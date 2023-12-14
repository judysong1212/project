package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102yDAO.java
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

@Repository("InfcPkgPdfF102yDAO")
public class InfcPkgPdfF102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_F102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102y(InfcPkgPdfF102yVO vo) throws Exception {
        return (String)insert("infcPkgPdfF102yDAO.insertPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102y(InfcPkgPdfF102yVO vo) throws Exception {
        update("infcPkgPdfF102yDAO.updatePdfF102y_S", vo);
    }
    
    public void updateYetaP220001ToPdfF102y(InfcPkgPdfF102yVO vo) throws Exception {
    	update("infcPkgPdfF102yDAO.updateYetaP220001ToPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102y(InfcPkgPdfF102yVO vo) throws Exception {
        delete("infcPkgPdfF102yDAO.deletePdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102yVO
	 * @return 조회?�� PDF_F102Y
	 * @exception Exception
	 */
    public InfcPkgPdfF102yVO selectPdfF102y(InfcPkgPdfF102yVO vo) throws Exception {
        return (InfcPkgPdfF102yVO) selectByPk("infcPkgPdfF102yDAO.selectPdfF102y_S", vo);
    }

    /**
	 * PDF_F102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102yList(InfcPkgPdfF102ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfF102yDAO.selectPdfF102yList_D", searchVO);
    }

    /**
	 * PDF_F102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102Y �? �??��
	 * @exception
	 */
    public int selectPdfF102yListTotCnt(InfcPkgPdfF102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfF102yDAO.selectPdfF102yListTotCnt_S", searchVO);
    }

}
