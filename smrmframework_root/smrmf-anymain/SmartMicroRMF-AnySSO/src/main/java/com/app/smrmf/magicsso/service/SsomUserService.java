package com.app.smrmf.magicsso.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.system.LoginVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;

/**
 * @Class Name : SsomUserService.java
 * @Description : SsomUser Business class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SsomUserService {
	
	 
	/**
	 * SSOM_USER?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? SsomUserVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    String insertSsomUser(SsomUserVO vo) throws Exception;
    
    /**
	 * SSOM_USER?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomUserVO
	 * @return void?��
	 * @exception Exception
	 */
    void updateSsomUser(SsomUserVO vo) throws Exception;
    
    /**
	 * SSOM_USER?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomUserVO
	 * @return void?�� 
	 * @exception Exception
	 */
    void deleteSsomUser(SsomUserVO vo) throws Exception;
    
    /**
	 * SSOM_USER?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? SsomUserVO
	 * @return 조회?�� SSOM_USER
	 * @exception Exception
	 */
    SsomUserVO selectSsomUser(SsomUserVO vo) throws Exception;
    
    /**
	 * SSOM_USER 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_USER 목록
	 * @exception Exception
	 */
    List selectSsomUserList(SsomUserSrhVO searchVO) throws Exception;
    
    /**
	 * SSOM_USER �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_USER �? �??��
	 * @exception
	 */
    int selectSsomUserListTotCnt(SsomUserSrhVO searchVO);
    
}
