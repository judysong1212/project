package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfA102y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfJ401ySrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfJ401y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401y_2019_DAO.java
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

@Repository("InfcPkgPdfJ401y_2019_DAO")
public class InfcPkgPdfJ401y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J401Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401y(InfcPkgPdfJ401y_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ401y_2019_DAO.insertPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401y(InfcPkgPdfJ401y_2019_VO vo) throws Exception {
        update("infcPkgPdfJ401y_2019_DAO.updatePdfJ401y_S", vo);
    }
    
    public void updateYetaP420001ToPdfJ401y(InfcPkgPdfJ401y_2019_VO vo) throws Exception {
    	update("infcPkgPdfJ401y_2019_DAO.updateYetaP420001ToPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401y(InfcPkgPdfJ401y_2019_VO vo) throws Exception {
        delete("infcPkgPdfJ401y_2019_DAO.deletePdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401yVO
	 * @return 조회?�� PDF_J401Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ401y_2019_VO selectPdfJ401y(InfcPkgPdfJ401y_2019_VO vo) throws Exception {
        return (InfcPkgPdfJ401y_2019_VO) selectByPk("infcPkgPdfJ401y_2019_DAO.selectPdfJ401y_S", vo);
    }

    /**
	 * PDF_J401Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401yList(InfcPkgPdfJ401ySrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfJ401y_2019_DAO.selectPdfJ401yList_D", searchVO);
    }

    /**
	 * PDF_J401Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401Y �? �??��
	 * @exception
	 */
    public int selectPdfJ401yListTotCnt(InfcPkgPdfJ401ySrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ401y_2019_DAO.selectPdfJ401yListTotCnt_S", searchVO);
    }

}
