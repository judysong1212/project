package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3150DAO.java
 * @Description : Yeta3150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYeta3150DAO")
public class InfcPkgYeta3150DAO extends EgovAbstractDAO {

	/**
	 * YETA3150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        return (String)insert("infcPkgYeta3150DAO.insertYetaPrc3150_S", vo);
    }
	  @Transactional
    public String fnPayr06430_PAYR445_1_2015_Insert(InfcPkgYeta3150VO vo) throws Exception {
        return (String)insert("infcPkgYeta3150DAO.fnPayr06430_PAYR445_1_2015_Insert", vo);
    }   
    

    /**
	 * YETA3150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3150VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        update("infcPkgYeta3150DAO.updateYetaPrc3150_S", vo);
    }

    /**
	 * YETA3150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3150VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        delete("infcPkgYeta3150DAO.deleteYetaPrc3150_S", vo);
    }

	  @Transactional
    public void fnPayr06430_PAYR445_2015_Delete(InfcPkgYeta3150VO vo) throws Exception {
        delete("infcPkgYeta3150DAO.fnPayr06430_PAYR445_2015_Delete", vo);
    }
     
    /**
	 * YETA3150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3150VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR445_CREATE_Delete(InfcPkgYeta3150VO vo) throws Exception {
        delete("yetav3150DAO.fnPayr06430_PAYR445_CREATE_Delete_S", vo);
    }  
    

    /**
	 * YETA3150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3150VO
	 * @return 조회한 YETA3150
	 * @exception Exception
	 */
    public InfcPkgYeta3150VO selectYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        return (InfcPkgYeta3150VO) selectByPk("infcPkgYeta3150DAO.selectYetaPrc3150_S", vo);
    }

    /**
	 * YETA3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3150List(InfcPkgYeta3150SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3150DAO.selectYetaPrc3150List_D", searchVO);
    }

    /**
	 * YETA3150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 총 갯수
	 * @exception
	 */
    public int selectYeta3150ListTotCnt(InfcPkgYeta3150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3150DAO.selectYetaPrc3150ListTotCnt_S", searchVO);
    }

}
