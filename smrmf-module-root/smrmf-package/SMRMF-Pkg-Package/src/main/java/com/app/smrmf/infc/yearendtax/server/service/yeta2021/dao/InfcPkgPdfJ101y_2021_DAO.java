package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ101y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ101y_2021_DAO.java
 * @Description : PdfJ101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ101y_2021_DAO")
public class InfcPkgPdfJ101y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ101y(InfcPkgPdfJ101y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ101y_2021_DAO.insertPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ101y(InfcPkgPdfJ101y_2021_VO vo) throws Exception {
        update("infcPkgPdfJ101y_2021_DAO.updatePdfJ101y_S", vo);
    }
    
    public void updateYetaP620001ToPdfJ101y(InfcPkgPdfJ101y_2021_VO vo) throws Exception {
    	update("infcPkgPdfJ101y_2021_DAO.updateYetaP620001ToPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ101y(InfcPkgPdfJ101y_2021_VO vo) throws Exception {
        delete("infcPkgPdfJ101y_2021_DAO.deletePdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ101yVO
	 * @return 조회?�� PDF_J101Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ101y_2021_VO selectPdfJ101y(InfcPkgPdfJ101y_2021_VO vo) throws Exception {
        return (InfcPkgPdfJ101y_2021_VO) selectByPk("infcPkgPdfJ101y_2021_DAO.selectPdfJ101y_S", vo);
    }

    /**
	 * PDF_J101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ101yList(InfcPkgPdfJ101ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfJ101y_2021_DAO.selectPdfJ101yList_D", searchVO);
    }

    /**
	 * PDF_J101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J101Y �? �??��
	 * @exception
	 */
    public int selectPdfJ101yListTotCnt(InfcPkgPdfJ101ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ101y_2021_DAO.selectPdfJ101yListTotCnt_S", searchVO);
    }

}
