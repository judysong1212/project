package com.app.smrmf.sysauth.systemusr.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Sysm0850Service.java
 * @Description : Sysm0850 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
 
@RemoteServiceRelativePath("SysmUsr0850Service.gwt")
public interface SysmUsr0850Service extends RemoteService {
		/**
		 * Utility class for simplifying access to the instance of async service.
		 */
		public static class Util {
			private static SysmUsr0850ServiceAsync instance;
			public static SysmUsr0850ServiceAsync getInstance(){
				if (instance == null) {
					instance = GWT.create(SysmUsr0850Service.class);
				}
				return instance;
			}
		}	
//	/**
//	 * SYSM0850을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Sysm0850VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertSysm0850(Sysm0850VO vo) throws Exception;
//    
//    /**
//	 * SYSM0850을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Sysm0850VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updateSysm0850(Sysm0850VO vo) throws Exception;
//    
//    /**
//	 * SYSM0850을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Sysm0850VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deleteSysm0850(Sysm0850VO vo) throws Exception;
//    
//    /**
//	 * SYSM0850을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Sysm0850VO
//	 * @return 조회한 SYSM0850
//	 * @exception Exception
//	 */
//    Sysm0850VO selectSysm0850(Sysm0850VO vo) throws Exception;
//    
//    /**
//	 * SYSM0850 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return SYSM0850 목록
//	 * @exception Exception
//	 */
//    List selectSysm0850List(Sysm0850SrhVO searchVO) throws Exception;
//    
//    /**
//	 * SYSM0850 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return SYSM0850 총 갯수
//	 * @exception
//	 */
//    int selectSysm0850ListTotCnt(Sysm0850SrhVO searchVO);
//    
}
