package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr5300BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr5300VO.java
 * @Description : Insr5300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5300Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr5300Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr5300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr5300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용번호", Insr5300BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험정산년도 : umytInsrClutYr */
	    	listColumnDefs.add(new ColumnDef("고용보험정산년도", Insr5300BM.ATTR_UMYTINSRCLUTYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 보험료부과구분코드 : prmmIposDivCd */
	    	listColumnDefs.add(new ColumnDef("보험료부과구분코드", Insr5300BM.ATTR_PRMMIPOSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험취득일자 : umytInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("고용보험취득일자", Insr5300BM.ATTR_UMYTINSRAQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험상실일자 : umytInsrLssDt */
	    	listColumnDefs.add(new ColumnDef("고용보험상실일자", Insr5300BM.ATTR_UMYTINSRLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험보수총액 : umytInsrPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("고용보험보수총액", Insr5300BM.ATTR_UMYTINSRPAYTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr5300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr5300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr5300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr5300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr5300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr5300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> umytInsrClutYr;   /** column 고용보험정산년도 : umytInsrClutYr */
//
//	    	private TextField<String> prmmIposDivCd;   /** column 보험료부과구분코드 : prmmIposDivCd */
//
//	    	private TextField<String> umytInsrAqtnDt;   /** column 고용보험취득일자 : umytInsrAqtnDt */
//
//	    	private TextField<String> umytInsrLssDt;   /** column 고용보험상실일자 : umytInsrLssDt */
//
//	    	private TextField<String> umytInsrPayTotAmnt;   /** column 고용보험보수총액 : umytInsrPayTotAmnt */
//
//	    	private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//	    	private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//	    	private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//	    	private TextField<String> ismt;   /** column 수정자 : ismt */
//
//	    	private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//	    	private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//	    	
	    }   
}
