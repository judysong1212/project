package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr5200BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr5200VO.java
 * @Description : Insr5200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5200Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    public Insr5200Def(){
	        setDaoClass("");
	        setCustomListMethod(CLASS_INSR5200TOINSR5200_DAO_LIST);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setFilterFormType(FILTER_FORM_SINGLE);

            setColumnsDefinition(getInsr5200());
		 
	    }   
	    
	    
	    public List<ColumnDef> getInsr5200() {
	    	
	    	List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	    	
	    	/** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr5200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr5200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 납부년월 : dducYrMnth */
	    	listColumnDefs.add(new ColumnDef("납부년월", Insr5200BM.ATTR_DDUCYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr5200BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 부과년월 : iposYrMnth */
	    	listColumnDefs.add(new ColumnDef("부과년월", Insr5200BM.ATTR_IPOSYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 한글성명 : hanNm */
	    	listColumnDefs.add(new ColumnDef("한글성명", Insr5200BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 주민등록번호 : resnRegnNum */
	    	listColumnDefs.add(new ColumnDef("주민등록번호", Insr5200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용시작일자 : umytInsrBgnnDt */
	    	listColumnDefs.add(new ColumnDef("고용시작일자", Insr5200BM.ATTR_UMYTINSRBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용종료일자 : umytInsrEndDt */
	    	listColumnDefs.add(new ColumnDef("고용종료일자", Insr5200BM.ATTR_UMYTINSRENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험급여공제년월 : umytPayrDducYrMnth */
	    	listColumnDefs.add(new ColumnDef("공제년월", Insr5200BM.ATTR_UMYTPAYRDDUCYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험처리일자 : umytInsrPrcsDt */
	    	listColumnDefs.add(new ColumnDef("처리일자", Insr5200BM.ATTR_UMYTINSRPRCSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험처리여부 : umytInsrPrcsYn */
	    	listColumnDefs.add(new ColumnDef("반영", Insr5200BM.ATTR_UMYTINSRPRCSYN, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 월평균보수월액 : mnthAvgPayMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("월평균보수월액", Insr5200BM.ATTR_MNTHAVGPAYMNTHAMNT, ColumnDef.TYPE_LONG , 120, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
	    	listColumnDefs.add(new ColumnDef("산정_근로자실업급여보험금액", Insr5200BM.ATTR_CMPTTNWKPPUNEPLRTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
	    	listColumnDefs.add(new ColumnDef("산정_사업주실업급여보험금액", Insr5200BM.ATTR_CMPTTNEPLRUNEPLRTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
	    	listColumnDefs.add(new ColumnDef("산정_사업주고안직능보험금액", Insr5200BM.ATTR_CMPTTNEPLRFNCDSNINSURSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
	    	listColumnDefs.add(new ColumnDef("재산정_근로자실업급여보험금액", Insr5200BM.ATTR_RECPTTNWKPPUNEPLRTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
	    	listColumnDefs.add(new ColumnDef("재산정_사업주실럽급여보험금액", Insr5200BM.ATTR_RECPTTNEPLRUNEPLRTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
	    	listColumnDefs.add(new ColumnDef("재산정_사업주고안직능보험금액", Insr5200BM.ATTR_RECPTTNEPLRFNCDSNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 정산보수총액 : clutPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("정산보수총액", Insr5200BM.ATTR_CLUTPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
	    	listColumnDefs.add(new ColumnDef("정산_근로자실업급여보험금액", Insr5200BM.ATTR_CLUTWKPPUNEPLRTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
	    	listColumnDefs.add(new ColumnDef("정산_사업주실업급여보험금액", Insr5200BM.ATTR_CLUTEPLRUNEPLRTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
	    	listColumnDefs.add(new ColumnDef("정산_사업주실업고안직능보험금액", Insr5200BM.ATTR_CLUTEPLRFNCDSNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험요율 : umytInsrApmrt */
	    	listColumnDefs.add(new ColumnDef("고용보험요율", Insr5200BM.ATTR_UMYTINSRAPMRT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 급여산출고용보험금액 : payCalcEmymtInsurSum */
	    	listColumnDefs.add(new ColumnDef("급여산출금액", Insr5200BM.ATTR_PAYCALCEMYMTINSURSUM, ColumnDef.TYPE_LONG , 120, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
	    	listColumnDefs.add(new ColumnDef("공단산출금액", Insr5200BM.ATTR_INDVUNEPLRTPYMTAGGRSUM, ColumnDef.TYPE_LONG , 120, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
	    	listColumnDefs.add(new ColumnDef("사업주실업급여보험합계금액", Insr5200BM.ATTR_EPLRUNEPLRTPYMTAGGRSUM, ColumnDef.TYPE_LONG , 120, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
	    	listColumnDefs.add(new ColumnDef("사업주고안직능보험합계금액", Insr5200BM.ATTR_EPLRFNCDSNAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});


	    	/** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
	    	listColumnDefs.add(new ColumnDef("고용보험차액", Insr5200BM.ATTR_UMYTINSRPRMMSRD, ColumnDef.TYPE_LONG , 120, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 분할납부구분코드 : divdPymtDivCd */
	    	listColumnDefs.add(new ColumnDef("분할납부구분코드", Insr5200BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 분할납부횟수 : divdPymt */
	    	listColumnDefs.add(new ColumnDef("분할납부횟수", Insr5200BM.ATTR_DIVDPYMT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr5200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr5200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr5200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr5200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr5200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr5200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	
	    	return listColumnDefs;
		}
	    
	    
	    
}
