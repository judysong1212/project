package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfB101dSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfB101dVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101dDAO.java
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

@Repository("PdfB101dDAO")
public class PdfB101dDAO extends EgovAbstractDAO {

	/**
	 * PDF_B101D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101dVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101d(PdfB101dVO vo) throws Exception {
        return (String)insert("pdfB101dDAO.insertPdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101dVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101d(PdfB101dVO vo) throws Exception {
        update("pdfB101dDAO.updatePdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101dVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101d(PdfB101dVO vo) throws Exception {
        delete("pdfB101dDAO.deletePdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101dVO
	 * @return 조회?�� PDF_B101D
	 * @exception Exception
	 */
    public PdfB101dVO selectPdfB101d(PdfB101dVO vo) throws Exception {
        return (PdfB101dVO) selectByPk("pdfB101dDAO.selectPdfB101d_S", vo);
    }

    /**
	 * PDF_B101D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101dList(PdfB101dSrhVO searchVO) throws Exception {
        return list("pdfB101dDAO.selectPdfB101dList_D", searchVO);
    }

    /**
	 * PDF_B101D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101D �? �??��
	 * @exception
	 */
    public int selectPdfB101dListTotCnt(PdfB101dSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfB101dDAO.selectPdfB101dListTotCnt_S", searchVO);
    }

}
