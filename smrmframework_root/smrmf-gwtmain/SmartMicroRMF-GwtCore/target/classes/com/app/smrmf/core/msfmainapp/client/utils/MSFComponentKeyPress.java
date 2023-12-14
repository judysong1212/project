/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.i18n.client.LocaleInfo;



public class MSFComponentKeyPress extends KeyListener {

    public MSFComponentKeyPress(){
    }


    @SuppressWarnings("rawtypes")
    public void componentKeyPress(ComponentEvent event) {
        char ch = (char) event.getKeyCode();
        final StringBuilder sb = new StringBuilder();
        final Field field = (Field) event.getSource();
        int lungNumero = 0;
        int posCur  = ((TextField)field).getCursorPos();
        boolean isInsert = (((TextField)field).getSelectionLength()==0?true:false); 
       
        if (field instanceof NumberField){
            // Per i campi numerici individua quanti delimitatori  presenti   
            String gs=LocaleInfo.getCurrentLocale().getNumberConstants().groupingSeparator();
            String ds=LocaleInfo.getCurrentLocale().getNumberConstants().decimalSeparator();
            String dato = String.valueOf(((NumberField)field).getRawValue());
            //lungNumero = dat1.length() - dat1.replace(ds,"").length() - dat1.replace(gs,"").length();
            String datNoSeparators = dato.replace(ds,"").replace(gs,"");
            lungNumero = dato.length() - datNoSeparators.length() ;
        }
        sb.append(String.valueOf(((TextField)field).getRawValue()));
        if (isInsert) {
            sb.insert(posCur, String.valueOf(ch));
        }
        String aux = sb.toString();
        if (event.isShiftKey() || (! event.isSpecialKey() && ! event.isNavKeyPress())){ 
            if ( (aux.length() - lungNumero) >((TextField)field).getMaxLength()) {
                event.stopEvent();
                return;
            }
            if (field instanceof NumberField){
                char ds=LocaleInfo.getCurrentLocale().getNumberConstants().decimalSeparator().charAt(0);

                //                if (((PNumberField) field).getMaxNumberCharactersAfterDecimalSeparator() != null) {   
                Integer maxNumberDecimalCharacters = ((MSFNumberField)field).getMaxDecimals();
                Integer maxNumberIntergerCharacters = ((MSFNumberField)field).getMaxLength() - maxNumberDecimalCharacters; 
                if (maxNumberDecimalCharacters == 0) {
                    if( ch == ds) {
                        event.stopEvent();
                    }
                } else if (maxNumberDecimalCharacters > 0) {

                    if (aux != null && !aux.equals("")) {

                        if (aux.contains("..")) {
                            event.stopEvent();
                            return;
                        }
                        final String[] vector = aux.split("\\"+ds);
                        if (vector.length > 2  && ch == ds) {
                            event.stopEvent();
                            return;
                        }
                        if (vector.length > 1) {
                            // Controllo il numero massimo di interi
                            final String intergerCharacters = vector[0];
                            if (intergerCharacters.length() > maxNumberIntergerCharacters) {
                                event.stopEvent();
                            }

                            // Controllo il numero massimo di decimali
                            final String decimal = vector[1];
                            if (decimal.length() > maxNumberDecimalCharacters) {
                                event.stopEvent();
                            }
                        }
                    }
                }
            }
            //            }
        }  
    }


}
