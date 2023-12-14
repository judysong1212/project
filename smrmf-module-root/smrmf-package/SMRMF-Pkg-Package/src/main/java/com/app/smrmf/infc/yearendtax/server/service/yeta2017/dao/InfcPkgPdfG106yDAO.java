package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG106ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG106yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG106yDAO.java
 * @Description : PdfG106y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG106yDAO")
public class InfcPkgPdfG106yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G106Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG106yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG106y(InfcPkgPdfG106yVO vo) throws Exception {
        return (String)insert("infcPkgPdfG106yDAO.insertPdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG106yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG106y(InfcPkgPdfG106yVO vo) throws Exception {
        update("infcPkgPdfG106yDAO.updatePdfG106y_S", vo);
    }
    
    public void updateYetaP220001ToPdfG106y(InfcPkgPdfG106yVO vo) throws Exception {
    	update("infcPkgPdfG106yDAO.updateYetaP220001ToPdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG106yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG106y(InfcPkgPdfG106yVO vo) throws Exception {
        delete("infcPkgPdfG106yDAO.deletePdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG106yVO
	 * @return 조회?�� PDF_G106Y
	 * @exception Exception
	 */
    public InfcPkgPdfG106yVO selectPdfG106y(InfcPkgPdfG106yVO vo) throws Exception {
        return (InfcPkgPdfG106yVO) selectByPk("infcPkgPdfG106yDAO.selectPdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG106yList(InfcPkgPdfG106ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfG106yDAO.selectPdfG106yList_D", searchVO);
    }

    /**
	 * PDF_G106Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106Y �? �??��
	 * @exception
	 */
    public int selectPdfG106yListTotCnt(InfcPkgPdfG106ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG106yDAO.selectPdfG106yListTotCnt_S", searchVO);
    }

}
