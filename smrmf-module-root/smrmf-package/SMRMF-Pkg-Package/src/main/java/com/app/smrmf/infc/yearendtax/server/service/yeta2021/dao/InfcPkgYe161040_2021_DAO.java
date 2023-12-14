package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161040Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166020_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161040_2021_DAO.java
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

@Repository("InfcPkgYe161040_2021_DAO")
public class InfcPkgYe161040_2021_DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta6100_YE161040_2021_CREATE_Insert01(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
        return (String)insert("infcPkgYe161040_2021_DAO.fnYeta6100_YE161040_2021_CREATE_Insert01_S", infcPkgYe161040Vo);
    }
	
	@Transactional
    public String fnYeta6100_YE161040_2021_CREATE_Insert02(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
        return (String)insert("infcPkgYe161040_2021_DAO.fnYeta6100_YE161040_2021_CREATE_Insert02_S", infcPkgYe161040Vo);
    }
	
	
	@Transactional
    public int fnYeta6100_YE161040_2021_INSU_FETC_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
        return  update("infcPkgYe161040_2021_DAO.fnYeta6100_YE161040_2021_INSU_FETC_Update_S", infcPkgYe161040Vo);
    }
	
	@Transactional
    public int PdfYeta2021_A102Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
		return  update("infcPkgYe161040_2021_DAO.PdfYeta2021_A102Y_YE161040_Update_S", infcPkgYe161040Vo);
          
    }
	
	//의료비 
	@Transactional
    public int PdfYeta2021_B101Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
		return update("infcPkgYe161040_2021_DAO.PdfYeta2021_B101Y_YE161040_Update_S", infcPkgYe161040Vo);
         
    }
	
	
	//실손보험
		@Transactional
	    public int PdfYeta2021_B201Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040_2021_DAO.PdfYeta2021_B201Y_YE161040_Update_S", infcPkgYe161040Vo);
	         
	    }
	
	
		//교육비 
		@Transactional
	    public int PdfYeta2021_C101Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
	         return update("infcPkgYe161040_2021_DAO.PdfYeta2021_C101Y_YE161040_Update_S", infcPkgYe161040Vo);

		}
		
		//신용카드 
		@Transactional
	    public int PdfYeta2021_G107Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
			return  update("infcPkgYe161040_2021_DAO.PdfYeta2021_G107Y_YE161040_Update_S", infcPkgYe161040Vo);
	          
	    }	
		
		//현금영수증 
		@Transactional
	    public int PdfYeta2021_G207Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
	         return update("infcPkgYe161040_2021_DAO.PdfYeta2021_G207Y_YE161040_Update_S", infcPkgYe161040Vo);
	         
	    }	
		
		//직불카드 
	    public int  PdfYeta2021_G307Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040_2021_DAO.PdfYeta2021_G307Y_YE161040_Update_S", infcPkgYe161040Vo);
	          
	    }	
	    
	    //제로페이 
	    public int  PdfYeta2021_G407Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040_2021_DAO.PdfYeta2021_G407Y_YE161040_Update_S", infcPkgYe161040Vo);
	          
	    }
		
		// E_소득세액공제명세
		@Transactional
	    public String incTaxDeducDec_nts_Yeta2021_Ye161040_Insert(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
	        return (String)insert("infcPkgYe161040_2021_DAO.incTaxDeducDec_nts_Yeta2021_Ye161040_Insert_S", infcPkgYe161040Vo);
	    }
		
		//건강보험료 금액 
	@Transactional
    public String PdfYeta2021_O101M_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
         update("infcPkgYe161040_2021_DAO.PdfYeta2021_O101M_YE161040_Update_S", infcPkgYe161040Vo);
         return "";
    }	
		 
	//기부금액  
@Transactional
public int fnYeta6200_L102Y_YE161040_2021_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
	return update("infcPkgYe161040_2021_DAO.fnYeta6200_L102Y_YE161040_2021_Update_S", infcPkgYe161040Vo);
      
}	
	 
	
	/********************************************************************************************************
	 * 소득공제관리화면에서처리 하는부분 
	 ********************************************************************************************************/ 
 
	//의료비 
		@Transactional
	    public int incDdcYeta2021_B101Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040_2021_DAO.incDdcYeta2021_B101Y_YE161040_Update_S", infcPkgYe161040Vo);
	         
	    }
		
		//교육비 
		@Transactional
	    public int incDdcYeta2021_C101Y_YE161040_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
	         return update("infcPkgYe161040_2021_DAO.incDdcYeta2021_C101Y_YE161040_Update_S", infcPkgYe161040Vo);

		}
		
		@Transactional
	    public int incDdcYeta2021_YE161040_2021_INSU_FETC_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
	        return  update("infcPkgYe161040_2021_DAO.fnYeta6100_YE161040_2021_INSU_FETC_Update_S", infcPkgYe161040Vo);
	    }
		 
		//기부금액  
		@Transactional
		public int incDdcYeta2021_L102Y_YE161040_2021_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception {
			return update("infcPkgYe161040_2021_DAO.fnYeta6200_L102Y_YE161040_2021_Update_S", infcPkgYe161040Vo);
		    
		}	
		
		
	/**
	 * YE161040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161040(InfcPkgYe161040_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe161040_2021_DAO.insertYe161040_S", vo);
    }

    /**
	 * YE161040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161040(InfcPkgYe161040_2021_VO vo) throws Exception {
        update("infcPkgYe161040_2021_DAO.updateYe161040_S", vo);
    }

    /**
	 * YE161040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161040(InfcPkgYe161040_2021_VO vo) throws Exception {
        delete("infcPkgYe161040_2021_DAO.deleteYe161040_S", vo);
    }

    /**
	 * YE161040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161040VO
	 * @return 조회?�� YE161040
	 * @exception Exception
	 */
    public InfcPkgYe161040_2021_VO selectYe161040(InfcPkgYe161040_2021_VO vo) throws Exception {
        return (InfcPkgYe161040_2021_VO) selectByPk("infcPkgYe161040_2021_DAO.selectYe161040_S", vo);
    }

    /**
	 * YE161040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161040 목록
	 * @exception Exception
	 */
    public List<?> selectYe161040List(InfcPkgYe161040Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe161040_2021_DAO.selectYe161040List_D", searchVO);
    }

    /**
	 * YE161040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161040 �? �??��
	 * @exception
	 */
    public int selectYe161040ListTotCnt(InfcPkgYe161040Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161040_2021_DAO.selectYe161040ListTotCnt_S", searchVO);
    }

}
