package com.app.exterms.diligence.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dlgn0230Service.gwt")
public interface Dlgn0230Service extends RemoteService {
	public static class Util{
		private static Dlgn0230ServiceAsync instance;
		public static Dlgn0230ServiceAsync getInstance(){
			if(instance == null){
				instance = GWT.create(Dlgn0230Service.class);
			}
			return instance;
		}
	}
	
	
	/** 복무통합관리 근태 일괄생성 **/
	public PagingLoadResult<ShowMessageBM> generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto) throws MSFException;
	
	/** 복무통합관리 복무 삭제 **/
	public int deleteWorkTime(List<Dlgn0100DTO> list) throws MSFException;
	
	/** 복무통합관리 주휴일수만 수정 **/
	public Long updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(Dlgn0110DTO dto) throws MSFException;
	
	/** 복무통합관리 기본근무 수정 **/
	public Long updateDlgn0110Grid(List<Dlgn0110DTO> dto) throws MSFException; 
	
	/** 복무통합관리 대상자 정보를 가져옴 **/
	public Dlgn0100DTO getMemberInfo(Dlgn0100DTO dto) throws MSFException;
	
	/** 복무통합관리 초과근무 수정**/
	public Long updateDlgn0210Grid(List<Dlgn0210DTO> dto) throws MSFException; 
	
}
