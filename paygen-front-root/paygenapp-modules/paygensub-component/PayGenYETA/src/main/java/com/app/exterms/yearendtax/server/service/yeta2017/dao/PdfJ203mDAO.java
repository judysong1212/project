package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ203mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ203mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ203mDAO.java
 * @Description : PdfJ203m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ203mDAO")
public class PdfJ203mDAO extends EgovAbstractDAO {

	/**
	 * PDF_J203M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ203mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ203m(PdfJ203mVO vo) throws Exception {
        return (String)insert("pdfJ203mDAO.insertPdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ203m(PdfJ203mVO vo) throws Exception {
        update("pdfJ203mDAO.updatePdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ203m(PdfJ203mVO vo) throws Exception {
        delete("pdfJ203mDAO.deletePdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ203mVO
	 * @return 조회?�� PDF_J203M
	 * @exception Exception
	 */
    public PdfJ203mVO selectPdfJ203m(PdfJ203mVO vo) throws Exception {
        return (PdfJ203mVO) selectByPk("pdfJ203mDAO.selectPdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ203mList(PdfJ203mSrhVO searchVO) throws Exception {
        return list("pdfJ203mDAO.selectPdfJ203mList_D", searchVO);
    }

    /**
	 * PDF_J203M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203M �? �??��
	 * @exception
	 */
    public int selectPdfJ203mListTotCnt(PdfJ203mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ203mDAO.selectPdfJ203mListTotCnt_S", searchVO);
    }

}
