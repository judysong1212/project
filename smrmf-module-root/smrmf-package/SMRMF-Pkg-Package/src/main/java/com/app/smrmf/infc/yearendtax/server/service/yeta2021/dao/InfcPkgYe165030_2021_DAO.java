package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165030_2021_DAO.java
 * @Description : Ye165030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe165030_2021_DAO")
public class InfcPkgYe165030_2021_DAO extends EgovAbstractDAO {

	@Transactional
    public String PdfYeta6200_L102Y_YE165030_Delete(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
           delete("infcPkgYe165030_2021_DAO.PdfYeta6200_L102Y_YE165030_Delete_S", infcPkgYe165030Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta6200_L102Y_YE165030_Insert(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
        return (String)insert("infcPkgYe165030_2021_DAO.PdfYeta6200_L102Y_YE165030_Insert_S", infcPkgYe165030Vo);
    }
	
	//H_기부금조정명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2021_Ye165030_Insert(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
        return (String)insert("infcPkgYe165030_2021_DAO.incTaxDeducDec_nts_Yeta2021_Ye165030_Insert_S", infcPkgYe165030Vo);
    }
	
	
	@Transactional
    public String fnYeta6100_YE165030TempYE165030_2021_CREATE_Insert(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
        return (String)insert("infcPkgYe165030_2021_DAO.fnYeta6100_YE165030TempYE165030_2021_CREATE_Insert_S", infcPkgYe165030Vo);
    }
	 
	 
	
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/  
	
	@Transactional
    public int incDdcYeta2021_L102Y_YE165030_Delete(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
		return delete("infcPkgYe165030_2021_DAO.PdfYeta6200_L102Y_YE165030_Delete_S", infcPkgYe165030Vo);
            
    }	
	
	@Transactional
    public String incDdcYeta2021_L102Y_YE165030_Insert(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
        return (String)insert("infcPkgYe165030_2021_DAO.PdfYeta6200_L102Y_YE165030_Insert_S", infcPkgYe165030Vo);
    }
	
	/**
	 * YE165030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165030(InfcPkgYe165030_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe165030_2021_DAO.insertYe165030_S", vo);
    }

    /**
	 * YE165030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165030(InfcPkgYe165030_2021_VO vo) throws Exception {
        update("infcPkgYe165030_2021_DAO.updateYe165030_S", vo);
    }

    /**
	 * YE165030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165030(InfcPkgYe165030_2021_VO vo) throws Exception {
        delete("infcPkgYe165030_2021_DAO.deleteYe165030_S", vo);
    }

    /**
	 * YE165030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165030VO
	 * @return 조회?�� YE165030
	 * @exception Exception
	 */
    public InfcPkgYe165030_2021_VO selectYe165030(InfcPkgYe165030_2021_VO vo) throws Exception {
        return (InfcPkgYe165030_2021_VO) selectByPk("infcPkgYe165030_2021_DAO.selectYe165030_S", vo);
    }

    /**
	 * YE165030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030 목록
	 * @exception Exception
	 */
    public List<?> selectYe165030List(InfcPkgYe165030Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe165030_2021_DAO.selectYe165030List_D", searchVO);
    }

    /**
	 * YE165030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165030 �? �??��
	 * @exception
	 */
    public int selectYe165030ListTotCnt(InfcPkgYe165030Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe165030_2021_DAO.selectYe165030ListTotCnt_S", searchVO);
    }

}
