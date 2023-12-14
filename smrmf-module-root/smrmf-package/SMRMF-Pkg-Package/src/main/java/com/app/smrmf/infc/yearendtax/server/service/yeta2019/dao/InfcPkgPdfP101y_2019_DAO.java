package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfP101ySrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfP101y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfP101y_2019_DAO.java
 * @Description : PdfP101y DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfP101y_2019_DAO")
public class InfcPkgPdfP101y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_P101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfP101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfP101y(InfcPkgPdfP101y_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfP101y_2019_DAO.insertPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfP101y(InfcPkgPdfP101y_2019_VO vo) throws Exception {
        update("infcPkgPdfP101y_2019_DAO.updatePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfP101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfP101y(InfcPkgPdfP101y_2019_VO vo) throws Exception {
        delete("infcPkgPdfP101y_2019_DAO.deletePdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfP101yVO
	 * @return 조회?�� PDF_P101Y
	 * @exception Exception
	 */
    public InfcPkgPdfP101y_2019_VO selectPdfP101y(InfcPkgPdfP101y_2019_VO vo) throws Exception {
        return (InfcPkgPdfP101y_2019_VO) selectByPk("infcPkgPdfP101y_2019_DAO.selectPdfP101y_S", vo);
    }

    /**
	 * PDF_P101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfP101yList(InfcPkgPdfP101ySrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfP101y_2019_DAO.selectPdfP101yList_D", searchVO);
    }

    /**
	 * PDF_P101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_P101Y �? �??��
	 * @exception
	 */
    public int selectPdfP101yListTotCnt(InfcPkgPdfP101ySrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfP101y_2019_DAO.selectPdfP101yListTotCnt_S", searchVO);
    }

}
