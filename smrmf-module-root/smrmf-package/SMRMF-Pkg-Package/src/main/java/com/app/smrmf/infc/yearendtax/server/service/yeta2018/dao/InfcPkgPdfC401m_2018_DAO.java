package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC401mSrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC401m_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC401m_2018_DAO.java
 * @Description : PdfC401m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC401m_2018_DAO")
public class InfcPkgPdfC401m_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C401M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC401mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC401m(InfcPkgPdfC401m_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC401m_2018_DAO.insertPdfC401m_S", vo);
    }

    /**
	 * PDF_C401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC401m(InfcPkgPdfC401m_2018_VO vo) throws Exception {
        update("infcPkgPdfC401m_2018_DAO.updatePdfC401m_S", vo);
    }

    /**
	 * PDF_C401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC401m(InfcPkgPdfC401m_2018_VO vo) throws Exception {
        delete("infcPkgPdfC401m_2018_DAO.deletePdfC401m_S", vo);
    }

    /**
	 * PDF_C401M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC401mVO
	 * @return 조회?�� PDF_C401M
	 * @exception Exception
	 */
    public InfcPkgPdfC401m_2018_VO selectPdfC401m(InfcPkgPdfC401m_2018_VO vo) throws Exception {
        return (InfcPkgPdfC401m_2018_VO) selectByPk("infcPkgPdfC401m_2018_DAO.selectPdfC401m_S", vo);
    }

    /**
	 * PDF_C401M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC401mList(InfcPkgPdfC401mSrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfC401m_2018_DAO.selectPdfC401mList_D", searchVO);
    }

    /**
	 * PDF_C401M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401M �? �??��
	 * @exception
	 */
    public int selectPdfC401mListTotCnt(InfcPkgPdfC401mSrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC401m_2018_DAO.selectPdfC401mListTotCnt_S", searchVO);
    }

}
