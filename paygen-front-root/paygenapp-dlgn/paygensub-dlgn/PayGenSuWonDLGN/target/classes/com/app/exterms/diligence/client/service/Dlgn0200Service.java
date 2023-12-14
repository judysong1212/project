package com.app.exterms.diligence.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Dlgn0200Service.gwt")
public interface Dlgn0200Service extends RemoteService {
	public static class Util{
		private static Dlgn0200ServiceAsync instance;
		public static Dlgn0200ServiceAsync getInstance(){
			if(instance == null){
				instance = GWT.create(Dlgn0200Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Dlgn0200DTO> searchWorkDayMemberInfo(BaseListLoadConfig config, Dlgn0200DTO dto) throws Exception ;
	
	public BaseListLoadResult<Dlgn0200DTO> getMemberWorkTimeInfo(BaseListLoadConfig config, Dlgn0200DTO dto) throws Exception ;
	
	public PagingLoadResult<ShowMessageBM>   generateWorkTime(Dlgn0200DTO dto) throws MSFException;
	
	public int saveWorkTime(List<Dlgn0200DTO> list) throws Exception;
	
	public int deleteWorkTime(List<Dlgn0200DTO> list) throws Exception;
	
	public Long updateDlgn0210Grid(List<Dlgn0210DTO> dto) throws MSFException; 
	
	public Long updateDlgn0210GridPre(List<Dlgn0210DTO> dto) throws MSFException; 

}
