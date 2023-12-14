package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfA102y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG107ySrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG107y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG107y_2022_DAO.java
 * @Description : PdfG107y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG107y_2022_DAO")
public class InfcPkgPdfG107y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G106Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG107yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG107y(InfcPkgPdfG107y_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG107y_2022_DAO.insertPdfG107y_S", vo);
    }

    /**
	 * PDF_G106Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG107yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG107y(InfcPkgPdfG107y_2022_VO vo) throws Exception {
        update("infcPkgPdfG107y_2022_DAO.updatePdfG107y_S", vo);
    }
    
    public void updateYetaP720001ToPdfG107y(InfcPkgPdfG107y_2022_VO vo) throws Exception {
    	update("infcPkgPdfG107y_2022_DAO.updateYetaP720001ToPdfG107y_S", vo);
    }

    /**
	 * PDF_G106Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG107yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG107y(InfcPkgPdfG107y_2022_VO vo) throws Exception {
        delete("infcPkgPdfG107y_2022_DAO.deletePdfG107y_S", vo);
    }

    /**
	 * PDF_G106Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG107yVO
	 * @return 조회?�� PDF_G106Y
	 * @exception Exception
	 */
    public InfcPkgPdfG107y_2022_VO selectPdfG107y(InfcPkgPdfG107y_2022_VO vo) throws Exception {
        return (InfcPkgPdfG107y_2022_VO) selectByPk("infcPkgPdfG107y_2022_DAO.selectPdfG107y_S", vo);
    }

    /**
	 * PDF_G106Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG107yList(InfcPkgPdfG107ySrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfG107y_2022_DAO.selectPdfG107yList_D", searchVO);
    }

    /**
	 * PDF_G106Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106Y �? �??��
	 * @exception
	 */
    public int selectPdfG107yListTotCnt(InfcPkgPdfG107ySrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG107y_2022_DAO.selectPdfG107yListTotCnt_S", searchVO);
    }

}
