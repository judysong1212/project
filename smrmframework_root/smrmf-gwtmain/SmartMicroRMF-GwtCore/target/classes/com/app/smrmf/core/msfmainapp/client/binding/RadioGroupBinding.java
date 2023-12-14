/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.binding;

import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;

/**
 * <p>FieldBinding is broken for RadioGroup fields. This fixes it.</p>
 *
 * <p>The bug is that RadioGroup's value is a Radio type, but all
 * models will have a String type. This converts between the two.
 * Really, RadioGroup's value should be a String type, associated
 * with the valueAttribute property.</p>
 */
public class RadioGroupBinding extends FieldBinding
{
    /** */
    public RadioGroupBinding(RadioGroup group, String property)
    {
        super(group, property);
    }

    /** Auto-ish binding; model property name is assumed same as group name */
    public RadioGroupBinding(RadioGroup group)
    {
        // This hoop is necessary because the RadioGroup doesn't set its Name property
        this(group, group.get(0).getName());
    }

    /** Takes the radio and turns it into a string, easy */
    @Override
    protected Object onConvertFieldValue(Object value)
    {
        return value==null?null:super.onConvertFieldValue(((Radio) value).getValueAttribute());
    }

    /** Takes the string and looks up the radio with the appropriate value attribute */
    @Override
    @SuppressWarnings("unchecked")
    protected Object onConvertModelValue(Object value)
    {
        for (Field rad: ((RadioGroup)this.field).getAll()) {
            if (value instanceof Long) {
                Long v2 = (Long) value;
                Long v1 = Long.valueOf(((Radio)rad).getValueAttribute());
                if (v1 != null && v2 != null & v1.compareTo(v2) == 0) {
                    return super.onConvertModelValue(rad);
                }
            } else if (value instanceof String) {
                if (((Radio)rad).getValueAttribute().equals(value)) {
                    return super.onConvertModelValue(rad);
                }
            } else {
                return null;
            }
        }
        return null;
    }
}