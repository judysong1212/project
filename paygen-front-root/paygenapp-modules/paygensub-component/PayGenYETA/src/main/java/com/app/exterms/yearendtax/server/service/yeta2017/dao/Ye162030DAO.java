package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye162030SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye162030VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162030DAO.java
 * @Description : Ye162030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye162030DAO")
public class Ye162030DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP210001_Ye162030VO_2017_Delete(Ye162030VO vo) throws Exception {
        delete("ye162030DAO.deleteYetaP210001_Ye162030VO_2017_Delete_S", vo);
    }
	  

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/	
	
	
	
	
	
	/**
	 * YE162030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162030(Ye162030VO vo) throws Exception {
        return (String)insert("ye162030DAO.insertYe162030_S", vo);
    }

    /**
	 * YE162030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162030(Ye162030VO vo) throws Exception {
        update("ye162030DAO.updateYe162030_S", vo);
    }

    /**
	 * YE162030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162030(Ye162030VO vo) throws Exception {
        delete("ye162030DAO.deleteYe162030_S", vo);
    }

    /**
	 * YE162030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162030VO
	 * @return 조회?�� YE162030
	 * @exception Exception
	 */
    public Ye162030VO selectYe162030(Ye162030VO vo) throws Exception {
        return (Ye162030VO) selectByPk("ye162030DAO.selectYe162030_S", vo);
    }

    /**
	 * YE162030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162030 목록
	 * @exception Exception
	 */
    public List<?> selectYe162030List(Ye162030SrhVO searchVO) throws Exception {
        return list("ye162030DAO.selectYe162030List_D", searchVO);
    }

    /**
	 * YE162030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162030 �? �??��
	 * @exception
	 */
    public int selectYe162030ListTotCnt(Ye162030SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162030DAO.selectYe162030ListTotCnt_S", searchVO);
    }

}
