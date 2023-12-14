package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.diligence.client.dto.InfcPkgDlgn0250DTO;
import com.app.exterms.payroll.client.dto.InfcPkgPayr0304DTO;
import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.dto.Payr0302DTO;
import com.app.exterms.payroll.client.dto.Payr0304DTO;
import com.app.exterms.payroll.client.dto.Payr0307DTO;
import com.app.exterms.payroll.client.dto.Payr0470DTO; //검색조건 수정 후 지급공제구분을 불러오기위해 추가함 6.16 -"8"
import com.app.exterms.payroll.client.dto.Payr4700DTO;
import com.app.exterms.payroll.client.form.defs.Payr0302Def;
import com.app.exterms.payroll.client.form.defs.Payr0304Def;
import com.app.exterms.payroll.client.form.defs.Payr0307Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
/*import com.app.exterms.payroll.client.service.Payr4200Service;
import com.app.exterms.payroll.client.service.Payr4200ServiceAsync;*/
import com.app.exterms.payroll.client.service.Payr4201Service;
import com.app.exterms.payroll.client.service.Payr4201ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFServiceFailureHandler;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
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

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr4201  extends MSFPanel { //4200복사 후 4201로 변경 6.16 -"1"
 

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
	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmPayr4200;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
		
	//급여대상자정보는 주석처리함 6.19 -"85"
	/*private Payr0304Def payr0304Def  = new Payr0304Def("PAYR4200");*/   //그리드 테이블 컬럼 define  
	
	//급여내역조회 DEF를 다시 추가함 6.17 -"60"
	private Payr0304Def payr0304AllDef = new Payr0304Def("PAYR4201"); //수정처리함 6.18 -"82"
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0304GridPanel;
	
	//일괄정리 추가4 6.19 -"123"
	  
	//수당 
	//def를 추가함 6.17 -"20"
	// private MSFCustomForm msfCustomForm; 
	  
	//공제 
	private Payr0302Def payr0302DducDef  = new Payr0302Def("PAYR4200DDUC");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0302DducGridPanel;
  
   
	// 급여조정
	private Payr0307Def payr0307Def = new Payr0307Def(); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel payr0307GridPanel;
	    
      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
  
	// 지급년도
	private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();
	private MSFGridPanel payYrGridPanel;
      
 

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
		private ButtonBar topPayr4200Bar;
		private Button btnPayr4200Init;
		// private Button btnPayr4200Save;
		private Button btnPayr4200Del;
		private Button btnPayr4200Sreach;
		private Button btnPayr4200Print;
		private Button btnPayr4200Excel;
		private Button btnPayr4200SumExcel; // 월별급여
		
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
      
		/** column 년도 : payYr */
		private ComboBox<BaseModel> srhPayYr;
		private ComboBox<BaseModel> srhPayMonth;
     
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
//      private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//      private HiddenField<String> srhPyspGrdeCd; //직종 
      
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
      
      
		private MSFTextField dilnlazDutyNumDys;    	/** column 근태_근무일수 : dilnlazDutyNumDys */
		private MSFTextField  dilnlazTotDutyNumDys;  /** column 총근무일수 : dilnlazTotDutyNumDys */
		private MSFTextField  dilnlazLvsgNumDys;  /** column 연가일수 : dilnlazLvsgNumDys */
		private MSFTextField  dilnlazFndtnTmRstDutyTm;    
		private MSFTextField  dilnlazTmRstDutyTm; 
		private MSFTextField  dilnlazTotTmRstDutyTm ; 
		private MSFTextField  dilnlazPubcHodyDutyNumDys;   
		private MSFTextField  dilnlazTotNtotTm;    
		private MSFTextField  dilnlazWklyHldyNumDys;   
			
	
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
      
		private FileUploadField payr4200flUp; // 파일업로드처리 부분
		private Boolean picBoolFile;
		private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
 
		private Boolean emptyCheck = false ;
		private boolean mutilCombo = false;
		private String systemKeys;
		
		//검색조건에 지급공제구분 추가 후 private 로 선언 6.16 -"7"
		private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
		private ComboBox<BaseModel> srhPayDducExtpyCd;
		
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
       
		private HiddenField<String> dpobCd;  			//사업장코드
		private HiddenField<String> systemkey;    	/** column SYSTEMKEY : systemkey */
		private HiddenField<String> pymtYrMnth;   	/** column 지급년월 : pymtYrMnth */
      	private HiddenField<String> payCd ;  		/** column 급여구분코드 : payCd */
      	private HiddenField<String> payrMangDeptCd; /** column 단위기관코드 : payrMangDeptCd */
      	private HiddenField<Long> payrSeilNum;   	/** column 급여일련번호 : payrSeilNum */
      	private HiddenField<String> emymtDivCd;   	/** column 고용구분코드 : emymtDivCd */
      
      	private MSFTextField hanNm ;  			/** column 한글성명 : hanNm */
      
      	private MSFTextField resnRegnNum;   	/** column 주민등록번호 : resnRegnNum */
      	private HiddenField<String> secRegnNum;   	/** column 주민등록번호 : secRegnNum */
      
      	private HiddenField<String> deptCd ;  		/** column 부서코드 : deptCd */
      	private MSFTextField deptNm ;  		/** column 부서 : deptNm */

      	private HiddenField<String> businCd;   		/** column 사업코드 : businCd */
      	private MSFTextField businNm;   		/** column 사업코드 : businNm */

      	private HiddenField<String> typOccuCd;   	/** column 직종코드 : typOccuCd */
      	private HiddenField<String> typOccuNm ;  	/** column 직종코드 : typOccuNm */
      	
      	//초기화 위해 추가 6.19 -"90"
      	/*private HiddenField<String> pyspGrdeCd;*/
      	
      	private HiddenField<String> logSvcYrNumCd ; /** column 근속년수코드 : logSvcYrNumCd */
      	private MSFTextField logSvcYrNumNm ;  	/** column 근속년수 : logSvcYrNumNm */

      	private MSFNumberField pymtTotAmnt;   			/** column 지급총액 : pymtTotAmnt */
      	private MSFNumberField extpyTotAmnt;  			/** column 수당총액 : extpyTotAmnt */

      	private HiddenField<Long> txtnTotAmnt;   	/** column 과세총액 : txtnTotAmnt */

      	private MSFNumberField freeDtyTotAmnt;   		/** column 비과세총액 : freeDtyTotAmnt */
      	private MSFNumberField dducTotAmnt;   			/** column 공제총액 : dducTotAmnt */

      	private HiddenField<Long> txTotAmnt;   		/** column 세금총액 : txTotAmnt */
       
      	private MSFNumberField  pernPymtSum;  			/** column 차인지급액 : pernPymtSum */
 
      	private HiddenField<String> bnkCd;   		/** column 은행코드 : bnkCd */
      	private HiddenField<String> bnkNm;  		/** column 은행코드 : bnkNm */
      	private HiddenField<String> bnkAccuNum;  	/** column 은행계좌번호 : bnkAccuNum */
      	private HiddenField<String> acntHodrNm;   	/** column 예금주명 : acntHodrNm */
      	private HiddenField<String> payDdlneDt;  	/** column 급여마감일자 : payDdlneDt */
      	private HiddenField<String> payDdlneYn;  	/** column 급여마감여부 : payDdlneYn */

      	private MSFNumberField  pymtB10100Sum ;     	/** column 기본급 : pymtB10100Sum */
      	private MSFNumberField  pymtT10100Sum ;    	/** column 소득세 : pymtT10100Sum */
      	private MSFNumberField  pymtT20100Sum ;    	/** column 주민세  : pymtT20100Sum */
      
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
					authExecEnabled();
				}
				
				gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
      		}
      	}
		  
      	private void authExecEnabled() {
    	  
      		Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd,srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd };
    	  
      		gwtAuthorization.formAuthFieldConfig(fldArrField);
	
      		srhPayYr.setValue(lsPayYrStore.findModel("payYr", DateTimeFormat.getFormat("yyyy").format(new Date()))); 
      		srhPayCd.setValue(lsPayCd.getAt(0));
            	  
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 
			 * : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
			// String[] strArrDeptCd =
			// {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
			// GWTAuthorization.formAuthPopConfig(plFrmPayr4200,
			// "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
			// GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd);
			// gwtAuthorization.formAuthConfig(plFrmPayr4200,
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
	private Payr4201ServiceAsync payr4201Service = Payr4201Service.Util.getInstance();

	private ListStore<BaseModel> lsPayYrStore	 	= new ListStore<BaseModel>(); 	// 년도
	private ListStore<BaseModel> lsPayMonth 		= new ListStore<BaseModel>(); 	// 급여월

	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	// 호봉제구분코드 

	// --------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>();	// 부서콤보
	// --------------------부서 불러 오는 함수------------------------------------------------
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
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
	//삭제처리 수정
	//정상작동안해서 원복 6.19 -"107"
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) { 
			if (ce.getButton() == btnPayr4200Del) {
				//일괄정리 위해 추가 6.22 -"139"
				
				//주석처리 6.22 -"138"
				MessageBox.confirm("삭제", "데이타을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						
						//if("Yes".equals(be.getButtonClicked().getText())){ 
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							doAction(ActionDatabase.DELETE);
							
	                        
						}
					}
				});   
			}
		}  
	};
	  
	    
	private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
        	savePayr4200();  
            break;
        case UPDATE: 
        	savePayr4200();
            break;
        case DELETE:  
        	payr4201Delete();
            break;
		default:
			break;
        }
    }
	
	//일괄정리 위해 추가 6.22 -"142"
	public void payr4201Delete() {

		 Payr0304DTO payr0304Dto = new Payr0304DTO();
		 //레코드에있던 정보를 빼내서 dto에 담는다. 일단 조건을 추가하기 6.19 -"91"
		 //DTO추가 6.22 -"146"
		 payr0304Dto.setPymtYrMnth(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")); //지급년월
		 
		 payr0304Dto.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); //급여구분코드
		 
		 payr0304Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); //단위기관
		 
		 payr0304Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); //고용구분코드
		 
		 payr0304Dto.setRepbtyBusinDivCd(MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd")); //호봉제
		 
		 payr0304Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); //관리부서코드
		 
		 /*payr0304Dto.setDeptGpCd(MSFSharedUtils.allowNulls(srhDeptGpCd.getValue()));*/ //그룹
		 String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		 payr0304Dto.setDeptCd(strDeptCd); //부서코드
		 
		 String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		 payr0304Dto.setTypOccuCd(strTypOccuCd); //직종코드
		 
		 String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
		 payr0304Dto.setDtilOccuInttnCd(strDtilOccuInttnCd); //직종세통합코드
		 
		 payr0304Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); //사업코드
		 
		 payr0304Dto.setPymtDducDivCd(MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd")); //지급공제구분코드
		 
		 payr0304Dto.setPayItemCd(MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd")); //지급공제항목코드
		 
		 
		 payr4201Service.activityOnPayr4201Save(payr0304Dto, actionDatabase, new AsyncCallback<Long>() {
			 public void onFailure(Throwable caught) {
				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr4201Save(save) : " + caught), null);
			 }
			 @Override
			 public void onSuccess(Long result) { 
				 if (result == 0) {
					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
							 "삭제가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				 } else {

					 actionDatabase = ActionDatabase.UPDATE;
					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "삭제가 완료되었습니다.", null);
					 reloadPayr4200();
				 } 
			 }  
		 });
	   } 
	
	
	
	
	
	
	
	
	     
	private void savePayr4200() { 
        
		if (MSFSharedUtils.paramNotNull(records)) {
            
			statCheck = false;
            List<Payr0307DTO> listPayr0307dto = new ArrayList<Payr0307DTO>();  
             
             while (records.hasNext()) {
           
            	 Record record = (Record) records.next(); 
                 BaseModel bmMapModel = (BaseModel)record.getModel();
                   
                 Payr0307DTO payr0307Dto = new Payr0307DTO();  
             
                 payr0307Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
                 payr0307Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pymtYrMnth")));    						/** column 지급년월 : pymtYrMnth */
                 payr0307Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    							/** column 급여구분코드 : payCd */
                 payr0307Dto.setPayrSeilNum((Long)bmMapModel.get("payrSeilNum"));    											/** column 급여일련번호 : payrSeilNum */
                 payr0307Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    							/** column SYSTEMKEY : systemkey */
                 payr0307Dto.setMnthPayAdmntSeilNum((Long)bmMapModel.get("mnthPayAdmntSeilNum"));    							/** column 월급여조정일련번호 : mnthPayAdmntSeilNum */
                 payr0307Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    							/** column 급여항목코드 : payItemCd */
                 payr0307Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));				/** column 지급공제구분코드 : pymtDducDivCd */
                 payr0307Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    											/** column 지급공제금액 : pymtDducSum */
                 payr0307Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    									/** column null : pymtDducTxtnAmnt */
                 payr0307Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    								/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                 payr0307Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("mnthPayAdmntAssoBssCtnt")));	/** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
//                payr0307Dto.setMnthPayAdmntYn((Boolean)bmMapModel.get("mnthPayAdmntYn"));    									/** column 소득세처리여부 : mnthPayAdmntYn */
  	           
                 if (actionDatabase.equals(ActionDatabase.INSERT)) {
                	
                	 
                	 if (MSFSharedUtils.isNullAsString(payr0307Dto.getSystemkey())) {
                		 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여] 조정할 대상자를 선택하십시요.", null);
                		 statCheck = true;
                		 break;
                	} else if (MSFSharedUtils.isNullAsString(payr0307Dto.getPymtDducDivCd())) {
                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여] 지급공제구분을 입력하십시요.", null);
                		statCheck = true;
                		break;
                	} else if (MSFSharedUtils.paramNotNull(payr0307Dto.getPymtDducSum())) {
                		if (payr0307Dto.getPymtDducSum().compareTo(0L) <= 0) {
	                			//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	         	               //          "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
	                  			//statCheck = true;
	                  			//break;
                		}
                	}  else if (MSFSharedUtils.paramNull(payr0307Dto.getPymtDducSum())) {
                   			 
                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
                		statCheck = true;
                		break;
                   			 
                	}  
                 }   
                 listPayr0307dto.add(payr0307Dto);
             }   
             
             if (!statCheck) {    
            	 payr4201Service.activityOnPayr4200(listPayr0307dto, actionDatabase, new AsyncCallback<Long>() { 
            		 public void onFailure(Throwable caught) {
            			 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
            					 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr4200(" + actionDatabase.name() + ") : " + caught), null);
		         	 }
            		 
            		 public void onSuccess(Long result) { 
            			 if (result == 0) {
            				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
		                      // actionDatabase = ActionDatabase.INSERT;
            			 } else {
            				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
            				 reloadPayr4200();
		                       actionDatabase = ActionDatabase.UPDATE;
            			 } 
            		 } 
            	 }); 
             }
		} else {
            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
            return;
		}
	}      
     

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	수당 저장 처리 루틴 
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/   

	private void doSaveExtpyAction(ActionDatabase actionDatabase) {
        
		switch (actionDatabase) {
		case INSERT: 
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			updateSavePayr4200ToExtpy();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			updateSavePayr4200ToExtpy();
			break;
		default:
			break;
		}
		
	}      
  

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 수당처리 업데이트  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : updateSavePayr4200ToExtpy
	 * @date : 2017. 7. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 7. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 *
	 */
private void updateSavePayr4200ToExtpy() {
	
	if (MSFSharedUtils.paramNotNull(records)) {
        
	
		statCheck = false;
        List<Payr0302DTO> listPayr0302dto = new ArrayList<Payr0302DTO>();  
         
         while (records.hasNext()) {
         
        	 Record record = (Record) records.next(); 
             BaseModel bmMapModel = (BaseModel)record.getModel();
               
             Payr0302DTO payr0302Dto = new Payr0302DTO();   
           
            //값넣기  
			payr0302Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			payr0302Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pymtYrMnth")));    /** column 지급년월 : pymtYrMnth */
			payr0302Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));    /** column 급여구분코드 : payCd */
			payr0302Dto.setPayrSeilNum((Long)bmMapModel.get("payrSeilNum"));    /** column 급여일련번호 : payrSeilNum */
			payr0302Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			payr0302Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			payr0302Dto.setPayItemSeilNum((Long)bmMapModel.get("payItemSeilNum"));    /** column 급여항목일련번호 : payItemSeilNum */
			payr0302Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
			payr0302Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			payr0302Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
			payr0302Dto.setPayPymtDducPrcsFlag(MSFSharedUtils.allowNulls(bmMapModel.get("payPymtDducPrcsFlag")));    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			payr0302Dto.setPayReattyAdmntVal(MSFSharedUtils.allowNulls(bmMapModel.get("payReattyAdmntVal")));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			payr0302Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			payr0302Dto.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrtxDotnCd")));    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
			payr0302Dto.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYtfeDtyReduCd")));    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
//			payr0302Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//			payr0302Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//			payr0302Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//			payr0302Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//			payr0302Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//			payr0302Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */

			
			 if (MSFSharedUtils.isNullAsString(payr0302Dto.getSystemkey())) {
        		 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여수당]근로자를 선택하십시요.", null);
        		 statCheck = true;
        		 break;
			 }
			 
             if (actionDatabase.equals(ActionDatabase.UPDATE)) { 
            	 
            	  if (MSFSharedUtils.paramNotNull(payr0302Dto.getPymtDducSum())) {
            		if (payr0302Dto.getPymtDducSum().compareTo(0L) <= 0) {
                			//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
         	               //          "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
                  			//statCheck = true;
                  			//break;
            		}
            	}  else if (MSFSharedUtils.paramNull(payr0302Dto.getPymtDducSum())) {
               			 
            		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "[급여수당] 수당금액은 0 이상[이하]이어야합니다. 입력하십시요.", null);
            		statCheck = true;
            		break;
               			 
            	}  
             }  else { 
            	 
            	 if (PayGenConst.PYMT_DDUC_DIV_CD_01.equals(payr0302Dto.getPayItemCd())) { 
    				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여수당]기본급은 삭제할 수 없습니다.", null);
        			 statCheck = true;
            		 break;
        		 }  
             } 
             listPayr0302dto.add(payr0302Dto);
         }   
         
         if (!statCheck) {    
        	 payr4201Service.activityOnExtpyPayr4200(listPayr0302dto, actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() { 
        		 public void onFailure(Throwable caught) {
        		
        		     List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                     ShowMessageBM smBm = new ShowMessageBM();
              	     smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
              	     smBm.setMenu("Payr");
              	     smBm.setPhase("[급여]에러");
              	     smBm.setMessage(caught.getLocalizedMessage());
              	     smBm.setContent(caught.getMessage());
              	     bmResult.add(smBm);  
              	     PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
              	   
                       ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
	    			    
	    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	    		       msFwMessage.show();
	    		       showMessageForm.setMSFFormWindows(msFwMessage);
	    		       
        			 //MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
        				//	 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnExtpyPayr4200(" + actionDatabase.name() + ") : " + caught), null);
	         	 }
        		 
        		 public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
        			// if (result == 0) {
        				// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                      // actionDatabase = ActionDatabase.INSERT;
        			// } else {
        				// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
        			   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	    			    
	    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	    		       msFwMessage.show();
	    		       showMessageForm.setMSFFormWindows(msFwMessage);
	    		       
	    		       reloadPayr4200();
	                      actionDatabase = ActionDatabase.UPDATE;
        			 //} 
        		 } 
        	 }); 
         }
	} else {
        MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
        return;
	}		
}  


private void doSaveDDucAction(ActionDatabase actionDatabase) {
    
	switch (actionDatabase) {
	case INSERT: 
		break;
	case UPDATE:
		this.actionDatabase = ActionDatabase.UPDATE;
		updateSavePayr4200ToDDuc();
		break;
	case DELETE:
		this.actionDatabase = ActionDatabase.DELETE;
		updateSavePayr4200ToDDuc();
		break;
	default:
		break;
	}
	
}      

	
private void updateSavePayr4200ToDDuc() {
	
	if (MSFSharedUtils.paramNotNull(records)) {
        
		statCheck = false;
        List<Payr0302DTO> listPayr0302dto = new ArrayList<Payr0302DTO>();  
    
         while (records.hasNext()) {
        	  
        	 Record record = (Record) records.next(); 
             BaseModel bmMapModel = (BaseModel)record.getModel();
               
             Payr0302DTO payr0302Dto = new Payr0302DTO();   
           
            //값넣기  
			payr0302Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			payr0302Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pymtYrMnth")));    /** column 지급년월 : pymtYrMnth */
			payr0302Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));    /** column 급여구분코드 : payCd */
			payr0302Dto.setPayrSeilNum((Long)bmMapModel.get("payrSeilNum"));    /** column 급여일련번호 : payrSeilNum */
			payr0302Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			payr0302Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			payr0302Dto.setPayItemSeilNum((Long)bmMapModel.get("payItemSeilNum"));    /** column 급여항목일련번호 : payItemSeilNum */
			payr0302Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
			payr0302Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			payr0302Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
			payr0302Dto.setPayPymtDducPrcsFlag(MSFSharedUtils.allowNulls(bmMapModel.get("payPymtDducPrcsFlag")));    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			payr0302Dto.setPayReattyAdmntVal(MSFSharedUtils.allowNulls(bmMapModel.get("payReattyAdmntVal")));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			payr0302Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			payr0302Dto.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYrtxDotnCd")));    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
			payr0302Dto.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyytYtfeDtyReduCd")));    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
//			payr0302Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//			payr0302Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//			payr0302Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//			payr0302Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//			payr0302Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//			payr0302Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */

		 
			 if (MSFSharedUtils.isNullAsString(payr0302Dto.getSystemkey())) {
        		 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "[급여공제] 근로자를 선택하십시요.", null);
        		 statCheck = true;
        		 break;
         
        	}
			 
             if (actionDatabase.equals(ActionDatabase.UPDATE)) { 
            	 
               if (MSFSharedUtils.paramNotNull(payr0302Dto.getPymtDducSum())) {
            		if (payr0302Dto.getPymtDducSum().compareTo(0L) <= 0) {
                			//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
         	               //          "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
                  			//statCheck = true;
                  			//break;
            		}
            	}  else if (MSFSharedUtils.paramNull(payr0302Dto.getPymtDducSum())) {
               			 
            		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "[급여공제] 공제금액은 0 이상[이하]이어야합니다. 입력하십시요.", null);
            		statCheck = true;
            		break;
               			 
            	}  
             }  else {
            	 
             }
             
             listPayr0302dto.add(payr0302Dto);
         }   
         
         if (!statCheck) {    
        	 payr4201Service.activityOnDDucPayr4200(listPayr0302dto, actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() { 
        		 public void onFailure(Throwable caught) {
        		
        		     List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                     ShowMessageBM smBm = new ShowMessageBM();
              	     smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
              	     smBm.setMenu("Payr");
              	     smBm.setPhase("[급여]에러");
              	     smBm.setMessage(caught.getLocalizedMessage());
              	     smBm.setContent(caught.getMessage());
              	     bmResult.add(smBm);  
              	     PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
              	   
                       ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
	    			    
	    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	    		       msFwMessage.show();
	    		       showMessageForm.setMSFFormWindows(msFwMessage);
	    		       
        			 //MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
        				//	 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnExtpyPayr4200(" + actionDatabase.name() + ") : " + caught), null);
	         	 }
        		 
        		 public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
        			// if (result == 0) {
        				// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                      // actionDatabase = ActionDatabase.INSERT;
        			// } else {
        				// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
        			   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	    			    
	    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	    		       msFwMessage.show();
	    		       showMessageForm.setMSFFormWindows(msFwMessage);
	    		       
	    		       reloadPayr4200();
	                   actionDatabase = ActionDatabase.UPDATE;
        			 //} 
        		 } 
        	 }); 
         }
	} else {
        MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
        return;
	}		
}       
	 
 

private void getDlgn250Data(InfcPkgDlgn0250DTO infcPkgDlgn0250Dto) {
 
     
		payr4201Service.getDlgn250Data(infcPkgDlgn0250Dto,  new AsyncCallback<InfcPkgDlgn0250DTO>() {
		    public void onFailure(Throwable caught) {
		        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getDlgn250Data(복무) : " + caught), null);
		    }
		    public void onSuccess(InfcPkgDlgn0250DTO result) { 
		    	 if (MSFSharedUtils.paramNotNull(result) ) {
		            
		    			dilnlazDutyNumDys.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazDutyNumDys(),"0"));    			/** column 근태_근무일수 : dilnlazDutyNumDys */
		    			dilnlazLvsgNumDys.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazLvsgNumDys(),"0"));    			/** column 근태_연가일수 : dilnlazLvsgNumDys */
		             //  infcDlgn0250Dto.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazAbnceNumDys(),"0"));    			/** column 근태_결근일수 : dilnlazAbnceNumDys */
		              // infcDlgn0250Dto.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazSckleaNumDys(),"0"));    		/** column 근태_병가일수 : dilnlazSckleaNumDys */
		               //infcDlgn0250Dto.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazOffvaNumDys(),"0"));    			/** column 근태_공가일수 : dilnlazOffvaNumDys */
		               //infcDlgn0250Dto.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazFmlyEvntNumDys(),"0"));    	/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
		              // infcDlgn0250Dto.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazHlthCreNumDys(),"0"));    		/** column 근태_보건일수 : dilnlazHlthCreNumDys */
		               dilnlazTotDutyNumDys.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazTotDutyNumDys(),"0"));    		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		               dilnlazWklyHldyNumDys.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazWklyHldyNumDys(),"0"));    	/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		           //    infcDlgn0250Dto.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(result.getDilnlazPaidPubcHodyNum(),"0"));    	/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
		           //    infcDlgn0250Dto.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(result.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );    		/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
		         //      infcDlgn0250Dto.setDilnlazNoteCtnt(result.getDilnlazNoteCtnt());    												/** column 근태_비고내용 : dilnlazNoteCtnt */ 
		          //     infcDlgn0250Dto.setDilnlazSpclHodyNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazSpclHodyNumDys(),"0"));    	/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
		          //     infcDlgn0250Dto.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazSatDutyNumDys(),"0"));    		/** column 총토요근무일수 : dilnlazSatDutyNumDys */
		               dilnlazPubcHodyDutyNumDys.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazPubcHodyDutyNumDys(),"0"));    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
		            //   infcDlgn0250Dto.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazHodyDutyNumDys(),"0"));    	/** column 휴일일수 : dilnlazHodyDutyNumDys */
		           //    infcDlgn0250Dto.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.defaultNulls(result.getDilnlazAbnceDutyRcgtnDys(),"0"));	/** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
		           //    infcDlgn0250Dto.setDilnlazTotDutyTm(MSFSharedUtils.defaultNulls(result.getDilnlazTotDutyTm(),"0"));    				/** column 근태_총근무시간 : dilnlazTotDutyTm */
		           //    infcDlgn0250Dto.setDilnlazPaidHodyNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazPaidHodyNumDys(),"0"));    	/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
		           //    infcDlgn0250Dto.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazTfcAssCstNumDys(),"0"));    	/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */ 
		          //     infcDlgn0250Dto.setDilnlazLnchDys(MSFSharedUtils.allowNulls(result.getDilnlazLnchDys()));    						/** column 근태_급식비일수 : dilnlazLnchDys */
		          //     infcDlgn0250Dto.setDilnlazWkdDutyNumDys(MSFSharedUtils.allowNulls(result.getDilnlazWkdDutyNumDys()));    			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
		               
		          //     infcDlgn0250Dto.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazPubcHodyDutyNumDys(),"0"));/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//		               infcDlgn0250Dto.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(result.getDilnlazHodyDutyNumDys(),"0"));    	/** column 휴일일수 : dilnlazHodyDutyNumDys */
		         //      infcDlgn0250Dto.setDilnlazSatDutyNumDys(result.getDilnlazSatDutyNumDys());    /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
		             //  infcDlgn0250Dto.setDilnlazTotNtotNumDys(result.getDilnlazTotNtotNumDys());    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
		               dilnlazTotNtotTm.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazTotNtotTm(),"0"));    				/** column 근태_총야근시간 : dilnlazTotNtotTm */
		               dilnlazFndtnTmRstDutyTm.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazFndtnTmRstDutyTm(),"0"));	/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
		               dilnlazTmRstDutyTm.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazTmRstDutyTm(),"0"));				/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
		              dilnlazTotTmRstDutyTm.setValue(MSFSharedUtils.defaultNulls(result.getDilnlazTotTmRstDutyTm(),"0"));	/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
		               
		        } else {
		        	   //복무정보	       
		 	       dilnlazDutyNumDys.setValue("0");    			/** column 근태_근무일수 : dilnlazDutyNumDys */
		 		  dilnlazLvsgNumDys.setValue("0");    			/** column 근태_연가일수 : dilnlazLvsgNumDys */
		           dilnlazTotDutyNumDys.setValue("0");    		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		           dilnlazWklyHldyNumDys.setValue("0");    	/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		           dilnlazPubcHodyDutyNumDys.setValue("0");    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
		           dilnlazTotNtotTm.setValue("0");    				/** column 근태_총야근시간 : dilnlazTotNtotTm */
		           dilnlazFndtnTmRstDutyTm.setValue("0");	/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
		           dilnlazTmRstDutyTm.setValue("0");				/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
		          dilnlazTotTmRstDutyTm.setValue("0");	/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
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
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
		

		String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
		        
		serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";    //사업코드 $1
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]"; //$2
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]"; //$3
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$4
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";    //$5
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";    //$6
		
		//20151212-추가 시작 
		if (payrMangDeptCd.equals(deptCdAuth)) { 
			serarchParam += "[]"; //parameter7
		} else {
			serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$7
		}  
		//20151212-추가 끝
		
		serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$8
		serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$9
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";   //$10
                   
//		String checkedSystemKeys = "'"+ systemkey + "'";
		String checkedSystemKeys = "";
		List<BaseModel> list = payr0304GridPanel.getGrid().getSelectionModel().getSelectedItems();
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			//System.out.println("체크값 : " + checkedSystemKeys);
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
		String rexFileName = "PAYRT4302" + ".crf";
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
               
		//검색조건
		String serarchParam = "";
		
		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
		String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
		
		        
		serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			//사업코드 $1
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"⊥"; //$2
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"⊥"; //$3
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";   //$4
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";	//$5
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"⊥";    		//$6
		
		//20151212-추가 시작 
		if (payrMangDeptCd.equals(deptCdAuth)) { 
			serarchParam += "⊥"; //parameter7
		} else {
			serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; //$7
		}  
		//20151212-추가 끝
		
		serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";//$8
		serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"⊥";  //$9
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";   //$10
                   
		
		
		
		String checkedSystemKeys = "";
		List<BaseModel> list = payr0304GridPanel.getGrid().getSelectionModel().getSelectedItems();
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
		}
//		else {
//			MessageBox.info("", "대상자를 선택해주세요.", null);
//		}
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
				
				String year	 = PayrUtils.getSelectedComboValue(srhPayYr,	"payYr");
				String month = PayrUtils.getSelectedComboValue(srhPayMonth,	"month");
				
				String pymtYrMnth	   = year+month;
				String payCd		   = PayrUtils.getSelectedComboValue(srhPayCd, "commCd");
		 		String payrMangDeptCd  = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
		 		String mangeDeptCd     = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd, "mangeDeptCd");
				String emymtDivCd	   = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");
				String repbtyBusinDivCd= MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd");
				String deptCd		   = PayrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
				String typOccuCd	   = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
//				String pyspGrdeCd	   = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "pyspGrdeCd");
				String dtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
				String businCd		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd");
				String businNm		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businNm");
				
				String hanNm		   = MSFSharedUtils.allowNulls(srhHanNm.getValue());
				String resnRegnNum	   = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
                String deptNm          = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); 
				
               
			 
				systemKeys = new String();
				systemKeys = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
				
				String deptCdAuth	   = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(  lsDeptCd
																									 , MSFSharedUtils.allowNulls(srhDeptCd.getValue())
																									 , "deptNmRtchnt", "deptCd"
																									)
																  ).replace(",", "");
				String dtilOccuInttnCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																										 , MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue())
																										 , "dtilOccuClsNm"
																										 , "dtilOccuInttnCd")).replace(",", "");
			
				
				String lastWeek = getWeekCountOfMonth(pymtYrMnth)+"일";
				//그리드 선택 데이터 출력
                //getWeekInMonths(year,month);
                
				
				
				
				String checkedSystemKeys = "";
				int keyCnt = 0;
				List<BaseModel> list = payr0304GridPanel.getGrid().getSelectionModel().getSelectedItems();

				if(list != null && list.size() > 0) {
					String chkSysKey = "";
					int iCnt = 0;

					for(BaseModel bm : list){
						chkSysKey += bm.get("systemkey") + ",";
						iCnt = iCnt + 1;
					}
					keyCnt = iCnt;
					checkedSystemKeys = chkSysKey.substring(0, chkSysKey.length() - 1); //$10 시스템키
//					System.out.println("시스템키는 넘기지 않고 검색조건만 넘김");
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
					
					serarchParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())	+ "⊥";	/*$1  사업장코드				*/
					serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$2  기간검색시작				*/
					serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$3  기간검색종료				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(payrMangDeptCd)							+ "⊥";	/*$4  단위기간				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(emymtDivCd)								+ "⊥";	/*$5  고용구분				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(deptCd)									+ "⊥";	/*$6  부서코드				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(typOccuCd)								+ "⊥";	/*$7  직종					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(dtilOccuInttnCd)							+ "⊥";	/*$8  직종세				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(businCd)									+ "⊥";	/*$9  사업코드				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(systemKeys)								+ "⊥";	/*$10 시스템키				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(hanNm)									+ "⊥";	/*$11 성명					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(resnRegnNum)								+ "⊥";	/*$12 주민번호				*/
					serarchParam += "" + MSFSharedUtils.allowNulls(payCd)									+ "⊥";	/*$13 급여구분				*/
					
					/* 20151212-변경추가 시작				*/
					serarchParam += "" + MSFMainApp.get().getUser().getUsrId()								+ "⊥"; 	/*$14 유저 아이디				*/
					serarchParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn()						+ "⊥";	/*$15 관리자 유무				*/
					
					/* 권한처리를위해 넘기는 변수 2개추가	*/
					serarchParam += "" + deptCdAuth															+ "⊥";	/*$16 부서					*/
					serarchParam += "" + dtilOccuInttnCdAuth												+ "⊥";	/*$17 직종세				*/
					
					/* 20151212-추가 끝					*/
					serarchParam += "" + MSFSharedUtils.allowNulls(myImgUrl)								+ "⊥";	/*$18 직인경로				*/
					serarchParam += "0⊥";																			/*$19 단건 1 복수건 0 프린트 추가	*/
					serarchParam += "" + year																+ "⊥";	/*$20 년					*/
					serarchParam += "" + pymtYrMnth															+ "⊥";	/*$21 년월					*/
					serarchParam += "" + month																+ "⊥";	/*$22 월					*/
					
					serarchParam += "" + businNm															+ "⊥";	/*$23 마지막주				*/
					serarchParam += "" + lastWeek															+ "⊥";	/*$24 					*/
					serarchParam += "" + deptNm																+ "⊥";	/*$25 					*/
					serarchParam += "" + mangeDeptCd														+ "⊥";	/*$26 관리부서				*/
					serarchParam += "" + repbtyBusinDivCd													+ "⊥";	/*$27 호봉제구분				*/
					
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

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr4200Form(); // 화면 기본정보를 설정
			createSearchForm(); // 검색필드를 적용
			createStandardForm(); // 기본정보필드
			vp.setSize("1010px", "700px");
	 
			actionDatabase = ActionDatabase.UPDATE;
			
					//수당그리드에서 바로 출력이 되도록 주석처리 6.17 -"12"
				    /**
				     * TODO 급여대상자에 따른 수당,공제,급여조정부분을 자동으로 불러오는 부분을 추가 한다...단계별진행........
			          * Create the relations 
			          *//*
					   final RelationDef  relPayr0304 = new RelationDef(payr0304Def, false);
					   relPayr0304.addJoinDef("pymtYrMnth", "pymtYrMnth");
					   relPayr0304.addJoinDef("dpobCd", "dpobCd");
					   relPayr0304.addJoinDef("systemkey", "systemkey");
					   relPayr0304.addJoinDef("payCd", "payCd");
					   relPayr0304.addJoinDef("payrSeilNum", "payrSeilNum"); 
					   relPayr0304.setLinkedObject(payr0304GridPanel);
					   payr0302ExtpyDef.addRelation(relPayr0304);  
  
					   // DETAILS 
			           final Grid payr0304Grid = payr0304GridPanel.getMsfGrid().getGrid();
			           payr0304Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (payr0304GridPanel.getCurrentlySelectedItem() != null) { 
			            		  
			            		  //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
                                  leftPayr0304Detail(payr0304GridPanel.getCurrentlySelectedItem());
                                 
                                 
                                  payr0302ExtpyDef.synchronizeGridDetail(
			            				  payr0304GridPanel.getCurrentlySelectedItem(),
			            				  payr0302ExtpyGridPanel ); 
                                 
			            		 
			            		 // payr0302ExtpyGridPanel.reload(); 
			            	   }
			            	  
			            	  actionDatabase = ActionDatabase.UPDATE;
			              }
			          }); 
			           
			           
					   final RelationDef  relPayr030401 = new RelationDef(payr0304Def,false);
			           relPayr030401.addJoinDef("pymtYrMnth", "pymtYrMnth");
			           relPayr030401.addJoinDef("dpobCd", "dpobCd");
			           relPayr030401.addJoinDef("systemkey", "systemkey");
			           relPayr030401.addJoinDef("payCd", "payCd");
			           relPayr030401.addJoinDef("payrSeilNum", "payrSeilNum"); 
			           relPayr030401.setLinkedObject(payr0304GridPanel);
			           payr0302DducDef.addRelation(relPayr030401);   
 
		 
			           // DETAILS 
			           final Grid payr0304Grid01 = payr0304GridPanel.getMsfGrid().getGrid();
			           payr0304Grid01.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (payr0304GridPanel.getCurrentlySelectedItem() != null) { 
			            		   
			            		 
			            		  payr0302DducDef.synchronizeGridDetail(
			            				  payr0304GridPanel.getCurrentlySelectedItem(),
			            				  payr0302DducGridPanel );
			            		  
			            		  //payr0302DducGridPanel.reload(); 
			            		   
			            	   }
			              }
 			          }); 
 
		 
			           final RelationDef  relPayr030402 = new RelationDef(payr0304Def,false);
			           relPayr030402.addJoinDef("pymtYrMnth", "pymtYrMnth");
			           relPayr030402.addJoinDef("dpobCd", "dpobCd");
			           relPayr030402.addJoinDef("systemkey", "systemkey");
			           relPayr030402.addJoinDef("payCd", "payCd");
			           relPayr030402.addJoinDef("payrSeilNum", "payrSeilNum"); 
			           relPayr030402.setLinkedObject(payr0304GridPanel);
			           payr0307Def.addRelation(relPayr030402); 
  
			           // DETAILS 
			           final Grid payr0304Grid02 = payr0304GridPanel.getMsfGrid().getGrid();
			           payr0304Grid02.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (payr0304GridPanel.getCurrentlySelectedItem() != null) { 
			            		 
			            		  setRecord(payr0304GridPanel.getCurrentlySelectedItem());	
			              		  actionDatabase = ActionDatabase.DELETE;
			              		  
			            		  payr0307Def.synchronizeGridDetail(
			            				  payr0304GridPanel.getCurrentlySelectedItem(),
			            				  payr0307GridPanel ); 
			            		  
			            		  InfcPkgDlgn0250DTO infcPkgDlgn0250Dto = new InfcPkgDlgn0250DTO();
			            		  

			            		  infcPkgDlgn0250Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    																	*//** column 사업장코드 : dpobCd *//*
			            		  infcPkgDlgn0250Dto.setSystemkey(MSFSharedUtils.allowNulls(record.get("systemkey")));    															*//** column SYSTEMKEY : systemkey *//*
			            		  infcPkgDlgn0250Dto.setDilnlazYrMnth(MSFSharedUtils.allowNulls(record.get("pymtYrMnth")));    									*//** column 근태년월 : dilnlazYrMnth *//*
			            		  infcPkgDlgn0250Dto.setPayCd(MSFSharedUtils.allowNulls(record.get("payCd")));    																	*//** column 급여구분코드 : payCd *//*
			            		  infcPkgDlgn0250Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(record.get("emymtDivCd")));    															*//** column 고용구분코드 : emymtDivCd *//*
			            		  infcPkgDlgn0250Dto.setDeptCd(MSFSharedUtils.allowNulls(record.get("deptCd")));    																	*//** column 부서코드 : deptCd *//*
			            		  infcPkgDlgn0250Dto.setBusinCd(MSFSharedUtils.allowNulls(record.get("businCd")));    																*//** column 사업코드 : businCd *//*
			            		     
			            		  
			            		  getDlgn250Data( infcPkgDlgn0250Dto) ;
			            		  
			            	   }
			            	  
			            	  // payr0307GridPanel.reload(); 
			            	   actionDatabase = ActionDatabase.UPDATE;
			                
			              }
			          });*/  
   
			            
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
	public Payr4201() { //4200복사 후 4201로 변경 6.16 -"2"

		setSize("1010px", "700px");
	}

	public Payr4201(String txtForm) { //4200복사 후 4201로 변경 6.16 -"3"
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

		plFrmPayr4200 = new FormPanel();
		/*plFrmPayr4200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ lblPayrConst.title_Payr4200());*/
		plFrmPayr4200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여내역조회관리"));
		plFrmPayr4200.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr4200.setBodyStyleName("pad-text");
		plFrmPayr4200.setPadding(2);
		plFrmPayr4200.setFrame(true);
			
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr4200(),"PAYR4200");
				}
			});
		plFrmPayr4200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr4200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmPayr4200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FlowLayout());

		ButtonBar buttonBar_1 = new ButtonBar();
		
		
		//화면 상단 조정내역,조정내역일괄정리 버튼을 주석처리 6.17 -"23"
		/*Button btnNewButton_2 = new Button("조정내역");
		btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
		buttonBar_1.add(btnNewButton_2);
		btnNewButton_2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"))){
					MessageBox.info("", "단위기관을 선택해 주세요.", null);
					return;
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"))) {
					MessageBox.info("", "급여구분을 선택해 주세요.", null);
					return;
				}
//				else if(MSFSharedUtils.paramNull(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
//					MessageBox.info("", "부서를 선택해 주세요.", null);
//					return;
//				}
				
				
		   		//검색조건을 값에 넣어 넘김. 
		   	  	BaseModel bmData = new BaseModel(); 
		    		   
		    		   
		   	  	bmData.set("dpobCd", dpobCd.getValue());
				bmData.set("srhSystemkey", srhSystemkey.getValue());
				bmData.set("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
				bmData.set("payMonth", MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"));
				bmData.set("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));
				bmData.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				bmData.set("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
				bmData.set("emymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				bmData.set("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
				bmData.set("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
				bmData.set("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
				bmData.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
					
//				bmData.set("srhPayYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
//				bmData.set("srhPayMonth", MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"));
//					 	bmData.set("srhPayCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCdNm"));
				bmData.set("srhPayrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptNm"));
				bmData.set("srhHanNm", srhHanNm.getValue());
				bmData.set("srhResnRegnNum", srhResnRegnNum.getValue());
				bmData.set("srhEmymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCdNm"));
				bmData.set("srhDeptCd", srhDeptCd.getValue());
				bmData.set("srhTypOccuCd", srhTypOccuCd.getValue());
				bmData.set("srhDtilOccuInttnCd", srhDtilOccuInttnCd.getValue());
				bmData.set("srhBusinCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businNm"));
				bmData.set("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
					 	
		    	bmData.set("systemkey", srhSystemkey.getValue());
		    	           
				setPPRecord(bmData); // 팝업에 넘길값

				PayrP420001 payrP42001Form = new PayrP420001(ActionDatabase.READ, getThis());

				MSFFormWindows msFwPayr42001 = new MSFFormWindows("급여조정내역",payrP42001Form, "닫기", "920px", "710px", true);
				msFwPayr42001.show();
				payrP42001Form.setMSFFormWindows(msFwPayr42001);
				payrP42001Form.bind(ppRecord);
			}
		});
			  
			  
		Button btnNewButton_3 = new Button("조정내역일괄등록");
		btnNewButton_3.setIcon(MSFMainApp.ICONS.text());
		buttonBar_1.add(btnNewButton_3);
		btnNewButton_3.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"))){
					MessageBox.info("", "단위기관을 선택해 주세요.", null);
					return;
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"))) {
					MessageBox.info("", "급여구분을 선택해 주세요.", null);
					return;
				}
//				else if(MSFSharedUtils.paramNull(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
//					MessageBox.info("", "부서를 선택해 주세요.", null);
//					return;
//				}
				
		   		//검색조건을 값에 넣어 넘김. 
		   	  	BaseModel bmData = new BaseModel(); 
		    		   
		    		   
		   	  	bmData.set("dpobCd", dpobCd.getValue());
				bmData.set("srhSystemkey", srhSystemkey.getValue());
				bmData.set("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
				bmData.set("payMonth", MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"));
				bmData.set("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));
				bmData.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				bmData.set("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
				  
			
				bmData.set("emymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				bmData.set("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
				bmData.set("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
				bmData.set("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
				bmData.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
					 	
					 	
//				bmData.set("srhPayYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
//				bmData.set("srhPayMonth", MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"));
//					 	bmData.set("srhPayCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCdNm"));
				bmData.set("srhPayrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptNm"));
				bmData.set("srhHanNm", srhHanNm.getValue());
				bmData.set("srhResnRegnNum", srhResnRegnNum.getValue());
				bmData.set("srhEmymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCdNm"));
				bmData.set("srhDeptCd", srhDeptCd.getValue());
				bmData.set("srhTypOccuCd", srhTypOccuCd.getValue());
				bmData.set("srhDtilOccuInttnCd", srhDtilOccuInttnCd.getValue());
				bmData.set("srhBusinCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businNm"));
				bmData.set("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
					 	
		    	bmData.set("systemkey", srhSystemkey.getValue());
		    	           
				setPPRecord(bmData); // 팝업에 넘길값

				PayrP420002 payrP42002Form = new PayrP420002(ActionDatabase.READ, getThis());

				MSFFormWindows msFwPayr42002 = new MSFFormWindows("조정내역일괄등록",payrP42002Form, "닫기", "920px", "710px", true);
				msFwPayr42002.show();
				payrP42002Form.setMSFFormWindows(msFwPayr42002);
				payrP42002Form.bind(ppRecord);
				
			}
		});*/
			  
		layoutContainer_1.add(buttonBar_1);
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		topPayr4200Bar = new ButtonBar();
		layoutContainer_2.add(topPayr4200Bar);
		topPayr4200Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
		  	
		btnPayr4200Init = new Button("초기화");
		btnPayr4200Init.setIcon(MSFMainApp.ICONS.new16());
		topPayr4200Bar.add(btnPayr4200Init);
		btnPayr4200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 초기화
				formInit();
			}
		});
				
		btnPayr4200Del = new Button("일괄정리");
		btnPayr4200Del.setIcon(MSFMainApp.ICONS.delete16());
		topPayr4200Bar.add(btnPayr4200Del);
		//일괄정리 처리 시작 6.19 -"113"
		btnPayr4200Del.addSelectionListener(selectionListener);
		

		
		btnPayr4200Sreach = new Button("조회");
		btnPayr4200Sreach.setIcon(MSFMainApp.ICONS.search16());
		topPayr4200Bar.add(btnPayr4200Sreach);
		btnPayr4200Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				//메세지박스 추가 6.19 -"110" war만들기10
				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"))){
					MessageBox.info("", "단위기관을 선택해 주세요.", null);
					return;
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"))) {
					MessageBox.info("", "급여구분을 선택해 주세요.", null);
					return;
				}
				
				reloadPayr4200();
			}
		});
		
		
		
		
		//인쇄,급여대장,급여내역 버튼 주석처리 6.17 -"24"
		/*btnPayr4200Print = new Button("인쇄");
		btnPayr4200Print.setIcon(MSFMainApp.ICONS.print16());
		topPayr4200Bar.add(btnPayr4200Print);
		btnPayr4200Print.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				// Payr4200Print("PAYRT4200") ;
				
				String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
				String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd");
			 
				String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
				String deptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
				String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
				
				
				if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
					if(emymtDivCd.equals("A0020010")){
						Payr4200Print("PAYRT4200",MSFMainApp.getMsg("PayGen.ReportDivisionType"));
					}else if(emymtDivCd.equals("A0020020")){
						if((deptCd == null || deptCd.equals("")) && (mangeDeptCd == null || mangeDeptCd.equals(""))){
							Window.alert("부서를 선택해 주세요");
							return;
						}	
						if((businCd == null || businCd.equals("")) && (mangeDeptCd == null || mangeDeptCd.equals(""))){	
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
			  	
		btnPayr4200Excel = new Button("급여대장");
		btnPayr4200Excel.setIcon(MSFMainApp.ICONS.excel16());
		topPayr4200Bar.add(btnPayr4200Excel);
		btnPayr4200Excel.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				// exportExcel();
				// payr0304GridPanel.callExportServlet("");
				
				
				String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
				String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd");
				String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
				String deptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
				String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

				
				
				
				if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
					if(emymtDivCd.equals("A0020010")){
						exportExcel();
					}else if(emymtDivCd.equals("A0020020")){
//						if(deptCd == null || deptCd.equals("")){
//							Window.alert("부서를 선택해 주세요");
//							return;
//						}	
//						if(businCd == null || businCd.equals("")){	
//							Window.alert("사업을 선택해 주세요");
//							return;
//						}
						exportExcel2();
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

		btnPayr4200SumExcel = new Button("급여내역");
		btnPayr4200SumExcel.setIcon(MSFMainApp.ICONS.excel16());
		topPayr4200Bar.add(btnPayr4200SumExcel);
		btnPayr4200SumExcel.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				// exportExcel();
				// payr0304GridPanel.callExportServlet("");
				exportTotExcel();
			}
		});*/
			  	
			   
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.setBorders(false);
		layoutContainer.setBorders(false);

		plFrmPayr4200.add(layoutContainer);

		// 파일업로드 처리
		plFrmPayr4200.setAction("bizform");
		plFrmPayr4200.setEncoding(Encoding.MULTIPART);
		plFrmPayr4200.setMethod(Method.POST);

		vp.add(plFrmPayr4200);
		plFrmPayr4200.setSize("990px", "680px");
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
		
		
		//4200복사 후 추가 6.16 -"5"
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//지급공제 
		sysComBass0300Dto.setRpsttvCd("B008");
		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		//4200복사 후 추가 6.16 -"6"
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
				 
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		
		
		
		
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
		 //-------------------관리부서 추가  
		  sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
        sysComBass0400Dto.setDeptDspyYn("Y");
        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
        sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
        sysComBass0400Dto.setTypOccuUseYn("A");  //표시인경우 A 대입 
        lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
         
        lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {  
        		mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
        		srhDeptCd.getInitStore().add(mDtalistDeptCd);
                  
        	}
        });     
          //--------------------급여부서 불러 오는 함수 ------------------------------------------------
          
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
				mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});  
			 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 년도 콤보박스 처리  시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		 */
		
		ContentPanel payYrGrid = new ContentPanel();
		payYrGrid.setVisible(false);
	  		    
		//년도 콤보처리 
	  	payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
	  	payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
	  		public void handleEvent(ComponentEvent be) {  
	  			payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
	  				public void handleEvent(StoreEvent<BaseModel> be) {  
	  					lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
	  			        	 
	  			        	//  Date today = new Date(); 
	  			        	    // A custom date format
	  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
	  			        	 
	  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
	  			      	     // srhPayYr.setValue(bm);
	  			        	//srhPayYr.setValue(lsPayYrStore.getAt(0));
	  			        	//Date today = new Date(); 
                            //DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
                            //srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
                     
					}
	  			});
	  		}
		});
	  	  
		payYrGrid.add(payYrGridPanel);
		plFrmPayr4200.add(payYrGrid);

	  
	    plFrmPayr4200.setLayout(new FlowLayout());
	    
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
		
		//4200복사후 검색조건 변경, 뼈대는 4050검색조건, 지급공제구분,항목 추가(payrP420001),디자인,combo형식은 4200을 가지고 수정함 6.16 -"6" 
		/*fieldSet.setStyleAttribute("marginTop", "10px");*/
		
		LayoutContainer lcSchLeft = new LayoutContainer();
	    lcSchLeft.setStyleAttribute("paddingRight", "10px");
	  

	    LayoutContainer layoutContainer = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
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
		    		     checkPayr4200Auth("PayrMangDeptCd", lsPayrMangDeptCd );   
                	 }

                
            }
        });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		sysComBass0400Dto = new PrgmComBass0400DTO(); 
        		sysComBass0400Dto.setDeptDspyYn("Y");
                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
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
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer_14.setLayout(frmlytSch);
	    
	    srhPayCd =  new ComboBox<BaseModel>(); 
        srhPayCd.setName("srhPayCd");
        srhPayCd.setForceSelection(true);
        srhPayCd.setMinChars(1);
        srhPayCd.setDisplayField("commCdNm");
        srhPayCd.setValueField("commCd");
        srhPayCd.setTriggerAction(TriggerAction.ALL);
        srhPayCd.setEmptyText("--급여구분선택--");
        srhPayCd.setSelectOnFocus(true); 
        srhPayCd.setReadOnly(false);
        srhPayCd.setEnabled(true); 
        srhPayCd.setStore(lsPayCd);
        srhPayCd.setFieldLabel("급여구분");
        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	checkPayr4200Auth("srhPayCd",lsPayCd);   
            }
        });
        
	    layoutContainer_14.add(srhPayCd, new FormData("100%"));
	    layoutContainer_14.setBorders(false);
	    
	    
	    LayoutContainer lc_101 = new LayoutContainer();
	    lc_101.setLayout(new ColumnLayout());
	    
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_10);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_10.setLayout(frmlytSch);
	    
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
	    layoutContainer_10.add(srhEmymtDivCd, new FormData("100%"));
	    layoutContainer_10.setBorders(false);
	    
	    
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
	    srhRepbtyBusinDivCd.setAllowBlank(true);
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
	 
	 
	    lc_101.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
	    lc_101.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    
	     
	    
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_8.setLayout(frmlytSch);
	    
	    /** column 지급년월 : payYr */
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
                          
	        				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
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
            			srhPayMonth.setValue(lsPayMonth.findModel("month", DateTimeFormat.getFormat("MM").format(new Date())));
            			
            			checkPayr4200Auth("srhPayMonth", lsPayMonth); 
            	}
            }
        }); 
	     
	     
	    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    layoutContainer_9.setBorders(false);
	  
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
	    lcSchCol.add(lc_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
	    
	     
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    
	    
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
  	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
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
	      	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
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
	    
	    
	    
	  //검색 소속부서 코드 처리  
	    srhDeptCd = new MSFMultiComboBox<ModelData>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setEmptyText("--부서선택--");
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
        				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));    
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
	    
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_1.setLayout(frmlytSch);
	    
        
        //직종 직종세처리  
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
           
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(80); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
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
        frmlytSch.setDefaultWidth(0);
//        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
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
		    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			    		   //2015.11.30 추가 
			    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
		         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
			                   
			                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
			                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
			                    
		                }  
		    		   }	   
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
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
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
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
//        srhDtilOccuInttnCd.setStyleAttribute("paddingLeft", "5px");
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
        layoutContainer_1.add(lcTypOccuCd, new FormData("100%"));
	    
	    		 
        layoutContainer_13.add( lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.52)); 
        
	    fieldSet.add(layoutContainer_13);
	    layoutContainer_13.setBorders(false); 
		
	    
	    
	    LayoutContainer layoutContainer_13_1 = new LayoutContainer();
	    layoutContainer_13_1.setLayout(new ColumnLayout());
	    
	    
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
	    
	    
	  //수정부분
	    
	    LayoutContainer layoutContainer_17 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_17.setLayout(frmlytSch);
	 	
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
		srhPymtDducDivCd.setFieldLabel("지급공제구분");  
		srhPymtDducDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				
				Payr0470DTO payr0470Dto = new Payr0470DTO();
				
				payr0470Dto.setPymtDducDivCd(PayrUtils.getSelectedComboValue(srhPymtDducDivCd, "commCd"));
				
				//지급공제구분 선택에 따라 지급공제항목을 가져옴
				payr4201Service.getPayDducExtpyCd(payr0470Dto, new AsyncCallback<List<BaseModel>>() {
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("오류 : " + caught);
					}
					
					@Override
					public void onSuccess(List<BaseModel> result) {
						// TODO Auto-generated method stub
						
						// -- 초기화 -- 
						srhPayDducExtpyCd.setStore(new ListStore<BaseModel>());
						srhPayDducExtpyCd.setValue(new BaseModel());
						lsPayDducExtpyCd.removeAll();
						// -- 초기화 -- 
						
						lsPayDducExtpyCd.add(result);
						srhPayDducExtpyCd.setStore(lsPayDducExtpyCd); 
					}
				});
			} 
		});  
		
		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytSch);
		
		srhPayDducExtpyCd = new ComboBox<BaseModel>(); 
		srhPayDducExtpyCd.setName("srhPayDducExtpyCd");
		srhPayDducExtpyCd.setForceSelection(true);
		srhPayDducExtpyCd.setMinChars(1);
		srhPayDducExtpyCd.setDisplayField("commCdNm");
		srhPayDducExtpyCd.setValueField("commCd");
		srhPayDducExtpyCd.setTriggerAction(TriggerAction.ALL);
		srhPayDducExtpyCd.setEmptyText("--지급공제구분선택--");
		srhPayDducExtpyCd.setSelectOnFocus(true); 
		srhPayDducExtpyCd.setReadOnly(false);
		srhPayDducExtpyCd.setEnabled(true); 
		srhPayDducExtpyCd.setStore(new ListStore<BaseModel>()); 
		srhPayDducExtpyCd.setFieldLabel("지급공제항목");  
		
		layoutContainer_17.add(srhPayDducExtpyCd, new FormData("100%"));
		layoutContainer_17.setBorders(false);
	    
	    
	 	
		layoutContainer_18.add(srhPymtDducDivCd, new FormData("100%"));
		layoutContainer_18.setBorders(false);
	    
	    
	    
	    //수정부분
	    
	    
	    
	    layoutContainer_13_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.48));
	    layoutContainer_13_1.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));  //수정
	    layoutContainer_13_1.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));  //수정
        
	    fieldSet.add(layoutContainer_13_1);
	    layoutContainer_13_1.setBorders(false);  
	    
	    
	    plFrmPayr4200.add(fieldSet); 
	//vp.add(panel);   
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
		
		
		//수당에서 바로 불러올 수 있도록 주석처리 6.17 -"13"
		//수당그리드가 아닌 근로자급여정보그리드를 참고하기위해 다시 주석해제 6.18 -"63"
		sysComBass0300Dto = new PrgmComBass0300DTO();
	 
	    
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//급여구분 
		sysComBass0300Dto.setRpsttvCd("B008");
		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		dpobCd = new HiddenField<String>(); 			// 사업장코드
		systemkey = new HiddenField<String>();			//** column SYSTEMKEY : systemkey *//*
		pymtYrMnth = new HiddenField<String>();			//** column 지급년월 : pymtYrMnth *//*
		payCd = new HiddenField<String>();				//** column 급여구분코드 : payCd *//*
		payrMangDeptCd = new HiddenField<String>();		//** column 단위기관코드 : payrMangDeptCd *//*
		payrSeilNum = new HiddenField<Long>();			//** column 급여일련번호 : payrSeilNum *//*
		emymtDivCd = new HiddenField<String>();			//** column 고용구분코드 : emymtDivCd *//*
		deptCd = new HiddenField<String>();				//** column 부서코드 : deptCd *//*
		businCd = new HiddenField<String>();			//** column 사업코드 : businCd *//*
		typOccuCd = new HiddenField<String>();			//** column 직종코드 : typOccuCd *//*
		typOccuNm = new HiddenField<String>();
		logSvcYrNumCd = new HiddenField<String>();		//** column 근속년수코드 : logSvcYrNumCd *//*
		txtnTotAmnt = new HiddenField<Long>();			//** column 과세총액 : txtnTotAmnt *//*
		bnkCd = new HiddenField<String>();				//** column 은행코드 : bnkCd *//*
		bnkNm = new HiddenField<String>();				//** column 은행코드 : bnkNm *//*
		bnkAccuNum = new HiddenField<String>();			//** column 은행계좌번호 : bnkAccuNum *//*
		acntHodrNm = new HiddenField<String>();			//** column 예금주명 : acntHodrNm *//*
		payDdlneDt = new HiddenField<String>();			//** column 급여마감일자 : payDdlneDt *//*
		payDdlneYn = new HiddenField<String>();			//** column 급여마감여부 : payDdlneYn *//*
		txTotAmnt = new HiddenField<Long>();   
	    
		//수당그리드를 확대하기 위해 4050의 급여스케줄정보 그리드를 가져와 제목만 수정 6.16 -"9"
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize("963px", "500px"); 
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("급여내역조회");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_1.setBorders(false);
		layoutContainer_1.setStyleAttribute("margintTop", "10px");
		
		//수당그리드 수정 occupationalLeft -> payrLeft01 6.16 -"10"
		//근로자급여정보그리드 이벤트 방식으로 수정 6.17 -"57"
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%")); 
		 
		
		/*LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize("330px", "490px");
		
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("근로자급여정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_1.setBorders(false);
		layoutContainer_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_10 = new LayoutContainer();
		layoutContainer_10.setLayout(new FitLayout());
		
		FieldSet fldstNewFieldset_3 = new FieldSet();
		fldstNewFieldset_3.setHeadingHtml("근무실적정보");
		
		LayoutContainer layoutContainer_6 = new LayoutContainer(); 
		layoutContainer_6.setLayout(new FitLayout());
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel(); 
		cntntpnlNewContentpanel.setCollapsible(false);
		cntntpnlNewContentpanel.setBodyBorder(false); 
		cntntpnlNewContentpanel.setHeaderVisible(false);   
		cntntpnlNewContentpanel.setLayout(new FitLayout());      
		cntntpnlNewContentpanel.setSize(286, 80);  
		 
		LayoutContainer layoutContainer_7_10 = new LayoutContainer();
		layoutContainer_7_10.setLayout(new ColumnLayout());
	 
		 
		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
		
		dilnlazDutyNumDys = new MSFTextField();  
		dilnlazDutyNumDys.setReadOnly(true); 
		dilnlazDutyNumDys.setFieldLabel("월총일수");  
	     
		layoutContainer_7.add(dilnlazDutyNumDys, new FormData("100%"));
		
		
		dilnlazLvsgNumDys =  new MSFTextField();   
		dilnlazLvsgNumDys.setReadOnly(true); 
		dilnlazLvsgNumDys.setFieldLabel("사용휴가");  
	    layoutContainer_7.add(dilnlazLvsgNumDys, new FormData("100%"));
	

	    dilnlazFndtnTmRstDutyTm =  new MSFTextField();   
	    dilnlazFndtnTmRstDutyTm.setReadOnly(true); 
	    dilnlazFndtnTmRstDutyTm.setFieldLabel("연장기본");  
	    layoutContainer_7.add(dilnlazFndtnTmRstDutyTm, new FormData("100%"));
	    
	    
	    dilnlazTmRstDutyTm =  new MSFTextField();   
	    dilnlazTmRstDutyTm.setReadOnly(true); 
	    dilnlazTmRstDutyTm.setFieldLabel("연장근무");  
	    layoutContainer_7.add(dilnlazTmRstDutyTm, new FormData("100%"));
	    
	    
	    dilnlazTotTmRstDutyTm =  new MSFTextField();   
	    dilnlazTotTmRstDutyTm.setReadOnly(true); 
	    dilnlazTotTmRstDutyTm.setFieldLabel("총연장근무");  
	    layoutContainer_7.add(dilnlazTotTmRstDutyTm, new FormData("100%"));
	     
	    
	    layoutContainer_7.setBorders(false);   
		 
	    layoutContainer_7_10.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    
	    
		LayoutContainer layoutContainer_77 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_77.setLayout(frmlytStd);
		
		dilnlazTotDutyNumDys = new MSFTextField();  
		dilnlazTotDutyNumDys.setReadOnly(true); 
		dilnlazTotDutyNumDys.setFieldLabel("총근무일");  
	     
		layoutContainer_77.add(dilnlazTotDutyNumDys, new FormData("100%"));
		
		
		dilnlazPubcHodyDutyNumDys =  new MSFTextField();   
		dilnlazPubcHodyDutyNumDys.setReadOnly(true); 
		dilnlazPubcHodyDutyNumDys.setFieldLabel("휴일근무");  
		layoutContainer_77.add(dilnlazPubcHodyDutyNumDys, new FormData("100%"));
		

	    dilnlazLvsgNumDys =  new MSFTextField();   
		dilnlazLvsgNumDys.setReadOnly(true); 
		dilnlazLvsgNumDys.setFieldLabel("휴일연장");  
		layoutContainer_77.add(dilnlazLvsgNumDys, new FormData("100%"));
		
		dilnlazTotNtotTm =  new MSFTextField();   
		dilnlazTotNtotTm.setReadOnly(true); 
		dilnlazTotNtotTm.setFieldLabel("야간근무");  
		layoutContainer_77.add(dilnlazTotNtotTm, new FormData("100%"));
		
		
		dilnlazWklyHldyNumDys =  new MSFTextField();   
		dilnlazWklyHldyNumDys.setReadOnly(true); 
		dilnlazWklyHldyNumDys.setFieldLabel("주휴일수");  
		layoutContainer_77.add(dilnlazWklyHldyNumDys, new FormData("100%"));
		
		layoutContainer_77.setBorders(false);   
		
		 
	    layoutContainer_7_10.add(layoutContainer_77,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		cntntpnlNewContentpanel.setTopComponent(layoutContainer_7_10);
	  	
		 
		layoutContainer_6.add(cntntpnlNewContentpanel);
		fldstNewFieldset_3.add(layoutContainer_6);
		layoutContainer_6.setBorders(false);
		layoutContainer_10.add(fldstNewFieldset_3);
		
		fldstNewFieldset_3.setSize(308, 220);
		fldstNewFieldset_3.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_3.setCollapsible(false);
		fldstNewFieldset.add(layoutContainer_10);	
		layoutContainer_10.setBorders(false); 
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize(622, 310);
		

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
		layoutContainer_3.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_4.setHeadingHtml("수 당");
		 
		
		FieldSet fldstNewFieldset_5 = new FieldSet();
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.add(payrLeft02());
		fldstNewFieldset_5.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);
		layoutContainer_3.add(fldstNewFieldset_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_5.setHeadingHtml("공 제");
		fldstNewFieldset_5.setCollapsible(false);
		fldstNewFieldset_1.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(622, 170);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("급여조정");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
		
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_2.setBorders(false);*/
		
		
		plFrmPayr4200.add(layoutContainer);
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
	
	//수당에서 바로 불러올 수 있도록 주석처리 6.17 -"14"
 /*private LayoutContainer occupationalRTop() {
	 
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
	 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(610, 100);  
	   
	   LayoutContainer lytCtr01 = new LayoutContainer();
	   lytCtr01.setLayout(new FlowLayout());
	   
	   LayoutContainer layoutContainer_5 = new LayoutContainer();
	   layoutContainer_5.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_6 = new LayoutContainer();
	   FormLayout  frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(66); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_6.setLayout(frmlytStd);
	   
	   hanNm  = new MSFTextField();
	   layoutContainer_6.add(hanNm, new FormData("100%"));
	   hanNm.setFieldLabel("성 명");
	   hanNm.setReadOnly(true);
	   layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_6.setBorders(false);
	   
	   LayoutContainer layoutContainer_7 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(5); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_7.setLayout(frmlytStd);
	   
	   secRegnNum = new HiddenField<String>();
	   
	   resnRegnNum = new MSFTextField();
	   resnRegnNum.setReadOnly(true);
	   resnRegnNum.setLabelSeparator("");
	   layoutContainer_7.add(resnRegnNum, new FormData("100%"));
	  // resnRegnNum.setFieldLabel("주민번호");
	   layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_7.setBorders(false);
	   
	   LayoutContainer layoutContainer_8 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_8.setLayout(frmlytStd);
	   
	   logSvcYrNumNm = new MSFTextField();
	   logSvcYrNumNm.setReadOnly(true);
	   layoutContainer_8.add(logSvcYrNumNm, new FormData("100%"));
	   logSvcYrNumNm.setFieldLabel("근속년수");
	   layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer_8.setBorders(false);
	   lytCtr01.add(layoutContainer_5);
	   layoutContainer_5.setBorders(false);
	    
	   LayoutContainer layoutContainer_9 = new LayoutContainer();
	   layoutContainer_9.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_10 = new LayoutContainer();
       frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_10.setLayout(frmlytStd);
	   
	   deptNm = new MSFTextField();
	   deptNm.setReadOnly(true);
	   layoutContainer_10.add(deptNm, new FormData("100%"));
	   deptNm.setFieldLabel("부서");
	   layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer_10.setBorders(false);
	   
	   LayoutContainer layoutContainer_11 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_11.setLayout(frmlytStd);
	   
	   businNm = new MSFTextField();
	   businNm.setReadOnly(true);
	   layoutContainer_11.add(businNm, new FormData("100%"));
	   businNm.setFieldLabel("직종(사업)");
	   layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer_11.setBorders(false);
	   lytCtr01.add(layoutContainer_9);
	   layoutContainer_9.setBorders(false);
	   
	   LayoutContainer layoutContainer_12 = new LayoutContainer();
	   layoutContainer_12.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_13 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_13.setLayout(frmlytStd);
	   
	   pymtTotAmnt = new MSFNumberField();
	   pymtTotAmnt.setReadOnly(true);
	   layoutContainer_13.add(pymtTotAmnt, new FormData("100%"));
	   pymtTotAmnt.setFieldLabel("급여합계"); 
	   pymtTotAmnt.setAllowDecimals(true); 
	   pymtTotAmnt.setFormat(NumberFormat.getDecimalFormat());
	  // pymtTotAmnt.setPropertyEditor(new NumberPropertyEditor(Long.class)); 
	   
	   layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_13.setBorders(false);
	   
	   LayoutContainer layoutContainer_14 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_14.setLayout(frmlytStd);
	   
	   extpyTotAmnt = new MSFNumberField();
	   extpyTotAmnt.setReadOnly(true);
	   layoutContainer_14.add(extpyTotAmnt, new FormData("100%"));
	   extpyTotAmnt.setFieldLabel("수당합계");
	   extpyTotAmnt.setAllowDecimals(true); 
	   extpyTotAmnt.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   
	   LayoutContainer layoutContainer = new LayoutContainer();
	 frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer.setLayout(frmlytStd);
	   
	   dducTotAmnt = new MSFNumberField();
	   dducTotAmnt.setReadOnly(true);
	   layoutContainer.add(dducTotAmnt, new FormData("100%"));
	   dducTotAmnt.setFieldLabel("공제금액");
	   dducTotAmnt.setAllowDecimals(true); 
	   dducTotAmnt.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer.setBorders(false);
	   
	   LayoutContainer layoutContainer_1 = new LayoutContainer();
     frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_1.setLayout(frmlytStd);
	   
	   pernPymtSum = new MSFNumberField();
	   pernPymtSum.setReadOnly(true);
	   layoutContainer_1.add(pernPymtSum, new FormData("100%"));
	   pernPymtSum.setFieldLabel("실수령액");
	   pernPymtSum.setAllowDecimals(true);  
	   pernPymtSum.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_12.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_1.setBorders(false);
	   lytCtr01.add(layoutContainer_12);
	   layoutContainer_12.setBorders(false);
	   
	   LayoutContainer layoutContainer_2 = new LayoutContainer();
	   layoutContainer_2.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_3 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_3.setLayout(frmlytStd);
	  
	   pymtB10100Sum = new MSFNumberField();
	   pymtB10100Sum.setReadOnly(true);
	   layoutContainer_3.add(pymtB10100Sum, new FormData("100%"));
	   pymtB10100Sum.setFieldLabel("기본급");
	   pymtB10100Sum.setAllowDecimals(true); 
	   pymtB10100Sum.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_3.setBorders(false);
	   
	   LayoutContainer layoutContainer_4 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_4.setLayout(frmlytStd);

	   
	   pymtT10100Sum = new MSFNumberField();
	   pymtT10100Sum.setReadOnly(true);
	   layoutContainer_4.add(pymtT10100Sum, new FormData("100%"));
	   pymtT10100Sum.setFieldLabel("소득세");
	   pymtT10100Sum.setAllowDecimals(true); 
	   pymtT10100Sum.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_4.setBorders(false);
	   
	   LayoutContainer layoutContainer_15 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_15.setLayout(frmlytStd);
	   
	   pymtT20100Sum = new MSFNumberField();
	   pymtT20100Sum.setReadOnly(true);
	   layoutContainer_15.add(pymtT20100Sum, new FormData("100%"));
	   pymtT20100Sum.setFieldLabel("지방세");
	   pymtT20100Sum.setAllowDecimals(true); 
	   pymtT20100Sum.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_2.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_15.setBorders(false);
	   
	   LayoutContainer layoutContainer_16 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(66); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_16.setLayout(frmlytStd);
	   
	   freeDtyTotAmnt = new MSFNumberField();
	   freeDtyTotAmnt.setReadOnly(true); 
	  
	   layoutContainer_16.add(freeDtyTotAmnt, new FormData("100%"));
	   freeDtyTotAmnt.setFieldLabel("비과세");
	   freeDtyTotAmnt.setAllowDecimals(true); 
	   freeDtyTotAmnt.setFormat(NumberFormat.getDecimalFormat());
	   layoutContainer_2.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_16.setBorders(false);
	   lytCtr01.add(layoutContainer_2);
	   layoutContainer_2.setBorders(false);
	   cp01.add(lytCtr01);
	    
	   lcTabFormLayer.add(cp01); 
	      
	   return lcTabFormLayer;
	 
}*/ 

	//근로자급여정보 그리드를 급여내역조회로 변경 6.17 -"58"
 private LayoutContainer occupationalLeft() {
     
     LayoutContainer lcTabFormLayer = new LayoutContainer();
     
    //   
      ContentPanel cp01 = new ContentPanel();   
      cp01.setBodyBorder(false); 
      cp01.setHeaderVisible(false);   
      cp01.setLayout(new FitLayout());      
      cp01.setSize(945, 485);  
     
     //msfCustomForm.setHeaderVisible(false);
     //Instantiate the GridPanel
      
      
     payr0304GridPanel = new MSFGridPanel(payr0304AllDef, false, false, false, false,false);
     payr0304GridPanel.setHeaderVisible(false);  
     payr0304GridPanel.setBodyBorder(true);
     payr0304GridPanel.setBorders(true);
     
     //일괄정리 추가3 6.19 -"122"
     //일괄정리 주석처리 6.22 -"133"
     
     
     /*payr0304GridPanel.setHeaderVisible(false);  
     payr0304GridPanel.setBodyBorder(true);
     payr0304GridPanel.setBorders(true);*/
   //  payr0304GridPanel.setSize(308, 340);  
    //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//      final Grid payr0304Grid = payr0304GridPanel.getMsfGrid().getGrid(); 
//      payr0304Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {  
//              if (payr0304GridPanel.getCurrentlySelectedItem() != null) {  
//                 
//                  
//              }
//            }
//        });  
    
     cp01.add(payr0304GridPanel); 
      
      lcTabFormLayer.add(cp01); 
       
        return lcTabFormLayer;  
     
    }  

 //기존 급여내역조회 그리드는 주석처리 6.17 -"59"
 /*private LayoutContainer payrLeft01() {
	   
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(945, 485);  //수당그리드 크기 수정 300, 170 -> 945, 485 6.16 -"11"
	    
	   //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
	   payr0302ExtpyGridPanel = new MSFGridPanel(payr0302ExtpyAllDef, false, false, false, false,false); //수당그리드의 컬럼을 바꾸기위해 payr0302ExtpyAllDef로 수정 6.17 -"17"
	   payr0302ExtpyGridPanel.setHeaderVisible(false);  
	   payr0302ExtpyGridPanel.setBodyBorder(true);
	   payr0302ExtpyGridPanel.setBorders(true);
	 //  payr0302ExtpyGridPanel.setSize(300, 140);  
	   payr0302ExtpyGridPanel.getBottomComponent().setVisible(false);
	 
	   final Grid payr0302ExtpyGrid = payr0302ExtpyGridPanel.getMsfGrid().getGrid(); 
	   payr0302ExtpyGrid.addListener(Events.Select,  new Listener<BaseEvent>() {
	         public void handleEvent(BaseEvent be) {  
	       	  if (payr0302ExtpyGridPanel.getCurrentlySelectedItem() != null) { 
	       		  선택한 값을 가져오는 구문이라 주석처리 6.17 -"56" war만들기5
	       		setRecord(payr0302ExtpyGridPanel.getCurrentlySelectedItem()); //수당그리드의 컬럼을 바꾸기위해 4050 2170컬럼처럼 추가 6.17 -"18"
				actionDatabase = ActionDatabase.DELETE;
	       	  }
	         }
	     });  
	   
	    cp01.add(payr0302ExtpyGridPanel);  
	 
	    
	    // 화면 하단 저장 삭제 부분 주석처리 6.17 -"19"
	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
			
				  if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
			            MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
			            return;
			        } 
			        
				    setListRecord(null);
				  
				    MessageBox.confirm("수당저장", "수당내역을 저장하면 자동으로 소득세가 계산됩니다. \n 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
			            @Override
			            public void handleEvent(MessageBoxEvent be) { 
			            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                          
			                	 setListRecord(payr0302ExtpyGridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());  
			                 
			                     if (MSFSharedUtils.paramNull(getListRecord()) || !getListRecord().hasNext()) {
			                     	List<Record>  lsRec  = new ArrayList<Record>();
			                     	for ( int i = 0; i < payr0302ExtpyGridPanel.getMsfGrid().getStore().getCount(); i++){
			             			  if(payr0302ExtpyGridPanel.getMsfGrid().getStore().getRecord(payr0302ExtpyGridPanel.getMsfGrid().getStore().getAt(i)).isDirty()){ //변경된 로우가 있을경우
			             			 
			             				    BaseModel bm = payr0302ExtpyGridPanel.getMsfGrid().getStore().getAt(i); 
			             				    lsRec.add(payr0302ExtpyGridPanel.getMsfGrid().getStore().getRecord(bm));
			             			  }
			             			}
			                      
			                     	setListRecord(lsRec.iterator()); 
			                    
			                     	  
			                     } 
			                     
			                     actionDatabase = ActionDatabase.UPDATE;
			                        
			                     doSaveExtpyAction(actionDatabase); 
			                        
			                }
			            }
			        });    
				    
			}
		}));
	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
			    if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
	                MessageBox.alert("마감", " 마감처리된 데이타는 삭제를 하실 수 없습니다.", null);
	                return;
	            }
	           
	            
	            MessageBox.confirm("수당삭제", "수당을 삭제하면 자동으로 소득세가 계산됩니다. \n 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
	                @Override
	                public void handleEvent(MessageBoxEvent be) {
	                  //  if("Yes".equals(be.getButtonClicked().getText())){
	                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

	                        
	                        Iterator<BaseModel> itBm  = payr0302ExtpyGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                        
	                        List<Record>  lsRec  = new ArrayList<Record>();
	                        
	                        while(itBm.hasNext()) {

	                            Record rec  = new Record(itBm.next()); 
	                            lsRec.add(rec);
	                            
	                        } 
	                         setListRecord(lsRec.iterator()); 
	                          
	                         actionDatabase = ActionDatabase.DELETE;
	                         doSaveExtpyAction(actionDatabase);
	                          
	                            
	                    }
	                }
	            });   
			}
		}));
	    
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;  
	   
 }*/
 
//공제부분도 주석처리 6.17 -"15"
 /*private LayoutContainer payrLeft02() {
	   
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(300, 170);   
	   
	   //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
	    payr0302DducGridPanel = new MSFGridPanel(payr0302DducDef, false, false, false, false,false);
	    payr0302DducGridPanel.setHeaderVisible(false);  
	    payr0302DducGridPanel.setBodyBorder(true);
	    payr0302DducGridPanel.setBorders(true); 
	    payr0302DducGridPanel.getBottomComponent().setVisible(false);
	 //   payr0302DducGridPanel.setSize(300, 140); 
 
	    cp01.add(payr0302DducGridPanel);

	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				  if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
			            MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
			            return;
			        } 
			        
				    setListRecord(null);
				  
				    MessageBox.confirm("공제저장", "공제내역을 저장하면 자동으로 소득세가 계산됩니다. \n 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
			            @Override
			            public void handleEvent(MessageBoxEvent be) { 
			            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

			                	  setListRecord(payr0302DducGridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());  
			                     
			                     if (MSFSharedUtils.paramNull(getListRecord()) || !getListRecord().hasNext()) {
			                     	List<Record>  lsRec  = new ArrayList<Record>();
			                     	for ( int i = 0; i < payr0302DducGridPanel.getMsfGrid().getStore().getCount(); i++){
			             			  if(payr0302DducGridPanel.getMsfGrid().getStore().getRecord(payr0302ExtpyGridPanel.getMsfGrid().getStore().getAt(i)).isDirty()){ //변경된 로우가 있을경우
			             				    BaseModel bm = payr0302DducGridPanel.getMsfGrid().getStore().getAt(i); 
			             				    lsRec.add(payr0302DducGridPanel.getMsfGrid().getStore().getRecord(bm));
			             			  }
			             			}
			                     	
			                     	setListRecord(lsRec.iterator());  
			                     	  
			                     }  
			                        actionDatabase = ActionDatabase.UPDATE;
			                        
			                    	doSaveDDucAction(actionDatabase); 
			                        
			                }
			            }
			        });    
			}
		}));
	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
			    if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
	                MessageBox.alert("마감", " 마감처리된 데이타는 삭제를 하실 수 없습니다.", null);
	                return;
	            }
	           
	            
	            MessageBox.confirm("공제삭제", "공제를 삭제하면 자동으로 소득세가 계산됩니다. \n 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
	                @Override
	                public void handleEvent(MessageBoxEvent be) {
	                  //  if("Yes".equals(be.getButtonClicked().getText())){
	                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

	                        
	                        Iterator<BaseModel> itBm  = payr0302DducGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                        
	                        List<Record>  lsRec  = new ArrayList<Record>();
	                        
	                        while(itBm.hasNext()) {

	                            Record rec  = new Record(itBm.next()); 
	                            lsRec.add(rec);
	                            
	                        } 
	                         setListRecord(lsRec.iterator()); 
	                          
	                         actionDatabase = ActionDatabase.DELETE;
	                         doSaveDDucAction(actionDatabase);
	                          
	                            
	                    }
	                }
	            });  
			}
		}));
	    
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;  
	   
 }*/
 
//급여조정부분도 주석처리 6.17 -"16",war만들기1
//급여조정 
//private LayoutContainer occupationalRBottom() {
      

  //LayoutContainer lcTabFormLayer = new LayoutContainer();


  //cpGridPayr0307 = new ContentPanel();   
  //cpGridPayr0307.setBodyBorder(false); 
  //cpGridPayr0307.setHeaderVisible(false);   
  //cpGridPayr0307.setLayout(new FitLayout());      
  //cpGridPayr0307.setSize(610, 148);  
  
  
  /** 
   * 에디트 기능 사용시 liveGrid 기능 사용하면 그리드 캐짐. 주의 할것.
   */
  //msfCustomForm.setHeaderVisible(false);
  //Instantiate the GridPanel
  //payr0307GridPanel = new MSFGridPanel(payr0307Def, false, false, false, false,false);
  //payr0307GridPanel.setHeaderVisible(false);  
  //payr0307GridPanel.setBodyBorder(true);
  //payr0307GridPanel.setBorders(true); 
  //payr0307GridPanel.getBottomComponent().setVisible(false);
 // payr0307GridPanel.setSize(600, 145); 
  
  //final Grid payr0307Grid = payr0307GridPanel.getMsfGrid().getGrid(); 
  //payr0307Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
       // public void handleEvent(BaseEvent be) {  
      	  //if (payr0307GridPanel.getCurrentlySelectedItem() != null) {  
      		  
      	  //}
        //}
    //});  
  
  //cpGridPayr0307.add(payr0307GridPanel);  

  //cpGridPayr0307.addButton(  new Button("소득세재계산", new SelectionListener<ButtonEvent>() {   
    //@Override  
    //public void componentSelected(ButtonEvent ce) {   
        
        
     
     //if (MSFSharedUtils.paramNotNull(systemkey.getValue())) {
         
       
         //if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
            // MessageBox.alert("마감", " 마감처리된 데이타는 소득세를 재계산 하실 수 없습니다.", null);
             //return;
         //}
        
            
         //MessageBox.confirm("소득세재계산", "수동입력된 소득세 초기화 후 자동으로 소득세가 재계산됩니다. \n 이전 소득세 계산 오류가 있을 경우  소득세를  다시 계산합니다.\n 소득세를 재 계산 하시겠습니까?",new Listener<MessageBoxEvent>(){
             //@Override
             //public void handleEvent(MessageBoxEvent be) {
               //  if("Yes".equals(be.getButtonClicked().getText())){
            	// if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                    
                     //Payr0307DTO  payr0307Dto = new Payr0307DTO();  
                     
                     //payr0307Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
                     //payr0307Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(pymtYrMnth.getValue()));    /** column 지급년월 : pymtYrMnth */
                    // payr0307Dto.setPayCd(MSFSharedUtils.allowNulls(payCd.getValue()));    /** column 급여구분코드 : payCd */
                     //payr0307Dto.setPayrSeilNum(payrSeilNum.getValue());    /** column 급여일련번호 : payrSeilNum */
                     //payr0307Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));    /** column SYSTEMKEY : systemkey */
//                     payr0307Dto.setMnthPayAdmntSeilNum((Long)bmMapModel.get("mnthPayAdmntSeilNum"));    /** column 월급여조정일련번호 : mnthPayAdmntSeilNum */
//                     payr0307Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
//                     payr0307Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
//                     payr0307Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
//                     payr0307Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    /** column null : pymtDducTxtnAmnt */
//                     payr0307Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                     payr0307Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("mnthPayAdmntAssoBssCtnt")));    /** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
//                     payr0307Dto.setMnthPayAdmntYn((Boolean)bmMapModel.get("mnthPayAdmntYn"));    /** column 월급여소급조정여부 : mnthPayAdmntYn */
           
                     
 //                    payr4200Service.activityOnCalcPayr4200(payr0307Dto ,
   //                          new AsyncCallback<Long>() { 
     //                    public void onFailure(Throwable caught) {
       //                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
         //                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnCalcPayr4200() : " + caught), null);
           //              }
             //            public void onSuccess(Long result) { 
               //             if (result == 0) {
                 //               MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),   "소득세 재계산 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                   //             actionDatabase = ActionDatabase.UPDATE;
                     //       } else {
                       //         MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                         //              "소득세 재계산 처리가 완료되었습니다.", null);
                           //     reloadPayr4200();
                             //   actionDatabase = ActionDatabase.UPDATE;
                            //} 
                         //} 
                          
                     //}); 
                         
                 //}
             //}
        // });   
         
         
       // } else {
          //  MessageBox.alert("소득세수동계산", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
        //    return;
       // }
         
   // }   
//  })); 
 // cpGridPayr0307.addButton( new Button("신규", new SelectionListener<ButtonEvent>() {   
  //    @Override  
  //    public void componentSelected(ButtonEvent ce) {   
    	  
    //	   setListRecord(null);
//         BaseModel bm = new BaseModel();
//         
//         bm = payr0307GridPanel.getTableDef().getDefaultValues();
//         RowEditor rowEdit = new RowEditor();
//         
//         /**================================================================================= 
//         //인서트시 초기셋팅부분 .
//         ====================================================================================*/ 
//         bm.set("dpobCd", MSFMainApp.get().getUser().getDpobCd() );
//         bm.set("pymtYrMnth", pymtYrMnth.getValue());
//         bm.set("systemkey",systemkey.getValue() );
//         bm.set("payCd", payCd.getValue());
//         bm.set("payrMangDeptCd",payrMangDeptCd.getValue() );
//         bm.set("payrSeilNum", payrSeilNum.getValue());
//         bm.set("mnthPayAdmntSeilNum", 0);
//         bm.set("payItemCd", new BaseModel());
//         /**================================================================================= 
//         //인서트시 초기셋팅부분 .
//         ====================================================================================*/ 
//          
//          for (int i=0;i < payr0307GridPanel.getGrid().getPlugins().size();i++) {
//              if (payr0307GridPanel.getGrid().getPlugins().get(i) instanceof RowEditor) {
//                  rowEdit = (RowEditor)payr0307GridPanel.getGrid().getPlugins().get(i);
//                  rowEdit.stopEditing(false);  
//                  payr0307GridPanel.getGrid().getStore().insert(bm, 0);  
//                  rowEdit.startEditing(payr0307GridPanel.getGrid().getStore().indexOf(bm), true);  
//                  break;
//              }
//          }
         
      //    if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
      //        MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
       //       return;
      //    }
         
      //    fnPopupCommP500();  
       
    //  }   
   // }));
  
 // cpGridPayr0307.addButton(  new Button("저장", new SelectionListener<ButtonEvent>() {   
    

	//@Override  
   // public void componentSelected(ButtonEvent ce) {   
       
    //    if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
     //       MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
     //       return;
     //   } 
        

      //  MessageBox.confirm("조정저장", "급여조정내역을 저장하면 자동으로 소득세가 계산됩니다. \n 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
        //    @Override
       //     public void handleEvent(MessageBoxEvent be) {
                //if("Yes".equals(be.getButtonClicked().getText())){
          //  	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

                    
            //    	 setListRecord(payr0307GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());  
                     
             //        if (MSFSharedUtils.paramNull(getListRecord()) || !getListRecord().hasNext()) {
              //       	List<Record>  lsRec  = new ArrayList<Record>();
                //     	for ( int i = 0; i < payr0307GridPanel.getMsfGrid().getStore().getCount(); i++){
             //			  if(payr0307GridPanel.getMsfGrid().getStore().getRecord(payr0307GridPanel.getMsfGrid().getStore().getAt(i)).isDirty()){ //변경된 로우가 있을경우
             		//		    BaseModel bm = payr0307GridPanel.getMsfGrid().getStore().getAt(i); 
             	//			    lsRec.add(payr0307GridPanel.getMsfGrid().getStore().getRecord(bm));
             		//	  }
             	//		}
                     	
                 //    	setListRecord(lsRec.iterator()); 
                     	
                //     }
                     
                     
                //     doAction(actionDatabase); 
                        
              //  }
         //   }
     //   });   
      
       
         
   // }   
 // })); 
  
 // cpGridPayr0307.addButton(  new Button("삭제", new SelectionListener<ButtonEvent>() {   
   //     @Override  
   //     public void componentSelected(ButtonEvent ce) {   
            
      //      if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
        //        MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
        //        return;
        //    }
           
            
         //   MessageBox.confirm("조정삭제", "급여조정내역을 삭제하면 자동으로 소득세가 계산됩니다. \n 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
             //   @Override
             //   public void handleEvent(MessageBoxEvent be) {
                  //  if("Yes".equals(be.getButtonClicked().getText())){
             //   	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

                        
              //          Iterator<BaseModel> itBm  = payr0307GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
                        
              //          List<Record>  lsRec  = new ArrayList<Record>();
                        
               //         while(itBm.hasNext()) {

                 //           Record rec  = new Record(itBm.next()); 
                  //          lsRec.add(rec);
                            
                  //      } 
                    //     setListRecord(lsRec.iterator()); 
                    //      
                     //    actionDatabase = ActionDatabase.DELETE;
                     //    doAction(actionDatabase);
                          
                            
                //    }
            //    }
          //  });   
            
      //  }   
    //  }));  
   
 // lcTabFormLayer.add(cpGridPayr0307); 
    
   //    return lcTabFormLayer;
//} 

  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 

    private void leftPayr0304Detail(BaseModel selRecord) {
    	 
    	
    	 dpobCd.setValue((String)selRecord.get("dpobCd"));  //사업장코드
     	 systemkey.setValue((String)selRecord.get("systemkey"));    /** column SYSTEMKEY : systemkey */
    	 pymtYrMnth.setValue((String)selRecord.get("pymtYrMnth"));   /** column 지급년월 : pymtYrMnth */
    	 payCd.setValue((String)selRecord.get("payCd")) ;  /** column 급여구분코드 : payCd */
    	 payrMangDeptCd.setValue((String)selRecord.get("payrMangDeptCd"));   /** column 단위기관코드 : payrMangDeptCd */
    	 payrSeilNum.setValue((Long)selRecord.get("payrSeilNum"));   /** column 급여일련번호 : payrSeilNum */
    	 emymtDivCd.setValue((String)selRecord.get("emymtDivCd"));   /** column 고용구분코드 : emymtDivCd */
     	 hanNm.setValue((String)selRecord.get("hanNm")) ;  /** column 한글성명 : hanNm */
    	 resnRegnNum.setValue((String)selRecord.get("resnRegnNum"));   /** column 주민등록번호 : resnRegnNum */
    	 
    	 secRegnNum.setValue((String)selRecord.get("secRegnNum"));   /** column 주민등록번호 : secRegnNum */
    	 
    	 deptCd.setValue((String)selRecord.get("deptCd")) ;  /** column 부서코드 : deptCd */
    	 deptNm.setValue((String)selRecord.get("deptNm")) ;  /** column 부서 : deptNm */
    	 businCd.setValue((String)selRecord.get("businCd"));   /** column 사업코드 : businCd */
    	 typOccuNm.setValue((String)selRecord.get("typOccuNm")) ;
    	 if (MSFSharedUtils.paramNull(typOccuNm.getValue())) {
    	//	 businNm.setFieldLabel("사업");
    		 businNm.setValue((String)selRecord.get("businNm"));   /** column 사업코드 : businNm */ 
    	 } else {
    		// businNm.setFieldLabel("직종");
    		 businNm.setValue((String)selRecord.get("dtilOccuClsDivNm")) ;  /** column 직종코드 : typOccuNm */
    	 }
    	 typOccuCd.setValue((String)selRecord.get("typOccuCd"));   /** column 직종코드 : typOccuCd */ 
    	 logSvcYrNumCd.setValue((String)selRecord.get("logSvcYrNumCd")) ;  /** column 근속년수코드 : logSvcYrNumCd */
    	 logSvcYrNumNm.setValue((String)selRecord.get("logSvcYrNumNm")) ;  /** column 근속년수 : logSvcYrNumNm */
    	 pymtTotAmnt.setValue((Long)selRecord.get("pymtTotAmnt"));   /** column 지급총액 : pymtTotAmnt */
    	 extpyTotAmnt.setValue((Long)selRecord.get("extpyTotAmnt")) ;  /** column 수당총액 : extpyTotAmnt */
    	 txtnTotAmnt.setValue((Long)selRecord.get("txtnTotAmnt"));   /** column 과세총액 : txtnTotAmnt */
    	 freeDtyTotAmnt.setValue((Long)selRecord.get("freeDtyTotAmnt"));   /** column 비과세총액 : freeDtyTotAmnt */
    	 dducTotAmnt.setValue((Long)selRecord.get("dducTotAmnt"));   /** column 공제총액 : dducTotAmnt */
    	 txTotAmnt.setValue((Long)selRecord.get("txTotAmnt"));   /** column 세금총액 : txTotAmnt */
    	 pernPymtSum.setValue((Long)selRecord.get("pernPymtSum")) ;  /** column 차인지급액 : pernPymtSum */
    	 bnkCd.setValue((String)selRecord.get("bnkCd"));   /** column 은행코드 : bnkCd */
    	 bnkNm.setValue((String)selRecord.get("bnkNm")) ;  /** column 은행코드 : bnkNm */
    	 bnkAccuNum.setValue((String)selRecord.get("bnkAccuNum")) ;  /** column 은행계좌번호 : bnkAccuNum */
    	 acntHodrNm.setValue((String)selRecord.get("acntHodrNm"));   /** column 예금주명 : acntHodrNm */
    	 payDdlneDt.setValue((String)selRecord.get("payDdlneDt")) ;  /** column 급여마감일자 : payDdlneDt */
    	 payDdlneYn.setValue((String)selRecord.get("payDdlneYn")) ;  /** column 급여마감여부 : payDdlneYn */
    	 pymtB10100Sum.setValue((Long)selRecord.get("pymtB10100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 기본급 : pymtB10100Sum */
         pymtT10100Sum.setValue((Long)selRecord.get("pymtT10100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 소득세 : pymtT10100Sum */
         pymtT20100Sum.setValue((Long)selRecord.get("pymtT20100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 주민세  : pymtT20100Sum */
    	
    }
    
    //일괄정리 추가2 6.19 -"121"
    //일괄정리 주석처리 6.22 -"132"
    
    
	public void reloadPayr4200() { //0304패널을 0302로 바꾸고 p420001에서 조회부분을 참고해 추가 6.17 -"40"
								   //다시 0304로 바꾸고 급여내역조회부분을 참고해 추가 6.18 -"70" war만들기7
			// TODO Auto-generated method stub
	        subformInit();
			IColumnFilter filters = null;
			payr0304GridPanel.getTableDef().setTableColumnFilters(filters);
			
			//검색조건 값들 추가 6.19 -"84"
			//지급년월
			payr0304GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
			//급여구분
			payr0304GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//단위기관
			payr0304GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			//고용구분
			payr0304GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//호봉제
			payr0304GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			//관리부서
			payr0304GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			//부서
			String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			payr0304GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
			//그룹
			//주석처리해봄 6.19 -"89"
			/*String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
            payr0304GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);*/
			//직종
			String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
			payr0304GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);  
			//직종세
			String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
			payr0304GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
			//사업
			payr0304GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//지급공제구분
			payr0304GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//지급공제항목
			payr0304GridPanel.getTableDef().addColumnFilter("payItemCd", MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			
			
			//확인위해 주석처리함 6.18 -"83"
			/*//호봉제 추가 6.18 -"76"
			payr0304GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			//관리부서 추가 6.18 -"77"
			payr0304GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);*/
			
			/*payr0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); */
			
			
			//payItemCd은 이름을 바꿀수 있는지, hanNm은 검색조건에서 필요없으니 뺄곳 찾기 6.18 -"78"
			/*payr0304GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); */
			/*payr0304GridPanel.getTableDef().addColumnFilter("payItemCd", MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);*/ 
			
			
			
			
			/*컬럼에 없어서 일단 주석처리 6.18 -"64" war만들기8*/
			/*payr0304GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);*/
			
			//추가부분 6.17 -"41"
			
			
			//필요없는 부분은 주석처리함 6.17 -"42"
			/*//20180305추가 
			payr0302ExtpyGridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0302ExtpyGridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
            payr0304GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
			//payr0304GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0304GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0304GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd") , SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0304GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0302ExtpyGridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);*/   
			
			payr0304GridPanel.reload();
			
			actionDatabase = ActionDatabase.UPDATE;
		}

	//폼초기화 검색조건포함 
	
	   private void formInit() {
		   
		   //검색조건내부 콤보박스도 초기화함 6.19 -"130"
		   srhPayMonth.clear();
		   srhPayCd.clear();
		   srhPayrMangDeptCd.clear();
		   srhEmymtDivCd.clear();
		   srhRepbtyBusinDivCd.clear();
		   srhMangeDeptCd.clear();
		   srhDeptCd.clear();
		   srhDeptGpCd.clear();
		   srhTypOccuCd.clear();
		   srhDtilOccuInttnCd.clear();
		   srhBusinCd.clear();
		   srhPymtDducDivCd.clear();
		   srhPayDducExtpyCd.clear();
		   
		   //검색조건초기화 추가 6.19 -"112" war만들기11
		   /*createSearchForm();*/ //이거 넣으면 검색조건바꿔도 값이 없는걸로 처리됨, subformInit은 정상작동함 6.19 -"113"
		   subformInit();
		   
		   //초기화 위해 주석처리 6.19 -"111"
		   /*actionDatabase = ActionDatabase.UPDATE;*/
		   
	   }
	   
	   private void subformInit() {
		  
		   payr0304GridPanel.getMsfGrid().clearData();
		   
	   }
	   
	      /**
        * 지급공제선택 
        */
      private void fnPopupCommP500() {
          //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
          //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
          //검색.처리하면됨.
    	  PrgmComP0500DTO sysComP0500Dto = new PrgmComP0500DTO();
          //지급공제구분코드 넘김.
          MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpPrgmCom0500Form(sysComP0500Dto);  //인사  
          
          final FormBinding popBindingCom0500 = popCom0500.getFormBinding();
         
          popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
              public void handleEvent(BaseEvent be) {
                 
                  List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
                  
                  if (mapModels != null) { 
                        
                      if (mapModels.size() > 1) {
                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                               "한건의 데이타만 선택가능합니다. 데이타를 확인하십시요.", null);
                          return;
                      }
                      
                      //payr0307GridPanel.getMsfGrid().clearData();
                      BaseModel bmData = payr0307GridPanel.getMsfGrid().getTableDef().getDefaultValues(); 
                 
                      Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
                      while (iterRecords.hasNext()) {
                            BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
                           
                            bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */ 
                            bmData.set("payrMangDeptCd",payrMangDeptCd.getValue());    /** column null : payrMangDeptCd */
                            bmData.set("payrSeilNum",payrSeilNum.getValue());    /** column null : payrSeilNum */
                            bmData.set("mnthPayAdmntSeilNum",0L);    /** column null : mnthPayAdmntSeilNum */
                            bmData.set("pymtYrMnth",pymtYrMnth.getValue());    /** column null : pymtYrMnth */
                            bmData.set("payCd$commCd",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column null : payCd */
                            bmData.set("payCd$commCdNm",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCdNm"));    /** column null : payCd */
                          //  bmData.set("payCd",lsPayCd.getAt(0));    /** column null : payCd */
                            bmData.set("systemkey",systemkey.getValue());    /** column systemKey : systemkey */
                            bmData.set("payItemCd",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));       /** column 급여항목코드 : payItemCd */ 
                            bmData.set("payItemNm",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));      /** column 급여항목코드 : payItemNm */
                            bmData.set("pymtDducDivCd$commCd",MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column null : pymtDducDivCd */
                            bmData.set("pymtDducDivCd$commCdNm",MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivNm")));    /** column null : pymtDducDivCd */
                            bmData.set("pymtDducFreeDtySum",0L);    /** column null : pymtDducFreeDtySum */
                            bmData.set("pymtDducTxtnAmnt",0L);      /** pymtDducTxtnAmnt */
                            
                            bmData.set("pymtDducSum",(Long)bmMapModel.get("payExtpySum"));    /** column null : pymtDducSum */
                            bmData.set("mnthPayAdmntAssoBssCtnt","");    /** column null : mnthPayAdmntAssoBssCtnt */
                            bmData.set("mnthPayAdmntYn",false);    /** column null : mnthPayAdmntYn */
//                            bmData.set("kybdr",);    /** column null : kybdr */
//                            bmData.set("inptDt",);    /** column null : inptDt */
//                            bmData.set("inptAddr",);    /** column null : inptAddr */
//                            bmData.set("ismt",);    /** column null : ismt */
//                            bmData.set("revnDt",);    /** column null : revnDt */
//                            bmData.set("revnAddr",);    /** column null : revnAddr */ 
                              
                      }  
                        
                     
                      payr0307GridPanel.getMsfGrid().getGrid().stopEditing();      
                      payr0307GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
                      payr0307GridPanel.getMsfGrid().getGrid().startEditing(payr0307GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 4);   
                     // payr0307GridPanel.getMsfGrid().getGrid().getStore().getAt(0).set("mnthPayAdmntAssoBssCtnt"," ");
                     // payr0307GridPanel.getMsfGrid().getGrid().getStore().update(payr0307GridPanel.getMsfGrid().getGrid().getStore().getAt(0));
                      payr0307GridPanel.getMsfGrid().getGrid().getStore().getRecord(payr0307GridPanel.getMsfGrid().getGrid().getStore().getAt(0)).setDirty(true);
                      //payr0307GridPanel.setSize(610, (145 - (cpGridPayr0307.getButtonBar().getHeight() + 10)));
                       
                      actionDatabase = ActionDatabase.INSERT; 
                  }  
                   
                  
              }
          });
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

	private Payr4201 getThis() { //4200복사 후 4201로 변경 6.16 -"4"
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
	   
	   
	    
	//엑셀저장함수 
	public void exportExcel() {
		// TODO Auto-generated method stub
		// payr0301GridPanel.callExportServlet("");
	        HashMap<String, String> param = new HashMap<String, String>(); 
	        
	        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	        
	        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
	        param.put("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        
	        param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
	        param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
	        
	        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
	        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
	        param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
	        param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
	       // param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	        param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
	        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
	        param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
	        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
	        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

	        //넘어온메서드 값을 가지고 처리 한다.  
	       // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
	        GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPayr4200Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	          
	        
	        // TODO 기간제면 XLS_PAYR4200 템플릿 으로 개발한다.
	        
	} 
	
	public void exportExcel2() {
		// TODO Auto-generated method stub
		// payr0301GridPanel.callExportServlet("");
	        HashMap<String, String> param = new HashMap<String, String>(); 

			systemKeys = new String();
			systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = payr0304GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
	        param.put("payYr", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"))); 
	        
	        param.put("deptNm", MSFSharedUtils.allowNulls(srhDeptCd.getValue())); 
	        
	        param.put("payMonth", (MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        
	        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
	        param.put("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        
	        param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
	        param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
	        
	        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
	        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
	        param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
	        param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
	       // param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	        param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
	        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
			param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
	        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
	        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

	        //넘어온메서드 값을 가지고 처리 한다.  
	       // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
	        //GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPayr4200Export2.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	        payr0304GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr4200Export2.do","extgwtFrame" ,param);
	        
	        // TODO 기간제면 XLS_PAYR4200 템플릿 으로 개발한다.
	        
	} 

	// 급여에 대한 합계로 출력
	public void exportTotExcel() {
	        // TODO Auto-generated method stub
	        // payr0301GridPanel.callExportServlet("");
	        HashMap<String, String> param = new HashMap<String, String>(); 
	        
	        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	        
	        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
	        param.put("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
	        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        
	        param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
	        param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
	        
	        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
	        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
	        param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
	        param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
	        //param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	        param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
	        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
	        param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
	        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
	        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

	        //넘어온메서드 값을 가지고 처리 한다.  
	       // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
	        GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPayr4200TotExport.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	          
	}
	    
	//엑셀 양식 저장
	private void xlsExportData() {
			                    
		HashMap<String, String> param = new HashMap<String, String>(); 
			   
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
		
       // if("".equals(MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd ,"commCd"))) {
       //  	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"지급공제항목을 선택해주세요.", null);
       //	return;
       // }
		
        
        param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
        param.put("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
        
        param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
        param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
        
        param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
        param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
        param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
        param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
        //param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
        param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
        param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
        param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
        param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  
        
      //  param.put("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd ,"commCd"));
      //  param.put("payDducExtpyCd", MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd ,"commCd"));
        

        
			                     
        payr0304GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsJxlsPayr4200Export.do","extgwtFrame", param);   
	}
	
	//급여일괄조정 업로드
	private void xlsImportData() { 
			MessageBox.confirm("일괄 조정", "급여 내역을 일괄조정을 하시겠습니까?<br>(등록되어있는 조정내역이 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
		      	@Override
		    	public void handleEvent(MessageBoxEvent be) {
		      	//	if("Yes".equals(be.getButtonClicked().getText())){
		      		//if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      			
		      			HashMap<String, String> param = new HashMap<String, String>();
		      			
		      			// only accept certain files 
		      			String strDpobCd = MSFMainApp.get().getUser().getDpobCd();
		            	String strPymtYrMnth = MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month");
			            String strPayrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");   
			            
			            String strMangeDeptCd =  MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd");   
			             
			            
			            String strEmymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
			            String strPayCd = MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"); 
			            String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
			            String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");  
			            String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			            String strBusinCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");  
			            String strSystemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue()); 
			            String strHanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue()); 
			            String strResnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
		                  
		            	if("".equals(MSFSharedUtils.allowNulls(strPymtYrMnth))){
		            		MessageBox.info("", "지급년월은 필수 입니다.", null);
		             	} else  if (MSFConfiguration.EMYMT_DIVCD02.equals(strEmymtDivCd)) {
		              		if("".equals(strBusinCd)){
		              			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
		            	} else {
		            			//get the filename to be uploaded
		                      	String filename = MSFSharedUtils.allowNulls(payr4200flUp.getValue());
		                      	if (filename.length() == 0) {
		                      		Window.alert("선택된 파일이 없습니다.");
		                      	} else {
		                      		//submit the form
		                            plFrmPayr4200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
		                            
		                            //파일업로드 처리
		                            plFrmPayr4200.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadPayr4200Import.do");
		                        	plFrmPayr4200.setEncoding(Encoding.MULTIPART);
		                        	plFrmPayr4200.setMethod(Method.POST);   
		                        	plFrmPayr4200.submit();  
		                          	plFrmPayr4200.onFrameLoad();  
		                        	picBoolFile = true;
		                      	}               
		                      	// reset and unmask the form 
		                      	// after file upload 
		                      	plFrmPayr4200.addListener(Events.Submit, new Listener<FormEvent>() {
		                      		public void handleEvent(FormEvent evt) {   
		                      			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
		                      				//업로드가  성공했으면 인서트 모듈을 태운다. 
		                                	plFrmPayr4200.unmask();  
//		                                   	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
		                                  	picBoolFile = false;
		                                  	evt.setResultHtml("");
		                              	} else {
		                              		if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
		                              			//업로드가  성공했으면 인서트 모듈을 태운다.
		                              			MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
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
		              	}else{ 
		              		//get the filename to be uploaded
		              		String filename = MSFSharedUtils.allowNulls(payr4200flUp.getValue());
		              		if (filename.length() == 0) {
		              			Window.alert("선택된 파일이 없습니다.");
		                	} else {
		                		//submit the form
		                		plFrmPayr4200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
		                		//파일업로드 처리
		                		
		                		plFrmPayr4200.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadPayr4200Import.do");
		                    	plFrmPayr4200.setEncoding(Encoding.MULTIPART);
		                    	plFrmPayr4200.setMethod(Method.POST);   
		                    	plFrmPayr4200.submit();  
		                    	plFrmPayr4200.onFrameLoad();  
		                    	picBoolFile = true;
		                	}               
		                       
		                    // reset and unmask the form 
		                    // after file upload 
		                	plFrmPayr4200.addListener(Events.Submit, new Listener<FormEvent>() {
		                		public void handleEvent(FormEvent evt) {   
		                			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
		                				//업로드가  성공했으면 인서트 모듈을 태운다. 
		                            	plFrmPayr4200.unmask();  
//		                             	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
		                                picBoolFile = false;
		                                evt.setResultHtml("");
		                			} else {
		                				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
		                					//업로드가  성공했으면 인서트 모듈을 태운다.
		                                    MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
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
