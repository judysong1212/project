package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0127DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0127Service.java
 * @Description : Psnl0127 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0127Service.gwt")
public interface Psnl0127Service extends RemoteService{
	
	public static class Util {
		private static Psnl0127ServiceAsync instance;
		public static Psnl0127ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0127Service.class);
			}
			return instance;
		}
	}
	public BaseListLoadResult<Psnl0127DTO> selectPsnl0127(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;
	
	public String savePsnl0127(ArrayList<Psnl0127DTO> changePsnl0127List) throws Exception;
	
}
