package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye164010Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye164010_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye164010_2020_DAO.java
 * @since : 2017. 12. 27. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye164010_2020_DAO")
public class Ye164010_2020_DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE164010 목록을 조회한다.
	 * @param Ye164010SrhVO - 조회할 정보가 담긴 ye164010SrhVo
	 * @return YE164010 목록
	 * @exception Exception
	 */
	public List selectYetaP53002ToYe164010List(Ye164010Srh_2020_VO ye164010SrhVo)throws Exception {
		return list("ye164010_2020_DAO.seleteYetaP53002ToYe164010_D", ye164010SrhVo);
	}

	/**
	 * YE164010 총 갯수를 조회한다.
	 * @param Ye164010SrhVO - 조회할 정보가 담긴 ye164010SrhVo
	 * @return YE164010 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP53002ToYe164010ListTotCnt(Ye164010Srh_2020_VO ye164010SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye164010_2020_DAO.seleteYetaP53002ToYe164010ListCnt_S", ye164010SrhVo);
	}	
	
	
	/**
	 * YE164010 을 등록한다.
	 * @param Ye164010VO - 등록할 정보가 담긴 Ye164010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP53002ToYe164010(Ye164010_2020_VO vo) throws Exception {
        return (String)insert("ye164010_2020_DAO.insertYetaP53002ToYe164010_S", vo);
    }
    
	/**
	 * YE164010 을 수정한다.
	 * @param Ye164010VO - 수정할 정보가 담긴 Ye164010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP53002ToYe164010(Ye164010_2020_VO vo) throws Exception {
        update("ye164010_2020_DAO.updateYetaP53002ToYe164010_S", vo);
    }
    
	/**
	 * YE164010 을 삭제한다.
	 * @param Ye164010VO - 삭제할 정보가 담긴 Ye164010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP53002ToYe164010(Ye164010_2020_VO vo) throws Exception {
        delete("ye164010_2020_DAO.deleteYetaP53002ToYe164010_S", vo);	
    }
    
    public void deleteYeta5300ToYe164010(Ye164010_2020_VO vo) throws Exception {
        delete("ye164010_2020_DAO.deleteYeta5300ToYe164010_S", vo);	
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
    
    public void deleteYetaP510001_Ye164010VO_2020_Delete(Ye164010_2020_VO vo) throws Exception {
        delete("ye164010_2020_DAO.deleteYetaP510001_Ye164010VO_2020_Delete_S", vo);
    }
    
    
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/

    
    
    
	

	/**
	 * YE164010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye164010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe164010(Ye164010_2020_VO vo) throws Exception {
        return (String)insert("ye164010_2020_DAO.insertYe164010_S", vo);
    }

    /**
	 * YE164010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye164010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe164010(Ye164010_2020_VO vo) throws Exception {
        update("ye164010_2020_DAO.updateYe164010_S", vo);
    }

    /**
	 * YE164010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye164010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe164010(Ye164010_2020_VO vo) throws Exception {
        delete("ye164010_2020_DAO.deleteYe164010_S", vo);
    }

    /**
	 * YE164010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye164010VO
	 * @return 조회?�� YE164010
	 * @exception Exception
	 */
    public Ye164010_2020_VO selectYe164010(Ye164010_2020_VO vo) throws Exception {
        return (Ye164010_2020_VO) selectByPk("ye164010_2020_DAO.selectYe164010_S", vo);
    }

    /**
	 * YE164010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE164010 목록
	 * @exception Exception
	 */
    public List<?> selectYe164010List(Ye164010Srh_2020_VO searchVO) throws Exception {
        return list("ye164010_2020_DAO.selectYe164010List_D", searchVO);
    }

    /**
	 * YE164010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE164010 �? �??��
	 * @exception
	 */
    public int selectYe164010ListTotCnt(Ye164010Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye164010_2020_DAO.selectYe164010ListTotCnt_S", searchVO);
    }

}
