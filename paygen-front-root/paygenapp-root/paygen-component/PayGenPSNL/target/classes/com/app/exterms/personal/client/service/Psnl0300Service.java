package com.app.exterms.personal.client.service;

import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0300DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0300Service.gwt")
public interface Psnl0300Service extends RemoteService {
	public static class Util{
		private static Psnl0300ServiceAsync instance;
		public static Psnl0300ServiceAsync getInstance(){
			if(instance == null){
				instance = GWT.create(Psnl0300Service.class);
			}
			return instance;
		}
		
	}
	
	public BaseListLoadResult<Psnl0300DTO> selectPsnl0300(BaseListLoadConfig config, Psnl0300DTO dto) throws Exception ;
	
	public BaseListLoadResult<Psnl0300DTO> selectPsnlP0300(BaseListLoadConfig config, Psnl0300DTO dto) throws Exception ;
	
	public int deletePsnl0300(List<Psnl0300DTO> list) throws Exception;
	
	public int deletePsnl0300List(List<BaseModel> listModels) throws Exception;
	
	public String appointmentSave(Psnl0300DTO dto) throws Exception;
	
	
	
	/** 일괄 발령 확정 **/
	public int appointmentSaveList(List<Psnl0300DTO> list) throws Exception;

	public String appointmentConfirmList(List<Psnl0300DTO>  dto) throws Exception;
}
