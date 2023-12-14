package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfL102dSrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfL102d_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102d_2020_DAO.java
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

@Repository("PdfL102d_2020_DAO")
public class PdfL102d_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_L102D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102d_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102d(PdfL102d_2020_VO vo) throws Exception {
        return (String)insert("pdfL102d_2020_DAO.insertPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102d_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102d(PdfL102d_2020_VO vo) throws Exception {
        update("pdfL102d_2020_DAO.updatePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102d_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102d(PdfL102d_2020_VO vo) throws Exception {
        delete("pdfL102d_2020_DAO.deletePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102d_2020_VO
	 * @return 조회?�� PDF_L102D
	 * @exception Exception
	 */
    public PdfL102d_2020_VO selectPdfL102d(PdfL102d_2020_VO vo) throws Exception {
        return (PdfL102d_2020_VO) selectByPk("pdfL102d_2020_DAO.selectPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102dList(PdfL102dSrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfL102d_2020_DAO.selectPdfL102dList_D", search_2020_VO);
    }

    /**
	 * PDF_L102D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D �? �??��
	 * @exception
	 */
    public int selectPdfL102dListTotCnt(PdfL102dSrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfL102d_2020_DAO.selectPdfL102dListTotCnt_S", search_2020_VO);
    }

}
