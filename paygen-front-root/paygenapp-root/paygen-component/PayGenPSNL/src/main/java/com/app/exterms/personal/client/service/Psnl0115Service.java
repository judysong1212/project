package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0115DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0115Service.java
 * @Description : Psnl0115 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0115Service.gwt")
public interface Psnl0115Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0115ServiceAsync instance;
		public static Psnl0115ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0115Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0115DTO> selectPsnl0115(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0115(ArrayList<Psnl0115DTO> changePsnl0115List) throws Exception;
}
