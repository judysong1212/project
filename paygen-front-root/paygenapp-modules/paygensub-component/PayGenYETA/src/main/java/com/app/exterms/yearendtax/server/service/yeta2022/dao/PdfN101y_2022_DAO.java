package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfN101ySrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfN101y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101y_2022_DAO.java
 * @Description : PdfN101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfN101y_2022_DAO")
public class PdfN101y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_N101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101y_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101y(PdfN101y_2022_VO vo) throws Exception {
        return (String)insert("pdfN101y_2022_DAO.insertPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101y_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101y(PdfN101y_2022_VO vo) throws Exception {
        update("pdfN101y_2022_DAO.updatePdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101y_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101y(PdfN101y_2022_VO vo) throws Exception {
        delete("pdfN101y_2022_DAO.deletePdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101y_2022_VO
	 * @return 조회?�� PDF_N101Y
	 * @exception Exception
	 */
    public PdfN101y_2022_VO selectPdfN101y(PdfN101y_2022_VO vo) throws Exception {
        return (PdfN101y_2022_VO) selectByPk("pdfN101y_2022_DAO.selectPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101yList(PdfN101ySrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfN101y_2022_DAO.selectPdfN101yList_D", search_2022_VO);
    }

    /**
	 * PDF_N101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y �? �??��
	 * @exception
	 */
    public int selectPdfN101yListTotCnt(PdfN101ySrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfN101y_2022_DAO.selectPdfN101yListTotCnt_S", search_2022_VO);
    }

}
