package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfA102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC301ySrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC301y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfC301y_2018_DAO.java
 * @Description : PdfC301y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfC301y_2018_DAO")
public class InfcPkgPdfC301y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_C301Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfC301yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfC301y(InfcPkgPdfC301y_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfC301y_2018_DAO.insertPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfC301y(InfcPkgPdfC301y_2018_VO vo) throws Exception {
        update("infcPkgPdfC301y_2018_DAO.updatePdfC301y_S", vo);
    }
    
    public void updateYetaP320001ToPdfC301y(InfcPkgPdfC301y_2018_VO vo) throws Exception {
    	update("infcPkgPdfC301y_2018_DAO.updateYetaP320001ToPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfC301yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfC301y(InfcPkgPdfC301y_2018_VO vo) throws Exception {
        delete("infcPkgPdfC301y_2018_DAO.deletePdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfC301yVO
	 * @return 조회?�� PDF_C301Y
	 * @exception Exception
	 */
    public InfcPkgPdfC301y_2018_VO selectPdfC301y(InfcPkgPdfC301y_2018_VO vo) throws Exception {
        return (InfcPkgPdfC301y_2018_VO) selectByPk("infcPkgPdfC301y_2018_DAO.selectPdfC301y_S", vo);
    }

    /**
	 * PDF_C301Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfC301yList(InfcPkgPdfC301ySrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfC301y_2018_DAO.selectPdfC301yList_D", searchVO);
    }

    /**
	 * PDF_C301Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_C301Y �? �??��
	 * @exception
	 */
    public int selectPdfC301yListTotCnt(InfcPkgPdfC301ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfC301y_2018_DAO.selectPdfC301yListTotCnt_S", searchVO);
    }

}
