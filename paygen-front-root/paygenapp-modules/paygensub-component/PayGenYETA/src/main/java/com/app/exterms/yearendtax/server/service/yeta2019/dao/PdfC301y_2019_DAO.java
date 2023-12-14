package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC301ySrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.PdfC301y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC301y_2019_DAO.java
 * @Description : PdfC301y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfC301y_2019_DAO")
public class PdfC301y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC301y_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC301y(PdfC301y_2019_VO vo) throws Exception {
        return (String)insert("pdfC301y_2019_DAO.insertPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301y_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC301y(PdfC301y_2019_VO vo) throws Exception {
        update("pdfC301y_2019_DAO.updatePdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301y_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC301y(PdfC301y_2019_VO vo) throws Exception {
        delete("pdfC301y_2019_DAO.deletePdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC301y_2019_VO
	 * @return 조회?�� PDF_C301Y
	 * @exception Exception
	 */
    public PdfC301y_2019_VO selectPdfC301y(PdfC301y_2019_VO vo) throws Exception {
        return (PdfC301y_2019_VO) selectByPk("pdfC301y_2019_DAO.selectPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC301yList(PdfC301ySrh_2019_VO search_2019_VO) throws Exception {
        return list("pdfC301y_2019_DAO.selectPdfC301yList_D", search_2019_VO);
    }

    /**
	 * PDF_C301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y �? �??��
	 * @exception
	 */
    public int selectPdfC301yListTotCnt(PdfC301ySrh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC301y_2019_DAO.selectPdfC301yListTotCnt_S", search_2019_VO);
    }

}
