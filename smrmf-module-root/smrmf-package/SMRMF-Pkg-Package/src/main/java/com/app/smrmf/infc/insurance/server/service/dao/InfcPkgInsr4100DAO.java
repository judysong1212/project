package com.app.smrmf.infc.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr4100DAO.java
 * @Description : Insr4100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr4100DAO")
public class InfcPkgInsr4100DAO extends EgovAbstractDAO {

	/**
	 * INSR4100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr4100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr4100(InfcPkgInsr4100VO vo) throws MSFException {
        return (String)insert("infcPkgInsr4100DAO.insertInsr4100_S", vo);
    }
    
    
	/**
	 * INSR4100을 등록한다.(누락데이터 생성)
	 * @param vo - 등록할 정보가 담긴 Insr4100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr4100_NOT_EXISTS(InfcPkgInsr4100VO vo) throws MSFException {
        return (String)insert("infcPkgInsr4100DAO.insertInsr4100_NOT_EXISTS", vo);
    }

    /**
	 * INSR4100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr4100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr4100(InfcPkgInsr4100VO vo) throws MSFException {
        update("infcPkgInsr4100DAO.updateInsr4100_S", vo);
    }
    
   

    /**
	 * INSR4100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr4100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr4100(InfcPkgInsr4100VO vo) throws MSFException {
        delete("infcPkgInsr4100DAO.deleteInsr4100_S", vo);
    }

    /**
	 * INSR4100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr4100VO
	 * @return 조회한 INSR4100
	 * @exception Exception
	 */
    public InfcPkgInsr4100VO selectInsr4100(InfcPkgInsr4100VO vo) throws MSFException {
        return (InfcPkgInsr4100VO) selectByPk("infcPkgInsr4100DAO.selectInsr4100_S", vo);
    }

    /**
	 * INSR4100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4100 목록
	 * @exception Exception
	 */
    public List selectInsr4100List(InfcPkgInsr4100SrhVO searchVO) throws MSFException {
        return list("infcPkgInsr4100DAO.selectInsr4100List_D", searchVO);
    }

    /**
	 * INSR4100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4100 총 갯수
	 * @exception
	 */
    public int selectInsr4100ListTotCnt(InfcPkgInsr4100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgInsr4100DAO.selectInsr4100ListTotCnt_S", searchVO);
    }
    
    
}
