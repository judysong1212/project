package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfK101mSrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfK101m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101m_2020_DAO.java
 * @Description : PdfK101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfK101m_2020_DAO")
public class InfcPkgPdfK101m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_K101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101m(InfcPkgPdfK101m_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfK101m_2020_DAO.insertPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101m(InfcPkgPdfK101m_2020_VO vo) throws Exception {
        update("infcPkgPdfK101m_2020_DAO.updatePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101m(InfcPkgPdfK101m_2020_VO vo) throws Exception {
        delete("infcPkgPdfK101m_2020_DAO.deletePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101mVO
	 * @return 조회?�� PDF_K101M
	 * @exception Exception
	 */
    public InfcPkgPdfK101m_2020_VO selectPdfK101m(InfcPkgPdfK101m_2020_VO vo) throws Exception {
        return (InfcPkgPdfK101m_2020_VO) selectByPk("infcPkgPdfK101m_2020_DAO.selectPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101mList(InfcPkgPdfK101mSrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfK101m_2020_DAO.selectPdfK101mList_D", searchVO);
    }

    /**
	 * PDF_K101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M �? �??��
	 * @exception
	 */
    public int selectPdfK101mListTotCnt(InfcPkgPdfK101mSrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfK101m_2020_DAO.selectPdfK101mListTotCnt_S", searchVO);
    }

}
