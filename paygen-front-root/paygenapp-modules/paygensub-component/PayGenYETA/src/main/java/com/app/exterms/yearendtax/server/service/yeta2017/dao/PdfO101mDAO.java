package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfO101mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfO101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101mDAO.java
 * @Description : PdfO101m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfO101mDAO")
public class PdfO101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_O101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101m(PdfO101mVO vo) throws Exception {
        return (String)insert("pdfO101mDAO.insertPdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101m(PdfO101mVO vo) throws Exception {
        update("pdfO101mDAO.updatePdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101m(PdfO101mVO vo) throws Exception {
        delete("pdfO101mDAO.deletePdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101mVO
	 * @return 조회?�� PDF_O101M
	 * @exception Exception
	 */
    public PdfO101mVO selectPdfO101m(PdfO101mVO vo) throws Exception {
        return (PdfO101mVO) selectByPk("pdfO101mDAO.selectPdfO101m_S", vo);
    }

    /**
	 * PDF_O101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101mList(PdfO101mSrhVO searchVO) throws Exception {
        return list("pdfO101mDAO.selectPdfO101mList_D", searchVO);
    }

    /**
	 * PDF_O101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101M �? �??��
	 * @exception
	 */
    public int selectPdfO101mListTotCnt(PdfO101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfO101mDAO.selectPdfO101mListTotCnt_S", searchVO);
    }

}
