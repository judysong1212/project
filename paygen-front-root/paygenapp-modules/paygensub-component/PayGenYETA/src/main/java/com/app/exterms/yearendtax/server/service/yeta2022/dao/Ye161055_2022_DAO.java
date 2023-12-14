package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161055Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye161055_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161055_2022_DAO.java
 * @since : 2019. 1. 2. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161055_2022_DAO")
public class Ye161055_2022_DAO extends EgovAbstractDAO {
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161055 목록을 조회한다.
	 * @param Ye161055Srh_2022_VO - 조회할 정보가 담긴 ye161055SrhVo
	 * @return YE161055 목록
	 * @exception Exception
	 */
	public List selectYeta7300ToYe161055List(Ye161055Srh_2022_VO ye161055SrhVo)throws Exception {
		return list("ye161055_2022_DAO.seleteYeta7300ToYe161055_D", ye161055SrhVo);
	}

//	/**
//	 * YE161055 총 갯수를 조회한다.
//	 * @param Ye161055Srh_2022_VO - 조회할 정보가 담긴 ye161055SrhVo
//	 * @return YE161055 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYeta73001ToYe161055ListtTotCnt(Ye161055Srh_2022_VO ye161055SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("ye161055_2022_DAO.seleteYeta7300ToYe161055ListCnt_S", ye161055SrhVo);
//	}	
	
	
//	/**
//	 * YE161055 을 등록한다.
//	 * @param Ye161055_2022_VO - 등록할 정보가 담긴 Ye161055_2022_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta7300ToYe161055(Ye161055_2022_VO vo) throws Exception {
//        return (String)insert("ye161055_2022_DAO.insertYeta7300ToYe161055_S", vo);
//    }
    
	/**
	 * YE161055 을 수정한다.
	 * @param Ye161055_2022_VO - 수정할 정보가 담긴 Ye161055_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta7300ToYe161055(Ye161055_2022_VO vo) throws Exception {
        update("ye161055_2022_DAO.updateYeta7300ToYe161055_S", vo);
    }
    
//	/**
//	 * YE161055 을 삭제한다.
//	 * @param Ye161055_2022_VO - 삭제할 정보가 담긴 Ye161055_2022_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta7300ToYe161055(Ye161055_2022_VO vo) throws Exception {
//        delete("ye161055_2022_DAO.deleteYeta7300ToYe161055_S", vo);
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
    
    public void deleteYetaP710001_Ye161055_2022_VO_2022_Delete(Ye161055_2022_VO vo) throws Exception {
        delete("ye161055_2022_DAO.deleteYetaP710001_Ye161055_2022_VO_2022_Delete_S", vo);
    }
     

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/

    
    
    
	

	/**
	 * YE161055?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161055_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161055(Ye161055_2022_VO vo) throws Exception {
        return (String)insert("ye161055_2022_DAO.insertYe161055_S", vo);
    }

    /**
	 * YE161055?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161055_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161055(Ye161055_2022_VO vo) throws Exception {
        update("ye161055_2022_DAO.updateYe161055_S", vo);
    }

    /**
	 * YE161055?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161055_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161055(Ye161055_2022_VO vo) throws Exception {
        delete("ye161055_2022_DAO.deleteYe161055_S", vo);
    }

    /**
	 * YE161055?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161055_2022_VO
	 * @return 조회?�� YE161055
	 * @exception Exception
	 */
    public Ye161055_2022_VO selectYe161055(Ye161055_2022_VO vo) throws Exception {
        return (Ye161055_2022_VO) selectByPk("ye161055_2022_DAO.selectYe161055_S", vo);
    }

    /**
	 * YE161055 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161055 목록
	 * @exception Exception
	 */
    public List<?> selectYe161055List(Ye161055Srh_2022_VO search_2022_VO) throws Exception {
        return list("ye161055_2022_DAO.selectYe161055List_D", search_2022_VO);
    }

    /**
	 * YE161055 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161055 �? �??��
	 * @exception
	 */
    public int selectYe161055ListTotCnt(Ye161055Srh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161055_2022_DAO.selectYe161055ListTotCnt_S", search_2022_VO);
    }

}
