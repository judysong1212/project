package com.app.exterms.insurance.client.form;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr0200DTO;
import com.app.exterms.insurance.client.service.Insr1100Service;
import com.app.exterms.insurance.client.service.Insr1100ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extend s MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Insr1100 extends MSFPanel {



/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작
 *##########################################################################
 **/
	    

	
	//검색조건
	private ComboBox<BaseModel> searchStdYear;
	
	private EditorGrid<Insr0200DTO> insr0240Grid;
	private EditorGrid<Insr0200DTO> insr0250Grid;
	private EditorGrid<Insr0200DTO> insr0260Grid;
	private EditorGrid<Insr0200DTO> insr0270Grid;
	
	private Insr1100ServiceAsync insr1100Service = Insr1100Service.Util.getInstance();
	
	private RpcProxy<BaseListLoadResult<Insr0200DTO>> insr0240Proxy = new RpcProxy<BaseListLoadResult<Insr0200DTO>>(){
		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback) {
			Insr0200DTO dto = new Insr0200DTO();
			dto.setHlthInsrStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
			insr1100Service.selectInsr0240((BaseListLoadConfig)loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderInsr0240 = new BaseListLoader<BaseListLoadResult<ModelData>>(insr0240Proxy);
	private ListStore<Insr0200DTO> storeInsr0240 = new ListStore<Insr0200DTO>(loaderInsr0240);
	
	private RpcProxy<BaseListLoadResult<Insr0200DTO>> insr0250Proxy = new RpcProxy<BaseListLoadResult<Insr0200DTO>>(){
		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback) {
			Insr0200DTO dto = new Insr0200DTO();
			dto.setNatPennStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
			insr1100Service.selectInsr0250((BaseListLoadConfig)loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderInsr0250 = new BaseListLoader<BaseListLoadResult<ModelData>>(insr0250Proxy);
	private ListStore<Insr0200DTO> storeInsr0250 = new ListStore<Insr0200DTO>(loaderInsr0250);
	
	private RpcProxy<BaseListLoadResult<Insr0200DTO>> insr0260Proxy = new RpcProxy<BaseListLoadResult<Insr0200DTO>>(){
		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback) {
			Insr0200DTO dto = new Insr0200DTO();
			dto.setUmytInsrStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
			insr1100Service.selectInsr0260((BaseListLoadConfig)loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderInsr0260 = new BaseListLoader<BaseListLoadResult<ModelData>>(insr0260Proxy);
	private ListStore<Insr0200DTO> storeInsr0260 = new ListStore<Insr0200DTO>(loaderInsr0260);
	
	private RpcProxy<BaseListLoadResult<Insr0200DTO>> insr0270Proxy = new RpcProxy<BaseListLoadResult<Insr0200DTO>>(){
		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback) {
			Insr0200DTO dto = new Insr0200DTO();
			dto.setIdtlAccdtInsurStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
			insr1100Service.selectInsr0270((BaseListLoadConfig)loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderInsr0270 = new BaseListLoader<BaseListLoadResult<ModelData>>(insr0270Proxy);
	private ListStore<Insr0200DTO> storeInsr0270 = new ListStore<Insr0200DTO>(loaderInsr0270);
	
	private TabPanel tabsPsnl;
	
	private SysCoCalendarDTO msfCoCalendarDto;  
	
	private ListStore<BaseModel>  lscrPayYr = new ListStore<BaseModel>(); 
	 
/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	


	private VerticalPanel vp;
	private FormPanel plFrmPayr2100;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;


	  
	   /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 상태처리 전역변수
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
     
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 화면 렌더링 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
       
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * Button 변수 선언
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
 
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
    
      /** 
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
 
	 
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
     
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	 
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// detailTp = XTemplate.create(getDetailTemplate());
	// // formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(5);
	// createPayr2100Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createTabForm(); //탭구성
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }
	

	public ContentPanel getViewPanel() {
		if (panel == null) {

			detailTp = XTemplate.create(getDetailTemplate());
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(5);
			createPayr2100Form(); // 화면 기본정보를 설정
			createSearchForm(); // 검색필드를 적용
			createTabForm(); // 탭구성
			add(vp);
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			// panel.setScrollMode(Scroll.AUTO);
			panel.add(vp);

		}
		return panel;
	}

	

/**
 *############################################################################# 
 * 프로그램 종료  	  
 *############################################################################# 
 **/	  

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 생성자 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 	
	/**
	 * @wbp.parser.constructor
	 */
	public Insr1100() {
		setSize("1010px", "700px");
	}

	public Insr1100(String txtForm) {
		this.txtForm = txtForm;
	}
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 생성자 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/		 
  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 시작
 * 1. 폼 생성 선언
 * 2. 공통 버튼 처리 선언
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/	  
	  
 /**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 


	// TODO 검색필드 설정
	private void createSearchForm() {
		
		 msfCoCalendarDto = new SysCoCalendarDTO();
		 //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	     lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	     
		
		plFrmPayr2100.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);

		
		searchStdYear = new ComboBox<BaseModel>();
		searchStdYear.setFieldLabel("기준년도");
		searchStdYear.setForceSelection(true);
		searchStdYear.setMinChars(1);
		searchStdYear.setDisplayField("yearDisp");
		searchStdYear.setValueField("year");
		searchStdYear.setTriggerAction(TriggerAction.ALL);
		searchStdYear.setEmptyText("--기준년도선택--");
		searchStdYear.setSelectOnFocus(true);
//		ListStore<BaseModel> ys = new ListStore<BaseModel>();
//		BaseModel bm = new BaseModel();
//		bm.set("commCd", "2014");
//		bm.set("commCdNm", "2014");
//		ys.add(bm);
		searchStdYear.setStore(lscrPayYr);
		searchStdYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
               public void handleEvent(StoreEvent<BaseModel> be) {  
 
                   searchStdYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
                    
               }
           });
		
		lcSchLeft.add(searchStdYear, new FormData("100%"));

		LayoutContainer layoutContainer = new LayoutContainer();

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FormLayout());
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FormLayout());
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.setBorders(false);
		lcSchRight.add(layoutContainer, new FormData("100%"));
		layoutContainer.setLayout(new ColumnLayout());
		layoutContainer.setBorders(false);

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmPayr2100.add(fieldSet);
		
	}
  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/   
  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 기본등록화면 입력 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/  

	private void createPayr2100Form() {

		plFrmPayr2100 = new FormPanel();
		plFrmPayr2100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 사회보험기준관리"));
		plFrmPayr2100.setIcon(Resources.APP_ICONS.text());
		// plFrmPayr2100.setBodyStyleName("pad-text");
		plFrmPayr2100.setPadding(5);
		plFrmPayr2100.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("사회보험기준관리","INSR1100");
				}
			});
		plFrmPayr2100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr2100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/


		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FlowLayout());

		layoutContainer.add(layoutContainer_1,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		ButtonBar buttonBar = new ButtonBar();
		layoutContainer_2.add(buttonBar);
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button topBtn = new Button("조회");
		topBtn.setIcon(Resources.APP_ICONS.search16());
		topBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if("item01".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0240.load();
				}else if("item02".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0250.load();
				}else if("item03".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0260.load();
				}else if("item04".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0270.load();
				}
			}
		});
		buttonBar.add(topBtn);

		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.setBorders(false);
		plFrmPayr2100.add(layoutContainer);
		layoutContainer.setBorders(false);

		// 파일업로드 처리
		plFrmPayr2100.setAction("bizform");
		plFrmPayr2100.setEncoding(Encoding.MULTIPART);
		plFrmPayr2100.setMethod(Method.POST);

		vp.add(plFrmPayr2100);
		plFrmPayr2100.setSize("990px", "690px");
	}	
	

	private void createTabForm() {

		tabsPsnl = new TabPanel(); // 탭정보설정을 위한 tab
		// tabsPsnl.setMinTabWidth(80);
		tabsPsnl.setAutoWidth(false);
		// tabsPsnl.setResizeTabs(true);
		tabsPsnl.setAnimScroll(true);
		tabsPsnl.setTabScroll(true);
		tabsPsnl.setPlain(true);
		tabsPsnl.setSize(970, 555);
		tabsPsnl.setStyleAttribute("marginTop", "10px");
		
		TabItem item01 = new TabItem();
		item01.setStyleAttribute("padding", "10px");
		item01.setText("건강보험");
		item01.setId("item01");
		item01.addStyleName("pad-text");
		item01.setLayout(new FormLayout());

		item01.add(Data01(), new FormData("100%"));
		tabsPsnl.add(item01);

		TabItem item02 = new TabItem();
		item02.setStyleAttribute("padding", "10px");
		item02.setText("국민연금");
		item02.setId("item02");
		item02.setLayout(new FormLayout());
		item02.add(Data02(), new FormData("100%"));
		tabsPsnl.add(item02);

		TabItem item03 = new TabItem();
		item03.setStyleAttribute("padding", "10px");
		item03.setText("고용보험");
		item03.setId("item03");
		item03.setLayout(new FormLayout());
		item03.add(Data03(), new FormData("100%"));

		tabsPsnl.add(item03);

		TabItem item04 = new TabItem();
		item04.setStyleAttribute("padding", "10px");
		item04.setText("산재보험(공무직)");
		item04.setId("item04");
		item04.setLayout(new FormLayout());
		item04.add(Data04(), new FormData("100%"));

		tabsPsnl.add(item04);
		
		tabsPsnl.addListener(Events.Select, new Listener<TabPanelEvent>() {
			@Override
			public void handleEvent(TabPanelEvent be) {
				if("item01".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0240.load();
				}else if("item02".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0250.load();
				}else if("item03".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0260.load();
				}else if("item04".equals(tabsPsnl.getSelectedItem().getId())){
					loaderInsr0270.load();
				}
			}
			
		});
		
		
		plFrmPayr2100.add(tabsPsnl, new FormData("100%"));
	}
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 기본등록화면 입력 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/   
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 

	// TODO 건강보험
	private LayoutContainer Data01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Insr0200DTO> sm = new CheckBoxSelectionModel<Insr0200DTO>();
		// selection model supports the SIMPLE selection mode
		// sm.setSelectionMode(SelectionMode.SIMPLE);

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("hlthInsrStdYr");
		column.setHeaderText("기준년도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("hlthInsrMinmMnthRuntnAmnt");
		column.setHeaderText("최저보수월액");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig("hlthInsrBstMnthRuntnAmnt", "최고보수월액", 100);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("hlthInsrUsrBrdnApmrt");
		column.setHeaderText("건강요율(사)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("hlthInsrHmlfBrdnApmrt");
		column.setHeaderText("건강요율(본)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("hlthRcptnUsrBrdnApmrt");
		column.setHeaderText("요양요율(사)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("hlthRcptnHmlfBrdnApmrt");
		column.setHeaderText("요양요율(본)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);
		
		DateField df1 = new DateField();
		df1.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("hlthInsrBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df1));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);
		
		DateField df2 = new DateField();
		df2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		
		column = new ColumnConfig();
		column.setId("hlthInsrEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		//column.setEditor(new CellEditor(df2));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);

		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(950, 520);

		insr0240Grid = new EditorGrid<Insr0200DTO>(storeInsr0240, cm);
		insr0240Grid.setStateId("insr0240Grid");
		insr0240Grid.setStateful(false);
		insr0240Grid.setLoadMask(true); // 작업중표시
		insr0240Grid.setBorders(true);
		insr0240Grid.setColumnResize(true);
		insr0240Grid.setSelectionModel(sm);
		insr0240Grid.addPlugin(sm);
		
		insr0240Grid.addListener(Events.BeforeEdit, new Listener<GridEvent<Insr0200DTO>>() {
			@Override
			public void handleEvent(GridEvent<Insr0200DTO> be) {
				//날짜를 변경할 경우
				if( be.getModel().getDpobCd() != null && !"".equals(be.getModel().getDpobCd())&& be.getColIndex() == 9){
					MessageBox.info("", "시작날짜는 변경할수 없습니다.", null);
				}
				
			}
		});
		
		cp01.add(insr0240Grid);

		cp01.addButton(new Button("신 규", new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(storeInsr0240.getCount() > 0 && storeInsr0240.getAt(0).getDpobCd() == null ){
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					insr0240Grid.stopEditing();
					Insr0200DTO dto = new Insr0200DTO();
					dto.setHlthInsrStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
					storeInsr0240.insert(dto, 0);
					insr0240Grid.startEditing(storeInsr0240.indexOf(dto), 3);
				}
			}
		}));

		cp01.addButton(new Button("삭 제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("건강보험 삭제", "건강보험정보를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							insr1100Service.deleteInsr0240(insr0240Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
								@Override
								public void onSuccess(Integer result) {
									MessageBox.info("삭제완료", "건강보험이 삭제되었습니다.", null);
									loaderInsr0240.load();
								}
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("삭제실패", "건강보험 삭제가 실패 하였습니다.", null);	
								}
							});
						}
					}
				});
				
			}
		}));

		cp01.addButton(new Button("저 장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("건강보험 저장", "건강보험정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							List<Insr0200DTO> dto = new ArrayList<Insr0200DTO>();
							for ( int i = 0; i < storeInsr0240.getCount(); i++){
								if(storeInsr0240.getRecord(storeInsr0240.getAt(i)).isDirty()){
									dto.add(storeInsr0240.getAt(i));
								}
							}
							insr1100Service.saveInsr0240(dto, new AsyncCallback<String>() {
								@Override
								public void onSuccess(String result) {
									MessageBox.info("저장완료", "건강보험이 저장되었습니다.", null);
									loaderInsr0240.load();
								}
								
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("저장실패", "건강보험 저장이 실패 하였습니다.", null);
								}
							});
						}
					}
				});
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	// TODO 국민연금
	private LayoutContainer Data02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Insr0200DTO> sm = new CheckBoxSelectionModel<Insr0200DTO>();
		// selection model supports the SIMPLE selection mode
		// sm.setSelectionMode(SelectionMode.SIMPLE);

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("natPennStdYr");
		column.setHeaderText("기준년도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("natPennMinmIncmMnthAmnt");
		column.setHeaderText("최저소득월액");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig("natPennBstIncmMnthAmnt", "최고소득월액", 100);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("natPennUsrBrdnApmrt");
		column.setHeaderText("국민요율(사)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("natPennHmlfBrdnApmrt");
		column.setHeaderText("국민요율(본)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);
		
		DateField df1 = new DateField();
		df1.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("natPennBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df1));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);
		
		DateField df2 = new DateField();
		df2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("natPennEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df2));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);


		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(950, 520);

		insr0250Grid = new EditorGrid<Insr0200DTO>(storeInsr0250, cm);
		insr0250Grid.setStateId("insr0250Grid");
		insr0250Grid.setStateful(false);
		insr0250Grid.setLoadMask(true); // 작업중표시
		insr0250Grid.setBorders(true);
		insr0250Grid.setColumnResize(true);
		insr0250Grid.setSelectionModel(sm);
		insr0250Grid.addPlugin(sm);
		
		insr0250Grid.addListener(Events.BeforeEdit, new Listener<GridEvent<Insr0200DTO>>() {
			@Override
			public void handleEvent(GridEvent<Insr0200DTO> be) {
				//날짜를 변경할 경우
				if( be.getModel().getDpobCd() != null && !"".equals(be.getModel().getDpobCd())&& be.getColIndex() == 7){
					MessageBox.info("", "시작날짜는 변경할수 없습니다.", null);
				}
				
			}
		});
		
		cp01.add(insr0250Grid);

		cp01.addButton(new Button("신 규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(storeInsr0250.getCount() > 0 && storeInsr0250.getAt(0).getDpobCd() == null ){
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					insr0250Grid.stopEditing();
					Insr0200DTO dto = new Insr0200DTO();
					dto.setNatPennStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
					storeInsr0250.insert(dto, 0);
					insr0250Grid.startEditing(storeInsr0250.indexOf(dto), 3);
				}
			}
		}));

		cp01.addButton(new Button("삭 제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("국민연금 삭제", "국민연금정보를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							insr1100Service.deleteInsr0250(insr0250Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
								@Override
								public void onSuccess(Integer result) {
									MessageBox.info("삭제완료", "국민연금이 삭제되었습니다.", null);
									loaderInsr0250.load();
								}
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("삭제실패", "국민연금 삭제가 실패 하였습니다.", null);	
								}
							});
						}
					}
				});
				
			}
		}));

		cp01.addButton(new Button("저 장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("국민연금 저장", "국민연금정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							List<Insr0200DTO> dto = new ArrayList<Insr0200DTO>();
							for ( int i = 0; i < storeInsr0250.getCount(); i++){
								if(storeInsr0250.getRecord(storeInsr0250.getAt(i)).isDirty()){
									dto.add(storeInsr0250.getAt(i));
								}
							}
							insr1100Service.saveInsr0250(dto, new AsyncCallback<String>() {
								@Override
								public void onSuccess(String result) {
									MessageBox.info("저장완료", "건강보험이 저장되었습니다.", null);
									loaderInsr0250.load();
								}
								
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("저장실패", "건강보험 저장이 실패 하였습니다.", null);
								}
							});
						}
					}
				});
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	// TODO 고용보험
	private LayoutContainer Data03() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Insr0200DTO> sm = new CheckBoxSelectionModel<Insr0200DTO>();
		// selection model supports the SIMPLE selection mode
		// sm.setSelectionMode(SelectionMode.SIMPLE);

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("umytInsrStdYr");
		column.setHeaderText("기준년도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("umytInsrMinmIncmMnthAmnt");
		column.setHeaderText("고용 최저보수월액");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("umytInsrBstIncmMnthAmnt");
		column.setHeaderText("고용 최고보수월액");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("umytInsrHmlfBrdnApmrt");
		column.setHeaderText("고용요율(본)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("umytInsrUsrBrdnApmrt");
		column.setHeaderText("고용요율(사)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("umytInsrUsrSftyEbisApmrt");
		column.setHeaderText("고용안정등사업요율");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(120);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);
		
		DateField df1 = new DateField();
		df1.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		
		column = new ColumnConfig();
		column.setId("umytInsrBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df1));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);
		
		DateField df2 = new DateField();
		df2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("umytInsrEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df2));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);


		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(950, 520);

		insr0260Grid = new EditorGrid<Insr0200DTO>(storeInsr0260, cm);
		insr0260Grid.setStateId("insr0260Grid");
		insr0260Grid.setStateful(false);
		insr0260Grid.setLoadMask(true); // 작업중표시
		insr0260Grid.setBorders(true);
		insr0260Grid.setColumnResize(true);
		insr0260Grid.setSelectionModel(sm);
		insr0260Grid.addPlugin(sm);
		
		insr0260Grid.addListener(Events.BeforeEdit, new Listener<GridEvent<Insr0200DTO>>() {
			@Override
			public void handleEvent(GridEvent<Insr0200DTO> be) {
				//날짜를 변경할 경우
				if( be.getModel().getDpobCd() != null && !"".equals(be.getModel().getDpobCd())&& be.getColIndex() == 8){
					MessageBox.info("", "시작날짜는 변경할수 없습니다.", null);
				}
				
			}
		});
		
		cp01.add(insr0260Grid);

		cp01.addButton(new Button("신 규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(storeInsr0260.getCount() > 0 && storeInsr0260.getAt(0).getDpobCd() == null ){
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					insr0260Grid.stopEditing();
					Insr0200DTO dto = new Insr0200DTO();
					dto.setUmytInsrStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
					storeInsr0260.insert(dto, 0);
					insr0260Grid.startEditing(storeInsr0260.indexOf(dto), 3);
				}
			}
		}));

		cp01.addButton(new Button("삭 제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("고용보험 삭제", "고용보험정보를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							insr1100Service.deleteInsr0260(insr0260Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
								@Override
								public void onSuccess(Integer result) {
									MessageBox.info("삭제완료", "고용보험이 삭제되었습니다.", null);
									loaderInsr0260.load();
								}
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("삭제실패", "고용보험 삭제가 실패 하였습니다.", null);	
								}
							});
						}
					}
				});
			}
		}));

		cp01.addButton(new Button("저 장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("고용보험 저장", "고용보험정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							List<Insr0200DTO> dto = new ArrayList<Insr0200DTO>();
							for ( int i = 0; i < storeInsr0260.getCount(); i++){
								if(storeInsr0260.getRecord(storeInsr0260.getAt(i)).isDirty()){
									dto.add(storeInsr0260.getAt(i));
								}
							}
							insr1100Service.saveInsr0260(dto, new AsyncCallback<String>() {
								@Override
								public void onSuccess(String result) {
									MessageBox.info("저장완료", "고용보험이 저장되었습니다.", null);
									loaderInsr0260.load();
								}
								
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("저장실패", "고용보험 저장이 실패 하였습니다.", null);
								}
							});
						}
					}
				});
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	// TODO 산재보험
	private LayoutContainer Data04() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Insr0200DTO> sm = new CheckBoxSelectionModel<Insr0200DTO>();
		// selection model supports the SIMPLE selection mode
		// sm.setSelectionMode(SelectionMode.SIMPLE);

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("idtlAccdtInsurStdYr");
		column.setHeaderText("기준년도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);

		column = new ColumnConfig();
		column.setId("idtlAccdtInsurUsrApmrt");
		column.setHeaderText("산재요율(사)");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(new TextField<String>()));
		configs.add(column);
		
		DateField df1 = new DateField();
		df1.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("idtlAccdtInsurBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df1));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);
		
		DateField df2 = new DateField();
		df2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("idtlAccdtInsurEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setEditor(new CellEditor(df2));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		configs.add(column);


		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(950, 520);

		insr0270Grid = new EditorGrid<Insr0200DTO>(storeInsr0270, cm);
		insr0270Grid.setStateId("insr0270Grid");
		insr0270Grid.setStateful(false);
		insr0270Grid.setLoadMask(true); // 작업중표시
		insr0270Grid.setBorders(true);
		insr0270Grid.setColumnResize(true);
		insr0270Grid.setSelectionModel(sm);
		insr0270Grid.addPlugin(sm);
		
		insr0270Grid.addListener(Events.BeforeEdit, new Listener<GridEvent<Insr0200DTO>>() {
			@Override
			public void handleEvent(GridEvent<Insr0200DTO> be) {
				//날짜를 변경할 경우
				if( be.getModel().getDpobCd() != null && !"".equals(be.getModel().getDpobCd())&& be.getColIndex() == 4){
					MessageBox.info("", "시작날짜는 변경할수 없습니다.", null);
				}
				
			}
		});
		
		cp01.add(insr0270Grid);

		cp01.addButton(new Button("신 규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(storeInsr0270.getCount() > 0 && storeInsr0270.getAt(0).getDpobCd() == null ){
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					insr0270Grid.stopEditing();
					Insr0200DTO dto = new Insr0200DTO();
					dto.setIdtlAccdtInsurStdYr(MSFSharedUtils.getSelectedComboValue(searchStdYear,"year"));
					storeInsr0270.insert(dto, 0);
					insr0270Grid.startEditing(storeInsr0270.indexOf(dto), 3);
				}
			}
		}));

		cp01.addButton(new Button("삭 제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("산재보험 삭제", "산재보험정보를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							insr1100Service.deleteInsr0270(insr0270Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
								@Override
								public void onSuccess(Integer result) {
									MessageBox.info("삭제완료", "산재보험이 삭제되었습니다.", null);
									loaderInsr0270.load();
								}
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("삭제실패", "산재보험 삭제가 실패 하였습니다.", null);	
								}
							});
						}
					}
				});
				
			}
		}));

		cp01.addButton(new Button("저 장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("산재보험 저장", "산재보험정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							List<Insr0200DTO> dto = new ArrayList<Insr0200DTO>();
							for ( int i = 0; i < storeInsr0270.getCount(); i++){
								if(storeInsr0270.getRecord(storeInsr0270.getAt(i)).isDirty()){
									dto.add(storeInsr0270.getAt(i));
								}
							}
							insr1100Service.saveInsr0270(dto, new AsyncCallback<String>() {
								@Override
								public void onSuccess(String result) {
									MessageBox.info("저장완료", "산재보험이 저장되었습니다.", null);
									loaderInsr0270.load();
								}
								
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.info("저장실패", "산재보험 저장이 실패 하였습니다.", null);
								}
							});
						}
					}
				});
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	} 
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 
   
	  

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	 



	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
	}-*/;


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
