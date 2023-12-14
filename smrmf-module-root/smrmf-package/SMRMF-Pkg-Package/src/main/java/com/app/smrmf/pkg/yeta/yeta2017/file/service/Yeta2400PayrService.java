package com.app.smrmf.pkg.yeta.yeta2017.file.service;

import java.util.List;
import java.util.Map;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161005VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;

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
public interface Yeta2400PayrService {
	
	
	InfcPkgYe161005VO selectYe161005(InfcPkgYe161010VO ye161010VO) throws Exception;
	 
	
	Map fnPayrB_ReTax_Total_Select( InfcPkgYe161020VO  infcPkgYe161020Vo) throws Exception;
	
	Map fnPayrHB_ReTax_Total_Select( InfcPkgYe161020VO    infcPkgYe161020Vo) throws Exception;
	 
	List fnPayrPSNL_ReTax_Total_Select( InfcPkgYe161020VO    infcPkgYe161020Vo) throws Exception;
	  
	List fnPayrHC_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	 
	List fnPayrHD_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	 
	List fnPayrPSNL_ReTax_CA_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	 
	List fnPayrCA_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception; 
	
	
	List fnPayrC_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	
	List fnPayrD_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	
	List fnPayrE_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	
	List fnPayrF_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	
	List fnPayrG_ReTax_Total_Select(InfcPkgYe161020VO  ye161010VO) throws Exception;
	 
	int updateYeta2400ToYe161010(InfcPkgYe161010VO ye161010VO) throws Exception;  
	
}
