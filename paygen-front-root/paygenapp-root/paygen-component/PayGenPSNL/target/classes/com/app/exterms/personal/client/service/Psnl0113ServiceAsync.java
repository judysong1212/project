package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl0113DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0113Service.java
 * @Description : Psnl0113 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public interface Psnl0113ServiceAsync{
	
	void savePsnl0113(Psnl0113DTO dto, AsyncCallback<Integer> callback);
	
	/**
	 * PSNL0113을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0113VO
	 * @param callback the callback to return 등록 결과
	 * @exception Exception
	 */
    void insertPsnl0113(Psnl0113DTO dto, AsyncCallback<String> callback);
    
    /**
	 * PSNL0113을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0113VO
	 * @param callback the callback to return void형
	 * @exception Exception
	 */
    void updatePsnl0113(Psnl0113DTO dto, AsyncCallback<Integer> callback);
    
    /**
	 * PSNL0113을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0113VO
	 * @param callback the callback to return void형 
	 * @exception Exception
	 */
    void deletePsnl0113(Psnl0113DTO dto, AsyncCallback<Integer> callback);
    
    /**
	 * PSNL0113을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0113VO
	 * @param callback the callback to return 조회한 PSNL0113
	 * @exception Exception
	 */
    void selectPsnl0113(Psnl0113DTO dto, AsyncCallback<Psnl0113DTO> callback);
    
        
}
