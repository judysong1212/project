package com.web.exterms.mypage.board.service;

import java.util.List;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;
import com.web.exterms.mypage.board.service.BoardPageVO;

/**
 * @Class Name : Bord0300Service.java
 * @Description : Bord0300 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface BoardPageService {
	
	/**
	 * BORD0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertBoardPage(BoardPageVO vo) throws Exception;

    /**
	 * BORD0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0300VO
	 * @return void형
	 * @exception Exception
	 */
    void updateBoardPage(BoardPageVO vo) throws Exception;
    
    /**
	 * BORD0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0300VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteBoardPage(BoardPageVO vo) throws Exception;
    
    /**
	 * BORD0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0300VO
	 * @return 조회한 BORD0300
	 * @exception Exception
	 */
    BoardPageVO selectBoardPage(BoardPageVO vo) throws Exception;
    
    /**
	 * BORD0300 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0300 목록
	 * @exception Exception
	 */
    List selectBoardPageList(BoardPageDefaultVO searchVO) throws Exception;
    
    /**
	 * BORD0300 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0300 총 갯수
	 * @exception
	 */
    int selectBoardPageListTotCnt(BoardPageDefaultVO searchVO);
    
}
