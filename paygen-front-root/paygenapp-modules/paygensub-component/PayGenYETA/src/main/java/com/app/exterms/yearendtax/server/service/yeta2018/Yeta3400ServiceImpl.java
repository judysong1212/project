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
package com.app.exterms.yearendtax.server.service.yeta2018;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye161005BM;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye161005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye161010DTO;
import com.app.exterms.yearendtax.client.service.yeta2018.Yeta3400Service;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye161005_2018_DAO;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye161010_2018_DAO;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye17Ta2000_2018_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161005Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye161005_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010_2018_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("Yeta3400Service")
public class Yeta3400ServiceImpl  extends AbstractCustomServiceImpl implements Yeta3400Service  ,YetaDaoConstants {
 
	  private static final Logger logger = LoggerFactory.getLogger(Yeta3400ServiceImpl.class);
	  private static final String calledClass = Yeta3400ServiceImpl.class.getName();
	  
	// 원천세신고기준  
	@Autowired
	@Resource(name = "Ye161005_2018_DAO")
	private Ye161005_2018_DAO ye161005DAO;
	
	@Autowired
	@Resource(name = "Ye161010_2018_DAO")
	private Ye161010_2018_DAO ye161010DAO;
	
 
	@Autowired
	@Resource(name = "Ye161005_2018_DAO")
	private Ye161005_2018_DAO ye16Ta161005DAO;
	  
	//연말정산신고파일생성 조회
	public Ye161005BM getYeta3400List(Ye161005DTO ye161005Dto) throws MSFException {
	
		Ye161005Srh_2018_VO ye161005SrhVo = new Ye161005Srh_2018_VO();
		MSFSysm0100BM sessionUser;
		String method = calledClass + ".getYeta0400List";
		
		String windowNm = "연말정산신고파일생성";
		String windowId = "YETA3400";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye161005DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
					.getSession().getServletContext());
			ye161005DAO = (Ye161005_2018_DAO) wac.getBean("Ye161005_2018_DAO");
		}
				
		/** 조건절 */
//			ye161005SrhVo.setDpobCd(sessionUser.getDeptCd());/** column 사업장코드 : dpobCd */
		ye161005SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161005Dto.getSrhYrtxBlggYr()));/** column 연말정산귀속년도 : yrtxBlggYr */
		ye161005SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhClutSeptCd()));/** column 정산구분코드 : clutSeptCd */
			
	   	 List<String> listDeptCd = new ArrayList<String>(); 
	   	 ye161005SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	   	 ye161005SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	  	
	     ye161005SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDeptCd()));  //권한처리를위해 추가  
	     ye161005SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDtilOccuInttnCd()).replace(",", ""));   
	     
	   	 ye161005SrhVo.setUsrId(sessionUser.getUsrId());
	   	 /******************************** 권한 ************************************************************************/
	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	   	 	
	   	 if ("FALSE".equals(chkDeptCd)) {
	   		 
	   		if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(ye161005Dto.getSrhDeptCd(),sessionUser.getDeptCd()))) {

			   	 ye161005SrhVo.setDeptCd(sessionUser.getDeptCd()); 
			   	 listDeptCd.add(sessionUser.getDeptCd());
			     ye161005SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
			     
       	 } else {
       		 
       		   ye161005SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDeptCd()));
    	   	   listDeptCd = SmrmfUtils.getStrToArrayList(ye161005Dto.getSrhDeptCd());  
    	   	   ye161005SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
       	 }  
	   		
		     ye161005SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		        
	   	 } else {
	     	    
	   		ye161005SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhPayrMangDeptCd())) ;   //단위기관코드   
	   	 		
	   		if (ye161005SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDeptCd()))) { 
	   			listDeptCd = null; 
	   			ye161005SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	   	        ye161005SrhVo.setDeptCd("");  //부서코드
	   		} else {
	   			ye161005SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDeptCd()));
	   	       listDeptCd = SmrmfUtils.getStrToArrayList(ye161005Dto.getSrhDeptCd());  
	   	       ye161005SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        } 
	   	 }
	     
	   	 /******************************** 권한 ************************************************************************/
	   	 ye161005SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhEmymtDivCd()));      		//고용구분코드
//	    	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	    	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	   	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	         
	   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161005Dto.getSrhTypOccuCd())); 
	    ye161005SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	    ye161005SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	    	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDtilOccuInttnCd())); 
	    	ye161005SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	    	ye161005SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhDtilOccuInttnCd())); //직종세
	        
	      List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161005Dto.getSrhBusinCd())); 
	    	ye161005SrhVo.setBusinCdArr(lstBusinCd);   
	    	ye161005SrhVo.setBusinCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhBusinCd()));   //사업코드
	        
//	   	ye161005SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	   	
	   	ye161005SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
	   	
	   	ye161005SrhVo.setUtDpobCd(MSFSharedUtils.allowNulls(ye161005Dto.getSrhUtDpobCd()));				//원천신고부서
	  //??	ye161005SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161005Dto.getBusoprRgstnum()));	//사업자등록번호
	   	
	        
    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//     	 List<String> listTypCd = new ArrayList<String>(); 
//     	 
//     	sysIfBass0320Vo.setYmdGb("Y");
//     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//     	
//     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
     	//이전부서 가져오기 
     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
     	sysIfBass0350Vo.setYmdGb("Y");
     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(ye161005Dto.getYrtxBlggYr()));
     	sysIfBass0350Vo.setTypOccuCd(ye161005SrhVo.getTypOccuCd());
     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161005SrhVo.getDtilOccuInttnCd());
    	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
     	
     	try {
			sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
     	ye161005SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
     	ye161005SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
     	
     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/	
			

		//int iResultCnt = ye161005DAO.selectYeta2400ToYe161005ListTotCnt(ye161005SrhVo);
			 
		Ye161005BM returnYeta161005Bm = new Ye161005BM();
		List egovResultDataList = new ArrayList();

		try {
		
			egovResultDataList =  ye161005DAO.selectYeta3400ToYe161005List(ye161005SrhVo);

			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
							
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

					
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					

					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					while( keys.hasNext() ){
						String key = keys.next();
						//형 타입이 숫자형일경우 형변환 해준다.
						if(tempMap.get(key) instanceof java.math.BigDecimal){
							returnYeta161005Bm.set(key, String.valueOf(tempMap.get(key)));
						}else{
							
		            		if("resnRegnNum".equals(key)) {
		            			// 복호화
		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            			returnYeta161005Bm.set(key, rrnDecCrypt);
		            			
		            		}else if("resuNumb".equals(key)) {
		            			// 복호화
		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            			returnYeta161005Bm.set(key, rrnDecCrypt);
		            			
		            		}else {
		            			
		            			returnYeta161005Bm.set(key, tempMap.get(key));
		            		}
				    	}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S", ex, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnYeta161005Bm;
	}
	
	
	

	//전자신고기본정보 수정
	public Long updateYe161005(Ye161005DTO ye161005Dto) throws MSFException {
		
		Long result = new Long(0);

			Ye161005_2018_VO ye161005Vo = new Ye161005_2018_VO();
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".updateYe161005";
			
			String windowNm = "연말정산신고파일생성";
			String windowId = "YETA0400";
			
			Ye161005_2018_VO ye16Ta161005Vo = new Ye161005_2018_VO();

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(ye16Ta161005DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				ye16Ta161005DAO = (Ye161005_2018_DAO) wac.getBean("Ye161005_2018_DAO");
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
		
			ye16Ta161005Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    								/** column 사업장코드 : dpobCd */
			ye16Ta161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getWhdgTxRegrstDeptCd()));    		/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
			ye16Ta161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getHhrkWhdgRegrstDeptCd())); 		/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
			ye16Ta161005Vo.setTxOffcCd(MSFSharedUtils.allowNulls(ye161005Dto.getTxOffcCd()));    							/** column A3_세무서코드 : txOffcCd */
			ye16Ta161005Vo.setPentrSeptCd(MSFSharedUtils.allowNulls(ye161005Dto.getPentrSeptCd()));    					/** column A5_제출자구분 : pentrSeptCd */
			ye16Ta161005Vo.setTxDeptyMangeNum(MSFSharedUtils.allowNulls(ye161005Dto.getTxDeptyMangeNum()));    			/** column A6_세무대리인관리번호 : txDeptyMangeNum */
			ye16Ta161005Vo.setHmtxId(MSFSharedUtils.allowNulls(ye161005Dto.getHmtxId()));    								/** column A7_홈텍스ID : hmtxId */
			ye16Ta161005Vo.setTxPgmCd(MSFSharedUtils.allowNulls(ye161005Dto.getTxPgmCd()));    							/** column A8_세무프로그램코드 : txPgmCd */
			ye16Ta161005Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161005Dto.getBusoprRgstnum().replace("-", "")));    /** column A9_사업자등록번호 : busoprRgstnum */
			ye16Ta161005Vo.setCorpFmnmNm(MSFSharedUtils.allowNulls(ye161005Dto.getCorpFmnmNm()));    						/** column A10_법인_상호명 : corpFmnmNm */
			ye16Ta161005Vo.setPernChrgDeptNm(MSFSharedUtils.allowNulls(ye161005Dto.getPernChrgDeptNm()));    				/** column A11_담당자부서 : pernChrgDeptNm */
			ye16Ta161005Vo.setPernChrgNm(MSFSharedUtils.allowNulls(ye161005Dto.getPernChrgNm()));    						/** column A12_담당자성명 : pernChrgNm */
			ye16Ta161005Vo.setPernChrgPhnNum(MSFSharedUtils.allowNulls(ye161005Dto.getPernChrgPhnNum()));    				/** column A13_담당자전화번호 : pernChrgPhnNum */
			ye16Ta161005Vo.setUseHanCd(MSFSharedUtils.allowNulls(ye161005Dto.getUseHanCd()));    							/** column A15_사용한글코드 : useHanCd */
			ye16Ta161005Vo.setSumtTgtPridCd(MSFSharedUtils.allowNulls(ye161005Dto.getSumtTgtPridCd()));   	 				/** column B16_제출대상기간코드 : sumtTgtPridCd */
			ye16Ta161005Vo.setCorpNum(MSFSharedUtils.allowNulls(ye161005Dto.getCorpNum()).replace("-", ""));    			/** column 법인번호 : corpNum */
			ye16Ta161005Vo.setIncmPost(MSFSharedUtils.allowNulls(ye161005Dto.getIncmPost()));    							/** column 소득신고의무자우편번호 : incmPost */
			ye16Ta161005Vo.setIncmAddr(MSFSharedUtils.allowNulls(ye161005Dto.getIncmAddr()));   	 						/** column 소득신고의무자기본주소 : incmAddr */
			ye16Ta161005Vo.setIncmAdtl(MSFSharedUtils.allowNulls(ye161005Dto.getIncmAdtl()));    							/** column 소득신고의무자상세주소 : incmAdtl */
			ye16Ta161005Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
//			ye16Ta161005Vo.setInptDt(ye161005Dto.getInptDt());    /** column 입력일자 : inptDt */
			ye16Ta161005Vo.setInptAddr(ye161005Dto.getInptAddr());    														/** column 입력주소 : inptAddr */
			ye16Ta161005Vo.setIsmt(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정자 : ismt */
//			ye16Ta161005Vo.setRevnDt(ye161005Dto.getRevnDt());    /** column 수정일자 : revnDt */
			ye16Ta161005Vo.setRevnAddr(ye161005Dto.getRevnAddr());    														/** column 수정주소 : revnAddr */
			ye16Ta161005Vo.setReprName(MSFSharedUtils.allowNulls(ye161005Dto.getReprName()));    							/** column 대표자성명 : reprName */
			ye16Ta161005Vo.setResuNumb(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(
		    ye161005Dto.getResuNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    							        /** column 주민등록번호 : resuNumb */
			ye16Ta161005Vo.setYrtxBlggYr(ye161005Dto.getYrtxBlggYr());
			ye16Ta161005Vo.setClutSeptCd(ye161005Dto.getClutSeptCd());
			ye16Ta161005Vo.setYetaC171(MSFSharedUtils.convertBooleanToVal(ye161005Dto.getYetaC171()));                                                        //C171_사업자단위과세자여부
			ye16Ta161005Vo.setYetaC172(ye161005Dto.getYetaC172());                                                         //C172_종사업장일련번호
		 
			
		  	try{
		  		ye16Ta161005DAO.updateYeta3400ToYe161005(ye16Ta161005Vo); 
		  		result = new Long(1);

			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
				
			}
		  	
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");

			return result;
		}
	
	
	
	//연말정산신고내역 조회
	public PagingLoadResult<BaseModel> getYeta34000List(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2400LIST;
		Ye161010Srh_2018_VO ye161010SrhVo = new Ye161010Srh_2018_VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye161010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161010DAO = (Ye161010_2018_DAO) wac.getBean("Ye161010_2018_DAO" ); 
		}
	        
		try {
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
	    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	    	//Get query parameters
	      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	
	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	ye161010SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));//정산구분
	    	ye161010SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	

            ye161010SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            ye161010SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
	    	ye161010SrhVo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	 if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

                	ye161010SrhVo.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
                    
            	 } else {
           		 
           		   ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                   listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                   ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드     
           	     }  
            	
               ye161010SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (ye161010SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	ye161010SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
            ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	ye161010SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	ye161010SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	ye161010SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
	      	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); 
	      	ye161010SrhVo.setBusinCdArr(lstBusinCd);  
	      	ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); //사업코드
	      	
//	      	ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr"))); //년도
	      	ye161010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	ye161010SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		 
	      	ye161010SrhVo.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"))); 			//원천신고부서  
	        ye161010SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "busoprRgstnum")));	//사업자등록번호
	      	        
	    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//	     	 List<String> listTypCd = new ArrayList<String>(); 
//	     	 
//	     	sysIfBass0320Vo.setYmdGb("Y");
//	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//	     	
//	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
	     	
	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	     	sysIfBass0350Vo.setYmdGb("Y");
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));
	     	sysIfBass0350Vo.setTypOccuCd(ye161010SrhVo.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161010SrhVo.getDtilOccuInttnCd());
	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
	     
	     	ye161010SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	     	ye161010SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	      	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161010DAO.selectYeta3400GirdListTotCnt(ye161010SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161010SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161010SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161010SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161010DAO.selectYeta3400GirdList(ye161010SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
				
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
	        	BaseModel bm = new BaseModel();
	 
	       	//bm.setProperties(map);
	     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
	     		Object mapCon = map.get(tableAttributes[i].getName());  
	                     
	     		switch ( tableAttributes[i].getType() ) {  
	          		case ColumnDef.TYPE_DATE: 
	          		case ColumnDef.TYPE_DATETIME: 
	                       
	             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
	            	map.put(tableAttributes[i].getName(), value);
	                     
	            	break; 
	            	
	            	//3. 복호화
	          		case ColumnDef.TYPE_STRING: 
	          		          			          			
	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

	          			String rrnDecCrypt = "";
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          		          			
	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;
	          							
	          			}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;

	          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;

	          	        }
	          				
	          		map.put(tableAttributes[i].getName(), strValue);
	          			                    
	          		break;
	                       
	          		case ColumnDef.TYPE_LONG:   
	                     
	          			if (mapCon != null) {  
	          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
	                        map.put(tableAttributes[i].getName(), lValue); 
	                    }  
	                       
	                     break;
	                     
	          		case ColumnDef.TYPE_DOUBLE:  
	          			
	                      if (mapCon != null) {      
	                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
	                         map.put(tableAttributes[i].getName(), dbValue); 
	                      }  
	                       
	                   	break;
	     		}
	     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
	     			Object baseModelValue = null;
	            	//콤보박스처리를 위해 추가함
	     			if (tableAttributes[i].getName().contains("$")) {
	     				
	     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
	                              
	     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
	                         
	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
	     			} else {
	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
	     			}
	     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                    
	                    bm.set(tableAttributes[i].getName(), baseModelValue);
	     	}

	     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	     	bmResult.add(bm);
		} 

			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0400List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	//연말정산신고파일 마감/풀기
	public Long finishOnYe161005(Ye161010DTO ye17Ta1010Dto) throws MSFException {
		
		Long result = new Long(0);
		String method = calledClass + ".finishOnYe161005";
		
		String windowNm = "연말정산신고파일생성";
		String windowId = "YETA3400";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

			Ye161010_2018_VO ye161010Vo = new Ye161010_2018_VO();
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(ye161010DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				ye161010DAO = (Ye161010_2018_DAO) wac.getBean("Ye161010_2018_DAO");
			}
					

//			ye161005Vo.setDpobCd(ye161005Dto.getDpobCd());
//			ye161005Vo.setYrtxBlggYr(ye161005Dto.getYrtxBlggYr());
//			ye161005Vo.setClutSeptCd(ye161005Dto.getClutSeptCd());
//			ye161005Vo.setEdacSeilNum(new BigDecimal(ye161005Dto.getEdacSeilNum()));
//			
//			ye161005Vo.setClosFlag(ye161005Dto.getClosFlag());
//			ye161005Vo.setClosDate(ye161005Dto.getEdacPrdt());
			
			
//			ye161005Vo.setDpobCd(ye161005Bm.getDpobCd());
//			ye161005Vo.setYrtxBlggYr(ye161005Bm.getYrtxBlggYr());
//			ye161005Vo.setClutSeptCd(ye161005Bm.getClutSeptCd());
//			ye161005Vo.setEdacSeilNum(new BigDecimal(ye161005Bm.getEdacSeilNum()));
//			
//			ye161005Vo.setClosFlag(ye161005Bm.getClosFlag());
//			ye161005Vo.setClosDate(ye161005Bm.getEdacPrdt());
//			
//			ye161005Vo.setIsmt(sessionUser.getUsrId());
//			ye161005Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			
			List<String> listDeptCd = new ArrayList<String>(); 
			
	      	/** 조건절 */
			ye161010Vo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getClutSeptCd()));//정산구분
			ye161010Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	

			ye161010Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
			ye161010Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDtilOccuInttnCd()).replace(",", ""));   
            
			ye161010Vo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
              if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(ye17Ta1010Dto.getDeptCd(),sessionUser.getDeptCd()))) {

                  	ye161010Vo.setDeptCd(sessionUser.getDeptCd()); 
                     listDeptCd.add(sessionUser.getDeptCd());
                     ye161010Vo.setDeptCdArr(listDeptCd);     //부서코드    
                     
              } else {
                      	 ye161010Vo.setDeptCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDeptCd()));
                 	     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDeptCd()));  
         	             ye161010Vo.setDeptCdArr(listDeptCd);     //부서코드  
              		 
              }  
            	  
               ye161010Vo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	 	ye161010Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getPayrMangDeptCd())) ;   //단위기관코드   
            	       if (ye161010Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDeptCd()))) { 
            	      	 listDeptCd = null; 
            	        	ye161010Vo.setDeptCdArr(listDeptCd);     //부서코드 
            	        	ye161010Vo.setDeptCd("");  //부서코드
            	       } else {
            	     	 ye161010Vo.setDeptCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDeptCd()));
                    	            listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDeptCd()));  
            	          ye161010Vo.setDeptCdArr(listDeptCd);     //부서코드   
            	     } 
            }
            
//            } else {
//            	
//            }
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
             ye161010Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getEmymtDivCd()));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
           	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getTypOccuCd())); 
           	ye161010Vo.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010Vo.setTypOccuCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getTypOccuCd()));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	ye161010SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	ye161010SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
          	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDtilOccuInttnCd())); 
          	ye161010Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
          	ye161010Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getDtilOccuInttnCd())); //직종세
	             
          	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(ye17Ta1010Dto.getBusinCd()); 
          	ye161010Vo.setBusinCdArr(lstBusinCd);  
          	ye161010Vo.setBusinCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getBusinCd())); //사업코드
	      	
//	      	ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getYrtxBlggYr())); //년도
//	      	ye161005Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161005Bm.getSystemkey()));  //시스템키
//	      	ye161005Vo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	ye161010Vo.setUtDpobCd(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getUtDpobCd()));				//원천신고부서
	      	//ye161010Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getBusoprRgstnum()));	//사업자등록번호
	      	        
	    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//	     	 List<String> listTypCd = new ArrayList<String>(); 
//	     	 
//	     	sysIfBass0320Vo.setYmdGb("Y");
//	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//	     	
//	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
	     	
	      	//이전부서 가져오기 
	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	     	sysIfBass0350Vo.setYmdGb("Y");
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(ye17Ta1010Dto.getYrtxBlggYr()));
	     	sysIfBass0350Vo.setTypOccuCd(ye161010Vo.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(ye161010Vo.getDtilOccuInttnCd());
	    	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	try {
				sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     
	     	ye161010Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	     	ye161010Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
			
	     	ye161010Vo.setClosFlag(ye17Ta1010Dto.getClosFlag());
	     	ye161010Vo.setClosDate(ye17Ta1010Dto.getClosDate());
			
	     	ye161010Vo.setIsmt(sessionUser.getUsrId());
	     	ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
		  	try{
		  		
		  		List<EgovMap> egovResultDataList = ye161010DAO.selectFinYe161010List(ye161010Vo);
		  		
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						
						EgovMap tempMap = (EgovMap)egovResultDataList.get(i);
						//마감처리
						ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));
						ye161010DAO.finishYeta3400Update(ye161010Vo);
        		  		result = new Long(1);
						
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			}
		  	
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

			return result;
		}

	  
}
