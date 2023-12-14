package com.app.smrmf.sysauth.system.client.form;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfBass0150Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfBass0360Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0360DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.sysauth.system.client.service.Sysm0600Service;
import com.app.smrmf.sysauth.system.client.service.Sysm0600ServiceAsync;
import com.extjs.gxt.ui.client.Style;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
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
public class Sysm0600  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	  private VerticalPanel vp;
	  private FormPanel plFrmSysm0600; 
	  private String txtForm = "";   
	  private Sysm0600ServiceAsync sysm0600Service = Sysm0600Service.Util.getInstance();  
	  private Button saveButton;     
	  private Button btnSelectBass0360;
	  private Button btnSelectBass0350;
	  private Button btnUnSelectBass0360;
	  private Button btnUnSelectBass0350;
	 
	  private SysIfBass0150Def sysIfBass0150Def  = new SysIfBass0150Def("SYSM0600");
	  private SysIfBass0360Def sysIfBass0360Top = new SysIfBass0360Def("SYSM0600TOP"); 
	  private SysIfBass0360Def sysIfBass0360Btm = new SysIfBass0360Def("SYSM0600BTM"); 
	  private MSFGridPanel msfGridSysIfBass0150; 
	  private MSFGridPanel msfGdSysIfBass0360Top;
	  private MSFGridPanel msfGdSysIfBass0360Btm;
	  private TextField<String> payMangeDeptNm ;  // 부서명 텍스트필드 변수
	  private TextField<String> dtilOccuClsNm; // 사용직종정보 직종세 통합코드 변수
	  private TextField<String> dtilNotOccuClsNm; // 미사용직종정보 직종세 통합코드 변수
	  
	  private ComboBox<BaseModel> deptCd01 ;    //부서  
	  private ComboBox<BaseModel> deptCd02 ;    //부서  
      private ListStore<BaseModel>   lsDeptCd01 = new ListStore<BaseModel>();//부서  
      private ListStore<BaseModel>   lsDeptCd02 = new ListStore<BaseModel>();//부서  
  	  private SysIfBass0400DTO sysIfBass0400Dto; //부서코드
  	  
	  private String payrMangDeptCd ;
	    
    public ContentPanel getViewPanel() {
        if (panel == null) {        	
          
            
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createSysm0600Form();  //화면 기본정보를 설정
		    vp.setSize("1010px", "700px");    
		    
		    
		    /**
	          * Create the relations 
	          */
			   final RelationDef  relBass0360 = new RelationDef(sysIfBass0150Def,false);
			   relBass0360.addJoinDef("dpobCd", "dpobCd"); 
			//   relBass0360.addJoinDef("deptCd", "deptCd"); 
			   relBass0360.addJoinDef("payrMangDeptCd", "payrMangDeptCd"); 
			   relBass0360.setLinkedObject(msfGridSysIfBass0150);
			   sysIfBass0360Top.addRelation(relBass0360); 
	           
	 
//	           // DETAILS 
//	           final Grid sysIfBass0360TopGrid = msfGridSysIfBass0150.getMsfGrid().getGrid();
//	           sysIfBass0360TopGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//	              public void handleEvent(BaseEvent be) {  
//	            	  if (msfGridSysIfBass0150.getCurrentlySelectedItem() != null) { 
//	            		 
//	            		
//	            	   } 
//	           }
//	         });
	           
	            
	           
	           /**
		          * Create the relations 
		          */
				   final RelationDef  relBass0350 = new RelationDef(sysIfBass0150Def,false);
				   relBass0350.addJoinDef("dpobCd", "dpobCd"); 
				//   relBass0350.addJoinDef("deptCd", "deptCd"); 
				   relBass0350.addJoinDef("payrMangDeptCd", "payrMangDeptCd"); 
				   relBass0350.setLinkedObject(msfGridSysIfBass0150);
				   sysIfBass0360Btm.addRelation(relBass0350); 
		           
		 
		           // DETAILS 
		           final Grid sysIfBass0360BtmGrid = msfGridSysIfBass0150.getMsfGrid().getGrid();
		           sysIfBass0360BtmGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
		              public void handleEvent(BaseEvent be) {  
		            	  if (msfGridSysIfBass0150.getCurrentlySelectedItem() != null) { 
		            		 
		            		  sysIfBass0360Top.synchronizeGridDetail(
		            				  msfGridSysIfBass0150.getCurrentlySelectedItem(),
		            				  msfGdSysIfBass0360Top ); 
		            		//  msfGdSysIfBass0360Top.reload();
		            		  
		            		  sysIfBass0360Btm.synchronizeGridDetail(
		            				  msfGridSysIfBass0150.getCurrentlySelectedItem(),
		            				  msfGdSysIfBass0360Btm ); 
		            		//  msfGdSysIfBass0360Btm.reload();
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
			  public Sysm0600() {
					setSize("1010px", "700px");  
			  } 
			
			  public Sysm0600(String txtForm) {
					this.txtForm = txtForm;
			  }		  
			  
			  private void createSysm0600Form() {
				  
				plFrmSysm0600 = new FormPanel();
				plFrmSysm0600.setHeadingText("PayGen Ver1.0 - 단위기관별권한관리");
				plFrmSysm0600.setIcon(Resources.APP_ICONS.text());
				plFrmSysm0600.setBodyStyleName("pad-text");
				plFrmSysm0600.setFrame(true); 
				 
				
				     sysIfBass0400Dto = new SysIfBass0400DTO(); 
				     sysIfBass0400Dto.setDeptDspyYn("Y");
			     	//--------------------부서 불러 오는 함수 ------------------------------------------------
					 lsDeptCd01 = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
					 //--------------------부서 불러 오는 함수 ------------------------------------------------
					 
					 
				    HorizontalPanel inner = new HorizontalPanel();
		            inner.setBorders(false);
		            inner.setLayout(new FitLayout());		            
		            sysIfBass0150Def.setReadOnly(true);   
		            msfGridSysIfBass0150 = new MSFGridPanel(sysIfBass0150Def, false, false, false); 
		            msfGridSysIfBass0150.setSize(300, 620);
		            msfGridSysIfBass0150.setBorders(true);
		            msfGridSysIfBass0150.getGrid().setBorders(true);
		            Grid grid = msfGridSysIfBass0150.getMsfGrid().getGrid();
		            grid.addListener(Events.CellDoubleClick , new Listener<BaseEvent>() {
		                public void handleEvent(BaseEvent be) {
		                	
		                  payrMangDeptCd = MSFSharedUtils.allowNulls(msfGridSysIfBass0150.getMsfGrid().getCurrentlySelectedItem().get("payrMangDeptCd"));
		                //	msfGdSysIfBass0360Top.mask(MSFMainApp.MSFMESSAGES.LoadingData());
		                //	dtilOccuClsNm.clear();	     
		                //	readtry();
		                //	readtry2();
		                }					
		            });
		            
		            //  검색조건 		          
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
		     	   
		     	    payMangeDeptNm = new TextField<String>();
		     	    payMangeDeptNm.setFieldLabel("단위기관");
		     	    payMangeDeptNm.addKeyListener(new KeyListener() {
		               public void componentKeyUp(ComponentEvent event) {
		                   super.componentKeyUp(event);
		                   payMangeDeptNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reDeptload(); 
		                   }
		               }
		           }); 
		     	    
		     	    layoutContainer_13.add(payMangeDeptNm, new FormData("100%"));
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
		     	    msfGridSysIfBass0150.setTopComponent(lycSreach);		            
		            inner.add(msfGridSysIfBass0150);
		            
		            
		            // 두번째 컨테이너컬럼(사용직종정보)   
		            msfGdSysIfBass0360Top = new MSFGridPanel(sysIfBass0360Top, false, false, false, false); 
		            msfGdSysIfBass0360Top.setSize(650, 300);
		            msfGdSysIfBass0360Top.getGrid().setBorders(true);
		         
		            final Grid<BaseModel> grid2 = msfGdSysIfBass0360Top.getMsfGrid().getGrid();
		            final ColumnModel columnModel =  grid2.getColumnModel();
		            final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		            final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 55); 
		            check.setAlignment(Style.HorizontalAlignment.CENTER);		            
    		        check.setEditor(columnConfigs.get(0).getEditor());
		            columnConfigs.set(0, check);

		            check.setRenderer(columnConfigs.get(0).getRenderer());  
		            grid2.addPlugin(check);
		            grid2.getView().setForceFit(true);
		            
		            
		            // 사용직종정보 검색조건 		          
		            LayoutContainer  lycSreach2 = new LayoutContainer(); 
		            FormLayout frmlytStd2 = new FormLayout();  
		            frmlytStd2.setLabelWidth(0);  
		     	    lycSreach2.setLayout(frmlytStd2);
		     	    lycSreach2.setHeight(30); 
		    	    
		            LayoutContainer layoutContainer_14 = new LayoutContainer();
		     	    layoutContainer_14.setLayout(new ColumnLayout());
		     	    layoutContainer_14.setStyleAttribute("paddingTop", "5px");
		     	    layoutContainer_14.setBorders(true);
		     	    
		     	    LayoutContainer layoutContainer_2 = new LayoutContainer();
		     	   layoutContainer_14.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			    	FormLayout frmlytSch = new FormLayout();  
				    frmlytSch.setLabelWidth(70); 
				    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
				    layoutContainer_2.setLayout(frmlytSch);
				    
			        deptCd01 = new ComboBox<BaseModel>();
			        deptCd01.setForceSelection(true);
			        deptCd01.setMinChars(1);
			        deptCd01.setDisplayField("deptNmRtchnt");
			        deptCd01.setValueField("deptCd");
			        deptCd01.setTriggerAction(TriggerAction.ALL);
			        deptCd01.setEmptyText("--부서선택--");
			        deptCd01.setSelectOnFocus(true); 
			        deptCd01.setReadOnly(false);
			        deptCd01.setEnabled(true); 
			        deptCd01.setStore(lsDeptCd01 );
			        deptCd01.setFieldLabel("부서");
				   
				    layoutContainer_2.add(deptCd01, new FormData("100%")); 
				    layoutContainer_2.setBorders(false);
		     	    
		     	    
		     	    LayoutContainer layoutContainer_15 = new LayoutContainer();
		     	    frmlytStd2 = new FormLayout();  
		     	    frmlytStd2.setLabelWidth(70); 
		     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		     	    layoutContainer_15.setLayout(frmlytStd2);
		     	   
		     	   dtilOccuClsNm = new TextField<String>();
		     	   dtilOccuClsNm.setFieldLabel("직종세명");
		     	   dtilOccuClsNm.addKeyListener(new KeyListener() {
		               public void componentKeyUp(ComponentEvent event) {
		                   super.componentKeyUp(event);
		                   dtilOccuClsNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reOccuInload(); 
		                   }
		               }
		           });
		     	    
		     	    layoutContainer_15.add(dtilOccuClsNm, new FormData("100%"));
		     	    layoutContainer_15.setBorders(false);
		     	
		     	    Button btnUsrSearch2 = new Button("검색");
		     	    btnUsrSearch2.setIcon(MSFMainApp.ICONS.search());
		      	    btnUsrSearch2.addListener(Events.Select, new Listener<ButtonEvent>() {
		     	    	public void handleEvent(ButtonEvent e) { 
		     	    		reOccuInload(); 
		     	    	}
		     	    });
		      	    
		     	    layoutContainer_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		     	    layoutContainer_14.add(btnUsrSearch2);
		     	    lycSreach2.add(layoutContainer_14);		     	     
		     	    msfGdSysIfBass0360Top.setTopComponent(lycSreach2);

		     	    
		     	     sysIfBass0400Dto = new SysIfBass0400DTO(); 
				     sysIfBass0400Dto.setDeptDspyYn("Y");
			     	//--------------------부서 불러 오는 함수 ------------------------------------------------
					 lsDeptCd02 = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
					 //--------------------부서 불러 오는 함수 ------------------------------------------------
					 
		            // 세번째 컨테이너컬럼(미사용직종정보)  
			        msfGdSysIfBass0360Btm = new MSFGridPanel(sysIfBass0360Btm, false, false, false, false); 
			        msfGdSysIfBass0360Btm.setSize(650, 300);
			        msfGdSysIfBass0360Btm.setBorders(true);
			        
			        final Grid<BaseModel> grid3 = msfGdSysIfBass0360Btm.getMsfGrid().getGrid();
		            final ColumnModel columnModel3 =  grid3.getColumnModel();
		            List<ColumnConfig> columnConfigs3 = columnModel3.getColumns();
		            final CheckColumnConfig check3 = new CheckColumnConfig("select", "선택", 55); 
		            check3.setAlignment(Style.HorizontalAlignment.CENTER);
		            check3.setEditor(columnConfigs3.get(0).getEditor());         
		            columnConfigs3.set(0, check3);
		            
		            check3.setRenderer(columnConfigs3.get(0).getRenderer());  
		            grid3.addPlugin(check3);
		            grid3.getView().setForceFit(true);
		            
		            
		         // 미사용직종정보 검색조건 		          
		            LayoutContainer  lycSreach3 = new LayoutContainer(); 
		            FormLayout frmlytStd3 = new FormLayout();  
		            frmlytStd3.setLabelWidth(0);  
		     	    lycSreach3.setLayout(frmlytStd3);
		     	    lycSreach3.setHeight(30); 
		    	    
		            LayoutContainer layoutContainer_17 = new LayoutContainer();
		            layoutContainer_17.setLayout(new ColumnLayout());
		            layoutContainer_17.setStyleAttribute("paddingTop", "5px");
		            layoutContainer_17.setBorders(true);
		     	    
		             LayoutContainer layoutContainer_21	 = new LayoutContainer();
		             layoutContainer_17.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
				       frmlytSch = new FormLayout();  
					    frmlytSch.setLabelWidth(70); 
					    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
					    layoutContainer_21.setLayout(frmlytSch);
					    
				        deptCd02 = new ComboBox<BaseModel>();
				        deptCd02.setForceSelection(true);
				        deptCd02.setMinChars(1);
				        deptCd02.setDisplayField("deptNmRtchnt");
				        deptCd02.setValueField("deptCd");
				        deptCd02.setTriggerAction(TriggerAction.ALL);
				        deptCd02.setEmptyText("--부서선택--");
				        deptCd02.setSelectOnFocus(true); 
				        deptCd02.setReadOnly(false);
				        deptCd02.setEnabled(true); 
				        deptCd02.setStore(lsDeptCd02 ); 
				        deptCd02.setFieldLabel("부서");
					   
				        layoutContainer_21.add(deptCd02, new FormData("100%")); 
				        layoutContainer_21.setBorders(false);
					    
		     	    
		     	    LayoutContainer layoutContainer_18 = new LayoutContainer();
		     	    frmlytStd2 = new FormLayout();  
		     	    frmlytStd2.setLabelWidth(70); 
		     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		     	    layoutContainer_18.setLayout(frmlytStd2);
		     	   
		     	   dtilNotOccuClsNm = new TextField<String>();
		     	   dtilNotOccuClsNm.setFieldLabel("직종세명");
		     	   dtilNotOccuClsNm.addKeyListener(new KeyListener() {
		               public void componentKeyUp(ComponentEvent event) {
		                   super.componentKeyUp(event);
		                   dtilNotOccuClsNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reOccuNotload(); 
		                   }
		               }
		           });
		     	    
		     	    layoutContainer_18.add(dtilNotOccuClsNm, new FormData("100%"));
		     	    layoutContainer_18.setBorders(false);
		     	
		     	    Button btnUsrSearch3 = new Button("검색");
		     	    btnUsrSearch3.setIcon(MSFMainApp.ICONS.search());
		     	    btnUsrSearch3.addListener(Events.Select, new Listener<ButtonEvent>() {
		     	    	public void handleEvent(ButtonEvent e) { 
		     	    		reOccuNotload(); 
		     	    	}
		     	    });
		      	    
		     	    layoutContainer_17.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		     	    layoutContainer_17.add(btnUsrSearch3);
		     	    lycSreach3.add(layoutContainer_17);		     	     
		     	    msfGdSysIfBass0360Btm.setTopComponent(lycSreach3);
	        
		          //툴바메뉴
		            ToolBar bottomToolbar = new ToolBar();  
		            bottomToolbar.add(new FillToolItem());
		            
		            // 첫번째 사용직종정보 툴바
		            // ================전체선택버튼=========================
		            btnSelectBass0360 = new Button("전체선택");
		            btnSelectBass0360.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
		                public void componentSelected(ButtonEvent ce) { 
		                	
		                	  int  lsCnt = msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
		                		  msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGdSysIfBass0360Top.getMsfGrid().getGrid().getView().refresh(true);
		    		    }
		            });

		            bottomToolbar.add(btnSelectBass0360);
		            bottomToolbar.add(new SeparatorMenuItem());
		            //====================================================
		            
		           // ================전체해제버튼=========================
		            btnUnSelectBass0360 = new Button("전체해제");
		            btnUnSelectBass0360.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                	
		                	  int  lsCnt = msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
		                		  msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGdSysIfBass0360Top.getMsfGrid().getGrid().getView().refresh(true);
		                }  
		            });

		            bottomToolbar.add(btnUnSelectBass0360);
		            bottomToolbar.add(new SeparatorMenuItem());
		            //====================================================
		            
		            saveButton = new Button("미사용");
		            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
		            	
		                public void componentSelected(ButtonEvent ce) {
		                	  Iterator<BaseModel> itBm  = msfGdSysIfBass0360Top.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
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
		    		            	  
		    		            	  SysIfBass0360DTO bass0360Dto = new SysIfBass0360DTO();
		    		            	  
		    		            	  bass0360Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
		    		            	  bass0360Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));
		    		            	  bass0360Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));
		    		            	  bass0360Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    		            	  
		    		            	  bass0360Dto.setPayrMangDeptCd("");
		    		            	  bass0360Delete(bass0360Dto);
		    		              }
	    		              }
	    		           
		                }
		                
		            });
		            bottomToolbar.add(saveButton);
		            bottomToolbar.add(new SeparatorMenuItem());

		            Button refresh = new Button("");
		            refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		            refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                	msfGdSysIfBass0360Top.reload();	                	
		                }  
		            });		            
		            bottomToolbar.add(refresh);
		            
		            
		            
		          // 두번째 미사용직종정보 툴바 		            
		            ToolBar bottomToolbar2 = new ToolBar();  
		            bottomToolbar2.add(new FillToolItem());
		         // ================전체선택버튼=========================
		            btnSelectBass0350 = new Button("전체선택");
		            btnSelectBass0350.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {
		                	
		                	  int  lsCnt = msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
		                		  msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getView().refresh(true);
		                	  
		                }  
		            });

		            bottomToolbar2.add(btnSelectBass0350);
		            bottomToolbar2.add(new SeparatorMenuItem());
		            //====================================================
		            
		           // ================전체해제버튼=========================
		            btnUnSelectBass0350  = new Button("전체해제");
		            btnUnSelectBass0350.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  

		                	  int  lsCnt = msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
		                		  msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getView().refresh(true);
		                }  
		            });

		            bottomToolbar2.add(btnUnSelectBass0350);
		            bottomToolbar2.add(new SeparatorMenuItem());
		            //====================================================
		            
		            saveButton = new Button("사용");
		            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) { 
		                	 Iterator<BaseModel> itBm  = msfGdSysIfBass0360Btm.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
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
		    		            	  
		    		            	  SysIfBass0360DTO bass0360Dto = new SysIfBass0360DTO();
		    		            	  
		    		            	  bass0360Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
		    		            	  bass0360Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));
		    		            	  bass0360Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));
		    		            	  bass0360Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    		            	  
		    		            	  bass0360Dto.setPayrMangDeptCd(payrMangDeptCd);
		    		            	  bass0360Insert(bass0360Dto);		    		            	
		    		              }		    		              
	    		              }
	    		              
		                }						
		            });

		            bottomToolbar2.add(saveButton);
		            bottomToolbar2.add(new SeparatorMenuItem());


		            Button refresh2 = new Button("");
		            refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
		            refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                	msfGdSysIfBass0360Btm.reload();
		                }  
		            });		            
		            bottomToolbar2.add(refresh2);
		            
		            //툴바 넣어주는것
		            msfGdSysIfBass0360Top.setBottomComponent(bottomToolbar);
		            msfGdSysIfBass0360Btm.setBottomComponent(bottomToolbar2);
		            
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
		     	    layoutContainer_16.add(msfGdSysIfBass0360Top);
		     	    layoutContainer_16.add(space);
		     	    layoutContainer_16.add(msfGdSysIfBass0360Btm);
		     	    
		            inner.add(layoutContainer_16);		            
		            
		        plFrmSysm0600.add(inner);

				vp.add(plFrmSysm0600);
				plFrmSysm0600.setSize("990px", "680px");
			  }	
			  
			  
//	private void readtry() {
//		 Object str = msfGridSysIfBass0150.getMsfGrid().getCurrentlySelectedItem().get("deptCd").toString();
//         msfGdSysIfBass0360Top.getTableDef().setTableColumnFilters(null);
//         TextField<String> deptCd = new TextField<String>();
//         deptCd.setValue((String)str); 
//        msfGdSysIfBass0360Top.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//       	msfGdSysIfBass0360Top.unmask();
//     	msfGdSysIfBass0360Top.reload();
//	}	
//	
//	private void readtry2() {
//		Object str = msfGridSysIfBass0150.getMsfGrid().getCurrentlySelectedItem().get("deptCd").toString();
//        msfGdSysIfBass0360Btm.getTableDef().setTableColumnFilters(null);
//        TextField<String> deptCd = new TextField<String>();
//        deptCd.setValue((String)str);       
//    	msfGdSysIfBass0360Btm.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//      	msfGdSysIfBass0360Btm.unmask();
//    	msfGdSysIfBass0360Btm.reload();
//	}		  
 
 
    // 부서관리 검색 메소드
    public void reDeptload() {
    	msfGridSysIfBass0150.getTableDef().setTableColumnFilters(null);   
    	msfGridSysIfBass0150.getTableDef().addColumnFilter("payMangeDeptNm", MSFSharedUtils.defaultNulls(payMangeDeptNm.getValue(),""), SimpleColumnFilter.OPERATOR_LIKE); 
    	msfGridSysIfBass0150.reload();
    }
    
    // 사용 직종정보 (직종세통합코드) 메소드
	public void reOccuInload() {
	    	IColumnFilter filters = null;
	        msfGdSysIfBass0360Top.getTableDef().setTableColumnFilters(filters); 	
	        
	        msfGdSysIfBass0360Top.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.defaultNulls(payrMangDeptCd,""), SimpleColumnFilter.OPERATOR_EQUALS);  
	        msfGdSysIfBass0360Top.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(deptCd01,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	        msfGdSysIfBass0360Top.getTableDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(dtilOccuClsNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        msfGdSysIfBass0360Top.reload();
	}
	
	// 미사용 직종정보 (직종세통합코드) 메소드
	public void reOccuNotload() {
		   IColumnFilter filters = null;
		   msfGdSysIfBass0360Btm.getTableDef().setTableColumnFilters(filters);    		 
		   msfGdSysIfBass0360Btm.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(deptCd02,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		   msfGdSysIfBass0360Btm.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.defaultNulls(payrMangDeptCd,""), SimpleColumnFilter.OPERATOR_EQUALS); 
		   msfGdSysIfBass0360Btm.getTableDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(dtilNotOccuClsNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		   msfGdSysIfBass0360Btm.reload();
	}
	
    private Sysm0600 getThis(){
        return this;
    }
    
    private void bass0360Delete(SysIfBass0360DTO bass0360Dto) {
    	sysm0600Service.bass0360Delete(bass0360Dto, new AsyncCallback<Long>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("bass0360Delete(삭제오류) : " + caught)
                        , null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					msfGdSysIfBass0360Top.reload();
			        msfGdSysIfBass0360Btm.reload();
				} else {
					
				}
			}
		});
	}
    
    private void bass0360Insert(SysIfBass0360DTO bass0360Dto) {
    	sysm0600Service.bass0360Insert(bass0360Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0320(인서트오류) : " + caught)
                        , null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					msfGdSysIfBass0360Top.reload();
			        msfGdSysIfBass0360Btm.reload();
				} else {
					
				}
				 
			}    		
    	});    	
  }
}
     
