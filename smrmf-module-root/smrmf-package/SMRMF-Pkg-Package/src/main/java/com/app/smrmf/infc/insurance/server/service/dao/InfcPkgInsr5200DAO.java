package com.app.smrmf.infc.insurance.server.service.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr5200DAO.java
 * @Description : Insr5200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr5200DAO")
public class InfcPkgInsr5200DAO extends EgovAbstractDAO {
	

    /**
     * 
     * <pre>
     * 1. 개요 : 고용보험 급여 반영 시처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : updatePayrToInsr5200
     * @date : 2017. 4. 11.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 11.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void updatePayrToInsr5200(InfcPkgInsr5200VO vo) throws Exception {
        update("infcPkgInsr5200DAO.updatePayrToInsr5200", vo);
    }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : 급여조정 고용보험 삭제시 처리 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : updatePayCancelInsr5200
     * @date : 2017. 4. 11.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 11.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void updatePayCancelInsr5200(InfcPkgInsr5200VO vo) throws Exception {
        update("infcPkgInsr5200DAO.updatePayCancelInsr5200", vo);
    }
         


}


