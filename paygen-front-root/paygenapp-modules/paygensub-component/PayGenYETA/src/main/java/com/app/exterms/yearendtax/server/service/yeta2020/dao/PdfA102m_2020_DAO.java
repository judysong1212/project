package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfA102mSrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfA102m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102m_2018_DAO.java
 * @Description : PdfA102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfA102m_2020_DAO")
public class PdfA102m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_A102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102m_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102m(PdfA102m_2020_VO vo) throws Exception {
        return (String)insert("pdfA102m_2020_DAO.insertPdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102m_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102m(PdfA102m_2020_VO vo) throws Exception {
        update("pdfA102m_2020_DAO.updatePdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102m_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102m(PdfA102m_2020_VO vo) throws Exception {
        delete("pdfA102m_2020_DAO.deletePdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102m_2020_VO
	 * @return 조회?�� PDF_A102M
	 * @exception Exception
	 */
    public PdfA102m_2020_VO selectPdfA102m(PdfA102m_2020_VO vo) throws Exception {
        return (PdfA102m_2020_VO) selectByPk("pdfA102m_2020_DAO.selectPdfA102m_S", vo);
    }

    /**
	 * PDF_A102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102mList(PdfA102mSrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfA102m_2020_DAO.selectPdfA102mList_D", search_2020_VO);
    }

    /**
	 * PDF_A102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102M �? �??��
	 * @exception
	 */
    public int selectPdfA102mListTotCnt(PdfA102mSrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfA102m_2020_DAO.selectPdfA102mListTotCnt_S", search_2020_VO);
    }

}
