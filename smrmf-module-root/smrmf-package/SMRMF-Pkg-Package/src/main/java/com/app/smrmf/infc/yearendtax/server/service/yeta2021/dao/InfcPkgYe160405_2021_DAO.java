package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe160405_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : InfcPkgYe160405_2021_DAO.java
 * @Description : InfcPkgYe160405 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe160405_2021_DAO")
public class InfcPkgYe160405_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE160405???�록?�다.
	 * @param vo - ?�록???�보�??�긴 InfcPkgYe160405VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertInfcPkgYe160405(InfcPkgYe160405_2021_VO vo) throws Exception {
        return (String)insert("infcPkgInfcPkgYe160405_2021_DAO.insertInfcPkgYe160405_S", vo);
    }

    /**
	 * YE160405???�정?�다.
	 * @param vo - ?�정???�보�??�긴 InfcPkgYe160405VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateInfcPkgYe160405(InfcPkgYe160405_2021_VO vo) throws Exception {
        update("infcPkgInfcPkgYe160405_2021_DAO.updateInfcPkgYe160405_S", vo);
    }

    /**
	 * YE160405????��?�다.
	 * @param vo - ??��???�보�??�긴 InfcPkgYe160405VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteInfcPkgYe160405(InfcPkgYe160405_2021_VO vo) throws Exception {
        delete("infcPkgInfcPkgYe160405_2021_DAO.deleteInfcPkgYe160405_S", vo);
    }


/***********************************************************************************
 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
 ***********************************************************************************/
       
    /**
     * 
     * <pre>
     * 1. 개요 :  D_종전근무처비과세_감면소득_비과세  
     * 2. 처리내용 : D_종전근무처비과세_감면소득_비과세  삭제 
     * </pre>
     * @Method Name : deleteYetaP610001_InfcPkgYe160405VO_2021_Delete
     * @date : 2021. 1. 8.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2021. 1. 8.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void deleteYetaP610001_InfcPkgYe160405VO_2021_Delete(InfcPkgYe160405_2021_VO vo) throws Exception {
        delete("infcPkgInfcPkgYe160405_2021_DAO.deleteYetaP610001_InfcPkgYe160405VO_2021_Delete_S", vo);
    }
    
/***********************************************************************************
 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
 ***********************************************************************************/
    

}
