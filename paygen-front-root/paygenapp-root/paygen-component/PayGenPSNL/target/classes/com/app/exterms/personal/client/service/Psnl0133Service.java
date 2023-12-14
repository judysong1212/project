package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0133DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0133Service.java
 * @Description : Psnl0133 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("psnl0133Service.gwt")
public interface Psnl0133Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0133ServiceAsync instance;
		public static Psnl0133ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0133Service.class);
			}
			return instance;
		}
	}
	
	/** 근무상황 조회 **/
	public BaseListLoadResult<Psnl0133DTO> selectPsnl0133(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;
	
	/** 근무상황 저장 **/
	public String savePsnl0133(ArrayList<Psnl0133DTO> changePsnl0133List) throws Exception;
	
	
}