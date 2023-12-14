package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC202mSrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfC202m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202m_2018_DAO.java
 * @Description : PdfC202m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC202m_2020_DAO")
public class PdfC202m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C202M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202m_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202m(PdfC202m_2020_VO vo) throws Exception {
        return (String)insert("pdfC202m_2020_DAO.insertPdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202m_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202m(PdfC202m_2020_VO vo) throws Exception {
        update("pdfC202m_2020_DAO.updatePdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202m_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202m(PdfC202m_2020_VO vo) throws Exception {
        delete("pdfC202m_2020_DAO.deletePdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202m_2020_VO
	 * @return 조회?�� PDF_C202M
	 * @exception Exception
	 */
    public PdfC202m_2020_VO selectPdfC202m(PdfC202m_2020_VO vo) throws Exception {
        return (PdfC202m_2020_VO) selectByPk("pdfC202m_2020_DAO.selectPdfC202m_S", vo);
    }

    /**
	 * PDF_C202M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202mList(PdfC202mSrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfC202m_2020_DAO.selectPdfC202mList_D", search_2020_VO);
    }

    /**
	 * PDF_C202M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202M �? �??��
	 * @exception
	 */
    public int selectPdfC202mListTotCnt(PdfC202mSrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC202m_2020_DAO.selectPdfC202mListTotCnt_S", search_2020_VO);
    }

}