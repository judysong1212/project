package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfA102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC401ySrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC401y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC401y_2018_DAO.java
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

@Repository("InfcPkgPdfC401y_2018_DAO")
public class InfcPkgPdfC401y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C401Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC401yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC401y(InfcPkgPdfC401y_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC401y_2018_DAO.insertPdfC401y_S", vo);
    }

    /**
	 * PDF_C401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC401y(InfcPkgPdfC401y_2018_VO vo) throws Exception {
        update("infcPkgPdfC401y_2018_DAO.updatePdfC401y_S", vo);
    }

    public void updateYetaP320001ToPdfC401y(InfcPkgPdfC401y_2018_VO vo) throws Exception {
    	update("infcPkgPdfC401y_2018_DAO.updateYetaP320001ToPdfC401y_S", vo);
    }
    
    /**
	 * PDF_C401Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC401y(InfcPkgPdfC401y_2018_VO vo) throws Exception {
        delete("infcPkgPdfC401y_2018_DAO.deletePdfC401y_S", vo);
    }

    /**
	 * PDF_C401Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC401yVO
	 * @return 조회?�� PDF_C401Y
	 * @exception Exception
	 */
    public InfcPkgPdfC401y_2018_VO selectPdfC401y(InfcPkgPdfC401y_2018_VO vo) throws Exception {
        return (InfcPkgPdfC401y_2018_VO) selectByPk("infcPkgPdfC401y_2018_DAO.selectPdfC401y_S", vo);
    }

    /**
	 * PDF_C401Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC401yList(InfcPkgPdfC401ySrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfC401y_2018_DAO.selectPdfC401yList_D", searchVO);
    }

    /**
	 * PDF_C401Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401Y �? �??��
	 * @exception
	 */
    public int selectPdfC401yListTotCnt(InfcPkgPdfC401ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC401y_2018_DAO.selectPdfC401yListTotCnt_S", searchVO);
    }

}
