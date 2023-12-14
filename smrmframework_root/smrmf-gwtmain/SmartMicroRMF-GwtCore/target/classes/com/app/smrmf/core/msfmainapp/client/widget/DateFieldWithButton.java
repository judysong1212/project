/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

@SuppressWarnings("deprecation")
public class DateFieldWithButton extends DateField {    
 
	private El wrap;
// private El input;
// protected El twinTrigger;
 
 private final Button button;
 private final int buttonOffset = 3;
	 
//   private final String twinTriggerStyle = "x-form-clear-trigger";
 private El span;
  
   
 public DateFieldWithButton(Button button) {
     this.button = button;
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
 
  @Override
  protected void onResize(int width, int height) {
     super.onResize(width, height);
   int tw = span.getWidth();
   if (width != Style.DEFAULT) {
   	  input.setWidth(wrap.getWidth() - button.el().getWidth() - buttonOffset - tw);
      //  getInputEl().setWidth(width - tw);
   }
    
  }
	 
   @Override
   protected void afterRender() {
       super.afterRender();
      // addStyleOnOver(twinTrigger.dom, "x-form-trigger-over");
   }
   
   @Override
   public void onComponentEvent(ComponentEvent ce) {
       super.onComponentEvent(ce);
       int type = ce.getEventTypeInt();
     //  if ((ce.getTarget() == twinTrigger.dom) && (type == Event.ONCLICK)) {
     //      onTwinTriggerClick(ce);
      // }
   }
   
   @Override
   protected void onRender(Element target, int index) {
       input = new El(DOM.createInputText());
       wrap = new El(DOM.createDiv());
       wrap.addStyleName("x-form-field-wrap");
       wrap.addStyleName("x-form-file-wrap");
       
       trigger = new El(DOM.createImg());
       trigger.dom.setClassName("x-form-trigger " + triggerStyle);
       trigger.dom.setPropertyString("src", GXT.BLANK_IMAGE_URL);
       
      // twinTrigger = new El(DOM.createButton());
      // twinTrigger.dom.setClassName("x-form-trigger " + "x-form-file-btn");
      // twinTrigger.dom.setPropertyString("src", GXT.BLANK_IMAGE_URL);
         
       
       span = new El(DOM.createSpan());
       span.dom.setClassName("x-form-twin-triggers");
       
       button.addStyleName("x-form-file-btn");
       button.render(span.dom);

       if (width == null) {
           setWidth(150);
       }
       
       DOM.appendChild(span.dom, trigger.dom);
       DOM.appendChild(span.dom, button.getElement());
       //DOM.appendChild(span.dom, twinTrigger.dom);
       
       DOM.appendChild(wrap.dom, input.dom);
       DOM.appendChild(wrap.dom, span.dom);
       
       setElement(wrap.dom, target, index); 
       
       addStyleOnOver(button.getElement(), "x-form-trigger-over");
     //  addStyleOnOver(twinTrigger.dom, "x-form-trigger-over");
       addStyleOnOver(trigger.dom, "x-form-trigger-over");
       
       if (isHideTrigger()) {
         span.setVisible(false);
       }
       
       super.onRender(target, index); 
       GWTUtils.setCustomStyles(this);
      // if (!isEditable()) {
      //     setEditable(true);
       //    setEditable(false);
      // }
    
    //   DOM.sinkEvents(twinTrigger.dom, Event.ONCLICK | Event.MOUSEEVENTS);
    //   DOM.sinkEvents(wrap.dom, Event.FOCUSEVENTS);
     //  DOM.sinkEvents(trigger.dom, Event.ONCLICK | Event.MOUSEEVENTS);
   }
   
//   protected void onTwinTriggerClick(ComponentEvent ce) {
//       setValue(null);
//       clearInvalid();
//       fireEvent(Events.TwinTriggerClick, ce);
//   }  
//    private El wrap;
//    private El input;
//    private final Button button;
//    private final int buttonOffset = 3;
//
//    public DateFieldWithButton(Button button) {
//        this.button = button;
//    }
//
//    @Override
//    protected void doAttachChildren() {
//        super.doAttachChildren();
//        ComponentHelper.doAttach(button);
//    }
//
//    @Override
//    protected void doDetachChildren() {
//        super.doDetachChildren();
//        ComponentHelper.doDetach(button);
//    }
//
//    @Override
//    protected El getInputEl() {
//        return input;
//    }
//
//    @Override
//    protected void onAttach() {
//        super.onAttach();
//        wrap.removeStyleName(fieldStyle);
//        if (GXT.isIE) {
//            int y1, y2;
//            if ((y1 = input.getY()) != (y2 = el().getParent().getY())) {
//                int dif = y2 - y1;
//                input.setTop(dif);
//            }
//        }
//    }
//
//    @Override
//    protected void onRender(Element target, int index) {
//        wrap = new El(DOM.createDiv());
//        wrap.addStyleName("x-form-field-wrap");
//        wrap.addStyleName("x-form-file-wrap");
//
//        input = new El(DOM.createInputText());
//        input.addStyleName(fieldStyle);
//        input.addStyleName("x-form-file-text");
//        input.setStyleAttribute("color", "#000000");
//
//        wrap.appendChild(input.dom);
//
//        setElement(wrap.dom, target, index);
//        super.onRender(target, index);
//        GWTUtils.setCustomStyles(this);
//        button.addStyleName("x-form-file-btn");
//        button.render(wrap.dom);
//
//        if (width == null) {
//            setWidth(150);
//        }
//    }
//
//    @Override
//    protected void onResize(int width, int height) {
//        super.onResize(width, height);
//        input.setWidth(wrap.getWidth() - button.el().getWidth() - buttonOffset);
//    }
}


// EXAMPLE
//public void onModuleLoad() {
//
//    FormPanel form = new FormPanel();
//
//    TextFieldWithButton<String> field = new TextFieldWithButton<String>(new Button("button"));
//    field.setFieldLabel("field");
//
//    TextField<String> t = new TextField<String>();
//    t.setFieldLabel("other field");
//
//    form.add(field);
//    form.add(t);
//
//    RootPanel.get().add(form);
//}