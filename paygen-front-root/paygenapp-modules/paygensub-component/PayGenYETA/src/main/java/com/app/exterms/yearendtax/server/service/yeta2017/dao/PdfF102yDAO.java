package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfF102ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfF102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102yDAO.java
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

@Repository("PdfF102yDAO")
public class PdfF102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_F102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102y(PdfF102yVO vo) throws Exception {
        return (String)insert("pdfF102yDAO.insertPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102y(PdfF102yVO vo) throws Exception {
        update("pdfF102yDAO.updatePdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102y(PdfF102yVO vo) throws Exception {
        delete("pdfF102yDAO.deletePdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102yVO
	 * @return 조회?�� PDF_F102Y
	 * @exception Exception
	 */
    public PdfF102yVO selectPdfF102y(PdfF102yVO vo) throws Exception {
        return (PdfF102yVO) selectByPk("pdfF102yDAO.selectPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102yList(PdfF102ySrhVO searchVO) throws Exception {
        return list("pdfF102yDAO.selectPdfF102yList_D", searchVO);
    }

    /**
	 * PDF_F102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y �? �??��
	 * @exception
	 */
    public int selectPdfF102yListTotCnt(PdfF102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfF102yDAO.selectPdfF102yListTotCnt_S", searchVO);
    }

}
