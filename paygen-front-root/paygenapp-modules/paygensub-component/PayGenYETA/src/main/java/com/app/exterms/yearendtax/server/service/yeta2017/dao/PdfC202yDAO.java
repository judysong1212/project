package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC202ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfC202yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202yDAO.java
 * @Description : PdfC202y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC202yDAO")
public class PdfC202yDAO extends EgovAbstractDAO {

	/**
	 * PDF_C202Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202y(PdfC202yVO vo) throws Exception {
        return (String)insert("pdfC202yDAO.insertPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202y(PdfC202yVO vo) throws Exception {
        update("pdfC202yDAO.updatePdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202y(PdfC202yVO vo) throws Exception {
        delete("pdfC202yDAO.deletePdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202yVO
	 * @return 조회?�� PDF_C202Y
	 * @exception Exception
	 */
    public PdfC202yVO selectPdfC202y(PdfC202yVO vo) throws Exception {
        return (PdfC202yVO) selectByPk("pdfC202yDAO.selectPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202yList(PdfC202ySrhVO searchVO) throws Exception {
        return list("pdfC202yDAO.selectPdfC202yList_D", searchVO);
    }

    /**
	 * PDF_C202Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y �? �??��
	 * @exception
	 */
    public int selectPdfC202yListTotCnt(PdfC202ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC202yDAO.selectPdfC202yListTotCnt_S", searchVO);
    }

}
