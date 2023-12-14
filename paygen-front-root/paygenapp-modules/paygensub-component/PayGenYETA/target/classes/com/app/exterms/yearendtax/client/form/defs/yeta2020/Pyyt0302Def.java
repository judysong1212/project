/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2020;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Pyyt0302BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Pyyt0302Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    protected ColumnDefListenerAdapter changeValueListenerAdapter1; 	// 비과세금액
    protected ColumnDefListenerAdapter changeValueListenerAdapter2; 	// 지급금액
    
    
    private PrgmComBass0300DTO sysComBass0300Dto ;

	public Pyyt0302Def(String chkPayrDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();

		// 수당
		if ("PYYT0302EXTPY".equals(chkPayrDef)) {
			

			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0302_EXTPY_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setEditFieldGrid(true);
//			setEditableGrid(true);
			
//	    	changeValueListenerAdapter = new ColumnDefListenerAdapter() {
//	           	
//	    		@SuppressWarnings("rawtypes")
//	    		public void run(Field field, Object valueField) {
//	    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field)  
//	    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
//	    			 final ModelData formModel = formPanel.getFormBinding().getModel();
//	    			 
//	    			 Window.alert("111111");
//	    			 Window.alert("" + formModel.get(Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM));
//	    			 Window.alert("" + (Long)formModel.get(Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM));
//	    			 
//	    			 Long pyytPyddFreeDtySum = (Long)formModel.get(Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM);
//	    			 
//	    			 Window.alert("222222");
//	    			 
//	    			 Long pyytPymtDducSum = (Long)formModel.get(Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM);
//	    			 Long pyytPyddTxtnAmnt = (Long)formModel.get(Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT);
//	    		  
////	    			 Long pyytPyddFreeDtySum = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM),"0"));  	// 비과세금액
////	    			 Long pyytPymtDducSum = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM),"0"));  			// 지급금액
////	    			 Long pyytPyddTxtnAmnt = Long.parseLong(MSFSharedUtils.defaultNulls(formModel.get(Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT),"0"));  		// 과세금액
//	    			 
//	    			 
//	    			 Window.alert("비과세금액 -> " + pyytPyddFreeDtySum);
//	    			 Window.alert("지급금액 -> " + pyytPymtDducSum);
//	    			 Window.alert("과세금액 -> " + pyytPyddTxtnAmnt);
//	    			 
//	    			 
////	    			 Long pyytPyddTxtnAmnt =  (Long) valueField ;   								// 과세금액 
//	    	         if (MSFSharedUtils.paramNotNull(pyytPyddFreeDtySum) && MSFSharedUtils.paramNotNull(pyytPyddTxtnAmnt) ) {
//	    	             if (pyytPyddTxtnAmnt.compareTo(pyytPyddFreeDtySum) > 0) {
////	    	                    field.markInvalid("값이크당.");    //config 에선언시 에러 .MSFSharedUtils.MSG.valError_MinMaxSalary()
//	    	                }
//	    	         }
//	    	         
//	    	         Window.alert("pyytPyddFreeDtySum -> " + pyytPyddFreeDtySum);
//	    	         Window.alert("pyytPyddTxtnAmnt -> " + pyytPyddTxtnAmnt);
//	    	         
//	    	         // 지급금액 = 과세금액 - 비과세금액
//	    	         pyytPyddTxtnAmnt = pyytPymtDducSum - pyytPyddFreeDtySum; 
//	    	         
////	    	         Window.alert("지급 ->" + pyytPymtDducSum + "비과세 -> " + pyytPyddFreeDtySum + "과세 -> " + pyytPyddTxtnAmnt);
//	    	      
//	    	         formModel.set(Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM, pyytPymtDducSum);	// 지급금액을 계산해준다.
//	    	         
//	    			}
//	    		};

			setColumnsDefinition(getYeta1900ToPyyt0302EXTPYColumnsList());
			
		// 공제
		} else if ("PYYT0302DDUC".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0302_DDUC_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			
			setEditFieldGrid(true);
			setEditableGrid(true);

			setColumnsDefinition(getYeta1900ToPyyt0302DDUCColumnsList());
			
			
		// 수당
		}else if ("YETA2900_PYYT0302EXTPY".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETA2900_TO_PYYT0302_EXTPY_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setEditFieldGrid(true);
//				setEditableGrid(true);
			setColumnsDefinition(getYeta2900ToPyyt0302EXTPYColumnsList());
		
		// 공제
		}else if ("YETA2900_PYYT0302DDUC".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETA2900_TO_PYYT0302_DDUC_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setEditFieldGrid(true);
			setEditableGrid(true);
			setColumnsDefinition(getYeta2900ToPyyt0302DDUCColumnsList());
				
				
		}else {
			setDaoClass("");
//			setCustomListMethod(CLASS_YETA1900_TO_PYYT0302_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setEditableGrid(true);
			setColumnsDefinition(getPyyt0302ColumnsList());
		}

	}
	
//    public void setitemChange(Field itemField,Object itemCd) {
//        
//        changeValueListenerAdapter.run(itemField, itemCd);
//        
//    }
    

	private List<ColumnDef> getPyyt0302ColumnsList(){
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("급여항목코드", Pyyt0302BM.ATTR_PYYTITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0302BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제구분코드 : pyytPymtDducCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Pyyt0302BM.ATTR_PYYTPYMTDDUCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제금액 : pyytPymtDducSum */
	    listColumnDefs.add(new ColumnDef("지급공제금액", Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
	    listColumnDefs.add(new ColumnDef("지급공제과세금액", Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제비과세금액 : pyytPyddFreeDtySum */
	    listColumnDefs.add(new ColumnDef("지급공제비과세금액", Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("연말정산_비과세감면코드", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0302BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0302BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0302BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0302BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0302BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0302BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	        
	    return listColumnDefs;
	}
	
	
	/** 2016 수당 항목 **/
	private List<ColumnDef> getYeta1900ToPyyt0302EXTPYColumnsList(){
		
		
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	    
	    
	    
	    
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("항목", Pyyt0302BM.ATTR_PYYTITEMNM, ColumnDef.TYPE_STRING , 60, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });
	    
	    
	    /** column 지급공제비과세금액 : pyytPyddFreeDtySum */
	    listColumnDefs.add(new ColumnDef("비과세금액", Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM, ColumnDef.TYPE_LONG , 70, true, true, true){
	    	{
//	    		addTrigger(Events.KeyUp, changeValueListenerAdapter);
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });	    
	    
	    /** column 지급공제금액 : pyytPymtDducSum */
	    listColumnDefs.add(new ColumnDef("지급금액", Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM, ColumnDef.TYPE_LONG , 70, true, true, true){
	    	{
//	    		addTrigger(Events.KeyUp, changeValueListenerAdapter);
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });
	    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
	    listColumnDefs.add(new ColumnDef("과세금액", Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
	    	{
//	    		setReadOnly(true);
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });

	    
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("비과세감면", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 70, true, false, true){
	    	{
	
	    	}
	    });    
	    
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("비과세감면", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUNM, ColumnDef.TYPE_STRING , 70, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });    
//        sysComBass0300Dto.setRpsttvCd("Y010");
//        /** column 급여구분코드  : payCd */
//        listColumnDefs.add(new ColumnListDef("비과세감면", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//        	}
//        });	    
	    
	
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("급여항목코드", Pyyt0302BM.ATTR_PYYTITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0302BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제구분코드 : pyytPymtDducCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Pyyt0302BM.ATTR_PYYTPYMTDDUCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0302BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0302BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0302BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0302BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0302BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0302BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	        
	    return listColumnDefs;
	}
	
	
	
	/** 2016 공제 항목 **/
	private List<ColumnDef> getYeta1900ToPyyt0302DDUCColumnsList(){
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	    
	    
	    
	    
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("항목", Pyyt0302BM.ATTR_PYYTITEMNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });
	    
	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 80, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });
	    
//	    sysComBass0300Dto.setRpsttvCd("B023");
//	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
//        listColumnDefs.add(new ColumnListDef("기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//        	}
//        });	   
	    
	    /** column 지급공제금액 : pyytPymtDducSum */
	    listColumnDefs.add(new ColumnDef("공제금액", Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
	    	{
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });

	    
	    
	    
	    /** column 지급공제비과세금액 : pyytPyddFreeDtySum */
	    listColumnDefs.add(new ColumnDef("비과세금액", Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM, ColumnDef.TYPE_LONG , 80, true, false, true){
	    	{
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });	    
	    

	    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
	    listColumnDefs.add(new ColumnDef("과세금액", Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });

	    
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("비과세감면코드", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });    
	    
	    
	
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("급여항목코드", Pyyt0302BM.ATTR_PYYTITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0302BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제구분코드 : pyytPymtDducCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Pyyt0302BM.ATTR_PYYTPYMTDDUCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });


	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0302BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0302BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0302BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0302BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0302BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0302BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	        
	    return listColumnDefs;
	}
	
	
	
	
	/** 2017 수당 항목 **/
	private List<ColumnDef> getYeta2900ToPyyt0302EXTPYColumnsList() {
		
		
		changeValueListenerAdapter1 = new ColumnDefListenerAdapter() {
			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();
              	
              	Long pyytPyddFreeDtySum = (Long) valueField; 								// 비과세금액 	
              	
              	Long pyytPymtDducSum =  formModel.get(Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM);		/** set 지급공제금액 : pyytPymtDducSum */
              	Long pyytPyddTxtnAmnt=  0L; 												/** set 지급공제과세금액 : pyytPyddTxtnAmnt */
              	
              	// 과세금액 = 지급공제금액 - 비과세금액
              	pyytPyddTxtnAmnt = pyytPymtDducSum - pyytPyddFreeDtySum;
              	
              	formModel.set(Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, pyytPyddTxtnAmnt);
              	
              }
          };
          
          
          changeValueListenerAdapter2 = new ColumnDefListenerAdapter() {
			@SuppressWarnings("rawtypes")
			public void run(Field field, Object valueField) {

				MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
				final ModelData formModel = formPanel.getFormBinding().getModel();
	              	
				Long pyytPymtDducSum = (Long) valueField; 										// 지급공제금액
	              	
				Long pyytPyddFreeDtySum =  formModel.get(Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM);	/** set 지급공제비과세금액 : pyytPyddFreeDtySum */
	            Long pyytPyddTxtnAmnt=  0L; 													/** set 지급공제과세금액 : pyytPyddTxtnAmnt */
	              	
	            // 과세금액 = 지급공제금액 - 비과세금액
	            pyytPyddTxtnAmnt = pyytPymtDducSum - pyytPyddFreeDtySum;
	              	
	            formModel.set(Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, pyytPyddTxtnAmnt);
	              	
			}
          };
		
		
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	    
	    
	    
	    
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("항목", Pyyt0302BM.ATTR_PYYTITEMNM, ColumnDef.TYPE_STRING , 80, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });
	    
	    
	    /** column 지급공제비과세금액 : pyytPyddFreeDtySum */
	    listColumnDefs.add(new ColumnDef("비과세금액", Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM, ColumnDef.TYPE_LONG , 80, true, true, true){
	    	{
	    		addTrigger(Events.KeyUp, changeValueListenerAdapter1);
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });	    
	    
	    /** column 지급공제금액 : pyytPymtDducSum */
	    listColumnDefs.add(new ColumnDef("지급금액", Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM, ColumnDef.TYPE_LONG , 70, true, true, true){
	    	{
	    		addTrigger(Events.KeyUp, changeValueListenerAdapter2);
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });
	    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
	    listColumnDefs.add(new ColumnDef("과세금액", Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
	    	{
//	    		setReadOnly(true);
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            	setReadOnly(true);
	    	}
	    });

	    
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("비과세감면", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 100, true, false, true){
	    	{
	
	    	}
	    });    
	    
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("비과세감면", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUNM, ColumnDef.TYPE_STRING , 80, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });    
//        sysComBass0300Dto.setRpsttvCd("Y010");
//        /** column 급여구분코드  : payCd */
//        listColumnDefs.add(new ColumnListDef("비과세감면", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//        	}
//        });	    
	    
	
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("급여항목코드", Pyyt0302BM.ATTR_PYYTITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0302BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제구분코드 : pyytPymtDducCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Pyyt0302BM.ATTR_PYYTPYMTDDUCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("연말정산_기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });

	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0302BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0302BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0302BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0302BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0302BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0302BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
	
	
	
	/** 2017 공제 항목 **/
	private List<ColumnDef> getYeta2900ToPyyt0302DDUCColumnsList(){
	    row = 0;
	    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	    
	    
	    
	    
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("항목", Pyyt0302BM.ATTR_PYYTITEMNM, ColumnDef.TYPE_STRING , 80, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });
	    
	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING , 80, true, false, true){
	    	{
	
	    	}
	    });
	    
	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
	    listColumnDefs.add(new ColumnDef("기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
	    	{
	    		setReadOnly(true);
	    	}
	    });
	    
//	    sysComBass0300Dto.setRpsttvCd("B023");
//	    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
//        listColumnDefs.add(new ColumnListDef("기부금코드", Pyyt0302BM.ATTR_PYYTYRTXDOTNCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//        	}
//        });	   
	    
	    /** column 지급공제금액 : pyytPymtDducSum */
	    listColumnDefs.add(new ColumnDef("공제금액", Pyyt0302BM.ATTR_PYYTPYMTDDUCSUM, ColumnDef.TYPE_LONG , 80, true, true, true){
	    	{
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });

	    
	    
	    
	    /** column 지급공제비과세금액 : pyytPyddFreeDtySum */
	    listColumnDefs.add(new ColumnDef("비과세금액", Pyyt0302BM.ATTR_PYYTPYDDFREEDTYSUM, ColumnDef.TYPE_LONG , 80, true, false, true){
	    	{
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });	    
	    

	    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
	    listColumnDefs.add(new ColumnDef("과세금액", Pyyt0302BM.ATTR_PYYTPYDDTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{
	    		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
	    	}
	    });

	    
	    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	    listColumnDefs.add(new ColumnDef("비과세감면코드", Pyyt0302BM.ATTR_PYYTYTFEDTYREDUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });    
	    
	    
	
	    /** column 급여항목코드 : pyytItemCd */
	    listColumnDefs.add(new ColumnDef("급여항목코드", Pyyt0302BM.ATTR_PYYTITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column SYSTEMKEY : systemkey */
	    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Pyyt0302BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Pyyt0302BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급년월 : pyytYrMnth */
	    listColumnDefs.add(new ColumnDef("지급년월", Pyyt0302BM.ATTR_PYYTYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 지급공제구분코드 : pyytPymtDducCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Pyyt0302BM.ATTR_PYYTPYMTDDUCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });


	    /** column 입력자 : kybdr */
	    listColumnDefs.add(new ColumnDef("입력자", Pyyt0302BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력일자 : inptDt */
	    listColumnDefs.add(new ColumnDef("입력일자", Pyyt0302BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 입력주소 : inptAddr */
	    listColumnDefs.add(new ColumnDef("입력주소", Pyyt0302BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정자 : ismt */
	    listColumnDefs.add(new ColumnDef("수정자", Pyyt0302BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정일자 : revnDt */
	    listColumnDefs.add(new ColumnDef("수정일자", Pyyt0302BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    /** column 수정주소 : revnAddr */
	    listColumnDefs.add(new ColumnDef("수정주소", Pyyt0302BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
