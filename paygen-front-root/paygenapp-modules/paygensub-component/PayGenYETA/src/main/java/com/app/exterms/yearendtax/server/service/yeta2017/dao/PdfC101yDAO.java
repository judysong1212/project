package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfC101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC101yDAO.java
 * @Description : PdfC101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC101yDAO")
public class PdfC101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_C101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC101y(PdfC101yVO vo) throws Exception {
        return (String)insert("pdfC101yDAO.insertPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC101y(PdfC101yVO vo) throws Exception {
        update("pdfC101yDAO.updatePdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC101y(PdfC101yVO vo) throws Exception {
        delete("pdfC101yDAO.deletePdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC101yVO
	 * @return 조회?�� PDF_C101Y
	 * @exception Exception
	 */
    public PdfC101yVO selectPdfC101y(PdfC101yVO vo) throws Exception {
        return (PdfC101yVO) selectByPk("pdfC101yDAO.selectPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC101yList(PdfC101ySrhVO searchVO) throws Exception {
        return list("pdfC101yDAO.selectPdfC101yList_D", searchVO);
    }

    /**
	 * PDF_C101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101Y �? �??��
	 * @exception
	 */
    public int selectPdfC101yListTotCnt(PdfC101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC101yDAO.selectPdfC101yListTotCnt_S", searchVO);
    }

}
