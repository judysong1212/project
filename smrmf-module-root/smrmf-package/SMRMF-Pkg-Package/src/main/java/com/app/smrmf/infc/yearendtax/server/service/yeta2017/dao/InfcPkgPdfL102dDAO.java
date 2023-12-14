package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102dSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102dVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102dDAO.java
 * @Description : PdfL102d DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfL102dDAO")
public class InfcPkgPdfL102dDAO extends EgovAbstractDAO {

	/**
	 * PDF_L102D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102dVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102d(InfcPkgPdfL102dVO vo) throws Exception {
        return (String)insert("infcPkgPdfL102dDAO.insertPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102dVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102d(InfcPkgPdfL102dVO vo) throws Exception {
        update("infcPkgPdfL102dDAO.updatePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102dVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102d(InfcPkgPdfL102dVO vo) throws Exception {
        delete("infcPkgPdfL102dDAO.deletePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102dVO
	 * @return 조회?�� PDF_L102D
	 * @exception Exception
	 */
    public InfcPkgPdfL102dVO selectPdfL102d(InfcPkgPdfL102dVO vo) throws Exception {
        return (InfcPkgPdfL102dVO) selectByPk("infcPkgPdfL102dDAO.selectPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102dList(InfcPkgPdfL102dSrhVO searchVO) throws Exception {
        return list("infcPkgPdfL102dDAO.selectPdfL102dList_D", searchVO);
    }

    /**
	 * PDF_L102D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D �? �??��
	 * @exception
	 */
    public int selectPdfL102dListTotCnt(InfcPkgPdfL102dSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfL102dDAO.selectPdfL102dListTotCnt_S", searchVO);
    }

}
