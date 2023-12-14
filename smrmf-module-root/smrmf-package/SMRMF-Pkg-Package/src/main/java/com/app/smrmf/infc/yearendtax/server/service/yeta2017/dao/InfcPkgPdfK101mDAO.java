package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101mDAO.java
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

@Repository("InfcPkgPdfK101mDAO")
public class InfcPkgPdfK101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_K101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101m(InfcPkgPdfK101mVO vo) throws Exception {
        return (String)insert("infcPkgPdfK101mDAO.insertPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101m(InfcPkgPdfK101mVO vo) throws Exception {
        update("infcPkgPdfK101mDAO.updatePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101m(InfcPkgPdfK101mVO vo) throws Exception {
        delete("infcPkgPdfK101mDAO.deletePdfK101m_S", vo);
    }

    /**
	 * PDF_K101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101mVO
	 * @return 조회?�� PDF_K101M
	 * @exception Exception
	 */
    public InfcPkgPdfK101mVO selectPdfK101m(InfcPkgPdfK101mVO vo) throws Exception {
        return (InfcPkgPdfK101mVO) selectByPk("infcPkgPdfK101mDAO.selectPdfK101m_S", vo);
    }

    /**
	 * PDF_K101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101mList(InfcPkgPdfK101mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfK101mDAO.selectPdfK101mList_D", searchVO);
    }

    /**
	 * PDF_K101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101M �? �??��
	 * @exception
	 */
    public int selectPdfK101mListTotCnt(InfcPkgPdfK101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfK101mDAO.selectPdfK101mListTotCnt_S", searchVO);
    }

}
