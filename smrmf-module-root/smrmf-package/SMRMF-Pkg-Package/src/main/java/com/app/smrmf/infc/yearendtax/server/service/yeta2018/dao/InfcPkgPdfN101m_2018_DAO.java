package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfN101mSrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfN101m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101m_2018_DAO.java
 * @Description : PdfN101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfN101m_2018_DAO")
public class InfcPkgPdfN101m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_N101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101m(InfcPkgPdfN101m_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfN101m_2018_DAO.insertPdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101m(InfcPkgPdfN101m_2018_VO vo) throws Exception {
        update("infcPkgPdfN101m_2018_DAO.updatePdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101m(InfcPkgPdfN101m_2018_VO vo) throws Exception {
        delete("infcPkgPdfN101m_2018_DAO.deletePdfN101m_S", vo);
    }

    /**
	 * PDF_N101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101mVO
	 * @return 조회?�� PDF_N101M
	 * @exception Exception
	 */
    public InfcPkgPdfN101m_2018_VO selectPdfN101m(InfcPkgPdfN101m_2018_VO vo) throws Exception {
        return (InfcPkgPdfN101m_2018_VO) selectByPk("infcPkgPdfN101m_2018_DAO.selectPdfN101m_S", vo);
    }

    /**
	 * PDF_N101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101mList(InfcPkgPdfN101mSrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfN101m_2018_DAO.selectPdfN101mList_D", searchVO);
    }

    /**
	 * PDF_N101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101M �? �??��
	 * @exception
	 */
    public int selectPdfN101mListTotCnt(InfcPkgPdfN101mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfN101m_2018_DAO.selectPdfN101mListTotCnt_S", searchVO);
    }

}
