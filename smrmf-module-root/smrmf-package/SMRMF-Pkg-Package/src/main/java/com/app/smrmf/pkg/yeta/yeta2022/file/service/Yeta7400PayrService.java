package com.app.smrmf.pkg.yeta.yeta2022.file.service;

import java.util.List;
import java.util.Map;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161005_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;

/**
 * @Class Name : Yeta7900Service.java
 * @Description : Yeta7900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta7400PayrService {
	
	
	InfcPkgYe161005_2022_VO selectYe161005(InfcPkgYe161010_2022_VO ye161010VO) throws Exception;
	 
	
	Map fnPayrB_ReTax_Total_Select( InfcPkgYe161020_2022_VO  infcPkgYe161020Vo) throws Exception;
	
	Map fnPayrHB_ReTax_Total_Select( InfcPkgYe161020_2022_VO    infcPkgYe161020Vo) throws Exception;
	 
	List fnPayrPSNL_ReTax_Total_Select( InfcPkgYe161020_2022_VO    infcPkgYe161020Vo) throws Exception;
	  
	List fnPayrHC_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	 
	List fnPayrHD_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	 
	List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	 
	List fnPayrCA_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception; 
	
	
	List fnPayrC_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	
	List fnPayrD_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	
	List fnPayrE_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	
	List fnPayrF_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	
	List fnPayrG_ReTax_Total_Select(InfcPkgYe161020_2022_VO  ye161010VO) throws Exception;
	 
	int updateYeta7400ToYe161010(InfcPkgYe161010_2022_VO ye161010VO) throws Exception;  
	
}
