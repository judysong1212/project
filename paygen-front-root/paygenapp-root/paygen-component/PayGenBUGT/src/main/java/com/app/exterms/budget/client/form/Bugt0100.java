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
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bugt0100  extends MSFPanel  { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private VerticalPanel vp;
	  private FormPanel plFrmBugt0100;
	  //private FormData formData; 
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
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createBugt0100Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createStandardForm();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				 
				
		        detailTp = XTemplate.create(getDetailTemplate());
		    
			   // formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createBugt0100Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createStandardForm();    //기본정보필드  
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
	  public Bugt0100() {
		  
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
	
	  public Bugt0100(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createBugt0100Form() {
		  
		plFrmBugt0100 = new FormPanel();
		plFrmBugt0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 부서예산관리"));
		plFrmBugt0100.setIcon(Resources.APP_ICONS.text());
		plFrmBugt0100.setBodyStyleName("pad-text");
		plFrmBugt0100.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("부서예산관리","BUGT0100");
				}
			});
		plFrmBugt0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBugt0100.getHeader().addTool(btnlogView); 
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
	  
			Button topBtn = new Button("신규");  
		  	topBtn.setIcon(Resources.APP_ICONS.new16());
		  	buttonBar.add(topBtn);
		  	 
		  	topBtn = new Button("저장");  
		  	topBtn.setIcon(Resources.APP_ICONS.save16());
		  	buttonBar.add(topBtn); 
		   
		  	topBtn = new Button("삭제");  
		  	topBtn.setIcon(Resources.APP_ICONS.delete16());
		  	buttonBar.add(topBtn);
		  	 
		  	topBtn = new Button("조회"); 
		  	topBtn.setIcon(Resources.APP_ICONS.search16());
		  	buttonBar.add(topBtn);
		  	
		  	topBtn = new Button("인쇄"); 
		  	topBtn.setIcon(Resources.APP_ICONS.text()); 
		  	buttonBar.add(topBtn);  
	  	
	  	plFrmBugt0100.add(buttonBar);    
	  	
		//파일업로드 처리
		plFrmBugt0100.setAction("bizform");
		plFrmBugt0100.setEncoding(Encoding.MULTIPART);
		plFrmBugt0100.setMethod(Method.POST);
		
		 
	
		vp.add(plFrmBugt0100);
		plFrmBugt0100.setSize("990px", "680px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {   
		  
		  plFrmBugt0100.setLayout(new FlowLayout());
		    
		    LayoutContainer lcSchCol = new LayoutContainer();
		    lcSchCol.setLayout(new ColumnLayout()); 
		    
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("검색조건");  
		   // fieldSet.setCheckboxToggle(false); 
		    
		    LayoutContainer lcSchLeft = new LayoutContainer();
		   // lcSchLeft.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(85); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    lcSchLeft.setLayout(frmlytSch);
//		    TextField<String> company = new TextField<String>();  
//		    company.setFieldLabel("주민등록번호");  
//		    fieldSet.add(company, formData);  
//		  
//		    TextField<String> email = new TextField<String>();  
//		    email.setFieldLabel("Email");  
//		    fieldSet.add(email, formData); 
		    
		     
		    LayoutContainer layoutContainer = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(85); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer.setLayout(frmlytSch);
		    
		    ComboBox comboBox = new ComboBox();
		    comboBox.setStore(new ListStore());
		    layoutContainer.add(comboBox, new FormData("100%"));
		    comboBox.setFieldLabel("회계단위"); 
		    layoutContainer.setBorders(false);
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(85); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_1.setLayout(frmlytSch);
		    
		    ComboBox comboBox_1 = new ComboBox();
		    comboBox_1.setStore(new ListStore());
		    layoutContainer_1.add(comboBox_1, new FormData("100%"));
		    comboBox_1.setFieldLabel("부서명"); 
		    layoutContainer_1.setBorders(false);
		    fieldSet.add(lcSchCol, new FormData("100%"));
		    
		    ComboBox comboBox_4 = new ComboBox();
		    comboBox_4.setStore(new ListStore());
		    lcSchLeft.add(comboBox_4, new FormData("100%"));
		    comboBox_4.setFieldLabel("회계년도");
		    
		    
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
		    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		     
		    
			
		    plFrmBugt0100.add(fieldSet); 
		//vp.add(panel);   
	  }  
	  private void createStandardForm() {
		  
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_1 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_1.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset = new FieldSet();
			fldstNewFieldset.setSize("470px", "300px");
			
			
			layoutContainer_1.add(fldstNewFieldset);
			fldstNewFieldset.setHeadingHtml("부서정보");
			fldstNewFieldset.setCollapsible(false);
			layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			layoutContainer_1.setBorders(false);
			
			fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset_1 = new FieldSet();
			fldstNewFieldset_1.setSize(478, 300);
			layoutContainer_2.add(fldstNewFieldset_1);
			fldstNewFieldset_1.setHeadingHtml("부서예산등록");
			fldstNewFieldset_1.setCollapsible(false);
			
			fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
			
			 
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			layoutContainer_2.setBorders(false);
			
			plFrmBugt0100.add(layoutContainer);
			layoutContainer.setBorders(false); 

			LayoutContainer layoutContainer11 = new LayoutContainer();
			plFrmBugt0100.add(layoutContainer11);
			layoutContainer11.setBorders(false);
			
			FieldSet fldstNewFieldset_2 = new FieldSet();
			//fldstNewFieldset_2.setSize(958, 230);
			layoutContainer11.add(fldstNewFieldset_2,new FormData("100%"));
			fldstNewFieldset_2.setHeadingHtml("부서예산집행내역");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%")); 
			
			    
		  } 
	  
	     private LayoutContainer occupationalRTop() {
	    	 
	    	   LayoutContainer lcTabFormLayer = new LayoutContainer();
	    	 
	    	   ContentPanel cp01 = new ContentPanel();   
		  	   cp01.setBodyBorder(false); 
		  	   cp01.setHeaderVisible(false);   
		  	   cp01.setLayout(new FitLayout());      
		  	   cp01.setSize(456, 115);  
		  	   
		  	   LayoutContainer lytCtr01 = new LayoutContainer();
		  	   lytCtr01.setLayout(new FlowLayout());
		  	   
		  	   LayoutContainer layoutContainer = new LayoutContainer();
		  	   layoutContainer.setLayout(new ColumnLayout());
		  	   
		  	   LayoutContainer layoutContainer_1 = new LayoutContainer();
		  	   FormLayout frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(60); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_1.setLayout(frmlytStd);
		  	   
		  	   ComboBox comboBox = new ComboBox();
		  	   comboBox.setStore(new ListStore());
		  	   layoutContainer_1.add(comboBox, new FormData("100%"));
		  	   comboBox.setFieldLabel("회계년도");
		  	   layoutContainer.add(layoutContainer_1);
		  	   layoutContainer_1.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_2 = new LayoutContainer();
		  	   frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(60); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			   layoutContainer_2.setLayout(frmlytStd);
		  	   
		  	   ComboBox comboBox_1 = new ComboBox();
		  	   comboBox_1.setStore(new ListStore());
		  	   layoutContainer_2.add(comboBox_1, new FormData("100%"));
		  	   comboBox_1.setFieldLabel("회계단위");
		  	   layoutContainer.add(layoutContainer_2);
		  	   layoutContainer_2.setBorders(false);
		  	   
		  	   layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		  	   
		  	   layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  	 
		  	   lytCtr01.add(layoutContainer);
		  	   layoutContainer.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_5 = new LayoutContainer();
		  	   layoutContainer_5.setLayout(new ColumnLayout());
		  	   
		  	   LayoutContainer layoutContainer_6 = new LayoutContainer();
		  	    frmlytStd = new FormLayout();  
				frmlytStd.setLabelWidth(60); 
				frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_6.setLayout(frmlytStd);
		  	   
		  	   TextField textField_2 = new TextField();
		  	   layoutContainer_6.add(textField_2, new FormData("100%"));
		  	   textField_2.setFieldLabel("부서명");
		  	   layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		  	   layoutContainer_6.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_7 = new LayoutContainer();
		  	   frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(60); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_7.setLayout(frmlytStd);
		  	   
		  	   Button button = new Button("검색");
		  	   layoutContainer_7.add(button, new FormData("100%"));
		  	   layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		  	   layoutContainer_7.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_8 = new LayoutContainer();
		  	   frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(0); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_8.setLayout(frmlytStd);
		  	   
		  	   TextField textField_3 = new TextField();
		  	   layoutContainer_8.add(textField_3, new FormData("100%"));
		  	   textField_3.setFieldLabel("");
		  	   textField_3.setLabelSeparator("");
		  	   
		  	  
		  	   layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  	   layoutContainer_8.setBorders(false);
		  	   lytCtr01.add(layoutContainer_5);
		  	   layoutContainer_5.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_9 = new LayoutContainer();
		  	   layoutContainer_9.setLayout(new ColumnLayout());
		  	   
		  	   LayoutContainer layoutContainer_10 = new LayoutContainer();
		       frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(60); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_10.setLayout(frmlytStd);
		  	   
		  	   TextField textField_4 = new TextField();
		  	   layoutContainer_10.add(textField_4, new FormData("100%"));
		  	   textField_4.setFieldLabel("예산금액");
		  	   layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  	   layoutContainer_10.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_11 = new LayoutContainer();
		  	   frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(60); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_11.setLayout(frmlytStd);
		  	   
		  	   TextField textField_5 = new TextField();
		  	   textField_5.setReadOnly(true);
		  	   layoutContainer_11.add(textField_5, new FormData("100%"));
		  	   textField_5.setFieldLabel("집행금액");
		  	   layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  	   layoutContainer_11.setBorders(false);
		  	   lytCtr01.add(layoutContainer_9);
		  	   layoutContainer_9.setBorders(false);
		  	   
		  	   LayoutContainer layoutContainer_12 = new LayoutContainer();
		  	   layoutContainer_12.setLayout(new ColumnLayout());
		  	   
		  	   LayoutContainer layoutContainer_13 = new LayoutContainer();
		  	   frmlytStd = new FormLayout();  
			   frmlytStd.setLabelWidth(60); 
			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		  	   layoutContainer_13.setLayout(frmlytStd);
		  	   
		  	   TextField textField_6 = new TextField();
		  	   textField_6.setReadOnly(true);
		  	   layoutContainer_13.add(textField_6, new FormData("100%"));
		  	   textField_6.setFieldLabel("예산잔액");
		  	   layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		  	   layoutContainer_13.setBorders(false);
		  	   
//		  	   LayoutContainer layoutContainer_14 = new LayoutContainer();
//		  	   frmlytStd = new FormLayout();  
//			   frmlytStd.setLabelWidth(50); 
//			   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		  	   layoutContainer_14.setLayout(frmlytStd);
//		  	   
//		  	   TextField textField_7 = new TextField();
//		  	   layoutContainer_14.add(textField_7, new FormData("100%"));
//		  	   textField_7.setFieldLabel("종료일자");
//		  	   layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  	   lytCtr01.add(layoutContainer_12);
		  	   layoutContainer_12.setBorders(false);
		  	   cp01.add(lytCtr01);
		  	  
		  	     
//		  	   cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//			  	      @Override  
//			  	      public void componentSelected(ButtonEvent ce) {   
//			  	         
//			  	      }   
//			  	}));  
			  	   
//		 	    cp01.addButton(new Button("근태생성", new SelectionListener<ButtonEvent>() {   
//		 	      @Override  
//		 	      public void componentSelected(ButtonEvent ce) {   
//		 	         
//		 	      }   
//		 	    }));   
		 		 
		 	    
		 	   lcTabFormLayer.add(cp01); 
		 	      
			   return lcTabFormLayer;
	    	 
	     }
	  
		//호봉등급별 근속년수 결과 
		 private LayoutContainer occupationalRBottom() {
			   

	         LayoutContainer lcTabFormLayer = new LayoutContainer();


	         List<Stock> stocks = null; //TestData.getStocks();   
	  	    
	  	    RowNumberer r = new RowNumberer();   

	  	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
	  	    configs.add(r);   

	  	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
	  	    // selection model supports the SIMPLE selection mode   
	  	    // sm.setSelectionMode(SelectionMode.SIMPLE);   
	  	  
	  	    configs.add(sm.getColumn());   
	  	  
	  	    ColumnConfig column = new ColumnConfig();   
	  	    column.setId("name");   
	  	    column.setHeaderText("회계년도");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(60);   
	  	    configs.add(column);   
	  	  
	  	    column = new ColumnConfig();   
	  	    column.setId("last");   
	  	    column.setHeaderText("회계단위");   
	  	    column.setAlignment(HorizontalAlignment.CENTER);   
	  	    column.setWidth(70);   
	  	    column.setRenderer(gridNumber);   
	  	    configs.add(column);   
	  	  
	  	    //콤보로처리 결근/결근인정/무단결근
	  	    column = new ColumnConfig("change", "부서명", 150);   
	  	    column.setAlignment(HorizontalAlignment.CENTER);    
	  	    column.setRenderer(change);   
	  	    configs.add(column);   
	  	    
	  	    column = new ColumnConfig("change", "집행일자", 70);   
	  	    column.setAlignment(HorizontalAlignment.CENTER);    
	  	    column.setRenderer(change);   
	  	    configs.add(column);   
	  	    

	  	    column = new ColumnConfig();   
	  	    column.setId("symbol");   
	  	    column.setHeaderText("집행금액");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(100);   
	  	    configs.add(column);   
	  	    
	  	    column = new ColumnConfig();   
	  	    column.setId("symbol");   
	  	    column.setHeaderText("관련근거");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(200);   
	  	    configs.add(column);  
	  	     
	  	  
	  	    ListStore<Stock> store = new ListStore<Stock>();   
	  	    store.add(stocks);   
	  	  
	  	    ColumnModel cm = new ColumnModel(configs);    
	  	    
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(935, 180);  
	  	  
	  	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
	  	    grid.setSelectionModel(sm);   
	  	    grid.setBorders(true);   
	  	    grid.setColumnReordering(true);   
	  	   // grid.getAriaSupport().setLabelledBy(cp01.getHeader().getId() + "-label");   
	  	    grid.addPlugin(sm);    
	 		
	  	    cp01.add(grid);
	 		 
	 	    
	 	    lcTabFormLayer.add(cp01); 
	 	      
			    return lcTabFormLayer;
		 } 
	  
	   private LayoutContainer occupationalLeft() {
		   
		   LayoutContainer lcTabFormLayer = new LayoutContainer();

	        List<Stock> stocks = null; //TestData.getStocks();   
	 	    
	 	    RowNumberer r = new RowNumberer();   

	 	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
	 	    configs.add(r);   

	 	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
	 	    // selection model supports the SIMPLE selection mode   
	 	    // sm.setSelectionMode(SelectionMode.SIMPLE);   
	 	  
	 	    configs.add(sm.getColumn());   
	 	  
	 	    ColumnConfig column = new ColumnConfig();   
	 	    column.setId("name");   
	 	    column.setHeaderText("회계년도");  
	 	    column.setAlignment(HorizontalAlignment.CENTER); 
	 	    column.setWidth(70);   
	 	    configs.add(column);   
	 	  
	 	    column = new ColumnConfig();   
	 	    column.setId("last");   
	 	    column.setHeaderText("회계단위");   
	 	    column.setAlignment(HorizontalAlignment.CENTER);   
	 	    column.setWidth(90);   
	 	    column.setRenderer(gridNumber);   
	 	    configs.add(column);   
	 	    
	 	    column = new ColumnConfig();   
	 	    column.setId("last");   
	 	    column.setHeaderText("부서명");   
	 	    column.setAlignment(HorizontalAlignment.CENTER);   
	 	    column.setWidth(150);   
	 	    column.setRenderer(gridNumber);   
	 	    configs.add(column); 
	 	    
	 	   column = new ColumnConfig();   
	 	    column.setId("last");   
	 	    column.setHeaderText("예산금액");   
	 	    column.setAlignment(HorizontalAlignment.CENTER);   
	 	    column.setWidth(100);   
	 	    column.setRenderer(gridNumber);   
	 	    configs.add(column);   
	 	    
	 	     
	 	  
	 	    ListStore<Stock> store = new ListStore<Stock>();   
	 	    store.add(stocks);   
	 	  
	 	    ColumnModel cm = new ColumnModel(configs);    
	 	    
	 	   ContentPanel cp01 = new ContentPanel();   
	 	   cp01.setBodyBorder(false); 
	 	   cp01.setHeaderVisible(false);   
	 	   cp01.setLayout(new FitLayout());      
	 	   cp01.setSize(450, 260);  
	 	  
	 	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
	 	    grid.setSelectionModel(sm);   
	 	    grid.setBorders(true);   
	 	    grid.setColumnReordering(true);   
	 	   // grid.getAriaSupport().setLabelledBy(cp01.getHeader().getId() + "-label");   
	 	    grid.addPlugin(sm);  
			
	 	    cp01.add(grid);
	 	   // grid.setWidth("480px"); 
		    
		    lcTabFormLayer.add(cp01); 
		     
			return lcTabFormLayer;  
		   
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
