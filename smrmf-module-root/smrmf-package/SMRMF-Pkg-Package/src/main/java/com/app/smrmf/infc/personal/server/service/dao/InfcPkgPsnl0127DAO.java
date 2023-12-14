package com.app.smrmf.infc.personal.server.service.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0127DAO.java
 * @Description : Psnl0127 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPsnl0127DAO")
public class InfcPkgPsnl0127DAO extends EgovAbstractDAO {
 
    /**
     * 급여대상자관리에 기본정보 수정시 처리 업데이트 
     * @param hMap
     * @throws Exception
     */
    @Transactional
    public int updatePsnl0127ToPayr4100(InfcPkgPsnl0127VO vo) throws Exception {
        return update("infcPkgPsnl0127DAO.updatePsnl0127ToPayr4100_S", vo);
    }

     

    /**
     * PSNL0127을 등록한다.
     * @param vo - 등록할 정보가 담긴 Psnl0127VO
     * @return 등록 결과
     * @exception Exception
     */
    @Transactional
    public String insertPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        return (String)insert("infcPkgPsnl0127DAO.insertPsnl0127_S", vo);
    }

    /**
     * PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updatePsnl0127_S", vo);
    }

    /**
     * 4대보험-국민연금 정보 업데이트 PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateInsr3100ToPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updateInsr3100ToPsnl0127_S", vo);
    }  
    
    /**
     * 4대보험-건강보험 정보 업데이트 PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateInsr4100ToPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updateInsr4100ToPsnl0127_S", vo);
    }  
    
    /**
     * 4대보험-건강보험 정보 업데이트 PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateXlsInsr4100ToPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updateXlsInsr4100ToPsnl0127_S", vo);
    } 
    
    
    /**
     * 4대보험-고용보험 정보 업데이트 PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateInsr5100ToPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updateInsr5100ToPsnl0127_S", vo);
    } 
    
    /**
     * 4대보험-고용보험 정보 업데이트 PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateXlsInsr5100ToPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updateXlsInsr5100ToPsnl0127_S", vo);
    } 
    
    
    
    
    /**
     * PSNL0127을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Psnl0127VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        delete("infcPkgPsnl0127DAO.deletePsnl0127_S", vo);
    }

    /**
     * PSNL0127을 조회한다.
     * @param vo - 조회할 정보가 담긴 Psnl0127VO
     * @return 조회한 PSNL0127
     * @exception Exception
     */
    public InfcPkgPsnl0127VO selectPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        return (InfcPkgPsnl0127VO) selectByPk("infcPkgPsnl0127DAO.selectPsnl0127_S", vo);
    }

    
    /**
     * 4대보험-국민연금 정보 업데이트 PSNL0127을 수정한다.
     * @param vo - 수정할 정보가 담긴 Psnl0127VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateXlsInsr3100ToPsnl0127(InfcPkgPsnl0127VO vo) throws Exception {
        update("infcPkgPsnl0127DAO.updateXlsInsr3100ToPsnl0127", vo);
    } 
    
    

}
