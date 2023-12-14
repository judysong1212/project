package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfF102ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfF102y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102y_2023_DAO.java
 * @Description : PdfF102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfF102y_2023_DAO")
public class InfcPkgPdfF102y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_F102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102y(InfcPkgPdfF102y_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfF102y_2023_DAO.insertPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102y(InfcPkgPdfF102y_2023_VO vo) throws Exception {
        update("infcPkgPdfF102y_2023_DAO.updatePdfF102y_S", vo);
    }
    
    public void updateYetaP820001ToPdfF102y(InfcPkgPdfF102y_2023_VO vo) throws Exception {
    	update("infcPkgPdfF102y_2023_DAO.updateYetaP820001ToPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102y(InfcPkgPdfF102y_2023_VO vo) throws Exception {
        delete("infcPkgPdfF102y_2023_DAO.deletePdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102yVO
	 * @return 조회?�� PDF_F102Y
	 * @exception Exception
	 */
    public InfcPkgPdfF102y_2023_VO selectPdfF102y(InfcPkgPdfF102y_2023_VO vo) throws Exception {
        return (InfcPkgPdfF102y_2023_VO) selectByPk("infcPkgPdfF102y_2023_DAO.selectPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102yList(InfcPkgPdfF102ySrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfF102y_2023_DAO.selectPdfF102yList_D", searchVO);
    }

    /**
	 * PDF_F102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y �? �??��
	 * @exception
	 */
    public int selectPdfF102yListTotCnt(InfcPkgPdfF102ySrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfF102y_2023_DAO.selectPdfF102yListTotCnt_S", searchVO);
    }

}
