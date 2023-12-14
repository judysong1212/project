package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr2520SrhVO;
import com.app.exterms.insurance.server.vo.Insr2520VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr2520DAO.java
 * @Description : Insr2520 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr2520DAO")
public class Insr2520DAO extends EgovAbstractDAO {
	
	
	/**
	 * INSR2520을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertOrUpdateInsr2520(Insr2520VO vo) throws Exception {
        return (String)insert("insr2520DAO.insertOrUpdateInsr2520_S", vo);
    }

	/**
	 * INSR2520을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr2520(Insr2520VO vo) throws Exception {
        return (String)insert("insr2520DAO.insertInsr2520_S", vo);
    }

    /**
	 * INSR2520을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2520VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2520(Insr2520VO vo) throws Exception {
        update("insr2520DAO.updateInsr2520_S", vo);
    }

    /**
	 * INSR2520을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr2520VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr2520(Insr2520VO vo) throws Exception {
        delete("insr2520DAO.deleteInsr2520_S", vo);
    }

    /**
	 * INSR2520을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2520VO
	 * @return 조회한 INSR2520
	 * @exception Exception
	 */
    public Insr2520VO selectInsr2520(Insr2520VO vo) throws Exception {
        return (Insr2520VO) selectByPk("insr2520DAO.selectInsr2520_S", vo);
    }

    /**
	 * INSR2520 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2520 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2520List(Insr2520SrhVO searchVO) throws Exception {
        return list("insr2520DAO.selectInsr2520List_D", searchVO);
    }

    /**
	 * INSR2520 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2520 총 갯수
	 * @exception
	 */
    public int selectInsr2520ListTotCnt(Insr2520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2520DAO.selectInsr2520ListTotCnt_S", searchVO);
    }

}
