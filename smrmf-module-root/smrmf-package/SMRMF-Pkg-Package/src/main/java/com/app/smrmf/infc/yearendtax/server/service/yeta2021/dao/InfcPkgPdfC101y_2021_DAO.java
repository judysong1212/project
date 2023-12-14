package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC101y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC101y_2021_DAO.java
 * @Description : PdfC101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC101y_2021_DAO")
public class InfcPkgPdfC101y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC101y(InfcPkgPdfC101y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC101y_2021_DAO.insertPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC101y(InfcPkgPdfC101y_2021_VO vo) throws Exception {
        update("infcPkgPdfC101y_2021_DAO.updatePdfC101y_S", vo);
    }
    
    public void updateYetaP620001ToPdfC101y(InfcPkgPdfC101y_2021_VO vo) throws Exception {
    	update("infcPkgPdfC101y_2021_DAO.updateYetaP620001ToPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC101y(InfcPkgPdfC101y_2021_VO vo) throws Exception {
        delete("infcPkgPdfC101y_2021_DAO.deletePdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC101yVO
	 * @return 조회?�� PDF_C101Y
	 * @exception Exception
	 */
    public InfcPkgPdfC101y_2021_VO selectPdfC101y(InfcPkgPdfC101y_2021_VO vo) throws Exception {
        return (InfcPkgPdfC101y_2021_VO) selectByPk("infcPkgPdfC101y_2021_DAO.selectPdfC101y_S", vo);
    }

    /**
	 * PDF_C101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC101yList(InfcPkgPdfC101ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfC101y_2021_DAO.selectPdfC101yList_D", searchVO);
    }

    /**
	 * PDF_C101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101Y �? �??��
	 * @exception
	 */
    public int selectPdfC101yListTotCnt(InfcPkgPdfC101ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC101y_2021_DAO.selectPdfC101yListTotCnt_S", searchVO);
    }

}
