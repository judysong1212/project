/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2017;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.InfcPsnl0100BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InfcPsnl0100Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public InfcPsnl0100Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("YETAP210001".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP210001_TO_PSNL0100_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYetaP210001ToPsnl0100ColumnsList());

		} else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP110001_TO_PSNL0100_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYetaP210001ToPsnl0100ColumnsList());
		}

	}
    
    
	
	private List<ColumnDef> getYetaP210001ToPsnl0100ColumnsList(){
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	
	    
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분", InfcPsnl0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });   
	    
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분", InfcPsnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	
	    	}
	    });   
	    
	    
	    
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", InfcPsnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", InfcPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });    
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", InfcPsnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 120, true, true, true){
	    	{
	
	    	}
	    });  
	    
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종", InfcPsnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	
	    	}
	    });
	    
	    /** column 직종세구분코드 : dtilOccuClsDivCd */
	    listColumnDefs.add(new ColumnDef("직종세(사업)", InfcPsnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	
	    	}
	    });
	    
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", InfcPsnl0100BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
	    
	    /** column 고용시작일자 : emymtBgnnDt */
	    listColumnDefs.add(new ColumnDef("시작일자", InfcPsnl0100BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    });
	    /** column 고용종료일자 : emymtEndDt */
	    listColumnDefs.add(new ColumnDef("종료일자", InfcPsnl0100BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 100, true, true, true){
	    	{
	
	    	}
	    });
	    
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직상태", InfcPsnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
	    
	    
	    
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", InfcPsnl0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPsnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용일련번호 : emymtSeilNum */
	    listColumnDefs.add(new ColumnDef("고용일련번호", InfcPsnl0100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분코드", InfcPsnl0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용유형코드 : emymtTypCd */
	    listColumnDefs.add(new ColumnDef("고용유형코드", InfcPsnl0100BM.ATTR_EMYMTTYPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", InfcPsnl0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 현근무지명 : currPaeWorkNm */
	    listColumnDefs.add(new ColumnDef("현근무지명", InfcPsnl0100BM.ATTR_CURRPAEWORKNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업코드 : businCd */
	    listColumnDefs.add(new ColumnDef("사업코드", InfcPsnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종코드", InfcPsnl0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종세구분코드 : dtilOccuClsDivCd */
	    listColumnDefs.add(new ColumnDef("직종세구분코드", InfcPsnl0100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직책코드 : odtyCd */
	    listColumnDefs.add(new ColumnDef("직책코드", InfcPsnl0100BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 급여지급구분코드 : payPymtDivCd */
	    listColumnDefs.add(new ColumnDef("급여지급구분코드", InfcPsnl0100BM.ATTR_PAYPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용금액 : emymtSum */
	    listColumnDefs.add(new ColumnDef("고용금액", InfcPsnl0100BM.ATTR_EMYMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 고용사유내용 : emymtReasCtnt */
	    listColumnDefs.add(new ColumnDef("고용사유내용", InfcPsnl0100BM.ATTR_EMYMTREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 증번호 : certNumHuhd */
	    listColumnDefs.add(new ColumnDef("증번호", InfcPsnl0100BM.ATTR_CERTNUMHUHD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 경감시작일자 : rducBgnnDt */
	    listColumnDefs.add(new ColumnDef("경감시작일자", InfcPsnl0100BM.ATTR_RDUCBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", InfcPsnl0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", InfcPsnl0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", InfcPsnl0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", InfcPsnl0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", InfcPsnl0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", InfcPsnl0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 경감종료일자 : rducEndDt */
	    listColumnDefs.add(new ColumnDef("경감종료일자", InfcPsnl0100BM.ATTR_RDUCENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 호봉등급코드 : pyspGrdeCd */
	    listColumnDefs.add(new ColumnDef("호봉등급코드", InfcPsnl0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 직종통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종통합코드", InfcPsnl0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 환산비율구분코드 : cvsnRtoDivCd */
	    listColumnDefs.add(new ColumnDef("환산비율구분코드", InfcPsnl0100BM.ATTR_CVSNRTODIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속년수 : dutyYrNum */
	    listColumnDefs.add(new ColumnDef("근속년수", InfcPsnl0100BM.ATTR_DUTYYRNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속월수 : dutyMnthIcm */
	    listColumnDefs.add(new ColumnDef("근속월수", InfcPsnl0100BM.ATTR_DUTYMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속일수 : dutyDayNum */
	    listColumnDefs.add(new ColumnDef("근속일수", InfcPsnl0100BM.ATTR_DUTYDAYNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 근속전체일수 : dutyTotDayNum */
	    listColumnDefs.add(new ColumnDef("근속전체일수", InfcPsnl0100BM.ATTR_DUTYTOTDAYNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    
	    /** column 국가코드 : natnCd */
	    listColumnDefs.add(new ColumnDef("국가코드", InfcPsnl0100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 국가코드 : natnNm */
	    listColumnDefs.add(new ColumnDef("국가코드", InfcPsnl0100BM.ATTR_NATNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 호주성명 : hfmlyNm */
	    listColumnDefs.add(new ColumnDef("호주성명", InfcPsnl0100BM.ATTR_HFMLYNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
    
	    
	    /** column 호주와의관계코드 : hfmlyRelaCd */
	    listColumnDefs.add(new ColumnDef("호주와의관계코드", InfcPsnl0100BM.ATTR_HFMLYRELACD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
	    
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", InfcPsnl0100BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });   
	    
    
    
        
        return listColumnDefs;
    }
    
    


}
