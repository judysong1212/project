/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.form;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.model.model.Entry;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.google.gwt.user.client.Element;
import com.msfgwt.reflection.client.Reflectable;

@Reflectable
public class MenuPage extends LayoutContainer implements IMSFWindow {

    private ListView<ModelData> dataView;
    protected Page page;

    @Override
    protected void onRender(Element parent, int pos) {
        super.onRender(parent, pos);
        setScrollMode(Scroll.AUTO);

//        MSFMainAppModel model = (MSFMainAppModel) Registry.get(MSFMainApp.MODEL);
        LayoutContainer customLayoutContainer = MSFMainApp.getCustomLayoutContent();
        if (customLayoutContainer == null) {
            /*
             * I read every row and add only those with Image not null. 
             * This shows in the content page only Entry with image (Thumb)  
             */
            ListStore<ModelData> store = new ListStore<ModelData>();
    //        for (Entry e : model.getEntries()) {
            for (Entry e : MSFMainApp.getEntries()) {
                if (!MSFSharedUtils.isNullAsString(e.get(MSFMainApp.ATTR_IMAGE))) {
                    store.add(e);
                }
            }
    
            StringBuffer sb = new StringBuffer();
            sb.append("<tpl for=\".\">");
            sb.append("<div class='sample-box' style='padding-top: 4px'>");
            sb.append("<div class='thumbd'>{image}</div>");
            sb.append("<div>{name}</div>");
            sb.append("</div></tpl>");
    
            dataView = new ListView<ModelData>();
            dataView.setItemSelector(".sample-box");
            dataView.setOverStyle("sample-over");
            dataView.setSelectStyle("none");
            dataView.setBorders(false);
            dataView.setStore(store);
            dataView.setTemplate(sb.toString()); 
            dataView.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
    
                @Override
                public void selectionChanged(SelectionChangedEvent<ModelData> se) {
                    if (se.getSelectedItem() != null) {
                        ModelData record = se.getSelectedItem();
                        Entry entry = (Entry) record;
                        MSFMainApp.showPage(entry);
                        dataView.getSelectionModel().deselectAll();
                    }
                }
            });
            add(dataView);
        } else {
            if ( customLayoutContainer instanceof IMSFContainer ) {
                IMSFContainer container = (IMSFContainer) customLayoutContainer;
                if ( container.getPageLayout()!=null ) {
                    setLayout(container.getPageLayout());
                }
                if ( container.getPageLayoutData()!=null ) {
                    add(customLayoutContainer, container.getPageLayoutData());
                } else {
                    add(customLayoutContainer);
                }
            } else {
                add(customLayoutContainer);
            }
        }
    }

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

}
