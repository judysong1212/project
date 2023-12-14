package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfA102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG207ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG207y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG207y_2023_DAO.java
 * @Description : PdfG207y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG207y_2023_DAO")
public class InfcPkgPdfG207y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G206Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG207yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG207y(InfcPkgPdfG207y_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG207y_2023_DAO.insertPdfG207y_S", vo);
    }

    /**
	 * PDF_G206Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG207yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG207y(InfcPkgPdfG207y_2023_VO vo) throws Exception {
        update("infcPkgPdfG207y_2023_DAO.updatePdfG207y_S", vo);
    }
    
    public void updateYetaP820001ToPdfG207y(InfcPkgPdfG207y_2023_VO vo) throws Exception {
    	update("infcPkgPdfG207y_2023_DAO.updateYetaP820001ToPdfG207y_S", vo);
    }

    /**
	 * PDF_G206Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG207yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG207y(InfcPkgPdfG207y_2023_VO vo) throws Exception {
        delete("infcPkgPdfG207y_2023_DAO.deletePdfG207y_S", vo);
    }

    /**
	 * PDF_G206Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG207yVO
	 * @return 조회?�� PDF_G206Y
	 * @exception Exception
	 */
    public InfcPkgPdfG207y_2023_VO selectPdfG207y(InfcPkgPdfG207y_2023_VO vo) throws Exception {
        return (InfcPkgPdfG207y_2023_VO) selectByPk("infcPkgPdfG207y_2023_DAO.selectPdfG207y_S", vo);
    }

    /**
	 * PDF_G206Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG207yList(InfcPkgPdfG207ySrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG207y_2023_DAO.selectPdfG207yList_D", searchVO);
    }

    /**
	 * PDF_G206Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206Y �? �??��
	 * @exception
	 */
    public int selectPdfG207yListTotCnt(InfcPkgPdfG207ySrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG207y_2023_DAO.selectPdfG207yListTotCnt_S", searchVO);
    }

}
