package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP102yDAO.java
 * @Description : PdfP102y DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfP102yDAO")
public class InfcPkgPdfP102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_P102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP102y(InfcPkgPdfP102yVO vo) throws Exception {
        return (String)insert("infcPkgPdfP102yDAO.insertPdfP102y_S", vo);
    }

    /**
	 * PDF_P102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP102y(InfcPkgPdfP102yVO vo) throws Exception {
        update("infcPkgPdfP102yDAO.updatePdfP102y_S", vo);
    }

    public void updateYetaP220001ToPdfP102y(InfcPkgPdfP102yVO vo) throws Exception {
    	update("infcPkgPdfP102yDAO.updateYetaP220001ToPdfP102y_S", vo);
    }
    
    /**
	 * PDF_P102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP102y(InfcPkgPdfP102yVO vo) throws Exception {
        delete("infcPkgPdfP102yDAO.deletePdfP102y_S", vo);
    }

    /**
	 * PDF_P102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP102yVO
	 * @return 조회?�� PDF_P102Y
	 * @exception Exception
	 */
    public InfcPkgPdfP102yVO selectPdfP102y(InfcPkgPdfP102yVO vo) throws Exception {
        return (InfcPkgPdfP102yVO) selectByPk("infcPkgPdfP102yDAO.selectPdfP102y_S", vo);
    }

    /**
	 * PDF_P102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP102yList(InfcPkgPdfP102ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfP102yDAO.selectPdfP102yList_D", searchVO);
    }

    /**
	 * PDF_P102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102Y �? �??��
	 * @exception
	 */
    public int selectPdfP102yListTotCnt(InfcPkgPdfP102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP102yDAO.selectPdfP102yListTotCnt_S", searchVO);
    }

}
