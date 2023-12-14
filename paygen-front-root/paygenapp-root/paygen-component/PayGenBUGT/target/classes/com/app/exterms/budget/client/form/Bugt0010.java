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
public class Bugt0010  extends MSFPanel  { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	  private VerticalPanel vp;
	  private FormPanel plFrmBugt0010;
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
//	    createPsnl0100Form();  //화면 기본정보를 설정
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
			    createPsnl0100Form();  //화면 기본정보를 설정
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
	  public Bugt0010() {
		  
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
	
	  public Bugt0010(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createPsnl0100Form() {
		  
		plFrmBugt0010 = new FormPanel();
		plFrmBugt0010.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 회계단위관리"));
		plFrmBugt0010.setIcon(Resources.APP_ICONS.text());
		plFrmBugt0010.setBodyStyleName("pad-text");
		plFrmBugt0010.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("회계단위관리","BUGT0010");
				}
			});
		plFrmBugt0010.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBugt0010.getHeader().addTool(btnlogView); 
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
	  	
	  	plFrmBugt0010.add(buttonBar);    
	  	
		//파일업로드 처리
		plFrmBugt0010.setAction("myurl");
		plFrmBugt0010.setEncoding(Encoding.MULTIPART);
		plFrmBugt0010.setMethod(Method.POST);
		
	
		vp.add(plFrmBugt0010);
		plFrmBugt0010.setSize("990px", "680px");
	  }
	   
 
	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {   
		  
	    plFrmBugt0010.setLayout(new FlowLayout());
	    
	    LayoutContainer lcSchCol = new LayoutContainer();
	    lcSchCol.setLayout(new ColumnLayout()); 
	    
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("검색조건");  
	   // fieldSet.setCheckboxToggle(false); 
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();
	    lcSchLeft.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(85); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	   // frmlytSch.setDefaultWidth(100);
	   // fieldSet.setLayout(layout);  
	    lcSchLeft.setLayout(frmlytSch);
	    
	    ComboBox cmbxNewCombobox = new ComboBox();
	    cmbxNewCombobox.setStore(new ListStore());
	    lcSchLeft.add(cmbxNewCombobox, new FormData("100%"));
	    cmbxNewCombobox.setFieldLabel("회계년도");
	  
//	    TextField<String> company = new TextField<String>();  
//	    company.setFieldLabel("주민등록번호");  
//	    fieldSet.add(company, formData);  
//	  
//	    TextField<String> email = new TextField<String>();  
//	    email.setFieldLabel("Email");  
//	    fieldSet.add(email, formData); 
	    
	     
	    LayoutContainer layoutContainer = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(85); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer.setLayout(frmlytSch);
	    layoutContainer.setBorders(false);
	    
	    TextField textField = new TextField();
	    layoutContainer.add(textField, new FormData("100%"));
	    textField.setFieldLabel("회계단위명");
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(85); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1.setLayout(frmlytSch);
	    layoutContainer_1.setBorders(false);
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
	    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	     
	    
		
	    plFrmBugt0010.add(fieldSet); 
		//vp.add(panel);   
	  }  
	  private void createStandardForm() {   
		  
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new FormLayout());
			 
			FieldSet fldstNewFieldset_2 = new FieldSet();
			fldstNewFieldset_2.setSize(572, 500);
			layoutContainer.add(fldstNewFieldset_2, new FormData("0"));
			fldstNewFieldset_2.setHeadingHtml("회계단위정보");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));  
			  
			plFrmBugt0010.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   
	  
		//회계단정보 
		 private LayoutContainer occupationalRBottom() {
			   

	         LayoutContainer lcTabFormLayer = new LayoutContainer();


	         List<Stock> stocks =  null;//TestData.getStocks();   
	  	    
	  	    RowNumberer r = new RowNumberer();   

	  	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
	  	    configs.add(r);   

	  	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
	  	    // selection model supports the SIMPLE selection mode   
	  	    // sm.setSelectionMode(SelectionMode.SIMPLE);   
	  	  
	  	    configs.add(sm.getColumn());   
	  	  
	  	    ColumnConfig column = new ColumnConfig();   
	  	    column.setId("name");   
	  	    column.setHeaderText("년도");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(70);   
	  	    configs.add(column);   
	  	  
	  	    column = new ColumnConfig();   
	  	    column.setId("last");   
	  	    column.setHeaderText("회계코드");   
	  	    column.setAlignment(HorizontalAlignment.CENTER);   
	  	    column.setWidth(100);   
	  	    column.setRenderer(gridNumber);   
	  	    configs.add(column);   
	  	  
	  	    column = new ColumnConfig("change", "회계단위명", 150);   
	  	    column.setAlignment(HorizontalAlignment.CENTER);    
	  	    column.setRenderer(change);   
	  	    configs.add(column);   
	  	    

	  	    column = new ColumnConfig();   
	  	    column.setId("symbol");   
	  	    column.setHeaderText("상위회계단위명");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(150);   
	  	    configs.add(column);   
	  	    
	  	    column = new ColumnConfig();   
	  	    column.setId("symbol");   
	  	    column.setHeaderText("회계단위시작일자");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(100);   
	  	    configs.add(column);  
	  	    
	  	    column = new ColumnConfig();   
	  	    column.setId("symbol");   
	  	    column.setHeaderText("회계단위종료일자");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(100);   
	  	    configs.add(column);  
	  	    
	  	    column = new ColumnConfig();   
	  	    column.setId("symbol");   
	  	    column.setHeaderText("비고내용");  
	  	    column.setAlignment(HorizontalAlignment.CENTER); 
	  	    column.setWidth(250);   
	  	    configs.add(column);  
	  	     
	  	  
	  	    ListStore<Stock> store = new ListStore<Stock>();   
	  	    store.add(stocks);   
	  	  
	  	    ColumnModel cm = new ColumnModel(configs);    
	  	    
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(935, 460);  
	  	  
	  	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
	  	    grid.setSelectionModel(sm);   
	  	    grid.setBorders(true);   
	  	    grid.setColumnReordering(true);   
	  	   // grid.getAriaSupport().setLabelledBy(cp01.getHeader().getId() + "-label");   
	  	    grid.addPlugin(sm);    
	 		
	  	    cp01.add(grid);
	 		 
//	  		cp01.addButton(new Button("확정", new SelectionListener<ButtonEvent>() {   
//			      @Override  
//			      public void componentSelected(ButtonEvent ce) {   
//			         
//			      }   
//			}));  
//			   
//		   cp01.addButton(new Button("확정풀기", new SelectionListener<ButtonEvent>() {   
//		     @Override  
//		     public void componentSelected(ButtonEvent ce) {   
//		        
//		     }   
//		   }));  
		    
		   
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
