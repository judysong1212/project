package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ401mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ401mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401mDAO.java
 * @Description : PdfJ401m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ401mDAO")
public class PdfJ401mDAO extends EgovAbstractDAO {

	/**
	 * PDF_J401M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401m(PdfJ401mVO vo) throws Exception {
        return (String)insert("pdfJ401mDAO.insertPdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401m(PdfJ401mVO vo) throws Exception {
        update("pdfJ401mDAO.updatePdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401m(PdfJ401mVO vo) throws Exception {
        delete("pdfJ401mDAO.deletePdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401mVO
	 * @return 조회?�� PDF_J401M
	 * @exception Exception
	 */
    public PdfJ401mVO selectPdfJ401m(PdfJ401mVO vo) throws Exception {
        return (PdfJ401mVO) selectByPk("pdfJ401mDAO.selectPdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401mList(PdfJ401mSrhVO searchVO) throws Exception {
        return list("pdfJ401mDAO.selectPdfJ401mList_D", searchVO);
    }

    /**
	 * PDF_J401M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401M �? �??��
	 * @exception
	 */
    public int selectPdfJ401mListTotCnt(PdfJ401mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ401mDAO.selectPdfJ401mListTotCnt_S", searchVO);
    }

}
