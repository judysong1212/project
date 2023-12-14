package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ101mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfJ101m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101m_2023_DAO.java
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

@Repository("InfcPkgPdfJ101m_2023_DAO")
public class InfcPkgPdfJ101m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101m(InfcPkgPdfJ101m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ101m_2023_DAO.insertPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101m(InfcPkgPdfJ101m_2023_VO vo) throws Exception {
        update("infcPkgPdfJ101m_2023_DAO.updatePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101m(InfcPkgPdfJ101m_2023_VO vo) throws Exception {
        delete("infcPkgPdfJ101m_2023_DAO.deletePdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101mVO
	 * @return 조회?�� PDF_J101M
	 * @exception Exception
	 */
    public InfcPkgPdfJ101m_2023_VO selectPdfJ101m(InfcPkgPdfJ101m_2023_VO vo) throws Exception {
        return (InfcPkgPdfJ101m_2023_VO) selectByPk("infcPkgPdfJ101m_2023_DAO.selectPdfJ101m_S", vo);
    }

    /**
	 * PDF_J101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101mList(InfcPkgPdfJ101mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfJ101m_2023_DAO.selectPdfJ101mList_D", searchVO);
    }

    /**
	 * PDF_J101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101M �? �??��
	 * @exception
	 */
    public int selectPdfJ101mListTotCnt(InfcPkgPdfJ101mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ101m_2023_DAO.selectPdfJ101mListTotCnt_S", searchVO);
    }

}
