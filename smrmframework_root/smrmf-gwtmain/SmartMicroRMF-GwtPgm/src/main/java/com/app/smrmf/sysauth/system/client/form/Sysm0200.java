package com.app.smrmf.sysauth.system.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0200BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.client.service.Sysm0200Service;
import com.app.smrmf.sysauth.system.client.service.Sysm0200ServiceAsync;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.dnd.TreeGridDragSource;
import com.extjs.gxt.ui.client.dnd.TreeGridDropTarget;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.event.DNDListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Sysm0200  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 
	  private SysmConstants lblSysmConst = SysmConstants.INSTANCE;
	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	
	  private VerticalPanel vp;
	  private FormPanel plFrmSysm0200;
	  private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  private TreeStore<BaseModel> store;
      private TreeGrid<BaseModel> grid;
      private Sysm0200ServiceAsync sysm0200Service = Sysm0200Service.Util.getInstance();
      private Button insertButton;
      private Button updateButton;
      private Button deleteButton;
      private BaseModel record;
      private TreeGridDropTarget target;
      
      private TextField<String> mnuNm;         //메뉴명
      
	  

	  public ContentPanel getViewPanel(){
			if(panel == null){
			  
				
				panel = new ContentPanel();
				//panel.setLayout(new FitLayout());  
		        panel.setBodyBorder(false);
		        panel.setBorders(false);
		        panel.setScrollMode(Scroll.AUTO); 
		        panel.setHeaderVisible(false); 
		        
			  //  formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    
			    createPsnl0100Form();  //화면 기본정보를 설정
			 
			    vp.setSize("1010px", "700px");	 
			    panel.add(vp);
	        }
	        return panel;
		}
			
		private void createPsnl0100Form() {
				  
			  plFrmSysm0200 = new FormPanel();
			  plFrmSysm0200.setHeadingText("ExTerms Ver1.0 - " + lblSysmConst.main_TitleSysm0200());
			  plFrmSysm0200.setIcon(Resources.APP_ICONS.text());
			  plFrmSysm0200.setBodyStyleName("pad-text");
			  plFrmSysm0200.setFrame(false); 
					
			    RowNumberer numberer = new RowNumberer();  

	            List<ColumnConfig> listColumnConfigs = new ArrayList<ColumnConfig>();

	            listColumnConfigs.add(numberer);
	          
	            
	            /** column 메뉴명 : mnuNm */
	            listColumnConfigs.add(new ColumnConfig( SysIfSysm0200BM.ATTR_MNUNM, "메뉴", 300){
	            	{
	            		setRenderer(new TreeGridCellRenderer<BaseModel>());
	            	}
	            });
	            /** column 메뉴아이콘 : mnuIcn */
	            listColumnConfigs.add(new ColumnConfig( SysIfSysm0200BM.ATTR_MNUICN,"아이콘", 180 ){
	            	{

	            	}
	            });
	            /** column 메뉴썸네일 : mnuTmbl */
	            listColumnConfigs.add(new ColumnConfig( SysIfSysm0200BM.ATTR_MNUTMBL,"썸네일",  180 ){
	            	{

	            	}
	            });
	            
	            /** column 메뉴화면폼패키지명 : mnuScnFrmPkgNm */
	            listColumnConfigs.add(new ColumnConfig(SysIfSysm0200BM.ATTR_MNUSCNFRMPKGNM,"패키지명",  180 ){
	            	{

	            	}
	            });
	            
	            /** column 메뉴출력순서 : mnuPrntOrd */
	            listColumnConfigs.add(new ColumnConfig(SysIfSysm0200BM.ATTR_MNUPRNTORD, "순서", 90 ){
	            	{

	            	}
	            }); 

//	            listColumnConfigs.add(new ColumnConfig("title", MSFMainApp.ADMINCONSTANTS.Titolo(), 300){
//	                {
//	                    
//	                }
//	            });
//	            listColumnConfigs.add(new ColumnConfig("iconcls",   MSFMainApp.ADMINCONSTANTS.Icona(),    180));
//	            listColumnConfigs.add(new ColumnConfig("thumbnail", MSFMainApp.ADMINCONSTANTS.Immagine(), 180));
//	            listColumnConfigs.add(new ColumnConfig("screen",    MSFMainApp.ADMINCONSTANTS.Pannello(), 180));
//	            listColumnConfigs.add(new ColumnConfig("ord",       MSFMainApp.ADMINCONSTANTS.Ordine(),    80));

	            final ColumnModel columnModel = new ColumnModel(listColumnConfigs);

	            store = new TreeStore<BaseModel>();

	            grid = new TreeGrid<BaseModel>(store, columnModel);
	            grid.setStripeRows(true);  
	            grid.setAutoExpandColumn("mnuScnFrmPkgNm"); 

	            final GridSelectionModel<BaseModel> sm = new GridSelectionModel<BaseModel>();
	            grid.setSelectionModel(sm);  
	            grid.addListener(Events.CellClick, new Listener<BaseEvent>() {            
	                public void handleEvent(BaseEvent be) {
	                    setRecord(sm.getSelectedItem());
	                }
	            });
//	            grid.addListener(Events.DoubleClick, new Listener<BaseEvent>() {            
//	                public void handleEvent(BaseEvent be) {
//	                    doAction(ActionDatabase.UPDATE);   
//	                }
//	            });
	            grid.addPlugin(numberer);
	            store.addListener(Events.Add, new Listener<BaseEvent>() {
	                public void handleEvent(BaseEvent be) {
	                    TreeModel parent = (TreeModel) MSFMainApp.getClientSession().get("treeParent");
	                    if (parent != null && store != null) {
	                        BaseModel bm = store.findModel("name", parent.get("name"));
	                    }
	                }
	            });
	            grid.setSize("970px", "610px");
	            grid.setBorders(true);
	            
	            new TreeGridDragSource(grid);  

	            target = new TreeGridDropTarget(grid);  
	            target.setAllowSelfAsSource(true);  
	            target.setFeedback(Feedback.BOTH);
	            target.addDNDListener(new DNDListener(){
	                public void dragDrop(DNDEvent e) {
	                    super.dragDrop(e);
	                    Object obj = e.getData();
	                    if (obj instanceof ArrayList) {
	                        List<BaseTreeModel> list = (List<BaseTreeModel>) obj;
	                        for (BaseTreeModel model : list) {
	                            BaseTreeModel btm = model.get("model");
	                            TreeModel parent = btm.getParent();
	                            MSFMainApp.getClientSession().addAttribute("treeParent", parent);
	                        }
	                    }
	                }
	            });

//	            ToolBar bar = new ToolBar();  
//	            bar.add(new LabelToolItem(MSFMainApp.MSFCONSTANTS.Filtro()));  
//
//	            StoreFilterField<BaseModel> field = new StoreFilterField<BaseModel>() {  
//
//	                @Override  
//	                protected void onFilter() {  
//	                    super.onFilter();  
//
//	                }
//
//	                protected boolean doSelect(Store<BaseModel> store,
//	                        BaseModel parent, BaseModel record, String property,
//	                        String filter) {
//	                    if (MSFSharedUtils.allowNulls(record.get("mnuNm")).toLowerCase().indexOf(filter.toLowerCase()) != -1) {  
//	                        return true;  
//	                    }  
//	                    return false;  
//	                }  
//
//	            };  
//	            field.setWidth(100);  
//	            field.bind(store);  		
//	            bar.add(field);  
	            //	            
//	            plFrmSysm0200.setTopComponent(bar);

	              
	            ToolBar bottomToolbar = new ToolBar();  
	            bottomToolbar.add(new FillToolItem());

	            Button refresh = new Button(MSFMainApp.MSFCONSTANTS.BtRefresh());
	            refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
	            refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) {  
	                    reload();  
	                }  
	            });
	            bottomToolbar.add(refresh);

//	            insertButton = new Button(MSFMainApp.MSFCONSTANTS.BtNuovo());
//	            insertButton.setIcon(MSFMainApp.ICONS.add());
//	            insertButton.addSelectionListener(selectionListener);
//	            bottomToolbar.add(insertButton);
//
//	            updateButton = new Button(MSFMainApp.MSFCONSTANTS.BtModification());
//	            updateButton.setIcon(MSFMainApp.ICONS.edit());
//	            updateButton.addSelectionListener(selectionListener);
//	            bottomToolbar.add(updateButton);
//
//	            deleteButton = new Button(MSFMainApp.MSFCONSTANTS.BtCancel());
//	            deleteButton.setIcon(MSFMainApp.ICONS.delete());
//	            deleteButton.addSelectionListener(selectionListener);
//	            bottomToolbar.add(deleteButton);

	            
	            plFrmSysm0200.setBottomComponent(bottomToolbar);  
	            plFrmSysm0200.add(grid);
	             readVociMenu();	 
					    
				vp.add(plFrmSysm0200);
				plFrmSysm0200.setSize("990px", "680px");
		}		
	  
	  /**
	   * @wbp.parser.constructor
	   */
	  public Sysm0200() {
			setSize("1010px", "700px");  
	  } 
	
	  public Sysm0200(String txtForm) {
			this.txtForm = txtForm;
	  }
	
 
	    private SelectionListener<ButtonEvent> selectionListener = 
	        new SelectionListener<ButtonEvent>() {
	        public void componentSelected(ButtonEvent ce) { 
	            if (ce.getButton() == insertButton) {
	                doAction(ActionDatabase.INSERT);
	            } else if (ce.getButton() == updateButton) {
	                doAction(ActionDatabase.UPDATE);
	            } else if (ce.getButton() == deleteButton) {
	                doAction(ActionDatabase.DELETE);
	            }

	        }  
	    };

	    private void doAction(ActionDatabase actionDatabase) {
//	        switch (actionDatabase) {
//	        case INSERT:
//	            NoticeBoardForm caricaVmn = new NoticeBoardForm(ActionDatabase.INSERT, getThis());
//	            MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
//	            w.show(); 
//	            caricaVmn.setMSFFormWindows(w);
//	            caricaVmn.bind(new BaseModel());
//	            caricaVmn.pulisci();
//	            break;
//	        case UPDATE:
//	            caricaVmn = new NoticeBoardForm(ActionDatabase.UPDATE, getThis());  	 
//	            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtModification(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
//	            w.show();
//	            caricaVmn.setMSFFormWindows(w);
//	            caricaVmn.bind(record);	   
//	            break;
//	        case DELETE:
//	            caricaVmn = new NoticeBoardForm(ActionDatabase.DELETE, getThis());  	 
//	            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtCancel(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtCancel(),MSFMainApp.MSFCONSTANTS.BtDelete());
//	            w.show();  
//	            caricaVmn.setMSFFormWindows(w);
//	            caricaVmn.bind(record);	            	
//	            break;
//	        }
	    }

	    private void readVociMenu(){
	        grid.mask(MSFMainApp.MSFMESSAGES.LoadingData());
	        //LOOP QUESTIONARI
	        sysm0200Service.getListSysm0200Menu(new AsyncCallback<List<SysIfSysm0200BM>>(){
	            public void onFailure(Throwable caught) {
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListSysm0200Menu(): "+caught), null);
	            }

	            public void onSuccess(List<SysIfSysm0200BM> result) {
	                composeListaVociMenu(result);
	            }
	        });
	    }

	    private void composeListaVociMenu(List<SysIfSysm0200BM> listaMenu) {
	        Iterator<SysIfSysm0200BM> iter = listaMenu.iterator();
	        BaseTreeModel folder = new BaseTreeModel();
	        BaseTreeModel category = null;
	        while ( iter.hasNext() ) {
	        	SysIfSysm0200BM mnu = iter.next();
	            Integer ord = new Integer(mnu.getMnuPrntOrd());
	            BaseTreeModel bm = new BaseTreeModel();
	            bm.set("sysDivCd", mnu.getSysDivCd());
	            bm.set("mnuCd", mnu.getMnuCd());
	            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
	            bm.set("mnuNm", mnu.getMnuNm());
	            bm.set("mnuIcn", mnu.getMnuIcn()); 
	            bm.set("mnuTmbl", mnu.getMnuTmbl());
	            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
	            bm.set("mnuTipNm", mnu.getMnuTipNm());
	            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
	            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
	            bm.set("mnuPrntOrd", ord);
	            bm.set("useYn", mnu.getUseYn());
	            bm.set("mnuEpln", mnu.getMnuEpln());
	             
	            if (mnu.getHhrkMnuCd() == null) {
	                category = new BaseTreeModel();
	                category.setProperties(bm.getProperties());
	                folder.add(category);
	            } else {
	                if (category != null) {
	                    category.add(bm);
	                }
	            }
	        }
	        store.removeAll();
	        store.add(folder, true);
	        grid.unmask();
	        grid.expandAll();
	    }

	    public String getIntro() {
	        return null;
	    }

	    public void setRecord(BaseModel record) {
	        this.record = record;
	    }

	    @Override
	    public void reload() {
	        readVociMenu();
	    }

	    private Sysm0200 getThis(){
	        return this;
	    }
	     
}
