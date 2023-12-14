package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfN101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfN101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101yDAO.java
 * @Description : PdfN101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfN101yDAO")
public class InfcPkgPdfN101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_N101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101y(InfcPkgPdfN101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfN101yDAO.insertPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101y(InfcPkgPdfN101yVO vo) throws Exception {
        update("infcPkgPdfN101yDAO.updatePdfN101y_S", vo);
    }
    
    public void updateYetaP220001ToPdfN101y(InfcPkgPdfN101yVO vo) throws Exception {
    	update("infcPkgPdfN101yDAO.updateYetaP220001ToPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101y(InfcPkgPdfN101yVO vo) throws Exception {
        delete("infcPkgPdfN101yDAO.deletePdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101yVO
	 * @return 조회?�� PDF_N101Y
	 * @exception Exception
	 */
    public InfcPkgPdfN101yVO selectPdfN101y(InfcPkgPdfN101yVO vo) throws Exception {
        return (InfcPkgPdfN101yVO) selectByPk("infcPkgPdfN101yDAO.selectPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101yList(InfcPkgPdfN101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfN101yDAO.selectPdfN101yList_D", searchVO);
    }

    /**
	 * PDF_N101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y �? �??��
	 * @exception
	 */
    public int selectPdfN101yListTotCnt(InfcPkgPdfN101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfN101yDAO.selectPdfN101yListTotCnt_S", searchVO);
    }

}
