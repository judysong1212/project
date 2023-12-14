package com.app.exterms.personal.client.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0111DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0111Service.java
 * @Description : Psnl0111 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0111ServiceAsync{
	
	public void selectPsnl0111(HashMap<String, String> param, AsyncCallback<List<HashMap<String, String>>> callback);
	
	public void savePsnl0111(Psnl0111DTO psnl0111Dto, AsyncCallback<Integer> callback);
}
