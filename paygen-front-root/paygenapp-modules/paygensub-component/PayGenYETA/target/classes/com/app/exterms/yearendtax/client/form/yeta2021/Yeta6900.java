package com.app.exterms.yearendtax.client.form.yeta2021;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2021.Pyyt0302DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Pyyt0304BM;
import com.app.exterms.yearendtax.client.dto.yeta2021.Pyyt0304DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.Pyyt0302Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.Pyyt0304Def;
import com.app.exterms.yearendtax.client.languages.YetaConstants;
import com.app.exterms.yearendtax.client.service.yeta2021.Yeta6900Service;
import com.app.exterms.yearendtax.client.service.yeta2021.Yeta6900ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
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
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Yeta6900  extends MSFPanel { 
 

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	// 권한 설정 객체
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
    private YetaConstants lblYetaConst = YetaConstants.INSTANCE; 
	private VerticalPanel vp;
	private FormPanel plFrmYeta1900;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
		
	//급여대상자정보 
//	// private MSFCustomForm msfCustomForm; 
	private Pyyt0304Def pyyt0304Def  = new Pyyt0304Def("Yeta6900");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel pyyt0304GridPanel;
	  
	//수당 
	private Pyyt0302Def pyyt0302ExtpyDef  = new Pyyt0302Def("Yeta6900_PYYT0302EXTPY");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel pyyt0302ExtpyGridPanel; 
	  
	//공제 
	private Pyyt0302Def pyyt0302DducDef  = new Pyyt0302Def("Yeta6900_PYYT0302DDUC");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel Pyyt0302DducGridPanel;
  

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 상태처리 전역변수 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		private ActionDatabase actionDatabase;
		private ContentPanel cpGridPayr0307;
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
		private ButtonBar topYeta1900Bar;
		private Button btnYeta1900Init;
		// private Button btnPayr4200Save;
		private Button btnYeta1900Del;
		private Button btnYeta1900Sreach;
		private Button btnYeta1900Print;
		private Button btnYeta1900Excel;
		private Button btnYeta1900SumExcel; // 월별급여
		
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
      
		/** column 년도 : payYr */
		private ComboBox<BaseModel> srhPayYr;
		private ComboBox<BaseModel> srhPayMonth;
     
		private ComboBox<BaseModel> srhPayCd; 					// 급여구분
		private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
		private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드
		private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	
		private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
		
		private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	
		private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	
		private ComboBox<BaseModel> srhBusinCd; 				// 사업
		private TextField<String> srhHanNm; 					// 성명
		private TextField<String> srhResnRegnNum; 				// 주민번호
		private HiddenField<String> srhSystemkey; 				// 시스템키
      
      
		private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
		private ComboBox<BaseModel> srhPayDducExtpyCd;
	
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
 
		
		private ComboBox<BaseModel> exlType; 					// 엑셀양식
		
		private FileUploadField Yeta6900flUp; // 파일업로드처리 부분
		private Boolean picBoolFile;
	
		private boolean mutilCombo = false;
		private String systemKeys;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
       
		private HiddenField<String> dpobCd;  		/** column 사업장코드 : dpobCd */
		private HiddenField<String> systemkey;    	/** column SYSTEMKEY : systemkey */
		
		private TextField<String> pyytYrMnth;   	/** column 지급년월 : pyytYrMnth */
		
      	private TextField<String> hanNm ;  			/** column 한글성명 : hanNm */
      	private TextField<String> resnRegnNum;   	/** column 주민등록번호 : resnRegnNum */
		
      	private HiddenField<String> logSvcYrNumCd ; /** column 근속년수코드 : logSvcYrNumCd */
      	private TextField<String> logSvcYrNumNm ;  	/** column 근속년수 : logSvcYrNumNm */
      	
      	private HiddenField<String> deptCd ;  		/** column 부서코드 : deptCd */
      	private TextField<String> deptNm ;  		/** column 부서 : deptNm */

      	private HiddenField<String> businCd;   		/** column 사업코드 : businCd */
      	private TextField<String> businNm;   		/** column 사업코드 : businNm */
      	
      	private NumberField pyytPymtTotAmnt;   		/** column 지급총액 : pyytpyytPymtTotAmnt */
      	private NumberField pyytExtpyTotAmnt;  		/** column 수당총액 : pyytpyytExtpyTotAmnt */

      	private HiddenField<String> typOccuCd;   	/** column 직종코드 : typOccuCd */
      	private HiddenField<String> typOccuNm ;  	/** column 직종코드 : typOccuNm */
      	private NumberField pyytDducTotAmnt;   		/** column 공제총액 : pyytDducTotAmnt */     
      	private NumberField  pyytPernPymtSum;  		/** column 차인지급액 : pyytPernPymtSum */

      	private NumberField  pyytB10100Sum ;     	/** column 기본급 : pyytB10100Sum */
      	private NumberField  pyytT10100Sum ;    	/** column 소득세 : pyytT10100Sum */
      	private NumberField  pyytT20100Sum ;    	/** column 주민세  : pyytT20100Sum */
      	private NumberField pyytFreeDtyTotAmnt;   	/** column 비과세총액 : pyytFreeDtyTotAmnt */
 

      	private HiddenField<Long> pyytTxtnTotAmnt;   	/** column 과세총액 : pyytTxtnTotAmnt */
      	private HiddenField<Long> pyytTxTotAmnt;   		/** column 세금총액 : pyytTxTotAmnt */
//  	private HiddenField<String> payCd;  		/** column 급여구분코드 : payCd */
      	private HiddenField<String> payrMangDeptCd; /** column 단위기관코드 : payrMangDeptCd */
//  	private HiddenField<Long> payrSeilNum;   	/** column 급여일련번호 : payrSeilNum */
      	private HiddenField<String> emymtDivCd;   	/** column 고용구분코드 : emymtDivCd */
  

//  	private HiddenField<String> secRegnNum;   	/** column 주민등록번호 : secRegnNum */
      	
      	

//      	private HiddenField<String> bnkCd;   		/** column 은행코드 : bnkCd */
//      	private HiddenField<String> bnkNm;  		/** column 은행코드 : bnkNm */
//      	private HiddenField<String> bnkAccuNum;  	/** column 은행계좌번호 : bnkAccuNum */
//      	private HiddenField<String> acntHodrNm;   	/** column 예금주명 : acntHodrNm */
//      	private HiddenField<String> payDdlneDt;  	/** column 급여마감일자 : payDdlneDt */
//      	private HiddenField<String> payDdlneYn;  	/** column 급여마감여부 : payDdlneYn */


      	
//      	private TextField<String> pyytSevePayPymtYn;   /** column 퇴직금지급여부 : pyytSevePayPymtYn */
      
      	private BaseModel ppRecord; //팝업에 넘길 레코드 값 
      
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
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
      	private void checkPayr4200Auth(String authAction, ListStore<BaseModel> bm) { 
      		// MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중");

      		// 2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
      		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm)) {
				// MSFMainApp.unmaskMainPage();----------------------------------------------------
				if (!maskTracker) {
					unmask();
				}
				authExecEnabled();
				gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
      		}
      	}
		  
      	private void authExecEnabled() {
    	  
      		Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd,srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd };
    	  
      		gwtAuthorization.formAuthFieldConfig(fldArrField);
      		
      		srhPayYr.setValue(lsPayYrStore.findModel("year", "2021"));
//      		srhPayYr.setValue(lsPayYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
      		srhPayMonth.setValue(lsPayMonth.findModel("month", DateTimeFormat.getFormat("MM").format(new Date())));
      		srhPayCd.setValue(lsPayCd.getAt(0));
            	  
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 
			 * : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
			// String[] strArrDeptCd =
			// {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
			// GWTAuthorization.formAuthPopConfig(plFrmYeta1900,
			// "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
			// GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd);
			// gwtAuthorization.formAuthConfig(plFrmYeta1900,
			// "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 종료
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
      		// srhDeptCd.fireEvent(Events.Add);
      		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
      	}
				 
		final Timer tmMask = new Timer() {
			public void run() {
				if (lsEmymtDivCd.getCount() > 0) {
	
					cancel();
					unmask();
					authExecEnabled();
					maskTracker = true;
	
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
	
			authMapDef.put("srhPayYr", Boolean.FALSE);
			authMapDef.put("srhPayMonth", Boolean.FALSE);
			authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
			authMapDef.put("srhPayCd", Boolean.FALSE);
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
	private void setPayr4200FormBinding() {
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
	private Yeta6900ServiceAsync yeta6900Service = Yeta6900Service.Util.getInstance();

	private ListStore<BaseModel> lsPayYrStore	 	= new ListStore<BaseModel>(); 	// 년도
	private ListStore<BaseModel> lsPayMonth 		= new ListStore<BaseModel>(); 	// 급여월

	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	// 호봉제구분코드 

	// --------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>();	// 부서콤보
	// --------------------부서 불러 오는 함수------------------------------------------------

	// --------------------사업 불러 오는 함수-------------------------------------------------
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();	// 사업콤보
	// --------------------사업 불러 오는 함수-------------------------------------------------
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	// 단위기관
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	// 부서직종그룹코드  	
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	// 직종
	private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>(); 	// 급여구분

	private ListStore<BaseModel> lsPymtDducDivCd 	= new ListStore<BaseModel>();	// 지급공제구분코드
	private ListStore<BaseModel> lsPayDducExtpyCd 	= new ListStore<BaseModel>(); 	// 지급공제항목
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>(); 	// 직종세

	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
	private BaseModel record;

	private Iterator<Record> records;
	private Iterator<Record> recordDels;
	
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
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr4200Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr4200Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else
//			if (ce.getButton() == btnYeta1900Del) {
//	                
//				MessageBox.confirm("삭제", "선택된 데이타을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
//					@Override
//					public void handleEvent(MessageBoxEvent be) {
//						
//						//if("Yes".equals(be.getButtonClicked().getText())){ 
//						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){  	
//							Iterator<BaseModel> itBm  = pyyt0304GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//	                             
//							List<Record>  lsRec  = new ArrayList<Record>();
//	                             
//	                        while(itBm.hasNext()) {
//
//	                        	Record rec  = new Record(itBm.next()); 
//	                        	lsRec.add(rec);
//	                                 
//	                        } 
//	                              
//	                             
//	                        setListRecordDels(lsRec.iterator()); 
//	                              
//	                        List<InfcPkgPayr0304DTO> listInfcPayr0304Dto = new ArrayList<InfcPkgPayr0304DTO>();  
//	                             
//	                        while (recordDels.hasNext()) {
//	                          
//	                        	Record record = (Record) recordDels.next(); 
//	                        	BaseModel bmMapModel = (BaseModel)record.getModel();
//	                                  
//	                              
//	                           
//	                            InfcPkgPayr0304DTO payr0304Dto = new InfcPkgPayr0304DTO(); 
//                                
//                                payr0304Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    				/** column 사업장코드 : dpobCd */
//                                payr0304Dto.setpyytYrMnth(MSFSharedUtils.allowNulls(record.get("pyytYrMnth")));			/** column 지급년월 : pyytYrMnth */
//                                payr0304Dto.setSystemkey(MSFSharedUtils.allowNulls(record.get("systemkey")));			/** column SYSTEMKEY : systemkey */
//                                payr0304Dto.setPayCd(MSFSharedUtils.allowNulls(record.get("payCd")));    				/** column 급여구분코드 : payCd */
//                                payr0304Dto.setPayrSeilNum((Long)record.get("payrSeilNum"));    						/** column 급여일련번호 : payrSeilNum */
//                                payr0304Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(record.get("payrMangDeptCd")));	/** column 급여관리부서코드 : payrMangDeptCd */
//                                payr0304Dto.setPayCd(MSFSharedUtils.allowNulls(record.get("payCd")));    				/** column 급여구분코드 : payCd */
//                                payr0304Dto.setPayrSeilNum((Long)record.get("payrSeilNum"));    						/** column 급여일련번호 : payrSeilNum */
////                                payr0304Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(record.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
////                                payr0304Dto.setHanNm(MSFSharedUtils.allowNulls(record.get("hanNm")));    /** column 한글성명 : hanNm */
////                                payr0304Dto.setResnRegnNum(MSFSharedUtils.allowNulls(record.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
////                                payr0304Dto.setDeptCd(MSFSharedUtils.allowNulls(record.get("deptCd")));    /** column 부서코드 : deptCd */
////                                payr0304Dto.setBusinCd(MSFSharedUtils.allowNulls(record.get("businCd")));    /** column 사업코드 : businCd */
////                                payr0304Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
////                                payr0304Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd")));    /** column 직종세구분코드 : dtilOccuInttnCd */
////                                payr0304Dto.setOdtyCd(MSFSharedUtils.allowNulls(record.get("odtyCd")));    /** column 직책코드 : odtyCd */
////                                payr0304Dto.setPyspCd(MSFSharedUtils.allowNulls(record.get("pyspCd")));    /** column 호봉코드 : pyspCd */
////                                payr0304Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
////                                payr0304Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(record.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
////                                payr0304Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(record.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
////                                payr0304Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(record.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
////                                payr0304Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(record.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
////                                payr0304Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(record.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
////                                payr0304Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(record.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
////                                payr0304Dto.setRetryDt(MSFSharedUtils.allowNulls(record.get("retryDt")));    /** column 퇴직일자 : retryDt */
////                                payr0304Dto.setLogSvcStdDt(MSFSharedUtils.allowNulls(record.get("logSvcStdDt")));    /** column 근속기준일자 : logSvcStdDt */
////                                payr0304Dto.setSpueYn(MSFSharedUtils.allowNulls(record.get("spueYn")));    /** column 배우자유무 : spueYn */
////                                payr0304Dto.setSuprtFamyNumTwenChDn(MSFSharedUtils.allowNulls(record.get("suprtFamyNumTwenChDn")));    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
////                                payr0304Dto.setSuprtFamyNumTreOvrChdn(MSFSharedUtils.allowNulls(record.get("suprtFamyNumTreOvrChdn")));    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
////                                payr0304Dto.setSuprtFamyNumEtc(MSFSharedUtils.allowNulls(record.get("suprtFamyNumEtc")));    /** column 부양가족수_기타 : suprtFamyNumEtc */
////                                payr0304Dto.setSuprtFamy3ChdnExtpySum(MSFSharedUtils.allowNulls(record.get("suprtFamy3ChdnExtpySum")));    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
////                                payr0304Dto.setChdnSchlExpnAdmclYn(MSFSharedUtils.allowNulls(record.get("chdnSchlExpnAdmclYn")));    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
////                                payr0304Dto.setHlthInsrGrde(MSFSharedUtils.allowNulls(record.get("hlthInsrGrde")));    /** column 건강보험등급 : hlthInsrGrde */
////                                payr0304Dto.setNatPennGrde(MSFSharedUtils.allowNulls(record.get("natPennGrde")));    /** column 국민연금등급 : natPennGrde */
////                                payr0304Dto.setMnthPayDlywagSum(MSFSharedUtils.allowNulls(record.get("mnthPayDlywagSum")));    /** column 월급여일당금액 : mnthPayDlywagSum */
////                                payr0304Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
////                                payr0304Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
////                                payr0304Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
////                                payr0304Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
////                                payr0304Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
////                                payr0304Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */ 
//	                             
//                                listInfcPayr0304Dto.add(payr0304Dto);
//	                        }
//	                        
//	                        payr4200Service.deletePayr4200(listInfcPayr0304Dto,ActionDatabase.DELETE, new AsyncCallback<Long>() {
//	                        	public void onFailure(Throwable caught) {
//	                        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                        				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("deletePayr4200(delete) : " + caught), null);
//	                        	}
//	                                  
//	                        	@Override
//	                            public void onSuccess(Long result) { 
//	                        		if (result == 0) {
//	                        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//	                        		} else {
//	                        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "삭제 처리가 완료되었습니다.", null);
//	                        			reload(); 
//	                        		} 
//	                        	} 
//	                        });   
//						}
//					}
//				});   
//			}
		}  
	};
	
	/** 수당, 공제 저장 삭제 구현 부 **/
	private void savePyyt0302(final Iterator<Record> iterRecords, final String flag) {
		
		int result = 0;
		
		String msg = "저장";
		
		if("del".equals(flag)) {
			msg = "삭제";
		}
		
		
        MessageBox.confirm(msg, "해당항목을 " + msg + " 하시겠습니까?",new Listener<MessageBoxEvent>(){
            @Override
            public void handleEvent(MessageBoxEvent be) {
               // if("Yes".equals(be.getButtonClicked().getText())){
            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                    
//                        Iterator<Record> iterRecords = Pyyt0302DducGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
                       
            		List<Pyyt0302DTO> listPyyt0302Dto = new ArrayList<Pyyt0302DTO>();  
            	        
            		while (iterRecords.hasNext()) {
                      
            			Record record = (Record) iterRecords.next(); 
            			BaseModel bmMapModel = (BaseModel)record.getModel();
                              
            			Pyyt0302DTO pyyt0302Dto = new Pyyt0302DTO();  
                            
            			pyyt0302Dto.setPyytItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytItemCd")));   	 					/** column 급여항목코드 : pyytItemCd */
            			pyyt0302Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));									/** column 급여구분코드 : payCd */
            			pyyt0302Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
            			pyyt0302Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
            			pyyt0302Dto.setPyytYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrMnth")));    						/** column 지급년월 : pyytYrMnth */
            			pyyt0302Dto.setPyytPymtDducCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytPymtDducCd")));    				/** column 지급공제구분코드 : pyytPymtDducCd */
            			pyyt0302Dto.setPyytPymtDducSum((Long) bmMapModel.get("pyytPymtDducSum"));    								/** column 지급공제금액 : pyytPymtDducSum */
            			pyyt0302Dto.setPyytPyddTxtnAmnt((Long) bmMapModel.get("pyytPyddTxtnAmnt"));    								/** column 지급공제과세금액 : pyytPyddTxtnAmnt */
            			pyyt0302Dto.setPyytPyddFreeDtySum((Long) bmMapModel.get("pyytPyddFreeDtySum"));    							/** column 지급공제비과세금액 : pyytPyddFreeDtySum */
            			pyyt0302Dto.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrtxDotnCd$commCd")));    		/** column 연말정산_기부금코드 : pyytYrtxDotnCd */
            			pyyt0302Dto.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYtfeDtyReduCd$commCd")));	/** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
//                            pyyt0302Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                            pyyt0302Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                            pyyt0302Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                            pyyt0302Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                            pyyt0302Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                            pyyt0302Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */                           
                            
                           
            			listPyyt0302Dto.add(pyyt0302Dto);
            		}   
            	          
            		yeta6900Service.saveYeta6900ToPyyt0302(listPyyt0302Dto, flag, new AsyncCallback<Integer>() {
                        public void onFailure(Throwable caught) {
                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                    MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta6900ToPyyt0302(save) : " + caught), null);
                        }
                        public void onSuccess(Integer resultInt) { 
                            if (resultInt == 0) {
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                        "저장이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                            } else {
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), resultInt + "건의 데이터 처리가 완료되었습니다.", null);
//                                reload();
//                                fireEvent(Events.RowDoubleClick);
                                payrInfoReload();
                    			extpyReload();
                				dducReload();
                            }
                        }
            		});
            	}
            }
		});
	}
	  
	    
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			savePayr4200();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			savePayr4200();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			savePayr4200();
			break;
		}
	}
	     

	private void savePayr4200() { 
        
//		if (MSFSharedUtils.paramNotNull(records)) {
//            
//			statCheck = false;
//            List<Payr0307DTO> listPayr0307dto = new ArrayList<Payr0307DTO>();  
//             
//             while (records.hasNext()) {
//           
//            	 Record record = (Record) records.next(); 
//                 BaseModel bmMapModel = (BaseModel)record.getModel();
//                   
//                 Payr0307DTO payr0307Dto = new Payr0307DTO();  
//             
//                 payr0307Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
//                 payr0307Dto.setpyytYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrMnth")));    						/** column 지급년월 : pyytYrMnth */
//                 payr0307Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    							/** column 급여구분코드 : payCd */
//                 payr0307Dto.setPayrSeilNum((Long)bmMapModel.get("payrSeilNum"));    											/** column 급여일련번호 : payrSeilNum */
//                 payr0307Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    							/** column SYSTEMKEY : systemkey */
//                 payr0307Dto.setMnthPayAdmntSeilNum((Long)bmMapModel.get("mnthPayAdmntSeilNum"));    							/** column 월급여조정일련번호 : mnthPayAdmntSeilNum */
//                 payr0307Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    							/** column 급여항목코드 : payItemCd */
//                 payr0307Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));				/** column 지급공제구분코드 : pymtDducDivCd */
//                 payr0307Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    											/** column 지급공제금액 : pymtDducSum */
//                 payr0307Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    									/** column null : pymtDducTxtnAmnt */
//                 payr0307Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    								/** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                 payr0307Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("mnthPayAdmntAssoBssCtnt")));	/** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
//                 payr0307Dto.setMnthPayAdmntYn((Boolean)bmMapModel.get("mnthPayAdmntYn"));    									/** column 월급여소급조정여부 : mnthPayAdmntYn */
////                payr0307Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
////                payr0307Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
////                payr0307Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
////                payr0307Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
////                payr0307Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
////                payr0307Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
//                 
//  	           
////                if ("C9080100".equals(payr0307Dto.getPayItemCd())) {
////                	 MessageBox.confirm("정액급식비", "정액급식비 조정시 비과세금액도 조정이 필요한지 확인하십시요. 계속진행하시겠습니까?",new Listener<MessageBoxEvent>(){
////          	              @Override
////          	               public void handleEvent(MessageBoxEvent be) {
////          	                  if("No".equals(be.getButtonClicked().getText())){ 
////          	                      return ;
////          	                 }
////          	            }
////          	              
////          	          });
////                } 
//                
//                 if (actionDatabase.equals(ActionDatabase.INSERT)) {
//                	
//                	 
//                	 if (MSFSharedUtils.isNullAsString(payr0307Dto.getSystemkey())) {
//                		 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여] 조정할 대상자를 선택하십시요.", null);
//                		 statCheck = true;
//                		 break;
//                	} else if (MSFSharedUtils.isNullAsString(payr0307Dto.getPymtDducDivCd())) {
//                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여] 지급공제구분을 입력하십시요.", null);
//                		statCheck = true;
//                		break;
//                	} else if (MSFSharedUtils.paramNotNull(payr0307Dto.getPymtDducSum())) {
//                		if (payr0307Dto.getPymtDducSum().compareTo(0L) <= 0) {
//	                			//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	         	               //          "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
//	                  			//statCheck = true;
//	                  			//break;
//                		}
//                	}  else if (MSFSharedUtils.paramNull(payr0307Dto.getPymtDducSum())) {
//                   			 
//                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
//                		statCheck = true;
//                		break;
//                   			 
//                	}  
//                 }   
//                 listPayr0307dto.add(payr0307Dto);
//             }   
//             
//             if (!statCheck) {    
//            	 payr4200Service.activityOnPayr4200(listPayr0307dto, actionDatabase, new AsyncCallback<Long>() { 
//            		 public void onFailure(Throwable caught) {
//            			 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//            					 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr4200(" + actionDatabase.name() + ") : " + caught), null);
//		         	 }
//            		 
//            		 public void onSuccess(Long result) { 
//            			 if (result == 0) {
//            				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//		                      // actionDatabase = ActionDatabase.INSERT;
//            			 } else {
//            				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
//		                       reload();
//		                       actionDatabase = ActionDatabase.UPDATE;
//            			 } 
//            		 } 
//            	 }); 
//             }
//		} else {
//            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//            return;
//		}
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
    
    
    private void Payr4200Print(String fileName, String repType) {
		if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			RdaPrint(fileName);
		} else if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			RexPrint(fileName);
		} else {
			Window.alert("출력 타입 오류!");
		}
	}
    
    
	//rda 
	private void RdaPrint(String fileName) {

		// mrd 출력물
		String rdaFileName = fileName + ".mrd";
        
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
               
		//검색조건
		String serarchParam = "";
                
		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
         
		        
		serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";    //사업코드 $1
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"year") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]"; //$2
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"year") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]"; //$3
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$4
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";    //$5
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";    //$6
		
		//20151212-추가 시작 
		if (payrMangDeptCd.equals(deptCdAuth)) { 
			serarchParam += "[]"; //parameter7
		} else {
			serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$7
		}  
		//20151212-추가 끝
		
		serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$8
		serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$9
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";   //$10
                   
//		String checkedSystemKeys = "'"+ systemkey + "'";
		String checkedSystemKeys = "";
		List<BaseModel> list = pyyt0304GridPanel.getGrid().getSelectionModel().getSelectedItems();
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			System.out.println("체크값 : " + checkedSystemKeys);
		}else {
			MessageBox.info("", "대상자를 선택해주세요.", null);
		}
		serarchParam = serarchParam+"["+checkedSystemKeys+"]";  //$11
                
		//20151212-변경추가 시작 
		serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //parameter12 유우져 아이디 넘김 
		serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //parameter13
				  
		//권한처리를위해 넘기는 변수 2개추가 
		serarchParam += "["+deptCdAuth+"]"; //$parameter14 부서 
		serarchParam += "["+dtilOccuInttnCdAuth+"]"; //parameter15 직종세 
		//20151212-추가 끝 
				
		GWT.log("popup : " + serarchParam);               
		String strParam = "/rp " + serarchParam; 
              
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	}
	
	
	
	//rex 
	private void RexPrint(String fileName) {
		
		// reb 출력물
		//TODO 클립리프토의 경우 개인별 월급여내역 파일이 PAYRT4302 
		String rexFileName = "PAYRT4302" + ".reb";
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
               
		//검색조건
		String serarchParam = "";
		
		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
         
		        
		serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			//사업코드 $1
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr,"year") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"⊥"; //$2
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr,"year") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"⊥"; //$3
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";   //$4
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";	//$5
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"⊥";    		//$6
		
		//20151212-추가 시작 
		if (payrMangDeptCd.equals(deptCdAuth)) { 
			serarchParam += "⊥"; //parameter7
		} else {
			serarchParam += ""+ YetaUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; //$7
		}  
		//20151212-추가 끝
		
		serarchParam += ""+ YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";//$8
		serarchParam += ""+ YetaUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"⊥";  //$9
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";   //$10
                   
		
		
		
		String checkedSystemKeys = "";
		List<BaseModel> list = pyyt0304GridPanel.getGrid().getSelectionModel().getSelectedItems();
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
		}else {
			MessageBox.info("", "대상자를 선택해주세요.", null);
		}
		serarchParam = serarchParam+""+checkedSystemKeys+"⊥";  //$11
                
		//20151212-변경추가 시작 
		serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  		//parameter12 유우져 아이디 넘김 
		serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; 	//parameter13
				  
		//권한처리를위해 넘기는 변수 2개추가 
		serarchParam += ""+deptCdAuth+"⊥";				//$parameter14 부서 
		serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; 	//parameter15 직종세 
				
		GWT.log("popup : " + serarchParam);
		String strParam = "" + serarchParam; 
      
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
	}
    
	
	private void RexPrint2(String fileName) {

		
				String strDirPath = "PAYR";
				
				// reb 출력물
				String rexFileName = fileName + ".crf";
//				String rexFileName = fileName + ".reb";
				
				// 보낼 파라미터
				
				// 검색조건
				String serarchParam = "";
				
				String year	 = YetaUtils.getSelectedComboValue(srhPayYr,	"year");
				String month = YetaUtils.getSelectedComboValue(srhPayMonth,	"month");
				
				String pyytYrMnth	   = year+month;
				String payCd		   = YetaUtils.getSelectedComboValue(srhPayCd, "commCd");
		 		String payrMangDeptCd  = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
				String emymtDivCd	   = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");
				String deptCd		   = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
				String typOccuCd	   = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
//				String pyspGrdeCd	   = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "pyspGrdeCd");
				String dtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
				String businCd		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd");
				String businNm		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businNm");
				
				
				String hanNm		   = MSFSharedUtils.allowNulls(srhHanNm.getValue());
				String resnRegnNum	   = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
 
                String deptNm          = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); 
				
			 
				systemKeys = new String();
				systemKeys = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
				
				String deptCdAuth	   = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(  lsDeptCd
																									 , MSFSharedUtils.allowNulls(srhDeptCd.getValue())
																									 , "deptNmRtchnt", "deptCd"
																									)
																  ).replace(",", "");
				String dtilOccuInttnCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																										 , MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue())
																										 , "dtilOccuClsNm"
																										 , "dtilOccuInttnCd")).replace(",", "");
			
				
				String lastWeek = getWeekCountOfMonth(pyytYrMnth)+"일";
				//그리드 선택 데이터 출력
                //getWeekInMonths(year,month);
                
				
				
				
				String checkedSystemKeys = "";
				int keyCnt = 0;
				List<BaseModel> list = pyyt0304GridPanel.getGrid().getSelectionModel().getSelectedItems();

				if(list != null && list.size() > 0) {
					String chkSysKey = "";
					int iCnt = 0;

					for(BaseModel bm : list){
						chkSysKey += bm.get("systemkey") + ",";
						iCnt = iCnt + 1;
					}
					keyCnt = iCnt;
					checkedSystemKeys = chkSysKey.substring(0, chkSysKey.length() - 1); //$10 시스템키
				//	System.out.println("시스템키는 넘기지 않고 검색조건만 넘김");
					//시스템키는 넘기지 않고 검색조건만 넘김
					if(keyCnt > 200) {
						MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.", new Listener<MessageBoxEvent>() {
							@Override
							public void handleEvent(MessageBoxEvent be) {
								// TODO Auto-generated method stub
								//if("Yes".equals(be.getButtonClicked().getText())) {
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									systemKeys = "";
								} else {
									return;
								}
							}
						});
						//System.out.println("선택한 시스템키 넘김");
						//선택한 시스템키 넘김
					} else {
						systemKeys = checkedSystemKeys;
					}
				}
				
				
				
//				if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)) {
				
					//도장 출력을 위해 추가 2014-11-06 //$9
					String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
					if(MSFSharedUtils.paramNull(myImgUrl)) {
					// myImgUrl = "http://105.19.10.32:8080";
					//경로오류 출력
					}
					
					serarchParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())	+ "⊥";	/*$1							*/
					serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$2  기간검색시작				*/
					serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$3  기간검색종료				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(payrMangDeptCd)							+ "⊥";	/*$4  단위기간					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(emymtDivCd)								+ "⊥";	/*$5  고용구분					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(deptCd)									+ "⊥";	/*$6  부서코드					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(typOccuCd)								+ "⊥";	/*$7  직종						*/
					serarchParam += "" + MSFSharedUtils.allowNulls(dtilOccuInttnCd)							+ "⊥";	/*$8  직종세						*/
					serarchParam += "" + MSFSharedUtils.allowNulls(businCd)									+ "⊥";	/*$9  사업코드					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(systemKeys)								+ "⊥";	/*$10 시스템키					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(hanNm)									+ "⊥";	/*$11 성명						*/
					serarchParam += "" + MSFSharedUtils.allowNulls(resnRegnNum)								+ "⊥";	/*$12 주민번호					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(payCd)									+ "⊥";	/*$13 급여구분					*/
					
					/* 20151212-변경추가 시작				*/
					serarchParam += "" + MSFMainApp.get().getUser().getUsrId()								+ "⊥"; /*$14 유저 아이디					*/
					serarchParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn()						+ "⊥";	/*$15 관리자 유무					*/
					
					/* 권한처리를위해 넘기는 변수 2개추가	*/
					serarchParam += "" + deptCdAuth															+ "⊥";	/*$16 부서						*/
					serarchParam += "" + dtilOccuInttnCdAuth												+ "⊥";	/*$17 직종세						*/
					
					/* 20151212-추가 끝					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(myImgUrl)								+ "⊥";	/*$18 직인경로					*/
					serarchParam += "0⊥";																			/*$19 단건 1 복수건 0 프린트 추가	*/
					serarchParam += "" + year																+ "⊥";	/*$20 년							*/
					serarchParam += "" + pyytYrMnth															+ "⊥";	/*$21 년월						*/
					serarchParam += "" + month																+ "⊥";	/*$22 월							*/
					
					serarchParam += "" + businNm															+ "⊥";	/*$23 마지막주							*/
					serarchParam += "" + lastWeek															+ "⊥";	/*$24 							*/
					serarchParam += "[" + deptNm															+ "]⊥";	/*$25 							*/
					
					
					String strParam = "" + serarchParam ;
					
					
					
					
					//GWT 타입으로 팝업 호출시  postCall true 설정
					PrintUtils.setPostCall(true);
					PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

				//}else{
				//	MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
				//}
	}
	
	
	private String getWeekCountOfMonth(String dt){
		int count = 0;
		
		Calendar cal = Calendar.getInstance();	
			
		int intYear=Integer.parseInt(dt.substring(0, 4));	
		int intMonth=Integer.parseInt(dt.substring(4, 6));
		
		int lastDay =  cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int day = 1; day <= lastDay; day++){
			
			  cal.set(Calendar.YEAR, intYear);
			  cal.set(Calendar.MONTH, intMonth - 1);
			  cal.set(Calendar.DAY_OF_MONTH, day);
			  int week = cal.get(Calendar.DAY_OF_WEEK);
			  if(week == 1){
				  count++;
			  }
				cal.clear();
		}		
		return Integer.toString(count);
	}
	
//	public void getWeekInMonths(String year, String month) {
//
//		  Calendar cal = Calendar.getInstance();
//		  int intYear=Integer.parseInt(year);
//		  int intMonth=Integer.parseInt(month);
//		  
//		  cal.set(Calendar.YEAR, intYear);
//		  cal.set(Calendar.MONTH, intMonth - 1);
//
//		  for (int week = 1; week < cal.getMaximum(Calendar.WEEK_OF_MONTH); week++) {
//		   cal.set(Calendar.WEEK_OF_MONTH, week);
//		 
//		   cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//		   int startDay = cal.get(Calendar.DAY_OF_MONTH);
//		 
//		   cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
//		   int endDay = cal.get(Calendar.DAY_OF_MONTH);
//		 
//		   if (week == 1 && startDay >= 7) {
//		    startDay = 1;
//		   }
//		 
//		   if (week == cal.getMaximum(Calendar.WEEK_OF_MONTH) - 1 && endDay <= 7) {
//		    endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//		   }
//		 
//		   System.out.println(week + "주 : " + startDay + " ~ " + endDay); 
//		  }
//		 } 

//    private void Payr4200Print(String fileName) {
// 
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PAYR";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		// 보낼 파라미터
//		
//		//권한 설정으로 인해 추가된 부분 
//        String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
//        String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
//        String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
//		
//		
//		//검색조건
//		String serarchParam = "";
// 	
// 	serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"year") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]";
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"year") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]";
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]"; 
//	serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]";
//	serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$8
//	//serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd") +"]";  //$9
//	serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$10
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";//$11
//	
////	serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";
////	serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
////	serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]";
//	 
////		List<BaseModel> list = pyyt0304GridPanel.getGrid().getSelectionModel().getSelectedItems();
////		String checkedSystemKeys = "";
////		if(list != null && list.size() > 0){
////			String chkkey = "";
////			for(BaseModel bm : list){
////				chkkey += "'"+bm.get("systemkey")+"',";
////			}
////			
////			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
////			
////		}
//	
//	   String checkedSystemKeys = "";
//     
//       serarchParam = serarchParam+"["+checkedSystemKeys+"]"; //$12
//       
//      //TODO 확인 
//       if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//           
//           serarchParam += "[]";  //$13
//           serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$14
//       
//       } else {
//           
//           //직종 권한에 대한 처리 추가 기본 처리  $9로해서 처리 할것...$13
////           if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
////                     && (Constants.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
////               serarchParam += "["+Constants.AUTH_TYPOCCUCD_10+"]"; 
////           } else {
////               serarchParam += "[]";
////           } 
//           
//           serarchParam += "[]";  //$14
//       }
//       
//       //권한처리를위해 넘기는 변수 2개추가 
//		serarchParam += ""+deptCdAuth+"⊥"; //$parameter14 부서 
//		serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; //parameter15 직종세 
//		//20151212-추가 끝 
//	
//		String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
//		
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//
//	}

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
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr4200Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createStandardForm();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr4200Form(); // 화면 기본정보를 설정
			createSearchForm(); // 검색필드를 적용
			createStandardForm(); // 기본정보필드
			vp.setSize("1010px", "700px");
	 
//				    /**
//				     * TODO 급여대상자에 따른 수당,공제,급여조정부분을 자동으로 불러오는 부분을 추가 한다...단계별진행........
//			          * Create the relations 
//			          */
//					   final RelationDef  relPayr0304 = new RelationDef(payr0304Def, false);
//					   relPayr0304.addJoinDef("pyytYrMnth", "pyytYrMnth");
//					   relPayr0304.addJoinDef("dpobCd", "dpobCd");
//					   relPayr0304.addJoinDef("systemkey", "systemkey");
//					   relPayr0304.addJoinDef("payCd", "payCd");
//					   relPayr0304.addJoinDef("payrSeilNum", "payrSeilNum"); 
//					   relPayr0304.setLinkedObject(pyyt0304GridPanel);
//					   pyyt0302ExtpyDef.addRelation(relPayr0304);  
//  
//					   // DETAILS 
//			           final Grid payr0304Grid = pyyt0304GridPanel.getMsfGrid().getGrid();
//			           payr0304Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
//			              public void handleEvent(BaseEvent be) {  
//			            	  if (pyyt0304GridPanel.getCurrentlySelectedItem() != null) { 
//			            		  
//			            		  //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//                                  leftPayr0304Detail(pyyt0304GridPanel.getCurrentlySelectedItem());
//                                 
//                                 
//                                  pyyt0302ExtpyDef.synchronizeGridDetail(
//			            				  pyyt0304GridPanel.getCurrentlySelectedItem(),
//			            				  pyyt0302ExtpyGridPanel ); 
//                                 
//			            		 
//			            		 // pyyt0302ExtpyGridPanel.reload(); 
//			            	   }
//			            	  
//			            	  actionDatabase = ActionDatabase.UPDATE;
//			              }
//			          }); 
//			           
//			           
//					   final RelationDef  relPayr030401 = new RelationDef(payr0304Def,false);
//			           relPayr030401.addJoinDef("pyytYrMnth", "pyytYrMnth");
//			           relPayr030401.addJoinDef("dpobCd", "dpobCd");
//			           relPayr030401.addJoinDef("systemkey", "systemkey");
//			           relPayr030401.addJoinDef("payCd", "payCd");
//			           relPayr030401.addJoinDef("payrSeilNum", "payrSeilNum"); 
//			           relPayr030401.setLinkedObject(pyyt0304GridPanel);
//			           payr0302DducDef.addRelation(relPayr030401);   
// 
//		 
//			           // DETAILS 
//			           final Grid payr0304Grid01 = pyyt0304GridPanel.getMsfGrid().getGrid();
//			           payr0304Grid01.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
//			              public void handleEvent(BaseEvent be) {  
//			            	  if (pyyt0304GridPanel.getCurrentlySelectedItem() != null) { 
//			            		   
//			            		 
//			            		  payr0302DducDef.synchronizeGridDetail(
//			            				  pyyt0304GridPanel.getCurrentlySelectedItem(),
//			            				  Pyyt0302DducGridPanel );
//			            		  
//			            		  //Pyyt0302DducGridPanel.reload(); 
//			            		   
//			            	   }
//			              }
// 			          }); 
// 
//			           
			     
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
	public Yeta6900() {

		setSize("1010px", "700px");
	}

	public Yeta6900(String txtForm) {
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
	private void createPayr4200Form() {

		plFrmYeta1900 = new FormPanel();
		plFrmYeta1900.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ "급여내역(정산용)관리");
		// plFrmYeta1900.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여(조정)내역관리");
		plFrmYeta1900.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta1900.setBodyStyleName("pad-text");
		plFrmYeta1900.setPadding(2);
		plFrmYeta1900.setFrame(true);
			
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("급여내역(정산용)관리","PAYR4200");
				}
			});
		plFrmYeta1900.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta1900.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmYeta1900.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
	        public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						//부서
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

		LayoutContainer layoutContainer = new LayoutContainer();

		LayoutContainer layoutContainer_1 = new LayoutContainer();

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		topYeta1900Bar = new ButtonBar();
		layoutContainer_2.add(topYeta1900Bar);
		topYeta1900Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
		  	
//		  	topBtn = new Button("삭제");  
//		  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//		  	buttonBar.add(topBtn);
		  	
		btnYeta1900Init = new Button("초기화");
		btnYeta1900Init.setIcon(MSFMainApp.ICONS.new16());
		topYeta1900Bar.add(btnYeta1900Init);
		btnYeta1900Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 초기화
				formInit();
			}
		});
				
		btnYeta1900Del = new Button("삭제");
		btnYeta1900Del.setIcon(MSFMainApp.ICONS.delete16());
		topYeta1900Bar.add(btnYeta1900Del);
		btnYeta1900Del.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				
		        if (pyyt0304GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() <= 0) {
		            
		            MessageBox.alert("경고", "삭제할 대상자를 선택해주세요.", null);
		            
		            return;
		        }
		        
		        
				// 선택된 데이터를 담는다.
				Iterator<BaseModel> itBm  = pyyt0304GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				
				List<Record>  lsRec  = new ArrayList<Record>();
	              
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
	                
	            Iterator<Record> iterRecords = lsRec.iterator() ; 
	            
        		final List<Pyyt0302DTO> listPyyt0302Dto = new ArrayList<Pyyt0302DTO>();  
    	        
        		while (iterRecords.hasNext()) {
                  
        			Record record = (Record) iterRecords.next(); 
        			BaseModel bmMapModel = (BaseModel)record.getModel();
                          
        			Pyyt0302DTO pyyt0302Dto = new Pyyt0302DTO();  
                        
        			pyyt0302Dto.setPyytItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytItemCd")));   	 			/** column 급여항목코드 : pyytItemCd */
        			pyyt0302Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    				/** column SYSTEMKEY : systemkey */
        			pyyt0302Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    						/** column 사업장코드 : dpobCd */
        			pyyt0302Dto.setPyytYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrMnth")));    				/** column 지급년월 : pyytYrMnth */
        			pyyt0302Dto.setPyytPymtDducCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytPymtDducCd")));    		/** column 지급공제구분코드 : pyytPymtDducCd */
        			pyyt0302Dto.setPyytPymtDducSum((Long) bmMapModel.get("pyytPymtDducSum"));    						/** column 지급공제금액 : pyytPymtDducSum */
        			pyyt0302Dto.setPyytPyddTxtnAmnt((Long) bmMapModel.get("pyytPyddTxtnAmnt"));    						/** column 지급공제과세금액 : pyytPyddTxtnAmnt */
        			pyyt0302Dto.setPyytPyddFreeDtySum((Long) bmMapModel.get("pyytPyddFreeDtySum"));    					/** column 지급공제비과세금액 : pyytPyddFreeDtySum */
        			pyyt0302Dto.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrtxDotnCd")));    		/** column 연말정산_기부금코드 : pyytYrtxDotnCd */
        			pyyt0302Dto.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYtfeDtyReduCd")));	/** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
//                        pyyt0302Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                        pyyt0302Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                        pyyt0302Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                        pyyt0302Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                        pyyt0302Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                        pyyt0302Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */                           
                        
                       
        			listPyyt0302Dto.add(pyyt0302Dto);
        		}   
        		
        		
				MessageBox.confirm("경고", "해당 대상자를 정말로 삭제하겠습니까?(기등록된 수당공제항목도 함께 삭제됩니다.)</BR> 삭제된 데이터는 복구되지 않습니다.", new Listener<MessageBoxEvent>() {
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// TODO Auto-generated method stub
						//if("Yes".equals(be.getButtonClicked().getText())) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
			        		yeta6900Service.deleteYeta6900List(listPyyt0302Dto, new AsyncCallback<Integer>() {
			                    public void onFailure(Throwable caught) {
			                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
			                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("deleteYeta1900List : " + caught), null);
			                    }
			                    public void onSuccess(Integer resultInt) { 
			                        if (resultInt == 0) {
			                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
			                                    "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
			                        } else {
			                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), resultInt + "건의 삭제 처리가 완료되었습니다.", null);
			                            reload();
			                        }
			                    }
			        		});
						} else {
							return;
						}
					}
				});
        		
        		
				

			}
		});
		btnYeta1900Del.addSelectionListener(selectionListener);

		btnYeta1900Sreach = new Button("조회");
		btnYeta1900Sreach.setIcon(MSFMainApp.ICONS.search16());
		topYeta1900Bar.add(btnYeta1900Sreach);
		btnYeta1900Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});
			  	
		btnYeta1900Print = new Button("인쇄");
		btnYeta1900Print.setIcon(MSFMainApp.ICONS.print16());
//		topYeta1900Bar.add(btnYeta1900Print);
		btnYeta1900Print.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				// Payr4200Print("PAYRT4200") ;
				
								
				
				String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
				String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
				String deptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
				String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

				
				
				
				if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
					if(emymtDivCd.equals("A0020010")){
						Payr4200Print("PAYRT4200",MSFMainApp.getMsg("PayGen.ReportDivisionType"));
					}else if(emymtDivCd.equals("A0020020")){
						if(deptCd == null || deptCd.equals("")){
							Window.alert("부서를 선택해 주세요");
							return;
						}	
						if(businCd == null || businCd.equals("")){	
							Window.alert("사업을 선택해 주세요");
							return;
						}
						RexPrint2("PAYRT420001");
					}else{
						Window.alert("고용구분을 선택해 주세요");
						return;
					}
				}else{
					Window.alert("단위기관/고용구분을 선택해 주세요");
					return;
				}
				
				
				
			}
		});
			  	
		btnYeta1900Excel = new Button("급여대장");
		btnYeta1900Excel.setIcon(MSFMainApp.ICONS.excel16());
		topYeta1900Bar.add(btnYeta1900Excel);
		btnYeta1900Excel.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				// exportExcel();
				// pyyt0304GridPanel.callExportServlet("");
				
//				Window.alert("준비중입니다.");
				
				
				String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
				String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
				String deptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
				String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

				
				
				
				if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
				if(emymtDivCd.equals("A0020010")){
						exportExcel01();
					}else if(emymtDivCd.equals("A0020020")){
						
//						Window.alert("준비중입니다.");
//						return;
////						if(deptCd == null || deptCd.equals("")){
////							Window.alert("부서를 선택해 주세요");
////							return;
////						}	
////						if(businCd == null || businCd.equals("")){	
////							Window.alert("사업을 선택해 주세요");
////							return;
////						}
						exportExcel02();
						//exportExcel();
					}else{
						Window.alert("고용구분을 선택해 주세요");
						return;
					}
				}else{
					Window.alert("단위기관/고용구분을 선택해 주세요");
					return;
				}
			}
		});

		btnYeta1900SumExcel = new Button("급여내역");
		btnYeta1900SumExcel.setIcon(MSFMainApp.ICONS.excel16());
//		topYeta1900Bar.add(btnYeta1900SumExcel);
		btnYeta1900SumExcel.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				exportTotExcel();
			}
		});
			   
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.setBorders(false);

		plFrmYeta1900.add(layoutContainer);

		// 파일업로드 처리
		plFrmYeta1900.setAction("bizform");
		plFrmYeta1900.setEncoding(Encoding.MULTIPART);
		plFrmYeta1900.setMethod(Method.POST);

		vp.add(plFrmYeta1900);
		plFrmYeta1900.setSize("990px", "680px");
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
		// 호봉
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월 
		
		lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------

		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
        sysComBass0400Dto.setDeptDspyYn("Y");
        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
        sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
         
        lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
         
        lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {  
        		mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
        		srhDeptCd.getInitStore().add(mDtalistDeptCd);
                  
        	}
        });     
          //--------------------급여부서 불러 오는 함수 ------------------------------------------------
        
        
        
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------
        lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------        
          
		// sysComBass0400Dto.setDeptDspyYn("Y");
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		// lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		// sysComBass0400Dto.setDeptDspyYn("");
			
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 직종 콤보박스 처리 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 */
	     	    
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});  
			 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 년도 콤보박스 처리  시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		 */
		
//		ContentPanel payYrGrid = new ContentPanel();
//		payYrGrid.setVisible(false);
//	  		    
//		//년도 콤보처리 
//	  	payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//	  	payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	  		public void handleEvent(ComponentEvent be) {  
//	  			payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	  				public void handleEvent(StoreEvent<BaseModel> be) {  
//	  					lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//	  			        	 
//	  			        	//  Date today = new Date(); 
//	  			        	    // A custom date format
//	  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	  			        	 
//	  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//	  			      	     // srhPayYr.setValue(bm);
//	  			        	//srhPayYr.setValue(lsPayYrStore.getAt(0));
//	  			        	//Date today = new Date(); 
//                            //DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                            //srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                     
//					}
//	  			});
//	  		}
//		});
//	  	  
//		payYrGrid.add(payYrGridPanel);
//		plFrmYeta1900.add(payYrGrid);

	  
	    plFrmYeta1900.setLayout(new FlowLayout());
	    
	    srhSystemkey = new HiddenField<String>(); 
	      
	    LayoutContainer lcSchCol = new LayoutContainer();
	    //lcSchCol.setStyleAttribute("background-color","red");
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
	    fieldSet.setStyleAttribute("marginTop", "10px");
	   
	   // fieldSet.setCheckboxToggle(false); 
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();
 
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_8.setLayout(frmlytSch);
	    
	    srhPayYr = new ComboBox<BaseModel>();
	    srhPayYr.setName("srhPayYr");
	    srhPayYr.setForceSelection(true);
	    srhPayYr.setMinChars(1);
	    srhPayYr.setDisplayField("yearDisp");
	    srhPayYr.setValueField("year");
	    srhPayYr.setTriggerAction(TriggerAction.ALL);
	   // srhPayYr.setEmptyText("--년도선택--");
	    srhPayYr.setSelectOnFocus(true); 
	    srhPayYr.setReadOnly(false);
	    srhPayYr.setEnabled(true); 
	    srhPayYr.setStore(lsPayYrStore);
	    srhPayYr.setFieldLabel("지급년월"); 
	    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    		    * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		    		    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		    		    * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		            	 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   checkPayr4200Auth("srhPayYr", lsPayYrStore); 
              	 }
            }
        });    
	    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        	BaseModel bmPayYr =  se.getSelectedItem(); 
	        	if (bmPayYr != null) {
	               
	        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                       
	        			if (srhDeptCd.getListView().getChecked().size() > 0) {  
                          
	        				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));
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
                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
                      // return;
	        		} 
	        	}       
	    	} 
		});   
	    layoutContainer_8.add(srhPayYr, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    layoutContainer_8.setBorders(false);
	    
	    LayoutContainer layoutContainer_9 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_9.setLayout(frmlytSch);
	    
	    /** column 지급년월 : Mnth */ 
	    srhPayMonth = new ComboBox<BaseModel>();
	    srhPayMonth.setName("srhPayMonth");
	    srhPayMonth.setForceSelection(true);
	    srhPayMonth.setMinChars(1);
	    srhPayMonth.setDisplayField("monthDisp");
	    srhPayMonth.setValueField("month");
	    srhPayMonth.setTriggerAction(TriggerAction.ALL);
	   // srhPayMonth.setEmptyText("--월선택--");
	    srhPayMonth.setSelectOnFocus(true); 
	    srhPayMonth.setReadOnly(false);
	    srhPayMonth.setEnabled(true); 
	    srhPayMonth.setStore(lsPayMonth);
	    srhPayMonth.setHideLabel(true);  
	    lsPayMonth.addStoreListener( new StoreListener<BaseModel>() {   
	    	public void handleEvent(StoreEvent<BaseModel> be) {  

            	EventType type = be.getType();
            	if (type == Store.Add) { 
            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
            			checkPayr4200Auth("srhPayMonth", lsPayMonth); 
            	}
            }
        });    
	    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    layoutContainer_9.setBorders(false);
	    
	    
	    LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_1_1 = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1_1.setLayout(frmlytSch);
	    
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
		    	    * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		    	    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		    	    * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    	   checkPayr4200Auth("srhEmymtDivCd", lsEmymtDivCd ); 
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
	    		} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
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
	    layoutContainer_1_1.add(srhEmymtDivCd, new FormData("100%"));
	    layoutContainer.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    layoutContainer.setBorders(false); 
	    
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0); 
//	    frmlytSch.setLabelWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(false);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	    srhRepbtyBusinDivCd.setValueField("commCd");
	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	    srhRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer_101.setBorders(false);
	    layoutContainer.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    
	    
	    
	    LayoutContainer layoutContainer_14 = new LayoutContainer();
	    layoutContainer_14.setBorders(false);
	    
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer_14.setLayout(frmlytSch);
        
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
            		 	checkPayr4200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
                		mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
                		srhDeptCd.getInitStore().add(mDtalistDeptCd);
                	}
                });  
        	} 
        });
        layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
        
        
       
        
        
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
        	 @Override
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
//        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                }
//            } 
//        }); 
        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
        layoutContainer_6.setBorders(false);
        
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        layoutContainer_btn.setLayout(frmlytSch);
        
        Button btnHanNm = new Button("검색");
//        layoutContainer_5.add(btnHanNm);
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                srhSystemkey.setValue("");
                srhResnRegnNum.setValue("");   
                fnPopupPsnl0100() ;
            }
        });
        layoutContainer_btn.add(btnHanNm);
        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));
        
        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_7.setLayout(frmlytSch);
         
        
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        srhResnRegnNum.setHideLabel(true);
        srhResnRegnNum.setName("srhResnRegnNum");
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
        srhResnRegnNum.setLabelSeparator("");
     //   srhResnRegnNum.setFieldLabel("주민번호");
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
        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
        layoutContainer_7.setBorders(false); 
        layoutContainer_5.setBorders(false);
        
//	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 			// 지급년월
//	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 단위기관 
//	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 고용구분
//	    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명, 주민등록번호
        
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급년월
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관 
	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
	    
	    
	    
	    
	    LayoutContainer layoutContainer_13 = new LayoutContainer();
	    layoutContainer_13.setLayout(new ColumnLayout());
	    
        LayoutContainer layoutContainer_1 = new LayoutContainer();
        layoutContainer_1.setBorders(false);
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer_1.setLayout(frmlytSch);
        
        srhPayCd =  new ComboBox<BaseModel>(); 
        srhPayCd.setName("srhPayCd");
        srhPayCd.setForceSelection(true);
        srhPayCd.setMinChars(1);
        srhPayCd.setDisplayField("commCdNm");
        srhPayCd.setValueField("commCd");
        srhPayCd.setTriggerAction(TriggerAction.ALL);
        srhPayCd.setEmptyText("--급여구분선택--");
        srhPayCd.setSelectOnFocus(true); 
//        srhPayCd.setReadOnly(true);
//        srhPayCd.setEnabled(false); 
        srhPayCd.setStore(lsPayCd);
        srhPayCd.setFieldLabel("급여구분");
        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	checkPayr4200Auth("srhPayCd",lsPayCd);   
            }
        });    
        layoutContainer_1.add(srhPayCd, new FormData("100%"));
	    
	    
	    
	   
	    
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	   
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_2.setLayout(frmlytSch);
	    
	    srhDeptCd = new MSFMultiComboBox<ModelData>();
        srhDeptCd.setName("srhDeptCd");
       // srhDeptCd.setForceSelection(true);
       // srhDeptCd.setMinChars(1);
        //srhDeptCd.setDisplayField("deptNmRtchnt");
        //srhDeptCd.setValueField("deptCd");
       // srhDeptCd.setTriggerAction(TriggerAction.ALL);
        srhDeptCd.setEmptyText("--부서선택--");
       // srhDeptCd.setSelectOnFocus(true); 
       // srhDeptCd.setReadOnly(false);
      //  srhDeptCd.setEnabled(true); 
        //srhDeptCd.setStore(lsDeptCd );
        //srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
        srhDeptCd.getStore().add(mDtalistDeptCd);
        srhDeptCd.setWidth(80);
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
        			checkPayr4200Auth("srhDeptCd", lsDeptCd); 
        		}
            }
        });    
 
        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
        	@Override
        	public void handleEvent(ComponentEvent ce) { 
                   
        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        			if (srhDeptCd.getListView().getChecked().size() > 0) {  
        				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));    
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
        			String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
        			sysComBass0320Dto.setDeptCd(strDeptCd);
        			lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            		public void handleEvent(StoreEvent<BaseModel> be) {  
	            			mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	            			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	            		}
	            	});  
		     	} else {
		     		sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		     		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		     		sysComBass0320Dto.setDeptCd(strDeptCd);
		     		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		     		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		     			public void handleEvent(StoreEvent<BaseModel> be) {  
		     				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
               
                //new SelectionChangedListener<ModelData>() {
         //@Override
         //public void selectionChanged(SelectionChangedEvent<ModelData> se) {
         //.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
         //  public void selectionChanged(SelectionChangedEvent<ModelData> se) {
            
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//             BaseModel bmPayCd =  se.getSelectedItem(); 
//             if (bmPayCd != null && Constants.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//                 if (bmPayCd != null) {  
//                    
//                     sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//                     sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//                 }      
//              
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//                   lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                  //--------------------사업 불러 오는 함수 -------------------------------------------------
//                   srhBusinCd.setStore(lsBusinCd); 
//                   srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                       public void handleEvent(StoreEvent<BaseModel> be) {  
//                        //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                       }
//                   });    
//             
//             }  
            
            } 
        });
	    //검색 소속부서 코드 처리  
//        LayoutContainer lccmlcDeptNm = new LayoutContainer();
//        lccmlcDeptNm.setLayout(new ColumnLayout());
//           //부서 
//        srhDeptCd = new TextField<String>();
//        srhDeptCd.setName("srhDeptCd");
//        srhDeptCd.setVisible(false);
//        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//            @Override
//            public void handleEvent(BaseEvent be) { 
//              if(srhDeptCd.getValue() != null){ 
//                 
//                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
//                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//                  
//                    //--------------------사업 불러 오는 함수 -------------------------------------------------
//                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//                      srhBusinCd.setStore(lsBusinCd); 
//                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                          public void handleEvent(StoreEvent<BaseModel> be) {  
//                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                          }
//                      });    
//                 
//              } 
//            }
//         });
//        plFrmYeta1900.add(srhDeptCd);
//        srhMangeDeptCd = new TextField<String>();
//        srhMangeDeptCd.setName("srhMangeDeptCd");
//        srhMangeDeptCd.setVisible(false);
//        plFrmYeta1900.add(srhMangeDeptCd);
//        srhMangeDeptNm = new TextField<String>();
//        srhMangeDeptNm.setName("srhMangeDeptNm");
//        srhMangeDeptNm.setVisible(false);
//        plFrmYeta1900.add(srhMangeDeptNm);
//  
//         LayoutContainer lcDeptNm = new LayoutContainer(); 
//         frmlytSch = new FormLayout();
//         frmlytSch.setLabelWidth(70);
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//         lcDeptNm.setLayout(frmlytSch);
//      
//         srhDeptNm = new TextField<String>();
//         srhDeptNm.setName("srhDeptNm");
//         srhDeptNm.setFieldLabel("부서");  
//         srhDeptNm.addKeyListener(new KeyListener() {
//              public void componentKeyUp(ComponentEvent event) {
//                  super.componentKeyUp(event); 
//                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                      if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                          srhDeptCd.setValue("");
//                          srhMangeDeptCd.setValue("");
//                      }
//                      fnPopupCommP140(srhDeptNm.getValue());
//                  }
//              }
//          });
//         
//         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                    @Override
//                    public void handleEvent(BaseEvent be) { 
//                         
//                        if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                            srhDeptCd.setValue("");
//                            srhMangeDeptCd.setValue("");
//                        }
//                     
//                    } 
//           });        
//          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//          
//           btnSrhDeptCd = new Button();
//           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//               public void handleEvent(ButtonEvent e) { 
//                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                       srhDeptCd.setValue("");
//                       srhMangeDeptCd.setValue("");
//                   }
//                   fnPopupCommP140(srhDeptNm.getValue()); 
//               }
//           });
//            
//           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
             
	    layoutContainer_2.add(srhDeptCd, new FormData("100%"));
	    layoutContainer_2.setBorders(false);
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_10.setLayout(frmlytSch);
        
        //직종 직종세처리  
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
        
        
	     LayoutContainer layoutContainer_211 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.LEFT ); 
	     layoutContainer_211.setLayout(frmlytSch); 
	    
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
	     
	     
	     layoutContainer_211.add(srhDeptGpCd, new FormData("100%")); 
        
        
        
           
        LayoutContainer layoutContainer_21 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(1); 
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_21.setLayout(frmlytSch); 
        
//        srhTypOccuCd = new ComboBox<BaseModel>(); 
//        srhTypOccuCd.setName("srhTypOccuCd");
//        srhTypOccuCd.setForceSelection(true);
//        srhTypOccuCd.setMinChars(1);
//        srhTypOccuCd.setDisplayField("typOccuNm");
//        srhTypOccuCd.setValueField("typOccuCd");
//        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//        srhTypOccuCd.setEmptyText("--직종선택--");
//        srhTypOccuCd.setSelectOnFocus(true); 
//        srhTypOccuCd.setReadOnly(false);
//        srhTypOccuCd.setEnabled(true); 
//        srhTypOccuCd.setStore(lsTypOccuCd); 
//        srhTypOccuCd.setFieldLabel("직 종");  
//        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                //직종변경에 따른 직종세 값 가져오기
//                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//                    sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                        LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//                    }
//                }
//            } 
//        }); 
//        lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
// 
 
//                
//            }
//        });    
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
        srhTypOccuCd.setHideLabel(true);
//        srhTypOccuCd.setLabelSeparator("");
//        srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	
            	   EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			    		   //2015.11.30 추가 
			    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
		         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
			                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
			                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
			                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
			                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
			                      //         mdSelect = tpMdSelect;
			                         //  } 
			                     //  }  
			                   
			                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
			                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
			                   // }  
			                    
		                }  
		    		   }	   
	            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkPayr4200Auth("srhTypOccuCd", lsTypOccuCd); 
              	 }
                
            }
        });     
        
        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
           @Override
          public void handleEvent(ComponentEvent ce) { 
        	   //2015.11.30 추가 
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
        
	      //2015.11.30 추가 
	        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
	            @Override
	            public void handleEvent(BaseEvent ce) {   
	            	
	            	displayDtilOccuInttnCd();
	            } 
	        }); 
        layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
        
        LayoutContainer lcSchRight = new LayoutContainer();
      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(1); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        frmlytSch.setDefaultWidth(0);
       // fieldSet.setLayout(layout);  
        lcSchRight.setLayout(frmlytSch);
        
        /** column 직종세코드 : dtilOccuInttnCd */
//        srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//        srhDtilOccuInttnCd.setForceSelection(true);
//        srhDtilOccuInttnCd.setMinChars(1);
//        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//        srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//        srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//        srhDtilOccuInttnCd.setSelectOnFocus(true); 
//        srhDtilOccuInttnCd.setReadOnly(false);
//        srhDtilOccuInttnCd.setEnabled(true);  
//        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//      //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//        srhDtilOccuInttnCd.setLabelSeparator("");
       
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
        
        lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
        layoutContainer_21.setBorders(false);
        
        layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
        layoutContainer_10.setBorders(false);
        
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
	    srhBusinCd.setEnabled(true); 
	    srhBusinCd.setStore(lsBusinCd);
	    srhBusinCd.setFieldLabel("사업");
	    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	    layoutContainer_4.setBorders(false);
	    fieldSet.add(layoutContainer_13);
	    layoutContainer_13.setBorders(false);
	    
//	    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	// 급여구분
//	    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 부서
//	    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 직종
//	    layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 사업
	    
	    
	    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 급여구분
	    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
	    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
	    
	    
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
	    
        LayoutContainer layoutContainer_16 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_16.setLayout(frmlytSch);
        
        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 사업
        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명
        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));// 
        
        fieldSet.add(lcSchCol3);
	    
		
	    plFrmYeta1900.add(fieldSet); 
	//vp.add(panel);   
	}  

 
	private void  displayDtilOccuInttnCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
         
         //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
             
             sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
             List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
             String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
             sysComBass0350Dto.setDeptCd(strDeptCd);
             List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
             String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
             sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
             
            // sysComBass0350Dto.setPyspGrdeCd(YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
             
             if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                 
                 lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
               //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                 
                 lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                         mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
                         srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                         
                         if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
                     	    ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
	  		                   
	  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
	  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
	  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
	  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
	  		                      //         mdSelect = tpMdSelect;
	  		                         //  } 
	  		                     //  }  	
	  		                   
                     	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
                     	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
	  		                   // }  
 	                 } 
                     }
                 });     
                 
             } 
          
       } else {
        
       } 
     //직종변경에 따른 직종세 값 가져오기
//     String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//     if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//         sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//         sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//         if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//             lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//             srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//         }
//     }   
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
	  
		sysComBass0300Dto = new PrgmComBass0300DTO();
	 
	    
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//급여구분 
		sysComBass0300Dto.setRpsttvCd("B008");
		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		dpobCd = new HiddenField<String>(); 			// 사업장코드
		systemkey = new HiddenField<String>();			/** column SYSTEMKEY : systemkey */
//		pyytYrMnth = new HiddenField<String>();			/** column 지급년월 : pyytYrMnth */
//		payCd = new HiddenField<String>();				/** column 급여구분코드 : payCd */
		payrMangDeptCd = new HiddenField<String>();		/** column 단위기관코드 : payrMangDeptCd */
//		payrSeilNum = new HiddenField<Long>();			/** column 급여일련번호 : payrSeilNum */
		emymtDivCd = new HiddenField<String>();			/** column 고용구분코드 : emymtDivCd */
		deptCd = new HiddenField<String>();				/** column 부서코드 : deptCd */
		businCd = new HiddenField<String>();			/** column 사업코드 : businCd */
		typOccuCd = new HiddenField<String>();			/** column 직종코드 : typOccuCd */
		typOccuNm = new HiddenField<String>();
		logSvcYrNumCd = new HiddenField<String>();		/** column 근속년수코드 : logSvcYrNumCd */
		pyytTxtnTotAmnt = new HiddenField<Long>();			/** column 과세총액 : pyytTxtnTotAmnt */
//		bnkCd = new HiddenField<String>();				/** column 은행코드 : bnkCd */
//		bnkNm = new HiddenField<String>();				/** column 은행코드 : bnkNm */
//		bnkAccuNum = new HiddenField<String>();			/** column 은행계좌번호 : bnkAccuNum */
//		acntHodrNm = new HiddenField<String>();			/** column 예금주명 : acntHodrNm */
//		payDdlneDt = new HiddenField<String>();			/** column 급여마감일자 : payDdlneDt */
//		payDdlneYn = new HiddenField<String>();			/** column 급여마감여부 : payDdlneYn */
		pyytTxTotAmnt = new HiddenField<Long>();    
	      
		LayoutContainer layoutContainer = new LayoutContainer();
		
		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize("290px", "440px");
		fldstNewFieldset.setHeadingHtml("급여대상자정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer_1.add(fldstNewFieldset);
		layoutContainer_1.setBorders(false);
		layoutContainer_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		layoutContainer1.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
//		layoutContainer.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		
//		LayoutContainer layoutContainer_10 = new LayoutContainer();
//		layoutContainer_10.setLayout(new FitLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize(695, 440);

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("급여상세정보");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());
		
		FieldSet fldstNewFieldset_4 = new FieldSet();
		fldstNewFieldset_4.setCollapsible(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.add(payrLeft01());
		fldstNewFieldset_4.add(layoutContainer_4);
		layoutContainer_4.setBorders(false);
		layoutContainer_3.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.58));
		fldstNewFieldset_4.setHeadingHtml("수 당");
		 
		
		FieldSet fldstNewFieldset_5 = new FieldSet();
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.add(payrLeft02());
		fldstNewFieldset_5.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);
		layoutContainer_3.add(fldstNewFieldset_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		fldstNewFieldset_5.setHeadingHtml("공 제");
		fldstNewFieldset_5.setCollapsible(false);
		fldstNewFieldset_1.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);
		
		layoutContainer_2.setBorders(false);
		layoutContainer1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.72));
		
		layoutContainer.add(layoutContainer1);
		
//		layoutContainer.add(layoutContainer_2);
		
		
		LayoutContainer layoutContainer2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
//		fldstNewFieldset_2.setSize(622, 70);
		fldstNewFieldset_2.setHeadingHtml("업로드");
		fldstNewFieldset_2.setCollapsible(false);
//		fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
		layoutContainer2.add(fldstNewFieldset_2);
		layoutContainer.add(layoutContainer2);
		
		    
		plFrmYeta1900.add(layoutContainer);
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
	private LayoutContainer occupationalRTop() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
//		cp01.setSize(640, 100);
		cp01.setSize(680, 100);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_111 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_111.setLayout(frmlytStd);

		pyytYrMnth = new TextField<String>();
		pyytYrMnth.setReadOnly(true);
		layoutContainer_111.add(pyytYrMnth, new FormData("100%"));
		pyytYrMnth.setFieldLabel("지급년월");
		layoutContainer_5.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_111.setBorders(false);		
		
		

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		hanNm = new TextField<String>();
		layoutContainer_6.add(hanNm, new FormData("100%"));
		hanNm.setFieldLabel("성명");
		hanNm.setReadOnly(true);
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

//		secRegnNum = new HiddenField<String>();

		resnRegnNum = new TextField<String>();
		resnRegnNum.setReadOnly(true);
		resnRegnNum.setLabelSeparator("");
		layoutContainer_7.add(resnRegnNum, new FormData("100%"));
		// resnRegnNum.setFieldLabel("주민번호");
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);

		logSvcYrNumNm = new TextField<String>();
		logSvcYrNumNm.setReadOnly(true);
		layoutContainer_8.add(logSvcYrNumNm, new FormData("100%"));
		logSvcYrNumNm.setFieldLabel("근속년수");
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_8.setBorders(false);
		lytCtr01.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		deptNm = new TextField<String>();
		deptNm.setReadOnly(true);
		layoutContainer_10.add(deptNm, new FormData("100%"));
		deptNm.setFieldLabel("부서");
		layoutContainer_9.add(layoutContainer_10,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_10.setBorders(false);

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		businNm = new TextField<String>();
		businNm.setReadOnly(true);
		layoutContainer_11.add(businNm, new FormData("100%"));
		businNm.setFieldLabel("직종/사업");
		layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_11.setBorders(false);
		lytCtr01.add(layoutContainer_9);
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);

		pyytPymtTotAmnt = new NumberField();
		pyytPymtTotAmnt.setReadOnly(true);
		layoutContainer_13.add(pyytPymtTotAmnt, new FormData("100%"));
		pyytPymtTotAmnt.setFieldLabel("급여합계");
		pyytPymtTotAmnt.setAllowDecimals(true);
		pyytPymtTotAmnt.setFormat(NumberFormat.getDecimalFormat());
		// pyytPymtTotAmnt.setPropertyEditor(new NumberPropertyEditor(Long.class));

		layoutContainer_12.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_13.setBorders(false);

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);

		pyytExtpyTotAmnt = new MSFNumberField();
		pyytExtpyTotAmnt.setReadOnly(true);
		layoutContainer_14.add(pyytExtpyTotAmnt, new FormData("100%"));
		pyytExtpyTotAmnt.setFieldLabel("수당합계");
		pyytExtpyTotAmnt.setAllowDecimals(true);
		pyytExtpyTotAmnt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_12.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytStd);

		pyytDducTotAmnt = new NumberField();
		pyytDducTotAmnt.setReadOnly(true);
		layoutContainer.add(pyytDducTotAmnt, new FormData("100%"));
		pyytDducTotAmnt.setFieldLabel("공제금액");
		pyytDducTotAmnt.setAllowDecimals(true);
		pyytDducTotAmnt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_12.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer.setBorders(false);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		pyytPernPymtSum = new NumberField();
		pyytPernPymtSum.setReadOnly(true);
		layoutContainer_1.add(pyytPernPymtSum, new FormData("100%"));
		pyytPernPymtSum.setFieldLabel("실수령액");
		pyytPernPymtSum.setAllowDecimals(true);
		pyytPernPymtSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_1.setBorders(false);
		lytCtr01.add(layoutContainer_12);
		layoutContainer_12.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		pyytB10100Sum = new NumberField();
		pyytB10100Sum.setReadOnly(true);
		layoutContainer_3.add(pyytB10100Sum, new FormData("100%"));
		pyytB10100Sum.setFieldLabel("기본급");
		pyytB10100Sum.setAllowDecimals(true);
		pyytB10100Sum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		pyytT10100Sum = new NumberField();
		pyytT10100Sum.setReadOnly(true);
		layoutContainer_4.add(pyytT10100Sum, new FormData("100%"));
		pyytT10100Sum.setFieldLabel("소득세");
		pyytT10100Sum.setAllowDecimals(true);
		pyytT10100Sum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_4.setBorders(false);

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytStd);

		pyytT20100Sum = new NumberField();
		pyytT20100Sum.setReadOnly(true);
		layoutContainer_15.add(pyytT20100Sum, new FormData("100%"));
		pyytT20100Sum.setFieldLabel("지방세");
		pyytT20100Sum.setAllowDecimals(true);
		pyytT20100Sum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_2.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_15.setBorders(false);
	   
		LayoutContainer layoutContainer_16 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytStd);

		pyytFreeDtyTotAmnt = new NumberField();
		pyytFreeDtyTotAmnt.setReadOnly(true);

		layoutContainer_16.add(pyytFreeDtyTotAmnt, new FormData("100%"));
		pyytFreeDtyTotAmnt.setFieldLabel("비과세");
		pyytFreeDtyTotAmnt.setAllowDecimals(true);
		pyytFreeDtyTotAmnt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_2.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_16.setBorders(false);
		lytCtr01.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		cp01.add(lytCtr01);

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
		cp01.setSize(255, 420);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		pyyt0304GridPanel = new MSFGridPanel(pyyt0304Def, false, false, false, false, false);
		pyyt0304GridPanel.setHeaderVisible(false);
		pyyt0304GridPanel.setBodyBorder(true);
		pyyt0304GridPanel.setBorders(true);
	    final Grid pyyt0304Grid = pyyt0304GridPanel.getMsfGrid().getGrid();
	    pyyt0304Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {

	    	public void handleEvent(BaseEvent be) {   
	    		
	    		payrInfoReload();

           }
       }); 		
   //  pyyt0304GridPanel.setSize(308, 340);  
    //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//      final Grid payr0304Grid = pyyt0304GridPanel.getMsfGrid().getGrid(); 
//      payr0304Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {  
//              if (pyyt0304GridPanel.getCurrentlySelectedItem() != null) {  
//                 
//                  
//              }
//            }
//        });  
    
		cp01.add(pyyt0304GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	} 


	private LayoutContainer payrLeft01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(390, 270);

	    MSFCustomForm msfCustomForm = new MSFCustomForm(pyyt0302ExtpyDef, 0, 0, false, false, false);
	    msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		pyyt0302ExtpyGridPanel = new MSFGridPanel(pyyt0302ExtpyDef, false,false, false, false, false);
		pyyt0302ExtpyGridPanel.setHeaderVisible(false);
		pyyt0302ExtpyGridPanel.setBodyBorder(true);
		pyyt0302ExtpyGridPanel.setBorders(true);
		// pyyt0302ExtpyGridPanel.setSize(300, 140);
		pyyt0302ExtpyGridPanel.setMSFFormPanel(msfCustomForm);
		pyyt0302ExtpyGridPanel.getBottomComponent().setVisible(true);
		
		
		final Grid pyyt0302ExtpyGrid = pyyt0302ExtpyGridPanel.getMsfGrid().getGrid();
		pyyt0302ExtpyGrid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (pyyt0302ExtpyGridPanel.getCurrentlySelectedItem() != null) {      

					pyyt0302ExtpyGridPanel.getMSFFormPanel().bind(pyyt0302ExtpyGridPanel.getCurrentlySelectedItem());

				} 
			}
		}); 
		

		cp01.add(pyyt0302ExtpyGridPanel);
		
		
		ButtonBar barBtn = new ButtonBar();
		barBtn.setAlignment(HorizontalAlignment.RIGHT);
			    
		  	
		Button btnSave = new Button("저장");
		btnSave.setIcon(MSFMainApp.ICONS.save16());
		barBtn.add(btnSave);
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
		        if (pyyt0302ExtpyGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
		            
		            MessageBox.alert("수당", "저장할 수당데이타가 존재하지 않습니다.", null);
		            
		            return;
		        }
		        
		        // 수정된 데이터를 담는다.
		        Iterator<Record> iterRecords = pyyt0302ExtpyGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		        
				savePyyt0302(iterRecords, "save");
			}
		});
		
		
		Button btnDel = new Button("삭제");
		btnDel.setIcon(MSFMainApp.ICONS.delete16());
		barBtn.add(btnDel);
		btnDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				List<BaseModel> list = pyyt0302ExtpyGridPanel.getGrid().getSelectionModel().getSelectedItems();
				
				
				if(list == null && list.size() <=0 ){
					 MessageBox.alert("수당", "삭제할 수당데이타가 존재하지 않습니다.", null);
					 return;
				}
				
				
				// 선택된 데이터를 담는다.
				Iterator<BaseModel> itBm  = pyyt0302ExtpyGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				
				List<Record>  lsRec  = new ArrayList<Record>();
	              
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
	                
	            Iterator<Record> iterRecords = lsRec.iterator() ; 
	            
	            savePyyt0302(iterRecords, "del");
				
				
			}
		});
		
		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(barBtn);

		return lcTabFormLayer;

	}
 
 
 	private LayoutContainer payrLeft02() {
	   
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(280, 270);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		Pyyt0302DducGridPanel = new MSFGridPanel(pyyt0302DducDef, false, false,false, false);
		Pyyt0302DducGridPanel.setHeaderVisible(false);
		Pyyt0302DducGridPanel.setBodyBorder(true);
		Pyyt0302DducGridPanel.setBorders(true);
		Pyyt0302DducGridPanel.getBottomComponent().setVisible(true);
		// Pyyt0302DducGridPanel.setSize(300, 140);
		

		cp01.add(Pyyt0302DducGridPanel);
		
		ButtonBar barBtn = new ButtonBar();
		barBtn.setAlignment(HorizontalAlignment.RIGHT);
			    
		  	
		Button btnSave = new Button("저장");
		btnSave.setIcon(MSFMainApp.ICONS.save16());
		barBtn.add(btnSave);
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
		        if (Pyyt0302DducGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
		            
		            MessageBox.alert("공제", "저장할 공제 데이타가 존재하지 않습니다.", null);
		            
		            return;
		        }
		        
		        // 수정된 데이터를 담는다.
		        Iterator<Record> iterRecords = Pyyt0302DducGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
				
				savePyyt0302(iterRecords, "save");
			}
		});
		
		
		Button btnDel = new Button("삭제");
		btnDel.setIcon(MSFMainApp.ICONS.delete16());
//		btnDel.setIcon(MSFMainApp.ICONS.new16());
		barBtn.add(btnDel);
		btnDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				List<BaseModel> list = Pyyt0302DducGridPanel.getGrid().getSelectionModel().getSelectedItems();
				
				if(list == null && list.size() <=0 ){
					 MessageBox.alert("공제", "삭제할 공제 데이타가 존재하지 않습니다.", null);
					 return;
				}
				
				
				// 선택된 데이터를 담는다.
				Iterator<BaseModel> itBm  = Pyyt0302DducGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				
				List<Record>  lsRec  = new ArrayList<Record>();
	              
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
	                
	            Iterator<Record> iterRecords = lsRec.iterator() ; 
	            
	            savePyyt0302(iterRecords, "del");
			}
		});
		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(barBtn);

		return lcTabFormLayer;
	   
 	}
 
	// 엑셀 업로드
	private LayoutContainer occupationalRBottom() {
	      
//		FieldSet fldstNewFieldset = new FieldSet();
//		fldstNewFieldset.setHeadingHtml("");
//		fldstNewFieldset.setStyleAttribute("marginTop", "10px");
	
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());
	
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
		    
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_21.setLayout(frmlytSch);
	    layoutContainer_21.setBorders(false);
	    
	    Yeta6900flUp = new FileUploadField();
	    Yeta6900flUp.setFieldLabel("급여업로드");
		Yeta6900flUp.setName("Yeta6900flUp");
		Yeta6900flUp.setValidator(new Validator() {  
			@Override 
			public String validate(Field<?> field, String value) { 
				value = value.toLowerCase();        
				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
				if(value.endsWith(".xls") ){           
					result = null;        
	         	}        
				return result;  
	    	} 
		});
		Yeta6900flUp.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
	//			excelGrid.getStore().removeAll();
			}
	    });
		
		
		layoutContainer_21.add(Yeta6900flUp, new FormData("100%"));
		
		
		
		LayoutContainer layoutContainer_42 = new LayoutContainer(); 
		//layoutContainer_42.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(40); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_42.setLayout(frmlytSch);
	    
		ListStore<BaseModel> lsExlType = new ListStore<BaseModel>();
		BaseModel exlTypeBaseModel = new BaseModel();
		exlTypeBaseModel.set("commCd", "typ01");
		exlTypeBaseModel.set("commNm", "양식1");
		lsExlType.add(exlTypeBaseModel);
		
		exlTypeBaseModel = new BaseModel();
		exlTypeBaseModel.set("commCd", "typ02");
		exlTypeBaseModel.set("commNm", "양식2 : 별도인사");
		lsExlType.add(exlTypeBaseModel);
	    
	    exlType = new ComboBox<BaseModel>();
	    exlType.setFieldLabel("양식");
		exlType.setForceSelection(true);
		
		exlType.setDisplayField("commNm");
		exlType.setValueField("commCd");
		exlType.setMinChars(1);
		exlType.setTriggerAction(TriggerAction.ALL);
		exlType.setEmptyText("--양식선택--");
		exlType.setStore(lsExlType);
		exlType.setSelectOnFocus(true);
  		exlType.setValue(lsExlType.findModel("commCd", "typ02"));
//		exlType.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				YetaUtils.setSelectedComboValue(exlType, "typ01", "commCd");
//			}
//		});
//		
		layoutContainer_42.add(exlType, new FormData("95%"));
	    
		
//		Button btnButton03 = new Button("양식1");
//		btnButton03.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				xlsExportData("typ01");
//			}
//		}); 
//		layoutContainer_42.add(btnButton03, new FormData("95%"));
		layoutContainer_42.setBorders(false);
		
		LayoutContainer layoutContainer_43 = new LayoutContainer(); 
		//layoutContainer_42.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_43.setLayout(frmlytSch);
		
		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
		        if("".equals(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"))) {
		        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"다운로드 할 양식을 선택해주세요.", null);
		        	return;
		        }
		        
		        if("typ01".equals(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"))) {
		        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"준비중입니다.", null);
		        	return;
		        }
				
				xlsExportData(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"));
			}
		}); 
		layoutContainer_43.add(btnButton02, new FormData("95%"));
		layoutContainer_43.setBorders(false);
		
	
		  
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnButton01 = new Button("업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
		        if("".equals(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"))) {
		        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"업로드 할 양식을 선택해주세요.", null);
		        	return;
		        }else {
		        	if("typ01".equals(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"))) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"준비중입니다.", null);
						return;
		        		
//		        		if("typ02".equals(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"))) {
//		                	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"준비중입니다.", null);
//		                	return;
//		                }
		        	}
		        }
	           	xlsImportData(); 
			}
		});
		layoutContainer_3.add(btnButton01, new FormData("95%"));
		layoutContainer_3.setBorders(false);
	

		
		layoutContainer_2.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.add(layoutContainer_42,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_43,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
	//	layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer.add(layoutContainer_1);
//		fldstNewFieldset.add(layoutContainer);
//		
//		cpPayr4200.add(fldstNewFieldset);
		return layoutContainer;
	} 

  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 

    private void leftPayr0304Detail(BaseModel selRecord) {
    	 
    	
    	 dpobCd.setValue((String)selRecord.get("dpobCd"));  //사업장코드
     	 systemkey.setValue((String)selRecord.get("systemkey"));    /** column SYSTEMKEY : systemkey */
    	 pyytYrMnth.setValue((String)selRecord.get("pyytYrMnth"));   /** column 지급년월 : pyytYrMnth */
//    	 payCd.setValue((String)selRecord.get("payCd")) ;  /** column 급여구분코드 : payCd */
    	 payrMangDeptCd.setValue((String)selRecord.get("payrMangDeptCd"));   /** column 단위기관코드 : payrMangDeptCd */
//    	 payrSeilNum.setValue((Long)selRecord.get("payrSeilNum"));   /** column 급여일련번호 : payrSeilNum */
    	 emymtDivCd.setValue((String)selRecord.get("emymtDivCd"));   /** column 고용구분코드 : emymtDivCd */
     	 hanNm.setValue((String)selRecord.get("hanNm")) ;  /** column 한글성명 : hanNm */
    	 resnRegnNum.setValue((String)selRecord.get("resnRegnNum"));   /** column 주민등록번호 : resnRegnNum */
    	 
//    	 secRegnNum.setValue((String)selRecord.get("secRegnNum"));   /** column 주민등록번호 : secRegnNum */
    	 
    	 deptCd.setValue((String)selRecord.get("deptCd")) ;  /** column 부서코드 : deptCd */
    	 deptNm.setValue((String)selRecord.get("deptNm")) ;  /** column 부서 : deptNm */
    	 businCd.setValue((String)selRecord.get("businCd"));   /** column 사업코드 : businCd */
    	 
    	// if (MSFSharedUtils.paramNull(typOccuNm.getRawValue())) {
    	//	 businNm.setFieldLabel("사업");
    	//	 businNm.setValue((String)selRecord.get("businNm"));   /** column 사업코드 : businNm */ 
    	// } else {
    		 businNm.setFieldLabel("직종");
    		 businNm.setValue((String)selRecord.get("typOccuNm")) ;  /** column 직종코드 : typOccuNm */
    	// }
    	 typOccuCd.setValue((String)selRecord.get("typOccuCd"));   /** column 직종코드 : typOccuCd */ 
    	 logSvcYrNumCd.setValue((String)selRecord.get("logSvcYrNumCd")) ;  /** column 근속년수코드 : logSvcYrNumCd */
    	 logSvcYrNumNm.setValue((String)selRecord.get("logSvcYrNumNm")) ;  /** column 근속년수 : logSvcYrNumNm */
    	 pyytPymtTotAmnt.setValue((Long)selRecord.get("pyytPymtTotAmnt"));   /** column 지급총액 : pyytPymtTotAmnt */
    	 pyytExtpyTotAmnt.setValue((Long)selRecord.get("pyytExtpyTotAmnt")) ;  /** column 수당총액 : pyytExtpyTotAmnt */
    	 pyytTxtnTotAmnt.setValue((Long)selRecord.get("pyytTxtnTotAmnt"));   /** column 과세총액 : pyytTxtnTotAmnt */
    	 pyytFreeDtyTotAmnt.setValue((Long)selRecord.get("pyytFreeDtyTotAmnt"));   /** column 비과세총액 : pyytFreeDtyTotAmnt */
    	 pyytDducTotAmnt.setValue((Long)selRecord.get("pyytDducTotAmnt"));   /** column 공제총액 : pyytDducTotAmnt */
    	 pyytTxTotAmnt.setValue((Long)selRecord.get("pyytTxTotAmnt"));   /** column 세금총액 : pyytTxTotAmnt */
    	 pyytPernPymtSum.setValue((Long)selRecord.get("pyytPernPymtSum")) ;  /** column 차인지급액 : pyytPernPymtSum */
//    	 bnkCd.setValue((String)selRecord.get("bnkCd"));   /** column 은행코드 : bnkCd */
//    	 bnkNm.setValue((String)selRecord.get("bnkNm")) ;  /** column 은행코드 : bnkNm */
//    	 bnkAccuNum.setValue((String)selRecord.get("bnkAccuNum")) ;  /** column 은행계좌번호 : bnkAccuNum */
//    	 acntHodrNm.setValue((String)selRecord.get("acntHodrNm"));   /** column 예금주명 : acntHodrNm */
//    	 payDdlneDt.setValue((String)selRecord.get("payDdlneDt")) ;  /** column 급여마감일자 : payDdlneDt */
//    	 payDdlneYn.setValue((String)selRecord.get("payDdlneYn")) ;  /** column 급여마감여부 : payDdlneYn */
    	 pyytB10100Sum.setValue((Long)selRecord.get("pyytB10100Sum"));   /** column 공제총액 : pyytDducTotAmnt *//** column 기본급 : pyytB10100Sum */
         pyytT10100Sum.setValue((Long)selRecord.get("pyytT10100Sum"));   /** column 공제총액 : pyytDducTotAmnt *//** column 소득세 : pyytT10100Sum */
         pyytT20100Sum.setValue((Long)selRecord.get("pyytT20100Sum"));   /** column 공제총액 : pyytDducTotAmnt *//** column 주민세  : pyytT20100Sum */
    	
    }
    
    @Override  
	public void reload() {
		// TODO Auto-generated method stub
		subformInit();
		IColumnFilter filters = null;
		pyyt0304GridPanel.getTableDef().setTableColumnFilters(filters);
			 
		pyyt0304GridPanel.getTableDef().addColumnFilter("pyytYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		pyyt0304GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		pyyt0304GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		pyyt0304GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			 
 
         String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
         pyyt0304GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
         String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
         pyyt0304GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           // String strPyspGrdeCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
           // pyyt0304GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
         String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
         pyyt0304GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
			//pyyt0304GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			//pyyt0304GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//pyyt0304GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd") , SimpleColumnFilter.OPERATOR_EQUALS); 
			//pyyt0304GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
          
         pyyt0304GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
         pyyt0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
         pyyt0304GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
         pyyt0304GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
         pyyt0304GridPanel.reload();
			
         actionDatabase = ActionDatabase.UPDATE;
	}
    
    
    /** 상세정보 조회 **/
	public void payrInfoReload() {
		
		Pyyt0304DTO pyyt0304Dto = new Pyyt0304DTO();
		
		// 그리드 내용들을 필드에 담는다.
		BaseModel bmData = pyyt0304GridPanel.getCurrentlySelectedItem();  
		
		pyyt0304Dto.setPyytYrMnth((String) bmData.get("pyytYrMnth"));
		pyyt0304Dto.setPayrMangDeptCd((String) bmData.get("payrMangDeptCd"));
		pyyt0304Dto.setEmymtDivCd((String) bmData.get("emymtDivCd"));
		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		pyyt0304Dto.setDeptCd(strDeptCd);
           
		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		pyyt0304Dto.setTypOccuCd(strTypOccuCd);

		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		pyyt0304Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);  
          
		pyyt0304Dto.setBusinCd((String) bmData.get("businCd"));
		pyyt0304Dto.setSystemkey((String) bmData.get("systemkey"));
		pyyt0304Dto.setHanNm((String) bmData.get("hanNm"));
		pyyt0304Dto.setPayCd((String) bmData.get("payCd"));
  		
         yeta6900Service.Yeta6900InfoList(pyyt0304Dto, new AsyncCallback<Pyyt0304BM>() {

        	 @Override
        	 public void onFailure(Throwable caught) {
             // TODO Auto-generated method stub
        		 MessageBox.alert("정보 가져오기", "정보가져오기 실패", null);
        	 }
			

			@Override
			public void onSuccess(Pyyt0304BM result) {
			// TODO Auto-generated method stub
				
				
				dpobCd.setValue(result.getDpobCd());							/**  column 사업장코드 : dpobCd */
				systemkey.setValue((String) result.getSystemkey());					/** column SYSTEMKEY : systemkey */ 
				
				pyytYrMnth.setValue((String) result.getPyytYrMnth());   				/** column 지급년월 : pyytYrMnth */
				hanNm.setValue((String) result.getHanNm());  							/** column 한글성명 : hanNm */
				resnRegnNum.setValue((String) result.getResnRegnNum());   			/** column 주민등록번호 : resnRegnNum */
				logSvcYrNumCd.setValue((String) result.getLogSvcYrNumCd()); 			/** column 근속년수코드 : logSvcYrNumCd */
				logSvcYrNumNm.setValue((String) result.getLogSvcYrNumNm());  			/** column 근속년수 : logSvcYrNumNm */
   				deptCd.setValue((String) result.getDeptCd()) ;  						/** column 부서코드 : deptCd */
   				deptNm.setValue((String) result.getDeptNm()) ;  						/** column 부서 : deptNm */
   				businCd.setValue((String) result.getBusinCd());   					/** column 사업코드 : businCd */
   				businNm.setValue((String) result.getBusinNm());   					/** column 사업코드 : businNm */
//   				Window.alert("33333");
   				pyytPymtTotAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytPymtTotAmnt(), "0"))); 		/** column 지급총액 : pyytpyytPymtTotAmnt */
   				pyytExtpyTotAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytExtpyTotAmnt(), "0")));		/** column 수당총액 : pyytpyytExtpyTotAmnt */
   				typOccuCd.setValue(result.getTypOccuCd());   				/** column 직종코드 : typOccuCd */
   				typOccuNm.setValue( result.getTypOccuNm()) ;  				/** column 직종코드 : typOccuNm */
   				pyytDducTotAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytDducTotAmnt(), "0")));   		/** column 공제총액 : pyytDducTotAmnt */     
   				pyytPernPymtSum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls( result.getPyytPernPymtSum(), "0")));  		/** column 차인지급액 : pyytPernPymtSum */
      			pyytB10100Sum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytB10100Sum(), "0"))) ;     		/** column 기본급 : pyytB10100Sum */
      			pyytT10100Sum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytT10100Sum(), "0"))) ;    		/** column 소득세 : pyytT10100Sum */
      			pyytT20100Sum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytT20100Sum(), "0"))) ;    		/** column 주민세  : pyytT20100Sum */
//      			Window.alert("5555");
      			pyytFreeDtyTotAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytFreeDtyTotAmnt(), "0"))); 	/** column 비과세총액 : pyytFreeDtyTotAmnt */
      			pyytTxtnTotAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytTxtnTotAmnt(), "0")));   		/** column 과세총액 : pyytTxtnTotAmnt */
      			pyytTxTotAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPyytTxTotAmnt(), "0")));   			/** column 세금총액 : pyytTxTotAmnt */
      			payrMangDeptCd.setValue( result.getPayrMangDeptCd()); 		/** column 단위기관코드 : payrMangDeptCd */
      			emymtDivCd.setValue(result.getEmymtDivCd());   				/** column 고용구분코드 : emymtDivCd */
      			
      			
	    		extpyReload();
	    		dducReload();
	    		
//	    		Window.alert("시스템키 --- " +systemkey.getValue() );
			} 
		});
	}
    
    /** 수당 조회 **/
	public void extpyReload() {
		// TODO Auto-generated method stub
//		subformInit();
		
//		Window.alert("시스템키 ---> " + MSFSharedUtils.allowNulls(systemkey.getValue()));
		IColumnFilter filters = null;
		pyyt0302ExtpyGridPanel.getTableDef().setTableColumnFilters(filters);
		pyyt0302ExtpyGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 			 
		pyyt0302ExtpyGridPanel.getTableDef().addColumnFilter("pyytYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		pyyt0302ExtpyGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		pyyt0302ExtpyGridPanel.reload();
			
	}
	
    /** 공제 조회 **/
	public void dducReload() {
		// TODO Auto-generated method stub
//		subformInit();
		IColumnFilter filters = null;
		Pyyt0302DducGridPanel.getTableDef().setTableColumnFilters(filters);
		Pyyt0302DducGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		Pyyt0302DducGridPanel.getTableDef().addColumnFilter("pyytYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		Pyyt0302DducGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		Pyyt0302DducGridPanel.reload();
			
	}

	// 폼초기화 검색조건포함
	private void formInit() {
		BaseModel bmInit = new BaseModel();

		srhHanNm.setValue(""); // 성명
		srhResnRegnNum.setValue(""); // 주민번호
		srhSystemkey.setValue(""); // 시스템키

		subformInit();
		// grid init
		pyyt0304GridPanel.getMsfGrid().clearData();

		actionDatabase = ActionDatabase.UPDATE;

		// 급여상세정보초기화
	}
	   
	private void subformInit() {
		BaseModel bmInit = new BaseModel();

		dpobCd.setValue("");  //사업장코드
		systemkey.setValue("");    /** column SYSTEMKEY : systemkey */
		pyytYrMnth.setValue("");   /** column 지급년월 : pyytYrMnth */
//		   payCd.setValue("") ;  /** column 급여구분코드 : payCd */
		payrMangDeptCd.setValue("");   /** column 단위기관코드 : payrMangDeptCd */
//		   payrSeilNum.setValue(0L);   /** column 급여일련번호 : payrSeilNum */
		emymtDivCd.setValue("");   /** column 고용구분코드 : emymtDivCd */
		hanNm.setValue("") ;  /** column 한글성명 : hanNm */
		resnRegnNum.setValue("");   /** column 주민등록번호 : resnRegnNum */
//		   secRegnNum.setValue("");   /** column 주민등록번호 : secRegnNum */
		deptCd.setValue("") ;  /** column 부서코드 : deptCd */
		deptNm.setValue("") ;  /** column 부서 : deptNm */
		businCd.setValue("");   /** column 사업코드 : businCd */
		businNm.setValue("");   /** column 사업코드 : businNm */
		typOccuCd.setValue("");   /** column 직종코드 : typOccuCd */
		typOccuNm.setValue("") ;  /** column 직종코드 : typOccuNm */
		logSvcYrNumCd.setValue("") ;  /** column 근속년수코드 : logSvcYrNumCd */
		logSvcYrNumNm.setValue("") ;  /** column 근속년수 : logSvcYrNumNm */
		pyytPymtTotAmnt.setValue(0L);   /** column 지급총액 : pyytPymtTotAmnt */
		pyytExtpyTotAmnt.setValue(0L) ;  /** column 수당총액 : pyytExtpyTotAmnt */
		pyytTxtnTotAmnt.setValue(0L);   /** column 과세총액 : pyytTxtnTotAmnt */
		pyytFreeDtyTotAmnt.setValue(0L);   /** column 비과세총액 : pyytFreeDtyTotAmnt */
		pyytDducTotAmnt.setValue(0L);   /** column 공제총액 : pyytDducTotAmnt */
		pyytTxTotAmnt.setValue(0L);   /** column 세금총액 : pyytTxTotAmnt */
		pyytPernPymtSum.setValue(0L) ;  /** column 차인지급액 : pyytPernPymtSum */
//		bnkCd.setValue("");   /** column 은행코드 : bnkCd */
//		bnkNm.setValue("") ;  /** column 은행코드 : bnkNm */
//		bnkAccuNum.setValue("") ;  /** column 은행계좌번호 : bnkAccuNum */
//		acntHodrNm.setValue("");   /** column 예금주명 : acntHodrNm */
//		payDdlneDt.setValue("") ;  /** column 급여마감일자 : payDdlneDt */
//		payDdlneYn.setValue("") ;  /** column 급여마감여부 : payDdlneYn */
		pyytB10100Sum.setValue(0L);   /** column 공제총액 : pyytDducTotAmnt *//** column 기본급 : pyytB10100Sum */
	    pyytT10100Sum.setValue(0L);   /** column 공제총액 : pyytDducTotAmnt *//** column 소득세 : pyytT10100Sum */
	    pyytT20100Sum.setValue(0L);   /** column 공제총액 : pyytDducTotAmnt *//** column 주민세  : pyytT20100Sum */
		   
		//grid init 
		pyyt0302ExtpyGridPanel.getMsfGrid().clearData();
		Pyyt0302DducGridPanel.getMsfGrid().clearData();
	}
	   
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	public Iterator<Record> getListRecord() {
		return this.records;
	}

	public void setListRecordDels(Iterator<Record> recordDels) {
		this.recordDels = recordDels;
	}

	public Iterator<Record> getListRecordDels() {
		return this.recordDels;
	}

	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}

	private Yeta6900 getThis() {
		return this;
	}
	   
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	   
	private void fnPopupPsnl0100()  {
           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
           //검색.처리하면됨.
          MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
          //  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호 
           
           final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
           
           popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
               public void handleEvent(BaseEvent be) {
                   BaseModel mapModel = (BaseModel)be.getSource();
                   if (!"".equals(mapModel.get("systemkey"))) { 
                        
                       srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                       srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                       srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
                   }  
                  
               }
           });
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	   
	   
	    
	//엑셀저장 ( 급여대장 : 공무직)
	public void exportExcel01() {
		// TODO Auto-generated method stub
		// payr0301GridPanel.callExportServlet("");
	        HashMap<String, String> param = new HashMap<String, String>(); 
	        
	        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	        
	        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
	        param.put("pyytYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
	        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
	        param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
	        param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
	       // param.put("pyspGrdeCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	        param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
	        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
	        param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
	        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
	        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

	        //넘어온메서드 값을 가지고 처리 한다.  
	       // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
	        GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsYeta6900Export01.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	          
	} 
	
	//엑셀저장 ( 급여대장 : 기간제)
	public void exportExcel02() {
		// TODO Auto-generated method stub
		// payr0301GridPanel.callExportServlet("");
	        HashMap<String, String> param = new HashMap<String, String>(); 

			systemKeys = new String();
			systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = pyyt0304GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
	        
	        
	        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	        param.put("payYr", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"))); 
	        param.put("deptNm", MSFSharedUtils.allowNulls(srhDeptCd.getValue())); 
	        param.put("payMonth", (MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
	        param.put("pyytYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
	        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
	        param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
	        param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
	       // param.put("pyspGrdeCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	        param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
	        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
			param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
	        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
	        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

	        //넘어온메서드 값을 가지고 처리 한다.  
	       // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
	        //GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPayr4200Export2.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	        pyyt0304GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta6900Export02.do","extgwtFrame" ,param);
	        
	        // TODO 기간제면 XLS_PAYR4200 템플릿 으로 개발한다.
	        
	} 

	// 급여에 대한 합계로 출력
	public void exportTotExcel() {
	        // TODO Auto-generated method stub
	        // payr0301GridPanel.callExportServlet("");
	        HashMap<String, String> param = new HashMap<String, String>(); 
	        
	        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	        
	        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
	        param.put("pyytYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
	        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
	        param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
	        param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
	        //param.put("pyspGrdeCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	        param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
	        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
	        param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
	        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
	        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

	        //넘어온메서드 값을 가지고 처리 한다.  
	       // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
	        GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsYeta6900Export03.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	          
	}
	    
	//엑셀 양식 저장
	private void xlsExportData(String strTyp) {
			                    
		HashMap<String, String> param = new HashMap<String, String>(); 
			   
		
        if("".equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"고용구분을 선택해주세요.", null);
        	return;
        }
        
        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
        
        
        
        if("typ01".equals(strTyp)) {	 	// 가변
        	 pyyt0304GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsTemYeta690001Export.do","extgwtFrame", param);  
        }else {								// 고정
        	 pyyt0304GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsTemYeta690002Export.do","extgwtFrame", param);  
        }
        
//        pyyt0304GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsTemYeta190002Export.do","extgwtFrame", param);  
	}
	
	
	//급여일괄조정 업로드
	private void xlsImportData() { 
			MessageBox.confirm("급여 저장", "급여 내역을 저장 하시겠습니까?<br>(해당 월에 등록되어있는 수당공제항목이 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
		      	@Override
		    	public void handleEvent(MessageBoxEvent be) {
		      	//	if("Yes".equals(be.getButtonClicked().getText())){
		      		//if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      			
		      			
	              		//get the filename to be uploaded
	              		String filename = MSFSharedUtils.allowNulls(Yeta6900flUp.getValue());
	              		if (filename.length() == 0) {
	              			Window.alert("선택된 파일이 없습니다.");
	              			return;
	                	} else {
	                		//submit the form
	                		plFrmYeta1900.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                		//파일업로드 처리
	                		
	                		// 가변
	                		if("typ01".equals(MSFSharedUtils.getSelectedComboValue(exlType,"commCd"))) {
	                			plFrmYeta1900.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadYeta690001Import.do");
	                		}else {
	                		// 고정
	                			plFrmYeta1900.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadYeta690002Import.do");
	                		}
	                		
	                		
	                    	plFrmYeta1900.setEncoding(Encoding.MULTIPART);
	                    	plFrmYeta1900.setMethod(Method.POST);   
	                    	plFrmYeta1900.submit();  
	                    	plFrmYeta1900.onFrameLoad();  
	                    	picBoolFile = true;
	                	}
	                    // reset and unmask the form 
	                    // after file upload 
	                	plFrmYeta1900.addListener(Events.Submit, new Listener<FormEvent>() {
	                		public void handleEvent(FormEvent evt) {  
//	                			Window.alert("????" + GWT.getHostPageBaseURL());
	                			
//	                			if (!"error".endsWith(evt.getResultHtml()) && picBoolFile) {
	                				//업로드가  성공했으면 인서트 모듈을 태운다. 
	                            	plFrmYeta1900.unmask();  
	                            	if(picBoolFile) {
	                            		MessageBox.alert("", "업로드 중입니다. 팝업이 뜨면 오류 내역을 확인해주세요.", null); 
		                                picBoolFile = false;
		                                evt.setResultHtml("");
	                            	}
//	                			} else {
//	                				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//	                					//업로드가  성공했으면 인서트 모듈을 태운다.
//	                                    MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
//	                                    picBoolFile = false;
//	                                    evt.setResultHtml("");
//	                				} else {
//	                					//실패 메시지나 에러 메시지 처리 . 
//	                                    evt.setResultHtml("");
//	                				} 
//	                          	}
	                     	};
	                  	});		      			
		           	}  
		        }
			}); 
		}
	    
	    //부서 
//        private void fnPopupCommP140(String deptCd) {
//            //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//            //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//            //검색.처리하면됨.
//            
//            MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//            
//            final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//           
//            popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//                public void handleEvent(BaseEvent be) {
//                    BaseModel mapModel = (BaseModel)be.getSource();
//                    if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                         
//                        srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                        srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                        srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                        srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                        srhDeptCd.fireEvent(Events.Add);
//                    }  
//                         
//                }
//            });
//        }       
        
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
