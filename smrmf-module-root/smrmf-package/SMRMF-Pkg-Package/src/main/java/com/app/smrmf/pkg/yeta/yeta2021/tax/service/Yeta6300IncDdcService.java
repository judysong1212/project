package com.app.smrmf.pkg.yeta.yeta2021.tax.service;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161050_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161055_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161060_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010_2021_VO;

/**
 * @Class Name : Yeta6900Service.java
 * @Description : Yeta6900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta6300IncDdcService {
	 
	public int incDdcYeta2021_B101Y_YE161040_Update(InfcPkgYe161040_2021_VO ye161040VO) throws Exception; 
	 
	// 의료비정리 합계
	public int incDdcYeta2021_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
      
	
	public int incDdcYeta2021_C101Y_YE161040_Update(InfcPkgYe161040_2021_VO ye161040VO) throws Exception; 
	

	public int incDdcYeta2021_C101Y_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	 
	public int incDdcYeta2021_L102Y_YE165020_Delete(InfcPkgYe165020_2021_VO infcPkgYe165020Vo) throws Exception; 
		
	public String incDdcYeta2021_L102Y_YE165020_Insert(InfcPkgYe165020_2021_VO infcPkgYe165020Vo) throws Exception; 
	

    public int incDdcYeta2021_L102Y_YE165030_Delete(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception;
	
    public String incDdcYeta2021_L102Y_YE165030_Insert(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception; 
	 
    public int incDdcYeta2021_L102Y_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	
    public int incDdcYeta2021_L102Y_YE161040_2021_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception; 
     
    public int incDdcYeta2021_L102Y_YE161060_2021_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception; 
	 
	public int incDdcYeta2021_D101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
	 

	public int incDdcYeta2021_E102Y_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2021_F102Y_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	

	public int incDdcYeta2021_J301Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
		

	public int incDdcYeta2021_N101Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
	
	
	public int incDdcYeta2021_YE161055_2021_Update(InfcPkgYe161050_2021_VO infcPkgYe161050Vo) throws Exception; 
	
	
	//종사업장 정리 
	public int delete_YETA3300_2021_Ye161055(InfcPkgYe161055_2021_VO infcPkgYe161055Vo) throws Exception; 
	public String insert_YETA3300_2021_Ye161055(InfcPkgYe161055_2021_VO infcPkgYe161055Vo) throws Exception; 
	
	 
	
	
	public int incDdcYeta2021_YE161050_2021_Update(InfcPkgYe161050_2021_VO infcPkgYe161050Vo) throws Exception; 
	
	 

	public int incDdcYeta2021_G107Y_YE166020_Update(InfcPkgYe166020_2021_VO infcPkgYe166020Vo) throws Exception;  
	

	public int incDdcYeta2021_G107Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2021_G207Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2021_G307Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
	
	//제로페이
	public int incDdcYeta2021_G407Y_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception; 
	
	public int incDdcYeta2021_YE166010_2021_CREATE_Delete(InfcPkgYe166010_2021_VO infcPkgYe166010Vo) throws Exception; 

	public int incDdcYeta2021_G107Y_YE166020_Delete(InfcPkgYe166020_2021_VO infcPkgYe166020Vo) throws Exception;  
	
	public int incDdcYeta2021_YE166020_2021_CREATE_Delete(InfcPkgYe166020_2021_VO infcPkgYe166020Vo) throws Exception;  
	
	
	 
	public String incDdcYeta2021_YE166020_2021_CREATE_Insert(InfcPkgYe166020_2021_VO infcPkgYe166020Vo) throws Exception;
	
	public String incDdcYeta2021_YE166010_2021_CREATE_Insert(InfcPkgYe166010_2021_VO infcPkgYe166010Vo) throws Exception; 
	  
	public int incDdcYeta2021_A102Y_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2021_YE161040_2021_INSU_FETC_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception;
	
	public int incDdcYeta2021_YE161040_2021_INSU_FETC01_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo)  throws Exception;
	
	
	public int incDdcYeta2021_All_YE161060_2021_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception;
	public int incDdcYeta2021_All_YE161070_2021_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception;
	
	public int incDdcYeta2021_All_YE161080_2021_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception;
	 

	public  int incDdcYeta6100_YE161030_2021_CREATE_Update(InfcPkgYe161030_2021_VO infcPkgYe161030Vo) throws Exception;
	
	public  int incDdcYeta6300_YE169010_Tax_2021_06_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	 
	
	
	
}
