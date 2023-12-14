package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr6200SrhVO;
import com.app.exterms.insurance.server.vo.Insr6200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr6200DAO.java
 * @Description : Insr6200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr6200DAO")
public class Insr6200DAO extends EgovAbstractDAO {

	/**
	 * INSR6200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr6200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr6200(Insr6200VO vo) throws Exception {
        return (String)insert("insr6200DAO.insertInsr6200_S", vo);
    }

    /**
	 * INSR6200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr6200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr6200(Insr6200VO vo) throws Exception {
        update("insr6200DAO.updateInsr6200_S", vo);
    }

    /**
	 * INSR6200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr6200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr6200(Insr6200VO vo) throws Exception {
        delete("insr6200DAO.deleteInsr6200_S", vo);
    }

    /**
	 * INSR6200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr6200VO
	 * @return 조회한 INSR6200
	 * @exception Exception
	 */
    public Insr6200VO selectInsr6200(Insr6200VO vo) throws Exception {
        return (Insr6200VO) selectByPk("insr6200DAO.selectInsr6200_S", vo);
    }

    /**
	 * INSR6200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6200 목록
	 * @exception Exception
	 */
    public List<?> selectInsr6200List(Insr6200SrhVO searchVO) throws Exception {
        return list("insr6200DAO.selectInsr6200List_D", searchVO);
    }

    /**
	 * INSR6200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6200 총 갯수
	 * @exception
	 */
    public int selectInsr6200ListTotCnt(Insr6200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr6200DAO.selectInsr6200ListTotCnt_S", searchVO);
    }

}
