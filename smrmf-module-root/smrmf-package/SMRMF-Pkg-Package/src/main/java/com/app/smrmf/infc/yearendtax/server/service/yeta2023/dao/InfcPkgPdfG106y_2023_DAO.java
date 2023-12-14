package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfA102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG106ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG106y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG106y_2023_DAO.java
 * @Description : PdfG106y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG106y_2023_DAO")
public class InfcPkgPdfG106y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G106Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG106yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfG106y(InfcPkgPdfG106y_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG106y_2023_DAO.insertPdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG106yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG106y(InfcPkgPdfG106y_2023_VO vo) throws Exception {
        update("infcPkgPdfG106y_2023_DAO.updatePdfG106y_S", vo);
    }
    
    public void updateYetaP820001ToPdfG106y(InfcPkgPdfG106y_2023_VO vo) throws Exception {
    	update("infcPkgPdfG106y_2023_DAO.updateYetaP820001ToPdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG106yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG106y(InfcPkgPdfG106y_2023_VO vo) throws Exception {
        delete("infcPkgPdfG106y_2023_DAO.deletePdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG106yVO
	 * @return 조회?�� PDF_G106Y
	 * @exception Exception
	 */
    public InfcPkgPdfG106y_2023_VO selectPdfG106y(InfcPkgPdfG106y_2023_VO vo) throws Exception {
        return (InfcPkgPdfG106y_2023_VO) selectByPk("infcPkgPdfG106y_2023_DAO.selectPdfG106y_S", vo);
    }

    /**
	 * PDF_G106Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG106yList(InfcPkgPdfG106ySrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG106y_2023_DAO.selectPdfG106yList_D", searchVO);
    }

    /**
	 * PDF_G106Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G106Y �? �??��
	 * @exception
	 */
    public int selectPdfG106yListTotCnt(InfcPkgPdfG106ySrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG106y_2023_DAO.selectPdfG106yListTotCnt_S", searchVO);
    }

}
