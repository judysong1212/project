package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG206yDAO.java
 * @Description : PdfG206y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG206yDAO")
public class InfcPkgPdfG206yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G206Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG206yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG206y(InfcPkgPdfG206yVO vo) throws Exception {
        return (String)insert("infcPkgPdfG206yDAO.insertPdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG206y(InfcPkgPdfG206yVO vo) throws Exception {
        update("infcPkgPdfG206yDAO.updatePdfG206y_S", vo);
    }
    
    public void updateYetaP220001ToPdfG206y(InfcPkgPdfG206yVO vo) throws Exception {
    	update("infcPkgPdfG206yDAO.updateYetaP220001ToPdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG206y(InfcPkgPdfG206yVO vo) throws Exception {
        delete("infcPkgPdfG206yDAO.deletePdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG206yVO
	 * @return 조회?�� PDF_G206Y
	 * @exception Exception
	 */
    public InfcPkgPdfG206yVO selectPdfG206y(InfcPkgPdfG206yVO vo) throws Exception {
        return (InfcPkgPdfG206yVO) selectByPk("infcPkgPdfG206yDAO.selectPdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG206yList(InfcPkgPdfG206ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfG206yDAO.selectPdfG206yList_D", searchVO);
    }

    /**
	 * PDF_G206Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206Y �? �??��
	 * @exception
	 */
    public int selectPdfG206yListTotCnt(InfcPkgPdfG206ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG206yDAO.selectPdfG206yListTotCnt_S", searchVO);
    }

}
