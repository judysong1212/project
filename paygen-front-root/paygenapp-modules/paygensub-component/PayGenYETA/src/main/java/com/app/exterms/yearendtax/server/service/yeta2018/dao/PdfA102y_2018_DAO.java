package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.PdfA102ySrh_2018_VO;
import com.app.exterms.yearendtax.server.vo.PdfA102y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102y_2018_DAO.java
 * @Description : PdfA102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PdfA102y_2018_DAO")
public class PdfA102y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_A102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102y(PdfA102y_2018_VO vo) throws Exception {
        return (String)insert("pdfA102y_2018_DAO.insertPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102y(PdfA102y_2018_VO vo) throws Exception {
        update("pdfA102y_2018_DAO.updatePdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102y(PdfA102y_2018_VO vo) throws Exception {
        delete("pdfA102y_2018_DAO.deletePdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102yVO
	 * @return 조회?�� PDF_A102Y
	 * @exception Exception
	 */
    public PdfA102y_2018_VO selectPdfA102y(PdfA102y_2018_VO vo) throws Exception {
        return (PdfA102y_2018_VO) selectByPk("pdfA102y_2018_DAO.selectPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102yList(PdfA102ySrh_2018_VO searchVO) throws Exception {
        return list("pdfA102y_2018_DAO.selectPdfA102yList_D", searchVO);
    }

    /**
	 * PDF_A102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y �? �??��
	 * @exception
	 */
    public int selectPdfA102yListTotCnt(PdfA102ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pdfA102y_2018_DAO.selectPdfA102yListTotCnt_S", searchVO);
    }

}
