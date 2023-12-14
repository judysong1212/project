package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfJ301ySrhVO;
import com.app.exterms.yearendtax.server.vo.PdfJ301yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301yDAO.java
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

@Repository("PdfJ301yDAO")
public class PdfJ301yDAO extends EgovAbstractDAO {

	/**
	 * PDF_J301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301y(PdfJ301yVO vo) throws Exception {
        return (String)insert("pdfJ301yDAO.insertPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301y(PdfJ301yVO vo) throws Exception {
        update("pdfJ301yDAO.updatePdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301y(PdfJ301yVO vo) throws Exception {
        delete("pdfJ301yDAO.deletePdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301yVO
	 * @return 조회?�� PDF_J301Y
	 * @exception Exception
	 */
    public PdfJ301yVO selectPdfJ301y(PdfJ301yVO vo) throws Exception {
        return (PdfJ301yVO) selectByPk("pdfJ301yDAO.selectPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301yList(PdfJ301ySrhVO searchVO) throws Exception {
        return list("pdfJ301yDAO.selectPdfJ301yList_D", searchVO);
    }

    /**
	 * PDF_J301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301Y �? �??��
	 * @exception
	 */
    public int selectPdfJ301yListTotCnt(PdfJ301ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfJ301yDAO.selectPdfJ301yListTotCnt_S", searchVO);
    }

}
