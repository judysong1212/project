package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102mDAO.java
 * @Description : PdfE102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfE102mDAO")
public class InfcPkgPdfE102mDAO extends EgovAbstractDAO {

	/**
	 * PDF_E102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102m(InfcPkgPdfE102mVO vo) throws Exception {
        return (String)insert("infcPkgPdfE102mDAO.insertPdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102m(InfcPkgPdfE102mVO vo) throws Exception {
        update("infcPkgPdfE102mDAO.updatePdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102m(InfcPkgPdfE102mVO vo) throws Exception {
        delete("infcPkgPdfE102mDAO.deletePdfE102m_S", vo);
    }

    /**
	 * PDF_E102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102mVO
	 * @return 조회?�� PDF_E102M
	 * @exception Exception
	 */
    public InfcPkgPdfE102mVO selectPdfE102m(InfcPkgPdfE102mVO vo) throws Exception {
        return (InfcPkgPdfE102mVO) selectByPk("infcPkgPdfE102mDAO.selectPdfE102m_S", vo);
    }

    /**
	 * PDF_E102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102mList(InfcPkgPdfE102mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfE102mDAO.selectPdfE102mList_D", searchVO);
    }

    /**
	 * PDF_E102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102M �? �??��
	 * @exception
	 */
    public int selectPdfE102mListTotCnt(InfcPkgPdfE102mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfE102mDAO.selectPdfE102mListTotCnt_S", searchVO);
    }

}
