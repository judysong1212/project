package com.app.exterms.personal.client.service;

import com.app.exterms.basis.client.dto.InfcPkgBass0360DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0112Service.java
 * @Description : Psnl0112 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("ComPsnlP010001Service.gwt")
public interface ComP010001Service extends RemoteService {
	
	public static class Util {
		private static ComP010001ServiceAsync instance;
		public static ComP010001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(ComP010001Service.class);
			}
			return instance;
		}
	}
	
	/**  단위기관 맵핑 조회  **/
	public int selectBass0360List(InfcPkgBass0360DTO infcBass0360Dto)throws MSFException;
	
	public String insertBass0360List(InfcPkgBass0360DTO infcBass0360Dto)throws MSFException;
	
	
   
}
