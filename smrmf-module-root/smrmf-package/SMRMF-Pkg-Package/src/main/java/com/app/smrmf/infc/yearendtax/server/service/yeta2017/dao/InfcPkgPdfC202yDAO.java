package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202yDAO.java
 * @Description : PdfC202y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC202yDAO")
public class InfcPkgPdfC202yDAO extends EgovAbstractDAO {

	/**
	 * PDF_C202Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202y(InfcPkgPdfC202yVO vo) throws Exception {
        return (String)insert("infcPkgPdfC202yDAO.insertPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202y(InfcPkgPdfC202yVO vo) throws Exception {
        update("infcPkgPdfC202yDAO.updatePdfC202y_S", vo);
    }
    
    public void updateYetaP220001ToPdfC202y(InfcPkgPdfC202yVO vo) throws Exception {
    	update("infcPkgPdfC202yDAO.updateYetaP220001ToPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202y(InfcPkgPdfC202yVO vo) throws Exception {
        delete("infcPkgPdfC202yDAO.deletePdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202yVO
	 * @return 조회?�� PDF_C202Y
	 * @exception Exception
	 */
    public InfcPkgPdfC202yVO selectPdfC202y(InfcPkgPdfC202yVO vo) throws Exception {
        return (InfcPkgPdfC202yVO) selectByPk("infcPkgPdfC202yDAO.selectPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202yList(InfcPkgPdfC202ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfC202yDAO.selectPdfC202yList_D", searchVO);
    }

    /**
	 * PDF_C202Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y �? �??��
	 * @exception
	 */
    public int selectPdfC202yListTotCnt(InfcPkgPdfC202ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC202yDAO.selectPdfC202yListTotCnt_S", searchVO);
    }

}
