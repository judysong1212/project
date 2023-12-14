package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0114DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0114Service.java
 * @Description : Psnl0114 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0114Service.gwt")
public interface Psnl0114Service extends RemoteService{
	
	public static class Util {
		private static Psnl0114ServiceAsync instance;
		public static Psnl0114ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0114Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0114DTO> selectPsnl0114(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0114(ArrayList<Psnl0114DTO> changePsnl0114List) throws Exception;
	
	
	/** 급여공제 코드 **/
	public List<BaseModel> getPayrDducCd() throws MSFException;
	
    
}
