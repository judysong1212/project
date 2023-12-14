package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0600DTO;
import com.app.exterms.basis.client.service.Bass0600Service;
import com.app.exterms.basis.client.service.Bass0600ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
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
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bass0600  extends MSFPanel  { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private VerticalPanel vp;
	  private FormPanel plFrmBass0600;
	//  private FormData formData; 
	  private String txtForm = "";  
	  private GridCellRenderer<Stock> gridNumber;   
	  private GridCellRenderer<Stock> change;
	  
	  final TabPanel tabsPsnl = new TabPanel(); //인사탭정보설정을 위한 tab 
	  
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	     
//	  //  formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPsnl0100Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createCheckBoxGrid();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  private Bass0600ServiceAsync bass0600Service = Bass0600Service.Util.getInstance();
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPsnl0600Form();  		//화면 기본정보를 설정
			    createSearchForm();    		//검색필드를 적용
			    createCheckBoxGrid();    	//기본정보필드  
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
	  public Bass0600() {
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
	
	  public Bass0600(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createPsnl0600Form() {
		  
		plFrmBass0600 = new FormPanel();
		plFrmBass0600.setHeadingText(PayGenConst.PAYGEN_VERSION.concat("  - 이관이력관리"));
		plFrmBass0600.setIcon(Resources.APP_ICONS.text());
		plFrmBass0600.setBodyStyleName("pad-text");
		plFrmBass0600.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("이관이력관리","BASS0600");
				}
			});
		plFrmBass0600.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0600.getHeader().addTool(btnlogView); 
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
	  
	  	Button topBtn = new Button("암호화실행"); 
	  	topBtn.setIcon(Resources.APP_ICONS.search16());
	  	buttonBar.add(topBtn);
	  	
		topBtn.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
                batchCryptData();
            }  
          });   
		Button topBtn2 = new Button("인쇄", psnl0600ButtonListener); 
		topBtn2.setIcon(Resources.APP_ICONS.text()); 
	  	buttonBar.add(topBtn2);  
	  	
	  	plFrmBass0600.add(buttonBar);    	
	  	
		vp.add(plFrmBass0600);
		plFrmBass0600.setSize("990px", "690px");
	  }
	   

	  private void createCheckBoxGrid() {   
	    List<Stock> stocks =  null;   
	    
	    RowNumberer r = new RowNumberer();   

	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
	    configs.add(r);   

	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
	    // selection model supports the SIMPLE selection mode   
	    // sm.setSelectionMode(SelectionMode.SIMPLE);   
	  
	    configs.add(sm.getColumn());   
	  
	    ColumnConfig column = new ColumnConfig();   
	    column.setId("name");   
	    column.setHeaderText("작업구분");  
	    column.setAlignment(HorizontalAlignment.CENTER); 
	    column.setWidth(100);   
	    configs.add(column);   
	  
	    column = new ColumnConfig();   
	    column.setId("symbol");   
	    column.setHeaderText("이관작업번호");  
	    column.setAlignment(HorizontalAlignment.CENTER); 
	    column.setWidth(100);   
	    configs.add(column);   
	    
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("이관작업일자");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(100);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	  
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("이관작업시작일시");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(100);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	    
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("이관작업종료일시");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(100);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	    
	    
	    column = new ColumnConfig();   
	    column.setId("last");   
	    column.setHeaderText("이관내용");   
	    column.setAlignment(HorizontalAlignment.CENTER);   
	    column.setWidth(250);   
	    column.setRenderer(gridNumber);   
	    configs.add(column);   
	  
	    column = new ColumnConfig("change", "정상", 80);   
	    column.setAlignment(HorizontalAlignment.CENTER);    
	    column.setRenderer(change);   
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
	      
	  
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("이관이력정보");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    lcStdGrid.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytStd = new FormLayout();  
	  //  frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(935, 540);  
	    
	    cpGrid.add(grid);
	    grid.setHeight("395px");
	    lcStdGrid.add(cpGrid);   
	    fieldSet.add(lcStdGrid);   
	      
	    plFrmBass0600.add(fieldSet);
	     
	  }   

	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {  
	    
	   // FormPanel panel = new FormPanel();  
	   // panel.setFrame(true); 
	   // panel.setHeaderVisible(false);
	   // panel.setIcon(Resources.APP_ICONS.form());  
	   // panel.setHeadingText("FormPanel");  
	   // panel.setSize(600, -1);  
	   // panel.setLabelAlign(LabelAlign.TOP);  
	   // panel.setButtonAlign(HorizontalAlignment.CENTER);  
	  
	   // FormPanel form2 = new FormPanel();  
	   // form2.setFrame(true);  
	   // form2.setHeadingHtml("Simple Form with FieldSets");  
	   // form2.setWidth(350);  
	    plFrmBass0600.setLayout(new FlowLayout());
	    
	    LayoutContainer lcSchCol = new LayoutContainer();
	    lcSchCol.setLayout(new ColumnLayout()); 
	    
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("검색조건");  
	   // fieldSet.setCheckboxToggle(false); 
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
	    
	    DateField dtfldNewDatefield = new DateField();
	    dtfldNewDatefield.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    lcSchLeft.add(dtfldNewDatefield, new FormData("100%"));
	    dtfldNewDatefield.setFieldLabel("이관기간");
	     
	    
	    LayoutContainer lcSchRight = new LayoutContainer();
	    lcSchRight.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(100); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
	    lcSchRight.setLayout(frmlytSchRight);
	    
	    LayoutContainer layoutContainer = new LayoutContainer();
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(10); 
	    frmlytSchRight.setLabelAlign(LabelAlign.LEFT);  
	    layoutContainer_1.setLayout(frmlytSchRight);
	    
	    DateField dtfldNewDatefield_1 = new DateField();
	    dtfldNewDatefield_1.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    layoutContainer_1.add(dtfldNewDatefield_1, new FormData("50%"));
	    dtfldNewDatefield_1.setFieldLabel("~");
	    dtfldNewDatefield_1.setLabelSeparator("");
	    layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_1.setBorders(false);
	    
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	    layoutContainer_2.setLayout(new FormLayout());
	    layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_2.setBorders(false);
	    lcSchRight.add(layoutContainer, new FormData("100%"));
	    layoutContainer.setLayout(new ColumnLayout());
	    layoutContainer.setBorders(false);
	    
	    LayoutContainer layoutContaine1 = new LayoutContainer();
	    //layoutContainer.setHeight(28);
	    layoutContaine1.setLayout(new FlowLayout());
	    
	    LayoutContainer layoutContainer_12 = new LayoutContainer();
	    layoutContainer_12.setLayout(new HBoxLayout());
	    
	    LayoutContainer layoutContainer_21 = new LayoutContainer();
	    layoutContainer_21.setLayout(new FormLayout());
	    
	    TextField txtfldNewTextfield_4 = new TextField();
	    layoutContainer_21.add(txtfldNewTextfield_4, new FormData("100%"));
	    txtfldNewTextfield_4.setFieldLabel("조건");
	    layoutContainer_12.add(layoutContainer_21);
	    layoutContainer_21.setBorders(false);
	    
	    Button btnNewButton_1 = new Button("New Button");
	    layoutContainer_12.add(btnNewButton_1);
	    layoutContaine1.add(layoutContainer_12);
	    layoutContainer_12.setBorders(false);
	    layoutContainer_2.add(layoutContaine1, new FormData("100%"));
	    layoutContaine1.setBorders(false);
	  
//	    TextField<String> company = new TextField<String>();  
//	    company.setFieldLabel("주민등록번호");  
//	    fieldSet.add(company,  new FormData("100%"));  
//	  
//	    TextField<String> email = new TextField<String>();  
//	    email.setFieldLabel("Email");  
//	    fieldSet.add(email,  new FormData("100%")); 
	    
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
	    lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75)); 
	    
	    fieldSet.add(lcSchCol, new FormData("100%"));   
		
	    plFrmBass0600.add(fieldSet); 
		//vp.add(panel);   
	  }  
	  
	  private void batchCryptData() {
		  
		  Bass0600DTO bass0600Dto= new Bass0600DTO();
		  
		  bass0600Service.insertBass0600(bass0600Dto,  new AsyncCallback<String>(){
                 public void onFailure(Throwable caught) {
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("bass0600Service : " + caught), null);
                 }
                 public void onSuccess(String result) { 
                   
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "처리가 완료되었습니다.", null);
                      
                   
                 } 
                  
             }); 
	  }
	  
	  
		private SelectionListener<ButtonEvent> psnl0600ButtonListener = new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				//TODO 환경미화원은 데이터 안나와서 출력물은 기존의 것으로 사용. 
				//인사기본출력에서는 권한 추가해서 환경미화원이 안나옴. 그래서 출력물 따로 만들어서 사용함
				RexPrint("BASST0600");
			}
		};	
		
		
		//rex
		private void RexPrint(final String fileName) {
			
			// 출력물 디렉토리 패스경로 통계 : STTS
			String strDirPath = new String();
			strDirPath = "BASS";
			
			// rex 출력물
			String rexFileName = new String();
			rexFileName = fileName+".crf";
			
			// 보낼 파라미터
			String strParam = new String();
			
			String searchParam = new String();
		       
		       
			searchParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) +"⊥";	// $1 사업장 코드
			searchParam += "" + ""+ "⊥";											
			
			strParam = "" + searchParam ;
					
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
			
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
