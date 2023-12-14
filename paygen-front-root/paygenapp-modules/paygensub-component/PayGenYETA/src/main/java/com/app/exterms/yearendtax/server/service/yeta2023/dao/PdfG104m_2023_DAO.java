package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG104mSrh_2023_VO;
import com.app.exterms.yearendtax.server.vo.PdfG104m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG104m_2023_DAO.java
 * @Description : PdfG104m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG104m_2023_DAO")
public class PdfG104m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G104M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG104m_2023_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG104m(PdfG104m_2023_VO vo) throws Exception {
        return (String)insert("pdfG104m_2023_DAO.insertPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104m_2023_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG104m(PdfG104m_2023_VO vo) throws Exception {
        update("pdfG104m_2023_DAO.updatePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104m_2023_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG104m(PdfG104m_2023_VO vo) throws Exception {
        delete("pdfG104m_2023_DAO.deletePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG104m_2023_VO
	 * @return 조회?�� PDF_G104M
	 * @exception Exception
	 */
    public PdfG104m_2023_VO selectPdfG104m(PdfG104m_2023_VO vo) throws Exception {
        return (PdfG104m_2023_VO) selectByPk("pdfG104m_2023_DAO.selectPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG104mList(PdfG104mSrh_2023_VO search_2023_VO) throws Exception {
        return list("pdfG104m_2023_DAO.selectPdfG104mList_D", search_2023_VO);
    }

    /**
	 * PDF_G104M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M �? �??��
	 * @exception
	 */
    public int selectPdfG104mListTotCnt(PdfG104mSrh_2023_VO search_2023_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG104m_2023_DAO.selectPdfG104mListTotCnt_S", search_2023_VO);
    }

}
