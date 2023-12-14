package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComPsnl0100VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0100DAO.java
 * @Description : Psnl0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComPayr0304DAO")
public class PrgmComPayr0304DAO extends EgovAbstractDAO {

    /**
	 * 연말정산 대상자 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 연말정산 대상자 목록
	 * @exception Exception
	 */
    public List selectYetaP0100List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComPayr0304DAO.selectYetaP0100List_D", searchVO);
    }

    /**
	 * 연말정산 대상자 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 연말정산 대상자 총 갯수
	 * @exception
	 */
    public int selectYetaP0100ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPayr0304DAO.selectYetaP0100ListTotCnt_S", searchVO);
    }

    /**
	 * 급여 대상자 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 급여 대상자 목록
	 * @exception Exception
	 */
    public List selectPayrP405001List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComPayr0304DAO.selectPayrP405001List_D", searchVO);
    }

    /**
	 * 급여 대상자 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 급여 대상자 총 갯수
	 * @exception
	 */
    public int selectPayrP405001ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPayr0304DAO.selectPayrP405001ListTotCnt_S", searchVO);
    }
    

}
