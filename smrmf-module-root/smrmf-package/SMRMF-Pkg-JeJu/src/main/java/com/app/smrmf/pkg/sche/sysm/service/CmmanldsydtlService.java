package com.app.smrmf.pkg.sche.sysm.service;

import java.util.List;

import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsydtlSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsydtlVO;

/**
 * @Class Name : CmmanldsydtlService.java
 * @Description : Cmmanldsydtl Business class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface CmmanldsydtlService {
	
	/**
	 * CMMANLDSYDTL?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldsydtlVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    String insertCmmanldsydtl(CmmanldsydtlVO vo) throws Exception;
    
    /**
	 * CMMANLDSYDTL?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return void?��
	 * @exception Exception
	 */
    void updateCmmanldsydtl(CmmanldsydtlVO vo) throws Exception;
    
    /**
	 * CMMANLDSYDTL?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return void?�� 
	 * @exception Exception
	 */
    void deleteCmmanldsydtl(CmmanldsydtlVO vo) throws Exception;
    
    /**
	 * CMMANLDSYDTL?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return 조회?�� CMMANLDSYDTL
	 * @exception Exception
	 */
    CmmanldsydtlVO selectCmmanldsydtl(CmmanldsydtlVO vo) throws Exception;
    
    /**
	 * CMMANLDSYDTL 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYDTL 목록
	 * @exception Exception
	 */
    List selectCmmanldsydtlList(CmmanldsydtlSrhVO searchVO) throws Exception;
    
    /**
	 * CMMANLDSYDTL �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYDTL �? �??��
	 * @exception
	 */
    int selectCmmanldsydtlListTotCnt(CmmanldsydtlSrhVO searchVO);
    
}
