package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG304mSrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfG304m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304m_2022_DAO.java
 * @Description : PdfG304m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG304m_2022_DAO")
public class PdfG304m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G304M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304m_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304m(PdfG304m_2022_VO vo) throws Exception {
        return (String)insert("pdfG304m_2022_DAO.insertPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304m_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304m(PdfG304m_2022_VO vo) throws Exception {
        update("pdfG304m_2022_DAO.updatePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304m_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304m(PdfG304m_2022_VO vo) throws Exception {
        delete("pdfG304m_2022_DAO.deletePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304m_2022_VO
	 * @return 조회?�� PDF_G304M
	 * @exception Exception
	 */
    public PdfG304m_2022_VO selectPdfG304m(PdfG304m_2022_VO vo) throws Exception {
        return (PdfG304m_2022_VO) selectByPk("pdfG304m_2022_DAO.selectPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304mList(PdfG304mSrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfG304m_2022_DAO.selectPdfG304mList_D", search_2022_VO);
    }

    /**
	 * PDF_G304M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M �? �??��
	 * @exception
	 */
    public int selectPdfG304mListTotCnt(PdfG304mSrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG304m_2022_DAO.selectPdfG304mListTotCnt_S", search_2022_VO);
    }

}
