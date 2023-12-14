package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfQ301mSrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfQ301m_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfQ301m_2022_DAO.java
 * @Description : PdfQ301m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfQ301m_2022_DAO")
public class InfcPkgPdfQ301m_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_Q301m?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfQ301mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfQ301m(InfcPkgPdfQ301m_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfQ301m_2022_DAO.insertPdfQ301m_S", vo);
    }

    /**
	 * PDF_Q301m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ301mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfQ301m(InfcPkgPdfQ301m_2022_VO vo) throws Exception {
        update("infcPkgPdfQ301m_2022_DAO.updatePdfQ301m_S", vo);
    }

    /**
	 * PDF_Q301m?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ301mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfQ301m(InfcPkgPdfQ301m_2022_VO vo) throws Exception {
        delete("infcPkgPdfQ301m_2022_DAO.deletePdfQ301m_S", vo);
    }

    /**
	 * PDF_Q301m?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfQ301mVO
	 * @return 조회?�� PDF_Q301m
	 * @exception Exception
	 */
    public InfcPkgPdfQ301m_2022_VO selectPdfQ301m(InfcPkgPdfQ301m_2022_VO vo) throws Exception {
        return (InfcPkgPdfQ301m_2022_VO) selectByPk("infcPkgPdfQ301m_2022_DAO.selectPdfQ301m_S", vo);
    }

    /**
	 * PDF_Q301m 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q301m 목록
	 * @exception Exception
	 */
    public List<?> selectPdfQ301mList(InfcPkgPdfQ301mSrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfQ301m_2022_DAO.selectPdfQ301mList_D", searchVO);
    }

    /**
	 * PDF_Q301m �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q301m �? �??��
	 * @exception
	 */
    public int selectPdfQ301mListTotCnt(InfcPkgPdfQ301mSrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfQ301m_2022_DAO.selectPdfQ301mListTotCnt_S", searchVO);
    }

}
