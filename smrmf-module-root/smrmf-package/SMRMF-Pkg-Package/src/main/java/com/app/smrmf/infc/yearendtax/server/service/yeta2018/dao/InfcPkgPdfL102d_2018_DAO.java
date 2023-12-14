package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfL102dSrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfL102d_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102d_2018_DAO.java
 * @Description : PdfL102d DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfL102d_2018_DAO")
public class InfcPkgPdfL102d_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_L102D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102dVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102d(InfcPkgPdfL102d_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfL102d_2018_DAO.insertPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102dVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102d(InfcPkgPdfL102d_2018_VO vo) throws Exception {
        update("infcPkgPdfL102d_2018_DAO.updatePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102dVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102d(InfcPkgPdfL102d_2018_VO vo) throws Exception {
        delete("infcPkgPdfL102d_2018_DAO.deletePdfL102d_S", vo);
    }

    /**
	 * PDF_L102D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102dVO
	 * @return 조회?�� PDF_L102D
	 * @exception Exception
	 */
    public InfcPkgPdfL102d_2018_VO selectPdfL102d(InfcPkgPdfL102d_2018_VO vo) throws Exception {
        return (InfcPkgPdfL102d_2018_VO) selectByPk("infcPkgPdfL102d_2018_DAO.selectPdfL102d_S", vo);
    }

    /**
	 * PDF_L102D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102dList(InfcPkgPdfL102dSrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfL102d_2018_DAO.selectPdfL102dList_D", searchVO);
    }

    /**
	 * PDF_L102D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102D �? �??��
	 * @exception
	 */
    public int selectPdfL102dListTotCnt(InfcPkgPdfL102dSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfL102d_2018_DAO.selectPdfL102dListTotCnt_S", searchVO);
    }

}
