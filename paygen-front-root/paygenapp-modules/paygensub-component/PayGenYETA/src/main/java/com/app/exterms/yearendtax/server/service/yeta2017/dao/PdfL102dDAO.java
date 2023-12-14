package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfL102dSrhVO;
import com.app.exterms.yearendtax.server.vo.PdfL102dVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102dDAO.java
 * @Description : PdfL102d DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfL102dDAO")
public class PdfL102dDAO extends EgovAbstractDAO {

	/**
	 * PDF_L102D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102dVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102d(PdfL102dVO vo) throws Exception {
        return (String)insert("pdfL102dDAO.insertPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102dVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102d(PdfL102dVO vo) throws Exception {
        update("pdfL102dDAO.updatePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102dVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102d(PdfL102dVO vo) throws Exception {
        delete("pdfL102dDAO.deletePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102dVO
	 * @return 조회?�� PDF_L102D
	 * @exception Exception
	 */
    public PdfL102dVO selectPdfL102d(PdfL102dVO vo) throws Exception {
        return (PdfL102dVO) selectByPk("pdfL102dDAO.selectPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102dList(PdfL102dSrhVO searchVO) throws Exception {
        return list("pdfL102dDAO.selectPdfL102dList_D", searchVO);
    }

    /**
	 * PDF_L102D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D �? �??��
	 * @exception
	 */
    public int selectPdfL102dListTotCnt(PdfL102dSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfL102dDAO.selectPdfL102dListTotCnt_S", searchVO);
    }

}
