package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfJ203ySrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfJ203y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ203y_2019_DAO.java
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

@Repository("InfcPkgPdfJ203y_2019_DAO")
public class InfcPkgPdfJ203y_2019_DAO extends EgovAbstractDAO {

 
	
	 public List<InfcPkgPdfJ203y_2019_VO> PdfYeta4200_F102Y_PDF_J203Y_Select(InfcPkgPdfJ203ySrh_2019_VO searchVO) throws Exception {
	        return list("infcPkgPdfJ203y_2019_DAO.PdfYeta4200_F102Y_PDF_J203Y_Select_D", searchVO);
	    }
	 
	
	/**
	 * PDF_J203Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ203yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ203y(InfcPkgPdfJ203y_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ203y_2019_DAO.insertPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ203y(InfcPkgPdfJ203y_2019_VO vo) throws Exception {
        update("infcPkgPdfJ203y_2019_DAO.updatePdfJ203y_S", vo);
    }
    
    public void updateYetaP420001ToPdfJ203y(InfcPkgPdfJ203y_2019_VO vo) throws Exception {
    	update("infcPkgPdfJ203y_2019_DAO.updateYetaP420001ToPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ203y(InfcPkgPdfJ203y_2019_VO vo) throws Exception {
        delete("infcPkgPdfJ203y_2019_DAO.deletePdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ203yVO
	 * @return 조회?�� PDF_J203Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ203y_2019_VO selectPdfJ203y(InfcPkgPdfJ203y_2019_VO vo) throws Exception {
        return (InfcPkgPdfJ203y_2019_VO) selectByPk("infcPkgPdfJ203y_2019_DAO.selectPdfJ203y_S", vo);
    }

    /**
	 * PDF_J203Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ203yList(InfcPkgPdfJ203ySrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfJ203y_2019_DAO.selectPdfJ203yList_D", searchVO);
    }

    /**
	 * PDF_J203Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203Y �? �??��
	 * @exception
	 */
    public int selectPdfJ203yListTotCnt(InfcPkgPdfJ203ySrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ203y_2019_DAO.selectPdfJ203yListTotCnt_S", searchVO);
    }

}
