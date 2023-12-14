package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfO101ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfO101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101yDAO.java
 * @Description : PdfO101y DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfO101yDAO")
public class PdfO101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_O101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101y(PdfO101yVO vo) throws Exception {
        return (String)insert("pdfO101yDAO.insertPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101y(PdfO101yVO vo) throws Exception {
        update("pdfO101yDAO.updatePdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101y(PdfO101yVO vo) throws Exception {
        delete("pdfO101yDAO.deletePdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101yVO
	 * @return 조회?�� PDF_O101Y
	 * @exception Exception
	 */
    public PdfO101yVO selectPdfO101y(PdfO101yVO vo) throws Exception {
        return (PdfO101yVO) selectByPk("pdfO101yDAO.selectPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101yList(PdfO101ySrhVO searchVO) throws Exception {
        return list("pdfO101yDAO.selectPdfO101yList_D", searchVO);
    }

    /**
	 * PDF_O101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y �? �??��
	 * @exception
	 */
    public int selectPdfO101yListTotCnt(PdfO101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfO101yDAO.selectPdfO101yListTotCnt_S", searchVO);
    }

}
