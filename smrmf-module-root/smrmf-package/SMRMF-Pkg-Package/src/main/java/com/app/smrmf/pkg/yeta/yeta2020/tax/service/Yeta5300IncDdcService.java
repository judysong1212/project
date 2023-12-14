package com.app.smrmf.pkg.yeta.yeta2020.tax.service;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161050_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161055_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161060_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161080_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010_2020_VO;

/**
 * @Class Name : Yeta5900Service.java
 * @Description : Yeta5900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta5300IncDdcService {
	 
	public int incDdcYeta2020_B101Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040VO) throws Exception; 
	 
	// 의료비정리 합계
	public int incDdcYeta2020_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
      
	
	public int incDdcYeta2020_C101Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040VO) throws Exception; 
	

	public int incDdcYeta2020_C101Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	 
	public int incDdcYeta2020_L102Y_YE165020_Delete(InfcPkgYe165020_2020_VO infcPkgYe165020Vo) throws Exception; 
		
	public String incDdcYeta2020_L102Y_YE165020_Insert(InfcPkgYe165020_2020_VO infcPkgYe165020Vo) throws Exception; 
	

    public int incDdcYeta2020_L102Y_YE165030_Delete(InfcPkgYe165030_2020_VO infcPkgYe165030Vo) throws Exception;
	
    public String incDdcYeta2020_L102Y_YE165030_Insert(InfcPkgYe165030_2020_VO infcPkgYe165030Vo) throws Exception; 
	 
    public int incDdcYeta2020_L102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	
    public int incDdcYeta2020_L102Y_YE161040_2020_Update(InfcPkgYe161040_2020_VO infcPkgYe161040Vo) throws Exception; 
     
    public int incDdcYeta2020_L102Y_YE161060_2020_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo) throws Exception; 
	 
	public int incDdcYeta2020_D101Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	 

	public int incDdcYeta2020_E102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2020_F102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	

	public int incDdcYeta2020_J301Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
		

	public int incDdcYeta2020_N101Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	
	public int incDdcYeta2020_YE161055_2020_Update(InfcPkgYe161050_2020_VO infcPkgYe161050Vo) throws Exception; 
	
	
	//종사업장 정리 
	public int delete_YETA3300_2020_Ye161055(InfcPkgYe161055_2020_VO infcPkgYe161055Vo) throws Exception; 
	public String insert_YETA3300_2020_Ye161055(InfcPkgYe161055_2020_VO infcPkgYe161055Vo) throws Exception; 
	
	 
	
	
	public int incDdcYeta2020_YE161050_2020_Update(InfcPkgYe161050_2020_VO infcPkgYe161050Vo) throws Exception; 
	
	 

	public int incDdcYeta2020_G107Y_YE166020_Update(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;  
	

	public int incDdcYeta2020_G107Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2020_G207Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2020_G307Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	//제로페이
	public int incDdcYeta2020_G407Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	public int incDdcYeta2020_YE166010_2020_CREATE_Delete(InfcPkgYe166010_2020_VO infcPkgYe166010Vo) throws Exception; 

	public int incDdcYeta2020_G107Y_YE166020_Delete(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;  
	
	public int incDdcYeta2020_YE166020_2020_CREATE_Delete(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;  
	
	
	 
	public String incDdcYeta2020_YE166020_2020_CREATE_Insert(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;
	
	public String incDdcYeta2020_YE166010_2020_CREATE_Insert(InfcPkgYe166010_2020_VO infcPkgYe166010Vo) throws Exception; 
	  
	public int incDdcYeta2020_A102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2020_YE161040_2020_INSU_FETC_Update(InfcPkgYe161040_2020_VO infcPkgYe161040Vo) throws Exception;
	
	public int incDdcYeta2020_YE161040_2020_INSU_FETC01_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo)  throws Exception;
	
	
	public int incDdcYeta2020_All_YE161060_2020_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo) throws Exception;
	public int incDdcYeta2020_All_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception;
	
	public int incDdcYeta2020_All_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception;
	 

	public  int incDdcYeta5100_YE161030_2020_CREATE_Update(InfcPkgYe161030_2020_VO infcPkgYe161030Vo) throws Exception;
	
	public  int incDdcYeta5300_YE169010_Tax_2020_06_Update(InfcPkgYe169010_2020_VO infcPkgYe169010Vo) throws Exception;
	 
	
	
	
}
