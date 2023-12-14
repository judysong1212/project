package com.app.smrmf.pkg.sche.sysm.service;

import java.util.List;

import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldlastwrkSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldlastwrkVO;

/**
 * @Class Name : CmmanldlastwrkService.java
 * @Description : Cmmanldlastwrk Business class
 * @Modification Information
 *
 * @author atres
 * @since 2018.0123
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface CmmanldlastwrkService {
	
	/**
	 * CMMANLDLASTWRK?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldlastwrkVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    String insertCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception;
    
    /**
	 * CMMANLDLASTWRK?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return void?��
	 * @exception Exception
	 */
    void updateCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception;
    
    /**
	 * CMMANLDLASTWRK?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return void?�� 
	 * @exception Exception
	 */
    void deleteCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception;
    
    /**
	 * CMMANLDLASTWRK?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return 조회?�� CMMANLDLASTWRK
	 * @exception Exception
	 */
    CmmanldlastwrkVO selectCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception;
    
    /**
	 * CMMANLDLASTWRK 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDLASTWRK 목록
	 * @exception Exception
	 */
    List selectCmmanldlastwrkList(CmmanldlastwrkSrhVO searchVO) throws Exception;
    
    /**
	 * CMMANLDLASTWRK �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDLASTWRK �? �??��
	 * @exception
	 */
    int selectCmmanldlastwrkListTotCnt(CmmanldlastwrkSrhVO searchVO);
    
}
