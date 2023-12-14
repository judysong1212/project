package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;

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

@Repository("InfcPkgPayr0300DAO")
public class InfcPkgPayr0300DAO extends EgovAbstractDAO {

	/**
	 * PAYR0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0300(InfcPkgPayr0300VO vo) throws Exception {
        return (String)insert("infcPkgPayr0300DAO.insertPayr0300_S", vo);
    }

    /**
	 * PAYR0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0300VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0300(InfcPkgPayr0300VO vo) throws Exception {
        update("infcPkgPayr0300DAO.updatePayr0300_S", vo);
    }

    /**
	 * PAYR0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0300VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0300(InfcPkgPayr0300VO vo) throws Exception {
        delete("infcPkgPayr0300DAO.deletePayr0300_S", vo);
    }
    
    /**
     * PAYR0300을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0300VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0300(InfcPkgPayr0300VO vo) throws Exception {
        delete("infcPkgPayr0300DAO.deletePayCalculationPayr0300_S", vo);
    }
 
    
    /**
	 * PAYR0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0300VO
	 * @return 조회한 PAYR0300
	 * @exception Exception
	 */
    public InfcPkgPayr0300VO selectPayr0300(InfcPkgPayr0300VO vo) throws Exception {
        return (InfcPkgPayr0300VO) selectByPk("infcPkgPayr0300DAO.selectPayr0300_S", vo);
    }

    /**
	 * PAYR0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0300 목록
	 * @exception Exception
	 */
    public List selectPayr0300List(InfcPkgPayr0300SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0300DAO.selectPayr0300List_D", searchVO);
    }

    /**
	 * PAYR0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0300 총 갯수
	 * @exception
	 */
    public int selectPayr0300ListTotCnt(InfcPkgPayr0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0300DAO.selectPayr0300ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0300 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0300 목록
   	 * @exception Exception
   	 */
       public List selectPayr0300PayYrList(InfcPkgPayr0300SrhVO searchVO) throws Exception {
           return list("infcPkgPayr0300DAO.selectPayr0300PayYrList_D", searchVO);
       }

       /**
   	 * PAYR0300 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0300 총 갯수
   	 * @exception
   	 */
       public int selectPayr0300PayYrListTotCnt(InfcPkgPayr0300SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0300DAO.selectPayr0300PayYrListTotCnt_S", searchVO);
       }
       
 
}