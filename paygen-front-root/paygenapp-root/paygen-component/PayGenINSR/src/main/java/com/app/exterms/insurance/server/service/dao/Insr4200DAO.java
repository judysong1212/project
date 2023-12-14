package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr4200SrhVO;
import com.app.exterms.insurance.server.vo.Insr4200VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr4200DAO.java
 * @Description : Insr4200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr4200DAO")
public class Insr4200DAO extends EgovAbstractDAO {

	/**
	 * INSR4200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr4200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr4200(Insr4200VO vo) throws Exception {
        return (String)insert("insr4200DAO.insertInsr4200_S", vo);
    }

    /**
	 * INSR4200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr4200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr4200(Insr4200VO vo) throws Exception {
        update("insr4200DAO.updateInsr4200_S", vo);
    }

    /**
	 * INSR4200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr4200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr4200(Insr4200VO vo) throws Exception {
        delete("insr4200DAO.deleteInsr4200_S", vo);
    }

    /**
	 * INSR4200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr4200VO
	 * @return 조회한 INSR4200
	 * @exception Exception
	 */
    public Insr4200VO selectInsr4200(Insr4200VO vo) throws Exception {
        return (Insr4200VO) selectByPk("insr4200DAO.selectInsr4200_S", vo);
    }

    /**
	 * INSR4200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4200 목록
	 * @exception Exception
	 */
    public List<?> selectInsr4200List(Insr4200SrhVO searchVO) throws Exception {
        return list("insr4200DAO.selectInsr4200List_D", searchVO);
    }

    /**
	 * INSR4200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4200 총 갯수
	 * @exception
	 */
    public int selectInsr4200ListTotCnt(Insr4200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr4200DAO.selectInsr3150ToInsr4200ListTotCnt_S", searchVO);
    }
    
    /**
   	 *  insr3150 - 조건에 맞는 INSR4200 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4200 총 갯수
   	 * @exception
   	 */
    public int selectInsr315ToInsr4200ListTotCnt(Insr4200SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("insr4200DAO.selectInsr3150ToInsr4200ListTotCnt_S", searchVO);
    }
    
    /**
   	 * insr3150 - 조건에 맞는 INSR4200 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4200 목록
   	 * @exception Exception
   	 */
    public List<?> selectInsr3150ToInsr4200List(Insr4200SrhVO searchVO) throws Exception {
    	return list("insr4200DAO.selectInsr3150ToInsr4200List_D", searchVO);
	}
    
    /**
   	 * insr3150 - 조건에 맞는 INSR4200 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4200 목록
   	 * @exception Exception
   	 */
    public List<?> selectXlsInsr3150ToInsr4200List(Insr4200SrhVO searchVO) throws Exception {
    	return list("insr4200DAO.selectXlsInsr3150ToInsr4200List_D", searchVO);
	}
    
    
    

    /**************************** 엑셀 업로드 ****************************/
    /**
	 * INSR4200을 삭제한다.(엑셀)
	 * @param vo - 삭제할 정보가 담긴 Insr4200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteXlsInsr3150ToInsr4200(Insr4200VO vo) throws Exception {
        delete("insr4200DAO.deleteXlsInsr4200_S", vo);
    }
    
	/**
	 * INSR4200을 등록한다.(엑셀)
	 * @param vo - 등록할 정보가 담긴 Insr4200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertXlsInsr3150ToInsr4200(Insr4200VO vo) throws Exception {
        return (String)insert("insr4200DAO.insertXlsInsr4200_S", vo);
    }
	/**************************** 엑셀 업로드 ****************************/
    
    /**
  	 * INSR4200을 수정한다.
  	 * @param vo - 수정할 정보가 담긴 Insr4100VO
  	 * @return void형
  	 * @exception Exception
  	 */
      public void insr3150MnthUpdate(Insr4200VO vo) throws MSFException {
          update("insr4200DAO.insr3150MnthUpdate_S", vo);
      }
      
  	/**
  	 * INSR3200 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3200 총 갯수
  	 * @exception
  	 */
  	public int selectInsr4200RegChkCnt(Insr4200VO vo) {
  		return (Integer)getSqlMapClientTemplate().queryForObject("insr4200DAO.selectInsr4200RegChkCnt", vo);
  	}
      
  	
  	/**
  	 * 당월 급여마감여부 체크한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3200 총 갯수
  	 * @exception
  	 */
  	public int selectPayCloseChkCnt(Insr4200VO vo) {
  		return (Integer)getSqlMapClientTemplate().queryForObject("insr4200DAO.selectPayCloseChkCnt", vo);
  	}
  	
}
