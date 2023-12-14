package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfJ501mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfJ501m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ501m_2022_DAO.java
 * @Description : PdfJ501m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ501m_2022_DAO")
public class InfcPkgPdfJ501m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J501m?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ501mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ501m(InfcPkgPdfJ501m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ501m_2022_DAO.insertPdfJ501m_S", vo);
    }

    /**
	 * PDF_J501m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ501mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ501m(InfcPkgPdfJ501m_2022_VO vo) throws Exception {
        update("infcPkgPdfJ501m_2022_DAO.updatePdfJ501m_S", vo);
    }

    /**
	 * PDF_J501m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ501mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ501m(InfcPkgPdfJ501m_2022_VO vo) throws Exception {
        delete("infcPkgPdfJ501m_2022_DAO.deletePdfJ501m_S", vo);
    }

    /**
	 * PDF_J501m?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ501mVO
	 * @return 조회?�� PDF_J501m
	 * @exception Exception
	 */
    public InfcPkgPdfJ501m_2022_VO selectPdfJ501m(InfcPkgPdfJ501m_2022_VO vo) throws Exception {
        return (InfcPkgPdfJ501m_2022_VO) selectByPk("infcPkgPdfJ501m_2022_DAO.selectPdfJ501m_S", vo);
    }

    /**
	 * PDF_J501m 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J501m 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ501mList(InfcPkgPdfJ501mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfJ501m_2022_DAO.selectPdfJ501mList_D", searchVO);
    }

    /**
	 * PDF_J501m �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J501m �? �??��
	 * @exception
	 */
    public int selectPdfJ501mListTotCnt(InfcPkgPdfJ501mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ501m_2022_DAO.selectPdfJ501mListTotCnt_S", searchVO);
    }

}
