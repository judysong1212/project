package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0120DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0120Service.java
 * @Description : Psnl0120 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0120Service.gwt")
public interface Psnl0120Service extends RemoteService{
	
	
	public static class Util {
		private static Psnl0120ServiceAsync instance;
		public static Psnl0120ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0120Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0120DTO> selectPsnl0120(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;

	public String savePsnl0120(ArrayList<Psnl0120DTO> changePsnl0120List) throws Exception;
	/**
	 * 교육사항 일괄등록
	 * @param insertPsnl0120List
	 * @return
	 * @throws Exception
	 */
	public String insert0120List(ArrayList<Psnl0120DTO> insertPsnl0120List) throws Exception;
	
}
