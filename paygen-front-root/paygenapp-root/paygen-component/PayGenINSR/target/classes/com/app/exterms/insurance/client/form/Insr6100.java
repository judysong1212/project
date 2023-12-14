package com.app.exterms.insurance.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Element;

public class Insr6100 extends LayoutContainer { 
	
	 
	/**
	 *##########################################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *##########################################################################
	 **/
		    

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
	  private FormPanel plFrmInsr3100;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  private GridCellRenderer<Stock> gridNumber;   
	  private GridCellRenderer<Stock> change; 
	  
	  
		   /**
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       * 상태처리 전역변수
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       */
	      private ActionDatabase actionDatabase;
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

	      @Override
		  protected void onRender(Element parent, int index) {
		    super.onRender(parent, index);
		    
		    detailTp = XTemplate.create(getDetailTemplate());
		    
		   // formData = new FormData("-650");
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createInsr3100Form();  //화면 기본정보를 설정
		    createSearchForm();    //검색필드를 적용
		    createCheckBoxGrid();     
		    add(vp);
		    vp.setSize("1010px", "700px");
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
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		 
	      /**
		   * @wbp.parser.constructor
		   */
		  public Insr6100() {
			  
//			    final NumberFormat currency = NumberFormat.getCurrencyFormat();   
//			    final NumberFormat number = NumberFormat.getFormat("0.00");   
//			    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);   
//			  
//			    change = new GridCellRenderer<Stock>() {   
//			      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//			          ListStore<Stock> store, Grid<Stock> grid) {   
//			        double val = (Double) model.get(property);   
//			        String style = val < 0 ? "red" : "green";   
//			        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";   
//			      }   
//			    };   
//			  
//			    gridNumber = new GridCellRenderer<Stock>() {   
//			      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//			          ListStore<Stock> store, Grid<Stock> grid) {   
//			        return numberRenderer.render(null, property, model.get(property));   
//			      }   
//			    };   
			   
				setSize("1010px", "700px");  
		  } 
		
		  public Insr6100(String txtForm) {
				this.txtForm = txtForm;
		  }  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작
	 * 1. 폼 생성 선언
	 * 2. 공통 버튼 처리 선언
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/	  
		  private void createInsr3100Form() {
			  
				plFrmInsr3100 = new FormPanel();
				plFrmInsr3100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 사회보험통합출력"));
				plFrmInsr3100.setIcon(Resources.APP_ICONS.text());
				plFrmInsr3100.setBodyStyleName("pad-text");
				plFrmInsr3100.setFrame(true);
				
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
				 ************************************************************************/
				final Button btnlogView = new Button("로그");   
				
				btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
				btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						 //로그 뷰화면 호출 메서드 
						  funcLogMessage("사회보험통합출력","INSR6100");
						}
					});
				plFrmInsr3100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
				plFrmInsr3100.getHeader().addTool(btnlogView); 
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 
				 ************************************************************************/


				  ButtonBar buttonBar = new ButtonBar();    
				  buttonBar.setAlignment(HorizontalAlignment.RIGHT);
//			      buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//			        public void componentSelected(ButtonEvent ce) {   
//			         
//			        }   
//			      }));   
//			      buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//			        public void componentSelected(ButtonEvent ce) {   
//			           
//			        }   
//			      }));    
			  
//					Button topBtn = new Button("신규");  
//				  	topBtn.setIcon(Common.ICONS.accordion());
//				  	buttonBar.add(topBtn);
				  	 
//				  	topBtn = new Button("저장");  
//				  	topBtn.setIcon(Common.ICONS.accordion());
//				  	buttonBar.add(topBtn); 
//				   
//				  	topBtn = new Button("삭제");  
//				  	topBtn.setIcon(Common.ICONS.accordion());
//				  	buttonBar.add(topBtn);
				  	 
				    Button topBtn = new Button("조회"); 
				  	topBtn.setIcon(Resources.APP_ICONS.text());
				  	buttonBar.add(topBtn);
				  	
				  	topBtn = new Button("인쇄"); 
				  	topBtn.setIcon(Resources.APP_ICONS.text()); 
				  	buttonBar.add(topBtn);  
			  	
			  	plFrmInsr3100.add(buttonBar);    
			  	
				//파일업로드 처리
				plFrmInsr3100.setAction("bizform");
				plFrmInsr3100.setEncoding(Encoding.MULTIPART);
				plFrmInsr3100.setMethod(Method.POST);
				
			
				vp.add(plFrmInsr3100);
				plFrmInsr3100.setSize("990px", "680px");
			  }
			   
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
		  /**
		   * 검색필드 설정
		   */
		  private void createSearchForm() {   
			  
			  plFrmInsr3100.setLayout(new FlowLayout());
			    
			    LayoutContainer lcSchCol = new LayoutContainer();
			    lcSchCol.setLayout(new ColumnLayout()); 
			    
			    FieldSet fieldSet = new FieldSet();  
			    fieldSet.setHeadingHtml("검색조건");  
			   // fieldSet.setCheckboxToggle(false); 
			    
			    LayoutContainer lcSchLeft = new LayoutContainer();
			    lcSchLeft.setStyleAttribute("paddingRight", "10px");
			  
//			    TextField<String> company = new TextField<String>();  
//			    company.setFieldLabel("주민등록번호");  
//			    fieldSet.add(company, formData);  
//			  
//			    TextField<String> email = new TextField<String>();  
//			    email.setFieldLabel("Email");  
//			    fieldSet.add(email, formData); 
			    
			     
			    LayoutContainer layoutContainer = new LayoutContainer();
			    FormLayout frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer.setLayout(frmlytSch);
			    
			    ComboBox comboBox = new ComboBox();
			    comboBox.setStore(new ListStore());
			    layoutContainer.add(comboBox, new FormData("100%"));
			    comboBox.setFieldLabel("소속"); 
			    layoutContainer.setBorders(false);
			    
			    LayoutContainer layoutContainer_1 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_1.setLayout(frmlytSch);
			    
			    ComboBox comboBox_1 = new ComboBox();
			    comboBox_1.setStore(new ListStore());
			    layoutContainer_1.add(comboBox_1, new FormData("100%"));
			    comboBox_1.setFieldLabel("고용구분"); 
			    layoutContainer_1.setBorders(false); 
			 
			    fieldSet.add(lcSchCol, new FormData("100%"));  
			    lcSchLeft.setLayout(new ColumnLayout());
			    
			    LayoutContainer layoutContainer_8 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_8.setLayout(frmlytSch);
			    
			    ComboBox comboBox_4 = new ComboBox();
			    comboBox_4.setStore(new ListStore());
			    layoutContainer_8.add(comboBox_4, new FormData("100%"));
			    comboBox_4.setFieldLabel("지급기간");
			    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
			    layoutContainer_8.setBorders(false);
			    
			    LayoutContainer layoutContainer_9 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(0); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_9.setLayout(frmlytSch);
			    
			    ComboBox comboBox_5 = new ComboBox();
			    comboBox_5.setLabelSeparator("");
			    comboBox_5.setStore(new ListStore());
			    layoutContainer_9.add(comboBox_5, new FormData("100%"));
			    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			    layoutContainer_9.setBorders(false);
			    
			    LayoutContainer layoutContainer_11 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(10); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_11.setLayout(frmlytSch);
			    
			    ComboBox comboBox_7 = new ComboBox();
			    comboBox_7.setLabelSeparator("~");
			    comboBox_7.setStore(new ListStore());
			    layoutContainer_11.add(comboBox_7, new FormData("100%"));
			    lcSchLeft.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
			    layoutContainer_11.setBorders(true);
			    
			    LayoutContainer layoutContainer_12 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(0); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_12.setLayout(frmlytSch);
			    
			    ComboBox comboBox_8 = new ComboBox();
			    comboBox_8.setLabelSeparator("");
			    comboBox_8.setStore(new ListStore());
			    layoutContainer_12.add(comboBox_8, new FormData("100%"));
			    lcSchLeft.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			    layoutContainer_12.setBorders(true);
			    
			    LayoutContainer layoutContainer_10 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_10.setLayout(frmlytSch);
			    
			    ComboBox comboBox_6 = new ComboBox();
			    comboBox_6.setStore(new ListStore());
			    layoutContainer_10.add(comboBox_6, new FormData("100%"));
			    comboBox_6.setFieldLabel("직종");
			    lcSchCol.add(layoutContainer_10);
			    
			    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
			    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
			    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
			   
			    lcSchCol.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
			    
			    LayoutContainer layoutContainer_3 = new LayoutContainer();
			    layoutContainer_3.setLayout(new ColumnLayout());
			    
			    LayoutContainer layoutContainer_2 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_2.setLayout(frmlytSch);
			    
			    ComboBox comboBox_2 = new ComboBox();
			    comboBox_2.setStore(new ListStore());
			    layoutContainer_2.add(comboBox_2, new FormData("100%"));
			    comboBox_2.setFieldLabel("부서명");
			    layoutContainer_3.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
			    layoutContainer_2.setBorders(false);
			    
			    LayoutContainer layoutContainer_4 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_4.setLayout(frmlytSch);
			    
			    ComboBox comboBox_3 = new ComboBox();
			    comboBox_3.setStore(new ListStore());
			    layoutContainer_4.add(comboBox_3, new FormData("100%"));
			    comboBox_3.setFieldLabel("사업명");
			    layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
			    layoutContainer_4.setBorders(false);
			    
			    LayoutContainer layoutContainer_5 = new LayoutContainer();
			    layoutContainer_5.setLayout(new ColumnLayout());
			    
			    LayoutContainer layoutContainer_6 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(40); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_6.setLayout(frmlytSch);
			    
			    TextField textField = new TextField();
			    layoutContainer_6.add(textField, new FormData("100%"));
			    textField.setFieldLabel("성명");
			    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
			    layoutContainer_6.setBorders(false);
			    
			    Button button = new Button("검색");
			    layoutContainer_5.add(button);
			    
			    LayoutContainer layoutContainer_7 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_7.setLayout(frmlytSch);
			    
			    TextField textField_1 = new TextField();
			    layoutContainer_7.add(textField_1, new FormData("100%"));
			    textField_1.setFieldLabel("주민번호");
			    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			    layoutContainer_7.setBorders(false);
			    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
			    layoutContainer_5.setBorders(false);
			    fieldSet.add(layoutContainer_3);
			    layoutContainer_3.setBorders(false);
			     
			    
				
			    plFrmInsr3100.add(fieldSet); 
			//vp.add(panel);   
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
	   
		  private void createCheckBoxGrid() {   
			    List<Stock> stocks = null; // TestData.getStocks();   
			    
			    RowNumberer r = new RowNumberer();   

			    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
			    configs.add(r);   

			    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
			    // selection model supports the SIMPLE selection mode   
			    // sm.setSelectionMode(SelectionMode.SIMPLE);   
			  
			    configs.add(sm.getColumn());   
			  
			    ColumnConfig column = new ColumnConfig();   
			    column.setId("name");   
			    column.setHeaderText("코드");  
			    column.setAlignment(HorizontalAlignment.CENTER); 
			    column.setWidth(150);   
			    configs.add(column);   
			  
			    column = new ColumnConfig();   
			    column.setId("symbol");   
			    column.setHeaderText("코드명");  
			    column.setAlignment(HorizontalAlignment.CENTER); 
			    column.setWidth(200);   
			    configs.add(column);    
			  
			    ListStore<Stock> store = new ListStore<Stock>();   
			    store.add(stocks);   
			  
			    ColumnModel cm = new ColumnModel(configs);    
			    
			    ContentPanel cp = new ContentPanel();   
			    cp.setHeaderVisible(false);
			    cp.setFrame(true);   
			    cp.setIcon(Resources.APP_ICONS.table());   
			    cp.setLayout(new FitLayout());   
			    cp.setSize(600, 300);   
			  
			    Grid<Stock> grid = new Grid<Stock>(store, cm);   
			    grid.setSelectionModel(sm);   
			    grid.setBorders(true);   
			    grid.setColumnReordering(true);   
			    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
			    grid.addPlugin(sm);   
			      
			  
			    //FieldSet fieldSet = new FieldSet();  
			    //fieldSet.setHeadingHtml("사회보험");
			    
			    LayoutContainer lcStdGrid = new LayoutContainer();
			    lcStdGrid.setStyleAttribute("paddingRight", "10px");
			    
		        FieldSet fieldSet_2 = new FieldSet();
			    
			    LayoutContainer layoutContainer1 = new LayoutContainer();
			    
			    RadioGroup rdgrpNewRadiogroup1 = new RadioGroup();
			    rdgrpNewRadiogroup1.setBorders(false);
			    
			    Radio rdNewRadio1 = new Radio();
			    rdgrpNewRadiogroup1.add(rdNewRadio1);
			    rdNewRadio1.setBoxLabel("건강보험");
			    rdNewRadio1.setHideLabel(true);
			    
			    Radio rdNewRadio_2 = new Radio();
			    rdgrpNewRadiogroup1.add(rdNewRadio_2);
			    rdNewRadio_2.setBoxLabel("국민연금");
			    rdNewRadio_2.setHideLabel(true);
			    
			    Radio rdNewRadio_3 = new Radio();
			    rdgrpNewRadiogroup1.add(rdNewRadio_3);
			    rdNewRadio_3.setBoxLabel("고용보험");
			    rdNewRadio_3.setHideLabel(true);
			    
//			    Radio rdNewRadio_4 = new Radio();
//			    rdgrpNewRadiogroup1.add(rdNewRadio_4);
//			    rdNewRadio_4.setBoxLabel("산재보험");
//			    rdNewRadio_4.setHideLabel(true);
			    
			     
			    layoutContainer1.add(rdgrpNewRadiogroup1);
			    rdgrpNewRadiogroup1.setFieldLabel("사회보험");
			    fieldSet_2.add(layoutContainer1);
			    layoutContainer1.setLayout(new FlowLayout(5));
			    plFrmInsr3100.add(fieldSet_2);
			    fieldSet_2.setHeadingHtml("사회보험");
			    fieldSet_2.setCollapsible(false);
			    
			    FieldSet fieldSet_1 = new FieldSet();
			    
			    LayoutContainer layoutContainer = new LayoutContainer();
			    
			    RadioGroup rdgrpNewRadiogroup = new RadioGroup();
			    rdgrpNewRadiogroup.setBorders(false);
			    
			    Radio rdNewRadio = new Radio();
			    rdgrpNewRadiogroup.add(rdNewRadio);
			    rdNewRadio.setBoxLabel("부서별");
			    rdNewRadio.setHideLabel(true);
			    
			    Radio rdNewRadio_1 = new Radio();
			    rdgrpNewRadiogroup.add(rdNewRadio_1);
			    rdNewRadio_1.setBoxLabel("개인별");
			    rdNewRadio_1.setHideLabel(true);
			     
			    layoutContainer.add(rdgrpNewRadiogroup);
			    rdgrpNewRadiogroup.setFieldLabel("출력조건");
			    fieldSet_1.add(layoutContainer);
			    layoutContainer.setLayout(new FlowLayout(5));
			    plFrmInsr3100.add(fieldSet_1);
			    fieldSet_1.setHeadingHtml("출력조건");
			    fieldSet_1.setCollapsible(false);
			    FormLayout frmlytStd = new FormLayout();  
			  //  frmlytStd.setLabelWidth(85); 
			   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
			    lcStdGrid.setLayout(frmlytStd);  
			    
			    ContentPanel cpGrid = new ContentPanel();   
			    cpGrid.setBodyBorder(false); 
			    cpGrid.setHeaderVisible(false);   
			    cpGrid.setLayout(new FitLayout());      
			    cpGrid.setSize(935, 400);  
			    
			    cpGrid.add(grid);
			    grid.setHeight("395px");
			    lcStdGrid.add(cpGrid);   
			   // fieldSet.add(lcStdGrid);   
			      
			   // plFrmInsr3100.add(fieldSet);
			     
			  }      

	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 그리드 처리 함수 종료
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/ 	  
		 
		  
		 
	 
	  
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
