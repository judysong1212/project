/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.event.WindowListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.form.TriggerField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;


public class MSFMultiComboBox<D extends ModelData> extends TriggerField<String> {  

 
 private Dialog checkBoxListHolder;
 private CheckBoxListView<D> listView;
 private ListStore<D> store;


 private String delimiter = ",";
 private boolean readOnly;
 

 public MSFMultiComboBox() {  
  store = new ListStore<D>();
  listView = new CheckBoxListView<D>();

//  checkBoxListHolder.addDomHandler(new BlurHandler() {
//
//      @Override 
//      public void onBlur(BlurEvent event) {
//          // TODO Auto-generated method stub
//          
//      }
//
//  }, BlurEvent.getType());
////
////
////  checkBoxListHolder.addDomHandler(new MouseOutHandler() {
////
////      @Override 
////      public void onMouseOut(MouseOutEvent event) {
////          // TODO Auto-generated method stub
////
////      }
////
////  }, MouseOutEvent.getType());
////  
//  checkBoxListHolder.sinkEvents(Event.ONBLUR);
    
 }
 

 @Override
 protected void onTriggerClick(ComponentEvent ce) {
  super.onTriggerClick(ce);
  checkBoxListHolder.setSize(getWidth(), 200);
  listView.setWidth(getWidth());
  checkBoxListHolder.setPosition(getAbsoluteLeft(), 
    getAbsoluteTop() + getHeight());
  if(checkBoxListHolder.isVisible()) {
   checkBoxListHolder.hide();
  }
  else {
   checkBoxListHolder.show();
  }
 }

// @Override
// protected void triggerBlur(ComponentEvent ce) {
// 
// // checkBoxListHolder.setSize(getWidth(), 200);
// // listView.setWidth(getWidth());
// // checkBoxListHolder.setPosition(getAbsoluteLeft(), 
//  //  getAbsoluteTop() + getHeight());
//  if(checkBoxListHolder.isVisible()) {
//   checkBoxListHolder.hide();
//  }
//  else {
//  // checkBoxListHolder.show();
//  }
//  //super.triggerBlur(ce);
// }
 
 @Override
 protected void onRender(Element target, int index) {
  super.onRender(target, index);
  checkBoxListHolder = new Dialog();  
  checkBoxListHolder.setClosable(false);
  checkBoxListHolder.setHeaderVisible(false);
  checkBoxListHolder.setFooter(false);
  checkBoxListHolder.setFrame(false);
  checkBoxListHolder.setResizable(false);
  checkBoxListHolder.setAutoHide(false);
  checkBoxListHolder.getButtonBar().setVisible(false);
  checkBoxListHolder.setLayout(new FitLayout());
  checkBoxListHolder.setFocusWidget(listView);
  checkBoxListHolder.add(listView);
  listView.setStore(store); 
 
  checkBoxListHolder.addWindowListener(new WindowListener(){ 
   @Override
   public void windowHide(WindowEvent we) {
    setValue(parseCheckedValues(listView));  
//    GWT.log(String.valueOf(we.getEventTypeInt()));
//    if( we.getEventTypeInt() == Event.ONBLUR) {
//        GWT.log(String.valueOf(we.getEventTypeInt()));
//    } 
    listView.fireEvent(Events.CheckChanged);
   }
   
//   @Override
//   public void handleEvent(WindowEvent e) { 
//       EventType type = e.getType();
//       GWT.log(String.valueOf(type.getEventCode()));
//   }
 
   }); 
  
//  checkBoxListHolder.addListener(Events.OnBlur, new Listener<ComponentEvent>() {
//      public void handleEvent(ComponentEvent be) {
//          GWT.log("11111");
//      }
//});
//  
//  listView.addListener(Events.Deactivate , new Listener<ComponentEvent>() {
//      public void handleEvent(ComponentEvent be) {
//          GWT.log("2222");
//      }
//});
//
 
//  
//  checkBoxListHolder.addListener(Events.OnBlur, new Listener<ComponentEvent>() {
//      @Override
//      public void handleEvent(ComponentEvent ce) { 
//          GWT.log("aaaaaaa");
////          checkBoxListHolder.addListener(Events.OnMouseUp, new Listener<ComponentEvent>() {
////              @Override
////              public void handleEvent(ComponentEvent ce) { 
////                  GWT.log("ddaaaaaaaaaaaaaaaaaa");
////                  setValue(parseCheckedValues(listView));
////                  onTriggerClick(ce);
////              } 
////           });  
//      } 
//   });   
 
 }

 private String parseCheckedValues(CheckBoxListView<D> checkBoxView) {
  StringBuffer buf = new StringBuffer();
  if(checkBoxView != null) {
   List<D> selected = checkBoxView.getChecked();
   int index = 1, len = selected.size();
   for(D c : selected) {
    buf.append(c.get(listView.getDisplayProperty()));
    if(index < len) {
     buf.append(delimiter);
    }
    index++;
   }
  }
  return buf.toString();
 }
 
public void showClose(ComponentEvent ce) {
    onTriggerClick(ce);
}

 
 public CheckBoxListView<D> getListView() {
  return listView;
 }

 public Dialog getCheckBoxListHolder() {
     return checkBoxListHolder;
 }


 public void setListView(CheckBoxListView<D> listView) {
  this.listView = listView;
 }


 public ListStore<D> getStore() { 
  return store;
 } 

 public ListStore<D> getInitStore() {
  store.removeAll();
  store.commitChanges();
  return store;
 }


 public void setStore(ListStore<D> store) {
  this.store = store;
 }


 public String getDelimiter() {
  return delimiter;
 }


 public void setDelimiter(String delimiter) {
  this.delimiter = delimiter;
 }


 public boolean isReadOnly() {
  return readOnly;
 }


 public void setReadOnly(boolean readOnly) {
  this.readOnly = readOnly;
 }




}
