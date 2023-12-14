/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0350BM;
import com.app.exterms.basis.client.dto.Psnl2100BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0320BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0350;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Psnl2100Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
//    private PrgmComBass0300DTO sysComBass0300Dto;
    private PrgmComBass0320DTO sysComBass0320Dto ;
//    private PrgmComBass0400DTO sysComBass0400Dto;
//    private PrgmComBass0500DTO sysComBass0500Dto;
    
    public static final String COLUMN_DEF_TYPOCCUCD = "typOccuCd"; 
    public static final String COLUMN_DEF_DTILOCCUCLSDIVCD = "dtilOccuInttnCd"; 

    public static final String FIELD_ID_TYPOCCUCD = COLUMN_DEF_TYPOCCUCD + "$typOccuCd"; 
    public static final String FIELD_ID_DTILOCCUCLSDIVCD = COLUMN_DEF_DTILOCCUCLSDIVCD + "$dtilOccuInttnCd"; 
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter; 
    
    protected ColumnListDef typOccuCdColumnDef;
    protected ColumnListDef dtilOccuClsDivCdColumnDef;
    
    protected ColumnListDef hodyNumDysBgnnDtColumnDef;
    protected ColumnDef hodyNumDysEndDtColumnDef;
    
    
    public Psnl2100Def(){
    	
		sysComBass0320Dto = new PrgmComBass0320DTO();

		setTitle("");
		setDaoClass(CLASS_BASS0310_PSNL2100_SAVE);
		setCustomListMethod(CLASS_BASS0310_PSNL2100_LIST);
		setColumnsDefinition(getAllColumnsList());
		setAutoFillGrid(true); // 그리드 크기 자동조정
		setShowFilterToolbar(false);
		setEditFieldGrid(false);
	}
    
    public Psnl2100Def(String chkDef){
    	if ("BASS0310_PSNL2100_COPY_1".equals(chkDef)) {
	        setTitle("");
	        setDaoClass(CLASS_BASS0310_PSNL2100_COPY_LIST);
	        setCustomListMethod(CLASS_BASS0310_PSNL2100_COPY_LIST);
	        setAutoFillGrid(true); // 그리드 크기 자동조정
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getBass031001List());  
	      
    	}else if ("BASS0310_PSNL2100_COPY_2".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_BASS0310_PSNL2100_COPY_LIST);
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getBass031001List2());  
	      
    	}else if ("BASS0310_PSNL2100_COPY_3".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_BASS0310_PSNL2100_LIST);
	        setAutoFillGrid(true); // 그리드 크기 자동조정
	        setShowFilterToolbar(false);
//	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getBass031001List3());  
	      
    	}
    }

	private List<ColumnDef> getAllColumnsList(){
    	
    	 //We create a Listener Adapter to run custom code when one of the combo boxes changes value.
        //The listener adapter is attached to the combo boxes using the method ColumnDef.addTrigger().
        changeValueListenerAdapter = new ColumnDefListenerAdapter() {
        	
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {
                // WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
                //To get by name the combo box fields
                Field dtilOccuClsDivCdField = findFieldByAttributeName(FIELD_ID_DTILOCCUCLSDIVCD); 
                
                if (FIELD_ID_TYPOCCUCD.equals(field.getItemId())) {
                    //Clear countries and locations
                    GWTUtils.clearField(dtilOccuClsDivCdField); 
                    //Reload Countries
                    BaseModel item = (BaseModel)valueField;
                    //String typOccuCd = ((String)item.get("typOccuCd")).substring(0, ((String)item.get("typOccuCd")).indexOf("!"));
                    String typOccuCd =  item.get("typOccuCd") ;
                    dtilOccuClsDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("typOccuCd", typOccuCd, SimpleColumnFilter.OPERATOR_EQUALS));
                    dtilOccuClsDivCdColumnDef.readData();
                 }
            }
        };
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Psnl2100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, false){
    		{

    		}
    	});
    	/** column 휴가일수일련번호 : hodyNumDysSeilNum */
    	listColumnDefs.add(new ColumnDef("번호", Psnl2100BM.ATTR_HODYNUMDYSSEILNUM, ColumnDef.TYPE_LONG , 90, true, true, true){
    		{
    			setReadOnly(true);
    		}
    	});
//    	/** column 직종코드 : typOccuCd */
//    	listColumnDefs.add(new ColumnListDef("직종", Psnl2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0350TypOccuCd(),PrgmComBass0350BM.ATTR_TYPOCCUCD,PrgmComBass0350BM.ATTR_TYPOCCUNM){
//    		{
//
//     		}
//     	});
//    	/** column 직종코드 : typOccuCd */
//    	typOccuCdColumnDef = new ColumnListDef("직종", Psnl2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0320(),PrgmComBass0320BM.ATTR_TYPOCCUCD,PrgmComBass0320BM.ATTR_TYPOCCUNM)
//    	{{  
//    		addTrigger(Events.Select, changeValueListenerAdapter);  
////    		addTrigger(Events.Show, changeValueListenerAdapter);  
//    	}};
//    	listColumnDefs.add(typOccuCdColumnDef);
    	
//    	/** column 직종코드 : typOccuCd */
//    	typOccuCdColumnDef = new ColumnListDef("직종", Psnl2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0320(),PrgmComBass0350BM.ATTR_TYPOCCUCD,PrgmComBass0350BM.ATTR_TYPOCCUNM)
//    	{{  
////    		addTrigger(Events.Select, changeValueListenerAdapter);  
////    		addTrigger(Events.Show, changeValueListenerAdapter);  
//    	}};
//    	listColumnDefs.add(typOccuCdColumnDef);
    	
        
        /** column 직종코드 : typOccuCd */
        typOccuCdColumnDef = new ColumnListDef("직종", Psnl2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0320(),PrgmComBass0320BM.ATTR_TYPOCCUCD,PrgmComBass0350BM.ATTR_TYPOCCUNM)
    	{{  
        	addTrigger(Events.Change, changeValueListenerAdapter);  
        }};
        listColumnDefs.add(typOccuCdColumnDef);
    	
    	
    	
        /** column 직종세통합코드 : dtilOccuInttnCd */
    	dtilOccuClsDivCdColumnDef = new ColumnListDef("직종세", Psnl2100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0350(), PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD, PrgmComBass0350BM.ATTR_DTILOCCUCLSNM)
    	{{ 
    		
    	}};
    	listColumnDefs.add(dtilOccuClsDivCdColumnDef);
        
        
             
    	/** column 호봉등급코드 : pyspGrdeCd */
    	listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl2100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			
    		}
    	});
    	/** column 휴가일수이상 : hodyNumDysOvr */
    	listColumnDefs.add(new ColumnDef("이상", Psnl2100BM.ATTR_HODYNUMDYSOVR, ColumnDef.TYPE_LONG, 90, true, true, true){
    		{
    			
    		}
    	});
    	/** column 휴가일수미만 : hodyNumDysUdr */
    	listColumnDefs.add(new ColumnDef("미만", Psnl2100BM.ATTR_HODYNUMDYSUDR, ColumnDef.TYPE_LONG , 90, true, true, true){
    		{

    		}
    	});
    	/** column 휴가일수유형코드 : hodyNumDysFrmCd */
    	listColumnDefs.add(new ColumnDef("휴가일수유형코드", Psnl2100BM.ATTR_HODYNUMDYSFRMCD, ColumnDef.TYPE_STRING , 90, true, false, false){
    		{

    		}
    	});
    	/** column 휴가일수 : hodyNumDys */
    	listColumnDefs.add(new ColumnDef("휴가일수", Psnl2100BM.ATTR_HODYNUMDYS, ColumnDef.TYPE_LONG , 90, true, true, true){
    		{

    		}
    	});
    	/** column 휴가일수율 : hodyNumDysRate */
    	listColumnDefs.add(new ColumnDef("휴가일수율", Psnl2100BM.ATTR_HODYNUMDYSRATE, ColumnDef.TYPE_DOUBLE, 90, true, false, false){
    		{

    		}
    	});
    	/** column 휴가일수시작일자 : hodyNumDysBgnnDt */
    	listColumnDefs.add(new ColumnDef("시작일자", Psnl2100BM.ATTR_HODYNUMDYSBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
    		{
    			setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
    		}
    	});
    	
    	
    	/** column 휴가일수종료일자 : hodyNumDysEndDt */
    	listColumnDefs.add(new ColumnDef("종료일자", Psnl2100BM.ATTR_HODYNUMDYSENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
    		{
    			setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");

    		}
    	});
    	/** column 휴가일수사용여부 : hodyNumDysUseYn */
    	listColumnDefs.add(new ColumnDef("사용", Psnl2100BM.ATTR_HODYNUMDYSUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
    		{

    		}
    	});
    	/** column 휴가일수비고내용 : hodyNumDysNoteCtnt */
    	listColumnDefs.add(new ColumnDef("비고내용", Psnl2100BM.ATTR_HODYNUMDYSNOTECTNT, ColumnDef.TYPE_STRING, 90, false, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTAREA); 
    		}
    	});
//    	/** column 입력자 : kybdr */
//    	listColumnDefs.add(new ColumnDef("입력자", Psnl2100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력일자 : inptDt */
//    	listColumnDefs.add(new ColumnDef("입력일자", Psnl2100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력주소 : inptAddr */
//    	listColumnDefs.add(new ColumnDef("입력주소", Psnl2100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정자 : ismt */
//    	listColumnDefs.add(new ColumnDef("수정자", Psnl2100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정일자 : revnDt */
//    	listColumnDefs.add(new ColumnDef("수정일자", Psnl2100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정주소 : revnAddr */
//    	listColumnDefs.add(new ColumnDef("수정주소", Psnl2100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});

//    	 
    	return listColumnDefs;
    }
    
    private List<ColumnDef> getBass031001List(){
    	    	
       row = 0;
       List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
       
       listColumnDefs.add(new ColumnDef("직종명", Bass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 110, true, true, true){
       	{
       		setReadOnly(true);
       	}
       });
       
       listColumnDefs.add(new ColumnDef("직종코드", Bass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 110, true, false, true){
       	{
       		setReadOnly(true);
       	}
       });

       /** column 직종세통합코드 : dtilOccuInttnCd */
       listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 100, true, true, true){
       	{
       		setReadOnly(true);	
       	}
       });  
       
       /** column 직종세명 : dtilOccuClsNm */
       listColumnDefs.add(new ColumnDef("직종세명", Bass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 112, true, true, true){
       	{
       		setReadOnly(true);
       	}
       }); 
             
       /** column 직종세사용여부 : dtilOccuClsUseYn */
       listColumnDefs.add(new ColumnDef("사용여부", Bass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
       	{

       	}
       });
       
       /** column 휴가일수사용여부 : hodyNumDysUseYn */
       listColumnDefs.add(new ColumnDef("등록여부", Psnl2100BM.ATTR_HODYNUMDYSUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){  	
    	   
       });
   	
       return listColumnDefs;
   }
    private List<ColumnDef> getBass031001List2(){
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
                
        listColumnDefs.add(new ColumnDef("직종명", Bass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        listColumnDefs.add(new ColumnDef("직종코드", Bass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 110, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        

        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		setReadOnly(true);	
        	}
        }); 
        
        /** column 직종세명 : dtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직종세명", Bass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 112, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });            
        
        /** column 휴가일수사용여부 : hodyNumDysUseYn */
        listColumnDefs.add(new ColumnDef("등록여부", Psnl2100BM.ATTR_HODYNUMDYSUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){  	
     	   
        });
    	
        return listColumnDefs;
    }
    
    private List<ColumnDef> getBass031001List3() {
    	 changeValueListenerAdapter = new ColumnDefListenerAdapter() {
         	
             @SuppressWarnings("rawtypes")
             public void run(Field field, Object valueField) {
                 // WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
                 //To get by name the combo box fields
                 Field dtilOccuClsDivCdField = findFieldByAttributeName(FIELD_ID_DTILOCCUCLSDIVCD); 
                 
                 if (FIELD_ID_TYPOCCUCD.equals(field.getItemId())) {
                     //Clear countries and locations
                     GWTUtils.clearField(dtilOccuClsDivCdField); 
                     //Reload Countries
                     BaseModel item = (BaseModel)valueField;
                     //String typOccuCd = ((String)item.get("typOccuCd")).substring(0, ((String)item.get("typOccuCd")).indexOf("!"));
                     String typOccuCd =  item.get("typOccuCd") ;
                     dtilOccuClsDivCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("typOccuCd", typOccuCd, SimpleColumnFilter.OPERATOR_EQUALS));
                     dtilOccuClsDivCdColumnDef.readData();
                  }
             }
         };
         
    	row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
                
        /** column 직종코드 : typOccuCd */
        typOccuCdColumnDef = new ColumnListDef("직종", Psnl2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0320(),PrgmComBass0320BM.ATTR_TYPOCCUCD,PrgmComBass0350BM.ATTR_TYPOCCUNM)
    	{{  
        	addTrigger(Events.Change, changeValueListenerAdapter);  
        }};
        listColumnDefs.add(typOccuCdColumnDef);
    	
        /** column 직종세통합코드 : dtilOccuInttnCd */
    	dtilOccuClsDivCdColumnDef = new ColumnListDef("직종세", Psnl2100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, true, true, new LookupPrgmComBass0350(), PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD, PrgmComBass0350BM.ATTR_DTILOCCUCLSNM)
    	{{ 
    		
    	}};
    	listColumnDefs.add(dtilOccuClsDivCdColumnDef);
         
    	/** column 휴가일수이상 : hodyNumDysOvr */
    	listColumnDefs.add(new ColumnDef("이상", Psnl2100BM.ATTR_HODYNUMDYSOVR, ColumnDef.TYPE_LONG, 90, true, true, true){
    		{
    			
    		}
    	});
    	/** column 휴가일수미만 : hodyNumDysUdr */
    	listColumnDefs.add(new ColumnDef("미만", Psnl2100BM.ATTR_HODYNUMDYSUDR, ColumnDef.TYPE_LONG , 90, true, true, true){
    		{

    		}
    	});
    	/** column 휴가일수 : hodyNumDys */
    	listColumnDefs.add(new ColumnDef("일수", Psnl2100BM.ATTR_HODYNUMDYS, ColumnDef.TYPE_LONG , 90, true, true, true){
    		{

    		}
    	});
    	
        return listColumnDefs;
	}

}
