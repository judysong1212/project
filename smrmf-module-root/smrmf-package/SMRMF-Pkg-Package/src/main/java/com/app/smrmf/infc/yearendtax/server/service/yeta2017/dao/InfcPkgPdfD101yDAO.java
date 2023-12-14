package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfD101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfD101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101yDAO.java
 * @Description : PdfD101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfD101yDAO")
public class InfcPkgPdfD101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_D101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101y(InfcPkgPdfD101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfD101yDAO.insertPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101y(InfcPkgPdfD101yVO vo) throws Exception {
        update("infcPkgPdfD101yDAO.updatePdfD101y_S", vo);
    }
    
    public void updateYetaP220001ToPdfD101y(InfcPkgPdfD101yVO vo) throws Exception {
    	update("infcPkgPdfD101yDAO.updateYetaP220001ToPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101y(InfcPkgPdfD101yVO vo) throws Exception {
        delete("infcPkgPdfD101yDAO.deletePdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101yVO
	 * @return 조회?�� PDF_D101Y
	 * @exception Exception
	 */
    public InfcPkgPdfD101yVO selectPdfD101y(InfcPkgPdfD101yVO vo) throws Exception {
        return (InfcPkgPdfD101yVO) selectByPk("infcPkgPdfD101yDAO.selectPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101yList(InfcPkgPdfD101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfD101yDAO.selectPdfD101yList_D", searchVO);
    }

    /**
	 * PDF_D101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y �? �??��
	 * @exception
	 */
    public int selectPdfD101yListTotCnt(InfcPkgPdfD101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfD101yDAO.selectPdfD101yListTotCnt_S", searchVO);
    }

}
