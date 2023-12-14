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

import com.app.exterms.payroll.client.dto.Payr0360BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class LookupReattyStpDsptyNum extends TableDef implements PayrDaoConstants {
     
    private PayrConstants payYrLabel = PayrConstants.INSTANCE;
    
    public LookupReattyStpDsptyNum(){
    	setTitle("");
    	setDaoClass("");
    	setCustomListMethod(CLASS_PAYR0360_REATTY_STP_DSPTY_NUM); 
    	
    	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
          listColumnDefs.add(new ColumnDef("회차코드", Payr0360BM.ATTR_REATTYSTPDSPTYNUM ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
          listColumnDefs.add(new ColumnDef("회차",    Payr0360BM.ATTR_REATTYSTPDSPTYNUMDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
            
          }});
          
        setColumnsDefinition(listColumnDefs);

    }

    public LookupReattyStpDsptyNum(String title, Class<?> pojoClass) {
        this();
        setTitle(title);
        setDaoClass(pojoClass);
    }
}
