package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfE102mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfE102mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102mDAO.java
 * @Description : PdfE102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfE102mDAO")
public class PdfE102mDAO extends EgovAbstractDAO {

	/**
	 * PDF_E102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102m(PdfE102mVO vo) throws Exception {
        return (String)insert("pdfE102mDAO.insertPdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102m(PdfE102mVO vo) throws Exception {
        update("pdfE102mDAO.updatePdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102m(PdfE102mVO vo) throws Exception {
        delete("pdfE102mDAO.deletePdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102mVO
	 * @return 조회?�� PDF_E102M
	 * @exception Exception
	 */
    public PdfE102mVO selectPdfE102m(PdfE102mVO vo) throws Exception {
        return (PdfE102mVO) selectByPk("pdfE102mDAO.selectPdfE102m_S", vo);
    }

    /**
	 * PDF_E102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102mList(PdfE102mSrhVO searchVO) throws Exception {
        return list("pdfE102mDAO.selectPdfE102mList_D", searchVO);
    }

    /**
	 * PDF_E102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102M �? �??��
	 * @exception
	 */
    public int selectPdfE102mListTotCnt(PdfE102mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfE102mDAO.selectPdfE102mListTotCnt_S", searchVO);
    }

}
