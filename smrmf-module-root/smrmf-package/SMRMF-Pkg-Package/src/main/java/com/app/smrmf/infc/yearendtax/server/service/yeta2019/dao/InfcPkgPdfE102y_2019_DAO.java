package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfA102y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfE102ySrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfE102y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfE102y_2019_DAO.java
 * @Description : PdfE102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfE102y_2019_DAO")
public class InfcPkgPdfE102y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_E102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfE102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfE102y(InfcPkgPdfE102y_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfE102y_2019_DAO.insertPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfE102y(InfcPkgPdfE102y_2019_VO vo) throws Exception {
        update("infcPkgPdfE102y_2019_DAO.updatePdfE102y_S", vo);
    }
    
    public void updateYetaP420001ToPdfE102y(InfcPkgPdfE102y_2019_VO vo) throws Exception {
    	update("infcPkgPdfE102y_2019_DAO.updateYetaP420001ToPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfE102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfE102y(InfcPkgPdfE102y_2019_VO vo) throws Exception {
        delete("infcPkgPdfE102y_2019_DAO.deletePdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfE102yVO
	 * @return 조회?�� PDF_E102Y
	 * @exception Exception
	 */
    public InfcPkgPdfE102y_2019_VO selectPdfE102y(InfcPkgPdfE102y_2019_VO vo) throws Exception {
        return (InfcPkgPdfE102y_2019_VO) selectByPk("infcPkgPdfE102y_2019_DAO.selectPdfE102y_S", vo);
    }

    /**
	 * PDF_E102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfE102yList(InfcPkgPdfE102ySrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfE102y_2019_DAO.selectPdfE102yList_D", searchVO);
    }

    /**
	 * PDF_E102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_E102Y �? �??��
	 * @exception
	 */
    public int selectPdfE102yListTotCnt(InfcPkgPdfE102ySrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfE102y_2019_DAO.selectPdfE102yListTotCnt_S", searchVO);
    }

}
