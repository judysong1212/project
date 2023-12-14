/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.LiveGridView;

public class LiveGridViewExtended extends LiveGridView {

    public static EventType StoreSet = new EventType();

    public ListStore<ModelData> getDisplayStore() {
        return ds;
    }

    public ListStore<ModelData> getCacheStore() {
        return liveStore;
    }

    public void refreshSelection() {
        List<ModelData> selectedItems = grid.getSelectionModel().getSelectedItems();
        for (ModelData selectedItem : selectedItems) {
            for (ModelData model : ds.getModels()) {
                if (model.equals(selectedItem)) {  //<--- confronta le righe per sincronizzare la selezione
                    int idx = ds.indexOf(selectedItem);
                    onRowSelect(idx);
                    break;
                }
            }
        }
    }

    public void scrollUp() {
        if (viewIndex > 0) {
            GridSelectionModel<ModelData> gsm=grid.getSelectionModel();
            gsm.deselect(0);
            updateRows(viewIndex - 1, false);
            liveScroller.setScrollTop(liveScroller.getScrollTop() - getCalculatedRowHeight());
            gsm.select(0,false);
        }
    }

    public void scrollDown() { 
        if ((totalCount - getVisibleRowCount()) > viewIndex) {
            GridSelectionModel<ModelData> gsm=grid.getSelectionModel();
            gsm.deselect(getVisibleRowCount()-1);
            updateRows(viewIndex + 1, false);
            liveScroller.setScrollTop(liveScroller.getScrollTop() + getCalculatedRowHeight());
            gsm.select(getVisibleRowCount()-1,false);
        }
    }

    public void pageUp() {
        LiveGridSelectionModel<ModelData> gsm=(LiveGridSelectionModel<ModelData>) grid.getSelectionModel();
        int row=liveStore.indexOf(gsm.getSelectedItem()) + liveStoreOffset - viewIndex;
        if(row < 0) 
            gsm.select(getVisibleRowCount()-1, false);
        else if ((viewIndex>0) && (getVisibleRowCount() -row -1 > 0)){
            gsm.setSelectRowOnNextLoad(0);
            gsm.deselectAll();
            liveScroller.setScrollTop(liveScroller.getScrollTop() -
                    (getCalculatedRowHeight() * (getVisibleRowCount() -row -1)) );
        } else {
            gsm.select(0, false);
        }
    }

    public void pageDown() {
        // viewIndex e' l'indice della prima riga visibile, liveStoreOffset le righe saltate dalla cache 
        LiveGridSelectionModel<ModelData> gsm=(LiveGridSelectionModel<ModelData>) grid.getSelectionModel();
        int row=liveStore.indexOf(gsm.getSelectedItem());
        if(row < 0) 
            gsm.select(0, false);
        else if(((viewIndex + getVisibleRowCount()) < totalCount)  && ((row + liveStoreOffset - viewIndex) >0)) {
            gsm.setSelectRowOnNextLoad(getVisibleRowCount()-1);
            gsm.deselectAll();
            liveScroller.setScrollTop(liveScroller.getScrollTop() + 
                    (getCalculatedRowHeight() * (row+ liveStoreOffset - viewIndex)) );
        } else {
            gsm.select(getVisibleRowCount()-1, false);
        }
    }

    @Override
    protected void initData(ListStore ds, ColumnModel cm) {
        super.initData(ds, cm);
        fireEvent(StoreSet);
    }

    @Override
    public void onRowSelect(int rowIndex) {
        super.onRowSelect(rowIndex);
        applyEmptyText();
    }

    @Override
    protected void initElements() {
        super.initElements();
        scroller.setStyleAttribute("overflowX", "hidden");
    }

    @Override
    public void refresh(boolean headerToo) {
        super.refresh(headerToo);
        refreshSelection();
    }

}