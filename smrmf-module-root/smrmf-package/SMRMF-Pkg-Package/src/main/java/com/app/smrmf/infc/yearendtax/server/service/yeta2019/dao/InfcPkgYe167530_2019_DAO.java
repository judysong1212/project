package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe167530_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167530_2019_DAO.java
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

@Repository("InfcPkgYe167530_2019_DAO")
public class InfcPkgYe167530_2019_DAO extends EgovAbstractDAO {

	
    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : insertYe167530
     * @date : 2019. 1. 2.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 1. 2.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */ 	
    public String insertYe167530(InfcPkgYe167530_2019_VO vo) throws Exception {
        return (String)insert("infcPkgYe167530_2019_DAO.insertYe167530_S", vo);
    }

    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : deleteYe167530
     * @date : 2019. 1. 2.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 1. 2.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */ 	
    public void deleteYe167530(InfcPkgYe167530_2019_VO vo) throws Exception {
        delete("infcPkgYe167530_2019_DAO.deleteYe167530_S", vo);
    }

}
