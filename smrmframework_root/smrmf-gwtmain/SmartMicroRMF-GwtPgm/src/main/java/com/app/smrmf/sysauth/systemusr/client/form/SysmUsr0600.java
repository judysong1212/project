package com.app.smrmf.sysauth.systemusr.client.form;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.VoceMenuUser;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.model.model.Folder;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0400BM;
import com.app.smrmf.sysauth.system.client.form.defs.Sysm0300Def;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0400Service;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0400ServiceAsync;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treegrid.EditorTreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysmUsr0600  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	  private VerticalPanel vp;
	  private FormPanel plFrmSysm0400;
	  private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  
    private EditorTreeGrid<SysIfSysm0400BM> treePanel;
    private SysmUsr0400ServiceAsync sysm0400Service = SysmUsr0400Service.Util.getInstance();
    private SysIfSysm0300DTO prf;
    private TreeStore<BaseModel> store;
    private Button saveButton;
    private Button cancelButton;
    private MSFGridPanel msfGridPanel;
 
    private TextField<String> authGrpNm;         //권한그룹명
    
	  public ContentPanel getViewPanel(){
			if(panel == null){
			
				   detailTp = XTemplate.create(getDetailTemplate());
				    
				    formData = new FormData("-650");
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				    createSysm0400Form();  //화면 기본정보를 설정
				 //   createSearchForm();    //검색필드를 적용
				 //   createStandardForm();    //기본정보필드 
				 //   createTabForm();       //탭구성
				    vp.setSize("1010px", "700px");
				            
				panel = new ContentPanel();
		        panel.setBodyBorder(false);
		        panel.setBorders(false);
		        panel.setHeaderVisible(false);
		        panel.setScrollMode(Scroll.AUTO);  
		        panel.add(vp);
		        
		        
			}
			return panel;
		}
	  
	  /**
	   * @wbp.parser.constructor
	   */
	  public SysmUsr0600() {
			setSize("1010px", "700px");  
	  } 
	
	  public SysmUsr0600(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createSysm0400Form() {
		  
		plFrmSysm0400 = new FormPanel();
		plFrmSysm0400.setHeadingText("ExTerms Ver1.0 - 권한그룹관리");
		plFrmSysm0400.setIcon(MSFMainApp.ICONS.text());
		plFrmSysm0400.setBodyStyleName("pad-text");
		plFrmSysm0400.setPadding(2);
		plFrmSysm0400.setFrame(true); 
		 
		
		  HorizontalPanel inner = new HorizontalPanel();
          inner.setBorders(false);

          Sysm0300Def sysm0300Def = new Sysm0300Def();
          sysm0300Def.setReadOnly(true);
          msfGridPanel = new MSFGridPanel(sysm0300Def, false, false, false);
          msfGridPanel.setSize(400, 600);
          msfGridPanel.setBorders(true);
          msfGridPanel.getGrid().setBorders(true);
          Grid grid = msfGridPanel.getMsfGrid().getGrid();
          grid.addListener(Events.CellClick, new Listener<BaseEvent>() {
              public void handleEvent(BaseEvent be) {
                   treePanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
                   prf = new SysIfSysm0300DTO();
                   prf.setAuthGrpSeilNum(Long.parseLong((msfGridPanel.getMsfGrid().getCurrentlySelectedItem().get("authGrpSeilNum").toString())));
                   clearTree();
                   readVociMenuProfile(prf);
              }
          });
          
         
          
          //검색조건 
          
            LayoutContainer  lycSreach = new LayoutContainer(); 
            FormLayout frmlytStd = new FormLayout();  
	   	    frmlytStd.setLabelWidth(0);  
	   	    lycSreach.setLayout(frmlytStd);
	        lycSreach.setHeight(30); 
	  	    
	        LayoutContainer layoutContainer_12 = new LayoutContainer();
	   	    layoutContainer_12.setLayout(new ColumnLayout());
	   	    layoutContainer_12.setStyleAttribute("paddingTop", "5px");
	   	    
	      
	   	    LayoutContainer layoutContainer_13 = new LayoutContainer();
	   	    frmlytStd = new FormLayout();  
	   	    frmlytStd.setLabelWidth(80); 
	   	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   	    layoutContainer_13.setLayout(frmlytStd);
	   	   
	   	    authGrpNm = new TextField<String>(); 
	     	authGrpNm.setFieldLabel("권한그룹명");
	   	    layoutContainer_13.add(authGrpNm, new FormData("100%")); 
	   	    layoutContainer_13.setBorders(false);
	   	
	   	    Button btnUsrSearch = new Button("검색");
	   	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
	    	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
	   	    	public void handleEvent(ButtonEvent e) { 
	   	    		reload(); 
	   	    	}
	   	    });
	 	    
	   	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   	    layoutContainer_12.add(btnUsrSearch );
	   	    lycSreach.add(layoutContainer_12);
 	     
	       msfGridPanel.setTopComponent(lycSreach);

          inner.add(msfGridPanel);

          ContentPanel columnTwo = new ContentPanel(); 
          columnTwo.setHeight(600);
          columnTwo.setWidth(550);
          columnTwo.setId("columnTwoPU");
          columnTwo.setHeadingText(MSFMainApp.ADMINCONSTANTS.VoceMenu());
          columnTwo.setStyleAttribute("paddingLeft", "10px");
          columnTwo.setLayout(new FitLayout());

          ColumnConfig name = new ColumnConfig("mnuNm", MSFMainApp.ADMINCONSTANTS.VoceMenu(), 200);
          name.setRenderer(new TreeGridCellRenderer<VoceMenuUser>());

          CheckColumnConfig checkVisible = new CheckColumnConfig("mnuUseYn", "화면", 40);
          checkVisible.setEditor(new CellEditor(new CheckBox()));
 
          CheckColumnConfig checkSearch = new CheckColumnConfig("mnuAuthGrPScnInqyYn", "조회", 40);
          checkSearch.setEditor(new CellEditor(new CheckBox()));
          
          CheckColumnConfig checkInsert = new CheckColumnConfig("mnuAuthGrPScnInptYn", "입력", 40);
          checkInsert.setEditor(new CellEditor(new CheckBox()));

          CheckColumnConfig checkUpdate = new CheckColumnConfig("mnuAuthGrPScnRevnYn", "수정", 40);
          checkUpdate.setEditor(new CellEditor(new CheckBox()));

          CheckColumnConfig checkDelete = new CheckColumnConfig("mnuAuthGrPScnDelYn", "삭제", 40);
          checkDelete.setEditor(new CellEditor(new CheckBox()));
            
          CheckColumnConfig checkPrint = new CheckColumnConfig("mnuAuthGrPScnPrtYn", "출력", 40);
          checkPrint.setEditor(new CellEditor(new CheckBox()));
        

          ColumnModel cm = new ColumnModel(Arrays.asList(name, checkVisible, checkSearch,checkInsert,checkUpdate, checkDelete,checkPrint));
          store = new TreeStore<BaseModel>();  

          final RowEditor<VoceMenuUser> re = new RowEditor<VoceMenuUser>(){ protected void positionButtons() {
	        	  if(isRendered()){
	        		  	super.positionButtons();
	        	  }
          }
          };
         // RowEditor<ModelData> rowEdit = new RowEditor<ModelData>()
          treePanel = new EditorTreeGrid<SysIfSysm0400BM>(store, cm);
          treePanel.setAutoWidth(true);
          //treePanel.setHeight(600);
          treePanel.setBorders(false); 
          treePanel.addPlugin(re);
          treePanel.setAutoExpandColumn("mnuNm");
          columnTwo.add(treePanel);

          ToolBar bottomToolbar = new ToolBar();  
          bottomToolbar.add(new FillToolItem());
          saveButton = new Button(MSFMainApp.MSFCONSTANTS.BtSave());
          saveButton.setIcon(MSFMainApp.ICONS.save16());
          saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
              public void componentSelected(ButtonEvent ce) {  
                  Iterator<Record> iterRecords = store.getModifiedRecords().iterator();
                  while (iterRecords.hasNext()) {
                      Record record = (Record) iterRecords.next();
                      SysIfSysm0400BM v = new SysIfSysm0400BM();
                      if (record.getModel() instanceof Folder) {
                          Folder f = (Folder) record.getModel();
                          v.setProperties(f.getProperties());
                      } else {
                          v = (SysIfSysm0400BM) record.getModel();
                      }
                      insertOrDeleteVociMenuProfile(v);
                  }
                  store.commitChanges();
              }  
          });

        
          bottomToolbar.add(saveButton);
          bottomToolbar.add(new SeparatorMenuItem());

          cancelButton = new Button(MSFMainApp.MSFCONSTANTS.BtDelete());
          cancelButton.setIcon(MSFMainApp.ICONS.cancel());
          cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
              public void componentSelected(ButtonEvent ce) {  
                  if (prf!=null) 
                      readVociMenuProfile(prf);
              }  
          });

          bottomToolbar.add(cancelButton);
          columnTwo.setBottomComponent(bottomToolbar);

          inner.add(columnTwo);
		
          plFrmSysm0400.add(inner);
		 
		    
		vp.add(plFrmSysm0400);
		plFrmSysm0400.setSize("990px", "680px");
	  }
	   
 

	    private void clearTree() {
	        store.removeAll();
	    }  

	    private ActionDatabase actionDatabase;
	    private void insertOrDeleteVociMenuProfile(final SysIfSysm0400BM node) {

	        actionDatabase = ActionDatabase.INSERT;
	        if (node.getAuthGrpSeilNum()!=null && node.getAuthGrpSeilNum()!=0) {
	            if (node.getMnuUseYn()) {
	                actionDatabase = ActionDatabase.UPDATE;
	            } else {
	                actionDatabase = ActionDatabase.DELETE;
	            }
	        } else {
	        	//그룹코드 데이터를 가지고 온다 없으면 스킾
	        	if ( MSFSharedUtils.paramNotNull(prf)) {
	        		node.setAuthGrpSeilNum(prf.getAuthGrpSeilNum());
	        	} else {
	        		return;
	        	}
	         
	        }
	        
//	        sysm0400Service.activityOnVoceMenuProfile(node, actionDatabase, new AsyncCallback<String>(){
//	            public void onFailure(Throwable caught) {
//	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnVoceMenuProfile(): "+caught), null);
//	            }
//
//	            public void onSuccess(String result) {
//	                if (result.compareTo("0")==0) {
//	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnVoceMenuProfile()"), null);
//	                } else {
//	                    switch (actionDatabase) {
//	                    case INSERT:
//	                        node.setMnuCd(result);
//	                        break;
//	                    default:
//	                        node.setMnuCd(null);
//	                        break;
//	                    }
//	                    store.commitChanges();
//	                	if ( MSFSharedUtils.paramNotNull(prf)) {
//	                		readVociMenuProfile(prf);
//	    	        	} 
//	                }
//	            }
//	        });
     }	

	    private void readVociMenuProfile(SysIfSysm0300DTO prf){
//	    	sysm0400Service.getListaVociMenuProfile(prf, new AsyncCallback<List<SysIfSysm0400BM>>(){
//	            public void onFailure(Throwable caught) {
//	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListaVociMenuProfile(): "+caught), null);
//	            }
//
//	            public void onSuccess(List<SysIfSysm0400BM> result) {
//	              setTreeNav(result);
//	            }
//	        });
	    }

	    public void setTreeNav(List<SysIfSysm0400BM> listaVmn) {
	        Iterator<SysIfSysm0400BM> iter = listaVmn.iterator();
	        Folder folder = new Folder(MSFMainApp.ADMINCONSTANTS.Menu());
	        Folder category = null;
	        while ( iter.hasNext() ) {
	            final SysIfSysm0400BM voce = (SysIfSysm0400BM) iter.next();
	            if (voce.getHhrkMnuCd() == null) {
	                category = new Folder(voce.getMnuNm());
	                category.setProperties(voce.getProperties());
	                folder.add(category);
	            } else {
	                if (category != null) {
	                	BaseModel bmVoce = new BaseModel();
	                	bmVoce.setProperties(voce.getProperties());
	                    category.add(bmVoce);
	                }
	            }
	        }
	        store.removeAll();
	        store.add(folder, true);
	        treePanel.unmask();
	        treePanel.expandAll();
	    }

	    public String getIntro() {
	        return null;
	    }

	    @Override
	    public void reload() {
//	    	if ( MSFSharedUtils.paramNull(usrNm.getValue())) {
//   		 MessageBox.alert("검색오류", 
//   				 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("성명을 선택하십시요."), null); 
//   		usrNm.focus();
//   	} else {
   		IColumnFilter filters = null;
       	msfGridPanel.getTableDef().setTableColumnFilters(filters);
   		 
       	msfGridPanel.getTableDef().addColumnFilter("authGrpNm", MSFSharedUtils.defaultNulls(authGrpNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
        msfGridPanel.reload();
//   	}
	       
	    }

	    private SysmUsr0600 getThis(){
	        return this;
	    }
	  
	  public native String getDetailTemplate() /*-{
	    return ['<div class="details">',
	    '<tpl for=".">',
	    '<img src="{modPath}"><div class="details-info">',
	    '<b>Image Name:</b>',
	    '<span>{name}</span>',
	    '<b>Size:</b>',
	    '<span>{sizeString}</span>',
	    '<b>Last Modified:</b>',
	    '<span>{dateString}</span></div>',
	    '</tpl>',
	    '</div>'].join("");
	  }-*/;


}
