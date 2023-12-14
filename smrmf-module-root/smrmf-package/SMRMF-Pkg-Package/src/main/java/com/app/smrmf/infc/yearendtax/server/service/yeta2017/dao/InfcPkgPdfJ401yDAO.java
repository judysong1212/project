package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ401ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ401yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401yDAO.java
 * @Description : PdfJ401y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ401yDAO")
public class InfcPkgPdfJ401yDAO extends EgovAbstractDAO {

	/**
	 * PDF_J401Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401y(InfcPkgPdfJ401yVO vo) throws Exception {
        return (String)insert("infcPkgPdfJ401yDAO.insertPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401y(InfcPkgPdfJ401yVO vo) throws Exception {
        update("infcPkgPdfJ401yDAO.updatePdfJ401y_S", vo);
    }
    
    public void updateYetaP220001ToPdfJ401y(InfcPkgPdfJ401yVO vo) throws Exception {
    	update("infcPkgPdfJ401yDAO.updateYetaP220001ToPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401y(InfcPkgPdfJ401yVO vo) throws Exception {
        delete("infcPkgPdfJ401yDAO.deletePdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401yVO
	 * @return 조회?�� PDF_J401Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ401yVO selectPdfJ401y(InfcPkgPdfJ401yVO vo) throws Exception {
        return (InfcPkgPdfJ401yVO) selectByPk("infcPkgPdfJ401yDAO.selectPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401yList(InfcPkgPdfJ401ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfJ401yDAO.selectPdfJ401yList_D", searchVO);
    }

    /**
	 * PDF_J401Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y �? �??��
	 * @exception
	 */
    public int selectPdfJ401yListTotCnt(InfcPkgPdfJ401ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ401yDAO.selectPdfJ401yListTotCnt_S", searchVO);
    }

}
