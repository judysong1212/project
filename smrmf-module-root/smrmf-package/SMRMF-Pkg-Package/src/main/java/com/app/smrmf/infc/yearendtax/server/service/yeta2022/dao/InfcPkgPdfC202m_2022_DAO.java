package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfC202mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfC202m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC202m_2022_DAO.java
 * @Description : PdfC202m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC202m_2022_DAO")
public class InfcPkgPdfC202m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C202M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC202mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC202m(InfcPkgPdfC202m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC202m_2022_DAO.insertPdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC202m(InfcPkgPdfC202m_2022_VO vo) throws Exception {
        update("infcPkgPdfC202m_2022_DAO.updatePdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC202mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC202m(InfcPkgPdfC202m_2022_VO vo) throws Exception {
        delete("infcPkgPdfC202m_2022_DAO.deletePdfC202m_S", vo);
    }

    /**
	 * PDF_C202M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC202mVO
	 * @return 조회?�� PDF_C202M
	 * @exception Exception
	 */
    public InfcPkgPdfC202m_2022_VO selectPdfC202m(InfcPkgPdfC202m_2022_VO vo) throws Exception {
        return (InfcPkgPdfC202m_2022_VO) selectByPk("infcPkgPdfC202m_2022_DAO.selectPdfC202m_S", vo);
    }

    /**
	 * PDF_C202M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC202mList(InfcPkgPdfC202mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfC202m_2022_DAO.selectPdfC202mList_D", searchVO);
    }

    /**
	 * PDF_C202M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C202M �? �??��
	 * @exception
	 */
    public int selectPdfC202mListTotCnt(InfcPkgPdfC202mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC202m_2022_DAO.selectPdfC202mListTotCnt_S", searchVO);
    }

}
