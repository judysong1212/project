package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye165020Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye165020VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165020_2018_DAO.java
 * @Description : Ye165020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye165020_2018_DAO")
public class Ye165020_2018_DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
 
    public void deleteYetaP310001_Ye165020VO_2018_Delete(Ye165020VO vo) throws Exception {
        delete("ye165020_2018_DAO.deleteYetaP310001_Ye165020VO_2018_Delete_S", vo);
    }
    
	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/	
	
	
	
	/**
	 * YE165020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165020(Ye165020VO vo) throws Exception {
        return (String)insert("ye165020_2018_DAO.insertYe165020_S", vo);
    }

    /**
	 * YE165020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165020(Ye165020VO vo) throws Exception {
        update("ye165020_2018_DAO.updateYe165020_S", vo);
    }

    /**
	 * YE165020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165020(Ye165020VO vo) throws Exception {
        delete("ye165020_2018_DAO.deleteYe165020_S", vo);
    }

    /**
	 * YE165020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165020VO
	 * @return 조회?�� YE165020
	 * @exception Exception
	 */
    public Ye165020VO selectYe165020(Ye165020VO vo) throws Exception {
        return (Ye165020VO) selectByPk("ye165020_2018_DAO.selectYe165020_S", vo);
    }

    /**
	 * YE165020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165020 목록
	 * @exception Exception
	 */
    public List<?> selectYe165020List(Ye165020Srh_2018_VO searchVO) throws Exception {
        return list("ye165020_2018_DAO.selectYe165020List_D", searchVO);
    }

    /**
	 * YE165020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165020 �? �??��
	 * @exception
	 */
    public int selectYe165020ListTotCnt(Ye165020Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye165020_2018_DAO.selectYe165020ListTotCnt_S", searchVO);
    }

}