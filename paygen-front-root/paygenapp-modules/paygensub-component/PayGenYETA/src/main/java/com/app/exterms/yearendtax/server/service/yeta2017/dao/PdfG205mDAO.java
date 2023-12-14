package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG205mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfG205mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG205mDAO.java
 * @Description : PdfG205m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG205mDAO")
public class PdfG205mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G205M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG205mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG205m(PdfG205mVO vo) throws Exception {
        return (String)insert("pdfG205mDAO.insertPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG205m(PdfG205mVO vo) throws Exception {
        update("pdfG205mDAO.updatePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG205m(PdfG205mVO vo) throws Exception {
        delete("pdfG205mDAO.deletePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG205mVO
	 * @return 조회?�� PDF_G205M
	 * @exception Exception
	 */
    public PdfG205mVO selectPdfG205m(PdfG205mVO vo) throws Exception {
        return (PdfG205mVO) selectByPk("pdfG205mDAO.selectPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG205mList(PdfG205mSrhVO searchVO) throws Exception {
        return list("pdfG205mDAO.selectPdfG205mList_D", searchVO);
    }

    /**
	 * PDF_G205M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M �? �??��
	 * @exception
	 */
    public int selectPdfG205mListTotCnt(PdfG205mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG205mDAO.selectPdfG205mListTotCnt_S", searchVO);
    }

}
