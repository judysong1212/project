package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0119Service.java
 * @Description : Psnl0119 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0119ServiceAsync{
	
	
	public void selectPsnl0119(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0119DTO>> callback);

	public void savePsnl0119(ArrayList<Psnl0119DTO> changePsnl0119List, AsyncCallback<String> callback);
}
