package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC301ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC301yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC301yDAO.java
 * @Description : PdfC301y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC301yDAO")
public class InfcPkgPdfC301yDAO extends EgovAbstractDAO {

	/**
	 * PDF_C301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC301yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC301y(InfcPkgPdfC301yVO vo) throws Exception {
        return (String)insert("infcPkgPdfC301yDAO.insertPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC301y(InfcPkgPdfC301yVO vo) throws Exception {
        update("infcPkgPdfC301yDAO.updatePdfC301y_S", vo);
    }
    
    public void updateYetaP220001ToPdfC301y(InfcPkgPdfC301yVO vo) throws Exception {
    	update("infcPkgPdfC301yDAO.updateYetaP220001ToPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC301y(InfcPkgPdfC301yVO vo) throws Exception {
        delete("infcPkgPdfC301yDAO.deletePdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC301yVO
	 * @return 조회?�� PDF_C301Y
	 * @exception Exception
	 */
    public InfcPkgPdfC301yVO selectPdfC301y(InfcPkgPdfC301yVO vo) throws Exception {
        return (InfcPkgPdfC301yVO) selectByPk("infcPkgPdfC301yDAO.selectPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC301yList(InfcPkgPdfC301ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfC301yDAO.selectPdfC301yList_D", searchVO);
    }

    /**
	 * PDF_C301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y �? �??��
	 * @exception
	 */
    public int selectPdfC301yListTotCnt(InfcPkgPdfC301ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC301yDAO.selectPdfC301yListTotCnt_S", searchVO);
    }

}
