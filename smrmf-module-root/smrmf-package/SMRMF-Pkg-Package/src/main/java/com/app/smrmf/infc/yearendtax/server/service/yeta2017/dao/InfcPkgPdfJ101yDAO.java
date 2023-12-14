package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101yDAO.java
 * @Description : PdfJ101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ101yDAO")
public class InfcPkgPdfJ101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_J101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101y(InfcPkgPdfJ101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfJ101yDAO.insertPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101y(InfcPkgPdfJ101yVO vo) throws Exception {
        update("infcPkgPdfJ101yDAO.updatePdfJ101y_S", vo);
    }
    
    public void updateYetaP220001ToPdfJ101y(InfcPkgPdfJ101yVO vo) throws Exception {
    	update("infcPkgPdfJ101yDAO.updateYetaP220001ToPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101y(InfcPkgPdfJ101yVO vo) throws Exception {
        delete("infcPkgPdfJ101yDAO.deletePdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101yVO
	 * @return 조회?�� PDF_J101Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ101yVO selectPdfJ101y(InfcPkgPdfJ101yVO vo) throws Exception {
        return (InfcPkgPdfJ101yVO) selectByPk("infcPkgPdfJ101yDAO.selectPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101yList(InfcPkgPdfJ101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfJ101yDAO.selectPdfJ101yList_D", searchVO);
    }

    /**
	 * PDF_J101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y �? �??��
	 * @exception
	 */
    public int selectPdfJ101yListTotCnt(InfcPkgPdfJ101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ101yDAO.selectPdfJ101yListTotCnt_S", searchVO);
    }

}
