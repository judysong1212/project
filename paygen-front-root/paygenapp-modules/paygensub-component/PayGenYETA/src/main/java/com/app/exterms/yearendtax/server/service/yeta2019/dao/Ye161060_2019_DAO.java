package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161060Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161060_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161060_2019_DAO.java
 * @Description : Ye161060 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye161060_2019_DAO")
public class Ye161060_2019_DAO extends EgovAbstractDAO {
	

	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161060 목록을 조회한다.
	 * @param Ye161060Srh_2019_VO - 조회할 정보가 담긴 ye161060SrhVo
	 * @return YE161060 목록
	 * @exception Exception
	 */
	public List selectYeta4300ToYe161060tabItem05List(Ye161060Srh_2019_VO ye161060SrhVo)throws Exception {
		return list("ye161060_2019_DAO.seleteYeta4300ToYe161060tabItem05_D", ye161060SrhVo);
	}

//	/**
//	 * YE161060 총 갯수를 조회한다.
//	 * @param Ye161060Srh_2019_VO - 조회할 정보가 담긴 ye161060SrhVo
//	 * @return YE161060 총 갯수
//	 * @exception
//	 */
//	@SuppressWarnings("deprecation")
//	public int selectYeta4300ToYe161060ListtTotCnt(Ye161060Srh_2019_VO ye161060SrhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("ye161060_2019_DAO.seleteYeta4300ToYe161060ListCnt_S", ye161060SrhVo);
//	}	
	
	
//	/**
//	 * YE161060 을 등록한다.
//	 * @param Ye161060_2019_VO - 등록할 정보가 담긴 Ye161060_2019_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta4300ToYe161060(Ye161060_2019_VO vo) throws Exception {
//        return (String)insert("ye161060_2019_DAO.insertYeta4300ToYe161060_S", vo);
//    }
    
	/**
	 * YE161060 을 수정한다.
	 * @param Ye161060_2019_VO - 수정할 정보가 담긴 Ye161060_2019_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta4300ToYe161060tabItem05_1(Ye161060_2019_VO vo) throws Exception {
        update("ye161060_2019_DAO.updateYeta4300ToYe161060tabItem05_1_S", vo);
    }
    public void updateYeta4300ToYe161060tabItem05_2(Ye161060_2019_VO vo) throws Exception {
        update("ye161060_2019_DAO.updateYeta4300ToYe161060tabItem05_2_S", vo);
    }
    
    
    
//	/**
//	 * YE161060 을 삭제한다.
//	 * @param Ye161060_2019_VO - 삭제할 정보가 담긴 Ye161060_2019_VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public void deleteYeta4300ToYe161060(Ye161060_2019_VO vo) throws Exception {
//        delete("ye161060_2019_DAO.deleteYeta4300ToYe161060_S", vo);
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
    public void deleteYetaP410001_Ye161060_2019_VO_2019_Delete(Ye161060_2019_VO vo) throws Exception {
      delete("ye161060_2019_DAO.deleteYetaP410001_Ye161060_2019_VO_2019_Delete_S", vo);
  }	
    	
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/	
		
    
	 

}
