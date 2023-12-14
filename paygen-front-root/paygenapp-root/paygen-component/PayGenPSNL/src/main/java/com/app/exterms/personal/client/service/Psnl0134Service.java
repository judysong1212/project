package com.app.exterms.personal.client.service;

import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0134DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0134Service.java
 * @Description : Psnl0134 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("psnl0134Service.gwt")
public interface Psnl0134Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0134ServiceAsync instance;
		public static Psnl0134ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0134Service.class);
			}
			return instance;
		}
	}
	
	/** 시찰(수행) 조회 **/
	public BaseListLoadResult<Psnl0134DTO> selectPsnl0134(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;
	public Psnl0134DTO selectPsnl0134Data( Psnl0134DTO psnl0134Dto);
	
	
	/** 시찰(수행) 저장 **/
	public Long savePsnl0134(Psnl0134DTO psnl0134Dto, ActionDatabase actionDatabase) throws Exception;
	
	

	
	
}