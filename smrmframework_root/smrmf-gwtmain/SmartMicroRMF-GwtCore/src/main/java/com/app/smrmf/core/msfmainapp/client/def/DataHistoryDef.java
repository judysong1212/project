/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;

public class DataHistoryDef extends TableDef {

    protected List<ColumnDef> listColumnDefs;

    public DataHistoryDef() {
        super();
        setTitle(MSFMainApp.MSFCONSTANTS.TitleDataHistory());
        setAutoFillGrid(true);

        this.customListMethod = MSFConfiguration.CUSTOM_SERVICE_DATA_HISTORY_LIST;

        listColumnDefs = new ArrayList<ColumnDef>();
        listColumnDefs.add(new ColumnDef(MSFMainApp.MSFCONSTANTS.LblHistoryDate(),      "datetime",        ColumnDef.TYPE_DATETIME,  130, false, true,  false){{
            //setFormatDate(DateTimeFormat.getFormat("dd.MM.yyyy HH:mm:ss"));
        }});
        listColumnDefs.add(new ColumnDef(MSFMainApp.MSFCONSTANTS.LblHistoryUser(),      "user.username",   ColumnDef.TYPE_STRING,  70, false, true,  false));
        listColumnDefs.add(new ColumnDef(MSFMainApp.MSFCONSTANTS.LblHistoryOperation(), "activityOnDb",    ColumnDef.TYPE_DATE,    70, false, true,  false));
        //listColumnDefs.add(new ColumnDef("Id",            "primaryKey",      ColumnDef.TYPE_STRING, 130, false, true,  false));
        setColumnsDefinition(listColumnDefs);

        setReadOnly(true);
    }

}
