package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG306mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG306m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG306m_2023_DAO.java
 * @Description : PdfG306m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG306m_2023_DAO")
public class InfcPkgPdfG306m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG306mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG306m(InfcPkgPdfG306m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG306m_2023_DAO.insertPdfG306m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG306m(InfcPkgPdfG306m_2023_VO vo) throws Exception {
        update("infcPkgPdfG306m_2023_DAO.updatePdfG306m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG306m(InfcPkgPdfG306m_2023_VO vo) throws Exception {
        delete("infcPkgPdfG306m_2023_DAO.deletePdfG306m_S", vo);
    }

    /**
	 * PDF_G306M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG306mVO
	 * @return 조회?�� PDF_G306M
	 * @exception Exception
	 */
    public InfcPkgPdfG306m_2023_VO selectPdfG306m(InfcPkgPdfG306m_2023_VO vo) throws Exception {
        return (InfcPkgPdfG306m_2023_VO) selectByPk("infcPkgPdfG306m_2023_DAO.selectPdfG306m_S", vo);
    }

    /**
	 * PDF_G306M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG306mList(InfcPkgPdfG306mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG306m_2023_DAO.selectPdfG306mList_D", searchVO);
    }

    /**
	 * PDF_G306M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M �? �??��
	 * @exception
	 */
    public int selectPdfG306mListTotCnt(InfcPkgPdfG306mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG306m_2023_DAO.selectPdfG306mListTotCnt_S", searchVO);
    }

}
