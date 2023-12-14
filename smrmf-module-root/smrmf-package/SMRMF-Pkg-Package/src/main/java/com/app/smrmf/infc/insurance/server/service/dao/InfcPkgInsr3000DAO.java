package com.app.smrmf.infc.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3000DAO.java
 * @Description : Insr3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr3000DAO")
public class InfcPkgInsr3000DAO extends EgovAbstractDAO {

	/**
	 * INSR3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr3000(InfcPkgInsr3000VO vo) throws Exception {
        return (String)insert("infcPkgInsr3000DAO.insertInsr3000_S", vo);
    }
    
	/**
	 * INSR3000을 등록한다.(누락데이터 생성)
	 * @param vo - 등록할 정보가 담긴 Insr3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr3000_NOT_EXISTS(InfcPkgInsr3000VO vo) throws Exception {
        return (String)insert("infcPkgInsr3000DAO.insertInsr3000_NOT_EXISTS", vo);
    }

    /**
	 * INSR3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr3000(InfcPkgInsr3000VO vo) throws Exception {
        update("infcPkgInsr3000DAO.updateInsr3000_S", vo);
    }

    /**
	 * INSR3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr3000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr3000(InfcPkgInsr3000VO vo) throws Exception {
        delete("infcPkgInsr3000DAO.deleteInsr3000_S", vo);
    }

    /**
	 * INSR3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3000VO
	 * @return 조회한 INSR3000
	 * @exception Exception
	 */
    public InfcPkgInsr3000VO selectInsr3000(InfcPkgInsr3000VO vo) throws Exception {
        return (InfcPkgInsr3000VO) selectByPk("infcPkgInsr3000DAO.selectInsr3000_S", vo);
    }

    /**
	 * INSR3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List<?> selectInsr3000List(InfcPkgInsr3000SrhVO searchVO) throws Exception {
        return list("infcPkgInsr3000DAO.selectInsr3000List_D", searchVO);
    }

    /**
	 * INSR3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 총 갯수
	 * @exception
	 */
    public int selectInsr3000ListTotCnt(InfcPkgInsr3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgInsr3000DAO.selectInsr3000ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * INSR3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 총 갯수
	 * @exception
	 */
    public int selectInsr3000Cnt(InfcPkgInsr3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgInsr3000DAO.selectInsr3000ListTotCnt", searchVO);
    }
    
     
       

}
