package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfN101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfN101y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfN101y_2021_DAO.java
 * @Description : PdfN101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfN101y_2021_DAO")
public class InfcPkgPdfN101y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_N101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfN101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfN101y(InfcPkgPdfN101y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfN101y_2021_DAO.insertPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfN101y(InfcPkgPdfN101y_2021_VO vo) throws Exception {
        update("infcPkgPdfN101y_2021_DAO.updatePdfN101y_S", vo);
    }
    
    public void updateYetaP620001ToPdfN101y(InfcPkgPdfN101y_2021_VO vo) throws Exception {
    	update("infcPkgPdfN101y_2021_DAO.updateYetaP620001ToPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfN101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfN101y(InfcPkgPdfN101y_2021_VO vo) throws Exception {
        delete("infcPkgPdfN101y_2021_DAO.deletePdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfN101yVO
	 * @return 조회?�� PDF_N101Y
	 * @exception Exception
	 */
    public InfcPkgPdfN101y_2021_VO selectPdfN101y(InfcPkgPdfN101y_2021_VO vo) throws Exception {
        return (InfcPkgPdfN101y_2021_VO) selectByPk("infcPkgPdfN101y_2021_DAO.selectPdfN101y_S", vo);
    }

    /**
	 * PDF_N101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfN101yList(InfcPkgPdfN101ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfN101y_2021_DAO.selectPdfN101yList_D", searchVO);
    }

    /**
	 * PDF_N101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_N101Y �? �??��
	 * @exception
	 */
    public int selectPdfN101yListTotCnt(InfcPkgPdfN101ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfN101y_2021_DAO.selectPdfN101yListTotCnt_S", searchVO);
    }

}
