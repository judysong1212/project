package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG306mDAO.java
 * @Description : PdfG306m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG306mDAO")
public class InfcPkgPdfG306mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G306M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG306mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG306m(InfcPkgPdfG306mVO vo) throws Exception {
        return (String)insert("infcPkgPdfG306mDAO.insertPdfG306m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG306m(InfcPkgPdfG306mVO vo) throws Exception {
        update("infcPkgPdfG306mDAO.updatePdfG306m_S", vo);
    }

    /**
	 * PDF_G306M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG306m(InfcPkgPdfG306mVO vo) throws Exception {
        delete("infcPkgPdfG306mDAO.deletePdfG306m_S", vo);
    }

    /**
	 * PDF_G306M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG306mVO
	 * @return 조회?�� PDF_G306M
	 * @exception Exception
	 */
    public InfcPkgPdfG306mVO selectPdfG306m(InfcPkgPdfG306mVO vo) throws Exception {
        return (InfcPkgPdfG306mVO) selectByPk("infcPkgPdfG306mDAO.selectPdfG306m_S", vo);
    }

    /**
	 * PDF_G306M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG306mList(InfcPkgPdfG306mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfG306mDAO.selectPdfG306mList_D", searchVO);
    }

    /**
	 * PDF_G306M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306M �? �??��
	 * @exception
	 */
    public int selectPdfG306mListTotCnt(InfcPkgPdfG306mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG306mDAO.selectPdfG306mListTotCnt_S", searchVO);
    }

}
