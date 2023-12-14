package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfN101mSrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.PdfN101m_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101m_2019_DAO.java
 * @Description : PdfN101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfN101m_2019_DAO")
public class PdfN101m_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_N101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101m_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101m(PdfN101m_2019_VO vo) throws Exception {
        return (String)insert("pdfN101m_2019_DAO.insertPdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101m_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101m(PdfN101m_2019_VO vo) throws Exception {
        update("pdfN101m_2019_DAO.updatePdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101m_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101m(PdfN101m_2019_VO vo) throws Exception {
        delete("pdfN101m_2019_DAO.deletePdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101m_2019_VO
	 * @return 조회?�� PDF_N101M
	 * @exception Exception
	 */
    public PdfN101m_2019_VO selectPdfN101m(PdfN101m_2019_VO vo) throws Exception {
        return (PdfN101m_2019_VO) selectByPk("pdfN101m_2019_DAO.selectPdfN101m_S", vo);
    }

    /**
	 * PDF_N101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101mList(PdfN101mSrh_2019_VO search_2019_VO) throws Exception {
        return list("pdfN101m_2019_DAO.selectPdfN101mList_D", search_2019_VO);
    }

    /**
	 * PDF_N101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101M �? �??��
	 * @exception
	 */
    public int selectPdfN101mListTotCnt(PdfN101mSrh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfN101m_2019_DAO.selectPdfN101mListTotCnt_S", search_2019_VO);
    }

}
