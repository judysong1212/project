package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfP101mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfP101m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101m_2022_DAO.java
 * @Description : PdfP101m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfP101m_2022_DAO")
public class InfcPkgPdfP101m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_P101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101m(InfcPkgPdfP101m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfP101m_2022_DAO.insertPdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101m(InfcPkgPdfP101m_2022_VO vo) throws Exception {
        update("infcPkgPdfP101m_2022_DAO.updatePdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101m(InfcPkgPdfP101m_2022_VO vo) throws Exception {
        delete("infcPkgPdfP101m_2022_DAO.deletePdfP101m_S", vo);
    }

    /**
	 * PDF_P101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101mVO
	 * @return 조회?�� PDF_P101M
	 * @exception Exception
	 */
    public InfcPkgPdfP101m_2022_VO selectPdfP101m(InfcPkgPdfP101m_2022_VO vo) throws Exception {
        return (InfcPkgPdfP101m_2022_VO) selectByPk("infcPkgPdfP101m_2022_DAO.selectPdfP101m_S", vo);
    }

    /**
	 * PDF_P101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101mList(InfcPkgPdfP101mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfP101m_2022_DAO.selectPdfP101mList_D", searchVO);
    }

    /**
	 * PDF_P101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101M �? �??��
	 * @exception
	 */
    public int selectPdfP101mListTotCnt(InfcPkgPdfP101mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP101m_2022_DAO.selectPdfP101mListTotCnt_S", searchVO);
    }

}
