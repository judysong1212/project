package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0300SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400VO;

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

@Repository("InfcPkgPayr0400DAO")
public class InfcPkgPayr0400DAO extends EgovAbstractDAO {

	/**
	 * PAYR0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0400(InfcPkgPayr0400VO vo) throws Exception {
        return (String)insert("infcPkgPayr0400DAO.insertPayr0400_S", vo);
    }
    
	/**
	 * PAYR0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertInfcPayr0400(InfcPkgPayr0400VO vo) throws Exception {
        return (String)insert("infcPkgPayr0400DAO.insertInfcPayr0400_S", vo);
    }

    /**
	 * PAYR0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0400VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0400(InfcPkgPayr0400VO vo) throws Exception {
        update("infcPkgPayr0400DAO.updatePayr0400_S", vo);
    }

    /**
	 * PAYR0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0400VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0400(InfcPkgPayr0400VO vo) throws Exception {
        delete("infcPkgPayr0400DAO.deletePayr0400_S", vo);
    }

    /**
	 * PAYR0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0400VO
	 * @return 조회한 PAYR0400
	 * @exception Exception
	 */
    public InfcPkgPayr0400VO selectPayr0400(InfcPkgPayr0400VO vo) throws Exception {
        return (InfcPkgPayr0400VO) selectByPk("infcPkgPayr0400DAO.selectPayr0400_S", vo);
    }

    /**
	 * PAYR0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0400 목록
	 * @exception Exception
	 */
    public List selectPayr0400List(InfcPkgPayr0400SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0400DAO.selectPayr0400List_D", searchVO);
    }
    
    /**
	 * PAYR0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0400 목록
	 * @exception Exception
	 */
    public List getTypOccuGrdeMppgSeilNum(InfcPkgPayr0400SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0400DAO.getTYP_OCCU_GRDE_MPPG_SEIL_NUM", searchVO);
    }

    /**
	 * PAYR0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0400 총 갯수
	 * @exception
	 */
    public int selectPayr0400ListTotCnt(InfcPkgPayr0400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0400DAO.selectPayr0400ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0400 총 갯수
	 * @exception
	 */
    public int selectPayr0400MappingListTotCnt(InfcPkgPayr0400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0400DAO.selectPayr0400TypOccuCdMappingListTotCnt_S", searchVO);
    }
    
    

    
    /**
     * 근속년수 리스트 정보를 가지고 온다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Bass0300 목록
     * @exception Exception
     */
    public List selectBass0300List(InfcPkgBass0300SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0400DAO.selectBass0300List_D", searchVO);
    }

    
}
