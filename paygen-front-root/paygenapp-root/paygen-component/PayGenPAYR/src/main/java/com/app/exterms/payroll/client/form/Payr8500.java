package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr8500Service;
import com.app.exterms.payroll.client.service.Payr8500ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2000BM;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2000DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2100DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2200DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemtDays0100DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemtPayr0100BM;
import com.app.exterms.retirement.client.form.def.InfcPkgRemt2000Def;
import com.app.exterms.retirement.client.form.def.InfcPkgRemtPayr0100Def;
import com.app.exterms.retirement.client.form.def.InfcPkgRemtWfep0100Def;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
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
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
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
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
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
public class Payr8500  extends MSFPanel { 
 
/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	  
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
	private FormPanel plFrmPayr8500;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	private FieldSet fldstNewFieldset_1;
	private TabPanel tabsRemtSub;
	private TabPanel tabsRemtTop;
	
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 그리드 def, panel 변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		// -- 퇴직금대상자정보리스트 
		private InfcPkgRemt2000Def remt2000Def  = new InfcPkgRemt2000Def("REMT0100");   //그리드 테이블 컬럼 define  
		// private MSFCustomForm msfCustomForm; 
		private MSFGridPanel remt2000DefGridPanel;
			 
		// -- 퇴직금산정 급여내역조회 
		private InfcPkgRemtPayr0100Def remtPayr0100Def  = new InfcPkgRemtPayr0100Def("REMT0100");   //그리드 테이블 컬럼 define  
		// private MSFCustomForm msfCustomForm; 
		private MSFGridPanel remtPayr0100GridPanel;
		      
		// -- 퇴직금산정 복리후생비 
		private InfcPkgRemtWfep0100Def remtWfep0100Def  = new InfcPkgRemtWfep0100Def("REMT0100");   //그리드 테이블 컬럼 define  
		// private MSFCustomForm msfCustomForm; 
		private MSFGridPanel remtWfep0100GridPanel;
		  
//		// -- 퇴직금 지급항목
//		private Remt2000Def remtPymt2000Def  = new Remt2000Def("REMTPYMT0100");   //그리드 테이블 컬럼 define  
//		// private MSFCustomForm msfCustomForm; 
//		private MSFGridPanel remtPymt2000GridPanel;
//	         	     
//		// -- 공제금액 
//		private Remt2300Def remt2300Def  = new Remt2300Def("REMT0100");   //그리드 테이블 컬럼 define  
//		// private MSFCustomForm msfCustomForm; 
//		private MSFGridPanel remt2300GridPanel;
//	
//		// -- 퇴직정산/중도정산처리시  
//		private Remt3100Def remt3100Def  = new Remt3100Def("REMT0100");   //그리드 테이블 컬럼 define  
//		// private MSFCustomForm msfCustomForm; 
//		private MSFGridPanel remt3100GridPanel; 
       
		  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		private ActionDatabase actionDatabase;
		private boolean statCheck = false;
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
		private ButtonBar topPayr8500Bar;
		private Button btnPayr8500Init;		//초기화
	    private Button btnPayr8500Sreach;	//조회
	    private Button btnPayr8500Print;	//퇴직금산정내역서(출력)
	    
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */ 
      
      /** column  년도 : year */
      private ComboBox<BaseModel> srhClutYr;					// 정산년도
      private ComboBox<BaseModel> srhClutMnth;					// 정산월
      private ComboBox<BaseModel> srhCalcSevePayPsnDivCd;		// 정산구분
      private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
      private ComboBox<BaseModel> srhBusinCd;    				// 사업
      private TextField<String> srhHanNm;         				// 성명
      private TextField<String> srhResnRegnNum;   				// 주민번호 
      private HiddenField<String> srhSystemkey;   				// 시스템키
      private ComboBox<BaseModel> srhEmymtDivCd;				// 고용구분 
      private MSFMultiComboBox<ModelData> srhDeptCd ;    		// 부서 
      private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;	// 직종세
      
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      
      private boolean mutilCombo = false;
      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 입력 변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
      private HiddenField<String> systemkey;		/**  column SYSTEMKEY : systemkey */
      private HiddenField<String> dpobCd;			/**  column 사업장코드 : dpobCd */
      private HiddenField<String> clutYrMnth;   	/** column 정산년월 : clutYrMnth */
      private HiddenField<String> pyspGrdeCd;   	/** column 호봉등급코드 : pyspGrdeCd */
      private HiddenField<String> logSvcYrNumCd;	/** column 근속년수코드 : logSvcYrNumCd */
      private HiddenField<String> logSvcMnthIcmCd;	/** column 근속월수코드 : logSvcMnthIcmCd */
      
      // -- 퇴직금산정
      private MSFComboBox<BaseModel> clutYr;   	/** column 정산년 : clutYr */
      private MSFComboBox<BaseModel> clutMnth;	/** column 정산월 : clutMnth */
      private MSFComboBox<BaseModel> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
      private MSFTextField nm;   				/** column 성명 : nm */
      private MSFTextField resnRegnNum;			//주민번호 
      private MSFTextField emymtDivNm;			/** column 고용구분 : emymtDivNm */
      private MSFTextField deptNm;     			/** column 부서 : deptNm    */
      private MSFTextField typOccuNm;   		/** column 직종 : typOccuNm */
      private MSFDateField  icncDt;   			/** column 입사일자 : icncDt */
      private MSFDateField  rkfcdDt;   			/** column 기산일자 : rkfcdDt */
      private MSFDateField  retryDt;   			/** column 퇴직일자 : retryDt */
      private MSFDateField  sevePayPymtDt;   	/** column 퇴직금지급일자 : sevePayPymtDt */
      private MSFCheckBox amcrrClutInsnYn;   	/** column 군경력정산포함여부 : amcrrClutInsnYn */
//      private MSFNumberField logSvcYrNum;   	/** column 근속년수 : logSvcYrNum */
//      private MSFNumberField logSvcMnthIcm;   	/** column 근속월수 : logSvcMnthIcm */
  
      // -- 산정결과
      private MSFDateField payCmpttnBgnnDt;   	/** column 급여산정시작일자 : payCmpttnBgnnDt */
      private MSFDateField payCmpttnEndDt;   	/** column 급여산정종료일자 : payCmpttnEndDt */
      private MSFNumberField marPubcWelfAmnt;   /** column 3월간후생복지비 : marPubcWelfAmnt */
      private MSFNumberField marTotAmntWag;   	/** column 3월간총임금액 : marTotAmntWag */
      private MSFNumberField dayAvgAmntWag;   	/** column 1일평균임금액 : dayAvgAmntWag */
      private MSFNumberField totLogSvcNumDys;   /** column 총근무일수 : totLogSvcNumDys */
      private MSFNumberField seveViewPayAddRate;/** column 퇴직금가산율 : sevePayAddRate */
      private MSFNumberField sevePayCmpttnSum;	/** column 퇴직금산정금액 : sevePayCmpttnSum */
//      private MSFNumberField sevePayAddRate;   	/** column 퇴직금가산율 : sevePayAddRate */
      private MSFNumberField sevePayAddApptnSum;/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
      private MSFNumberField amcrrLogSvcNumDys;	/** column 군경력근무일수 : amcrrLogSvcNumDys */
      private MSFNumberField amcrrAddApptnSum;  /** column 군경력가산적용금액 : amcrrAddApptnSum */
      private MSFNumberField sevePayPymtSum;   	/** column 퇴직금지급액 : sevePayPymtSum */
        
      private boolean boolPymtDduc = false;
     
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
      /**
       * 권한설정 처리 체크 
       * AuthAction 
       */
      	private void checkRemt0100Auth( String authAction, ListStore<BaseModel> bm) {   
      		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
      		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
      			if (!maskTracker) { unmask(); }  
      			authExecEnabled() ;
      			//MSFMainApp.unmaskMainPage();
      		}
      	}
      	private void authExecEnabled() { 
      		//----------------------------------------------------------------------
      		Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
            
      		gwtAuthorization.formAuthFieldConfig(fldArrField);
      		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
               
      		srhClutYr.setValue(lsClutYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
      		srhClutMnth.setValue(lsClutMnth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
             
      		srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(2));
               
      		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
      		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
              // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
              // GWTAuthorization.formAuthPopConfig(plFrmPayr4220, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
              // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			  // gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
      		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
             //  srhDeptCd.fireEvent(Events.Add); 
      		srhDeptCd.getListView().fireEvent(Events.CheckChanged);   
      	}

      	final Timer tmMask = new Timer() {
      		public void run() {
      			if (lsEmymtDivCd.getCount() > 0 ) {
      				cancel();
      				unmask(); 
      				authExecEnabled() ;
      				maskTracker  = true;
      			} else {
      				tmMask.scheduleRepeating(2000);
      			}
      		}
      	}; 
		     
      	private void initLoad() { 

      		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
      		gwtAuthorization = GWTAuthorization.getInstance();
      		gwtExtAuth = GWTExtAuth.getInstance(); 
  			   
      		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();
      		
      		authMapDef.put("srhClutYr", Boolean.FALSE);
      		authMapDef.put("srhClutMnth", Boolean.FALSE);
      		authMapDef.put("srhCalcSevePayPsnDivCd", Boolean.FALSE);
      		authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
      		authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
      		authMapDef.put("srhDeptCd", Boolean.FALSE);
      		// authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
  				 
      		gwtExtAuth.setCheckMapDef(authMapDef);
  		        
      		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
      			//권한 검색조건처리를 위해 추가된 부분 
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
	    private void setRemt0100FormBinding() {
	 	 
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
	private Payr8500ServiceAsync payr8500Service = Payr8500Service.Util.getInstance();
	    
	private ListStore<BaseModel> lsClutYrStore = new ListStore<BaseModel>();	//년도 
	private ListStore<BaseModel> lsClutMnth = new ListStore<BaseModel>();  		//급여월   
	private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>();		//고용구분 
	    
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	         
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	    
	private ListStore<BaseModel>  lsPayrMangDeptCd = new ListStore<BaseModel>();		//단위기관 
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();				//직종 
	private ListStore<BaseModel>  lsCalcSevePayPsnDivCd = new ListStore<BaseModel>(); 	//정산구분
	private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); 		//지급공제구분코드 
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();		//직종세
	   
	    
	private ListStore<BaseModel> lsCrClutYrStore = new ListStore<BaseModel>(); 			// 년도
	private ListStore<BaseModel> lsCrClutMnth = new ListStore<BaseModel>(); 			// 급여월
	private ListStore<BaseModel> lsCrCalcSevePayPsnDivCd = new ListStore<BaseModel>(); 	// 정산구분
	    
	private PrgmComBass0300DTO sysComBass0300Dto;	// 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; 	// 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	// 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; 	// 단위기관
	private SysCoCalendarDTO msfCoCalendarDto; 		// 날짜
	private PrgmComBass0350DTO sysComBass0350Dto; 	// 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; 	// 직종
	    
	private BaseModel record;
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	private Iterator<Record> records;
  	  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
	
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
	private void Remt0100Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "REMT";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
		String serarchParam = "";
     	 
		String year = PayrUtils.getSelectedComboValue(srhClutYr, "year");
		String month = PayrUtils.getSelectedComboValue(srhClutMnth, "month");
		String strCalcSevePayPsnDivCd = PayrUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd, "commCd");
		String pymtYrMnth = year.concat(month);
		String strDpobCd = dpobCd.getValue();
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt", "deptCd");
		String typOccuCd = PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm", "typOccuCd");
		String dtilOccuInttnCd = PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm", "dtilOccuInttnCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
		String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
		String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
	         
				
		serarchParam += "[" + strDpobCd + "]"; 				// $1
		serarchParam += "[" + pymtYrMnth + "]"; 			// $2
		serarchParam += "[" + strCalcSevePayPsnDivCd + "]"; // $3
		serarchParam += "[" + payrMangDeptCd + "]"; 		// $4
		serarchParam += "[" + emymtDivCd + "]"; 			// $5
		serarchParam += "[" + deptCd + "]"; 				// $6
		serarchParam += "[" + typOccuCd + "]"; 				// $7
		serarchParam += "[]"; 								// $8
		serarchParam += "[" + dtilOccuInttnCd + "]"; 		// $9
		serarchParam += "[" + businCd + "]"; 				// $10
			 
		
		List<BaseModel> list = remt2000DefGridPanel.getGrid().getSelectionModel().getSelectedItems();
		String checkedSystemKeys = "";
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
			
		}   //$11
		
		
		serarchParam += "["+checkedSystemKeys+"]";  //$11
	      
		//TODO 확인  출력 확인 해야함 
		if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {

			serarchParam += "[]"; // $12
			serarchParam += "["+ MSFMainApp.get().getUser().getPayrMangDeptYn() + "]"; // $13

		} else {

			serarchParam += "[]";  //$13
		}
	      
			 
		String strParam = "/rp " + serarchParam;
		 
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	}
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	
	
/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/
	public ContentPanel getViewPanel(){
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr8500Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createStandardForm(); 	// 기본정보필드
			occupationalRTop();		// 하단탭
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");
				    
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
	  public Payr8500() {
		  //엣지변환
		  //setSize("1010px", "700px");  
			setSize("1010px", "750px");  
	  } 
	
	  public Payr8500(String txtForm) {
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
	private void createPayr8500Form() {
		  
		plFrmPayr8500 = new FormPanel();
		plFrmPayr8500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  퇴직금산정내역확인"));
		// plFrmPayr8500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여대상자관리");
		plFrmPayr8500.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr8500.setBodyStyleName("pad-text");
		plFrmPayr8500.setPadding(2);
		plFrmPayr8500.setFrame(true);
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("퇴직금산정내역확인","PAYR8500");
				}
			});
		plFrmPayr8500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr8500.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmPayr8500.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						srhDeptCd.showClose(ce);
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
			} 
		});
	        
//		LayoutContainer layoutContainer = new LayoutContainer();
//		layoutContainer.setLayout(new ColumnLayout());
//			  
//		LayoutContainer layoutContainer_1 = new LayoutContainer();
//		layoutContainer_1.setLayout(new FlowLayout());
//
//		ButtonBar buttonBar_1 = new ButtonBar();
//
//		Button btnNewButton_2 = new Button("");
//		buttonBar_1.add(btnNewButton_2);
//
//		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		layoutContainer_1.setBorders(false);
//
//		LayoutContainer layoutContainer_2 = new LayoutContainer();
//		layoutContainer_2.setLayout(new FlowLayout());

		topPayr8500Bar = new ButtonBar();
//		layoutContainer_2.add(topPayr8500Bar);
		topPayr8500Bar.setAlignment(HorizontalAlignment.RIGHT);
			 
		  	
		btnPayr8500Init = new Button("초기화");
		btnPayr8500Init.setIcon(MSFMainApp.ICONS.new16());
		topPayr8500Bar.add(btnPayr8500Init);
		btnPayr8500Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 초기화
				formInit();
			}
		}); 
			  	
			  	 
		btnPayr8500Sreach = new Button("조회");
		btnPayr8500Sreach.setIcon(MSFMainApp.ICONS.search16());
		topPayr8500Bar.add(btnPayr8500Sreach);
		btnPayr8500Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});
			  	
		btnPayr8500Print = new Button("퇴직금산정내역서");
		btnPayr8500Print.setIcon(MSFMainApp.ICONS.search16());
		topPayr8500Bar.add(btnPayr8500Print);
		btnPayr8500Print.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Remt0100Print("REMTT0100");
			}
		});
			  	
			  	
//		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//		layoutContainer_2.setBorders(false);
//		layoutContainer.setBorders(false);
//		  	
//		plFrmPayr8500.add(layoutContainer);    
		
		plFrmPayr8500.add(topPayr8500Bar);  
		  	  
		  	
		// 파일업로드 처리
		plFrmPayr8500.setAction("bizform");
		plFrmPayr8500.setEncoding(Encoding.MULTIPART);
		plFrmPayr8500.setMethod(Method.POST);
			
		vp.add(plFrmPayr8500);
		//엣지변환
		//plFrmPayr8500.setSize("990px", "690px");
		plFrmPayr8500.setSize("990px", "740px");
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
 /**
  * 검색필드 설정
  */
	private void createSearchForm() {   
      

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
     
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		// -- 정산구분 
		sysComBass0300Dto.setRpsttvCd("B027");
		lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);

		// -- 고용구분
		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
     
		//월 
		lsClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     
     
 		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
        

		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
     
		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
     
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});     
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------
      
             
		//--------------------직종 불러 오는 함수 ------------------------------------------------  
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});   
		//--------------------직종 불러 오는 함수 ------------------------------------------------  
  
		plFrmPayr8500.setLayout(new FlowLayout());
		srhSystemkey = new HiddenField<String>();
      
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
		
		// fieldSet.setCheckboxToggle(false); 
    
		LayoutContainer lcSchLeft = new LayoutContainer();
		// lcSchLeft.setStyleAttribute("paddingRight", "10px");
   

		fieldSet.add(lcSchCol, new FormData("100%"));
		lcSchLeft.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);
    
		srhClutYr = new ComboBox<BaseModel>();
		srhClutYr.setName("srhClutYr");
		srhClutYr.setForceSelection(true);
		srhClutYr.setMinChars(1);
		srhClutYr.setDisplayField("yearDisp");
		srhClutYr.setValueField("year");
		srhClutYr.setTriggerAction(TriggerAction.ALL);
		// srhClutYr.setEmptyText("--년도선택--");
		srhClutYr.setSelectOnFocus(true);
		srhClutYr.setReadOnly(false);
		srhClutYr.setEnabled(true);
		srhClutYr.setStore(lsClutYrStore);
		srhClutYr.setFieldLabel("정산년월");
		srhClutYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {   
				checkRemt0100Auth("srhClutYr", lsClutYrStore);
          
			}
		});
		srhClutYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmClutYr =  se.getSelectedItem(); 
				
				if (bmClutYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)  
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                   
						if (srhDeptCd.getListView().getChecked().size() > 0) {  
                      
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year"));
							List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
							sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
						}      
                
						//--------------------사업 불러 오는 함수 -------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						//--------------------사업 불러 오는 함수 -------------------------------------------------
						
						srhBusinCd.setStore(lsBusinCd); 
						srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
							public void handleEvent(StoreEvent<BaseModel> be) {  
                          //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
							}
						});    
					} else {
						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
						//return;
					} 
				}       
			} 
		});   
		layoutContainer_8.add(srhClutYr, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		layoutContainer_8.setBorders(false);
    
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSch);
    
		/** column 지급년월 : Mnth */
		srhClutMnth = new ComboBox<BaseModel>();
		srhClutMnth.setName("srhClutMnth");
		srhClutMnth.setForceSelection(true);
		srhClutMnth.setMinChars(1);
		srhClutMnth.setDisplayField("monthDisp");
		srhClutMnth.setValueField("month");
		srhClutMnth.setTriggerAction(TriggerAction.ALL);
		// srhClutMnth.setEmptyText("--월선택--");
		srhClutMnth.setSelectOnFocus(true);
		srhClutMnth.setStore(lsClutMnth);
		srhClutMnth.setHideLabel(true);
		srhClutMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				checkRemt0100Auth("srhClutMnth", lsClutMnth);
			}
		});
		layoutContainer_9.add(srhClutMnth, new FormData("100%"));
		lcSchLeft.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_9.setBorders(false);
    
		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(70); 
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
		lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	    				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkRemt0100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
           	 	}
			}
		});    
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				
				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
				//--------------------부서 불러 오는 함수 ------------------------------------------------
				
				lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});  
			} 
		});
		layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
		layoutContainer.setBorders(false);

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);
    
		srhCalcSevePayPsnDivCd = new ComboBox<BaseModel>();
		srhCalcSevePayPsnDivCd.setName("srhCalcSevePayPsnDivCd");
		srhCalcSevePayPsnDivCd.setForceSelection(true);
		srhCalcSevePayPsnDivCd.setMinChars(1);
		srhCalcSevePayPsnDivCd.setDisplayField("commCdNm");
		srhCalcSevePayPsnDivCd.setValueField("commCd");
		srhCalcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
		srhCalcSevePayPsnDivCd.setEmptyText("--정산구분선택--");
		srhCalcSevePayPsnDivCd.setSelectOnFocus(true);
		srhCalcSevePayPsnDivCd.setReadOnly(false);
		srhCalcSevePayPsnDivCd.setEnabled(true);
		srhCalcSevePayPsnDivCd.setStore(lsCalcSevePayPsnDivCd);
		srhCalcSevePayPsnDivCd.setFieldLabel("정산구분");
		srhCalcSevePayPsnDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				checkRemt0100Auth("srhCalcSevePayPsnDivCd", lsCalcSevePayPsnDivCd); 
			}
		});    
		layoutContainer_14.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
   
		layoutContainer_14.setBorders(false);

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
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
					fnPopupPsnl0100();
		        }
		        
		        if (event.getKeyCode() == KeyCodes.KEY_BACKSPACE) {
		        	srhSystemkey.setValue("");
		        	srhResnRegnNum.setValue("");
		        }
		        
		        super.componentKeyDown(event);
			}
		});
		
//		srhHanNm.addKeyListener(new KeyListener() {
//			public void componentKeyUp(ComponentEvent event) {
//				super.componentKeyUp(event);
//				srhHanNm.validate();
//				
//				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
//					srhSystemkey.setValue("");
//					srhResnRegnNum.setValue("");
//					fnPopupPsnl0100();
//				}
//			}
//		});
//		srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//					srhSystemkey.setValue("");
//					srhResnRegnNum.setValue("");
//				}
//			}
//		});
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
		layoutContainer_6.setBorders(false);
    
		Button btnHanNm = new Button("검색");
		layoutContainer_5.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();

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
				if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim()
						.equals("")) {
					srhSystemkey.setValue("");
					srhHanNm.setValue("");
				}

			}
		});
		layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer_7.setBorders(false);
		layoutContainer_5.setBorders(false);
    
		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
		lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_13.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);
    
		srhEmymtDivCd = new ComboBox<BaseModel>();
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
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	  					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						checkRemt0100Auth("srhEmymtDivCd", lsEmymtDivCd); 
				}
			}
		});    
		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					srhDeptCd.getListView().fireEvent(Events.CheckChanged);
					srhBusinCd.setEnabled(true);
					srhTypOccuCd.reset();
					srhTypOccuCd.setEnabled(false);
					srhDtilOccuInttnCd.reset();
					srhDtilOccuInttnCd.setEnabled(false);
				} else if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
					// 20151130 추가 수정
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
		layoutContainer_1.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer_1.setBorders(false);
    
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
    
		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.getStore().add(mDtalistDeptCd);
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	    				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						checkRemt0100Auth("srhDeptCd", lsDeptCd); 
           	 	}
			}
		});    

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if ((srhDeptCd.getListView().getChecked().size() == 1)  
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {  
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year"));    
						List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
					}      
                   
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					srhBusinCd.setStore(lsBusinCd); 
					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
							//   searchBusinCd.setValue(lsBusinCd.getAt(0));  
						}
					}); 
				} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	            		 
					//2015.11.30 권한 직종가져오기  추가 
           		   	sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
           		   	String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
           		   	sysComBass0320Dto.setDeptCd(strDeptCd);
           		   	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
           		   	
           		   	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
           		   		public void handleEvent(StoreEvent<BaseModel> be) {  
                            mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                            srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                          }
                      });  
				} else {
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		       		String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		       		sysComBass0320Dto.setDeptCd(strDeptCd);
		        	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		     		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		     			public void handleEvent(StoreEvent<BaseModel> be) {  
		     				mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		     				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		     			}
		     		});   
				}
			}  
		});  
     
		srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
         
		layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);
    
		// 직종 직종세처리
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());
       
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);
    
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		srhTypOccuCd.setFieldLabel("직종");
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
        	
        	  EventType type = be.getType();
        	  if (type == Store.Add) { 
        		  //2015.11.30 추가 
        		  if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
        			  if (!gwtExtAuth.getEnableTypOccuCd()) {
        				  ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0); 
        				  srhTypOccuCd.getListView().setChecked(mdSelect, true); 
	                      srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
        			  }  
        		  }
        		  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        		   * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
        		   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
        		   * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	    			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
        		  //checkRemt0100Auth("srhTypOccuCd", lsTypOccuCd); 
        	  }
			}
		});     
    
		srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				// 2015.11.30 추가
				displayDtilOccuInttnCd();
			}
		});
     
		srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
    
		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));

		lcTypOccuCd.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		lcTypOccuCd.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_21.setBorders(false);
    
		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_13.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
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
		srhBusinCd.getListView().setWidth("200px");
		srhBusinCd.setStore(lsBusinCd);
		srhBusinCd.setFieldLabel("사업");
		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		layoutContainer_4.setBorders(false);
		fieldSet.add(layoutContainer_13);
		layoutContainer_13.setBorders(false);
     
	    plFrmPayr8500.add(fieldSet); 
	}  
 

	private void  displayDtilOccuInttnCd() {
	  
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
         
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);
			
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
             
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
             
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
		
		dpobCd 			= new HiddenField<String>();	//사업장코드 
        systemkey 		= new HiddenField<String>();	//시스템키 
        pyspGrdeCd 		=  new HiddenField<String>();	//호봉등급
        logSvcYrNumCd 	=  new HiddenField<String>();	/** column 근속년수코드 : logSvcYrNumCd */
        logSvcMnthIcmCd	=  new HiddenField<String>();	/** column 근속월수코드 : logSvcMnthIcmCd */
        clutYrMnth 		=   new HiddenField<String>(); 
     
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        //정산구분 
        sysComBass0300Dto.setRpsttvCd("B027");
        lsCrCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        
        //월 
        lsCrClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------

        
        //--------------------급여년도 불러 오는 함수 ------------------------------------------------
        lsCrClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
        //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
     
        
        LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		//fldstNewFieldset.setSize("330px", "505px");
		
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("대상자정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.36));
		layoutContainer_1.setBorders(false);
		
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		//frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("퇴직금산정");
		fldstNewFieldset_1.setCollapsible(false);
		//fldstNewFieldset_1.setSize(622, 540);
		 
		layoutContainer_2.add(fldstNewFieldset_1,new FormData("100%"));
		 
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.64));
		layoutContainer_2.setBorders(false);
		  
		plFrmPayr8500.add(layoutContainer);
		layoutContainer.setBorders(false); 
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
	//하단 탭
	private void occupationalRTop() {
	  
      
		LayoutContainer layoutContainer_37 = new LayoutContainer();
		layoutContainer_37.setLayout(new FlowLayout());
		   
		layoutContainer_37.add(rightForm01()); 
		layoutContainer_37.setBorders(false); 
	     
		fldstNewFieldset_1.add(layoutContainer_37);
      
     
		tabsRemtTop = new TabPanel(); //퇴직금계산을 위한 tab 
		//tabsRemtSub.setMinTabWidth(80);   
		tabsRemtTop.setAutoWidth(false);
	    // tabsRemtSub.setResizeTabs(true);   
		tabsRemtTop.setAnimScroll(true);   
		tabsRemtTop.setTabScroll(true); 
		tabsRemtTop.setPlain(true);   
		tabsRemtTop.setSize(597, 400);    
     
		TabItem itemTop01 = new TabItem();
		itemTop01.setStyleAttribute("padding", "3px");
		itemTop01.setText("퇴직금계산");
		// itemTop01.addStyleName("pad-text");
		itemTop01.setLayout(new FormLayout());
		itemTop01.add(DataTop01(), new FormData("100%"));
		itemTop01.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 퇴직금계산결과
				reloadRemt2000();
			}
		});
		tabsRemtTop.add(itemTop01);  
       
		fldstNewFieldset_1.add(tabsRemtTop,new FormData("100%"));  
	}
 
 

	private LayoutContainer rightForm01() { 
	
		dpobCd = new HiddenField<String>();    /** column 사업장코드 : dpobCd */
		systemkey = new HiddenField<String>(); /** column SYSTEMKEY : systemkey */
	 
		LayoutContainer layoutContainer = new LayoutContainer();   
    
		ContentPanel cp02 = new ContentPanel();
		cp02.setHeaderVisible(false);
		cp02.setSize(600, 158);
		cp02.setLayout(new FlowLayout());
     
		LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setBorders(false);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(40);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytStd);

		LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		layoutContainer_1_1.setLayout(new ColumnLayout());
     
		LayoutContainer   layoutContainer_13 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_13.setLayout(frmlytSch); 
     
		clutYr = new MSFComboBox<BaseModel>();
		clutYr.setName("clutYr");
		clutYr.setForceSelection(true);
		clutYr.setMinChars(1);
		clutYr.setDisplayField("yearDisp");
		clutYr.setValueField("year");
		clutYr.setTriggerAction(TriggerAction.ALL);
		clutYr.setEmptyText("----");
		clutYr.setSelectOnFocus(true);
		clutYr.setReadOnly(true);
		clutYr.setStore(lsCrClutYrStore);
		layoutContainer_13.add(clutYr, new FormData("100%"));
		clutYr.setFieldLabel("정산년월");
		layoutContainer_13.setBorders(false);
     
		layoutContainer_1_1.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
     
		LayoutContainer layoutContainer_2_3 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2_3.setLayout(frmlytSch); 
     
		clutMnth = new MSFComboBox<BaseModel>();
		clutMnth.setName("clutMnth");
		clutMnth.setForceSelection(true);
		clutMnth.setMinChars(1);
		clutMnth.setDisplayField("monthDisp");
		clutMnth.setValueField("month");
		clutMnth.setTriggerAction(TriggerAction.ALL);
		clutMnth.setEmptyText("----");
		clutMnth.setSelectOnFocus(true);
		clutMnth.setReadOnly(true);
		clutMnth.setStore(lsCrClutMnth);
		layoutContainer_2_3.add(clutMnth, new FormData("100%"));
		clutMnth.setHideLabel(true);
		clutMnth.setBorders(false);
      
     
		layoutContainer_1_1.add(layoutContainer_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_1_1.setBorders(false);
     
		layoutContainer_5.add(layoutContainer_1_1, new FormData("100%"));
     
		layoutContainer_6.add(layoutContainer_5 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3) );
     
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytSch);
  
		/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		calcSevePayPsnDivCd = new MSFComboBox<BaseModel>();
		calcSevePayPsnDivCd.setName("calcSevePayPsnDivCd");
		calcSevePayPsnDivCd.setForceSelection(true);
		calcSevePayPsnDivCd.setMinChars(1);
		calcSevePayPsnDivCd.setDisplayField("commCdNm");
		calcSevePayPsnDivCd.setValueField("commCd");
		calcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
		calcSevePayPsnDivCd.setEmptyText("----");
		calcSevePayPsnDivCd.setSelectOnFocus(true);
		calcSevePayPsnDivCd.setReadOnly(true);
		calcSevePayPsnDivCd.setStore(lsCrCalcSevePayPsnDivCd);
		layoutContainer_2_1.add(calcSevePayPsnDivCd, new FormData("100%"));
		calcSevePayPsnDivCd.setFieldLabel("정산구분");
		layoutContainer_6.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_2_1.setBorders(false);
     
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
     
		nm = new MSFTextField();
	    nm.setReadOnly(true);
	    layoutContainer_3.add(nm, new FormData("100%"));
	    nm.setFieldLabel("성명");
	    layoutContainer_6.add(layoutContainer_3 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 
     
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
     
		resnRegnNum = new MSFTextField();
		resnRegnNum.setReadOnly(true);
		layoutContainer_4.add(resnRegnNum, new FormData("100%"));
		resnRegnNum.setHideLabel(true);
		layoutContainer_6.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));
      
		cp02.add(layoutContainer_6);  
     

		LayoutContainer layoutContainer71 = new LayoutContainer();
		layoutContainer71.setLayout(new ColumnLayout());
     
		LayoutContainer layoutContainer_61 = new LayoutContainer();
		layoutContainer_61.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_61.setLayout(frmlytStd);
     
		emymtDivNm = new MSFTextField();
		emymtDivNm.setReadOnly(true);
		layoutContainer_61.add(emymtDivNm, new FormData("100%"));
		emymtDivNm.setFieldLabel("고용구분");
		layoutContainer71.add(layoutContainer_61,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     
		LayoutContainer layoutContainer_62 = new LayoutContainer();
		layoutContainer_62.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_62.setLayout(frmlytStd);
     
		deptNm = new MSFTextField();
		deptNm.setReadOnly(true);
		layoutContainer_62.add(deptNm, new FormData("100%"));
		deptNm.setFieldLabel("부서");
		layoutContainer71.add(layoutContainer_62,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
     
		LayoutContainer layoutContainer_69 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_69.setLayout(frmlytStd);
     
		typOccuNm = new MSFTextField();
		typOccuNm.setReadOnly(true);
		layoutContainer_69.add(typOccuNm, new FormData("100%"));
		typOccuNm.setFieldLabel("직종(사업)");
		layoutContainer71.add(layoutContainer_69, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));
		layoutContainer_69.setBorders(false);
		cp02.add(layoutContainer71);
     
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setLayout(new ColumnLayout());
     
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
     
		icncDt = new MSFDateField();
		icncDt.setReadOnly(true);
		new DateFieldMask(icncDt, "9999.99.99");
		icncDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		icncDt.setName("icncDt");
		icncDt.setAllowBlank(false);
		layoutContainer_1.add(icncDt, new FormData("100%"));
		icncDt.setFieldLabel("입사일자");
		layoutContainer7.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
     
		rkfcdDt = new MSFDateField();
		new DateFieldMask(rkfcdDt, "9999.99.99");
		rkfcdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		rkfcdDt.setName("rkfcdDt");
		rkfcdDt.setAllowBlank(false);
		layoutContainer_2.add(rkfcdDt, new FormData("100%"));
		rkfcdDt.setFieldLabel("기산일자");
		layoutContainer7.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
     
		retryDt = new MSFDateField();
		new DateFieldMask(retryDt, "9999.99.99");
		retryDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		retryDt.setName("retryDt");
		retryDt.setAllowBlank(false);
		layoutContainer_9.add(retryDt, new FormData("100%"));
		retryDt.setFieldLabel("퇴사일자");
		layoutContainer7.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainer_9.setBorders(false);
		cp02.add(layoutContainer7);
     
     
		LayoutContainer layoutContainer_51 = new LayoutContainer();
		layoutContainer_51.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_51.setLayout(frmlytStd);

		amcrrClutInsnYn = new MSFCheckBox();
		layoutContainer_51.add(amcrrClutInsnYn, new FormData("100%"));
		amcrrClutInsnYn.setFieldLabel("군경력");
		// amcrrClutInsnYn.setBoxLabel("군경력");
		layoutContainer7.add(layoutContainer_51,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
      
		/**-----------------------------------------------
		 * 지급일자 시작 
		----------------------------------------------*/ 
		LayoutContainer layoutContainerd7 = new LayoutContainer();
		layoutContainerd7.setLayout(new ColumnLayout());
     
		LayoutContainer layoutContainerd_1 = new LayoutContainer();
		layoutContainerd_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_1.setLayout(frmlytStd);
      
		sevePayPymtDt = new MSFDateField();
		new DateFieldMask(sevePayPymtDt, "9999.99.99");
		sevePayPymtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		sevePayPymtDt.setName("rkfcdDt");
		sevePayPymtDt.setAllowBlank(false);
		layoutContainerd_1.add(sevePayPymtDt, new FormData("100%"));
		sevePayPymtDt.setFieldLabel("지급일자");
		layoutContainerd7.add(layoutContainerd_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainerd_2 = new LayoutContainer();
		layoutContainerd_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_2.setLayout(frmlytStd);
    
		layoutContainerd7.add(layoutContainerd_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainerd_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_9.setLayout(frmlytStd);
      
		layoutContainerd7.add(layoutContainerd_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainerd_9.setBorders(false);
		cp02.add(layoutContainerd7);
     
     
		LayoutContainer layoutContainerd_51 = new LayoutContainer();
		layoutContainer_51.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_51.setLayout(frmlytStd);
      
		layoutContainerd7.add(layoutContainerd_51,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
	/**-----------------------------------------------
	 * 지급일자 종료
	----------------------------------------------*/ 

		layoutContainer.add(cp02) ;   
     
		return layoutContainer;
	}
 
	private  LayoutContainer DataTop01() {
    

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		tabsRemtSub = new TabPanel(); 		//퇴직금 계산 tab 
		//tabsRemtSub.setMinTabWidth(80);   
		tabsRemtSub.setAutoWidth(false);
		// tabsRemtSub.setResizeTabs(true);   
		tabsRemtSub.setAnimScroll(true);   
		tabsRemtSub.setTabScroll(true);
		tabsRemtSub.setPlain(true);
		tabsRemtSub.setSize(583, 312);
    
		TabItem item01 = new TabItem();
		// item01.setStyleAttribute("padding", "10px");
		item01.setText("산정결과");
		item01.addStyleName("pad-text");
		item01.setLayout(new FormLayout());
		item01.add(Data01(), new FormData("100%"));
		tabsRemtSub.add(item01);
		item01.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 산정결과 탭을 누른경우에 데이터를 리로딩한다.

			}
		});

		TabItem item02 = new TabItem();
		// item02.setStyleAttribute("padding", "10px");
		item02.setText("급여내역");
		item02.setLayout(new FormLayout());
		item02.add(Data02(), new FormData("100%"));
		tabsRemtSub.add(item02);
		item02.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 급여내역에 대한 지급기간 데이터를 가지고와 헤더셋팅하는 부분 추가
				reloadPayrRemt0100Header();

			}
		});
 

		TabItem item03 = new TabItem();
		// item03.setStyleAttribute("padding", "10px");
		item03.setText("후생복지비");
		item03.setLayout(new FormLayout());
		item03.add(Data03(), new FormData("100%"));
		tabsRemtSub.add(item03);
		item03.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 후생복지비
				reloadRemt210002();

			}
		});
  
		lcTabFormLayer.add(tabsRemtSub, new FormData("100%"));

		return lcTabFormLayer;
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
 private LayoutContainer occupationalLeft() {
	   
	   LayoutContainer lcTabFormLayer = new LayoutContainer(new FitLayout());
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(315, 508);  
//	   
	   
	//msfCustomForm.setHeaderVisible(false);
    //Instantiate the GridPanel
	   remt2000DefGridPanel = new MSFGridPanel(remt2000Def, false, false, false, false);
	   remt2000DefGridPanel.setHeaderVisible(false);  
	   remt2000DefGridPanel.setBodyBorder(true);
	   remt2000DefGridPanel.setBorders(true);
	//   remt2000DefGridPanel.setSize(308, 466); 
 //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

	   final Grid remt2000DefGrid = remt2000DefGridPanel.getMsfGrid().getGrid();
       remt2000DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
          public void handleEvent(BaseEvent be) {  
        	  if (remt2000DefGridPanel.getCurrentlySelectedItem() != null) { 
        		  BaseModel bmData = new BaseModel();
        		  
        		  bmData = remt2000DefGridPanel.getCurrentlySelectedItem();
        		   
        		  dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
        		  systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
        	      clutYrMnth.setValue(MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")));   /** column 정산년월 : clutYrMnth */
        	      calcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("calcSevePayPsnDivCd"))));   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        	    
        	      clutYr.setValue(lsCrClutYrStore.findModel("year",MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")).substring(0, 4)) );   /** column 정산년 : clutYr */
        	      clutMnth.setValue(lsCrClutMnth.findModel("month",MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")).substring(4, 6)) );   /** column 정산월 : clutMnth */
        	      reloadRemt2000();
        	   } 
        	    tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
        	    tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
        	    
        	  
	       }
	  });  
	   
	   cp01.add(remt2000DefGridPanel); 
	    
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;  
	   
}
 
	   
 	//산정결과
	private LayoutContainer Data01() { 

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FlowLayout(5));
		cp01.setSize(558, 287);

		cp01.add(DataRemt2000());

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	} 
	 
	 
	private LayoutContainer DataRemt2000() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(555, 283);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);
	     
		payCmpttnBgnnDt = new MSFDateField();
		payCmpttnBgnnDt.setReadOnly(true);
		new DateFieldMask(payCmpttnBgnnDt, "9999.99.99");
		payCmpttnBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		payCmpttnBgnnDt.setName("payCmpttnBgnnDt");
		payCmpttnBgnnDt.setAllowBlank(false);
		layoutContainer_6.add(payCmpttnBgnnDt, new FormData("100%"));
		payCmpttnBgnnDt.setFieldLabel("급여산정기간");
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_6.setBorders(false);
	     
		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(20);
		frmlytStd.setLabelSeparator("");
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
	     
		payCmpttnEndDt = new MSFDateField();
		payCmpttnEndDt.setReadOnly(true);
		new DateFieldMask(icncDt, "9999.99.99");
		payCmpttnEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		payCmpttnEndDt.setName("payCmpttnEndDt");
		payCmpttnEndDt.setAllowBlank(false);
		layoutContainer_7.add(payCmpttnEndDt, new FormData("100%"));
		payCmpttnEndDt.setFieldLabel("~");
		layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
	     
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.30));
		layoutContainer_8.setBorders(false);

		lytCtr01.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytStd);
	     
		/** column 3월간후생복지비 : marPubcWelfAmnt */
		marPubcWelfAmnt = new MSFNumberField();
		marPubcWelfAmnt.setReadOnly(true);
		marPubcWelfAmnt.setAllowDecimals(true);
		marPubcWelfAmnt.setPropertyEditorType(Long.class);
		marPubcWelfAmnt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_18.add(marPubcWelfAmnt, new FormData("100%"));
		marPubcWelfAmnt.setFieldLabel("3개월간후생복지비");
		layoutContainer_9.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_18.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		marTotAmntWag = new MSFNumberField();
		marTotAmntWag.setReadOnly(true);
		marTotAmntWag.setAllowDecimals(true);
		marTotAmntWag.setPropertyEditorType(Long.class);
		marTotAmntWag.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_10.add(marTotAmntWag, new FormData("100%"));
		marTotAmntWag.setFieldLabel("3개월간총임금액");
		layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_10.setBorders(false);
	     
	      
		lytCtr01.add(layoutContainer_9);
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);

		dayAvgAmntWag = new MSFNumberField();
		dayAvgAmntWag.setReadOnly(true);
		dayAvgAmntWag.setAllowDecimals(true);
		dayAvgAmntWag.setPropertyEditorType(Long.class);
		dayAvgAmntWag.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_13.add(dayAvgAmntWag, new FormData("100%"));
		dayAvgAmntWag.setFieldLabel("일평균임금액");
		layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_13.setBorders(false);
	     
 
		lytCtr01.add(layoutContainer_12);
		layoutContainer_12.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		totLogSvcNumDys = new MSFNumberField();
		totLogSvcNumDys.setReadOnly(true);
		totLogSvcNumDys.setAllowDecimals(true);
		totLogSvcNumDys.setPropertyEditorType(Long.class);
		totLogSvcNumDys.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_3.add(totLogSvcNumDys, new FormData("100%"));
		totLogSvcNumDys.setFieldLabel("근속일수");
	     
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
	     
		/** column 퇴직금산정금액 : sevePayCmpttnSum */
		sevePayCmpttnSum = new MSFNumberField();
		sevePayCmpttnSum.setReadOnly(true);
		sevePayCmpttnSum.setAllowDecimals(true);
		sevePayCmpttnSum.setPropertyEditorType(Long.class);
		sevePayCmpttnSum.setFormat(NumberFormat.getDecimalFormat());
		sevePayCmpttnSum.setFieldLabel("퇴직금액");
		layoutContainer_4.add(sevePayCmpttnSum, new FormData("100%"));
	     
		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_4.setBorders(false);

		lytCtr01.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
	     
		FieldSet subFdSet01 = new FieldSet();
		subFdSet01.setTitle("퇴직금가산");
		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		layoutContainer2_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer3_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(145);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_1.setLayout(frmlytStd);
	      
		seveViewPayAddRate = new MSFNumberField();
		seveViewPayAddRate.setReadOnly(true);
		seveViewPayAddRate.setAllowDecimals(true);
		seveViewPayAddRate.setPropertyEditorType(Double.class);
		seveViewPayAddRate.setFormat(NumberFormat.getDecimalFormat());
		seveViewPayAddRate.setFieldLabel("퇴직금가산율");
		layoutContainer3_1.add(seveViewPayAddRate, new FormData("100%"));
 	        
	   
		layoutContainer2_1.add(layoutContainer3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer3_1.setBorders(false);

		LayoutContainer layoutContainer4_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_1.setLayout(frmlytStd);
	     
		/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
		sevePayAddApptnSum = new MSFNumberField();
		sevePayAddApptnSum.setReadOnly(true);
		sevePayAddApptnSum.setAllowDecimals(true);
		sevePayAddApptnSum.setPropertyEditorType(Long.class);
		sevePayAddApptnSum.setFormat(NumberFormat.getDecimalFormat());
		sevePayAddApptnSum.setFieldLabel("근무연수가산금");
		layoutContainer4_1.add(sevePayAddApptnSum, new FormData("100%"));
	     
		layoutContainer2_1.add(layoutContainer4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer4_1.setBorders(false);
	     
		subFdSet01.add(layoutContainer2_1);

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(145);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3_1.setLayout(frmlytStd);
	      
		/** column 군경력근무일수 : amcrrLogSvcNumDys */
		amcrrLogSvcNumDys = new MSFNumberField();
		amcrrLogSvcNumDys.setReadOnly(true);
		amcrrLogSvcNumDys.setAllowDecimals(true);
		amcrrLogSvcNumDys.setPropertyEditorType(Long.class);
		amcrrLogSvcNumDys.setFormat(NumberFormat.getDecimalFormat());
		amcrrLogSvcNumDys.setFieldLabel("군경력일수");
		layoutContainer_3_1.add(amcrrLogSvcNumDys, new FormData("100%"));
 	        
	   
		layoutContainer_2_1.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_3_1.setBorders(false);

		LayoutContainer layoutContainer_4_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4_1.setLayout(frmlytStd);

		/** column 군경력가산적용금액 : amcrrAddApptnSum */
		amcrrAddApptnSum = new MSFNumberField();
		amcrrAddApptnSum.setReadOnly(true);
		amcrrAddApptnSum.setAllowDecimals(true);
		amcrrAddApptnSum.setPropertyEditorType(Long.class);
		amcrrAddApptnSum.setFormat(NumberFormat.getDecimalFormat());
		amcrrAddApptnSum.setFieldLabel("군경력가산금");
		layoutContainer_4_1.add(amcrrAddApptnSum, new FormData("100%"));

		layoutContainer_2_1.add(layoutContainer_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_4_1.setBorders(false);

		subFdSet01.add(layoutContainer_2_1);
		lytCtr01.add(subFdSet01);
		layoutContainer_2_1.setBorders(false);

		LayoutContainer layoutContainer_121 = new LayoutContainer();
		layoutContainer_121.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_131 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_131.setLayout(frmlytStd);

		/** column 퇴직금지급액 : sevePayPymtSum */
		sevePayPymtSum = new MSFNumberField();
		sevePayPymtSum.setReadOnly(true);
		sevePayPymtSum.setAllowDecimals(true);
		sevePayPymtSum.setPropertyEditorType(Long.class);
		sevePayPymtSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_131.add(sevePayPymtSum, new FormData("100%"));
		sevePayPymtSum.setFieldLabel("퇴직금지급액");
		layoutContainer_121.add(layoutContainer_131, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_131.setBorders(false);

		lytCtr01.add(layoutContainer_121);
		layoutContainer_121.setBorders(false);
		
		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	 
	//급여내역
	private LayoutContainer Data02() { 

		LayoutContainer lcTabFormLayer = new LayoutContainer(); 

		ContentPanel cp01 = new ContentPanel();   
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(583, 287);  
	  	    
		remtPayr0100GridPanel = new MSFGridPanel(remtPayr0100Def, false, false,false, false, false);
		remtPayr0100GridPanel.setHeaderVisible(false);
		remtPayr0100GridPanel.setBodyBorder(true);
		remtPayr0100GridPanel.setBorders(true);
	  
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM01).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM02).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM03).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM04).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT01).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT02).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT03).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT04).setStyle("background-color:#F5F6CE;");
	       
		AggregationRowConfig<BaseModel> remtPayr0100SummaryRow = new AggregationRowConfig<BaseModel>();  
		
		remtPayr0100SummaryRow.setCellStyle(InfcPkgRemtPayr0100BM.ATTR_PAYITEMNM,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT01,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT02,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT03,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT04,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(InfcPkgRemtPayr0100BM.ATTR_ITEMTOTAMNT,"summary_color");
		   //  String htmlAttr = "<span style='background-color:yellow; background-repeat: no-repeat;'>합 계</span>" ;
		    
		remtPayr0100SummaryRow.setHtml(InfcPkgRemtPayr0100BM.ATTR_PAYITEMNM, "계");   
		    
		// with summary type and format  
		remtPayr0100SummaryRow.setSummaryType(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT01, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT01, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT02, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT02, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT03, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT03, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT04, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT04, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(InfcPkgRemtPayr0100BM.ATTR_ITEMTOTAMNT, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(InfcPkgRemtPayr0100BM.ATTR_ITEMTOTAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
		      
		remtPayr0100GridPanel.getGrid().getColumnModel().addAggregationRow(remtPayr0100SummaryRow);    
	       
		cp01.add(remtPayr0100GridPanel);  
		 
		//급여내역
	    cp01.addButton(new Button("퇴직금재산정", new SelectionListener<ButtonEvent>() {   
	    	@Override  
	    	public void componentSelected(ButtonEvent ce) {   
	    		MessageBox.confirm("급여내역 퇴직금재산정", "급여내역 퇴직금 재산정을 하시겠습니까?<br>(급여내역 변경에 따른 재계산)",new Listener<MessageBoxEvent>(){
	    			@Override
	    			public void handleEvent(MessageBoxEvent be) {
	    				//if("Yes".equals(be.getButtonClicked().getText())){
	    				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	    	                
	    					Iterator<BaseModel> itBm  = remtPayr0100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  
	    	  	          	List<Record>  lsRec  = new ArrayList<Record>();
	    	  	          
	    	  	          	while(itBm.hasNext()) {
	    	  	          		Record rec  = new Record(itBm.next()); 
	    	  	          		lsRec.add(rec);
	    	  	          	} 
	    	  	          	setListRecord(lsRec.iterator()); 
	    	  	          	Iterator<Record> iterRecords = getListRecord();
	    	  	          
	    	                List<InfcPkgRemt2200DTO> listRemt2200dto = new ArrayList<InfcPkgRemt2200DTO>();  
	    	              
	    	                while (iterRecords.hasNext()) {
	    	            
	    	                	Record recData = (Record) iterRecords.next(); 
	    	                	BaseModel bmMapModel = (BaseModel)recData.getModel();
	    	                    
	    	                	InfcPkgRemt2200DTO remt2200Dto = new InfcPkgRemt2200DTO(); 
	    	                 
	    	                	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** column 사업장코드 : dpobCd */
	    	                	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	    	                	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    	/** column 정산년월 : clutYrMnth */
	    	                	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    	/** column 급여항목코드 : payItemCd */
	    	                	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    	/** column 수당그룹코드 : extpyGrpCd */
	    	                	remt2200Dto.setSevePayDtlPatrNum(1L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm01")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt01"));	/** column 지급금액 : pymtSum */
	    	  				  
	    	                	listRemt2200dto.add(remt2200Dto);
	    	                  
	    	                	remt2200Dto = new InfcPkgRemt2200DTO();
	    	                  
	    	                	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
	    	                	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	    	                	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    	/** column 정산년월 : clutYrMnth */
	    	                	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    	/** column 급여항목코드 : payItemCd */
	    	                	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    	/** column 수당그룹코드 : extpyGrpCd */
	    	                	remt2200Dto.setSevePayDtlPatrNum(2L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                  	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm02")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                  	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt02"));    /** column 지급금액 : pymtSum */
	    	  				  
	    	                  	listRemt2200dto.add(remt2200Dto);
	    	                  
	    	                  	remt2200Dto = new InfcPkgRemt2200DTO();
	    	                  
	    	                  	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
	    	                  	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	    	                  	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    	/** column 정산년월 : clutYrMnth */
	    	                  	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                  	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    	/** column 급여항목코드 : payItemCd */
	    	                  	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    	/** column 수당그룹코드 : extpyGrpCd */
	    	                  	remt2200Dto.setSevePayDtlPatrNum(3L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                  	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm03")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                  	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt03"));	/** column 지급금액 : pymtSum */
	    	  				  
	    	                  	listRemt2200dto.add(remt2200Dto);
	    	                  
	    	                  	remt2200Dto = new InfcPkgRemt2200DTO();
	    	                  	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** column 사업장코드 : dpobCd */
	    	                  	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	    	                  	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    	/** column 정산년월 : clutYrMnth */
	    	                  	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                  	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    	/** column 급여항목코드 : payItemCd */
	    	                  	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    	/** column 수당그룹코드 : extpyGrpCd */
	    	                  	remt2200Dto.setSevePayDtlPatrNum(4L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                  	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm04")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                  	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt04"));	/** column 지급금액 : pymtSum */
	    	  				  
	    	                  	listRemt2200dto.add(remt2200Dto);
	    	                }   
	    	                
	    	                payr8500Service.activityOnUpdatePayr8500ToRemt0100ToPayrCalc(listRemt2200dto, new AsyncCallback<Long>() {

	    	                	public void onFailure(Throwable caught) {
	    	  	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    	  	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100ToPayrCalc(저장) : " + caught), null);
	    	  	                }
	    	  	                public void onSuccess(Long result) { 
	    	  	                    
	    	  	                	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "퇴직금재정산이 완료되었습니다.", null);
	    	  	                	tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
	    	  	                	tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
	    	                     	  
	    	  	                	reloadRemt2000();
	    	  	                }   
	    	                });  
	    				}  
	    			}
	    		});
	    	}   
	    }));  
	    
	    lcTabFormLayer.add(cp01); 
		   
	    return lcTabFormLayer;
	 } 
	
	//후생복지비 
	private LayoutContainer Data03() {
		   
		LayoutContainer lcTabFormLayer = new LayoutContainer();
	  	    
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(583, 287);   
	  	 
	  	   
		remtWfep0100GridPanel = new MSFGridPanel(remtWfep0100Def, false, false,false, false);
		remtWfep0100GridPanel.setHeaderVisible(false);
		remtWfep0100GridPanel.setBodyBorder(true);
		remtWfep0100GridPanel.setBorders(true);
	    
		GWTUtils.findColumnConfig(remtWfep0100GridPanel, InfcPkgRemt2000BM.ATTR_SEVEPAYPYMTSUM).setStyle("background-color:#F5F6CE;"); 
		     
		AggregationRowConfig<BaseModel> remtWfep0100SummaryRow = new AggregationRowConfig<BaseModel>();  
				 
		remtWfep0100SummaryRow.setCellStyle(InfcPkgRemt2000BM.ATTR_SEVEPAYPYMTSUM,"summary_color");
		remtWfep0100SummaryRow.setHtml(InfcPkgRemtPayr0100BM.ATTR_PAYITEMNM, "계");   
			    
		// with summary type and format  
		remtWfep0100SummaryRow.setSummaryType(InfcPkgRemt2000BM.ATTR_SEVEPAYPYMTSUM, SummaryType.SUM);   
		remtWfep0100SummaryRow.setSummaryFormat(InfcPkgRemt2000BM.ATTR_SEVEPAYPYMTSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  

		remtWfep0100GridPanel.getGrid().getColumnModel().addAggregationRow(remtWfep0100SummaryRow);    
			     
		cp01.add(remtWfep0100GridPanel);  
	  	  
 
		//후생복지비
		cp01.addButton(new Button("퇴직금재산정", new SelectionListener<ButtonEvent>() {   
			@Override  
			public void componentSelected(ButtonEvent ce) {   
				MessageBox.confirm("후생복지비 퇴직금재산정", "후생복지비 퇴직금 재산정을 하시겠습니까?<br>(후생복지비 변경에 따른 재계산)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							Iterator<BaseModel> itBm  = remtWfep0100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
							List<Record>  lsRec  = new ArrayList<Record>();
		    			          
							while (itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}
							
							setListRecord(lsRec.iterator()); 
							Iterator<Record> iterRecords = getListRecord();
		    			           
							List<InfcPkgRemt2200DTO> listRemt2200dto = new ArrayList<InfcPkgRemt2200DTO>();  
		    		            
							while (iterRecords.hasNext()) {
		    		          
								Record recData = (Record) iterRecords.next(); 
								BaseModel bmMapModel = (BaseModel)recData.getModel();
		    		                  
								InfcPkgRemt2200DTO remt2200Dto = new InfcPkgRemt2200DTO(); 
		    		               
		    		            remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));					/** column 사업장코드 : dpobCd */
		    		            remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    		/** column SYSTEMKEY : systemkey */
		    		            remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    		/** column 정산년월 : clutYrMnth */
		    		            remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
		    		        	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    		/** column 급여항목코드 : payItemCd */
		    		        	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    		/** column 수당그룹코드 : extpyGrpCd */
		    		        	remt2200Dto.setSevePayDtlPatrNum(0L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
		    		         	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("totLogSvcNumDys")));/** column 퇴직금산정시간 : sevePayCmpttnTm */
		    					remt2200Dto.setPymtSum((Long)bmMapModel.get("sevePayPymtSum")); 	/** column 지급금액 : pymtSum */
		    						  
		    					listRemt2200dto.add(remt2200Dto); 
							}   
		    		              
							payr8500Service.activityOnUpdatePayr8500ToRemt0100ToPayrWfepCalc(listRemt2200dto, new AsyncCallback<Long>() {
								public void onFailure(Throwable caught) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100ToPayrCalc01(저장) : " + caught), null);
								}
								
								public void onSuccess(Long result) { 
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "퇴직금재정산이 완료되었습니다.", null);
									//remtWfep0100GridPanel.reload();
									tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
									tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
		    		                   	  
									reloadRemt2000();
								}   
							}); 
						}  
					}
				});
			}   
		}));   
		
		lcTabFormLayer.add(cp01); 
	 	    
		return lcTabFormLayer;
	 } 
	 
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
		
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		remt2000DefGridPanel.getTableDef().setTableColumnFilters(filters);
		 
		//정산년월
		remt2000DefGridPanel.getTableDef().addColumnFilter("clutYrMnth", (MSFSharedUtils.getSelectedComboValue(srhClutYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhClutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		        
		//정산구분
		remt2000DefGridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		         
		remt2000DefGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		remt2000DefGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		remt2000DefGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
            
		String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		remt2000DefGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             
		String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		remt2000DefGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	         
		remt2000DefGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			  
		remt2000DefGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remt2000DefGridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		remt2000DefGridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			 
		remt2000DefGridPanel.reload();
	}
	  
	
	//폼초기화 검색조건포함 
	private void formInit() {
	       
		tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
		tabsRemtSub.setSelection(tabsRemtSub.getItem(0)); 
	      
		systemkey.setValue("");        	/**  column SYSTEMKEY : systemkey */
	    dpobCd.setValue("");           	/**  column 사업장코드 : dpobCd      */  
	    calcSevePayPsnDivCd.reset();   	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    clutYrMnth.setValue("");   		/** column 정산년월 : clutYrMnth */ 
	    clutYr.reset();   				/** column 정산년 : clutYr */ 
	    clutMnth.reset();   			/** column 정산월 : clutMnth */ 
	    nm.setValue("");   				/** column 성명 : nm */
	    resnRegnNum.setValue("");    
	    deptNm.setValue("");     		/** column 부서 : deptNm    */ 
	    emymtDivNm.setValue("");   		/** column 고용구분 : emymtDivNm */ 
	    typOccuNm.setValue("");   		/** column 직종 : typOccuNm */ 
	    // pyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */ 
	    logSvcYrNumCd.setValue("");   	/** column 근속년수코드 : logSvcYrNumCd */ 
	    logSvcMnthIcmCd.setValue("");   /** column 근속월수코드 : logSvcMnthIcmCd */ 
	    icncDt.reset();   				/** column 입사일자 : icncDt */ 
	    rkfcdDt.reset();   				/** column 기산일자 : rkfcdDt */ 
	    retryDt.reset();   				/** column 퇴직일자 : retryDt */
//	    logSvcYrNum.setValue(0);   		/** column 근속년수 : logSvcYrNum */
//	    logSvcMnthIcm.setValue(0);   	/** column 근속월수 : logSvcMnthIcm */
	    payCmpttnBgnnDt.reset();   		/** column 급여산정시작일자 : payCmpttnBgnnDt */
	    payCmpttnEndDt.reset();   		/** column 급여산정종료일자 : payCmpttnEndDt */
	    marPubcWelfAmnt.setValue(0);   	/** column 3월간후생복지비 : marPubcWelfAmnt */
	    marTotAmntWag.setValue(0);   	/** column 3월간총임금액 : marTotAmntWag */
	    dayAvgAmntWag.setValue(0);   	/** column 1일평균임금액 : dayAvgAmntWag */
	    sevePayCmpttnSum.setValue(0);   /** column 퇴직금산정금액 : sevePayCmpttnSum */
	    seveViewPayAddRate.setValue(0); /** column 퇴직금가산율 : sevePayAddRate */
	    sevePayAddApptnSum.setValue(0);	/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
	    amcrrClutInsnYn.setValue(false);/** column 군경력정산포함여부 : amcrrClutInsnYn */
	    amcrrAddApptnSum.setValue(0);   /** column 군경력가산적용금액 : amcrrAddApptnSum */
	    totLogSvcNumDys.setValue(0);   	/** column 총근무일수 : totLogSvcNumDys */
	    sevePayPymtSum.setValue(0);   	/** column 퇴직금지급액 : sevePayPymtSum */
		sevePayPymtDt.reset();   		/** column 퇴직금지급일자 : sevePayPymtDt */
	      
        remtPayr0100GridPanel.getMsfGrid().clearData(); 
	    remtWfep0100GridPanel.getMsfGrid().clearData(); 
	}
	   
	//산정결과
	private void reloadRemt2000(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
         
		InfcPkgRemt2000DTO remt2000Dto = new InfcPkgRemt2000DTO(); 
	      	 
		remt2000Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));		/**  column 사업장코드 : dpobCd */
		remt2000Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));	/**  column SYSTEMKEY : systemkey */ 
 		  
	    remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	    remt2000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */	  
	      	    
	    payr8500Service.activityOnReadPayr8500ToRemt0100(remt2000Dto, new AsyncCallback<InfcPkgRemt2000DTO>() {
	    	@Override
	    	public void onFailure(Throwable caught) {
	    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0100" + caught), null);
	    	}
	    	@Override
	     	public void onSuccess(InfcPkgRemt2000DTO result) { 
	    		//리턴 결과 
	    		clutYrMnth.setValue(result.getClutYrMnth());	/** column 정산년월 : clutYrMnth */
				clutYr.setValue(lsCrClutYrStore.findModel("year",MSFSharedUtils.allowNulls(result.getClutYr() )));		/** column 정산년월 : clutYrMnth */
				clutMnth.setValue(lsCrClutMnth.findModel("month",MSFSharedUtils.allowNulls(result.getClutMnth() )));    /** column 정산년월 : clutYrMnth */
				calcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getCalcSevePayPsnDivCd())));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				nm.setValue(result.getNm());					/** column 성명 : nm */
				resnRegnNum.setValue(result.getResnRegnNum());	/** column 주민등록번호 : resnRegnNum */
				emymtDivNm.setValue(result.getEmymtDivNm());    /** column 고용구분 : emymtDivNm */
				deptNm.setValue(result.getDeptNm());    		/** column 부서 : deptNm */
				typOccuNm.setValue(result.getTypOccuNm());    	/** column 직종 : typOccuNm */
				icncDt.setValue(GWTUtils.getDateFromString(result.getIcncDt(), "yyyyMMdd"));	/** column 입사일자 : icncDt */
				rkfcdDt.setValue(GWTUtils.getDateFromString(result.getRkfcdDt(), "yyyyMMdd"));	/** column 기산일자 : rkfcdDt */
				retryDt.setValue(GWTUtils.getDateFromString(result.getRetryDt(), "yyyyMMdd"));	/** column 퇴직일자 : retryDt */
				
				logSvcYrNumCd.setValue(result.getLogSvcYrNumCd());    	/** column 근속년수코드 : logSvcYrNumCd */
				logSvcMnthIcmCd.setValue(result.getLogSvcMnthIcmCd());	/** column 근속월수코드 : logSvcMnthIcmCd */
				
				sevePayPymtDt.setValue(GWTUtils.getDateFromString(result.getSevePayPymtDt(), "yyyyMMdd"));    	/** column 퇴직금지급일자 : sevePayPymtDt */
				
//				logSvcYrNum.setValue(result.getLogSvcYrNum());    	/** column 근속년수 : logSvcYrNum */
//				logSvcMnthIcm.setValue(result.getLogSvcMnthIcm());	/** column 근속월수 : logSvcMnthIcm */
				amcrrLogSvcNumDys.setValue(result.getAmcrrLogSvcNumDys());	/** column 군경력근무일수 : amcrrLogSvcNumDys */ 
				
				payCmpttnBgnnDt.setValue(GWTUtils.getDateFromString(result.getPayCmpttnBgnnDt(), "yyyyMMdd"));	/** column 급여산정시작일자 : payCmpttnBgnnDt */
				payCmpttnEndDt.setValue(GWTUtils.getDateFromString(result.getPayCmpttnEndDt(), "yyyyMMdd"));    /** column 급여산정종료일자 : payCmpttnEndDt */
				marPubcWelfAmnt.setValue(result.getMarPubcWelfAmnt());		/** column 3월간후생복지비 : marPubcWelfAmnt */
				marTotAmntWag.setValue(result.getMarTotAmntWag());    		/** column 3월간총임금액 : marTotAmntWag */
				dayAvgAmntWag.setValue(result.getDayAvgAmntWag());    		/** column 1일평균임금액 : dayAvgAmntWag */
				sevePayCmpttnSum.setValue(result.getSevePayCmpttnSum());    /** column 퇴직금산정금액 : sevePayCmpttnSum */
				seveViewPayAddRate.setValue(result.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
				sevePayAddApptnSum.setValue(result.getSevePayAddApptnSum());/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
				amcrrClutInsnYn.setValue( result.getAmcrrClutInsnYn());    	/** column 군경력정산포함여부 : amcrrClutInsnYn */
				amcrrAddApptnSum.setValue(result.getAmcrrAddApptnSum());	/** column 군경력가산적용금액 : amcrrAddApptnSum */
				totLogSvcNumDys.setValue(result.getTotLogSvcNumDys());    	/** column 총근무일수 : totLogSvcNumDys */
				sevePayPymtSum.setValue(result.getSevePayPymtSum());    	/** column 퇴직금지급액 : sevePayPymtSum */
				
	    	}	
	    });	       
	}
	   
	   
	//급여지급기간 셋팅하는 부분 
	private void reloadPayrRemt0100Header(){
		  
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		InfcPkgRemt2100DTO remt2100Dto = new InfcPkgRemt2100DTO();

		remt2100Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));/** column 사업장코드 : dpobCd */
		remt2100Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));/** column SYSTEMKEY : systemkey */
 		  
	    remt2100Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	    remt2100Dto.setClutYrMnth(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */	  
	      	    
	    payr8500Service.activityOnPayr8500ToRemt0100Header(remt2100Dto, new AsyncCallback<List<InfcPkgRemtDays0100DTO>>() {
	    	@Override 
	    	public void onSuccess(List<InfcPkgRemtDays0100DTO> result) { 
	    		//리턴 결과 
	    		if (MSFSharedUtils.paramNotNull(result)) {
	    			for (int iCnt =0;iCnt < result.size();iCnt++) {
	    				InfcPkgRemtDays0100DTO remtDays0100Dto = new InfcPkgRemtDays0100DTO();
	    				remtDays0100Dto = (InfcPkgRemtDays0100DTO)result.get(iCnt);
		                		  
	    				remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("", 2, 1));
	    				remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig( MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt01()).concat("<br>" 
	    						+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt01()))  , 1, 2));
	    				remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 3, new HeaderGroupConfig(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt02()).concat("<br>" 
	    						+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt02())), 1, 2));
	    				remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 5, new HeaderGroupConfig(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt03()).concat("<br>" 
	    						+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt03())), 1, 2));
	    				remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 7, new HeaderGroupConfig(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt04()).concat("<br>" 
	    						+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt04())), 1, 2));
	    				remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("계", 2, 1));
	                				
	    				GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_PAYITEMNM).setHeaderText("급여지급기간"); 
	    				GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM01).setHeaderText("");     /** set item_tm01 : itemTm01 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT01).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays01()));   /** set item_amnt01 : itemAmnt01 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM02).setHeaderText("");     /** set item_tm02 : itemTm02 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT02).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays02()));   /** set item_amnt02 : itemAmnt02 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM03).setHeaderText("");     /** set item_tm03 : itemTm03 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT03).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays03()));   /** set item_amnt03 : itemAmnt03 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTM04).setHeaderText("");     /** set item_tm04 : itemTm04 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMAMNT04).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays04()));   /** set item_amnt04 : itemAmnt04 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, InfcPkgRemtPayr0100BM.ATTR_ITEMTOTAMNT).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemTotDays()));  /** set 퇴직금 급여합계 :  itemTotAmnt */
	    			} 
	    			//급여내역
	    			reloadRemt210001();
	    		} else {
	                		
	    		}
	    	}
	    	@Override
	    	public void onFailure(Throwable caught) {
	    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0100 : " + caught), null);
	    	}
	    });	   
	}
	   
	   
	//급여내역 
	private void reloadRemt210001(){
		  
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		remtPayr0100GridPanel.getTableDef().setTableColumnFilters(filters);
			
		remtPayr0100GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remtPayr0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtPayr0100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtPayr0100GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		    
		remtPayr0100GridPanel.reload();  
		boolPymtDduc = true;
	}
	   
	// 후생복지비
	private void reloadRemt210002() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		IColumnFilter filters = null;
		remtWfep0100GridPanel.getTableDef().setTableColumnFilters(filters);

		remtWfep0100GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remtWfep0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
		remtWfep0100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd",MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		remtWfep0100GridPanel.getTableDef().addColumnFilter("clutYrMnth",MSFSharedUtils.getSelectedComboValue(clutYr, "year")
					.concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS);

		remtWfep0100GridPanel.reload();

	}
		
	    
	      
	   /**
	    * 퇴직정산 누른경우에 데이터를 리로딩한다.
	    * 소득세계산 탭을 누르면 /세액계산 탭의 정보 까지 같이 가지고 온다. 
	    */
//	   private void reloadDataRemtPymt(){
//	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//               return;
//           }
//		   IColumnFilter filters = null;
//		   remtPymt2000GridPanel.getTableDef().setTableColumnFilters(filters);
//			
//		   remtPymt2000GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//		   remtPymt2000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//		   remtPymt2000GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//		   remtPymt2000GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
//		    
//		   remtPymt2000GridPanel.reload();
//		   
//		   reloadDataRemtTax();
//		   
//	   }
	   
	/**
	 * 퇴직금공제내역
	 */
//	private void reloadDataRemtTax() {
//		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//			return;
//		}
//		
//		IColumnFilter filters = null;
//		remt2300GridPanel.getTableDef().setTableColumnFilters(filters);
//
//		remt2300GridPanel.getTableDef().addColumnFilter("dpobCd",MSFSharedUtils.allowNulls(dpobCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
//		remt2300GridPanel.getTableDef().addColumnFilter("systemkey",MSFSharedUtils.allowNulls(systemkey.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
//		remt2300GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd",MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
//		remt2300GridPanel.getTableDef().addColumnFilter("clutYrMnth",MSFSharedUtils.getSelectedComboValue(clutYr, "year")
//				.concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS);
//
//		remt2300GridPanel.reload();
//	}
	  
	    
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	public Iterator<Record> getListRecord() {
		return this.records;
	}

	private Payr8500 getThis() {
		return this;
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();//우편번호

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
       
     //부서 
//       private void fnPopupCommP140(String deptCd) {
//           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//           //검색.처리하면됨.
//           
//           MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//           
//           final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//          
//           popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//               public void handleEvent(BaseEvent be) {
//                   BaseModel mapModel = (BaseModel)be.getSource();
//                   if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                        
//                       srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                       srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                       srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                       srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                       srhDeptCd.fireEvent(Events.Add);
//                   }  
//                        
//               }
//           });
//       } 
	
	private void fnPopupRemt1000() {

		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom1000 = PrgmComPopupUtils.lovPopUpPrgmComRemt1000Form(); // 인사
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();
		// //우편번호

		final FormBinding popBindingCom1000 = popCom1000.getFormBinding();

		popBindingCom1000.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {

				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();

				if (mapModels != null) {

					if (MSFSharedUtils.paramNull(mapModels)) {
						return;
					} else {

						String pymtYrMnth = MSFSharedUtils.getSelectedComboValue(srhClutYr, "year")
								+ MSFSharedUtils.getSelectedComboValue(srhClutMnth, "month");
						
						if (MSFSharedUtils.paramNull(pymtYrMnth)) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산년월을 선택하셔야 합니다.", null);
							return;
						}
						if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"))) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
							return;
						}

						// 정산구분

						// 추가정보보내기
						InfcPkgRemt2000DTO remt2000Dto = new InfcPkgRemt2000DTO();

						remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(
								MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd")));/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						remt2000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(pymtYrMnth));				/** column 정산년월 : clutYrMnth */

						payr8500Service.activityOnInsertPayr8500ToRemt0100(mapModels, remt2000Dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
							
							public void onFailure(Throwable caught) {

								List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
								ShowMessageBM smBm = new ShowMessageBM();
								smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
								smBm.setMenu("Remt");
								smBm.setPhase("[퇴직정산]퇴직대상자에러");
								smBm.setMessage(caught.getLocalizedMessage());
								smBm.setContent(caught.getMessage());
								bmResult.add(smBm);
								PagingLoadResult<ShowMessageBM> retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());

								ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ,getThis());

								MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm, "닫기","620px", "510px", true);
								msFwMessage.show();
								showMessageForm.setMSFFormWindows(msFwMessage);

								// MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
								// MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertRemt0100(insert) :  + caught), null);
							}

							public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
								if (MSFSharedUtils.paramNotNull(result)) {
									ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ,getThis());
									BaseModel tmRec = new BaseModel();
									MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기", "620px","510px", true);
									msFwMessage.show();
									showMessageForm.setMSFFormWindows(msFwMessage);
								}
								
								reload();
							}
						});
					}
				}
			}
		});
	}
	
	
//    private void fnPopupCommP500() {
//        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//        //검색.처리하면됨.
//        SysComP0500DTO sysComP0500Dto = new SysComP0500DTO();
//        sysComP0500Dto.setPymtDducDivCd(PayGenConst.PYMT_DDUC_DIV_CD_03);
//        //지급공제구분코드 넘김.
//        MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpMsfCom0500Form(sysComP0500Dto);  //공제
//        
//        final FormBinding popBindingCom0500 = popCom0500.getFormBinding();
//       
//        popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {
//               
//                List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
//                
//                if (mapModels != null) { 
//                      
//                    if (mapModels.size() > 1) {
//                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "한건의 데이타만 선택가능합니다. 데이타를 확인하십시요.", null);
//                        return;
//                    }
//                    
//                    remt2300GridPanel.getMsfGrid().clearData();
//                    
//                    BaseModel bmData = remt2300GridPanel.getTableDef().getDefaultValues(); 
//               
//                    Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
//                    while (iterRecords.hasNext()) {
//                          BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
//                          
//							bmData.set("dpobCd",MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
//							bmData.set("calcSevePayPsnDivCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//							bmData.set("clutYrMnth",MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */
//							bmData.set("systemkey",MSFSharedUtils.allowNulls(systemkey.getValue()));    /** column SYSTEMKEY : systemkey */
//						    bmData.set("payItemCd",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));       /** column 급여항목코드 : payItemCd */ 
//	                        bmData.set("payItemNm",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));      /** column 급여항목 : payItemNm */ 
//							bmData.set("pymtDducDivCd",MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
//							bmData.set("pymtSum",0L);    /** column 지급금액 : pymtSum */
//							  
//                    }   
//                   
//                    remt2300GridPanel.getMsfGrid().getGrid().stopEditing();      
//                    remt2300GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//                    remt2300GridPanel.getMsfGrid().getGrid().startEditing(remt2300GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 2);   
//                   // remt2300GridPanel.getMsfGrid().getGrid().getStore().getAt(0).set("mnthPayAdmntAssoBssCtnt"," ");
//                   // remt2300GridPanel.getMsfGrid().getGrid().getStore().update(Remt2300GridPanel.getMsfGrid().getGrid().getStore().getAt(0));
//                    remt2300GridPanel.getMsfGrid().getGrid().getStore().getRecord(remt2300GridPanel.getMsfGrid().getGrid().getStore().getAt(0)).setDirty(true);
//                    
//                    actionDatabase = ActionDatabase.INSERT; 
//                }  
//            }
//        });
//    }
	
	
		  
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
