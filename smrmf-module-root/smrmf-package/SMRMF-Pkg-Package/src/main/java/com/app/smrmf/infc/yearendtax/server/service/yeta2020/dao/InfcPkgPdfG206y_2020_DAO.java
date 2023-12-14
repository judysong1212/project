package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG206ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG206y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG206y_2020_DAO.java
 * @Description : PdfG206y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG206y_2020_DAO")
public class InfcPkgPdfG206y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G206Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG206yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG206y(InfcPkgPdfG206y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG206y_2020_DAO.insertPdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG206y(InfcPkgPdfG206y_2020_VO vo) throws Exception {
        update("infcPkgPdfG206y_2020_DAO.updatePdfG206y_S", vo);
    }
    
    public void updateYetaP520001ToPdfG206y(InfcPkgPdfG206y_2020_VO vo) throws Exception {
    	update("infcPkgPdfG206y_2020_DAO.updateYetaP520001ToPdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG206yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG206y(InfcPkgPdfG206y_2020_VO vo) throws Exception {
        delete("infcPkgPdfG206y_2020_DAO.deletePdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG206yVO
	 * @return 조회?�� PDF_G206Y
	 * @exception Exception
	 */
    public InfcPkgPdfG206y_2020_VO selectPdfG206y(InfcPkgPdfG206y_2020_VO vo) throws Exception {
        return (InfcPkgPdfG206y_2020_VO) selectByPk("infcPkgPdfG206y_2020_DAO.selectPdfG206y_S", vo);
    }

    /**
	 * PDF_G206Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG206yList(InfcPkgPdfG206ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfG206y_2020_DAO.selectPdfG206yList_D", searchVO);
    }

    /**
	 * PDF_G206Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G206Y �? �??��
	 * @exception
	 */
    public int selectPdfG206yListTotCnt(InfcPkgPdfG206ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG206y_2020_DAO.selectPdfG206yListTotCnt_S", searchVO);
    }

}
