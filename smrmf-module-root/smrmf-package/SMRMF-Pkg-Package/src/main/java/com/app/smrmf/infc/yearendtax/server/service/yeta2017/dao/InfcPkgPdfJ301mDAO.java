package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301mSrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301mVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301mDAO.java
 * @Description : PdfJ301m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ301mDAO")
public class InfcPkgPdfJ301mDAO extends EgovAbstractDAO {

	/**
	 * PDF_J301M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301m(InfcPkgPdfJ301mVO vo) throws Exception {
        return (String)insert("infcPkgPdfJ301mDAO.insertPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301m(InfcPkgPdfJ301mVO vo) throws Exception {
        update("infcPkgPdfJ301mDAO.updatePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301m(InfcPkgPdfJ301mVO vo) throws Exception {
        delete("infcPkgPdfJ301mDAO.deletePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301mVO
	 * @return 조회?�� PDF_J301M
	 * @exception Exception
	 */
    public InfcPkgPdfJ301mVO selectPdfJ301m(InfcPkgPdfJ301mVO vo) throws Exception {
        return (InfcPkgPdfJ301mVO) selectByPk("infcPkgPdfJ301mDAO.selectPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301mList(InfcPkgPdfJ301mSrhVO searchVO) throws Exception {
        return list("infcPkgPdfJ301mDAO.selectPdfJ301mList_D", searchVO);
    }

    /**
	 * PDF_J301M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M �? �??��
	 * @exception
	 */
    public int selectPdfJ301mListTotCnt(InfcPkgPdfJ301mSrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ301mDAO.selectPdfJ301mListTotCnt_S", searchVO);
    }

}
