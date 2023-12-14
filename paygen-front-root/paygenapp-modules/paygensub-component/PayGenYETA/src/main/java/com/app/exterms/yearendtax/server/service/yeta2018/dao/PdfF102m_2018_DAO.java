package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfF102mSrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfF102m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102m_2018_DAO.java
 * @Description : PdfF102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfF102m_2018_DAO")
public class PdfF102m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_F102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102m(PdfF102m_2018_VO vo) throws Exception {
        return (String)insert("pdfF102m_2018_DAO.insertPdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102m(PdfF102m_2018_VO vo) throws Exception {
        update("pdfF102m_2018_DAO.updatePdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102m(PdfF102m_2018_VO vo) throws Exception {
        delete("pdfF102m_2018_DAO.deletePdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102mVO
	 * @return 조회?�� PDF_F102M
	 * @exception Exception
	 */
    public PdfF102m_2018_VO selectPdfF102m(PdfF102m_2018_VO vo) throws Exception {
        return (PdfF102m_2018_VO) selectByPk("pdfF102m_2018_DAO.selectPdfF102m_S", vo);
    }

    /**
	 * PDF_F102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102mList(PdfF102mSrh_2018_VO searchVO) throws Exception {
        return list("pdfF102m_2018_DAO.selectPdfF102mList_D", searchVO);
    }

    /**
	 * PDF_F102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102M �? �??��
	 * @exception
	 */
    public int selectPdfF102mListTotCnt(PdfF102mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfF102m_2018_DAO.selectPdfF102mListTotCnt_S", searchVO);
    }

}