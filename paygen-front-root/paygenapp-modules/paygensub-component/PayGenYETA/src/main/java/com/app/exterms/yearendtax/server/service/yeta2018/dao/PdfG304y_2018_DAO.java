package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfG304ySrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfG304y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304y_2018_DAO.java
 * @Description : PdfG304y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfG304y_2018_DAO")
public class PdfG304y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G304Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304y(PdfG304y_2018_VO vo) throws Exception {
        return (String)insert("pdfG304y_2018_DAO.insertPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304y(PdfG304y_2018_VO vo) throws Exception {
        update("pdfG304y_2018_DAO.updatePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304y(PdfG304y_2018_VO vo) throws Exception {
        delete("pdfG304y_2018_DAO.deletePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304yVO
	 * @return 조회?�� PDF_G304Y
	 * @exception Exception
	 */
    public PdfG304y_2018_VO selectPdfG304y(PdfG304y_2018_VO vo) throws Exception {
        return (PdfG304y_2018_VO) selectByPk("pdfG304y_2018_DAO.selectPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304yList(PdfG304ySrh_2018_VO searchVO) throws Exception {
        return list("pdfG304y_2018_DAO.selectPdfG304yList_D", searchVO);
    }

    /**
	 * PDF_G304Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y �? �??��
	 * @exception
	 */
    public int selectPdfG304yListTotCnt(PdfG304ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfG304y_2018_DAO.selectPdfG304yListTotCnt_S", searchVO);
    }

}
