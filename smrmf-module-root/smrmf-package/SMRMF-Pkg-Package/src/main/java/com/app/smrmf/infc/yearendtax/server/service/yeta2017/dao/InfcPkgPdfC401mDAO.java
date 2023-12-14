package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC401mDAO.java
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

@Repository("InfcPkgPdfC401mDAO")
public class InfcPkgPdfC401mDAO extends EgovAbstractDAO {

	/**
	 * PDF_C401M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC401mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC401m(InfcPkgPdfC401mVO vo) throws Exception {
        return (String)insert("infcPkgPdfC401mDAO.insertPdfC401m_S", vo);
    }

    /**
	 * PDF_C401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC401m(InfcPkgPdfC401mVO vo) throws Exception {
        update("infcPkgPdfC401mDAO.updatePdfC401m_S", vo);
    }

    /**
	 * PDF_C401M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC401mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC401m(InfcPkgPdfC401mVO vo) throws Exception {
        delete("infcPkgPdfC401mDAO.deletePdfC401m_S", vo);
    }

    /**
	 * PDF_C401M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC401mVO
	 * @return 조회?�� PDF_C401M
	 * @exception Exception
	 */
    public InfcPkgPdfC401mVO selectPdfC401m(InfcPkgPdfC401mVO vo) throws Exception {
        return (InfcPkgPdfC401mVO) selectByPk("infcPkgPdfC401mDAO.selectPdfC401m_S", vo);
    }

    /**
	 * PDF_C401M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC401mList(InfcPkgPdfC401mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfC401mDAO.selectPdfC401mList_D", searchVO);
    }

    /**
	 * PDF_C401M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C401M �? �??��
	 * @exception
	 */
    public int selectPdfC401mListTotCnt(InfcPkgPdfC401mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC401mDAO.selectPdfC401mListTotCnt_S", searchVO);
    }

}
