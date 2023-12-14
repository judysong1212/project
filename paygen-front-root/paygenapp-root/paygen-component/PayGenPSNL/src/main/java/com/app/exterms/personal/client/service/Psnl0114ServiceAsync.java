package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0114DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0114Service.java
 * @Description : Psnl0114 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0114ServiceAsync{
	
	public void selectPsnl0114(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0114DTO>> callback);

	public void savePsnl0114(ArrayList<Psnl0114DTO> changePsnl0114List, AsyncCallback<String> callback);
	
	/** 시스템 사업장 코드 **/
	public void getPayrDducCd(AsyncCallback<List<BaseModel>> callback);					
}
