package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3200BM;
import com.app.exterms.insurance.client.dto.Insr3300BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr3200VO.java
 * @Description : Insr3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3200Def extends TableDef implements InsrDaoConstants {
	private int row = 0;
	private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	
	public Insr3200Def(String chkDef) {
		if("INSR4200".equals(chkDef)) {
			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_INSR4200TOINSR3200_DAO_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getInsr4200ToInsr3200());
		}else if("INSRP420001".equals(chkDef)) {
			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_INSRP420001TOINSR3200_DAO_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getInsrP420001ToInsr3200());
		} else {
			setTitle("");
			setDaoClass("");
			setCustomListMethod("");
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setFilterFormType(FILTER_FORM_SINGLE);
		}
	}
	
	public List<ColumnDef> getInsr4200ToInsr3200() {
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
		
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true) {
    		{
    			
    		}
    	});
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr3200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 고지년월 : nofctYrMnth */
		listColumnDefs.add(new ColumnDef("고지년월", Insr3200BM.ATTR_NOFCTYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 고지차수 : nofctDspty */
		listColumnDefs.add(new ColumnDef("고지차수", Insr3200BM.ATTR_NOFCTDSPTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 고용일련번호 : emymtSeilNum */
    	listColumnDefs.add(new ColumnDef("고용번호", Insr3200BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
    		{

    		}
    	});
		/** column 사업장관리번호 : dpobMangeNum */
		listColumnDefs.add(new ColumnDef("사업장관리번호", Insr3200BM.ATTR_DPOBMANGENUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 단위기관코드 : untIstutCd */
		listColumnDefs.add(new ColumnDef("단위기관코드", Insr3200BM.ATTR_UNTISTUTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 회계부호 : accSgn */
		listColumnDefs.add(new ColumnDef("회계부호", Insr3200BM.ATTR_ACCSGN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 건강보험증번호 : hlthInsrCertNum */
		listColumnDefs.add(new ColumnDef("증번호", Insr3200BM.ATTR_HLTHINSRCERTNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 한글성명 : hanNm */
		listColumnDefs.add(new ColumnDef("성명", Insr3200BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 주민등록번호 : secRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
			{
				
			}
		});
		/** column 감면사유코드 : reduReasCd */
		listColumnDefs.add(new ColumnDef("감면사유코드", Insr3200BM.ATTR_REDUREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 감면사유 : reduReasNm */
		listColumnDefs.add(new ColumnDef("감면사유", Insr3200BM.ATTR_REDUREASNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 건강보험직종코드 : hlthInsrTypOccuCd */
		listColumnDefs.add(new ColumnDef("건강보험직종", Insr3200BM.ATTR_HLTHINSRTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 보수월액등급 : payMnthAmntGrde */
		listColumnDefs.add(new ColumnDef("보수월액등급", Insr3200BM.ATTR_PAYMNTHAMNTGRDE, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("보수월액", Insr3200BM.ATTR_PAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 공제년월 : dducYrMnth */
		listColumnDefs.add(new ColumnDef("공제년월", Insr3300BM.ATTR_DDUCYRMNTH, ColumnDef.TYPE_STRING , 70, true, true, true){
			{
				
			}
		});
		/** column 건강보험처리여부 : hlthInsrPrcsYn */
		listColumnDefs.add(new ColumnDef("반영여부", Insr3300BM.ATTR_HLTHINSRPRCSYN, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 산출보험료 : calcPrmm */
		listColumnDefs.add(new ColumnDef("산출액", Insr3200BM.ATTR_CALCPRMM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 공단산출보험료 : sanCalcPrmm */
		listColumnDefs.add(new ColumnDef("공단산출액", Insr3200BM.ATTR_SANCALCPRMM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 건강보험보험료차액 : hlthInsrPrmmSrd */
		listColumnDefs.add(new ColumnDef("차액", Insr3300BM.ATTR_HLTHINSRPRMMSRD, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 건강환급금이자 : hlthInsrRefdItrt */
		listColumnDefs.add(new ColumnDef("환급금이자", Insr3200BM.ATTR_HLTHINSRREFDITRT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 정산사유코드 : clutReasCd */
		listColumnDefs.add(new ColumnDef("정산사유코드", Insr3200BM.ATTR_CLUTREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 정산적용시작년월 : clutApptnBgnnYrMnth */
		listColumnDefs.add(new ColumnDef("정산적용시작년월", Insr3200BM.ATTR_CLUTAPPTNBGNNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 정산적용종료년월 : clutApptnEndYrMnth */
		listColumnDefs.add(new ColumnDef("정산적용종료년월", Insr3200BM.ATTR_CLUTAPPTNENDYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 정산보험료 : clutPrmm */
		listColumnDefs.add(new ColumnDef("정산보험료", Insr3200BM.ATTR_CLUTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 고지보험료 : nofctPrmm */
		listColumnDefs.add(new ColumnDef("고지보험료", Insr3200BM.ATTR_NOFCTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 연말정산보험료 : yrtxPrmm */
		listColumnDefs.add(new ColumnDef("연말정산보험료", Insr3200BM.ATTR_YRTXPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 취득일자 : aqtnDt */
		listColumnDefs.add(new ColumnDef("취득일자", Insr3200BM.ATTR_AQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 상실일자 : lssDt */
		listColumnDefs.add(new ColumnDef("상실일자", Insr3200BM.ATTR_LSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 요양산출보험료 : lgtmRcptnCalcPrmm */
		listColumnDefs.add(new ColumnDef("산출액", Insr3200BM.ATTR_LGTMRCPTNCALCPRMM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 공단요양산출보험료 : sanLgtmRcptnCalcPrmm */
		listColumnDefs.add(new ColumnDef("공단산출액", Insr3200BM.ATTR_SANLGTMRCPTNCALCPRMM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 장기요양보험차액 : lgtmRcptnInsurSrd */
		listColumnDefs.add(new ColumnDef("차액", Insr3300BM.ATTR_LGTMRCPTNINSURSRD, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 요양환급금이자 : lgtmRcptnRefdItrt */
		listColumnDefs.add(new ColumnDef("환급금이자", Insr3200BM.ATTR_LGTMRCPTNREFDITRT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 차액합계 : srdAggrSum */
		listColumnDefs.add(new ColumnDef("차액합계", Insr3300BM.ATTR_SRDAGGRSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		/** column 요양정산사유코드 : lgtmRcptnClutReasCd */
		listColumnDefs.add(new ColumnDef("요양정산사유코드", Insr3200BM.ATTR_LGTMRCPTNCLUTREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
		listColumnDefs.add(new ColumnDef("요양정산적용시작년월", Insr3200BM.ATTR_LGTMRCPTNAPPTNBGNNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
		listColumnDefs.add(new ColumnDef("요양정산적용종료년월", Insr3200BM.ATTR_LGTMRCPTNAPPTNENDYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 요양정산보험료 : lgtmRcptnClutPrmm */
		listColumnDefs.add(new ColumnDef("요양정산보험료", Insr3200BM.ATTR_LGTMRCPTNCLUTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 요양고지보험료 : lgtmRcptnNofctPrmm */
		listColumnDefs.add(new ColumnDef("요양고지보험료", Insr3200BM.ATTR_LGTMRCPTNNOFCTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
		listColumnDefs.add(new ColumnDef("요양연말정산보험료", Insr3200BM.ATTR_LGTMRCPTNYRTXPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
		listColumnDefs.add(new ColumnDef("건강_요양산출보험료계", Insr3200BM.ATTR_HLTHRCPTNCALCPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 건강_요양정산보험료계 : hlthRcptnClutPrmm */
		listColumnDefs.add(new ColumnDef("건강_요양정산보험료계", Insr3200BM.ATTR_HLTHRCPTNCLUTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
		listColumnDefs.add(new ColumnDef("건강_요양고지보험료계", Insr3200BM.ATTR_HLTHRCPTNNOFCTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
		listColumnDefs.add(new ColumnDef("건강_요양연말정산보험료계", Insr3200BM.ATTR_HLTHRCPTNYRTXPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
		/** column 총납부보험료 : totPymtPrmm */
		listColumnDefs.add(new ColumnDef("총납부보험료", Insr3200BM.ATTR_TOTPYMTPRMM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		}); 
		/** column 건강보험처리일자 : hlthInsrPrcsDt */
		listColumnDefs.add(new ColumnDef("처리일자", Insr3300BM.ATTR_HLTHINSRPRCSDT, ColumnDef.TYPE_STRING , 80, true, false, true){
			{
				
			}
		});
		/** column 분할납부구분코드 : divdPymtDivCd */
		listColumnDefs.add(new ColumnDef("분할납부", Insr3300BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 분할납부횟수 : divdPymt */
		listColumnDefs.add(new ColumnDef("분할납부횟수", Insr3300BM.ATTR_DIVDPYMT, ColumnDef.TYPE_LONG , 90, true, false, true){
			{
				
			}
		});
    	 return listColumnDefs;
    } 
	

	public List<ColumnDef> getInsrP420001ToInsr3200() {
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
		
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true) {
    		{
    			
    		}
    	});
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr3200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				
			}
		});
		/** column 고지년월 : nofctYrMnth */
		listColumnDefs.add(new ColumnDef("납부년월", Insr3200BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		
		/** column 한글성명 : hanNm */
		listColumnDefs.add(new ColumnDef("성명", Insr3200BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		/** column 주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("보수월액", Insr3200BM.ATTR_PAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("납부년월금액", Insr3200BM.ATTR_HLTHINSRMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("납부전월금액", Insr3200BM.ATTR_BEFOFRHLTHINSRMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("변동금액", Insr3200BM.ATTR_HLTHINSRGAPAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("납부년월금액", Insr3200BM.ATTR_HLTHRCPTNMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("납부전월금액", Insr3200BM.ATTR_BEFOREHLTHRCPTNMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
		
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("변동금액", Insr3200BM.ATTR_HLTHRCPTNGAPAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
				
			}
		});
    	 return listColumnDefs;
    } 
}
