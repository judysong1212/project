package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0116DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0116Service.java
 * @Description : Psnl0116 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0116Service.gwt")
public interface Psnl0116Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0116ServiceAsync instance;
		public static Psnl0116ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0116Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0116DTO> selectPsnl0116(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0116(ArrayList<Psnl0116DTO> changePsnl0116List) throws Exception;
}
