package com.app.smrmf.pkg.yeta.yeta2023.tax.service;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161050_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161055_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161060_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161070_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161080_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe169010_2023_VO;

/**
 * @Class Name : Yeta8900Service.java
 * @Description : Yeta8900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta8300IncDdcService {
	 
	public int incDdcYeta2023_B101Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception; 
	 
	// 의료비정리 합계
	public int incDdcYeta2023_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception; 
      
	
	public int incDdcYeta2023_C101Y_YE161040_Update(InfcPkgYe161040_2023_VO ye161040VO) throws Exception; 
	

	public int incDdcYeta2023_C101Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception; 
	 
	public int incDdcYeta2023_L102Y_YE165020_Delete(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception; 
		
	public String incDdcYeta2023_L102Y_YE165020_Insert(InfcPkgYe165020_2023_VO infcPkgYe165020Vo) throws Exception; 
	

    public int incDdcYeta2023_L102Y_YE165030_Delete(InfcPkgYe165030_2023_VO infcPkgYe165030Vo) throws Exception;
	
    public String incDdcYeta2023_L102Y_YE165030_Insert(InfcPkgYe165030_2023_VO infcPkgYe165030Vo) throws Exception; 
	 
    public int incDdcYeta2023_L102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception; 
	
    public int incDdcYeta2023_L102Y_YE161040_2023_Update(InfcPkgYe161040_2023_VO infcPkgYe161040Vo) throws Exception; 
     
    public int incDdcYeta2023_L102Y_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception; 
	 
	public int incDdcYeta2023_D101Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
	 

	public int incDdcYeta2023_E102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2023_F102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception; 
	

	public int incDdcYeta2023_J301Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
		

	public int incDdcYeta2023_N101Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
	
	
	public int incDdcYeta2023_YE161055_2023_Update(InfcPkgYe161050_2023_VO infcPkgYe161050Vo) throws Exception; 
	
	
	//종사업장 정리 
	public int delete_YETA3300_2023_Ye161055(InfcPkgYe161055_2023_VO infcPkgYe161055Vo) throws Exception; 
	public String insert_YETA3300_2023_Ye161055(InfcPkgYe161055_2023_VO infcPkgYe161055Vo) throws Exception; 
	
	 
	
	
	public int incDdcYeta2023_YE161050_2023_Update(InfcPkgYe161050_2023_VO infcPkgYe161050Vo) throws Exception; 
	
	 

	public int incDdcYeta2023_G107Y_YE166020_Update(InfcPkgYe166020_2023_VO infcPkgYe166020Vo) throws Exception;  
	

	public int incDdcYeta2023_G107Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2023_G207Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2023_G307Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
	
	//제로페이
	public int incDdcYeta2023_G407Y_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception; 
	
	public int incDdcYeta2023_YE166010_2023_CREATE_Delete(InfcPkgYe166010_2023_VO infcPkgYe166010Vo) throws Exception; 

	public int incDdcYeta2023_G107Y_YE166020_Delete(InfcPkgYe166020_2023_VO infcPkgYe166020Vo) throws Exception;  
	
	public int incDdcYeta2023_YE166020_2023_CREATE_Delete(InfcPkgYe166020_2023_VO infcPkgYe166020Vo) throws Exception;  
	
	
	 
	public String incDdcYeta2023_YE166020_2023_CREATE_Insert(InfcPkgYe166020_2023_VO infcPkgYe166020Vo) throws Exception;
	
	public String incDdcYeta2023_YE166010_2023_CREATE_Insert(InfcPkgYe166010_2023_VO infcPkgYe166010Vo) throws Exception; 
	  
	public int incDdcYeta2023_A102Y_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2023_YE161040_2023_INSU_FETC_Update(InfcPkgYe161040_2023_VO infcPkgYe161040Vo) throws Exception;
	
	public int incDdcYeta2023_YE161040_2023_INSU_FETC01_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo)  throws Exception;
	
	
	public int incDdcYeta2023_All_YE161060_2023_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception;
	public int incDdcYeta2023_All_YE161070_2023_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception;
	
	public int incDdcYeta2023_All_YE161080_2023_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception;
	 

	public  int incDdcYeta8100_YE161030_2023_CREATE_Update(InfcPkgYe161030_2023_VO infcPkgYe161030Vo) throws Exception;
	
	public  int incDdcYeta8300_YE169010_Tax_2023_06_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception;
	 
	
	
	
}
