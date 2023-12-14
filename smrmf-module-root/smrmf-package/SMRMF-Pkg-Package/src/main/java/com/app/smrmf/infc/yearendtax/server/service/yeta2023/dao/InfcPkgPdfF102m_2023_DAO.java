package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfF102mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfF102m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfF102m_2023_DAO.java
 * @Description : PdfF102m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfF102m_2023_DAO")
public class InfcPkgPdfF102m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_F102M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfF102mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfF102m(InfcPkgPdfF102m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfF102m_2023_DAO.insertPdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfF102m(InfcPkgPdfF102m_2023_VO vo) throws Exception {
        update("infcPkgPdfF102m_2023_DAO.updatePdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfF102mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfF102m(InfcPkgPdfF102m_2023_VO vo) throws Exception {
        delete("infcPkgPdfF102m_2023_DAO.deletePdfF102m_S", vo);
    }

    /**
	 * PDF_F102M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfF102mVO
	 * @return 조회?�� PDF_F102M
	 * @exception Exception
	 */
    public InfcPkgPdfF102m_2023_VO selectPdfF102m(InfcPkgPdfF102m_2023_VO vo) throws Exception {
        return (InfcPkgPdfF102m_2023_VO) selectByPk("infcPkgPdfF102m_2023_DAO.selectPdfF102m_S", vo);
    }

    /**
	 * PDF_F102M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfF102mList(InfcPkgPdfF102mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfF102m_2023_DAO.selectPdfF102mList_D", searchVO);
    }

    /**
	 * PDF_F102M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_F102M �? �??��
	 * @exception
	 */
    public int selectPdfF102mListTotCnt(InfcPkgPdfF102mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfF102m_2023_DAO.selectPdfF102mListTotCnt_S", searchVO);
    }

}
