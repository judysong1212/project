package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfE102ySrh_2020_VO;
import com.app.exterms.yearendtax.server.vo.PdfE102y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102y_2020_DAO.java
 * @Description : PdfE102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfE102y_2020_DAO")
public class PdfE102y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_E102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102y_2020_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102y(PdfE102y_2020_VO vo) throws Exception {
        return (String)insert("pdfE102y_2020_DAO.insertPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102y_2020_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102y(PdfE102y_2020_VO vo) throws Exception {
        update("pdfE102y_2020_DAO.updatePdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102y_2020_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102y(PdfE102y_2020_VO vo) throws Exception {
        delete("pdfE102y_2020_DAO.deletePdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102y_2020_VO
	 * @return 조회?�� PDF_E102Y
	 * @exception Exception
	 */
    public PdfE102y_2020_VO selectPdfE102y(PdfE102y_2020_VO vo) throws Exception {
        return (PdfE102y_2020_VO) selectByPk("pdfE102y_2020_DAO.selectPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102yList(PdfE102ySrh_2020_VO search_2020_VO) throws Exception {
        return list("pdfE102y_2020_DAO.selectPdfE102yList_D", search_2020_VO);
    }

    /**
	 * PDF_E102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y �? �??��
	 * @exception
	 */
    public int selectPdfE102yListTotCnt(PdfE102ySrh_2020_VO search_2020_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfE102y_2020_DAO.selectPdfE102yListTotCnt_S", search_2020_VO);
    }

}
