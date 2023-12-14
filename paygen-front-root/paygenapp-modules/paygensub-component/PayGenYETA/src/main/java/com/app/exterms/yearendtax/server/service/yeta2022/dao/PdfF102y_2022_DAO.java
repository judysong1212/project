package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfF102ySrh_2022_VO;
import com.app.exterms.yearendtax.server.vo.PdfF102y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102y_2022_DAO.java
 * @Description : PdfF102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfF102y_2022_DAO")
public class PdfF102y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_F102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102y_2022_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102y(PdfF102y_2022_VO vo) throws Exception {
        return (String)insert("pdfF102y_2022_DAO.insertPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102y_2022_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102y(PdfF102y_2022_VO vo) throws Exception {
        update("pdfF102y_2022_DAO.updatePdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102y_2022_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102y(PdfF102y_2022_VO vo) throws Exception {
        delete("pdfF102y_2022_DAO.deletePdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102y_2022_VO
	 * @return 조회?�� PDF_F102Y
	 * @exception Exception
	 */
    public PdfF102y_2022_VO selectPdfF102y(PdfF102y_2022_VO vo) throws Exception {
        return (PdfF102y_2022_VO) selectByPk("pdfF102y_2022_DAO.selectPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102yList(PdfF102ySrh_2022_VO search_2022_VO) throws Exception {
        return list("pdfF102y_2022_DAO.selectPdfF102yList_D", search_2022_VO);
    }

    /**
	 * PDF_F102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y �? �??��
	 * @exception
	 */
    public int selectPdfF102yListTotCnt(PdfF102ySrh_2022_VO search_2022_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfF102y_2022_DAO.selectPdfF102yListTotCnt_S", search_2022_VO);
    }

}
