package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2520BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr1400VO.java
 * @Description : Insr1400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2400Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	    
	    final PrgmComBass0300DTO sysComBass0300Dto;
	    
	    public Insr2400Def(String chkDef){ 
	    	
	     	 sysComBass0300Dto = new PrgmComBass0300DTO();  
	     	 
	       if("Insr2400".equals(chkDef)) {
			   
	      		setTitle("");
	 	        setDaoClass("");
	 	        setCustomListMethod(CLASS_INSRP230006TOINSR2520_DAO_LIST);
	 	        setAutoFillGrid(false);
	 	        setShowFilterToolbar(false);
	 	        setCheckBoxOnGridRows(true);
	 	        setFilterFormType(FILTER_FORM_SINGLE);
	 	         	 
		   	   setColumnsDefinition(getInsr2400ToInsr2500()) ;
		   }
	    }     	 
	       
     public List<ColumnDef> getInsr2400ToInsr2500(){	 
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	      

	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", Insr2520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 작성년월 : retryYrMnth */
	        listColumnDefs.add(new ColumnDef("작성년월", Insr2520BM.ATTR_RETRYYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	        listColumnDefs.add(new ColumnDef("고용보험상실_고용_일련번호", Insr2520BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 산정대상기간일련번호 : cmpttnTgtPridSeilNum */
	        listColumnDefs.add(new ColumnDef("순번", Insr2520BM.ATTR_CMPTTNTGTPRIDSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 30, true, true, true){
	        	{

	        	}
	        });
	        /** column 산정대상시작일자 : cmpttnTgtBgnnDt */
	        listColumnDefs.add(new ColumnDef("시작일자", Insr2520BM.ATTR_CMPTTNTGTBGNNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 산정대상종료일자 : cmpttnTgtEndDt */
	        listColumnDefs.add(new ColumnDef("종료일자", Insr2520BM.ATTR_CMPTTNTGTENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 임금지급기초일수 : amntPymtNumDys */
	        listColumnDefs.add(new ColumnDef("임금지급기초일수", Insr2520BM.ATTR_AMNTPYMTNUMDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 입력자 : kybdr */
	        listColumnDefs.add(new ColumnDef("입력자", Insr2520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 입력일자 : inptDt */
	        listColumnDefs.add(new ColumnDef("입력일자", Insr2520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 입력주소 : inptAddr */
	        listColumnDefs.add(new ColumnDef("입력주소", Insr2520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 수정자 : ismt */
	        listColumnDefs.add(new ColumnDef("수정자", Insr2520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 수정일자 : revnDt */
	        listColumnDefs.add(new ColumnDef("수정일자", Insr2520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 수정주소 : revnAddr */
	        listColumnDefs.add(new ColumnDef("수정주소", Insr2520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	      
			
			 return listColumnDefs;
			 
	    }  
     
    
}
