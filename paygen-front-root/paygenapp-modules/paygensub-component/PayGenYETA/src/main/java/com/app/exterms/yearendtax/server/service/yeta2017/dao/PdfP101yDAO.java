package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfP101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfP101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101yDAO.java
 * @Description : PdfP101y DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfP101yDAO")
public class PdfP101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_P101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101y(PdfP101yVO vo) throws Exception {
        return (String)insert("pdfP101yDAO.insertPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101y(PdfP101yVO vo) throws Exception {
        update("pdfP101yDAO.updatePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101y(PdfP101yVO vo) throws Exception {
        delete("pdfP101yDAO.deletePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101yVO
	 * @return 조회?�� PDF_P101Y
	 * @exception Exception
	 */
    public PdfP101yVO selectPdfP101y(PdfP101yVO vo) throws Exception {
        return (PdfP101yVO) selectByPk("pdfP101yDAO.selectPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101yList(PdfP101ySrhVO searchVO) throws Exception {
        return list("pdfP101yDAO.selectPdfP101yList_D", searchVO);
    }

    /**
	 * PDF_P101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y �? �??��
	 * @exception
	 */
    public int selectPdfP101yListTotCnt(PdfP101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfP101yDAO.selectPdfP101yListTotCnt_S", searchVO);
    }

}
