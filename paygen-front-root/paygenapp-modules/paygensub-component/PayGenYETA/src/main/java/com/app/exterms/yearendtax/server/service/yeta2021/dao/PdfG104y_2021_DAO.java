package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG104ySrh_2021_VO;
import com.app.exterms.yearendtax.server.vo.PdfG104y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG104y_2021_DAO.java
 * @Description : PdfG104y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG104y_2021_DAO")
public class PdfG104y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G104Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG104y_2021_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG104y(PdfG104y_2021_VO vo) throws Exception {
        return (String)insert("pdfG104y_2021_DAO.insertPdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104y_2021_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG104y(PdfG104y_2021_VO vo) throws Exception {
        update("pdfG104y_2021_DAO.updatePdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104y_2021_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG104y(PdfG104y_2021_VO vo) throws Exception {
        delete("pdfG104y_2021_DAO.deletePdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG104y_2021_VO
	 * @return 조회?�� PDF_G104Y
	 * @exception Exception
	 */
    public PdfG104y_2021_VO selectPdfG104y(PdfG104y_2021_VO vo) throws Exception {
        return (PdfG104y_2021_VO) selectByPk("pdfG104y_2021_DAO.selectPdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG104yList(PdfG104ySrh_2021_VO search_2021_VO) throws Exception {
        return list("pdfG104y_2021_DAO.selectPdfG104yList_D", search_2021_VO);
    }

    /**
	 * PDF_G104Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104Y �? �??��
	 * @exception
	 */
    public int selectPdfG104yListTotCnt(PdfG104ySrh_2021_VO search_2021_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG104y_2021_DAO.selectPdfG104yListTotCnt_S", search_2021_VO);
    }

}
