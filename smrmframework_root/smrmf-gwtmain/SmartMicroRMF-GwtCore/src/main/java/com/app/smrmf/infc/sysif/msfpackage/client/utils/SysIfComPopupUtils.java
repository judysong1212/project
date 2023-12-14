package com.app.smrmf.infc.sysif.msfpackage.client.utils;

import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.SysIfP0100;
import com.app.smrmf.infc.sysif.msfpackage.client.form.SysIfP0980;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfPsnl0100Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfSysm0100Def;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.event.dom.client.KeyCodes;

public class SysIfComPopupUtils {
 
    
    
	//인사팝업-단건선택
	public static final MSFFormPanel lovPopUpMsfCom0100Form(){
	        
	        // TODO Auto-generated method stub 
	            return lovPopUpMsfCom0100Form(null);
	         
	}
	   
	public static final MSFFormPanel lovPopUpMsfCom0100Form(String UsrName){
		
		
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysIfPsnl0100Def(), 1, 0);
		MSFCustomForm sysCom0100Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysCom0100Form;
		final SysIfP0100 sysComP0100 =  new SysIfP0100(850,600); 
		customForm.setLov(sysComP0100);
		lov = customForm.getLov();   
		
		if (MSFSharedUtils.paramNull(UsrName)) {
		    customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
		} else {
			SysIfP0100.getHanNm().setValue(UsrName);
		    customForm.getLov().getLovDef().addColumnFilter("hanNm", UsrName, SimpleColumnFilter.OPERATOR_EQUALS);  
		}
		
	 
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0100Form.getTableDef());
            lovWindow.setInitialForm(sysCom0100Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false); 
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
   
            SysIfP0100.getHanNm().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysIfP0100.getHanNm().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters); 
                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(SysIfP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(SysIfP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(SysIfP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             });
            
            SysIfP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
            	  SysIfP0100.getHanNm().validate();
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(SysIfP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(SysIfP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(SysIfP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            
    	} 
	        return comform;
		 
	}
	
	
    /**
     * 시스템 사용자 정보 팝업 
     * @param usrNm
     * @return
     */
   	public static final MSFFormPanel lovPopUpMsfSysComP0980Form(String usrNm){ 
   		
   		Lov lov = null;     
   		//LovLiveGeneric lovWindow = null; 
   		final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysIfSysm0100Def("SYSM0100"), 1, 0);
   		MSFCustomForm sysComP0980Form = customForm.getCustomForm();    
   		MSFFormPanel comform = (MSFFormPanel)sysComP0980Form;
   		final SysIfP0980 sysComP0980 =  new SysIfP0980(850,600); 
   		customForm.setLov(sysComP0980);
   		lov = customForm.getLov();   
   		
   		  if (MSFSharedUtils.paramNull(usrNm)) {
   		    customForm.getLov().getLovDef().addColumnFilter("usrNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
   		  } else {
   			SysIfP0980.getUsrNm().setValue(usrNm);
   		    customForm.getLov().getLovDef().addColumnFilter("usrNm", usrNm, SimpleColumnFilter.OPERATOR_EQUALS);  
   		  }
   		
   	 
           if (lov != null) {
               final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysComP0980Form.getTableDef());
               lovWindow.setInitialForm(sysComP0980Form);   //formPanel을적어준다.
               lovWindow.showButtonNew(false); 
               lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
               lovWindow.show();
               lov.fixAttributeFormNames(); 
      
               SysIfP0980.getUsrNm().addKeyListener(new KeyListener() {
                   public void componentKeyUp(ComponentEvent event) {
                       super.componentKeyUp(event);
                       SysIfP0980.getUsrNm().validate();
                       if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                           IColumnFilter filters = null;
                           lovWindow.getLovDef().setTableColumnFilters(filters);
                           lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysIfP0980.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                           lovWindow.getLovDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(SysIfP0980.getUsrDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                           lovWindow.getLovDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(SysIfP0980.getUsrNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                           lovWindow.readData();
                       }
                   }
                });
               
               SysIfP0980.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
                 public void handleEvent(ButtonEvent e) {
                	 SysIfP0980.getUsrNm().validate();
                     IColumnFilter filters = null;
                     lovWindow.getLovDef().setTableColumnFilters(filters);
                     lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysIfP0980.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                     lovWindow.getLovDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(SysIfP0980.getUsrDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                     lovWindow.getLovDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(SysIfP0980.getUsrNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                     lovWindow.readData();
                     
                 }
                });
               
       	} 
   	        
   	    return comform;
   		 
   	}
		 
	 
}
