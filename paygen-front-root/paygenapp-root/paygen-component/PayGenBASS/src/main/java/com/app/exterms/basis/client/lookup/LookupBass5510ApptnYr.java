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

public class LookupBass5510ApptnYr extends TableDef implements BasisDaoConstants {
     
    private BasisConstants label = BasisConstants.INSTANCE;
    
    public LookupBass5510ApptnYr(){
    	setTitle(label.title_Bass0440BassYr());
    	setDaoClass(CLASS_BASS5510_APPTN_YR);
    	setCustomListMethod(CLASS_BASS5510_APPTN_YR); 
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        listColumnDefs.add(new ColumnDef("적용년도", Bass5510BM.ATTR_APPTNYR ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
        listColumnDefs.add(new ColumnDef("년도",   Bass5510BM.ATTR_APPTNYRDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
          
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
