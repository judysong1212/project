package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye161090Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye161090_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye161090_2022_DAO.java
 * @since : 2017. 12. 27. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye161090_2022_DAO")
public class Ye161090_2022_DAO extends EgovAbstractDAO {
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE161090 목록을 조회한다.
	 * @param Ye161090Srh_2022_VO - 조회할 정보가 담긴 ye161090SrhVo
	 * @return YE161090 목록
	 * @exception Exception
	 */
	public List selectYeta7300ToYe161090List(Ye161090Srh_2022_VO ye161090SrhVo)throws Exception {
		return list("ye161090_2022_DAO.seleteYeta7300ToYe161090_D", ye161090SrhVo);
	}

	/**
	 * YE161090 총 갯수를 조회한다.
	 * @param Ye161090Srh_2022_VO - 조회할 정보가 담긴 ye161090SrhVo
	 * @return YE161090 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYeta7300ToYe161090ListTotCnt(Ye161090Srh_2022_VO ye161090SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye161090_2022_DAO.seleteYeta7300ToYe161090ListCnt_S", ye161090SrhVo);
	}	
	
	
	/**
	 * YE161090 을 등록한다.
	 * @param Ye161090_2022_VO - 등록할 정보가 담긴 Ye161090_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta7300ToYe161090(Ye161090_2022_VO vo) throws Exception {
        return (String)insert("ye161090_2022_DAO.insertYeta7300ToYe161090_S", vo);
    }
    
	/**
	 * YE161090 을 수정한다.
	 * @param Ye161090_2022_VO - 수정할 정보가 담긴 Ye161090_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYeta7300ToYe161090(Ye161090_2022_VO vo) throws Exception {
        update("ye161090_2022_DAO.updateYeta7300ToYe161090_S", vo);
    }
    
	/**
	 * YE161090 을 삭제한다.
	 * @param Ye161090_2022_VO - 삭제할 정보가 담긴 Ye161090_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYeta7300ToYe161090(Ye161090_2022_VO vo) throws Exception {
        delete("ye161090_2022_DAO.deleteYeta7300ToYe161090_S", vo);	
    }
    
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 종료
	 * #############################################
	 * **/

    /***********************************************************************************
     * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
     ***********************************************************************************/
       
      /** ++++++++++++++++++++++++++++++++yeta2100 화면처리  ++++++++++++++++++++++++++++ **/      
 
    public void deleteYetaP710001_Ye161090_2022_VO_2022_Delete(Ye161090_2022_VO vo) throws Exception {
        delete("ye161090_2022_DAO.deleteYetaP710001_Ye161090_2022_VO_2022_Delete_S", vo);	
    }
    
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/   
    
    
    
	/**
	 * YE161090?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161090_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161090(Ye161090_2022_VO vo) throws Exception {
        return (String)insert("ye161090_2022_DAO.insertYe161090_S", vo);
    }

    /**
	 * YE161090?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161090_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161090(Ye161090_2022_VO vo) throws Exception {
        update("ye161090_2022_DAO.updateYe161090_S", vo);
    }

    /**
	 * YE161090?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161090_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161090(Ye161090_2022_VO vo) throws Exception {
        delete("ye161090_2022_DAO.deleteYe161090_S", vo);
    }

    /**
	 * YE161090?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161090_2022_VO
	 * @return 조회?�� YE161090
	 * @exception Exception
	 */
    public Ye161090_2022_VO selectYe161090(Ye161090_2022_VO vo) throws Exception {
        return (Ye161090_2022_VO) selectByPk("ye161090_2022_DAO.selectYe161090_S", vo);
    }

    /**
	 * YE161090 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161090 목록
	 * @exception Exception
	 */
    public List<?> selectYe161090List(Ye161090Srh_2022_VO search_2022_VO) throws Exception {
        return list("ye161090_2022_DAO.selectYe161090List_D", search_2022_VO);
    }

    /**
	 * YE161090 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161090 �? �??��
	 * @exception
	 */
    public int selectYe161090ListTotCnt(Ye161090Srh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye161090_2022_DAO.selectYe161090ListTotCnt_S", search_2022_VO);
    }

}
