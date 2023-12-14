package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161070Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161070_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161070_2019_DAO.java
 * @since : 2019. 1. 3. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161070_2019_DAO")
public class Ye161070_2019_DAO extends EgovAbstractDAO {
	
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161070 목록을 조회한다.
	 * @param Ye161070Srh_2019_VO - 조회할 정보가 담긴 ye161070SrhVo
	 * @return YE161070 목록
	 * @exception Exception
	 */
	public List selectYeta4300ToYe161070List(Ye161070Srh_2019_VO ye161070SrhVo)throws Exception {
		return list("ye161070_2019_DAO.seleteYeta4300ToYe161070_D", ye161070SrhVo);
	}

//	/**
//	 * YE161070 총 갯수를 조회한다.
//	 * @param Ye161070Srh_2019_VO - 조회할 정보가 담긴 ye161070SrhVo
//	 * @return YE161070 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYeta4300ToYe161070ListtTotCnt(Ye161070Srh_2019_VO ye161070SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("ye161070_2019_DAO.seleteYeta4300ToYe161070ListCnt_S", ye161070SrhVo);
//	}	
	
	
//	/**
//	 * YE161070 을 등록한다.
//	 * @param Ye161070_2019_VO - 등록할 정보가 담긴 Ye161070_2019_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta4300ToYe161070(Ye161070_2019_VO vo) throws Exception {
//        return (String)insert("ye161070_2019_DAO.insertYeta4300ToYe161070_S", vo);
//    }
    
	/**
	 * YE161070 을 수정한다.
	 * @param Ye161070_2019_VO - 수정할 정보가 담긴 Ye161070_2019_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta4300ToYe161070tabItem06(Ye161070_2019_VO vo) throws Exception {
        update("ye161070_2019_DAO.updateYeta4300ToYe161070tabItem06_S", vo);
    }
    
    public void updateYeta4300ToYe161070tabItem07(Ye161070_2019_VO vo) throws Exception {
        update("ye161070_2019_DAO.updateYeta4300ToYe161070tabItem07_S", vo);
    }
    
//	/**
//	 * YE161070 을 삭제한다.
//	 * @param Ye161070_2019_VO - 삭제할 정보가 담긴 Ye161070_2019_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta4300ToYe161070(Ye161070_2019_VO vo) throws Exception {
//        delete("ye161070_2019_DAO.deleteYeta4300ToYe161070_S", vo);
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
    
  public void deleteYetaP410001_Ye161070_2019_VO_2019_Delete(Ye161070_2019_VO vo) throws Exception {
	  delete("ye161070_2019_DAO.deleteYetaP410001_Ye161070_2019_VO_2019_Delete_S", vo);
  }

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
    
    

}
