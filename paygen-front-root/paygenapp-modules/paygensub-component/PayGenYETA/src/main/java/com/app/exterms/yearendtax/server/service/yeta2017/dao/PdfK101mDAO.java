package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfK101mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfK101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101mDAO.java
 * @Description : PdfK101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfK101mDAO")
public class PdfK101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_K101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101m(PdfK101mVO vo) throws Exception {
        return (String)insert("pdfK101mDAO.insertPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101m(PdfK101mVO vo) throws Exception {
        update("pdfK101mDAO.updatePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101m(PdfK101mVO vo) throws Exception {
        delete("pdfK101mDAO.deletePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101mVO
	 * @return 조회?�� PDF_K101M
	 * @exception Exception
	 */
    public PdfK101mVO selectPdfK101m(PdfK101mVO vo) throws Exception {
        return (PdfK101mVO) selectByPk("pdfK101mDAO.selectPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101mList(PdfK101mSrhVO searchVO) throws Exception {
        return list("pdfK101mDAO.selectPdfK101mList_D", searchVO);
    }

    /**
	 * PDF_K101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M �? �??��
	 * @exception
	 */
    public int selectPdfK101mListTotCnt(PdfK101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfK101mDAO.selectPdfK101mListTotCnt_S", searchVO);
    }

}
