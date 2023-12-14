package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304mDAO.java
 * @Description : PdfG304m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG304mDAO")
public class InfcPkgPdfG304mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G304M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304m(InfcPkgPdfG304mVO vo) throws Exception {
        return (String)insert("infcPkgPdfG304mDAO.insertPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304m(InfcPkgPdfG304mVO vo) throws Exception {
        update("infcPkgPdfG304mDAO.updatePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304m(InfcPkgPdfG304mVO vo) throws Exception {
        delete("infcPkgPdfG304mDAO.deletePdfG304m_S", vo);
    }

    /**
	 * PDF_G304M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304mVO
	 * @return 조회?�� PDF_G304M
	 * @exception Exception
	 */
    public InfcPkgPdfG304mVO selectPdfG304m(InfcPkgPdfG304mVO vo) throws Exception {
        return (InfcPkgPdfG304mVO) selectByPk("infcPkgPdfG304mDAO.selectPdfG304m_S", vo);
    }

    /**
	 * PDF_G304M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304mList(InfcPkgPdfG304mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfG304mDAO.selectPdfG304mList_D", searchVO);
    }

    /**
	 * PDF_G304M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304M �? �??��
	 * @exception
	 */
    public int selectPdfG304mListTotCnt(InfcPkgPdfG304mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG304mDAO.selectPdfG304mListTotCnt_S", searchVO);
    }

}
