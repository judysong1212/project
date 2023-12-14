package com.app.smrmf.infc.insurance.server.service.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr4200DAO.java
 * @Description : Insr4200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr4200DAO")
public class InfcPkgInsr4200DAO extends EgovAbstractDAO {

	 
    /**
     * 
     * <pre>
     * 1. 개요 : 국민연금 급여 반영 시처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : updatePayrToInsr4200
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
    public void updatePayrToInsr4200(InfcPkgInsr4200VO vo) throws Exception {
        update("infcPkgInsr4200DAO.updatePayrToInsr4200", vo);
    }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : 급여조정 국민연금 삭제시 처리 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : updatePayCancelInsr4200
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
    public void updatePayCancelInsr4200(InfcPkgInsr4200VO vo) throws Exception {
        update("infcPkgInsr4200DAO.updatePayCancelInsr4200", vo);
    }
        
}
