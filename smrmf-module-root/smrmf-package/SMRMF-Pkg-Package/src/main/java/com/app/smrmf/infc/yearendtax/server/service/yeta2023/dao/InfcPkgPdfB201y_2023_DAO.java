package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB201y_2023_DAO.java
 * @Description : PdfB201y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfB201y_2023_DAO")
public class InfcPkgPdfB201y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_B201y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB201yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB201y(InfcPkgPdfB201y_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfB201y_2023_DAO.insertPdfB201y_S", vo);
    }

    /**
	 * PDF_B201y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB201yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB201y(InfcPkgPdfB201y_2023_VO vo) throws Exception {
        update("infcPkgPdfB201y_2023_DAO.updatePdfB201y_S", vo);
    }
    
    public void updateYetaP820001ToPdfB201y(InfcPkgPdfB201y_2023_VO vo) throws Exception {
    	update("infcPkgPdfB201y_2023_DAO.updateYetaP820001ToPdfB201y_S", vo);
    }

    /**
	 * PDF_B201y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB201yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB201y(InfcPkgPdfB201y_2023_VO vo) throws Exception {
        delete("infcPkgPdfB201y_2023_DAO.deletePdfB201y_S", vo);
    }

    /**
	 * PDF_B201y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB201yVO
	 * @return 조회?�� PDF_B201y
	 * @exception Exception
	 */
    public InfcPkgPdfB201y_2023_VO selectPdfB201y(InfcPkgPdfB201y_2023_VO vo) throws Exception {
        return (InfcPkgPdfB201y_2023_VO) selectByPk("infcPkgPdfB201y_2023_DAO.selectPdfB201y_S", vo);
    }

    /**
	 * PDF_B201y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B201y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB201yList(InfcPkgPdfB201ySrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfB201y_2023_DAO.selectPdfB201yList_D", searchVO);
    }

    /**
	 * PDF_B201y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B201y �? �??��
	 * @exception
	 */
    public int selectPdfB201yListTotCnt(InfcPkgPdfB201ySrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfB201y_2023_DAO.selectPdfB201yListTotCnt_S", searchVO);
    }

}
