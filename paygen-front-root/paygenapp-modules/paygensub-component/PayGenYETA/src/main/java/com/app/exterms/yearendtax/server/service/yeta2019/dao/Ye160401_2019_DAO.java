package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160401_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160401_2019_DAO.java
 * @Description : Ye160401 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye160401_2019_DAO")
public class Ye160401_2019_DAO extends EgovAbstractDAO {

	/**
	 * YE160401???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160401_2019_VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160401(Ye160401_2019_VO vo) throws Exception {
        return (String)insert("ye160401_2019_DAO.insertYe160401_S", vo);
    }

    /**
	 * YE160401???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160401_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160401(Ye160401_2019_VO vo) throws Exception {
        update("ye160401_2019_DAO.updateYe160401_S", vo);
    }

    /**
	 * YE160401????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160401_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160401(Ye160401_2019_VO vo) throws Exception {
        delete("ye160401_2019_DAO.deleteYe160401_S", vo);
    }
    
    
    /**
	 * YE160401????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160401_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta4100ToYe160401(Ye160401_2019_VO vo) throws Exception {
        delete("ye160401_2019_DAO.deleteYeta1100ToYe160401_S", vo);
    }
    
    
    
    
    public void deleteYetaP110001_Ye160401_2016_CREATE_Delete(Ye160401_2019_VO vo) throws Exception {
        delete("Ye16Ta160401_2019_DAO.deleteYeta1100ToYe160401_S", vo);
    }
    
    /**
	 * YE160401????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160401_2019_VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta4100_Ye160401_CREATE_Delete(Ye160401_2019_VO vo) throws Exception {
        delete("ye160401_2019_DAO.fnYeta1100_Ye160401_CREATE_Delete", vo);
    }
    
  /***********************************************************************************
   * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
   ***********************************************************************************/
    
    /**
     * 
     * <pre>
     * 1. 개요 :현근무지급여지급명세 삭제 
     * 2. 처리내용 : 현근무지급여지급명세 삭제 
     * </pre>
     * @Method Name : deleteYetaP410001_Ye160401_2019_VO_2018_Delete
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
    public void deleteYetaP410001_Ye160401_2019_VO_2019_Delete(Ye160401_2019_VO vo) throws Exception {
        delete("ye160401_2019_DAO.deleteYetaP410001_Ye160401_2019_VO_2019_Delete_S", vo);
    }
    
    
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
}
