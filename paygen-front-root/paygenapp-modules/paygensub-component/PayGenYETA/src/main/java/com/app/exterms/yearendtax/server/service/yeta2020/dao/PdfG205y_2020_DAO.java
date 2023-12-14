package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG205ySrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfG205y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG205y_2020_DAO.java
 * @Description : PdfG205y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG205y_2020_DAO")
public class PdfG205y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G205Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG205y_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG205y(PdfG205y_2020_VO vo) throws Exception {
        return (String)insert("pdfG205y_2020_DAO.insertPdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205y_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG205y(PdfG205y_2020_VO vo) throws Exception {
        update("pdfG205y_2020_DAO.updatePdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205y_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG205y(PdfG205y_2020_VO vo) throws Exception {
        delete("pdfG205y_2020_DAO.deletePdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG205y_2020_VO
	 * @return 조회?�� PDF_G205Y
	 * @exception Exception
	 */
    public PdfG205y_2020_VO selectPdfG205y(PdfG205y_2020_VO vo) throws Exception {
        return (PdfG205y_2020_VO) selectByPk("pdfG205y_2020_DAO.selectPdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG205yList(PdfG205ySrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfG205y_2020_DAO.selectPdfG205yList_D", search_2020_VO);
    }

    /**
	 * PDF_G205Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205Y �? �??��
	 * @exception
	 */
    public int selectPdfG205yListTotCnt(PdfG205ySrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG205y_2020_DAO.selectPdfG205yListTotCnt_S", search_2020_VO);
    }

}
