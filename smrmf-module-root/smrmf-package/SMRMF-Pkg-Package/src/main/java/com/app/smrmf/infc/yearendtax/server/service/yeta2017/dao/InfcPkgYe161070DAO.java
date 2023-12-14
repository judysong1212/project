package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161070DAO.java
 * @Description : Ye161070 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161070DAO")
public class InfcPkgYe161070DAO extends EgovAbstractDAO {

	

	@Transactional
    public String fnYeta2100_YE161070_2017_CREATE_Insert(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
        return (String)insert("infcPkgYe161070DAO.fnYeta2100_YE161070_2017_CREATE_Insert_S", infcPkgYe161070Vo);
    }
	
   //개인연금저축 
	@Transactional
    public String fnYeta2200_D101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
         update("infcPkgYe161070DAO.fnYeta2200_D101Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
         return  "";
    }
	
	
	//신용카드   
		@Transactional
	    public String fnYeta2200_G106Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070DAO.fnYeta2200_G106Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		
      //현금영수증   
		@Transactional
	    public String fnYeta2200_G206Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070DAO.fnYeta2200_G206Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		
		//직불카드    
		@Transactional
	    public String fnYeta2200_G306Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070DAO.fnYeta2200_G306Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
 
		//주택마련저축     
		@Transactional
	    public String fnYeta2200_J301Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070DAO.fnYeta2200_J301Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    }
		
		//소상공인공제      
		@Transactional
	    public String fnYeta2200_K101M_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070DAO.fnYeta2200_K101M_YE161070_2017_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		//장기집합      
		@Transactional
	    public String fnYeta2200_N101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070DAO.fnYeta2200_N101Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		// C_그밖의소득공제
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2017_Ye161070_Insert(InfcPkgYe161070VO     infcPkgYe161070Vo) throws Exception {
	        return (String)insert("infcPkgYe161070DAO.incTaxDeducDec_nts_Yeta2017_Ye161070_Insert_S", infcPkgYe161070Vo);
	    }
	 
		
		/********************************************************************************************************
		 * 소득공제관리화면에서처리 하는부분 
		 ********************************************************************************************************/ 		
		 
			// 개인연금저축
			@Transactional
			public int incDdcYeta2017_YE161050_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
				return update("infcPkgYe161050DAO.fnYeta2300_YE161050_2017_Update_S", infcPkgYe161050Vo);
			        
			}
		
		
		
		   //개인연금저축 
			@Transactional
		    public int incDdcYeta2017_D101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070DAO.fnYeta2200_D101Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
		        
		    }
			
			//주택마련저축     
			@Transactional
		    public int incDdcYeta2017_J301Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070DAO.fnYeta2200_J301Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
		            
		    }
			
			
			//장기집합      
			@Transactional
		    public int incDdcYeta2017_N101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070DAO.fnYeta2200_N101Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
		            
		    }
			
			//신용카드   
			@Transactional
		    public int incDdcYeta2017_G106Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return  update("infcPkgYe161070DAO.fnYeta2200_G106Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			 //현금영수증   
			@Transactional
		    public int incDdcYeta2017_G206Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070DAO.fnYeta2200_G206Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			//직불카드    
			@Transactional
		    public int incDdcYeta2017_G306Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070DAO.fnYeta2200_G306Y_YE161070_2017_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			@Transactional
		    public int incDdcYeta2017_All_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070DAO.incDdcYeta2017_All_YE161070_2017_Update_S", infcPkgYe161070Vo);
		            
		    } 
			 
	/**
	 * YE161070?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161070VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161070(InfcPkgYe161070VO vo) throws Exception {
        return (String)insert("infcPkgYe161070DAO.insertYe161070_S", vo);
    }

    /**
	 * YE161070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161070VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161070(InfcPkgYe161070VO vo) throws Exception {
        update("infcPkgYe161070DAO.updateYe161070_S", vo);
    }

    /**
	 * YE161070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161070VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161070(InfcPkgYe161070VO vo) throws Exception {
        delete("infcPkgYe161070DAO.deleteYe161070_S", vo);
    }

    /**
	 * YE161070?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161070VO
	 * @return 조회?�� YE161070
	 * @exception Exception
	 */
    public InfcPkgYe161070VO selectYe161070(InfcPkgYe161070VO vo) throws Exception {
        return (InfcPkgYe161070VO) selectByPk("infcPkgYe161070DAO.selectYe161070_S", vo);
    }

    /**
	 * YE161070 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161070 목록
	 * @exception Exception
	 */
    public List<?> selectYe161070List(InfcPkgYe161070SrhVO searchVO) throws Exception {
        return list("infcPkgYe161070DAO.selectYe161070List_D", searchVO);
    }

    /**
	 * YE161070 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161070 �? �??��
	 * @exception
	 */
    public int selectYe161070ListTotCnt(InfcPkgYe161070SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161070DAO.selectYe161070ListTotCnt_S", searchVO);
    }

}
