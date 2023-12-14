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
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;

public class ButtonGrid extends Button{
    //    public static String INSERT = "INSERT";
    //    public static String UPDATE = "UPDATE";
    //    public static String DELETE = "DELETE";
    //    public static String EXPORT = "EXPORT";
    private boolean isSmall;
    private ActionDatabase actionDatabase;
    private BaseModel record;

    public ButtonGrid(ActionDatabase actionDatabase, boolean isSmall) {
        super();
        this.actionDatabase = actionDatabase;
        this.setSmall(isSmall);
        switch (actionDatabase) {
        case INSERT: 
            setIcon(MSFMainApp.ICONS.add());
            if (!isSmall) {
                setText(MSFMainApp.MSFCONSTANTS.BtNuovo());
            }
            break;
        case UPDATE:
            setIcon(MSFMainApp.ICONS.edit());
            if (!isSmall) {
                setText(MSFMainApp.MSFCONSTANTS.BtModification());
            }
            break;
        case DELETE:
            setIcon(MSFMainApp.ICONS.delete());
            if (!isSmall) {
                setText(MSFMainApp.MSFCONSTANTS.BtCancel());
            }
            break;
        case EXPORT:
            //          setIcon(MSFMainApp.ICONS.save());
            //          if (!isSmall) {
            //              setText(MSFMainApp.MSFCONSTANTS.BtSave());
            //          }
            break;
        }
    }

    public ButtonGrid(ActionDatabase actionDatabase, boolean isSmall, SelectionListener<ButtonEvent> listener) {
        this(actionDatabase, isSmall);
        addSelectionListener(listener);
    }

    public ButtonGrid(ActionDatabase actionDatabase, SelectionListener<ButtonEvent> listener) {
        this(actionDatabase, false);
        addSelectionListener(listener);
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

    public void setSmall(boolean isSmall) {
        this.isSmall = isSmall;
        if (isSmall) {
            setText(null);
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
            }
        } else {
            removeToolTip();
            switch (actionDatabase) {
            case INSERT: 
                setText(MSFMainApp.MSFCONSTANTS.BtNuovo());
                break;
            case UPDATE:
                setText(MSFMainApp.MSFCONSTANTS.BtModification());
                break;
            case DELETE:
                setText(MSFMainApp.MSFCONSTANTS.BtCancel());
                break;
            }

        }
    }

    public boolean isSmall() {
        return isSmall;
    }
}
