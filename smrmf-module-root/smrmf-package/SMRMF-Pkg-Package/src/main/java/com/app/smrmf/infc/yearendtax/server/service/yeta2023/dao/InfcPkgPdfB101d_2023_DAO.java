package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB101dSrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB101d_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101d_2023_DAO.java
 * @Description : PdfB101d DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfB101d_2023_DAO")
public class InfcPkgPdfB101d_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_B101D?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101dVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101d(InfcPkgPdfB101d_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfB101d_2023_DAO.insertPdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101dVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101d(InfcPkgPdfB101d_2023_VO vo) throws Exception {
        update("infcPkgPdfB101d_2023_DAO.updatePdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101dVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101d(InfcPkgPdfB101d_2023_VO vo) throws Exception {
        delete("infcPkgPdfB101d_2023_DAO.deletePdfB101d_S", vo);
    }

    /**
	 * PDF_B101D?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101dVO
	 * @return 조회?�� PDF_B101D
	 * @exception Exception
	 */
    public InfcPkgPdfB101d_2023_VO selectPdfB101d(InfcPkgPdfB101d_2023_VO vo) throws Exception {
        return (InfcPkgPdfB101d_2023_VO) selectByPk("infcPkgPdfB101d_2023_DAO.selectPdfB101d_S", vo);
    }

    /**
	 * PDF_B101D 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101D 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101dList(InfcPkgPdfB101dSrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfB101d_2023_DAO.selectPdfB101dList_D", searchVO);
    }

    /**
	 * PDF_B101D �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101D �? �??��
	 * @exception
	 */
    public int selectPdfB101dListTotCnt(InfcPkgPdfB101dSrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfB101d_2023_DAO.selectPdfB101dListTotCnt_S", searchVO);
    }

}
