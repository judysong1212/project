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
package com.app.exterms.diligence.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.service.DlgnP010001Service;
import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.exterms.dlgn.server.utils.DiligenceCommonConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.pkg.listener.DlgnListenerAdapter;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("DlgnP010001Service")
public class DlgnP010001ServiceImpl extends AbstractCustomServiceImpl implements DiligenceDaoConstants, DlgnP010001Service {
	
	private static final Logger logger = LoggerFactory.getLogger(DlgnP010001ServiceImpl.class);
	private static final String calledClass = DlgnP010001ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "dlgn0100DAO")
	private Dlgn0100DAO dlgn0100DAO;
	
	@Autowired
	@Resource(name = "dlgn0200DAO")
	private Dlgn0200DAO dlgn0200DAO;

	
	/** 기본 및 시간외근무 근태 생성 **/
	@Override
	public PagingLoadResult<ShowMessageBM> generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto) throws MSFException {
		String detailYmKubn = DiligenceCommonConstants.YANGPYEONG_DLGN_DT_BUNGI;
//		String detailYmKubn = "201703"; //복무관리 기준일
		
		int cnt = 0;
		
		PagingLoadResult<ShowMessageBM> retval = null;
		List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	        
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Dlgn0100VO      dlgn0100Vo		= new Dlgn0100VO();
		Dlgn0100SrhVO  dlgn0100SrhVo  	= new Dlgn0100SrhVO();
		
		Dlgn0200VO      dlgn0200Vo		= new Dlgn0200VO();
		Dlgn0200SrhVO  dlgn0200SrhVo  	= new Dlgn0200SrhVO();
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
    	
		try{

			
		    /** ++++++++++++++++++++++++++++++++++ 기본근무 생성 +++++++++++++++++++++++++++++++++++++**/
			/** 조건절 */
			dlgn0100Dto.setDpobCd(sessionUser.getDpobCd()); 
			dlgn0100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
			dlgn0100Dto.setUsrId(sessionUser.getUsrId());  
			
		 	List<String> listDeptCd = new ArrayList<String>();
			
			dlgn0100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가
			dlgn0100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd()).replace(",", ""));
	         
			dlgn0100Dto.setSystemkey(MSFSharedUtils.allowNulls(dlgn0100Dto.getSystemkey()));
	        
	        // 시스템 키가 없을 경우 일괄처리(lump), 있으면 일괄처리(individ)
	        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
	        if("".equals(dlgn0100Dto.getSystemkey())  || dlgn0100Dto.getSystemkey() == null) {
	        	dlgn0100Dto.setCreateFlag("lump");		//일괄
	        }else {
	        	dlgn0100Dto.setCreateFlag("individ");	//개별
	        }
	        
	        dlgn0100Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getMangeDeptCd()));			// 관리부서
			/******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	dlgn0100Dto.setDeptCd(sessionUser.getDeptCd()); 
            	listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0100Dto.getDeptCd());  
            	dlgn0100Dto.setDeptCdArr(listDeptCd);     //부서코드  
            	dlgn0100Dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	
            	if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCd())) 
            			|| MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCd()).contains(dlgn0100Dto.getPayrMangDeptCd())
            			) {
            		dlgn0100Dto.setDeptCdArr(null);     //부서코드 
            		dlgn0100Dto.setDeptCd("");  //부서코드
            	} else {
            		listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0100Dto.getDeptCd());  
            		dlgn0100Dto.setDeptCdArr(listDeptCd);     //부서코드 
            	}
	          
            }
            
//            /**
//	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
//	         */
//            if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth())) 
//        			|| MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth()).contains(dlgn0100Dto.getPayrMangDeptCd())
//        			) {
//            	dlgn0100Dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//              	 
//        	}  
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd())); 
            dlgn0100Dto.setTypOccuCdArr(lstTypeOccuCd); 
            dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd()));  //직종
            
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); 
            dlgn0100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            dlgn0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); //직종세 
            
			dlgn0100Dto.setIsmt(sessionUser.getUsrId());
			dlgn0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			dlgn0100Dto.setTypOccuBusinVal(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuBusinVal()) );	// 복무통합구분값
            /******************************** 권한 ************************************************************************/
		
			  //삭제 인서트 처리를 위한 조건으로 가지고 와서 인서트 처리 할것....로직  
            /**
             * 대상자 가져오기 
             */
//			
//			// 2.복호화 리턴받을 값 선언
 			String rrnDecCrypt = "";
            List list =   dlgn0100DAO.selectDlgn0100ToRtnData(dlgn0100Dto); 
            
            Iterator<Map<String, Object>> iter = list.iterator();
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
            
                
                dlgn0100Dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
                dlgn0100Dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
                dlgn0100Dto.setDilnlazYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazYrMnth")))); //   DILNLAZ_YR_MNTH
                dlgn0100Dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
                dlgn0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
                dlgn0100Dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
                dlgn0100Dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
                dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
                dlgn0100Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
                dlgn0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
                dlgn0100Dto.setDilnlazDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
                dlgn0100Dto.setDilnlazDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
                dlgn0100Dto.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyNumDys"))));   // DILNLAZ_DUTY_NUM_DYS
                dlgn0100Dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN
                dlgn0100Dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazWklyHldyNumDys")))); // DILNLAZ_WKLY_HLDY_NUM_DYS
                dlgn0100Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
                dlgn0100Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
                dlgn0100Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
                dlgn0100Dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
                dlgn0100Dto.setTypOccuBusinVal(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuBusinVal"))));    /** set 복무통합구분값 : typOccuBusinVal */
                
//				dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
//				dlgn0100DAO.deleteDlgn0100(dlgn0100Dto); 
//				
//				dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
				
//				if((detailYmKubn.compareTo(dlgn0100Dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
//					
//					dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
//					dlgn0100DAO.deleteDlgn0100(dlgn0100Dto); 
//					
//					dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
//					dlgn0100DAO.insertDlgn0110Pre(dlgn0100Dto);
//					
//				}else{
					
                
                // 무기계약직 이면서 직종, 직종세 없을 경우 복무 로직 skip 처리
		        if( "A0020010".equals(dlgn0100Dto.getEmymtDivCd()) && ( "".equals(dlgn0100Dto.getTypOccuCd()) || "".equals(dlgn0100Dto.getDtilOccuInttnCd())) ) {
		        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","기본복무관리" ,"생성오류","대상자 : " + dlgn0100Dto.getHanNm() + " 인사관리 -> 직종, 직종세 누락 확인")); 
		        
		        }else {
					dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
					dlgn0100DAO.deleteDlgn0100(dlgn0100Dto); 
					
					dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
					dlgn0100DAO.insertDlgn0110(dlgn0100Dto);
//				}
			
				
				
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dlgn0100Dto.setResnRegnNum(rrnDecCrypt);
		
					
					InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
			 
			        infcDlgn0100Vo.setDpobCd(dlgn0100Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
					infcDlgn0100Vo.setSystemkey(dlgn0100Dto.getSystemkey());					/** column SYSTEMKEY : systemkey */
					infcDlgn0100Vo.setDilnlazYrMnth(dlgn0100Dto.getDilnlazYrMnth());			/** column 근태년월 : dilnlazYrMnth */
					infcDlgn0100Vo.setPayCd(dlgn0100Dto.getPayCd());    						/** column 급여구분코드 : payCd */
					infcDlgn0100Vo.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
					infcDlgn0100Vo.setMangeDeptCd(dlgn0100Dto.getMangeDeptCd());    			/** column 관리부서코드  mangeDeptCd */
					infcDlgn0100Vo.setDeptCd(dlgn0100Dto.getDeptCd());							/** column 부서코드 : deptCd */
					infcDlgn0100Vo.setBusinCd(dlgn0100Dto.getBusinCd());						/** column 사업코드 : businCd */
					infcDlgn0100Vo.setTypOccuCd(dlgn0100Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
					infcDlgn0100Vo.setPyspGrdeCd(dlgn0100Dto.getPyspGrdeCd());    				/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
					infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0100Dto.getDtilOccuInttnCd());    	/** column 직종세구분코드 : dtilOccuInttnCd */
					infcDlgn0100Vo.setTypOccuBusinVal(dlgn0100Dto.getTypOccuBusinVal());		/** set 복무통합구분값 : typOccuBusinVal */
					
					infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
					infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0100Dto.getDilnlazWklyHldyNumDys()); //주휴일수
					//System.out.println("infcDlgn0100Vo.getDilnlazWklyHldyNumDys()>> "+infcDlgn0100Vo.getDilnlazWklyHldyNumDys());
	//				if((detailYmKubn.compareTo(dlgn0100Dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
	//					
	//				/****************************************************************************************************
	//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
	//		         ****************************************************************************************************/
	//				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
	//		        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
	//		        /****************************************************************************************************
	//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
	//		         ****************************************************************************************************/
	//				}else{
						/****************************************************************************************************
						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
							DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
						Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
						/****************************************************************************************************
						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
	//				}
					cnt = cnt + 1;
					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본복무관리" ,"생성완료","대상자 : " + dlgn0100Dto.getHanNm())); 
	            }				
				
            }
//			List<Dlgn0100DTO> list = new ArrayList<Dlgn0100DTO>();
			
//			List list = new ArrayList();
//			
//			InfcDlgn0100VO infcDlgn0100Vo = new InfcDlgn0100VO();
//			
//			list = dlgn0100DAO.afterSelectDlgn0100(dlgn0100Dto);
//			
//			// 2.복호화 리턴받을 값 선언
//			String rrnDecCrypt = "";
//			
//			if(list != null && list.size() > 0){
//				for(int i = 0; i < list.size(); i++){
//					
////					Dlgn0100DTO dlgn0100Dto = list.get(i);
//					
//					dlgn0100Dto = new Dlgn0100DTO();
//					
//					Map tempMap = (Map) list.get(i);
//					Iterator<String> keys = tempMap.keySet().iterator();
//					while(keys.hasNext() ){
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		dlgn0100Dto.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		dlgn0100Dto.set(key, tempMap.get(key));
//		            	}
//		            }
//					
//					// 3.복호화
//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					dlgn0100Dto.setResnRegnNum(rrnDecCrypt);
//
//					
//
//			 
//			        infcDlgn0100Vo.setDpobCd(dlgn0100Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
//					infcDlgn0100Vo.setSystemkey(dlgn0100Dto.getSystemkey());					/** column SYSTEMKEY : systemkey */
//					infcDlgn0100Vo.setDilnlazYrMnth(dlgn0100Dto.getDilnlazYrMnth());			/** column 근태년월 : dilnlazYrMnth */
//					infcDlgn0100Vo.setPayCd(dlgn0100Dto.getPayCd());    						/** column 급여구분코드 : payCd */
//					infcDlgn0100Vo.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
//					infcDlgn0100Vo.setDeptCd(dlgn0100Dto.getDeptCd());							/** column 부서코드 : deptCd */
//					infcDlgn0100Vo.setBusinCd(dlgn0100Dto.getBusinCd());						/** column 사업코드 : businCd */
//					infcDlgn0100Vo.setTypOccuCd(dlgn0100Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
//					infcDlgn0100Vo.setPyspGrdeCd(dlgn0100Dto.getPyspGrdeCd());    				/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
//					infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0100Dto.getDtilOccuInttnCd());    	/** column 직종세구분코드 : dtilOccuInttnCd */
//					
//					infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
//					infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//					
//					infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0100Dto.getDilnlazWklyHldyNumDys()); //주휴일수
//					//System.out.println("infcDlgn0100Vo.getDilnlazWklyHldyNumDys()>> "+infcDlgn0100Vo.getDilnlazWklyHldyNumDys());
//					/****************************************************************************************************
//			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//			         ****************************************************************************************************/
//			        PayrListenerAdapter dlgnAdapter = new PayrListenerAdapter();  
//			        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//			        /****************************************************************************************************
//			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//			         ****************************************************************************************************/
//				}  
//	        }
            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무 생성" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(cnt) + "명처리완료 ")); 
			/** ++++++++++++++++++++++++++++++++++ 기본근무 생성 +++++++++++++++++++++++++++++++++++++**/
			
			/** ++++++++++++++++++++++++++++++++++ 시간외근무 생성 +++++++++++++++++++++++++++++++++++++**/
            cnt = 0;
            
			dlgn0200Dto.setIsmt(sessionUser.getUsrId());
			dlgn0200Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			dlgn0200Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dlgn0200Dto.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가
			dlgn0200Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0200Dto.getDtilOccuInttnCd()).replace(",", ""));
	            
			dlgn0200Dto.setDpobCd(sessionUser.getDpobCd()); 
			dlgn0200Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
			dlgn0200Dto.setUsrId(sessionUser.getUsrId());  
			// 시스템 키가 없을 경우 일괄처리(lump), 있으면 일괄처리(individ)
	        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
	        if("".equals(dlgn0200Dto.getSystemkey())  || dlgn0200Dto.getSystemkey() == null) {
	        	dlgn0200Dto.setCreateFlag("lump");		//일괄
	        }else {
	        	dlgn0200Dto.setCreateFlag("individ");	//개별
	        }
			
			 listDeptCd = new ArrayList<String>();
			 
			 dlgn0200Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(dlgn0200Dto.getMangeDeptCd()));			// 관리부서
			/******************************** 권한 ************************************************************************/
            chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

            if ("FALSE".equals(chkDeptCd)) {
            	dlgn0200Dto.setDeptCd(sessionUser.getDeptCd()); 
            	listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0200Dto.getCurrAffnDeptCd());  
            	dlgn0200Dto.setDeptCdArr(listDeptCd);     //부서코드  
            	dlgn0200Dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	if (dlgn0200Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0200Dto.getCurrAffnDeptCd()))
            			|| MSFSharedUtils.allowNulls(dlgn0200Dto.getCurrAffnDeptCd()).contains(dlgn0200Dto.getPayrMangDeptCd())
            			) {
            		dlgn0200Dto.setCurrAffnDeptCd("");  //부서코드
            		dlgn0200Dto.setDeptCdArr(null);     //부서코드 
            	} else {
            		listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0200Dto.getCurrAffnDeptCd());  
            		dlgn0200Dto.setDeptCdArr(listDeptCd);     //부서코드 
            	}
            	 
            }
//            /**
//            * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
//	         */
//            if (dlgn0200Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0200Dto.getDeptCdAuth())) 
//       			|| MSFSharedUtils.allowNulls(dlgn0200Dto.getDeptCdAuth()).contains(dlgn0200Dto.getPayrMangDeptCd())
//       			) {
//            	dlgn0200Dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//              	
//       	}  
	       

            lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200Dto.getTypOccuCd())); 
            dlgn0200Dto.setTypOccuCdArr(lstTypeOccuCd); 
            dlgn0200Dto.setTypOccuCd(MSFSharedUtils.allowNulls(dlgn0200Dto.getTypOccuCd()));  //직종
            
            lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200Dto.getDtilOccuInttnCd())); 
            dlgn0200Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            dlgn0200Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dlgn0200Dto.getDtilOccuInttnCd())); //직종세 
            dlgn0200Dto.setTypOccuBusinVal(MSFSharedUtils.allowNulls(dlgn0200Dto.getTypOccuBusinVal()) );	// 복무통합구분값
            
            /******************************** 권한 ************************************************************************/
			
           
           List list01 =   dlgn0200DAO.selectDlgn0200ToRtnData(dlgn0200Dto); 
           
           Iterator<Map<String, Object>> iter01 = list01.iterator();
       
           while ( iter01.hasNext() ) {
               Map<String, Object> map = (Map<String, Object>) iter01.next();
            
	          
               dlgn0200Dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
               dlgn0200Dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
               dlgn0200Dto.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyYrMnth")))); //   DILNLAZ_YR_MNTH
               dlgn0200Dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
               dlgn0200Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
               dlgn0200Dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
               dlgn0200Dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
               dlgn0200Dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
               dlgn0200Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
               dlgn0200Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
		       
               dlgn0200Dto.setDilnlazExceDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
               dlgn0200Dto.setDilnlazExceDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
		        
		         
               dlgn0200Dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN 
               dlgn0200Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
               dlgn0200Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
               dlgn0200Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
               dlgn0200Dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
               dlgn0200Dto.setTypOccuBusinVal(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuBusinVal"))));    /** set 복무통합구분값 : typOccuBusinVal */ 
               
               // 무기계약직 이면서 직종, 직종세 없을 경우 복무 로직 skip 처리
		        if( "A0020010".equals(dlgn0100Dto.getEmymtDivCd()) &&  ("".equals(dlgn0200Dto.getTypOccuCd()) || "".equals(dlgn0200Dto.getDtilOccuInttnCd())) ) {
		        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","시간외근무관리" ,"생성오류","대상자 : " + dlgn0200Dto.getHanNm() + " 인사관리 -> 직종, 직종세 누락 확인")); 
		        
		        }else {
            
	                dlgn0200DAO.deleteDlgn0210(dlgn0200Dto);
					dlgn0200DAO.deleteDlgn0200(dlgn0200Dto); 
					dlgn0200DAO.insertDlgn0200(dlgn0200Dto);
					dlgn0200DAO.insertDlgn0210(dlgn0200Dto);
					
					
					InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dlgn0200Dto.setResnRegnNum(rrnDecCrypt);
					
					infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
					infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			 
					infcDlgn0200Vo.setDpobCd(dlgn0200Dto.getDpobCd());									/** column 사업장코드 : dpobCd */
					infcDlgn0200Vo.setSystemkey(dlgn0200Dto.getSystemkey());    						/** column SYSTEMKEY : systemkey */
					infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth());   	/** column 근태년월 : dilnlazYrMnth */
					infcDlgn0200Vo.setPayCd(dlgn0200Dto.getPayCd());									/** column 급여구분코드 : payCd */
					infcDlgn0200Vo.setEmymtDivCd(dlgn0200Dto.getEmymtDivCd());    						/** column 고용구분코드 : emymtDivCd */
					infcDlgn0200Vo.setMangeDeptCd(dlgn0200Dto.getMangeDeptCd());    					/** column 관리부서코드  mangeDeptCd */
					infcDlgn0200Vo.setDeptCd(dlgn0200Dto.getDeptCd());									/** column 부서코드 : deptCd */
					infcDlgn0200Vo.setBusinCd(dlgn0200Dto.getBusinCd());    							/** column 사업코드 : businCd */
					infcDlgn0200Vo.setTypOccuCd(dlgn0200Dto.getTypOccuCd());    						/** column 직종코드 : typOccuCd */
					infcDlgn0200Vo.setPyspGrdeCd(dlgn0200Dto.getPyspGrdeCd());    						/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
					infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0200Dto.getDtilOccuInttnCd());    			/** column 직종세구분코드 : dtilOccuInttnCd */
					infcDlgn0200Vo.setTypOccuBusinVal(dlgn0100Dto.getTypOccuBusinVal());				/** set 복무통합구분값 : typOccuBusinVal */
					
					/****************************************************************************************************
			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
			         ****************************************************************************************************/
					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
			        Long iResult = dlgnAdapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
			        /****************************************************************************************************
			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
			         ****************************************************************************************************/
			        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","시간외근무관리" ,"생성완료","대상자 : " + dlgn0200Dto.getHanNm())); 
			        cnt = cnt + 1;
		        }	
           }
//				list = new ArrayList();
//				InfcDlgn0200VO infcDlgn0200Vo = new InfcDlgn0200VO();
//				
//				list = dlgn0200DAO.afterSelectDlgn0200(dlgn0200Dto);
//				
//				if(list != null && list.size() > 0){
//					for(int i = 0; i < list.size(); i++){
//						
////						Dlgn0200DTO dlgn0200Dto = list.get(i);
//						
//						dlgn0200Dto = new Dlgn0200DTO();
//						
//						Map tempMap = (Map) list.get(i);
//						Iterator<String> keys = tempMap.keySet().iterator();
//						while(keys.hasNext() ){
//				            String key = keys.next();
//				            //형 타입이 숫자형일경우 형변환 해준다.
//			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//			            		dlgn0200Dto.set(key, String.valueOf(tempMap.get(key)));
//			            	}else{
//			            		dlgn0200Dto.set(key, tempMap.get(key));
//			            	}
//			            }
//						
//						// 3.복호화
//						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//						dlgn0200Dto.setResnRegnNum(rrnDecCrypt);
//						
//						infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
//						infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//				 
//						infcDlgn0200Vo.setDpobCd(dlgn0200Dto.getDpobCd());											/** column 사업장코드 : dpobCd */
//						infcDlgn0200Vo.setSystemkey(dlgn0200Dto.getSystemkey());    									/** column SYSTEMKEY : systemkey */
//						infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth());   	 	/** column 근태년월 : dilnlazYrMnth */
//						infcDlgn0200Vo.setPayCd(dlgn0200Dto.getPayCd());													/** column 급여구분코드 : payCd */
//						infcDlgn0200Vo.setEmymtDivCd(dlgn0200Dto.getEmymtDivCd());    								/** column 고용구분코드 : emymtDivCd */
//						infcDlgn0200Vo.setDeptCd(dlgn0200Dto.getDeptCd());												/** column 부서코드 : deptCd */
//						infcDlgn0200Vo.setBusinCd(dlgn0200Dto.getBusinCd());    											/** column 사업코드 : businCd */
//						infcDlgn0200Vo.setTypOccuCd(dlgn0200Dto.getTypOccuCd());    								/** column 직종코드 : typOccuCd */
//						infcDlgn0200Vo.setPyspGrdeCd(dlgn0200Dto.getPyspGrdeCd());    								/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
//						infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0200Dto.getDtilOccuInttnCd());    						/** column 직종세구분코드 : dtilOccuInttnCd */
//						
//						/****************************************************************************************************
//				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//				         ****************************************************************************************************/
//				        PayrListenerAdapter dlgnAdapter = new PayrListenerAdapter();  
//				        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
//				        /****************************************************************************************************
//				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//				         ****************************************************************************************************/
//					}  
//		        }
           	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","시간외근무 생성" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(cnt) + "명처리완료 ")); 
			/** ++++++++++++++++++++++++++++++++++ 시간외근무 생성 +++++++++++++++++++++++++++++++++++++**/
       		
           	retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "근태 생성 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}		
		
		return retval;
	}
		
	
	
//	@Override
//	public int generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto) throws MSFException {
//		String detailYmKubn = DiligenceCommonConstants.YANGPYEONG_DLGN_DT_BUNGI;
////		String detailYmKubn = "201703"; //복무관리 기준일
//		
//		int result = 0;
//		
//		
//		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		
//		Dlgn0100VO      dlgn0100Vo		= new Dlgn0100VO();
//		Dlgn0100SrhVO  dlgn0100SrhVo  	= new Dlgn0100SrhVO();
//		
//		Dlgn0200VO      dlgn0200Vo		= new Dlgn0200VO();
//		Dlgn0200SrhVO  dlgn0200SrhVo  	= new Dlgn0200SrhVO();
//		
//		
//		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//		
//    	
//		try{
//
//			
//		    /** ++++++++++++++++++++++++++++++++++ 기본근무 생성 +++++++++++++++++++++++++++++++++++++**/
//			/** 조건절 */
//			dlgn0100Dto.setDpobCd(sessionUser.getDpobCd()); 
//			dlgn0100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
//			dlgn0100Dto.setUsrId(sessionUser.getUsrId());  
//			
//		 	List<String> listDeptCd = new ArrayList<String>();
//			
//			dlgn0100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가
//			dlgn0100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd()).replace(",", ""));
//	         
//			dlgn0100Dto.setSystemkey(MSFSharedUtils.allowNulls(dlgn0100Dto.getSystemkey()));
//	        
//	        // 시스템 키가 없을 경우 일괄처리(lump), 있으면 일괄처리(individ)
//	        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
//	        if("".equals(dlgn0100Dto.getSystemkey())  || dlgn0100Dto.getSystemkey() == null) {
//	        	dlgn0100Dto.setCreateFlag("lump");		//일괄
//	        }else {
//	        	dlgn0100Dto.setCreateFlag("individ");	//개별
//	        }
//			/******************************** 권한 ************************************************************************/
//            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//            if ("FALSE".equals(chkDeptCd)) {
//            	dlgn0100Dto.setDeptCd(sessionUser.getDeptCd()); 
//            	listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0100Dto.getDeptCd());  
//            	dlgn0100Dto.setDeptCdArr(listDeptCd);     //부서코드  
//            	dlgn0100Dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	
//            	if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCd())) 
//            			|| MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCd()).contains(dlgn0100Dto.getPayrMangDeptCd())
//            			) {
//            		dlgn0100Dto.setDeptCdArr(null);     //부서코드 
//            		dlgn0100Dto.setDeptCd("");  //부서코드
//            	} else {
//            		listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0100Dto.getDeptCd());  
//            		dlgn0100Dto.setDeptCdArr(listDeptCd);     //부서코드 
//            	}
//	          
//            }
//            
////            /**
////	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
////	         */
////            if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth())) 
////        			|| MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth()).contains(dlgn0100Dto.getPayrMangDeptCd())
////        			) {
////            	dlgn0100Dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
////              	 
////        	}  
//            
//            
//            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd())); 
//            dlgn0100Dto.setTypOccuCdArr(lstTypeOccuCd); 
//            dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd()));  //직종
//            
//            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); 
//            dlgn0100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//            dlgn0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); //직종세 
//            
//			dlgn0100Dto.setIsmt(sessionUser.getUsrId());
//			dlgn0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//            
//	       
//            /******************************** 권한 ************************************************************************/
//		
//			  //삭제 인서트 처리를 위한 조건으로 가지고 와서 인서트 처리 할것....로직  
//            /**
//             * 대상자 가져오기 
//             */
////			
////			// 2.복호화 리턴받을 값 선언
// 			String rrnDecCrypt = "";
//            List list =   dlgn0100DAO.selectDlgn0100ToRtnData(dlgn0100Dto); 
//            
//            Iterator<Map<String, Object>> iter = list.iterator();
//        
//            while ( iter.hasNext() ) {
//                Map<String, Object> map = (Map<String, Object>) iter.next();
//            
//                
//                dlgn0100Dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
//                dlgn0100Dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
//                dlgn0100Dto.setDilnlazYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazYrMnth")))); //   DILNLAZ_YR_MNTH
//                dlgn0100Dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
//                dlgn0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
//                dlgn0100Dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
//                dlgn0100Dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
//                dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
//                dlgn0100Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
//                dlgn0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
//                dlgn0100Dto.setDilnlazDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
//                dlgn0100Dto.setDilnlazDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
//                dlgn0100Dto.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyNumDys"))));   // DILNLAZ_DUTY_NUM_DYS
//                dlgn0100Dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN
//                dlgn0100Dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazWklyHldyNumDys")))); // DILNLAZ_WKLY_HLDY_NUM_DYS
//                dlgn0100Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
//                dlgn0100Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
//                dlgn0100Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
//                dlgn0100Dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
//                
////				dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
////				dlgn0100DAO.deleteDlgn0100(dlgn0100Dto); 
////				
////				dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
//				
////				if((detailYmKubn.compareTo(dlgn0100Dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
////					
////					dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
////					dlgn0100DAO.deleteDlgn0100(dlgn0100Dto); 
////					
////					dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
////					dlgn0100DAO.insertDlgn0110Pre(dlgn0100Dto);
////					
////				}else{
//					
//					dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
//					dlgn0100DAO.deleteDlgn0100(dlgn0100Dto); 
//					
//					dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
//					dlgn0100DAO.insertDlgn0110(dlgn0100Dto);
////				}
//			
//				
//				
//				// 3.복호화
//				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//				dlgn0100Dto.setResnRegnNum(rrnDecCrypt);
//	
//				
//				InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
//		 
//		        infcDlgn0100Vo.setDpobCd(dlgn0100Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
//				infcDlgn0100Vo.setSystemkey(dlgn0100Dto.getSystemkey());					/** column SYSTEMKEY : systemkey */
//				infcDlgn0100Vo.setDilnlazYrMnth(dlgn0100Dto.getDilnlazYrMnth());			/** column 근태년월 : dilnlazYrMnth */
//				infcDlgn0100Vo.setPayCd(dlgn0100Dto.getPayCd());    						/** column 급여구분코드 : payCd */
//				infcDlgn0100Vo.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
//				infcDlgn0100Vo.setDeptCd(dlgn0100Dto.getDeptCd());							/** column 부서코드 : deptCd */
//				infcDlgn0100Vo.setBusinCd(dlgn0100Dto.getBusinCd());						/** column 사업코드 : businCd */
//				infcDlgn0100Vo.setTypOccuCd(dlgn0100Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
//				infcDlgn0100Vo.setPyspGrdeCd(dlgn0100Dto.getPyspGrdeCd());    				/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
//				infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0100Dto.getDtilOccuInttnCd());    	/** column 직종세구분코드 : dtilOccuInttnCd */
//				
//				infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
//				infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//				
//				infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0100Dto.getDilnlazWklyHldyNumDys()); //주휴일수
//				//System.out.println("infcDlgn0100Vo.getDilnlazWklyHldyNumDys()>> "+infcDlgn0100Vo.getDilnlazWklyHldyNumDys());
////				if((detailYmKubn.compareTo(dlgn0100Dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
////					
////				/****************************************************************************************************
////		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
////		         ****************************************************************************************************/
////				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
////		        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
////		        /****************************************************************************************************
////		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
////		         ****************************************************************************************************/
////				}else{
//					/****************************************************************************************************
//					 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//					 ****************************************************************************************************/
//						DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
//					Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//					/****************************************************************************************************
//					 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//					 ****************************************************************************************************/
////				}
//				
//            }
////			List<Dlgn0100DTO> list = new ArrayList<Dlgn0100DTO>();
//			
////			List list = new ArrayList();
////			
////			InfcDlgn0100VO infcDlgn0100Vo = new InfcDlgn0100VO();
////			
////			list = dlgn0100DAO.afterSelectDlgn0100(dlgn0100Dto);
////			
////			// 2.복호화 리턴받을 값 선언
////			String rrnDecCrypt = "";
////			
////			if(list != null && list.size() > 0){
////				for(int i = 0; i < list.size(); i++){
////					
//////					Dlgn0100DTO dlgn0100Dto = list.get(i);
////					
////					dlgn0100Dto = new Dlgn0100DTO();
////					
////					Map tempMap = (Map) list.get(i);
////					Iterator<String> keys = tempMap.keySet().iterator();
////					while(keys.hasNext() ){
////			            String key = keys.next();
////			            //형 타입이 숫자형일경우 형변환 해준다.
////		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
////		            		dlgn0100Dto.set(key, String.valueOf(tempMap.get(key)));
////		            	}else{
////		            		dlgn0100Dto.set(key, tempMap.get(key));
////		            	}
////		            }
////					
////					// 3.복호화
////					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
////					dlgn0100Dto.setResnRegnNum(rrnDecCrypt);
////
////					
////
////			 
////			        infcDlgn0100Vo.setDpobCd(dlgn0100Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
////					infcDlgn0100Vo.setSystemkey(dlgn0100Dto.getSystemkey());					/** column SYSTEMKEY : systemkey */
////					infcDlgn0100Vo.setDilnlazYrMnth(dlgn0100Dto.getDilnlazYrMnth());			/** column 근태년월 : dilnlazYrMnth */
////					infcDlgn0100Vo.setPayCd(dlgn0100Dto.getPayCd());    						/** column 급여구분코드 : payCd */
////					infcDlgn0100Vo.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
////					infcDlgn0100Vo.setDeptCd(dlgn0100Dto.getDeptCd());							/** column 부서코드 : deptCd */
////					infcDlgn0100Vo.setBusinCd(dlgn0100Dto.getBusinCd());						/** column 사업코드 : businCd */
////					infcDlgn0100Vo.setTypOccuCd(dlgn0100Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
////					infcDlgn0100Vo.setPyspGrdeCd(dlgn0100Dto.getPyspGrdeCd());    				/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
////					infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0100Dto.getDtilOccuInttnCd());    	/** column 직종세구분코드 : dtilOccuInttnCd */
////					
////					infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
////					infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
////					
////					infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0100Dto.getDilnlazWklyHldyNumDys()); //주휴일수
////					//System.out.println("infcDlgn0100Vo.getDilnlazWklyHldyNumDys()>> "+infcDlgn0100Vo.getDilnlazWklyHldyNumDys());
////					/****************************************************************************************************
////			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
////			         ****************************************************************************************************/
////			        PayrListenerAdapter dlgnAdapter = new PayrListenerAdapter();  
////			        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
////			        /****************************************************************************************************
////			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
////			         ****************************************************************************************************/
////				}  
////	        }
//			/** ++++++++++++++++++++++++++++++++++ 기본근무 생성 +++++++++++++++++++++++++++++++++++++**/
//			
//			/** ++++++++++++++++++++++++++++++++++ 시간외근무 생성 +++++++++++++++++++++++++++++++++++++**/
//			dlgn0200Dto.setIsmt(sessionUser.getUsrId());
//			dlgn0200Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//			
//			dlgn0200Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dlgn0200Dto.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가
//			dlgn0200Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0200Dto.getDtilOccuInttnCd()).replace(",", ""));
//	            
//			dlgn0200Dto.setDpobCd(sessionUser.getDpobCd()); 
//			dlgn0200Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
//			dlgn0200Dto.setUsrId(sessionUser.getUsrId());  
//			// 시스템 키가 없을 경우 일괄처리(lump), 있으면 일괄처리(individ)
//	        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
//	        if("".equals(dlgn0200Dto.getSystemkey())  || dlgn0200Dto.getSystemkey() == null) {
//	        	dlgn0200Dto.setCreateFlag("lump");		//일괄
//	        }else {
//	        	dlgn0200Dto.setCreateFlag("individ");	//개별
//	        }
//			
//			 listDeptCd = new ArrayList<String>();
//
//			/******************************** 권한 ************************************************************************/
//            chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//
//            if ("FALSE".equals(chkDeptCd)) {
//            	dlgn0200Dto.setDeptCd(sessionUser.getDeptCd()); 
//            	listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0200Dto.getCurrAffnDeptCd());  
//            	dlgn0200Dto.setDeptCdArr(listDeptCd);     //부서코드  
//            	dlgn0200Dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	if (dlgn0200Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0200Dto.getCurrAffnDeptCd()))
//            			|| MSFSharedUtils.allowNulls(dlgn0200Dto.getCurrAffnDeptCd()).contains(dlgn0200Dto.getPayrMangDeptCd())
//            			) {
//            		dlgn0200Dto.setCurrAffnDeptCd("");  //부서코드
//            		dlgn0200Dto.setDeptCdArr(null);     //부서코드 
//            	} else {
//            		listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0200Dto.getCurrAffnDeptCd());  
//            		dlgn0200Dto.setDeptCdArr(listDeptCd);     //부서코드 
//            	}
//            	 
//            }
////            /**
////            * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
////	         */
////            if (dlgn0200Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0200Dto.getDeptCdAuth())) 
////       			|| MSFSharedUtils.allowNulls(dlgn0200Dto.getDeptCdAuth()).contains(dlgn0200Dto.getPayrMangDeptCd())
////       			) {
////            	dlgn0200Dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
////              	
////       	}  
//	       
//
//            lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200Dto.getTypOccuCd())); 
//            dlgn0200Dto.setTypOccuCdArr(lstTypeOccuCd); 
//            dlgn0200Dto.setTypOccuCd(MSFSharedUtils.allowNulls(dlgn0200Dto.getTypOccuCd()));  //직종
//            
//            lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200Dto.getDtilOccuInttnCd())); 
//            dlgn0200Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//            dlgn0200Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dlgn0200Dto.getDtilOccuInttnCd())); //직종세 
//             
//            /******************************** 권한 ************************************************************************/
//			
//           
//           List list01 =   dlgn0200DAO.selectDlgn0200ToRtnData(dlgn0200Dto); 
//           
//           Iterator<Map<String, Object>> iter01 = list01.iterator();
//       
//           while ( iter01.hasNext() ) {
//               Map<String, Object> map = (Map<String, Object>) iter01.next();
//            
//	          
//               dlgn0200Dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
//               dlgn0200Dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
//               dlgn0200Dto.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyYrMnth")))); //   DILNLAZ_YR_MNTH
//               dlgn0200Dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
//               dlgn0200Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
//               dlgn0200Dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
//               dlgn0200Dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
//               dlgn0200Dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
//               dlgn0200Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
//               dlgn0200Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
//		       
//               dlgn0200Dto.setDilnlazExceDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
//               dlgn0200Dto.setDilnlazExceDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
//		        
//		         
//               dlgn0200Dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN 
//               dlgn0200Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
//               dlgn0200Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
//               dlgn0200Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
//               dlgn0200Dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
//		         
//	           
//            
//                dlgn0200DAO.deleteDlgn0210(dlgn0200Dto);
//				dlgn0200DAO.deleteDlgn0200(dlgn0200Dto); 
//				dlgn0200DAO.insertDlgn0200(dlgn0200Dto);
//				dlgn0200DAO.insertDlgn0210(dlgn0200Dto);
//				
//				
//				InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
//				
//				// 3.복호화
//				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//				dlgn0200Dto.setResnRegnNum(rrnDecCrypt);
//				
//				infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
//				infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		 
//				infcDlgn0200Vo.setDpobCd(dlgn0200Dto.getDpobCd());											/** column 사업장코드 : dpobCd */
//				infcDlgn0200Vo.setSystemkey(dlgn0200Dto.getSystemkey());    									/** column SYSTEMKEY : systemkey */
//				infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth());   	 	/** column 근태년월 : dilnlazYrMnth */
//				infcDlgn0200Vo.setPayCd(dlgn0200Dto.getPayCd());													/** column 급여구분코드 : payCd */
//				infcDlgn0200Vo.setEmymtDivCd(dlgn0200Dto.getEmymtDivCd());    								/** column 고용구분코드 : emymtDivCd */
//				infcDlgn0200Vo.setDeptCd(dlgn0200Dto.getDeptCd());												/** column 부서코드 : deptCd */
//				infcDlgn0200Vo.setBusinCd(dlgn0200Dto.getBusinCd());    											/** column 사업코드 : businCd */
//				infcDlgn0200Vo.setTypOccuCd(dlgn0200Dto.getTypOccuCd());    								/** column 직종코드 : typOccuCd */
//				infcDlgn0200Vo.setPyspGrdeCd(dlgn0200Dto.getPyspGrdeCd());    								/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
//				infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0200Dto.getDtilOccuInttnCd());    						/** column 직종세구분코드 : dtilOccuInttnCd */
//				
//				/****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
//		        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
//		        /****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//				
//           }
////				list = new ArrayList();
////				InfcDlgn0200VO infcDlgn0200Vo = new InfcDlgn0200VO();
////				
////				list = dlgn0200DAO.afterSelectDlgn0200(dlgn0200Dto);
////				
////				if(list != null && list.size() > 0){
////					for(int i = 0; i < list.size(); i++){
////						
//////						Dlgn0200DTO dlgn0200Dto = list.get(i);
////						
////						dlgn0200Dto = new Dlgn0200DTO();
////						
////						Map tempMap = (Map) list.get(i);
////						Iterator<String> keys = tempMap.keySet().iterator();
////						while(keys.hasNext() ){
////				            String key = keys.next();
////				            //형 타입이 숫자형일경우 형변환 해준다.
////			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
////			            		dlgn0200Dto.set(key, String.valueOf(tempMap.get(key)));
////			            	}else{
////			            		dlgn0200Dto.set(key, tempMap.get(key));
////			            	}
////			            }
////						
////						// 3.복호화
////						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
////						dlgn0200Dto.setResnRegnNum(rrnDecCrypt);
////						
////						infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
////						infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
////				 
////						infcDlgn0200Vo.setDpobCd(dlgn0200Dto.getDpobCd());											/** column 사업장코드 : dpobCd */
////						infcDlgn0200Vo.setSystemkey(dlgn0200Dto.getSystemkey());    									/** column SYSTEMKEY : systemkey */
////						infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth());   	 	/** column 근태년월 : dilnlazYrMnth */
////						infcDlgn0200Vo.setPayCd(dlgn0200Dto.getPayCd());													/** column 급여구분코드 : payCd */
////						infcDlgn0200Vo.setEmymtDivCd(dlgn0200Dto.getEmymtDivCd());    								/** column 고용구분코드 : emymtDivCd */
////						infcDlgn0200Vo.setDeptCd(dlgn0200Dto.getDeptCd());												/** column 부서코드 : deptCd */
////						infcDlgn0200Vo.setBusinCd(dlgn0200Dto.getBusinCd());    											/** column 사업코드 : businCd */
////						infcDlgn0200Vo.setTypOccuCd(dlgn0200Dto.getTypOccuCd());    								/** column 직종코드 : typOccuCd */
////						infcDlgn0200Vo.setPyspGrdeCd(dlgn0200Dto.getPyspGrdeCd());    								/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
////						infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0200Dto.getDtilOccuInttnCd());    						/** column 직종세구분코드 : dtilOccuInttnCd */
////						
////						/****************************************************************************************************
////				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
////				         ****************************************************************************************************/
////				        PayrListenerAdapter dlgnAdapter = new PayrListenerAdapter();  
////				        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
////				        /****************************************************************************************************
////				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
////				         ****************************************************************************************************/
////					}  
////		        }
//			/** ++++++++++++++++++++++++++++++++++ 시간외근무 생성 +++++++++++++++++++++++++++++++++++++**/
//			result = 1;
//			
//		}catch(Exception e){
//			
//			result = 0;
//			
//			e.printStackTrace();
//			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "근태 생성 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
//			
//		}		
//		
//		return result;
//	}
//	
}
