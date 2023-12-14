package com.app.exterms.payroll.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Payr0303Service.java
 * @Description : Payr0303 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Payr0303Service.gwt")
public interface Payr0303Service extends RemoteService {
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr0303ServiceAsync instance;
		public static Payr0303ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr0303Service.class);
			}
			return instance;
		}
	}	
	 
//	/**
//	 * PAYR0303을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0303VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertPayr0303(Payr0303VO vo) throws Exception;
//    
//    /**
//	 * PAYR0303을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0303VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updatePayr0303(Payr0303VO vo) throws Exception;
//    
//    /**
//	 * PAYR0303을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0303VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deletePayr0303(Payr0303VO vo) throws Exception;
//    
//    /**
//	 * PAYR0303을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0303VO
//	 * @return 조회한 PAYR0303
//	 * @exception Exception
//	 */
//    Payr0303VO selectPayr0303(Payr0303VO vo) throws Exception;
//    
//    /**
//	 * PAYR0303 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0303 목록
//	 * @exception Exception
//	 */
//    List selectPayr0303List(Payr0303DefaultVO searchVO) throws Exception;
//    
//    /**
//	 * PAYR0303 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0303 총 갯수
//	 * @exception
//	 */
//    int selectPayr0303ListTotCnt(Payr0303DefaultVO searchVO);
    
}
