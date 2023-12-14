/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.binding;

import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;

import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.data.BaseModel;

public class BaseRecordBinding extends FieldBinding {

    protected MSFComboBox<BaseModel> combo;


    /**
     * Creates a new BaseRecord combo binding
     * 
     * @param field the combo box
     * @param property the property name
     */
    public BaseRecordBinding(MSFComboBox<BaseModel> field, String property) {
        super(field, property);
        this.combo = field;
    }

    //
    @Override
    protected Object onConvertFieldValue(Object value) {
        if (value == null) {
            return null;
        }
        return combo.getValue().get(combo.getAttrNameId());
    }

    @Override
    protected Object onConvertModelValue(Object value) {
        if (value == null) {
            return null;
        }
        //        String name = (String)value;
        return combo.getStore().findModel(combo.getAttrNameId(), value);
    }
}
