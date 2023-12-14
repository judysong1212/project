package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe160404SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe160404VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160404DAO.java
 * @Description : Ye160404 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

/**
 * @Class Name : Ye160404DAO.java
 * @since : 2017. 12. 13. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */          
@Repository("InfcPkgYe160404DAO")
public class InfcPkgYe160404DAO extends EgovAbstractDAO {

	/**
	 * YE160404???�록?�다.
	 * @param vo - ?�록???�보�??�긴 InfcPkgYe160404VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160404(InfcPkgYe160404VO vo) throws Exception {
        return (String)insert("infcPkgYe160404DAO.insertYe160404_S", vo);
    }

    /**
	 * YE160404???�정?�다.
	 * @param vo - ?�정???�보�??�긴 InfcPkgYe160404VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160404(InfcPkgYe160404VO vo) throws Exception {
        update("infcPkgYe160404DAO.updateYe160404_S", vo);
    }

    /**
	 * YE160404????��?�다.
	 * @param vo - ??��???�보�??�긴 InfcPkgYe160404VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160404(InfcPkgYe160404VO vo) throws Exception {
        delete("infcPkgYe160404DAO.deleteYe160404_S", vo);
    }
    
    /**
	 * YE160404????��?�다.
	 * @param vo - ??��???�보�??�긴 InfcPkgYe160404VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta2100ToYe160404(InfcPkgYe160404VO vo) throws Exception {
        delete("infcPkgYe160404DAO.deleteYeta1100ToYe160404_S", vo);
    }

    
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
    /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/   
    
	/**
	 * 
	 * <pre>
	 * 1. 개요 : D_종전근무처
	 * 2. 처리내용 : D_종전근무처 삭제 
	 * </pre>
	 * @Method Name : deleteYetaP210001_InfcPkgYe160404VO_2017_Delete
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
	public void deleteYetaP210001_InfcPkgYe160404VO_2017_Delete(InfcPkgYe160404VO vo) throws Exception {
        delete("infcPkgYe160404DAO.deleteYetaP210001_InfcPkgYe160404VO_2017_Delete_S", vo);
    }
    
    /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/  
    
    
    
    /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/
    /**
	 * YE160404 목록을 조회한다.(종전근무지 팝업)
	 * @param InfcPkgInfcPkgYe160404SrhVO - 조회할 정보가 담긴 ye160404SrhVo
	 * @return YE160404 목록
	 * @exception Exception
	 */
    public List selectYetaP23001ToYe160404List(InfcPkgYe160404SrhVO ye160404SrhVo) throws Exception {
        return list("infcPkgYe160404DAO.seleteYetaP23006ToYe160404_D", ye160404SrhVo);
    }

    /**
	 * YE160404 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param InfcPkgInfcPkgYe160404SrhVO - 조회할 정보가 담긴 ye160404SrhVo
	 * @return YETA3110 총 갯수
	 * @exception
	 */
    @SuppressWarnings("deprecation")
	public int selectYetaP23001ToYe160404ListtTotCnt(InfcPkgYe160404SrhVO ye160404SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe160404DAO.seleteYetaP23006ToYe160404ListCnt_S", ye160404SrhVo);
    }
    
	/**
	 * YE160404 을 등록한다.
	 * @param InfcPkgInfcPkgYe160404VO - 등록할 정보가 담긴 InfcPkgYe160404VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP23006ToYe160404(InfcPkgYe160404VO vo) throws Exception {
        return (String)insert("infcPkgYe160404DAO.insertYetaP23006ToYe160404_S", vo);
    }
    
	/**
	 * YE160404 을 수정한다.
	 * @param InfcPkgInfcPkgYe160404VO - 수정할 정보가 담긴 InfcPkgYe160404VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP23006ToYe160404(InfcPkgYe160404VO vo) throws Exception {
        update("infcPkgYe160404DAO.updateYetaP23006ToYe160404_S", vo);
    }
    
	/**
	 * YE160404 을 삭제한다.
	 * @param InfcPkgInfcPkgYe160404VO - 삭제할 정보가 담긴 InfcPkgYe160404VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP23006ToYe160404(InfcPkgYe160404VO vo) throws Exception {
        delete("infcPkgYe160404DAO.deleteYetaP23006ToYe160404_S", vo);
    }
   
    /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/
    
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
    
    
	

}
