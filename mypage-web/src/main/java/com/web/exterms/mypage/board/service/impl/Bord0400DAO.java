package com.web.exterms.mypage.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import com.web.exterms.mypage.board.service.BoardPageDefaultVO;
import com.web.exterms.mypage.board.service.BoardPageVO;
import com.web.exterms.mypage.board.service.Bord0400VO;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;

/**
 * @Class Name : Bord0400DAO.java
 * @Description : Bord0400 DAO Class
 * @Modification Information
 *
 * @author boardsubmit
 * @since boardsubmit
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("bord0400DAO")
public class Bord0400DAO extends EgovAbstractDAO {

	/**
	 * BORD0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBoardPage1(Bord0400VO vo) throws Exception {
        return (String)insert("bord0400DAO.insertBoardPage_D", vo);
    }

    /**
	 * BORD0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBord0400(Bord0400VO vo) throws Exception {
        update("bord0400DAO.updateBord0400_S", vo);
    }

    /**
	 * BORD0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0400VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBord0400(Bord0400VO vo) throws Exception {
        delete("bord0400DAO.deleteBord0400_S", vo);
    }

    /**
	 * BORD0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0400VO
	 * @return 조회한 BORD0400
	 * @exception Exception
	 */
    public Bord0400VO selectBord0400(Bord0400VO vo) throws Exception {
        return (Bord0400VO) selectByPk("bord0400DAO.selectBord0400_S", vo);
    }
    
    /**
	 * BORD0400 파일 유무를 조회한다
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 목록
	 * @exception Exception
	 */
    public List selectCheckBord0400(Bord0400VO vo) throws Exception {
        return list("bord0400DAO.selectCheckBord0400_D", vo);
    }

    /**
	 * BORD0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0400 목록
	 * @exception Exception
	 */
    public List selectBord0400List(BoardPageDefaultVO searchVO) throws Exception {
        return list("bord0400DAO.selectBord0400List_D", searchVO);
    }

    /**
	 * BORD0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BORD0400 총 갯수
	 * @exception
	 */
    public int selectBord0400ListTotCnt(BoardPageDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bord0400DAO.selectBord0400ListTotCnt_S", searchVO);
    }

}
