package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfE102mSrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfE102m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102m_2018_DAO.java
 * @Description : PdfE102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfE102m_2018_DAO")
public class PdfE102m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_E102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102m(PdfE102m_2018_VO vo) throws Exception {
        return (String)insert("pdfE102m_2018_DAO.insertPdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102m(PdfE102m_2018_VO vo) throws Exception {
        update("pdfE102m_2018_DAO.updatePdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102m(PdfE102m_2018_VO vo) throws Exception {
        delete("pdfE102m_2018_DAO.deletePdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102mVO
	 * @return 조회?�� PDF_E102M
	 * @exception Exception
	 */
    public PdfE102m_2018_VO selectPdfE102m(PdfE102m_2018_VO vo) throws Exception {
        return (PdfE102m_2018_VO) selectByPk("pdfE102m_2018_DAO.selectPdfE102m_S", vo);
    }

    /**
	 * PDF_E102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102mList(PdfE102mSrh_2018_VO searchVO) throws Exception {
        return list("pdfE102m_2018_DAO.selectPdfE102mList_D", searchVO);
    }

    /**
	 * PDF_E102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102M �? �??��
	 * @exception
	 */
    public int selectPdfE102mListTotCnt(PdfE102mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfE102m_2018_DAO.selectPdfE102mListTotCnt_S", searchVO);
    }

}
