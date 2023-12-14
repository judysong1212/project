package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe160406Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe160406_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye160406_2021_DAO.java
 * @since : 2017. 12. 15. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("InfcPkgYe160406_2021_DAO")
public class InfcPkgYe160406_2021_DAO extends EgovAbstractDAO {
	
	

	/**
	 * YE160406???�록?�다.
	 * @param vo - ?�록???�보�??�긴 InfcPkgYe160406VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe160406_2021_DAO.insertYe160406_S", vo);
    }

    /**
	 * YE160406???�정?�다.
	 * @param vo - ?�정???�보�??�긴 InfcPkgYe160406VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        update("infcPkgYe160406_2021_DAO.updateYe160406_S", vo);
    }

    /**
	 * YE160406????��?�다.
	 * @param vo - ??��???�보�??�긴 InfcPkgYe160406VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        delete("infcPkgYe160406_2021_DAO.deleteYe160406_S", vo);
    }
    
    /**
	 * YE160406????��?�다.
	 * @param vo - ??��???�보�??�긴 InfcPkgYe160406VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta4100TOYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        delete("infcPkgYe160406_2021_DAO.deleteYeta1100ToYe160406_S", vo);
    }
    
    /**
	 * YE160406????��?�다.
	 * @param vo - ??��???�보�??�긴 InfcPkgYe160406VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta1100ToYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        delete("infcPkgYe160406_2021_DAO.deleteYeta1100ToYe160406_S", vo);
    }


    /**
	 * YE160406 목록??조회?�다.
	 * @param searchMap - 조회???�보�??�긴 Map
	 * @return YE160406 목록
	 * @exception Exception
	 */
    public List<?> selectYe160406List(InfcPkgYe160406Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe160406_2021_DAO.selectYe160406List_D", searchVO);
    }

    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
    /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/
  
    /**
     * 
     * <pre>
     * 1. 개요 : 종전근무지연금보험료_공적연금
     * 2. 처리내용 : 종전근무지연금보험료_공적연금 삭제 
     * </pre>
     * @Method Name : deleteYetaP610001_InfcPkgYe160406VO_2021_Delete
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
    public void deleteYetaP610001_InfcPkgYe160406VO_2021_Delete(InfcPkgYe160406_2021_VO vo) throws Exception {
        delete("infcPkgYe160406_2021_DAO.deleteYetaP610001_InfcPkgYe160406VO_2021_Delete_S", vo);
    }
	
    /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/
    
    
    /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/

    /** 
     * #############################################
     * 2017년도 연말정산 구현 시작
     * #############################################
     *   **/
	/**
	 * YE160406 을 등록한다.
	 * @param InfcPkgInfcPkgYe160406VO - 등록할 정보가 담긴 InfcPkgYe160406VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP63006ToYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe160406_2021_DAO.insertYetaP63006ToYe160406_S", vo);
    }
    
	/**
	 * YE160406 을 수정한다.
	 * @param InfcPkgInfcPkgYe160406VO - 수정할 정보가 담긴 InfcPkgYe160406VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP63006ToYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        update("infcPkgYe160406_2021_DAO.updateYetaP63006ToYe160406_S", vo);
    }
    
	/**
	 * YE160406 을 삭제한다.
	 * @param InfcPkgInfcPkgYe160406VO - 삭제할 정보가 담긴 InfcPkgYe160406VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP63006ToYe160406(InfcPkgYe160406_2021_VO vo) throws Exception {
        delete("infcPkgYe160406_2021_DAO.deleteYetaP63006ToYe160406_S", vo);
    }
    /** 
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/    
    
    /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
      ***********************************************************************************/
   

	
	
	
	

}
