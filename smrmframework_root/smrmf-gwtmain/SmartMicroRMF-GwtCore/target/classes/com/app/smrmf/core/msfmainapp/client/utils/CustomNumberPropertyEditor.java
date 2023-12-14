package com.app.smrmf.core.msfmainapp.client.utils;
 
import java.math.BigDecimal;

import com.extjs.gxt.ui.client.widget.form.NumberPropertyEditor;

public class CustomNumberPropertyEditor extends NumberPropertyEditor {

    public CustomNumberPropertyEditor(Class<?> type) {
        super(type);
    }

    @Override
    public Number convertStringValue(String value) {
        try {
            if (type == BigDecimal.class) {
                return new BigDecimal(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.convertStringValue(value);
    }    
}