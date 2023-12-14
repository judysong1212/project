package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC202ySrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfC202y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202y_2018_DAO.java
 * @Description : PdfC202y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC202y_2018_DAO")
public class PdfC202y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C202Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202y(PdfC202y_2018_VO vo) throws Exception {
        return (String)insert("pdfC202y_2018_DAO.insertPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202y(PdfC202y_2018_VO vo) throws Exception {
        update("pdfC202y_2018_DAO.updatePdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202y(PdfC202y_2018_VO vo) throws Exception {
        delete("pdfC202y_2018_DAO.deletePdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202yVO
	 * @return 조회?�� PDF_C202Y
	 * @exception Exception
	 */
    public PdfC202y_2018_VO selectPdfC202y(PdfC202y_2018_VO vo) throws Exception {
        return (PdfC202y_2018_VO) selectByPk("pdfC202y_2018_DAO.selectPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202yList(PdfC202ySrh_2018_VO searchVO) throws Exception {
        return list("pdfC202y_2018_DAO.selectPdfC202yList_D", searchVO);
    }

    /**
	 * PDF_C202Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y �? �??��
	 * @exception
	 */
    public int selectPdfC202yListTotCnt(PdfC202ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC202y_2018_DAO.selectPdfC202yListTotCnt_S", searchVO);
    }

}
