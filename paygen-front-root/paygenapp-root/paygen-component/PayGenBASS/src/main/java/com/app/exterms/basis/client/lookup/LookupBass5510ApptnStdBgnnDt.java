/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass5510BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class LookupBass5510ApptnStdBgnnDt extends TableDef implements BasisDaoConstants {
     
    private BasisConstants payYrLabel = BasisConstants.INSTANCE;
    
    public LookupBass5510ApptnStdBgnnDt(){
    	setTitle(payYrLabel.titleBass5510());
    	setDaoClass("");
    	setCustomListMethod(CLASS_BASS5510_APPTN_STD_BGNN_DT); 
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("적용년도", Bass5510BM.ATTR_APPTNYR ,   ColumnDef.TYPE_STRING, 150,  false, false, false));
        /** set 적용기준시작일자 : apptnStdBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Bass5510BM.ATTR_APPTNSTDBGNNDT ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
        listColumnDefs.add(new ColumnDef("기준일자",   Bass5510BM.ATTR_APPTNSTDBGNNDTDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
          
        }});
       // 
        setColumnsDefinition(listColumnDefs);
        
    }

//    public LookupBass5510ApptnYr(String title, Class<?> pojoClass) {
//        this();
//        setTitle(title);
//        setDaoClass(pojoClass);
//    }
}

