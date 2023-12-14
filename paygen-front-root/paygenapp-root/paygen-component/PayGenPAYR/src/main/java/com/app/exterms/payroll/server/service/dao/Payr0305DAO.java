package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0305SrhVO;
import com.app.exterms.payroll.server.vo.Payr0305VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0305DAO.java
 * @Description : Payr0305 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0305DAO")
public class Payr0305DAO extends EgovAbstractDAO {

	/**
	 * PAYR0305을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0305VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0305(Payr0305VO vo) throws Exception {
        return (String)insert("payr0305DAO.insertPayr0305_S", vo);
    }

    /**
	 * PAYR0305을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0305VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0305(Payr0305VO vo) throws Exception {
        update("payr0305DAO.updatePayr0305_S", vo);
    }

    /**
	 * PAYR0305을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0305VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0305(Payr0305VO vo) throws Exception {
        delete("payr0305DAO.deletePayr0305_S", vo);
    }
    /**
     * PAYR0305을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0305VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0305(Payr0305VO vo) throws Exception {
        delete("payr0305DAO.deletePayCalculationPayr0305_S", vo);
    }
    
    
    /**
	 * PAYR0305을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0305VO
	 * @return 조회한 PAYR0305
	 * @exception Exception
	 */
    public Payr0305VO selectPayr0305(Payr0305VO vo) throws Exception {
        return (Payr0305VO) selectByPk("payr0305DAO.selectPayr0305_S", vo);
    }

    /**
	 * PAYR0305 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0305 목록
	 * @exception Exception
	 */
    public List selectPayr0305List(Payr0305SrhVO searchVO) throws Exception {
        return list("payr0305DAO.selectPayr0305List_D", searchVO);
    }
    /** 엑셀 출력 **/
    public List selectPayr0305XlsList(Payr0305SrhVO searchVO) throws Exception {
        return list("payr0305DAO.selectPayr0305XlsList_D", searchVO);
    }

    /**
	 * PAYR0305 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0305 총 갯수
	 * @exception
	 */
    public int selectPayr0305ListTotCnt(Payr0305SrhVO searchVO) {
     
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0305DAO.selectPayr0305ListTotCnt_S", searchVO);
    }

}
