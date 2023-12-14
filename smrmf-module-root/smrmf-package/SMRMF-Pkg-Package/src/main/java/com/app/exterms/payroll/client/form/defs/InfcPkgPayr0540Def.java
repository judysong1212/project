/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0540BM;
import com.app.exterms.payroll.shared.InfcPkgPayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.i18n.client.DateTimeFormat;
 
/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InfcPkgPayr0540Def  extends TableDef implements InfcPkgPayrDaoConstants {

    private int row = 0; 
 
    final SysIfBass0300DTO sysComBass0300Dto;
    protected ColumnDefListenerAdapter changeValueListenerAdapter;
    private ListStore<BaseModel> resultCd;
    
    
	 public InfcPkgPayr0540Def(String chkDef){
    	
    	 sysComBass0300Dto = new SysIfBass0300DTO(); 
    	 
    	 
    	 if ("InsrLP410001".equals(chkDef)) {
    		    setTitle("");
    	        setDaoClass("");
    	        setCustomListMethod(CLASS_INSRLP410001_PAYR0540_DATA_LIST);
    	        setAutoFillGrid(false);
    	        setShowFilterToolbar(false);
    	        setCheckBoxOnGridRows(true); 
    	       // setEditFieldGrid(true); 
    	        setFilterFormType(FILTER_FORM_SINGLE);
              setColumnsDefinition(getInsrLP410001ToInfcPayr0540());
              
          } else if ("InsrRP410001".equals(chkDef)) {
        	  sysComBass0300Dto.setRpsttvCd("B013");
         	  resultCd = SysifComServiceUtils.getSingleBass0300ComboData( sysComBass0300Dto);
        	  
        	  
        	  
        	  setTitle("");
              setDaoClass("");
              setCustomListMethod(CLASS_INSRRP410001_PAYR0540_DATA_LIST);
              setAutoFillGrid(false);
              setShowFilterToolbar(false);
              setCheckBoxOnGridRows(true); 
               setEditFieldGrid(true); 
              setColumnsDefinition(getInsrRP410001ToInfcPayr0540());
             
             
              
           
              
          }  else if ("".equals(chkDef)) {
        	  setTitle("");
              setDaoClass("");
              setCustomListMethod("");
              setAutoFillGrid(false);
              setShowFilterToolbar(false);
              setCheckBoxOnGridRows(true); 
            //  setEditFieldGrid(true); 
              setColumnsDefinition(getInfcPayr0540());
              
          } 
    }	
      
	 public void setitemChange(Field itemField,Object itemCd) {
		    
		    changeValueListenerAdapter.run(itemField, itemCd);
		    
		}
		    
	 
	 public List<ColumnDef> getInfcPayr0540(){	 

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgPayr0540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	          
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgPayr0540BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	        /** column 예외처리일련번호 : exptnPrcsSeilNum */
	        listColumnDefs.add(new ColumnDef("번호", InfcPkgPayr0540BM.ATTR_EXPTNPRCSSEILNUM, ColumnDef.TYPE_LONG, 40, false, true, true){
	        	{
	               setReadOnly(true);
	        	}
	        });
	        /** column 급여항목코드 : payItemCd */
	        listColumnDefs.add(new ColumnDef("급여항목코드", InfcPkgPayr0540BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, false, false, true){
	            {

	            }
	        });
	      
	        sysComBass0300Dto.setRpsttvCd("B013"); 
	        /** column 예외구분코드 : exptnDivCd */
	        listColumnDefs.add(new ColumnListDef("예외구분", InfcPkgPayr0540BM.ATTR_EXPTNDIVCD, ColumnDef.TYPE_STRING, 110, false, true, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
	        	{

	        	}
	        });
	        /** column 예외구분 : exptnDivNm */
	        listColumnDefs.add(new ColumnDef("예외구분", InfcPkgPayr0540BM.ATTR_EXPTNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	        sysComBass0300Dto.setRpsttvCd("B008"); 
	        /** column 지급공제구분코드 : pymtDducDivCd */
	        listColumnDefs.add(new ColumnListDef("공제구분", InfcPkgPayr0540BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
	        	{

	        	}
	        });
	        
	        /** column 지급공제구분 : pymtDducDivNm */
	        listColumnDefs.add(new ColumnDef("공제구분", InfcPkgPayr0540BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	        /** column 면제여부 : exmtnYn */
	        listColumnDefs.add(new ColumnDef("면제", InfcPkgPayr0540BM.ATTR_EXMTNYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
	        	{

	        	}
	        });
	        /** column 예외처리지급금액 : exptnPrcsPymtSum */
	        listColumnDefs.add(new ColumnDef("예외금액", InfcPkgPayr0540BM.ATTR_EXPTNPRCSPYMTSUM, ColumnDef.TYPE_LONG, 80, false, true, true){
	        	{

	        	}
	        });
	        /** column 예외처리지급비율 : exptnPrcsPymtRto */
	        listColumnDefs.add(new ColumnDef("예외비율", InfcPkgPayr0540BM.ATTR_EXPTNPRCSPYMTRTO, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
	        	{

	        	}
	        });
	        /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	        listColumnDefs.add(new ColumnDef("시작일자", InfcPkgPayr0540BM.ATTR_EXPTNPRCSBGNNDT, ColumnDef.TYPE_DATE, 80, false, true, true){
	        	{
	        		setMaxLength(10);
	        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
	        		setDtFieldMask("9999.99.99");
	        	}
	        });
	        /** column 예외처리종료일자 : exptnPrcsEndDt */
	        listColumnDefs.add(new ColumnDef("종료일자", InfcPkgPayr0540BM.ATTR_EXPTNPRCSENDDT, ColumnDef.TYPE_DATE, 80, false, true, true){
	        	{
	        		setMaxLength(10);
	        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
	        		setDtFieldMask("9999.99.99");
	        	}
	        });
	        /** column 예외처리내용 : exptnPrcsNoteCtnt */
	        listColumnDefs.add(new ColumnDef("예외처리내용", InfcPkgPayr0540BM.ATTR_EXPTNPRCSNOTECTNT, ColumnDef.TYPE_STRING , 120, false, true, true){
	            {

	            }
	        });

	        
//	        /** column 입력자 : kybdr */
//	        listColumnDefs.add(new ColumnDef("입력자", InfcPayr0540BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, false, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 입력일자 : inptDt */
//	        listColumnDefs.add(new ColumnDef("입력일자", InfcPayr0540BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 입력주소 : inptAddr */
//	        listColumnDefs.add(new ColumnDef("입력주소", InfcPayr0540BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 수정자 : ismt */
//	        listColumnDefs.add(new ColumnDef("수정자", InfcPayr0540BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 수정일자 : revnDt */
//	        listColumnDefs.add(new ColumnDef("수정일자", InfcPayr0540BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 수정주소 : revnAddr */
//	        listColumnDefs.add(new ColumnDef("수정주소", InfcPayr0540BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });

//	        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
	//
//	        private TextField<String> exptnPrcsSeilNum   /** column 예외처리일련번호 : exptnPrcsSeilNum */
	//
//	        private TextField<String> exptnDivCd   /** column 예외구분코드 : exptnDivCd */
	//
//	        private TextField<String> pymtDducDivCd   /** column 지급공제구분코드 : pymtDducDivCd */
	//
//	        private TextField<String> exmtnYn   /** column 면제여부 : exmtnYn */
	//
//	        private TextField<String> exptnPrcsPymtSum   /** column 예외처리지급금액 : exptnPrcsPymtSum */
	//
//	        private TextField<String> exptnPrcsPymtRto   /** column 예외처리지급비율 : exptnPrcsPymtRto */
	//
//	        private TextField<String> exptnPrcsBgnnDt   /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	//
//	        private TextField<String> exptnPrcsEndDt   /** column 예외처리종료일자 : exptnPrcsEndDt */
	//
//	        private TextField<String> kybdr   /** column 입력자 : kybdr */
	//
//	        private TextField<String> inptDt   /** column 입력일자 : inptDt */
	//
//	        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
	//
//	        private TextField<String> ismt   /** column 수정자 : ismt */
	//
//	        private TextField<String> revnDt   /** column 수정일자 : revnDt */
	//
//	        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

	        
	        return listColumnDefs;
	    }
	 
	 public List<ColumnDef> getInsrLP410001ToInfcPayr0540(){	 

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgPayr0540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
          
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgPayr0540BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", InfcPkgPayr0540BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
                setReadOnly(true);
            }
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", InfcPkgPayr0540BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 50, true, true, false){
          {
              setReadOnly(true);
          }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", InfcPkgPayr0540BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
          {
              setReadOnly(true);
          }
        });
        
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", InfcPkgPayr0540BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
          {
              setReadOnly(true);
          }
        });
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", InfcPkgPayr0540BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	 setReadOnly(true);
            }
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", InfcPkgPayr0540BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	 setReadOnly(true);
            }
        });
        
       
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서", InfcPkgPayr0540BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
            {
                setReadOnly(true);
            }
        });
        

        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", InfcPkgPayr0540BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	  setReadOnly(true);
            }
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", InfcPkgPayr0540BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	  setReadOnly(true);
            }
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", InfcPkgPayr0540BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	  setReadOnly(true);
            }
        });
        
/** column 직종세통합코드 : dtilOccuInttnCd */
listColumnDefs.add(new ColumnDef("직종세통합코드", InfcPkgPayr0540BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
{

}
});                                           

        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", InfcPkgPayr0540BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", InfcPkgPayr0540BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 직종세구분 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", InfcPkgPayr0540BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
        
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", InfcPkgPayr0540BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	 setReadOnly(true);
            }
        }); 
        
        
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업", InfcPkgPayr0540BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
        
        return listColumnDefs;
    }
	 
	 public List<ColumnDef> getInsrRP410001ToInfcPayr0540(){	 
		 
		 changeValueListenerAdapter = new ColumnDefListenerAdapter() {
	           	
	    		@SuppressWarnings("rawtypes")
	    		public void run(Field field, Object valueField) {  
	    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
	    			 final ModelData formModel = formPanel.getFormBinding().getModel();
	    			 BaseModel item = (BaseModel)valueField;

	    			 String result02 = "";
	    			 String result11 = "";
	    			 
	    			 for(int i=0; i<resultCd.getCount(); i++){
	    				 if(item.get("commCd").equals(resultCd.getModels().get(i).get("commCd"))){
	    					 result02 = resultCd.getModels().get(i).get("mangeItem02");
	    					 result11 = resultCd.getModels().get(i).get("mangeItem11");
	    				 }	    				 
	    			 }
	    			 formModel.set(InfcPkgPayr0540BM.ATTR_PAYITEMCD, result02);
	    			 formModel.set(InfcPkgPayr0540BM.ATTR_EXPTNPRCSPYMTRTO,  new Double(result11));    	
	    			}
	    		};
		 
		 

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgPayr0540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	          
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgPayr0540BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	        /** column 예외처리일련번호 : exptnPrcsSeilNum */
	        listColumnDefs.add(new ColumnDef("번호", InfcPkgPayr0540BM.ATTR_EXPTNPRCSSEILNUM, ColumnDef.TYPE_LONG, 40, false, true, true){
	        	{
	               setReadOnly(true);
	        	}
	        });
	        
	        /** column 지급공제구분 : pymtDducDivNm */
	        listColumnDefs.add(new ColumnDef("공제구분", InfcPkgPayr0540BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
	        	{
	        		 setReadOnly(true);
	        	}
	        });
	        
	        /** column 급여항목코드 : payItemCd */
	        listColumnDefs.add(new ColumnDef("급여항목코드", InfcPkgPayr0540BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, false, false, true){
	            {

	            }
	        });
	                
	        sysComBass0300Dto.setRpsttvCd("B013"); 
	        sysComBass0300Dto.setMangeItem01("Y");
	        /** column 예외구분코드 : exptnDivCd */
	        listColumnDefs.add(new ColumnListDef("예외구분", InfcPkgPayr0540BM.ATTR_EXPTNDIVCD, ColumnDef.TYPE_STRING, 110, false, true, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
	        	{
	        		addTrigger(Events.Change, changeValueListenerAdapter);
	        	}
	        });
	        /** column 예외구분 : exptnDivNm */
	        listColumnDefs.add(new ColumnDef("예외구분", InfcPkgPayr0540BM.ATTR_EXPTNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
	        	{

	        	}
	        });
	        sysComBass0300Dto.setRpsttvCd("B008"); 
	        /** column 지급공제구분코드 : pymtDducDivCd */
	        listColumnDefs.add(new ColumnListDef("공제구분", InfcPkgPayr0540BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
	        	{

	        	}
	        });
	         
	        /** column 면제여부 : exmtnYn */
	        listColumnDefs.add(new ColumnDef("면제", InfcPkgPayr0540BM.ATTR_EXMTNYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
	        	{

	        	}
	        });
	        /** column 예외처리지급금액 : exptnPrcsPymtSum */
	        listColumnDefs.add(new ColumnDef("예외금액", InfcPkgPayr0540BM.ATTR_EXPTNPRCSPYMTSUM, ColumnDef.TYPE_LONG, 80, false, true, true){
	        	{

	        	}
	        });
	        /** column 예외처리지급비율 : exptnPrcsPymtRto */
	        listColumnDefs.add(new ColumnDef("예외비율", InfcPkgPayr0540BM.ATTR_EXPTNPRCSPYMTRTO, ColumnDef.TYPE_DOUBLE, 80, false, true, true){
	        	{

	        	}
	        });
	        /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	        listColumnDefs.add(new ColumnDef("시작일자", InfcPkgPayr0540BM.ATTR_EXPTNPRCSBGNNDT, ColumnDef.TYPE_DATE, 80, false, true, true){
	        	{
	        		setMaxLength(10);
	        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
	        		setDtFieldMask("9999.99.99");
	        	}
	        });
	        /** column 예외처리종료일자 : exptnPrcsEndDt */
	        listColumnDefs.add(new ColumnDef("종료일자", InfcPkgPayr0540BM.ATTR_EXPTNPRCSENDDT, ColumnDef.TYPE_DATE, 80, false, true, true){
	        	{
	        		setMaxLength(10);
	        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
	        		setDtFieldMask("9999.99.99");
	        	}
	        });
	        /** column 예외처리내용 : exptnPrcsNoteCtnt */
	        listColumnDefs.add(new ColumnDef("예외처리내용", InfcPkgPayr0540BM.ATTR_EXPTNPRCSNOTECTNT, ColumnDef.TYPE_STRING , 120, false, true, true){
	            {

	            }
	        });

	        
//	        /** column 입력자 : kybdr */
//	        listColumnDefs.add(new ColumnDef("입력자", InfcPayr0540BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, false, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 입력일자 : inptDt */
//	        listColumnDefs.add(new ColumnDef("입력일자", InfcPayr0540BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 입력주소 : inptAddr */
//	        listColumnDefs.add(new ColumnDef("입력주소", InfcPayr0540BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 수정자 : ismt */
//	        listColumnDefs.add(new ColumnDef("수정자", InfcPayr0540BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 수정일자 : revnDt */
//	        listColumnDefs.add(new ColumnDef("수정일자", InfcPayr0540BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });
//	        /** column 수정주소 : revnAddr */
//	        listColumnDefs.add(new ColumnDef("수정주소", InfcPayr0540BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//	        	{
	//
//	        	}
//	        });

//	        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
	//
//	        private TextField<String> exptnPrcsSeilNum   /** column 예외처리일련번호 : exptnPrcsSeilNum */
	//
//	        private TextField<String> exptnDivCd   /** column 예외구분코드 : exptnDivCd */
	//
//	        private TextField<String> pymtDducDivCd   /** column 지급공제구분코드 : pymtDducDivCd */
	//
//	        private TextField<String> exmtnYn   /** column 면제여부 : exmtnYn */
	//
//	        private TextField<String> exptnPrcsPymtSum   /** column 예외처리지급금액 : exptnPrcsPymtSum */
	//
//	        private TextField<String> exptnPrcsPymtRto   /** column 예외처리지급비율 : exptnPrcsPymtRto */
	//
//	        private TextField<String> exptnPrcsBgnnDt   /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	//
//	        private TextField<String> exptnPrcsEndDt   /** column 예외처리종료일자 : exptnPrcsEndDt */
	//
//	        private TextField<String> kybdr   /** column 입력자 : kybdr */
	//
//	        private TextField<String> inptDt   /** column 입력일자 : inptDt */
	//
//	        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
	//
//	        private TextField<String> ismt   /** column 수정자 : ismt */
	//
//	        private TextField<String> revnDt   /** column 수정일자 : revnDt */
	//
//	        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

	        
	        return listColumnDefs;
	    }
}
