package com.app.exterms.budget.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bugt0300  extends MSFPanel  { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/ 

	 private VerticalPanel vp;
	  private FormPanel plFrmBugt0300;
	 // private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  private GridCellRenderer<Stock> gridNumber;   
	  private GridCellRenderer<Stock> change;
	   
	  
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	    //formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createBugt0300Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createListGrid();    //그리드 정보  
//	    
//	    ButtonBar buttonBar_1 = new ButtonBar();
//	    
//	    Button button_1 = new Button("엑셀다운");
//	    buttonBar_1.add(button_1);
//	  	plFrmBugt0300.add(buttonBar_1, new FormData("100%"));
//	  	
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				 
				
			    detailTp = XTemplate.create(getDetailTemplate());
			    
			    //formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createBugt0300Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createListGrid();    //그리드 정보  
			    
			    ButtonBar buttonBar_1 = new ButtonBar();
			    
			    Button button_1 = new Button("엑셀다운");
			    buttonBar_1.add(button_1);
			  	plFrmBugt0300.add(buttonBar_1, new FormData("100%"));
			  	
			    add(vp);
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
	  
	  private void createStdSubFrom() {
	  }
		
	  	
	  	
	  /**
	   * @wbp.parser.constructor
	   */
	  public Bugt0300() {
		  
//		    final NumberFormat currency = NumberFormat.getCurrencyFormat();   
//		    final NumberFormat number = NumberFormat.getFormat("0.00");   
//		    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);   
//		  
//		    change = new GridCellRenderer<Stock>() {   
//		      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//		          ListStore<Stock> store, Grid<Stock> grid) {   
//		        double val = (Double) model.get(property);   
//		        String style = val < 0 ? "red" : "green";   
//		        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";   
//		      }   
//		    };   
//		  
//		    gridNumber = new GridCellRenderer<Stock>() {   
//		      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//		          ListStore<Stock> store, Grid<Stock> grid) {   
//		        return numberRenderer.render(null, property, model.get(property));   
//		      }   
//		    };   
		    
			setSize("1010px", "700px");  
	  } 
	
	  public Bugt0300(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createBugt0300Form() {
		  
		plFrmBugt0300 = new FormPanel();
		plFrmBugt0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 예산집행통계현황"));
		plFrmBugt0300.setIcon(Resources.APP_ICONS.text());
		plFrmBugt0300.setBodyStyleName("pad-text");
		plFrmBugt0300.setFrame(true);  
		plFrmBugt0300.setLayout(new FormLayout());
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("예산집행통계현황","BUGT0300");
				}
			});
		plFrmBugt0300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBugt0300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		  ButtonBar buttonBar = new ButtonBar();    
		  buttonBar.setAlignment(HorizontalAlignment.RIGHT);
//	      buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	        public void componentSelected(ButtonEvent ce) {   
//	         
//	        }   
//	      }));   
//	      buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	        public void componentSelected(ButtonEvent ce) {   
//	           
//	        }   
//	      }));    
	  
//	  	Button topBtn = new Button("신규");  
//	  	topBtn.setIcon(Resources.APP_ICONS.accordion());
//	  	buttonBar.add(topBtn);
//	  	 
//	  	topBtn = new Button("저장");  
//	  	topBtn.setIcon(Resources.APP_ICONS.accordion());
//	  	buttonBar.add(topBtn); 
//	   
//	  	topBtn = new Button("삭제");  
//	  	topBtn.setIcon(Resources.APP_ICONS.accordion());
//	  	buttonBar.add(topBtn);
	  	 
		Button topBtn = new Button("조회"); 
	  	topBtn.setIcon(Resources.APP_ICONS.search16());
	  	buttonBar.add(topBtn);
	  	
	  	topBtn = new Button("인쇄"); 
	  	topBtn.setIcon(Resources.APP_ICONS.print16()); 
	  	buttonBar.add(topBtn);  
	  	
	  	plFrmBugt0300.add(buttonBar);  
	  	
		//파일업로드 처리 - 사업장 직인 정보 
	  	plFrmBugt0300.setAction("myurl");  //url 정보 추가 할것.
	  	plFrmBugt0300.setEncoding(Encoding.MULTIPART);
	  	plFrmBugt0300.setMethod(Method.POST);
	  	
	  	 
	  	
		vp.add(plFrmBugt0300);
		plFrmBugt0300.setSize("990px", "680px");
	  }
	    
	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {
	    
	    LayoutContainer lcSchCol = new LayoutContainer();
	    lcSchCol.setLayout(new ColumnLayout()); 
	    
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("검색조건");   
	    
	    
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	    layoutContainer_2.setStyleAttribute("paddingRight", "10px"); 
	    layoutContainer_2.setBorders(false);
	    
	    LayoutContainer layoutContainer_3 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_3.setLayout(frmlytSch);
	    
	    ComboBox comboBox_1 = new ComboBox();
	    comboBox_1.setStore(new ListStore());
	    layoutContainer_3.add(comboBox_1, new FormData("100%"));
	    comboBox_1.setFieldLabel("회계단위");
	    
	    layoutContainer_3.setBorders(false);
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();
	    lcSchLeft.setStyleAttribute("paddingRight", "10px");
	    
	    LayoutContainer lcSchRight = new LayoutContainer();
	    lcSchRight.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(60); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
	    lcSchRight.setLayout(frmlytSchRight);
	    
	    ComboBox comboBox = new ComboBox();
	    comboBox.setStore(new ListStore());
	    lcSchRight.add(comboBox, new FormData("100%"));
	    comboBox.setFieldLabel("사업명");
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer = new LayoutContainer();
	    frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(60); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer.setLayout(frmlytSchRight);
	    
	    TextField txtfldNewTextfield_2 = new TextField();
	    layoutContainer.add(txtfldNewTextfield_2, new FormData("100%"));
	    txtfldNewTextfield_2.setFieldLabel("부서명");
	    lcSchLeft.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	    layoutContainer.setBorders(false);
	    
	    Button btnNewButton_1 = new Button("검색");
	    lcSchLeft.add(btnNewButton_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(0); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_1.setLayout(frmlytSchRight);
	    
	    TextField textField = new TextField();
	    textField.setLabelSeparator("");
	    layoutContainer_1.add(textField, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_1.setBorders(false);
	    frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(60); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_2.setLayout(frmlytSchRight);
	    
	    TextField txtfldNewTextfield_4 = new TextField();
	    layoutContainer_2.add(txtfldNewTextfield_4, new FormData("100%"));
	    txtfldNewTextfield_4.setFieldLabel("회계년도");
	  
//	    TextField<String> lastName = new TextField<String>();  
//	    lastName.setFieldLabel("사업장명");  
//	    lcSchRight.add(lastName, new FormData("100%"));  
	    
	    lcSchCol.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15)); 
	    lcSchCol.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 
	    lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 
	    
	  
	    
	    fieldSet.add(lcSchCol);  
		
	    plFrmBugt0300.add(fieldSet);  
	    
	  }  
	   

	  private void createListGrid() {   
	    List<Stock> stocks = null; //TestData.getStocks();   
	    
	    RowNumberer r = new RowNumberer();   

	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
	    configs.add(r);   

	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();    
	  
	    configs.add(sm.getColumn());   
	  
	    ColumnConfig column = new ColumnConfig();   
	    column.setId("name");   
	    column.setHeaderText("회계년도");  
	    column.setAlignment(HorizontalAlignment.CENTER); 
	    column.setWidth(80);   
	    configs.add(column);   
	    
	    column = new ColumnConfig();   
	    column.setId("name");   
	    column.setHeaderText("회계단위");  
	    column.setAlignment(HorizontalAlignment.CENTER); 
	    column.setWidth(100);   
	    configs.add(column);   
	  
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("부서명");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(150);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	   

	    column = new ColumnConfig();   
	    column.setId("symbol");   
	    column.setHeaderText("사업명");  
	    column.setAlignment(HorizontalAlignment.CENTER); 
	    column.setWidth(150);   
	    configs.add(column);   
	    
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("예산금액");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(150);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	    
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("집행금액");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(150);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	    
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("잔액");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(150);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	     
	  
	    ListStore<Stock> store = new ListStore<Stock>();   
	    store.add(stocks);   
	  
	    ColumnModel cm = new ColumnModel(configs);    
	    
	    ContentPanel cp = new ContentPanel();   
	    cp.setHeaderVisible(false);
	    cp.setFrame(true);   
	    cp.setIcon(Resources.APP_ICONS.table());   
	    cp.setLayout(new FitLayout());   
	  //  cp.setSize(600, 180);   
	  
	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
	    grid.setSelectionModel(sm);   
	    grid.setBorders(true);   
	    grid.setColumnReordering(true);   
	    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
	    grid.addPlugin(sm);   
	      
	  
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("예산집행내역");
	    fieldSet.setSize(958, 480);
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    lcStdGrid.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytStd = new FormLayout();  
	   // frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(935, 445);  
	    
	    cpGrid.add(grid);
	   // grid.setHeight("147px");
	    lcStdGrid.add(cpGrid);   
	    fieldSet.add(lcStdGrid);   
	      
	    plFrmBugt0300.add(fieldSet);
	     
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
