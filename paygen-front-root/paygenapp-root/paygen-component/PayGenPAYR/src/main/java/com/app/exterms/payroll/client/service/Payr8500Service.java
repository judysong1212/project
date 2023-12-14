package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.retirement.client.dto.InfcPkgRemt2000DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2100DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2200DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemtDays0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Payr8500Service.java
 * @Description : Payr8500 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Payr8500Service.gwt")
public interface Payr8500Service extends RemoteService {
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr8500ServiceAsync instance;
		public static Payr8500ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr8500Service.class);
			}
			return instance;
		}
	}	
	
	/** 산정결과 **/
	public InfcPkgRemt2000DTO activityOnReadPayr8500ToRemt0100(InfcPkgRemt2000DTO remt2000Dto) throws MSFException ;
	
	/** 급여내역 퇴직금 재산정 **/
	public Long activityOnUpdatePayr8500ToRemt0100ToPayrCalc(List<InfcPkgRemt2200DTO> listRemt2200dto) throws MSFException ;
	
	/** 후생복지비 퇴직금 재산정 **/
	public Long activityOnUpdatePayr8500ToRemt0100ToPayrWfepCalc(List<InfcPkgRemt2200DTO> listRemt2200dto) throws MSFException;
	
	/** 급여지급기간 셋팅 **/
	public List<InfcPkgRemtDays0100DTO> activityOnPayr8500ToRemt0100Header(InfcPkgRemt2100DTO remt2100Dto) throws MSFException;
	
	
	public PagingLoadResult<ShowMessageBM> activityOnInsertPayr8500ToRemt0100(List<BaseModel> mapModels,InfcPkgRemt2000DTO remt2000Dto) throws MSFException ;
	
	
	
	
	 
//	/**
//	 * PAYR8500을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr8500VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertPayr8500(Payr8500VO vo) throws Exception;
//    
//    /**
//	 * PAYR8500을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr8500VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updatePayr8500(Payr8500VO vo) throws Exception;
//    
//    /**
//	 * PAYR8500을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr8500VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deletePayr8500(Payr8500VO vo) throws Exception;
//    
//    /**
//	 * PAYR8500을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr8500VO
//	 * @return 조회한 PAYR8500
//	 * @exception Exception
//	 */
//    Payr8500VO selectPayr8500(Payr8500VO vo) throws Exception;
//    
//    /**
//	 * PAYR8500 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR8500 목록
//	 * @exception Exception
//	 */
//    List selectPayr8500List(Payr8500DefaultVO searchVO) throws Exception;
//    
//    /**
//	 * PAYR8500 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR8500 총 갯수
//	 * @exception
//	 */
//    int selectPayr8500ListTotCnt(Payr8500DefaultVO searchVO);
    
}
