package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta1000DAO.java
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

@Repository("InfcPkgYeta17TaxDAO")
public class InfcPkgYeta17TaxDAO extends EgovAbstractDAO { 
	
	
	/********************************************************************************************************
	 * 2017년 세액계산 시작 
	 ********************************************************************************************************/ 
  
	  @Transactional
	  public int fnYeta2300_B101Y_YE161080_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_B101Y_YE161080_2017_Update", infcPkgYe161010Vo);
	  }
	  
	  @Transactional
	  public int fnYeta2300_All_YE161080_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_All_YE161080_2017_Update", infcPkgYe161010Vo);
	  }
   
	  @Transactional
	  public int fnYeta2300_TaxPkg01_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_TaxPkg01_2017_Update", infcPkgYe161010Vo);
	  }
	  
	  //인적공제인원수 산정 
	  @Transactional
	  public int fnYeta2300_YE161020_Tax_2017_01_Update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE161020_Tax_2017_01_Update", infcPkgYe161020Vo);
	    }
	  
	  @Transactional
	  public int fnYeta2300_YE161055_Tax_2017_02_Update(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE161055_Tax_2017_02_Update", infcPkgYe161055Vo);
	    }
	    
	  @Transactional
	  public int fnYeta2300_YE161050_Tax_2017_03_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE161050_Tax_2017_03_Update", infcPkgYe161050Vo);
	    }
	  
	 
	  
	  @Transactional
	    public String fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	        return (String)insert("infcPkgYeta17TaxDAO.fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert", infcPkgYe169010Vo);
	    } 
	    
	  @Transactional
	    public int fnYeta2300_YE169010_Tax_2017_04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	        return update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_04_Update", infcPkgYe169010Vo);
	    } 
	  
	  @Transactional
	    public int fnYeta2300_YE169010_Tax_2017_05_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	        return update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_05_Update", infcPkgYe169010Vo);
	    } 
	   
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_06_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_06_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_07_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_07_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_08_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_08_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_09_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_09_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_10_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_10_Update", infcPkgYe169010Vo);
	    }
	   
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_11_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_11_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_12_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_12_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_13_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_13_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_14_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_14_Update", infcPkgYe169010Vo);
	    }  
	
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_15_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_15_Update", infcPkgYe169010Vo);
	    }	 

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_16_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_16_Update", infcPkgYe161070Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_17_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_17_Update", infcPkgYe161070Vo);
	    }  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_18_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_18_Update", infcPkgYe161070Vo);
	    }  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_19_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_19_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_20_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_20_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_21_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_21_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_22_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_22_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_23_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_23_Update", infcPkgYe169010Vo);
	    }
	 

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_24_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_24_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_25_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_25_Update", infcPkgYe161080Vo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_25_01_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_25_01_Update", infcPkgYe161080Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_26_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_26_Update", infcPkgYe161080Vo);
	    }
	  

	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_27_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_27_Update", infcPkgYe161080Vo);
	    }
	  

//	  @Transactional
//	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update", infcPkgYe169010Vo);
//	    }
	  

	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_29_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_29_Update", infcPkgYe169010Vo);
	    }
	  
 
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_30_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_30_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_31_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_31_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_31_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_31_01_Update", infcPkgYe169010Vo);
	    }	  
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_32_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_32_Update", infcPkgYe169010Vo);
	    } 
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_33_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_Update", infcPkgYe161060Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_33_02_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_02_Update", infcPkgYe161060Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_33_03_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_03_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_33_04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_04_Update", infcPkgYe169010Vo);
	    }
	  
	   
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update", infcPkgYe169010Vo);
	    }
	  
	   
	   @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update", infcPkgYe169010Vo);
	    }
	   

		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return  delete("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete", infcPkgYe169010Vo);
		    }
		   

		  @Transactional
		   public String fnYeta2300_YE169010_Tax_2017_40_Update(InfcPkgYe165030VO  infcPkgYe165030Vo) throws Exception {
		        return (String)insert("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_40_Update", infcPkgYe165030Vo);
		    }
		  

		  @Transactional
		   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		        return (String)insert("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update", infcPkgYe169010Vo);
		    } 
		  

		  
		   public List<?> fnYeta2300_YE169010_Tax_2017_TgYear_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		        return list("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgYear_Select", infcPkgYe169010Vo);
		    }
		   
		  
		  
		   public List<?> fnYeta2300_YE169010_Tax_2017_1001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		        return list("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_1001_Select", infcPkgYe169010Vo);
		    }
		   

		    public List<?>  fnPayr06430_PAYR442_ReTax_2017_SelectFind(InfcPkgYe165030SrhVO vo) throws Exception {
		    	 return list("infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2017_SelectFind", vo);
		         
		    }
		    
	  @Transactional
	    public int fnPayr06430_PAYR442_ReTax_2017_Update(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception {
	        return update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2017_Update", infcPkgYe165030Vo);
	    }
	 

	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_50_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_50_Update", infcPkgYe169010Vo);
	    }
	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_50_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_50_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_50_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_50_01_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_50_01_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_50_01_Update", infcPkgYe169010aVo);
	    }
	  @Transactional
	   public InfcPkgYe169010VO fnYeta2300_YE169010_Tax_2017_51_Select(InfcPkgYe169010SrhVO   infcPkgYe169010SrhVo) throws Exception {
	        return (InfcPkgYe169010VO) selectByPk("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_51_Select", infcPkgYe169010SrhVo);
	    }
	  

	    public InfcPkgYe169010VO fnYeta2300_YE169010_Tax_2017_2001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	        return (InfcPkgYe169010VO) selectByPk("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_2001_Select", infcPkgYe169010Vo);
	    }
	    
	    public InfcPkgYe169010aVO fnYeta2300_YE169010a_Tax_2017_2001_Select(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	        return (InfcPkgYe169010aVO) selectByPk("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_2001_Select", infcPkgYe169010aVo);
	    }
	     
	    @Transactional
		   public int fnYeta2300_YE169010_Tax_2017_2002_Update(InfcPkgYe169010VO subInfcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_2002_Update", subInfcPkgYe169010Vo);
		    }
	    
	    @Transactional
		   public int fnYeta2300_YE169010a_Tax_2017_2002_Update(InfcPkgYe169010aVO subInfcPkgYe169010aVo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_2002_Update", subInfcPkgYe169010aVo);
		    }
	    
	    
	    @Transactional
		   public int fnYeta2300_YE161020_Tax_2017_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE161020_Tax_2017_C152_STD_TX_DDC_YN_Update", infcPkgYe161020Vo);
		    } 
	 
	    
	    @Transactional
		   public int fnYeta2300_YE169010a_Tax_2017_52_Update(InfcPkgYe169010aVO dscnPrc3000Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_52_Update", dscnPrc3000Vo);
		    }
	    
	    
		  @Transactional
		   public String fnYeta2300_YE169010a_Tax_2017_52_Insert(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		        return (String)insert("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_52_Insert", infcPkgYe169010Vo);
		    } 
	   
		  @Transactional
		   public int fnYeta2300_YE169010a_Tax_2017_52_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return   delete("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_52_Delete", infcPkgYe169010Vo);
		    }
		 
		  
		  

		   @Transactional
		   public int fnYeta2300_YE169010_Tax_2017_2003_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_2003_Select", infcPkgYe169010Vo);
		    }   
		   
		   
		   
//		  @Transactional
//		   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//			  return   update("infcPkgYeta17TaxDAO.yeta2000_ReTax_2016_DCSN_INCM_Update", infcPkgYe169010Vo);
//		    }
		 
		   @Transactional
		   public int fnYeta2300_YE169010_Tax_2017_3001_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3001_Update", infcPkgYe169010Vo);
		    }		  
			  
		   @Transactional
		   public int fnYeta2300_YE169010a_Tax_2017_3001_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
			  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3001_Update", infcPkgYe169010aVo);
		    }		
			
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3002_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3002_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3002_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3002_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3003_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3003_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3003_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3003_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3004_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3004_Update", infcPkgYe169010Vo);
	    }	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3004_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3004_Update", infcPkgYe169010aVo);
	    }	  
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3005_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3005_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3005_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3005_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3006_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3006_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3006_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3006_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3007_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3007_Update", infcPkgYe169010Vo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3007_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3007_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3008_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3008_Update", infcPkgYe169010Vo);
	    }
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3008_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3008_Update", infcPkgYe169010aVo);
	    }

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3009_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3009_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3009_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3009_Update", infcPkgYe169010aVo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3010_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3010_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3010_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3010_Update", infcPkgYe169010aVo);
	    }
	  

	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3011_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3011_Update", infcPkgYe169010Vo);
	    }

	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3011_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3011_Update", infcPkgYe169010aVo);
	    }

		
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_3012_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3012_Update", infcPkgYe169010Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010a_Tax_2017_3012_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3012_Update", infcPkgYe169010aVo);
	    }   

		  @Transactional
		   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update", infcPkgYe169010Vo);
		    }
		  

			
		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update", infcPkgYe169010Vo);
		    }
		 

		   
		   
		  @Transactional
		   public int fnYeta2300_YE169010_Tax_2017_51_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_51_Update", infcPkgYe169010Vo);
		    }
		  
		  @Transactional
		   public int fnYeta2300_YE169010a_Tax_2017_51_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
			  return  update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_51_Update", infcPkgYe169010aVo);
		    }

		  
			
		  @Transactional
		   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update", infcPkgYe169010Vo);
		    }
 
		  
		  public List  fnYeta2300_YE169010_Tax_2017_A01_Select(InfcPkgYe169010SrhVO infcPkgYe169010Vo) throws Exception {
		    	 return list("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_A01_Select", infcPkgYe169010Vo);
		         
		    }
		    
		  @Transactional
		   public int fnYeta2300_Ye161060_Tax_2017_I1_Update(InfcPkgYe161060VO    inputYe161060Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_Ye161060_Tax_2017_I1_Update", inputYe161060Vo);
		    }
	 
		  @Transactional
		   public int fnYeta2300_Ye161070_Tax_2017_I2_Update(InfcPkgYe161070VO    inputYe161070Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_Ye161070_Tax_2017_I2_Update", inputYe161070Vo);
		    }
		  
		  @Transactional
		   public int fnYeta2300_Ye161080_Tax_2017_I3_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_Ye161080_Tax_2017_I3_Update", inputYe161080Vo);
		    }
		  
		    
		  @Transactional
		   public int fnYeta2300_YE169010_Tax_2017_TgIn01_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn01_Update", inputYe161080Vo);
		    }
		  
		  @Transactional
		   public int fnYeta2300_YE169010_Tax_2017_TgIn02_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
			  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn02_Update", infcPkgYe169010Vo);
		    }

		    
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_TgIn03_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn03_Update", inputYe161080Vo);
	    }
	  
	  @Transactional
	   public int fnYeta2300_YE169010_Tax_2017_TgIn04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   update("infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn04_Update", infcPkgYe169010Vo);
	    }

				  	  
		  
    /********************************************************************************************************
	 * 2017년 세액계산 종료 
	 ********************************************************************************************************/ 
  
	    
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return  update("infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update", infcPkgYe169010Vo);
	    } 
	    
	  @Transactional
	   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
		  return   delete("infcPkgYeta17TaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete", infcPkgYe169010Vo);
	    }
	 
	      
}
