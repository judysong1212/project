package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfP101mSrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.PdfP101m_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101m_2019_DAO.java
 * @Description : PdfP101m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfP101m_2019_DAO")
public class PdfP101m_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_P101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101m_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101m(PdfP101m_2019_VO vo) throws Exception {
        return (String)insert("pdfP101m_2019_DAO.insertPdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101m_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101m(PdfP101m_2019_VO vo) throws Exception {
        update("pdfP101m_2019_DAO.updatePdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101m_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101m(PdfP101m_2019_VO vo) throws Exception {
        delete("pdfP101m_2019_DAO.deletePdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101m_2019_VO
	 * @return 조회?�� PDF_P101M
	 * @exception Exception
	 */
    public PdfP101m_2019_VO selectPdfP101m(PdfP101m_2019_VO vo) throws Exception {
        return (PdfP101m_2019_VO) selectByPk("pdfP101m_2019_DAO.selectPdfP101m_S", vo);
    }

    /**
	 * PDF_P101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101mList(PdfP101mSrh_2019_VO search_2019_VO) throws Exception {
        return list("pdfP101m_2019_DAO.selectPdfP101mList_D", search_2019_VO);
    }

    /**
	 * PDF_P101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101M �? �??��
	 * @exception
	 */
    public int selectPdfP101mListTotCnt(PdfP101mSrh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfP101m_2019_DAO.selectPdfP101mListTotCnt_S", search_2019_VO);
    }

}
