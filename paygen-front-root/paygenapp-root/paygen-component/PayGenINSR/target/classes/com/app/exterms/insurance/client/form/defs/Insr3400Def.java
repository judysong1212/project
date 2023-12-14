package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3100BM;
import com.app.exterms.insurance.client.dto.Insr3400BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr3400VO.java
 * @Description : Insr3400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3400Def  extends TableDef implements InsrDaoConstants {
	private int row = 0;
	private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	
	public Insr3400Def(String chkDef) {
		if("INSR4300".equals(chkDef)) {
			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_INSR4300TOINSR3400_DAO_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(false);
			//setCellModel(true);
			setColumnsDefinition(getInsr4300ToInsr3400ColumnsList());
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
	private List<ColumnDef> getInsr4300ToInsr3400ColumnsList() {
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Insr3400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("정산년월", Insr3400BM.ATTR_NOFCTYRMNTHNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 고용일련번호 : emymtSeilNum */
    	listColumnDefs.add(new ColumnDef("고용번호", Insr3400BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
    	/** column 휴퇴직정산일련번호 : levfAbncRetryClutNum */
    	listColumnDefs.add(new ColumnDef("휴퇴직정산일련번호", Insr3400BM.ATTR_LEVFABNCRETRYCLUTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Insr3100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 성명 : nm */
		listColumnDefs.add(new ColumnDef("성명", Insr3100BM.ATTR_NM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 주민등록번호 : secRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false) {
			{
				
			}
		});
    	/** column 정산시작일자 : clutBgnnDt */
    	listColumnDefs.add(new ColumnDef("정산시작일자", Insr3400BM.ATTR_CLUTBGNNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{

    		}
    	});
    	/** column 퇴직일자 : retryDt */
    	listColumnDefs.add(new ColumnDef("퇴직일자", Insr3400BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{

    		}
    	});
    	/** column 근무월수 : dutyMnthIcm */
    	listColumnDefs.add(new ColumnDef("근무월수", Insr3400BM.ATTR_DUTYMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강보수총액 : hlthNumCpisTotAmnt */
    	listColumnDefs.add(new ColumnDef("건강보수총액", Insr3400BM.ATTR_HLTHNUMCPISTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강보수월액 : hlthPayMnthAmnt */
    	listColumnDefs.add(new ColumnDef("건강보수월액", Insr3400BM.ATTR_HLTHPAYMNTHAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 기납부_건강보험료 : alpayHlthPrmm */
    	listColumnDefs.add(new ColumnDef("건강보험료", Insr3400BM.ATTR_ALPAYHLTHPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 기납부_장기요양보험료 : alpayLgtmRcptnPrmm */
    	listColumnDefs.add(new ColumnDef("장기요양보험료", Insr3400BM.ATTR_ALPAYLGTMRCPTNPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 기납부_합계 : alpayAggrSum */
    	listColumnDefs.add(new ColumnDef("합계", Insr3400BM.ATTR_ALPAYAGGRSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강확정보험료 : hlthFixPrmm */
    	listColumnDefs.add(new ColumnDef("건강확정보험료", Insr3400BM.ATTR_HLTHFIXPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 감면월수 : reduMnthIcm */
    	listColumnDefs.add(new ColumnDef("감면월수", Insr3400BM.ATTR_REDUMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강_감면_조정보험료 : hlthReduAdmntPrmm */
    	listColumnDefs.add(new ColumnDef("건강_감면_조정보험료", Insr3400BM.ATTR_HLTHREDUADMNTPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 실근무월수 : turtyDutyMnthIcm */
    	listColumnDefs.add(new ColumnDef("실근무월수", Insr3400BM.ATTR_TURTYDUTYMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강산정보험료 : hlthCmpttnPrmm */
    	listColumnDefs.add(new ColumnDef("건강산정보험료", Insr3400BM.ATTR_HLTHCMPTTNPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강정산보험료 : hlthClutPrmm */
    	listColumnDefs.add(new ColumnDef("건강정산보험료", Insr3400BM.ATTR_HLTHCLUTPRMM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
    		{

    		}
    	});
    	/** column 분할납부구분코드 : divdPymtDivCd */
    	listColumnDefs.add(new ColumnDef("분할납부구분코드", Insr3400BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 분할납부횟수 : divdPymt */
    	listColumnDefs.add(new ColumnDef("분할납부횟수", Insr3400BM.ATTR_DIVDPYMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
    		{

    		}
    	});
    	/** column 공제년월 : dducYrMnth */
    	listColumnDefs.add(new ColumnDef("공제년월", Insr3400BM.ATTR_DDUCYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강연말정산처리일자 : hlthYrtxPrcsDt */
    	listColumnDefs.add(new ColumnDef("건강연말정산처리일자", Insr3400BM.ATTR_HLTHYRTXPRCSDT, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{

    		}
    	});
    	/** column 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
    	listColumnDefs.add(new ColumnDef("건강보험연말정산처리여부", Insr3400BM.ATTR_HLTHINSRYRTXPRCSYN, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{

    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Insr3400BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Insr3400BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", Insr3400BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", Insr3400BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", Insr3400BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", Insr3400BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 공제년월 : dducYrMnth */
    	listColumnDefs.add(new ColumnDef("공제년월", Insr3400BM.ATTR_DDUCYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	return listColumnDefs;
	}
}