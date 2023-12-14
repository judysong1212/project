package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0300DTO;
import com.app.exterms.personal.client.form.defs.Psnl0300Def;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100Service;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0300Service;
import com.app.exterms.personal.client.service.Psnl0300ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.client.service.PrgmComBass0400ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0300 extends MSFPanel {

/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부시작} 
 * #######################################################
 */
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0300Bar;	
	private Button btnPsnl0300Reset;				//초기화 버튼
	private Button btnPsnl0300New;					//신규 버튼
	private Button btnPsnl0300Del;					//삭제 버튼
	private Button btnPsnl0300Sreach;				//조회 버튼
	private Button btnPsnl0300Print;				//인쇄 버튼
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색 조건 시작 --------------
	private HiddenField<String> dpobCd;
	private HiddenField<String> systemkey;
	private ComboBox<BaseModel> searchAppmtDivCd;	//발령구분
	private ComboBox<BaseModel> searchAppmtFixYn; 	//발령상태
	private TextField<String> srhDeptCd; 			//부서코드
    private TextField<String> srhDeptNm; 			//부서명  
    private Button btnSrhDeptCd;					//부서검색버튼
  //  private TextField<String> srhMangeDeptCd; 		//관리부서 수정
  //  private TextField<String> srhMangeDeptNm; 		//관리부서 수정 
    private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

    private ComboBox<BaseModel> searchBusinCd;	  	//사업명
	private ComboBox<BaseModel> searchEmymtDivCd; 	//고용구분
	private TextField<String> searchName;		  	//성명
	private TextField<String> searchResnRegnNum;  	//주민번호
	private DateField searchAppmtDtS;			  	//발령일자 시작
	private DateField searchAppmtDtE;			  	//발령일자 종료
	private ComboBox<BaseModel> searchTypOccuCd;  	//직종 

	private Boolean emptyCheck = false ;

	// -------------- 검색조건 끝 --------------
	
	// -------------- 대상선정 필드 시작 --------------
	private MSFComboBox<BaseModel> midAppmtDivCd;	//발령구분
	private MSFComboBox<BaseModel> midDeptCd; 	  	//부서
	private MSFComboBox<BaseModel> midBusinCd;	  	//사업명
	private MSFComboBox<BaseModel> midTypOccuCd;  	//직종
	private MSFComboBox<BaseModel> midEmymtDivCd; 	//고용구분
	// -------------- 대상선정 필드 끝 --------------
	
	//-------------- 발령대상자정보 이미지 시작 --------------
	Image picImg; //대상자 정보 사진
	// -------------- 발령대상자정보 이미지 끝 --------------
	
	//-------------- 발령설정 탑 시작 --------------
	private MSFComboBox<BaseModel> appmtDivCd; 		//발령구분
	private MSFTextField appmtName;		   			//성명
	private MSFTextField appmtResnRegnNum;    		//주민번호
	private MSFComboBox<BaseModel> appmtHdofcCodtnCd;//재직구분
	// -------------- 발령설정 탑 끝 --------------
	
	//-------------- 발령전 시작 --------------
	private MSFTextField beforeCurrDeptCdNm;		//부서
	private MSFTextField beforeBusinCdNm; 			//사업명
	private MSFTextField beforeTypOccuCdNm; 		//직종
	private MSFTextField beforeDtilOccuInttnNm;		//직종세
	private MSFTextField beforeOdtyCdNm; 			//직책
	private MSFTextField beforeLogSvcYrNumCdNm;		//근속년수
	// -------------- 발령전 끝 --------------
	
	// -------------- 발령후 시작 --------------
	private MSFComboBox<BaseModel> afterCurrDeptCd;		//부서
	private MSFComboBox<BaseModel> afterBusinCd;	  	//사업명
	private MSFComboBox<BaseModel> afterTypOccuCd;  	//직종
	private MSFComboBox<BaseModel> afterDtilOccuInttnCd;//직종세
	private MSFComboBox<BaseModel> afterLogSvcYrNumCd; 	//근속년수
	private MSFComboBox<BaseModel> afterOdtyCd; 		//직책
	private MSFTextField afterAppmtIstut;				//발령기관
	private MSFTextField afterAppmtBssCtnt;				//발령근거내용
	private MSFDateField afterAppmtDt;					//발령일자
	private HiddenField<String> emymtDivCdFld;			//고용구분
	
	private Button saveBtn;
	// -------------- 발령후 끝 --------------
	
	// -------------- store 선언 시작 --------------
	private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA046 			= new ListStore<BaseModel>(); //발령구분
	private ListStore<BaseModel> listStoreA002 			= new ListStore<BaseModel>(); //고용구분
	private ListStore<BaseModel> listStoreA003			= new ListStore<BaseModel>(); //재직구분
	private ListStore<BaseModel> listStoreA041 			= new ListStore<BaseModel>(); //직종
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>(); //직종세
	private ListStore<BaseModel> listStoreA015 			= new ListStore<BaseModel>(); //직책
	private ListStore<BaseModel> listStoreA007 			= new ListStore<BaseModel>(); //근속년수
	private ListStore<BaseModel> listStoreBass0400 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreBass0400All 	= new ListStore<BaseModel>(); //소속부서 전체 데이타

    private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서

	// -------------- store 선언 끝 --------------
	
	// -------------- 그리드 선언 시작 --------------
//	private Grid<Psnl0300DTO> psnl0300Grid;
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
	 
	private Psnl0300Def psnl0300Def  = new Psnl0300Def("PSNL0300");   //그리드 테이블 컬럼 define  
	private MSFGridPanel psnl0300GridPanel;
	// -------------- 그리드 선언 끝 --------------
	
	// -------------- 서비스 호출 시작 --------------
	private InfcPkgPsnl0100ServiceAsync psnl0100Service = InfcPkgPsnl0100Service.Util.getInstance();
	private Psnl0300ServiceAsync psnl0300Service = Psnl0300Service.Util.getInstance();
	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	// -------------- 서비스 호출 끝 --------------
	
	private boolean comboBool = false;
	private PrgmComBass0350DTO sysComBass0350Dto; 		// 직종세
	private ActionDatabase actionDatabase;
//	private BaseModel tmpBmData;
	private RpcProxy<BaseListLoadResult<Psnl0300DTO>> psnl0300Proxy = new RpcProxy<BaseListLoadResult<Psnl0300DTO>>() {
		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Psnl0300DTO>> callback) {
			
			Psnl0300DTO dto = new Psnl0300DTO();
			dto.setAppmtDivCd(PersonalUtil.getSelectedComboValue(searchAppmtDivCd, "commCd"));
			dto.setAppmtFixYn(PersonalUtil.getSelectedComboValue(searchAppmtFixYn, "commCd"));
			dto.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")));
			dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   //부서 
			dto.setBusinCd(PersonalUtil.getSelectedComboValue(searchBusinCd, "businCd"));
			dto.setEmymtDivCd(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"));
			dto.setHanNm(searchName.getValue());
			dto.setResnRegnNum(searchResnRegnNum.getValue());
			dto.setAppmtDtS(PersonalUtil.getConvertDateToString(searchAppmtDtS, "yyyyMMdd"));
			dto.setAppmtDtE(PersonalUtil.getConvertDateToString(searchAppmtDtE, "yyyyMMdd"));
			dto.setTypOccuCd(PersonalUtil.getSelectedComboValue(searchTypOccuCd, "typOccuCd"));
			
			psnl0300Service.selectPsnl0300((BaseListLoadConfig) loadConfig, dto, callback); 
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0300 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0300Proxy);
	private ListStore<Psnl0300DTO> storePsnl0300 = new ListStore<Psnl0300DTO>(loaderPsnl0300);
	
	
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
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	private void checkPsnl0300Auth( String authAction, ListStore<BaseModel> bm) {   
		//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			if (!maskTracker) { unmask(); }  
				//MSFMainApp.unmaskMainPage();
			authExecEnabled() ;
		}
	}
	
	private void authExecEnabled() { 
		//----------------------------------------------------
		Field<?>[] fldArrField = {searchEmymtDivCd, srhDeptCd, srhDeptNm, searchBusinCd, searchTypOccuCd};
             
		gwtAuthorization.formAuthFieldConfig(fldArrField);
    	gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
             
    	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    	 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
    	 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
             // String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
            //  gwtAuthorization.formAuthPopConfig(plFrmPsnl0300, "","searchEmymtDivCd",strArrDeptCd,"searchTypOccuCd","searchBusinCd");
             // gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
    	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    	 * 권한설정을 위한 콤보처리를 위한 메서드 종료
		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    	srhDeptCd.fireEvent(Events.Add);
	           
	}
//		  private AuthAction authAction;
//		  private int checkCntDef = 1;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkPsnl0300Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			 
//			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//			   
//				    
//	                //----------------------------------------------------
//	                unmask(); 
//	                //MSFMainApp.unmaskMainPage();
//	                 
//			   }
//		  }

	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			if (listStoreA002.getCount() > 0) {

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

		authMapDef.put("searchEmymtDivCd", Boolean.FALSE);

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
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################
 */

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0300;
	private String txtForm = "";
	 

	private GridCellRenderer<Stock> gridNumber;
	private GridCellRenderer<Stock> change;

	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();

			vp = new VerticalPanel();
			// vp.setSpacing(10);

			createPsnl0300Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createStandardForm(); 	// 기본정보필드

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
	 * @wbp.parser.constructor
	 */
	public Psnl0300() {
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Psnl0300(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0300Form() {
		
		actionDatabase = ActionDatabase.INSERT;
		
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0350Dto.setDtilOccuClsUseYn("A");
		//--------------------직종세 코드 불러 오는 함수 --------------------------------------------------
		lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
//		lsDtilOccuInttnCd = new ListStore<BaseModel>();
		//--------------------직종세 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0350Dto.setDtilOccuClsUseYn("");
		
		plFrmPsnl0300 = new FormPanel();
		plFrmPsnl0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 발령관리"));
		plFrmPsnl0300.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0300.setBodyStyleName("pad-text");
		plFrmPsnl0300.setFrame(true);
		plFrmPsnl0300.setPadding(2);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("발령관리","PSNL0300");
				}
			});
		plFrmPsnl0300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		dpobCd = new HiddenField<String>();
		systemkey = new HiddenField<String>();
		emymtDivCdFld = new HiddenField<String>();
//		searchSystemkey = new HiddenField<String>();
		
		
		List<String> arrRpsttvCd = new ArrayList<String>();
		arrRpsttvCd.add("A046");
		arrRpsttvCd.add("A002");
		arrRpsttvCd.add("A003");
		// arrRpsttvCd.add("A041");
		arrRpsttvCd.add("A015");
		arrRpsttvCd.add("A007");
		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
		sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
		
			@Override
			public void onSuccess(HashMap<String, List<BaseModel>> result) {
				// TODO 콤보 데이터 저장하는곳
				if(result != null && result.size() > 0){
					listStoreA002.add(result.get("A002"));
					//listStoreA041.add(result.get("A041"));
					listStoreA007.add(result.get("A007"));
					listStoreA003.add(result.get("A003"));
					listStoreA046.add(result.get("A046"));
					listStoreA015.add(result.get("A015"));
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "공통코드 에러!", null);
			}
		});
	
		listStoreBass0400 = PrgmComComboUtils.getMangDeptBass0400ComboData(new PrgmComBass0400DTO());
		sysComBass0400Service.getPrgmComDeptBass0400List(new PrgmComBass0400DTO(),new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				listStoreBass0400All.add(result);
			}
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});

		topPsnl0300Bar = new ButtonBar();
		topPsnl0300Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnPsnl0300Reset = new Button("초기화");
		btnPsnl0300Reset.setIcon(MSFMainApp.ICONS.new16());
		btnPsnl0300Reset.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
//				searchAppmtDivCd.setValue(new BaseModel());	// 발령구분
//				searchAppmtFixYn.setValue(new BaseModel());	// 발령상태
//				srhMangeDeptCd.setValue("");				// 관리부서
//				searchAppmtDtS.setValue(null);				// 발령일자_시작
//				searchAppmtDtE.setValue(null);				// 발령일자_종료
//				searchName.setValue("");					// 성명
//				searchResnRegnNum.setValue("");				// 주민등록번호
//				systemkey.setValue("");						// 시스템키
				
				//검색조건 초기화
				psnl0300SrhInit();
				
				if(searchEmymtDivCd.isEnabled()){
					
					searchEmymtDivCd.setValue(new BaseModel());			// 고용구분
					searchBusinCd.setEnabled(true);						// 사업
					searchTypOccuCd.setEnabled(true);					// 직종
					searchTypOccuCd.reset();							// 직종
					srhDeptCd.setValue("");								// 부서
					searchBusinCd.setValue(new BaseModel());			// 사업
					searchBusinCd.setEmptyText("--소속선택--");				// 사업
					searchBusinCd.setStore(new ListStore<BaseModel>());	// 사업
				}
				
				//발령설정 초기화
				psnl0300Init();
				
				//그리드 초기화
				psnl0300GridPanel.getMsfGrid().clearData();
			}
		});
		topPsnl0300Bar.add(btnPsnl0300Reset);
		
		btnPsnl0300New = new Button("신규");
		btnPsnl0300New.setIcon(MSFMainApp.ICONS.new16());
		btnPsnl0300New.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				//발령설정 초기화
				psnl0300Init();
				
				//그리드 선택 초기화
				psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().deselectAll();
				
			}
		});
		topPsnl0300Bar.add(btnPsnl0300New);
		
		btnPsnl0300Del = new Button("삭제");
		btnPsnl0300Del.setIcon(MSFMainApp.ICONS.delete16());
		btnPsnl0300Del.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if(psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() > 0){
//				if(psnl0300Grid.getSelectionModel().getSelectedItems().size() > 0){
					MessageBox.confirm("발령 삭제", "선택하신 발령정보를 삭제 하시겠습니까?<br>(미발령건만 삭제가능.)",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								
								
								Iterator<BaseModel> itBm  = psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();	
								
								List<Record>  lsRec  = new ArrayList<Record>();
					              
								while(itBm.hasNext()) {
									Record rec  = new Record(itBm.next()); 
									lsRec.add(rec);
								} 
								
								Iterator<Record> iterRecords = lsRec.iterator() ;  
					            List<Psnl0300DTO> listPsnl0300Dto = new ArrayList<Psnl0300DTO>();
					            
					            Boolean delChk = true;
					            
					            
					            while (iterRecords.hasNext()) {
							 	       
									Record recData = (Record) iterRecords.next(); 
									BaseModel bmMapModel = (BaseModel)recData.getModel();
					 	               
									Psnl0300DTO psnl0300Dto = new Psnl0300DTO();  
									
									psnl0300Dto.setAppmtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDivCd")));    				/** column 발령구분코드 : appmtDivCd */
									psnl0300Dto.setAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDt")));    					/** column 발령일자 : appmtDt */
									psnl0300Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    						/** column 한글성명 : hanNm */
									psnl0300Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));   			/** column 주민등록번호 : resnRegnNum */
									psnl0300Dto.setAppmtFixYn(MSFSharedUtils.allowNulls(bmMapModel.get("appmtFixYn"))); 				/** column 발령확정여부 : appmtFixYn */
									
									if("Y".equals(psnl0300Dto.getAppmtFixYn())) {
										delChk = false;
									}
									
									psnl0300Dto.setBfrDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrDeptCd"))); 					/** column 전_부서코드명 : bfrDeptCd */
									psnl0300Dto.setBfrBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrBusinCd"))); 				/** column 전_사업코드 : bfrBusinCd */
									psnl0300Dto.setBfrTypOccuDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrTypOccuDivCd"))); 		/** column 전_직종구분코드 : bfrTypOccuDivCd */
									psnl0300Dto.setBfrOdtyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrOdtyDivCd"))); 			/** column 전_직책구분코드 : bfrOdtyDivCd */
									psnl0300Dto.setBfrPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrPyspCd"))); 					/** column 전호봉코드 : bfrPyspCd */
									
									psnl0300Dto.setAftDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftDeptCd"))); 					/** column 후_부서코드 : aftDeptCd */
									psnl0300Dto.setAftBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftBusinCd"))); 				/** column 후_사업코드 : aftBusinCd */
									psnl0300Dto.setAftTypOccuDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftTypOccuDivCd"))); 		/** column 후_직종구분코드 : aftTypOccuDivCd */
									psnl0300Dto.setAftOdtyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftOdtyDivCd"))); 			/** column 후_직책구분코드 : aftOdtyDivCd */
									psnl0300Dto.setAftPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftPyspCd"))); 					/** column 후_호봉코드 : aftPyspCd */
									
									psnl0300Dto.setAppmtBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtBssCtnt"))); 			/** column 발령근거내용 : appmtBssCtnt */ 
									psnl0300Dto.setAppmtIstut(MSFSharedUtils.allowNulls(bmMapModel.get("appmtIstut")));   		 		/** column 발령기관 : appmtIstut */
									
									psnl0300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));							/** column 사업장코드 : dpobCd */
									psnl0300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   				/** column SYSTEMKEY : systemkey */
									psnl0300Dto.setAppmtNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtNum")));    					/** column 발령번호 : appmtNum */
									psnl0300Dto.setAftLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftLogSvcYrNumCd")));		/** column 후_근속년수코드 : aftLogSvcYrNumCd */
									psnl0300Dto.setBfrLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrLogSvcYrNumCd")));		/** column 전근속년수코드 : bfrLogSvcYrNumCd */
									psnl0300Dto.setBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("bgnnDt")));    						/** column 시작일자 : bgnnDt */
									psnl0300Dto.setEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("endDt")));    						/** column 종료일자 : endDt */
									psnl0300Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    						/** column 부서코드 : deptCd */
									psnl0300Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    					/** column 사업코드 : businCd */
									psnl0300Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    				/** column 직종코드 : typOccuCd */
									psnl0300Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));   						/** column 직책코드 : odtyCd */
									psnl0300Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    						/** column 호봉코드 : pyspCd */
									psnl0300Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    				/** column 호봉등급코드 : pyspGrdeCd */
									psnl0300Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));			/** column 근속년수코드 : logSvcYrNumCd */
									psnl0300Dto.setDsnyActDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActDivCd"))); 			/** column 징계구분코드 : dsnyActDivCd */
									psnl0300Dto.setCtwpMnthNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctwpMnthNum"), "0")));	/** column 감봉월수 : ctwpMnthNum */
									psnl0300Dto.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pernAppmtNoteCtnt")));									/** column 인사발령비고내용 : pernAppmtNoteCtnt */
									psnl0300Dto.setAppmtSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("appmtSeilNum"), "0"))); 	/** column 발령일련번호 : appmtSeilNum */
					 	           
									
									listPsnl0300Dto.add(psnl0300Dto);
								} 
								
					            
					            if(!delChk) {
					            	
					            	MessageBox.info("알림", "확정여부가 확정인 데이터는 삭제 불가!. </br> 선택한 데이터 확인 요망", null);
					            	
					            }else {
					            	
					            	 psnl0300Service.deletePsnl0300(listPsnl0300Dto, new AsyncCallback<Integer>(){
//											psnl0300Service.deletePsnl0300(psnl0300Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>(){
												@Override
												public void onSuccess(Integer result) {
													MessageBox.info("알림", "발령정보("+result+")건 삭제 처리가 완료 되었습니다.", null);
													
													//발령설정 폼 초기화
													psnl0300Init();
													
													reload();
//													loaderPsnl0300.load();
												}
												@Override
												public void onFailure(Throwable caught) {
													MessageBox.info("경고", "삭제실패! " + caught, null);
												}
											});
					            }
					            
								
					           
							}
						}
					});
				}else{
					MessageBox.info("항목선택", "삭제할 항목을 선택하여주세요.", null);
				}
			}
		});
		topPsnl0300Bar.add(btnPsnl0300Del);

		// topBtn = new Button("조회");
		btnPsnl0300Sreach = new Button("조회");
		btnPsnl0300Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0300Sreach.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// loaderPsnl0300.load();
				reload();

			}
		});
		topPsnl0300Bar.add(btnPsnl0300Sreach);

		// topBtn = new Button("인쇄");
		btnPsnl0300Print = new Button("인쇄");
		btnPsnl0300Print.setIcon(MSFMainApp.ICONS.print16());
		btnPsnl0300Print.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				Window.alert("준비중입니다.");
			}
		});
		topPsnl0300Bar.add(btnPsnl0300Print);

		plFrmPsnl0300.add(topPsnl0300Bar);

		// 파일업로드 처리
		plFrmPsnl0300.setAction("bizform");
		plFrmPsnl0300.setEncoding(Encoding.MULTIPART);
		plFrmPsnl0300.setMethod(Method.POST);

		vp.add(plFrmPsnl0300);
		//엣지변환
		//plFrmPsnl0300.setSize("990px", "680px");
		plFrmPsnl0300.setSize("990px", "730px");
	}

	
	
	//발령내역
		private LayoutContainer occupationalRBottom() {

			LayoutContainer lcTabFormLayer = new LayoutContainer();
			lcTabFormLayer.setStyleAttribute("paddingLeft"	, "10px");
			lcTabFormLayer.setStyleAttribute("paddingRight"	, "10px");
			
			ContentPanel cp01 = new ContentPanel();
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());
//			cp01.setSize(936, 115);
			cp01.setSize("950px", "195px");
			
			psnl0300GridPanel = new MSFGridPanel(psnl0300Def, false, false, false, false);
			psnl0300GridPanel.setHeaderVisible(false);  
			psnl0300GridPanel.setBodyBorder(true);
			psnl0300GridPanel.setBorders(true);
			
			final Grid psnl0300DefGrid = psnl0300GridPanel.getMsfGrid().getGrid();
			psnl0300DefGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {  
				
					psnl0300Init();
					
					actionDatabase = ActionDatabase.UPDATE;
					saveBtn.hide();
					BaseModel bmData = new BaseModel();

					bmData = psnl0300GridPanel.getCurrentlySelectedItem();
					
					if(bmData.get("pic") != null && !"".equals(bmData.get("pic")) ){
						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermPhoto")+"/" + bmData.get("pic"));
					}else{
						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
					}
					
					if("Y".equals(bmData.get("appmtFixYn"))){
						
						appmtDivCd.setValue(new BaseModel());
						appmtName.setValue("");
						appmtResnRegnNum.setValue("");
						appmtHdofcCodtnCd.setValue(new BaseModel());
						beforeCurrDeptCdNm.setValue("");
						beforeBusinCdNm.setValue("");
						beforeTypOccuCdNm.setValue("");
						beforeDtilOccuInttnNm.setValue("");
						beforeOdtyCdNm.setValue("");
						beforeLogSvcYrNumCdNm.setValue("");
						afterCurrDeptCd.setValue(new BaseModel());
						afterBusinCd.setValue(new BaseModel());
//						afterTypOccuCd.setValue(new BaseModel());
//						afterDtilOccuInttnCd.setValue(new BaseModel());
						afterTypOccuCd.reset();
						afterDtilOccuInttnCd.reset();
						afterLogSvcYrNumCd.setValue(new BaseModel());
						afterOdtyCd.setValue(new BaseModel());
						afterAppmtIstut.setValue("");
						afterAppmtBssCtnt.setValue("");
						afterAppmtDt.setValue(null);
						
					}else{
						
						emymtDivCdFld.reset();
						
						comboBool = false;
						
						dpobCd.setValue(MSFSharedUtils.allowNulls((String) bmData.get("dpobCd")));
						systemkey.setValue(MSFSharedUtils.allowNulls((String) bmData.get("systemkey")));
//						emymtDivCdFld.setValue((String) bmData.get("emymtDivCd"));
						
						PersonalUtil.setSelectedComboValue(appmtDivCd, (String) bmData.get("appmtDivCd"), "commCd");	//발령구분
						appmtName.setValue((String) bmData.get("hanNm"));				//성명
						appmtResnRegnNum.setValue((String) bmData.get("resnRegnNum"));	//주민번호
							
														  
						PersonalUtil.setSelectedComboValue(appmtHdofcCodtnCd, (String) bmData.get("hdofcCodtnCd"), "commCd");//재직구분
						beforeCurrDeptCdNm.setValue((String) bmData.get("bfrDeptNm"));			//부서
						beforeBusinCdNm.setValue((String) bmData.get("bfrBusinNm"));			//사업
						beforeTypOccuCdNm.setValue((String) bmData.get("bfrTypOccuDivNm"));		//직종
						beforeOdtyCdNm.setValue((String) bmData.get("bfrOdtyDivNm"));			//직책
//						beforeLogSvcYrNumCdNm.setValue((String) bmData.get("logSvcYrNumCd"));	//근속년수
						PersonalUtil.setSelectedComboValue(afterDtilOccuInttnCd, (String) bmData.get("aftDtilOccuInttnCd"), "dtilOccuInttnCd");
						PersonalUtil.setSelectedComboValue(afterTypOccuCd, (String) bmData.get("aftTypOccuDivCd"), "typOccuCd");
						
						
						PersonalUtil.setSelectedComboValue(afterCurrDeptCd, (String) bmData.get("aftDeptCd"), "deptCd");
						afterCurrDeptCd.fireEvent(Events.Change);
						
						
//						tmpBmData = new BaseModel();
//						tmpBmData.set("aftBusinCd", bmData.get("aftBusinCd"));
//						tmpBmData.set("aftTypOccuDivCd", bmData.get("aftTypOccuDivCd"));
//						tmpBmData.set("aftDtilOccuInttnCd", bmData.get("aftDtilOccuInttnCd"));
						
						
						PersonalUtil.setSelectedComboValue(afterLogSvcYrNumCd, (String) bmData.get("logSvcYrNumCd"), "commCd");
						PersonalUtil.setSelectedComboValue(afterOdtyCd, (String) bmData.get("aftOdtyDivCd"), "commCd");
						afterAppmtIstut.setValue((String) bmData.get("appmtIstut"));
						afterAppmtBssCtnt.setValue((String) bmData.get("appmtBssCtnt"));
						afterAppmtDt.setValue(GWTUtils.getDateFromString((String) bmData.get("appmtDt"), "yyyyMMdd"));
						
						if(MSFConfiguration.EMYMT_DIVCD01.equals((String) bmData.get("emymtDivCd"))) {
							
							afterBusinCd.setReadOnly(true);
							afterBusinCd.reset();
							
							afterTypOccuCd.setReadOnly(false);
							afterDtilOccuInttnCd.setReadOnly(false);
							
							
						}else {
							afterTypOccuCd.setReadOnly(true);
							afterDtilOccuInttnCd.setReadOnly(true);
							
							afterTypOccuCd.reset();
							afterDtilOccuInttnCd.reset();
							
							afterBusinCd.setReadOnly(false);
							
						}
						
						
//						PersonalUtil.setSelectedComboValue(afterBusinCd, (String) bmData.get("aftBusinCd"), "businCd");
//						Window.alert((String) bmData.get("aftBusinCd"));
	        	   } 				
					
//					if (psnl0300GridPanel.getCurrentlySelectedItem() != null) { 
//		        		  
//						dpobCd.setValue("");
//						systemkey.setValue("");
//						
//						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//						appmtDivCd.setValue(new BaseModel());
//						appmtName.setValue("");
//						appmtResnRegnNum.setValue("");
//						appmtHdofcCodtnCd.setValue(new BaseModel());
//						beforeCurrDeptCdNm.setValue("");
//						beforeBusinCdNm.setValue("");
//						beforeTypOccuCdNm.setValue("");
//						beforeOdtyCdNm.setValue("");
//						beforeLogSvcYrNumCdNm.setValue("");
//						afterCurrDeptCd.setValue(new BaseModel());
//						afterBusinCd.setValue(new BaseModel());
//						afterTypOccuCd.setValue(new BaseModel());
//						afterLogSvcYrNumCd.setValue(new BaseModel());
//						afterOdtyCd.setValue(new BaseModel());
//						afterAppmtIstut.setValue("");
//						afterAppmtBssCtnt.setValue("");
//						afterAppmtDt.setValue(null);
//						
//						psnl0300Init();
//						
//						BaseModel bmData = new BaseModel();
	//
//						bmData = psnl0300GridPanel.getCurrentlySelectedItem();
//						
//						if(bmData.get("pic") != null && !"".equals(bmData.get("pic")) ){
//							picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermPhoto")+"/" + bmData.get("pic"));
//						}else{
//							picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//						}
//						
//						if("Y".equals(bmData.get("appmtFixYn"))){
//							
//							appmtDivCd.setValue(new BaseModel());
//							appmtName.setValue("");
//							appmtResnRegnNum.setValue("");
//							appmtHdofcCodtnCd.setValue(new BaseModel());
//							beforeCurrDeptCdNm.setValue("");
//							beforeBusinCdNm.setValue("");
//							beforeTypOccuCdNm.setValue("");
//							beforeOdtyCdNm.setValue("");
//							beforeLogSvcYrNumCdNm.setValue("");
//							afterCurrDeptCd.setValue(new BaseModel());
//							afterBusinCd.setValue(new BaseModel());
//							afterTypOccuCd.setValue(new BaseModel());
//							afterLogSvcYrNumCd.setValue(new BaseModel());
//							afterOdtyCd.setValue(new BaseModel());
//							afterAppmtIstut.setValue("");
//							afterAppmtBssCtnt.setValue("");
//							afterAppmtDt.setValue(null);
//							
//						}else{
//								dpobCd.setValue(MSFSharedUtils.allowNulls((String) bmData.get("dpobCd")));
//								systemkey.setValue(MSFSharedUtils.allowNulls((String) bmData.get("systemkey")));
//								
//								PersonalUtil.setSelectedComboValue(appmtDivCd, (String) bmData.get("appmtDivCd"), "commCd");	//발령구분
//								appmtName.setValue((String) bmData.get("hanNm"));				//성명
//								appmtResnRegnNum.setValue((String) bmData.get("resnRegnNum"));	//주민번호
//								
//								//재직구분
//								PersonalUtil.setSelectedComboValue(appmtHdofcCodtnCd, (String) bmData.get("hdofcCodtnCd"), "commCd");
//								beforeCurrDeptCdNm.setValue((String) bmData.get("bfrDeptNm"));			//부서
//								beforeBusinCdNm.setValue((String) bmData.get("bfrDeptNm"));				//사업
//								beforeTypOccuCdNm.setValue((String) bmData.get("bfrTypOccuDivNm"));		//직종
//								beforeOdtyCdNm.setValue((String) bmData.get("bfrOdtyDivNm"));			//직책
//								beforeLogSvcYrNumCdNm.setValue((String) bmData.get("logSvcYrNumCd"));	//근속년수
//								
//								PersonalUtil.setSelectedComboValue(afterCurrDeptCd, (String) bmData.get("aftDeptCd"), "deptCd");
//								afterCurrDeptCd.fireEvent(Events.Change);
//								
//								PersonalUtil.setSelectedComboValue(afterTypOccuCd, (String) bmData.get("aftTypOccuDivCd"), "commCd");
//								PersonalUtil.setSelectedComboValue(afterLogSvcYrNumCd, (String) bmData.get("aftLogSvcYrNumCd"), "commCd");
//								PersonalUtil.setSelectedComboValue(afterOdtyCd, (String) bmData.get("aftOdtyDivCd"), "commCd");
//								afterAppmtIstut.setValue((String) bmData.get("appmtIstut"));
//								afterAppmtBssCtnt.setValue((String) bmData.get("appmtBssCtnt"));
//								afterAppmtDt.setValue(DateTimeFormat.getFormat("yyyy.MM.dd").parse((String) bmData.get("appmtDt")));
//		        	   } 
//			       }
				}
			});  
			cp01.add(psnl0300GridPanel);
			
//			RowNumberer r = new RowNumberer();
//			List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//			final CheckBoxSelectionModel<Psnl0300DTO> sm = new CheckBoxSelectionModel<Psnl0300DTO>();
//			
//			configs.add(r);
//			
//			configs.add(sm.getColumn());
	//
//			ColumnConfig column = new ColumnConfig();
//			column.setId("appmtDivCdNm");
//			column.setHeaderText("발령구분");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(100);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("appmtDt");
//			column.setHeaderText("발령일자");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(80);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("hanNm");
//			column.setHeaderText("성명");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(80);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("resnRegnNum");
//			column.setHeaderText("주민번호");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(80);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("appmtFixYnNm");
//			column.setHeaderText("상태");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(80);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("bfrDeptCd");
//			column.setHeaderText("전부서");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(110);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("bfrBusinCd");
//			column.setHeaderText("전사업");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(110);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("bfrTypOccuDivCd");
//			column.setHeaderText("전직종");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(90);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("bfrOdtyDivCd");
//			column.setHeaderText("전직책");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(100);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("bfrPyspCd");
//			column.setHeaderText("전호봉");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(100);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("aftDeptNm");
//			column.setHeaderText("후부서");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(110);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("aftBusinNm");
//			column.setHeaderText("후사업");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(110);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("aftTypOccuDivNm");
//			column.setHeaderText("후직종");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(90);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("aftOdtyDivNm");
//			column.setHeaderText("후직책");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(100);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("aftPyspNm");
//			column.setHeaderText("후호봉");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(100);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("appmtBssCtnt");
//			column.setHeaderText("발령근거사유");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(150);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
	//
//			column = new ColumnConfig();
//			column.setId("appmtIstut");
//			column.setHeaderText("발령기관");
//			column.setAlignment(HorizontalAlignment.CENTER);
//			column.setWidth(100);
//			column.setMenuDisabled(true);
//			column.setSortable(false);
//			configs.add(column);
//			
//			ColumnModel cm = new ColumnModel(configs);
	//
//			psnl0300Grid = new Grid<Psnl0300DTO>(storePsnl0300, cm);
//			psnl0300Grid.setStateful(true);
//			psnl0300Grid.setSelectionModel(sm);
//			psnl0300Grid.setBorders(true);
//			psnl0300Grid.setColumnReordering(true);
//			psnl0300Grid.setLoadMask(true);
//			psnl0300Grid.addPlugin(sm);
//			psnl0300Grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<Psnl0300DTO>() {
//				@Override
//				public void selectionChanged(SelectionChangedEvent<Psnl0300DTO> se) {
//					if(se.getSelectedItem() == null){
//						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//						appmtDivCd.setValue(new BaseModel());
//						appmtName.setValue("");
//						appmtResnRegnNum.setValue("");
//						appmtHdofcCodtnCd.setValue(new BaseModel());
//						beforeCurrDeptCdNm.setValue("");
//						beforeBusinCdNm.setValue("");
//						beforeTypOccuCdNm.setValue("");
//						beforeOdtyCdNm.setValue("");
//						beforeLogSvcYrNumCdNm.setValue("");
//						afterCurrDeptCd.setValue(new BaseModel());
//						afterBusinCd.setValue(new BaseModel());
//						afterTypOccuCd.setValue(new BaseModel());
//						afterLogSvcYrNumCd.setValue(new BaseModel());
//						afterOdtyCd.setValue(new BaseModel());
//						afterAppmtIstut.setValue("");
//						afterAppmtBssCtnt.setValue("");
//						afterAppmtDt.setValue(null);
//					}else{
//						if(se.getSelectedItem().getPic() != null && !"".equals(se.getSelectedItem().getPic()) ){
//							picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermPhoto")+"/"+se.getSelectedItem().getPic() );
//						}else{
//							picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//						}
//						if("Y".equals(se.getSelectedItem().getAppmtFixYn())){
//							appmtDivCd.setValue(new BaseModel());
//							appmtName.setValue("");
//							appmtResnRegnNum.setValue("");
//							appmtHdofcCodtnCd.setValue(new BaseModel());
//							beforeCurrDeptCdNm.setValue("");
//							beforeBusinCdNm.setValue("");
//							beforeTypOccuCdNm.setValue("");
//							beforeOdtyCdNm.setValue("");
//							beforeLogSvcYrNumCdNm.setValue("");
//							afterCurrDeptCd.setValue(new BaseModel());
//							afterBusinCd.setValue(new BaseModel());
//							afterTypOccuCd.setValue(new BaseModel());
//							afterLogSvcYrNumCd.setValue(new BaseModel());
//							afterOdtyCd.setValue(new BaseModel());
//							afterAppmtIstut.setValue("");
//							afterAppmtBssCtnt.setValue("");
//							afterAppmtDt.setValue(null);
//						}else{
//							//발령구분
//							PersonalUtil.setSelectedComboValue(appmtDivCd, se.getSelectedItem().getAppmtDivCd(), "commCd");	
//							appmtName.setValue(se.getSelectedItem().getHanNm());				//성명
//							appmtResnRegnNum.setValue(se.getSelectedItem().getResnRegnNum());	//주민번호
//							
//							//재직구분
//							PersonalUtil.setSelectedComboValue(appmtHdofcCodtnCd, se.getSelectedItem().getHdofcCodtnCd(), "commCd");
//							beforeCurrDeptCdNm.setValue(se.getSelectedItem().getBfrDeptCd());		//부서
//							beforeBusinCdNm.setValue(se.getSelectedItem().getBfrBusinCd());			//사업
//							beforeTypOccuCdNm.setValue(se.getSelectedItem().getBfrTypOccuDivCd());	//직종
//							beforeOdtyCdNm.setValue(se.getSelectedItem().getBfrOdtyDivCd());		//직책
//							beforeLogSvcYrNumCdNm.setValue(se.getSelectedItem().getLogSvcYrNumCd());//근속년수
//							
//							PersonalUtil.setSelectedComboValue(afterCurrDeptCd, se.getSelectedItem().getAftDeptCd(), "deptCd");
//							afterCurrDeptCd.fireEvent(Events.Change, se);
//							
//							PersonalUtil.setSelectedComboValue(afterTypOccuCd, se.getSelectedItem().getAftTypOccuDivCd(), "commCd");
//							PersonalUtil.setSelectedComboValue(afterLogSvcYrNumCd, se.getSelectedItem().getAftLogSvcYrNumCd(), "commCd");
//							PersonalUtil.setSelectedComboValue(afterOdtyCd, se.getSelectedItem().getAftOdtyDivCd(), "commCd");
//							afterAppmtIstut.setValue(se.getSelectedItem().getAppmtIstut());
//							afterAppmtBssCtnt.setValue(se.getSelectedItem().getAppmtBssCtnt());
//							afterAppmtDt.setValue(DateTimeFormat.getFormat("yyyy.MM.dd").parse(se.getSelectedItem().getAppmtDt()));
//						}
//					}
//				}
//			});
//			
//			cp01.add(psnl0300Grid);
			
			lcTabFormLayer.add(cp01);

			return lcTabFormLayer;
	}
	
	
	
	
	//TODO 검색설정 
	private void createSearchForm() {

		
		sysComBass0320Dto = new PrgmComBass0320DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		
		listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		 
		 //-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);

		
		plFrmPsnl0300.setLayout(new FlowLayout());

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
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// frmlytSch.setDefaultWidth(100);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);

		searchAppmtDivCd = new ComboBox<BaseModel>();
		searchAppmtDivCd.setFieldLabel("발령구분");
		searchAppmtDivCd.setForceSelection(true);
		searchAppmtDivCd.setMinChars(1);
		searchAppmtDivCd.setDisplayField("commCdNm");
		searchAppmtDivCd.setValueField("commCd");
		searchAppmtDivCd.setTriggerAction(TriggerAction.ALL);
		searchAppmtDivCd.setEmptyText("--발령구분선택--");
		searchAppmtDivCd.setSelectOnFocus(true);
		searchAppmtDivCd.setStore(listStoreA046);
		lcSchLeft.add(searchAppmtDivCd, new FormData("100%"));

		
		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytSch);
 
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
//	    		sysComBass0400Dto = new PrgmComBass0400DTO();
//  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
//  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
//  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//  	    		
//  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
//  	    			}
//  	    		});  
  	    		emptyCheck = true;
	    	} 
	    });
        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
            	
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {   
                	
                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
//	                	sysComBass0400Dto = new PrgmComBass0400DTO();
//	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
//	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
//	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//	      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//	      	    		
//	      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//	      	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
//	      	    			} 
//	      	    			
//	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        
		layoutContainer.add(srhMangeDeptCd, new FormData("100%"));

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

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
	    			
	    			  if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
	            		   //2015.11.30 권한 직종가져오기  추가 
	            		 //  sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	            		   sysComBass0320Dto.setDeptCd(srhDeptCd.getValue());
	            		   listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   searchTypOccuCd.setStore(listStoreA041);
	            		  
	            	   } else {
	            		      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
		                      sysComBass0500Dto.setBusinApptnYr(""); 
		                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue());  
		                  
		                    //--------------------사업 불러 오는 함수 -------------------------------------------------
		                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		                     //--------------------사업 불러 오는 함수 -------------------------------------------------
		                      searchBusinCd.setStore(lsBusinCd); 
			                  searchBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			                    	public void handleEvent(StoreEvent<BaseModel> be) {  
			                    		//searchBusinCd.setValue(lsBusinCd.getAt(0));  
			                         }
			                    });    
	            	   } 
	    		} 
	    	}
	    });
//	    plFrmPsnl0300.add(srhDeptCd);
//	    srhMangeDeptCd = new TextField<String>();
//	    srhMangeDeptCd.setName("srhMangeDeptCd");
//	    srhMangeDeptCd.setVisible(false);
//	    plFrmPsnl0300.add(srhMangeDeptCd);
//	    srhMangeDeptNm = new TextField<String>();
//	    srhMangeDeptNm.setName("srhMangeDeptNm");
//	    srhMangeDeptNm.setVisible(false);
//	    srhMangeDeptNm.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//	    srhMangeDeptNm.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
//	    plFrmPsnl0300.add(srhMangeDeptNm);
	 
	    LayoutContainer lcDeptNm = new LayoutContainer(); 
	    frmlytSch = new FormLayout();
	    frmlytSch.setLabelWidth(70);
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
	    			//srhMangeDeptCd.setValue("");
	    		}
	    		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	    			//if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
	    				srhDeptCd.setValue("");
	    			//	srhMangeDeptCd.setValue("");
	    			//}
	    			fnPopupCommP140(srhDeptNm.getValue());
	    		}
	    		super.componentKeyDown(event);
	    	}
	    });
	        
//	    srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	    	@Override
//	    	public void handleEvent(BaseEvent be) { 
//	    		if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	    			srhDeptCd.setValue("");
//	    			srhMangeDeptCd.setValue("");
//	    		}
//	                    
//	    	} 
//	    });   
	    
	    lcDeptNm.add(srhDeptNm, new FormData("100%"));  
	    btnSrhDeptCd = new Button();
	    btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
	    btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	    btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) { 
	    		if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
	    			srhDeptCd.setValue("");
	    			//srhMangeDeptCd.setValue("");
	    		}
	    		fnPopupCommP140(srhDeptNm.getValue()); 
	    	}
	    });
	           
	    lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
	    lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	           
		layoutContainer_1.add(lccmlcDeptNm, new FormData("100%"));
		

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);
		layoutContainer_8.setBorders(false);
		
		lcSchCol.add(lcSchLeft,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol.add(layoutContainer_1,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol.add(layoutContainer_8,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		fieldSet.add(lcSchCol, new FormData("100%"));


		searchEmymtDivCd = new ComboBox<BaseModel>();
		searchEmymtDivCd.setFieldLabel("고용구분");
		searchEmymtDivCd.setForceSelection(true);
		searchEmymtDivCd.setMinChars(1);
		searchEmymtDivCd.setDisplayField("commCdNm");
		searchEmymtDivCd.setValueField("commCd");
		searchEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		searchEmymtDivCd.setEmptyText("--고용구분선택--");
		searchEmymtDivCd.setSelectOnFocus(true);
		searchEmymtDivCd.setName("searchEmymtDivCd");
		searchEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		searchEmymtDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				String emymt = searchEmymtDivCd.getValue() == null ? "" : String.valueOf(searchEmymtDivCd.getValue().get("commCd")) ;
				
				if(MSFConfiguration.EMYMT_DIVCD01.equals(emymt)){ //공무직일 경우
					 searchBusinCd.setValue(new BaseModel());
					 searchTypOccuCd.setValue(new BaseModel());
					 searchBusinCd.setEnabled(false); 
					 srhDeptCd.fireEvent(Events.Add); 
	                 if (gwtExtAuth.getEnableTypOccuCd()) { 
	                	 searchTypOccuCd.setEnabled(true);
	                    // srhDtilOccuInttnCd.setEnabled(true); 
	                 } else { 
	                	 searchTypOccuCd.setEnabled(false);
	                    // srhDtilOccuInttnCd.setEnabled(false);
	                     
	                 }
					
				}else if(MSFConfiguration.EMYMT_DIVCD02.equals(emymt)){ //기간제 계약직일 경우
					srhDeptCd.fireEvent(Events.Add); 
					searchBusinCd.setValue(new BaseModel());
					searchTypOccuCd.setValue(new BaseModel());
					searchBusinCd.setEnabled(true);
					searchTypOccuCd.setEnabled(false);
				} 
//				else{
//					searchBusinCd.setValue(new BaseModel());
//					searchTypOccuCd.setValue(new BaseModel());
//					searchBusinCd.setEnabled(true);
//					searchTypOccuCd.setEnabled(true);
//				}
				 
			}
		});
		searchEmymtDivCd.setStore(listStoreA002);
		listStoreA002.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) { 
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   checkPsnl0300Auth("searchEmymtDivCd", listStoreA002); 
              	 }
		    }
		}); 
		
		layoutContainer_8.add(searchEmymtDivCd, new FormData("100%"));

		searchTypOccuCd = new ComboBox<BaseModel>();
        searchTypOccuCd.setFieldLabel("직종");
        searchTypOccuCd.setForceSelection(true);
        searchTypOccuCd.setMinChars(1);
        searchTypOccuCd.setDisplayField("typOccuNm");
        searchTypOccuCd.setValueField("typOccuCd");
        searchTypOccuCd.setTriggerAction(TriggerAction.ALL);
        searchTypOccuCd.setEmptyText("--직종선택--");
        searchTypOccuCd.setSelectOnFocus(true);
        searchTypOccuCd.setStore(listStoreA041);
        searchTypOccuCd.setName("searchTypOccuCd");
        searchTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        searchTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		lcSchLeft.add(searchTypOccuCd, new FormData("100%"));
		searchTypOccuCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) { 
				//2015.11.30 추가 
				if (!gwtExtAuth.getEnableTypOccuCd()) {
					
					BaseModel  mdSelect  = searchTypOccuCd.getStore().getAt(0) ; 
					searchTypOccuCd.setValue( mdSelect); 
		                    
				}   
			}
		});   
		   
		searchBusinCd = new ComboBox<BaseModel>();
		searchBusinCd.setFieldLabel("사업명");
		searchBusinCd.setForceSelection(true);
		searchBusinCd.setMinChars(1);
		searchBusinCd.setDisplayField("businNm");
		searchBusinCd.setValueField("businCd");
		searchBusinCd.setTriggerAction(TriggerAction.ALL);
		searchBusinCd.setEmptyText("--사업선택--");
		searchBusinCd.setSelectOnFocus(true);
		searchBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		searchBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
		searchBusinCd.setStore(new ListStore<BaseModel>());
		searchBusinCd.setName("searchBusinCd");
		layoutContainer.add(searchBusinCd, new FormData("100%"));
		
		
		LayoutContainer layoutNm = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutNmFld = new LayoutContainer();
		
		frmlytSch = new FormLayout();
	    frmlytSch.setLabelWidth(70);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	    layoutNmFld.setLayout(frmlytSch);
	    

		 
		searchName = new TextField<String>();
        searchName.setFieldLabel("성명");
		searchName.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				super.componentKeyUp(event);
				searchName.validate();
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {

					systemkey.setValue("");
					fnPopupPsnl0100();
				}
			}
		});
        
//        searchName.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
//                super.componentKeyUp(event);
//                searchName.validate();
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                	
//                	systemkey.setValue("");
//                    fnPopupPsnl0100();
//                }
//            }
//        });
        layoutNmFld.add(searchName, new FormData("100%"));
        layoutNm.add(layoutNmFld, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
        
//        LayoutContainer layoutContainer_2 = new LayoutContainer();
//        frmlytSch = new FormLayout();
//        frmlytSch.setLabelWidth(1);
//        frmlytSch.setLabelAlign(LabelAlign.LEFT);
//        layoutContainer_2.setLayout(frmlytSch);
        
        LayoutContainer layoutNmdBtn = new LayoutContainer();
        
        Button button = new Button("검색");
        button.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
            	
                fnPopupPsnl0100();
            }
        });
        layoutNmdBtn.add(button, new FormData("100%"));
        layoutNm.add(layoutNmdBtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
        layoutContainer_1.add(layoutNm, new FormData("100%"));
        
    	searchAppmtFixYn = new ComboBox<BaseModel>();
		searchAppmtFixYn.setFieldLabel("발령상태");
		searchAppmtFixYn.setForceSelection(true);
		searchAppmtFixYn.setMinChars(1);
		searchAppmtFixYn.setDisplayField("commCdNm");
		searchAppmtFixYn.setValueField("commCd");
		searchAppmtFixYn.setTriggerAction(TriggerAction.ALL);
		searchAppmtFixYn.setEmptyText("--발령상태선택--");
		searchAppmtFixYn.setSelectOnFocus(true);
		ListStore<BaseModel> tempStore = new ListStore<BaseModel>();
		BaseModel tempBm = new BaseModel();
		tempBm.set("commCd", "Y");
		tempBm.set("commCdNm", "확정");
		tempStore.add(tempBm);
		tempBm = new BaseModel();
		tempBm.set("commCd", "N");
		tempBm.set("commCdNm", "미확정");
		tempStore.add(tempBm);
		searchAppmtFixYn.setStore(tempStore);
		
		layoutContainer_1.add(searchAppmtFixYn, new FormData("100%"));
        
//        layoutContainer_1.add(searchName, new FormData("100%"));
         
        LayoutContainer layoutContainer_3 = new LayoutContainer();
//        layoutContainer_3.setLayout(new ColumnLayout());

//        LayoutContainer layoutContainer_2 = new LayoutContainer();
//        frmlytSch = new FormLayout();
//        frmlytSch.setLabelWidth(1);
//        frmlytSch.setLabelAlign(LabelAlign.LEFT);
//        layoutContainer_2.setLayout(frmlytSch);
//        
//        Button button = new Button("검색");
//        button.addSelectionListener(new SelectionListener<ButtonEvent>() {
//            @Override
//            public void componentSelected(ButtonEvent ce) {
//                fnPopupPsnl0100();
//            }
//        });
//        layoutContainer_2.add(button, new FormData("100%"));
        
        LayoutContainer layoutContainer_21 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_21.setLayout(frmlytSch);
 
        searchResnRegnNum = new TextField<String>();
        searchResnRegnNum.setFieldLabel("주민번호");
        
        layoutContainer_21.add(searchResnRegnNum, new FormData("100%"));
        
//        layoutContainer_3.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//        layoutContainer_3.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
        layoutContainer_3.add(layoutContainer_21, new FormData("100%"));
        
        layoutContainer_8.add(layoutContainer_3, new FormData("100%"));
         

		searchAppmtDtS = new DateField();
		searchAppmtDtS.setFieldLabel("발령일자");
		new DateFieldMask(searchAppmtDtS, "9999.99.99");
		searchAppmtDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		lcSchLeft.add(searchAppmtDtS, new FormData("100%"));
		
		searchAppmtDtE = new DateField();
		new DateFieldMask(searchAppmtDtE, "9999.99.99");
		searchAppmtDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchAppmtDtE.setFieldLabel("");
		searchAppmtDtE.setLabelSeparator("~");
		searchAppmtDtE.setLabelStyle("text-align:center;");
		layoutContainer.add(searchAppmtDtE, new FormData("100%"));
		 
		plFrmPsnl0300.add(fieldSet);
		// vp.add(panel);
	}
	
	//중간부분 설정
	private void createStandardForm() {

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setStyleAttribute("padding", "10px");
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setStyleAttribute("text-align", "right");
		layoutContainer_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		midAppmtDivCd = new MSFComboBox<BaseModel>();
		midAppmtDivCd.setFieldLabel("발령구분");
		midAppmtDivCd.setForceSelection(true);
		midAppmtDivCd.setMinChars(1);
		midAppmtDivCd.setDisplayField("commCdNm");
		midAppmtDivCd.setValueField("commCd");
		midAppmtDivCd.setTriggerAction(TriggerAction.ALL);
		midAppmtDivCd.setEmptyText("--선택--");
		midAppmtDivCd.setSelectOnFocus(true);
		midAppmtDivCd.setStore(listStoreA046);
		layoutContainer_2.add(midAppmtDivCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		FormLayout frmlyt_4 = new FormLayout();
		frmlyt_4.setLabelWidth(70);
		frmlyt_4.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlyt_4);
		
		midEmymtDivCd = new MSFComboBox<BaseModel>();
		midEmymtDivCd.setFieldLabel("고용구분");
		midEmymtDivCd.setForceSelection(true);
		midEmymtDivCd.setMinChars(1);
		midEmymtDivCd.setDisplayField("commCdNm");
		midEmymtDivCd.setValueField("commCd");
		midEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		midEmymtDivCd.setEmptyText("--선택--");
		midEmymtDivCd.setSelectOnFocus(true);
		midEmymtDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				String emymt = midEmymtDivCd.getValue() == null ? "" : String.valueOf(midEmymtDivCd.getValue().get("commCd")) ;
				
				if(MSFConfiguration.EMYMT_DIVCD01.equals(emymt)){ 		// 공무직일 경우
					midBusinCd.setValue(new BaseModel());
					midTypOccuCd.setValue(new BaseModel());
					midBusinCd.setEnabled(false);
					midTypOccuCd.setEnabled(true);
					
				}else if(MSFConfiguration.EMYMT_DIVCD02.equals(emymt)){ // 기간제 계약직일 경우
					midBusinCd.setValue(new BaseModel());
					midTypOccuCd.setValue(new BaseModel());
					midBusinCd.setEnabled(true);
					midTypOccuCd.setEnabled(false);
				}else{
					midBusinCd.setValue(new BaseModel());
					midTypOccuCd.setValue(new BaseModel());
					midBusinCd.setEnabled(true);
					midTypOccuCd.setEnabled(true);
				}
			}
		});
		midEmymtDivCd.setStore(listStoreA002);
		layoutContainer_4.add(midEmymtDivCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		
		LayoutContainer layoutContainer_61 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_61.setLayout(frmlytSch);
		
		midDeptCd = new MSFComboBox<BaseModel>();
		midDeptCd.setFieldLabel("부서");
		midDeptCd.setForceSelection(true);
		midDeptCd.setMinChars(1);
		midDeptCd.setDisplayField("deptNmRtchnt");
		midDeptCd.setValueField("deptCd");
		midDeptCd.setTriggerAction(TriggerAction.ALL);
		midDeptCd.setEmptyText("--부서선택--");
		midDeptCd.setSelectOnFocus(true);
		midDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) { 
				if(String.valueOf(midDeptCd.getValue().get("deptCd")) != null){
					
					String deptCd = String.valueOf(midDeptCd.getValue().get("deptCd"));
						
					PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
					sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
					sysComBass0500Dto.setDeptCd(deptCd);
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					midBusinCd.setStore(lsBusinCd); 
					midBusinCd.setEmptyText("--사업명선택--");
					midBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
				                   		//searchBusinCd.setValue(lsBusinCd.getAt(0));  
				        }
					});  
				}
			}
		});			
//		midDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				if(midDeptCd.getValue() != null){
//					InfcComBass0500DTO dto = new InfcComBass0500DTO();
//					dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
//					dto.setDeptCd(String.valueOf(midDeptCd.getValue().get("deptCd")));
//					
//					psnl0100Service.getBusinList(dto, new AsyncCallback<List<BaseModel>>() {
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							midBusinCd.setStore(ls);
//							midBusinCd.setEmptyText("--사업명선택--");
//							midBusinCd.setValue(new BaseModel());
//						}
//						
//						@Override
//						public void onFailure(Throwable caught) {
//							caught.printStackTrace();
//							MessageBox.alert("", "사업코드 에러!", null);
//						}
//					});
//				}else{
//					midBusinCd.setStore(new ListStore<BaseModel>());
//					midBusinCd.setEmptyText("--부서선택--");
//					midBusinCd.setValue(new BaseModel());
//				}
//			}
//		});
		midDeptCd.setStore(listStoreBass0400All);
		layoutContainer_61.add(midDeptCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_61,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		
		LayoutContainer layoutContainer_611 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_611.setLayout(frmlytSch);
		
		midBusinCd = new MSFComboBox<BaseModel>();
		midBusinCd.setFieldLabel("사업명");
		midBusinCd.setForceSelection(true);
		midBusinCd.setMinChars(1);
		midBusinCd.setDisplayField("businNm");
		midBusinCd.setValueField("businCd");
		midBusinCd.setTriggerAction(TriggerAction.ALL);
		midBusinCd.setEmptyText("--부서선택--");
		midBusinCd.setSelectOnFocus(true);
		midBusinCd.setStore(new ListStore<BaseModel>());
		layoutContainer_611.add(midBusinCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_611,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		
		
		
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);
		
		midTypOccuCd = new MSFComboBox<BaseModel>();
		midTypOccuCd.setFieldLabel("직 종");
		midTypOccuCd.setForceSelection(true);
		midTypOccuCd.setMinChars(1);
		midTypOccuCd.setDisplayField("typOccuNm");
		midTypOccuCd.setValueField("typOccuCd");
		midTypOccuCd.setTriggerAction(TriggerAction.ALL);
		midTypOccuCd.setEmptyText("--직종선택--");
		midTypOccuCd.setSelectOnFocus(true);
		midTypOccuCd.setStore(listStoreA041);
		layoutContainer_6.add(midTypOccuCd, new FormData("100%"));
		layoutContainer_6.setBorders(false);
		layoutContainer_1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));

		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNewButton_1 = new Button("일괄발령");
		btnNewButton_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				String appmtDivCd = PersonalUtil.getSelectedComboValue(midAppmtDivCd, "commCd");
				String emymtDivCd = PersonalUtil.getSelectedComboValue(midEmymtDivCd, "commCd");
				String deptCd = PersonalUtil.getSelectedComboValue(midDeptCd, "deptCd");
				String businCd = PersonalUtil.getSelectedComboValue(midBusinCd, "businCd");
				String typOccuCd = PersonalUtil.getSelectedComboValue(midTypOccuCd, "commCd");
				
				String appmtDivCdNm = PersonalUtil.getSelectedComboValue(midAppmtDivCd, "commCdNm");
				String emymtDivCdNm = PersonalUtil.getSelectedComboValue(midEmymtDivCd, "commCdNm");
				String deptCdNm = PersonalUtil.getSelectedComboValue(midDeptCd, "deptNmRtchnt");
				String businCdNm = PersonalUtil.getSelectedComboValue(midBusinCd, "businNm");
				String typOccuCdNm = PersonalUtil.getSelectedComboValue(midTypOccuCd, "typOccuNm");
				
				if("".equals(appmtDivCd)){
					MessageBox.info("", "발령구분을 선택하여주세요.", null);
				}else if("".equals(emymtDivCd)) {
					MessageBox.info("", "고용구분을 선택하여주세요.", null);
				}else{
					Dialog complex = PsnlP0300.getPsnlP0300Form(appmtDivCd
																, emymtDivCd
																, deptCd
																, businCd
																, typOccuCd
																, appmtDivCdNm
																, emymtDivCdNm
																, deptCdNm
																, businCdNm
																, typOccuCdNm
																, listStoreA041
																, listStoreA007
																, listStoreA015
																, listStoreBass0400All);
					complex.show();
				}
			}
		});
		
		buttonBar.add(btnNewButton_1);
		layoutContainer_1.add(buttonBar,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		layoutContainer_5.add(layoutContainer_1);
		layoutContainer_1.setBorders(false);
		plFrmPsnl0300.add(layoutContainer_5);
		layoutContainer_5.setBorders(true);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new FlowLayout());

		FieldSet fldstNewFieldset_2 = new FieldSet();
//		fldstNewFieldset_2.setSize(958, 150);
		fldstNewFieldset_2.setSize("965px", "225px");
		layoutContainer_3.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("발령내역");
		fldstNewFieldset_2.setCollapsible(false);

		fldstNewFieldset_2.add(occupationalRBottom(), new FormData("100%"));

		plFrmPsnl0300.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize(140, 225);
		

		ContentPanel contentPanel = new ContentPanel();
		contentPanel.setHeaderVisible(false);
		contentPanel.setHeadingText("");
		contentPanel.setSize(120, 150);
		
		//picImg = new Image(GWT.getHostPageBaseURL()+MSFConfiguration.NON_EXTERM_PHOTO);
		picImg = new Image();
		picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		picImg.setSize("136px", "150px");
		picImg.setVisible(true);
		picImg.setTitle("사진");
		contentPanel.add(picImg);
		
		fldstNewFieldset.add(contentPanel);
		
		layoutContainer_11.add(fldstNewFieldset);
		layoutContainer_11.setBorders(false);
		fldstNewFieldset.setHeadingHtml("발령대상자정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_11,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		fldstNewFieldset.add(occupationalLeft(), new FormData("100%"));

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_1 = new FieldSet();
//		fldstNewFieldset_1.setSize(814, 260);
		//엣지변환
		//fldstNewFieldset_1.setSize("819px", "235px");
		fldstNewFieldset_1.setSize("819px", "255px");

		layoutContainer_21.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("개별발령");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.add(occupationalRTop(), new FormData("100%"));

		LayoutContainer layoutContainer_31 = new LayoutContainer();
		layoutContainer_31.setLayout(new ColumnLayout());

		fldstNewFieldset_1.add(layoutContainer_31);
		layoutContainer_31.setBorders(false);

		layoutContainer.add(layoutContainer_21,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		layoutContainer_21.setBorders(false);

		plFrmPsnl0300.add(layoutContainer);
		layoutContainer.setBorders(false);
	}
	
	
	//TODO 발령설정
	private LayoutContainer occupationalRTop() {

		LayoutContainer lcTabFormLayer = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer = new LayoutContainer();
		FormLayout fl = new FormLayout();
		fl.setLabelWidth(80);
		fl.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(fl);
		appmtDivCd = new MSFComboBox<BaseModel>();
		appmtDivCd.setFieldLabel("발령구분");
		appmtDivCd.setForceSelection(true);
		appmtDivCd.setMinChars(1);
		appmtDivCd.setDisplayField("commCdNm");
		appmtDivCd.setValueField("commCd");
		appmtDivCd.setTriggerAction(TriggerAction.ALL);
		appmtDivCd.setEmptyText("--발령구분선택--");
		appmtDivCd.setSelectOnFocus(true);
		appmtDivCd.setStore(listStoreA046);
		layoutContainer.add(appmtDivCd, new FormData("100%"));
		
		LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		FormLayout fl_1_1 = new FormLayout();
		fl_1_1.setLabelWidth(80);
		fl_1_1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1_1.setLayout(fl_1_1);
		appmtName = new MSFTextField();
		appmtName.setFieldLabel("성명");
		
		layoutContainer_1_1.add(appmtName,new FormData("100%"));
		
		LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		FormLayout fl_1_2 = new FormLayout();
		fl_1_2.setLabelWidth(80);
		fl_1_2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1_2.setLayout(fl_1_2);
		
		Button button = new Button("검색");
		button.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				systemkey.setValue("");
				fnPopupPsnl0100_2();
			}
		});
		
		layoutContainer_1_2.add(button,new FormData("100%"));
		
		
		layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.85));
		layoutContainer_1.add(layoutContainer_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
		
		appmtResnRegnNum = new MSFTextField();
		appmtResnRegnNum.setFieldLabel("주민번호");
		layoutContainer_2.add(appmtResnRegnNum, new FormData("100%"));
		
		
		
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(80);
		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch1);
		
		appmtHdofcCodtnCd = new MSFComboBox<BaseModel>();
		appmtHdofcCodtnCd.setFieldLabel("재직구분");
		appmtHdofcCodtnCd.setForceSelection(true);
		appmtHdofcCodtnCd.setMinChars(1);
		appmtHdofcCodtnCd.setDisplayField("commCdNm");
		appmtHdofcCodtnCd.setValueField("commCd");
		appmtHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
		appmtHdofcCodtnCd.setEmptyText("--재직구분선택--");
		appmtHdofcCodtnCd.setSelectOnFocus(true);
		appmtHdofcCodtnCd.setStore(listStoreA003);
		layoutContainer_3.add(appmtHdofcCodtnCd, new FormData("100%"));
		
		
		lcTabFormLayer.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabFormLayer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabFormLayer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabFormLayer.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		FieldSet beforeIssueFieldSet = new FieldSet();
		beforeIssueFieldSet.setHeadingHtml("발령전");
//		beforeIssueFieldSet.setSize(790, 90);
		beforeIssueFieldSet.setSize("812px", "80px");
		
		LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer beforelc1 = new LayoutContainer();
		FormLayout beforefl1 = new FormLayout();
		beforefl1.setLabelWidth(80);
		beforefl1.setLabelAlign(LabelAlign.RIGHT);
		beforelc1.setLayout(beforefl1);
		beforeCurrDeptCdNm = new MSFTextField();
		beforeCurrDeptCdNm.setFieldLabel("부서");
		beforelc1.add(beforeCurrDeptCdNm, new FormData("100%"));
		
		beforeTypOccuCdNm = new MSFTextField();
		beforeTypOccuCdNm.setFieldLabel("직종");
		beforelc1.add(beforeTypOccuCdNm, new FormData("100%"));
		
//		beforeOdtyCdNm = new MSFTextField();
//		beforeOdtyCdNm.setFieldLabel("직책");
//		beforelc1.add(beforeOdtyCdNm, new FormData("100%"));
		
		LayoutContainer beforelc2 = new LayoutContainer();
		FormLayout beforefl2 = new FormLayout();
		beforefl2.setLabelWidth(80);
		beforefl2.setLabelAlign(LabelAlign.RIGHT);
		beforelc2.setLayout(beforefl2);
		beforeBusinCdNm = new MSFTextField();
		beforeBusinCdNm.setFieldLabel("사업");
		beforelc2.add(beforeBusinCdNm, new FormData("100%"));
		
//		beforeLogSvcYrNumCdNm = new MSFTextField();
//		beforeLogSvcYrNumCdNm.setFieldLabel("근속년수");
//		beforelc2.add(beforeLogSvcYrNumCdNm, new FormData("100%"));
		
		beforeDtilOccuInttnNm = new MSFTextField();
		beforeDtilOccuInttnNm.setFieldLabel("직종세");
		beforelc2.add(beforeDtilOccuInttnNm, new FormData("100%"));
	
		LayoutContainer beforelc3 = new LayoutContainer();
		FormLayout beforefl3 = new FormLayout();
		beforefl3.setLabelWidth(80);
		beforefl3.setLabelAlign(LabelAlign.RIGHT);
		beforelc3.setLayout(beforefl3);
		
//		beforeTypOccuCdNm = new MSFTextField();
//		beforeTypOccuCdNm.setFieldLabel("직종");
//		beforelc3.add(beforeTypOccuCdNm, new FormData("100%"));
		beforeOdtyCdNm = new MSFTextField();
		beforeOdtyCdNm.setFieldLabel("직책");
		beforelc3.add(beforeOdtyCdNm, new FormData("100%"));
		
		
		beforeLogSvcYrNumCdNm = new MSFTextField();
		beforeLogSvcYrNumCdNm.setFieldLabel("근속년수");
		beforelc3.add(beforeLogSvcYrNumCdNm, new FormData("100%"));
		
		lc.add(beforelc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lc.add(beforelc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lc.add(beforelc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		beforeIssueFieldSet.add(lc, new FormData("100%"));
		lcTabFormLayer.add(beforeIssueFieldSet);
		
		
		//발령후 부분 시작
		FieldSet afterIssueFieldSet = new FieldSet();
		afterIssueFieldSet.setHeadingHtml("발령후");
//		afterIssueFieldSet.setSize(790, 110);
		//엣지변환
		//afterIssueFieldSet.setSize("812px", "115px");
		afterIssueFieldSet.setSize("812px", "135px");
		
		LayoutContainer afterlc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer afterlc1 = new LayoutContainer();
		FormLayout afterfl1 = new FormLayout();
		afterfl1.setLabelWidth(80);
		afterfl1.setLabelAlign(LabelAlign.RIGHT);
		afterlc1.setLayout(afterfl1);
		afterCurrDeptCd = new MSFComboBox<BaseModel>();
		afterCurrDeptCd.setFieldLabel("부서");
		afterCurrDeptCd.setForceSelection(true);
		afterCurrDeptCd.setMinChars(1);
		afterCurrDeptCd.setDisplayField("deptNmRtchnt");
		afterCurrDeptCd.setValueField("deptCd");
		afterCurrDeptCd.setTriggerAction(TriggerAction.ALL);
		afterCurrDeptCd.setEmptyText("--부서선택--");
		afterCurrDeptCd.setSelectOnFocus(true);
		afterCurrDeptCd.setStore(listStoreBass0400All);
		afterCurrDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) { 
				if(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd") != null){
					String deptCd = PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd");
//					String emymtDivCd = emymtDivCdFld.getValue();
					
					 BaseModel bmData = new BaseModel();
            		 bmData = psnl0300GridPanel.getCurrentlySelectedItem();
//            		 emymtDivCdFld.setValue((String) bmData.get("emymtDivCd"));
//            		 String emymtDivCd = emymtDivCdFld.getValue();
					
            		 String emymtDivCd = "";
            		 
            		 if(emymtDivCdFld.getValue() == null || "".equals(emymtDivCdFld.getValue())) {
            			 
            			 emymtDivCd = (String) bmData.get("emymtDivCd");
            			 
            		 }else {
            			 
            			 emymtDivCd = emymtDivCdFld.getValue();
            		 }
            		 
            		 
					if (MSFConfiguration.EMYMT_DIVCD01.equals(emymtDivCd)) {
						
						
						//2015.11.30 권한 직종가져오기  추가 
						//  sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
						sysComBass0320Dto.setDeptCd(deptCd);
						listStoreA041 = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto); 
						afterTypOccuCd.setStore(listStoreA041);
		            		  
					} else {
						
						PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
						sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
						sysComBass0500Dto.setDeptCd(deptCd);
						//--------------------사업 불러 오는 함수 -------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						//--------------------사업 불러 오는 함수 -------------------------------------------------
						afterBusinCd.setStore(lsBusinCd); 
						afterBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
							public void handleEvent(StoreEvent<BaseModel> be) {  
				                    		//searchBusinCd.setValue(lsBusinCd.getAt(0));  
							
								
								
//							if(tmpBmData != null || !"".equals(tmpBmData)) {
//							
//								String businStr = tmpBmData.get("aftBusinCd");
//								
//								if(!"".equals(businStr))	{
//									PersonalUtil.setSelectedComboValue(afterBusinCd, businStr, "businCd");
//								}
//								
//							}
								
								BaseModel bmData = new BaseModel();
								bmData = psnl0300GridPanel.getCurrentlySelectedItem();
								if(bmData != null || !"".equals(bmData)) {
									PersonalUtil.setSelectedComboValue(afterBusinCd, (String) bmData.get("aftBusinCd"), "businCd");
								}
				        	}
						});  
						
					}
				}
			}
		});	
		
		
		
//		afterCurrDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(final BaseEvent be) {
//				
//				if(afterCurrDeptCd.getValue() != null){
//					InfcComBass0500DTO dto = new InfcComBass0500DTO();
//					dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
//					dto.setDeptCd(String.valueOf(afterCurrDeptCd.getValue().get("deptCd")));
//					
//					psnl0100Service.getBusinList(dto, new AsyncCallback<List<BaseModel>>() {
//						
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							
//							
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							afterBusinCd.setStore(ls);
//							afterBusinCd.setEmptyText("--사업명선택--");
//							afterBusinCd.setValue(new BaseModel());
//							
//									
//							
////							BaseModel bmData = new BaseModel();
////							bmData = psnl0300GridPanel.getCurrentlySelectedItem();
////							PersonalUtil.setSelectedComboValue(afterBusinCd, (String) bmData.get("aftBusinCd") , "businCd");
//							
//							if(be.getSource() instanceof GridSelectionModel){
//								@SuppressWarnings("unchecked")
//								GridSelectionModel<Psnl0300DTO> gsm = (GridSelectionModel<Psnl0300DTO>) be.getSource();
//								PersonalUtil.setSelectedComboValue(afterBusinCd,gsm.getSelectedItem().getAftBusinCd() , "businCd");
//							}
//						}
//						
//						@Override
//						public void onFailure(Throwable caught) {
//							
//							caught.printStackTrace();
//							MessageBox.alert("", "사업코드 에러!", null);
//						}
//					});
//				}else{
//					afterBusinCd.setStore(new ListStore<BaseModel>());
//					afterBusinCd.setEmptyText("--부서선택--");
//					afterBusinCd.setValue(new BaseModel());
//				}
//			}
//		});
		afterlc1.add(afterCurrDeptCd, new FormData("100%"));
		
//		afterOdtyCd = new MSFComboBox<BaseModel>();
//		afterOdtyCd.setFieldLabel("직책");
//		afterOdtyCd.setForceSelection(true);
//		afterOdtyCd.setMinChars(1);
//		afterOdtyCd.setDisplayField("commCdNm");
//		afterOdtyCd.setValueField("commCd");
//		afterOdtyCd.setTriggerAction(TriggerAction.ALL);
//		afterOdtyCd.setEmptyText("--직책선택--");
//		afterOdtyCd.setSelectOnFocus(true);
//		afterOdtyCd.setStore(listStoreA015);
//		afterlc1.add(afterOdtyCd, new FormData("100%"));
		
		afterTypOccuCd = new MSFComboBox<BaseModel>();
		afterTypOccuCd.setFieldLabel("직종");
		afterTypOccuCd.setForceSelection(true);
		afterTypOccuCd.setMinChars(1);
		afterTypOccuCd.setDisplayField("typOccuNm");
		afterTypOccuCd.setValueField("typOccuCd");
		afterTypOccuCd.setTriggerAction(TriggerAction.ALL);
		afterTypOccuCd.setEmptyText("--직종선택--");
		afterTypOccuCd.setSelectOnFocus(true);
		afterTypOccuCd.setStore(listStoreA041);
		//2015.11.30 추가 
//		afterTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent ce) {
//				
//				 BaseModel bmData = new BaseModel();
//        		 bmData = psnl0300GridPanel.getCurrentlySelectedItem();
////        		 emymtDivCdFld.setValue((String) bmData.get("emymtDivCd"));
//        		 
//        		 String emymtDivCd = "";
//        		 
//        		 
//        		 if(emymtDivCdFld.getValue() == null || "".equals(emymtDivCdFld.getValue())) {
//        			 
//        			 emymtDivCd = (String) bmData.get("emymtDivCd");
//        			 
//        		 }else {
//        			 
//        			 emymtDivCd = emymtDivCdFld.getValue();
//        		 }
//        		 
//        		 
//				if (MSFConfiguration.EMYMT_DIVCD01.equals(emymtDivCd)) {
//					
//					
//					if (psnl0300GridPanel.getCurrentlySelectedItem() != null) {  
//						
//						if(!comboBool) {
//							
//							comboBool = true;
//							
//							bmData = new BaseModel();
//							bmData = psnl0300GridPanel.getCurrentlySelectedItem();
//                   		 	PersonalUtil.setSelectedComboValue(afterDtilOccuInttnCd, (String) bmData.get("aftDtilOccuInttnCd"), "dtilOccuInttnCd");
//                   		 	PersonalUtil.setSelectedComboValue(afterTypOccuCd, (String) bmData.get("aftTypOccuDivCd"), "typOccuCd");
//                   		 
//						}
//					}
//					
//					
//					sysComBass0350Dto = new PrgmComBass0350DTO();
////					sysComBass0350Dto.setPayrMangDeptCd(MSFMainApp.get().get);
//					//직종변경에 따른 직종세 값 가져오기
//					String strTypOccuCd = PersonalUtil.getSelectedComboValue(afterTypOccuCd,"typOccuCd"); 
//					sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
//					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
//					sysComBass0350Dto.setDtilOccuClsUseYn("A");           
//					lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
//					afterDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
//					sysComBass0350Dto.setDtilOccuClsUseYn("");
//					
//				
//				} else {
//		                   
//				} 
//			} 
//		}); 
		afterTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
            	BaseModel bmPayYr =  se.getSelectedItem(); 
//            	if (bmPayYr != null) {
            	 BaseModel bmData = new BaseModel();
        		 bmData = psnl0300GridPanel.getCurrentlySelectedItem();
//        		 emymtDivCdFld.setValue((String) bmData.get("emymtDivCd"));
        		 
        		 String emymtDivCd = "";
        		 
        		 
        		 if(emymtDivCdFld.getValue() == null || "".equals(emymtDivCdFld.getValue())) {
        			 
        			 emymtDivCd = (String) bmData.get("emymtDivCd");
        			 
        		 }else {
        			 
        			 emymtDivCd = emymtDivCdFld.getValue();
        		 }
        		 
        		 
				if (MSFConfiguration.EMYMT_DIVCD01.equals(emymtDivCd)) {
					
					
					
					if (psnl0300GridPanel.getCurrentlySelectedItem() != null) {  
						
						
						if(!comboBool) {
							comboBool = true;
							
							bmData = new BaseModel();
							bmData = psnl0300GridPanel.getCurrentlySelectedItem();
                   		 	PersonalUtil.setSelectedComboValue(afterDtilOccuInttnCd, (String) bmData.get("aftDtilOccuInttnCd"), "dtilOccuInttnCd");
                   		 	PersonalUtil.setSelectedComboValue(afterTypOccuCd, (String) bmData.get("aftTypOccuDivCd"), "typOccuCd");
						}
					}
					
					sysComBass0350Dto = new PrgmComBass0350DTO();
//					sysComBass0350Dto.setPayrMangDeptCd(MSFMainApp.get().get);
					//직종변경에 따른 직종세 값 가져오기
					String strTypOccuCd = PersonalUtil.getSelectedComboValue(afterTypOccuCd,"typOccuCd"); 
					sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
					sysComBass0350Dto.setDtilOccuClsUseYn("A");           
					lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
					afterDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
					sysComBass0350Dto.setDtilOccuClsUseYn("");
					
					
				} else {
		                   
				} 
            		
//            	}       
            } 
        });  
		afterlc1.add(afterTypOccuCd, new FormData("100%"));
		
		afterAppmtIstut = new MSFTextField();
		afterAppmtIstut.setFieldLabel("발령기관");
		afterlc1.add(afterAppmtIstut, new FormData("100%"));
		
		LayoutContainer afterlc2 = new LayoutContainer();
		FormLayout afterfl2 = new FormLayout();
		afterfl2.setLabelWidth(80);
		afterfl2.setLabelAlign(LabelAlign.RIGHT);
		afterlc2.setLayout(afterfl2);
		afterBusinCd = new MSFComboBox<BaseModel>();
		afterBusinCd.setFieldLabel("사업");
		afterBusinCd.setForceSelection(true);
		afterBusinCd.setMinChars(1);
		afterBusinCd.setDisplayField("businNm");
		afterBusinCd.setValueField("businCd");
		afterBusinCd.setTriggerAction(TriggerAction.ALL);
		afterBusinCd.setEmptyText("--부서선택--");
		afterBusinCd.setSelectOnFocus(true);
		afterBusinCd.setStore(new ListStore<BaseModel>());
//		afterBusinCd.setStore(lsBusinCd);
		afterlc2.add(afterBusinCd, new FormData("100%"));
		
		
		afterDtilOccuInttnCd = new MSFComboBox<BaseModel>();
		afterDtilOccuInttnCd.setFieldLabel("직종세");
		afterDtilOccuInttnCd.setName("afterDtilOccuInttnCd");
		afterDtilOccuInttnCd.setEmptyText("--직종세선택--");
		afterDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
		afterDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
		afterDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
		afterDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
		afterDtilOccuInttnCd.setSelectOnFocus(true);
	    //creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	    //creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
//		afterDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	        @Override
//	        public void handleEvent(ComponentEvent ce) {    
//	            if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
//	                mutilCombo = true;
//	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	                mutilCombo = true;
//	              //  GWT.log(" b" + ce.getEvent().getType());
//	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	                mutilCombo = false;
//	              //  GWT.log(" b" + ce.getEvent().getType());
//	            } else {
//	               
//	            }  
//	        
//	        } 
//	    });		

	    afterlc2.add(afterDtilOccuInttnCd, new FormData("100%"));	
		
//		afterLogSvcYrNumCd = new MSFComboBox<BaseModel>();
//		afterLogSvcYrNumCd.setFieldLabel("근속년수");
//		afterLogSvcYrNumCd.setForceSelection(true);
//		afterLogSvcYrNumCd.setMinChars(1);
//		afterLogSvcYrNumCd.setDisplayField("commCdNm");
//		afterLogSvcYrNumCd.setValueField("commCd");
//		afterLogSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
//		afterLogSvcYrNumCd.setEmptyText("--년수선택--");
//		afterLogSvcYrNumCd.setSelectOnFocus(true);
//		afterLogSvcYrNumCd.setStore(listStoreA007);
//		afterlc2.add(afterLogSvcYrNumCd, new FormData("100%"));
		
		afterAppmtBssCtnt = new MSFTextField();
		afterAppmtBssCtnt.setFieldLabel("발령근거내용");
		afterlc2.add(afterAppmtBssCtnt, new FormData("100%"));
		
		LayoutContainer afterlc3 = new LayoutContainer();
		FormLayout afterfl3 = new FormLayout();
		afterfl3.setLabelWidth(80);
		afterfl3.setLabelAlign(LabelAlign.RIGHT);
		afterlc3.setLayout(afterfl3);
//		afterTypOccuCd = new MSFComboBox<BaseModel>();
//		afterTypOccuCd.setFieldLabel("직종");
//		afterTypOccuCd.setForceSelection(true);
//		afterTypOccuCd.setMinChars(1);
//		afterTypOccuCd.setDisplayField("typOccuNm");
//		afterTypOccuCd.setValueField("typOccuCd");
//		afterTypOccuCd.setTriggerAction(TriggerAction.ALL);
//		afterTypOccuCd.setEmptyText("--직종선택--");
//		afterTypOccuCd.setSelectOnFocus(true);
//		afterTypOccuCd.setStore(listStoreA041);
//		afterlc3.add(afterTypOccuCd, new FormData("100%"));
		
		
		afterOdtyCd = new MSFComboBox<BaseModel>();
		afterOdtyCd.setFieldLabel("직책");
		afterOdtyCd.setForceSelection(true);
		afterOdtyCd.setMinChars(1);
		afterOdtyCd.setDisplayField("commCdNm");
		afterOdtyCd.setValueField("commCd");
		afterOdtyCd.setTriggerAction(TriggerAction.ALL);
		afterOdtyCd.setEmptyText("--직책선택--");
		afterOdtyCd.setSelectOnFocus(true);
		afterOdtyCd.setStore(listStoreA015);
		
		afterlc3.add(afterOdtyCd, new FormData("100%"));
		
		
		afterLogSvcYrNumCd = new MSFComboBox<BaseModel>();
		afterLogSvcYrNumCd.setFieldLabel("근속년수");
		afterLogSvcYrNumCd.setForceSelection(true);
		afterLogSvcYrNumCd.setMinChars(1);
		afterLogSvcYrNumCd.setDisplayField("commCdNm");
		afterLogSvcYrNumCd.setValueField("commCd");
		afterLogSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
		afterLogSvcYrNumCd.setEmptyText("--년수선택--");
		afterLogSvcYrNumCd.setSelectOnFocus(true);
		afterLogSvcYrNumCd.setStore(listStoreA007);
		afterlc3.add(afterLogSvcYrNumCd, new FormData("100%"));
		
		
		afterAppmtDt = new MSFDateField();
		new DateFieldMask(afterAppmtDt, "9999.99.99");
		afterAppmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		afterAppmtDt.setFieldLabel("발령일자");
		afterAppmtDt.setValue(new Date());
		afterlc3.add(afterAppmtDt, new FormData("100%"));
		
//		ButtonBar buttonConfirm = new ButtonBar();
//		buttonConfirm.setAlignment(HorizontalAlignment.RIGHT);
//		Button saveBtn = new Button("저장");
//		saveBtn.addListener(Events.Select, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
////				if(appmtName.getValue() != null && appmtName.getValue() != "" && psnl0300Grid.getSelectionModel().getSelectedItems().size() < 1 ){
//				if(appmtName.getValue() != null && appmtName.getValue() != "" && psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() < 1 ){	
//					
//					MessageBox.confirm("발령 저장", appmtName.getValue()+" 님의 발령 내역을 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
//						@Override
//						public void handleEvent(MessageBoxEvent be) {
//							//if("Yes".equals(be.getButtonClicked().getText())){
//							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//								
//								if(!"".equals(appmtName.getValue())){
//									Psnl0300DTO dto = new Psnl0300DTO();
//									dto.setAppmtDivCd(PersonalUtil.getSelectedComboValue(appmtDivCd, "commCd"));
//									//이름 주민으로 dpob_cd, systemkey 가져오기
//									dto.setHanNm(appmtName.getValue());
//									dto.setResnRegnNum(appmtResnRegnNum.getValue());
//									dto.setSystemkey(systemkey.getValue());
//									//발령전 데이터는 현재 데이터로 select into 처리
//									//발령후 시작
//									dto.setAftBusinCd(PersonalUtil.getSelectedComboValue(afterBusinCd, "businCd"));
//									dto.setAftDeptCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd"));
//									dto.setAftTypOccuDivCd(PersonalUtil.getSelectedComboValue(afterTypOccuCd));
//									dto.setAftLogSvcYrNumCd(PersonalUtil.getSelectedComboValue(afterLogSvcYrNumCd));
//									dto.setAftOdtyDivCd(PersonalUtil.getSelectedComboValue(afterOdtyCd));
//									//dto.setAftPyspCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "businCd"));
//									//dto.setAftPyspGrdeCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "businCd"));
//									dto.setAppmtIstut(afterAppmtIstut.getValue());
//									dto.setAppmtBssCtnt(afterAppmtBssCtnt.getValue());
//									//후 호봉코드는 비워둠, 후 호봉등급은 전 호봉등급으로 같이 등록
//									dto.setAppmtDt(PersonalUtil.getConvertDateToString(afterAppmtDt, "yyyyMMdd"));
//									
//									psnl0300Service.appointmentSave(dto, new AsyncCallback<String>() {
//										@Override
//										public void onSuccess(String result) {
//											MessageBox.info("", "발령이 저장되었습니다.", null);
//											
//											appmtDivCd.setValue(new BaseModel());
//											appmtName.setValue("");
//											appmtResnRegnNum.setValue("");
//											appmtHdofcCodtnCd.setValue(new BaseModel());
//											beforeCurrDeptCdNm.setValue("");
//											beforeBusinCdNm.setValue("");
//											beforeTypOccuCdNm.setValue("");
//											beforeOdtyCdNm.setValue("");
//											beforeLogSvcYrNumCdNm.setValue("");
//											afterCurrDeptCd.setValue(new BaseModel());
//											afterBusinCd.setValue(new BaseModel());
//											afterTypOccuCd.setValue(new BaseModel());
//											afterLogSvcYrNumCd.setValue(new BaseModel());
//											afterOdtyCd.setValue(new BaseModel());
//											afterAppmtIstut.setValue("");
//											afterAppmtBssCtnt.setValue("");
//											afterAppmtDt.setValue(null);
//											
//											reload();
////											loaderPsnl0300.load();
//										}
//										@Override
//										public void onFailure(Throwable caught) {
//											MessageBox.alert("", "발령 저장 에러", null);
//										}
//									});
//								}
//							}
//						}
//					});
//				}
//			}
//		});
//		buttonConfirm.add(saveBtn);
//		Button confirm = new Button("확정");
//		confirm.addListener(Events.Select, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				
//				if(psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() > 0 ){	
////				if( psnl0300Grid.getSelectionModel().getSelectedItems().size() > 0 ){
//					MessageBox.confirm("발령 확정", "선택하신 미확정 인원에 대해 발령을 확정 하시겠습니까?",new Listener<MessageBoxEvent>(){
//						@Override
//						public void handleEvent(MessageBoxEvent be) {
//							//if("Yes".equals(be.getButtonClicked().getText())){
//							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//								
//								Iterator<BaseModel> itBm  = psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();	
//								
//								List<Record>  lsRec  = new ArrayList<Record>();
//					              
//								while(itBm.hasNext()) {
//									Record rec  = new Record(itBm.next()); 
//									lsRec.add(rec);
//								} 
//								
//								Iterator<Record> iterRecords = lsRec.iterator() ;  
//					            List<Psnl0300DTO> listPsnl0300Dto = new ArrayList<Psnl0300DTO>();
//					            
//					            
//					            while (iterRecords.hasNext()) {
//							 	       
//									Record recData = (Record) iterRecords.next(); 
//									BaseModel bmMapModel = (BaseModel)recData.getModel();
//					 	               
//									Psnl0300DTO psnl0300Dto = new Psnl0300DTO();  
//									
//									psnl0300Dto.setAppmtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDivCd")));    			/** column 발령구분코드 : appmtDivCd */
//									psnl0300Dto.setAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDt")));    				/** column 발령일자 : appmtDt */
//									psnl0300Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    					/** column 한글성명 : hanNm */
//									psnl0300Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));   		/** column 주민등록번호 : resnRegnNum */
//									psnl0300Dto.setAppmtFixYn(MSFSharedUtils.allowNulls(bmMapModel.get("appmtFixYn"))); 			/** column 발령확정여부 : appmtFixYn */
//																										
//									psnl0300Dto.setBfrDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrDeptCd"))); 				/** column 전_부서코드명 : bfrDeptCd */
//									psnl0300Dto.setBfrBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrBusinCd"))); 			/** column 전_사업코드 : bfrBusinCd */
//									psnl0300Dto.setBfrTypOccuDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrTypOccuDivCd"))); 	/** column 전_직종구분코드 : bfrTypOccuDivCd */
//									psnl0300Dto.setBfrOdtyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrOdtyDivCd"))); 		/** column 전_직책구분코드 : bfrOdtyDivCd */
//									psnl0300Dto.setBfrPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrPyspCd"))); 				/** column 전호봉코드 : bfrPyspCd */
//									
//									psnl0300Dto.setAftDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftDeptCd"))); 				/** column 후_부서코드 : aftDeptCd */
//									psnl0300Dto.setAftBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftBusinCd"))); 			/** column 후_사업코드 : aftBusinCd */
//									psnl0300Dto.setAftTypOccuDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftTypOccuDivCd"))); 	/** column 후_직종구분코드 : aftTypOccuDivCd */
//									psnl0300Dto.setAftOdtyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftOdtyDivCd"))); 		/** column 후_직책구분코드 : aftOdtyDivCd */
//									psnl0300Dto.setAftPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftPyspCd"))); 				/** column 후_호봉코드 : aftPyspCd */
//									
//									psnl0300Dto.setAppmtBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtBssCtnt"))); 		/** column 발령근거내용 : appmtBssCtnt */ 
//									psnl0300Dto.setAppmtIstut(MSFSharedUtils.allowNulls(bmMapModel.get("appmtIstut")));   		 	/** column 발령기관 : appmtIstut */
//									
//									psnl0300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));						/** column 사업장코드 : dpobCd */
//									psnl0300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   			/** column SYSTEMKEY : systemkey */
//									psnl0300Dto.setAppmtNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtNum")));    				/** column 발령번호 : appmtNum */
//									psnl0300Dto.setAftLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftLogSvcYrNumCd")));	/** column 후_근속년수코드 : aftLogSvcYrNumCd */
//									psnl0300Dto.setBfrLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrLogSvcYrNumCd")));	/** column 전근속년수코드 : bfrLogSvcYrNumCd */
//									psnl0300Dto.setBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("bgnnDt")));    					/** column 시작일자 : bgnnDt */
//									psnl0300Dto.setEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("endDt")));    					/** column 종료일자 : endDt */
//									psnl0300Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    					/** column 부서코드 : deptCd */
//									psnl0300Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    				/** column 사업코드 : businCd */
//									psnl0300Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    			/** column 직종코드 : typOccuCd */
//									psnl0300Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));   					/** column 직책코드 : odtyCd */
//									psnl0300Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    					/** column 호봉코드 : pyspCd */
//									psnl0300Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    			/** column 호봉등급코드 : pyspGrdeCd */
//									psnl0300Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));		/** column 근속년수코드 : logSvcYrNumCd */
//									psnl0300Dto.setDsnyActDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActDivCd"))); 		/** column 징계구분코드 : dsnyActDivCd */
//									psnl0300Dto.setCtwpMnthNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctwpMnthNum"), "0"))) ;   /** column 감봉월수 : ctwpMnthNum */
//									psnl0300Dto.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pernAppmtNoteCtnt")));    								/** column 인사발령비고내용 : pernAppmtNoteCtnt */
//									psnl0300Dto.setAppmtSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("appmtSeilNum"), "0"))); 	/** column 발령일련번호 : appmtSeilNum */
//									psnl0300Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd"))); 			/** column 고용구분코드 : emymtDivCd */
//									
//									listPsnl0300Dto.add(psnl0300Dto);
//								} 
//					            
//					                
//					            psnl0300Service.appointmentConfirmList(listPsnl0300Dto, new AsyncCallback<String>() {
////								psnl0300Service.appointmentConfirmList(psnl0300Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<String>() {
//									@Override
//									public void onSuccess(String result) {
//										MessageBox.info("", "발령이 확정되었습니다.", null);
//										
//										
//										//발령설정 초기화
//										psnl0300Init();
//										
//										//조회
//										reload();
//										
////										appmtDivCd.setValue(new BaseModel());
////										appmtName.setValue("");
////										appmtResnRegnNum.setValue("");
////										appmtHdofcCodtnCd.setValue(new BaseModel());
////										beforeCurrDeptCdNm.setValue("");
////										beforeBusinCdNm.setValue("");
////										beforeTypOccuCdNm.setValue("");
////										beforeOdtyCdNm.setValue("");
////										beforeLogSvcYrNumCdNm.setValue("");
////										afterCurrDeptCd.setValue(new BaseModel());
////										afterBusinCd.setValue(new BaseModel());
////										afterTypOccuCd.setValue(new BaseModel());
////										afterLogSvcYrNumCd.setValue(new BaseModel());
////										afterOdtyCd.setValue(new BaseModel());
////										afterAppmtIstut.setValue("");
////										afterAppmtBssCtnt.setValue("");
////										afterAppmtDt.setValue(null);
////										
////										loaderPsnl0300.load();
//									}
//									@Override
//									public void onFailure(Throwable caught) {
//										MessageBox.alert("", "발령 확정 에러", null);
//									}
//								});
//							}
//						}
//					});
//				}else {
//					MessageBox.alert("", "확정할 데이터를 발령내역에서 선택해 주세요.", null);
//				}
//			}
//		});
//		buttonConfirm.add(confirm);
//		afterlc3.add(buttonConfirm, new FormData("100%"));
		
		
		afterlc.add(afterlc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		afterlc.add(afterlc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		afterlc.add(afterlc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		afterIssueFieldSet.add(afterlc, new FormData("100%"));
		
		LayoutContainer afterlc4 = new LayoutContainer();
		FormLayout afterfl4 = new FormLayout();
		afterfl4.setLabelWidth(80);
		afterfl4.setLabelAlign(LabelAlign.RIGHT);
		afterlc4.setLayout(afterfl4);
		
		ButtonBar buttonConfirm = new ButtonBar();
		buttonConfirm.setAlignment(HorizontalAlignment.RIGHT);
		
		saveBtn = new Button("저장");
		saveBtn.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
//				if(appmtName.getValue() != null && appmtName.getValue() != "" && psnl0300Grid.getSelectionModel().getSelectedItems().size() < 1 ){
				if(appmtName.getValue() != null && appmtName.getValue() != ""){	
					
					MessageBox.confirm("발령 저장", appmtName.getValue()+" 님의 발령 내역을 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								
								if(!"".equals(appmtName.getValue())){
									Psnl0300DTO dto = new Psnl0300DTO();
									dto.setAppmtDivCd(PersonalUtil.getSelectedComboValue(appmtDivCd, "commCd"));
									//이름 주민으로 dpob_cd, systemkey 가져오기
									dto.setHanNm(appmtName.getValue());
									dto.setResnRegnNum(appmtResnRegnNum.getValue());
									dto.setSystemkey(systemkey.getValue());
									//발령전 데이터는 현재 데이터로 select into 처리
									//발령후 시작
									dto.setAftBusinCd(PersonalUtil.getSelectedComboValue(afterBusinCd, "businCd"));
									dto.setAftDeptCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd"));
									dto.setAftTypOccuDivCd(PersonalUtil.getSelectedComboValue(afterTypOccuCd, "typOccuCd"));
									dto.setAftLogSvcYrNumCd(PersonalUtil.getSelectedComboValue(afterLogSvcYrNumCd));
									dto.setAftOdtyDivCd(PersonalUtil.getSelectedComboValue(afterOdtyCd));
									dto.setAftDtilOccuInttnCd(PersonalUtil.getSelectedComboValue(afterDtilOccuInttnCd, "dtilOccuInttnCd"));
									//dto.setAftPyspCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "businCd"));
									//dto.setAftPyspGrdeCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "businCd"));
									dto.setAppmtIstut(afterAppmtIstut.getValue());
									dto.setAppmtBssCtnt(afterAppmtBssCtnt.getValue());
									//후 호봉코드는 비워둠, 후 호봉등급은 전 호봉등급으로 같이 등록
									dto.setAppmtDt(PersonalUtil.getConvertDateToString(afterAppmtDt, "yyyyMMdd"));
									
									psnl0300Service.appointmentSave(dto, new AsyncCallback<String>() {
										@Override
										public void onSuccess(String result) {
											MessageBox.info("", "발령이 저장되었습니다.", null);
											
											appmtDivCd.setValue(new BaseModel());
											appmtName.setValue("");
											appmtResnRegnNum.setValue("");
											appmtHdofcCodtnCd.setValue(new BaseModel());
											beforeCurrDeptCdNm.setValue("");
											beforeBusinCdNm.setValue("");
											beforeTypOccuCdNm.setValue("");
											beforeOdtyCdNm.setValue("");
											beforeLogSvcYrNumCdNm.setValue("");
											afterCurrDeptCd.setValue(new BaseModel());
											afterBusinCd.setValue(new BaseModel());
											afterTypOccuCd.setValue(new BaseModel());
											afterDtilOccuInttnCd.setValue(new BaseModel());
											afterLogSvcYrNumCd.setValue(new BaseModel());
											afterOdtyCd.setValue(new BaseModel());
											afterAppmtIstut.setValue("");
											afterAppmtBssCtnt.setValue("");
											afterAppmtDt.setValue(null);
											emymtDivCdFld.reset();
											
											reload();
//											loaderPsnl0300.load();
										}
										@Override
										public void onFailure(Throwable caught) {
											MessageBox.alert("", "발령 저장 에러", null);
										}
									});
								}
							}
						}
					});
				}
			}
		});
		buttonConfirm.add(saveBtn);
		Button confirm = new Button("확정");
		confirm.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				if(psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size() > 0 ){	
//				if( psnl0300Grid.getSelectionModel().getSelectedItems().size() > 0 ){
					MessageBox.confirm("발령 확정", "선택하신 미확정 인원에 대해 발령을 확정 하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								
								Iterator<BaseModel> itBm  = psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();	
								
								List<Record>  lsRec  = new ArrayList<Record>();
					              
								while(itBm.hasNext()) {
									Record rec  = new Record(itBm.next()); 
									lsRec.add(rec);
								} 
								
								Iterator<Record> iterRecords = lsRec.iterator() ;  
					            List<Psnl0300DTO> listPsnl0300Dto = new ArrayList<Psnl0300DTO>();
					            
					            
					            while (iterRecords.hasNext()) {
							 	       
									Record recData = (Record) iterRecords.next(); 
									BaseModel bmMapModel = (BaseModel)recData.getModel();
					 	               
									Psnl0300DTO psnl0300Dto = new Psnl0300DTO();  
									
									psnl0300Dto.setAppmtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDivCd")));    				/** column 발령구분코드 : appmtDivCd */
									psnl0300Dto.setAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDt")));    					/** column 발령일자 : appmtDt */
									psnl0300Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    						/** column 한글성명 : hanNm */
									psnl0300Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));   			/** column 주민등록번호 : resnRegnNum */
									psnl0300Dto.setAppmtFixYn(MSFSharedUtils.allowNulls(bmMapModel.get("appmtFixYn"))); 				/** column 발령확정여부 : appmtFixYn */
																										
									psnl0300Dto.setBfrDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrDeptCd"))); 					/** column 전_부서코드명 : bfrDeptCd */
									psnl0300Dto.setBfrBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrBusinCd"))); 				/** column 전_사업코드 : bfrBusinCd */
									psnl0300Dto.setBfrTypOccuDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrTypOccuDivCd"))); 		/** column 전_직종구분코드 : bfrTypOccuDivCd */
									psnl0300Dto.setBfrOdtyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrOdtyDivCd"))); 			/** column 전_직책구분코드 : bfrOdtyDivCd */
									psnl0300Dto.setBfrPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrPyspCd"))); 					/** column 전호봉코드 : bfrPyspCd */
									
									psnl0300Dto.setAftDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftDeptCd"))); 					/** column 후_부서코드 : aftDeptCd */
									psnl0300Dto.setAftBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftBusinCd"))); 				/** column 후_사업코드 : aftBusinCd */
									psnl0300Dto.setAftTypOccuDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftTypOccuDivCd"))); 		/** column 후_직종구분코드 : aftTypOccuDivCd */
									psnl0300Dto.setAftDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftDtilOccuInttnCd")));	/** column 후_직종세통합코드 : aftDtilOccuInttnCd */
									
									psnl0300Dto.setAftOdtyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftOdtyDivCd"))); 			/** column 후_직책구분코드 : aftOdtyDivCd */
									psnl0300Dto.setAftPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftPyspCd"))); 					/** column 후_호봉코드 : aftPyspCd */
									
									psnl0300Dto.setAppmtBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtBssCtnt"))); 			/** column 발령근거내용 : appmtBssCtnt */ 
									psnl0300Dto.setAppmtIstut(MSFSharedUtils.allowNulls(bmMapModel.get("appmtIstut")));   		 		/** column 발령기관 : appmtIstut */
									
									psnl0300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));							/** column 사업장코드 : dpobCd */
									psnl0300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   				/** column SYSTEMKEY : systemkey */
									psnl0300Dto.setAppmtNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtNum")));    					/** column 발령번호 : appmtNum */
									psnl0300Dto.setAftLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("aftLogSvcYrNumCd")));		/** column 후_근속년수코드 : aftLogSvcYrNumCd */
									psnl0300Dto.setBfrLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("bfrLogSvcYrNumCd")));		/** column 전근속년수코드 : bfrLogSvcYrNumCd */
									psnl0300Dto.setBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("bgnnDt")));    						/** column 시작일자 : bgnnDt */
									psnl0300Dto.setEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("endDt")));    						/** column 종료일자 : endDt */
									psnl0300Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    						/** column 부서코드 : deptCd */
									psnl0300Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    					/** column 사업코드 : businCd */
									psnl0300Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    				/** column 직종코드 : typOccuCd */
									psnl0300Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));   						/** column 직책코드 : odtyCd */
									psnl0300Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    						/** column 호봉코드 : pyspCd */
									psnl0300Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    				/** column 호봉등급코드 : pyspGrdeCd */
									psnl0300Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));			/** column 근속년수코드 : logSvcYrNumCd */
									psnl0300Dto.setDsnyActDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActDivCd"))); 			/** column 징계구분코드 : dsnyActDivCd */
									psnl0300Dto.setCtwpMnthNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctwpMnthNum"), "0"))) ;   /** column 감봉월수 : ctwpMnthNum */
									psnl0300Dto.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pernAppmtNoteCtnt")));    								/** column 인사발령비고내용 : pernAppmtNoteCtnt */
									psnl0300Dto.setAppmtSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("appmtSeilNum"), "0"))); 	/** column 발령일련번호 : appmtSeilNum */
									psnl0300Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd"))); 				/** column 고용구분코드 : emymtDivCd */
									
									listPsnl0300Dto.add(psnl0300Dto);
								} 
					            
					                
					            psnl0300Service.appointmentConfirmList(listPsnl0300Dto, new AsyncCallback<String>() {
//								psnl0300Service.appointmentConfirmList(psnl0300Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<String>() {
									@Override
									public void onSuccess(String result) {
										MessageBox.info("", "발령이 확정되었습니다.", null);
										
										
										//발령설정 초기화
										psnl0300Init();
										
										//조회
										reload();
										
//										appmtDivCd.setValue(new BaseModel());
//										appmtName.setValue("");
//										appmtResnRegnNum.setValue("");
//										appmtHdofcCodtnCd.setValue(new BaseModel());
//										beforeCurrDeptCdNm.setValue("");
//										beforeBusinCdNm.setValue("");
//										beforeTypOccuCdNm.setValue("");
//										beforeOdtyCdNm.setValue("");
//										beforeLogSvcYrNumCdNm.setValue("");
//										afterCurrDeptCd.setValue(new BaseModel());
//										afterBusinCd.setValue(new BaseModel());
//										afterTypOccuCd.setValue(new BaseModel());
//										afterLogSvcYrNumCd.setValue(new BaseModel());
//										afterOdtyCd.setValue(new BaseModel());
//										afterAppmtIstut.setValue("");
//										afterAppmtBssCtnt.setValue("");
//										afterAppmtDt.setValue(null);
//										
//										loaderPsnl0300.load();
									}
									@Override
									public void onFailure(Throwable caught) {
										MessageBox.alert("", "발령 확정 에러", null);
									}
								});
							}
						}
					});
				}else {
					MessageBox.alert("", "확정할 데이터를 발령내역에서 선택해 주세요.", null);
				}
			}
		});
		buttonConfirm.add(confirm);
		afterlc4.add(buttonConfirm, new FormData("100%"));
		
		
		afterIssueFieldSet.add(afterlc4, new FormData("100%"));
		
		lcTabFormLayer.add(afterIssueFieldSet);
		
		return lcTabFormLayer;
	}

	
	
	
	private LayoutContainer occupationalLeft() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		return lcTabFormLayer;

	}
	
	public void reload() {
		// TODO Auto-generated method stub
		if("".equals(MSFSharedUtils.getSelectedComboValue(searchBusinCd,"businCd"))){
			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(searchBusinCd,"commCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				return;
			} 
		} 
		
				    
		IColumnFilter filters = null;
		psnl0300GridPanel.getTableDef().setTableColumnFilters(filters);
		
		psnl0300GridPanel.getTableDef().addColumnFilter("appmtDivCd", MSFSharedUtils.getSelectedComboValue(searchAppmtDivCd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);//발령구분
		psnl0300GridPanel.getTableDef().addColumnFilter("appmtFixYn", MSFSharedUtils.getSelectedComboValue(searchAppmtFixYn,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); //발령상태
		psnl0300GridPanel.getTableDef().addColumnFilter("currAffnDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); //소속부서

		psnl0300GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS); //고용구분
		
		
		psnl0300GridPanel.getTableDef().addColumnFilter("appmtDtS", PersonalUtil.getConvertDateToString(searchAppmtDtS, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0300GridPanel.getTableDef().addColumnFilter("appmtDtE", PersonalUtil.getConvertDateToString(searchAppmtDtE, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		//20180305추가 
		psnl0300GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				
		//psnl0300GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); //부서
		       
		psnl0300GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(searchBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		psnl0300GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(searchTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0300GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0300GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(searchName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		psnl0300GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(searchResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
		
		psnl0300GridPanel.reload();
	}
	
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	
	private void fnPopupPsnl0100() {
	       MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchName.getRawValue());  //인사  
	       final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	       
	       popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("systemkey"))) { 
	                   systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   			//시스템키
	            	   searchName.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));				//힌글이름
	            	   searchResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));  //주민번호 
	            	   
	               }  
	           }
	       });
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
    			//srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
    			//srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
                srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                srhDeptCd.fireEvent(Events.Add);
               }  
    		}
		});
	}
	
	private void fnPopupPsnl0100_2() {
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchName.getRawValue()); // 인사
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) {
					
					/**
					 * 발령설정에서 발령대상자를 검색하여 발령할 경우 
					 * 발령전, 발령후를 초기화 후 마스터에 있는 정보로 발령전 필드셋에 보여준다.
					 **/
//					psnl0300Init();
					
					// 발령설정 초기화
					appmtName.setValue("");
					appmtResnRegnNum.setValue("");
					appmtHdofcCodtnCd.setValue(new BaseModel());
					
					beforeCurrDeptCdNm.setValue("");
					beforeBusinCdNm.setValue("");
					beforeTypOccuCdNm.setValue("");
					beforeOdtyCdNm.setValue("");
					beforeLogSvcYrNumCdNm.setValue("");
					
					afterCurrDeptCd.setValue(new BaseModel());
					afterBusinCd.setValue(new BaseModel());
					afterTypOccuCd.reset();
					afterDtilOccuInttnCd.reset();
					afterLogSvcYrNumCd.setValue(new BaseModel());
					afterOdtyCd.setValue(new BaseModel());
					afterAppmtIstut.setValue("");
					afterAppmtBssCtnt.setValue("");
					afterAppmtDt.setValue(null);
					
					
					systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); 					// 시스템키
					appmtName.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));						// 성명 
					appmtResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));  		// 주민번호
					PersonalUtil.setSelectedComboValue(appmtHdofcCodtnCd
							, (String) MSFSharedUtils.allowNulls(mapModel.get("hdofcCodtnCd")) , "commCd");		// 재직구분
					
//					// --- 발령전
					beforeCurrDeptCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("currAffnDeptNm")));		// 부서
					beforeBusinCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("businNm"))); 				// 사업명
					beforeTypOccuCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("typOccuNm"))); 			// 직종
					beforeDtilOccuInttnNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("dtilOccuClsDivNm")));// 직종세
					
					beforeOdtyCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("odtyNm"))); 				// 직책
					beforeLogSvcYrNumCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("logSvcYrNumNm")));	// 근속년수
					
					emymtDivCdFld.setValue(MSFSharedUtils.allowNulls(mapModel.get("emymtDivCd")));
					
				}
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/  
	
	/** 검색조건 초기화 **/
	public void psnl0300SrhInit() {
		
		searchAppmtDivCd.setValue(new BaseModel());	// 발령구분
		searchAppmtFixYn.setValue(new BaseModel());	// 발령상태
		//srhMangeDeptCd.setValue("");				// 관리부서
		searchAppmtDtS.setValue(null);				// 발령일자_시작
		searchAppmtDtE.setValue(null);				// 발령일자_종료
		searchName.setValue("");					// 성명
		searchResnRegnNum.setValue("");				// 주민등록번호
		systemkey.setValue("");						// 시스템키
		
	}
	
	/** 발령설정 초기화 **/ 
	public void psnl0300Init() {
		saveBtn.show();
		actionDatabase = ActionDatabase.INSERT;
		
		dpobCd.setValue("");
		systemkey.setValue("");
		
		picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		
		appmtDivCd.setValue(new BaseModel());
		appmtName.setValue("");
		appmtResnRegnNum.setValue("");
		appmtHdofcCodtnCd.setValue(new BaseModel());
		
		beforeCurrDeptCdNm.setValue("");
		beforeBusinCdNm.setValue("");
		beforeTypOccuCdNm.setValue("");
		beforeDtilOccuInttnNm.setValue("");
		beforeOdtyCdNm.setValue("");
		beforeLogSvcYrNumCdNm.setValue("");
		
		afterCurrDeptCd.setValue(new BaseModel());
		afterBusinCd.setValue(new BaseModel());
		afterTypOccuCd.reset();
		afterDtilOccuInttnCd.reset();
		afterLogSvcYrNumCd.setValue(new BaseModel());
		afterOdtyCd.setValue(new BaseModel());
		afterAppmtIstut.setValue("");
		afterAppmtBssCtnt.setValue("");
		afterAppmtDt.setValue(new Date());
		
		emymtDivCdFld.reset();
		comboBool = false;
	}


	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
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
