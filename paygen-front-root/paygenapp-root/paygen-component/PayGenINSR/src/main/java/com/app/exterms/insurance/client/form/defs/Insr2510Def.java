package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2510BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr2510VO.java
 * @Description : Insr2510 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2510Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr2510Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Insr2510BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */
listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2510BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
listColumnDefs.add(new ColumnDef("고용보험상실_고용_일련번호", Insr2510BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 작성년월 : retryYrMnth */
listColumnDefs.add(new ColumnDef("작성년월", Insr2510BM.ATTR_RETRYYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
listColumnDefs.add(new ColumnDef("퇴직금산정상세일련번호", Insr2510BM.ATTR_SEVEPAYDTLPATRNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 임금산정시작일자 : payPymtBgnnDt */
listColumnDefs.add(new ColumnDef("임금산정시작일자", Insr2510BM.ATTR_PAYPYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 임금산정종료일자 : payPymtEndDt */
listColumnDefs.add(new ColumnDef("임금산정종료일자", Insr2510BM.ATTR_PAYPYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 임금산정일수 : pymtNumDys */
listColumnDefs.add(new ColumnDef("임금산정일수", Insr2510BM.ATTR_PYMTNUMDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 임금_기본급금액 : amntBspySum */
listColumnDefs.add(new ColumnDef("임금_기본급금액", Insr2510BM.ATTR_AMNTBSPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 임금_이외수당금액 : amntEtcExtpySum */
listColumnDefs.add(new ColumnDef("임금_이외수당금액", Insr2510BM.ATTR_AMNTETCEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 임금_상여금액 : amntAllwBnusSum */
listColumnDefs.add(new ColumnDef("임금_상여금액", Insr2510BM.ATTR_AMNTALLWBNUSSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 임금_연차수당금액 : amntAnnlExtpySum */
listColumnDefs.add(new ColumnDef("임금_연차수당금액", Insr2510BM.ATTR_AMNTANNLEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 임금_기타금액 : amntEtcSum */
listColumnDefs.add(new ColumnDef("임금_기타금액", Insr2510BM.ATTR_AMNTETCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Insr2510BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Insr2510BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Insr2510BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Insr2510BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Insr2510BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Insr2510BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//private TextField<String> socInsrLssEmymtNum;   /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
//
//private TextField<String> retryYrMnth;   /** column 작성년월 : retryYrMnth */
//
//private TextField<String> sevePayDtlPatrNum;   /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
//
//private TextField<String> payPymtBgnnDt;   /** column 임금산정시작일자 : payPymtBgnnDt */
//
//private TextField<String> payPymtEndDt;   /** column 임금산정종료일자 : payPymtEndDt */
//
//private TextField<String> pymtNumDys;   /** column 임금산정일수 : pymtNumDys */
//
//private TextField<String> amntBspySum;   /** column 임금_기본급금액 : amntBspySum */
//
//private TextField<String> amntEtcExtpySum;   /** column 임금_이외수당금액 : amntEtcExtpySum */
//
//private TextField<String> amntAllwBnusSum;   /** column 임금_상여금액 : amntAllwBnusSum */
//
//private TextField<String> amntAnnlExtpySum;   /** column 임금_연차수당금액 : amntAnnlExtpySum */
//
//private TextField<String> amntEtcSum;   /** column 임금_기타금액 : amntEtcSum */
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
