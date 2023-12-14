package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfA102y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG306ySrh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG306y_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfG306y_2022_DAO.java
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

@Repository("InfcPkgPdfG306y_2022_DAO")
public class InfcPkgPdfG306y_2022_DAO extends EgovAbstractDAO {

	/**
	 * PDF_G306Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfG306yVO
	 * @return ?���? 결과	
	 * @exception Exception
	 */
    public String insertPdfG306y(InfcPkgPdfG306y_2022_VO vo) throws Exception {
        return (String)insert("infcPkgPdfG306y_2022_DAO.insertPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfG306y(InfcPkgPdfG306y_2022_VO vo) throws Exception {
        update("infcPkgPdfG306y_2022_DAO.updatePdfG306y_S", vo);
    }
    
    public void updateYetaP720001ToPdfG306y(InfcPkgPdfG306y_2022_VO vo) throws Exception {
    	update("infcPkgPdfG306y_2022_DAO.updateYetaP720001ToPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfG306yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfG306y(InfcPkgPdfG306y_2022_VO vo) throws Exception {
        delete("infcPkgPdfG306y_2022_DAO.deletePdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfG306yVO
	 * @return 조회?�� PDF_G306Y
	 * @exception Exception
	 */
    public InfcPkgPdfG306y_2022_VO selectPdfG306y(InfcPkgPdfG306y_2022_VO vo) throws Exception {
        return (InfcPkgPdfG306y_2022_VO) selectByPk("infcPkgPdfG306y_2022_DAO.selectPdfG306y_S", vo);
    }

    /**
	 * PDF_G306Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfG306yList(InfcPkgPdfG306ySrh_2022_VO searchVO) throws Exception {
        return list("infcPkgPdfG306y_2022_DAO.selectPdfG306yList_D", searchVO);
    }

    /**
	 * PDF_G306Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_G306Y �? �??��
	 * @exception
	 */
    public int selectPdfG306yListTotCnt(InfcPkgPdfG306ySrh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfG306y_2022_DAO.selectPdfG306yListTotCnt_S", searchVO);
    }

}
