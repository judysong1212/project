package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG106mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG106m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG106m_2023_DAO.java
 * @Description : PdfG106m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG106m_2023_DAO")
public class InfcPkgPdfG106m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G106M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG106mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG106m(InfcPkgPdfG106m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG106m_2023_DAO.insertPdfG106m_S", vo);
    }

    /**
	 * PDF_G106M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG106mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG106m(InfcPkgPdfG106m_2023_VO vo) throws Exception {
        update("infcPkgPdfG106m_2023_DAO.updatePdfG106m_S", vo);
    }

    /**
	 * PDF_G106M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG106mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG106m(InfcPkgPdfG106m_2023_VO vo) throws Exception {
        delete("infcPkgPdfG106m_2023_DAO.deletePdfG106m_S", vo);
    }

    /**
	 * PDF_G106M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG106mVO
	 * @return 조회?�� PDF_G106M
	 * @exception Exception
	 */
    public InfcPkgPdfG106m_2023_VO selectPdfG106m(InfcPkgPdfG106m_2023_VO vo) throws Exception {
        return (InfcPkgPdfG106m_2023_VO) selectByPk("infcPkgPdfG106m_2023_DAO.selectPdfG106m_S", vo);
    }

    /**
	 * PDF_G106M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG106mList(InfcPkgPdfG106mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG106m_2023_DAO.selectPdfG106mList_D", searchVO);
    }

    /**
	 * PDF_G106M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106M �? �??��
	 * @exception
	 */
    public int selectPdfG106mListTotCnt(InfcPkgPdfG106mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG106m_2023_DAO.selectPdfG106mListTotCnt_S", searchVO);
    }

}
