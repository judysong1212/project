/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2019;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Pyyt0302BM;
import com.app.exterms.yearendtax.client.dto.yeta2019.Pyyt0304BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Pyyt0304Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Pyyt0304Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("YETA1900".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYeta1900ToPyyt0304ColumnsList());

		}else if ("YETA2900".equals(chkPayrDef)) {
			
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA2900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYeta2900ToPyyt0304ColumnsList());			
			
		}else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYeta1900ToPyyt0304ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYeta1900ToPyyt0304ColumnsList(){
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	
	    
	    
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", Pyyt0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 120, true, true, true){
	    	{
	
	    	}
	    });
	    
	    
	    
	    /** column 한글성명 : hanNm */
	    listColumnDefs.add(new ColumnDef("성명", Pyyt0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
	    	{
	
	    	}
	    });
	    /** column 주민등록번호 : resnRegnNum */
	    listColumnDefs.add(new ColumnDef("주민등록번호", Pyyt0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    });
	    
	    
	    
	    
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0304BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0304BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0304BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", Pyyt0304BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분코드", Pyyt0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", Pyyt0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("사업코드", Pyyt0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종코드", Pyyt0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종세통합코드", Pyyt0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직책코드 : odtyCd */
	    listColumnDefs.add(new ColumnDef("직책코드", Pyyt0304BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 호봉코드 : pyspCd */
	    listColumnDefs.add(new ColumnDef("호봉코드", Pyyt0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속년수코드 : logSvcYrNumCd */
	    listColumnDefs.add(new ColumnDef("근속년수코드", Pyyt0304BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속년수코드 : logSvcYrNumCd */
	    listColumnDefs.add(new ColumnDef("근속년수", Pyyt0304BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속월수코드 : logSvcMnthIcmCd */
	    listColumnDefs.add(new ColumnDef("근속월수코드", Pyyt0304BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속월수코드 : logSvcMnthIcmCd */
	    listColumnDefs.add(new ColumnDef("근속월수", Pyyt0304BM.ATTR_LOGSVCMNTHICMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 최초고용일자 : frstEmymtDt */
	    listColumnDefs.add(new ColumnDef("최초고용일자", Pyyt0304BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용시작일자 : emymtBgnnDt */
	    listColumnDefs.add(new ColumnDef("고용시작일자", Pyyt0304BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용종료일자 : emymtEndDt */
	    listColumnDefs.add(new ColumnDef("고용종료일자", Pyyt0304BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 재직구분코드 : hdofcDivCd */
	    listColumnDefs.add(new ColumnDef("재직구분코드", Pyyt0304BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 퇴직일자 : retryDt */
	    listColumnDefs.add(new ColumnDef("퇴직일자", Pyyt0304BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급총액 : pyytPymtTotAmnt */
	    listColumnDefs.add(new ColumnDef("지급총액", Pyyt0304BM.ATTR_PYYTPYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수당총액 : pyytExtpyTotAmnt */
	    listColumnDefs.add(new ColumnDef("수당총액", Pyyt0304BM.ATTR_PYYTEXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 과세총액 : pyytTxtnTotAmnt */
	    listColumnDefs.add(new ColumnDef("과세총액", Pyyt0304BM.ATTR_PYYTTXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 비과세총액 : pyytFreeDtyTotAmnt */
	    listColumnDefs.add(new ColumnDef("비과세총액", Pyyt0304BM.ATTR_PYYTFREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 공제총액 : pyytDducTotAmnt */
	    listColumnDefs.add(new ColumnDef("공제총액", Pyyt0304BM.ATTR_PYYTDDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 세금총액 : pyytTxTotAmnt */
	    listColumnDefs.add(new ColumnDef("세금총액", Pyyt0304BM.ATTR_PYYTTXTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 퇴직금지급여부 : pyytSevePayPymtYn */
	    listColumnDefs.add(new ColumnDef("퇴직금지급여부", Pyyt0304BM.ATTR_PYYTSEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 차인지급액 : pyytPernPymtSum */
	    listColumnDefs.add(new ColumnDef("차인지급액", Pyyt0304BM.ATTR_PYYTPERNPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0304BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0304BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0304BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0304BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0304BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0304BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    
	    
	    listColumnDefs.add(new ColumnDef("기본급", Pyyt0304BM.ATTR_PYYTB10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 소득세 : pymtT10100Sum */               
	    listColumnDefs.add(new ColumnDef("소득세", Pyyt0304BM.ATTR_PYYTT10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 주민세  : pymtT20100Sum */
	    listColumnDefs.add(new ColumnDef("주민세", Pyyt0304BM.ATTR_PYYTT20100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
	    	{
	
	    	}
	    });
	    
	    
	        
	        return listColumnDefs;
	    }
	    
	    

	private List<ColumnDef> getYeta2900ToPyyt0304ColumnsList(){
		
	    row = 0;
	    
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	    
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", Pyyt0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    });
	    
	    
	    /** column 한글성명 : hanNm */
	    listColumnDefs.add(new ColumnDef("성명", Pyyt0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
	    	{
	
	    	}
	    });
	    /** column 주민등록번호 : resnRegnNum */
	    listColumnDefs.add(new ColumnDef("주민등록번호", Pyyt0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    });
	    
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0304BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0304BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0304BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", Pyyt0304BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분코드", Pyyt0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", Pyyt0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("사업코드", Pyyt0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종코드", Pyyt0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종세통합코드", Pyyt0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직책코드 : odtyCd */
	    listColumnDefs.add(new ColumnDef("직책코드", Pyyt0304BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 호봉코드 : pyspCd */
	    listColumnDefs.add(new ColumnDef("호봉코드", Pyyt0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속년수코드 : logSvcYrNumCd */
	    listColumnDefs.add(new ColumnDef("근속년수코드", Pyyt0304BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속년수코드 : logSvcYrNumCd */
	    listColumnDefs.add(new ColumnDef("근속년수", Pyyt0304BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속월수코드 : logSvcMnthIcmCd */
	    listColumnDefs.add(new ColumnDef("근속월수코드", Pyyt0304BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속월수코드 : logSvcMnthIcmCd */
	    listColumnDefs.add(new ColumnDef("근속월수", Pyyt0304BM.ATTR_LOGSVCMNTHICMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 최초고용일자 : frstEmymtDt */
	    listColumnDefs.add(new ColumnDef("최초고용일자", Pyyt0304BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용시작일자 : emymtBgnnDt */
	    listColumnDefs.add(new ColumnDef("고용시작일자", Pyyt0304BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용종료일자 : emymtEndDt */
	    listColumnDefs.add(new ColumnDef("고용종료일자", Pyyt0304BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 재직구분코드 : hdofcDivCd */
	    listColumnDefs.add(new ColumnDef("재직구분코드", Pyyt0304BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 퇴직일자 : retryDt */
	    listColumnDefs.add(new ColumnDef("퇴직일자", Pyyt0304BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급총액 : pyytPymtTotAmnt */
	    listColumnDefs.add(new ColumnDef("지급총액", Pyyt0304BM.ATTR_PYYTPYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수당총액 : pyytExtpyTotAmnt */
	    listColumnDefs.add(new ColumnDef("수당총액", Pyyt0304BM.ATTR_PYYTEXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 과세총액 : pyytTxtnTotAmnt */
	    listColumnDefs.add(new ColumnDef("과세총액", Pyyt0304BM.ATTR_PYYTTXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	    		
	    	}
	    });
	    /** column 비과세총액 : pyytFreeDtyTotAmnt */
	    listColumnDefs.add(new ColumnDef("비과세총액", Pyyt0304BM.ATTR_PYYTFREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	    		
	    		
	    	}
	    });
	    /** column 공제총액 : pyytDducTotAmnt */
	    listColumnDefs.add(new ColumnDef("공제총액", Pyyt0304BM.ATTR_PYYTDDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 세금총액 : pyytTxTotAmnt */
	    listColumnDefs.add(new ColumnDef("세금총액", Pyyt0304BM.ATTR_PYYTTXTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 퇴직금지급여부 : pyytSevePayPymtYn */
	    listColumnDefs.add(new ColumnDef("퇴직금지급여부", Pyyt0304BM.ATTR_PYYTSEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 차인지급액 : pyytPernPymtSum */
	    listColumnDefs.add(new ColumnDef("차인지급액", Pyyt0304BM.ATTR_PYYTPERNPYMTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0304BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0304BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0304BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0304BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0304BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0304BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    
	    
	    listColumnDefs.add(new ColumnDef("기본급", Pyyt0304BM.ATTR_PYYTB10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 소득세 : pymtT10100Sum */               
	    listColumnDefs.add(new ColumnDef("소득세", Pyyt0304BM.ATTR_PYYTT10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 주민세  : pymtT20100Sum */
	    listColumnDefs.add(new ColumnDef("주민세", Pyyt0304BM.ATTR_PYYTT20100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
	    	{
	
	    	}
	    });
	    
	      /** column 급여구분코드 : payCd */
	      listColumnDefs.add(new ColumnDef("급여구분코드", Pyyt0302BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, false){
	      	{

	      	}
	      });
	    
	    
	        
	        return listColumnDefs;
	    }
	    
	    

}
