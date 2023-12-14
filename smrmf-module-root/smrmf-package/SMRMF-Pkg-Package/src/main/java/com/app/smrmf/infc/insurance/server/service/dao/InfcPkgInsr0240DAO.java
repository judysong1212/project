package com.app.smrmf.infc.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrAmntVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3000DAO.java
 * @Description : Insr3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgInsr0240DAO")
public class InfcPkgInsr0240DAO extends EgovAbstractDAO {

    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : select4InsureDataList
     * @date : 2016. 12. 24.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 24.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List  select4InsureDataList(InfcPkgPayr0250VO searchVO) throws Exception {
        return  list("infcPkgInsr0240DAO.select4InsureDataList_D", searchVO);
    }
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : 금액으로 업로드된 4대보험 처리를 위한 작업 ..위한 루틴 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : select4InsureDataAmnt
     * @date : 2017. 4. 6.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 6.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public PkgInsrAmntVO  select4InsureDataAmnt(InfcPkgPayr0250VO searchVO) throws Exception {
    	   return (PkgInsrAmntVO) selectByPk("infcPkgInsr0240DAO.select4InsureDataAmnt_D", searchVO);
    }  

}
