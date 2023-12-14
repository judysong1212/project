package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ101ySrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ101y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101y_2022_DAO.java
 * @Description : PdfJ101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ101y_2022_DAO")
public class PdfJ101y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101y_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101y(PdfJ101y_2022_VO vo) throws Exception {
        return (String)insert("pdfJ101y_2022_DAO.insertPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101y_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101y(PdfJ101y_2022_VO vo) throws Exception {
        update("pdfJ101y_2022_DAO.updatePdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101y_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101y(PdfJ101y_2022_VO vo) throws Exception {
        delete("pdfJ101y_2022_DAO.deletePdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101y_2022_VO
	 * @return 조회?�� PDF_J101Y
	 * @exception Exception
	 */
    public PdfJ101y_2022_VO selectPdfJ101y(PdfJ101y_2022_VO vo) throws Exception {
        return (PdfJ101y_2022_VO) selectByPk("pdfJ101y_2022_DAO.selectPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101yList(PdfJ101ySrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfJ101y_2022_DAO.selectPdfJ101yList_D", search_2022_VO);
    }

    /**
	 * PDF_J101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y �? �??��
	 * @exception
	 */
    public int selectPdfJ101yListTotCnt(PdfJ101ySrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ101y_2022_DAO.selectPdfJ101yListTotCnt_S", search_2022_VO);
    }

}
