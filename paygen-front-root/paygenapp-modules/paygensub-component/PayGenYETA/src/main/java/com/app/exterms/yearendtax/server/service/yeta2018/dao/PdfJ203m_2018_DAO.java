package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ203mSrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ203m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ203m_2018_DAO.java
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

@Repository("PdfJ203m_2018_DAO")
public class PdfJ203m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J203M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ203mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ203m(PdfJ203m_2018_VO vo) throws Exception {
        return (String)insert("pdfJ203m_2018_DAO.insertPdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ203m(PdfJ203m_2018_VO vo) throws Exception {
        update("pdfJ203m_2018_DAO.updatePdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ203m(PdfJ203m_2018_VO vo) throws Exception {
        delete("pdfJ203m_2018_DAO.deletePdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ203mVO
	 * @return 조회?�� PDF_J203M
	 * @exception Exception
	 */
    public PdfJ203m_2018_VO selectPdfJ203m(PdfJ203m_2018_VO vo) throws Exception {
        return (PdfJ203m_2018_VO) selectByPk("pdfJ203m_2018_DAO.selectPdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ203mList(PdfJ203mSrh_2018_VO searchVO) throws Exception {
        return list("pdfJ203m_2018_DAO.selectPdfJ203mList_D", searchVO);
    }

    /**
	 * PDF_J203M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203M �? �??��
	 * @exception
	 */
    public int selectPdfJ203mListTotCnt(PdfJ203mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ203m_2018_DAO.selectPdfJ203mListTotCnt_S", searchVO);
    }

}