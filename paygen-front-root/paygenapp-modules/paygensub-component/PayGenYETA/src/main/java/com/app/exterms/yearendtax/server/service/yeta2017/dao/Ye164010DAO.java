package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye164010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye164010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye164010DAO.java
 * @since : 2017. 12. 27. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye164010DAO")
public class Ye164010DAO extends EgovAbstractDAO {
	
	
	
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
	public List selectYetaP23002ToYe164010List(Ye164010SrhVO ye164010SrhVo)throws Exception {
		return list("ye164010DAO.seleteYetaP23002ToYe164010_D", ye164010SrhVo);
	}

	/**
	 * YE164010 총 갯수를 조회한다.
	 * @param Ye164010SrhVO - 조회할 정보가 담긴 ye164010SrhVo
	 * @return YE164010 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP23002ToYe164010ListTotCnt(Ye164010SrhVO ye164010SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye164010DAO.seleteYetaP23002ToYe164010ListCnt_S", ye164010SrhVo);
	}	
	
	
	/**
	 * YE164010 을 등록한다.
	 * @param Ye164010VO - 등록할 정보가 담긴 Ye164010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP23002ToYe164010(Ye164010VO vo) throws Exception {
        return (String)insert("ye164010DAO.insertYetaP23002ToYe164010_S", vo);
    }
    
	/**
	 * YE164010 을 수정한다.
	 * @param Ye164010VO - 수정할 정보가 담긴 Ye164010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP23002ToYe164010(Ye164010VO vo) throws Exception {
        update("ye164010DAO.updateYetaP23002ToYe164010_S", vo);
    }
    
	/**
	 * YE164010 을 삭제한다.
	 * @param Ye164010VO - 삭제할 정보가 담긴 Ye164010VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP23002ToYe164010(Ye164010VO vo) throws Exception {
        delete("ye164010DAO.deleteYetaP23002ToYe164010_S", vo);	
    }
    
    public void deleteYeta2300ToYe164010(Ye164010VO vo) throws Exception {
        delete("ye164010DAO.deleteYeta2300ToYe164010_S", vo);	
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
    
    public void deleteYetaP210001_Ye164010VO_2017_Delete(Ye164010VO vo) throws Exception {
        delete("ye164010DAO.deleteYetaP210001_Ye164010VO_2017_Delete_S", vo);
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
    public String insertYe164010(Ye164010VO vo) throws Exception {
        return (String)insert("ye164010DAO.insertYe164010_S", vo);
    }

    /**
	 * YE164010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye164010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe164010(Ye164010VO vo) throws Exception {
        update("ye164010DAO.updateYe164010_S", vo);
    }

    /**
	 * YE164010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye164010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe164010(Ye164010VO vo) throws Exception {
        delete("ye164010DAO.deleteYe164010_S", vo);
    }

    /**
	 * YE164010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye164010VO
	 * @return 조회?�� YE164010
	 * @exception Exception
	 */
    public Ye164010VO selectYe164010(Ye164010VO vo) throws Exception {
        return (Ye164010VO) selectByPk("ye164010DAO.selectYe164010_S", vo);
    }

    /**
	 * YE164010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE164010 목록
	 * @exception Exception
	 */
    public List<?> selectYe164010List(Ye164010SrhVO searchVO) throws Exception {
        return list("ye164010DAO.selectYe164010List_D", searchVO);
    }

    /**
	 * YE164010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE164010 �? �??��
	 * @exception
	 */
    public int selectYe164010ListTotCnt(Ye164010SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye164010DAO.selectYe164010ListTotCnt_S", searchVO);
    }

}