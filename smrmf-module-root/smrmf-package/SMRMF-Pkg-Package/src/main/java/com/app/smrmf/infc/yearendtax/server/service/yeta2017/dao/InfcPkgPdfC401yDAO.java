package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC401yDAO.java
 * @Description : PdfC401y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC401yDAO")
public class InfcPkgPdfC401yDAO extends EgovAbstractDAO {

	/**
	 * PDF_C401Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC401yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC401y(InfcPkgPdfC401yVO vo) throws Exception {
        return (String)insert("infcPkgPdfC401yDAO.insertPdfC401y_S", vo);
    }

    /**
	 * PDF_C401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC401y(InfcPkgPdfC401yVO vo) throws Exception {
        update("infcPkgPdfC401yDAO.updatePdfC401y_S", vo);
    }

    public void updateYetaP220001ToPdfC401y(InfcPkgPdfC401yVO vo) throws Exception {
    	update("infcPkgPdfC401yDAO.updateYetaP220001ToPdfC401y_S", vo);
    }
    
    /**
	 * PDF_C401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC401y(InfcPkgPdfC401yVO vo) throws Exception {
        delete("infcPkgPdfC401yDAO.deletePdfC401y_S", vo);
    }

    /**
	 * PDF_C401Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC401yVO
	 * @return 조회?�� PDF_C401Y
	 * @exception Exception
	 */
    public InfcPkgPdfC401yVO selectPdfC401y(InfcPkgPdfC401yVO vo) throws Exception {
        return (InfcPkgPdfC401yVO) selectByPk("infcPkgPdfC401yDAO.selectPdfC401y_S", vo);
    }

    /**
	 * PDF_C401Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC401yList(InfcPkgPdfC401ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfC401yDAO.selectPdfC401yList_D", searchVO);
    }

    /**
	 * PDF_C401Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401Y �? �??��
	 * @exception
	 */
    public int selectPdfC401yListTotCnt(InfcPkgPdfC401ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC401yDAO.selectPdfC401yListTotCnt_S", searchVO);
    }

}
