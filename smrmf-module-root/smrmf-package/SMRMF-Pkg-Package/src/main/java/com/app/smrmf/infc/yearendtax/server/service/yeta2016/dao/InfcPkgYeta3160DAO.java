package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3160SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3160VO;

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

@Repository("InfcPkgYeta3160DAO")
public class InfcPkgYeta3160DAO extends EgovAbstractDAO {

	/**
	 * YETA3160을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3160VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3160(InfcPkgYeta3160VO vo) throws Exception {
        return (String)insert("infcPkgYeta3160DAO.insertYetaPrc3160_S", vo);
    }

    /**
	 * YETA3160을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3160VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3160(InfcPkgYeta3160VO vo) throws Exception {
        update("infcPkgYeta3160DAO.updateYetaPrc3160_S", vo);
    }

    /**
	 * YETA3160을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3160VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3160(InfcPkgYeta3160VO vo) throws Exception {
        delete("infcPkgYeta3160DAO.deleteYetaPrc3160_S", vo);
    }
    
    /**
	 * YETA3160을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3160VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR451_CREATE_Delete(InfcPkgYeta3160VO vo) throws Exception {
        delete("infcPkgYeta3160DAO.fnPayr06430_PAYR451_CREATE_Delete_S", vo);
    } 

    /**
	 * YETA3160을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3160VO
	 * @return 조회한 YETA3160
	 * @exception Exception
	 */
    public InfcPkgYeta3160VO selectYeta3160(InfcPkgYeta3160VO vo) throws Exception {
        return (InfcPkgYeta3160VO) selectByPk("infcPkgYeta3160DAO.selectYetaPrc3160_S", vo);
    }

    /**
	 * YETA3160 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3160 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3160List(InfcPkgYeta3160SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3160DAO.selectYetaPrc3160List_D", searchVO);
    }

    /**
	 * YETA3160 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3160 총 갯수
	 * @exception
	 */
    public int selectYeta3160ListTotCnt(InfcPkgYeta3160SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3160DAO.selectYetaPrc3160ListTotCnt_S", searchVO);
    }

}
