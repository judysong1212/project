package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye162530Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye162530_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye162530_2020_DAO.java
 * @since : 2017. 12. 22. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye162530_2020_DAO")
public class Ye162530_2020_DAO extends EgovAbstractDAO {
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	/**
	 * YE162530 목록을 조회한다.
	 * @param Ye162530SrhVO - 조회할 정보가 담긴 ye162530SrhVo
	 * @return YE162530 목록
	 * @exception Exception
	 */
	public List selectYetaP53004ToYe162530List(Ye162530Srh_2020_VO ye162530SrhVo)throws Exception {
		return list("ye162530_2020_DAO.seleteYetaP53004ToYe162530_D", ye162530SrhVo);
	}

	/**
	 * YE162530 총 갯수를 조회한다.
	 * @param Ye162530SrhVO - 조회할 정보가 담긴 ye162530SrhVo
	 * @return YE162530 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP53004ToYe162530ListTotCnt(Ye162530Srh_2020_VO ye162530SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye162530_2020_DAO.seleteYetaP53004ToYe162530ListCnt_S", ye162530SrhVo);
	}	
	
	
	/**
	 * YE162530 을 등록한다.
	 * @param Ye162530VO - 등록할 정보가 담긴 Ye162530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP53004ToYe162530(Ye162530_2020_VO vo) throws Exception {
        return (String)insert("ye162530_2020_DAO.insertYetaP53004ToYe162530_S", vo);
    }
    
	/**
	 * YE162530 을 수정한다.
	 * @param Ye162530VO - 수정할 정보가 담긴 Ye162530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP53004ToYe162530(Ye162530_2020_VO vo) throws Exception {
        update("ye162530_2020_DAO.updateYetaP53004ToYe162530_S", vo);
    }
    
	/**
	 * YE162530 을 삭제한다.
	 * @param Ye162530VO - 삭제할 정보가 담긴 Ye162530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP53004ToYe162530(Ye162530_2020_VO vo) throws Exception {
        delete("ye162530_2020_DAO.deleteYetaP53004ToYe162530_S", vo);	
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
	  @Transactional
	    public void deleteYetaP510001_Ye162530VO_2020_Delete(Ye162530_2020_VO vo) throws Exception {
	        delete("ye162530_2020_DAO.deleteYetaP510001_Ye162530VO_2020_Delete_S", vo);
	    }
     
     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
	
    
	

	/**
	 * YE162530을 등록한다.(임대차계약)
	 * @param vo - 등록할 정보가 담긴 Ye162530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03004To162530(Ye162530_2020_VO vo) throws Exception {
        return (String)insert("ye162530_2020_DAO.insertYe162530_S", vo);
    }

    /**
	 * YE162530을 수정한다.(임대차계약)
	 * @param vo - 수정할 정보가 담긴 Ye162530VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03004To162530(Ye162530_2020_VO vo) throws Exception {
        update("ye162530_2020_DAO.updateYe162530_S", vo);
    }

    /**
	 * YE162530을 삭제한다.(임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Ye162530VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03004To162530(Ye162530_2020_VO vo) throws Exception {
        delete("ye162530_2020_DAO.deleteYe162530_S", vo);
    }
    
    /**
	 * YE162530을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162530VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR451_CREATE_Delete(Ye162530_2020_VO vo) throws Exception {
        delete("ye162530_2020_DAO.fnPayr06430_PAYR451_CREATE_Delete_S", vo);
    } 

    /**
	 * YE162530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Ye162530VO
	 * @return 조회한 YE162530
	 * @exception Exception
	 */
    public Ye162530_2020_VO selectYe162530(Ye162530_2020_VO vo) throws Exception {
        return (Ye162530_2020_VO) selectByPk("ye162530_2020_DAO.selectYe162530_S", vo);
    }

    /**
	 * YE162530 목록을 조회한다.(임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162530 목록
	 * @exception Exception
	 */
    public List selectYetaP03004To162530List(Ye162530Srh_2020_VO searchVO) throws Exception {
        return list("ye162530_2020_DAO.selectYe162530List_D", searchVO);
    }

    /**
	 * YE162530 총 갯수를 조회한다.(임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162530 총 갯수
	 * @exception
	 */
    public int selectYetaP03004To162530ListTotCnt(Ye162530Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162530_2020_DAO.selectYe162530ListTotCnt_S", searchVO);
    }

}
