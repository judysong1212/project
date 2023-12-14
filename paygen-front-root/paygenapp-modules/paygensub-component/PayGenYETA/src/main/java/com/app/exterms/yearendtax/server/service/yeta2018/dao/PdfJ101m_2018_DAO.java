package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ101mSrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ101m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101m_2018_DAO.java
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

@Repository("PdfJ101m_2018_DAO")
public class PdfJ101m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101m(PdfJ101m_2018_VO vo) throws Exception {
        return (String)insert("pdfJ101m_2018_DAO.insertPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101m(PdfJ101m_2018_VO vo) throws Exception {
        update("pdfJ101m_2018_DAO.updatePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101m(PdfJ101m_2018_VO vo) throws Exception {
        delete("pdfJ101m_2018_DAO.deletePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101mVO
	 * @return 조회?�� PDF_J101M
	 * @exception Exception
	 */
    public PdfJ101m_2018_VO selectPdfJ101m(PdfJ101m_2018_VO vo) throws Exception {
        return (PdfJ101m_2018_VO) selectByPk("pdfJ101m_2018_DAO.selectPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101mList(PdfJ101mSrh_2018_VO searchVO) throws Exception {
        return list("pdfJ101m_2018_DAO.selectPdfJ101mList_D", searchVO);
    }

    /**
	 * PDF_J101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M �? �??��
	 * @exception
	 */
    public int selectPdfJ101mListTotCnt(PdfJ101mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ101m_2018_DAO.selectPdfJ101mListTotCnt_S", searchVO);
    }

}
