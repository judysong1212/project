/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;

public abstract class MSFFilterField extends StoreFilterField<BaseModel>{

    public MSFFilterField() {
        super();
        setTriggerStyle("x-form-search-trigger");
    }

    @Override
    protected boolean doSelect(Store<BaseModel> store, BaseModel parent, BaseModel record, String property, String filter) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    protected abstract void onTriggerClick(ComponentEvent ce);

}
