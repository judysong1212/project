package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye166020Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye166020_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166020_2018_DAO.java
 * @Description : Ye166020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye166020_2021_DAO")
public class Ye166020_2021_DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP610001_Ye166020_2021_VO_2018_Delete(Ye166020_2021_VO vo) throws Exception {
        delete("ye166020_2018_DAO.deleteYetaP610001_Ye166020_2021_VO_2018_Delete_S", vo);
    }

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/
	
	
	
	/**
	 * YE166020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166020_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166020(Ye166020_2021_VO vo) throws Exception {
        return (String)insert("ye166020_2018_DAO.insertYe166020_S", vo);
    }

    /**
	 * YE166020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166020_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166020(Ye166020_2021_VO vo) throws Exception {
        update("ye166020_2018_DAO.updateYe166020_S", vo);
    }

    /**
	 * YE166020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166020_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166020(Ye166020_2021_VO vo) throws Exception {
        delete("ye166020_2018_DAO.deleteYe166020_S", vo);
    }

    /**
	 * YE166020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166020_2021_VO
	 * @return 조회?�� YE166020
	 * @exception Exception
	 */
    public Ye166020_2021_VO selectYe166020(Ye166020_2021_VO vo) throws Exception {
        return (Ye166020_2021_VO) selectByPk("ye166020_2018_DAO.selectYe166020_S", vo);
    }

    /**
	 * YE166020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166020 목록
	 * @exception Exception
	 */
    public List<?> selectYe166020List(Ye166020Srh_2021_VO search_2021_VO) throws Exception {
        return list("ye166020_2018_DAO.selectYe166020List_D", search_2021_VO);
    }

    /**
	 * YE166020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166020 �? �??��
	 * @exception
	 */
    public int selectYe166020ListTotCnt(Ye166020Srh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye166020_2018_DAO.selectYe166020ListTotCnt_S", search_2021_VO);
    }

}
