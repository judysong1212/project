package com.app.smrmf.pkg.yeta.yeta2022.tax.service;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161050_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161055_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161060_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010_2022_VO;

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
public interface Yeta7300IncDdcService {
	 
	public int incDdcYeta2022_B101Y_YE161040_Update(InfcPkgYe161040_2022_VO ye161040VO) throws Exception; 
	 
	// 의료비정리 합계
	public int incDdcYeta2022_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
      
	
	public int incDdcYeta2022_C101Y_YE161040_Update(InfcPkgYe161040_2022_VO ye161040VO) throws Exception; 
	

	public int incDdcYeta2022_C101Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	 
	public int incDdcYeta2022_L102Y_YE165020_Delete(InfcPkgYe165020_2022_VO infcPkgYe165020Vo) throws Exception; 
		
	public String incDdcYeta2022_L102Y_YE165020_Insert(InfcPkgYe165020_2022_VO infcPkgYe165020Vo) throws Exception; 
	

    public int incDdcYeta2022_L102Y_YE165030_Delete(InfcPkgYe165030_2022_VO infcPkgYe165030Vo) throws Exception;
	
    public String incDdcYeta2022_L102Y_YE165030_Insert(InfcPkgYe165030_2022_VO infcPkgYe165030Vo) throws Exception; 
	 
    public int incDdcYeta2022_L102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	
    public int incDdcYeta2022_L102Y_YE161040_2022_Update(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception; 
     
    public int incDdcYeta2022_L102Y_YE161060_2022_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception; 
	 
	public int incDdcYeta2022_D101Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
	 

	public int incDdcYeta2022_E102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2022_F102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	

	public int incDdcYeta2022_J301Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
		

	public int incDdcYeta2022_N101Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
	
	
	public int incDdcYeta2022_YE161055_2022_Update(InfcPkgYe161050_2022_VO infcPkgYe161050Vo) throws Exception; 
	
	
	//종사업장 정리 
	public int delete_YETA3300_2022_Ye161055(InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception; 
	public String insert_YETA3300_2022_Ye161055(InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception; 
	
	 
	
	
	public int incDdcYeta2022_YE161050_2022_Update(InfcPkgYe161050_2022_VO infcPkgYe161050Vo) throws Exception; 
	
	 

	public int incDdcYeta2022_G107Y_YE166020_Update(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception;  
	

	public int incDdcYeta2022_G107Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2022_G207Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2022_G307Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
	
	//제로페이
	public int incDdcYeta2022_G407Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception; 
	
	public int incDdcYeta2022_YE166010_2022_CREATE_Delete(InfcPkgYe166010_2022_VO infcPkgYe166010Vo) throws Exception; 

	public int incDdcYeta2022_G107Y_YE166020_Delete(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception;  
	
	public int incDdcYeta2022_YE166020_2022_CREATE_Delete(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception;  
	
	
	 
	public String incDdcYeta2022_YE166020_2022_CREATE_Insert(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception;
	
	public String incDdcYeta2022_YE166010_2022_CREATE_Insert(InfcPkgYe166010_2022_VO infcPkgYe166010Vo) throws Exception; 
	  
	public int incDdcYeta2022_A102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2022_YE161040_2022_INSU_FETC_Update(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception;
	
	public int incDdcYeta2022_YE161040_2022_INSU_FETC01_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo)  throws Exception;
	
	
	public int incDdcYeta2022_All_YE161060_2022_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception;
	public int incDdcYeta2022_All_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception;
	
	public int incDdcYeta2022_All_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception;
	 

	public  int incDdcYeta7100_YE161030_2022_CREATE_Update(InfcPkgYe161030_2022_VO infcPkgYe161030Vo) throws Exception;
	
	public  int incDdcYeta7300_YE169010_Tax_2022_06_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	 
	
	
	
}
