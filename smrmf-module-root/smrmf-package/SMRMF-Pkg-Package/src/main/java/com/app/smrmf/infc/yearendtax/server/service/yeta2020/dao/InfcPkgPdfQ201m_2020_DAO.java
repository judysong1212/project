package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfQ201mSrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfQ201m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfQ201m_2020_DAO.java
 * @Description : PdfQ201m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfQ201m_2020_DAO")
public class InfcPkgPdfQ201m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_Q201m?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfQ201mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfQ201m(InfcPkgPdfQ201m_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfQ201m_2020_DAO.insertPdfQ201m_S", vo);
    }

    /**
	 * PDF_Q201m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ201mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfQ201m(InfcPkgPdfQ201m_2020_VO vo) throws Exception {
        update("infcPkgPdfQ201m_2020_DAO.updatePdfQ201m_S", vo);
    }

    /**
	 * PDF_Q201m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ201mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfQ201m(InfcPkgPdfQ201m_2020_VO vo) throws Exception {
        delete("infcPkgPdfQ201m_2020_DAO.deletePdfQ201m_S", vo);
    }

    /**
	 * PDF_Q201m?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfQ201mVO
	 * @return 조회?�� PDF_Q201m
	 * @exception Exception
	 */
    public InfcPkgPdfQ201m_2020_VO selectPdfQ201m(InfcPkgPdfQ201m_2020_VO vo) throws Exception {
        return (InfcPkgPdfQ201m_2020_VO) selectByPk("infcPkgPdfQ201m_2020_DAO.selectPdfQ201m_S", vo);
    }

    /**
	 * PDF_Q201m 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q201m 목록
	 * @exception Exception
	 */
    public List<?> selectPdfQ201mList(InfcPkgPdfQ201mSrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfQ201m_2020_DAO.selectPdfQ201mList_D", searchVO);
    }

    /**
	 * PDF_Q201m �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q201m �? �??��
	 * @exception
	 */
    public int selectPdfQ201mListTotCnt(InfcPkgPdfQ201mSrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfQ201m_2020_DAO.selectPdfQ201mListTotCnt_S", searchVO);
    }

}
