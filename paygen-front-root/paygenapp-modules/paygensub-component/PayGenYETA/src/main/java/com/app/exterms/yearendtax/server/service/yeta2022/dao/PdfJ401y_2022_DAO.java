package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ401ySrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ401y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401y_2022_DAO.java
 * @Description : PdfJ401y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ401y_2022_DAO")
public class PdfJ401y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J401Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401y_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401y(PdfJ401y_2022_VO vo) throws Exception {
        return (String)insert("pdfJ401y_2022_DAO.insertPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401y_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401y(PdfJ401y_2022_VO vo) throws Exception {
        update("pdfJ401y_2022_DAO.updatePdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401y_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401y(PdfJ401y_2022_VO vo) throws Exception {
        delete("pdfJ401y_2022_DAO.deletePdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401y_2022_VO
	 * @return 조회?�� PDF_J401Y
	 * @exception Exception
	 */
    public PdfJ401y_2022_VO selectPdfJ401y(PdfJ401y_2022_VO vo) throws Exception {
        return (PdfJ401y_2022_VO) selectByPk("pdfJ401y_2022_DAO.selectPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401yList(PdfJ401ySrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfJ401y_2022_DAO.selectPdfJ401yList_D", search_2022_VO);
    }

    /**
	 * PDF_J401Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y �? �??��
	 * @exception
	 */
    public int selectPdfJ401yListTotCnt(PdfJ401ySrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ401y_2022_DAO.selectPdfJ401yListTotCnt_S", search_2022_VO);
    }

}
