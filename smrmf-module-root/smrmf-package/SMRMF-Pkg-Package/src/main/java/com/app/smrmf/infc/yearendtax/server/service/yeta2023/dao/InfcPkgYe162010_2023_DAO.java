package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161090_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162010Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162020Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162030Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162040Srh_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162010_2023_DAO.java
 * @Description : Ye162010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2016.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162010_2023_DAO")
public class InfcPkgYe162010_2023_DAO extends EgovAbstractDAO {

	
	//개인연금저축 
	@Transactional
    public String PdfYeta8200_D101Y_YE162010_Insert(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
        return (String)insert("infcPkgYe162010_2023_DAO.PdfYeta8200_D101Y_YE162010_Insert_S", infcPkgYe162010Vo);
    }
	
	
	@Transactional
    public String PdfYeta8200_D101Y_YE162010_Delete(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
           delete("infcPkgYe162010_2023_DAO.PdfYeta8200_D101Y_YE162010_Delete_S", infcPkgYe162010Vo);
           
           return "";
    }	
	
	//연금저축 
	@Transactional
    public String PdfYeta8200_E102Y_YE162010_Insert(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
        return (String)insert("infcPkgYe162010_2023_DAO.PdfYeta8200_E102Y_YE162010_Insert_S", infcPkgYe162010Vo);
    }
	

	
	@Transactional
    public String PdfYeta8200_E102Y_YE162010_Delete(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
           delete("infcPkgYe162010_2023_DAO.PdfYeta8200_E102Y_YE162010_Delete_S", infcPkgYe162010Vo);
           
           return "";
    }	
	
	
	// F_연금저축계좌
	@Transactional
    public String incTaxDeducDec_nts_Yeta2023_Ye162010_Insert(InfcPkgYe162010_2023_VO infcPkgYe162010Vo) throws Exception {
        return (String)insert("infcPkgYe162010_2023_DAO.incTaxDeducDec_nts_Yeta2023_Ye162010_Insert_S", infcPkgYe162010Vo);
    }
	
    public List<?> fnYeta8300_YE162010_Tax_2023_A01_Select(InfcPkgYe162010Srh_2023_VO   ye162010SrhVo) throws Exception {
        return list("infcPkgYe162010_2023_DAO.selectYeta8300_Tax_Ye162010_01_List_D", ye162010SrhVo);
    }
	 
    public int updateYeta8300_Tax_Ye162010_01(InfcPkgYe162010_2023_VO vo) throws Exception {
    	return update("infcPkgYe162010_2023_DAO.updateYeta8300_Tax_Ye162010_01_S", vo);
    }   
    
    public int updateYeta8300_Tax_Ye162010_01_S(InfcPkgYe162010_2023_VO vo) throws Exception {
    	return update("infcPkgYe162010_2023_DAO.updateYeta8300_Tax_Ye162010_01_S_S", vo);
    } 
    
	  
    public int updateYeta8300_Tax_Ye162010_02(InfcPkgYe162010_2023_VO vo) throws Exception {
    	return update("infcPkgYe162010_2023_DAO.updateYeta8300_Tax_Ye162010_02_S", vo);
    }  
     
	   
	   
	
	/**
	 * YE162010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162010(InfcPkgYe162010_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe162010_2023_DAO.insertYe162010_S", vo);
    }

    /**
	 * YE162010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162010(InfcPkgYe162010_2023_VO vo) throws Exception {
        update("infcPkgYe162010_2023_DAO.updateYe162010_S", vo);
    }

    /**
	 * YE162010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162010(InfcPkgYe162010_2023_VO vo) throws Exception {
        delete("infcPkgYe162010_2023_DAO.deleteYe162010_S", vo);
    }

    /**
	 * YE162010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162010VO
	 * @return 조회?�� YE162010
	 * @exception Exception
	 */
    public InfcPkgYe162010_2023_VO selectYe162010(InfcPkgYe162010_2023_VO vo) throws Exception {
        return (InfcPkgYe162010_2023_VO) selectByPk("infcPkgYe162010_2023_DAO.selectYe162010_S", vo);
    }

    /**
	 * YE162010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162010 목록
	 * @exception Exception
	 */
    public List<?> selectYe162010List(InfcPkgYe162010Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe162010_2023_DAO.selectYe162010List_D", searchVO);
    }

    /**
	 * YE162010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162010 �? �??��
	 * @exception
	 */
    public int selectYe162010ListTotCnt(InfcPkgYe162010Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162010_2023_DAO.selectYe162010ListTotCnt_S", searchVO);
    }

}
