package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl010002DTO;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;



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
public interface PsnlP010002ServiceAsync{
	
	/** 근로자 신규 등록시 이미 등록된 근로자인지 체크 **/
	public void psnl0100Check( Psnl0100DTO psnl0100Dto, AsyncCallback<Long> callback)throws MSFException;	
	
	/** 저장 **/
	public void savePsnlAll(Psnl010002DTO psnl010002Dto, ActionDatabase actionDatabase, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback)throws MSFException;
	
	/** 근로자 정보 저장 후 데이터 조회하여 보여줌 **/
	public void getSystemkey(Psnl010002DTO psnl010002Dto, AsyncCallback<String> callback)throws MSFException;
	
}