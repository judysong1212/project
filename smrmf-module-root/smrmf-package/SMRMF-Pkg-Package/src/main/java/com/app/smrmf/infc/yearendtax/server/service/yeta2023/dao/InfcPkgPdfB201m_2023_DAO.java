package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB201m_2023_DAO.java
 * @Description : PdfB201m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfB201m_2023_DAO")
public class InfcPkgPdfB201m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_B201m?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB201mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB201m(InfcPkgPdfB201m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfB201m_2023_DAO.insertPdfB201m_S", vo);
    }

    /**
	 * PDF_B201m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB201mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB201m(InfcPkgPdfB201m_2023_VO vo) throws Exception {
        update("infcPkgPdfB201m_2023_DAO.updatePdfB201m_S", vo);
    }

    /**
	 * PDF_B201m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB201mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB201m(InfcPkgPdfB201m_2023_VO vo) throws Exception {
        delete("infcPkgPdfB201m_2023_DAO.deletePdfB201m_S", vo);
    }

    /**
	 * PDF_B201m?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB201mVO
	 * @return 조회?�� PDF_B201m
	 * @exception Exception
	 */
    public InfcPkgPdfB201m_2023_VO selectPdfB201m(InfcPkgPdfB201m_2023_VO vo) throws Exception {
        return (InfcPkgPdfB201m_2023_VO) selectByPk("infcPkgPdfB201m_2023_DAO.selectPdfB201m_S", vo);
    }

    /**
	 * PDF_B201m 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B201m 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB201mList(InfcPkgPdfB201mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfB201m_2023_DAO.selectPdfB201mList_D", searchVO);
    }

    /**
	 * PDF_B201m �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B201m �? �??��
	 * @exception
	 */
    public int selectPdfB201mListTotCnt(InfcPkgPdfB201mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfB201m_2023_DAO.selectPdfB201mListTotCnt_S", searchVO);
    }

}
