/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.constants.Constants;

import com.extjs.gxt.ui.client.data.BaseModel;

public class TrueFalseNullStaticDef extends ColumnListStaticDef {

    // VALORI PER COMBO Vero/Falso/Tutti
    public static final BaseRecordDef TRUE_FALSE_NULL = new BaseRecordDef() {{
        add(Constants.ALL_VALUE,    MSFMainApp.MSFCONSTANTS.LblAll());
        add(Constants.TRUE_VALUE,   MSFMainApp.MSFCONSTANTS.LblTrue());
        add(Constants.FALSE_VALUE,  MSFMainApp.MSFCONSTANTS.LblFalse());
    }};

    public TrueFalseNullStaticDef(
            String title, 
            String attributeName, 
            int type, 
            int size,
            Boolean isRequired, 
            Boolean isVisibleInGrid,
            Boolean isVisibleInForm){

        super(title, 
              attributeName,
              type, 
              size,
              isRequired, 
              isVisibleInGrid,
              isVisibleInForm,
              TRUE_FALSE_NULL.getList());

    }

    public static final BaseModel getBaseModelByCode(String codValue) {
        if (codValue != null && codValue.length() > 0) {
            for (BaseModel bm : TRUE_FALSE_NULL.getList()) {
                if (bm.get(BaseRecordDef.ID).equals(codValue)) {
                    return bm;
                }
            }
        }
        return null; 
    }

}
