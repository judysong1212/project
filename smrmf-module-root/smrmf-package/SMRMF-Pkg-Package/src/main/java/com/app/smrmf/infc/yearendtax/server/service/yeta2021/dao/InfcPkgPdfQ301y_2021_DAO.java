package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ301ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ301y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfQ301y_2021_DAO.java
 * @Description : PdfQ301y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfQ301y_2021_DAO")
public class InfcPkgPdfQ301y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_Q301y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfQ301yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfQ301y(InfcPkgPdfQ301y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfQ301y_2021_DAO.insertPdfQ301y_S", vo);
    }

    /**
	 * PDF_Q301y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ301yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfQ301y(InfcPkgPdfQ301y_2021_VO vo) throws Exception {
        update("infcPkgPdfQ301y_2021_DAO.updatePdfQ301y_S", vo);
    }
    
    public void updateYetaP620001ToPdfQ301y(InfcPkgPdfQ301y_2021_VO vo) throws Exception {
    	update("infcPkgPdfQ301y_2021_DAO.updateYetaP620001ToPdfQ301y_S", vo);
    }

    /**
	 * PDF_Q301y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ301yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfQ301y(InfcPkgPdfQ301y_2021_VO vo) throws Exception {
        delete("infcPkgPdfQ301y_2021_DAO.deletePdfQ301y_S", vo);
    }

    /**
	 * PDF_Q301y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfQ301yVO
	 * @return 조회?�� PDF_Q301y
	 * @exception Exception
	 */
    public InfcPkgPdfQ301y_2021_VO selectPdfQ301y(InfcPkgPdfQ301y_2021_VO vo) throws Exception {
        return (InfcPkgPdfQ301y_2021_VO) selectByPk("infcPkgPdfQ301y_2021_DAO.selectPdfQ301y_S", vo);
    }

    /**
	 * PDF_Q301y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q301y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfQ301yList(InfcPkgPdfQ301ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfQ301y_2021_DAO.selectPdfQ301yList_D", searchVO);
    }

    /**
	 * PDF_Q301y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q301y �? �??��
	 * @exception
	 */
    public int selectPdfQ301yListTotCnt(InfcPkgPdfQ301ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfQ301y_2021_DAO.selectPdfQ301yListTotCnt_S", searchVO);
    }

}
