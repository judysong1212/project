package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG306yDAO.java
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

@Repository("InfcPkgPdfG306yDAO")
public class InfcPkgPdfG306yDAO extends EgovAbstractDAO {

	/**
	 * PDF_G306Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG306yVO
	 * @return ?���? 결과	
	 * @exception Exception
	 */
    public String insertPdfG306y(InfcPkgPdfG306yVO vo) throws Exception {
        return (String)insert("infcPkgPdfG306yDAO.insertPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG306y(InfcPkgPdfG306yVO vo) throws Exception {
        update("infcPkgPdfG306yDAO.updatePdfG306y_S", vo);
    }
    
    public void updateYetaP220001ToPdfG306y(InfcPkgPdfG306yVO vo) throws Exception {
    	update("infcPkgPdfG306yDAO.updateYetaP220001ToPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG306y(InfcPkgPdfG306yVO vo) throws Exception {
        delete("infcPkgPdfG306yDAO.deletePdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG306yVO
	 * @return 조회?�� PDF_G306Y
	 * @exception Exception
	 */
    public InfcPkgPdfG306yVO selectPdfG306y(InfcPkgPdfG306yVO vo) throws Exception {
        return (InfcPkgPdfG306yVO) selectByPk("infcPkgPdfG306yDAO.selectPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG306yList(InfcPkgPdfG306ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfG306yDAO.selectPdfG306yList_D", searchVO);
    }

    /**
	 * PDF_G306Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y �? �??��
	 * @exception
	 */
    public int selectPdfG306yListTotCnt(InfcPkgPdfG306ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG306yDAO.selectPdfG306yListTotCnt_S", searchVO);
    }

}
