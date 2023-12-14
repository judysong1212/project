package com.app.exterms.personal.client.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.dto.Psnl0110_02DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

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
@RemoteServiceRelativePath("Psnl0110Service.gwt")
public interface Psnl0110Service extends RemoteService{
	
	public static class Util {
		private static Psnl0110ServiceAsync instance;
		public static Psnl0110ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0110Service.class);
			}
			return instance;
		}
	}
	//20210520_양평 근무시간 조회시 적용
	public BaseListLoadResult<Psnl0110DTO> selectPsnl0110(BaseListLoadConfig config, HashMap<String, String> params) throws Exception;
	

	public String savePsnl0110(ArrayList<Psnl0110DTO> changePsnl0110List) throws Exception;
	
	
	/** 인사(무기) 기간제고용 저장/수정/삭제 **/
	public Long savePsnl0100ToPsnl0110(List<Psnl0110_02DTO> listPsnl0110Dto, ActionDatabase actionDatabase) throws MSFException;
	
	
}
