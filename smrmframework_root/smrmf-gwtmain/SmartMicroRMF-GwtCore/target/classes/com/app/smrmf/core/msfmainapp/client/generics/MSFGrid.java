/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.listner.GridGenericListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.service.GenericServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFServiceFailureHandler;
import com.app.smrmf.core.msfmainapp.client.widget.IconButtonGrid;
import com.app.smrmf.core.msfmainapp.client.widget.MSFManyTriggerField;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.ModelReader;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.BufferView;
import com.extjs.gxt.ui.client.widget.grid.CellSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @author Carlo
 *
 */
public class MSFGrid implements ClickHandler { //extends SelectionListener<ButtonEvent>{

    public static final int MAX_LENGTH = 100 ;

    protected GenericServiceAsync        appService = GenericService.Util.getInstance();
    protected TableDef                   tableDef;
    protected BaseModel                  currentlySelectedItem;
    protected Object                     currentlySelectedItemId;
    protected TextField                  fieldFilter;
    protected ColumnModel                columnModel;
    protected boolean                    autoLoadData = true;
    protected GridSelectionModel         gridSelectionModel;
    protected GridGenericListenerAdapter listener = new GridGenericListenerAdapter();
   
    private EditorGrid<BaseModel>                     grid;
    private BufferView                               bfView;                   
    private ListStore<BaseModel> store;
    final RowNumberer rowNum = new RowNumberer();
    private PagingLoader<PagingLoadResult<BaseModel>> liveLoader; 
    private RpcProxy<PagingLoadResult<BaseModel>>     liveProxy;
    private boolean isLive;
    private boolean isCellModel;
    private int                                       totalLength;
    private boolean 								  seUpdate;
    private boolean                                   seDelete;
    private LabelToolItem lblGridItem = new LabelToolItem(); 

    private GridCellRenderer<BaseModel> buttonRenderer = new GridCellRenderer<BaseModel>() {  
        public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,  
                final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
            HorizontalPanel hp = new HorizontalPanel();
            //            ButtonGrid bt = null;
            IconButtonGrid bt = null;
            if (seUpdate) {
                // bt = new ButtonGrid(ActionDatabase.UPDATE, true, MSFGrid.this);
                bt = new IconButtonGrid(ActionDatabase.UPDATE, MSFGrid.this);
                bt.showTooltip(true);
                bt.setRecord(model);
                hp.add(bt);
            }
            if (seDelete) {
                //                bt = new ButtonGrid(ActionDatabase.DELETE, true, MSFGrid.this);
                bt = new IconButtonGrid(ActionDatabase.DELETE, MSFGrid.this);
                bt.showTooltip(true);
                bt.setRecord(model);
                hp.add(bt);
            }

            return hp;  
        }  
    };

    @Override
    public void onClick(ClickEvent arg0) {
        final IconButtonGrid source = (IconButtonGrid) arg0.getSource();
        currentlySelectedItem = source.getRecord();
        grid.getSelectionModel().select(currentlySelectedItem, false);
    }

    public MSFGrid(TableDef tableDef,  boolean isLive) {
        this.isLive = isLive;
        this.tableDef = tableDef;
        this.columnModel = tableDef.getColumnModel();
        if (tableDef.isButtonsSingleRow() && !tableDef.isReadOnly()) {
            List<ColumnConfig> columnConfigs = columnModel.getColumns();
            ColumnConfig columnConfig = new ColumnConfig("actionButtons", 60){
                {
                    setRenderer(buttonRenderer);
                    setFixed(true);
                }
            };
            columnConfigs.add(columnConfig);
            this.columnModel = new ColumnModel(columnConfigs);
        }
    }

    public void initialize(){ 
        if (isLive) {
            liveProxy = new RpcProxy<PagingLoadResult<BaseModel>>() {

                @Override
                protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<BaseModel>> callback) {
                    if (loadConfig == null) {
                        callback.onSuccess(new BasePagingLoadResult<BaseModel>(new ArrayList<BaseModel>(), 0, 0));
                    } else {
                        if (autoLoadData) {
                            //Check if call must be skipped
                            if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(getTableDef().getCustomListMethod()) ) {
                                return;
                            }
                            GWT.log("liveProxy.load("+loadConfig+","+callback+")");
                            GWTUtils.maskComponent(grid);
                            PagingLoadConfig config = (PagingLoadConfig) loadConfig;
                            IColumnFilter filters = getTableDef().getColumnFilters(fieldFilter.getRawValue());
                            ServiceParameters params = ServiceParameters.getListParameters(
                                    getTableDef().getTable(),
                                    ActionDatabase.LIST,
                                    getTableDef().getTableAttributes(), 
                                    filters, 
                                    getTableDef().getColumnOrders(), 
                                    config,
                                    getTableDef().getCustomListMethod());
                            appService.getListGenericObjects(
                                    params, 
                                    callback);
                        }
                    }
                }
            };

            liveLoader = new BasePagingLoader<PagingLoadResult<BaseModel>>(liveProxy, new ModelReader()) {
                @Override
                public boolean load() {
                    boolean ok = false;
                    if (autoLoadData) {
                        //Quando il remoteSort=false l'informazione del sort viene salvato solo sullo store
                        //Se clicco su "aggiorna" prendo dallo store l'eventuale order clause che senno' andrebbe persa
                        liveLoader.setSortField(store.getSortField());
                        liveLoader.setSortDir(store.getSortDir());
                        GWTUtils.maskComponent(grid);
                        GWT.log("liveLoader.load()");
                        ok = super.load();
                    }
                    return ok;
                }

                @Override
                protected void onLoadSuccess(Object loadConfig, PagingLoadResult<BaseModel> result) {
                    if ( loadConfig==null ) {
                        loadConfig = new BasePagingLoadConfig(0, 0);
                    }
                  
                    super.onLoadSuccess(loadConfig, result);
                    //After call to onLoadSuccess we fire an event so that an external application 
                    //can add a listener to the grid and intercept this event
                    grid.fireEvent(MSFEvents.dataReadInLiveGrid);
                }

            };
            liveLoader.setRemoteSort(true);

            liveLoader.addLoadListener(new LoadListener() { 
                /**
                 * @see com.extjs.gxt.ui.client.event.LoadListener#loaderLoad(com.extjs.gxt.ui.client.data.LoadEvent)
                 */
                @Override
                public void loaderLoad(LoadEvent le) {
                    GWT.log("liveLoader.loaderLoad("+le+")", le.exception);
                    GWT.log("tableDef.getPageMaxSize()("+tableDef.getPageMaxSize()+")");
                    GWTUtils.unmaskComponent(grid);
                    totalLength   = -1;
                    int rowsRetrieved = -1;
                    try {
                        BasePagingLoadResult<BaseModel> data = le.getData();
                        List<BaseModel> list = data.getData();
                        totalLength = data.getTotalLength();
                        rowsRetrieved = list.size();
                        if (tableDef.getPageMaxSize() > totalLength) {
                            liveLoader.setRemoteSort(false);
                        } else {
                            liveLoader.setRemoteSort(true);
                        }
                        //TODO --차후 로직 확인 수정 임시
                        if (totalLength == 0) { 
                           autoLoadData = false;
                        }
                          
                    } catch (Exception ex) {
                        GWT.log("Exception loading data: " + le, ex);
                    }
                  
                    GWT.log("Store Loaded: store.getCount()=" + store.getCount() + 
                            "  totalLength=" + totalLength + 
                            "  rowsRetrieved=" + rowsRetrieved, le.exception);
              
                }

                /**
                 * @see com.extjs.gxt.ui.client.event.LoadListener#loaderLoadException(com.extjs.gxt.ui.client.data.LoadEvent)
                 */
                @Override
                public void loaderLoadException(LoadEvent le) {
                    GWT.log("liveLoader.loaderLoadException("+le+")", le.exception);
                    GWTUtils.unmaskComponent(grid);
                    MSFServiceFailureHandler failureHandler = new MSFServiceFailureHandler();
                    failureHandler.handleServiceFailure(le.exception);
                }

            });
            store = new ListStore<BaseModel>(liveLoader);
            store.addStoreListener(new StoreListener<BaseModel>() {

                @Override
                public void storeDataChanged(StoreEvent<BaseModel> se) {
                    //Select old record
                    if ( currentlySelectedItemId != null ) {
                        if ( grid.getSelectionModel() instanceof MSFLiveGridSelectionModel ) {
                            MSFLiveGridSelectionModel sm = (MSFLiveGridSelectionModel)grid.getSelectionModel();
                            //TODO: check if this call can be used to avoid selection of an unexistent row after a call to delete
                            //sm.clearSelected();
                            sm.setCurrentlySelectedItemId(currentlySelectedItemId);
                        }
                    }
                    super.storeDataChanged(se);
                }
            });
           // grid = new Grid<BaseModel>(store, columnModel);
            grid = new EditorGrid<BaseModel>(store, columnModel);
            grid.setTrackMouseOver(false); 
            grid.setBorders(false);
            bfView = new BufferView();   
            grid.setView(bfView);
            LiveGridViewExtended liveView = new LiveGridViewExtended();
            liveView.setEmptyText(MSFMainApp.MSFMESSAGES.NoRowsAvailable());
            liveView.setCacheSize(tableDef.getPageMaxSize());
            grid.setView(liveView);
//            if (tableDef.isRowNumberer() ) {
//            	   
//                 ColumnModel columnModel = grid.getColumnModel();
//                 List<ColumnConfig> columnConfigs = columnModel.getColumns();
//                 columnConfigs.add(0,rowNum); 
//                 grid.addPlugin(rowNum);
//                 grid.getView().setForceFit(true);
//             }
            if (tableDef.isCheckBoxOnGridRows()) {
                gridSelectionModel = new LiveGridCheckBoxSelectionModel(liveView);
                LiveGridCheckBoxSelectionModel sm = (LiveGridCheckBoxSelectionModel) gridSelectionModel;
               // grid.setSelectionModel(sm); 
                grid.setColumnReordering(true); 
                grid.getAriaSupport().setLabelledBy(grid.getId() + "-label"); 
                grid.addPlugin(sm); 

                //                gridpanel.getMsfGrid().getGrid().getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<BaseModel>>() { 
                //                    public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                //                        gridpanel.getMsfGrid().setCurrentlySelectedItem((BaseModel) sm.getSelectedItem());
                //                    }
                //                });
                //                gridpanel.getMsfGrid().setListener(new GridGenericListenerAdapter() {
                //                    public void onDoubleClickOnRecord(BaseModel record) {
                //                        gridpanel.getMsfGrid().setCurrentlySelectedItem((BaseModel) sm.getSelectedItem());
                //                        gridpanel.handleButtonEvent(ActionDatabase.UPDATE);
                //                    }
                //                });
                ColumnModel columnModel = grid.getColumnModel();
                List<ColumnConfig> columnConfigs = columnModel.getColumns();
//                if (tableDef.isRowNumberer()) { 
//                	columnConfigs.add(1,sm.getColumn());  
//                } else {
              
                	columnConfigs.add(0,sm.getColumn());
//                }
            } else { 
                gridSelectionModel = new LiveGridSelectionModel(liveView);
                 
            }
         
            grid.setSelectionModel(gridSelectionModel);
            //            grid.addListener(Events.CellClick, new Listener<BaseEvent>() {
            //                public void handleEvent(BaseEvent be) {
            //                    currentlySelectedItem = (BaseModel) sm.getSelectedItem();
            //                    GWT.log("msfGrid.CellClick.handleEvent("+be+"), currentlySelectedItem=" + 
            //                            (currentlySelectedItem!=null ? currentlySelectedItem.get("description") : ""));
            //                }
            //            });
            grid.getSelectionModel().addListener(Events.SelectionChange, 
                    new Listener<SelectionChangedEvent<BaseModel>>() {  
                public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                    // TODO Auto-generated method stub
                    currentlySelectedItem = (BaseModel) gridSelectionModel.getSelectedItem();
                    GWT.log("msfGrid.SelectionChange.handleEvent("+be+"), currentlySelectedItem=" + 
                            (currentlySelectedItem!=null ? currentlySelectedItem.get(TableDef.ID_PROPERTY_NAME) : ""));
                }
            });
            grid.addListener(Events.OnDoubleClick, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    currentlySelectedItem = (BaseModel) gridSelectionModel.getSelectedItem();
                    onDoubleClickOnRecord();
                    listener.onDoubleClickOnRecord(currentlySelectedItem);
                }
            });
            grid.addListener(Events.OnKeyPress,  new Listener<ComponentEvent>() {
                public void handleEvent(ComponentEvent be) {
                    if (be.getKeyCode() == 13) {
                        currentlySelectedItem = (BaseModel) gridSelectionModel.getSelectedItem();
                        onDoubleClickOnRecord();
                        listener.onDoubleClickOnRecord(currentlySelectedItem);
                    }
                }
            });

            final MSFManyTriggerField<String> field = new MSFManyTriggerField<String>(2);
            field.setFirstTriggerStyle("x-form-search-trigger");
            field.setSecondTriggerStyle("x-form-clear-trigger");
            field.setFirstTriggerStyleOnMouseOver("x-form-trigger-over");
            field.setSecondTriggerStyleOnMouseOver("x-form-trigger-over");
            field.setDelimiter(2);
            // click on search trigger
            field.addListener(MSFManyTriggerField.triggerClickEvent[0], new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    if (MSFSharedUtils.paramNotNull(fieldFilter.getRawValue())) {
                        readData();
                    }
                }
            });
            // click on clear trigger
            field.addListener(MSFManyTriggerField.triggerClickEvent[1], new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                    if (MSFSharedUtils.paramNotNull(fieldFilter.getRawValue())) {
                        field.setRawValue("");
                        readData();
                    }
                }
            });
            // Return on field, same as search
            field.addKeyListener(new KeyListener(){
                @Override
                public void componentKeyUp(ComponentEvent event) {
                    char ch = (char) event.getKeyCode();
                    if ( ch == KeyCodes.KEY_ENTER ) {
                        readData();
                    }
                }
            });
            fieldFilter = field;
        } else {
            /**************************************************************************************************/
            //live 호출이 아닌경우 처리를 위한 구현부 
            /**************************************************************************************************/
            store = new ListStore<BaseModel>();
           // grid = new Grid<BaseModel>(store, columnModel);
            grid = new EditorGrid<BaseModel>(store, columnModel);
            bfView = new BufferView();   
            grid.setStripeRows(true);
            grid.setBorders(false);
            grid.setView(bfView);

            
           // final CellSelectionModel<BaseModel> sm = new CellSelectionModel<BaseModel>();
          
            if (tableDef.isCheckBoxOnGridRows()) {
                 gridSelectionModel = new CheckBoxSelectionModel<BaseModel>();
               
                CheckBoxSelectionModel sm = (CheckBoxSelectionModel) gridSelectionModel; 
                //  grid.setSelectionModel(sm); 
                  grid.setColumnReordering(true); 
                  grid.getAriaSupport().setLabelledBy(grid.getId() + "-label"); 
                  grid.addPlugin(sm); 

                  //                gridpanel.getMsfGrid().getGrid().getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<BaseModel>>() { 
                  //                    public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                  //                        gridpanel.getMsfGrid().setCurrentlySelectedItem((BaseModel) sm.getSelectedItem());
                  //                    }
                  //                });
                  //                gridpanel.getMsfGrid().setListener(new GridGenericListenerAdapter() {
                  //                    public void onDoubleClickOnRecord(BaseModel record) {
                  //                        gridpanel.getMsfGrid().setCurrentlySelectedItem((BaseModel) sm.getSelectedItem());
                  //                        gridpanel.handleButtonEvent(ActionDatabase.UPDATE);
                  //                    }
                  //                });
                  ColumnModel columnModel = grid.getColumnModel();
                  List<ColumnConfig> columnConfigs = columnModel.getColumns();
//                  if (tableDef.isRowNumberer()) { 
//                    columnConfigs.add(1,sm.getColumn());  
//                  } else {
                   columnConfigs.add(0,sm.getColumn());
//                  }
            } else { 
                if (tableDef.isCellModel()) {
                    gridSelectionModel = new CellSelectionModel<BaseModel>();
                } else {
                    gridSelectionModel = new GridSelectionModel<BaseModel>();  
                } 
            }
            
            grid.setSelectionModel(gridSelectionModel);
            
            grid.getSelectionModel().addListener(Events.SelectionChange, 
                    new Listener<SelectionChangedEvent<BaseModel>>() {  
                public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                    // TODO Auto-generated method stub
                    currentlySelectedItem = (BaseModel) gridSelectionModel.getSelectedItem();
                    //currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                    GWT.log("msfGrid.SelectionChange.handleEvent("+be+"), currentlySelectedItem=" + 
                            (currentlySelectedItem!=null ? currentlySelectedItem.get(TableDef.ID_PROPERTY_NAME) : ""));
                }
            });
            grid.addListener(Events.OnDoubleClick, new Listener<BaseEvent>() {
                public void handleEvent(BaseEvent be) {
                   // currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                    currentlySelectedItem = (BaseModel) gridSelectionModel.getSelectedItem();
                    onDoubleClickOnRecord();
                    listener.onDoubleClickOnRecord(currentlySelectedItem);
                }
            });
            grid.addListener(Events.OnKeyPress,  new Listener<ComponentEvent>() {
                @SuppressWarnings("unchecked")
                public void handleEvent(ComponentEvent be) {
                    if (be.getKeyCode() == 13) {
                        //currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                        currentlySelectedItem = (BaseModel) gridSelectionModel.getSelectedItem();
                        onDoubleClickOnRecord();
                        listener.onDoubleClickOnRecord(currentlySelectedItem);
                    }
                }
            });
            StoreFilterField<BaseModel> field = new StoreFilterField<BaseModel>() {

                protected boolean doSelect(Store<BaseModel> store, BaseModel parent, BaseModel record, String property, String filter) {
                    Iterator<ColumnConfig> list = getTableDef().getColumnModel().getColumns().iterator();
                    while (list.hasNext()) {
                        ColumnConfig columnConfig = (ColumnConfig) list.next();
                        if (MSFSharedUtils.allowNulls(record.get(columnConfig.getId())).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                            return true;  
                        }
                    }

                    return false;
                }
            };
            field.bind(store);
            fieldFilter = field;
            if (this.autoLoadData) {
                readData();
            }
        }
        fieldFilter.setWidth(150);  
    }

    public ListStore<BaseModel> getStore() {
        return store;
    }

    public void setStore(ListStore<BaseModel> store) {
        this.store = store;
    }

    public EditorGrid<BaseModel> getGrid() {
        return grid;
    }

    public void setTableDef(TableDef tableDef) {
        this.tableDef = tableDef;
    }

    public TableDef getTableDef() {
        return tableDef;
    }

    public void refreshStore(List<BaseModel> obj) {
        if (store != null) {  
            store.removeAll();  
            store.add(obj);
            store.commitChanges();
        }
    }

    /**
     * This method reads data from database and puts these into store then the grid is simple 
     * or uses a loader when the grid is live.
     */
    public void readData(){
        this.autoLoadData = true;
        if ( !isLive ) {
            //Check if call must be skipped
            if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(getTableDef().getCustomListMethod()) ) {
                return;
            }
            GWTUtils.maskComponent(grid);
            IColumnFilter filters = getTableDef().getColumnFilters(fieldFilter.getRawValue());
            ServiceParameters params = ServiceParameters.getListParameters(
                    getTableDef().getTable(),
                    ActionDatabase.LIST,
                    tableDef.getTableAttributes(),
                    filters,
                    tableDef.getColumnOrders(),
                    null,
                    tableDef.getCustomListMethod());
                //  params.setNoPageData(isLive); //TODO 임시로 사용하기 위해 처리됨 
            appService.getListGenericObjects(
                    params,
                    new AsyncCallback<PagingLoadResult<BaseModel>>(){
                        public void onFailure(Throwable caught) {
                            caught.printStackTrace();
                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                    MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListGenericObjects(): "+caught),null);                            
                        }
                        public void onSuccess(PagingLoadResult<BaseModel> result) {
                            GWTUtils.unmaskGrid(grid);
                             
                            List<BaseModel> list = result.getData();
                            refreshStore(list); 
                            
                            lblGridItem.setHtml(GXT.MESSAGES.pagingToolBar_displayMsg(result.getOffset(),result.getTotalLength(),result.getTotalLength()));  
                            //new LabelToolItem(GXT.MESSAGES.pagingToolBar_displayMsg(result.getOffset(),result.getTotalLength(),result.getTotalLength()));   
                            
                        }
                    });
             this.autoLoadData = false;
        } else {
            liveLoader.load();  
        }
        if ( this.currentlySelectedItem != null ) {
            this.currentlySelectedItemId = this.currentlySelectedItem.get(TableDef.ID_PROPERTY_NAME);
            this.currentlySelectedItem = null;
        } 
    }

    public LabelToolItem getlabelGridItem() {
        return this.lblGridItem;
    }
        
        
    public BaseModel getCurrentlySelectedItem() {
        return currentlySelectedItem;
    }

    public void setCurrentlySelectedItem(BaseModel model) {
        this.currentlySelectedItem = model;
        //GWT.log("들어온데이터 확인  ("+model.get(TableDef.ID_PROPERTY_NAME)+")");
    }
    
    public boolean isLive() {
        return isLive;
    }
    
    public void setCellModel(boolean CellModel) {
        this.isCellModel = CellModel;
    }
    
    public boolean isCellModel() {
        return isCellModel;
    }
    

    /**
     * @return It returns the field filter, on grid or live grid. 
     * You can put this into a top toolbar.  
     */
    public TextField getFieldFilter() {
        return fieldFilter;
    }

    public void setGrant(boolean seUpdate, boolean seDelete) {
        this.seUpdate = seUpdate;
        this.seDelete = seDelete;
    }

    /**
     * This is a override of a method of the selection listner. This is required because
     * when you click over buttons update/delete on the single rows, the focus or 
     * current selection item dosen't fired, and the attribute currentlySelectedItem isn't
     * set. Thus when the column buttons is rendered, every buttons has for attribute the relative 
     * basemodel, and when you click on buttons, the basemodel becomes the currentlySelectedItem.
     */
    //    @Override
    //    public void componentSelected(ButtonEvent ce) {
    //        currentlySelectedItem = ((ButtonGrid)ce.getButton()).getRecord();
    //        grid.getSelectionModel().select(currentlySelectedItem, false);
    //    }

    public void setAutoLoad(boolean b) {
        this.autoLoadData = b;
    }

    @Deprecated
    public void onDoubleClickOnRecord(){}

    public void clearData(){
        if (isLive) {
            liveLoader.load(null);
        } else {
            store.removeAll();
            store.commitChanges();
        }
        currentlySelectedItem = null;
    }

    public void setListener(GridGenericListenerAdapter listener) {
        this.listener = listener;
    }

}
