package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfB101ySrh_2021_VO;
import com.app.exterms.yearendtax.server.vo.PdfB101y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101y_2018_DAO.java
 * @Description : PdfB101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfB101y_2021_DAO")
public class PdfB101y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_B101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101y_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101y(PdfB101y_2021_VO vo) throws Exception {
        return (String)insert("pdfB101y_2021_DAO.insertPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101y_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101y(PdfB101y_2021_VO vo) throws Exception {
        update("pdfB101y_2021_DAO.updatePdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101y_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101y(PdfB101y_2021_VO vo) throws Exception {
        delete("pdfB101y_2021_DAO.deletePdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101y_2021_VO
	 * @return 조회?�� PDF_B101Y
	 * @exception Exception
	 */
    public PdfB101y_2021_VO selectPdfB101y(PdfB101y_2021_VO vo) throws Exception {
        return (PdfB101y_2021_VO) selectByPk("pdfB101y_2021_DAO.selectPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101yList(PdfB101ySrh_2021_VO search_2021_VO) throws Exception {
        return list("pdfB101y_2021_DAO.selectPdfB101yList_D", search_2021_VO);
    }

    /**
	 * PDF_B101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y �? �??��
	 * @exception
	 */
    public int selectPdfB101yListTotCnt(PdfB101ySrh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfB101y_2021_DAO.selectPdfB101yListTotCnt_S", search_2021_VO);
    }

}
