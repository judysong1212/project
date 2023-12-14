/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.math.BigDecimal;

import com.extjs.gxt.ui.client.widget.form.NumberPropertyEditor;
import com.google.gwt.i18n.client.NumberFormat;

public class MSFNumberPropertyEditor extends NumberPropertyEditor{

    public MSFNumberPropertyEditor(NumberFormat format) {
        super(format);
    }

    @Override
    public Number convertStringValue(String value) {
        if (type == Double.class) {
            Double d = format.parse(value);
            return d;
        } else if (type == BigDecimal.class) {
            return new BigDecimal(value);
        }  else { 
            return super.convertStringValue(value);
        }
          
    }
}
