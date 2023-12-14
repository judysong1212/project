package com.app.exterms.personal.server.service;

import java.util.Iterator;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0112DTO;
import com.app.exterms.personal.client.service.Psnl0112Service;
import com.app.exterms.personal.server.service.dao.Psnl0112DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0112ServiceImpl.java
 * @Description : Psnl0112 Business Implement class
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
@Service("psnl0112Service")
public class Psnl0112ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0112Service {

    @Resource(name="psnl0112DAO")
    private Psnl0112DAO psnl0112DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPsnl0112IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	@Override
	public int insertPsnl0112(Psnl0112DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return psnl0112DAO.insertPsnl0112(dto);
	}

	@Override
	public int updatePsnl0112(Psnl0112DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return psnl0112DAO.updatePsnl0112(dto);
	}

	@Override
	public int deletePsnl0112(Psnl0112DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return psnl0112DAO.deletePsnl0112(dto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Psnl0112DTO selectPsnl0112(Psnl0112DTO dto) throws Exception {
		// TODO Auto-generated method stub
		Psnl0112DTO returnVal = new Psnl0112DTO();
		
		EgovMap map = psnl0112DAO.selectPsnl0112(dto); 
		if(map != null && map.size() > 0){
			Iterator<String> keys = map.keySet().iterator();
			while( keys.hasNext() ){
	            String key = keys.next();
	            //형 타입이 숫자형일경우 형변환 해준다.
            	if(map.get(key) instanceof java.math.BigDecimal){
            		returnVal.set(key, String.valueOf(map.get(key)));
            	}else{
            		returnVal.set(key, map.get(key));
            	}
            }
		}
		
		return returnVal;
	}

	@Override
	public int savePsnl0112(Psnl0112DTO dto) throws Exception {
		// TODO Auto-generated method stub
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		return psnl0112DAO.savePsnl0112(dto);
	}
    
}
