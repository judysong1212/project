/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.event.dom.client.ClickHandler;

public class IconButtonGrid extends MSFImage{
    private ActionDatabase actionDatabase;
    private BaseModel record;

    public IconButtonGrid(ActionDatabase actionDatabase) {
        super();
        this.actionDatabase = actionDatabase;
        switch (actionDatabase) {
        case INSERT: 
            setIcon(MSFMainApp.CUSTOM_ICONS.add());
            break;
        case UPDATE:
            setIcon(MSFMainApp.CUSTOM_ICONS.edit());
            break;
        case DELETE:
            setIcon(MSFMainApp.CUSTOM_ICONS.delete());
            break;
        case EXPORT:
            //          setIcon(MSFMainApp.ICONS.save());
            //          if (!isSmall) {
            //              setText(MSFMainApp.MSFCONSTANTS.BtSave());
            //          }
            break;
        }
    }

    public IconButtonGrid(ActionDatabase actionDatabase, ClickHandler handler) {
        this(actionDatabase);
        addClickHandler(handler);
    }

    public ActionDatabase getActionDatabase() {
        return actionDatabase;
    }

    public void showTooltip(boolean tooltip){
        switch (actionDatabase) {
        case INSERT:
            setToolTip(MSFMainApp.MSFCONSTANTS.BtNuovo());
            break;
        case UPDATE:
            setToolTip(MSFMainApp.MSFCONSTANTS.BtModification());
            break;
        case DELETE:
            setToolTip(MSFMainApp.MSFCONSTANTS.BtCancel());
            break;
        case EXPORT:
            //          setToolTip(MSFMainApp.MSFCONSTANTS.BtSave());
            break;
        }
    }

    public void setRecord(BaseModel record) {
        this.record = record;
    }

    public BaseModel getRecord() {
        return record;
    }

}
