package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfQ101ySrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfQ101y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfQ101y_2022_DAO.java
 * @Description : PdfQ101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfQ101y_2022_DAO")
public class InfcPkgPdfQ101y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_Q101y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfQ101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfQ101y(InfcPkgPdfQ101y_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfQ101y_2022_DAO.insertPdfQ101y_S", vo);
    }

    /**
	 * PDF_Q101y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfQ101y(InfcPkgPdfQ101y_2022_VO vo) throws Exception {
        update("infcPkgPdfQ101y_2022_DAO.updatePdfQ101y_S", vo);
    }
    
    public void updateYetaP720001ToPdfQ101y(InfcPkgPdfQ101y_2022_VO vo) throws Exception {
    	update("infcPkgPdfQ101y_2022_DAO.updateYetaP720001ToPdfQ101y_S", vo);
    }

    /**
	 * PDF_Q101y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfQ101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfQ101y(InfcPkgPdfQ101y_2022_VO vo) throws Exception {
        delete("infcPkgPdfQ101y_2022_DAO.deletePdfQ101y_S", vo);
    }

    /**
	 * PDF_Q101y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfQ101yVO
	 * @return 조회?�� PDF_Q101y
	 * @exception Exception
	 */
    public InfcPkgPdfQ101y_2022_VO selectPdfQ101y(InfcPkgPdfQ101y_2022_VO vo) throws Exception {
        return (InfcPkgPdfQ101y_2022_VO) selectByPk("infcPkgPdfQ101y_2022_DAO.selectPdfQ101y_S", vo);
    }

    /**
	 * PDF_Q101y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q101y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfQ101yList(InfcPkgPdfQ101ySrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfQ101y_2022_DAO.selectPdfQ101yList_D", searchVO);
    }

    /**
	 * PDF_Q101y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_Q101y �? �??��
	 * @exception
	 */
    public int selectPdfQ101yListTotCnt(InfcPkgPdfQ101ySrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfQ101y_2022_DAO.selectPdfQ101yListTotCnt_S", searchVO);
    }

}
