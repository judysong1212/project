package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ301mSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ301mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301mDAO.java
 * @Description : PdfJ301m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ301mDAO")
public class PdfJ301mDAO extends EgovAbstractDAO {

	/**
	 * PDF_J301M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301m(PdfJ301mVO vo) throws Exception {
        return (String)insert("pdfJ301mDAO.insertPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301m(PdfJ301mVO vo) throws Exception {
        update("pdfJ301mDAO.updatePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301m(PdfJ301mVO vo) throws Exception {
        delete("pdfJ301mDAO.deletePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301mVO
	 * @return 조회?�� PDF_J301M
	 * @exception Exception
	 */
    public PdfJ301mVO selectPdfJ301m(PdfJ301mVO vo) throws Exception {
        return (PdfJ301mVO) selectByPk("pdfJ301mDAO.selectPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301mList(PdfJ301mSrhVO searchVO) throws Exception {
        return list("pdfJ301mDAO.selectPdfJ301mList_D", searchVO);
    }

    /**
	 * PDF_J301M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M �? �??��
	 * @exception
	 */
    public int selectPdfJ301mListTotCnt(PdfJ301mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ301mDAO.selectPdfJ301mListTotCnt_S", searchVO);
    }

}
