package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161050_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161055_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161060_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010a_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta1000_2021_DAO.java
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

@Repository("InfcPkgYeta17Tax_2021_DAO")
public class InfcPkgYeta17Tax_2021_DAO extends EgovAbstractDAO { 
	
	
	/********************************************************************************************************
	 * 2017년 세액계산 시작 
	 ********************************************************************************************************/ 
  
	  @Transactional
	  public int fnYeta6300_B101Y_YE161080_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_B101Y_YE161080_2021_Update", infcPkgYe161010Vo);
	  }
	  
	  @Transactional
	  public int fnYeta6300_All_YE161080_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_All_YE161080_2021_Update", infcPkgYe161010Vo);
	  }
   
	  @Transactional
	  public int fnYeta6300_TaxPkg01_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_TaxPkg01_2021_Update", infcPkgYe161010Vo);
	  }
	  
	  //인적공제인원수 산정 
	  @Transactional
	  public int fnYeta6300_YE161020_Tax_2021_01_Update(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE161020_Tax_2021_01_Update", infcPkgYe161020Vo);
	    }
	  
	  @Transactional
	  public int fnYeta6300_YE161055_Tax_2021_02_Update(InfcPkgYe161055_2021_VO infcPkgYe161055Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE161055_Tax_2021_02_Update", infcPkgYe161055Vo);
	    }
	    
	  @Transactional
	  public int fnYeta6300_YE161050_Tax_2021_03_Update(InfcPkgYe161050_2021_VO infcPkgYe161050Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE161050_Tax_2021_03_Update", infcPkgYe161050Vo);
	    }
	  
	 
	  
	  @Transactional
	    public String fnPayr06420_Yeta6300_ReTax_2016_CREATE_01_1_Insert(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	        return (String)insert("infcPkgYeta17Tax_2021_DAO.fnPayr06420_Yeta6300_ReTax_2016_CREATE_01_1_Insert", infcPkgYe169010Vo);
	    } 
	    
	  @Transactional
	    public int fnYeta6300_YE169010_Tax_2021_04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	        return update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_04_Update", infcPkgYe169010Vo);
	    } 
	  
	  @Transactional
	    public int fnYeta6300_YE169010_Tax_2021_05_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	        return update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_05_Update", infcPkgYe169010Vo);
	    } 
	   
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_06_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_06_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_07_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_07_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_08_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_08_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_09_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_09_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_10_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_10_Update", infcPkgYe169010Vo);
	    }
	   
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_11_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_11_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_12_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_12_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_13_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_13_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_14_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_14_Update", infcPkgYe169010Vo);
	    }  
	
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_15_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_15_Update", infcPkgYe169010Vo);
	    }	 

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_16_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_16_Update", infcPkgYe161070Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_17_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_17_Update", infcPkgYe161070Vo);
	    }  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_18_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_18_Update", infcPkgYe161070Vo);
	    }  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_19_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_19_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_20_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_20_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_21_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_21_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_22_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_22_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_23_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_23_Update", infcPkgYe169010Vo);
	    }
	 

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_24_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_24_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_25_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_25_Update", infcPkgYe161080Vo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_25_01_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_25_01_Update", infcPkgYe161080Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_26_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_26_Update", infcPkgYe161080Vo);
	    }
	  

	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_27_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_27_Update", infcPkgYe161080Vo);
	    }
	  

//	  @Transactional
//	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
//		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update", infcPkgYe169010Vo);
//	    }
	  

	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_29_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_29_Update", infcPkgYe169010Vo);
	    }
	  
 
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_30_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_30_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_31_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_31_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_31_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_31_01_Update", infcPkgYe169010Vo);
	    }	  
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_32_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_32_Update", infcPkgYe169010Vo);
	    } 
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_33_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_33_Update", infcPkgYe161060Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_33_02_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_33_02_Update", infcPkgYe161060Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_33_03_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_33_03_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_33_04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_33_04_Update", infcPkgYe169010Vo);
	    }
	  
	   
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update", infcPkgYe169010Vo);
	    }
	  
	   
	   @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update", infcPkgYe169010Vo);
	    }
	   

		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return  delete("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete", infcPkgYe169010Vo);
		    }
		   

		  @Transactional
		   public String fnYeta6300_YE169010_Tax_2021_40_Update(InfcPkgYe165030_2021_VO  infcPkgYe165030Vo) throws Exception {
		        return (String)insert("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_40_Update", infcPkgYe165030Vo);
		    }
		  

		  @Transactional
		   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		        return (String)insert("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update", infcPkgYe169010Vo);
		    } 
		  

		  
		   public List<?> fnYeta6300_YE169010_Tax_2021_TgYear_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		        return list("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_TgYear_Select", infcPkgYe169010Vo);
		    }
		   
		  
		  
		   public List<?> fnYeta6300_YE169010_Tax_2021_1001_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		        return list("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_1001_Select", infcPkgYe169010Vo);
		    }
		   

		    public List<?>  fnPayr06430_PAYR442_ReTax_2021_SelectFind(InfcPkgYe165030Srh_2021_VO vo) throws Exception {
		    	 return list("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR442_ReTax_2021_SelectFind", vo);
		         
		    }
		    
	  @Transactional
	    public int fnPayr06430_PAYR442_ReTax_2021_Update(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
	        return update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR442_ReTax_2021_Update", infcPkgYe165030Vo);
	    }
	 

	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_50_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_50_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_50_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_50_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_50_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_50_01_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_50_01_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_50_01_Update", infcPkgYe169010aVo);
	    }
	  @Transactional
	   public InfcPkgYe169010_2021_VO fnYeta6300_YE169010_Tax_2021_51_Select(InfcPkgYe169010Srh_2021_VO   infcPkgYe169010SrhVo) throws Exception {
	        return (InfcPkgYe169010_2021_VO) selectByPk("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_51_Select", infcPkgYe169010SrhVo);
	    }
	  

	    public InfcPkgYe169010_2021_VO fnYeta6300_YE169010_Tax_2021_2001_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	        return (InfcPkgYe169010_2021_VO) selectByPk("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_2001_Select", infcPkgYe169010Vo);
	    }
	    
	    public InfcPkgYe169010a_2021_VO fnYeta6300_YE169010a_Tax_2021_2001_Select(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	        return (InfcPkgYe169010a_2021_VO) selectByPk("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_2001_Select", infcPkgYe169010aVo);
	    }
	     
	    @Transactional
		   public int fnYeta6300_YE169010_Tax_2021_2002_Update(InfcPkgYe169010_2021_VO subInfcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_2002_Update", subInfcPkgYe169010Vo);
		    }
	    
	    @Transactional
		   public int fnYeta6300_YE169010a_Tax_2021_2002_Update(InfcPkgYe169010a_2021_VO subInfcPkgYe169010aVo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_2002_Update", subInfcPkgYe169010aVo);
		    }
	    
	    
	    @Transactional
		   public int fnYeta6300_YE161020_Tax_2021_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE161020_Tax_2021_C152_STD_TX_DDC_YN_Update", infcPkgYe161020Vo);
		    } 
	 
	    
	    @Transactional
		   public int fnYeta6300_YE169010a_Tax_2021_52_Update(InfcPkgYe169010a_2021_VO dscnPrc3000Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_52_Update", dscnPrc3000Vo);
		    }
	    
	    
		  @Transactional
		   public String fnYeta6300_YE169010a_Tax_2021_52_Insert(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		        return (String)insert("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_52_Insert", infcPkgYe169010Vo);
		    } 
	   
		  @Transactional
		   public int fnYeta6300_YE169010a_Tax_2021_52_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return   delete("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_52_Delete", infcPkgYe169010Vo);
		    }
		 
		  
		  

		   @Transactional
		   public int fnYeta6300_YE169010_Tax_2021_2003_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_2003_Select", infcPkgYe169010Vo);
		    }   
		   
		   
		   
//		  @Transactional
//		   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
//			  return   update("infcPkgYeta17Tax_2021_DAO.yeta2000_ReTax_2016_DCSN_INCM_Update", infcPkgYe169010Vo);
//		    }
		 
		   @Transactional
		   public int fnYeta6300_YE169010_Tax_2021_3001_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3001_Update", infcPkgYe169010Vo);
		    }		  
			  
		   @Transactional
		   public int fnYeta6300_YE169010a_Tax_2021_3001_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
			  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3001_Update", infcPkgYe169010aVo);
		    }		
			
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3002_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3002_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3002_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3002_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3003_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3003_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3003_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3003_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3004_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3004_Update", infcPkgYe169010Vo);
	    }	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3004_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3004_Update", infcPkgYe169010aVo);
	    }	  
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3005_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3005_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3005_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3005_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3006_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3006_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3006_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3006_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3007_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3007_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3007_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3007_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3008_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3008_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3008_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3008_Update", infcPkgYe169010aVo);
	    }

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3009_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3009_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3009_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3009_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3010_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3010_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3010_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3010_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3011_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3011_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3011_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3011_Update", infcPkgYe169010aVo);
	    }

		
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_3012_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_3012_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010a_Tax_2021_3012_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_3012_Update", infcPkgYe169010aVo);
	    }   

		  @Transactional
		   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update", infcPkgYe169010Vo);
		    }
		  

			
		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update", infcPkgYe169010Vo);
		    }
		 

		   
		   
		  @Transactional
		   public int fnYeta6300_YE169010_Tax_2021_51_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_51_Update", infcPkgYe169010Vo);
		    }
		  
		  @Transactional
		   public int fnYeta6300_YE169010a_Tax_2021_51_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
			  return  update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010a_Tax_2021_51_Update", infcPkgYe169010aVo);
		    }

		  
			
		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update", infcPkgYe169010Vo);
		    }
 
		  
		  public List  fnYeta6300_YE169010_Tax_2021_A01_Select(InfcPkgYe169010Srh_2021_VO infcPkgYe169010Vo) throws Exception {
		    	 return list("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_A01_Select", infcPkgYe169010Vo);
		         
		    }
		    
		  @Transactional
		   public int fnYeta6300_Ye161060_Tax_2021_I1_Update(InfcPkgYe161060_2021_VO    inputYe161060Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_Ye161060_Tax_2021_I1_Update", inputYe161060Vo);
		    }
	 
		  @Transactional
		   public int fnYeta6300_Ye161070_Tax_2021_I2_Update(InfcPkgYe161070_2021_VO    inputYe161070Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_Ye161070_Tax_2021_I2_Update", inputYe161070Vo);
		    }
		  
		  @Transactional
		   public int fnYeta6300_Ye161080_Tax_2021_I3_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_Ye161080_Tax_2021_I3_Update", inputYe161080Vo);
		    }
		  
		    
		  @Transactional
		   public int fnYeta6300_YE169010_Tax_2021_TgIn01_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_TgIn01_Update", inputYe161080Vo);
		    }
		  
		  @Transactional
		   public int fnYeta6300_YE169010_Tax_2021_TgIn02_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_TgIn02_Update", infcPkgYe169010Vo);
		    }

		    
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_TgIn03_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_TgIn03_Update", inputYe161080Vo);
	    }
	  
	  @Transactional
	   public int fnYeta6300_YE169010_Tax_2021_TgIn04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17Tax_2021_DAO.fnYeta6300_YE169010_Tax_2021_TgIn04_Update", infcPkgYe169010Vo);
	    }

				  	  
		  
    /********************************************************************************************************
	 * 2017년 세액계산 종료 
	 ********************************************************************************************************/ 
  
	    
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update", infcPkgYe169010Vo);
	    } 
	    
	  @Transactional
	   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
		  return   delete("infcPkgYeta17Tax_2021_DAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete", infcPkgYe169010Vo);
	    }
	 
	      
}
