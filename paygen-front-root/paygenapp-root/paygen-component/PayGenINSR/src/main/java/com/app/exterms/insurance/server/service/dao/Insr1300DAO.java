package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr1300SrhVO;
import com.app.exterms.insurance.server.vo.Insr1300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr1300DAO.java
 * @Description : Insr1300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr1300DAO")
public class Insr1300DAO extends EgovAbstractDAO {

	/**
	 * INSR1300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr1300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr1300(Insr1300VO vo) throws Exception {
        return (String)insert("insr1300DAO.insertInsr1300_S", vo);
    }

    /**
	 * INSR1300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr1300(Insr1300VO vo) throws Exception {
        update("insr1300DAO.updateInsr1300_S", vo);
    }

    /**
	 * INSR1300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr1300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr1300(Insr1300VO vo) throws Exception {
        delete("insr1300DAO.deleteInsr1300_S", vo);
    }

    /**
	 * INSR1300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr1300VO
	 * @return 조회한 INSR1300
	 * @exception Exception
	 */
    public Insr1300VO selectInsr1300(Insr1300VO vo) throws Exception {
        return (Insr1300VO) selectByPk("insr1300DAO.selectInsr1300_S", vo);
    }

    /**
	 * INSR1300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1300 목록
	 * @exception Exception
	 */
    public List<?> selectInsr1300List(Insr1300SrhVO searchVO) throws Exception {
        return list("insr1300DAO.selectInsr1300List_D", searchVO);
    }

    /**
	 * INSR1300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1300 총 갯수
	 * @exception
	 */
    public int selectInsr1300ListTotCnt(Insr1300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1300DAO.selectInsr1300ListTotCnt_S", searchVO);
    }

}
