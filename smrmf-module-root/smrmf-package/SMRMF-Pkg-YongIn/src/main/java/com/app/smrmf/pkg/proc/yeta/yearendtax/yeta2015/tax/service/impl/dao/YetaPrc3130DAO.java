package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3130SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3130VO;

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

@Repository("YetaPrc3130DAO")
public class YetaPrc3130DAO extends EgovAbstractDAO {

	/**
	 * YETA3130을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3130(InfcPkgYeta3130VO vo) throws Exception {
        return (String)insert("yetaPrc3130DAO.insertYetaPrc3130_S", vo);
    }

    /**
	 * YETA3130을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3130VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3130(InfcPkgYeta3130VO vo) throws Exception {
        update("yetaPrc3130DAO.updateYetaPrc3130_S", vo);
    }

    /**
	 * YETA3130을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3130VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3130(InfcPkgYeta3130VO vo) throws Exception {
        delete("yetaPrc3130DAO.deleteYetaPrc3130_S", vo);
    }

    /**
	 * YETA3130을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3130VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR452_CREATE_Delete(InfcPkgYeta3130VO vo) throws Exception {
        delete("yetaPrc3130DAO.fnPayr06430_PAYR452_CREATE_Delete_S", vo);
    }
    
    /**
	 * YETA3130을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3130VO
	 * @return 조회한 YETA3130
	 * @exception Exception
	 */
    public InfcPkgYeta3130VO selectYeta3130(InfcPkgYeta3130VO vo) throws Exception {
        return (InfcPkgYeta3130VO) selectByPk("yeta3130DAO.selectYeta3130_S", vo);
    }

    /**
	 * YETA3130 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3130 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3130List(InfcPkgYeta3130SrhVO searchVO) throws Exception {
        return list("yetPrc3130DAO.selectYetaPrc3130List_D", searchVO);
    }

    /**
	 * YETA3130 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3130 총 갯수
	 * @exception
	 */
    public int selectYeta3130ListTotCnt(InfcPkgYeta3130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3130DAO.selectYetaPrc3130ListTotCnt_S", searchVO);
    }

}
