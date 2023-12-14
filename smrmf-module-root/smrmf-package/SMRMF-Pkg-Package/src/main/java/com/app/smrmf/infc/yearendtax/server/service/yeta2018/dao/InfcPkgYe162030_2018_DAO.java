package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162030Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162040Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162040_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162030_2018_DAO.java
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

@Repository("InfcPkgYe162030_2018_DAO")
public class InfcPkgYe162030_2018_DAO extends EgovAbstractDAO {

	//주택마련 
		@Transactional
	    public String PdfYeta3200_J301Y_YE162030_Delete(InfcPkgYe162030_2018_VO infcPkgYe162030Vo) throws Exception {
	           delete("infcPkgYe162030_2018_DAO.PdfYeta3200_J301Y_YE162030_Delete_S", infcPkgYe162030Vo);
	           
	           return "";
	    }	
		@Transactional
	    public String PdfYeta3200_J301Y_YE162030_Insert(InfcPkgYe162030_2018_VO infcPkgYe162030Vo) throws Exception {
	        return (String)insert("infcPkgYe162030_2018_DAO.PdfYeta3200_J301Y_YE162030_Insert_S", infcPkgYe162030Vo);
	    }
	  
	 
		 //F_주택마련저축
		
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2018_Ye162030_Insert(InfcPkgYe162030_2018_VO infcPkgYe162030Vo) throws Exception {
	        return (String)insert("infcPkgYe162030_2018_DAO.incTaxDeducDec_nts_Yeta2018_Ye162030_Insert_S", infcPkgYe162030Vo);
	    }
		 
		  public List<?> fnYeta3300_YE162030_Tax_2018_A01_Select(InfcPkgYe162030Srh_2018_VO infcPkgYe162030Vo) throws Exception {
		        return list("infcPkgYE162030_2018_DAO.selectYeta3300_Tax_YE162030_01_List_D", infcPkgYe162030Vo);
		    }
			 
		    public int updateYeta3300_Tax_YE162030_01(InfcPkgYe162030_2018_VO infcPkgYe162030Vo) throws Exception {
		    	return update("infcPkgYE162030_2018_DAO.updateYeta3300_Tax_YE162030_01_S", infcPkgYe162030Vo);
		    }   
			 
		 
			   
	/**
	 * YE162030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162030(InfcPkgYe162030_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe162030_2018_DAO.insertYe162030_S", vo);
    }

    /**
	 * YE162030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162030(InfcPkgYe162030_2018_VO vo) throws Exception {
        update("infcPkgYe162030_2018_DAO.updateYe162030_S", vo);
    }

    /**
	 * YE162030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162030(InfcPkgYe162030_2018_VO vo) throws Exception {
        delete("infcPkgYe162030_2018_DAO.deleteYe162030_S", vo);
    }

    /**
	 * YE162030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162030VO
	 * @return 조회?�� YE162030
	 * @exception Exception
	 */
    public InfcPkgYe162030_2018_VO selectYe162030(InfcPkgYe162030_2018_VO vo) throws Exception {
        return (InfcPkgYe162030_2018_VO) selectByPk("infcPkgYe162030_2018_DAO.selectYe162030_S", vo);
    }

    /**
	 * YE162030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162030 목록
	 * @exception Exception
	 */
    public List<?> selectYe162030List(InfcPkgYe162030Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe162030_2018_DAO.selectYe162030List_D", searchVO);
    }

    /**
	 * YE162030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162030 �? �??��
	 * @exception
	 */
    public int selectYe162030ListTotCnt(InfcPkgYe162030Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162030_2018_DAO.selectYe162030ListTotCnt_S", searchVO);
    }

}
