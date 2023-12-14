package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0118DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0118Service.java
 * @Description : Psnl0118 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@RemoteServiceRelativePath("Psnl0118Service.gwt")
public interface Psnl0118Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0118ServiceAsync instance;
		public static Psnl0118ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0118Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0118DTO> selectPsnl0118(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0118(ArrayList<Psnl0118DTO> changePsnl0118List) throws Exception;
}

