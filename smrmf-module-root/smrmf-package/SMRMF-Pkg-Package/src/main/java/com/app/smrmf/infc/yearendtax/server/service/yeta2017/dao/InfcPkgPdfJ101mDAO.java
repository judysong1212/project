package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101mDAO.java
 * @Description : PdfJ101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ101mDAO")
public class InfcPkgPdfJ101mDAO extends EgovAbstractDAO {

	/**
	 * PDF_J101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101m(InfcPkgPdfJ101mVO vo) throws Exception {
        return (String)insert("infcPkgPdfJ101mDAO.insertPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101m(InfcPkgPdfJ101mVO vo) throws Exception {
        update("infcPkgPdfJ101mDAO.updatePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101m(InfcPkgPdfJ101mVO vo) throws Exception {
        delete("infcPkgPdfJ101mDAO.deletePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101mVO
	 * @return 조회?�� PDF_J101M
	 * @exception Exception
	 */
    public InfcPkgPdfJ101mVO selectPdfJ101m(InfcPkgPdfJ101mVO vo) throws Exception {
        return (InfcPkgPdfJ101mVO) selectByPk("infcPkgPdfJ101mDAO.selectPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101mList(InfcPkgPdfJ101mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfJ101mDAO.selectPdfJ101mList_D", searchVO);
    }

    /**
	 * PDF_J101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M �? �??��
	 * @exception
	 */
    public int selectPdfJ101mListTotCnt(InfcPkgPdfJ101mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ101mDAO.selectPdfJ101mListTotCnt_S", searchVO);
    }

}
