package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ201ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ201y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfQ201y_2021_DAO.java
 * @Description : PdfQ201y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfQ201y_2021_DAO")
public class InfcPkgPdfQ201y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_Q201y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfQ201yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfQ201y(InfcPkgPdfQ201y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfQ201y_2021_DAO.insertPdfQ201y_S", vo);
    }

    /**
	 * PDF_Q201y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ201yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfQ201y(InfcPkgPdfQ201y_2021_VO vo) throws Exception {
        update("infcPkgPdfQ201y_2021_DAO.updatePdfQ201y_S", vo);
    }
    
    public void updateYetaP620001ToPdfQ201y(InfcPkgPdfQ201y_2021_VO vo) throws Exception {
    	update("infcPkgPdfQ201y_2021_DAO.updateYetaP620001ToPdfQ201y_S", vo);
    }

    /**
	 * PDF_Q201y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ201yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfQ201y(InfcPkgPdfQ201y_2021_VO vo) throws Exception {
        delete("infcPkgPdfQ201y_2021_DAO.deletePdfQ201y_S", vo);
    }

    /**
	 * PDF_Q201y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfQ201yVO
	 * @return 조회?�� PDF_Q201y
	 * @exception Exception
	 */
    public InfcPkgPdfQ201y_2021_VO selectPdfQ201y(InfcPkgPdfQ201y_2021_VO vo) throws Exception {
        return (InfcPkgPdfQ201y_2021_VO) selectByPk("infcPkgPdfQ201y_2021_DAO.selectPdfQ201y_S", vo);
    }

    /**
	 * PDF_Q201y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q201y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfQ201yList(InfcPkgPdfQ201ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfQ201y_2021_DAO.selectPdfQ201yList_D", searchVO);
    }

    /**
	 * PDF_Q201y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q201y �? �??��
	 * @exception
	 */
    public int selectPdfQ201yListTotCnt(InfcPkgPdfQ201ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfQ201y_2021_DAO.selectPdfQ201yListTotCnt_S", searchVO);
    }

}
