package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr6500BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr6500VO.java
 * @Description : Insr6500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr6500Def  extends TableDef implements InsrDaoConstants {
	    private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr6500Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr6500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 납부년월 : pymtYrMnth */
	    	listColumnDefs.add(new ColumnDef("납부년월", Insr6500BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용구분코드 : emymtDivCd */
	    	listColumnDefs.add(new ColumnDef("고용구분코드", Insr6500BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 산재보험상세일련번호 : idtlAccdtInsurDtlPatrNum */
	    	listColumnDefs.add(new ColumnDef("산재보험상세일련번호", Insr6500BM.ATTR_IDTLACCDTINSURDTLPATRNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 부서코드 : deptCd */
	    	listColumnDefs.add(new ColumnDef("부서코드", Insr6500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 사업코드 : businCd */
	    	listColumnDefs.add(new ColumnDef("사업코드", Insr6500BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 산재보험인원수 : idtlAccdtInsrPeplNum */
	    	listColumnDefs.add(new ColumnDef("산재보험인원수", Insr6500BM.ATTR_IDTLACCDTINSRPEPLNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 보수총금액 : payTotSum */
	    	listColumnDefs.add(new ColumnDef("보수총금액", Insr6500BM.ATTR_PAYTOTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 산재보험요율 : idtlAccdtInsurApmrt */
	    	listColumnDefs.add(new ColumnDef("산재보험요율", Insr6500BM.ATTR_IDTLACCDTINSURAPMRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 산재보험납부금액 : idtlAccdtInsurPymtSum */
	    	listColumnDefs.add(new ColumnDef("산재보험납부금액", Insr6500BM.ATTR_IDTLACCDTINSURPYMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr6500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr6500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr6500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr6500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr6500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr6500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> pymtYrMnth;   /** column 납부년월 : pymtYrMnth */
//
//	    	private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//	    	private TextField<String> idtlAccdtInsurDtlPatrNum;   /** column 산재보험상세일련번호 : idtlAccdtInsurDtlPatrNum */
//
//	    	private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//	    	private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//	    	private TextField<String> idtlAccdtInsrPeplNum;   /** column 산재보험인원수 : idtlAccdtInsrPeplNum */
//
//	    	private TextField<String> payTotSum;   /** column 보수총금액 : payTotSum */
//
//	    	private TextField<String> idtlAccdtInsurApmrt;   /** column 산재보험요율 : idtlAccdtInsurApmrt */
//
//	    	private TextField<String> idtlAccdtInsurPymtSum;   /** column 산재보험납부금액 : idtlAccdtInsurPymtSum */
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
	    	
	    }   
}
