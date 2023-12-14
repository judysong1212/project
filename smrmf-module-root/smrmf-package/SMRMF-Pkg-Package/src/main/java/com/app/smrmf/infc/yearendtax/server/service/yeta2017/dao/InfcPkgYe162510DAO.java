package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162510DAO.java
 * @Description : Ye162510 DAO Class
 * @Modification Information
 *
 * @author Kim ji eun
 * @since 2016.12.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162510DAO")
public class InfcPkgYe162510DAO extends EgovAbstractDAO implements IsSerializable {
	
	

	// G_월세액소득공제명세
 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2017_Ye162510_Insert(InfcPkgYe162510VO     infcPkgYe162510Vo) throws Exception {
        return (String)insert("infcPkgYe162510DAO.incTaxDeducDec_nts_Yeta2017_Ye162510_Insert_S", infcPkgYe162510Vo);
    }
	
	
	  public List<?> fnYeta2300_YE162510_Tax_2017_A01_Select(InfcPkgYe162510SrhVO   ye162510SrhVo) throws Exception {
	        return list("infcPkgYe162510DAO.selectYeta2300_Tax_YE162510_01_List_D", ye162510SrhVo);
	    }
		 
	    public int updateYeta2300_Tax_Ye162510_01(InfcPkgYe162510VO vo) throws Exception {
	    	return update("infcPkgYe162510DAO.updateYeta2300_Tax_YE162510_01_S", vo);
	    }   
	 
	    
	    public int updateYeta2300_Tax_Ye162510_02(InfcPkgYe162510VO vo) throws Exception {
	    	return update("infcPkgYe162510DAO.updateYeta2300_Tax_Ye162510_02_S", vo);
	    }   
	 
	  
	/**
	 * YE162510을 등록한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 등록할 정보가 담긴 Ye162510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaT13019To162510(InfcPkgYe162510VO vo) throws Exception {
        return (String)insert("infcPkgYe162510DAO.insertYe162510_S", vo);
    }

    /**
	 * YE162510을 수정한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 수정할 정보가 담긴 Ye162510VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaT13019To162510(InfcPkgYe162510VO vo) throws Exception {
        update("infcPkgYe162510DAO.updateYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Ye162510VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaT13019To162510(InfcPkgYe162510VO vo) throws Exception {
        delete("infcPkgYe162510DAO.deleteYe162510_S", vo);
    }
    
//    /**
//	 * YE162510 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YE162510 목록
//	 * @exception Exception
//	 */
//    public List selectYetaP03004To162510List(Ye162510SrhVO searchVO) throws Exception {
//        return list("infcPkgYe162510DAO.selectYetaP03004To162510List_D", searchVO);
//    }
//
//    /**
//	 * YE162510 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YE162510 총 갯수
//	 * @exception
//	 */
//    public int selectYetaP03004To162510ListTotCnt(Ye162510SrhVO searchVO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162510DAO.selectYetaP03004To162510ListTotCnt_S", searchVO);
//    }
    
    
 
    /**
	 * YE162510 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 목록
	 * @exception Exception
	 */
    public List selectYeT13019To162510List(InfcPkgYe162510SrhVO searchVO) throws Exception {
        return list("infcPkgYe162510DAO.selectYeT13019To162510List_D", searchVO);
    }
   
    /**
	 * YE162510 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 총 갯수
	 * @exception
	 */
    public int selectYetaT13019To162510ListTotCnt(InfcPkgYe162510SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162510DAO.selectYetaT13019To162510ListTotCnt_S", searchVO);
    }
    
    
	

	/**
	 * YE162510을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Ye162510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYe162510(InfcPkgYe162510VO vo) throws Exception {
        return (String)insert("infcPkgYe162510DAO.insertYe162510_S", vo);
    }

    /**
	 * YE162510을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Ye162510VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYe162510(InfcPkgYe162510VO vo) throws Exception {
        update("infcPkgYe162510DAO.updateYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYe162510(InfcPkgYe162510VO vo) throws Exception {
        delete("infcPkgYe162510DAO.deleteYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR452_CREATE_Delete(InfcPkgYe162510VO vo) throws Exception {
        delete("infcPkgYe162510DAO.fnPayr06430_PAYR452_CREATE_Delete_S", vo);
    }
    
    /**
	 * YE162510을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Ye162510VO
	 * @return 조회한 YE162510
	 * @exception Exception
	 */
    public InfcPkgYe162510VO selectYe162510(InfcPkgYe162510VO vo) throws Exception {
        return (InfcPkgYe162510VO) selectByPk("infcPkgYe162510DAO.selectYe162510_S", vo);
    }

    /**
	 * YE162510 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 목록
	 * @exception Exception
	 */
    public List<?> selectYe162510List(InfcPkgYe162510SrhVO searchVO) throws Exception {
        return list("infcPkgYe162510DAO.selectYe162510List_D", searchVO);
    }

    /**
	 * YE162510 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 총 갯수
	 * @exception
	 */
    public int selectYe162510ListTotCnt(InfcPkgYe162510SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162510DAO.selectYe162510ListTotCnt_S", searchVO);
    }

}
