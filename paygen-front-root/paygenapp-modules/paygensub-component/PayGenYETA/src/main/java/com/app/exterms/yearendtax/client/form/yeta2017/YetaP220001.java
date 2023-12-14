/**
 * 월별급여내역
 */
package com.app.exterms.yearendtax.client.form.yeta2017;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.PdfA102yBM;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfB101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG106yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG206yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG306yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfP102yDTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfA102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfB101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfC101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfC202yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfC301yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfC401yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfD101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfE102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfF102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfG106yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfG206yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfG306yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfJ101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfJ203yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfJ301yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfJ401yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfK101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfL102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfN101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfO101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.PdfP102yDef;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP220001Service;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP220001ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP220001   extends MSFFormPanel {  

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	전역변수 선언부  시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/

	private  ContentPanel cpYeta21001; 

	private PdfA102yDef pdfA102yDef = new PdfA102yDef("");
	private PdfB101yDef pdfB101yDef = new PdfB101yDef("");
	private PdfC101yDef pdfC101yDef = new PdfC101yDef("");
	private PdfC202yDef pdfC202yDef = new PdfC202yDef("");	
	private PdfC301yDef pdfC301yDef = new PdfC301yDef("");

	private PdfC401yDef pdfC401yDef = new PdfC401yDef("");
	private PdfD101yDef pdfD101yDef = new PdfD101yDef("");
	private PdfE102yDef pdfE102yDef = new PdfE102yDef("");
	private PdfF102yDef pdfF102yDef = new PdfF102yDef("");	
	//	private PdfG104yDef pdfG104yDef = new PdfG104yDef("");	
	private PdfG106yDef pdfG106yDef = new PdfG106yDef("");	

	//	private PdfG205yDef pdfG205yDef = new PdfG205yDef("");
	private PdfG206yDef pdfG206yDef = new PdfG206yDef("");
	//	private PdfG304yDef pdfG304yDef = new PdfG304yDef("");
	private PdfG306yDef pdfG306yDef = new PdfG306yDef("");
	private PdfJ101yDef pdfJ101yDef = new PdfJ101yDef("");
	private PdfJ203yDef pdfJ203yDef = new PdfJ203yDef("");
	private PdfJ301yDef pdfJ301yDef = new PdfJ301yDef("");

	private PdfJ401yDef pdfJ401yDef = new PdfJ401yDef("");	
	private PdfK101yDef pdfK101yDef = new PdfK101yDef("");	
	private PdfL102yDef pdfL102yDef = new PdfL102yDef("");
	private PdfN101yDef pdfN101yDef = new PdfN101yDef("");
	private PdfO101yDef pdfO101yDef = new PdfO101yDef("");

	//	private PdfP101yDef pdfP101yDef = new PdfP101yDef("");
	private PdfP102yDef pdfP102yDef = new PdfP102yDef("");

	private MSFGridPanel yetaPdfA102yGridPanel;
	private MSFGridPanel yetaPdfB101yGridPanel;
	private MSFGridPanel yetaPdfC101yGridPanel;
	private MSFGridPanel yetaPdfC202yGridPanel;
	private MSFGridPanel yetaPdfC301yGridPanel;

	private MSFGridPanel yetaPdfC401yGridPanel;	
	private MSFGridPanel yetaPdfD101yGridPanel;
	private MSFGridPanel yetaPdfE102yGridPanel;
	private MSFGridPanel yetaPdfF102yGridPanel;
	//	private MSFGridPanel yetaPdfG104yGridPanel;
	private MSFGridPanel yetaPdfG106yGridPanel;

	//	private MSFGridPanel yetaPdfG205yGridPanel;
	private MSFGridPanel yetaPdfG206yGridPanel;	
	//	private MSFGridPanel yetaPdfG304yGridPanel;
	private MSFGridPanel yetaPdfG306yGridPanel;
	private MSFGridPanel yetaPdfJ101yGridPanel;
	private MSFGridPanel yetaPdfJ203yGridPanel;
	private MSFGridPanel yetaPdfJ301yGridPanel;

	private MSFGridPanel yetaPdfJ401yGridPanel;	
	private MSFGridPanel yetaPdfK101yGridPanel;
	private MSFGridPanel yetaPdfL102yGridPanel;
	private MSFGridPanel yetaPdfN101yGridPanel;
	private MSFGridPanel yetaPdfO101yGridPanel;

	//	private MSFGridPanel yetaPdfP101yGridPanel;
	private MSFGridPanel yetaPdfP102yGridPanel;

	private Button btnSelected;
	private Button btnAllUsed;
	private Button btnUnUsed;
	// -------------- 권한 설정 객체 종료 --------------

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
	private MSFPanel caller;
	public FormBinding formBinding;
	private TabPanel tabYetaP220001;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	private HiddenField<String> systemkey;
	private HiddenField<String> dpobCd;
	private HiddenField<String> yrtxBlggYr;  /** set 연말정산귀속년도 : edacRvyy */
	private HiddenField<String> clutSeptCd;/** set 정산구분코드 : settGbcd */
	
	private MSFTextField typOccuNm; 			// 기본정보_직종
	private MSFTextField fnm; 				// 기본정보_성명
	private MSFTextField deptNm; 				// 기본정보_부서

	private boolean mutilCombo = false;

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

	//화면 폼 바인딩 처리 
	private void setPayr410001FormBinding() {

		// formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
		// formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));

	}        

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

	private YetaP220001ServiceAsync yetaP220001Service = YetaP220001Service.Util.getInstance();

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	Rpc Service 선언부 종료
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/

	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/ 		    
	public YetaP220001(final ActionDatabase actionDatabase, final MSFPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
		// 콤보 권한초기화

		cpYeta21001 = new ContentPanel();

		createBasicForm(); 	// 검색필드를 적용
		createStandardForm(); 	// 기본정보필드

		cpYeta21001.setBodyBorder(false);
		cpYeta21001.setBorders(false);
		cpYeta21001.setHeaderVisible(false);
		cpYeta21001.setSize("890px", "660px");

		this.add(cpYeta21001);
		formBinding = new FormBinding(this, true);

		this.setSize("910px", "710px");
	}

	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/


	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * 검색필드 설정
	 */
	private void createBasicForm() {
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());

		/** column text : 기본정보_성명 cretypOccuNm */
		LayoutContainer layoutContainer11 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11.setLayout(frmlytSch);

		fnm = new MSFTextField();
		fnm.setName("fnm");
		fnm.setFieldLabel("성명");
		fnm.setEmptyText("--성명--");
		fnm.setReadOnly(true);
		layoutContainer11.add(fnm, new FormData("100%"));
		layoutContainer11.setBorders(false);
		lcSchCol2.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		/** column text : 기본정보_부서 creDeptCd */
		LayoutContainer layoutContainer12 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12.setLayout(frmlytSch);

		deptNm = new MSFTextField();
		deptNm.setName("deptNm");
		deptNm.setFieldLabel("부서");
		deptNm.setEmptyText("--부서--");
		deptNm.setReadOnly(true);
		layoutContainer12.add(deptNm, new FormData("100%"));
		layoutContainer12.setBorders(false);
		lcSchCol2.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		/** column text : 기본정보_직종 cretypOccuNm */
		LayoutContainer layoutContainer10 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10.setLayout(frmlytSch);

		typOccuNm = new MSFTextField();
		typOccuNm.setName("typOccuNm");
		typOccuNm.setFieldLabel("직종");
		typOccuNm.setEmptyText("--직종--");
		typOccuNm.setReadOnly(true);
		layoutContainer10.add(typOccuNm, new FormData("100%"));
		layoutContainer10.setBorders(false);
		lcSchCol2.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		fieldSet.add(lcSchCol2, new FormData("100%"));
		
		cpYeta21001.add(fieldSet, new FormData("100%"));
	}


	private void createStandardForm() {
		systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta21001.add(systemkey);

		dpobCd = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		dpobCd.setName("dpobCd");
		cpYeta21001.add(dpobCd);

		yrtxBlggYr = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYeta21001.add(yrtxBlggYr);

		clutSeptCd = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		clutSeptCd.setName("clutSeptCd");
		cpYeta21001.add(clutSeptCd);
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");

		tabYetaP220001 = new TabPanel(); // 인사탭정보설정을 위한 tab
		tabYetaP220001.setStyleAttribute("paddingTop", "3px");
		tabYetaP220001.setStyleAttribute("paddingLeft", "2px");
		// tabsBass0350.setMinTabWidth(80);
		tabYetaP220001.setAutoWidth(false);
		// tabsBass0350.setResizeTabs(true);
		tabYetaP220001.setAnimScroll(true);
		tabYetaP220001.setTabScroll(true);
		tabYetaP220001.setPlain(true);
		tabYetaP220001.setSize(885, 595);

		TabItem item_PDF_A102Y = new TabItem();
		item_PDF_A102Y.setId("item_PDF_A102Y");
		item_PDF_A102Y.setText("보장성보험");
		item_PDF_A102Y.setLayout(new FormLayout());
		item_PDF_A102Y.add(Yeta_PDF_A102Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_A102Y);

		TabItem item_PDF_B101Y = new TabItem();
		item_PDF_B101Y.setId("item_PDF_B101Y");
		item_PDF_B101Y.setText("의료비");
		item_PDF_B101Y.setLayout(new FormLayout());
		item_PDF_B101Y.add(Yeta_PDF_B101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_B101Y);

		TabItem item_PDF_C101Y = new TabItem();
		item_PDF_C101Y.setId("item_PDF_C101Y");
		item_PDF_C101Y.setText("교육비");
		item_PDF_C101Y.setLayout(new FormLayout());
		item_PDF_C101Y.add(Yeta_PDF_C101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_C101Y);

		TabItem item_PDF_C202Y = new TabItem();
		item_PDF_C202Y.setId("item_PDF_C202Y");
		item_PDF_C202Y.setText("직업훈련비");
		item_PDF_C202Y.setLayout(new FormLayout());
		item_PDF_C202Y.add(Yeta_PDF_C202Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_C202Y);

		TabItem item_PDF_C301Y = new TabItem();
		item_PDF_C301Y.setId("item_PDF_C301Y");
		item_PDF_C301Y.setText("교복구입비");
		item_PDF_C301Y.setLayout(new FormLayout());
		item_PDF_C301Y.add(Yeta_PDF_C301Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_C301Y);

		TabItem item_PDF_C401Y = new TabItem();
		item_PDF_C401Y.setId("item_PDF_C401Y");
		item_PDF_C401Y.setText("학자금상환");
		item_PDF_C401Y.setLayout(new FormLayout());
		item_PDF_C401Y.add(Yeta_PDF_C401Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_C401Y);

		TabItem item_PDF_D101Y = new TabItem();
		item_PDF_D101Y.setId("item_PDF_D101Y");
		item_PDF_D101Y.setText("개인연금저축");
		item_PDF_D101Y.setLayout(new FormLayout());
		item_PDF_D101Y.add(Yeta_PDF_D101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_D101Y);

		TabItem item_PDF_E102Y = new TabItem();
		item_PDF_E102Y.setId("item_PDF_E102Y");
		item_PDF_E102Y.setText("연금저축");
		item_PDF_E102Y.setLayout(new FormLayout());
		item_PDF_E102Y.add(Yeta_PDF_E102Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_E102Y);

		TabItem item_PDF_F102Y = new TabItem();
		item_PDF_F102Y.setId("item_PDF_F102Y");
		item_PDF_F102Y.setText("퇴직연금");
		item_PDF_F102Y.setLayout(new FormLayout());
		item_PDF_F102Y.add(Yeta_PDF_F102Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_F102Y);

		TabItem item_PDF_G106Y = new TabItem();
		item_PDF_G106Y.setId("item_PDF_G106Y");
		item_PDF_G106Y.setText("신용카드");
		item_PDF_G106Y.setLayout(new FormLayout());
		item_PDF_G106Y.add(Yeta_PDF_G106Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_G106Y);

		TabItem item_PDF_G206Y = new TabItem();
		item_PDF_G206Y.setId("item_PDF_G206Y");
		item_PDF_G206Y.setText("현금영수증");
		item_PDF_G206Y.setLayout(new FormLayout());
		item_PDF_G206Y.add(Yeta_PDF_G206Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_G206Y);

		TabItem item_PDF_G306Y = new TabItem();
		item_PDF_G306Y.setId("item_PDF_G306Y");
		item_PDF_G306Y.setText("직불카드등");
		item_PDF_G306Y.setLayout(new FormLayout());
		item_PDF_G306Y.add(Yeta_PDF_G306Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_G306Y);

		TabItem item_PDF_J101Y = new TabItem();
		item_PDF_J101Y.setId("item_PDF_J101Y");
		item_PDF_J101Y.setText("주택임차차입금원리금상환액");
		item_PDF_J101Y.setLayout(new FormLayout());
		item_PDF_J101Y.add(Yeta_PDF_J101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_J101Y);

		TabItem item_PDF_J203Y = new TabItem();
		item_PDF_J203Y.setId("item_PDF_J203Y");
		item_PDF_J203Y.setText("장기주택저당차입금이자상환액");
		item_PDF_J203Y.setLayout(new FormLayout());
		item_PDF_J203Y.add(Yeta_PDF_J203Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_J203Y);

		TabItem item_PDF_J301Y = new TabItem();
		item_PDF_J301Y.setId("item_PDF_J301Y");
		item_PDF_J301Y.setText("주택마련저축");
		item_PDF_J301Y.setLayout(new FormLayout());
		item_PDF_J301Y.add(Yeta_PDF_J301Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_J301Y);

		TabItem item_PDF_J401Y = new TabItem();
		item_PDF_J401Y.setId("item_PDF_J401Y");
		item_PDF_J401Y.setText("목돈안드는전세이자상환액");
		item_PDF_J401Y.setLayout(new FormLayout());
		item_PDF_J401Y.add(Yeta_PDF_J401Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_J401Y);

		TabItem item_PDF_K101Y = new TabItem();
		item_PDF_K101Y.setId("item_PDF_K101Y");
		item_PDF_K101Y.setText("소기업소상공인공제부금");
		item_PDF_K101Y.setLayout(new FormLayout());
		item_PDF_K101Y.add(Yeta_PDF_K101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_K101Y);

		TabItem item_PDF_L102Y = new TabItem();
		item_PDF_L102Y.setId("item_PDF_L102Y");
		item_PDF_L102Y.setText("기부금");
		item_PDF_L102Y.setLayout(new FormLayout());
		item_PDF_L102Y.add(Yeta_PDF_L102Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_L102Y);

		TabItem item_PDF_N101Y = new TabItem();
		item_PDF_N101Y.setId("item_PDF_N101Y");
		item_PDF_N101Y.setText("장기집합투자증권저축");
		item_PDF_N101Y.setLayout(new FormLayout());
		item_PDF_N101Y.add(Yeta_PDF_N101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_N101Y);

		TabItem item_PDF_O101Y = new TabItem();
		item_PDF_O101Y.setId("item_PDF_O101M");
		item_PDF_O101Y.setText("건강보험료");
		item_PDF_O101Y.setLayout(new FormLayout());
		item_PDF_O101Y.add(Yeta_PDF_O101Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_O101Y);

		TabItem item_PDF_P102Y = new TabItem();
		item_PDF_P102Y.setId("item_PDF_P101Y");
		item_PDF_P102Y.setText("국민연금보험료");
		item_PDF_P102Y.setLayout(new FormLayout());
		item_PDF_P102Y.add(Yeta_PDF_P102Y_Grid(), new FormData("100%"));
		tabYetaP220001.add(item_PDF_P102Y);

		fieldSet.add(tabYetaP220001);

		cpYeta21001.add(fieldSet, new FormData("100%"));


	}

	private LayoutContainer Yeta_PDF_A102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfA102yGridPanel = new MSFGridPanel(pdfA102yDef, false, false, false, false, false);
		yetaPdfA102yGridPanel.setHeaderVisible(false);
		yetaPdfA102yGridPanel.setBodyBorder(false);
		yetaPdfA102yGridPanel.setBorders(true);
		yetaPdfA102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfA102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfA102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfA102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  
				
				int iCnt = 0;

				PdfA102yDTO pdfA102yDto = new PdfA102yDTO();
				List<PdfA102yDTO> listPdfA102yDto = new ArrayList<PdfA102yDTO>();

				Iterator<BaseModel> itBm = yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 
				
				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						iCnt = iCnt + 1;
						
						pdfA102yDto = new PdfA102yDTO();
						
						pdfA102yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfA102yDto.setAccNo(MSFSharedUtils.allowNulls(bmMapModel.get("accNo")));
						pdfA102yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfA102yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfA102yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfA102yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfA102yDto.add(pdfA102yDto);

					}
				}

				if(listPdfA102yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}


				yetaP220001Service.updateYetaP220001ToPdfA102Y(listPdfA102yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfA102yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfA102yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfA102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_B101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfB101yGridPanel = new MSFGridPanel(pdfB101yDef, false, false, false, false, false);
		yetaPdfB101yGridPanel.setHeaderVisible(false);
		yetaPdfB101yGridPanel.setBodyBorder(false);
		yetaPdfB101yGridPanel.setBorders(true);
		yetaPdfB101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfB101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfB101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfB101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfB101yDTO pdfB101yDto = new PdfB101yDTO();
				List<PdfB101yDTO> listPdfB101yDto = new ArrayList<PdfB101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfB101yDto = new PdfB101yDTO();

						pdfB101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfB101yDto.setManSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("manSeilNum")))); 
						pdfB101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfB101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfB101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfB101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfB101yDto.add(pdfB101yDto);
					}
				}


				if(listPdfB101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfB101Y(listPdfB101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfB101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfB101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfB101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_C101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfC101yGridPanel = new MSFGridPanel(pdfC101yDef, false, false, false, false, false);
		yetaPdfC101yGridPanel.setHeaderVisible(false);
		yetaPdfC101yGridPanel.setBodyBorder(false);
		yetaPdfC101yGridPanel.setBorders(true);
		yetaPdfC101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfC101yDTO pdfC101yDto = new PdfC101yDTO();
				List<PdfC101yDTO> listPdfC101yDto = new ArrayList<PdfC101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfC101yDto = new PdfC101yDTO();

						pdfC101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfC101yDto.setEdiSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("ediSeilNum"))));
						pdfC101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfC101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfC101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfC101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfC101yDto.add(pdfC101yDto);
					}
				}


				if(listPdfC101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfC101Y(listPdfC101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfC101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfC101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfC101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_C202Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfC202yGridPanel = new MSFGridPanel(pdfC202yDef, false, false, false, false, false);
		yetaPdfC202yGridPanel.setHeaderVisible(false);
		yetaPdfC202yGridPanel.setBodyBorder(false);
		yetaPdfC202yGridPanel.setBorders(true);
		yetaPdfC202yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC202yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC202yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC202yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfC202yDTO pdfC202yDto = new PdfC202yDTO();
				List<PdfC202yDTO> listPdfC202yDto = new ArrayList<PdfC202yDTO>();

				Iterator<BaseModel> itBm = yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfC202yDto = new PdfC202yDTO();

						pdfC202yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfC202yDto.setJbEdiSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("jbEdiSeilNum"))));
						pdfC202yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfC202yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfC202yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfC202yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfC202yDto.add(pdfC202yDto);
					}
				}


				if(listPdfC202yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfC202Y(listPdfC202yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfC202yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfC202yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfC202yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_C301Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfC301yGridPanel = new MSFGridPanel(pdfC301yDef, false, false, false, false, false);
		yetaPdfC301yGridPanel.setHeaderVisible(false);
		yetaPdfC301yGridPanel.setBodyBorder(false);
		yetaPdfC301yGridPanel.setBorders(true);
		yetaPdfC301yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC301yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfC301yDTO pdfC301yDto = new PdfC301yDTO();
				List<PdfC301yDTO> listPdfC301yDto = new ArrayList<PdfC301yDTO>();

				Iterator<BaseModel> itBm = yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfC301yDto = new PdfC301yDTO();

						pdfC301yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfC301yDto.setSchUniSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("schUniSeilNum"))));
						pdfC301yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfC301yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfC301yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfC301yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfC301yDto.add(pdfC301yDto);
					}
				}


				if(listPdfC301yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfC301Y(listPdfC301yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfC301yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfC301yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfC301yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_C401Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfC401yGridPanel = new MSFGridPanel(pdfC401yDef, false, false, false, false, false);
		yetaPdfC401yGridPanel.setHeaderVisible(false);
		yetaPdfC401yGridPanel.setBodyBorder(false);
		yetaPdfC401yGridPanel.setBorders(true);
		yetaPdfC401yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC401yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfC401yDTO pdfC401yDto = new PdfC401yDTO();
				List<PdfC401yDTO> listPdfC401yDto = new ArrayList<PdfC401yDTO>();

				Iterator<BaseModel> itBm = yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfC401yDto = new PdfC401yDTO();

						pdfC401yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfC401yDto.setSchUniSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("schUniSeilNum"))));
						pdfC401yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfC401yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfC401yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfC401yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfC401yDto.add(pdfC401yDto);
					}
				}


				if(listPdfC401yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfC401Y(listPdfC401yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfC401yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfC401yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfC401yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_D101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfD101yGridPanel = new MSFGridPanel(pdfD101yDef, false, false, false, false, false);
		yetaPdfD101yGridPanel.setHeaderVisible(false);
		yetaPdfD101yGridPanel.setBodyBorder(false);
		yetaPdfD101yGridPanel.setBorders(true);
		yetaPdfD101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfD101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfD101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfD101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfD101yDTO pdfD101yDto = new PdfD101yDTO();
				List<PdfD101yDTO> listPdfD101yDto = new ArrayList<PdfD101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfD101yDto = new PdfD101yDTO();

						pdfD101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfD101yDto.setPnsnSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("pnsnSeilNum")));
						pdfD101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfD101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfD101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfD101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfD101yDto.add(pdfD101yDto);
					}
				}


				if(listPdfD101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfD101Y(listPdfD101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfD101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfD101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfD101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_E102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfE102yGridPanel = new MSFGridPanel(pdfE102yDef, false, false, false, false, false);
		yetaPdfE102yGridPanel.setHeaderVisible(false);
		yetaPdfE102yGridPanel.setBodyBorder(false);
		yetaPdfE102yGridPanel.setBorders(true);
		yetaPdfE102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfE102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfE102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfE102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfE102yDTO pdfE102yDto = new PdfE102yDTO();
				List<PdfE102yDTO> listPdfE102yDto = new ArrayList<PdfE102yDTO>();

				Iterator<BaseModel> itBm = yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfE102yDto = new PdfE102yDTO();

						pdfE102yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfE102yDto.setPnsnSvSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("pnsnSvSeilNum")));
						pdfE102yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfE102yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfE102yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfE102yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfE102yDto.add(pdfE102yDto);
					}
				}


				if(listPdfE102yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfE102Y(listPdfE102yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfE102yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfE102yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfE102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_F102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfF102yGridPanel = new MSFGridPanel(pdfF102yDef, false, false, false, false, false);
		yetaPdfF102yGridPanel.setHeaderVisible(false);
		yetaPdfF102yGridPanel.setBodyBorder(false);
		yetaPdfF102yGridPanel.setBorders(true);
		yetaPdfF102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfF102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfF102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfF102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfF102yDTO pdfF102yDto = new PdfF102yDTO();
				List<PdfF102yDTO> listPdfF102yDto = new ArrayList<PdfF102yDTO>();

				Iterator<BaseModel> itBm = yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfF102yDto = new PdfF102yDTO();

						pdfF102yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfF102yDto.setAccNo(MSFSharedUtils.allowNulls(bmMapModel.get("accNo")));
						pdfF102yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfF102yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfF102yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfF102yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfF102yDto.add(pdfF102yDto);
					}
				}


				if(listPdfF102yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfF102Y(listPdfF102yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfF102yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfF102yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfF102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_G106Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfG106yGridPanel = new MSFGridPanel(pdfG106yDef, false, false, false, false, false);
		yetaPdfG106yGridPanel.setHeaderVisible(false);
		yetaPdfG106yGridPanel.setBodyBorder(false);
		yetaPdfG106yGridPanel.setBorders(true);
		yetaPdfG106yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG106yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG106yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG106yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfG106yDTO pdfG106yDto = new PdfG106yDTO();
				List<PdfG106yDTO> listPdfG106yDto = new ArrayList<PdfG106yDTO>();

				Iterator<BaseModel> itBm = yetaPdfG106yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfG106yDto = new PdfG106yDTO();

						pdfG106yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfG106yDto.setCardSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("cardSeilNum"))));
						pdfG106yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfG106yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfG106yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfG106yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfG106yDto.add(pdfG106yDto);
					}
				}


				if(listPdfG106yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfG106Y(listPdfG106yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfG106yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfG106yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfG106yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_G206Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfG206yGridPanel = new MSFGridPanel(pdfG206yDef, false, false, false, false, false);
		yetaPdfG206yGridPanel.setHeaderVisible(false);
		yetaPdfG206yGridPanel.setBodyBorder(false);
		yetaPdfG206yGridPanel.setBorders(true);
		yetaPdfG206yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG206yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG206yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG206yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfG206yDTO pdfG206yDto = new PdfG206yDTO();
				List<PdfG206yDTO> listPdfG206yDto = new ArrayList<PdfG206yDTO>();

				Iterator<BaseModel> itBm = yetaPdfG206yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfG206yDto = new PdfG206yDTO();

						pdfG206yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfG206yDto.setCashCardSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("cashCardSeilNum"))));
						pdfG206yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfG206yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfG206yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfG206yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfG206yDto.add(pdfG206yDto);
					}
				}


				if(listPdfG206yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfG206Y(listPdfG206yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfG206yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfG206yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfG206yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_G306Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfG306yGridPanel = new MSFGridPanel(pdfG306yDef, false, false, false, false, false);
		yetaPdfG306yGridPanel.setHeaderVisible(false);
		yetaPdfG306yGridPanel.setBodyBorder(false);
		yetaPdfG306yGridPanel.setBorders(true);
		yetaPdfG306yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG306yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG306yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG306yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfG306yDTO pdfG306yDto = new PdfG306yDTO();
				List<PdfG306yDTO> listPdfG306yDto = new ArrayList<PdfG306yDTO>();

				Iterator<BaseModel> itBm = yetaPdfG306yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfG306yDto = new PdfG306yDTO();

						pdfG306yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfG306yDto.setDirCardSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("dirCardSeilNum"))));
						pdfG306yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfG306yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfG306yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfG306yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfG306yDto.add(pdfG306yDto);
					}
				}


				if(listPdfG306yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfG306Y(listPdfG306yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfG306yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfG306yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfG306yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_J101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfJ101yGridPanel = new MSFGridPanel(pdfJ101yDef, false, false, false, false, false);
		yetaPdfJ101yGridPanel.setHeaderVisible(false);
		yetaPdfJ101yGridPanel.setBodyBorder(false);
		yetaPdfJ101yGridPanel.setBorders(true);
		yetaPdfJ101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfJ101yDTO pdfJ101yDto = new PdfJ101yDTO();
				List<PdfJ101yDTO> listPdfJ101yDto = new ArrayList<PdfJ101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfJ101yDto = new PdfJ101yDTO();

						pdfJ101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfJ101yDto.setTradeSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("tradeSeilNum"))));
						pdfJ101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfJ101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfJ101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfJ101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfJ101yDto.add(pdfJ101yDto);
					}
				}


				if(listPdfJ101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfJ101Y(listPdfJ101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfJ101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfJ101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfJ101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_J203Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfJ203yGridPanel = new MSFGridPanel(pdfJ203yDef, false, false, false, false, false);
		yetaPdfJ203yGridPanel.setHeaderVisible(false);
		yetaPdfJ203yGridPanel.setBodyBorder(false);
		yetaPdfJ203yGridPanel.setBorders(true);
		yetaPdfJ203yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ203yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfJ203yDTO pdfJ203yDto = new PdfJ203yDTO();
				List<PdfJ203yDTO> listPdfJ203yDto = new ArrayList<PdfJ203yDTO>();

				Iterator<BaseModel> itBm = yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfJ203yDto = new PdfJ203yDTO();

						pdfJ203yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfJ203yDto.setLoanSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("loanSeilNum"))));
						pdfJ203yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfJ203yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfJ203yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfJ203yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfJ203yDto.add(pdfJ203yDto);
					}
				}


				if(listPdfJ203yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfJ203Y(listPdfJ203yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfJ203yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfJ203yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfJ203yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_J301Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfJ301yGridPanel = new MSFGridPanel(pdfJ301yDef, false, false, false, false, false);
		yetaPdfJ301yGridPanel.setHeaderVisible(false);
		yetaPdfJ301yGridPanel.setBodyBorder(false);
		yetaPdfJ301yGridPanel.setBorders(true);
		yetaPdfJ301yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ301yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfJ301yDTO pdfJ301yDto = new PdfJ301yDTO();
				List<PdfJ301yDTO> listPdfJ301yDto = new ArrayList<PdfJ301yDTO>();

				Iterator<BaseModel> itBm = yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfJ301yDto = new PdfJ301yDTO();

						pdfJ301yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfJ301yDto.setHomeSeilSum(MSFSharedUtils.allowNulls(bmMapModel.get("homeSeilSum")));
						pdfJ301yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfJ301yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfJ301yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfJ301yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfJ301yDto.add(pdfJ301yDto);
					}
				}


				if(listPdfJ301yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfJ301Y(listPdfJ301yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfJ301yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfJ301yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfJ301yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_J401Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfJ401yGridPanel = new MSFGridPanel(pdfJ401yDef, false, false, false, false, false);
		yetaPdfJ401yGridPanel.setHeaderVisible(false);
		yetaPdfJ401yGridPanel.setBodyBorder(false);
		yetaPdfJ401yGridPanel.setBorders(true);
		yetaPdfJ401yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ401yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfJ401yDTO pdfJ401yDto = new PdfJ401yDTO();
				List<PdfJ401yDTO> listPdfJ401yDto = new ArrayList<PdfJ401yDTO>();

				Iterator<BaseModel> itBm = yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfJ401yDto = new PdfJ401yDTO();

						pdfJ401yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfJ401yDto.setAccNo(MSFSharedUtils.allowNulls(bmMapModel.get("accNo")));
						pdfJ401yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfJ401yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfJ401yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfJ401yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfJ401yDto.add(pdfJ401yDto);
					}
				}


				if(listPdfJ401yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfJ401Y(listPdfJ401yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfJ401yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfJ401yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfJ401yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_K101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfK101yGridPanel = new MSFGridPanel(pdfK101yDef, false, false, false, false, false);
		yetaPdfK101yGridPanel.setHeaderVisible(false);
		yetaPdfK101yGridPanel.setBodyBorder(false);
		yetaPdfK101yGridPanel.setBorders(true);	
		yetaPdfK101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfK101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfK101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfK101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfK101yDTO pdfK101yDto = new PdfK101yDTO();
				List<PdfK101yDTO> listPdfK101yDto = new ArrayList<PdfK101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfK101yDto = new PdfK101yDTO();

						pdfK101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfK101yDto.setAccNo(MSFSharedUtils.allowNulls(bmMapModel.get("accNo")));
						pdfK101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfK101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfK101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfK101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfK101yDto.add(pdfK101yDto);
					}
				}


				if(listPdfK101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfK101Y(listPdfK101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfK101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfK101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfK101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_L102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfL102yGridPanel = new MSFGridPanel(pdfL102yDef, false, false, false, false, false);
		yetaPdfL102yGridPanel.setHeaderVisible(false);
		yetaPdfL102yGridPanel.setBodyBorder(false);
		yetaPdfL102yGridPanel.setBorders(true);
		yetaPdfL102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfL102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfL102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfL102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfL102yDTO pdfL102yDto = new PdfL102yDTO();
				List<PdfL102yDTO> listPdfL102yDto = new ArrayList<PdfL102yDTO>();

				Iterator<BaseModel> itBm = yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfL102yDto = new PdfL102yDTO();

						pdfL102yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfL102yDto.setConbSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("conbSeilNum"))));
						pdfL102yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfL102yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfL102yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfL102yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfL102yDto.add(pdfL102yDto);
					}
				}


				if(listPdfL102yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfL102Y(listPdfL102yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfL102yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfL102yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfL102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_N101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfN101yGridPanel = new MSFGridPanel(pdfN101yDef, false, false, false, false, false);
		yetaPdfN101yGridPanel.setHeaderVisible(false);
		yetaPdfN101yGridPanel.setBodyBorder(false);
		yetaPdfN101yGridPanel.setBorders(true);
		yetaPdfN101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfN101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfN101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfN101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfN101yDTO pdfN101yDto = new PdfN101yDTO();
				List<PdfN101yDTO> listPdfN101yDto = new ArrayList<PdfN101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfN101yDto = new PdfN101yDTO();

						pdfN101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfN101yDto.setSecuNo(MSFSharedUtils.allowNulls(bmMapModel.get("secuNo")));
						pdfN101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfN101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfN101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfN101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfN101yDto.add(pdfN101yDto);
					}
				}


				if(listPdfN101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfN101Y(listPdfN101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfN101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfN101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfN101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}


	private LayoutContainer Yeta_PDF_O101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfO101yGridPanel = new MSFGridPanel(pdfO101yDef, false, false, false, false, false);
		yetaPdfO101yGridPanel.setHeaderVisible(false);
		yetaPdfO101yGridPanel.setBodyBorder(false);
		yetaPdfO101yGridPanel.setBorders(true);
		yetaPdfO101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfO101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfO101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfO101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfO101yDTO pdfO101yDto = new PdfO101yDTO();
				List<PdfO101yDTO> listPdfO101yDto = new ArrayList<PdfO101yDTO>();

				Iterator<BaseModel> itBm = yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfO101yDto = new PdfO101yDTO();

						pdfO101yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfO101yDto.setDatCd(MSFSharedUtils.allowNulls(bmMapModel.get("datCd")));
						pdfO101yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfO101yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfO101yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfO101yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfO101yDto.add(pdfO101yDto);
					}
				}


				if(listPdfO101yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfO101Y(listPdfO101yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfO101yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfO101yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfO101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	private LayoutContainer Yeta_PDF_P102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 550);

		yetaPdfP102yGridPanel = new MSFGridPanel(pdfP102yDef, false, false, false, false, false);
		yetaPdfP102yGridPanel.setHeaderVisible(false);
		yetaPdfP102yGridPanel.setBodyBorder(false);
		yetaPdfP102yGridPanel.setBorders(true);
		yetaPdfP102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfP102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		//		grid.getView().setForceFit(true);	

		//툴바메뉴
		ToolBar bottomToolbar = new ToolBar();  
		bottomToolbar.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnAllUsed = new Button("전체선택");
		btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfP102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar.add(btnAllUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnUsed = new Button("전체해제");
		btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfP102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnUnUsed);
		bottomToolbar.add(new SeparatorMenuItem());
		//====================================================

		btnSelected = new Button("소득공제반영");
		btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  

				int iCnt = 0;

				PdfP102yDTO pdfP102yDto = new PdfP102yDTO();
				List<PdfP102yDTO> listPdfP102yDto = new ArrayList<PdfP102yDTO>();

				Iterator<BaseModel> itBm = yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 

				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if (bmMapModel.get("select").equals("true")&& bmMapModel.get("pdfDatAppExcCtnt") != null ) {
						MessageBox.info("경고", "적용시 제외사유를 입력할 수 없습니다.", null);
						return;
					}

					if ((Boolean) bmMapModel.get("select")) {
						pdfP102yDto = new PdfP102yDTO();

						pdfP102yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						pdfP102yDto.setDatCd(MSFSharedUtils.allowNulls(bmMapModel.get("datCd")));
						pdfP102yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
						pdfP102yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

						pdfP102yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
						pdfP102yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

						listPdfP102yDto.add(pdfP102yDto);
					}
				}


				if(listPdfP102yDto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}

				yetaP220001Service.updateYetaP220001ToPdfP102Y(listPdfP102yDto, actionDatabase, new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.info("생성완료", "총 " + result + "개의 소득공제가 생성되었습니다.</br> 팝업을 닫은 후 조회해주시길 바랍니다.", null);
						reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}
		});
		bottomToolbar.add(btnSelected);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				yetaPdfP102yGridPanel.reload();	                	
			}  
		});		            
		bottomToolbar.add(refresh);

		//툴바 넣어주는것
		yetaPdfP102yGridPanel.setBottomComponent(bottomToolbar);

		cp01.add(yetaPdfP102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	public void reload() {
		IColumnFilter filters = null;

		yetaPdfA102yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfA102yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfA102yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfA102yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfA102yGridPanel.reload();  

		yetaPdfB101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfB101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfB101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfB101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfB101yGridPanel.reload();  

		yetaPdfC101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfC101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC101yGridPanel.reload();  

		yetaPdfC202yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfC202yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC202yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC202yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC202yGridPanel.reload();  

		yetaPdfC301yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfC301yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC301yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC301yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC301yGridPanel.reload();  

		yetaPdfC401yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfC401yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC401yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC401yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfC401yGridPanel.reload();  

		yetaPdfD101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfD101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfD101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfD101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfD101yGridPanel.reload();  

		yetaPdfE102yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfE102yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfE102yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfE102yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfE102yGridPanel.reload();  

		yetaPdfF102yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfF102yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfF102yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfF102yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfF102yGridPanel.reload();  

		yetaPdfG106yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG106yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG106yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG106yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG106yGridPanel.reload();  

		yetaPdfG206yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG206yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG206yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG206yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG206yGridPanel.reload();  

		yetaPdfG306yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG306yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG306yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG306yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG306yGridPanel.reload();  

		yetaPdfJ101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfJ101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ101yGridPanel.reload();  

		yetaPdfJ203yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfJ203yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ203yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ203yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ203yGridPanel.reload();  

		yetaPdfJ301yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfJ301yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ301yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ301yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ301yGridPanel.reload();  

		yetaPdfJ401yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfJ401yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ401yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ401yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfJ401yGridPanel.reload();  

		yetaPdfK101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfK101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfK101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfK101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfK101yGridPanel.reload();  

		yetaPdfL102yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfL102yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfL102yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfL102yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfL102yGridPanel.reload();  

		yetaPdfN101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfN101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfN101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfN101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfN101yGridPanel.reload();  

		yetaPdfO101yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfO101yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfO101yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfO101yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfO101yGridPanel.reload();  

		yetaPdfP102yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfP102yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfP102yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfP102yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfP102yGridPanel.reload();  

	}

	// 폼초기화 검색조건포함
	private void formInit() {

		//		yetaP220001GridPanel.getMsfGrid().clearData();
		actionDatabase = ActionDatabase.READ;

	}

	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				reload();
			}
		});
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}

}
