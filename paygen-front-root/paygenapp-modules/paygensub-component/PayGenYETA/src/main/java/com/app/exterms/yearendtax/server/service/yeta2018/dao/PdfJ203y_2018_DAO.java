package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ203ySrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ203y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ203y_2018_DAO.java
 * @Description : PdfJ203y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ203y_2018_DAO")
public class PdfJ203y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J203Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ203yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ203y(PdfJ203y_2018_VO vo) throws Exception {
        return (String)insert("pdfJ203y_2018_DAO.insertPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ203y(PdfJ203y_2018_VO vo) throws Exception {
        update("pdfJ203y_2018_DAO.updatePdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ203y(PdfJ203y_2018_VO vo) throws Exception {
        delete("pdfJ203y_2018_DAO.deletePdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ203yVO
	 * @return 조회?�� PDF_J203Y
	 * @exception Exception
	 */
    public PdfJ203y_2018_VO selectPdfJ203y(PdfJ203y_2018_VO vo) throws Exception {
        return (PdfJ203y_2018_VO) selectByPk("pdfJ203y_2018_DAO.selectPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ203yList(PdfJ203ySrh_2018_VO searchVO) throws Exception {
        return list("pdfJ203y_2018_DAO.selectPdfJ203yList_D", searchVO);
    }

    /**
	 * PDF_J203Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203Y �? �??��
	 * @exception
	 */
    public int selectPdfJ203yListTotCnt(PdfJ203ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ203y_2018_DAO.selectPdfJ203yListTotCnt_S", searchVO);
    }

}
