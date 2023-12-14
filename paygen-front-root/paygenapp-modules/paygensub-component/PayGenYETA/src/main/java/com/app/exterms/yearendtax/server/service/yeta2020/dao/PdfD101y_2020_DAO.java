package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfD101ySrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfD101y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101y_2020_DAO.java
 * @Description : PdfD101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfD101y_2020_DAO")
public class PdfD101y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_D101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101y_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101y(PdfD101y_2020_VO vo) throws Exception {
        return (String)insert("pdfD101y_2020_DAO.insertPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101y_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101y(PdfD101y_2020_VO vo) throws Exception {
        update("pdfD101y_2020_DAO.updatePdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101y_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101y(PdfD101y_2020_VO vo) throws Exception {
        delete("pdfD101y_2020_DAO.deletePdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101y_2020_VO
	 * @return 조회?�� PDF_D101Y
	 * @exception Exception
	 */
    public PdfD101y_2020_VO selectPdfD101y(PdfD101y_2020_VO vo) throws Exception {
        return (PdfD101y_2020_VO) selectByPk("pdfD101y_2020_DAO.selectPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101yList(PdfD101ySrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfD101y_2020_DAO.selectPdfD101yList_D", search_2020_VO);
    }

    /**
	 * PDF_D101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y �? �??��
	 * @exception
	 */
    public int selectPdfD101yListTotCnt(PdfD101ySrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfD101y_2020_DAO.selectPdfD101yListTotCnt_S", search_2020_VO);
    }

}
