package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3140SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3140VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3140DAO.java
 * @Description : Yeta3140 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3140DAO")
public class Yeta3140DAO extends EgovAbstractDAO {
	
	
	
	/**
	 * YETA3140을 등록한다.(의료비내역등록 팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3140VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03002To3140(Yeta3140VO vo) throws Exception {
        return (String)insert("yeta3140DAO.insertYeta3140_S", vo);
    }

    /**
	 * YETA3140을 수정한다.(의료비내역등록 팝업)
	 * @param vo - 수정할 정보가 담긴 Yeta3140VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03002To3140(Yeta3140VO vo) throws Exception {
        update("yeta3140DAO.updateYeta3140_S", vo);
    }

    /**
	 * YETA3140을 삭제한다.(의료비내역등록 팝업)
	 * @param vo - 삭제할 정보가 담긴 Yeta3140VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03002To3140(Yeta3140VO vo) throws Exception {
        delete("yeta3140DAO.deleteYeta3140_S", vo);
    }
    

    /**
	 * YETA3140 총 갯수를 조회한다.(의료비내역등록 팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3140 총 갯수
	 * @exception
	 */
    public int selectYetaP03002To3140ListTotCnt(Yeta3140SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3140DAO.selectYetaP03002To3140ListTotCnt_S", searchVO);
    }
    
    /**
	 * YETA3140 목록을 조회한다.(의료비내역등록 팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3140 목록
	 * @exception Exception
	 */
    public List selectYetaP03002To3140List(Yeta3140SrhVO searchVO) throws Exception {
        return list("yeta3140DAO.selectYetaP03002To3140List_D", searchVO);
    }
    
	
	
	

	/**
	 * YETA3140을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3140VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3140(Yeta3140VO vo) throws Exception {
        return (String)insert("yeta3140DAO.insertYeta3140_S", vo);
    }

    /**
	 * YETA3140을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3140VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3140(Yeta3140VO vo) throws Exception {
        update("yeta3140DAO.updateYeta3140_S", vo);
    }

    /**
	 * YETA3140을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3140VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3140(Yeta3140VO vo) throws Exception {
        delete("yeta3140DAO.deleteYeta3140_S", vo);
    }
    
    /**
	 * YETA3140을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3140VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR430_CREATE_Delete(Yeta3140VO vo) throws Exception {
        delete("yeta3140DAO.fnPayr06430_PAYR430_CREATE_Delete_S", vo);
    }
    
    

    /**
	 * YETA3140을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3140VO
	 * @return 조회한 YETA3140
	 * @exception Exception
	 */
    public Yeta3140VO selectYeta3140(Yeta3140VO vo) throws Exception {
        return (Yeta3140VO) selectByPk("yeta3140DAO.selectYeta3140_S", vo);
    }

    /**
	 * YETA3140 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3140 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3140List(Yeta3140SrhVO searchVO) throws Exception {
        return list("yeta3140DAO.selectYeta3140List_D", searchVO);
    }

    /**
	 * YETA3140 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3140 총 갯수
	 * @exception
	 */
    public int selectYeta3140ListTotCnt(Yeta3140SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3140DAO.selectYeta3140ListTotCnt_S", searchVO);
    }

}
