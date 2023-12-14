package com.app.smrmf.infc.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfA102y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfB101ySrh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfB101y_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfB101y_2019_DAO.java
 * @Description : PdfB101y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfB101y_2019_DAO")
public class InfcPkgPdfB101y_2019_DAO extends EgovAbstractDAO {

	/**
	 * PDF_B101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfB101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfB101y(InfcPkgPdfB101y_2019_VO vo) throws Exception {
        return (String)insert("infcPkgPdfB101y_2019_DAO.insertPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfB101y(InfcPkgPdfB101y_2019_VO vo) throws Exception {
        update("infcPkgPdfB101y_2019_DAO.updatePdfB101y_S", vo);
    }
    
    public void updateYetaP420001ToPdfB101y(InfcPkgPdfB101y_2019_VO vo) throws Exception {
    	update("infcPkgPdfB101y_2019_DAO.updateYetaP420001ToPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfB101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfB101y(InfcPkgPdfB101y_2019_VO vo) throws Exception {
        delete("infcPkgPdfB101y_2019_DAO.deletePdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfB101yVO
	 * @return 조회?�� PDF_B101Y
	 * @exception Exception
	 */
    public InfcPkgPdfB101y_2019_VO selectPdfB101y(InfcPkgPdfB101y_2019_VO vo) throws Exception {
        return (InfcPkgPdfB101y_2019_VO) selectByPk("infcPkgPdfB101y_2019_DAO.selectPdfB101y_S", vo);
    }

    /**
	 * PDF_B101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfB101yList(InfcPkgPdfB101ySrh_2019_VO searchVO) throws Exception {
        return list("infcPkgPdfB101y_2019_DAO.selectPdfB101yList_D", searchVO);
    }

    /**
	 * PDF_B101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_B101Y �? �??��
	 * @exception
	 */
    public int selectPdfB101yListTotCnt(InfcPkgPdfB101ySrh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfB101y_2019_DAO.selectPdfB101yListTotCnt_S", searchVO);
    }

}
