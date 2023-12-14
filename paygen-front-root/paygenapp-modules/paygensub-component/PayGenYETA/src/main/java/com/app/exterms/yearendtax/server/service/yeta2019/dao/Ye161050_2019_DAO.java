package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161050Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161050_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161050_2019_DAO.java
 * @Description : Ye161050 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye161050_2019_DAO")
public class Ye161050_2019_DAO extends EgovAbstractDAO {

	
	
	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	
	/** ++++++++++++++++++++++++++++++++yeta2300 화면처리  ++++++++++++++++++++++++++++ **/  
    public void updateYeta4300ToYe161050(Ye161050_2019_VO vo) throws Exception {
        update("ye161050_2019_DAO.updateYeta4300ToYe161050_S", vo);
    }
	
	
	   
	/** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
	
    public void deleteYetaP410001_Ye161050_2019_VO_2019_Delete(Ye161050_2019_VO vo) throws Exception {
        delete("ye161050_2019_DAO.deleteYetaP410001_Ye161050_2019_VO_2019_Delete_S", vo);
    }
	
	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/
	
	/**
	 * YE161050?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161050_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161050(Ye161050_2019_VO vo) throws Exception {
        return (String)insert("ye161050_2019_DAO.insertYe161050_S", vo);
    }

    /**
	 * YE161050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161050_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161050(Ye161050_2019_VO vo) throws Exception {
        update("ye161050_2019_DAO.updateYe161050_S", vo);
    }

    /**
	 * YE161050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161050_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161050(Ye161050_2019_VO vo) throws Exception {
        delete("ye161050_2019_DAO.deleteYe161050_S", vo);
    }

    /**
	 * YE161050?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161050_2019_VO
	 * @return 조회?�� YE161050
	 * @exception Exception
	 */
    public Ye161050_2019_VO selectYe161050(Ye161050_2019_VO vo) throws Exception {
        return (Ye161050_2019_VO) selectByPk("ye161050_2019_DAO.selectYe161050_S", vo);
    }

    /**
	 * YE161050 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161050 목록
	 * @exception Exception
	 */
    public List<?> selectYe161050List(Ye161050Srh_2019_VO search_2019_VO) throws Exception {
        return list("ye161050_2019_DAO.selectYe161050List_D", search_2019_VO);
    }

    /**
	 * YE161050 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161050 �? �??��
	 * @exception
	 */
    public int selectYe161050ListTotCnt(Ye161050Srh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161050_2019_DAO.selectYe161050ListTotCnt_S", search_2019_VO);
    }
    
    
    

}