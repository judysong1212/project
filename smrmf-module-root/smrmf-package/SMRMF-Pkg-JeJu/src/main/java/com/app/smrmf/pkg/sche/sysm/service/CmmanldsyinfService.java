package com.app.smrmf.pkg.sche.sysm.service;

import java.util.List;

import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsyinfSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsyinfVO;

/**
 * @Class Name : CmmanldsyinfService.java
 * @Description : Cmmanldsyinf Business class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface CmmanldsyinfService {
	
	/**
	 * CMMANLDSYINF?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldsyinfVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    String insertCmmanldsyinf(CmmanldsyinfVO vo) throws Exception;
    
    /**
	 * CMMANLDSYINF?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return void?��
	 * @exception Exception
	 */
    void updateCmmanldsyinf(CmmanldsyinfVO vo) throws Exception;
    
    /**
	 * CMMANLDSYINF?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return void?�� 
	 * @exception Exception
	 */
    void deleteCmmanldsyinf(CmmanldsyinfVO vo) throws Exception;
    
    /**
	 * CMMANLDSYINF?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return 조회?�� CMMANLDSYINF
	 * @exception Exception
	 */
    CmmanldsyinfVO selectCmmanldsyinf(CmmanldsyinfVO vo) throws Exception;
    
    /**
	 * CMMANLDSYINF 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYINF 목록
	 * @exception Exception
	 */
    List selectCmmanldsyinfList(CmmanldsyinfSrhVO searchVO) throws Exception;
    
    /**
	 * CMMANLDSYINF �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYINF �? �??��
	 * @exception
	 */
    int selectCmmanldsyinfListTotCnt(CmmanldsyinfSrhVO searchVO);
    
}
