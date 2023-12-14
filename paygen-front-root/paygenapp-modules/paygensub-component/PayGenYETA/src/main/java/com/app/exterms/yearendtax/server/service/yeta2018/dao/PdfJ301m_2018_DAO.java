package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ301mSrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ301m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301m_2018_DAO.java
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

@Repository("PdfJ301m_2018_DAO")
public class PdfJ301m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J301M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301m(PdfJ301m_2018_VO vo) throws Exception {
        return (String)insert("pdfJ301m_2018_DAO.insertPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301m(PdfJ301m_2018_VO vo) throws Exception {
        update("pdfJ301m_2018_DAO.updatePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301m(PdfJ301m_2018_VO vo) throws Exception {
        delete("pdfJ301m_2018_DAO.deletePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301mVO
	 * @return 조회?�� PDF_J301M
	 * @exception Exception
	 */
    public PdfJ301m_2018_VO selectPdfJ301m(PdfJ301m_2018_VO vo) throws Exception {
        return (PdfJ301m_2018_VO) selectByPk("pdfJ301m_2018_DAO.selectPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301mList(PdfJ301mSrh_2018_VO searchVO) throws Exception {
        return list("pdfJ301m_2018_DAO.selectPdfJ301mList_D", searchVO);
    }

    /**
	 * PDF_J301M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M �? �??��
	 * @exception
	 */
    public int selectPdfJ301mListTotCnt(PdfJ301mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ301m_2018_DAO.selectPdfJ301mListTotCnt_S", searchVO);
    }

}
