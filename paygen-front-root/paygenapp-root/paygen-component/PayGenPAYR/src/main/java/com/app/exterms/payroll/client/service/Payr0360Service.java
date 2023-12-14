package com.app.exterms.payroll.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Payr0360Service.java
 * @Description : Payr0360 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Payr0360Service.gwt")
public interface Payr0360Service {
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr0360ServiceAsync instance;
		public static Payr0360ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr0360Service.class);
			}
			return instance;
		}
	}		
	
//	/**
//	 * PAYR0360을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0360VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertPayr0360(Payr0360VO vo) throws Exception;
//    
//    /**
//	 * PAYR0360을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0360VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updatePayr0360(Payr0360VO vo) throws Exception;
//    
//    /**
//	 * PAYR0360을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0360VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deletePayr0360(Payr0360VO vo) throws Exception;
//    
//    /**
//	 * PAYR0360을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0360VO
//	 * @return 조회한 PAYR0360
//	 * @exception Exception
//	 */
//    Payr0360VO selectPayr0360(Payr0360VO vo) throws Exception;
//    
//    /**
//	 * PAYR0360 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0360 목록
//	 * @exception Exception
//	 */
//    List selectPayr0360List(Payr0360SrhVO searchVO) throws Exception;
//    
//    /**
//	 * PAYR0360 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0360 총 갯수
//	 * @exception
//	 */
//    int selectPayr0360ListTotCnt(Payr0360SrhVO searchVO);
    
}
