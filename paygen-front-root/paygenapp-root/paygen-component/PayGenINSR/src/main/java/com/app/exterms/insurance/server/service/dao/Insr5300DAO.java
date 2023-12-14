package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr5300SrhVO;
import com.app.exterms.insurance.server.vo.Insr5300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr5300DAO.java
 * @Description : Insr5300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr5300DAO")
public class Insr5300DAO extends EgovAbstractDAO {

	/**
	 * INSR5300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr5300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr5300(Insr5300VO vo) throws Exception {
        return (String)insert("insr5300DAO.insertInsr5300_S", vo);
    }

    /**
	 * INSR5300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr5300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr5300(Insr5300VO vo) throws Exception {
        update("insr5300DAO.updateInsr5300_S", vo);
    }

    /**
	 * INSR5300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr5300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr5300(Insr5300VO vo) throws Exception {
        delete("insr5300DAO.deleteInsr5300_S", vo);
    }

    /**
	 * INSR5300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr5300VO
	 * @return 조회한 INSR5300
	 * @exception Exception
	 */
    public Insr5300VO selectInsr5300(Insr5300VO vo) throws Exception {
        return (Insr5300VO) selectByPk("insr5300DAO.selectInsr5300_S", vo);
    }

    /**
	 * INSR5300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5300 목록
	 * @exception Exception
	 */
    public List<?> selectInsr5300List(Insr5300SrhVO searchVO) throws Exception {
        return list("insr5300DAO.selectInsr5300List_D", searchVO);
    }

    /**
	 * INSR5300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5300 총 갯수
	 * @exception
	 */
    public int selectInsr5300ListTotCnt(Insr5300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr5300DAO.selectInsr5300ListTotCnt_S", searchVO);
    }

}
