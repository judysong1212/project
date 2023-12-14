/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import com.app.smrmf.core.msfmainapp.client.def.TableDef;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * The default GridSelectionModel doesn't work with LiveGrid. This class together with
 * LiveGridViewExtended supports the following features:
 * 
 * - Selection of ModelData (Single or Multi)
 * - Scroll up and down with arrow keys
 * - Select first item on reload
 * - Add a check-box as first column to mark selected table rows
 * 
 * For this class to work, it is VERY important that you override the equals()
 * method of your model data. If you select an item and scroll down and up again (so that
 * the cache is reloaded) you will not have the same instance of your model data in the 
 * selection list and in the ListStore. Therefore we need some intelligent way of comparing
 * models.
 * 
 * @author bh
 *
 * @param <M>
 */
public class LiveGridCheckBoxSelectionModel<M extends ModelData> extends CheckBoxSelectionModel<ModelData> implements MSFLiveGridSelectionModel<M> {

    private LiveGridViewExtended gridView;
    private int selectRowOnNextLoad = -1;
    private Object currentlySelectedItemId;

    public LiveGridCheckBoxSelectionModel(LiveGridViewExtended view) {
        this.gridView = view;
        view.addListener(LiveGridViewExtended.StoreSet, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {

                // LiveGridView uses two ListStore's. One contains just the models that are currently
                // displayed on the screen, and the other is a cache store that contains more
                // models (e.g. 200 at default).
                // As default the GridSelection model uses the cache store, which results in wrong
                // selection of items. Therefore we need to use only the display store in the
                // selection model.
                listStore = gridView.getDisplayStore();
                store = gridView.getDisplayStore();
                store.addStoreListener(new StoreListener<ModelData>() {
                    @Override
                    public void storeAdd(StoreEvent<ModelData> se) {
                        super.storeAdd(se);
                        gridView.refreshSelection();

                        // This is just a handy feature, to select the first item on next reload.
                        if (selectRowOnNextLoad >= 0 ) {
                            final int row=selectRowOnNextLoad;
                            selectRowOnNextLoad = -1;
                            DeferredCommand.addCommand(new Command() {
                                public void execute() {
                                    select(row, false);
                                }
                            });
                        }

                        //This to select the row that was previously selected
                        if ( currentlySelectedItemId!=null ) {
                            final ModelData item = store.findModel(TableDef.ID_PROPERTY_NAME, currentlySelectedItemId);
                            if ( item != null ) {
                                DeferredCommand.addCommand(new Command() {
                                    public void execute() {
                                        select(item, false);
                                    }
                                });
                            }
                        }

                    }
                });
            }
        });
    }

    /* (non-Javadoc)
     * @see com.app.smrmf.core.msfmainapp.client.generics.MSFLiveGridSelectionModel#isSelectRowOnNextLoad()
     */
    public boolean isSelectRowOnNextLoad() {
        return selectRowOnNextLoad > -1;
    }

    /* (non-Javadoc)
     * @see com.app.smrmf.core.msfmainapp.client.generics.MSFLiveGridSelectionModel#setCurrentlySelectedItemId(java.lang.Object)
     */
    public void setCurrentlySelectedItemId(Object currentlySelectedItemId) {
        this.currentlySelectedItemId = currentlySelectedItemId;
    }

    /* (non-Javadoc)
     * @see com.app.smrmf.core.msfmainapp.client.generics.MSFLiveGridSelectionModel#setSelectRowOnNextLoad(int)
     */
    public void setSelectRowOnNextLoad(int rowNum) {
        selectRowOnNextLoad = rowNum;
    }

    /* (non-Javadoc)
     * @see com.app.smrmf.core.msfmainapp.client.generics.MSFLiveGridSelectionModel#getSelectRowOnNextLoad()
     */
    public int getSelectRowOnNextLoad() {
        return selectRowOnNextLoad;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void bindGrid(Grid grid) {
        super.bindGrid(grid);
        listStore = gridView.getDisplayStore();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void bind(Store store) {
        super.bind(store);
        this.store = gridView.getDisplayStore();
    }

    /* (non-Javadoc)
     * @see com.app.smrmf.core.msfmainapp.client.generics.MSFLiveGridSelectionModel#clearSelected()
     */
    public void clearSelected() {
        selected.clear();
        lastSelected = null;
    }

    @Override
    public void refresh() {}

    @Override
    protected void onClear(StoreEvent<ModelData> se) {}

    @Override
    protected void onKeyUp(GridEvent<ModelData> e) {
        if (!hasPrevious()) {
            gridView.scrollUp();
        }
        super.onKeyUp(e);
    }

    @Override
    protected void onKeyDown(GridEvent<ModelData> e) {
        if (!hasNext()) {
            gridView.scrollDown();
        }
        super.onKeyDown(e);
    }
    @Override
    protected void onKeyPress(GridEvent<ModelData> e) {
        int code = e.getKeyCode();
        switch (code) {
        case KeyCodes.KEY_PAGEDOWN:
            onPageDown(e);
            break;
        case KeyCodes.KEY_PAGEUP:
            onPageUp(e);
            break;
        }
        super.onKeyPress(e);
    }	
    protected void onPageDown(GridEvent<ModelData> e) {
        gridView.pageDown();
    }
    protected void onPageUp(GridEvent<ModelData> e) {
        gridView.pageUp();
    }

}