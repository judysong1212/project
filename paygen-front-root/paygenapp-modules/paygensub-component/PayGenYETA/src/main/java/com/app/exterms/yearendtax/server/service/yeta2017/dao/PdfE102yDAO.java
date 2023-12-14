package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfE102ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfE102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102yDAO.java
 * @Description : PdfE102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfE102yDAO")
public class PdfE102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_E102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102y(PdfE102yVO vo) throws Exception {
        return (String)insert("pdfE102yDAO.insertPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102y(PdfE102yVO vo) throws Exception {
        update("pdfE102yDAO.updatePdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102y(PdfE102yVO vo) throws Exception {
        delete("pdfE102yDAO.deletePdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102yVO
	 * @return 조회?�� PDF_E102Y
	 * @exception Exception
	 */
    public PdfE102yVO selectPdfE102y(PdfE102yVO vo) throws Exception {
        return (PdfE102yVO) selectByPk("pdfE102yDAO.selectPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102yList(PdfE102ySrhVO searchVO) throws Exception {
        return list("pdfE102yDAO.selectPdfE102yList_D", searchVO);
    }

    /**
	 * PDF_E102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y �? �??��
	 * @exception
	 */
    public int selectPdfE102yListTotCnt(PdfE102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfE102yDAO.selectPdfE102yListTotCnt_S", searchVO);
    }

}
