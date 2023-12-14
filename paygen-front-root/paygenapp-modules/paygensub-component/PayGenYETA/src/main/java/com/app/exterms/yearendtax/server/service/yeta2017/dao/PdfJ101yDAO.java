package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101yDAO.java
 * @Description : PdfJ101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ101yDAO")
public class PdfJ101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_J101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101y(PdfJ101yVO vo) throws Exception {
        return (String)insert("pdfJ101yDAO.insertPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101y(PdfJ101yVO vo) throws Exception {
        update("pdfJ101yDAO.updatePdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101y(PdfJ101yVO vo) throws Exception {
        delete("pdfJ101yDAO.deletePdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101yVO
	 * @return 조회?�� PDF_J101Y
	 * @exception Exception
	 */
    public PdfJ101yVO selectPdfJ101y(PdfJ101yVO vo) throws Exception {
        return (PdfJ101yVO) selectByPk("pdfJ101yDAO.selectPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101yList(PdfJ101ySrhVO searchVO) throws Exception {
        return list("pdfJ101yDAO.selectPdfJ101yList_D", searchVO);
    }

    /**
	 * PDF_J101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y �? �??��
	 * @exception
	 */
    public int selectPdfJ101yListTotCnt(PdfJ101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ101yDAO.selectPdfJ101yListTotCnt_S", searchVO);
    }

}
