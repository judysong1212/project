package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1300BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr1300VO.java
 * @Description : Insr1300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1300Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr1300Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Insr1300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */
listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 사회보험작성일자 : soctyInsurCmptnDt */
listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1300BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1300BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 국민연금소득월액 : natPennIncmMnthAmnt */
listColumnDefs.add(new ColumnDef("국민연금소득월액", Insr1300BM.ATTR_NATPENNINCMMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
listColumnDefs.add(new ColumnDef("건강보험보수월액", Insr1300BM.ATTR_HLTHINSRMNTHRUNTNAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 고용보험보수월액 : umytInsrPayMnthAmnt */
listColumnDefs.add(new ColumnDef("고용보험보수월액", Insr1300BM.ATTR_UMYTINSRPAYMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
listColumnDefs.add(new ColumnDef("산재보험보수월액", Insr1300BM.ATTR_IDTLACCDTPAYMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 비고 : note */
listColumnDefs.add(new ColumnDef("비고", Insr1300BM.ATTR_NOTE, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Insr1300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Insr1300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Insr1300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Insr1300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Insr1300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Insr1300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
//
//private TextField<String> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
//
//private TextField<String> natPennIncmMnthAmnt;   /** column 국민연금소득월액 : natPennIncmMnthAmnt */
//
//private TextField<String> hlthInsrMnthRuntnAmnt;   /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
//
//private TextField<String> umytInsrPayMnthAmnt;   /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
//
//private TextField<String> idtlAccdtPayMnthAmnt;   /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
//
//private TextField<String> note;   /** column 비고 : note */
//
//private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//private TextField<String> ismt;   /** column 수정자 : ismt */
//
//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
	    }   
    
}
