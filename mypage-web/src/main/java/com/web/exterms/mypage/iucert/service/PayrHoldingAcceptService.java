package com.web.exterms.mypage.iucert.service;

import java.util.List;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptDefaultVO;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptVO;

/**
 * @Class Name : Payr0900Service.java
 * @Description : Payr0900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PayrHoldingAcceptService {
	
	/**
	 * PAYR0900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPayr0900(PayrHoldingAcceptVO vo) throws Exception;
    
    /**
	 * PAYR0900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0900VO
	 * @return void형
	 * @exception Exception
	 */
    void updatePayr0900(PayrHoldingAcceptVO vo) throws Exception;
    
    /**
	 * PAYR0900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0900VO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePayr0900(PayrHoldingAcceptVO vo) throws Exception;
    
    /**
	 * PAYR0900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0900VO
	 * @return 조회한 PAYR0900
	 * @exception Exception
	 */
    PayrHoldingAcceptVO selectPayr0900(PayrHoldingAcceptVO vo) throws Exception;
    
    /**
	 * PAYR0900 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0900 목록
	 * @exception Exception
	 */
    List selectPayr0900List(PayrHoldingAcceptDefaultVO searchVO) throws Exception;
    
    /**
	 * PAYR0900 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0900 총 갯수
	 * @exception
	 */
    int selectPayr0900ListTotCnt(PayrHoldingAcceptDefaultVO searchVO);
    
}
