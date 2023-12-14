package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr5200SrhVO;
import com.app.exterms.insurance.server.vo.Insr5200VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr5200DAO.java
 * @Description : Insr5200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr5200DAO")
public class Insr5200DAO extends EgovAbstractDAO {
	
    /**
  	 * INSR5200을 수정한다.
  	 * @param vo - 수정할 정보가 담긴 Insr5200VO
  	 * @return void형
  	 * @exception Exception
  	 */
      public void insr5200MnthUpdate(Insr5200VO vo) throws MSFException {
          update("insr5200DAO.insr5200MnthUpdate", vo);
      }


	/**
	 * INSR5200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr5200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr5200(Insr5200VO vo) throws Exception {
        return (String)insert("insr5200DAO.insertInsr5200_S", vo);
    }

    /**
	 * INSR5200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr5200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr5200(Insr5200VO vo) throws Exception {
        update("insr5200DAO.updateInsr5200_S", vo);
    }

    /**
	 * INSR5200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr5200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr5200(Insr5200VO vo) throws Exception {
        delete("insr5200DAO.deleteInsr5200_S", vo);
    }

    /**
	 * INSR5200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr5200VO
	 * @return 조회한 INSR5200
	 * @exception Exception
	 */
    public Insr5200VO selectInsr5200(Insr5200VO vo) throws Exception {
        return (Insr5200VO) selectByPk("insr5200DAO.selectInsr5200_S", vo);
    }

    /**
	 * INSR5200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5200 목록
	 * @exception Exception
	 */
    public List<?> selectXlsInsr5200List(Insr5200SrhVO searchVO) throws Exception {
        return list("insr5200DAO.selectXlsInsr5200List_D", searchVO);
    }

    /**
	 * INSR5200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5200 총 갯수
	 * @exception
	 */
    public int selectInsr5200ListTotCnt(Insr5200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr5200DAO.selectInsr5200ListTotCnt_S", searchVO);
    }
    
    /**
	 * INSR5200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5200 목록
	 * @exception Exception
	 */
    public List<?> selectInsr5200List(Insr5200SrhVO searchVO) throws Exception {
        return list("insr5200DAO.selectInsr5200List_D", searchVO);
    }

  	/**
  	 * INSR5200 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3200 총 갯수
  	 * @exception
  	 */
  	public int selectInsr5200RegChkCnt(Insr5200VO vo) {
  		return (Integer)getSqlMapClientTemplate().queryForObject("insr5200DAO.selectInsr5200RegChkCnt", vo);
  	}
    
  	/**
  	 * 당월 급여마감여부 체크한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3200 총 갯수
  	 * @exception
  	 */
  	public int selectPayCloseChkCnt(Insr5200VO vo) {
  		return (Integer)getSqlMapClientTemplate().queryForObject("insr5200DAO.selectPayCloseChkCnt", vo);
  	}
}




