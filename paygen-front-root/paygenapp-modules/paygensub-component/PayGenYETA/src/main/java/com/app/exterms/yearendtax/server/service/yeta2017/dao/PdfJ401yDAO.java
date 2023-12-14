package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ401ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ401yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401yDAO.java
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

@Repository("PdfJ401yDAO")
public class PdfJ401yDAO extends EgovAbstractDAO {

	/**
	 * PDF_J401Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401y(PdfJ401yVO vo) throws Exception {
        return (String)insert("pdfJ401yDAO.insertPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401y(PdfJ401yVO vo) throws Exception {
        update("pdfJ401yDAO.updatePdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401y(PdfJ401yVO vo) throws Exception {
        delete("pdfJ401yDAO.deletePdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401yVO
	 * @return 조회?�� PDF_J401Y
	 * @exception Exception
	 */
    public PdfJ401yVO selectPdfJ401y(PdfJ401yVO vo) throws Exception {
        return (PdfJ401yVO) selectByPk("pdfJ401yDAO.selectPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401yList(PdfJ401ySrhVO searchVO) throws Exception {
        return list("pdfJ401yDAO.selectPdfJ401yList_D", searchVO);
    }

    /**
	 * PDF_J401Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y �? �??��
	 * @exception
	 */
    public int selectPdfJ401yListTotCnt(PdfJ401ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ401yDAO.selectPdfJ401yListTotCnt_S", searchVO);
    }

}
