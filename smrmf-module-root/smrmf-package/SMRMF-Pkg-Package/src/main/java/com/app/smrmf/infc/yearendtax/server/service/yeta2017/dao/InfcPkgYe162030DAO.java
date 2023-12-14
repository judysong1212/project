package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162030DAO.java
 * @Description : Ye162030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162030DAO")
public class InfcPkgYe162030DAO extends EgovAbstractDAO {

	//주택마련 
		@Transactional
	    public String PdfYeta2200_J301Y_YE162030_Delete(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception {
	           delete("infcPkgYe162030DAO.PdfYeta2200_J301Y_YE162030_Delete_S", infcPkgYe162030Vo);
	           
	           return "";
	    }	
		@Transactional
	    public String PdfYeta2200_J301Y_YE162030_Insert(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception {
	        return (String)insert("infcPkgYe162030DAO.PdfYeta2200_J301Y_YE162030_Insert_S", infcPkgYe162030Vo);
	    }
	  
	 
		 //F_주택마련저축
		
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2017_Ye162030_Insert(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception {
	        return (String)insert("infcPkgYe162030DAO.incTaxDeducDec_nts_Yeta2017_Ye162030_Insert_S", infcPkgYe162030Vo);
	    }
		 
		  public List<?> fnYeta2300_YE162030_Tax_2017_A01_Select(InfcPkgYe162030SrhVO infcPkgYe162030Vo) throws Exception {
		        return list("infcPkgYE162030DAO.selectYeta2300_Tax_YE162030_01_List_D", infcPkgYe162030Vo);
		    }
			 
		    public int updateYeta2300_Tax_YE162030_01(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception {
		    	return update("infcPkgYE162030DAO.updateYeta2300_Tax_YE162030_01_S", infcPkgYe162030Vo);
		    }   
			 
		 
			   
	/**
	 * YE162030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162030(InfcPkgYe162030VO vo) throws Exception {
        return (String)insert("infcPkgYe162030DAO.insertYe162030_S", vo);
    }

    /**
	 * YE162030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162030(InfcPkgYe162030VO vo) throws Exception {
        update("infcPkgYe162030DAO.updateYe162030_S", vo);
    }

    /**
	 * YE162030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162030(InfcPkgYe162030VO vo) throws Exception {
        delete("infcPkgYe162030DAO.deleteYe162030_S", vo);
    }

    /**
	 * YE162030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162030VO
	 * @return 조회?�� YE162030
	 * @exception Exception
	 */
    public InfcPkgYe162030VO selectYe162030(InfcPkgYe162030VO vo) throws Exception {
        return (InfcPkgYe162030VO) selectByPk("infcPkgYe162030DAO.selectYe162030_S", vo);
    }

    /**
	 * YE162030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162030 목록
	 * @exception Exception
	 */
    public List<?> selectYe162030List(InfcPkgYe162030SrhVO searchVO) throws Exception {
        return list("infcPkgYe162030DAO.selectYe162030List_D", searchVO);
    }

    /**
	 * YE162030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162030 �? �??��
	 * @exception
	 */
    public int selectYe162030ListTotCnt(InfcPkgYe162030SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162030DAO.selectYe162030ListTotCnt_S", searchVO);
    }

}
