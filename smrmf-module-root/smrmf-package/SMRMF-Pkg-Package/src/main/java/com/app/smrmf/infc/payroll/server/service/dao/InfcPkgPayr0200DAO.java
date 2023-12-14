package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0200SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0200DAO.java
 * @Description : Payr0200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0200DAO")
public class InfcPkgPayr0200DAO extends EgovAbstractDAO {

	/**
	 * PAYR0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0200(InfcPkgPayr0200VO vo) throws Exception {
        return (String)insert("infcPkgPayr0200DAO.insertPayr0200_S", vo);
    }

    /**
	 * PAYR0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0200VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0200(InfcPkgPayr0200VO vo) throws Exception {
        update("infcPkgPayr0200DAO.updatePayr0200_S", vo);
    }

    /**
	 * PAYR0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0200VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0200(InfcPkgPayr0200VO vo) throws Exception {
        delete("infcPkgPayr0200DAO.deletePayr0200_S", vo);
    }

    /**
	 * PAYR0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0200VO
	 * @return 조회한 PAYR0200
	 * @exception Exception
	 */
    public InfcPkgPayr0200VO selectPayr0200(InfcPkgPayr0200VO vo) throws Exception {
        return (InfcPkgPayr0200VO) selectByPk("infcPkgPayr0200DAO.selectPayr0200_S", vo);
    }

    /**
	 * PAYR0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0200 목록
	 * @exception Exception
	 */
    public List selectPayr0200List(InfcPkgPayr0200SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0200DAO.selectPayr0200List_D", searchVO);
    }

    /**
	 * PAYR0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0200 총 갯수
	 * @exception
	 */
    public int selectPayr0200ListTotCnt(InfcPkgPayr0200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0200DAO.selectPayr0200ListTotCnt_S", searchVO);
    }
    
    /**
	 * PAYR0200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0200 목록
	 * @exception Exception
	 */
    public List selectPayr0200ToPayr3200List(InfcPkgPayr0200SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0200DAO.selectPayr0200ToPayr3200List_D", searchVO);
    }

    /**
	 * PAYR0200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0200 총 갯수
	 * @exception
	 */
    public int selectPayr0200ToPayr3200ListTotCnt(InfcPkgPayr0200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0200DAO.selectPayr0200ToPayr3200ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0200 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0200 목록
   	 * @exception Exception
   	 */
       public List selectPayr0200ToPayr4100List(InfcPkgPayr0200SrhVO searchVO) throws Exception {
           return list("infcPkgPayr0200DAO.selectPayr0200ToPayr4100List_D", searchVO);
       }

       /**
   	 * PAYR0200 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0200 총 갯수
   	 * @exception
   	 */
       public int selectPayr0200ToPayr4100ListTotCnt(InfcPkgPayr0200SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0200DAO.selectPayr0200ToPayr4100ListTotCnt_S", searchVO);
       }
     
       
       /**
   	 * PAYR0200 급여 계산에서 호출시 사용하는 메서드 
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0200 목록
   	 * @exception Exception
   	 */
       public List selectPayr0200ToPayrCalcList(InfcPkgPayr0200SrhVO searchVO) throws Exception {
           return list("infcPkgPayr0200DAO.selectPayr0200ToPayrCalcList_D", searchVO);
       }
       
       
    
}
