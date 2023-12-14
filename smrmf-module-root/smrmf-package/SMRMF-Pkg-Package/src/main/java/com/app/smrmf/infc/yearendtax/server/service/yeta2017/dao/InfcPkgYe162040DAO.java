package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162040DAO.java
 * @Description : Ye162040 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162040DAO")
public class InfcPkgYe162040DAO extends EgovAbstractDAO {

	//장기집합 투자 증권 
	@Transactional
    public String PdfYeta2200_N101Y_YE162040_Delete(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception {
           delete("infcPkgYe162040DAO.PdfYeta2200_N101Y_YE162040_Delete_S", infcPkgYe162040Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta2200_N101Y_YE162040_Insert(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception {
        return (String)insert("infcPkgYe162040DAO.PdfYeta2200_N101Y_YE162040_Insert_S", infcPkgYe162040Vo);
    }
	
	//F_장기집합투자증권저축_B1013
	
	@Transactional
    public String incTaxDeducDec_nts_Yeta2017_Ye162040_Insert(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception {
        return (String)insert("infcPkgYe162040DAO.incTaxDeducDec_nts_Yeta2017_Ye162040_Insert_S", infcPkgYe162040Vo);
    }

	  public List<?> fnYeta2300_YE162040_Tax_2017_A01_Select(InfcPkgYe162040SrhVO infcPkgYe162040Vo) throws Exception {
	        return list("infcPkgYE162040DAO.selectYeta2300_Tax_YE162040_01_List_D", infcPkgYe162040Vo);
	    }
		 
	    public int updateYeta2300_Tax_YE162040_01(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception {
	    	return update("infcPkgYE162040DAO.updateYeta2300_Tax_YE162040_01_S", infcPkgYe162040Vo);
	    }   
	 
		 
	 
	/**
	 * YE162040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162040(InfcPkgYe162040VO vo) throws Exception {
        return (String)insert("infcPkgYe162040DAO.insertYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162040(InfcPkgYe162040VO vo) throws Exception {
        update("infcPkgYe162040DAO.updateYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162040(InfcPkgYe162040VO vo) throws Exception {
        delete("infcPkgYe162040DAO.deleteYe162040_S", vo);
    }

    /**
	 * YE162040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162040VO
	 * @return 조회?�� YE162040
	 * @exception Exception
	 */
    public InfcPkgYe162040VO selectYe162040(InfcPkgYe162040VO vo) throws Exception {
        return (InfcPkgYe162040VO) selectByPk("infcPkgYe162040DAO.selectYe162040_S", vo);
    }

    /**
	 * YE162040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 목록
	 * @exception Exception
	 */
    public List<?> selectYe162040List(InfcPkgYe162040SrhVO searchVO) throws Exception {
        return list("infcPkgYe162040DAO.selectYe162040List_D", searchVO);
    }

    /**
	 * YE162040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 �? �??��
	 * @exception
	 */
    public int selectYe162040ListTotCnt(InfcPkgYe162040SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162040DAO.selectYe162040ListTotCnt_S", searchVO);
    }

}
