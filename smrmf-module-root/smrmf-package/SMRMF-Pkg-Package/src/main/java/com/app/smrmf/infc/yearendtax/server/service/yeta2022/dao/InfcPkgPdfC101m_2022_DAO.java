package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfC101mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfC101m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC101m_2022_DAO.java
 * @Description : PdfC101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC101m_2022_DAO")
public class InfcPkgPdfC101m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC101m(InfcPkgPdfC101m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC101m_2022_DAO.insertPdfC101m_S", vo);
    }

    /**
	 * PDF_C101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC101m(InfcPkgPdfC101m_2022_VO vo) throws Exception {
        update("infcPkgPdfC101m_2022_DAO.updatePdfC101m_S", vo);
    }

    /**
	 * PDF_C101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC101m(InfcPkgPdfC101m_2022_VO vo) throws Exception {
        delete("infcPkgPdfC101m_2022_DAO.deletePdfC101m_S", vo);
    }

    /**
	 * PDF_C101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC101mVO
	 * @return 조회?�� PDF_C101M
	 * @exception Exception
	 */
    public InfcPkgPdfC101m_2022_VO selectPdfC101m(InfcPkgPdfC101m_2022_VO vo) throws Exception {
        return (InfcPkgPdfC101m_2022_VO) selectByPk("infcPkgPdfC101m_2022_DAO.selectPdfC101m_S", vo);
    }

    /**
	 * PDF_C101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC101mList(InfcPkgPdfC101mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfC101m_2022_DAO.selectPdfC101mList_D", searchVO);
    }

    /**
	 * PDF_C101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C101M �? �??��
	 * @exception
	 */
    public int selectPdfC101mListTotCnt(InfcPkgPdfC101mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC101m_2022_DAO.selectPdfC101mListTotCnt_S", searchVO);
    }

}
