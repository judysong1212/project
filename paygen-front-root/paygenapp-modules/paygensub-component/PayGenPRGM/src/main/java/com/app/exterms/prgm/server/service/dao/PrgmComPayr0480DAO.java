package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.prgm.server.vo.PrgmComPayr0480SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComPayr0480VO;
//import com.googlecode.ehcache.annotations.Cacheable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0480DAO.java
 * @Description : Payr0480 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.09.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComPayr0480DAO")
public class PrgmComPayr0480DAO extends EgovAbstractDAO {

	/**
	 * PAYR0480을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0480VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0480(PrgmComPayr0480VO vo) throws Exception {
        return (String)insert("prgmComPayr0480DAO.insertPayr0480_S", vo);
    }

    /**
	 * PAYR0480을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0480VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0480(PrgmComPayr0480VO vo) throws Exception {
        update("prgmComPayr0480DAO.updatePayr0480_S", vo);
    }

    /**
	 * PAYR0480을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0480VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0480(PrgmComPayr0480VO vo) throws Exception {
        delete("prgmComPayr0480DAO.deletePayr0480_S", vo);
    }

    /**
	 * PAYR0480을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0480VO
	 * @return 조회한 PAYR0480
	 * @exception Exception
	 */
    public PrgmComPayr0480VO selectPayr0480(PrgmComPayr0480VO vo) throws Exception {
        return (PrgmComPayr0480VO) selectByPk("prgmComPayr0480DAO.selectPayr0480_S", vo);
    }

    /**
	 * PAYR0480 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0480 목록
	 * @exception Exception
	 */
   
    public List selectComp0500ToPayr0480List(PrgmComPayr0480SrhVO searchVO) throws Exception {
        return list("prgmComPayr0480DAO.selectComp0500ToPayr0480List_D", searchVO);
    }

    /**
	 * PAYR0480 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0480 총 갯수
	 * @exception
	 */
     
    public int selectComp0500ToPayr0480ListTotCnt(PrgmComPayr0480SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPayr0480DAO.selectComp0500ToPayr0480ListTotCnt_S", searchVO);
    }

    /**
  	 * PAYR0480 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0480 목록
  	 * @exception Exception
  	 */
     
      public List selectPrgmComPayr0480List(PrgmComPayr0480SrhVO searchVO) throws Exception {
          return list("prgmComPayr0480DAO.selectPrgmComPayr0480List_D", searchVO);
      }

      /**
  	 * PAYR0480 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0480 총 갯수
  	 * @exception
  	 */
       
      public int selectPrgmComPayr0480ListTotCnt(PrgmComPayr0480SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("prgmComPayr0480DAO.selectPrgmComPayr0480ListTotCnt_S", searchVO);
      }
    
    
}
