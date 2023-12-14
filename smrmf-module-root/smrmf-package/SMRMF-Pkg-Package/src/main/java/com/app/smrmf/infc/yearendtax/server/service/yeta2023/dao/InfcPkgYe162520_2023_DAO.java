package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162510Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162510_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162520Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162520_2023_VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162520_2023_DAO.java
 * @Description : Ye162520 DAO Class
 * @Modification Information
 *
 * @author Kim ji eun
 * @since 2016.12.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162520_2023_DAO")
public class InfcPkgYe162520_2023_DAO extends EgovAbstractDAO implements IsSerializable {
	
	// G_거주자간_금전소비대차
	 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2023_Ye162520_Insert(InfcPkgYe162520_2023_VO infcPkgYe162520Vo) throws Exception {
        return (String)insert("infcPkgYe162520_2023_DAO.incTaxDeducDec_nts_Yeta2023_Ye162520_Insert_S", infcPkgYe162520Vo);
    }
	
	
	  public List<?> fnYeta8300_YE162520_Tax_2023_A01_Select(InfcPkgYe162520Srh_2023_VO   ye162520SrhVo) throws Exception {
	        return list("infcPkgYe162520_2023_DAO.selectYeta8300_Tax_YE162520_01_List_D", ye162520SrhVo);
	    }
		 
	    public int updateYeta8300_Tax_Ye162520_01(InfcPkgYe162520_2023_VO vo) throws Exception {
	    	return update("infcPkgYe162520_2023_DAO.updateYeta8300_Tax_YE162520_01_S", vo);
	    }   
	 
	    
	   
	 
	/**
	 * YE162520을 등록한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param vo - 등록할 정보가 담긴 Ye162520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//	  @Transactional
//    public String insertYetaP03004To162520(Ye162520_2023_VO vo) throws Exception {
//        return (String)insert("infcPkgYe162520_2023_DAO.insertYe162520_S", vo);
//    }

    /**
	 * YE162520을 수정한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param vo - 수정할 정보가 담긴 Ye162520VO
	 * @return void형
	 * @exception Exception
	 */
//	  @Transactional
//    public void updateYetaP03004To162520(Ye162520_2023_VO vo) throws Exception {
//        update("infcPkgYe162520_2023_DAO.updateYe162520_S", vo);
//    }

    /**
	 * YE162520을 삭제한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param vo - 삭제할 정보가 담긴 Ye162520VO
	 * @return void형 
	 * @exception Exception
	 */
//	  @Transactional
//    public void deleteYetaP03004To162520(Ye162520_2023_VO vo) throws Exception {
//        delete("infcPkgYe162520_2023_DAO.deleteYe162520_S", vo);
//    }
    
	  
    /**
	 * YE162520 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162520 목록
	 * @exception Exception
	 */
    public List selectYetaP03004To162520List(InfcPkgYe162520_2023_VO searchVO) throws Exception {
        return list("infcPkgYe162520_2023_DAO.selectYetaP03004To162520List_D", searchVO);
    }

    /**
	 * YE162520 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 금전소비대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162520 총 갯수
	 * @exception
	 */
    public int selectYetaP03004To162520ListTotCnt(InfcPkgYe162520_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162520_2023_DAO.selectYetaP03004To162520ListTotCnt_S", searchVO);
    }

	
	
	
	
	
	

	/**
	 * YE162520을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Ye162520VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    public String insertYe162520(Ye162520_2023_VO vo) throws Exception {
//        return (String)insert("infcPkgYe162520_2023_DAO.insertYe162520_S", vo);
//    }

    /**
	 * YE162520을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Ye162520VO
	 * @return void형
	 * @exception Exception
	 */
//    public void updateYe162520(Ye162520_2023_VO vo) throws Exception {
//        update("infcPkgYe162520_2023_DAO.updateYe162520_S", vo);
//    }

    /**
	 * YE162520을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162520VO
	 * @return void형 
	 * @exception Exception
	 */
//    public void deleteYe162520(Ye162520_2023_VO vo) throws Exception {
//        delete("infcPkgYe162520_2023_DAO.deleteYe162520_S", vo);
//    }

    /**
	 * YE162520을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162520VO
	 * @return void형 
	 * @exception Exception
	 */
//    public void fnPayr06430_PAYR450_CREATE_Delete(Ye162520_2023_VO vo) throws Exception {
//        delete("infcPkgYe162520_2023_DAO.fnPayr06430_PAYR450_CREATE_Delete_S", vo);
//    }
    
    /**
	 * YE162520을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Ye162520VO
	 * @return 조회한 YE162520
	 * @exception Exception
	 */
//    public Ye162520_2023_VO selectYe162520(Ye162520_2023_VO vo) throws Exception {
//        return (Ye162520_2023_VO) selectByPk("infcPkgYe162520_2023_DAO.selectYe162520_S", vo);
//    }

    /**
	 * YE162520 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162520 목록
	 * @exception Exception
	 */
//    public List<?> selectYe162520List(Ye162520Srh_2023_VO searchVO) throws Exception {
//        return list("infcPkgYe162520_2023_DAO.selectYe162520List_D", searchVO);
//    }

    /**
	 * YE162520 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162520 총 갯수
	 * @exception
	 */
//    public int selectYe162520ListTotCnt(Ye162520Srh_2023_VO searchVO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162520_2023_DAO.selectYe162520ListTotCnt_S", searchVO);
//    }

}
