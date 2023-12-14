package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0117DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0117Service.java
 * @Description : Psnl0117 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.0527
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0117ServiceAsync{
	
	
	public void selectPsnl0117(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0117DTO>> callback);

	public void savePsnl0117(ArrayList<Psnl0117DTO> changePsnl0117List, AsyncCallback<String> callback);
}
