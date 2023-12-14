/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import com.extjs.gxt.ui.client.data.ModelData;

public interface MSFLiveGridSelectionModel<M extends ModelData> {

    /**
     * 
     * @return returns true if first model in currently displayed list of models is selected on next reload
     */
    public boolean isSelectRowOnNextLoad();

    /**
     * Use this method if you want to select the model row having a specified Id
     * 
     * @param currentlySelectedItemId
     */
    public void setCurrentlySelectedItemId(Object currentlySelectedItemId);

    /**
     * Use this method if you want to select the model "row" on next reload (defaults to not select the row)
     * 
     * @param selectRowOnNextLoad
     */
    public void setSelectRowOnNextLoad(int rowNum);

    public int getSelectRowOnNextLoad();

    /**
     * The selection list is automatically cleared when models are removed from
     * the display store (e.g. when you scroll up or down). We need to change this
     * behavior so that selections are remembered, even if store changes content.
     * Therefore the methods refresh() and onClear() are overridden to do nothing.
     * 
     * Use this method instead to clear selected items.
     */
    public void clearSelected();

}