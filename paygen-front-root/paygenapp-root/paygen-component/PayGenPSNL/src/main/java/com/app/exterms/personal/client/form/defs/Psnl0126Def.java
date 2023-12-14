package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100BM;
import com.app.exterms.personal.client.dto.Psnl0126BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0126Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;
    
    public static final String COLUMN_DEF_HODYAPPTNNUMDYS = "hodyApptnNumDys"; 
    public static final String COLUMN_DEF_HODYUSENUMDYS = "hodyUseNumDys"; 
    public static final String COLUMN_DEF_HODYRSTNUMDYS = "hodyRstNumDys"; 

    public static final String FIELD_ID_HODYAPPTNNUMDYS = COLUMN_DEF_HODYAPPTNNUMDYS; 
    public static final String FIELD_ID_HODYUSENUMDYS = COLUMN_DEF_HODYUSENUMDYS; 
    public static final String FIELD_ID_HODYRSTNUMDYS = COLUMN_DEF_HODYRSTNUMDYS; 
    public static final String FIELD_ID_TT = COLUMN_DEF_HODYAPPTNNUMDYS+"$hodyApptnNumDys"; 
   
    protected ColumnDefListenerAdapter changeValueListenerAdapter1; 
    protected ColumnDefListenerAdapter changeValueListenerAdapter2;   
    protected ColumnDefListenerAdapter changeValueListenerAdapter3; 
    protected ColumnDefListenerAdapter changeValueListenerAdapter4; 
    
    private boolean boolReadOnly = false ;
    
  

    public Psnl0126Def(String chkDef){
    	if ("PSNL0290".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0126_DATA_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
//	        setCellModel(true);
	        setColumnsDefinition(getPsnl0290ToPsnl0126ColumnsList());  
	      
    	}else if ("PSNL0295".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0126_DATA_LIST);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
	        setColumnsDefinition(getPsnl0295ToPsnl0126ColumnsList());
//	        setCellModel(true);
	        
    	}else if ("PSNLP029001".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_PSNLP029001_DATA_LIST);
	        setColumnsDefinition(getPsnlP029001ToPsnl0126ColumnsList());
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
//	        setCellModel(true);
	        
    	}else if ("PSNLP029002".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setColumnsDefinition(getPsnlP029002ToPsnl0126ColumnsList());
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
//	        setCellModel(true);
	        
    	}
    }

    private List<ColumnDef> getPsnl0290ToPsnl0126ColumnsList(){ 
    	  
    	// 휴가일수
    	changeValueListenerAdapter1 = new ColumnDefListenerAdapter() {
       	
    		@SuppressWarnings("rawtypes")
    		public void run(Field field, Object valueField) {
    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field)  
    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
    			 final ModelData formModel = formPanel.getFormBinding().getModel();
    			 
    			 Double hodyApptnNumDys = (Double) valueField; 								// 휴가적용일수
    			 Double spclHodyNumDys = formModel.get(Psnl0126BM.ATTR_SPCLHODYNUMDYS); 	// 특별휴가일수
    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS);		// 휴가사용일수  
    			 Double spclHodyUseDys = formModel.get(Psnl0126BM.ATTR_SPCLHODYUSEDYS); 	// 특별휴가사용일수
//    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS);   
    	         if (MSFSharedUtils.paramNotNull(hodyApptnNumDys) && MSFSharedUtils.paramNotNull(hodyUseNumDys) ) {
    	             if (hodyUseNumDys.compareTo(hodyApptnNumDys) > 0) {
//    	                    field.markInvalid("값이크당.");    //config 에선언시 에러 .MSFSharedUtils.MSG.valError_MinMaxSalary()
    	                }
    	         }
    	         
    	         Double hodyRstNumDys = (hodyApptnNumDys +spclHodyNumDys) - (hodyUseNumDys + spclHodyUseDys); 
    	         
    	         formModel.set(Psnl0126BM.ATTR_HODYRSTNUMDYS, hodyRstNumDys);
    	         
    		}
    	};
    	
    	// 특별휴가일수
    	changeValueListenerAdapter2 = new ColumnDefListenerAdapter() {
           	
    		@SuppressWarnings("rawtypes")
    		public void run(Field field, Object valueField) {
    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field)  
    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
    			 final ModelData formModel = formPanel.getFormBinding().getModel();
    			 
    			 Double hodyApptnNumDys = formModel.get(Psnl0126BM.ATTR_HODYAPPTNNUMDYS);	// 휴가적용일수
    			 Double spclHodyNumDys = (Double) valueField; 								// 특별휴가일수
    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS); 		// 휴가사용일수  
    			 Double spclHodyUseDys = formModel.get(Psnl0126BM.ATTR_SPCLHODYUSEDYS); 	// 특별휴가사용일수
    			 
//    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS);   
    	         if (MSFSharedUtils.paramNotNull(hodyApptnNumDys) && MSFSharedUtils.paramNotNull(hodyUseNumDys) ) {
    	             if (hodyUseNumDys.compareTo(hodyApptnNumDys) > 0) {
//    	                    field.markInvalid("값이크당.");    //config 에선언시 에러 .MSFSharedUtils.MSG.valError_MinMaxSalary()
    	                }
    	         }
    	         
    	         Double hodyRstNumDys = (hodyApptnNumDys +spclHodyNumDys) - (hodyUseNumDys + spclHodyUseDys);  
    	         
    	         formModel.set(Psnl0126BM.ATTR_HODYRSTNUMDYS, hodyRstNumDys);
    	         
    		}
    	};
    	
    	// 사용일수
    	changeValueListenerAdapter3 = new ColumnDefListenerAdapter() {
           	
    		@SuppressWarnings("rawtypes")
    		public void run(Field field, Object valueField) {
    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field)  
    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
    			 final ModelData formModel = formPanel.getFormBinding().getModel();
    			 
    			 Double hodyApptnNumDys = formModel.get(Psnl0126BM.ATTR_HODYAPPTNNUMDYS); 	// 휴가적용일수
    			 Double spclHodyNumDys = formModel.get(Psnl0126BM.ATTR_SPCLHODYNUMDYS); 	// 특별휴가일수
    			 Double hodyUseNumDys =  (Double) valueField ;   // formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS); 휴가사용일수   
    			 Double spclHodyUseDys = formModel.get(Psnl0126BM.ATTR_SPCLHODYUSEDYS); 	// 특별휴가사용일수
//    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS);   
    	         if (MSFSharedUtils.paramNotNull(hodyApptnNumDys) && MSFSharedUtils.paramNotNull(hodyUseNumDys) ) {
    	             if (hodyUseNumDys.compareTo(hodyApptnNumDys) > 0) {
//    	                    field.markInvalid("값이크당.");    //config 에선언시 에러 .MSFSharedUtils.MSG.valError_MinMaxSalary()
    	                }
    	         }
    	         
    	         Double hodyRstNumDys = (hodyApptnNumDys +spclHodyNumDys) - (hodyUseNumDys + spclHodyUseDys); 
    	         
    	         formModel.set(Psnl0126BM.ATTR_HODYRSTNUMDYS, hodyRstNumDys);
    	         
    		}
    	};
    	
    	// 특별휴가사용일수
    	changeValueListenerAdapter4 = new ColumnDefListenerAdapter() {
           	
    		@SuppressWarnings("rawtypes")
    		public void run(Field field, Object valueField) {
    			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field)  
    			 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
    			 final ModelData formModel = formPanel.getFormBinding().getModel();
    			 
    			 Double hodyApptnNumDys = formModel.get(Psnl0126BM.ATTR_HODYAPPTNNUMDYS); 	// 휴가적용일수
    			 Double spclHodyNumDys = formModel.get(Psnl0126BM.ATTR_SPCLHODYNUMDYS); 	// 특별휴가일수
    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS) ;   // formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS); 휴가사용일수   
    			 Double spclHodyUseDys = (Double) valueField ; 	// 특별휴가사용일수
//    			 Double hodyUseNumDys =  formModel.get(Psnl0126BM.ATTR_HODYUSENUMDYS);   
    	         if (MSFSharedUtils.paramNotNull(hodyApptnNumDys) && MSFSharedUtils.paramNotNull(hodyUseNumDys) ) {
    	             if (hodyUseNumDys.compareTo(hodyApptnNumDys) > 0) {
//    	                    field.markInvalid("값이크당.");    //config 에선언시 에러 .MSFSharedUtils.MSG.valError_MinMaxSalary()
    	                }
    	         }
    	         
    	         Double hodyRstNumDys = (hodyApptnNumDys +spclHodyNumDys) - (hodyUseNumDys + spclHodyUseDys); 
    	         
    	         formModel.set(Psnl0126BM.ATTR_HODYRSTNUMDYS, hodyRstNumDys);
    	         
    		}
    	};
    		
    		
    		
    		
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Psnl0126BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        		

        	}
        });
        
        
        /** column 휴가적용년도 : hodyApptnYr */
        listColumnDefs.add(new ColumnDef("년도", Psnl0126BM.ATTR_HODYAPPTNYR, ColumnDef.TYPE_STRING, 70, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0126BM.ATTR_CURRAFFNDEPTNM, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0126BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Psnl0126BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 100, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        

        /** column 주민등록번호 : resnSecNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Psnl0126BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 근속년수 : logSvcYrNumNm */
        listColumnDefs.add(new ColumnDef("근속년수", Psnl0126BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 80, false, true, true){
            {
            	setReadOnly(true);
           
            }
        });
        
        /** column 연가보상비적용여부 : lvsgCoptnCstApptnYn */
        listColumnDefs.add(new ColumnDef("연(월)차수당", Psnl0126BM.ATTR_LVSGCOPTNCSTAPPTNYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
            {
            	
            }
        });   
        
        /** column 휴가일수_시스템 계산 : hodyNumDysSysCalc */
        listColumnDefs.add(new ColumnDef("계산", Psnl0126BM.ATTR_HODYNUMDYSSYSCALC, ColumnDef.TYPE_LONG,  80, true, true, true){
            {
            	setRegEx("[^0-9]");
            	setReadOnly(true);
            }
        });
        
        
        /** column 휴가적용일수 : hodyApptnNumDys */
        listColumnDefs.add(new ColumnDef("기본", Psnl0126BM.ATTR_HODYAPPTNNUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {	
            	addTrigger(Events.Change, changeValueListenerAdapter1);
            	setRegEx("[^0-9]");
            	setSelectOnFocus(true);
            	
            }
        });
        
//        ModelData formModel = getMsfGridPanel().getMSFFormPanel().getModel();
        
        
        /** column 특별휴가일수 : spclHodyNumDys */
        listColumnDefs.add(new ColumnDef("특별", Psnl0126BM.ATTR_SPCLHODYNUMDYS, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
        	{
//        		addTrigger(Events.Change, changeValueListenerAdapter);
        		addTrigger(Events.KeyUp, changeValueListenerAdapter2);
        		
        		setRegEx("[^0-9]");
        		
        	}
        });
//        
//        /** column 휴가적용일수 : hodyApptnNumDys */
//        hodyApptnNumDysColumnDef = new ColumnListDef("휴가일수", Psnl0126BM.ATTR_HODYAPPTNNUMDYS, ColumnDef.TYPE_DOUBLE, 60, true, true, true, null, customListMethod, customListMethod)
//    	{{  
//    		addTrigger(Events.Change, changeValueListenerAdapter);
////    		addTrigger(Events.Show, changeValueListenerAdapter);  
//    	}};
//    	listColumnDefs.add(hodyApptnNumDysColumnDef);

        
        /** column 휴가사용일수 : hodyUseNumDys */
        listColumnDefs.add(new ColumnDef("휴가", Psnl0126BM.ATTR_HODYUSENUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {
            	addTrigger(Events.KeyUp, changeValueListenerAdapter3);
            	setRegEx("[^0-9]");
            	setSelectOnFocus(true);
            }
        });
        
        listColumnDefs.add(new ColumnDef("특별휴가", Psnl0126BM.ATTR_SPCLHODYUSEDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {
            	addTrigger(Events.KeyUp, changeValueListenerAdapter4);
            	setRegEx("[^0-9]");
            	setSelectOnFocus(true);
            }
        });
        
        /** column 휴가잔여일수 : hodyRstNumDys */
        listColumnDefs.add(new ColumnDef("잔여일수", Psnl0126BM.ATTR_HODYRSTNUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {
            	setRegEx("[^0-9]");
            	setReadOnly(true);
            }
        });
        
        
        /** column 휴가비고내용 : hodyNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Psnl0126BM.ATTR_HODYNOTECTNT, ColumnDef.TYPE_STRING, 200, false, true, true){
            {

            }
        });
        
        /** column 휴가확정여부 : hodyFixYn */
        listColumnDefs.add(new ColumnDef("확정", Psnl0126BM.ATTR_HODYFIXYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 휴가확정일자 : hodyFixDt */
        listColumnDefs.add(new ColumnDef("휴가확정일자", Psnl0126BM.ATTR_HODYFIXDT, ColumnDef.TYPE_DATE , 90, false, false, true){
        	{
        		setReadOnly(true);
        		setDtFieldMask("9999.99.99");
        	}
        });
        
        /** column 휴가시작일자 : hodyBgnnDt */
        listColumnDefs.add(new ColumnDef("휴가시작일자", Psnl0126BM.ATTR_HODYBGNNDT, ColumnDef.TYPE_DATE, 90, false, false, true){
            {
            	setReadOnly(true);
        		setDtFieldMask("9999.99.99");
            }
        });
        
        /** column 휴가종료일자 : HODY_END_DT */
        listColumnDefs.add(new ColumnDef("휴가종료일자", Psnl0126BM.ATTR_HODYENDDT, ColumnDef.TYPE_DATE, 90, false, false, true){
            {
            	setReadOnly(true);
        		setDtFieldMask("9999.99.99");
            }
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Psnl0126BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** set 직종세통합코드명 : dtilOccuInttnNm */
        listColumnDefs.add(new ColumnDef("직종세", Psnl0126BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Psnl0126BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 150, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        //-------------------------------------------------------------------------------------------------------------------------
       
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0126BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        
        
        /** column 연가보상비적용일자 : lvsgCoptnCstApptnDt */
        listColumnDefs.add(new ColumnDef("연가보상비적용일자", Psnl0126BM.ATTR_LVSGCOPTNCSTAPPTNDT, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        
        
//        /** column 휴가일수_PSNL2100 : hodyNumDys */
//        listColumnDefs.add(new ColumnDef("계산일수", Psnl0126BM.ATTR_HODYNUMDYS, ColumnDef.TYPE_LONG, 60, true, false, false){
//            {
//            	
//            }
//        }); 
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Psnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        }); 
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Psnl0126BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0126BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종명", Psnl0126BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Psnl0126BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING, 90, true, false, false){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0126BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** set 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0126BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        
//		 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
//		 ModelData formModel = formPanel.getFormBinding().getModel();
        
        
        return listColumnDefs;
         
    }
    
    
    
    private List<ColumnDef> getPsnl0295ToPsnl0126ColumnsList(){
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /** column 휴가적용년도 : hodyApptnYr */
        listColumnDefs.add(new ColumnDef("년도", Psnl0126BM.ATTR_HODYAPPTNYR, ColumnDef.TYPE_STRING, 70, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0126BM.ATTR_CURRAFFNDEPTNM, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0126BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Psnl0126BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 100, true, true, true){
            {
            	setReadOnly(true);
            }
        });

        /** column 휴가일수_시스템 계산 : hodyNumDysSysCalc */
        listColumnDefs.add(new ColumnDef("계산일수", Psnl0126BM.ATTR_HODYNUMDYSSYSCALC, ColumnDef.TYPE_LONG,  80, true, true, true){
            {
            	setRegEx("[^0-9]");
            	setReadOnly(true);
            }
        });
        
        
        /** column 휴가적용일수 : hodyApptnNumDys */
        listColumnDefs.add(new ColumnDef("휴가일수", Psnl0126BM.ATTR_HODYAPPTNNUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {	
//            	addTrigger(Events.Change, changeValueListenerAdapter);
            	setRegEx("[^0-9]");
            	setSelectOnFocus(true);
            }
        });
        
        /** column 특별휴가일수 : spclHodyNumDys */
        listColumnDefs.add(new ColumnDef("특별휴가일수", Psnl0126BM.ATTR_SPCLHODYNUMDYS, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
        	{
        		setRegEx("[^0-9]");
        	}
        });
//        
//        /** column 휴가적용일수 : hodyApptnNumDys */
//        hodyApptnNumDysColumnDef = new ColumnListDef("휴가일수", Psnl0126BM.ATTR_HODYAPPTNNUMDYS, ColumnDef.TYPE_DOUBLE, 60, true, true, true, null, customListMethod, customListMethod)
//    	{{  
//    		addTrigger(Events.Change, changeValueListenerAdapter);
////    		addTrigger(Events.Show, changeValueListenerAdapter);  
//    	}};
//    	listColumnDefs.add(hodyApptnNumDysColumnDef);

        
        /** column 휴가사용일수 : hodyUseNumDys */
        listColumnDefs.add(new ColumnDef("휴가", Psnl0126BM.ATTR_HODYUSENUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {
//            	addTrigger(Events.Change, changeValueListenerAdapter);
            	setRegEx("[^0-9]");
            	setSelectOnFocus(true);
            }
        });
        
        listColumnDefs.add(new ColumnDef("특별휴가", Psnl0126BM.ATTR_SPCLHODYUSEDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {
//            	addTrigger(Events.Change, changeValueListenerAdapter);
            	setRegEx("[^0-9]");
            	setSelectOnFocus(true);
            }
        });
        
        
        /** column 휴가잔여일수 : hodyRstNumDys */
        listColumnDefs.add(new ColumnDef("잔여일수", Psnl0126BM.ATTR_HODYRSTNUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {
            	setRegEx("[^0-9]");
            	setReadOnly(true);
            }
        });
        
        
        /** column 휴가비고내용 : hodyNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Psnl0126BM.ATTR_HODYNOTECTNT, ColumnDef.TYPE_STRING, 200, false, true, true){
            {

            }
        });
        
        /** column 휴가확정여부 : hodyFixYn */
        listColumnDefs.add(new ColumnDef("확정", Psnl0126BM.ATTR_HODYFIXYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
            {

            }
        });
        
        /** column 휴가확정일자 : hodyFixDt */
        listColumnDefs.add(new ColumnDef("휴가확정일자", Psnl0126BM.ATTR_HODYFIXDT, ColumnDef.TYPE_DATE , 90, false, true, true){
        	{
        		setReadOnly(true);
        		setDtFieldMask("9999.99.99");
        	}
        });
        
        /** column 휴가시작일자 : hodyBgnnDt */
        listColumnDefs.add(new ColumnDef("휴가시작일자", Psnl0126BM.ATTR_HODYBGNNDT, ColumnDef.TYPE_DATE, 90, false, true, true){
            {
            	setReadOnly(true);
        		setDtFieldMask("9999.99.99");
            }
        });
        
        /** column 휴가종료일자 : HODY_END_DT */
        listColumnDefs.add(new ColumnDef("휴가종료일자", Psnl0126BM.ATTR_HODYENDDT, ColumnDef.TYPE_DATE, 90, false, true, true){
            {
            	setReadOnly(true);
        		setDtFieldMask("9999.99.99");
            }
        });
        
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Psnl0126BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Psnl0126BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {

            }
        });
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Psnl0126BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 150, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 퇴직일자 : retryDt */
        listColumnDefs.add(new ColumnDef("퇴직일자", Psnl0100BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING, 150, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        //-------------------------------------------------------------------------------------------------------------------------
        
        /** column 주민등록번호 : resnSecNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Psnl0126BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
            {
            	setReadOnly(true);
            }
        });
        
       
        /** column 휴가확정일자 : hodyFixDt */
        listColumnDefs.add(new ColumnDef("휴가확정일자", Psnl0126BM.ATTR_HODYFIXDT, ColumnDef.TYPE_DATE , 90, false, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0126BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        
        
        
        /** column 휴가시작일자 : hodyBgnnDt */
        listColumnDefs.add(new ColumnDef("휴가시작일자", Psnl0126BM.ATTR_HODYBGNNDT, ColumnDef.TYPE_DATE, 90, false, false, false){
            {

            }
        });
        
        /** column 휴가종료일자 : HODY_END_DT */
        listColumnDefs.add(new ColumnDef("휴가종료일자", Psnl0126BM.ATTR_HODYENDDT, ColumnDef.TYPE_DATE, 90, false, false, false){
            {

            }
        });
        
        
        /** column 연가보상비적용일자 : lvsgCoptnCstApptnDt */
        listColumnDefs.add(new ColumnDef("연가보상비적용일자", Psnl0126BM.ATTR_LVSGCOPTNCSTAPPTNDT, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        
        
        
//        /** column 휴가일수_PSNL2100 : hodyNumDys */
//        listColumnDefs.add(new ColumnDef("계산일수", Psnl0126BM.ATTR_HODYNUMDYS, ColumnDef.TYPE_LONG, 60, true, false, false){
//            {
//            	
//            }
//        });
        
        
        
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Psnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Psnl0126BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0126BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종명", Psnl0126BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        
        
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Psnl0126BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, false, false){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0126BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** set 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0126BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Psnl0126BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Psnl0126BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Psnl0126BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Psnl0126BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Psnl0126BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Psnl0126BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
        
        
        return listColumnDefs;
    }
    
    private List<ColumnDef> getPsnlP029001ToPsnl0126ColumnsList(){
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0126BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0126BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 휴가적용년도 : hodyApptnYr */
        listColumnDefs.add(new ColumnDef("년도", Psnl0126BM.ATTR_HODYAPPTNYR, ColumnDef.TYPE_STRING, 70, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0126BM.ATTR_CURRAFFNDEPTNM, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0126BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 생년월일 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("생년월일", Psnl0126BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING, 100, true, true, true){
            {
            	setReadOnly(true);
            }
        });

        /** column 휴가일수_시스템 계산 : hodyNumDysSysCalc */
        listColumnDefs.add(new ColumnDef("계산일수", Psnl0126BM.ATTR_HODYNUMDYSSYSCALC, ColumnDef.TYPE_LONG,  80, true, true, true){
            {
            	setRegEx("[^0-9]");
            	setReadOnly(true);
            }
        });
        
        /** column 휴가일수_시스템 계산 : hodyNumDysSysCalc */
        listColumnDefs.add(new ColumnDef("조정일수", Psnl0126BM.ATTR_CHNNUMDYS, ColumnDef.TYPE_LONG,  80, true, true, true){
            {
            	setRegEx("[^0-9]");
            }
        });
        
        return listColumnDefs;
    }
    
    private List<ColumnDef> getPsnlP029002ToPsnl0126ColumnsList(){
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
                
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0126BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
            {

            }
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0126BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 휴가적용년도 : hodyApptnYr */
        listColumnDefs.add(new ColumnDef("년도", Psnl0126BM.ATTR_HODYAPPTNYR, ColumnDef.TYPE_STRING, 70, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0126BM.ATTR_CURRAFFNDEPTNM, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0126BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 생년월일 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("생년월일", Psnl0126BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING, 100, true, true, true){
            {
            	setReadOnly(true);
            }
        });
        
        /** column 휴가적용일수 : hodyApptnNumDys */
        listColumnDefs.add(new ColumnDef("휴가일수", Psnl0126BM.ATTR_HODYAPPTNNUMDYS, ColumnDef.TYPE_DOUBLE, 80, true, true, true){
            {	
            	setReadOnly(true);
            	setRegEx("[^0-9]");
            }
        });
        
        /** column 휴가일수_시스템 계산 : hodyNumDysSysCalc */
        listColumnDefs.add(new ColumnDef("조정일수", Psnl0126BM.ATTR_CHNNUMDYS, ColumnDef.TYPE_LONG,  80, true, true, true){
            {
            	setRegEx("[^0-9]");
            }
        });
        
        /** column 대상자 존재여부 : hodyNumDysSysYn */
        listColumnDefs.add(new ColumnDef("대상자 존재여부", Psnl0126BM.ATTR_HODYNUMDYSSYSYN, ColumnDef.TYPE_BOOLEAN,  80, true, true, true){
            {
            }
        });
        
        return listColumnDefs;
    }
    
}