package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0122DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0122Service.java
 * @Description : Psnl0122 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0122Service.gwt")
public interface Psnl0122Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0122ServiceAsync instance;
		public static Psnl0122ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0122Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0122DTO> selectPsnl0122(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0122(ArrayList<Psnl0122DTO> changePsnl0122List) throws Exception;
}