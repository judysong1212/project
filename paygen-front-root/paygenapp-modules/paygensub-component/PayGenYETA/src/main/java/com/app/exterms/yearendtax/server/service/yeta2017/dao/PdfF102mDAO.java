package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfF102mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfF102mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102mDAO.java
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

@Repository("PdfF102mDAO")
public class PdfF102mDAO extends EgovAbstractDAO {

	/**
	 * PDF_F102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102m(PdfF102mVO vo) throws Exception {
        return (String)insert("pdfF102mDAO.insertPdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102m(PdfF102mVO vo) throws Exception {
        update("pdfF102mDAO.updatePdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102m(PdfF102mVO vo) throws Exception {
        delete("pdfF102mDAO.deletePdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102mVO
	 * @return 조회?�� PDF_F102M
	 * @exception Exception
	 */
    public PdfF102mVO selectPdfF102m(PdfF102mVO vo) throws Exception {
        return (PdfF102mVO) selectByPk("pdfF102mDAO.selectPdfF102m_S", vo);
    }

    /**
	 * PDF_F102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102mList(PdfF102mSrhVO searchVO) throws Exception {
        return list("pdfF102mDAO.selectPdfF102mList_D", searchVO);
    }

    /**
	 * PDF_F102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102M �? �??��
	 * @exception
	 */
    public int selectPdfF102mListTotCnt(PdfF102mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfF102mDAO.selectPdfF102mListTotCnt_S", searchVO);
    }

}
