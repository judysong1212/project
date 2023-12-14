 /*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class MSFTreeGridBase<M extends ModelData> extends TreeGrid<M>{

    public MSFTreeGridBase(TreeStore<M> store, ColumnModel columnModel) {
        super(store, columnModel);
        setIconProvider(modelIconProvider);
        
    }
    
    protected void onRender(Element target, int index) {
        super.onRender(target, index);
        expandAll();
    }

    public void refresh(M model) {
        super.refresh(model);
    }

    private ModelIconProvider<M> modelIconProvider = new ModelIconProvider<M>() {
        public AbstractImagePrototype getIcon(M model) {
            String iconCss = model.get("icon-css");
            if (iconCss == null || iconCss.isEmpty()) {
                return IconHelper.create("empty.png", 0, 0); /* this will set the second image size to 0px */
            }
            return IconHelper.create(iconCss);
        }
    };
    

}
