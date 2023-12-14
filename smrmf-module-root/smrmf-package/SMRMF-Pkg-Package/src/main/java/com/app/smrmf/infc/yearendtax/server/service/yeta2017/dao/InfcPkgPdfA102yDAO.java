package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102yDAO.java
 * @Description : PdfA102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfA102yDAO")
public class InfcPkgPdfA102yDAO extends EgovAbstractDAO {
 
	
	/**
	 * PDF_A102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102y(InfcPkgPdfA102yVO vo) throws Exception {
        return (String)insert("infcPkgPdfA102yDAO.insertPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102y(InfcPkgPdfA102yVO vo) throws Exception {
        update("infcPkgPdfA102yDAO.updatePdfA102y_S", vo);
    }
    
    public void updateYetaP220001ToPdfA102y(InfcPkgPdfA102yVO vo) throws Exception {
    	update("infcPkgPdfA102yDAO.updateYetaP220001ToPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102y(InfcPkgPdfA102yVO vo) throws Exception {
        delete("infcPkgPdfA102yDAO.deletePdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102yVO
	 * @return 조회?�� PDF_A102Y
	 * @exception Exception
	 */
    public InfcPkgPdfA102yVO selectPdfA102y(InfcPkgPdfA102yVO vo) throws Exception {
        return (InfcPkgPdfA102yVO) selectByPk("infcPkgPdfA102yDAO.selectPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102yList(InfcPkgPdfA102ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfA102yDAO.selectPdfA102yList_D", searchVO);
    }

    /**
	 * PDF_A102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y �? �??��
	 * @exception
	 */
    public int selectPdfA102yListTotCnt(InfcPkgPdfA102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfA102yDAO.selectPdfA102yListTotCnt_S", searchVO);
    }

}
