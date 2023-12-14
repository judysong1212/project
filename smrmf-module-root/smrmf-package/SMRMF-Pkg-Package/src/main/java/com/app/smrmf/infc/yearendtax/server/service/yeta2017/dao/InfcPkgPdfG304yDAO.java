package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304yDAO.java
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

@Repository("InfcPkgPdfG304yDAO")
public class InfcPkgPdfG304yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G304Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304y(InfcPkgPdfG304yVO vo) throws Exception {
        return (String)insert("infcPkgPdfG304yDAO.insertPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304y(InfcPkgPdfG304yVO vo) throws Exception {
        update("infcPkgPdfG304yDAO.updatePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304y(InfcPkgPdfG304yVO vo) throws Exception {
        delete("infcPkgPdfG304yDAO.deletePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304yVO
	 * @return 조회?�� PDF_G304Y
	 * @exception Exception
	 */
    public InfcPkgPdfG304yVO selectPdfG304y(InfcPkgPdfG304yVO vo) throws Exception {
        return (InfcPkgPdfG304yVO) selectByPk("infcPkgPdfG304yDAO.selectPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304yList(InfcPkgPdfG304ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfG304yDAO.selectPdfG304yList_D", searchVO);
    }

    /**
	 * PDF_G304Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y �? �??��
	 * @exception
	 */
    public int selectPdfG304yListTotCnt(InfcPkgPdfG304ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG304yDAO.selectPdfG304yListTotCnt_S", searchVO);
    }

}
