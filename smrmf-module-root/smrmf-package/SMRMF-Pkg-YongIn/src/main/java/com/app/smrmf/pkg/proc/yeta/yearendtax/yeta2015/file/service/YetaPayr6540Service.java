package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.file.service;

import java.util.List;
import java.util.Map;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;

/**
 * @Class Name : Yeta3900Service.java
 * @Description : Yeta3900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface YetaPayr6540Service {
	
	
	Map fnPayrHB_ReTax_Total_Select(InfcPkgYeta1000VO yeta1000Vo) throws Exception;
	 
	List fnPayrPSNL_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	  
	List fnPayrHC_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	 
	List fnPayrHD_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	 
	List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	 
	List fnPayrCA_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	 
	Map fnPayrB_ReTax_Total_Select(InfcPkgYeta1000VO yeta1000Vo) throws Exception;
	
	List fnPayrC_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	
	List fnPayrD_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	
	List fnPayrE_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	
	List fnPayrF_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	
	List fnPayrG_ReTax_Total_Select(InfcPkgYeta1000VO  yeta1000Vo) throws Exception;
	
	
	
}
