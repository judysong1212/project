package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC202ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC202y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202y_2023_DAO.java
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

@Repository("InfcPkgPdfC202y_2023_DAO")
public class InfcPkgPdfC202y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C202Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202y(InfcPkgPdfC202y_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC202y_2023_DAO.insertPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202y(InfcPkgPdfC202y_2023_VO vo) throws Exception {
        update("infcPkgPdfC202y_2023_DAO.updatePdfC202y_S", vo);
    }
    
    public void updateYetaP820001ToPdfC202y(InfcPkgPdfC202y_2023_VO vo) throws Exception {
    	update("infcPkgPdfC202y_2023_DAO.updateYetaP820001ToPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202y(InfcPkgPdfC202y_2023_VO vo) throws Exception {
        delete("infcPkgPdfC202y_2023_DAO.deletePdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202yVO
	 * @return 조회?�� PDF_C202Y
	 * @exception Exception
	 */
    public InfcPkgPdfC202y_2023_VO selectPdfC202y(InfcPkgPdfC202y_2023_VO vo) throws Exception {
        return (InfcPkgPdfC202y_2023_VO) selectByPk("infcPkgPdfC202y_2023_DAO.selectPdfC202y_S", vo);
    }

    /**
	 * PDF_C202Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202yList(InfcPkgPdfC202ySrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfC202y_2023_DAO.selectPdfC202yList_D", searchVO);
    }

    /**
	 * PDF_C202Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202Y �? �??��
	 * @exception
	 */
    public int selectPdfC202yListTotCnt(InfcPkgPdfC202ySrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC202y_2023_DAO.selectPdfC202yListTotCnt_S", searchVO);
    }

}
