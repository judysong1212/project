package com.app.smrmf.syscom.client.util;

import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.form.SysComP0120;
import com.app.smrmf.syscom.client.form.SysComP0980;
import com.app.smrmf.syscom.client.form.SysComP0990;
import com.app.smrmf.syscom.client.form.SysComPostDoro;
import com.app.smrmf.syscom.client.form.defs.SsoxUserDef;
import com.app.smrmf.syscom.client.form.defs.SysComCmmn0320Def;
import com.app.smrmf.syscom.client.form.defs.SysComCmmn0600Def;
import com.app.smrmf.syscom.client.form.defs.SysComSysm0100Def;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.event.dom.client.KeyCodes;

public class SysComPopupUtils {
 
    
//    private static Button btnMtOk;
//    private static Button btnMtCancel;
//    private static ListStore<BaseModel> storeList;
    
   /**
    * 공통팝업처리 함수
    * @param strRpsttvCd
    * @return MSFFormPanel
    * 사용예 
    * MSFFormPanel comform = lovPopUpMsfCom0130Form("A031");
    * final FormBinding popBinding = comform.getFormBinding();
    */
//	public static final MSFFormPanel lovPopUpMsfCom0130Form(final String strRpsttvCd){
//		
//		// TODO Auto-generated method stub
//		Lov lov = null;    
//		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysComBass0300Def(), 1, 0);
//		MSFCustomForm sysComP0130Form = customForm.getCustomForm();    
//		MSFFormPanel comform = (MSFFormPanel)sysComP0130Form; 
//		
//	    final SysComP0130 sysComP0130 =  new SysComP0130(350,450); 
//        customForm.setLov(sysComP0130);
//       
//		lov = customForm.getLov();    
//		
//	    if (MSFSharedUtils.paramNotNull(strRpsttvCd)) {
//	        customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//	        customForm.getLov().getLovDef().addColumnFilter("commCdNm", "", SimpleColumnFilter.OPERATOR_EQUALS); 
//	    } else {
//	        return null;
//	    }
//        if (lov != null) { 
//            final LovLiveGeneric  lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysComP0130Form.getTableDef());
//            lovWindow.setInitialForm(sysComP0130Form);   //formPanel을적어준다.
//            lovWindow.showButtonNew(false);  
//            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//            lovWindow.show();
//            lov.fixAttributeFormNames(); 
//   
//            sysComP0130.getCommCdNm().addKeyListener(new KeyListener() {
//                public void componentKeyUp(ComponentEvent event) {
//                    super.componentKeyUp(event);
//                    sysComP0130.getCommCdNm().validate();
//                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
//                        IColumnFilter filters = null;
//                        lovWindow.getLovDef().setTableColumnFilters(filters);
//                        lovWindow.getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.getLovDef().addColumnFilter("commCdNm", MSFSharedUtils.defaultNulls(sysComP0130.getCommCdNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                        lovWindow.readData();
//                    }
//                }
//             });
//            
//            SysComP0130.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
//              public void handleEvent(ButtonEvent e) {
//                  sysComP0130.getCommCdNm().validate();
//                  IColumnFilter filters = null;
//                  lovWindow.getLovDef().setTableColumnFilters(filters);
//                  lovWindow.getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.getLovDef().addColumnFilter("commCdNm", MSFSharedUtils.defaultNulls(sysComP0130.getCommCdNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                  lovWindow.readData();
//                  
//              }
//             });
//            sysComP0130.getCommCdNm().focus();  
//    	} 
//	        
//	        return comform;
//		 
//	}
	
	 
    
  /**
   * 임시 사용안함.    
   * @return
   */
   	public static final MSFFormPanel lovPopUpMsfSysComP0990Form(){ 
   		
   		Lov lov = null;     
   		//LovLiveGeneric lovWindow = null; 
   		final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SsoxUserDef(), 1, 0);
   		MSFCustomForm sysComP0990Form = customForm.getCustomForm();    
   		MSFFormPanel comform = (MSFFormPanel)sysComP0990Form;
   		final SysComP0990 sysComP0990 =  new SysComP0990(850,600); 
   		customForm.setLov(sysComP0990);
   		lov = customForm.getLov();   
   		
//   		if (MSFSharedUtils.paramNull(UsrName)) {
//   		    customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
//   		} else {
//   			sysComP0990.hanNm.setValue(UsrName);
//   		    customForm.getLov().getLovDef().addColumnFilter("hanNm", UsrName, SimpleColumnFilter.OPERATOR_EQUALS);  
//   		}
   		
   	 
           if (lov != null) {
               final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysComP0990Form.getTableDef());
               lovWindow.setInitialForm(sysComP0990Form);   //formPanel을적어준다.
               lovWindow.showButtonNew(false); 
               lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
               lovWindow.show();
               lov.fixAttributeFormNames(); 
      
//               sysComP0100.hanNm.addKeyListener(new KeyListener() {
//                   public void componentKeyUp(ComponentEvent event) {
//                       super.componentKeyUp(event);
//                       sysComP0100.hanNm.validate();
//                       if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
//                           IColumnFilter filters = null;
//                           lovWindow.getLovDef().setTableColumnFilters(filters);
//                            
//                           lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.typOccuCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.emymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.businCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.hdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(sysComP0100.hanNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(sysComP0100.resnRegnNum.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(sysComP0100.systemkey.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                           lovWindow.readData();
//                       }
//                   }
//                });
//               
//               sysComP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
//                 public void handleEvent(ButtonEvent e) {
//                     sysComP0100.hanNm.validate();
//                     IColumnFilter filters = null;
//                     lovWindow.getLovDef().setTableColumnFilters(filters);
//                     lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.typOccuCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.emymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.businCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(sysComP0100.hdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(sysComP0100.hanNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(sysComP0100.resnRegnNum.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(sysComP0100.systemkey.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     lovWindow.readData();
//                     
//                 }
//                });
               
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
   		final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysComSysm0100Def(), 1, 0);
   		MSFCustomForm sysComP0980Form = customForm.getCustomForm();    
   		MSFFormPanel comform = (MSFFormPanel)sysComP0980Form;
   		final SysComP0980 sysComP0980 =  new SysComP0980(850,600); 
   		customForm.setLov(sysComP0980);
   		lov = customForm.getLov();   
   		
   		  if (MSFSharedUtils.paramNull(usrNm)) {
   		    customForm.getLov().getLovDef().addColumnFilter("usrNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
   		  } else {
   			SysComP0980.getUsrNm().setValue(usrNm);
   		    customForm.getLov().getLovDef().addColumnFilter("usrNm", usrNm, SimpleColumnFilter.OPERATOR_EQUALS);  
   		  }
   		
   	 
           if (lov != null) {
               final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysComP0980Form.getTableDef());
               lovWindow.setInitialForm(sysComP0980Form);   //formPanel을적어준다.
               lovWindow.showButtonNew(false); 
               lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
               lovWindow.show();
               lov.fixAttributeFormNames(); 
      
               SysComP0980.getUsrNm().addKeyListener(new KeyListener() {
                   public void componentKeyUp(ComponentEvent event) {
                       super.componentKeyUp(event);
                       SysComP0980.getUsrNm().validate();
                       if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                           IColumnFilter filters = null;
                           lovWindow.getLovDef().setTableColumnFilters(filters);
                           lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysComP0980.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                           lovWindow.getLovDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(SysComP0980.getUsrDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                           lovWindow.getLovDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(SysComP0980.getUsrNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                           lovWindow.readData();
                       }
                   }
                });
               
               SysComP0980.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
                 public void handleEvent(ButtonEvent e) {
                	 SysComP0980.getUsrNm().validate();
                     IColumnFilter filters = null;
                     lovWindow.getLovDef().setTableColumnFilters(filters);
                     lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysComP0980.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                     lovWindow.getLovDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(SysComP0980.getUsrDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                     lovWindow.getLovDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(SysComP0980.getUsrNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                     lovWindow.readData();
                     
                 }
                });
               
       	} 
   	        
   	    return comform;
   		 
   	}
   	

	//도로명주소팝업
    public static final MSFFormPanel lovPopUpMsfCom0120Form(){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysComCmmn0320Def(), 1, 0);
		MSFCustomForm sysComP0120Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysComP0120Form;
		final SysComP0120 sysComP0120 = new SysComP0120(850,550); 
        
		customForm.setLov(sysComP0120);
		lov = customForm.getLov();   
		customForm.getLov().getLovDef().addColumnFilter("searchWord", "", SimpleColumnFilter.OPERATOR_EQUALS);   
	 
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
            lovWindow.setInitialForm(sysComP0120Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
          
            SysComP0120.getSearchWord().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysComP0120.getSearchWord().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                       
                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getSearchWord().getValue(),""))) {
                            return;
                        }
 
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("searchWord", MSFSharedUtils.defaultNulls(SysComP0120.getSearchWord().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             }); 
            
            SysComP0120.btnUsrSearch04.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                	  if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getSearchWord().getValue(),""))) {
                          return;
                      }
                    IColumnFilter filters = null;
                    lovWindow.getLovDef().setTableColumnFilters(filters);
                    lovWindow.getLovDef().addColumnFilter("searchWord", MSFSharedUtils.defaultNulls(SysComP0120.getSearchWord().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.readData();
                    
                }
               });
            SysComP0120.getRoadNmTat().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysComP0120.getRoadNmTat().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""))) {
                            return;
                        }
//                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""))) {
//                            return;
//                        }
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmTat", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLi", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLi().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                       
                        lovWindow.readData();
                    }
                }
             }); 
            
            SysComP0120.getRoadNmLi().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysComP0120.getRoadNmLi().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""))) {
                            return;
                        }
                       
//                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""))) {
//                            return;
//                        }
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("getRoadNmTat()", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLi", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLi().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             }); 
            SysComP0120.getRoadNmLtnumBobn().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        SysComP0120.getRoadNmLtnumBobn().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""))) {
                                return;
                            }
//                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""))) {
//                                return;
//                            }
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmTat", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmLi", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLi().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 }); 
            SysComP0120.getBuildNumBobn().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        SysComP0120.getBuildNumBobn().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNm().getValue(),""))) {
                                return;
                            }
//                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getBuildNumBobn()n.getValue(),""))) {
//                                return;
//                            }
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNm", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("buildNumBobn", MSFSharedUtils.defaultNulls(SysComP0120.getBuildNumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 }); 
                SysComP0120.getBuildNm().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        SysComP0120.getBuildNm().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getBuildNm().getValue(),""))) {
                                return;
                            }
                           
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("buildNm", MSFSharedUtils.defaultNulls(SysComP0120.getBuildNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 });  
            
            SysComP0120.btnUsrSearch01.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                      return;
                  }
                  if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                      return;
                  }
                  if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""))) {
                      return;
                  }
//                  if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""))) {
//                      return;
//                  }
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("roadNmTat", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            
            SysComP0120.btnUsrSearch02.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getRoadNm().getValue(),""))) {
                        return;
                    }
//                    if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getBuildNumBobn()n.getValue(),""))) {
//                        return;
//                    }
                    IColumnFilter filters = null;
                    lovWindow.getLovDef().setTableColumnFilters(filters);
                    lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("roadNm", MSFSharedUtils.defaultNulls(SysComP0120.getRoadNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("buildNumBobn", MSFSharedUtils.defaultNulls(SysComP0120.getBuildNumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.readData();
                    
                }
               });
            
            SysComP0120.btnUsrSearch03.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.defaultNulls(SysComP0120.getBuildNm().getValue(),""))) {
                        return;
                    }
                   
                    IColumnFilter filters = null;
                    lovWindow.getLovDef().setTableColumnFilters(filters);
                    lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComP0120.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("buildNm", MSFSharedUtils.defaultNulls(SysComP0120.getBuildNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComP0120.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.readData();
                    
                }
               });
   
    	} 
	        
	        return comform;
		 
	}
     
    /**
     * 
     * <pre>
     * 1. 개요 : 우편번호 연계 모듈에 의한 호출 처리 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : lovPopUpMsfCom0600Form
     * @date : Apr 6, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Apr 6, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @return
     */
    public static final MSFFormPanel lovPopUpMsfCom0600Form(){
		
		// TODO Auto-generated method stub
		Lov lov = null;     
		//LovLiveGeneric lovWindow = null; 
		MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysComCmmn0600Def(), 1, 0);
		MSFCustomForm sysComP0600Form = customForm.getCustomForm();    
		MSFFormPanel comform = (MSFFormPanel)sysComP0600Form;
		final SysComPostDoro sysComP0600 = new SysComPostDoro(850,550); 
        
		customForm.setLov(sysComP0600);
		lov = customForm.getLov();   
		customForm.getLov().getLovDef().addColumnFilter("keyword", "", SimpleColumnFilter.OPERATOR_EQUALS);   
	 
        if (lov != null) {
            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
            lovWindow.setInitialForm(sysComP0600Form);   //formPanel을적어준다.
            lovWindow.showButtonNew(false);
            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
            lovWindow.show();
            lov.fixAttributeFormNames(); 
          
            SysComPostDoro.getSearchWord().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysComPostDoro.getSearchWord().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                       
                        if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getSearchWord().getValue(),""))) {
                            return;
                        }
 
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("keyword", MSFSharedUtils.defaultNulls(SysComPostDoro.getSearchWord().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             }); 
            
            SysComPostDoro.btnUsrSearch04.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                	  if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getSearchWord().getValue(),""))) {
                          return;
                      }
                    IColumnFilter filters = null;
                    lovWindow.getLovDef().setTableColumnFilters(filters);
                    lovWindow.getLovDef().addColumnFilter("keyword", MSFSharedUtils.defaultNulls(SysComPostDoro.getSearchWord().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.readData();
                    
                }
               });
            SysComPostDoro.getRoadNmTat().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysComPostDoro.getRoadNmTat().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""))) {
                            return;
                        }
//                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0600.getRoadNmLtnumBobn().getValue(),""))) {
//                            return;
//                        }
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmTat", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLi", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLi().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                       
                        lovWindow.readData();
                    }
                }
             }); 
            
            SysComPostDoro.getRoadNmLi().addKeyListener(new KeyListener() {
                public void componentKeyUp(ComponentEvent event) {
                    super.componentKeyUp(event);
                    SysComPostDoro.getRoadNmLi().validate();
                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                            return;
                        }
                        if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""))) {
                            return;
                        }
                       
//                        if ("".equals(MSFSharedUtils.defaultNulls(SysComP0600.getRoadNmLtnumBobn().getValue(),""))) {
//                            return;
//                        }
                        IColumnFilter filters = null;
                        lovWindow.getLovDef().setTableColumnFilters(filters);
                        lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("getRoadNmTat()", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLi", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLi().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                        lovWindow.readData();
                    }
                }
             }); 
            SysComPostDoro.getRoadNmLtnumBobn().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        SysComPostDoro.getRoadNmLtnumBobn().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""))) {
                                return;
                            }
//                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0600.getRoadNmLtnumBobn().getValue(),""))) {
//                                return;
//                            }
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmTat", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmLi", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLi().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 }); 
            SysComPostDoro.getBuildNumBobn().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        SysComPostDoro.getBuildNumBobn().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNm().getValue(),""))) {
                                return;
                            }
//                            if ("".equals(MSFSharedUtils.defaultNulls(SysComP0600.getBuildNumBobn()n.getValue(),""))) {
//                                return;
//                            }
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNm", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("buildNumBobn", MSFSharedUtils.defaultNulls(SysComPostDoro.getBuildNumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 }); 
                SysComPostDoro.getBuildNm().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        SysComPostDoro.getBuildNm().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                                return;
                            }
                            if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getBuildNm().getValue(),""))) {
                                return;
                            }
                           
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("buildNm", MSFSharedUtils.defaultNulls(SysComPostDoro.getBuildNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 });  
            
            SysComPostDoro.btnUsrSearch01.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                      return;
                  }
                  if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                      return;
                  }
                  if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""))) {
                      return;
                  }
//                  if ("".equals(MSFSharedUtils.defaultNulls(SysComP0600.getRoadNmLtnumBobn().getValue(),""))) {
//                      return;
//                  }
                  IColumnFilter filters = null;
                  lovWindow.getLovDef().setTableColumnFilters(filters);
                  lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("roadNmTat", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmTat().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.getLovDef().addColumnFilter("roadNmLtnumBobn", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNmLtnumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
                  lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                  lovWindow.readData();
                  
              }
             });
            
            SysComPostDoro.btnUsrSearch02.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNm().getValue(),""))) {
                        return;
                    }
//                    if ("".equals(MSFSharedUtils.defaultNulls(SysComP0600.getBuildNumBobn()n.getValue(),""))) {
//                        return;
//                    }
                    IColumnFilter filters = null;
                    lovWindow.getLovDef().setTableColumnFilters(filters);
                    lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("roadNm", MSFSharedUtils.defaultNulls(SysComPostDoro.getRoadNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("buildNumBobn", MSFSharedUtils.defaultNulls(SysComPostDoro.getBuildNumBobn().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.readData();
                    
                }
               });
            
            SysComPostDoro.btnUsrSearch03.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"))) {
                        return;
                    }
                    if ("".equals(MSFSharedUtils.defaultNulls(SysComPostDoro.getBuildNm().getValue(),""))) {
                        return;
                    }
                   
                    IColumnFilter filters = null;
                    lovWindow.getLovDef().setTableColumnFilters(filters);
                    lovWindow.getLovDef().addColumnFilter("roadNmCtapv", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtapv(),"roadNmCtapv"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("roadNmCtatgu", MSFSharedUtils.getSelectedComboValue(SysComPostDoro.getRoadNmCtatgu(),"roadNmCtatgu"), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("buildNm", MSFSharedUtils.defaultNulls(SysComPostDoro.getBuildNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.getLovDef().addColumnFilter("valueAttribute", MSFSharedUtils.defaultNulls(SysComPostDoro.valueAttribute,""), SimpleColumnFilter.OPERATOR_EQUALS); 
                    lovWindow.readData();
                    
                }
               });
   
    	} 
	        
	        return comform;
		 
	}
		 
	 
}
