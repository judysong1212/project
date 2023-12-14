package com.app.exterms.personal.server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0127DTO;
import com.app.exterms.personal.client.service.Psnl0127Service;
import com.app.exterms.personal.server.service.dao.Psnl0127DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0127ServiceImpl.java
 * @Description : Psnl0127 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("psnl0127Service")
public class Psnl0127ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0127Service {

    @Resource(name="psnl0127DAO")
    private Psnl0127DAO psnl0127DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0127ServiceImpl.class);
    private static final String calledClass = Psnl0127ServiceImpl.class.getName();
   
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0127DTO> selectPsnl0127(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws MSFException {
		// TODO Auto-generated method stub
		List<Psnl0127DTO> returnValue = new ArrayList<Psnl0127DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".selectPsnl0127";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {
			
			egovResultDataList = psnl0127DAO.selectPsnl0127(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0127DTO dto = new Psnl0127DTO();
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
					//건강보험CheckBox
					if("Y".equals(dto.getHlthInsrApptnYn())) {
						dto.setHlthInsrApptnChk(true);
					}else {
						dto.setHlthInsrApptnChk(false);
					}
					
					//국민연금CheckBox
					if("Y".equals(dto.getNatPennApptnYn())){
						dto.setNatPennApptnChk(true);
					}else {
						dto.setNatPennApptnChk(false);
					}
					
					//고용보혐CheckBox
					if("Y".equals(dto.getUmytInsrApptnYn())){
						dto.setUmytInsrApptnChk(true);
					}else {
						dto.setUmytInsrApptnChk(false);
					}
					
					//산재보험CheckBox
					if("Y".equals(dto.getIdtlAccdtInsurApptnYn())){
						dto.setIdtlAccdtInsurApptnChk(true);
					}else {
						dto.setIdtlAccdtInsurApptnChk(false);
					}
					
					//사회보험료 null일 경우 0으로 처리..
					dto.setHlthInsrPayTotAmnt(MSFSharedUtils.defaultNulls(dto.getHlthInsrPayTotAmnt(), "0"));//건강보험보수총액
					dto.setHlthInsrMnthRuntnAmnt(MSFSharedUtils.defaultNulls(dto.getHlthInsrMnthRuntnAmnt(), "0"));//건강보험보수월액
					dto.setNatPennStdIncmMnthAmnt(MSFSharedUtils.defaultNulls(dto.getNatPennStdIncmMnthAmnt(), "0"));//국민연금기준소득월액
					dto.setUmytInsrPayMnthAmnt(MSFSharedUtils.defaultNulls(dto.getUmytInsrPayMnthAmnt(), "0"));//고용보험보수월액
					dto.setIdtlAccdtPayMnthAmnt(MSFSharedUtils.defaultNulls(dto.getIdtlAccdtPayMnthAmnt(), "0"));//산재보험보수월액
					
					//삭제 여부가 필요한 그리드 데이터일 경우 delChk를 false값을 필수로 넘겨준다.
					dto.setDelChk(false);
					returnValue.add(dto);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		
		return new BaseListLoadResult<Psnl0127DTO>(returnValue);
	}
	

	@Override
	public String savePsnl0127(ArrayList<Psnl0127DTO> changePsnl0127List)
			throws MSFException {
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".savePsnl0127";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			if(changePsnl0127List!=null && changePsnl0127List.size() > 0){
				for ( int i = 0; i < changePsnl0127List.size(); i++){
					if(changePsnl0127List.get(i).getDelChk()){
						psnl0127DAO.deletePsnl0127(changePsnl0127List.get(i));
						delCnt++;
					}else{
//						MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0127List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0127List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						if(changePsnl0127List.get(i).getDpobCd() != null 	&& changePsnl0127List.get(i).getSystemkey() !=null){
							psnl0127DAO.updatePsnl0127(changePsnl0127List.get(i));
						}else{
							psnl0127DAO.insertPsnl0127(changePsnl0127List.get(i));
						}
						saveCnt++;
					}
				}
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
	
	
    
}
