package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG304mSrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG304m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304m_2020_DAO.java
 * @Description : PdfG304m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG304m_2020_DAO")
public class InfcPkgPdfG304m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G304M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304m(InfcPkgPdfG304m_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG304m_2020_DAO.insertPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304m(InfcPkgPdfG304m_2020_VO vo) throws Exception {
        update("infcPkgPdfG304m_2020_DAO.updatePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304m(InfcPkgPdfG304m_2020_VO vo) throws Exception {
        delete("infcPkgPdfG304m_2020_DAO.deletePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304mVO
	 * @return 조회?�� PDF_G304M
	 * @exception Exception
	 */
    public InfcPkgPdfG304m_2020_VO selectPdfG304m(InfcPkgPdfG304m_2020_VO vo) throws Exception {
        return (InfcPkgPdfG304m_2020_VO) selectByPk("infcPkgPdfG304m_2020_DAO.selectPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304mList(InfcPkgPdfG304mSrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfG304m_2020_DAO.selectPdfG304mList_D", searchVO);
    }

    /**
	 * PDF_G304M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M �? �??��
	 * @exception
	 */
    public int selectPdfG304mListTotCnt(InfcPkgPdfG304mSrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG304m_2020_DAO.selectPdfG304mListTotCnt_S", searchVO);
    }

}
