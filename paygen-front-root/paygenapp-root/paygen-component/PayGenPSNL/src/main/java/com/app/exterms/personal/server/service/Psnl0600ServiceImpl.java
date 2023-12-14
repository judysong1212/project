package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.app.exterms.personal.client.dto.Psnl0600DTO;
import com.app.exterms.personal.client.service.Psnl0600Service;
import com.app.exterms.personal.server.service.dao.Psnl0600DAO;
import com.app.exterms.personal.server.vo.Psnl0600SrhVO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
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
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("psnl0600Service")
public class Psnl0600ServiceImpl extends AbstractCustomServiceImpl implements Psnl0600Service, PsnlDaoConstants {
	
	private static final Logger logger = LoggerFactory.getLogger(Psnl0600ServiceImpl.class);
	private static final String calledClass = Psnl0600ServiceImpl.class.getName();
	    
	@Autowired
	@Resource(name = "psnl0600DAO")
	private Psnl0600DAO psnl0600DAO;
	
	
	//기본
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0600(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		List<String> listDeptCd = new ArrayList<String>();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		
		String method = calledClass + ".selectPsnl0600";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 

		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd", sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
////			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
		 	if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {         
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
//			}  
		/******************************** 권한 ************************************************************************/			
		  
		  
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0600(param);
			egovResultDataList = psnl0600DAO.selectPsnl0600(psnl0600SrhVo);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
					
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
					
					// 복호화
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
		
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
		
	}

	//병역
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0112(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".selectPsnl0112";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 
		  // public static final String AUTH_USR_DIV_10 = "D0010010";   // D001    0010    공무직업무담당자
		  //  public static final String AUTH_USR_DIV_20 = "D0010020";   // D001    0020    기간제업무담당자
		  //  public static final String AUTH_USR_DIV_25 = "D0010025";  //  D001    0025    [겸직]공무직기간제담당자
		  /* public static final String AUTH_USR_DIV_30 = "D0010030";   // D001    0030    공무직총괄업무담당자
		    public static final String AUTH_USR_DIV_40 = "D0010040";   // D001    0040    기간제총괄업무담당자
		    public static final String AUTH_USR_DIV_60 = "D0010060";   // D001    0060    총괄업무담당자
		    public static final String AUTH_USR_DIV_70 = "D0010070";   // D001    0070    공무직근로자
		    public static final String AUTH_USR_DIV_80 = "D0010080";   // D001    0080    기간제근로자
		    public static final String AUTH_USR_DIV_90 = "D0010090";   // D001    0090    마스터관리자 */
		    
		 //  if (ExtermsProps.AUTH_USR_DIV_10.equals(sessionUser.getUsrDivCd()) && ExtermsProps.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd())){
			    
				
		  // } else if (ExtermsProps.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())){
			   
			   
		//   } else if (ExtermsProps.AUTH_USR_DIV_25.equals(sessionUser.getUsrDivCd())){
			   
			   
		 //  } else {
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
			        
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
//				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			} 
//			}  
		/******************************** 권한 ************************************************************************/			
		
		//-----------
		psnl0600SrhVo.setDsageDivCd(MSFSharedUtils.allowNulls(params.get("srhDsageDivCd")));//제대구분
		psnl0600SrhVo.setDsageDtS(MSFSharedUtils.allowNulls(params.get("srhDsageDtS")));	//제대기간 시작일
		psnl0600SrhVo.setDsageDtE(MSFSharedUtils.allowNulls(params.get("srhDsageDtE")));	//제대기간 종료일
		psnl0600SrhVo.setBaggrpCd(MSFSharedUtils.allowNulls(params.get("srhBaggrpCd")));	//군별	
		psnl0600SrhVo.setAbotsCd(MSFSharedUtils.allowNulls(params.get("srhAbotsCd")));		//병과
		psnl0600SrhVo.setClsCd(MSFSharedUtils.allowNulls(params.get("srhClsCd")));			//계급
		
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0112(params);
			egovResultDataList = psnl0600DAO.selectPsnl0112(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
					
					// 복호화
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
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	


	//단체
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0114(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		String method = calledClass + ".selectPsnl0114";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
		
//				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				} 
//			}  
		/******************************** 권한 ************************************************************************/			
		
		//-----------
		psnl0600SrhVo.setJnOpztnNm(MSFSharedUtils.allowNulls(params.get("srhJnOpztnNm")));	//단체명
		psnl0600SrhVo.setJnDtS(MSFSharedUtils.allowNulls(params.get("srhJnDtS")));			//가입기간 시작일
		psnl0600SrhVo.setJnDtE(MSFSharedUtils.allowNulls(params.get("srhJnDtE")));			//가입기간 종료일
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0114(params);
			egovResultDataList = psnl0600DAO.selectPsnl0114(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
					
					// 복호화
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
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	

	

	//학력
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0116(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		String method = calledClass + ".selectPsnl0116";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
//			        
//				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				} 
//			}  
		/******************************** 권한 ************************************************************************/	
		
		//-----------
		psnl0600SrhVo.setAcadAbtyDivCd(MSFSharedUtils.allowNulls(params.get("srhAcadAbtyDivCd")));	//학력구분
		psnl0600SrhVo.setDegrDivCd(MSFSharedUtils.allowNulls(params.get("srhDegrDivCd")));				//학위
		psnl0600SrhVo.setDeprMajrCd(MSFSharedUtils.allowNulls(params.get("srhDeprMajrCd")));			//학과
		psnl0600SrhVo.setSchlCd(MSFSharedUtils.allowNulls(params.get("srhSchlCd")));						//학교명
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0116(params);
			egovResultDataList = psnl0600DAO.selectPsnl0116(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
					
					// 복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					returnValue.add(dto);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");	
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}

	
		
	

	//경력
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0119(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		
		// TODO Auto-generated method stub
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		String method = calledClass + ".selectPsnl0119";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
//			        
//				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				} 
//			}  
		/******************************** 권한 ************************************************************************/	
		
		//-----------
		psnl0600SrhVo.setPaeWorkNm(MSFSharedUtils.allowNulls(params.get("srhPaeWorkNm")));		//근무지명
		psnl0600SrhVo.setCarrBgnnDtS(MSFSharedUtils.allowNulls(params.get("srhCarrBgnnDtS")));	//경력시작일자 시작기간
		psnl0600SrhVo.setCarrBgnnDtE(MSFSharedUtils.allowNulls(params.get("srhCarrBgnnDtE")));	//경력시작일자 종료기간
		
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0119(params);
			egovResultDataList = psnl0600DAO.selectPsnl0119(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
					
					// 복호화
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
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	
	
	
	
	

	//자격
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0118(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		
		String method = calledClass + ".selectPsnl0118";
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
//			        
//				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}   
//			}  
		/******************************** 권한 ************************************************************************/			
		
		//-----------
		psnl0600SrhVo.setQftntLicnsPovncCtnt(MSFSharedUtils.allowNulls(params.get("srhQftntLicnsPovncCtnt")));	//자격면허일련번호
		psnl0600SrhVo.setAqtnDtS(MSFSharedUtils.allowNulls(params.get("srhAqtnDtS")));				//취득일자 시작기간
		psnl0600SrhVo.setAqtnDtE(MSFSharedUtils.allowNulls(params.get("srhAqtnDtE")));				//취득일자 종료기간
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0118(params);
			egovResultDataList = psnl0600DAO.selectPsnl0118(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					

					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";

					
					Psnl0600DTO dto = new Psnl0600DTO();
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
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	

	
	

	//교육
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0120(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		

		String method = calledClass + ".selectPsnl0120";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
//			        
//				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) {
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
//					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				} 
//			}  
		/******************************** 권한 ************************************************************************/			
		
		//-----------
		psnl0600SrhVo.setEduKndNm(MSFSharedUtils.allowNulls(params.get("srhEduKndNm")));		//교육종류명
		psnl0600SrhVo.setEduBgnnDtS(MSFSharedUtils.allowNulls(params.get("srhEduBgnnDtS")));	//교육시작일자 시작기간
		psnl0600SrhVo.setEduBgnnDtE(MSFSharedUtils.allowNulls(params.get("srhEduBgnnDtE")));	//교육시작일자 종료기간
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0120(params);
			egovResultDataList = psnl0600DAO.selectPsnl0120(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
		
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	
	
	
	

	//포상
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0121(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		
		
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".selectPsnl0121";
		
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
//			        
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) {
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}  
//			}  
		/******************************** 권한 ************************************************************************/			
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0121(params);
			egovResultDataList = psnl0600DAO.selectPsnl0121(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
		
			
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	
	
	//징계
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0122(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".selectPsnl0122";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
//					params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));  
//				    params.put("srhDeptCd", MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//			        params.put("deptCdArr", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));     //부서코드 
//			        
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			} 
//			}  
		/******************************** 권한 ************************************************************************/			
		
		//-----------
		psnl0600SrhVo.setDsnyActDivCd(MSFSharedUtils.allowNulls(params.get("srhDsnyActDivCd")));		//징계구분
		psnl0600SrhVo.setDsnyActDsplDtS(MSFSharedUtils.allowNulls(params.get("srhDsnyActDsplDtS")));	//징계처분일자 시작일
		psnl0600SrhVo.setDsnyActDsplDtE(MSFSharedUtils.allowNulls(params.get("srhDsnyActDsplDtE")));	//징계처분일자 종료일
		
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0122(params);
			egovResultDataList = psnl0600DAO.selectPsnl0122(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	
	


	//휴직
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0123(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0600DTO> returnValue = new ArrayList<Psnl0600DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".selectPsnl0123";
		
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		params.put("dpobCd", sessionUser.getDpobCd()); 
		psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());
		
//		params.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
		
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(params.get("srhCurrDeptCd") == null || "".equals(params.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(params.get("srhPayrMangDeptCd"));
		}
		
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));	//부서
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(params.get("srhEmymtDivCd")));		//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(params.get("srhBusinCd")));				//사업
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(params.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));		//재직코드
      	
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(params.get("srhHdofcCodtnCd")));	//재직상태
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateS")));//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(params.get("srhNowDeptDateE")));//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(params.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(params.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(params.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(params.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(params.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(params.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(params.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")))); //직종세
		
		
		params.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn()); 
		params.put("usrId",sessionUser.getUsrId());   
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(params.get("dpobCd")));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(params.get("payrMangDeptYn")));
		
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(params.get("usrId")));
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(params.get("srhDtilOccuInttnCd")).replace(",", "")));   
		         
		/******************************** 권한 ************************************************************************/
//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) { 
//				
//					params.put("payrMangDeptCd", MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			    	params.put("srhCurrDeptCd","");  
//			    	params.put("srhDeptCd","");  
//			        params.put("deptCdArr","");     //부서코드 
//			        
//			        psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(params.get("payrMangDeptCd")));
//			        psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
//			        psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhDeptCd")));
//			        List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
//			        
//			}  else { 
		
//		if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhPayrMangDeptCd")))) { 
		if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")))) {   
//			psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
			List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
			psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
		}else {
//			psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
//			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd")));
			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
			List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(params.get("srhCurrDeptCd"))); 
			psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
		}
		
//			}  
		/******************************** 권한 ************************************************************************/			

		//-----------
		psnl0600SrhVo.setLevfAbncDivCd(MSFSharedUtils.allowNulls(params.get("srhLevfAbncDivCd")));		//휴직구분
		psnl0600SrhVo.setLevfAbncBgnnDtS(MSFSharedUtils.allowNulls(params.get("srhLevfAbncBgnnDtS")));	//휴직일 시작기간
		psnl0600SrhVo.setLevfAbncBgnnDtE(MSFSharedUtils.allowNulls(params.get("srhLevfAbncBgnnDtE")));	//휴직일 종료기간
		
		try{
			//egovResultDataList = psnl0600DAO.selectPsnl0123(params);
			egovResultDataList = psnl0600DAO.selectPsnl0123(psnl0600SrhVo);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0600DTO dto = new Psnl0600DTO();
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
		
		return new BaseListLoadResult<Psnl0600DTO>(returnValue);
	}
	
	

	
	
	// ====================================== 그리드 조회 ==========================================
	/** 기본 **/
	public PagingLoadResult<BaseModel> getPsnl0600DataList(ServiceParameters serviceParameters) throws MSFException {
			
			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_PSNL0600_DATA_LIST;
			Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO"); 
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
		    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
		    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
				
		    	
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
				//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
				if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
					psnl0600SrhVo.setPayrMangDeptCd("");
					psnl0600SrhVo.setCurrAffnDeptCd("");	
				}else {
					psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));	//단위기관
				}
				
				
				
				
				psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));					//고용구분
				psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));						//사업
				
				List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
				psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
				psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));				//재직코드
		      	
				psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));			//현부서 시작일자(시작)
				psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));			//현부서 종료일자(종료)
				psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
				psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
				psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));				//근속년수(시작)
				psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));				//근속년수(종료)
				psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));				//생년월일(시작)
				psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));				//생년월일(종료)
				psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
				psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));					//직종
				
				List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
				psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
				psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
				
				psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
				psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
				      
				
				psnl0600SrhVo.setSrhFlag("N");	
		      	if(psnl0600SrhVo.getEmymtDivCd() != "" || !"".equals(psnl0600SrhVo.getEmymtDivCd())) {
		      		
		          	// 퇴사한 공무직이 기간제 근로자로 재입사 한 경우 공무직 화면에서 조회하기 위해 srhVo 추가
			      	// 재직 구분이 없거나, 퇴직 포함 시 조회되도록 처리.
		      		if( ( psnl0600SrhVo.getHdofcCodtnCd() == null || "".equals(psnl0600SrhVo.getHdofcCodtnCd()) ) ||  ( ( psnl0600SrhVo.getHdofcCodtnCd().contains("A0030020")) ||  psnl0600SrhVo.getHdofcCodtnCd() == "A0030020"  ) ) {
		      			psnl0600SrhVo.setSrhFlag("Y");	
			      	}
						
		      	}
		      	
		      	psnl0600SrhVo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtBgnnDt")));
		      	psnl0600SrhVo.setEmymtEndDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtEndDt")));
				/******************************** 권한 ************************************************************************/
//				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
//					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
//				}else {
//					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
//					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
//					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
//				}
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {         
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}
				/******************************** 권한 ************************************************************************/	
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = psnl0600DAO.selectPsnl0600ListTotCnt(psnl0600SrhVo);  
		              
		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
		          	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
		     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
		        
		     	/**페이지 카운트 처리를 위한 부분 */ 
		     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = new ArrayList();
		     	if (psnl0600SrhVo.getEmymtDivCd().equals("A0020020")) {
		     		list = psnl0600DAO.selectPsnl0600ToA0410020(psnl0600SrhVo);
		     	}
		     	else {
		     		list = psnl0600DAO.selectPsnl0600(psnl0600SrhVo);
		     	}
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) {
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
		          	   			
		          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          				String rrnDecCrypt = "";
		          		          			
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
		            
				SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600DataList");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			return retval;
		}
	
	
	/** 병역 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0112DataList(ServiceParameters serviceParameters) throws MSFException {
			
			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_PSNL0600_TO_PSNL0112_DATA_LIST;
			Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
		    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
		    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
				
		    	
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
				//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
				if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
					psnl0600SrhVo.setPayrMangDeptCd("");
					psnl0600SrhVo.setCurrAffnDeptCd("");	
				}else {
					psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
					psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
				}
				
				psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		//고용구분
				psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				//사업
				
				List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
				psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
				psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));		//재직코드
		      	
				psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
				psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
				psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
				psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
				psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
				psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
				psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
				psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
				psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
				psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
				
				List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
				psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
				psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
				
				psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
				psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
				         
				/******************************** 권한 ************************************************************************/
				if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}else {
					psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
					psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
				}
				/******************************** 권한 ************************************************************************/	
				
				
				psnl0600SrhVo.setDsageDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dsageDivCd"))));		//제대구분
				psnl0600SrhVo.setDsageDtS(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dsageDtS"))));			//제대기간 시작일
				psnl0600SrhVo.setDsageDtE(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dsageDtE"))));			//제대기간 종료일
				psnl0600SrhVo.setBaggrpCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "baggrpCd"))));			//군별	
				psnl0600SrhVo.setAbotsCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "abotsCd"))));				//병과
				psnl0600SrhVo.setClsCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clsCd"))));						//계급
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = psnl0600DAO.selectPsnl0112ListTotCnt(psnl0600SrhVo);  
		              
		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
		          	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
		     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
		        
		     	/**페이지 카운트 처리를 위한 부분 */ 
		     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = psnl0600DAO.selectPsnl0112(psnl0600SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) {
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
		          	   			
		          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          				String rrnDecCrypt = "";
		          		          			
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
		            
				SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0112DataList");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
		return retval;
	}
	
	
	/** 단체 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0114DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0114_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));				//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setJnOpztnNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "jnOpztnNm")));	//단체명
			psnl0600SrhVo.setJnDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "jnDtS")));					//가입기간 시작일
			psnl0600SrhVo.setJnDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "jnDtE")));					//가입기간 종료일
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0114ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0114(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0114DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 학력 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0116DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0116_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));				//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setAcadAbtyDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "acadAbtyDivCd"))));	//학력구분
			psnl0600SrhVo.setDegrDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "degrDivCd"))));			//학위
			psnl0600SrhVo.setDeprMajrCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deprMajrCd"))));			//학과
			psnl0600SrhVo.setSchlCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "schlCd"))));					//학교명
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0116ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0116(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0116DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 경력 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0119DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0119_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));				//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setPaeWorkNm(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "paeWorkNm"))));	//근무지명
			psnl0600SrhVo.setCarrBgnnDtS(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "carrBgnnDtS"))));	//경력시작일자 시작기간		
			psnl0600SrhVo.setCarrBgnnDtE(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "carrBgnnDtE"))));	//경력시작일자 종료기간
			
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0119ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0119(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0119DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/** 자격 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0118DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0118_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));				//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setQftntLicnsPovncCtnt(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "qftntLicnsPovncCtnt"))));	//자격면허일련번호
			psnl0600SrhVo.setAqtnDtS(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "aqtnDtS"))));					//취득일자 시작기간
			psnl0600SrhVo.setAqtnDtE(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "aqtnDtE"))));					//취득일자 종료기간		
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0118ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0118(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0118DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/** 교육 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0120DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0120_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));				//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));					//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setEduKndNm(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "eduKndNm"))));		//교육종류명
			psnl0600SrhVo.setEduBgnnDtS(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "eduBgnnDtS"))));	//교육시작일자 시작기간
			psnl0600SrhVo.setEduBgnnDtE(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "eduBgnnDtE"))));	//교육시작일자 종료기간
	           
			
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0120ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0120(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0120DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 포상 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0121DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0121_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));				//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));					//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0121ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0121(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0121DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 징계 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0122DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0122_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));				//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setDsnyActDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dsnyActDivCd"))));		//징계구분
			psnl0600SrhVo.setDsnyActDsplDtS(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dsnyActDsplDtS"))));	//징계처분일자 시작일
			psnl0600SrhVo.setDsnyActDsplDtE(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dsnyActDsplDtE"))));	//징계처분일자 종료일
	            
			
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0122ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0122(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0122DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 휴직 **/
	public PagingLoadResult<BaseModel> getPsnl0600ToPsnl0123DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0600_TO_PSNL0123_DATA_LIST;
		Psnl0600SrhVO   psnl0600SrhVo = new Psnl0600SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0600DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0600DAO = (Psnl0600DAO) wac.getBean("psnl0600DAO" ); 
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
	    	psnl0600SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0600SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
	    	
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));		//소속부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(psnl0600SrhVo.getCurrAffnDeptCd() == null || "".equals(psnl0600SrhVo.getCurrAffnDeptCd())) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));				//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));					//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);   
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	      	
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateS")));			//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "frstWorkDateE")));			//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearS")));			//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "workYearE")));			//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateS")));			//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "birthDateE")));			//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sexType")));						//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));				//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/	
			
			psnl0600SrhVo.setLevfAbncDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "levfAbncDivCd"))));			//휴직구분
			psnl0600SrhVo.setLevfAbncBgnnDtS(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "levfAbncBgnnDtS"))));	//휴직일 시작기간
			psnl0600SrhVo.setLevfAbncBgnnDtE(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "levfAbncBgnnDtE"))));	//휴직일 종료기간
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0600DAO.selectPsnl0123ListTotCnt(psnl0600SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0600DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0600SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0600DAO.selectPsnl0123(psnl0600SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0600DataList, "getPsnl0600ToPsnl0123DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	

}
