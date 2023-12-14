package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0304DTO;
import com.app.exterms.payroll.client.dto.Payr0485DTO;
import com.app.exterms.payroll.client.form.defs.Payr0304Def;
import com.app.exterms.payroll.client.form.defs.Payr0470Def;
import com.app.exterms.payroll.client.form.defs.Payr0485Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr1450Service;
import com.app.exterms.payroll.client.service.Payr1450ServiceAsync;
import com.app.exterms.payroll.client.service.Payr4200Service;
import com.app.exterms.payroll.client.service.Payr4200ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0470DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style;
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
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
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
public class Payr1450  extends MSFPanel { 
 

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
	private Payr1450ServiceAsync payr1450Service = Payr1450Service.Util.getInstance();
	private VerticalPanel vp;
	private FormPanel plFrmPayr1450;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
		
	//급여대상자정보 
	private Payr0304Def payr0304Def  = new Payr0304Def("PAYR4200");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0304GridPanel;
	  
//	//수당 
//	private Payr0302Def payr0302ExtpyDef  = new Payr0302Def("PAYR4200EXTPY");   //그리드 테이블 컬럼 define  
//	// private MSFCustomForm msfCustomForm; 
//	private MSFGridPanel payr0302ExtpyGridPanel; 
//	  
//	//공제 
//	private Payr0302Def payr0302DducDef  = new Payr0302Def("PAYR4200DDUC");   //그리드 테이블 컬럼 define  
//	// private MSFCustomForm msfCustomForm; 
//	private MSFGridPanel payr0302DducGridPanel;
	
	//지급공제 _ 지급공제항목출력관리
	private Payr0470Def payr0470ducDef  = new Payr0470Def("PAYR1450");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0470DducGridPanel;
	
	//수당그룹 _ 지급공제항목출력관리
//	private Payr0480Def payr0480ExtpyDef  = new Payr0480Def();   //그리드 테이블 컬럼 define  
	
	//출력항목
	private Payr0485Def payr0485ExtpyDef = new Payr0485Def("PAYR1450");	//그리드 테이블 컬럼 define  
	
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0485ExtpyGridPanel; 
  
	// 지급년도
	private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();
	private MSFGridPanel payYrGridPanel;
      
 

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 상태처리 전역변수 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		private ActionDatabase actionDatabase;
//		private ContentPanel cpGridPayr0307;
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
		private ButtonBar topPayr1450Bar;
		private Button btnPayr4200Init;
		private Button btnPayr4200Del;
		private Button btnPayr1450Sreach;
		private Button btnPayr4200Print;
		private Button btnPayr1450Excel;
		private Button saveButton;
		private ButtonBar saveButtonBar;
		private Button UpdateSaveButton;
		private Button btnSelectPayr0145;
		private Button btnUnSelectPayr0145;
		private MSFGridPanel msfGdSysIfPayr0145Btm;
		
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
		
		/** column 급여공제그룹코드 : payDducGrpCd */
	      private ComboBox<BaseModel> srhPayDducGrpCd;   //급여공제그룹코드
	      /** column 급여공제명 : payDducNm */
	      
		private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	
		private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	
		private ComboBox<BaseModel> srhBusinCd; 				// 사업
		private TextField<String> srhHanNm; 					// 성명
		private TextField<String> srhResnRegnNum; 				// 주민번호
		private HiddenField<String> srhSystemkey; 				// 시스템키
      
		private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
//		private MSFMultiComboBox<ModelData> srhPymtDducDivCd1;	/** column 지급공제구분코드 : pymtDducDivCd */
//		private MSFMultiComboBox<ModelData> srhPymtDducDivCd2;	/** column 지급공제구분코드 : pymtDducDivCd */
		private ComboBox<BaseModel> srhPymtDducDivCd1;	/** column 지급공제구분코드 : pymtDducDivCd */
		private ComboBox<BaseModel> srhPymtDducDivCd2;	/** column 지급공제구분코드 : pymtDducDivCd */
		private MSFMultiComboBox<ModelData> srhPayExtpyGrpCd;	/** column 수당그룹구분코드 : ExpnAdmclExtpyDivCd */
		private ComboBox<BaseModel> srhPayDducExtpyCd;
		private ComboBox<BaseModel> srhSpciType;	/** column 기부금유형 : pymtDducDivCd */
	
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
		private List<ModelData> mDtalistDtilPayExtpyGrpCd;
		private List<ModelData> mDtalistDtilPymtDducDivCd1;
		private List<ModelData> mDtalistDtilPymtDducDivCd2;
      
		private FileUploadField payr4200flUp; // 파일업로드처리 부분
		private Boolean picBoolFile;
	
		private boolean mutilCombo = false;
		private String systemKeys;
		
		private CheckBox retryClutYn;					// 퇴직정산여부
		private CheckBox shttmInsnYn;  					// 기간제출력여부
		private CheckBox dpobFndtnUseYn;				// 기본사용여부
		private CheckBox displayYn;						// 출력여부
		
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
      	
		private TextField<String> payItemCd;       /** column 항목코드 : payItemCd */  	
		private TextField<String> payExtpyNm;      /** column 항목 : payExtpyNm */  	
      
      	private TextField<String> hanNm ;  			/** column 한글성명 : hanNm */
      
      	private TextField<String> resnRegnNum;   	/** column 주민등록번호 : resnRegnNum */
      	private HiddenField<String> secRegnNum;   	/** column 주민등록번호 : secRegnNum */
      
      	private HiddenField<String> deptCd ;  		/** column 부서코드 : deptCd */
      	private TextField<String> deptNm ;  		/** column 부서 : deptNm */

      	private HiddenField<String> businCd;   		/** column 사업코드 : businCd */
      	private TextField<String> businNm;   		/** column 사업코드 : businNm */

      	private HiddenField<String> typOccuCd;   	/** column 직종코드 : typOccuCd */
      	private HiddenField<String> typOccuNm ;  	/** column 직종코드 : typOccuNm */
      
      	private HiddenField<String> logSvcYrNumCd ; /** column 근속년수코드 : logSvcYrNumCd */
      	private TextField<String> logSvcYrNumNm ;  	/** column 근속년수 : logSvcYrNumNm */

      	private NumberField pymtTotAmnt;   			/** column 지급총액 : pymtTotAmnt */
      	private NumberField extpyTotAmnt;  			/** column 수당총액 : extpyTotAmnt */

      	private HiddenField<Long> txtnTotAmnt;   	/** column 과세총액 : txtnTotAmnt */
      	
      	private TextField<String> freeDtyCd;   	/** column 비과세코드 : freeDtyCd */
      	private TextField<String> freeDtyNm;   		/** column 비과세명 : freeDtyNm */
      	
      	private TextField<String> yrtxFreeDtyReduCd;   	/** column 비과세코드 : yrtxFreeDtyReduCd */
      	private TextField<String> yrtxFreeDtyReduNm;   		/** column 비과세명 : yrtxFreeDtyReduNm */
      	
      	private NumberField freeDtyTotAmnt;   		/** column 비과세총액 : freeDtyTotAmnt */
      	private NumberField dducTotAmnt;   			/** column 공제총액 : dducTotAmnt */
      	
      	private TextField<String> accAccNm;			/** column 회계명 : accAccNm */
      	private TextField<String> accAccCd;		/** column 회계코드 : accAccCd */

      	private HiddenField<Long> txTotAmnt;   		/** column 세금총액 : txTotAmnt */
       
      	private NumberField  pernPymtSum;  			/** column 차인지급액 : pernPymtSum */
 
      	private HiddenField<String> bnkCd;   		/** column 은행코드 : bnkCd */
      	private HiddenField<String> bnkNm;  		/** column 은행코드 : bnkNm */
      	private HiddenField<String> bnkAccuNum;  	/** column 은행계좌번호 : bnkAccuNum */
      	private HiddenField<String> acntHodrNm;   	/** column 예금주명 : acntHodrNm */
      	private HiddenField<String> payDdlneDt;  	/** column 급여마감일자 : payDdlneDt */
      	private HiddenField<String> payDdlneYn;  	/** column 급여마감여부 : payDdlneYn */

      	private NumberField  pymtB10100Sum ;     	/** column 기본급 : pymtB10100Sum */
      	private NumberField  pymtT10100Sum ;    	/** column 소득세 : pymtT10100Sum */
      	private NumberField  pymtT20100Sum ;    	/** column 주민세  : pymtT20100Sum */
      	
      	private ComboBox<BaseModel> yrtxDotnNm;		/** column 기부금유형 : yrtxDotnNm */
      	private ComboBox<BaseModel> yrtxDotnCd;		/** column 기부금코드 : yrtxDotnCd */
      	
      	private CheckBox sevePayYn;					// 퇴직정산여부
		private CheckBox payrTermUseYn;  					// 기간제출력여부
		private CheckBox extptDducUseYn;				// 기본사용여부
		private CheckBox extptDducDspyYn;						// 출력여부
      
      	private BaseModel ppRecord; //팝업에 넘길 레코드 값 
        private MSFGridPanel payr0480GridPanel;
        
      //팝업 HiddenField
        private HiddenField<String> accAccKey;		//회계계정 키
        private HiddenField<String> yrtxDontKey;	//기부금유형 키
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
      	private void checkPayr1450Auth(String authAction, ListStore<BaseModel> bm) { 
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
	
      		srhPayYr.setValue(lsPayYrStore.findModel("payYr", DateTimeFormat.getFormat("yyyy").format(new Date())));
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
			// GWTAuthorization.formAuthPopConfig(plFrmPayr1450,
			// "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
			// GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd);
			// gwtAuthorization.formAuthConfig(plFrmPayr1450,
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
	private void setPayr1450FormBinding() {
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
	private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();

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

	private ListStore<BaseModel> lsPymtDducDivCd 		= new ListStore<BaseModel>();	// 지급공제구분코드
	private ListStore<BaseModel> lsExpnAdmclExtpyDivCd 	= new ListStore<BaseModel>();	// 수당그룹
	
	private ListStore<BaseModel> lsPymtDducDivCd1 		= new ListStore<BaseModel>(); 	// 지급공제항목_출력항목 미상세
	private ListStore<BaseModel> lsPymtDducDivCd2 		= new ListStore<BaseModel>(); 	// 지급공제항목_출력항목
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>(); 	// 직종세
	private ListStore<BaseModel> lsYrtxDotnNm 			= new ListStore<BaseModel>(); 	// 기부금항목

	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
	private PrgmComPayr0470DTO sysComPayr0470Dto; // 공제
	private PrgmComPayr0480DTO sysComPayr0480Dto; // 수당
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
			if (ce.getButton() == btnPayr4200Del) {
	                
				MessageBox.confirm("삭제", "선택된 데이타을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						
						//if("Yes".equals(be.getButtonClicked().getText())){ 
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){  	
							Iterator<BaseModel> itBm  = payr0304GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                             
							List<Record>  lsRec  = new ArrayList<Record>();
	                             
	                        while(itBm.hasNext()) {

	                        	Record rec  = new Record(itBm.next()); 
	                        	lsRec.add(rec);
	                                 
	                        } 
	                              
	                             
	                        setListRecordDels(lsRec.iterator()); 
	                              
	                        List<InfcPkgPayr0304DTO> listInfcPayr0304Dto = new ArrayList<InfcPkgPayr0304DTO>();  
	                             
	                        while (recordDels.hasNext()) {
	                          
	                        	Record record = (Record) recordDels.next(); 
	                        	BaseModel bmMapModel = (BaseModel)record.getModel();
	                                  
	                              
	                           
	                            InfcPkgPayr0304DTO payr0304Dto = new InfcPkgPayr0304DTO(); 
                                
                                payr0304Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    				/** column 사업장코드 : dpobCd */
                                payr0304Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(record.get("pymtYrMnth")));			/** column 지급년월 : pymtYrMnth */
                                payr0304Dto.setSystemkey(MSFSharedUtils.allowNulls(record.get("systemkey")));			/** column SYSTEMKEY : systemkey */
                                payr0304Dto.setPayCd(MSFSharedUtils.allowNulls(record.get("payCd")));    				/** column 급여구분코드 : payCd */
                                payr0304Dto.setPayrSeilNum((Long)record.get("payrSeilNum"));    						/** column 급여일련번호 : payrSeilNum */
                                payr0304Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(record.get("payrMangDeptCd")));	/** column 급여관리부서코드 : payrMangDeptCd */
                                payr0304Dto.setPayCd(MSFSharedUtils.allowNulls(record.get("payCd")));    				/** column 급여구분코드 : payCd */
                                payr0304Dto.setPayrSeilNum((Long)record.get("payrSeilNum"));    						/** column 급여일련번호 : payrSeilNum */
//                                payr0304Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(record.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
//                                payr0304Dto.setHanNm(MSFSharedUtils.allowNulls(record.get("hanNm")));    /** column 한글성명 : hanNm */
//                                payr0304Dto.setResnRegnNum(MSFSharedUtils.allowNulls(record.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
//                                payr0304Dto.setDeptCd(MSFSharedUtils.allowNulls(record.get("deptCd")));    /** column 부서코드 : deptCd */
//                                payr0304Dto.setBusinCd(MSFSharedUtils.allowNulls(record.get("businCd")));    /** column 사업코드 : businCd */
//                                payr0304Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//                                payr0304Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd")));    /** column 직종세구분코드 : dtilOccuInttnCd */
//                                payr0304Dto.setOdtyCd(MSFSharedUtils.allowNulls(record.get("odtyCd")));    /** column 직책코드 : odtyCd */
//                                payr0304Dto.setPyspCd(MSFSharedUtils.allowNulls(record.get("pyspCd")));    /** column 호봉코드 : pyspCd */
//                                payr0304Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//                                payr0304Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(record.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
//                                payr0304Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(record.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
//                                payr0304Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(record.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
//                                payr0304Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(record.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
//                                payr0304Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(record.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
//                                payr0304Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(record.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
//                                payr0304Dto.setRetryDt(MSFSharedUtils.allowNulls(record.get("retryDt")));    /** column 퇴직일자 : retryDt */
//                                payr0304Dto.setLogSvcStdDt(MSFSharedUtils.allowNulls(record.get("logSvcStdDt")));    /** column 근속기준일자 : logSvcStdDt */
//                                payr0304Dto.setSpueYn(MSFSharedUtils.allowNulls(record.get("spueYn")));    /** column 배우자유무 : spueYn */
//                                payr0304Dto.setSuprtFamyNumTwenChDn(MSFSharedUtils.allowNulls(record.get("suprtFamyNumTwenChDn")));    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
//                                payr0304Dto.setSuprtFamyNumTreOvrChdn(MSFSharedUtils.allowNulls(record.get("suprtFamyNumTreOvrChdn")));    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
//                                payr0304Dto.setSuprtFamyNumEtc(MSFSharedUtils.allowNulls(record.get("suprtFamyNumEtc")));    /** column 부양가족수_기타 : suprtFamyNumEtc */
//                                payr0304Dto.setSuprtFamy3ChdnExtpySum(MSFSharedUtils.allowNulls(record.get("suprtFamy3ChdnExtpySum")));    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//                                payr0304Dto.setChdnSchlExpnAdmclYn(MSFSharedUtils.allowNulls(record.get("chdnSchlExpnAdmclYn")));    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
//                                payr0304Dto.setHlthInsrGrde(MSFSharedUtils.allowNulls(record.get("hlthInsrGrde")));    /** column 건강보험등급 : hlthInsrGrde */
//                                payr0304Dto.setNatPennGrde(MSFSharedUtils.allowNulls(record.get("natPennGrde")));    /** column 국민연금등급 : natPennGrde */
//                                payr0304Dto.setMnthPayDlywagSum(MSFSharedUtils.allowNulls(record.get("mnthPayDlywagSum")));    /** column 월급여일당금액 : mnthPayDlywagSum */
//                                payr0304Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
//                                payr0304Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
//                                payr0304Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                                payr0304Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
//                                payr0304Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
//                                payr0304Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */ 
	                             
                                listInfcPayr0304Dto.add(payr0304Dto);
	                        }
	                        
	                        payr4200Service.deletePayr4200(listInfcPayr0304Dto,ActionDatabase.DELETE, new AsyncCallback<Long>() {
	                        	public void onFailure(Throwable caught) {
	                        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("deletePayr4200(delete) : " + caught), null);
	                        	}
	                                  
	                        	@Override
	                            public void onSuccess(Long result) { 
	                        		if (result == 0) {
	                        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                        		} else {
	                        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "삭제 처리가 완료되었습니다.", null);
	                        			reload(); 
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
			this.actionDatabase = ActionDatabase.INSERT;
//			savePayr4200();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			savePayr0485();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
//			savePayr4200();
			break;
		}
	}
	     

	private void savePayr0485() { 
        
		final Payr0485DTO payr0485Dto = new Payr0485DTO();
		
		
		
		payr0485Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));												/** column 사업장코드 : dpobCd */
		payr0485Dto.setEmymtDivCd(emymtDivCd.getValue());
		payr0485Dto.setPayItemCd(MSFSharedUtils.allowNulls(payItemCd.getValue()));											/** column 급여공제항목코드 : payItemCd */
		payr0485Dto.setYrtxFreeDtyReduCd(MSFSharedUtils.allowNulls(yrtxFreeDtyReduCd.getValue()));							/** column 비과세감면코드 : yrtxFreeDtyReduCd */
		payr0485Dto.setAccAccCd(MSFSharedUtils.allowNulls(accAccCd.getValue()));											/** column 회계계정코드 : accAccCd */
		payr0485Dto.setSevePayYn(MSFSharedUtils.allowNulls(PayrUtils.getCheckedCheckBoxYnValue(sevePayYn))); 				/** column 퇴직정산포함 : sevePayYn */
		payr0485Dto.setPayrTermUseYn(MSFSharedUtils.allowNulls(PayrUtils.getCheckedCheckBoxYnValue(payrTermUseYn)));  		/** column 기간제출력 : payrTermUseYn */
		payr0485Dto.setYrtxDotnCd(MSFSharedUtils.allowNulls(PayrUtils.getSelectedComboValue(yrtxDotnCd)));  				/** column 기부금유형 : yrtxDotnCd */
		payr0485Dto.setExtptDducDspyYn(MSFSharedUtils.allowNulls(PayrUtils.getCheckedCheckBoxYnValue(extptDducDspyYn)));	/** column 화면출력 : extptDducDspyYn */
		payr0485Dto.setExtptDducUseYn(MSFSharedUtils.allowNulls(PayrUtils.getCheckedCheckBoxYnValue(extptDducUseYn)));		/** column 사용여부 : extptDducUseYn */
		
		updatePayr0485(payr0485Dto);
		
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
				
				String year	 = PayrUtils.getSelectedComboValue(srhPayYr,	"payYr");
				String month = PayrUtils.getSelectedComboValue(srhPayMonth,	"month");
				
				String pymtYrMnth	   = year+month;
				String payCd		   = PayrUtils.getSelectedComboValue(srhPayCd, "commCd");
		 		String payrMangDeptCd  = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
				String emymtDivCd	   = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");
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
					System.out.println("시스템키는 넘기지 않고 검색조건만 넘김");
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
					serarchParam += "" + pymtYrMnth															+ "⊥";	/*$21 년월						*/
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
			createPayr1450Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createStandardForm(); 	// 기본정보필드
			vp.setSize("1010px", "700px");
	 
//			/**
//			 * TODO 급여대상자에 따른 수당,공제,급여조정부분을 자동으로 불러오는 부분을 추가 한다...단계별진행........
//			 * Create the relations
//			 */
//			final RelationDef relPayr0304 = new RelationDef(payr0304Def, false);
//			relPayr0304.addJoinDef("pymtYrMnth", "pymtYrMnth");
//			relPayr0304.addJoinDef("dpobCd", "dpobCd");
//			relPayr0304.addJoinDef("systemkey", "systemkey");
//			relPayr0304.addJoinDef("payCd", "payCd");
//			relPayr0304.addJoinDef("payrSeilNum", "payrSeilNum");
//			relPayr0304.setLinkedObject(payr0304GridPanel);
//			payr0302ExtpyDef.addRelation(relPayr0304);
//  
//			// DETAILS
//			final Grid payr0304Grid = payr0304GridPanel.getMsfGrid().getGrid();
//			payr0304Grid.addListener(Events.RowDoubleClick,
//					new Listener<BaseEvent>() {
//						public void handleEvent(BaseEvent be) {
//							if (.getCurrentlySelectedItem() != null) {
//
//								// 선택된 값을 우측 그리드에 넣기 위한 메서드 호출
//								leftPayr0304Detail(payr0304GridPanel
//										.getCurrentlySelectedItem());
//
//								payr0302ExtpyDef.synchronizeGridDetail(
//										payr0304GridPanel
//												.getCurrentlySelectedItem(),
//										payr0302ExtpyGridPanel);
//
//								// payr0302ExtpyGridPanel.reload();
//							}
//
//							actionDatabase = ActionDatabase.UPDATE;
//						}
//					});
//
//			final RelationDef relPayr030401 = new RelationDef(payr0304Def,
//					false);
//			relPayr030401.addJoinDef("pymtYrMnth", "pymtYrMnth");
//			relPayr030401.addJoinDef("dpobCd", "dpobCd");
//			relPayr030401.addJoinDef("systemkey", "systemkey");
//			relPayr030401.addJoinDef("payCd", "payCd");
//			relPayr030401.addJoinDef("payrSeilNum", "payrSeilNum");
//			relPayr030401.setLinkedObject(payr0304GridPanel);
//			payr0302DducDef.addRelation(relPayr030401);
//
//			// DETAILS
//			final Grid payr0304Grid01 = payr0304GridPanel.getMsfGrid()
//					.getGrid();
//			payr0304Grid01.addListener(Events.RowDoubleClick,
//					new Listener<BaseEvent>() {
//						public void handleEvent(BaseEvent be) {
//							if (payr0304GridPanel.getCurrentlySelectedItem() != null) {
//
//								payr0302DducDef.synchronizeGridDetail(
//										payr0304GridPanel
//												.getCurrentlySelectedItem(),
//										payr0302DducGridPanel);
//
//								// payr0302DducGridPanel.reload();
//
//							}
//						}
//					});

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
	public Payr1450() {

		setSize("1010px", "700px");
	}

	public Payr1450(String txtForm) {
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
	private void createPayr1450Form() {

		plFrmPayr1450 = new FormPanel();
		plFrmPayr1450.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ " 수당공제항목출력설정" );
		// plFrmPayr1450.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여(조정)내역관리");
		plFrmPayr1450.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr1450.setBodyStyleName("pad-text");
		plFrmPayr1450.setPadding(2);
		plFrmPayr1450.setFrame(true);
			
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("수당공제항목출력설정","PAYR1450");
				}
			});
		plFrmPayr1450.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr1450.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmPayr1450.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
	        public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhPayExtpyGrpCd.getCheckBoxListHolder().isVisible() ) {
						srhPayExtpyGrpCd.showClose(ce);
						mutilCombo = false;
					
					} 
//					else if (srhPymtDducDivCd1.getCheckBoxListHolder().isVisible() ) {
//						srhPymtDducDivCd1.showClose(ce);
//						mutilCombo = false;
//					
//					} else if ( srhPymtDducDivCd2.getCheckBoxListHolder().isVisible() ) {
//						srhPymtDducDivCd2.showClose(ce);
//                        mutilCombo = false;
//					}  
				}
	    	} 
		});

		LayoutContainer layoutContainer = new LayoutContainer();
//		layoutContainer.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		topPayr1450Bar = new ButtonBar();
		layoutContainer_2.add(topPayr1450Bar);
		topPayr1450Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
		btnPayr1450Sreach = new Button("조회");
		btnPayr1450Sreach.setIcon(MSFMainApp.ICONS.search16());
		topPayr1450Bar.add(btnPayr1450Sreach);
		btnPayr1450Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if("".equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")) || MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd") == null) {
					MessageBox.alert("오류", "고용구분을 선택해주세요.(필수)", null);
        			return;
				};
				
				// 조회버튼 클릭시 처리
				reload();
			}
		});
		
		btnPayr1450Excel = new Button("엑셀");
		btnPayr1450Excel.setIcon(MSFMainApp.ICONS.excel16()); 
		topPayr1450Bar.add(btnPayr1450Excel);
		btnPayr1450Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});
			  	
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.setBorders(false);

		plFrmPayr1450.add(layoutContainer);

		// 파일업로드 처리
		plFrmPayr1450.setAction("bizform");
		plFrmPayr1450.setEncoding(Encoding.MULTIPART);
		plFrmPayr1450.setMethod(Method.POST);

		vp.add(plFrmPayr1450);
		plFrmPayr1450.setSize("990px", "680px");
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
		sysComPayr0470Dto = new PrgmComPayr0470DTO();
		sysComPayr0480Dto = new PrgmComPayr0480DTO();
		
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
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		//지급공제구분 : 본봉, 수당, 공제, 세금
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("B008");  
		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); 
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("B008");  
		lsPymtDducDivCd1 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); 
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("B008");  
		lsPymtDducDivCd2 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); 
		
		
		//기부금유형 
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("B023");  
		lsYrtxDotnNm = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		
		
		//수당그룹 
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("B025");  
		lsExpnAdmclExtpyDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//lsPayDducExtpyCd = PrgmComComboUtils.getSinglePayr0470ComboData(sysComPayr0470Dto);//지급공제항목
		//lsExpnAdmclExtpyDivCd = PrgmComComboUtils.getSinglePayr0480ComboData(sysComPayr0480Dto);//수당종류
		
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
                     
					}
	  			});
	  		}
		});
	  	  
		payYrGrid.add(payYrGridPanel);
		plFrmPayr1450.add(payYrGrid);

	  
	    plFrmPayr1450.setLayout(new FlowLayout());
	    
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
	    fieldSet.setStyleAttribute("marginTop", "5px");
	   
	   // fieldSet.setCheckboxToggle(false); 
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();
 
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    /****************************************************************
		 * 빈칸FieldSet 시작
		 ****************************************************************/
	    
		FieldSet fieldSet_1 = new FieldSet();  
	    LayoutContainer lcSchCol_1 = new LayoutContainer();
	    //fieldSet_1.setSize(1000, 20);
	    lcSchCol_1.setLayout(new ColumnLayout());  
	    fieldSet_1.setHeadingHtml("빈칸");
	    fieldSet_1.setStyleAttribute("marginTop", "5px");
	    fieldSet_1.add(lcSchCol_1, new FormData("100%")); 
	    /****************************************************************
		 * 빈칸FieldSet 끝
		 ****************************************************************/
	    
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
		    		   checkPayr1450Auth("srhPayYr", lsPayYrStore); 
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
	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	    layoutContainer_8.setBorders(false);
	    
	    LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_1_1 = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1_1.setLayout(frmlytSch);
	    
	    srhEmymtDivCd =  new ComboBox<BaseModel>(); 
	    srhEmymtDivCd.setAllowBlank(false); 	//val체크
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
		    	   checkPayr1450Auth("srhEmymtDivCd", lsEmymtDivCd ); 
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
	    layoutContainer.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	    layoutContainer.setBorders(false); 
	    
	    LayoutContainer layoutContainer_3 = new LayoutContainer();
	    layoutContainer_3.setBorders(false);
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_3.setLayout(frmlytSch);
	    
	    srhPymtDducDivCd = new ComboBox<BaseModel>();
	    srhPymtDducDivCd.setName("srhPymtDducDivCd");
	    srhPymtDducDivCd.setForceSelection(true);
	    srhPymtDducDivCd.setMinChars(1);
	    srhPymtDducDivCd.setDisplayField("commCdNm");
	    srhPymtDducDivCd.setValueField("commCd");
	    srhPymtDducDivCd.setTriggerAction(TriggerAction.ALL);
	    srhPymtDducDivCd.setEmptyText("--지급공제선택--");
	    srhPymtDducDivCd.setSelectOnFocus(true); 
	    srhPymtDducDivCd.setReadOnly(false);
	    srhPymtDducDivCd.setEnabled(true); 
	    srhPymtDducDivCd.setStore(lsPymtDducDivCd);  
	    srhPymtDducDivCd.setFieldLabel("지급공제구분");
	    srhPymtDducDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//지급공제 그룹 수당에 따른 수당그룹 값 가져오기.
	    		
	    		String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd, "commCd");
	    		
	    		if("B0080020".equals(strTypOccuCd)){ //수당
	    			sysComBass0300Dto = new PrgmComBass0300DTO();
	    			sysComBass0300Dto.setRpsttvCd("B025");
	    			sysComBass0300Dto.setMangeItem01("C");
	    			
	    			srhPayExtpyGrpCd.setValue("");
	    			srhPayExtpyGrpCd.getInitStore();
//	    			srhPymtDducDivCd1.setValue("");
//	    			srhPymtDducDivCd1.getInitStore();
//	    			srhPymtDducDivCd2.setValue("");
//	    			srhPymtDducDivCd2.getInitStore();
	    			
	    			lsExpnAdmclExtpyDivCd.removeAllListeners();   // 리스너 초기화
	    			lsExpnAdmclExtpyDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

	    			
	    			lsExpnAdmclExtpyDivCd.addStoreListener( new StoreListener<BaseModel>() {   
                        public void handleEvent(StoreEvent<BaseModel> be) {  
                        	mDtalistDtilPayExtpyGrpCd = PayrUtils.getLstComboModelData(lsExpnAdmclExtpyDivCd) ; 
                            srhPayExtpyGrpCd.getInitStore().add(mDtalistDtilPayExtpyGrpCd); 
                            
                        }
                    });
	    			
//	    			lsPymtDducDivCd1 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//	    			lsPymtDducDivCd2 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//	    			lsPymtDducDivCd1.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
////                        	mDtalistDtilPymtDducDivCd1 = PayrUtils.getLstComboModelData(lsPymtDducDivCd1) ; 
//                        	mDtalistDtilPymtDducDivCd1 = PayrUtils.getLstComboModelData(lsPymtDducDivCd) ; 
//                        	srhPymtDducDivCd1.getInitStore().add(mDtalistDtilPymtDducDivCd1); 
//                            
//                        } 
//                    });
//	    			lsPymtDducDivCd2.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
////                        	mDtalistDtilPymtDducDivCd2 = PayrUtils.getLstComboModelData(lsPymtDducDivCd2) ;
//                        	mDtalistDtilPymtDducDivCd2 = PayrUtils.getLstComboModelData(lsPymtDducDivCd) ;
//                        	srhPymtDducDivCd2.getInitStore().add(mDtalistDtilPymtDducDivCd2); 
//                            
//                        }
//                    });
	    			
	    		}else if("B0080030".equals(strTypOccuCd)){ //공제
	    			
	    			sysComBass0300Dto = new PrgmComBass0300DTO();
	    			srhPayExtpyGrpCd.getInitStore();
	    			sysComBass0300Dto.setRpsttvCd("B025");
	    			sysComBass0300Dto.setMangeItem01("D");
	    			
	    			lsExpnAdmclExtpyDivCd.removeAllListeners();   // 리스너 초기화
	    			lsExpnAdmclExtpyDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
	    			lsExpnAdmclExtpyDivCd.addStoreListener( new StoreListener<BaseModel>() {   
                        public void handleEvent(StoreEvent<BaseModel> be) {  
                        	mDtalistDtilPayExtpyGrpCd = PayrUtils.getLstComboModelData(lsExpnAdmclExtpyDivCd) ; 
                            srhPayExtpyGrpCd.getInitStore().add(mDtalistDtilPayExtpyGrpCd); 
                            
                        }
                    });
//	    			srhPymtDducDivCd1.setValue("");
//	    			srhPymtDducDivCd1.getInitStore();
//	    			srhPymtDducDivCd2.setValue("");
//	    			srhPymtDducDivCd2.getInitStore();
	    			
//	    			lsPymtDducDivCd1 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//	    			lsPymtDducDivCd2 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
	    			
//	    			lsPymtDducDivCd1.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
//                        	mDtalistDtilPymtDducDivCd1 = PayrUtils.getLstComboModelData(lsPymtDducDivCd1) ; 
//                        	srhPymtDducDivCd1.getInitStore().add(mDtalistDtilPymtDducDivCd1); 
//                            
//                        } 
//                    });
//	    			lsPymtDducDivCd2.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
//                        	mDtalistDtilPymtDducDivCd2 = PayrUtils.getLstComboModelData(lsPymtDducDivCd2) ; 
//                        	srhPymtDducDivCd2.getInitStore().add(mDtalistDtilPymtDducDivCd2); 
//                            
//                        }
//                    });
	    		}else if("B0080040".equals(strTypOccuCd)){ //세금
	    			srhPayExtpyGrpCd.getInitStore();
	    			
	    			sysComBass0300Dto = new PrgmComBass0300DTO();
	    			sysComBass0300Dto.setRpsttvCd("B025");
	    			sysComBass0300Dto.setMangeItem01("T");
	    			
	    			lsExpnAdmclExtpyDivCd.removeAllListeners();   // 리스너 초기화
	    			lsExpnAdmclExtpyDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
	    			lsExpnAdmclExtpyDivCd.addStoreListener( new StoreListener<BaseModel>() {   
                        public void handleEvent(StoreEvent<BaseModel> be) {  
                        	mDtalistDtilPayExtpyGrpCd = PayrUtils.getLstComboModelData(lsExpnAdmclExtpyDivCd) ; 
                            srhPayExtpyGrpCd.getInitStore().add(mDtalistDtilPayExtpyGrpCd); 
                            
                        }
                    });
	    			
//	    			srhPymtDducDivCd1.setValue("");
//	    			srhPymtDducDivCd1.getInitStore();
//	    			srhPymtDducDivCd2.setValue("");
//	    			srhPymtDducDivCd2.getInitStore();
//	    			
//	    			lsPymtDducDivCd1 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//	    			lsPymtDducDivCd2 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//	    			
//	    			lsPymtDducDivCd1.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
//                        	mDtalistDtilPymtDducDivCd1 = PayrUtils.getLstComboModelData(lsPymtDducDivCd1) ; 
//                        	srhPymtDducDivCd1.getInitStore().add(mDtalistDtilPymtDducDivCd1); 
//                            
//                        } 
//                    });
//	    			lsPymtDducDivCd2.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
//                        	mDtalistDtilPymtDducDivCd2 = PayrUtils.getLstComboModelData(lsPymtDducDivCd2) ; 
//                        	srhPymtDducDivCd2.getInitStore().add(mDtalistDtilPymtDducDivCd2); 
//                            
//                        }
//                    });
	    		}else if("B0080010".equals(strTypOccuCd)){ //본봉일때 기본급이 나와야 함.
	    			srhPayExtpyGrpCd.getInitStore();
	    			lsExpnAdmclExtpyDivCd.removeAllListeners();   // 리스너 초기화
	    			
//	    			sysComBass0300Dto = new PrgmComBass0300DTO();
//	    			srhPayExtpyGrpCd.getInitStore();
//	    			sysComBass0300Dto.setRpsttvCd("B021");
//	    			sysComBass0300Dto.setDtlCd("0040");
//	    			
//	    			
//	    			lsExpnAdmclExtpyDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//	    			lsExpnAdmclExtpyDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
//                        	mDtalistDtilPayExtpyGrpCd = PayrUtils.getLstComboModelData(lsExpnAdmclExtpyDivCd) ; 
//                            srhPayExtpyGrpCd.getInitStore().add(mDtalistDtilPayExtpyGrpCd); 
//                            
//                        }
//                    });
	    			
//	    			srhPymtDducDivCd1.getInitStore();
//	    			srhPymtDducDivCd2.getInitStore();
	    		}else{
	    			srhPayExtpyGrpCd.getInitStore();
	    			lsExpnAdmclExtpyDivCd.removeAllListeners();   // 리스너 초기화
	    			
//	    			srhPymtDducDivCd1.getInitStore();
//	    			srhPymtDducDivCd2.getInitStore();
	    		}
	    	}
	    	
		});
	    
	    layoutContainer_3.add(srhPymtDducDivCd, new FormData("100%"));
	    
	    LayoutContainer layoutContainer_20 = new LayoutContainer();
	    layoutContainer_20.setBorders(false);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	    frmlytSch.setDefaultWidth(100);
	    layoutContainer_20.setLayout(frmlytSch);
	    
	    srhPayExtpyGrpCd = new MSFMultiComboBox<ModelData>();
	    srhPayExtpyGrpCd.setName("srhPayExtpyGrpCd");
	    srhPayExtpyGrpCd.setEmptyText("--수당선택--");
	    srhPayExtpyGrpCd.getListView().setDisplayProperty("commCdNm");
	    srhPayExtpyGrpCd.getStore().add(mDtalistDtilPayExtpyGrpCd);
	    srhPayExtpyGrpCd.setFieldLabel("수당그룹");
	    srhPayExtpyGrpCd.setReadOnly(false);
	    srhPayExtpyGrpCd.setEnabled(true); 
	    srhPayExtpyGrpCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
	    layoutContainer_20.add(srhPayExtpyGrpCd, new FormData("100%"));
        
        
        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 고용구분
	    lcSchCol.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 			// 지급공제구분
	    lcSchCol.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 수당그룹 
	    
	    
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
        srhPayCd.setReadOnly(false);
        srhPayCd.setEnabled(true); 
        srhPayCd.setStore(lsPayCd);
        srhPayCd.setFieldLabel("급여구분");
        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	checkPayr1450Auth("srhPayCd",lsPayCd);   
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
        			checkPayr1450Auth("srhDeptCd", lsDeptCd); 
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
		                	//checkPayr1450Auth("srhTypOccuCd", lsTypOccuCd); 
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
        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
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
	    
	    
//	    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 급여구분
//	    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
//	    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
	    
	    
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
	    
        LayoutContainer layoutContainer_16 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_16.setLayout(frmlytSch);
        
//        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 사업
//        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명
//        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));// 
        
        fieldSet.add(lcSchCol3);
	    
		
	    plFrmPayr1450.add(fieldSet); 
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
//                         mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
//                         srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                         
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
	 
	    
//		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//		//급여구분 
//		sysComBass0300Dto.setRpsttvCd("B008");  //지급공제구분
//		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		dpobCd = new HiddenField<String>(); 			// 사업장코드
		systemkey = new HiddenField<String>();			/** column SYSTEMKEY : systemkey */
		pymtYrMnth = new HiddenField<String>();			/** column 지급년월 : pymtYrMnth */
		payCd = new HiddenField<String>();				/** column 급여구분코드 : payCd */
		payrMangDeptCd = new HiddenField<String>();		/** column 단위기관코드 : payrMangDeptCd */
		payrSeilNum = new HiddenField<Long>();			/** column 급여일련번호 : payrSeilNum */
		emymtDivCd = new HiddenField<String>();			/** column 고용구분코드 : emymtDivCd */
		deptCd = new HiddenField<String>();				/** column 부서코드 : deptCd */
		businCd = new HiddenField<String>();			/** column 사업코드 : businCd */
		typOccuCd = new HiddenField<String>();			/** column 직종코드 : typOccuCd */
		typOccuNm = new HiddenField<String>();
		logSvcYrNumCd = new HiddenField<String>();		/** column 근속년수코드 : logSvcYrNumCd */
		txtnTotAmnt = new HiddenField<Long>();			/** column 과세총액 : txtnTotAmnt */
		bnkCd = new HiddenField<String>();				/** column 은행코드 : bnkCd */
		bnkNm = new HiddenField<String>();				/** column 은행코드 : bnkNm */
		bnkAccuNum = new HiddenField<String>();			/** column 은행계좌번호 : bnkAccuNum */
		acntHodrNm = new HiddenField<String>();			/** column 예금주명 : acntHodrNm */
		payDdlneDt = new HiddenField<String>();			/** column 급여마감일자 : payDdlneDt */
		payDdlneYn = new HiddenField<String>();			/** column 급여마감여부 : payDdlneYn */
		txTotAmnt = new HiddenField<Long>();    
	      
		LayoutContainer layoutContainer = new LayoutContainer();
		
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());
		
		// 그리드 안에 콤보박스
		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		layoutContainer_3_1.setBorders(false);
	    
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_3_1.setLayout(frmlytSch);
	    
	    
	    srhPymtDducDivCd1 = new ComboBox<BaseModel>();
	    srhPymtDducDivCd1.setName("srhPymtDducDivCd1");
	    srhPymtDducDivCd1.setForceSelection(true);
	    srhPymtDducDivCd1.setMinChars(1);
	    srhPymtDducDivCd1.setDisplayField("commCdNm");
	    srhPymtDducDivCd1.setValueField("commCd");
	    srhPymtDducDivCd1.setTriggerAction(TriggerAction.ALL);
	    srhPymtDducDivCd1.setEmptyText("--지급공제선택--");
	    srhPymtDducDivCd1.setSelectOnFocus(true); 
	    srhPymtDducDivCd1.setReadOnly(false);
	    srhPymtDducDivCd1.setEnabled(true); 
	    srhPymtDducDivCd1.setStore(lsPymtDducDivCd1);  
	    srhPymtDducDivCd1.setFieldLabel("지급공제구분");	    
	    srhPymtDducDivCd1.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        	BaseModel bmPayYr =  se.getSelectedItem(); 
	        	if (bmPayYr != null) {
	        		IColumnFilter filters = null;
	            	payr0470DducGridPanel.getTableDef().setTableColumnFilters(filters);
	            	payr0470DducGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분 
	            	payr0470DducGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd1,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 지급공제구분
	            	payr0470DducGridPanel.reload();
	        	}       
	    	} 
		});   	    
//	    srhPymtDducDivCd1 = new MSFMultiComboBox<ModelData>();
//	    srhPymtDducDivCd1.setName("srhPymtDducDivCd1");
////	    srhPymtDducDivCd1.setForceSelection(true);
////	    srhPymtDducDivCd1.setMinChars(1);
////	    srhPymtDducDivCd1.setDisplayField("payDducNm");
////	    srhPymtDducDivCd1.setValueField("payDducCd");
////	    srhPymtDducDivCd1.setTriggerAction(TriggerAction.ALL);
//	    srhPymtDducDivCd1.setEmptyText("--지급공제선택--");
//	    srhPymtDducDivCd1.getListView().setDisplayProperty("commCdNm");
//	    srhPymtDducDivCd1.getStore().add(mDtalistDtilPymtDducDivCd1);
//	    srhPymtDducDivCd1.setFieldLabel("지급공제구분"); 
////	    srhPymtDducDivCd1.setSelectOnFocus(true); 
//	    srhPymtDducDivCd1.setReadOnly(false);
//	    srhPymtDducDivCd1.setEnabled(true); 
////	    srhPymtDducDivCd1.setStore(lsPayDducExtpyCd);
//	    
//	    srhPymtDducDivCd1.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//        	@Override
//        	public void handleEvent(ComponentEvent ce) {   
//        		if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//        			// GWT.log(" a" + ce.getEvent().getType());
//        			mutilCombo = true;
//        		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//        			mutilCombo = true;
//        			//  GWT.log(" b" + ce.getEvent().getType());
//        		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//        			mutilCombo = false;
//        			//  GWT.log(" b" + ce.getEvent().getType());
//        		}  
//        	} 
//        });
	    layoutContainer_3_1.add(srhPymtDducDivCd1, new FormData("100%"));
	    layoutContainer_3.add(layoutContainer_3_1, new FormData("100%"));
		
		//그리드 안에 콤보박스
	    
		FieldSet fldstNewFieldset_4 = new FieldSet();
		fldstNewFieldset_4.setCollapsible(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.add(payrLeft01());
		fldstNewFieldset_4.add(layoutContainer_3_1);
		fldstNewFieldset_4.add(layoutContainer_4);
		layoutContainer_4.setBorders(false);
		fldstNewFieldset_4.setCollapsible(false);
		fldstNewFieldset_4.setHeadingHtml("출력항목 미선택");
		layoutContainer_3.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		//그리드 안에 콤보박스
		LayoutContainer layoutContainer_3_2 = new LayoutContainer();
		layoutContainer_3_1.setBorders(false);
	    
	    FormLayout frmlytSch1 = new FormLayout();  
	    frmlytSch1.setLabelWidth(80); 
	    frmlytSch1.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_3_2.setLayout(frmlytSch1);
	    
	    
	    
	    
	    srhPymtDducDivCd2 = new ComboBox<BaseModel>();
	    srhPymtDducDivCd2.setName("srhPymtDducDivCd2");
	    srhPymtDducDivCd2.setForceSelection(true);
	    srhPymtDducDivCd2.setMinChars(1);
	    srhPymtDducDivCd2.setDisplayField("commCdNm");
	    srhPymtDducDivCd2.setValueField("commCd");
	    srhPymtDducDivCd2.setTriggerAction(TriggerAction.ALL);
	    srhPymtDducDivCd2.setEmptyText("--지급공제선택--");
	    srhPymtDducDivCd2.setSelectOnFocus(true); 
	    srhPymtDducDivCd2.setReadOnly(false);
	    srhPymtDducDivCd2.setEnabled(true); 
	    srhPymtDducDivCd2.setStore(lsPymtDducDivCd2);  
	    srhPymtDducDivCd2.setFieldLabel("지급공제구분");	    
	    srhPymtDducDivCd2.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        	BaseModel bmPayYr =  se.getSelectedItem(); 
	        	if (bmPayYr != null) {
	        		IColumnFilter filters = null;
	            	payr0485ExtpyGridPanel.getTableDef().setTableColumnFilters(filters);
	            	payr0485ExtpyGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분 
	            	payr0485ExtpyGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd2,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 지급공제구분
	            	payr0485ExtpyGridPanel.reload();
	        	}       
	    	} 
		});  	    
	    
	    
//	    srhPymtDducDivCd2 = new MSFMultiComboBox<ModelData>();
//	    srhPymtDducDivCd2.setName("srhPymtDducDivCd2");
////	    srhPymtDducDivCd2.setForceSelection(true);
////	    srhPymtDducDivCd2.setMinChars(1);
////	    srhPymtDducDivCd2.setDisplayField("payDducNm");
////	    srhPymtDducDivCd2.setValueField("payDducCd");
////	    srhPymtDducDivCd2.setTriggerAction(TriggerAction.ALL);
//	    srhPymtDducDivCd2.setEmptyText("--지급공제선택--");
//	    srhPymtDducDivCd2.getListView().setDisplayProperty("commCdNm");
//	    srhPymtDducDivCd2.getStore().add(mDtalistDtilPymtDducDivCd2);
//	    srhPymtDducDivCd2.setFieldLabel("지급공제구분"); 
////	    srhPymtDducDivCd1.setSelectOnFocus(true); 
//	    srhPymtDducDivCd2.setReadOnly(false);
//	    srhPymtDducDivCd2.setEnabled(true); 
////	    srhPymtDducDivCd1.setStore(lsPayDducExtpyCd);
//	    srhPymtDducDivCd2.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
//        	@Override
//        	public void handleEvent(ComponentEvent ce) {
//
//        		IColumnFilter filters = null;
//        		payr0485ExtpyGridPanel.getTableDef().setTableColumnFilters(filters);
//        		payr0485ExtpyGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 고용구분 
////            	payr0470DducGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 지급공제구분
//            	String strPayDducExtpyCd = PayrUtils.getStrValToBMMultiCombo(lsPymtDducDivCd1, srhPymtDducDivCd1.getValue(),"commCdNm","commCd"); 
//            	payr0485ExtpyGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", strPayDducExtpyCd, SimpleColumnFilter.OPERATOR_EQUALS); //수당그룹구분코드
//            	payr0485ExtpyGridPanel.reload();
//            	
//        	}
//
//		});	 	    
	    srhPymtDducDivCd2.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
	    layoutContainer_3_2.add(srhPymtDducDivCd2, new FormData("100%"));
	    layoutContainer_3.add(layoutContainer_3_2, new FormData("100%"));
		
		//그리드 안에 콤보박스
		
		
		FieldSet fldstNewFieldset_5 = new FieldSet();
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.add(payrLeft02());
		fldstNewFieldset_5.add(layoutContainer_3_2);
		fldstNewFieldset_5.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);
		fldstNewFieldset_5.setHeadingHtml("출력항목");
		fldstNewFieldset_5.setCollapsible(false);
		layoutContainer_3.add(fldstNewFieldset_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		layoutContainer.add(layoutContainer_3);
		
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
//		fldstNewFieldset_1.setSize(1000, 350);
		fldstNewFieldset_1.setHeadingHtml("출력항목상세");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_1.add(payr1450Info(),new FormData("100%"));
		layoutContainer.add(fldstNewFieldset_1);
		
		    
		plFrmPayr1450.add(layoutContainer);
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
	private LayoutContainer payr1450Info() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		// ContentPanel cp01 = new ContentPanel();
		// cp01.setBodyBorder(false);
		// cp01.setHeaderVisible(false);
		// cp01.setLayout(new FitLayout());
		// cp01.setSize(600, 100);

		LayoutContainer lytCtr01 = new LayoutContainer();
//		lytCtr01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_22 = new LayoutContainer();
		layoutContainer_22.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_23 = new LayoutContainer();
		FormLayout frmlytCd = new FormLayout();
		frmlytCd.setLabelWidth(80);
		frmlytCd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_23.setLayout(frmlytCd);

		payItemCd = new TextField<String>();
		payItemCd.setName("payItemCd");
		payItemCd.setFieldLabel("항목코드");

		layoutContainer_23.add(payItemCd, new FormData("100%"));
       layoutContainer_22.add(layoutContainer_23,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_23.setBorders(false);

		LayoutContainer layoutContainer_24 = new LayoutContainer();
		FormLayout frmlytNm = new FormLayout();
		 frmlytNm.setLabelWidth(0);
		frmlytNm.setLabelSeparator("");
		frmlytNm.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24.setLayout(frmlytNm);

		payExtpyNm = new TextField<String>();
		payExtpyNm.setName("payExtpyNm");
//		payExtpyNm.setFieldLabel("항목");
      
       layoutContainer_24.add(payExtpyNm, new FormData("100%"));
       layoutContainer_22.add(layoutContainer_24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       layoutContainer_24.setBorders(false);
       
       
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setBorders(false);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);
	   
		yrtxDotnCd = new ComboBox<BaseModel>();
		yrtxDotnCd.setName("yrtxDotnCd");
		yrtxDotnCd.setForceSelection(true);
		yrtxDotnCd.setMinChars(1);
		yrtxDotnCd.setDisplayField("commCdNm");
		yrtxDotnCd.setValueField("commCd");
		yrtxDotnCd.setTriggerAction(TriggerAction.ALL);
		yrtxDotnCd.setEmptyText("--기부금 유형--");
		yrtxDotnCd.setSelectOnFocus(true);
		yrtxDotnCd.setReadOnly(false);
		yrtxDotnCd.setEnabled(true);
		yrtxDotnCd.setStore(lsYrtxDotnNm);
		yrtxDotnCd.setFieldLabel("기부금 유형");
	   	layoutContainer_13.add(yrtxDotnCd, new FormData("100%")); 
	   	layoutContainer_22.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    
       	lytCtr01.add(layoutContainer_22);
	   
	   
	   	LayoutContainer layoutContainer_5 = new LayoutContainer();
	   	layoutContainer_5.setLayout(new ColumnLayout());
	   
	   	LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);
	   
		yrtxDontKey = new HiddenField<String>();
		yrtxDontKey.setName("yrtxDontKey");
		yrtxDontKey.setFieldLabel("yrtxDontKey");

		Button btnFreeDtyCd = new Button();
		btnFreeDtyCd.setIcon(MSFMainApp.ICONS.search());
		btnFreeDtyCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (MSFSharedUtils.allowNulls(yrtxFreeDtyReduCd.getValue()).trim().equals("")) {
					yrtxDontKey.setValue("");
				}
				fnPopupBass0300("Y011");
			}
		});

		yrtxFreeDtyReduCd = new TextFieldWithButton<String>(btnFreeDtyCd);
		yrtxFreeDtyReduCd.setFieldLabel("비과세감면");
		yrtxFreeDtyReduCd.setMaxLength(20);
		yrtxFreeDtyReduCd.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				yrtxDontKey.validate();

				if (MSFSharedUtils.allowNulls(yrtxFreeDtyReduCd.getValue()).trim().equals("")) {
					yrtxDontKey.setValue("");
				}
				if (MSFSharedUtils.paramNull(yrtxFreeDtyReduCd.getValue())) {
					yrtxDontKey.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					fnPopupBass0300("Y011");
				}
				super.componentKeyDown(event);
			}
		});

	   layoutContainer_6.add(yrtxFreeDtyReduCd, new FormData("100%"));
	   //freeDtyNm.setReadOnly(true);
	   layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_6.setBorders(false);
	   
	   LayoutContainer layoutContainer_7 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(5); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_7.setLayout(frmlytStd);
	   
	   //secRegnNum = new HiddenField<String>();
	   
	   yrtxFreeDtyReduNm = new TextField<String>();
	   yrtxFreeDtyReduNm.setReadOnly(true);
	   yrtxFreeDtyReduNm.setLabelSeparator("");
	   layoutContainer_7.add(yrtxFreeDtyReduNm, new FormData("100%"));
	   layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_7.setBorders(false);
	   
	   //===========회계정보 시작 ===================
	   LayoutContainer layoutContainer_8 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_8.setLayout(frmlytStd);
	   
	   accAccKey = new HiddenField<String>();
	   accAccKey.setName("accAccKey");
	   accAccKey.setFieldLabel("accAccKey");
	  
	   Button btnAccCd = new Button();
	   btnAccCd.setIcon(MSFMainApp.ICONS.search());
	   btnAccCd.addListener(Events.Select, new Listener<ButtonEvent>() {
           public void handleEvent(ButtonEvent e) {
           	if (MSFSharedUtils.allowNulls(accAccCd.getValue()).trim().equals("")) {
           		accAccKey.setValue("");
               }
           	fnPopupBass0300("B021");
           }
       });
	   accAccCd = new TextFieldWithButton<String>(btnAccCd);
	   accAccCd.setFieldLabel("회계계정");
	   accAccCd.setMaxLength(20);
	   accAccCd.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				accAccKey.validate();
				
				if (MSFSharedUtils.allowNulls(accAccCd.getValue()).trim().equals("")) {
					accAccKey.setValue("");
                }if (MSFSharedUtils.paramNull(accAccCd.getValue())) {
                	accAccKey.setValue("");
                }
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	accAccCd.setValue("");
                	accAccNm.setValue("");
                	fnPopupBass0300("B021");
                	}
                super.componentKeyDown(event);
            	}
		});
	   
	   
	   layoutContainer_8.add(accAccCd, new FormData("100%"));
	   layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_8.setBorders(false);
	   lytCtr01.add(layoutContainer_5);
	   layoutContainer_5.setBorders(false);
	   
	   LayoutContainer layoutContainer_17 = new LayoutContainer();
	   frmlytStd = new FormLayout();
	   frmlytStd.setLabelWidth(5);
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_17.setLayout(frmlytStd);
	   
	   accAccNm = new TextField<String>();
	   accAccNm.setReadOnly(true);
	   accAccNm.setLabelSeparator("");
	   layoutContainer_17.add(accAccNm, new FormData("100%"));
	   layoutContainer_5.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_17.setBorders(false);
	   
	   //===========회계정보 끝 ===================
	   
	   //===========퇴직정산 포함-=================
	   LayoutContainer layoutContainer_9 = new LayoutContainer();
	   layoutContainer_9.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_10 = new LayoutContainer();
       frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_10.setLayout(frmlytStd);
	   
	   sevePayYn = new CheckBox();
//	   sevePayYn.setBoxLabel(boxLabelHtml);
	   sevePayYn.setName("sevePayYn");
	   sevePayYn.setBoxLabel("퇴직정산포함");
	   
	   layoutContainer_10.add(sevePayYn, new FormData("100%"));
   	   layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
	   layoutContainer_10.setBorders(false);

	   //===========기간체출력=================
	   LayoutContainer layoutContainer_11 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_11.setLayout(frmlytStd);
	   
	   payrTermUseYn = new CheckBox();
	   payrTermUseYn.setName("payrTermUseYn");
	   payrTermUseYn.setBoxLabel("기간제출력");
	   layoutContainer_11.add(payrTermUseYn, new FormData("100%"));
   	   layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
   	   
   	   
	   LayoutContainer layoutContainer_14 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_14.setLayout(frmlytStd);
	   
	   extptDducDspyYn = new CheckBox();
	   extptDducDspyYn.setName("extptDducDspyYn");
	   extptDducDspyYn.setBoxLabel("화면출력");
	   layoutContainer_14.add(extptDducDspyYn, new FormData("100%"));
	   layoutContainer_9.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	   
	   
	   LayoutContainer layoutContainer = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer.setLayout(frmlytStd);
	   
	   extptDducUseYn = new CheckBox();
	   extptDducUseYn.setName("extptDducUseYn");
	   extptDducUseYn.setBoxLabel("사용");
	   layoutContainer.add(extptDducUseYn, new FormData("100%"));
	   layoutContainer_9.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	   
	   
	   LayoutContainer layoutContainer10 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
//	   frmlytStd.setLabelWidth(80); 
//	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer10.setLayout(frmlytStd);
	   
	   saveButtonBar = new ButtonBar();
	   saveButtonBar.setAlignment(HorizontalAlignment.RIGHT);
	   
	   Button saveBtn = new Button("저장");
	   saveBtn.setIcon(MSFMainApp.ICONS.save16());
	   saveBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
					actionDatabase = ActionDatabase.UPDATE;
					doAction(actionDatabase);
			}
		});
       saveButtonBar.add(saveBtn);
       layoutContainer10.add(saveButtonBar);
       layoutContainer_9.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	   
	   layoutContainer.setBorders(false);
		
   	   layoutContainer_11.setBorders(false);
	   
	   lytCtr01.add(layoutContainer_9);
	   layoutContainer_9.setBorders(false);
	   
	   //============퇴직정산, 기간제출력끝 ========
	   //============기부금 유형 ========
	   
	   LayoutContainer layoutContainer_12 = new LayoutContainer();
	   layoutContainer_12.setLayout(new ColumnLayout());
	   
//	   LayoutContainer layoutContainer_13 = new LayoutContainer();
//	   layoutContainer_13.setBorders(false);
//	   frmlytStd = new FormLayout();  
//	   frmlytStd.setLabelWidth(80); 
//	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//	   layoutContainer_13.setLayout(frmlytStd);
//	   
//	   yrtxDotnCd = new ComboBox<BaseModel>();
//	   yrtxDotnCd.setName("yrtxDotnCd");
//	   yrtxDotnCd.setForceSelection(true);
//	   yrtxDotnCd.setMinChars(1);
//	   yrtxDotnCd.setDisplayField("commCdNm");
//	   yrtxDotnCd.setValueField("commCd");
//	   yrtxDotnCd.setTriggerAction(TriggerAction.ALL);
//	   yrtxDotnCd.setEmptyText("--기부금 유형--");
//	   yrtxDotnCd.setSelectOnFocus(true); 
//	   yrtxDotnCd.setReadOnly(false);
//	   yrtxDotnCd.setEnabled(true); 
//	   yrtxDotnCd.setStore(lsYrtxDotnNm);  
//	   yrtxDotnCd.setFieldLabel("기부금 유형");
//	    layoutContainer_13.add(yrtxDotnCd, new FormData("100%")); 
//	    
//	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   
	   //============기부금 유형 끝========
	   
//	   LayoutContainer layoutContainer_14 = new LayoutContainer();
//	   frmlytStd = new FormLayout();  
//	   frmlytStd.setLabelWidth(80); 
//	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//	   layoutContainer_14.setLayout(frmlytStd);
//	   
//	   extptDducDspyYn = new CheckBox();
//	   extptDducDspyYn.setName("extptDducDspyYn");
//	   extptDducDspyYn.setFieldLabel("화면출력");
//	   layoutContainer_14.add(extptDducDspyYn, new FormData("100%"));
//	   layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.125));
	   
//	   LayoutContainer layoutContainer = new LayoutContainer();
//	   frmlytStd = new FormLayout();  
//	   frmlytStd.setLabelWidth(80); 
//	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//	   layoutContainer.setLayout(frmlytStd);
//	   
//	   extptDducUseYn = new CheckBox();
//	   extptDducUseYn.setName("extptDducUseYn");
//	   extptDducUseYn.setFieldLabel("사용");
//	   layoutContainer.add(extptDducUseYn, new FormData("100%"));
//	   layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.125));
//	   layoutContainer.setBorders(false);
	    
	   
//	   LayoutContainer layoutContainer10 = new LayoutContainer();
//	   frmlytStd = new FormLayout();  
//	   frmlytStd.setLabelWidth(80); 
//	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//	   layoutContainer10.setLayout(frmlytStd);
//	   
//	   saveButtonBar = new ButtonBar();
//	   
//	   saveButtonBar.setAlignment(HorizontalAlignment.RIGHT);
//	   
//       saveButton = new Button(MSFMainApp.MSFCONSTANTS.BtSave());
//       saveButton.setIcon(MSFMainApp.ICONS.save16());
//       saveButtonBar.add(saveButton);
//       saveButton.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//					actionDatabase = ActionDatabase.UPDATE;
//					doAction(actionDatabase);
//			}
//		});
//       layoutContainer10.add(saveButtonBar);
       //layoutContainer10.add(saveButton, new FormData("50%"));
//	   layoutContainer_12.add(layoutContainer10);
//	   layoutContainer10.setBorders(false);
	   //=====================
	   
	   lytCtr01.add(layoutContainer_12);

	   lcTabFormLayer.add(lytCtr01);
	      
	   return lcTabFormLayer;
}

 private LayoutContainer occupationalLeft() {
     
     LayoutContainer lcTabFormLayer = new LayoutContainer();
     
    //   
      ContentPanel cp01 = new ContentPanel();   
      cp01.setBodyBorder(false); 
      cp01.setHeaderVisible(false);   
      cp01.setLayout(new FitLayout());      
      cp01.setSize(320, 460);  
     
     //msfCustomForm.setHeaderVisible(false);
     //Instantiate the GridPanel
     payr0304GridPanel = new MSFGridPanel(payr0304Def, false, false, false, false,false);
     payr0304GridPanel.setHeaderVisible(false);  
     payr0304GridPanel.setBodyBorder(true);
     payr0304GridPanel.setBorders(true);
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

//출력항목 미 선택
 private LayoutContainer payrLeft01() {
	   
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(384, 370);  
	    
	   //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
	   payr0470DducGridPanel = new MSFGridPanel(payr0470ducDef, false, false, false, false,false);
	   payr0470DducGridPanel.setHeaderVisible(false);  
	   payr0470DducGridPanel.setBodyBorder(true);
	   payr0470DducGridPanel.setBorders(true);
	 //  payr0302ExtpyGridPanel.setSize(300, 140);  
	   payr0470DducGridPanel.getBottomComponent().setVisible(false);
	   
	   final Grid<BaseModel> grid2 = payr0470DducGridPanel.getMsfGrid().getGrid();
       final ColumnModel columnModel2 =  grid2.getColumnModel();
       final List<ColumnConfig> columnConfigs2 = columnModel2.getColumns();
       final CheckColumnConfig check2 = new CheckColumnConfig("select", "선택", 55); 
       check2.setAlignment(Style.HorizontalAlignment.CENTER);		            
       check2.setEditor(columnConfigs2.get(0).getEditor());
       columnConfigs2.set(0, check2);

       check2.setRenderer(columnConfigs2.get(0).getRenderer());  
       grid2.addPlugin(check2);
       grid2.getView().setForceFit(true);
	    
		//툴바메뉴
       ToolBar bottomToolbar = new ToolBar();  
       bottomToolbar.add(new FillToolItem());
       
       // 첫번째 사용직종정보 툴바
       // ================전체선택버튼=========================
       btnSelectPayr0145 = new Button("전체선택");
       btnSelectPayr0145.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
           public void componentSelected(ButtonEvent ce) { 
           	
           	  int  lsCnt = payr0470DducGridPanel.getMsfGrid().getGrid().getStore().getCount();
           	  
           	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
           		  
           		payr0470DducGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
           		payr0470DducGridPanel.getMsfGrid().getGrid().getStore().commitChanges();
           		   
           	  } 
           	payr0470DducGridPanel.getMsfGrid().getGrid().getView().refresh(true);
		    }
       });

       bottomToolbar.add(btnSelectPayr0145);
       bottomToolbar.add(new SeparatorMenuItem());
       
       //=================================================================
       // ================전체해제버튼=========================
       btnSelectPayr0145  = new Button("전체해제");
       btnSelectPayr0145.addSelectionListener(new SelectionListener<ButtonEvent>() {
           public void componentSelected(ButtonEvent ce) {  

           	  int  lsCnt = payr0470DducGridPanel.getMsfGrid().getGrid().getStore().getCount();
           	  
           	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
           		  
           		payr0470DducGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
           		payr0470DducGridPanel.getMsfGrid().getGrid().getStore().commitChanges();
           		   
           	  } 
           	payr0470DducGridPanel.getMsfGrid().getGrid().getView().refresh(true);
           }  
       });

       bottomToolbar.add(btnSelectPayr0145);
       bottomToolbar.add(new SeparatorMenuItem());
       //====================================================
       
       saveButton = new Button("사용");
       saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
           public void componentSelected(ButtonEvent ce) { 
           	 Iterator<BaseModel> itBm  = payr0470DducGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
		          List<Record> lsRec  = new ArrayList<Record>();
		          while(itBm.hasNext()) {
		              Record rec  = new Record(itBm.next()); 
		              lsRec.add(rec);
		          }  
		          Iterator<Record> iterRecords = lsRec.iterator();
		          
	              while (iterRecords.hasNext()) {	    		            	  
	            	  Record recData = (Record) iterRecords.next(); 
		              BaseModel bmMapModel = (BaseModel)recData.getModel();
		               
		              // select에 null값이 들어가있으므로 널포인트에러뜸.
		              // 그래서 null인것은 false로 강제변환시킴.
		              if((Boolean)bmMapModel.get("select")==null){
		            		 bmMapModel.set("select", false);
		            	 }		    		              
		              
		              if ((Boolean)bmMapModel.get("select")) {	//사용 기능 구현 
		            	  
		            	  Payr0485DTO payr0485Dto = new  Payr0485DTO();
		            	  payr0485Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));  //사업장코드
		            	  payr0485Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); //고용구분코드
		            	  
		            	  payr0485Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payDducCd"))); //항목코드
		            	  
		            	  if("true".equals(MSFSharedUtils.allowNulls(bmMapModel.get("payDducUseYn")))){
		            		  payr0485Dto.setExtptDducUseYn("Y"); 
		            	  }else{
		            		  payr0485Dto.setExtptDducUseYn("N"); 
		            	  }
		            	  //payr0485Dto.setExtptDducUseYn(MSFSharedUtils.allowNulls(bmMapModel.get("payDducUseYn"))); //사용여부
		            	  payr0485Dto.setYrtxFreeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxFreeDtyReduCd"))); // 비과세감면코드
		            	  payr0485Dto.setAccAccCd(MSFSharedUtils.allowNulls(bmMapModel.get("accAccCd"))); //회계계정코드
		            	  payr0485Dto.setSevePayYn(MSFSharedUtils.allowNulls(bmMapModel.get("sevePayYn"))); //퇴직여부
		            	  payr0485Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));
		            	  
		            	  payr0485Insert(payr0485Dto);

		              }		    		              
	              }
           }
       });

       bottomToolbar.add(saveButton);
       bottomToolbar.add(new SeparatorMenuItem());


       Button refresh2 = new Button("");
       refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
       refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
           public void componentSelected(ButtonEvent ce) {  
        	   payr0470DducGridPanel.reload();
           }  
       });		            
       bottomToolbar.add(refresh2);
       
       
       payr0470DducGridPanel.setBottomComponent(bottomToolbar);
       
	    cp01.add(payr0470DducGridPanel);
	    

//        lcTabFormLayer.add(bottomToolbar);
	    
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;  
	   
 }
 
 //출력항목
 private LayoutContainer payrLeft02() {
	   
	   LayoutContainer lcTabFormLayer1 = new LayoutContainer();
 
	   ContentPanel cp02 = new ContentPanel();   
	   cp02.setBodyBorder(false); 
	   cp02.setHeaderVisible(false);   
	   cp02.setLayout(new FitLayout());      
	   cp02.setSize(576, 370);    
	   
	   //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
	   payr0485ExtpyGridPanel = new MSFGridPanel(payr0485ExtpyDef, false, false, false, false, false);
	   payr0485ExtpyGridPanel.setHeaderVisible(false);  
	   payr0485ExtpyGridPanel.setBodyBorder(true);
	   payr0485ExtpyGridPanel.setBorders(true); 
	   payr0485ExtpyGridPanel.getBottomComponent().setVisible(false);
	   
	   final Grid payr0485Grid = payr0485ExtpyGridPanel.getMsfGrid().getGrid(); // 출력항목상세 그리드 선언
	   payr0485Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {  
            if (payr0485ExtpyGridPanel.getCurrentlySelectedItem() != null) {    
               
                setRecord(payr0485ExtpyGridPanel.getCurrentlySelectedItem());
                payr0485Detail(payr0485ExtpyGridPanel.getCurrentlySelectedItem());
                actionDatabase = ActionDatabase.UPDATE;
             } 
           }
       }); 
       
	   final Grid<BaseModel> grid2 = payr0485ExtpyGridPanel.getMsfGrid().getGrid();
       final ColumnModel columnModel2 =  grid2.getColumnModel();
       final List<ColumnConfig> columnConfigs2 = columnModel2.getColumns();
       final CheckColumnConfig check2 = new CheckColumnConfig("select", "선택", 55); 
       check2.setAlignment(Style.HorizontalAlignment.CENTER);		            
       check2.setEditor(columnConfigs2.get(0).getEditor());
       columnConfigs2.set(0, check2);

       check2.setRenderer(columnConfigs2.get(0).getRenderer());  
       grid2.addPlugin(check2);
       grid2.getView().setForceFit(true);
	 //   payr0302DducGridPanel.setSize(300, 140); 
	   
	// 두번째 미사용직종정보 툴바 		            
       ToolBar bottomToolbar2 = new ToolBar();  
       bottomToolbar2.add(new FillToolItem());
    // ================전체선택버튼=========================
       btnSelectPayr0145 = new Button("전체선택");
       btnSelectPayr0145.addSelectionListener(new SelectionListener<ButtonEvent>() {
           public void componentSelected(ButtonEvent ce) {
           	
           	  int  lsCnt = payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().getCount();
           	  
           	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
           		  
           		payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
           		payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().commitChanges();
           		   
           	  } 
           	payr0485ExtpyGridPanel.getMsfGrid().getGrid().getView().refresh(true);
           	  
           }  
       });

       bottomToolbar2.add(btnSelectPayr0145);
       bottomToolbar2.add(new SeparatorMenuItem());
       //====================================================
       
      // ================전체해제버튼=========================
       btnSelectPayr0145  = new Button("전체해제");
       btnSelectPayr0145.addSelectionListener(new SelectionListener<ButtonEvent>() {
           public void componentSelected(ButtonEvent ce) {  

           	  int  lsCnt = payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().getCount();
           	  
           	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
           		  
           		payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
           		payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().commitChanges();
           		   
           	  } 
           	payr0485ExtpyGridPanel.getMsfGrid().getGrid().getView().refresh(true);
           }  
       });

       bottomToolbar2.add(btnSelectPayr0145);
       bottomToolbar2.add(new SeparatorMenuItem());
       //====================================================
       
       saveButton = new Button("미사용");
       saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
       	
           public void componentSelected(ButtonEvent ce) {
        	   Window.alert("현재 사용중인 수당코드가 아니면 완전삭제, 있으면 사용안함으로 변경 및 삭제불가");
           	  Iterator<BaseModel> itBm  = payr0485ExtpyGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
		          List<Record> lsRec  = new ArrayList<Record>();
		          while(itBm.hasNext()) {
		              Record rec  = new Record(itBm.next()); 
		              lsRec.add(rec);
		          }  
		          Iterator<Record> iterRecords = lsRec.iterator();
		          
	              while (iterRecords.hasNext()) {	    		            	  
	            	  Record recData = (Record) iterRecords.next();
		              BaseModel bmMapModel = (BaseModel)recData.getModel();		    		             
		              
		              // select에 null값이 들어가있으므로 널포인트에러뜸.
		              // 그래서 null인것은 false로 강제변환시킴.
		              if((Boolean)bmMapModel.get("select")==null){
		            		 bmMapModel.set("select", false);
		            	 }		    		              
		                
		              if ((Boolean)bmMapModel.get("select")) { //미사용 다시 구현
		            	  
		            	  Payr0485DTO payr0485Dto = new  Payr0485DTO();
		            	  payr0485Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));  //사업장코드
		            	  payr0485Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); //고용구분코드
		            	  
		            	  payr0485Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd"))); //항목코드
		            	  
		            	  if("true".equals(MSFSharedUtils.allowNulls(bmMapModel.get("payDducUseYn")))){
		            		  payr0485Dto.setExtptDducUseYn("Y"); 
		            	  }else{
		            		  payr0485Dto.setExtptDducUseYn("N"); 
		            	  }
		            	  payr0485Dto.setYrtxFreeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxFreeDtyReduCd"))); // 비과세감면코드
		            	  payr0485Dto.setAccAccCd(MSFSharedUtils.allowNulls(bmMapModel.get("accAccCd"))); //회계계정코드
		            	  payr0485Dto.setSevePayYn(MSFSharedUtils.allowNulls(bmMapModel.get("sevePayYn"))); //퇴직여부
		            	  
		            	  payrUpdateDelete0485Yn(payr0485Dto);
		              }
	              }
	           
           }
           
       });

       bottomToolbar2.add(saveButton);
       bottomToolbar2.add(new SeparatorMenuItem());


       Button refresh2 = new Button("");
       refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
       refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
           public void componentSelected(ButtonEvent ce) {  
        	   payr0485ExtpyGridPanel.reload();
           }  
       });		            
       bottomToolbar2.add(refresh2);
       
       payr0485ExtpyGridPanel.setBottomComponent(bottomToolbar2);
 
       cp02.add(payr0485ExtpyGridPanel);
	    
       lcTabFormLayer1.add(cp02); 
	     
		return lcTabFormLayer1;  
	   
 }
 

  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 

    private void payr0485Detail(BaseModel selRecord) {
    	 
    	 payItemCd.setValue((String)selRecord.get("payItemCd"));  /** column 항목코드 : payItemCd */
    	 payExtpyNm.setValue((String)selRecord.get("payExtpyNm"));  /** column 항목명 : payExtpyNm */
    	 yrtxFreeDtyReduCd.setValue((String)selRecord.get("yrtxFreeDtyReduCd"));  /** column 비과세감면코드 : yrtxFreeDtyReduCd */
    	 yrtxFreeDtyReduNm.setValue((String)selRecord.get("yrtxFreeDtyReduNm"));  /** column 비과세감면 : yrtxFreeDtyReduNm */
    	 
    	 
    	 accAccCd.setValue((String)selRecord.get("accAccCd"));  /** column 회계계정코드 : accAccCd */
    	 accAccNm.setValue((String)selRecord.get("accAccNm"));  /** column 회계계정 : accAccNm */
    	 
    	 sevePayYn.setValue((Boolean)selRecord.get("sevePayYn"));    /** column 퇴직정산포함여부 : sevePayYn */
    	 payrTermUseYn.setValue((Boolean)selRecord.get("payrTermUseYn"));    
//		 BaseModel  bm  =  yrtxDotnCd.getStore().findModel("yrtxDotnCd", (String)selRecord.get("yrtxDotnCd") ); 
//		 yrtxDotnCd.setValue(bm);  /** column 기부금유형코드 : yrtxDotnCd */
    	 yrtxDotnCd.setValue(lsYrtxDotnNm.findModel("commCd",MSFSharedUtils.allowNulls(selRecord.get("yrtxDotnCd"))));
    	 extptDducDspyYn.setValue((Boolean)selRecord.get("extptDducDspyYn"));    /** column 화면출력여부 : extptDducDspyYn */
    	 extptDducUseYn.setValue((Boolean)selRecord.get("extptDducUseYn"));    /** column 사용 : payrTermUseYn */
    	
    	 dpobCd.setValue((String)selRecord.get("dpobCd"));  /** column 사업코드 : businCd */
     	 systemkey.setValue((String)selRecord.get("systemkey"));    /** column SYSTEMKEY : systemkey */
    	 emymtDivCd.setValue((String)selRecord.get("emymtDivCd"));   /** column 고용구분코드 : emymtDivCd */
    	 
//    	 pymtYrMnth.setValue((String)selRecord.get("pymtYrMnth"));   /** column 지급년월 : pymtYrMnth */
//    	 payCd.setValue((String)selRecord.get("payCd")) ;  /** column 급여구분코드 : payCd */
//    	 payrMangDeptCd.setValue((String)selRecord.get("payrMangDeptCd"));   /** column 단위기관코드 : payrMangDeptCd */
//    	 payrSeilNum.setValue((Long)selRecord.get("payrSeilNum"));   /** column 급여일련번호 : payrSeilNum */
//     	 hanNm.setValue((String)selRecord.get("hanNm")) ;  /** column 한글성명 : hanNm */
//    	 resnRegnNum.setValue((String)selRecord.get("resnRegnNum"));   /** column 주민등록번호 : resnRegnNum */
//    	 
//    	 secRegnNum.setValue((String)selRecord.get("secRegnNum"));   /** column 주민등록번호 : secRegnNum */
//    	 
//    	 deptCd.setValue((String)selRecord.get("deptCd")) ;  /** column 부서코드 : deptCd */
//    	 deptNm.setValue((String)selRecord.get("deptNm")) ;  /** column 부서 : deptNm */
//    	 businCd.setValue((String)selRecord.get("businCd"));   /** column 사업코드 : businCd */
//    	 
//    	 typOccuCd.setValue((String)selRecord.get("typOccuCd"));   /** column 직종코드 : typOccuCd */ 
//    	 logSvcYrNumCd.setValue((String)selRecord.get("logSvcYrNumCd")) ;  /** column 근속년수코드 : logSvcYrNumCd */
//    	 logSvcYrNumNm.setValue((String)selRecord.get("logSvcYrNumNm")) ;  /** column 근속년수 : logSvcYrNumNm */
//    	 pymtTotAmnt.setValue((Long)selRecord.get("pymtTotAmnt"));   /** column 지급총액 : pymtTotAmnt */
//    	 extpyTotAmnt.setValue((Long)selRecord.get("extpyTotAmnt")) ;  /** column 수당총액 : extpyTotAmnt */
//    	 txtnTotAmnt.setValue((Long)selRecord.get("txtnTotAmnt"));   /** column 과세총액 : txtnTotAmnt */
//    	 freeDtyTotAmnt.setValue((Long)selRecord.get("freeDtyTotAmnt"));   /** column 비과세총액 : freeDtyTotAmnt */
//    	 dducTotAmnt.setValue((Long)selRecord.get("dducTotAmnt"));   /** column 공제총액 : dducTotAmnt */
//    	 txTotAmnt.setValue((Long)selRecord.get("txTotAmnt"));   /** column 세금총액 : txTotAmnt */
//    	 pernPymtSum.setValue((Long)selRecord.get("pernPymtSum")) ;  /** column 차인지급액 : pernPymtSum */
//    	 bnkCd.setValue((String)selRecord.get("bnkCd"));   /** column 은행코드 : bnkCd */
//    	 bnkNm.setValue((String)selRecord.get("bnkNm")) ;  /** column 은행코드 : bnkNm */
//    	 bnkAccuNum.setValue((String)selRecord.get("bnkAccuNum")) ;  /** column 은행계좌번호 : bnkAccuNum */
//    	 acntHodrNm.setValue((String)selRecord.get("acntHodrNm"));   /** column 예금주명 : acntHodrNm */
//    	 payDdlneDt.setValue((String)selRecord.get("payDdlneDt")) ;  /** column 급여마감일자 : payDdlneDt */
//    	 payDdlneYn.setValue((String)selRecord.get("payDdlneYn")) ;  /** column 급여마감여부 : payDdlneYn */
//    	 pymtB10100Sum.setValue((Long)selRecord.get("pymtB10100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 기본급 : pymtB10100Sum */
//         pymtT10100Sum.setValue((Long)selRecord.get("pymtT10100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 소득세 : pymtT10100Sum */
//         pymtT20100Sum.setValue((Long)selRecord.get("pymtT20100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 주민세  : pymtT20100Sum */
    	
    }
    
    @Override  
	public void reload() { //검색조건에 있는 필드 정보
			// TODO Auto-generated method stub
    	IColumnFilter filters = null;
    	payr0470DducGridPanel.getTableDef().setTableColumnFilters(filters);
    	payr0470DducGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 고용구분 
    	payr0470DducGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 지급공제구분
    	String strsrhPayExtpyGrpCd = PayrUtils.getStrValToBMMultiCombo(lsExpnAdmclExtpyDivCd,srhPayExtpyGrpCd.getValue(),"commCdNm","commCd"); 
    	payr0470DducGridPanel.getTableDef().addColumnFilter("payExtpyGrpCd", strsrhPayExtpyGrpCd, SimpleColumnFilter.OPERATOR_EQUALS); //수당그룹구분코드
    	payr0470DducGridPanel.reload();
    	
    	IColumnFilter filter = null;
    	payr0485ExtpyGridPanel.getTableDef().setTableColumnFilters(filter);
    	payr0485ExtpyGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 고용구분 
    	payr0485ExtpyGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); // 지급공제구분
    	String strPayExtpyGrpCd = PayrUtils.getStrValToBMMultiCombo(lsExpnAdmclExtpyDivCd,srhPayExtpyGrpCd.getValue(),"commCdNm","commCd"); 
    	payr0485ExtpyGridPanel.getTableDef().addColumnFilter("payExtpyGrpCd", strPayExtpyGrpCd, SimpleColumnFilter.OPERATOR_EQUALS); //수당그룹구분코드
    	payr0485ExtpyGridPanel.reload();
    	
		}

	//폼초기화 검색조건포함 
	   private void formInit() {
		   BaseModel bmInit = new BaseModel();
		  
//		   srhPayYr.setValue(lsPayYrStore.getAt(0));
//           Date today = new Date(); 
//           DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//           srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//     
//           srhPayCd.setValue(lsPayCd.getAt(0));
//           
//		   srhTypOccuCd.setValue(bmInit); //직종  
//		   srhEmymtDivCd.setValue(bmInit); //고용구분 
//		   srhPayrMangDeptCd.setValue(bmInit); //단위기관
//
//		   srhDeptCd.setValue(bmInit) ;    //부서 
//		   srhBusinCd.setValue(bmInit);    //사업
		   srhHanNm.setValue("");         //성명
		   srhResnRegnNum.setValue("");   //주민번호 
		   srhSystemkey.setValue("");   //시스템키

		   subformInit();
		   //grid init
		   payr0304GridPanel.getMsfGrid().clearData();
		  
		   actionDatabase = ActionDatabase.UPDATE;
		   
		   //급여상세정보초기화 
	   }
	   
	   private void subformInit() {
		   BaseModel bmInit = new BaseModel();
		  
		   dpobCd.setValue("");  //사업장코드
		   systemkey.setValue("");    /** column SYSTEMKEY : systemkey */
		   pymtYrMnth.setValue("");   /** column 지급년월 : pymtYrMnth */
		   payCd.setValue("") ;  /** column 급여구분코드 : payCd */
		   payrMangDeptCd.setValue("");   /** column 단위기관코드 : payrMangDeptCd */
		   payrSeilNum.setValue(0L);   /** column 급여일련번호 : payrSeilNum */
		   emymtDivCd.setValue("");   /** column 고용구분코드 : emymtDivCd */
		   hanNm.setValue("") ;  /** column 한글성명 : hanNm */
		   resnRegnNum.setValue("");   /** column 주민등록번호 : resnRegnNum */
		   secRegnNum.setValue("");   /** column 주민등록번호 : secRegnNum */
		   deptCd.setValue("") ;  /** column 부서코드 : deptCd */
		   deptNm.setValue("") ;  /** column 부서 : deptNm */
		   businCd.setValue("");   /** column 사업코드 : businCd */
		   businNm.setValue("");   /** column 사업코드 : businNm */
		   typOccuCd.setValue("");   /** column 직종코드 : typOccuCd */
		   typOccuNm.setValue("") ;  /** column 직종코드 : typOccuNm */
		   logSvcYrNumCd.setValue("") ;  /** column 근속년수코드 : logSvcYrNumCd */
		   logSvcYrNumNm.setValue("") ;  /** column 근속년수 : logSvcYrNumNm */
		   pymtTotAmnt.setValue(0L);   /** column 지급총액 : pymtTotAmnt */
		   extpyTotAmnt.setValue(0L) ;  /** column 수당총액 : extpyTotAmnt */
		   txtnTotAmnt.setValue(0L);   /** column 과세총액 : txtnTotAmnt */
		   freeDtyTotAmnt.setValue(0L);   /** column 비과세총액 : freeDtyTotAmnt */
		   dducTotAmnt.setValue(0L);   /** column 공제총액 : dducTotAmnt */
		   txTotAmnt.setValue(0L);   /** column 세금총액 : txTotAmnt */
		   pernPymtSum.setValue(0L) ;  /** column 차인지급액 : pernPymtSum */
		   bnkCd.setValue("");   /** column 은행코드 : bnkCd */
		   bnkNm.setValue("") ;  /** column 은행코드 : bnkNm */
		   bnkAccuNum.setValue("") ;  /** column 은행계좌번호 : bnkAccuNum */
		   acntHodrNm.setValue("");   /** column 예금주명 : acntHodrNm */
		   payDdlneDt.setValue("") ;  /** column 급여마감일자 : payDdlneDt */
		   payDdlneYn.setValue("") ;  /** column 급여마감여부 : payDdlneYn */
		   pymtB10100Sum.setValue(0L);   /** column 공제총액 : dducTotAmnt *//** column 기본급 : pymtB10100Sum */
	       pymtT10100Sum.setValue(0L);   /** column 공제총액 : dducTotAmnt *//** column 소득세 : pymtT10100Sum */
	       pymtT20100Sum.setValue(0L);   /** column 공제총액 : dducTotAmnt *//** column 주민세  : pymtT20100Sum */
		   
		   //grid init 
	       payr0470DducGridPanel.getMsfGrid().clearData();
		   payr0485ExtpyGridPanel.getMsfGrid().clearData();
//		   payr0307GridPanel.getMsfGrid().clearData();
		     
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

	private Payr1450 getThis() {
		return this;
	}
	   
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	   
	private void fnPopupBass0300(final String itemValue)   {
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통 
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
					if ("B021".equals(itemValue)) {
						//회계계정
						accAccCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));		//회계계정코드
						accAccNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));		//회계계정
					}else if("Y010".equals(itemValue)) {
						yrtxFreeDtyReduCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
						yrtxFreeDtyReduNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
					}
				}   
			}
		});
	}
//	//비과세감면 코드 확인 후 팝업 구현
//	private void fnPopupBass0300Y(String commCdNm)   {
//       MSFFormPanel popCom0300 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form("B021");  
//        
//        final FormBinding popBindingCom0300 = popCom0300.getFormBinding();
//        popBindingCom0300.addListener(Events.Change, new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {
//     	   
//            BaseModel mapModel = (BaseModel)be.getSource();
//            yrtxFreeDtyReduCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
//           // yrtxDontKey.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
//            }
//        });
//	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 출력항목 미선택 사용 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/   
    private void payr0485Insert(Payr0485DTO payr0485Dto) {
    	payr1450Service.payr1450Insert(payr0485Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1450(인서트오류) : " + caught)
                        , null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					payr0470DducGridPanel.reload();
					payr0485ExtpyGridPanel.reload();
				} else {
					
				}
				 
			}    		
    	});    	
  }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 출력항목 미사용
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/ 
  private void payrUpdateDelete0485Yn(Payr0485DTO payr0485Dto) {
	
  	payr1450Service.payrUpdate0485Yn(payr0485Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1450(미사용 업데이트 오류) : " + caught), null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					payr0470DducGridPanel.reload();
					payr0485ExtpyGridPanel.reload();
				} else {
					
				}
				 
			}    		
  	});  
  	payr1450Service.payrDelte0485(payr0485Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1450(미사용 삭제 오류) : " + caught), null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					payr0470DducGridPanel.reload();
					payr0485ExtpyGridPanel.reload();
				} else {
					
				}
				 
			}    		
  	}); 
}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 출력항목상세 저장
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
    private void updatePayr0485(Payr0485DTO payr0485Dto) {
    	payr1450Service.updatePayr0485(payr0485Dto, new AsyncCallback<Long>(){
			@Override 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1450(업데이트오류) : " + caught)
                        , null);
			}
			@Override
			public void onSuccess(Long result) {
				
				if (result > 0L) {
					payr0470DducGridPanel.reload();
					payr0485ExtpyGridPanel.reload();
				} else {
					
				}
				 
			}    		
    	});    	
  }
    /**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 엑셀저장 상단
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
    private void excelFileExport() {
    	HashMap<String, String> param = new HashMap<String, String>(); 
    	
    	param.put("emymtDivCd", PayrUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
    	param.put("pymtDducDivCd", PayrUtils.getSelectedComboValue(srhPymtDducDivCd, "commCd"));
    	//param.put("payCd", PayrUtils.getSelectedComboValue(srhPayCd, "commCd"));
    	
    	payr0485ExtpyGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsFilePayr1450Export.do", "extgwtFrame", param);
    }
    
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 출력항목 미선택 사용 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
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
