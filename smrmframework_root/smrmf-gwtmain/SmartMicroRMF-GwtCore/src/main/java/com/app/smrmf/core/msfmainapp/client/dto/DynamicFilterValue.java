/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class DynamicFilterValue extends BaseModel {

    private static final long serialVersionUID = 1L;

    public static final int SIMPLE_FIELD = 1;
    public static final int COMBO_FIELD  = 2;

    public static final String ATTR_ATTRIBUTE_TYPE      = "attribute_type";
    public static final String ATTR_ATTRIBUTE_NAME      = "attribute_name";
    public static final String ATTR_ATTRIBUTE_SUB_NAME  = "attribute_sub_name";
    public static final String ATTR_VALUE               = "value";

    public DynamicFilterValue() {
        super();
    }

    public DynamicFilterValue(
            int attributeType,
            String attributeName,
            String attributeSubName
            ) {
        super();
        setAttributeType(attributeType);
        setAttributeName(attributeName);
        setAttributeSubName(attributeSubName);
    }

    public int getAttributeType() {
        return Integer.parseInt(get(ATTR_ATTRIBUTE_TYPE).toString());
    }
    public void setAttributeType(int attributeType) {
        set(ATTR_ATTRIBUTE_TYPE, attributeType);
    }

    public String getAttributeName() {
        return get(ATTR_ATTRIBUTE_NAME);
    }
    public void setAttributeName(String attributeName) {
        set(ATTR_ATTRIBUTE_NAME, attributeName);
    }

    public String getAttributeSubName() {
        return get(ATTR_ATTRIBUTE_SUB_NAME);
    }
    public void setAttributeSubName(String attributeSubName) {
        set(ATTR_ATTRIBUTE_SUB_NAME, attributeSubName);
    }

    public Serializable getValue() {
        return get(ATTR_VALUE);
    }
    public void setValue(Serializable value) {
        set(ATTR_VALUE, value);
    }

}
