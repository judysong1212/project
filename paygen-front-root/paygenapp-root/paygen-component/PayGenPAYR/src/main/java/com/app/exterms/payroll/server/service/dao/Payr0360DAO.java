package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.payroll.server.vo.Payr0360SrhVO;
import com.app.exterms.payroll.server.vo.Payr0360VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0360DAO.java
 * @Description : Payr0360 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0360DAO")
public class Payr0360DAO extends EgovAbstractDAO {

	/**
	 * PAYR0360을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0360VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0360(Payr0360VO vo) throws Exception {
        return (String)insert("payr0360DAO.insertPayr0360_S", vo);
    }

    /**
	 * PAYR0360을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0360VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0360(Payr0360VO vo) throws Exception {
        update("payr0360DAO.updatePayr0360_S", vo);
    }

    /**
	 * PAYR0360을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0360VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0360(Payr0360VO vo) throws Exception {
        delete("payr0360DAO.deletePayr0360_S", vo);
    }

    /**
	 * PAYR0360을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0360VO
	 * @return 조회한 PAYR0360
	 * @exception Exception
	 */
    public Payr0360VO selectPayr0360(Payr0360VO vo) throws Exception {
        return (Payr0360VO) selectByPk("payr0360DAO.selectPayr0360_S", vo);
    }

    /**
	 * PAYR0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0360 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0360List(Payr0360SrhVO searchVO) throws Exception {
        return list("payr0360DAO.selectPayr0360List_D", searchVO);
    }

    /**
	 * PAYR0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0360 총 갯수
	 * @exception
	 */
    public int selectPayr0360ListTotCnt(Payr0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0360DAO.selectPayr0360ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * PAYR0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0360 목록
	 * @exception Exception
	 */
    public List<?> selectPayr0360ReattyStpDsptyNumList(Payr0360SrhVO searchVO) throws Exception {
        return list("payr0360DAO.selectPayr0360ReattyStpDsptyNumList_D", searchVO);
    }

    /**
	 * PAYR0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0360 총 갯수
	 * @exception
	 */
    public int selectPayr0360ReattyStpDsptyNumListTotCnt(Payr0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0360DAO.selectPayr0360ReattyStpDsptyNumListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR4210 WINDOW CONFIG PAYR0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0360 목록
	 * @exception Exception
	 */
    public List<?> selectPayr4210ToPayr0360List(Payr0360SrhVO searchVO) throws Exception {
        return list("payr0360DAO.selectPayr4210ToPayr0360List_D", searchVO);
    }

    /**
	 * PAYR4210 WINDOW CONFIG PAYR0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0360 총 갯수
	 * @exception
	 */
    public int selectPayr4210ToPayr0360ListTotCnt(Payr0360SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0360DAO.selectPayr4210ToPayr0360ListTotCnt_S", searchVO);
    } 
    
    
    

}
