package com.app.exterms.payroll.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Payr0350Service.java
 * @Description : Payr0350 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Payr0350Service.gwt")
public interface Payr0350Service {
 
		/**
		 * Utility class for simplifying access to the instance of async service.
		 */
		public static class Util {
			private static Payr0350ServiceAsync instance;
			public static Payr0350ServiceAsync getInstance(){
				if (instance == null) {
					instance = GWT.create(Payr0350Service.class);
				}
				return instance;
			}
		}		
	
//	/**
//	 * PAYR0350을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0350VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertPayr0350(Payr0350VO vo) throws Exception;
//    
//    /**
//	 * PAYR0350을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0350VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updatePayr0350(Payr0350VO vo) throws Exception;
//    
//    /**
//	 * PAYR0350을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0350VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deletePayr0350(Payr0350VO vo) throws Exception;
//    
//    /**
//	 * PAYR0350을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0350VO
//	 * @return 조회한 PAYR0350
//	 * @exception Exception
//	 */
//    Payr0350VO selectPayr0350(Payr0350VO vo) throws Exception;
//    
//    /**
//	 * PAYR0350 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0350 목록
//	 * @exception Exception
//	 */
//    List selectPayr0350List(Payr0350DefaultVO searchVO) throws Exception;
//    
//    /**
//	 * PAYR0350 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0350 총 갯수
//	 * @exception
//	 */
//    int selectPayr0350ListTotCnt(Payr0350DefaultVO searchVO);
    
}
