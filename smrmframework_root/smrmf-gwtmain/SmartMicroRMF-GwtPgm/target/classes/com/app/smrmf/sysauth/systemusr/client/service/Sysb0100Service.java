package com.app.smrmf.sysauth.systemusr.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Sysb0100Service.java
 * @Description : Sysb0100 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Sysb0100Service.gwt")
public interface Sysb0100Service  extends RemoteService {
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Sysb0100ServiceAsync instance;
		public static Sysb0100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Sysb0100Service.class);
			}
			return instance;
		}
	}
	
//	/**
//	 * SYSB0100?�� ?��록한?��.
//	 * @param vo - ?��록할 ?��보�? ?���? Sysb0100VO
//	 * @return ?���? 결과
//	 * @exception Exception
//	 */
//    String insertSysb0100(SysIfSysb0100VO vo) throws Exception;
//    
//    /**
//	 * SYSB0100?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0100VO
//	 * @return void?��
//	 * @exception Exception
//	 */
//    void updateSysb0100(SysIfSysb0100VO vo) throws Exception;
//    
//    /**
//	 * SYSB0100?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0100VO
//	 * @return void?�� 
//	 * @exception Exception
//	 */
//    void deleteSysb0100(SysIfSysb0100VO vo) throws Exception;
//    
//    /**
//	 * SYSB0100?�� 조회?��?��.
//	 * @param vo - 조회?�� ?��보�? ?���? Sysb0100VO
//	 * @return 조회?�� SYSB0100
//	 * @exception Exception
//	 */
//    SysIfSysb0100VO selectSysb0100(SysIfSysb0100VO vo) throws Exception;
//    
//    /**
//	 * SYSB0100 목록?�� 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0100 목록
//	 * @exception Exception
//	 */
//    List selectSysb0100List(Sysb0100DefaultVO searchVO) throws Exception;
//    
//    /**
//	 * SYSB0100 �? �??���? 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0100 �? �??��
//	 * @exception
//	 */
//    int selectSysb0100ListTotCnt(Sysb0100DefaultVO searchVO);
    
}
