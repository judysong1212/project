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

import com.app.exterms.payroll.client.dto.Payr0420BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class LookupPayr0420OccuClssPayStd extends TableDef implements PayrDaoConstants {
     
    private PayrConstants payYrLabel = PayrConstants.INSTANCE;
    
    public LookupPayr0420OccuClssPayStd(){
    	setTitle(payYrLabel.titlePayr0420());
    	setDaoClass("");
    	setCustomListMethod(CLASS_PAYR0420_OCCU_CLSS_PAY_STD); 
    	 
    	   
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        listColumnDefs.add(new ColumnDef("산정일자", Payr0420BM.ATTR_OCCUCLSSPAYCMPTTNSTD ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
        listColumnDefs.add(new ColumnDef("산정일자",    Payr0420BM.ATTR_OCCUCLSSPAYCMPTTNSTDDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
          
        }});
       // 
        setColumnsDefinition(listColumnDefs);

    }

    public LookupPayr0420OccuClssPayStd(String title, Class<?> pojoClass) {
        this();
        setTitle(title);
        setDaoClass(pojoClass);
    }
}
