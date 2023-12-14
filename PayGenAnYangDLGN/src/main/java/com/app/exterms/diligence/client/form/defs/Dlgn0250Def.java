/**
 * 공통화면 팝업 
 */
package com.app.exterms.diligence.client.form.defs;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0250BM;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0250Def  extends TableDef implements DiligenceDaoConstants {

    private int row = 0;
    private DiligenceConstants dlgnLabel = DiligenceConstants.INSTANCE;
    
    public static final String COLUMN_DEF_EMYMTDIVCD = "emymtDivCd"; 								/** column 고용구분코드 : emymtDivCd */
    public static final String COLUMN_DEF_DILNLAZWKDDUTYNUMDYS = "dilnlazWkdDutyNumDys"; 			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
    public static final String COLUMN_DEF_DILNLAZTOTDUTYTM = "dilnlazTotDutyTm"; 					/** column 총근무시간 : dilnlazTotDutyTm */
    public static final String COLUMN_DEF_DILNLAZHODYDUTYNUMDYS = "dilnlazHodyDutyNumDys"; 			/** column 휴일일수 : dilnlazHodyDutyNumDys */
    public static final String COLUMN_DEF_DILNLAZTOTDUTYNUMDYS = "dilnlazTotDutyNumDys"; 			/** column 총근무일수 : dilnlazTotDutyNumDys */

    public static final String FIELD_ID_EMYMTDIVCD = COLUMN_DEF_EMYMTDIVCD; 						/** column 고용구분코드 : emymtDivCd */
    public static final String FIELD_ID_DILNLAZWKDDUTYNUMDYS = COLUMN_DEF_DILNLAZWKDDUTYNUMDYS; 	/** column 평일근무일수 : dilnlazWkdDutyNumDys */
    public static final String FIELD_ID_DILNLAZTOTDUTYTM = COLUMN_DEF_DILNLAZTOTDUTYTM; 			/** column 총근무시간 : dilnlazTotDutyTm */
    public static final String FIELD_ID_DILNLAZHODYDUTYNUMDYS = COLUMN_DEF_DILNLAZHODYDUTYNUMDYS;	/** column 휴일일수 : dilnlazHodyDutyNumDys */
    public static final String FIELD_ID_DILNLAZTOTDUTYNUMDYS = COLUMN_DEF_DILNLAZTOTDUTYNUMDYS; 	/** column 총근무일수 : dilnlazTotDutyNumDys */

    
    private ColumnDefListenerAdapter changeValueListenerAdapter1;
    private ColumnDefListenerAdapter changeValueListenerAdapter2;
    private ColumnDefListenerAdapter changeValueListenerAdapter3;
    private ColumnDefListenerAdapter changeValueListenerAdapter4;
    private ColumnDefListenerAdapter changeValueListenerAdapter5; 
    

    public Dlgn0250Def(){
    	
        setTitle("");
        setDaoClass(CLASS_DLGN0250_DATA_LIST);
        setCustomListMethod(CLASS_DLGN0250_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setCheckBoxOnGridRows(true);
        setEditFieldGrid(true);
        setColumnsDefinition(getColumnsList());  
        setCellModel(true);
        
    }
    
    
    private List<ColumnDef> getColumnsList(){ 
    	
    	// 평일일수 수정 시
        changeValueListenerAdapter1 = new ColumnDefListenerAdapter() {

        	@SuppressWarnings("rawtypes")
        		public void run(Field field, Object valueField) {
        		// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
        		
        		 MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
    			 final ModelData formModel = formPanel.getFormBinding().getModel();
    					 
    			 String emymtDivCdStr =formModel.get(Dlgn0250BM.ATTR_EMYMTDIVCD);
    			 BigDecimal dayTm 	= new BigDecimal("8");		// 하루 근무시간
    			 
    			 BigDecimal dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
    			 BigDecimal dilnlazTotDutyTm 		= BigDecimal.ZERO; 			/** column 총근무시간 : dilnlazTotDutyTm */
    			 BigDecimal dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;			/** column 휴일일수 : dilnlazHodyDutyNumDys */
    			 BigDecimal dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 			/** column 총근무일수 : dilnlazTotDutyNumDys */
    			 
 				dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
     			dilnlazTotDutyTm 		= BigDecimal.ZERO; 			/** column 총근무시간 : dilnlazTotDutyTm */
     			dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;			/** column 휴일일수 : dilnlazHodyDutyNumDys */
     			dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 			/** column 총근무일수 : dilnlazTotDutyNumDys */
     			
         		String dilnlazWkdDutyNumDysStr = (String) valueField; 									/** column 평일근무일수 : dilnlazWkdDutyNumDys */
         		String dilnlazTotDutyTmStr =formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM); 			/** column 총근무시간 : dilnlazTotDutyTm */
         		String dilnlazHodyDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZHODYDUTYNUMDYS);	/** column 휴일일수 : dilnlazHodyDutyNumDys */
         		String dilnlazTotDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS); 	/** column 총근무일수 : dilnlazTotDutyNumDys */
         		
    			 	
 	  			// A. 무기계약직 : 근무시간(평일일수 * 8), 총근무일수(평일일수 + 휴일일수) 
         		if("A0020010".equals(emymtDivCdStr)) {
//         			Window.alert("33");
         			// 1. 값 셋팅 
           			dilnlazWkdDutyNumDys = new BigDecimal(dilnlazWkdDutyNumDysStr);								// 평일근무일수 : dilnlazWkdDutyNumDys 
           			dilnlazHodyDutyNumDys = new BigDecimal(dilnlazHodyDutyNumDysStr);							// 휴일일수 : dilnlazHodyDutyNumDys 
           			
           			// 2. 값 산정
         			dilnlazTotDutyTm  	 = dilnlazWkdDutyNumDys.multiply(dayTm);								// 총근무시간 : dilnlazTotDutyTm 
         			dilnlazTotDutyNumDys = dilnlazWkdDutyNumDys.add(dilnlazHodyDutyNumDys);	 					// 총근무일수 : dilnlazTotDutyNumDys 
         			
         			// 3. 값 반영
         			formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, String.valueOf(dilnlazTotDutyTm));			// 총근무시간 : dilnlazTotDutyTm 
//         			formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS, String.valueOf(dilnlazTotDutyNumDys));	// 총근무일수 : dilnlazTotDutyNumDys 
         		
         		// B. 기간제 : 근무시간(평일일수 * 8), 총근무일수(평일일수) 
         		}else {
         			
         			// 1. 값 셋팅 
           			dilnlazWkdDutyNumDys = new BigDecimal(dilnlazWkdDutyNumDysStr);								// 평일근무일수 : dilnlazWkdDutyNumDys 
           			dilnlazHodyDutyNumDys = new BigDecimal(dilnlazTotDutyTmStr);								// 휴일일수 : dilnlazHodyDutyNumDys 
           			
           			// 2. 값 산정
         			dilnlazTotDutyTm  	 = dilnlazWkdDutyNumDys.multiply(dayTm);								// 총근무시간 : dilnlazTotDutyTm 
         			dilnlazTotDutyNumDys = dilnlazWkdDutyNumDys;	 											// 총근무일수 : dilnlazTotDutyNumDys 
         			
         			
         			// 3. 값 반영
         			formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, String.valueOf(dilnlazTotDutyTm));			// 총근무시간 : dilnlazTotDutyTm 
         			formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS, String.valueOf(dilnlazTotDutyNumDys));	// 총근무일수 : dilnlazTotDutyNumDys 
         		}   			 
        	}
        };
        	
        	
        // 근무시간 수정 시
        changeValueListenerAdapter2 = new ColumnDefListenerAdapter() {
        	@SuppressWarnings("rawtypes")
        	public void run(Field field, Object valueField) {
        		
        		// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
            		
            	MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
        		final ModelData formModel = formPanel.getFormBinding().getModel();
        			 
        		String emymtDivCdStr = formModel.get(Dlgn0250BM.ATTR_EMYMTDIVCD);
        		BigDecimal dayTm 	= new BigDecimal("8");		// 하루 근무시간
        			 
        		BigDecimal dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
        		BigDecimal dilnlazTotDutyTm 		= BigDecimal.ZERO; 			/** column 총근무시간 : dilnlazTotDutyTm */
        		BigDecimal dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;			/** column 휴일일수 : dilnlazHodyDutyNumDys */
        		BigDecimal dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 			/** column 총근무일수 : dilnlazTotDutyNumDys */
                    		
        			 
            	dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                dilnlazTotDutyTm 		= BigDecimal.ZERO; 			/** column 총근무시간 : dilnlazTotDutyTm */
                dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;			/** column 휴일일수 : dilnlazHodyDutyNumDys */
                dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 			/** column 총근무일수 : dilnlazTotDutyNumDys */
                			
                String dilnlazWkdDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM); 		/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                String dilnlazTotDutyTmStr =(String) valueField; 										/** column 총근무시간 : dilnlazTotDutyTm */
                String dilnlazHodyDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZHODYDUTYNUMDYS);	/** column 휴일일수 : dilnlazHodyDutyNumDys */
                String dilnlazTotDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS); 	/** column 총근무일수 : dilnlazTotDutyNumDys */
                    		
               			 
                // A. 무기계약직 : 평일일수(근무시간 * 8), 총근무일수(평일일수 + 휴일일수) 
				if ("A0020010".equals(emymtDivCdStr)) {
					// 1. 값 셋팅
					dilnlazTotDutyTm = new BigDecimal(dilnlazTotDutyTmStr); 												// 총근무시간 : dilnlazTotDutyTm
					dilnlazTotDutyNumDys = new BigDecimal(dilnlazTotDutyNumDysStr); 										// 총근무일수 : dilnlazTotDutyNumDys
					dilnlazHodyDutyNumDys = new BigDecimal(dilnlazHodyDutyNumDysStr); 										// 휴일일수 : dilnlazHodyDutyNumDys

					// 2. 값 산정
					dilnlazWkdDutyNumDys = dilnlazTotDutyTm.divide(dayTm, 4,  BigDecimal.ROUND_HALF_UP);					// 평일근무일수:dilnlazWkdDutyNumDys
					dilnlazTotDutyNumDys = dilnlazWkdDutyNumDys.add(dilnlazHodyDutyNumDys); 								// 총근무일수 :dilnlazTotDutyNumDys

					
					// 3. 값 반영
					formModel.set(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS,String.valueOf(dilnlazWkdDutyNumDys)); 				// 평일근무일수 :dilnlazWkdDutyNumDys
					formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS,String.valueOf(dilnlazTotDutyNumDys)); 				// 총근무일수 :dilnlazTotDutyNumDys

					// B. 기간제 : 평일일수(근무시간 * 8), 총근무일수(평일일수)
				} else {
                    			
					// 1. 값 셋팅
					// 1. 값 셋팅
					dilnlazTotDutyTm = new BigDecimal(dilnlazTotDutyTmStr); 												// 총근무시간 : dilnlazTotDutyTm
					dilnlazTotDutyNumDys = new BigDecimal(dilnlazTotDutyNumDysStr); 										// 총근무일수 : dilnlazTotDutyNumDys
					dilnlazHodyDutyNumDys = new BigDecimal(dilnlazHodyDutyNumDysStr); 										// 휴일일수 : dilnlazHodyDutyNumDys


					// 2. 값 산정
					dilnlazWkdDutyNumDys = dilnlazTotDutyTm.multiply(dayTm);												// 평일근무일수: dilnlazWkdDutyNumDys
					dilnlazTotDutyNumDys = dilnlazWkdDutyNumDys; 															// 총근무일수 :dilnlazTotDutyNumDys

					// 3. 값 반영
					formModel.set(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS,String.valueOf(dilnlazWkdDutyNumDys)); 				// 평일근무일수 : dilnlazWkdDutyNumDys
					formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS,String.valueOf(dilnlazTotDutyNumDys)); 				// 총근무일수 :dilnlazTotDutyNumDys

				}
			}
        };	
        	
        	
        // 휴일일수 수정 시
        changeValueListenerAdapter3 = new ColumnDefListenerAdapter() {

        	@SuppressWarnings("rawtypes")
        	public void run(Field field, Object valueField) {
        		// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
                		
                		
        		MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
        		final ModelData formModel = formPanel.getFormBinding().getModel();
            			 
        		String emymtDivCdStr 	= formModel.get(Dlgn0250BM.ATTR_EMYMTDIVCD);
        		BigDecimal dayTm 		= new BigDecimal("8");		// 하루 근무시간
            			 
        		BigDecimal dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;									/** column 평일근무일수 : dilnlazWkdDutyNumDys */
            	BigDecimal dilnlazTotDutyTm 		= BigDecimal.ZERO; 									/** column 총근무시간 : dilnlazTotDutyTm */
            	BigDecimal dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;									/** column 휴일일수 : dilnlazHodyDutyNumDys */
            	BigDecimal dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 									/** column 총근무일수 : dilnlazTotDutyNumDys */
                        	
            			 
            	dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;												/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                dilnlazTotDutyTm 		= BigDecimal.ZERO; 												/** column 총근무시간 : dilnlazTotDutyTm */
                dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;												/** column 휴일일수 : dilnlazHodyDutyNumDys */
                dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 												/** column 총근무일수 : dilnlazTotDutyNumDys */
                			
               	String dilnlazWkdDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS); 	/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                String dilnlazTotDutyTmStr =formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM); 			/** column 총근무시간 : dilnlazTotDutyTm */
                String dilnlazHodyDutyNumDysStr = (String) valueField;									/** column 휴일일수 : dilnlazHodyDutyNumDys */
                String dilnlazTotDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS); 	/** column 총근무일수 : dilnlazTotDutyNumDys */
                    		
               			 
            	// A. 무기계약직 : 평일일수(총근무일수 - 휴일일수), 근무시간(평일일수 * 8), 총근무일수(평일일수 + 휴일일수) 
                if("A0020010".equals(emymtDivCdStr)) {
                	// 1. 값 셋팅 
                   	dilnlazTotDutyNumDys = new BigDecimal(dilnlazTotDutyNumDysStr);								// 총근무일수 : dilnlazTotDutyNumDys 
                    dilnlazHodyDutyNumDys = new BigDecimal(dilnlazHodyDutyNumDysStr);							// 휴일일수 : dilnlazHodyDutyNumDys 
                    			
                    // 2. 값 산정
                    dilnlazWkdDutyNumDys = dilnlazTotDutyNumDys.subtract(dilnlazHodyDutyNumDys);				// 평일근무일수 : dilnlazWkdDutyNumDys 
                    dilnlazTotDutyTm 	 = dilnlazWkdDutyNumDys.multiply(dayTm);								// 총근무시간 : dilnlazTotDutyTm 
                    dilnlazTotDutyNumDys = dilnlazWkdDutyNumDys.add(dilnlazHodyDutyNumDys);	 					// 총근무일수 : dilnlazTotDutyNumDys 
                    			
                    // 3. 값 반영
                    formModel.set(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS, String.valueOf(dilnlazWkdDutyNumDys));	// 평일근무일수 : dilnlazWkdDutyNumDys 
                    formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, String.valueOf(dilnlazTotDutyTm));			// 총근무시간 : dilnlazTotDutyTm 
                    formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS, String.valueOf(dilnlazTotDutyNumDys));	// 총근무일수 : dilnlazTotDutyNumDys 
                    		
                    			
                    // B. 기간제 : 평일일수(총근무일수), 근무시간(평일일수 * 8), 총근무일수(평일일수) 
                    }else {
                    	
                    	// 휴일일수 수정 시 딱히 반영해줄 사항 없음.
                    }           			 
                }
        	} ;
                	
                	
           // 총근무일수 수정 시
        	changeValueListenerAdapter4 = new ColumnDefListenerAdapter() {

        		@SuppressWarnings("rawtypes")
        		public void run(Field field, Object valueField) {
        			// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
                    		
        			MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
                	final ModelData formModel = formPanel.getFormBinding().getModel();
                			 
                	String emymtDivCdStr = formModel.get(Dlgn0250BM.ATTR_EMYMTDIVCD);
                	BigDecimal dayTm 	= new BigDecimal("8");		// 하루 근무시간
                			 
                	BigDecimal dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                	BigDecimal dilnlazTotDutyTm 		= BigDecimal.ZERO; 			/** column 총근무시간 : dilnlazTotDutyTm */
                	BigDecimal dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;			/** column 휴일일수 : dilnlazHodyDutyNumDys */
                	BigDecimal dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 			/** column 총근무일수 : dilnlazTotDutyNumDys */
                            	
                			 
               		dilnlazWkdDutyNumDys 	= BigDecimal.ZERO;			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                	dilnlazTotDutyTm 		= BigDecimal.ZERO; 			/** column 총근무시간 : dilnlazTotDutyTm */
                	dilnlazHodyDutyNumDys 	= BigDecimal.ZERO;			/** column 휴일일수 : dilnlazHodyDutyNumDys */
                	dilnlazTotDutyNumDys 	= BigDecimal.ZERO; 			/** column 총근무일수 : dilnlazTotDutyNumDys */
                			
                    String dilnlazWkdDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS); 	/** column 평일근무일수 : dilnlazWkdDutyNumDys */
                    String dilnlazTotDutyTmStr =formModel.get(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM); 			/** column 총근무시간 : dilnlazTotDutyTm */
                    String dilnlazHodyDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZHODYDUTYNUMDYS);	/** column 휴일일수 : dilnlazHodyDutyNumDys */
                    String dilnlazTotDutyNumDysStr = (String) valueField; 									/** column 총근무일수 : dilnlazTotDutyNumDys */
                    		
               			 
            	  	// A. 무기계약직 : 평일일수(총근무일수 - 휴일일수), 근무시간(평일일수 * 8), 총근무일수(평일일수 + 휴일일수) 
                    if("A0020010".equals(emymtDivCdStr)) {
                    	// 1. 값 셋팅 
                    	dilnlazTotDutyNumDys = new BigDecimal(dilnlazTotDutyNumDysStr);								// 총근무일수 : dilnlazTotDutyNumDys 
                    	dilnlazHodyDutyNumDys = new BigDecimal(dilnlazHodyDutyNumDysStr);							// 휴일일수 : dilnlazHodyDutyNumDys 
                    			
                      			
                    	// 2. 값 산정
                    	dilnlazWkdDutyNumDys = dilnlazTotDutyNumDys.subtract(dilnlazHodyDutyNumDys);				// 평일근무일수 : dilnlazWkdDutyNumDys 
                    	dilnlazTotDutyTm 	 = dilnlazWkdDutyNumDys.multiply(dayTm);								// 총근무시간 : dilnlazTotDutyTm 
//                    	dilnlazTotDutyNumDys = dilnlazWkdDutyNumDys.add(dilnlazHodyDutyNumDys);	 					// 총근무일수 : dilnlazTotDutyNumDys 
                    			
                    	// 3. 값 반영
                    	formModel.set(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS, String.valueOf(dilnlazWkdDutyNumDys));	// 평일근무일수 : dilnlazWkdDutyNumDys 
                    	formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, String.valueOf(dilnlazTotDutyTm));			// 총근무시간 : dilnlazTotDutyTm 
//                    	formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS, String.valueOf(dilnlazTotDutyNumDys));	// 총근무일수 : dilnlazTotDutyNumDys 
                    		
                    			
                    // B. 기간제 : 평일일수(총근무일수), 근무시간(평일일수 * 8) 
                    }else {
                    	// 1. 값 셋팅 
                    	dilnlazTotDutyNumDys = new BigDecimal(dilnlazTotDutyNumDysStr);								// 총근무일수 : dilnlazTotDutyNumDys 
                    	dilnlazHodyDutyNumDys = new BigDecimal(dilnlazHodyDutyNumDysStr);							// 휴일일수 : dilnlazHodyDutyNumDys 
                    			
                    	// 2. 값 산정
                    	dilnlazWkdDutyNumDys = dilnlazTotDutyNumDys;												// 평일근무일수 : dilnlazWkdDutyNumDys 
                    	dilnlazTotDutyTm 	 = dilnlazWkdDutyNumDys.multiply(dayTm);								// 총근무시간 : dilnlazTotDutyTm 
                    			
                    	// 3. 값 반영
                    	formModel.set(Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS, String.valueOf(dilnlazWkdDutyNumDys));	// 평일근무일수 : dilnlazWkdDutyNumDys 
                    	formModel.set(Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, String.valueOf(dilnlazTotDutyTm));			// 총근무시간 : dilnlazTotDutyTm 
                    }
        		}
        	};	
        	
        	
    		// 휴일근무시간 수정 시
            changeValueListenerAdapter5 = new ColumnDefListenerAdapter() {

            	@SuppressWarnings("rawtypes")
            	public void run(Field field, Object valueField) {
            		// WRITE HERE YOUR CODE, Object triggered the listener (i.e. Field) 
                       		
            		MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
                   	final ModelData formModel = formPanel.getFormBinding().getModel();
                   	
                	BigDecimal dayTm 	= new BigDecimal("8");		// 하루 근무시간
                   			 
                   	String dilnlazPubcHodyDutyNumDysStr = formModel.get(Dlgn0250BM.ATTR_DILNLAZPUBCHODYDUTYNUMDYS);		/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
            
                   	
                   	BigDecimal dilnlazPubcHodyDutyNumDys 	= BigDecimal.ZERO;											/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
                	BigDecimal dilnlazPubcHodyDutyTm 	= BigDecimal.ZERO;												/** column 총휴일근무시간 : dilnlazPubcHodyDutyTm */
                   	
                   	dilnlazPubcHodyDutyNumDys 	= BigDecimal.ZERO;														/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
                   	dilnlazPubcHodyDutyTm 	= BigDecimal.ZERO;															/** column 총휴일근무시간 : dilnlazPubcHodyDutyTm */
                   			
                   	
                   	String dilnlazTotDutyNumDysStr = (String) valueField; 												/** column 총휴일근무시간 : dilnlazPubcHodyDutyTm */
                   	
                   	// 1. 값 셋팅 
                   	dilnlazPubcHodyDutyNumDys = new BigDecimal(dilnlazPubcHodyDutyNumDysStr);							// 총휴일근무일수 : dilnlazPubcHodyDutyNumDys 
                   	dilnlazPubcHodyDutyTm = new BigDecimal(dilnlazTotDutyNumDysStr);									// 총휴일근무시간 : dilnlazPubcHodyDutyTm 
                         			
                   	// 2. 값 산정
                   	dilnlazPubcHodyDutyNumDys = dilnlazPubcHodyDutyTm.divide(dayTm);									// 총휴일근무일수 : dilnlazPubcHodyDutyNumDys 
                   	
                   	// 3. 값 반영
                   	formModel.set(Dlgn0250BM.ATTR_DILNLAZPUBCHODYDUTYNUMDYS, String.valueOf(dilnlazPubcHodyDutyNumDys));// 총휴일근무일수 : dilnlazPubcHodyDutyNumDys 
                   	
            	}
            }; 	 	
                	
        	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0250BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0250BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 근태년월 : dilnlazYrMnth */
        listColumnDefs.add(new ColumnDef("근무년월", Dlgn0250BM.ATTR_DILNLAZYRMNTH, ColumnDef.TYPE_STRING , 60, false,true, false){
            {
                setReadOnly(true);
                setTextFdMask("9999.99");
            }
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분", Dlgn0250BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 60, false, false, false){
            {

            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Dlgn0250BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Dlgn0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });

        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Dlgn0250BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", Dlgn0250BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Dlgn0250BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Dlgn0250BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Dlgn0250BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분", Dlgn0250BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
                setReadOnly(true);
                setEnabled(true);
            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Dlgn0250BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Dlgn0250BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
                setReadOnly(true);
            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Dlgn0250BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급", Dlgn0250BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 직종세구분코드 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Dlgn0250BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Dlgn0250BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
                setReadOnly(true);
            }
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Dlgn0250BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, false){
          {
              setReadOnly(true);
          }
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Dlgn0250BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
          {
              setReadOnly(true);
          }
        });
         
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Dlgn0250BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
          {
              setReadOnly(true);
          }
        });
         
      
        /** column 근무일수 : dilnlazDutyNumDys */
        listColumnDefs.add(new ColumnDef("월총일수", Dlgn0250BM.ATTR_DILNLAZDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
            }
        });
        
        //=================== 실근무일수 시작 ===================
        /** column 평일근무일수 : dilnlazWkdDutyNumDys */
        listColumnDefs.add(new ColumnDef("평일일수", Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
            	addTrigger(Events.KeyUp, changeValueListenerAdapter1);
            }
        });
//        dilnlazWkdDutyNumDysColumnDef = new ColumnDef("평일일수", Dlgn0250BM.ATTR_DILNLAZWKDDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false) {
//        	{
//        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
//        		addTrigger(Events.KeyUp, changeValueListenerAdapter1);
//        	}
//        };
//        listColumnDefs.add(dilnlazWkdDutyNumDysColumnDef);
        
        /** column 총근무시간 : dilnlazTotDutyTm */
        listColumnDefs.add(new ColumnDef("근무시간", Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	setReadOnly(true);
//            	addTrigger(Events.KeyUp, changeValueListenerAdapter2);
            }
        });
//        dilnlazTotDutyTmColumnDef = new ColumnDef("근무시간", Dlgn0250BM.ATTR_DILNLAZTOTDUTYTM, ColumnDef.TYPE_STRING , 70, false, true, false) {
//        	{
//        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
////        		setSelectOnFocus(true);
//        		addTrigger(Events.KeyUp, changeValueListenerAdapter1);
//        	}
//        };
//        listColumnDefs.add(dilnlazTotDutyTmColumnDef);
        
        /** column 휴일일수 : dilnlazHodyDutyNumDys */
        listColumnDefs.add(new ColumnDef("휴일일수", Dlgn0250BM.ATTR_DILNLAZHODYDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");  
            	setSelectOnFocus(true);
//            	addTrigger(Events.KeyUp, changeValueListenerAdapter3);
            }
        });
        
        /** column 총근무일수 : dilnlazTotDutyNumDys */
        listColumnDefs.add(new ColumnDef("총근무일수", Dlgn0250BM.ATTR_DILNLAZTOTDUTYNUMDYS, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	addTrigger(Events.KeyUp, changeValueListenerAdapter4);
            }
        });
        //=================== 실근무일수 종료 ===================
        
        /** column 유급휴가일수 : dilnlazPaidHodyNumDys */
        listColumnDefs.add(new ColumnDef("휴가(유급)사용일수", Dlgn0250BM.ATTR_DILNLAZPAIDHODYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        
        
        /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
        listColumnDefs.add(new ColumnDef("교통보조일수", Dlgn0250BM.ATTR_DILNLAZTFCASSCSTNUMDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
        	}
        });
        /** column 근태_급식비일수 : dilnlazLnchDys */
        listColumnDefs.add(new ColumnDef("급식비일수", Dlgn0250BM.ATTR_DILNLAZLNCHDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
        	}
        });
        
        /** set 근태_간식비일수 : dilnlazSppySnkfNumDys */
        listColumnDefs.add(new ColumnDef("간식비일수", Dlgn0250BM.ATTR_DILNLAZSPPYSNKFNUMDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
        		setSelectOnFocus(true);
        	}
        });
        
        /** set 근태_숙직일수 : dilnlazNgtdyNumDys */
        listColumnDefs.add(new ColumnDef("숙직일수", Dlgn0250BM.ATTR_DILNLAZNGTDYNUMDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
        		setSelectOnFocus(true);
        	}
        });
        
        
        
        
        /** column 근태_출장여부 : dilnlazButpYn */
        listColumnDefs.add(new ColumnDef("출장일수", Dlgn0250BM.ATTR_DILNLAZBUTPDYS, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setRegEx("^[+-]?\\d*(\\.?\\d*)$");
        		setSelectOnFocus(true);
        	}
        });

        /** column 특별휴가일수 : dilnlazSpclHodyNumDys */
        listColumnDefs.add(new ColumnDef("특별휴가", Dlgn0250BM.ATTR_DILNLAZSPCLHODYNUMDYS, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 결근일수 : dilnlazAbnceNumDys */
        listColumnDefs.add(new ColumnDef("결근일수", Dlgn0250BM.ATTR_DILNLAZABNCENUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 결근인정일수 : dilnlazAbnceDutyRcgtnDys */
        listColumnDefs.add(new ColumnDef("결근인정", Dlgn0250BM.ATTR_DILNLAZABNCEDUTYRCGTNDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 병가일수 : dilnlazSckleaNumDys */
        listColumnDefs.add(new ColumnDef("병가일수", Dlgn0250BM.ATTR_DILNLAZSCKLEANUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 공가일수 : dilnlazOffvaNumDys */
        listColumnDefs.add(new ColumnDef("공가일수", Dlgn0250BM.ATTR_DILNLAZOFFVANUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 경조사일수 : dilnlazFmlyEvntNumDys */
        listColumnDefs.add(new ColumnDef("경조사일수", Dlgn0250BM.ATTR_DILNLAZFMLYEVNTNUMDYS, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 보건일수 : dilnlazHlthCreNumDys */
        listColumnDefs.add(new ColumnDef("보건일수", Dlgn0250BM.ATTR_DILNLAZHLTHCRENUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
       
       
        
        /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
        listColumnDefs.add(new ColumnDef("휴일근무(일)", Dlgn0250BM.ATTR_DILNLAZPUBCHODYDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        
        /** column 총휴일근무시간 : dilnlazPubcHodyDutyTm */
        listColumnDefs.add(new ColumnDef("휴일근무(시간)", Dlgn0250BM.ATTR_DILNLAZPUBCHODYDUTYTM, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	setReadOnly(true);
            	addTrigger(Events.KeyUp, changeValueListenerAdapter5);
            }
        });
        
        /** column 총휴일연장시간 : dilnlazHodyTotNtotTm */
        listColumnDefs.add(new ColumnDef("휴일연장(시간)", Dlgn0250BM.ATTR_DILNLAZHODYTOTNTOTTM, ColumnDef.TYPE_STRING , 70, false, true, false){
            {
            	
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	setReadOnly(true);
            }
        });
        
        /** column 총토요근무일수 : dilnlazSatDutyNumDys */
        listColumnDefs.add(new ColumnDef("토요근무", Dlgn0250BM.ATTR_DILNLAZSATDUTYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        }); 
        
        /** column 주휴일수 : dilnlazWklyHldyNumDys */
        listColumnDefs.add(new ColumnDef("주휴일수", Dlgn0250BM.ATTR_DILNLAZWKLYHLDYNUMDYS, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
        /** column 유급휴일수 : dilnlazPaidPubcHodyNum */
        listColumnDefs.add(new ColumnDef("연(월)차휴일수", Dlgn0250BM.ATTR_DILNLAZPAIDPUBCHODYNUM, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        }); 
        
        /** column 연가일수 : dilnlazLvsgNumDys */
        listColumnDefs.add(new ColumnDef("연가(잔여)일수", Dlgn0250BM.ATTR_DILNLAZLVSGNUMDYS, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
//        /** column 교통보조비일수 : dilnlazTfcAssCstNumDys */
//        listColumnDefs.add(new ColumnDef("교통보조비", Dlgn0250BM.ATTR_DILNLAZTFCASSCSTNUMDYS, ColumnDef.TYPE_STRING , 90, false, true, false){
//            {
//            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
//            	setSelectOnFocus(true);
//            }
//        });
         
    
       
        
        /** column 기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("기본시간외근무", Dlgn0250BM.ATTR_DILNLAZFNDTNTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	setReadOnly(true);
            }
        });
        /** column 시간외근무시간 : dilnlazTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("시간외근무", Dlgn0250BM.ATTR_DILNLAZTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	setReadOnly(true);
            }
        });
        /** column 총시간외근무시간 : dilnlazTotTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("총시간외근무시간", Dlgn0250BM.ATTR_DILNLAZTOTTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            	setReadOnly(true);
            }
        });
        /** column 총야근시간 : dilnlazTotNtotTm */
        listColumnDefs.add(new ColumnDef("야간근무", Dlgn0250BM.ATTR_DILNLAZTOTNTOTTM, ColumnDef.TYPE_STRING , 60, false, true, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
//            	setReadOnly(true);
            }
        });
        
        /** column 근무시작일자 : dilnlazDutyBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Dlgn0250BM.ATTR_DILNLAZDUTYBGNNDT, ColumnDef.TYPE_DATE , 70, false, true, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
        /** column 근무종료일자 : dilnlazDutyEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Dlgn0250BM.ATTR_DILNLAZDUTYENDDT, ColumnDef.TYPE_DATE , 70, false, true, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
       
        /** column 초과근무시작일자 : dilnlazExceDutyBgnnDt */
        listColumnDefs.add(new ColumnDef("초과근무시작일자", Dlgn0250BM.ATTR_DILNLAZEXCEDUTYBGNNDT, ColumnDef.TYPE_DATE , 90, false, false, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
        /** column 초과근무종료일자 : dilnlazExceDutyEndDt */
        listColumnDefs.add(new ColumnDef("초과근무종료일자", Dlgn0250BM.ATTR_DILNLAZEXCEDUTYENDDT, ColumnDef.TYPE_DATE , 90, false, false, false){
            {
            	 setMaxLength(10);
         		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
         		setDtFieldMask("9999.99.99");
            }
        });
         
        /** column 총야근일수 : dilnlazTotNtotNumDys */
        listColumnDefs.add(new ColumnDef("총야근일수", Dlgn0250BM.ATTR_DILNLAZTOTNTOTNUMDYS, ColumnDef.TYPE_STRING , 90, false, false, false){
            {
            	setRegEx("^[+-]?\\d*(\\.?\\d*)$");
            	setSelectOnFocus(true);
            }
        });
     
       
        
        /** column 마감처리여부 : dilnlazDdlnePrcsYn */
        listColumnDefs.add(new ColumnDef("마감", Dlgn0250BM.ATTR_DILNLAZDDLNEPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
            {
                setReadOnly(true);
            }
        });
        
        /** column 비고내용 : dilnlazNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고", Dlgn0250BM.ATTR_DILNLAZNOTECTNT, ColumnDef.TYPE_STRING , 90, false, true, false){
            {

            }
        });
       
      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Dlgn0250BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Dlgn0250BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Dlgn0250BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Dlgn0250BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Dlgn0250BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Dlgn0250BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
        

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dilnlazYrMnth;   /** column 근태년월 : dilnlazYrMnth */
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
//        private TextField<String> dilnlazDutyBgnnDt;   /** column 근무시작일자 : dilnlazDutyBgnnDt */
//
//        private TextField<String> dilnlazDutyEndDt;   /** column 근무종료일자 : dilnlazDutyEndDt */
//
//        private TextField<String> dilnlazDutyNumDys;   /** column 근무일수 : dilnlazDutyNumDys */
//
//        private TextField<String> dilnlazLvsgNumDys;   /** column 연가일수 : dilnlazLvsgNumDys */
//
//        private TextField<String> dilnlazAbnceNumDys;   /** column 결근일수 : dilnlazAbnceNumDys */
//
//        private TextField<String> dilnlazSckleaNumDys;   /** column 병가일수 : dilnlazSckleaNumDys */
//
//        private TextField<String> dilnlazOffvaNumDys;   /** column 공가일수 : dilnlazOffvaNumDys */
//
//        private TextField<String> dilnlazFmlyEvntNumDys;   /** column 경조사일수 : dilnlazFmlyEvntNumDys */
//
//        private TextField<String> dilnlazHlthCreNumDys;   /** column 보건일수 : dilnlazHlthCreNumDys */
//
//        private TextField<String> dilnlazTotDutyNumDys;   /** column 총근무일수 : dilnlazTotDutyNumDys */
//
//        private TextField<String> dilnlazWklyHldyNumDys;   /** column 주휴일수 : dilnlazWklyHldyNumDys */
//
//        private TextField<String> dilnlazPaidPubcHodyNum;   /** column 유급휴일수 : dilnlazPaidPubcHodyNum */
//
//        private TextField<String> dilnlazDdlnePrcsYn;   /** column 마감처리여부 : dilnlazDdlnePrcsYn */
//
//        private TextField<String> dilnlazNoteCtnt;   /** column 비고내용 : dilnlazNoteCtnt */
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
//        private TextField<String> dilnlazSpclHodyNumDys;   /** column 특별휴가일수 : dilnlazSpclHodyNumDys */
//
//        private TextField<String> dilnlazSatDutyNumDys;   /** column 총토요근무일수 : dilnlazSatDutyNumDys */
//
//        private TextField<String> dilnlazPubcHodyDutyNumDys;   /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//
//        private TextField<String> dilnlazAbnceDutyRcgtnDys;   /** column 결근인정일수 : dilnlazAbnceDutyRcgtnDys */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dilnlazTotDutyTm;   /** column 총근무시간 : dilnlazTotDutyTm */
//
//        private TextField<String> dilnlazPaidHodyNumDys;   /** column 유급휴가일수 : dilnlazPaidHodyNumDys */
//
//        private TextField<String> dilnlazTfcAssCstNumDys;   /** column 교통보조비일수 : dilnlazTfcAssCstNumDys */    
// 
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
//        private TextField<String> dilnlazExceDutyBgnnDt;   /** column 초과근무시작일자 : dilnlazExceDutyBgnnDt */
//
//        private TextField<String> dilnlazExceDutyEndDt;   /** column 초과근무종료일자 : dilnlazExceDutyEndDt */
//
//        private TextField<String> dilnlazPubcHodyDutyNumDys;   /** column 휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//
//        private TextField<String> dilnlazSatDutyNumDys;   /** column 토요근무일수 : dilnlazSatDutyNumDys */
//
//        private TextField<String> dilnlazTotNtotNumDys;   /** column 총야근일수 : dilnlazTotNtotNumDys */
//
//        private TextField<String> dilnlazTotNtotTm;   /** column 총야근시간 : dilnlazTotNtotTm */
//
//        private TextField<String> dilnlazFndtnTmRstDutyTm;   /** column 기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
//
//        private TextField<String> dilnlazTmRstDutyTm;   /** column 시간외근무시간 : dilnlazTmRstDutyTm */
//
//        private TextField<String> dilnlazTotTmRstDutyTm;   /** column 총시간외근무시간 : dilnlazTotTmRstDutyTm */
//
//        private TextField<String> dilnlazDdlnePrcsYn;   /** column 마감처리여부 : dilnlazDdlnePrcsYn */
//
//        private TextField<String> dilnlazNoteCtnt;   /** column 비고내용 : dilnlazNoteCtnt */
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
          
      

        
        setColumnsDefinition(listColumnDefs);
		return listColumnDefs;
    }
}
