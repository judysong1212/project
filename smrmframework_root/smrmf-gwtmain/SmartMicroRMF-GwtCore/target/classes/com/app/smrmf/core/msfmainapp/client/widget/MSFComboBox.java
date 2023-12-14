/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;

public class MSFComboBox<D extends BaseModel> extends ComboBox<BaseModel> {

    protected El imgRefresh;
    protected long lastRefreshTime;
    protected ColumnDef columnDef;
    protected String attrNameId          = "combocode";
    protected String attrNameDescription = "comboname";

    public MSFComboBox() {
        super();
        setDisplayField(attrNameDescription);
        setValueField(attrNameId);
        this.setStore(new ListStore<BaseModel>());
    }

    public MSFComboBox(String attrNameId, String attrNameDescription) {
        this();
        setDisplayField(attrNameDescription);
        setValueField(attrNameId);
        this.attrNameId          = attrNameId;
        this.attrNameDescription = attrNameDescription;
    }

    @Override
    protected void onRender(com.google.gwt.user.client.Element target, int index) {
        super.onRender(target, index);
        GWTUtils.setCustomStyles(this);

        //Add a context menu to trigger a reload data on the list attached to the combo box
        Menu menu = new Menu();
        MenuItem itemReload = new MenuItem(MSFMainApp.MSFCONSTANTS.MenuReload());
        menu.add(itemReload);
        itemReload.addSelectionListener(new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                reloadData();
            }
        });
        this.setContextMenu(menu);
    }

    /**
     * Reloads data calling readData() on the bound ColumnListDef
     */
    public void reloadData() {
        ColumnDef columnDef = getColumnDef();
        if ( columnDef!=null && columnDef instanceof ColumnListDef ) {
            ((ColumnListDef)columnDef).readData();
        }
    }

    public ColumnDef getColumnDef() {
        return columnDef;
    }
    public void setColumnDef(ColumnDef columnDef) {
        this.columnDef = columnDef;
    }

    public String getAttrNameId() {
        return attrNameId;
    }
    public void setAttrNameId(String attrNameId) {
        this.attrNameId = attrNameId;
    }

    public String getAttrNameDescription() {
        return attrNameDescription;
    }
    public void setAttrNameDescription(String attrNameDescription) {
        this.attrNameDescription = attrNameDescription;
    }

}
