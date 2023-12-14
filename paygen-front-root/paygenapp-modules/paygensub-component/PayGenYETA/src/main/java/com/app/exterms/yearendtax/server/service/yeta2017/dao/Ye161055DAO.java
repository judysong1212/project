package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161055SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161055VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161055DAO.java
 * @since : 2018. 1. 2. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161055DAO")
public class Ye161055DAO extends EgovAbstractDAO {
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161055 목록을 조회한다.
	 * @param Ye161055SrhVO - 조회할 정보가 담긴 ye161055SrhVo
	 * @return YE161055 목록
	 * @exception Exception
	 */
	public List selectYeta2300ToYe161055List(Ye161055SrhVO ye161055SrhVo)throws Exception {
		return list("ye161055DAO.seleteYeta2300ToYe161055_D", ye161055SrhVo);
	}

//	/**
//	 * YE161055 총 갯수를 조회한다.
//	 * @param Ye161055SrhVO - 조회할 정보가 담긴 ye161055SrhVo
//	 * @return YE161055 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYeta23001ToYe161055ListtTotCnt(Ye161055SrhVO ye161055SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("ye161055DAO.seleteYeta2300ToYe161055ListCnt_S", ye161055SrhVo);
//	}	
	
	
//	/**
//	 * YE161055 을 등록한다.
//	 * @param Ye161055VO - 등록할 정보가 담긴 Ye161055VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta2300ToYe161055(Ye161055VO vo) throws Exception {
//        return (String)insert("ye161055DAO.insertYeta2300ToYe161055_S", vo);
//    }
    
	/**
	 * YE161055 을 수정한다.
	 * @param Ye161055VO - 수정할 정보가 담긴 Ye161055VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta2300ToYe161055(Ye161055VO vo) throws Exception {
        update("ye161055DAO.updateYeta2300ToYe161055_S", vo);
    }
    
//	/**
//	 * YE161055 을 삭제한다.
//	 * @param Ye161055VO - 삭제할 정보가 담긴 Ye161055VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta2300ToYe161055(Ye161055VO vo) throws Exception {
//        delete("ye161055DAO.deleteYeta2300ToYe161055_S", vo);
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
    
    public void deleteYetaP210001_Ye161055VO_2017_Delete(Ye161055VO vo) throws Exception {
        delete("ye161055DAO.deleteYetaP210001_Ye161055VO_2017_Delete_S", vo);
    }
     

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/

    
    
    
	

	/**
	 * YE161055?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161055VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161055(Ye161055VO vo) throws Exception {
        return (String)insert("ye161055DAO.insertYe161055_S", vo);
    }

    /**
	 * YE161055?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161055VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161055(Ye161055VO vo) throws Exception {
        update("ye161055DAO.updateYe161055_S", vo);
    }

    /**
	 * YE161055?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161055VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161055(Ye161055VO vo) throws Exception {
        delete("ye161055DAO.deleteYe161055_S", vo);
    }

    /**
	 * YE161055?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161055VO
	 * @return 조회?�� YE161055
	 * @exception Exception
	 */
    public Ye161055VO selectYe161055(Ye161055VO vo) throws Exception {
        return (Ye161055VO) selectByPk("ye161055DAO.selectYe161055_S", vo);
    }

    /**
	 * YE161055 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161055 목록
	 * @exception Exception
	 */
    public List<?> selectYe161055List(Ye161055SrhVO searchVO) throws Exception {
        return list("ye161055DAO.selectYe161055List_D", searchVO);
    }

    /**
	 * YE161055 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161055 �? �??��
	 * @exception
	 */
    public int selectYe161055ListTotCnt(Ye161055SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161055DAO.selectYe161055ListTotCnt_S", searchVO);
    }

}
