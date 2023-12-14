package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101yVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101yDAO.java
 * @Description : PdfO101y DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfO101yDAO")
public class InfcPkgPdfO101yDAO extends EgovAbstractDAO {

	/**
	 * PDF_O101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101y(InfcPkgPdfO101yVO vo) throws Exception {
        return (String)insert("infcPkgPdfO101yDAO.insertPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101y(InfcPkgPdfO101yVO vo) throws Exception {
        update("infcPkgPdfO101yDAO.updatePdfO101y_S", vo);
    }
    
    public void updateYetaP220001ToPdfO101y(InfcPkgPdfO101yVO vo) throws Exception {
    	update("infcPkgPdfO101yDAO.updateYetaP220001ToPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101y(InfcPkgPdfO101yVO vo) throws Exception {
        delete("infcPkgPdfO101yDAO.deletePdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101yVO
	 * @return 조회?�� PDF_O101Y
	 * @exception Exception
	 */
    public InfcPkgPdfO101yVO selectPdfO101y(InfcPkgPdfO101yVO vo) throws Exception {
        return (InfcPkgPdfO101yVO) selectByPk("infcPkgPdfO101yDAO.selectPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101yList(InfcPkgPdfO101ySrhVO searchVO) throws Exception {
        return list("infcPkgPdfO101yDAO.selectPdfO101yList_D", searchVO);
    }

    /**
	 * PDF_O101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y �? �??��
	 * @exception
	 */
    public int selectPdfO101yListTotCnt(InfcPkgPdfO101ySrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfO101yDAO.selectPdfO101yListTotCnt_S", searchVO);
    }

}
