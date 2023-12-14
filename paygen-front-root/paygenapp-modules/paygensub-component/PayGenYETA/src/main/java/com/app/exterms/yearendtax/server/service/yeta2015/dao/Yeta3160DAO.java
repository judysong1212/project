package com.app.exterms.yearendtax.server.service.yeta2015.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3160SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3160VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3160DAO.java
 * @Description : Yeta3160 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Yeta3160DAO")
public class Yeta3160DAO extends EgovAbstractDAO {

	/**
	 * YETA3160을 등록한다.(임대차계약)
	 * @param vo - 등록할 정보가 담긴 Yeta3160VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03004To3160(Yeta3160VO vo) throws Exception {
        return (String)insert("yeta3160DAO.insertYeta3160_S", vo);
    }

    /**
	 * YETA3160을 수정한다.(임대차계약)
	 * @param vo - 수정할 정보가 담긴 Yeta3160VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03004To3160(Yeta3160VO vo) throws Exception {
        update("yeta3160DAO.updateYeta3160_S", vo);
    }

    /**
	 * YETA3160을 삭제한다.(임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Yeta3160VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03004To3160(Yeta3160VO vo) throws Exception {
        delete("yeta3160DAO.deleteYeta3160_S", vo);
    }
    
    /**
	 * YETA3160을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3160VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR451_CREATE_Delete(Yeta3160VO vo) throws Exception {
        delete("yeta3160DAO.fnPayr06430_PAYR451_CREATE_Delete_S", vo);
    } 

    /**
	 * YETA3160을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3160VO
	 * @return 조회한 YETA3160
	 * @exception Exception
	 */
    public Yeta3160VO selectYeta3160(Yeta3160VO vo) throws Exception {
        return (Yeta3160VO) selectByPk("yeta3160DAO.selectYeta3160_S", vo);
    }

    /**
	 * YETA3160 목록을 조회한다.(임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3160 목록
	 * @exception Exception
	 */
    public List selectYetaP03004To3160List(Yeta3160SrhVO searchVO) throws Exception {
        return list("yeta3160DAO.selectYeta3160List_D", searchVO);
    }

    /**
	 * YETA3160 총 갯수를 조회한다.(임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3160 총 갯수
	 * @exception
	 */
    public int selectYetaP03004To3160ListTotCnt(Yeta3160SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yeta3160DAO.selectYeta3160ListTotCnt_S", searchVO);
    }

}
