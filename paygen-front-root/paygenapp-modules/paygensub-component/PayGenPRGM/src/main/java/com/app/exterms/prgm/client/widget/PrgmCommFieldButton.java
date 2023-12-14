/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.prgm.client.widget;

import com.app.exterms.prgm.client.form.PrgmComP0130;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0300Def;
import com.app.exterms.prgm.client.lov.DeptMenu.PrgmComMenu;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
 
@SuppressWarnings("deprecation")
public class PrgmCommFieldButton<D> extends PrgmTriggerField<D> {  
 
    private PrgmComMenu menu;
    private boolean formatValue; 
    private String popAcadAbtyDivCd;
    private String rpsttvCd;
    /**
     * Creates a new date field.
     */
    public PrgmCommFieldButton() {
      super();
      autoValidate = false;   
    //  propertyEditor = new DateTimePropertyEditor();
    //  messages = new DateFieldMessages();
      setTriggerStyle("x-form-search-trigger");
    }

    public void setAcadAbtyDivCd(String popAcadAbtyDivCd) { 
        this.popAcadAbtyDivCd = popAcadAbtyDivCd; 
     } 
    
    /**
     * Returns the field's date picker.
     * 
     * @return the date picker
     */
    public void getCommLov() {
        
       if (menu == null) {
       menu = new PrgmComMenu();
 
      } 
        
    }

    public String getRpsttvCd() {
        return this.rpsttvCd;
    }

    public void setRpsttvCd(String rpsttvCd) {
        this.rpsttvCd = rpsttvCd;
    }

    private void fnPopupCommField(String commNm) {
        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨.
        if (MSFSharedUtils.paramNotNull(popAcadAbtyDivCd) && MSFSharedUtils.paramNull(this.getRpsttvCd())) {
                
            if("2".equals(popAcadAbtyDivCd.substring(popAcadAbtyDivCd.length()-2,popAcadAbtyDivCd.length()-1))){
                this.setRpsttvCd("A031");
            }else if("3".equals(popAcadAbtyDivCd.substring(popAcadAbtyDivCd.length()-2,popAcadAbtyDivCd.length()-1))){
                this.setRpsttvCd("A032");
            }else if("4".equals(popAcadAbtyDivCd.substring(popAcadAbtyDivCd.length()-2,popAcadAbtyDivCd.length()-1))){
                this.setRpsttvCd("A033");  
            }else if("5".equals(popAcadAbtyDivCd.substring(popAcadAbtyDivCd.length()-2,popAcadAbtyDivCd.length()-1))){
                this.setRpsttvCd("A034");  
            }else if(("6".compareTo((popAcadAbtyDivCd.substring(popAcadAbtyDivCd.length()-2,popAcadAbtyDivCd.length()-1)))) <= 0){
                this.setRpsttvCd("A035");  
            }else{
                this.setRpsttvCd(""); 
            } 
        } else  if (MSFSharedUtils.paramNotNull(popAcadAbtyDivCd) && MSFSharedUtils.paramNotNull(this.getRpsttvCd())) {    
            if(("5".compareTo((popAcadAbtyDivCd.substring(popAcadAbtyDivCd.length()-2,popAcadAbtyDivCd.length()-1)))) > 0){ 
                return; 
            }
        } else {
            if (MSFSharedUtils.paramNull(this.getRpsttvCd())) {
                
                MessageBox.alert("", "검색할 공통코드가 존재하지 않습니다. 관리자에게 문의!", null);
                return; 
            }
            
        }    
        
        MSFFormPanel popCom0130 = lovPopUpPrgmCom0130Form(this.getRpsttvCd(),commNm);  //공통  
        
        final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
       
        popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource();
                if (!"".equals(mapModel.get("commCd"))) { 
                    fireEvent(Events.Change, be);  
                }   
            }
        });
    }
     
    
    /**
     * 공통팝업처리 함수
     * @param strRpsttvCd
     * @return MSFFormPanel
     * 사용예 
     * MSFFormPanel comform = lovPopUpPrgmCom0130Form("A031");
     * final FormBinding popBinding = comform.getFormBinding();
     */
     public static final MSFFormPanel lovPopUpPrgmCom0130Form(final String strRpsttvCd,String commCdNm){
         
         
      // TODO Auto-generated method stub
         Lov lov = null;    
         MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 1, 0);
         MSFCustomForm sysComP0130Form = customForm.getCustomForm();    
         MSFFormPanel comform = (MSFFormPanel)sysComP0130Form; 
         
         final PrgmComP0130 sysComP0130 =  new PrgmComP0130(350,450); 
         customForm.setLov(sysComP0130);
        
         lov = customForm.getLov();    
         
         if (MSFSharedUtils.paramNotNull(strRpsttvCd)) {
             sysComP0130.getCommCdNm().setValue(commCdNm);
             customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", strRpsttvCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             customForm.getLov().getLovDef().addColumnFilter("commCdNm", MSFSharedUtils.allowNulls(commCdNm), SimpleColumnFilter.OPERATOR_EQUALS); 
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
             
             sysComP0130.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
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
      

    protected void expand() {
    
        getCommLov();
       
        focusValue = getValue();
      // handle case when down arrow is opening menu
      DeferredCommand.addCommand(new Command() {
        public void execute() {
         //menu.show(el().dom, "tl-bl?");
            fnPopupCommField(MSFSharedUtils.allowNulls(focusValue));
          //menu.getFnPopupCommP160(CommCd).focus(); 
        }
      });
    }

    @Override
    protected void onKeyDown(FieldEvent fe) {
      super.onKeyDown(fe);
      if (fe.getKeyCode() == KeyCodes.KEY_DOWN) {
        fe.stopEvent();
        if (menu == null || !menu.isAttached()) {
          expand();
        }
      }
    }

    @Override
    protected void onRender(Element target, int index) {
      super.onRender(target, index); 
      
      new KeyNav<FieldEvent>(this) {

        @Override
        public void onEsc(FieldEvent fe) {
          if (menu != null && menu.isAttached()) {
            menu.hide();
          }
        }
      };

      if (GXT.isAriaEnabled()) {
        getInputEl().dom.setAttribute("title", getMessages().getInvalidText());
      }
    }

    @Override
    protected void onTriggerClick(ComponentEvent ce) {
      super.onTriggerClick(ce);
      expand();
    }

    @Override
    protected boolean validateBlur(DomEvent e, Element target) {
      return menu == null || (menu != null && !menu.isVisible());
    }

    @Override
    protected boolean validateValue(String value) {
      if (!super.validateValue(value)) {
        return false;
      }
      if (value.length() < 1) { // if it's blank and textfield didn't flag it then
        // it's valid
        return true;
      }
 
      return true;
    }

}
