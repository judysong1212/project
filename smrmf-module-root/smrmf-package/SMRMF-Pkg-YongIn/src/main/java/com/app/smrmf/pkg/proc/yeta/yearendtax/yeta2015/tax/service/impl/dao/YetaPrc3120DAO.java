package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3120SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3120VO;

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

@Repository("YetaPrc3120DAO")
public class YetaPrc3120DAO extends EgovAbstractDAO {

	/**
	 * YETA3120을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3120VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3120(InfcPkgYeta3120VO vo) throws Exception {
        return (String)insert("yetaPrc3120DAO.insertYetaPrc3120_S", vo);
    }

    /**
	 * YETA3120을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3120VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3120(InfcPkgYeta3120VO vo) throws Exception {
        update("yetaPrc3120DAO.updateYetaPrc3120_S", vo);
    }

    /**
	 * YETA3120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3120VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3120(InfcPkgYeta3120VO vo) throws Exception {
        delete("yetaPrc3120DAO.deleteYetPrc3120_S", vo);
    }

    /**
	 * YETA3120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3120VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR450_CREATE_Delete(InfcPkgYeta3120VO vo) throws Exception {
        delete("yetaPrc3120DAO.fnPayr06430_PAYR450_CREATE_Delete_S", vo);
    }
    
    /**
	 * YETA3120을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3120VO
	 * @return 조회한 YETA3120
	 * @exception Exception
	 */
	  
    public InfcPkgYeta3120VO selectYeta3120(InfcPkgYeta3120VO vo) throws Exception {
        return (InfcPkgYeta3120VO) selectByPk("yetaPrc3120DAO.selectYetaPrc3120_S", vo);
    }

    /**
	 * YETA3120 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3120 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3120List(InfcPkgYeta3120SrhVO searchVO) throws Exception {
        return list("yetaPrc3120DAO.selectYetaPrc3120List_D", searchVO);
    }

    /**
	 * YETA3120 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3120 총 갯수
	 * @exception
	 */
    public int selectYeta3120ListTotCnt(InfcPkgYeta3120SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3120DAO.selectYetaPrc3120ListTotCnt_S", searchVO);
    }

}
