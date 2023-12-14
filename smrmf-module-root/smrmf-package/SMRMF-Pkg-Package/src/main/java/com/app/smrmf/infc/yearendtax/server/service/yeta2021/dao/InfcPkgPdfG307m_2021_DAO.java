package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG307mSrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG307m_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG307m_2021_DAO.java
 * @Description : PdfG307m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG307m_2021_DAO")
public class InfcPkgPdfG307m_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG307mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG307m(InfcPkgPdfG307m_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG307m_2021_DAO.insertPdfG307m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG307mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG307m(InfcPkgPdfG307m_2021_VO vo) throws Exception {
        update("infcPkgPdfG307m_2021_DAO.updatePdfG307m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG307mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG307m(InfcPkgPdfG307m_2021_VO vo) throws Exception {
        delete("infcPkgPdfG307m_2021_DAO.deletePdfG307m_S", vo);
    }

    /**
	 * PDF_G306M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG307mVO
	 * @return 조회?�� PDF_G306M
	 * @exception Exception
	 */
    public InfcPkgPdfG307m_2021_VO selectPdfG307m(InfcPkgPdfG307m_2021_VO vo) throws Exception {
        return (InfcPkgPdfG307m_2021_VO) selectByPk("infcPkgPdfG307m_2021_DAO.selectPdfG307m_S", vo);
    }

    /**
	 * PDF_G306M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG307mList(InfcPkgPdfG307mSrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfG307m_2021_DAO.selectPdfG307mList_D", searchVO);
    }

    /**
	 * PDF_G306M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M �? �??��
	 * @exception
	 */
    public int selectPdfG307mListTotCnt(InfcPkgPdfG307mSrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG307m_2021_DAO.selectPdfG307mListTotCnt_S", searchVO);
    }

}
