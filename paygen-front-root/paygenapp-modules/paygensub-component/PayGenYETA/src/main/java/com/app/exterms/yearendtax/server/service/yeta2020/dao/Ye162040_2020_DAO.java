package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye162040Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye162040_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162040_2020_DAO.java
 * @Description : Ye162040 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye162040_2020_DAO")
public class Ye162040_2020_DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP510001_Ye162040_2020_VO_2020_Delete(Ye162040_2020_VO vo) throws Exception {
        delete("ye162040_2020_DAO.deleteYetaP510001_Ye162040_2020_VO_2020_Delete_S", vo);
    }

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/	
	
	
	
	
	/**
	 * YE162040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162040_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162040(Ye162040_2020_VO vo) throws Exception {
        return (String)insert("ye162040_2020_DAO.insertYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162040(Ye162040_2020_VO vo) throws Exception {
        update("ye162040_2020_DAO.updateYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162040(Ye162040_2020_VO vo) throws Exception {
        delete("ye162040_2020_DAO.deleteYe162040_S", vo);
    }

    /**
	 * YE162040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162040_2020_VO
	 * @return 조회?�� YE162040
	 * @exception Exception
	 */
    public Ye162040_2020_VO selectYe162040(Ye162040_2020_VO vo) throws Exception {
        return (Ye162040_2020_VO) selectByPk("ye162040_2020_DAO.selectYe162040_S", vo);
    }

    /**
	 * YE162040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 목록
	 * @exception Exception
	 */
    public List<?> selectYe162040List(Ye162040Srh_2020_VO search_2020_VO) throws Exception {
        return list("ye162040_2020_DAO.selectYe162040List_D", search_2020_VO);
    }

    /**
	 * YE162040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 �? �??��
	 * @exception
	 */
    public int selectYe162040ListTotCnt(Ye162040Srh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162040_2020_DAO.selectYe162040ListTotCnt_S", search_2020_VO);
    }

}
