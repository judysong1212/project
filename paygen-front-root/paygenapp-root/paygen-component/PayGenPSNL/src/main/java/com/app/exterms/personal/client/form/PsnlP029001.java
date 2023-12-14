/**
 * 신규고용일괄등록
 **/
package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.form.defs.Psnl0126Def;
import com.app.exterms.personal.client.service.PsnlP029001Service;
import com.app.exterms.personal.client.service.PsnlP029001ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class PsnlP029001 extends MSFFormPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------

	private FormPanel cpPsnlP029001;

	private PsnlP029001ServiceAsync psnlP029001Service = PsnlP029001Service.Util.getInstance();

	// -------------- grid 선언 시작 ---------------
	private Psnl0126Def psnl0126Def  = new Psnl0126Def("PSNLP029001");   //그리드 테이블 컬럼 define  
	private MSFGridPanel psnlP0126GridPanel;
	// -------------- grid 선언 종료 ---------------	

	// -------------- 휴가일수 생성 폼 시작 --------------
	private DateField creWorkDayS;      						//근태기간 시작일
	private DateField creWorkDayE;      						//근태기간 종료일
	private ComboBox<BaseModel> creEmymtDivCd;					//고용구분
	private ComboBox<BaseModel> creRepbtyBusinDivCd; 			//호봉제구분코드  
	private ComboBox<BaseModel> creBusinCd;						//사업
	private ComboBox<BaseModel> crePayrMangDeptCd;				//단위기관
	private ComboBox<BaseModel> creYear;        				//작업년도
	private MSFMultiComboBox<ModelData> creDeptCd ;    			//부서 
	private ComboBox<BaseModel> creDeptGpCd; 					//부서직종그룹코드	
	private MSFMultiComboBox<ModelData> creTypOccuCd;			//직종  
	private MSFMultiComboBox<ModelData> creDtilOccuInttnCd;		//직종세   
	private CheckBox creHodyFixYn;								//확정여부
	private List<ModelData> mDtalistcrDeptCd;			
	private List<ModelData> mDtalistcrTypOccuCd;
	private List<ModelData> mDtalistcrDtilOccuInttnCd;

	// -------------- 휴가일수 생성 폼 종료 --------------

	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;	//공통코드
	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
	private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
	private SysCoCalendarDTO  msfCoCalendarDto;  
	private PrgmComBass0320DTO sysComBass0320Dto;
	private PrgmComBass0350DTO sysComBass0350Dto;
	// -------------- DTO 선언 종료 --------------

	// --------------------------------------------------------------------------------------
	private ListStore<BaseModel> lscrPayYr				= new ListStore<BaseModel>();	//년도 
	private ListStore<BaseModel> lscrPayMonth			= new ListStore<BaseModel>();  	//급여월   
	private ListStore<BaseModel> lscrEmymtDivCd 		= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lscreRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lscrDeptCd  			= new ListStore<BaseModel>();	//부서콤보
	private ListStore<BaseModel> lscrBusinCd  			= new ListStore<BaseModel>();	//사업콤보   
	private ListStore<BaseModel> lscrPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lscreDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드  
	private ListStore<BaseModel> lscrTypOccuCd 			= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lscrDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lscrPayCd 				= new ListStore<BaseModel>(); 	//급여구분

	private boolean mutilcrCombo = false;
	// -------------- store 선언 종료  ---------------
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 상태처리 전역변수 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * ^^^^^^^^^^^^
	 */

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 화면 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	public FormBinding formBinding;

	public PsnlP029001(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);

		cpPsnlP029001 = new FormPanel();
		initLoad();
		createForm();

		cpPsnlP029001.setBodyBorder(false);
		cpPsnlP029001.setBorders(false);
		cpPsnlP029001.setHeaderVisible(false);
		cpPsnlP029001.setSize("770px", "590px");

		// ------------------ 멀티콤보박스 닫기 ------------------  
		cpPsnlP029001.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 						
				if (mutilcrCombo) {
					if ( creDeptCd.getCheckBoxListHolder().isVisible() ) {
						//부서
						creDeptCd.showClose(ce);
						mutilcrCombo = false;
					} else if (creTypOccuCd.getCheckBoxListHolder().isVisible() ) {
						//직종
						creTypOccuCd.showClose(ce);
						mutilcrCombo = false;
						//  creTypOccuCd.getListView().fireEvent(Events.CheckChanged);
					} else if ( creDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
						//직종세
						creDtilOccuInttnCd.showClose(ce);
						mutilcrCombo = false;
					}  
				}
			} 
		}); 
		// ------------------ 멀티콤보박스 닫기 ------------------  

		this.add(cpPsnlP029001);
		formBinding = new FormBinding(this, true);

		this.setSize("800px", "600px");
	}

	/**
	 * 휴가 일수 생성
	 */
	private void createForm() {

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto  = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();

		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lscrPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------


		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B015");	//급여구분 
		lscrPayCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		sysComBass0300Dto.setRpsttvCd("A002");	//고용구분
		lscrEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());       
		lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);	//부서

		lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistcrDeptCd = PersonalUtil.getDeptCdModelData(lscrDeptCd) ; 
				creDeptCd.getStore().add(mDtalistcrDeptCd);                
			}
		});  

		sysComBass0300Dto.setRpsttvCd("A048");
		lscreRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------

		//       /**
		//        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//        * 직종 콤보박스 처리  시작
		//        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
		//        */
		//        
		lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  

				mDtalistcrTypOccuCd = PersonalUtil.getTypOccuCdModelData(lscrTypOccuCd) ;  
				creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);


			}
		});  


		msfCoCalendarDto = new SysCoCalendarDTO();

		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 

		FieldSet fldstNewFieldset = new FieldSet(); 
		fldstNewFieldset.setHeadingHtml("휴가일수-생성");

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		LayoutContainer lcSchCol01 = new LayoutContainer();		
		FormLayout frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		creYear = new ComboBox<BaseModel>();
		creYear.setName("creYear");
		creYear.setFieldLabel("년도");
		creYear.setForceSelection(true);
		creYear.setMinChars(1);
		creYear.setDisplayField("yearDisp");
		creYear.setValueField("year");
		creYear.setTriggerAction(TriggerAction.ALL);
		creYear.setEmptyText("--년도--");
		creYear.setSelectOnFocus(true);
		creYear.setStore(lscrPayYr);
		creYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {   
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPsnl0290Auth("creYear", lscrPayYr); 
				} 
			}
		});
		creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayYr =  se.getSelectedItem(); 
				if (bmPayYr != null) {
					if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
						if (creDeptCd.getListView().getChecked().size() > 0) {  

							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));
							List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
							sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
						}      

						//--------------------사업 불러 오는 함수 -------------------------------------------------
						lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						//--------------------사업 불러 오는 함수 -------------------------------------------------
						creBusinCd.setStore(lscrBusinCd); 
						creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
							public void handleEvent(StoreEvent<BaseModel> be) {  
								//   searchBusinCd.setValue(lsBusinCd.getAt(0));  
							}
						});    
					} else {
						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
						//         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
						// return;
					}
				}       
			} 
		});
		creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmMonth =  se.getSelectedItem(); 
				if (bmMonth != null) { 
					if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) ) {
						//년도에 따라 기간 변화
						setInitDate();
					}
				}       
			} 
		}); 
		lcSchCol01.add(creYear, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();		
		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		/** column 단위기관 : payrMangDeptCd */
		crePayrMangDeptCd = new ComboBox<BaseModel>();
		crePayrMangDeptCd.setName("crePayrMangDeptCd"); 
		crePayrMangDeptCd.setForceSelection(true);
		crePayrMangDeptCd.setMinChars(1);
		crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
		crePayrMangDeptCd.setValueField("payrMangDeptCd");
		crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		crePayrMangDeptCd.setEmptyText("--단위기관선택--");
		crePayrMangDeptCd.setSelectOnFocus(true); 
		crePayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		crePayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
		crePayrMangDeptCd.setStore(lscrPayrMangDeptCd);  
		crePayrMangDeptCd.setFieldLabel("단위기관"); 
		lscrPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPsnl0290Auth("crePayrMangDeptCd", lscrPayrMangDeptCd); 
				}
			}
		});    
		crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));

				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
				//--------------------부서 불러 오는 함수 ------------------------------------------------

				lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistcrDeptCd = PersonalUtil.getDeptCdModelData(lscrDeptCd) ; 
						creDeptCd.getInitStore().add(mDtalistcrDeptCd);
					}
				});   
			} 
		});
		lcSchCol02.add(crePayrMangDeptCd, new FormData("100%"));

		LayoutContainer lcSchCol03 = new LayoutContainer(new ColumnLayout());	

		LayoutContainer lcSchCol03_1 = new LayoutContainer();		
		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03_1.setLayout(frmlytSch);

		creEmymtDivCd = new ComboBox<BaseModel>();
		creEmymtDivCd.setFieldLabel("고용구분");
		creEmymtDivCd.setForceSelection(true);
		creEmymtDivCd.setMinChars(1);
		creEmymtDivCd.setDisplayField("commCdNm");
		creEmymtDivCd.setValueField("commCd");
		creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		creEmymtDivCd.setEmptyText("--고용구분선택--");
		creEmymtDivCd.setSelectOnFocus(true);
		creEmymtDivCd.setStore(lscrEmymtDivCd);
		creEmymtDivCd.setName("creEmymtDivCd"); 
		//        creEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		//        creEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayCd =  se.getSelectedItem(); 
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					creDeptCd.getListView().fireEvent(Events.CheckChanged); 
					creBusinCd.setEnabled(true);
					creTypOccuCd.reset();
					creTypOccuCd.setEnabled(false);
					creDtilOccuInttnCd.reset();
					creDtilOccuInttnCd.setEnabled(false);
				} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {

					creBusinCd.reset();
					creBusinCd.setEnabled(false);  
					//20151130 추가 수정
					creDeptCd.getListView().fireEvent(Events.CheckChanged);
					if (gwtExtAuth.getEnableTypOccuCd()) {
						creTypOccuCd.setEnabled(true);
						creDtilOccuInttnCd.setEnabled(true); 
					} else {
						creTypOccuCd.setEnabled(false);
						creDtilOccuInttnCd.setEnabled(false);

					}


				} else {

				} 
			} 
		});

		lscrEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			    	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					checkPsnl0290Auth("creEmymtDivCd", lscrEmymtDivCd); 
				}
			}
		});
		lcSchCol03_1.add(creEmymtDivCd, new FormData("100%"));
		lcSchCol03.add(lcSchCol03_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));


		LayoutContainer lcSchCol03_2 = new LayoutContainer();
		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol03_2.setLayout(frmlytSch);

		creRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
		creRepbtyBusinDivCd.setForceSelection(true);
		creRepbtyBusinDivCd.setAllowBlank(false);
		creRepbtyBusinDivCd.setMinChars(1);
		creRepbtyBusinDivCd.setDisplayField("commCdNm");
		creRepbtyBusinDivCd.setValueField("commCd");
		creRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		creRepbtyBusinDivCd.setEmptyText("--호봉제--");
		creRepbtyBusinDivCd.setSelectOnFocus(true); 
		creRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		creRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		creRepbtyBusinDivCd.setStore(lscreRepbtyBusinDivCd);
		creRepbtyBusinDivCd.setLabelSeparator("");
		lscreRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  


			}
		});  
		lcSchCol03_2.add(creRepbtyBusinDivCd, new FormData("100%"));
		lcSchCol03_2.setBorders(false);
		lcSchCol03.add(lcSchCol03_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_14 = new LayoutContainer();

		FormLayout frmlytSch01_2 = new FormLayout();
		frmlytSch01_2.setLabelWidth(35);
		frmlytSch01_2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch01_2);


		creDeptCd = new MSFMultiComboBox<ModelData>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		creDeptCd.getStore().add(mDtalistcrDeptCd);
		//		creDeptCd.setWidth(100);
		creDeptCd.setFieldLabel("부서");
		creDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		creDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPsnl0290Auth("creDeptCd", lscrDeptCd); 
				}
			}
		});    

		creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
					if (creDeptCd.getListView().getChecked().size() > 0) {  
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));  
						List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
					}      

					//--------------------사업 불러 오는 함수 -------------------------------------------------
					lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					//--------------------사업 불러 오는 함수 -------------------------------------------------

					creBusinCd.setStore(lscrBusinCd); 
					creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
							//   creBusinCd.setValue(lscrBusinCd.getAt(0));  
						}
					});    


				} else  if ((creDeptCd.getListView().getChecked().size() >  0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

					//2015.11.30 권한 직종가져오기  추가 
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
					String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					sysComBass0320Dto.setDeptCd(strDeptCd);
					lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
					lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  

							mDtalistcrTypOccuCd = PersonalUtil.getTypOccuCdModelData(lscrTypOccuCd) ;  
							creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);

						}
					});  

				} 
			}  
		});  

		creDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				} 
			} 
		});                       

		layoutContainer_14.add(creDeptCd, new FormData("100%"));



		//직종 직종세처리 
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_211 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_211.setLayout(frmlytSch); 

		creDeptGpCd  =  new ComboBox<BaseModel>(); 
		creDeptGpCd.setName("creDeptGpCd");
		creDeptGpCd.setForceSelection(true);
		creDeptGpCd.setAllowBlank(false);
		creDeptGpCd.setMinChars(1);
		creDeptGpCd.setDisplayField("commCdNm");
		creDeptGpCd.setValueField("commCd");
		creDeptGpCd.setTriggerAction(TriggerAction.ALL);
		creDeptGpCd.setEmptyText("--그룹--");
		creDeptGpCd.setSelectOnFocus(true); 
		creDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		creDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		creDeptGpCd.setStore(lscreDeptGpCd);
		creDeptGpCd.setFieldLabel("직종"); 

		layoutContainer_211.add(creDeptGpCd, new FormData("100%")); 


		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		//       	frmlytSch.setLabelWidth(0); 
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_21.setLayout(frmlytSch);

		creTypOccuCd = new MSFMultiComboBox<ModelData>();
		creTypOccuCd.setName("creTypOccuCd"); 
		creTypOccuCd.setEmptyText("--직종선택--"); 
		creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
		//		creTypOccuCd.setWidth(100);
		creTypOccuCd.setHideLabel(true);
		creTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		creTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		creTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  

				EventType type = be.getType();
				if (type == Store.Add) { 
					//2015.11.30 추가 
					if (!gwtExtAuth.getEnableTypOccuCd()) {
						ModelData  mdSelect  = creTypOccuCd.getStore().getAt(0) ;     	                   
						creTypOccuCd.getListView().setChecked(mdSelect, true); 
						creTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));

					}  

					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			     		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					//checkPsnl0290Auth("creTypOccuCd", lscrTypOccuCd); 
				}
			}
		});     

		creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 

				//2015.11.30 추가 
				displayCreDtilOccuInttnCd();  

			}  
		});  

		creTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});

		//2015.11.30 추가 
		creTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
			@Override
			public void handleEvent(BaseEvent ce) {   

				displayCreDtilOccuInttnCd();  
			} 
		});    

		layoutContainer_21.add(creTypOccuCd, new FormData("100%")); 

		LayoutContainer lcSchRight = new LayoutContainer();
		frmlytSch = new FormLayout();  
		//       	frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		frmlytSch.setDefaultWidth(0);
		lcSchRight.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */  
		creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		creDtilOccuInttnCd.setName("creDtilOccuInttnCd"); 
		creDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
		creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
		creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
		//		creDtilOccuInttnCd.setWidth(100);
		creDtilOccuInttnCd.setHideLabel(true);
		creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {    
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else {

				}  
			} 
		});

		lcSchRight.add(creDtilOccuInttnCd, new FormData("100%")); 


		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));


		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setBorders(false);

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSch);


		creBusinCd = new ComboBox<BaseModel>();
		creBusinCd.setName("creBusinCd");
		creBusinCd.setFieldLabel("사업");
		creBusinCd.setForceSelection(true);
		creBusinCd.setMinChars(1);
		creBusinCd.setDisplayField("businNm");
		creBusinCd.setValueField("businCd");
		creBusinCd.setTriggerAction(TriggerAction.ALL);
		creBusinCd.setEmptyText("--사업선택--");
		creBusinCd.setSelectOnFocus(true);
		creBusinCd.setStore(lscrBusinCd); 
		creBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		creBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		creBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayCd =  se.getSelectedItem(); 
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					creBusinCd.setValue(lscrBusinCd.findModel("businCd",bmPayCd.get("businCd")) );
				}  
			} 
		});

		layoutContainer_15.add(creBusinCd, new FormData("100%")); 



		LayoutContainer lc41 = new LayoutContainer();
		FormLayout fl4 = new FormLayout();
		fl4.setLabelWidth(60);
		fl4.setLabelAlign(LabelAlign.RIGHT);
		lc41.setLayout(fl4);

		LayoutContainer lc2_1 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lc2_1_1 = new LayoutContainer();
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(60);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_1.setLayout(fl2_1);

		creWorkDayS = new DateField();
		creWorkDayS.setName("creWorkDayS");
		new DateFieldMask(creWorkDayS, "9999.99.99"); 
		creWorkDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creWorkDayS.setFieldLabel("기간");

		lc2_1_1.add(creWorkDayS, new FormData("100%"));

		LayoutContainer lc2_1_2 = new LayoutContainer();
		FormLayout fl2_2 = new FormLayout();
		fl2_2.setLabelWidth(7);
		fl2_2.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_2.setLayout(fl2_2);

		creWorkDayE = new DateField();
		creWorkDayE.setName("creWorkDayE");
		new DateFieldMask(creWorkDayE, "9999.99.99"); 
		creWorkDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creWorkDayE.setLabelSeparator("~");
		creWorkDayE.setReadOnly(true);
		creWorkDayE.setEnabled(true);
		lc2_1_2.add(creWorkDayE, new FormData("100%"));

		lc2_1.add(lc2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		lc2_1.add(lc2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		lc41.add(lc2_1, new FormData("100%"));

		LayoutContainer layoutContainer_16 = new LayoutContainer();
		layoutContainer_16.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_16_1 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_16_1.setLayout(frmlytSch);

		creHodyFixYn = new CheckBox();
		creHodyFixYn.setName("creHodyFixYn");
		creHodyFixYn.setBoxLabel("미확정");
		creHodyFixYn.setLabelSeparator("확정여부 : ");
		creHodyFixYn.setHideLabel(false);
		layoutContainer_16_1.add(creHodyFixYn, new FormData("100%"));

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_5.setLayout(frmlytSch);

		Button btnPsnl0290Create = new Button("휴가일수산정");
		btnPsnl0290Create.setWidth(55);
		btnPsnl0290Create.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				MessageBox.confirm("휴가 일수 산정", "휴가일수를 산정 하시겠습니까?</br>",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							if("".equals(MSFSharedUtils.getSelectedComboValue(creYear, "year"))){
								MessageBox.info("", "년도는 필수 입니다.", null);
							}else if("".equals(PersonalUtil.getConvertDateToString(creWorkDayS, "yyyyMMdd")) || "".equals(PersonalUtil.getConvertDateToString(creWorkDayE, "yyyyMMdd"))){
								MessageBox.info("", "기간은 필수 입니다.", null);
							}else if(GregorianCalendar.compareDate(creWorkDayS.getValue(), creWorkDayE.getValue()) < 0){
								MessageBox.info("", "기간 설정이 이상합니다. 확인하십시요.", null);  
							}else{
								reload();
							}

						}  
					}
				}); 				
			}
		}); 

		layoutContainer_5.add(btnPsnl0290Create, new FormData("100%"));
		layoutContainer_5.setBorders(false);

		lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));					// 년도 	
		lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));					// 단위기관
		lcSchCol.add(lcSchCol03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));					// 고용구분                

		layoutContainer_13.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));// 부서
		layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));		// 직종


		layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_16.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	

		lcSchCol3.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 사업
		lcSchCol3.add(lc41,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));						// 기간
		lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));		// 확정여부

		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setStyleAttribute("paddingTop", "10px");

		LayoutContainer layoutContainer2_1 = new LayoutContainer();	

		LayoutContainer layoutContainer2_2 = new LayoutContainer();

		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);

		Button btnBassSave = new Button("확정");
		btnBassSave.setWidth(150);
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				createPsnl0126ToPsnlP029001Data();
			}

		});

		btnBar.add(btnBassSave);
		layoutContainer2_2.add(btnBar);

		layoutContainer2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.6));
		layoutContainer2.add(layoutContainer2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));

		fldstNewFieldset.add(lcSchCol, new FormData("100%")); 
		fldstNewFieldset.add(layoutContainer_13, new FormData("100%")); 
		fldstNewFieldset.add(lcSchCol3, new FormData("100%")); 

		cpPsnlP029001.add(fldstNewFieldset);  
		cpPsnlP029001.add(createMsfGridForm(),new FormData("100%") );
		cpPsnlP029001.add(layoutContainer2);
	}

	private LayoutContainer createMsfGridForm() {
		// private void createMsfGridForm() {

		FieldSet fldstNewFieldset2 = new FieldSet();		
		fldstNewFieldset2.setHeadingHtml("산정결과");	

		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		layoutContainer2_1.setLayout(frmlytStd);		
		layoutContainer2_1.setBorders(false);

		ContentPanel cpGridPsnlP029001 = new ContentPanel();
		cpGridPsnlP029001.setBodyBorder(false);
		cpGridPsnlP029001.setHeaderVisible(false);
		cpGridPsnlP029001.setLayout(new FitLayout());
		cpGridPsnlP029001.setSize(735, 425);

		psnlP0126GridPanel = new MSFGridPanel(psnl0126Def, false, false, false, false, false);
		psnlP0126GridPanel.setBorders(false);
		psnlP0126GridPanel.setBodyBorder(true);
		psnlP0126GridPanel.setHeaderVisible(false);
		psnlP0126GridPanel.getBottomComponent().setVisible(false);

		cpGridPsnlP029001.add(psnlP0126GridPanel);

		layoutContainer2_1.add(cpGridPsnlP029001);

		fldstNewFieldset2.add(layoutContainer2_1, new FormData("100%"));

		return fldstNewFieldset2;
	}

	/**
	 * 휴가일수결과 저장
	 */
	private void createPsnl0126ToPsnlP029001Data() {

		MessageBox.confirm("휴가 일수 산정", "휴가일수산정 결과를 저장 하시겠습니까?</br> ",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					final Tracker tracker = new Tracker();
					tracker.setStatus(false);

					//휴가일수생성
					//Progress bar for upload
					final MessageBox box = MessageBox.wait("휴가일수산정", "휴가일수산정 중 입니다...", "휴가일수 산정 중...");
					final Timer t = new Timer()
					{
						public void run()
						{
							if (tracker.getStatus())
							{
								cancel();
								box.close();
							}
						}
					};
					t.scheduleRepeating(500);

					Iterator<BaseModel> itBm = psnlP0126GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

					List<Record>  lsRec  = new ArrayList<Record>();

					while(itBm.hasNext()) {
						Record rec  = new Record(itBm.next()); 
						lsRec.add(rec);
					} 

					Iterator<Record> iterRecords = lsRec.iterator() ;  
					List<Psnl0126DTO> listPsnl0126Dto = new ArrayList<Psnl0126DTO>(); 

					final int cnt = psnlP0126GridPanel.getGrid().getSelectionModel().getSelectedItems().size();

					while (iterRecords.hasNext()) {

						Record recData = (Record) iterRecords.next(); 
						BaseModel bmMapModel = (BaseModel)recData.getModel();

						Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  
						//			            Window.alert(""+MSFSharedUtils.allowNulls(bmMapModel.get("chnNumDys")));
						psnl0126Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
						psnl0126Dto.setHodyNumDysSysCalc(MSFSharedUtils.allowNulls(bmMapModel.get("chnNumDys")));
						psnl0126Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
						psnl0126Dto.setHodyApptnYr(MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnYr")));
						listPsnl0126Dto.add(psnl0126Dto);			
					}          
					psnlP029001Service.createPsnlP029001HolidayCount(listPsnl0126Dto ,new AsyncCallback<Long>()  {

						public void onFailure(Throwable caught) {
							tracker.setStatus(true);
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createPsnlP029001HolidayCount() : " + caught), null);
						}
						public void onSuccess(Long result) { 
							tracker.setStatus(true);
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
										"휴가일수산정 저장된 데이터가 없습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
										"휴가일수산정 저장이 완료되었습니다.", null);
								psnlP0126GridPanel.getMsfGrid().clearData();
							} 
						} 
					});

				}  
			}
		}); 
	}  

	/**
	 * 권한설정 처리 체크 
	 * AuthAction 
	 */
	private void checkPsnl0290Auth( String authAction, ListStore<BaseModel> bm) {   
		//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		// Boolean bool = gwtExtAuth.checkExtAuth(authAction, bm );
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			if (!maskTracker) { unmask(); }  
			authExecEnabled() ;


		}
	}

	private void authExecEnabled() { 
		//------------------
		//----------------------------------------------------
		Field<?>[] fldArrField = {crePayrMangDeptCd, creEmymtDivCd, creDeptCd, creTypOccuCd, creDtilOccuInttnCd, creBusinCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);
		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 

		creYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year"))) {
			setInitDate();
		}  
		creDeptCd.getListView().fireEvent(Events.CheckChanged); 

	}

	//날짜계산
	private void setInitDate() {

		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;

		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set (Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear, "year")), monthS -1, 1);
		creWorkDayS.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  

		Calendar  intieCal =   Calendar.getInstance();
		intieCal.set (Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear,"year")), monthE - 1, maxDays );
		creWorkDayE.setValue(intieCal.getTime());

	}
	private void  displayCreDtilOccuInttnCd() {

		if ((creTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {


			List<ModelData> mdDeptCdSelect =  creDeptCd.getListView().getChecked();  
			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);

			List<ModelData> mdListSelect =  creTypOccuCd.getListView().getChecked();
			String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 

			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {

				lscrDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 

				lscrDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistcrDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lscrDtilOccuInttnCd) ;

						creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);

						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = creDtilOccuInttnCd.getStore().getAt(0) ;

							creDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							creDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
						} 
					}
				});    

			} 

		} else {

		}   
	}

	private void initLoad() {       
		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 

		authMapDef.put("creYear",Boolean.FALSE);  
		authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
		authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
		authMapDef.put("creDeptCd",Boolean.FALSE); 
		// authMapDef.put("creTypOccuCd",Boolean.FALSE);


		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			//권한 검색조건처리를 위해 추가된 부분 
			mask("[화면로딩] 초기화 진행 중!");
		}
		tmMask.scheduleRepeating(5000);
	}  
	public void reload() {
		// TODO Auto-generated method stub
		if("".equals(MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"))){
			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				return;
			} 
		} 
		IColumnFilter filters = null;
		psnlP0126GridPanel.getTableDef().setTableColumnFilters(filters);

		psnlP0126GridPanel.getTableDef().addColumnFilter("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(creYear, "year"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnlP0126GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnlP0126GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lscrDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		psnlP0126GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);

		String strTypOccuCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		psnlP0126GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 

		String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		psnlP0126GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		psnlP0126GridPanel.getTableDef().addColumnFilter("hodyBgnnDt", PersonalUtil.getConvertDateToString(creWorkDayS, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnlP0126GridPanel.getTableDef().addColumnFilter("hodyEndDt", PersonalUtil.getConvertDateToString(creWorkDayE, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS);

		psnlP0126GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnlP0126GridPanel.getTableDef().addColumnFilter("hodyFixYn", MSFSharedUtils.allowNulls(creHodyFixYn.getValue()?"Y":"N"), SimpleColumnFilter.OPERATOR_EQUALS);  
		psnlP0126GridPanel.reload();
	}

	final Timer tmMask = new Timer()
	{
		public void run()
		{
			// if (maskTracker)
			// { 
			if (lscrEmymtDivCd.getCount() > 0 ) {

				cancel();
				unmask(); 
				authExecEnabled() ;
				maskTracker  = true;

			} else {
				tmMask.scheduleRepeating(2000);
			}
			// }
		}
	};

	class Tracker 
	{
		public boolean status = false;
		public boolean getStatus(){return status;}
		public void setStatus(boolean stat){status = stat;}
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
