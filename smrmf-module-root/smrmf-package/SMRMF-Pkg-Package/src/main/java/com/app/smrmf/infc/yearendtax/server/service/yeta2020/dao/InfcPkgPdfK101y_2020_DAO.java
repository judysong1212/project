package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfK101ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfK101y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfK101y_2020_DAO.java
 * @Description : PdfK101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfK101y_2020_DAO")
public class InfcPkgPdfK101y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_K101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfK101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfK101y(InfcPkgPdfK101y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfK101y_2020_DAO.insertPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfK101y(InfcPkgPdfK101y_2020_VO vo) throws Exception {
        update("infcPkgPdfK101y_2020_DAO.updatePdfK101y_S", vo);
    }
    
    public void updateYetaP520001ToPdfK101y(InfcPkgPdfK101y_2020_VO vo) throws Exception {
    	update("infcPkgPdfK101y_2020_DAO.updateYetaP520001ToPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfK101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfK101y(InfcPkgPdfK101y_2020_VO vo) throws Exception {
        delete("infcPkgPdfK101y_2020_DAO.deletePdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfK101yVO
	 * @return 조회?�� PDF_K101Y
	 * @exception Exception
	 */
    public InfcPkgPdfK101y_2020_VO selectPdfK101y(InfcPkgPdfK101y_2020_VO vo) throws Exception {
        return (InfcPkgPdfK101y_2020_VO) selectByPk("infcPkgPdfK101y_2020_DAO.selectPdfK101y_S", vo);
    }

    /**
	 * PDF_K101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfK101yList(InfcPkgPdfK101ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfK101y_2020_DAO.selectPdfK101yList_D", searchVO);
    }

    /**
	 * PDF_K101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_K101Y �? �??��
	 * @exception
	 */
    public int selectPdfK101yListTotCnt(InfcPkgPdfK101ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfK101y_2020_DAO.selectPdfK101yListTotCnt_S", searchVO);
    }

}
