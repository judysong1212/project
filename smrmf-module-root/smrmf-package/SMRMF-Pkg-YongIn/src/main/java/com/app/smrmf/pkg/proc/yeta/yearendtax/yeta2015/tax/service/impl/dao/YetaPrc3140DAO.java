package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140VO;

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

@Repository("YetaPrc3140DAO")
public class YetaPrc3140DAO extends EgovAbstractDAO {

	/**
	 * YETA3140을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3140VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3140(InfcPkgYeta3140VO vo) throws Exception {
        return (String)insert("yetaPrc3140DAO.insertYetaPrc3140_S", vo);
    }
	  @Transactional
    public String fnPayr06430_PAYR430_2014_Insert(InfcPkgYeta3140VO vo) throws Exception {
        return (String)insert("yetaPrc3140DAO.fnPayr06430_PAYR430_2014_Insert", vo);
    } 
   
    /**
	 * YETA3140을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3140VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3140(InfcPkgYeta3140VO vo) throws Exception {
        update("yetaPrc3140DAO.updateYetaPrc3140_S", vo);
    }

    /**
	 * YETA3140을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3140VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3140(InfcPkgYeta3140VO vo) throws Exception {
        delete("yetaPrc3140DAO.deleteYetaPrc3140_S", vo);
    }
	  @Transactional
    public void fnPayr06430_PAYR430_2014_Delete(InfcPkgYeta3140VO vo) throws Exception {
        delete("yetaPrc3140DAO.fnPayr06430_PAYR430_2014_Delete", vo);
    }
   
    
    
    /**
	 * YETA3140을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3140VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR430_CREATE_Delete(InfcPkgYeta3140VO vo) throws Exception {
        delete("yetaPrc3140DAO.fnPayr06430_PAYR430_CREATE_Delete_S", vo);
    }
    
    

    /**
	 * YETA3140을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3140VO
	 * @return 조회한 YETA3140
	 * @exception Exception
	 */
	 
    public InfcPkgYeta3140VO selectYeta3140(InfcPkgYeta3140VO vo) throws Exception {
        return (InfcPkgYeta3140VO) selectByPk("yetaPrc3140DAO.selectYetaPrc3140_S", vo);
    }

    /**
	 * YETA3140 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3140 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3140List(InfcPkgYeta3140SrhVO searchVO) throws Exception {
        return list("yetaPrc3140DAO.selectYetaPrc3140List_D", searchVO);
    }

    /**
	 * YETA3140 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3140 총 갯수
	 * @exception
	 */
    public int selectYeta3140ListTotCnt(InfcPkgYeta3140SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3140DAO.selectYetaPrc3140ListTotCnt_S", searchVO);
    }

}
