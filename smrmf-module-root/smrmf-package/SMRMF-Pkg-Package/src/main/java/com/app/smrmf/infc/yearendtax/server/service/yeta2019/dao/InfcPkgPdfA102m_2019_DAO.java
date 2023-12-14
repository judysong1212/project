package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfA102mSrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfA102m_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102m_2019_DAO.java
 * @Description : PdfA102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfA102m_2019_DAO")
public class InfcPkgPdfA102m_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_A102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102m(InfcPkgPdfA102m_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfA102m_2019_DAO.insertPdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102m(InfcPkgPdfA102m_2019_VO vo) throws Exception {
        update("infcPkgPdfA102m_2019_DAO.updatePdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102m(InfcPkgPdfA102m_2019_VO vo) throws Exception {
        delete("infcPkgPdfA102m_2019_DAO.deletePdfA102m_S", vo);
    }

    /**
	 * PDF_A102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102mVO
	 * @return 조회?�� PDF_A102M
	 * @exception Exception
	 */
    public InfcPkgPdfA102m_2019_VO selectPdfA102m(InfcPkgPdfA102m_2019_VO vo) throws Exception {
        return (InfcPkgPdfA102m_2019_VO) selectByPk("infcPkgPdfA102m_2019_DAO.selectPdfA102m_S", vo);
    }

    /**
	 * PDF_A102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102mList(InfcPkgPdfA102mSrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfA102m_2019_DAO.selectPdfA102mList_D", searchVO);
    }

    /**
	 * PDF_A102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102M �? �??��
	 * @exception
	 */
    public int selectPdfA102mListTotCnt(InfcPkgPdfA102mSrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfA102m_2019_DAO.selectPdfA102mListTotCnt_S", searchVO);
    }

}
