package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0480SrhVO;
import com.app.exterms.payroll.server.vo.Payr0480VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0480DAO.java
 * @Description : Payr0480 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0480DAO")
public class Payr0480DAO extends EgovAbstractDAO {

	/**
	 * PAYR0480을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0480VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0480(Payr0480VO vo) throws Exception {
        return (String)insert("payr0480DAO.insertPayr0480_S", vo);
    }

    /**
	 * PAYR0480을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0480VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0480(Payr0480VO vo) throws Exception {
        update("payr0480DAO.updatePayr0480_S", vo);
    }

    /**
	 * PAYR0480을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0480VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0480(Payr0480VO vo) throws Exception {
        delete("payr0480DAO.deletePayr0480_S", vo);
    }

    /**
	 * PAYR0480을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0480VO
	 * @return 조회한 PAYR0480
	 * @exception Exception
	 */
    public Payr0480VO selectPayr0480(Payr0480VO vo) throws Exception {
        return (Payr0480VO) selectByPk("payr0480DAO.selectPayr0480_S", vo);
    }

    /**
	 * PAYR0480 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0480 목록
	 * @exception Exception
	 */
    public List  selectPayr0480List(Payr0480SrhVO searchVO) throws Exception {
        return (List)list("payr0480DAO.selectPayr0480List_D", searchVO);
    }

    /**
	 * PAYR0480 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0480 총 갯수
	 * @exception
	 */
    public int selectPayr0480ListTotCnt(Payr0480SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0480DAO.selectPayr0480ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0480 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0480 목록
   	 * @exception Exception
   	 */
       public List selectPayr0480ToPayr4450List(Payr0480SrhVO searchVO) throws Exception {
           return  (List)list("payr0480DAO.selectPayr0480ToPayr4450List_D", searchVO);
       }

       /**
   	 * PAYR0480 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0480 총 갯수
   	 * @exception
   	 */
       public int selectPayr0480ToPayr4450ListTotCnt(Payr0480SrhVO searchVO) {
               
           return  (Integer)getSqlMapClientTemplate().queryForObject("payr0480DAO.selectPayr0480ToPayr4450ListTotCnt_S", searchVO);
       }
       

    
    
}
