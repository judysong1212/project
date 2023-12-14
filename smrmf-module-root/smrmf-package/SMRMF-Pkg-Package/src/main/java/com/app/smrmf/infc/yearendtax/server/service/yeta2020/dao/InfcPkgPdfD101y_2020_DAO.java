package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfD101ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfD101y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfD101y_2020_DAO.java
 * @Description : PdfD101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfD101y_2020_DAO")
public class InfcPkgPdfD101y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_D101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfD101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfD101y(InfcPkgPdfD101y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfD101y_2020_DAO.insertPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfD101y(InfcPkgPdfD101y_2020_VO vo) throws Exception {
        update("infcPkgPdfD101y_2020_DAO.updatePdfD101y_S", vo);
    }
    
    public void updateYetaP520001ToPdfD101y(InfcPkgPdfD101y_2020_VO vo) throws Exception {
    	update("infcPkgPdfD101y_2020_DAO.updateYetaP520001ToPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfD101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfD101y(InfcPkgPdfD101y_2020_VO vo) throws Exception {
        delete("infcPkgPdfD101y_2020_DAO.deletePdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfD101yVO
	 * @return 조회?�� PDF_D101Y
	 * @exception Exception
	 */
    public InfcPkgPdfD101y_2020_VO selectPdfD101y(InfcPkgPdfD101y_2020_VO vo) throws Exception {
        return (InfcPkgPdfD101y_2020_VO) selectByPk("infcPkgPdfD101y_2020_DAO.selectPdfD101y_S", vo);
    }

    /**
	 * PDF_D101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfD101yList(InfcPkgPdfD101ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfD101y_2020_DAO.selectPdfD101yList_D", searchVO);
    }

    /**
	 * PDF_D101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_D101Y �? �??��
	 * @exception
	 */
    public int selectPdfD101yListTotCnt(InfcPkgPdfD101ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfD101y_2020_DAO.selectPdfD101yListTotCnt_S", searchVO);
    }

}
