package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfL102ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfL102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102yDAO.java
 * @Description : PdfL102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfL102yDAO")
public class PdfL102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_L102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102y(PdfL102yVO vo) throws Exception {
        return (String)insert("pdfL102yDAO.insertPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102y(PdfL102yVO vo) throws Exception {
        update("pdfL102yDAO.updatePdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102y(PdfL102yVO vo) throws Exception {
        delete("pdfL102yDAO.deletePdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102yVO
	 * @return 조회?�� PDF_L102Y
	 * @exception Exception
	 */
    public PdfL102yVO selectPdfL102y(PdfL102yVO vo) throws Exception {
        return (PdfL102yVO) selectByPk("pdfL102yDAO.selectPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102yList(PdfL102ySrhVO searchVO) throws Exception {
        return list("pdfL102yDAO.selectPdfL102yList_D", searchVO);
    }

    /**
	 * PDF_L102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y �? �??��
	 * @exception
	 */
    public int selectPdfL102yListTotCnt(PdfL102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfL102yDAO.selectPdfL102yListTotCnt_S", searchVO);
    }

}
