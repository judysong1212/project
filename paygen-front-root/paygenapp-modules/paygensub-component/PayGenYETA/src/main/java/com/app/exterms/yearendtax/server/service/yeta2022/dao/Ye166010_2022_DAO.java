package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye166010Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye166010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166010_2022_DAO.java
 * @Description : Ye166010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye166010_2022_DAO")
public class Ye166010_2022_DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/       
	  public void deleteYetaP710001_Ye166010VO_2022_Delete(Ye166010VO vo) throws Exception {
	        delete("ye166010_2022_DAO.deleteYetaP710001_Ye166010VO_2022_Delete_S", vo);
	    }
	  
	  
	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/
	
	
	
	
	
	
	
	
	/**
	 * YE166010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166010(Ye166010VO vo) throws Exception {
        return (String)insert("ye166010_2022_DAO.insertYe166010_S", vo);
    }

    /**
	 * YE166010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166010(Ye166010VO vo) throws Exception {
        update("ye166010_2022_DAO.updateYe166010_S", vo);
    }

    /**
	 * YE166010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166010(Ye166010VO vo) throws Exception {
        delete("ye166010_2022_DAO.deleteYe166010_S", vo);
    }

    /**
	 * YE166010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166010VO
	 * @return 조회?�� YE166010
	 * @exception Exception
	 */
    public Ye166010VO selectYe166010(Ye166010VO vo) throws Exception {
        return (Ye166010VO) selectByPk("ye166010_2022_DAO.selectYe166010_S", vo);
    }

    /**
	 * YE166010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166010 목록
	 * @exception Exception
	 */
    public List<?> selectYe166010List(Ye166010Srh_2022_VO searchVO) throws Exception {
        return list("ye166010_2022_DAO.selectYe166010List_D", searchVO);
    }

    /**
	 * YE166010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166010 �? �??��
	 * @exception
	 */
    public int selectYe166010ListTotCnt(Ye166010Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye166010_2022_DAO.selectYe166010ListTotCnt_S", searchVO);
    }

}
