package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfC301ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfC301yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC301yDAO.java
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

@Repository("PdfC301yDAO")
public class PdfC301yDAO extends EgovAbstractDAO {

	/**
	 * PDF_C301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC301yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC301y(PdfC301yVO vo) throws Exception {
        return (String)insert("pdfC301yDAO.insertPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC301y(PdfC301yVO vo) throws Exception {
        update("pdfC301yDAO.updatePdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC301y(PdfC301yVO vo) throws Exception {
        delete("pdfC301yDAO.deletePdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC301yVO
	 * @return 조회?�� PDF_C301Y
	 * @exception Exception
	 */
    public PdfC301yVO selectPdfC301y(PdfC301yVO vo) throws Exception {
        return (PdfC301yVO) selectByPk("pdfC301yDAO.selectPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC301yList(PdfC301ySrhVO searchVO) throws Exception {
        return list("pdfC301yDAO.selectPdfC301yList_D", searchVO);
    }

    /**
	 * PDF_C301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y �? �??��
	 * @exception
	 */
    public int selectPdfC301yListTotCnt(PdfC301ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfC301yDAO.selectPdfC301yListTotCnt_S", searchVO);
    }

}
