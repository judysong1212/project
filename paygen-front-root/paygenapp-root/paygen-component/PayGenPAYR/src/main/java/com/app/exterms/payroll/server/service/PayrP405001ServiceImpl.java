/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.payroll.server.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.service.PayrP405001Service;
import com.app.exterms.payroll.server.service.dao.Payr0250DAO;
import com.app.exterms.payroll.server.vo.Payr0250SrhVO;
import com.app.exterms.payroll.server.vo.Payr0250VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("PayrP405001Service")
public class PayrP405001ServiceImpl extends AbstractCustomServiceImpl implements PayrDaoConstants, PayrP405001Service {
	
	private static final Logger logger = LoggerFactory.getLogger(PayrP405001ServiceImpl.class);
	private static final String calledClass = PayrP405001ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Payr0250DAO")
	private Payr0250DAO payr0250DAO;

	
	/** 급여스케줄 일괄생성 **/
	@Override
	public PagingLoadResult<ShowMessageBM> createSchedulePayrP405001(Payr0250DTO payr0250Dto)throws MSFException {
		
		Payr0250VO    	payr0250Vo		= new Payr0250VO();
		Payr0250SrhVO 	payr0250SrhVo  	= new Payr0250SrhVO();
		Payr0250VO 		tpPayr0250Vo 	= new Payr0250VO(); 
		Calendar cal = Calendar.getInstance();
		// 메시지 처리를 위한
		List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		
		
		Boolean dateCk1 = false;
		Boolean dateCk2 = false;
		int coCalendarCnt = 0;
		int iRnt = 0;
		
		
		String strYr = "";
		String strMnth = "";

		String strYtMnth_E = payr0250Dto.getJobYr_E() + payr0250Dto.getJobMnth_E();
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".createSchedulePayrP405001";
		
//    	int result = 0;
    	PagingLoadResult<ShowMessageBM> retval = null; 

    	String windowNm = "스케줄일괄생성";
		String windowId = "PAYRP405001";
		
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
    	
		try{
			
			payr0250SrhVo = new Payr0250SrhVO();
			
			
			// --- 개월수 차이를 구함 
			int sYear= Integer.parseInt(payr0250Dto.getJobYr_S()); 
			int sMonth = Integer.parseInt(payr0250Dto.getJobMnth_S()); 

			int eYear = Integer.parseInt(payr0250Dto.getJobYr_E()); 
			int eMonth = Integer.parseInt(payr0250Dto.getJobMnth_E()); 

			int month_diff = (eYear - sYear)* 12 + (eMonth - sMonth);	// 개월수 차이
			
			// TODO 수정 필요
			
			if(month_diff == 0) {
				// 기간을 당월만 선택하면 개월수가 0으로 나오기 때문에 0일 경우 무조건 1 개월 데이터를 일단 줌..
				month_diff = 1;
			}else {
				// 기간 설정 시 개월수 1이 빠짐.
				month_diff = month_diff + 1;
			}
			// -- 개월수 차이를 구함
			
			String strDate = payr0250Dto.getJobYr_S() + payr0250Dto.getJobMnth_S();
			
			String strEmymtDivNm = "";
			
			if(MSFConfiguration.EMYMT_DIVCD01.endsWith(payr0250Dto.getEmymtDivCd()) ) {
				strEmymtDivNm = "공무직";
			}else if(MSFConfiguration.EMYMT_DIVCD02.endsWith(payr0250Dto.getEmymtDivCd())) {
				strEmymtDivNm = "기간제근로자";
			}else {
				
			}
			
			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여스케줄생성]처리시작",strEmymtDivNm,"")); 
			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여스케줄생성]" + String.valueOf(month_diff) + "건 처리 시작",strEmymtDivNm,""));  
			
			
			
	    	// 선택한 일자가 말일 일 경우 매달 말일로 일자를 넣어준다.
			payr0250SrhVo  	= new Payr0250SrhVO();
			payr0250SrhVo.setJobYrMnth(strDate);
			
			coCalendarCnt = payr0250DAO.selectCoCalendarCnt(payr0250SrhVo);
			if(MSFSharedUtils.allowNulls(payr0250Dto.getPymtDt()).equals(String.valueOf(coCalendarCnt))) {
				dateCk1 = true;
			}
			
			if(MSFSharedUtils.allowNulls(payr0250Dto.getRflctnEndDt()).equals(String.valueOf(coCalendarCnt))) {
				dateCk2 = true;
			}
			
			for(int i = 1; i <= month_diff; i++ ) {
				
				// --- 반영 시작 일자 및 종료일자 값 구하기 
				int maxDays = 0;
					   
				Calendar intiCal = Calendar.getInstance();
				intiCal.set(Integer.parseInt(strDate.substring(0,4)), Integer.parseInt(strDate.substring(4,6)) - 1, 1);
//				payr0250Dto.setRflctnBgnnDt(GWTUtils.getStringFromDate(intiCal.getTime(), "yyyyMMdd"));/** column 반영시작일자 : rflctnBgnnDt */
//				payr0250Dto.setRflctnBgnnDt(MSFServerUtils.getStringFromDate(intiCal.getTime(), "yyyyMMdd"));/** column 반영시작일자 : rflctnBgnnDt */
				maxDays = intiCal.getActualMaximum(intiCal.DAY_OF_MONTH);
				String dayE =  String.valueOf(maxDays);
				
					
//				intiCal = Calendar.getInstance();
//				intiCal.set(Integer.parseInt(strDate.substring(0,4)), Integer.parseInt(strDate.substring(4,6)) - 1, maxDays);
				// intiCal.add(Calendar.DATE, maxDays - 1);

//				payr0250Dto.setRflctnEndDt(GWTUtils.getStringFromDate(intiCal.getTime(), "yyyyMMdd"));			/** column 반영종료일자 : rflctnEndDt */
//				payr0250Dto.setRflctnEndDt(MSFServerUtils.getStringFromDate(intiCal.getTime(), "yyyyMMdd"));	/** column 반영종료일자 : rflctnEndDt */
				 // --- 반영 시작 일자 및 종료일자 값 구하기
				
				
        		payr0250Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    										/** column 사업장코드 : dpobCd */
        		payr0250Vo.setJobYrMnth(MSFSharedUtils.allowNulls(strDate));    													/** column 작업년월 : jobYrMnth */
//        		System.out.println("==================작업년월 : " + strDate );
        		payr0250Vo.setPayCd(MSFSharedUtils.allowNulls(payr0250Dto.getPayCd()));    											/** column 급여구분코드 : payCd */
        		payr0250Vo.setPayScduSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0250Dto.getPayScduSeilNum(), "0")));   	/** column 급여스케줄일련번호 : payScduSeilNum */
        		payr0250Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0250Dto.getPayrMangDeptCd()));    						/** column 급여관리부서코드 : payrMangDeptCd */
        		payr0250Vo.setDeptCd(MSFSharedUtils.allowNulls(payr0250Dto.getDeptCd()));    										/** column 부서코드 : deptCd */
        		payr0250Vo.setBusinCd(MSFSharedUtils.allowNulls(payr0250Dto.getBusinCd()));    										/** column 사업코드 : businCd */
        		payr0250Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0250Dto.getEmymtDivCd()));    								/** column 고용구분코드 : emymtDivCd */
        		payr0250Vo.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    							/** column 담당직원번호 : pernChrgEmpIdenNum */
        		payr0250Vo.setJobNm(MSFSharedUtils.allowNulls(payr0250Dto.getPayCd()));    											/** column 작업명 : jobNm */
        		
//        		payr0250Vo.setPymtDt(MSFSharedUtils.allowNulls(strDate + payr0250Dto.getPymtDt().substring(6, 8)));    				/** column 지급일자 : pymtDt */
        	
        		// 선택한 일자가 말일 일 경우 매달 말일로 일자를 넣어준다.
        		payr0250SrhVo  	= new Payr0250SrhVO();
        		payr0250SrhVo.setJobYrMnth(strDate);
        	
        		if(dateCk1) {
        			payr0250Vo.setPymtDt(MSFSharedUtils.allowNulls(strDate + dayE));												/** column 지급일자 : pymtDt */
        		}else {
        			payr0250Vo.setPymtDt(MSFSharedUtils.allowNulls(strDate + payr0250Dto.getPymtDt())); 							/** column 지급일자 : pymtDt */
        		}
        		
        		payr0250Vo.setRflctnBgnnDt(MSFSharedUtils.allowNulls(strDate + payr0250Dto.getRflctnBgnnDt()));    					/** column 반영시작일자 : rflctnBgnnDt */
//        		payr0250Vo.setRflctnEndDt(MSFSharedUtils.allowNulls(strDate + dayE));   	 			/** column 반영종료일자 : rflctnEndDt */
        		
        		// 선택한 반영종료일자가 해당월의 말일 일 경우 매달 말일로. 아닐 경우 그냥 선택한 날짜로
        		if(dateCk2) {
        			payr0250Vo.setRflctnEndDt(MSFSharedUtils.allowNulls(strDate + dayE));											/** column 반영종료일자 : rflctnEndDt */
        		}else {
        			payr0250Vo.setRflctnEndDt(MSFSharedUtils.allowNulls(strDate + payr0250Dto.getRflctnEndDt())); 					/** column 반영종료일자 : rflctnEndDt */
        		}
        		
        		
//        		payr0250Vo.setPayDdlneDt(MSFSharedUtils.allowNulls(	strDate + payr0250Dto.getPayDdlneDt().substring(7, 9)));    /** column 급여마감일자 : payDdlneDt */
//        		payr0250Vo.setGroFlCretnDt(MSFSharedUtils.allowNulls(egovMap.get("groFlCretnDt")));    /** column 지로파일생성일자 : groFlCretnDt */
        		
        		payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(payr0250Dto.getTypOccuCd()));    									/** column 직종코드 : typOccuCd */
        		payr0250Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0250Dto.getDtilOccuInttnCd()))	;						/** column null : dtilOccuInttnCd */
        		
//        		payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(egovMap.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//        		payr0250Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(egovMap.get("dtilOccuClsDivCd")));    /** column null : dtilOccuClsDivCd */
        		
        		payr0250Vo.setDeptGpCd(MSFSharedUtils.allowNulls(payr0250Dto.getDeptGpCd()));    									/** column 부서직종세그룹코드 : deptGpCd */
        		payr0250Vo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(payr0250Dto.getRepbtyBusinDivCd()));    					/** column 호봉제구분코드 : repbtyBusinDivCd */
        		payr0250Vo.setMangeDeptCd(MSFSharedUtils.allowNulls(payr0250Dto.getMangeDeptCd()));    								/** column 인사관리부서코드 : mangeDeptCd */
        		
        		
        		payr0250Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    											/** column 입력자 : kybdr */
        		payr0250Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  		/** column 입력주소 : inptAddr */
        		payr0250Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    											/** column 수정자 : ismt */
        		payr0250Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    	/** column 수정주소 : revnAddr */
        		payr0250Vo.setOverYn(payr0250Dto.getOverYn());

//        		int mn = 1;
//				cal = Calendar.getInstance();
//				cal.setTime(SmrmfUtils.getDateFromString(strDate, "yyyymm"));
//				cal.add(Calendar.MONTH, mn); // 한달을 더한다.
//				System.out.println("==================작업 년월 더함 cal: " + cal.getTime());
//				SimpleDateFormat fm = new SimpleDateFormat("yyyymm");
//				strDate = fm.format(cal.getTime());
//				System.out.println("==================작업 년월 더함 : " + strDate);
//				CalendarUtil.addMonthsToDate(cal.getTime(), mn);
//				
//				cal.setTime(SmrmfUtils.getDateFromString(payr0250Vo.getJobYrMnth() + payr0250Dto.getPymtDt(), "yyyyMMdd"));
//				cal.add(Calendar.MONTH, 1); // 한달을 더한다.
//				fm = new SimpleDateFormat("yyyyMMdd");
        		
        		
        		SimpleDateFormat fm = new SimpleDateFormat("yyyyMM");
        		
        		cal = Calendar.getInstance();
//				cal.setTime(SmrmfUtils.getDateFromString(strDate, "yyyyMM"));
        		cal.setTime(fm.parse(strDate));
        		 
				cal.add(Calendar.MONTH, 1);	// 한달을 더한다.
				strDate = fm.format(cal.getTime());
 		
				
				boolean flag = false;
			    String errMsg = "";
				
//                tpPayr0250Vo = payr0250DAO.selectPayr0250(payr0250Vo);
//                
//                if (tpPayr0250Vo == null) { 
 				if(MSFConfiguration.EMYMT_DIVCD01.endsWith(payr0250Dto.getEmymtDivCd()) ) {
                      /** 
                       * 인서트 시 기존에 생성된 데이터가 존재하는지 여부 확인하여 존재하면 저장안하고 메시지 띄움.
                       */
//					  payr0250Vo.setSrhFlag("Y");
                	  List chkPayr0250List = payr0250DAO.selectPayr0250CheckList(payr0250Vo);
                	  if(chkPayr0250List.size() > 0){
          				for (int j = 0; j < chkPayr0250List.size(); j++) {
        					
          					EgovMap eMap = (EgovMap) chkPayr0250List.get(j);
          					
          					String deptCdStr = (String) eMap.get("deptCd");
          					String typOccuCdStr = (String) eMap.get("typOccuCd");
          					String dtilOccuInttnCdStr = (String) eMap.get("dtilOccuInttnCd");
          					
        					String businCd = MSFSharedUtils.allowNulls( (String) eMap.get("businCd") );
        					
        					if(businCd == null || "".equals(businCd)) {
        						
              					// 1. 부서 + 직종 + 직종세
              					if(MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) 
              							&&	MSFSharedUtils.paramNotNull(payr0250Dto.getTypOccuCd()) 
              							&& MSFSharedUtils.paramNotNull(payr0250Dto.getDtilOccuInttnCd()) ) {

              						// a. 부서코드가 등록된 경우
              						if(MSFSharedUtils.allowNulls(typOccuCdStr).equals("") || MSFSharedUtils.allowNulls(typOccuCdStr) == null){
              							flag = true;
              							errMsg = "등록된 직종세 스케줄이 존재합니다. 부서 데이터를 등록하시려면 기등록된 직종세 스케줄을 삭제 후 등록하십시요.";
              							break;
              						}else{
              							if(payr0250Dto.getTypOccuCd().equals(typOccuCdStr)){
              								// b. 직종코드가 등록된 경우
              								if( MSFSharedUtils.allowNulls(dtilOccuInttnCdStr)== null || MSFSharedUtils.allowNulls(dtilOccuInttnCdStr).equals("")){
              									flag = true;
                      							errMsg = "등록된 직종세 스케줄이 존재합니다. 직종 데이터를 등록하시려면 기등록된 직종세 스케줄을 삭제 후 등록하십시요.";
                      							break;
              								}else{
              									// c.직종세코드가 등록된 경우 	
              									if(payr0250Dto.getDtilOccuInttnCd().equals(dtilOccuInttnCdStr)){
              										flag = true;
                          							errMsg = "등록된 직종세 스케줄이 존재합니다. 직종세 데이터를 등록하시려면 기등록된 직종세 스케줄을 삭제 후 등록하십시요.";
                          							break;
              									}
              								}
              							}  
              						}
              					}
              				    // 2. 부서 + 직종
              					else if(MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) 
              							&&	MSFSharedUtils.paramNotNull(payr0250Dto.getTypOccuCd()) ) {
              						
              						// a.부서코드가 등록된 경우
              						if(MSFSharedUtils.allowNulls(typOccuCdStr).equals("") || MSFSharedUtils.allowNulls(typOccuCdStr) == null){
              							flag = true;
              							errMsg = "등록된 직종 스케줄이 존재합니다. 부서 데이터를 등록하시려면 기등록된 직종 스케줄을 삭제 후 등록하십시요.";
              							break;
              						}else{
              							if(payr0250Dto.getTypOccuCd().equals(typOccuCdStr)){
              							// b. 직종이 등록된 경우 
                  							if( MSFSharedUtils.allowNulls(dtilOccuInttnCdStr) == null || MSFSharedUtils.allowNulls(dtilOccuInttnCdStr).equals("")){
              									flag = true;
                      							errMsg = "등록된 직종 스케줄이 존재합니다. 직종 데이터를 등록하시려면 기등록된 직종 스케줄을 삭제 후 등록하십시요.";
                      							break;
                      							// c. 직종세 등록된 경우 
              								}else {
              									flag = true;
                      							errMsg = "등록된 직종 스케줄이 존재합니다. 직종 하위 데이터를 등록하시려면 기등록된 직종 스케줄을 삭제 후 등록하십시요.";
                      							break;
              								}
              							}
              						}
              						
              					}
              					
              					// 3. 부서
              					else if(MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) ) {
              						
//              						if(payr0250Dto.getDeptCd().equals(deptCdStr) || payr0250Dto.getDeptCd() == deptCdStr){
              						
              						// a.부서코드가 등록된 경우
              						if(MSFSharedUtils.allowNulls(typOccuCdStr).equals("") || MSFSharedUtils.allowNulls(typOccuCdStr) == null){
              							flag = true;
              							errMsg = "등록된 부서 스케줄이 존재합니다. 부서 데이터를 등록하시려면 기등록된 부서 스케줄을 삭제 후 등록하십시요.";
              							break;
              						}else {
              						// b.직종/직종세 등록된 경우
              							flag = true;
              							errMsg = "입력하려는 부서에는 하위 직종/직종세 데이터가 존재합니다. 직종/직종세까지 선택하신 후 등록  하십시요.";
              							break;
              						}
              					}
        					}
          				}
                	  }else{
                	  //insert
                	  }
                	  
 				}else if(MSFConfiguration.EMYMT_DIVCD02.endsWith(payr0250Dto.getEmymtDivCd())){
 					
 					List chkPayr0250List = payr0250DAO.selectPayr0250CheckList(payr0250Vo);
 					if(chkPayr0250List.size() > 0){
 						flag = true;
 						errMsg = "등록된 사업 스케줄이 존재합니다. 사업 데이터를 등록하시려면 기 등록된 사업 스케줄을 삭제 후 등록하십시요.";
 					}
  					
  				}
 				
 				
          	  if(flag){
        		  bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[" + strEmymtDivNm+ "]" ,"생성오류","생성년월 : " + payr0250Vo.getJobYrMnth() + "월  " + errMsg));
        	  }else{
        		  payr0250DAO.insertPayr0250FromPayrP405001(payr0250Vo);
//                result = result + 1;
                
        		  bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[" + strEmymtDivNm+ "]" ,"생성완료","생성년월 : " + payr0250Vo.getJobYrMnth() + "월 처리완료 "));
        		  
        	  }
          	  
          	  iRnt = iRnt + 1;
                	  
			}
			
			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여스케줄생성]" + String.valueOf(iRnt) + "건 처리 완료",strEmymtDivNm,""));  
			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
			
		}catch(Exception e){
			
           e.printStackTrace();   
    	   ShowMessageBM smBm = new ShowMessageBM();
    	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
    	   smBm.setMenu("Payr");
    	   smBm.setPhase("[급여스케줄생성]에러");
    	   smBm.setMessage(e.getLocalizedMessage());
    	   smBm.setContent(e.getMessage());
    	   bmResult.add(smBm);  
    	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U:C",e, windowNm , windowId);
			
		}		
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		
		return retval;
	}

	
	@Override
	public List<BaseModel> selectCoCalendar(Payr0250DTO payr0250Dto) throws MSFException {
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectCoCalendar";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String srhDpobCd = sessionUser.getDpobCd();
		
		String windowNm = "스케줄일괄생성";
		String windowId = "PAYRP4050001";
		
		try{
			Payr0250SrhVO payr0250SrhVo = new Payr0250SrhVO();
			payr0250SrhVo.setJobYrMnth(payr0250Dto.getJobYrMnth());
//			Payr0250DTO Dto = new Payr0250DTO();
			
			egovResultDataList = payr0250DAO.selectCoCalendar(payr0250SrhVo);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		return returnValue;
		
	}
	
	
	
	
	
	
	
  
}
