/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.prgm.client.widget;

import com.app.exterms.prgm.client.lov.DeptMenu.PrgmDeptMenu;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
 
@SuppressWarnings("deprecation")
public class PrgmNonDeptFieldButton<D> extends PrgmTriggerField<D> {  
 
    private PrgmDeptMenu menu;
    private boolean formatValue; 
    
    /**
     * Creates a new date field.
     */
    public PrgmNonDeptFieldButton() {
      super();
      autoValidate = false;  
    //  propertyEditor = new DateTimePropertyEditor();
    //  messages = new DateFieldMessages();
      setTriggerStyle("x-form-search-trigger");
    } 
    
    /**
     * Returns the field's date picker. 
     * @return the date picker
     */
    public void getDeptLov() {
        
       if (menu == null) {
       menu = new PrgmDeptMenu();
 
      } 
    }

    public void getFnPopupCommP160(String deptCd) { 
        //부서
     final MSFFormPanel popCom0145 = PrgmComPopupUtils.lovPopUpNonPrgmCom0145Form(deptCd); 
        
        final FormBinding popBindingCom0145 = popCom0145.getFormBinding();
        
        popBindingCom0145.addListener(Events.Change, new Listener<BaseEvent>() {
           
            @SuppressWarnings("unchecked")
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource(); 
                if (!"".equals(mapModel.get("deptCd"))) {   
                    fireEvent(Events.Change, be); 
                  
                }     
            }
        });
     } 
      

    protected void expand() {
   
        getDeptLov();
 
        focusValue = getValue();
      // handle case when down arrow is opening menu
      DeferredCommand.addCommand(new Command() {
        public void execute() {
         //menu.show(el().dom, "tl-bl?");
          getFnPopupCommP160((String) focusValue);
          //menu.getFnPopupCommP160(deptCd).focus();
            
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
