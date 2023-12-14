package com.app.exterms.personal.client.service;

import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0134DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
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
public interface Psnl0134ServiceAsync{
	
	
	/** 시찰(수행) 조회 **/
	public void selectPsnl0134(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0134DTO>> callback);
	public void selectPsnl0134Data(  Psnl0134DTO psnl0134Dto, AsyncCallback<Psnl0134DTO> callback);
	
	/** 시찰(수행) 저장 **/
	public void savePsnl0134(Psnl0134DTO psnl0134Dto, ActionDatabase actionDatabase, AsyncCallback <Long> callback);
}