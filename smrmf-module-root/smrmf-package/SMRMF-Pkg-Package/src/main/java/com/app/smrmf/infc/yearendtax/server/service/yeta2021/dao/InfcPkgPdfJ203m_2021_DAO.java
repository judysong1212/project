package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ203mSrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ203m_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ203m_2021_DAO.java
 * @Description : PdfJ203m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ203m_2021_DAO")
public class InfcPkgPdfJ203m_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J203M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ203mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ203m(InfcPkgPdfJ203m_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ203m_2021_DAO.insertPdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ203m(InfcPkgPdfJ203m_2021_VO vo) throws Exception {
        update("infcPkgPdfJ203m_2021_DAO.updatePdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ203mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ203m(InfcPkgPdfJ203m_2021_VO vo) throws Exception {
        delete("infcPkgPdfJ203m_2021_DAO.deletePdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ203mVO
	 * @return 조회?�� PDF_J203M
	 * @exception Exception
	 */
    public InfcPkgPdfJ203m_2021_VO selectPdfJ203m(InfcPkgPdfJ203m_2021_VO vo) throws Exception {
        return (InfcPkgPdfJ203m_2021_VO) selectByPk("infcPkgPdfJ203m_2021_DAO.selectPdfJ203m_S", vo);
    }

    /**
	 * PDF_J203M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ203mList(InfcPkgPdfJ203mSrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfJ203m_2021_DAO.selectPdfJ203mList_D", searchVO);
    }

    /**
	 * PDF_J203M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J203M �? �??��
	 * @exception
	 */
    public int selectPdfJ203mListTotCnt(InfcPkgPdfJ203mSrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ203m_2021_DAO.selectPdfJ203mListTotCnt_S", searchVO);
    }

}
