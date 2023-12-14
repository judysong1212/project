/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.payroll.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0100BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class LookupPayr0100ApptnStdBgnnDt extends TableDef implements PayrDaoConstants {
     
    private PayrConstants payYrLabel = PayrConstants.INSTANCE;
    
    public LookupPayr0100ApptnStdBgnnDt(){
    	setTitle(payYrLabel.titlePayr0100());
    	setDaoClass("");
    	setCustomListMethod(CLASS_PAYR0100_APPTN_STD_BGNN_DT); 
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("적용년도", Payr0100BM.ATTR_APPTNYR ,   ColumnDef.TYPE_STRING, 150,  false, false, false));
        /** set 적용기준시작일자 : apptnStdBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0100BM.ATTR_APPTNSTDBGNNDT ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
        listColumnDefs.add(new ColumnDef("기준일자",   Payr0100BM.ATTR_APPTNSTDBGNNDTDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
          
        }});
       // 
        setColumnsDefinition(listColumnDefs);
        
    }

//    public LookupPayr0100ApptnYr(String title, Class<?> pojoClass) {
//        this();
//        setTitle(title);
//        setDaoClass(pojoClass);
//    }
}

