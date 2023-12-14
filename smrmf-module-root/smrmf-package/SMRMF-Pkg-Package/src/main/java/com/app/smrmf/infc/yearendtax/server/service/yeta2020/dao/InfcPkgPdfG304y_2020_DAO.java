package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG304ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG304y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG304y_2020_DAO.java
 * @Description : PdfG304y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG304y_2020_DAO")
public class InfcPkgPdfG304y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G304Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG304yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG304y(InfcPkgPdfG304y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG304y_2020_DAO.insertPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG304y(InfcPkgPdfG304y_2020_VO vo) throws Exception {
        update("infcPkgPdfG304y_2020_DAO.updatePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG304yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG304y(InfcPkgPdfG304y_2020_VO vo) throws Exception {
        delete("infcPkgPdfG304y_2020_DAO.deletePdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG304yVO
	 * @return 조회?�� PDF_G304Y
	 * @exception Exception
	 */
    public InfcPkgPdfG304y_2020_VO selectPdfG304y(InfcPkgPdfG304y_2020_VO vo) throws Exception {
        return (InfcPkgPdfG304y_2020_VO) selectByPk("infcPkgPdfG304y_2020_DAO.selectPdfG304y_S", vo);
    }

    /**
	 * PDF_G304Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG304yList(InfcPkgPdfG304ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfG304y_2020_DAO.selectPdfG304yList_D", searchVO);
    }

    /**
	 * PDF_G304Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G304Y �? �??��
	 * @exception
	 */
    public int selectPdfG304yListTotCnt(InfcPkgPdfG304ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG304y_2020_DAO.selectPdfG304yListTotCnt_S", searchVO);
    }

}
