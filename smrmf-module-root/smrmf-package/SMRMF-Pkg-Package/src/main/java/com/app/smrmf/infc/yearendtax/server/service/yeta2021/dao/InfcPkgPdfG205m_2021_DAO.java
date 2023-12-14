package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG205mSrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG205m_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG205m_2021_DAO.java
 * @Description : PdfG205m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG205m_2021_DAO")
public class InfcPkgPdfG205m_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G205M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG205mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG205m(InfcPkgPdfG205m_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG205m_2021_DAO.insertPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG205m(InfcPkgPdfG205m_2021_VO vo) throws Exception {
        update("infcPkgPdfG205m_2021_DAO.updatePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG205m(InfcPkgPdfG205m_2021_VO vo) throws Exception {
        delete("infcPkgPdfG205m_2021_DAO.deletePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG205mVO
	 * @return 조회?�� PDF_G205M
	 * @exception Exception
	 */
    public InfcPkgPdfG205m_2021_VO selectPdfG205m(InfcPkgPdfG205m_2021_VO vo) throws Exception {
        return (InfcPkgPdfG205m_2021_VO) selectByPk("infcPkgPdfG205m_2021_DAO.selectPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG205mList(InfcPkgPdfG205mSrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfG205m_2021_DAO.selectPdfG205mList_D", searchVO);
    }

    /**
	 * PDF_G205M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M �? �??��
	 * @exception
	 */
    public int selectPdfG205mListTotCnt(InfcPkgPdfG205mSrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG205m_2021_DAO.selectPdfG205mListTotCnt_S", searchVO);
    }

}
