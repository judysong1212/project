package com.app.exterms.diligence.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Dlgn0100ServiceAsync {
	public void searchWorkDayMemberInfo(BaseListLoadConfig config, Dlgn0100DTO dto, AsyncCallback<BaseListLoadResult<Dlgn0100DTO>> callback) ;
	
	public void getMemberWorkTimeInfo(BaseListLoadConfig config, Dlgn0100DTO dto, AsyncCallback<BaseListLoadResult<Dlgn0100DTO>> callback) ;
	
	public void generateWorkTime(Dlgn0100DTO dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	public void saveWorkTime(List<Dlgn0100DTO> list, AsyncCallback<Integer> callback);
	
	public void deleteWorkTime(List<Dlgn0100DTO> list, AsyncCallback<Integer> callback);
	
	public void getPayrMangDeptCd(Dlgn0100DTO dto, AsyncCallback<List<BaseModel>> callback);
	
	public void updateDlgn0110Grid(List<Dlgn0110DTO> listDlgn0110_1dto, AsyncCallback<Long> callback) ; //기본근무관리 저장 (기준일 후)
	
	public void updateDlgn0110GridPre(List<Dlgn0110DTO> listDlgn0110_1dto, AsyncCallback<Long> callback) ; //기본근무관리 저장 (기준일 전)
	
	/** 근태관리 대상자 정보를 가져옴 **/
	public void getMemberInfo(Dlgn0100DTO dto, AsyncCallback<Dlgn0100DTO> callback);
	
	public void updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(Dlgn0110DTO dlgn01101dto, AsyncCallback<Long> callback) ; //주휴일수 저장
	

}
