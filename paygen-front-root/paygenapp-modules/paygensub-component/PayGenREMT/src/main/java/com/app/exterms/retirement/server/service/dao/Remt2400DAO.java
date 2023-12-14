package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.retirement.server.vo.Remt2400SrhVO;
import com.app.exterms.retirement.server.vo.Remt2400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt2400DAO.java
 * @Description : Remt2400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt2400DAO")
public class Remt2400DAO extends EgovAbstractDAO {

	/**
	 * REMT2400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2400(Remt2400VO vo) throws Exception {
        return (String)insert("remt2400DAO.insertRemt2400_S", vo);
    }

    /**
	 * REMT2400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2400(Remt2400VO vo) throws Exception {
        update("remt2400DAO.updateRemt2400_S", vo);
    }

    /**
	 * REMT2400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2400VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2400(Remt2400VO vo) throws Exception {
        delete("remt2400DAO.deleteRemt2400_S", vo);
    }

    /**
	 * REMT2400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2400VO
	 * @return 조회한 REMT2400
	 * @exception Exception
	 */
    public Remt2400VO selectRemt2400(Remt2400VO vo) throws Exception {
        return (Remt2400VO) selectByPk("remt2400DAO.selectRemt2400_S", vo);
    }

    /**
	 * REMT2400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2400 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2400List(Remt2400SrhVO searchVO) throws Exception {
        return list("remt2400DAO.selectRemt2400List_D", searchVO);
    }

    /**
	 * REMT2400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2400 총 갯수
	 * @exception
	 */
    public int selectRemt2400ListTotCnt(Remt2400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt2400DAO.selectRemt2400ListTotCnt_S", searchVO);
    }

}
