package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ101mSrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ101m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101m_2022_DAO.java
 * @Description : PdfJ101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ101m_2022_DAO")
public class PdfJ101m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101m_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101m(PdfJ101m_2022_VO vo) throws Exception {
        return (String)insert("pdfJ101m_2022_DAO.insertPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101m_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101m(PdfJ101m_2022_VO vo) throws Exception {
        update("pdfJ101m_2022_DAO.updatePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101m_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101m(PdfJ101m_2022_VO vo) throws Exception {
        delete("pdfJ101m_2022_DAO.deletePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101m_2022_VO
	 * @return 조회?�� PDF_J101M
	 * @exception Exception
	 */
    public PdfJ101m_2022_VO selectPdfJ101m(PdfJ101m_2022_VO vo) throws Exception {
        return (PdfJ101m_2022_VO) selectByPk("pdfJ101m_2022_DAO.selectPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101mList(PdfJ101mSrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfJ101m_2022_DAO.selectPdfJ101mList_D", search_2022_VO);
    }

    /**
	 * PDF_J101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M �? �??��
	 * @exception
	 */
    public int selectPdfJ101mListTotCnt(PdfJ101mSrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ101m_2022_DAO.selectPdfJ101mListTotCnt_S", search_2022_VO);
    }

}