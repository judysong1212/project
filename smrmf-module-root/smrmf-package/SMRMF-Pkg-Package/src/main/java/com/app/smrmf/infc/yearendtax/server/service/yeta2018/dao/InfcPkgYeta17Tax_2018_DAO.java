package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161050_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161055_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161060_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161080_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010a_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta1000_2018_DAO.java
 * @Description : Yeta1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYeta17Tax_2018_DAO")
public class InfcPkgYeta17Tax_2018_DAO extends EgovAbstractDAO { 
	
	
	/********************************************************************************************************
	 * 2017년 세액계산 시작 
	 ********************************************************************************************************/ 
  
	  @Transactional
	  public int fnYeta3300_B101Y_YE161080_2018_Update(InfcPkgYe161010_2018_VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_B101Y_YE161080_2018_Update", infcPkgYe161010Vo);
	  }
	  
	  @Transactional
	  public int fnYeta3300_All_YE161080_2018_Update(InfcPkgYe161010_2018_VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_All_YE161080_2018_Update", infcPkgYe161010Vo);
	  }
   
	  @Transactional
	  public int fnYeta3300_TaxPkg01_2018_Update(InfcPkgYe161010_2018_VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_TaxPkg01_2018_Update", infcPkgYe161010Vo);
	  }
	  
	  //인적공제인원수 산정 
	  @Transactional
	  public int fnYeta3300_YE161020_Tax_2018_01_Update(InfcPkgYe161020_2018_VO infcPkgYe161020Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE161020_Tax_2018_01_Update", infcPkgYe161020Vo);
	    }
	  
	  @Transactional
	  public int fnYeta3300_YE161055_Tax_2018_02_Update(InfcPkgYe161055_2018_VO infcPkgYe161055Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE161055_Tax_2018_02_Update", infcPkgYe161055Vo);
	    }
	    
	  @Transactional
	  public int fnYeta3300_YE161050_Tax_2018_03_Update(InfcPkgYe161050_2018_VO infcPkgYe161050Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE161050_Tax_2018_03_Update", infcPkgYe161050Vo);
	    }
	  
	 
	  
	  @Transactional
	    public String fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
	        return (String)insert("infcPkgYeta17Tax_2018_DAO.fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert", infcPkgYe169010Vo);
	    } 
	    
	  @Transactional
	    public int fnYeta3300_YE169010_Tax_2018_04_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
	        return update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_04_Update", infcPkgYe169010Vo);
	    } 
	  
	  @Transactional
	    public int fnYeta3300_YE169010_Tax_2018_05_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
	        return update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_05_Update", infcPkgYe169010Vo);
	    } 
	   
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_06_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_06_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_07_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_07_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_08_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_08_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_09_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_09_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_10_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_10_Update", infcPkgYe169010Vo);
	    }
	   
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_11_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_11_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_12_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_12_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_13_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_13_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_14_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_14_Update", infcPkgYe169010Vo);
	    }  
	
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_15_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_15_Update", infcPkgYe169010Vo);
	    }	 

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_16_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_16_Update", infcPkgYe161070Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_17_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_17_Update", infcPkgYe161070Vo);
	    }  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_18_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_18_Update", infcPkgYe161070Vo);
	    }  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_19_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_19_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_20_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_20_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_21_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_21_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_22_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_22_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_23_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_23_Update", infcPkgYe169010Vo);
	    }
	 

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_24_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_24_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_25_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_25_Update", infcPkgYe161080Vo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_25_01_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_25_01_Update", infcPkgYe161080Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_26_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_26_Update", infcPkgYe161080Vo);
	    }
	  

	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_27_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_27_Update", infcPkgYe161080Vo);
	    }
	  

//	  @Transactional
//	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
//		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update", infcPkgYe169010Vo);
//	    }
	  

	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_29_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_29_Update", infcPkgYe169010Vo);
	    }
	  
 
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_30_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_30_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_31_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_31_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_31_01_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_31_01_Update", infcPkgYe169010Vo);
	    }	  
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_32_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_32_Update", infcPkgYe169010Vo);
	    } 
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_33_Update(InfcPkgYe161060_2018_VO infcPkgYe161060Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_33_Update", infcPkgYe161060Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_33_02_Update(InfcPkgYe161060_2018_VO infcPkgYe161060Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_33_02_Update", infcPkgYe161060Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_33_03_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_33_03_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_33_04_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_33_04_Update", infcPkgYe169010Vo);
	    }
	  
	   
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update", infcPkgYe169010Vo);
	    }
	  
	   
	   @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update", infcPkgYe169010Vo);
	    }
	   

		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return  delete("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete", infcPkgYe169010Vo);
		    }
		   

		  @Transactional
		   public String fnYeta3300_YE169010_Tax_2018_40_Update(InfcPkgYe165030_2018_VO  infcPkgYe165030Vo) throws Exception {
		        return (String)insert("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_40_Update", infcPkgYe165030Vo);
		    }
		  

		  @Transactional
		   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		        return (String)insert("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update", infcPkgYe169010Vo);
		    } 
		  

		  
		   public List<?> fnYeta3300_YE169010_Tax_2018_TgYear_Select(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		        return list("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_TgYear_Select", infcPkgYe169010Vo);
		    }
		   
		  
		  
		   public List<?> fnYeta3300_YE169010_Tax_2018_1001_Select(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		        return list("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_1001_Select", infcPkgYe169010Vo);
		    }
		   

		    public List<?>  fnPayr06430_PAYR442_ReTax_2018_SelectFind(InfcPkgYe165030Srh_2018_VO vo) throws Exception {
		    	 return list("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR442_ReTax_2018_SelectFind", vo);
		         
		    }
		    
	  @Transactional
	    public int fnPayr06430_PAYR442_ReTax_2018_Update(InfcPkgYe165030_2018_VO infcPkgYe165030Vo) throws Exception {
	        return update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR442_ReTax_2018_Update", infcPkgYe165030Vo);
	    }
	 

	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_50_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_50_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_50_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_50_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_50_01_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_50_01_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_50_01_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_50_01_Update", infcPkgYe169010aVo);
	    }
	  @Transactional
	   public InfcPkgYe169010_2018_VO fnYeta3300_YE169010_Tax_2018_51_Select(InfcPkgYe169010Srh_2018_VO   infcPkgYe169010SrhVo) throws Exception {
	        return (InfcPkgYe169010_2018_VO) selectByPk("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_51_Select", infcPkgYe169010SrhVo);
	    }
	  

	    public InfcPkgYe169010_2018_VO fnYeta3300_YE169010_Tax_2018_2001_Select(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
	        return (InfcPkgYe169010_2018_VO) selectByPk("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_2001_Select", infcPkgYe169010Vo);
	    }
	    
	    public InfcPkgYe169010a_2018_VO fnYeta3300_YE169010a_Tax_2018_2001_Select(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
	        return (InfcPkgYe169010a_2018_VO) selectByPk("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_2001_Select", infcPkgYe169010aVo);
	    }
	     
	    @Transactional
		   public int fnYeta3300_YE169010_Tax_2018_2002_Update(InfcPkgYe169010_2018_VO subInfcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_2002_Update", subInfcPkgYe169010Vo);
		    }
	    
	    @Transactional
		   public int fnYeta3300_YE169010a_Tax_2018_2002_Update(InfcPkgYe169010a_2018_VO subInfcPkgYe169010aVo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_2002_Update", subInfcPkgYe169010aVo);
		    }
	    
	    
	    @Transactional
		   public int fnYeta3300_YE161020_Tax_2018_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020_2018_VO infcPkgYe161020Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE161020_Tax_2018_C152_STD_TX_DDC_YN_Update", infcPkgYe161020Vo);
		    } 
	 
	    
	    @Transactional
		   public int fnYeta3300_YE169010a_Tax_2018_52_Update(InfcPkgYe169010a_2018_VO dscnPrc3000Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_52_Update", dscnPrc3000Vo);
		    }
	    
	    
		  @Transactional
		   public String fnYeta3300_YE169010a_Tax_2018_52_Insert(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		        return (String)insert("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_52_Insert", infcPkgYe169010Vo);
		    } 
	   
		  @Transactional
		   public int fnYeta3300_YE169010a_Tax_2018_52_Delete(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return   delete("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_52_Delete", infcPkgYe169010Vo);
		    }
		 
		  
		  

		   @Transactional
		   public int fnYeta3300_YE169010_Tax_2018_2003_Select(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_2003_Select", infcPkgYe169010Vo);
		    }   
		   
		   
		   
//		  @Transactional
//		   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
//			  return   update("infcPkgYeta17Tax_2018_DAO.yeta2000_ReTax_2016_DCSN_INCM_Update", infcPkgYe169010Vo);
//		    }
		 
		   @Transactional
		   public int fnYeta3300_YE169010_Tax_2018_3001_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3001_Update", infcPkgYe169010Vo);
		    }		  
			  
		   @Transactional
		   public int fnYeta3300_YE169010a_Tax_2018_3001_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
			  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3001_Update", infcPkgYe169010aVo);
		    }		
			
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3002_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3002_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3002_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3002_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3003_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3003_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3003_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3003_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3004_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3004_Update", infcPkgYe169010Vo);
	    }	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3004_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3004_Update", infcPkgYe169010aVo);
	    }	  
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3005_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3005_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3005_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3005_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3006_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3006_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3006_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3006_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3007_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3007_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3007_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3007_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3008_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3008_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3008_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3008_Update", infcPkgYe169010aVo);
	    }

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3009_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3009_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3009_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3009_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3010_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3010_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3010_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3010_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3011_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3011_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3011_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3011_Update", infcPkgYe169010aVo);
	    }

		
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_3012_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_3012_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010a_Tax_2018_3012_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_3012_Update", infcPkgYe169010aVo);
	    }   

		  @Transactional
		   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update", infcPkgYe169010Vo);
		    }
		  

			
		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update", infcPkgYe169010Vo);
		    }
		 

		   
		   
		  @Transactional
		   public int fnYeta3300_YE169010_Tax_2018_51_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_51_Update", infcPkgYe169010Vo);
		    }
		  
		  @Transactional
		   public int fnYeta3300_YE169010a_Tax_2018_51_Update(InfcPkgYe169010a_2018_VO infcPkgYe169010aVo) throws Exception {
			  return  update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010a_Tax_2018_51_Update", infcPkgYe169010aVo);
		    }

		  
			
		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update", infcPkgYe169010Vo);
		    }
 
		  
		  public List  fnYeta3300_YE169010_Tax_2018_A01_Select(InfcPkgYe169010Srh_2018_VO infcPkgYe169010Vo) throws Exception {
		    	 return list("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_A01_Select", infcPkgYe169010Vo);
		         
		    }
		    
		  @Transactional
		   public int fnYeta3300_Ye161060_Tax_2018_I1_Update(InfcPkgYe161060_2018_VO    inputYe161060Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_Ye161060_Tax_2018_I1_Update", inputYe161060Vo);
		    }
	 
		  @Transactional
		   public int fnYeta3300_Ye161070_Tax_2018_I2_Update(InfcPkgYe161070_2018_VO    inputYe161070Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_Ye161070_Tax_2018_I2_Update", inputYe161070Vo);
		    }
		  
		  @Transactional
		   public int fnYeta3300_Ye161080_Tax_2018_I3_Update(InfcPkgYe161080_2018_VO    inputYe161080Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_Ye161080_Tax_2018_I3_Update", inputYe161080Vo);
		    }
		  
		    
		  @Transactional
		   public int fnYeta3300_YE169010_Tax_2018_TgIn01_Update(InfcPkgYe161080_2018_VO    inputYe161080Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_TgIn01_Update", inputYe161080Vo);
		    }
		  
		  @Transactional
		   public int fnYeta3300_YE169010_Tax_2018_TgIn02_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_TgIn02_Update", infcPkgYe169010Vo);
		    }

		    
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_TgIn03_Update(InfcPkgYe161080_2018_VO    inputYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_TgIn03_Update", inputYe161080Vo);
	    }
	  
	  @Transactional
	   public int fnYeta3300_YE169010_Tax_2018_TgIn04_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2018_DAO.fnYeta3300_YE169010_Tax_2018_TgIn04_Update", infcPkgYe169010Vo);
	    }

				  	  
		  
    /********************************************************************************************************
	 * 2017년 세액계산 종료 
	 ********************************************************************************************************/ 
  
	    
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update", infcPkgYe169010Vo);
	    } 
	    
	  @Transactional
	   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010_2018_VO infcPkgYe169010Vo) throws Exception {
		  return   delete("infcPkgYeta17Tax_2018_DAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete", infcPkgYe169010Vo);
	    }
	 
	      
}
