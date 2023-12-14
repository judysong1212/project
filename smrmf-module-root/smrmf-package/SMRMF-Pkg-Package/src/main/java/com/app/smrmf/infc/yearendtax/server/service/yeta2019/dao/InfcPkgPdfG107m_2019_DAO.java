package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfG107mSrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfG107m_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG107m_2019_DAO.java
 * @Description : PdfG107m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG107m_2019_DAO")
public class InfcPkgPdfG107m_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G106M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG107mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG107m(InfcPkgPdfG107m_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG107m_2019_DAO.insertPdfG107m_S", vo);
    }

    /**
	 * PDF_G106M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG107mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG107m(InfcPkgPdfG107m_2019_VO vo) throws Exception {
        update("infcPkgPdfG107m_2019_DAO.updatePdfG107m_S", vo);
    }

    /**
	 * PDF_G106M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG107mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG107m(InfcPkgPdfG107m_2019_VO vo) throws Exception {
        delete("infcPkgPdfG107m_2019_DAO.deletePdfG107m_S", vo);
    }

    /**
	 * PDF_G106M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG107mVO
	 * @return 조회?�� PDF_G106M
	 * @exception Exception
	 */
    public InfcPkgPdfG107m_2019_VO selectPdfG107m(InfcPkgPdfG107m_2019_VO vo) throws Exception {
        return (InfcPkgPdfG107m_2019_VO) selectByPk("infcPkgPdfG107m_2019_DAO.selectPdfG107m_S", vo);
    }

    /**
	 * PDF_G106M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG107mList(InfcPkgPdfG107mSrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfG107m_2019_DAO.selectPdfG107mList_D", searchVO);
    }

    /**
	 * PDF_G106M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106M �? �??��
	 * @exception
	 */
    public int selectPdfG107mListTotCnt(InfcPkgPdfG107mSrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG107m_2019_DAO.selectPdfG107mListTotCnt_S", searchVO);
    }

}
