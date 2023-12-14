package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfN101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfN101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101yDAO.java
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

@Repository("PdfN101yDAO")
public class PdfN101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_N101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101y(PdfN101yVO vo) throws Exception {
        return (String)insert("pdfN101yDAO.insertPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101y(PdfN101yVO vo) throws Exception {
        update("pdfN101yDAO.updatePdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101y(PdfN101yVO vo) throws Exception {
        delete("pdfN101yDAO.deletePdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101yVO
	 * @return 조회?�� PDF_N101Y
	 * @exception Exception
	 */
    public PdfN101yVO selectPdfN101y(PdfN101yVO vo) throws Exception {
        return (PdfN101yVO) selectByPk("pdfN101yDAO.selectPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101yList(PdfN101ySrhVO searchVO) throws Exception {
        return list("pdfN101yDAO.selectPdfN101yList_D", searchVO);
    }

    /**
	 * PDF_N101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y �? �??��
	 * @exception
	 */
    public int selectPdfN101yListTotCnt(PdfN101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfN101yDAO.selectPdfN101yListTotCnt_S", searchVO);
    }

}
