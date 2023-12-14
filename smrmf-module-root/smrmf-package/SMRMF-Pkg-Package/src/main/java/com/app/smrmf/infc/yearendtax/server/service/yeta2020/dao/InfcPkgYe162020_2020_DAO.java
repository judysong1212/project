package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161080_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162010Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162020Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162030Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162040Srh_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162020_2020_DAO.java
 * @Description : Ye162020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 20178.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162020_2020_DAO")
public class InfcPkgYe162020_2020_DAO extends EgovAbstractDAO {

	
	//퇴직연금 
	@Transactional
    public String PdfYeta5200_F102Y_YE162020_Delete(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception {
           delete("infcPkgYe162020_2020_DAO.PdfYeta5200_F102Y_YE162020_Delete_S", infcPkgYe162020Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta5200_F102Y_YE162020_Insert(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception {
        return (String)insert("infcPkgYe162020_2020_DAO.PdfYeta5200_F102Y_YE162020_Insert_S", infcPkgYe162020Vo);
    }
	
	//F_퇴직연금계좌명세 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2020_Ye162020_Insert(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception {
        return (String)insert("infcPkgYe162020_2020_DAO.incTaxDeducDec_nts_Yeta2020_Ye162020_Insert_S", infcPkgYe162020Vo);
    }
	 
	
	
	  public List<?> fnYeta5300_YE162020_Tax_2020_A01_Select(InfcPkgYe162020Srh_2020_VO infcPkgYe162020Vo) throws Exception {
	        return list("infcPkgYe162020_2020_DAO.selectYeta5300_Tax_Ye162020_01_List_D", infcPkgYe162020Vo);
	    }
		 
	    public int updateYeta5300_Tax_Ye162020_01(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception {
	    	return update("infcPkgYe162020_2020_DAO.updateYeta5300_Tax_Ye162020_01_S", infcPkgYe162020Vo);
	    }   
		  
	    public int updateYeta5300_Tax_Ye162020_02(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception {
	    	return update("infcPkgYe162020_2020_DAO.updateYeta5300_Tax_Ye162020_02_S", infcPkgYe162020Vo);
	    }  
	   
	 
	/**
	 * YE162020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162020(InfcPkgYe162020_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe162020_2020_DAO.insertYe162020_S", vo);
    }

    /**
	 * YE162020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162020(InfcPkgYe162020_2020_VO vo) throws Exception {
        update("infcPkgYe162020_2020_DAO.updateYe162020_S", vo);
    }

    /**
	 * YE162020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162020(InfcPkgYe162020_2020_VO vo) throws Exception {
        delete("infcPkgYe162020_2020_DAO.deleteYe162020_S", vo);
    }

    /**
	 * YE162020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162020VO
	 * @return 조회?�� YE162020
	 * @exception Exception
	 */
    public InfcPkgYe162020_2020_VO selectYe162020(InfcPkgYe162020_2020_VO vo) throws Exception {
        return (InfcPkgYe162020_2020_VO) selectByPk("infcPkgYe162020_2020_DAO.selectYe162020_S", vo);
    }

    /**
	 * YE162020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162020 목록
	 * @exception Exception
	 */
    public List<?> selectYe162020List(InfcPkgYe162020Srh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe162020_2020_DAO.selectYe162020List_D", searchVO);
    }

    /**
	 * YE162020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162020 �? �??��
	 * @exception
	 */
    public int selectYe162020ListTotCnt(InfcPkgYe162020Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162020_2020_DAO.selectYe162020ListTotCnt_S", searchVO);
    }

}
