package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0116DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0116Service.java
 * @Description : Psnl0116 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0116ServiceAsync{
	
	
	public void selectPsnl0116(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0116DTO>> callback);

	public void savePsnl0116(ArrayList<Psnl0116DTO> changePsnl0116List, AsyncCallback<String> callback);
}
