package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0400SrhVO;
import com.app.exterms.payroll.server.vo.Payr0400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0400DAO.java
 * @Description : Payr0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0400DAO")
public class Payr0400DAO extends EgovAbstractDAO {

	/**
	 * PAYR0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0400(Payr0400VO vo) throws Exception {
        return (String)insert("payr0400DAO.insertPayr0400_S", vo);
    }

    /**
	 * PAYR0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0400VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0400(Payr0400VO vo) throws Exception {
        update("payr0400DAO.updatePayr0400_S", vo);
    }

    /**
	 * PAYR0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0400VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0400(Payr0400VO vo) throws Exception {
        delete("payr0400DAO.deletePayr0400_S", vo);
    }

    /**
     * PAYR0400을 삭제FALG 처리 
     * @param vo - 삭제할 정보가 담긴 Payr0400VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayr0400Flag(Payr0400VO vo) throws Exception {
        update("payr0400DAO.deletePayr0400Flag_S", vo);
    } 
    
    /**
	 * PAYR0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0400VO
	 * @return 조회한 PAYR0400
	 * @exception Exception
	 */
    public Payr0400VO selectPayr0400(Payr0400VO vo) throws Exception {
        return (Payr0400VO) selectByPk("payr0400DAO.selectPayr0400_S", vo);
    }

    /**
	 * PAYR0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0400 목록
	 * @exception Exception
	 */
    public List selectPayr0400List(Payr0400SrhVO searchVO) throws Exception {
        return list("payr0400DAO.selectPayr0400List_D", searchVO);
    }

    /**
	 * PAYR0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0400 총 갯수
	 * @exception
	 */
    public int selectPayr0400ListTotCnt(Payr0400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0400DAO.selectPayr0400ListTotCnt_S", searchVO);
    }
    
    /**
 	 * PAYR0400 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR0400 총 갯수
 	 * @exception
 	 */
     public int selectPayr0400CheckCnt(Payr0400VO payr0400Vo) {
         return (Integer)getSqlMapClientTemplate().queryForObject("payr0400DAO.selectPayr0400CheckCnt_S", payr0400Vo);
     }
    
    

}
