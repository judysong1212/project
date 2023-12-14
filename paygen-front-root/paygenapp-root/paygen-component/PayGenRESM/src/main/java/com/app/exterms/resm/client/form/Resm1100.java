package com.app.exterms.resm.client.form;

import java.util.Date;
import java.util.HashMap;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.resm.client.dto.Bass0320DTO;
import com.app.exterms.resm.client.form.defs.Bass0320Def;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.client.service.Resm1100Service;
import com.app.exterms.resm.client.service.Resm1100ServiceAsync;
import com.app.exterms.resm.client.utils.ResmUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Bass03200.java
 * @Description : 직종세부관리
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
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Resm1100 extends MSFPanel {
	/**
	 * ########################################################################## 
	 * { 시스템 기본설정파일 선언부 시작}
	 * ##########################################################################
	 **/

	/**
	 * ########################################################################## 
	 * { 시스템 기본설정파일 선언부 종료}
	 * ##########################################################################
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	private ResmConstants lblBasisConst = ResmConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmBass0320;
	// private FormData formData;
	private String txtForm = ""; 

	private BaseModel bmData = new BaseModel();
	
	public FormBinding formBinding;
	public FormBinding srhFormBinding;

	private Bass0320Def resm1100Def = new Bass0320Def(); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;O
	private MSFGridPanel msfBass0320GridPanel;
	
	//파일업로드처리 부분  
    private FileUploadField resm1100flUp;
    private Boolean picBoolFile;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 화면 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private FieldSet fieldSetFrm;
	private FieldSet fieldSetGrd;
	private FieldSet fieldSetSrhFrm;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ButtonBar topBass0320Bar;
	private Button btnBass0320New;
	private Button btnBass0320Save;
	private Button btnBass0320Del;
	private Button btnBass0320Sreach;
	
	private Button btnBass0320Trnr;						//이관 버튼

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -- 검색 조건 시작 
		private TextField<String> srhTypOccuNm; 	//직종명
		private ListStore<BaseModel>  stTypOccuCd = new ListStore<BaseModel>();			//직종 상세
		private CheckBox srhTypOccuUseYn; 					// 직종세사용여부
		private CheckBoxGroup srhTypOccuUseGrp; 			// 체크박스그룹
	// -- 검색 조건 끝
	
		// -------------- 공통코드 선언 시작 --------------
	    private PrgmComBass0300DTO sysComBass0300Dto;
	    private PrgmComBass0320DTO sysComBass0320Dto;
	    private PrgmComBass0350DTO sysComBass0350Dto;
	    // -------------- 공통코드 선언 종료--------------

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	private HiddenField<String> dpobCd;
	private MSFTextField typOccuCd;				//직종코드
	 
	private MSFTextField typOccuNm; 			// 직종명
	private MSFTextField typOccuCtnt; 			// 직종내용
	private MSFNumberField typOccuOrd; 			// 순서
	private CheckBoxGroup typOccuUseGrp; 		// 체크박스그룹
	private CheckBox typOccuUseYn; 				// 직종세사용여부 
	private MSFComboBox<BaseModel> chngTypOccuCd; 			// 개편전직종코드 
	private MSFDateField typOccuStdt;				//직종시작일자 
	private MSFDateField typOccuEddt;				//직종종료일자 
	
	private HiddenField<String> typOccuJbfmlDivCd;   /** column 직종직군구분코드 : typOccuJbfmlDivCd */ 
	private HiddenField<String> pyspGrdeCd;   /** column null : pyspGrdeCd */
	 
	// 입력수정삭제처리 rpc 처리부
	private Resm1100ServiceAsync resm1100Service = Resm1100Service.Util.getInstance();
	 
	private BaseModel record;
	private Date today = new Date();		// 오늘 날짜 가져오는 코드
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 상태처리 전역변수
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
	private ActionDatabase actionDatabase;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
//	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
//		public void componentSelected(ButtonEvent ce) {
//			if (ActionDatabase.INSERT.equals(actionDatabase)) {
//				actionDatabase = null;
//				if (ce.getButton() == btnBass0320Save) {
//					doAction(ActionDatabase.INSERT);
//				}
//			}else if (ce.getButton() == btnBass0320Save) {
//				doAction(ActionDatabase.UPDATE);
//				actionDatabase = null;
//			}else if (ce.getButton() == btnBass0320Del) {
//				doAction(ActionDatabase.DELETE);
//			}
//		}
//	};
	
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			if (ce.getButton() == btnBass0320Save) {
				if(ActionDatabase.INSERT.equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
					doAction(ActionDatabase.INSERT);
				}else {
					actionDatabase = ActionDatabase.UPDATE;
					doAction(ActionDatabase.UPDATE);
				}
			}else if (ce.getButton() == btnBass0320Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public void save(final ActionDatabase actionDatabase){
		
		final Bass0320DTO dto = new Bass0320DTO();
		
		if(MSFSharedUtils.paramNull(typOccuNm)){
			MessageBox.info("", "직종명을 입력하여 주세요.", null);
		}else if((Long)typOccuOrd.getValue() <  0 ){
			MessageBox.info("", "잘 못 입력하셨습니다. 다시 입력해 주세요.", null);
		}else if(typOccuStdt.getValue() == null || typOccuEddt.getValue() == null ||GregorianCalendar.compareDate(typOccuStdt.getValue(), typOccuEddt.getValue()) < 0){
			MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null); 
		}else{
		//	Window.alert(""+MSFSharedUtils.allowNulls(typOccuNm.getValue()));
			dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
			dto.setTypOccuCd(MSFSharedUtils.allowNulls(typOccuCd.getValue()));    /** column 직종코드 : typOccuCd */
			dto.setTypOccuNm(MSFSharedUtils.allowNulls(typOccuNm.getValue()));    /** column 직종명 : typOccuNm */
			dto.setTypOccuUseYn(typOccuUseYn.getValue());    /** column 직종사용여부 : typOccuUseYn */
			dto.setTypOccuCtnt(MSFSharedUtils.allowNulls(typOccuCtnt.getValue()));    /** column 직종내용 : typOccuCtnt */
			dto.setTypOccuOrd((Long)typOccuOrd.getValue());    /** column 정렬순서 : typOccuOrd */
			dto.setTypOccuJbfmlDivCd(MSFSharedUtils.allowNulls(typOccuJbfmlDivCd.getValue()));    /** column 직종직군구분코드 : typOccuJbfmlDivCd */
//			dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(pyspGrdeCd.getValue()));    /** column null : pyspGrdeCd */
//			dto.setKybdr(MSFSharedUtils.allowNulls(kybdr.getValue()));    /** column 입력자 : kybdr */
//			dto.setInptDt(MSFSharedUtils.allowNulls(inptDt.getValue()));    /** column 입력일자 : inptDt */
//			dto.setInptAddr(MSFSharedUtils.allowNulls(inptAddr.getValue()));    /** column 입력주소 : inptAddr */
//			dto.setIsmt(MSFSharedUtils.allowNulls(ismt.getValue()));    /** column 수정자 : ismt */
//			dto.setRevnDt(MSFSharedUtils.allowNulls(revnDt.getValue()));    /** column 수정일자 : revnDt */
//			dto.setRevnAddr(MSFSharedUtils.allowNulls(revnAddr.getValue()));    /** column 수정주소 : revnAddr */
			
			dto.setChngTypOccuCd(ResmUtils.getSelectedComboValue(chngTypOccuCd,"typOccuCd"));	/** column 개편전 직종명 : chngTypOccuCd */
			dto.setTypOccuStdt(ResmUtils.getConvertDateToString(typOccuStdt, "yyyyMMdd"));	/** column 시작일자 : typOccuStdt */
			dto.setTypOccuEddt(ResmUtils.getConvertDateToString(typOccuEddt, "yyyyMMdd"));	/** column 종료일자 : typOccuEddt */
			
			MessageBox.confirm("","DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						resm1100Service.saveBass0320(dto, actionDatabase, new AsyncCallback<Long>() {
							@Override
							public void onSuccess(Long result) {
								if (result > 0L) {
									if("DELETE".equals(actionDatabase.name())){
										MessageBox.info("", "삭제 되었습니다.", null);
									}else{
										MessageBox.info("", "저장 되었습니다.", null);
									}
									reload();
								} else {
									if("DELETE".equals(actionDatabase.name())){
										MessageBox.info("", "삭제 처리가 정상적으로 이루어지지 않았습니다.", null);
									}else{
										MessageBox.info("", "저장 처리가 정상적으로 이루어지지 않았습니다.", null);
									}
								}	
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0320(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});						
					}
				}
			});
		 }
		
	}

	public ContentPanel getViewPanel() {
		if (panel == null) {
			
//			List<String> arrRpsttvCd = new ArrayList<String>();
//			arrRpsttvCd.add("A041");
//			arrRpsttvCd.add("A006");
//			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
//			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
//			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
//				
//				@Override
//				public void onSuccess(HashMap<String, List<BaseModel>> result) {
//					// TODO 콤보 데이터 저장하는곳
//					if(result != null && result.size() > 0){
//						listStoreA041.add(result.get("A041")); 
//					}
//					 
//				}
//				@Override
//				public void onFailure(Throwable caught) {
//					MessageBox.alert("", "공통코드 에러!", null);
//				}
//			});

			//detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0350Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createListGrdForm();	// 직종세부정보 그리드
			createStandardForm(); 	// 기본정보필드
			createSubForm();		// 엑셀업로드
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setScrollMode(Scroll.AUTO); 
			panel.setHeaderVisible(false);
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
	public Resm1100() {
		setSize("1010px", "700px");
	}

	public Resm1100(String txtForm) {
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
	private void createPsnl0350Form() {

		plFrmBass0320 = new FormPanel();
		plFrmBass0320.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - ") + "직종관리");
		plFrmBass0320.setIcon(Resources.APP_ICONS.text());
		plFrmBass0320.setPadding(2);
		plFrmBass0320.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("직종관리","BASS0320");
				}
			});
		plFrmBass0320.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0320.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		
		plFrmBass0320.setFrame(true);
		plFrmBass0320.setSize("990px", "680px"); 

		/*LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1 = new LayoutContainer();
		LayoutContainer lc2 = new LayoutContainer();*/
		
		/*ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.LEFT);
		
		btnBass0320Trnr = new Button("개편 직종-직종세 이관");
		btnBass0320Trnr.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
    			BassP035001 bassP03201Form = new BassP035001(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwBass03201 = new MSFFormWindows("개편 직종-직종세 이관", bassP03201Form, "닫기", "820px", "710px", true);
				msFwBass03201.show();
				bassP03201Form.setMSFFormWindows(msFwBass03201);
				
    		}
    	});
		
		btnBar.add(btnBass0320Trnr);
		lc1.add(btnBar);*/
		
		topBass0320Bar = new ButtonBar();
		topBass0320Bar.setAlignment(HorizontalAlignment.RIGHT);
		

		// 신규
		btnBass0320New = new Button("신규");
		btnBass0320New.setIcon(Resources.APP_ICONS.new16());
		topBass0320Bar.add(btnBass0320New);
		btnBass0320New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//신규 버튼 클릭시 처리     
    			formBass0320Init();   
    			actionDatabase = ActionDatabase.INSERT;
    		}
    	});
		 
		
		// 저장 -신규/수정 동시 처리 부분으로 나뉨
		btnBass0320Save = new Button("저장");
		btnBass0320Save.setIcon(Resources.APP_ICONS.save16());
		topBass0320Bar.add(btnBass0320Save);
		btnBass0320Save.addSelectionListener(selectionListener);

		// 삭제
		btnBass0320Del = new Button("삭제");
		btnBass0320Del.setIcon(Resources.APP_ICONS.delete16());
		topBass0320Bar.add(btnBass0320Del);
		btnBass0320Del.addSelectionListener(selectionListener);

		// 검색
		btnBass0320Sreach = new Button("조회");
		btnBass0320Sreach.setIcon(Resources.APP_ICONS.search16());
		topBass0320Bar.add(btnBass0320Sreach);
		btnBass0320Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						// 조회버튼 클릭시 처리 
						reload();
					}
				});
		
		/*lc2.add(topBass0320Bar);
		
		lc.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lc.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));*/

		plFrmBass0320.add(topBass0320Bar);
		

		vp.add(plFrmBass0320);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {

		plFrmBass0320.setLayout(new FlowLayout()); 

		fieldSetSrhFrm = new FieldSet();
		fieldSetSrhFrm.setHeadingHtml("검색조건"); 
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSetSrhFrm.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchColSrhFrm = new LayoutContainer();
		lcSchColSrhFrm.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeftSrhFrm = new LayoutContainer(); 
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(100);
		lcSchLeftSrhFrm.setLayout(frmlytSch); 
  
		srhTypOccuNm = new TextField<String>();
		srhTypOccuNm.setName("srhTypOccuNm");
		srhTypOccuNm.setFieldLabel("직종명");
		lcSchLeftSrhFrm.add(srhTypOccuNm, new FormData("100%"));
		
		LayoutContainer lcSchrRightSrhFrm = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchrRightSrhFrm.setLayout(frmlytSch); 
				
		srhTypOccuUseGrp = new CheckBoxGroup();
		srhTypOccuUseGrp.setName("srhTypOccuUseGrp");
		srhTypOccuUseGrp.setLabelSeparator("");
		
		srhTypOccuUseYn = new CheckBox();
		srhTypOccuUseYn.setName("srhTypOccuUseYn");
		srhTypOccuUseYn.setBoxLabel("사용여부");
		srhTypOccuUseYn.setValue(true);
		srhTypOccuUseGrp.add(srhTypOccuUseYn);
		srhTypOccuUseYn.setHideLabel(true);
		lcSchrRightSrhFrm.add(srhTypOccuUseGrp, new FormData("100%"));
		
		lcSchColSrhFrm.add(lcSchLeftSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		lcSchColSrhFrm.add(lcSchrRightSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
		
		fieldSetSrhFrm.add(lcSchColSrhFrm, new FormData("100%"));

		plFrmBass0320.add(fieldSetSrhFrm);
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
		
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		stTypOccuCd = new ListStore<BaseModel>();
//		stTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		stTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		
		dpobCd = new HiddenField<String>(); 
		typOccuJbfmlDivCd =  new HiddenField<String>();	/** column 직종직군구분코드 : typOccuJbfmlDivCd */ 
		pyspGrdeCd =  new HiddenField<String>();  		/** column null : pyspGrdeCd */
		
		fieldSetFrm = new FieldSet();
		fieldSetFrm.setHeadingHtml("상세정보");

		LayoutContainer lcStdColFrm = new LayoutContainer();
		lcStdColFrm.setLayout(new ColumnLayout());

		LayoutContainer lcStdLeftFrm = new LayoutContainer();
		lcStdLeftFrm.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm = new LayoutContainer();
		lcStdCenterFrm.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm = new LayoutContainer();
		lcStdRightFrm.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm.setLayout(frmlytStd);
		
		LayoutContainer lcStdRightFrm2 = new LayoutContainer();
		lcStdRightFrm2.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm2.setLayout(frmlytStd);
		
		LayoutContainer lcStdFrm2 = new LayoutContainer();
		lcStdFrm2.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdFrm2.setLayout(frmlytStd); 		
		
		LayoutContainer lcStdColFrm2 = new LayoutContainer();
		lcStdColFrm2.setLayout(new ColumnLayout());
		
		LayoutContainer lcStdLeftFrm2 = new LayoutContainer();
		lcStdLeftFrm2.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm2.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm2 = new LayoutContainer();
		lcStdCenterFrm2.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm2.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm3 = new LayoutContainer();
		lcStdRightFrm3.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm3.setLayout(frmlytStd);
		
		
		typOccuCd = new MSFTextField();
		typOccuCd.setReadOnly(true);
		typOccuCd.setName("dtilOccuClsDivCd");
		typOccuCd.setFieldLabel("직종코드");
		lcStdLeftFrm.add(typOccuCd, new FormData("100%"));
		
		typOccuCtnt = new MSFTextField();
		typOccuCtnt.setName("typOccuCtnt");
		typOccuCtnt.setFieldLabel("직종내용");
		lcStdFrm2.add(typOccuCtnt, new FormData("100%"));
		
	 
		typOccuNm = new MSFTextField();
		typOccuNm.setName("typOccuNm");
		typOccuNm.setFieldLabel("직종명");
		lcStdCenterFrm.add(typOccuNm, new FormData("100%"));

		typOccuUseGrp = new CheckBoxGroup();
		typOccuUseGrp.setName("dtilOccuClsUseGrp");
		typOccuUseGrp.setLabelSeparator("");

		typOccuUseYn = new CheckBox();
		typOccuUseYn.setName("typOccuUseYn");
		typOccuUseGrp.add(typOccuUseYn);
		typOccuUseYn.setBoxLabel("사용여부");
		typOccuUseYn.setHideLabel(true); 

		lcStdRightFrm.add(typOccuUseGrp, new FormData("100%"));
		
		
		typOccuOrd = new MSFNumberField();
		typOccuOrd.setName("typOccuOrd");
		typOccuOrd.setFieldLabel("정렬순서");
		typOccuOrd.setRegex("^[0-9]+$"); 
		typOccuOrd.setAllowDecimals(true);
		typOccuOrd.setPropertyEditorType(Long.class); 
		typOccuOrd.setFormat(NumberFormat.getDecimalFormat());
		typOccuOrd.getMessages().setRegexText("숫자만 입력가능합니다.");
		lcStdRightFrm2.add(typOccuOrd, new FormData("100%")); 
		
		chngTypOccuCd = new MSFComboBox<BaseModel>(); 
		chngTypOccuCd.setName("chngTypOccuCd");
		chngTypOccuCd.setFieldLabel("개편전 직종명");
		chngTypOccuCd.setForceSelection(true);				 
		chngTypOccuCd.setMinChars(1);
		chngTypOccuCd.setDisplayField("typOccuNm");		
		chngTypOccuCd.setValueField("typOccuCd");		
		chngTypOccuCd.setTriggerAction(TriggerAction.ALL);
		chngTypOccuCd.setEmptyText("--개편전 직종선택--");
		chngTypOccuCd.setSelectOnFocus(true);
		chngTypOccuCd.setReadOnly(false);
		chngTypOccuCd.setEnabled(true);
		chngTypOccuCd.setStore(stTypOccuCd);
		lcStdLeftFrm2.add(chngTypOccuCd, new FormData("100%"));
		
		typOccuStdt = new MSFDateField();
		typOccuStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		typOccuStdt.setName("typOccuStdt");				 
		new DateFieldMask(typOccuStdt, "9999.99.99");
		typOccuStdt.setFieldLabel("시작일자");
		typOccuStdt.setMinLength(10);
		typOccuStdt.setMaxLength(10);
		lcStdCenterFrm2.add(typOccuStdt, new FormData("100%"));

		typOccuEddt = new MSFDateField(); 
		typOccuEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		typOccuEddt.setName("typOccuEddt");				 
		new DateFieldMask(typOccuEddt, "9999.99.99");
		typOccuEddt.setFieldLabel("종료일자");
		typOccuEddt.setMinLength(10);
		typOccuEddt.setMaxLength(10);
		lcStdRightFrm3.add(typOccuEddt, new FormData("100%"));

		lcStdColFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		lcStdColFrm.add(lcStdRightFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
		
		lcStdColFrm2.add(lcStdLeftFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm2.add(lcStdCenterFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm2.add(lcStdRightFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
			
		
		fieldSetFrm.add(lcStdColFrm, new FormData("100%"));		
		fieldSetFrm.add(lcStdColFrm2, new FormData("100%"));
		fieldSetFrm.add(lcStdFrm2, new FormData("100%"));
		

		plFrmBass0320.add(fieldSetFrm);
		// vp.add(panel);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 서브 입력 폼 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createListGrdForm() {
		
		fieldSetGrd = new FieldSet();
		fieldSetGrd.setHeadingHtml("직종상세정보");
 

		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(940, 405);	//448

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		msfBass0320GridPanel = new MSFGridPanel(resm1100Def, false, false, false, true);
		msfBass0320GridPanel.setHeaderVisible(false);
		msfBass0320GridPanel.setBodyBorder(true);
		msfBass0320GridPanel.setBorders(true);
		 
		final Grid<BaseModel> grid = msfBass0320GridPanel.getMsfGrid().getGrid();
		grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if (msfBass0320GridPanel.getCurrentlySelectedItem() != null) {
				
					bmData = new BaseModel();
	        		bmData = msfBass0320GridPanel.getCurrentlySelectedItem();
			    
	        		dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));
	        		typOccuCd.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuCd")));
	        		typOccuNm.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuNm")));
	        		typOccuCtnt.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuCtnt")));
	        		typOccuOrd.setValue((Long)bmData.get("typOccuOrd"));
	        		typOccuUseYn.setValue((Boolean)bmData.get("typOccuUseYn"));
	        		typOccuJbfmlDivCd.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuJbfmlDivCd")));    /** column 직종직군구분코드 : typOccuJbfmlDivCd */
	        		pyspGrdeCd.setValue(MSFSharedUtils.allowNulls(bmData.get("pyspGrdeCd")));    /** column null : pyspGrdeCd */ 	
//	        		Window.alert(""+(String)grid.getSelectionModel().getSelectedItem().get("chngTypOccuCd"));
	        		chngTypOccuCd.setValue(chngTypOccuCd.getStore().findModel("typOccuCd", (String)grid.getSelectionModel().getSelectedItem().get("chngTypOccuCd")));  //chngTypOccuCd를 어떻게 받아올기 생각해보자.
	        		chngTypOccuCd.setEnabled(false);
	        		typOccuStdt.setValue(ResmUtils.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("typOccuStdt"), "yyyyMMdd"));
	        		typOccuEddt.setValue(ResmUtils.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("typOccuEddt"), "yyyyMMdd"));
	        		
	        		//DB 저장/신규 구분
	        		actionDatabase = ActionDatabase.UPDATE;
			}
			}
		});

		cpGrid.add(msfBass0320GridPanel);
		// grid.setHeight("147px");

		lcStdGrid.add(cpGrid);
		fieldSetGrd.add(lcStdGrid);

		plFrmBass0320.add(fieldSetGrd);

	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	   * Excel 
	   */
	  private void createSubForm() {
		  
		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setHeadingHtml("");
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		  
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());
			
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout()); 
			
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
			    
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2_1.setLayout(frmlytSch);
		layoutContainer_2_1.setBorders(false);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		layoutContainer_3.setBorders(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer(); 
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_4.setLayout(frmlytSch);
	    layoutContainer_4.setBorders(false);
	    
	    resm1100flUp = new FileUploadField();
	    resm1100flUp.setName("resm1100flUp");
	    resm1100flUp.setValidator(new Validator() {  
                @Override  public String validate(Field<?> field, String value) { 
                    value = value.toLowerCase();        
                    String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
                    if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
                        result = null;        
                        }        
                    return result;  
                    } 
                });
		layoutContainer_2_1.add(resm1100flUp, new FormData("100%"));
		resm1100flUp.setFieldLabel("직종");
		
		Button btnButton01 = new Button("양식업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  
              	xlsImportData(); 
                    
              }
          });
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		

		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  
                xlsExportData();
                    
              }
          }); 		
		layoutContainer_4.add(btnButton02, new FormData("100%"));
		
		layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		
		plFrmBass0320.add(fldstNewFieldset);
			
	  } 
	  
	  /* 엑셀 업로드 */
	  private void xlsImportData() {
		  MessageBox.confirm("직종 생성", "직종을 생성하시겠습니까?<br>",new Listener<MessageBoxEvent>(){
		      	@Override
		    	public void handleEvent(MessageBoxEvent be) {
		      		//if("Yes".equals(be.getButtonClicked().getText())){
		      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      			
		      			String filename = MSFSharedUtils.allowNulls(resm1100flUp.getValue());
	              		if (filename.length() == 0) {
	              			Window.alert("선택된 파일이 없습니다.");
	              			return;
	                	} else {
	                		//submit the form
	                		plFrmBass0320.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                		//파일업로드 처리
	                		plFrmBass0320.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadBass0320Import.do");
	                		plFrmBass0320.setEncoding(Encoding.MULTIPART);
	                		plFrmBass0320.setMethod(Method.POST);   
	                		plFrmBass0320.submit();  
	                		plFrmBass0320.onFrameLoad();  
	                    	picBoolFile = true;	 
	                    	
	                	}
	              		// reset and unmask the form 
                      	// after file upload 
	              		plFrmBass0320.addListener(Events.Submit, new Listener<FormEvent>() {
                      		public void handleEvent(FormEvent evt) {   
                      			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
                      				
                      				//업로드가  성공했으면 인서트 모듈을 태운다. 
                      				plFrmBass0320.unmask();  
//                                  MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
                                  	picBoolFile = false;
                                  	evt.setResultHtml("");
                              	} else {
                              		if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
                              			plFrmBass0320.unmask();  
                              			MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
                                      	picBoolFile = false;
                                    	evt.setResultHtml("");
                              		} else {
                              			//실패 메시지나 에러 메시지 처리 . 
                              			evt.setResultHtml("");
                              		} 
                              	}
                      		};
                      	});               		
	              		
		           	}  
		        }
			}); 	     	 
	  } 
	    
	  /* 엑셀 다운로드 */
	  private void xlsExportData() {
		  
		  HashMap<String, String> param = new HashMap<String, String>();  
		  
		  param.put("dpobCd",MSFSharedUtils.allowNulls(dpobCd.getValue()) );	//사업장코드
		  param.put("typOccuCd", MSFSharedUtils.allowNulls(typOccuCd.getValue()));	//직종코드
		  param.put("typOccuNm", MSFSharedUtils.allowNulls(typOccuNm.getValue()));	//직종명
		  param.put("typOccuUseYn",MSFSharedUtils.allowNulls((Boolean)typOccuUseYn.getValue()));    /** column 직종사용여부 : typOccuUseYn */
		  param.put("typOccuCtnt",MSFSharedUtils.allowNulls(typOccuCtnt.getValue()));    /** column 직종내용 : typOccuCtnt */
		  param.put("typOccuOrd",MSFSharedUtils.allowNulls((Long)typOccuOrd.getValue()));    /** column 정렬순서 : typOccuOrd */
		  param.put("chngTypOccuCd",ResmUtils.getSelectedComboValue(chngTypOccuCd,"typOccuCd"));	/** column 개편전 직종명 : chngTypOccuCd */
		  param.put("typOccuStdt",ResmUtils.getConvertDateToString(typOccuStdt, "yyyyMMdd"));	/** column 시작일자 : typOccuStdt */
		  param.put("typOccuEddt",ResmUtils.getConvertDateToString(typOccuEddt, "yyyyMMdd"));	/** column 종료일자 : typOccuEddt */
	  
		  msfBass0320GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileBass0320Export.do","extgwtFrame" ,param);  
	  }
	  
	@Override
	public void reload() {
		
		formBass0320Init();
		
		//검색조건
		IColumnFilter filters = null;
		msfBass0320GridPanel.getTableDef().setTableColumnFilters(filters); 
		msfBass0320GridPanel.getTableDef().addColumnFilter("typOccuNm", srhTypOccuNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);					//직종명
		msfBass0320GridPanel.getTableDef().addColumnFilter("srhTypOccuUseYn", srhTypOccuUseYn.getValue()? "Y" : "N", SimpleColumnFilter.OPERATOR_LIKE);
		msfBass0320GridPanel.reload();
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Resm1100 getThis() {
		return this;
	}	
	
	private void formBass0320Init() {
		dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());	 
		typOccuCd.setValue("");	//직종명 
		typOccuNm.setValue("");				//직종명
		typOccuCtnt.setValue("");			//직종내용
		typOccuOrd.reset();		      	//순서
		typOccuOrd.setValue(0);
		typOccuUseYn.setValue(false);		//직종사용여부
		typOccuStdt.setReadOnly(false);
		typOccuStdt.setValue(today); 		// 시작일자
		typOccuEddt.setReadOnly(false);
		typOccuEddt.setValue(today); 		// 종료일
		chngTypOccuCd.setValue(new BaseModel());
		chngTypOccuCd.setEnabled(true);//직종코드
		
		  
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
