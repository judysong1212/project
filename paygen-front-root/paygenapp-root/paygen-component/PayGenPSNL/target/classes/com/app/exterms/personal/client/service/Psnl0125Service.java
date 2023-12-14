package com.app.exterms.personal.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Psnl0125Service.java
 * @Description : Psnl0125 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Psnl0125Service.gwt")
public interface Psnl0125Service extends RemoteService {
	
	public static class Util {
		private static Psnl0125ServiceAsync instance;
		public static Psnl0125ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0125Service.class);
			}
			return instance;
		}
	}
	
//	/**
//	 * PSNL0125을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Psnl0125VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertPsnl0125(Psnl0125VO vo) throws Exception;
//    
//    /**
//	 * PSNL0125을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Psnl0125VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updatePsnl0125(Psnl0125VO vo) throws Exception;
//    
//    /**
//	 * PSNL0125을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Psnl0125VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deletePsnl0125(Psnl0125VO vo) throws Exception;
//    
//    /**
//	 * PSNL0125을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Psnl0125VO
//	 * @return 조회한 PSNL0125
//	 * @exception Exception
//	 */
//    Psnl0125VO selectPsnl0125(Psnl0125VO vo) throws Exception;
//    
//    /**
//	 * PSNL0125 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PSNL0125 목록
//	 * @exception Exception
//	 */
//    List selectPsnl0125List(Psnl0125DefaultVO searchVO) throws Exception;
//    
//    /**
//	 * PSNL0125 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PSNL0125 총 갯수
//	 * @exception
//	 */
//    int selectPsnl0125ListTotCnt(Psnl0125DefaultVO searchVO);
    
}
