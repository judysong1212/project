package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC101ySrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfC101y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC101y_2018_DAO.java
 * @Description : PdfC101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC101y_2018_DAO")
public class PdfC101y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC101y(PdfC101y_2018_VO vo) throws Exception {
        return (String)insert("pdfC101y_2018_DAO.insertPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC101y(PdfC101y_2018_VO vo) throws Exception {
        update("pdfC101y_2018_DAO.updatePdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC101y(PdfC101y_2018_VO vo) throws Exception {
        delete("pdfC101y_2018_DAO.deletePdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC101yVO
	 * @return 조회?�� PDF_C101Y
	 * @exception Exception
	 */
    public PdfC101y_2018_VO selectPdfC101y(PdfC101y_2018_VO vo) throws Exception {
        return (PdfC101y_2018_VO) selectByPk("pdfC101y_2018_DAO.selectPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC101yList(PdfC101ySrh_2018_VO searchVO) throws Exception {
        return list("pdfC101y_2018_DAO.selectPdfC101yList_D", searchVO);
    }

    /**
	 * PDF_C101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101Y �? �??��
	 * @exception
	 */
    public int selectPdfC101yListTotCnt(PdfC101ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC101y_2018_DAO.selectPdfC101yListTotCnt_S", searchVO);
    }

}
