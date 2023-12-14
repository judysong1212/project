package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0133DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * @Class Name : Psnl0133Service.java
 * @Description : Psnl0133 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0133ServiceAsync{
	
	
	/** 근무상황 조회 **/
	public void selectPsnl0133(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0133DTO>> callback);
	
	/** 근무상황 저장 **/
	public void savePsnl0133(ArrayList<Psnl0133DTO> changePsnl0133List, AsyncCallback<String> callback);
}