package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl0112DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0112Service.java
 * @Description : Psnl0112 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Psnl0112ServiceAsync {
	
	void savePsnl0112(Psnl0112DTO dto, AsyncCallback<Integer> callback);
	
	/**
	 * PSNL0112을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0112VO
	 * @param callback the callback to return 등록 결과
	 * @exception Exception
	 */
    void insertPsnl0112(Psnl0112DTO dto, AsyncCallback<Integer> callback);
    
    /**
	 * PSNL0112을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0112VO
	 * @param callback the callback to return void형
	 * @exception Exception
	 */
    void updatePsnl0112(Psnl0112DTO dto, AsyncCallback<Integer> callback);
    
    /**
	 * PSNL0112을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0112VO
	 * @param callback the callback to return void형 
	 * @exception Exception
	 */
    void deletePsnl0112(Psnl0112DTO dto, AsyncCallback<Integer> callback);
    
    /**
	 * PSNL0112을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0112VO
	 * @param callback the callback to return 조회한 PSNL0112
	 * @exception Exception
	 */
    void selectPsnl0112(Psnl0112DTO dto, AsyncCallback<Psnl0112DTO> callback);
    
   
}
