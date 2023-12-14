package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfK101mSrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.PdfK101m_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101m_2019_DAO.java
 * @Description : PdfK101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfK101m_2019_DAO")
public class PdfK101m_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_K101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101m_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101m(PdfK101m_2019_VO vo) throws Exception {
        return (String)insert("pdfK101m_2019_DAO.insertPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101m_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101m(PdfK101m_2019_VO vo) throws Exception {
        update("pdfK101m_2019_DAO.updatePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101m_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101m(PdfK101m_2019_VO vo) throws Exception {
        delete("pdfK101m_2019_DAO.deletePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101m_2019_VO
	 * @return 조회?�� PDF_K101M
	 * @exception Exception
	 */
    public PdfK101m_2019_VO selectPdfK101m(PdfK101m_2019_VO vo) throws Exception {
        return (PdfK101m_2019_VO) selectByPk("pdfK101m_2019_DAO.selectPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101mList(PdfK101mSrh_2019_VO search_2019_VO) throws Exception {
        return list("pdfK101m_2019_DAO.selectPdfK101mList_D", search_2019_VO);
    }

    /**
	 * PDF_K101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M �? �??��
	 * @exception
	 */
    public int selectPdfK101mListTotCnt(PdfK101mSrh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfK101m_2019_DAO.selectPdfK101mListTotCnt_S", search_2019_VO);
    }

}
