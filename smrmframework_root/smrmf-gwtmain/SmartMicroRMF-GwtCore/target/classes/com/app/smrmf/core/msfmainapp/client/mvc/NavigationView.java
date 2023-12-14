/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.mvc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.AppEvents;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.model.model.Category;
import com.app.smrmf.core.msfmainapp.client.model.model.Entry;
import com.app.smrmf.core.msfmainapp.client.model.model.Folder;
import com.app.smrmf.core.msfmainapp.client.model.model.MSFMainAppModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.SelectionService;
import com.extjs.gxt.ui.client.event.SourceSelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabPanel.TabPosition;
import com.extjs.gxt.ui.client.widget.button.IconButton;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
 

public class NavigationView extends View {

	  public enum NavigationType {
	        TREE, LIST, ACCORDING
	    }

	    private MSFMainAppModel model;
	    private ContentPanel westPanel;
	    private ToolBar toolBar;
	    private TabPanel tabPanel;
	    private TabItem listItem, treeItem, accordingItem;
	    private TreePanel<ModelData> tree;

	    private TreeStore<ModelData> treeStore;
	    private StoreFilterField<ModelData> filter;
	    private SelectionChangedListener<TreeModel> sele;
	    private ListView<Entry> list;
	    private SourceSelectionChangedListener seleSource;

	    private ModelData acoChild = null;
	    
	    public NavigationView(Controller controller) {
	        super(controller);
	    }

	    protected void initialize() {
	        model = (MSFMainAppModel) Registry.get(MSFMainApp.MODEL);
	        sele = new SelectionChangedListener<TreeModel>() {
	            public void selectionChanged(SelectionChangedEvent<TreeModel> event) {
	                List<TreeModel> sel = event.getSelection();
	                if (sel.size() > 0) {
	                    TreeModel m = (TreeModel) event.getSelection().get(0);
	                    if (m != null && m instanceof Entry) {
	                        MSFMainApp.showPage((Entry) m);
	                    }
	                }
	            }  
	        };
	        SelectionService.get().addListener(sele);
	        filter = new StoreFilterField<ModelData>() {

	            @Override
	            protected boolean doSelect(Store<ModelData> store, ModelData parent, ModelData child, String property,
	                    String filter) {
	                if (child instanceof Folder) {
	                    return false;
	                }
	                String name = child.get("name");
	                name = name.toLowerCase();
	                if (name.indexOf(filter.toLowerCase()) != -1) {
	                    return true;
	                }
	                return false;

	            }

	        };
           
	        westPanel = (ContentPanel) Registry.get(AppView.WEST_PANEL);
	        //westPanel.setHeading("PayGenApp");
	        westPanel.setHeadingText("PayGenApp");
	        westPanel.setLayout(new FitLayout());
	        westPanel.add(createTabPanel());

	        toolBar = (ToolBar) westPanel.getTopComponent();
	        IconButton filterBtn = new IconButton("icon-filter");
	        filterBtn.setWidth(20);
	        toolBar.add(filterBtn);
	        toolBar.add(filter);

	        createListContent();
	        createTreeContent();
	        createAccordingContent();
	        westPanel.syncSize();
	    }

	    private TabPanel createTabPanel() {
	        tabPanel = new TabPanel();
	        tabPanel.setMinTabWidth(70);
	        tabPanel.setBorderStyle(false);
	        tabPanel.setBodyBorder(false);
	        tabPanel.setTabPosition(TabPosition.BOTTOM);

	        treeItem = new TabItem();
	        treeItem.setText(MSFMainApp.MENU);
	        tabPanel.add(treeItem);

	        listItem = new TabItem();
	        listItem.setText(MSFMainApp.MENU);
	        tabPanel.add(listItem);

	        accordingItem = new TabItem();
	        accordingItem.setText(MSFMainApp.MENU);
	        tabPanel.add(accordingItem);

	        setTabPanel(MSFMainApp.getNavigationType());
	        return tabPanel;
	    }

	    public void setTabPanel(NavigationType navigationType) {
	        tabPanel.removeAll();
	        switch (navigationType) {
	        case LIST:
	            tabPanel.add(listItem);
	            break;
	        case ACCORDING:
	            tabPanel.add(accordingItem);
	            break;
	        default:
	            tabPanel.add(treeItem);
	            break;
	        }
	    }

	    private void createTreeContent() {
	        TreeLoader<ModelData> loader = new BaseTreeLoader<ModelData>(new TreeModelReader<List<ModelData>>()) {
	            @Override
	            public boolean hasChildren(ModelData parent) {
	                return parent instanceof Category;
	            }

	        };
	        treeStore = new TreeStore<ModelData>(loader);

	        tree = new TreePanel<ModelData>(treeStore);
	        tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	        tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-list"));
	        tree.setAutoLoad(true);
	        tree.setDisplayProperty("name");
	        tree.setIconProvider(modelIconProvider);
	      
	        seleSource = new SourceSelectionChangedListener(tree.getSelectionModel());
	        SelectionService.get().addListener(seleSource);
	        SelectionService.get().register(tree.getSelectionModel());

	        filter.bind(treeStore);
	        loader.load(model);
	        tree.expandAll();

	        treeItem.setBorders(false);
	        treeItem.setLayout(new FitLayout());
	        treeItem.add(tree);

	        Menu contextMenu = new Menu();  

	        MenuItem insert = new MenuItem();  
	        insert.setText(MSFMainApp.MSFMESSAGES.OpenNewSession());  
	        insert.setIcon(MSFMainApp.ICONS.add());  
	        insert.addSelectionListener(new SelectionListener<MenuEvent>() {  
	            public void componentSelected(MenuEvent ce) {  
	                ModelData folder = tree.getSelectionModel().getSelectedItem();  
	                if (folder != null) {  
	                    TreeModel m = (TreeModel) folder;
	                    if (m != null && m instanceof Entry) {
	                        Entry e = ((Entry) m).clone();
//	                        e.setNewSessione(true);
	                        MSFMainApp.showPage(e, "NEW", null, null);
	                    }
	                }  
	            }  
	        });  
	        contextMenu.add(insert);  

	        tree.setContextMenu(contextMenu);
	    }

	    private ModelIconProvider<ModelData> modelIconProvider = new ModelIconProvider<ModelData>() {
	        public AbstractImagePrototype getIcon(ModelData model) {
	            String iconCss = model.get(MSFMainApp.ATTR_ICON);
	            if (iconCss == null || iconCss.isEmpty()) {
	                return IconHelper.create("icons/default.png", 0, 0); /* this will set the second image size to 0px */
	            }
	            return IconHelper.create("icons/"+iconCss);
	        }
	    };

	    @SuppressWarnings("unchecked")
	    private void createListContent() {
	        listItem.setLayout(new FitLayout());
	        listItem.setBorders(false);

	        list = new ListView<Entry>();
	        list.setDisplayProperty("name");
	        list.setBorders(false);
	        list.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<Entry>() {
	            @Override
	            public void selectionChanged(SelectionChangedEvent<Entry> se) {
	                Entry e = se.getSelection().get(0);
	                if (e != null && e instanceof Entry) {
	                    Entry entry = (Entry) e;
//	                    entry.setNewSessione(true);
	                    MSFMainApp.showPage(entry);
	                }
	            }
	        });

	        ListStore<Entry> store = new ListStore<Entry>();
	        store.setStoreSorter(new StoreSorter(new Comparator<Entry>() {

	            public int compare(Entry e1, Entry e2) {
	                return e1.getName().compareTo(e2.getName());
	            }

	        }));
	        store.add(MSFMainApp.getEntries());

	        list.setStore(store);

	        filter.bind((Store) store);
	        listItem.add(list);
	    }


	    private ContentPanel accordingPanel;
	    
	    private void createAccordingContent() {
	        accordingItem.setLayout(new FitLayout());
	        accordingItem.setBorders(false);

	        accordingPanel = new ContentPanel();  
	        accordingPanel.setHeaderVisible(false);  
	        accordingPanel.setBodyBorder(false);   
	        accordingPanel.setLayout(new AccordionLayout());
	        loadEntriesAccording(model, null);
	     
	        accordingItem.add(accordingPanel);
	        //	    filter.bind((Store) store);
	    }

	    private void loadEntriesAccording(TreeModel model, TreeStore<ModelData> store) {
	    	 
	        for (ModelData child : model.getChildren()) {
	            if (child instanceof Entry) { 
	            	  
	            	if (acoChild != null && acoChild.get(MSFMainApp.ATTR_ID).equals(((Entry) child).getUpid())) { 
	            	    // String entryDisply = "<span style='font-size:13px'>" + ((Entry) child).getName() + "</span>" ; 
	            	     String entryDisply = ((Entry) child).getName(); 
	            	     child.set(MSFMainApp.ATTR_NAME, entryDisply);
	            		 store.add(acoChild, child , false);  
	            	} else {
	            	   //  String entryDisply = "<span style='font-size:13px'>" + ((Entry) child).getName() + "</span>" ;
	            	     String entryDisply = ((Entry) child).getName();
                         child.set(MSFMainApp.ATTR_NAME, entryDisply);
	            		store.add(child, false);
	            	}
	            
	            } else if (child instanceof Category) {
	            	
	            	    acoChild = null;
	            	    ContentPanel cp = new ContentPanel();  
	            	    cp.setAnimCollapse(false);  
	            	   // cp.removeStyleName("x-panel-inline-icon");
	            	   // cp.setStyleName("x-panel-inline-icon_acco");
	            	    cp.setIcon(MSFMainApp.ICONS.bgHeading2());  
	            	    cp.getHeader().setStyleAttribute("line-height", "25px"); 
	            	    
		               // cp.setHeading("<span style='font-size:16px'><b>" + ((Category) child).getName() + "</b></span>");  
		                cp.setHeadingHtml("<span style='font-size:16px'><b>" + ((Category) child).getName() + "</b></span>");
		                cp.setLayout(new FitLayout()); 
                        
		            	if (((Category) child).getUpId() != null) {
		            	 	if (((Category) child).getUpId().equals("EXTERM00"))   { 
		            	 	  
		            	 	    accordingPanel.add(cp);
		            	 	  //cp.getHeader().addStyleName("background: url('" + GWT.getHostPageBaseURL() + "/images/left_bg.gif')  top left; background-repeat:repeat-y;font-size:12px; padding:0px 0px 0px 0px;");
		                        store = new TreeStore<ModelData>();  
			                    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store);	
			                
				                tree.setDisplayProperty("name");
				                tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-list")); 
                                tree.setIconProvider(modelIconProvider);
				                tree.addListener(Events.OnClick, new Listener<BaseEvent>() {
				                    public void handleEvent(BaseEvent be) {
				                    	//Entry e = (Entry) be.getSource();
				                       	if (tree.getSelectionModel().getSelectedItem() != null) { 
					                        Entry e = (Entry) tree.getSelectionModel().getSelectedItem();
					                        if (e != null && e instanceof Entry) {
					                            Entry entry = (Entry) e;
				//	                            entry.setNewSessione(true);
					                            MSFMainApp.showPage(entry);
					                        }
				                       	}   
				                    }
				                });
				                cp.add(tree);
				                loadEntriesAccording((Category) child, store);
		            	 	} else {
		            	 		  
		            	 	    // String entryDisply = "<span style='font-size:13px'>" + ((Category) child).getName() + "</span>" ;
		            	 	    String entryDisply =  ((Category) child).getName();
		            	 	    
		                         child.set(MSFMainApp.ATTR_NAME, entryDisply);
		            	 		 acoChild = child; 
					                
		            	 		tree = new TreePanel<ModelData>(store); 
		            	        tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-list"));  
		            	        tree.setIconProvider(modelIconProvider);
//		            	 		tree.setIconProvider(new ModelIconProvider<ModelData>() {
//
//		            	 		      public AbstractImagePrototype getIcon(ModelData model) {
//		            	 		        if (model.get("icon") != null) {
//		            	 		          return IconHelper.createStyle((String) model.get("icon"));
//		            	 		        } else {
//		            	 		          return null;
//		            	 		        }
//		            	 		      }
//
//		            	 		    });

		            	 	    tree.setDisplayProperty("name"); 
		            	 	  
		            	 		store.add(child, false);
		            	 	     
		            	 	    tree.setExpanded(child, true);  
		            	 	    
		            		    cp.add(tree); 
		            		    loadEntriesAccording((Category) child, store);
		            	 	}
		            	} else {
		            		
				                loadEntriesAccording((Category) child, store);
		            	} 
			                
		            
	            } else if (child instanceof Folder) {
	                loadEntriesAccording((Folder) child, null);
	            }
	        }
	    }
 
	    
	    @SuppressWarnings("unchecked")
	    protected void handleEvent(AppEvent event) {
	        EventType type = event.getType();
	        Entry entry = (Entry) event.getData();
	        if (type == AppEvents.HidePage ) {
	            tree.getSelectionModel().deselectAll();
	            entry.remove(MSFMainApp.ATTR_PAGE);
	        } else if ( type == AppEvents.LogOut ){  
	            SelectionService.get().removeListener(sele);
	            SelectionService.get().removeListener(seleSource);
	            SelectionService.get().unregister(tree.getSelectionModel());
	        } else if (type == AppEvents.TabChange ) {
//	            if (entry.getName() == "Menu") {
	            if (entry.getId() == MSFMainApp.ENTRY_MENU_NAME) {
	                tree.getSelectionModel().deselectAll();
	            } else {
	                tree.getSelectionModel().setSelection((List) Arrays.asList(entry));
	            }
	        }
	        //} else if ( type == AppEvents.Init ){
	        //    //Espandi il primo figlio
	        //    try {
	        //        ModelData menuNode = treeStore.getChild(0);
	        //        tree.setExpanded(menuNode, true);
	        //    } catch (Exception ex) {}
	        //}
	    }

}
