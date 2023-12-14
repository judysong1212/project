/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.HashMap;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.listner.GridGenericListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.service.GenericServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.widget.ButtonGrid;
import com.app.smrmf.core.msfmainapp.client.widget.IconButtonGrid;
import com.app.smrmf.core.msfmainapp.client.widget.MSFSimpleTrigger;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ColumnModelEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnHeader;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.GridView;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LiveToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MSFGridPanel extends ContentPanel {
    public enum MSFGridType {
        NORMAL, LIVE, TREE, GROUPBY
    }

    private GenericServiceAsync appService = GenericService.Util.getInstance();
    private Grid<BaseModel> grid;
    private MSFGrid msfGrid;
    private ToolBar bar = null;
   
    /*
     * LiveToolItem | FillToolItem | exportButton | SeparatorToolItem | refreshButton | SeparatorToolItem | insertButton | SeparatorToolItem | updateButton | SeparatorToolItem | deleteButton
     */
    protected Button exportButton;
    protected SeparatorToolItem separatorToolItem1 = new SeparatorToolItem();
    protected Button refreshButton;
    protected SeparatorToolItem separatorToolItem2 = new SeparatorToolItem();
    protected ButtonGrid insertButton;
    protected SeparatorToolItem separatorToolItem3 = new SeparatorToolItem();
    protected ButtonGrid updateButton;
    protected SeparatorToolItem separatorToolItem4 = new SeparatorToolItem();
    protected ButtonGrid deleteButton;
    protected Button customButton;
    protected SeparatorToolItem separatorToolItem5 = new SeparatorToolItem();
    protected ToolBar bottomToolbar;
    protected TableDef tableDef;
    protected boolean seInsert;
    protected boolean seUpdate;
    protected boolean seDelete;
    protected MSFFormPanel MSFFormPanel;
    protected MSFFormPanel msfCustomFormPanel;
    protected MSFFormPanel workFormPanel;
    protected boolean showExportButton;
    protected boolean showRefreshButton;
    protected boolean autoSelectFirstRecord = true;
    protected MSFGridType gridType;
    protected Dialog dhDialog; 
   
    public MSFGridPanel(
            final TableDef tableDef,
            boolean seInsert, 
            boolean seUpdate, 
            boolean seDelete) {
        this(tableDef, seInsert, seUpdate, seDelete, true);
    }

    public MSFGridPanel(
            final TableDef tableDef,
            boolean seInsert, 
            boolean seUpdate, 
            boolean seDelete,
            boolean autoLoadData) {
        this(tableDef, seInsert, seUpdate, seDelete, autoLoadData, MSFGridType.LIVE, null);
    }

    public MSFGridPanel(
            final TableDef tableDef,
            boolean seInsert, 
            boolean seUpdate, 
            boolean seDelete,
            boolean autoLoadData,
            boolean liveGrid) {
        this(tableDef, seInsert, seUpdate, seDelete, autoLoadData, (liveGrid?MSFGridType.LIVE:MSFGridType.NORMAL), null);
    }
    

    protected void doAutoHeight() {
      if (grid.isViewReady()) {
          
          //이벤트로 호출 처리 수정함.
         // grid.getView().getScroller().setStyleAttribute("overflowY", "hidden");  
          setHeight((grid.getView().getBody().isScrollableX() ? 19 : 0) + grid.el().getFrameWidth("tb")   
                  + grid.getView().getHeader().getHeight() +  getFrameHeight()   
                  + grid.getView().getBody().firstChild().getHeight());   
 
//          setHeight((grid.getView().getBody().isScrollableX() ? 19 : 19)
//          + grid.el().getFrameWidth("tb")
//          + grid.getView().getHeader().getHeight()
//          + getFrameHeight()
//          + grid.getView().getBody().firstChild().getHeight());  
           
      }
    }


    public MSFGridPanel(
            final TableDef tableDef,
            boolean seInsert, 
            boolean seUpdate, 
            boolean seDelete,
            boolean autoLoadData,
            MSFGridType gridType,
            String attribute) {

        super();
        setBodyBorder(true);
        setBorders(false);
        setHeadingText(tableDef.getTitle()); //setHeading(tableDef.getTitle());  
        setButtonAlign(HorizontalAlignment.CENTER);  
        setLayout(new FitLayout()); 
       
        this.tableDef = tableDef;
        this.seInsert = seInsert;
        this.seUpdate = seUpdate;
        this.seDelete = seDelete;
        this.gridType = gridType;

        if (gridType.equals(MSFGridType.GROUPBY)) {
            msfGrid = new MSFGroupByGrid(tableDef, attribute){
                @Override
                public void onClick(ClickEvent arg0) {
                    super.onClick(arg0);
                    if (arg0.getSource() instanceof IconButtonGrid) {
                        final IconButtonGrid source = (IconButtonGrid) arg0.getSource();
                        handleButtonEvent(source.getActionDatabase());
                    }
                }
//                @Override
//                public void componentSelected(ButtonEvent ce) {
//                    super.componentSelected(ce);
//                    if (ce.getButton() instanceof ButtonGrid) {
//                        handleButtonEvent(((ButtonGrid)ce.getButton()).getActionDatabase());
//                    }
//                }
            };
        } else if (gridType.equals(MSFGridType.TREE)) {
            msfGrid = new MSFTreeGrid(tableDef, attribute){
                @Override
                public void onClick(ClickEvent arg0) {
                    super.onClick(arg0);
                    if (arg0.getSource() instanceof IconButtonGrid) {
                        final IconButtonGrid source = (IconButtonGrid) arg0.getSource();
                        handleButtonEvent(source.getActionDatabase());
                    }
                }
//                @Override
//                public void componentSelected(ButtonEvent ce) {
//                    super.componentSelected(ce);
//                    if (ce.getButton() instanceof ButtonGrid) {
//                        handleButtonEvent(((ButtonGrid)ce.getButton()).getActionDatabase());
//                    }
//                }
            };
        } else {
            
                msfGrid = new MSFGrid(tableDef, gridType.equals(MSFGridType.LIVE)){
                @Override
                public void onClick(ClickEvent arg0) {
                    super.onClick(arg0);
                    if (arg0.getSource() instanceof IconButtonGrid) {
                        final IconButtonGrid source = (IconButtonGrid) arg0.getSource();
                        handleButtonEvent(source.getActionDatabase());
                    }
                }
//                @Override
//                public void componentSelected(ButtonEvent ce) {
//                    super.componentSelected(ce);
//                    if (ce.getButton() instanceof ButtonGrid) {
//                        handleButtonEvent(((ButtonGrid)ce.getButton()).getActionDatabase());
//                    }
//                }
            };
        }
        msfGrid.setListener(new GridGenericListenerAdapter(){
            public void onDoubleClickOnRecord(BaseModel record) {
                if (getCurrentlySelectedItem() != null && MSFGridPanel.this.seUpdate) {
                    MSFGridPanel.this.handleButtonEvent(ActionDatabase.UPDATE);
                }
            }
        });
        msfGrid.setGrant(seUpdate, seDelete); //chiamato nel metodo setGrant di questa classe
        msfGrid.setAutoLoad(autoLoadData);
        msfGrid.initialize();
        grid = msfGrid.getGrid();
        grid.setColumnLines(true);
        grid.setColumnReordering(true);
        grid.setStripeRows(true);

        grid.addListener(Events.ViewReady, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                ColumnHeader columnHeader = grid.getView().getHeader();
                setSortIconOnColumnHeader(columnHeader);
               
            }
        });
        
        grid.addListener(Events.ViewReady, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
              grid.getStore().addListener(Store.Add, new Listener<StoreEvent<BaseModel>>() {
                public void handleEvent(StoreEvent<BaseModel> be) { 
                   // doAutoHeight();
//                  if (!msfGrid.isLive()) {   
//                    int viewIndex = be.getIndex();
//                    int totalCount = be.getStore().getModels().size();
//                    int i = be.getStore().getModels().size(); 
//                    lblItem.setLabel(GXT.MESSAGES.pagingToolBar_displayMsg((totalCount == 0 ? 0 : viewIndex + 1), i, (int) totalCount));   
//                  }
                }
              });
               // doAutoHeight();
            }
          });
        
          grid.addListener(Events.ColumnResize, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
              //doAutoHeight();
            }
          });
          grid.getColumnModel().addListener(Events.HiddenChange, new Listener<ColumnModelEvent>() {
            public void handleEvent(ColumnModelEvent be) {
               //doAutoHeight();
            }
          }); 
    

        if (!tableDef.isAutoFillGrid()) {
            grid.addListener(Events.Render, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    Grid grid = (Grid) be.getSource(); 
                    GridView gridView = grid.getView();
                    if (msfGrid.isLive()) {
                        DOM.setStyleAttribute(gridView.getScroller().dom, "overflowX", "auto");
                        DOM.setStyleAttribute(gridView.getScroller().dom, "overflowY", "hidden");
                    } else {
                        DOM.setStyleAttribute(gridView.getScroller().dom, "overflowX", "auto");
                        DOM.setStyleAttribute(gridView.getScroller().dom, "overflowY", "scroll");
                    }
                     
                }
            });
        }
        //If ShowChangeHistory is enabled in tableDef, we add a context menu that allows the user
        //to show histoy data for selected record
        if (tableDef.getEnableHistoryView()) {
            Menu menu = new Menu();
            final MenuItem itemShowHistory = new MenuItem(MSFMainApp.MSFCONSTANTS.ShowHistoryLite());
            menu.add(itemShowHistory);
            itemShowHistory.addListener(Events.OnMouseOver, new Listener<BaseEvent>() {
                @Override
                public void handleEvent(BaseEvent be) {
                    BaseModel bm = getCurrentlySelectedItem();
                    GWTUtils.showListHistoricDataWindow(bm, tableDef);
                }
            });
            grid.setContextMenu(menu);
        }
        //Add triggers set on TableDef, if any
        List<MSFSimpleTrigger> triggers = tableDef.getTriggers();
        if ( triggers!=null && triggers.size()>0 ) {
            for (final MSFSimpleTrigger trigger : triggers) {
                if (trigger.getListener() != null && trigger.getEventType() != null) {
                    this.addListener(trigger.getEventType(), trigger.getListener());
                }
            }
        }
        //editgrig
        if (tableDef.isEditFieldGrid()) {
         //   final EditorGrid<BaseModel> re = new EditorGrid<BaseModel>(grid.getStore(), msfGrid.columnModel);
            grid.addListener(Events.BeforeEdit, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) { 
                    Registry.register("currentSelectedRecord", grid.getSelectionModel().getSelectedItem());
                //    GWT.log("레지스트등록 데이터 확인 들어온데이터 확인  ("+grid.getSelectionModel().getSelectedItem().get(TableDef.ID_PROPERTY_NAME)+")");
                }
            });
            grid.addListener(Events.AfterEdit, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                   //  grid.getStore().commitChanges(); 
                     msfGrid.setCurrentlySelectedItem(grid.getSelectionModel().getSelectedItem());
                   //  GWT.log("수정이후 데이터  들어온데이터 확인  ("+grid.getSelectionModel().getSelectedItem().get(TableDef.ID_PROPERTY_NAME)+")");
                     
//                    AppEvent appEvent = new AppEvent(
//                            MSFEvents.ActivityOnGenericObjects, 
//                            ServiceParameters.getCrtUpdDelParameters(
//                                    tableDef.getTable(), 
//                                    msfGrid.getCurrentlySelectedItem(),
//                                    tableDef.getTableAttributes(),
//                                    ActionDatabase.UPDATE, 
//                                    tableDef.getCustomSaveMethod(),
//                                    tableDef.isReloadData()));
//                    appEvent.setSource(MSFGridPanel.this);
//                    Dispatcher.forwardEvent(appEvent);
                }
            });
            grid.addListener(Events.CancelEdit, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    grid.getStore().rejectChanges();
                }
            });
           
           // grid..addPlugin(  re);
        }
        
        if (tableDef.isEditableGrid()) {
//            final RowEditor<BaseModel> re = new RowEditor<BaseModel>();
//            re.addListener(Events.BeforeEdit, new Listener<BaseEvent>() {
//                public void handleEvent(BaseEvent be) {
//                    Registry.register("currentSelectedRecord", grid.getSelectionModel().getSelectedItem());
//                }
//            });
//            re.addListener(Events.AfterEdit, new Listener<BaseEvent>() {
//                public void handleEvent(BaseEvent be) {
//                 //   grid.getStore().commitChanges();
//                    msfGrid.setCurrentlySelectedItem(grid.getSelectionModel().getSelectedItem());
////                    AppEvent appEvent = new AppEvent(
////                            MSFEvents.ActivityOnGenericObjects, 
////                            ServiceParameters.getCrtUpdDelParameters(
////                                    tableDef.getTable(), 
////                                    msfGrid.getCurrentlySelectedItem(),
////                                    tableDef.getTableAttributes(),
////                                    ActionDatabase.UPDATE, 
////                                    tableDef.getCustomSaveMethod(),
////                                    tableDef.isReloadData()));
////                    appEvent.setSource(MSFGridPanel.this);
////                    Dispatcher.forwardEvent(appEvent);
//                }
//            });
//            re.addListener(Events.CancelEdit, new Listener<BaseEvent>() {
//                public void handleEvent(BaseEvent be) {
//                    grid.getStore().rejectChanges();
//                }
//            });
//            grid.addPlugin(re);
        }
        GridView gridView = grid.getView();
        if (gridView != null) {
            if (gridView instanceof LiveGridViewExtended) {
                LiveGridViewExtended viewExtended = (LiveGridViewExtended) gridView;
                viewExtended.addListener(Events.LiveGridViewUpdate
                        , new Listener<BaseEvent>() {
                    public void handleEvent(BaseEvent be) {
                        firstRowSelectedAndClicked(); 
                    }
                });

            }
        }

        setAutoFill(tableDef.isAutoFillGrid());

        //if (tableDef.showFilterForm() && msfGrid.isLive()) {
        if (tableDef.getFilterFormType()==TableDef.FILTER_FORM_MULTIPLE && msfGrid.isLive()) {
            LayoutContainer formPanel = tableDef.getFilterForm();
            formPanel.addListener(TableDef.clickSearchButton, new Listener<ComponentEvent>() {
                //@Override
                public void handleEvent(ComponentEvent be) {
                    msfGrid.readData();
                }
            });
            LayoutContainer container = new LayoutContainer();
            BorderLayout borderLayout = new BorderLayout();
            container.setLayout(borderLayout);
            BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, tableDef.getHeightSearchForm()+20);  
            container.add(formPanel, northData);
            BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);  
            container.add(grid, centerData);
            add(container);
            //} else {
        } else if (tableDef.getFilterFormType()==TableDef.FILTER_FORM_SINGLE) {
            TextField field = msfGrid.getFieldFilter();
            if (field != null) {
                bar = new ToolBar();  
                bar.add(new LabelToolItem(MSFMainApp.MSFCONSTANTS.Filtro()));  
                bar.add(field);
//                setTopComponent(bar);
            }
            add(grid);
        } else {
            add(grid);
        }

        showFilterToolbar(tableDef.showFilterToolbar());
        
        bottomToolbar = new ToolBar();  
      
        if (msfGrid.isLive()) {
            LiveToolItem item = new LiveToolItem();  
            item.bindGrid(grid);  

            bottomToolbar.add(item);  
        } else { 
              LabelToolItem lblItem = new LabelToolItem();   
              lblItem = msfGrid.getlabelGridItem();
             // lblItem.setLabel(GXT.MESSAGES.pagingToolBar_displayMsg(0,0,0));   
              bottomToolbar.add(lblItem);  
             // bottomToolbar.add(new FillToolItem());  
        }

        bottomToolbar.add(new FillToolItem());  

        showExportButton(false);

        showRefreshButton(true);

        setBottomComponent(bottomToolbar);  	

        //todo 버튼 추가 활성화 기능 추가를 위해 이부분을 수정함. 
        if (!tableDef.isReadOnly()) {
            insertButton = new ButtonGrid(ActionDatabase.INSERT, myButtonListener);
            if (!tableDef.isButtonsSingleRow()) {
                updateButton = new ButtonGrid(ActionDatabase.UPDATE, myButtonListener);
                deleteButton = new ButtonGrid(ActionDatabase.DELETE, myButtonListener);
            }
        }

        setGrant(seInsert, seUpdate, seDelete);

        //        grid.addListener(Events.CellClick, new Listener<BaseEvent>() {
        //            public void handleEvent(BaseEvent be) {
        //                tableDef.refreshObjectLinked(getCurrentlySelectedItem());
        //            }
        //        });
        grid.getSelectionModel().addListener(Events.SelectionChange, 
                new Listener<SelectionChangedEvent<BaseModel>>() {  
            public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                tableDef.refreshObjectLinked(getCurrentlySelectedItem());
            }
        });

        tableDef.setMsfGridPanel(this);

        tableDef.onMsfGridPanelCreated();
    }

    public void reload() {
        msfGrid.readData();
    }

    public void reload(ServiceParameters result) {
        msfGrid.readData();
    }

    private SelectionListener<ButtonEvent> myButtonListener = new SelectionListener<ButtonEvent>() {
        public void componentSelected(ButtonEvent ce) {
            if (ce.getButton() instanceof ButtonGrid) {
                handleButtonEvent(((ButtonGrid)ce.getButton()).getActionDatabase());
            } else if (ce.getButton() == exportButton) {
                    handleButtonEvent(ActionDatabase.EXPORT);
            } else if (ce.getButton() == customButton) {
                handleButtonEvent(ActionDatabase.CUSTOM);
            }
        }
    };
    public void handleButtonEvent(ActionDatabase actionDatabase) {

        switch (actionDatabase) {
        case EXPORT:
            callServletWriterSession();
            break;
        case DELETE:
            fireEvent(MSFEvents.preClickOnDeleteButton, new BaseEvent(deleteButton));
            GridSelectionModel<BaseModel> sm = (GridSelectionModel<BaseModel>) grid.getSelectionModel();
            List<BaseModel> listSelectedItems = sm.getSelectedItems();
            if (listSelectedItems.size() == 1) {
                goToForm(actionDatabase);
            } else if (listSelectedItems.size() > 1) {
                AppEvent appEvent = new AppEvent(
                        MSFEvents.ActivityOnGenericObjects, 
                        ServiceParameters.getDelParameters(tableDef.getTable(), listSelectedItems, actionDatabase, tableDef.getCustomSaveMethod()));
                appEvent.setSource(this);
                Dispatcher.forwardEvent(appEvent);
            } else {
                MessageBox.alert(
                        MSFMainApp.MSFCONSTANTS.Alert(), 
                        MSFMainApp.MSFMESSAGES.msgNoRecordSelected(), 
                        null);
            }
            break;
        case INSERT:
            fireEvent(MSFEvents.preClickOnInsertButton, new BaseEvent(insertButton));
            goToForm(actionDatabase);
            break;
        case UPDATE:
            fireEvent(MSFEvents.preClickOnUpdateButton, new BaseEvent(updateButton));
            goToForm(actionDatabase);
            break;
        case CUSTOM:
            fireEvent(MSFEvents.preClickOnCustomButton, new BaseEvent(customButton));
            goToForm(actionDatabase);
            break;
        }
    }

    protected void goToForm(ActionDatabase actionDatabase){
        String titoloForm = "";
        String titoloButton = "";
        workFormPanel=MSFFormPanel;
        switch (actionDatabase) {
        case INSERT:
            titoloForm = MSFMainApp.MSFCONSTANTS.BtNew()+" "+tableDef.getTitle();
            titoloButton = MSFMainApp.MSFCONSTANTS.BtSave();
            break;
        case UPDATE:
            titoloForm = MSFMainApp.MSFCONSTANTS.BtModification()+" "+tableDef.getTitle();
            titoloButton = MSFMainApp.MSFCONSTANTS.BtRefresh();
            break;
        case DELETE:
            titoloForm = MSFMainApp.MSFCONSTANTS.BtCancel()+" "+tableDef.getTitle();
            titoloButton = MSFMainApp.MSFCONSTANTS.BtCancel();
            break;
        case CUSTOM:
            if(msfCustomFormPanel==null) {
                    titoloForm = tableDef.getTitle();
                    workFormPanel=MSFFormPanel;
            } else {
                titoloForm = msfCustomFormPanel.getTableDef().getTitle();
                workFormPanel=msfCustomFormPanel;
            }
            titoloButton = MSFMainApp.MSFCONSTANTS.BtConferma();
            break;
        }

        if (workFormPanel == null) {
            workFormPanel=
            MSFFormPanel = new MSFSimpleForm(
                    actionDatabase, 
                    tableDef);
        }
        workFormPanel.setMSFGridPanel(this);

        List<Listener<? extends BaseEvent>> listenersOnSuccessSave = workFormPanel.getListeners(MSFCustomForm.OnSuccessSave);
        if ( listenersOnSuccessSave==null || listenersOnSuccessSave.size()==0 ) {
            workFormPanel.addListener(MSFCustomForm.OnSuccessSave, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    fireEvent(MSFCustomForm.OnSuccessSave, be);
                }
            });
        }
        List<Listener<? extends BaseEvent>> listenersBind = workFormPanel.getFormBinding().getListeners(Events.Bind);
        if ( listenersBind==null || listenersBind.size()==0 ) {
            workFormPanel.getFormBinding().addListener(Events.Bind, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    if ( ActionDatabase.INSERT.equals(workFormPanel.getActionDatabase()) ) {
                        workFormPanel.enable();
                        workFormPanel.clearStateFields();
                    }
                    MSFGridPanel.this.fireEvent(MSFEvents.dataBindedIntoForm, new BaseEvent(workFormPanel));
                }
            });
        }

        MSFFormWindows myWindows = 
            new MSFFormWindows(
                    titoloForm, 
                    workFormPanel,
                    titoloButton,
                    MSFMainApp.MSFCONSTANTS.BtDelete());
        myWindows.setWidth(workFormPanel.getWidth()+12);
        myWindows.show();

        workFormPanel.setMSFFormWindows(myWindows);
        workFormPanel.setActionDatabase(actionDatabase);
        switch (actionDatabase) {
        case INSERT:
            BaseModel bm = tableDef.getDefaultValues();
            if (bm != null || workFormPanel.getFormBinding().getModel() != null) {
                workFormPanel.disable();
                workFormPanel.clear();
                workFormPanel.bind(bm);
//                MSFFormPanel.getFormBinding().addListener(Events.Bind, new Listener<BaseEvent>() {
//                    public void handleEvent(BaseEvent be) {
//                        MSFGridPanel.this.fireEvent(MSFEvents.dataBindedIntoForm, new BaseEvent(MSFFormPanel));
//                        MSFFormPanel.enable();
//                        MSFFormPanel.clearStateFields();
//                    }
//                });
            }
            break;
        default:
            if (msfGrid.getCurrentlySelectedItem() != null) {
                workFormPanel.bind(msfGrid.getCurrentlySelectedItem());
//                MSFFormPanel.getFormBinding().addListener(Events.Bind, new Listener<BaseEvent>() {
//                    public void handleEvent(BaseEvent be) {
//                        MSFGridPanel.this.fireEvent(MSFEvents.dataBindedIntoForm, new BaseEvent(MSFFormPanel));
//                    }
//                });
            } else {
                MessageBox.alert(
                        MSFMainApp.MSFCONSTANTS.Alert(), 
                        MSFMainApp.MSFMESSAGES.msgNoRecordSelected(), 
                        null);
            }
            break;
        }
    }

    public void callExportServlet(String customListMethod) {
    	//TODO 추후정리 
    	 callServletWriterSession(); 
    	
    }
    private void callServletWriterSession(){
        //Check if call must be skipped
        if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(tableDef.getCustomListMethod()) ) {
            return;
        }
        IColumnFilter iColumnFilter = tableDef.getTableColumnFilters();
        if (msfGrid.isLive()) {
            iColumnFilter = getTableDef().getColumnFilters(msfGrid.getFieldFilter().getRawValue());
        }
        ServiceParameters params = ServiceParameters.getExportParameters(
                tableDef.getTable(),
                ActionDatabase.EXPORT,
                tableDef.getTitle(), 
                tableDef.getTableAttributes(),
                iColumnFilter,
                tableDef.getColumnOrders(),
                tableDef.getCustomListMethod());
        appService.exportXLSGenericObjects(
                params,
                new AsyncCallback<String>() {
                    public void onSuccess(String result) {
                        if (MSFSharedUtils.paramNotNull(result)) {
                            callExportData(result);
                        }
                    }
                    public void onFailure(Throwable caught) {

                    }
                }
        );
    }

//    public void getListHistoricData(BaseModel bm){
//        if ( bm!=null ) {
//            GWTUtils.maskComponent(grid);
//            final String rowPK = bm.get(TableDef.ID_PROPERTY_NAME);
//            SimpleColumnFilter filters = new SimpleColumnFilter(
//                    MSFDaoConstants.ATTR_AdmDataHistory_primaryKey, 
//                    rowPK, 
//                    SimpleColumnFilter.OPERATOR_EQUALS);
//            ColumnAttribute[] tableAttributes = new ColumnAttribute[] {
//            };
//
//            //IColumnFilter filters = getTableDef().getColumnFilters(fieldFilter.getRawValue());
//            ServiceParameters params = ServiceParameters.getListParameters(
//                    tableDef.getTable(),
//                    ActionDatabase.LIST,
//                    tableAttributes,
//                    filters,
//                    null,
//                    null,
//                    MSFConfiguration.CUSTOM_SERVICE_DATA_HISTORY_LIST);
//            appService.getListGenericObjects(
//                    params,
//                    new AsyncCallback<PagingLoadResult<BaseModel>>(){
//                        public void onFailure(Throwable caught) {
//                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                                    MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListGenericObjects(): "+caught),null);
//                        }
//                        public void onSuccess(PagingLoadResult<BaseModel> result) {
//                            GWTUtils.unmaskComponent(grid);
//                            List<BaseModel> list = result.getData();
//                            final StringBuffer msg = new StringBuffer();
//                            msg.append("<table border='0' cellpadding='2' cellspacing='0' class='x-grid3-row-table'>");
//                            msg.append("<tr><td colspan='5'><b>Historic data for record "+rowPK+"</b></td></tr>");
//                            msg.append("<tr>");
//                            msg.append("<td><b>User</b></td>");
//                            msg.append("<td><b>&nbsp;&nbsp;&nbsp;</b></td>");
//                            msg.append("<td><b>Data</b></td>");
//                            msg.append("<td><b>&nbsp;&nbsp;&nbsp;</b></td>");
//                            msg.append("<td><b>Operazione</b></td>");
//                            msg.append("</tr>");
//                            for ( int i=0 ; i<list.size() ; i++ ) {
//                                BaseModel row = list.get(i);
//                                msg.append("<tr>");
//                                msg.append("<td>"+row.get("user$username")+"</td>");
//                                msg.append("<td>&nbsp;</td>");
//                                msg.append("<td>"+row.get(MSFDaoConstants.ATTR_AdmDataHistory_datetime)+"</td>");
//                                msg.append("<td>&nbsp;</td>");
//                                msg.append("<td>"+row.get(MSFDaoConstants.ATTR_AdmDataHistory_activityOnDb)+"</td>");
//                                msg.append("</tr>");
//                            }
//                            msg.append("</table>");
//                            dhDialog = new Dialog() {
//                                @Override
//                                protected void onRender(Element element, int index) {
//                                    super.onRender(element, index);
//                                    addStyleName("x-window-dlg");
//                                    El body = new El(dhDialog.getElement("body"));
//                                    String html = msg.toString();
//                                    body.dom.setInnerHTML(html);
//                                }
//                            };
//                            dhDialog.setTitle("DATI STORICI");
//                            dhDialog.setButtons("");
//                            dhDialog.setModal(true);
//                            dhDialog.show();
//                        }
//                    });
//        }
//    }

    protected void callExportData(String sessionObjectName){
        //        Window.open("ExportData?XLSParam="+sessionObjectName, "_black", "");
        HashMap<String, String> param = new HashMap<String, String>();
        param .put("XLSParam",sessionObjectName);
        GWTUtils.postCall("ExportData", JsUtil.toJavaScriptObject(param));
    }

    public void setGrant(boolean seInsert, boolean seUpdate, boolean seDelete) {
        this.seInsert = seInsert;
        this.seUpdate = seUpdate;
        this.seDelete = seDelete;
        if (insertButton != null) {
            if (seInsert) {
                bottomToolbar.add(separatorToolItem2);
                bottomToolbar.add(insertButton);
            } else {
                //bottomToolbar.remove(separatorToolItem2);
                //bottomToolbar.remove(insertButton);
                separatorToolItem2.removeFromParent();
                insertButton.removeFromParent();
            }
        }
        if (updateButton != null) {
            if (seUpdate) {
                bottomToolbar.add(separatorToolItem3);
                bottomToolbar.add(updateButton);
            } else {
                //bottomToolbar.remove(separatorToolItem3);
                //bottomToolbar.remove(updateButton);
                separatorToolItem3.removeFromParent();
                updateButton.removeFromParent();
            }
        }
        if (deleteButton != null) {
            if (seDelete) {
                bottomToolbar.add(separatorToolItem4);
                bottomToolbar.add(deleteButton);
            } else {
                //bottomToolbar.remove(separatorToolItem4);
                //bottomToolbar.remove(deleteButton);
                separatorToolItem4.removeFromParent();
                deleteButton.removeFromParent();
            }
        }
        msfGrid.setGrant(seUpdate, seDelete);
    }

    /**
     * @return Return the object grid contained
     */
    public MSFGrid getMsfGrid() {
        return msfGrid;
    }

    public void setMSFFormPanel(MSFFormPanel MSFFormPanel) {
        this.MSFFormPanel = MSFFormPanel;
    }

    public MSFFormPanel getMSFFormPanel() {
        return MSFFormPanel;
    }

    /**
     * 
     * @return Grid GXT standard component content into MSFGrid 
     */
    public Grid<BaseModel> getGrid() {
        return grid;
    }

    public BaseModel getCurrentlySelectedItem(){
        return msfGrid.getCurrentlySelectedItem();
    }

    public void setMargin(int top, int bottom, int left, int right){
        if (top    != 0) setStyleAttribute("paddingTop"   , top+"px");
        if (bottom != 0) setStyleAttribute("paddingBottom", bottom+"px");
        if (left   != 0) setStyleAttribute("paddingLeft"  , left+"px");
        if (right  != 0) setStyleAttribute("paddingRight" , right+"px");
    }

    /**
     * @return Returns the TableDef associated
     */
    public TableDef getTableDef() {
        return tableDef;
    }

    /**
     * True to auto expand the columns to fit the grid <b>when the grid is
     * created</b>.
     * 
     * @param autoFill true to expand
     */
    public void setAutoFill(boolean autoFill){
        grid.getView().setAutoFill(autoFill);
    }

    /**
     * If exists at least one record into store, the first is selected and clicked. 
     */
    protected void firstRowSelectedAndClicked(){
        ListStore<BaseModel> store = grid.getStore();
        if (store != null) {
            List<BaseModel> list = store.getModels();
            if (list != null) {
                if (list.size() > 0 && autoSelectFirstRecord && getCurrentlySelectedItem() == null) {
                    grid.getSelectionModel().select(0, true);
                    grid.fireEvent(Events.CellClick);
                }
            }
        }
    }

    public boolean isAutoSelectFirstRecord() {
        return autoSelectFirstRecord;
    }

    /**
     * If true, when the grid view is ready and if exists and shows at least one record,
     * the first record is auto selected and clicked (fire event CellClick on grid).
     * @param autoSelectFirstRecord default is true
     */
    public void setAutoSelectFirstRecord(boolean autoSelectFirstRecord) {
        this.autoSelectFirstRecord = autoSelectFirstRecord;
    }

    public void showRefreshButton(boolean showRefreshButton) {
        this.showRefreshButton = showRefreshButton;
        if (showRefreshButton) {
            if (refreshButton == null) {
                refreshButton = new Button();
                refreshButton.addSelectionListener(new SelectionListener<ButtonEvent>() {  
                    public void componentSelected(ButtonEvent ce) {  
                        msfGrid.readData();
                    }  
                });
                refreshButton.setToolTip(MSFMainApp.MSFCONSTANTS.BtRefresh());
                refreshButton.setIcon(MSFMainApp.ICONS.actionRefresh());
            }
            bottomToolbar.add(separatorToolItem1); 
            bottomToolbar.add(refreshButton); 
        } else {
            bottomToolbar.remove(separatorToolItem1);
            bottomToolbar.remove(refreshButton);
        }

    }

    public boolean isShowRefreshButton() {
        return showRefreshButton;
    }

    public void showExportButton(boolean showExportButton) {
        this.showExportButton = showExportButton;
        if (showExportButton) {
            if (exportButton == null) {
                exportButton = new Button();
                exportButton.addSelectionListener(myButtonListener);
                exportButton.setIcon(MSFMainApp.ICONS.excel16());
                exportButton.setToolTip("Export EXCEL");
            }
            bottomToolbar.insert(exportButton, 2);
        } else {
            if (exportButton != null) {
                bottomToolbar.remove(exportButton);
            }
        }
    }

    public boolean isShowExportButton() {
        return showExportButton;
    }

    private void setSortIconOnColumnHeader(ColumnHeader columnHeader) {
        int index = 0;
        for (ColumnDef columnDef : this.tableDef.getColumnsDefinition()) {
            if (columnDef.isVisibleInGrid() && columnDef.getSortPos() > 0) {
                columnHeader.updateSortIcon(index, columnDef.getSortDir());
            }
            index++;
        }        
    }

    /**
     * Disable the action buttons
     */
    public void disableActionButtons() {
        if (insertButton != null) {
            insertButton.disable();
        }
        if (updateButton != null) {
            updateButton.disable();
        }
        if (deleteButton != null) {
            deleteButton.disable();
        }
    }

    /**
     * Enable the action buttons
     */
    public void enableActionButtons() {
        if (insertButton != null) {
            insertButton.enable();
        }
        if (updateButton != null) {
            updateButton.enable();
        }
        if (deleteButton != null) {
            deleteButton.enable();
        }
    }    

    public void showSmallActionButtons(boolean b) {
        if (insertButton != null) {
            insertButton.setSmall(b);
        }
        if (updateButton != null) {
            updateButton.setSmall(b);
        }
        if (deleteButton != null) {
            deleteButton.setSmall(b);
        }
    }

    public boolean isSeInsert() {
        return seInsert;
    }

    public void setSeInsert(boolean seInsert) {
        this.seInsert = seInsert;
    }

    public boolean isSeUpdate() {
        return seUpdate;
    }

    public void setSeUpdate(boolean seUpdate) {
        this.seUpdate = seUpdate;
    }

    public boolean isSeDelete() {
        return seDelete;
    }

    public void setSeDelete(boolean seDelete) {
        this.seDelete = seDelete;
    }

    public MSFGridType getGridType() {
        return gridType;
    }

    public void setGridType(MSFGridType gridType) {
        this.gridType = gridType;
    }

    public Button getExportButton() {
        return exportButton;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public ButtonGrid getInsertButton() {
        return insertButton;
    }

    public ButtonGrid getUpdateButton() {
        return updateButton;
    }

    public ButtonGrid getDeleteButton() {
        return deleteButton;
    }

    public ToolBar getBottomToolbar() {
        return bottomToolbar;
    }

    public void setShowExportButton(boolean showExportButton) {
        this.showExportButton = showExportButton;
    }

    public void setShowRefreshButton(boolean showRefreshButton) {
        this.showRefreshButton = showRefreshButton;
    }

    public void setMyButtonListener(SelectionListener<ButtonEvent> myButtonListener) {
        this.myButtonListener = myButtonListener;
    }

 /**
     * @return Add a Button to the bottom ToolBar of MSFGridPanel
     public void addToolButton(Button btn) {
        int idx=0;
        if (showRefreshButton) {
            idx=bottomToolbar.indexOf(refreshButton);
        } else if (showExportButton) {
            idx=bottomToolbar.indexOf(exportButton);
        }
        bottomToolbar.insert(new SeparatorToolItem(), ++idx);
        bottomToolbar.insert(btn, ++idx);
    }
 */
    
    /**
     * @return Add a "unmanaged" custom Button to the bottom ToolBar of MSFGridPanel
     */
    public void addCustomButton(Button btn) {
        addCustomButton(btn, (MSFSimpleForm) null);
    }
    /**
     * @return Add a custom Button to the bottom ToolBar of MSFGridPanel connected to
     * a generated MSFSimpleForm using the tabledef
     */
    public void addCustomButton(Button btn, TableDef tableDef) {
        addCustomButton(btn, new MSFSimpleForm(ActionDatabase.CUSTOM, tableDef));
    } 
  
    /**
     * @return Add a custom Button to the bottom ToolBar of MSFGridPanel connected to
     * a custom MSFFormPanel
     */
    public void addCustomButton(Button btn, MSFFormPanel customPanel) {
        int idx=0;
        if(customButton != null) {
            idx=bottomToolbar.indexOf(customButton);
            bottomToolbar.remove(customButton);
            bottomToolbar.insert(btn, idx);
        } else {
            if (showRefreshButton) {
                idx=bottomToolbar.indexOf(refreshButton);
            } else if (showExportButton) {
                idx=bottomToolbar.indexOf(exportButton);
            }
            bottomToolbar.insert(separatorToolItem5, ++idx);
            bottomToolbar.insert(btn, ++idx);
        }
        
        customButton=btn;
        if(customPanel==null) {
            msfCustomFormPanel=MSFFormPanel;
        } else {
            customButton.addSelectionListener(myButtonListener);
            msfCustomFormPanel=customPanel; 
        }
    }
    public void removeCustomButton() {
        if(customButton != null) {
            bottomToolbar.remove(customButton);
            bottomToolbar.remove(separatorToolItem5);
            customButton=null;
        }
    }
    public void setMsfCustomFormPanel(MSFFormPanel msfCustomFormPanel) {
        this.msfCustomFormPanel = msfCustomFormPanel;
    }

    public MSFFormPanel getMsfCustomFormPanel() {
        return msfCustomFormPanel;
    }
 
    public void showFilterToolbar(boolean b) {
        Component component = getTopComponent();
        if (!b && component != null) {
            remove(component);
        } else if (b && bar != null && component == null) { 
            setTopComponent(bar);
        }
    }

    public void callXlsExportServlet(String tagetMethod, String strFrame,HashMap<String, String> param) {
   
            //넘어온메서드 값을 가지고 처리 한다.  
            GWTUtils.xlsExportData(tagetMethod, strFrame, JsUtil.toJavaScriptObject(param)); 
            
    } 
    
    /**
     * 
     * <pre>
     * 1. 개요 : 선택된 그리드를 입력 팝업 없이 폼에 맵핑하는 메서드 
     * 2. 처리내용 :  내부적으로 formpanel 에 컬럼으로 선언된 내용을 폼에 맵핑하여 바인딩 
     * </pre>
     * @Method Name : setGridRowFormBind
     * @date : Mar 11, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Mar 11, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param model
     */
    public void setGridRowFormBind(ModelData model){ 
        workFormPanel=MSFFormPanel; 

        if (workFormPanel == null) {
            workFormPanel=
            MSFFormPanel = new MSFSimpleForm(
                    ActionDatabase.UPDATE, 
                    tableDef);
        }
        workFormPanel.setMSFGridPanel(this);
 
        List<Listener<? extends BaseEvent>> listenersBind = workFormPanel.getFormBinding().getListeners(Events.Bind);
        if ( listenersBind==null || listenersBind.size()==0 ) {
            workFormPanel.getFormBinding().addListener(Events.Bind, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                  
                    MSFGridPanel.this.fireEvent(MSFEvents.dataBindedIntoForm, new BaseEvent(workFormPanel));
                }
            });
        }
 
            if (model != null) {
                workFormPanel.bind(msfGrid.getCurrentlySelectedItem());
 
            } else {
                MessageBox.alert(
                        MSFMainApp.MSFCONSTANTS.Alert(), 
                        MSFMainApp.MSFMESSAGES.msgNoRecordSelected(), 
                        null);
            } 
        
    }

}