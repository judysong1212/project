package com.web.exterms.mypage.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import com.web.exterms.mypage.board.service.BoardPageVO;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;


/**
 * @Class Name : Bord0300DAO.java
 * @Description : Bord0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("boardPageDAO")
public class BoardPageDAO extends EgovAbstractDAO {

	/**
	 * BORD0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBoardPage(BoardPageVO vo) throws Exception {
        return (String)insert("boardPageDAO.insertBoardPage_S", vo);
    }
    
   
    /**
	 * BORD0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBoardPage(BoardPageVO vo) throws Exception {
        update("boardPageDAO.updateBoardPage_S", vo);
    }

    /**
	 * BORD0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBoardPage(BoardPageVO vo) throws Exception {
        delete("boardPageDAO.deleteBoardPage_S", vo);
    }

    /**
	 * BORD0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0300VO
	 * @return 조회한 BORD0300
	 * @exception Exception
	 */
    public BoardPageVO selectBoardPage(BoardPageVO vo) throws Exception {
        return (BoardPageVO) selectByPk("boardPageDAO.selectBoardPage_S", vo);
    }

    /**
	 * BORD0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0300 목록
	 * @exception Exception
	 */
    public List selectBoardPageList(BoardPageDefaultVO searchVO) throws Exception {
        return list("boardPageDAO.selectBoardPageList_D", searchVO);
    }

    /**
	 * BORD0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0300 총 갯수
	 * @exception
	 */
    public int selectBoardPageListTotCnt(BoardPageDefaultVO searchVO) {
        return (Integer) getSqlMapClientTemplate().queryForObject("boardPageDAO.selectBoardPageListTotCnt_S", searchVO);
    }

}
