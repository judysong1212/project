package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ301mSrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ301m_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301m_2021_DAO.java
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

@Repository("InfcPkgPdfJ301m_2021_DAO")
public class InfcPkgPdfJ301m_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J301M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301m(InfcPkgPdfJ301m_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ301m_2021_DAO.insertPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301m(InfcPkgPdfJ301m_2021_VO vo) throws Exception {
        update("infcPkgPdfJ301m_2021_DAO.updatePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301m(InfcPkgPdfJ301m_2021_VO vo) throws Exception {
        delete("infcPkgPdfJ301m_2021_DAO.deletePdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301mVO
	 * @return 조회?�� PDF_J301M
	 * @exception Exception
	 */
    public InfcPkgPdfJ301m_2021_VO selectPdfJ301m(InfcPkgPdfJ301m_2021_VO vo) throws Exception {
        return (InfcPkgPdfJ301m_2021_VO) selectByPk("infcPkgPdfJ301m_2021_DAO.selectPdfJ301m_S", vo);
    }

    /**
	 * PDF_J301M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301mList(InfcPkgPdfJ301mSrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfJ301m_2021_DAO.selectPdfJ301mList_D", searchVO);
    }

    /**
	 * PDF_J301M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301M �? �??��
	 * @exception
	 */
    public int selectPdfJ301mListTotCnt(InfcPkgPdfJ301mSrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ301m_2021_DAO.selectPdfJ301mListTotCnt_S", searchVO);
    }

}
