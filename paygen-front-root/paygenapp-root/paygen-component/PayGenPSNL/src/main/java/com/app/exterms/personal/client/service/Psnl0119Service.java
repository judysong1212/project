package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0119Service.java
 * @Description : Psnl0119 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0119Service.gwt")
public interface Psnl0119Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0119ServiceAsync instance;
		public static Psnl0119ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0119Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0119DTO> selectPsnl0119(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0119(ArrayList<Psnl0119DTO> changePsnl0119List) throws Exception;
}
