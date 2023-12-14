package com.app.exterms.diligence.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Dlgn0200ServiceAsync {
	public void searchWorkDayMemberInfo(BaseListLoadConfig config, Dlgn0200DTO dto, AsyncCallback<BaseListLoadResult<Dlgn0200DTO>> callback) ;
	
	public void getMemberWorkTimeInfo(BaseListLoadConfig config, Dlgn0200DTO dto, AsyncCallback<BaseListLoadResult<Dlgn0200DTO>> callback) ;
	
	public void generateWorkTime(Dlgn0200DTO dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	public void saveWorkTime(List<Dlgn0200DTO> list, AsyncCallback<Integer> callback);
	
	public void deleteWorkTime(List<Dlgn0200DTO> list, AsyncCallback<Integer> callback);
	
	public void updateDlgn0210Grid(List<Dlgn0210DTO> listDlgn0210_1dto, AsyncCallback<Long> callback) ; //2017.04.06 : kim ji eun
	
}
