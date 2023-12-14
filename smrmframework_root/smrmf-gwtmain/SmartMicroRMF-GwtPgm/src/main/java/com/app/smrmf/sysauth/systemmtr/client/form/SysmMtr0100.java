/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysauth.systemmtr.client.form;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0050DTO;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0051DTO;
import com.app.smrmf.sysauth.systemmtr.client.form.defs.SysMtrSysm0050Def;
import com.app.smrmf.sysauth.systemmtr.client.form.defs.SysMtrSysm0051Def;
import com.app.smrmf.sysauth.systemmtr.client.languages.SysmMtrConstants;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0100Service;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0100ServiceAsync;
import com.app.smrmf.sysauth.systemmtr.client.utils.SysmMtrUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : SysmMtr0100.java
 * @Description : 사업장관리
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 **/

/**
 * =========================================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends
 * LayoutContainer implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리
 * 해야함. MSFPanel
 * =========================================================================
 **/
public class SysmMtr0100 extends MSFPanel {
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topSysmMtr0100Bar;
	private Button btnSysmMtr0100New;
	private Button btnSysmMtr0100Save;
	private Button btnSysmMtr0100Del;
	private Button btnSysmMtr0100Sreach;
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 시작 -------------- 
	private TextField<String> srhSysDpobNm;	// 사업장명
	private CheckBox srhSysDpobUseYn; 		// 사용여부
	// -------------- 검색조건 종료 -------------- 

 
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	// -------------- 상세정보 시작--------------  
	private MSFTextField sysDpobCd;   				/** column 시스템사업장코드 : sysDpobCd */
	private MSFTextField sysDpobNm;   				/** column 시스템사업장명 : sysDpobNm */
	
	private MSFTextField sysDpobKey;   				/** set 시스템사업장KEY : sysDpobKey */
	
	private MSFTextField useSysDivCd;   	        /** column 사용시스템구분코드 : useSysDivCd */	
	private MSFDateField sysDpobBgnDt;   			/** column 시스템사업장개시일자 : sysDpobBgnDt */
 
    private MSFDateField sysDpobEdDt;               /** set 시스템사업장종료일자 : sysDpobEdDt */
  
    private MSFTextField sysDpobCtnt;           /** set 시스템사업장내용 : sysDpobCtnt */
   
	private CheckBox sysDpobUseYn;   				/** column 시스템사업장사용여부 : sysDpobUseYn */

	//지급년도 
//	private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
//	private MSFGridPanel payYrGridPanel;
	
	
	// -------------- 상세정보 종료--------------
	

	// -------------- Store 시작 --------------
	 
 
	// -------------- Store 종료 --------------

	
	// -------------- 서비스 호출 시작 -------------- 
	private SysmMtr0100ServiceAsync sysmMtr0100Service = SysmMtr0100Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 
	
	
	// -------------- grid 시작 -------------- 
	private SysMtrSysm0050Def   sysMtrSysm0050Def = new SysMtrSysm0050Def(); // 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel01;
	 
	// -------------- grid 끝 --------------  

	// -------------- 상태처리 전역변수  -------------- 
	private ActionDatabase actionDatabase; 
	// -------------- 상태처리 전역변수  -------------- 
	
	// -------------- DTO 선언 시작  -------------- 
	private SysIfBass0300DTO sysComBass0300Dto;
	private SysMtrSysm0050DTO sysMtrSysm0050Dto;  
	
	// -------------- DTO 선언 종료  -------------- 

	private SysmMtrConstants lblSysmMtrConstantst = SysmMtrConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmSysmMtr0100;

	private String txtForm = "";
	private XTemplate detailTp;

	public FormBinding formBinding;
	public FormBinding srhFormBinding;


    private BaseModel ppRecord; //팝업에 넘길 레코드 값 
	private BaseModel record;
	private Iterator<Record> records;
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
//	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
//		public void componentSelected(ButtonEvent ce) {
//			if (ActionDatabase.INSERT.equals(actionDatabase)) {
//				actionDatabase = null;
//				if (ce.getButton() == btnSysmMtr0100Save) {
//					doAction(ActionDatabase.INSERT);
//				}
//			} else if (ce.getButton() == btnSysmMtr0100Save) {
//				doAction(ActionDatabase.UPDATE);
//				actionDatabase = null;
//			} else if (ce.getButton() == btnSysmMtr0100Del) {
//				doAction(ActionDatabase.DELETE);
//			}
//		}
//	};

	private void doAction(ActionDatabase actionDatabase) {
		
		save(actionDatabase);

	}

	//저장
	public void save(final ActionDatabase actionDatabase) {
		// final InfcSysmMtr0100DTO dto = new InfcSysmMtr0100DTO();
		
		sysMtrSysm0050Dto = new SysMtrSysm0050DTO();
		
		 
		sysMtrSysm0050Dto.setSysDpobCd(sysDpobCd.getValue());    /** column 시스템사업장코드 : sysDpobCd */
		sysMtrSysm0050Dto.setSysDpobNm(sysDpobNm.getValue());    /** column 시스템사업장명 : sysDpobNm */
		sysMtrSysm0050Dto.setSysDpobKey(sysDpobKey.getValue());    /** column 시스템사업장KEY : sysDpobKey */
		sysMtrSysm0050Dto.setUseSysDivCd(useSysDivCd.getValue());   								/** column 사용시스템구분코드 : useSysDivCd */
		sysMtrSysm0050Dto.setSysDpobUseYn(sysDpobUseYn.getValue() ? "Y" : "N");   	
		sysMtrSysm0050Dto.setSysDpobBgnDt(MSFSharedUtils.getConvertDateToString(sysDpobBgnDt, "yyyyMMdd"));    /** column 시스템사업장개시일자 : sysDpobBgnDt */
		sysMtrSysm0050Dto.setSysDpobEdDt(MSFSharedUtils.getConvertDateToString(sysDpobEdDt, "yyyyMMdd"));    /** column 시스템사업장종료일자 : sysDpobEdDt */
		sysMtrSysm0050Dto.setSysDpobCtnt(sysDpobCtnt.getValue());    /** column 시스템사업장내용 : sysDpobCtnt */
//		sysMtrSysm0050Dto.setKybdr(kybdr.getValue());    /** column 입력자 : kybdr */
//		sysMtrSysm0050Dto.setInptDt(inptDt.getValue());    /** column 입력일자 : inptDt */
//		sysMtrSysm0050Dto.setInptAddr(inptAddr.getValue());    /** column 입력주소 : inptAddr */
//		sysMtrSysm0050Dto.setIsmt(ismt.getValue());    /** column 수정자 : ismt */
//		sysMtrSysm0050Dto.setRevnDt(revnDt.getValue());    /** column 수정일자 : revnDt */
//		sysMtrSysm0050Dto.setRevnAddr(revnAddr.getValue());    /** column 수정주소 : revnAddr */
		
		 
		
		if ("".equals(sysMtrSysm0050Dto.getSysDpobCd()) || sysMtrSysm0050Dto.getSysDpobCd() == null) {
			MessageBox.info("", "시스템사업장코드는 필수 입니다.", null);
			sysDpobCd.focus();
			return;
		} else if ("".equals(sysMtrSysm0050Dto.getSysDpobNm()) || sysMtrSysm0050Dto.getSysDpobNm() == null) {
			MessageBox.info("", "시스템사업장명은 필수 입니다.", null);
			sysDpobNm.focus();
			return;
		 
		}
		MessageBox.confirm("", "DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?": "저장 하시겠습니까?", new Listener<MessageBoxEvent>() {
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					
					// 0 : 실패  1: 정상  3: 중복된 데이터 있음  13: 삭제할 수 없음(bass0100에 존재)
					sysmMtr0100Service.saveSysMtr0050(sysMtrSysm0050Dto, actionDatabase, new AsyncCallback<Integer>() {
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							MessageBox.info("경고", "DELETE".equals(actionDatabase.name()) ? "삭제에 실패하였습니다. </br> 데이터를 확인해 주세요." + caught : "저장에 실패하였습니다.</br> 데이터를 확인해 주세요." + caught, null);
						}
						
						@Override
						public void onSuccess(Integer result) {
							
							// TODO Auto-generated method stub
							if(result == 1 ) {
								MessageBox.info("알림", "DELETE".equals(actionDatabase.name()) ? "삭제 되었습니다.": "저장 되었습니다.", null);
								reloadSysm0050();

								
							}else if(result == 13 ){
								
								MessageBox.info("경고", "해당 데이터는 삭제할 수 없습니다.", null);
							
							}else if(result == 3 ){
								
								MessageBox.info("경고", "DELETE".equals(actionDatabase.name()) ? "삭제에 실패하였습니다. </br> 데이터를 확인해 주세요.": "저장에 실패하였습니다.</br> 중복된 데이터가 없는지 데이터를 확인해 주세요.", null);
							
							}else if(result == 0 ){
								
								MessageBox.info("경고", "DELETE".equals(actionDatabase.name()) ? "삭제에 실패하였습니다. </br> 데이터를 확인해 주세요.": "저장에 실패하였습니다.</br> 데이터를 확인해 주세요.", null);
							
							}
						}
					});
				}
			}
		});
	}
  

	public ContentPanel getViewPanel() {
		
	
 		if (panel == null) { 
 
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createSysmMtr0100Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
			createListGrid(); 			// 사업장정보 그리드
			createStandardForm(); 		// 사업장 상세 정보
//			createStdSubFrom(); 		// 사업장 관리번호
			vp.setSize("1010px", "700px");
			/**
			 * -------------------------------------------------------------------
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 시작
			 * -------------------------------------------------------------------
			 */
			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmSysmMtr0100, true);

			// setSysmMtr0100FormBinding(); //폼바인딩처리 - 입력필드
			// bindMsfComBass0400(formBinding.getModel()); //부서코드
			// bindMsfComBass0500(formBinding.getModel()); //사업코드
			// bindMsfComBass0300(formBinding.getModel(),"A003"); //재직상태구분코드
			/**
			 * -------------------------------------------------------------------
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 종료
			 * -------------------------------------------------------------------
			 */
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
	 * #############################################################################
	 * 프로그램 종료
	 * #############################################################################
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 생성자 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * @wbp.parser.constructor
	 */
	public SysmMtr0100() {
		setSize("1010px", "700px");
	}

	// 생성자 함수에 변수을 받아 처리
	public SysmMtr0100(String txtForm) {
		this.txtForm = txtForm;
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSysmMtr0100Form() {

		plFrmSysmMtr0100 = new FormPanel();
		plFrmSysmMtr0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 시스템사업장관리"));
		plFrmSysmMtr0100.setIcon(MSFMainApp.ICONS.text());
		plFrmSysmMtr0100.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 lblSysmMtrConstantst.title_SysmMtr0100()
				  funcLogMessage("시스템사업장관리","SysmMtr0100");
				}
			});
		plFrmSysmMtr0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmSysmMtr0100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmSysmMtr0100.setPadding(2);
		plFrmSysmMtr0100.setFrame(true);
		plFrmSysmMtr0100.setLayout(new FormLayout());

		topSysmMtr0100Bar = new ButtonBar();
		topSysmMtr0100Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnSysmMtr0100New = new Button("신규");
		btnSysmMtr0100New.setIcon(MSFMainApp.ICONS.new16());
		topSysmMtr0100Bar.add(btnSysmMtr0100New);
		btnSysmMtr0100New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				// 상세정보 초기화
				formSysmMtr0100Init();
				
				sysDpobCd.setReadOnly(false);	
				 
				actionDatabase = ActionDatabase.INSERT;
				
			}
	});

		btnSysmMtr0100Save = new Button("저장");
		btnSysmMtr0100Save.setIcon(MSFMainApp.ICONS.save16());
//		btnSysmMtr0100Save.addSelectionListener(selectionListener);
		btnSysmMtr0100Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(ActionDatabase.INSERT.equals(actionDatabase)) {
					doAction(actionDatabase);
					
				}else {
					actionDatabase = ActionDatabase.UPDATE;
					doAction(actionDatabase);
				}
			}
		});
		topSysmMtr0100Bar.add(btnSysmMtr0100Save);

		btnSysmMtr0100Del = new Button("삭제");
		btnSysmMtr0100Del.setIcon(MSFMainApp.ICONS.delete16()); 
		btnSysmMtr0100Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				doAction(ActionDatabase.DELETE);
			}
		});
		topSysmMtr0100Bar.add(btnSysmMtr0100Del);
		
		

		btnSysmMtr0100Sreach = new Button("조회");
		btnSysmMtr0100Sreach.setIcon(MSFMainApp.ICONS.search16());
		topSysmMtr0100Bar.add(btnSysmMtr0100Sreach);
		btnSysmMtr0100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reloadSysm0050();
				
				sysDpobCd.setReadOnly(false);
			}
		});

		plFrmSysmMtr0100.add(topSysmMtr0100Bar);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmSysmMtr0100.setAction("myurl"); // url 정보 추가 할것.
		plFrmSysmMtr0100.setEncoding(Encoding.MULTIPART);
		plFrmSysmMtr0100.setMethod(Method.POST);

		vp.add(plFrmSysmMtr0100);
		plFrmSysmMtr0100.setSize("990px", "680px");
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {

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
		lcSchLeft.setStyleAttribute("paddingRight", "100px");
		FormLayout frmlytSchLeft = new FormLayout();
		frmlytSchLeft.setLabelWidth(120);
		frmlytSchLeft.setLabelAlign(LabelAlign.RIGHT);
		frmlytSchLeft.setDefaultWidth(100);
		lcSchLeft.setLayout(frmlytSchLeft);

		srhSysDpobNm = new TextField<String>();
		srhSysDpobNm.setName("srhSysDpobNm");
		srhSysDpobNm.setFieldLabel("사업장명");
		// srhDpobNm.setAllowBlank(false);
		lcSchLeft.add(srhSysDpobNm, new FormData("90%"));
		
		
		
		LayoutContainer lcSchRight = new LayoutContainer(new ColumnLayout());
		
		lcSchRight.setStyleAttribute("paddingRight", "100px");
//		FormLayout frmlytSchRight = new FormLayout();
//		frmlytSchRight.setLabelWidth(85);
//		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
//		lcSchRight.setLayout(frmlytSchRight);
		
		LayoutContainer lcSchRight01 = new LayoutContainer();
		
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0);
		lcSchRight01.setLayout(frmlytStd);
		
		LabelField lbFld = new LabelField("사용 : ");
		lcSchRight01.add(lbFld);
		lcSchRight.add(lcSchRight01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		
		LayoutContainer lcSchRight02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(10); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight02.setLayout(frmlytStd);

		srhSysDpobUseYn = new CheckBox();
		srhSysDpobUseYn.setName("srhSysDpobUseYn");
		srhSysDpobUseYn.setHideLabel(true);
		srhSysDpobUseYn.setValueAttribute("Y");
		srhSysDpobUseYn.setValue(true);
		lcSchRight02.add(srhSysDpobUseYn, new FormData("90%"));
		lcSchRight.add(lcSchRight02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fieldSet.add(lcSchCol, new FormData("90%"));

		plFrmSysmMtr0100.add(fieldSet);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private void createStandardForm() {
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer01 = new LayoutContainer();
//		layoutContainer01.setStyleAttribute("paddingLeft", "10px");
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer01.setLayout(frmlytStd);
		
		LayoutContainer gridLayoutContainer01 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		gridLayoutContainer01.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset1 = new FieldSet();
		fldstNewFieldset1.setHeadingHtml("기본정보");
		fldstNewFieldset1.setSize("470px", "255px");
		fldstNewFieldset1.add(createLeftForm(), new FormData("100%"));
		layoutContainer01.add(fldstNewFieldset1);
		
		layoutContainer.add(layoutContainer01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		
//		LayoutContainer layoutContainer02 = new LayoutContainer();
//		layoutContainer02.setStyleAttribute("paddingRight", "10px");
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(0); 
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer02.setLayout(frmlytStd);
//		
//		FieldSet fldstNewFieldset2 = new FieldSet();
//		fldstNewFieldset2.setHeadingHtml("과세유형");
//		fldstNewFieldset2.setSize("480px", "255px");
//		fldstNewFieldset2.add(createRightForm(), new FormData("100%"));
//		layoutContainer02.add(fldstNewFieldset2);
//		
//		layoutContainer.add(layoutContainer02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		plFrmSysmMtr0100.add(layoutContainer);
		
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	private LayoutContainer createLeftForm() {	
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		 
		
		LayoutContainer lc02 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc0201 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0201.setLayout(frmlytStd);
		
		sysDpobCd = new MSFTextField();
		sysDpobCd.setName("sysDpobCd");
//		sysMnthFndtnDutyNumDys.setMaxLength(14);
		// DPOB_CD.getMessages().setMaxLengthText("한글7자 영어숫자 14자");
		sysDpobCd.setFieldLabel("시스템코드");
		//dpobCd.setReadOnly(false);
		lc0201.add(sysDpobCd, new FormData("100%"));
		lc02.add(lc0201, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));		
		
		
		LayoutContainer lc0202 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0202.setLayout(frmlytStd);	
		
		sysDpobNm = new MSFTextField();
		sysDpobNm.setName("sysDpobNm");
//		sysMnthFndtnDutyNumDys.setMaxLength(14);
		// DPOB_CD.getMessages().setMaxLengthText("한글7자 영어숫자 14자");
		sysDpobNm.setFieldLabel("시스템명");
		//dpobCd.setReadOnly(false);
		lc0202.add(sysDpobNm, new FormData("100%"));
		
		lc02.add(lc0202, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		
		
		LayoutContainer lc03 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc0301 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0301.setLayout(frmlytStd);
		
		sysDpobBgnDt = new MSFDateField();
		new DateFieldMask(sysDpobBgnDt, "9999.99.99"); 
		sysDpobBgnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		sysDpobBgnDt.setFieldLabel("개시일자");
		lc0301.add(sysDpobBgnDt);
		
		lc03.add(lc0301, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));		
		
		
		LayoutContainer lc0302 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0302.setLayout(frmlytStd);	
		
		sysDpobEdDt = new MSFDateField();
		new DateFieldMask(sysDpobEdDt, "9999.99.99"); 
		sysDpobEdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		sysDpobEdDt.setFieldLabel("종료일자");
		lc0302.add(sysDpobEdDt);
		
		lc03.add(lc0302, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		
		
		LayoutContainer lc04 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc0401 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0401.setLayout(frmlytStd);
		
		useSysDivCd = new MSFTextField();
		useSysDivCd.setName("useSysDivCd");
		useSysDivCd.setFieldLabel("시스템구분"); 
		useSysDivCd.setEmptyText("--시스템구분--");
		useSysDivCd.setSelectOnFocus(true); 
		lc0401.add(useSysDivCd, new FormData("100%"));
		
		lc04.add(lc0401, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));		
		
		
		LayoutContainer lc0402 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0402.setLayout(frmlytStd);	
		
		sysDpobUseYn = new CheckBox();
		sysDpobUseYn.setName("sysDpobUseYn");
		sysDpobUseYn.setBoxLabel("사용여부");
		sysDpobUseYn.setHideLabel(false);
		sysDpobUseYn.setLabelSeparator("");
		sysDpobUseYn.setValue(false);
		lc0402.add(sysDpobUseYn, new FormData("100%"));
		
		lc04.add(lc0402, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		 
		 
		
		LayoutContainer lc07 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc0701 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc0701.setLayout(frmlytStd);
		
		
		sysDpobCtnt = new MSFTextField();
		sysDpobCtnt.setName("sysDpobCtnt");
 
		sysDpobCtnt.setFieldLabel("내 용");
		//dpobCd.setReadOnly(false);
		lc0701.add(sysDpobCtnt, new FormData("100%"));
		
		lc07.add(lc0701, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));		
		
		
//		LayoutContainer lc0702 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();
//		frmlytStd.setLabelWidth(100);
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		lc0702.setLayout(frmlytStd);
//		
//		lc07.add(lc0702, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		  
		lcTabFormLayer.add(lc02);
		lcTabFormLayer.add(lc03);
		lcTabFormLayer.add(lc04);  
		lcTabFormLayer.add(lc07); 
		
		return lcTabFormLayer;
	}
	
	
	 
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createListGrid() {

		FieldSet FieldSetGrid = new FieldSet();
		FieldSetGrid.setHeadingHtml("시스템사업장정보");

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(950, 280);

		msfGridPanel01 = new MSFGridPanel(sysMtrSysm0050Def, false, false, false, false, false);
		msfGridPanel01.setHeaderVisible(false);
		msfGridPanel01.setBodyBorder(true);
		msfGridPanel01.setBorders(true);
		 
		//그리드 선택시
		final Grid<BaseModel> grid = msfGridPanel01.getMsfGrid().getGrid();
		grid.addListener(Events.RowDoubleClick, new Listener<GridEvent<BaseModel>>() {
			@Override
			public void handleEvent(GridEvent<BaseModel> be) {
				
				actionDatabase = ActionDatabase.UPDATE; 
				
				formSysmMtr0100Init();
				
        		//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
				leftSysmMtr0100Detail(msfGridPanel01.getCurrentlySelectedItem());
				 
			}
		});

	 
		cpGrid.add(msfGridPanel01);
		lcStdGrid.add(cpGrid);
		FieldSetGrid.add(lcStdGrid);

		plFrmSysmMtr0100.add(FieldSetGrid);

	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// 고용구분
	private void fnPopupBass0300(final String itemValue) {
//		MSFFormPanel popCom0130 = SysComPopupUtils.lovPopUpMsfCom0130Form(itemValue);  //공통  
//	       
//		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
//	      
//		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
//			public void handleEvent(BaseEvent be) {
//				@SuppressWarnings("unchecked")
////				List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
//				BaseModel mapModel = (BaseModel)be.getSource();
//				if (!"".equals(mapModel.get("commCd"))) { 
//					if ("A042".equals(itemValue)) {
//						
//						 
//						 if (mapModel != null) { 
//							
//							
//							 BaseModel bmData = msfGridPanel02.getMsfGrid().getTableDef().getDefaultValues(); 
//		                    
//							 bmData.set("emymtDivCd",MSFSharedUtils.allowNulls(mapModel.get("commCd")));   			/** column 고용구분코드 : emymtDivCd */
//							 bmData.set("emymtDivNm",MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));   		/** column 고용구분코드 : emymtDivCd */
//							 bmData.set("sysDpobCd", "");   														/** column 시스템사업장코드 : sysDpobCd */
//	//	                        bmData.set("emymtDivCd",MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));   			/** column 고용구분코드 : emymtDivCd */
//							 bmData.set("txtnFrmDivCd$commCd",MSFSharedUtils.allowNulls(""));    					/** column 과세유형구분코드 : txtnFrmDivCd */
//							 bmData.set("txtnFrmDivCd$commCdNm",MSFSharedUtils.allowNulls(""));  					/** column 과세유형구분코드 : txtnFrmDivCd */                
//							 bmData.set("txtnFrmBgnnDt",GWTUtils.getDateFromString("", "yyyyMMdd")); 				/** column 과세유형시작일자 : txtnFrmBgnnDt */
//							 bmData.set("txtnFrmEndDt",GWTUtils.getDateFromString("", "yyyyMMdd"));  				/** column 과세유형종료일자 : txtnFrmEndDt */
//							 bmData.set("txtnFrmCtnt",MSFSharedUtils.allowNulls(""));   							/** column 과세유형내용 : txtnFrmCtnt */
//		                        
//		                    
//							 msfGridPanel02.getMsfGrid().getGrid().stopEditing();      
//							 msfGridPanel02.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//							 msfGridPanel02.getMsfGrid().getGrid().startEditing(msfGridPanel02.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
//							 msfGridPanel02.setSize(460, 230);
//							 
//						 }
//					} 
//				}   
//			}
//		});
	}	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private void leftSysmMtr0100Detail(BaseModel selRecord) { 
	   
		
		sysDpobCd.setValue((String)selRecord.get("sysDpobCd"));   													/** column 시스템사업장코드 : sysDpobCd */
		sysDpobCd.setReadOnly(true);
		sysDpobNm.setValue((String)selRecord.get("sysDpobNm"));   													/** column 시스템사업장명 : sysDpobNm */
		sysDpobKey.setValue((String)selRecord.get("sysDpobKey"));  													/** column 시스템사업장KEY : sysDpobKey */
		useSysDivCd.setValue((String)selRecord.get("useSysDivCd"));           		                                /** column 사용시스템구분코드 : useSysDivCd */ 
		sysDpobBgnDt.setValue((Date)selRecord.get("sysDpobBgnDt"));													/** column 시스템개시일자 : sysDpobBgnDt */
		sysDpobBgnDt.setValue((Date)selRecord.get("sysDpobEdDt"));													/** set 시스템사업장종료일자 : sysDpobEdDt */
	 
		sysDpobUseYn.setValue((Boolean)selRecord.get("sysDpobUseYn"));   											/** column 시스템사업장사용여부 : sysDpobUseYn */
		sysDpobCtnt.setValue((String)selRecord.get("sysDpobCtnt"));  		 /** set 시스템사업장내용 : sysDpobCtnt */
	 
		  
	}

	public void reloadSysm0050() {
		IColumnFilter filters = null;
		
		msfGridPanel01.getTableDef().setTableColumnFilters(filters);
		msfGridPanel01.getTableDef().addColumnFilter("sysDpobNm",srhSysDpobNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel01.getTableDef().addColumnFilter("sysDpobUseYn",srhSysDpobUseYn.getValue() ? "Y" : "N", SimpleColumnFilter.OPERATOR_ILIKE);
		
		msfGridPanel01.reload();
	}
	
	  
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private SysmMtr0100 getThis() {
		return this;
	}
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
	
	 

	private void formSysmMtr0100Init() {
		
	 
		sysDpobCd.setValue("");   						/** column 시스템사업장코드 : sysDpobCd */
		sysDpobNm.setValue("");   						/** column 시스템사업장명 : sysDpobNm */
		
		useSysDivCd.setValue("");   		/** column 사용시스템구분코드 : useSysDivCd */ 
		
		sysDpobBgnDt.setValue(null);   					/** column 시스템사업장개시일자 : sysDpobBgnDt */	  
		
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
 