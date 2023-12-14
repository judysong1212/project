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

import com.app.exterms.personal.client.dto.Psnl0117DTO;
import com.app.exterms.personal.client.service.Psnl0117Service;
import com.app.exterms.personal.server.service.dao.Psnl0117DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0117ServiceImpl.java
 * @Description : Psnl0117 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.0527
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@SuppressWarnings("serial")
@Service("psnl0117Service")
public class Psnl0117ServiceImpl extends AbstractCustomServiceImpl implements Psnl0117Service {

    @Resource(name="psnl0117DAO")
    private Psnl0117DAO psnl0117DAO;
    private static final Logger logger = LoggerFactory.getLogger(Psnl0117ServiceImpl.class);
    private static final String calledClass = Psnl0117ServiceImpl.class.getName();
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0117DTO> selectPsnl0117(BaseListLoadConfig config, HashMap<String, String> params)throws Exception {
    	
    	// TODO Auto-generated method stub
    	
    	String method = calledClass + ".savePsnl0114";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
    	List<Psnl0117DTO> returnValue = new ArrayList<Psnl0117DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			egovResultDataList = psnl0117DAO.selectPsnl0117(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0117DTO dto = new Psnl0117DTO();
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
		
		return new BaseListLoadResult<Psnl0117DTO>(returnValue);
	}

	@Override
	public String savePsnl0117(ArrayList<Psnl0117DTO> changePsnl0117List)
			throws Exception {
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".savePsnl0117";
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		try{
			if(changePsnl0117List!=null && changePsnl0117List.size() > 0){
				for ( int i = 0; i < changePsnl0117List.size(); i++){
					if(changePsnl0117List.get(i).getDelChk()){
						psnl0117DAO.deletePsnl0117(changePsnl0117List.get(i));
						delCnt++;
					}else{
//						MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0117List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0117List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0117List.get(i).getOrcrdSeilNum() != null){
							psnl0117DAO.updatePsnl0117(changePsnl0117List.get(i));
						}else{
							psnl0117DAO.insertPsnl0117(changePsnl0117List.get(i));
						}
						saveCnt++;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U:D:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U:D:C");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
    
}
