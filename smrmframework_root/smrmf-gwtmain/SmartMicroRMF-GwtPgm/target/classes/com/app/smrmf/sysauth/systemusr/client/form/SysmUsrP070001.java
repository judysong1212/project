package com.app.smrmf.sysauth.systemusr.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0500DTO;
import com.app.smrmf.sysauth.system.client.form.defs.Sysm0100Def;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0500Service;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0500ServiceAsync;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
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
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysmUsrP070001  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	    private VerticalPanel vp;
	    private FormPanel plFrmSysm0500;
	    private FormData formData; 
	    private String txtForm = ""; 
	  
	  
	    private ListStore<BaseModel> lsSysm0500;
	    private ListStore<BaseModel> lsSysm0300;
	    private SysmUsr0500ServiceAsync sysm0500Service = SysmUsr0500Service.Util.getInstance();
	    private Grid<BaseModel> gridSysm0500;
	    private Grid<BaseModel> gridSysm0300;
	    private Button btnSysm0500Save;
	    private Button btnSysm0500Cancel;
	    private Button btnSysm0300Save;
	    private Button btnSysm0300Cancel;
	    private SysIfSysm0100BM usrSysm0100Bm;
	    
	    private Sysm0100Def sysm0100Def = new Sysm0100Def("SYSM0500");
	    private MSFGridPanel msfGdPaneSysm0100;
	    private TextField<String> usrNm ;
	  
 
	  
    public ContentPanel getViewPanel() {
        if (panel == null) {
        	
            panel = new ContentPanel();
           // panel.setLayout(new FitLayout());  
            panel.setBodyBorder(false);
            panel.setBorders(false);
            panel.setHeaderVisible(false);
            panel.setScrollMode(Scroll.AUTO); 
            
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createSysm0500Form();  //화면 기본정보를 설정 
		    vp.setSize("1010px", "700px");
            
         
            panel.add(vp);
        }
        return panel;
    } 	    
 		  
			  /**
			   * @wbp.parser.constructor
			   */
			  public SysmUsrP070001() {
					setSize("1010px", "700px");  
			  } 
			
			  public SysmUsrP070001(String txtForm) {
					this.txtForm = txtForm;
			  }
			  
			  private void createSysm0500Form() {
				  
				plFrmSysm0500 = new FormPanel();
				plFrmSysm0500.setHeadingText("ExTerms Ver1.0 - 메뉴권한그룹관리");
				plFrmSysm0500.setIcon(Resources.APP_ICONS.text());
				plFrmSysm0500.setBodyStyleName("pad-text");
				plFrmSysm0500.setPadding(2);
				plFrmSysm0500.setFrame(true); 
				
				  
				    HorizontalPanel inner = new HorizontalPanel();
		            inner.setBorders(false);
		            inner.setLayout(new FitLayout());
 
		            sysm0100Def.setReadOnly(true);   
		            msfGdPaneSysm0100 = new MSFGridPanel(sysm0100Def, false, false, false); 
		        
		            msfGdPaneSysm0100.setSize(400, 620);
		            msfGdPaneSysm0100.setBorders(true);
		            msfGdPaneSysm0100.getGrid().setBorders(true);
		            Grid grid = msfGdPaneSysm0100.getMsfGrid().getGrid();
		            grid.addListener(Events.CellClick, new Listener<BaseEvent>() {
		                public void handleEvent(BaseEvent be) {
		                    gridSysm0500.mask(MSFMainApp.MSFMESSAGES.LoadingData());
		                    usrSysm0100Bm = new SysIfSysm0100BM(); 
		                    usrSysm0100Bm.setUsrId(msfGdPaneSysm0100.getMsfGrid().getCurrentlySelectedItem().get("usrId").toString());
		                    readSysm0500(usrSysm0100Bm);
		                    readSysm0300(usrSysm0100Bm);
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
		     	    frmlytStd.setLabelWidth(60); 
		     	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		     	    layoutContainer_13.setLayout(frmlytStd);
		     	   
		     	    usrNm = new TextField<String>();
		     	    usrNm.setFieldLabel("성 명");
		     	    usrNm.addKeyListener(new KeyListener() {
		               public void componentKeyUp(ComponentEvent event) {
		                   super.componentKeyUp(event);
		                   usrNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                       reSysmload(); 
		                   }
		               }
		           });

		     	    
		     	    layoutContainer_13.add(usrNm, new FormData("100%")); 
		     	    layoutContainer_13.setBorders(false);
		     	
		     	    Button btnUsrSearch = new Button("검색");
		     	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
		      	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
		     	    	public void handleEvent(ButtonEvent e) { 
		     	    		reSysmload(); 
		     	    	}
		     	    });
		   	    
		     	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		     	    layoutContainer_12.add(btnUsrSearch );
		     	    lycSreach.add(layoutContainer_12);
		     	     
		     	   msfGdPaneSysm0100.setTopComponent(lycSreach);
		            
		            inner.add(msfGdPaneSysm0100);
		            
		            LayoutContainer  lcLeftGrid = new LayoutContainer();  
		            frmlytStd = new FormLayout();  
		     	    frmlytStd.setLabelWidth(0);  
		     	    lcLeftGrid.setLayout(frmlytStd);
		            lcLeftGrid.setBorders(false);
		            inner.add(lcLeftGrid);  
		            
		            /*****************************상단 **************************************/
		            ContentPanel cpSysm0500 = new ContentPanel(); 
		            cpSysm0500.setHeight(300);
		            cpSysm0500.setId("cpSysm0500");
		            cpSysm0500.setHeadingText("사용 권한그룹");
		            cpSysm0500.setStyleAttribute("paddingLeft", "2px");

		            List<ColumnConfig> listCCSysm0500 = new ArrayList<ColumnConfig>();
		            listCCSysm0500.add(new ColumnConfig() {
		                {
		                	setHeaderText("사용자");
		                    setSortable(true);
		                    setId("usrId");
		                    setWidth(70);
		                }
		            });
		            listCCSysm0500.add(new ColumnConfig() {
		                {
		                	setHeaderText("성명");
		                    setSortable(true);
		                    setId("usrNm");
		                    setWidth(90);
		                }
		            });
		            listCCSysm0500.add(new ColumnConfig() {
		                {
		                	setHeaderText("그룹");
		                    setSortable(true);
		                    setId("authGrpSeilNum");
		                    setWidth(60);
		                }
		            });
		            listCCSysm0500.add(new ColumnConfig() {
		                {
		                	setHeaderText("권한그룹명");
		                    setSortable(true);
		                    setId("authGrpNm");
		                    setWidth(200);
		                }
		            });
		            CheckColumnConfig checkSysm0500 = new CheckColumnConfig("usrAuthUseYn", "사용", 40);
		            checkSysm0500.setEditor(new CellEditor(new CheckBox()));
		            listCCSysm0500.add(checkSysm0500);  
		            
		            
		            
		            //setup column model
		            ColumnModel columnModelSysm0500 = new ColumnModel(listCCSysm0500);

		            lsSysm0500 = new ListStore<BaseModel>();  
		            gridSysm0500 = new EditorGrid<BaseModel>(lsSysm0500, columnModelSysm0500);
		            gridSysm0500.setStripeRows(true);  
		            gridSysm0500.setWidth(560);
		            gridSysm0500.setHeight(300);
		           // gridSysm0500.setAutoHeight(true);
		            gridSysm0500.setLoadMask(true); 
		            gridSysm0500.setBorders(true);
		            gridSysm0500.addPlugin(checkSysm0500);
		           

		            ToolBar btmSysm0500Tbar = new ToolBar();  
		            btmSysm0500Tbar.add(new FillToolItem());
		            btnSysm0500Save = new Button(MSFMainApp.MSFCONSTANTS.BtDelete());
		            btnSysm0500Save.setIcon(MSFMainApp.ICONS.delete16());
		            btnSysm0500Save.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                    Iterator<Record> iterRecords = lsSysm0500.getModifiedRecords().iterator();
		                    while (iterRecords.hasNext()) {
		                        Record record = (Record) iterRecords.next();
		                        updateSysm0500Save((BaseModel) record.getModel());
		                    }
		                    lsSysm0500.commitChanges();
		                }  
		            });

		            btmSysm0500Tbar.add(btnSysm0500Save);
//		            btmSysm0500Tbar.add(new SeparatorMenuItem());
//
//		            btnSysm0500Cancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete());
//		            btnSysm0500Cancel.setIcon(MSFMainApp.ICONS.cancel());
//		            btnSysm0500Cancel.addSelectionListener(new SelectionListener<ButtonEvent>() {
//		                public void componentSelected(ButtonEvent ce) {  
//		                if (usrSysm0100Bm!=null) 
//		                        readSysm0500(usrSysm0100Bm);
//		                }  
//		            });
//
//		            btmSysm0500Tbar.add(btnSysm0500Cancel);
		            btmSysm0500Tbar.add(new SeparatorMenuItem());

		            Button refresh = new Button(MSFMainApp.MSFCONSTANTS.BtOrdinamento());
		            refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		            refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                    gridSysm0500.clearState();  
		                }  
		            });
		            btmSysm0500Tbar.add(refresh);

		            cpSysm0500.setBottomComponent(btmSysm0500Tbar);  			

		            cpSysm0500.add(gridSysm0500);  	        
		           /*****************************상단 **************************************/
		            lcLeftGrid.add(cpSysm0500);
		            /*****************************하단  **************************************/
		            ContentPanel cpSysm0300 = new ContentPanel(); 
		            cpSysm0300.setHeight(300);
		            cpSysm0300.setId("cpSysm0300");
		            cpSysm0300.setHeadingText("미사용 권한그룹");
		            cpSysm0300.setStyleAttribute("paddingLeft", "2px");

		            List<ColumnConfig> listCCSysm0300 = new ArrayList<ColumnConfig>();
		            listCCSysm0300.add(new ColumnConfig() {
		                {
		                	setHeaderText("그룹");
		                    setSortable(true);
		                    setId("authGrpSeilNum");
		                    setWidth(60);
		                }
		            }); 
		            listCCSysm0300.add(new ColumnConfig() {
		                {
		                	setHeaderText("시스템업무");
		                    setSortable(true);
		                    setId("businDivCd");
		                    setWidth(100);
		                }
		            });
		            listCCSysm0300.add(new ColumnConfig() {
		                {
		                	setHeaderText("권한그룹명");
		                    setSortable(true);
		                    setId("authGrpNm");
		                    setWidth(250);
		                }
		            });
		            CheckColumnConfig checkSysm0300 = new CheckColumnConfig("usrAuthUseYn", "사용", 40);
		            checkSysm0300.setEditor(new CellEditor(new CheckBox()));
		            listCCSysm0300.add(checkSysm0300);  
		            
		            
		            //setup column model
		            ColumnModel columnModelSysm0300 = new ColumnModel(listCCSysm0300);
 
		            lsSysm0300 = new ListStore<BaseModel>();  
		            gridSysm0300 = new EditorGrid<BaseModel>(lsSysm0300, columnModelSysm0300);
		            gridSysm0300.setStripeRows(true);  
		            gridSysm0300.setWidth(560);
		            gridSysm0300.setHeight(300);
		           // gridSysm0300.setAutoHeight(true);
		            gridSysm0300.setLoadMask(true); 
		            gridSysm0300.setBorders(true);
		            gridSysm0300.addPlugin(checkSysm0300);
		           

		            ToolBar btmSysm0300Tbar = new ToolBar();  
		            btmSysm0300Tbar.add(new FillToolItem());
		            btnSysm0300Save = new Button(MSFMainApp.MSFCONSTANTS.BtSave());
		            btnSysm0300Save.setIcon(MSFMainApp.ICONS.save16());
		            btnSysm0300Save.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                    Iterator<Record> iterRecords = lsSysm0300.getModifiedRecords().iterator();
		                    while (iterRecords.hasNext()) {
		                        Record record = (Record) iterRecords.next();
		                        updateSysm0300Save((BaseModel) record.getModel());
		                    }
		                    lsSysm0300.commitChanges();
		                }  
		            });

		            btmSysm0300Tbar.add(btnSysm0300Save);
//		            btmSysm0300Tbar.add(new SeparatorMenuItem());
//
//		            btnSysm0300Cancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete());
//		            btnSysm0300Cancel.setIcon(MSFMainApp.ICONS.cancel());
//		            btnSysm0300Cancel.addSelectionListener(new SelectionListener<ButtonEvent>() {
//		                public void componentSelected(ButtonEvent ce) {  
//		                if (usrSysm0100Bm!=null) 
//		                        readSysm0300(usrSysm0100Bm);
//		                }  
//		            });
//
//		            btmSysm0300Tbar.add(btnSysm0300Cancel);
		            btmSysm0300Tbar.add(new SeparatorMenuItem());

		            Button refresh3 = new Button(MSFMainApp.MSFCONSTANTS.BtOrdinamento());
		            refresh3.setIcon(MSFMainApp.ICONS.actionRefresh());
		            refresh3.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                    gridSysm0300.clearState();  
		                }  
		            });
		            btmSysm0300Tbar.add(refresh3);

		            cpSysm0300.setBottomComponent(btmSysm0300Tbar);  			

		            cpSysm0300.add(gridSysm0300);  	        
		         /*****************************하단 **************************************/
		            
               
                 lcLeftGrid.add(cpSysm0300);
		            
		        plFrmSysm0500.add(inner);
				vp.add(plFrmSysm0500);
				plFrmSysm0500.setSize("990px", "680px");
			  }
	 
			    
    private void updateSysm0500Save(BaseModel record) {
        ActionDatabase actionDatabase = ActionDatabase.INSERT;
        SysIfSysm0500DTO sysm0500Dto = new SysIfSysm0500DTO( 
        		record.get("sysDivCd").toString(),
                Long.parseLong(record.get("authGrpSeilNum").toString()),   
                record.get("authGrpNm").toString(),
                usrSysm0100Bm.getUsrId(), 
                usrSysm0100Bm.getUsrNm(), 
                record.get("usrAuthUseYn").toString().equals("true")?true:false);
       // if (MSFSharedUtils.paramNotNull(record.get("usrId"))) {
            actionDatabase = ActionDatabase.DELETE;
            sysm0500Dto.setUsrId(record.get("usrId").toString());
       // }
            //todo 임시주석 
//        sysm0500Service.activityOnSysm0500User(sysm0500Dto, actionDatabase, new AsyncCallback<Long>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnProfilesUser(): "+caught), null);
//            }
//
//            public void onSuccess(Long result) {
//                if (result.compareTo(new Long(0))==0) {
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("in activityOnProfilesUser()"), null);
//                } else {
//                	 Info.display("권한설정", "{0}가 정상처리되었습니다.",new Params("처리"));  
//                	 if (usrSysm0100Bm!=null)   readSysm0500(usrSysm0100Bm);
//                	 if (usrSysm0100Bm!=null)   readSysm0300(usrSysm0100Bm);
//	                 
//                }
//            }
//        });
    }	 
	
		private void updateSysm0300Save(BaseModel record) {
		ActionDatabase actionDatabase = ActionDatabase.INSERT;
		SysIfSysm0300DTO sysm0300Dto = new SysIfSysm0300DTO( 
				record.get("sysDivCd").toString(),
		        Long.parseLong(record.get("authGrpSeilNum").toString()), 
		        record.get("businDivCd").toString(), 
		        record.get("authGrpNm").toString(),
		        record.get("grde").toString(), 
		        record.get("usrAuthUseYn").toString().equals("true")?true:false,
		        		 record.get("grpEpln").toString(), 		
		        		  usrSysm0100Bm.getUsrId());
		//if (MSFSharedUtils.paramNotNull(record.get("usrId"))) {
		//    actionDatabase = ActionDatabase.DELETE;
		  //  sysm0300Dto.setUsrId(record.get("usrId").toString());
		//}
		//임시주석
//		sysm0500Service.activitySysm0300User(sysm0300Dto, actionDatabase, new AsyncCallback<Long>(){
//		    public void onFailure(Throwable caught) {
//		        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//		                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnProfilesUser(): "+caught), null);
//		    }
//		
//		    public void onSuccess(Long result) {
//		        if (result.compareTo(new Long(0))==0) {
//		            MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//		                    MSFMainApp.ADMINMESSAGES.ExceptionMessageService("in activityOnProfilesUser()"), null);
//		        } else {
//		        	 Info.display("권한설정", "{0}가 정상처리되었습니다.",new Params("처리"));  
//		        	 if (usrSysm0100Bm!=null)   readSysm0500(usrSysm0100Bm);
//		        	 if (usrSysm0100Bm!=null)   readSysm0300(usrSysm0100Bm);
//		             
//		        }
//		    }
//		});
		}	

    private void readSysm0500(SysIfSysm0100BM usrSysm0100Bm){
        gridSysm0500.mask();
//        sysm0500Service.getListaSysm0500User(usrSysm0100Bm, new AsyncCallback<List<SysIfSysm0500DTO>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListaSysm0500User(): "+caught), null);
//            }
//
//            public void onSuccess(List<SysIfSysm0500DTO> result) {
//                gridSysm0500.unmask();
//                composeListSysm0500(result);
//            }
//        });
    }
    
    private void readSysm0300(SysIfSysm0100BM usrSysm0100Bm){
        gridSysm0500.mask();
//        sysm0500Service.getListaSysm0300User(usrSysm0100Bm, new AsyncCallback<List<SysIfSysm0300DTO>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListaSysm0300User(): "+caught), null);
//            }
//
//            public void onSuccess(List<SysIfSysm0300DTO> result) {
//                gridSysm0300.unmask();
//                composeListSysm0300(result);
//            }
//        });
    }

    private void composeListSysm0500(List<SysIfSysm0500DTO> listaPrf) {
        Iterator<SysIfSysm0500DTO> iter = listaPrf.iterator();
        List<BaseModel> list = new ArrayList<BaseModel>();
        while ( iter.hasNext() ) {
        	SysIfSysm0500DTO att = (SysIfSysm0500DTO) iter.next();
            Long prfId = new Long(att.getAuthGrpSeilNum().longValue());
            String id = null;
            if (att.getUsrId()!=null)
                id = att.getUsrId(); 
            BaseModel bm = new BaseModel();
            bm.set("sysDivCd", att.getSysDivCd());
            bm.set("usrId", id);
            bm.set("usrNm", att.getUsrNm());
            bm.set("authGrpSeilNum", prfId);
            bm.set("authGrpNm", att.getAuthGrpNm());
            bm.set("usrAuthUseYn", false);   // att.getUsrAuthUseYn()
            list.add(bm);
        }
        lsSysm0500.removeAll();
        lsSysm0500.add(list);  
        gridSysm0500.repaint();
        lsSysm0500.commitChanges();

    }
    

    private void composeListSysm0300(List<SysIfSysm0300DTO> listSysm0300) {
        Iterator<SysIfSysm0300DTO> iter = listSysm0300.iterator();
        List<BaseModel> list = new ArrayList<BaseModel>();
        while ( iter.hasNext() ) {
        	SysIfSysm0300DTO att = (SysIfSysm0300DTO) iter.next();
            Long prfId = new Long(att.getAuthGrpSeilNum().longValue());
           // String id = null;
           // if (att.getUsrId()!=null)
           //     id = att.getUsrId(); 
            BaseModel bm = new BaseModel();
            bm.set("sysDivCd", att.getSysDivCd());
            bm.set("authGrpSeilNum", prfId);
            bm.set("businDivCd", att.getBusinDivCd()); 
            bm.set("authGrpNm", att.getAuthGrpNm());
            bm.set("grde", att.getGrde());
            bm.set("authGrpUseYn", false);   //att.getAuthGrpUseYn()
            bm.set("grpEpln", att.getGrpEpln());
            list.add(bm);
        }
        lsSysm0300.removeAll();
        lsSysm0300.add(list);  
        gridSysm0300.repaint();
        lsSysm0300.commitChanges();

    }
     

    public String getIntro() {
        return null;
    }
 
    public void reSysmload() {
    	
    	if ( MSFSharedUtils.paramNull(usrNm.getValue())) {
    		 MessageBox.alert("검색오류", 
    				 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("성명을 선택하십시요."), null); 
    		usrNm.focus();
    	} else {
    		IColumnFilter filters = null;
    		msfGdPaneSysm0100.getTableDef().setTableColumnFilters(filters);
    		 
    		msfGdPaneSysm0100.getTableDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(usrNm.getRawValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    		msfGdPaneSysm0100.getTableDef().addColumnFilter("usrDivCd", "D0010070,D0010080", SimpleColumnFilter.OPERATOR_IN); 
    		msfGdPaneSysm0100.getTableDef().addColumnFilter("searchKeyword", "N", SimpleColumnFilter.OPERATOR_EQUALS); 
        	 
    		msfGdPaneSysm0100.reload();
    	}
    
    }
 
    private SysmUsrP070001 getThis(){
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
