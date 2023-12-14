package com.app.exterms.retirement.client.form;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Element;

public class RemtP0400 extends LayoutContainer { 
	
	  private VerticalPanel vp;
	  private FormPanel plFrmRemt0100; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  
	  @Override
	  protected void onRender(Element parent, int index) {
	    super.onRender(parent, index);
	    
	    detailTp = XTemplate.create(getDetailTemplate()); 
	    
	    vp = new VerticalPanel();
	    vp.setSpacing(10);
	    createPsnl0100Form();  //화면 기본정보를 설정 
	    createStandardForm();    //기본정보필드  
	    add(vp);
	    vp.setSize("600px", "480px");
	  }
	  
	  /**
	   * @wbp.parser.constructor
	   */
	  public RemtP0400() {
		   
			setSize("600px", "480px");  
	  } 
	
	  public RemtP0400(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createPsnl0100Form() {
		  
		plFrmRemt0100 = new FormPanel();
		plFrmRemt0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 퇴직금중간정산-2014년이전자료등록"));
		plFrmRemt0100.setIcon(MSFMainApp.ICONS.text());
		plFrmRemt0100.setBodyStyleName("pad-text");
		plFrmRemt0100.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("퇴직금중간정산-2014년이전자료등록","REMTP0400");
				}
			});
		plFrmRemt0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmRemt0100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
	  	
		//파일업로드 처리
		plFrmRemt0100.setAction("myurl");
		plFrmRemt0100.setEncoding(Encoding.MULTIPART);
		plFrmRemt0100.setMethod(Method.POST);
		 
		    
		vp.add(plFrmRemt0100);
		plFrmRemt0100.setSize("580px", "460px");
	  }
	   
	 
	  /**
	   * 기본사항 
	   */
	  private void createStandardForm() {
		   

		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("기본사항");
		    
		    LayoutContainer layoutContainer = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		    layoutContainer.setLayout(frmlytSch);
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    layoutContainer_1.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		    layoutContainer_2.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield = new TextField();
		   // lblfldNewLabelfield.setStyleAttribute("backgroundcolor","white");
		    lblfldNewLabelfield.setFieldLabel("정산년월"); 
		    layoutContainer_2.add(lblfldNewLabelfield, new FormData("100%"));
		    layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_2.setBorders(false);
		    
		    LayoutContainer layoutContainer_3 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_3.setLayout(frmlytSch);
		    
		    TextField labelField = new TextField();
		    labelField.setFieldLabel("정산구분");
		    layoutContainer_3.add(labelField, new FormData("100%"));
		    layoutContainer_1.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_1.add(layoutContainer_3);
		    layoutContainer_3.setBorders(false);
		    
		    LayoutContainer layoutContainer_25 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_25.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_2 = new TextField();
		    layoutContainer_25.add(lblfldNewLabelfield_2);
		    lblfldNewLabelfield_2.setFieldLabel("부 서");
		    layoutContainer_1.add(layoutContainer_25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_25.setBorders(false);
		    
		    LayoutContainer layoutContainer_26 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_26.setLayout(frmlytSch);
		    
		    
		    TextField lblfldNewLabelfield_3 = new TextField();
		    layoutContainer_26.add(lblfldNewLabelfield_3);
		    lblfldNewLabelfield_3.setFieldLabel("직 종");
		    layoutContainer_1.add(layoutContainer_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_26.setBorders(false);
		    layoutContainer.add(layoutContainer_1, new FormData("100%"));
		    layoutContainer_1.setBorders(false);
		    
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    layoutContainer_4.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_5 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_5.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_4 = new TextField();
		    layoutContainer_5.add(lblfldNewLabelfield_4, new FormData("100%"));
		    lblfldNewLabelfield_4.setFieldLabel("주민번호");
		    layoutContainer_4.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_5.setBorders(false);
		    
		    LayoutContainer layoutContainer_6 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_6.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_5 = new TextField();
		    layoutContainer_6.add(lblfldNewLabelfield_5, new FormData("100%"));
		    lblfldNewLabelfield_5.setFieldLabel("성 명");
		    layoutContainer_4.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_6.setBorders(false);
		    layoutContainer.add(layoutContainer_4, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
		    
		    LayoutContainer layoutContainer_7 = new LayoutContainer();
		    layoutContainer_7.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_8.setLayout(frmlytSch);
		    layoutContainer_7.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_8.setBorders(false);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_9.setLayout(frmlytSch);
		    layoutContainer_7.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_9.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_10.setLayout(frmlytSch);
		    layoutContainer_7.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		    layoutContainer_10.setBorders(false);
		    layoutContainer.add(layoutContainer_7, new FormData("100%"));
		    layoutContainer_7.setBorders(false);
		    
		    LayoutContainer layoutContainer_11 = new LayoutContainer();
		    layoutContainer_11.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_12 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_12.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_6 = new TextField();
		    lblfldNewLabelfield_6.setFieldLabel("입사일자");
		    layoutContainer_12.add(lblfldNewLabelfield_6);
		    layoutContainer_11.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_12.setBorders(false);
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_13.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_7 = new TextField();
		    lblfldNewLabelfield_7.setFieldLabel("재고용일자");
		    layoutContainer_13.add(lblfldNewLabelfield_7, new FormData("100%"));
		    layoutContainer_11.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_13.setBorders(false);
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_14.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_8 = new TextField();
		    lblfldNewLabelfield_8.setFieldLabel("종료일자");
		    layoutContainer_14.add(lblfldNewLabelfield_8, new FormData("100%"));
		    layoutContainer_11.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_14.setBorders(false);
		    
		    LayoutContainer layoutContainer_15 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_15.setLayout(frmlytSch);
		    
		    DateField dtfldNewDatefield = new DateField();
		    layoutContainer_15.add(dtfldNewDatefield, new FormData("100%"));
		    dtfldNewDatefield.setFieldLabel("퇴직일자");
		    layoutContainer_11.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_15.setBorders(false);
		    layoutContainer.add(layoutContainer_11, new FormData("100%"));
		    layoutContainer_11.setBorders(false);
		    
		    LayoutContainer layoutContainer_16 = new LayoutContainer();
		    layoutContainer_16.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_18 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_18.setLayout(frmlytSch);
		    layoutContainer_16.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_18.setBorders(false);
		    
		    LayoutContainer layoutContainer_17 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_17.setLayout(frmlytSch);
		    
		    TextField lblfldNewLabelfield_9 = new TextField();
		    lblfldNewLabelfield_9.setFieldLabel("근속년수:"); 
		    layoutContainer_17.add(lblfldNewLabelfield_9, new FormData("100%"));
		    layoutContainer_16.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_17.setBorders(false);
		    
		    LayoutContainer layoutContainer_19 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_19.setLayout(frmlytSch);
		    
		    CheckBox chckbxNewCheckbox = new CheckBox();
		    layoutContainer_19.add(chckbxNewCheckbox, new FormData("100%"));
		    chckbxNewCheckbox.setBoxLabel("압류공제");
		    chckbxNewCheckbox.setHideLabel(true);
		    layoutContainer_16.add(layoutContainer_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_19.setBorders(false);
		    
		    LayoutContainer layoutContainer_20 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_20.setLayout(frmlytSch);
		    
		    CheckBox chckbxNewCheckbox_1 = new CheckBox();
		    layoutContainer_20.add(chckbxNewCheckbox_1, new FormData("100%"));
		    chckbxNewCheckbox_1.setBoxLabel("임 원");
		    chckbxNewCheckbox_1.setHideLabel(true);
		    layoutContainer_16.add(layoutContainer_20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_20.setBorders(false);
		    layoutContainer.add(layoutContainer_16, new FormData("100%"));
		    layoutContainer_16.setBorders(false);
		    
		    LayoutContainer layoutContainer_21 = new LayoutContainer();
		    layoutContainer_21.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_22 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_22.setLayout(frmlytSch);
		    
		    ComboBox cmbxNewCombobox_6 = new ComboBox();
		    cmbxNewCombobox_6.setStore(new ListStore());
		    layoutContainer_22.add(cmbxNewCombobox_6);
		    cmbxNewCombobox_6.setFieldLabel("은행명");
		    layoutContainer_21.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_22.setBorders(false);
		    
		    LayoutContainer layoutContainer_23 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_23.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_4 = new TextField();
		    layoutContainer_23.add(txtfldNewTextfield_4, new FormData("100%"));
		    txtfldNewTextfield_4.setFieldLabel("계좌번호");
		    layoutContainer_21.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_23.setBorders(false);
		    
		    LayoutContainer layoutContainer_24 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_24.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_5 = new TextField();
		    layoutContainer_24.add(txtfldNewTextfield_5, new FormData("100%"));
		    txtfldNewTextfield_5.setFieldLabel("예금주");
		    layoutContainer_21.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		    layoutContainer_24.setBorders(false);
		    layoutContainer.add(layoutContainer_21, new FormData("100%"));
		    layoutContainer_21.setBorders(false);
		    fieldSet.add(layoutContainer);
		    layoutContainer.setBorders(false);
		    
		    plFrmRemt0100.add(fieldSet);
			
			//vp.add(panel);   
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
