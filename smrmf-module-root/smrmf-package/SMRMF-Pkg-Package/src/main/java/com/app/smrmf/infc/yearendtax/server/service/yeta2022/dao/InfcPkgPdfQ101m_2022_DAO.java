package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfQ101mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfQ101m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfQ101m_2022_DAO.java
 * @Description : PdfQ101m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfQ101m_2022_DAO")
public class InfcPkgPdfQ101m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_Q101m?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfQ101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfQ101m(InfcPkgPdfQ101m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfQ101m_2022_DAO.insertPdfQ101m_S", vo);
    }

    /**
	 * PDF_Q101m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfQ101m(InfcPkgPdfQ101m_2022_VO vo) throws Exception {
        update("infcPkgPdfQ101m_2022_DAO.updatePdfQ101m_S", vo);
    }

    /**
	 * PDF_Q101m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfQ101m(InfcPkgPdfQ101m_2022_VO vo) throws Exception {
        delete("infcPkgPdfQ101m_2022_DAO.deletePdfQ101m_S", vo);
    }

    /**
	 * PDF_Q101m?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfQ101mVO
	 * @return 조회?�� PDF_Q101m
	 * @exception Exception
	 */
    public InfcPkgPdfQ101m_2022_VO selectPdfQ101m(InfcPkgPdfQ101m_2022_VO vo) throws Exception {
        return (InfcPkgPdfQ101m_2022_VO) selectByPk("infcPkgPdfQ101m_2022_DAO.selectPdfQ101m_S", vo);
    }

    /**
	 * PDF_Q101m 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q101m 목록
	 * @exception Exception
	 */
    public List<?> selectPdfQ101mList(InfcPkgPdfQ101mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfQ101m_2022_DAO.selectPdfQ101mList_D", searchVO);
    }

    /**
	 * PDF_Q101m �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q101m �? �??��
	 * @exception
	 */
    public int selectPdfQ101mListTotCnt(InfcPkgPdfQ101mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfQ101m_2022_DAO.selectPdfQ101mListTotCnt_S", searchVO);
    }

}
