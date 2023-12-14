package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161080Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161080_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161080_2018_DAO.java
 * @Description : Ye161080 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161080_2018_DAO")
public class InfcPkgYe161080_2018_DAO extends EgovAbstractDAO {
 

	@Transactional
    public String fnYeta3100_YE161080_2018_CREATE_Insert(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
        return (String)insert("infcPkgYe161080_2018_DAO.fnYeta3100_YE161080_2018_CREATE_Insert_S", infcPkgYe161080Vo);
    }
	
	
	@Transactional
    public String fnYeta3200_A102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
           update("infcPkgYe161080_2018_DAO.fnYeta3200_A102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
           
           return "";
    }
	
	//교육비합계금액 
	@Transactional
    public String fnYeta3200_C101Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
           update("infcPkgYe161080_2018_DAO.fnYeta3200_C101Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
           
           return "";
    }
	
	 
	//연금저축 
	@Transactional
    public String fnYeta3200_E102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
           update("infcPkgYe161080_2018_DAO.fnYeta3200_E102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
           
           return "";
    }
	  
	//퇴직연금  
	@Transactional
    public String fnYeta3200_F102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
           update("infcPkgYe161080_2018_DAO.fnYeta3200_F102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
           
           return "";
    }
	 
	//기부금액  
	@Transactional
    public int fnYeta3200_L102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		
		return update("infcPkgYe161080_2018_DAO.fnYeta3200_L102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
       
    }
 
	// 의료비정리 합계
	@Transactional
    public int  fnYeta3200_B101Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		return update("infcPkgYe161080_2018_DAO.fnYeta3200_B101Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
           
            
    }
	
	// C_세액감면및공제
	@Transactional
    public String incTaxDeducDec_nts_Yeta2018_Ye161080_Insert(InfcPkgYe161080_2018_VO     infcPkgYe161080Vo) throws Exception {
        return (String)insert("infcPkgYe161080_2018_DAO.incTaxDeducDec_nts_Yeta2018_Ye161080_Insert_S", infcPkgYe161080Vo);
    }
	
	@Transactional
    public String incTaxDeducDec_nts_Yeta2018_Ye161080_Insert_01(InfcPkgYe161080_2018_VO     infcPkgYe161080Vo) throws Exception {
        return (String)insert("infcPkgYe161080_2018_DAO.incTaxDeducDec_nts_Yeta2018_Ye161080_Insert_01_S", infcPkgYe161080Vo);
    }
		 
	
		/********************************************************************************************************
		 * 소득공제관리화면에서처리 하는부분 
		 ********************************************************************************************************/ 
	 
	
	// 의료비정리 합계
		@Transactional
	    public int incDdcYeta2018_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		
			return update("infcPkgYe161080_2018_DAO.fnYeta3200_B101Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
	           
	    }
		
		//교육비합계금액 
		@Transactional
	    public int incDdcYeta2018_C101Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
			return update("infcPkgYe161080_2018_DAO.fnYeta3200_C101Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
	           
	    }
		
		
		//기부금액  
		@Transactional
	    public int incDdcYeta2018_L102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
			
			return update("infcPkgYe161080_2018_DAO.fnYeta3200_L102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
	       
	    }
		
		//연금저축 
		@Transactional
	    public int incDdcYeta2018_E102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
			return update("infcPkgYe161080_2018_DAO.fnYeta3200_E102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
	            
	    }
	 
		
		//퇴직연금  
		@Transactional
	    public int incDdcYeta2018_F102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
			return update("infcPkgYe161080_2018_DAO.fnYeta3200_F102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
	            
	    }
	

		@Transactional
	    public int incDdcYeta2018_A102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
			return  update("infcPkgYe161080_2018_DAO.fnYeta3200_A102Y_YE161080_2018_Update_S", infcPkgYe161080Vo);
	    }
		
		@Transactional
	    public int incDdcYeta2018_All_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
			return  update("infcPkgYe161080_2018_DAO.incDdcYeta2018_All_YE161080_2018_Update_S", infcPkgYe161080Vo);
	    }
		 
		
	/**
	 * YE161080?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161080VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161080(InfcPkgYe161080_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe161080_2018_DAO.insertYe161080_S", vo);
    }

    /**
	 * YE161080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161080VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161080(InfcPkgYe161080_2018_VO vo) throws Exception {
        update("infcPkgYe161080_2018_DAO.updateYe161080_S", vo);
    }

    /**
	 * YE161080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161080VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161080(InfcPkgYe161080_2018_VO vo) throws Exception {
        delete("infcPkgYe161080_2018_DAO.deleteYe161080_S", vo);
    }

    /**
	 * YE161080?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161080VO
	 * @return 조회?�� YE161080
	 * @exception Exception
	 */
    public InfcPkgYe161080_2018_VO selectYe161080(InfcPkgYe161080_2018_VO vo) throws Exception {
        return (InfcPkgYe161080_2018_VO) selectByPk("infcPkgYe161080_2018_DAO.selectYe161080_S", vo);
    }

    /**
	 * YE161080 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161080 목록
	 * @exception Exception
	 */
    public List<?> selectYe161080List(InfcPkgYe161080Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe161080_2018_DAO.selectYe161080List_D", searchVO);
    }

    /**
	 * YE161080 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161080 �? �??��
	 * @exception
	 */
    public int selectYe161080ListTotCnt(InfcPkgYe161080Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161080_2018_DAO.selectYe161080ListTotCnt_S", searchVO);
    }

}
