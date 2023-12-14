package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170VO;

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

@Repository("YetaPrc3170DAO")
public class YetaPrc3170DAO extends EgovAbstractDAO {

	/**
	 * YETA3170을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3170VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3170(InfcPkgYeta3170VO vo) throws Exception {
        return (String)insert("yetaPrc3170DAO.insertYetaPrc3170_S", vo);
    }

    /**
	 * YETA3170을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3170VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3170(InfcPkgYeta3170VO vo) throws Exception {
        update("yetaPrc3170DAO.updateYetaPrc3170_S", vo);
    }
    
	  @Transactional
    public int fnPayr06430_PAYR442_ReTax_2014_Update(InfcPkgYeta3170VO vo) throws Exception {
        return update("yetaPrc3170DAO.fnPayr06430_PAYR442_ReTax_2014_Update", vo);
    }
    

    /**
	 * YETA3170을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3170VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3170(InfcPkgYeta3170VO vo) throws Exception {
        delete("yetaPrc3170DAO.deleteYetaPrc3170_S", vo);
    }
    
    /**
	 * YETA3170을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3170VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR442_CREATE_Delete(InfcPkgYeta3170VO vo) throws Exception {
        delete("yetaPrc3170DAO.fnPayr06430_PAYR442_CREATE_Delete_S", vo);
    }

    
    /**
	 * YETA3170을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3170VO
	 * @return 조회한 YETA3170
	 * @exception Exception
	 */
    public InfcPkgYeta3170VO selectYeta3170(InfcPkgYeta3170VO vo) throws Exception {
        return (InfcPkgYeta3170VO) selectByPk("yetaPrc3170DAO.selectYetaPrc3170_S", vo);
    }
    
    
   
    
    /**
	 * YETA3170 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3170 목록
	 * @exception Exception
	 */
    public List  selectYeta3170List(InfcPkgYeta3170SrhVO searchVO) throws Exception {
        return list("yetaPrc3170DAO.selectYetaPrc3170List_D", searchVO);
    }
 
    
    public List  fnPayr06430_PAYR442_ReTax_2014_SelectFind(InfcPkgYeta3170SrhVO vo) throws Exception {
    	 return list("yetaPrc3170DAO.fnPayr06430_PAYR442_ReTax_2014_SelectFind", vo);
         
    }
    
    
    /**
	 * YETA3170 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3170 총 갯수
	 * @exception
	 */
    public int selectYeta3170ListTotCnt(InfcPkgYeta3170SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3170DAO.selectYetaPrc3170ListTotCnt_S", searchVO);
    }

}
