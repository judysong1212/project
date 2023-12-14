package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG304ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfG304yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304yDAO.java
 * @Description : PdfG304y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG304yDAO")
public class PdfG304yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G304Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304y(PdfG304yVO vo) throws Exception {
        return (String)insert("pdfG304yDAO.insertPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304y(PdfG304yVO vo) throws Exception {
        update("pdfG304yDAO.updatePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304y(PdfG304yVO vo) throws Exception {
        delete("pdfG304yDAO.deletePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304yVO
	 * @return 조회?�� PDF_G304Y
	 * @exception Exception
	 */
    public PdfG304yVO selectPdfG304y(PdfG304yVO vo) throws Exception {
        return (PdfG304yVO) selectByPk("pdfG304yDAO.selectPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304yList(PdfG304ySrhVO searchVO) throws Exception {
        return list("pdfG304yDAO.selectPdfG304yList_D", searchVO);
    }

    /**
	 * PDF_G304Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y �? �??��
	 * @exception
	 */
    public int selectPdfG304yListTotCnt(PdfG304ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG304yDAO.selectPdfG304yListTotCnt_S", searchVO);
    }

}
