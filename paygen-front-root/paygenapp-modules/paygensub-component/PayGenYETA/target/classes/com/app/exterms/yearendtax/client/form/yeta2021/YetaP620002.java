/**
 * 월별급여내역
 */
package com.app.exterms.yearendtax.client.form.yeta2021;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfB101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfF102yDTO;
//import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG106yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG107yDTO;
//import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG206yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG207yDTO;
//import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG306yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG307yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG407yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfP102yDTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfA102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfB101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfC101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfC202yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfC301yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfC401yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfD101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfE102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfF102yDef;
//import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG106yDef;
//import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG206yDef;
//import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG306yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG107yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG207yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG307yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfG407yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfJ101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfJ203yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfJ301yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfJ401yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfK101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfL102yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfN101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfO101yDef;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.PdfP102yDef;
import com.app.exterms.yearendtax.client.service.yeta2021.YetaP620001Service;
import com.app.exterms.yearendtax.client.service.yeta2021.YetaP620001ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP620002   extends MSFFormPanel {  

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	전역변수 선언부  시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/

	private  ContentPanel cpYeta61001; 

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
	//private PdfG106yDef pdfG106yDef = new PdfG106yDef("");	
	private PdfG107yDef pdfG107yDef = new PdfG107yDef("");

	//	private PdfG205yDef pdfG205yDef = new PdfG205yDef("");
	//private PdfG206yDef pdfG206yDef = new PdfG206yDef("");
	private PdfG207yDef pdfG207yDef = new PdfG207yDef("");
	//	private PdfG304yDef pdfG304yDef = new PdfG304yDef("");
	//private PdfG306yDef pdfG306yDef = new PdfG306yDef("");
	private PdfG307yDef pdfG307yDef = new PdfG307yDef("");
	
	/** 제로페이 **/
	private PdfG407yDef pdfG407yDef = new PdfG407yDef("");
	
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
	//private MSFGridPanel yetaPdfG106yGridPanel;
	private MSFGridPanel yetaPdfG107yGridPanel;

	//	private MSFGridPanel yetaPdfG205yGridPanel;
	//private MSFGridPanel yetaPdfG206yGridPanel;	
	private MSFGridPanel yetaPdfG207yGridPanel;
	//	private MSFGridPanel yetaPdfG304yGridPanel;
	//private MSFGridPanel yetaPdfG306yGridPanel;
	private MSFGridPanel yetaPdfG307yGridPanel;
	
	/** 제로페이 **/
	private MSFGridPanel yetaPdfG407yGridPanel;
	
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

	private ButtonBar topYeta620002Bar;
	private Button btnYeta620002AllUsed; 	// 전체선택
	private Button btnYeta620002UnUsed; 		// 선택해제
	private Button btnYeta620002Save; 	// 소득공제반영
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

	private YetaP620001ServiceAsync yetaP620001Service = YetaP620001Service.Util.getInstance();

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
	public YetaP620002(final ActionDatabase actionDatabase, final MSFPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
		// 콤보 권한초기화

		cpYeta61001 = new ContentPanel();

		createBasicForm(); 	// 검색필드를 적용
		createStandardForm(); 	// 기본정보필드

		cpYeta61001.setBodyBorder(false);
		cpYeta61001.setBorders(false);
		cpYeta61001.setScrollMode(Scroll.AUTOY);
		cpYeta61001.setHeaderVisible(false);
		cpYeta61001.setSize("913px", "660px");

		this.add(cpYeta61001);
		formBinding = new FormBinding(this, true);

		this.setSize("945px", "710px");
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
		fieldSet.setStyleAttribute("paddingTop", "5px");
		fieldSet.setSize(885, 50);
		fieldSet.setHeadingHtml("기본정보");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());

		/** column text : 기본정보_성명 cretypOccuNm */
		LayoutContainer layoutContainer11 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
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
		frmlytSch.setLabelWidth(50);
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
		frmlytSch.setLabelWidth(50);
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

		topYeta620002Bar = new ButtonBar();
		topYeta620002Bar.setAlignment(HorizontalAlignment.RIGHT);
		topYeta620002Bar.setStyleAttribute("paddingRight", "15px");
		topYeta620002Bar.setStyleAttribute("paddingTop", "5px");

		btnYeta620002AllUsed = new Button("전체선택");
		topYeta620002Bar.add(btnYeta620002AllUsed);
		btnYeta620002AllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfA102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt2 = yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt2;iCnt++) {

					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfB101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt3 = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt3;iCnt++) {

					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt4 = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt4;iCnt++) {

					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt5 = yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt5;iCnt++) {

					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC202yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt6 = yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt6;iCnt++) {

					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt7 = yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt7;iCnt++) {

					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt8 = yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt8;iCnt++) {

					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfD101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt9 = yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt9;iCnt++) {

					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfE102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt10 = yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt10;iCnt++) {

					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfF102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt11 = yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt11;iCnt++) {

					yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG107yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt12 = yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt12;iCnt++) {

					yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG207yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt13 = yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt13;iCnt++) {

					yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG307yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				/** 제로페이 **/
				int  lsCnt14 = yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt14;iCnt++) {

					yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG407yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt15 = yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt15;iCnt++) {

					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt16 = yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt16;iCnt++) {

					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt17 = yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt17;iCnt++) {

					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt18 = yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt18;iCnt++) {

					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt19 = yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt19;iCnt++) {

					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfK101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt20 = yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt20;iCnt++) {

					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfL102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt21 = yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt21;iCnt++) {

					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfN101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt22 = yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt22;iCnt++) {

					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfO101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt23 = yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt23;iCnt++) {

					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfP102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});

		btnYeta620002UnUsed = new Button("선택해제");
		topYeta620002Bar.add(btnYeta620002UnUsed);
		btnYeta620002UnUsed.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 

				int  lsCnt = yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfA102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfA102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt2 = yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt2;iCnt++) {

					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfB101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfB101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt3 = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt3;iCnt++) {

					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt4 = yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt4;iCnt++) {

					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt5 = yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt5;iCnt++) {

					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC202yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC202yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt6 = yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt6;iCnt++) {

					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt7 = yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt7;iCnt++) {

					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfC401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfC401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt8 = yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt8;iCnt++) {

					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfD101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfD101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt9 = yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt9;iCnt++) {

					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfE102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfE102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt10 = yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt10;iCnt++) {

					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfF102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfF102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt11 = yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt11;iCnt++) {

					yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG107yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt12 = yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt12;iCnt++) {

					yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG207yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt13 = yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt13;iCnt++) {

					yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG307yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				/** 제로페이 **/
				int  lsCnt14 = yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt14;iCnt++) {

					yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfG407yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt15 = yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt15;iCnt++) {

					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt16 = yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt16;iCnt++) {

					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ203yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt17 = yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt17;iCnt++) {

					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ301yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt18 = yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt18;iCnt++) {

					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfJ401yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt19 = yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt19;iCnt++) {

					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfK101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfK101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt20 = yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt20;iCnt++) {

					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfL102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfL102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt21 = yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt21;iCnt++) {

					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfN101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfN101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt22 = yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt22;iCnt++) {

					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfO101yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfO101yGridPanel.getMsfGrid().getGrid().getView().refresh(true);

				int  lsCnt23 = yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt23; iCnt++) {

					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					yetaPdfP102yGridPanel.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				yetaPdfP102yGridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});  

		btnYeta620002Save = new Button("소득공제반영");
		topYeta620002Bar.add(btnYeta620002Save);
		btnYeta620002Save.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {
				final List<PdfA102yDTO> listPdfA102yDto = A102UpdateSetDto();
				final List<PdfB101yDTO> listPdfB101yDto = B101UpdateSetDto();
				final List<PdfC101yDTO> listPdfC101yDto = C101UpdateSetDto();
				final List<PdfC202yDTO> listPdfC202yDto = C202UpdateSetDto();
				final List<PdfC301yDTO> listPdfC301yDto = C301UpdateSetDto();
				
				final List<PdfC401yDTO> listPdfC401yDto = C401UpdateSetDto();
				final List<PdfD101yDTO> listPdfD101yDto = D101UpdateSetDto();
				final List<PdfE102yDTO> listPdfE102yDto = E102UpdateSetDto();
				final List<PdfF102yDTO> listPdfF102yDto = F102UpdateSetDto();
				final List<PdfG107yDTO> listPdfG107yDto = G107UpdateSetDto();

				final List<PdfG207yDTO> listPdfG207yDto = G207UpdateSetDto();
				final List<PdfG307yDTO> listPdfG307yDto = G307UpdateSetDto();
				
				/** 제로페이 **/
				final List<PdfG407yDTO> listPdfG407yDto = G407UpdateSetDto();
				
				final List<PdfJ101yDTO> listPdfJ101yDto = J101UpdateSetDto();
				final List<PdfJ203yDTO> listPdfJ203yDto = J203UpdateSetDto();
				final List<PdfJ301yDTO> listPdfJ301yDto = J301UpdateSetDto();

				final List<PdfJ401yDTO> listPdfJ401yDto = J401UpdateSetDto();
				final List<PdfK101yDTO> listPdfK101yDto = K101UpdateSetDto();
				final List<PdfL102yDTO> listPdfL102yDto = L102UpdateSetDto();
				final List<PdfN101yDTO> listPdfN101yDto = N101UpdateSetDto();
				final List<PdfO101yDTO> listPdfO101yDto = O101UpdateSetDto();

				final List<PdfP102yDTO> listPdfP102yDto = P102UpdateSetDto();
				
				/** 그리드에서 하나의 값도 받지 못하면 메세지 박스 알림*/
				if ((listPdfA102yDto.size() + listPdfB101yDto.size() + listPdfC101yDto.size() + listPdfC202yDto.size() +
						listPdfC301yDto.size() + listPdfC401yDto.size() + listPdfD101yDto.size() + listPdfE102yDto.size() + 
						listPdfF102yDto.size() + listPdfG107yDto.size() + listPdfG207yDto.size() + listPdfG307yDto.size() +
						listPdfG407yDto.size() + listPdfJ101yDto.size() + listPdfJ203yDto.size() + listPdfJ301yDto.size() +
						listPdfJ401yDto.size() + listPdfK101yDto.size() + listPdfL102yDto.size() + listPdfN101yDto.size() +
						listPdfO101yDto.size() + listPdfP102yDto.size()) <= 0 ) {

					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;

				}

				MessageBox.confirm("","소득공제를 반영하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							/** 조건 확인 */
							if (listPdfA102yDto.size() > 0) {UpdateA102(listPdfA102yDto);}     //보장성보험
							if (listPdfB101yDto.size() > 0) {UpdateB101(listPdfB101yDto);}     //의료비
							if (listPdfC101yDto.size() > 0) {UpdateC101(listPdfC101yDto);}     //교육비
							if (listPdfC202yDto.size() > 0) {UpdateC202(listPdfC202yDto);}     //직업훈련비
							if (listPdfC301yDto.size() > 0) {UpdateC301(listPdfC301yDto);}     //교복구입비
							                                                                   
							if (listPdfC401yDto.size() > 0) {UpdateC401(listPdfC401yDto);}     //학자금상환
							if (listPdfD101yDto.size() > 0) {UpdateD101(listPdfD101yDto);}     //개인연금저축
							if (listPdfE102yDto.size() > 0) {UpdateE102(listPdfE102yDto);}     //연금저축
							if (listPdfF102yDto.size() > 0) {UpdateF102(listPdfF102yDto);}     //퇴직연금
							if (listPdfG107yDto.size() > 0) {UpdateG107(listPdfG107yDto);}     //신용카드
							                                                                   
							if (listPdfG207yDto.size() > 0) {UpdateG207(listPdfG207yDto);}     //현금영수증
							if (listPdfG307yDto.size() > 0) {UpdateG307(listPdfG307yDto);}     //직불카드등
							/** 제로페이 **/
							if (listPdfG407yDto.size() > 0) {UpdateG407(listPdfG407yDto);}     //제로페이
							if (listPdfJ101yDto.size() > 0) {UpdateJ101(listPdfJ101yDto);}     //주택임차차입금원리금상환액
							if (listPdfJ203yDto.size() > 0) {UpdateJ203(listPdfJ203yDto);}     //장기주택저당차입금이자상환액
							if (listPdfJ301yDto.size() > 0) {UpdateJ301(listPdfJ301yDto);}     //주택마련저축
							                                                                   
							if (listPdfJ401yDto.size() > 0) {UpdateJ401(listPdfJ401yDto);}     //목돈안드는전세이자상환액
							if (listPdfK101yDto.size() > 0) {UpdateK101(listPdfK101yDto);}     //소기업소상공인공제부금
							if (listPdfL102yDto.size() > 0) {UpdateL102(listPdfL102yDto);}     //기부금
							if (listPdfN101yDto.size() > 0) {UpdateN101(listPdfN101yDto);}     //장기집합투자증권저축
							if (listPdfO101yDto.size() > 0) {UpdateO101(listPdfO101yDto);}     //건강보험료
							                                                                   
							if (listPdfP102yDto.size() > 0) {UpdateP102(listPdfP102yDto);}     //국민연금보험료
						}
					}
				});

			}
		});



		cpYeta61001.add(fieldSet, new FormData("100%"));
		cpYeta61001.add(topYeta620002Bar, new FormData("100%"));
	}


	private void createStandardForm() {
		systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta61001.add(systemkey);

		dpobCd = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		dpobCd.setName("dpobCd");
		cpYeta61001.add(dpobCd);

		yrtxBlggYr = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYeta61001.add(yrtxBlggYr);

		clutSeptCd = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		clutSeptCd.setName("clutSeptCd");
		cpYeta61001.add(clutSeptCd);


		ContentPanel panel = new ContentPanel();
		panel.setBodyBorder(false);
		panel.setBorders(false);
		panel.setHeaderVisible(false);
		panel.setScrollMode(Scroll.AUTO);

		LayoutContainer layoutContainer = new LayoutContainer();

		FieldSet fieldSet = new FieldSet();
		fieldSet.setStyleAttribute("paddingTop", "15px");
		fieldSet.setSize(885, 280);
		fieldSet.setHeadingHtml("보장성보험");
		fieldSet.add(Yeta_PDF_A102Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet);

		FieldSet fieldSet2 = new FieldSet();
		fieldSet2.setStyleAttribute("paddingTop", "15px");
		fieldSet2.setSize(885, 280);
		fieldSet2.setHeadingHtml("의료비");
		fieldSet2.add(Yeta_PDF_B101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet2);

		FieldSet fieldSet3 = new FieldSet();
		fieldSet3.setStyleAttribute("paddingTop", "15px");
		fieldSet3.setSize(885, 280);
		fieldSet3.setHeadingHtml("교육비");
		fieldSet3.add(Yeta_PDF_C101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet3);

		FieldSet fieldSet4 = new FieldSet();
		fieldSet4.setStyleAttribute("paddingTop", "15px");
		fieldSet4.setSize(885, 280);
		fieldSet4.setHeadingHtml("직업훈련비");
		fieldSet4.add(Yeta_PDF_C202Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet4);

		FieldSet fieldSet5 = new FieldSet();
		fieldSet5.setStyleAttribute("paddingTop", "15px");
		fieldSet5.setSize(885, 280);
		fieldSet5.setHeadingHtml("교복구입비");
		fieldSet5.add(Yeta_PDF_C301Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet5);

		FieldSet fieldSet6 = new FieldSet();
		fieldSet6.setStyleAttribute("paddingTop", "15px");
		fieldSet6.setSize(885, 280);
		fieldSet6.setHeadingHtml("학자금상환");
		fieldSet6.add(Yeta_PDF_C401Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet6);

		FieldSet fieldSet7 = new FieldSet();
		fieldSet7.setStyleAttribute("paddingTop", "15px");
		fieldSet7.setSize(885, 280);
		fieldSet7.setHeadingHtml("개인연금저축");
		fieldSet7.add(Yeta_PDF_D101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet7);

		FieldSet fieldSet8 = new FieldSet();
		fieldSet8.setStyleAttribute("paddingTop", "15px");
		fieldSet8.setSize(885, 280);
		fieldSet8.setHeadingHtml("연금저축");
		fieldSet8.add(Yeta_PDF_E102Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet8);

		FieldSet fieldSet9 = new FieldSet();
		fieldSet9.setStyleAttribute("paddingTop", "15px");
		fieldSet9.setSize(885, 280);
		fieldSet9.setHeadingHtml("퇴직연금");
		fieldSet9.add(Yeta_PDF_F102Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet9);

		FieldSet fieldSet10 = new FieldSet();
		fieldSet10.setStyleAttribute("paddingTop", "15px");
		fieldSet10.setSize(885, 280);
		fieldSet10.setHeadingHtml("신용카드");
		fieldSet10.add(Yeta_PDF_G107Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet10);

		FieldSet fieldSet11 = new FieldSet();
		fieldSet11.setStyleAttribute("paddingTop", "15px");
		fieldSet11.setSize(885, 280);
		fieldSet11.setHeadingHtml("현금영수증");
		fieldSet11.add(Yeta_PDF_G207Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet11);

		FieldSet fieldSet12 = new FieldSet();
		fieldSet12.setStyleAttribute("paddingTop", "15px");
		fieldSet12.setSize(885, 280);
		fieldSet12.setHeadingHtml("직불카드등");
		fieldSet12.add(Yeta_PDF_G307Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet12);

		FieldSet fieldSet13 = new FieldSet();
		fieldSet13.setStyleAttribute("paddingTop", "15px");
		fieldSet13.setSize(885, 280);
		fieldSet13.setHeadingHtml("제로페이");
		fieldSet13.add(Yeta_PDF_G407Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet13);

		FieldSet fieldSet14 = new FieldSet();
		fieldSet14.setStyleAttribute("paddingTop", "15px");
		fieldSet14.setSize(885, 280);
		fieldSet14.setHeadingHtml("주택임차차입금원리금상환액");
		fieldSet14.add(Yeta_PDF_J101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet14);

		FieldSet fieldSet15 = new FieldSet();
		fieldSet15.setStyleAttribute("paddingTop", "15px");
		fieldSet15.setSize(885, 280);
		fieldSet15.setHeadingHtml("장기주택저당차입금이자상환액");
		fieldSet15.add(Yeta_PDF_J203Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet15);

		FieldSet fieldSet16 = new FieldSet();
		fieldSet16.setStyleAttribute("paddingTop", "15px");
		fieldSet16.setSize(885, 280);
		fieldSet16.setHeadingHtml("주택마련저축");
		fieldSet16.add(Yeta_PDF_J301Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet16);

		FieldSet fieldSet17 = new FieldSet();
		fieldSet17.setStyleAttribute("paddingTop", "15px");
		fieldSet17.setSize(885, 280);
		fieldSet17.setHeadingHtml("목돈안드는전세이자상환액");
		fieldSet17.add(Yeta_PDF_J401Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet17);

		FieldSet fieldSet18 = new FieldSet();
		fieldSet18.setStyleAttribute("paddingTop", "15px");
		fieldSet18.setSize(885, 280);
		fieldSet18.setHeadingHtml("소기업소상공인공제부금");
		fieldSet18.add(Yeta_PDF_K101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet18);

		FieldSet fieldSet19 = new FieldSet();
		fieldSet19.setStyleAttribute("paddingTop", "15px");
		fieldSet19.setSize(885, 280);
		fieldSet19.setHeadingHtml("기부금");
		fieldSet19.add(Yeta_PDF_L102Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet19);

		FieldSet fieldSet20 = new FieldSet();
		fieldSet20.setStyleAttribute("paddingTop", "15px");
		fieldSet20.setSize(885, 280);
		fieldSet20.setHeadingHtml("장기집합투자증권저축");
		fieldSet20.add(Yeta_PDF_N101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet20);

		FieldSet fieldSet21 = new FieldSet();
		fieldSet21.setStyleAttribute("paddingTop", "15px");
		fieldSet21.setSize(885, 280);
		fieldSet21.setHeadingHtml("건강보험료");
		fieldSet21.add(Yeta_PDF_O101Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet21);

		FieldSet fieldSet22 = new FieldSet();
		fieldSet22.setStyleAttribute("paddingTop", "15px");
		fieldSet22.setSize(885, 280);
		fieldSet22.setHeadingHtml("국민연금보험료");
		fieldSet22.add(Yeta_PDF_P102Y_Grid(), new FormData("100%"));
		layoutContainer.add(fieldSet22);

		panel.add(layoutContainer);

		cpYeta61001.add(panel, new FormData("100%"));

	}

	//보장성 보험 그리드선언
	private LayoutContainer Yeta_PDF_A102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfA102yGridPanel = new MSFGridPanel(pdfA102yDef, false, false, false, false, false);
		yetaPdfA102yGridPanel.setHeaderVisible(false);
		yetaPdfA102yGridPanel.setBodyBorder(false);
		yetaPdfA102yGridPanel.setBorders(true);
		//		yetaPdfA102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfA102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfA102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//의료비 그리드선언
	private LayoutContainer Yeta_PDF_B101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfB101yGridPanel = new MSFGridPanel(pdfB101yDef, false, false, false, false, false);
		yetaPdfB101yGridPanel.setHeaderVisible(false);
		yetaPdfB101yGridPanel.setBodyBorder(false);
		yetaPdfB101yGridPanel.setBorders(true);
		//		yetaPdfB101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfB101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfB101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//교육비 그리드선언
	private LayoutContainer Yeta_PDF_C101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfC101yGridPanel = new MSFGridPanel(pdfC101yDef, false, false, false, false, false);
		yetaPdfC101yGridPanel.setHeaderVisible(false);
		yetaPdfC101yGridPanel.setBodyBorder(false);
		yetaPdfC101yGridPanel.setBorders(true);
		//		yetaPdfC101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfC101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//직업훈련비 그리드선언
	private LayoutContainer Yeta_PDF_C202Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfC202yGridPanel = new MSFGridPanel(pdfC202yDef, false, false, false, false, false);
		yetaPdfC202yGridPanel.setHeaderVisible(false);
		yetaPdfC202yGridPanel.setBodyBorder(false);
		yetaPdfC202yGridPanel.setBorders(true);
		//		yetaPdfC202yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC202yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfC202yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//교복구입비 그리드선언
	private LayoutContainer Yeta_PDF_C301Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfC301yGridPanel = new MSFGridPanel(pdfC301yDef, false, false, false, false, false);
		yetaPdfC301yGridPanel.setHeaderVisible(false);
		yetaPdfC301yGridPanel.setBodyBorder(false);
		yetaPdfC301yGridPanel.setBorders(true);
		//		yetaPdfC301yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC301yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfC301yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//학자금상환 그리드선언
	private LayoutContainer Yeta_PDF_C401Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfC401yGridPanel = new MSFGridPanel(pdfC401yDef, false, false, false, false, false);
		yetaPdfC401yGridPanel.setHeaderVisible(false);
		yetaPdfC401yGridPanel.setBodyBorder(false);
		yetaPdfC401yGridPanel.setBorders(true);
		//		yetaPdfC401yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfC401yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfC401yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//개인연금저축 그리드선언
	private LayoutContainer Yeta_PDF_D101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfD101yGridPanel = new MSFGridPanel(pdfD101yDef, false, false, false, false, false);
		yetaPdfD101yGridPanel.setHeaderVisible(false);
		yetaPdfD101yGridPanel.setBodyBorder(false);
		yetaPdfD101yGridPanel.setBorders(true);
		//		yetaPdfD101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfD101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfD101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//연금저축 그리드선언
	private LayoutContainer Yeta_PDF_E102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfE102yGridPanel = new MSFGridPanel(pdfE102yDef, false, false, false, false, false);
		yetaPdfE102yGridPanel.setHeaderVisible(false);
		yetaPdfE102yGridPanel.setBodyBorder(false);
		yetaPdfE102yGridPanel.setBorders(true);
		//		yetaPdfE102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfE102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfE102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//퇴직연금 그리드선언
	private LayoutContainer Yeta_PDF_F102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfF102yGridPanel = new MSFGridPanel(pdfF102yDef, false, false, false, false, false);
		yetaPdfF102yGridPanel.setHeaderVisible(false);
		yetaPdfF102yGridPanel.setBodyBorder(false);
		yetaPdfF102yGridPanel.setBorders(true);
		//		yetaPdfF102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfF102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);

		cp01.add(yetaPdfF102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//신용카드 그리드선언
	private LayoutContainer Yeta_PDF_G107Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfG107yGridPanel = new MSFGridPanel(pdfG107yDef, false, false, false, false, false);
		yetaPdfG107yGridPanel.setHeaderVisible(false);
		yetaPdfG107yGridPanel.setBodyBorder(false);
		yetaPdfG107yGridPanel.setBorders(true);
		//		yetaPdfG106yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG107yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfG107yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//현금영수증 그리드선언
	private LayoutContainer Yeta_PDF_G207Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfG207yGridPanel = new MSFGridPanel(pdfG207yDef, false, false, false, false, false);
		yetaPdfG207yGridPanel.setHeaderVisible(false);
		yetaPdfG207yGridPanel.setBodyBorder(false);
		yetaPdfG207yGridPanel.setBorders(true);
		//		yetaPdfG206yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG207yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfG207yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//직불카드등 그리드선언
	private LayoutContainer Yeta_PDF_G307Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfG307yGridPanel = new MSFGridPanel(pdfG307yDef, false, false, false, false, false);
		yetaPdfG307yGridPanel.setHeaderVisible(false);
		yetaPdfG307yGridPanel.setBodyBorder(false);
		yetaPdfG307yGridPanel.setBorders(true);
		//		yetaPdfG306yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG307yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfG307yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	// 제로페이 그리드선언
	
	private LayoutContainer Yeta_PDF_G407Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfG407yGridPanel = new MSFGridPanel(pdfG407yDef, false, false, false, false, false);
		yetaPdfG407yGridPanel.setHeaderVisible(false);
		yetaPdfG407yGridPanel.setBodyBorder(false);
		yetaPdfG407yGridPanel.setBorders(true);
		//		yetaPdfG306yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfG407yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfG407yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	//주택임차차입금원리금상환액 그리드선언
	private LayoutContainer Yeta_PDF_J101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfJ101yGridPanel = new MSFGridPanel(pdfJ101yDef, false, false, false, false, false);
		yetaPdfJ101yGridPanel.setHeaderVisible(false);
		yetaPdfJ101yGridPanel.setBodyBorder(false);
		yetaPdfJ101yGridPanel.setBorders(true);
		//		yetaPdfJ101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfJ101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//장기주택저당차입금이자상환액 그리드선언
	private LayoutContainer Yeta_PDF_J203Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfJ203yGridPanel = new MSFGridPanel(pdfJ203yDef, false, false, false, false, false);
		yetaPdfJ203yGridPanel.setHeaderVisible(false);
		yetaPdfJ203yGridPanel.setBodyBorder(false);
		yetaPdfJ203yGridPanel.setBorders(true);
		//		yetaPdfJ203yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ203yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfJ203yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//주택마련저축 그리드선언
	private LayoutContainer Yeta_PDF_J301Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfJ301yGridPanel = new MSFGridPanel(pdfJ301yDef, false, false, false, false, false);
		yetaPdfJ301yGridPanel.setHeaderVisible(false);
		yetaPdfJ301yGridPanel.setBodyBorder(false);
		yetaPdfJ301yGridPanel.setBorders(true);
		//		yetaPdfJ301yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ301yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfJ301yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//목돈안드는전세이자상환액 그리드선언
	private LayoutContainer Yeta_PDF_J401Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfJ401yGridPanel = new MSFGridPanel(pdfJ401yDef, false, false, false, false, false);
		yetaPdfJ401yGridPanel.setHeaderVisible(false);
		yetaPdfJ401yGridPanel.setBodyBorder(false);
		yetaPdfJ401yGridPanel.setBorders(true);
		//		yetaPdfJ401yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfJ401yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfJ401yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//소기업소상공인공제부금 그리드선언
	private LayoutContainer Yeta_PDF_K101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfK101yGridPanel = new MSFGridPanel(pdfK101yDef, false, false, false, false, false);
		yetaPdfK101yGridPanel.setHeaderVisible(false);
		yetaPdfK101yGridPanel.setBodyBorder(false);
		yetaPdfK101yGridPanel.setBorders(true);	
		//		yetaPdfK101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfK101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfK101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//기부금 그리드선언
	private LayoutContainer Yeta_PDF_L102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfL102yGridPanel = new MSFGridPanel(pdfL102yDef, false, false, false, false, false);
		yetaPdfL102yGridPanel.setHeaderVisible(false);
		yetaPdfL102yGridPanel.setBodyBorder(false);
		yetaPdfL102yGridPanel.setBorders(true);
		//		yetaPdfL102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfL102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfL102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//장기집합투자증권저축 그리드선언
	private LayoutContainer Yeta_PDF_N101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfN101yGridPanel = new MSFGridPanel(pdfN101yDef, false, false, false, false, false);
		yetaPdfN101yGridPanel.setHeaderVisible(false);
		yetaPdfN101yGridPanel.setBodyBorder(false);
		yetaPdfN101yGridPanel.setBorders(true);
		//		yetaPdfN101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfN101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfN101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//건강보험료 그리드선언
	private LayoutContainer Yeta_PDF_O101Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfO101yGridPanel = new MSFGridPanel(pdfO101yDef, false, false, false, false, false);
		yetaPdfO101yGridPanel.setHeaderVisible(false);
		yetaPdfO101yGridPanel.setBodyBorder(false);
		yetaPdfO101yGridPanel.setBorders(true);
		//		yetaPdfO101yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfO101yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfO101yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//국민연금보험료 그리드선언
	private LayoutContainer Yeta_PDF_P102Y_Grid() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		//		lcTabFormLayer.setStyleAttribute("paddingTop", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 250);

		yetaPdfP102yGridPanel = new MSFGridPanel(pdfP102yDef, false, false, false, false, false);
		yetaPdfP102yGridPanel.setHeaderVisible(false);
		yetaPdfP102yGridPanel.setBodyBorder(false);
		yetaPdfP102yGridPanel.setBorders(true);
		//		yetaPdfP102yGridPanel.getBottomComponent().setVisible(false);

		final Grid<BaseModel> grid = yetaPdfP102yGridPanel.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid.addPlugin(check);
		
		cp01.add(yetaPdfP102yGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	//보장성보험 DTO 세팅
	public List<PdfA102yDTO> A102UpdateSetDto(){

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

		return listPdfA102yDto;
	}

	//의료비 DTO 세팅
	public List<PdfB101yDTO> B101UpdateSetDto(){

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

		return listPdfB101yDto;
	}

	//교육비 DTO 세팅
	public List<PdfC101yDTO> C101UpdateSetDto(){

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
		return listPdfC101yDto;
	}

	//직업훈련비 DTO 세팅
	public List<PdfC202yDTO> C202UpdateSetDto(){

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

		return listPdfC202yDto;
	}

	//교복구입비 DTO 세팅
	public List<PdfC301yDTO> C301UpdateSetDto(){

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

		return listPdfC301yDto;
	}

	//학자금상환 DTO 세팅
	public List<PdfC401yDTO> C401UpdateSetDto(){

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

		return listPdfC401yDto;
	}

	//개인연금저축 DTO 세팅
	public List<PdfD101yDTO> D101UpdateSetDto(){

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

		return listPdfD101yDto;
	}

	//연금저축 DTO 세팅
	public List<PdfE102yDTO> E102UpdateSetDto(){

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

		return listPdfE102yDto;
	}

	//퇴직연금 DTO 세팅
	public List<PdfF102yDTO> F102UpdateSetDto(){

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

		return listPdfF102yDto;
	}

	//신용카드 DTO 세팅
	public List<PdfG107yDTO> G107UpdateSetDto(){

		PdfG107yDTO pdfG107yDto = new PdfG107yDTO();
		List<PdfG107yDTO> listPdfG107yDto = new ArrayList<PdfG107yDTO>();

		Iterator<BaseModel> itBm = yetaPdfG107yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
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
				pdfG107yDto = new PdfG107yDTO();

				pdfG107yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
				pdfG107yDto.setCardSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("cardSeilNum"))));
				pdfG107yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
				pdfG107yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

				pdfG107yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
				pdfG107yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

				listPdfG107yDto.add(pdfG107yDto);
			}
		}

		return listPdfG107yDto;
	}

	//현금영수증 DTO 세팅
	public List<PdfG207yDTO> G207UpdateSetDto(){

		PdfG207yDTO pdfG207yDto = new PdfG207yDTO();
		List<PdfG207yDTO> listPdfG207yDto = new ArrayList<PdfG207yDTO>();

		Iterator<BaseModel> itBm = yetaPdfG207yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
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
				pdfG207yDto = new PdfG207yDTO();

				pdfG207yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
				pdfG207yDto.setCashCardSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("cashCardSeilNum"))));
				pdfG207yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
				pdfG207yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

				pdfG207yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
				pdfG207yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

				listPdfG207yDto.add(pdfG207yDto);
			}
		}

		return listPdfG207yDto;
	}

	//직불카드등 DTO 세팅
	public List<PdfG307yDTO> G307UpdateSetDto(){

		PdfG307yDTO pdfG307yDto = new PdfG307yDTO();
		List<PdfG307yDTO> listPdfG307yDto = new ArrayList<PdfG307yDTO>();

		Iterator<BaseModel> itBm = yetaPdfG307yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
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
				pdfG307yDto = new PdfG307yDTO();

				pdfG307yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
				pdfG307yDto.setDirCardSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("dirCardSeilNum"))));
				pdfG307yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
				pdfG307yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

				pdfG307yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
				pdfG307yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

				listPdfG307yDto.add(pdfG307yDto);
			}
		}

		return listPdfG307yDto;
	}


	//제로페이  DTO 세팅
	public List<PdfG407yDTO> G407UpdateSetDto(){

		PdfG407yDTO pdfG407yDto = new PdfG407yDTO();
		List<PdfG407yDTO> listPdfG407yDto = new ArrayList<PdfG407yDTO>();

		Iterator<BaseModel> itBm = yetaPdfG407yGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
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
				pdfG407yDto = new PdfG407yDTO();

				pdfG407yDto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
				pdfG407yDto.setZeroSeilNum(MSFSharedUtils.convertStringToLong(String.valueOf(bmMapModel.get("zeroSeilNum"))));
				pdfG407yDto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));
				pdfG407yDto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));

				pdfG407yDto.setPdfDatAppYn(MSFSharedUtils.allowNulls(bmMapModel.get("select")));
				pdfG407yDto.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pdfDatAppExcCtnt")));

				listPdfG407yDto.add(pdfG407yDto);
			}
		}

		return listPdfG407yDto;
	}

	//주택임차차입금원리금상환액 DTO 세팅
	public List<PdfJ101yDTO> J101UpdateSetDto(){

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

		return listPdfJ101yDto;
	}

	//장기주택저당차입금이자상환액 DTO 세팅
	public List<PdfJ203yDTO> J203UpdateSetDto(){

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

		return listPdfJ203yDto;
	}

	//주택마련저축 DTO 세팅
	public List<PdfJ301yDTO> J301UpdateSetDto(){

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

		return listPdfJ301yDto;
	}

	//목돈안드는전세이자상환액 DTO 세팅
	public List<PdfJ401yDTO> J401UpdateSetDto(){

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

		return listPdfJ401yDto;
	}

	//소기업소상공인공제부금 DTO 세팅
	public List<PdfK101yDTO> K101UpdateSetDto(){

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

		return listPdfK101yDto;
	}

	//기부금 DTO 세팅
	public List<PdfL102yDTO> L102UpdateSetDto(){

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

		return listPdfL102yDto;
	}

	//장기집합투자증권저축 DTO 세팅
	public List<PdfN101yDTO> N101UpdateSetDto(){

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

		return listPdfN101yDto;
	}

	//건강보험료 DTO 세팅
	public List<PdfO101yDTO> O101UpdateSetDto(){

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

		return listPdfO101yDto;
	}

	//국민연금보험료 DTO 세팅
	public List<PdfP102yDTO> P102UpdateSetDto(){

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

		return listPdfP102yDto;
	}
	
	public void UpdateA102(List<PdfA102yDTO> listPdfA102yDto) {
		yetaP620001Service.updateYetaP620001ToPdfA102Y(listPdfA102yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfB101yDTO> listPdfB101yDto = B101UpdateSetDto();
//				UpdateB101(listPdfB101yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateB101(List<PdfB101yDTO> listPdfB101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfB101Y(listPdfB101yDto, actionDatabase, new AsyncCallback<Integer>() {

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfC101yDTO> listPdfC101yDto = C101UpdateSetDto();
//				UpdateC101(listPdfC101yDto);
			}
	
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}

	public void UpdateC101(List<PdfC101yDTO> listPdfC101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfC101Y(listPdfC101yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfC202yDTO> listPdfC202yDto = C202UpdateSetDto();
//				UpdateC202(listPdfC202yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateC202(List<PdfC202yDTO> listPdfC202yDto) {
		yetaP620001Service.updateYetaP620001ToPdfC202Y(listPdfC202yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfC301yDTO> listPdfC301yDto = C301UpdateSetDto();
//				UpdateC301(listPdfC301yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateC301(List<PdfC301yDTO> listPdfC301yDto) {
		yetaP620001Service.updateYetaP620001ToPdfC301Y(listPdfC301yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfC401yDTO> listPdfC401yDto = C401UpdateSetDto();
//				UpdateC401(listPdfC401yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateC401(List<PdfC401yDTO> listPdfC401yDto) {
		yetaP620001Service.updateYetaP620001ToPdfC401Y(listPdfC401yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfD101yDTO> listPdfD101yDto = D101UpdateSetDto();
//				UpdateD101(listPdfD101yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateD101(List<PdfD101yDTO> listPdfD101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfD101Y(listPdfD101yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfE102yDTO> listPdfE102yDto = E102UpdateSetDto();
//				UpdateE102(listPdfE102yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateE102(List<PdfE102yDTO> listPdfE102yDto) {
		yetaP620001Service.updateYetaP620001ToPdfE102Y(listPdfE102yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfF102yDTO> listPdfF102yDto = F102UpdateSetDto();
//				UpdateF102(listPdfF102yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateF102(List<PdfF102yDTO> listPdfF102yDto) {
		yetaP620001Service.updateYetaP620001ToPdfF102Y(listPdfF102yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfG106yDTO> listPdfG106yDto = G106UpdateSetDto();
//				UpdateG106(listPdfG106yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateG107(List<PdfG107yDTO> listPdfG107yDto) {
		yetaP620001Service.updateYetaP620001ToPdfG107Y(listPdfG107yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfG206yDTO> listPdfG206yDto = G206UpdateSetDto();
//				UpdateG206(listPdfG206yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateG207(List<PdfG207yDTO> listPdfG207yDto) {
		yetaP620001Service.updateYetaP620001ToPdfG207Y(listPdfG207yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfG306yDTO> listPdfG306yDto = G306UpdateSetDto();
//				UpdateG306(listPdfG306yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateG307(List<PdfG307yDTO> listPdfG307yDto) {
		yetaP620001Service.updateYetaP620001ToPdfG307Y(listPdfG307yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfJ101yDTO> listPdfJ101yDto = J101UpdateSetDto();
//				UpdateJ101(listPdfJ101yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	/** 제로페이 **/
	public void UpdateG407(List<PdfG407yDTO> listPdfG407yDto) {
		yetaP620001Service.updateYetaP620001ToPdfG407Y(listPdfG407yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfJ101yDTO> listPdfJ101yDto = J101UpdateSetDto();
//				UpdateJ101(listPdfJ101yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateJ101(List<PdfJ101yDTO> listPdfJ101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfJ101Y(listPdfJ101yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfJ203yDTO> listPdfJ203yDto = J203UpdateSetDto();
//				UpdateJ203(listPdfJ203yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateJ203(List<PdfJ203yDTO> listPdfJ203yDto) {
		yetaP620001Service.updateYetaP620001ToPdfJ203Y(listPdfJ203yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfJ301yDTO> listPdfJ301yDto = J301UpdateSetDto();
//				UpdateJ301(listPdfJ301yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateJ301(List<PdfJ301yDTO> listPdfJ301yDto) {
		yetaP620001Service.updateYetaP620001ToPdfJ301Y(listPdfJ301yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfJ401yDTO> listPdfJ401yDto = J401UpdateSetDto();
//				UpdateJ401(listPdfJ401yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateJ401(List<PdfJ401yDTO> listPdfJ401yDto) {
		yetaP620001Service.updateYetaP620001ToPdfJ401Y(listPdfJ401yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfK101yDTO> listPdfK101yDto = K101UpdateSetDto();
//				UpdateK101(listPdfK101yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateK101(List<PdfK101yDTO> listPdfK101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfK101Y(listPdfK101yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfL102yDTO> listPdfL102yDto = L102UpdateSetDto();
//				UpdateL102(listPdfL102yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateL102(List<PdfL102yDTO> listPdfL102yDto) {
		yetaP620001Service.updateYetaP620001ToPdfL102Y(listPdfL102yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfL102yDTO> listPdfL102yDto = L102UpdateSetDto();
//				UpdateL102(listPdfL102yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateN101(List<PdfN101yDTO> listPdfN101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfN101Y(listPdfN101yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfO101yDTO> listPdfO101yDto = O101UpdateSetDto();
//				UpdateO101(listPdfO101yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateO101(List<PdfO101yDTO> listPdfO101yDto) {
		yetaP620001Service.updateYetaP620001ToPdfO101Y(listPdfO101yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
//				List<PdfP102yDTO> listPdfP102yDto = P102UpdateSetDto();
//				UpdateP102(listPdfP102yDto);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 생성에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
	}
	
	public void UpdateP102(List<PdfP102yDTO> listPdfP102yDto) {
		yetaP620001Service.updateYetaP620001ToPdfP102Y(listPdfP102yDto, actionDatabase, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				MessageBox.info("생성완료", "소득공제가 반영되었습니다.", null);
				reload();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
						"소득공제 반영에 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
			}
		});			
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

		yetaPdfG107yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG107yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG107yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG107yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG107yGridPanel.reload();  

		yetaPdfG207yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG207yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG207yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG207yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG207yGridPanel.reload();  

		yetaPdfG307yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG307yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG307yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG307yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG307yGridPanel.reload();  

		/** 제로페이 **/
		yetaPdfG407yGridPanel.getTableDef().setTableColumnFilters(filters);
		yetaPdfG407yGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG407yGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG407yGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaPdfG407yGridPanel.reload();  

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
