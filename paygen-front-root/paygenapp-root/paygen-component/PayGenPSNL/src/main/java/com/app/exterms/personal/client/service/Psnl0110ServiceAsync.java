package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.dto.Psnl0110_02DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0110Service.java
 * @Description : Psnl0110 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2015.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0110ServiceAsync{
	//20210520_양평 근무시간 조회시 적용
	public void selectPsnl0110(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0110DTO>> callback);
	

	public void savePsnl0110(ArrayList<Psnl0110DTO> changePsnl0110List, AsyncCallback<String> callback);
	
	/** 인사(무기) 기간제고용 저장/수정/삭제 **/
	public void savePsnl0100ToPsnl0110(List<Psnl0110_02DTO> listPsnl0110Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	
}
