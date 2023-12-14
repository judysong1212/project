package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye166020SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye166020VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye166020DAO.java
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

@Repository("Ye166020DAO")
public class Ye166020DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP210001_Ye166020VO_2017_Delete(Ye166020VO vo) throws Exception {
        delete("ye166020DAO.deleteYetaP210001_Ye166020VO_2017_Delete_S", vo);
    }

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/
	
	
	
	/**
	 * YE166020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye166020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe166020(Ye166020VO vo) throws Exception {
        return (String)insert("ye166020DAO.insertYe166020_S", vo);
    }

    /**
	 * YE166020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe166020(Ye166020VO vo) throws Exception {
        update("ye166020DAO.updateYe166020_S", vo);
    }

    /**
	 * YE166020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye166020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe166020(Ye166020VO vo) throws Exception {
        delete("ye166020DAO.deleteYe166020_S", vo);
    }

    /**
	 * YE166020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye166020VO
	 * @return 조회?�� YE166020
	 * @exception Exception
	 */
    public Ye166020VO selectYe166020(Ye166020VO vo) throws Exception {
        return (Ye166020VO) selectByPk("ye166020DAO.selectYe166020_S", vo);
    }

    /**
	 * YE166020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166020 목록
	 * @exception Exception
	 */
    public List<?> selectYe166020List(Ye166020SrhVO searchVO) throws Exception {
        return list("ye166020DAO.selectYe166020List_D", searchVO);
    }

    /**
	 * YE166020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE166020 �? �??��
	 * @exception
	 */
    public int selectYe166020ListTotCnt(Ye166020SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye166020DAO.selectYe166020ListTotCnt_S", searchVO);
    }

}
