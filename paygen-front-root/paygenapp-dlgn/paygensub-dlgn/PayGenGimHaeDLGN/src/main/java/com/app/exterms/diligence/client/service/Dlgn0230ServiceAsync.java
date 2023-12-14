package com.app.exterms.diligence.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface Dlgn0230ServiceAsync {
	
	/** 복무통합관리 근태 일괄생성 **/
	public void generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);	
	
	/** 복무통합관리 복무 삭제 **/
	public void deleteWorkTime(List<Dlgn0100DTO> list, AsyncCallback<Integer> callback);
	
	/** 복무통합관리 주휴일수만 수정 **/
	public void updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(Dlgn0110DTO dlgn01101dto, AsyncCallback<Long> callback);
	
	/** 복무통합관리 기본근무 수정 **/
	public void updateDlgn0110Grid(List<Dlgn0110DTO> listDlgn0110_1dto, AsyncCallback<Long> callback); 
	
	/** 복무통합관리 대상자 정보를 가져옴 **/
	public void getMemberInfo(Dlgn0100DTO dto, AsyncCallback<Dlgn0100DTO> callback);
	
	/** 복무통합관리 초과근무 수정**/
	public void updateDlgn0210Grid(List<Dlgn0210DTO> listDlgn0210_1dto, AsyncCallback<Long> callback) ; //기준일 후
}
