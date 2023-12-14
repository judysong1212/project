package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102yDAO.java
 * @Description : PdfE102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfE102yDAO")
public class InfcPkgPdfE102yDAO extends EgovAbstractDAO {

	/**
	 * PDF_E102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102y(InfcPkgPdfE102yVO vo) throws Exception {
        return (String)insert("infcPkgPdfE102yDAO.insertPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102y(InfcPkgPdfE102yVO vo) throws Exception {
        update("infcPkgPdfE102yDAO.updatePdfE102y_S", vo);
    }
    
    public void updateYetaP220001ToPdfE102y(InfcPkgPdfE102yVO vo) throws Exception {
    	update("infcPkgPdfE102yDAO.updateYetaP220001ToPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102y(InfcPkgPdfE102yVO vo) throws Exception {
        delete("infcPkgPdfE102yDAO.deletePdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102yVO
	 * @return 조회?�� PDF_E102Y
	 * @exception Exception
	 */
    public InfcPkgPdfE102yVO selectPdfE102y(InfcPkgPdfE102yVO vo) throws Exception {
        return (InfcPkgPdfE102yVO) selectByPk("infcPkgPdfE102yDAO.selectPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102yList(InfcPkgPdfE102ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfE102yDAO.selectPdfE102yList_D", searchVO);
    }

    /**
	 * PDF_E102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y �? �??��
	 * @exception
	 */
    public int selectPdfE102yListTotCnt(InfcPkgPdfE102ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfE102yDAO.selectPdfE102yListTotCnt_S", searchVO);
    }

}
