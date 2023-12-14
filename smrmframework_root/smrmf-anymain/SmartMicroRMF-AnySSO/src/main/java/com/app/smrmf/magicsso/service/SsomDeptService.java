package com.app.smrmf.magicsso.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.system.SsomDeptSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsomDeptVO;

/**
 * @Class Name : SsomDeptService.java
 * @Description : SsomDept Business class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SsomDeptService {
	
	/**
	 * SSOM_DEPT?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? SsomDeptVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    String insertSsomDept(SsomDeptVO vo) throws Exception;
    
    /**
	 * SSOM_DEPT?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomDeptVO
	 * @return void?��
	 * @exception Exception
	 */
    void updateSsomDept(SsomDeptVO vo) throws Exception;
    
    /**
	 * SSOM_DEPT?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomDeptVO
	 * @return void?�� 
	 * @exception Exception
	 */
    void deleteSsomDept(SsomDeptVO vo) throws Exception;
    
    /**
	 * SSOM_DEPT?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? SsomDeptVO
	 * @return 조회?�� SSOM_DEPT
	 * @exception Exception
	 */
    SsomDeptVO selectSsomDept(SsomDeptVO vo) throws Exception;
    
    /**
	 * SSOM_DEPT 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_DEPT 목록
	 * @exception Exception
	 */
    List selectSsomDeptList(SsomDeptSrhVO searchVO) throws Exception;
    
    /**
	 * SSOM_DEPT �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_DEPT �? �??��
	 * @exception
	 */
    int selectSsomDeptListTotCnt(SsomDeptSrhVO searchVO);
    
}
