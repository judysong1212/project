package com.app.exterms.payroll.client.service;

import com.app.exterms.payroll.client.dto.Hpe100BM;
import com.app.exterms.payroll.client.dto.Hpe100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr7100Service.gwt")
public interface Payr7100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr7100ServiceAsync instance;
		public static Payr7100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr7100Service.class);
			}
			return instance;
		}
	}
	

	/** 전자신고기본정보 조회 **/
	public Hpe100BM getPayr7100List(Hpe100DTO hpe100Dto) throws MSFException;

	/** 전자신고기본정보 조회 **/
	public Hpe100BM setPayr7100SummaryData(Hpe100DTO hpe100Dto) throws MSFException;
	
	
	//추가_20200925
	public Long setPayr7100DataSave(Hpe100DTO hpe100Dto) throws MSFException;
	
	/** 전자신고기본정보 수정 **/
	//public Long updateYe161005(Ye161005DTO ye161005Dto) throws MSFException;
	
	//**----------2022.01.19 PDS(전자신고기본정보)조회 추가작업 (START)---------**//	
	public Hpe100BM getPayr7100Hpe000T(Hpe100DTO hpe100Dto) throws MSFException;

}