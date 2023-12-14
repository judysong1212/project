package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfO101mSrh_2021_VO;
import com.app.exterms.yearendtax.server.vo.PdfO101m_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101m_2021_DAO.java
 * @Description : PdfO101m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfO101m_2021_DAO")
public class PdfO101m_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_O101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101m_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101m(PdfO101m_2021_VO vo) throws Exception {
        return (String)insert("pdfO101m_2021_DAO.insertPdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101m_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101m(PdfO101m_2021_VO vo) throws Exception {
        update("pdfO101m_2021_DAO.updatePdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101m_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101m(PdfO101m_2021_VO vo) throws Exception {
        delete("pdfO101m_2021_DAO.deletePdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101m_2021_VO
	 * @return 조회?�� PDF_O101M
	 * @exception Exception
	 */
    public PdfO101m_2021_VO selectPdfO101m(PdfO101m_2021_VO vo) throws Exception {
        return (PdfO101m_2021_VO) selectByPk("pdfO101m_2021_DAO.selectPdfO101m_S", vo);
    }

    /**
	 * PDF_O101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101mList(PdfO101mSrh_2021_VO search_2021_VO) throws Exception {
        return list("pdfO101m_2021_DAO.selectPdfO101mList_D", search_2021_VO);
    }

    /**
	 * PDF_O101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101M �? �??��
	 * @exception
	 */
    public int selectPdfO101mListTotCnt(PdfO101mSrh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfO101m_2021_DAO.selectPdfO101mListTotCnt_S", search_2021_VO);
    }

}
