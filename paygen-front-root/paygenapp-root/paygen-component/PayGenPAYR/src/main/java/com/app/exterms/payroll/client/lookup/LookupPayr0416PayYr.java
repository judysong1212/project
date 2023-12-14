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

import com.app.exterms.payroll.client.dto.Payr0416BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class LookupPayr0416PayYr extends TableDef implements PayrDaoConstants {
     
    private PayrConstants payYrLabel = PayrConstants.INSTANCE;
    
    public LookupPayr0416PayYr(){
    	setTitle(payYrLabel.title_Payr0415PayYr());
    	setDaoClass("");
    	setCustomListMethod(CLASS_PAYR0416_PAY_YR); 
    	 
    	   
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        listColumnDefs.add(new ColumnDef("급여년도", Payr0416BM.ATTR_PAYYR ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
        listColumnDefs.add(new ColumnDef("년도",    Payr0416BM.ATTR_PAYYRDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
          
        }});
       // 
        setColumnsDefinition(listColumnDefs);

    }

    public LookupPayr0416PayYr(String title, Class<?> pojoClass) {
        this();
        setTitle(title);
        setDaoClass(pojoClass);
    }
}
