package com.app.exterms.personal.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.basis.client.dto.InfcComBass0500DTO;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100Service;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0100DAO;
import com.extjs.gxt.ui.client.data.BaseModel;

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
@Service("InfcPkgPsnl0100Service")
public class InfcPkgPsnl0100ServiceImpl    extends AbstractCustomServiceImpl  implements InfcPkgPsnl0100Service {
	
	 private static final Logger logger = LoggerFactory.getLogger(InfcPkgPsnl0100ServiceImpl.class);
	 private static final String calledClass = InfcPkgPsnl0100ServiceImpl.class.getName();
	    
	@Autowired
    @Resource(name="InfcPkgPsnl0100DAO")
    private InfcPkgPsnl0100DAO psnl0100DAO;
	 
 

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getBusinList(InfcComBass0500DTO sysComBass0500Dto) throws Exception {
		
		// TODO Auto-generated method stub
		
		String method = calledClass + ".getBusinList";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		sysComBass0500Dto.setDpobCd(sessionUser.getDpobCd());
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			
			egovResultDataList = psnl0100DAO.getBusinList(sysComBass0500Dto);
			
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
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnValue;
		
	}

 
	

}
