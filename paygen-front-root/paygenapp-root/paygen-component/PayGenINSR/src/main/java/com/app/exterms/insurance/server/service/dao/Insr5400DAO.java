package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr5400SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr5400DAO.java
 * @Description : Insr5400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr5400DAO")
public class Insr5400DAO extends EgovAbstractDAO {

	/**
	 * INSR5300을 조회한다
	 * @param vo - 조회할 정보가 담긴 Insr5400VO
	 * @return 조회 결과
	 * @exception Exception
	 */
    public List<?> selectInsr5300ToInsr5400List(Insr5400SrhVO vo) throws Exception {
    	return list("insr5400DAO.selectInsr5300ToInsr5400List", vo);
    }

	/**
	 * INSR5300을 건수조회한다
	 * @param vo - 등록할 정보가 담긴 Insr5400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public int selectInsr5300ToInsr5400ListCnt(Insr5400SrhVO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr5400DAO.selectInsr5300ToInsr5400ListCnt", vo);
    }

	/**
	 * INSR5300을 건수조회한다
	 * @param vo - 조회할 정보가 담긴 Insr5400SrhVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public int selectInsr5300Cnt(Insr5400SrhVO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr5400DAO.selectInsr5300Cnt", vo);
    }

	/**
	 * INSR6200을 건수조회한다
	 * @param vo - 조회할 정보가 담긴 Insr5400SrhVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public int selectInsr6200Cnt(Insr5400SrhVO vo) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("insr5400DAO.selectInsr6200Cnt", vo);
    }

//    /**
//	 * 엑셀저장 insr4100  화면 엑셀저장 INSR3000 목록을 조회한다.
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return INSR3000 목록
//	 * @exception Exception
//	 */
//    public List selectXlsInsr3000List(Insr3000SrhVO searchVO) throws Exception {
//        return list("insr3000DAO.selectXlsInsr3000List_D", searchVO);
//    }

    /**
	 * 엑셀저장 insr5400  화면 엑셀저장 INSR6200, INSR5300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List selectInsr5300ToInsr5400ListXls(Insr5400SrhVO searchVO) throws Exception {
    	logger.debug("00000001");
        return list("insr5400DAO.selectInsr5300ToInsr5400ListXls", searchVO);
    }

	/**
	 * INSR5300을 등록한다
	 * @param vo - 등록할 정보가 담긴 Insr5400SrhVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertInsr5300(Insr5400SrhVO vo) throws Exception {
    	logger.debug("000001");
    	insert("insr5400DAO.insertInsr5300", vo);
    }

    /**
	 * INSR6200을 등록한다
	 * @param vo - 등록할 정보가 담긴 Insr5400SrhVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertInsr6200(Insr5400SrhVO vo) throws Exception {
    	logger.debug("00000001");
    	insert("insr5400DAO.insertInsr6200", vo);
    }
 
	/**
	 * INSR5300을 업데이트한다
	 * @param vo - 업데이트할 정보가 담긴 Insr5400SrhVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateInsr5300(Insr5400SrhVO vo) throws Exception {
    	logger.debug("000000001");
    	insert("insr5400DAO.updateInsr5300", vo);
    }

	/**
	 * INSR6200을 업데이트한다
	 * @param vo - 업데이트할 정보가 담긴 Insr5400SrhVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateInsr6200(Insr5400SrhVO vo) throws Exception {
    	logger.debug("0000000001");
    	insert("insr5400DAO.updateInsr6200", vo);
    }
}