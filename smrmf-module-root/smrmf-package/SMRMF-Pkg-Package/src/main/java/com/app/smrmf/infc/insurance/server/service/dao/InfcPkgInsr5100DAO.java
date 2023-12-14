package com.app.smrmf.infc.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr5100DAO.java
 * @Description : Insr5100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr5100DAO")
public class InfcPkgInsr5100DAO extends EgovAbstractDAO {

	/**
	 * INSR5100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr5100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr5100(InfcPkgInsr5100VO vo) throws Exception {
        return (String)insert("infcPkgInsr5100DAO.insertInsr5100_S", vo);
    }
    
	/**
	 * INSR5100을 등록한다.(누락자 데이터 생성)
	 * @param vo - 등록할 정보가 담긴 Insr5100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr5100_NOT_EXISTS(InfcPkgInsr5100VO vo) throws Exception {
        return (String)insert("infcPkgInsr5100DAO.insertInsr5100_NOT_EXISTS", vo);
    }

    /**
	 * INSR5100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr5100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr5100(InfcPkgInsr5100VO vo) throws Exception {
        update("infcPkgInsr5100DAO.updateInsr5100_S", vo);
    }

    /**
	 * INSR5100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr5100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr5100(InfcPkgInsr5100VO vo) throws Exception {
        delete("infcPkgInsr5100DAO.deleteInsr5100_S", vo);
    }

    /**
	 * INSR5100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr5100VO
	 * @return 조회한 INSR5100
	 * @exception Exception
	 */
    public InfcPkgInsr5100VO selectInsr5100(InfcPkgInsr5100VO vo) throws Exception {
        return (InfcPkgInsr5100VO) selectByPk("infcPkgInsr5100DAO.selectInsr5100_S", vo);
    }

    /**
	 * INSR5100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr5100List(InfcPkgInsr5100SrhVO searchVO) throws Exception {
        return list("infcPkgInsr5100DAO.selectInsr5100List_D", searchVO);
    }

    /**
	 * INSR5100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5100 총 갯수
	 * @exception
	 */
    public int selectInsr5100ListTotCnt(InfcPkgInsr5100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgInsr5100DAO.selectInsr5100ListTotCnt_S", searchVO);
    }
    
}
