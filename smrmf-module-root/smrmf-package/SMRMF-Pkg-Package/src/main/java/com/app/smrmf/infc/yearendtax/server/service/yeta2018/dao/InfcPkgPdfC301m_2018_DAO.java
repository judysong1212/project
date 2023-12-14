package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC301mSrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC301m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC301m_2018_DAO.java
 * @Description : PdfC301m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC301m_2018_DAO")
public class InfcPkgPdfC301m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C301M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC301m(InfcPkgPdfC301m_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC301m_2018_DAO.insertPdfC301m_S", vo);
    }

    /**
	 * PDF_C301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC301m(InfcPkgPdfC301m_2018_VO vo) throws Exception {
        update("infcPkgPdfC301m_2018_DAO.updatePdfC301m_S", vo);
    }

    /**
	 * PDF_C301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC301m(InfcPkgPdfC301m_2018_VO vo) throws Exception {
        delete("infcPkgPdfC301m_2018_DAO.deletePdfC301m_S", vo);
    }

    /**
	 * PDF_C301M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC301mVO
	 * @return 조회?�� PDF_C301M
	 * @exception Exception
	 */
    public InfcPkgPdfC301m_2018_VO selectPdfC301m(InfcPkgPdfC301m_2018_VO vo) throws Exception {
        return (InfcPkgPdfC301m_2018_VO) selectByPk("infcPkgPdfC301m_2018_DAO.selectPdfC301m_S", vo);
    }

    /**
	 * PDF_C301M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC301mList(InfcPkgPdfC301mSrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfC301m_2018_DAO.selectPdfC301mList_D", searchVO);
    }

    /**
	 * PDF_C301M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301M �? �??��
	 * @exception
	 */
    public int selectPdfC301mListTotCnt(InfcPkgPdfC301mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC301m_2018_DAO.selectPdfC301mListTotCnt_S", searchVO);
    }

}
