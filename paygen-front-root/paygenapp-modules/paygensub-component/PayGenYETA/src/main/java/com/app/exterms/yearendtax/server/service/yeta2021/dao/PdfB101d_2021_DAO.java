package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfB101dSrh_2021_VO;
import com.app.exterms.yearendtax.server.vo.PdfB101d_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101d_2018_DAO.java
 * @Description : PdfB101d DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfB101d_2021_DAO")
public class PdfB101d_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_B101D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101d_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101d(PdfB101d_2021_VO vo) throws Exception {
        return (String)insert("pdfB101d_2021_DAO.insertPdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101d_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101d(PdfB101d_2021_VO vo) throws Exception {
        update("pdfB101d_2021_DAO.updatePdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101d_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101d(PdfB101d_2021_VO vo) throws Exception {
        delete("pdfB101d_2021_DAO.deletePdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101d_2021_VO
	 * @return 조회?�� PDF_B101D
	 * @exception Exception
	 */
    public PdfB101d_2021_VO selectPdfB101d(PdfB101d_2021_VO vo) throws Exception {
        return (PdfB101d_2021_VO) selectByPk("pdfB101d_2021_DAO.selectPdfB101d_S", vo);
    }

    /**
	 * PDF_B101D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101dList(PdfB101dSrh_2021_VO search_2021_VO) throws Exception {
        return list("pdfB101d_2021_DAO.selectPdfB101dList_D", search_2021_VO);
    }

    /**
	 * PDF_B101D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101D �? �??��
	 * @exception
	 */
    public int selectPdfB101dListTotCnt(PdfB101dSrh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfB101d_2021_DAO.selectPdfB101dListTotCnt_S", search_2021_VO);
    }

}