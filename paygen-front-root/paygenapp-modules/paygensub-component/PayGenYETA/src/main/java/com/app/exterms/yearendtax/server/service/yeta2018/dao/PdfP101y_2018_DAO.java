package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfP101ySrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfP101y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101y_2018_DAO.java
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

@Repository("PdfP101y_2018_DAO")
public class PdfP101y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_P101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101y(PdfP101y_2018_VO vo) throws Exception {
        return (String)insert("pdfP101y_2018_DAO.insertPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101y(PdfP101y_2018_VO vo) throws Exception {
        update("pdfP101y_2018_DAO.updatePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101y(PdfP101y_2018_VO vo) throws Exception {
        delete("pdfP101y_2018_DAO.deletePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101yVO
	 * @return 조회?�� PDF_P101Y
	 * @exception Exception
	 */
    public PdfP101y_2018_VO selectPdfP101y(PdfP101y_2018_VO vo) throws Exception {
        return (PdfP101y_2018_VO) selectByPk("pdfP101y_2018_DAO.selectPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101yList(PdfP101ySrh_2018_VO searchVO) throws Exception {
        return list("pdfP101y_2018_DAO.selectPdfP101yList_D", searchVO);
    }

    /**
	 * PDF_P101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y �? �??��
	 * @exception
	 */
    public int selectPdfP101yListTotCnt(PdfP101ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfP101y_2018_DAO.selectPdfP101yListTotCnt_S", searchVO);
    }

}
