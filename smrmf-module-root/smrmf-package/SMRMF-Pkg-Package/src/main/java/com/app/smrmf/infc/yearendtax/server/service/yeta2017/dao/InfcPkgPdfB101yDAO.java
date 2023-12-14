package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101yDAO.java
 * @Description : PdfB101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfB101yDAO")
public class InfcPkgPdfB101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_B101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101y(InfcPkgPdfB101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfB101yDAO.insertPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101y(InfcPkgPdfB101yVO vo) throws Exception {
        update("infcPkgPdfB101yDAO.updatePdfB101y_S", vo);
    }
    
    public void updateYetaP220001ToPdfB101y(InfcPkgPdfB101yVO vo) throws Exception {
    	update("infcPkgPdfB101yDAO.updateYetaP220001ToPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101y(InfcPkgPdfB101yVO vo) throws Exception {
        delete("infcPkgPdfB101yDAO.deletePdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101yVO
	 * @return 조회?�� PDF_B101Y
	 * @exception Exception
	 */
    public InfcPkgPdfB101yVO selectPdfB101y(InfcPkgPdfB101yVO vo) throws Exception {
        return (InfcPkgPdfB101yVO) selectByPk("infcPkgPdfB101yDAO.selectPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101yList(InfcPkgPdfB101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfB101yDAO.selectPdfB101yList_D", searchVO);
    }

    /**
	 * PDF_B101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y �? �??��
	 * @exception
	 */
    public int selectPdfB101yListTotCnt(InfcPkgPdfB101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfB101yDAO.selectPdfB101yListTotCnt_S", searchVO);
    }

}
