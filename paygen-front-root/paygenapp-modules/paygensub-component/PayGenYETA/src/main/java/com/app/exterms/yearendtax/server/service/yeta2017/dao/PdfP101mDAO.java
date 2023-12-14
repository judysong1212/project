package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfP101mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfP101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101mDAO.java
 * @Description : PdfP101m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfP101mDAO")
public class PdfP101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_P101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101m(PdfP101mVO vo) throws Exception {
        return (String)insert("pdfP101mDAO.insertPdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101m(PdfP101mVO vo) throws Exception {
        update("pdfP101mDAO.updatePdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101m(PdfP101mVO vo) throws Exception {
        delete("pdfP101mDAO.deletePdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101mVO
	 * @return 조회?�� PDF_P101M
	 * @exception Exception
	 */
    public PdfP101mVO selectPdfP101m(PdfP101mVO vo) throws Exception {
        return (PdfP101mVO) selectByPk("pdfP101mDAO.selectPdfP101m_S", vo);
    }

    /**
	 * PDF_P101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101mList(PdfP101mSrhVO searchVO) throws Exception {
        return list("pdfP101mDAO.selectPdfP101mList_D", searchVO);
    }

    /**
	 * PDF_P101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101M �? �??��
	 * @exception
	 */
    public int selectPdfP101mListTotCnt(PdfP101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfP101mDAO.selectPdfP101mListTotCnt_S", searchVO);
    }

}
