package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0360DTO;
import com.app.exterms.basis.client.dto.Bass0400BM;
import com.app.exterms.basis.client.form.defs.Bass0450Def;
import com.app.exterms.basis.client.service.Bass0450Service;
import com.app.exterms.basis.client.service.Bass0450ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
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
import com.extjs.gxt.ui.client.store.ListStore;
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
public class Bass0450  extends MSFPanel { 
	
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
	  private XTemplate detailTp;	  
	  private Bass0450ServiceAsync bass0450service = Bass0450Service.Util.getInstance();  
	  private Button saveButton;
	  private Button saveButton2;	    
	  private Button btnSelectBass0360;
	  private Button btnSelectBass0350;
	  private Button btnUnSelectBass0360;
	  private Button btnUnSelectBass0350;
	  private Bass0400BM dept;
	  private Bass0450Def bass0400Def = new Bass0450Def("BASS0400");
	  private Bass0450Def bass0360Def = new Bass0450Def("BASS0360"); 
	  private Bass0450Def bass0350Def = new Bass0450Def("BASS0350");

	  private MSFGridPanel msfGridPanelBass0450; 
	  private MSFGridPanel msfGridPanelBass0360;
	  private MSFGridPanel msfGridPanelBass0350;
	  private TextField<String> deptNmHan ;  // 부서명 텍스트필드 변수
	  private TextField<String> dtilOccuClsNm; // 사용직종정보 직종세 통합코드 변수
	  private TextField<String> dtilNotOccuClsNm; // 미사용직종정보 직종세 통합코드 변수
	  private String deptCd;
	  
  	  private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>(); //직종
  	  private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
	   
	  private PrgmComBass0320DTO sysComBass0320Dto = new PrgmComBass0320DTO();	//직종
	  private PrgmComBass0350DTO sysComBass0350Dto = new PrgmComBass0350DTO();	//직종세
      
	  public ContentPanel getViewPanel() {
        if (panel == null) {        	
          
            
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createSysm0500Form();  //화면 기본정보를 설정
		    vp.setSize("1010px", "700px");    
		    
		    
		    /**
	          * Create the relations 
	          */
			   final RelationDef  relBass0360 = new RelationDef(bass0400Def,false);
			   relBass0360.addJoinDef("dpobCd", "dpobCd"); 
			   relBass0360.addJoinDef("deptCd", "deptCd"); 
			   relBass0360.setLinkedObject(msfGridPanelBass0450);
			   bass0360Def.addRelation(relBass0360); 
	           
//	           // DETAILS 
//	           final Grid bass0360DefGrid = msfGridPanelBass0450.getMsfGrid().getGrid();
//	           bass0360DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//	              public void handleEvent(BaseEvent be) {  
//	            	  if (msfGridPanelBass0450.getCurrentlySelectedItem() != null) { 
//	            		 
//	            		  bass0360Def.synchronizeGridDetail(
//	            				  msfGridPanelBass0450.getCurrentlySelectedItem(),
//	            				  msfGridPanelBass0360 );
//	            		  msfGridPanelBass0360.reload();
//	            	   }
//	             
//	           }
//	         }); 
	            
	            
	           /**
		          * Create the relations 
		          */
				   final RelationDef  relBass0350 = new RelationDef(bass0400Def,false);
				   relBass0350.addJoinDef("dpobCd", "dpobCd"); 
				   relBass0350.addJoinDef("deptCd", "deptCd"); 
				   relBass0350.setLinkedObject(msfGridPanelBass0450);
				   bass0350Def.addRelation(relBass0350); 
		           
		 
		           // DETAILS 
		           final Grid bass0350DefGrid = msfGridPanelBass0450.getMsfGrid().getGrid();
		           bass0350DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
		              public void handleEvent(BaseEvent be) {  
		            	  if (msfGridPanelBass0450.getCurrentlySelectedItem() != null) {  
		            		  
		            		  bass0360Def.synchronizeGridDetail(
		            				  msfGridPanelBass0450.getCurrentlySelectedItem(),
		            				  msfGridPanelBass0360 );
		            		//  msfGridPanelBass0360.reload();
		            		  
		            		  bass0350Def.synchronizeGridDetail(
		            				  msfGridPanelBass0450.getCurrentlySelectedItem(),
		            				  msfGridPanelBass0350 ); 
		            		//  msfGridPanelBass0350.reload();
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
			  public Bass0450() {
					setSize("1010px", "700px");  
			  } 
			
			  public Bass0450(String txtForm) {
					this.txtForm = txtForm;
			  }		  
			  
			  private void createSysm0500Form() {
				  
				listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);  
				lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);

				
				plFrmSysm0500 = new FormPanel();
				plFrmSysm0500.setHeadingText("PayGen Ver1.0 - 부서별직종세맵핑관리");
				plFrmSysm0500.setIcon(Resources.APP_ICONS.text());
				plFrmSysm0500.setBodyStyleName("pad-text");
				plFrmSysm0500.setFrame(true); 
				plFrmSysm0500.setPadding(2);
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
				 ************************************************************************/
				final Button btnlogView = new Button("로그");   
				
				btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
				btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						 //로그 뷰화면 호출 메서드 
						  funcLogMessage("부서별직종세관리","BASS0450");
						}
					});
				plFrmSysm0500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
				plFrmSysm0500.getHeader().addTool(btnlogView); 
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 
				 ************************************************************************/
				
				  
				    HorizontalPanel inner = new HorizontalPanel();
		            inner.setBorders(false);
		            inner.setLayout(new FitLayout());		            
		            bass0400Def.setReadOnly(true);   
		            msfGridPanelBass0450 = new MSFGridPanel(bass0400Def, false, false, false,true,false); 
		            msfGridPanelBass0450.setSize(300, 620);
		            msfGridPanelBass0450.setBorders(true);
		            msfGridPanelBass0450.getGrid().setBorders(true);
		            Grid grid = msfGridPanelBass0450.getMsfGrid().getGrid();
		            grid.addListener(Events.CellDoubleClick , new Listener<BaseEvent>() {
		                public void handleEvent(BaseEvent be) {
		                	
		                	 deptCd = MSFSharedUtils.allowNulls(msfGridPanelBass0450.getMsfGrid().getCurrentlySelectedItem().get("deptCd"));
		                	//msfGridPanelBass0360.mask(MSFMainApp.MSFMESSAGES.LoadingData());
		                	//dtilOccuClsNm.clear();	     
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
		     	   
		     	    deptNmHan = new TextField<String>();
		     	    deptNmHan.setFieldLabel("부서명");
		     	   deptNmHan.addKeyListener(new KeyListener() {
		    			public void componentKeyDown(ComponentEvent event) {
		    				 super.componentKeyDown(event);
			                   deptNmHan.validate();
			                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
			                	   reDeptload(); 
			                   }
		    			}
		    		});
		     	    
//		     	    deptNmHan.addKeyListener(new KeyListener() {
//		               public void componentKeyUp(ComponentEvent event) {
//		                   super.componentKeyUp(event);
//		                   deptNmHan.validate();
//		                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//		                	   reDeptload(); 
//		                   }
//		               }
//		           }); 
		     	    
		     	    layoutContainer_13.add(deptNmHan, new FormData("100%"));
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
		     	    msfGridPanelBass0450.setTopComponent(lycSreach);		            
		            inner.add(msfGridPanelBass0450);
		            
		            
		            // 두번째 컨테이너컬럼(사용직종정보)   
		            msfGridPanelBass0360 = new MSFGridPanel(bass0360Def, false, false, false, false,false); 
		            msfGridPanelBass0360.setSize(650, 300);
		            msfGridPanelBass0360.getGrid().setBorders(true);
		         
		            final Grid<BaseModel> grid2 = msfGridPanelBass0360.getMsfGrid().getGrid();
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
//		     	   layoutContainer_15.add(dtilOccuClsNm, new FormData("100%"));
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
		     	    msfGridPanelBass0360.setTopComponent(lycSreach2);

		     	    
		            // 세번째 컨테이너컬럼(미사용직종정보)  
			        msfGridPanelBass0350 = new MSFGridPanel(bass0350Def, false, false, false, false,false); 
			        msfGridPanelBass0350.setSize(650, 300);
			        msfGridPanelBass0350.setBorders(true);
			        
			        final Grid<BaseModel> grid3 = msfGridPanelBass0350.getMsfGrid().getGrid();
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
		     	    msfGridPanelBass0350.setTopComponent(lycSreach3);
	        
		          //툴바메뉴
		            ToolBar bottomToolbar = new ToolBar();  
		            bottomToolbar.add(new FillToolItem());
		            
		            // 첫번째 사용직종정보 툴바
		            // ================전체선택버튼=========================
		            btnSelectBass0360 = new Button("전체선택");
		            btnSelectBass0360.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
		                public void componentSelected(ButtonEvent ce) { 
		                	
		                	  int  lsCnt = msfGridPanelBass0360.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0360.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
		                		  msfGridPanelBass0360.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0360.getMsfGrid().getGrid().getView().refresh(true);
		    		    }
		            });
		            
		            
		            bottomToolbar.add(btnSelectBass0360);
		            bottomToolbar.add(new SeparatorMenuItem());
		            //====================================================
		            
		           // ================전체해제버튼=========================
		            btnUnSelectBass0360 = new Button("전체해제");
		            btnUnSelectBass0360.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  
		                	
		                	  int  lsCnt = msfGridPanelBass0360.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0360.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
		                		  msfGridPanelBass0360.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0360.getMsfGrid().getGrid().getView().refresh(true);
		                }  
		            });

		            bottomToolbar.add(btnUnSelectBass0360);
		            bottomToolbar.add(new SeparatorMenuItem());
		            //====================================================
		            
		            saveButton = new Button("미사용");
		            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {   
		            	
		                public void componentSelected(ButtonEvent ce) {           	    
		                	  Iterator<BaseModel> itBm  = msfGridPanelBass0360.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
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
		    		            	  int lsCntOccu = listStoreA041.getCount(); // 권한사용되는 직종갯수를 가져옴.
		    		            	  int dtilOccu = lsDtilOccuInttnCd.getCount(); //권한사용되는 직종세 갯수를 가져옴.

		    		            	  int cnt = 0; // 직종비교가 맞는것이 있는지 카운터 세는 변수
		    		            	  
		    		            	  for(int iCnt=0;iCnt<lsCntOccu;iCnt++){   //직종카운트
		    		            		  for(int jCnt=0;jCnt<dtilOccu;jCnt++){ //직종세카운트
		    		            			  if(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuNm")).equals(listStoreA041.getAt(iCnt).get("typOccuNm"))
		    		            			     && MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsNm")).equals(lsDtilOccuInttnCd.getAt(jCnt).get("dtilOccuClsNm"))){
			    		            			  MessageBox.alert("오류", "사용하고 있는 " + "["+bmMapModel.get("typOccuNm")+"]" + " 직종의 " +
			    		            		      "["+ bmMapModel.get("dtilOccuClsNm") + "]" +"직종세는 삭제할 수 없습니다.", null);
			    		            		      cnt++;
			    		            		  }  
		    		            		  }		    		            		  
		    		            	  }
		    		            	  if(cnt==0){
		    		            		  Bass0360DTO bass0360Dto = new Bass0360DTO();
			    		            	  
		    		            		  bass0360Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
		    		            		  bass0360Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));
		    		            		  bass0360Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));
		    		            		  bass0360Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    		            	  
	
		    		            		  bass0360Delete(bass0360Dto);
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
		                	msfGridPanelBass0360.reload();	                	
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
		                	
		                	  int  lsCnt = msfGridPanelBass0350.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0350.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
		                		  msfGridPanelBass0350.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0350.getMsfGrid().getGrid().getView().refresh(true);
		                	  
		                }  
		            });

		            bottomToolbar2.add(btnSelectBass0350);
		            bottomToolbar2.add(new SeparatorMenuItem());
		            //====================================================
		            
		           // ================전체해제버튼=========================
		            btnUnSelectBass0350  = new Button("전체해제");
		            btnUnSelectBass0350.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) {  

		                	  int  lsCnt = msfGridPanelBass0350.getMsfGrid().getGrid().getStore().getCount();
		                	  
		                	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
		                		  
		                		  msfGridPanelBass0350.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
		                		  msfGridPanelBass0350.getMsfGrid().getGrid().getStore().commitChanges();
		                		   
		                	  } 
		                	  msfGridPanelBass0350.getMsfGrid().getGrid().getView().refresh(true);
		                }  
		            });

		            bottomToolbar2.add(btnUnSelectBass0350);
		            bottomToolbar2.add(new SeparatorMenuItem());
		            //====================================================
		            
		            saveButton = new Button("사용");
		            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
		                public void componentSelected(ButtonEvent ce) { 
		                	 Iterator<BaseModel> itBm  = msfGridPanelBass0350.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
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
		    		            	  
		    		            	  Bass0360DTO bass0360Dto = new Bass0360DTO();
		    		            	  
		    		            	  bass0360Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
		    		            	  bass0360Dto.setDeptCd(deptCd);
		    		            	  bass0360Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));
		    		            	  bass0360Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    		            	  
 
		    		            	  bass0360Insert(bass0360Dto);		    		            	
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
		                	msfGridPanelBass0350.reload();
		                }  
		            });		            
		            bottomToolbar2.add(refresh2);
		            
		            //툴바 넣어주는것
		            msfGridPanelBass0360.setBottomComponent(bottomToolbar);
		            msfGridPanelBass0350.setBottomComponent(bottomToolbar2);
		            
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
		     	    layoutContainer_16.add(msfGridPanelBass0360);
		     	    layoutContainer_16.add(space);
		     	    layoutContainer_16.add(msfGridPanelBass0350);
		     	    
		            inner.add(layoutContainer_16);		            
		            
		        plFrmSysm0500.add(inner);

				vp.add(plFrmSysm0500);
				plFrmSysm0500.setSize("990px", "680px");
			  }	
			  
			  
//	private void readtry() {
//		 Object str = msfGridPanelBass0450.getMsfGrid().getCurrentlySelectedItem().get("deptCd").toString();
//         msfGridPanelBass0360.getTableDef().setTableColumnFilters(null);
//         TextField<String> deptCd = new TextField<String>();
//         deptCd.setValue((String)str); 
//        msfGridPanelBass0360.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//       	msfGridPanelBass0360.unmask();
//     	msfGridPanelBass0360.reload();
//	}	
//	
//	private void readtry2() {
//		Object str = msfGridPanelBass0450.getMsfGrid().getCurrentlySelectedItem().get("deptCd").toString();
//        msfGridPanelBass0350.getTableDef().setTableColumnFilters(null);
//        TextField<String> deptCd = new TextField<String>();
//        deptCd.setValue((String)str);       
//    	msfGridPanelBass0350.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(str,""), SimpleColumnFilter.OPERATOR_EQUALS);
//      	msfGridPanelBass0350.unmask();
//    	msfGridPanelBass0350.reload();
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
    	msfGridPanelBass0450.getTableDef().setTableColumnFilters(null);   
    	msfGridPanelBass0450.getTableDef().addColumnFilter("deptNmHan", MSFSharedUtils.defaultNulls(deptNmHan.getValue(),""), SimpleColumnFilter.OPERATOR_LIKE); 
    	msfGridPanelBass0450.reload();
    }
    
    // 사용 직종정보 (직종세통합코드) 메소드
	public void reOccuInload() {
	    	IColumnFilter filters = null;
	        msfGridPanelBass0360.getTableDef().setTableColumnFilters(filters); 	    
	        msfGridPanelBass0360.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(deptCd,""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        msfGridPanelBass0360.getTableDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(dtilOccuClsNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        msfGridPanelBass0360.reload();
	}
	
	// 미사용 직종정보 (직종세통합코드) 메소드
	public void reOccuNotload() {
		   IColumnFilter filters = null;
		   msfGridPanelBass0350.getTableDef().setTableColumnFilters(filters);  
		   msfGridPanelBass0350.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.defaultNulls(deptCd,""), SimpleColumnFilter.OPERATOR_EQUALS); 
		   msfGridPanelBass0350.getTableDef().addColumnFilter("dtilOccuClsNm", MSFSharedUtils.defaultNulls(dtilNotOccuClsNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
		   msfGridPanelBass0350.reload();
	}
	
    private Bass0450 getThis(){
        return this;
    }
    
    private void bass0360Delete(Bass0360DTO bass0360Dto) {
    	bass0450service.bass0360Delete(bass0360Dto, new AsyncCallback<Long>() {
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("bass0360Delete(삭제오류) : " + caught), null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					msfGridPanelBass0360.reload();
			        msfGridPanelBass0350.reload();
				} else {
					
				}
			}
		});
	}
    
    private void bass0360Insert(Bass0360DTO bass0360Dto) {
    	bass0450service.bass0360Insert(bass0360Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0320(인서트오류) : " + caught), null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					msfGridPanelBass0360.reload();
			        msfGridPanelBass0350.reload();
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
