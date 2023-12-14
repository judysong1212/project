package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfD101mSrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfD101m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101m_2022_DAO.java
 * @Description : PdfD101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfD101m_2022_DAO")
public class PdfD101m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_D101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101m_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101m(PdfD101m_2022_VO vo) throws Exception {
        return (String)insert("pdfD101m_2022_DAO.insertPdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101m_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101m(PdfD101m_2022_VO vo) throws Exception {
        update("pdfD101m_2022_DAO.updatePdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101m_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101m(PdfD101m_2022_VO vo) throws Exception {
        delete("pdfD101m_2022_DAO.deletePdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101m_2022_VO
	 * @return 조회?�� PDF_D101M
	 * @exception Exception
	 */
    public PdfD101m_2022_VO selectPdfD101m(PdfD101m_2022_VO vo) throws Exception {
        return (PdfD101m_2022_VO) selectByPk("pdfD101m_2022_DAO.selectPdfD101m_S", vo);
    }

    /**
	 * PDF_D101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101mList(PdfD101mSrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfD101m_2022_DAO.selectPdfD101mList_D", search_2022_VO);
    }

    /**
	 * PDF_D101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101M �? �??��
	 * @exception
	 */
    public int selectPdfD101mListTotCnt(PdfD101mSrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfD101m_2022_DAO.selectPdfD101mListTotCnt_S", search_2022_VO);
    }

}
