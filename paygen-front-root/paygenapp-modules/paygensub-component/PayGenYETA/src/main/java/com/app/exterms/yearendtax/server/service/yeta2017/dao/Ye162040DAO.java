package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye162040SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye162040VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162040DAO.java
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

@Repository("Ye162040DAO")
public class Ye162040DAO extends EgovAbstractDAO {

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP210001_Ye162040VO_2017_Delete(Ye162040VO vo) throws Exception {
        delete("ye162040DAO.deleteYetaP210001_Ye162040VO_2017_Delete_S", vo);
    }

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/	
	
	
	
	
	/**
	 * YE162040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162040(Ye162040VO vo) throws Exception {
        return (String)insert("ye162040DAO.insertYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162040(Ye162040VO vo) throws Exception {
        update("ye162040DAO.updateYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162040(Ye162040VO vo) throws Exception {
        delete("ye162040DAO.deleteYe162040_S", vo);
    }

    /**
	 * YE162040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162040VO
	 * @return 조회?�� YE162040
	 * @exception Exception
	 */
    public Ye162040VO selectYe162040(Ye162040VO vo) throws Exception {
        return (Ye162040VO) selectByPk("ye162040DAO.selectYe162040_S", vo);
    }

    /**
	 * YE162040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 목록
	 * @exception Exception
	 */
    public List<?> selectYe162040List(Ye162040SrhVO searchVO) throws Exception {
        return list("ye162040DAO.selectYe162040List_D", searchVO);
    }

    /**
	 * YE162040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 �? �??��
	 * @exception
	 */
    public int selectYe162040ListTotCnt(Ye162040SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162040DAO.selectYe162040ListTotCnt_S", searchVO);
    }

}
