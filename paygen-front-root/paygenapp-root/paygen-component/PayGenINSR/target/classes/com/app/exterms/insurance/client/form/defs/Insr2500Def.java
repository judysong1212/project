package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2500BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr2500VO.java
 * @Description : Insr2500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2500Def  extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr2500Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Insr2500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */
listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr2500BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 작성년월 : retryYrMnth */
listColumnDefs.add(new ColumnDef("작성년월", Insr2500BM.ATTR_RETRYYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
listColumnDefs.add(new ColumnDef("고용보험상실_고용_일련번호", Insr2500BM.ATTR_SOCINSRLSSEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 사회보험작성일자 : soctyInsurCmptnDt */
listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr2500BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 부서코드 : deptCd */
listColumnDefs.add(new ColumnDef("부서코드", Insr2500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 성명 : nm */
listColumnDefs.add(new ColumnDef("성명", Insr2500BM.ATTR_NM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입사일자 : icncDt */
listColumnDefs.add(new ColumnDef("입사일자", Insr2500BM.ATTR_ICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 고용보험취득일자 : umytInsrAqtnDt */
listColumnDefs.add(new ColumnDef("고용보험취득일자", Insr2500BM.ATTR_UMYTINSRAQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직일자 : retryDt */
listColumnDefs.add(new ColumnDef("퇴직일자", Insr2500BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 고용보험이직사유코드 : umytInsrChgjbReasCd */
listColumnDefs.add(new ColumnDef("고용보험이직사유코드", Insr2500BM.ATTR_UMYTINSRCHGJBREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 고용보험구체적사유내용 : umytInsrSpecResnCtnt */
listColumnDefs.add(new ColumnDef("고용보험구체적사유내용", Insr2500BM.ATTR_UMYTINSRSPECRESNCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
listColumnDefs.add(new ColumnDef("통상피보험자단위기간일수", Insr2500BM.ATTR_USALYTISEDUNTPRIDNUMDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금계산총일수 : avgAmntCalcTotNumDys */
listColumnDefs.add(new ColumnDef("평균임금계산총일수", Insr2500BM.ATTR_AVGAMNTCALCTOTNUMDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금기본금금액 : avgAmntFndtnSum */
listColumnDefs.add(new ColumnDef("평균임금기본금금액", Insr2500BM.ATTR_AVGAMNTFNDTNSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금이외수당금액 : avgAmntEtcExtpySum */
listColumnDefs.add(new ColumnDef("평균임금이외수당금액", Insr2500BM.ATTR_AVGAMNTETCEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금상여금금액 : avgAmntAllwBnusSum */
listColumnDefs.add(new ColumnDef("평균임금상여금금액", Insr2500BM.ATTR_AVGAMNTALLWBNUSSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금연차수당금액 : avgAmntAnnlExtpySum */
listColumnDefs.add(new ColumnDef("평균임금연차수당금액", Insr2500BM.ATTR_AVGAMNTANNLEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금기타금액 : avgAmntEtcSum */
listColumnDefs.add(new ColumnDef("평균임금기타금액", Insr2500BM.ATTR_AVGAMNTETCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 평균임금액 : avgAmntQnty */
listColumnDefs.add(new ColumnDef("평균임금액", Insr2500BM.ATTR_AVGAMNTQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 통상임금액 : usalyAmntWag */
listColumnDefs.add(new ColumnDef("통상임금액", Insr2500BM.ATTR_USALYAMNTWAG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 기준임금액 : stdAmntWag */
listColumnDefs.add(new ColumnDef("기준임금액", Insr2500BM.ATTR_STDAMNTWAG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 1일소정근로시간 : dayFxdWorkTmNum */
listColumnDefs.add(new ColumnDef("1일소정근로시간", Insr2500BM.ATTR_DAYFXDWORKTMNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 퇴직금수령금액 : sevePayReipSum */
listColumnDefs.add(new ColumnDef("퇴직금수령금액", Insr2500BM.ATTR_SEVEPAYREIPSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 퇴직금외기타금액 : sevePayRstEtcSum */
listColumnDefs.add(new ColumnDef("퇴직금외기타금액", Insr2500BM.ATTR_SEVEPAYRSTETCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Insr2500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Insr2500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Insr2500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Insr2500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Insr2500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Insr2500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//private TextField<String> retryYrMnth;   /** column 작성년월 : retryYrMnth */
//
//private TextField<String> socInsrLssEmymtNum;   /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
//
//private TextField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
//
//private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//private TextField<String> nm;   /** column 성명 : nm */
//
//private TextField<String> icncDt;   /** column 입사일자 : icncDt */
//
//private TextField<String> umytInsrAqtnDt;   /** column 고용보험취득일자 : umytInsrAqtnDt */
//
//private TextField<String> retryDt;   /** column 퇴직일자 : retryDt */
//
//private TextField<String> umytInsrChgjbReasCd;   /** column 고용보험이직사유코드 : umytInsrChgjbReasCd */
//
//private TextField<String> umytInsrSpecResnCtnt;   /** column 고용보험구체적사유내용 : umytInsrSpecResnCtnt */
//
//private TextField<String> usalyTisedUntPridNumDys;   /** column 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
//
//private TextField<String> avgAmntCalcTotNumDys;   /** column 평균임금계산총일수 : avgAmntCalcTotNumDys */
//
//private TextField<String> avgAmntFndtnSum;   /** column 평균임금기본금금액 : avgAmntFndtnSum */
//
//private TextField<String> avgAmntEtcExtpySum;   /** column 평균임금이외수당금액 : avgAmntEtcExtpySum */
//
//private TextField<String> avgAmntAllwBnusSum;   /** column 평균임금상여금금액 : avgAmntAllwBnusSum */
//
//private TextField<String> avgAmntAnnlExtpySum;   /** column 평균임금연차수당금액 : avgAmntAnnlExtpySum */
//
//private TextField<String> avgAmntEtcSum;   /** column 평균임금기타금액 : avgAmntEtcSum */
//
//private TextField<String> avgAmntQnty;   /** column 평균임금액 : avgAmntQnty */
//
//private TextField<String> usalyAmntWag;   /** column 통상임금액 : usalyAmntWag */
//
//private TextField<String> stdAmntWag;   /** column 기준임금액 : stdAmntWag */
//
//private TextField<String> dayFxdWorkTmNum;   /** column 1일소정근로시간 : dayFxdWorkTmNum */
//
//private TextField<String> sevePayReipSum;   /** column 퇴직금수령금액 : sevePayReipSum */
//
//private TextField<String> sevePayRstEtcSum;   /** column 퇴직금외기타금액 : sevePayRstEtcSum */
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
