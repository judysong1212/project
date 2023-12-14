package com.app.exterms.resm.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0500Def;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.client.service.Resm2300Service;
import com.app.exterms.resm.client.service.Resm2300ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
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
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Resm4300  extends MSFPanel { 


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
	private ResmConstants lblPayrConst = ResmConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmPayr5300;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	   
	  
	private PrgmComBass0500Def bass0500Def = new PrgmComBass0500Def("PAYR5300"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel bass0500GridPanel;

//	private Payr0490Def payr0490Def = new Payr0490Def("PAYR5300_PAYR0490_LIST"); // 그리드 테이블 컬럼 define
//	// private MSFCustomForm msfCustomForm;
//	private MSFGridPanel payr0490GridPanel;
//
//	// 단가표작성년도 ..회계년도표기수정
//	private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();
//	private MSFGridPanel payYrGridPanel;

	
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
	private ButtonBar topPayr5300Bar;
	private Button btnPayr5300Init;
	// private Button btnPayr5300Save;
	// private Button btnPayr5300Del;
	private Button btnPayr5300Sreach;
//	private Button btnPayr5300Print;
	private Button btnPayr5300Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
     
	private ComboBox<BaseModel> srhPayYr; /** column 급여년도 : payYr */

	private ComboBox<BaseModel> srhPayrMangDeptCd; // 단위기관

	private TextField<String> srhDeptCd; // 부서코드
	private TextField<String> srhDeptNm; // 부서명
	private Button btnSrhDeptCd;
	private TextField<String> srhMangeDeptCd; // 관리부서 수정
	private TextField<String> srhMangeDeptNm; // 관리부서 수정

	private ComboBox<BaseModel> srhBusinCd; // 사업
	private ComboBox<BaseModel> srhPayCd; // 급여구분
	/** column 지급공제구분코드 : pymtDducDivCd */
	private ComboBox<BaseModel> srhPymtDducDivCd;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
	//상단값.  
	private HiddenField<String> dpobCd;  //사업장코드 
	private HiddenField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
      
	private TextField<String> businApptnYr;   /** column 사업년도 : businApptnYr */ 
    private HiddenField<String> deptCd;   /** column 부서코드 : deptCd */
    private TextField<String> deptNm;   /** column 부서코드 : deptNm */ 
    private HiddenField<String> businCd;   /** column 사업코드 : businCd */ 
    private TextField<String> businNm;   /** column 사업명 : businNm */ 
    private DateField businStdt;   /** column 사업기간시작일자 : businStdt */ 
    private DateField businEddt;   /** column 사업기간종료일자 : businEddt */
             

	private HiddenField<String> businEmymtTypOccuCd;   /** column 사업고용직종코드 : businEmymtTypOccuCd */
	private HiddenField<String> businEmymtTypOccuNm;   /** column 사업고용직종코드 : businEmymtTypOccuCd */

    private HiddenField<String> businRepbtyEmpNum;   /** column 사업담당직원번호 : businRepbtyEmpNum */
    private HiddenField<String> businRepbtyEmpNm;   /** column 사업담당직원번호 : businRepbtyEmpNum */
      
    private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */
    private HiddenField<String> payrMangDeptNm;   /** column 단위기관코드 : payrMangDeptNm */  
      
      
    //하단값.
    private HiddenField<String> payYr;  //지급년도 
      
    private TextField<String> payItemCd;   					/** column 급여항목코드 : payItemCd */
    private TextField<String> itemNm;   						/** column 항목명 : itemNm */ 
     
    private ComboBox<BaseModel> payCd;   				/** column 급여구분코드 : payCd */ 
    private ComboBox<BaseModel>  pymtDducDivCd;   	/** column 지급공제구분코드 : pymtDducDivCd */
    private ComboBox<BaseModel>  pymtDducFrmCd;   	/** column 지급공제유형코드 : pymtDducFrmCd */
    private NumberField pymtDducRate;   					/** column 지급공제율 : pymtDducRate */
    private NumberField pymtDducSum;   					/** column 지급공제액 : pymtDducSum */
    private ComboBox<BaseModel>  txtnDivCd;   			/** column 과세구분코드 : txtnDivCd */
    private NumberField freeDtyRate;   						/** column 비과세율 : freeDtyRate */
    private NumberField freeDtySum;  	 						/** column 비과세금액 : freeDtySum */
    
	private CheckBox jan;		/** column 1월 : jan */
	private CheckBox feb;		/** column 2월 : feb */
	private CheckBox mar;		/** column 3월 : mar */
	private CheckBox apr;		/** column 4월 : apr */
	private CheckBox may;	/** column 5월 : may */
	private CheckBox jun;		/** column 6월 : jun */
	private CheckBox jul;		/** column 7월 : jul */
	private CheckBox aug;		/** column 8월 : aug */
	private CheckBox sep;		/** column 9월 : sep */
	private CheckBox oct;		/** column 10월 : oct */
	private CheckBox nov;		/** column 11월 : nov */
	private CheckBox dec;		/** column 12월 : dec */
	private CheckBox chkAll;	/** column 전체체크 : chkAll */

	private NumberField rngeOrd;								/** column 정렬순서 : rngeOrd */
	private CheckBox payItemUseYn;							/** column 급여항목사용여부 : payItemUseYn */
	private DateField itemApptnBgnnDt;						/** column 항목적용시작일자 : itemApptnBgnnDt */
	private DateField itemApptnEndDt;							/** column 항목적용종료일자 : itemApptnEndDt */
	private ComboBox<BaseModel> dayMnthAmntDivCd;	/** column 일월액구분코드 : dayMnthAmntDivCd */
	private ComboBox<BaseModel> calcStdDivCd;			/** column 계산기준구분코드 : calcStdDivCd */
	private CheckBox usalyAmntYn;								/** column 통상임금여부 : usalyAmntYn */
	private TextField<String> payItemNoteCtnt;				/** column 급여항목비고내용 : payItemNoteCtnt */

	private HiddenField<Long> payrUcstDgmSeilNum;		/** column 급여단가표일련번호 : payrUcstDgmSeilNum */

	private TextField<String> calcStdFunc;					/** column 계산수식내용 : calcStdFunc */
        
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
     			//  private Boolean boolChkAuth;  
     			//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkPayr5300Auth(String authAction, ListStore<BaseModel> bm) {
		// MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중");

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
		// ----------------------------------------------------------------------
		Field<?>[] fldArrField = { srhPayrMangDeptCd, srhDeptCd, srhDeptNm,srhBusinCd };

		gwtAuthorization.formAuthFieldConfig(fldArrField);

		srhPayYr.setValue(lsPayYrStore.findModel("payYr", DateTimeFormat.getFormat("yyyy").format(new Date())));

		srhPayCd.setValue(lsPayCd.getAt(0));
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
			//  gwtAuthorization.formAuthPopConfig(plFrmPayr5300, "srhPayrMangDeptCd","",strArrDeptCd,"","srhBusinCd");
			// gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd);
			//   GWTAuthorization.formAuthConfig(plFrmPayr5300, "srhPayrMangDeptCd","","srhDeptCd","","srhBusinCd");
			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * 권한설정을 위한 콤보처리를 위한 메서드 종료
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		srhDeptCd.fireEvent(Events.Add);

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
		authMapDef.put("srhPayCd", Boolean.FALSE);

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
	    private void setPayr5300FormBinding() {
	 	 
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
	private Resm2300ServiceAsync payr5300Service = Resm2300Service.Util.getInstance();	 
	
	private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
	private ListStore<BaseModel>   lsPayYrStore = new ListStore<BaseModel>(); 
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
		   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
	private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
	private ListStore<BaseModel>  lsGdPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
	
	private ListStore<BaseModel>  lsPymtDducFrmCd = new ListStore<BaseModel>();  /** column 지급공제유형코드 : pymtDducFrmCd */
	private ListStore<BaseModel>  lsTxtnDivCd = new ListStore<BaseModel>(); /** column 과세구분코드 : txtnDivCd */
	private ListStore<BaseModel>  lsDayMnthAmntDivCd = new ListStore<BaseModel>(); /** column 일월액구분코드 : dayMnthAmntDivCd */
	private ListStore<BaseModel>  lsCalcStdDivCd = new ListStore<BaseModel>(); /** column 계산기준구분코드 : calcStdDivCd */
	 
	
	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0350DTO sysComBass0350Dto;   
	private PrgmComBass0150DTO sysComBass0150Dto;  
	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	
	private BaseModel record; 
    
	private BaseModel detailRecord; 
	
    private List<BaseModel> records;
    
	
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
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr5300Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr5300Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnPayr5300Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
	  
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
            doInsert();
            break;
        case UPDATE: 
            this.actionDatabase = ActionDatabase.UPDATE;
             savePayr5300();  
            break;
        case DELETE: 
             this.actionDatabase = ActionDatabase.DELETE;
				MessageBox.confirm("경고", "해당 지급공제항목을 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							savePayr5300();  
						}
					}
				});
            break;
        }
    }
    

    public void doInsert() {
//      if (isValid()) {
         
              
//        Payr0490DTO payr0490Dto = new Payr0490DTO();
//         
//
//        payr0490Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
//        payr0490Dto.setPayYr(MSFSharedUtils.allowNulls(businApptnYr.getValue()));   /** column 지급년도 : payYr */    
//        
//        payr0490Dto.setBusinCd(MSFSharedUtils.allowNulls(businCd.getValue()));    /** column 사업코드 : businCd */
//        payr0490Dto.setDeptCd(MSFSharedUtils.allowNulls(deptCd.getValue()));    /** column 부서코드 : deptCd */
//        payr0490Dto.setPayrUcstDgmSeilNum(0L);    /** column 급여단가표일련번호 : payrUcstDgmSeilNum */
//        payr0490Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//
//        /** EMYMT_DIV_CD 고용구분코드*/
//        payr0490Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01);  
//        payr0490Dto.setPayCd(PayGenConst.PAY_CD_01);   /** column 급여구분코드 : payCd */            
//        payr0490Dto.setPymtDducFrmCd("");   /** column 지급공제유형코드 : pymtDducFrmCd */              
//        payr0490Dto.setTxtnDivCd("");   /** column 과세구분코드 : txtnDivCd */                          
//        payr0490Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(businStdt.getValue(),"yyyyMMdd") );   /** column 항목적용시작일자 : itemApptnBgnnDt */
//        payr0490Dto.setItemApptnEndDt(GWTUtils.getStringFromDate(businEddt.getValue(),"yyyyMMdd") ) ; /** column 항목적용종료일자 : itemApptnEndDt */   
//        payr0490Dto.setDayMnthAmntDivCd("") ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
//        payr0490Dto.setCalcStdDivCd("");   /** column 계산기준구분코드 : calcStdDivCd */      
//        payr0490Dto.setUsalyAmntYn(false);   /** column 통상임금여부 : usalyAmntYn */            
//        payr0490Dto.setPayItemNoteCtnt("");   /** column 급여항목비고내용 : payItemNoteCtnt */ 
//       
//
//        /** JAN */
//        payr0490Dto.setJan(true);
//        
//        /** FEB */
//        payr0490Dto.setFeb(true);
//        
//        /** MAR */
//        payr0490Dto.setMar(true);
//        
//        /** APR */
//        payr0490Dto.setApr(true);
//        
//        /** MAY */
//        payr0490Dto.setMay(true);
//        
//        /** JUN */
//        payr0490Dto.setJun(true);
//        
//        /** JUL */
//        payr0490Dto.setJul(true);
//        
//        /** AUG */
//        payr0490Dto.setAug(true);
//        
//        /** SEP */
//        payr0490Dto.setSep(true);
//        
//        /** OCT */
//        payr0490Dto.setOct(true);
//        
//        /** NOV */
//        payr0490Dto.setNov(true);
//        
//        /** DEC */
//        payr0490Dto.setDec(true);
//        
//        
//        payr0490Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getMangeDeptCd()); 
//        payr0490Dto.setCalcStdFunc("");  
//        
//         
//        payr5300Service.activityOnPayr0490Insert(payr0490Dto,records, 
//                                  actionDatabase,
//                                  new AsyncCallback<Long>() {
//              public void onFailure(Throwable caught) {
//                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0490Insert(" + actionDatabase.name() + ") : " + caught), null);
//              }
//              public void onSuccess(Long result) { 
//                  if (result == 0) {
//                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//                              actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//                  } else {
//                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                              actionDatabase + "처리가 완료되었습니다.", null);
//                      payr0490GridPanel.reload();
//                  } 
//              } 
//          });
     // }
    }   
    
    
    private void savePayr5300() { 
        
//        if (this.actionDatabase.equals(ActionDatabase.UPDATE) ) {
//                /** column 급여항목코드 : payItemCd */    
//                if (MSFSharedUtils.paramNull(payItemCd.getValue())) {
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            "급여항목이 존재하지 않습니다.", null);
//                    return;
//                } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(payCd,"commCd"))) {
//                    /** column 급여구분코드 : payCd */ 
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            "급여구분은 필수 선택 항목입니다.", null);
//                    return;
//                } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd,"commCd"))) {
//                    /** column 지급공제구분코드 : pymtDducDivCd */  
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            "지급공제구분은 필수 선택 항목입니다.", null);
//                    return;
//                } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd,"commCd"))) {
//                    /** column 지급공제유형코드 : pymtDducFrmCd */
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            "지급공제유형은 필수 선택 항목입니다.", null);
//                    return;
//                } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(txtnDivCd,"commCd"))) {
//                    /** column 과세구분코드 : txtnDivCd */ 
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            "과세구분은 필수 선택 항목입니다.", null);
//                    return;
//                } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(calcStdDivCd,"commCd"))) {
//                    /** column 계산기준구분코드 : calcStdDivCd */ 
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            "계산기준구분은 필수 선택 항목입니다.", null);
//                    return;
//               } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd,"commCd"))) {
//                   /** column 일월액구분코드 : dayMnthAmntDivCd */
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                        "일월액구분은 필수 선택 항목입니다.", null);
//                   return;
//               }
//        }
//        Payr0490DTO payr0490Dto = new Payr0490DTO();
//        
//        payr0490Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));
//        payr0490Dto.setPayYr(MSFSharedUtils.allowNulls(payYr.getValue()));   /** column 지급년도 : payYr */   
//
//        payr0490Dto.setBusinCd(MSFSharedUtils.allowNulls(businCd.getValue()));    /** column 사업코드 : businCd */
//        payr0490Dto.setDeptCd(MSFSharedUtils.allowNulls(deptCd.getValue()));    /** column 부서코드 : deptCd */ 
//        payr0490Dto.setPayrMangDeptCd(("".equals(MSFSharedUtils.allowNulls(payrMangDeptCd.getValue())) ? MSFMainApp.get().getUser().getPayrMangDeptCd() : MSFSharedUtils.allowNulls(payrMangDeptCd.getValue())));    /** column 급여관리부서코드 : payrMangDeptCd */
//        
//        payr0490Dto.setPayItemCd(MSFSharedUtils.allowNulls(payItemCd.getValue()));   /** column 급여항목코드 : payItemCd */    
//        payr0490Dto.setPayrUcstDgmSeilNum(payrUcstDgmSeilNum.getValue());   /** column 급여단가표일련번호 : payrUcstDgmSeilNum */
//        payr0490Dto.setItemNm(MSFSharedUtils.allowNulls(itemNm.getValue()));   /** column 항목명 : itemNm */                                         
//        payr0490Dto.setPayCd(MSFSharedUtils.getSelectedComboValue(payCd,"commCd"));   /** column 급여구분코드 : payCd */                                  
//        payr0490Dto.setPymtDducDivCd(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd,"commCd"));   /** column 지급공제구분코드 : pymtDducDivCd */              
//        payr0490Dto.setPymtDducFrmCd(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd,"commCd"));   /** column 지급공제유형코드 : pymtDducFrmCd */              
//        payr0490Dto.setPymtDducRate((Double)pymtDducRate.getValue());   /** column 지급공제율 : pymtDducRate */                      
//        payr0490Dto.setPymtDducSum((Long)pymtDducSum.getValue());   /** column 지급공제액 : pymtDducSum */                        
//        payr0490Dto.setTxtnDivCd(MSFSharedUtils.getSelectedComboValue(txtnDivCd,"commCd"));   /** column 과세구분코드 : txtnDivCd */                          
//        payr0490Dto.setFreeDtyRate((Double)freeDtyRate.getValue());   /** column 비과세율 : freeDtyRate */                          
//        payr0490Dto.setFreeDtySum((Long)freeDtySum.getValue());   /** column 비과세금액 : freeDtySum */   
//        payr0490Dto.setRngeOrd((Long)rngeOrd.getValue());   /** column 정렬순서 : rngeOrd */                        
//        payr0490Dto.setPayItemUseYn(payItemUseYn.getValue());   /** column 급여항목사용여부 : payItemUseYn */      
//        payr0490Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(itemApptnBgnnDt.getValue(),"yyyyMMdd") );   /** column 항목적용시작일자 : itemApptnBgnnDt */
//        payr0490Dto.setItemApptnEndDt(GWTUtils.getStringFromDate(itemApptnEndDt.getValue(),"yyyyMMdd") ) ; /** column 항목적용종료일자 : itemApptnEndDt */   
//        payr0490Dto.setDayMnthAmntDivCd(MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd,"commCd")) ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
//        payr0490Dto.setCalcStdDivCd(MSFSharedUtils.getSelectedComboValue(calcStdDivCd,"commCd"));   /** column 계산기준구분코드 : calcStdDivCd */      
//        payr0490Dto.setUsalyAmntYn(usalyAmntYn.getValue());   /** column 통상임금여부 : usalyAmntYn */            
//        payr0490Dto.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(payItemNoteCtnt.getValue()));   /** column 급여항목비고내용 : payItemNoteCtnt */ 
//        payr0490Dto.setCalcStdFunc(MSFSharedUtils.allowNulls(calcStdFunc.getValue()));   ;   /** column 계산수식내용 : calcStdFunc */ 
//        
//        /** JAN */
//        payr0490Dto.setJan(jan.getValue());
//        
//        /** FEB */
//        payr0490Dto.setFeb(feb.getValue());
//        
//        /** MAR */
//        payr0490Dto.setMar(mar.getValue());
//        
//        /** APR */
//        payr0490Dto.setApr(apr.getValue());
//        
//        /** MAY */
//        payr0490Dto.setMay(may.getValue());
//        
//        /** JUN */
//        payr0490Dto.setJun(jun.getValue());
//        
//        /** JUL */
//        payr0490Dto.setJul(jul.getValue());
//        
//        /** AUG */
//        payr0490Dto.setAug(aug.getValue());
//        
//        /** SEP */
//        payr0490Dto.setSep(sep.getValue());
//        
//        /** OCT */
//        payr0490Dto.setOct(oct.getValue());
//        
//        /** NOV */
//        payr0490Dto.setNov(nov.getValue());
//        
//        /** DEC */
//        payr0490Dto.setDec(dec.getValue());
//        
//        
//        payr5300Service.activityOnPayr5300(payr0490Dto, actionDatabase, new AsyncCallback<Long>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5300(): "+caught), null);
//            }
//
//            public void onSuccess(Long result) { 
//                if (result == 0) {
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//                            actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//                } else {
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                            actionDatabase + "처리가 완료되었습니다.", null);
//                    payr0490GridPanel.reload();
//                } 
//             } 
//        }); 

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
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    **/
    
	private void RdaPrint(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
 	String searchParam = "";
//		
//		String name = searchName.getValue() == null ? "" : searchName.getValue();
//		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
//		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
//		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
//		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
//		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
//		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
//		
//		serarchParam += "["+name+"]";
//		serarchParam += "["+resn+"]";
//		serarchParam += "["+hdofcCodtnCd+"]";
//		serarchParam += "[]";
//		//serarchParam += "["+manageDeptCd+"]";
//		serarchParam += "["+deptCd+"]";
//		serarchParam += "["+emymtDivCd+"]";
//		serarchParam += "["+typOccuCd+"]";
		
 
			String strParam = "/rp " + searchParam ; 
		
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

	}
	
	
	
	//rex 

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
//	    getAriaSupport().setPresentation(true);
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr5300Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createStandardForm();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){

				 
				 //콤보 권한초기화
				   initLoad(); 
								
			    getAriaSupport().setPresentation(true);
			    detailTp = XTemplate.create(getDetailTemplate());
			    
			   // formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPayr5300Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createStandardForm();    //기본정보필드  
			    vp.setSize("1010px", "700px");
			    
			    /**
			     * Create the relations 
			     */
//				  final RelationDef  relBass0500Def = new RelationDef(bass0500Def,false);
//				  relBass0500Def.addJoinDef("dpobCd", "dpobCd"); 
//				  relBass0500Def.addJoinDef("payYr", "payYr");
//				  relBass0500Def.addJoinDef("deptCd", "deptCd");
//				  relBass0500Def.addJoinDef("businCd", "businCd");
//				  relBass0500Def.addJoinDef("payrUcstDgmSeilNum", "payrUcstDgmSeilNum");
//				  relBass0500Def.setLinkedObject(bass0500GridPanel);
//				  payr0490Def.addRelation(relBass0500Def); 
//				
//
//			      // DETAILS 
//			      final Grid bass0500Grid = bass0500GridPanel.getMsfGrid().getGrid();
//			      bass0500Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
//			         public void handleEvent(BaseEvent be) {  
//			       	  if (bass0500GridPanel.getCurrentlySelectedItem() != null) { 
//			       		
//			       	   setRecord(bass0500GridPanel.getCurrentlySelectedItem());
//			       	   
//			       		payr0490Def.synchronizeGridDetail(
//			       				bass0500GridPanel.getCurrentlySelectedItem(),
//			       		payr0490GridPanel ); 
//			       	 
//			       		fnFormTextMapping(record);
//					  //  payr0490GridPanel.reload();
//					            
//			       		
//			       	   }
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
	  public Resm4300() { 
		   
			setSize("1010px", "700px");  
	  } 
	
	  public Resm4300(String txtForm) {
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
	  private void createPayr5300Form() {
		  
			plFrmPayr5300 = new FormPanel();
			plFrmPayr5300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Resm2300());
		//	plFrmPayr5300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 지급공제단가관리");
			plFrmPayr5300.setIcon(MSFMainApp.ICONS.text());
			plFrmPayr5300.setBodyStyleName("pad-text");
			plFrmPayr5300.setPadding(2);
			plFrmPayr5300.setFrame(true); 
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblPayrConst.title_Resm2300(),"RESM2300");
					}
				});
			plFrmPayr5300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr5300.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

			

			 LayoutContainer layoutContainer = new LayoutContainer();
			  layoutContainer.setLayout(new ColumnLayout());
			  
			  LayoutContainer layoutContainer_1 = new LayoutContainer(); 
			  layoutContainer_1.setLayout(new FlowLayout());
			  
			  ButtonBar buttonBar_1 = new ButtonBar();
			  
			  Button btnNewButton_2 = new Button("");
			//  btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
			  buttonBar_1.add(btnNewButton_2);
			  layoutContainer_1.add(buttonBar_1);
			  layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			  layoutContainer_1.setBorders(false);
			  
			  LayoutContainer layoutContainer_2 = new LayoutContainer();
			  layoutContainer_2.setLayout(new FlowLayout());
			  
			   
			   topPayr5300Bar = new ButtonBar();    
			   layoutContainer_2.add(topPayr5300Bar);
			   topPayr5300Bar.setAlignment(HorizontalAlignment.RIGHT);
			 
		  	
			   btnPayr5300Init = new Button("초기화");  
			   btnPayr5300Init.setIcon(MSFMainApp.ICONS.new16());
			  	topPayr5300Bar.add(btnPayr5300Init);
			  	btnPayr5300Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		      });	
//			  	topBtn = new Button("삭제");  
//			  	topBtn.setIcon(MSFMainApp.ICONS.delete16());
//			  	topPayr5300Bar.add(topBtn); 
			  	 
			  	btnPayr5300Sreach = new Button("조회"); 
			  	btnPayr5300Sreach.setIcon(MSFMainApp.ICONS.search16());
			  	topPayr5300Bar.add(btnPayr5300Sreach);
			  	btnPayr5300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
				
//			  	btnPayr5300Print = new Button("인쇄"); 
//			  	btnPayr5300Print.setIcon(MSFMainApp.ICONS.print16()); 
//			  	topPayr5300Bar.add(btnPayr5300Print);  
//			  	btnPayr5300Print.addListener(Events.Select, new Listener<ButtonEvent>() {
//		    		public void handleEvent(ButtonEvent e) {
//		    			RdaPrint("PAYRT5300") ;
//		    			 
//		    		}
//		    	});
//				
			  	btnPayr5300Excel = new Button("엑셀"); 
			  	btnPayr5300Excel.setIcon(MSFMainApp.ICONS.excel16()); 
			  	topPayr5300Bar.add(btnPayr5300Excel);  
			  	btnPayr5300Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			exportExcel(); 
		    		}
		    	});
		    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_2.setBorders(false); 
		    layoutContainer.setBorders(false);
		  	
		    plFrmPayr5300.add(layoutContainer);    
		  	   
			//파일업로드 처리
			plFrmPayr5300.setAction("bizform");
			plFrmPayr5300.setEncoding(Encoding.MULTIPART);
			plFrmPayr5300.setMethod(Method.POST);
			 
			vp.add(plFrmPayr5300);
			plFrmPayr5300.setSize("990px", "680px");
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
	 
	 sysComBass0300Dto = new PrgmComBass0300DTO();
	 sysComBass0350Dto = new PrgmComBass0350DTO(); 
	 sysComBass0150Dto = new PrgmComBass0150DTO();
	 sysComBass0400Dto = new PrgmComBass0400DTO();
	 sysComBass0500Dto = new PrgmComBass0500DTO();
	 
	 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	 
	 
	 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	 sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
	 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	   
	 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	   
	 sysComBass0400Dto.setDeptDspyYn("Y");
     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	 //--------------------부서 불러 오는 함수 ------------------------------------------------
	 lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
	//--------------------부서 불러 오는 함수 ------------------------------------------------
     /**
      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      * 년도 콤보박스 처리  시작
      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
      */
     		    ContentPanel payYrGrid = new ContentPanel();  
     		     payYrGrid.setVisible(false);
     		    
     		    //년도 콤보처리 
//     		   payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
//     		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//     			       public void handleEvent(ComponentEvent be) {  
//     			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//     			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//     			        	  
//     			          }  
//     			        });  
//     			       
//     			      }  
//     			    });  
//     	  
//     		payYrGrid.add(payYrGridPanel); 
     		plFrmPayr5300.add(payYrGrid);
     	    
     	     
	  
	  plFrmPayr5300.setLayout(new FlowLayout());
	    
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
	    

        LayoutContainer layoutContainer_8 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_8.setLayout(frmlytSch);
        
        /** column 지급년 : payYr */
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
        srhPayYr.setFieldLabel("지급년도");
        lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
 
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr5300Auth("srhPayYr", lsPayYrStore ); 
              	 }
              
            }
        });    
        srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
           BaseModel bmPayYr =  se.getSelectedItem(); 
           if (bmPayYr != null) {
              sysComBass0500Dto.setDeptCd(srhDeptCd.getValue());
              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
              //--------------------사업 불러 오는 함수 -------------------------------------------------
               lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
              //--------------------사업 불러 오는 함수 -------------------------------------------------
               srhBusinCd.setStore(lsBusinCd);
               srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                   public void handleEvent(StoreEvent<BaseModel> be) {  
                     //  srhBusinCd.setValue(lsBusinCd.getAt(0));  
                   }
               });    
           
           }       
          } 
      });    
        layoutContainer_8.add(srhPayYr, new FormData("100%"));
        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
        layoutContainer_8.setBorders(false);
        
	    LayoutContainer layoutContainer_14 = new LayoutContainer();
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
		                	checkPayr5300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd ); 
              	 }
              
            }
        });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
  	    	} 
  	    });
	    layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
	   
	    layoutContainer_14.setBorders(false);
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
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
            	checkPayr5300Auth("srhPayCd",lsPayCd); 
               
            }
        });    
	    layoutContainer_1.add(srhPayCd, new FormData("100%"));
	    lcSchCol.add(layoutContainer_1);
	    layoutContainer_1.setBorders(false);
	 
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(50); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_2.setLayout(frmlytSch);
        
//        srhDeptCd = new ComboBox<BaseModel>();
//        srhDeptCd.setName("srhDeptCd");
//        srhDeptCd.setForceSelection(true);
//        srhDeptCd.setMinChars(1);
//        srhDeptCd.setDisplayField("deptNmRtchnt");
//        srhDeptCd.setValueField("deptCd");
//        srhDeptCd.setTriggerAction(TriggerAction.ALL);
//        srhDeptCd.setEmptyText("--부서선택--");
//        srhDeptCd.setSelectOnFocus(true); 
//        srhDeptCd.setReadOnly(false);
//        srhDeptCd.setEnabled(true); 
//        srhDeptCd.setStore(lsDeptCd );
//        srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
//        srhDeptCd.setFieldLabel("부서");
//        srhDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//                GWTAuthorization.formAuthConfig(plFrmPayr5300, "srhPayrMangDeptCd","","srhDeptCd","","srhBusinCd");
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//                
//            }
//        });    
//        srhDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//             BaseModel bmPayCd =  se.getSelectedItem(); 
//             if (bmPayCd != null) {
//                sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd"));
//                sysComBass0500Dto.setBusinApptnYr((String)srhPayYr.getValue().get("payYr"));
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                 lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                 srhBusinCd.setStore(lsBusinCd);
//                 srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                     public void handleEvent(StoreEvent<BaseModel> be) {  
//                         srhBusinCd.setValue(lsBusinCd.getAt(0));  
//                     }
//                 });    
//             
//             }       
//            } 
//        });
        
        //검색 소속부서 코드 처리  
        LayoutContainer lccmlcDeptNm = new LayoutContainer();
        lccmlcDeptNm.setLayout(new ColumnLayout());
           //부서 
        srhDeptCd = new TextField<String>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setVisible(false);
        
        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
            @Override
            public void handleEvent(BaseEvent be) { 
              if(srhDeptCd.getValue() != null){ 
                 
                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
                  
                    //--------------------사업 불러 오는 함수 -------------------------------------------------
                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                     //--------------------사업 불러 오는 함수 -------------------------------------------------
                      srhBusinCd.setStore(lsBusinCd); 
                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                          public void handleEvent(StoreEvent<BaseModel> be) {  
                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                          }
                      });    
                 
              } 
            }
         });
        plFrmPayr5300.add(srhDeptCd);
        srhMangeDeptCd = new TextField<String>();
        srhMangeDeptCd.setName("srhMangeDeptCd");
        srhMangeDeptCd.setVisible(false);
        plFrmPayr5300.add(srhMangeDeptCd);
        srhMangeDeptNm = new TextField<String>();
        srhMangeDeptNm.setName("srhMangeDeptNm");
        srhMangeDeptNm.setVisible(false);
        plFrmPayr5300.add(srhMangeDeptNm);
  
         LayoutContainer lcDeptNm = new LayoutContainer(); 
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(50);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         lcDeptNm.setLayout(frmlytSch);
      
         srhDeptNm = new TextField<String>();
         srhDeptNm.setName("srhDeptNm");
         srhDeptNm.setFieldLabel("부서");  
         srhDeptNm.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
         srhDeptNm.setEnabled(gwtExtAuth.getEnableDeptCd());
         srhDeptNm.addKeyListener(new KeyListener() {
        	 @Override
              public void componentKeyDown(ComponentEvent event) {
                 
                  if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
                      srhDeptCd.setValue("");
                      srhMangeDeptCd.setValue("");
                  }
                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                     // if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
                          srhDeptCd.setValue("");
                          srhMangeDeptCd.setValue("");
                     // }
                      fnPopupCommP140(srhDeptNm.getValue());
                  }
                  super.componentKeyDown(event); 
              }
          });
         
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
          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
          
           btnSrhDeptCd = new Button();
           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
           btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
               public void handleEvent(ButtonEvent e) { 
                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
                       srhDeptCd.setValue("");
                       srhMangeDeptCd.setValue("");
                   }
                   fnPopupCommP140(srhDeptNm.getValue()); 
               }
           });
            
           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
             
           
        layoutContainer_2.add(lccmlcDeptNm, new FormData("100%")); 
        layoutContainer_2.setBorders(false);
        
        LayoutContainer layoutContainer_3 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(50); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_3.setLayout(frmlytSch);
        
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
        layoutContainer_3.add(srhBusinCd, new FormData("100%")); 
        layoutContainer_3.setBorders(false); 
	    
	    
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	     
	    
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15)); 
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
	    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	    lcSchCol.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	    lcSchCol.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	    
	    
	    
	    FieldSet fieldSet2 = new FieldSet();  
	    fieldSet2.setHeadingHtml("");  
	    
	    ButtonBar topPayr5300Bar_2 = new ButtonBar();
	    
	    Button btnTrnrBusin = new Button("이전사업지급항목이관");
	    btnTrnrBusin.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
//				PayrP530001 payrP530011Form = new PayrP530001(ActionDatabase.READ, getThis());   
//			    
//				MSFFormWindows msFwPayrP53001 = new MSFFormWindows("이전사업이관", payrP530011Form, "닫기", "700px", "350px", true);
//				msFwPayrP53001.show();
//				payrP530011Form.setMSFFormWindows(msFwPayrP53001);
				
			}
		});
	    topPayr5300Bar_2.add(btnTrnrBusin);
	    
	    Button btnTrnrBusin2 = new Button("단가항목복사");
	    btnTrnrBusin2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
//				PayrP530002 payrP530002Form = new PayrP530002(ActionDatabase.READ, getThis());   
//			    
//				MSFFormWindows msFwPayrP53002 = new MSFFormWindows("단가항목복사", payrP530002Form, "닫기", "900px", "600px", true);
//				msFwPayrP53002.show();
//				payrP530002Form.setMSFFormWindows(msFwPayrP53002);
				
			}
		});
	    topPayr5300Bar_2.add(btnTrnrBusin2);
	    fieldSet2.add(topPayr5300Bar_2);
	    
	    
//	    LayoutContainer layoutContainer = new LayoutContainer();
//	    layoutContainer.setLayout(new ColumnLayout());
//	    
//	   
//	    fieldSet.add(layoutContainer);
//	    layoutContainer.setBorders(false);
	      
		
	    plFrmPayr5300.add(fieldSet); 
	    plFrmPayr5300.add(fieldSet2); 
	//vp.add(panel);   
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
     
        dpobCd = new HiddenField<String>();              //사업장코드 
        emymtDivCd = new HiddenField<String>();          /** column 고용구분코드 : emymtDivCd */
        payrUcstDgmSeilNum =  new HiddenField<Long>(); /** column 급여단가표일련번호 : payrUcstDgmSeilNum */
       
       
        deptCd = new HiddenField<String>();   /** column 부서코드 : deptCd */
        businCd = new HiddenField<String>();   /** column 사업코드 : businCd */ 

        businEmymtTypOccuCd = new HiddenField<String>();   /** column 사업고용직종코드 : businEmymtTypOccuCd */
        businEmymtTypOccuNm = new HiddenField<String>();   /** column 사업고용직종 : businEmymtTypOccuCd */
        businRepbtyEmpNum = new HiddenField<String>();   /** column 사업담당직원번호 : businRepbtyEmpNum */
        businRepbtyEmpNm = new HiddenField<String>();   /** column 사업담당직원 : businRepbtyEmpNm */
        payrMangDeptCd = new HiddenField<String>();   /** column 단위기관코드 : payrMangDeptCd */
        payrMangDeptNm = new HiddenField<String>();   /** column 단위기관 : payrMangDeptNm */  
      
        
        payYr = new HiddenField<String>();   /** column 지급년도  : payYr */ 
        
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_11 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
//		fldstNewFieldset.setSize(330,330);
		fldstNewFieldset.setSize(330,290);
		
		
		layoutContainer_11.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("사업정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_11.setBorders(false);
		
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
//		fldstNewFieldset_1.setSize(624, 330);
		fldstNewFieldset_1.setSize(624, 290);

		layoutContainer_21.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("지급공제항목설정");
		fldstNewFieldset_1.setCollapsible(false);
		
		fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
		
		LayoutContainer layoutContainer_31 = new LayoutContainer();
		layoutContainer_31.setLayout(new ColumnLayout());
		
		FieldSet fldstNewFieldset_4 = new FieldSet();
//		fldstNewFieldset_4.setSize(600, 255);
		fldstNewFieldset_4.setSize(600, 215);
		fldstNewFieldset_4.setCollapsible(false);
		
		LayoutContainer layoutContainer_41 = new LayoutContainer(new FitLayout());
		layoutContainer_41.add(payrLeft01(),new FormData("100%"));
		fldstNewFieldset_4.add(layoutContainer_41,new FormData("100%"));
		layoutContainer_41.setBorders(false);
		layoutContainer_31.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		fldstNewFieldset_4.setHeadingHtml("지급공제항목");
		fldstNewFieldset_1.add(layoutContainer_31);
		layoutContainer_31.setBorders(false);
		 
		
		layoutContainer.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_21.setBorders(false);
		   
		plFrmPayr5300.add(layoutContainer);
		layoutContainer.setBorders(false); 
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new FlowLayout());
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(960, 190);
		layoutContainer_3.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("지급공제상세정보");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "20px");
		
		fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
		
		plFrmPayr5300.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);
		    
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
 private LayoutContainer occupationalRTop() {
	 
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
	 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(600, 60);  
	   
	   LayoutContainer lytCtr01 = new LayoutContainer();
	   lytCtr01.setLayout(new FlowLayout());
	   
	   LayoutContainer layoutContainer_12 = new LayoutContainer();
	   layoutContainer_12.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_13 = new LayoutContainer();
	   FormLayout frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(60); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_13.setLayout(frmlytStd);
	   
	   businApptnYr = new TextField<String>();
	   businApptnYr.setReadOnly(true);
	   layoutContainer_13.add(businApptnYr, new FormData("100%"));
	   businApptnYr.setFieldLabel("사업년도");
	   layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	   layoutContainer_13.setBorders(false);
	   
	   LayoutContainer layoutContainer = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(60); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer.setLayout(frmlytStd);
	   
	   deptNm = new TextField<String>();
	   deptNm.setReadOnly(true);
	   layoutContainer.add(deptNm, new FormData("100%"));
	   deptNm.setFieldLabel("부서");
	   layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	   layoutContainer.setBorders(false);
	   
	   LayoutContainer layoutContainer_1 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(60); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_1.setLayout(frmlytStd);
	   
	   businNm = new TextField<String>();
	   businNm.setReadOnly(true);
	   layoutContainer_1.add(businNm, new FormData("100%"));
	   businNm.setFieldLabel("사업");
	   layoutContainer_12.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	   layoutContainer_1.setBorders(false);
	   lytCtr01.add(layoutContainer_12);
	   layoutContainer_12.setBorders(false);
	   
	   LayoutContainer layoutContainer_2 = new LayoutContainer();
	   layoutContainer_2.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_3 = new LayoutContainer();
	   layoutContainer_3.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_4 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(60); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_4.setLayout(frmlytStd);
	   
	   businStdt = new DateField();
	   businStdt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	   layoutContainer_4.add(businStdt, new FormData("100%"));
	   businStdt.setFieldLabel("사업기간");
	   businStdt.setReadOnly(true);
	   layoutContainer_3.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
	   layoutContainer_4.setBorders(false);
	   
	   LayoutContainer layoutContainer_5 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(10); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT); 
	   layoutContainer_5.setLayout(frmlytStd);
	   
	   businEddt = new DateField();
	   businEddt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	   businEddt.setLabelSeparator("~");
	   businEddt.setReadOnly(true);
	   layoutContainer_5.add(businEddt, new FormData("100%"));
	   layoutContainer_3.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	   layoutContainer_5.setBorders(false);
	   layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	   layoutContainer_3.setBorders(false);
	   lytCtr01.add(layoutContainer_2);
	   layoutContainer_2.setBorders(false);
	   cp01.add(lytCtr01); 
		 
	    
	   lcTabFormLayer.add(cp01); 
	      
	   return lcTabFormLayer;
	 
}

 private LayoutContainer occupationalRBottom() {
	   

     LayoutContainer lcTabFormLayer = new LayoutContainer();

	    
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FlowLayout());      
	   cp01.setSize(955, 167);
	   
	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {   
	         //update
	          actionDatabase = ActionDatabase.UPDATE;
              doAction(ActionDatabase.UPDATE);
	      }   
	    }));  
	    
	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
	 	      @Override  
	 	      public void componentSelected(ButtonEvent ce) {   
	 	        //선택된 항목을 삭제한다. 서브데이터 존재여부를 확인 한후 삭제처리.  
	 	         actionDatabase = ActionDatabase.DELETE;
	 	         doAction(ActionDatabase.DELETE);
	 	         
	 	      }   
	 	    }));
	     
	    LayoutContainer layoutContainer = new LayoutContainer();
	    layoutContainer.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    FormLayout frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_1.setLayout(frmlytStd);
	    
	    payItemCd = new TextField<String>();
	    layoutContainer_1.add(payItemCd, new FormData("100%"));
	    payItemCd.setFieldLabel("항 목");
	    layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_1.setBorders(false);
	    
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(5); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_2.setLayout(frmlytStd);
	    
	    itemNm = new TextField<String>();
	    layoutContainer_2.add(itemNm, new FormData("100%"));
	    itemNm.setHideLabel(true);
	    layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_2.setBorders(false);
	    
	    LayoutContainer layoutContainer_3 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
	    frmlytStd.setLabelWidth(90); 
	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_3.setLayout(frmlytStd);
	    
	    payCd =  new ComboBox<BaseModel>(); 
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
	    layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_3.setBorders(false);
	    
	    LayoutContainer layoutContainer_4 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_4.setLayout(frmlytStd);
	    

	     //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	     sysComBass0300Dto.setRpsttvCd("B019");  //급여게산기준코드 
	     lsCalcStdDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	       
	    calcStdDivCd =  new ComboBox<BaseModel>(); 
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
	    layoutContainer_4.add(calcStdDivCd, new FormData("100%"));
	    layoutContainer.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	    layoutContainer_4.setBorders(false);
	    
	    LayoutContainer layoutContainer_5 = new LayoutContainer();
	    layoutContainer_5.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_9 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_9.setLayout(frmlytStd);
	    
	    usalyAmntYn = new CheckBox();
	    layoutContainer_9.add(usalyAmntYn, new FormData("100%"));
        usalyAmntYn.setBoxLabel("통상임금");
        usalyAmntYn.setHideLabel(true);
	    
	    layoutContainer_5.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_9.setBorders(false);
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_10.setLayout(frmlytStd);
	    
	    /** column 급여항목사용여부 : payItemUseYn */
	    payItemUseYn = new CheckBox();
	    layoutContainer_10.add(payItemUseYn, new FormData("100%"));
	    payItemUseYn.setBoxLabel("사용여부");
	    payItemUseYn.setHideLabel(true);
	    layoutContainer_5.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_10.setBorders(false);
	    layoutContainer.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	    layoutContainer_5.setBorders(false);
	    cp01.add(layoutContainer);
	    layoutContainer.setBorders(false);
	    
	    
	    LayoutContainer layoutContainer02 = new LayoutContainer();
	   layoutContainer02.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_11 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_11.setLayout(frmlytStd);
	    

        //--------------------공통 코드 불러 오는 함수 -------------------------------------------
        sysComBass0300Dto.setRpsttvCd("B008");  //지급공제구분코드  
        lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
          
        
	    pymtDducDivCd =  new ComboBox<BaseModel>(); 
	    pymtDducDivCd.setForceSelection(true);
	    pymtDducDivCd.setMinChars(1);
	    pymtDducDivCd.setDisplayField("commCdNm");
	    pymtDducDivCd.setValueField("commCd");
	    pymtDducDivCd.setTriggerAction(TriggerAction.ALL);
	    pymtDducDivCd.setEmptyText("--지급공제선택--");
        pymtDducDivCd.setSelectOnFocus(true); 
        pymtDducDivCd.setReadOnly(false);
        pymtDducDivCd.setEnabled(true); 
        pymtDducDivCd.setStore(lsPymtDducDivCd);
        pymtDducDivCd.setFieldLabel("지급(공제)구분");
	    layoutContainer_11.add(pymtDducDivCd, new FormData("100%"));
	    layoutContainer02.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_11.setBorders(false);
	    
	    LayoutContainer layoutContainer_21 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
	    frmlytStd.setLabelWidth(90); 
	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_21.setLayout(frmlytStd);
	     

        //--------------------공통 코드 불러 오는 함수 -------------------------------------------
        sysComBass0300Dto.setRpsttvCd("B017");  //지급공제유형코드  
        lsPymtDducFrmCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
           
        
	    pymtDducFrmCd =  new ComboBox<BaseModel>(); 
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
	    layoutContainer02.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_21.setBorders(false);
	    
	    LayoutContainer layoutContainer_31 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_31.setLayout(frmlytStd);
	    
	    pymtDducSum = new NumberField();
	    pymtDducSum.setAllowDecimals(true); 
	    pymtDducSum.setPropertyEditorType(Long.class); 
	    pymtDducSum.setFormat(NumberFormat.getDecimalFormat());
	    layoutContainer_31.add(pymtDducSum, new FormData("100%"));
	    pymtDducSum.setFieldLabel("지급(공제)금액");
	   layoutContainer02.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_31.setBorders(false);
	    
	    LayoutContainer layoutContainer_41 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_41.setLayout(frmlytStd);
	    
	    pymtDducRate = new NumberField();
	    pymtDducRate.setAllowDecimals(true); 
	    pymtDducRate.setFormat(NumberFormat.getDecimalFormat());
	    layoutContainer_41.add(pymtDducRate, new FormData("100%"));
	    pymtDducRate.setFieldLabel("지급(공제)율");
	    layoutContainer02.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	    layoutContainer_41.setBorders(false);
	    
	    LayoutContainer layoutContainer_6 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_6.setLayout(frmlytStd);
	    

        //--------------------공통 코드 불러 오는 함수 -------------------------------------------
        sysComBass0300Dto.setRpsttvCd("B016");  //구분  
        lsDayMnthAmntDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
           
        
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
          
	    layoutContainer_6.add(dayMnthAmntDivCd, new FormData("100%"));
	
	    layoutContainer02.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	    layoutContainer_6.setBorders(false);
	    cp01.add(layoutContainer02);
	   layoutContainer02.setBorders(false);
	   
	   
	   LayoutContainer layoutContainer03 = new LayoutContainer();
	   layoutContainer03.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_12 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
	    frmlytStd.setLabelWidth(90); 
	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_12.setLayout(frmlytStd);
	    
	    //--------------------공통 코드 불러 오는 함수 -------------------------------------------
        sysComBass0300Dto.setRpsttvCd("B005");  //과세구분  
        lsTxtnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
           
        
        txtnDivCd =  new ComboBox<BaseModel>(); 
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
	    layoutContainer03.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_12.setBorders(false);
	    
	    LayoutContainer layoutContainer_22 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
	    frmlytStd.setLabelWidth(90); 
	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_22.setLayout(frmlytStd);
	    
	    freeDtySum = new NumberField();
	    freeDtySum.setAllowDecimals(true); 
	    freeDtySum.setPropertyEditorType(Long.class); 
	    freeDtySum.setFormat(NumberFormat.getDecimalFormat());
	    layoutContainer_22.add(freeDtySum, new FormData("100%"));
	    freeDtySum.setFieldLabel("비과세금액");
	   layoutContainer03.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_22.setBorders(false);
	    
	    LayoutContainer layoutContainer_32 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
	    frmlytStd.setLabelWidth(90); 
	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_32.setLayout(frmlytStd);
	    
	    freeDtyRate = new NumberField();
	    freeDtyRate.setAllowDecimals(true); 
	    freeDtyRate.setFormat(NumberFormat.getDecimalFormat());
	    layoutContainer_32.add(freeDtyRate, new FormData("100%"));
	    freeDtyRate.setFieldLabel("비과세율");
	    layoutContainer03.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    layoutContainer_32.setBorders(false);
	    
	    LayoutContainer layoutContainer_42 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_42.setLayout(frmlytStd);
	     
	    itemApptnBgnnDt = new DateField();
	    itemApptnBgnnDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	    layoutContainer_42.add(itemApptnBgnnDt, new FormData("100%"));
	    itemApptnBgnnDt.setFieldLabel("시작일자");
	     
	    layoutContainer03.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	    layoutContainer_42.setBorders(false);
	    
	    LayoutContainer layoutContainer_7 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_7.setLayout(frmlytStd);
	    
	    
	    itemApptnEndDt = new DateField();
	    itemApptnEndDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	    layoutContainer_7.add(itemApptnEndDt, new FormData("100%"));
        itemApptnEndDt.setFieldLabel("종료일자");
	    
	    layoutContainer03.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	    layoutContainer_7.setBorders(false);
	    cp01.add(layoutContainer03);
	    layoutContainer03.setBorders(false);
	    
	    
	    LayoutContainer layoutContainer04 = new LayoutContainer();
	       layoutContainer04.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_13 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(90); 
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
	    layoutContainer04.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
	    layoutContainer_13.setBorders(false);
	  
	    LayoutContainer layoutContainer_43 = new LayoutContainer();
	    frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(40); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	    layoutContainer_43.setLayout(frmlytStd);
	    

        rngeOrd = new NumberField();
        rngeOrd.setAllowDecimals(true); 
        rngeOrd.setPropertyEditorType(Long.class); 
        rngeOrd.setFormat(NumberFormat.getDecimalFormat());
        rngeOrd.setFieldLabel("순서");
        
	    layoutContainer_43.add(rngeOrd, new FormData("100%")); 
	    
	   layoutContainer04.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	    layoutContainer_43.setBorders(false);
	    cp01.add(layoutContainer04);
	   layoutContainer04.setBorders(false);
	   
	   
       LayoutContainer layoutContainer04_1 = new LayoutContainer();
       layoutContainer04_1.setLayout(new ColumnLayout());
       
       
	   LayoutContainer layoutContainer_8 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(90); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_8.setLayout(frmlytStd);
	   
	   payItemNoteCtnt = new TextField<String>();
	   layoutContainer_8.add(payItemNoteCtnt, new FormData("100%"));
	   payItemNoteCtnt.setFieldLabel("비 고");
	   cp01.add(layoutContainer_8);
	   layoutContainer_8.setBorders(false);
	    

       LayoutContainer layoutContainer_8_1 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(90); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_8_1.setLayout(frmlytStd);
        

       calcStdFunc = new TextField<String>(); 
       calcStdFunc.setFieldLabel("계산식");
         calcStdFunc.setVisible(false);
       
          layoutContainer_8_1.add(calcStdFunc, new FormData("100%"));
          layoutContainer_8_1.setBorders(false);
          
          layoutContainer04_1.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
          layoutContainer04_1.add(layoutContainer_8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
          layoutContainer04_1.setBorders(false);
          cp01.add(layoutContainer04_1);
        
	    
	    lcTabFormLayer.add(cp01); 
	      
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

 private LayoutContainer payrLeft01() {
	   
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
//	   cp01.setSize(600, 222);   
	   cp01.setSize(600, 182);   
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
//	    payr0490GridPanel = new MSFGridPanel(payr0490Def, false, false, false, false,false);
//	    payr0490GridPanel.setHeaderVisible(false);  
//	    payr0490GridPanel.setBodyBorder(false);
//	    payr0490GridPanel.setBorders(false); 
//	    payr0490GridPanel.getBottomComponent().setVisible(false);
//     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//	    // DETAILS 
//        final Grid payr0490Grid = payr0490GridPanel.getMsfGrid().getGrid();
//        payr0490Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//           public void handleEvent(BaseEvent be) {  
//            if (payr0490GridPanel.getCurrentlySelectedItem() != null) {   
//               
//                 
//                payrUcstDgmSeilNum.setValue((Long)payr0490GridPanel.getCurrentlySelectedItem().get("payrUcstDgmSeilNum")); /** column 급여단가표일련번호 : payrUcstDgmSeilNum */
//                payItemCd.setValue(MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("payItemCd")));   /** column 급여항목코드 : payItemCd */                          
//                itemNm.setValue(MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("itemNm")));   /** column 항목명 : itemNm */                                         
//                payCd.setValue(lsPayCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("payCd"))));   /** column 급여구분코드 : payCd */                                  
//          
//                pymtDducDivCd.setValue(lsPymtDducDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("pymtDducDivCd"))));   /** column 지급공제구분코드 : pymtDducDivCd */              
//                pymtDducFrmCd.setValue(lsPymtDducFrmCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("pymtDducFrmCd"))));   /** column 지급공제유형코드 : pymtDducFrmCd */              
//                pymtDducRate.setValue((Double)payr0490GridPanel.getCurrentlySelectedItem().get("pymtDducRate"));   /** column 지급공제율 : pymtDducRate */                       
//                pymtDducSum.setValue((Long)payr0490GridPanel.getCurrentlySelectedItem().get("pymtDducSum"));   /** column 지급공제액 : pymtDducSum */                        
//                txtnDivCd.setValue(lsTxtnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("txtnDivCd"))));   /** column 과세구분코드 : txtnDivCd */                          
//                freeDtyRate.setValue((Double)payr0490GridPanel.getCurrentlySelectedItem().get("freeDtyRate"));   /** column 비과세율 : freeDtyRate */                          
//                freeDtySum.setValue((Long)payr0490GridPanel.getCurrentlySelectedItem().get("freeDtySum"));   /** column 비과세금액 : freeDtySum */   
//                rngeOrd.setValue((Long)payr0490GridPanel.getCurrentlySelectedItem().get("rngeOrd"));   /** column 정렬순서 : rngeOrd */                        
//                payItemUseYn.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("payItemUseYn"));   /** column 급여항목사용여부 : payItemUseYn */      
//                itemApptnBgnnDt.setValue((Date)payr0490GridPanel.getCurrentlySelectedItem().get("itemApptnBgnnDt"));   /** column 항목적용시작일자 : itemApptnBgnnDt */
//                itemApptnEndDt.setValue((Date)payr0490GridPanel.getCurrentlySelectedItem().get("itemApptnEndDt")) ; /** column 항목적용종료일자 : itemApptnEndDt */   
//                dayMnthAmntDivCd.setValue(lsDayMnthAmntDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("dayMnthAmntDivCd")))) ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
//                calcStdDivCd.setValue(lsCalcStdDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("calcStdDivCd"))));   /** column 계산기준구분코드 : calcStdDivCd */      
//                usalyAmntYn.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("usalyAmntYn"));   /** column 통상임금여부 : usalyAmntYn */            
//                payItemNoteCtnt.setValue(MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("payItemNoteCtnt")));   /** column 급여항목비고내용 : payItemNoteCtnt */ 
//                calcStdFunc.setValue(MSFSharedUtils.allowNulls(payr0490GridPanel.getCurrentlySelectedItem().get("calcStdFunc")));  /** column 계산수식내용 : calcStdFunc */
//                jan.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("jan"));   /** column 1월 : jan */
//                feb.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("feb"));   /** column 2월 : feb */
//                mar.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("mar"));   /** column 3월 : mar */
//                apr.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("apr"));   /** column 4월 : apr */
//                may.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("may"));   /** column 5월 : may */
//                jun.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("jun"));   /** column 6월 : jun */
//                jul.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("jul"));   /** column 7월 : jul */
//                aug.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("aug"));   /** column 8월 : aug */
//                sep.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("sep")) ;  /** column 9월 : sep */
//                oct.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("oct"));   /** column 10월 : oct */
//                nov.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("nov"));   /** column 11월 : nov */
//                dec.setValue((Boolean)payr0490GridPanel.getCurrentlySelectedItem().get("dec"));   /** column 12월 : dec */ 
//                
//                
//                //삭제와 업데이트를 위한 값을 넣은다.
//                setDetailRecord(payr0490GridPanel.getCurrentlySelectedItem());
//                
//                 
//                
//                
//             } 
//           }
//       }); 
//	    
//	    
//	    
//	    cp01.add(payr0490GridPanel); 
	    

	     sysComBass0300Dto = new PrgmComBass0300DTO(); 
		 
		 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("B008");  //지급공제구분코드 
		 lsGdPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		   
		 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	 
		 
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new ColumnLayout());

		FormLayout frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
         
		ToolBar toolBar = new ToolBar();
		toolBar.setBorders(false);
		
//		toolBar.getAriaSupport().setLabel("지급공제구분");
		

		toolBar.add(new LabelToolItem("지급공제구분: "));
	    final ComboBox<BaseModel> type = new ComboBox<BaseModel>();
	    type.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
	    type.setName("type");
	    type.setForceSelection(true);
	    type.setMinChars(1);
	    type.setDisplayField("commCdNm");
	    type.setValueField("commCd");
	    type.setTriggerAction(TriggerAction.ALL);
//	    type.setFieldLabel("지급공제구분");
	    type.setEmptyText("--지급공제구분선택--");
	    type.setSelectOnFocus(true); 
	    type.setReadOnly(false);
	    type.setEnabled(true); 
	    type.setStore(lsGdPymtDducDivCd); 
	    type.setWidth(150);

//	    type.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
//	    type.setEditable(false);
//	    type.setFireChangeEventOnSetValue(true);
	    type.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        	BaseModel bmPayYr =  se.getSelectedItem(); 
	        	if (bmPayYr != null) {
//	        		IColumnFilter filters = null;
//	        		payr0490GridPanel.getTableDef().setTableColumnFilters(filters);
//	        		payr0490GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(type,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	        		payr0490GridPanel.reload();
	        	}       
	    	} 
		});
	    
//	    type.addListener(Events.Change, new Listener<FieldEvent>() {
//	      public void handleEvent(FieldEvent be) {
//	           
//	            payr0490GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(type,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	            payr0490GridPanel.reload();
//	      }
//	    });
//	    toolBar.add(type);
//	    layoutContainer_2.add(toolBar);
	    
		LayoutContainer layoutContainer_3 = new LayoutContainer();
//		layoutContainer_3.setStyleAttribute("text-align", "right");
		
//		ToolBar toolBar2 = new ToolBar();
//		toolBar2.setBorders(false);
//		toolBar.getAriaSupport().setLabel("지급공제구분");
//	    toolBar.add(new LabelToolItem("지급공제구분: "));
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setStyleAttribute("text-align", "right");
//		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button button = new Button("신규");
		button.setIcon(MSFMainApp.ICONS.new16());
		button.setStyleAttribute("marginTop", "3px");
//		button.setStyleAttribute("marginLeft", "50px");
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 // 급여공제구분 팝업으로 데이터를 가지고온다.
		          fnPopupCommP500(); 
			}
		});
		
		btnBar.add(button);
		
	    toolBar.add(type);
	    toolBar.add(button);
	    layoutContainer_2.add(toolBar);
//		toolBar2.add(btnBar);
//		
//	    layoutContainer_3.add(toolBar2);
		
//	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//		      @Override  
//		      public void componentSelected(ButtonEvent ce) {   
//		       // 급여공제구분 팝업으로 데이터를 가지고온다.
//		          fnPopupCommP500(); 
//		      }   
//		    }));  
	    
//	    toolBar.add(button);
//	    layoutContainer_3.add(toolBar);
		
	    
	    layoutContainer_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//	    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    
	    //-------

	    
	    cp01.setTopComponent(layoutContainer_1);
//	    cp01.setTopComponent(toolBar);
	   
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;  
	   
 }
 
private LayoutContainer occupationalLeft() {
 
 LayoutContainer lcTabFormLayer = new LayoutContainer();
 
  ContentPanel cp01 = new ContentPanel();   
  cp01.setBodyBorder(false); 
  cp01.setHeaderVisible(false);   
  cp01.setLayout(new FitLayout());      
  cp01.setSize(308, 285);  
  
  //msfCustomForm.setHeaderVisible(false);
  //Instantiate the GridPanel
  bass0500GridPanel = new MSFGridPanel(bass0500Def, false, false, false,false);
  bass0500GridPanel.setHeaderVisible(false);  
  bass0500GridPanel.setBodyBorder(false);
  bass0500GridPanel.setBorders(true);  
  bass0500GridPanel.getBottomComponent().setVisible(false);
//  msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

  cp01.add(bass0500GridPanel); 
  
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
	        bass0500GridPanel.getMsfGrid().clearData();  
        
	        formSubInit(); 
	        formSubDetilInit();
        
			IColumnFilter filters = null;
			bass0500GridPanel.getTableDef().setTableColumnFilters(filters);
			
			 
			bass0500GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
			bass0500GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			bass0500GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			bass0500GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			bass0500GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"payCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0415GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"pymtDducDivCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			  
			  
			bass0500GridPanel.reload();
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
                   setListRecord(mapModels);
                   actionDatabase = ActionDatabase.INSERT;
                   doAction(ActionDatabase.INSERT); 
               }  
           }
       });
   }
   
   
   public void setListRecord(List<BaseModel> records) {
       this.records = records;
   } 

   
	  private void fnFormTextMapping(BaseModel bmRecord) {
          
	      dpobCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("dpobCd")));   /** column 사업장코드 : dpobCd */  
                        
	     // payrUcstDgmSeilNum.setValue(0L);  /** column 급여단가표일련번호 : payrUcstDgmSeilNum */ 
	      
          //emymtDivCd.setValue("");   /** column 고용구분코드 : emymtDivCd */                        
                                                                                       
          businApptnYr.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businApptnYr")));   /** column 사업적용년도 : businApptnYr */                    
          deptCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("deptCd")));   /** column 부서코드 : deptCd */                                    
          deptNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("deptNm")));   /** column 부서코드 : deptNm */                                    
          businCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businCd")));   /** column 사업코드 : businCd */                                  
          businNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businNm")));   /** column 사업명 : businNm */                                    
          businStdt.setValue((Date)bmRecord.get("businStdt"));   /** column 사업기간시작일자 : businStdt */                      
          businEddt.setValue((Date)bmRecord.get("businEddt"));   /** column 사업기간종료일자 : businEddt */                      
                                                                                       
          businEmymtTypOccuCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businEmymtTypOccuCd")));   /** column 사업고용직종코드 : businEmymtTypOccuCd */  
          businEmymtTypOccuNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businEmymtTypOccuNm")));   /** column 사업고용직종 : businEmymtTypOccuCd */  
                                                                                       
          businRepbtyEmpNum.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businRepbtyEmpNum")));   /** column 사업담당직원번호 : businRepbtyEmpNum */      
         // businRepbtyEmpNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businRepbtyEmpNm")));   /** column 사업담당직원번호 : businRepbtyEmpNum */       
                                                                                       
          payrMangDeptCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("payrMangDeptCd")));   /** column 단위기관코드 : payrMangDeptCd */            
          payrMangDeptNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("payrMangDeptNm")));   /** column 단위기관코드 : payrMangDeptNm */  
           
          payYr.setValue(MSFSharedUtils.allowNulls(bmRecord.get("businApptnYr")));  //지급년도                                                                 
         
     };
    //폼초기화 검색조건포함 
	   private void formInit() {
	       
	       BaseModel bmBlank = new BaseModel();  
	          
//	          srhPayYr.setValue(lsPayYrStore.getAt(0)); /** column 급여년도 : payYr */                                     
//	          
//	          srhPayrMangDeptCd.setValue(bmBlank); //단위기관                                                
//	          srhDeptCd.setValue(bmBlank) ;    //부서                                                        
//	          srhBusinCd.setValue(bmBlank);    //사업                                                        
	          srhPayCd.setValue(bmBlank);     //급여구분                                                     
	                                                                                       
	          srhPymtDducDivCd.setValue(bmBlank); /** column 지급공제구분코드 : pymtDducDivCd */             
	          bass0500GridPanel.getMsfGrid().clearData();  
	          
	          formSubInit(); 
	          formSubDetilInit();
	   }
	
	   private void formSubInit() {
	       
	       BaseModel bmBlank = new BaseModel();  
	       
	       dpobCd.setValue("");  //사업장코드                                   
	       payrUcstDgmSeilNum.setValue(0L);  /** column 급여단가표일련번호 : payrUcstDgmSeilNum */
 
           emymtDivCd.setValue("");   /** column 고용구분코드 : emymtDivCd */                        
                                                                                        
           businApptnYr.setValue("");   /** column 사업적용년도 : businApptnYr */                    
           deptCd.setValue("");   /** column 부서코드 : deptCd */                                    
           deptNm.setValue("");   /** column 부서코드 : deptNm */                                    
           businCd.setValue("");   /** column 사업코드 : businCd */                                  
           businNm.setValue("");   /** column 사업명 : businNm */                                    
           businStdt.reset();   /** column 사업기간시작일자 : businStdt */                      
           businEddt.reset();   /** column 사업기간종료일자 : businEddt */                      
                                                                                        
           businEmymtTypOccuCd.setValue("");   /** column 사업고용직종코드 : businEmymtTypOccuCd */  
           businEmymtTypOccuNm.setValue("");   /** column 사업고용직종코드 : businEmymtTypOccuCd */  
                                                                                        
           businRepbtyEmpNum.setValue("");   /** column 사업담당직원번호 : businRepbtyEmpNum */      
           businRepbtyEmpNm.setValue("");   /** column 사업담당직원번호 : businRepbtyEmpNum */       
                                                                                        
           payrMangDeptCd.setValue("");   /** column 단위기관코드 : payrMangDeptCd */            
           payrMangDeptNm.setValue("");   /** column 단위기관코드 : payrMangDeptNm */            
             
      //     payr0490GridPanel.getMsfGrid().clearData();
            
           
	   }
	   
  private void formSubDetilInit() {
           
           BaseModel bmBlank = new BaseModel();  
                                                                         
           payYr.setValue("");  //지급년도                                                                 
           payItemCd.setValue("");   /** column 급여항목코드 : payItemCd */                          
           itemNm.setValue("");   /** column 항목명 : itemNm */                                         
           payCd.setValue(bmBlank);   /** column 급여구분코드 : payCd */                                  
           pymtDducDivCd.setValue(bmBlank);   /** column 지급공제구분코드 : pymtDducDivCd */              
           pymtDducFrmCd.setValue(bmBlank);   /** column 지급공제유형코드 : pymtDducFrmCd */              
           pymtDducRate.setValue(0.0);   /** column 지급공제율 : pymtDducRate */                      
           pymtDducSum.setValue(0);   /** column 지급공제액 : pymtDducSum */                        
           txtnDivCd.setValue(bmBlank);   /** column 과세구분코드 : txtnDivCd */                          
           freeDtyRate.setValue(0.0);   /** column 비과세율 : freeDtyRate */                          
           freeDtySum.setValue(0);   /** column 비과세금액 : freeDtySum */   
           rngeOrd.setValue(0);   /** column 정렬순서 : rngeOrd */                        
           payItemUseYn.setValue(true);   /** column 급여항목사용여부 : payItemUseYn */      
           itemApptnBgnnDt.reset();   /** column 항목적용시작일자 : itemApptnBgnnDt */
           itemApptnEndDt.reset() ; /** column 항목적용종료일자 : itemApptnEndDt */   
           dayMnthAmntDivCd.setValue(bmBlank) ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
           calcStdDivCd.setValue(bmBlank);   /** column 계산기준구분코드 : calcStdDivCd */      
           usalyAmntYn.setValue(false);   /** column 통상임금여부 : usalyAmntYn */            
           payItemNoteCtnt.setValue("");   /** column 급여항목비고내용 : payItemNoteCtnt */
           
           jan.setValue(true);   /** column 1월 : jan */
           feb.setValue(true);   /** column 2월 : feb */
           mar.setValue(true);   /** column 3월 : mar */
           apr.setValue(true);   /** column 4월 : apr */
           may.setValue(true);   /** column 5월 : may */
           jun.setValue(true);   /** column 6월 : jun */
           jul.setValue(true);   /** column 7월 : jul */
           aug.setValue(true);   /** column 8월 : aug */
           sep.setValue(true) ;  /** column 9월 : sep */
           oct.setValue(true);   /** column 10월 : oct */
           nov.setValue(true);   /** column 11월 : nov */
           dec.setValue(true);   /** column 12월 : dec */
           chkAll.setValue(false);   /** column 전체체크 : chkAll */
              
       }
  
	   private void exportExcel() {
	       
	   //    payr0490GridPanel.callExportServlet(""); 
	   }
	    //전체선택 체크박스 
       public class CheckboxListener implements Listener<BaseEvent>
       {
           public void handleEvent(BaseEvent be) {
               CheckBox checkBox = (CheckBox) be.getSource();
               if (checkBox.getValue()) {
                  //전체선택
                   jan.setValue(true);   /** column 1월 : jan */
                   feb.setValue(true);   /** column 2월 : feb */
                   mar.setValue(true);   /** column 3월 : mar */
                   apr.setValue(true);   /** column 4월 : apr */
                   may.setValue(true);   /** column 5월 : may */
                   jun.setValue(true);   /** column 6월 : jun */
                   jul.setValue(true);   /** column 7월 : jul */
                   aug.setValue(true);   /** column 8월 : aug */
                   sep.setValue(true) ;  /** column 9월 : sep */
                   oct.setValue(true);   /** column 10월 : oct */
                   nov.setValue(true);   /** column 11월 : nov */
                   dec.setValue(true);   /** column 12월 : dec */
               } else {
                  //전체해제  
                   jan.setValue(false);   /** column 1월 : jan */
                   feb.setValue(false);   /** column 2월 : feb */
                   mar.setValue(false);   /** column 3월 : mar */
                   apr.setValue(false);   /** column 4월 : apr */
                   may.setValue(false);   /** column 5월 : may */
                   jun.setValue(false);   /** column 6월 : jun */
                   jul.setValue(false);   /** column 7월 : jul */
                   aug.setValue(false);   /** column 8월 : aug */
                   sep.setValue(false) ;  /** column 9월 : sep */
                   oct.setValue(false);   /** column 10월 : oct */
                   nov.setValue(false);   /** column 11월 : nov */
                   dec.setValue(false);   /** column 12월 : dec */
               }
           }
       }   
   
 
	  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	   
       public void setDetailRecord(BaseModel detailRecord) {
           this.detailRecord = detailRecord;
       }
       
	   

	   private Resm4300 getThis(){
	       return this;
	   }
	   
	 //부서 
	   private void fnPopupCommP140(String deptCd) {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       
	       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
	       
	       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
	      
	       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("mangeDeptCd"))) { 
	                    
	                   srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
	                   srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
	                   srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	                   srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
	                   srhDeptCd.fireEvent(Events.Add);
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
