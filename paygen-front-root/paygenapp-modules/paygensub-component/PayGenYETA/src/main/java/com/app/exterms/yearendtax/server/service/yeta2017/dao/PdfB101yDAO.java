package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfB101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfB101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101yDAO.java
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

@Repository("PdfB101yDAO")
public class PdfB101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_B101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101y(PdfB101yVO vo) throws Exception {
        return (String)insert("pdfB101yDAO.insertPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101y(PdfB101yVO vo) throws Exception {
        update("pdfB101yDAO.updatePdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101y(PdfB101yVO vo) throws Exception {
        delete("pdfB101yDAO.deletePdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101yVO
	 * @return 조회?�� PDF_B101Y
	 * @exception Exception
	 */
    public PdfB101yVO selectPdfB101y(PdfB101yVO vo) throws Exception {
        return (PdfB101yVO) selectByPk("pdfB101yDAO.selectPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101yList(PdfB101ySrhVO searchVO) throws Exception {
        return list("pdfB101yDAO.selectPdfB101yList_D", searchVO);
    }

    /**
	 * PDF_B101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y �? �??��
	 * @exception
	 */
    public int selectPdfB101yListTotCnt(PdfB101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfB101yDAO.selectPdfB101yListTotCnt_S", searchVO);
    }

}
