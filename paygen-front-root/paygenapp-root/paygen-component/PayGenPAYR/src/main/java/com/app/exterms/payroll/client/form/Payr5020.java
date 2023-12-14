package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Bass0350DTO;
import com.app.exterms.payroll.client.form.defs.Bass0300Def;
import com.app.exterms.payroll.client.form.defs.Bass0350Def;
import com.app.exterms.payroll.client.service.Payr5020Service;
import com.app.exterms.payroll.client.service.Payr5020ServiceAsync;
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
public class Payr5020  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	  private VerticalPanel vp;
	  private FormPanel plFrmpAYR5020;
	  private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp;	  
	  
	  private Payr5020ServiceAsync payr5020Service = Payr5020Service.Util.getInstance();	// 입력수정삭제처리 rpc 처리부
	  
	  private Button saveButton;
	  private Button saveButton2;	    
	  private Button btnSelectBass0360;
	  private Button btnSelectBass0350;
	  private Button btnUnSelectBass0360;
	  private Button btnUnSelectBass0350;
	 
	  private Bass0300Def bass0300Def = new Bass0300Def("PAYR5020");
	  private Bass0350Def bass0350TopDef = new Bass0350Def("BASS0350Top"); 
	  private Bass0350Def bass0350BottomDef = new Bass0350Def("BASS0350Bottom");

	  private MSFGridPanel msfGridPanelBass0300; 
	  private MSFGridPanel msfGridPanelBass0350Top;
	  private MSFGridPanel msfGridPanelBass0350Bottom;
	  private TextField<String> commCdNm ;  // 부서명 텍스트필드 변수
	  private TextField<String> dtilOccuClsNm; // 사용직종정보 직종세 통합코드 변수
	  private TextField<String> dtilNotOccuClsNm; // 미사용직종정보 직종세 통합코드 변수
	  private String commCd;
	  
  	/*  private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>(); //직종
  	  private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
	   
	  private PrgmComBass0320DTO sysComBass0320Dto = new PrgmComBass0320DTO();	//직종
	  private PrgmComBass0350DTO sysComBass0350Dto = new PrgmComBass0350DTO();	//직종세
*/      
	  
	  public ContentPanel getViewPanel() {
        if (panel == null) {        	
          
            
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createpAYR5020Form();  //화면 기본정보를 설정
		    vp.setSize("1010px", "700px");    
		    
		    
		    /**
	          * Create the relations 
	          */
			   final RelationDef  relBass0350Top = new RelationDef(bass0300Def,false);
			   relBass0350Top.addJoinDef("dpobCd", "dpobCd"); 
			   relBass0350Top.addJoinDef("commCd", "dtilOccuJbfmlDivCd"); 
			   relBass0350Top.setLinkedObject(msfGridPanelBass0300);
			   bass0350TopDef.addRelation(relBass0350Top); 
	           
	 
	           // DETAILS 
	           final Grid bass0300DefGrid = msfGridPanelBass0300.getMsfGrid().getGrid();
	           bass0300DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	              public void handleEvent(BaseEvent be) {  
	            	  if (msfGridPanelBass0300.getCurrentlySelectedItem() != null) { 
	            		  bass0350TopDef.synchronizeGridDetail(
	            				  msfGridPanelBass0300.getCurrentlySelectedItem(),
	            				  msfGridPanelBass0350Top ); 
	            		  
	            		//  reOccuInload();
	            	   }
	            	
	           }
	         });
	           
	            
	           
	           /**
		          * Create the relations 
		          */
				   final RelationDef  relBass0350Bottom = new RelationDef(bass0300Def,false);
				   relBass0350Bottom.addJoinDef("dpobCd", "dpobCd"); 
				   //relBass0350Bottom.addJoinDef("deptCd", "deptCd"); 
				   relBass0350Bottom.setLinkedObject(msfGridPanelBass0300);
				   bass0350BottomDef.addRelation(relBass0350Bottom); 
		           
		 
		           // DETAILS 
		           final Grid bass0350DefGrid = msfGridPanelBass0300.getMsfGrid().getGrid();
		           bass0350DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
		              public void handleEvent(BaseEvent be) {  
		            	  if (msfGridPanelBass0300.getCurrentlySelectedItem() != null) { 
		            		  bass0350BottomDef.synchronizeGridDetail(
		            				  msfGridPanelBass0300.getCurrentlySelectedItem(),
		            				  msfGridPanelBass0350Bottom );
		            		  
		            		//  reOccuNotload();
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
			  public Payr5020() {
					setSize("1010px", "700px");  
			  } 
			
			  public Payr5020(String txtForm) {
					this.txtForm = txtForm;
			  }		  
			  
			  private void createpAYR5020Form() {
				  
				//listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);  
				//lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);

				
				plFrmpAYR5020 = new FormPanel();
				plFrmpAYR5020.setHeadingText("PayGen Ver1.0 - 직종세직군관리");
				plFrmpAYR5020.setIcon(Resources.APP_ICONS.text());
				plFrmpAYR5020.setBodyStyleName("pad-text");
				plFrmpAYR5020.setFrame(true); 
				
			

				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
				 ************************************************************************/
				final Button btnlogView = new Button("로그");   
				
				btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
				btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						 //로그 뷰화면 호출 메서드 
						  funcLogMessage("직종세직군관리","PAYR5020");
						}
					});
				plFrmpAYR5020.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
				plFrmpAYR5020.getHeader().addTool(btnlogView); 
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 
				 ************************************************************************/


				
				    HorizontalPanel inner = new HorizontalPanel();
		            inner.setBorders(false);
		            inner.setLayout(new FitLayout());		            
		            bass0300Def.setReadOnly(true);   
		            msfGridPanelBass0300 = new MSFGridPanel(bass0300Def, false, false, false); 
		            msfGridPanelBass0300.setSize(300, 620);
		            msfGridPanelBass0300.setBorders(true);
		            msfGridPanelBass0300.getGrid().setBorders(true);
		            Grid grid = msfGridPanelBass0300.getMsfGrid().getGrid();
		            grid.addListener(Events.CellDoubleClick , new Listener<BaseEvent>() {
		                public void handleEvent(BaseEvent be) {
		                	
		                	commCd = MSFSharedUtils.allowNulls(msfGridPanelBass0300.getMsfGrid().getCurrentlySelectedItem().get("commCd"));
		                	
		                	

		                	//dtilOccuClsNm.clear();	    
		             
		                	
		                	//dtilNotOccuClsNm.clear();
		                	
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
		     	   
		     	    commCdNm = new TextField<String>();
		     	    commCdNm.setFieldLabel("부서명");
		     	    commCdNm.addKeyListener(new KeyListener() {
		               public void componentKeyDown(ComponentEvent event) {
		                 
		                   commCdNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reDeptload(); 
		                   }
		                   super.componentKeyDown(event);
		               }
		           }); 
		     	    
		     	    layoutContainer_13.add(commCdNm, new FormData("100%"));
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
		     	    msfGridPanelBass0300.setTopComponent(lycSreach);		            
		            inner.add(msfGridPanelBass0300);
		            
		            
		            // 두번째 컨테이너컬럼(사용직종정보)   
		            msfGridPanelBass0350Top = new MSFGridPanel(bass0350TopDef, false, false, false, false); 
		            msfGridPanelBass0350Top.setSize(650, 300);
		            msfGridPanelBass0350Top.getGrid().setBorders(true);
		         
		            final Grid<BaseModel> grid2 = msfGridPanelBass0350Top.getMsfGrid().getGrid();
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
		     	    
		     	    
		     	    LayoutContainer layoutContainer_15 = new LayoutContainer();
		     	    frmlytStd2 = new FormLayout();  
		     	    frmlytStd2.setLabelWidth(70); 
		     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		     	    layoutContainer_15.setLayout(frmlytStd2);
		     	   
		     	   dtilOccuClsNm = new TextField<String>();
		     	   dtilOccuClsNm.setFieldLabel("직종세명");
		     	   dtilOccuClsNm.addKeyListener(new KeyListener() {
		               public void componentKeyDown(ComponentEvent event) {
		                  
		                   dtilOccuClsNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reOccuInload(); 
		                   }
		                   super.componentKeyDown(event);
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
		      	    
		     	    layoutContainer_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		     	    layoutContainer_14.add(btnUsrSearch2);
		     	    lycSreach2.add(layoutContainer_14);		     	     
		     	    msfGridPanelBass0350Top.setTopComponent(lycSreach2);

		     	    
		            // 세번째 컨테이너컬럼(미사용직종정보)  
		     	   msfGridPanelBass0350Bottom = new MSFGridPanel(bass0350BottomDef, false, false, false, false); 
		     	  msfGridPanelBass0350Bottom.setSize(650, 300);
		     	 msfGridPanelBass0350Bottom.setBorders(true);
			        
			        final Grid<BaseModel> grid3 = msfGridPanelBass0350Bottom.getMsfGrid().getGrid();
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
		     	    
		     	    
		     	    LayoutContainer layoutContainer_18 = new LayoutContainer();
		     	    frmlytStd2 = new FormLayout();  
		     	    frmlytStd2.setLabelWidth(70); 
		     	    frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		     	    layoutContainer_18.setLayout(frmlytStd2);
		     	   
		     	   dtilNotOccuClsNm = new TextField<String>();
		     	   dtilNotOccuClsNm.setFieldLabel("직종세명");
		     	   dtilNotOccuClsNm.addKeyListener(new KeyListener() {
		               public void componentKeyDown(ComponentEvent event) {
		                 
		                   dtilNotOccuClsNm.validate();
		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                	   reOccuNotload(); 
		                   }
		                   super.componentKeyDown(event);
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
		      	    
		     	    layoutContainer_17.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		     	    layoutContainer_17.add(btnUsrSearch3);
		     	    lycSreach3.add(layoutContainer_17);		     	     
		     	   msfGridPanelBass0350Bottom.setTopComponent(lycSreach3);
	        
		          //툴바메뉴
		            ToolBar bottomToolbar = new ToolBar();  
		            bottomToolbar.add(new FillToolItem());
		            
		            // 첫번째 사용직종정보 툴바
		            // ================전체선택버튼=========================
		            btnSelectBass0360 = new Button("전체선택");
		            btnSelectBass0360.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
		                public void componentSelected(ButtonEvent ce) { 
		                	
		                	  int  lsCnt = msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
		                		  msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0350Top.getMsfGrid().getGrid().getView().refresh(true);
		    		    }
		            });

		            bottomToolbar.add(btnSelectBass0360);
		            bottomToolbar.add(new SeparatorMenuItem());
		            //====================================================
		            
		           // ================전체해제버튼=========================
		            btnUnSelectBass0360 = new Button("전체해제");
		            btnUnSelectBass0360.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                	
		                	  int  lsCnt = msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
		                		  msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0350Top.getMsfGrid().getGrid().getView().refresh(true);
		                }  
		            });

		            bottomToolbar.add(btnUnSelectBass0360);
		            bottomToolbar.add(new SeparatorMenuItem());
		            //====================================================
		            
		            saveButton = new Button("미사용");
		            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {   
		            	
		                public void componentSelected(ButtonEvent ce) {           	    
		                	  Iterator<BaseModel> itBm  = msfGridPanelBass0350Top.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
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
		    		            	  //int lsCntOccu = listStoreA041.getCount(); // 권한사용되는 직종갯수를 가져옴.
		    		            	  //int dtilOccu = lsDtilOccuInttnCd.getCount(); //권한사용되는 직종세 갯수를 가져옴.

		    		            	  int cnt = 0; // 직종비교가 맞는것이 있는지 카운터 세는 변수
		    		            	  
		    		            	  /*for(int iCnt=0;iCnt<lsCntOccu;iCnt++){   //직종카운트
		    		            		  for(int jCnt=0;jCnt<dtilOccu;jCnt++){ //직종세카운트
		    		            			  if(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuNm")).equals(listStoreA041.getAt(iCnt).get("typOccuNm"))
		    		            			     && MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsNm")).equals(lsDtilOccuInttnCd.getAt(jCnt).get("dtilOccuClsNm"))){
			    		            			  MessageBox.alert("오류", "사용하고 있는 " + "["+bmMapModel.get("typOccuNm")+"]" + " 직종의 " +
			    		            		      "["+ bmMapModel.get("dtilOccuClsNm") + "]" +"직종세는 삭제할 수 없습니다.", null);
			    		            		      cnt++;
			    		            		  }  
		    		            		  }		    		            		  
		    		            	  }*/
		    		            	  if(cnt==0){
		    		            		 
		    		            		  Bass0350DTO bass0350Dto = new Bass0350DTO();		    		            	  
			    		            	  bass0350Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));	    		            
			    		            	  bass0350Dto.setDtilOccuJbfmlDivCd("");
			    		            	  bass0350Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    		            	  
	 
			    		            	  bass0350Update(bass0350Dto);	
		    		            	  }
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
		                	msfGridPanelBass0350Top.reload();	                	
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
		                	
		                	  int  lsCnt = msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
		                		  msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getView().refresh(true);
		                	  
		                }  
		            });

		            bottomToolbar2.add(btnSelectBass0350);
		            bottomToolbar2.add(new SeparatorMenuItem());
		            //====================================================
		            
		           // ================전체해제버튼=========================
		            btnUnSelectBass0350  = new Button("전체해제");
		            btnUnSelectBass0350.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  

		                	  int  lsCnt = msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
		                		  msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getView().refresh(true);
		                }  
		            });

		            bottomToolbar2.add(btnUnSelectBass0350);
		            bottomToolbar2.add(new SeparatorMenuItem());
		            //====================================================
		            
		            saveButton = new Button("사용");
		            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) { 
		                	 Iterator<BaseModel> itBm  = msfGridPanelBass0350Bottom.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
	    			          List<Record> lsRec  = new ArrayList<Record>();
	    			          while(itBm.hasNext()) {
	    			              Record rec  = new Record(itBm.next()); 
	    			              lsRec.add(rec);
	    			          }  
	    			          Iterator<Record> iterRecords = lsRec.iterator();
	    			          
	    		              while (iterRecords.hasNext()) {	    		            	  
	    		            	  Record recData = (Record) iterRecords.next(); 
		    		              BaseModel bmMapModel = (BaseModel)recData.getModel();
		    		              
		    		            //  System.out.println("select의 값 : " + bmMapModel.get("select"));
		    		              
		    		              // select에 null값이 들어가있으므로 널포인트에러뜸.
		    		              // 그래서 null인것은 false로 강제변환시킴.
		    		              if((Boolean)bmMapModel.get("select")==null){
		    		            		 bmMapModel.set("select", false);
		    		            	 }		    		              
		    		              
		    		              if ((Boolean)bmMapModel.get("select")) {	
		    		            	  Bass0350DTO bass0350Dto = new Bass0350DTO();		    		            	  
		    		            	  bass0350Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
		    		            	  bass0350Dto.setDtilOccuJbfmlDivCd(commCd);
		    		            	  bass0350Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    		            	  
		    		            	  bass0350Update(bass0350Dto);		    		            	
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
		                	msfGridPanelBass0350Bottom.reload();
		                }  
		            });		            
		            bottomToolbar2.add(refresh2);
		            
		            //툴바 넣어주는것
		            msfGridPanelBass0350Top.setBottomComponent(bottomToolbar);
		            msfGridPanelBass0350Bottom.setBottomComponent(bottomToolbar2);
		            
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
		     	    layoutContainer_16.add(msfGridPanelBass0350Top);
		     	    layoutContainer_16.add(space);
		     	    layoutContainer_16.add(msfGridPanelBass0350Bottom);
		     	    
		            inner.add(layoutContainer_16);		            
		            
		        plFrmpAYR5020.add(inner);

				vp.add(plFrmpAYR5020);
				plFrmpAYR5020.setSize("990px", "680px");
			  }	
			  
			  
//	private void readtry() {
//		 Object str = msfGridPanelBass0300.getMsfGrid().getCurrentlySelectedItem().get("deptCd").toString();
//         msfGridPanelBass0350Top.getTableDef().setTableColumnFilters(null);
//         TextField<String> deptCd = new TextField<String>();
//         deptCd.setValue((String)str); 
//        msfGridPanelBass0350Top.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//       	msfGridPanelBass0350Top.unmask();
//     	msfGridPanelBass0350Top.reload();
//	}	
//	
//	private void readtry2() {
//		Object str = msfGridPanelBass0300.getMsfGrid().getCurrentlySelectedItem().get("deptCd").toString();
//        msfGridPanelBass0350Bottom.getTableDef().setTableColumnFilters(null);
//        TextField<String> deptCd = new TextField<String>();
//        deptCd.setValue((String)str);       
//    	msfGridPanelBass0350Bottom.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//      	msfGridPanelBass0350Bottom.unmask();
//    	msfGridPanelBass0350Bottom.reload();
//	}		  
//
//	private void readProfiles(Bass0400BM dept){
//
//    }
    
//    private void composeListaProfiles(List<Bass0400DTO> listaPrf) {
//   	Iterator<Bass0400DTO> iter = listaPrf.iterator();
//        List<BaseModel> list = new ArrayList<BaseModel>();
//        Bass0400DTO att = new Bass0400DTO();
//        while ( iter.hasNext() ) {
//        	att = (Bass0400DTO) iter.next();
//            BaseModel bm = new BaseModel();
//            bm.set("deptCd", att.getDeptCd());
//            list.add(bm);
//        }     	
//    }

  
 
    // 부서관리 검색 메소드
    public void reDeptload() {
    	msfGridPanelBass0300.getTableDef().setTableColumnFilters(null);   
    	msfGridPanelBass0300.getTableDef().addColumnFilter("commCdNm", MSFSharedUtils.defaultNulls(commCdNm.getValue(),""), SimpleColumnFilter.OPERATOR_LIKE); 
    	msfGridPanelBass0300.reload();
    }
    
    // 사용 직종정보 (직종세통합코드) 메소드
	public void reOccuInload() {
	    	IColumnFilter filters = null;
	        msfGridPanelBass0350Top.getTableDef().setTableColumnFilters(null); 	    
	        //msfGridPanelBass0350Top.getTableDef().addColumnFilter("dtilOccuJbfmlDivCd", MSFSharedUtils.defaultNulls(commCd,""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        msfGridPanelBass0350Top.getTableDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(dtilOccuClsNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        
	        msfGridPanelBass0350Top.reload();
	}
	
	// 미사용 직종정보 (직종세통합코드) 메소드
	public void reOccuNotload() {
		   IColumnFilter filters = null;
		   msfGridPanelBass0350Bottom.getTableDef().setTableColumnFilters(filters);  	 
		   msfGridPanelBass0350Bottom.getTableDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(dtilNotOccuClsNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		   msfGridPanelBass0350Bottom.reload();
	}
	
    private Payr5020 getThis(){
        return this;
    }
    
/*    private void bass0360Delete(Bass0360DTO bass0360Dto) {
    	bass0450service.bass0360Delete(bass0360Dto, new AsyncCallback<Long>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("bass0360Delete(삭제오류) : " + caught), null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					msfGridPanelBass0350Top.reload();
					msfGridPanelBass0350Bottom.reload();
				} else {
					
				}
			}
		});
	}*/
    
    private void bass0350Update(Bass0350DTO bass0350Dto) {
    	                
    	payr5020Service.bass0350Update(bass0350Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("bass0350Update(업데이트 오류) : " + caught), null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					msfGridPanelBass0350Top.reload();
					msfGridPanelBass0350Bottom.reload();
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
