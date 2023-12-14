package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfK101ySrh_2023_VO;
import com.app.exterms.yearendtax.server.vo.PdfK101y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101y_2023_DAO.java
 * @Description : PdfK101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfK101y_2023_DAO")
public class PdfK101y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_K101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101y_2023_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101y(PdfK101y_2023_VO vo) throws Exception {
        return (String)insert("pdfK101y_2023_DAO.insertPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101y_2023_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101y(PdfK101y_2023_VO vo) throws Exception {
        update("pdfK101y_2023_DAO.updatePdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101y_2023_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101y(PdfK101y_2023_VO vo) throws Exception {
        delete("pdfK101y_2023_DAO.deletePdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101y_2023_VO
	 * @return 조회?�� PDF_K101Y
	 * @exception Exception
	 */
    public PdfK101y_2023_VO selectPdfK101y(PdfK101y_2023_VO vo) throws Exception {
        return (PdfK101y_2023_VO) selectByPk("pdfK101y_2023_DAO.selectPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101yList(PdfK101ySrh_2023_VO search_2023_VO) throws Exception {
        return list("pdfK101y_2023_DAO.selectPdfK101yList_D", search_2023_VO);
    }

    /**
	 * PDF_K101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101Y �? �??��
	 * @exception
	 */
    public int selectPdfK101yListTotCnt(PdfK101ySrh_2023_VO search_2023_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfK101y_2023_DAO.selectPdfK101yListTotCnt_S", search_2023_VO);
    }

}
