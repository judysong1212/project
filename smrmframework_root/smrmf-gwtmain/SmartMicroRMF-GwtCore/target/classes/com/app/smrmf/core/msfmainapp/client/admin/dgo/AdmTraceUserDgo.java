/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dgo;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.google.gwt.i18n.client.DateTimeFormat;

public class AdmTraceUserDgo extends TableDef implements MSFDaoConstants {

    public AdmTraceUserDgo(){
    	setTitle("Trace User");
        setDaoClass(CLASS_AdmTraceUser);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("Id", "id", ColumnDef.TYPE_LONG, 10, false, false, false));
        listColumnDefs.add(new ColumnDef("User", "u", ColumnDef.TYPE_STRING, 200, false, true, false){
            {
                setAttributeFormula("(admUser.cognome || ' ' || admUser.nome)");
            }
        });
        listColumnDefs.add(new ColumnDef("Date time", "datetime", ColumnDef.TYPE_STRING, 150, false, true, false){
            {
                setFormatDate(DateTimeFormat.getFullDateTimeFormat());
                setSortPosDir(1, SortDir.DESC);
            }
        });
        listColumnDefs.add(new ColumnDef("Method Executed", "methodExecuted", ColumnDef.TYPE_STRING, 200, false, true, false));
        listColumnDefs.add(new ColumnDef("Dao Used", "daoUsed", ColumnDef.TYPE_STRING, 200, false, true, false));
        listColumnDefs.add(new ColumnDef("Activity On Db", "activityOnDb", ColumnDef.TYPE_STRING, 100, false, true, false));
        listColumnDefs.add(new ColumnDef("DB Session", "dbSession", ColumnDef.TYPE_STRING, 100, false, true, false));
        listColumnDefs.add(new ColumnDef("WS Sesssion", "wsSesssion", ColumnDef.TYPE_STRING, 100, false, true, false));

        setColumnsDefinition(listColumnDefs);
        setReadOnly(true);
    }

}
