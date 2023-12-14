package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG407m_2022_DAO.java
 * @Description : PdfG407m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG407m_2022_DAO")
public class InfcPkgPdfG407m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG407mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG407m(InfcPkgPdfG407m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG407m_2022_DAO.insertPdfG407m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG407mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG407m(InfcPkgPdfG407m_2022_VO vo) throws Exception {
        update("infcPkgPdfG407m_2022_DAO.updatePdfG407m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG407mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG407m(InfcPkgPdfG407m_2022_VO vo) throws Exception {
        delete("infcPkgPdfG407m_2022_DAO.deletePdfG407m_S", vo);
    }

    /**
	 * PDF_G306M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG407mVO
	 * @return 조회?�� PDF_G306M
	 * @exception Exception
	 */
    public InfcPkgPdfG407m_2022_VO selectPdfG407m(InfcPkgPdfG407m_2022_VO vo) throws Exception {
        return (InfcPkgPdfG407m_2022_VO) selectByPk("infcPkgPdfG407m_2022_DAO.selectPdfG407m_S", vo);
    }

    /**
	 * PDF_G306M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG407mList(InfcPkgPdfG407mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfG407m_2022_DAO.selectPdfG407mList_D", searchVO);
    }

    /**
	 * PDF_G306M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M �? �??��
	 * @exception
	 */
    public int selectPdfG407mListTotCnt(InfcPkgPdfG407mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG407m_2022_DAO.selectPdfG407mListTotCnt_S", searchVO);
    }

}
