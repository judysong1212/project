/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;

public class MSFTabItem extends TabItem {

    protected TableDef detailTableDef;
    protected MSFGridPanel detailGridPanel;

    public MSFTabItem(TableDef detailTableDef) {
        this(detailTableDef, true, true, true);
    }

    public MSFTabItem(TableDef detailTableDef, boolean seInsert, boolean seUpdate, boolean seDelete) {
        super(detailTableDef.getTitle());
        setLayout(new FillLayout()); 
        this.setDetailTableDef(detailTableDef);
        detailGridPanel = new MSFGridPanel(detailTableDef, seInsert, seUpdate, seDelete, false);
        detailGridPanel.setHeaderVisible(false);
        detailGridPanel.setBodyBorder(false);
        detailGridPanel.setBorders(false);
        add(detailGridPanel);
    }

    public void setDetailTableDef(TableDef detailTableDef) {
        this.detailTableDef = detailTableDef;
    }

    public TableDef getDetailTableDef() {
        return detailTableDef;
    }

    public MSFGridPanel getDetailGridPanel() {
        return detailGridPanel;
    }

    public void setDetailGridPanel(MSFGridPanel detailGridPanel) {
        this.detailGridPanel = detailGridPanel;
    }


}
