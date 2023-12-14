/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.mvc;


import com.app.smrmf.core.msfmainapp.client.AppEvents;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ClientSession;
import com.app.smrmf.core.msfmainapp.client.form.Page;
import com.app.smrmf.core.msfmainapp.client.model.model.Entry;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.History;

public class ContentView extends View {

	  private TabPanel tabPanel;

	    public ContentView(Controller controller) {
	        super(controller);
	    }

	    public void initialize() {
	        tabPanel = new TabPanel();
	        tabPanel.setCloseContextMenu(true);
	        tabPanel.setBorderStyle(false);
	        tabPanel.setBodyBorder(false);
	        tabPanel.setTabScroll(true);
	        tabPanel.setAnimScroll(true);
	        tabPanel.addListener(Events.Remove, new Listener<TabPanelEvent>() {
	            public void handleEvent(TabPanelEvent be) {
	                final ClientSession clientSession   = MSFMainApp.getClientSession();
	                TabItem item = be.getItem();
	                Entry entry = (Entry) item.getData("entry");
	                String idKey = item.getData("idKey");
	                clientSession.remove(idKey);
	                Dispatcher.forwardEvent(AppEvents.HidePage, entry);
	            }
	        });

	        tabPanel.addListener(Events.Select, new Listener<TabPanelEvent>() {
	            public void handleEvent(TabPanelEvent be) {
	                String token = History.getToken();
	                Entry entry = (Entry) be.getItem().getData("entry");
	                MSFMainApp.unmaskMainPage();
	                if (token != null && (!token.equals(entry.getId()))) {
	                    History.newItem(entry.getId(), false);
	                }
	                Dispatcher.forwardEvent(AppEvents.TabChange, entry);
	            }
	        });
	        ContentPanel center = (ContentPanel) Registry.get(AppView.CENTER_PANEL);
	        center.add(tabPanel);
	    }

	    public void onShowPage(Entry entry){
	        onShowPage(entry, null,null,null);
	    }
	    public void onShowPage(Entry entry,String idKey,String dataBlocco,String utenteBlocco) {
	        final ClientSession clientSession   = MSFMainApp.getClientSession();
	        Page page = entry.get(MSFMainApp.ATTR_PAGE);
	        if (page == null) {
	            page = new Page(entry);
	            entry.set(MSFMainApp.ATTR_PAGE, page);
	        }

	        TabItem item = tabPanel.findItem("page__"+page.getId(), false);
	        if (item==null){
	            String pageId    = clientSession.getString(idKey);
	            item = tabPanel.findItem("page__"+pageId, false);
	        }
	        // take the max session number used to the same entry and add 1
	        int sessionNumber = findSessioneNumber(entry)+1;
	        // if the session number is 1, I do nothing, else create a short string () with session to attach bottom tab name
	        String session = "";
	        if (sessionNumber > 1) {
	            session = " ("+sessionNumber+")";
	        }

	        if (item == null || "NEW".equals(idKey)) {
	            item = new TabItem();
	            item.setData("entry", entry);
	            if (idKey != null) {
	                item.setData("idKey", idKey);
	            }
	            item.setClosable(entry.isClosable());
	            item.setId("page__"+page.getId());
	            if (idKey != null ){
	                clientSession.addGlobalAttribute(idKey, page.getId());    
	            }
	            if (dataBlocco != null){
	                clientSession.addAttribute(MSFMainApp.DATABLOCK, dataBlocco);    
	            }
	            if (utenteBlocco != null){
	                clientSession.addAttribute(MSFMainApp.USERLOCK,utenteBlocco);    
	            }
	            item.setText(entry.getName()+session);
	            item.setLayout(new FitLayout());
	            item.setData("sessionNumber", Integer.valueOf(sessionNumber));
	            item.add(page);
	            tabPanel.add(item);
	        }

	        if (item != tabPanel.getSelectedItem()) {
	            tabPanel.setSelection(item);
	        }
	    }

	    public void onRemovePage(Entry entry,String idKey) {
	        final ClientSession clientSession   = MSFMainApp.getClientSession();
	        clientSession.remove(idKey);
	   
	        String pageId    = clientSession.getString(idKey);
	        TabItem item = tabPanel.findItem("page__"+pageId, false);

	        if (item==null){
	            Page page = entry.get(MSFMainApp.ATTR_PAGE);
	            item = tabPanel.findItem("page__"+page.getId(), false);
	        }
	        tabPanel.remove(item);
	    }

	    /**
	     * Count the tabItem with the same entry and return the maxSessionNumber found with attribute into the tabItem data
	     * 
	     * @param entry The new entry
	     * @return the number of the session
	     */
	    private int findSessioneNumber(Entry entry) {
	        int maxSessioniNumber = 0;
	        int count = tabPanel.getItemCount();
	        for (int i = 0; i < count; i++) {
	            TabItem item = tabPanel.getItem(i);
	            Object o = item.getData("entry");
	            if (o != null && o instanceof Entry) {
	                Entry e = (Entry)o;
	                if (e.getName().equals(entry.getName())) {
	                    Object s = item.getData("sessionNumber");
	                    if (s != null && s instanceof Integer) {
	                        if (((Integer)s).intValue() > maxSessioniNumber) {
	                            maxSessioniNumber = ((Integer)s).intValue();
	                        }
	                    }
	                }
	            }
	        }
	        return maxSessioniNumber;
	    }

	    protected void handleEvent(AppEvent event) {
	        EventType type = event.getType();
	        if (type == AppEvents.ShowPage) {
	            Entry entry = event.getData("entry");
	            String idKey = event.getData("idKey");
	            String dataModifica = event.getData(MSFMainApp.DATABLOCK);
	            String utenteModifica = event.getData(MSFMainApp.USERLOCK);
	            onShowPage(entry,idKey,dataModifica,utenteModifica);
	        }
	        if (type == AppEvents.RemovePage){
	            Entry entry = event.getData("entry");
	            String idKey = event.getData("idKey");
	            onRemovePage(entry, idKey);
	            //            final ClientSession clientSession   = MSFMainApp.getClientSession();
	            //            TabItem item = this.tabPanel.getSelectedItem();
	            //            String idKey = item.getData("idKey");
	            //            clientSession.remove(idKey);
	            //            tabPanel.remove(item);
	        }
	    }
 

}
