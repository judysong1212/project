package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfL102ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfL102y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfL102y_2020_DAO.java
 * @Description : PdfL102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfL102y_2020_DAO")
public class InfcPkgPdfL102y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_L102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfL102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfL102y(InfcPkgPdfL102y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfL102y_2020_DAO.insertPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfL102y(InfcPkgPdfL102y_2020_VO vo) throws Exception {
        update("infcPkgPdfL102y_2020_DAO.updatePdfL102y_S", vo);
    }
    
    public void updateYetaP520001ToPdfL102y(InfcPkgPdfL102y_2020_VO vo) throws Exception {
    	update("infcPkgPdfL102y_2020_DAO.updateYetaP520001ToPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfL102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfL102y(InfcPkgPdfL102y_2020_VO vo) throws Exception {
        delete("infcPkgPdfL102y_2020_DAO.deletePdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfL102yVO
	 * @return 조회?�� PDF_L102Y
	 * @exception Exception
	 */
    public InfcPkgPdfL102y_2020_VO selectPdfL102y(InfcPkgPdfL102y_2020_VO vo) throws Exception {
        return (InfcPkgPdfL102y_2020_VO) selectByPk("infcPkgPdfL102y_2020_DAO.selectPdfL102y_S", vo);
    }

    /**
	 * PDF_L102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfL102yList(InfcPkgPdfL102ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfL102y_2020_DAO.selectPdfL102yList_D", searchVO);
    }

    /**
	 * PDF_L102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_L102Y �? �??��
	 * @exception
	 */
    public int selectPdfL102yListTotCnt(InfcPkgPdfL102ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfL102y_2020_DAO.selectPdfL102yListTotCnt_S", searchVO);
    }

}
