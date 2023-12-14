package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ401mSrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ401m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401m_2022_DAO.java
 * @Description : PdfJ401m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ401m_2022_DAO")
public class PdfJ401m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J401M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401m_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401m(PdfJ401m_2022_VO vo) throws Exception {
        return (String)insert("pdfJ401m_2022_DAO.insertPdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401m_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401m(PdfJ401m_2022_VO vo) throws Exception {
        update("pdfJ401m_2022_DAO.updatePdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401m_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401m(PdfJ401m_2022_VO vo) throws Exception {
        delete("pdfJ401m_2022_DAO.deletePdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401m_2022_VO
	 * @return 조회?�� PDF_J401M
	 * @exception Exception
	 */
    public PdfJ401m_2022_VO selectPdfJ401m(PdfJ401m_2022_VO vo) throws Exception {
        return (PdfJ401m_2022_VO) selectByPk("pdfJ401m_2022_DAO.selectPdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401mList(PdfJ401mSrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfJ401m_2022_DAO.selectPdfJ401mList_D", search_2022_VO);
    }

    /**
	 * PDF_J401M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401M �? �??��
	 * @exception
	 */
    public int selectPdfJ401mListTotCnt(PdfJ401mSrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ401m_2022_DAO.selectPdfJ401mListTotCnt_S", search_2022_VO);
    }

}
