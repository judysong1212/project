package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfD101mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfD101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101mDAO.java
 * @Description : PdfD101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfD101mDAO")
public class PdfD101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_D101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101m(PdfD101mVO vo) throws Exception {
        return (String)insert("pdfD101mDAO.insertPdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101m(PdfD101mVO vo) throws Exception {
        update("pdfD101mDAO.updatePdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101m(PdfD101mVO vo) throws Exception {
        delete("pdfD101mDAO.deletePdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101mVO
	 * @return 조회?�� PDF_D101M
	 * @exception Exception
	 */
    public PdfD101mVO selectPdfD101m(PdfD101mVO vo) throws Exception {
        return (PdfD101mVO) selectByPk("pdfD101mDAO.selectPdfD101m_S", vo);
    }

    /**
	 * PDF_D101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101mList(PdfD101mSrhVO searchVO) throws Exception {
        return list("pdfD101mDAO.selectPdfD101mList_D", searchVO);
    }

    /**
	 * PDF_D101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101M �? �??��
	 * @exception
	 */
    public int selectPdfD101mListTotCnt(PdfD101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfD101mDAO.selectPdfD101mListTotCnt_S", searchVO);
    }

}
