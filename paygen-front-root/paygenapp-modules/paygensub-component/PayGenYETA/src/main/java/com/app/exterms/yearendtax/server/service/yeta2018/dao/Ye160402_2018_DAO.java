package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160402VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160402_2018_DAO.java
 * @Description : Ye160402 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye160402_2018_DAO")
public class Ye160402_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE160402???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160402VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160402(Ye160402VO vo) throws Exception {
        return (String)insert("ye160402_2018_DAO.insertYe160402_S", vo);
    }

    /**
	 * YE160402???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160402(Ye160402VO vo) throws Exception {
        update("ye160402_2018_DAO.updateYe160402_S", vo);
    }

    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160402(Ye160402VO vo) throws Exception {
        delete("ye160402_2018_DAO.deleteYe160402_S", vo);
    }
    public void deleteYetaP110001_Ye160402_2016_CREATE_Delete(Ye160402VO vo) throws Exception {
        delete("ye16Ta160402_2018_DAO.fnYeta1100_YE160402_2016_CREATE_Delete_S", vo);
    }
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeYeta3100To160402(Ye160402VO vo) throws Exception {
        delete("ye160402_2018_DAO.deleteYeta3100ToYe160402_S", vo);
    }
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta3100_Ye160402_CREATE_Delete(Ye160402VO vo) throws Exception {
        delete("ye160402_2018_DAO.fnYeta3100_Ye160402_CREATE_Delete", vo);
    }
    
	
	
	
	/***********************************************************************************
	   * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	   ***********************************************************************************/
	   
    
    /**
     * 
     * <pre>
     * 1. 개요 : 현근무지비과세_감면소득_과세 
     * 2. 처리내용 : 현근무지비과세_감면소득_과세 삭제 
     * </pre>
     * @Method Name : deleteYetaP310001_Ye160402VO_2018_Delete
     * @date : 2018. 1. 8.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 8.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void deleteYetaP310001_Ye160402VO_2018_Delete(Ye160402VO vo) throws Exception {
        delete("ye160402_2018_DAO.deleteYetaP310001_Ye160402VO_2018_Delete_S", vo);
    }
 
	
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
	
     

}
