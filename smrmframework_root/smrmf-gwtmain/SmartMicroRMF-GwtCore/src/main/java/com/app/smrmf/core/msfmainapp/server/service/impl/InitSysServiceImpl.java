/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.service.system.InitSysService;
import com.app.smrmf.props.ExtermsProps;

@Service("InitSysService")
public class InitSysServiceImpl  extends AbstractCustomServiceImpl implements InitSysService {
 
    private static final Logger logger = LoggerFactory.getLogger(InitSysServiceImpl.class);
   
 
    /**
     * 좌측의 트리 메뉴 셋팅을 위한 메뉴테이블의 데이터을 가지고 온다.
     */
    public String getInitialization(){
    	
    	String nResult = "";
    	
    	try {
    		
    		//설정변수 값 가져오기 
    		nResult = ExtermsProps.PropsInitialize();
    	
    	 } catch (Exception ex) {
            logger.error("EXCEPTION calling getMenu(): "+ex, ex);
         }
       
         return nResult;
    }	
     
}
