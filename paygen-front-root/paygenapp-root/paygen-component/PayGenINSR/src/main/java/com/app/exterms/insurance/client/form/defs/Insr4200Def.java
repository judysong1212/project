package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr4100BM;
import com.app.exterms.insurance.client.dto.Insr4200BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr4200VO.java
 * @Description : Insr4200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4200Def  extends TableDef implements InsrDaoConstants {
	
	private int row = 0;
	
	private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	        
    public Insr4200Def(String chkDef){
    	  if ("INSR3150".equals(chkDef)) {
    	        setDaoClass("");
    	        setCustomListMethod(CLASS_INSR3150TOINSR4200_DAO_LIST);
    	        setAutoFillGrid(false);
    	        setShowFilterToolbar(false);
    	        setCheckBoxOnGridRows(true); 
               
              setColumnsDefinition(getInsr3200ToInsr4300());
              
          }  
    }	

    public List<ColumnDef> getInsr3200ToInsr4300() {
    	
    	List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    	
    	/** column 공제년월 : dducYrMnth */
    	listColumnDefs.add(new ColumnDef("공제년월", Insr4200BM.ATTR_DDUCYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	
	    	}
    	});
    	
    	/** column 부서코드 : deptNm */
    	listColumnDefs.add(new ColumnDef("부서", Insr4100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 140, false, true, false){
	    	{
	    		setReadOnly(true);
	    	}
    	});
    	
    	/** column 한글성명 : hanNm */
    	listColumnDefs.add(new ColumnDef("한글성명", Insr4200BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
    	});
    	/** column 주민등록번호 : resnRegnNum */
    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr4200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
    	});
    	
    	/** column 국민연금급여공제년월 : natPayrDducYrMnth */
    	listColumnDefs.add(new ColumnDef("공제년월", Insr4200BM.ATTR_NATPAYRDDUCYRMNTH, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
    	}); 	
    	
    	/** column 반영여부 : NATINSRPRCSYN */
    	listColumnDefs.add(new ColumnDef("반영", Insr4200BM.ATTR_NATINSRPRCSYN, ColumnDef.TYPE_STRING , 60, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
    	});
    	
    	/** column 국민연금기호번호 : natPennSymNum */
    	listColumnDefs.add(new ColumnDef("연금기호번호", Insr4200BM.ATTR_NATPENNSYMNUM, ColumnDef.TYPE_STRING , 110, true, true, true){
    		{

    		}
    	});
    	/** column 연금급여산출보험금액 : natPennPayCalcSum */
    	listColumnDefs.add(new ColumnDef("급여산출보험료", Insr4200BM.ATTR_NATPENNPAYCALCSUM, ColumnDef.TYPE_LONG , 110, true, true, true){
    		{

    		}
    	});
    	
    	/** column 본인소급보험료 : reattyQnty */
//    	listColumnDefs.add(new ColumnDef("공단소급보험료", Insr4200BM.ATTR_REATTYQNTY, ColumnDef.TYPE_LONG , 110, true, true, true){
//	    	{
//	
//	    	}
//    	});
    	/** column 본인정산보험료 : hmlfClutPrmm */
//    	listColumnDefs.add(new ColumnDef("공단정산보험료", Insr4200BM.ATTR_HMLFCLUTPRMM, ColumnDef.TYPE_LONG , 110, true, true, true){
//	    	{
//	
//	    	}
//    	});
    	
    	
    	
    	/** column 본인납부보험료계 : aggr */
    	listColumnDefs.add(new ColumnDef("공단산출보험료", Insr4200BM.ATTR_AGGR, ColumnDef.TYPE_LONG , 110, true, true, true){
	    	{
	
	    	}
    	});   	
    	

    	
    	/** column 국민연금차액 : NATINSRPRMMSRD */
    	listColumnDefs.add(new ColumnDef("산출차액", Insr4200BM.ATTR_NATINSRPRMMSRD, ColumnDef.TYPE_LONG , 120, true, true, true){
	    	{
	
	    	}
    	});   	
    	
    	
    	
    	
    	
    	
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Insr4200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	    	}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr4200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	    	}
    	});

    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서", Insr4100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	    	{
	    		setReadOnly(true);
	    	}
    	});


    	/** column 고용일련번호 : emymtSeilNum */
    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr4200BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});

    	/** column 주민등록번호 : secRegnNum */
    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr4200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
	    	{
	    		setReadOnly(true);
	    	}
    	});


    	/** column 신고소득총액 : regrstIncmTotAmnt */
    	listColumnDefs.add(new ColumnDef("신고소득총액", Insr4200BM.ATTR_REGRSTINCMTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 결정기준소득월액 : deinStdIncmMnthAmnt */
    	listColumnDefs.add(new ColumnDef("결정기준소득월액", Insr4200BM.ATTR_DEINSTDINCMMNTHAMNT, ColumnDef.TYPE_LONG , 120, true, false, true){
	    	{
	    		setReadOnly(true);
	    	}
    	});
    	
    	/** column 결정월보험료 : deinMnthPrmm */
    	listColumnDefs.add(new ColumnDef("결정월보험료", Insr4200BM.ATTR_DEINMNTHPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 본인부담액 : indvBrdnSum */
    	listColumnDefs.add(new ColumnDef("산출액", Insr4200BM.ATTR_INDVBRDNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 본인부담액 : indvBrdnSum */
    	listColumnDefs.add(new ColumnDef("본인부담액", Insr4200BM.ATTR_INDVBRDNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 본인소급보험료 : reattyQnty */
    	listColumnDefs.add(new ColumnDef("본인소급보험료", Insr4200BM.ATTR_REATTYQNTY, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 본인정산보험료 : hmlfClutPrmm */
    	listColumnDefs.add(new ColumnDef("본인정산보험료", Insr4200BM.ATTR_HMLFCLUTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});

    	/** column 본인보험료계 : hmlfPrmmAggr */
    	listColumnDefs.add(new ColumnDef("본인보험료계", Insr4200BM.ATTR_HMLFPRMMAGGR, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});

    	/** column 사업장부담액 : dpobBrdnSum */
    	listColumnDefs.add(new ColumnDef("사업장부담액", Insr4200BM.ATTR_DPOBBRDNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 사업자정산보험료 : busoprClutPrmm */
    	listColumnDefs.add(new ColumnDef("사업자정산보험료", Insr4200BM.ATTR_BUSOPRCLUTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 사업자소급보험료 : busoprReattyPrmm */
    	listColumnDefs.add(new ColumnDef("사업자소급보험료", Insr4200BM.ATTR_BUSOPRREATTYPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 사업자보험료계 : busoprPrmmAggr */
    	listColumnDefs.add(new ColumnDef("사업자보험료계", Insr4200BM.ATTR_BUSOPRPRMMAGGR, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
    	});

    	/** column 변동구분 : fluc */
    	listColumnDefs.add(new ColumnDef("변동구분", Insr4200BM.ATTR_FLUC, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 취득월납부여부 : aqtnMnthPymtYn */
    	listColumnDefs.add(new ColumnDef("취득월납부여부", Insr4200BM.ATTR_AQTNMNTHPYMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 변동일자 : flucDt */
    	listColumnDefs.add(new ColumnDef("변동일자", Insr4200BM.ATTR_FLUCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 변동사유내용 : flucReasCtnt */
    	listColumnDefs.add(new ColumnDef("변동사유내용", Insr4200BM.ATTR_FLUCREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 공단직권결정여부 : pbcorpOautyDeinYn */
    	listColumnDefs.add(new ColumnDef("공단직권결정여부", Insr4200BM.ATTR_PBCORPOAUTYDEINYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Insr4200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Insr4200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", Insr4200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", Insr4200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", Insr4200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", Insr4200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
    	});

    	return listColumnDefs;
	}
    
}
