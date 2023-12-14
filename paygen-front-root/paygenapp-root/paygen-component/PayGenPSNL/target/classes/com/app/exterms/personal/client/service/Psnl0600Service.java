package com.app.exterms.personal.client.service;

import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl0600DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0600Service.gwt")
public interface Psnl0600Service extends RemoteService {

	public static class Util{
		private static Psnl0600ServiceAsync instance;
		public static Psnl0600ServiceAsync getInstance(){
			if(instance == null){
				instance = GWT.create(Psnl0600Service.class);
			}
			return instance;
		}
		
	}
	
	//기본
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0600(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//병역
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0112(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//단체
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0114(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//학력
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0116(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//경력
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0119(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//자격
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0118(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//교육
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0120(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//포상
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0121(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//징계
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0122(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
	//휴직
	public BaseListLoadResult<Psnl0600DTO> selectPsnl0123(BaseListLoadConfig config, HashMap<String, String> params ) throws Exception;
}
