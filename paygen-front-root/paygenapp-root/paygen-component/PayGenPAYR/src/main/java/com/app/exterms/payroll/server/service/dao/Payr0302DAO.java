package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0302SrhVO;
import com.app.exterms.payroll.server.vo.Payr0302VO;

import com.app.exterms.payroll.server.vo.Payr0307SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0302DAO.java
 * @Description : Payr0302 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0302DAO")
public class Payr0302DAO extends EgovAbstractDAO {

	/**
	 * PAYR0302을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0302VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0302(Payr0302VO vo) throws Exception {
        return (String)insert("payr0302DAO.insertPayr0302_S", vo);
    }

    /**
	 * PAYR0302을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0302VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0302(Payr0302VO vo) throws Exception {
        update("payr0302DAO.updatePayr0302_S", vo);
    }
    @Transactional
    public void updatePayr0302Payr0307(Payr0302VO vo) throws Exception {
        update("payr0302DAO.updatePayr0302Payr0307_S", vo);
    }
    
    /**
	 * PAYR0302을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0302VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0302(Payr0302VO vo) throws Exception {
        delete("payr0302DAO.deletePayr0302_S", vo);
    }
    @Transactional
    public void deletePayr0302Payr0307(Payr0302VO vo) throws Exception {
        delete("payr0302DAO.deletePayr0302Payr0307_S", vo);
    }
    @Transactional
    public void deletePayr0302ToPayr0307T(Payr0302VO vo) throws Exception {
        delete("payr0302DAO.deletePayr0302ToPayr0307T_S", vo);
    }
     
    
    /**
     * PAYR0302을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0302VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0302(Payr0302VO vo) throws Exception {
        delete("payr0302DAO.deletePayCalculationPayr0302_S", vo);
    }
    
    
    public List selectExtpyPayr0302List(Payr0302SrhVO   payr0302SrhVO) throws Exception {
        return list("payr0302DAO.selectExtpyPayr0302List_D", payr0302SrhVO); 
    }
    
    public List selectDducPayr0302List(Payr0302SrhVO   payr0302SrhVO) throws Exception {
        return list("payr0302DAO.selectDducPayr0302List_D", payr0302SrhVO); 
    }
    
    
    /**
	 * PAYR0302을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0302VO
	 * @return 조회한 PAYR0302
	 * @exception Exception
	 */
    public Payr0302VO selectPayr0302(Payr0302VO vo) throws Exception {
        return (Payr0302VO) selectByPk("payr0302DAO.selectPayr0302_S", vo);
    }

    public Payr0302VO selectPayr0302Payr0307(Payr0302VO vo) throws Exception {
        return (Payr0302VO) selectByPk("payr0302DAO.selectPayr0302Payr0307_S", vo);
    }
    
    public Payr0302VO selectPayr0302Payr0307_2(Payr0302VO vo) throws Exception {
        return (Payr0302VO) selectByPk("payr0302DAO.selectPayr0302Payr0307_S2", vo);
    }
    
    public List selectPayr0302ToPayr301CalcList(Payr0302VO vo) throws Exception {
        return list("payr0302DAO.selectPayr0302ToPayr301CalcList_D", vo); 
    }
     
    /**
	 * PAYR0302 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 목록
	 * @exception Exception
	 */
    public List selectPayr0302List(Payr0302SrhVO searchVO) throws Exception {
        return list("payr0302DAO.selectPayr0302List_D", searchVO);
    }

    /**
	 * PAYR0302 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 총 갯수
	 * @exception
	 */
    public int selectPayr0302ListTotCnt(Payr0302SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0302DAO.selectPayr0302ListTotCnt_S", searchVO);
    }
	
    /**
	 * PAYR0302 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 목록
	 * @exception Exception
	 */
    public List selectPayr0302ExtpyList(Payr0302SrhVO searchVO) throws Exception {
        return list("payr0302DAO.selectPayr0302ExtpyList_D", searchVO);
    }
    

    /**
	 * PAYR0302 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0302 총 갯수
	 * @exception
	 */
    public int selectPayr0302ExtpyListTotCnt(Payr0302SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0302DAO.selectPayr0302ExtpyListTotCnt_S", searchVO);
    }
    
    
  
    
    
    /**
 	 * PAYR0302 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0302 목록
 	 * @exception Exception
 	 */
     public List selectPayr0302DducList(Payr0302SrhVO searchVO) throws Exception {
         return list("payr0302DAO.selectPayr0302DducList_D", searchVO);
     }

     /**
 	 * PAYR0302 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0302 총 갯수
 	 * @exception
 	 */
     public int selectPayr0302DducListTotCnt(Payr0302SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("payr0302DAO.selectPayr0302DducListTotCnt_S", searchVO);
     }


}
