package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3300BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr3300VO.java
 * @Description : Insr3300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3300Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr3300Def(){
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고지년월 : nofctYrMnth */
	    	listColumnDefs.add(new ColumnDef("고지년월", Insr3300BM.ATTR_NOFCTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고지차수 : nofctDspty */
	    	listColumnDefs.add(new ColumnDef("고지차수", Insr3300BM.ATTR_NOFCTDSPTY, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용번호", Insr3300BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 공제년월 : dducYrMnth */
	    	listColumnDefs.add(new ColumnDef("공제년월", Insr3300BM.ATTR_DDUCYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험처리일자 : hlthInsrPrcsDt */
	    	listColumnDefs.add(new ColumnDef("건강보험처리일자", Insr3300BM.ATTR_HLTHINSRPRCSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험처리여부 : hlthInsrPrcsYn */
	    	listColumnDefs.add(new ColumnDef("건강보험처리여부", Insr3300BM.ATTR_HLTHINSRPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험보험료차액 : hlthInsrPrmmSrd */
	    	listColumnDefs.add(new ColumnDef("건강보험보험료차액", Insr3300BM.ATTR_HLTHINSRPRMMSRD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 장기요양보험차액 : lgtmRcptnInsurSrd */
	    	listColumnDefs.add(new ColumnDef("장기요양보험차액", Insr3300BM.ATTR_LGTMRCPTNINSURSRD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험정산보험료 : yrtxPrmm */
	    	listColumnDefs.add(new ColumnDef("건강보험정산보험료", Insr3300BM.ATTR_YRTXPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
	    	listColumnDefs.add(new ColumnDef("장기요양정산보험료", Insr3300BM.ATTR_LGTMRCPTNYRTXPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 건강보험환급금이자 : hlthInsrRefdItrt */
	    	listColumnDefs.add(new ColumnDef("건강보험환급금이자", Insr3300BM.ATTR_HLTHINSRREFDITRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
	    	listColumnDefs.add(new ColumnDef("장기요양보험환급금이자", Insr3300BM.ATTR_LGTMRCPTNINSURREFDITRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 차액합계 : srdAggrSum */
	    	listColumnDefs.add(new ColumnDef("차액합계", Insr3300BM.ATTR_SRDAGGRSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 분할납부구분코드 : divdPymtDivCd */
	    	listColumnDefs.add(new ColumnDef("분할납부구분코드", Insr3300BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 분할납부횟수 : divdPymt */
	    	listColumnDefs.add(new ColumnDef("분할납부횟수", Insr3300BM.ATTR_DIVDPYMT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr3300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr3300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr3300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr3300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr3300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr3300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});

//	    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    	private TextField<String> nofctYrMnth;   /** column 고지년월 : nofctYrMnth */
//
//	    	private TextField<String> nofctDspty;   /** column 고지차수 : nofctDspty */
//
//	    	private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//	    	private TextField<String> dducYrMnth;   /** column 공제년월 : dducYrMnth */
//
//	    	private TextField<String> hlthInsrPrcsDt;   /** column 건강보험처리일자 : hlthInsrPrcsDt */
//
//	    	private TextField<String> hlthInsrPrcsYn;   /** column 건강보험처리여부 : hlthInsrPrcsYn */
//
//	    	private TextField<String> hlthInsrPrmmSrd;   /** column 건강보험보험료차액 : hlthInsrPrmmSrd */
//
//	    	private TextField<String> lgtmRcptnInsurSrd;   /** column 장기요양보험차액 : lgtmRcptnInsurSrd */
//
//private TextField<String> yrtxPrmm;   /** column 건강보험정산보험료 : yrtxPrmm */
//
//private TextField<String> lgtmRcptnYrtxPrmm;   /** column 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
//
//	    	private TextField<String> hlthInsrRefdItrt;   /** column 건강보험환급금이자 : hlthInsrRefdItrt */
//
//	    	private TextField<String> lgtmRcptnInsurRefdItrt;   /** column 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
//
//	    	private TextField<String> srdAggrSum;   /** column 차액합계 : srdAggrSum */
//
//	    	private TextField<String> divdPymtDivCd;   /** column 분할납부구분코드 : divdPymtDivCd */
//
//	    	private TextField<String> divdPymt;   /** column 분할납부횟수 : divdPymt */
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
