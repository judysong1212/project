package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102y_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfA102y_2020_DAO.java
 * @Description : PdfA102y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfA102y_2020_DAO")
public class InfcPkgPdfA102y_2020_DAO extends EgovAbstractDAO {
 
	
	/**
	 * PDF_A102Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfA102yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfA102y(InfcPkgPdfA102y_2020_VO vo) throws Exception {
        return (String)insert("infcPkgPdfA102y_2020_DAO.insertPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfA102y(InfcPkgPdfA102y_2020_VO vo) throws Exception {
        update("infcPkgPdfA102y_2020_DAO.updatePdfA102y_S", vo);
    }
    
    public void updateYetaP520001ToPdfA102y(InfcPkgPdfA102y_2020_VO vo) throws Exception {
    	update("infcPkgPdfA102y_2020_DAO.updateYetaP520001ToPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfA102yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfA102y(InfcPkgPdfA102y_2020_VO vo) throws Exception {
        delete("infcPkgPdfA102y_2020_DAO.deletePdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfA102yVO
	 * @return 조회?�� PDF_A102Y
	 * @exception Exception
	 */
    public InfcPkgPdfA102y_2020_VO selectPdfA102y(InfcPkgPdfA102y_2020_VO vo) throws Exception {
        return (InfcPkgPdfA102y_2020_VO) selectByPk("infcPkgPdfA102y_2020_DAO.selectPdfA102y_S", vo);
    }

    /**
	 * PDF_A102Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfA102yList(InfcPkgPdfA102ySrh_2020_VO searchVO) throws Exception {
        return list("infcPkgPdfA102y_2020_DAO.selectPdfA102yList_D", searchVO);
    }

    /**
	 * PDF_A102Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_A102Y �? �??��
	 * @exception
	 */
    public int selectPdfA102yListTotCnt(InfcPkgPdfA102ySrh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfA102y_2020_DAO.selectPdfA102yListTotCnt_S", searchVO);
    }

}
