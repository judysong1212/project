package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3300SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3300DAO.java
 * @Description : Yeta3300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYeta3300DAO")
public class InfcPkgYeta3300DAO extends EgovAbstractDAO {

	/**
	 * YETA3300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3300(InfcPkgYeta3300VO vo) throws Exception {
        return (String)insert("infcPkgYeta3300DAO.insertYetaPrc3300_S", vo);
    }

    /**
	 * YETA3300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3300VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3300(InfcPkgYeta3300VO vo) throws Exception {
        update("infcPkgYeta3300DAO.updateYetaPrc3300_S", vo);
    }

    /**
	 * YETA3300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3300VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3300(InfcPkgYeta3300VO vo) throws Exception {
        delete("infcPkgYeta3300DAO.deleteYetaPrc3300_S", vo);
    }

    /**
	 * YETA3300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3300VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_Yeta3300_CREATE_Delete(InfcPkgYeta3300VO vo) throws Exception {
        delete("infcPkgYeta3300DAO.fnPayr06430_Yeta3300_CREATE_Delete_S", vo);
    } 
    
    /**
	 * YETA3300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3300VO
	 * @return 조회한 YETA3300
	 * @exception Exception
	 */
	  
    public InfcPkgYeta3300VO selectYeta3300(InfcPkgYeta3300VO vo) throws Exception {
        return (InfcPkgYeta3300VO) selectByPk("infcPkgYeta3300DAO.selectYetaPrc3300_S", vo);
    }

    /**
	 * YETA3300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3300 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3300List(InfcPkgYeta3300SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3300DAO.selectYetaPrc3300List_D", searchVO);
    }

    /**
	 * YETA3300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3300 총 갯수
	 * @exception
	 */
    public int selectYeta3300ListTotCnt(InfcPkgYeta3300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3300DAO.selectYetaPrc3300ListTotCnt_S", searchVO);
    }

}
