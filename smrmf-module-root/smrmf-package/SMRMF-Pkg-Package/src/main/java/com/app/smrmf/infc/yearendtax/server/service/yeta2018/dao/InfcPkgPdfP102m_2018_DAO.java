package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP102mSrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP102m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP102m_2018_DAO.java
 * @Description : PdfP102m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfP102m_2018_DAO")
public class InfcPkgPdfP102m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_P102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP102m(InfcPkgPdfP102m_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfP102m_2018_DAO.insertPdfP102m_S", vo);
    }

    /**
	 * PDF_P102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP102m(InfcPkgPdfP102m_2018_VO vo) throws Exception {
        update("infcPkgPdfP102m_2018_DAO.updatePdfP102m_S", vo);
    }

    /**
	 * PDF_P102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP102m(InfcPkgPdfP102m_2018_VO vo) throws Exception {
        delete("infcPkgPdfP102m_2018_DAO.deletePdfP102m_S", vo);
    }

    /**
	 * PDF_P102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP102mVO
	 * @return 조회?�� PDF_P102M
	 * @exception Exception
	 */
    public InfcPkgPdfP102m_2018_VO selectPdfP102m(InfcPkgPdfP102m_2018_VO vo) throws Exception {
        return (InfcPkgPdfP102m_2018_VO) selectByPk("infcPkgPdfP102m_2018_DAO.selectPdfP102m_S", vo);
    }

    /**
	 * PDF_P102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP102mList(InfcPkgPdfP102mSrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfP102m_2018_DAO.selectPdfP102mList_D", searchVO);
    }

    /**
	 * PDF_P102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P102M �? �??��
	 * @exception
	 */
    public int selectPdfP102mListTotCnt(InfcPkgPdfP102mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP102m_2018_DAO.selectPdfP102mListTotCnt_S", searchVO);
    }

}
