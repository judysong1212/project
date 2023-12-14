package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfA102y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG306ySrh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfG306y_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG306y_2023_DAO.java
 * @Description : PdfG306y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG306y_2023_DAO")
public class InfcPkgPdfG306y_2023_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG306yVO
	 * @return ?���? 결과	
	 * @exception Exception
	 */
    public String insertPdfG306y(InfcPkgPdfG306y_2023_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG306y_2023_DAO.insertPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG306y(InfcPkgPdfG306y_2023_VO vo) throws Exception {
        update("infcPkgPdfG306y_2023_DAO.updatePdfG306y_S", vo);
    }
    
    public void updateYetaP820001ToPdfG306y(InfcPkgPdfG306y_2023_VO vo) throws Exception {
    	update("infcPkgPdfG306y_2023_DAO.updateYetaP820001ToPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG306y(InfcPkgPdfG306y_2023_VO vo) throws Exception {
        delete("infcPkgPdfG306y_2023_DAO.deletePdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG306yVO
	 * @return 조회?�� PDF_G306Y
	 * @exception Exception
	 */
    public InfcPkgPdfG306y_2023_VO selectPdfG306y(InfcPkgPdfG306y_2023_VO vo) throws Exception {
        return (InfcPkgPdfG306y_2023_VO) selectByPk("infcPkgPdfG306y_2023_DAO.selectPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG306yList(InfcPkgPdfG306ySrh_2023_VO searchVO) throws Exception {
        return list("infcPkgPdfG306y_2023_DAO.selectPdfG306yList_D", searchVO);
    }

    /**
	 * PDF_G306Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y �? �??��
	 * @exception
	 */
    public int selectPdfG306yListTotCnt(InfcPkgPdfG306ySrh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG306y_2023_DAO.selectPdfG306yListTotCnt_S", searchVO);
    }

}
