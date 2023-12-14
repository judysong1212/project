/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class MSFSimpleForm extends MSFFormPanel {

    public TableDef getTableDef() {
        return tableDef;
    }

    public void setTableDef(TableDef tableDef) {
        this.tableDef = tableDef;
    }

    private FieldSet fieldSet;

    public MSFSimpleForm(
            ActionDatabase actionDatabase, 
            TableDef tableDef) {
        super();
        setBodyBorder(false);
        setBorders(false);
        setHeaderVisible(false);
        setAutoHeight(true);

        final FormData formData = new FormData("0");
        this.tableDef = tableDef;
        this.fieldSet = tableDef.getFieldSet();
        
        this.actionDatabase = actionDatabase;
        this.customLayoutContainer = tableDef.getCustomLayoutContainer();
        this.width = tableDef.getWidth();
        setWidth(this.width);

        List<ColumnDef> listaColonne = tableDef.getColumnsDefinition();

        if (customLayoutContainer == null){

            add(this.fieldSet);
            setFormBinding(tableDef.getFormBinding(this, this.fieldSet));

        } else {

            setCustomLayout(listaColonne, "");

        }

    }

    //    private void populateListItem() {
    //        ColumnListDef cdef = null;
    //        Iterator<ColumnDef> iter = tableDef.getColumnsDefinition().iterator();
    //        while (iter.hasNext()) {
    //            ColumnDef columnDef = (ColumnDef) iter.next();
    //            if (columnDef instanceof ColumnListDef){
    //                cdef = (ColumnListDef)columnDef;
    //                ((ComboBox)cdef.getCb()).mask();
    //                readData(cdef);
    //            }
    //        }
    //    }

    @Override
    public void onSuccessSave() {
    }

    public boolean isValid(){
        boolean result = true;
        Iterator<Component> componenti = fieldSet.getItems().iterator();
        while (componenti.hasNext()) {
            Component comp = (Component) componenti.next();
            if (comp instanceof TextField){
                if (!((TextField)comp).isValid()) {
                    result = false;
                }
            } else if (comp instanceof DateField){
                if (!((DateField)comp).isValid()) {
                    result = false;
                }
            } else if (comp instanceof NumberField){
                if (!((NumberField)comp).isValid()) {
                    result = false;
                }
            } else if (comp instanceof ComboBox){
                if (!((ComboBox)comp).isValid()) {
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    protected void onFailureSave() {
        super.onFailureSave();
    }

//    @Override
//    protected void setCustomLayout(List<ColumnDef> listaColonne, String labelSeparator) {
//
//        setFormBinding(new FormBinding(this));
//        final FormData formData = new FormData("0");
//
//        //Ciclo sui fields della TableDef e cerco nel CustomFormPanel un field con lo stesso ID per farci sopra il binding
//        for (ColumnDef columnDef : listaColonne) {
//            Field cf = columnDef.getField();
//            final int maxLight = columnDef.getMaxLength();
//            String labelText = columnDef.getTitle();
//            String labelFieldText = MSFSharedUtils.paramNotNull(labelText) ? labelText+labelSeparator : "";
//            // Leggo sia il campo itemId  
//            String itemId = cf.getItemId();
//            List<Component> listaField =  (List<Component>) GWTUtils.findChildrenComponentsByItemId(customLayoutContainer, itemId);
//            for (Component field : listaField){
//
//                if (field!=null && (field instanceof LabelField)) {
//                    ((Field)field).setValue(labelFieldText);    
//                } else if ( field!=null && (field instanceof Field || field instanceof SysComboBox<?>) ) {
//                    FieldBinding fieldBinding = null;
//                    if (field instanceof RadioGroup) {
//                        fieldBinding = new RadioGroupBinding((RadioGroup) field, itemId); //columnDef.getAttributeName()
//                    } else if (field instanceof SysComboBox<?>){
//                        fieldBinding = new BaseRecordBinding((SysComboBox) field, itemId);
//                    } else  {
//                        fieldBinding = new FieldBinding((Field)field, itemId);
//                    }
//
//                    ((Field)field).setFieldLabel(labelFieldText);
//                    fieldBinding.setUpdateOriginalValue(true);
//                    getFormBinding().addFieldBinding(fieldBinding);
//                    // to add the formBinding object to field, to use on client trigger 
//                    field.setData(MSFConfiguration.PROP_FORM_BINDING, getFormBinding());
//                    field.setData(MSFConfiguration.PROP_FORM_PARENT,  this);                        
//                    if (field instanceof LovField){
//                        ((LovField)field).setLov(columnDef.getLov());
//                        ((LovField)field).setParentColumnDef(columnDef);
//                    }
//                    field.addListener(Events.Change, new Listener<BaseEvent>() {
//                        public void handleEvent(BaseEvent be) {
//                            if (be.getSource() instanceof Field) {
//                                Field f = (Field) be.getSource();
//                                setDirtyField(f);
//                            }
//                        }
//                    });
//                    add(customLayoutContainer, formData);
//
//                }
//
//            }
//        }
//    
//    }

}
