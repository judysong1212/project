package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0530SrhVO;
import com.app.exterms.payroll.server.vo.Payr0530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0530DAO.java
 * @Description : Payr0530 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0530DAO")
public class Payr0530DAO extends EgovAbstractDAO {

	/**
	 * PAYR0530을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0530(Payr0530VO vo) throws Exception {
        return (String)insert("payr0530DAO.insertPayr0530_S", vo);
    }

    /**
	 * PAYR0530을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0530VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0530(Payr0530VO vo) throws Exception {
        update("payr0530DAO.updatePayr0530_S", vo);
    }

    /**
	 * PAYR0530을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0530VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0530(Payr0530VO vo) throws Exception {
        delete("payr0530DAO.deletePayr0530_S", vo);
    }
    

    /**
	 * PAYR0530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0530VO
	 * @return 조회한 PAYR0530
	 * @exception Exception
	 */
    public Payr0530VO selectPayr0530Check(Payr0530VO vo) throws Exception {
        return (Payr0530VO) selectByPk("payr0530DAO.selectPayr0530Check_S", vo);
    }

    /**
	 * PAYR0530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0530VO
	 * @return 조회한 PAYR0530
	 * @exception Exception
	 */
    public Payr0530VO selectPayr0530(Payr0530VO vo) throws Exception {
        return (Payr0530VO) selectByPk("payr0530DAO.selectPayr0530_S", vo);
    }

    /**
	 * PAYR0530 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0530 목록
	 * @exception Exception
	 */
    public List selectPayr0530List(Payr0530SrhVO searchVO) throws Exception {
        return list("payr0530DAO.selectPayr0530List_D", searchVO);
    }

    /**
	 * PAYR0530 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0530 총 갯수
	 * @exception
	 */
    public int selectPayr0530ListTotCnt(Payr0530SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0530DAO.selectPayr0530ListTotCnt_S", searchVO);
         
    }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 :  가족수당 대상자 정보 조회 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : selectPayr0530List
     * @date : 2016. 12. 15.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 15.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List selectPayrP410005ToPayr0530List(Payr0530SrhVO searchVO) throws Exception {
        return list("payr0530DAO.selectPayrP410005ToPayr0530List_D", searchVO);
    }
    
    public List selectXlsPayrP410005ToPayr0530List(Payr0530SrhVO searchVO) throws Exception {
        return list("payr0530DAO.selectXlsPayrP410005ToPayr0530List_D", searchVO);
    }

    
    /**
     * 
     * <pre>
     * 1. 개요 :  가족수당 대상자 정보 조회 개수 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : selectPayr0530ListTotCnt
     * @date : 2016. 12. 15.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 15.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     */
    public int selectPayrP410005ToPayr0530ListTotCnt(Payr0530SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0530DAO.selectPayrP410005ToPayr0530ListTotCnt_S", searchVO);
         
    }
    
    
    

}
