/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

public class PrintFilterDef extends TableDef {
    private String reportRDAFile;

    public PrintFilterDef(){
        super();
    }

    public void setReportRDAFile(String reportRDAFile) {
        this.reportRDAFile = reportRDAFile;
    }

    public String getReportRDAFile() {
        return reportRDAFile;
    }
}
