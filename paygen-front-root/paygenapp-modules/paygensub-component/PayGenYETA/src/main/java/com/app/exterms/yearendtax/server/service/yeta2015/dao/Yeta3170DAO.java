package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3170SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3170VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3170DAO.java
 * @Description : Yeta3170 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3170DAO")
public class Yeta3170DAO extends EgovAbstractDAO implements IsSerializable {
	
	
	/**
	 * YETA3170을 등록한다.(이월기부금등록 팝업)
	 * @param vo - 등록할 정보가 담긴 Yeta3170VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03001To3170(Yeta3170VO vo) throws Exception {
        return (String)insert("yeta3170DAO.insertYeta3170_S", vo);
    }

    /**
	 * YETA3170을 수정한다.(이월기부금등록 팝업)
	 * @param vo - 수정할 정보가 담긴 Yeta3170VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03001To3170(Yeta3170VO vo) throws Exception {
        update("yeta3170DAO.updateYeta3170_S", vo);
    }

    /**
	 * YETA3170을 삭제한다.(이월기부금등록 팝업)
	 * @param vo - 삭제할 정보가 담긴 Yeta3170VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03001To3170(Yeta3170VO vo) throws Exception {
        delete("yeta3170DAO.deleteYeta3170_S", vo);
    }
	
	
	
	
	

	/**
	 * YETA3170을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3170VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3170(Yeta3170VO vo) throws Exception {
        return (String)insert("yeta3170DAO.insertYeta3170_S", vo);
    }

    /**
	 * YETA3170을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3170VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3170(Yeta3170VO vo) throws Exception {
        update("yeta3170DAO.updateYeta3170_S", vo);
    }

    /**
	 * YETA3170을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3170VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3170(Yeta3170VO vo) throws Exception {
        delete("yeta3170DAO.deleteYeta3170_S", vo);
    }
    
    /**
	 * YETA3170을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3170VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR442_CREATE_Delete(Yeta3170VO vo) throws Exception {
        delete("yeta3170DAO.fnPayr06430_PAYR442_CREATE_Delete_S", vo);
    }
    
    
    /**
	 * YETA3170 총 갯수를 조회한다.(이월기부금 팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3170 총 갯수
	 * @exception
	 */
    public int selectYetaP03001To3170ListTotCnt(Yeta3170SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3170DAO.selectYetaP03001To3170listTotCnt_S", searchVO);
    }
    
    /**
	 * YETA3170 목록을 조회한다.(이월기부금 팝업)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3170 목록
	 * @exception Exception
	 */
    public List selectYetaP03001To3170List(Yeta3170SrhVO searchVO) throws Exception {
        return list("yeta3170DAO.selectYetaP03001To3170list_D", searchVO);
    }
    
    

    
    /**
	 * YETA3170을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3170VO
	 * @return 조회한 YETA3170
	 * @exception Exception
	 */
    public Yeta3170VO selectYeta3170(Yeta3170VO vo) throws Exception {
        return (Yeta3170VO) selectByPk("yeta3170DAO.selectYeta3170_S", vo);
    }

    /**
	 * YETA3170 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3170 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3170List(Yeta3170SrhVO searchVO) throws Exception {
        return list("yeta3170DAO.selectYeta3170List_D", searchVO);
    }

    /**
	 * YETA3170 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3170 총 갯수
	 * @exception
	 */
    public int selectYeta3170ListTotCnt(Yeta3170SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3170DAO.selectYeta3170ListTotCnt_S", searchVO);
    }

}
