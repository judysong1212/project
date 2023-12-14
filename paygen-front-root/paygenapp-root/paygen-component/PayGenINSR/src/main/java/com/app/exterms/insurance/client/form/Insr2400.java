package com.app.exterms.insurance.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2500DTO;
import com.app.exterms.insurance.client.dto.Insr2510DTO;
import com.app.exterms.insurance.client.dto.Insr2530DTO;
import com.app.exterms.insurance.client.form.defs.Insr2200Def;
import com.app.exterms.insurance.client.form.defs.Insr2520Def;
import com.app.exterms.insurance.client.service.InsrP230006Service;
import com.app.exterms.insurance.client.service.InsrP230006ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFCheckBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.core.resources.client.model.Stock;
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
import com.extjs.gxt.ui.client.event.KeyListener;
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
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
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
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Insr2400  extends MSFPanel {  
	 
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
	private FormPanel plFrmInsr2400;
	private String txtForm = "";
	private XTemplate detailTp;

	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	
	// -------------- grid 선언 시작  ---------------
	// 대상자 정보
	//private Insr1100Def insr1100Def = new Insr1100Def("INSR2400"); // 그리드 테이블 컬럼 define
	private Insr2200Def insr2200Def  = new Insr2200Def("INSR2400");
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel insr2200GridPanel;
	
	//private Insr1400Def insr1400Def = new Insr1400Def("Insr2400");   //그리드 테이블 컬럼 define  
	private Insr2520Def insr2520Def = new Insr2520Def("InsrP230006");   //그리드 테이블 컬럼 define  
	private MSFGridPanel insr2520GridPanel;
	// -------------- grid 선언 종료  ---------------
	 
	private GridCellRenderer<Stock> gridNumber;
	private GridCellRenderer<Stock> change;
	  
//	    //4대보험취득
//		  private Insr1100Def insr1100Def  = new Insr1100Def("Insr2400");   //그리드 테이블 컬럼 define  
//	    // private MSFCustomForm msfCustomForm; 
//	      private MSFGridPanel insr1100GridPanel;
	    
	    //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
		    
	  
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
	private ButtonBar topInsr2400Bar;
//	private Button btnInsr2400Init;
//	private Button btnInsr2400New;
//	private Button btnInsr2400Save;
//	private Button btnInsr2400Del;
	private Button btnInsr2400Sreach;
	private Button btnInsr2400ExcelFile;
	private Button btnInsr2400Print;
	private Button btnInsr2400Excel;
	 
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	      
	/** column 년도 : payYr */
	private DateField srhSoctyInsurCmptnDt01;
	private DateField srhSoctyInsurCmptnDt02;
	     
	    //  private ComboBox<BaseModel> srhTypOccuCd; //직종 
	    //  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
	    //  private HiddenField<String> srhPyspGrdeCd; //직종 
	      
	    //  private ComboBox<BaseModel> srhPayCd;     //급여구분
	private ComboBox<BaseModel> srhEmymtDivCd; // 고용구분
	private ComboBox<BaseModel> srhPayrMangDeptCd; // 단위기관

	private MSFMultiComboBox<ModelData> srhDeptCd; // 부서
	    //  private MSFTextField srhDeptCd; //부서코드
	    //  private MSFTextField srhDeptNm; //부서명  
	    //  private Button btnSrhDeptCd;
	    //  private MSFTextField srhMangeDeptCd; //관리부서 수정
	    //  private MSFTextField srhMangeDeptNm; //관리부서 수정  
	      
	private MSFMultiComboBox<ModelData> srhTypOccuCd; // 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; // 재직상태

	private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
	private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
	
	private ComboBox<BaseModel> srhBusinCd; // 사업
	private TextField<String> srhHanNm; // 성명
	private TextField<String> srhResnRegnNum; // 주민번호
	private HiddenField<String> srhSystemkey; // 시스템키

	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
 
	private Boolean emptyCheck = false ; 
	private boolean mutilCombo = false;
	
	private HiddenField<String> retryYrMnth;	//작성년월
	private long amntBspy = 1500000L; //기본금
 	private long amntEtcExtpy = 500000L;  //기타수당
 	private long amntAllwBnus = 2000000L; //상여금
 	private long amntAnnlExtpy = 100000L; //연차수당
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 입력 변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	// --- 기본정보 시작 ---
	private MSFDateField soctyInsurCmptnDt;		/** column 사회보험작성일자 : soctyInsurCmptnDt */	
 	private MSFTextField socnsrIssRegVal02;    /** column 성명 : socnsrAqtnRegVal02 */
 	private MSFTextField socnsrIssRegVal03;    /** column 주민등록번호 : socnsrAqtnRegVal03 */
	private MSFTextField emymtDivNm;			// 고용구분
	private MSFTextField deptNm;		 		// 부서
	private MSFTextField typOccuNm; 			// 직종
	private MSFTextField DtilOccuClsDivNm; 		// 직종세
	
	private MSFNumberField socInsrLssEmymtNum; //일련번호
	
	private TextFieldWithButton<String> socnsrAqtnRegVal04D;/** column 국적 : socnsrAqtnRegVal04 popup */
 	private MSFComboBox<BaseModel> socnsrAqtnRegVal05;    	/** TextFieldWithButton* column 체류자격 : socnsrAqtnRegVal05 */
 	private MSFCheckBox socnsrAqtnRegVal06;   				/** column 대표자여부 : socnsrAqtnRegVal06 1 예 / 2아니오 */
 	
 	private MSFDateField tempDateFld1; 			// 이직(퇴직일)
 	private MSFDateField tempDateFld2; 			// 취득일
	// --- 기본정보 종료 ---	
	
	
	private NumberField tempNumFle;		//통산피보험 단위기간
	
 	
 
 	private HiddenField<String> systemkey;
 	private HiddenField<String> dpobCd;
 	private HiddenField<String> deptCd;
 	private HiddenField<String> icncDt;
	private HiddenField<String> soctyInsurCmptnDtReal;
	
	
	// -- 기준연장기간 시작 --
	private ComboBox<BaseModel> tempComboTop_0;
	private ComboBox<BaseModel> tempComboTop_1; 		//사유1
	private ComboBox<BaseModel> tempComboTop_2; 		//사유2
	private ComboBox<BaseModel> tempComboTop_3; 		//사유3
	
	private DateField tempTopDate_1_S; 					//날짜1 시작
	private DateField tempTopDate_1_E; 					//날짜1 종료
	
	private DateField tempTopDate_2_S; 					//날짜2 시작
	private DateField tempTopDate_2_E; 					//날짜2 종료
	
	private DateField tempTopDate_3_S; 					//날짜3 시작
	private DateField tempTopDate_3_E; 					//날짜3 종료
	// -- 기준연장기간 종료 -- 
	
	// -- 임금계산기간 시작 -- 
	private DateField tempMidDate_1_S; 					//날짜1 시작
	private DateField tempMidDate_1_E; 					//날짜1 종료
	
	private DateField tempMidDate_2_S; 					//날짜2 시작
	private DateField tempMidDate_2_E; 					//날짜2 종료
	
	private DateField tempMidDate_3_S; 					//날짜3 시작
	private DateField tempMidDate_3_E; 					//날짜3 종료
	
	private DateField tempMidDate_4_S; 					//날짜4 시작
	private DateField tempMidDate_4_E; 					//날짜4 종료
	
	private NumberField tempNumDaysSumFle;				//통산피보험 단위기간
	// -- 임금계산기간 종료 -- 
	
	// -- 임금내역 시작 -- 
	private NumberField tempNumDaysFle_1;				//총보수 1
	private NumberField tempNumDaysFle_2;				//총보수 2
	private NumberField tempNumDaysFle_3;				//총보수 3
	private NumberField tempNumDaysFle_4;				//총보수 4
	private NumberField tempNumDaysFle_5;				//총보수 5
	
	private NumberField tempNumFle_1;					//기본금 1
	private NumberField tempNumFle_2;					//기본금 2
	private NumberField tempNumFle_3;					//기본금 3
	private NumberField tempNumFle_4;					//기본금 4
	private NumberField tempSumNumFle_1;				//기본금 합계 1
	
	private NumberField tempNumFle_5;					//기타수당 1
	private NumberField tempNumFle_6;					//기타수당 2
	private NumberField tempNumFle_7;					//기타수당 3
	private NumberField tempNumFle_8;					//기타수당 4
	private NumberField tempSumNumFle_2;				//기타수당 합계 1
	
	private NumberField tempNumFle_9;					//상여금 1
	private NumberField tempSumNumFle_3;				//상여금 합계 1
	
	private NumberField tempNumFle_10;					//연차수당 1
	private NumberField tempSumNumFle_4;				//연차수당 합계 1
	
	private NumberField tempNumFle_11;					//기타 1
	private NumberField tempSumNumFle_5;				//기타 합계 1
	// -- 임금내역 종료 -- 
	
	private NumberField tempUnderNumFle_1;				//총임금액 
	private NumberField tempUnderNumFle_2;				//총일수
	private NumberField tempUnderNumFle_3;				//평균임금 (총임금액/총일수)
	
	private NumberField tempUnderNumFle_4;				//통상임금
	private NumberField tempUnderNumFle_5;				//기준임금
	private TextField<String> tempUnderNumFle_6;				//1일 소정근로 시간
	private NumberField tempUnderNumFle_7;				//퇴직금 수령액
	
	private NumberField tempUnderTxtFle_1;		//기타(퇴직금외 기타 금품)
	private TextField<String> tempUnderTxtFle_2;		//구체적 사유
	
	
	private String systemKeys;
	
	
	
		 
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	전역변수 선언부  종료
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/	
	
	
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	
	/** 권한설정 처리 체크  AuthAction */
	private void checkInsr2400Auth(String authAction, ListStore<BaseModel> bm) {
		// 2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())
				&& gwtExtAuth.checkExtAuth(authAction, bm)) {

			if (!maskTracker) {
				unmask();
			}
			// MSFMainApp.unmaskMainPage();

			authExecEnabled();
			gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
		}
	}
			  
	private void authExecEnabled() {
		//----------------------------------------------------------------------
		Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);

		// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
		setInitDate();
		srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(1), true);
		srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(1).get("commCdNm").toString());
		                
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					   // gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	}
	

	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			if (lsEmymtDivCd.getCount() > 0) {

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
		authMapDef.put("srhHdofcCodtnCd", Boolean.FALSE);
		authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
		authMapDef.put("srhDeptCd", Boolean.FALSE);
		// authMapDef.put("srhTypOccuCd",Boolean.FALSE);

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
	
	
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	전역함수 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	   // 검색 폼 바인딩 처리 함수  
		//화면 폼 바인딩 처리 
		    private void setInsr2400FormBinding() {
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
		    
	//입력수정삭제처리 rpc 처리부     
	// private Insr2400ServiceAsync insr2400Service = Insr2400Service.Util.getInstance();	    
				 
    private InsrP230006ServiceAsync insrP230006Service = InsrP230006Service.Util.getInstance();	    
    
	private ListStore<BaseModel> stdExtnnReasCdStore = new ListStore<BaseModel>();  //기준연장사유코드
	private ListStore<BaseModel> umytInsrChgjbReasCd = new ListStore<BaseModel>();  //고용보험이직사유코드
		    
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();		//년도 
	private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  		//급여월   
		  		
	private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();	//고용구분 
		  		
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();		// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();		// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();			//직종 
	private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); 		//재직상태 
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세
		  	 

	private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
	private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드 
	
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
		  	  
	private BaseModel record;
	private Iterator<Record> records;
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값

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

			detailTp = XTemplate.create(getDetailTemplate());

			vp = new VerticalPanel();
			vp.setSpacing(10);
			createInsr2400Form();		// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
			createStandardForm(); 		// 기본정보필드
			//엣지변환
			//vp.setSize("1010px", "710px");
			vp.setSize("1010px", "780px");

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
	public Insr2400() {

//		final NumberFormat currency = NumberFormat.getCurrencyFormat();
//		final NumberFormat number = NumberFormat.getFormat("0.00");
//		final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(
//				currency);
//
//		change = new GridCellRenderer<Stock>() {
//			public String render(Stock model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Stock> store, Grid<Stock> grid) {
//				double val = (Double) model.get(property);
//				String style = val < 0 ? "red" : "green";
//				return "<span style='color:" + style + "'>"
//						+ number.format(val) + "</span>";
//			}
//		};
//
//		gridNumber = new GridCellRenderer<Stock>() {
//			public String render(Stock model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Stock> store, Grid<Stock> grid) {
//				return numberRenderer.render(null, property,
//						model.get(property));
//			}
//		};

		//엣지변환
		//setSize("1010px", "710px");
		setSize("1010px", "780px");
	}

	public Insr2400(String txtForm) {
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

	private void createInsr2400Form() {
			   
		
		plFrmInsr2400 = new FormPanel();
		plFrmInsr2400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 피보험자이직확인서"));
		plFrmInsr2400.setIcon(Resources.APP_ICONS.text());
		plFrmInsr2400.setBodyStyleName("pad-text");
		plFrmInsr2400.setPadding(2);
		plFrmInsr2400.setFrame(true);

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("피보험자이직확인서","INSR2400");
				}
			});
		plFrmInsr2400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmInsr2400.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		 //멀티콤보박스 닫기 
		plFrmInsr2400.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	     @Override
	     public void handleEvent(ComponentEvent ce) { 
	     
	      //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
	             
	     //        if (f instanceof MSFMultiComboBox<?>) {
	                 
//	                 if ("srhDeptCd".equals(f.getName())) {
//	                     
//	                 } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                     
//	                 }
	                 
	       //      } else {
	            if (mutilCombo) {
	                 if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
	                     srhDeptCd.showClose(ce);
	                     mutilCombo = false;
	                 } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
	                     srhHdofcCodtnCd.showClose(ce);
	                     mutilCombo = false;
	                 } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
	                     //직종
	                     srhTypOccuCd.showClose(ce);
	                     mutilCombo = false;
	                   //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
	                 } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
	                     //직종세
	                     srhDtilOccuInttnCd.showClose(ce);
	                     mutilCombo = false;
	                 }  
	            }
	         //    }
	     //    } 
	     } 
	 });
		
		topInsr2400Bar = new ButtonBar();
		topInsr2400Bar.setAlignment(HorizontalAlignment.RIGHT);
			      
		
		Button topBtn1 = new Button("임금산정");
		topBtn1.setIcon(Resources.APP_ICONS.text());
		topInsr2400Bar.add(topBtn1);

		topBtn1.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {


				if (insr2200GridPanel.getCurrentlySelectedItem() != null) {  
					if(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("systemkey")) != null 
							&& !MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("systemkey")).equals("")){

						BaseModel bm = new BaseModel();

						//산정대상기간
						bm.set("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));
						bm.set("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
						bm.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
						bm.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue().longValue());
						bm.set("cmpttnTgtPridSeilNum", 1L);
						bm.set("cmpttnTgtBgnnDt", "20151101");	
						bm.set("cmpttnTgtEndDt", "20151130");	
						bm.set("amntPymtNumDys", 30L);	
						insr2520GridPanel.getGrid().getStore().add(bm);

						BaseModel bm1 = new BaseModel();
						bm1.set("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));
						bm1.set("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
						bm1.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
						bm1.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue().longValue());
						bm1.set("cmpttnTgtPridSeilNum", 2L);
						bm1.set("cmpttnTgtBgnnDt", "20151201");	
						bm1.set("cmpttnTgtEndDt", "20151231");	
						bm1.set("amntPymtNumDys", 31L);	
						insr2520GridPanel.getGrid().getStore().add(bm1);

						BaseModel bm2 = new BaseModel();
						bm2.set("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));
						bm2.set("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
						bm2.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
						bm2.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue().longValue());
						bm2.set("cmpttnTgtPridSeilNum", 3L);
						bm2.set("cmpttnTgtBgnnDt", "20160101");	
						bm2.set("cmpttnTgtEndDt", "20160131");	
						bm2.set("amntPymtNumDys", 31L);	
						insr2520GridPanel.getGrid().getStore().add(bm2);

						BaseModel bm3 = new BaseModel();
						bm3.set("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));
						bm3.set("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
						bm3.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
						bm3.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue().longValue());
						bm3.set("cmpttnTgtPridSeilNum", 4L);
						bm3.set("cmpttnTgtBgnnDt", "20160201");	
						bm3.set("cmpttnTgtEndDt", "20160228");	
						bm3.set("amntPymtNumDys", 28L);	
						insr2520GridPanel.getGrid().getStore().add(bm3);

						BaseModel bm4 = new BaseModel();
						bm4.set("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));
						bm4.set("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
						bm4.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
						bm4.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue().longValue());
						bm4.set("cmpttnTgtPridSeilNum", 5L);
						bm4.set("cmpttnTgtBgnnDt", "20160301");	
						bm4.set("cmpttnTgtEndDt", "20160331");	
						bm4.set("amntPymtNumDys", 31L);	
						insr2520GridPanel.getGrid().getStore().add(bm4);

						BaseModel bm5 = new BaseModel();
						bm5.set("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));
						bm5.set("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
						bm5.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
						bm5.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue().longValue());
						bm5.set("cmpttnTgtPridSeilNum", 6L);
						bm5.set("cmpttnTgtBgnnDt", "20160401");	
						bm5.set("cmpttnTgtEndDt", "20160430");	
						bm5.set("amntPymtNumDys", 30L);	
						insr2520GridPanel.getGrid().getStore().add(bm5);

						amntBspy = 1500000L;
						amntEtcExtpy = 500000L;
						amntAllwBnus = 2000000L;
						amntAnnlExtpy = 100000L;

						//통산피보험 단위기간
						tempNumFle.setValue(180L);

						//임금계산 기간셋팅
						tempMidDate_1_S.setValue(InsrUtils.getConvertStringToDate("20160115", "yyyyMMdd"));
						tempMidDate_1_E.setValue(InsrUtils.getConvertStringToDate("20160131", "yyyyMMdd"));				
						tempMidDate_2_S.setValue(InsrUtils.getConvertStringToDate("20160201", "yyyyMMdd"));
						tempMidDate_2_E.setValue(InsrUtils.getConvertStringToDate("20160228", "yyyyMMdd"));				
						tempMidDate_3_S.setValue(InsrUtils.getConvertStringToDate("20160301", "yyyyMMdd"));
						tempMidDate_3_E.setValue(InsrUtils.getConvertStringToDate("20160330", "yyyyMMdd"));				
						tempMidDate_4_S.setValue(InsrUtils.getConvertStringToDate("20160401", "yyyyMMdd"));
						tempMidDate_4_E.setValue(InsrUtils.getConvertStringToDate("20160414", "yyyyMMdd"));				

						//월별 근무일수 셋팅
						setTempNumDaysFle_1();
						setTempNumDaysFle_2();
						setTempNumDaysFle_3();
						setTempNumDaysFle_4();

						//월별 기본금 셋팅
						setTempNumFle_1();
						setTempNumFle_2();
						setTempNumFle_3();
						setTempNumFle_4();

						//월별 그밖의 수당 셋팅
						setTempNumFle_5();
						setTempNumFle_6();
						setTempNumFle_7();
						setTempNumFle_8();

						//상여금
						setTempNumFle_9();

						//연차수당
						setAmntAnnlExtpy();

						//기타	
						tempNumFle_11.setValue(700000L);
						//기타 합계
						tempSumNumFle_5.setValue(700000L);

						//통상임금
						tempUnderNumFle_4.setValue(1500000L);
						//기준임금
						tempUnderNumFle_5.setValue(1000000L);
						//1일 소정근로시간
						tempUnderNumFle_6.setValue("42.195");
						//퇴직금 수령액
						tempUnderNumFle_7.setValue(5000000L);
						//퇴직금외 기타금품
						tempUnderTxtFle_1.setValue(500000L);

					}
				}else{
					MessageBox.info("", "대상자를 선택 하세요.", null);
				}
			}
		});
		
		Button topBtn2 = new Button("저장");
		topBtn2.setIcon(MSFMainApp.ICONS.save16());
		topInsr2400Bar.add(topBtn2);
		topBtn2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
		           MessageBox.confirm("이직확인서 저장", "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

								if(insr2520GridPanel.getGrid().getStore().getCount() > 0){
									 actionDatabase = ActionDatabase.INSERT;
							          
							           
									
									 
									 //이직 마스터
									 Insr2500DTO insr2500Dto = new Insr2500DTO();	 
									 insr2500Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
									 insr2500Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));    /** column SYSTEMKEY : systemkey */
									 insr2500Dto.setRetryYrMnth(MSFSharedUtils.allowNulls(retryYrMnth.getValue()));    /** column 작성년월 : retryYrMnth */
									 insr2500Dto.setSocInsrLssEmymtNum(socInsrLssEmymtNum.getValue().longValue());    /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
									 
									 //작성일자 셋팅
									 insr2500Dto.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(soctyInsurCmptnDtReal.getValue()));    /** column 사회보험작성일자 : soctyInsurCmptnDt */
									 //TODO 조회전 조회로 셋팅
									 insr2500Dto.setDeptCd(MSFSharedUtils.allowNulls(deptCd.getValue()));    /** column 부서코드 : deptCd */
									 insr2500Dto.setNm(MSFSharedUtils.allowNulls(socnsrIssRegVal02.getValue()));    /** column 성명 : nm */
									 insr2500Dto.setIcncDt(MSFSharedUtils.allowNulls(icncDt.getValue()));    /** column 입사일자 : icncDt */
									 insr2500Dto.setUmytInsrAqtnDt(MSFSharedUtils.allowNulls(InsrUtils.getConvertDateToString(tempDateFld2, "yyyyMMdd")));    /** column 고용보험취득일자 : umytInsrAqtnDt */
									 insr2500Dto.setRetryDt(MSFSharedUtils.allowNulls(InsrUtils.getConvertDateToString(tempDateFld1, "yyyyMMdd")));    /** column 퇴직일자 : retryDt */
									 

									 insr2500Dto.setUmytInsrChgjbReasCd(MSFSharedUtils.getSelectedComboValue(tempComboTop_0,"commCd"));    /** column 고용보험이직사유코드 : umytInsrChgjbReasCd */
									 insr2500Dto.setUmytInsrSpecResnCtnt(tempUnderTxtFle_2.getValue());    /** column 고용보험구체적사유내용 : umytInsrSpecResnCtnt */			
									 
									
									 
									 insr2500Dto.setUsalyTisedUntPridNumDys(longToNullChk(tempNumFle.getValue()));    /** column 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
									 insr2500Dto.setAvgAmntCalcTotNumDys(longToNullChk(tempNumDaysFle_5.getValue()));    //일수 합계           /** column 평균임금계산총일수 : avgAmntCalcTotNumDys */
									 insr2500Dto.setAvgAmntFndtnSum(longToNullChk(tempSumNumFle_1.getValue()));          //기본금 합계         /** column 평균임금기본금금액 : avgAmntFndtnSum */
									 insr2500Dto.setAvgAmntEtcExtpySum(longToNullChk(tempSumNumFle_2.getValue()));       //그밖의 수당 합계    /** column 평균임금이외수당금액 : avgAmntEtcExtpySum */
									 insr2500Dto.setAvgAmntAllwBnusSum(longToNullChk(tempSumNumFle_3.getValue()));       //상여금 합계         /** column 평균임금상여금금액 : avgAmntAllwBnusSum */
									 insr2500Dto.setAvgAmntAnnlExtpySum(longToNullChk(tempSumNumFle_4.getValue()));      //연차수당 합계       /** column 평균임금연차수당금액 : avgAmntAnnlExtpySum */
									 insr2500Dto.setAvgAmntEtcSum(longToNullChk(tempSumNumFle_5.getValue()));            //기타 합계           /** column 평균임금기타금액 : avgAmntEtcSum */									 	
									 insr2500Dto.setAvgAmntQnty(0L);            //평균임금    /** column 평균임금액 : avgAmntQnty */
									 insr2500Dto.setUsalyAmntWag(longToNullChk(tempUnderNumFle_4.getValue()));              /** column 통상임금액 : usalyAmntWag */
									 insr2500Dto.setStdAmntWag(longToNullChk(tempUnderNumFle_5.getValue()));                /** column 기준임금액 : stdAmntWag */
									 insr2500Dto.setDayFxdWorkTmNum(tempUnderNumFle_6.getValue());                       /** column 1일소정근로시간 : dayFxdWorkTmNum */
									 insr2500Dto.setSevePayReipSum(longToNullChk(tempUnderNumFle_7.getValue()));            /** column 퇴직금수령금액 : sevePayReipSum */
									 insr2500Dto.setSevePayRstEtcSum(longToNullChk(tempUnderTxtFle_1.getValue()));          /** column 퇴직금외기타금액 : sevePayRstEtcSum */

									 
									 //임금산정
									 List<Insr2510DTO> insr2510DtoArr = new ArrayList<Insr2510DTO>();
									 
									 for(int i=0; i < 4; i++){
										 Insr2510DTO insr2510Dto = new Insr2510DTO(); 
										 insr2510Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
										 insr2510Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));    /** column SYSTEMKEY : systemkey */
										 insr2510Dto.setRetryYrMnth(MSFSharedUtils.allowNulls(retryYrMnth.getValue()));    /** column 작성년월 : retryYrMnth */
										 insr2510Dto.setSocInsrLssEmymtNum(socInsrLssEmymtNum.getValue().longValue());    /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
										 if(i==0){	
											 insr2510Dto.setSevePayDtlPatrNum(1L);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
											 insr2510Dto.setPayPymtBgnnDt(InsrUtils.getConvertDateToString(tempMidDate_1_S, "yyyyMMdd"));    /** column 임금산정시작일자 : payPymtBgnnDt */
											 insr2510Dto.setPayPymtEndDt(InsrUtils.getConvertDateToString(tempMidDate_1_E, "yyyyMMdd"));    /** column 임금산정종료일자 : payPymtEndDt */					 
											 insr2510Dto.setPymtNumDys(longToNullChk(tempNumDaysFle_1.getValue()));    /** column 임금산정일수 : pymtNumDys */
											 insr2510Dto.setAmntBspySum(longToNullChk(tempNumFle_1.getValue()));    /** column 임금_기본급금액 : amntBspySum */
											 insr2510Dto.setAmntEtcExtpySum(longToNullChk(tempNumFle_5.getValue()));    /** column 임금_이외수당금액 : amntEtcExtpySum */
										 }
										 if(i==1){
											 insr2510Dto.setSevePayDtlPatrNum(2L);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
											 insr2510Dto.setPayPymtBgnnDt(InsrUtils.getConvertDateToString(tempMidDate_2_S, "yyyyMMdd"));    /** column 임금산정시작일자 : payPymtBgnnDt */
											 insr2510Dto.setPayPymtEndDt(InsrUtils.getConvertDateToString(tempMidDate_2_E, "yyyyMMdd"));    /** column 임금산정종료일자 : payPymtEndDt */
											 insr2510Dto.setPymtNumDys(longToNullChk(tempNumDaysFle_2.getValue()));    /** column 임금산정일수 : pymtNumDys */
											 insr2510Dto.setAmntBspySum(longToNullChk(tempNumFle_2.getValue()));    /** column 임금_기본급금액 : amntBspySum */
											 insr2510Dto.setAmntEtcExtpySum(longToNullChk(tempNumFle_6.getValue()));    /** column 임금_이외수당금액 : amntEtcExtpySum */
										 }
										 if(i==2){
											 insr2510Dto.setSevePayDtlPatrNum(3L);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
											 insr2510Dto.setPayPymtBgnnDt(InsrUtils.getConvertDateToString(tempMidDate_3_S, "yyyyMMdd"));    /** column 임금산정시작일자 : payPymtBgnnDt */
											 insr2510Dto.setPayPymtEndDt(InsrUtils.getConvertDateToString(tempMidDate_3_E, "yyyyMMdd"));    /** column 임금산정종료일자 : payPymtEndDt */
											 insr2510Dto.setPymtNumDys(longToNullChk(tempNumDaysFle_3.getValue()));    /** column 임금산정일수 : pymtNumDys */
											 insr2510Dto.setAmntBspySum(longToNullChk(tempNumFle_3.getValue()));    /** column 임금_기본급금액 : amntBspySum */
											 insr2510Dto.setAmntEtcExtpySum(longToNullChk(tempNumFle_7.getValue()));    /** column 임금_이외수당금액 : amntEtcExtpySum */
										 }
										 if(i==3){
											 insr2510Dto.setSevePayDtlPatrNum(4L);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
											 insr2510Dto.setPayPymtBgnnDt(InsrUtils.getConvertDateToString(tempMidDate_4_S, "yyyyMMdd"));    /** column 임금산정시작일자 : payPymtBgnnDt */
											 insr2510Dto.setPayPymtEndDt(InsrUtils.getConvertDateToString(tempMidDate_4_E, "yyyyMMdd"));    /** column 임금산정종료일자 : payPymtEndDt */
											 insr2510Dto.setPymtNumDys(longToNullChk(tempNumDaysFle_4.getValue()));    /** column 임금산정일수 : pymtNumDys */
											 insr2510Dto.setAmntBspySum(longToNullChk(tempNumFle_4.getValue()));    /** column 임금_기본급금액 : amntBspySum */
											 insr2510Dto.setAmntEtcExtpySum(longToNullChk(tempNumFle_8.getValue()));    /** column 임금_이외수당금액 : amntEtcExtpySum */
										 }
//										 insr2510Dto.setAmntAllwBnusSum(longToNullChk(tempNumFle_9.getValue()));    /** column 임금_상여금액 : amntAllwBnusSum */									 
//										 insr2510Dto.setAmntAnnlExtpySum(longToNullChk(tempNumFle_10.getValue()));    /** column 임금_연차수당금액 : amntAnnlExtpySum */
//										 insr2510Dto.setAmntEtcSum(longToNullChk(tempNumFle_11.getValue()));    /** column 임금_기타금액 : amntEtcSum */	
										 insr2510Dto.setAmntAllwBnusSum(longToNullChk(null));    /** column 임금_상여금액 : amntAllwBnusSum */									 
										 insr2510Dto.setAmntAnnlExtpySum(longToNullChk(null));    /** column 임금_연차수당금액 : amntAnnlExtpySum */
										 insr2510Dto.setAmntEtcSum(longToNullChk(null));    /** column 임금_기타금액 : amntEtcSum */
										 insr2510DtoArr.add(insr2510Dto);
									 }
									  
									 
									 //기준연장기간 셋팅
									
									 List<Insr2530DTO> insr2530DtoArr = new ArrayList<Insr2530DTO>();
									 								 
										 for(int i=0; i < 3; i++){
											 Insr2530DTO insr2530Dto = new Insr2530DTO(); 
											 insr2530Dto.setDpobCd(dpobCd.getValue());
											 insr2530Dto.setSystemkey(systemkey.getValue());
											 insr2530Dto.setRetryYrMnth(retryYrMnth.getValue());
											 insr2530Dto.setSocInsrLssEmymtNum(socInsrLssEmymtNum.getValue().longValue());								 
											 if(i==0){	
												 insr2530Dto.setStdExtnnSeilNum(1L);
												 insr2530Dto.setStdExtnnBgnnDt(GWTUtils.getStringFromDate(tempTopDate_1_S.getValue(),"yyyyMMdd"));
												 insr2530Dto.setStdExtnnEndDt(GWTUtils.getStringFromDate(tempTopDate_1_E.getValue(),"yyyyMMdd"));
												 insr2530Dto.setStdExtnnReasCd(MSFSharedUtils.getSelectedComboValue(tempComboTop_1,"commCd"));
											 }
											 if(i==1){
												 insr2530Dto.setStdExtnnSeilNum(2L);
												 insr2530Dto.setStdExtnnBgnnDt(GWTUtils.getStringFromDate(tempTopDate_2_S.getValue(),"yyyyMMdd"));
												 insr2530Dto.setStdExtnnEndDt(GWTUtils.getStringFromDate(tempTopDate_2_E.getValue(),"yyyyMMdd"));
												 insr2530Dto.setStdExtnnReasCd(MSFSharedUtils.getSelectedComboValue(tempComboTop_2,"commCd"));
											 }
											 if(i==2){
												 insr2530Dto.setStdExtnnSeilNum(3L);
												 insr2530Dto.setStdExtnnBgnnDt(GWTUtils.getStringFromDate(tempTopDate_3_S.getValue(),"yyyyMMdd"));
												 insr2530Dto.setStdExtnnEndDt(GWTUtils.getStringFromDate(tempTopDate_3_E.getValue(),"yyyyMMdd"));
												 insr2530Dto.setStdExtnnReasCd(MSFSharedUtils.getSelectedComboValue(tempComboTop_3,"commCd"));
											 }										 
											 insr2530DtoArr.add(insr2530Dto);
										 }
									 
									 
									HashMap<String, Object> hMap = new HashMap<String, Object>(); 
									hMap.put("insr2500Dto", insr2500Dto);
									hMap.put("insr2510DtoArr", insr2510DtoArr);
									hMap.put("insr2530DtoArr", insr2530DtoArr);
									 
									
								
									
									insrP230006Service.activityOnInsertInsr2520(insr2520GridPanel.getGrid().getStore().getModels(), insr2500Dto, insr2510DtoArr, insr2530DtoArr,  new AsyncCallback<Long>() {
											@Override
											public void onSuccess(Long result) {
												MessageBox.info("", "저장 되었습니다.", null);
												reload();
												resetForm();
											}
											@Override
											public void onFailure(Throwable caught) {
												caught.printStackTrace();
												MessageBox.info("", "저장 오류", null);
											}
										});
									}else{
										MessageBox.info("", "저장하실 내용이 없습니다. 임금산정후 저장 하세요.", null);
									}
							           
								}else{
									//MessageBox.info("", "삭제하실 대상자를 선택하여주세요.", null);
								}
							}
						
		           });
				
			}
		});

		   
		 
		btnInsr2400Sreach = new Button("조회");
		btnInsr2400Sreach.setIcon(MSFMainApp.ICONS.search16());
		topInsr2400Bar.add(btnInsr2400Sreach);
		btnInsr2400Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
				resetForm();
			}
		});
		 	
		btnInsr2400ExcelFile = new Button("이직확인서신고파일");
		btnInsr2400ExcelFile.setIcon(MSFMainApp.ICONS.excel16());
		topInsr2400Bar.add(btnInsr2400ExcelFile);
		btnInsr2400ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				excelFileExport();
			}
		});

		btnInsr2400Print = new Button("인쇄");
		btnInsr2400Print.setIcon(MSFMainApp.ICONS.print16());
		topInsr2400Bar.add(btnInsr2400Print);
		btnInsr2400Print.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				insr2400Print("INSRT230006", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
		});

		 	 
		plFrmInsr2400.add(topInsr2400Bar);

		// 파일업로드 처리
		plFrmInsr2400.setAction("myurl");
		plFrmInsr2400.setEncoding(Encoding.MULTIPART);
		plFrmInsr2400.setMethod(Method.POST);

		vp.add(plFrmInsr2400);
		//엣지변환
		//plFrmInsr2400.setSize("990px", "710px");
		plFrmInsr2400.setSize("990px", "780px");
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

	/**  검색필드 설정 */
	private void createSearchForm() {
			  

		
		systemkey = new HiddenField<String>();
        systemkey.setName("systemkey");
        vp.add(systemkey);
        
        dpobCd = new HiddenField<String>();
        dpobCd.setName("dpobCd");
        vp.add(dpobCd);
        
        deptCd = new HiddenField<String>();
        deptCd.setName("deptCd");
        vp.add(deptCd);
        
        icncDt = new HiddenField<String>();
        icncDt.setName("icncDt");
        vp.add(icncDt);     
		   
        soctyInsurCmptnDtReal = new HiddenField<String>();
        soctyInsurCmptnDtReal.setName("soctyInsurCmptnDtReal");
        vp.add(soctyInsurCmptnDtReal);
        
        retryYrMnth = new HiddenField<String>();
        retryYrMnth.setName("retryYrMnth");
        vp.add(retryYrMnth);    
		
		
		//  srhPyspGrdeCd = new HiddenField<String>(); 
		srhSystemkey = new HiddenField<String>(); // 시스템키

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
				 
		// -------------------- 단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		// --------------------단위기관 불러 오는 함수
		// ------------------------------------------------

		// --------------------공통 코드 불러 오는 함수 --------------------------------------------------
		// 재직상태
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		lsHdofcCodtnCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd);
				srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
			}
		});
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
				 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
				 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //월 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------


		 //-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		
		 //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		    // sysComBass0400Dto.setDeptDspyYn("Y");
		 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		 lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

		 lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd);
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		 });
		// --------------------급여부서 불러 오는 함수------------------------------------------------

		// sysComBass0400Dto.setDeptDspyYn("Y");
		// --------------------부서 불러 오는 함수------------------------------------------------
		// lsDeptCd =PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
		// --------------------부서 불러 오는 함수------------------------------------------------
		// sysComBass0400Dto.setDeptDspyYn("");

		  sysComBass0300Dto.setRpsttvCd("A048");
		  lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		 /**
		  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		  * 직종 콤보박스 처리  시작
		  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		  */

		 lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		 lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			 public void handleEvent(StoreEvent<BaseModel> be) {
				 mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd);
				 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			 }
		 });
					 
		 /**
		  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		  * 년도 콤보박스 처리  시작
		  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		  */

		plFrmInsr2400.setLayout(new FlowLayout());

		srhSystemkey = new HiddenField<String>();

		LayoutContainer lcSchCol = new LayoutContainer();
		// lcSchCol.setStyleAttribute("background-color","red");
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
		// fieldSet.setCheckboxToggle(false);

		LayoutContainer lcSchLeft = new LayoutContainer();
		// lcSchLeft.setStyleAttribute("paddingRight", "10px");
		lcSchLeft.setLayout(new ColumnLayout());

		fieldSet.add(lcSchCol, new FormData("100%"));

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);
			    

		srhSoctyInsurCmptnDt01 = new DateField();
		srhSoctyInsurCmptnDt01.setName("soctyInsurCmptnDt01");
		new DateFieldMask(srhSoctyInsurCmptnDt01, "9999.99.99");
		srhSoctyInsurCmptnDt01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		srhSoctyInsurCmptnDt01.setFieldLabel("상실기간");
			  //  srhSoctyInsurCmptnDt01.setValue(value); 
			    
		layoutContainer_8.add(srhSoctyInsurCmptnDt01, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSch);

		srhSoctyInsurCmptnDt02 = new DateField();
		srhSoctyInsurCmptnDt02.setName("srhSoctyInsurCmptnDt02");
		new DateFieldMask(srhSoctyInsurCmptnDt02, "9999.99.99");
		srhSoctyInsurCmptnDt02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		srhSoctyInsurCmptnDt02.setLabelSeparator("~");

		layoutContainer_9.add(srhSoctyInsurCmptnDt02, new FormData("100%"));
		lcSchLeft.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_9.setBorders(false);

		

		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytSch);

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
		lsPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서
					 * : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd"
					 * ,"srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkInsr2400Auth("srhPayrMangDeptCd", lsPayrMangDeptCd);
				}
			}
		});
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		srhDeptCd.reset(); // 2015.12.07 추가
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
				// -------------------- 부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// -------------------- 부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd);
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});
			}
		});
		layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
		layoutContainer.setBorders(false);

		 LayoutContainer layoutContainer_1 = new LayoutContainer();
	        layoutContainer_1.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_101 = new LayoutContainer();

	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_101.setLayout(frmlytSch);
	        
	        srhEmymtDivCd =  new ComboBox<BaseModel>(); 
	        srhEmymtDivCd.setName("srhEmymtDivCd");
	        srhEmymtDivCd.setForceSelection(true);
	        srhEmymtDivCd.setMinChars(1);
	        srhEmymtDivCd.setDisplayField("commCdNm");
	        srhEmymtDivCd.setValueField("commCd");
	        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
	        srhEmymtDivCd.setEmptyText("--고용구분선택--");
	        srhEmymtDivCd.setSelectOnFocus(true); 
	        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	        srhEmymtDivCd.setStore(lsEmymtDivCd);
	        srhEmymtDivCd.setFieldLabel("고용구분");
	        lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	         	   EventType type = be.getType();
	         	   if (type == Store.Add) { 
	             		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                          * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                          * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                          * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                          ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                     	checkInsr2400Auth("EmymtDivCd", lsEmymtDivCd ); 
	             	 }
	                
	            }
	        });    
	        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	     	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	     	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	     	    	 BaseModel bmPayCd =  se.getSelectedItem(); 
	     	    	 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	     	    		 srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                      srhBusinCd.setEnabled(true);
	                      srhTypOccuCd.reset();
	                      srhTypOccuCd.setEnabled(false);
	                      srhDtilOccuInttnCd.reset();
	                      srhDtilOccuInttnCd.setEnabled(false);
	                  } else {
	                 	 //20151130 추가 수정 
	                 	 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	                 	 srhBusinCd.reset();
	                      srhBusinCd.setEnabled(false);   
	                      if (gwtExtAuth.getEnableTypOccuCd()) {
	                     	 srhTypOccuCd.setEnabled(true);
	                          srhDtilOccuInttnCd.setEnabled(true); 
	                      } else {
	                     	 srhTypOccuCd.setEnabled(false);
	                          srhDtilOccuInttnCd.setEnabled(false);
	                          
	                      }
	                  }  
	     	    	 
	     	    	} 
	     	    });
	        layoutContainer_101.add(srhEmymtDivCd, new FormData("100%"));
	        layoutContainer_101.setBorders(false); 
	        
	        
	        LayoutContainer layoutContainer_102 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(1); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        frmlytSch.setDefaultWidth(0);
	        layoutContainer_102.setLayout(frmlytSch);
	        
	        
	        
	        srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	        srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	        srhRepbtyBusinDivCd.setForceSelection(true);
	        srhRepbtyBusinDivCd.setAllowBlank(false);
	        srhRepbtyBusinDivCd.setMinChars(1);
	        srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	        srhRepbtyBusinDivCd.setValueField("commCd");
	        srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	        srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	        srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	        srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	        srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	        srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	        srhRepbtyBusinDivCd.setHideLabel(true);
	        //srhRepbtyBusinDivCd.setLabelSeparator("");
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	        lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

//	            	  EventType type = be.getType();
//	     	    	   if (type == Store.Add) { 
//	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	     	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	     	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	     	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//	     	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	     	    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//	                	 }  
	              
	            }
	        });  
	        
	        layoutContainer_102.add(srhRepbtyBusinDivCd, new FormData("100%"));
	        layoutContainer_102.setBorders(false); 
	        
	        
	        layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	        layoutContainer_1.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	        layoutContainer_1.setBorders(false); 
		
		
		

	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
	        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		    //lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));//

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());

		//관리부서 
		LayoutContainer lcSch2_1 = new LayoutContainer();
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(60);
		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_1.setLayout(frmlytSch2_1);
		
		srhMangeDeptCd = new ComboBox<BaseModel>();
		srhMangeDeptCd.setName("srhMangeDeptCd"); 
		srhMangeDeptCd.setEmptyText("--관리부서선택--");
		srhMangeDeptCd.setDisplayField("deptNmRtchnt");
		srhMangeDeptCd.setStore(lsMangeDeptCd); 
		srhMangeDeptCd.setWidth(100);
		srhMangeDeptCd.setFieldLabel("관리부서");
		srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
        srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
        srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
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
        srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	    		sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		
  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
  	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
  	    			}
  	    		});  
  	    		emptyCheck = true;
	    	} 
	    });
        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
            	
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
                	
                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
	                	sysComBass0400Dto = new PrgmComBass0400DTO();
	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		
	      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	      	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	      	    			} 
	      	    			
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
		
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		// srhDeptCd.setForceSelection(true);
		// srhDeptCd.setMinChars(1);
		// srhDeptCd.setDisplayField("deptNmRtchnt");
		// srhDeptCd.setValueField("deptCd");
		// srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		// srhDeptCd.setSelectOnFocus(true);
		// srhDeptCd.setReadOnly(false);
		// srhDeptCd.setEnabled(true);
		// srhDeptCd.setStore(lsDeptCd );
		// srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.getStore().add(mDtalistDeptCd);
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서
					 * : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd"
					 * ,"srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkInsr2400Auth("srhDeptCd", lsDeptCd);
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.CheckChanged, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhDeptCd.getListView().getChecked().size() == 1)
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

					if (srhDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(), "yyyy"));
								List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
								sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}

					// --------------------사업 불러 오는 함수 -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수-------------------------------------------------
					srhBusinCd.setStore(lsBusinCd);
					srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
											// searchBusinCd.setValue(lsBusinCd.getAt(0));
							}
						});
					} else if ((srhDeptCd.getListView().getChecked().size() > 0)
								&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

						// 2015.11.30 권한 직종가져오기 추가
						sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
						String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt", "deptCd");
						sysComBass0320Dto.setDeptCd(strDeptCd);
						lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
						lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd);
								srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
							}
						});
					} else {
						sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
						String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt", "deptCd");
						sysComBass0320Dto.setDeptCd(strDeptCd);
						lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
						lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd);
								srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
							}
						});
					}
				}
		});
		srhDeptCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);

		// 직종 직종세처리
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		
		LayoutContainer layoutContainer_20 = new LayoutContainer();
		   frmlytSch = new FormLayout();  
		   frmlytSch.setLabelWidth(60); 
		   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		   layoutContainer_20.setLayout(frmlytSch); 
		   
		   
		   srhDeptGpCd  =  new ComboBox<BaseModel>(); 
		   srhDeptGpCd.setName("srhDeptGpCd");
		   srhDeptGpCd.setForceSelection(true);
		   srhDeptGpCd.setAllowBlank(false);
		   srhDeptGpCd.setMinChars(1);
		   srhDeptGpCd.setDisplayField("commCdNm");
		   srhDeptGpCd.setValueField("commCd");
		   srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
		   srhDeptGpCd.setEmptyText("--그룹--");
		   srhDeptGpCd.setSelectOnFocus(true); 
		   srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		   srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		   srhDeptGpCd.setStore(lsDeptGpCd);
		   srhDeptGpCd.setFieldLabel("직종"); 
		
		
		   layoutContainer_20.add(srhDeptGpCd, new FormData("100%")); 
		
		
		   LayoutContainer layoutContainer_21 = new LayoutContainer();
		   frmlytSch = new FormLayout();  
		   frmlytSch.setLabelWidth(1); 
		   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		   frmlytSch.setDefaultWidth(0);
		   layoutContainer_21.setLayout(frmlytSch); 
		   
		   
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		srhTypOccuCd.setHideLabel(true);
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					// 2015.11.30 추가
					if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
						if (!gwtExtAuth.getEnableTypOccuCd()) {
							ModelData mdSelect = srhTypOccuCd.getStore().getAt(0);
							srhTypOccuCd.getListView().setChecked(mdSelect, true);
							srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
						}
						/**
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
						 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 
						 * 값순서 : 단위기관 ,고용구분, 부서,직종, 사업 순으로 없으면 ""
						 * "srhPayrMangDeptCd","srhEmymtDivCd"
						 * ,"srhDeptCd","srhTypOccuCd","srhBusinCd"
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					}
				}
			}
		});

		srhTypOccuCd.getListView().addListener(Events.CheckChanged, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				// 2015.11.30 추가
				displayDtilOccuInttnCd();
			}
		});

		srhTypOccuCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		// 2015.11.30 추가
		srhTypOccuCd.addListener(Events.Add, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent ce) {
				displayDtilOccuInttnCd();
			}
		});

		layoutContainer_21.add(srhTypOccuCd, new FormData("100%"));

		LayoutContainer lcSchRight = new LayoutContainer();
		// lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lcSchRight.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */

		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		srhDtilOccuInttnCd.setWidth(100);
		srhDtilOccuInttnCd.setHideLabel(true);
		srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
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

		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));

//		lcTypOccuCd.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
//		lcTypOccuCd.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		layoutContainer_21.setBorders(false);

		   lcTypOccuCd.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		   lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		   lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
		   layoutContainer_21.setBorders(false);
		
		
		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);

		
		fieldSet.add(layoutContainer_13);
		layoutContainer_13.setBorders(false);

		  layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		    //layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
			
		
		
		   

		    LayoutContainer lcSchCol3 = new LayoutContainer();
		    lcSchCol3.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_4 = new LayoutContainer();

		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_4.setLayout(frmlytSch);
		    
		    srhBusinCd = new ComboBox<BaseModel>();
		    srhBusinCd.setName("srhBusinCd");
		    srhBusinCd.setForceSelection(true);
		    srhBusinCd.setMinChars(1);
		    srhBusinCd.setDisplayField("businNm");
		    srhBusinCd.setValueField("businCd");
		    srhBusinCd.setTriggerAction(TriggerAction.ALL);
		    srhBusinCd.setEmptyText("--사업선택--");
		    srhBusinCd.setSelectOnFocus(true); 
		    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
		    srhBusinCd.setStore(lsBusinCd);
		    srhBusinCd.setFieldLabel("사업");
		    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
		    
		    
		    
		    
		    LayoutContainer layoutContainer_5 = new LayoutContainer();
		    layoutContainer_5.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_6 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_6.setLayout(frmlytSch);
		    
		    srhHanNm = new TextField<String>();
		    srhHanNm.setName("srhHanNm");
		    srhHanNm.setFieldLabel("성명");
		    layoutContainer_6.add(srhHanNm, new FormData("100%"));
		    srhHanNm.addKeyListener(new KeyListener() {
		        public void componentKeyDown(ComponentEvent event) {
		          
		            srhHanNm.validate();
		            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
		                srhSystemkey.setValue("");
		                srhResnRegnNum.setValue("");
		            }
		            if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		                srhSystemkey.setValue("");
		                srhResnRegnNum.setValue(""); 
		                fnPopupPsnl0100() ;
		            }
		            super.componentKeyDown(event);
		        }
		     });
//		    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//		        @Override
//		        public void handleEvent(BaseEvent be) {  
//		            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//		                srhSystemkey.setValue("");
//		                srhResnRegnNum.setValue("");
//		            }
//		         
//		        } 
//		   }); 
		    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		    layoutContainer_6.setBorders(false);
		    
		    Button btnHanNm = new Button("검색");
		    layoutContainer_5.add(btnHanNm);
		    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
		        public void handleEvent(ButtonEvent e) {
		            srhSystemkey.setValue("");
		            srhResnRegnNum.setValue("");   
		          fnPopupPsnl0100() ;
		              
		        }
		    });
		    
		    LayoutContainer layoutContainer_7 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_7.setLayout(frmlytSch);
		    
		    /** column 주민등록번호 : resnRegnNum */
		    srhResnRegnNum = new TextField<String>();
		    srhResnRegnNum.setName("srhResnRegnNum");
		    new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
		    srhResnRegnNum.setHideLabel(true);
		    srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
		        @Override
		        public void handleEvent(BaseEvent be) {  
		            if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
		                srhSystemkey.setValue("");
		                srhHanNm.setValue("");
		            }
		         
		        } 
		  }); 
		    layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
		    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.41));
		    layoutContainer_7.setBorders(false); 
		    layoutContainer_5.setBorders(false);
		    
			LayoutContainer layoutContainer_14 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_14.setLayout(frmlytSch);

			srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
			srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
			// srhHdofcCodtnCd.setForceSelection(true);
			// srhHdofcCodtnCd.setMinChars(1);
			// srhHdofcCodtnCd.setDisplayField("commCdNm");
			// srhHdofcCodtnCd.setValueField("commCd");
			// srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
			srhHdofcCodtnCd.setEmptyText("--재직선택--");
			// srhHdofcCodtnCd.setSelectOnFocus(true);
			srhHdofcCodtnCd.setReadOnly(true);
			srhHdofcCodtnCd.setEnabled(true);
			// srhHdofcCodtnCd.setStore(lsHdofcCodtnCd);
			srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
			srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
			srhHdofcCodtnCd.setWidth(100);
			// srhHdofcCodtnCd.setHeight(100);
			srhHdofcCodtnCd.setFieldLabel("재직상태");
			srhHdofcCodtnCd.getStore().addStoreListener(new StoreListener<ModelData>() {
				public void handleEvent(StoreEvent<ModelData> be) {
					checkInsr2400Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);
				}
			});
			srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
				@Override
				public void handleEvent(ComponentEvent ce) {
					if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
						// GWT.log(" a" + ce.getEvent().getType());
						mutilCombo = true;
					} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
						mutilCombo = true;
						// GWT.log(" b" + ce.getEvent().getType());
					} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
						mutilCombo = false;
						// GWT.log(" b" + ce.getEvent().getType());
					}
				}
			});

			layoutContainer_14.add(srhHdofcCodtnCd, new FormData("100%"));
			layoutContainer_14.setBorders(false);
			
		    lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		    lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    lcSchCol3.setBorders(false);
		    
		    fieldSet.add(lcSchCol3);
		    
		   plFrmInsr2400.add(fieldSet);
		// vp.add(panel);
	}
		  

	private void  displayDtilOccuInttnCd() {
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	              
		   //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect = srhDeptCd.getListView().getChecked();
			String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect, "deptCd");
			sysComBass0350Dto.setDeptCd(strDeptCd);
			List<ModelData> mdListSelect = srhTypOccuCd.getListView().getChecked();
			String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect, "typOccuCd");
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
	                  
	                 // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	                  
			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
	                      
				lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
						srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
	                              
						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
			  		                   
							srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
						}
					}
				});
			}

		} else {

		}
	}
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
		
		LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
		layoutContainer.setBorders(false);
		
		
		LayoutContainer layoutGirdContainer = new LayoutContainer();
		layoutGirdContainer.setBorders(false);
		
		
		LayoutContainer layoutGirdContainer_1 = new LayoutContainer();
		layoutGirdContainer_1.setBorders(false);
		layoutGirdContainer_1.add(occupationalLeft1());
		layoutGirdContainer.add(layoutGirdContainer_1, new FormData("100%"));
		
		LayoutContainer layoutGirdContainer_2 = new LayoutContainer();
		layoutGirdContainer_2.setBorders(false);
		layoutGirdContainer_2.add(occupationalLeft2());
		layoutGirdContainer.add(layoutGirdContainer_2, new FormData("100%"));
		
		
		layoutContainer.add(layoutGirdContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//		layoutContainer.add(occupationalLeft(), new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer.add(createInfoForm(), new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));

		plFrmInsr2400.add(layoutContainer);
		
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
	
	//급여대상자정보 그리드 
	private LayoutContainer occupationalLeft1() {

		FieldSet fieldSetGrd = new FieldSet();  
	    fieldSetGrd.setHeadingHtml("대상자정보");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    FormLayout frmlytStd = new FormLayout();  
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(325, 305);  
	    
	    insr2200GridPanel = new MSFGridPanel(insr2200Def, false, false, false, false);
	    insr2200GridPanel.setHeaderVisible(false);  
	    insr2200GridPanel.setBodyBorder(true);
	    insr2200GridPanel.setBorders(true);
	    
	    
		final Grid insr2100Grid = insr2200GridPanel.getMsfGrid().getGrid(); 
		insr2100Grid.addListener(Events.CellDoubleClick,  new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
	    
				if (insr2200GridPanel.getCurrentlySelectedItem() != null) {  
					
					resetForm();
					
					setRecord(insr2200GridPanel.getCurrentlySelectedItem());	
					
					
					
					dpobCd.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("dpobCd")));
					systemkey.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("systemkey")));
				
//				    soctyInsurCmptnDt.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("soctyInsurCmptnDt"), "yyyyMMdd"));
				    //insr2100 상실일자(고용보험상실일기준)
					soctyInsurCmptnDt.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal18"), "yyyyMMdd"));
				    
				    //실제 작성일자
				    soctyInsurCmptnDtReal.setValue((String) insr2200GridPanel.getCurrentlySelectedItem().get("soctyInsurCmptnDt"));
				    
				    socnsrIssRegVal02.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal02")));
				    socnsrIssRegVal03.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal03")));
				    socInsrLssEmymtNum.setValue((Long)insr2200GridPanel.getCurrentlySelectedItem().get("socInsrLssEmymtNum"));   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */				
				    emymtDivNm.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("emymtDivNm"))); //고용구분 
					deptNm.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("deptNm"))); //부서 
					typOccuNm.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("typOccuNm"))); //직종 
				    
				    
					
					
					IColumnFilter filters = null;
			
					
					 
					insr2520GridPanel.getTableDef().setTableColumnFilters(filters);			
					insr2520GridPanel.getTableDef().addColumnFilter("dpobCd",  MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("dpobCd")), SimpleColumnFilter.OPERATOR_EQUALS); 
					insr2520GridPanel.getTableDef().addColumnFilter("systemkey",  MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("systemkey")), SimpleColumnFilter.OPERATOR_EQUALS); 			
					insr2520GridPanel.getTableDef().addColumnFilter("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					insr2520GridPanel.getTableDef().addColumnFilter("socInsrLssEmymtNum", (Long)insr2200GridPanel.getCurrentlySelectedItem().get("socInsrLssEmymtNum"), SimpleColumnFilter.OPERATOR_EQUALS); 
			        
					insr2520GridPanel.reload();
					
					BaseModel baseModel = new BaseModel();
					baseModel.set("systemkey", MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("systemkey")));
					baseModel.set("retryYrMnth", MSFSharedUtils.allowNulls(retryYrMnth.getValue()));
					baseModel.set("socInsrLssEmymtNum", (Long)insr2200GridPanel.getCurrentlySelectedItem().get("socInsrLssEmymtNum"));
					
					
					
					
					insrP230006Service.activityOnSelectInsr2500Data(baseModel,  new AsyncCallback<Insr2500DTO>() {
						
						public void onSuccess(Insr2500DTO result) {

								deptCd.setValue(result.getDeptCd());
							 	tempDateFld1.setValue(InsrUtils.getConvertStringToDate((String) result.getRetryDt(), "yyyyMMdd"));			//퇴직일
							 	tempDateFld2.setValue(InsrUtils.getConvertStringToDate((String) result.getUmytInsrAqtnDt(), "yyyyMMdd"));   //취득일
							 	icncDt.setValue(result.getIcncDt());	//입사일자

								retryYrMnth.setValue(result.getRetryYrMnth());					//작성년월
								InsrUtils.setSelectedComboValue(tempComboTop_0, result.getUmytInsrChgjbReasCd(), "commCd");		//이직사유코드			
								tempUnderTxtFle_2.setValue(result.getUmytInsrSpecResnCtnt());   //구체적사유
								tempNumFle.setValue(result.getUsalyTisedUntPridNumDys());		//통상피보험자단위기간일수		
								
								tempNumFle_9.setValue(result.getAvgAmntAllwBnusSum());
								tempNumFle_10.setValue(result.getAvgAmntAnnlExtpySum());
								tempNumFle_11.setValue(result.getAvgAmntEtcSum());
								
								tempNumDaysFle_5.setValue(result.getAvgAmntCalcTotNumDys());//총일수 합계
								tempSumNumFle_1.setValue(result.getAvgAmntFndtnSum());      //평균임금 기본금액 합계
								tempSumNumFle_2.setValue(result.getAvgAmntEtcExtpySum());   //그밖의 수당 합계
								tempSumNumFle_3.setValue(result.getAvgAmntAllwBnusSum());   //상여금 합계
								tempSumNumFle_4.setValue(result.getAvgAmntAnnlExtpySum());  //연차수당 합계
								tempSumNumFle_5.setValue(result.getAvgAmntEtcSum());        //기타 합계
								tempUnderNumFle_4.setValue(result.getUsalyAmntWag());           //통산임금액
								tempUnderNumFle_5.setValue(result.getStdAmntWag());				//기준임금액
								tempUnderNumFle_6.setValue(result.getDayFxdWorkTmNum());		//1일소정근로시간
								tempUnderNumFle_7.setValue(result.getSevePayReipSum());			//퇴직금수령금액		
								tempUnderTxtFle_1.setValue(result.getSevePayRstEtcSum());		//퇴직금외기타금액
								
							
						}
						
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
							MessageBox.info("", "조회 오류", null);
						}
					});
					
					insrP230006Service.activityOnSelectInsr2510DataList(baseModel,  new AsyncCallback<List<Insr2510DTO>>() {		
						public void onSuccess(List<Insr2510DTO> result) {
							if(result.size() > 0){
								for(int i=0; i<result.size(); i++){
									Insr2510DTO insr2510Dto = (Insr2510DTO) result.get(i);
									if(insr2510Dto.getSevePayDtlPatrNum() == 1){
										tempMidDate_1_S.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtBgnnDt(), "yyyyMMdd"));
										tempMidDate_1_E.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtEndDt(), "yyyyMMdd"));				
										tempNumDaysFle_1.setValue(insr2510Dto.getPymtNumDys());
										tempNumFle_1.setValue(insr2510Dto.getAmntBspySum());
										tempNumFle_5.setValue(insr2510Dto.getAmntEtcExtpySum());
									}
									if(insr2510Dto.getSevePayDtlPatrNum() == 2){									
										tempMidDate_2_S.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtBgnnDt(), "yyyyMMdd"));
										tempMidDate_2_E.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtEndDt(), "yyyyMMdd"));				
										tempNumDaysFle_2.setValue(insr2510Dto.getPymtNumDys());
										tempNumFle_2.setValue(insr2510Dto.getAmntBspySum());
										tempNumFle_6.setValue(insr2510Dto.getAmntEtcExtpySum());
									}
									if(insr2510Dto.getSevePayDtlPatrNum() == 3){
										tempMidDate_3_S.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtBgnnDt(), "yyyyMMdd"));
										tempMidDate_3_E.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtEndDt(), "yyyyMMdd"));				
										tempNumDaysFle_3.setValue(insr2510Dto.getPymtNumDys());
										tempNumFle_3.setValue(insr2510Dto.getAmntBspySum());
										tempNumFle_7.setValue(insr2510Dto.getAmntEtcExtpySum());
									}
									if(insr2510Dto.getSevePayDtlPatrNum() == 4){
										tempMidDate_4_S.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtBgnnDt(), "yyyyMMdd"));
										tempMidDate_4_E.setValue(InsrUtils.getConvertStringToDate((String) insr2510Dto.getPayPymtEndDt(), "yyyyMMdd"));				
										tempNumDaysFle_4.setValue(insr2510Dto.getPymtNumDys());//총일수
										tempNumFle_4.setValue(insr2510Dto.getAmntBspySum());//기본금
										tempNumFle_8.setValue(insr2510Dto.getAmntEtcExtpySum());//기타수당
									}
								}				
								Long sum1 = longToNullChk(tempNumDaysFle_1.getValue())
										   +longToNullChk(tempNumDaysFle_2.getValue())
										   +longToNullChk(tempNumDaysFle_3.getValue())
										   +longToNullChk(tempNumDaysFle_4.getValue());
								
								
								
								//Long sum2 = tempNumFle_1.getValue().longValue()+tempNumFle_2.getValue().longValue()+tempNumFle_3.getValue().longValue()+tempNumFle_4.getValue().longValue();
								//Long sum3 = tempNumFle_5.getValue().longValue()+tempNumFle_6.getValue().longValue()+tempNumFle_7.getValue().longValue()+tempNumFle_8.getValue().longValue();			
								tempNumDaysFle_5.setValue(sum1); //총일수 합계
								//tempSumNumFle_1.setValue(sum2); //기본금 합계
								//tempSumNumFle_2.setValue(sum3); //기타수당 합계
							}
//							else{
//								tempNumDaysFle_1.setValue(0L);
//								tempNumFle_1.setValue(0L);
//								tempNumFle_5.setValue(0L);
//								tempNumDaysFle_2.setValue(0L);
//								tempNumFle_2.setValue(0L);
//								tempNumFle_6.setValue(0L);
//								tempNumDaysFle_3.setValue(0L);
//								tempNumFle_3.setValue(0L);
//								tempNumFle_7.setValue(0L);
//								tempNumDaysFle_4.setValue(0L);//총일수
//								tempNumFle_4.setValue(0L);//기본금
//								tempNumFle_8.setValue(0L);//기타수당
//							}
						}
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
							MessageBox.info("", "조회 오류", null);
						}
					});
					
					
					insrP230006Service.activityOnSelectInsr2530DataList(baseModel,  new AsyncCallback<List<Insr2530DTO>>() {
						
						public void onSuccess(List<Insr2530DTO> result) {
							if(result.size() > 0){
								for(int i=0; i<result.size(); i++){
									Insr2530DTO insr2530Dto = (Insr2530DTO) result.get(i);
									if(insr2530Dto.getStdExtnnSeilNum() == 1){
										tempTopDate_1_S.setValue(InsrUtils.getConvertStringToDate((String) insr2530Dto.getStdExtnnBgnnDt(), "yyyyMMdd"));
										tempTopDate_1_E.setValue(InsrUtils.getConvertStringToDate((String) insr2530Dto.getStdExtnnEndDt(), "yyyyMMdd"));
										InsrUtils.setSelectedComboValue(tempComboTop_1, insr2530Dto.getStdExtnnReasCd(), "commCd");					
									}
									if(insr2530Dto.getStdExtnnSeilNum() == 2){
										tempTopDate_2_S.setValue(InsrUtils.getConvertStringToDate((String) insr2530Dto.getStdExtnnBgnnDt(), "yyyyMMdd"));
										tempTopDate_2_E.setValue(InsrUtils.getConvertStringToDate((String) insr2530Dto.getStdExtnnEndDt(), "yyyyMMdd"));
										InsrUtils.setSelectedComboValue(tempComboTop_2, insr2530Dto.getStdExtnnReasCd(), "commCd");		
									}
									if(insr2530Dto.getStdExtnnSeilNum() == 3){
										tempTopDate_3_S.setValue(InsrUtils.getConvertStringToDate((String) insr2530Dto.getStdExtnnBgnnDt(), "yyyyMMdd"));
										tempTopDate_3_E.setValue(InsrUtils.getConvertStringToDate((String) insr2530Dto.getStdExtnnEndDt(), "yyyyMMdd"));
										InsrUtils.setSelectedComboValue(tempComboTop_3, insr2530Dto.getStdExtnnReasCd(), "commCd");	
									}
								}
							}
						}
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
							MessageBox.info("", "조회 오류", null);
						}
					});
				}
	        	   
           }
       }); 


		insr2100Grid.addListener(Events.CellClick,  new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (insr2200GridPanel.getCurrentlySelectedItem() == null) { 	
					resetForm();				
				}
			}
		});

		
	    cpGrid.add(insr2200GridPanel); 
	    
	    fieldSetGrd.add(cpGrid);
	    lcStdGrid.add(fieldSetGrd);
	    
	    return lcStdGrid;
	}
	
	private LayoutContainer occupationalLeft2() {

		FieldSet fieldSetGrd = new FieldSet();  
	    fieldSetGrd.setHeadingHtml("");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    FormLayout frmlytStd = new FormLayout();  
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(325, 180);  
	    
	    insr2520GridPanel = new MSFGridPanel(insr2520Def, false, false, false, false, false);
	    insr2520GridPanel.setHeaderVisible(false);  
	    insr2520GridPanel.setBodyBorder(true);
	    insr2520GridPanel.setBorders(true);
//	    final Grid insr2400ToInsr1400Grid = insr1400GridPanel.getMsfGrid().getGrid();
//	    insr2400ToInsr1400Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
//           public void handleEvent(BaseEvent be) {   
//	        	   
//           }
//       }); 
	    insr2520GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("재무단위 산정대상기간(이직일포함)", 1, 2));
	    cpGrid.add(insr2520GridPanel); 
	    
	    LayoutContainer lc = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer lc1 = new LayoutContainer();
	    
		FormLayout frmlytSchlc1 = new FormLayout();
		frmlytSchlc1.setLabelWidth(150);
		frmlytSchlc1.setLabelAlign(LabelAlign.RIGHT);
		
		lc1.setLayout(frmlytSchlc1);
		
	    tempNumFle = new NumberField();
		tempNumFle.setFieldLabel("통산피보험 단위기간");
		tempNumFle.setReadOnly(true);
		tempNumFle.setAllowDecimals(true); 
		tempNumFle.setPropertyEditorType(Long.class); 
		tempNumFle.setFormat(NumberFormat.getDecimalFormat());
		lc1.add(tempNumFle, new FormData("100%"));
		
		lc.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
	    
	    LayoutContainer lc2 = new LayoutContainer();
	    
	    LabelField labelfld1= new LabelField("일");
	    labelfld1.setStyleAttribute("padding-top", "5px");
	    labelfld1.setStyleAttribute( "text-align", "center");
		labelfld1.setBorders(false);
		lc2.add(labelfld1, new FormData("100%"));
	    
	    lc.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	    
	    
	    fieldSetGrd.add(cpGrid);
	    fieldSetGrd.add(lc);
	    lcStdGrid.add(fieldSetGrd);
	    
	    return lcStdGrid;
	}
	
	

	
	
	private LayoutContainer createInfoForm() {

		 sysComBass0300Dto.setRpsttvCd("I027");
		 stdExtnnReasCdStore = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		 
		 sysComBass0300Dto.setRpsttvCd("I022");
		 umytInsrChgjbReasCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FormLayout());
		layoutContainer.setBorders(false);
		
		FieldSet fieldSetInfo = new FieldSet();
		fieldSetInfo.setHeadingHtml("기본정보");
		
		//--
		LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytSch);
     
		soctyInsurCmptnDt = new MSFDateField();   
		soctyInsurCmptnDt.setReadOnly(true);
		new DateFieldMask(soctyInsurCmptnDt, "9999.99.99");
		soctyInsurCmptnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		soctyInsurCmptnDt.setName("soctyInsurCmptnDt");
		layoutContainer_2_1.add(soctyInsurCmptnDt, new FormData("100%"));
		soctyInsurCmptnDt.setFieldLabel("상실일자");
		layoutContainer_6.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer_2_1.setBorders(false);
     
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setBorders(false);
		// layoutContainer_3.setBorders(true);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
     
		socnsrIssRegVal02 = new MSFTextField();
		socnsrIssRegVal02.setReadOnly(true);
		layoutContainer_3.add(socnsrIssRegVal02, new FormData("100%"));
		socnsrIssRegVal02.setFieldLabel("성명");
		layoutContainer_6.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		socnsrIssRegVal03 = new MSFTextField();
		socnsrIssRegVal03.setReadOnly(true);
		layoutContainer_4.add(socnsrIssRegVal03, new FormData("100%"));
		socnsrIssRegVal03.setHideLabel(true);
		layoutContainer_6.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));
     
		/** 고용구분 */
		LayoutContainer layoutContaineri_4 = new LayoutContainer();
		layoutContaineri_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContaineri_4.setLayout(frmlytStd);

		emymtDivNm = new MSFTextField();
		emymtDivNm.setReadOnly(true);
		layoutContaineri_4.add(emymtDivNm, new FormData("100%"));
		emymtDivNm.setFieldLabel("고용구분");
		layoutContainer_6.add(layoutContaineri_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    
		fieldSetInfo.add(layoutContainer_6, new FormData("100%"));

		LayoutContainer layoutContainera7 = new LayoutContainer();
		layoutContainera7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainera_1 = new LayoutContainer();
		layoutContainera_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainera_1.setLayout(frmlytStd);

		
		
		socInsrLssEmymtNum = new MSFNumberField();
		layoutContainera_1.add(socInsrLssEmymtNum, new FormData("100%"));
		socInsrLssEmymtNum.setReadOnly(true);
		socInsrLssEmymtNum.setFieldLabel("일련번호");
		layoutContainera7.add(layoutContainera_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
     
		LayoutContainer layoutContainera_2 = new LayoutContainer();
		layoutContainera_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainera_2.setLayout(frmlytStd);

		deptNm = new MSFTextField();
		deptNm.setReadOnly(true);
		layoutContainera_2.add(deptNm, new FormData("100%"));
		deptNm.setFieldLabel("부서");

		layoutContainera7.add(layoutContainera_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
     

		LayoutContainer layoutContainerb_2 = new LayoutContainer();
		layoutContainerb_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerb_2.setLayout(frmlytStd);

		typOccuNm = new MSFTextField();
		typOccuNm.setReadOnly(true);
		layoutContainerb_2.add(typOccuNm, new FormData("100%"));
		typOccuNm.setFieldLabel("직종");

		layoutContainera7.add(layoutContainerb_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		fieldSetInfo.add(layoutContainera7, new FormData("100%"));

		LayoutContainer layoutContainer18 = new LayoutContainer();
		layoutContainer18.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer18_1 = new LayoutContainer();
		layoutContainer18_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer18_1.setLayout(frmlytStd);
     
		tempDateFld1 = new MSFDateField();   
//		tempDateFld1.setReadOnly(true);
		new DateFieldMask(tempDateFld1, "9999.99.99");
		tempDateFld1.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempDateFld1.setName("tempDateFld1");
		layoutContainer18_1.add(tempDateFld1, new FormData("100%"));
		layoutContainer18.add(layoutContainer18_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		tempDateFld1.setFieldLabel("이직(퇴직일)");

		LayoutContainer layoutContainer18_2 = new LayoutContainer();
		layoutContainer18_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer18_2.setLayout(frmlytStd);
		
		tempDateFld2 = new MSFDateField();   
//		tempDateFld2.setReadOnly(true);
		new DateFieldMask(tempDateFld2, "9999.99.99");
		tempDateFld2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempDateFld2.setName("tempDateFld2");
		layoutContainer18_2.add(tempDateFld2, new FormData("100%"));
		tempDateFld2.setFieldLabel("취득일");
		layoutContainer18.add(layoutContainer18_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fieldSetInfo.add(layoutContainer18, new FormData("100%"));
		//--
		layoutContainer.add(fieldSetInfo);
		
		
		

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		
		LayoutContainer lyoutTop0 = new LayoutContainer(new ColumnLayout());
		lyoutTop0.setBorders(false);

		
		
		final LayoutContainer lyoutTop0_1 = new LayoutContainer();
		lyoutTop0_1.setBorders(true);
		
		lyoutTop0_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutTop0_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutTop0_1.setStyleName("x-border-u-bottom",true);
	    		lyoutTop0_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    		lyoutTop0_1.setHeight("50px");  
	    	}
	    });
		   
		LabelField labelfldTop0_1= new LabelField("이직사유");
		labelfldTop0_1.setStyleAttribute("padding-top", "5px");
		labelfldTop0_1.setStyleAttribute( "text-align", "center");
	    
		lyoutTop0_1.add(labelfldTop0_1, new FormData("100%"));
		
		//------------------------------------------------------------
		
		
		
		
		LayoutContainer lyoutTop0_2 = new LayoutContainer();
		lyoutTop0_2.setBorders(false);
		
		
		LayoutContainer lyoutTop0_2_1 = new LayoutContainer(new ColumnLayout());
		lyoutTop0_2_1.setBorders(false);
		
		
		final LayoutContainer lyoutTop0_2_1_1 = new LayoutContainer();
		lyoutTop0_2_1_1.setBorders(true);
		
		lyoutTop0_2_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutTop0_2_1_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutTop0_2_1_1.setStyleName("x-border-u-bottom",true);
	    		lyoutTop0_2_1_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    		lyoutTop0_2_1_1.setHeight("25px");  
	    	}
	    });
		   
		LabelField labelfldTop0_2_1_1= new LabelField("구분");
		labelfldTop0_2_1_1.setStyleAttribute("padding-top", "5px");
		labelfldTop0_2_1_1.setStyleAttribute( "text-align", "center");
		lyoutTop0_2_1_1.add(labelfldTop0_2_1_1, new FormData("100%"));
		
		lyoutTop0_2_1.add(lyoutTop0_2_1_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		

		
		LayoutContainer lyoutTop0_2_1_2 = new LayoutContainer();
		lyoutTop0_2_1_2.setBorders(true);	

		
		FormLayout frmlytStd0 = new FormLayout();
		frmlytStd0.setLabelWidth(0);
		frmlytStd0.setLabelAlign(LabelAlign.RIGHT);
		lyoutTop0_2_1_2.setLayout(frmlytStd0);
		
		 tempComboTop_0 = new ComboBox<BaseModel>();
		 tempComboTop_0.setForceSelection(true);
		 tempComboTop_0.setMinChars(1);
		 tempComboTop_0.setDisplayField("commCdNm");
		 tempComboTop_0.setValueField("commCd");
		 tempComboTop_0.setTriggerAction(TriggerAction.ALL);
		 tempComboTop_0.setEmptyText("--이직사유선택--");
		 tempComboTop_0.setSelectOnFocus(true);
		 tempComboTop_0.setStore(umytInsrChgjbReasCd);
		 tempComboTop_0.setLabelSeparator("");
		

		lyoutTop0_2_1_2.add(tempComboTop_0, new FormData("100%")); 

		lyoutTop0_2_1.add(lyoutTop0_2_1_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		

		lyoutTop0_2.add(lyoutTop0_2_1,  new FormData("100%"));
		
		//------------------------------------------------------------------
		
		LayoutContainer lyoutTop0_2_2 = new LayoutContainer(new ColumnLayout());
		lyoutTop0_2_2.setBorders(false);
		
		
		final LayoutContainer lyoutTop0_2_2_1 = new LayoutContainer();
		lyoutTop0_2_2_1.setBorders(true);
		
		lyoutTop0_2_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutTop0_2_2_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutTop0_2_2_1.setStyleName("x-border-u-bottom",true);
	    		lyoutTop0_2_2_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    		lyoutTop0_2_2_1.setHeight("25px");  
	    	}
	    });
		   
		LabelField labelfldTop0_2_2_1= new LabelField("구체적사유");
		labelfldTop0_2_2_1.setStyleAttribute("padding-top", "5px");
		labelfldTop0_2_2_1.setStyleAttribute( "text-align", "center");  
		
		lyoutTop0_2_2_1.add(labelfldTop0_2_2_1, new FormData("100%"));
		lyoutTop0_2_2.add(lyoutTop0_2_2_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		

		
		LayoutContainer lyoutTop0_2_2_2 = new LayoutContainer();
		lyoutTop0_2_2_2.setBorders(true);
		
		FormLayout frmlytStd1 = new FormLayout();
		frmlytStd1.setLabelWidth(0);
		frmlytStd1.setLabelAlign(LabelAlign.RIGHT);
		lyoutTop0_2_2_2.setLayout(frmlytStd1);
		
		
		tempUnderTxtFle_2 = new TextField<String>();
		tempUnderTxtFle_2.setName("tempUnderTxtFle0");
		tempUnderTxtFle_2.setLabelSeparator("");
		lyoutTop0_2_2_2.add(tempUnderTxtFle_2, new FormData("100%"));
		lyoutTop0_2_2.add(lyoutTop0_2_2_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		
		
		lyoutTop0_2.add(lyoutTop0_2_2, new FormData("100%"));
		
		lyoutTop0.add(lyoutTop0_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
		lyoutTop0.add(lyoutTop0_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));

		fieldSet.add(lyoutTop0);

	
		
		LayoutContainer lyoutTop = new LayoutContainer(new ColumnLayout());
		lyoutTop.setBorders(false);
		
		final LayoutContainer lyoutTop_01 = new LayoutContainer();
		lyoutTop_01.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutTop_01.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutTop_01.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutTop_01.setStyleName("x-border-u-bottom",true);
	    		lyoutTop_01.setHeight("78px"); 
	    		
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    LabelField labelfldTop_1= new LabelField("기준연장기간");
	   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
	  //  lblfldNewLabelfield_12.setHeight(24);
	    labelfldTop_1.setStyleAttribute("padding-top", "5px");
	    labelfldTop_1.setStyleAttribute( "text-align", "center");
	    labelfldTop_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    lyoutTop_01.add(labelfldTop_1, new FormData("100%"));
	   // lblfldNewLabelfield_12.setHeight("20");
		
		lyoutTop.add(lyoutTop_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
		
		
		LayoutContainer lyoutTop_02 = new LayoutContainer();
		lyoutTop_02.setBorders(false);
		
		
		LayoutContainer lyoutTop_02_1 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_1.setBorders(false);
		
		
		final LayoutContainer lyoutTop_02_1_1 = new LayoutContainer();
		lyoutTop_02_1_1.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutTop_02_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutTop_02_1_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutTop_02_1_1.setStyleName("x-border-u-bottom",true);
	    		lyoutTop_02_1_1.setHeight("53px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    LabelField labelfldTop_02_1_1= new LabelField("사유");
	   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
	  //  lblfldNewLabelfield_12.setHeight(24);
	    labelfldTop_02_1_1.setStyleAttribute("padding-top", "5px");
	    labelfldTop_02_1_1.setStyleAttribute( "text-align", "center");
	    labelfldTop_02_1_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    lyoutTop_02_1_1.add(labelfldTop_02_1_1, new FormData("100%"));
	   // lblfldNewLabelfield_12.setHeight("20");
	    
	    
	    
		LayoutContainer lyoutTop_02_01 = new LayoutContainer();
		lyoutTop_02_01.setBorders(false);
		
		LayoutContainer lyoutTop_02_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_1_2.setBorders(false);
		
		LayoutContainer lyoutTop_02_1_2_1 = new LayoutContainer();
		lyoutTop_02_1_2_1.setBorders(true);
		Button button = new Button("기준연장초기화");
		lyoutTop_02_1_2_1.add(button); 
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempComboTop_1.clear();
				tempTopDate_1_S.clear();
				tempTopDate_1_E.clear();
			}
		});
		
		
		LayoutContainer lyoutTop_02_1_2_2 = new LayoutContainer();
		lyoutTop_02_1_2_2.setBorders(true);
		
		button = new Button("기준연장초기화");
		lyoutTop_02_1_2_2.add(button); 
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempComboTop_2.clear();
				tempTopDate_2_S.clear();
				tempTopDate_2_E.clear();
			}
		});
		
		LayoutContainer lyoutTop_02_1_2_3 = new LayoutContainer();
		lyoutTop_02_1_2_3.setBorders(true);
				
		button = new Button("기준연장초기화");
		lyoutTop_02_1_2_3.add(button); 
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempComboTop_3.clear();
				tempTopDate_3_S.clear();
				tempTopDate_3_E.clear();
			}
		});
		
		
//		RadioGroup radioGr = new RadioGroup();
//		
//		Radio radio1 = new Radio();
//		radio1.setBoxLabel("희망");
//		radio1.setHideLabel(true);
//		radio1.setValueAttribute("N");
//		radioGr.add(radio1);
//		
//		Radio radio2 = new Radio();
//		radio2.setBoxLabel("비희망");
//		radio2.setHideLabel(true);
//		radio2.setValueAttribute("Y");
//		radio2.setValue(true);
//		radioGr.add(radio2);
//		lyoutTop_02_1_2_3.add(radioGr, new FormData("100%"));
		
		
		lyoutTop_02_1_2.add(lyoutTop_02_1_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lyoutTop_02_1_2.add(lyoutTop_02_1_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lyoutTop_02_1_2.add(lyoutTop_02_1_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		lyoutTop_02_01.add(lyoutTop_02_1_2);
		
		LayoutContainer lyoutTop_02_1_3 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_1_3.setBorders(false);
		
		LayoutContainer lyoutTop_02_1_3_1 = new LayoutContainer();
		lyoutTop_02_1_3_1.setBorders(true);
		
		FormLayout formLayoutTop_02_1_3_1 = new FormLayout();
		formLayoutTop_02_1_3_1.setLabelWidth(0);
		lyoutTop_02_1_3_1.setLayout(formLayoutTop_02_1_3_1);
		
		tempComboTop_1 = new ComboBox<BaseModel>();
		tempComboTop_1.setForceSelection(true);
		tempComboTop_1.setMinChars(1);
		tempComboTop_1.setDisplayField("commCdNm");
		tempComboTop_1.setValueField("commCd");
		tempComboTop_1.setTriggerAction(TriggerAction.ALL);
		tempComboTop_1.setEmptyText("--연장사유선택--");
		tempComboTop_1.setSelectOnFocus(true);
		tempComboTop_1.setStore(stdExtnnReasCdStore);
		tempComboTop_1.setLabelSeparator("");
		lyoutTop_02_1_3_1.add(tempComboTop_1, new FormData("100%"));
		
		
		LayoutContainer lyoutTop_02_1_3_2 = new LayoutContainer();
		lyoutTop_02_1_3_2.setBorders(true);
		
		FormLayout formLayoutTop_02_1_3_2 = new FormLayout();
		formLayoutTop_02_1_3_2.setLabelWidth(0);
		lyoutTop_02_1_3_2.setLayout(formLayoutTop_02_1_3_2);
		
		tempComboTop_2 = new ComboBox<BaseModel>();
		tempComboTop_2.setForceSelection(true);
		tempComboTop_2.setMinChars(1);
		tempComboTop_2.setDisplayField("commCdNm");
		tempComboTop_2.setValueField("commCd");
		tempComboTop_2.setTriggerAction(TriggerAction.ALL);
		tempComboTop_2.setEmptyText("--연장사유선택--");
		tempComboTop_2.setSelectOnFocus(true);
		tempComboTop_2.setStore(stdExtnnReasCdStore);
		tempComboTop_2.setLabelSeparator("");
		lyoutTop_02_1_3_2.add(tempComboTop_2, new FormData("100%"));
		
		LayoutContainer lyoutTop_02_1_3_3 = new LayoutContainer();
		lyoutTop_02_1_3_3.setBorders(true);
		
		FormLayout formLayoutTop_02_1_3_3 = new FormLayout();
		formLayoutTop_02_1_3_3.setLabelWidth(0);
		lyoutTop_02_1_3_3.setLayout(formLayoutTop_02_1_3_3);
		
		tempComboTop_3 = new ComboBox<BaseModel>();
		tempComboTop_3.setForceSelection(true);
		tempComboTop_3.setMinChars(1);
		tempComboTop_3.setDisplayField("commCdNm");
		tempComboTop_3.setValueField("commCd");
		tempComboTop_3.setTriggerAction(TriggerAction.ALL);
		tempComboTop_3.setEmptyText("--연장사유선택--");
		tempComboTop_3.setSelectOnFocus(true);
		tempComboTop_3.setStore(stdExtnnReasCdStore);
		tempComboTop_3.setLabelSeparator("");
		lyoutTop_02_1_3_3.add(tempComboTop_3, new FormData("100%"));
		
		
		lyoutTop_02_1_3.add(lyoutTop_02_1_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lyoutTop_02_1_3.add(lyoutTop_02_1_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lyoutTop_02_1_3.add(lyoutTop_02_1_3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		lyoutTop_02_01.add(lyoutTop_02_1_3);
		
		
		lyoutTop_02_1.add(lyoutTop_02_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		lyoutTop_02_1.add(lyoutTop_02_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		
		
		lyoutTop_02.add(lyoutTop_02_1, new FormData("100%"));
		
		
		LayoutContainer lyoutTop_02_2 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_2.setBorders(false);
		
		
		final LayoutContainer lyoutTop_02_2_1 = new LayoutContainer();
		lyoutTop_02_2_1.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutTop_02_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutTop_02_2_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutTop_02_2_1.setStyleName("x-border-u-bottom",true);
	    		lyoutTop_02_2_1.setHeight("25px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    LabelField labelfldTop_02_2_1= new LabelField("기간");
	   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
	  //  lblfldNewLabelfield_12.setHeight(24);
	    labelfldTop_02_2_1.setStyleAttribute("padding-top", "5px");
	    labelfldTop_02_2_1.setStyleAttribute( "text-align", "center");
	    labelfldTop_02_2_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    lyoutTop_02_2_1.add(labelfldTop_02_2_1, new FormData("100%"));
	   // lblfldNewLabelfield_12.setHeight("20");
	    
	    LayoutContainer lyoutTop__02_2_2 = new LayoutContainer(new ColumnLayout());
	    lyoutTop__02_2_2.setBorders(false);
	    
	    
		LayoutContainer lyoutTop_02_2_2 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_2_2.setBorders(false);
		
		LayoutContainer lyoutTop_02_2_2_1 = new LayoutContainer();
		lyoutTop_02_2_2_1.setBorders(false);
		FormLayout frmlytStdTop_02_2_2_1 = new FormLayout();
		frmlytStdTop_02_2_2_1.setLabelWidth(0);
		lyoutTop_02_2_2_1.setLayout(frmlytStdTop_02_2_2_1);
		
		tempTopDate_1_S = new DateField();
		new DateFieldMask(tempTopDate_1_S, "9999.99.99");
		tempTopDate_1_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempTopDate_1_S.setLabelSeparator("");
		lyoutTop_02_2_2_1.add(tempTopDate_1_S, new FormData("100%"));
		lyoutTop_02_2_2.add(lyoutTop_02_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		
		LayoutContainer lyoutTop_02_2_2_2 = new LayoutContainer();
		lyoutTop_02_2_2_2.setBorders(false);
		FormLayout frmlytStdTop_02_2_2_2 = new FormLayout();
		frmlytStdTop_02_2_2_2.setLabelWidth(10);
		frmlytStdTop_02_2_2_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutTop_02_2_2_2.setLayout(frmlytStdTop_02_2_2_2);
		
		tempTopDate_1_E = new DateField();
		new DateFieldMask(tempTopDate_1_E, "9999.99.99");
		tempTopDate_1_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempTopDate_1_E.setLabelSeparator("~");
		lyoutTop_02_2_2_2.add(tempTopDate_1_E, new FormData("100%"));
		lyoutTop_02_2_2.add(lyoutTop_02_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		

		
		LayoutContainer lyoutTop_02_2_3 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_2_3.setBorders(false);
		
		LayoutContainer lyoutTop_02_2_3_1 = new LayoutContainer();
		lyoutTop_02_2_3_1.setBorders(false);
		FormLayout frmlytStdTop_02_2_3_1 = new FormLayout();
		frmlytStdTop_02_2_3_1.setLabelWidth(0);
		lyoutTop_02_2_3_1.setLayout(frmlytStdTop_02_2_3_1);
		
		tempTopDate_2_S = new DateField();
		new DateFieldMask(tempTopDate_2_S, "9999.99.99");
		tempTopDate_2_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempTopDate_2_S.setLabelSeparator("");
		lyoutTop_02_2_3_1.add(tempTopDate_2_S, new FormData("100%"));
		lyoutTop_02_2_3.add(lyoutTop_02_2_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		
		LayoutContainer lyoutTop_02_2_3_2 = new LayoutContainer();
		lyoutTop_02_2_3_2.setBorders(false);
		FormLayout frmlytStdTop_02_2_3_2 = new FormLayout();
		frmlytStdTop_02_2_3_2.setLabelWidth(10);
		frmlytStdTop_02_2_3_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutTop_02_2_3_2.setLayout(frmlytStdTop_02_2_3_2);
		
		tempTopDate_2_E = new DateField();
		new DateFieldMask(tempTopDate_2_E, "9999.99.99");
		tempTopDate_2_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempTopDate_2_E.setLabelSeparator("~");
		lyoutTop_02_2_3_2.add(tempTopDate_2_E, new FormData("100%"));
		lyoutTop_02_2_3.add(lyoutTop_02_2_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		
		
		LayoutContainer lyoutTop_02_2_4 = new LayoutContainer(new ColumnLayout());
		lyoutTop_02_2_4.setBorders(false);
		
		LayoutContainer lyoutTop_02_2_4_1 = new LayoutContainer();
		lyoutTop_02_2_4_1.setBorders(false);
		FormLayout frmlytStdTop_02_2_4_1 = new FormLayout();
		frmlytStdTop_02_2_4_1.setLabelWidth(0);
		lyoutTop_02_2_4_1.setLayout(frmlytStdTop_02_2_4_1);
		
		tempTopDate_3_S = new DateField();
		new DateFieldMask(tempTopDate_3_S, "9999.99.99");
		tempTopDate_3_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempTopDate_3_S.setLabelSeparator("");
		lyoutTop_02_2_4_1.add(tempTopDate_3_S, new FormData("100%"));
		lyoutTop_02_2_4.add(lyoutTop_02_2_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		
		LayoutContainer lyoutTop_02_2_4_2 = new LayoutContainer();
		lyoutTop_02_2_4_2.setBorders(false);
		FormLayout frmlytStdTop_02_2_4_2 = new FormLayout();
		frmlytStdTop_02_2_4_2.setLabelWidth(10);
		frmlytStdTop_02_2_4_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutTop_02_2_4_2.setLayout(frmlytStdTop_02_2_4_2);
		
		tempTopDate_3_E = new DateField();
		new DateFieldMask(tempTopDate_3_E, "9999.99.99");
		tempTopDate_3_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempTopDate_3_E.setLabelSeparator("~");
		lyoutTop_02_2_4_2.add(tempTopDate_3_E, new FormData("100%"));
		lyoutTop_02_2_4.add(lyoutTop_02_2_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		
		
		lyoutTop__02_2_2.add(lyoutTop_02_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lyoutTop__02_2_2.add(lyoutTop_02_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lyoutTop__02_2_2.add(lyoutTop_02_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		
		
		
		lyoutTop_02_2.add(lyoutTop_02_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		lyoutTop_02_2.add(lyoutTop__02_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		lyoutTop_02.add(lyoutTop_02_2, new FormData("100%"));
		
		
		lyoutTop.add(lyoutTop_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));
		fieldSet.add(lyoutTop);
		
		
		LayoutContainer lyoutMid = new LayoutContainer();
		lyoutMid.setBorders(false);
		
		LayoutContainer lyoutMid_01 = new LayoutContainer(new ColumnLayout());
		lyoutMid_01.setBorders(false);
		
		final LayoutContainer lyoutMid_01_1 = new LayoutContainer();
		lyoutMid_01_1.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutMid_01_1.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_01_1.setHeight("73px");  
	    	}
	    });
		    /**********************************************************************************************************
          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	         ***********************************************************************************************************/
	    LabelField labelfldMid_01_1= new LabelField("임금계산기간");
	   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
	  //  lblfldNewLabelfield_12.setHeight(24);
	    labelfldMid_01_1.setStyleAttribute("padding-top", "35px");
	    labelfldMid_01_1.setStyleAttribute( "text-align", "center");
	    labelfldMid_01_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    lyoutMid_01_1.add(labelfldMid_01_1, new FormData("100%"));
	   // lblfldNewLabelfield_12.setHeight("20");
		
		
		final LayoutContainer lyoutMid_01_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_01_2.setBorders(true);

	    
	    
//		LayoutContainer lyoutMid_01_2_1 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_1.setBorders(false);
//		
//		LayoutContainer lyoutMid_01_2_1_1 = new LayoutContainer();
//		lyoutMid_01_2_1_1.setBorders(true);
//		
//		Button button2 = new Button("임금초기화");
//		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//			}
//		});
//		lyoutMid_01_2_1_1.add(button2); 
//		lyoutMid_01_2_1.add(lyoutMid_01_2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		LayoutContainer lyoutMid_01_2_1_2 = new LayoutContainer();
//		lyoutMid_01_2_1_2.setBorders(true);
//		
//		button2 = new Button("임금초기화");
//		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//			}
//		});
//		lyoutMid_01_2_1_2.add(button2); 
//		lyoutMid_01_2_1.add(lyoutMid_01_2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		LayoutContainer lyoutMid_01_2_1_3 = new LayoutContainer();
//		lyoutMid_01_2_1_3.setBorders(true);
//		
//		button2 = new Button("임금초기화");
//		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//			}
//		});
//		lyoutMid_01_2_1_3.add(button2); 
//		lyoutMid_01_2_1.add(lyoutMid_01_2_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		LayoutContainer lyoutMid_01_2_1_4 = new LayoutContainer();
//		lyoutMid_01_2_1_4.setBorders(true);
//		
//		button2 = new Button("임금초기화");
//		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//			}
//		});
//		lyoutMid_01_2_1_4.add(button2); 
//		lyoutMid_01_2_1.add(lyoutMid_01_2_1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		lyoutMid_01_2.add(lyoutMid_01_2_1, new FormData("100%"));
//		
//		//--
//		LayoutContainer lyoutMid_01_2_2 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_2.setBorders(false);
//		
//			// -- 1
//		LayoutContainer lyoutMid_01_2_2_1 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_2_1.setBorders(false);
//		
//		LayoutContainer lyoutMid_01_2_2_1_1 = new LayoutContainer();
//		lyoutMid_01_2_2_1_1.setBorders(false);
//		
//		FormLayout frmlytMid_01_2_2_1_1 = new FormLayout();
//		frmlytMid_01_2_2_1_1.setLabelWidth(0);
//		lyoutMid_01_2_2_1_1.setLayout(frmlytMid_01_2_2_1_1);
//		
//		
//		tempMidDate_1_S = new DateField();
//		new DateFieldMask(tempMidDate_1_S, "9999.99.99");
//		tempMidDate_1_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		tempMidDate_1_S.setLabelSeparator("");
//		lyoutMid_01_2_2_1_1.add(tempMidDate_1_S, new FormData("100%"));
//		lyoutMid_01_2_2_1.add(lyoutMid_01_2_2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
//		
//		
//		LayoutContainer lyoutMid_01_2_2_1_2 = new LayoutContainer();
//		lyoutMid_01_2_2_1_2.setBorders(false);
//		
//		
//		FormLayout frmlytdMid_01_2_2_1_2 = new FormLayout();
//		frmlytdMid_01_2_2_1_2.setLabelWidth(0);
//		frmlytdMid_01_2_2_1_2.setLabelAlign(LabelAlign.RIGHT);
//		lyoutMid_01_2_2_1_2.setLayout(frmlytdMid_01_2_2_1_2);
//		
//		LabelField labelMid_01_2_2_1_2= new LabelField("~");
//		labelMid_01_2_2_1_2.setStyleAttribute("padding-top", "5px");
//		lyoutMid_01_2_2_1_2.add(labelMid_01_2_2_1_2);
//		lyoutMid_01_2_2_1.add(lyoutMid_01_2_2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		lyoutMid_01_2_2.add(lyoutMid_01_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//	
//		LayoutContainer lyoutMid_01_2_2_2 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_2_2.setBorders(false);
//		
//		LayoutContainer lyoutMid_01_2_2_2_1 = new LayoutContainer();
//		lyoutMid_01_2_2_2_1.setBorders(false);
//		
//		FormLayout frmlytMid_01_2_2_2_1 = new FormLayout();
//		frmlytMid_01_2_2_2_1.setLabelWidth(0);
//		lyoutMid_01_2_2_2_1.setLayout(frmlytMid_01_2_2_2_1);
//		
//		
//		tempMidDate_2_S = new DateField();
//		new DateFieldMask(tempMidDate_2_S, "9999.99.99");
//		tempMidDate_2_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		tempMidDate_2_S.setLabelSeparator("");
//		lyoutMid_01_2_2_2_1.add(tempMidDate_2_S, new FormData("100%"));
//		lyoutMid_01_2_2_2.add(lyoutMid_01_2_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
//		
//		
//		LayoutContainer lyoutMid_01_2_2_2_2 = new LayoutContainer();
//		lyoutMid_01_2_2_2_2.setBorders(false);
//		
//		
//		FormLayout frmlytdMid_01_2_2_2_2 = new FormLayout();
//		frmlytdMid_01_2_2_2_2.setLabelWidth(0);
//		frmlytdMid_01_2_2_2_2.setLabelAlign(LabelAlign.RIGHT);
//		lyoutMid_01_2_2_2_2.setLayout(frmlytdMid_01_2_2_2_2);
//		
//		LabelField labelMid_01_2_2_2_2= new LabelField("~");
//		labelMid_01_2_2_2_2.setStyleAttribute("padding-top", "5px");
//		lyoutMid_01_2_2_2_2.add(labelMid_01_2_2_2_2);
//		lyoutMid_01_2_2_2.add(lyoutMid_01_2_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		lyoutMid_01_2_2.add(lyoutMid_01_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		
//		
//		LayoutContainer lyoutMid_01_2_2_3 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_2_3.setBorders(false);
//		
//		LayoutContainer lyoutMid_01_2_2_3_1 = new LayoutContainer();
//		lyoutMid_01_2_2_3_1.setBorders(false);
//		
//		FormLayout frmlytMid_01_2_2_3_1 = new FormLayout();
//		frmlytMid_01_2_2_3_1.setLabelWidth(0);
//		lyoutMid_01_2_2_3_1.setLayout(frmlytMid_01_2_2_3_1);
//		
//		
//		tempMidDate_3_S = new DateField();
//		new DateFieldMask(tempMidDate_3_S, "9999.99.99");
//		tempMidDate_3_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		tempMidDate_3_S.setLabelSeparator("");
//		lyoutMid_01_2_2_3_1.add(tempMidDate_3_S, new FormData("100%"));
//		lyoutMid_01_2_2_3.add(lyoutMid_01_2_2_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
//		
//		
//		LayoutContainer lyoutMid_01_2_2_3_2 = new LayoutContainer();
//		lyoutMid_01_2_2_3_2.setBorders(false);
//		
//		
//		FormLayout frmlytdMid_01_2_2_3_2 = new FormLayout();
//		frmlytdMid_01_2_2_3_2.setLabelWidth(0);
//		frmlytdMid_01_2_2_3_2.setLabelAlign(LabelAlign.RIGHT);
//		lyoutMid_01_2_2_3_2.setLayout(frmlytdMid_01_2_2_3_2);
//		
//		LabelField labelMid_01_2_2_3_2= new LabelField("~");
//		labelMid_01_2_2_3_2.setStyleAttribute("padding-top", "5px");
//		lyoutMid_01_2_2_3_2.add(labelMid_01_2_2_3_2);
//		lyoutMid_01_2_2_3.add(lyoutMid_01_2_2_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		lyoutMid_01_2_2.add(lyoutMid_01_2_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		
//		
//		LayoutContainer lyoutMid_01_2_2_4 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_2_4.setBorders(false);
//		
//		LayoutContainer lyoutMid_01_2_2_4_1 = new LayoutContainer();
//		lyoutMid_01_2_2_4_1.setBorders(false);
//		
//		FormLayout frmlytMid_01_2_2_4_1 = new FormLayout();
//		frmlytMid_01_2_2_4_1.setLabelWidth(0);
//		lyoutMid_01_2_2_4_1.setLayout(frmlytMid_01_2_2_4_1);
//		
//		
//		tempMidDate_4_S = new DateField();
//		new DateFieldMask(tempMidDate_4_S, "9999.99.99");
//		tempMidDate_4_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		tempMidDate_4_S.setLabelSeparator("");
//		lyoutMid_01_2_2_4_1.add(tempMidDate_4_S, new FormData("100%"));
//		lyoutMid_01_2_2_4.add(lyoutMid_01_2_2_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
//		
//		
//		LayoutContainer lyoutMid_01_2_2_4_2 = new LayoutContainer();
//		lyoutMid_01_2_2_4_2.setBorders(false);
//		
//		
//		FormLayout frmlytdMid_01_2_2_4_2 = new FormLayout();
//		frmlytdMid_01_2_2_4_2.setLabelWidth(0);
//		lyoutMid_01_2_2_4_2.setLayout(frmlytdMid_01_2_2_4_2);
//		
//		LabelField labelMid_01_2_2_4_2= new LabelField("~");
//		labelMid_01_2_2_4_2.setStyleAttribute("padding-top", "5px");
//		lyoutMid_01_2_2_4_2.add(labelMid_01_2_2_4_2);
//		lyoutMid_01_2_2_4.add(lyoutMid_01_2_2_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		lyoutMid_01_2_2.add(lyoutMid_01_2_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		
//		
//		
//		lyoutMid_01_2.add(lyoutMid_01_2_2, new FormData("100%"));
//		
//		
//		
//		
//		
//		//--
//		LayoutContainer lyoutMid_01_2_3 = new LayoutContainer(new ColumnLayout());
//		lyoutMid_01_2_3.setBorders(false);
//		
//		lyoutMid_01_2.add(lyoutMid_01_2_3, new FormData("100%"));
		
		
		
		
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
		final LayoutContainer lyoutMid_01_2_1 = new LayoutContainer();
		lyoutMid_01_2_1.setBorders(false);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_2_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_01_2_1.setStyleName("x-border-u-bottom",true);
//	    		lyoutMid_01_2_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
//		FormLayout frmlytStdMid_01_2_1 = new FormLayout();
//		frmlytStdMid_01_2_1.setLabelWidth(0);
//		lyoutMid_01_2_1.setLayout(frmlytStdMid_01_2_1);
		
		LayoutContainer lyoutMid_01_2_1_1 = new LayoutContainer();
		lyoutMid_01_2_1_1.setBorders(false);
		Button button2 = new Button("임금초기화");
		lyoutMid_01_2_1_1.add(button2); 
		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempNumFle_1.setValue(0L);
				tempNumFle_5.setValue(0L);
			}
		});
		lyoutMid_01_2_1.add(lyoutMid_01_2_1_1, new FormData("100%"));
		
		LayoutContainer lyoutMid_01_2_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_01_2_1_2.setBorders(false);
		
		LayoutContainer lyoutMid_01_2_1_2_1 = new LayoutContainer();
		lyoutMid_01_2_1_2_1.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_1_2_1 = new FormLayout();
		frmlytStdMid_01_2_1_2_1.setLabelWidth(0);
		frmlytStdMid_01_2_1_2_1.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_1_2_1.setLayout(frmlytStdMid_01_2_1_2_1);
		
		tempMidDate_1_S = new DateField();
		new DateFieldMask(tempMidDate_1_S, "9999.99.99");
		tempMidDate_1_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_1_S.setLabelSeparator("");
		
		tempMidDate_1_S.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   tempMidDate_1_E.setValue(null);
	        	   tempNumDaysFle_1.setValue(0L);
	           }
	       });
		
		lyoutMid_01_2_1_2_1.add(tempMidDate_1_S, new FormData("100%"));
		lyoutMid_01_2_1_2.add(lyoutMid_01_2_1_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		
		LayoutContainer lyoutMid_01_2_1_2_2 = new LayoutContainer();
		lyoutMid_01_2_1_2_2.setBorders(false);
		FormLayout frmlytStdMid_01_2_1_2_2 = new FormLayout();
		frmlytStdMid_01_2_1_2_2.setLabelWidth(0);
		frmlytStdMid_01_2_1_2_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_1_2_2.setLayout(frmlytStdMid_01_2_1_2_2);
		
		LabelField labelMid_01_2_1_2_2= new LabelField("~");
		labelMid_01_2_1_2_2.setStyleAttribute("padding-top", "5px");
		lyoutMid_01_2_1_2_2.add(labelMid_01_2_1_2_2);
		lyoutMid_01_2_1_2.add(lyoutMid_01_2_1_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		lyoutMid_01_2_1.add(lyoutMid_01_2_1_2, new FormData("100%"));
		
		LayoutContainer lyoutMid_01_2_1_3 = new LayoutContainer();
		lyoutMid_01_2_1_3.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_1_3 = new FormLayout();
		frmlytStdMid_01_2_1_3.setLabelWidth(10);
		frmlytStdMid_01_2_1_3.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_1_3.setLayout(frmlytStdMid_01_2_1_3);
		
		tempMidDate_1_E = new DateField();
		new DateFieldMask(tempMidDate_1_E, "9999.99.99");
		tempMidDate_1_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_1_E.setLabelSeparator("");
		lyoutMid_01_2_1_3.add(tempMidDate_1_E, new FormData("100%"));
		lyoutMid_01_2_1.add(lyoutMid_01_2_1_3, new FormData("100%"));
		lyoutMid_01_2.add(lyoutMid_01_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		tempMidDate_1_E.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   if(InsrUtils.getConvertDateToString(tempMidDate_1_S, "yyyyMMdd") == null || InsrUtils.getConvertDateToString(tempMidDate_1_S, "yyyyMMdd").equals("")){
	        		   Window.alert("기준연장기간 시작일을 입력하세요.");
	        	   }else{
	        		   setTempNumDaysFle_1();
	        	   }
	           }
	       });
		final LayoutContainer lyoutMid_01_2_2 = new LayoutContainer();
		lyoutMid_01_2_2.setBorders(false);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_2_2.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_01_2_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
//		FormLayout frmlytStdMid_01_2_2 = new FormLayout();
//		frmlytStdMid_01_2_2.setLabelWidth(0);
//		lyoutMid_01_2_2.setLayout(frmlytStdMid_01_2_2);
		
		LayoutContainer lyoutMid_01_2_2_1 = new LayoutContainer();
		lyoutMid_01_2_2_1.setBorders(false);
		button2 = new Button("임금초기화");
		lyoutMid_01_2_2_1.add(button2); 
		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempNumFle_2.setValue(0L);
				tempNumFle_6.setValue(0L);
			}
		});
		lyoutMid_01_2_2.add(lyoutMid_01_2_2_1, new FormData("100%"));
		
		LayoutContainer lyoutMid_01_2_2_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_01_2_2_2.setBorders(false);
		
		LayoutContainer lyoutMid_01_2_2_2_1 = new LayoutContainer();
		lyoutMid_01_2_2_2_1.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_2_2_1 = new FormLayout();
		frmlytStdMid_01_2_2_2_1.setLabelWidth(0);
		frmlytStdMid_01_2_2_2_1.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_2_2_1.setLayout(frmlytStdMid_01_2_2_2_1);
		
		tempMidDate_2_S = new DateField();
		new DateFieldMask(tempMidDate_2_S, "9999.99.99");
		tempMidDate_2_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_2_S.setLabelSeparator("");
		
		tempMidDate_2_S.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   tempMidDate_2_E.setValue(null);
	        	   tempNumDaysFle_2.setValue(0L);
	           }
	       });
		
		lyoutMid_01_2_2_2_1.add(tempMidDate_2_S, new FormData("100%"));
		lyoutMid_01_2_2_2.add(lyoutMid_01_2_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		
		LayoutContainer lyoutMid_01_2_2_2_2 = new LayoutContainer();
		lyoutMid_01_2_2_2_2.setBorders(false);
		FormLayout frmlytStdMid_01_2_2_2_2 = new FormLayout();
		frmlytStdMid_01_2_2_2_2.setLabelWidth(0);
		frmlytStdMid_01_2_2_2_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_2_2_2.setLayout(frmlytStdMid_01_2_2_2_2);
		
		LabelField labelMid_01_2_2_2_2= new LabelField("~");
		labelMid_01_2_2_2_2.setStyleAttribute("padding-top", "5px");
		lyoutMid_01_2_2_2_2.add(labelMid_01_2_2_2_2, new FormData("100%"));
		lyoutMid_01_2_2_2.add(lyoutMid_01_2_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		lyoutMid_01_2_2.add(lyoutMid_01_2_2_2, new FormData("100%"));		
		
		LayoutContainer lyoutMid_01_2_2_3 = new LayoutContainer();
		lyoutMid_01_2_2_3.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_2_3 = new FormLayout();
		frmlytStdMid_01_2_2_3.setLabelWidth(10);
		frmlytStdMid_01_2_2_3.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_2_3.setLayout(frmlytStdMid_01_2_2_3);
		
		tempMidDate_2_E = new DateField();
		new DateFieldMask(tempMidDate_2_E, "9999.99.99");
		tempMidDate_2_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_2_E.setLabelSeparator("");
		lyoutMid_01_2_2_3.add(tempMidDate_2_E, new FormData("100%"));
		lyoutMid_01_2_2.add(lyoutMid_01_2_2_3, new FormData("100%"));
		lyoutMid_01_2.add(lyoutMid_01_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		tempMidDate_2_E.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   if(InsrUtils.getConvertDateToString(tempMidDate_2_S, "yyyyMMdd") == null || InsrUtils.getConvertDateToString(tempMidDate_2_S, "yyyyMMdd").equals("")){
	        		   Window.alert("기준연장기간 시작일을 입력하세요.");
	        	   }else{
	        		   setTempNumDaysFle_2();
	        	   }
	           }
	       });
		final LayoutContainer lyoutMid_01_2_3 = new LayoutContainer();
		lyoutMid_01_2_3.setBorders(false);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_2_3.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_01_2_3.setStyleName("x-border-u-bottom",true);
//	    		lyoutMid_01_2_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
//		FormLayout frmlytStdMid_01_2_3 = new FormLayout();
//		frmlytStdMid_01_2_3.setLabelWidth(0);
//		lyoutMid_01_2_3.setLayout(frmlytStdMid_01_2_3);
		
		LayoutContainer lyoutMid_01_2_3_1 = new LayoutContainer();
		lyoutMid_01_2_3_1.setBorders(false);
		button2 = new Button("임금초기화");
		lyoutMid_01_2_3_1.add(button2); 
		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempNumFle_3.setValue(0L);
				tempNumFle_7.setValue(0L);
			}
		});
		lyoutMid_01_2_3.add(lyoutMid_01_2_3_1, new FormData("100%"));
		
		LayoutContainer lyoutMid_01_2_3_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_01_2_3_2.setBorders(false);
		
		LayoutContainer lyoutMid_01_2_3_2_1 = new LayoutContainer();
		lyoutMid_01_2_3_2_1.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_3_2_1 = new FormLayout();
		frmlytStdMid_01_2_3_2_1.setLabelWidth(0);
		frmlytStdMid_01_2_3_2_1.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_3_2_1.setLayout(frmlytStdMid_01_2_3_2_1);
		
		tempMidDate_3_S = new DateField();
		new DateFieldMask(tempMidDate_3_S, "9999.99.99");
		tempMidDate_3_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_3_S.setLabelSeparator("");
		
		tempMidDate_3_S.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   tempMidDate_3_E.setValue(null);
	        	   tempNumDaysFle_3.setValue(0L);
	           }
	       });
		
		lyoutMid_01_2_3_2_1.add(tempMidDate_3_S, new FormData("100%"));
		lyoutMid_01_2_3_2.add(lyoutMid_01_2_3_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		
		LayoutContainer llyoutMid_01_2_3_2_2 = new LayoutContainer();
		llyoutMid_01_2_3_2_2.setBorders(false);
		FormLayout frmlytStdMid_01_2_2_3_2 = new FormLayout();
		frmlytStdMid_01_2_2_3_2.setLabelWidth(0);
		frmlytStdMid_01_2_2_3_2.setLabelAlign(LabelAlign.RIGHT);
		llyoutMid_01_2_3_2_2.setLayout(frmlytStdMid_01_2_2_3_2);
		
		LabelField labelMid_01_2_2_3_2= new LabelField("~");
		labelMid_01_2_2_3_2.setStyleAttribute("padding-top", "5px");
		llyoutMid_01_2_3_2_2.add(labelMid_01_2_2_3_2, new FormData("100%"));
		lyoutMid_01_2_3_2.add(llyoutMid_01_2_3_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		lyoutMid_01_2_3.add(lyoutMid_01_2_3_2, new FormData("100%"));		
		
		final LayoutContainer lyoutMid_01_2_3_3 = new LayoutContainer();
		lyoutMid_01_2_3_3.setBorders(false);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_2_3_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_2_3_3.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_01_2_3_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		FormLayout frmlytStdMid_01_2_3_3 = new FormLayout();
		frmlytStdMid_01_2_3_3.setLabelWidth(10);
		lyoutMid_01_2_3_3.setLayout(frmlytStdMid_01_2_3_3);
		
		tempMidDate_3_E = new DateField();
		new DateFieldMask(tempMidDate_3_E, "9999.99.99");
		tempMidDate_3_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_3_E.setLabelSeparator("");
		lyoutMid_01_2_3_3.add(tempMidDate_3_E, new FormData("100%"));
		lyoutMid_01_2_3.add(lyoutMid_01_2_3_3, new FormData("100%"));
		lyoutMid_01_2.add(lyoutMid_01_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		tempMidDate_3_E.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   if(InsrUtils.getConvertDateToString(tempMidDate_3_S, "yyyyMMdd") == null || InsrUtils.getConvertDateToString(tempMidDate_3_S, "yyyyMMdd").equals("")){
	        		   Window.alert("기준연장기간 시작일을 입력하세요.");
	        	   }else{
	        		   setTempNumDaysFle_3();
	        	   }
	           }
	       });
		final LayoutContainer lyoutMid_01_2_4 = new LayoutContainer();
		lyoutMid_01_2_4.setBorders(false);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_2_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_2_4.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_01_2_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
//		FormLayout frmlytStdMid_01_2_4 = new FormLayout();
//		frmlytStdMid_01_2_4.setLabelWidth(0);
//		lyoutMid_01_2_4.setLayout(frmlytStdMid_01_2_4);
		
		LayoutContainer lyoutMid_01_2_4_1 = new LayoutContainer();
		lyoutMid_01_2_4_1.setBorders(false);
		button2 = new Button("임금초기화");
		lyoutMid_01_2_4_1.add(button2); 
		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				tempNumFle_4.setValue(0L);
				tempNumFle_8.setValue(0L);
			}
		});
		lyoutMid_01_2_4.add(lyoutMid_01_2_4_1, new FormData("100%"));
		
		LayoutContainer lyoutMid_01_2_4_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_01_2_4_2.setBorders(false);
		
		LayoutContainer lyoutMid_01_2_4_2_1 = new LayoutContainer();
		lyoutMid_01_2_4_2_1.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_4_2_1 = new FormLayout();
		frmlytStdMid_01_2_4_2_1.setLabelWidth(0);
		frmlytStdMid_01_2_4_2_1.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_4_2_1.setLayout(frmlytStdMid_01_2_4_2_1);
		
		tempMidDate_4_S = new DateField();
		new DateFieldMask(tempMidDate_4_S, "9999.99.99");
		tempMidDate_4_S.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_4_S.setLabelSeparator("");
		
		tempMidDate_4_S.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   tempMidDate_4_E.setValue(null);
	        	   tempNumDaysFle_4.setValue(0L);
	           }
	       });
		
		lyoutMid_01_2_4_2_1.add(tempMidDate_4_S, new FormData("100%"));
		lyoutMid_01_2_4_2.add(lyoutMid_01_2_4_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		
		LayoutContainer llyoutMid_01_2_4_2_2 = new LayoutContainer();
		llyoutMid_01_2_4_2_2.setBorders(false);
		FormLayout frmlytStdMid_01_2_4_2_2 = new FormLayout();
		frmlytStdMid_01_2_4_2_2.setLabelWidth(0);
		frmlytStdMid_01_2_4_2_2.setLabelAlign(LabelAlign.RIGHT);
		llyoutMid_01_2_4_2_2.setLayout(frmlytStdMid_01_2_4_2_2);
		
		LabelField labelMid_01_2_2_4_2= new LabelField("~");
		labelMid_01_2_2_4_2.setStyleAttribute("padding-top", "5px");
		llyoutMid_01_2_4_2_2.add(labelMid_01_2_2_4_2, new FormData("100%"));
		lyoutMid_01_2_4_2.add(llyoutMid_01_2_4_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		lyoutMid_01_2_4.add(lyoutMid_01_2_4_2, new FormData("100%"));		
		
		LayoutContainer lyoutMid_01_2_3_4 = new LayoutContainer();
		lyoutMid_01_2_3_4.setBorders(false);
		
		FormLayout frmlytStdMid_01_2_3_4 = new FormLayout();
		frmlytStdMid_01_2_3_4.setLabelWidth(10);
		frmlytStdMid_01_2_3_4.setLabelAlign(LabelAlign.RIGHT);
		lyoutMid_01_2_3_4.setLayout(frmlytStdMid_01_2_3_4);
		
		tempMidDate_4_E = new DateField();
		new DateFieldMask(tempMidDate_4_E, "9999.99.99");
		tempMidDate_4_E.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tempMidDate_4_E.setLabelSeparator("");
		lyoutMid_01_2_3_4.add(tempMidDate_4_E, new FormData("100%"));
		lyoutMid_01_2_4.add(lyoutMid_01_2_3_4, new FormData("100%"));
		//--
		lyoutMid_01_2.add(lyoutMid_01_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//>>>>>>>>>>>>>>>>>
		tempMidDate_4_E.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	        	   if(InsrUtils.getConvertDateToString(tempMidDate_4_S, "yyyyMMdd") == null || InsrUtils.getConvertDateToString(tempMidDate_4_S, "yyyyMMdd").equals("")){
	        		   Window.alert("기준연장기간 시작일을 입력하세요.");
	        	   }else{
	        		   setTempNumDaysFle_4();
	        	   }
	           }
	       });
		
		
		final LayoutContainer lyoutMid_01_3 = new LayoutContainer();
		lyoutMid_01_3.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_01_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_01_3.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_01_3.setStyleAttribute("background-color", "#dfe8f6"); 
	    		lyoutMid_01_3.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_01_3.setHeight("73px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		
		
//		final LayoutContainer lyoutMid_01_3_1  = new LayoutContainer();
//		lyoutMid_01_3_1.setBorders(false);
//        /**********************************************************************************************************
//         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//         ***********************************************************************************************************/
//		lyoutMid_01_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
//	    	public void handleEvent(BaseEvent be) {
//	    		lyoutMid_01_3_1.removeStyleName("x-border");
//		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
//	    		lyoutMid_01_3_1.setStyleName("x-border-u-bottom",true);
//	    		lyoutMid_01_3_1.setHeight("50px");  
//	    	}
//	    });
//		    /**********************************************************************************************************
//          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//	         ***********************************************************************************************************/
	    LabelField labelfMid_01_3_1= new LabelField("계");
	   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
	  //  lblfldNewLabelfield_12.setHeight(24);
	    labelfMid_01_3_1.setStyleAttribute("padding-top", "5px");
	    labelfMid_01_3_1.setStyleAttribute( "text-align", "center");
	   // labelfMid_01_3_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    lyoutMid_01_3.add(labelfMid_01_3_1, new FormData("100%"));
		//lyoutMid_01_3.add(lyoutMid_01_3_1, new FormData("100%"));
		
		
		//LayoutContainer lyoutMid_01_3_2  = new LayoutContainer();
		//lyoutMid_01_3_2.setBorders(false);
		
		//FormLayout frmlytStdMid_01_3_2 = new FormLayout();
		//frmlytStdMid_01_3_2.setLabelWidth(0);
		//frmlytStdMid_01_3_2.setLabelAlign(LabelAlign.LEFT);
		//lyoutMid_01_3_2.setLayout(frmlytStdMid_01_3_2);
		
		tempNumDaysSumFle = new NumberField();
		tempNumDaysSumFle.setLabelSeparator("");
		tempNumDaysSumFle.setReadOnly(true);
		tempNumDaysSumFle.setAllowDecimals(true); 
		tempNumDaysSumFle.setPropertyEditorType(Long.class); 
		tempNumDaysSumFle.setFormat(NumberFormat.getDecimalFormat());
		//lyoutMid_01_3_2.add(tempNumDaysSumFle, new FormData("100%"));
		//lyoutMid_01_3.add(lyoutMid_01_3_2, new FormData("100%"));
		
		

	   // lblfldNewLabelfield_12.setHeight("20");
		
		lyoutMid_01.add(lyoutMid_01_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.145));
		lyoutMid_01.add(lyoutMid_01_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.735));
		lyoutMid_01.add(lyoutMid_01_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		lyoutMid.add(lyoutMid_01, new FormData("100%"));
		
		
		LayoutContainer lyoutMid_02 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02.setBorders(false);
		
		
		final LayoutContainer lyoutMid_02_1 = new LayoutContainer();
		lyoutMid_02_1.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutMid_02_1.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_1.setHeight("150px");  
	    	}
	    });
		    /**********************************************************************************************************
          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	         ***********************************************************************************************************/
	    LabelField labelMid_02_1= new LabelField("임금내역");
	   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
	  //  lblfldNewLabelfield_12.setHeight(24);
	    labelMid_02_1.setStyleAttribute("padding-top", "30px");
	    labelMid_02_1.setStyleAttribute( "text-align", "center");
	    labelMid_02_1.setStyleAttribute("background-color", "#dfe8f6"); 
	    lyoutMid_02_1.add(labelMid_02_1, new FormData("100%"));
		lyoutMid_02.add(lyoutMid_02_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.025));
		
		
		
		LayoutContainer lyoutMid_02_2 = new LayoutContainer();
		lyoutMid_02_2.setBorders(false);
		
		final LayoutContainer lyoutMid_02_2_1 = new LayoutContainer();
		lyoutMid_02_2_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_1.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_2_1.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		lyoutMid_02_2_1.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_1 = new LabelField("총보수");
		labelfld_02_2_1.setStyleAttribute("font-size", "10px");
		labelfld_02_2_1.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_1.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_1.setBorders(false);
		lyoutMid_02_2_1.add(labelfld_02_2_1, new FormData("100%"));
		lyoutMid_02_2.add(lyoutMid_02_2_1, new FormData("100%"));
		
		
		final LayoutContainer lyoutMid_02_2_2 = new LayoutContainer();
		lyoutMid_02_2_2.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_2.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_2.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_2_2.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		lyoutMid_02_2_2.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_2 = new LabelField("기본금");
		labelfld_02_2_2.setStyleAttribute("font-size", "10px");
		labelfld_02_2_2.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_2.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_2.setBorders(false);
		lyoutMid_02_2_2.add(labelfld_02_2_2, new FormData("100%"));
		lyoutMid_02_2.add(lyoutMid_02_2_2, new FormData("100%"));
		
		
		final LayoutContainer lyoutMid_02_2_3 = new LayoutContainer();
		lyoutMid_02_2_3.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_3.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_3.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_2_3.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		lyoutMid_02_2_3.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_3 = new LabelField("기타수당");
		labelfld_02_2_3.setStyleAttribute("font-size", "10px");
		labelfld_02_2_3.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_3.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_3.setBorders(false);
		lyoutMid_02_2_3.add(labelfld_02_2_3, new FormData("100%"));
		lyoutMid_02_2.add(lyoutMid_02_2_3, new FormData("100%"));
		
		
		final LayoutContainer lyoutMid_02_2_4 = new LayoutContainer();
		lyoutMid_02_2_4.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_4.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_4.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_2_4.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		lyoutMid_02_2_4.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_4 = new LabelField("상여금");
		labelfld_02_2_4.setStyleAttribute("font-size", "10px");
		labelfld_02_2_4.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_4.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_4.setBorders(false);
		lyoutMid_02_2_4.add(labelfld_02_2_4, new FormData("100%"));
		lyoutMid_02_2.add(lyoutMid_02_2_4, new FormData("100%"));
		
		
		final LayoutContainer lyoutMid_02_2_5 = new LayoutContainer();
		lyoutMid_02_2_5.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_5.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_5.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_2_5.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		lyoutMid_02_2_5.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_5 = new LabelField("연차수당");
		labelfld_02_2_5.setStyleAttribute("font-size", "10px");
		labelfld_02_2_5.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_5.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_5.setBorders(false);
		lyoutMid_02_2_5.add(labelfld_02_2_5, new FormData("100%"));
		lyoutMid_02_2.add(lyoutMid_02_2_5, new FormData("100%"));
		
		
		final LayoutContainer lyoutMid_02_2_6 = new LayoutContainer();
		lyoutMid_02_2_6.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_6.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_6.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_6.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_2_6.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		lyoutMid_02_2_6.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_6 = new LabelField("기타");
		labelfld_02_2_6.setStyleAttribute("font-size", "10px");
		labelfld_02_2_6.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_6.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_6.setBorders(false);
		lyoutMid_02_2_6.add(labelfld_02_2_6, new FormData("100%"));
		lyoutMid_02_2.add(lyoutMid_02_2_6, new FormData("100%"));
		
		
		lyoutMid_02.add(lyoutMid_02_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		
		
		final LayoutContainer lyoutMid_02_3 = new LayoutContainer();
		lyoutMid_02_3.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3.setHeight("150px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		
		// -- 1
		final LayoutContainer lyoutMid_02_3_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3_1.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3_1.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		
		//-- >
		LayoutContainer lyoutMid_02_3_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_1.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_1_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_1_1.setBorders(false);
		
		FormLayout frmlytMid_02_3_1_1_1 = new FormLayout();
		frmlytMid_02_3_1_1_1.setLabelWidth(0);
		lyoutMid_02_3_1_1_1.setLayout(frmlytMid_02_3_1_1_1);
		
		tempNumDaysFle_1 = new NumberField();
		tempNumDaysFle_1.setLabelSeparator("");
		tempNumDaysFle_1.setReadOnly(true);
		tempNumDaysFle_1.setAllowDecimals(true); 
		tempNumDaysFle_1.setPropertyEditorType(Long.class); 
		tempNumDaysFle_1.setFormat(NumberFormat.getDecimalFormat());
		tempNumDaysFle_1.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_1_1_1.add(tempNumDaysFle_1, new FormData("100%"));
		lyoutMid_02_3_1_1.add(lyoutMid_02_3_1_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		
		LayoutContainer lyoutMid_02_3_1_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_1_2.setBorders(false);
		
		LabelField labelfld02_3_1_1_2 = new LabelField("일");
		labelfld02_3_1_1_2.setStyleAttribute("padding-top", "5px");
		labelfld02_3_1_1_2.setStyleAttribute( "text-align", "center");
		labelfld02_3_1_1_2.setBorders(false);
		lyoutMid_02_3_1_1_2.add(labelfld02_3_1_1_2, new FormData("100%"));
		lyoutMid_02_3_1_1.add(lyoutMid_02_3_1_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		lyoutMid_02_3_1.add(lyoutMid_02_3_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		//-- >
		
		//-- >
		LayoutContainer lyoutMid_02_3_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_2.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_2_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_2_1.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_2_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_2_1_1.setBorders(false);
		
		FormLayout frmlytMid_02_3_2_1_1 = new FormLayout();
		frmlytMid_02_3_2_1_1.setLabelWidth(0);
		lyoutMid_02_3_2_1_1.setLayout(frmlytMid_02_3_2_1_1);
		
		tempNumDaysFle_2 = new NumberField();
		tempNumDaysFle_2.setLabelSeparator("");
		tempNumDaysFle_2.setReadOnly(true);
		tempNumDaysFle_2.setAllowDecimals(true); 
		tempNumDaysFle_2.setPropertyEditorType(Long.class); 
		tempNumDaysFle_2.setFormat(NumberFormat.getDecimalFormat());
		tempNumDaysFle_2.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_2_1_1.add(tempNumDaysFle_2, new FormData("100%"));
		lyoutMid_02_3_2_1.add(lyoutMid_02_3_2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		
		LayoutContainer lyoutMid_02_3_2_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_2_1_2.setBorders(false);
		
		LabelField labelfldMid_02_3_2_1_2 = new LabelField("일");
		labelfldMid_02_3_2_1_2.setStyleAttribute("padding-top", "5px");
		labelfldMid_02_3_2_1_2.setStyleAttribute( "text-align", "center");
		labelfldMid_02_3_2_1_2.setBorders(false);
		lyoutMid_02_3_2_1_2.add(labelfldMid_02_3_2_1_2, new FormData("100%"));
		lyoutMid_02_3_2_1.add(lyoutMid_02_3_2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		lyoutMid_02_3_1.add(lyoutMid_02_3_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		//-- >
		
		//-- >
		LayoutContainer lyoutMid_02_3_1_3 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_3.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_3_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_3_1.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_3_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_3_1_1.setBorders(false);
		
		FormLayout frmlytMid_02_3_3_1_1 = new FormLayout();
		frmlytMid_02_3_3_1_1.setLabelWidth(0);
		lyoutMid_02_3_3_1_1.setLayout(frmlytMid_02_3_3_1_1);
		
		tempNumDaysFle_3 = new NumberField();
		tempNumDaysFle_3.setLabelSeparator("");
		tempNumDaysFle_3.setReadOnly(true);
		tempNumDaysFle_3.setAllowDecimals(true); 
		tempNumDaysFle_3.setPropertyEditorType(Long.class); 
		tempNumDaysFle_3.setFormat(NumberFormat.getDecimalFormat());
		tempNumDaysFle_3.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_3_1_1.add(tempNumDaysFle_3, new FormData("100%"));
		lyoutMid_02_3_3_1.add(lyoutMid_02_3_3_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		
		LayoutContainer lyoutMid_02_3_3_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_3_1_2.setBorders(false);
		
		LabelField labelfldMid_02_3_3_1_2  = new LabelField("일");
		labelfldMid_02_3_3_1_2.setStyleAttribute("padding-top", "5px");
		labelfldMid_02_3_3_1_2.setStyleAttribute( "text-align", "center");
		labelfldMid_02_3_3_1_2.setBorders(false);
		lyoutMid_02_3_3_1_2.add(labelfldMid_02_3_3_1_2, new FormData("100%"));
		lyoutMid_02_3_3_1.add(lyoutMid_02_3_3_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		lyoutMid_02_3_1.add(lyoutMid_02_3_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		//-- >
		
		//-- >
		LayoutContainer lyoutMid_02_3_1_4 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_4.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_1_4_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_4_1.setBorders(false);
		
		LayoutContainer lyoutMid_02_3_4_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_4_1_1.setBorders(false);
		
		FormLayout frmlytMid_02_3_4_1_1 = new FormLayout();
		frmlytMid_02_3_4_1_1.setLabelWidth(0);
		lyoutMid_02_3_4_1_1.setLayout(frmlytMid_02_3_4_1_1);
		
		tempNumDaysFle_4 = new NumberField();
		tempNumDaysFle_4.setLabelSeparator("");
		tempNumDaysFle_4.setReadOnly(true);
		tempNumDaysFle_4.setAllowDecimals(true); 
		tempNumDaysFle_4.setPropertyEditorType(Long.class); 
		tempNumDaysFle_4.setFormat(NumberFormat.getDecimalFormat());
		tempNumDaysFle_4.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_4_1_1.add(tempNumDaysFle_4, new FormData("100%"));
		lyoutMid_02_3_1_4_1.add(lyoutMid_02_3_4_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		
		LayoutContainer lyoutMid_02_3_4_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_4_1_2.setBorders(false);
		
		LabelField labelfldMid_02_3_4_1_2  = new LabelField("일");
		labelfldMid_02_3_4_1_2.setStyleAttribute("padding-top", "5px");
		labelfldMid_02_3_4_1_2.setStyleAttribute( "text-align", "center");
		labelfldMid_02_3_4_1_2.setBorders(false);
		lyoutMid_02_3_4_1_2.add(labelfldMid_02_3_4_1_2, new FormData("100%"));
		lyoutMid_02_3_1_4_1.add(lyoutMid_02_3_4_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		lyoutMid_02_3_1.add(lyoutMid_02_3_1_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		//-- >
		
		//-- >
		LayoutContainer lyoutMid_02_3_1_5 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_5.setBorders(true);
		
		LayoutContainer lyoutMid_02_3_1_5_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_1_5_1.setBorders(true);
		
		LayoutContainer lyoutMid_02_3_5_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_5_1_1.setBorders(false);
		
		FormLayout frmlytMid_02_3_5_1_1 = new FormLayout();
		frmlytMid_02_3_5_1_1.setLabelWidth(0);
		lyoutMid_02_3_5_1_1.setLayout(frmlytMid_02_3_5_1_1);
		
		tempNumDaysFle_5 = new NumberField();
		tempNumDaysFle_5.setLabelSeparator("");
		tempNumDaysFle_5.setReadOnly(true);
		tempNumDaysFle_5.setAllowDecimals(true); 
		tempNumDaysFle_5.setPropertyEditorType(Long.class); 
		tempNumDaysFle_5.setFormat(NumberFormat.getDecimalFormat());
		tempNumDaysFle_5.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_5_1_1.add(tempNumDaysFle_5, new FormData("100%"));
		lyoutMid_02_3_1_5_1.add(lyoutMid_02_3_5_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		
		LayoutContainer lyoutMid_02_3_5_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_5_1_2.setBorders(false);
		
		LabelField labelfldMid_02_3_5_1_2  = new LabelField("일");
		labelfldMid_02_3_5_1_2.setStyleAttribute("padding-top", "5px");
		labelfldMid_02_3_5_1_2.setStyleAttribute( "text-align", "center");
		labelfldMid_02_3_5_1_2.setBorders(false);
		lyoutMid_02_3_5_1_2.add(labelfldMid_02_3_5_1_2, new FormData("100%"));
		lyoutMid_02_3_1_5_1.add(lyoutMid_02_3_5_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lyoutMid_02_3_1.add(lyoutMid_02_3_1_5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		 //-- >
		lyoutMid_02_3.add(lyoutMid_02_3_1, new FormData("100%"));
		// -- 1
		
		// -- 2
		final LayoutContainer lyoutMid_02_3_2 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_2.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3_2.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3_2.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3_2.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		
		 //-- >
		LayoutContainer lyoutMid_02_3_2_01 = new LayoutContainer();
		lyoutMid_02_3_2_01.setBorders(false);
		
		FormLayout frmlytMid_02_3_2_01 = new FormLayout();
		frmlytMid_02_3_2_01.setLabelWidth(0);
		lyoutMid_02_3_2_01.setLayout(frmlytMid_02_3_2_01);
		
		tempNumFle_1 = new NumberField();
		tempNumFle_1.setLabelSeparator("");
		//tempNumFle_1.setReadOnly(true);
		tempNumFle_1.setAllowDecimals(true); 
		tempNumFle_1.setPropertyEditorType(Long.class); 
		tempNumFle_1.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_1.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_2_01.add(tempNumFle_1, new FormData("100%"));
		
		lyoutMid_02_3_2.add(lyoutMid_02_3_2_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		 //-- >
		
		 //-- >
		LayoutContainer lyoutMid_02_3_2_02 = new LayoutContainer();
		lyoutMid_02_3_2_02.setBorders(false);
		
		FormLayout frmlytMid_02_3_2_02 = new FormLayout();
		frmlytMid_02_3_2_02.setLabelWidth(0);
		lyoutMid_02_3_2_02.setLayout(frmlytMid_02_3_2_02);
		
		tempNumFle_2 = new NumberField();
		tempNumFle_2.setLabelSeparator("");
		//tempNumFle_2.setReadOnly(true);
		tempNumFle_2.setAllowDecimals(true); 
		tempNumFle_2.setPropertyEditorType(Long.class); 
		tempNumFle_2.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_2.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_2_02.add(tempNumFle_2, new FormData("100%"));
		
		lyoutMid_02_3_2.add(lyoutMid_02_3_2_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		 //-- >
		
		 //-- >
		LayoutContainer lyoutMid_02_3_2_03 = new LayoutContainer();
		lyoutMid_02_3_2_03.setBorders(false);
		
		FormLayout frmlytMid_02_3_2_03 = new FormLayout();
		frmlytMid_02_3_2_03.setLabelWidth(0);
		lyoutMid_02_3_2_03.setLayout(frmlytMid_02_3_2_03);
		
		tempNumFle_3 = new NumberField();
		tempNumFle_3.setLabelSeparator("");
		//tempNumFle_3.setReadOnly(true);
		tempNumFle_3.setAllowDecimals(true); 
		tempNumFle_3.setPropertyEditorType(Long.class); 
		tempNumFle_3.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_3.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_2_03.add(tempNumFle_3, new FormData("100%"));
		
		lyoutMid_02_3_2.add(lyoutMid_02_3_2_03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		 //-- >
		
		//-- >
		LayoutContainer lyoutMid_02_3_2_04 = new LayoutContainer();
		lyoutMid_02_3_2_04.setBorders(false);
		
		FormLayout frmlytMid_02_3_2_04 = new FormLayout();
		frmlytMid_02_3_2_04.setLabelWidth(0);
		lyoutMid_02_3_2_04.setLayout(frmlytMid_02_3_2_04);
		
		tempNumFle_4 = new NumberField();
		tempNumFle_4.setLabelSeparator("");
		//tempNumFle_4.setReadOnly(true);
		tempNumFle_4.setAllowDecimals(true); 
		tempNumFle_4.setPropertyEditorType(Long.class); 
		tempNumFle_4.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_4.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_2_04.add(tempNumFle_4, new FormData("100%"));
		
		lyoutMid_02_3_2.add(lyoutMid_02_3_2_04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		//-- >
		
		 //-- >
		LayoutContainer lyoutMid_02_3_2_05 = new LayoutContainer();
		lyoutMid_02_3_2_05.setBorders(false);
		
		FormLayout frmlytMid_02_3_2_05 = new FormLayout();
		frmlytMid_02_3_2_05.setLabelWidth(0);
		lyoutMid_02_3_2_05.setLayout(frmlytMid_02_3_2_05);
		
		tempSumNumFle_1 = new NumberField();
		tempSumNumFle_1.setLabelSeparator("");
		//tempSumNumFle_1.setReadOnly(true);
		tempSumNumFle_1.setAllowDecimals(true); 
		tempSumNumFle_1.setPropertyEditorType(Long.class); 
		tempSumNumFle_1.setFormat(NumberFormat.getDecimalFormat());
		tempSumNumFle_1.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_2_05.add(tempSumNumFle_1, new FormData("100%"));
		
		lyoutMid_02_3_2.add(lyoutMid_02_3_2_05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		 //-- >
		
		lyoutMid_02_3.add(lyoutMid_02_3_2, new FormData("100%"));
		// -- 2
		
		// -- 3
		final LayoutContainer lyoutMid_02_3_3 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_3.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3_3.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3_3.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3_3.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		
		 //-- >
		LayoutContainer lyoutMid_02_3_3_01 = new LayoutContainer();
		lyoutMid_02_3_3_01.setBorders(false);
		
		FormLayout frmlytMid_02_3_3_01 = new FormLayout();
		frmlytMid_02_3_3_01.setLabelWidth(0);
		lyoutMid_02_3_3_01.setLayout(frmlytMid_02_3_3_01);
		
		tempNumFle_5 = new NumberField();
		tempNumFle_5.setLabelSeparator("");
		//tempNumFle_5.setReadOnly(true);
		tempNumFle_5.setAllowDecimals(true); 
		tempNumFle_5.setPropertyEditorType(Long.class); 
		tempNumFle_5.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_5.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_3_01.add(tempNumFle_5, new FormData("100%"));
		
		lyoutMid_02_3_3.add(lyoutMid_02_3_3_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		 //-- >
		
		 //-- >
		LayoutContainer lyoutMid_02_3_3_02 = new LayoutContainer();
		lyoutMid_02_3_3_02.setBorders(false);
		
		FormLayout frmlytMid_02_3_3_02 = new FormLayout();
		frmlytMid_02_3_3_02.setLabelWidth(0);
		lyoutMid_02_3_3_02.setLayout(frmlytMid_02_3_3_02);
		
		tempNumFle_6 = new NumberField();
		tempNumFle_6.setLabelSeparator("");
		//tempNumFle_6.setReadOnly(true);
		tempNumFle_6.setAllowDecimals(true); 
		tempNumFle_6.setPropertyEditorType(Long.class); 
		tempNumFle_6.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_6.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_3_02.add(tempNumFle_6, new FormData("100%"));
		
		lyoutMid_02_3_3.add(lyoutMid_02_3_3_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		 //-- >
		
		 //-- >
		LayoutContainer lyoutMid_02_3_3_03 = new LayoutContainer();
		lyoutMid_02_3_3_03.setBorders(false);
		
		FormLayout frmlytMid_02_3_3_03 = new FormLayout();
		frmlytMid_02_3_3_03.setLabelWidth(0);
		lyoutMid_02_3_3_03.setLayout(frmlytMid_02_3_3_03);
		
		tempNumFle_7 = new NumberField();
		tempNumFle_7.setLabelSeparator("");
		//tempNumFle_7.setReadOnly(true);
		tempNumFle_7.setAllowDecimals(true); 
		tempNumFle_7.setPropertyEditorType(Long.class); 
		tempNumFle_7.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_7.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_3_03.add(tempNumFle_7, new FormData("100%"));
		
		lyoutMid_02_3_3.add(lyoutMid_02_3_3_03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		 //-- >
		
		//-- >
		LayoutContainer lyoutMid_02_3_3_04 = new LayoutContainer();
		lyoutMid_02_3_3_04.setBorders(false);
		
		FormLayout frmlytMid_02_3_3_04 = new FormLayout();
		frmlytMid_02_3_3_04.setLabelWidth(0);
		lyoutMid_02_3_3_04.setLayout(frmlytMid_02_3_3_04);
		
		tempNumFle_8 = new NumberField();
		tempNumFle_8.setLabelSeparator("");
		//tempNumFle_8.setReadOnly(true);
		tempNumFle_8.setAllowDecimals(true); 
		tempNumFle_8.setPropertyEditorType(Long.class); 
		tempNumFle_8.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_8.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_3_04.add(tempNumFle_8, new FormData("100%"));
		
		lyoutMid_02_3_3.add(lyoutMid_02_3_3_04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.215));
		//-- >
		
		 //-- >
		LayoutContainer lyoutMid_02_3_3_05 = new LayoutContainer();
		lyoutMid_02_3_3_05.setBorders(false);
		
		FormLayout frmlytMid_02_3_3_05 = new FormLayout();
		frmlytMid_02_3_3_05.setLabelWidth(0);
		lyoutMid_02_3_3_05.setLayout(frmlytMid_02_3_3_05);
		
		tempSumNumFle_2 = new NumberField();
		tempSumNumFle_2.setLabelSeparator("");
		//tempSumNumFle_2.setReadOnly(true);
		tempSumNumFle_2.setAllowDecimals(true); 
		tempSumNumFle_2.setPropertyEditorType(Long.class); 
		tempSumNumFle_2.setFormat(NumberFormat.getDecimalFormat());
		tempSumNumFle_2.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_3_05.add(tempSumNumFle_2, new FormData("100%"));
		
		lyoutMid_02_3_3.add(lyoutMid_02_3_3_05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		 //-- >
		
		lyoutMid_02_3.add(lyoutMid_02_3_3, new FormData("100%"));	
		// -- 3
		
		
		// -- 4
		final LayoutContainer lyoutMid_02_3_4 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_4.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3_4.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3_4.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3_4.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		 // -- >
		LayoutContainer lyoutMid_02_3_4_01 = new LayoutContainer();
		lyoutMid_02_3_4_01.setBorders(false);
		
		FormLayout frmlytMid_02_3_4_01 = new FormLayout();
		frmlytMid_02_3_4_01.setLabelWidth(0);
		lyoutMid_02_3_4_01.setLayout(frmlytMid_02_3_4_01);
		
		tempNumFle_9 = new NumberField();
		tempNumFle_9.setLabelSeparator("");
		//tempNumFle_9.setReadOnly(true);
		tempNumFle_9.setAllowDecimals(true); 
		tempNumFle_9.setPropertyEditorType(Long.class); 
		tempNumFle_9.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_9.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_4_01.add(tempNumFle_9, new FormData("100%"));
		
		lyoutMid_02_3_4.add(lyoutMid_02_3_4_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.86));
		 // -- >
		
		 // -- >
		LayoutContainer lyoutMid_02_3_4_02 = new LayoutContainer();
		lyoutMid_02_3_4_02.setBorders(false);
		
		FormLayout frmlytMid_02_3_4_02 = new FormLayout();
		frmlytMid_02_3_4_02.setLabelWidth(0);
		lyoutMid_02_3_4_02.setLayout(frmlytMid_02_3_4_02);
		
		tempSumNumFle_3 = new NumberField();
		tempSumNumFle_3.setLabelSeparator("");
		//tempSumNumFle_3.setReadOnly(true);
		tempSumNumFle_3.setAllowDecimals(true); 
		tempSumNumFle_3.setPropertyEditorType(Long.class); 
		tempSumNumFle_3.setFormat(NumberFormat.getDecimalFormat());
		tempSumNumFle_3.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_4_02.add(tempSumNumFle_3, new FormData("100%"));
		
		lyoutMid_02_3_4.add(lyoutMid_02_3_4_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		 // -- >
		lyoutMid_02_3.add(lyoutMid_02_3_4, new FormData("100%"));	
		// -- 4
		
		
		// -- 5
		final LayoutContainer lyoutMid_02_3_5 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_5.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3_5.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3_5.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3_5.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		 // -- >
		LayoutContainer lyoutMid_02_3_5_01 = new LayoutContainer();
		lyoutMid_02_3_5_01.setBorders(false);
		
		FormLayout frmlytMid_02_3_5_01 = new FormLayout();
		frmlytMid_02_3_5_01.setLabelWidth(0);
		lyoutMid_02_3_5_01.setLayout(frmlytMid_02_3_5_01);
		
		tempNumFle_10 = new NumberField();
		tempNumFle_10.setLabelSeparator("");
		//tempNumFle_10.setReadOnly(true);
		tempNumFle_10.setAllowDecimals(true); 
		tempNumFle_10.setPropertyEditorType(Long.class); 
		tempNumFle_10.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_10.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_5_01.add(tempNumFle_10, new FormData("100%"));
		
		lyoutMid_02_3_5.add(lyoutMid_02_3_5_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.86));
		 // -- >
		
		 // -- >
		LayoutContainer lyoutMid_02_3_5_02 = new LayoutContainer();
		lyoutMid_02_3_5_02.setBorders(false);
		
		FormLayout frmlytMid_02_3_5_02 = new FormLayout();
		frmlytMid_02_3_5_02.setLabelWidth(0);
		lyoutMid_02_3_5_02.setLayout(frmlytMid_02_3_5_02);
		
		tempSumNumFle_4 = new NumberField();
		tempSumNumFle_4.setLabelSeparator("");
		//tempSumNumFle_4.setReadOnly(true);
		tempSumNumFle_4.setAllowDecimals(true); 
		tempSumNumFle_4.setPropertyEditorType(Long.class); 
		tempSumNumFle_4.setFormat(NumberFormat.getDecimalFormat());
		tempSumNumFle_4.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_5_02.add(tempSumNumFle_4, new FormData("100%"));
		
		lyoutMid_02_3_5.add(lyoutMid_02_3_5_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		 // -- >
		lyoutMid_02_3.add(lyoutMid_02_3_5, new FormData("100%"));
		// -- 5
		
		
		// -- 6
		final LayoutContainer lyoutMid_02_3_6 = new LayoutContainer(new ColumnLayout());
		lyoutMid_02_3_6.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_3_6.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_3_6.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_3_6.setStyleName("x-border-u-bottom",true);
	    		lyoutMid_02_3_6.setHeight("25px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		 // -- >
		LayoutContainer lyoutMid_02_3_6_01 = new LayoutContainer();
		lyoutMid_02_3_6_01.setBorders(false);
		
		FormLayout frmlytMid_02_3_6_01 = new FormLayout();
		frmlytMid_02_3_6_01.setLabelWidth(0);
		lyoutMid_02_3_6_01.setLayout(frmlytMid_02_3_6_01);
		
		tempNumFle_11 = new NumberField();
		tempNumFle_11.setLabelSeparator("");
		//tempNumFle_11.setReadOnly(true);
		tempNumFle_11.setAllowDecimals(true); 
		tempNumFle_11.setPropertyEditorType(Long.class); 
		tempNumFle_11.setFormat(NumberFormat.getDecimalFormat());
		tempNumFle_11.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_6_01.add(tempNumFle_11, new FormData("100%"));
		
		lyoutMid_02_3_6.add(lyoutMid_02_3_6_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.86));
		 // -- >
		
		 // -- >
		LayoutContainer lyoutMid_02_3_6_02 = new LayoutContainer();
		lyoutMid_02_3_6_02.setBorders(false);
		
		FormLayout frmlytMid_02_3_6_02 = new FormLayout();
		frmlytMid_02_3_6_02.setLabelWidth(0);
		lyoutMid_02_3_6_02.setLayout(frmlytMid_02_3_6_02);
		
		tempSumNumFle_5 = new NumberField();
		tempSumNumFle_5.setLabelSeparator("");
		//tempSumNumFle_5.setReadOnly(true);
		tempSumNumFle_5.setAllowDecimals(true); 
		tempSumNumFle_5.setPropertyEditorType(Long.class); 
		tempSumNumFle_5.setFormat(NumberFormat.getDecimalFormat());
		tempSumNumFle_5.setInputStyleAttribute("text-align", "right"); 
		lyoutMid_02_3_6_02.add(tempSumNumFle_5, new FormData("100%"));
		
		lyoutMid_02_3_6.add(lyoutMid_02_3_6_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		 // -- >
		lyoutMid_02_3.add(lyoutMid_02_3_6, new FormData("100%"));
		// -- 6
		
		lyoutMid_02.add(lyoutMid_02_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.855));
		lyoutMid.add(lyoutMid_02, new FormData("100%"));
		fieldSet.add(lyoutMid);
		
		
		/**********/
		LayoutContainer lyoutUnder = new LayoutContainer(new ColumnLayout());
		lyoutUnder.setBorders(false);
		
		
		// >>>>>>>>>>>
		LayoutContainer lyoutUnder_1 = new LayoutContainer();
		lyoutUnder_1.setBorders(false);
		
		final LayoutContainer lyoutUnder_1_1 = new LayoutContainer();
		lyoutUnder_1_1.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_1_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_1_1.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_1_1.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
		LabelField labelfldUnder_1_1 = new LabelField("평균임금");
		// lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px");
		// lblfldNewLabelfield_12.setHeight(24);
		labelfldUnder_1_1.setStyleAttribute("padding-top", "5px");
		labelfldUnder_1_1.setStyleAttribute("vertical-align", "middle");
		labelfldUnder_1_1.setStyleAttribute("background-color", "#dfe8f6");
		lyoutUnder_1_1.add(labelfldUnder_1_1, new FormData("100%"));
		//lyoutUnder_1.add(lyoutUnder_1_1, new FormData("100%"));
		 
		 
		final LayoutContainer lyoutUnder_1_2 = new LayoutContainer();
		lyoutUnder_1_2.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_1_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_1_2.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_1_2.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_1_2.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
		LabelField labelfldUnder_1_2 = new LabelField("통산임금");
		// lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px");
		// lblfldNewLabelfield_12.setHeight(24);
		labelfldUnder_1_2.setStyleAttribute("padding-top", "5px");
		labelfldUnder_1_2.setStyleAttribute("vertical-align", "middle");
		labelfldUnder_1_2.setStyleAttribute("background-color", "#dfe8f6");
		lyoutUnder_1_2.add(labelfldUnder_1_2, new FormData("100%"));
		lyoutUnder_1.add(lyoutUnder_1_2, new FormData("100%"));
		
		
		final LayoutContainer lyoutUnder_1_3 = new LayoutContainer();
		lyoutUnder_1_3.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_1_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_1_3.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_1_3.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_1_3.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
		LabelField labelfldUnder_1_3 = new LabelField("1일소정근로시간");
		// lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px");
		// lblfldNewLabelfield_12.setHeight(24);
		labelfldUnder_1_3.setStyleAttribute("padding-top", "5px");
		labelfldUnder_1_3.setStyleAttribute("vertical-align", "middle");
		labelfldUnder_1_3.setStyleAttribute("background-color", "#dfe8f6");
		lyoutUnder_1_3.add(labelfldUnder_1_3, new FormData("100%"));
		lyoutUnder_1.add(lyoutUnder_1_3, new FormData("100%"));
		
		
		final LayoutContainer lyoutUnder_1_4 = new LayoutContainer();
		lyoutUnder_1_4.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_1_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_1_4.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_1_4.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_1_4.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
		LabelField labelfldUnder_1_4 = new LabelField("기타(퇴직금외 기타 금품)");
		// lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px");
		// lblfldNewLabelfield_12.setHeight(24);
		labelfldUnder_1_4.setStyleAttribute("padding-top", "5px");
		labelfldUnder_1_4.setStyleAttribute("vertical-align", "middle");
		labelfldUnder_1_4.setStyleAttribute("background-color", "#dfe8f6");
		lyoutUnder_1_4.add(labelfldUnder_1_4, new FormData("100%"));
		lyoutUnder_1.add(lyoutUnder_1_4, new FormData("100%"));
		
		
		final LayoutContainer lyoutUnder_1_5 = new LayoutContainer();
		lyoutUnder_1_5.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_1_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_1_5.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_1_5.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_1_5.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
		LabelField labelfldUnder_1_5 = new LabelField("구체적사유");
		// lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px");
		// lblfldNewLabelfield_12.setHeight(24);
		labelfldUnder_1_5.setStyleAttribute("padding-top", "5px");
		labelfldUnder_1_5.setStyleAttribute("vertical-align", "middle");
		labelfldUnder_1_5.setStyleAttribute("background-color", "#dfe8f6");
		//lyoutUnder_1_5.add(labelfldUnder_1_5, new FormData("100%"));
		//lyoutUnder_1.add(lyoutUnder_1_5, new FormData("100%"));
		
		lyoutUnder.add(lyoutUnder_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		// >>>>>>>>>>>
		
		
		// >>>>>>>>>>>
		LayoutContainer lyoutUnder_2 = new LayoutContainer();
		lyoutUnder_2.setBorders(false);
		
		
		 // --
		LayoutContainer lyoutUnder_2_1 = new LayoutContainer();
		lyoutUnder_2_1.setBorders(false);
		
		final LayoutContainer lyoutUnder_2_1_1 = new LayoutContainer(new ColumnLayout());
		lyoutUnder_2_1_1.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_2_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_2_1_1.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_2_1_1.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_2_1_1.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/		
		
//		LayoutContainer lyoutUnder_2_1_1_1 = new LayoutContainer();
//		lyoutUnder_2_1_1_1.setBorders(false);
//		
//		FormLayout frmlytUnder_2_1_1_1 = new FormLayout();
//		frmlytUnder_2_1_1_1.setLabelWidth(75);
//		frmlytUnder_2_1_1_1.setLabelAlign(LabelAlign.RIGHT);
//		lyoutUnder_2_1_1_1.setLayout(frmlytUnder_2_1_1_1);
//		
//		tempUnderNumFle_1 = new NumberField();
//		tempUnderNumFle_1.setLabelSeparator("총임금액");
//		tempUnderNumFle_1.setReadOnly(true);
//		tempUnderNumFle_1.setAllowDecimals(true); 
//		tempUnderNumFle_1.setPropertyEditorType(Long.class); 
//		tempUnderNumFle_1.setFormat(NumberFormat.getDecimalFormat());
//		lyoutUnder_2_1_1_1.add(tempUnderNumFle_1, new FormData("100%"));
//		
//		lyoutUnder_2_1_1.add(lyoutUnder_2_1_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		
//		
//		
//		LayoutContainer lyoutUnder_2_1_1_2 = new LayoutContainer();
//		lyoutUnder_2_1_1_2.setBorders(false);
//		
//		FormLayout frmlytUnder_2_1_1_2 = new FormLayout();
//		frmlytUnder_2_1_1_2.setLabelWidth(75);
//		frmlytUnder_2_1_1_2.setLabelAlign(LabelAlign.RIGHT);
//		lyoutUnder_2_1_1_2.setLayout(frmlytUnder_2_1_1_2);
//		
//		tempUnderNumFle_2 = new NumberField();
//		tempUnderNumFle_2.setLabelSeparator(" / 총일수");
//		tempUnderNumFle_2.setReadOnly(true);
//		tempUnderNumFle_2.setAllowDecimals(true); 
//		tempUnderNumFle_2.setPropertyEditorType(Long.class); 
//		tempUnderNumFle_2.setFormat(NumberFormat.getDecimalFormat());
//		lyoutUnder_2_1_1_2.add(tempUnderNumFle_2, new FormData("100%"));
//		
//		lyoutUnder_2_1_1.add(lyoutUnder_2_1_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		
//		
//		
//		LayoutContainer lyoutUnder_2_1_1_3 = new LayoutContainer();
//		lyoutUnder_2_1_1_3.setBorders(false);
//		
//		FormLayout frmlytUnder_2_1_1_3 = new FormLayout();
//		frmlytUnder_2_1_1_3.setLabelWidth(10);
//		
//		lyoutUnder_2_1_1_3.setLayout(frmlytUnder_2_1_1_3);
//		
//		tempUnderNumFle_3 = new NumberField();
//		tempUnderNumFle_3.setLabelSeparator(" = ");
//		tempUnderNumFle_3.setReadOnly(true);
//		tempUnderNumFle_3.setAllowDecimals(true); 
//		tempUnderNumFle_3.setPropertyEditorType(Long.class); 
//		tempUnderNumFle_3.setFormat(NumberFormat.getDecimalFormat());
//		lyoutUnder_2_1_1_3.add(tempUnderNumFle_3, new FormData("100%"));
//		
//		lyoutUnder_2_1_1.add(lyoutUnder_2_1_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		lyoutUnder_2_1.add(lyoutUnder_2_1_1, new FormData("100%"));
		
		
		//
		final LayoutContainer lyoutUnder_2_1_2 = new LayoutContainer(new ColumnLayout());
		lyoutUnder_2_1_2.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_2_1_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_2_1_2.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_2_1_2.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_2_1_2.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/		
		
		LayoutContainer lyoutUnder_2_1_2_1 = new LayoutContainer();
		lyoutUnder_2_1_2_1.setBorders(false);
		
		FormLayout frmlytUnder_2_1_2_1 = new FormLayout();
		frmlytUnder_2_1_2_1.setLabelWidth(0);
		frmlytUnder_2_1_2_1.setLabelAlign(LabelAlign.RIGHT);
		lyoutUnder_2_1_2_1.setLayout(frmlytUnder_2_1_2_1);
		
		tempUnderNumFle_4 = new NumberField();
		tempUnderNumFle_4.setLabelSeparator("");
		//tempUnderNumFle_4.setReadOnly(true);
		tempUnderNumFle_4.setAllowDecimals(true); 
		tempUnderNumFle_4.setPropertyEditorType(Long.class); 
		tempUnderNumFle_4.setFormat(NumberFormat.getDecimalFormat());
		tempUnderNumFle_4.setInputStyleAttribute("text-align", "right"); 
		lyoutUnder_2_1_2_1.add(tempUnderNumFle_4, new FormData("100%"));
		
		lyoutUnder_2_1_2.add(lyoutUnder_2_1_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		
		
		LayoutContainer lyoutUnder_2_1_2_2 = new LayoutContainer();
		lyoutUnder_2_1_2_2.setBorders(false);
		
		FormLayout frmlytUnder_2_1_2_2= new FormLayout();
		frmlytUnder_2_1_2_2.setLabelWidth(75);
		frmlytUnder_2_1_2_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutUnder_2_1_2_2.setLayout(frmlytUnder_2_1_2_2);
		
		tempUnderNumFle_5 = new NumberField();
		tempUnderNumFle_5.setLabelSeparator("기준임금");
		//tempUnderNumFle_5.setReadOnly(true);
		tempUnderNumFle_5.setAllowDecimals(true); 
		tempUnderNumFle_5.setPropertyEditorType(Long.class); 
		tempUnderNumFle_5.setFormat(NumberFormat.getDecimalFormat());
		tempUnderNumFle_5.setInputStyleAttribute("text-align", "right"); 
		lyoutUnder_2_1_2_2.add(tempUnderNumFle_5, new FormData("100%"));
		
		lyoutUnder_2_1_2.add(lyoutUnder_2_1_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		lyoutUnder_2_1.add(lyoutUnder_2_1_2, new FormData("100%"));
		//
		
		
		//
		final LayoutContainer lyoutUnder_2_1_3 = new LayoutContainer(new ColumnLayout());
		lyoutUnder_2_1_3.setBorders(true);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_2_1_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_2_1_3.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_2_1_3.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_2_1_3.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/		
		
		LayoutContainer lyoutUnder_2_1_3_1 = new LayoutContainer();
		lyoutUnder_2_1_3_1.setBorders(false);
		
		FormLayout frmlytUnder_2_1_3_1 = new FormLayout();
		frmlytUnder_2_1_3_1.setLabelWidth(0);
		frmlytUnder_2_1_3_1.setLabelAlign(LabelAlign.RIGHT);
		lyoutUnder_2_1_3_1.setLayout(frmlytUnder_2_1_3_1);
		
		tempUnderNumFle_6 = new TextField<String>();
		tempUnderNumFle_6.setName("tempUnderNumFle_6");
		tempUnderNumFle_6.setLabelSeparator("");
		tempUnderNumFle_6.setInputStyleAttribute("text-align", "right");
		lyoutUnder_2_1_3_1.add(tempUnderNumFle_6, new FormData("100%"));
		
		lyoutUnder_2_1_3.add(lyoutUnder_2_1_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		
		
		LayoutContainer lyoutUnder_2_1_3_2 = new LayoutContainer();
		lyoutUnder_2_1_3_2.setBorders(false);
		
		FormLayout frmlytUnder_2_1_3_2 = new FormLayout();
		frmlytUnder_2_1_3_2.setLabelWidth(75);
		frmlytUnder_2_1_3_2.setLabelAlign(LabelAlign.RIGHT);
		lyoutUnder_2_1_3_2.setLayout(frmlytUnder_2_1_3_2);
		
		tempUnderNumFle_7 = new NumberField();
		tempUnderNumFle_7.setLabelSeparator("퇴직금수령액");
		//tempUnderNumFle_7.setReadOnly(true);
		tempUnderNumFle_7.setAllowDecimals(true); 
		tempUnderNumFle_7.setPropertyEditorType(Long.class); 
		tempUnderNumFle_7.setFormat(NumberFormat.getDecimalFormat());
		tempUnderNumFle_7.setInputStyleAttribute("text-align", "right"); 
		lyoutUnder_2_1_3_2.add(tempUnderNumFle_7, new FormData("100%"));
		
		lyoutUnder_2_1_3.add(lyoutUnder_2_1_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		lyoutUnder_2_1.add(lyoutUnder_2_1_3, new FormData("100%"));
		//
		
		//
		final LayoutContainer lyoutUnder_2_1_4 = new LayoutContainer();
		lyoutUnder_2_1_4.setBorders(true);
		
		FormLayout frmlytUnder_2_1_4 = new FormLayout();
		frmlytUnder_2_1_4.setLabelWidth(0);
		lyoutUnder_2_1_4.setLayout(frmlytUnder_2_1_4);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_2_1_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_2_1_4.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_2_1_4.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_2_1_4.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/		
		
		tempUnderTxtFle_1 = new NumberField();
		tempUnderTxtFle_1.setLabelSeparator("");
		//tempUnderTxtFle_1.setReadOnly(true);
		tempUnderTxtFle_1.setAllowDecimals(true); 
		tempUnderTxtFle_1.setPropertyEditorType(Long.class); 
		tempUnderTxtFle_1.setFormat(NumberFormat.getDecimalFormat());
		tempUnderTxtFle_1.setInputStyleAttribute("text-align", "right");
		lyoutUnder_2_1_4.add(tempUnderTxtFle_1, new FormData("100%"));
		
		lyoutUnder_2_1.add(lyoutUnder_2_1_4, new FormData("100%"));
		
	
		
		
		
		//
		
		
		//
		final LayoutContainer lyoutUnder_2_1_5 = new LayoutContainer();
		lyoutUnder_2_1_5.setBorders(true);
		
		FormLayout frmlytUnder_2_1_5 = new FormLayout();
		frmlytUnder_2_1_5.setLabelWidth(0);
		lyoutUnder_2_1_5.setLayout(frmlytUnder_2_1_5);
		/**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_2_1_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_2_1_5.removeStyleName("x-border");
		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
	    		lyoutUnder_2_1_5.setStyleName("x-border-u-bottom",true);
	    		lyoutUnder_2_1_5.setHeight("25px");  
	    	}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/		
		
	//	tempUnderTxtFle_2 = new TextField<String>();
	//	tempUnderTxtFle_2.setName("tempUnderTxtFle_2");
	//	tempUnderTxtFle_2.setLabelSeparator("");
    //	lyoutUnder_2_1_5.add(tempUnderTxtFle_2, new FormData("100%"));
		
		//lyoutUnder_2_1.add(lyoutUnder_2_1_5, new FormData("100%"));
		//
		
		
		lyoutUnder_2.add(lyoutUnder_2_1, new FormData("100%"));
		 // -- 
		
		
		
		LayoutContainer lyoutUnder_2_2 = new LayoutContainer();
		lyoutUnder_2_2.setBorders(false);
		lyoutUnder_2.add(lyoutUnder_2_2, new FormData("100%"));
		
		
		
		
		lyoutUnder.add(lyoutUnder_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		// >>>>>>>>>>>
		
		
		fieldSet.add(lyoutUnder, new FormData("100%"));
		/**********/
		
		


		layoutContainer.add(fieldSet);
		return layoutContainer;
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
		 
	private void setInitDate() {

		Date today = new Date();
		int maxDays = 0;
		Calendar intiCal = Calendar.getInstance();
		intiCal.set(Integer.parseInt(GWTUtils.getStringFromDate(today, "yyyy")),
					Integer.parseInt(GWTUtils.getStringFromDate(today, "MM")) - 1,1);
		
		srhSoctyInsurCmptnDt01.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum(intiCal.DAY_OF_MONTH);

		if ("02".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 28) {
			maxDays = 28;
		} else if ("04".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		} else if ("06".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		} else if ("09".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		} else if ("11".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		}

		Calendar intieCal = Calendar.getInstance();
		intieCal.set(Integer.parseInt(GWTUtils.getStringFromDate(today, "yyyy")),
				Integer.parseInt(GWTUtils.getStringFromDate(today, "MM")) - 1,maxDays);
		// intiCal.add(Calendar.DATE, maxDays - 1);
		// GWT.log("일수" +
		// DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
		srhSoctyInsurCmptnDt02.setValue(intieCal.getTime());
	}
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/		   
	       
	
	public void reload() {
		

		IColumnFilter filters = null;
		 
		insr2200GridPanel.getTableDef().setTableColumnFilters(filters);			
		insr2200GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr2200GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 			
		insr2200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		insr2200GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
        String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
        insr2200GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);       
        
      //20180305추가 
        insr2200GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
      		
        String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
        insr2200GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);              
        String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
        insr2200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		insr2200GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr2200GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr2200GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		insr2200GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
		 
	   String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
	   if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
	           String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
	           String chkkey = "";
	           for (int i=0; i<ray.length; i++){ 
	               BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
	               chkkey += bmData.get("commCd")+","; 
	           }
	           strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
	   } 
        insr2200GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
		insr2200GridPanel.reload();
		actionDatabase = ActionDatabase.UPDATE;
		 
		//dpobInfoSearch();

	}
	
	//총일수 합계
		private void setTempNumDaysFle_5(){
			tempNumDaysFle_5.setValue(longToNullChk(tempNumDaysFle_1.getValue())
									 +longToNullChk(tempNumDaysFle_2.getValue())
									 +longToNullChk(tempNumDaysFle_3.getValue())
									 +longToNullChk(tempNumDaysFle_4.getValue()));
			//setTempUnderNumFle();
		}
		
		//기본금 합계
		private void setTempSumNumFle_1(){
			tempSumNumFle_1.setValue(longToNullChk(tempNumFle_1.getValue())
								    +longToNullChk(tempNumFle_2.getValue())
								    +longToNullChk(tempNumFle_3.getValue())
								    +longToNullChk(tempNumFle_4.getValue()));
			//setTempUnderNumFle();
		}
		
		//기타수당 합계
		private void setTempSumNumFle_2(){
			tempSumNumFle_2.setValue(longToNullChk(tempNumFle_5.getValue())
								    +longToNullChk(tempNumFle_6.getValue())
								    +longToNullChk(tempNumFle_7.getValue())
								    +longToNullChk(tempNumFle_8.getValue()));
			//setTempUnderNumFle();
		}
		
		//총일수 1
		private void setTempNumDaysFle_1(){
			 tempNumDaysFle_1.setValue(getDayCount(InsrUtils.getConvertDateToString(tempMidDate_1_S, "yyyyMMdd"),InsrUtils.getConvertDateToString(tempMidDate_1_E, "yyyyMMdd")));
			 setTempNumDaysFle_5();//총일수 합계
			 //setTempNumFle_1();    //기본금
			 //setTempNumFle_5();    //기타수당 
		}
		
		//기본금 1
		private void setTempNumFle_1(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_1_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_1.getValue())){
				tempNumFle_1.setValue(amntBspy);
			}else{
				long tmpAmnt = (amntBspy * longToNullChk(tempNumDaysFle_1.getValue())) / lastDay;
				tempNumFle_1.setValue(tmpAmnt);
			}	
			setTempSumNumFle_1();
		}
		
		//그밖의 수당 1(기타수당1)
		private void setTempNumFle_5(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_1_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_1.getValue())){
				tempNumFle_5.setValue(amntEtcExtpy);
			}else{
				long tmpAmnt = (amntEtcExtpy * longToNullChk(tempNumDaysFle_1.getValue())) / lastDay;
				tempNumFle_5.setValue(tmpAmnt);
			}	
			setTempSumNumFle_2();
		}
		
		
		//총일수 2
		private void setTempNumDaysFle_2(){
			 tempNumDaysFle_2.setValue(getDayCount(InsrUtils.getConvertDateToString(tempMidDate_2_S, "yyyyMMdd"),InsrUtils.getConvertDateToString(tempMidDate_2_E, "yyyyMMdd")));
			 setTempNumDaysFle_5();
			 //setTempNumFle_2();
			 //setTempNumFle_6();
		}
		
		//기본금 2
		private void setTempNumFle_2(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_2_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_2.getValue())){
				tempNumFle_2.setValue(amntBspy);
			}else{
				long tmpAmnt = (amntBspy * longToNullChk(tempNumDaysFle_2.getValue())) / lastDay;
				tempNumFle_2.setValue(tmpAmnt);
			}	
			setTempSumNumFle_1();
		}
		
		//그밖의 수당 2(기타수당2)
		private void setTempNumFle_6(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_2_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_2.getValue())){
				tempNumFle_6.setValue(amntEtcExtpy);
			}else{
				long tmpAmnt = (amntEtcExtpy * longToNullChk(tempNumDaysFle_2.getValue())) / lastDay;
				tempNumFle_6.setValue(tmpAmnt);
			}	
			setTempSumNumFle_2();
		}
		
		// 총일수 3
		private void setTempNumDaysFle_3(){
			 tempNumDaysFle_3.setValue(getDayCount(InsrUtils.getConvertDateToString(tempMidDate_3_S, "yyyyMMdd"),InsrUtils.getConvertDateToString(tempMidDate_3_E, "yyyyMMdd")));
			 setTempNumDaysFle_5();
			 //setTempNumFle_3();
			 //setTempNumFle_7();
		}
		
		// 기본금 3
		private void setTempNumFle_3(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_3_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_3.getValue())){
				tempNumFle_3.setValue(amntBspy);
			}else{
				long tmpAmnt = (amntBspy * longToNullChk(tempNumDaysFle_3.getValue())) / lastDay;
				tempNumFle_3.setValue(tmpAmnt);
			}	
			setTempSumNumFle_1();
		}
		
		//그밖의 수당 3(기타수당3)
		private void setTempNumFle_7(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_3_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_3.getValue())){
				tempNumFle_7.setValue(amntEtcExtpy);
			}else{
				long tmpAmnt = (amntEtcExtpy * longToNullChk(tempNumDaysFle_3.getValue())) / lastDay;
				tempNumFle_7.setValue(tmpAmnt);
			}	
			setTempSumNumFle_2();
		}
		
		//총일수 4
		private void setTempNumDaysFle_4(){
			 tempNumDaysFle_4.setValue(getDayCount(InsrUtils.getConvertDateToString(tempMidDate_4_S, "yyyyMMdd"),InsrUtils.getConvertDateToString(tempMidDate_4_E, "yyyyMMdd")));
			 setTempNumDaysFle_5();
			 //setTempNumFle_4();
			 //setTempNumFle_8();
		}
		
		//기본금 4
		private void setTempNumFle_4(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_4_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_4.getValue())){
				tempNumFle_4.setValue(amntBspy);
			}else{
				long tmpAmnt = (amntBspy * longToNullChk(tempNumDaysFle_4.getValue())) / lastDay;
				tempNumFle_4.setValue(tmpAmnt);
			}	
			setTempSumNumFle_1();
		}
		
		//그밖의 수당 4(기타수당4)
		private void setTempNumFle_8(){
			long lastDay = getMonthOfLastDay(InsrUtils.getConvertDateToString(tempMidDate_4_S, "yyyyMMdd"));
			if(lastDay == longToNullChk(tempNumDaysFle_4.getValue())){
				tempNumFle_8.setValue(amntEtcExtpy);
			}else{
				long tmpAmnt = (amntEtcExtpy * longToNullChk(tempNumDaysFle_4.getValue())) / lastDay;
				tempNumFle_8.setValue(tmpAmnt);
			}	
			setTempSumNumFle_2();
		}
		
		//상여금
		private void setTempNumFle_9(){
			long tmpAmnt = (amntAllwBnus * 3) / 12 ;
			tempNumFle_9.setValue(tmpAmnt);
			tempSumNumFle_3.setValue(tmpAmnt);
			
		}
		
		//연차수당
		private void setAmntAnnlExtpy(){
			long tmpAmnt = (amntAnnlExtpy * 3) / 12;
			tempNumFle_10.setValue(tmpAmnt);
			tempSumNumFle_4.setValue(tmpAmnt);
			
		}
		
		//총임금액/총일수/평균임금
		private void setTempUnderNumFle(){
			long tmpAmnt =  	
							tempSumNumFle_1.getValue().longValue()+				//기본금 합계 1
							tempSumNumFle_1.getValue().longValue()+			    //기타수당 합계 1
							tempSumNumFle_3.getValue().longValue()+				//상여금 합계 1
							tempSumNumFle_4.getValue().longValue();				//연차수당 합계 1
							//tempSumNumFle_5;				//기타 합계 1
			tempUnderNumFle_1.setValue(tmpAmnt);                                          //총임금액
			tempUnderNumFle_2.setValue(tempNumDaysFle_5.getValue().longValue());          //총일수
			tempUnderNumFle_3.setValue(tmpAmnt / tempNumDaysFle_5.getValue().longValue());//평균임금
		}
		
		private long getMonthOfLastDay(String dt){
			
			Calendar cal = Calendar.getInstance();
			int year = Integer.parseInt(dt.substring(0, 4));
			int month = Integer.parseInt(dt.substring(4, 6)) - 1;
			int day = Integer.parseInt(dt.substring(6, 8));
			cal.set(year, month, day);

			return (long) cal.getActualMaximum(cal.DATE);
		}
		
		private Long getDayCount(String startDt, String endDt){
			
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			
			int sYear = Integer.parseInt(startDt.substring(0, 4));
			int sMonth = Integer.parseInt(startDt.substring(4, 6)) - 1;
			int sDay = Integer.parseInt(startDt.substring(6, 8));
			cal1.set(sYear, sMonth, sDay);
			
			int eYear = Integer.parseInt(endDt.substring(0, 4));
			int eMonth = Integer.parseInt(endDt.substring(4, 6)) - 1;
			int eDay = Integer.parseInt(endDt.substring(6, 8));
			cal2.set(eYear, eMonth, eDay);
			
			return  (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24 * 60 * 60 * 1000) + 1L;
		}
	
	private Long longToNullChk(Object val){
		if(val == null){
			return 0L;
		}else{
			return (Long) val;
		}
	}	
	
	private void excelFileExport() {	

		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
		
		if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
			if(emymtDivCd.equals("A0020010")){
			}else if(emymtDivCd.equals("A0020020")){
				if(deptCd == null || deptCd.equals("")){
					Window.alert("부서를 선택해 주세요");
					resetForm();
					insr2200GridPanel.getMsfGrid().clearData();
					return;
				}	
				if(businCd == null || businCd.equals("")){	
					Window.alert("사업을 선택해 주세요");
					resetForm();
					insr2200GridPanel.getMsfGrid().clearData();
					return;
				}
			}else{
				Window.alert("고용구분을 선택해 주세요");
				resetForm();
				insr2200GridPanel.getMsfGrid().clearData();
				return;
			}
		}else{
			Window.alert("단위기관/고용구분을 선택해 주세요");
			resetForm();
			insr2200GridPanel.getMsfGrid().clearData();
			return;
		}
		
		
		
		HashMap<String, String> param = new HashMap<String, String>(); 
		
		
		
		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
		
		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = insr2200GridPanel.getGrid().getSelectionModel().getSelectedItems();

		if(list != null && list.size() > 0){
			String chkSysKey = "";
			int iCnt = 0;

			for(BaseModel bm : list){
				chkSysKey += bm.get("systemkey")+",";
				iCnt = iCnt + 1;
			}
			keyCnt = iCnt;
			checkedSystemKeys = chkSysKey.substring(0,chkSysKey.length()-1); //$10 시스템키   

			//시스템키는 넘기지 않고 검색조건만 넘김	
			if(keyCnt > 200) {
				MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// TODO Auto-generated method stub
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							systemKeys = "";
						}else {
							return;
						}
					}
				});
				//선택한 시스템키 넘김
			}else {
				systemKeys = checkedSystemKeys;
			}

		}
		
		
		
		param.put("soctyInsurCmptnDt01",  GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd")); 
		param.put("soctyInsurCmptnDt02",  GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd")); 			
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		//단위기관
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	    param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));    
		
		
		
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		   if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
	           String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
	           String chkkey = "";
	           for (int i=0; i<ray.length; i++){ 
	               BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
	               chkkey += bmData.get("commCd")+","; 
	           }
	           strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
	   } 			   
	   param.put("hdofcCodtnCd", strHdofcCodtnCd); 
	   insr2200GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2400Export.do","extgwtFrame" ,param);
	}
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	print Service 선언부 시작
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
	private void insr2400Print(String fileName, String repType) {
		
		
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType.trim())) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType.trim())) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!"+repType);
		   }
	    }	
	//rda
	private void RdaPrint(String fileName) {
		
		
	}
	
	//rex 
	private void RexPrint(String fileName) {

		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
		String strDirPath = "INSR";

		// reb 출력물
		String rexFileName = fileName+".crf";
		//String rexFileName = fileName+".reb";

		// 보낼 파라미터  

		// 검색조건
		String serarchParam = "";

		String soctyInsurCmptnDt01 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd");
		String soctyInsurCmptnDt02 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd");
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		String typOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
		String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
		String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue());
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for (int i=0; i<ray.length; i++){ 
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd")+","; 
			}
			strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		}

		
		String deptCdAuth = MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "");
		
		
		
		if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
			if(emymtDivCd.equals("A0020010")){
			}else if(emymtDivCd.equals("A0020020")){
				if(deptCd == null || deptCd.equals("")){
					Window.alert("부서를 선택해 주세요");
					resetForm();
					insr2200GridPanel.getMsfGrid().clearData();
					return;
				}	
				if(businCd == null || businCd.equals("")){	
					Window.alert("사업을 선택해 주세요");
					resetForm();
					insr2200GridPanel.getMsfGrid().clearData();
					return;
				}
			}else{
				Window.alert("고용구분을 선택해 주세요");
				resetForm();
				insr2200GridPanel.getMsfGrid().clearData();
				return;
			}
		}else{
			Window.alert("단위기관/고용구분을 선택해 주세요");
			resetForm();
			insr2200GridPanel.getMsfGrid().clearData();
			return;
		}

		
		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = insr2200GridPanel.getGrid().getSelectionModel().getSelectedItems();

		if(list != null && list.size() > 0){
			String chkSysKey = "";
			int iCnt = 0;

			for(BaseModel bm : list){
				chkSysKey += bm.get("systemkey")+",";
				iCnt = iCnt + 1;
			}
			keyCnt = iCnt;
			checkedSystemKeys = chkSysKey.substring(0,chkSysKey.length()-1); //$10 시스템키   

			//시스템키는 넘기지 않고 검색조건만 넘김	
			if(keyCnt > 200) {
				MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// TODO Auto-generated method stub
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							systemKeys = "";
						}else {
							return;
						}
					}
				});
				//선택한 시스템키 넘김
			}else {
				systemKeys = checkedSystemKeys;
			}

		}


		if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)){

			//도장 출력을 위해 추가 2014-11-06 //$9
			String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
			if(MSFSharedUtils.paramNull(myImgUrl)) {
			// myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력 
			}							

			
			serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";//$1
			serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt01)+"⊥";	//$2  기간검색시작		
			serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt02)+"⊥";	//$3  기간검색종료			
			serarchParam += ""+MSFSharedUtils.allowNulls(payrMangDeptCd)+"⊥";		//$4  단위기간
			serarchParam += ""+MSFSharedUtils.allowNulls(emymtDivCd)+"⊥";		    //$5  고용구분
			serarchParam += ""+MSFSharedUtils.allowNulls(deptCd)+"⊥";			    //$6  부서코드
			serarchParam += ""+MSFSharedUtils.allowNulls(typOccuCd)+"⊥";			//$7  직종
			serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCd)+"⊥";	    //$8  직종세
			serarchParam += ""+MSFSharedUtils.allowNulls(businCd)+"⊥";             //$9  사업코드
			serarchParam += ""+MSFSharedUtils.allowNulls(systemKeys)+"⊥";	        //$10 시스템키
			serarchParam += ""+MSFSharedUtils.allowNulls(hanNm)+"⊥";		        //$11 성명
			serarchParam += ""+MSFSharedUtils.allowNulls(resnRegnNum)+"⊥";		    //$12 주민번호	
			serarchParam += ""+MSFSharedUtils.allowNulls(strHdofcCodtnCd)+"⊥";		//$13 재직상태				 			        

			//20151212-변경추가 시작 
			serarchParam += ""+MSFMainApp.get().getUser().getUsrId()+"⊥";          //$14 유저 아이디
			serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$15 관리자 유무
						  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += ""+deptCdAuth+"⊥";                                     //$16 부서 
			serarchParam += ""+dtilOccuInttnCdAuth+"⊥";                            //$17 직종세 
			//20151212-추가 끝 
			serarchParam += ""+MSFSharedUtils.allowNulls(myImgUrl)+"⊥";            //$18 직인경로
			serarchParam += "0⊥";                                                  //$19 단건 1 복수건 0 프린트 추가
			
			
			String strParam = "" + serarchParam ;

			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

		}else{
			MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
		}

	}
	
	
   private void resetForm(){
	   soctyInsurCmptnDt.clear();		/** column 사회보험작성일자 : soctyInsurCmptnDt */	
	   socnsrIssRegVal02.clear();    /** column 성명 : socnsrAqtnRegVal02 */
	   socnsrIssRegVal03.clear();    /** column 주민등록번호 : socnsrAqtnRegVal03 */
	   emymtDivNm.clear();			// 고용구분
	   deptNm.clear();		 		// 부서
	   typOccuNm.clear(); 			// 직종
	   //DtilOccuClsDivNm.clear(); 		// 직종세
	   socInsrLssEmymtNum.clear(); //일련번호
	   tempDateFld1.clear(); 			// 이직(퇴직일)
	   tempDateFld2.clear(); 			// 취득일
	   tempNumFle.clear();		//통산피보험 단위기간
	   systemkey.clear();
	   dpobCd.clear();
	   deptCd.clear();
	   icncDt.clear();
	   
	   soctyInsurCmptnDtReal.clear();  //작성일자
	   
	   tempComboTop_0.clear();
	   tempComboTop_1.clear(); 		//사유1
	   tempComboTop_2.clear(); 		//사유2
	   tempComboTop_3.clear(); 		//사유3
	   tempTopDate_1_S.clear(); 					//날짜1 시작
	   tempTopDate_1_E.clear(); 					//날짜1 종료
	   tempTopDate_2_S.clear(); 					//날짜2 시작
	   tempTopDate_2_E.clear(); 					//날짜2 종료
	   tempTopDate_3_S.clear(); 					//날짜3 시작
	   tempTopDate_3_E.clear(); 					//날짜3 종료
	   tempMidDate_1_S.clear(); 					//날짜1 시작
	   tempMidDate_1_E.clear(); 					//날짜1 종료
	   tempMidDate_2_S.clear(); 					//날짜2 시작
	   tempMidDate_2_E.clear(); 					//날짜2 종료
	   tempMidDate_3_S.clear(); 					//날짜3 시작
	   tempMidDate_3_E.clear(); 					//날짜3 종료
	   tempMidDate_4_S.clear(); 					//날짜4 시작
	   tempMidDate_4_E.clear(); 					//날짜4 종료
	   tempNumDaysSumFle.clear();				//통산피보험 단위기간
	   tempNumDaysFle_1.clear();				//총보수 1
	   tempNumDaysFle_2.clear();				//총보수 2
	   tempNumDaysFle_3.clear();				//총보수 3
	   tempNumDaysFle_4.clear();				//총보수 4
	   tempNumDaysFle_5.clear();				//총보수 5
	   tempNumFle_1.clear();					//기본금 1
	   tempNumFle_2.clear();					//기본금 2
	   tempNumFle_3.clear();					//기본금 3
	   tempNumFle_4.clear();					//기본금 4
	   tempSumNumFle_1.clear();				//기본금 합계 1
	   tempNumFle_5.clear();					//기타수당 1
	   tempNumFle_6.clear();					//기타수당 2
	   tempNumFle_7.clear();					//기타수당 3
	   tempNumFle_8.clear();					//기타수당 4
	   tempSumNumFle_2.clear();				//기타수당 합계 1
	   tempNumFle_9.clear();					//상여금 1
	   tempSumNumFle_3.clear();				//상여금 합계 1
	   tempNumFle_10.clear();					//연차수당 1
	   tempSumNumFle_4.clear();				//연차수당 합계 1
	   tempNumFle_11.clear();					//기타 1
	   tempSumNumFle_5.clear();				//기타 합계 1
	   //tempUnderNumFle_1.clear();				//총임금액 
	   //tempUnderNumFle_2.clear();				//총일수
	   //tempUnderNumFle_3.clear();				//평균임금 (총임금액/총일수)
	   tempUnderNumFle_4.clear();				//통상임금
	   tempUnderNumFle_5.clear();				//기준임금
	   tempUnderNumFle_6.clear();				//1일 소정근로 시간
	   tempUnderNumFle_7.clear();				//퇴직금 수령액
	   tempUnderTxtFle_1.clear();		//기타(퇴직금외 기타 금품)
	   tempUnderTxtFle_2.clear();		//구체적 사유
	   systemKeys = "";
	   
	   insr2520GridPanel.getMsfGrid().clearData();
	   
   }
	
	
   public void setRecord(BaseModel record) {
       this.record = record;
   }
	
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();
		// //우편번호
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) {

					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); // 주민번호
				}
			}
		});
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
