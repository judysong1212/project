/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.yearendtax.client;

import java.util.ArrayList;
import java.util.List;




import com.app.exterms.yearendtax.client.dto.yeta2017.Payr0485BM;
import com.app.exterms.yearendtax.client.dto.yeta2022.Payr0415BM;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161010BM;
import com.app.exterms.yearendtax.client.languages.YetaConstants;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye161005_2018_DAO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class LookupYeta7600YetaYr extends TableDef implements YetaDaoConstants{
     
	private static final String CLASS_PAYR0415_PAY_YR = "com.app.exterms.payroll.server.service.Payr1500ServiceImpl.getCboPayr0415PayYrList";
	public static final String CLASS_PAYR0415_DATA_LIST = "com.app.exterms.payroll.server.service.Payr1500ServiceImpl.getPayr0415DataList";//급여항목마스터_공무직
	
	private YetaConstants lblYetaConst = YetaConstants.INSTANCE; 
    
    public LookupYeta7600YetaYr(){
    	setTitle(lblYetaConst.title_Yeta7600YetaYr());
    	setDaoClass("");
    	setCustomListMethod(CLASS_PAYR0415_PAY_YR); 
    	 
    	   
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        listColumnDefs.add(new ColumnDef("급여년도", Payr0415BM.ATTR_PAYYR ,   ColumnDef.TYPE_STRING, 150,  false, true, true));
        listColumnDefs.add(new ColumnDef("년도",    Payr0415BM.ATTR_PAYYRDISP  , ColumnDef.TYPE_STRING, 150, false, true, true){{
          
        }});
       // 
        setColumnsDefinition(listColumnDefs);

    }

    public LookupYeta7600YetaYr(String title, Class<?> pojoClass) {
        this();
        setTitle(title);
        setDaoClass(pojoClass);
    }
}
