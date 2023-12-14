package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0300SrhVO;
import com.app.exterms.payroll.server.vo.Payr0300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0300DAO.java
 * @Description : Payr0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0300DAO")
public class Payr0300DAO extends EgovAbstractDAO {

	/**
	 * PAYR0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0300(Payr0300VO vo) throws Exception {
        return (String)insert("payr0300DAO.insertPayr0300_S", vo);
    }

    /**
	 * PAYR0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0300VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0300(Payr0300VO vo) throws Exception {
        update("payr0300DAO.updatePayr0300_S", vo);
    }

    /**
	 * PAYR0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0300VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0300(Payr0300VO vo) throws Exception {
        delete("payr0300DAO.deletePayr0300_S", vo);
    }
    
    /**
     * PAYR0300을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0300VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0300(Payr0300VO vo) throws Exception {
        delete("payr0300DAO.deletePayCalculationPayr0300_S", vo);
    }
 
    
    /**
	 * PAYR0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0300VO
	 * @return 조회한 PAYR0300
	 * @exception Exception
	 */
    public Payr0300VO selectPayr0300(Payr0300VO vo) throws Exception {
        return (Payr0300VO) selectByPk("payr0300DAO.selectPayr0300_S", vo);
    }

    /**
	 * PAYR0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0300 목록
	 * @exception Exception
	 */
    public List selectPayr0300List(Payr0300SrhVO searchVO) throws Exception {
        return list("payr0300DAO.selectPayr0300List_D", searchVO);
    }

    /**
	 * PAYR0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0300 총 갯수
	 * @exception
	 */
    public int selectPayr0300ListTotCnt(Payr0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0300DAO.selectPayr0300ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0300 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0300 목록
   	 * @exception Exception
   	 */
       public List selectPayr0300PayYrList(Payr0300SrhVO searchVO) throws Exception {
           return list("payr0300DAO.selectPayr0300PayYrList_D", searchVO);
       }

       /**
   	 * PAYR0300 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0300 총 갯수
   	 * @exception
   	 */
       public int selectPayr0300PayYrListTotCnt(Payr0300SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("payr0300DAO.selectPayr0300PayYrListTotCnt_S", searchVO);
       }
       
 
}
