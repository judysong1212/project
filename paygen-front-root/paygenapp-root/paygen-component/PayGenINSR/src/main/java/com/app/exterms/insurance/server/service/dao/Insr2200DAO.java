package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.exterms.insurance.server.vo.Insr2200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Insr2200DAO.java
 * @Description : Insr2200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr2200DAO")
public class Insr2200DAO extends EgovAbstractDAO {

	/**
	 * INSR2200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr2200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr2200(Insr2200VO vo) throws Exception {
        return (String)insert("insr2200DAO.insertInsr2200_S", vo);
    }

    /**
	 * INSR2200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2200(Insr2200VO vo) throws Exception {
        update("insr2200DAO.updateInsr2200_S", vo);
    }

    /**
	 * INSR2200을 특정컬럼을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr2200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2200Bnde(Insr2200VO vo) throws Exception {
        update("insr2200DAO.updateInsr2200Bnde_S", vo);
    }
    
    /**
	 * INSR2200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr2200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr2200(Insr2200VO vo) throws Exception {
        delete("insr2200DAO.deleteInsr2200_S", vo);
    }

    /**
	 * INSR2200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr2200VO
	 * @return 조회한 INSR2200
	 * @exception Exception
	 */
    public Insr2200VO selectInsr2200(Insr2200VO vo) throws Exception {
        return (Insr2200VO) selectByPk("insr2200DAO.selectInsr2200_S", vo);
    }

    /**
	 * INSR2200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2200 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2200List(Insr2200SrhVO searchVO) throws Exception {
        return list("insr2200DAO.selectInsr2200List_D", searchVO);
    }

    /**
	 * INSR2200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2200 목록
	 * @exception Exception
	 */
    public List<?> selectInsr2200ToInsr2400List(Insr2200SrhVO searchVO) throws Exception {
        return list("insr2200DAO.selectInsr2200ToInsr2400List_D", searchVO);
    }
    
    /**
	 * INSR2200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2200 총 갯수
	 * @exception
	 */
    public int selectInsr2200ListTotCnt(Insr2200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2200DAO.selectInsr2200ListTotCnt_S", searchVO);
    }
    
    /**
	 * INSR2400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR2400 총 갯수
	 * @exception
	 */
    public int selectInsr2200ToInsr2400ListTotCnt(Insr2200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr2200DAO.selectInsr2200ToInsr2400ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 자격상실 상세보기 조회 INSR2200 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR2200 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsr2100ToInsr2200List(Insr2200SrhVO searchVO) throws Exception {
           return list("insr2200DAO.selectInsr2100ToInsr2200List_D", searchVO);
       }

    /**
   	 *  자격상실 상세보기 조회  INSR2200 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR2200 총 갯수
   	 * @exception
   	 */
       public int selectInsr2100ToInsr2200ListTotCnt(Insr2200SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr2200DAO.selectInsr2100ToInsr2200ListTotCnt_S", searchVO);
       }

       /**
        *  자격취득내역 엑셀저장 처리 루틴 호출 
        * @param searchMap - 조회할 정보가 담긴 Map
        * @return INSR1200 목록
        * @exception Exception
        */
       public List  selectXlsInsr2200List(Insr2200SrhVO searchVO) throws Exception {
    	   return list("insr2200DAO.selectInsr2200ExcelList_D", searchVO);
       }

       /**
        * INSR2200을 조회한다.
        * @param vo - 조회할 정보가 담긴 Insr2200VO
        * @return 조회한 INSR2200
        * @exception Exception
        */
       public EgovMap selectInsr230004ToBass0150(Insr2200SrhVO vo) throws Exception {
    	   return (EgovMap) selectByPk("insr2200DAO.selectInsr230004ToBass0150_S", vo);
       }
       
       /**
        * INSR2200을 조회한다.
        * @param vo - 조회할 정보가 담긴 Insr2200VO
        * @return 조회한 INSR2200
        * @exception Exception
        */
       public EgovMap selectInsr230004ToBass0500(Insr2200SrhVO vo) throws Exception {
    	   return (EgovMap) selectByPk("insr2200DAO.selectInsr230004ToBass0500_S", vo);
       }
    
}
