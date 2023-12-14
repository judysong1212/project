package com.app.exterms.personal.client.service;

import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0300DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Psnl0300ServiceAsync {
	public void selectPsnl0300(BaseListLoadConfig config, Psnl0300DTO dto, AsyncCallback<BaseListLoadResult<Psnl0300DTO>> callback) ;
	
	public void selectPsnlP0300(BaseListLoadConfig config, Psnl0300DTO dto, AsyncCallback<BaseListLoadResult<Psnl0300DTO>> callback) ;
	
	public void deletePsnl0300(List<Psnl0300DTO> list, AsyncCallback<Integer> callback);
	
	public void deletePsnl0300List(List<BaseModel> listModels, AsyncCallback<Integer> callback);
	
	public void appointmentSave(Psnl0300DTO dto, AsyncCallback<String> callback);
	
	
	/** 일괄 발령 확정 **/
	public void appointmentSaveList(List<Psnl0300DTO> list, AsyncCallback<Integer> callback);

	public void appointmentConfirmList(List<Psnl0300DTO>  dto, AsyncCallback<String> callback);
}
