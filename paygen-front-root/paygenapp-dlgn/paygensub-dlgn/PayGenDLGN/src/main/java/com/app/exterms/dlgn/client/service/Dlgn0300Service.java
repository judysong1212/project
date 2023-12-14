package com.app.exterms.dlgn.client.service;

import com.app.exterms.dlgn.client.dto.Dlgn0300DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Dlgn0300Service.gwt")
public interface Dlgn0300Service extends RemoteService {
	public static class Util{
		private static Dlgn0300ServiceAsync instance;
		public static Dlgn0300ServiceAsync getInstance(){
			if(instance == null){
				instance = GWT.create(Dlgn0300Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Dlgn0300DTO> selectDlgn0300(BaseListLoadConfig config, Dlgn0300DTO dto) throws Exception ;
	
	
}
