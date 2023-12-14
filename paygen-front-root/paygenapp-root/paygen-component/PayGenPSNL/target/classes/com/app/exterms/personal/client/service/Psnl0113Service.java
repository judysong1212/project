package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl0113DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

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

@RemoteServiceRelativePath("Psnl0113Service.gwt")
public interface Psnl0113Service extends RemoteService{
	
	public static class Util {
		private static Psnl0113ServiceAsync instance;
		public static Psnl0113ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0113Service.class);
			}
			return instance;
		}
	}
	
	int savePsnl0113(Psnl0113DTO dto) throws Exception;
	
	/**
	 * PSNL0113을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0113VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPsnl0113(Psnl0113DTO dto) throws Exception;
    
    /**
	 * PSNL0113을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0113VO
	 * @return void형
	 * @exception Exception
	 */
    int updatePsnl0113(Psnl0113DTO dto) throws Exception;
    
    /**
	 * PSNL0113을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0113VO
	 * @return void형 
	 * @exception Exception
	 */
    int deletePsnl0113(Psnl0113DTO dto) throws Exception;
    
    /**
	 * PSNL0113을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0113VO
	 * @return 조회한 PSNL0113
	 * @exception Exception
	 */
    Psnl0113DTO selectPsnl0113(Psnl0113DTO dto) throws Exception;
    
        
}
