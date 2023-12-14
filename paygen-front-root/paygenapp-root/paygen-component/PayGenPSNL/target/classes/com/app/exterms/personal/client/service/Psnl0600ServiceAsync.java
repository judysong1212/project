package com.app.exterms.personal.client.service;

import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0600DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Psnl0600ServiceAsync {

	//기본
	public void selectPsnl0600(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//병역
	public void selectPsnl0112(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//단체
	public void selectPsnl0114(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//학력
	public void selectPsnl0116(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//경력
	public void selectPsnl0119(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//자격
	public void selectPsnl0118(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//교육
	public void selectPsnl0120(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//포상
	public void selectPsnl0121(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//징계
	public void selectPsnl0122(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
	//휴직
	public void selectPsnl0123(BaseListLoadConfig config, HashMap<String, String> params, AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback );
}
