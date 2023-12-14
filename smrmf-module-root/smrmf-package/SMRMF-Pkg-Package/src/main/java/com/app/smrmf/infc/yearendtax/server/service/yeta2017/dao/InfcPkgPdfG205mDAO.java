package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG205mDAO.java
 * @Description : PdfG205m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG205mDAO")
public class InfcPkgPdfG205mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G205M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG205mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG205m(InfcPkgPdfG205mVO vo) throws Exception {
        return (String)insert("infcPkgPdfG205mDAO.insertPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG205m(InfcPkgPdfG205mVO vo) throws Exception {
        update("infcPkgPdfG205mDAO.updatePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG205mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG205m(InfcPkgPdfG205mVO vo) throws Exception {
        delete("infcPkgPdfG205mDAO.deletePdfG205m_S", vo);
    }

    /**
	 * PDF_G205M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG205mVO
	 * @return 조회?�� PDF_G205M
	 * @exception Exception
	 */
    public InfcPkgPdfG205mVO selectPdfG205m(InfcPkgPdfG205mVO vo) throws Exception {
        return (InfcPkgPdfG205mVO) selectByPk("infcPkgPdfG205mDAO.selectPdfG205m_S", vo);
    }

    /**
	 * PDF_G205M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG205mList(InfcPkgPdfG205mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfG205mDAO.selectPdfG205mList_D", searchVO);
    }

    /**
	 * PDF_G205M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G205M �? �??��
	 * @exception
	 */
    public int selectPdfG205mListTotCnt(InfcPkgPdfG205mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG205mDAO.selectPdfG205mListTotCnt_S", searchVO);
    }

}
