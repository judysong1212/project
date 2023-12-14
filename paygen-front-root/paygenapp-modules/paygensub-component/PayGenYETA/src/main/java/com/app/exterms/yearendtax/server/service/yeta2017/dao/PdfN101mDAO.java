package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfN101mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfN101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101mDAO.java
 * @Description : PdfN101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfN101mDAO")
public class PdfN101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_N101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101m(PdfN101mVO vo) throws Exception {
        return (String)insert("pdfN101mDAO.insertPdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101m(PdfN101mVO vo) throws Exception {
        update("pdfN101mDAO.updatePdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101m(PdfN101mVO vo) throws Exception {
        delete("pdfN101mDAO.deletePdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101mVO
	 * @return 조회?�� PDF_N101M
	 * @exception Exception
	 */
    public PdfN101mVO selectPdfN101m(PdfN101mVO vo) throws Exception {
        return (PdfN101mVO) selectByPk("pdfN101mDAO.selectPdfN101m_S", vo);
    }

    /**
	 * PDF_N101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101mList(PdfN101mSrhVO searchVO) throws Exception {
        return list("pdfN101mDAO.selectPdfN101mList_D", searchVO);
    }

    /**
	 * PDF_N101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101M �? �??��
	 * @exception
	 */
    public int selectPdfN101mListTotCnt(PdfN101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfN101mDAO.selectPdfN101mListTotCnt_S", searchVO);
    }

}
