package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG207mSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG207m_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG207m_2023_DAO.java
 * @Description : PdfG207m DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG207m_2023_DAO")
public class InfcPkgPdfG207m_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G206M?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG207mVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG207m(InfcPkgPdfG207m_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG207m_2023_DAO.insertPdfG207m_S", vo);
    }

    /**
	 * PDF_G206M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG207mVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG207m(InfcPkgPdfG207m_2023_VO vo) throws Exception {
        update("infcPkgPdfG207m_2023_DAO.updatePdfG207m_S", vo);
    }

    /**
	 * PDF_G206M?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG207mVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG207m(InfcPkgPdfG207m_2023_VO vo) throws Exception {
        delete("infcPkgPdfG207m_2023_DAO.deletePdfG207m_S", vo);
    }

    /**
	 * PDF_G206M?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG207mVO
	 * @return 조회?�� PDF_G206M
	 * @exception Exception
	 */
    public InfcPkgPdfG207m_2023_VO selectPdfG207m(InfcPkgPdfG207m_2023_VO vo) throws Exception {
        return (InfcPkgPdfG207m_2023_VO) selectByPk("infcPkgPdfG207m_2023_DAO.selectPdfG207m_S", vo);
    }

    /**
	 * PDF_G206M 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206M 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG207mList(InfcPkgPdfG207mSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG207m_2023_DAO.selectPdfG207mList_D", searchVO);
    }

    /**
	 * PDF_G206M �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206M �? �??��
	 * @exception
	 */
    public int selectPdfG207mListTotCnt(InfcPkgPdfG207mSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG207m_2023_DAO.selectPdfG207mListTotCnt_S", searchVO);
    }

}
