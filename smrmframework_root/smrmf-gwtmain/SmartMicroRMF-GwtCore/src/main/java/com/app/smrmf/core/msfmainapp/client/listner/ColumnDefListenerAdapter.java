/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.listner;

import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;

import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.widget.form.Field;

/**
 * This class implements the <i>ColumnDefListener</i> and adds some public methods 
 * to get or set value of field by attribute name. You can use this to implement a
 * trigger on columnDef to make a validation or other between field's form.
 * 
 * @author Carlo
 *
 */
public class ColumnDefListenerAdapter implements ColumnDefListener {

    private Field field;
    private FormBinding formBinding;
    private BaseModel baseModel;
    private boolean isInitialized = false;

    /**
     * Initializes the listener with trigger field, formBinding read from data stored into field 
     * and baseModel. If all is not null, put the isInitialized attribute equal true
     */
    public void initialize(Field field) {
        this.field = field;
        this.isInitialized  = findFormBinding() && findBaseModel();
    }
    
    /**
     * This is the method to override
     */
    public void run(Field field, Object valueField) {
    }
    
    /**
     * Finds the formBinding from data stored into field
     * @return true if formBinding's found 
     */
    private boolean findFormBinding(){
        this.formBinding = null;
        Object objFormBinding = field.getData(MSFConfiguration.PROP_FORM_BINDING);
        if (objFormBinding instanceof FormBinding) {
            this.formBinding = (FormBinding)objFormBinding;
            if (this.formBinding != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the baseModel inside the formBinding
     * @return true if baseModel's found 
     */
    private boolean findBaseModel(){
        this.baseModel = null;
        if (this.formBinding != null) {
            this.baseModel = (BaseModel) this.formBinding.getModel();
            if (this.baseModel != null) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the trigger field
     * @return the trigger field
     */
    public Field getField() {
        return field;
    }

    /**
     * Gets the attribute formBinding
     * @return the formBinding object
     */
    public FormBinding getFormBinding() {
        return formBinding;
    }

    /**
     * Returns the value of field by attribute name 
     * @param attributeName The attribute name of the column 
     * @return A generic object (String, Date, Long, Double, Boolean)
     */
    public Object getValueByAttributeName(String attributeName) {
        String attrName = GWTUtils.adjustsColumnDefName(attributeName);
        for (FieldBinding fieldBinding : this.formBinding.getBindings()) {
            if (fieldBinding.getProperty().equals(attrName)) {
                Field f = fieldBinding.getField();
                if (f != null) {
                    return f.getValue();
                }
            }
        }
        return null;
    }
    
    /**
     * Sets the value of the field with the name equal to attributeName 
     * @param value         the value to be set
     * @param attributeName the name of the field
     */
    public void setValueByAttributeName(Object value, String attributeName) {
        String attrName = GWTUtils.adjustsColumnDefName(attributeName);
        if (this.baseModel != null) {
            this.baseModel.set(attrName, value);
        } else {
            for (FieldBinding fieldBinding : this.formBinding.getBindings()) {
                if (fieldBinding.getProperty().equals(attrName)) {
                    Field f = fieldBinding.getField();
                    if (f != null) {
                        f.setValue(value);
                    }
                }
            }
        }
    }
    
    /**
     * Finds the field with the name equal to attributeName
     * @param attributeName Name of the field, it's the same of columnDef attribute
     * @return the field found
     */
    public Field findFieldByAttributeName(String attributeName) {
        String attrName = GWTUtils.adjustsColumnDefName(attributeName);
        if (this.formBinding != null) {
            for (FieldBinding fieldBinding : this.formBinding.getBindings()) {
                if (fieldBinding.getProperty().equals(attrName)) {
                    return fieldBinding.getField();
                }
            }
        }
        return null;
    }
    
}
