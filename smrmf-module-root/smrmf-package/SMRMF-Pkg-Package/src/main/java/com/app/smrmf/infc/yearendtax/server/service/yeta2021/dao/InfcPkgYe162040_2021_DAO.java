package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162020Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162030Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162040Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162040_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162040_2021_DAO.java
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

@Repository("InfcPkgYe162040_2021_DAO")
public class InfcPkgYe162040_2021_DAO extends EgovAbstractDAO {

	//장기집합 투자 증권 
	@Transactional
    public String PdfYeta6200_N101Y_YE162040_Delete(InfcPkgYe162040_2021_VO infcPkgYe162040Vo) throws Exception {
           delete("infcPkgYe162040_2021_DAO.PdfYeta6200_N101Y_YE162040_Delete_S", infcPkgYe162040Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta6200_N101Y_YE162040_Insert(InfcPkgYe162040_2021_VO infcPkgYe162040Vo) throws Exception {
        return (String)insert("infcPkgYe162040_2021_DAO.PdfYeta6200_N101Y_YE162040_Insert_S", infcPkgYe162040Vo);
    }
	
	//F_장기집합투자증권저축_B1013
	
	@Transactional
    public String incTaxDeducDec_nts_Yeta2021_Ye162040_Insert(InfcPkgYe162040_2021_VO infcPkgYe162040Vo) throws Exception {
        return (String)insert("infcPkgYe162040_2021_DAO.incTaxDeducDec_nts_Yeta2021_Ye162040_Insert_S", infcPkgYe162040Vo);
    }

	  public List<?> fnYeta6300_YE162040_Tax_2021_A01_Select(InfcPkgYe162040Srh_2021_VO infcPkgYe162040Vo) throws Exception {
	        return list("infcPkgYE162040_2021_DAO.selectYeta6300_Tax_YE162040_01_List_D", infcPkgYe162040Vo);
	    }
		 
	    public int updateYeta6300_Tax_YE162040_01(InfcPkgYe162040_2021_VO infcPkgYe162040Vo) throws Exception {
	    	return update("infcPkgYE162040_2021_DAO.updateYeta6300_Tax_YE162040_01_S", infcPkgYe162040Vo);
	    }   
	 
		 
	 
	/**
	 * YE162040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye162040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe162040(InfcPkgYe162040_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe162040_2021_DAO.insertYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe162040(InfcPkgYe162040_2021_VO vo) throws Exception {
        update("infcPkgYe162040_2021_DAO.updateYe162040_S", vo);
    }

    /**
	 * YE162040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye162040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe162040(InfcPkgYe162040_2021_VO vo) throws Exception {
        delete("infcPkgYe162040_2021_DAO.deleteYe162040_S", vo);
    }

    /**
	 * YE162040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye162040VO
	 * @return 조회?�� YE162040
	 * @exception Exception
	 */
    public InfcPkgYe162040_2021_VO selectYe162040(InfcPkgYe162040_2021_VO vo) throws Exception {
        return (InfcPkgYe162040_2021_VO) selectByPk("infcPkgYe162040_2021_DAO.selectYe162040_S", vo);
    }

    /**
	 * YE162040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 목록
	 * @exception Exception
	 */
    public List<?> selectYe162040List(InfcPkgYe162040Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe162040_2021_DAO.selectYe162040List_D", searchVO);
    }

    /**
	 * YE162040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE162040 �? �??��
	 * @exception
	 */
    public int selectYe162040ListTotCnt(InfcPkgYe162040Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162040_2021_DAO.selectYe162040ListTotCnt_S", searchVO);
    }

}
