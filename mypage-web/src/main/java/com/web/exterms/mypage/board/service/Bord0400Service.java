package com.web.exterms.mypage.board.service;

import java.util.List;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;
import com.web.exterms.mypage.board.service.Bord0400VO;

/**
 * @Class Name : Bord0400Service.java
 * @Description : Bord0400 Business class
 * @Modification Information
 *
 * @author boardsubmit
 * @since boardsubmit
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Bord0400Service {
	
	/**
	 * BORD0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertBoardPage1(Bord0400VO vo) throws Exception;
    
    /**
	 * BORD0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0400VO
	 * @return void형
	 * @exception Exception
	 */
    void updateBord0400(Bord0400VO vo) throws Exception;
    
    /**
	 * BORD0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0400VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteBord0400(Bord0400VO vo) throws Exception;
    
    /**
	 * BORD0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0400VO
	 * @return 조회한 BORD0400
	 * @exception Exception
	 */
    Bord0400VO selectBord0400(Bord0400VO vo) throws Exception;
    
    /**
	 * BORD0400 파일 유무를 조회한다
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 목록
	 * @exception Exception
	 */
    List selectCheckBord0400(Bord0400VO vo) throws Exception;
    
    /**
	 * BORD0400 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 목록
	 * @exception Exception
	 */
    List selectBord0400List(BoardPageDefaultVO searchVO) throws Exception;
    
    /**
	 * BORD0400 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 총 갯수
	 * @exception
	 */
    int selectBord0400ListTotCnt(BoardPageDefaultVO searchVO);
    
}
