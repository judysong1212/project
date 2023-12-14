package com.app.smrmf.pkg.yeta.yeta2019.file.service;

import java.util.List;
import java.util.Map;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161005_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161020_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161040_2019_VO;

/**
 * @Class Name : Yeta4900Service.java
 * @Description : Yeta4900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta4400PayrService {
	
	
	InfcPkgYe161005_2019_VO selectYe161005(InfcPkgYe161010_2019_VO ye161010VO) throws Exception;
	 
	
	Map fnPayrB_ReTax_Total_Select( InfcPkgYe161020_2019_VO  infcPkgYe161020Vo) throws Exception;
	
	Map fnPayrHB_ReTax_Total_Select( InfcPkgYe161020_2019_VO    infcPkgYe161020Vo) throws Exception;
	 
	List fnPayrPSNL_ReTax_Total_Select( InfcPkgYe161020_2019_VO    infcPkgYe161020Vo) throws Exception;
	  
	List fnPayrHC_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	 
	List fnPayrHD_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	 
	List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	 
	List fnPayrCA_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception; 
	
	
	List fnPayrC_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	
	List fnPayrD_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	
	List fnPayrE_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	
	List fnPayrF_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	
	List fnPayrG_ReTax_Total_Select(InfcPkgYe161020_2019_VO  ye161010VO) throws Exception;
	 
	int updateYeta4400ToYe161010(InfcPkgYe161010_2019_VO ye161010VO) throws Exception;  
	
}
