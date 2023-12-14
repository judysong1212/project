package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP102mDAO.java
 * @Description : PdfP102m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfP102mDAO")
public class InfcPkgPdfP102mDAO extends EgovAbstractDAO {

	/**
	 * PDF_P102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP102m(InfcPkgPdfP102mVO vo) throws Exception {
        return (String)insert("infcPkgPdfP102mDAO.insertPdfP102m_S", vo);
    }

    /**
	 * PDF_P102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP102m(InfcPkgPdfP102mVO vo) throws Exception {
        update("infcPkgPdfP102mDAO.updatePdfP102m_S", vo);
    }

    /**
	 * PDF_P102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP102m(InfcPkgPdfP102mVO vo) throws Exception {
        delete("infcPkgPdfP102mDAO.deletePdfP102m_S", vo);
    }

    /**
	 * PDF_P102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP102mVO
	 * @return 조회?�� PDF_P102M
	 * @exception Exception
	 */
    public InfcPkgPdfP102mVO selectPdfP102m(InfcPkgPdfP102mVO vo) throws Exception {
        return (InfcPkgPdfP102mVO) selectByPk("infcPkgPdfP102mDAO.selectPdfP102m_S", vo);
    }

    /**
	 * PDF_P102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP102mList(InfcPkgPdfP102mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfP102mDAO.selectPdfP102mList_D", searchVO);
    }

    /**
	 * PDF_P102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102M �? �??��
	 * @exception
	 */
    public int selectPdfP102mListTotCnt(InfcPkgPdfP102mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP102mDAO.selectPdfP102mListTotCnt_S", searchVO);
    }

}
