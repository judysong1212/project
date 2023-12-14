package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0250VO;
import com.app.exterms.payroll.server.vo.Payr0500SrhVO;
import com.app.exterms.payroll.server.vo.Payr0500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0500DAO.java
 * @Description : Payr0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0500DAO")
public class Payr0500DAO extends EgovAbstractDAO {

	/**
	 * PAYR0500을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0500VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0500(Payr0500VO vo) throws Exception {
        return (String)insert("payr0500DAO.insertPayr0500_S", vo);
    }

    /**
	 * PAYR0500을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0500VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0500(Payr0500VO vo) throws Exception {
        update("payr0500DAO.updatePayr0500_S", vo);
    }

    /**
     * 급여인사마스터 정보를 업데이트 한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0500ToPayr4100(Payr0500VO vo) throws Exception {
        update("payr0500DAO.updatePayr0500ToPayr4100_S", vo);
    } 
    
    
    /**
     * 급여인사마스터 정보를 업데이트 한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0500ToPayr0530(Payr0500VO vo) throws Exception {
        update("payr0500DAO.updatePayr0500ToPayr0530_S", vo);
    } 
    
    /**
     * 급여인사마스터 소득세율 정보를 업데이트 한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0500ToPayrP410004(Payr0500VO vo) throws Exception {
        update("payr0500DAO.updatePayr0500ToPayrP410004_S", vo);
    } 
    
    
    
    /**
	 * PAYR0500을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0500VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0500(Payr0500VO vo) throws Exception {
        delete("payr0500DAO.deletePayr0500_S", vo);
    }

    /**
	 * PAYR0500을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0500VO
	 * @return 조회한 PAYR0500
	 * @exception Exception
	 */
    public Payr0500VO selectPayr0500(Payr0500VO vo) throws Exception {
        return (Payr0500VO) selectByPk("payr0500DAO.selectPayr0500_S", vo);
    }
    
    /**
     * PAYR0500을 조회한다.
     * @param vo - 조회할 정보가 담긴 Payr0500VO
     * @return 조회한 PAYR0500
     * @exception Exception
     */
    public Payr0500VO selectPayr0500ToPayr0530(Payr0500VO vo) throws Exception {
        return (Payr0500VO) selectByPk("payr0500DAO.selectPayr0500ToPayr0530_S", vo);
    }

    /**
	 * PAYR0500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0500 목록
	 * @exception Exception
	 */
    public List selectPayr0500List(Payr0500SrhVO searchVO) throws Exception {
        return list("payr0500DAO.selectPayr0500List_D", searchVO);
    }

    /**
	 * PAYR0500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0500 총 갯수
	 * @exception
	 */
    public int selectPayr0500ListTotCnt(Payr0500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0500DAO.selectPayr0500ListTotCnt_S", searchVO);
    }
    
    //인사.급여기본정보를 가져온다.
    public List selectPsnlPayrInfoList(Payr0250VO searchVO) throws Exception {
        return list("payr0500DAO.selectPsnlPayrInfoList_D", searchVO);
    }
    

    /**
	 * PAYR0500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0500 목록
	 * @exception Exception
	 */
    public List selectPayrP410004ToPayr0500List(Payr0500SrhVO searchVO) throws Exception {
        return list("payr0500DAO.selectPayrP410004ToPayr0500List_D", searchVO);
    }

    /**
	 * PAYR0500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0500 총 갯수
	 * @exception
	 */
    public int selectPayrP410004ToPayr0500ListTotCnt(Payr0500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0500DAO.selectPayrP410004ToPayr0500ListTotCnt_S", searchVO);
    }
    

}
