package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

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

@Repository("YetaPrc3150DAO")
public class YetaPrc3150DAO extends EgovAbstractDAO {

	/**
	 * YETA3150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        return (String)insert("yetaPrc3150DAO.insertYetaPrc3150_S", vo);
    }
	  @Transactional
    public String fnPayr06430_PAYR445_1_2014_Insert(InfcPkgYeta3150VO vo) throws Exception {
        return (String)insert("yetaPrc3150DAO.fnPayr06430_PAYR445_1_2014_Insert", vo);
    }   
    

    /**
	 * YETA3150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3150VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        update("yetaPrc3150DAO.updateYetaPrc3150_S", vo);
    }

    /**
	 * YETA3150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3150VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3150(InfcPkgYeta3150VO vo) throws Exception {
        delete("yetaPrc3150DAO.deleteYetaPrc3150_S", vo);
    }

	  @Transactional
    public void fnPayr06430_PAYR445_2014_Delete(InfcPkgYeta3150VO vo) throws Exception {
        delete("yetaPrc3150DAO.fnPayr06430_PAYR445_2014_Delete", vo);
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
        return (InfcPkgYeta3150VO) selectByPk("yetaPrc3150DAO.selectYetaPrc3150_S", vo);
    }

    /**
	 * YETA3150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3150List(InfcPkgYeta3150SrhVO searchVO) throws Exception {
        return list("yetaPrc3150DAO.selectYetaPrc3150List_D", searchVO);
    }

    /**
	 * YETA3150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3150 총 갯수
	 * @exception
	 */
    public int selectYeta3150ListTotCnt(InfcPkgYeta3150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3150DAO.selectYetaPrc3150ListTotCnt_S", searchVO);
    }

}
