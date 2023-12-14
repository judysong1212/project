package com.app.exterms.payroll.client.service;

import com.app.exterms.payroll.client.dto.Hpe100BM;
import com.app.exterms.payroll.client.dto.Hpe100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr7100ServiceAsync {

	/** 전자신고기본정보 조회 **/
	public void getPayr7100List(Hpe100DTO hpe100Dto, AsyncCallback<Hpe100BM> callback);

	/** 전자신고기본정보 조회 **/
	public void setPayr7100SummaryData(Hpe100DTO hpe100Dto, AsyncCallback<Hpe100BM> callback);
	
	//추가_20200925
	public void setPayr7100DataSave(Hpe100DTO hpe100Dto, AsyncCallback<Long> callback);
	
	/** 전자신고기본정보 수정 **/
	//public void updateYe161005(Ye161005DTO ye161005Dto, AsyncCallback<Long> callback);
	

	//**----------2022.01.19 PDS(전자신고기본정보)조회 추가작업 (START)---------**//	
	public void getPayr7100Hpe000T(Hpe100DTO hpe100Dto, AsyncCallback<Hpe100BM> callback);

	
	
}