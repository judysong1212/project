package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG206mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG206m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG206m_2023_DAO.java
 * @Description : PdfG206m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG206m_2023_DAO")
public class InfcPkgPdfG206m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G206M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG206mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG206m(InfcPkgPdfG206m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG206m_2023_DAO.insertPdfG206m_S", vo);
    }

    /**
	 * PDF_G206M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG206m(InfcPkgPdfG206m_2023_VO vo) throws Exception {
        update("infcPkgPdfG206m_2023_DAO.updatePdfG206m_S", vo);
    }

    /**
	 * PDF_G206M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG206m(InfcPkgPdfG206m_2023_VO vo) throws Exception {
        delete("infcPkgPdfG206m_2023_DAO.deletePdfG206m_S", vo);
    }

    /**
	 * PDF_G206M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG206mVO
	 * @return 조회?�� PDF_G206M
	 * @exception Exception
	 */
    public InfcPkgPdfG206m_2023_VO selectPdfG206m(InfcPkgPdfG206m_2023_VO vo) throws Exception {
        return (InfcPkgPdfG206m_2023_VO) selectByPk("infcPkgPdfG206m_2023_DAO.selectPdfG206m_S", vo);
    }

    /**
	 * PDF_G206M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG206mList(InfcPkgPdfG206mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG206m_2023_DAO.selectPdfG206mList_D", searchVO);
    }

    /**
	 * PDF_G206M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206M �? �??��
	 * @exception
	 */
    public int selectPdfG206mListTotCnt(InfcPkgPdfG206mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG206m_2023_DAO.selectPdfG206mListTotCnt_S", searchVO);
    }

}
