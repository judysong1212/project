package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407ySrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG407y_2022_DAO.java
 * @Description : PdfG407y DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPdfG407y_2022_DAO")
public class InfcPkgPdfG407y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG407yVO
	 * @return ?���? 결과	
	 * @exception Exception
	 */
    public String insertPdfG407y(InfcPkgPdfG407y_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG407y_2022_DAO.insertPdfG407y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG407yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG407y(InfcPkgPdfG407y_2022_VO vo) throws Exception {
        update("infcPkgPdfG407y_2022_DAO.updatePdfG407y_S", vo);
    }
    
    public void updateYetaP720001ToPdfG407y(InfcPkgPdfG407y_2022_VO vo) throws Exception {
    	update("infcPkgPdfG407y_2022_DAO.updateYetaP720001ToPdfG407y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG407yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG407y(InfcPkgPdfG407y_2022_VO vo) throws Exception {
        delete("infcPkgPdfG407y_2022_DAO.deletePdfG407y_S", vo);
    }

    /**
	 * PDF_G306Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG407yVO
	 * @return 조회?�� PDF_G306Y
	 * @exception Exception
	 */
    public InfcPkgPdfG407y_2022_VO selectPdfG407y(InfcPkgPdfG407y_2022_VO vo) throws Exception {
        return (InfcPkgPdfG407y_2022_VO) selectByPk("infcPkgPdfG407y_2022_DAO.selectPdfG407y_S", vo);
    }

    /**
	 * PDF_G306Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG407yList(InfcPkgPdfG407ySrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfG407y_2022_DAO.selectPdfG407yList_D", searchVO);
    }

    /**
	 * PDF_G306Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y �? �??��
	 * @exception
	 */
    public int selectPdfG407yListTotCnt(InfcPkgPdfG407ySrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG407y_2022_DAO.selectPdfG407yListTotCnt_S", searchVO);
    }

}
