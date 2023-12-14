package com.app.exterms.personal.client.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0111DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0111Service.java
 * @Description : Psnl0111 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0111Service.gwt")
public interface Psnl0111Service extends RemoteService{
	
	public static class Util {
		private static Psnl0111ServiceAsync instance;
		public static Psnl0111ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0111Service.class);
			}
			return instance;
		}
	}
	public List<HashMap<String, String>> selectPsnl0111(HashMap<String, String> param) throws Exception;
	
	public int savePsnl0111(Psnl0111DTO psnl0111Dto) throws Exception;
}
