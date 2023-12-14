package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ301ySrh_2023_VO;
import com.app.exterms.yearendtax.server.vo.PdfJ301y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301y_2023_DAO.java
 * @Description : PdfJ301y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfJ301y_2023_DAO")
public class PdfJ301y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301y_2023_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301y(PdfJ301y_2023_VO vo) throws Exception {
        return (String)insert("pdfJ301y_2023_DAO.insertPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301y_2023_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301y(PdfJ301y_2023_VO vo) throws Exception {
        update("pdfJ301y_2023_DAO.updatePdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301y_2023_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301y(PdfJ301y_2023_VO vo) throws Exception {
        delete("pdfJ301y_2023_DAO.deletePdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301y_2023_VO
	 * @return 조회?�� PDF_J301Y
	 * @exception Exception
	 */
    public PdfJ301y_2023_VO selectPdfJ301y(PdfJ301y_2023_VO vo) throws Exception {
        return (PdfJ301y_2023_VO) selectByPk("pdfJ301y_2023_DAO.selectPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301yList(PdfJ301ySrh_2023_VO search_2023_VO) throws Exception {
        return list("pdfJ301y_2023_DAO.selectPdfJ301yList_D", search_2023_VO);
    }

    /**
	 * PDF_J301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301Y �? �??��
	 * @exception
	 */
    public int selectPdfJ301yListTotCnt(PdfJ301ySrh_2023_VO search_2023_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ301y_2023_DAO.selectPdfJ301yListTotCnt_S", search_2023_VO);
    }

}
