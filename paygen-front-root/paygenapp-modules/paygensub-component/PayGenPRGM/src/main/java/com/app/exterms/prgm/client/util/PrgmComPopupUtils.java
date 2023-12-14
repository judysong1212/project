package com.app.exterms.prgm.client.util;

import com.app.exterms.prgm.client.dto.PrgmComBass0120DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.form.PrgmComP0100;
import com.app.exterms.prgm.client.form.PrgmComP0110;
import com.app.exterms.prgm.client.form.PrgmComP0130;
import com.app.exterms.prgm.client.form.PrgmComP0140;
import com.app.exterms.prgm.client.form.PrgmComP0145;
import com.app.exterms.prgm.client.form.PrgmComP0150;
import com.app.exterms.prgm.client.form.PrgmComP0160;
import com.app.exterms.prgm.client.form.PrgmComP0500;
import com.app.exterms.prgm.client.form.PrgmComP0510;
import com.app.exterms.prgm.client.form.PrgmComPBass120001;
import com.app.exterms.prgm.client.form.PrgmInsrComP2000;
import com.app.exterms.prgm.client.form.PrgmPayrP405001;
import com.app.exterms.prgm.client.form.PrgmPsnlComP0126;
import com.app.exterms.prgm.client.form.PrgmRemtComP1000;
import com.app.exterms.prgm.client.form.PrgmYetaP0100;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0120Def;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0300Def;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0350Def;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0400Def;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0500Def;
import com.app.exterms.prgm.client.form.defs.PrgmComP0500Def;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0100Def;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0115Def;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.event.dom.client.KeyCodes;

public class PrgmComPopupUtils {
 
    
//    private static Button btnMtOk;
//    private static Button btnMtCancel;
//    private static ListStore<BaseModel> storeList;
    
   /**
    * 공통팝업처리 함수
    * @param strRpsttvCd
    * @return MSFFormPanel
    * 사용예 
    * MSFFormPanel comform = lovPopUpPrgmCom0130Form("A031");
    * final FormBinding popBinding = comform.getFormBinding();
    */
	public static final MSFFormPanel lovPopUpPrgmCom0130Form(final String strRpsttvCd){
		
		// TODO Auto-generated method stub
		Lov lov = null;    
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 1, 0);
		MSFCustomForm sysComP0130Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysComP0130Form; 
		
	    final PrgmComP0130 sysComP0130 =  new PrgmComP0130(350,450); 
        customForm.setLov(sysComP0130);
       
		lov = customForm.getLov();    
		
	    if (MSFSharedUtils.paramNotNull(strRpsttvCd)) {
	        customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	        customForm.getLov().getLovDef().addColumnFilter("commCdNm", "", SimpleColumnFilter.OPERATOR_EQUALS); 
	    } else {
	        return null;
	    }
        if (lov != null) { 
            final LovLiveGeneric  lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysComP0130Form.getTableDef());
            lovWindow.setInitialForm(sysComP0130Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);  
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            sysComP0130.getCommCdNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    sysComP0130.getCommCdNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("commCdNm", MSFSharedUtils.defaultNulls(sysComP0130.getCommCdNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComP0130.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  sysComP0130.getCommCdNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("commCdNm", MSFSharedUtils.defaultNulls(sysComP0130.getCommCdNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            sysComP0130.getCommCdNm().focus();  
    	} 
	        
	        return comform;
		 
	}
	
	//부서팝업  
    public static final MSFFormPanel lovPopUpPrgmCom0140Form(){
      
                  // TODO Auto-generated method stub 
                      return lovPopUpPrgmCom0140Form(null);
                
    }
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 권한 처리에 따른 부서 정보만가져오는 경우  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : lovPopUpPrgmCom0140Form
	 * @date : Jun 16, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jun 16, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param DeptNm
	 * @return
	 */
	public static final MSFFormPanel lovPopUpPrgmCom0140Form(String DeptNm){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0400Def(), 1, 0);
		MSFCustomForm sysCom0140Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysCom0140Form;
		  
		  final PrgmComP0140 sysComP0140 =  new PrgmComP0140(600,600); 
	      customForm.setLov(sysComP0140);
	      lov = customForm.getLov();    
	      

	        if (MSFSharedUtils.paramNull(DeptNm)) { 
	            customForm.getLov().getLovDef().addColumnFilter("deptNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);    
	            customForm.getLov().getLovDef().addColumnFilter("deptDspyYn", "", SimpleColumnFilter.OPERATOR_EQUALS);   
	           
	        } else {
	            PrgmComP0140.getDeptNm().setValue(DeptNm);
	            customForm.getLov().getLovDef().addColumnFilter("deptNm", DeptNm, SimpleColumnFilter.OPERATOR_EQUALS);    
	            customForm.getLov().getLovDef().addColumnFilter("deptDspyYn", "", SimpleColumnFilter.OPERATOR_EQUALS);  
	            
	        }
	      
	        if (lov != null) {
	            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0140Form.getTableDef());
	            lovWindow.setInitialForm(sysCom0140Form);   //formPanel을적어준다.
	            lovWindow.showButtonNew(false); 
	            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
	            lovWindow.show(); 
	            lov.fixAttributeFormNames(); 
	   
	            PrgmComP0140.getDeptNm().addKeyListener(new KeyListener() {
	                public void componentKeyUp(ComponentEvent event) {
	                    super.componentKeyUp(event);
	                    PrgmComP0140.getDeptNm().validate();
	                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
	                        IColumnFilter filters = null;
	                        lovWindow.getLovDef().setTableColumnFilters(filters);
	                        lovWindow.getLovDef().addColumnFilter("deptNm", MSFSharedUtils.defaultNulls(PrgmComP0140.getDeptNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.readData();
	                    }
	                }
	             });
	            
	            PrgmComP0140.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
	              public void handleEvent(ButtonEvent e) {
	            	  PrgmComP0140.getDeptNm().validate();
	                  IColumnFilter filters = null;
	                  lovWindow.getLovDef().setTableColumnFilters(filters);
	                  lovWindow.getLovDef().addColumnFilter("deptNm", MSFSharedUtils.defaultNulls(PrgmComP0140.getDeptNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.readData();
	                  
	              }
	             });
	            PrgmComP0140.getDeptNm().focus();  
	        } 
	        return comform;
		 
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 그리드 부서 팝업 호출시 전체 호출하는 메서드  권한 미적용사용  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : lovPopUpNonPrgmCom0145Form
	 * @date : 2016. 10. 17.
	 * @author : cyberlhs
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 10. 17.		cyberlhs				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param DeptNm
	 * @return
	 */
    public static final MSFFormPanel lovPopUpNonPrgmCom0145Form(String DeptNm){
      
                  // TODO Auto-generated method stub 
    	            if (MSFSharedUtils.paramNull(DeptNm) ) {
    	            	DeptNm = "";
    	            }  
    	            
                   return lovPopUpPrgmCom0145Form(DeptNm,"");
                
    }
	//부서팝업  
    public static final MSFFormPanel lovPopUpPrgmCom0145Form(String deptDspyYn){
      
                  // TODO Auto-generated method stub 
    	            if (MSFSharedUtils.paramNull(deptDspyYn) ) {
    	            	deptDspyYn = "";
    	            }  
    	            
                   return lovPopUpPrgmCom0145Form(null,deptDspyYn);
                
    }
    
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 관리부서등 권한 없이 전체 데이타 가져오는 경우  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : lovPopUpPrgmCom0140Form
	 * @date : Jun 16, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jun 16, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param DeptNm
	 * @return
	 */
		public static final MSFFormPanel lovPopUpPrgmCom0145Form(String DeptNm,String deptDspyYn){
			
			// TODO Auto-generated method stub
			Lov lov = null;     
			//LovLiveGeneric lovWindow = null; 
			MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0400Def(), 1, 0);
			MSFCustomForm sysCom0145Form = customForm.getCustomForm();    
			MSFFormPanel comform = (MSFFormPanel)sysCom0145Form;
			  
			  final PrgmComP0145 sysComP0145 =  new PrgmComP0145(600,600); 
		      customForm.setLov(sysComP0145);
		      lov = customForm.getLov();    
		      

		        if (MSFSharedUtils.paramNull(DeptNm) && MSFSharedUtils.paramNull(deptDspyYn)) { 
		            customForm.getLov().getLovDef().addColumnFilter("deptNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);    
		            customForm.getLov().getLovDef().addColumnFilter("deptDspyYn", "", SimpleColumnFilter.OPERATOR_EQUALS);   
		           
		        } else {
		            PrgmComP0145.getDeptNm().setValue(DeptNm);
		            customForm.getLov().getLovDef().addColumnFilter("deptNm", DeptNm, SimpleColumnFilter.OPERATOR_EQUALS);    
		            customForm.getLov().getLovDef().addColumnFilter("deptDspyYn", deptDspyYn, SimpleColumnFilter.OPERATOR_EQUALS);  
		            
		        }
		      
		        if (lov != null) {
		            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0145Form.getTableDef());
		            lovWindow.setInitialForm(sysCom0145Form);   //formPanel을적어준다.
		            lovWindow.showButtonNew(false); 
		            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
		            lovWindow.show(); 
		            lov.fixAttributeFormNames(); 
		   
		            PrgmComP0145.getDeptNm().addKeyListener(new KeyListener() {
		                public void componentKeyUp(ComponentEvent event) {
		                    super.componentKeyUp(event);
		                    PrgmComP0145.getDeptNm().validate();
		                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
		                        IColumnFilter filters = null;
		                        lovWindow.getLovDef().setTableColumnFilters(filters);
		                        lovWindow.getLovDef().addColumnFilter("deptNm", MSFSharedUtils.defaultNulls(PrgmComP0145.getDeptNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		                        lovWindow.getLovDef().addColumnFilter("deptDspyYn", MSFSharedUtils.defaultNulls(PrgmComP0145.getDeptDspyYn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		                        lovWindow.readData();
		                    }
		                }
		             });
		            
		            PrgmComP0145.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
		              public void handleEvent(ButtonEvent e) {
		            	  PrgmComP0145.getDeptNm().validate();
		                  IColumnFilter filters = null;
		                  lovWindow.getLovDef().setTableColumnFilters(filters);
		                  lovWindow.getLovDef().addColumnFilter("deptNm", MSFSharedUtils.defaultNulls(PrgmComP0145.getDeptNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		                  lovWindow.getLovDef().addColumnFilter("deptDspyYn", MSFSharedUtils.defaultNulls(PrgmComP0145.getDeptDspyYn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		                  lovWindow.readData();
		                  
		              }
		             });
		            PrgmComP0145.getDeptNm().focus();  
		        } 
		        return comform;
			 
		}
	
	//사업팝업 - 년도기본
	public static final MSFFormPanel lovPopUpPrgmCom0150Form(PrgmComBass0500DTO sysComBass0500Dto){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0500Def(""), 1, 0);
		MSFCustomForm sysCom0150Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysCom0150Form;
		final PrgmComP0150 sysComP0150 =  new PrgmComP0150(800,600); 
        customForm.setLov(sysComP0150);
        lov = customForm.getLov();   
         
        customForm.getLov().getLovDef().addColumnFilter("businApptnYr", sysComBass0500Dto.getBusinApptnYr(), SimpleColumnFilter.OPERATOR_EQUALS); 
        customForm.getLov().getLovDef().addColumnFilter("deptCd", sysComBass0500Dto.getDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
         
     
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0150Form.getTableDef());
            lovWindow.setInitialForm(sysCom0150Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            PrgmComP0150.getBusinNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmComP0150.getBusinNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters); 
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0150.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businApptnYr", MSFSharedUtils.getSelectedComboValue(PrgmComP0150.getBusinApptnYr(),"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businNm", MSFSharedUtils.defaultNulls(PrgmComP0150.getBusinNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComP0150.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmComP0150.getBusinNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0150.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businApptnYr", MSFSharedUtils.getSelectedComboValue(PrgmComP0150.getBusinApptnYr(),"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businNm", MSFSharedUtils.defaultNulls(PrgmComP0150.getBusinNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData(); 
              }
             });
            
        } 
	        
	     return comform;
		 
	}


    //가족사항 
    public static final MSFFormPanel lovPopUpPrgmCom0160Form(PrgmComPsnl0115DTO sysComPsnl0115Dto){
        
        // TODO Auto-generated method stub
        Lov lov = null;     
        //LovLiveGeneric lovWindow = null; 
        MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0115Def(), 1, 0);
        MSFCustomForm sysCom0160Form = customForm.getCustomForm();    
        MSFFormPanel comform = (MSFFormPanel)sysCom0160Form;
        final PrgmComP0160 sysComP0160 =  new PrgmComP0160(700,400); 
        customForm.setLov(sysComP0160);
        lov = customForm.getLov();    
       
        customForm.getLov().getLovDef().addColumnFilter("dpobCd", sysComPsnl0115Dto.getDpobCd(), SimpleColumnFilter.OPERATOR_EQUALS);
        customForm.getLov().getLovDef().addColumnFilter("systemkey", sysComPsnl0115Dto.getSystemkey(), SimpleColumnFilter.OPERATOR_EQUALS);
        
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0160Form.getTableDef());
            lovWindow.setInitialForm(sysCom0160Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
//            sysComP0150.businNm.addKeyListener(new KeyListener() {
//                public void componentKeyUp(ComponentEvent event) {
//                    super.componentKeyUp(event);
//                    sysComP0150.businNm.validate();
//                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
//                        IColumnFilter filters = null;
//                        lovWindow.getLovDef().setTableColumnFilters(filters); 
//                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(sysComP0150.deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.getLovDef().addColumnFilter("businApptnYr", MSFSharedUtils.getSelectedComboValue(sysComP0150.businApptnYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.getLovDef().addColumnFilter("businNm", MSFSharedUtils.defaultNulls(sysComP0150.businNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.readData();
//                    }
//                }
//             });
//            
//            sysComP0150.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
//              public void handleEvent(ButtonEvent e) {
//                  sysComP0150.businNm.validate();
//                  IColumnFilter filters = null;
//                  lovWindow.getLovDef().setTableColumnFilters(filters);
//                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(sysComP0150.deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.getLovDef().addColumnFilter("businApptnYr", MSFSharedUtils.getSelectedComboValue(sysComP0150.businApptnYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.getLovDef().addColumnFilter("businNm", MSFSharedUtils.defaultNulls(sysComP0150.businNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.readData(); 
//              }
//             });
        } 
        
        return comform;
         
    }
    
    
    //수당공제팝업 
    public static final MSFFormPanel lovPopUpPrgmCom0500Form(PrgmComP0500DTO sysComP0500Dto){
        
        // TODO Auto-generated method stub
        Lov lov = null;     
        //LovLiveGeneric lovWindow = null; 
        MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComP0500Def(), 1, 0);
        MSFCustomForm sysCom0500Form = customForm.getCustomForm();    
        MSFFormPanel comform = (MSFFormPanel)sysCom0500Form;
        final PrgmComP0500 sysComP0500 =  new PrgmComP0500(600,400); 
        customForm.setLov(sysComP0500);
        lov = customForm.getLov();    
       
        customForm.getLov().getLovDef().addColumnFilter("pymtDducDivCd", sysComP0500Dto.getPymtDducDivCd(), SimpleColumnFilter.OPERATOR_EQUALS);
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0500Form.getTableDef());
            lovWindow.setInitialForm(sysCom0500Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            PrgmComP0500.getPayExtpyNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmComP0500.getPayExtpyNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters); 
                        lovWindow.getLovDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0500.getPymtDducDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("payExtpyNm", MSFSharedUtils.defaultNulls(PrgmComP0500.getPayExtpyNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComP0500.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmComP0500.getPayExtpyNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0500.getPymtDducDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("payExtpyNm", MSFSharedUtils.defaultNulls(PrgmComP0500.getPayExtpyNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.readData();
              }
             });
        } 
        
        return comform;
         
    }
    
    
   /**
    * 직종/직종세 다건검색기능.
    * @return
    */
    public static final MSFFormPanel lovPopUpPrgmCom0510Form(){
        
        // TODO Auto-generated method stub
        Lov lov = null;     
        //LovLiveGeneric lovWindow = null; 
        MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0350Def(), 1, 0);
        MSFCustomForm sysCom0510Form = customForm.getCustomForm();    
        MSFFormPanel comform = (MSFFormPanel)sysCom0510Form;
        final PrgmComP0510 sysComP0510 =  new PrgmComP0510(600,400); 
        customForm.setLov(sysComP0510);
        lov = customForm.getLov();    
       
        customForm.getLov().getLovDef().addColumnFilter("typOccuCd","", SimpleColumnFilter.OPERATOR_EQUALS);
          
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0510Form.getTableDef());
            lovWindow.setInitialForm(sysCom0510Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            PrgmComP0510.getDtilOccuClsNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmComP0510.getDtilOccuClsNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters); 
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0510.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
                        lovWindow.getLovDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0510.getPyspGrdeCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
                        lovWindow.getLovDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(PrgmComP0510.getDtilOccuClsNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComP0510.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  PrgmComP0510.getDtilOccuClsNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters); 
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0510.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.getLovDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0510.getPyspGrdeCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.getLovDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(PrgmComP0510.getDtilOccuClsNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
              }
             });
        } 
        
        return comform;
         
    }
    
	//인사팝업-단건선택
  public static final MSFFormPanel lovPopUpPrgmCom0100Form(){
	        
	        // TODO Auto-generated method stub 
	            return lovPopUpPrgmCom0100Form(null);
	         
  }
	   
	public static final MSFFormPanel lovPopUpPrgmCom0100Form(String UsrName){
		
		
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
		MSFCustomForm sysCom0100Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysCom0100Form;
		final PrgmComP0100 sysComP0100 =  new PrgmComP0100(850,600); 
		customForm.setLov(sysComP0100);
		lov = customForm.getLov();   
		
		if (MSFSharedUtils.paramNull(UsrName)) {
		    customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
		} else {
			PrgmComP0100.getHanNm().setValue(UsrName);
		    customForm.getLov().getLovDef().addColumnFilter("hanNm", UsrName, SimpleColumnFilter.OPERATOR_EQUALS);  
		}
		
	 
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0100Form.getTableDef());
            lovWindow.setInitialForm(sysCom0100Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            PrgmComP0100.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmComP0100.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters); 
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmComP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmComP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmComP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmComP0100.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmComP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmComP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmComP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            
    	} 
	        
	        return comform;
		 
	}
	
	//인사팝업 멀티 선택 건
    public static final MSFFormPanel lovPopUpPrgmCom0110Form(){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
		MSFCustomForm msfPsnl0110Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)msfPsnl0110Form;
		   
		final PrgmComP0110 sysComP0110 =  new PrgmComP0110(850,600); 
        customForm.setLov(sysComP0110);
        lov = customForm.getLov();   
        customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
      
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),msfPsnl0110Form.getTableDef());
            lovWindow.setInitialForm(msfPsnl0110Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
          //  lovWindow.showBtnBar(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
    
             
            
            PrgmComP0110.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmComP0110.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);                         
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmComP0110.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmComP0110.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmComP0110.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComP0110.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmComP0110.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmComP0110.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmComP0110.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmComP0110.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmComP0110.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            

//            ToolBar toolBar = new ToolBar();  
// 
//            toolBar = (ToolBar)lovWindow.getBottomComponent(); 
//            
//            btnMtOk = new Button(MSFMainApp.MSFCONSTANTS.BtConferma(), buttonListener);
//            btnMtOk.setIcon(MSFMainApp.ICONS.confirm());
//            toolBar.add(btnMtOk);
//
//            btnMtCancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete(), buttonListener);
//            btnMtCancel.setIcon(MSFMainApp.ICONS.cancel());
//            toolBar.add(btnMtCancel);
//            lovWindow.setBottomComponent(toolBar);  
            
        } 
	        
	        return comform;
		 
	}
//    private static SelectionListener<ButtonEvent> buttonListener = new SelectionListener<ButtonEvent>() {  
//        @Override  
//        public void componentSelected(ButtonEvent ce) {  
//           if (ce.getButton() == btnMtOk) {
//               storeList = new ListStore<BaseModel>();  
//               storeList = (ListStore<BaseModel>)ce.getSource();
//               //Iterator<Record> iterRecords = storeList.get.getModifiedRecords().iterator();
////               while (iterRecords.hasNext()) {
////                   Record record = (Record) iterRecords.next();
////                 //  updateProfilesUtenti((BaseModel) record.getModel());
////               }
//              
//               
//            } else if (ce.getButton() == btnMtCancel) {
//                ce.getBoxComponent().hide();
//            }
//        }  
//    };
     
     
	
	//퇴직대상자 선택 인사팝업 멀티 선택 건
    public static final MSFFormPanel lovPopUpPrgmComRemt1000Form(){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
		MSFCustomForm msfPsnl0110Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)msfPsnl0110Form;
		   
		final PrgmRemtComP1000 sysRemtComP1000 =  new PrgmRemtComP1000(850,600); 
        customForm.setLov(sysRemtComP1000);
        lov = customForm.getLov();   
        customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
      
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),msfPsnl0110Form.getTableDef());
            lovWindow.setInitialForm(msfPsnl0110Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
          //  lovWindow.showBtnBar(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
    
            PrgmRemtComP1000.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmRemtComP1000.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("retryDt01", GWTUtils.getStringFromDate(PrgmRemtComP1000.getRetryDt01().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("retryDt02", GWTUtils.getStringFromDate(PrgmRemtComP1000.getRetryDt02().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);                    
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmRemtComP1000.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmRemtComP1000.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmRemtComP1000.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmRemtComP1000.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmRemtComP1000.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("retryDt01", GWTUtils.getStringFromDate(PrgmRemtComP1000.getRetryDt01().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("retryDt02", GWTUtils.getStringFromDate(PrgmRemtComP1000.getRetryDt02().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);                    
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmRemtComP1000.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmRemtComP1000.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmRemtComP1000.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmRemtComP1000.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            

//            ToolBar toolBar = new ToolBar();  
// 
//            toolBar = (ToolBar)lovWindow.getBottomComponent(); 
//            
//            btnMtOk = new Button(MSFMainApp.MSFCONSTANTS.BtConferma(), buttonListener);
//            btnMtOk.setIcon(MSFMainApp.ICONS.confirm());
//            toolBar.add(btnMtOk);
//
//            btnMtCancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete(), buttonListener);
//            btnMtCancel.setIcon(MSFMainApp.ICONS.cancel());
//            toolBar.add(btnMtCancel);
//            lovWindow.setBottomComponent(toolBar);  
            
        } 
	        
	        return comform;
		 
	}
    
    
	//4대보험 선택 인사팝업 멀티 선택 건
    public static final MSFFormPanel lovPopUpPrgmComInsr2000Form(){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
		MSFCustomForm msfPsnl0110Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)msfPsnl0110Form;
		   
		final PrgmInsrComP2000 sysInsrComP2000 =  new PrgmInsrComP2000(850,600); 
        customForm.setLov(sysInsrComP2000);
        lov = customForm.getLov();   
        customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
      
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),msfPsnl0110Form.getTableDef());
            lovWindow.setInitialForm(msfPsnl0110Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
    
            PrgmInsrComP2000.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmInsrComP2000.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtBgnnDt01", GWTUtils.getStringFromDate(PrgmInsrComP2000.getEmymtBgnnDt01().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtBgnnDt02", GWTUtils.getStringFromDate(PrgmInsrComP2000.getEmymtBgnnDt02().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);                    
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmInsrComP2000.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmInsrComP2000.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmInsrComP2000.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            
            PrgmInsrComP2000.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmInsrComP2000.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtBgnnDt01", GWTUtils.getStringFromDate(PrgmInsrComP2000.getEmymtBgnnDt01().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtBgnnDt02", GWTUtils.getStringFromDate(PrgmInsrComP2000.getEmymtBgnnDt02().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);                    
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmInsrComP2000.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmInsrComP2000.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmInsrComP2000.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmInsrComP2000.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
                       
        } 
	        
	        return comform;
		 
	}
    
	// 휴가일수 산정 팝업창 추가 
    public static final MSFFormPanel lovPopUpPrgmComPsnl0126Form(final String year){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def("PSNL0126"), 1, 0);
		MSFCustomForm msfPsnl0110Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)msfPsnl0110Form;
		   
		final PrgmPsnlComP0126 sysInsrComP2000 =  new PrgmPsnlComP0126(850,600); 
        customForm.setLov(sysInsrComP2000);
        lov = customForm.getLov();   
        customForm.getLov().getLovDef().addColumnFilter("hodyApptnYr", year, SimpleColumnFilter.OPERATOR_EQUALS);  
      
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),msfPsnl0110Form.getTableDef());
            lovWindow.setInitialForm(msfPsnl0110Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
          //  lovWindow.showBtnBar(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
    
            PrgmPsnlComP0126.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmPsnlComP0126.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.getLovDef().addColumnFilter("emymtBgnnDt01", GWTUtils.getStringFromDate(PrgmPsnlComP0126.getEmymtBgnnDt01().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.getLovDef().addColumnFilter("emymtBgnnDt02", GWTUtils.getStringFromDate(PrgmPsnlComP0126.getEmymtBgnnDt02().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);                    
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmPsnlComP0126.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmPsnlComP0126.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmPsnlComP0126.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
                        lovWindow.getLovDef().addColumnFilter("hodyApptnYr", MSFSharedUtils.defaultNulls(year,"9999"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            
            PrgmPsnlComP0126.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmPsnlComP0126.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.getLovDef().addColumnFilter("emymtBgnnDt01", GWTUtils.getStringFromDate(PrgmPsnlComP0126.getEmymtBgnnDt01().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.getLovDef().addColumnFilter("emymtBgnnDt02", GWTUtils.getStringFromDate(PrgmPsnlComP0126.getEmymtBgnnDt02().getValue(),"yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);                    
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmPsnlComP0126.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmPsnlComP0126.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmPsnlComP0126.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmPsnlComP0126.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.getLovDef().addColumnFilter("hodyApptnYr", MSFSharedUtils.defaultNulls(year,"9999"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            
        } 
	        
	        return comform;
		 
	}
    
    //연말정산 대상자 멀티 선택 건
    public static final MSFFormPanel lovPopUpPrgmYetaP0100Form(){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
		MSFCustomForm msfYeta0100Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)msfYeta0100Form;
		   
		final PrgmYetaP0100 sysYetaP0100=  new PrgmYetaP0100(850,600); 
        customForm.setLov(sysYetaP0100);
        lov = customForm.getLov();   
        customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
      
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),msfYeta0100Form.getTableDef());
            lovWindow.setInitialForm(msfYeta0100Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
          //  lovWindow.showBtnBar(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
            
            PrgmYetaP0100.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmYetaP0100.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);                         
                        lovWindow.getLovDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getYrtxBlggYr(),"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmYetaP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmYetaP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmYetaP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmYetaP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmYetaP0100.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getYrtxBlggYr(),"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmYetaP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmYetaP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmYetaP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmYetaP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            

//            ToolBar toolBar = new ToolBar();  
// 
//            toolBar = (ToolBar)lovWindow.getBottomComponent(); 
//            
//            btnMtOk = new Button(MSFMainApp.MSFCONSTANTS.BtConferma(), buttonListener);
//            btnMtOk.setIcon(MSFMainApp.ICONS.confirm());
//            toolBar.add(btnMtOk);
//
//            btnMtCancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete(), buttonListener);
//            btnMtCancel.setIcon(MSFMainApp.ICONS.cancel());
//            toolBar.add(btnMtCancel);
//            lovWindow.setBottomComponent(toolBar);  
            
        } 
	        
	        return comform;
		 
	}    
    
    //급여 대상자 멀티 선택 건
    public static final MSFFormPanel lovPopUpPrgmPayrP405001Form(){
    	
    	// TODO Auto-generated method stub
    	Lov lov = null;     
    	//LovLiveGeneric lovWindow = null; 
    	MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComPsnl0100Def(), 1, 0);
    	MSFCustomForm msfPayrP405001Form = customForm.getCustomForm();    
    	MSFFormPanel comform = (MSFFormPanel)msfPayrP405001Form;
    	
    	final PrgmPayrP405001 sysPayrP405001=  new PrgmPayrP405001(850,600); 
    	customForm.setLov(sysPayrP405001);
    	lov = customForm.getLov();   
    	customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
    	
    	
    	if (lov != null) {
    		final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),msfPayrP405001Form.getTableDef());
    		lovWindow.setInitialForm(msfPayrP405001Form);   //formPanel을적어준다.
    		lovWindow.showButtonNew(false);
    		//  lovWindow.showBtnBar(false);
    		lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
    		lovWindow.show();
    		lov.fixAttributeFormNames(); 
    		
    		PrgmPayrP405001.getHanNm().addKeyListener(new KeyListener() {
    			public void componentKeyUp(ComponentEvent event) {
    				super.componentKeyUp(event);
    				PrgmPayrP405001.getHanNm().validate();
    				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
    					IColumnFilter filters = null;
    					lovWindow.getLovDef().setTableColumnFilters(filters);                         
    					lovWindow.getLovDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getPayYr(),"year")+MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getPayMonth(),"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getPayCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmPayrP405001.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmPayrP405001.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmPayrP405001.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    					lovWindow.readData();
    				}
    			}
    		});
    		
    		PrgmPayrP405001.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
    			public void handleEvent(ButtonEvent e) {
    				PrgmPayrP405001.getHanNm().validate();
    				IColumnFilter filters = null;
    				lovWindow.getLovDef().setTableColumnFilters(filters);
    				lovWindow.getLovDef().addColumnFilter("pymtYrMnth",  (MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getPayYr(),"year")+MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getPayMonth(),"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getPayCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getTypOccuCd(),"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(PrgmPayrP405001.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(PrgmPayrP405001.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(PrgmPayrP405001.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(PrgmPayrP405001.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    				lovWindow.readData();
    				
    			}
    		});
    		
    		
//            ToolBar toolBar = new ToolBar();  
// 
//            toolBar = (ToolBar)lovWindow.getBottomComponent(); 
//            
//            btnMtOk = new Button(MSFMainApp.MSFCONSTANTS.BtConferma(), buttonListener);
//            btnMtOk.setIcon(MSFMainApp.ICONS.confirm());
//            toolBar.add(btnMtOk);
//
//            btnMtCancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete(), buttonListener);
//            btnMtCancel.setIcon(MSFMainApp.ICONS.cancel());
//            toolBar.add(btnMtCancel);
//            lovWindow.setBottomComponent(toolBar);  
    		
    	} 
    	
    	return comform;
    	
    }    
    
    
    
    /**
     * 
     * <pre>
     * 1. 개요 : 단위 사업장 검색 팝업  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : lovPopUpPrgmCom0500Form
     * @date : 2018. 1. 5.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 5.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param sysComP0500Dto
     * @return
     */
    public static final MSFFormPanel lovPopUpPrgmComPBass120001Form(PrgmComBass0120DTO prgmComBass0120Dto){
        
        // TODO Auto-generated method stub
        Lov lov = null;     
        //LovLiveGeneric lovWindow = null; 
        MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0120Def(), 1, 0);
        MSFCustomForm prgmComPBass120001 = customForm.getCustomForm();    
        MSFFormPanel comform = (MSFFormPanel)prgmComPBass120001;
        final PrgmComPBass120001 sysComPBass120001 =  new PrgmComPBass120001(800,400); 
        customForm.setLov(sysComPBass120001);
        lov = customForm.getLov();    
       
        customForm.getLov().getLovDef().addColumnFilter("utDpobNm", prgmComBass0120Dto.getUtDpobNm(), SimpleColumnFilter.OPERATOR_EQUALS);
         
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),prgmComPBass120001.getTableDef());
            lovWindow.setInitialForm(prgmComPBass120001);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            PrgmComPBass120001.getUtDpobNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    PrgmComP0500.getPayExtpyNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters); 
                        lovWindow.getLovDef().addColumnFilter("utDpobNm", MSFSharedUtils.defaultNulls(PrgmComPBass120001.getUtDpobNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            PrgmComPBass120001.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  PrgmComPBass120001.getUtDpobNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("utDpobNm", MSFSharedUtils.defaultNulls(PrgmComPBass120001.getUtDpobNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.readData();
              }
             });
        } 
        
        return comform;
         
    }
      
	 
}
