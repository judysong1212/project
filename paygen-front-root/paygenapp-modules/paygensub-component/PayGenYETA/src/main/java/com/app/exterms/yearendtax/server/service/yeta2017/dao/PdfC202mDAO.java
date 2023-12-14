package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC202mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfC202mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202mDAO.java
 * @Description : PdfC202m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC202mDAO")
public class PdfC202mDAO extends EgovAbstractDAO {

	/**
	 * PDF_C202M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202m(PdfC202mVO vo) throws Exception {
        return (String)insert("pdfC202mDAO.insertPdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202m(PdfC202mVO vo) throws Exception {
        update("pdfC202mDAO.updatePdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202m(PdfC202mVO vo) throws Exception {
        delete("pdfC202mDAO.deletePdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202mVO
	 * @return 조회?�� PDF_C202M
	 * @exception Exception
	 */
    public PdfC202mVO selectPdfC202m(PdfC202mVO vo) throws Exception {
        return (PdfC202mVO) selectByPk("pdfC202mDAO.selectPdfC202m_S", vo);
    }

    /**
	 * PDF_C202M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202mList(PdfC202mSrhVO searchVO) throws Exception {
        return list("pdfC202mDAO.selectPdfC202mList_D", searchVO);
    }

    /**
	 * PDF_C202M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202M �? �??��
	 * @exception
	 */
    public int selectPdfC202mListTotCnt(PdfC202mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC202mDAO.selectPdfC202mListTotCnt_S", searchVO);
    }

}
