package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG104mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfG104mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG104mDAO.java
 * @Description : PdfG104m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG104mDAO")
public class PdfG104mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G104M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG104mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG104m(PdfG104mVO vo) throws Exception {
        return (String)insert("pdfG104mDAO.insertPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG104m(PdfG104mVO vo) throws Exception {
        update("pdfG104mDAO.updatePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG104m(PdfG104mVO vo) throws Exception {
        delete("pdfG104mDAO.deletePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG104mVO
	 * @return 조회?�� PDF_G104M
	 * @exception Exception
	 */
    public PdfG104mVO selectPdfG104m(PdfG104mVO vo) throws Exception {
        return (PdfG104mVO) selectByPk("pdfG104mDAO.selectPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG104mList(PdfG104mSrhVO searchVO) throws Exception {
        return list("pdfG104mDAO.selectPdfG104mList_D", searchVO);
    }

    /**
	 * PDF_G104M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M �? �??��
	 * @exception
	 */
    public int selectPdfG104mListTotCnt(PdfG104mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG104mDAO.selectPdfG104mListTotCnt_S", searchVO);
    }

}
