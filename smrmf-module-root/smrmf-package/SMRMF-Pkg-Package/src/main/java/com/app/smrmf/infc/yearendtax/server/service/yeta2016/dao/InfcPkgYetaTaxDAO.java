package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;

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

@Repository("InfcPkgYetaTaxDAO")
public class InfcPkgYetaTaxDAO extends EgovAbstractDAO { 
	 

	  @Transactional
	  public int fnPayr06420_Yeta3140_ReTax_2016_CREATE_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06420_Yeta3140_ReTax_2016_CREATE_01_Update", vo);
	    }
	
	  @Transactional
	  public int fnPayr06420_PAYR415_ReTax_2016_CREATE_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_01_Update", vo);
	    }
	  
	  @Transactional
	    public String fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert(InfcPkgYeta2000VO vo) throws Exception {
	        return (String)insert("infcPkgYetaTaxDAO.fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert", vo);
	    } 
	    
	  
	  
	  
	  @Transactional
	   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_02_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_02_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_02_2_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_02_2_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_02_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_02_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_02_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_02_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_03_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_03_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_04_02_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_04_02_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_3_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_3_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_2_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_2_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_4_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_4_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_1_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_1_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_2_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_2_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_3_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_3_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_TG_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_TG_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_04_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_04_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_04_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_04_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_05_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_05_01_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_05_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_05_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_01_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_01_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_02_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_02_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_03_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_03_Update", vo);
	    } 
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_02_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_02_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_03_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_03_Update", vo);
	    }
	  
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update", vo);
	    }
	  
	
	  @Transactional
	   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_4_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_4_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_2_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_2_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_14_TX_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_14_TX_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_14_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_14_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_14_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_14_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF01_12_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF01_12_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_SPCI_Update(InfcPkgYeta3000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_SPCI_Update", vo);
	    }
	  
	   @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_SUBT_Update(InfcPkgYeta3000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_SUBT_Update", vo);
	    } 
	   @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_WKER_AMNT_Update(InfcPkgYeta3000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_WKER_AMNT_Update", vo);
	    } 
	   
	   
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Update(InfcPkgYeta3000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Update", vo);
	    }
	   
	  @Transactional
	   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.yeta2000_ReTax_2016_DCSN_INCM_Update", vo);
	    }
	 
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_12_1_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_1_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_15_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_15_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_16_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_16_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_17_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_17_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_18_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return  update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_18_Update", vo);
	    }
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYeta2000VO vo) throws Exception {
		  return   update("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update", vo);
	    }

	    
	  @Transactional
	   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYeta2000VO vo) throws Exception {
		  return   delete("infcPkgYetaTaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete", vo);
	    }
	  @Transactional
	   public int fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Delete(InfcPkgYeta2000VO vo) throws Exception {
		  return   delete("infcPkgYetaTaxDAO.fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Delete", vo);
	    }
	  
	  @Transactional
	   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYeta2000VO vo) throws Exception {
		  return  delete("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete", vo);
	    }
	   
	  @Transactional
	   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_2_Update(InfcPkgYeta2000VO vo) throws Exception {
	        return (String)insert("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_2_Update", vo);
	    }
	  
	  @Transactional
	   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYeta2000VO vo) throws Exception {
	        return (String)insert("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update", vo);
	    } 
	 
	   public List<?> fnPayr06430_PAYR442_PAYR425_ReTax_2016_SelectFind(InfcPkgYeta2000VO searchVO) throws Exception {
	        return list("infcPkgYetaTaxDAO.fnPayr06430_PAYR442_PAYR425_ReTax_2016_SelectFind", searchVO);
	    }
	   
	   public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Select(InfcPkgYeta2000VO vo) throws Exception {
	        return (InfcPkgYeta3000VO) selectByPk("infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Select", vo);
	    }
	      
}
