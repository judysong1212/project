package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfD101mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfD101m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101m_2022_DAO.java
 * @Description : PdfD101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfD101m_2022_DAO")
public class InfcPkgPdfD101m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_D101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101m(InfcPkgPdfD101m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfD101m_2022_DAO.insertPdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101m(InfcPkgPdfD101m_2022_VO vo) throws Exception {
        update("infcPkgPdfD101m_2022_DAO.updatePdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101m(InfcPkgPdfD101m_2022_VO vo) throws Exception {
        delete("infcPkgPdfD101m_2022_DAO.deletePdfD101m_S", vo);
    }

    /**
	 * PDF_D101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101mVO
	 * @return 조회?�� PDF_D101M
	 * @exception Exception
	 */
    public InfcPkgPdfD101m_2022_VO selectPdfD101m(InfcPkgPdfD101m_2022_VO vo) throws Exception {
        return (InfcPkgPdfD101m_2022_VO) selectByPk("infcPkgPdfD101m_2022_DAO.selectPdfD101m_S", vo);
    }

    /**
	 * PDF_D101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101mList(InfcPkgPdfD101mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfD101m_2022_DAO.selectPdfD101mList_D", searchVO);
    }

    /**
	 * PDF_D101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101M �? �??��
	 * @exception
	 */
    public int selectPdfD101mListTotCnt(InfcPkgPdfD101mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfD101m_2022_DAO.selectPdfD101mListTotCnt_S", searchVO);
    }

}
