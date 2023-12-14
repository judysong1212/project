package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ203yDAO.java
 * @Description : PdfJ203y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ203yDAO")
public class InfcPkgPdfJ203yDAO extends EgovAbstractDAO {

 
	
	 public List<InfcPkgPdfJ203yVO> PdfYeta2200_F102Y_PDF_J203Y_Select(InfcPkgPdfJ203ySrhVO searchVO) throws Exception {
	        return list("infcPkgPdfJ203yDAO.PdfYeta2200_F102Y_PDF_J203Y_Select_D", searchVO);
	    }
	 
	
	/**
	 * PDF_J203Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ203yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ203y(InfcPkgPdfJ203yVO vo) throws Exception {
        return (String)insert("infcPkgPdfJ203yDAO.insertPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ203y(InfcPkgPdfJ203yVO vo) throws Exception {
        update("infcPkgPdfJ203yDAO.updatePdfJ203y_S", vo);
    }
    
    public void updateYetaP220001ToPdfJ203y(InfcPkgPdfJ203yVO vo) throws Exception {
    	update("infcPkgPdfJ203yDAO.updateYetaP220001ToPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ203y(InfcPkgPdfJ203yVO vo) throws Exception {
        delete("infcPkgPdfJ203yDAO.deletePdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ203yVO
	 * @return 조회?�� PDF_J203Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ203yVO selectPdfJ203y(InfcPkgPdfJ203yVO vo) throws Exception {
        return (InfcPkgPdfJ203yVO) selectByPk("infcPkgPdfJ203yDAO.selectPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ203yList(InfcPkgPdfJ203ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfJ203yDAO.selectPdfJ203yList_D", searchVO);
    }

    /**
	 * PDF_J203Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203Y �? �??��
	 * @exception
	 */
    public int selectPdfJ203yListTotCnt(InfcPkgPdfJ203ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ203yDAO.selectPdfJ203yListTotCnt_S", searchVO);
    }

}
