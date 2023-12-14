package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG206mDAO.java
 * @Description : PdfG206m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG206mDAO")
public class InfcPkgPdfG206mDAO extends EgovAbstractDAO {

	/**
	 * PDF_G206M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG206mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG206m(InfcPkgPdfG206mVO vo) throws Exception {
        return (String)insert("infcPkgPdfG206mDAO.insertPdfG206m_S", vo);
    }

    /**
	 * PDF_G206M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG206m(InfcPkgPdfG206mVO vo) throws Exception {
        update("infcPkgPdfG206mDAO.updatePdfG206m_S", vo);
    }

    /**
	 * PDF_G206M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG206m(InfcPkgPdfG206mVO vo) throws Exception {
        delete("infcPkgPdfG206mDAO.deletePdfG206m_S", vo);
    }

    /**
	 * PDF_G206M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG206mVO
	 * @return 조회?�� PDF_G206M
	 * @exception Exception
	 */
    public InfcPkgPdfG206mVO selectPdfG206m(InfcPkgPdfG206mVO vo) throws Exception {
        return (InfcPkgPdfG206mVO) selectByPk("infcPkgPdfG206mDAO.selectPdfG206m_S", vo);
    }

    /**
	 * PDF_G206M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG206mList(InfcPkgPdfG206mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfG206mDAO.selectPdfG206mList_D", searchVO);
    }

    /**
	 * PDF_G206M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206M �? �??��
	 * @exception
	 */
    public int selectPdfG206mListTotCnt(InfcPkgPdfG206mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG206mDAO.selectPdfG206mListTotCnt_S", searchVO);
    }

}
