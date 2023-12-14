package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0120DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0120Service.java
 * @Description : Psnl0120 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0120ServiceAsync{
	
	
	public void selectPsnl0120(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0120DTO>> callback);

	public void savePsnl0120(ArrayList<Psnl0120DTO> changePsnl0120List, AsyncCallback<String> callback);
	/**
	 * 교육사항 일괄등록
	 * @param insertPsnl0120List
	 * @throws Exception
	 */
	public void insert0120List(ArrayList<Psnl0120DTO> insertPsnl0120List, AsyncCallback<String> callback);
	
}
