package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfA102ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfA102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102yDAO.java
 * @Description : PdfA102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfA102yDAO")
public class PdfA102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_A102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102y(PdfA102yVO vo) throws Exception {
        return (String)insert("pdfA102yDAO.insertPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102y(PdfA102yVO vo) throws Exception {
        update("pdfA102yDAO.updatePdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102y(PdfA102yVO vo) throws Exception {
        delete("pdfA102yDAO.deletePdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102yVO
	 * @return 조회?�� PDF_A102Y
	 * @exception Exception
	 */
    public PdfA102yVO selectPdfA102y(PdfA102yVO vo) throws Exception {
        return (PdfA102yVO) selectByPk("pdfA102yDAO.selectPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102yList(PdfA102ySrhVO searchVO) throws Exception {
        return list("pdfA102yDAO.selectPdfA102yList_D", searchVO);
    }

    /**
	 * PDF_A102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y �? �??��
	 * @exception
	 */
    public int selectPdfA102yListTotCnt(PdfA102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfA102yDAO.selectPdfA102yListTotCnt_S", searchVO);
    }

}
