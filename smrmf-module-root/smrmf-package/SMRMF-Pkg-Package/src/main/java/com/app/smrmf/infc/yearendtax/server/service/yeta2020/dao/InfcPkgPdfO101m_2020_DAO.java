package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfO101mSrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfO101m_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101m_2020_DAO.java
 * @Description : PdfO101m DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfO101m_2020_DAO")
public class InfcPkgPdfO101m_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_O101M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101m(InfcPkgPdfO101m_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfO101m_2020_DAO.insertPdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101m(InfcPkgPdfO101m_2020_VO vo) throws Exception {
        update("infcPkgPdfO101m_2020_DAO.updatePdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101m(InfcPkgPdfO101m_2020_VO vo) throws Exception {
        delete("infcPkgPdfO101m_2020_DAO.deletePdfO101m_S", vo);
    }

    /**
	 * PDF_O101M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101mVO
	 * @return 조회?�� PDF_O101M
	 * @exception Exception
	 */
    public InfcPkgPdfO101m_2020_VO selectPdfO101m(InfcPkgPdfO101m_2020_VO vo) throws Exception {
        return (InfcPkgPdfO101m_2020_VO) selectByPk("infcPkgPdfO101m_2020_DAO.selectPdfO101m_S", vo);
    }

    /**
	 * PDF_O101M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101mList(InfcPkgPdfO101mSrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfO101m_2020_DAO.selectPdfO101mList_D", searchVO);
    }

    /**
	 * PDF_O101M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101M �? �??��
	 * @exception
	 */
    public int selectPdfO101mListTotCnt(InfcPkgPdfO101mSrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfO101m_2020_DAO.selectPdfO101mListTotCnt_S", searchVO);
    }

}
