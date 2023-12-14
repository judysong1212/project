package com.app.exterms.personal.server.service;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.InfcPkgPsnl0115DTO;
import com.app.exterms.personal.client.service.InfcPkgPsnl0115Service;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0115DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0115VO;

/**
 * @Class Name : Psnl0100ServiceImpl.java
 * @Description : Psnl0100 Business Implement class
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
@Service("InfcPkgPsnl0115Service")
public class InfcPkgPsnl0115ServiceImpl extends AbstractCustomServiceImpl implements InfcPkgPsnl0115Service {
	
	 private static final  Logger logger = LoggerFactory.getLogger(InfcPkgPsnl0115ServiceImpl.class);
	 private static final String calledClass = InfcPkgPsnl0115ServiceImpl.class.getName();
	    
	@Autowired
    @Resource(name="InfcPkgPsnl0115DAO")
    private InfcPkgPsnl0115DAO psnl0115DAO;
	 
 

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Long insertOnPsnl0115(InfcPkgPsnl0115DTO infcPsnl0115Dto, ActionDatabase actionDatabase)throws MSFException {
		// TODO Auto-generated method stub
		
		
		Long returnValue = new Long(1);
		
		String windowNm = "급여";
		String windowId = "PayrP410003";
		
		
		
		String method = calledClass + ".insertOnPsnl0115";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		//암호화 객체 생성
		String nResult = null;
		
		try {
			nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	
		
		
		try{

			
			InfcPkgPsnl0115VO infcPsnl0115Vo = new InfcPkgPsnl0115VO(); 
			
			
			infcPsnl0115Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
			infcPsnl0115Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
			infcPsnl0115Vo.setFamyRelaDivCd(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getFamyRelaDivCd()));    	/** column 가족관계구분코드 : famyRelaDivCd */
			infcPsnl0115Vo.setFamyNm(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getFamyNm()));    				/** column 가족성명 : famyNm */
			
			if(MSFSharedUtils.paramNotNull(infcPsnl0115Dto.getFamyResnRegnNum() )  )  {   			
				
				if(infcPsnl0115Dto.getFamyResnRegnNum().substring(6, 7) == "1" 
						|| "1".equals(infcPsnl0115Dto.getFamyResnRegnNum().substring(6, 7))
						||  infcPsnl0115Dto.getFamyResnRegnNum().substring(6, 7) == "2" 
						|| "2".equals(infcPsnl0115Dto.getFamyResnRegnNum().substring(6, 7)) ) {
					
					infcPsnl0115Vo.setYoobhMnthDay("19" + infcPsnl0115Dto.getFamyResnRegnNum().substring(0, 6));    			/** column 생년월일 : yoobhMnthDay */
					
				}else {
					infcPsnl0115Vo.setYoobhMnthDay("20" + infcPsnl0115Dto.getFamyResnRegnNum().substring(0, 6));    			/** column 생년월일 : yoobhMnthDay */
				}
				
			}
			infcPsnl0115Vo.setFamyResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(infcPsnl0115Dto.getFamyResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));/** column 가족주민등록번호 : famyResnRegnNum */
//			infcPsnl0115Vo.setFamyResnRegnNum(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getFamyResnRegnNum())); 
			
			
			
			
			
			infcPsnl0115Vo.setFrgnrYn(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getFrgnrYn()));    				/** column 외국인여부 : frgnrYn */
			infcPsnl0115Vo.setDabtyDivCd(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getDabtyDivCd()));    		/** column 장애구분코드 : dabtyDivCd */
			infcPsnl0115Vo.setDabtyGrdeCd(MSFSharedUtils.allowNulls(infcPsnl0115Dto.getDabtyGrdeCd()));    		/** column 장애등급코드 : dabtyGrdeCd */
			
//			infcPsnl0115Vo.setFamySeilNum(infcPsnl0115Dto.getFamySeilNum());    /** column 가족일련번호 : famySeilNum */		
//			infcPsnl0115Vo.setYoobhMnthDay(psnl0115Dto.getYoobhMnthDay());    			/** column 생년월일 : yoobhMnthDay */
//			infcPsnl0115Vo.setSclcDivCd(psnl0115Dto.getSclcDivCd());    				/** column 음양구분코드 : sclcDivCd */
//			infcPsnl0115Vo.setAcadAbtyDivCd(psnl0115Dto.getAcadAbtyDivCd());   		 	/** column 학력구분코드 : acadAbtyDivCd */
//			infcPsnl0115Vo.setSchlNm(psnl0115Dto.getSchlNm());    						/** column 학교명 : schlNm */
//			infcPsnl0115Vo.setCrrCd(psnl0115Dto.getCrrCd());    						/** column 직업명 : crrCd */
//			infcPsnl0115Vo.setWkOfcNm(psnl0115Dto.getWkOfcNm());    					/** column 직장명 : wkOfcNm */
//			infcPsnl0115Vo.setInbyNm(psnl0115Dto.getInbyNm());    						/** column 직위명 : inbyNm */
//			infcPsnl0115Vo.setFamyPartNoteCtnt(psnl0115Dto.getFamyPartNoteCtnt());   	/** column 가족사항비고내용 : famyPartNoteCtnt */
//			infcPsnl0115Vo.setNatnCd(psnl0115Dto.getNatnCd());    						/** column 국가코드 : natnCd */
//			infcPsnl0115Vo.setFamyChbttYn(psnl0115Dto.getFamyChbttYn());    			/** column 가족동거여부 : famyChbttYn */
//			infcPsnl0115Vo.setFamyAllwYn(psnl0115Dto.getFamyAllwYn());    				/** column 가족수당여부 : famyAllwYn */
//			infcPsnl0115Vo.setSchlExpnAdmclYn(psnl0115Dto.getSchlExpnAdmclYn());    	/** column 학비보조여부 : schlExpnAdmclYn */
//			infcPsnl0115Vo.setYrtxYn(psnl0115Dto.getYrtxYn());    						/** column 연말정산여부 : yrtxYn */
			
			
			infcPsnl0115Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    			/** column 입력자 : kybdr */
//			infcPsnl0115Vo.setInptDt(psnl0115Dto.getInptDt());    /** column 입력일자 : inptDt */
			infcPsnl0115Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 입력주소 : inptAddr */
			infcPsnl0115Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    			/** column 수정자 : ismt */
//			infcPsnl0115Vo.setRevnDt(psnl0115Dto.getRevnDt());    /** column 수정일자 : revnDt */
			infcPsnl0115Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 수정주소 : revnAddr */
//			psnl0115Vo.setFamySecRegnNum(psnl0115Dto.getFamySecRegnNum());    /** column null : famySecRegnNum */
//			psnl0115Vo.setFamyOrgRegnNum(psnl0115Dto.getFamyOrgRegnNum());    /** column null : famyOrgRegnNum */
			
			
			psnl0115DAO.insertPsnl0115(infcPsnl0115Vo);
			
		}catch(Exception e){
			
			returnValue = new Long(0);
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"c",e, windowNm , windowId);
			
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		return returnValue;
		
	}

 
	

}
