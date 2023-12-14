package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162040Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162510Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162510_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162520Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162520_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166030_2020_VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162510_2020_DAO.java
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

@Repository("InfcPkgYe162510_2020_DAO")
public class InfcPkgYe162510_2020_DAO extends EgovAbstractDAO implements IsSerializable {
	
	//월세액 소득공제반영 추가 20201230
	@Transactional
    public String PdfYeta5200_J501Y_YE162510_Insert(InfcPkgYe162510_2020_VO infcPkgYe162510Vo) throws Exception {
        return (String)insert("infcPkgYe162510_2020_DAO.PdfYeta5200_J501Y_YE162510_Insert_S", infcPkgYe162510Vo);
    }
	
	//월세액 소득공제반영 추가 20201230
	@Transactional
	public String PdfYeta5200_J501Y_YE162510_Delete(InfcPkgYe162510_2020_VO infcPkgYe162510Vo) throws Exception {
        delete("infcPkgYe162510_2020_DAO.PdfYeta5200_J501Y_YE162510_Delete_S", infcPkgYe162510Vo);
        
        return "";
	}
	
	

	// G_월세액소득공제명세
 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2020_Ye162510_Insert(InfcPkgYe162510_2020_VO     infcPkgYe162510Vo) throws Exception {
        return (String)insert("infcPkgYe162510_2020_DAO.incTaxDeducDec_nts_Yeta2020_Ye162510_Insert_S", infcPkgYe162510Vo);
    }
	
	
	  public List<?> fnYeta5300_YE162510_Tax_2020_A01_Select(InfcPkgYe162510Srh_2020_VO   ye162510SrhVo) throws Exception {
	        return list("infcPkgYe162510_2020_DAO.selectYeta5300_Tax_YE162510_01_List_D", ye162510SrhVo);
	    }
		 
	    public int updateYeta5300_Tax_Ye162510_01(InfcPkgYe162510_2020_VO vo) throws Exception {
	    	return update("infcPkgYe162510_2020_DAO.updateYeta5300_Tax_YE162510_01_S", vo);
	    }   
	 
	    
	    public int updateYeta5300_Tax_Ye162510_02(InfcPkgYe162510_2020_VO vo) throws Exception {
	    	return update("infcPkgYe162510_2020_DAO.updateYeta5300_Tax_Ye162510_02_S", vo);
	    }   
	 
	  
	/**
	 * YE162510을 등록한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 등록할 정보가 담긴 Ye162510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaT13019To162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe162510_2020_DAO.insertYe162510_S", vo);
    }

    /**
	 * YE162510을 수정한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 수정할 정보가 담긴 Ye162510VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaT13019To162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        update("infcPkgYe162510_2020_DAO.updateYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Ye162510VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaT13019To162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        delete("infcPkgYe162510_2020_DAO.deleteYe162510_S", vo);
    }
    
//    /**
//	 * YE162510 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YE162510 목록
//	 * @exception Exception
//	 */
//    public List selectYetaP03004To162510List(Ye162510Srh_2020_VO searchVO) throws Exception {
//        return list("infcPkgYe162510_2020_DAO.selectYetaP03004To162510List_D", searchVO);
//    }
//
//    /**
//	 * YE162510 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return YE162510 총 갯수
//	 * @exception
//	 */
//    public int selectYetaP03004To162510ListTotCnt(Ye162510Srh_2020_VO searchVO) {
//        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162510_2020_DAO.selectYetaP03004To162510ListTotCnt_S", searchVO);
//    }
    
    
 
    /**
	 * YE162510 목록을 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 목록
	 * @exception Exception
	 */
    public List selectYeT13019To162510List(InfcPkgYe162510Srh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe162510_2020_DAO.selectYeT13019To162510List_D", searchVO);
    }
   
    /**
	 * YE162510 총 갯수를 조회한다.(거주자간 주택임차차입금 원리금 상환액 팝업 - 임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 총 갯수
	 * @exception
	 */
    public int selectYetaT13019To162510ListTotCnt(InfcPkgYe162510Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162510_2020_DAO.selectYetaT13019To162510ListTotCnt_S", searchVO);
    }
    
    
	

	/**
	 * YE162510을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Ye162510VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYe162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe162510_2020_DAO.insertYe162510_S", vo);
    }

    /**
	 * YE162510을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Ye162510VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYe162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        update("infcPkgYe162510_2020_DAO.updateYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYe162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        delete("infcPkgYe162510_2020_DAO.deleteYe162510_S", vo);
    }

    /**
	 * YE162510을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162510VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR452_CREATE_Delete(InfcPkgYe162510_2020_VO vo) throws Exception {
        delete("infcPkgYe162510_2020_DAO.fnPayr06430_PAYR452_CREATE_Delete_S", vo);
    }
    
    /**
	 * YE162510을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Ye162510VO
	 * @return 조회한 YE162510
	 * @exception Exception
	 */
    public InfcPkgYe162510_2020_VO selectYe162510(InfcPkgYe162510_2020_VO vo) throws Exception {
        return (InfcPkgYe162510_2020_VO) selectByPk("infcPkgYe162510_2020_DAO.selectYe162510_S", vo);
    }

    /**
	 * YE162510 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 목록
	 * @exception Exception
	 */
    public List<?> selectYe162510List(InfcPkgYe162510Srh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe162510_2020_DAO.selectYe162510List_D", searchVO);
    }

    /**
	 * YE162510 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162510 총 갯수
	 * @exception
	 */
    public int selectYe162510ListTotCnt(InfcPkgYe162510Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162510_2020_DAO.selectYe162510ListTotCnt_S", searchVO);
    }

}