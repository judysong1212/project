package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161050_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161070_2021_DAO.java
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

@Repository("InfcPkgYe161070_2021_DAO")
public class InfcPkgYe161070_2021_DAO extends EgovAbstractDAO {

	

	@Transactional
    public String fnYeta6100_YE161070_2021_CREATE_Insert(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
        return (String)insert("infcPkgYe161070_2021_DAO.fnYeta6100_YE161070_2021_CREATE_Insert_S", infcPkgYe161070Vo);
    }
	
	//2021연말정산_추가
	//벤처기업투자신탁 
			@Transactional
		    public String fnYeta6200_Q101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
		         update("infcPkgYe161070_2021_DAO.fnYeta6200_Q101Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		         return  "";
		    }
			
	//벤처기업투자신탁_전년도 
	@Transactional
		  public String fnYeta6200_Q201Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
		       update("infcPkgYe161070_2021_DAO.fnYeta6200_Q201Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		       return  "";
		  }
	
	//벤처기업투자신탁_전년도 
	@Transactional
		  public String fnYeta6200_Q301Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
			    update("infcPkgYe161070_2021_DAO.fnYeta6200_Q301Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
			    return  "";
		  }
	
	
	
   //개인연금저축 
	@Transactional
    public String fnYeta6200_D101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
         update("infcPkgYe161070_2021_DAO.fnYeta6200_D101Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
         return  "";
    }
	
	
	//신용카드   
		@Transactional
	    public String fnYeta6200_G107Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_G107Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		
      //현금영수증   
		@Transactional
	    public String fnYeta6200_G207Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_G207Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		//직불카드    
		@Transactional
	    public String fnYeta6200_G307Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_G307Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		//제로페이    
		@Transactional
	    public String fnYeta6200_G407Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_G407Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
 
		//주택마련저축     
		@Transactional
	    public String fnYeta6200_J301Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_J301Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    }
		
		//소상공인공제      
		@Transactional
	    public String fnYeta6200_K101M_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_K101M_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		//장기집합      
		@Transactional
	    public String fnYeta6200_N101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	           update("infcPkgYe161070_2021_DAO.fnYeta6200_N101Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
	           
	           return "";
	    } 
		
		// C_그밖의소득공제
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2021_Ye161070_Insert(InfcPkgYe161070_2021_VO     infcPkgYe161070Vo) throws Exception {
	        return (String)insert("infcPkgYe161070_2021_DAO.incTaxDeducDec_nts_Yeta2021_Ye161070_Insert_S", infcPkgYe161070Vo);
	    }
	 
		
		/********************************************************************************************************
		 * 소득공제관리화면에서처리 하는부분 
		 ********************************************************************************************************/ 		
		 
			// 개인연금저축
			@Transactional
			public int incDdcYeta2021_YE161050_2021_Update(InfcPkgYe161050_2021_VO infcPkgYe161050Vo) throws Exception {
				return update("infcPkgYe161050_2021_DAO.fnYeta6300_YE161050_2021_Update_S", infcPkgYe161050Vo);
			        
			}
		
		
		
		   //개인연금저축 
			@Transactional
		    public int incDdcYeta2021_D101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.fnYeta6200_D101Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		        
		    }
			
			//주택마련저축     
			@Transactional
		    public int incDdcYeta2021_J301Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.fnYeta6200_J301Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    }
			
			
			//장기집합      
			@Transactional
		    public int incDdcYeta2021_N101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.fnYeta6200_N101Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    }
			
			//신용카드   
			@Transactional
		    public int incDdcYeta2021_G107Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return  update("infcPkgYe161070_2021_DAO.fnYeta6200_G107Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			 //현금영수증   
			@Transactional
		    public int incDdcYeta2021_G207Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.fnYeta6200_G207Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			//직불카드    
			@Transactional
		    public int incDdcYeta2021_G307Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.fnYeta6200_G307Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			//제로페이    
			@Transactional
		    public int incDdcYeta2021_G407Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.fnYeta6200_G407Y_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    } 
			
			@Transactional
		    public int incDdcYeta2021_All_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
				return update("infcPkgYe161070_2021_DAO.incDdcYeta2021_All_YE161070_2021_Update_S", infcPkgYe161070Vo);
		            
		    } 
			 
	/**
	 * YE161070?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161070VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161070(InfcPkgYe161070_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe161070_2021_DAO.insertYe161070_S", vo);
    }

    /**
	 * YE161070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161070VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161070(InfcPkgYe161070_2021_VO vo) throws Exception {
        update("infcPkgYe161070_2021_DAO.updateYe161070_S", vo);
    }

    /**
	 * YE161070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161070VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161070(InfcPkgYe161070_2021_VO vo) throws Exception {
        delete("infcPkgYe161070_2021_DAO.deleteYe161070_S", vo);
    }

    /**
	 * YE161070?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161070VO
	 * @return 조회?�� YE161070
	 * @exception Exception
	 */
    public InfcPkgYe161070_2021_VO selectYe161070(InfcPkgYe161070_2021_VO vo) throws Exception {
        return (InfcPkgYe161070_2021_VO) selectByPk("infcPkgYe161070_2021_DAO.selectYe161070_S", vo);
    }

    /**
	 * YE161070 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161070 목록
	 * @exception Exception
	 */
    public List<?> selectYe161070List(InfcPkgYe161070Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe161070_2021_DAO.selectYe161070List_D", searchVO);
    }

    /**
	 * YE161070 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161070 �? �??��
	 * @exception
	 */
    public int selectYe161070ListTotCnt(InfcPkgYe161070Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161070_2021_DAO.selectYe161070ListTotCnt_S", searchVO);
    }

}