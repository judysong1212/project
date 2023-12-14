package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG104mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG104m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG104m_2023_DAO.java
 * @Description : PdfG104m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG104m_2023_DAO")
public class InfcPkgPdfG104m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G104M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG104mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG104m(InfcPkgPdfG104m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG104m_2023_DAO.insertPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG104m(InfcPkgPdfG104m_2023_VO vo) throws Exception {
        update("infcPkgPdfG104m_2023_DAO.updatePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG104m(InfcPkgPdfG104m_2023_VO vo) throws Exception {
        delete("infcPkgPdfG104m_2023_DAO.deletePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG104mVO
	 * @return 조회?�� PDF_G104M
	 * @exception Exception
	 */
    public InfcPkgPdfG104m_2023_VO selectPdfG104m(InfcPkgPdfG104m_2023_VO vo) throws Exception {
        return (InfcPkgPdfG104m_2023_VO) selectByPk("infcPkgPdfG104m_2023_DAO.selectPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG104mList(InfcPkgPdfG104mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG104m_2023_DAO.selectPdfG104mList_D", searchVO);
    }

    /**
	 * PDF_G104M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M �? �??��
	 * @exception
	 */
    public int selectPdfG104mListTotCnt(InfcPkgPdfG104mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG104m_2023_DAO.selectPdfG104mListTotCnt_S", searchVO);
    }

}
