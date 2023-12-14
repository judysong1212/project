package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Ye162510Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye162510_2022_VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * @Class Name : Ye162510_2022_DAO.java
 * @since : 2017. 12. 25. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Repository("Ye162510_2022_DAO")
public class Ye162510_2022_DAO extends EgovAbstractDAO implements IsSerializable {
	
	
	
	/**
	 * ############################################# 
	 * 2017년도 연말정산 구현 시작
	 * #############################################
	 * **/
	
	
	
	/**
	 * YE162510 목록을 조회한다.
	 * @param Ye162510Srh_2022_VO - 조회할 정보가 담긴 ye162510SrhVo
	 * @return YE162510 목록
	 * @exception Exception
	 */
	public List selectYetaP73005ToYe162510List(Ye162510Srh_2022_VO ye162510SrhVo)throws Exception {
		return list("ye162510_2022_DAO.seleteYetaP73005ToYe162510_D", ye162510SrhVo);
	}

	/**
	 * YE162510 총 갯수를 조회한다.
	 * @param Ye162510Srh_2022_VO - 조회할 정보가 담긴 ye162510SrhVo
	 * @return YE162510 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectYetaP73005ToYe162510ListTotCnt(Ye162510Srh_2022_VO ye162510SrhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ye162510_2022_DAO.seleteYetaP73005ToYe162510ListCnt_S", ye162510SrhVo);
	}	
	
	
	/**
	 * YE162510 을 등록한다.
	 * @param Ye162510_2022_VO - 등록할 정보가 담긴 Ye162510_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYetaP73005ToYe162510(Ye162510_2022_VO vo) throws Exception {
        return (String)insert("ye162510_2022_DAO.insertYetaP73005ToYe162510_S", vo);
    }
    
	/**
	 * YE162510 을 수정한다.
	 * @param Ye162510_2022_VO - 수정할 정보가 담긴 Ye162510_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void updateYetaP73005ToYe162510(Ye162510_2022_VO vo) throws Exception {
        update("ye162510_2022_DAO.updateYetaP73005ToYe162510_S", vo);
    }
    
	/**
	 * YE162510 을 삭제한다.
	 * @param Ye162510_2022_VO - 삭제할 정보가 담긴 Ye162510_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deleteYetaP73005ToYe162510(Ye162510_2022_VO vo) throws Exception {
        delete("ye162510_2022_DAO.deleteYetaP73005ToYe162510_S", vo);	
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
	    public void deleteYetaP710001_Ye162510_2022_VO_2022_Delete(Ye162510_2022_VO vo) throws Exception {
	        delete("ye162510_2022_DAO.deleteYetaP710001_Ye162510_2022_VO_2022_Delete_S", vo);
	    }

     /***********************************************************************************
      * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료 
      ***********************************************************************************/
    
    
	
	
	/**
	 * YE162510을 등록한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 등록할 정보가 담긴 Ye162510_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaT13019To162510(Ye162510_2022_VO vo) throws Exception {
        return (String)insert("ye162510_2022_DAO.insertYe162510_S", vo);
    }

    /**
	 * YE162510을 수정한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 수정할 정보가 담긴 Ye162510_2022_VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaT13019To162510(Ye162510_2022_VO vo) throws Exception {
        update("ye162510_2022_DAO.updateYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Ye162510_2022_VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaT13019To162510(Ye162510_2022_VO vo) throws Exception {
        delete("ye162510_2022_DAO.deleteYe162510_S", vo);
    }
    
//    /**
//	 * YE162510 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YE162510 목록
//	 * @exception Exception
//	 */
//    public List selectYetaP03004To162510List(Ye162510Srh_2022_VO search_2022_VO) throws Exception {
//        return list("ye162510_2022_DAO.selectYetaP03004To162510List_D", search_2022_VO);
//    }
//
//    /**
//	 * YE162510 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YE162510 총 갯수
//	 * @exception
//	 */
//    public int selectYetaP03004To162510ListTotCnt(Ye162510Srh_2022_VO search_2022_VO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("ye162510_2022_DAO.selectYetaP03004To162510ListTotCnt_S", search_2022_VO);
//    }
    
    
 
    /**
	 * YE162510 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 목록
	 * @exception Exception
	 */
    public List selectYeT13019To162510List(Ye162510Srh_2022_VO search_2022_VO) throws Exception {
        return list("ye162510_2022_DAO.selectYeT13019To162510List_D", search_2022_VO);
    }
   
    /**
	 * YE162510 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 총 갯수
	 * @exception
	 */
    public int selectYetaT13019To162510ListTotCnt(Ye162510Srh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162510_2022_DAO.selectYetaT13019To162510ListTotCnt_S", search_2022_VO);
    }
    
    
	

	/**
	 * YE162510을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Ye162510_2022_VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYe162510(Ye162510_2022_VO vo) throws Exception {
        return (String)insert("ye162510_2022_DAO.insertYe162510_S", vo);
    }

    /**
	 * YE162510을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Ye162510_2022_VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYe162510(Ye162510_2022_VO vo) throws Exception {
        update("ye162510_2022_DAO.updateYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162510_2022_VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYe162510(Ye162510_2022_VO vo) throws Exception {
        delete("ye162510_2022_DAO.deleteYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162510_2022_VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR452_CREATE_Delete(Ye162510_2022_VO vo) throws Exception {
        delete("ye162510_2022_DAO.fnPayr06430_PAYR452_CREATE_Delete_S", vo);
    }
    
    /**
	 * YE162510을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Ye162510_2022_VO
	 * @return 조회한 YE162510
	 * @exception Exception
	 */
    public Ye162510_2022_VO selectYe162510(Ye162510_2022_VO vo) throws Exception {
        return (Ye162510_2022_VO) selectByPk("ye162510_2022_DAO.selectYe162510_S", vo);
    }

    /**
	 * YE162510 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 목록
	 * @exception Exception
	 */
    public List<?> selectYe162510List(Ye162510Srh_2022_VO search_2022_VO) throws Exception {
        return list("ye162510_2022_DAO.selectYe162510List_D", search_2022_VO);
    }

    /**
	 * YE162510 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 총 갯수
	 * @exception
	 */
    public int selectYe162510ListTotCnt(Ye162510Srh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye162510_2022_DAO.selectYe162510ListTotCnt_S", search_2022_VO);
    }

}
