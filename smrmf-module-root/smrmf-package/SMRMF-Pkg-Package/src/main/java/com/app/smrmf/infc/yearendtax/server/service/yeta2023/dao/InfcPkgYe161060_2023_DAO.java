package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161050_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161055_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161060Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161060_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161070_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161060_2023_DAO.java
 * @Description : Ye161060 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161060_2023_DAO")
public class InfcPkgYe161060_2023_DAO extends EgovAbstractDAO {

	

	@Transactional
	public String fnYeta8100_Ye161060_PAYR_2023_CREATE_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception {
		 return (String)insert("infcPkgYe161060_2023_DAO.fnYeta8100_Ye161060_PAYR_2023_CREATE_Insert_S", yePrc160401Vo);
	 
   }
	
	 
	//주책임차차입금원리금상환액 
	@Transactional
    public String fnYeta8200_J101Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
           update("infcPkgYe161060_2023_DAO.fnYeta8200_J101Y_YE161060_2023_Update_S", infcPkgYe161060Vo);
           
           return "";
    } 
	
	
	//장기주택저당차입금 
	@Transactional
    public String fnYeta8200_J203Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
           update("infcPkgYe161060_2023_DAO.fnYeta8200_J203Y_YE161060_2023_Update_S", infcPkgYe161060Vo);
           
           return "";
    } 
	
	//건강보험  
	@Transactional
    public String fnYeta8200_O101M_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
           update("infcPkgYe161060_2023_DAO.fnYeta8200_O101M_YE161060_2023_Update_S", infcPkgYe161060Vo);
           
           return "";
    } 
	 
	//이월기부금정리   
	@Transactional
    public String fnYeta8200_L102Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
           update("infcPkgYe161060_2023_DAO.fnYeta8200_L102Y_YE161060_2023_Update_S", infcPkgYe161060Vo);
           
           return "";
    } 
 
	// C_특별소득공제
	
	@Transactional
	public String incTaxDeducDec_nts_Yeta2023_Ye161060_Insert(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
		 return (String)insert("infcPkgYe161060_2023_DAO.incTaxDeducDec_nts_Yeta2023_Ye161060_Insert_S", infcPkgYe161060Vo);
	 
   }
	
	 
	
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/ 
	
	//이월기부금정리   
		@Transactional
	    public int incDdcYeta2023_L102Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
			return update("infcPkgYe161060_2023_DAO.fnYeta8200_L102Y_YE161060_2023_Update_S", infcPkgYe161060Vo);
	            
	    } 
		
		@Transactional
	    public int incDdcYeta2023_All_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
			return update("infcPkgYe161060_2023_DAO.incDdcYeta2023_All_YE161060_2023_Update_S", infcPkgYe161060Vo);
	            
	    } 
		 
		
		@Transactional
	    public int incDdcYeta2023_YE161040_2023_INSU_FETC01_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
	        return  update("infcPkgYe161060_2023_DAO.fnYeta8100_YE161060_2023_INSU_FETC01_Update_S", infcPkgYe161060Vo);
	    }
			
		
		
	/**
	 * YE161060?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161060VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161060(InfcPkgYe161060_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe161060_2023_DAO.insertYe161060_S", vo);
    }

    /**
	 * YE161060?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161060VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161060(InfcPkgYe161060_2023_VO vo) throws Exception {
        update("infcPkgYe161060_2023_DAO.updateYe161060_S", vo);
    }

    /**
	 * YE161060?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161060VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161060(InfcPkgYe161060_2023_VO vo) throws Exception {
        delete("infcPkgYe161060_2023_DAO.deleteYe161060_S", vo);
    }

    /**
	 * YE161060?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161060VO
	 * @return 조회?�� YE161060
	 * @exception Exception
	 */
    public InfcPkgYe161060_2023_VO selectYe161060(InfcPkgYe161060_2023_VO vo) throws Exception {
        return (InfcPkgYe161060_2023_VO) selectByPk("infcPkgYe161060_2023_DAO.selectYe161060_S", vo);
    }

    /**
	 * YE161060 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161060 목록
	 * @exception Exception
	 */
    public List<?> selectYe161060List(InfcPkgYe161060Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe161060_2023_DAO.selectYe161060List_D", searchVO);
    }

    /**
	 * YE161060 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161060 �? �??��
	 * @exception
	 */
    public int selectYe161060ListTotCnt(InfcPkgYe161060Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161060_2023_DAO.selectYe161060ListTotCnt_S", searchVO);
    }

}
