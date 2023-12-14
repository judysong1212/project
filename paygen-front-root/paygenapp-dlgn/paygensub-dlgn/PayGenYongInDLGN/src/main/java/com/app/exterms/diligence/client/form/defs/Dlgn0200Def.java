/**
 * 공통화면 팝업 
 */
package com.app.exterms.diligence.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0200BM;
import com.app.exterms.diligence.client.dto.Dlgn0210BM;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0200Def  extends TableDef implements DiligenceDaoConstants {

	private int row = 0;
    private DiligenceConstants dlgnLabel = DiligenceConstants.INSTANCE;
    
  //2017.04.06 : kim ji eun start //
    public static final String COLUMN_DEF_DILNLAZTMRSTDUTYTM = "dilnlazTmRstDutyTm"; //연장근무시간
    public static final String COLUMN_DEF_DILNLAZNTOTTM = "dilnlazNtotTm"; //야근근무시간
    public static final String COLUMN_DEF_DILNLAZHODYDUTYTM = "dilnlazHodyDutyTm"; //휴일근무시간
    public static final String COLUMN_DEF_DILNLAZHODYNTOTTM = "dilnlazHodyNtotTm"; //휴일연장근무시간
    public static final String COLUMN_DEF_DILNLAZDUTYEDTM = "dilnlazDutyEdTm"; //근태종료시간
    
    public static final String FIELD_ID_DILNLAZTMRSTDUTYTM = COLUMN_DEF_DILNLAZTMRSTDUTYTM; //연장근무시간
    public static final String FIELD_ID_DILNLAZNTOTTM = COLUMN_DEF_DILNLAZNTOTTM; //야근근무시간
    public static final String FIELD_ID_DILNLAZHODYDUTYTM = COLUMN_DEF_DILNLAZHODYDUTYTM; //휴일근무시간 
    public static final String FIELD_ID_DILNLAZHODYNTOTTM = COLUMN_DEF_DILNLAZHODYNTOTTM; //휴일연장근무시간
    public static final String FIELD_ID_DILNLAZDUTYEDTM = COLUMN_DEF_DILNLAZDUTYEDTM; //근태종료시간
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter;
    
    public Dlgn0200Def(String chkDef){
    	if("DLGN0200".equals(chkDef)) {
    		setTitle("");
            setDaoClass("");
            setDaoClass(CLASS_DLGN0200LIST_01);
            setCustomListMethod(CLASS_DLGN0200LIST_01);
            setAutoFillGrid(false);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(true);
            setEditFieldGrid(true);
            setCellModel(true);
            setColumnsDefinition(getDLGN0200ColumnsList01());  
    	}else{
       
	    	setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
	        setCellModel(true);
	        setColumnsDefinition(getDLGN0200ColumnsList()); 
        
    	}
    }
    private List<ColumnDef> getDLGN0200ColumnsList() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
        listColumnDefs.add(new ColumnDef("근태초과근무년월", Dlgn0200BM.ATTR_DILNLAZEXCEDUTYYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0200BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Dlgn0200BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Dlgn0200BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Dlgn0200BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Dlgn0200BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Dlgn0200BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
        listColumnDefs.add(new ColumnDef("근태_초과근무시작일자", Dlgn0200BM.ATTR_DILNLAZEXCEDUTYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
        listColumnDefs.add(new ColumnDef("근태_초과근무종료일자", Dlgn0200BM.ATTR_DILNLAZEXCEDUTYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
        listColumnDefs.add(new ColumnDef("근태_휴일근무일수", Dlgn0200BM.ATTR_DILNLAZPUBCHODYDUTYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
        listColumnDefs.add(new ColumnDef("근태_토요근무일수", Dlgn0200BM.ATTR_DILNLAZSATDUTYNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
        listColumnDefs.add(new ColumnDef("근태_총야근일수", Dlgn0200BM.ATTR_DILNLAZTOTNTOTNUMDYS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_총야근시간 : dilnlazTotNtotTm */
        listColumnDefs.add(new ColumnDef("근태_총야근시간", Dlgn0200BM.ATTR_DILNLAZTOTNTOTTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("근태_기본시간외근무시간", Dlgn0200BM.ATTR_DILNLAZFNDTNTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("근태_시간외근무시간", Dlgn0200BM.ATTR_DILNLAZTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("근태_총시간외근무시간", Dlgn0200BM.ATTR_DILNLAZTOTTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
        listColumnDefs.add(new ColumnDef("근태_마감처리여부", Dlgn0200BM.ATTR_DILNLAZDDLNEPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_비고내용 : dilnlazNoteCtnt */
        listColumnDefs.add(new ColumnDef("근태_비고내용", Dlgn0200BM.ATTR_DILNLAZNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Dlgn0200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Dlgn0200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Dlgn0200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Dlgn0200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Dlgn0200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Dlgn0200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Dlgn0200BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Dlgn0200BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
        listColumnDefs.add(new ColumnDef("근태_휴일총근무시간", Dlgn0200BM.ATTR_DILNLAZPUBCHODYDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dilnlazExceDutyYrMnth;   /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//        private TextField<String> dilnlazExceDutyBgnnDt;   /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
//
//        private TextField<String> dilnlazExceDutyEndDt;   /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
//
//        private TextField<String> dilnlazPubcHodyDutyNumDys;   /** column 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//
//        private TextField<String> dilnlazSatDutyNumDys;   /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
//
//        private TextField<String> dilnlazTotNtotNumDys;   /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
//
//        private TextField<String> dilnlazTotNtotTm;   /** column 근태_총야근시간 : dilnlazTotNtotTm */
//
//        private TextField<String> dilnlazFndtnTmRstDutyTm;   /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
//
//        private TextField<String> dilnlazTmRstDutyTm;   /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
//
//        private TextField<String> dilnlazTotTmRstDutyTm;   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
//
//        private TextField<String> dilnlazDdlnePrcsYn;   /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
//
//        private TextField<String> dilnlazNoteCtnt;   /** column 근태_비고내용 : dilnlazNoteCtnt */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> dilnlazPubcHodyDutyTm;   /** column 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
//     
        
//        setColumnsDefinition(listColumnDefs);
    	return listColumnDefs;
    }
    
  //2017.04.06 : kim ji eun
    private List<ColumnDef> getDLGN0200ColumnsList01() {
    	
    	//We create a Listener Adapter to run custom code when one of the combo boxes changes value.
    	//The listener adapter is attached to the combo boxes using the method ColumnDef.addTrigger().
    	changeValueListenerAdapter = new ColumnDefListenerAdapter() {

    	@SuppressWarnings("rawtypes")
    		public void run(Field field, Object valueField) {
    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
    			//To get by name the combo box fields
    			Field dilnlazTmRstDutyTmDisp = findFieldByAttributeName(FIELD_ID_DILNLAZTMRSTDUTYTM);  //연장근무시간
    			Field dilnlazNtotTmDisp = findFieldByAttributeName(FIELD_ID_DILNLAZNTOTTM);  //야근근무시간
    			Field dilnlazHodyDutyTmDisp = findFieldByAttributeName(FIELD_ID_DILNLAZHODYDUTYTM);  //휴일근무시간
    			Field dilnlazHodyNtotTmDisp = findFieldByAttributeName(FIELD_ID_DILNLAZHODYNTOTTM);  //휴일연장근무시간
    			Field dilnlazDutyEdTmDisp = findFieldByAttributeName(FIELD_ID_DILNLAZDUTYEDTM);  //종료시간
    			
    	  		if(FIELD_ID_DILNLAZDUTYEDTM.equals(field.getItemId())) {
               		System.out.println(COLUMN_DEF_DILNLAZDUTYEDTM);
               		//Clear countries and locations
               		GWTUtils.clearField(dilnlazTmRstDutyTmDisp); 
               		GWTUtils.clearField(dilnlazNtotTmDisp);
               		GWTUtils.clearField(dilnlazHodyDutyTmDisp);
               		GWTUtils.clearField(dilnlazHodyNtotTmDisp);
            		
            	}
    		}
    	};
           
        row = 0;
    	
    	List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    	
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0210BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0210BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0210BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 근태일자 : dilnlazApptnDt */
        listColumnDefs.add(new ColumnDef("근태일자", Dlgn0210BM.ATTR_DILNLAZAPPTNDT, ColumnDef.TYPE_STRING , 80, true, true, true){
        		
        		
        });
        /** column 근태_시작시간 : dilnlazDutyStTm */
        listColumnDefs.add(new ColumnDef("시작시간", Dlgn0210BM.ATTR_DILNLAZDUTYSTTM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        /** column 근태_종료시간 : dilnlazDutyEdTm */
        listColumnDefs.add(new ColumnDef("종료시간", Dlgn0210BM.ATTR_DILNLAZDUTYEDTM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        /** column 연장근무(시:분)퇴근시간 : dilnlazDutyEdTmRst */
        listColumnDefs.add(new ColumnDef("퇴근", Dlgn0210BM.ATTR_DILNLAZDUTYEDTMRST, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        /** column 연장근무(시:분)근무시간 : dilnlazTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("근무", Dlgn0210BM.ATTR_DILNLAZTMRSTDUTYTM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        
        /** column 야근근무(시:분)퇴근시간 : dilnlazDutyEdTmDuty */
        listColumnDefs.add(new ColumnDef("퇴근", Dlgn0210BM.ATTR_DILNLAZDUTYEDTMDUTY, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        /** column 야근근무(시:분)근무시간 : dilnlazNtotTm */
        listColumnDefs.add(new ColumnDef("근무", Dlgn0210BM.ATTR_DILNLAZNTOTTM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        
        /** column 휴일근무(시:분)퇴근시간 : dilnlazDutyEdTmHodyDuty */
        listColumnDefs.add(new ColumnDef("퇴근", Dlgn0210BM.ATTR_DILNLAZDUTYEDTMHODYDUTY, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        /** column 휴일근무(시:분)근무시간 : dilnlazHodyDutyTm */
        listColumnDefs.add(new ColumnDef("근무", Dlgn0210BM.ATTR_DILNLAZHODYDUTYTM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}	
        });
        
        /** column 휴일연장근무(시:분)퇴근시간 : dilnlazDutyEdTmHodyNtot */
        listColumnDefs.add(new ColumnDef("퇴근", Dlgn0210BM.ATTR_DILNLAZDUTYEDTMHODYNTOT, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        /** column 휴일연장근무(시:분)근무시간 : dilnlazHodyNtotTm */
        listColumnDefs.add(new ColumnDef("근무", Dlgn0210BM.ATTR_DILNLAZHODYNTOTTM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{
//        		setSelectOnFocus(true);
        	}
        });
        
		/** column 휴일여부 : offdayKubn */
		listColumnDefs.add(new ColumnDef("휴일", Dlgn0210BM.ATTR_OFFDAYKUBN, ColumnDef.TYPE_STRING , 60, true, false, true){
			{
		
			}
		});
		
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Dlgn0210BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Dlgn0210BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Dlgn0210BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Dlgn0210BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Dlgn0210BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Dlgn0210BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
		return listColumnDefs;
    	
    }
}
