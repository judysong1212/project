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

@Repository("PrgmComPsnl0100DAO")
public class PrgmComPsnl0100DAO extends EgovAbstractDAO {

	/**
	 * PSNL0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        return (String)insert("prgmComPsnl0100DAO.insertPsnl0100_S", vo);
    }

    /**
	 * PSNL0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        update("prgmComPsnl0100DAO.updatePsnl0100_S", vo);
    }

    /**
	 * PSNL0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        delete("prgmComPsnl0100DAO.deletePsnl0100_S", vo);
    }

    /**
	 * PSNL0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0100VO
	 * @return 조회한 PSNL0100
	 * @exception Exception
	 */
    public PrgmComPsnl0100VO selectPsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        return (PrgmComPsnl0100VO) selectByPk("prgmComPsnl0100DAO.selectPsnl0100_S", vo);
    }

    /**
	 * PSNL0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    public List selectPsnl0100List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComPsnl0100DAO.selectPsnl0100List_D", searchVO);
    }

    /**
	 * PSNL0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 총 갯수
	 * @exception
	 */
    public int selectPsnl0100ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0100DAO.selectPsnl0100ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 퇴직정산대상자 선택 PSNL0100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0100 목록
   	 * @exception Exception
   	 */
       public List selectRemtPsnl0100List(PrgmComSearchVO searchVO) throws Exception {
           return list("prgmComPsnl0100DAO.selectRemtPsnl0100List_D", searchVO);
       }

       /**
   	 * 퇴직정산 대상자 선택 PSNL0100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0100 총 갯수
   	 * @exception
   	 */
       public int selectRemtPsnl0100ListTotCnt(PrgmComSearchVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0100DAO.selectRemtPsnl0100ListTotCnt_S", searchVO);
       }
       
       /**
      	 * 사회보험대상자 선택 PSNL0100 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PSNL0100 목록
      	 * @exception Exception
      	 */
          public List selectInsrPsnl0100List(PrgmComSearchVO searchVO) throws Exception {
              return list("prgmComPsnl0100DAO.selectInsrPsnl0100List_D", searchVO);
          }

          /**
      	 * 사회보험 대상자 선택 PSNL0100 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PSNL0100 총 갯수
      	 * @exception
      	 */
          public int selectInsrPsnl0100ListTotCnt(PrgmComSearchVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0100DAO.selectInsrPsnl0100ListTotCnt_S", searchVO);
          }
       
    
    /**
	 * PSNL0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    public List selectPsnl0100ToPayr1700List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComPsnl0100DAO.selectPsnl0100ToPayr1700List_D", searchVO);
    }

    /**
	 * PSNL0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 총 갯수
	 * @exception
	 */
    public int selectPsnl0100ToPayr1700ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0100DAO.selectPsnl0100ToPayr1700ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PSNL0100 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0100 목록
   	 * @exception Exception
   	 */
       public List selectPsnl0100ToPayr4100List(PrgmComSearchVO searchVO) throws Exception {
           return list("prgmComPsnl0100DAO.selectPsnl0100ToPayr4100List_D", searchVO);
       }

       /**
   	 * PSNL0100 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0100 총 갯수
   	 * @exception
   	 */
       public int selectPsnl0100ToPayr4100ListTotCnt(PrgmComSearchVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0100DAO.selectPsnl0100ToPayr4100ListTotCnt_S", searchVO);
       }
    
       /**
      	 * PSNL0126 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PSNL0100 목록
      	 * @exception Exception
      	 */
          public List selectPsnl0100ToPsnl0126List(PrgmComSearchVO searchVO) throws Exception {
              return list("prgmComPsnl0100DAO.selectPsnl0100ToPsnl0126List_D", searchVO);
          }

          /**
      	 * PSNL0126 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PSNL0100 총 갯수
      	 * @exception
      	 */
          public int selectPsnl0100ToPsnl0126ListTotCnt(PrgmComSearchVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPsnl0100DAO.selectPsnl0100ToPsnl0126ListTotCnt_S", searchVO);
          }
       


}
