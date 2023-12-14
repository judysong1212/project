package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102yDAO.java
 * @Description : PdfL102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfL102yDAO")
public class InfcPkgPdfL102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_L102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102y(InfcPkgPdfL102yVO vo) throws Exception {
        return (String)insert("infcPkgPdfL102yDAO.insertPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102y(InfcPkgPdfL102yVO vo) throws Exception {
        update("infcPkgPdfL102yDAO.updatePdfL102y_S", vo);
    }
    
    public void updateYetaP220001ToPdfL102y(InfcPkgPdfL102yVO vo) throws Exception {
    	update("infcPkgPdfL102yDAO.updateYetaP220001ToPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102y(InfcPkgPdfL102yVO vo) throws Exception {
        delete("infcPkgPdfL102yDAO.deletePdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102yVO
	 * @return 조회?�� PDF_L102Y
	 * @exception Exception
	 */
    public InfcPkgPdfL102yVO selectPdfL102y(InfcPkgPdfL102yVO vo) throws Exception {
        return (InfcPkgPdfL102yVO) selectByPk("infcPkgPdfL102yDAO.selectPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102yList(InfcPkgPdfL102ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfL102yDAO.selectPdfL102yList_D", searchVO);
    }

    /**
	 * PDF_L102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y �? �??��
	 * @exception
	 */
    public int selectPdfL102yListTotCnt(InfcPkgPdfL102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfL102yDAO.selectPdfL102yListTotCnt_S", searchVO);
    }

}
