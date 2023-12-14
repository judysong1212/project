package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl010002DTO;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.dto.Psnl0111DTO;
import com.app.exterms.personal.client.dto.Psnl0112DTO;
import com.app.exterms.personal.client.dto.Psnl0113DTO;
import com.app.exterms.personal.client.service.PsnlP010002Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0101DAO;
import com.app.exterms.personal.server.service.dao.Psnl0110DAO;
import com.app.exterms.personal.server.service.dao.Psnl0111DAO;
import com.app.exterms.personal.server.service.dao.Psnl0112DAO;
import com.app.exterms.personal.server.service.dao.Psnl0113DAO;
import com.app.exterms.personal.server.service.dao.Psnl0127DAO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.exterms.personal.server.vo.Psnl0101VO;
import com.app.exterms.personal.server.vo.Psnl0110SrhVO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.exterms.personal.server.vo.Psnl0111VO;
import com.app.exterms.personal.server.vo.Psnl0112VO;
import com.app.exterms.personal.server.vo.Psnl0113VO;
import com.app.exterms.personal.server.vo.Psnl0127VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0360DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360VO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400VO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr3000DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr4100DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr5100DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr6100DAO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr6100VO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0304DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0520DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520VO;
import com.app.smrmf.props.ExtermsProps;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.text.SimpleDateFormat;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : PsnlP010002ServiceImpl.java
 * @Description : PsnlP010002 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@SuppressWarnings("serial")
@Service("psnlP010002Service")
public class PsnlP010002ServiceImpl extends AbstractCustomServiceImpl implements PsnlP010002Service {

    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
    
    @Resource(name="psnl0101DAO")
    private Psnl0101DAO psnl0101DAO;
    
    @Resource(name="psnl0110DAO")
    private Psnl0110DAO psnl0110DAO;
    
    @Resource(name="psnl0111DAO")
    private Psnl0111DAO psnl0111DAO;
    
    @Resource(name="psnl0112DAO")
    private Psnl0112DAO psnl0112DAO;
    
    @Resource(name="psnl0113DAO")
    private Psnl0113DAO psnl0113DAO;
    
    @Resource(name="InfcPkgBass0360DAO")
    private InfcPkgBass0360DAO infcBass0360DAO;
	
	@Resource(name = "InfcPkgPayr0500DAO")
	private InfcPkgPayr0500DAO infcPayr0500DAO;
	
	@Resource(name = "InfcPkgPayr0520DAO")
    private InfcPkgPayr0520DAO infcPayr0520DAO;

	@Resource(name = "InfcPkgPayr0304DAO")
	private InfcPkgPayr0304DAO infcPayr0304DAO;
	
    @Resource(name="psnl0127DAO")
    private Psnl0127DAO psnl0127DAO;
    
    @Resource(name="InfcPkgInsr3000DAO")
    private InfcPkgInsr3000DAO infcInsr3000DAO;
    
    @Resource(name="InfcPkgInsr4100DAO")
    private InfcPkgInsr4100DAO infcInsr4100DAO;
    
    
    @Resource(name="InfcPkgInsr5100DAO")
    private InfcPkgInsr5100DAO infcInsr5100DAO;
    
    
    @Resource(name="InfcPkgInsr6100DAO")
    private InfcPkgInsr6100DAO infcInsr6100DAO;
    
    
    private static final Logger logger = LoggerFactory.getLogger(PsnlP010002ServiceImpl.class);
    private static final String calledClass = PsnlP010002ServiceImpl.class.getName();
    
    
    
    
	/** 근로자 신규 등록시 이미 등록된 근로자인지 체크 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Long psnl0100Check(Psnl0100DTO psnl0100Dto) throws MSFException {
		
		String method = calledClass + ".psnl0100Check";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
//		List<Psnl0100DTO> returnValue = new ArrayList<Psnl0100DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		Long result = new Long(0);
		
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		psnl0100Dto.setDpobCd(sessionUser.getDpobCd());
		// 파라미터 보낼 때(암호화)
		psnl0100Dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0100Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
		
		
		try{
			egovResultDataList = psnl0100DAO.selectPsnl0100Check(psnl0100Dto);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				
				// 존재하면 1 리턴
				result = new Long(1);
				
				
//				for(int i = 0 ; i < egovResultDataList.size(); i++){
//					
//					// 복호화 리턴받을 값 선언
//					String rrnDecCrypt = "";
//					
//					Psnl0100DTO dto = new Psnl0100DTO();
//					
//					Map tempMap = (Map)egovResultDataList.get(i);
//					
//					Iterator<String> keys = tempMap.keySet().iterator();
//					
//					while( keys.hasNext() ){
//						
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		dto.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		dto.set(key, tempMap.get(key));
//		            	}
//		            }
//					
//					// 복호화
//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					dto.setResnRegnNum(rrnDecCrypt);
//					
//					returnValue.add(dto);
//				}
			}else {
				
				// 없으면 0 리턴
				result = new Long(0);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);

			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		
		return result;
	}

	
	
	/** 인사 저장 **/
	@Override
	public PagingLoadResult<ShowMessageBM> savePsnlAll(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase) throws MSFException {
		
		
		
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
        
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
		List egovResultDataList = new ArrayList();
		
		Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
		Psnl0111DTO psnl0111Dto = new Psnl0111DTO();
		Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
		Psnl0112DTO psnl0112Dto = new Psnl0112DTO();
		Psnl0113DTO psnl0113Dto = new Psnl0113DTO();
		
		
		Psnl0100VO psnl0100Vo 	= new Psnl0100VO();
		Psnl0110VO psnl0110Vo 	= new Psnl0110VO();
		Psnl0111VO psnl0111Vo 	= new Psnl0111VO();
		Psnl0112VO psnl0112Vo 	= new Psnl0112VO();
		Psnl0113VO psnl0113Vo 	= new Psnl0113VO();
		HashMap<String, String> tempMap = new HashMap<String, String>();
		String systemkey = "";
		
		int cnt = 0;
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
    	
		try{
			
			psnl0100Dto = new Psnl0100DTO();
			
			// 1. 인사 기본  ( PSNL0100 ) 
			psnl0100Dto.setDpobCd(sessionUser.getDpobCd());
			psnl0100Dto.setDeptCd(MSFSharedUtils.allowNulls(psnl010002Dto.getDeptCd()));    											/** column 부서코드 : deptCd */
			psnl0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getEmymtDivCd()));    									/** column 고용구분코드 : emymtDivCd */
	  		psnl0100Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(psnl010002Dto.getCurrAffnDeptCd())));		/** column 현소속부서코드 : currAffnDeptCd */
	  		psnl0100Dto.setHanNm(MSFSharedUtils.allowNulls(psnl010002Dto.getHanNm()));    												/** column 한글성명 : hanNm */
//	  		psnl0100Dto.setResnRegnNum(MSFSharedUtils.allowNulls(psnl010002Dto.getResnRegnNum())); 										
			psnl0100Dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult
							, MSFSharedUtils.allowNulls(psnl010002Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	/** column 주민등록번호 : resnRegnNum */
	  		psnl0100Dto.setEngNm(MSFSharedUtils.allowNulls(psnl010002Dto.getEngNm()));    												/** column 영문성명 : engNm */
	  		psnl0100Dto.setChinCharNm(MSFSharedUtils.allowNulls(psnl010002Dto.getChinCharNm()));    									/** column 한문성명 : chinCharNm */  	
	  		psnl0100Dto.setRepbtyBusinNm(MSFSharedUtils.allowNulls(psnl010002Dto.getRepbtyBusinNm()));    								/** column 담당업무명 : repbtyBusinNm */
	  		psnl0100Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(psnl010002Dto.getHdofcCodtnCd()));									/** column 재직상태코드 : hdofcCodtnCd */
	  		psnl0100Dto.setNatnCd(MSFSharedUtils.allowNulls(psnl010002Dto.getNatnCd()));    											/** column 국가코드 : natnCd */
	  		psnl0100Dto.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getRepbtyBusinDivCd()));							/** column 호봉제구분코드 : repbtyBusinDivCd */
	  		psnl0100Dto.setPyspCd(MSFSharedUtils.allowNulls(psnl010002Dto.getPyspCd()));    											/** column 호봉코드 : pyspCd */	
	  		psnl0100Dto.setUnnMbspSttYn(MSFSharedUtils.allowNulls(psnl010002Dto.getUnnMbspSttYn()));    								/** column 노조가입여부 : unnMbspSttYn */
	  		psnl0100Dto.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
	  		psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */
			
	  		
        	switch (actionDatabase) {
	    		case INSERT:
	    			
	    			// 1. 인사 기본
	    			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [기본]", "저장 시작"));
	    			
	    			psnl0100Dto.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
	    			psnl0100Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
	    			
	    			//신규일 경우 호봉은 무조건 '0호봉' 코드값을 넣어줌.
	    			//쿼리에서 기간제일 경우는 호봉 ''로 넣고 공무직 일 경우만 호봉코드 넣어줌.
	    			psnl0100Dto.setPyspCd("A0050000");
	    			
	    			
	    			// 인사 초기 등록 시 근속년월 0년 0개월 넣어줌.
	    			psnl0100Dto.setLogSvcYrNumCd("A0070000");	// 근속년수코드
	    			psnl0100Dto.setLogSvcMnthIcmCd("A0060034");	// 근속월수코드
	    			
	    			String dpobCd = sessionUser.getUsrDivCd() == null ? sessionUser.getDpobCd() : sessionUser.getDpobCd();
	    			systemkey = psnl0100DAO.getNewSystemkey(dpobCd);
	    			psnl0100Dto.setDpobCd(dpobCd);
	    			psnl0100Dto.setSystemkey(systemkey);
	    			
	    			psnl0100DAO.insertPsnl0100(psnl0100Dto);
	    			
	    			//jungmin 2014.09.25
	    			//급여인사 마스터 등록 추가 시작
	    			InfcPkgPayr0500VO payr0500vo = new InfcPkgPayr0500VO();
	    			InfcPkgPayr0520VO tpPayr0520vo = new InfcPkgPayr0520VO();
	    			
	    			payr0500vo.setDpobCd(dpobCd);
	    			payr0500vo.setSystemkey(systemkey);
	    			
	    			tempMap = new HashMap<String, String>();
	    			tempMap.put("dpobCd", dpobCd );
	    			tempMap.put("deptCd", psnl0100Dto.getCurrAffnDeptCd());
	    			payr0500vo.setPayrMangDeptCd(psnl0100DAO.getPayDeptCd(tempMap));
	    			payr0500vo.setEmymtDivCd(psnl0100Dto.getEmymtDivCd());
	    			payr0500vo.setPayRcptYn("Y"); 
	    			/** 2015.07.13 소득세 관련추가  */
	    			payr0500vo.setAddIncmTxApptnRtoCd(ExtermsProps.getProps("PAYR_TAX_B0290020"));    	/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
	    			payr0500vo.setAddIncmTxApptnYrMnth("");									/** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
	    			payr0500vo.setAddIncmTxApptnYn("N");   									/** column 추가소득세적용여부 : addIncmTxApptnYn  N : 최초입력  Y: 변경적용 E : 급여적용 이후 수정불가 .과세기간동*/
	    	           
	    			payr0500vo.setKybdr(psnl0100Dto.getKybdr());
	    			payr0500vo.setIsmt(psnl0100Dto.getIsmt());
	    			payr0500vo.setInptAddr(psnl0100Dto.getInptAddr());
	    			payr0500vo.setRevnAddr(psnl0100Dto.getRevnAddr());
	    			
	    			BeanUtils.copyProperties(tpPayr0520vo, payr0500vo);
	    			
	    			tpPayr0520vo.setPayItemCd("");
	    			tpPayr0520vo.setPymtDducItemSilNum(BigDecimal.ZERO);
	    			 
	    			tpPayr0520vo = infcPayr0520DAO.selectPayr0520(tpPayr0520vo);
	    			
	    			if (MSFSharedUtils.paramNull(tpPayr0520vo)) {
	    				infcPayr0500DAO.deletePayr0500(payr0500vo);
	    			}  
	    			
	    			infcPayr0500DAO.insertPayr0500(payr0500vo);
	    			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [기본]", "저장 완료"));
	    			break;
	        	case UPDATE: 
	        		
	        		systemkey = psnl010002Dto.getSystemkey();
	        		psnl0100Dto.setSystemkey(systemkey);
	        		if(psnl0100DAO.updatePsnl0100(psnl0100Dto) > 0 ) {
	        			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [기본]", "저장 완료"));	
	        		}else {
	        			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [기본]", "저장 실패"));
	        		}
	        		 
	        		break;
        	} 
        	
        	
        	
	  		// 2. 인사 인적  ( PSNL0111 ) 
        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 시작"));
        	bmResult.add( psnl0111Save(psnl010002Dto, actionDatabase, systemkey));
        	
	  		
	  		// 3. 인사 고용 ( PSNL0110 )
        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [고용]", "저장 시작"));
        	bmResult.add( psnl0110Save(psnl010002Dto, actionDatabase, systemkey));
   	
	  		
	  		// 4. 인사 병역 ( PSNL0112 )
        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 시작"));
        	bmResult.add( psnl0112Save(psnl010002Dto, actionDatabase, systemkey));
	    	
	    	
	    	// 5. 인사 신상 ( PSNL0113 )
        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 시작"));
        	bmResult.add( psnl0113Save(psnl010002Dto, actionDatabase, systemkey));
        	
        	
        	
        	// 6. 인사 마스터 인적, 신상 UPDATE 처리 시작
        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [마스터]", "저장 시작"));
  			//(인적)
        	psnl0100Dto.setStyBgnnDt(MSFSharedUtils.allowNulls(psnl010002Dto.getStyBgnnDt()));    												/** column 체류시작일자 : styBgnnDt */
        	psnl0100Dto.setStyEndDt(MSFSharedUtils.allowNulls(psnl010002Dto.getStyEndDt()));    												/** column 체류종료일자 : styEndDt */
        	psnl0100Dto.setFrgnrDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getFrgnrDivCd()));    											/** column 외국인구분코드 : frgnrDivCd */
  			psnl0100Dto.setPsptNum(MSFSharedUtils.allowNulls(psnl010002Dto.getPsptNum()));    													/** column 여권번호 : psptNum */
  			psnl0100Dto.setPernNoteCtnt(MSFSharedUtils.allowNulls(psnl010002Dto.getPernNoteCtnt()));    										/** column 인사비고내용 : pernNoteCtnt */
  		
  			
  			 String strResnYoobhMnth = "";
  			 String strYoobhMnthDay = "";
  			 if("1".equals(psnl010002Dto.getResnRegnNum().substring(6,7)) || "2".equals(psnl010002Dto.getResnRegnNum().substring(6,7))) {
  				 strResnYoobhMnth = psnl010002Dto.getResnRegnNum().substring(0, 6);
  				 strYoobhMnthDay = "19" + strResnYoobhMnth;
  		     }else if("3".equals(psnl010002Dto.getResnRegnNum().substring(6,7)) || "4".equals(psnl010002Dto.getResnRegnNum().substring(6,7))) {
  		    	 strResnYoobhMnth = psnl010002Dto.getResnRegnNum().substring(0, 6);
  		    	 strYoobhMnthDay = "20" + strResnYoobhMnth;
  		     }
  			
  			
    		//(신상)
  			psnl0100Dto.setSxDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getSxDivCd()));    													/** column 성별구분코드 : sxDivCd */
  			psnl0100Dto.setYoobhMnthDay(MSFSharedUtils.defaultNulls(psnl010002Dto.getYoobhMnthDay(), strYoobhMnthDay));   		 				/** column 생년월일 : yoobhMnthDay */
//    	psnl0100Dto.setSclcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("sclcDivCd")));    /** column 음양구분코드 : sclcDivCd */

  			psnl0100DAO.updatePsnl0100(psnl0100Dto);
  			
  			
  			// 7. 고용에 따른 인사 마스터 update 처리 
  			String yearStr = new SimpleDateFormat("yyyy").format(new Date());
				
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 1차 : 고용 구분에 따라 **/
			//기간제일 때
			if("A0020020".equals(psnl010002Dto.getEmymtDivCd())) {
					
				// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
				if(( "A0420030".equals(psnl010002Dto.getEmymtTypCd()) || "A0420020".equals(psnl010002Dto.getEmymtTypCd()))
					&& Integer.parseInt( psnl010002Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
					) {
						
					}else {
						psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
					}
					
					psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
					
				}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
					
					//공무직일 때
					psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);						// 직종
					psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);				// 직종세
					
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
				
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 2차 : 고용 유형에 따라 **/
				//신규
				if("A0420010".equals(psnl010002Dto.getEmymtTypCd()) || "A0420020".equals(psnl010002Dto.getEmymtTypCd())) {
					//고용구분코드 신규 or 직제개편
					psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				// 소속 부서 
					psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);				// 현부서 발령일
					
					//고용구분코드 신규일 때
					psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);					//최초고용일자
					
				//직제개편	
				}else if("A0420050".equals(psnl010002Dto.getEmymtTypCd())) {
					//고용구분코드 신규 or 직제개편
					psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				// 현부서
					psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);				// 현부서 발령일
				
				//퇴직
				}else if("A0420990".equals(psnl010002Dto.getEmymtTypCd())) {
					//고용유형이 퇴직일때만
					psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						// 퇴직일자
						
				//전보
				}else if("A0420060".equals(psnl010002Dto.getEmymtTypCd())) {
					psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				// 소속 부서 
					psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);				// 현부서 발령일
				// 연장계약
				}else if("A0420030".equals(psnl010002Dto.getEmymtTypCd())) {
					// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
					psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						// 퇴직일자
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
					
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 3차 : 공통 사항 **/
	//			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
				// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
				if("A0020020".equals(psnl010002Dto.getEmymtDivCd()) 
						&& ( "A0420030".equals(psnl010002Dto.getEmymtTypCd()) || "A0420020".equals(psnl010002Dto.getEmymtTypCd()))
						&& Integer.parseInt( psnl010002Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
						) {
					
							psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);			// 고용종료일
							
				}else {
					
					psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					// 고용시작일
					psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					// 고용종료일
					
				}
				
				psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);						// 재직상태코드
				psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);								// 직책코드
				psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);						// 고용해제사유
				
				
				// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
					
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
	

//			egovResultDataList = psnl0100DAO.getMemberInfo(psnl0100Dto);
//			if(egovResultDataList != null && egovResultDataList.size() > 0){
//				for(int i = 0 ; i < egovResultDataList.size(); i++){
//					
//					Map tempMap = (Map)egovResultDataList.get(i);
//					Iterator<String> keys = tempMap.keySet().iterator();
//					while( keys.hasNext() ){
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		returnDTO.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		returnDTO.set(key, tempMap.get(key));
//		            	}
//		            }
//				}
//			}
			
			psnl0110Vo = new Psnl0110VO();
			psnl0110Vo.setDpobCd(psnl010002Dto.getDpobCd());
			psnl0110Vo.setSystemkey(psnl010002Dto.getSystemkey());
			psnl0110Vo.setEmymtDivCd(psnl010002Dto.getEmymtDivCd());
			psnl0110Vo.setEmymtTypCd(psnl010002Dto.getEmymtTypCd());
			psnl0110Vo.setTypOccuCd(psnl010002Dto.getTypOccuCd());
			// 고용구분이 공무직이고 고용유형이 신규고용, 전보, 재고용, 직제개편인 경우해만 해당 로직 실행
			// 공무직일 경우에만 BASS360 작동
			if("A0020010".equals(psnl0100Dto.getEmymtDivCd()) &&  !"".equals(MSFSharedUtils.defaultNulls(psnl0110Vo.getTypOccuCd(), ""))) {
//				if("A0020010".equals(psnl0100Dto.getEmymtDivCd()) && psnl0100Dto.getTypOccuCd() != null || !"".equals(psnl0100Dto.getTypOccuCd())) {
				//TODO  신규 A0420010 , 직제개편 A0420050, 전보 A0420060, 재고용 A0420020, 연장계약 A0420030
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420020".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420030".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())) {
					
					
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					// 1. 가장 최신의 고용 이력 정보를 가져온다. (신규고용, 재고용, 직제개편, 전보, 연장계약 중)
					Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
					psnl0110SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
					psnl0110SrhVo.setSystemkey(psnl0110Vo.getSystemkey());
					
					
					Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
					returnPsnl0110Vo = psnl0110DAO.selectPsnl0110MaxData(psnl0110SrhVo);
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
					if(returnPsnl0110Vo != null) {
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 2. 단위기관 코드를 가져온다.
						InfcPkgBass0360SrhVO infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
						
						infcBass0360SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
						infcBass0360SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
						infcBass0360SrhVo.setTypOccuCd(returnPsnl0110Vo.getTypOccuCd());
						infcBass0360SrhVo.setDtilOccuInttnCd(returnPsnl0110Vo.getDtilOccuInttnCd());
						
						
						InfcPkgBass0360VO infcBass0360Vo = new InfcPkgBass0360VO();
						String strPayrMangDeptCd = "";
						
						@SuppressWarnings("unused")
						List infcBass0360List = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
	//					infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
						
						for (int i = 0; i < infcBass0360List.size(); i++) {
							EgovMap egovMap = (EgovMap) infcBass0360List.get(i);
							strPayrMangDeptCd = String.valueOf(egovMap.get("payrMangDeptCd"));
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
						
						
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 3. 해당 고용 정보를 가지고 단위기관 코드가 존재하는지 찾아본다.
						// 데이터 null 체크
						boolean datacChk = true;
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDpobCd())) {
							datacChk = false;
						}
						
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDeptCd())) {
							datacChk = false;
						}
						
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getTypOccuCd())) {
							datacChk = false;
						}
						
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDtilOccuInttnCd())) {
							datacChk = false;
						}
						
						// 데이터가 null 이 아닐 경우에만 실행.
						int iResult = 0;
						if(datacChk) {
							
							infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
							
							infcBass0360SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
							infcBass0360SrhVo.setPayrMangDeptCd(strPayrMangDeptCd);
							infcBass0360SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
							infcBass0360SrhVo.setTypOccuCd(returnPsnl0110Vo.getTypOccuCd());
							infcBass0360SrhVo.setDtilOccuInttnCd(returnPsnl0110Vo.getDtilOccuInttnCd());
							
							iResult = psnl0110DAO.selectBass0360PayrMangDeptCdTotCnt(infcBass0360SrhVo);
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						
						
						
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 4. 존재하면 그 값들을 가지고 PAYR0500 을 update 쳐주고 단위기관코드를 리턴, 존재하지 않을 경우 fail 리턴
						if(0 < iResult) {
							
							try{
								
								infcBass0360Vo = new InfcPkgBass0360VO();
								
								psnl0110Vo.setPayrMangDeptCd(strPayrMangDeptCd);
								psnl0110Vo.setIsmt(sessionUser.getUsrId());
								psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								
								psnl0110DAO.updatePayrMangDeptCdPayr0500(psnl0110Vo);
								strPayrMangDeptCd = infcBass0360Vo.getPayrMangDeptCd();
							}catch(Exception e) {
								
//								returnDTO.setDataChk("fail");
								e.printStackTrace();		
							}
						}else {
	//						strPayrMangDeptCd = "fail";
							// 기존 컨버전 데이트 중 직종세 권한 안 준 데이터 들로 인해서 fail 리턴 안하도록 처리..
//							returnDTO.setDataChk("fail");
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					}
				}
			
				
			// 기간제 근로자일경우 payr0500 단위기관코드 update 처리 해준다.
			}else if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
				//TODO  신규 A0420010 , 직제개편 A0420050, 전보 A0420060, 재고용 A0420020, 연장계약 A0420030
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420020".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420030".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())) {
					
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					// 1. 가장 최신의 고용 이력 정보를 가져온다. (신규고용, 재고용, 직제개편, 전보, 연장계약 중)
					Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
					psnl0110SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
					psnl0110SrhVo.setSystemkey(psnl0110Vo.getSystemkey());
					
					
					Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
					returnPsnl0110Vo = psnl0110DAO.selectPsnl0110MaxData(psnl0110SrhVo);
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
					
					
					if(returnPsnl0110Vo != null) {
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 2. 단위기관 코드를 가져온다.
						InfcPkgBass0400VO infcBass0400SrhVo = new InfcPkgBass0400VO();
						
						infcBass0400SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
						infcBass0400SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
						
						
						String strPayrMangDeptCd = "";
						
						@SuppressWarnings("unused")
						List infcBass0400List = psnl0100DAO.getPayrMangDeptCd_02(infcBass0400SrhVo);
	//					infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
						
						for (int i = 0; i < infcBass0400List.size(); i++) {
							EgovMap egovMap = (EgovMap) infcBass0400List.get(i);
							strPayrMangDeptCd = String.valueOf(egovMap.get("payrMangDeptCd"));
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
						
						
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 3.. 존재하면 그 값들을 가지고 PAYR0500 을 update 쳐주고 단위기관코드를 리턴
						if(!"".equals(strPayrMangDeptCd) || strPayrMangDeptCd != "") {
							
							try{
								
								
								psnl0110Vo.setPayrMangDeptCd(strPayrMangDeptCd);
								psnl0110Vo.setIsmt(sessionUser.getUsrId());
								psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								
								psnl0110DAO.updatePayrMangDeptCdPayr0500(psnl0110Vo);
								
							}catch(Exception e) {
								
//								returnDTO.setDataChk("fail");
								e.printStackTrace();		
							}
						}else {
	//						strPayrMangDeptCd = "fail";
							// 기존 컨버전 데이트 중 직종세 권한 안 준 데이터 들로 인해서 fail 리턴 안하도록 처리..
//							returnDTO.setDataChk("fail");
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					}
				}
			}
  			
  			
//  			if(result > 0) {
  				bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [마스터]", "저장 완료"));
//  			}else {
//  				bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [마스터]", "저장 실패"));
//  			}
  			
            
            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"처리완료[리스트에서 이상여부확인]",  "처리완료 ")); 
			
           	retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		}catch(Exception e){
			
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "인사 저장 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}		
		
		return retval;
	}
	
	
	
	/** 인사 고용 저장 처리 **/
	private ShowMessageBM psnl0110Save(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase, String systemkeyStr) {
		
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest());
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		
		String strPayrMangDeptCd = "";
		
		ShowMessageBM msg = new ShowMessageBM();
		int result = 0;
        
        try{
        	
        	
//        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 시작"));
	  		
        	Psnl0110VO psnl0110Vo 	= new Psnl0110VO();
	  		
	  		psnl0110Vo.setDpobCd(sessionUser.getDpobCd());
	  		psnl0110Vo.setSystemkey(systemkeyStr);
	  		psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl010002Dto.getEmymtSeilNum(), "0")));				/** column 고용일련번호 : emymtSeilNum */
	  		psnl0110Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getEmymtDivCd()));    										/** column 고용구분코드 : emymtDivCd */
	  		psnl0110Vo.setEmymtTypCd(MSFSharedUtils.allowNulls(psnl010002Dto.getEmymtTypCd()));    										/** column 고용유형코드 : emymtTypCd */
	  		psnl0110Vo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(psnl010002Dto.getEmymtBgnnDt()));    									/** column 고용시작일자 : emymtBgnnDt */
	    	psnl0110Vo.setEmymtEndDt(MSFSharedUtils.allowNulls(psnl010002Dto.getEmymtEndDt()));    										/** column 고용종료일자 : emymtEndDt */
	    	psnl0110Vo.setDeptCd(MSFSharedUtils.allowNulls(psnl010002Dto.getDeptCd()));    												/** column 부서코드 : deptCd */
	    	psnl0110Vo.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(psnl010002Dto.getCurrPaeWorkNm()));    								/** column 현근무지명 : currPaeWorkNm */
	    	psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl010002Dto.getBusinCd()));    											/** column 사업코드 : businCd */
	    	psnl0110Vo.setTypOccuCd(MSFSharedUtils.allowNulls(psnl010002Dto.getTypOccuCd()));    										/** column 직종코드 : typOccuCd */
	    	psnl0110Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl010002Dto.getDtilOccuInttnCd()));								/** column 직종통합코드 : dtilOccuInttnCd */
	    	psnl0110Vo.setOdtyCd(MSFSharedUtils.allowNulls(psnl010002Dto.getOdtyCd()));    												/** column 직책코드 : odtyCd */
	    	psnl0110Vo.setRetryDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getRetryDivCd()));    										/** column 퇴직이직사유구분코드 : retryDivCd */   
	    	psnl0110Vo.setRetryReasCtnt(MSFSharedUtils.allowNulls(psnl010002Dto.getRetryReasCtnt()));    								/** column 퇴직사유내용 : retryReasCtnt */
	    	psnl0110Vo.setIsmt(sessionUser.getUsrId());    																				/** column 수정자 : ismt */
	    	psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */
        	
        
    
        
	      	switch (actionDatabase) {
			case INSERT:
				
				psnl0110Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				psnl0110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
				
				psnl0110DAO.insertPsnl0110(psnl0110Vo);
				
				
				
				//신규 고용일때 병역 기간을 산정하여 인사 마스터 메인에 경력기간 년 월을 업데이트 시켜준다.
				// 근속년수 및 근속년월 업데이트 처리 시작###########################################
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) ||  "A0420090".equals(psnl0110Vo.getEmymtTypCd())){
					
					
					//100$급여소득세적용 최초입력 
					psnl0110Vo.setAddIncmTxApptnRtoCd(ExtermsProps.getProps("PAYR_TAX_B0290020"));
					
					//2014.09.18 신규고용일때 급여마스터 테이블 신규 등록처리.
					psnl0110DAO.mergeIntoPayr0500(psnl0110Vo);
					
					EgovMap map01 =  psnl0110DAO.selectInsrPsnl0110(psnl0110Vo);
					
					if (MSFSharedUtils.paramNotNull(map01)) {
					//신규고용인경우 4대보험 테이블에 데이터 인서트하기 
						InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
						InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
						InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
						InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
						
						
						insr3000Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
						insr3000Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
						insr3000Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */
						insr3000Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
						insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 

						
						insr4100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
						insr4100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
						insr4100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */ 
						insr4100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
						insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 		/** column 입력주소 : inptAddr */ 

					
						
						insr5100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
						insr5100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
						 
						insr5100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */ 
						insr5100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
						insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 

						
						insr6100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
						insr6100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */ 
						insr6100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */
						insr6100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
						insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 
						
						
						/**
						 * 단, 고용정보를 전체 다 삭제할 경우 이력이 남아있으므로 Insert시 오류나서
						 * 일단은 select 후 데이터 있으면 delete 후 다시 insert처리,  없으면 기존대로 insert 하게끔 처리함.
						 */
						InfcPkgInsr3000SrhVO insr3000SrhVo = new InfcPkgInsr3000SrhVO();
						
						insr3000SrhVo.setDpobCd(String.valueOf(map01.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						insr3000SrhVo.setSystemkey(String.valueOf(map01.get("systemkey")));    /** column SYSTEMKEY : systemkey */

						int iCnt = infcInsr3000DAO.selectInsr3000Cnt(insr3000SrhVo);
						
						
						if(iCnt == 0) {	//데이터 없으면 insert
							infcInsr3000DAO.insertInsr3000(insr3000Vo);
							infcInsr4100DAO.insertInsr4100(insr4100Vo);
							infcInsr5100DAO.insertInsr5100(insr5100Vo);
							infcInsr6100DAO.insertInsr6100(insr6100Vo);
							
						}else {			// 데이터 있으면 delete 후 insert
							
							infcInsr3000DAO.deleteInsr3000(insr3000Vo);
							infcInsr4100DAO.deleteInsr4100(insr4100Vo);
							infcInsr5100DAO.deleteInsr5100(insr5100Vo);
							infcInsr6100DAO.deleteInsr6100(insr6100Vo);
							
							infcInsr3000DAO.insertInsr3000(insr3000Vo);
							infcInsr4100DAO.insertInsr4100(insr4100Vo);
							infcInsr5100DAO.insertInsr5100(insr5100Vo);
							infcInsr6100DAO.insertInsr6100(insr6100Vo);
							
						}

					}
					/* 근속년수 코드 A007, 근속년월 코드 A006 : 둘다 MANAGE_ITEM01 참조
						A0290000    A029    0000    해당없음
						A0290001    A029    0001    최대 6개월
						A0290002    A029    0002    최대 1년
						A0290003    A029    0003    최대 2년
						A0290004    A029    0004    최대 3년
						A029000A    A029    000A    모두인정
					*/
					EgovMap map = psnl0110DAO.getLogSvcData(psnl0110Vo);
					
					int year = 0; //업데이트 년
					int month = 0; //업데이트 월
					if(map != null ){
						
						int diffMonths = 0;
						if (MSFSharedUtils.paramNull(map.get("diffMonths"))) {
							diffMonths = 0;
						} else {
							diffMonths = map.get("diffMonths") == null ? 0 : Integer.parseInt(String.valueOf(map.get("diffMonths")));
						}
						 if("A0290001".equals(map.get("servcRcgtnPridCd"))){
							if(diffMonths > 6){
								month = 6;
							}else{
								if (MSFSharedUtils.paramNotNull(map.get("diffMonth"))) {
									if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
										month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
									}
								}
							}
							
						}else if("A0290002".equals(map.get("servcRcgtnPridCd"))){
							if(diffMonths > 12){
								year = 1;
								month = 0;
							}else{
								if (MSFSharedUtils.paramNotNull(map.get("diffMonth"))) {
									if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
										month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
									}
								}
							}
						}else if("A0290003".equals(map.get("servcRcgtnPridCd"))){
							if(diffMonths > 24){
								year = 2;
								month = 0;
							}else{
								if (MSFSharedUtils.paramNotNull(map.get("diffYear"))) {	
									if(String.valueOf(map.get("diffYear")) != null || "".equals(String.valueOf(map.get("diffYear"))))  {
										year = Integer.parseInt(String.valueOf(map.get("diffYear")));
									}
									
									if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
										month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
									}
								}
							}
						}else if("A0290004".equals(map.get("servcRcgtnPridCd"))){
							if(diffMonths > 36){
								year = 3;
								month = 0;
							}else{
								if (MSFSharedUtils.paramNotNull(map.get("diffYear"))) {		
									if(String.valueOf(map.get("diffYear")) != null || "".equals(String.valueOf(map.get("diffYear"))))  {
										year = Integer.parseInt(String.valueOf(map.get("diffYear")));
									}
									
									
									if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
										month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
									}
								}	
							}
						}else if("A029000A".equals(map.get("servcRcgtnPridCd"))){
							
							if (MSFSharedUtils.paramNotNull(map.get("diffYear"))) {		
								if(String.valueOf(map.get("diffYear")) != null || "".equals(String.valueOf(map.get("diffYear"))))  {
									year = Integer.parseInt(String.valueOf(map.get("diffYear")));
								}
								
								
								if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
									month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
								}
							}
//							year = Integer.parseInt(String.valueOf(map.get("diffYear")));
//							month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
						}
					}
					HashMap<String, String> tempMap = new HashMap<String, String>();
					tempMap.put("dpobCd", psnl0110Vo.getDpobCd());
					tempMap.put("systemkey", psnl0110Vo.getSystemkey());
					
//					psnl0110Vo.setDpobCd(tempMap.get("dpobCd"));
//					psnl0110Vo.setSystemkey(tempMap.get("systemkey"));
					
					
					if(year>0){
						tempMap.put("year",year+"");
						psnl0110Vo.setYear(tempMap.get("year"));
						
						try{
							psnl0110DAO.updateYearMst(psnl0110Vo);
						}catch(Exception e) {
							MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updateYearMst" + e); 
					        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0110DAO.updateYearMst", errMsg, logger) ; 
						}
					}
					if(month>0){
						tempMap.put("month",month+"");
						psnl0110Vo.setMonth(tempMap.get("month"));
						
						try{
							psnl0110DAO.updateMonthMst(psnl0110Vo);
						}catch(Exception e) {
							MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updateMonthMst" + e); 
					        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0110DAO.updateMonthMst", errMsg, logger) ; 
						}
						
//						psnl0110DAO.updateMonthMst(tempMap);
						
					}
					tempMap = new HashMap<String, String>();
					// 근속년수 및 근속년월 업데이트 처리 끝###########################################
					
					
					// 2017.09.22
        			// 신규고용일 경우 해당 테이블 데이터 update 처리
        			Psnl0101VO psnl0101Vo = new Psnl0101VO();
        			
        			psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0110Vo.getDpobCd()));    							/** column 사업장코드 : dpobCd */
        			psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Vo.getSystemkey()));							/** column SYSTEMKEY : systemkey */
//        			psnl0101Vo.setPsnlBseSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("psnlBseSeilNum")));    /** column 통계기준일련번호 : psnlBseSeilNum */
        			psnl0101Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0110Vo.getEmymtDivCd()));   						/** column 고용구분코드 : emymtDivCd */
        			psnl0101Vo.setFrstBseEmymtDt(psnl0110Vo.getEmymtBgnnDt());												/** column 최초고용일자 : frstBseEmymtDt */
        			psnl0101Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
        			psnl0101Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());						/** column 수정주소 : revnAddr */
                	
        			// 공무직전환자의 경우 해당일자를 최초고용일자로 해준다.
        			if(	"A0420090".equals(psnl0110Vo.getEmymtTypCd())) {
        				psnl0101Vo.setEmymtTypCd("A0420090");
        			}
        			
        			
        			psnl0101DAO.deletePsnl0101(psnl0101Vo);
					psnl0101DAO.insertPsnl0101(psnl0101Vo);
					
					
					
				} else if("A0420990".equals(psnl0110Vo.getEmymtTypCd())){
				    //퇴직일경우 마스터 업데이트 
				    Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
				    psnl0100Dto.setDpobCd(psnl0110Vo.getDpobCd());
                    psnl0100Dto.setSystemkey(psnl0110Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                    psnl0100Dto.setHdofcCodtnCd("A0030020");   //마스터 퇴
                    psnl0100Dto.setRetryDt(MSFSharedUtils.paramNull(psnl0110Vo.getEmymtEndDt()) ? psnl0110Vo.getEmymtBgnnDt() : psnl0110Vo.getEmymtEndDt());
                    psnl0100Dto.setRetryReasCtnt(psnl0110Vo.getEmymtReasCtnt()); 
                    
                    
                    try{
                    	psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
					}catch(Exception e) {
						MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updatePsnl0100ToPsnlStat" + e); 
				        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto)", errMsg, logger) ; 
					}
                    
				    
				} else if("A0420040".equals(psnl0110Vo.getEmymtTypCd())){
                    //휴직일경우 마스터 업데이트 
                    Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
                    psnl0100Dto.setDpobCd(psnl0110Vo.getDpobCd());
                    psnl0100Dto.setSystemkey(psnl0110Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                    psnl0100Dto.setHdofcCodtnCd("A0030030");   //마스터 휴직
                    psnl0100Dto.setRetryDt(null);
                    psnl0100Dto.setRetryReasCtnt(""); 
                    
                    
                    try{
                    	psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
					}catch(Exception e) {
						MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updatePsnl0100ToPsnlStat" + e); 
				        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto)", errMsg, logger) ; 
					}
                    
                }
			
			
				break;
				
	    	case UPDATE: 
	    		
	    		
	    		/**
				 * 고용 정보 수정 시 쿼리에서 
				 * 퇴직 AND 공무직 -> 직종, 직종세를 입력하지 않았을 경우 고용에서 퇴직, 휴직을 제외한 제일 최신의 값을 가져와 UPDATE
				 * 퇴직 -> 공무직, 기간제 근로자 모두 부서와 직책을 입력하지 않았을 경우 고용에서 퇴직, 휴직을 제외한 제일 최신의 값을 가져와 UPDATE 
				 * **/
	    		psnl0110Vo.setEmymtSeilNum(new BigDecimal(1));
				psnl0110DAO.updatePsnl0110(psnl0110Vo);
				
				if("A0420990".equals(psnl0110Vo.getEmymtTypCd())){
				    //퇴직일경우 마스터 업데이트 
				    Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
				    psnl0100Dto.setDpobCd(psnl0110Vo.getDpobCd());
                    psnl0100Dto.setSystemkey(psnl0110Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                    psnl0100Dto.setHdofcCodtnCd("A0030020");   //마스터 퇴직
                    psnl0100Dto.setRetryDt(MSFSharedUtils.paramNull(psnl0110Vo.getEmymtEndDt()) ? psnl0110Vo.getEmymtBgnnDt() : psnl0110Vo.getEmymtEndDt());
                    psnl0100Dto.setRetryReasCtnt(psnl0110Vo.getEmymtReasCtnt()); 
                    
                    psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
				    
				} else if("A0420040".equals(psnl0110Vo.getEmymtTypCd())){
                    //휴직일경우 마스터 업데이트 
                    Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
                    psnl0100Dto.setDpobCd(psnl0110Vo.getDpobCd());
                    psnl0100Dto.setSystemkey(psnl0110Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                    psnl0100Dto.setHdofcCodtnCd("A0030030");   //마스터 휴직
                    psnl0100Dto.setRetryDt(null);
                    psnl0100Dto.setRetryReasCtnt(""); 
                     
                    psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
                
                } else if("A0420010".equals(psnl0110Vo.getEmymtTypCd())) {
                	
                	// 신규고용일 경우 사대보험에 insert 해줌
                	InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
					InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
					InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
					InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
					
					insr3000Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr3000Vo.setSystemkey(psnl0110Vo.getSystemkey());    														/** column SYSTEMKEY : systemkey */
					insr3000Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */
					insr3000Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 

					insr4100Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr4100Vo.setSystemkey(psnl0110Vo.getSystemkey());    														/** column SYSTEMKEY : systemkey */
					insr4100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */ 
					insr4100Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 

				
					insr5100Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr5100Vo.setSystemkey(psnl0110Vo.getSystemkey());    														/** column SYSTEMKEY : systemkey */
					insr5100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */ 
					insr5100Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 

					
					insr6100Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr6100Vo.setSystemkey(psnl0110Vo.getSystemkey());   	 													/** column SYSTEMKEY : systemkey */ 
					insr6100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */
					insr6100Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 
                	
					infcInsr3000DAO.deleteInsr3000(insr3000Vo);
					infcInsr4100DAO.deleteInsr4100(insr4100Vo);
					infcInsr5100DAO.deleteInsr5100(insr5100Vo);
					infcInsr6100DAO.deleteInsr6100(insr6100Vo);
					
					infcInsr3000DAO.insertInsr3000(insr3000Vo);
					infcInsr4100DAO.insertInsr4100(insr4100Vo);
					infcInsr5100DAO.insertInsr5100(insr5100Vo);
					infcInsr6100DAO.insertInsr6100(insr6100Vo);
                	
                }else {
                	
                	// 신규고용이 아닐 경우 사대보험 테이블에서 지워줌
                	
                	InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
					InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
					InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
					InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
					
					insr3000Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr3000Vo.setSystemkey(psnl0110Vo.getSystemkey());    														/** column SYSTEMKEY : systemkey */
					insr3000Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */
					insr3000Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 

					insr4100Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr4100Vo.setSystemkey(psnl0110Vo.getSystemkey());    														/** column SYSTEMKEY : systemkey */
					insr4100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */ 
					insr4100Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 

				
					insr5100Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr5100Vo.setSystemkey(psnl0110Vo.getSystemkey());    														/** column SYSTEMKEY : systemkey */
					insr5100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */ 
					insr5100Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 

					
					insr6100Vo.setDpobCd(psnl0110Vo.getDpobCd());    															/** column 사업장코드 : dpobCd */
					insr6100Vo.setSystemkey(psnl0110Vo.getSystemkey());   	 													/** column SYSTEMKEY : systemkey */ 
					insr6100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));	/** column 고용일련번호 : emymtSeilNum */
					insr6100Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */ 
					insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 입력주소 : inptAddr */ 
                	
					infcInsr3000DAO.deleteInsr3000(insr3000Vo);
					infcInsr4100DAO.deleteInsr4100(insr4100Vo);
					infcInsr5100DAO.deleteInsr5100(insr5100Vo);
					infcInsr6100DAO.deleteInsr6100(insr6100Vo);
                	
                }
				
	    		break;
	      	} 
	      	
	      	
	    	//BASS0360 에 단위기관, 직종, 직종세, 부서 입력되어 있는지 체크
			strPayrMangDeptCd = checkBass0360(psnl0110Vo);
			
			if("fail".equals(strPayrMangDeptCd)) {
				MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다."); 
		        throw MSFServerUtils.getValidationException("Psnl0100ServiceImpl.checkBass0360", errMsg, logger) ; 
			}else {
				
			}
	      	
	      	
	    	// 2017.06.19 공무직이면서 퇴직,전보, 직제개편 추가
			if( "A0020010".equals(psnl0110Vo.getEmymtDivCd())){
				
				if("A0420990".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())) {
					psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Vo.getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
					
					psnl0110DAO.updateEmymtEndDate(psnl0110Vo);
					
					//부서 및 직종이 비어 있는경우 처리를 위해 
				//	psnl0110DAO.selectPsnl0110(changePsnl0110List.get(i));
				}
			}	
			
			
			// 신규 일 경우 사대보험 테이블 처리 관련
			if("A0420010".equals(psnl0110Vo.getEmymtTypCd())) {
            	// psnl0127 insert
				// 해당년도에 데이터 있으면 삭제 후 다시 생성
				if(MSFSharedUtils.paramNotNull(psnl0110Vo.getEmymtBgnnDt())) {
					
					
					Psnl0127VO psnl0127Vo = new Psnl0127VO();
					
					psnl0127Vo.setDpobCd(psnl0110Vo.getDpobCd());
					psnl0127Vo.setSystemkey(psnl0110Vo.getSystemkey());
					psnl0127Vo.setSoctyInsurYr(psnl0110Vo.getEmymtBgnnDt().substring(0, 4));
					
					psnl0127Vo.setKybdr(sessionUser.getUsrId());
					psnl0127Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

					psnl0127Vo.setIsmt(sessionUser.getUsrId());
					psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					psnl0127DAO.deletePsnl0127(psnl0127Vo);
					psnl0127DAO.insertPsnl0127(psnl0127Vo);
				}
			}
			
			
			msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [고용]", "저장 완료");
      	
        }catch(Exception e) {
        	
        	MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "인적 고용 중 에러가 발생했습니다. : psnl0110Save" + e); 
	        throw MSFServerUtils.getValidationException("PsnlP010002ServiceImpl.psnl0110Save()", errMsg, logger) ; 
        	
        }
        
		return msg;
		
	}
	
	
	
	
	/** 인사 인적 저장 처리 **/
	private ShowMessageBM psnl0111Save(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase, String systemkeyStr) {
		
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		
		ShowMessageBM msg = new ShowMessageBM();
		int result = 0;
        
        try{
        	
        	
//        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 시작"));
	  		
        	Psnl0111DTO psnl0111Dto = new Psnl0111DTO();
	  		
	  		psnl0111Dto.setDpobCd(sessionUser.getDpobCd());
	  		psnl0111Dto.setSystemkey(systemkeyStr);
	  		psnl0111Dto.setHusRoadNmZpcd(MSFSharedUtils.allowNulls(psnl010002Dto.getHusRoadNmZpcd()));    								/** column 집도로명우편번호 : husRoadNmZpcd */
	  		psnl0111Dto.setHusRoadNmFndtnAddr(MSFSharedUtils.allowNulls(psnl010002Dto.getHusRoadNmFndtnAddr()));    					/** column 집도로명기본주소 : husRoadNmFndtnAddr */
	  		psnl0111Dto.setHusRoadNmDtlPatrAddr(MSFSharedUtils.allowNulls(psnl010002Dto.getHusRoadNmDtlPatrAddr()));    				/** column 집도로명상세주소 : husRoadNmDtlPatrAddr */
	  		psnl0111Dto.setHusZpcd(MSFSharedUtils.allowNulls(psnl010002Dto.getHusZpcd()));    											/** column 집우편번호 : husZpcd */
	  		psnl0111Dto.setBthcAddr(MSFSharedUtils.allowNulls(psnl010002Dto.getBthcAddr()));   			 								/** column 출생지주소 : bthcAddr */
	  		psnl0111Dto.setHfmlyNm(MSFSharedUtils.allowNulls(psnl010002Dto.getHfmlyNm()));    											/** column 호주성명 : hfmlyNm */
	  		psnl0111Dto.setHfmlyRelaCd(MSFSharedUtils.allowNulls(psnl010002Dto.getHfmlyRelaCd()));   									/** column 호주와의관계코드 : hfmlyRelaCd */
	  		psnl0111Dto.setCellPhneNum(MSFSharedUtils.allowNulls(psnl010002Dto.getCellPhneNum()));    									/** column 핸드폰번호 : cellPhneNum */
	  		psnl0111Dto.setHusPhnNum(MSFSharedUtils.allowNulls(psnl010002Dto.getHusPhnNum()));    										/** column 집전화번호 : husPhnNum */
	  		psnl0111Dto.setEmailAddr(MSFSharedUtils.allowNulls(psnl010002Dto.getEmailAddr()));    										/** column 이메일주소 : emailAddr */
	  		psnl0111Dto.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
	  		psnl0111Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */
        	
        
    
        
	      	switch (actionDatabase) {
			case INSERT:
				
				psnl0111Dto.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				psnl0111Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
				
				
				
				result = psnl0111DAO.savePsnl0111(psnl0111Dto);
				
				if(result > 0) {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 완료");
				}else {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 실패");
				}
				
//		        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 완료"));
			
				break;
				
	    	case UPDATE: 
	    		
	    		result =  psnl0111DAO.savePsnl0111(psnl0111Dto);
//	            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 완료"));
	    		if(result > 0) {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 완료");
				}else {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [인적]", "저장 실패");
				}
	    		break;
	      	} 
      	
        }catch(Exception e) {
        	
        	MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "인적 저장 중 에러가 발생했습니다. : psnl0111Save" + e); 
	        throw MSFServerUtils.getValidationException("PsnlP010002ServiceImpl.psnl0111Save()", errMsg, logger) ; 
        	
        }
        
		return msg;
		
	}
	
	
	
	/** 인사 병역 저장 처리 **/
	private ShowMessageBM psnl0112Save(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase, String systemkeyStr) {
		
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		ShowMessageBM msg = new ShowMessageBM();
		int result = 0;
		
		
        try{
        	
        	
//        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 시작"));
	  		
	  		
        	Psnl0112DTO psnl0112Dto = new Psnl0112DTO();
	    	
	    	psnl0112Dto.setDpobCd(sessionUser.getDpobCd());
	    	psnl0112Dto.setSystemkey(systemkeyStr);
	    	psnl0112Dto.setEnrlntDt(MSFSharedUtils.allowNulls(psnl010002Dto.getEnrlntDt()));    										/** column 입대일자 : enrlntDt */
	    	psnl0112Dto.setDsageDt(MSFSharedUtils.allowNulls(psnl010002Dto.getDsageDt()));    											/** column 제대일자 : dsageDt */
	    	psnl0112Dto.setServcRcgtnPridCd(MSFSharedUtils.allowNulls(psnl010002Dto.getServcRcgtnPridCd()));							/** column 복무인정기간코드 : servcRcgtnPridCd */
	    	psnl0112Dto.setSrvssCd(MSFSharedUtils.allowNulls(psnl010002Dto.getSrvssCd()));    											/** column 역종코드 : srvssCd */
	    	psnl0112Dto.setBaggrpCd(MSFSharedUtils.allowNulls(psnl010002Dto.getBaggrpCd()));    										/** column 군별코드 : baggrpCd */
	    	psnl0112Dto.setAbotsCd(MSFSharedUtils.allowNulls(psnl010002Dto.getAbotsCd()));    											/** column 병과코드 : abotsCd */
	    	psnl0112Dto.setClsCd(MSFSharedUtils.allowNulls(psnl010002Dto.getClsCd()));    												/** column 계급코드 : clsCd */
	    	psnl0112Dto.setMitySilnum(MSFSharedUtils.allowNulls(psnl010002Dto.getMitySilnum()));    									/** column 군번 : mitySilnum */
	    	psnl0112Dto.setMos(MSFSharedUtils.allowNulls(psnl010002Dto.getMos()));    													/** column MOS : mos */
	    	psnl0112Dto.setDsageDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getDsageDivCd()));    									/** column 제대구분코드 : dsageDivCd */
	    	psnl0112Dto.setExmtnReasCd(MSFSharedUtils.allowNulls(psnl010002Dto.getExmtnReasCd()));    									/** column 면제사유코드 : exmtnReasCd */
	    	psnl0112Dto.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
	    	psnl0112Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */
        	
        
    
        
	      	switch (actionDatabase) {
			case INSERT:
				
				psnl0112Dto.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				psnl0112Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
				
				result = psnl0112DAO.savePsnl0112(psnl0112Dto);
				
				
				if(result > 0) {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 완료");
				}else {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 실패");
				}
				
//		        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 완료"));
				break;
				
	    	case UPDATE: 
	    		
	    		result = psnl0112DAO.savePsnl0112(psnl0112Dto);
				
				
				if(result > 0) {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 완료");
				}else {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 실패");
				}
				
//	            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [병역]", "저장 완료"));
	    		break;
	      	} 
      	
        }catch(Exception e) {
        	
        	MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "병역 저장 중 에러가 발생했습니다. : psnl0112Save" + e); 
	        throw MSFServerUtils.getValidationException("PsnlP010002ServiceImpl.psnl0112Save()", errMsg, logger) ; 
        	
        }
        
		
		return msg;
		
	}
	
	
	
	/** 인사 신상 저장 처리 **/
	private ShowMessageBM psnl0113Save(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase, String systemkeyStr) {
		
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		ShowMessageBM msg = new ShowMessageBM();
		int result = 0;
		
        
        try{
        	
        	
//        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 시작"));
	  		
	  		
        	Psnl0113DTO psnl0113Dto = new Psnl0113DTO();
	    	
	    	psnl0113Dto.setDpobCd(sessionUser.getDpobCd());
	    	psnl0113Dto.setSystemkey(systemkeyStr);
	    	psnl0113Dto.setSttur(MSFSharedUtils.allowNulls(psnl010002Dto.getSttur()));    												/** column 신장 : sttur */
	    	psnl0113Dto.setWei(MSFSharedUtils.allowNulls(psnl010002Dto.getWei()));   	 												/** column 체중 : wei */
	    	psnl0113Dto.setBldtpDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getBldtpDivCd()));    									/** column 혈액형구분코드 : bldtpDivCd */
	    	psnl0113Dto.setPrmtsaYn(MSFSharedUtils.allowNulls(psnl010002Dto.getPrmtsaYn()));    										/** column 색맹여부 : prmtsaYn */
	    	psnl0113Dto.setTnkeeVsnLf(MSFSharedUtils.allowNulls(psnl010002Dto.getTnkeeVsnLf()));    									/** column 나안시력_좌 : tnkeeVsnLf */
	    	psnl0113Dto.setTnkeeVsnRght(MSFSharedUtils.allowNulls(psnl010002Dto.getTnkeeVsnRght()));    								/** column 나안시력_우 : tnkeeVsnRght */
	    	psnl0113Dto.setCorrVsnLf(MSFSharedUtils.allowNulls(psnl010002Dto.getCorrVsnLf()));    										/** column 교정시력_좌 : corrVsnLf */
	    	psnl0113Dto.setCorrVsnRght(MSFSharedUtils.allowNulls(psnl010002Dto.getCorrVsnRght()));    									/** column 교정시력_우 : corrVsnRght */
	    	psnl0113Dto.setRelnFrmCd(MSFSharedUtils.allowNulls(psnl010002Dto.getRelnFrmCd()));    										/** column 종교유형코드 : relnFrmCd */
	    	psnl0113Dto.setHbbyCtnt(MSFSharedUtils.allowNulls(psnl010002Dto.getHbbyCtnt()));    										/** column 취미내용 : hbbyCtnt */
	    	psnl0113Dto.setSpityCtnt(MSFSharedUtils.allowNulls(psnl010002Dto.getSpityCtnt()));    										/** column 특기내용 : spityCtnt */	
	    	psnl0113Dto.setHlthCodtnCtnt(MSFSharedUtils.allowNulls(psnl010002Dto.getHlthCodtnCtnt()));   								/** column 건강상태내용 : hlthCodtnCtnt */
	    	psnl0113Dto.setDabtyDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getDabtyDivCd()));    									/** column 장애구분코드 : dabtyDivCd */
	    	psnl0113Dto.setDabtyGrdeCd(MSFSharedUtils.allowNulls(psnl010002Dto.getDabtyGrdeCd()));    									/** column 장애등급코드 : dabtyGrdeCd */
	    	psnl0113Dto.setDabtyAjmtDt(MSFSharedUtils.allowNulls(psnl010002Dto.getDabtyAjmtDt()));    									/** column 장애판정일자 : dabtyAjmtDt */
	    	psnl0113Dto.setPattVetnsDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getPattVetnsDivCd()));    							/** column 보훈구분코드 : pattVetnsDivCd */
	    	psnl0113Dto.setPattVetnsNum(MSFSharedUtils.allowNulls(psnl010002Dto.getPattVetnsNum()));    								/** column 보훈번호 : pattVetnsNum */
	    	psnl0113Dto.setAmomRelaDivCd(MSFSharedUtils.allowNulls(psnl010002Dto.getAmomRelaDivCd()));    								/** column 유공자와의관계구분코드 : amomRelaDivCd */
	    	psnl0113Dto.setPattVetnsYn(MSFSharedUtils.allowNulls(psnl010002Dto.getPattVetnsYn()));    									/** column 보훈여부 : pattVetnsYn */
	    	psnl0113Dto.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
	    	psnl0113Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */
        	
        
    
        
	      	switch (actionDatabase) {
			case INSERT:
				
				psnl0113Dto.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				psnl0113Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
				
				
				psnl0113DAO.insertPsnl0113(psnl0113Dto);
				
				msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 완료");
				
				
//		        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 완료"));
				break;
				
	    	case UPDATE: 
	    		
	    		result = psnl0113DAO.updatePsnl0113(psnl0113Dto);
				
				if(result > 0) {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 완료");
				}else {
					msg = new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 실패");
				}
				
//	            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"PSNL","인사신규등록" ,"인사 [신상]", "저장 완료"));
	    		break;
	      	} 
      	
        }catch(Exception e) {
        	
        	MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "신상 저장 중 에러가 발생했습니다. : psnl0113Save" + e); 
	        throw MSFServerUtils.getValidationException("PsnlP010002ServiceImpl.psnl0113Save()", errMsg, logger) ; 
        	
        }
        
		
		return msg;
		
	}
	
	
	
	/** 근로자 정보 저장 후 데이터 조회하여 보여줌 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getSystemkey(Psnl010002DTO psnl010002Dto) throws MSFException {
		
		
		Psnl010002DTO resultPsnl010002Dto = new Psnl010002DTO();
		
		String SystemkeyStr = "";
		
		String method = calledClass + ".getPsnlAllData";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
//		List<Psnl0100DTO> returnValue = new ArrayList<Psnl0100DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		Long result = new Long(0);
		
		
		Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		psnl0100Dto.setDpobCd(sessionUser.getDpobCd());
		// 파라미터 보낼 때(암호화)
		psnl0100Dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl010002Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
		
		
		try{
			
			
			// -- 인사 기본 정보를 가지고 온다.
			egovResultDataList = psnl0100DAO.selectPsnl0100Check(psnl0100Dto);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					EgovMap egovMap = (EgovMap) egovResultDataList.get(i);
					SystemkeyStr = String.valueOf(egovMap.get("systemkey"));
					
					
//					// 복호화 리턴받을 값 선언
//					String rrnDecCrypt = "";
//					
//					psnl0100Dto = new Psnl0100DTO();
//					
//					Map tempMap = (Map)egovResultDataList.get(i);
//					
//					Iterator<String> keys = tempMap.keySet().iterator();
//					
//					while( keys.hasNext() ){
//						
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		psnl0100Dto.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		psnl0100Dto.set(key, tempMap.get(key));
//		            	}
//		            }
//					
//					// 복호화
//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0100Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					psnl0100Dto.setResnRegnNum(rrnDecCrypt);
//					
				}
			}else {
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);

			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		return SystemkeyStr;
	}
	
	
	/** 고용 등록시 입력한 직종, 직종세가 BASS00360에 등록되어 있는지 확인 후 없으면 insert, 있으면 pass **/
	public String checkBass0360(Psnl0110VO psnl0110Vo) {
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".checkBass0360";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String strResult = "";
		
		try {
			// 공무직일 경우에만 BASS360 작동
			if("A0020010".equals(psnl0110Vo.getEmymtDivCd()) && ( psnl0110Vo.getTypOccuCd() != null || !"".equals(psnl0110Vo.getTypOccuCd())) ) {
				
				//TODO  신규 A0420010 , 직제개편 A0420050, 전보 A0420060, 재고용 A0420020, 연장계약 A0420030 , 복직 A0420070
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420020".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420030".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420070".equals(psnl0110Vo.getEmymtTypCd())
						
						) {
					
					InfcPkgBass0360SrhVO infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
					
					infcBass0360SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
					infcBass0360SrhVo.setDeptCd(psnl0110Vo.getDeptCd());
					infcBass0360SrhVo.setTypOccuCd(psnl0110Vo.getTypOccuCd());
					infcBass0360SrhVo.setDtilOccuInttnCd(psnl0110Vo.getDtilOccuInttnCd());
					
					
					InfcPkgBass0360VO infcBass0360Vo = new InfcPkgBass0360VO();
					
					//단위기관 코드를 가져옴
					@SuppressWarnings("unused")
					List infcBass0360List = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
//					infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
					
					for (int i = 0; i < infcBass0360List.size(); i++) {
						EgovMap egovMap = (EgovMap) infcBass0360List.get(i);
						infcBass0360SrhVo.setPayrMangDeptCd(String.valueOf(egovMap.get("payrMangDeptCd")));
					}
					
//					infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Vo.getPayrMangDeptCd());
					
					// 2016.09.07
					// 사업장, 부서, 직종, 직종세 비교 후 맞는 데이터가 없으면 insert
					// 없으면 단위기관 코드가 없을 경우만 update 처리..
					int iResult = infcBass0360DAO.selectBass0360ListTotCnt(infcBass0360SrhVo);
					
					
					infcBass0360Vo = new InfcPkgBass0360VO();
					infcBass0360Vo.setDpobCd(infcBass0360SrhVo.getDpobCd());
					infcBass0360Vo.setDeptCd(infcBass0360SrhVo.getDeptCd());
					infcBass0360Vo.setTypOccuCd(infcBass0360SrhVo.getTypOccuCd());
					infcBass0360Vo.setDtilOccuInttnCd(infcBass0360SrhVo.getDtilOccuInttnCd());
					infcBass0360Vo.setPayrMangDeptCd(infcBass0360SrhVo.getPayrMangDeptCd());
	
			
					
					
					if(iResult == 0) {
						
						infcBass0360Vo.setKybdr(sessionUser.getUsrId());
						infcBass0360Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						infcBass0360DAO.insertBass0360(infcBass0360Vo);
//						strResult = infcBass0360Vo.getPayrMangDeptCd();
						
					}else{
						
						infcBass0360Vo.setIsmt(sessionUser.getUsrId());
						infcBass0360Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						// 단위기관이 맵핑되어 있지 않은 데이터를 맵핑하여 사용한다.
						infcBass0360DAO.updateBass0360PayrMangDeptCd(infcBass0360Vo);
						
						
					}
					
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					// 1. 가장 최신의 고용 이력 정보를 가져온다. (신규고용, 재고용, 직제개편, 전보 중)
//					Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
//					psnl0110SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
//					psnl0110SrhVo.setSystemkey(psnl0110Vo.getSystemkey());
//					
//					
//					Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
//					returnPsnl0110Vo = psnl0110DAO.selectPsnl0110MaxData(psnl0110SrhVo);
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					
//					
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					// 2. 해당 고용 정보를 가지고 단위기관 코드가 존재하는지 찾아본다.
//					// 데이터 null 체크
//					boolean datacChk = true;
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDpobCd())) {
//						datacChk = false;
//					}
//					
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDeptCd())) {
//						datacChk = false;
//					}
//					
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getTypOccuCd())) {
//						datacChk = false;
//					}
//					
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDtilOccuInttnCd())) {
//						datacChk = false;
//					}
//					
//					// 데이터가 null 이 아닐 경우에만 실행.
//					iResult = 0;
//					if(datacChk) {
//						infcBass0360SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
//						infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Vo.getPayrMangDeptCd());
//						infcBass0360SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
//						infcBass0360SrhVo.setTypOccuCd(returnPsnl0110Vo.getTypOccuCd());
//						infcBass0360SrhVo.setDtilOccuInttnCd(returnPsnl0110Vo.getDtilOccuInttnCd());
//						
//						iResult = psnl0110DAO.selectBass0360PayrMangDeptCdTotCnt(infcBass0360SrhVo);
//					}
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					
//					
//					
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					// 3. 존재하면 그 값들을 가지고 PAYR0500 을 update 쳐주고 단위기관코드를 리턴, 존재하지 않을 경우 fail 리턴
//					if(0 < iResult) {
//						
//						try{
//							
//							psnl0110Vo.setPayrMangDeptCd(infcBass0360Vo.getPayrMangDeptCd());
//							psnl0110Vo.setIsmt(sessionUser.getUsrId());
//							psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//							
//							psnl0110DAO.updatePayrMangDeptCdPayr0500(psnl0110Vo);
//							strResult = infcBass0360Vo.getPayrMangDeptCd();
//						}catch(Exception e) {
//							strResult = "fail";
//							e.printStackTrace();		
//						}
//					}else {
//						strResult = "fail";
//					}
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
				}else {
					
				}

			}else {

			}

		}catch(Exception e) {
			
			strResult = "fail";
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C:U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);	
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C" );
		
		return strResult;
	}
	
	
	
	

	
	
}
