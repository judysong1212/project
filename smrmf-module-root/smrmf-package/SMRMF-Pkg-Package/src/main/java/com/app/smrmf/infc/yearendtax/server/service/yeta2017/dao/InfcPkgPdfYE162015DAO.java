package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : InfcPkgPdfYE162015DAO
 * @Description : InfcPkgPdfYE162015 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfYE162015DAO")
public class InfcPkgPdfYE162015DAO extends EgovAbstractDAO {

    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : insertPdfYE162015
     * @date : 2017. 12. 21.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 12. 21.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */ 	
    public String insertPdfYE162015(InfcPkgPdfYE162015VO vo) throws Exception {
        return (String)insert("InfcPkgPdfYE162015DAO.insertPdfYE162015_S", vo);
    }

    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : deletePdfYE162015
     * @date : 2017. 12. 21.
     * @author : USER
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 12. 21.		USER				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */ 	
    public void deletePdfYE162015(InfcPkgPdfYE162015VO vo) throws Exception {
        delete("InfcPkgPdfYE162015DAO.deletePdfYE162015_S", vo);
    }

}