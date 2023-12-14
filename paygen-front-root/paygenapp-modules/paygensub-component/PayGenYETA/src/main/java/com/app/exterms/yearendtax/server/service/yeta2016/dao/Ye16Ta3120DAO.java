package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3120SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3120VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3120DAO.java
 * @Description : Yeta3120 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta3120DAO")
public class Ye16Ta3120DAO extends EgovAbstractDAO implements IsSerializable {
	
	
    /**
	 * YETA3120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3120VO
	 * @return void형 
	 * @exception Exception
	 */
    public void fnYeta1100_YETA3120_2016_CREATE_Delete(Yeta3120VO vo) throws Exception {
        delete("ye16Ta3120DAO.fnYeta1100_YETA3120_2016_CREATE_Delete_S", vo);
    }
	
	
	
	
	/**
	 * YETA3120을 등록한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param vo - 등록할 정보가 담긴 Yeta3120VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03004To3120(Yeta3120VO vo) throws Exception {
        return (String)insert("ye16Ta3120DAO.insertYeta3120_S", vo);
    }

    /**
	 * YETA3120을 수정한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param vo - 수정할 정보가 담긴 Yeta3120VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03004To3120(Yeta3120VO vo) throws Exception {
        update("ye16Ta3120DAO.updateYeta3120_S", vo);
    }

    /**
	 * YETA3120을 삭제한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param vo - 삭제할 정보가 담긴 Yeta3120VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03004To3120(Yeta3120VO vo) throws Exception {
        delete("ye16Ta3120DAO.deleteYeta3120_S", vo);
    }
    
    /**
	 * YETA3120 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3120 목록
	 * @exception Exception
	 */
    public List selectYetaP03004To3120List(Yeta3120SrhVO searchVO) throws Exception {
        return list("ye16Ta3120DAO.selectYetaP03004To3120List_D", searchVO);
    }

    /**
	 * YETA3120 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3120 총 갯수
	 * @exception
	 */
    public int selectYetaP03004To3120ListTotCnt(Yeta3120SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3120DAO.selectYetaP03004To3120ListTotCnt_S", searchVO);
    }

	
	
	
	
	
	

	/**
	 * YETA3120을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3120VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta3120(Yeta3120VO vo) throws Exception {
        return (String)insert("ye16Ta3120DAO.insertYeta3120_S", vo);
    }

    /**
	 * YETA3120을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3120VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYeta3120(Yeta3120VO vo) throws Exception {
        update("ye16Ta3120DAO.updateYeta3120_S", vo);
    }

    /**
	 * YETA3120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3120VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYeta3120(Yeta3120VO vo) throws Exception {
        delete("ye16Ta3120DAO.deleteYeta3120_S", vo);
    }

    /**
	 * YETA3120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3120VO
	 * @return void형 
	 * @exception Exception
	 */
    public void fnPayr06430_PAYR450_CREATE_Delete(Yeta3120VO vo) throws Exception {
        delete("ye16Ta3120DAO.fnPayr06430_PAYR450_CREATE_Delete_S", vo);
    }
    
    /**
	 * YETA3120을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3120VO
	 * @return 조회한 YETA3120
	 * @exception Exception
	 */
    public Yeta3120VO selectYeta3120(Yeta3120VO vo) throws Exception {
        return (Yeta3120VO) selectByPk("ye16Ta3120DAO.selectYeta3120_S", vo);
    }

    /**
	 * YETA3120 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3120 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3120List(Yeta3120SrhVO searchVO) throws Exception {
        return list("ye16Ta3120DAO.selectYeta3120List_D", searchVO);
    }

    /**
	 * YETA3120 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3120 총 갯수
	 * @exception
	 */
    public int selectYeta3120ListTotCnt(Yeta3120SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3120DAO.selectYeta3120ListTotCnt_S", searchVO);
    }

}
