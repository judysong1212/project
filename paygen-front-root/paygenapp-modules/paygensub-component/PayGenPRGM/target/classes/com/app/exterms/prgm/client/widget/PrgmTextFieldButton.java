/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.prgm.client.widget;

import java.util.Date;

import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.menu.DateMenu;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
 
@SuppressWarnings("deprecation")
public class PrgmTextFieldButton<D> extends TextField<D> {  

    protected BaseEventPreview focusEventPreview;
    protected El trigger;
    protected String triggerStyle = "x-form-trigger-arrow";
    protected boolean mimicing;
   
    private El wrap; 
    private El input; 
  //  private Menu menu;
    private final Button button;
    private final int buttonOffset = 1; 
    private boolean editable = true;
    private boolean monitorTab = true;
    private boolean hideTrigger;
    
    private DateMenu menu;
    
    private FormPanel frmpl; 

    public PrgmTextFieldButton(Button button) {
      super();
      autoValidate = false;
      this.button = button;   
    //  menu = new Menu();
    
    //  this.button.setContextMenu(menu);
      this.button.addSelectionListener( new SelectionListener<ButtonEvent>() {
          @Override
          public void componentSelected(ButtonEvent ce) {
              expand();
           }
          });
      
//      .addListener(Events.Select, new Listener<BaseEvent>() {
//          public void handleEvent(BaseEvent be) {
//              BaseModel mapModel = (BaseModel)be.getSource();
//              focusValue = getValue();
//              Window.alert("ddddd");
//              //setValue((D) mapModel.get(strValue)); 
//            }
//          }); 
       
    
    } 

    
    /**
     * Returns the field's date picker.
     * 
     * @return the date picker
     */
    public DatePicker getDatePicker() {
      if (menu == null) {
        menu = new DateMenu();

        menu.getDatePicker().addListener(Events.Select, new Listener<ComponentEvent>() {
          public void handleEvent(ComponentEvent ce) {
            focusValue = getValue();
            setValue((D) menu.getDate());
            menu.hide();
          }
        });
        menu.addListener(Events.Hide, new Listener<ComponentEvent>() {
          public void handleEvent(ComponentEvent be) {
            focus();
          }
        });
      }
      return menu.getDatePicker();
    }

    private void fnPopupCommP160(String deptCd) { 
       //부서
        MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd); 
         
        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
        
        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
           
            @SuppressWarnings("unchecked")
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource(); 
                if (!"".equals(mapModel.get("deptCd"))) {   
                    fireEvent(Events.Change, be);
                    getInputEl().setValue( (String) mapModel.get("deptNmRtchnt"));  
                    getInputEl().focus(); 
                }     
            }
        });
    } 
      


    @Override
    protected void doAttachChildren() {
        super.doAttachChildren();
        ComponentHelper.doAttach(button);
    }

    @Override
    protected void doDetachChildren() {
        super.doDetachChildren();
        ComponentHelper.doDetach(button);
    }

    @Override
    protected El getInputEl() {
        return input;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        wrap.removeStyleName(fieldStyle);
        if (GXT.isIE) {
            int y1, y2;
            if ((y1 = input.getY()) != (y2 = el().getParent().getY())) {
                int dif = y2 - y1;
                input.setTop(dif);
            }
        }
    }

    /**
     * Returns the trigger style.
     * 
     * @return the trigger style
     */
    public String getTriggerStyle() {
      return triggerStyle;
    }

    /**
     * Returns true if the combo is editable.
     * 
     * @return true if editable
     */
    public boolean isEditable() {
      return editable;
    }

    /**
     * Returns true if the trigger is hidden.
     * 
     * @return the hide trigger state
     */
    public boolean isHideTrigger() {
      return hideTrigger;
    }

    /**
     * Returns true if tab key events are being monitored.
     * 
     * @return true if monitoring
     */
    public boolean isMonitorTab() {
      return monitorTab;
    }

    /**
     * Allow or prevent the user from directly editing the field text. If false is
     * passed, the user will only be able to select from the items defined in the
     * dropdown list.
     * 
     * @param editable true to allow the user to directly edit the field text
     */
    public void setEditable(boolean editable) {
      this.editable = editable;
      if (rendered) {
        El fromEl = getInputEl();
        if (!readOnly) {
          fromEl.dom.setPropertyBoolean("readOnly", !editable);
        }
        fromEl.setStyleName("x-triggerfield-noedit", !editable);
        if (GXT.isAriaEnabled()) {
          fromEl.dom.setAttribute("aria-readonly", editable ? "false" : "true");
        }
      }
    }

    /**
     * True to hide the trigger (defaults to false, pre-render).
     * 
     * @param hideTrigger true to hide the trigger
     */
    public void setHideTrigger(boolean hideTrigger) {
      this.hideTrigger = hideTrigger;
    }

    /**
     * True to monitor tab key events to force the bluring of the field (defaults
     * to true).
     * 
     * @param monitorTab true to monitor tab key events
     */
    public void setMonitorTab(boolean monitorTab) {
      this.monitorTab = monitorTab;
    }

    /**
     * Sets the trigger style name.
     * 
     * @param triggerStyle
     */
    public void setTriggerStyle(String triggerStyle) {
      this.triggerStyle = triggerStyle;
    }

    @Override
    public void setReadOnly(boolean readOnly) {
      this.readOnly = readOnly;
      if (rendered) {
        el().setStyleName(readOnlyFieldStyle, readOnly);
        if (editable || (readOnly && !editable)) {
          getInputEl().dom.setPropertyBoolean("readOnly", readOnly);
        }
      }
    }

    @Override
    protected Size adjustInputSize() {
      return new Size(hideTrigger ? 0 : trigger.getStyleSize().width, 0);
    }

    @Override
    protected void afterRender() {
      super.afterRender();
      addStyleOnOver(trigger.dom, "x-form-trigger-over");
      removeStyleName(fieldStyle);
    }

    protected void beforeBlur() {
    }

    protected void mimicBlur(PreviewEvent e, Element target) { 
      if (!el().dom.isOrHasChild(target) && validateBlur(e, target)) {
        triggerBlur(null);
      }
    }

    @Override
    protected void onKeyDown(FieldEvent fe) {
      super.onKeyDown(fe);
      if (monitorTab && fe.getKeyCode() == KeyCodes.KEY_TAB) {  
        triggerBlur(fe);
      }
      if (fe.getKeyCode() == KeyCodes.KEY_DOWN) {
          fe.stopEvent();
          if (menu == null || !menu.isAttached()) {
            expand();
          }
        }
    }

    protected void expand() {
        DatePicker picker = getDatePicker();

        Object v = getValue();
        Date d = null;
        if (v instanceof Date) {
          d = (Date) v;
        } else {
          d = new Date();
        }

       
        picker.setValue(d, true);

        // handle case when down arrow is opening menu
        DeferredCommand.addCommand(new Command() {
          public void execute() {
            menu.show(el().dom, "tl-bl?");
            menu.getDatePicker().focus();
          }
        });
        
      //  if (menu == null) menu = new Menu();
      //  frmpl = new FormPanel();
       // frmpl.setSize(100, 100);
         
       // menu.add(frmpl);
	  //  focusValue = getValue();
      //  fnPopupCommP160( MSFSharedUtils.allowNulls(focusValue)); 
        // handle case when down arrow is opening menu
//        DeferredCommand.addCommand(new Command() {
//          public void execute() { 
//            //  menu.show(el().dom, "tl-bl?");
//            //  menu.focus();
//             
//          }
//        });
      }
    
    @Override
    protected void onBlur(ComponentEvent ce) {
    }

    @Override
    protected void onClick(ComponentEvent ce) {
      if (!readOnly
          && ((!editable && getInputEl().dom.isOrHasChild(ce.getTarget())) || (trigger.dom.isOrHasChild(ce.getTarget())))) {
        onTriggerClick(ce);
      }
      super.onClick(ce);
    }

    @Override
    protected void onDisable() {
      super.onDisable();
      addStyleName("x-item-disabled");
    }

    @Override
    protected void onEnable() {
      super.onEnable();
      removeStyleName("x-item-disabled");
    }

    @Override
    protected void onFocus(ComponentEvent ce) {
      super.onFocus(ce);
      if (!mimicing) {
        addStyleName("x-trigger-wrap-focus");
        mimicing = true;
        focusEventPreview.add();
      }
    }

    @Override
    protected void onRender(Element target, int index) {

      focusEventPreview = new BaseEventPreview() {
        protected boolean onAutoHide(final PreviewEvent ce) {
          if (ce.getEventTypeInt() == Event.ONMOUSEDOWN) {
            mimicBlur(ce, ce.getTarget());
          }
          return false;
        }
      };

      if (el() != null) {
        super.onRender(target, index);
        return;
      } 

      wrap = new El(DOM.createDiv());
      wrap.addStyleName("x-form-field-wrap");
      wrap.addStyleName("x-form-file-wrap");

      input = new El(DOM.createInputText());
      input.addStyleName(fieldStyle);
      input.addStyleName("x-form-file-text");
      input.setStyleAttribute("color", "#000000");
 

      setElement(wrap.dom, target, index);
      
      trigger = new El(DOM.createDiv());
      trigger.dom.setClassName("x-form-trigger " + triggerStyle);
      trigger.dom.setPropertyString("src", GXT.BLANK_IMAGE_URL);
      if (GXT.isAriaEnabled()) {
        trigger.dom.setPropertyString("alt", "Dropdown");
      }

 
      el().appendChild(input.dom);
      el().appendChild(trigger.dom);

      if (hideTrigger) {
        trigger.setVisible(false);
      }

      super.onRender(target, index); 

      button.addStyleName("x-form-file-btn");
      button.render(wrap.dom);

      if (width == null) {
          setWidth(150);
      } 
      
      if (!editable) {
        setEditable(false);
      }
      
      new KeyNav<FieldEvent>(this) {
          
          @Override
          public void onEsc(FieldEvent fe) {
//            if (menu != null && menu.isAttached()) {
//              menu.hide();
//            }
          }
        };

        if (GXT.isAriaEnabled()) {
          getInputEl().dom.setAttribute("title", getMessages().getInvalidText());
        }
    }
    
 

    @Override
    protected void onResize(int width, int height) {
      super.onResize(width, height);
      if ((GXT.isIE6 || GXT.isIE7) && !hideTrigger) {
        int y;
        if ((y = input.getY()) != trigger.getY()) {
          trigger.setY(y);
        }
      }
      input.setWidth(wrap.getWidth() - button.el().getWidth() - buttonOffset);
    }

    protected void onTriggerClick(ComponentEvent ce) {
      fireEvent(Events.TriggerClick, ce); 
      expand();
    }

    protected void triggerBlur(ComponentEvent ce) {
      DeferredCommand.addCommand(new Command() {
        public void execute() {
          getFocusEl().blur();
        }
      });
      mimicing = false;
      focusEventPreview.remove();
      beforeBlur();
      removeStyleName("x-trigger-wrap-focus");
      super.onBlur(ce);
    }

  
    protected boolean validateBlur(DomEvent ce, Element target) {
        return menu == null || (menu != null && !menu.isVisible());
    }

}
