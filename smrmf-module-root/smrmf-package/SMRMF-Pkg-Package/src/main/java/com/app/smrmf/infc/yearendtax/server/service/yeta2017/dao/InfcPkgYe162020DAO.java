package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162020DAO.java
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

@Repository("InfcPkgYe162020DAO")
public class InfcPkgYe162020DAO extends EgovAbstractDAO {

	
	//퇴직연금 
	@Transactional
    public String PdfYeta2200_F102Y_YE162020_Delete(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
           delete("infcPkgYe162020DAO.PdfYeta2200_F102Y_YE162020_Delete_S", infcPkgYe162020Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta2200_F102Y_YE162020_Insert(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
        return (String)insert("infcPkgYe162020DAO.PdfYeta2200_F102Y_YE162020_Insert_S", infcPkgYe162020Vo);
    }
	
	//F_퇴직연금계좌명세 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2017_Ye162020_Insert(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
        return (String)insert("infcPkgYe162020DAO.incTaxDeducDec_nts_Yeta2017_Ye162020_Insert_S", infcPkgYe162020Vo);
    }
	 
	
	
	  public List<?> fnYeta2300_YE162020_Tax_2017_A01_Select(InfcPkgYe162020SrhVO infcPkgYe162020Vo) throws Exception {
	        return list("infcPkgYe162020DAO.selectYeta2300_Tax_Ye162020_01_List_D", infcPkgYe162020Vo);
	    }
		 
	    public int updateYeta2300_Tax_Ye162020_01(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
	    	return update("infcPkgYe162020DAO.updateYeta2300_Tax_Ye162020_01_S", infcPkgYe162020Vo);
	    }   
		  
	    public int updateYeta2300_Tax_Ye162020_02(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
	    	return update("infcPkgYe162020DAO.updateYeta2300_Tax_Ye162020_02_S", infcPkgYe162020Vo);
	    }  
	   
	 
	/**
	 * YE162020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162020(InfcPkgYe162020VO vo) throws Exception {
        return (String)insert("infcPkgYe162020DAO.insertYe162020_S", vo);
    }

    /**
	 * YE162020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162020(InfcPkgYe162020VO vo) throws Exception {
        update("infcPkgYe162020DAO.updateYe162020_S", vo);
    }

    /**
	 * YE162020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162020(InfcPkgYe162020VO vo) throws Exception {
        delete("infcPkgYe162020DAO.deleteYe162020_S", vo);
    }

    /**
	 * YE162020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162020VO
	 * @return 조회?�� YE162020
	 * @exception Exception
	 */
    public InfcPkgYe162020VO selectYe162020(InfcPkgYe162020VO vo) throws Exception {
        return (InfcPkgYe162020VO) selectByPk("infcPkgYe162020DAO.selectYe162020_S", vo);
    }

    /**
	 * YE162020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162020 목록
	 * @exception Exception
	 */
    public List<?> selectYe162020List(InfcPkgYe162020SrhVO searchVO) throws Exception {
        return list("infcPkgYe162020DAO.selectYe162020List_D", searchVO);
    }

    /**
	 * YE162020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162020 �? �??��
	 * @exception
	 */
    public int selectYe162020ListTotCnt(InfcPkgYe162020SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162020DAO.selectYe162020ListTotCnt_S", searchVO);
    }

}
