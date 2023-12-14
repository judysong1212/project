package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3110SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3110VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3110DAO.java
 * @Description : Yeta3110 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3110DAO")
public class YetaPrc3110DAO extends EgovAbstractDAO {

	/**
	 * YETA3110을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3110VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3110(InfcPkgYeta3110VO vo) throws Exception {
        return (String)insert("yetaPrc3110DAO.insertYetaPrc3110_S", vo);
    }

    /**
	 * YETA3110을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3110VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3110(InfcPkgYeta3110VO vo) throws Exception {
        update("yetaPrc3110DAO.updateYetaPrc3110_S", vo);
    }

    /**
	 * YETA3110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3110VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3110(InfcPkgYeta3110VO vo) throws Exception {
        delete("yetaPrc3110DAO.deleteYetaPrc3110_S", vo);
    }

    /**
	 * YETA3110을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3110VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR435_CREATE_Delete(InfcPkgYeta3110VO vo) throws Exception {
        delete("yetaPrc3110DAO.fnPayr06430_PAYR435_CREATE_Delete_S", vo);
    }  
    
    
    /**
	 * YETA3110을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3110VO
	 * @return 조회한 YETA3110
	 * @exception Exception
	 */
	  
    public InfcPkgYeta3110VO selectYeta3110(InfcPkgYeta3110VO vo) throws Exception {
        return (InfcPkgYeta3110VO) selectByPk("yeta3110DAO.selectYeta3110_S", vo);
    }

    /**
	 * YETA3110 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3110 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3110List(InfcPkgYeta3110SrhVO searchVO) throws Exception {
        return list("yetaPrc3110DAO.selectYetaPrc3110List_D", searchVO);
    }

    /**
	 * YETA3110 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3110 총 갯수
	 * @exception
	 */
    public int selectYeta3110ListTotCnt(InfcPkgYeta3110SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3110DAO.selectYetaPrc3110ListTotCnt_S", searchVO);
    }

}
