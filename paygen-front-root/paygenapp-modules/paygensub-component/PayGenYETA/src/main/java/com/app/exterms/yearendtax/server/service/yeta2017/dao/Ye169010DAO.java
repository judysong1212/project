package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161080VO;
import com.app.exterms.yearendtax.server.vo.Ye169010VO;
import com.app.exterms.yearendtax.server.vo.Ye169010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye169010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye169010DAO.java
 * @Description : Ye169010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye169010DAO")
public class Ye169010DAO extends EgovAbstractDAO {
	
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/	
	
	/**
	 * YE169010 을 수정한다.
	 * @param InfcPkgYe169010VO - 수정할 정보가 담긴 Ye169010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta2300ToYe169010(Ye169010VO vo) throws Exception {
        update("ye169010DAO.updateYeta2300ToYe169010_S", vo);
    }
	
	
	
	/**
	 * YE169010 목록을 조회한다.
	 * @param Ye169010SrhVO - 조회할 정보가 담긴 ye169010SrhVo
	 * @return YE169010 목록
	 * @exception Exception
	 */
	public List selectYeta2300ToYe169010List(Ye169010SrhVO ye169010SrhVo)throws Exception {
		return list("ye169010DAO.seleteYeta2300ToYe169010_D", ye169010SrhVo);
	}

	/**
	 * YE169010 총 갯수를 조회한다.
	 * @param Ye169010SrhVO - 조회할 정보가 담긴 ye169010SrhVo
	 * @return YE169010 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta2300ToYe169010ListtTotCnt(Ye169010SrhVO ye169010SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye169010DAO.seleteYeta2300ToYe169010ListCnt_S", ye169010SrhVo);
	}	
	
    public void updateYeta2300ToYe169010tabItem09(Ye169010VO vo) throws Exception {
        update("ye169010DAO.updateYeta2300ToYe169010tabItem09_S", vo);
    }  
    
	
	
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	
		
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	 ***********************************************************************************/
	   
	  /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
	   public void deleteYetaP210001_Ye169010VO_2017_Delete(Ye169010VO vo) throws Exception {
	        delete("ye169010DAO.deleteYetaP210001_Ye169010VO_2017_Delete_S", vo);
	    }

	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
	  ***********************************************************************************/
	
	
	

	/**
	 * YE169010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye169010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe169010(Ye169010VO vo) throws Exception {
        return (String)insert("ye169010DAO.insertYe169010_S", vo);
    }

    /**
	 * YE169010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe169010(Ye169010VO vo) throws Exception {
        update("ye169010DAO.updateYe169010_S", vo);
    }

    /**
	 * YE169010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye169010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe169010(Ye169010VO vo) throws Exception {
        delete("ye169010DAO.deleteYe169010_S", vo);
    }

    /**
	 * YE169010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye169010VO
	 * @return 조회?�� YE169010
	 * @exception Exception
	 */
    public Ye169010VO selectYe169010(Ye169010VO vo) throws Exception {
        return (Ye169010VO) selectByPk("ye169010DAO.selectYe169010_S", vo);
    }

    /**
	 * YE169010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010 목록
	 * @exception Exception
	 */
    public List<?> selectYe169010List(Ye169010SrhVO searchVO) throws Exception {
        return list("ye169010DAO.selectYe169010List_D", searchVO);
    }

    /**
	 * YE169010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE169010 �? �??��
	 * @exception
	 */
    public int selectYe169010ListTotCnt(Ye169010SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye169010DAO.selectYe169010ListTotCnt_S", searchVO);
    }

}