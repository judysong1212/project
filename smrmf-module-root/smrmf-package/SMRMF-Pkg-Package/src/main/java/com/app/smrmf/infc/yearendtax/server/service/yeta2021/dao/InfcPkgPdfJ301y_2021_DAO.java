package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ301ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ301y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfJ301y_2021_DAO.java
 * @Description : PdfJ301y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfJ301y_2021_DAO")
public class InfcPkgPdfJ301y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_J301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfJ301yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfJ301y(InfcPkgPdfJ301y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfJ301y_2021_DAO.insertPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfJ301y(InfcPkgPdfJ301y_2021_VO vo) throws Exception {
        update("infcPkgPdfJ301y_2021_DAO.updatePdfJ301y_S", vo);
    }
    
    public void updateYetaP620001ToPdfJ301y(InfcPkgPdfJ301y_2021_VO vo) throws Exception {
    	update("infcPkgPdfJ301y_2021_DAO.updateYetaP620001ToPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfJ301yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfJ301y(InfcPkgPdfJ301y_2021_VO vo) throws Exception {
        delete("infcPkgPdfJ301y_2021_DAO.deletePdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfJ301yVO
	 * @return 조회?�� PDF_J301Y
	 * @exception Exception
	 */
    public InfcPkgPdfJ301y_2021_VO selectPdfJ301y(InfcPkgPdfJ301y_2021_VO vo) throws Exception {
        return (InfcPkgPdfJ301y_2021_VO) selectByPk("infcPkgPdfJ301y_2021_DAO.selectPdfJ301y_S", vo);
    }

    /**
	 * PDF_J301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfJ301yList(InfcPkgPdfJ301ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfJ301y_2021_DAO.selectPdfJ301yList_D", searchVO);
    }

    /**
	 * PDF_J301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_J301Y �? �??��
	 * @exception
	 */
    public int selectPdfJ301yListTotCnt(InfcPkgPdfJ301ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfJ301y_2021_DAO.selectPdfJ301yListTotCnt_S", searchVO);
    }

}
