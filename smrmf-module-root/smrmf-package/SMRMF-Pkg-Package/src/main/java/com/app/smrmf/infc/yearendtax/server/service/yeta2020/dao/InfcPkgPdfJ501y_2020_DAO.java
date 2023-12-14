package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ501ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ501y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ501y_2020_DAO.java
 * @Description : PdfJ501y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ501y_2020_DAO")
public class InfcPkgPdfJ501y_2020_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J501y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ501yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ501y(InfcPkgPdfJ501y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ501y_2020_DAO.insertPdfJ501y_S", vo);
    }

    /**
	 * PDF_J501y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ501yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ501y(InfcPkgPdfJ501y_2020_VO vo) throws Exception {
        update("infcPkgPdfJ501y_2020_DAO.updatePdfJ501y_S", vo);
    }
    
    public void updateYetaP520001ToPdfJ501y(InfcPkgPdfJ501y_2020_VO vo) throws Exception {
    	update("infcPkgPdfJ501y_2020_DAO.updateYetaP520001ToPdfJ501y_S", vo);
    }

    /**
	 * PDF_J501y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ501yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ501y(InfcPkgPdfJ501y_2020_VO vo) throws Exception {
        delete("infcPkgPdfJ501y_2020_DAO.deletePdfJ501y_S", vo);
    }

    /**
	 * PDF_J501y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ501yVO
	 * @return 조회?�� PDF_J501y
	 * @exception Exception
	 */
    public InfcPkgPdfJ501y_2020_VO selectPdfJ501y(InfcPkgPdfJ501y_2020_VO vo) throws Exception {
        return (InfcPkgPdfJ501y_2020_VO) selectByPk("infcPkgPdfJ501y_2020_DAO.selectPdfJ501y_S", vo);
    }

    /**
	 * PDF_J501y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J501y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ501yList(InfcPkgPdfJ501ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfJ501y_2020_DAO.selectPdfJ501yList_D", searchVO);
    }

    /**
	 * PDF_J501y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J501y �? �??��
	 * @exception
	 */
    public int selectPdfJ501yListTotCnt(InfcPkgPdfJ501ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ501y_2020_DAO.selectPdfJ501yListTotCnt_S", searchVO);
    }

}
