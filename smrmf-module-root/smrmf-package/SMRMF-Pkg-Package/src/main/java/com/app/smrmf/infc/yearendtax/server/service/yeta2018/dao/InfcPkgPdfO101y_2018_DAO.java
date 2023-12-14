package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfA102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfO101ySrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfO101y_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PdfO101y_2018_DAO.java
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

@Repository("InfcPkgPdfO101y_2018_DAO")
public class InfcPkgPdfO101y_2018_DAO extends EgovAbstractDAO {

	/**
	 * PDF_O101Y?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? PdfO101yVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertPdfO101y(InfcPkgPdfO101y_2018_VO vo) throws Exception {
        return (String)insert("infcPkgPdfO101y_2018_DAO.insertPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101yVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updatePdfO101y(InfcPkgPdfO101y_2018_VO vo) throws Exception {
        update("infcPkgPdfO101y_2018_DAO.updatePdfO101y_S", vo);
    }
    
    public void updateYetaP320001ToPdfO101y(InfcPkgPdfO101y_2018_VO vo) throws Exception {
    	update("infcPkgPdfO101y_2018_DAO.updateYetaP320001ToPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? PdfO101yVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deletePdfO101y(InfcPkgPdfO101y_2018_VO vo) throws Exception {
        delete("infcPkgPdfO101y_2018_DAO.deletePdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? PdfO101yVO
	 * @return 조회?�� PDF_O101Y
	 * @exception Exception
	 */
    public InfcPkgPdfO101y_2018_VO selectPdfO101y(InfcPkgPdfO101y_2018_VO vo) throws Exception {
        return (InfcPkgPdfO101y_2018_VO) selectByPk("infcPkgPdfO101y_2018_DAO.selectPdfO101y_S", vo);
    }

    /**
	 * PDF_O101Y 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y 목록
	 * @exception Exception
	 */
    public List<?> selectPdfO101yList(InfcPkgPdfO101ySrh_2018_VO searchVO) throws Exception {
        return list("infcPkgPdfO101y_2018_DAO.selectPdfO101yList_D", searchVO);
    }

    /**
	 * PDF_O101Y �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return PDF_O101Y �? �??��
	 * @exception
	 */
    public int selectPdfO101yListTotCnt(InfcPkgPdfO101ySrh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPdfO101y_2018_DAO.selectPdfO101yListTotCnt_S", searchVO);
    }

}
