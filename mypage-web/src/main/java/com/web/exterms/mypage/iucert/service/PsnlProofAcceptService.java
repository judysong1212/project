package com.web.exterms.mypage.iucert.service;

import java.util.List;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptDefaultVO;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;

/**
 * @Class Name : Psnl0550Service.java
 * @Description : Psnl0550 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PsnlProofAcceptService {
	
	/**
	 * PSNL0550을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0550VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPsnl0550(PsnlProofAcceptVO vo) throws Exception;
    
    /**
	 * PSNL0550을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0550VO
	 * @return void형
	 * @exception Exception
	 */
    void updatePsnl0550(PsnlProofAcceptVO vo) throws Exception;
    
    /**
	 * PSNL0550을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0550VO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePsnl0550(PsnlProofAcceptVO vo) throws Exception;
    
    /**
	 * PSNL0550을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0550VO
	 * @return 조회한 PSNL0550
	 * @exception Exception
	 */
    PsnlProofAcceptVO selectPsnl0550(PsnlProofAcceptVO vo) throws Exception;
    
    /**
	 * PSNL0550 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0550 목록
	 * @exception Exception
	 */
    List selectPsnl0550List(PsnlProofAcceptDefaultVO searchVO) throws Exception;
    
    /**
	 * PSNL0550 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0550 총 갯수
	 * @exception
	 */
    int selectPsnl0550ListTotCnt(PsnlProofAcceptDefaultVO searchVO);
    
}
