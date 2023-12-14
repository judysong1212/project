package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0127DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0127Service.java
 * @Description : Psnl0127 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0127ServiceAsync{
	
	public void selectPsnl0127(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0127DTO>> callback);
	public void savePsnl0127(ArrayList<Psnl0127DTO> changePsnl0127List, AsyncCallback<String> callback);
	
}
