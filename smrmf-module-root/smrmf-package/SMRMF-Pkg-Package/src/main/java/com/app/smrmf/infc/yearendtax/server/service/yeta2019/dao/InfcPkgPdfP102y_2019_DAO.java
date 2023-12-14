package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfA102y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfP102ySrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfP102y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP102y_2019_DAO.java
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

@Repository("InfcPkgPdfP102y_2019_DAO")
public class InfcPkgPdfP102y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_P102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP102y(InfcPkgPdfP102y_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfP102y_2019_DAO.insertPdfP102y_S", vo);
    }

    /**
	 * PDF_P102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP102y(InfcPkgPdfP102y_2019_VO vo) throws Exception {
        update("infcPkgPdfP102y_2019_DAO.updatePdfP102y_S", vo);
    }

    public void updateYetaP420001ToPdfP102y(InfcPkgPdfP102y_2019_VO vo) throws Exception {
    	update("infcPkgPdfP102y_2019_DAO.updateYetaP420001ToPdfP102y_S", vo);
    }
    
    /**
	 * PDF_P102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP102y(InfcPkgPdfP102y_2019_VO vo) throws Exception {
        delete("infcPkgPdfP102y_2019_DAO.deletePdfP102y_S", vo);
    }

    /**
	 * PDF_P102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP102yVO
	 * @return 조회?�� PDF_P102Y
	 * @exception Exception
	 */
    public InfcPkgPdfP102y_2019_VO selectPdfP102y(InfcPkgPdfP102y_2019_VO vo) throws Exception {
        return (InfcPkgPdfP102y_2019_VO) selectByPk("infcPkgPdfP102y_2019_DAO.selectPdfP102y_S", vo);
    }

    /**
	 * PDF_P102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP102yList(InfcPkgPdfP102ySrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfP102y_2019_DAO.selectPdfP102yList_D", searchVO);
    }

    /**
	 * PDF_P102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102Y �? �??��
	 * @exception
	 */
    public int selectPdfP102yListTotCnt(InfcPkgPdfP102ySrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP102y_2019_DAO.selectPdfP102yListTotCnt_S", searchVO);
    }

}
