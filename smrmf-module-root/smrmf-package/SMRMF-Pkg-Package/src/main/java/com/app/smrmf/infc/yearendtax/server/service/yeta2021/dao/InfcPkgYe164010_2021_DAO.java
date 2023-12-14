package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe164010Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe164010_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye164010_2021_DAO.java
 * @Description : Ye164010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe164010_2021_DAO")
public class InfcPkgYe164010_2021_DAO extends EgovAbstractDAO {

	
	
	//의료비 
	@Transactional
    public String PdfYeta6200_B101Y_YE164010_Insert(InfcPkgYe164010_2021_VO infcPkgYe164010Vo) throws Exception {
        return (String)insert("infcPkgYe164010_2021_DAO.PdfYeta6200_B101Y_YE164010_Insert_S", infcPkgYe164010Vo);
    }
	
	
	@Transactional
    public String PdfYeta6200_B101Y_YE164010_Delete(InfcPkgYe164010_2021_VO infcPkgYe164010Vo) throws Exception {
           delete("infcPkgYe164010_2021_DAO.PdfYeta6200_B101Y_YE164010_Delete_S", infcPkgYe164010Vo);
           
           return "";
    }
	
	
	//A_의료비지급명세
	@Transactional
    public String incTaxDeducDec_nts_Yeta2021_Ye164010_Insert(InfcPkgYe164010_2021_VO  infcPkgYe164010Vo) throws Exception {
        return (String)insert("infcPkgYe164010_2021_DAO.incTaxDeducDec_nts_Yeta2021_Ye164010_Insert_S", infcPkgYe164010Vo);
    }
	
	 
	/**
	 * YE164010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye164010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe164010(InfcPkgYe164010_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe164010_2021_DAO.insertYe164010_S", vo);
    }

    /**
	 * YE164010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye164010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe164010(InfcPkgYe164010_2021_VO vo) throws Exception {
        update("infcPkgYe164010_2021_DAO.updateYe164010_S", vo);
    }

    /**
	 * YE164010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye164010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe164010(InfcPkgYe164010_2021_VO vo) throws Exception {
        delete("infcPkgYe164010_2021_DAO.deleteYe164010_S", vo);
    }

    /**
	 * YE164010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye164010VO
	 * @return 조회?�� YE164010
	 * @exception Exception
	 */
    public InfcPkgYe164010_2021_VO selectYe164010(InfcPkgYe164010_2021_VO vo) throws Exception {
        return (InfcPkgYe164010_2021_VO) selectByPk("infcPkgYe164010_2021_DAO.selectYe164010_S", vo);
    }

    /**
	 * YE164010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE164010 목록
	 * @exception Exception
	 */
    public List<?> selectYe164010List(InfcPkgYe164010Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe164010_2021_DAO.selectYe164010List_D", searchVO);
    }

    /**
	 * YE164010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE164010 �? �??��
	 * @exception
	 */
    public int selectYe164010ListTotCnt(InfcPkgYe164010Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe164010_2021_DAO.selectYe164010ListTotCnt_S", searchVO);
    }

}
