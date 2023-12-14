package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG205mSrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfG205m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG205m_2020_DAO.java
 * @Description : PdfG205m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG205m_2020_DAO")
public class PdfG205m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G205M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG205m_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG205m(PdfG205m_2020_VO vo) throws Exception {
        return (String)insert("pdfG205m_2020_DAO.insertPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205m_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG205m(PdfG205m_2020_VO vo) throws Exception {
        update("pdfG205m_2020_DAO.updatePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205m_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG205m(PdfG205m_2020_VO vo) throws Exception {
        delete("pdfG205m_2020_DAO.deletePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG205m_2020_VO
	 * @return 조회?�� PDF_G205M
	 * @exception Exception
	 */
    public PdfG205m_2020_VO selectPdfG205m(PdfG205m_2020_VO vo) throws Exception {
        return (PdfG205m_2020_VO) selectByPk("pdfG205m_2020_DAO.selectPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG205mList(PdfG205mSrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfG205m_2020_DAO.selectPdfG205mList_D", search_2020_VO);
    }

    /**
	 * PDF_G205M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M �? �??��
	 * @exception
	 */
    public int selectPdfG205mListTotCnt(PdfG205mSrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG205m_2020_DAO.selectPdfG205mListTotCnt_S", search_2020_VO);
    }

}
