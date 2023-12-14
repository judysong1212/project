package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC101mSrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfC101m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC101m_2018_DAO.java
 * @Description : PdfC101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC101m_2018_DAO")
public class PdfC101m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC101m(PdfC101m_2018_VO vo) throws Exception {
        return (String)insert("pdfC101m_2018_DAO.insertPdfC101m_S", vo);
    }

    /**
	 * PDF_C101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC101m(PdfC101m_2018_VO vo) throws Exception {
        update("pdfC101m_2018_DAO.updatePdfC101m_S", vo);
    }

    /**
	 * PDF_C101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC101m(PdfC101m_2018_VO vo) throws Exception {
        delete("pdfC101m_2018_DAO.deletePdfC101m_S", vo);
    }

    /**
	 * PDF_C101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC101mVO
	 * @return 조회?�� PDF_C101M
	 * @exception Exception
	 */
    public PdfC101m_2018_VO selectPdfC101m(PdfC101m_2018_VO vo) throws Exception {
        return (PdfC101m_2018_VO) selectByPk("pdfC101m_2018_DAO.selectPdfC101m_S", vo);
    }

    /**
	 * PDF_C101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC101mList(PdfC101mSrh_2018_VO searchVO) throws Exception {
        return list("pdfC101m_2018_DAO.selectPdfC101mList_D", searchVO);
    }

    /**
	 * PDF_C101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101M �? �??��
	 * @exception
	 */
    public int selectPdfC101mListTotCnt(PdfC101mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC101m_2018_DAO.selectPdfC101mListTotCnt_S", searchVO);
    }

}
