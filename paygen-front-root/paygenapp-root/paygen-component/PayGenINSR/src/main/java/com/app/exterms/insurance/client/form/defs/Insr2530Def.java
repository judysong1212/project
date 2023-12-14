package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2530BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr2530VO.java
 * @Description : Insr2530 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2530Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr2530Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr2530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 작성년월 : retryYrMnth */
	    	listColumnDefs.add(new ColumnDef("작성년월", Insr2530BM.ATTR_RETRYYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	    	listColumnDefs.add(new ColumnDef("고용보험상실_고용_일련번호", Insr2530BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 기준연장일련번호 : stdExtnnSeilNum */
	    	listColumnDefs.add(new ColumnDef("기준연장일련번호", Insr2530BM.ATTR_STDEXTNNSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 기준연장시작일자 : stdExtnnBgnnDt */
	    	listColumnDefs.add(new ColumnDef("기준연장시작일자", Insr2530BM.ATTR_STDEXTNNBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 기준연장종료일자 : stdExtnnEndDt */
	    	listColumnDefs.add(new ColumnDef("기준연장종료일자", Insr2530BM.ATTR_STDEXTNNENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 기준연장사유코드 : stdExtnnReasCd */
	    	listColumnDefs.add(new ColumnDef("기준연장사유코드", Insr2530BM.ATTR_STDEXTNNREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr2530BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr2530BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr2530BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr2530BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr2530BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr2530BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> retryYrMnth;   /** column 작성년월 : retryYrMnth */
//
//	    	private TextField<String> socInsrLssEmymtNum;   /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
//
//	    	private TextField<String> stdExtnnSeilNum;   /** column 기준연장일련번호 : stdExtnnSeilNum */
//
//	    	private TextField<String> stdExtnnBgnnDt;   /** column 기준연장시작일자 : stdExtnnBgnnDt */
//
//	    	private TextField<String> stdExtnnEndDt;   /** column 기준연장종료일자 : stdExtnnEndDt */
//
//	    	private TextField<String> stdExtnnReasCd;   /** column 기준연장사유코드 : stdExtnnReasCd */
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
