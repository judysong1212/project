package com.app.smrmf.sysauth.systemmtr.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfBass0300Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0800DTO;
import com.app.smrmf.sysauth.systemmtr.client.form.defs.SysMtrSysm0300Def;
import com.app.smrmf.sysauth.systemmtr.client.form.defs.SysMtrSysm0800Def;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0500Service;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0500ServiceAsync;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysmMtr0500  extends MSFPanel { 
	
	 /**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
 

     /**######################################################
 	 * { 시스템 기본설정파일 선언부  종료}
 	 *#######################################################*/

  private VerticalPanel vp;
  private FormPanel plFrmSysmMtr0500;
  private FormData formData; 
  private String txtForm = "";
  private XTemplate detailTp;	  
  private SysmMtr0500ServiceAsync sysmMtr0500service = SysmMtr0500Service.Util.getInstance();  
  private Button saveButton;
  private Button saveButton2;	    
  private Button btnSelectSysm0800;
  private Button btnSelectSysm0300;
  private Button btnUnSelectSysm0800;
  private Button btnUnSelectSysm0300; 
  
  private SysIfBass0300Def sysIfBass0300Def = new SysIfBass0300Def("SYSMMTR0500");
  private SysMtrSysm0800Def sysMtrSysm0800Def = new SysMtrSysm0800Def("SYSMMTR0500"); 
  private SysMtrSysm0300Def sysMtrSysm0300Def = new SysMtrSysm0300Def("SYSMMTR0500");

  private MSFGridPanel msfGridPanelSysmMtr0500; 
  private MSFGridPanel msfGridPanelSysm0800;
  private MSFGridPanel msfGridPanelSysm0300;
  private TextField<String> usrDivNm ;  // 부서명 텍스트필드 변수
  private TextField<String> authGrpNm; // 사용직종정보 직종세 통합코드 변수
  private TextField<String> noAuthGrpNm; // 미사용직종정보 직종세 통합코드 변수
  private String usrDivCd;
  
	 
  public ContentPanel getViewPanel() {
    if (panel == null) {        	
      
        
	    vp = new VerticalPanel();
	    vp.setSpacing(10);
	    createSysmMtr0500Form();  //화면 기본정보를 설정
	    vp.setSize("1010px", "700px");    
	    
	    
	    /**
          * Create the relations 
          */
		   final RelationDef  relSysm0800 = new RelationDef(sysIfBass0300Def,false);
		   relSysm0800.addJoinDef("dpobCd", "sysDivCd"); 
		   relSysm0800.addJoinDef("commCd", "usrDivCd"); 
		   relSysm0800.setLinkedObject(msfGridPanelSysmMtr0500);
		   sysMtrSysm0800Def.addRelation(relSysm0800); 
           
//           // DETAILS 
//           final Grid sysMtrSysm0800DefGrid = msfGridPanelSysmMtr0500.getMsfGrid().getGrid();
//           sysMtrSysm0800DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//              public void handleEvent(BaseEvent be) {  
//            	  if (msfGridPanelSysmMtr0500.getCurrentlySelectedItem() != null) { 
//            		 
//            		  sysMtrSysm0800Def.synchronizeGridDetail(
//            				  msfGridPanelSysmMtr0500.getCurrentlySelectedItem(),
//            				  msfGridPanelSysm0800 );
//            		  msfGridPanelSysm0800.reload();
//            	   }
//             
//           }
//         }); 
            
            
           /**
	          * Create the relations 
	          */
			   final RelationDef  relSysm0300 = new RelationDef(sysIfBass0300Def,false);
			   relSysm0300.addJoinDef("dpobCd", "sysDivCd"); 
			   relSysm0300.addJoinDef("commCd", "usrDivCd"); 
			   relSysm0300.setLinkedObject(msfGridPanelSysmMtr0500);
			   sysMtrSysm0300Def.addRelation(relSysm0300); 
	           
	 
	           // DETAILS 
	           final Grid sysMtrSysm0300DefGrid = msfGridPanelSysmMtr0500.getMsfGrid().getGrid();
	           sysMtrSysm0300DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	              public void handleEvent(BaseEvent be) {  
	            	  if (msfGridPanelSysmMtr0500.getCurrentlySelectedItem() != null) {  
	            		  
	            		  sysMtrSysm0800Def.synchronizeGridDetail(
	            				  msfGridPanelSysmMtr0500.getCurrentlySelectedItem(),
	            				  msfGridPanelSysm0800 );
	            		//  msfGridPanelSysm0800.reload();
	            		  
	            		  sysMtrSysm0300Def.synchronizeGridDetail(
	            				  msfGridPanelSysmMtr0500.getCurrentlySelectedItem(),
	            				  msfGridPanelSysm0300 ); 
	            		//  msfGridPanelSysm0300.reload();
	            	   }
	            	  
	           }
	      });
	   
	    
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
		  public SysmMtr0500() {
				setSize("1010px", "700px");  
		  } 
		
		  public SysmMtr0500(String txtForm) {
				this.txtForm = txtForm;
		  }		  
		  
		  private void createSysmMtr0500Form() {
			  
		 
			
			plFrmSysmMtr0500 = new FormPanel();
			plFrmSysmMtr0500.setHeadingText("PayGen Ver1.0 - 사용자권한그룹설정관리");
			plFrmSysmMtr0500.setIcon(Resources.APP_ICONS.text());
			plFrmSysmMtr0500.setBodyStyleName("pad-text");
			plFrmSysmMtr0500.setFrame(true); 
			plFrmSysmMtr0500.setPadding(2);
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage("사용자권한그룹설정관리","SYSMMTR0500");
					}
				});
			plFrmSysmMtr0500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmSysmMtr0500.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/
			
			  
			    HorizontalPanel inner = new HorizontalPanel();
	            inner.setBorders(false);
	            inner.setLayout(new FitLayout());		            
	            sysIfBass0300Def.setReadOnly(true);   
	            msfGridPanelSysmMtr0500 = new MSFGridPanel(sysIfBass0300Def, false, false, false,true,false); 
	            msfGridPanelSysmMtr0500.setSize(300, 620);
	            msfGridPanelSysmMtr0500.setBorders(true);
	            msfGridPanelSysmMtr0500.getGrid().setBorders(true);
	            Grid grid = msfGridPanelSysmMtr0500.getMsfGrid().getGrid();
	            grid.addListener(Events.CellDoubleClick , new Listener<BaseEvent>() {
	                public void handleEvent(BaseEvent be) {
	                	
	                	 usrDivCd = MSFSharedUtils.allowNulls(msfGridPanelSysmMtr0500.getMsfGrid().getCurrentlySelectedItem().get("usrDivCd"));
	                	//msfGridPanelSysm0800.mask(MSFMainApp.MSFMESSAGES.LoadingData());
	                	//authGrpNm.clear();	     
	                	//readtry();
	                	//readtry2();
	                }					
	            });
	            
	            // 부서명 검색조건 		          
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
	     	   
	     	    usrDivNm = new TextField<String>();
	     	    usrDivNm.setFieldLabel("사용자권한구분");
	     	    usrDivNm.addKeyListener(new KeyListener() {
	    			public void componentKeyDown(ComponentEvent event) {
	    				 super.componentKeyDown(event);
		                   usrDivNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reDeptload(); 
		                   }
	    			}
	    		});
	     	    
//	     	    usrDivNm.addKeyListener(new KeyListener() {
//	               public void componentKeyUp(ComponentEvent event) {
//	                   super.componentKeyUp(event);
//	                   usrDivNm.validate();
//	                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                	   reDeptload(); 
//	                   }
//	               }
//	           }); 
	     	    
	     	    layoutContainer_13.add(usrDivNm, new FormData("100%"));
	     	    layoutContainer_13.setBorders(false);
	     	
	     	    Button btnUsrSearch = new Button("검색");
	     	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
	      	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
	     	    	public void handleEvent(ButtonEvent e) { 
	     	    		reDeptload(); 
	     	    	}
	     	    });
	      	    
	     	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	     	    layoutContainer_12.add(btnUsrSearch );
	     	    lycSreach.add(layoutContainer_12);		     	     
	     	    msfGridPanelSysmMtr0500.setTopComponent(lycSreach);		            
	            inner.add(msfGridPanelSysmMtr0500);
	            
	            
	            // 두번째 컨테이너컬럼(사용권한그룹)   
	            msfGridPanelSysm0800 = new MSFGridPanel(sysMtrSysm0800Def, false, false, false, false,false); 
	            msfGridPanelSysm0800.setSize(650, 300);
	            msfGridPanelSysm0800.getGrid().setBorders(true);
	         
	            final Grid<BaseModel> grid2 = msfGridPanelSysm0800.getMsfGrid().getGrid();
	            final ColumnModel columnModel =  grid2.getColumnModel();
	            final List<ColumnConfig> columnConfigs = columnModel.getColumns();
	            final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 55); 
	            check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		        check.setEditor(columnConfigs.get(0).getEditor());
	            columnConfigs.set(0, check);

	            check.setRenderer(columnConfigs.get(0).getRenderer());  
	            grid2.addPlugin(check);
	            grid2.getView().setForceFit(true);
	            
	            
	            // 사용 권한그룹정보 		          
	            LayoutContainer  lycSreach2 = new LayoutContainer(); 
	            FormLayout frmlytStd2 = new FormLayout();  
	            frmlytStd2.setLabelWidth(0);  
	     	    lycSreach2.setLayout(frmlytStd2);
	     	    lycSreach2.setHeight(30); 
	    	    
	            LayoutContainer layoutContainer_14 = new LayoutContainer();
	     	    layoutContainer_14.setLayout(new ColumnLayout());
	     	    layoutContainer_14.setStyleAttribute("paddingTop", "5px");
	     	    layoutContainer_14.setBorders(true);
	     	    
	     	    
	     	    LayoutContainer layoutContainer_15 = new LayoutContainer();
	     	    frmlytStd2 = new FormLayout();  
	     	    frmlytStd2.setLabelWidth(70); 
	     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
	     	    layoutContainer_15.setLayout(frmlytStd2);
	     	   
	     	   authGrpNm = new TextField<String>();
	     	   authGrpNm.setFieldLabel("권한그룹");
	     	   authGrpNm.addKeyListener(new KeyListener() {
	               public void componentKeyDown(ComponentEvent event) {
	                   
	                   authGrpNm.validate();
	                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                	   reOccuInload(); 
	                   }
	                   super.componentKeyDown(event);
	               }
	           });
	     	    
	     	    layoutContainer_15.add(authGrpNm, new FormData("100%"));
//	     	   layoutContainer_15.add(authGrpNm, new FormData("100%"));
	     	    layoutContainer_15.setBorders(false);
	     	
	     	    Button btnUsrSearch2 = new Button("검색");
	     	    btnUsrSearch2.setIcon(MSFMainApp.ICONS.search());
	      	    btnUsrSearch2.addListener(Events.Select, new Listener<ButtonEvent>() {
	     	    	public void handleEvent(ButtonEvent e) { 
	     	    		reOccuInload(); 
	     	    	}
	     	    });
	      	    
	      	    
	     	    layoutContainer_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	     	    layoutContainer_14.add(btnUsrSearch2);
	     	    lycSreach2.add(layoutContainer_14);		     	     
	     	    msfGridPanelSysm0800.setTopComponent(lycSreach2);

	     	    
	            // 세번째 컨테이너컬럼(미사용권한그룹)  
		        msfGridPanelSysm0300 = new MSFGridPanel(sysMtrSysm0300Def, false, false, false, false,false); 
		        msfGridPanelSysm0300.setSize(650, 300);
		        msfGridPanelSysm0300.setBorders(true);
		        
		        final Grid<BaseModel> grid3 = msfGridPanelSysm0300.getMsfGrid().getGrid();
	            final ColumnModel columnModel3 =  grid3.getColumnModel();
	            List<ColumnConfig> columnConfigs3 = columnModel3.getColumns();
	            final CheckColumnConfig check3 = new CheckColumnConfig("select", "선택", 55); 
	            check3.setAlignment(Style.HorizontalAlignment.CENTER);
	            check3.setEditor(columnConfigs3.get(0).getEditor());         
	            columnConfigs3.set(0, check3);
	            
	            check3.setRenderer(columnConfigs3.get(0).getRenderer());  
	            grid3.addPlugin(check3);
	            grid3.getView().setForceFit(true);
	            
	            
	         // 미사용권한그룹 검색조건 		          
	            LayoutContainer  lycSreach3 = new LayoutContainer(); 
	            FormLayout frmlytStd3 = new FormLayout();  
	            frmlytStd3.setLabelWidth(0);  
	     	    lycSreach3.setLayout(frmlytStd3);
	     	    lycSreach3.setHeight(30); 
	    	    
	            LayoutContainer layoutContainer_17 = new LayoutContainer();
	            layoutContainer_17.setLayout(new ColumnLayout());
	            layoutContainer_17.setStyleAttribute("paddingTop", "5px");
	            layoutContainer_17.setBorders(true);
	     	    
	     	    
	     	    LayoutContainer layoutContainer_18 = new LayoutContainer();
	     	    frmlytStd2 = new FormLayout();  
	     	    frmlytStd2.setLabelWidth(70); 
	     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
	     	    layoutContainer_18.setLayout(frmlytStd2);
	     	   
	     	   noAuthGrpNm = new TextField<String>();
	     	   noAuthGrpNm.setFieldLabel("권한그룹");
	     	   noAuthGrpNm.addKeyListener(new KeyListener() {
	               public void componentKeyDown(ComponentEvent event) {
	                   
	                   noAuthGrpNm.validate();
	                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                	   reOccuNotload(); 
	                   }
	                   super.componentKeyDown(event);
	               }
	           });
	     	    
	     	    layoutContainer_18.add(noAuthGrpNm, new FormData("100%"));
	     	    layoutContainer_18.setBorders(false);
	     	
	     	    Button btnUsrSearch3 = new Button("검색");
	     	    btnUsrSearch3.setIcon(MSFMainApp.ICONS.search());
	     	    btnUsrSearch3.addListener(Events.Select, new Listener<ButtonEvent>() {
	     	    	public void handleEvent(ButtonEvent e) { 
	     	    		reOccuNotload(); 
	     	    	}
	     	    });
	      	    
	     	    layoutContainer_17.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	     	    layoutContainer_17.add(btnUsrSearch3);
	     	    lycSreach3.add(layoutContainer_17);		     	     
	     	    msfGridPanelSysm0300.setTopComponent(lycSreach3);
        
	          //툴바메뉴
	            ToolBar bottomToolbar = new ToolBar();  
	            bottomToolbar.add(new FillToolItem());
	            
	            // 첫번째 사용직종정보 툴바
	            // ================전체선택버튼=========================
	            btnSelectSysm0800 = new Button("전체선택");
	            btnSelectSysm0800.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
	                public void componentSelected(ButtonEvent ce) { 
	                	
	                	  int  lsCnt = msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().getCount();
	                	  
	                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
	                		  
	                		  msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
	                		  msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().commitChanges();
	                		   
	                	  } 
	                	  msfGridPanelSysm0800.getMsfGrid().getGrid().getView().refresh(true);
	    		    }
	            });
	            
	            
	            bottomToolbar.add(btnSelectSysm0800);
	            bottomToolbar.add(new SeparatorMenuItem());
	            //====================================================
	            
	           // ================전체해제버튼=========================
	            btnUnSelectSysm0800 = new Button("전체해제");
	            btnUnSelectSysm0800.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) {  
	                	
	                	  int  lsCnt = msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().getCount();
	                	  
	                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
	                		  
	                		  msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
	                		  msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().commitChanges();
	                		   
	                	  } 
	                	  msfGridPanelSysm0800.getMsfGrid().getGrid().getView().refresh(true);
	                }  
	            });

	            bottomToolbar.add(btnUnSelectSysm0800);
	            bottomToolbar.add(new SeparatorMenuItem());
	            //====================================================
	            
	            saveButton = new Button("미사용");
	            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {   
	            	
	                public void componentSelected(ButtonEvent ce) {           	    
	                	  Iterator<BaseModel> itBm  = msfGridPanelSysm0800.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
    			          List<Record> lsRec  = new ArrayList<Record>();
    			          while(itBm.hasNext()) {
    			              Record rec  = new Record(itBm.next()); 
    			              lsRec.add(rec);
    			          }  
    			          Iterator<Record> iterRecords = lsRec.iterator();
    			          
    		              while (iterRecords.hasNext()) {	    		            	  
    		            	  Record recData = (Record) iterRecords.next();
	    		              BaseModel bmMapModel = (BaseModel)recData.getModel();		    		             
	    		              
	    		              // select에 null값이 들어가있으므로 널포인트에러뜸.
	    		              // 그래서 null인것은 false로 강제변환시킴.
	    		              if((Boolean)bmMapModel.get("select")==null){
	    		            		 bmMapModel.set("select", false);
	    		            	 }		    		              
	    		                
	    		              if ((Boolean)bmMapModel.get("select")) {        
	    		             
	    		            		  SysIfSysm0800DTO sysm0800Dto = new SysIfSysm0800DTO();
		    		            	  
	    		            		  sysm0800Dto.setSysDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("sysDivCd")));
	    		            		  sysm0800Dto.setUsrDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("usrDivCd")));
	    		            		  sysm0800Dto.setAuthGrpSeilNum(Long.parseLong(MSFSharedUtils.defaultNulls(bmMapModel.get("authGrpSeilNum"),"0")));  		            	  

	    		            		  sysm0800Delete(sysm0800Dto); 
	    		              }
    		              } 		           
	                 }		                
	             });
	            bottomToolbar.add(saveButton);
	            bottomToolbar.add(new SeparatorMenuItem());

	            Button refresh = new Button();
	            refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
	            refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) {  
	                	msfGridPanelSysm0800.reload();	                	
	                }  
	            });		            
	            bottomToolbar.add(refresh);
	            
	            
	            
	          // 두번째 미사용직종정보 툴바 		            
	            ToolBar bottomToolbar2 = new ToolBar();  
	            bottomToolbar2.add(new FillToolItem());
	         // ================전체선택버튼=========================
	            btnSelectSysm0300 = new Button("전체선택");
	            btnSelectSysm0300.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) {
	                	
	                	  int  lsCnt = msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().getCount();
	                	  
	                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
	                		  
	                		  msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
	                		  msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().commitChanges();
	                		   
	                	  } 
	                	  msfGridPanelSysm0300.getMsfGrid().getGrid().getView().refresh(true);
	                	  
	                }  
	            });

	            bottomToolbar2.add(btnSelectSysm0300);
	            bottomToolbar2.add(new SeparatorMenuItem());
	            //====================================================
	            
	           // ================전체해제버튼=========================
	            btnUnSelectSysm0300  = new Button("전체해제");
	            btnUnSelectSysm0300.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) {  

	                	  int  lsCnt = msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().getCount();
	                	  
	                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
	                		  
	                		  msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
	                		  msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().commitChanges();
	                		   
	                	  } 
	                	  msfGridPanelSysm0300.getMsfGrid().getGrid().getView().refresh(true);
	                }  
	            });

	            bottomToolbar2.add(btnUnSelectSysm0300);
	            bottomToolbar2.add(new SeparatorMenuItem());
	            //====================================================
	            
	            saveButton = new Button("사용");
	            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) { 
	                	 Iterator<BaseModel> itBm  = msfGridPanelSysm0300.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
    			          List<Record> lsRec  = new ArrayList<Record>();
    			          while(itBm.hasNext()) {
    			              Record rec  = new Record(itBm.next()); 
    			              lsRec.add(rec);
    			          }  
    			          Iterator<Record> iterRecords = lsRec.iterator();
    			          
    		              while (iterRecords.hasNext()) {	    		            	  
    		            	  Record recData = (Record) iterRecords.next(); 
	    		              BaseModel bmMapModel = (BaseModel)recData.getModel();
	    		              
	    		           
	    		              // select에 null값이 들어가있으므로 널포인트에러뜸.
	    		              // 그래서 null인것은 false로 강제변환시킴.
	    		              if((Boolean)bmMapModel.get("select")==null){
	    		            		 bmMapModel.set("select", false);
	    		            	 }		    		              
	    		              
	    		              if ((Boolean)bmMapModel.get("select")) {	
	    		            	  
	    		            	  SysIfSysm0800DTO sysm0800Dto = new SysIfSysm0800DTO(); 
	    		            	   
	    		            	  sysm0800Dto.setSysDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("sysDivCd")));
	    		            	  sysm0800Dto.setUsrDivCd(usrDivCd);
	    		            	  sysm0800Dto.setAuthGrpSeilNum(Long.parseLong(MSFSharedUtils.defaultNulls(bmMapModel.get("authGrpSeilNum"),"0")));            	  

	    		            	  sysm0800Insert(sysm0800Dto);		    		            	
	    		              }		    		              
    		              }
    		              
	                }						
	            });

	            bottomToolbar2.add(saveButton);
	            bottomToolbar2.add(new SeparatorMenuItem());


	            Button refresh2 = new Button();
	            refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
	            refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
	                public void componentSelected(ButtonEvent ce) {  
	                	msfGridPanelSysm0300.reload();
	                }  
	            });		            
	            bottomToolbar2.add(refresh2);
	            
	            //툴바 넣어주는것
	            msfGridPanelSysm0800.setBottomComponent(bottomToolbar);
	            msfGridPanelSysm0300.setBottomComponent(bottomToolbar2);
	            
	            // 중간사이 틈을 주기위한 컨테이너
	            LayoutContainer space = new LayoutContainer();
	            space.setHeight(10);
	            space.setWidth(500);
	            space.setId("space");
	            space.setStyleAttribute("paddingLeft", "10px");

	            LayoutContainer layoutContainer_16 = new LayoutContainer();
	     	    frmlytStd2 = new FormLayout();  
	     	    frmlytStd2.setLabelWidth(100);
	     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
	     	    layoutContainer_16.setLayout(frmlytStd2);		     	    
	     	    layoutContainer_16.add(msfGridPanelSysm0800);
	     	    layoutContainer_16.add(space);
	     	    layoutContainer_16.add(msfGridPanelSysm0300);
	     	    
	            inner.add(layoutContainer_16);		            
	            
	        plFrmSysmMtr0500.add(inner);

			vp.add(plFrmSysmMtr0500);
			plFrmSysmMtr0500.setSize("990px", "680px");
		  }	
		  
		  
//private void readtry() {
//	 Object str = msfGridPanelSysmMtr0500.getMsfGrid().getCurrentlySelectedItem().get("usrDivCd").toString();
//     msfGridPanelSysm0800.getTableDef().setTableColumnFilters(null);
//     TextField<String> usrDivCd = new TextField<String>();
//     usrDivCd.setValue((String)str); 
//    msfGridPanelSysm0800.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//   	msfGridPanelSysm0800.unmask();
// 	msfGridPanelSysm0800.reload();
//}	
//
//private void readtry2() {
//	Object str = msfGridPanelSysmMtr0500.getMsfGrid().getCurrentlySelectedItem().get("usrDivCd").toString();
//    msfGridPanelSysm0300.getTableDef().setTableColumnFilters(null);
//    TextField<String> usrDivCd = new TextField<String>();
//    usrDivCd.setValue((String)str);       
//	msfGridPanelSysm0300.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//  	msfGridPanelSysm0300.unmask();
//	msfGridPanelSysm0300.reload();
//}		  
//
//private void readProfiles(SysIfBass0400BM dept){
//
//}

//private void composeListaProfiles(List<Bass0400DTO> listaPrf) {
//	Iterator<Bass0400DTO> iter = listaPrf.iterator();
//    List<BaseModel> list = new ArrayList<BaseModel>();
//    Bass0400DTO att = new Bass0400DTO();
//    while ( iter.hasNext() ) {
//    	att = (Bass0400DTO) iter.next();
//        BaseModel bm = new BaseModel();
//        bm.set("usrDivCd", att.getDeptCd());
//        list.add(bm);
//    }     	
//}



// 공통 코드 사용자권한 구분코드
public void reDeptload() {
	msfGridPanelSysmMtr0500.getTableDef().setTableColumnFilters(null);   
	msfGridPanelSysmMtr0500.getTableDef().addColumnFilter("usrDivNm", MSFSharedUtils.defaultNulls(usrDivNm.getValue(),""), SimpleColumnFilter.OPERATOR_LIKE); 
	msfGridPanelSysmMtr0500.reload();
}

// 사용 권한그룹번호
public void reOccuInload() {
    	IColumnFilter filters = null;
        msfGridPanelSysm0800.getTableDef().setTableColumnFilters(filters); 	    
        msfGridPanelSysm0800.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.defaultNulls(usrDivCd,""), SimpleColumnFilter.OPERATOR_EQUALS); 
        msfGridPanelSysm0800.getTableDef().addColumnFilter("authGrpNm", MSFSharedUtils.defaultNulls(authGrpNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
        msfGridPanelSysm0800.reload();
}

// 미사용  권한 그룹정보 
public void reOccuNotload() {
	   IColumnFilter filters = null;
	   msfGridPanelSysm0300.getTableDef().setTableColumnFilters(filters);  
	   msfGridPanelSysm0300.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.defaultNulls(usrDivCd,""), SimpleColumnFilter.OPERATOR_EQUALS); 
	   msfGridPanelSysm0300.getTableDef().addColumnFilter("authGrpNm", MSFSharedUtils.defaultNulls(noAuthGrpNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	   msfGridPanelSysm0300.reload();
}

private SysmMtr0500 getThis(){
    return this;
}

private void sysm0800Delete(SysIfSysm0800DTO sysm0800Dto) {
	sysmMtr0500service.sysm0800Delete(sysm0800Dto, new AsyncCallback<Long>() {
		@Override
		public void onFailure(Throwable caught) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("sysm0800Delete(삭제오류) : " + caught), null);
		}
		@Override
		public void onSuccess(Long result) {
			
			if (result > 0L) {
				msfGridPanelSysm0800.reload();
		        msfGridPanelSysm0300.reload();
			} else {
				
			}
		}
	});
}

private void sysm0800Insert(SysIfSysm0800DTO sysm0800Dto) {
	sysmMtr0500service.sysm0800Insert(sysm0800Dto, new AsyncCallback<Long>(){
		@Override 
		public void onFailure(Throwable caught) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("sysm0800Insert(인서트오류) : " + caught), null);
		}
		@Override
		public void onSuccess(Long result) {
			
			if (result > 0L) {
				msfGridPanelSysm0800.reload();
		        msfGridPanelSysm0300.reload();
			} else {
				
			}
			 
		}    		
	});    	
}



/************************************************************************
 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
 ************************************************************************/
/**
 * 
 * <pre>
 * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : funcLogMessage
 * @date : 2016. 9. 2.
 * @author : Administrator
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2016. 9. 2.		Administrator				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param wndName
 * @param wndId
 */
public void funcLogMessage(String wndName, String wndId){

	 ShowMessageBM smForm = new ShowMessageBM();
	 smForm.setWindowId(wndId);
	 smForm.setWindowNm(wndName);
	//개별 화면 에러메시지 검색 팝업  
	GWTUtils.funcLogMessage(smForm);
}  
/************************************************************************
 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
 ************************************************************************/	 


}
