package com.app.exterms.diligence.server.service;

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

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.exterms.diligence.client.service.Dlgn0200Service;
import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0110DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0210SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0210VO;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.exterms.dlgn.server.utils.DiligenceCommonConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.pkg.listener.DlgnListenerAdapter;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.math.BigDecimal;


@Service("dlgn0200Service")
public class Dlgn0200ServiceImpl extends AbstractCustomServiceImpl implements Dlgn0200Service, DiligenceDaoConstants  {
//	extends RemoteServiceDispatcher
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(Dlgn0200ServiceImpl.class);
	private static final String calledClass = Dlgn0200ServiceImpl.class.getName();
	
	private String detailYmKubn = DiligenceCommonConstants.GIMCHEON_DLGN_DT_BUNGI; //복무관리 기준일
	
	@Autowired
	@Resource(name="dlgn0200DAO")
	private Dlgn0200DAO dlgn0200Dao;
	
	@Autowired
	@Resource(name="dlgn0210DAO")
	private Dlgn0210DAO dlgn0210DAO;
	
	@Autowired
	@Resource(name="dlgn0100DAO")
	private Dlgn0100DAO dlgn0100Dao;
	
	@Autowired
	@Resource(name="dlgn0110DAO")
	private Dlgn0110DAO dlgn0110DAO;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Dlgn0200DTO> searchWorkDayMemberInfo(
			BaseListLoadConfig config, Dlgn0200DTO dtoParam) throws Exception {
		
		String method = calledClass + ".searchWorkDayMemberInfo";
		
		String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
		
		List<Dlgn0200DTO> returnValue = new ArrayList<Dlgn0200DTO>();
		List egovResultDataList = new ArrayList();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		
		Dlgn0200SrhVO dlgn0200SrhVO = new Dlgn0200SrhVO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 
		dlgn0200SrhVO.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(dtoParam.getDilnlazExceDutyYrMnth()));//작업년월
		dlgn0200SrhVO.setHanNm(MSFSharedUtils.allowNulls(dtoParam.getHanNm()));					//성명
//		dlgn0200SrhVO.setResnRegnNum(MSFSharedUtils.allowNulls(dtoParam.getResnRegnNum()));		//주민등록번호
		
		// 2. 파라미터 보낼 때(암호화)
		dlgn0200SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200SrhVO.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

		
		//아래 권한부분에서 처리
//		List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
//		dlgn0200SrhVO.setDeptCdArr(listDeptCd);     
//		dlgn0200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
			
//			dlgn0200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서
		dlgn0200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(dtoParam.getEmymtDivCd()));	//고용구분
		dlgn0200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(dtoParam.getBusinCd()));			//사업
			
//		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(dtoParam.getHdofcCodtnCd());  
//		dlgn0200SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);    
//		dlgn0200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(dtoParam.getHdofcCodtnCd()));//재직코드
			
		List<String> lstTypOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())); 
		dlgn0200SrhVO.setTypOccuCdArr(lstTypOccuCd);  
		dlgn0200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())));				//직종
			
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd())); 
		dlgn0200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		dlgn0200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()))); 	//직종세
			
			
		dlgn0200SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장											
		dlgn0200SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	//단위기간 담당자 여부
		
		
//		dlgn0200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));	//단위기관
		//무조건 세션에 있는걸? 
		dlgn0200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())) ;   //단위기관
		
		
		dlgn0200SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						//유저 아이디
		
		dlgn0200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		dlgn0200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()).replace(",", ""));
		
		dlgn0200SrhVO.setPayCd(MSFSharedUtils.allowNulls(dtoParam.getPayCd())); //급여구분
			         
		/******************************** 권한 ************************************************************************/
		 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
		if ("FALSE".equals(chkDeptCd)) {
			dlgn0200SrhVO.setDeptCd(sessionUser.getDeptCd()); 
			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(sessionUser.getDeptCd());  
			dlgn0200SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
			dlgn0200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
          } else {
			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())) || 
					dtoParam.getCurrAffnDeptCd().indexOf(dtoParam.getDeptCd()) != -1
					) { 
	//			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
	//			dlgn0200SrhVO.setDeptCdArr(listDeptCd);     
	//			dlgn0200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
						
				dlgn0200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())); // 단위기관
				dtoParam.setDeptCd("");
				dlgn0200SrhVO.setDeptCd("");
				List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  //부서
				dlgn0200SrhVO.setDeptCdArr(listDeptCd); 
					        
			}  else { 
				dlgn0200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())); 
				dlgn0200SrhVO.setDeptCdArr(lsdeptCd);  
			}  	
          }

		 /**
        * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
        */
//       if (dlgn0200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0200SrhVO.getDeptCdAuth())) 
//   			|| MSFSharedUtils.allowNulls(dlgn0200SrhVO.getDeptCdAuth()).contains(dlgn0200SrhVO.getPayrMangDeptCd())
//   			) {
//    	   dlgn0200SrhVO.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//         	
//   	}  
		
		
		try{
			//egovResultDataList = dlgn0200Dao.selectDlgn0200(dtoParam);
			egovResultDataList = dlgn0200Dao.selectDlgn0200(dlgn0200SrhVO);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Dlgn0200DTO dto = new Dlgn0200DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Dlgn0200DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Dlgn0200DTO> getMemberWorkTimeInfo(
			BaseListLoadConfig config, Dlgn0200DTO dtoParam) throws Exception {
		List<Dlgn0200DTO> returnValue = new ArrayList<Dlgn0200DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
		

		String method = calledClass + ".getMemberWorkTimeInfo";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		// 2. 파라미터 보낼 때(암호화)
		dtoParam.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dtoParam.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		try{
			
			egovResultDataList = dlgn0200Dao.selectDlgn0210(dtoParam);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Dlgn0200DTO dto = new Dlgn0200DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					dto.setDilnlazDutyYnboolean("Y".equals(tempMap.get("dilnlazDutyYn")) ? true : false);
					dto.setDilnlazNtotYnboolean("Y".equals(tempMap.get("dilnlazNtotYn")) ? true : false);
					dto.setDilnlazHodyDutyYnBoolean("Y".equals(tempMap.get("dilnlazHodyDutyYn")) ? true : false);/** column 근태_휴일근무여부 : dilnlazHodyDutyYn */
					
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Dlgn0200DTO>(returnValue);
	}

	@Override
	public PagingLoadResult<ShowMessageBM>   generateWorkTime(Dlgn0200DTO dto) throws MSFException {
		
			String windowNm = "시간외근무관리";
			String windowId = "DLGN0200";
			
			
			String method = calledClass + ".generateWorkTime";
			MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			

			Long result = new Long(0);
	        Long iCnt = new Long(0);
	        PagingLoadResult<ShowMessageBM> retval = null;
	        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	        
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			 	
			
			// 2. 파라미터 보낼 때(암호화)
			dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
			
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dto.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가
	        dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd()).replace(",", ""));
	            
	        dto.setDpobCd(sessionUser.getDpobCd()); 
			dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
			dto.setUsrId(sessionUser.getUsrId());  
			// 시스템 키가 없을 경우 일괄처리(lump), 있으면 일괄처리(individ)
	        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
	        if("".equals(dto.getSystemkey())  || dto.getSystemkey() == null) {
	        	dto.setCreateFlag("lump");		//일괄
	        }else {
	        	dto.setCreateFlag("individ");	//개별
	        }
			
			List<String> listDeptCd = new ArrayList<String>();

			/******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

            if ("FALSE".equals(chkDeptCd)) {
            	dto.setDeptCd(sessionUser.getDeptCd()); 
            	listDeptCd = SmrmfUtils.getStrToArrayList(dto.getCurrAffnDeptCd());  
        		dto.setDeptCdArr(listDeptCd);     //부서코드  
            	dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	if (dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dto.getCurrAffnDeptCd()))
            			|| MSFSharedUtils.allowNulls(dto.getCurrAffnDeptCd()).contains(dto.getPayrMangDeptCd())
            			) {
            		dto.setCurrAffnDeptCd("");  //부서코드
            		dto.setDeptCdArr(null);     //부서코드 
            	} else {
            		listDeptCd = SmrmfUtils.getStrToArrayList(dto.getCurrAffnDeptCd());  
            		dto.setDeptCdArr(listDeptCd);     //부서코드 
            	}
            	 
            }
            /**
            * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
	         */
//            if (dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dto.getDeptCdAuth())) 
//       			|| MSFSharedUtils.allowNulls(dto.getDeptCdAuth()).contains(dto.getPayrMangDeptCd())
//       			) {
//            	dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//              	
//       	}  
	       

            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dto.getTypOccuCd())); 
            dto.setTypOccuCdArr(lstTypeOccuCd); 
            dto.setTypOccuCd(MSFSharedUtils.allowNulls(dto.getTypOccuCd()));  //직종
            
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd())); 
            dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd())); //직종세 
         // 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
            
            /******************************** 권한 ************************************************************************/
			try {
				
				 /**
	             * 대상자 가져오기 
	             */
	            List list =   dlgn0200Dao.selectDlgn0200ToRtnData(dto); 
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	        
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	             
		          
			        dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
	                dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
			        dto.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyYrMnth")))); //   DILNLAZ_YR_MNTH
			        dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
			        dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
			        dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
			        dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
			        dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
			        dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
			        dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
			       
			        dto.setDilnlazExceDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
			        dto.setDilnlazExceDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
			        
			         
			        dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN 
			        dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
			        dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
			        dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
			        dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
			        
			        // 무기계약직 이면서 직종, 직종세 없을 경우 복무 로직 skip 처리
			        if( "A0020010".equals(dto.getEmymtDivCd()) && ( "".equals(dto.getTypOccuCd()) || "".equals(dto.getDtilOccuInttnCd()))) {
			        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","시간외근무관리" ,"생성오류","대상자 : " + dto.getHanNm() + " 인사관리 -> 직종, 직종세 누락 확인")); 
			        }else {
			         
		          
						dlgn0200Dao.deleteDlgn0210(dto);
						dlgn0200Dao.deleteDlgn0200(dto); 
						dlgn0200Dao.insertDlgn0200(dto);
						dlgn0200Dao.insertDlgn0210(dto);
						
						InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
					
						// 3.복호화
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						dto.setResnRegnNum(rrnDecCrypt);
						
						infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
						infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				 
						infcDlgn0200Vo.setDpobCd(dto.getDpobCd());	/** column 사업장코드 : dpobCd */
						infcDlgn0200Vo.setSystemkey(dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
						infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dto.getDilnlazExceDutyYrMnth());    /** column 근태년월 : dilnlazYrMnth */
						infcDlgn0200Vo.setPayCd(dto.getPayCd());	/** column 급여구분코드 : payCd */
						infcDlgn0200Vo.setEmymtDivCd(dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
						infcDlgn0200Vo.setDeptCd(dto.getDeptCd());	/** column 부서코드 : deptCd */
						infcDlgn0200Vo.setBusinCd(dto.getBusinCd());    /** column 사업코드 : businCd */
						infcDlgn0200Vo.setTypOccuCd(dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
						infcDlgn0200Vo.setPyspGrdeCd(dto.getPyspGrdeCd());    /** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
						infcDlgn0200Vo.setDtilOccuInttnCd(dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
						
						if((detailYmKubn.compareTo(dto.getDilnlazExceDutyYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
							
							/****************************************************************************************************
					         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
					         ****************************************************************************************************/
							DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
					        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
					        /****************************************************************************************************
					         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
					         ****************************************************************************************************/
						}else{
							/****************************************************************************************************
							 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
							 ****************************************************************************************************/
								DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
							Long iResult = dlgnAdapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
							/****************************************************************************************************
							 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
							 ****************************************************************************************************/
						}
				        iCnt = iCnt + 1;
				        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","초과근무관리" ,"생성완료","대상자 : " + dto.getHanNm())); 
				        
			        }
	            }
	            
	            
//				List list = new ArrayList();
//				InfcDlgn0200VO infcDlgn0200Vo = new InfcDlgn0200VO();
//				
//				list = dlgn0200Dao.afterSelectDlgn0200(dto);
				
//				// 2.복호화 리턴받을 값 선언
//				String rrnDecCrypt = "";
//				
//				if(list != null && list.size() > 0){
//					for(int i = 0; i < list.size(); i++){
//						
////						Dlgn0200DTO dlgn0200Dto = list.get(i);
//						
//						Dlgn0200DTO dlgn0200Dto = new Dlgn0200DTO();
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
//						infcDlgn0200Vo.setDpobCd(dlgn0200Dto.getDpobCd());	/** column 사업장코드 : dpobCd */
//						infcDlgn0200Vo.setSystemkey(dlgn0200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//						infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth());    /** column 근태년월 : dilnlazYrMnth */
//						infcDlgn0200Vo.setPayCd(dlgn0200Dto.getPayCd());	/** column 급여구분코드 : payCd */
//						infcDlgn0200Vo.setEmymtDivCd(dlgn0200Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//						infcDlgn0200Vo.setDeptCd(dlgn0200Dto.getDeptCd());	/** column 부서코드 : deptCd */
//						infcDlgn0200Vo.setBusinCd(dlgn0200Dto.getBusinCd());    /** column 사업코드 : businCd */
//						infcDlgn0200Vo.setTypOccuCd(dlgn0200Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//						infcDlgn0200Vo.setPyspGrdeCd(dlgn0200Dto.getPyspGrdeCd());    /** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
//						infcDlgn0200Vo.setDtilOccuInttnCd(dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
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
//
//		        }
				
	            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","초과근무 생성" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 ")); 
				 
				 retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
				 
			}catch(Exception e){
				e.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D:C:B:S",e, windowNm , windowId);
				
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:C:B:S");
			
		return retval;
	}

	@Override
	public int saveWorkTime(List<Dlgn0200DTO> list) throws Exception {
		int updateCnt = 0;
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveWorkTime";
		
		 InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
		 
		 String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
		 
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		 
			
		 try{
			 
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			 
			if(list != null && list.size() > 0){
				for(int i = 0; i < list.size(); i++){
					Dlgn0200DTO dto = list.get(i);
					

					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					
					dto.setIsmt(sessionUser.getUsrId());
					dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					   if ((new BigDecimal(MSFSharedUtils.defaultNulls(dto.getDilnlazDutyTm(),"0"))).compareTo(BigDecimal.ZERO) > 0) {
						    //dto.setDilnlazDutyYn(dto.getDilnlazDutyYnboolean() ? "Y" : "N");       //연장근로유무
					    	dto.setDilnlazDutyYn("Y");       //연장근로유무
					    	dto.setDilnlazTmRstDutyYn("Y");
					    	dto.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(dto.getDilnlazDutyTm(),"0"));
					    } else {
					    	dto.setDilnlazDutyYn("N");       //연장근로유무
					    	dto.setDilnlazTmRstDutyYn("N");
					    	dto.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(dto.getDilnlazDutyTm(),"0"));
					    }
					    
				    
				    if ((new BigDecimal(MSFSharedUtils.defaultNulls(dto.getDilnlazNtotTm(),"0"))).compareTo(BigDecimal.ZERO) > 0) {
					    //dto.setDilnlazNtotYn(dto.getDilnlazNtotYnboolean() ? "Y" : "N");       //야간근로유무
				    	dto.setDilnlazNtotYn("Y");       //야간근로유무 
				    } else {
				    	dto.setDilnlazNtotYn("N");       //야간근로유무 
				    }
				    
				    if ((new BigDecimal(MSFSharedUtils.defaultNulls(dto.getDilnlazHodyDutyTm(),"0"))).compareTo(BigDecimal.ZERO) > 0) {
				    	//dto.setDilnlazHodyDutyYn(dto.getDilnlazHodyDutyYnBoolean() ? "Y" : "N");	/** column 근태_휴일근무여부 : dilnlazHodyDutyYn */
				    	dto.setDilnlazHodyDutyYn("Y");       //휴일근무
				    } else {
				    	dto.setDilnlazHodyDutyYn("N");       //휴일근무
				    }
				     
					//dto.setDilnlazHodyDutyTm(dto.getDilnlazHodyDutyTm());						/** column 근태_휴일근무시간 : dilnlazHodyDutyTm */
					
					updateCnt += dlgn0200Dao.updateDlgn0210(dto);
			 
					infcDlgn0200Vo.setDpobCd(dto.getDpobCd());    								/** column 사업장코드 : dpobCd */
					infcDlgn0200Vo.setSystemkey(dto.getSystemkey());    						/** column SYSTEMKEY : systemkey */
					infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dto.getDilnlazExceDutyYrMnth());	/** column 근태년월 : dilnlazYrMnth */
					infcDlgn0200Vo.setPayCd(dto.getPayCd());    								/** column 급여구분코드 : payCd */
					infcDlgn0200Vo.setEmymtDivCd(dto.getEmymtDivCd());    						/** column 고용구분코드 : emymtDivCd */
					infcDlgn0200Vo.setDeptCd(dto.getDeptCd());    								/** column 부서코드 : deptCd */
					infcDlgn0200Vo.setBusinCd(dto.getBusinCd());   								/** column 사업코드 : businCd */
					infcDlgn0200Vo.setTypOccuCd(dto.getTypOccuCd());    						/** column 직종코드 : typOccuCd */
					infcDlgn0200Vo.setPyspGrdeCd("");    										/**   column 호봉등급코드 : pyspGrdeCd */
					infcDlgn0200Vo.setDtilOccuInttnCd(dto.getDtilOccuInttnCd());    			/** column 직종세구분코드 : dtilOccuInttnCd */
					
					infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dto.getDilnlazExceDutyYrMnth());				
					 
				}  
				/****************************************************************************************************
		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
		         ****************************************************************************************************/
				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
		        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
		        
		        /****************************************************************************************************
		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
		         ****************************************************************************************************/
	        }
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		 }catch(Exception e) {
			 e.printStackTrace();
			 
			 /** 에러 로그 **/			
			 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U", e, windowNm , windowId);
			 
		 }
		
		return updateCnt;
	}

	@Override
	public int deleteWorkTime(List<Dlgn0200DTO> list) throws Exception {
		
		String method = calledClass + ".deleteWorkTime";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		int deleteCnt = 0;
		

		String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
		
			deleteCnt = 0;
			if(list != null && list.size() > 0){
				for(int i = 0; i < list.size(); i++){
					Dlgn0200DTO dto = list.get(i);
					Dlgn0100DTO dtoDlgn0100 = new Dlgn0100DTO();
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dtoDlgn0100.setResnRegnNum(rrnDecCrypt);
					
					dtoDlgn0100.setDpobCd(dto.getDpobCd());    							/** column 사업장코드 : dpobCd */
					dtoDlgn0100.setSystemkey(dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
					dtoDlgn0100.setDilnlazYrMnth(dto.getDilnlazExceDutyYrMnth());    	/** column 근태년월 : dilnlazYrMnth */
					dtoDlgn0100.setPayCd(dto.getPayCd());    							/** column 급여구분코드 : payCd */
					
					deleteCnt += dlgn0200Dao.deleteDlgn0200_S(dto);
					dlgn0200Dao.deleteDlgn0210_S(dto); 
					
					dlgn0100Dao.deleteDlgn0110_S(dtoDlgn0100);
					deleteCnt += dlgn0100Dao.deleteDlgn0100_S(dtoDlgn0100); 
				}
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
		
		}catch(Exception e) {
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D",e, windowNm , windowId);
		}
		
		return deleteCnt;
	}
	
	public PagingLoadResult<BaseModel> getDlgn0200List_01(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_DLGN0200LIST_01;
        Dlgn0200SrhVO   dlgn0200SrhVO = new Dlgn0200SrhVO(); 
        Dlgn0210SrhVO   dlgn0210SrhVO = new Dlgn0210SrhVO();
        Dlgn0200VO dlgn0200VO = new Dlgn0200VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
	      if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
	      
	          WebApplicationContext wac = WebApplicationContextUtils.
	                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	          dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
	      }
        
        try {
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0470BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            dlgn0210SrhVO.setDpobCd(sessionUser.getDpobCd());
            dlgn0210SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); //고용구분코드
            dlgn0210SrhVO.setDilnlazExceDutyYrMnth(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailYm"), "")); //근태년월
            dlgn0210SrhVO.setHanNm(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailName"), "")); //성명
            dlgn0210SrhVO.setDetailEmymtBgnnDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtBgnnDt"), "")); //시작일자
            dlgn0210SrhVO.setDetailEmymtEndDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtEndDt"), "")); //시작일자
            dlgn0210SrhVO.setSystemkey(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"), "")); //시스템키
            dlgn0210SrhVO.setPayCd(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd"), ""));  //급여구분코드
            
//            //Get total record count //전체 데이터 갯수를 가지고 온다.
	         if ( pagingValues.executeRecordCount ) { 
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
//                int iResultCnt = 0 ;
                int iResultCnt = dlgn0210DAO.selectDlgn0200ListTotCnt(dlgn0210SrhVO); 
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginDlgn0200DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            dlgn0210SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	dlgn0210SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	dlgn0210SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            
            List list = dlgn0210DAO.selectDlgn0200List(dlgn0210SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	
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
                       
                     case ColumnDef.TYPE_LONG:   
                     
                    if (mapCon != null) {  
                        Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
                        map.put(tableAttributes[i].getName(), lValue); 
                    }  
                       
                     break;
                     
                 	//3. 복호화
                 	case ColumnDef.TYPE_STRING: 
                 	          			          			
                 		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                    			
                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                 	          			
                 			String rrnDecCrypt = "";
                 	          			
                 			// 주민번호(복호화)
                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 	          		
                 			strValue = rrnDecCrypt;
                 						
                 		}
                  	                       
                 	map.put(tableAttributes[i].getName(), strValue);
                 		                    
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
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0200DataList, "getDlgn0200List_01");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	//TODO 근무내역등록 시간외, 그리드 수정시 기준일 
	public Long updateDlgn0210Grid(List<Dlgn0210DTO> listDlgn0210Dto ) throws MSFException {
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0210Grid";
		
		String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
	 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try {  
            
            if  (MSFSharedUtils.paramNull(dlgn0100Dao)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0100Dao = (Dlgn0100DAO) wac.getBean("dlgn0100DAO" ); 
            }
            
            if  (MSFSharedUtils.paramNull(dlgn0200Dao)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0200Dao = (Dlgn0200DAO) wac.getBean("dlgn0200DAO" ); 
            }
            
//           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
//                
//                WebApplicationContext wac = WebApplicationContextUtils.
//                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
//            }
            
            if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
            }
            
            if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
            String rrnDecCrypt = "";
            for(int iPayrCnt=0;iPayrCnt < listDlgn0210Dto.size();iPayrCnt++) {
            	Dlgn0210DTO dlgn0210Dto = new Dlgn0210DTO();  
            	dlgn0210Dto = listDlgn0210Dto.get(iPayrCnt);
             
            	Dlgn0210VO dlgn0210Vo = new Dlgn0210VO(); 
            	
            	dlgn0210Vo.setIsmt(sessionUser.getUsrId());
            	dlgn0210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
    			
            	dlgn0210Vo.setDpobCd(dlgn0210Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
            	dlgn0210Vo.setSystemkey(dlgn0210Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
            	dlgn0210Vo.setPayCd(dlgn0210Dto.getPayCd());			/** column 급여구분 : payCd */
            	dlgn0210Vo.setDilnlazExceDutyYrMnth(dlgn0210Dto.getDilnlazExceDutyYrMnth().replaceAll("\\.",""));	/** column 근무년월 : detailYm */
            	dlgn0210Vo.setDilnlazApptnDt(dlgn0210Dto.getDilnlazApptnDt().replaceAll("\\.",""));		/** column 근태일자 : dilnlazApptnDt */
            	dlgn0210Vo.setDilnlazDutyStTm(dlgn0210Dto.getDilnlazDutyStTm());	/** column 시작시간 : dilnlazDutyStTm */
            	dlgn0210Vo.setDilnlazDutyEdTm(dlgn0210Dto.getDilnlazDutyEdTm());	/** column 종료시간 : dilnlazDutyEdTm */
            	dlgn0210Vo.setDilnlazTmRstDutyTm(dlgn0210Dto.getDilnlazTmRstDutyTm());		/** column 연장근무시간 : dilnlazTmRstDutyTm */
            	dlgn0210Vo.setDilnlazNtotTm(dlgn0210Dto.getDilnlazNtotTm());		/** column 야간근무시간 : dilnlazNtotTm */
            	dlgn0210Vo.setDilnlazHodyDutyTm(dlgn0210Dto.getDilnlazHodyDutyTm());		/** column 휴일근무시간 : dilnlazHodyDutyTm */
            	dlgn0210Vo.setDilnlazHodyNtotTm(dlgn0210Dto.getDilnlazHodyNtotTm());		/** column 휴일연장근무시간 : dilnlazHodyNtotTm */
            	
            	dlgn0210Vo.setEmymtDivCd(dlgn0210Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
            	dlgn0210Vo.setDeptCd(dlgn0210Dto.getDeptCd());    /** column 부서코드 : deptCd */
            	dlgn0210Vo.setBusinCd(dlgn0210Dto.getBusinCd());    /** column 사업코드 : businCd */
            	dlgn0210Vo.setTypOccuCd(dlgn0210Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
            	dlgn0210Vo.setDtilOccuInttnCd(dlgn0210Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
                
            	//TODO 임시로 입력한 근무시간에 대해서만 UPDATE 처리
            	/************************ 이전 신규 로직 ************************/
            	dlgn0210DAO.updateDlgn0210GridTm_02(dlgn0210Vo);
	           	dlgn0210DAO.updateDlgn0210Grid_Yn(dlgn0210Vo);   
	            	
//	         	dlgn0110DAO.updateDlgn0210GridDlgn0110(dlgn0210Vo);   /* 복무기준 재정의전 주석처리 */
	         	/************************ 이전 신규 로직 ************************/
            	
            	
            	/************************ 이전 신규 로직 ************************/
//            	dlgn0210DAO.updateDlgn0210Grid_02(dlgn0210Vo);
//	           	dlgn0210DAO.updateDlgn0210Grid_Yn(dlgn0210Vo);   
//	            	
//	         	dlgn0110DAO.updateDlgn0210GridDlgn0110(dlgn0210Vo); 
//	            	
//	            	
//	         		//TODO 안성시는 현재 휴일근무에 대해서 여태까지 점심시간을 합해서 지급했다고 합니다. 이번 임금협상시 이에 대해 다시 체결한다고 하였으며
//	            	// 5월분까지에 대해서는 휴일근무에 대해서 점심시간을 합해서 수당 지급한다고 합니다.
////	           		dlgn0210DAO.updateDlgn0210Grid_LunchTm(dlgn0210Vo);
	            /************************ 이전 신규 로직 ************************/
	            	
            	
            	InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
				
				// 3.복호화
//				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0210Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//				dlgn0210Vo.setResnRegnNum(rrnDecCrypt);
//				
				infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
				infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		 
				infcDlgn0200Vo.setDpobCd(dlgn0210Vo.getDpobCd());	/** column 사업장코드 : dpobCd */
				infcDlgn0200Vo.setSystemkey(dlgn0210Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0210Vo.getDilnlazExceDutyYrMnth());    /** column 근태년월 : dilnlazYrMnth */
				infcDlgn0200Vo.setPayCd(dlgn0210Vo.getPayCd());	/** column 급여구분코드 : payCd */
				infcDlgn0200Vo.setEmymtDivCd(dlgn0210Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
				infcDlgn0200Vo.setDeptCd(dlgn0210Vo.getDeptCd());	/** column 부서코드 : deptCd */
				infcDlgn0200Vo.setBusinCd(dlgn0210Vo.getBusinCd());    /** column 사업코드 : businCd */
				infcDlgn0200Vo.setTypOccuCd(dlgn0210Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
				infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0210Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
				
				
				if((detailYmKubn.compareTo(dlgn0210Vo.getDilnlazExceDutyYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
					
					/****************************************************************************************************
			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
			         ****************************************************************************************************/
					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
			        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
			        /****************************************************************************************************
			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
			         ****************************************************************************************************/
		        
				}else{ //기준일 후
					
					/****************************************************************************************************
					 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
					 ****************************************************************************************************/
						DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
					Long iResult = dlgnAdapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
					/****************************************************************************************************
					 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
					 ****************************************************************************************************/
				}
		        
            }
            
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//           MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
           
           iCnt = iCnt + 1; 
            
	    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","근무실적 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));  
	    
	    rtnData = 1L;
	} catch (Exception ex) {
	   // logger.error("EXCEPTION calling activityOnDlgn0250(): "+ex); 
	    
	   // result = new Long(0);
	   // throw MSFServerUtils.getOperationException("activityOnDlgn0250", ex, logger);
		 ex.printStackTrace();   
		   ShowMessageBM smBm = new ShowMessageBM();
		   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
		   smBm.setMenu("dlgn");
		   smBm.setPhase("[근무실적]에러");
		   smBm.setMessage(ex.getLocalizedMessage());
		   smBm.setContent(ex.getMessage());
		   bmResult.add(smBm);  
		   
		 /** 에러 로그 **/			
//		 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
		   ex.printStackTrace();
			rtnData = 0L;
			throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
	}finally {
        
      }
	
	return rtnData;
	
}
	
	
	//TODO 근무내역등록 시간외, 그리드 수정시 기준일 후 기준일 전
		public Long updateDlgn0210GridPre(List<Dlgn0210DTO> listDlgn0210Dto ) throws MSFException {
			Long rtnData = 0L;
			Long result = new Long(0);
	        Long iCnt = new Long(0);
	        PagingLoadResult<ShowMessageBM> retval = null;
	        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	        
			String method = calledClass + ".updateDlgn0210Grid";
			
			String windowNm = "시간외근무관리";
			String windowId = "DLGN0200";
			 
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {  
	            
	            if  (MSFSharedUtils.paramNull(dlgn0100Dao)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                dlgn0100Dao = (Dlgn0100DAO) wac.getBean("dlgn0100DAO" ); 
	            }
	            
	            if  (MSFSharedUtils.paramNull(dlgn0200Dao)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                dlgn0200Dao = (Dlgn0200DAO) wac.getBean("dlgn0200DAO" ); 
	            }
	            
//	           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
//	                
//	                WebApplicationContext wac = WebApplicationContextUtils.
//	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	//
//	                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
//	            }
	            
	            if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
	            }
	            
	            if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
	            }
	            String rrnDecCrypt = "";
	            for(int iPayrCnt=0;iPayrCnt < listDlgn0210Dto.size();iPayrCnt++) {
	            	Dlgn0210DTO dlgn0210Dto = new Dlgn0210DTO();  
	            	dlgn0210Dto = listDlgn0210Dto.get(iPayrCnt);
	             
	            	Dlgn0210VO dlgn0210Vo = new Dlgn0210VO(); 
	            	
	            	dlgn0210Vo.setIsmt(sessionUser.getUsrId());
	            	dlgn0210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
	    			
	            	dlgn0210Vo.setDpobCd(dlgn0210Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	            	dlgn0210Vo.setSystemkey(dlgn0210Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	            	dlgn0210Vo.setPayCd(dlgn0210Dto.getPayCd());			/** column 급여구분 : payCd */
	            	dlgn0210Vo.setDilnlazExceDutyYrMnth(dlgn0210Dto.getDilnlazExceDutyYrMnth().replaceAll("\\.",""));	/** column 근무년월 : detailYm */
	            	dlgn0210Vo.setDilnlazApptnDt(dlgn0210Dto.getDilnlazApptnDt().replaceAll("\\.",""));		/** column 근태일자 : dilnlazApptnDt */
	            	dlgn0210Vo.setDilnlazDutyStTm(dlgn0210Dto.getDilnlazDutyStTm());	/** column 시작시간 : dilnlazDutyStTm */
	            	dlgn0210Vo.setDilnlazDutyEdTm(dlgn0210Dto.getDilnlazDutyEdTm());	/** column 종료시간 : dilnlazDutyEdTm */
	            	dlgn0210Vo.setDilnlazTmRstDutyTm(dlgn0210Dto.getDilnlazTmRstDutyTm());		/** column 연장근무시간 : dilnlazTmRstDutyTm */
	            	dlgn0210Vo.setDilnlazNtotTm(dlgn0210Dto.getDilnlazNtotTm());		/** column 야간근무시간 : dilnlazNtotTm */
	            	dlgn0210Vo.setDilnlazHodyDutyTm(dlgn0210Dto.getDilnlazHodyDutyTm());		/** column 휴일근무시간 : dilnlazHodyDutyTm */
	            	dlgn0210Vo.setDilnlazHodyNtotTm(dlgn0210Dto.getDilnlazHodyNtotTm());		/** column 휴일연장근무시간 : dilnlazHodyNtotTm */
	            	
	            	dlgn0210Vo.setEmymtDivCd(dlgn0210Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
	            	dlgn0210Vo.setDeptCd(dlgn0210Dto.getDeptCd());    /** column 부서코드 : deptCd */
	            	dlgn0210Vo.setBusinCd(dlgn0210Dto.getBusinCd());    /** column 사업코드 : businCd */
	            	dlgn0210Vo.setTypOccuCd(dlgn0210Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
	            	dlgn0210Vo.setDtilOccuInttnCd(dlgn0210Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
	                
	            	dlgn0210DAO.updateDlgn0210Grid_02Pre(dlgn0210Vo);
	            	
	            	InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
					
					// 3.복호화
//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0210Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					dlgn0210Vo.setResnRegnNum(rrnDecCrypt);
//					
					infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
					infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			 
					infcDlgn0200Vo.setDpobCd(dlgn0210Vo.getDpobCd());	/** column 사업장코드 : dpobCd */
					infcDlgn0200Vo.setSystemkey(dlgn0210Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
					infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0210Vo.getDilnlazExceDutyYrMnth());    /** column 근태년월 : dilnlazYrMnth */
					infcDlgn0200Vo.setPayCd(dlgn0210Vo.getPayCd());	/** column 급여구분코드 : payCd */
					infcDlgn0200Vo.setEmymtDivCd(dlgn0210Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
					infcDlgn0200Vo.setDeptCd(dlgn0210Vo.getDeptCd());	/** column 부서코드 : deptCd */
					infcDlgn0200Vo.setBusinCd(dlgn0210Vo.getBusinCd());    /** column 사업코드 : businCd */
					infcDlgn0200Vo.setTypOccuCd(dlgn0210Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
					infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0210Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
					
					
					if((detailYmKubn.compareTo(dlgn0210Vo.getDilnlazExceDutyYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
						
						/****************************************************************************************************
				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
				         ****************************************************************************************************/
						DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
				        Long iResult = dlgnAdapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
				        /****************************************************************************************************
				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
				         ****************************************************************************************************/
			        
					}else{ //기준일 후
						
						/****************************************************************************************************
						 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
							DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
						Long iResult = dlgnAdapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
						/****************************************************************************************************
						 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
					}
			        
	            }
	            
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
//	           MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
	           
	           iCnt = iCnt + 1; 
	            
		    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","근무실적 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));  
		    rtnData = 1L;
		} catch (Exception ex) {
		   // logger.error("EXCEPTION calling activityOnDlgn0250(): "+ex); 
		    
		   // result = new Long(0);
		   // throw MSFServerUtils.getOperationException("activityOnDlgn0250", ex, logger);
			 ex.printStackTrace();   
			   ShowMessageBM smBm = new ShowMessageBM();
			   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			   smBm.setMenu("dlgn");
			   smBm.setPhase("[근무실적]에러");
			   smBm.setMessage(ex.getLocalizedMessage());
			   smBm.setContent(ex.getMessage());
			   bmResult.add(smBm);  
			   
			 /** 에러 로그 **/			
//			 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
			   ex.printStackTrace();
				rtnData = 0L;
				throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
		}finally {
	        
	      }
		
		return rtnData;
		
	}
		
}