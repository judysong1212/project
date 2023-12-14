package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG205yDAO.java
 * @Description : PdfG205y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG205yDAO")
public class InfcPkgPdfG205yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G205Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG205yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG205y(InfcPkgPdfG205yVO vo) throws Exception {
        return (String)insert("infcPkgPdfG205yDAO.insertPdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG205y(InfcPkgPdfG205yVO vo) throws Exception {
        update("infcPkgPdfG205yDAO.updatePdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG205y(InfcPkgPdfG205yVO vo) throws Exception {
        delete("infcPkgPdfG205yDAO.deletePdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG205yVO
	 * @return 조회?�� PDF_G205Y
	 * @exception Exception
	 */
    public InfcPkgPdfG205yVO selectPdfG205y(InfcPkgPdfG205yVO vo) throws Exception {
        return (InfcPkgPdfG205yVO) selectByPk("infcPkgPdfG205yDAO.selectPdfG205y_S", vo);
    }

    /**
	 * PDF_G205Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG205yList(InfcPkgPdfG205ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfG205yDAO.selectPdfG205yList_D", searchVO);
    }

    /**
	 * PDF_G205Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205Y �? �??��
	 * @exception
	 */
    public int selectPdfG205yListTotCnt(InfcPkgPdfG205ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG205yDAO.selectPdfG205yListTotCnt_S", searchVO);
    }

}
