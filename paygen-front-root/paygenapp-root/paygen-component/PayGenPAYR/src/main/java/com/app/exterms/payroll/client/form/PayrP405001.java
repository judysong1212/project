package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.service.PayrP405001Service;
import com.app.exterms.payroll.client.service.PayrP405001ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PayrP405001  extends MSFFormPanel { 
	
	
	private  ContentPanel cpPayrP405001; 

//	private ListStore<BaseModel> storeCat;
//	private AdminServiceAsync adminService = AdminService.Util.getInstance();
//	private HiddenField<String> categoryHidden;
//	private HiddenField<String> id;
//	private TextField<String> title;
//	private TextField<String> iconcls;
//	private TextField<String> thumbnail;
//	private TextField<String> qtip;
//	private TextField<String> screen;
//	private TextField<String> ord;
//	private TextField<String> name;
//	private CheckBox seAdmin;
//	private ComboBox<BaseModel> cat;
	
	
	private HiddenField<String>	dpobCd;									/**  column 사업장코드 : dpobCd */
	    
	private ComboBox<BaseModel> crePayYr_S; 					// 시작 년
	private ComboBox<BaseModel> crePayMonth_S; 					// 시작 월
	private ComboBox<BaseModel> crePayYr_E; 					// 종료 년
	private ComboBox<BaseModel> crePayMonth_E;					// 종료 월
	
	private ComboBox<BaseModel> creRflctnBgnnDt; 				// 반영시작일자
	private ComboBox<BaseModel> creRflctnEndDt;					// 반영종료일자

	private ComboBox<BaseModel> crePayCd; 						// 급여구분
//	private DateField pymtDt;			 						// 지급기준일자
	private ComboBox<BaseModel> pymtDt;			 				// 지급기준일자

	private ComboBox<BaseModel> crePayrMangDeptCd; 				// 단위기관
	private ComboBox<BaseModel> creEmymtDivCd; 					// 고용구분
	private ComboBox<BaseModel> creRepbtyBusinDivCd; 			// 호봉제구분코드  
	private ComboBox<BaseModel> creMangeDeptCd; 				// 관리부서 
	private ComboBox<BaseModel> creDeptCd; 						// 부서
//	private TextField<String> srhDeptNm; 							// 부서명
//    private TextField<String> creDeptCd; 							// 부서코드
//    private TextField<String> srhDeptNm; 							// 부서명  
//    private Button btncreDeptCd;
	private ComboBox<BaseModel> creDeptGpCd; 						//부서직종그룹코드
	private ComboBox<BaseModel> creTypOccuCd;						// 직종
	private ComboBox<BaseModel> creDtilOccuInttnCd; 				// 직종세
	private ComboBox<BaseModel> creBusinCd; 						// 사업
	
    private CheckBox overYn;									// 차월지급여부
	
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	     
	private boolean mutilCombo = false;
	private boolean statCheck = false;
	    
	private ActionDatabase actionDatabase;
	private MSFPanel caller;
//	private Boolean lettura;
	public FormBinding formBinding;
	private Boolean emptyCheck = false ;
	
	private ListStore<BaseModel> lsDays 				= new ListStore<BaseModel>();	// 일자	
	private ListStore<BaseModel> lsPayYrStore		 	= new ListStore<BaseModel>();	// 년도 
	private ListStore<BaseModel> lsPayMonth 			= new ListStore<BaseModel>();	// 급여월   
	private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	// 고용구분 
	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	// 호봉제구분코드 
	private ListStore<BaseModel> lscreMangeDeptCd 		= new ListStore<BaseModel>();	// 관리부서
	private ListStore<BaseModel> lsDeptCd  				= new ListStore<BaseModel>();	// 부서콤보
	private ListStore<BaseModel> lsBusinCd  			= new ListStore<BaseModel>();	// 사업콤보   
	private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>();	// 단위기관 
	private ListStore<BaseModel> lsPayCd 				= new ListStore<BaseModel>(); 	// 급여구분
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	// 부서직종그룹코드
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	// 직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	// 직종세
	
	
	private PrgmComBass0300DTO sysComBass0300Dto; 		// 공통코드 dto
	private PrgmComBass0500DTO sysComBass0500Dto; 		// 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; 		// 단위기관
	private SysCoCalendarDTO  msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; 		// 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; 		// 직종
	private PrgmComBass0400DTO sysComBass0400Dto; 		// 부서
	
	
	// -------------- 서비스 호출 시작 --------------
	private PayrP405001ServiceAsync payrP405001Service = PayrP405001Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
    /**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
     // 검색 폼 바인딩 처리 함수 
    // private AuthAction authAction;  
		//  private Boolean boolChkAuth;  
		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkPayrP405001Auth(String authAction, ListStore<BaseModel> bm) {
		// MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중");
		// 2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())&& gwtExtAuth.checkExtAuth(authAction, bm)) {

			authExecEnabled();
			gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
		}
	}

	 private void authExecEnabled() { 
	  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      * 권한설정을 위한 콤보처리를 위한 메서드 시작 
      * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
      ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	     Field<?>[] fldArrField = {creDeptCd,crePayrMangDeptCd,creEmymtDivCd,creTypOccuCd,creDtilOccuInttnCd,creBusinCd}; 
	     gwtAuthorization.formAuthFieldConfig(fldArrField);
	     
	     crePayYr_S.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
//	     crePayYr_S.fireEvent(Events.Change);
	     crePayMonth_S.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	     
	     crePayYr_E.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	     crePayMonth_E.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	     
	     crePayCd.setValue(lsPayCd.getAt(0));
	     
	     setInitDate();
	     
	  //   gwtAuthorization.formAuthFieldConfig(crePayrMangDeptCd,creEmymtDivCd,strArrDeptCd,creTypOccuCd,creDtilOccuInttnCd,creBusinCd);
//            gwtAuthorization.formAuthPopConfig(plFrmPayr4050, "crePayrMangDeptCd","creEmymtDivCd",strArrDeptCd,"creTypOccuCd","creDtilOccuInttnCd","creBusinCd");
//           gwtAuthorization.formAuthBtnConfig(btncreDeptCd); 
       //GWTAuthorization.formAuthConfig(plFrmPayr4050, "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd");
     /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      * 권한설정을 위한 콤보처리를 위한 메서드 종료
      ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//       creDeptCd.fireEvent(Events.Add); 
	 }
	 
	final Timer tmMask = new Timer() {
		public void run() {
			if (lsEmymtDivCd.getCount() > 0 && lsPayYrStore.getCount() > 0) {

				cancel();
				unmask();
				authExecEnabled();
				maskTracker = true;

			} else {
				authExecEnabled();
				tmMask.scheduleRepeating(2000);
			}
		}
	};
	     
	private void initLoad() { 

		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();
		    
		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();
		authMapDef.put("PayYr", Boolean.FALSE);
		authMapDef.put("PayMonth", Boolean.FALSE);
		authMapDef.put("crePayCd", Boolean.FALSE);
		authMapDef.put("PayrMangDeptCd", Boolean.FALSE);
		authMapDef.put("EmymtDivCd", Boolean.FALSE);
		// authMapDef.put("TypOccuCd",Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			// 권한 검색조건처리를 위해 추가된 부분
			mask("[화면로딩] 초기화 진행 중!");
		}
	    
		tmMask.scheduleRepeating(5000);
	}
	 
       
    /**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/	

	public PayrP405001(ActionDatabase actionDatabase, MSFPanel caller) {
		
		super();
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		FormLayout layout = new FormLayout();
		layout.setDefaultWidth(300);
		layout.setLabelWidth(100);
		this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
//		this.lettura = actionDatabase.name().equalsIgnoreCase("DELETE");
		
		
		//콤보 권한초기화
		initLoad(); 
		
		cpPayrP405001 = new ContentPanel();
		
		Payr0250DTO payr0250Dto = new Payr0250DTO();
		payr0250Dto.setJobYrMnth(DateTimeFormat.getFormat("yyyy").format(new Date()) + DateTimeFormat.getFormat("MM").format(new Date()));
		
		payrP405001Service.selectCoCalendar(payr0250Dto, new AsyncCallback<List<BaseModel>>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectCoCalendar(" + " 로드 중 오류 발생." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(List<BaseModel> result) {
				lsDays.add(result);
				
				// TODO Auto-generated method stub
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + result + " " + "건이 생성되었습니다. 데이터를 확인해 주세요.", null);
				
			}
        });
		

		createSearchForm(); // 기본정보 필드를 적용
//		createMsfGridForm(); // 그리드필드
		   
	           
		cpPayrP405001.setBodyBorder(false);
		cpPayrP405001.setBorders(false);
		cpPayrP405001.setHeaderVisible(false);
		//엣지변환
		//cpPayrP405001.setSize("490px", "290px");
		cpPayrP405001.setSize("490px", "320px");

		this.add(cpPayrP405001);
		formBinding = new FormBinding(this, true);

		//엣지변환
		//this.setSize("520px", "320px");
		this.setSize("520px", "350px");

	    }
	
	
	/**
	 * 기본정보 설정
	 */
	private void createSearchForm() {
		
	     sysComBass0150Dto = new PrgmComBass0150DTO();
		 sysComBass0300Dto = new PrgmComBass0300DTO();
		 sysComBass0500Dto = new PrgmComBass0500DTO();
		 sysComBass0350Dto = new PrgmComBass0350DTO();
		 msfCoCalendarDto   = new SysCoCalendarDTO();
		 sysComBass0320Dto = new PrgmComBass0320DTO();
		 sysComBass0400Dto = new PrgmComBass0400DTO();
		 
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		 lscreMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		 
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //급여구분 
		 sysComBass0300Dto.setRpsttvCd("B015");
		 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //호봉
		 sysComBass0300Dto.setRpsttvCd("A048");
		 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------		 
		 
		 
		 //--------------------급여년도 불러 오는 함수 ------------------------------------------------
		 lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //월 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		//--------------------부서 코드 불러 오는 함수 --------------------------------------------------
	     sysComBass0400Dto.setDeptDspyYn("Y");
	     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	     
	     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	     //--------------------부서 코드 불러 오는 함수 --------------------------------------------------
	     
	     //--------------------직종 코드 불러 오는 함수 --------------------------------------------------
	     lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
	     //--------------------직종 코드 불러 오는 함수 --------------------------------------------------
	     
	     //--------------------직종 코드 불러 오는 함수 --------------------------------------------------
	     lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	     //--------------------직종 코드 불러 오는 함수 --------------------------------------------------
	     
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpPayrP405001.add(dpobCd);
		
		
		LayoutContainer lc = new LayoutContainer();
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_1_Y = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc1_1_Y.setLayout(frmlytSch);
	    
	    crePayYr_S = new ComboBox<BaseModel>();
	    crePayYr_S.setName("crePayYr_S");
	    crePayYr_S.setForceSelection(true);
	    crePayYr_S.setMinChars(1);
	    crePayYr_S.setDisplayField("yearDisp");
	    crePayYr_S.setValueField("year");
	    crePayYr_S.setTriggerAction(TriggerAction.ALL);
	   // srhPayYr.setEmptyText("--년도선택--");
	    crePayYr_S.setSelectOnFocus(true); 
	    crePayYr_S.setReadOnly(false);
	    crePayYr_S.setEnabled(true); 
	    crePayYr_S.setStore(lsPayYrStore);
	    crePayYr_S.setFieldLabel("생성년월구간"); 
	    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
		      			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkPayrP405001Auth("srhPayYr", lsPayYrStore); 
				}
			}
		});
	    crePayYr_S.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		           BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		               
		        	   if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
	                       
	//                       if (creDeptCd.getListView().getChecked().size() > 0) {  
		        		   		sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(creDeptCd,"deptCd"));
		        		   		sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year"));
	//                           List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
	//                           sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	//                       }      
	                           //--------------------사업 불러 오는 함수 -------------------------------------------------
	                           lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	                           //--------------------사업 불러 오는 함수 -------------------------------------------------
	                           creBusinCd.setStore(lsBusinCd); 
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
	    crePayYr_S.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		           BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		               
		       		Payr0250DTO payr0250Dto = new Payr0250DTO();
		    		payr0250Dto.setJobYrMnth(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year") 
		    									+ MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month"));
		    		
		    		payrP405001Service.selectCoCalendar(payr0250Dto, new AsyncCallback<List<BaseModel>>()  {
		    			@Override
		    			public void onFailure(Throwable caught) {
		    				// TODO Auto-generated method stub
		    				
		    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		    						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectCoCalendar(" + " 로드 중 오류 발생." + ") : " + caught), null);
		    			}

		    			@Override
		    			public void onSuccess(List<BaseModel> result) {
		    				
		    				// -- 초기화 -- 
		    				pymtDt.setStore(new ListStore<BaseModel>());
							pymtDt.setValue(new BaseModel());
							lsDays.removeAll();
	    					// -- 초기화 -- 
		    				
		    				lsDays.add(result);
		    				pymtDt.setStore(lsDays);
		    				
		    				
			                // 기간제일 경우
			                int maxDays = 0;
					 		   
				  			Calendar  intiCal =  Calendar.getInstance(); 
				  			intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month")) - 1, 1 );
				  			maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);
				  			
				  			String dayE = String.valueOf(maxDays);
							PayrUtils.setSelectedComboValue(creRflctnEndDt, dayE, "commCd");
		    				
		    			}
		            });
		           }
	          }
	    });
	    lc1_1_Y.add(crePayYr_S, new FormData("100%"));
		
		
	    lc1_1.add(lc1_1_Y,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		
		
		LayoutContainer lc1_1_M = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc1_1_M.setLayout(frmlytSch);
	    
	    /** column 지급년월 : Mnth */ 
	    crePayMonth_S = new ComboBox<BaseModel>();
	    crePayMonth_S.setName("crePayMonth_S");
	    crePayMonth_S.setForceSelection(true);
	    crePayMonth_S.setMinChars(1);
	    crePayMonth_S.setDisplayField("monthDisp");
	    crePayMonth_S.setValueField("month");
	    crePayMonth_S.setTriggerAction(TriggerAction.ALL);
	   // srhPayMonth.setEmptyText("--월선택--");
	    crePayMonth_S.setSelectOnFocus(true); 
	    crePayMonth_S.setReadOnly(false);
	    crePayMonth_S.setEnabled(true); 
	    crePayMonth_S.setStore(lsPayMonth);
	    crePayMonth_S.setHideLabel(true);  
	    lsPayMonth.addStoreListener( new StoreListener<BaseModel>() {   
	    	public void handleEvent(StoreEvent<BaseModel> be) {  
	    		EventType type = be.getType();
	    		if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkPayrP405001Auth("crePayMonth_S", lsPayMonth); 
	    		}
            }
        });
	    crePayMonth_S.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		           BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		               
		       		Payr0250DTO payr0250Dto = new Payr0250DTO();
		    		payr0250Dto.setJobYrMnth(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year") 
		    									+ MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month"));
		    		
		    		payrP405001Service.selectCoCalendar(payr0250Dto, new AsyncCallback<List<BaseModel>>()  {
		    			@Override
		    			public void onFailure(Throwable caught) {
		    				// TODO Auto-generated method stub
		    				
		    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		    						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectCoCalendar(" + " 로드 중 오류 발생." + ") : " + caught), null);
		    			}

		    			@Override
		    			public void onSuccess(List<BaseModel> result) {
		    				
		    				// -- 초기화 -- 
		    				pymtDt.setStore(new ListStore<BaseModel>());
							pymtDt.setValue(new BaseModel());
							lsDays.removeAll();
	    					// -- 초기화 -- 
							
		    				lsDays.add(result);
		    				pymtDt.setStore(lsDays);
		    				
			                // 기간제일 경우
			                int maxDays = 0;
					 		   
				  			Calendar  intiCal =  Calendar.getInstance(); 
				  			intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month")) - 1, 1 );
				  			maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);
				  			
				  			String dayE = String.valueOf(maxDays);
							PayrUtils.setSelectedComboValue(creRflctnEndDt, dayE, "commCd");
		    				
		    			}
		            });
		           }
	          }
	    });
	    lc1_1_M.add(crePayMonth_S, new FormData("100%"));
	    lc1_1.add(lc1_1_M,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    lc1.add(lc1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		LayoutContainer lc1_2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_2_Y = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(10); 
	    frmlytSch.setLabelAlign(LabelAlign.LEFT); 
	    lc1_2_Y.setLayout(frmlytSch);
	    
	    crePayYr_E = new ComboBox<BaseModel>();
	    crePayYr_E.setName("crePayYr_E");
	    crePayYr_E.setForceSelection(true);
	    crePayYr_E.setMinChars(1);
	    crePayYr_E.setDisplayField("yearDisp");
	    crePayYr_E.setValueField("year");
	    crePayYr_E.setTriggerAction(TriggerAction.ALL);
	   // srhPayYr.setEmptyText("--년도선택--");
	    crePayYr_E.setSelectOnFocus(true); 
	    crePayYr_E.setReadOnly(false);
	    crePayYr_E.setEnabled(true); 
	    crePayYr_E.setStore(lsPayYrStore);
	    crePayYr_E.setLabelSeparator("~");
//	    crePayYr_S.setFieldLabel("~"); 
	    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
		      			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkPayrP405001Auth("crePayYr_E", lsPayYrStore); 
				}
			}
		});
//	    crePayYr_E.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//		           BaseModel bmPayYr =  se.getSelectedItem(); 
//		           if (bmPayYr != null) {
//		               
//		        	   if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
//	                       
//	//                       if (creDeptCd.getListView().getChecked().size() > 0) {  
//	                          
//	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"payYr"));
//	//                           List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
//	//                           sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//	//                       }      
//	                    
//	                           //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                           lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                           //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                           creBusinCd.setStore(lsBusinCd); 
//	                           creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                        	   	public void handleEvent(StoreEvent<BaseModel> be) {  
//	                              //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                        	   	}
//	                           });
//		        	   } else {
//	                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
//	                      // return;
//		        	   }
//		           }
//	          }
//	    });
	    lc1_2_Y.add(crePayYr_E, new FormData("100%"));
	    lc1_2.add(lc1_2_Y,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		
		
		LayoutContainer lc1_2_M = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc1_2_M.setLayout(frmlytSch);
	    
	    /** column 지급년월 : Mnth */ 
	    crePayMonth_E = new ComboBox<BaseModel>();
	    crePayMonth_E.setName("crePayMonth_E");
	    crePayMonth_E.setForceSelection(true);
	    crePayMonth_E.setMinChars(1);
	    crePayMonth_E.setDisplayField("monthDisp");
	    crePayMonth_E.setValueField("month");
	    crePayMonth_E.setTriggerAction(TriggerAction.ALL);
	   // srhPayMonth.setEmptyText("--월선택--");
	    crePayMonth_E.setSelectOnFocus(true); 
	    crePayMonth_E.setReadOnly(false);
	    crePayMonth_E.setEnabled(true); 
	    crePayMonth_E.setStore(lsPayMonth);
	    crePayMonth_E.setHideLabel(true);  
	    lsPayMonth.addStoreListener( new StoreListener<BaseModel>() {   
	    	public void handleEvent(StoreEvent<BaseModel> be) {  
	    		EventType type = be.getType();
	    		if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkPayrP405001Auth("crePayMonth_E", lsPayMonth); 
	    		}
            }
        });    
	    lc1_2_M.add(crePayMonth_E, new FormData("100%"));
	    lc1_2.add(lc1_2_M,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));;
	    
	    lc1.add(lc1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));;
		
		
		LayoutContainer lc2 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc2.setLayout(frmlytSch);
	    
	    crePayCd =  new ComboBox<BaseModel>(); 
	    crePayCd.setName("crePayCd");
	    crePayCd.setForceSelection(true);
	    crePayCd.setMinChars(1);
	    crePayCd.setDisplayField("commCdNm");
	    crePayCd.setValueField("commCd");
	    crePayCd.setTriggerAction(TriggerAction.ALL);
	    crePayCd.setEmptyText("--급여구분선택--");
	    crePayCd.setSelectOnFocus(true); 
	    crePayCd.setReadOnly(false);
	    crePayCd.setEnabled(true); 
	    crePayCd.setStore(lsPayCd);
	    crePayCd.setFieldLabel("급여구분");
	    crePayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
 
            	checkPayrP405001Auth("crePayCd",lsPayCd);   
            }
        });  
        
	    lc2.add(crePayCd, new FormData("50%"));
		
		LayoutContainer lc3 = new LayoutContainer(new ColumnLayout());
		
//	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(80); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	    lc3.setLayout(frmlytSch);
		
		
		LayoutContainer lc3_01 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc3_01.setLayout(frmlytSch);
	    
	    pymtDt =  new ComboBox<BaseModel>(); 
	    pymtDt.setName("pymtDt");
	    pymtDt.setForceSelection(true);
	    pymtDt.setMinChars(1);
	    pymtDt.setDisplayField("commCdNm");
	    pymtDt.setValueField("commCd");
	    pymtDt.setTriggerAction(TriggerAction.ALL);
	    pymtDt.setEmptyText("--지급기준일선택--");
	    pymtDt.setSelectOnFocus(true); 
	    pymtDt.setReadOnly(false);
	    pymtDt.setStore(lsDays);
	    pymtDt.setFieldLabel("지급기준일");
	    lc3_01.add(pymtDt, new FormData("100%"));
		
//	    lc3.add(pymtDt, new FormData("30%"));
	    lc3.add(lc3_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    
	    
		LayoutContainer lc3_02 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc3_02.setLayout(frmlytSch);
	    
	    
	    overYn = new CheckBox();
	    overYn.setHideLabel(true);
	    overYn.setValue(false);
	    overYn.setBoxLabel("차월지급여부");
	    overYn.setHideLabel(true);
	    overYn.setValueAttribute("Y");
	    
	    lc3_02.add(overYn, new FormData("100%"));
	    lc3.add(lc3_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    
		
		LayoutContainer lc4 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc4.setLayout(frmlytSch);
	    
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
	    crePayrMangDeptCd.setStore(lsPayrMangDeptCd);  
	    crePayrMangDeptCd.setFieldLabel("단위기관"); 
	    lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   checkPayrP405001Auth("crePayrMangDeptCd", lsPayrMangDeptCd );   
                	 }

                
            }
        });    
	    crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	         
//  	    	    sysComBass0400Dto.setDeptDspyYn("Y");
//                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
//                //--------------------부서 불러 오는 함수 ------------------------------------------------
//                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//                //--------------------부서 불러 오는 함수 ------------------------------------------------
  	    	} 
  	    });
	    lc4.add(crePayrMangDeptCd, new FormData("50%"));
		
		
		LayoutContainer lc5 = new LayoutContainer(new ColumnLayout());
		
//	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(70); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	    lc5.setLayout(frmlytSch);
		
		LayoutContainer layoutContainer_10 = new LayoutContainer();
		  //  lcSchCol.add(layoutContainer_10);
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);

		creEmymtDivCd = new ComboBox<BaseModel>();
		creEmymtDivCd.setName("creEmymtDivCd");
		creEmymtDivCd.setForceSelection(true);
		creEmymtDivCd.setAllowBlank(true);
		creEmymtDivCd.setMinChars(1);
		creEmymtDivCd.setDisplayField("commCdNm");
		creEmymtDivCd.setValueField("commCd");
		creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		creEmymtDivCd.setEmptyText("--고용구분선택--");
		creEmymtDivCd.setSelectOnFocus(true);
		creEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		creEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		creEmymtDivCd.setStore(lsEmymtDivCd);
		creEmymtDivCd.setFieldLabel("고용구분");
		lsEmymtDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서
					 * : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkPayrP405001Auth("EmymtDivCd", lsEmymtDivCd);
				}
			}
		});
		creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	  	  		BaseModel bmPayCd =  se.getSelectedItem(); 
	  	  		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	  	  			creDeptCd.fireEvent(Events.Add); 
	  	    	    creBusinCd.setEnabled(true);
	  	    	    creTypOccuCd.reset();
	                creTypOccuCd.setEnabled(false);
	                creDtilOccuInttnCd.reset();
	                creDtilOccuInttnCd.setEnabled(false);
	                
	                
	                // 기간제일 경우
	                int maxDays = 0;
			 		   
		  			Calendar  intiCal =  Calendar.getInstance(); 
		  			intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month")) - 1, 1 );
		  			maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);
		  			
		  			String dayE = String.valueOf(maxDays);
	  	  			
	  	  			
	  	  			PayrUtils.setSelectedComboValue(pymtDt, dayE, "commCd");
	                
	  	  		} else {
	  	  			creBusinCd.reset();
	  	  			creBusinCd.setEnabled(false);  
	  	  			
	  	  			//20151130 추가 수정
	  	  			creDeptCd.fireEvent(Events.Add); 
	  	  			
	  	  			if (gwtExtAuth.getEnableTypOccuCd()) {
	  	  				creTypOccuCd.setEnabled(true);
	  	  				creDtilOccuInttnCd.setEnabled(true); 
	  	  			} else {
	  	  				creTypOccuCd.setEnabled(false);
	  	  				creDtilOccuInttnCd.setEnabled(false);
	  	  				
						creRepbtyBusinDivCd.reset();
						creRepbtyBusinDivCd.setEnabled(false);

						creDeptGpCd.reset();
						creDeptGpCd.setEnabled(false);
	  	  			}
	  	  			
	  	  			// 공무직 일 경우 지급기준일 20일
	    			PayrUtils.setSelectedComboValue(pymtDt, "20", "commCd");
	  	  			
		  	  		
	  	  		}  
			} 
		});
		layoutContainer_10.add(creEmymtDivCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);
		    
		    
		LayoutContainer layoutContainer_101 = new LayoutContainer();
		  //  lcSchCol.add(layoutContainer_101);
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_101.setLayout(frmlytSch);
		    
		creRepbtyBusinDivCd = new ComboBox<BaseModel>();
		creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
		creRepbtyBusinDivCd.setForceSelection(true);
		creRepbtyBusinDivCd.setAllowBlank(true);
		creRepbtyBusinDivCd.setMinChars(1);
		creRepbtyBusinDivCd.setDisplayField("commCdNm");
		creRepbtyBusinDivCd.setValueField("commCd");
		creRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		creRepbtyBusinDivCd.setEmptyText("--호봉제--");
		creRepbtyBusinDivCd.setHideLabel(true);
		creRepbtyBusinDivCd.setSelectOnFocus(true);
		creRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		creRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		creRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
		creRepbtyBusinDivCd.setLabelSeparator("");
		// creRepbtyBusinDivCd.setFieldLabel("고용구분");  
		lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

//	            	  EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//	                	 }  
	              
			}
		}); 

		layoutContainer_101.add(creRepbtyBusinDivCd, new FormData("100%"));
		layoutContainer_101.setBorders(false);
		 
		 
		lc5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
		lc5.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
//		
//	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(70); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	    lc5.setLayout(frmlytSch);
//	    
//	    creEmymtDivCd =  new ComboBox<BaseModel>(); 
//        creEmymtDivCd.setName("creEmymtDivCd");
//        creEmymtDivCd.setForceSelection(true);
//        creEmymtDivCd.setAllowBlank(false);
//        creEmymtDivCd.setMinChars(1);
//        creEmymtDivCd.setDisplayField("commCdNm");
//        creEmymtDivCd.setValueField("commCd");
//        creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//        creEmymtDivCd.setEmptyText("--고용구분선택--");
//        creEmymtDivCd.setSelectOnFocus(true); 
//        creEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//        creEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
//        creEmymtDivCd.setStore(lsEmymtDivCd);
//        creEmymtDivCd.setFieldLabel("고용구분");  
//	    lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//	    	public void handleEvent(StoreEvent<BaseModel> be) {  
//	    		EventType type = be.getType();
//	    		if (type == Store.Add) { 
//	    			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	    			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	    			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	    			 * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
//		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	    				checkPayrP405001Auth("creEmymtDivCd", lsEmymtDivCd); 
//	    		}  
//	    	}
//        });  
//	    creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	  	    	 BaseModel bmPayCd =  se.getSelectedItem(); 
//	  	    	 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//	  	    	    creDeptCd.fireEvent(Events.Add); 
//	  	    	    creBusinCd.setEnabled(true);
//	  	    	    creTypOccuCd.reset();
//	                creTypOccuCd.setEnabled(false);
//	                creDtilOccuInttnCd.reset();
//	                creDtilOccuInttnCd.setEnabled(false);
//	             } else {
//	                 creBusinCd.reset();
//	                 creBusinCd.setEnabled(false);  
//	                 //20151130 추가 수정
//	                 creDeptCd.fireEvent(Events.Add); 
//	                 if (gwtExtAuth.getEnableTypOccuCd()) {
//	                	 creTypOccuCd.setEnabled(true);
//	                     creDtilOccuInttnCd.setEnabled(true); 
//	                 } else {
//	                	 creTypOccuCd.setEnabled(false);
//	                     creDtilOccuInttnCd.setEnabled(false);
//	                 }
//	             }
//	    	}
//		});
//	    lc5.add(creEmymtDivCd, new FormData("50%"));
		
		
		LayoutContainer lc11 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc11.setLayout(frmlytSch);
	    
		creMangeDeptCd = new ComboBox<BaseModel>();
		creMangeDeptCd.setName("creMangeDeptCd"); 
		creMangeDeptCd.setEmptyText("--관리부서선택--");
		creMangeDeptCd.setDisplayField("deptNmRtchnt");
		creMangeDeptCd.setStore(lscreMangeDeptCd); 
		creMangeDeptCd.setWidth(100);
		creMangeDeptCd.setFieldLabel("관리부서");
		creMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		creMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	EventType type = be.getType();
            	if (type == Store.Add) { 
            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
            		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
            	}
            }
        });  
		creMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	    		sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd")); 
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd"))); 
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		
  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//  	    				mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
//  	    				creDeptCd.getInitStore().add(mDtalistcrDeptCd);
  	    				creDeptCd.setStore(lsDeptCd);
  	    			}
  	    		});  
  	    		emptyCheck = true;
	    	} 
	    });
		creMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
            	
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
                	
                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(creMangeDeptCd.getValue()))) {
	                	sysComBass0400Dto = new PrgmComBass0400DTO();
	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));  
	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd")); 
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    	  lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		
	      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//	      	    				mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
//	      	    				creDeptCd.getInitStore().add(mDtalistcrDeptCd);
	      	    				creDeptCd.setStore(lsDeptCd);
	      	    			} 
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
		lc11.add(creMangeDeptCd, new FormData("50%"));
	    
	    
		
		
		LayoutContainer lc6 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc6.setLayout(frmlytSch);
	    
	    creDeptCd = new ComboBox<BaseModel>();
	    creDeptCd.setName("creDeptCd");
		creDeptCd.setFieldLabel("부서명");
		creDeptCd.setForceSelection(true);
		creDeptCd.setMinChars(1);
		creDeptCd.setDisplayField("deptNmRtchnt");
		creDeptCd.setValueField("deptCd");
		creDeptCd.setTriggerAction(TriggerAction.ALL);
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.setSelectOnFocus(true);
//		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creDeptCd.setStore(lsDeptCd);
		creDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		creDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
            //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	           BaseModel bmDeptCd =  se.getSelectedItem(); 
	           if (bmDeptCd != null) {
	        	   if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
                     
//                       if (creDeptCd.getListView().getChecked().size() > 0) {  
                        
	        		   	sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(creDeptCd,"deptCd"));
       		   			sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year"));
//                           List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
//                           sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//                       }      
                         //--------------------사업 불러 오는 함수 -------------------------------------------------
                         lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                         //--------------------사업 불러 오는 함수 -------------------------------------------------
                         creBusinCd.setStore(lsBusinCd); 
                         creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                      	   	public void handleEvent(StoreEvent<BaseModel> be) {  
                            //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                      	   	}
                         });
	        	   } else if(MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
	        		   
						//2015.11.30 권한 직종가져오기  추가 
						sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		         		   
						String strDeptCd = PayrUtils.getSelectedComboValue(creDeptCd, "deptCd");  
						sysComBass0320Dto.setDeptCd(strDeptCd);
		         		   
						lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
						
						creTypOccuCd.setStore(lsTypOccuCd); 
	        		  
	        	   } else {
                    // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                    //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
                    // return;
	        	   }
	           }
        	}
		});
		creDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    			checkPayrP405001Auth("creDeptCd", lsDeptCd); 
				}   
			}
		});   
		lc6.add(creDeptCd, new FormData("50%"));
		
		LayoutContainer lc7 = new LayoutContainer(new ColumnLayout());
		
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(80); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_211.setLayout(frmlytSch); 
       
        creDeptGpCd  =  new ComboBox<BaseModel>(); 
        creDeptGpCd.setName("creDeptGpCd");
        creDeptGpCd.setForceSelection(true);
        creDeptGpCd.setAllowBlank(true);
        creDeptGpCd.setMinChars(1);
        creDeptGpCd.setDisplayField("commCdNm");
        creDeptGpCd.setValueField("commCd");
        creDeptGpCd.setTriggerAction(TriggerAction.ALL);
        creDeptGpCd.setEmptyText("--그룹--");
        creDeptGpCd.setSelectOnFocus(true); 
        creDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        creDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        creDeptGpCd.setStore(lsDeptGpCd);
        creDeptGpCd.setFieldLabel("직종"); 

        layoutContainer_211.add(creDeptGpCd, new FormData("100%")); 
        lc7.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		
		LayoutContainer lc7_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);.
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lc7_1.setLayout(frmlytSch);

		creTypOccuCd = new ComboBox<BaseModel>();
		creTypOccuCd.setName("creTypOccuCd");
		creTypOccuCd.setEmptyText("--직종선택--");
		creTypOccuCd.setDisplayField("typOccuNm");
		creTypOccuCd.setValueField("typOccuCd");
		creTypOccuCd.setStore(lsTypOccuCd);
		creTypOccuCd.setHideLabel(true);
		creTypOccuCd.setWidth(100);
//		creTypOccuCd.setFieldLabel("직종");
		//creTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		//creTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		creTypOccuCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {   
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
			    		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						//checkYeta0300Auth("creTypOccuCd", lsTypOccuCd); 
				}
			}
		});   
		creTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
            	BaseModel bmPayYr =  se.getSelectedItem(); 
            	if (bmPayYr != null) {
    				if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
    					
    					sysComBass0350Dto = new PrgmComBass0350DTO();
    					sysComBass0350Dto.setPayrMangDeptCd(PayrUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
    					//직종변경에 따른 직종세 값 가져오기
    					String strTypOccuCd = PayrUtils.getSelectedComboValue(creTypOccuCd,"typOccuCd"); 
    					sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
    					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
    		                        
    					lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
    					creDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
    					
    					
    				} else {
    		                   
    				} 
            	}       
            } 
        });   
		creTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
		               // GWT.log(" a" + ce.getEvent().getType());
		                mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
		                mutilCombo = true;
		              //  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
		                mutilCombo = false;
		              //  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});		
		lc7_1.add(creTypOccuCd, new FormData("100%"));
		
		lc7.add(lc7_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		
		
		LayoutContainer lc7_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lc7_2.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */
		creDtilOccuInttnCd = new ComboBox<BaseModel>();
		creDtilOccuInttnCd.setName("creDtilOccuInttnCd");
		creDtilOccuInttnCd.setEmptyText("--직종세선택--");
		creDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
		creDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
		creDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
		creDtilOccuInttnCd.setWidth(100);
		creDtilOccuInttnCd.setHideLabel(true);
	    //creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	    //creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
	    creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	        @Override
	        public void handleEvent(ComponentEvent ce) {    
	            if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
	                mutilCombo = true;
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                mutilCombo = true;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                mutilCombo = false;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else {
	               
	            }  
	        
	        } 
	    });		

	    lc7_2.add(creDtilOccuInttnCd, new FormData("100%"));
		lc7.add(lc7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		
		LayoutContainer lc8 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc8.setLayout(frmlytSch);
	    
	    creBusinCd = new ComboBox<BaseModel>();
	    creBusinCd.setName("creBusinCd");
	    creBusinCd.setForceSelection(true);
	    creBusinCd.setMinChars(1);
	    creBusinCd.setDisplayField("businNm");
	    creBusinCd.setValueField("businCd");
	    creBusinCd.setTriggerAction(TriggerAction.ALL);
	    creBusinCd.setEmptyText("--사업선택--");
	    creBusinCd.setSelectOnFocus(true);   
	    creBusinCd.setStore(lsBusinCd);
	    creBusinCd.setFieldLabel("사업");
	    creBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	    creBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
	    lc8.add(creBusinCd, new FormData("70%"));
		
		
		LayoutContainer lc9 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button btnInitPayrP405001 = new Button("초기화");
		btnInitPayrP405001.setWidth("100px");
//		btnInitPayrP405001.setIcon(MSFMainApp.ICONS.new16());
		btnBar.add(btnInitPayrP405001); 
		
		btnInitPayrP405001.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
			}
		});
		
		Button btnSavePayrP405001 = new Button("저장");
//		btnSavePayrP405001.setIcon(MSFMainApp.ICONS.save16());
		btnSavePayrP405001.setWidth("100px");
		btnBar.add(btnSavePayrP405001);
		btnSavePayrP405001.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				// 스케줄 생성
				createSchedule();
			}
		});
		
		
		lc9.add(btnBar, new FormData("100%"));
		
		LayoutContainer lc10 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc10_1 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc10_1.setLayout(frmlytSch);
	    
	    creRflctnBgnnDt = new ComboBox<BaseModel>();
	    creRflctnBgnnDt.setName("creRflctnBgnnDt");
	    creRflctnBgnnDt.setForceSelection(true);
	    creRflctnBgnnDt.setMinChars(1);
	    creRflctnBgnnDt.setDisplayField("commCdNm");
        creRflctnBgnnDt.setValueField("commCd");
	    creRflctnBgnnDt.setTriggerAction(TriggerAction.ALL);
	    creRflctnBgnnDt.setEmptyText("--구간선택--");
	    creRflctnBgnnDt.setSelectOnFocus(true);   
	    creRflctnBgnnDt.setStore(lsDays);
	    creRflctnBgnnDt.setFieldLabel("생성일구간");
	    
	    lc10_1.add(creRflctnBgnnDt, new FormData("100%"));
	    
		LayoutContainer lc10_2 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(10); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc10_2.setLayout(frmlytSch);
	    
	    creRflctnEndDt = new ComboBox<BaseModel>();
	    creRflctnEndDt.setName("creRflctnEndDt");
	    creRflctnEndDt.setForceSelection(true);
	    creRflctnEndDt.setMinChars(1);
	    creRflctnEndDt.setDisplayField("commCdNm");
	    creRflctnEndDt.setValueField("commCd");
	    creRflctnEndDt.setTriggerAction(TriggerAction.ALL);
	    creRflctnEndDt.setEmptyText("--구간선택--");
	    creRflctnEndDt.setSelectOnFocus(true);   
	    creRflctnEndDt.setStore(lsDays);
	    creRflctnEndDt.setLabelSeparator("~");
	    
	    lc10_2.add(creRflctnEndDt, new FormData("100%"));
	    
	    
	    lc10.add(lc10_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    lc10.add(lc10_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		
		lc.add(lc1,new FormData("100%"));	//생성년월구간
		lc.add(lc10,new FormData("100%"));	//생성일구간
		lc.add(lc2,new FormData("100%"));	// 급여구분
		lc.add(lc4,new FormData("100%"));	// 단위기관
		lc.add(lc5,new FormData("100%"));	// 고용구분
		lc.add(lc11,new FormData("100%"));	// 관리부서
		lc.add(lc6,new FormData("100%"));	// 부서
		lc.add(lc7,new FormData("100%"));	// 직종, 직종세
		lc.add(lc8,new FormData("100%"));	// 사압
		lc.add(lc3,new FormData("100%"));	// 지급기준일
		lc.add(lc9,new FormData("100%"));
		
		cpPayrP405001.add(lc);
		
//		lc.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		lc.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	}

//	    private void composeListaVociMenu(List<ElementoMenu> listaVociMenu) {
//	        Iterator<ElementoMenu> iter = listaVociMenu.iterator();
//	        List<BaseModel> list = new ArrayList<BaseModel>();
//	        BaseModel baseModel = null;
//	        while (iter.hasNext()) {
//	            ElementoMenu elementoMenu = iter.next();
//	            BaseModel bm = new BaseModel();
//	            bm.set("combocode", elementoMenu.getMnuCd());
//	            bm.set("comboname", elementoMenu.getMnuNm());
//	            list.add(bm);
//	            if (categoryHidden.getValue() != null && elementoMenu.getMnuCd() != null) {
//	                String catValue = categoryHidden.getValue();
//	                String idMenu = elementoMenu.getMnuCd();
//	                if (catValue.compareTo(idMenu) == 0) {
//	                    baseModel = bm;
//	                }
//	            }
//	        }
//	        storeCat.add(list);
//	        if (baseModel != null)
//	            cat.setValue(baseModel);
//	    }

	    public void bind(final ModelData model) {
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            //@Override
	            public void handleEvent(BaseEvent be) {
//	                adminService.getCategories(new AsyncCallback<List<ElementoMenu>>() {
//	                    public void onFailure(Throwable caught) {
//	                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getCategories(): " + caught), null);
//	                    }
//
//	                    public void onSuccess(List<ElementoMenu> result) {
//	                        composeListaVociMenu(result);
//	                    }
//	                });
//	                if ("ADMIN".equals(model.get("tipo"))) {
//	                    seAdmin.setValue(true);
//	                }
	            }
	        });
	    }

	public boolean isValid() {
		boolean result = true;
//		if (!ord.isValid()) {
//			ord.focus();
//			result = false;
//		}
//		if (!title.isValid()) {
//			title.focus();
//			result = false;
//		}
//		if (cat.getValue() != null && !name.isValid()) {
//			name.focus();
//			result = false;
//		}
//		if (!screen.isValid()) {
//			screen.focus();
//			result = false;
//		}
		return result;
	}
	  //TODO  확인 
	    public void save() {
//	        if (isValid()) {
//	            adminService.activityOnVoceMenu(new ElementoMenu(
//	                    id.getValue()==null?null:id.getValue(),
//	                            cat.getValue()==null?null: cat.getValue().get("combocode"),
//	                                    title.getValue(),
//	                                    iconcls.getValue(),
//	                                    thumbnail.getValue(),
//	                                    qtip.getValue(),
//	                                    screen.getValue(),
//	                                    new Date(),
//	                                    new Boolean(false),new Boolean(false),new Boolean(false),
//	                                    new Long(ord.getValue()),
//	                                    seAdmin.getValue()==null?"":"ADMIN",
//	                                    name.getValue()), 
//	                                    actionDatabase,
//	                                    new AsyncCallback<Long>() {
//	                public void onFailure(Throwable caught) {
//	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnVoceMenu(" + actionDatabase.name() + ") : " + caught), null);
//	                }
//	                public void onSuccess(Long result) {
//	                    getMSFWindows().hide();
//	                    ricarica();
//	                }	
//	            });
//	        }
	    }

	public void pulisci() {
		this.clear();
	}

	public void ricarica() {
		caller.reload();
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onFailureSave() {
		// TODO Auto-generated method stub

	}

	public void restoreValues() {

	}
	
	
	private void createSchedule() {
		
		Payr0250DTO payr0250Dto = new Payr0250DTO();
		
		
		payr0250Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    												/** column 사업장코드 : dpobCd */
		payr0250Dto.setJobYr_S(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year")));    			/** column 작업년월 : jobYrMnth */
		payr0250Dto.setJobMnth_S(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month")));    	/** column 작업년월 : jobYrMnth */
		payr0250Dto.setJobYr_E(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayYr_E,"year")));    			/** column 작업년월 : jobYrMnth */
		payr0250Dto.setJobMnth_E(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayMonth_E,"month")));   	/** column 작업년월 : jobYrMnth */
        payr0250Dto.setRflctnBgnnDt(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creRflctnBgnnDt,"commCd"))); /** column 반영시작일자 : rflctnBgnnDt */
        payr0250Dto.setRflctnEndDt(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creRflctnEndDt,"commCd")));   /** column 반영종료일자 : rflctnEndDt */
		
		
		
		payr0250Dto.setPayCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayCd,"commCd")));    							/** column 급여구분코드 : payCd */
		payr0250Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"))); 	/** column 급여관리부서코드 : payrMangDeptCd */
		payr0250Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd")));    			/** column 인사관리부서코드 : mangeDeptCd */
		payr0250Dto.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creDeptCd,"deptCd")));    							/** column 부서코드 : deptCd */
		payr0250Dto.setBusinCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd")));    						/** column 사업코드 : businCd */
		payr0250Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")));    					/** column 고용구분코드 : emymtDivCd */
		payr0250Dto.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creRepbtyBusinDivCd,"commCd")));    		/** column 호봉제구분코드 : repbtyBusinDivCd */
		
		payr0250Dto.setJobNm(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(crePayCd,"commCd")));    							/** column 작업명 : jobNm */
//		payr0250Dto.setPymtDt(MSFSharedUtils.allowNulls(PayrUtils.getConvertDateToString(pymtDt, "yyyyMMdd")));    								/** column 지급일자 : pymtDt */
		payr0250Dto.setPymtDt( MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(pymtDt,"commCd")) );    							/** column 지급일자 : pymtDt */
		
		payr0250Dto.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creTypOccuCd,"typOccuCd")));    				/** column 직종코드 : typOccuCd */
		payr0250Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creDtilOccuInttnCd, "dtilOccuInttnCd")));	/** column null : dtilOccuInttnCd */
		payr0250Dto.setOverYn(MSFSharedUtils.allowNulls(PayrUtils.getCheckedCheckBoxYnValue(overYn)));											// 차월지급여부
		
		// 기간제 근로자
	   	if (MSFConfiguration.EMYMT_DIVCD02.equals(payr0250Dto.getEmymtDivCd())) {
    		if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobYr_S() + payr0250Dto.getJobMnth_S()) ) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                            "[급여] 시작 지급년월 을 입력하십시요.", null);
    			statCheck = true;
    			return;
    		} else if(MSFSharedUtils.isNullAsString(payr0250Dto.getJobYr_E() + payr0250Dto.getJobMnth_E()) ) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "[급여] 종료 지급년월 을 입력하십시요.", null);
    			statCheck = true;
    			return;
    		}else if (MSFSharedUtils.isNullAsString(payr0250Dto.getDeptCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                         "[급여] 부서 또는 관리부서를 입력하십시요.", null);
       			statCheck = true;
       			return;
    		} else if (MSFSharedUtils.isNullAsString(payr0250Dto.getEmymtDivCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                         "[급여] 고용구분을 입력하십시요.", null);
       			statCheck = true;
       			return;		
       		} else if (MSFSharedUtils.isNullAsString(payr0250Dto.getBusinCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                         "[급여] 사업을 입력하십시요.", null);
      			statCheck = true;
      			return;
      		} 
//       		else if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobNm())) {
//    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                         "[급여] 작업명을 입력하십시요.", null);
//     			statCheck = true;
//     			return;
//     		}
    		  payr0250Dto.setTypOccuCd("");    			/** column 직종코드 : typOccuCd */
              payr0250Dto.setDtilOccuInttnCd("");   	/** column 직종세종통합코드 : dtilOccuInttnCd */
              payr0250Dto.setPyspGrdeCd("");    		/** column 호봉등급코드 : pyspGrdeCd */
    	
        // 무기계약근로자
    	} else if (MSFConfiguration.EMYMT_DIVCD01.equals(payr0250Dto.getEmymtDivCd())) {
    	 
    		if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobYr_S() + payr0250Dto.getJobMnth_S()) ) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                            "[급여] 시작 지급년월 을 입력하십시요.", null);
    			statCheck = true;
    			return;
    		} else if(MSFSharedUtils.isNullAsString(payr0250Dto.getJobYr_E() + payr0250Dto.getJobMnth_E()) ) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "[급여] 종료 지급년월 을 입력하십시요.", null);
    			statCheck = true;
    			return;
    		}else if (MSFSharedUtils.isNullAsString(payr0250Dto.getDeptCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "[급여] 부서 또는 관리부서를 입력하십시요.", null);
	  			statCheck = true;
	  			return;
    		} else if (MSFSharedUtils.isNullAsString(payr0250Dto.getEmymtDivCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                         "[급여] 고용구분을 입력하십시요.", null);
       			statCheck = true;
       			return;		
       		} 
//    		else if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobNm())) {
//    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                        "[급여] 작업명을 입력하십시요.", null);
//    			statCheck = true;
//    			return;
//    		}
    		//환경미화원인경우 처리 
    		//TODO 직종세직종명이 있는경우 직종명을 입력하도록 하는 루틴 생각 추가 
    		//if ( MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd())
    			//	        .concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))))) {
    			
    	    if (!gwtExtAuth.getEnableTypOccuCd())	{
    			if (MSFSharedUtils.isNullAsString(payr0250Dto.getTypOccuCd())) {
         			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
  	                         "[급여] 직종을 입력하십시요.", null);
           			statCheck = true;
           			return;
           		}
    		} 
    	    
    	    if (!gwtExtAuth.getEnableDtilOccuInttnCd())	{
    			if (MSFSharedUtils.isNullAsString(payr0250Dto.getDtilOccuInttnCd())) {
         			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
  	                         "[급여] 직종세를 입력하십시요.", null);
           			statCheck = true;
           			return;
           		}
    		} 
    	    payr0250Dto.setBusinCd("");    /** column 사업코드 : businCd */
    	    
    	    
    	}   else {
    		
    		if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobYr_S() + payr0250Dto.getJobMnth_S()) ) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                            "[급여] 시작 지급년월 을 입력하십시요.", null);
    			statCheck = true;
    			return;
    		} else if(MSFSharedUtils.isNullAsString(payr0250Dto.getJobYr_E() + payr0250Dto.getJobMnth_E()) ) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "[급여] 종료 지급년월 을 입력하십시요.", null);
    			statCheck = true;
    			return;
    		} else if (MSFSharedUtils.isNullAsString(payr0250Dto.getDeptCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "[급여] 부서 또는 관리부서를 입력하십시요.", null);
	  			statCheck = true;
	  			return;
    		} else if (MSFSharedUtils.isNullAsString(payr0250Dto.getEmymtDivCd())) {
    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                         "[급여] 고용구분을 입력하십시요.", null);
       			statCheck = true;
       			return;	
       		} 
//    		else if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobNm())) {
//    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                         "[급여] 작업명을 입력하십시요.", null);
//     			statCheck = true;
//     			return;
//     		}

    		if (MSFConfiguration.EMYMT_DIVCD02.equals(payr0250Dto.getEmymtDivCd())) {
    			 if (MSFSharedUtils.isNullAsString(payr0250Dto.getBusinCd())) {
          			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
   	                         "[급여] 사업을 입력하십시요.", null);
            			statCheck = true;
            			return;
            		} 
    		} else if (MSFConfiguration.EMYMT_DIVCD01.equals(payr0250Dto.getEmymtDivCd())) {
    			if (MSFSharedUtils.isNullAsString(payr0250Dto.getTypOccuCd())) {
         			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
  	                         "[급여] 직종을 입력하십시요.", null);
           			statCheck = true;
           			return;
           		}
    		} 
    	}
    	
    	if (MSFSharedUtils.paramNull(payr0250Dto.getPymtDt())) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                         "[급여] 지급일자를 입력하십시요.", null);
			statCheck = true;
			return;
		} 
//    	else if (MSFSharedUtils.paramNull(payr0250Dto.getRflctnBgnnDt())) {
//			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                    "[급여] 시작일자를 입력하십시요.", null);
//   			statCheck = true;
//   			return;
//   		} else if (MSFSharedUtils.paramNull(payr0250Dto.getRflctnEndDt())) {
//			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                    "[급여] 종료일자를 입력하십시요.", null);
//   			statCheck = true;
//   			return;
//   		} 
    	

    	
   	   final Tracker tracker = new Tracker();
       tracker.setStatus(false);
		
		payrP405001Service.createSchedulePayrP405001(payr0250Dto , new AsyncCallback<PagingLoadResult<ShowMessageBM>>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
		           tracker.setStatus(true);
		           List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		           ShowMessageBM smBm = new ShowMessageBM();
		    	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
		    	   smBm.setMenu("Payr");
		    	   smBm.setPhase("[급여스케줄생성]에러");
		    	   smBm.setMessage(caught.getLocalizedMessage());
		    	   smBm.setContent(caught.getMessage());
		    	   bmResult.add(smBm);  
		    	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
		    	   
		           ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
				    
			       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
			       msFwMessage.show();
			       showMessageForm.setMSFFormWindows(msFwMessage);
				
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createSchedule(" + "스케줄 생성이 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
				
	              // 오류를 리턴하는 경우
	        	   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
				    
			       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
			       msFwMessage.show();
			       showMessageForm.setMSFFormWindows(msFwMessage);
				
				// TODO Auto-generated method stub
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + result + " " + "건이 생성되었습니다. 데이터를 확인해 주세요.", null);
				
			}
        });
		
		
		
//		payrP405001Service.createSchedulePayrP405001(payr0250Dto ,new AsyncCallback<Integer>()  {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createSchedule(" + "스케줄 생성이 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
//			}
//
//			@Override
//			public void onSuccess(Integer result) {
//				
//				// TODO Auto-generated method stub
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + result + " " + "건이 생성되었습니다. 데이터를 확인해 주세요.", null);
//				
//			}
//        });
		
	}
	
	private void setInitDate() {
		   
		int maxDays = 0;
		   
		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayYr_S,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayMonth_S,"month")) - 1, 1 );
		maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);  
		
		String dayS = "01";
		String dayE =  String.valueOf(maxDays);
		

		PayrUtils.setSelectedComboValue(creRflctnBgnnDt, dayS, "commCd"); // 반영시작일자
		PayrUtils.setSelectedComboValue(creRflctnEndDt, dayE, "commCd"); // 반영종료일자
		
		if (MSFConfiguration.EMYMT_DIVCD01.equals(PayrUtils.getSelectedComboValue(creEmymtDivCd, "commCd"))) {
			// 공무직 일 경우 지급 기준 일자 20일
			PayrUtils.setSelectedComboValue(pymtDt, "20", "commCd");
		} else if (MSFConfiguration.EMYMT_DIVCD02.equals(PayrUtils.getSelectedComboValue(creEmymtDivCd, "commCd"))) {
			// 기간제 일 경우 지급 기준 일자 30일? 말일?
			PayrUtils.setSelectedComboValue(pymtDt, dayE, "commCd");
		} else {
			PayrUtils.setSelectedComboValue(pymtDt,"01", "commCd");
		}
		
	}

	

	private PayrP405001 getThis(){
	    return this;
	}
	
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	}  
	
	
	 //부서 
//    private void fnPopupCommP140(String deptCd) {
//        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//        //검색.처리하면됨.
//        
//        MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//        
//        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//       
//        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {
//                BaseModel mapModel = (BaseModel)be.getSource();
//                if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                     
//                    creDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                    srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("eptNmRtchnt"))); 
//                    creDeptCd.fireEvent(Events.Add);
//                }  
//            }
//        });
//    }   
	    
	 

}
