package com.app.exterms.insurance.client.form;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;

public class Insr2200 extends LayoutContainer { 
	
	
	 
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
	  private FormPanel plFrmPsnl0300;
	  private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  final TabPanel tabsPsnl = new TabPanel(); //인사탭정보설정을 위한 tab 
	  
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
		    
		    formData = new FormData("-650");
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createPsnl0100Form();  //화면 기본정보를 설정
		   // createSearchForm();    //검색필드를 적용
		   // createStandardForm();    //기본정보필드 
		   // createTabForm();       //탭구성
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
		   * @wbp.parser.constructor
		   */
		  public Insr2200() {
				setSize("1010px", "700px");  
		  } 
		
		  public Insr2200(String txtForm) {
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
		     
		  
		  private void createPsnl0100Form() {
			  
			plFrmPsnl0300 = new FormPanel();
			plFrmPsnl0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 가입자내역변경신고관리"));
			plFrmPsnl0300.setIcon(Resources.APP_ICONS.text());
			plFrmPsnl0300.setBodyStyleName("pad-text");
			plFrmPsnl0300.setPadding(2);
			plFrmPsnl0300.setFrame(true); 
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage("가입자내역변경신고관리","INSR2200");
					}
				});
			plFrmPsnl0300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPsnl0300.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

			
			//파일업로드 처리
			plFrmPsnl0300.setAction("myurl");
			plFrmPsnl0300.setEncoding(Encoding.MULTIPART);
			plFrmPsnl0300.setMethod(Method.POST);
			    
			vp.add(plFrmPsnl0300);
			plFrmPsnl0300.setSize("990px", "680px");
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
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/   
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/  

		  private void createStandardForm() {  
			    formData = new FormData("100%");  
//			   // FormPanel panel = new FormPanel();  
//			   // panel.setFrame(true); 
//			   // panel.setHeaderVisible(false);
//			   // panel.setIcon(Resources.ICONS.form());  
//			   // panel.setHeading("FormPanel");  
//			   // panel.setSize(600, -1);  
//			   // panel.setLabelAlign(LabelAlign.TOP);  
//			   // panel.setButtonAlign(HorizontalAlignment.CENTER);  
//			  
//			   // FormPanel form2 = new FormPanel();  
//			   // form2.setFrame(true);  
//			   // form2.setHeadingHtml("Simple Form with FieldSets");  
//			   // form2.setWidth(350);  
//			    plFrmPsnl0300.setLayout(new FlowLayout());
	    
			    LayoutContainer lcStdCol = new LayoutContainer();
			    lcStdCol.setLayout(new ColumnLayout()); 

			    FieldSet fieldSet = new FieldSet();  
			    fieldSet.setHeadingHtml("기본사항");
			    
			    LayoutContainer lcStdLeft = new LayoutContainer();
			    lcStdLeft.setStyleAttribute("paddingRight", "10px");
			    FormLayout frmlytStd = new FormLayout();  
			    frmlytStd.setLabelWidth(85); 
			    frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
			    lcStdLeft.setLayout(frmlytStd);
			        
			  
				Image image = new Image(); 
				image.getElement().getStyle().setProperty("marginTop", "10px");
				lcStdLeft.add(image,   new FormData("-775 -645"));
				image.setSize("120", "150");
				//plFrmPsnl0300.add(fieldSet, new FormData("100% -515"));
				
				
				 LayoutContainer lcStdCenter = new LayoutContainer();
				 lcStdCenter.setStyleAttribute("paddingRight", "10px");
				 frmlytStd = new FormLayout();  
				 frmlytStd.setLabelWidth(85); 
				 frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
				 lcStdCenter.setLayout(frmlytStd);
				    
			     
			    TextField<String> firstName = new TextField<String>();  
			    firstName.setFieldLabel("First Name");  
			    firstName.setAllowBlank(false);  
			    lcStdCenter.add(firstName, formData);  
			  
			    TextField<String> lastName = new TextField<String>();  
			    lastName.setFieldLabel("Last Name");  
			    lcStdCenter.add(lastName, formData);  
			  
			    TextField<String> company = new TextField<String>();  
			    company.setFieldLabel("Company");  
			    lcStdCenter.add(company, formData);  
			  
			    TextField<String> email = new TextField<String>();  
			    email.setFieldLabel("Email");  
			    lcStdCenter.add(email, formData);  
			  
			    lcStdCol.add(lcStdLeft,new ColumnData(.5)); 
			    lcStdCol.add(lcStdCenter,new ColumnData(.5)); 
			    fieldSet.add(lcStdCol, formData);  
			    
			    
			    //파일업로드 처리 
			    FileUploadField file = new FileUploadField();
			    file.addListener(Events.Change, new Listener<FieldEvent>() {
					public void handleEvent(FieldEvent e) {
						   if (!plFrmPsnl0300.isValid()) {
						          return;
						        }
						        // normally would submit the form but for example no server set up to
						        // handle the post
						        // panel.submit();
						        MessageBox.info("Action", "업로드 개발중 !", null);
					}
				});
			    file.setAllowBlank(false);
			    file.setName("uploadedfile");
			    file.setFieldLabel("사진");
			    file.setStyleAttribute("paddingRight", "5px");
			    fieldSet.add(file);
			    
			    plFrmPsnl0300.add(fieldSet); 
				//vp.add(panel);   
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


		  private void createTabForm() {  
		    formData = new FormData("100%");  
		    FormPanel panel = new FormPanel();  
		    panel.setBodyStyleName("example-bg");  
		    panel.setPadding(0);  
		    panel.setFrame(true);  
		    panel.setHeaderVisible(false);  
		    panel.setBodyBorder(false);   
		    panel.setButtonAlign(HorizontalAlignment.CENTER);  
		    panel.setLayout(new FitLayout());   
		           
		    //tabsPsnl.setMinTabWidth(80);   
		    tabsPsnl.setAutoWidth(false);
		   // tabsPsnl.setResizeTabs(true);   
		    tabsPsnl.setAnimScroll(true);   
		    tabsPsnl.setTabScroll(true); 
		    tabsPsnl.setPlain(true);   
		    tabsPsnl.setSize(980, 250);    
		    
		    TabItem item01 = new TabItem();  
		    item01.setStyleAttribute("padding", "10px");  
		    item01.setText(" 인  적 ");  
		    item01.addStyleName("pad-text");     
		    item01.setLayout(new FormLayout());  
		  
//		    TextField<String> name = new TextField<String>();  
//		    name.setFieldLabel("First Name");  
//		    name.setValue("Darrell");  
//		    item01.add(name, formData);  
//		  
//		    TextField<String> last = new TextField<String>();  
//		    last.setFieldLabel("Last Name");  
//		    last.setValue("Meyer");  
//		    personal.add(last, formData);  
//		  
//		    TextField<String> company = new TextField<String>();  
//		    company.setFieldLabel("Company");  
//		    personal.add(company, formData);  
//		  
//		    TextField<String> email = new TextField<String>();  
//		    email.setFieldLabel("Email");  
//		    personal.add(email, formData);  
		  
		    tabsPsnl.add(item01);  
		  
		    TabItem item02 = new TabItem();  
		    item02.setStyleAttribute("padding", "10px");  
		    item02.setText("병 역");  
		    item02.setLayout(new FormLayout());  
		  
//		    TextField<String> home = new TextField<String>();  
//		    home.setFieldLabel("Home");  
//		    home.setValue("800-555-1212");  
//		    numbers.add(home, formData);  
//		  
//		    TextField<String> business = new TextField<String>();  
//		    business.setFieldLabel("Business");  
//		    numbers.add(business, formData);  
//		  
//		    TextField<String> mobile = new TextField<String>();  
//		    mobile.setFieldLabel("Mobile");  
//		    numbers.add(mobile, formData);  
//		  
//		    TextField<String> fax = new TextField<String>();  
//		    fax.setFieldLabel("Fax");  
//		    numbers.add(fax, formData);  
		  
	      tabsPsnl.add(item02);  
	      
	      TabItem item03 = new TabItem();  
	      item03.setStyleAttribute("padding", "10px");  
	      item03.setText(" 신 상 ");  
	      item03.setLayout(new FormLayout());  
		  
//		    TextField<String> home = new TextField<String>();  
//		    home.setFieldLabel("Home");  
//		    home.setValue("800-555-1212");  
//		    numbers.add(home, formData);  
//		  
//		    TextField<String> business = new TextField<String>();  
//		    business.setFieldLabel("Business");  
//		    numbers.add(business, formData);  
//		  
//		    TextField<String> mobile = new TextField<String>();  
//		    mobile.setFieldLabel("Mobile");  
//		    numbers.add(mobile, formData);  
//		  
//		    TextField<String> fax = new TextField<String>();  
//		    fax.setFieldLabel("Fax");  
//		    numbers.add(fax, formData);  
		  
	      tabsPsnl.add(item03);  
	       
	      TabItem item05 = new TabItem();  
	      item05.setStyleAttribute("padding", "10px");  
	      item05.setText(" 가 족 ");  
	      item05.setLayout(new FormLayout());  
		  
//		    TextField<String> home = new TextField<String>();  
//		    home.setFieldLabel("Home");  
//		    home.setValue("800-555-1212");  
//		    numbers.add(home, formData);  
//		  
//		    TextField<String> business = new TextField<String>();  
//		    business.setFieldLabel("Business");  
//		    numbers.add(business, formData);  
//		  
//		    TextField<String> mobile = new TextField<String>();  
//		    mobile.setFieldLabel("Mobile");  
//		    numbers.add(mobile, formData);  
//		  
//		    TextField<String> fax = new TextField<String>();  
//		    fax.setFieldLabel("Fax");  
//		    numbers.add(fax, formData);  
		  
	      tabsPsnl.add(item05);  
	      
	      TabItem item06 = new TabItem();  
	      item06.setStyleAttribute("padding", "10px");  
	      item06.setText(" 학 력 ");  
	      item06.setLayout(new FormLayout());  
		  
//		    TextField<String> home = new TextField<String>();  
//		    home.setFieldLabel("Home");  
//		    home.setValue("800-555-1212");  
//		    numbers.add(home, formData);  
//		  
//		    TextField<String> business = new TextField<String>();  
//		    business.setFieldLabel("Business");  
//		    numbers.add(business, formData);  
//		  
//		    TextField<String> mobile = new TextField<String>();  
//		    mobile.setFieldLabel("Mobile");  
//		    numbers.add(mobile, formData);  
//		  
//		    TextField<String> fax = new TextField<String>();  
//		    fax.setFieldLabel("Fax");  
//		    numbers.add(fax, formData);  
		  
	      tabsPsnl.add(item06);  
	       
	      TabItem item09 = new TabItem();  
	      item09.setStyleAttribute("padding", "10px");  
	      item09.setText(" 경 력 ");  
	      item09.setLayout(new FormLayout());  
		  
//		    TextField<String> home = new TextField<String>();  
//		    home.setFieldLabel("Home");  
//		    home.setValue("800-555-1212");  
//		    numbers.add(home, formData);  
//		  
//		    TextField<String> business = new TextField<String>();  
//		    business.setFieldLabel("Business");  
//		    numbers.add(business, formData);  
//		  
//		    TextField<String> mobile = new TextField<String>();  
//		    mobile.setFieldLabel("Mobile");  
//		    numbers.add(mobile, formData);  
//		  
//		    TextField<String> fax = new TextField<String>();  
//		    fax.setFieldLabel("Fax");  
//		    numbers.add(fax, formData);  
		  
	      tabsPsnl.add(item09);  
	       
		    panel.add(tabsPsnl);  
		    panel.addButton(new Button("Cancel"));  
		    panel.addButton(new Button("Submit"));  
//		  
//		    panel.setSize(340, 200);  
//		  
//		    if (GXT.isFocusManagerEnabled()) {  
//		      name.getFocusSupport().setPreviousId(panel.getButtonBar().getId());  
//		      home.getFocusSupport().setPreviousId(panel.getButtonBar().getId());  
//		        
//		      panel.getButtonBar().getFocusSupport().addListener(FocusManager.TabNext, new Listener<BaseEvent>() {  
//		        public void handleEvent(BaseEvent be) {  
//		          tabsPsnl.getItem(tabsPsnl.getSelectedItem() == tabsPsnl.getItem(0) ? 0 : 1).getItem(0).focus();  
//		          be.setCancelled(true);  
//		        }  
//		      });  
//		      panel.getButtonBar().getFocusSupport().addListener(FocusManager.TabPrevious, new Listener<BaseEvent>() {  
//		        public void handleEvent(BaseEvent be) {  
//		          TabItem item = tabsPsnl.getItem(tabsPsnl.getSelectedItem() == tabsPsnl.getItem(0) ? 0 : 1);  
//		          item.getItem(item.getItemCount() - 1).focus();  
//		          be.setCancelled(true);  
//		        }  
//		      });  
//		    }  
		    plFrmPsnl0300.add(panel, formData); 
		   // vp.add(panel);  
		  }  
		  /**
		   * 검색필드 설정
		   */
		  private void createSearchForm() {  
		     formData = new FormData("100%");  
		   // FormPanel panel = new FormPanel();  
		   // panel.setFrame(true); 
		   // panel.setHeaderVisible(false);
		   // panel.setIcon(Resources.ICONS.form());  
		   // panel.setHeading("FormPanel");  
		   // panel.setSize(600, -1);  
		   // panel.setLabelAlign(LabelAlign.TOP);  
		   // panel.setButtonAlign(HorizontalAlignment.CENTER);  
		  
		   // FormPanel form2 = new FormPanel();  
		   // form2.setFrame(true);  
		   // form2.setHeadingHtml("Simple Form with FieldSets");  
		   // form2.setWidth(350);  
		    plFrmPsnl0300.setLayout(new FlowLayout());
		    
		    LayoutContainer lcSchCol = new LayoutContainer();
		    lcSchCol.setLayout(new ColumnLayout()); 
		    
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("검색조건");  
		   // fieldSet.setCheckboxToggle(false); 
		    
		    LayoutContainer lcSchLeft = new LayoutContainer();
		    lcSchLeft.setStyleAttribute("paddingRight", "200px");
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(85); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    frmlytSch.setDefaultWidth(100);
		   // fieldSet.setLayout(layout);  
		    lcSchLeft.setLayout(frmlytSch);
		    
		   
		    TextField<String> firstName = new TextField<String>();  
		    firstName.setFieldLabel("성 명");  
		    firstName.setAllowBlank(false);   
		    lcSchLeft.add(firstName, formData);  
		  
		    TextField<String> lastName = new TextField<String>();  
		    lastName.setFieldLabel("주민등록번호");  
		    lcSchLeft.add(lastName, formData);  
		  
//		    TextField<String> company = new TextField<String>();  
//		    company.setFieldLabel("주민등록번호");  
//		    fieldSet.add(company, formData);  
//		  
//		    TextField<String> email = new TextField<String>();  
//		    email.setFieldLabel("Email");  
//		    fieldSet.add(email, formData); 
		    
		    lcSchCol.add(lcSchLeft,new ColumnData(.5)); 
		    fieldSet.add(lcSchCol, formData);  
			
		    plFrmPsnl0300.add(fieldSet); 
			//vp.add(panel);   
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
