package com.app.smrmf.infc.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr6100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr6100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr6100DAO.java
 * @Description : Insr6100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr6100DAO")
public class InfcPkgInsr6100DAO extends EgovAbstractDAO {

	/**
	 * INSR6100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr6100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr6100(InfcPkgInsr6100VO vo) throws Exception {
        return (String)insert("infcPkgInsr6100DAO.insertInsr6100_S", vo);
    }
    
	/**
	 * INSR6100을 등록한다.(누락 데이터 생성)
	 * @param vo - 등록할 정보가 담긴 Insr6100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr6100_NOT_EXISTS(InfcPkgInsr6100VO vo) throws Exception {
        return (String)insert("infcPkgInsr6100DAO.insertInsr6100_NOT_EXISTS", vo);
    }

    /**
	 * INSR6100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr6100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr6100(InfcPkgInsr6100VO vo) throws Exception {
        update("infcPkgInsr6100DAO.updateInsr6100_S", vo);
    }

    /**
	 * INSR6100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr6100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr6100(InfcPkgInsr6100VO vo) throws Exception {
        delete("infcPkgInsr6100DAO.deleteInsr6100_S", vo);
    }

    /**
	 * INSR6100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr6100VO
	 * @return 조회한 INSR6100
	 * @exception Exception
	 */
    public InfcPkgInsr6100VO selectInsr6100(InfcPkgInsr6100VO vo) throws Exception {
        return (InfcPkgInsr6100VO) selectByPk("infcPkgInsr6100DAO.selectInsr6100_S", vo);
    }

    /**
	 * INSR6100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr6100List(InfcPkgInsr6100SrhVO searchVO) throws Exception {
        return list("infcPkgInsr6100DAO.selectInsr6100List_D", searchVO);
    }

    /**
	 * INSR6100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR6100 총 갯수
	 * @exception
	 */
    public int selectInsr6100ListTotCnt(InfcPkgInsr6100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgInsr6100DAO.selectInsr6100ListTotCnt_S", searchVO);
    }

}
