package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfO101ySrh_2019_VO;
import com.app.exterms.yearendtax.server.vo.PdfO101y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101y_2019_DAO.java
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

@Repository("PdfO101y_2019_DAO")
public class PdfO101y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_O101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101y_2019_VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101y(PdfO101y_2019_VO vo) throws Exception {
        return (String)insert("pdfO101y_2019_DAO.insertPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101y_2019_VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101y(PdfO101y_2019_VO vo) throws Exception {
        update("pdfO101y_2019_DAO.updatePdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101y_2019_VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101y(PdfO101y_2019_VO vo) throws Exception {
        delete("pdfO101y_2019_DAO.deletePdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101y_2019_VO
	 * @return 조회?�� PDF_O101Y
	 * @exception Exception
	 */
    public PdfO101y_2019_VO selectPdfO101y(PdfO101y_2019_VO vo) throws Exception {
        return (PdfO101y_2019_VO) selectByPk("pdfO101y_2019_DAO.selectPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101yList(PdfO101ySrh_2019_VO search_2019_VO) throws Exception {
        return list("pdfO101y_2019_DAO.selectPdfO101yList_D", search_2019_VO);
    }

    /**
	 * PDF_O101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y �? �??��
	 * @exception
	 */
    public int selectPdfO101yListTotCnt(PdfO101ySrh_2019_VO search_2019_VO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfO101y_2019_DAO.selectPdfO101yListTotCnt_S", search_2019_VO);
    }

}
