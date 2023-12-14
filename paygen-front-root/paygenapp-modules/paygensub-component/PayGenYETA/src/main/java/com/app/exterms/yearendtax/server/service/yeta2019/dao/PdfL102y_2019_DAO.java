package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfL102ySrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.PdfL102y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102y_2019_DAO.java
 * @Description : PdfL102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfL102y_2019_DAO")
public class PdfL102y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_L102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102y_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102y(PdfL102y_2019_VO vo) throws Exception {
        return (String)insert("pdfL102y_2019_DAO.insertPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102y_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102y(PdfL102y_2019_VO vo) throws Exception {
        update("pdfL102y_2019_DAO.updatePdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102y_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102y(PdfL102y_2019_VO vo) throws Exception {
        delete("pdfL102y_2019_DAO.deletePdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102y_2019_VO
	 * @return 조회?�� PDF_L102Y
	 * @exception Exception
	 */
    public PdfL102y_2019_VO selectPdfL102y(PdfL102y_2019_VO vo) throws Exception {
        return (PdfL102y_2019_VO) selectByPk("pdfL102y_2019_DAO.selectPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102yList(PdfL102ySrh_2019_VO search_2019_VO) throws Exception {
        return list("pdfL102y_2019_DAO.selectPdfL102yList_D", search_2019_VO);
    }

    /**
	 * PDF_L102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y �? �??��
	 * @exception
	 */
    public int selectPdfL102yListTotCnt(PdfL102ySrh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfL102y_2019_DAO.selectPdfL102yListTotCnt_S", search_2019_VO);
    }

}
