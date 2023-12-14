package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl0112DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

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
@RemoteServiceRelativePath("Psnl0112Service.gwt")
public interface Psnl0112Service extends RemoteService {
	
	public static class Util {
		private static Psnl0112ServiceAsync instance;
		public static Psnl0112ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0112Service.class);
			}
			return instance;
		}
	}
	
	int savePsnl0112(Psnl0112DTO dto) throws Exception;
	
	/**
	 * PSNL0112을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0112VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    int insertPsnl0112(Psnl0112DTO dto) throws Exception;
    
    /**
	 * PSNL0112을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0112VO
	 * @return void형
	 * @exception Exception
	 */
    int updatePsnl0112(Psnl0112DTO dto) throws Exception;
    
    /**
	 * PSNL0112을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0112VO
	 * @return void형 
	 * @exception Exception
	 */
    int deletePsnl0112(Psnl0112DTO dto) throws Exception;
    
    /**
	 * PSNL0112을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0112VO
	 * @return 조회한 PSNL0112
	 * @exception Exception
	 */
    Psnl0112DTO selectPsnl0112(Psnl0112DTO dto) throws Exception;
    
   
}
