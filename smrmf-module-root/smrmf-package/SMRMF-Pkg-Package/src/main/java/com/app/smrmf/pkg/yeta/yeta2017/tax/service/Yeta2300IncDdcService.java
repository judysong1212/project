package com.app.smrmf.pkg.yeta.yeta2017.tax.service;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;

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
public interface Yeta2300IncDdcService {
	 
	public int incDdcYeta2017_B101Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	 
	// 의료비정리 합계
	public int incDdcYeta2017_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
      
	
	public int incDdcYeta2017_C101Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	

	public int incDdcYeta2017_C101Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	 
	public int incDdcYeta2017_L102Y_YE165020_Delete(InfcPkgYe165020VO infcPkgYe165020Vo) throws Exception; 
		
	public String incDdcYeta2017_L102Y_YE165020_Insert(InfcPkgYe165020VO infcPkgYe165020Vo) throws Exception; 
	

    public int incDdcYeta2017_L102Y_YE165030_Delete(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception;
	
    public String incDdcYeta2017_L102Y_YE165030_Insert(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception; 
	 
    public int incDdcYeta2017_L102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	
    public int incDdcYeta2017_L102Y_YE161040_2017_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception; 
     
    public int incDdcYeta2017_L102Y_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception; 
	 
	public int incDdcYeta2017_D101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	 

	public int incDdcYeta2017_E102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2017_F102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	

	public int incDdcYeta2017_J301Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
		

	public int incDdcYeta2017_N101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	
	
	public int incDdcYeta2017_YE161055_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception; 
	
	
	//종사업장 정리 
	public int delete_YETA2300_2017_Ye161055(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception; 
	public String insert_YETA2300_2017_Ye161055(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception; 
	
	 
	
	
	public int incDdcYeta2017_YE161050_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception; 
	
	 

	public int incDdcYeta2017_G106Y_YE166020_Update(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception;  
	

	public int incDdcYeta2017_G106Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2017_G206Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	

	public int incDdcYeta2017_G306Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	
	
	
	public int incDdcYeta2017_YE166010_2017_CREATE_Delete(InfcPkgYe166010VO infcPkgYe166010Vo) throws Exception; 

	public int incDdcYeta2017_G106Y_YE166020_Delete(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception;  
	
	public int incDdcYeta2017_YE166020_2017_CREATE_Delete(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception;  
	
	
	 
	public String incDdcYeta2017_YE166020_2017_CREATE_Insert(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception;
	
	public String incDdcYeta2017_YE166010_2017_CREATE_Insert(InfcPkgYe166010VO infcPkgYe166010Vo) throws Exception; 
	  
	public int incDdcYeta2017_A102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	 

	public int incDdcYeta2017_YE161040_2017_INSU_FETC_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception;
	
	public int incDdcYeta2017_YE161040_2017_INSU_FETC01_Update(InfcPkgYe161060VO infcPkgYe161060Vo)  throws Exception;
	
	
	public int incDdcYeta2017_All_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception;
	public int incDdcYeta2017_All_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception;
	
	public int incDdcYeta2017_All_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception;
	 

	public  int incDdcYeta2100_YE161030_2017_CREATE_Update(InfcPkgYe161030VO infcPkgYe161030Vo) throws Exception;
	
	public  int incDdcYeta2300_YE169010_Tax_2017_06_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	 
	
	
	
}
