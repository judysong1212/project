package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ101mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101mDAO.java
 * @Description : PdfJ101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ101mDAO")
public class PdfJ101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_J101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101m(PdfJ101mVO vo) throws Exception {
        return (String)insert("pdfJ101mDAO.insertPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101m(PdfJ101mVO vo) throws Exception {
        update("pdfJ101mDAO.updatePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101m(PdfJ101mVO vo) throws Exception {
        delete("pdfJ101mDAO.deletePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101mVO
	 * @return 조회?�� PDF_J101M
	 * @exception Exception
	 */
    public PdfJ101mVO selectPdfJ101m(PdfJ101mVO vo) throws Exception {
        return (PdfJ101mVO) selectByPk("pdfJ101mDAO.selectPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101mList(PdfJ101mSrhVO searchVO) throws Exception {
        return list("pdfJ101mDAO.selectPdfJ101mList_D", searchVO);
    }

    /**
	 * PDF_J101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M �? �??��
	 * @exception
	 */
    public int selectPdfJ101mListTotCnt(PdfJ101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ101mDAO.selectPdfJ101mListTotCnt_S", searchVO);
    }

}
