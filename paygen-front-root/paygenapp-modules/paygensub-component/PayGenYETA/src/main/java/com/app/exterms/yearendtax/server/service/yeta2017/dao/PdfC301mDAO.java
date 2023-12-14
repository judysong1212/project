package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC301mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfC301mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC301mDAO.java
 * @Description : PdfC301m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC301mDAO")
public class PdfC301mDAO extends EgovAbstractDAO {

	/**
	 * PDF_C301M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC301m(PdfC301mVO vo) throws Exception {
        return (String)insert("pdfC301mDAO.insertPdfC301m_S", vo);
    }

    /**
	 * PDF_C301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC301m(PdfC301mVO vo) throws Exception {
        update("pdfC301mDAO.updatePdfC301m_S", vo);
    }

    /**
	 * PDF_C301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC301m(PdfC301mVO vo) throws Exception {
        delete("pdfC301mDAO.deletePdfC301m_S", vo);
    }

    /**
	 * PDF_C301M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC301mVO
	 * @return 조회?�� PDF_C301M
	 * @exception Exception
	 */
    public PdfC301mVO selectPdfC301m(PdfC301mVO vo) throws Exception {
        return (PdfC301mVO) selectByPk("pdfC301mDAO.selectPdfC301m_S", vo);
    }

    /**
	 * PDF_C301M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC301mList(PdfC301mSrhVO searchVO) throws Exception {
        return list("pdfC301mDAO.selectPdfC301mList_D", searchVO);
    }

    /**
	 * PDF_C301M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301M �? �??��
	 * @exception
	 */
    public int selectPdfC301mListTotCnt(PdfC301mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC301mDAO.selectPdfC301mListTotCnt_S", searchVO);
    }

}
