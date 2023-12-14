package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3000DAO.java
 * @Description : Yeta3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3000DAO")
public class YetaPrc3000DAO extends EgovAbstractDAO {

	/**
	 * YETA3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        return (String)insert("yetaPrc3000DAO.insertYetaPrc3000_S", vo);
    }
	  @Transactional
    public String fnPayr06430_PAYR425_2014_CREATE_Insert(InfcPkgYeta2000VO vo) throws Exception {
        return (String)insert("yetaPrc3000DAO.fnPayr06430_PAYR425_2014_CREATE_Insert_S", vo);
    } 
    

    /**
	 * YETA3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        update("yetaPrc3000DAO.updateYetaPrc3000_S", vo);
    }
	  @Transactional
    public void fnPayr06530_PAYR425_2015_CREATE1_Update(InfcPkgYeta2000VO vo) throws Exception {
        update("yetaPrc3000DAO.fnPayr06530_PAYR425_2015_CREATE1_Update", vo);
    }
    
    /**
	 * YETA3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        delete("yetaPrc3000DAO.deleteYetaPrc3000_S", vo);
    }
    
    /**
 	 * YETA3000을 삭제한다.
 	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
 	 * @return void형 
 	 * @exception Exception
 	 */
	  @Transactional
     public void fnPayr06430_PAYR425_CREATE_Delete(InfcPkgYeta3000VO vo) throws Exception {
         delete("yetaPrc3000DAO.fnPayr06430_PAYR425_CREATE_Delete_S", vo);
     }
    
    /**
	 * YETA3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3000VO
	 * @return 조회한 YETA3000
	 * @exception Exception
	 */
    public InfcPkgYeta3000VO selectYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        return (InfcPkgYeta3000VO) selectByPk("yetaPrc3000DAO.selectYetaPrc3000_S", vo);
    }

    
    public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2014_SPCI_Select_Update(InfcPkgYeta3000VO vo) throws Exception {
        return (InfcPkgYeta3000VO) selectByPk("yetaPrc3000DAO.fnPayr06430_PAYR425_ReTax_2014_SPCI_Select_Update", vo);
    }
     
    
    /**
	 * YETA3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3000List(InfcPkgYeta3000SrhVO searchVO) throws Exception {
        return list("yetaPrc3000DAO.selectYetaPrc3000List_D", searchVO);
    }

    /**
	 * YETA3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 총 갯수
	 * @exception
	 */
    public int selectYeta3000ListTotCnt(InfcPkgYeta3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3000DAO.selectYetaPrc3000ListTotCnt_S", searchVO);
    }

}
