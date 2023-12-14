package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165020Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165020_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye165020_2023_DAO.java
 * @Description : Ye165020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe165020_2023_DAO")
public class InfcPkgYe165020_2023_DAO extends EgovAbstractDAO {

	@Transactional
    public String PdfYeta8200_L102Y_YE165020_Delete(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception {
           delete("infcPkgYe165020_2023_DAO.PdfYeta8200_L102Y_YE165020_Delete_S", infcPkgYe165020Vo);
           
           return "";
    }	
	@Transactional
    public String PdfYeta8200_L102Y_YE165020_Insert(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception {
        return (String)insert("infcPkgYe165020_2023_DAO.PdfYeta8200_L102Y_YE165020_Insert_S", infcPkgYe165020Vo);
    }
	
	// I_기부자관계코드별기부금합계
	@Transactional
    public String incTaxDeducDec_nts_Yeta2023_Ye165020_Insert(InfcPkgYe165020_2023_VO  infcPkgYe165020Vo) throws Exception {
        return (String)insert("infcPkgYe165020_2023_DAO.incTaxDeducDec_nts_Yeta2023_Ye165020_Insert_S", infcPkgYe165020Vo);
    }
	
	
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/ 
	
	@Transactional
    public int incDdcYeta2023_L102Y_YE165020_Delete(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception {
          
		return delete("infcPkgYe165020_2023_DAO.PdfYeta8200_L102Y_YE165020_Delete_S", infcPkgYe165020Vo);
          
    }
	
	@Transactional
    public String incDdcYeta2023_L102Y_YE165020_Insert(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception {
        return (String)insert("infcPkgYe165020_2023_DAO.PdfYeta8200_L102Y_YE165020_Insert_S", infcPkgYe165020Vo);
    } 
	/**
	 * YE165020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye165020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe165020(InfcPkgYe165020_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe165020_2023_DAO.insertYe165020_S", vo);
    }

    /**
	 * YE165020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe165020(InfcPkgYe165020_2023_VO vo) throws Exception {
        update("infcPkgYe165020_2023_DAO.updateYe165020_S", vo);
    }

    /**
	 * YE165020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye165020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe165020(InfcPkgYe165020_2023_VO vo) throws Exception {
        delete("infcPkgYe165020_2023_DAO.deleteYe165020_S", vo);
    }

    /**
	 * YE165020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye165020VO
	 * @return 조회?�� YE165020
	 * @exception Exception
	 */
    public InfcPkgYe165020_2023_VO selectYe165020(InfcPkgYe165020_2023_VO vo) throws Exception {
        return (InfcPkgYe165020_2023_VO) selectByPk("infcPkgYe165020_2023_DAO.selectYe165020_S", vo);
    }

    /**
	 * YE165020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165020 목록
	 * @exception Exception
	 */
    public List<?> selectYe165020List(InfcPkgYe165020Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe165020_2023_DAO.selectYe165020List_D", searchVO);
    }

    /**
	 * YE165020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE165020 �? �??��
	 * @exception
	 */
    public int selectYe165020ListTotCnt(InfcPkgYe165020Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe165020_2023_DAO.selectYe165020ListTotCnt_S", searchVO);
    }

}
