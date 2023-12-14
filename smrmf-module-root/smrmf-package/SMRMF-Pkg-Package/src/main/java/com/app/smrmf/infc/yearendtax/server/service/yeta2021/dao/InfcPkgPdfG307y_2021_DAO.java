package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG307ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG307y_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG307y_2021_DAO.java
 * @Description : PdfG307y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG307y_2021_DAO")
public class InfcPkgPdfG307y_2021_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG307yVO
	 * @return ?���? 결과	
	 * @exception Exception
	 */
    public String insertPdfG307y(InfcPkgPdfG307y_2021_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG307y_2021_DAO.insertPdfG307y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG307yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG307y(InfcPkgPdfG307y_2021_VO vo) throws Exception {
        update("infcPkgPdfG307y_2021_DAO.updatePdfG307y_S", vo);
    }
    
    public void updateYetaP620001ToPdfG307y(InfcPkgPdfG307y_2021_VO vo) throws Exception {
    	update("infcPkgPdfG307y_2021_DAO.updateYetaP620001ToPdfG307y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG307yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG307y(InfcPkgPdfG307y_2021_VO vo) throws Exception {
        delete("infcPkgPdfG307y_2021_DAO.deletePdfG307y_S", vo);
    }

    /**
	 * PDF_G306Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG307yVO
	 * @return 조회?�� PDF_G306Y
	 * @exception Exception
	 */
    public InfcPkgPdfG307y_2021_VO selectPdfG307y(InfcPkgPdfG307y_2021_VO vo) throws Exception {
        return (InfcPkgPdfG307y_2021_VO) selectByPk("infcPkgPdfG307y_2021_DAO.selectPdfG307y_S", vo);
    }

    /**
	 * PDF_G306Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG307yList(InfcPkgPdfG307ySrh_2021_VO searchVO) throws Exception {
        return list("infcPkgPdfG307y_2021_DAO.selectPdfG307yList_D", searchVO);
    }

    /**
	 * PDF_G306Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y �? �??��
	 * @exception
	 */
    public int selectPdfG307yListTotCnt(InfcPkgPdfG307ySrh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG307y_2021_DAO.selectPdfG307yListTotCnt_S", searchVO);
    }

}
