package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0121DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0121Service.java
 * @Description : Psnl0121 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0121Service.gwt")
public interface Psnl0121Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0121ServiceAsync instance;
		public static Psnl0121ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0121Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0121DTO> selectPsnl0121(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0121(ArrayList<Psnl0121DTO> changePsnl0121List) throws Exception;
}
