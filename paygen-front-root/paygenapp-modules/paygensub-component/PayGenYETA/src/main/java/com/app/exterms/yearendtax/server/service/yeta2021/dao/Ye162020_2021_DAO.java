package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye162020Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye162020_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162020_2021_DAO.java
 * @Description : Ye162020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 20178.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye162020_2021_DAO")
public class Ye162020_2021_DAO extends EgovAbstractDAO {
	
	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	
	
	
	/** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    
	
	public void deleteYetaP610001_Ye162020_2021_VO_2021_Delete(Ye162020_2021_VO vo) throws Exception {
        delete("ye162020_2021_DAO.deleteYetaP610001_Ye162020_2021_VO_2021_Delete_S", vo);
    }
    
    
    
	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/

	
	
	
	
	

	/**
	 * YE162020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162020_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162020(Ye162020_2021_VO vo) throws Exception {
        return (String)insert("ye162020_2021_DAO.insertYe162020_S", vo);
    }

    /**
	 * YE162020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162020_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162020(Ye162020_2021_VO vo) throws Exception {
        update("ye162020_2021_DAO.updateYe162020_S", vo);
    }

    /**
	 * YE162020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162020_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162020(Ye162020_2021_VO vo) throws Exception {
        delete("ye162020_2021_DAO.deleteYe162020_S", vo);
    }

    /**
	 * YE162020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162020_2021_VO
	 * @return 조회?�� YE162020
	 * @exception Exception
	 */
    public Ye162020_2021_VO selectYe162020(Ye162020_2021_VO vo) throws Exception {
        return (Ye162020_2021_VO) selectByPk("ye162020_2021_DAO.selectYe162020_S", vo);
    }

    /**
	 * YE162020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162020 목록
	 * @exception Exception
	 */
    public List<?> selectYe162020List(Ye162020Srh_2021_VO search_2021_VO) throws Exception {
        return list("ye162020_2021_DAO.selectYe162020List_D", search_2021_VO);
    }

    /**
	 * YE162020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162020 �? �??��
	 * @exception
	 */
    public int selectYe162020ListTotCnt(Ye162020Srh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162020_2021_DAO.selectYe162020ListTotCnt_S", search_2021_VO);
    }

}
