package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl010002DTO;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0134Service.java
 * @Description : Psnl0134 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("psnlP010002Service.gwt")
public interface PsnlP010002Service extends RemoteService{
	
	
	public static class Util {
		private static PsnlP010002ServiceAsync instance;
		public static PsnlP010002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PsnlP010002Service.class);
			}
			return instance;
		}
	}
	
	/** 근로자 신규 등록시 이미 등록된 근로자인지 체크 **/
	public Long psnl0100Check(Psnl0100DTO psnl0100Dto) throws MSFException;
	
	/** 저장 **/
	public PagingLoadResult<ShowMessageBM> savePsnlAll(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase) throws MSFException;
	
	
	/** 근로자 정보 저장 후 해당 근로자 시스템키 가져옴. **/
	public String getSystemkey(Psnl010002DTO psnl010002Dto) throws MSFException;
	
	 
	
	
}