package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG104ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfG104yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG104yDAO.java
 * @Description : PdfG104y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG104yDAO")
public class PdfG104yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G104Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG104yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG104y(PdfG104yVO vo) throws Exception {
        return (String)insert("pdfG104yDAO.insertPdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG104y(PdfG104yVO vo) throws Exception {
        update("pdfG104yDAO.updatePdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG104y(PdfG104yVO vo) throws Exception {
        delete("pdfG104yDAO.deletePdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG104yVO
	 * @return 조회?�� PDF_G104Y
	 * @exception Exception
	 */
    public PdfG104yVO selectPdfG104y(PdfG104yVO vo) throws Exception {
        return (PdfG104yVO) selectByPk("pdfG104yDAO.selectPdfG104y_S", vo);
    }

    /**
	 * PDF_G104Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG104yList(PdfG104ySrhVO searchVO) throws Exception {
        return list("pdfG104yDAO.selectPdfG104yList_D", searchVO);
    }

    /**
	 * PDF_G104Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104Y �? �??��
	 * @exception
	 */
    public int selectPdfG104yListTotCnt(PdfG104ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG104yDAO.selectPdfG104yListTotCnt_S", searchVO);
    }

}
