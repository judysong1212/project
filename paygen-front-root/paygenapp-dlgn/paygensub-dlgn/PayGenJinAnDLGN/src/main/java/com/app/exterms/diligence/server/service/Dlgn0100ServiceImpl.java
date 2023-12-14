package com.app.exterms.diligence.server.service;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.service.Dlgn0100Service;
import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0110DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110SrhVO;
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
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.pkg.listener.DlgnListenerAdapter;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.math.BigDecimal;


@Service("dlgn0100Service")
public class Dlgn0100ServiceImpl extends AbstractCustomServiceImpl implements Dlgn0100Service {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(Dlgn0100ServiceImpl.class);
	private static final String calledClass = Dlgn0100ServiceImpl.class.getName();
	

	private String detailYmKubn = DiligenceCommonConstants.JINAN_DLGN_DT_BUNGI;
//	private String detailYmKubn = "201703"; //복무관리 기준일
	
	@Resource(name="dlgn0100DAO")
	private Dlgn0100DAO dlgn0100Dao;
	
	@Resource(name="dlgn0200DAO")
	private Dlgn0200DAO dlgn0200Dao;
	
	@Resource(name="dlgn0110DAO")
	private Dlgn0110DAO dlgn0110DAO;
	
	@Resource(name="dlgn0210DAO")
	private Dlgn0210DAO dlgn0210DAO;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	/** 기본근무관리 - 근태관리대상자정보 **/
	public BaseListLoadResult<Dlgn0100DTO> searchWorkDayMemberInfo(BaseListLoadConfig config
																	, Dlgn0100DTO dtoParam) throws Exception {
		
		String method = calledClass + ".searchWorkDayMemberInfo";
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
		List<Dlgn0100DTO> returnValue = new ArrayList<Dlgn0100DTO>();
		List egovResultDataList = new ArrayList();
		Dlgn0100SrhVO dlgn0100SrhVO = new Dlgn0100SrhVO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		 	    
		dlgn0100SrhVO.setPayCd(MSFSharedUtils.allowNulls(dtoParam.getPayCd()));	//급여구분
		dlgn0100SrhVO.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dtoParam.getDilnlazYrMnth()));	//지급년월
		dlgn0100SrhVO.setHanNm(MSFSharedUtils.allowNulls(dtoParam.getHanNm()));					//성명
		
		
		// 2. 파라미터 보낼 때(암호화)
		dlgn0100SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dtoParam.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		
		//아래 권한부분에서 처리
//		List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
//		dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
//		dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
			
//			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서
		dlgn0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(dtoParam.getEmymtDivCd()));	//고용구분
		dlgn0100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(dtoParam.getBusinCd()));			//사업
			
//		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(dtoParam.getHdofcCodtnCd());  
//		dlgn0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);    
//		dlgn0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(dtoParam.getHdofcCodtnCd()));//재직코드
			
		List<String> lstTypOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())); 
		dlgn0100SrhVO.setTypOccuCdArr(lstTypOccuCd);  
		dlgn0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())));				//직종
			
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd())); 
		dlgn0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		dlgn0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()))); 	//직종세
			
			
		dlgn0100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장											
		dlgn0100SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	//단위기간 담당자 여부
//		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));	//단위기관
		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())) ;   //단위기관
		dlgn0100SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						//유저 아이디
		
		dlgn0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		dlgn0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()).replace(",", ""));
			         
		/******************************** 권한 ************************************************************************/
		  String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
		if ("FALSE".equals(chkDeptCd)) {
			dlgn0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(sessionUser.getDeptCd());  
          	dlgn0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
          	dlgn0100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
          } else {
				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())) || 
						dtoParam.getCurrAffnDeptCd().indexOf(dtoParam.getDeptCd()) != -1
						) { 
		//			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
		//			dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
		//			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
							
					dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())); // 단위기관
					dtoParam.setDeptCd("");
					dlgn0100SrhVO.setDeptCd("");
					List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  //부서
					dlgn0100SrhVO.setDeptCdArr(listDeptCd);  
						        
				}  else { 
					dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())); 
					dlgn0100SrhVO.setDeptCdArr(lsdeptCd);  
				}  
          }
//		 /**
//         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
//         */
//        if (dlgn0100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100SrhVO.getDeptCdAuth())) 
//    			|| MSFSharedUtils.allowNulls(dlgn0100SrhVO.getDeptCdAuth()).contains(dlgn0100SrhVO.getPayrMangDeptCd())
//    			) {
//        	
//        	dlgn0100SrhVO.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//          	 
//    	}  
		
		try{
			
//			dlgn0100SrhVO.setCurrAffnDeptCd(dtoParam.getCurrAffnDeptCd());
//			egovResultDataList = dlgn0100Dao.selectDlgn0100(dtoParam);
			egovResultDataList = dlgn0100Dao.selectDlgn0100(dlgn0100SrhVO);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Dlgn0100DTO dto = new Dlgn0100DTO();
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
		
		return new BaseListLoadResult<Dlgn0100DTO>(returnValue);
	}	
	
	
	
	
	
	
	/** 기본근무관리 - 근태관리대상자정보 **/
	public Dlgn0100DTO getMemberInfo(Dlgn0100DTO dtoParam) throws Exception {
		
		String method = calledClass + ".getMemberInfo";
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
		List egovResultDataList = new ArrayList();
		Dlgn0100SrhVO dlgn0100SrhVO = new Dlgn0100SrhVO();
		Dlgn0100DTO dto = new Dlgn0100DTO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		 	    
		dlgn0100SrhVO.setPayCd(MSFSharedUtils.allowNulls(dtoParam.getPayCd()));	//급여구분
		dlgn0100SrhVO.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dtoParam.getDilnlazYrMnth()));	//지급년월
		dlgn0100SrhVO.setHanNm(MSFSharedUtils.allowNulls(dtoParam.getHanNm()));					//성명
		dlgn0100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(dtoParam.getSystemkey()));
		
		
		// 2. 파라미터 보낼 때(암호화)
		dlgn0100SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dtoParam.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		
		//아래 권한부분에서 처리
//		List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
//		dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
//		dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
			
//			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서
		dlgn0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(dtoParam.getEmymtDivCd()));	//고용구분
		dlgn0100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(dtoParam.getBusinCd()));			//사업
			
//		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(dtoParam.getHdofcCodtnCd());  
//		dlgn0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);    
//		dlgn0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(dtoParam.getHdofcCodtnCd()));//재직코드
			
		List<String> lstTypOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())); 
		dlgn0100SrhVO.setTypOccuCdArr(lstTypOccuCd);  
		dlgn0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())));				//직종
			
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd())); 
		dlgn0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		dlgn0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()))); 	//직종세
			
			
		dlgn0100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장											
		dlgn0100SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	//단위기간 담당자 여부
//		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));	//단위기관
		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())) ;   //단위기관
		dlgn0100SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						//유저 아이디
		
		dlgn0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		dlgn0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()).replace(",", ""));
			         
		/******************************** 권한 ************************************************************************/
		  String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
		if ("FALSE".equals(chkDeptCd)) {
			dlgn0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(sessionUser.getDeptCd());  
          	dlgn0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
          	dlgn0100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
          } else {
				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())) || 
						dtoParam.getCurrAffnDeptCd().indexOf(dtoParam.getDeptCd()) != -1
						) { 
		//			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
		//			dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
		//			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
							
					dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())); // 단위기관
					dtoParam.setDeptCd("");
					dlgn0100SrhVO.setDeptCd("");
					List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  //부서
					dlgn0100SrhVO.setDeptCdArr(listDeptCd);  
						        
				}  else { 
					dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())); 
					dlgn0100SrhVO.setDeptCdArr(lsdeptCd);  
				}  
          }
		
		try{
			
			egovResultDataList = dlgn0100Dao.selectDlgn0100(dlgn0100SrhVO);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				dto = new Dlgn0100DTO();
				
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					
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
		
		return dto;
	}	
	
	
		
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Dlgn0100DTO> getMemberWorkTimeInfo(
			BaseListLoadConfig config, Dlgn0100DTO dtoParam) throws Exception {
		
		String method = calledClass + ".getMemberWorkTimeInfo";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		List<Dlgn0100DTO> returnValue = new ArrayList<Dlgn0100DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		// 2. 파라미터 보낼 때(암호화)
		dtoParam.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dtoParam.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		try{
			egovResultDataList = dlgn0100Dao.selectDlgn0110(dtoParam);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Dlgn0100DTO dto = new Dlgn0100DTO();
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
					
					dto.setDilnlazAbnceYnboolean("Y".equals(tempMap.get("dilnlazAbnceYn")) ? true : false);
					dto.setDilnlazLvsgYnboolean("Y".equals(tempMap.get("dilnlazLvsgYn")) ? true : false);
					dto.setDilnlazSckleaYnboolean("Y".equals(tempMap.get("dilnlazSckleaYn")) ? true : false);
					dto.setDilnlazOffvaYnboolean("Y".equals(tempMap.get("dilnlazOffvaYn")) ? true : false);
					dto.setDilnlazFmlyEvntYnboolean("Y".equals(tempMap.get("dilnlazFmlyEvntYn")) ? true : false);	/** set 근태_경조사여부 : dilnlazFmlyEvntYnboolean */
					dto.setDilnlazHlthCreYnboolean("Y".equals(tempMap.get("dilnlazHlthCreYn")) ? true : false);
					
					dto.setDilnlazAbnceDutyRcgtnYnboolean("Y".equals(tempMap.get("dilnlazAbnceDutyRcgtnYn")) ? true : false);/** set 근태_결근여부 : dilnlazAbnceYnboolean */
					dto.setDilnlazSpclHodyYnboolean("Y".equals(tempMap.get("dilnlazSpclHodyYn")) ? true : false);	/** set 근태_연가여부 : dilnlazLvsgYnboolean */
					dto.setDilnlazTfcAssCstYnBoolean("Y".equals(tempMap.get("dilnlazTfcAssCstYn")) ? true : false);	/** set 근태_병가여부 : dilnlazSckleaYnboolean */
					dto.setDilnlazLnchYnBoolean("Y".equals(tempMap.get("dilnlazLnchYn")) ? true : false);	/** set 근태_공가여부 : dilnlazOffvaYnboolean */
//					dto.setDilnlazHodyYnboolean("Y".equals(tempMap.get("dilnlazHodyYn")) ? true : false);	/** set 근태_보건여부 : dilnlazHlthCreYnboolean */
					dto.setDilnlazDutyYnBoolean("Y".equals(tempMap.get("dilnlazDutyYn")) ? true : false);	/** set 근태_근무여부 : dilnlazDutyYnBoolean */
					
					dto.setDilnlazWklyHldyNumDys(dtoParam.getDilnlazWklyHldyNumDys());
					
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
			
		
		return new BaseListLoadResult<Dlgn0100DTO>(returnValue);
	}

	@Override
	/** 기본 근무 관리 근태 생성**/
	public PagingLoadResult<ShowMessageBM>  generateWorkTime(Dlgn0100DTO dto) throws MSFException {
		
			String method = calledClass + ".generateWorkTime";
			
		
			Long result = new Long(0);
	        Long iCnt = new Long(0);
	        PagingLoadResult<ShowMessageBM> retval = null;
	        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	        
			String windowNm = "기본근무관리";
			String windowId = "DLGN0100";
		
			MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		   	List<String> listDeptCd = new ArrayList<String>();
		   	
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			// 2. 파라미터 보낼 때(암호화)
			dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		   	
		   	try{ 
		   		
		   		
				dto.setIsmt(sessionUser.getUsrId());
				dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				/** 조건절 */
				dto.setDpobCd(sessionUser.getDpobCd()); 
				dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
				dto.setUsrId(sessionUser.getUsrId());  
				
				// TODO 테스트
//				dto.setDeptCd(dto.getDeptCd());
				
				dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가
		        dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd()).replace(",", ""));
		         
		        dto.setSystemkey(MSFSharedUtils.allowNulls(dto.getSystemkey()));
		        
		        // 시스템 키가 없을 경우 일괄처리(lump), 있으면 개별처리(individ)
		        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
		        if("".equals(dto.getSystemkey())  || dto.getSystemkey() == null) {
		        	dto.setCreateFlag("lump");		//일괄
		        }else {
		        	dto.setCreateFlag("individ");	//개별
		        }
				/******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	dto.setDeptCd(sessionUser.getDeptCd()); 
	            	listDeptCd = SmrmfUtils.getStrToArrayList(dto.getDeptCd());  
	        		dto.setDeptCdArr(listDeptCd);     //부서코드  
	            	dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	
	            	if (dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dto.getDeptCd())) 
	            			|| MSFSharedUtils.allowNulls(dto.getDeptCd()).contains(dto.getPayrMangDeptCd())
	            			) {
	            		dto.setDeptCdArr(null);     //부서코드 
	            		dto.setDeptCd("");  //부서코드
	            	} else {
	            		listDeptCd = SmrmfUtils.getStrToArrayList(dto.getDeptCd());  
	            		dto.setDeptCdArr(listDeptCd);     //부서코드 
	            	}
		          
	            }
	            
//	            /**
//		         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
//		         */
//	            if (dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dto.getDeptCdAuth())) 
//	        			|| MSFSharedUtils.allowNulls(dto.getDeptCdAuth()).contains(dto.getPayrMangDeptCd())
//	        			) {
//	            	dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//	              	 
//	        	}  
	            
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dto.getTypOccuCd())); 
	            dto.setTypOccuCdArr(lstTypeOccuCd); 
	            dto.setTypOccuCd(MSFSharedUtils.allowNulls(dto.getTypOccuCd()));  //직종
	            
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd())); 
	            dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd())); //직종세 
	            
		       
	            /******************************** 권한 ************************************************************************/
	            
	            //삭제 인서트 처리를 위한 조건으로 가지고 와서 인서트 처리 할것....로직  
	            /**
	             * 대상자 가져오기 
	             */
	            List list =   dlgn0100Dao.selectDlgn0100ToRtnData(dto); 
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	        
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	            
	                
	                dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
	                dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
			        dto.setDilnlazYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazYrMnth")))); //   DILNLAZ_YR_MNTH
			        dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
			        dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
			        dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
			        dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
			        dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
			        dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
			        dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
			        dto.setDilnlazDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
			        dto.setDilnlazDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
			        dto.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyNumDys"))));   // DILNLAZ_DUTY_NUM_DYS
			        dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN
			        dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazWklyHldyNumDys")))); // DILNLAZ_WKLY_HLDY_NUM_DYS
			        dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
			        dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
			        dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
			        dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
			        
			        
			        // 무기계약직 이면서 직종, 직종세 없을 경우 복무 로직 skip 처리
			        if( "A0020010".equals(dto.getEmymtDivCd()) && ( "".equals(dto.getTypOccuCd()) || "".equals(dto.getDtilOccuInttnCd()))) {
			        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","기본복무관리" ,"생성오류","대상자 : " + dto.getHanNm() + " 인사관리 -> 직종, 직종세 누락 확인")); 
			        }else {
			        
	                
	//		            /**
	//			         * TODO 김해 시청 기간제 근로자만 교통비, 급식비 Y 처리
	//			         */
	//			        if("A0020020".equals(dto.getEmymtDivCd())) {
	//			        	dto.setDilnlazTfcAssCstYn("Y");			// 근태_교통보조비여부
	//			        	dto.setDilnlazLnchYn("Y");				// 근태_급식비여부
	//			        	
	//			        }else {
				        	dto.setDilnlazTfcAssCstYn("N");			// 근태_교통보조비여부
				        	dto.setDilnlazLnchYn("N");				// 근태_급식비여부
	//			        }
				        
		                
		                 //삭제처리 후 
	//	                dlgn0100Dao.deleteDlgn0110(dto);
	//		            dlgn0100Dao.deleteDlgn0100(dto);  
		                
		                //인서트 처리 
	//		            dlgn0100Dao.`Dlgn0100(dto);
	//		            if((detailYmKubn.compareTo(dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
	//		            	//삭제처리 후 
	//		                dlgn0100Dao.deleteDlgn0110(dto);
	//			            dlgn0100Dao.deleteDlgn0100(dto);  
	//		                
	//		                //인서트 처리 
	//			            dlgn0100Dao.insertDlgn0100(dto);
	//		            	dlgn0100Dao.insertDlgn0110Pre(dto);
	//		            }else{ //기준일 후
			            	//삭제처리 후 
			                dlgn0100Dao.deleteDlgn0110(dto);
				            dlgn0100Dao.deleteDlgn0100(dto);  
			                
			                //인서트 처리 
				            dlgn0100Dao.insertDlgn0100(dto);
			            	dlgn0100Dao.insertDlgn0110(dto);
	//		            }
		            
						
						InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
						
						// 3.복호화
	//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	//					infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
						
						infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
						infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				 
				        infcDlgn0100Vo.setDpobCd(dto.getDpobCd());						/** column 사업장코드 : dpobCd */
						infcDlgn0100Vo.setSystemkey(dto.getSystemkey());				/** column SYSTEMKEY : systemkey */
						infcDlgn0100Vo.setDilnlazYrMnth(dto.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
						infcDlgn0100Vo.setPayCd(dto.getPayCd());    					/** column 급여구분코드 : payCd */
						infcDlgn0100Vo.setEmymtDivCd(dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
						infcDlgn0100Vo.setDeptCd(dto.getDeptCd());						/** column 부서코드 : deptCd */
						infcDlgn0100Vo.setBusinCd(dto.getBusinCd());					/** column 사업코드 : businCd */
						infcDlgn0100Vo.setTypOccuCd(dto.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
						infcDlgn0100Vo.setPyspGrdeCd(dto.getPyspGrdeCd());    			/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
						infcDlgn0100Vo.setDtilOccuInttnCd(dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
						infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dto.getDilnlazWklyHldyNumDys()); //주휴일수
						//System.out.println("infcDlgn0100Vo.getDilnlazWklyHldyNumDys()>> "+infcDlgn0100Vo.getDilnlazWklyHldyNumDys());
	//					if((detailYmKubn.compareTo(dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
	//						
	//					/****************************************************************************************************
	//			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
	//			         ****************************************************************************************************/
	//					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
	//			        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
	//			        /****************************************************************************************************
	//			         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
	//			         ****************************************************************************************************/
	//					}else{
							/****************************************************************************************************
							 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
							 ****************************************************************************************************/
								DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
							Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
							/****************************************************************************************************
							 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
							 ****************************************************************************************************/
	//					}
				        iCnt = iCnt + 1;
				        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본복무관리" ,"생성완료","대상자 : " + dto.getHanNm())); 
				        
			        }
	            }   
	          
				
	//			List<Dlgn0100DTO> list = new ArrayList<Dlgn0100DTO>();
				
				//List list = new ArrayList();
				
				
//				list = dlgn0100Dao.afterSelectDlgn0100(dto);
//				
//				if(list != null && list.size() > 0){
//					for(int i = 0; i < list.size(); i++){
//						
//	//					Dlgn0100DTO dlgn0100Dto = list.get(i);
//						
//						Dlgn0100DTO dlgn0100Dto = new Dlgn0100DTO();
//						
//						// 2.복호화 리턴받을 값 선언
//						String rrnDecCrypt = "";
//						
//						Map tempMap = (Map) list.get(i);
//						Iterator<String> keys = tempMap.keySet().iterator();
//						while(keys.hasNext() ){
//				            String key = keys.next();
//				            //형 타입이 숫자형일경우 형변환 해준다.
//			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//			            		dlgn0100Dto.set(key, String.valueOf(tempMap.get(key)));
//			            	}else{
//			            		dlgn0100Dto.set(key, tempMap.get(key));
//			            	}
//			            }
						
					
	//				}  
	//	        }
				
				 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무 생성" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 ")); 
				 
				 retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
				 
		   	}catch(Exception e) {
		   		e.printStackTrace();
		   		
		   		/** 에러 로그 **/			
		   		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:D",e, windowNm , windowId);
		   		throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "근태 생성 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
		   	}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D");
			
		return retval;
	}

	/**기본복무관리 저장 처리**/
	@Override
	public int saveWorkTime(List<Dlgn0100DTO> list) throws Exception {
		int updateCnt = 0;
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveWorkTime";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	
		InfcPkgDlgn0100VO infcDlgn0100Vo = new  InfcPkgDlgn0100VO();
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
		try{
			
			if(list != null && list.size() > 0){
				//주휴일수 계산
				int useDilnlazWklyHldyNumDys = 0;
				String preUseDilnlazWklyHldyNumDys = "";
				Calendar preCal = Calendar.getInstance();
				Calendar nowCal = Calendar.getInstance();
				boolean inptWklyHldyNumDys = false;
				String inptDilnlazWklyHldyNumDys = "";
				int useWeekCnt = 0;
				// 주휴일수 계산 끝
				
				// 2.복호화 리턴받을 값 선언
				String rrnDecCrypt = "";

				
				
				for(int i = 0; i < list.size(); i++){
					Dlgn0100DTO dto = list.get(i);
					dto.setIsmt(sessionUser.getUsrId());
					dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					dto.setDilnlazAbnceYn(dto.getDilnlazAbnceYnboolean() ? "Y" : "N");
					dto.setDilnlazLvsgYn(dto.getDilnlazLvsgYnboolean() ? "Y" : "N");
					dto.setDilnlazSckleaYn(dto.getDilnlazSckleaYnboolean() ? "Y" : "N");
					dto.setDilnlazOffvaYn(dto.getDilnlazOffvaYnboolean() ? "Y" : "N");
					dto.setDilnlazFmlyEvntYn(dto.getDilnlazFmlyEvntYnboolean() ? "Y" : "N");
					dto.setDilnlazHlthCreYn(dto.getDilnlazHlthCreYnboolean() ? "Y" : "N");
					dto.setDilnlazAbnceDutyRcgtnYn(dto.getDilnlazAbnceDutyRcgtnYnboolean() ? "Y" : "N");
					dto.setDilnlazSpclHodyYn(dto.getDilnlazSpclHodyYnboolean() ? "Y" : "N");
					dto.setDilnlazTfcAssCstYn(dto.getDilnlazTfcAssCstYnBoolean() ? "Y" : "N");				
					dto.setDilnlazLnchYn(dto.getDilnlazLnchYnBoolean() ? "Y" : "N");
	//				dto.setDilnlazHodyYn(dto.getDilnlazHodyYnboolean() ? "Y" : "N");
					dto.setDilnlazDutyYn(dto.getDilnlazDutyYnBoolean() ? "Y" : "N");	//근무
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					//주휴일수 계산 시작 
					if( !dto.getInptDilnlazWklyHldyNumDys().equals(dto.getDilnlazWklyHldyNumDys()) ){
						inptWklyHldyNumDys = true;
						inptDilnlazWklyHldyNumDys = dto.getInptDilnlazWklyHldyNumDys();
					}
					
					//System.out.println("useDilnlazWklyHldyNumDys> "+useDilnlazWklyHldyNumDys);
					if (dto.getDilnlazAbnceYnboolean()) { //결근 선택시
						if(useDilnlazWklyHldyNumDys ==0) {
							useDilnlazWklyHldyNumDys = 1;
							preUseDilnlazWklyHldyNumDys = dto.getDilnlazApptnDt().replace(".", "");
						}
						//결근 선택 주차 계산
						preCal.set ( Integer.parseInt(preUseDilnlazWklyHldyNumDys.substring(0,4)), Integer.parseInt(preUseDilnlazWklyHldyNumDys.substring(4,6)), Integer.parseInt(preUseDilnlazWklyHldyNumDys.substring(6,8)) );
						int preWeek = preCal.get(Calendar.WEEK_OF_YEAR);
						nowCal.set ( Integer.parseInt( dto.getDilnlazApptnDt().replace(".", "").substring(0,4) ) , Integer.parseInt( dto.getDilnlazApptnDt().replace(".", "").substring(4,6) ), Integer.parseInt( dto.getDilnlazApptnDt().replace(".", "").substring(6,8) ) );
						int nowWeek = nowCal.get(Calendar.WEEK_OF_YEAR);
						
						//기존 휴일수 체크주 확인
						Dlgn0110SrhVO dlgn0110SrhVO = new Dlgn0110SrhVO();
						dlgn0110SrhVO.setSystemkey(MSFSharedUtils.allowNulls(dto.getSystemkey()));	 //systemkey
						dlgn0110SrhVO.setDilnlazApptnDt(dto.getDilnlazApptnDt().replace(".", ""));	//급여구분
						useWeekCnt = dlgn0100Dao.selectDlgn0110WklyHldyCnt(dlgn0110SrhVO);
						//System.out.println("useWeekCnt> "+useWeekCnt);
						if ( useWeekCnt>0 ) useDilnlazWklyHldyNumDys=0;
						
						if ( Integer.parseInt((dto.getDilnlazApptnDt()).replace(".", "")) >= Integer.parseInt(preUseDilnlazWklyHldyNumDys) && nowWeek > preWeek && i > 0 && useWeekCnt < 1) {
							// 결근 선택일이 이전 결근일보다 크고 이전 결근일의 주에 에 속하지 않으면..
							// +기존 휴일체크 주차가 없으면
							preUseDilnlazWklyHldyNumDys = dto.getDilnlazApptnDt().replace(".", "");
							useDilnlazWklyHldyNumDys++;
						}
						
						//System.out.println("useDilnlazWklyHldyNumDys2> "+useDilnlazWklyHldyNumDys);
					}
					//주휴일수 계산 끝
					
					updateCnt += dlgn0100Dao.updateDlgn0110(dto);
					
					infcDlgn0100Vo.setDpobCd(dto.getDpobCd());    				/** column 사업장코드 : dpobCd */
					infcDlgn0100Vo.setSystemkey(dto.getSystemkey());    		/** column SYSTEMKEY : systemkey */
					infcDlgn0100Vo.setDilnlazYrMnth(dto.getDilnlazYrMnth());    /** column 근태년월 : dilnlazYrMnth */
					infcDlgn0100Vo.setPayCd(dto.getPayCd());    				/** column 급여구분코드 : payCd */
					infcDlgn0100Vo.setEmymtDivCd(dto.getEmymtDivCd());    		/** column 고용구분코드 : emymtDivCd */
					infcDlgn0100Vo.setDeptCd(dto.getDeptCd());    				/** column 부서코드 : deptCd */
					infcDlgn0100Vo.setBusinCd(dto.getBusinCd());    			/** column 사업코드 : businCd */
					infcDlgn0100Vo.setTypOccuCd(dto.getTypOccuCd());    		/** column 직종코드 : typOccuCd */
					//infcDlgn0100Vo.setPyspGrdeCd("");    /** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
					infcDlgn0100Vo.setDtilOccuInttnCd(dto.getDtilOccuInttnCd());/** column 직종세구분코드 : dtilOccuInttnCd */
					infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dto.getDilnlazWklyHldyNumDys()); //주휴일수
					
	//				infcDlgn0100Vo.setDilnlazDutyBgnnDt(record.get("dilnlazDutyBgnnDt"));    /** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
	//				infcDlgn0100Vo.setDilnlazDutyEndDt(record.get("dilnlazDutyEndDt"));    /** column 근태_근무종료일자 : dilnlazDutyEndDt */
	//				infcDlgn0100Vo.setDilnlazDutyNumDys(record.get("dilnlazDutyNumDys"));    /** column 근태_근무일수 : dilnlazDutyNumDys */
	//				infcDlgn0100Vo.setDilnlazLvsgNumDys(record.get("dilnlazLvsgNumDys"));    /** column 근태_연가일수 : dilnlazLvsgNumDys */
	//				infcDlgn0100Vo.setDilnlazAbnceNumDys(record.get("dilnlazAbnceNumDys"));    /** column 근태_결근일수 : dilnlazAbnceNumDys */
	//				infcDlgn0100Vo.setDilnlazSckleaNumDys(record.get("dilnlazSckleaNumDys"));    /** column 근태_병가일수 : dilnlazSckleaNumDys */
	//				infcDlgn0100Vo.setDilnlazOffvaNumDys(record.get("dilnlazOffvaNumDys"));    /** column 근태_공가일수 : dilnlazOffvaNumDys */
	//				infcDlgn0100Vo.setDilnlazFmlyEvntNumDys(record.get("dilnlazFmlyEvntNumDys"));    /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
	//				infcDlgn0100Vo.setDilnlazHlthCreNumDys(record.get("dilnlazHlthCreNumDys"));    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
	//				infcDlgn0100Vo.setDilnlazTotDutyNumDys(record.get("dilnlazTotDutyNumDys"));    /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
	//				infcDlgn0100Vo.setDilnlazWklyHldyNumDys(record.get("dilnlazWklyHldyNumDys"));    /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
	//				infcDlgn0100Vo.setDilnlazPaidPubcHodyNum(record.get("dilnlazPaidPubcHodyNum"));    /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
	//				infcDlgn0100Vo.setDilnlazDdlnePrcsYn(record.get("dilnlazDdlnePrcsYn"));    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
	//				infcDlgn0100Vo.setDilnlazNoteCtnt(record.get("dilnlazNoteCtnt"));    /** column 근태_비고내용 : dilnlazNoteCtnt */
	//				infcDlgn0100Vo.setKybdr(record.get("kybdr"));    /** column 입력자 : kybdr */
	//				infcDlgn0100Vo.setInptDt(record.get("inptDt"));    /** column 입력일자 : inptDt */
	//				infcDlgn0100Vo.setInptAddr(record.get("inptAddr"));    /** column 입력주소 : inptAddr */
	//				infcDlgn0100Vo.setIsmt(record.get("ismt"));    /** column 수정자 : ismt */
	//				infcDlgn0100Vo.setRevnDt(record.get("revnDt"));    /** column 수정일자 : revnDt */
	//				infcDlgn0100Vo.setRevnAddr(record.get("revnAddr"));    /** column 수정주소 : revnAddr */
	//				infcDlgn0100Vo.setDilnlazSpclHodyNumDys(record.get("dilnlazSpclHodyNumDys"));    /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
	//				infcDlgn0100Vo.setDilnlazSatDutyNumDys(record.get("dilnlazSatDutyNumDys"));    /** column 총토요근무일수 : dilnlazSatDutyNumDys */
	//				infcDlgn0100Vo.setDilnlazPubcHodyDutyNumDys(record.get("dilnlazPubcHodyDutyNumDys"));    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
	//				infcDlgn0100Vo.setDilnlazAbnceDutyRcgtnDys(record.get("dilnlazAbnceDutyRcgtnDys"));    /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */ 
	//				infcDlgn0100Vo.setDilnlazTotDutyTm(record.get("dilnlazTotDutyTm"));    /** column 근태_총근무시간 : dilnlazTotDutyTm */
				}
				
				int finWklyHldyNumDys = Integer.parseInt(infcDlgn0100Vo.getDilnlazWklyHldyNumDys()) - useDilnlazWklyHldyNumDys ;
				if ( finWklyHldyNumDys < 0 ) finWklyHldyNumDys = 0;
				String finDilnlazWklyHldyNumDys = finWklyHldyNumDys + "";
				
				//System.out.println("finDilnlazWklyHldyNumDys1> "+finDilnlazWklyHldyNumDys);
				if( inptWklyHldyNumDys ){ //입력받은 휴일수와 계산된 휴일수가 다르면 입력받은 휴일수로 저장
					finDilnlazWklyHldyNumDys = inptDilnlazWklyHldyNumDys;
				}
				//System.out.println("finDilnlazWklyHldyNumDys2> "+finDilnlazWklyHldyNumDys);
				
				infcDlgn0100Vo.setDilnlazWklyHldyNumDys(finDilnlazWklyHldyNumDys);
				//System.out.println("infcDlgn0100Vo.getDilnlazWklyHldyNumDys>>> "+infcDlgn0100Vo.getDilnlazWklyHldyNumDys());
				/****************************************************************************************************
				 * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
				 ****************************************************************************************************/
				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter(); 
				
				Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
				
				/****************************************************************************************************
	             * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
	             ****************************************************************************************************/
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
		
		return updateCnt;
	}

	@Override
	public int deleteWorkTime(List<Dlgn0100DTO> list) throws Exception {
		int deleteCnt = 0;
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				Dlgn0100DTO dto = list.get(i); 
				Dlgn0200DTO dtoDlgn0200  = new Dlgn0200DTO();
				
				dtoDlgn0200.setDpobCd(dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
				dtoDlgn0200.setSystemkey(dto.getSystemkey());    				/** column SYSTEMKEY : systemkey */
				dtoDlgn0200.setDilnlazExceDutyYrMnth(dto.getDilnlazYrMnth());	/** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
				dtoDlgn0200.setPayCd(dto.getPayCd());    						/** column 급여구분코드 : payCd */
				
				dlgn0200Dao.deleteDlgn0210_S(dtoDlgn0200);
				deleteCnt += dlgn0200Dao.deleteDlgn0200_S(dtoDlgn0200); 
				
				dlgn0100Dao.deleteDlgn0110_S(dto);
				deleteCnt += dlgn0100Dao.deleteDlgn0100_S(dto); 
			}
		}
		return deleteCnt;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BaseModel> getPayrMangDeptCd(Dlgn0100DTO dto) throws Exception {
		
		String method = calledClass + ".getPayrMangDeptCd";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		// 2. 파라미터 보낼 때(암호화)
		dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		dto.setDpobCd(sessionUser.getDpobCd());
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			egovResultDataList = dlgn0100Dao.getPayrMangDeptCd(dto);
			

			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
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
					

					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);

					
					returnValue.add(bm);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"s",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnValue;
	}
	
	//Dlgn근무내역등록 그리드 조회
	
	public PagingLoadResult<BaseModel> getDlgn0100List_01(ServiceParameters serviceParameters) throws MSFException {
		
        PagingLoadResult<BaseModel> retval = null;
        String method = calledClass + ".getPayrMangDeptCd";
        String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
        //        String method =  CLASS_DLGN0100LIST_01;
        Dlgn0100SrhVO   dlgn0100SrhVO = new Dlgn0100SrhVO(); 
        Dlgn0110SrhVO   dlgn0110SrhVO = new Dlgn0110SrhVO();
        Dlgn0100VO dlgn0200VO = new Dlgn0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
	      if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
	      
	          WebApplicationContext wac = WebApplicationContextUtils.
	                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	          dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
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
            dlgn0110SrhVO.setDpobCd(sessionUser.getDpobCd());
            dlgn0110SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); //고용구분코드
            dlgn0110SrhVO.setDilnlazYrMnth(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailYm"), "")); //근태년월
            dlgn0110SrhVO.setHanNm(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailName"), "")); //성명
            dlgn0110SrhVO.setDilnlazDutyBgnnDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtBgnnDt"), "")); //시작일자
            dlgn0110SrhVO.setDilnlazDutyEndDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtEndDt"), "")); //종료일자
            dlgn0110SrhVO.setSystemkey(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"), "")); //시스템키
            dlgn0110SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드
//            //Get total record count //전체 데이터 갯수를 가지고 온다.
	         if ( pagingValues.executeRecordCount ) {
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
//                int iResultCnt = 0 ;
                int iResultCnt = dlgn0110DAO.selectDlgn0100ListTotCnt(dlgn0110SrhVO);
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginDlgn0100DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            dlgn0110SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	dlgn0110SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	dlgn0110SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = dlgn0110DAO.selectDlgn0100List(dlgn0110SrhVO);
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
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0100DataList, "getDlgn0100List_01");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
        	/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"s",ex, windowNm , windowId);
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }
        
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        return retval;
    }
	//기본근무관리 근무내역등록 그리드 수정(기준일 후)
	public Long updateDlgn0110Grid(List<Dlgn0110DTO> listDlgn0110Dto ) throws MSFException {
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0110Grid";
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
	 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
           
           if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
               
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

               dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
           }
            
            String rrnDecCrypt = "";
            for(int iPayrCnt=0; iPayrCnt < listDlgn0110Dto.size();iPayrCnt++) {
            	
            	Dlgn0110DTO dlgn0110Dto = new Dlgn0110DTO();
            	dlgn0110Dto = listDlgn0110Dto.get(iPayrCnt);
            	
            	dlgn0110Dto.setIsmt(sessionUser.getUsrId());
            	dlgn0110Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
            	
            	dlgn0110Dto.setPayCd(dlgn0110Dto.getPayCd());
            	dlgn0110Dto.setSystemkey(dlgn0110Dto.getSystemkey());
            	dlgn0110Dto.setDpobCd(dlgn0110Dto.getDpobCd());
            	
            	dlgn0110Dto.setDilnlazYrMnth(dlgn0110Dto.getDilnlazYrMnth().replaceAll("\\.", ""));
            	dlgn0110Dto.setDilnlazApptnDt(dlgn0110Dto.getDilnlazApptnDt().replaceAll("\\.", ""));
            	dlgn0110Dto.setDilnlazDutyTm(dlgn0110Dto.getDilnlazDutyTm());
            	dlgn0110Dto.setDilnlazWklyHldyNumDys(dlgn0110Dto.getDilnlazWklyHldyNumDys()); // DILNLAZ_WKLY_HLDY_NUM_DYS
            	dlgn0110Dto.setDilnlazEtcDivCd(dlgn0110Dto.getDilnlazEtcDivCd());
            	dlgn0110Dto.setEmymtDivCd(dlgn0110Dto.getEmymtDivCd());
            	
            	if("true".equals(dlgn0110Dto.getDilnlazDutyYn())){
            		dlgn0110Dto.setDilnlazDutyYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazDutyYn("N");
            	}
//            	dlgn0110Dto.setDilnlazDutyYn(dlgn0110Dto.getDilnlazDutyYn()); //근무
            	if("true".equals(dlgn0110Dto.getDilnlazAbnceYn())){
            		dlgn0110Dto.setDilnlazAbnceYn("Y");
            		
            		// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
            		if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
            			dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("Y");
            			dlgn0110Dto.setDilnlazEtcDivCd("N0010010");	
            		}
            		
            	}else{
            		dlgn0110Dto.setDilnlazAbnceYn("N");
            		
            		// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
            		if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
            			dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("");
            			dlgn0110Dto.setDilnlazEtcDivCd("N0010000");	
            		}
            		
            	}
//            	dlgn0110Dto.setDilnlazAbnceYn(dlgn0110Dto.getDilnlazAbnceYn()); //결근
            	if("true".equals(dlgn0110Dto.getDilnlazLvsgYn())){
            		dlgn0110Dto.setDilnlazLvsgYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazLvsgYn("N");
            	}
//            	dlgn0110Dto.setDilnlazLvsgYn(dlgn0110Dto.getDilnlazLvsgYn()); //연차
            	if("true".equals(dlgn0110Dto.getDilnlazSpclHodyYn())){
            		dlgn0110Dto.setDilnlazSpclHodyYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazSpclHodyYn("N");
            	}
//            	dlgn0110Dto.setDilnlazSpclHodyYn(dlgn0110Dto.getDilnlazSpclHodyYn()); //특(휴)
            	if("true".equals(dlgn0110Dto.getDilnlazSckleaYn())){
            		dlgn0110Dto.setDilnlazSckleaYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazSckleaYn("N");
            	}            	
//            	dlgn0110Dto.setDilnlazSckleaYn(dlgn0110Dto.getDilnlazSckleaYn()); //병가
            	if("true".equals(dlgn0110Dto.getDilnlazOffvaYn())){
            		dlgn0110Dto.setDilnlazOffvaYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazOffvaYn("N");
            	} 
//            	dlgn0110Dto.setDilnlazOffvaYn(dlgn0110Dto.getDilnlazOffvaYn()); //공가
            	if("true".equals(dlgn0110Dto.getDilnlazFmlyEvntYn())){
            		dlgn0110Dto.setDilnlazFmlyEvntYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazFmlyEvntYn("N");
            	} 
//            	dlgn0110Dto.setDilnlazFmlyEvntYn(dlgn0110Dto.getDilnlazFmlyEvntYn()); //경조사
            	if("true".equals(dlgn0110Dto.getDilnlazHlthCreYn())){
            		dlgn0110Dto.setDilnlazHlthCreYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazHlthCreYn("N");
            	} 
//            	dlgn0110Dto.setDilnlazHlthCreYn(dlgn0110Dto.getDilnlazHlthCreYn()); //보건
            	
            	if("true".equals(dlgn0110Dto.getDilnlazTfcAssCstYn())){ //교통비
            		dlgn0110Dto.setDilnlazTfcAssCstYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazTfcAssCstYn("N");
            	} 
            	
            	if("true".equals(dlgn0110Dto.getDilnlazLnchYn())){ //급식비
            		dlgn0110Dto.setDilnlazLnchYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazLnchYn("N");
            	}
            	
            	if("true".equals(dlgn0110Dto.getDilnlazButpYn())){ 		//출장비
            		dlgn0110Dto.setDilnlazButpYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazButpYn("N");
            	}
            	
	            	dlgn0110DAO.updateDlgn0100ToDlgn0110(dlgn0110Dto);
	            	dlgn0210DAO.updateDlgn0100Todlgn0210Tm(dlgn0110Dto); 
        	
            InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
			
			// 3.복호화
//			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
//			
			infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
			infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
	 
	        infcDlgn0100Vo.setDpobCd(dlgn0110Dto.getDpobCd());						/** column 사업장코드 : dpobCd */
			infcDlgn0100Vo.setSystemkey(dlgn0110Dto.getSystemkey());				/** column SYSTEMKEY : systemkey */
			infcDlgn0100Vo.setDilnlazYrMnth(dlgn0110Dto.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
			infcDlgn0100Vo.setPayCd(dlgn0110Dto.getPayCd());    					/** column 급여구분코드 : payCd */
			infcDlgn0100Vo.setEmymtDivCd(dlgn0110Dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
			infcDlgn0100Vo.setDeptCd(dlgn0110Dto.getDeptCd());						/** column 부서코드 : deptCd */
			infcDlgn0100Vo.setBusinCd(dlgn0110Dto.getBusinCd());					/** column 사업코드 : businCd */
			infcDlgn0100Vo.setTypOccuCd(dlgn0110Dto.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
			infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0110Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
			infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0110Dto.getDilnlazWklyHldyNumDys()); //주휴일수
			
//			if((detailYmKubn.compareTo(dlgn0110Dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
//				/****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
//		        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//		        /****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//			}else{ //기준일 후
				/****************************************************************************************************
				 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
				Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
				/****************************************************************************************************
				 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
//			}
        }
        	
        	/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//           MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
           
           iCnt = iCnt + 1; 
            
	    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무관리 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));   
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
//     		 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
     		   ex.printStackTrace();
     			rtnData = 0L;
     			throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
     	}finally {
             
           }
     	
     	return rtnData;
     	
	}
	
	
	
	//기본근무관리 근무내역등록 그리드 수정(기준일 후)
	public Long updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(Dlgn0110DTO dlgn01101dto) throws MSFException {
		
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0110Grid";
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
	 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
           
           if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
               
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

               dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
           }
            
            	
        	
            InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
			
			// 3.복호화
//			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
//			
			infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
			infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
	 
	        infcDlgn0100Vo.setDpobCd(dlgn01101dto.getDpobCd());						/** column 사업장코드 : dpobCd */
			infcDlgn0100Vo.setSystemkey(dlgn01101dto.getSystemkey());				/** column SYSTEMKEY : systemkey */
			infcDlgn0100Vo.setDilnlazYrMnth(dlgn01101dto.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
			infcDlgn0100Vo.setPayCd(dlgn01101dto.getPayCd());    					/** column 급여구분코드 : payCd */
			infcDlgn0100Vo.setEmymtDivCd(dlgn01101dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
			infcDlgn0100Vo.setDeptCd(dlgn01101dto.getDeptCd());						/** column 부서코드 : deptCd */
			infcDlgn0100Vo.setBusinCd(dlgn01101dto.getBusinCd());					/** column 사업코드 : businCd */
			infcDlgn0100Vo.setTypOccuCd(dlgn01101dto.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
			infcDlgn0100Vo.setDtilOccuInttnCd(dlgn01101dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
			infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn01101dto.getDilnlazWklyHldyNumDys()); //주휴일수
			
//			if((detailYmKubn.compareTo(dlgn01101dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
//				/****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
//		        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//		        /****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//			}else{ //기준일 후
				/****************************************************************************************************
				 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
				Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
				/****************************************************************************************************
				 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
//			}
        	
        	/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//           MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
           
//           iCnt = iCnt + 1; 
            
//	    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무관리 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));   
	    rtnData = 1L;	
        } catch (Exception ex) {
     	   // logger.error("EXCEPTION calling activityOnDlgn0250(): "+ex); 
    	    
     	   // result = new Long(0);
     	   // throw MSFServerUtils.getOperationException("activityOnDlgn0250", ex, logger);
//     		 ex.printStackTrace();   
//     		   ShowMessageBM smBm = new ShowMessageBM();
//     		   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//     		   smBm.setMenu("dlgn");
//     		   smBm.setPhase("[근무실적]에러");
//     		   smBm.setMessage(ex.getLocalizedMessage());
//     		   smBm.setContent(ex.getMessage());
//     		   bmResult.add(smBm);  
     		   
     		 /** 에러 로그 **/			
//     		 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
     		   ex.printStackTrace();
     			rtnData = 0L;
     			throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
     	}finally {
             
           }
     	
     	return rtnData;
     	
	}
	
	
	
	
	
	
	
	//기본근무관리 근무내역등록 그리드 수정(기준일 전)
	public Long updateDlgn0110GridPre(List<Dlgn0110DTO> listDlgn0110Dto ) throws MSFException {
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0110Grid";
		
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
	 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
           
           if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
               
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

               dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
           }
            
            String rrnDecCrypt = "";
            for(int iPayrCnt=0; iPayrCnt < listDlgn0110Dto.size();iPayrCnt++) {
            	
            	Dlgn0110DTO dlgn0110Dto = new Dlgn0110DTO();
            	dlgn0110Dto = listDlgn0110Dto.get(iPayrCnt);
            	
            	dlgn0110Dto.setIsmt(sessionUser.getUsrId());
            	dlgn0110Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
            	
            	dlgn0110Dto.setPayCd(dlgn0110Dto.getPayCd());
            	dlgn0110Dto.setSystemkey(dlgn0110Dto.getSystemkey());
            	dlgn0110Dto.setDpobCd(dlgn0110Dto.getDpobCd());
            	
            	dlgn0110Dto.setDilnlazYrMnth(dlgn0110Dto.getDilnlazYrMnth().replaceAll("\\.", ""));
            	dlgn0110Dto.setDilnlazApptnDt(dlgn0110Dto.getDilnlazApptnDt().replaceAll("\\.", ""));
            	dlgn0110Dto.setDilnlazDutyTm(dlgn0110Dto.getDilnlazDutyTm());
            	dlgn0110Dto.setDilnlazWklyHldyNumDys(dlgn0110Dto.getDilnlazWklyHldyNumDys()); // DILNLAZ_WKLY_HLDY_NUM_DYS
            	dlgn0110Dto.setDilnlazEtcDivCd(dlgn0110Dto.getDilnlazEtcDivCd());
            	dlgn0110Dto.setEmymtDivCd(dlgn0110Dto.getEmymtDivCd());
            	
            	System.out.println("111"+dlgn0110Dto.getEmymtDivCd());
            	
            	if("true".equals(dlgn0110Dto.getDilnlazDutyYn())){
            		dlgn0110Dto.setDilnlazDutyYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazDutyYn("N");
            	}
//            	dlgn0110Dto.setDilnlazDutyYn(dlgn0110Dto.getDilnlazDutyYn()); //근무
            	if("true".equals(dlgn0110Dto.getDilnlazAbnceYn())){
            		dlgn0110Dto.setDilnlazAbnceYn("Y");
            		
            		// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
            		if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
            			dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("Y");
            			dlgn0110Dto.setDilnlazEtcDivCd("N0010010");	
            		}
            		
            	}else{
            		dlgn0110Dto.setDilnlazAbnceYn("N");
            		
            		// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
            		if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
            			dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("");
            			dlgn0110Dto.setDilnlazEtcDivCd("N0010000");	
            		}
            		
            	}
//            	dlgn0110Dto.setDilnlazAbnceYn(dlgn0110Dto.getDilnlazAbnceYn()); //결근
            	if("true".equals(dlgn0110Dto.getDilnlazLvsgYn())){
            		dlgn0110Dto.setDilnlazLvsgYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazLvsgYn("N");
            	}
//            	dlgn0110Dto.setDilnlazLvsgYn(dlgn0110Dto.getDilnlazLvsgYn()); //연차
            	if("true".equals(dlgn0110Dto.getDilnlazSpclHodyYn())){
            		dlgn0110Dto.setDilnlazSpclHodyYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazSpclHodyYn("N");
            	}
//            	dlgn0110Dto.setDilnlazSpclHodyYn(dlgn0110Dto.getDilnlazSpclHodyYn()); //특(휴)
            	if("true".equals(dlgn0110Dto.getDilnlazSckleaYn())){
            		dlgn0110Dto.setDilnlazSckleaYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazSckleaYn("N");
            	}            	
//            	dlgn0110Dto.setDilnlazSckleaYn(dlgn0110Dto.getDilnlazSckleaYn()); //병가
            	if("true".equals(dlgn0110Dto.getDilnlazOffvaYn())){
            		dlgn0110Dto.setDilnlazOffvaYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazOffvaYn("N");
            	} 
//            	dlgn0110Dto.setDilnlazOffvaYn(dlgn0110Dto.getDilnlazOffvaYn()); //공가
            	if("true".equals(dlgn0110Dto.getDilnlazFmlyEvntYn())){
            		dlgn0110Dto.setDilnlazFmlyEvntYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazFmlyEvntYn("N");
            	} 
//            	dlgn0110Dto.setDilnlazFmlyEvntYn(dlgn0110Dto.getDilnlazFmlyEvntYn()); //경조사
            	if("true".equals(dlgn0110Dto.getDilnlazHlthCreYn())){
            		dlgn0110Dto.setDilnlazHlthCreYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazHlthCreYn("N");
            	} 
//            	dlgn0110Dto.setDilnlazHlthCreYn(dlgn0110Dto.getDilnlazHlthCreYn()); //보건
            	
            	if("true".equals(dlgn0110Dto.getDilnlazTfcAssCstYn())){ //교통비
            		dlgn0110Dto.setDilnlazTfcAssCstYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazTfcAssCstYn("N");
            	} 
            	
            	if("true".equals(dlgn0110Dto.getDilnlazLnchYn())){ //급식비
            		dlgn0110Dto.setDilnlazLnchYn("Y");
            	}else{
            		dlgn0110Dto.setDilnlazLnchYn("N");
            	}
            	
	            	dlgn0110DAO.updateDlgn0100ToDlgn0110Pre(dlgn0110Dto);
        	
            InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
			
			// 3.복호화
//			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
//			
			infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
			infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
	 
	        infcDlgn0100Vo.setDpobCd(dlgn0110Dto.getDpobCd());						/** column 사업장코드 : dpobCd */
			infcDlgn0100Vo.setSystemkey(dlgn0110Dto.getSystemkey());				/** column SYSTEMKEY : systemkey */
			infcDlgn0100Vo.setDilnlazYrMnth(dlgn0110Dto.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
			infcDlgn0100Vo.setPayCd(dlgn0110Dto.getPayCd());    					/** column 급여구분코드 : payCd */
			infcDlgn0100Vo.setEmymtDivCd(dlgn0110Dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
			infcDlgn0100Vo.setDeptCd(dlgn0110Dto.getDeptCd());						/** column 부서코드 : deptCd */
			infcDlgn0100Vo.setBusinCd(dlgn0110Dto.getBusinCd());					/** column 사업코드 : businCd */
			infcDlgn0100Vo.setTypOccuCd(dlgn0110Dto.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
			infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0110Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
			infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0110Dto.getDilnlazWklyHldyNumDys()); //주휴일수
			
//			if((detailYmKubn.compareTo(dlgn0110Dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
//				/****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
//		        Long iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//		        /****************************************************************************************************
//		         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
//		         ****************************************************************************************************/
//			}else{ //기준일 후
				/****************************************************************************************************
				 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
				Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
				/****************************************************************************************************
				 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
//			}
        }
        	
        	/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//           MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
           
           iCnt = iCnt + 1; 
            
	    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무관리 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));   
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
//     		 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
     		   ex.printStackTrace();
     			rtnData = 0L;
     			throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
     	}finally {
             
           }
     	
     	return rtnData;
     	
	}
}
