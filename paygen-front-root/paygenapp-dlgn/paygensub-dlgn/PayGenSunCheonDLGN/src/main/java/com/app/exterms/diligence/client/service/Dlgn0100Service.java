package com.app.exterms.diligence.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Dlgn0100Service.gwt")
public interface Dlgn0100Service extends RemoteService {
	public static class Util{
		private static Dlgn0100ServiceAsync instance;
		public static Dlgn0100ServiceAsync getInstance(){
			if(instance == null){
				instance = GWT.create(Dlgn0100Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Dlgn0100DTO> searchWorkDayMemberInfo(BaseListLoadConfig config, Dlgn0100DTO dto) throws Exception ;
	
	public BaseListLoadResult<Dlgn0100DTO> getMemberWorkTimeInfo(BaseListLoadConfig config, Dlgn0100DTO dto) throws Exception ;
	
	public PagingLoadResult<ShowMessageBM>  generateWorkTime(Dlgn0100DTO dto) throws MSFException;
	
	public int saveWorkTime(List<Dlgn0100DTO> list) throws Exception;
	
	public int deleteWorkTime(List<Dlgn0100DTO> list) throws Exception;
	
	public List<BaseModel> getPayrMangDeptCd(Dlgn0100DTO dto) throws Exception;
	
	public Long updateDlgn0110Grid(List<Dlgn0110DTO> dto) throws MSFException; 
	
	public Long updateDlgn0110GridPre(List<Dlgn0110DTO> dto) throws MSFException; 
	
	/** 근태관리 대상자 정보를 가져옴 **/
	public Dlgn0100DTO getMemberInfo(Dlgn0100DTO dto) throws Exception;
	
	/** 주휴일수만 수정 **/
	public Long updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(Dlgn0110DTO dto) throws MSFException; 
}
