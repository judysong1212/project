package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG304mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfG304mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304mDAO.java
 * @Description : PdfG304m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG304mDAO")
public class PdfG304mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G304M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304m(PdfG304mVO vo) throws Exception {
        return (String)insert("pdfG304mDAO.insertPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304m(PdfG304mVO vo) throws Exception {
        update("pdfG304mDAO.updatePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304m(PdfG304mVO vo) throws Exception {
        delete("pdfG304mDAO.deletePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304mVO
	 * @return 조회?�� PDF_G304M
	 * @exception Exception
	 */
    public PdfG304mVO selectPdfG304m(PdfG304mVO vo) throws Exception {
        return (PdfG304mVO) selectByPk("pdfG304mDAO.selectPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304mList(PdfG304mSrhVO searchVO) throws Exception {
        return list("pdfG304mDAO.selectPdfG304mList_D", searchVO);
    }

    /**
	 * PDF_G304M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M �? �??��
	 * @exception
	 */
    public int selectPdfG304mListTotCnt(PdfG304mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG304mDAO.selectPdfG304mListTotCnt_S", searchVO);
    }

}
