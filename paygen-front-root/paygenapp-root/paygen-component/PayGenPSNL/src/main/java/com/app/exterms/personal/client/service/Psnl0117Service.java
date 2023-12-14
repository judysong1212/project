package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0117DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0117Service.java
 * @Description : Psnl0117 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.0527
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0117Service.gwt")
public interface Psnl0117Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0117ServiceAsync instance;
		public static Psnl0117ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0117Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0117DTO> selectPsnl0117(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0117(ArrayList<Psnl0117DTO> changePsnl0117List) throws Exception;
}
