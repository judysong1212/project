package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0415DTO;
import com.app.exterms.payroll.client.dto.Payr0416DTO;
import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.exterms.payroll.client.form.defs.Payr0416Def;
import com.app.exterms.payroll.client.form.defs.Payr0417Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0416PayYr;
import com.app.exterms.payroll.client.service.Payr5250Service;
import com.app.exterms.payroll.client.service.Payr5250ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr5250  extends MSFPanel { 



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
	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmPayr5250;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	
	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	 
	
	private Payr0416Def payr0416Def = new Payr0416Def("PAYR5250"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel payr0416GridPanel;
	
	
	private Payr0417Def payr0417Def = new Payr0417Def("PAYR5250"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel payr0417GridPanel;


	// 직종콤보
	// private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();
	// private MSFGridPanel typOccuCdGridPanel;

	private LookupPayr0416PayYr lkApptnYr = new LookupPayr0416PayYr();
	private MSFGridPanel payYrGridPanel;
      

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
      private ButtonBar topPayr5250Bar;
      private Button btnPayr5250Init;
      private Button btnPayr5250Print;
      //private Button btnPayr5250New;
      private Button btnPayr5250Del;
      private Button btnPayr5250Sreach;
      private Button btnPayr5250ExcelFile;
      
      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ComboBox<BaseModel> srhPayYr;					/** column 급여년도 : payYr */
	
	private MSFTextField srhDeptCd; 						// 부서명
	private MSFTextField srhDeptNm; 						// 부서명
	private Button btnSrhDeptCd;
	
	private ComboBox<BaseModel> srhTypOccuCd;				/** column 직종코드 : typOccuCd */
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;	/** column 직종세코드 : dtilOccuInttnCd */
	private ComboBox<BaseModel> srhPymtDducDivCd;			/** column 지급공제구분코드 : pymtDducDivCd */
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	
	
	
	private List<ModelData> mDtalistDtilOccuInttnCd;
	private boolean mutilCombo = false;
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	// -- 생성부 
	private ComboBox<BaseModel> createPayYr;	/** column 급여년도 : payYr */  
	private MSFTextField creDeptCd; 						// 부서명
	private MSFTextField creDeptNm; 						// 부서명
	private Button btnDeptCd;
     // private ComboBox<BaseModel> createTypOccuCd ;  /** column 직종코드 : typOccuCd */
     // private ComboBox<BaseModel> createDtilOccuInttnCd;   /** column 직종세코드 : dtilOccuInttnCd */
        
	// -- 항목설정
	
	private TextField<String> payYr;   				/** column 급여년도 : payYr */   
	
    private HiddenField<String> deptCd;				/** column 부서코드 : deptCd */
    private TextField<String> deptNm;   			/** column 부서코드 : deptNm */
	
	private HiddenField<String> typOccuCd;   		/** column 직종코드 : typOccuCd */
    private TextField<String> typOccuNm;   			/** column 직종코드 : typOccuCd */
    private HiddenField<String> dtilOccuInttnCd;	/** column 직종세코드 : dtilOccuInttnCd */
    private TextField<String> dtilOccuInttnNm;   	/** column 직종세코드 : dtilOccuInttnCd */
    
    private HiddenField<Long> dtilOccuDlySeilNum;	/** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
 
    //  private HiddenField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
   //   private TextField<String> pyspGrdeNm;   /** column 호봉등급코드 : pyspGrdeCd */
    
    
    private ComboBox<BaseModel> srhPayCd;          //급여구분
    private ComboBox<BaseModel> srhType;          //급여구분
   
    // -- 상세정보 
    private HiddenField<String> dpobCd; 	 			/** column 사업장코드 : dpobCd */   
    private HiddenField<String> emymtDivCd;  			/** column 고용구분코드 : emymtDivCd */
    
//    private HiddenField<String> deptCd;		
//    
//    private TextField<String> deptNm; 					//부서
//    private Button btnSrhDeptCd;
    
//    private HiddenField<Long> typOccuGrdeMppgSeilNum;   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
    private HiddenField<Long> itemDlySeilNum;   		/** column 급여항목일련번호 : itemDlySeilNum */
      
    private TextField<String> payrImcd ;  				/** column 급여항목코드 : payrImcd */
    private TextField<String> itemNm;   				/** column 항목명 : itemNm */ 
    private ComboBox<BaseModel> payCd;   				/** column 급여구분코드 : payCd */ 
    private ComboBox<BaseModel> dayMnthAmntDivCd;   	/** column 일월액구분코드 : dayMnthAmntDivCd */
    private CheckBox usalyAmntYn;   					/** column 통상임금여부 : usalyAmntYn */
    private CheckBox payItemUseYn;   					/** column 급여항목사용여부 : payItemUseYn */
    
    private ComboBox<BaseModel> pymtDducDivCd ;  		/** column 지급공제구분코드 : pymtDducDivCd */
    private ComboBox<BaseModel> pymtDducFrmCd;   		/** column 지급공제유형코드 : pymtDducFrmCd */
    private NumberField pymtDducSum;  					/** column 지급공제액 : pymtDducSum */
    private NumberField pymtDducRate;   				/** column 지급공제율 : pymtDducRate */
    private ComboBox<BaseModel> calcStdDivCd;   		/** column 계산기준구분코드 : calcStdDivCd */
    private ComboBox<BaseModel> txtnDivCd;   			/** column 과세구분코드 : txtnDivCd */
    private NumberField freeDtySum;   					/** column 비과세금액 : freeDtySum */
    private NumberField freeDtyRate ;  					/** column 비과세율 : freeDtyRate */
	private DateField itemApptnBgnnDt ;  				/** column 항목적용시작일자 : itemApptnBgnnDt */
	private DateField itemApptnEndDt;   				/** column 항목적용종료일자 : itemApptnEndDt */

    private CheckBox jan;   							/** column 1월 : jan */
    private CheckBox feb;   							/** column 2월 : feb */
    private CheckBox mar;   							/** column 3월 : mar */
    private CheckBox apr;   							/** column 4월 : apr */
    private CheckBox may;   							/** column 5월 : may */
	private CheckBox jun;   							/** column 6월 : jun */
	private CheckBox jul;   							/** column 7월 : jul */
	private CheckBox aug;   							/** column 8월 : aug */
	private CheckBox sep ;  							/** column 9월 : sep */
	private CheckBox oct;   							/** column 10월 : oct */
	private CheckBox nov;   							/** column 11월 : nov */
	private CheckBox dec;   							/** column 12월 : dec */
	private CheckBox chkAll;   							/** column 전체체크 : chkAll */
	private NumberField rngeOrd ;  						/** column 정렬순서 : rngeOrd */
	
    private TextField<String> payItemNoteCtnt;   		/** column 급여항목비고내용 : payItemNoteCtnt */
    private ComboBox<BaseModel> payrMangDeptCd;   		/** column 급여관리부서코드 : payrMangDeptCd */
    private TextField<String> calcStdFunc;   			/** column 계산수식내용 : calcStdFunc */
   
    private CheckBox sumOhrItemApptnYn;					/** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
    
    private BaseModel ppRecord; //팝업에 넘길 레코드 값  
	private Iterator<Record> recordDels;
    private boolean searchYn;
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	// 검색 폼 바인딩 처리 함수

	// private AuthAction authAction;
	// private Boolean boolChkAuth;
	// private static MessageBox authBox = MessageBox.wait("화면로딩",
	// "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중...");
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkPayr5250Auth(String authAction, ListStore<BaseModel> bm) {
		// MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중");

		// 2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())
				&& gwtExtAuth.checkExtAuth(authAction, bm)) {

			if (!maskTracker) {
				unmask();
			}
			authExecEnabled();

			gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
		}
	}

	private void authExecEnabled() {
		// ------------------
		// ----------------------------------------------------
		Field<?>[] fldArrField = { srhPayrMangDeptCd, srhTypOccuCd,payrMangDeptCd };

		gwtAuthorization.formAuthFieldConfig(fldArrField);

		// MSFMainApp.unmaskMainPage();
		// srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new
		// Date())));

		Date today = new Date();
		// A custom date format
		DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");
		createPayYr.setValue(lscrPayYr.findModel("year", fmt.format(today)));
		
		srhDeptCd.setValue(MSFMainApp.get().getUser().getTplvlDeptCd());
		srhDeptNm.setValue(MSFMainApp.get().getUser().getTplvlDeptNm());
		
		creDeptCd.setValue(MSFMainApp.get().getUser().getTplvlDeptCd());
		creDeptNm.setValue(MSFMainApp.get().getUser().getTplvlDeptNm());

		// payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()
		// ));
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */
		// gwtAuthorization.formAuthConfig(plFrmPayr5250,
		// "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */

		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */
		// gwtAuthorization.formAuthConfig(plFrmPayr5250,
		// "payrMangDeptCd","","","","");
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */

	}

	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			if (lsPayYrStore.getCount() > 0) {

				cancel();
				unmask();
				authExecEnabled();
				maskTracker = true;

			} else {
				tmMask.scheduleRepeating(2000);
			}
			// }
		}
	};
			     
			  
	private void initLoad() {

		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();

		authMapDef.put("srhPayYr", Boolean.FALSE);
		authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
		authMapDef.put("createPayYr", Boolean.FALSE);

		// authMapDef.put("MangeDeptCd",Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			// 권한 검색조건처리를 위해 추가된 부분
			mask("[화면로딩] 초기화 진행 중!");
		}
		tmMask.scheduleRepeating(5000);
	}
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/	
        
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	// 검색 폼 바인딩 처리 함수
	// 화면 폼 바인딩 처리
	private void setPayr5250FormBinding() {

		// formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt,
		// "srhPubcHodyCtnt"));
		// formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum,
		// "degtrResnRegnNum"));

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
	//입력수정삭제처리 rpc 처리부     
	private Payr5250ServiceAsync payr5250Service = Payr5250Service.Util.getInstance();	    
	
	private ListStore<BaseModel> lsPayYrStore 			= new ListStore<BaseModel>();
	
	//공통 코드 
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsPymtDducDivCd 		= new ListStore<BaseModel>();
	
	private ListStore<BaseModel> lscrTypOccuCd 			= new ListStore<BaseModel>();
	private ListStore<BaseModel> lscrDtilOccuInttnCd 	= new ListStore<BaseModel>();
	private ListStore<BaseModel> lscrPayYr 				= new ListStore<BaseModel>();
	 	
    private ListStore<BaseModel> lsPayCd 				= new ListStore<BaseModel>(); //급여구분
	private ListStore<BaseModel> lsGdPymtDducDivCd 		= new ListStore<BaseModel>(); //지급공제구분코드 
	    
	private ListStore<BaseModel> lsPymtDducFrmCd 		= new ListStore<BaseModel>();  	/** column 지급공제유형코드 : pymtDducFrmCd */
	private ListStore<BaseModel> lsTxtnDivCd 			= new ListStore<BaseModel>(); 	/** column 과세구분코드 : txtnDivCd */
	private ListStore<BaseModel> lsDayMnthAmntDivCd 	= new ListStore<BaseModel>(); 	/** column 일월액구분코드 : dayMnthAmntDivCd */
	private ListStore<BaseModel> lsCalcStdDivCd 		= new ListStore<BaseModel>(); 	/** column 계산기준구분코드 : calcStdDivCd */
	     
	private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>();//단위기관     
	    
	private PrgmComBass0300DTO sysComBass0300Dto;
	private PrgmComBass0350DTO sysComBass0350Dto;
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0150DTO sysComBass0150Dto;
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종

	private BaseModel record;

	private BaseModel detailRecord;

	private List<BaseModel> records;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr5250(){
//    	payr0400GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr5250List(bass0200Dto, new AsyncCallback<List<Payr5250BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr5250(): "+caught), null);
//                msfPayr5250GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr5250BM> result) {
//            	composedPayr5250List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr5250List(List<Payr5250BM> listaMenu) {
//        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//        BaseTreeModel folder = new BaseTreeModel();
//        BaseTreeModel category = null;
//        while ( iter.hasNext() ) {
//        	Sysm0200BM mnu = iter.next();
//            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
//            BaseTreeModel bm = new BaseTreeModel();
//            bm.set("sysDivCd", mnu.getSysDivCd());
//            bm.set("mnuCd", mnu.getMnuCd());
//            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
//            bm.set("mnuNm", mnu.getMnuNm());
//            bm.set("mnuIcn", mnu.getMnuIcn()); 
//            bm.set("mnuTmbl", mnu.getMnuTmbl());
//            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
//            bm.set("mnuTipNm", mnu.getMnuTipNm());
//            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
//            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
//            bm.set("mnuPrntOrd", ord);
//            bm.set("useYn", mnu.getUseYn());
//            bm.set("mnuEpln", mnu.getMnuEpln());
//             
//            if (mnu.getHhrkMnuCd() == null) {
//                category = new BaseTreeModel();
//                category.setProperties(bm.getProperties());
//                folder.add(category);
//            } else {
//                if (category != null) {
//                    category.add(bm);
//                }
//            }
//        } 
//        msfPayr5250GridPanel.unmask();  
//    }
     

	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
     private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
    	 public void componentSelected(ButtonEvent ce) { 
    		 if (ce.getButton() == btnPayr5250Del) {
                    	 
    			 if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
    				 MessageBox.alert("오류", "마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
    				 return; 
    			 }
                    	 
                    	 
    			 MessageBox.confirm("경고", "지급공제항목을 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
    				 @Override
    				 public void handleEvent(MessageBoxEvent be) {
    					 if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
    						 
    						 actionDatabase = ActionDatabase.DELETE;
    						 
 							Iterator<BaseModel> itBm  = payr0416GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
                            
 							List<Record>  lsRec  = new ArrayList<Record>();
 	                             
 	                        while(itBm.hasNext()) {

 	                        	Record rec  = new Record(itBm.next()); 
 	                        	lsRec.add(rec);
 	                                 
 	                        } 
 	                              
 	                             
 	                        setListRecordDels(lsRec.iterator()); 
 	                              
 	                        List<Payr0416DTO> listPayr0416Dto = new ArrayList<Payr0416DTO>();  
 	                             
 	                        while (recordDels.hasNext()) {
 	                          
 	                        	Record record = (Record) recordDels.next(); 
 	                        	BaseModel bmMapModel = (BaseModel)record.getModel();
 	                                  
 	                              
 	                        	Payr0416DTO payr0416Dto = new Payr0416DTO(); 
 	                            
 	                        	payr0416Dto.setPayYr(MSFSharedUtils.allowNulls(bmMapModel.get("payYr")));
 	                        	payr0416Dto.setDpobCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd"))));
 	                        	payr0416Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
 	                        	payr0416Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
 	                        	payr0416Dto.setDtilOccuDlySeilNum((Long) bmMapModel.get("dtilOccuDlySeilNum")) ;
                                 
 	                             
 	                        	listPayr0416Dto.add(payr0416Dto);
 	                        } 
    						 
    						 
 	                        payr5250Service.activityOnPayr5250Delete(listPayr0416Dto, actionDatabase,new AsyncCallback<Long>() {
 	                        	public void onFailure(Throwable caught) {
 	                        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
 	                        				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5250Insert(" + actionDatabase.name() + ") : " + caught), null);
 	                        	}
 	                        	public void onSuccess(Long result) { 
 	                        		if (result == 0) {
 	                        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
 	                        					actionDatabase.name() + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
 	                        		} else {
 	                        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase.name() + "처리가 완료되었습니다.", null);
 	                        			
 	                        			payr0417GridPanel.getMsfGrid().clearData();

 	                        			formSubInit();
 	                        			formSubDetilInit();
 	                        			
 	                        			
 	                        			payr0416_reload();
 	                        		} 
 	                        	} 
 	                        });
    					 }
    				 }
    			 });
    		 }
    	}  
 	};
      
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
            doInsert();
            break;
        case UPDATE:
            this.actionDatabase = ActionDatabase.UPDATE;
            save();
            break;
        case DELETE:
            this.actionDatabase = ActionDatabase.DELETE;
            save();     
            break;
        }
    }
    
    
    /**
     * 지급공제항목저장
     */
    public void payr0417Save() {
//      if (isValid()) {
              
        Payr0417DTO payr0417Dto = new Payr0417DTO();
        
        
        payr0417Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));	/** column 사업장코드 : dpobCd */
        payr0417Dto.setDtilOccuDlySeilNum(Long.parseLong(MSFSharedUtils.allowNulls(record.get("dtilOccuDlySeilNum"))));  /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
        payr0417Dto.setPayYr(payYr.getValue());									/** column 급여년도 : payYr */
//        payr0417Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd"))) ;
//        payr0417Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd"))) ;
//        payr0417Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd")));  
         
        
        payr0417Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01); 							/** column 고용구분코드 : emymtDivCd */
        payr0417Dto.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"));		/** column 급여구분코드 : payCd */
        payr0417Dto.setPymtDducFrmCd(""); 												   	/** column 지급공제유형코드 : pymtDducFrmCd */
        payr0417Dto.setTxtnDivCd("");  														/** column 과세구분코드 : txtnDivCd */
        payr0417Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(new Date(),"yyyyMMdd")); 	/** column 항목적용시작일자 : itemApptnBgnnDt */
        payr0417Dto.setItemApptnEndDt("99991231");  										/** column 항목적용종료일자 : itemApptnEndDt */
        payr0417Dto.setDayMnthAmntDivCd("");												/** column 일월액구분코드 : dayMnthAmntDivCd */
        payr0417Dto.setCalcStdDivCd(""); 													/** column 계산기준구분코드 : calcStdDivCd */
        payr0417Dto.setPayItemNoteCtnt(payItemNoteCtnt.getValue());  						/** column 급여항목비고내용 : payItemNoteCtnt */
        payr0417Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getMangeDeptCd()); 		/** column 급여관리부서코드 : payrMangDeptCd */
        payr0417Dto.setCalcStdFunc("");  													/** column 계산수식내용 : calcStdFunc */

        
        payr5250Service.activityOnPayr0417Insert(payr0417Dto, records,  actionDatabase, new AsyncCallback<Long>() {
        	public void onFailure(Throwable caught) {
        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
        				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Insert(" + actionDatabase.name() + ") : " + caught), null);
        	}
              public void onSuccess(Long result) { 
                  if (result == 0) {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                              actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                  } else {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
//                      reload();
//                      payr0417_reload();
                      	//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
  						leftPayr0416Detail(payr0416GridPanel.getCurrentlySelectedItem());
                  } 
              } 
          });
    }   
    
	/**
	 * 급여항목마스터 생성저장
	 */
	public void doInsert() {
//      if (isValid()) {
        
        Payr0416DTO payr0416Dto = new Payr0416DTO();  
        
        if (MSFSharedUtils.paramNull(createPayYr.getValue())) {
            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "생성할 년도를 선택하십시요.", null);
            return;
        }
       
        payr0416Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
        payr0416Dto.setDeptCd(MSFSharedUtils.allowNulls(creDeptCd.getValue()));
        payr0416Dto.setPayYr(MSFSharedUtils.allowNulls(createPayYr.getValue().get("year")));
        
        payr5250Service.activityOnPayr5250Insert(payr0416Dto,records, actionDatabase,new AsyncCallback<Long>() {
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5250Insert(" + actionDatabase.name() + ") : " + caught), null);
              }
              public void onSuccess(Long result) { 
                  if (result == 0) {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                    		  actionDatabase.name() + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                  } else {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase.name() + "처리가 완료되었습니다.", null);
                      payr0416_reload();
                  } 
              } 
          });
     // }
    }   
    
    
    public void save() {
//    if (isValid()) {
          
        Payr0415DTO payr0417Dto = new Payr0415DTO(); 
       
        if (MSFSharedUtils.paramNull(record)) {
            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "선택된 데이터가 없습니다.", null);
            return;
        }
         
        payr0417Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));
        payr0417Dto.setPayYr(MSFSharedUtils.allowNulls(record.get("payYr")));
        payr0417Dto.setTypOccuGrdeMppgSeilNum(Long.parseLong(MSFSharedUtils.allowNulls(record.get("typOccuGrdeMppgSeilNum")))); 
        payr0417Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd"))) ;
        payr0417Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd"))) ;
       // payr0417Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd"))); 
           
//        payr1500Service.activityOnPayr0415Save(payr0417Dto, 
//                                actionDatabase,
//                                new AsyncCallback<Long>() {
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Save(" + actionDatabase.name()   + ") : " + caught), null);
//            }
//            public void onSuccess(Long result) { 
//               if (result == 0) {
//                   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//                           actionDatabase.name() + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//               } else {
//                   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                           actionDatabase.name() + "처리가 완료되었습니다.", null);
//                   formSubInit(); 
//                   formSubDetilInit();
//                   reload();
//               } 
//            } 
//        });
   // }
	}

	/**
	 * form detail info data update
	 */
	public void detailFormSave() {
    	
//      if (isValid()) {
    	
		Payr0417DTO payr0417Dto = new Payr0417DTO(); 
            
    	if (MSFSharedUtils.paramNull(detailRecord)) {
    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "선택된 데이터가 없습니다.", null);
            return;
        }
        
        if (this.actionDatabase.equals(ActionDatabase.UPDATE) ) {
        	/** column 급여항목코드 : payItemCd */    
            if (MSFSharedUtils.paramNull(payrImcd.getValue())) {
            	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "급여항목이 존재하지 않습니다.", null);
            	return;
            } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(payCd,"commCd"))) {
                /** column 급여구분코드 : payCd */ 
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "급여구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd,"commCd"))) {
                /** column 지급공제구분코드 : pymtDducDivCd */  
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "지급공제구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd,"commCd"))) {
                /** column 지급공제유형코드 : pymtDducFrmCd */
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "지급공제유형은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(txtnDivCd,"commCd"))) {
                /** column 과세구분코드 : txtnDivCd */ 
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "과세구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(calcStdDivCd,"commCd"))) {
                /** column 계산기준구분코드 : calcStdDivCd */ 
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "계산기준구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd,"commCd"))) {
            	/** column 일월액구분코드 : dayMnthAmntDivCd */
            	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "일월액구분은 필수 선택 항목입니다.", null);
               return;
            }
        }
        
        
         
        payr0417Dto.setPayYr(MSFSharedUtils.allowNulls(payYr.getValue()));    									/** column 급여년도 : payYr */
        payr0417Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    								/** column 사업장코드 : dpobCd */
        payr0417Dto.setItemDlySeilNum(itemDlySeilNum.getValue());												/** column 급여일용단가항목일련번호 : itemDlySeilNum */
        payr0417Dto.setDtilOccuDlySeilNum(dtilOccuDlySeilNum.getValue());    									/** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
        payr0417Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(payrMangDeptCd,"payrMangDeptCd"));	/** column 급여관리부서코드 : payrMangDeptCd */
        payr0417Dto.setPayrImcd(payrImcd.getValue());    														/** column 급여항목코드 : payrImcd */
        payr0417Dto.setItemNm(itemNm.getValue());    															/** column 항목명 : itemNm */
        payr0417Dto.setPayCd(MSFSharedUtils.allowNulls(payCd.getValue().get("commCd")));    					/** column 급여구분코드 : payCd */
        payr0417Dto.setPymtDducDivCd(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd, "commCd"));    		/** column 지급공제구분코드 : pymtDducDivCd */
        payr0417Dto.setPymtDducFrmCd(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd, "commCd"));   	 		/** column 지급공제유형코드 : pymtDducFrmCd */
        payr0417Dto.setPymtDducRate((Double) pymtDducRate.getValue());    										/** column 지급공제율 : pymtDducRate */
        payr0417Dto.setPymtDducSum((Long) pymtDducSum.getValue());    											/** column 지급공제액 : pymtDducSum */
        payr0417Dto.setTxtnDivCd(MSFSharedUtils.getSelectedComboValue(txtnDivCd, "commCd"));    				/** column 과세구분코드 : txtnDivCd */
        payr0417Dto.setFreeDtyRate((Double) freeDtyRate.getValue());    										/** column 비과세율 : freeDtyRate */
        payr0417Dto.setFreeDtySum((Long) freeDtySum.getValue());    											/** column 비과세금액 : freeDtySum */
        payr0417Dto.setJan(jan.getValue()?"Y":"N");    															/** column 1월 : jan */
        payr0417Dto.setFeb(feb.getValue()?"Y":"N");    															/** column 2월 : feb */
        payr0417Dto.setMar(mar.getValue()?"Y":"N");    															/** column 3월 : mar */
        payr0417Dto.setApr(apr.getValue()?"Y":"N");    															/** column 4월 : apr */
        payr0417Dto.setMay(may.getValue()?"Y":"N");    															/** column 5월 : may */
        payr0417Dto.setJun(jun.getValue()?"Y":"N");    															/** column 6월 : jun */
        payr0417Dto.setJul(jul.getValue()?"Y":"N");    															/** column 7월 : jul */
        payr0417Dto.setAug(aug.getValue()?"Y":"N");    															/** column 8월 : aug */
        payr0417Dto.setSep(sep.getValue()?"Y":"N");    															/** column 9월 : sep */
        payr0417Dto.setOct(oct.getValue()?"Y":"N");   												 			/** column 10월 : oct */
        payr0417Dto.setNov(nov.getValue()?"Y":"N");    															/** column 11월 : nov */
        payr0417Dto.setDec(dec.getValue()?"Y":"N");    															/** column 12월 : dec */
        payr0417Dto.setRngeOrd((Long) rngeOrd.getValue());    													/** column 정렬순서 : rngeOrd */
        payr0417Dto.setSumOhrItemApptnYn(MSFSharedUtils.allowNulls(detailRecord.get("sumOhrItemApptnYn")));		/** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
        payr0417Dto.setPayItemUseYn(payItemUseYn.getValue()?"Y":"N");    										/** column 급여항목사용여부 : payItemUseYn */
        payr0417Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(itemApptnBgnnDt.getValue(), "yyyyMMdd"));		/** column 항목적용시작일자 : itemApptnBgnnDt */
        payr0417Dto.setItemApptnEndDt(GWTUtils.getStringFromDate(itemApptnEndDt.getValue(), "yyyyMMdd"));		/** column 항목적용종료일자 : itemApptnEndDt */
        payr0417Dto.setDayMnthAmntDivCd(MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd, "commCd")); 		/** column 일월액구분코드 : dayMnthAmntDivCd */
        payr0417Dto.setCalcStdDivCd(MSFSharedUtils.getSelectedComboValue(calcStdDivCd, "commCd"));    			/** column 계산기준구분코드 : calcStdDivCd */
        payr0417Dto.setCalcStdFunc(MSFSharedUtils.allowNulls(calcStdFunc.getValue()));    						/** column 계산수식내용 : calcStdFunc */
        payr0417Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01);    											/** column 고용구분코드 : emymtDivCd */
        payr0417Dto.setUsalyAmntYn(usalyAmntYn.getValue()?"Y":"N");    											/** column 통상임금여부 : usalyAmntYn */
        payr0417Dto.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(payItemNoteCtnt.getValue()));   				/** column 급여항목비고내용 : payItemNoteCtnt */
		
		
		
		Iterator<BaseModel> itBm = payr0416GridPanel.getMsfGrid().getGrid().getStore().getModels().iterator(); 
				
		List<Record>  lsRec  = new ArrayList<Record>();
          
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 
            
        Iterator<Record> iterRecords = lsRec.iterator() ;  

        List<Payr0417DTO> listpayr0417Dto = new ArrayList<Payr0417DTO>();  
				
		while (iterRecords.hasNext()) {
					
					
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			               
			Payr0417DTO payr0417Dto_1 = new Payr0417DTO(); 
			
//			payr0410Dto_1.setitemDlySeilNum((Long) bmMapModel.get("itemDlySeilNum"));			/** set 급여항목일련번호 : itemDlySeilNum */        
			payr0417Dto_1.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));			/** set 급여구분코드 : payCd */
			payr0417Dto_1.setPayrImcd(MSFSharedUtils.allowNulls(bmMapModel.get("payrImcd")));	/** set 급여항목코드 : payrImcd */
			
			listpayr0417Dto.add(payr0417Dto_1);
		} 
		
		if(ActionDatabase.UPDATE == actionDatabase || (ActionDatabase.UPDATE).equals(actionDatabase)) {
			for(int iPayrCnt=0; iPayrCnt < listpayr0417Dto.size(); iPayrCnt++) {
	                
				Payr0417DTO payr0417Dto_Check = new Payr0417DTO();  
				payr0417Dto_Check = listpayr0417Dto.get(iPayrCnt);   
	            	
	            	
				//내가 선택한 데이터가 아닌 것 중에서
				if(payr0417Dto_Check.getItemDlySeilNum() != payr0417Dto.getItemDlySeilNum() ) {
					if(payr0417Dto.getPayrImcd() == payr0417Dto_Check.getPayrImcd() && payr0417Dto.getPayCd() == payr0417Dto_Check.getPayCd()) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"지급공제항목에 중복된 데이터가 존재합니다.", null);
						return;
					}
				}
			}
		}
		//------
          
		              
		payr5250Service.activityOnPayr0417DetailFormSave(payr0417Dto,  actionDatabase, new AsyncCallback<Long>() {
			public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0410DetailFormSave(" + actionDatabase.name() + ") : " + caught), null);
			}
			public void onSuccess(Long result) { 
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
                     formSubDetilInit();
//                     payr0416GridPanel.reload();
//                     payr0417_reload();
                     payr0417GridPanel.reload();
				} 
			} 
		});
	} 
           
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/
   
	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();

			getAriaSupport().setPresentation(true);
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr5250Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createStandardForm(); 	// 기본정보필드
			vp.setSize("1010px", "700px");
			    
//			    /**
//			     * Create the relations 
//			     */
//				  final RelationDef  relPayr0415 = new RelationDef(payr0417Def,false);
//				  relPayr0415.addJoinDef("dpobCd", "dpobCd");
//				  relPayr0415.addJoinDef("payYr", "payYr");
//				  relPayr0415.addJoinDef("typOccuGrdeMppgSeilNum", "typOccuGrdeMppgSeilNum");
//				  relPayr0415.addJoinDef("typOccuCd", "typOccuCd");
//				  relPayr0415.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
//				 // relPayr0415.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
//				  relPayr0415.setLinkedObject(payr0417GridPanel);
//				  payr0416Def.addRelation(relPayr0415); 
//			       //TODO
//			      // DETAILS 
//			      final Grid payr0417Grid = payr0417GridPanel.getMsfGrid().getGrid();
//			      payr0417Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//			         public void handleEvent(BaseEvent be) {  
//			       	  if (payr0417GridPanel.getCurrentlySelectedItem() != null) { 
//			       		 
//			       	     //선택된 값을 가지고 있는 레코드 
//                        setRecord(payr0417GridPanel.getCurrentlySelectedItem());
//                          
//			       		payr0416Def.synchronizeGridDetail(payr0417GridPanel.getCurrentlySelectedItem(),payr0416GridPanel ); 
//			       			//화면우측에 뿌리기. 
//			       			BaseModel bmPayr0415 = payr0417GridPanel.getCurrentlySelectedItem();
//			       			payYr.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("payYr")));
//			       			/** column 직종 : typOccuNm */ 
//			       			typOccuNm.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("typOccuNm")));
//			       			/** column 직종세 : dtilOccuInttnNm */
//			       			dtilOccuInttnNm.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("dtilOccuInttnNm")));
//			       		
//			       			//hidden 변수
//			       			dpobCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("dpobCd")));
//			       			typOccuGrdeMppgSeilNum.setValue(Long.parseLong(bmPayr0415.get("typOccuGrdeMppgSeilNum").toString()));  /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
//			       			typOccuCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("typOccuCd")));
//			       			dtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("dtilOccuInttnCd")));
//			       			//pyspGrdeCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("pyspGrdeCd"))); 
//			       		 
//			       			srhType.setEnabled(true);  
//					       	srhPayCd.setEnabled(true);
//					        //srhType.clear();
//							//srhPayCd.clear();  		       	  
//					        //IColumnFilter filters = null;
//					       	//payr0416GridPanel.getTableDef().setTableColumnFilters(filters);
//							//payr0416GridPanel.reload();
//			       	   	}
//			       	   
//
//			         }
//			     }); 
			    
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
	public Payr5250() {

		setSize("1010px", "700px");
	}

	public Payr5250(String txtForm) {
		this.txtForm = txtForm;
	}
	 
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 생성자 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/	
	  
	  
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createPayr5250Form() {
	            
		plFrmPayr5250 = new FormPanel();
		plFrmPayr5250.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ "");
		// plFrmPayr5250.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 지급공제항목관리");
		plFrmPayr5250.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr5250.setBodyStyleName("pad-text");
		plFrmPayr5250.setPadding(2);
		plFrmPayr5250.setFrame(true);
	          
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
	  		
		btnlogView.setHeight("10px"); // 로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 로그 뷰화면 호출 메서드
				funcLogMessage("", "PAYR1500");
			}
		});
		plFrmPayr5250.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr5250.getHeader().addTool(btnlogView);
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가
		 ************************************************************************/

		// 멀티콤보박스 닫기
		plFrmPayr5250.addListener(Events.OnClick, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (mutilCombo) {
					if (srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible()) {
						// 직종세
						srhDtilOccuInttnCd.showClose(ce);
						mutilCombo = false;
					}
				}
			}
		});
			
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FlowLayout());

		ButtonBar buttonBar_1 = new ButtonBar();

		Button btnTrnrBusin2 = new Button("단가항목복사");
	    btnTrnrBusin2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				PayrP525003 payrP525003Form = new PayrP525003(ActionDatabase.READ, getThis());   
			    
				MSFFormWindows msFwPayrP525003 = new MSFFormWindows("단가항목복사", payrP525003Form, "닫기", "900px", "600px", true);
				msFwPayrP525003.show();
				payrP525003Form.setMSFFormWindows(msFwPayrP525003);
				
			}
		});
	    buttonBar_1.add(btnTrnrBusin2);

		layoutContainer_1.add(buttonBar_1);
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		topPayr5250Bar = new ButtonBar();

		topPayr5250Bar.setAlignment(HorizontalAlignment.RIGHT);
	          
		btnPayr5250Init = new Button("초기화");
		btnPayr5250Init.setIcon(MSFMainApp.ICONS.new16());
		topPayr5250Bar.add(btnPayr5250Init);
		btnPayr5250Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				formInit();
			}
		});
	           
//	           btnPayr5250New = new Button("신규");  
//	           btnPayr5250New.setIcon(MSFMainApp.ICONS.new16());
//	           topPayr5250Bar.add(btnPayr5250New);
//	           btnPayr5250New.addListener(Events.Select, new Listener<ButtonEvent>() {
//	              public void handleEvent(ButtonEvent e) {
//	                  formNew(); 
//	              }
//	          });
	           
	          
		btnPayr5250Del = new Button("삭제");
		btnPayr5250Del.setIcon(MSFMainApp.ICONS.delete16());
		topPayr5250Bar.add(btnPayr5250Del);
		btnPayr5250Del.addSelectionListener(selectionListener);

		btnPayr5250Sreach = new Button("조회");
		btnPayr5250Sreach.setIcon(MSFMainApp.ICONS.search16());
		topPayr5250Bar.add(btnPayr5250Sreach);
		btnPayr5250Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				searchYn = true;
				payr0416_reload();
			}
		});
	         
	          
		btnPayr5250ExcelFile = new Button("엑셀");
		btnPayr5250ExcelFile.setIcon(Resources.APP_ICONS.excel16());
		topPayr5250Bar.add(btnPayr5250ExcelFile);
		btnPayr5250ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				excelFileExport();
//				Window.alert("준비중입니다.");
			}
		});
	          
	              
//	            btnPayr5250Print = new Button("인쇄"); 
//	            btnPayr5250Print.setIcon(MSFMainApp.ICONS.print16()); 
//	            topPayr5250Bar.add(btnPayr5250Print);  
	            
		layoutContainer_2.add(topPayr5250Bar);
		layoutContainer_2.setBorders(false);
	           
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer.setBorders(false);
	          
		plFrmPayr5250.add(layoutContainer);

		// 파일업로드 처리
		plFrmPayr5250.setAction("bizform");
		plFrmPayr5250.setEncoding(Encoding.MULTIPART);
		plFrmPayr5250.setMethod(Method.POST);

		vp.add(plFrmPayr5250);
		plFrmPayr5250.setSize("990px", "680px");
	}
	         
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
           
		// --------------------단위기관 불러 오는 함수------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		// --------------------단위기관 불러 오는 함수------------------------------------------------

		// --------------------공통 코드 불러 오는 함수
		// -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B008"); // 지급공제구분코드
		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		// --------------------공통 코드 불러 오는 함수-------------------------------------------
	         

		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 년도 콤보박스 처리 시작 
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 */
		ContentPanel payYrGrid = new ContentPanel();
		payYrGrid.setVisible(false);
	                  
		// 년도 콤보처리
		payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true);
		payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
			public void handleEvent(ComponentEvent be) {  
				payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
					public void handleEvent(StoreEvent<BaseModel> be) {  
						lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
	                               
						Date today = new Date(); 
						// A custom date format
						DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
	                               
						BaseModel  bm  =  srhPayYr.getStore().findModel("payYr", fmt.format(today) ); 
						srhPayYr.setValue(bm);
					}  
				});  
			}  
		});  

		payYrGrid.add(payYrGridPanel);
		plFrmPayr5250.add(payYrGrid);
	              
	               
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 직종 콤보박스 처리 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 */
	                  
	                      
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);

		plFrmPayr5250.setLayout(new FlowLayout());

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
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		lcSchLeft.setStyleAttribute("marginBottom", "5px");
		
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);
		
		srhPayYr = new ComboBox<BaseModel>();
		srhPayYr.setName("srhPayYr");
		srhPayYr.setForceSelection(true);
		srhPayYr.setMinChars(1);
		srhPayYr.setDisplayField("payYrDisp");
		srhPayYr.setValueField("payYr");
		srhPayYr.setTriggerAction(TriggerAction.ALL);
		// srhPayYr.setEmptyText("--년도선택--");
		srhPayYr.setSelectOnFocus(true);
		srhPayYr.setReadOnly(false);
		srhPayYr.setEnabled(true);
		srhPayYr.setStore(lsPayYrStore);
		srhPayYr.setFieldLabel("년 도");  
		srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {   
	                	
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				  	 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				  	 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				   		checkPayr5250Auth("srhPayYr", lsPayYrStore); 
				}
			}
		});  
	          
	          
		layoutContainer_8.add(srhPayYr, new FormData("100%"));

		LayoutContainer layoutContainer01 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer01.setLayout(frmlytSch);

		/** column 단위기관 : payrMangDeptCd */
		srhPayrMangDeptCd = new ComboBox<BaseModel>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setForceSelection(true);
		srhPayrMangDeptCd.setMinChars(1);
		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		srhPayrMangDeptCd.setSelectOnFocus(true);
		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
		srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);
		srhPayrMangDeptCd.setFieldLabel("단위기관");
		srhPayrMangDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {
	                	   
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						checkPayr5250Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
				} 
			}
		});    
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")));  
			} 
		});
		layoutContainer01.add(srhPayrMangDeptCd, new FormData("100%"));
		layoutContainer01.setBorders(false);
		
		
		LayoutContainer layoutContainer10 = new LayoutContainer();
		layoutContainer10.setLayout(new ColumnLayout());
		
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(60);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
        srhDeptNm = new MSFTextField(); 
        srhDeptNm.setName("srhDeptNm");
        srhDeptNm.setFieldLabel("부서"); 
        srhDeptNm.setReadOnly(true);
        //currAffnDeptNm.setLabelSeparator("");
        srhDeptNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		
        		if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        			srhDeptCd.setValue("");
        			srhDeptNm.setValue("");
	    		}
	    		if (MSFSharedUtils.paramNull(creDeptNm.getValue())) {
	    			srhDeptCd.setValue("");
	    			srhDeptNm.setValue("");
	    		}  
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        				srhDeptCd.setValue("");
        				srhDeptNm.setValue("");
        			}
        			fnPopupCommP140("srh", srhDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
        lcDeptNm.add(srhDeptNm, new FormData("100%"));  
        
        
        LayoutContainer lcBtnDeptCd = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        lcBtnDeptCd.setLayout(frmlytSch);
          
        btnSrhDeptCd = new Button();
        btnSrhDeptCd.setEnabled(false);
        btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
        btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	 public void handleEvent(ButtonEvent e) { 
        		 if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        			 srhDeptNm.setValue("");
        		 }
        		 fnPopupCommP140("srh", srhDeptNm.getValue()); 
        	 }
        });
        lcBtnDeptCd.add(btnSrhDeptCd);
        
        
        LayoutContainer lcDeptCd = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(0);
        lcDeptCd.setLayout(frmlytSch);
        
        srhDeptCd = new MSFTextField(); 
        srhDeptCd.setLabelSeparator("");
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setReadOnly(true);
        
        lcDeptCd.add(srhDeptCd, new FormData("100%"));
            
        layoutContainer10.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
        layoutContainer10.add(lcBtnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
        layoutContainer10.add(lcDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
        
		LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());

		LayoutContainer layoutContainerTyp = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerTyp.setLayout(frmlytSch);

		srhTypOccuCd = new ComboBox<BaseModel>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setForceSelection(true);
		srhTypOccuCd.setMinChars(1);
		srhTypOccuCd.setDisplayField("typOccuNm");
		srhTypOccuCd.setValueField("typOccuCd");
		srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.setSelectOnFocus(true);
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.setStore(lsTypOccuCd);
		srhTypOccuCd.setFieldLabel("직 종");
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) { 
				//2015.11.30 추가 
		            	
				EventType type = be.getType();
				if (type == Store.Add) {
					if (!gwtExtAuth.getEnableTypOccuCd()) {
						BaseModel mdSelect = srhTypOccuCd.getStore().getAt(0);
						srhTypOccuCd.setValue(mdSelect);

					}
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					// checkPayr5250Auth("srhTypOccuCd", lsTypOccuCd ); 
				}
			}
		});
		
		srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                  
				//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기  
				sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")); 
	                  
				if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                      
					lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
	                      
					lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
							mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
							srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
	                              
							if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
								ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
								srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
								srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
			  		                   // }  
							}
						}
					});

				}
			}
		});
	           
		layoutContainerTyp.add(srhTypOccuCd, new FormData("100%"));
		layoutContainerTyp.setBorders(false);
		
		layoutContainer.add(layoutContainerTyp, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);
	          
	            
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		srhDtilOccuInttnCd.setWidth(100);
		srhDtilOccuInttnCd.setHideLabel(true);
		// srhDtilOccuInttnCd.setHideLabel(true);
		srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
//		srhDtilOccuInttnCd.setFieldLabel("직종세");
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				} else {
					
				}
			}
		});

		layoutContainer_14.add(srhDtilOccuInttnCd, new FormData("100%"));
		layoutContainer_14.setBorders(false);
		layoutContainer.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

		srhPymtDducDivCd = new ComboBox<BaseModel>();
		srhPymtDducDivCd.setName("srhPymtDducDivCd");
		srhPymtDducDivCd.setForceSelection(true);
		srhPymtDducDivCd.setMinChars(1);
		srhPymtDducDivCd.setDisplayField("commCdNm");
		srhPymtDducDivCd.setValueField("commCd");
		srhPymtDducDivCd.setTriggerAction(TriggerAction.ALL);
		srhPymtDducDivCd.setEmptyText("--지급공제구분선택--");
		srhPymtDducDivCd.setSelectOnFocus(true);
		srhPymtDducDivCd.setReadOnly(false);
		srhPymtDducDivCd.setEnabled(true);
		srhPymtDducDivCd.setStore(lsPymtDducDivCd);
		srhPymtDducDivCd.setFieldLabel("지급공제");  
	        
		layoutContainer_1.add(srhPymtDducDivCd, new FormData("100%"));
		layoutContainer_1.setBorders(false);
		lcSchCol.add(layoutContainer_1);

		fieldSet.add(lcSchCol, new FormData("100%"));
		lcSchLeft.setLayout(new ColumnLayout());

		lcSchCol.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));
		lcSchCol.add(layoutContainer01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		lcSchCol.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));

		plFrmPayr5250.add(fieldSet);
		// vp.add(panel);
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

		dpobCd 					= new HiddenField<String>();	// 사업장코드
		dtilOccuDlySeilNum      = new HiddenField<Long>();		/** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
//		typOccuGrdeMppgSeilNum 	= new HiddenField<Long>();		/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		itemDlySeilNum 			= new HiddenField<Long>();		/** column 급여항목일련번호 : itemDlySeilNum */
		
		deptCd 					= new HiddenField<String>();	/** column 부서코드 : deptCd */
		emymtDivCd 				= new HiddenField<String>();	/** column 고용구분코드 : emymtDivCd */
		typOccuCd				= new HiddenField<String>();	/** column 직종코드 : typOccuCd */
		dtilOccuInttnCd 		= new HiddenField<String>();	/** column 직종세코드 : dtilOccuInttnCd */
	
		msfCoCalendarDto 		= new SysCoCalendarDTO();
	            
		// --------------------급여년도 불러 오는 함수------------------------------------------------
		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		// --------------------급여년도 불러 오는 함수------------------------------------------------

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setStyleAttribute("text-align", "right");
		layoutContainer_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		// layoutContainer_4.setLayout(new FormLayout());
		// layoutContainer_1.add(layoutContainer_4, new
		// com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		// layoutContainer_4.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		createPayYr = new ComboBox<BaseModel>();
		createPayYr.setForceSelection(true);
		createPayYr.setMinChars(1);
		createPayYr.setDisplayField("yearDisp");
		createPayYr.setValueField("year");
		createPayYr.setTriggerAction(TriggerAction.ALL);
		createPayYr.setEmptyText("--생성년도선택--");
		createPayYr.setSelectOnFocus(true);
		createPayYr.setReadOnly(false);
		createPayYr.setEnabled(true);
		createPayYr.setStore(lscrPayYr);
		createPayYr.setFieldLabel("생성년도");
		createPayYr.setStyleAttribute("marginTop", "5px");
		createPayYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				checkPayr5250Auth("createPayYr", lscrPayYr);

			}
		});
		layoutContainer_2.add(createPayYr, new FormData("100%"));
		layoutContainer_2.setBorders(false);

		layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_1.setStyleAttribute("marginLeft", "3px");
		
		
		
		
		LayoutContainer layoutContainer10 = new LayoutContainer();
		layoutContainer10.setLayout(new ColumnLayout());
		
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(60);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
        creDeptNm = new MSFTextField(); 
        creDeptNm.setName("deptNm");
        creDeptNm.setFieldLabel("부서"); 
        creDeptNm.setReadOnly(true);
        //currAffnDeptNm.setLabelSeparator("");
        creDeptNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		
        		if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        			creDeptCd.setValue("");
        			creDeptNm.setValue("");
	    		}
	    		if (MSFSharedUtils.paramNull(creDeptNm.getValue())) {
	    			creDeptCd.setValue("");
	    			creDeptNm.setValue("");
	    		}  
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        				creDeptCd.setValue("");
        				creDeptNm.setValue("");
        			}
        			fnPopupCommP140("cre",creDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
        lcDeptNm.add(creDeptNm, new FormData("100%"));  
        
        LayoutContainer lcBtnDeptCd = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        lcBtnDeptCd.setLayout(frmlytSch);
          
        btnDeptCd = new Button();
        btnDeptCd.setEnabled(false);
        btnDeptCd.setIcon(MSFMainApp.ICONS.search()); 
        btnDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	 public void handleEvent(ButtonEvent e) { 
        		 if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        			 creDeptNm.setValue("");
        		 }
        		 fnPopupCommP140("cre", creDeptNm.getValue()); 
        	 }
        });
        lcBtnDeptCd.add(btnDeptCd);
        
        
        LayoutContainer lcDeptCd = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(0);
        lcDeptCd.setLayout(frmlytSch);
        
        creDeptCd = new MSFTextField(); 
        creDeptCd.setLabelSeparator("");
        creDeptCd.setName("creDeptCd");
        creDeptCd.setReadOnly(true);
        
        lcDeptCd.add(creDeptCd, new FormData("100%"));
            
        layoutContainer10.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
        layoutContainer10.add(lcBtnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
        layoutContainer10.add(lcDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
        layoutContainer_1.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// //
		LayoutContainer layoutContainer_btn = new LayoutContainer();

		// ButtonBar buttonBar = new ButtonBar();
		// buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		ButtonBar buttonBar1 = new ButtonBar();
		buttonBar1.setAlignment(HorizontalAlignment.LEFT);

		Button btnNewButton_1 = new Button("지급공제직종세생성");
		btnNewButton_1.setStyleAttribute("marginTop", "5px");
		// btnNewButton_1.setStyleAttribute("marginLeft", "10px");
		buttonBar1.add(btnNewButton_1);
		btnNewButton_1.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 직종세 지급항목 생성하기

				if (searchYn) {
					if(creDeptCd.getValue() == null || "".equals(creDeptCd.getValue())) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), " 버튼 좌측에 있는 부서 선택 후 생성 가능합니다.", null);
						return;
					}else {
						formNew();
					}
					
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), " 직종정보 조회 후 생성 가능합니다.", null);
				}

			}
		}); 
		Button btnNewButton_2 = new Button("이전년도직종세이관");
		btnNewButton_2.setStyleAttribute("marginTop", "5px");
		// btnNewButton_2.setStyleAttribute("marginLeft", "5px");
		buttonBar1.add(btnNewButton_2);
		btnNewButton_2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
//				Window.alert("준비중입니다.");
//
				PayrP525001 payrP525001Form = new PayrP525001(ActionDatabase.CUSTOM, getThis());
				MSFFormWindows msFwInsr15001 = new MSFFormWindows("이전년도직종세이관", payrP525001Form, "닫기", "600px", "400px", true);
				msFwInsr15001.show();
				payrP525001Form.setMSFFormWindows(msFwInsr15001);
				// funcSetPopUpRecord();
				// insrP23005Form.bind(ppRecord);

			}
		});
		layoutContainer_btn.add(buttonBar1);
		layoutContainer_1.add(layoutContainer_btn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		// ----

		LayoutContainer layoutContainer_btn2 = new LayoutContainer();

		ButtonBar buttonBar2 = new ButtonBar();
		buttonBar2.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNewButton_3 = new Button("직종세지급항목일괄생성");
		btnNewButton_3.setStyleAttribute("marginTop", "5px");
//	              btnNewButton_3.setStyleAttribute("marginLeft", "380px");
		buttonBar2.add(btnNewButton_3);
		btnNewButton_3.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
//				Window.alert("준비중입니다.");
				
//				// TODO
				PayrP525002 payrP525002Form = new PayrP525002(ActionDatabase.CUSTOM, getThis());
				MSFFormWindows msFwInsr15002 = new MSFFormWindows("직종세지급항목일괄생성", payrP525002Form, "닫기", "1010px","650px", true);
				msFwInsr15002.show();
				payrP525002Form.setMSFFormWindows(msFwInsr15002);

				funcSetPopUpRecord();
				payrP525002Form.bind(ppRecord);

			}
		});
//	              layoutContainer_1.add(buttonBar); 
	    
		layoutContainer_btn2.add(buttonBar2);
		
		layoutContainer_1.add(layoutContainer_btn2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		// layoutContainer_btn.add(buttonBar2);

		layoutContainer_1.setBorders(false);
		layoutContainer_5.add(layoutContainer_1);
		layoutContainer_5.setBorders(true);

		plFrmPayr5250.add(layoutContainer_5);

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize(330, 300);
	          
	          
		layoutContainer_11.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("직종정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer_11.setBorders(false);
		layoutContainer_11.setStyleAttribute("marginTop", "10px");

		fldstNewFieldset.add(occupationalLeft(), new FormData("100%"));

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize(626, 300);

		layoutContainer_21.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("지급공제항목설정");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
	          
	          
		fldstNewFieldset_1.add(occupationalRTop(), new FormData("100%"));

		LayoutContainer layoutContainer_31 = new LayoutContainer();
		layoutContainer_31.setLayout(new ColumnLayout());

		FieldSet fldstNewFieldset_4 = new FieldSet();
		fldstNewFieldset_4.setCollapsible(false);

		LayoutContainer layoutContainer_41 = new LayoutContainer();
		layoutContainer_41.add(payrLeft01());
		fldstNewFieldset_4.add(layoutContainer_41);
		layoutContainer_41.setBorders(false);
		layoutContainer_31.add(fldstNewFieldset_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		fldstNewFieldset_4.setHeadingHtml("지급공제항목");
		fldstNewFieldset_1.add(layoutContainer_31);
		layoutContainer_31.setBorders(false);

		layoutContainer.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.63));
		layoutContainer_21.setBorders(false);
		layoutContainer_21.setStyleAttribute("marginLeft", "-30px");

		plFrmPayr5250.add(layoutContainer);
		layoutContainer.setBorders(false);
	          
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new FlowLayout());

		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(962, 190);
		layoutContainer_3.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("지급공제상세정보");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "5px");

		fldstNewFieldset_2.add(occupationalRBottom(), new FormData("100%"));

		plFrmPayr5250.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);

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
	// 지급공제항목설정
	private LayoutContainer occupationalRTop() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(600, 30);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(40);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);

		payYr = new TextField<String>();
		payYr.setFieldLabel("년 도");
		layoutContainer_13.add(payYr, new FormData("100%"));
		layoutContainer_13.setBorders(false);

		layoutContainer_12.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));
		
		
		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);

		deptNm = new TextField<String>();
		deptNm.setFieldLabel("부서");
		layoutContainer_14.add(deptNm, new FormData("100%"));
		layoutContainer_14.setBorders(false);

		layoutContainer_12.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));
		
		

		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytStd);

		typOccuNm = new TextField<String>();
		typOccuNm.setFieldLabel("직 종");
		layoutContainer.add(typOccuNm, new FormData("100%"));

		layoutContainer.setBorders(false);
		layoutContainer_12.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer14 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14.setLayout(frmlytStd);

		dtilOccuInttnNm = new TextField<String>();
		dtilOccuInttnNm.setFieldLabel("직종세");
		layoutContainer14.add(dtilOccuInttnNm, new FormData("100%"));

		layoutContainer14.setBorders(false);
		layoutContainer_12.add(layoutContainer14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_12.setBorders(false);

		lytCtr01.add(layoutContainer_12);
		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
	

	// 지급공제항목상세정보
	private LayoutContainer occupationalRBottom() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FlowLayout());
		cp01.setSize(955, 165);
	         
	       
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		/** column 급여항목코드 : payrImcd */
		payrImcd = new TextField<String>();
		layoutContainer_1.add(payrImcd, new FormData("100%"));
		payrImcd.setFieldLabel("항 목");
		layoutContainer_1.setBorders(false);
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		/** column 항목명 : itemNm */
		itemNm = new TextField<String>();
		layoutContainer_2.add(itemNm, new FormData("100%"));
		itemNm.setLabelSeparator("");
		itemNm.setFieldLabel("");
		layoutContainer_2.setBorders(false);
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	             
	          
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
	          
	          
		// --------------------공통 코드 불러 오는 함수-------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B015"); // 급여구분코드
		lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 급여구분코드 : payCd */
		payCd = new ComboBox<BaseModel>();
		payCd.setForceSelection(true);
		payCd.setMinChars(1);
		payCd.setDisplayField("commCdNm");
		payCd.setValueField("commCd");
		payCd.setTriggerAction(TriggerAction.ALL);
		payCd.setEmptyText("--급여구분선택--");
		payCd.setSelectOnFocus(true);
		payCd.setReadOnly(false);
		payCd.setEnabled(true);
		payCd.setStore(lsPayCd);
		payCd.setFieldLabel("급여구분");

		layoutContainer_3.add(payCd, new FormData("100%"));
		layoutContainer_3.setBorders(false);
		layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
	        
	          
		// --------------------공통 코드 불러 오는 함수-------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B016"); // 과세구분
		lsDayMnthAmntDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 일월액구분코드 : dayMnthAmntDivCd */
		dayMnthAmntDivCd = new ComboBox<BaseModel>();
		dayMnthAmntDivCd.setForceSelection(true);
		dayMnthAmntDivCd.setMinChars(1);
		dayMnthAmntDivCd.setDisplayField("commCdNm");
		dayMnthAmntDivCd.setValueField("commCd");
		dayMnthAmntDivCd.setTriggerAction(TriggerAction.ALL);
		dayMnthAmntDivCd.setEmptyText("--일월액구분선택--");
		dayMnthAmntDivCd.setSelectOnFocus(true);
		dayMnthAmntDivCd.setReadOnly(false);
		dayMnthAmntDivCd.setEnabled(true);
		dayMnthAmntDivCd.setStore(lsDayMnthAmntDivCd);
		dayMnthAmntDivCd.setFieldLabel("일월액구분");

		layoutContainer_4.add(dayMnthAmntDivCd, new FormData("100%"));
		layoutContainer_4.setBorders(false);
	          
		layoutContainer.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);

		/** column 통상임금여부 : usalyAmntYn */
		usalyAmntYn = new CheckBox();
		usalyAmntYn.setBoxLabel("통상임금");
		usalyAmntYn.setHideLabel(true);
		layoutContainer_9.add(usalyAmntYn, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		// layoutContainer_9.setStyleAttribute("padding-left", "27px");

		layoutContainer_5.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		/** column 급여항목사용여부 : payItemUseYn */
		payItemUseYn = new CheckBox();
		payItemUseYn.setBoxLabel("사용여부");
		payItemUseYn.setHideLabel(true);
		layoutContainer_10.add(payItemUseYn, new FormData("100%"));
		layoutContainer_10.setBorders(false);
		// layoutContainer_10.setStyleAttribute("padding-left", "25px");

		layoutContainer_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_5.setBorders(false);
		layoutContainer.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		layoutContainer.setBorders(false);

		cp01.add(layoutContainer);
	          
	          
		LayoutContainer layoutContainer02 = new LayoutContainer();
		layoutContainer02.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);
	          

		// --------------------공통 코드 불러 오는 함수-------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B008"); // 지급공제구분코드
		lsGdPymtDducDivCd = PrgmComComboUtils
				.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 지급공제구분코드 : pymtDducDivCd */
		pymtDducDivCd = new ComboBox<BaseModel>();
		pymtDducDivCd.setForceSelection(true);
		pymtDducDivCd.setMinChars(1);
		pymtDducDivCd.setDisplayField("commCdNm");
		pymtDducDivCd.setValueField("commCd");
		pymtDducDivCd.setTriggerAction(TriggerAction.ALL);
		pymtDducDivCd.setEmptyText("--지급공제구분선택--");
		pymtDducDivCd.setSelectOnFocus(true);
		pymtDducDivCd.setReadOnly(false);
		pymtDducDivCd.setEnabled(true);
		pymtDducDivCd.setStore(lsGdPymtDducDivCd);
		pymtDducDivCd.setFieldLabel("지급(공제)구분");

		layoutContainer_11.add(pymtDducDivCd, new FormData("100%"));
		layoutContainer_11.setBorders(false);

		layoutContainer02.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytStd);
	          

		// --------------------공통 코드 불러 오는 함수-------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B017"); // 지급공제유형코드
		lsPymtDducFrmCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 지급공제유형코드 : pymtDducFrmCd */
		pymtDducFrmCd = new ComboBox<BaseModel>();
		pymtDducFrmCd.setForceSelection(true);
		pymtDducFrmCd.setMinChars(1);
		pymtDducFrmCd.setDisplayField("commCdNm");
		pymtDducFrmCd.setValueField("commCd");
		pymtDducFrmCd.setTriggerAction(TriggerAction.ALL);
		pymtDducFrmCd.setEmptyText("--지급공제유형선택--");
		pymtDducFrmCd.setSelectOnFocus(true);
		pymtDducFrmCd.setReadOnly(false);
		pymtDducFrmCd.setEnabled(true);
		pymtDducFrmCd.setStore(lsPymtDducFrmCd);
		pymtDducFrmCd.setFieldLabel("지급(공제)유형");
		layoutContainer_21.add(pymtDducFrmCd, new FormData("100%"));
		layoutContainer_21.setBorders(false);
	          
		layoutContainer02.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer layoutContainer_31 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_31.setLayout(frmlytStd);

		/** column 지급공제액 : pymtDducSum */
		pymtDducSum = new NumberField();
		pymtDducSum.setFieldLabel("지급(공제)금액");
		pymtDducSum.setAllowDecimals(true);
		pymtDducSum.setPropertyEditorType(Long.class);
		pymtDducSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_31.add(pymtDducSum, new FormData("100%"));
		layoutContainer_31.setBorders(false);
		layoutContainer02.add(layoutContainer_31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer layoutContainer_41 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_41.setLayout(frmlytStd);

		/** column 지급공제율 : pymtDducRate */
		pymtDducRate = new NumberField();
		pymtDducRate.setFieldLabel("지급(공제)율");
		pymtDducRate.setAllowDecimals(true);
		pymtDducRate.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_41.add(pymtDducRate, new FormData("100%"));
		layoutContainer_41.setBorders(false);
	          
		layoutContainer02.add(layoutContainer_41,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		// --------------------공통 코드 불러 오는 함수
		// -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B019"); // 급여게산기준코드
		lsCalcStdDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 계산기준구분코드 : calcStdDivCd */
		calcStdDivCd = new ComboBox<BaseModel>();
		calcStdDivCd.setForceSelection(true);
		calcStdDivCd.setMinChars(1);
		calcStdDivCd.setDisplayField("commCdNm");
		calcStdDivCd.setValueField("commCd");
		calcStdDivCd.setTriggerAction(TriggerAction.ALL);
		calcStdDivCd.setEmptyText("--계산기준선택--");
		calcStdDivCd.setSelectOnFocus(true);
		calcStdDivCd.setReadOnly(false);
		calcStdDivCd.setEnabled(true);
		calcStdDivCd.setStore(lsCalcStdDivCd);
		calcStdDivCd.setFieldLabel("계산기준");

		layoutContainer_6.add(calcStdDivCd, new FormData("100%"));
		layoutContainer_6.setBorders(false);

		layoutContainer02.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		layoutContainer02.setBorders(false);
		cp01.add(layoutContainer02);
	         
		LayoutContainer layoutContainer03 = new LayoutContainer();
		layoutContainer03.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytStd);

		// --------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B005"); // 과세구분
		lsTxtnDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 과세구분코드 : txtnDivCd */
		txtnDivCd = new ComboBox<BaseModel>();
		txtnDivCd.setForceSelection(true);
		txtnDivCd.setMinChars(1);
		txtnDivCd.setDisplayField("commCdNm");
		txtnDivCd.setValueField("commCd");
		txtnDivCd.setTriggerAction(TriggerAction.ALL);
		txtnDivCd.setEmptyText("--과세구분선택--");
		txtnDivCd.setSelectOnFocus(true);
		txtnDivCd.setReadOnly(false);
		txtnDivCd.setEnabled(true);
		txtnDivCd.setStore(lsTxtnDivCd);
		txtnDivCd.setFieldLabel("과세구분");
		layoutContainer_12.add(txtnDivCd, new FormData("100%"));
		layoutContainer_12.setBorders(false);

		layoutContainer03.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer layoutContainer_22 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_22.setLayout(frmlytStd);

		/** column 비과세금액 : freeDtySum */
		freeDtySum = new NumberField();
		freeDtySum.setFieldLabel("비과세금액");
		freeDtySum.setAllowDecimals(true);
		freeDtySum.setPropertyEditorType(Long.class);
		freeDtySum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_22.add(freeDtySum, new FormData("100%"));
		layoutContainer_22.setBorders(false);
		layoutContainer03.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
		LayoutContainer layoutContainer_32 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytStd);

		/** column 비과세율 : freeDtyRate */
		freeDtyRate = new NumberField();
		freeDtyRate.setFieldLabel("비과세율");
		freeDtyRate.setAllowDecimals(true);
		freeDtyRate.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_32.add(freeDtyRate, new FormData("100%"));
		layoutContainer03.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_32.setBorders(false);

		LayoutContainer layoutContainer_42 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytStd);

		/** column 항목적용시작일자 : itemApptnBgnnDt */
		itemApptnBgnnDt = new DateField();
		new DateFieldMask(itemApptnBgnnDt, "9999.99.99");
		itemApptnBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		// itemApptnBgnnDt.setPropertyEditor(new
		// DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat()));
		itemApptnBgnnDt.setName("itemApptnBgnnDt");
		itemApptnBgnnDt.setFieldLabel("시작일자");

		layoutContainer_42.add(itemApptnBgnnDt, new FormData("100%"));

		layoutContainer03.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		layoutContainer_42.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		/** column 항목적용종료일자 : itemApptnEndDt */
		itemApptnEndDt = new DateField();
		itemApptnEndDt.setName("itemApptnEndDt");
		new DateFieldMask(itemApptnEndDt, "9999.99.99");
		itemApptnEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		// itemApptnEndDt.setPropertyEditor(new
		// DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat()));
		itemApptnEndDt.setFieldLabel("종료일자");

		layoutContainer_7.add(itemApptnEndDt, new FormData("100%"));
		layoutContainer_7.setBorders(false);
		layoutContainer03.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		layoutContainer03.setBorders(false);
		cp01.add(layoutContainer03);

		LayoutContainer layoutContainer04 = new LayoutContainer();
		layoutContainer04.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(50);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);

		Listener<BaseEvent> chkListener = new CheckboxListener();
		CheckBoxGroup chckbxgrpNewCheckboxgroup = new CheckBoxGroup();

		/** column 1월 : jan */
		jan = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(jan);
		jan.setBoxLabel("1월");
		jan.setHideLabel(true);

		/** column 2월 : feb */
		feb = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(feb);
		feb.setBoxLabel("2월");
		feb.setHideLabel(true);

		/** column 3월 : mar */
		mar = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(mar);
		mar.setBoxLabel("3월");
		mar.setHideLabel(true);

		/** column 4월 : apr */
		apr = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(apr);
		apr.setBoxLabel("4월");
		apr.setHideLabel(true);

		/** column 5월 : may */
		may = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(may);
		may.setBoxLabel("5월");
		may.setHideLabel(true);
	          
		/** column 6월 : jun */
		jun = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(jun);
		jun.setBoxLabel("6월");
		jun.setHideLabel(true);

		/** column 7월 : jul */
		jul = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(jul);
		jul.setBoxLabel("7월");
		jul.setHideLabel(true);

		/** column 8월 : aug */
		aug = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(aug);
		aug.setBoxLabel("8월");
		aug.setHideLabel(true);

		/** column 9월 : sep */
		sep = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(sep);
		sep.setBoxLabel("9월");
		sep.setHideLabel(true);

		/** column 10월 : oct */
		oct = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(oct);
		oct.setBoxLabel("10월");
		oct.setHideLabel(true);

		/** column 11월 : nov */
		nov = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(nov);
		nov.setBoxLabel("11월");
		nov.setHideLabel(true);

		/** column 12월 : dec */
		dec = new CheckBox();

		chckbxgrpNewCheckboxgroup.add(dec);
		dec.setBoxLabel("12월");
		dec.setHideLabel(true);

		chkAll = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(chkAll);
		chkAll.addListener(Events.OnClick, chkListener);
		chkAll.setBoxLabel("전체");
		chkAll.setHideLabel(true);

		layoutContainer_13.add(chckbxgrpNewCheckboxgroup, new FormData("100%"));
		chckbxgrpNewCheckboxgroup.setFieldLabel("지급월");
		layoutContainer04.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		layoutContainer_13.setBorders(false);

		LayoutContainer layoutContainer_43 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(40);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_43.setLayout(frmlytStd);

		/** column 정렬순서 : rngeOrd */
		rngeOrd = new NumberField();
		rngeOrd.setFieldLabel("순서");
		rngeOrd.setPropertyEditorType(Long.class);
		rngeOrd.setAllowDecimals(true);
		rngeOrd.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_43.add(rngeOrd, new FormData("100%"));
		layoutContainer_43.setBorders(false);
		layoutContainer04.add(layoutContainer_43,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		layoutContainer04.setBorders(false);
		cp01.add(layoutContainer04);

		LayoutContainer layoutContainer04_1 = new LayoutContainer();
		layoutContainer04_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);

		/** column 급여항목비고내용 : payItemNoteCtnt */
		payItemNoteCtnt = new TextField<String>();
		payItemNoteCtnt.setFieldLabel("비 고");
		layoutContainer_8.add(payItemNoteCtnt, new FormData("100%"));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_8_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8_1.setLayout(frmlytStd);

		/** column 단위기관 : payrMangDeptCd */
		payrMangDeptCd = new ComboBox<BaseModel>();
		payrMangDeptCd.setName("payrMangDeptCd");
		payrMangDeptCd.setForceSelection(true);
		payrMangDeptCd.setMinChars(1);
		payrMangDeptCd.setDisplayField("payrMangDeptNm");
		payrMangDeptCd.setValueField("payrMangDeptCd");
		payrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		payrMangDeptCd.setEmptyText("--단위기관선택--");
		payrMangDeptCd.setSelectOnFocus(true);
		payrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		payrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
		payrMangDeptCd.setStore(lsPayrMangDeptCd);
		payrMangDeptCd.setFieldLabel("단위기관");
	 	payrMangDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	 		public void handleEvent(StoreEvent<BaseModel> be) {  
	 			payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd() ));  
	 			EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						checkPayr5250Auth("PayrMangDeptCd", lsPayrMangDeptCd); 
				}
	 		}
	 	});    
		payrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

			}
		});

		layoutContainer_8_1.add(payrMangDeptCd, new FormData("100%"));
		layoutContainer_8_1.setBorders(false);

		layoutContainer04_1.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer04_1.add(layoutContainer_8_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer04_1.setBorders(false);
		cp01.add(layoutContainer04_1);

		calcStdFunc = new TextField<String>();
		calcStdFunc.setFieldLabel("게산식");
		calcStdFunc.setVisible(false);
		
		LayoutContainer layoutContainer04_2 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcBtn = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button btnSave = new Button("저장");
		btnSave.addListener(Events.OnClick, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				actionDatabase = ActionDatabase.UPDATE;
				detailFormSave();
			}
			
		});
		btnBar.add(btnSave);
		
		
		Button btnDel = new Button("삭제");
		btnDel.addListener(Events.OnClick, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				if (!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {

					MessageBox.alert("오류","마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
					return;

				}

				MessageBox.confirm("경고","지급공제상세정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)", new Listener<MessageBoxEvent>() {
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// if("Yes".equals(be.getButtonClicked().getText())){
						if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {
							actionDatabase = ActionDatabase.DELETE;
							detailFormSave();
						}
					}
				});
			}
			
		});
		btnBar.add(btnDel);	
		
		lcBtn.add(btnBar);
		
		layoutContainer04_2.add(lcBtn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		
		cp01.add(layoutContainer04_2);
		
		
		

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// 지급공제항목
	private LayoutContainer payrLeft01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		lcTabFormLayer.setStyleAttribute("paddingLeft", "10px");  
        lcTabFormLayer.setStyleAttribute("paddingRight", "10px");  

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(600, 220);

		sysComBass0300Dto = new PrgmComBass0300DTO();

		// --------------------공통 코드 불러 오는함수-------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B008"); // 지급공제구분코드
		lsGdPymtDducDivCd =PrgmComComboUtils
				.getSingleBass0300ComboData(sysComBass0300Dto);
		// --------------------공통 코드 불러 오는 함수-------------------------------------------

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setStyleAttribute("text-align", "right");
		layoutContainer_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
		
		ToolBar toolBar = new ToolBar();
		//toolBar.getAriaSupport().setLabel("지급공제구분");
		//toolBar.add(new FillToolItem());
		toolBar.add(new LabelToolItem("급여구분: "));
		 
		
		sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
    	lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);

    	/** column 급여구분코드 : payCd */
    	srhPayCd = new ComboBox<BaseModel>(); 
    	srhPayCd.setName("srhPayCd");
    	srhPayCd.setForceSelection(true);
    	srhPayCd.setMinChars(1);
    	srhPayCd.setDisplayField("commCdNm");
    	srhPayCd.setValueField("commCd");
    	srhPayCd.setTriggerAction(TriggerAction.ALL);
    	srhPayCd.setEmptyText("--급여구분선택--");
    	srhPayCd.setSelectOnFocus(true); 
    	srhPayCd.setReadOnly(false);
    	srhPayCd.setEnabled(false); 
    	srhPayCd.setStore(lsPayCd); 
    	srhPayCd.setFieldLabel("급여구분");  
    	
    	srhPayCd.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent be) {
//				IColumnFilter filters = null;
//				payr0416GridPanel.getTableDef().setTableColumnFilters(filters);
//				payr0416GridPanel.getTableDef().addColumnFilter("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
//				payr0416GridPanel.reload();
			}
		});
    	
    	
    	
    	toolBar.add(srhPayCd);
    	
		
		toolBar.add(new LabelToolItem("지급공제구분: "));
		srhType = new ComboBox<BaseModel>();
		srhType.setName("srhType");
		srhType.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
		srhType.setTriggerAction(TriggerAction.ALL);
		//srhType.setEditable(false);
		srhType.setEmptyText("--지급공제구분선택--");
		srhType.setFireChangeEventOnSetValue(true);
		srhType.setWidth(150);
		srhType.setDisplayField("commCdNm");
		srhType.setValueField("commCd");
		srhType.setReadOnly(false);		
		srhType.setEnabled(false);		
		srhType.setStore(lsGdPymtDducDivCd);
		srhType.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent be) {
//				IColumnFilter filters = null;
//				payr0416GridPanel.getTableDef().setTableColumnFilters(filters);
//				payr0416GridPanel.getTableDef().addColumnFilter("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
//				payr0416GridPanel.getTableDef().addColumnFilter("pymtDducDivCd",MSFSharedUtils.getSelectedComboValue(srhType, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
//				payr0416GridPanel.reload();
				
				
				
			}
		});
		
		
		toolBar.add(srhType);

		layoutContainer_2.add(toolBar, new FormData("100%"));
		layoutContainer_2.setBorders(false);

		layoutContainer_1.add(layoutContainer_2,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		layoutContainer_1.setStyleAttribute("marginLeft", "3px");

		// LayoutContainer layoutContainer_6 = new LayoutContainer();

		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNew = new Button("신규");
		btnNew.setIcon(MSFMainApp.ICONS.new16());
		btnNew.setStyleAttribute("marginTop", "3px");
		btnNew.setStyleAttribute("marginLeft", "50px");
		buttonBar.add(btnNew);

		btnNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				if (MSFSharedUtils.paramNull(srhPayCd.getValue())) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여구분을 선택하세요", null);
					return;
				} else {
					fnPopupCommP500();
				}
			}
		});

		// layoutContainer_6.add(buttonBar, new FormData("100%"));

		layoutContainer_1.add(buttonBar);
		layoutContainer_1.setBorders(false);

		layoutContainer_5.add(layoutContainer_1);
		layoutContainer_5.setBorders(true);

		// toolBar.add(layoutContainer_01);

		cp01.setTopComponent(layoutContainer_5);

		/*
		 * cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>()
		 * {
		 * 
		 * @Override public void componentSelected(ButtonEvent ce) {
		 * fnPopupCommP500(); } }));
		 */

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0417GridPanel = new MSFGridPanel(payr0417Def, false, false, false, false, false);
		payr0417GridPanel.setHeaderVisible(false);
		payr0417GridPanel.setBodyBorder(true);
		payr0417GridPanel.setBorders(true);
		payr0417GridPanel.setSize(600, 220);
		// DETAILS
		final Grid payr0410Grid = payr0417GridPanel.getMsfGrid().getGrid();
		payr0410Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (payr0417GridPanel.getCurrentlySelectedItem() != null) { 
					
					dpobCd.setValue(MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("dpobCd")));
					payYr.setValue(MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("payYr")));		/** column 급여년도 : payYr */
					dtilOccuDlySeilNum.setValue((Long)payr0417GridPanel.getCurrentlySelectedItem().get("dtilOccuDlySeilNum"));  /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */ 
//					Window.alert("직종세단가항목일련번호 : " + dtilOccuDlySeilNum.getValue());
					
					itemDlySeilNum.setValue((Long)payr0417GridPanel.getCurrentlySelectedItem().get("itemDlySeilNum"));   		/** column 급여일용단가항목일련번호 : itemDlySeilNum */
//					Window.alert("급여일용단가항목일련번호 : " + itemDlySeilNum.getValue());
//					Window.alert("1111111111111");
					payrImcd.setValue(MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("payrImcd")));	/** column 급여항목코드 : payrImcd */                          
	                itemNm.setValue(MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("itemNm")));   	/** column 항목명 : itemNm */                                         
	                payCd.setValue(lsPayCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("payCd"))));   						/** column 급여구분코드 : payCd */                                  
	                pymtDducDivCd.setValue(lsGdPymtDducDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("pymtDducDivCd"))));	/** column 지급공제구분코드 : pymtDducDivCd */              
	                pymtDducFrmCd.setValue(lsPymtDducFrmCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("pymtDducFrmCd"))));   /** column 지급공제유형코드 : pymtDducFrmCd */              
	              
//	                Window.alert("222222222");
	                
	                pymtDducRate.setValue((Double)payr0417GridPanel.getCurrentlySelectedItem().get("pymtDducRate"));   			/** column 지급공제율 : pymtDducRate */                      
	                pymtDducSum.setValue((Long)payr0417GridPanel.getCurrentlySelectedItem().get("pymtDducSum"));   				/** column 지급공제액 : pymtDducSum */                        
	                txtnDivCd.setValue(lsTxtnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("txtnDivCd"))));   			/** column 과세구분코드 : txtnDivCd */                          
	                freeDtyRate.setValue((Double)payr0417GridPanel.getCurrentlySelectedItem().get("freeDtyRate"));   			/** column 비과세율 : freeDtyRate */                          
	                freeDtySum.setValue((Long)payr0417GridPanel.getCurrentlySelectedItem().get("freeDtySum"));   				/** column 비과세금액 : freeDtySum */  
	                  
//	                Window.alert("333333333");
	                jan.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("jan"))?true:false);				/** column 1월 : jan */
	                feb.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("feb"))?true:false);   			/** column 2월 : feb */
	                mar.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("mar"))?true:false);   			/** column 3월 : mar */
	                apr.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("apr"))?true:false);   			/** column 4월 : apr */
	                may.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("may"))?true:false);   			/** column 5월 : may */
	                jun.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("jun"))?true:false);   			/** column 6월 : jun */
	            	jul.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("jul"))?true:false);   			/** column 7월 : jul */
	               	aug.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("aug"))?true:false);   			/** column 8월 : aug */
	               	sep.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("sep"))?true:false);	  			/** column 9월 : sep */
	               	oct.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("oct"))?true:false);   			/** column 10월 : oct */
	             	nov.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("nov"))?true:false);   			/** column 11월 : nov */
	              	dec.setValue("Y".equals(payr0417GridPanel.getCurrentlySelectedItem().get("dec"))?true:false);   			/** column 12월 : dec */ 
	                     
//	                Window.alert("44444444444");
	              	
	              	rngeOrd.setValue((Long)payr0417GridPanel.getCurrentlySelectedItem().get("rngeOrd"));   																				/** column 정렬순서 : rngeOrd */                        
	              	payItemUseYn.setValue((Boolean) payr0417GridPanel.getCurrentlySelectedItem().get("payItemUseYn")?true:false); 													/** column 급여항목사용여부 : payItemUseYn */      
	              	
	              	itemApptnBgnnDt.setValue(GWTUtils.getDateFromString((String)payr0417GridPanel.getCurrentlySelectedItem().get("itemApptnBgnnDt"), "yyyyMMdd"));						/** column 항목적용시작일자 : itemApptnBgnnDt */
	            	itemApptnEndDt.setValue(GWTUtils.getDateFromString((String)payr0417GridPanel.getCurrentlySelectedItem().get("itemApptnEndDt"), "yyyyMMdd")) ;						/** column 항목적용종료일자 : itemApptnEndDt */   
	               	dayMnthAmntDivCd.setValue(lsDayMnthAmntDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("dayMnthAmntDivCd"))));	/** column 일월액구분코드 : dayMnthAmntDivCd */
	             	calcStdDivCd.setValue(lsCalcStdDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("calcStdDivCd"))));   			/** column 계산기준구분코드 : calcStdDivCd */      
	              	usalyAmntYn.setValue((Boolean) payr0417GridPanel.getCurrentlySelectedItem().get("usalyAmntYn")?true:false);   													/** column 통상임금여부 : usalyAmntYn */            
	             	payItemNoteCtnt.setValue(MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("payItemNoteCtnt")));   										/** column 급여항목비고내용 : payItemNoteCtnt */ 
	             	
//	             	Window.alert("5555555555");
	             	
	             	payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("payrMangDeptCd"))));/** column 급여관리부서코드 : payrMangDeptCd */
	             	calcStdFunc.setValue(MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("calcStdFunc")));   												/** column 계산수식내용 : calcStdFunc */
	                      
//	             	Window.alert("단위기관 : " +  MSFSharedUtils.allowNulls(payr0417GridPanel.getCurrentlySelectedItem().get("payrMangDeptCd")));
	             	//삭제와 업데이트를 위한 값을 넣은다.
	             	setDetailRecord(payr0417GridPanel.getCurrentlySelectedItem());
	                     
				}
			}
		});

		// msfGridPanel.setMSFFormPanel(msfCustomForm); //폼을 그리드에 넣은다.
		cp01.add(payr0417GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	   
	private LayoutContainer occupationalLeft() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");  
        lcTabFormLayer.setStyleAttribute("paddingRight", "5px");  

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(320, 270);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0416GridPanel = new MSFGridPanel(payr0416Def, false, false, false, false, false);
		payr0416GridPanel.setHeaderVisible(false);
		payr0416GridPanel.setBodyBorder(true);
		payr0416GridPanel.setBorders(true);
		payr0416GridPanel.setSize(320, 270);
		// msfGridPanel.setMSFFormPanel(msfCustomForm); //폼을 그리드에 넣은다.
		// DETAILS
		final Grid payr0416Grid = payr0416GridPanel.getMsfGrid().getGrid();
		payr0416Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (payr0416GridPanel.getCurrentlySelectedItem() != null) { 
					
					
//					Window.alert("일단");
					
					
					setRecord(payr0416GridPanel.getCurrentlySelectedItem());
					
					formSubInit();
					formSubDetilInit();
					
//					Window.alert("ㄴㄴㄴ");
					// 급여구분, 지급공제구분 활성화
			    	srhPayCd.setReadOnly(false);
			    	srhPayCd.setEnabled(true);
			    	
					srhType.setReadOnly(false);		
					srhType.setEnabled(true);		
					
//					Window.alert("111");
					
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
					leftPayr0416Detail(payr0416GridPanel.getCurrentlySelectedItem());
					
                    
				}
			}
		});		
		cp01.add(payr0416GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
    private void leftPayr0416Detail(BaseModel selRecord) {
    	
//    	Window.alert("111");
		 
    	// 지급공제항목설정 보여주기
		payYr.setValue((String)selRecord.get("payYr"));							/** column 급여년도 : payYr */
		deptNm.setValue((String)selRecord.get("deptNm"));
		typOccuCd.setValue((String)selRecord.get("typOccuCd"));					/** column 직종코드 : typOccuCd */
		typOccuNm.setValue((String)selRecord.get("typOccuNm"));					/** column 직종코드 : typOccuCd */
		dtilOccuInttnCd.setValue((String)selRecord.get("dtilOccuInttnCd"));		/** column 직종세코드 : dtilOccuInttnCd */
		dtilOccuInttnNm.setValue((String)selRecord.get("dtilOccuInttnNm"));		/** column 직종세코드 : dtilOccuInttnCd */
		
		dtilOccuDlySeilNum.setValue((Long) selRecord.get("dtilOccuDlySeilNum"));/** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
		
		
//		Window.alert("222");
		
		// 지급공제항목조회
		payr0417_reload(selRecord);
    
    }
	
	
	
	
	
	  
	        
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~ 그리드 처리 함수 종료 ~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/  
	
	
	public void payr0416_reload() {
		// TODO Auto-generated method stub
		if (MSFSharedUtils.paramNull(srhPayYr.getValue())) {
			MessageBox.alert("데이터 오류", "년도는 필수 선택사항입니다.", null);
			srhPayYr.focus();
			return;
		}
     
		IColumnFilter filters = null;
		payr0416GridPanel.getTableDef().setTableColumnFilters(filters);
	               
		payr0416GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0416GridPanel.getTableDef().addColumnFilter("deptCd", srhDeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		//    payr0417GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		payr0416GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0416GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		payr0416GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	              //payr0417GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0416GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"pymtDducDivCd"), SimpleColumnFilter.OPERATOR_EQUALS); 

		payr0416GridPanel.reload();
		
	}
	
	
	public void payr0417_reload(BaseModel bmPayr0416) {
		// TODO Auto-generated method stub

		String strPayYr = bmPayr0416.get("payYr");
		String strTypOccuCd = bmPayr0416.get("typOccuCd");
		String strDtilOccuInttnCd = bmPayr0416.get("dtilOccuInttnCd");
		String strPymtDducDivCd = bmPayr0416.get("pymtDducDivCd");
		String strPayrMangDeptCd = bmPayr0416.get("payrMangDeptCd");
		Long lDtilOccuDlySeilNum = bmPayr0416.get("dtilOccuDlySeilNum");
       	   
	    IColumnFilter filters = null;
	    payr0417GridPanel.getTableDef().setTableColumnFilters(filters);
           
	    payr0417GridPanel.getTableDef().addColumnFilter("payYr", strPayYr, SimpleColumnFilter.OPERATOR_EQUALS); 
//	    payr0417GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//	    payr0417GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0417GridPanel.getTableDef().addColumnFilter("dtilOccuDlySeilNum", lDtilOccuDlySeilNum, SimpleColumnFilter.OPERATOR_EQUALS); 
	    
	    
	    //payr0416GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", strPymtDducDivCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0417GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", strPayrMangDeptCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0417GridPanel.getTableDef().addColumnFilter("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
	    payr0417GridPanel.getTableDef().addColumnFilter("pymtDducDivCd",MSFSharedUtils.getSelectedComboValue(srhType, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
	    
//	    Window.alert("333");
	    
	    
	    payr0417GridPanel.reload();
	}
	        

	public void setRecord(BaseModel record) {
		this.record = record;
	}
	         
	/**
	 * 지급공제선택
	 */
	private void fnPopupCommP500() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		PrgmComP0500DTO sysComP0500Dto = new PrgmComP0500DTO();
		// 지급공제구분코드 넘김.
		MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpPrgmCom0500Form(sysComP0500Dto); // 인사

		final FormBinding popBindingCom0500 = popCom0500.getFormBinding();

		popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();
				if (mapModels != null) {

					boolean payCdEq = false;
					boolean payImcdEq = false;
					String itemNm = "";
					String payCd = MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd");
					List<BaseModel> list = payr0417GridPanel.getMsfGrid().getGrid().getStore().getModels();
					for (BaseModel bm : list) {
						if (payCd.equals(bm.get("payCd"))) {
							payCdEq = true;
						}
						for (BaseModel bm2 : mapModels) {
							if (bm.get("payrImcd").equals(bm2.get("payExtpyCd"))) {
								payImcdEq = true;
								itemNm = bm.get("itemNm");
							}
						}
					}

					if (payCdEq == true && payImcdEq == true) {
						MessageBox.alert(
							MSFMainApp.MSFCONSTANTS.Alert(),itemNm+ " 의 "+ MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCdNm")+ " 가 이미 존재 합니다.", null);
					} else {
						setListRecord(mapModels);
						actionDatabase = ActionDatabase.INSERT;
						payr0417Save();
					}
				}
			}
		});
	}

	/**
	 * 직종에 대한 직종세를 신규로 처리한다.
	 */
	private void formNew() {
		// 팝업호출을 통해 처리 한다.
		fnPopupCommP510();
	}
	
    //부서 
    private void fnPopupCommP140(final String flag, String strDeptCd) {
        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨.
    	
        MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(strDeptCd);  //부서
        
        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
       
        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource();
                if (!"".equals(mapModel.get("deptCd"))) { 
                	
                	if("srh".equals(flag)) {
                		srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                		srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                	}else {
                		creDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                		creDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                	}
                	
                	
                }  
            }
        });
    }
	           
	private void fnPopupCommP510() {

		if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(createPayYr, "year"))) {
			MessageBox.alert("생성년도선택", "생설할 생성년도를 선택하십시요.", null);
			return;
		}

		MSFFormPanel popCom0510 = PrgmComPopupUtils.lovPopUpPrgmCom0510Form(); // 직종

		final FormBinding popBindingCom0510 = popCom0510.getFormBinding();

		popBindingCom0510.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();

				if (mapModels != null) {
					boolean year = false;
					boolean deptCdYn = false;
					boolean dtilOccuInttnCdYn = false;
					String strDeptNm = "";
					String dtilOccuInttnNm = "";
					String createPayYrStr = MSFSharedUtils.getSelectedComboValue(createPayYr, "year");
					List<BaseModel> list = payr0416GridPanel.getMsfGrid().getGrid().getStore().getModels();
					
					
					for (BaseModel bm : list) {
						if (createPayYrStr.equals(bm.get("payYr"))) {
							year = true;
						}
						
						
						for (BaseModel bm2 : mapModels) {
							if (bm.get("deptCd").equals(creDeptCd.getValue())) {
								deptCdYn = true;
								strDeptNm = creDeptNm.getValue();
							}
						}
						
						
						
						for (BaseModel bm3 : mapModels) {
							if (bm.get("dtilOccuInttnCd").equals(bm3.get("dtilOccuInttnCd"))) {
								dtilOccuInttnCdYn = true;
								dtilOccuInttnNm = bm.get("dtilOccuInttnNm");
							}
						}
						
					}
					
					if (year == true && deptCdYn == true && dtilOccuInttnCdYn == true) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), createPayYrStr + "년도 " + strDeptNm + " 에" + " 직종세 (" + dtilOccuInttnNm+ ") 이(가) 이미 존재 합니다.", null);
					} else {
						setListRecord(mapModels);
						actionDatabase = ActionDatabase.INSERT;
						doAction(ActionDatabase.INSERT);
					}
				}
			}
		});
	}
	             
	             
	private void formBeforeToNew() {
		// 선택된 이전 데이터를 이관한다. 해당년도로 이관한다. 만약 데이터
		if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(createPayYr, "year"))) {
			MessageBox.alert("생성년도선택", "생설할 생성년도를 선택하십시요.", null);
			return;
		}
	                
		MSFFormPanel popCom0510 = PrgmComPopupUtils.lovPopUpPrgmCom0510Form(); // 직종

		final FormBinding popBindingCom0510 = popCom0510.getFormBinding();

		popBindingCom0510.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();

				if (mapModels != null) {
	                            
					setListRecord(mapModels);
					actionDatabase = ActionDatabase.INSERT;

					MessageBox.confirm("이전데이터이관","선택하신 직종세에 대한 이전년도 데이터를 이관합니다. 이관하시겠습니까?", new Listener<MessageBoxEvent>() {
						@Override
						public void handleEvent(MessageBoxEvent be) {
							// if("Yes".equals(be.getButtonClicked().getText())){
							if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {

								Payr0415DTO payr0417Dto = new Payr0415DTO();
								payr0417Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
								payr0417Dto.setPayYr(MSFSharedUtils.allowNulls(createPayYr.getValue().get("year")));
	                                        
//	                                            payr1500Service.activityOnPayr5250BfToNew(payr0417Dto,records, 
//	                                                    actionDatabase,
//	                                                    new AsyncCallback<Long>() {
//	                                                    public void onFailure(Throwable caught) {
//	                                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                                                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Insert(" + actionDatabase.name() + ") : " + caught), null);
//	                                                    }
//	                                                    public void onSuccess(Long result) { 
//	                                                        if (result == 0) {
//	                                                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//	                                                                    actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//	                                                        } else {
//	                                                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	                                                                    actionDatabase + "처리가 완료되었습니다.", null);
//	                                                            reload();
//	                                                        } 
//	                                                    } 
//	                                                }); 
	                                            
									}
								}
							});
				} else {
					MessageBox.alert("직종선택", "생설할 직종/직종세를 선택하십시요.", null);
					return;
				}

			}
		});
	}
	             
	             
	public void setListRecord(List<BaseModel> records) {
		this.records = records;
	}

	private void formInit() {

		searchYn = false;

		BaseModel bmBlank = new BaseModel();
		
		createPayYr.setValue(bmBlank);				/** column 급여년도 : payYr */

		srhPayYr.setValue(lsPayYrStore.getAt(0));	/** column 급여년도 : payYr */
		srhTypOccuCd.setValue(bmBlank);				/** column 직종코드 : typOccuCd */
		srhDtilOccuInttnCd.getInitStore();			/** column 직종세코드 : dtilOccuInttnCd */
		srhPymtDducDivCd.setValue(bmBlank);			/** column 지급공제구분코드 : pymtDducDivCd */

		
		payr0417GridPanel.getMsfGrid().clearData();

		formSubInit();
		formSubDetilInit();
	}

	private void formSubInit() {

		BaseModel bmBlank = new BaseModel();

		dpobCd.setValue(""); // 사업장코드
//		typOccuGrdeMppgSeilNum.setValue(0L);	/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		dtilOccuDlySeilNum.setValue(0L);		/** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
		itemDlySeilNum.setValue(0L);			/** column 급여항목일련번호 : itemDlySeilNum */
		emymtDivCd.setValue("");				/** column 고용구분코드 : emymtDivCd */
	    deptCd.setValue("");					/** column 부서코드 : deptCd */
	    deptNm.setValue("");   					/** column 부서코드 : deptNm */
		typOccuCd.setValue("");					/** column 직종코드 : typOccuCd */
		typOccuNm.setValue("");					/** column 직종코드 : typOccuCd */
		dtilOccuInttnCd.setValue("");			/** column 직종세코드 : dtilOccuInttnCd */
		dtilOccuInttnNm.setValue("");			/** column 직종세코드 : dtilOccuInttnCd */

		// pyspGrdeCd.setValue(""); /** column 호봉등급코드 : pyspGrdeCd */
		// pyspGrdeNm.setValue(""); /** column 호봉등급 : pyspGrdeNm */

		payr0417GridPanel.getMsfGrid().clearData();
		
	}
	         
	private void formSubDetilInit() {

		BaseModel bmBlank = new BaseModel();

		setDetailRecord(bmBlank);

		payYr.setValue(""); // 지급년도
		
		payrImcd.setValue("");				/** column 급여항목코드 : payrImcd */
		itemNm.setValue("");				/** column 항목명 : itemNm */
		
		payCd.setValue(bmBlank);			/** column 급여구분코드 : payCd */
		pymtDducDivCd.setValue(bmBlank);	/** column 지급공제구분코드 : pymtDducDivCd */
		pymtDducFrmCd.setValue(bmBlank);	/** column 지급공제유형코드 : pymtDducFrmCd */
		pymtDducRate.setValue(0.0);			/** column 지급공제율 : pymtDducRate */
		pymtDducSum.setValue(0);			/** column 지급공제액 : pymtDducSum */
		txtnDivCd.setValue(bmBlank);		/** column 과세구분코드 : txtnDivCd */
		freeDtyRate.setValue(0.0);			/** column 비과세율 : freeDtyRate */
		freeDtySum.setValue(0);				/** column 비과세금액 : freeDtySum */
		
		jan.setValue(false);				/** column 1월 : jan */
		feb.setValue(false);				/** column 2월 : feb */
		mar.setValue(false);				/** column 3월 : mar */
		apr.setValue(false);				/** column 4월 : apr */
		may.setValue(false);				/** column 5월 : may */
		jun.setValue(false);				/** column 6월 : jun */
		jul.setValue(false);				/** column 7월 : jul */
		aug.setValue(false);				/** column 8월 : aug */
		sep.setValue(false);				/** column 9월 : sep */
		oct.setValue(false);				/** column 10월 : oct */
		nov.setValue(false);				/** column 11월 : nov */
		dec.setValue(false);				/** column 12월 : dec */
		chkAll.setValue(false);				/** column 전체체크 : chkAll */
		rngeOrd.setValue(0);				/** column 정렬순서 : rngeOrd */
	
		payItemUseYn.setValue(false);		/** column 급여항목사용여부 : payItemUseYn */
		itemApptnBgnnDt.reset();			/** column 항목적용시작일자 : itemApptnBgnnDt */
		itemApptnEndDt.reset();				/** column 항목적용종료일자 : itemApptnEndDt */
		dayMnthAmntDivCd.setValue(bmBlank);	/** column 일월액구분코드 : dayMnthAmntDivCd */
		calcStdDivCd.setValue(bmBlank);		/** column 계산기준구분코드 : calcStdDivCd */
		usalyAmntYn.setValue(false);		/** column 통상임금여부 : usalyAmntYn */
		payItemNoteCtnt.setValue("");		/** column 급여항목비고내용 : payItemNoteCtnt */
		calcStdFunc.setValue("");			/** column 계산수식내용 : calcStdFunc */

	}
	    
	// 전체선택 체크박스
	public class CheckboxListener implements Listener<BaseEvent> {
		public void handleEvent(BaseEvent be) {
			CheckBox checkBox = (CheckBox) be.getSource();
			if (checkBox.getValue()) {
				// 전체선택
				jan.setValue(true);		/** column 1월 : jan */
				feb.setValue(true);		/** column 2월 : feb */
				mar.setValue(true);		/** column 3월 : mar */
				apr.setValue(true);		/** column 4월 : apr */
				may.setValue(true);		/** column 5월 : may */
				jun.setValue(true);		/** column 6월 : jun */
				jul.setValue(true);		/** column 7월 : jul */
				aug.setValue(true);		/** column 8월 : aug */
				sep.setValue(true);		/** column 9월 : sep */
				oct.setValue(true);		/** column 10월 : oct */
				nov.setValue(true);		/** column 11월 : nov */
				dec.setValue(true);		/** column 12월 : dec */
			} else {
				// 전체해제
				jan.setValue(false);	/** column 1월 : jan */
				feb.setValue(false);	/** column 2월 : feb */
				mar.setValue(false);	/** column 3월 : mar */
				apr.setValue(false);	/** column 4월 : apr */
				may.setValue(false);	/** column 5월 : may */
				jun.setValue(false);	/** column 6월 : jun */
				jul.setValue(false);	/** column 7월 : jul */
				aug.setValue(false);	/** column 8월 : aug */
				sep.setValue(false);	/** column 9월 : sep */
				oct.setValue(false);	/** column 10월 : oct */
				nov.setValue(false);	/** column 11월 : nov */
				dec.setValue(false);	/** column 12월 : dec */
			}
		}
	}  
	    
 
	public void setDetailRecord(BaseModel detailRecord) {
		this.detailRecord = detailRecord;
	}

	private Payr5250 getThis() {
		return this;
	}

	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
	}-*/;

	// 엑셀 저장
	private void excelFileExport() {
		
		HashMap<String, String> param = new HashMap<String, String>();

		param.put("payYr",MSFSharedUtils.getSelectedComboValue(srhPayYr, "payYr"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd")); // 단위기관
		param.put("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()) ); 									// 부서
		param.put("typOccuCd",MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd"));
		String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
		param.put("dtilOccuInttnCd", strDtilOccuInttnCd);
		param.put("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd, "pymtDducDivCd"));
		payr0417GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsFilePayr5250Export.do", "extgwtFrame", param);
		
	}

	private void funcSetPopUpRecord() {
		BaseModel bmRec = new BaseModel();

		bmRec.set("payYr", MSFSharedUtils.getSelectedComboValue(createPayYr, "year"));

		setPPRecord(bmRec);
	}

	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}	
	
	public void setListRecordDels(Iterator<Record> recordDels) {
		this.recordDels = recordDels;
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
	public void funcLogMessage(String wndName, String wndId) {

		ShowMessageBM smForm = new ShowMessageBM();
		smForm.setWindowId(wndId);
		smForm.setWindowNm(wndName);
		// 개별 화면 에러메시지 검색 팝업
		GWTUtils.funcLogMessage(smForm);
	}
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
		 
}
