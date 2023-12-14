package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfD101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfD101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101yDAO.java
 * @Description : PdfD101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfD101yDAO")
public class PdfD101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_D101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101y(PdfD101yVO vo) throws Exception {
        return (String)insert("pdfD101yDAO.insertPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101y(PdfD101yVO vo) throws Exception {
        update("pdfD101yDAO.updatePdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101y(PdfD101yVO vo) throws Exception {
        delete("pdfD101yDAO.deletePdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101yVO
	 * @return 조회?�� PDF_D101Y
	 * @exception Exception
	 */
    public PdfD101yVO selectPdfD101y(PdfD101yVO vo) throws Exception {
        return (PdfD101yVO) selectByPk("pdfD101yDAO.selectPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101yList(PdfD101ySrhVO searchVO) throws Exception {
        return list("pdfD101yDAO.selectPdfD101yList_D", searchVO);
    }

    /**
	 * PDF_D101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y �? �??��
	 * @exception
	 */
    public int selectPdfD101yListTotCnt(PdfD101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfD101yDAO.selectPdfD101yListTotCnt_S", searchVO);
    }

}
