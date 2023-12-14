package com.app.smrmf.sysauth.systemusr.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @Class Name : Sysb0500Service.java
 * @Description : Sysb0500 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("Sysb0500Service.gwt")
public interface Sysb0500Service  extends RemoteService {
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Sysb0500ServiceAsync instance;
		public static Sysb0500ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Sysb0500Service.class);
			}
			return instance;
		}
	}
	
//	/**
//	 * SYSB0500?�� ?��록한?��.
//	 * @param vo - ?��록할 ?��보�? ?���? Sysb0500VO
//	 * @return ?���? 결과
//	 * @exception Exception
//	 */
//    String insertSysb0500(SysIfSysb0500VO vo) throws Exception;
//    
//    /**
//	 * SYSB0500?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0500VO
//	 * @return void?��
//	 * @exception Exception
//	 */
//    void updateSysb0500(SysIfSysb0500VO vo) throws Exception;
//    
//    /**
//	 * SYSB0500?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0500VO
//	 * @return void?�� 
//	 * @exception Exception
//	 */
//    void deleteSysb0500(SysIfSysb0500VO vo) throws Exception;
//    
//    /**
//	 * SYSB0500?�� 조회?��?��.
//	 * @param vo - 조회?�� ?��보�? ?���? Sysb0500VO
//	 * @return 조회?�� SYSB0500
//	 * @exception Exception
//	 */
//    SysIfSysb0500VO selectSysb0500(SysIfSysb0500VO vo) throws Exception;
//    
//    /**
//	 * SYSB0500 목록?�� 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0500 목록
//	 * @exception Exception
//	 */
//    List selectSysb0500List(SysIfSysb0500SrhVO searchVO) throws Exception;
//    
//    /**
//	 * SYSB0500 �? �??���? 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0500 �? �??��
//	 * @exception
//	 */
//    int selectSysb0500ListTotCnt(SysIfSysb0500SrhVO searchVO);
    
}
