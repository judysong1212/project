package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfJ401mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfJ401m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ401m_2022_DAO.java
 * @Description : PdfJ401m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ401m_2022_DAO")
public class InfcPkgPdfJ401m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J401M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ401mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ401m(InfcPkgPdfJ401m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ401m_2022_DAO.insertPdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ401m(InfcPkgPdfJ401m_2022_VO vo) throws Exception {
        update("infcPkgPdfJ401m_2022_DAO.updatePdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ401mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ401m(InfcPkgPdfJ401m_2022_VO vo) throws Exception {
        delete("infcPkgPdfJ401m_2022_DAO.deletePdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ401mVO
	 * @return 조회?�� PDF_J401M
	 * @exception Exception
	 */
    public InfcPkgPdfJ401m_2022_VO selectPdfJ401m(InfcPkgPdfJ401m_2022_VO vo) throws Exception {
        return (InfcPkgPdfJ401m_2022_VO) selectByPk("infcPkgPdfJ401m_2022_DAO.selectPdfJ401m_S", vo);
    }

    /**
	 * PDF_J401M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ401mList(InfcPkgPdfJ401mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfJ401m_2022_DAO.selectPdfJ401mList_D", searchVO);
    }

    /**
	 * PDF_J401M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J401M �? �??��
	 * @exception
	 */
    public int selectPdfJ401mListTotCnt(InfcPkgPdfJ401mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ401m_2022_DAO.selectPdfJ401mListTotCnt_S", searchVO);
    }

}
