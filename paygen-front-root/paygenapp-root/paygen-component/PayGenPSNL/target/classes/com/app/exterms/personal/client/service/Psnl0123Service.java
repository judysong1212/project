package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0123DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0123Service.java
 * @Description : Psnl0123 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@RemoteServiceRelativePath("Psnl0123Service.gwt")
public interface Psnl0123Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0123ServiceAsync instance;
		public static Psnl0123ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0123Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0123DTO> selectPsnl0123(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0123(ArrayList<Psnl0123DTO> changePsnl0123List) throws Exception;
}
