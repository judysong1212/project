package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfA102mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfA102mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102mDAO.java
 * @Description : PdfA102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfA102mDAO")
public class PdfA102mDAO extends EgovAbstractDAO {

	/**
	 * PDF_A102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102m(PdfA102mVO vo) throws Exception {
        return (String)insert("pdfA102mDAO.insertPdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102m(PdfA102mVO vo) throws Exception {
        update("pdfA102mDAO.updatePdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102m(PdfA102mVO vo) throws Exception {
        delete("pdfA102mDAO.deletePdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102mVO
	 * @return 조회?�� PDF_A102M
	 * @exception Exception
	 */
    public PdfA102mVO selectPdfA102m(PdfA102mVO vo) throws Exception {
        return (PdfA102mVO) selectByPk("pdfA102mDAO.selectPdfA102m_S", vo);
    }

    /**
	 * PDF_A102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102mList(PdfA102mSrhVO searchVO) throws Exception {
        return list("pdfA102mDAO.selectPdfA102mList_D", searchVO);
    }

    /**
	 * PDF_A102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102M �? �??��
	 * @exception
	 */
    public int selectPdfA102mListTotCnt(PdfA102mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfA102mDAO.selectPdfA102mListTotCnt_S", searchVO);
    }

}
