package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;

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

@Repository("InfcPkgPayr0500DAO")
public class InfcPkgPayr0500DAO extends EgovAbstractDAO {

	/**
	 * PAYR0500을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0500VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        return (String)insert("infcPkgPayr0500DAO.insertPayr0500_S", vo);
    }

    /**
	 * PAYR0500을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0500VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0500(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updatePayr0500_S", vo);
    }

    /**
     * 급여인사마스터 정보를 업데이트 한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0500ToPayr4100(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updatePayr0500ToPayr4100_S", vo);
    } 
    
    
    /**
     * 4대보험 수정사항 반영 고용보험 제외여부 업데이트 
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateInsr5100ToPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updateInsr5100ToPayr0500_S", vo);
    } 
    
    /**
     * 4대보험 수정사항 반영 고용보험 제외여부 업데이트 엑셀 
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateXlsInsr5100ToPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updateXlsInsr5100ToPayr0500_S", vo);
    } 
    
    
    /**
     * 급여인사마스터 정보를 업데이트 한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0500ToPayr0530(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updatePayr0500ToPayr0530_S", vo);
    } 
    
    /**
     * 4대보험-건강보험 정보 업데이트 PAYR0500을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateInsr4100ToPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updateInsr4100ToPayr0500_S", vo);
    } 
    
    /**
     * 4대보험-건강보험 정보 업데이트 PAYR0500을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateXlsInsr4100ToPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updateXlsInsr4100ToPayr0500_S", vo);
    } 
    
    /**
	 * PAYR0500을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0500VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0500(InfcPkgPayr0500VO vo) throws Exception {
        delete("infcPkgPayr0500DAO.deletePayr0500_S", vo);
    }

    /**
	 * PAYR0500을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0500VO
	 * @return 조회한 PAYR0500
	 * @exception Exception
	 */
    public InfcPkgPayr0500VO selectPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        return (InfcPkgPayr0500VO) selectByPk("infcPkgPayr0500DAO.selectPayr0500_S", vo);
    }
    
    /**
     * PAYR0500을 조회한다.
     * @param vo - 조회할 정보가 담긴 Payr0500VO
     * @return 조회한 PAYR0500
     * @exception Exception
     */
    public InfcPkgPayr0500VO selectPayr0500ToPayr0530(InfcPkgPayr0500VO vo) throws Exception {
        return (InfcPkgPayr0500VO) selectByPk("infcPkgPayr0500DAO.selectPayr0500ToPayr0530_S", vo);
    }

    /**
	 * PAYR0500 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0500 목록
	 * @exception Exception
	 */
    public List selectPayr0500List(InfcPkgPayr0500SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0500DAO.selectPayr0500List_D", searchVO);
    }

    /**
	 * PAYR0500 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0500 총 갯수
	 * @exception
	 */
    public int selectPayr0500ListTotCnt(InfcPkgPayr0500SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0500DAO.selectPayr0500ListTotCnt_S", searchVO);
    }
    
    //인사.급여기본정보를 가져온다.
    public List selectPsnlPayrInfoList(InfcPkgPayr0250VO searchVO) throws Exception {
        return list("infcPkgPayr0500DAO.selectPsnlPayrInfoList_D", searchVO);
    }
    /**
	  * Payr0500VO을 수정한다.
	  * @param vo - 수정할 정보가 담긴 Payr0500VO
	  * @return void형
	  * @exception Exception
	  */

    @Transactional
    public void updatePayr0500TotAddIncmTx(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updatePayr0500TotAddIncmTx_S", vo);
    } 
    
    /**
     * 4대보험-국민연금 정보 업데이트 PAYR0500을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0500VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateXlsInsr3100ToPayr0500(InfcPkgPayr0500VO vo) throws Exception {
        update("infcPkgPayr0500DAO.updateXlsInsr3100ToPayr0500_S", vo);
    } 
}
