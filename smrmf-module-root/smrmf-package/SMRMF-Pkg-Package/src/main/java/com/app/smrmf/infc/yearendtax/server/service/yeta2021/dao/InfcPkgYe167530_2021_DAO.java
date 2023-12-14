package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167530_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167530_2021_DAO.java
 * @Description : Ye167530 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 3017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167530_2021_DAO")
public class InfcPkgYe167530_2021_DAO extends EgovAbstractDAO {

	
    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : insertYe167530
     * @date : 2021. 1. 2.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2021. 1. 2.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */ 	
    public String insertYe167530(InfcPkgYe167530_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe167530_2021_DAO.insertYe167530_S", vo);
    }

    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : deleteYe167530
     * @date : 2021. 1. 2.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2021. 1. 2.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */ 	
    public void deleteYe167530(InfcPkgYe167530_2021_VO vo) throws Exception {
        delete("infcPkgYe167530_2021_DAO.deleteYe167530_S", vo);
    }

}
