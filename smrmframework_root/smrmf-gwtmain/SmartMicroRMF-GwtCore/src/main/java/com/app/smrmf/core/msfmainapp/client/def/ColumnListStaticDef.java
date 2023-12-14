/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFRadioGroup;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTrigger;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;

public class ColumnListStaticDef extends ColumnDef{

    private List<BaseModel> baseRecords;
    //protected MSFComboBox<BaseModel> cb;
    //protected RadioGroup radioGroup;
    protected boolean isRadio = false;

    public ColumnListStaticDef(
            String title, 
            String attributeName, 
            int type, 
            int size,
            Boolean isRequired, 
            Boolean isVisibleInGrid,
            Boolean isVisibleInForm,
            List<BaseModel> baseRecords){

        super(title, 
              attributeName,
              type, 
              size,
              isRequired, 
              isVisibleInGrid,
              isVisibleInForm);

        this.baseRecords = baseRecords;

    }

    private MSFComboBox<BaseModel> getComboBoxStaticField(MSFComboBox<BaseModel> result) {
        if ( result==null ) {
            result = new MSFComboBox<BaseModel>();
            result.setWidth(300);
        }
        configureMSFField(result);
        return result;
    }

    private RadioGroup getRadioGroupStaticField(MSFRadioGroup result) {
        if ( result==null ) {
            result = new MSFRadioGroup(getIdHTML());
            //result.setWidth(300);
        }
        configureMSFField(result);
        return result;
    }

    public Field getVisibleField(Field result){
        if (!isRadio) { 
            result = getComboBoxStaticField((MSFComboBox)result);
        } else {
            result = getRadioGroupStaticField((MSFRadioGroup)result);
        }
        return result;
    }

    public Field getField(){
        Field result = getVisibleField();
        columnField = result;
        return result;
    }

    public void configureMSFField(Field field) {
        if ( field instanceof MSFComboBox ) {
            MSFComboBox<BaseModel> result = (MSFComboBox<BaseModel>) field;
            result.setColumnDef(this);
            result.setDisplayField(BaseRecordDef.DESCRIPTION);
            result.setValueField(BaseRecordDef.ID);
            result.setAttrNameDescription(BaseRecordDef.DESCRIPTION);
            result.setAttrNameId(BaseRecordDef.ID);
            ListStore<BaseModel> store = new ListStore<BaseModel>();  
            result.setFieldLabel(super.getTitle());  
            result.setItemId(getIdHTML());  
            result.setStore(store);
            result.setTypeAhead(true);  
            result.setTriggerAction(TriggerAction.ALL);  
            result.setEmptyText("Seleziona ...");
            result.setSelectOnFocus(true);  
            if (super.getIsRequired()) {
                result.setAllowBlank(false);
                ComboBox<BaseModel>.ComboBoxMessages messagesApp = result.new ComboBoxMessages();
                messagesApp.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
                result.setMessages(messagesApp);
            }
            if (isReadOnly()) {
                result.disable();
            }
            if (baseRecords != null) {
                store.add(baseRecords);
            }
        } else if ( field instanceof MSFRadioGroup ) {
            MSFRadioGroup result = (MSFRadioGroup) field;
            result.setColumnDef(this);
            result.setItemId(getIdHTML());
            result.setFieldLabel(super.getTitle());  
            //result.setFireChangeEventOnSetValue(false);
            if (baseRecords != null) {
                for (BaseModel b : baseRecords) {
                    Radio r = new Radio();
                    r.setBoxLabel(b.get(BaseRecordDef.DESCRIPTION).toString());
                    r.setValueAttribute(b.get(BaseRecordDef.ID).toString());
                    r.setFireChangeEventOnSetValue(false);
                    result.add(r);
                }
            }
        }
        Field result = field;
        if (triggers != null) {
            if (triggers.size() > 0) {
                for (final MSFTrigger trigger : triggers) {
                    if (trigger.getListener() != null && trigger.getEventType() != null) {
                        result.addListener(trigger.getEventType(), new Listener<BaseEvent>() {
                            public void handleEvent(BaseEvent be) {
                                Object o = be.getSource();
                                Field  f = null;
                                Object v = null;
                                if (o instanceof Field) {
                                    f = (Field)o;
                                    v = f.getValue();
                                }
                                trigger.getListener().initialize(f);
                                trigger.getListener().run(f, v);
                            }
                        });
                    }
                    
                }
            }
        }
    }


//    public Field getField(){
//        if (!isRadio) { 
//            ListStore<BaseModel> store = new ListStore<BaseModel>();  
//            cb = new MSFComboBox<BaseModel>(BaseRecordDef.ID, BaseRecordDef.DESCRIPTION){
//                @Override
//                protected void onRender(com.google.gwt.user.client.Element target, int index) {
//                    super.onRender(target, index);
//                    if (!getAllowBlank()) {
//                        setRequiredStyle(this);
//                    }
//                }
//            };  
//            cb.setFieldLabel(super.getTitle());  
//            cb.setItemId(getIdHTML());  
//            cb.setStore(store);
//            cb.setTypeAhead(true);  
//            cb.setTriggerAction(TriggerAction.ALL);  
//            cb.setEmptyText("Seleziona ...");
//            cb.setSelectOnFocus(true);  
//            cb.setWidth(300);
//            if (super.getIsRequired()) {
//                cb.setAllowBlank(false);
//                ComboBox<BaseModel>.ComboBoxMessages messagesApp = cb.new ComboBoxMessages();
//                messagesApp.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
//                cb.setMessages(messagesApp);
//            }
//            if (isReadOnly()) {
//                cb.disable();
//            }
//            if (baseRecords != null) {
//                store.add(baseRecords);
//            }
//            if (triggers != null) {
//                if (triggers.size() > 0) {
//                    for (final MSFTrigger trigger : triggers) {
//                        if (trigger.getListener() != null && trigger.getEventType() != null) {
//                            cb.addListener(trigger.getEventType(), new Listener<BaseEvent>() {
//                                public void handleEvent(BaseEvent be) {
//                                    Object o = be.getSource();
//                                    Field  f = null;
//                                    Object v = null;
//                                    if (o instanceof Field) {
//                                        f = (Field)o;
//                                        v = f.getValue();
//                                    }
//                                    trigger.getListener().initialize(f);
//                                    trigger.getListener().run(f, v);
//                                }
//                            });
//                        }
//                        
//                    }
//                }
//            }
//            return cb;
//        } else {
//            radioGroup = new RadioGroup(getIdHTML()){
//                private Radio lastValue = null;
//                @Override
//                public void setValue(Radio value) {
//                    Radio oldValue = lastValue;
//                    if (value != null) {
//                        lastValue = value;
//                        super.setValue(value);
//                    } else {
//                        if (oldValue != null) {
//                            oldValue.setValue(false);
//                        }
//                    }
//                    if (this.isFireChangeEventOnSetValue()) {
//                        fireChangeEvent(oldValue, value);
//                    }
//                }
//                @Override
//                protected void onRadioSelected(Radio radio) {
//                    Radio oldValue = lastValue;
//                    super.onRadioSelected(radio);
//                    fireChangeEvent(oldValue, radio);
//                }
//            };
//            radioGroup.setItemId(getIdHTML());
//            radioGroup.setFieldLabel(super.getTitle());  
//            //            radioGroup.setFireChangeEventOnSetValue(false);
//            if (baseRecords != null) {
//                for (BaseModel b : baseRecords) {
//                    Radio r = new Radio();
//                    r.setBoxLabel(b.get(BaseRecordDef.DESCRIPTION).toString());
//                    r.setValueAttribute(b.get(BaseRecordDef.ID).toString());
//                    r.setFireChangeEventOnSetValue(false);
//                    radioGroup.add(r);
//                }
//            }
//            if (triggers != null) {
//                if (triggers.size() > 0) {
//                    for (final MSFTrigger trigger : triggers) {
//                        if (trigger.getListener() != null && trigger.getEventType() != null) {
//                            radioGroup.addListener(trigger.getEventType(), new Listener<BaseEvent>() {
//                                public void handleEvent(BaseEvent be) {
//                                    Object o = be.getSource();
//                                    Field  f = null;
//                                    Object v = null;
//                                    if (o instanceof Field) {
//                                        f = (Field)o;
//                                        v = f.getValue();
//                                    }
//                                    trigger.getListener().initialize(f);
//                                    trigger.getListener().run(f, v);
//                                }
//                            });
//                        }
//                        
//                    }
//                }
//            }
//            return radioGroup;
//        }
//    }

    public boolean isRadio() {
        return isRadio;
    }

    public void setRadio(boolean isRadio) {
        this.isRadio = isRadio;
    }

    public RadioGroup getRadioGroup() {
        return (RadioGroup)columnField;
    }

    public ComboBox<BaseModel> getCb() {
        return (ComboBox<BaseModel>)columnField;
    }
    
    public Field getSearchField() {
        return getField();
    }

    public BaseModel getBaseModelByCode(Object codValue) {
        if (codValue != null) {
            for (BaseModel bm : baseRecords) {
                if (bm.get(BaseRecordDef.ID).equals(codValue)) {
                    return bm;
                }
            }
        }
        return null; 
    }
}