package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161040DAO.java
 * @Description : Ye161040 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161040DAO")
public class InfcPkgYe161040DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta2100_YE161040_2017_CREATE_Insert01(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
        return (String)insert("infcPkgYe161040DAO.fnYeta2100_YE161040_2017_CREATE_Insert01_S", infcPkgYe161040Vo);
    }
	
	@Transactional
    public String fnYeta2100_YE161040_2017_CREATE_Insert02(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
        return (String)insert("infcPkgYe161040DAO.fnYeta2100_YE161040_2017_CREATE_Insert02_S", infcPkgYe161040Vo);
    }
	
	
	@Transactional
    public int fnYeta2100_YE161040_2017_INSU_FETC_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
        return  update("infcPkgYe161040DAO.fnYeta2100_YE161040_2017_INSU_FETC_Update_S", infcPkgYe161040Vo);
    }
	
	@Transactional
    public int PdfYeta2017_A102Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
		return  update("infcPkgYe161040DAO.PdfYeta2017_A102Y_YE161040_Update_S", infcPkgYe161040Vo);
          
    }
	
	//의료비 
	@Transactional
    public int PdfYeta2017_B101Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
		return update("infcPkgYe161040DAO.PdfYeta2017_B101Y_YE161040_Update_S", infcPkgYe161040Vo);
         
    }
	
	
		//교육비 
		@Transactional
	    public int PdfYeta2017_C101Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	         return update("infcPkgYe161040DAO.PdfYeta2017_C101Y_YE161040_Update_S", infcPkgYe161040Vo);

		}
		
		//신용카드 
		@Transactional
	    public int PdfYeta2017_G106Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
			return  update("infcPkgYe161040DAO.PdfYeta2017_G106Y_YE161040_Update_S", infcPkgYe161040Vo);
	          
	    }	
		
		//현금영수증 
		@Transactional
	    public int PdfYeta2017_G206Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	         return update("infcPkgYe161040DAO.PdfYeta2017_G206Y_YE161040_Update_S", infcPkgYe161040Vo);
	         
	    }	
		
		
		//직불카드 
		@Transactional
	    public int  PdfYeta2017_G306Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040DAO.PdfYeta2017_G306Y_YE161040_Update_S", infcPkgYe161040Vo);
	          
	    }	
		
		// E_소득세액공제명세
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2017_Ye161040_Insert(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	        return (String)insert("infcPkgYe161040DAO.incTaxDeducDec_nts_Yeta2017_Ye161040_Insert_S", infcPkgYe161040Vo);
	    }
		  
		
	
//	   //직업훈련비 
//		@Transactional
//	    public String PdfYeta2017_C202Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
//	         update("infcPkgYe161040DAO.PdfYeta2017_C202Y_YE161040_Update_S", infcPkgYe161040Vo);
//	         return "";
//	    }
//		
//		
//		//교복구입비 
//		@Transactional
//	    public String PdfYeta2017_C301Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
//	         update("infcPkgYe161040DAO.PdfYeta2017_C301Y_YE161040_Update_S", infcPkgYe161040Vo);
//	         return "";
//	    }
//		
//		//학자금대출 
//		@Transactional
//	    public String PdfYeta2017_C401Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
//	         update("infcPkgYe161040DAO.PdfYeta2017_C401Y_YE161040_Update_S", infcPkgYe161040Vo);
//	         return "";
//	    }
	 
		
		//건강보험료 금액 
	@Transactional
    public String PdfYeta2017_O101M_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
         update("infcPkgYe161040DAO.PdfYeta2017_O101M_YE161040_Update_S", infcPkgYe161040Vo);
         return "";
    }	
		 
	//기부금액  
@Transactional
public int fnYeta2200_L102Y_YE161040_2017_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	return update("infcPkgYe161040DAO.fnYeta2200_L102Y_YE161040_2017_Update_S", infcPkgYe161040Vo);
      
}	
	 
	
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/ 
 
	//의료비 
		@Transactional
	    public int incDdcYeta2017_B101Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040DAO.incDdcYeta2017_B101Y_YE161040_Update_S", infcPkgYe161040Vo);
	         
	    }
		
		//교육비 
		@Transactional
	    public int incDdcYeta2017_C101Y_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	         return update("infcPkgYe161040DAO.incDdcYeta2017_C101Y_YE161040_Update_S", infcPkgYe161040Vo);

		}
		
		@Transactional
	    public int incDdcYeta2017_YE161040_2017_INSU_FETC_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	        return  update("infcPkgYe161040DAO.fnYeta2100_YE161040_2017_INSU_FETC_Update_S", infcPkgYe161040Vo);
	    }
		 
		//기부금액  
		@Transactional
		public int incDdcYeta2017_L102Y_YE161040_2017_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040DAO.fnYeta2200_L102Y_YE161040_2017_Update_S", infcPkgYe161040Vo);
		    
		}	
		
		
	/**
	 * YE161040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161040(InfcPkgYe161040VO vo) throws Exception {
        return (String)insert("infcPkgYe161040DAO.insertYe161040_S", vo);
    }

    /**
	 * YE161040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161040(InfcPkgYe161040VO vo) throws Exception {
        update("infcPkgYe161040DAO.updateYe161040_S", vo);
    }

    /**
	 * YE161040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161040(InfcPkgYe161040VO vo) throws Exception {
        delete("infcPkgYe161040DAO.deleteYe161040_S", vo);
    }

    /**
	 * YE161040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161040VO
	 * @return 조회?�� YE161040
	 * @exception Exception
	 */
    public InfcPkgYe161040VO selectYe161040(InfcPkgYe161040VO vo) throws Exception {
        return (InfcPkgYe161040VO) selectByPk("infcPkgYe161040DAO.selectYe161040_S", vo);
    }

    /**
	 * YE161040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161040 목록
	 * @exception Exception
	 */
    public List<?> selectYe161040List(InfcPkgYe161040SrhVO searchVO) throws Exception {
        return list("infcPkgYe161040DAO.selectYe161040List_D", searchVO);
    }

    /**
	 * YE161040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161040 �? �??��
	 * @exception
	 */
    public int selectYe161040ListTotCnt(InfcPkgYe161040SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161040DAO.selectYe161040ListTotCnt_S", searchVO);
    }

}
