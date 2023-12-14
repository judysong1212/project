package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167530_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167530_2023_DAO.java
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

@Repository("InfcPkgYe167530_2023_DAO")
public class InfcPkgYe167530_2023_DAO extends EgovAbstractDAO {

	
    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : insertYe167530
     * @date : 2023. 1. 2.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2023. 1. 2.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */ 	
    public String insertYe167530(InfcPkgYe167530_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe167530_2023_DAO.insertYe167530_S", vo);
    }

    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : deleteYe167530
     * @date : 2023. 1. 2.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2023. 1. 2.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */ 	
    public void deleteYe167530(InfcPkgYe167530_2023_VO vo) throws Exception {
        delete("infcPkgYe167530_2023_DAO.deleteYe167530_S", vo);
    }

}
