package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160404Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye160404_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye160404_2023_DAO.java
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
 * @Class Name : Ye160404_2023_DAO.java
 * @since : 2017. 12. 13. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye160404_2023_DAO")
public class Ye160404_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE160404???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160404_2023_VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160404(Ye160404_2023_VO vo) throws Exception {
        return (String)insert("ye160404_2023_DAO.insertYe160404_S", vo);
    }

    /**
	 * YE160404???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160404_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160404(Ye160404_2023_VO vo) throws Exception {
        update("ye160404_2023_DAO.updateYe160404_S", vo);
    }

    /**
	 * YE160404????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160404_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160404(Ye160404_2023_VO vo) throws Exception {
        delete("ye160404_2023_DAO.deleteYe160404_S", vo);
    }
    
    /**
	 * YE160404????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160404_2023_VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta8100ToYe160404(Ye160404_2023_VO vo) throws Exception {
        delete("ye160404_2023_DAO.deleteYeta1100ToYe160404_S", vo);
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
	 * @Method Name : deleteYetaP310001_Ye160404_2023_VO_2023_Delete
	 * @date : 2019. 1. 8.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 1. 8.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void deleteYetaP810001_Ye160404_2023_VO_2023_Delete(Ye160404_2023_VO vo) throws Exception {
        delete("ye160404_2023_DAO.deleteYetaP810001_Ye160404_2023_VO_2023_Delete_S", vo);
    }
    
    /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/  
    
    
    
    /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/
    /**
	 * YE160404 목록을 조회한다.(종전근무지 팝업)
	 * @param InfcPkgYe160404Srh_2023_VO - 조회할 정보가 담긴 ye160404SrhVo
	 * @return YE160404 목록
	 * @exception Exception
	 */
    public List selectYetaP83001ToYe160404List(Ye160404Srh_2023_VO ye160404SrhVo) throws Exception {
        return list("ye160404_2023_DAO.seleteYetaP83006ToYe160404_D", ye160404SrhVo);
    }

    /**
	 * YE160404 총 갯수를 조회한다.(종전근무지 팝업)
	 * @param InfcPkgYe160404Srh_2023_VO - 조회할 정보가 담긴 ye160404SrhVo
	 * @return YETA3110 총 갯수
	 * @exception
	 */
    @SuppressWarnings("deprecation")
	public int selectYetaP83001ToYe160404ListtTotCnt(Ye160404Srh_2023_VO ye160404SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye160404_2023_DAO.seleteYetaP83006ToYe160404ListCnt_S", ye160404SrhVo);
    }
    
	/**
	 * YE160404 을 등록한다.
	 * @param InfcPkgYe160404_2023_VO - 등록할 정보가 담긴 Ye160404_2023_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP83006ToYe160404(Ye160404_2023_VO vo) throws Exception {
        return (String)insert("ye160404_2023_DAO.insertYetaP83006ToYe160404_S", vo);
    }
    
	/**
	 * YE160404 을 수정한다.
	 * @param InfcPkgYe160404_2023_VO - 수정할 정보가 담긴 Ye160404_2023_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP83006ToYe160404(Ye160404_2023_VO vo) throws Exception {
        update("ye160404_2023_DAO.updateYetaP83006ToYe160404_S", vo);
    }
    
    public int updateYeta8300ToYe160404(Ye160404_2023_VO vo) throws Exception {
        return update("ye160404_2023_DAO.updateYeta8300ToYe160404_S", vo);
    }
    
    
	/**
	 * YE160404 을 삭제한다.
	 * @param InfcPkgYe160404_2023_VO - 삭제할 정보가 담긴 Ye160404_2023_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP83006ToYe160404(Ye160404_2023_VO vo) throws Exception {
        delete("ye160404_2023_DAO.deleteYetaP83006ToYe160404_S", vo);
    }
   
    /** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/
    
    
    //암호화 패치를 위해 임시로 적용 함 
    public List selectYetaAllList() throws Exception {
        return list("ye160404_2023_DAO.selectYetaAllList_D", null);
    }
    
    public void updateYetaAll(Ye160404_2023_VO vo) throws Exception {
        update("ye160404_2023_DAO.updateYetaAll_S", vo);
    }  
    
    
    
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
    
    
	

}
