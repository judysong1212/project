package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3130SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3130VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3130DAO.java
 * @Description : Yeta3130 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3130DAO")
public class Yeta3130DAO extends EgovAbstractDAO implements IsSerializable {
	
	/**
	 * YETA3130을 등록한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 등록할 정보가 담긴 Yeta3130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03004To3130(Yeta3130VO vo) throws Exception {
        return (String)insert("yeta3130DAO.insertYeta3130_S", vo);
    }

    /**
	 * YETA3130을 수정한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 수정할 정보가 담긴 Yeta3130VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03004To3130(Yeta3130VO vo) throws Exception {
        update("yeta3130DAO.updateYeta3130_S", vo);
    }

    /**
	 * YETA3130을 삭제한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Yeta3130VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03004To3130(Yeta3130VO vo) throws Exception {
        delete("yeta3130DAO.deleteYeta3130_S", vo);
    }
    
//    /**
//	 * YETA3130 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YETA3130 목록
//	 * @exception Exception
//	 */
//    public List selectYetaP03004To3130List(Yeta3130SrhVO searchVO) throws Exception {
//        return list("yeta3130DAO.selectYetaP03004To3130List_D", searchVO);
//    }
//
//    /**
//	 * YETA3130 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YETA3130 총 갯수
//	 * @exception
//	 */
//    public int selectYetaP03004To3130ListTotCnt(Yeta3130SrhVO searchVO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3130DAO.selectYetaP03004To3130ListTotCnt_S", searchVO);
//    }
    
    
 
    /**
	 * YETA3130 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3130 목록
	 * @exception Exception
	 */
    public List selectYetaP03005To3130List(Yeta3130SrhVO searchVO) throws Exception {
        return list("yeta3130DAO.selectYetaP03005To3130List_D", searchVO);
    }
   
    /**
	 * YETA3130 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3130 총 갯수
	 * @exception
	 */
    public int selectYetaP03005To3130ListTotCnt(Yeta3130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3130DAO.selectYetaP03005To3130ListTotCnt_S", searchVO);
    }
    
    
	

	/**
	 * YETA3130을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3130(Yeta3130VO vo) throws Exception {
        return (String)insert("yeta3130DAO.insertYeta3130_S", vo);
    }

    /**
	 * YETA3130을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3130VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3130(Yeta3130VO vo) throws Exception {
        update("yeta3130DAO.updateYeta3130_S", vo);
    }

    /**
	 * YETA3130을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3130VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3130(Yeta3130VO vo) throws Exception {
        delete("yeta3130DAO.deleteYeta3130_S", vo);
    }

    /**
	 * YETA3130을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3130VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR452_CREATE_Delete(Yeta3130VO vo) throws Exception {
        delete("yeta3130DAO.fnPayr06430_PAYR452_CREATE_Delete_S", vo);
    }
    
    /**
	 * YETA3130을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3130VO
	 * @return 조회한 YETA3130
	 * @exception Exception
	 */
    public Yeta3130VO selectYeta3130(Yeta3130VO vo) throws Exception {
        return (Yeta3130VO) selectByPk("yeta3130DAO.selectYeta3130_S", vo);
    }

    /**
	 * YETA3130 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3130 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3130List(Yeta3130SrhVO searchVO) throws Exception {
        return list("yeta3130DAO.selectYeta3130List_D", searchVO);
    }

    /**
	 * YETA3130 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3130 총 갯수
	 * @exception
	 */
    public int selectYeta3130ListTotCnt(Yeta3130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3130DAO.selectYeta3130ListTotCnt_S", searchVO);
    }

}
