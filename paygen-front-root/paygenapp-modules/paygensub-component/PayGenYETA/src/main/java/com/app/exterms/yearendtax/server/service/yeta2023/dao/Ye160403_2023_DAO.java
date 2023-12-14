package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160403Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye160403_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye160403_2023_DAO.java
 * @since : 2019. 1. 7. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye160403_2023_DAO")
public class Ye160403_2023_DAO extends EgovAbstractDAO {
	
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * Ye160403 목록을 조회한다.
	 * @param Ye160403Srh_2023_VO - 조회할 정보가 담긴 Ye160403SrhVo
	 * @return Ye160403 목록
	 * @exception Exception
	 */
	public List selectYetaP83008ToYe160403List(Ye160403Srh_2023_VO Ye160403SrhVo)throws Exception {
		return list("ye160403_2023_DAO.seleteYetaP83008ToYe160403_D", Ye160403SrhVo);
	}
	/**
	 * Ye160403 을 수정한다.
	 * @param Ye160403_2023_VO - 수정할 정보가 담긴 Ye160403_2023_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP83008ToYe160403(Ye160403_2023_VO vo) throws Exception {
        update("ye160403_2023_DAO.updateYetaP83008ToYe160403_S", vo);
    }
    
	/**
	 * Ye160403 을 삭제한다.
	 * @param Ye160403_2023_VO - 삭제할 정보가 담긴 Ye160403_2023_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP83008ToYe160403(Ye160403_2023_VO vo) throws Exception {
        delete("ye160403_2023_DAO.deleteYetaP83008ToYe160403_S", vo);
    }	

	/**
	 * YE160403???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160403_2023_VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160403(Ye160403_2023_VO vo) throws Exception {
        return (String)insert("ye160403_2023_DAO.insertYe160403_S", vo);
    }

    /**
	 * YE160403???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160403_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160403(Ye160403_2023_VO vo) throws Exception {
        update("ye160403_2023_DAO.updateYe160403_S", vo);
    }

    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160403(Ye160403_2023_VO vo) throws Exception {
        delete("ye160403_2023_DAO.deleteYe160403_S", vo);
    }
    
    
    public void deleteYetaP110001_Ye160403_2016_CREATE_Delete(Ye160403_2023_VO vo) throws Exception {
        delete("ye16Ta160403_2023_DAO.fnYeta1100_YE160403_2016_CREATE_Delete_S", vo);
    }
    
    
    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta8100ToYe160403(Ye160403_2023_VO vo) throws Exception {
        delete("ye160403_2023_DAO.deleteYeta8100ToYe160403_S", vo);
    }
    
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta8100_Ye160403_CREATE_Delete(Ye160403_2023_VO vo) throws Exception {
        delete("ye160403_2023_DAO.fnYeta8100_Ye160403_CREATE_Delete", vo);
    }
    
 
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
   	
    /**
     *     
     * <pre>
     * 1. 개요 : 현근무지비과세_감면소득_비과세
     * 2. 처리내용 : 현근무지비과세_감면소득_비과세 삭제 
     * </pre>
     * @Method Name : deleteYetaP810001_Ye160403_2023_VO_2023_Delete
     * @date : 2019. 1. 8.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 1. 8.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param  Ye160403_2023_VO vo
     * @throws Exception
     */
    public void deleteYetaP810001_Ye160403_2023_VO_2023_Delete(Ye160403_2023_VO vo) throws Exception {
        delete("ye160403_2023_DAO.deleteYetaP810001_Ye160403_2023_VO_2023_Delete_S", vo);
    }
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
      ***********************************************************************************/
    

}
