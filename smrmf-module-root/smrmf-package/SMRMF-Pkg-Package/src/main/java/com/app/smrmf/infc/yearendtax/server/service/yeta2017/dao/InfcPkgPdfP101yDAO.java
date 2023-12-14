package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101yDAO.java
 * @Description : PdfP101y DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfP101yDAO")
public class InfcPkgPdfP101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_P101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101y(InfcPkgPdfP101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfP101yDAO.insertPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101y(InfcPkgPdfP101yVO vo) throws Exception {
        update("infcPkgPdfP101yDAO.updatePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101y(InfcPkgPdfP101yVO vo) throws Exception {
        delete("infcPkgPdfP101yDAO.deletePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101yVO
	 * @return 조회?�� PDF_P101Y
	 * @exception Exception
	 */
    public InfcPkgPdfP101yVO selectPdfP101y(InfcPkgPdfP101yVO vo) throws Exception {
        return (InfcPkgPdfP101yVO) selectByPk("infcPkgPdfP101yDAO.selectPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101yList(InfcPkgPdfP101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfP101yDAO.selectPdfP101yList_D", searchVO);
    }

    /**
	 * PDF_P101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y �? �??��
	 * @exception
	 */
    public int selectPdfP101yListTotCnt(InfcPkgPdfP101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP101yDAO.selectPdfP101yListTotCnt_S", searchVO);
    }

}
