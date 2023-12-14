package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101yDAO.java
 * @Description : PdfK101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfK101yDAO")
public class InfcPkgPdfK101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_K101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101y(InfcPkgPdfK101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfK101yDAO.insertPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101y(InfcPkgPdfK101yVO vo) throws Exception {
        update("infcPkgPdfK101yDAO.updatePdfK101y_S", vo);
    }
    
    public void updateYetaP220001ToPdfK101y(InfcPkgPdfK101yVO vo) throws Exception {
    	update("infcPkgPdfK101yDAO.updateYetaP220001ToPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101y(InfcPkgPdfK101yVO vo) throws Exception {
        delete("infcPkgPdfK101yDAO.deletePdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101yVO
	 * @return 조회?�� PDF_K101Y
	 * @exception Exception
	 */
    public InfcPkgPdfK101yVO selectPdfK101y(InfcPkgPdfK101yVO vo) throws Exception {
        return (InfcPkgPdfK101yVO) selectByPk("infcPkgPdfK101yDAO.selectPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101yList(InfcPkgPdfK101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfK101yDAO.selectPdfK101yList_D", searchVO);
    }

    /**
	 * PDF_K101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101Y �? �??��
	 * @exception
	 */
    public int selectPdfK101yListTotCnt(InfcPkgPdfK101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfK101yDAO.selectPdfK101yListTotCnt_S", searchVO);
    }

}
