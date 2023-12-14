package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161080Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye161080_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161080_2023_DAO.java
 * @Description : Ye161080 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye161080_2023_DAO")
public class Ye161080_2023_DAO extends EgovAbstractDAO {
	
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161080 목록을 조회한다.
	 * @param Ye161080Srh_2023_VO - 조회할 정보가 담긴 ye161080SrhVo
	 * @return YE161080 목록
	 * @exception Exception
	 */
	public List selectYeta8300ToYe161080tabItem08List(Ye161080Srh_2023_VO ye161080SrhVo)throws Exception {
		return list("ye161080_2023_DAO.seleteYeta8300ToYe161080tabItem08_D", ye161080SrhVo);
	}
	
	public List selectYeta8300ToYe161080tabItem09List(Ye161080Srh_2023_VO ye161080SrhVo)throws Exception {
		return list("ye161080_2023_DAO.seleteYeta8300ToYe161080tabItem09_D", ye161080SrhVo);
	}
	
	public List selectYeta8300ToYe161080tabItem10List(Ye161080Srh_2023_VO ye161080SrhVo)throws Exception {
		return list("ye161080_2023_DAO.seleteYeta8300ToYe161080tabItem10_D", ye161080SrhVo);
	}

//	/**
//	 * YE161080 총 갯수를 조회한다.
//	 * @param Ye161080Srh_2023_VO - 조회할 정보가 담긴 ye161080SrhVo
//	 * @return YE161080 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYeta8300ToYe161080ListtTotCnt(Ye161080Srh_2023_VO ye161080SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("ye161080_2023_DAO.seleteYeta8300ToYe161080ListCnt_S", ye161080SrhVo);
//	}	
	
	
//	/**
//	 * YE161080 을 등록한다.
//	 * @param Ye161080_2023_VO - 등록할 정보가 담긴 Ye161080_2023_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta8300ToYe161080(Ye161080_2023_VO vo) throws Exception {
//        return (String)insert("ye161080_2023_DAO.insertYeta8300ToYe161080_S", vo);
//    }
    
	/**
	 * YE161080 을 수정한다.
	 * @param Ye161080_2023_VO - 수정할 정보가 담긴 Ye161080_2023_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta8300ToYe161080tabItem08_1(Ye161080_2023_VO vo) throws Exception {
        update("ye161080_2023_DAO.updateYeta8300ToYe161080tabItem08_1_S", vo);
    }
    
    public void updateYeta8300ToYe161080tabItem08_3(Ye161080_2023_VO vo) throws Exception {
        update("ye161080_2023_DAO.updateYeta8300ToYe161080tabItem08_3_S", vo);
    } 
    
    public void updateYeta8300ToYe161080tabItem09(Ye161080_2023_VO vo) throws Exception {
        update("ye161080_2023_DAO.updateYeta8300ToYe161080tabItem09_S", vo);
    }  
    
    public void updateYeta8300ToYe161080tabItem10(Ye161080_2023_VO vo) throws Exception {
        update("ye161080_2023_DAO.updateYeta8300ToYe161080tabItem10_S", vo);
    }  
    
    
//	/**
//	 * YE161080 을 삭제한다.
//	 * @param Ye161080_2023_VO - 삭제할 정보가 담긴 Ye161080_2023_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta8300ToYe161080(Ye161080_2023_VO vo) throws Exception {
//        delete("ye161080_2023_DAO.deleteYeta8300ToYe161080_S", vo);
//    }	
	
	/**    
     * #############################################
     * 2017년도 연말정산 구현 종료
     * #############################################
     *   **/	
	
	
    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
       
      /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
    public void deleteYetaP810001_Ye161080_2023_VO_2023_Delete(Ye161080_2023_VO vo) throws Exception {
        delete("ye161080_2023_DAO.deleteYetaP810001_Ye161080_2023_VO_2023_Delete_S", vo);
    }

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/		
	
	

	/**
	 * YE161080?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161080_2023_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161080(Ye161080_2023_VO vo) throws Exception {
        return (String)insert("ye161080_2023_DAO.insertYe161080_S", vo);
    }

    /**
	 * YE161080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161080_2023_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161080(Ye161080_2023_VO vo) throws Exception {
        update("ye161080_2023_DAO.updateYe161080_S", vo);
    }

    /**
	 * YE161080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161080_2023_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161080(Ye161080_2023_VO vo) throws Exception {
        delete("ye161080_2023_DAO.deleteYe161080_S", vo);
    }

    /**
	 * YE161080?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161080_2023_VO
	 * @return 조회?�� YE161080
	 * @exception Exception
	 */
    public Ye161080_2023_VO selectYe161080(Ye161080_2023_VO vo) throws Exception {
        return (Ye161080_2023_VO) selectByPk("ye161080_2023_DAO.selectYe161080_S", vo);
    }

    /**
	 * YE161080 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161080 목록
	 * @exception Exception
	 */
    public List<?> selectYe161080List(Ye161080Srh_2023_VO search_2023_VO) throws Exception {
        return list("ye161080_2023_DAO.selectYe161080List_D", search_2023_VO);
    }

    /**
	 * YE161080 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161080 �? �??��
	 * @exception
	 */
    public int selectYe161080ListTotCnt(Ye161080Srh_2023_VO search_2023_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161080_2023_DAO.selectYe161080ListTotCnt_S", search_2023_VO);
    }

}
