package com.app.exterms.payroll.client.form;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.gwtrpcspring.RemoteServiceUtil;

import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.exterms.payroll.client.form.defs.Payr0410Def;
import com.app.exterms.payroll.client.lookup.LookupPayr0415PayYr;
import com.app.exterms.payroll.client.service.PayrP150003Service;
import com.app.exterms.payroll.client.service.PayrP150003ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PayrP150003 extends MSFFormPanel{

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	private FormPanel cpPayrP150003;

	// -------------- grid 선언 시작 ---------------
	private MSFGridPanel PayrP150003_01GridPanel;
	private MSFGridPanel PayrP150003_02GridPanel;

	// private Bass0500Def bass0500Def = new Bass0500Def();
	private Payr0410Def payrP150003Def_01 = new Payr0410Def("POPUP_PAYR150003_PAYR0410_COPY_1");
	private Payr0410Def payrP150003Def_02 = new Payr0410Def("POPUP_PAYR150003_PAYR0410_COPY_2");
	// -------------- grid 선언 종료 ---------------

	// -------------- 공통코드 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0350DTO sysComBass0350Dto;   
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- 공통코드 선언 종료--------------
	private ListStore<BaseModel>   lsPayYrStore = new ListStore<BaseModel>(); 
	private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();

	private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();
	private MSFGridPanel payYrGridPanel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 상태처리
	 * 전역변수 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	//권한 설정 객체 
	private static  GWTAuthorization gwtAuthorization;
	private static  GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 화면
	 * 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	public FormBinding formBinding;
	private Date today = new Date();		// 오늘 날짜 가져오는 코드
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private Button btnPayrSave = new Button(); // 선태 저장
	private Button btnPayrSave2 = new Button(); // 미선택 저장
	private Button btnPayrAllSave = new Button(); // 일괄복사

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 변수
	 * 선언 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 변수 시작 --------------
	private ComboBox<BaseModel> basicPayYr; /** column 급여년도 : payYr */
	private ComboBox<BaseModel> basicTypOccuCd; 	/** column 직종코드 : typOccuCd */
	private ComboBox<BaseModel> basicDtilOccuInttnCd; /** column 직종세코드 : dtilOccuInttnCd */  
	private ComboBox<BaseModel> basicPayCd; // 급여구분

	private ComboBox<BaseModel> targetPayCd; // 급여구분

	private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
	// -------------- 변수 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private PayrP150003ServiceAsync payrP150003Service = PayrP150003Service.Util.getInstance();

	// -------------- 서비스 호출 종료 --------------
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 입력
	 * 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkPayrP150003Auth( String authAction, ListStore<BaseModel>bm) {
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			if (!maskTracker) { unmask(); } 
			authExecEnabled();
		}
	}

	private void authExecEnabled() { 
		Field<?>[] fldArrField = { basicTypOccuCd, basicDtilOccuInttnCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);

		basicPayYr.setValue(lsPayYrStore.findModel("payYr", DateTimeFormat.getFormat("yyyy").format(new Date())));
		
		basicPayCd.setValue(lsPayCd.getAt(0));
		
		targetPayCd.setValue(lsPayCd.getAt(0));

	}

	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			cancel();
			unmask();
			authExecEnabled() ;
			maskTracker = true;
			// }
		}
	};

	private void initLoad() {

		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();

		authMapDef.put("basicPayYr", Boolean.FALSE);
		authMapDef.put("basicPayCd", Boolean.FALSE);
		authMapDef.put("targetPayYr", Boolean.FALSE);
		authMapDef.put("targetPayCd", Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			//권한 검색조건처리를 위해 추가된 부분
			mask("[화면로딩] 초기화 진행 중!");
		}	
		tmMask.scheduleRepeating(5000);
	}
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	public PayrP150003(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		//콤보 권한초기화
		initLoad(); 

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);

		cpPayrP150003 = new FormPanel();

		createMsfGridForm();

		cpPayrP150003.setBodyBorder(false);
		cpPayrP150003.setBorders(false);
		cpPayrP150003.setHeaderVisible(false);
		cpPayrP150003.setSize("890px", "590px");

		this.add(cpPayrP150003);
		formBinding = new FormBinding(this, true);

		this.setSize("900px", "590px");
	}

	private void createMsfGridForm() {

		// private void createMsfGridForm() {
		LayoutContainer layoutContainer = new LayoutContainer();

		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		//		layoutContainer1.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		layoutContainer1_2.setLayout(new ColumnLayout());

		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.setHeadingHtml("기본 단가항목");
		fldstNewFieldset2.setSize("430px", "500px");
		fldstNewFieldset2.add(bassLeft01(), new FormData("100%"));
		layoutContainer1.add(fldstNewFieldset2);

		layoutContainer1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		FieldSet fldstNewFieldset3 = new FieldSet();		
		fldstNewFieldset3.setHeadingHtml("대상 단가항목");
		fldstNewFieldset3.setSize("430px", "500px");
		fldstNewFieldset3.add(bassRight01(), new FormData("100%"));
		layoutContainer1_2.add(fldstNewFieldset3);

		layoutContainer1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setStyleAttribute("paddingRight", "15px");
		layoutContainer2.setStyleAttribute("paddingTop", "10px");

		LayoutContainer layoutContainer2_1 = new LayoutContainer();	

		LayoutContainer layoutContainer2_2 = new LayoutContainer();

		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnPayrAllSave = new Button("일괄복사");
		btnPayrAllSave.setWidth(150);
		btnPayrAllSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				copyPkgEvent150003();
			}

		});

		btnBar.add(btnPayrAllSave);
		layoutContainer2_2.add(btnBar);

		layoutContainer2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.6));
		layoutContainer2.add(layoutContainer2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));

		layoutContainer.add(layoutContainer1);
		layoutContainer.add(layoutContainer2);

		cpPayrP150003.add(layoutContainer);
	}

	private LayoutContainer bassLeft01() {
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO(); 
		sysComBass0320Dto = new PrgmComBass0320DTO();

		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
		lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 

		ContentPanel payYrGrid = new ContentPanel();  
		payYrGrid.setVisible(false);

		//년도 콤보처리 
		payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
		payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
			public void handleEvent(ComponentEvent be) {  
				payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
					public void handleEvent(StoreEvent<BaseModel> be) {  
						lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 

					}  
				});  

			}  
		});  

		payYrGrid.add(payYrGridPanel); 
		cpPayrP150003.add(payYrGrid);

		LayoutContainer lcStdGrid = new LayoutContainer();
		//		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		//		lcStdGrid.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer_1_1.setLayout(frmlytStd);

		/** column 지급년 : payYr */
		basicPayYr = new ComboBox<BaseModel>();
		basicPayYr.setName("basicPayYr");
		basicPayYr.setForceSelection(true);
		basicPayYr.setMinChars(1);
		basicPayYr.setDisplayField("payYrDisp");
		basicPayYr.setValueField("payYr");
		basicPayYr.setTriggerAction(TriggerAction.ALL);
		// srhPayYr.setEmptyText("--년도선택--");
		basicPayYr.setSelectOnFocus(true); 
		basicPayYr.setReadOnly(false);
		basicPayYr.setEnabled(true); 
		basicPayYr.setStore(lsPayYrStore);
		basicPayYr.setFieldLabel("지급년도");
		basicPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  

				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","basicTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPayrP150003Auth("basicPayYr", lsPayYrStore ); 
				}

			}
		}); 
		layoutContainer_1_1.add(basicPayYr, new FormData("100%"));		
		layoutContainer_1.add(layoutContainer_1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

		LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer_1_2.setLayout(frmlytStd);

		basicPayCd =  new ComboBox<BaseModel>(); 
		basicPayCd.setName("basicPayCd");
		basicPayCd.setForceSelection(true);
		basicPayCd.setMinChars(1);
		basicPayCd.setDisplayField("commCdNm");
		basicPayCd.setValueField("commCd");
		basicPayCd.setTriggerAction(TriggerAction.ALL);
		basicPayCd.setEmptyText("--급여구분선택--");
		basicPayCd.setSelectOnFocus(true); 
		basicPayCd.setReadOnly(false);
		basicPayCd.setEnabled(true); 
		basicPayCd.setStore(lsPayCd);
		basicPayCd.setFieldLabel("급여구분");
		basicPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) { 
				
				checkPayrP150003Auth("basicPayCd",lsPayCd); 
			}
		});    
		basicPayCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				basicDtilOccuInttnCd.setValue(new BaseModel());
			} 
		}); 
		layoutContainer_1_2.add(basicPayCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setStyleAttribute("paddingBottom", "10px");

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer_2_1.setLayout(frmlytStd);
		
		basicTypOccuCd = new ComboBox<BaseModel>(); 
		basicTypOccuCd.setName("basicTypOccuCd");
		basicTypOccuCd.setForceSelection(true);
		basicTypOccuCd.setMinChars(1);
		basicTypOccuCd.setDisplayField("typOccuNm");
		basicTypOccuCd.setValueField("typOccuCd");
		basicTypOccuCd.setTriggerAction(TriggerAction.ALL);
		basicTypOccuCd.setEmptyText("--직종선택--");
		basicTypOccuCd.setSelectOnFocus(true); 
		basicTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		basicTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		basicTypOccuCd.setStore(lsTypOccuCd); 
		basicTypOccuCd.setFieldLabel("직 종");  
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					if (!gwtExtAuth.getEnableTypOccuCd()) {
						BaseModel  mdSelect  = basicTypOccuCd.getStore().getAt(0) ; 
						basicTypOccuCd.setValue(mdSelect );
					}  
				}
			}
		});    
		basicTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

				//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기  
				sysComBass0350Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
				sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(basicTypOccuCd,"typOccuCd")); 

				if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {

					lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
					basicDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);

				} 
			} 
		});
		layoutContainer_2_1.add(basicTypOccuCd, new FormData("100%")); 
		layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_2_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer_2_2.setLayout(frmlytStd);
		
		basicDtilOccuInttnCd = new ComboBox<BaseModel>();
		basicDtilOccuInttnCd.setName("basicDtilOccuInttnCd");
		basicDtilOccuInttnCd.setFieldLabel("직종세");
		basicDtilOccuInttnCd.setForceSelection(true);
		basicDtilOccuInttnCd.setMinChars(1);
		basicDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
		basicDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
		basicDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
		basicDtilOccuInttnCd.setEmptyText("--직종세선택--");
		basicDtilOccuInttnCd.setSelectOnFocus(true);
		basicDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		basicDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		basicDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);	
		basicDtilOccuInttnCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(!"".equals(MSFSharedUtils.getSelectedComboValue(basicDtilOccuInttnCd,"dtilOccuInttnCd"))){
					reload();
				}
			} 
		}); 
		layoutContainer_2_2.add(basicDtilOccuInttnCd, new FormData("100%")); 
		layoutContainer_2.add(layoutContainer_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		ContentPanel cpGridPayrP150003_01 = new ContentPanel();
		cpGridPayrP150003_01.setBodyBorder(false);
		cpGridPayrP150003_01.setHeaderVisible(false);
		cpGridPayrP150003_01.setLayout(new FitLayout());
		cpGridPayrP150003_01.setSize(410, 410);

		PayrP150003_01GridPanel = new MSFGridPanel(payrP150003Def_01, false, false,false, false, false);
		PayrP150003_01GridPanel.setBorders(false);
		PayrP150003_01GridPanel.setBodyBorder(true);
		PayrP150003_01GridPanel.setHeaderVisible(false);
		PayrP150003_01GridPanel.getBottomComponent().setVisible(true);	
		// 두번째 미사용직종정보 툴바 
		ToolBar bottomToolbar = new ToolBar(); 
		bottomToolbar.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnPayrSave = new Button("선택");
		btnPayrSave.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(PayrUtils.getSelectedComboValue(basicPayCd,"commCd") == PayrUtils.getSelectedComboValue(targetPayCd,"commCd")){
					MessageBox.info("", "다른 급여구분을 선택하여 주세요.", null);
				}else if(PayrP150003_01GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){

					List<BaseModel> list = PayrP150003_01GridPanel.getGrid().getSelectionModel().getSelectedItems();
					List<BaseModel> list2 = new ArrayList<BaseModel>();

					for(BaseModel bm : list){

						PayrP150003_01GridPanel.getGrid().getStore().remove(bm);

						bm.set("payCd", MSFSharedUtils.getSelectedComboValue(targetPayCd,"commCd"));
						bm.set("payNm", MSFSharedUtils.getSelectedComboValue(targetPayCd,"commCdNm"));
						list2.add(bm);
					}

					PayrP150003_02GridPanel.getGrid().getStore().add(list2);
				}
			}			
		});
		bottomToolbar.add(btnPayrSave);
		bottomToolbar.add(new SeparatorMenuItem());
		PayrP150003_01GridPanel.setBottomComponent(bottomToolbar);
		cpGridPayrP150003_01.add(PayrP150003_01GridPanel);

		lcStdGrid.add(layoutContainer_1);
		lcStdGrid.add(layoutContainer_2);		
		lcStdGrid.add(cpGridPayrP150003_01);	

		return lcStdGrid;

	}

	private LayoutContainer bassRight01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		//		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		//		lcStdGrid.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer_1_1.setLayout(frmlytStd);

		targetPayCd =  new ComboBox<BaseModel>(); 
		targetPayCd.setName("targetPayCd");
		targetPayCd.setForceSelection(true);
		targetPayCd.setMinChars(1);
		targetPayCd.setDisplayField("commCdNm");
		targetPayCd.setValueField("commCd");
		targetPayCd.setTriggerAction(TriggerAction.ALL);
		targetPayCd.setEmptyText("--급여구분선택--");
		targetPayCd.setSelectOnFocus(true); 
		targetPayCd.setReadOnly(false);
		targetPayCd.setEnabled(true); 
		targetPayCd.setStore(lsPayCd);
		targetPayCd.setFieldLabel("급여구분");
		targetPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				checkPayrP150003Auth("targetPayCd",lsPayCd); 

			}
		});    
		layoutContainer_1_1.add(targetPayCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

		LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer_1_2.setLayout(frmlytStd);
		
		layoutContainer_1.add(layoutContainer_1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setStyleAttribute("paddingBottom", "35px");
		
		ContentPanel cpGridPayrP150003_02 = new ContentPanel();
		cpGridPayrP150003_02.setBodyBorder(false);
		cpGridPayrP150003_02.setHeaderVisible(false);
		cpGridPayrP150003_02.setLayout(new FitLayout());
		cpGridPayrP150003_02.setSize(410, 410);

		PayrP150003_02GridPanel = new MSFGridPanel(payrP150003Def_02, false, false,false, false, false);
		//		PayrP150003_02GridPanel.setSize(380, 450);
		PayrP150003_02GridPanel.setBorders(false);
		PayrP150003_02GridPanel.setBodyBorder(true);
		PayrP150003_02GridPanel.setHeaderVisible(false);
		PayrP150003_02GridPanel.getBottomComponent().setVisible(true);
		// 두번째 미사용직종정보 툴바 
		ToolBar bottomToolbar2 = new ToolBar(); 
		bottomToolbar2.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnPayrSave2 = new Button("미선택");
		btnPayrSave2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(PayrP150003_02GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){

					List<BaseModel> list = PayrP150003_02GridPanel.getGrid().getSelectionModel().getSelectedItems();
					List<BaseModel> list2 = new ArrayList<BaseModel>();

					for(BaseModel bm : list){

						PayrP150003_02GridPanel.getGrid().getStore().remove(bm);

						bm.set("payCd", MSFSharedUtils.getSelectedComboValue(basicPayCd,"commCd"));
						bm.set("payNm", MSFSharedUtils.getSelectedComboValue(basicPayCd,"commCdNm"));
						list2.add(bm);
					}

					PayrP150003_01GridPanel.getGrid().getStore().add(list2);


				}
			}			
		});

		bottomToolbar2.add(btnPayrSave2);
		bottomToolbar2.add(new SeparatorMenuItem());
		PayrP150003_02GridPanel.setBottomComponent(bottomToolbar2);
		cpGridPayrP150003_02.add(PayrP150003_02GridPanel);

		lcStdGrid.add(layoutContainer_1);
		lcStdGrid.add(layoutContainer_2);
		lcStdGrid.add(cpGridPayrP150003_02);

		return lcStdGrid;

	}
	
	public void copyPkgEvent150003() {

		Iterator<BaseModel> itBm = PayrP150003_02GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

		List<Record>  lsRec  = new ArrayList<Record>();

		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 

		Iterator<Record> iterRecords = lsRec.iterator() ;  
		List<Payr0410DTO> listPayr0410Dto = new ArrayList<Payr0410DTO>(); 

		final int cnt = PayrP150003_02GridPanel.getGrid().getSelectionModel().getSelectedItems().size();

		while (iterRecords.hasNext()) {

			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			Payr0410DTO payr0410Dto = new Payr0410DTO();  

			payr0410Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());    					/** column 사업장코드 : dpobCd */
			payr0410Dto.setTypOccuGrdeMppgSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuGrdeMppgSeilNum"))));/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
			payr0410Dto.setPayYr(MSFSharedUtils.allowNulls(bmMapModel.get("payYr")));    					/** column 지급년도 : payYr */
			payr0410Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));
			payr0410Dto.setCalcStdFunc(MSFSharedUtils.allowNulls(bmMapModel.get("calcStdFunc")));  /** column 계산수식내용 : calcStdFunc */
			
			payr0410Dto.setPayCd(MSFSharedUtils.getSelectedComboValue(targetPayCd,"commCd"));
			payr0410Dto.setItemNm(MSFSharedUtils.allowNulls(bmMapModel.get("itemNm")));
			payr0410Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(basicTypOccuCd,"typOccuCd"));
			payr0410Dto.setPayrImcd(MSFSharedUtils.allowNulls(bmMapModel.get("payrImcd")));   /** column 급여항목코드 : payrImcd */     
			payr0410Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));
			payr0410Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));
			
			payr0410Dto.setDtilOccuInttnCd(MSFSharedUtils.getSelectedComboValue(basicDtilOccuInttnCd,"dtilOccuInttnCd"));	
			payr0410Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));   /** column 지급공제구분코드 : pymtDducDivCd */              
			payr0410Dto.setPymtDducFrmCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducFrmCd")));   /** column 지급공제유형코드 : pymtDducFrmCd */   
			payr0410Dto.setPymtDducRate(MSFSharedUtils.convertStringToDouble(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducRate"))));   /** column 지급공제율 : pymtDducRate */                       
			payr0410Dto.setPymtDducSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducSum"))));   /** column 지급공제액 : pymtDducSum */                        
			
			payr0410Dto.setTxtnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("txtnDivCd")));   /** column 과세구분코드 : txtnDivCd */                          
			payr0410Dto.setFreeDtyRate(MSFSharedUtils.convertStringToDouble(MSFSharedUtils.allowNulls(bmMapModel.get("freeDtyRate"))));   /** column 비과세율 : freeDtyRate */                          
			payr0410Dto.setFreeDtySum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.allowNulls(bmMapModel.get("freeDtySum"))));   /** column 비과세금액 : freeDtySum */   
			payr0410Dto.setJan(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("jan"))).booleanValue());   /** column 1월 : jan */
			payr0410Dto.setFeb(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("feb"))).booleanValue());   /** column 2월 : feb */
			
			payr0410Dto.setMar(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("mar"))).booleanValue());   /** column 3월 : mar */
			payr0410Dto.setApr(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("apr"))).booleanValue());   /** column 4월 : apr */
			payr0410Dto.setMay(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("may"))).booleanValue());   /** column 5월 : may */
			payr0410Dto.setJun(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("jun"))).booleanValue());   /** column 6월 : jun */
			payr0410Dto.setJul(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("jul"))).booleanValue());   /** column 7월 : jul */
			
			payr0410Dto.setAug(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("aug"))).booleanValue());   /** column 8월 : aug */
			payr0410Dto.setSep(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("sep"))).booleanValue()) ;  /** column 9월 : sep */
			payr0410Dto.setOct(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("oct"))).booleanValue());   /** column 10월 : oct */
			payr0410Dto.setNov(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("nov"))).booleanValue());   /** column 11월 : nov */
			payr0410Dto.setDec(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("dec"))).booleanValue());   /** column 12월 : dec */ 
			
			payr0410Dto.setRngeOrd(MSFSharedUtils.convertStringToLong(MSFSharedUtils.allowNulls(bmMapModel.get("rngeOrd"))));   /** column 정렬순서 : rngeOrd */    
			payr0410Dto.setPayItemUseYn(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("payItemUseYn"))).booleanValue());   /** column 급여항목사용여부 : payItemUseYn */     
			payr0410Dto.setItemApptnBgnnDt(DateTimeFormat.getFormat("yyyyMMdd").format((Date)bmMapModel.get("itemApptnBgnnDt")));   /** column 항목적용시작일자 : itemApptnBgnnDt */
			payr0410Dto.setItemApptnEndDt(DateTimeFormat.getFormat("yyyyMMdd").format((Date)bmMapModel.get("itemApptnEndDt"))) ; /** column 항목적용종료일자 : itemApptnEndDt */   
			payr0410Dto.setDayMnthAmntDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dayMnthAmntDivCd"))) ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
			
			payr0410Dto.setCalcStdDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcStdDivCd")));   /** column 계산기준구분코드 : calcStdDivCd */   
			payr0410Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01);
			payr0410Dto.setUsalyAmntYn(Boolean.valueOf(MSFSharedUtils.allowNulls(bmMapModel.get("usalyAmntYn"))).booleanValue());   /** column 통상임금여부 : usalyAmntYn */ 
			payr0410Dto.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("payItemNoteCtnt")));   /** column 급여항목비고내용 : payItemNoteCtnt */ 
			

			listPayr0410Dto.add(payr0410Dto);			
		}          

		payrP150003Service.copyPkgUnitPriceItemsPayrP150003(listPayr0410Dto ,new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("copyPkgUnitPriceItemsPayrP150003(" + "일괄 복사가 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {

				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + cnt + "건중  " + " " + result + " " + "건이 완료되었습니다.", null);	
				basicTypOccuCd.setValue(new BaseModel());
				basicDtilOccuInttnCd.setValue(new BaseModel());
				basicPayCd.setValue(lsPayCd.getAt(0));
				targetPayCd.setValue(lsPayCd.getAt(0));
				reload2();
			}
		});      

	}

	public void reload() {

		IColumnFilter filters = null;
		PayrP150003_01GridPanel.getMsfGrid().clearData();	
		PayrP150003_01GridPanel.getTableDef().setTableColumnFilters(filters);
		PayrP150003_01GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(basicPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
		PayrP150003_01GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(basicTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		PayrP150003_01GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(basicDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		PayrP150003_01GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFMainApp.get().getUser().getPayrMangDeptCd() , SimpleColumnFilter.OPERATOR_EQUALS); 
		PayrP150003_01GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(basicPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		PayrP150003_01GridPanel.reload();
	}

	public void reload2() {		
		PayrP150003_01GridPanel.getMsfGrid().clearData();
		PayrP150003_02GridPanel.getMsfGrid().clearData();
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
