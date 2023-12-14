package com.app.smrmf.pkg.proc.dlgn.manage.commute.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;

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

@Repository("ManageCommuteDAO")
public class ManageCommuteDAO extends EgovAbstractDAO {
 
    
    /**
     * DLGN0100 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return DLGN0100 목록
     * @exception Exception
     */
    public List selectInfcDlgn0110TotList(InfcPkgDlgn0100SrhVO searchVO) throws Exception {
        return  list("manageCommuteDAO.selectInfcDlgn0110TotList_D", searchVO);  
    }
    
    
    /**
     * DLGN0100 수정한다.
     * @param vo - 수정할 정보가 담긴DLGN0100VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateManageCommuteInfcDlgn0100(InfcPkgDlgn0100VO vo) throws Exception {
        update("manageCommuteDAO.updateManageCommuteInfcDlgn0100_S", vo);
    }

    
    /**
     * DLGN0200 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return DLGN0100 목록
     * @exception Exception
     */
    public List selectInfcDlgn0210TotList(InfcPkgDlgn0200SrhVO searchVO) throws Exception {
        return  list("manageCommuteDAO.selectInfcDlgn0210TotList_D", searchVO);  
    }
    
    
    /**
     * DLGN0200 수정한다.
     * @param vo - 수정할 정보가 담긴 DLGN0200VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updateManageCommuteInfcDlgn0200(InfcPkgDlgn0200VO vo) throws Exception {
        update("manageCommuteDAO.updateManageCommuteInfcDlgn0200_S", vo);
    }


/**
     * DLGN0100 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return DLGN0100 목록
     * @exception Exception
     */
    public List selectInfcDlgn0110HHMiTotList(InfcPkgDlgn0100SrhVO searchVO) throws Exception {
        return  list("manageCommuteDAO.selectInfcDlgn0110HHMiTotList_D", searchVO);  
    }
     
    
    /**
     * DLGN0200 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return DLGN0100 목록
     * @exception Exception
     */
    public List selectInfcDlgn0210HHMiTotList(InfcPkgDlgn0200SrhVO searchVO) throws Exception {
        return  list("manageCommuteDAO.selectInfcDlgn0210HHMiTotList_D", searchVO);  
    }

    
        
}
