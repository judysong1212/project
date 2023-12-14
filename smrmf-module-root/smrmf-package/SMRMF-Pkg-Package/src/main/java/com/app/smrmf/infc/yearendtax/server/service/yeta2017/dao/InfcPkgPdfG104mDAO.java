package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG104mDAO.java
 * @Description : PdfG104m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG104mDAO")
public class InfcPkgPdfG104mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G104M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG104mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG104m(InfcPkgPdfG104mVO vo) throws Exception {
        return (String)insert("infcPkgPdfG104mDAO.insertPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG104m(InfcPkgPdfG104mVO vo) throws Exception {
        update("infcPkgPdfG104mDAO.updatePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG104mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG104m(InfcPkgPdfG104mVO vo) throws Exception {
        delete("infcPkgPdfG104mDAO.deletePdfG104m_S", vo);
    }

    /**
	 * PDF_G104M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG104mVO
	 * @return 조회?�� PDF_G104M
	 * @exception Exception
	 */
    public InfcPkgPdfG104mVO selectPdfG104m(InfcPkgPdfG104mVO vo) throws Exception {
        return (InfcPkgPdfG104mVO) selectByPk("infcPkgPdfG104mDAO.selectPdfG104m_S", vo);
    }

    /**
	 * PDF_G104M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG104mList(InfcPkgPdfG104mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfG104mDAO.selectPdfG104mList_D", searchVO);
    }

    /**
	 * PDF_G104M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G104M �? �??��
	 * @exception
	 */
    public int selectPdfG104mListTotCnt(InfcPkgPdfG104mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG104mDAO.selectPdfG104mListTotCnt_S", searchVO);
    }

}
