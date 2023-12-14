package com.app.exterms.personal.client.form;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0600DTO;
import com.app.exterms.personal.client.form.defs.Psnl0600Def;
import com.app.exterms.personal.client.service.Psnl0600Service;
import com.app.exterms.personal.client.service.Psnl0600ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.form.PrgmComP0130;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0300Def;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0350Service;
import com.app.exterms.prgm.client.service.PrgmComBass0350ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
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
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
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

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0600 extends MSFPanel {

/**###################################################### 
 * { 시스템 기본설정파일 선언부 시작} 
 * #######################################################
 */
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */	
	private HashMap<String, String> params = new HashMap<String, String>();
	
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0600Bar;	
	private Button btnPsnl0600Reset;	//초기화 버튼
	private Button btnPsnl0600Sreach;	//조회 버튼
	private Button btnPsnl0600Print;	//인쇄 버튼
	private Button btnPsnl0600Excel;	//엑셀 버튼
	// -------------- 상단 버튼 종료 --------------
	
	//검색조건 시작
	// -------------- 상위 검색조건 시작 -------------- 
	private HiddenField<String> payrMangDeptCd;					//단위기관 코드
	private TextField<String> srhDeptCd;						//부서코드
    private TextField<String> srhDeptNm; 						//부서명  
    private Button btnSrhDeptCd;
    private TextField<String> srhMangeDeptCd; 					//관리부서 수정
    private TextField<String> srhMangeDeptNm; 					//관리부서 수정 
    private ComboBox<BaseModel> srhPayrMangDeptCd; 				//단위기관
	private ComboBox<BaseModel> searchEmymtDivCd; 				//고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 			//호봉제구분코드  
	private HiddenField<String> searchPyspGrdeCd;
	private String typComboOccuCd  = new String(); 
	private ComboBox<BaseModel> srhTypOccuCd;  					//직종
	private ComboBox<BaseModel> srhDeptGpCd;		 			//부서직종그룹코드	    
	private MSFMultiComboBox<ModelData>  srhDtilOccuInttnCd;	//직종세 구분
	private DateField searchNowDeptDateS;		  				//현부서 시작일
	private DateField searchNowDeptDateE;		  				//현부서 종료일
	private DateField searchFrstWorkDateS;		  				//최초 고용 시작일
	private DateField searchFrstWorkDateE;		  				//최초 고용 종료일
	private DateField searchBirthDateS;			  				//생일 시작일
	private DateField searchBirthDateE;			  				//생일 종료일
	private ComboBox<BaseModel> searchWorkYearS;  				//근속년수 시작일
	private ComboBox<BaseModel> searchWorkYearE;  				//근속년수 시작일
//	private ComboBox<BaseModel> searchHdofcCodtnCd;			//재직구분
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 		//재직구분
	private ComboBox<BaseModel> searchSexType;					//성별
	private ComboBox<BaseModel> srhBusinCd; 					//사업명 
	//직종콤보
//    private LookupPrgmComBass0320 comTypOccuCd = new LookupPrgmComBass0320();  
//    private MSFGridPanel comTypOccuCdGridPanel;
	private PrgmComBass0300DTO sysComBass0300Dto; 				//공통코드 
	private PrgmComBass0320DTO sysComBass0320Dto;				//직종
	private PrgmComBass0350DTO sysComBass0350Dto;				//직종세
	private PrgmComBass0500DTO sysComBass0500Dto; 				//사업코드 
	private SysCoCalendarDTO    msfCoCalendarDto;  				// 날짜
	
	
	private LayoutContainer lcSch1_2_1 = new LayoutContainer(new ColumnLayout());	// 기간별
	private LayoutContainer lcSch1_2_2 = new LayoutContainer(new ColumnLayout());	// 분기별
	private LayoutContainer lcSch1_2_3 = new LayoutContainer(new ColumnLayout());	// 월별
	
	private ComboBox<BaseModel> srhDateType;						// 기간구분(기간별, 분기별, 월별)
	private ComboBox<BaseModel> srhYr01;							// 월별 년
	private ComboBox<BaseModel> srhMnth;							// 월별 월
    private DateField srhDayS;      								// 기간별 시작일
    private DateField srhDayE;      								// 기간별 종료일
    private ComboBox<BaseModel> srhYr02;							// 분기별 년
    private ComboBox<BaseModel> srhMnthS;							// 분기별 시작월
    private ComboBox<BaseModel> srhMnthE;							// 분기별 종료월
	private HiddenField<String> month;
	// -------------- 상위 검색조건 종료 -------------- 
	
	
    private List<ModelData> mDtalistDtilOccuInttnCd;			//직종세 멀티 
    private List<ModelData> mDtalistHdofcCodtnCd;				//재직 멀티
    private boolean mutilCombo = false;
	
	// -------------- 병역 검색조건 시작 -------------- 
	private ComboBox<BaseModel> searchDsageDivCd;				//제대구분
	private DateField searchDsageDtS;		      				//제대 시작일
	private DateField searchDsageDtE;		      				//제대 종료일
	private ComboBox<BaseModel> searchBaggrpCd;   				//군별
	private ComboBox<BaseModel> searchAbotsCd;    				//병과
	private ComboBox<BaseModel> searchClsCd;      				//계급
	// -------------- 병역 검색조건 종료 -------------- 
	
	
	// -------------- 단체 검색조건 시작 --------------
	private TextField<String> searchJnOpztnNm;					//단체명
	private DateField searchJnDtS;			  					//가입기간 시작일
	private DateField searchJnDtE;			  					//가입기간 종료일
	// -------------- 단체 검색조건 종료 --------------
	
	
	// -------------- 학력 검색조건 시작 --------------
	private ComboBox<BaseModel> searchAcadAbtyDivCd;			//학력구분
	private ComboBox<BaseModel> searchDegrDivCd;				//학위
	private TextField<String> searchDeprMajrCd;	 				//학과
	private TextField<String> searchSchlCd;		 				//학교명
	private TextField<String> searchDeprMajrCdNm;				//학과
	private TextField<String> searchSchlCdNm;					//학교명
	// -------------- 학력 검색조건 종료 --------------
	
	
	// -------------- 경력 검색조건 시작 --------------
	private TextField<String> searchPaeWorkNm;					//근무처명
	private DateField searchCarrBgnnDtS;						//근무시작일 시작
	private DateField searchCarrBgnnDtE;						//근무시작일 종료
	// -------------- 경력 검색조건 종료 --------------
	
	// -------------- 자격 검색조건 시작 --------------
	private TextField<String> searchQftntLicnsPovncCtnt;		//자격면허
	private DateField searchAqtnDtS;							//취득일자 시작
	private DateField searchAqtnDtE;							//취득일자 종료
	// -------------- 자격 검색조건 종료 --------------
	
	// -------------- 교육 검색조건 시작 --------------
	private TextField<String> searchEduKndNm;					//교육종류
	private DateField searchEduBgnnDtS;							//교육기간 시작
	private DateField searchEduBgnnDtE;							//교육기간 종료
	// -------------- 교육 검색조건 종료 --------------
	
	// -------------- 징계 검색조건 시작 --------------
	private ComboBox<BaseModel> searchDsnyActDivCd;				//징계구분
	private DateField searchDsnyActDsplDtS;						//징계처분일 시작
	private DateField searchDsnyActDsplDtE;		    			//징계처분일 종료
	// -------------- 징계 검색조건 종료 --------------
	
	// -------------- 휴직 검색조건 시작 --------------
	private ComboBox<BaseModel> searchLevfAbncDivCd;			//휴직구분
	private DateField searchLevfAbncBgnnDtS;					//휴직일 시작
	private DateField searchLevfAbncBgnnDtE;					//휴직일 종료
	// -------------- 휴직 검색조건 종료 --------------
	//검색 조건 끝
	
	private TabPanel tabsPsnl; //하위 탭  
	
	// -------------- grid 선언 시작 --------------
//	private Grid<Psnl0600DTO> psnl0600Grid; //기본 그리드
//	private Grid<Psnl0600DTO> psnl0112Grid; //병역 그리드
//	private Grid<Psnl0600DTO> psnl0114Grid; //단체 그리드
//	private Grid<Psnl0600DTO> psnl0116Grid; //학력 그리드
//	private Grid<Psnl0600DTO> psnl0119Grid; //경력 그리드
//	private Grid<Psnl0600DTO> psnl0118Grid; //자격 그리드
//	private Grid<Psnl0600DTO> psnl0120Grid; //교육 그리드
//	private Grid<Psnl0600DTO> psnl0121Grid; //포상 그리드
//	private Grid<Psnl0600DTO> psnl0122Grid; //징계 그리드
//	private Grid<Psnl0600DTO> psnl0123Grid; //휴직 그리드
	
	          
	private Psnl0600Def psnl0600Def  = new Psnl0600Def("PSNL0600");					// 기본
	private MSFGridPanel psnl0600GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0112Def  = new Psnl0600Def("PSNL0112");		// 병역
	private MSFGridPanel psnl0600ToPsnl0112GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0114Def  = new Psnl0600Def("PSNL0114");		// 단체
	private MSFGridPanel psnl0600ToPsnl0114GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0116Def  = new Psnl0600Def("PSNL0116");		// 학력
	private MSFGridPanel psnl0600ToPsnl0116GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0119Def  = new Psnl0600Def("PSNL0119");		// 경력
	private MSFGridPanel psnl0600ToPsnl0119GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0118Def  = new Psnl0600Def("PSNL0118");		// 자격
	private MSFGridPanel psnl0600ToPsnl0118GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0120Def  = new Psnl0600Def("PSNL0120");		// 교육
	private MSFGridPanel psnl0600ToPsnl0120GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0121Def  = new Psnl0600Def("PSNL0121");		// 포상
	private MSFGridPanel psnl0600ToPsnl0121GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0122Def  = new Psnl0600Def("PSNL0122");		// 징계
	private MSFGridPanel psnl0600ToPsnl0122GridPanel;
	
	private Psnl0600Def psnl0600ToPsnl0123Def  = new Psnl0600Def("PSNL0123");		// 휴직
	private MSFGridPanel psnl0600ToPsnl0123GridPanel;
	// -------------- grid 선언 종료 --------------
	
	private RadioGroup outputTypeRadiogroup; //기본 출력 양식 
	
	       
	// -------------- store 선언 시작 --------------
	private ListStore<BaseModel> listStoreA002 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA041 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA007 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA003 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA004 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA025 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA023 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA024 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA045 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA026 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA028 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA011 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA046 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreB014 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsHdofcCodtnCd 	= new ListStore<BaseModel>();	//재직상태 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  	
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDateType 		= new ListStore<BaseModel>();  	// 기간 구분
	private ListStore<BaseModel> lsYrStore 			= new ListStore<BaseModel>();  	// 년도 
	private ListStore<BaseModel> lsMonthStore 		= new ListStore<BaseModel>();  	// 월 
	  
	// -------------- store 선언 종료 --------
	
	//서비스 시작
	// -------------- 서비스 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	private PrgmComBass0350ServiceAsync sysComBass0350Service = PrgmComBass0350Service.Util.getInstance();	//직종
	//private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();
	private Psnl0600ServiceAsync psnl0600Service = Psnl0600Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
	//기본
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			psnl0600Service.selectPsnl0600( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0600 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy);
	private ListStore<Psnl0600DTO> storePsnl0600 = new ListStore<Psnl0600DTO>(loaderPsnl0600);
	
	//병역 
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0112 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhDsageDivCd", PersonalUtil.getSelectedComboValue(searchDsageDivCd,"commCd"));//제대구분
			params.put("srhDsageDtS", searchDsageDtS.getValue() == null ? "" : dateTimeFormat.format(searchDsageDtS.getValue()));//제대기간 시작일
			params.put("srhDsageDtE", searchDsageDtE.getValue() == null ? "" : dateTimeFormat.format(searchDsageDtE.getValue()));//제대기간 종료일
			params.put("srhBaggrpCd", PersonalUtil.getSelectedComboValue(searchBaggrpCd,"commCd"));//군별
			params.put("srhAbotsCd", PersonalUtil.getSelectedComboValue(searchAbotsCd,"commCd"));//병과
			params.put("srhClsCd", PersonalUtil.getSelectedComboValue(searchClsCd,"commCd"));//계급
			
			
			psnl0600Service.selectPsnl0112( (BaseListLoadConfig) loadConfig, params, callback);
			
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0112 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0112);
	private ListStore<Psnl0600DTO> storePsnl0112 = new ListStore<Psnl0600DTO>(loaderPsnl0112);
	
	//단체
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0114 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhJnOpztnNm", searchJnOpztnNm.getValue() == null ? "" : searchJnOpztnNm.getValue());			//단체명
			params.put("srhJnDtS", searchJnDtS.getValue() == null ? "" : dateTimeFormat.format(searchJnDtS.getValue()));//가입기간 시작일
			params.put("srhJnDtE", searchJnDtE.getValue() == null ? "" : dateTimeFormat.format(searchJnDtE.getValue()));//가입기간 종료일
			
			psnl0600Service.selectPsnl0114( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0114 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0114);
	private ListStore<Psnl0600DTO> storePsnl0114 = new ListStore<Psnl0600DTO>(loaderPsnl0114);
	
	//학력
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0116 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhAcadAbtyDivCd", PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));	//학력구분
			params.put("srhDegrDivCd", PersonalUtil.getSelectedComboValue(searchDegrDivCd,"commCd"));			//학위
			params.put("srhDeprMajrCd", searchDeprMajrCd.getValue() == null ? "" : searchDeprMajrCd.getValue());//학과
			params.put("srhSchlCd", searchSchlCd.getValue() == null ? "" : searchSchlCd.getValue());			//학교명
			
			psnl0600Service.selectPsnl0116( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0116 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0116);
	private ListStore<Psnl0600DTO> storePsnl0116 = new ListStore<Psnl0600DTO>(loaderPsnl0116);
	
	//경력
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0119 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhPaeWorkNm", searchPaeWorkNm.getValue() == null ? "" : searchPaeWorkNm.getValue());//근무처명
			params.put("srhCarrBgnnDtS", searchCarrBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchCarrBgnnDtS.getValue()));//근무시작일 시작일
			params.put("srhCarrBgnnDtE", searchCarrBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchCarrBgnnDtE.getValue()));//근무시작일 종료일
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));			
			psnl0600Service.selectPsnl0119( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0119 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0119);
	private ListStore<Psnl0600DTO> storePsnl0119 = new ListStore<Psnl0600DTO>(loaderPsnl0119);
	
	//자격
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0118 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhQftntLicnsPovncCtnt", searchQftntLicnsPovncCtnt.getValue() == null ? "" : searchQftntLicnsPovncCtnt.getValue());//자격면허
			params.put("srhAqtnDtS", searchAqtnDtS.getValue() == null ? "" : dateTimeFormat.format(searchAqtnDtS.getValue()));//취득일자 시작일
			params.put("srhAqtnDtE", searchAqtnDtE.getValue() == null ? "" : dateTimeFormat.format(searchAqtnDtE.getValue()));//취득일자 종료일
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));			
			
			psnl0600Service.selectPsnl0118( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0118 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0118);
	private ListStore<Psnl0600DTO> storePsnl0118 = new ListStore<Psnl0600DTO>(loaderPsnl0118);
	
	//교육
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0120 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhEduKndNm", searchEduKndNm.getValue() == null ? "" : searchEduKndNm.getValue());//교육종류
			params.put("srhEduBgnnDtS", searchEduBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchEduBgnnDtS.getValue()));//교육종류 시작일
			params.put("srhEduBgnnDtE", searchEduBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchEduBgnnDtE.getValue()));//교육종류 종료일
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));			
			
			psnl0600Service.selectPsnl0120( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0120 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0120);
	private ListStore<Psnl0600DTO> storePsnl0120 = new ListStore<Psnl0600DTO>(loaderPsnl0120);
	
	//포상
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0121 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			psnl0600Service.selectPsnl0121( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0121 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0121);
	private ListStore<Psnl0600DTO> storePsnl0121 = new ListStore<Psnl0600DTO>(loaderPsnl0121);
	
	//징계
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0122 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhDsnyActDivCd", PersonalUtil.getSelectedComboValue(searchDsnyActDivCd,"commCd"));//징계구분
			params.put("srhDsnyActDsplDtS", searchDsnyActDsplDtS.getValue() == null ? "" : dateTimeFormat.format(searchDsnyActDsplDtS.getValue()));//징계처분일 시작일
			params.put("srhDsnyActDsplDtE", searchDsnyActDsplDtE.getValue() == null ? "" : dateTimeFormat.format(searchDsnyActDsplDtE.getValue()));//징계처분일 종료일
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			
			psnl0600Service.selectPsnl0122( (BaseListLoadConfig) loadConfig, params, callback);
			
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0122 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0122);
	private ListStore<Psnl0600DTO> storePsnl0122 = new ListStore<Psnl0600DTO>(loaderPsnl0122);
	
	//휴직
	private RpcProxy<BaseListLoadResult<Psnl0600DTO>> psnl0600Proxy0123 = new RpcProxy<BaseListLoadResult<Psnl0600DTO>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0600DTO>> callback) {
			
			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
			DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyyyMMdd");
			
			params = new HashMap<String, String>();
			/******************* 기본 검색조건 시작 *******************/
			params.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	//단위기관
			
			params.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));	//관리부서
			params.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));   	//부서 
			params.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));	//고용구분
			params.put("srhTypOccuCd", (PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")));	//직종

			params.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
			params.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
	
			params.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
			params.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
			
			params.put("srhBirthDateS", searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue()));
			params.put("srhBirthDateE", searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue()));
			
			params.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
			params.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
			
			
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
			
			params.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
			
//			params.put("srhHdofcCodtnCd", PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd,"commCd"));
			params.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
		//	params.put("srhDtilOccuInttnCd", PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"));
			
			String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
			params.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  //직종세 
			
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			/******************* 기본 검색조건 종료 *******************/
			
			params.put("srhLevfAbncDivCd", PersonalUtil.getSelectedComboValue(searchLevfAbncDivCd,"commCd"));//휴직구분
			params.put("srhLevfAbncBgnnDtS", searchLevfAbncBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchLevfAbncBgnnDtS.getValue()));//휴직일 시작일
			params.put("srhLevfAbncBgnnDtE", searchLevfAbncBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchLevfAbncBgnnDtE.getValue()));//휴직일 종료일
//			params.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//			params.put("srhBusinCd", srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
			
			psnl0600Service.selectPsnl0123( (BaseListLoadConfig) loadConfig, params, callback);
			params = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0123 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0600Proxy0123);
	private ListStore<Psnl0600DTO> storePsnl0123 = new ListStore<Psnl0600DTO>(loaderPsnl0123);
	//서비스 끝
 

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
	  private void checkPsnl0600Auth( String authAction, ListStore<BaseModel> bm) {   
    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			   if (!maskTracker) { unmask(); }  
               //MSFMainApp.unmaskMainPage();
			   authExecEnabled() ;
				
                 
		   }
	  }
	  
		 private void authExecEnabled() { 
			   //------------------
			 //----------------------------------------------------
	       		Field<?>[] fldArrField = {searchEmymtDivCd,srhMangeDeptCd,srhDeptNm,srhDeptCd,srhDeptNm,srhTypOccuCd, srhBusinCd};
	       	 
	       		gwtAuthorization.formAuthFieldConfig(fldArrField);
	       		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 
    		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//    		 String[] strArrDeptCd = { "srhDeptCd","srhDeptNm","srhDeptCd","srhDeptNm"};
    		// String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
    		//gwtAuthorization.formAuthPopConfig(plFrmPsnl0600, "","searchEmymtDivCd",strArrDeptCd,"srhTypOccuCd","searchYearBusinCd");
    		//gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
    		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    		  * 권한설정을 위한 콤보처리를 위한 메서드 종료
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
       		 srhDeptCd.fireEvent(Events.Add);
       		 
       		 
    		 // ------------- 월별 날짜 셋팅 
    		 srhYr01.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
    		 srhMnth.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
    		 // ------------- 월별 날짜 셋팅 
    		 
    		 
    		 // ------------- 분기별 날짜 셋팅 
    		 srhYr02.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//분기별 년도
    		 srhMnthS.setValue(lsMonthStore.findModel("month", DateTimeFormat.getFormat("MM").format(new Date()))); 
    		 // ------------- 분기별 날짜 셋팅 
       	
		 	}
//		  private AuthAction authAction;
//		  private int checkCntDef = 1;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkPsnl0600Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
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

	   final Timer tmMask = new Timer()
	     {
	           public void run()
	           {
	              // if (maskTracker)
	              // { 
	        	   if (listStoreA002.getCount() > 0 ) {
	        		   
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
	     
		  private void initLoad() { 
			// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
			     gwtAuthorization = GWTAuthorization.getInstance();
			     gwtExtAuth = GWTExtAuth.getInstance();
			     
			     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
			     
			     authMapDef.put("searchEmymtDivCd",Boolean.FALSE); 
				 
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
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * Print 인쇄 선언부 변수 선언부 시작
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */	
			private String strDirPath;
			private String strParam;
			private String searchParam;
			private String rdaFileName;
			private String rexFileName;
			private String checkedSystemKeys;
			/**
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * Print 인쇄 선언부 변수 선언부 종료
			 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		  
	  
		  
	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */
 

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0600;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	private GridCellRenderer<Stock> gridNumber;
	private GridCellRenderer<Stock> change;
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */	
/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################
 */	
	
	public ContentPanel getViewPanel() {
		
		month = new HiddenField<String>();
		
		 
		 //권한 검색조건처리를 위해 추가된 부분 
		initLoad();
		
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		msfCoCalendarDto = new SysCoCalendarDTO();    
		
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A002");
		 listStoreA002 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A041");
		 listStoreA041 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A007");
		 listStoreA007 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------년도 불러 오는 함수 ------------------------------------------------
		 lsYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);	
		 //--------------------년도 불러 오는 함수 ------------------------------------------------ 
	        
		 //--------------------월 불러 오는 함수 ------------------------------------------------ 
		 lsMonthStore = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------월 불러 오는 함수 ------------------------------------------------ 
		 
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("S001");	// 기간구분
		 lsDateType = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		 lsDateType.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					srhDateType.setValue(lsDateType.getAt(0));
		         }
			});  
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		    
		 //sysComBass0300Dto.setRpsttvCd("A003");
		// listStoreA003 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		//재직상태  
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
	            srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
	         }
		});   
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A004");
		 listStoreA004 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A025");
		 listStoreA025 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A023");
		 listStoreA023 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A024");
		 listStoreA024 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A045");
		 listStoreA045 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A026");
		 listStoreA026 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A028");
		 listStoreA028 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A011");
		 listStoreA011 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A048");
		 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A046");
		 listStoreA046 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("B014");
		 listStoreB014 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
						
//		//가져올 콤보 리스트 목록
//		List<String> arrRpsttvCd = new ArrayList<String>();
//		arrRpsttvCd.add("A002");
////		arrRpsttvCd.add("A041");
//		arrRpsttvCd.add("A007");
//		arrRpsttvCd.add("A003");
//		arrRpsttvCd.add("A004");
//		arrRpsttvCd.add("A025");
//		arrRpsttvCd.add("A023");
//		arrRpsttvCd.add("A024");
//		arrRpsttvCd.add("A045");
//		arrRpsttvCd.add("A026");
//		//arrRpsttvCd.add("A027");
//		arrRpsttvCd.add("A028");
//		arrRpsttvCd.add("A011");
//		arrRpsttvCd.add("A046");
//		arrRpsttvCd.add("A048");
//		sysComBass0300Dto = new PrgmComBass0300DTO(); 
//		sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
//		
//		sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
//			
//			@Override
//			public void onSuccess(HashMap<String, List<BaseModel>> result) {
//				// 콤보 데이터 저장하는곳
//				if(result != null && result.size() > 0){
//					listStoreA002.add(result.get("A002"));
////					listStoreA041.add(result.get("A041"));	//직종
//					listStoreA007.add(result.get("A007"));
//					listStoreA003.add(result.get("A003"));	//재직상태
//					listStoreA004.add(result.get("A004"));
//					listStoreA025.add(result.get("A025"));
//					listStoreA023.add(result.get("A023"));
//					listStoreA024.add(result.get("A024"));
//					listStoreA045.add(result.get("A045"));
//					listStoreA026.add(result.get("A026"));
//					//listStoreA027.add(result.get("A027"));
//					listStoreA028.add(result.get("A028"));
//					listStoreA011.add(result.get("A011"));
//					lsRepbtyBusinDivCd.add(result.get("A048"));
//					listStoreA046.add(result.get("A046"));
//				}
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				MessageBox.alert("", "공통코드 에러!", null);
//			}
//		});
		
		if (panel == null) {

			detailTp = XTemplate.create(getDetailTemplate());
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(5);
			createPsnl0600Form();	//화면 기본정보를 설정
			createSearchForm(); 	//검색필드를 적용
			createTabForm(); 		//탭구성
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.add(vp);

		}
		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Psnl0600() {
		setSize("1010px", "700px");
	}

	public Psnl0600(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0600Form() {

		plFrmPsnl0600 = new FormPanel();
		plFrmPsnl0600.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 인사통합출력"));
		plFrmPsnl0600.setIcon(MSFMainApp.ICONS.text());
		// plFrmPsnl0600.setBodyStyleName("pad-text");
		plFrmPsnl0600.setPadding(2);
		plFrmPsnl0600.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("인사통합출력","PSNL0600");
				}
			});
		plFrmPsnl0600.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0600.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		payrMangDeptCd = new HiddenField<String>();

		//---------------------멀티콤보박스 닫기 -------------------------------------------------
		plFrmPsnl0600.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
//				for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
//					if (f instanceof MSFMultiComboBox<?>) {
//						if ("srhDeptCd".equals(f.getName())) {
//						} else if ("srhHdofcCodtnCd".equals(f.getName())) {
//						
//						}
//					} else {
				
				if (mutilCombo) {
					if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
						//직종세
						srhDtilOccuInttnCd.showClose(ce);
						mutilCombo = false;
					} else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						srhHdofcCodtnCd.showClose(ce);
						mutilCombo = false;
					}   
				} 
			} 
		}); 
        //---------------------멀티콤보박스 닫기 -------------------------------------------------
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FlowLayout());

		ButtonBar buttonBar_1 = new ButtonBar();
		layoutContainer_1.add(buttonBar_1);
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

//		ButtonBar buttonBar = new ButtonBar();
		topPsnl0600Bar = new ButtonBar();
		layoutContainer_2.add(topPsnl0600Bar);
		topPsnl0600Bar.setAlignment(HorizontalAlignment.RIGHT);
		// buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));
		// buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));

//		Button topBtn = new Button("초기화");
		btnPsnl0600Reset = new Button("초기화");
		btnPsnl0600Reset.setIcon(MSFMainApp.ICONS.new16());
		btnPsnl0600Reset.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
			    srhMangeDeptCd.setValue("");					//관리부서 코드
			    srhMangeDeptNm.setValue("");					//관리부서 이름
				searchNowDeptDateS.setValue(null);				//현부서 시작일
				searchNowDeptDateE.setValue(null);				//현부서 종료일
				searchFrstWorkDateS.setValue(null);				//최초 고용 시작일
				searchFrstWorkDateE.setValue(null);				//최초 고용 종료일
				searchBirthDateS.setValue(null);			  	//생일 시작일
				searchBirthDateE.setValue(null);			  	//생일 종료일
				searchWorkYearS.setValue(new BaseModel());  	//근속년수 시작일
				searchWorkYearE.setValue(new BaseModel());  	//근속년수 시작일
				srhHdofcCodtnCd.setValue("");					//재직구분
//				searchHdofcCodtnCd.setValue(new BaseModel());	//재직구분
				searchSexType.setValue(new BaseModel());		//성별
				srhBusinCd.setValue(new BaseModel());			//사업명
				
				if(searchEmymtDivCd.isEnabled()){
					searchEmymtDivCd.setValue(new BaseModel());
					srhTypOccuCd.setEnabled(true);
					srhTypOccuCd.setValue(new BaseModel());
					srhDtilOccuInttnCd.getInitStore();
					srhDeptCd.setValue(""); //부서
					srhDeptNm.setValue(""); //부서
					//searchCurrDeptCd.setStore(listStoreBass0400All);
				}
				
				// 그리드 초기화
//				psnl0600Grid.getStore().removeAll(); //기본 그리드
//				psnl0112Grid.getStore().removeAll(); //병역 그리드
//				psnl0114Grid.getStore().removeAll(); //단체 그리드
//				psnl0116Grid.getStore().removeAll(); //학력 그리드
//				psnl0119Grid.getStore().removeAll(); //경력 그리드
//				psnl0118Grid.getStore().removeAll(); //자격 그리드
//				psnl0120Grid.getStore().removeAll(); //교육 그리드
//				psnl0121Grid.getStore().removeAll(); //포상 그리드
//				psnl0122Grid.getStore().removeAll(); //징계 그리드
//				psnl0123Grid.getStore().removeAll(); //휴직 그리드
				
				
				psnl0600GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0112GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0114GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0116GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0119GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0118GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0120GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0121GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0122GridPanel.getMsfGrid().clearData();
				psnl0600ToPsnl0123GridPanel.getMsfGrid().clearData();
				
				//조회시 탭부분 초기화
				tabsPsnl.setSelection(tabsPsnl.getItem(0));
				
			}
		});
		topPsnl0600Bar.add(btnPsnl0600Reset);
		
		//조회버튼 시작
		btnPsnl0600Sreach = new Button("조회");
		btnPsnl0600Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0600Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				//조회시 탭부분 초기화
				if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0600.load();
					reloadPsnl0600();
				}else if("itemPsnl0112".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0112.load();
					reloadPsnl0112();
				}else if("itemPsnl0114".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0114.load();
					reloadPsnl0114();
				}else if("itemPsnl0116".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0116.load();
					reloadPsnl0116();
				}else if("itemPsnl0119".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0119.load();
					reloadPsnl0119();
				}else if("itemPsnl0118".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0118.load();
					reloadPsnl0118();
				}else if("itemPsnl0120".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0120.load();
					reloadPsnl0120();
				}else if("itemPsnl0121".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0121.load();
					reloadPsnl0121();
				}else if("itemPsnl0122".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0122.load();
					reloadPsnl0122();
				}else if("itemPsnl0123".equals(tabsPsnl.getSelectedItem().getId())){
//					loaderPsnl0123.load();
					reloadPsnl0123();
				}else{
					tabsPsnl.setSelection(tabsPsnl.getItem(0));
//					loaderPsnl0600.load();
					reloadPsnl0600();
				}
			}
		});
		topPsnl0600Bar.add(btnPsnl0600Sreach);
		
		btnPsnl0600Print = new Button("인쇄", psnl0600ButtonListener);
		btnPsnl0600Print.setIcon(MSFMainApp.ICONS.print16());
//		btnPsnl0600Print.addListener(Events.OnClick, new Listener<ButtonEvent>() {
//			@Override
//			public void handleEvent(ButtonEvent be) {
//				//탭정보
//				String strDirPath = "PSNL";
//				String rdaFileName = "";
//				String strParam = "/rp ";
//				String checkedSystemKeys = "";
//				if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){ //기본
//					
//					rdaFileName = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
//					
//					List<Psnl0600DTO> checkList  = psnl0600Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0112".equals(tabsPsnl.getSelectedItem().getId())){ //병역
//					
//					rdaFileName = "PSNLT0274";
//					
//					List<Psnl0600DTO> checkList  = psnl0112Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0114".equals(tabsPsnl.getSelectedItem().getId())){ //단체
//					//인쇄할 필요 없음
//					return;
//				}else if("itemPsnl0116".equals(tabsPsnl.getSelectedItem().getId())){ //학력
//					rdaFileName = "PSNLT0275";
//					
//					List<Psnl0600DTO> checkList  = psnl0116Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0119".equals(tabsPsnl.getSelectedItem().getId())){ //경력
//					rdaFileName = "PSNLT0281";
//					
//					List<Psnl0600DTO> checkList  = psnl0119Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0118".equals(tabsPsnl.getSelectedItem().getId())){ //자격
//					rdaFileName = "PSNLT0277";
//					
//					List<Psnl0600DTO> checkList  = psnl0118Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0120".equals(tabsPsnl.getSelectedItem().getId())){ //교육
//					rdaFileName = "PSNLT0278";
//					
//					List<Psnl0600DTO> checkList  = psnl0120Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0121".equals(tabsPsnl.getSelectedItem().getId())){ //포상
//					rdaFileName = "PSNLT0276";
//					
//					List<Psnl0600DTO> checkList  = psnl0121Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0122".equals(tabsPsnl.getSelectedItem().getId())){ //징계
//					rdaFileName = "PSNLT0279";
//					
//					List<Psnl0600DTO> checkList  = psnl0122Grid.getSelectionModel().getSelectedItems();
//					if(checkList != null && checkList.size() > 0){
//						for(Psnl0600DTO dto : checkList){
//							if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//								checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//							}
//						}
//					}
//				}else if("itemPsnl0123".equals(tabsPsnl.getSelectedItem().getId())){ //휴직
//					//인쇄할 필요 없음
//					return;
//				}
//				
//				checkedSystemKeys = checkedSystemKeys.length() > 0 ? checkedSystemKeys.substring(1, checkedSystemKeys.length()) : "";
//				
//				//System.out.println("checkedSystemKeys = " + checkedSystemKeys);
//				
//				if("".equals(checkedSystemKeys)){
//					MessageBox.info("", "인쇄 하실 내용을 체크하여 주세요.", null);
//					return;
////				    strParam += "[]";
////                    PrintUtils.setPostCall(true);
////                    PrintUtils.rdaPrint(strDirPath, rdaFileName+".mrd", strParam);
//				}else{
//					strParam += "["+checkedSystemKeys+"]";
//					PrintUtils.setPostCall(true);
//					PrintUtils.rdaPrint(strDirPath, rdaFileName+".mrd", strParam);
//				}
//			}
//		});
		topPsnl0600Bar.add(btnPsnl0600Print);
 
//		topBtn = new Button("엑셀");
		btnPsnl0600Excel = new Button("엑셀");
		btnPsnl0600Excel.setIcon(MSFMainApp.ICONS.excel16());
		btnPsnl0600Excel.addListener(Events.OnClick, new Listener<ButtonEvent>() {
	            @Override
	            public void handleEvent(ButtonEvent be) {
	                //탭정보  
	                if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){ //기본
	                	
	                	HashMap<String, String> param = new HashMap<String, String>(); 
	                             
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	                	
	                	/******************* 기본 검색조건 시작 *******************/       
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
	                      
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export01.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 

	                }else if("itemPsnl0112".equals(tabsPsnl.getSelectedItem().getId())){ //병역
	                	
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/            
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhDsageDivCd", PersonalUtil.getSelectedComboValue(searchDsageDivCd,"commCd"));	//제대구분
            	    	param.put("srhDsageDtS", searchDsageDtS.getValue() == null ? "" : dateTimeFormat.format(searchDsageDtS.getValue()));//제대 시작 일자  
            	    	param.put("srhDsageDtE", searchDsageDtE.getValue() == null ? "" : dateTimeFormat.format(searchDsageDtE.getValue()));//제대 종료 일자 
            	    	param.put("srhBaggrpCd", PersonalUtil.getSelectedComboValue(searchBaggrpCd,"commCd"));	//군별
            	    	param.put("srhAbotsCd", PersonalUtil.getSelectedComboValue(searchAbotsCd,"commCd"));	//병과
            	    	param.put("srhClsCd", PersonalUtil.getSelectedComboValue(searchClsCd,"commCd"));		//계급
            	    	
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export02.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	                    
//	                    return;  
	                }else if("itemPsnl0114".equals(tabsPsnl.getSelectedItem().getId())){ //단체
	                	
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/     
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhJnOpztnNm", searchJnOpztnNm.getValue());	//단체명
            	    	param.put("srhJnDtS", searchJnDtS.getValue() == null ? "" : dateTimeFormat.format(searchJnDtS.getValue()));//가입 시작 일자  
            	    	param.put("srhJnDtE", searchJnDtE.getValue() == null ? "" : dateTimeFormat.format(searchJnDtE.getValue()));//가입 종료 일자
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export03.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	                	
//	                    return;
	                }else if("itemPsnl0116".equals(tabsPsnl.getSelectedItem().getId())){ //학력
	                    
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/        
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhAcadAbtyDivCd", PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));//학력구분
            	    	param.put("srhSchlCd", searchSchlCd.getValue());		//학교
            	    	param.put("srhDeprMajrCd", searchDeprMajrCd.getValue());//학과
            	    	param.put("srhDegrDivCd", PersonalUtil.getSelectedComboValue(searchDegrDivCd,"commCd"));//학위
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export04.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
            	    	
//	                    return;
	                }else if("itemPsnl0119".equals(tabsPsnl.getSelectedItem().getId())){ //경력
	                    
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/            
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhPaeWorkNm", searchPaeWorkNm.getValue());//근무처명
            	    	param.put("srhCarrBgnnDtS", searchCarrBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchCarrBgnnDtS.getValue()));//근무시작일(시작)
            	    	param.put("srhCarrBgnnDtE", searchCarrBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchCarrBgnnDtE.getValue()));//근무시작일(종료)
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export05.do","extgwtFrame", JsUtil.toJavaScriptObject(param));
	                	
//	                    return;
	                }else if("itemPsnl0118".equals(tabsPsnl.getSelectedItem().getId())){ //자격
	                    
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/          
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhQftntLicnsPovncCtnt", searchQftntLicnsPovncCtnt.getValue());//자격면허
            	    	param.put("srhAqtnDtS", searchAqtnDtS.getValue() == null ? "" : dateTimeFormat.format(searchAqtnDtS.getValue()));//취득일자(시작)
            	    	param.put("srhAqtnDtE", searchAqtnDtE.getValue() == null ? "" : dateTimeFormat.format(searchAqtnDtE.getValue()));//취득일자(종료)
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export06.do","extgwtFrame", JsUtil.toJavaScriptObject(param));
	                	
//	                    return;
	                }else if("itemPsnl0120".equals(tabsPsnl.getSelectedItem().getId())){ //교육
	                    
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/   
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhEduKndNm", searchEduKndNm.getValue());//교육종류
            	    	param.put("srhEduBgnnDtS", searchEduBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchEduBgnnDtS.getValue()));//교육기간(시작)
            	    	param.put("srhEduBgnnDtE", searchEduBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchEduBgnnDtE.getValue()));//교육기간(종료)
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export07.do","extgwtFrame", JsUtil.toJavaScriptObject(param));
	                	
//	                    return;
	                }else if("itemPsnl0121".equals(tabsPsnl.getSelectedItem().getId())){ //포상
	                    
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/      
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export08.do","extgwtFrame", JsUtil.toJavaScriptObject(param));
            	    	
//	                    return;
	                }else if("itemPsnl0122".equals(tabsPsnl.getSelectedItem().getId())){ //징계
	                    
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/     
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhDsnyActDivCd", PersonalUtil.getSelectedComboValue(searchDsnyActDivCd,"commCd"));//징계구분
            	    	param.put("srhDsnyActDsplDtS", searchDsnyActDsplDtS.getValue() == null ? "" : dateTimeFormat.format(searchDsnyActDsplDtS.getValue()));//징계처분일(시작)
            	    	param.put("srhDsnyActDsplDtE", searchDsnyActDsplDtE.getValue() == null ? "" : dateTimeFormat.format(searchDsnyActDsplDtE.getValue()));//징계처분일(종료)
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export09.do","extgwtFrame", JsUtil.toJavaScriptObject(param));
	                	
//	                    return;
	                }else if("itemPsnl0123".equals(tabsPsnl.getSelectedItem().getId())){ //휴직
	                   
	                	HashMap<String, String> param = new HashMap<String, String>(); 
                        
	                	DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            	        /******************* 기본 검색조건 시작 *******************/  
	                	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
	                	
            	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
            	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
            	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
            	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
            	        
            	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
            	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
            	        param.put("srhNowDeptDateS", searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue()));
            	        param.put("srhNowDeptDateE", searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue()));
            	        param.put("srhFrstWorkDateS", searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue()));
            	        param.put("srhFrstWorkDateE", searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue()));
            	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
            	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
            	                    
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
            	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
            	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
            	    	/******************* 기본 검색조건 종료 *******************/
            	    	
            	    	param.put("srhLevfAbncDivCd", PersonalUtil.getSelectedComboValue(searchLevfAbncDivCd,"commCd"));//휴직구분
            	    	param.put("srhLevfAbncBgnnDtS", searchLevfAbncBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchLevfAbncBgnnDtS.getValue()));//휴직기간(시작)
            	    	param.put("srhLevfAbncBgnnDtE", searchLevfAbncBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchLevfAbncBgnnDtE.getValue()));//휴직기간(종료)
            	    	
            	    	//넘어온메서드 값을 가지고 처리 한다.  
            	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600Export10.do","extgwtFrame", JsUtil.toJavaScriptObject(param));	                	
//	                	return;
	                }
	            }
	        });
		topPsnl0600Bar.add(btnPsnl0600Excel);
		
		Button btnPsnlAll0600Exl = new Button("통합 출력");
		btnPsnlAll0600Exl.setIcon(MSFMainApp.ICONS.excel16());
		btnPsnlAll0600Exl.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				PsnlP060001 psnlP060001Form = new PsnlP060001(ActionDatabase.READ, getThis());
				MSFFormWindows msFwPsnlP060001 = new MSFFormWindows("인사통합출력", psnlP060001Form, "닫기", "970px", "310px", true);
				msFwPsnlP060001.show();
				psnlP060001Form.setMSFFormWindows(msFwPsnlP060001);
//				
//				
//				BaseModel bmRecord = new BaseModel();
//
//				bmRecord.set("formId", "PSNL0100");
//				
//				setPPRecord(bmRecord); 
//				psnlP010002Form.bind(ppRecord);
				
				
			}
		});
		topPsnl0600Bar.add(btnPsnlAll0600Exl);
		

		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.setBorders(false);
		plFrmPsnl0600.add(layoutContainer);
		layoutContainer.setBorders(false);

		// 파일업로드 처리
		plFrmPsnl0600.setAction("myurl");
		plFrmPsnl0600.setEncoding(Encoding.MULTIPART);
		plFrmPsnl0600.setMethod(Method.POST);

		vp.add(plFrmPsnl0600);
		plFrmPsnl0600.setSize("990px", "690px");
	}
	
	private SelectionListener<ButtonEvent> psnl0600ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			String printType = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
			
			if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){ //기본
				
				Psnl0600Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
			}else if("itemPsnl0112".equals(tabsPsnl.getSelectedItem().getId())){ //병역
				
				//printType = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
				Psnl0600Print("PSNLT0274", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
//				RdaPrint("PSNLT0274");
				
			}else if("itemPsnl0114".equals(tabsPsnl.getSelectedItem().getId())){ //단체
				//인쇄할 필요 없음
				return;
			}else if("itemPsnl0116".equals(tabsPsnl.getSelectedItem().getId())){ //학력
//				TODO REX 학력 리포트가 없어서 임시로 만들었음..
				Psnl0600Print("PSNLT0275", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				return;
				
			}else if("itemPsnl0119".equals(tabsPsnl.getSelectedItem().getId())){ //경력
				Psnl0600Print("PSNLT0281", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}else if("itemPsnl0118".equals(tabsPsnl.getSelectedItem().getId())){ //자격
				
				Psnl0600Print("PSNLT0277", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
//				Psnl0600Print("PSNLT0281", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
			}else if("itemPsnl0120".equals(tabsPsnl.getSelectedItem().getId())){ //교육
				
				Psnl0600Print("PSNLT0278", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
			}else if("itemPsnl0121".equals(tabsPsnl.getSelectedItem().getId())){ //포상
				
				Psnl0600Print("PSNLT0276", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
			}else if("itemPsnl0122".equals(tabsPsnl.getSelectedItem().getId())){ //징계
				
				Psnl0600Print("PSNLT0279", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
			}else if("itemPsnl0123".equals(tabsPsnl.getSelectedItem().getId())){ //휴직
				//인쇄할 필요 없음
				//Psnl0600Print("PSNLT0275", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
				
				return;
			}
		}
	};	
 
	// TODO 기본 탭 시작
	private LayoutContainer StdData01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft"	, "5px");
		lcTabFormLayer.setStyleAttribute("paddingRight"	, "5px");
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(950, 460);
		
		psnl0600GridPanel = new MSFGridPanel(psnl0600Def, false, false, false, false, false);
		psnl0600GridPanel.setHeaderVisible(false);  
		psnl0600GridPanel.setBodyBorder(false);
	    psnl0600GridPanel.setBorders(true);
	    

	    cp01.add(psnl0600GridPanel); 

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//		// selection model supports the SIMPLE selection mode
//		// sm.setSelectionMode(SelectionMode.SIMPLE);
//
//		configs.add(sm.getColumn());
//		
//		ColumnConfig column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//        column.setId("currDeptNm");
//        column.setHeaderText("부서");
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setWidth(110);
//        column.setSortable(false);
//        column.setMenuDisabled(true);
//        configs.add(column);
//		 
//        column = new ColumnConfig();
//        column.setId("hanNm");
//        column.setHeaderText("성 명");
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setWidth(80);
//        column.setSortable(false);
//        column.setMenuDisabled(true);
//        configs.add(column);
//
//        column = new ColumnConfig();
//        column.setId("resnRegnNum");
//        column.setHeaderText("주민등록번호");
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setWidth(100);
//        column.setSortable(false);
//        column.setMenuDisabled(true);
//        configs.add(column);
//        
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
////		column.setId("dtilOccuClsDivNm");
//		column.setId("dtilOccuInttnNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//        column.setId("businNm");
//        column.setHeaderText("사업");
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setWidth(110);
//        column.setSortable(false);
//        column.setMenuDisabled(true);
//        configs.add(column);
//	       
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("frstEmymtDt");
//		column.setHeaderText("최초고용일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("currDeptAppmtDt");
//		column.setHeaderText("현부서고용일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("retryDt");
//		column.setHeaderText("퇴직일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("logSvcYrNumNm");
//		column.setHeaderText("근무년수");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("logSvcMnthIcmNm");
//		column.setHeaderText("근무월");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dabtyDivNm");
//		column.setHeaderText("장애구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("addr");
//		column.setHeaderText("도로명주소");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(300);
//		column.setSortable(false);
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("husPhnNum");
//		column.setHeaderText("전화번호");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("cellPhneNum");
//		column.setHeaderText("핸드폰");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emailAddr");
//		column.setHeaderText("이메일");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("pernNoteCtnt");
//		
//		column.setHeaderText("비 고");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//
//
//		psnl0600Grid = new Grid<Psnl0600DTO>(storePsnl0600, cm);
//		psnl0600Grid.setStateful(true);
//		psnl0600Grid.setSelectionModel(sm);
//		psnl0600Grid.setBorders(true);
//		psnl0600Grid.setColumnReordering(true);
//		psnl0600Grid.setLoadMask(true);
//		//psnl0600Grid.setAutoExpandColumn("pernNoteCtnt");
//		psnl0600Grid.addPlugin(sm);
//   cp01.add(psnl0600Grid);
		
		
		outputTypeRadiogroup = new RadioGroup();
		outputTypeRadiogroup.setBorders(false);
		outputTypeRadiogroup.setFieldLabel("출력조건");
		
		Radio radio = new Radio();
		radio.setBoxLabel("기본");
		radio.setHideLabel(true);
		radio.setValue(true);
		radio.setValueAttribute("PSNLT0270"); 
		outputTypeRadiogroup.add(radio);

		radio = new Radio();
		radio.setBoxLabel("인적");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0272"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("신상");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0273"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("가족");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0280"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("발령");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0281"); 
		outputTypeRadiogroup.add(radio);
		
		
		LayoutContainer lcTabFormLayer2 = new LayoutContainer();
		lcTabFormLayer2.setLayout(new FlowLayout());
		lcTabFormLayer2.setBorders(false);
		lcTabFormLayer2.add(outputTypeRadiogroup);
		
		
		lcTabFormLayer.add(lcTabFormLayer2);
		
		
		
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}

	// 병역
	private LayoutContainer PersonalMilitary01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
		cp01.setSize(968, 495);
		cp01.setLayout(new FitLayout());

//		List<Stock> stocks = TestData.getStocks();
//		Collections.sort(stocks, new Comparator<Stock>() {
//			public int compare(Stock arg0, Stock arg1) {
//				return arg0.getName().compareTo(arg1.getName());
//			}
//		});
//		ListStore<Stock> store = new ListStore<Stock>();
//		store.add(stocks);

		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		// TODO 병역 검색시작
		searchDsageDivCd = new ComboBox<BaseModel>();
		searchDsageDivCd.setFieldLabel("제대구분");
		searchDsageDivCd.setForceSelection(true);
		searchDsageDivCd.setMinChars(1);
		searchDsageDivCd.setDisplayField("commCdNm");
		searchDsageDivCd.setValueField("commCd");
		searchDsageDivCd.setTriggerAction(TriggerAction.ALL);
		searchDsageDivCd.setEmptyText("--제대구분선택--");
		searchDsageDivCd.setSelectOnFocus(true);
		searchDsageDivCd.setStore(listStoreA025);
		
		layoutContainer_7.add(searchDsageDivCd, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		layoutContainer_6.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);

		
		searchDsageDtS = new DateField();
		new DateFieldMask(searchDsageDtS, "9999.99.99");
		searchDsageDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsageDtS.setFieldLabel("제대일자");
		layoutContainer_9.add(searchDsageDtS, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchDsageDtE = new DateField();
		new DateFieldMask(searchDsageDtE, "9999.99.99");
		searchDsageDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsageDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchDsageDtE, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);

		searchBaggrpCd = new ComboBox<BaseModel>();
		searchBaggrpCd.setFieldLabel(" 군별");
		searchBaggrpCd.setForceSelection(true);
		searchBaggrpCd.setMinChars(1);
		searchBaggrpCd.setDisplayField("commCdNm");
		searchBaggrpCd.setValueField("commCd");
		searchBaggrpCd.setTriggerAction(TriggerAction.ALL);
		searchBaggrpCd.setEmptyText("--군별선택--");
		searchBaggrpCd.setSelectOnFocus(true);
		searchBaggrpCd.setStore(listStoreA023);
		
		layoutContainer_8.add(searchBaggrpCd, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_8.setBorders(false);
		fieldSet.add(layoutContainer_5, new FormData("100%"));
		layoutContainer_5.setBorders(false);

		searchAbotsCd = new ComboBox<BaseModel>();
		searchAbotsCd.setFieldLabel("병과");
		searchAbotsCd.setForceSelection(true);
		searchAbotsCd.setMinChars(1);
		searchAbotsCd.setDisplayField("commCdNm");
		searchAbotsCd.setValueField("commCd");
		searchAbotsCd.setTriggerAction(TriggerAction.ALL);
		searchAbotsCd.setEmptyText("--병과선택--");
		searchAbotsCd.setSelectOnFocus(true);
		searchAbotsCd.setStore(listStoreA024);
		layoutContainer_3.add(searchAbotsCd, new FormData("100%"));

		searchClsCd = new ComboBox<BaseModel>();
		searchClsCd.setFieldLabel("계급");
		searchClsCd.setForceSelection(true);
		searchClsCd.setMinChars(1);
		searchClsCd.setDisplayField("commCdNm");
		searchClsCd.setValueField("commCd");
		searchClsCd.setTriggerAction(TriggerAction.ALL);
		searchClsCd.setEmptyText("--계급선택--");
		searchClsCd.setSelectOnFocus(true);
		searchClsCd.setStore(listStoreA045);
		
		layoutContainer_4.add(searchClsCd, new FormData("100%"));
		
		layoutContainer_2.setBorders(false);
		
		
		
		fieldSet.add(layoutContainer_2);
		
		/*LayoutContainer layoutContainer_search = new LayoutContainer();
		layoutContainer_search.setLayout(new ColumnLayout());
		Button btn = new Button("세부조회");
		btn.setIcon(MSFMainApp.ICONS.accordion());
		layoutContainer_search.add(btn);
		fieldSet.add(layoutContainer_search);*/
		
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();

		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
//		cp02.setSize(956, 338);
		cp02.setSize(956, 417);
		
		psnl0600ToPsnl0112GridPanel = new MSFGridPanel(psnl0600ToPsnl0112Def, false, false, false, false, false);
		psnl0600ToPsnl0112GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0112GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0112GridPanel.setBorders(true);
	    
	    cp02.add(psnl0600ToPsnl0112GridPanel); 

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//        column.setId("hanNm");
//        column.setHeaderText("성 명");
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setWidth(80);
//        column.setSortable(false);
//        column.setMenuDisabled(true);
//        configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
// 
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsageDivCd");
//		column.setHeaderText("제대구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("enrlntDt");
//		column.setHeaderText("입대일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsageDt");
//		column.setHeaderText("제대일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("servcRcgtnPridCd");
//		column.setHeaderText("복무인정기간");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("srvssCd");
//		column.setHeaderText("역 종");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("baggrpCd");
//		column.setHeaderText("군 별");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("abotsCd");
//		column.setHeaderText("병 과");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("clsCd");
//		column.setHeaderText("계 급");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("mitySilnum");
//		column.setHeaderText("군 번");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("mos");
//		column.setHeaderText("MOS");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("exmtnReasCd");
//		column.setHeaderText("면제사유");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0112Grid = new Grid<Psnl0600DTO>(storePsnl0112, cm);
//		psnl0112Grid.setStateful(true);
//		psnl0112Grid.setSelectionModel(sm);
//		psnl0112Grid.setBorders(true);
//		psnl0112Grid.setColumnReordering(true);
//		psnl0112Grid.setLoadMask(true);
//		psnl0112Grid.addPlugin(sm);
//		
//		
//
//		cp02.add(psnl0112Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;
	}

	

	// TODO 단체 시작
	private LayoutContainer PersonalGroup01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
		cp01.setSize(968, 500);
		cp01.setLayout(new FitLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		searchJnOpztnNm = new TextField<String>();
		searchJnOpztnNm.setFieldLabel("단체명");
		layoutContainer_3.add(searchJnOpztnNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchJnDtS = new DateField();
		new DateFieldMask(searchJnDtS, "9999.99.99");
		searchJnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchJnDtS.setFieldLabel("가입기간");
		layoutContainer_9.add(searchJnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchJnDtE = new DateField();
		new DateFieldMask(searchJnDtE, "9999.99.99");
		searchJnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchJnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchJnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0114GridPanel = new MSFGridPanel(psnl0600ToPsnl0114Def, false, false, false, false, false);
		psnl0600ToPsnl0114GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0114GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0114GridPanel.setBorders(true);
	    
		cp02.add(psnl0600ToPsnl0114GridPanel); 

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		//final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//		//configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("jnDt");
//		column.setHeaderText("가입일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("jnOpztnNm");
//		column.setHeaderText("가입단체명");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("odtyCd", "직책", 120);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("wirlDt");
//		column.setHeaderText("탈퇴일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0114Grid = new Grid<Psnl0600DTO>(storePsnl0114, cm);
//		//psnl0114Grid.setSelectionModel(sm);
//		psnl0114Grid.setBorders(true);
//		psnl0114Grid.setColumnReordering(true);
//		//psnl0114Grid.addPlugin(sm);
//		psnl0114Grid.setStateful(true);
//		psnl0114Grid.setLoadMask(true);
//		
//		
//		cp02.add(psnl0114Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	

	// TODO 학력 시작
	private LayoutContainer PersonalAcademicAbility01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		LayoutContainer lcTabCol02 = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(968, 463);
		cp01.setSize(968, 500);
		cp01.setLayout(new FlowLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
		
		
		searchAcadAbtyDivCd = new ComboBox<BaseModel>();
		searchAcadAbtyDivCd.setFieldLabel("학력구분");
		searchAcadAbtyDivCd.setForceSelection(true);
		searchAcadAbtyDivCd.setMinChars(1);
		searchAcadAbtyDivCd.setDisplayField("commCdNm");
		searchAcadAbtyDivCd.setValueField("commCd");
		searchAcadAbtyDivCd.setTriggerAction(TriggerAction.ALL);
		searchAcadAbtyDivCd.setEmptyText("--학력구분선택--");  
		searchAcadAbtyDivCd.setSelectOnFocus(true);
		searchAcadAbtyDivCd.setStore(listStoreA026);
		searchAcadAbtyDivCd.addListener(Events.Valid, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				searchSchlCd.setValue("");
				searchDeprMajrCd.setValue("");
				if(searchAcadAbtyDivCd.getValue() == null){
					searchSchlCdNm.setEmptyText("--학력선택--");
					searchDeprMajrCdNm.setEmptyText("--학력선택--");
				}else{
					searchSchlCdNm.setEmptyText("--학교선택--");
					searchDeprMajrCdNm.setEmptyText("--학과선택--");
				}
			}
		});
		searchAcadAbtyDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
       	 	public void handleEvent(BaseEvent be) {
				
				// 학력구분을 해당없음으로 선택하였을 경우 조건에 있는 학교, 학과, 학위를 초기화 해줌.
				if("A0260000".equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd")))) {
					
					searchDeprMajrCd.setValue("");
            		searchDeprMajrCdNm.setValue("");
        			searchSchlCd.setValue("");
        			searchSchlCdNm.setValue("");
        			searchDegrDivCd.setValue(new BaseModel());
        			
				}
       	 	}
		});
		
		
		
		layoutContainer_7.add(searchAcadAbtyDivCd, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		layoutContainer_5.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		layoutContainer_3.setBorders(false);
		
		
		
		searchSchlCd = new TextField<String>();
		searchDeprMajrCd = new TextField<String>();
		
		searchSchlCdNm = new TextField<String>();
		searchSchlCdNm.setFieldLabel("학교");
		searchSchlCdNm.setEmptyText("--학력선택--");
		searchSchlCdNm.setReadOnly(true);
		searchSchlCdNm.addListener(Events.OnFocus, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				Lov lov;     
				LovLiveGeneric lovWindow; 
				MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
				MSFCustomForm sysCom0130Form = customForm.getCustomForm();    
				MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
				final FormBinding popBindingInner = comform.getFormBinding();
				
				customForm.setLov(new PrgmComP0130());
				lov = customForm.getLov();   
				
				//학교구분의 선택에 따라..
//				String schType= searchAcadAbtyDivCd.getValue() == null ? "" : String.valueOf(searchAcadAbtyDivCd.getValue().get("commCd"));
				String schType = MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));
				
				if(schType != null && !"".equals(schType)) {
					
					String sch = schType.substring(schType.length()-2,schType.length()-1);
					if("2".equals(sch)){
						sch = "A031";
					}else if("3".equals(sch)){
						sch = "A032";
					}else if("4".equals(sch)){
						sch = "A033";
					}else if("5".equals(sch)){
						sch = "A034";
					}else if("6".equals(sch)){
						sch = "A035";
					}else{
						sch = "";
					}
					
					fnPopupBass0300(sch);
					
//					String sch = schType.substring(schType.length()-2,schType.length()-1);
//					if("2".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A031", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("3".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A032", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("4".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A033", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("5".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A034", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("6".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A035", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else{
//						lov = null;
//					}
//					
//					popBindingInner.addListener(Events.Change, new Listener<BaseEvent>() {
//			            public void handleEvent(BaseEvent be) {
//			            	if (!"".equals(popBindingInner.getModel().get("rpsttvCd"))) {
//			            		//코드값 및 버튼 텍스트 변경.
//			            		searchSchlCd.setValue(String.valueOf(popBindingInner.getModel().get("commCd")));
//			            		searchSchlCdNm.setValue(String.valueOf(popBindingInner.getModel().get("commCdNm")));
//			            	}  
//			            }
//			        });
//					
//	                if (lov != null) {
//                		lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
//                        lovWindow.setInitialForm(sysCom0130Form);   //formPanel을적어준다.
//                        lovWindow.showButtonNew(true);
//                        lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//                        lovWindow.show();
//                        lov.fixAttributeFormNames(); 
//               
//                	} 
				}else{
					MessageBox.alert("", "학력구분을 선택하여주세요.", null);
				}
			}
		
		});
		
		layoutContainer_3.add(searchSchlCdNm, new FormData("100%"));

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
		
		
		searchDeprMajrCdNm = new TextField<String>();
		searchDeprMajrCdNm.setFieldLabel("학과");
		searchDeprMajrCdNm.setEmptyText("--학력선택--");  
		searchDeprMajrCdNm.setReadOnly(true);
		searchDeprMajrCdNm.addListener(Events.OnFocus, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				// 학교구분의 선택에 따라..
				String schType = MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));
				
				if(schType != null && !"".equals(schType)) {
					
					String sch = schType.substring(schType.length()-2,schType.length()-1);
					
					if("4".equals(sch) || "5".equals(sch) || "6".equals(sch) ){
						sch = "A027";
					}else{
						sch = "";
					}
					
					fnPopupBass0300(sch);
					
				}else{
					MessageBox.alert("", "학력구분을 선택하여주세요.", null);
				}			
				
//				Lov lov;     
//				LovLiveGeneric lovWindow; 
//				MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
//				MSFCustomForm sysCom0130Form = customForm.getCustomForm();    
//				MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
//				final FormBinding popBindingInner = comform.getFormBinding();
//				
//				customForm.setLov(new PrgmComP0130());
//				lov = customForm.getLov();   
//				
//				//학교구분의 선택에 따라..
//				String schType= searchAcadAbtyDivCd.getValue() == null ? "" : String.valueOf(searchAcadAbtyDivCd.getValue().get("commCd"));
//				
//				if(schType != null && !"".equals(schType))
//				{
//					String sch = schType.substring(schType.length()-2,schType.length()-1);
//					if("4".equals(sch) || "5".equals(sch) || "6".equals(sch) ){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A027", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else{
//						lov = null;
//					}
//					
//					popBindingInner.addListener(Events.Change, new Listener<BaseEvent>() {
//			            public void handleEvent(BaseEvent be) {
//			            	if (!"".equals(popBindingInner.getModel().get("rpsttvCd"))) {
//			            		//코드값 및 버튼 텍스트 변경.
//			            		searchDeprMajrCd.setValue(String.valueOf(popBindingInner.getModel().get("commCd")));
//			            		searchDeprMajrCdNm.setValue(String.valueOf(popBindingInner.getModel().get("commCdNm")));
//			            	}  
//			            }
//			        });
//					
//	                if (lov != null) {
//                		lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
//                        lovWindow.setInitialForm(sysCom0130Form);   //formPanel을적어준다.
//                        lovWindow.showButtonNew(true);
//                        lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//                        lovWindow.show();
//                        lov.fixAttributeFormNames(); 
//               
//                	} 
//				}else{
//					MessageBox.alert("", "학력구분을 선택하여주세요.", null);
//				}
			}
		});
		
		layoutContainer_8.add(searchDeprMajrCdNm, new FormData("100%"));
		
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		layoutContainer_5.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
		
		
		searchDegrDivCd = new ComboBox<BaseModel>();
		searchDegrDivCd.setFieldLabel("학위");
		searchDegrDivCd.setForceSelection(true);
		searchDegrDivCd.setMinChars(1);
		searchDegrDivCd.setDisplayField("commCdNm");
		searchDegrDivCd.setValueField("commCd");
		searchDegrDivCd.setTriggerAction(TriggerAction.ALL);
		searchDegrDivCd.setEmptyText("--학위선택--");  
		searchDegrDivCd.setSelectOnFocus(true);
		searchDegrDivCd.setStore(listStoreA028);
		
		layoutContainer_4.add(searchDegrDivCd, new FormData("100%"));
		
		fieldSet.add(layoutContainer_5, new FormData("100%"));
		layoutContainer.add(fieldSet);
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
//		cp02.setSize(956, 338);
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0116GridPanel = new MSFGridPanel(psnl0600ToPsnl0116Def, false, false, false, false, false);
		psnl0600ToPsnl0116GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0116GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0116GridPanel.setBorders(true);
	    
	    cp02.add(psnl0600ToPsnl0116GridPanel); 

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서"); 
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("etncItshlDt");
//		column.setHeaderText("입학일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("grdtnDt");
//		column.setHeaderText("졸업일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("acadAbtyDivCd", "학력구분", 120);
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("schlCd");
//		column.setHeaderText("학교명");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deprMajrCd");
//		column.setHeaderText("전공학과");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("degrDivCd");
//		column.setHeaderText("학위");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("lesnYrNumCd");
//		column.setHeaderText("수업년수");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("acadAbtyNoteCtnt");
//		column.setHeaderText("비 고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0116Grid = new Grid<Psnl0600DTO>(storePsnl0116, cm);
//		psnl0116Grid.setSelectionModel(sm);
//		psnl0116Grid.setBorders(true);
//		psnl0116Grid.setColumnReordering(true);
//		psnl0116Grid.addPlugin(sm);
//		psnl0116Grid.setStateful(true);
//		psnl0116Grid.setLoadMask(true);
//		
//		cp02.add(psnl0116Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	// TODO 경력시작
	private LayoutContainer PersonalTemp01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(968, 463);
		cp01.setSize(968, 500);
		cp01.setLayout(new FitLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		searchPaeWorkNm = new TextField<String>();
		searchPaeWorkNm.setFieldLabel("근무처명");
		layoutContainer_3.add(searchPaeWorkNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchCarrBgnnDtS = new DateField();
		new DateFieldMask(searchCarrBgnnDtS, "9999.99.99");
		searchCarrBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchCarrBgnnDtS.setFieldLabel("근무시작일");
		layoutContainer_9.add(searchCarrBgnnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchCarrBgnnDtE = new DateField();
		new DateFieldMask(searchCarrBgnnDtE, "9999.99.99");
		searchCarrBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchCarrBgnnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchCarrBgnnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0119GridPanel = new MSFGridPanel(psnl0600ToPsnl0119Def, false, false, false, false, false);
		psnl0600ToPsnl0119GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0119GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0119GridPanel.setBorders(true);
	    
	    cp02.add(psnl0600ToPsnl0119GridPanel); 


//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("carrBgnnDt");
//		column.setHeaderText("근무시작일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("carrEndDt");
//		column.setHeaderText("근무종료일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("paeWorkNm", "근무처", 200);
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("odtyNm");
//		column.setHeaderText("직책명");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("repbtyBusinNm");
//		column.setHeaderText("담당업무");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("carrNoteCtnt");
//		column.setHeaderText("비고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0119Grid = new Grid<Psnl0600DTO>(storePsnl0119, cm);
//		psnl0119Grid.setSelectionModel(sm);
//		psnl0119Grid.setBorders(true);
//		psnl0119Grid.setColumnReordering(true);
//		psnl0119Grid.addPlugin(sm);
//		psnl0119Grid.setStateful(true);
//		psnl0119Grid.setLoadMask(true);
//
//		cp02.add(psnl0119Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	// TODO 자격시작
	private LayoutContainer PersonalTemp02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
		cp01.setSize(968, 500);
//		cp01.setSize(968, 463);
		cp01.setLayout(new FitLayout());

		

		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		searchQftntLicnsPovncCtnt = new TextField<String>();
		searchQftntLicnsPovncCtnt.setFieldLabel("자격면허");
		layoutContainer_3.add(searchQftntLicnsPovncCtnt, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchAqtnDtS = new DateField();
		new DateFieldMask(searchAqtnDtS, "9999.99.99");
		searchAqtnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchAqtnDtS.setFieldLabel("취득일자");
		layoutContainer_9.add(searchAqtnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchAqtnDtE = new DateField();
		new DateFieldMask(searchAqtnDtE, "9999.99.99");
		searchAqtnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchAqtnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchAqtnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
//		cp02.setSize(956, 338);
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0118GridPanel = new MSFGridPanel(psnl0600ToPsnl0118Def, false, false, false, false, false);
		psnl0600ToPsnl0118GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0118GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0118GridPanel.setBorders(true);
	    
	    cp02.add(psnl0600ToPsnl0118GridPanel); 

		
//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("aqtnDt");
//		column.setHeaderText("취득일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("qftntLicnsCd");
//		column.setHeaderText("자격면허코드");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("qftntLicnsPovncCtnt", "자격면허분야", 200);
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("efmnIstutNm");
//		column.setHeaderText("시행기관");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("qftntLicnsNum");
//		column.setHeaderText("자격면허번호");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0118Grid = new Grid<Psnl0600DTO>(storePsnl0118, cm);
//		psnl0118Grid.setSelectionModel(sm);
//		psnl0118Grid.setBorders(true);
//		psnl0118Grid.setColumnReordering(true);
//		psnl0118Grid.addPlugin(sm);
//		psnl0118Grid.setStateful(true);
//		psnl0118Grid.setLoadMask(true);
//
//		cp02.add(psnl0118Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	

	// TODO 교육 시작
	private LayoutContainer PersonalTemp04() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(968, 463);
		cp01.setSize(968, 500);
		cp01.setLayout(new FitLayout());

		

		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		
		
		searchEduKndNm = new TextField<String>();
		searchEduKndNm.setFieldLabel("교육종류");
		layoutContainer_3.add(searchEduKndNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchEduBgnnDtS = new DateField();
		new DateFieldMask(searchEduBgnnDtS, "9999.99.99");
		searchEduBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchEduBgnnDtS.setFieldLabel("교육시작기간");
		layoutContainer_9.add(searchEduBgnnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchEduBgnnDtE = new DateField();
		new DateFieldMask(searchEduBgnnDtE, "9999.99.99");
		searchEduBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchEduBgnnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchEduBgnnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0120GridPanel = new MSFGridPanel(psnl0600ToPsnl0120Def, false, false, false, false, false);
		psnl0600ToPsnl0120GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0120GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0120GridPanel.setBorders(true);
	    
		cp02.add(psnl0600ToPsnl0120GridPanel); 

		

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("eduBgnnDt");
//		column.setHeaderText("교육시작일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("eduEndDt");
//		column.setHeaderText("교육종료일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("eduCmpteTm", "이수시간", 120);
//		column.setAlignment(HorizontalAlignment.RIGHT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("eduKndNm");
//		column.setHeaderText("교육종류");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("eduIstutNm");
//		column.setHeaderText("교육기관");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("eduNoteCtnt");
//		column.setHeaderText("비 고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0120Grid = new Grid<Psnl0600DTO>(storePsnl0120, cm);
//		psnl0120Grid.setSelectionModel(sm);
//		psnl0120Grid.setBorders(true);
//		psnl0120Grid.setColumnReordering(true);
//		psnl0120Grid.addPlugin(sm);
//		psnl0120Grid.setStateful(true);
//		psnl0120Grid.setLoadMask(true);
//
//		cp02.add(psnl0120Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	// TODO 포상 시작
	private LayoutContainer PersonalTemp05() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(968, 463);
		cp01.setSize(968, 500);
		cp01.setLayout(new FitLayout());


		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
		cp02.setSize(956, 485);
		
		psnl0600ToPsnl0121GridPanel = new MSFGridPanel(psnl0600ToPsnl0121Def, false, false, false, false, false);
		psnl0600ToPsnl0121GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0121GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0121GridPanel.setBorders(true);
	    
	    cp02.add(psnl0600ToPsnl0121GridPanel); 

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("accldYr");
//		column.setHeaderText("포상년도");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(60);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("accldPrttDt");
//		column.setHeaderText("포상일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("accldKndCd");
//		column.setHeaderText("포상종류");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("accldDivCd");
//		column.setHeaderText("포상구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("accldNm", "포상명", 150);
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("accldCfmntNum", "포상서훈번호", 100);
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("efmnIstutNm");
//		column.setHeaderText("시행기관");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("accldMnantCtnt");
//		column.setHeaderText("포상주체");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("accldNoteCtnt");
//		column.setHeaderText("비 고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0121Grid = new Grid<Psnl0600DTO>(storePsnl0121, cm);
//		psnl0121Grid.setSelectionModel(sm);
//		psnl0121Grid.setBorders(true);
//		psnl0121Grid.setColumnReordering(true);
//		psnl0121Grid.addPlugin(sm);
//		psnl0121Grid.setStateful(true);
//		psnl0121Grid.setLoadMask(true);
//
//		cp02.add(psnl0121Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	// TODO 징계시작
	private LayoutContainer PersonalTemp06() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(968, 463);
		cp01.setSize(968, 500);
		cp01.setLayout(new FitLayout());


		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		
		
		searchDsnyActDivCd = new ComboBox<BaseModel>();
		searchDsnyActDivCd.setFieldLabel("징계구분");
		searchDsnyActDivCd.setForceSelection(true);
		searchDsnyActDivCd.setMinChars(1);
		searchDsnyActDivCd.setDisplayField("commCdNm");
		searchDsnyActDivCd.setValueField("commCd");
		searchDsnyActDivCd.setTriggerAction(TriggerAction.ALL);
		searchDsnyActDivCd.setEmptyText("--징계구분선택--");
		searchDsnyActDivCd.setSelectOnFocus(true);
		searchDsnyActDivCd.setStore(listStoreA011);
		
		layoutContainer_3.add(searchDsnyActDivCd, new FormData("100%"));

		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		searchDsnyActDsplDtS = new DateField();
		new DateFieldMask(searchDsnyActDsplDtS, "9999.99.99");
		searchDsnyActDsplDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsnyActDsplDtS.setFieldLabel("징계처분일");
		layoutContainer_9.add(searchDsnyActDsplDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchDsnyActDsplDtE = new DateField();
		new DateFieldMask(searchDsnyActDsplDtE, "9999.99.99");
		searchDsnyActDsplDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsnyActDsplDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchDsnyActDsplDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0122GridPanel = new MSFGridPanel(psnl0600ToPsnl0122Def, false, false, false, false, false);
		psnl0600ToPsnl0122GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0122GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0122GridPanel.setBorders(true);
	    
	    cp02.add(psnl0600ToPsnl0122GridPanel); 
		
		

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActDsplDt");
//		column.setHeaderText("징계처분일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActDivCd");
//		column.setHeaderText("징계구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("dsnyActNm", "징계명", 150);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActReasCtnt");
//		column.setHeaderText("징계사유");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(200);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActEctgOrgn");
//		column.setHeaderText("시행기관");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActBgnnDt");
//		column.setHeaderText("징계시작");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActEndDt");
//		column.setHeaderText("징계종료일");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActAnstyDt");
//		column.setHeaderText("징계사면일");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActAnstyDivCd");
//		column.setHeaderText("사면구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("symbol");
//		column.setHeaderText("감봉월수");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dsnyActNoteCtnt");
//		column.setHeaderText("비 고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		psnl0122Grid = new Grid<Psnl0600DTO>(storePsnl0122, cm);
//		psnl0122Grid.setSelectionModel(sm);
//		psnl0122Grid.setBorders(true);
//		psnl0122Grid.setColumnReordering(true);
//		psnl0122Grid.addPlugin(sm);
//		psnl0122Grid.setStateful(true);
//		psnl0122Grid.setLoadMask(true);
//
//		cp02.add(psnl0122Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	// TODO 휴직관리 시작
	private LayoutContainer PersonalTemp07() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(968, 463);
		cp01.setSize(968, 500);
		cp01.setLayout(new FitLayout());

		

		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		
		searchLevfAbncDivCd = new ComboBox<BaseModel>();
		searchLevfAbncDivCd.setFieldLabel("휴직구분");
		searchLevfAbncDivCd.setForceSelection(true);
		searchLevfAbncDivCd.setMinChars(1);
		searchLevfAbncDivCd.setDisplayField("commCdNm");
		searchLevfAbncDivCd.setValueField("commCd");
		searchLevfAbncDivCd.setTriggerAction(TriggerAction.ALL);
		searchLevfAbncDivCd.setEmptyText("--휴직구분선택--");
		searchLevfAbncDivCd.setSelectOnFocus(true);
		searchLevfAbncDivCd.setStore(listStoreB014);
		
		layoutContainer_3.add(searchLevfAbncDivCd, new FormData("100%"));

		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		searchLevfAbncBgnnDtS = new DateField();
		new DateFieldMask(searchLevfAbncBgnnDtS, "9999.99.99");
		searchLevfAbncBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchLevfAbncBgnnDtS.setFieldLabel("휴직기간");
		layoutContainer_9.add(searchLevfAbncBgnnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchLevfAbncBgnnDtE = new DateField();
		new DateFieldMask(searchLevfAbncBgnnDtE, "9999.99.99");
		searchLevfAbncBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchLevfAbncBgnnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchLevfAbncBgnnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		ContentPanel cp02 = new ContentPanel();
		cp02.setBodyBorder(false);
		cp02.setHeaderVisible(false);
		cp02.setLayout(new FitLayout());
//		cp02.setSize(956, 338);
		cp02.setSize(956, 445);
		
		psnl0600ToPsnl0123GridPanel = new MSFGridPanel(psnl0600ToPsnl0123Def, false, false, false, false, false);
		psnl0600ToPsnl0123GridPanel.setHeaderVisible(false);  
		psnl0600ToPsnl0123GridPanel.setBodyBorder(true);
		psnl0600ToPsnl0123GridPanel.setBorders(true);
	    
		cp02.add(psnl0600ToPsnl0123GridPanel); 

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		//final CheckBoxSelectionModel<Psnl0600DTO> sm = new CheckBoxSelectionModel<Psnl0600DTO>();
//
//		//configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("currDeptNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("deptNm");
//		column.setHeaderText("관리부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("typeOccuNm");
//		column.setHeaderText("직 종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("dtilOccuInttnNm");
////		column.setId("dtilOccuClsDivNm");
//		column.setHeaderText("직종세구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성 명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("hdofcCodtnNm");
//		column.setHeaderText("재직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("levfAbncDivCd");
//		column.setHeaderText("휴직구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("levfAbncBgnnDt");
//		column.setHeaderText("시작일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("levfAbncEndDt", "종료일자", 100);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig("turtyRntmntDt", "복직일자", 100);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("levfAbncNoteCtnt");
//		column.setHeaderText("비 고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(300);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//
//		ColumnModel cm = new ColumnModel(configs);
//
//
//		psnl0123Grid = new Grid<Psnl0600DTO>(storePsnl0123, cm);
//		//psnl0123Grid.setSelectionModel(sm);
//		psnl0123Grid.setBorders(true);
//		psnl0123Grid.setColumnReordering(true);
//		//psnl0123Grid.addPlugin(sm);
//		psnl0123Grid.setStateful(true);
//		psnl0123Grid.setLoadMask(true);
//
//
//		cp02.add(psnl0123Grid);

		layoutContainer_1.add(cp02);

		lcTabCol02.add(layoutContainer_1, new FormData("100%"));
		layoutContainer_1.setBorders(false);

		cp01.add(lcTabCol02);

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;

	}

	private void createTabForm() {

		tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
		/*
		tabsPsnl.addListener(Events.Select, new Listener<TabPanelEvent>() {
			@Override
			public void handleEvent(TabPanelEvent be) {
				if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){
					loaderPsnl0600.load();
				}else if("itemPsnl0112".equals(tabsPsnl.getSelectedItem().getId())){
					loaderPsnl0112.load();
				}else if("itemPsnl0114".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0116".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0119".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0118".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0120".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0121".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0122".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0123".equals(tabsPsnl.getSelectedItem().getId())){
					
				}
			}
			
		});
		*/
		
		// tabsPsnl.setMinTabWidth(80);
		tabsPsnl.setAutoWidth(false);
		// tabsPsnl.setResizeTabs(true);
		tabsPsnl.setAnimScroll(true);
		tabsPsnl.setTabScroll(true);
		tabsPsnl.setPlain(true);
		tabsPsnl.setSize(970, 520);

		TabItem itemPsnl0600 = new TabItem();
//		itemPsnl0600.setStyleAttribute("padding", "10px");
		itemPsnl0600.setText(" 기 본 ");
		itemPsnl0600.addStyleName("pad-text");
		itemPsnl0600.setLayout(new FormLayout());
		itemPsnl0600.setId("itemPsnl0600");
		itemPsnl0600.add(StdData01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0600);

		// TabItem item01 = new TabItem();
		// item01.setStyleAttribute("padding", "10px");
		// item01.setText(" 인&nbsp;적 ");
		// item01.addStyleName("pad-text");
		// item01.setLayout(new FormLayout());
		//
		// item01.add(PersonalData01(), new FormData("100%"));
		// tabsPsnl.add(item01);

		// TabItem item021 = new TabItem();
		// item021.setStyleAttribute("padding", "10px");
		// item021.setText(" 고 용 ");
		// item021.setLayout(new FormLayout());
		// item021.add(Employment01(), new FormData("100%"));
		// tabsPsnl.add(item021);

		TabItem itemPsnl0112 = new TabItem();
//		itemPsnl0112.setStyleAttribute("padding", "10px");
		itemPsnl0112.setText(" 병 역 ");
		itemPsnl0112.setLayout(new FormLayout());
		itemPsnl0112.setId("itemPsnl0112");
		itemPsnl0112.add(PersonalMilitary01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0112);

		// TabItem item03 = new TabItem();
		// item03.setStyleAttribute("padding", "10px");
		// item03.setText(" 신 상 ");
		// item03.setLayout(new FormLayout());
		// item03.add(PersonalData02(), new FormData("100%"));
		//
		// tabsPsnl.add(item03);

		TabItem itemPsnl0114 = new TabItem();
//		itemPsnl0114.setStyleAttribute("padding", "10px");
		itemPsnl0114.setText(" 단 체 ");
		itemPsnl0114.setId("itemPsnl0114");
		itemPsnl0114.setLayout(new FormLayout());
		itemPsnl0114.add(PersonalGroup01(), new FormData("100%"));

		tabsPsnl.add(itemPsnl0114);

		// TabItem item05 = new TabItem();
		// item05.setStyleAttribute("padding", "10px");
		// item05.setText(" 가 족 ");
		// item05.setLayout(new FormLayout());
		// item05.add(PersonalFamily01(), new FormData("100%"));
		//
		// tabsPsnl.add(item05);

		TabItem itemPsnl0116 = new TabItem();
//		itemPsnl0116.setStyleAttribute("padding", "10px");
		itemPsnl0116.setText(" 학 력 ");
		itemPsnl0116.setId("itemPsnl0116");
		itemPsnl0116.setLayout(new FormLayout());
		itemPsnl0116.add(PersonalAcademicAbility01(), new FormData("100%"));

		tabsPsnl.add(itemPsnl0116);

		TabItem itemPsnl0119 = new TabItem();
//		itemPsnl0119.setStyleAttribute("padding", "10px");
		itemPsnl0119.setText(" 경 력 ");
		itemPsnl0119.setId("itemPsnl0119");
		itemPsnl0119.setLayout(new FormLayout());
		itemPsnl0119.add(PersonalTemp01(), new FormData("100%"));

		tabsPsnl.add(itemPsnl0119);

		TabItem itemPsnl0118 = new TabItem();
//		itemPsnl0118.setStyleAttribute("padding", "10px");
		itemPsnl0118.setText(" 자 격 ");
		itemPsnl0118.setId("itemPsnl0118");
		itemPsnl0118.setLayout(new FormLayout());
		itemPsnl0118.add(PersonalTemp02(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0118);


		TabItem itemPsnl0120 = new TabItem();
//		itemPsnl0120.setStyleAttribute("padding", "10px");
		itemPsnl0120.setText(" 교 육 ");
		itemPsnl0120.setId("itemPsnl0120");
		itemPsnl0120.setLayout(new FormLayout());
		itemPsnl0120.add(PersonalTemp04(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0120);

		TabItem itemPsnl0121 = new TabItem();
//		itemPsnl0121.setStyleAttribute("padding", "10px");
		itemPsnl0121.setText(" 포 상 ");
		itemPsnl0121.setId("itemPsnl0121");
		itemPsnl0121.setLayout(new FormLayout());
		itemPsnl0121.add(PersonalTemp05(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0121);

		TabItem itemPsnl0122 = new TabItem();
//		itemPsnl0122.setStyleAttribute("padding", "10px");
		itemPsnl0122.setText(" 징 계 ");
		itemPsnl0122.setId("itemPsnl0122");
		itemPsnl0122.setLayout(new FormLayout());
		itemPsnl0122.add(PersonalTemp06(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0122);

		TabItem itemPsnl0123 = new TabItem();
//		itemPsnl0123.setStyleAttribute("padding", "10px");
		itemPsnl0123.setText(" 휴 직 ");
		itemPsnl0123.setId("itemPsnl0123");
		itemPsnl0123.setLayout(new FormLayout());
		itemPsnl0123.add(PersonalTemp07(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0123);

		plFrmPsnl0600.add(tabsPsnl, new FormData("100%"));
	}

	// TODO 검색필드 설정
	private void createSearchForm() {
		
		
		
		plFrmPsnl0600.setLayout(new FlowLayout());
		
		sysComBass0320Dto = new PrgmComBass0320DTO();
		listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		
//		List<String> arrRpsttvCd = new ArrayList<String>();
////		arrRpsttvCd.add("A002"); //고용구분
//		arrRpsttvCd.add("A003"); //재직구분
//		//arrRpsttvCd.add("A041"); //직종
//		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
//		sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
//		
//		//재직상태  
//		 sysComBass0300Dto.setRpsttvCd("A003");
//		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
//                mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
//                srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
//            }
//		 });   
		   

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytSch);

//		searchDeptCd = new ComboBox<BaseModel>();
//		searchDeptCd.setFieldLabel("관리부서");
//		searchDeptCd.setForceSelection(true);
//		searchDeptCd.setMinChars(1);
//		searchDeptCd.setDisplayField("deptNmRtchnt");
//		searchDeptCd.setValueField("mangeDeptCd");
//		searchDeptCd.setTriggerAction(TriggerAction.ALL);
//		searchDeptCd.setEmptyText("--관리부서선택--");
//		searchDeptCd.setSelectOnFocus(true);
//		searchDeptCd.setStore(PrgmComComboUtils.getMangDeptBass0400ComboData(null));
//		
//		searchDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
//
//			@Override
//			public void handleEvent(BaseEvent be) {
//				if(searchDeptCd.getValue() != null){
//					PrgmComBass0400DTO sysComBass0400Dto = new PrgmComBass0400DTO();
//					sysComBass0400Dto.setMangeDeptCd(searchDeptCd.getValue().get("mangeDeptCd")+"");
//					searchCurrDeptCd.getStore().removeAll();
//					
//					
//					sysComBass0400Service.getPrgmComDeptBass0400List(sysComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
//						
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							searchCurrDeptCd.setStore(ls);
//							searchCurrDeptCd.setEmptyText("--부서선택--");
//							searchCurrDeptCd.setValue(new BaseModel());
//						}
//						@Override
//						public void onFailure(Throwable caught) {
//							caught.printStackTrace();
//						}
//					});
//				}else{
//					searchCurrDeptCd.setStore(new ListStore<BaseModel>());
//					searchCurrDeptCd.setEmptyText("--관리부서선택--");
//					searchCurrDeptCd.setValue(new BaseModel());
//				}
//				
//				
//			}
//		
//		});
		
		 //검색 부서 코드 처리  
		LayoutContainer lccmlcDeptNm = new LayoutContainer();
        lccmlcDeptNm.setLayout(new ColumnLayout());
        //부서 
        srhDeptCd = new TextField<String>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setVisible(false);
//        srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());//TODO 확인 
//        srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd()); 
        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//            @Override
//            public void handleEvent(BaseEvent be) { 
//            	if(srhDeptCd.getValue() != null){
//            		if (Constants.EMYMT_DIVCD02.equals(searchEmymtDivCd.getValue().get("commCd"))) {
//            			PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//            			dto.setDeptCd(srhDeptCd.getValue()); 
//                  
//            			//--------------------사업 불러 오는 함수 -------------------------------------------------
//            			lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//            			//--------------------사업 불러 오는 함수 -------------------------------------------------
//            			srhBusinCd.setStore(lsBusinCd); 
//            			srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//            				public void handleEvent(StoreEvent<BaseModel> be) {  
//                             // searchYearBusinCd.setValue(lsBusinCd.getAt(0));  
//            				}
//            			});    
//            		}	
//              	} 
//            }
//        });
        	@Override
        	public void handleEvent(BaseEvent be) { 
        		if(srhDeptCd.getValue() != null){
        			
        				if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
        					
        					PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
        					dto.setBusinApptnYr("");  
        					dto.setDeptCd(srhDeptCd.getValue()); 
        					//--------------------사업 불러 오는 함수 -------------------------------------------------
        					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
        					//--------------------사업 불러 오는 함수 -------------------------------------------------
        					srhBusinCd.setStore(lsBusinCd); 
        					
        					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        						public void handleEvent(StoreEvent<BaseModel> be) {  
		        				//searchYearBusinCd.setValue(lsBusinCd.getAt(0));  
        						}
        					});    
        				} else  if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
   	            		     					
        					//2015.11.30 권한 직종가져오기  추가 
   	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
   	            		   sysComBass0320Dto.setDeptCd(srhDeptCd.getValue());
   	            	       listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   	            	       srhTypOccuCd.setStore(listStoreA041);
   	            	   } else {
   	            		     
   	            	   } 
        		} 
        	}
        });
        
        
        plFrmPsnl0600.add(srhDeptCd);
        
        srhMangeDeptCd = new TextField<String>();
        srhMangeDeptCd.setName("srhMangeDeptCd");
        srhMangeDeptCd.setVisible(false);
        plFrmPsnl0600.add(srhMangeDeptCd);
        srhMangeDeptNm = new TextField<String>();
        srhMangeDeptNm.setName("srhMangeDeptNm");
        srhMangeDeptNm.setVisible(false);
        plFrmPsnl0600.add(srhMangeDeptNm);
  
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
        		 if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
        			 srhDeptCd.setValue("");
        			 srhMangeDeptCd.setValue("");
        		 }
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			//if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
        				srhDeptCd.setValue("");
        				srhMangeDeptCd.setValue("");
        			//}
        			fnPopupCommP140(srhDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
         
//         srhDeptNm.addListener(Events.Add, new Listener<BaseEvent>() {
//        	 @Override
//        	 public void handleEvent(BaseEvent be) { 
//        		 if(srhDeptNm.getValue() != null){
//        			 if (Constants.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
//        				 PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//        				 dto.setBusinApptnYr("");  
//        				 dto.setDeptCd(srhDeptCd.getValue()); 
//                    
//          				//--------------------사업 불러 오는 함수 -------------------------------------------------
//          				lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//          				//--------------------사업 불러 오는 함수 -------------------------------------------------
//          				srhBusinCd.setStore(lsBusinCd); 
//          				srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//          					public void handleEvent(StoreEvent<BaseModel> be) {  
//                             //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//          					}
//          				});    
//        			 }
//        		 } 
//        	 }
//         });
         
//         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//        	 @Override
//        	 public void handleEvent(BaseEvent be) { 
//        		 if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
//        			 srhDeptCd.setValue("");
//        			 srhMangeDeptCd.setValue("");
//        		 }
//                     
//        	 } 
//         });  
         
       
         
         lcDeptNm.add(srhDeptNm, new FormData("100%"));  
          
         btnSrhDeptCd = new Button();
         btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
         btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
         btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	 public void handleEvent(ButtonEvent e) { 
        		 //if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
        			 srhDeptCd.setValue("");
        			 srhMangeDeptCd.setValue("");
        		 //}
        		 fnPopupCommP140(srhDeptNm.getValue()); 
        	 }
         });
            
         lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
         lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
           
         layoutContainer.add(lccmlcDeptNm, new FormData("100%"));
         lcSchCol.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
         layoutContainer.setBorders(false);

         LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
         
         
         LayoutContainer layoutContainer_1_1 = new LayoutContainer();
         
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(70);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         layoutContainer_1_1.setLayout(frmlytSch);
		 
		
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
         searchEmymtDivCd.setStore(listStoreA002);
         searchEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
         searchEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
         listStoreA002.addStoreListener( new StoreListener<BaseModel>() {   
        	 public void handleEvent(StoreEvent<BaseModel> be) {  
        		 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPsnl0600Auth("searchEmymtDivCd", listStoreA002); 
              	 }
        	 }
         });
        
         searchEmymtDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
        	 @Override
        	 public void handleEvent(BaseEvent be) {
        		 String emymt = searchEmymtDivCd.getValue() == null ? "" : String.valueOf(searchEmymtDivCd.getValue().get("commCd")) ;
 				
        		 if(MSFConfiguration.EMYMT_DIVCD01.equals(emymt)){ //공무직일 경우
        			//20151130 추가 수정 
        			 srhDeptCd.fireEvent(Events.Add); 
        			 srhBusinCd.reset();
                     srhBusinCd.setEnabled(false);   
                     if (gwtExtAuth.getEnableTypOccuCd()) {
                    	 srhTypOccuCd.setEnabled(true);
                      	 srhDtilOccuInttnCd.setEnabled(true); 
                     } else {
                    	 srhTypOccuCd.setEnabled(false);
                     	 srhDtilOccuInttnCd.setEnabled(false);
                     }
        			 
        			 /*
        			 srhBusinCd.setValue(new BaseModel());
   					 srhTypOccuCd.setValue(new BaseModel());
   					 srhBusinCd.setEnabled(false); 
   					 srhDeptCd.fireEvent(Events.Add); 
   					 
   	                 if (gwtExtAuth.getEnableTypOccuCd()) { 
   	                	 srhTypOccuCd.setEnabled(true);
   	                    // srhDtilOccuInttnCd.setEnabled(true); 
   	                 } else { 
   	                	 srhTypOccuCd.setEnabled(false);
   	                    // srhDtilOccuInttnCd.setEnabled(false);
   	                 }
   	                 */
   					
   				}else if(MSFConfiguration.EMYMT_DIVCD02.equals(emymt)){ //기간제 계약직일 경우
   					srhDeptCd.fireEvent(Events.Add); 
   					srhBusinCd.setEnabled(true);
   					srhTypOccuCd.reset();
        			srhTypOccuCd.setEnabled(false);
        			srhDtilOccuInttnCd.reset();
        			srhDtilOccuInttnCd.setEnabled(false);
   					
   					/*
   					srhDeptCd.fireEvent(Events.Add); 
   					srhBusinCd.setValue(new BaseModel());
   					srhTypOccuCd.setValue(new BaseModel());
   					srhBusinCd.setEnabled(true);
   					srhTypOccuCd.setEnabled(false);
   					*/
   				} 
        			
        	 }
         });

         layoutContainer_1_1.add(searchEmymtDivCd, new FormData("100%"));
         layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
         
         
         LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		// lcSchCol.add(layoutContainer_101);
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1_2.setLayout(frmlytSch);

		srhRepbtyBusinDivCd = new ComboBox<BaseModel>();
		srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		srhRepbtyBusinDivCd.setForceSelection(true);
		srhRepbtyBusinDivCd.setAllowBlank(false);
		srhRepbtyBusinDivCd.setMinChars(1);
		srhRepbtyBusinDivCd.setDisplayField("commCdNm");
		srhRepbtyBusinDivCd.setValueField("commCd");
		srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
		srhRepbtyBusinDivCd.setHideLabel(true);
		srhRepbtyBusinDivCd.setSelectOnFocus(true);
		srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
		srhRepbtyBusinDivCd.setLabelSeparator("");
		// srhRepbtyBusinDivCd.setFieldLabel("고용구분");
		lsRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		    
		layoutContainer_1_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
		layoutContainer_1_2.setBorders(false);
		layoutContainer_1.add(layoutContainer_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
         
         
         lcSchCol.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
         layoutContainer_1.setBorders(false);

         LayoutContainer layoutContainer_2 = new LayoutContainer();
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(70);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         layoutContainer_2.setLayout(frmlytSch);
		

         srhBusinCd = new ComboBox<BaseModel>();
         srhBusinCd.setFieldLabel("사업명");
         srhBusinCd.setForceSelection(true);
       	 srhBusinCd.setMinChars(1);
       	 srhBusinCd.setDisplayField("businNm");
         srhBusinCd.setValueField("businCd");
         srhBusinCd.setTriggerAction(TriggerAction.ALL);
         srhBusinCd.setEmptyText("--사업선택--");
         srhBusinCd.setSelectOnFocus(true);
         srhBusinCd.setName("srhBusinCd");
         srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
         srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
         srhBusinCd.setStore(new ListStore<BaseModel>());
         
         layoutContainer_2.add(srhBusinCd, new FormData("100%"));
         
         lcSchCol.add(layoutContainer_2,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
         layoutContainer_2.setBorders(false);

         LayoutContainer layoutContainer_3 = new LayoutContainer();
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(70);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         layoutContainer_3.setLayout(frmlytSch);

//         searchHdofcCodtnCd = new ComboBox<BaseModel>();
//         searchHdofcCodtnCd.setFieldLabel("재직구분");
//         searchHdofcCodtnCd.setForceSelection(true);
//		 searchHdofcCodtnCd.setMinChars(1);
//		 searchHdofcCodtnCd.setDisplayField("commCdNm");
//		 searchHdofcCodtnCd.setValueField("commCd");
//		 searchHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
//		 searchHdofcCodtnCd.setEmptyText("--재직구분선택--");
//		 searchHdofcCodtnCd.setSelectOnFocus(true);
//		 searchHdofcCodtnCd.setStore(listStoreA003);   
//		
//		 layoutContainer_3.add(searchHdofcCodtnCd, new FormData("100%"));
		 
         srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
         srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
         srhHdofcCodtnCd.setEmptyText("--재직선택--");
         srhHdofcCodtnCd.setReadOnly(true);
         srhHdofcCodtnCd.setEnabled(true); 
         srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
         srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
         srhHdofcCodtnCd.setFieldLabel("재직");
         srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
             public void handleEvent(StoreEvent<ModelData> be) {  
//                 srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//                 srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
             }
         }); 
         srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
             @Override
             public void handleEvent(ComponentEvent ce) {   
                 if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                     mutilCombo = true;
                 } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                     mutilCombo = true;
                 } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                     mutilCombo = false;
                 }  
             } 
         });
         layoutContainer_3.add(srhHdofcCodtnCd, new FormData("100%"));
		 
		 
		 
		 lcSchCol.add(layoutContainer_3,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		 layoutContainer_3.setBorders(false);

		 FieldSet fieldSet = new FieldSet();
		 fieldSet.setHeadingHtml("검색조건");
		 /****************************************************************
		  * 검색조건 배경 변경 스타일시트 추가 시작
		  ****************************************************************/
		 	fieldSet.addStyleName("x-fieldset-serarch-back-color");
		 /****************************************************************
		  * 검색조건 배경 변경 스타일시트 추가 끝
		  ****************************************************************/		 

		 fieldSet.add(lcSchCol, new FormData("100%"));

		 LayoutContainer layoutContainer_4 = new LayoutContainer();
		 layoutContainer_4.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_5 = new LayoutContainer();
		 layoutContainer_5.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_9 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_9.setLayout(frmlytSch);

		 searchNowDeptDateS = new DateField();
		 new DateFieldMask(searchNowDeptDateS, "9999.99.99");
		 searchNowDeptDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 layoutContainer_9.add(searchNowDeptDateS, new FormData("100%"));
		 searchNowDeptDateS.setFieldLabel("현부서일");
		 layoutContainer_5.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 layoutContainer_9.setBorders(false);

		 LayoutContainer layoutContainer_10 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(10);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_10.setLayout(frmlytSch);

		 searchNowDeptDateE = new DateField();
		 new DateFieldMask(searchNowDeptDateE, "9999.99.99");
		 searchNowDeptDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchNowDeptDateE.setLabelSeparator("~");
		 layoutContainer_10.add(searchNowDeptDateE, new FormData("100%"));
		 layoutContainer_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		 layoutContainer_10.setBorders(false);
		 layoutContainer_4.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		 layoutContainer_5.setBorders(false);

		 LayoutContainer layoutContainer_6 = new LayoutContainer();
		 layoutContainer_6.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_8 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_8.setLayout(frmlytSch);
 
		 searchFrstWorkDateS = new DateField();
		 new DateFieldMask(searchFrstWorkDateS, "9999.99.99");
		 searchFrstWorkDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchFrstWorkDateS.setFieldLabel("최초고용일");
		 layoutContainer_8.add(searchFrstWorkDateS, new FormData("100%"));
		 layoutContainer_6.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 layoutContainer_8.setBorders(false);

		 LayoutContainer layoutContainer_11 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(10);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_11.setLayout(frmlytSch);

		 searchFrstWorkDateE = new DateField();
		 new DateFieldMask(searchFrstWorkDateE, "9999.99.99");
		 searchFrstWorkDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchFrstWorkDateE.setLabelSeparator("~");
		 layoutContainer_11.add(searchFrstWorkDateE, new FormData("100%"));
		 layoutContainer_11.setBorders(false);
		 layoutContainer_6.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		 layoutContainer_6.setBorders(false);
		 layoutContainer_4.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		 LayoutContainer layoutContainer_7 = new LayoutContainer();
		 layoutContainer_7.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_12 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_12.setLayout(frmlytSch);

//		searchBirthDateS = new DateField();
//		searchBirthDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		searchBirthDateS.setFieldLabel("생년월일");
//		layoutContainer_12.add(searchBirthDateS, new FormData("100%"));
		
		 searchWorkYearS = new ComboBox<BaseModel>();
		 searchWorkYearS.setFieldLabel("근속년수");
		 searchWorkYearS.setForceSelection(true);
		 searchWorkYearS.setMinChars(1);
		 searchWorkYearS.setDisplayField("commCdNm");
		 searchWorkYearS.setValueField("commCd");
		 searchWorkYearS.setTriggerAction(TriggerAction.ALL);
		 searchWorkYearS.setEmptyText("--근속년수--");
		 searchWorkYearS.setSelectOnFocus(true);
		 searchWorkYearS.setStore(listStoreA007);
		
		 layoutContainer_12.add(searchWorkYearS, new FormData("100%"));
		
		 layoutContainer_7.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 layoutContainer_12.setBorders(false);

		 LayoutContainer layoutContainer_13 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(10);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_13.setLayout(frmlytSch);

//		searchBirthDateE = new DateField();
//		searchBirthDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		searchBirthDateE.setLabelSeparator("~");
//		layoutContainer_13.add(searchBirthDateE, new FormData("100%"));
		
		 searchWorkYearE = new ComboBox<BaseModel>();
		 searchWorkYearE.setLabelSeparator("~");
		 searchWorkYearE.setForceSelection(true);
		 searchWorkYearE.setMinChars(1);
		 searchWorkYearE.setDisplayField("commCdNm");
		 searchWorkYearE.setValueField("commCd");
		 searchWorkYearE.setTriggerAction(TriggerAction.ALL);
		 searchWorkYearE.setEmptyText("--근속년수--");
		 searchWorkYearE.setSelectOnFocus(true);
		 searchWorkYearE.setStore(listStoreA007);
		
		 layoutContainer_13.add(searchWorkYearE, new FormData("100%"));
		
		 layoutContainer_7.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		 layoutContainer_13.setBorders(false);
		 layoutContainer_4.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		 layoutContainer_7.setBorders(false);

		 LayoutContainer layoutContainer_14 = new LayoutContainer();
		 layoutContainer_14.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_17 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_17.setLayout(frmlytSch);
  
//		searchWorkYearS = new ComboBox<BaseModel>();
//		searchWorkYearS.setFieldLabel("근속년수");
//		searchWorkYearS.setForceSelection(true);
//		searchWorkYearS.setMinChars(1);
//		searchWorkYearS.setDisplayField("commCdNm");
//		searchWorkYearS.setValueField("commCd");
//		searchWorkYearS.setTriggerAction(TriggerAction.ALL);
//		searchWorkYearS.setEmptyText("--근속년수--");
//		searchWorkYearS.setSelectOnFocus(true);
//		searchWorkYearS.setStore(listStoreA007);
//		
//		layoutContainer_17.add(searchWorkYearS, new FormData("100%"));
		
		 searchBirthDateS = new DateField();
		 new DateFieldMask(searchBirthDateS, "9999.99.99");
		 searchBirthDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchBirthDateS.setFieldLabel("생년월일");
		 layoutContainer_17.add(searchBirthDateS, new FormData("100%"));
		
	     layoutContainer_14.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	    
	     LayoutContainer layoutContainer_18 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(10); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	     layoutContainer_18.setLayout(frmlytSch);
	     layoutContainer_18.setBorders(false);
	     
//	    searchWorkYearE = new ComboBox<BaseModel>();
//		searchWorkYearE.setLabelSeparator("~");
//		searchWorkYearE.setForceSelection(true);
//		searchWorkYearE.setMinChars(1);
//		searchWorkYearE.setDisplayField("commCdNm");
//		searchWorkYearE.setValueField("commCd");
//		searchWorkYearE.setTriggerAction(TriggerAction.ALL);
//		searchWorkYearE.setEmptyText("--근속년수--");
//		searchWorkYearE.setSelectOnFocus(true);
//		searchWorkYearE.setStore(listStoreA007);
//		
//	    layoutContainer_18.add(searchWorkYearE, new FormData("100%"));
	    
	     searchBirthDateE = new DateField();
	     new DateFieldMask(searchBirthDateE, "9999.99.99");
		 searchBirthDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchBirthDateE.setLabelSeparator("~");
		 layoutContainer_18.add(searchBirthDateE, new FormData("100%"));
	    
	     layoutContainer_14.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	    
	     layoutContainer_4.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	    
	     LayoutContainer layoutContainer_15 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(70); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_15.setLayout(frmlytSch);
	    
	     searchSexType = new ComboBox<BaseModel>();
         searchSexType.setFieldLabel("성 별");
         searchSexType.setForceSelection(true);
         searchSexType.setMinChars(1);
         searchSexType.setDisplayField("commCdNm");
         searchSexType.setValueField("commCd");
         searchSexType.setTriggerAction(TriggerAction.ALL);
         searchSexType.setEmptyText("--성별 선택--");
         searchSexType.setSelectOnFocus(true);
         searchSexType.setStore(listStoreA004);   
	  
	     layoutContainer_15.add(searchSexType, new FormData("100%"));
	     layoutContainer_4.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	     layoutContainer_15.setBorders(false);
	    
	     LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());
	     
	     
	     LayoutContainer layoutContainer_16_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_1.setLayout(frmlytSch);

		srhDeptGpCd = new ComboBox<BaseModel>();
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
	     
		layoutContainer_16_1.add(srhDeptGpCd, new FormData("100%"));	     
		layoutContainer_16.add(layoutContainer_16_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    
		
		
	     LayoutContainer layoutContainer_16_2 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_2.setLayout(frmlytSch);
	    
	     srhTypOccuCd = new ComboBox<BaseModel>();
//	     srhTypOccuCd.setFieldLabel("직 종");
//	     srhTypOccuCd.setLabelSeparator("");
	     srhTypOccuCd.setHideLabel(true);
	     srhTypOccuCd.setForceSelection(true);
	     srhTypOccuCd.setMinChars(1);
	     srhTypOccuCd.setDisplayField("typOccuNm");
	     srhTypOccuCd.setValueField("typOccuCd");
	     srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
	     srhTypOccuCd.setEmptyText("--직종선택--");
	     srhTypOccuCd.setSelectOnFocus(true);
	     srhTypOccuCd.setStore(listStoreA041);
	     srhTypOccuCd.setName("srhTypOccuCd");
	     srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	     srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	     srhTypOccuCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	    	 public void handleEvent(StoreEvent<BaseModel> be) { 
	    		 //2015.11.30 추가 
	    		  if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
	    		 if (!gwtExtAuth.getEnableTypOccuCd()) {
	    			 BaseModel  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
//		            	if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//		            		for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//		            			ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//		            			if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//		            				mdSelect = tpMdSelect;
//		            			} 
//		                	}  
		                   
		    			   srhTypOccuCd.setValue(mdSelect);
		                   // }  
	    		 }  
	    		 }
             }
         }); 
	     srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	 public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	             
	            	//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
	    		    sysComBass0350Dto = new PrgmComBass0350DTO();
	    		    
//	            	sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	            	sysComBass0350Dto.setDeptCd(srhDeptCd.getValue()); 
	                sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")); 
	                
//	    			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	    			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
//	    			
//	    			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
//	                sysComBass0350Dto.setDeptCd(strDeptCd);
//	                
//	                List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
//	                String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
//	                sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
	                    
	                // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	                    
	                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                	
	                	//직종세 초기화
	                	srhDtilOccuInttnCd.getInitStore(); 
	                	srhDtilOccuInttnCd.setValue("");
	                	
	                	lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	                	//  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
	                        
	                	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
	                		public void handleEvent(StoreEvent<BaseModel> be) {  
	                			mDtalistDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
	            } 
	        });	     
//		layoutContainer_16.add(srhTypOccuCd, new FormData("100%"));
	     layoutContainer_16_2.add(srhTypOccuCd, new FormData("100%"));	     
	     layoutContainer_16.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		layoutContainer_4.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_16.setBorders(false);

		
		
		LayoutContainer layoutContainer_20 = new LayoutContainer();
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytSch);
	    
	     
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.setHideLabel(true);
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
//		srhDtilOccuInttnCd.setLabelSeparator("");
		srhDtilOccuInttnCd.setWidth(100);
		// srhDtilOccuInttnCd.setHideLabel(true);
//		srhDtilOccuInttnCd.setFieldLabel("직종세");
		srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,
				new Listener<ComponentEvent>() {
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
	  
	     layoutContainer_20.add(srhDtilOccuInttnCd, new FormData("100%"));
	    
	     layoutContainer_4.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	    
	     fieldSet.add(layoutContainer_4);
	     
	     
	     
		LayoutContainer layoutContainer_77 = new LayoutContainer(new ColumnLayout());
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSch1_2.setLayout(frmlytSch);
	     
		LayoutContainer lcSch1_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_1.setLayout(frmlytSch);
		
		
		srhDateType = new ComboBox<BaseModel>();
		srhDateType.setName("srhDateType");
		srhDateType.setForceSelection(true);
		srhDateType.setMinChars(1);
		srhDateType.setDisplayField("commCdNm");
		srhDateType.setAllowBlank(false);
		srhDateType.setValueField("commCd");
		srhDateType.setTriggerAction(TriggerAction.ALL);
		srhDateType.setEmptyText("-- 기간 선택 --");
		srhDateType.setSelectOnFocus(true); 
		srhDateType.setFieldLabel("고용기간"); 
		srhDateType.setStore(lsDateType);
		srhDateType.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// TODO Auto-generated method stub
				// 기간 선택에 따라 날짜를 보여준다.
				
				if("S0010010".equals(MSFSharedUtils.getSelectedComboValue(srhDateType, "commCd"))) {		// 기간별
					
					lcSch1_2_3.hide();
					lcSch1_2_2.hide();
					lcSch1_2_1.show();
					
					setInitDate();	// 기간 셋팅
					
					
				}else if("S0010020".equals(MSFSharedUtils.getSelectedComboValue(srhDateType, "commCd"))) {	// 분기별
					
					lcSch1_2_3.hide();
					lcSch1_2_2.show();
					lcSch1_2_1.hide();
					
				}else if("S0010030".equals(MSFSharedUtils.getSelectedComboValue(srhDateType, "commCd"))) {	// 월별
					
					lcSch1_2_1.hide();
					lcSch1_2_3.show();
					lcSch1_2_2.hide();
					
					
				}else {
					
					lcSch1_2_3.hide();
					lcSch1_2_2.hide();
					lcSch1_2_1.show();
					
				}
			}
	    });
		srhDateType.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
//				SttsUtils.setSelectedComboValue(srhDateType, "S0010010", "commCd");
//				srhDateType.setValue(lsDateType.getAt(0));
			}
		});
		lcSch1_1.add(srhDateType, new FormData("100%"));
		
//		private LayoutContainer lcSch1_2_1 = new LayoutContainer(new ColumnLayout());	// 기간별
		layoutContainer_77.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		
		
		
		/****** 기간 *******/	    
		LayoutContainer lcSch1_2 = new LayoutContainer();
		FormLayout frmlytSch1_2 = new FormLayout();
//		frmlytSch1_2.setLabelWidth(60);
//		frmlytSch1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_2.setLayout(frmlytSch1_2);
		
		// 기간별
		lcSch1_2_1 = new LayoutContainer(new ColumnLayout());
//		FormLayout fl1_2_1  = new FormLayout();
//		lcSch1_2_1.setLayout(fl1_2_1);
		
		LayoutContainer lcSch1_2_1_S = new LayoutContainer();
    	FormLayout fl2_1 = new FormLayout();
      	fl2_1.setLabelWidth(40);
      	fl2_1.setLabelAlign(LabelAlign.RIGHT);
      	lcSch1_2_1_S.setLayout(fl2_1);
             
     	srhDayS = new DateField();
     	srhDayS.setName("srhDayS");
        new DateFieldMask(srhDayS, "9999.99.99"); 
        srhDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayS.setFieldLabel("기간");
        lcSch1_2_1_S.add(srhDayS, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_1_E = new LayoutContainer();
        FormLayout fl2_2 = new FormLayout();
        fl2_2.setLabelWidth(5);
        fl2_2.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_1_E.setLayout(fl2_2);
        
            
        srhDayE = new DateField();
        srhDayE.setName("srhDayE");
        new DateFieldMask(srhDayE, "9999.99.99"); 
        srhDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayE.setLabelSeparator("~");
//        srhDayE.setReadOnly(true);
//        srhDayE.setEnabled(true);
        lcSch1_2_1_E.add(srhDayE, new FormData("100%"));
            
        lcSch1_2_1.add(lcSch1_2_1_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
        lcSch1_2_1.add(lcSch1_2_1_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
        
//        lcSch1_2_1.show();
        lcSch1_2.add(lcSch1_2_1);
        
        
        
		// 분기별
        lcSch1_2_2 = new LayoutContainer(new ColumnLayout());
//        FormLayout fl1_2_2  = new FormLayout();
//        lcSch1_2_2.setLayout(fl1_2_2);
		
		LayoutContainer lcSch1_2_2_Y = new LayoutContainer();
    	FormLayout fl1_2_2_Y  = new FormLayout();
    	fl1_2_2_Y.setLabelWidth(40);
    	fl1_2_2_Y.setLabelAlign(LabelAlign.RIGHT);
    	lcSch1_2_2_Y.setLayout(fl1_2_2_Y);
             
    	srhYr02 = new ComboBox<BaseModel>();
    	srhYr02.setName("srhYr02");
    	srhYr02.setForceSelection(true);
    	srhYr02.setMinChars(1);
    	srhYr02.setDisplayField("yearDisp");
    	srhYr02.setValueField("year");
    	srhYr02.setTriggerAction(TriggerAction.ALL);
    	srhYr02.setEmptyText("-- 년도선택 --");
    	srhYr02.setSelectOnFocus(true); 
    	srhYr02.setStore(lsYrStore);  
    	srhYr02.setFieldLabel("년도");
    	srhYr02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
//					srhYr02.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
				}
			}
    	});
		lcSch1_2_2_Y.add(srhYr02, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_2_M_S = new LayoutContainer();
        FormLayout fl1_2_2_M_S = new FormLayout();
        fl1_2_2_M_S.setLabelWidth(30);
        fl1_2_2_M_S.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_2_M_S.setLayout(fl1_2_2_M_S);
        
        srhMnthS = new ComboBox<BaseModel>();
        srhMnthS.setName("srhMnthS");
        srhMnthS.setForceSelection(true);
        srhMnthS.setMinChars(1);
        srhMnthS.setDisplayField("monthDisp");
        srhMnthS.setValueField("month");
        srhMnthS.setTriggerAction(TriggerAction.ALL);
        srhMnthS.setEmptyText("-- 년도선택 --");
        srhMnthS.setSelectOnFocus(true); 
        srhMnthS.setStore(lsMonthStore);  
        srhMnthS.setFieldLabel("월");
        srhMnthS.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
//					srhMnthS.setValue(lsMonthStore.findModel("month", DateTimeFormat.getFormat("MM").format(new Date()))); 	
				}
			}
    	});
        srhMnthS.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		// 시작월에 따라 마감월 변경
        		String strMon_S = MSFSharedUtils.getSelectedComboValue(srhMnthS, "month");
        		
        		// 1분기 시작월, 마감월 고정
        		if ("01".equals(strMon_S) || "02".equals(strMon_S) || "03".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "01"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "03"));
        			
        			month.setValue("02");
        			
        		// 2분기 시작월, 마감월 고정	
        		} else  if ("04".equals(strMon_S) || "05".equals(strMon_S) || "06".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "04"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "06"));
        			
        			month.setValue("05");
        			
        		// 3분기 시작월, 마감월 고정		
        		}  else  if ("07".equals(strMon_S) || "08".equals(strMon_S) || "09".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "07"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "09"));
        			
        			month.setValue("08");
        			
        		// 4분기 시작월, 마감월 고정			
        		} else  if ("10".equals(strMon_S) || "11".equals(strMon_S) || "12".equals(strMon_S)) {
         			
         			srhMnthS.setValue(lsMonthStore.findModel("month", "10"));
         			srhMnthE.setValue(lsMonthStore.findModel("month", "12"));
         			
         			month.setValue("11");
         			
         		} 
        		
        	} 
        });
    	lcSch1_2_2_M_S.add(srhMnthS, new FormData("100%"));
    	
    	
      	LayoutContainer lcSch1_2_2_M_E = new LayoutContainer();
        FormLayout fl1_2_2_M_E = new FormLayout();
        fl1_2_2_M_E.setLabelWidth(5);
        fl1_2_2_M_E.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_2_M_E.setLayout(fl1_2_2_M_E);
        
        srhMnthE = new ComboBox<BaseModel>();
        srhMnthE.setName("srhMnthE");
        srhMnthE.setForceSelection(true);
        srhMnthE.setMinChars(1);
        srhMnthE.setDisplayField("monthDisp");
        srhMnthE.setValueField("month");
    	srhMnthE.setTriggerAction(TriggerAction.ALL);
//    	srhMnthE.setEmptyText("-- 년도선택 --");
    	srhMnthE.setSelectOnFocus(true); 
    	srhMnthE.setStore(lsMonthStore);  
    	srhMnthE.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		// 시작월에 따라 마감월 변경
        		String strMon_E = MSFSharedUtils.getSelectedComboValue(srhMnthE, "month");
        		
        		// 1분기 시작월, 마감월 고정
        		if ("01".equals(strMon_E) || "02".equals(strMon_E) || "03".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "01"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "03"));
        			
        		// 2분기 시작월, 마감월 고정	
        		} else  if ("04".equals(strMon_E) || "05".equals(strMon_E) || "06".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "04"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "06"));
        			
        		// 3분기 시작월, 마감월 고정		
        		}  else  if ("07".equals(strMon_E) || "08".equals(strMon_E) || "09".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "07"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "09"));
        			
        		// 4분기 시작월, 마감월 고정			
        		} else  if ("10".equals(strMon_E) || "11".equals(strMon_E) || "12".equals(strMon_E)) {
         			
         			srhMnthS.setValue(lsMonthStore.findModel("month", "10"));
         			srhMnthE.setValue(lsMonthStore.findModel("month", "12"));
         			
         		} 
        		
        	} 
        });
    	srhMnthE.setLabelSeparator("~");
    	lcSch1_2_2_M_E.add(srhMnthE, new FormData("100%"));
            
        lcSch1_2_2.add(lcSch1_2_2_Y, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        lcSch1_2_2.add(lcSch1_2_2_M_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
        lcSch1_2_2.add(lcSch1_2_2_M_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
        
        lcSch1_2.add(lcSch1_2_2);
        
        
    	// 월별
        lcSch1_2_3 = new LayoutContainer(new ColumnLayout());
//        FormLayout fl1_2_3  = new FormLayout();
//        lcSch1_2_3.setLayout(fl1_2_3);
		
		LayoutContainer lcSch1_2_3_S = new LayoutContainer();
    	FormLayout fl1_2_3_S  = new FormLayout();
    	fl1_2_3_S.setLabelWidth(40);
    	fl1_2_3_S.setLabelAlign(LabelAlign.RIGHT);
      	lcSch1_2_3_S.setLayout(fl1_2_3_S);
             
    	srhYr01 = new ComboBox<BaseModel>();
    	srhYr01.setName("srhYr");
    	srhYr01.setForceSelection(true);
    	srhYr01.setMinChars(1);
    	srhYr01.setDisplayField("yearDisp");
    	srhYr01.setValueField("year");
    	srhYr01.setTriggerAction(TriggerAction.ALL);
    	srhYr01.setEmptyText("-- 년도선택 --");
    	srhYr01.setSelectOnFocus(true); 
    	srhYr01.setStore(lsYrStore);  
    	srhYr01.setFieldLabel("년도");
    	srhYr01.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {    
        		EventType type = be.getType();
        		if (type == Store.Add) { 
//        			 srhYr01.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
        		}
        	}
        });
        lcSch1_2_3_S.add(srhYr01, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_3_E = new LayoutContainer();
        FormLayout fl1_2_3_E = new FormLayout();
        fl1_2_3_E.setLabelWidth(30);
        fl1_2_3_E.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_3_E.setLayout(fl1_2_3_E);
        
    	srhMnth = new ComboBox<BaseModel>();
    	srhMnth.setName("srhMnth");
    	srhMnth.setForceSelection(true);
    	srhMnth.setMinChars(1);
    	srhMnth.setDisplayField("monthDisp");
    	srhMnth.setValueField("month");
    	srhMnth.setTriggerAction(TriggerAction.ALL);
    	srhMnth.setEmptyText("-- 년도선택 --");
    	srhMnth.setSelectOnFocus(true); 
    	srhMnth.setStore(lsMonthStore);  
    	srhMnth.setFieldLabel("월");
    	srhMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {    
        		EventType type = be.getType();
        		if (type == Store.Add) { 
//        			 srhMnth.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
        		}
        	}
        });
        lcSch1_2_3_E.add(srhMnth, new FormData("100%"));
            
        lcSch1_2_3.add(lcSch1_2_3_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        lcSch1_2_3.add(lcSch1_2_3_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
        lcSch1_2.add(lcSch1_2_3);
        layoutContainer_77.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		fieldSet.add(layoutContainer_77);
	     
		
	     plFrmPsnl0600.add(fieldSet);
		// vp.add(panel);
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
	private void Psnl0600Print(String fileName, String repType) {
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    }	
	
	
	//rda
	private void RdaPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		strDirPath = "PSNL";
		
		// mrd 출력물
		rdaFileName = fileName+".mrd";
		
		// 보낼 파라미터
		strParam = "/rp ";
		searchParam = "";
		
//		//권한 설정으로 인해 추가된 부분 
//        String strSrhPayrMangDeptCd = MSFSharedUtils.allowNulls(payrMangDeptCd.getValue());
//        String deptCdAuth = MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(srhDeptCd.getValue()).replace(",", "")); 
//        String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
//		
//        /******************* 기본 검색조건 시작 *******************/
//		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
//		DateTimeFormat dateBirthFormat = DateTimeFormat.getFormat("yyMMdd");
//		
//		
//		String strSrhDpobCd = MSFMainApp.get().getUser().getDpobCd();	//사업장코드
////		String strSrhPayrMangDeptCd =  MSFSharedUtils.allowNulls(payrMangDeptCd.getValue());	//단위기관
//		String strSrhDeptCd = MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue());				//관리부서
//		String strSrhCurrDeptCd = MSFSharedUtils.allowNulls(srhDeptCd.getValue());				//소속부서
//		String strSrhEmymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd");//고용구분
//		String strSrhBusinCd = srhBusinCd.getValue() == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd");
//		String strSrhHdofcCodtnCd = PersonalUtil.getPrintStrToMultiData(lsHdofcCodtnCd, srhHdofcCodtnCd.getValue(), "commCdNm", "commCd");//재직구분
//		
//		String strSrhNowDeptDateS = searchNowDeptDateS.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateS.getValue());	//현부서일_시작
//		String strSrhNowDeptDateE = searchNowDeptDateE.getValue() == null ? "" : dateTimeFormat.format(searchNowDeptDateE.getValue());	//현부서일_종료
//		String strSrhFrstWorkDateS = searchFrstWorkDateS.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateS.getValue());//최초고용일_시작
//		String strSrhFrstWorkDateE = searchFrstWorkDateE.getValue() == null ? "" : dateTimeFormat.format(searchFrstWorkDateE.getValue());//최초고요일_종료
//		String strSrhWorkYearS = PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01");//근속년수_시작
//		String strSrhWorkYearE = PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01");//근속년수_종료
//		
//		String strSrhBirthDateS = searchBirthDateS.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateS.getValue());//생년월일_시작
//		String strSrhBirthDateE = searchBirthDateE.getValue() == null ? "" : dateBirthFormat.format(searchBirthDateE.getValue());//생년월일_종료
//		String strSrhSexType = PersonalUtil.getSelectedComboValue(searchSexType,"commCd");		//성별
//		String strSrhTypOccuCd = PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd");	//직종
//		String strSrhDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");//직종세 
//		
//		searchParam +=  "[" + strSrhDpobCd + "]";			//$1 사업장코드
//		searchParam +=  "[" + strSrhPayrMangDeptCd + "]";	//$2 단위기관
//		searchParam +=  "[" + strSrhEmymtDivCd + "]";		//$3 고용구분
//		searchParam +=  "[" + strSrhHdofcCodtnCd + "]";		//$4 재직구분
//		searchParam +=  "[" + strSrhTypOccuCd + "]";		//$5 직종
//		searchParam +=  "[" + strSrhDtilOccuInttnCd + "]";	//$6 직종세
//		searchParam +=  "[" + strSrhBusinCd + "]";			//$7 사업
//		
//		//20151212-추가 시작 
//	    if (strSrhPayrMangDeptCd.equals(deptCdAuth)) { 
//	    	searchParam += "[]"; //$8 부서
//        } else {
//        	searchParam += "["+ strSrhCurrDeptCd+"]"; //$8 부서
//        }  
//	 	//20151212-추가 끝
//	    
//	    searchParam +=  "[" + strSrhNowDeptDateS + "]";	//$9 현부서일_시작
//	    searchParam +=  "[" + strSrhNowDeptDateE + "]";	//$10 현부서일_종료
//	    searchParam +=  "[" + strSrhFrstWorkDateS + "]";//$11 최초고용일_시작
//	    searchParam +=  "[" + strSrhFrstWorkDateE + "]";//$12 최초고요일_종료
//	    searchParam +=  "[" + strSrhWorkYearS + "]";	//$13 근속년수_시작
//	    searchParam +=  "[" + strSrhWorkYearE + "]";	//$14 근속년수_종료
//	    searchParam +=  "[" + strSrhBirthDateS + "]";	//$15 생년월일_시작
//	    searchParam +=  "[" + strSrhBirthDateE + "]";	//$16 생년월일_종료
//	    searchParam +=  "[" + strSrhSexType + "]";		//$17 성별
//	    
//	    //20151212-추가 시작 
//	    searchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  			//$18 유저ID
//	    searchParam += "[" + MSFMainApp.get().getUser().getPayrMangDeptYn() + "]"; 	//$19 단위기관 여부
//		  
//		//권한처리를위해 넘기는 변수 2개추가 
//	    searchParam += "[" + deptCdAuth + "]"; 			//$20 부서 권한
//	    searchParam += "[" + dtilOccuInttnCdAuth + "]"; //$21 직종세 권한
//		/******************* 기본 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 병역 검색조건 시작 *******************/
//	    String strSrhDsageDivCd = PersonalUtil.getSelectedComboValue(searchDsageDivCd,"commCd");//제대구분
//	    String strSrhDsageDtS = searchDsageDtS.getValue() == null ? "" : dateTimeFormat.format(searchDsageDtS.getValue());//제대기간 시작일
//	    String strSrhDsageDtE = searchDsageDtE.getValue() == null ? "" : dateTimeFormat.format(searchDsageDtE.getValue());//제대기간 종료일
//	    String strSrhBaggrpCd = PersonalUtil.getSelectedComboValue(searchBaggrpCd,"commCd");//군별
//	    String strSrhAbotsCd =  PersonalUtil.getSelectedComboValue(searchAbotsCd,"commCd");	//병과
//	    String strSrhClsCd = PersonalUtil.getSelectedComboValue(searchClsCd,"commCd");		//계급
//	    /******************* 병역 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 단체 검색조건 시작 *******************/
//	    String strSrhJnOpztnNm =  searchJnOpztnNm.getValue() == null ? "" : searchJnOpztnNm.getValue();			//단체명
//	    String strSrhJnDtS = searchJnDtS.getValue() == null ? "" : dateTimeFormat.format(searchJnDtS.getValue());//가입기간 시작일
//	    String strSrhJnDtE = searchJnDtE.getValue() == null ? "" : dateTimeFormat.format(searchJnDtE.getValue());//가입기간 종료일
//	    /******************* 단체 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 학력 검색조건 시작 *******************/
//	    String strSrhAcadAbtyDivCd = PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd");		//학력구분
//	    String strSrhDegrDivCd = PersonalUtil.getSelectedComboValue(searchDegrDivCd,"commCd");				//학위
//	    String strSrhDeprMajrCd = searchDeprMajrCd.getValue() == null ? "" : searchDeprMajrCd.getValue();	//학과
//	    String strSrhSchlCd = searchSchlCd.getValue() == null ? "" : searchSchlCd.getValue();				//학교명
//	    /******************* 학력 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 경력 검색조건 시작 *******************/
//	    String strSrhPaeWorkNm = searchPaeWorkNm.getValue() == null ? "" : searchPaeWorkNm.getValue();//근무처명
//	    String strSrhCarrBgnnDtS = searchCarrBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchCarrBgnnDtS.getValue());//근무시작일 시작일
//	    String strSrhCarrBgnnDtE = searchCarrBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchCarrBgnnDtE.getValue());//근무시작일 종료일
//	    /******************* 경력 검색조건 종료 *******************/
//	    
//
//	    /******************* 자격 검색조건 시작 *******************/
//	    String strSrhQftntLicnsNum = searchQftntLicnsNum.getValue() == null ? "" : searchQftntLicnsNum.getValue();		//자격면허
//	    String strSrhAqtnDtS = searchAqtnDtS.getValue() == null ? "" : dateTimeFormat.format(searchAqtnDtS.getValue());	//취득일자 시작일
//	    String strSrhAqtnDtE = searchAqtnDtE.getValue() == null ? "" : dateTimeFormat.format(searchAqtnDtE.getValue());	//취득일자 종료일
//	    /******************* 자격 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 교육 검색조건 시작 *******************/
//	    String strSrhEduKndNm = searchEduKndNm.getValue() == null ? "" : searchEduKndNm.getValue();//교육종류
//	    String strSrhEduBgnnDtS = searchEduBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchEduBgnnDtS.getValue());//교육종류 시작일
//	    String strSrhEduBgnnDtE = searchEduBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchEduBgnnDtE.getValue());//교육종류 종료일
//	    /******************* 교육 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 포상 검색조건 시작 *******************/
//	    //기본조건만 사용
//	    /******************* 포상 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 징계 검색조건 시작 *******************/
//	    //기본조건만 사용
//	    /******************* 징계 검색조건 종료 *******************/
//	    
//	    
//	    /******************* 휴직 검색조건 시작 *******************/
//	    String strSrhLevfAbncDivCd = PersonalUtil.getSelectedComboValue(searchLevfAbncDivCd,"commCd");//휴직구분
//	    String strSrhLevfAbncBgnnDtS = searchLevfAbncBgnnDtS.getValue() == null ? "" : dateTimeFormat.format(searchLevfAbncBgnnDtS.getValue());//휴직일 시작일
//	    String strSrhLevfAbncBgnnDtE = searchLevfAbncBgnnDtE.getValue() == null ? "" : dateTimeFormat.format(searchLevfAbncBgnnDtE.getValue());//휴직일 종료일
//	    /******************* 휴직 검색조건 종료 *******************/
		
		
		
		
		String checkedSystemKeys = "";
		
		int keyCnt = 0;
		int iCnt = 0;
		
		//탭정보
		if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){ //기본
			//기본, 인적, 신상, 가족, 발령
//			List<Psnl0600DTO> checkList  = psnl0600Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
			
//			searchParam += "[" + checkedSystemKeys + "]"; //$22 시스템키
			searchParam += "[" + "]"; //$22 시스템키
			
		}else if("PSNLT0274".equals(fileName)){ //병역
			
//			List<Psnl0600DTO> checkList  = psnl0112Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0112GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
			
//			searchParam += "[" + checkedSystemKeys + "]";//$22 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
//			
//		    searchParam += "[" + strSrhDsageDivCd + "]";//$23 제대구분
//		    searchParam += "[" + strSrhDsageDtS + "]";	//$24 제대기간 시작일
//		    searchParam += "[" + strSrhDsageDtE + "]";	//$25 제대기간 종료일
//		    searchParam += "[" + strSrhBaggrpCd + "]";	//$26 군별
//		    searchParam += "[" + strSrhAbotsCd + "]";	//$27 병과
//		    searchParam += "[" + strSrhClsCd + "]";		//$28 계급
			
		}else if("PSNLT0275".equals(fileName)){ //학력
			
//			List<Psnl0600DTO> checkList  = psnl0116Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0116GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
			
//			searchParam += "[" + checkedSystemKeys + "]";	//$22 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
//			
//			searchParam += "[" + strSrhAcadAbtyDivCd + "]";	//$23 학력구분
//			searchParam += "[" + strSrhDegrDivCd + "]";			//$24 학위
//			searchParam += "[" + strSrhDeprMajrCd + "]";		//$25 학과
//			searchParam += "[" + strSrhSchlCd + "]";				//$26 학교명
			
		}else if("PSNLT0281".equals(fileName)){ //경력
			
//			List<Psnl0600DTO> checkList  = psnl0119Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0119GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
//			searchParam += "[" + checkedSystemKeys + "]";	//$22 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
//			
//			searchParam += "[" + strSrhPaeWorkNm + "]";		//$23 근무처명
//			searchParam += "[" + strSrhCarrBgnnDtS + "]";	//$24 근무시작일 종료일
//			searchParam += "[" + strSrhCarrBgnnDtE + "]";	//$25 근무시작일 종료일
			
		}else if("PSNLT0277".equals(fileName)){ //자격
			
//			List<Psnl0600DTO> checkList  = psnl0118Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0118GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
//			searchParam += "[" + checkedSystemKeys + "]";	//$22 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
//			
//			searchParam += "[" + strSrhQftntLicnsNum + "]";	//$23 자격면허
//			searchParam += "[" + strSrhAqtnDtS + "]";		//$24 취득일자 시작일
//			searchParam += "[" + strSrhAqtnDtE + "]";		//$25 취득일자 종료일
			
		}else if("PSNLT0278".equals(fileName)){ //교육
			
//			List<Psnl0600DTO> checkList  = psnl0120Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0120GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
//			searchParam += "[" + checkedSystemKeys + "]";	//$22 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
//			
//			searchParam += "[" + strSrhEduKndNm + "]";		//$23 교육종류
//			searchParam += "[" + strSrhEduBgnnDtS + "]";	//$24 교육종류 시작일
//			searchParam += "[" + strSrhEduBgnnDtE + "]";	//$25 교육종류 종료일
			
		}else if("PSNLT0276".equals(fileName)){ //포상
			
//			List<Psnl0600DTO> checkList  = psnl0121Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0121GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
//			searchParam += "[" + checkedSystemKeys + "]";	//$22 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
			
		}else if("PSNLT0279".equals(fileName)){ //징계
			
//			List<Psnl0600DTO> checkList  = psnl0122Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//						keyCnt += 1;
//					}
//				}
//			}
			
			List<BaseModel> list = psnl0600ToPsnl0122GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				iCnt = 0;
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
					iCnt = iCnt + 1;
				}
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
//			searchParam += "[" + checkedSystemKeys + "]";	//$25 시스템키
//			searchParam += "[" + "]"; //$22 시스템키
			
		}
		checkedSystemKeys = checkedSystemKeys.length() > 0 ? checkedSystemKeys.substring(1, checkedSystemKeys.length()) : "";
		
		
		if("".equals(checkedSystemKeys)){
			MessageBox.info("", "인쇄 하실 내용을 체크하여 주세요.", null);
			return;
		}else{
			
			if(iCnt > 200) {
				MessageBox.info("", "200건 이상은 선택할 수 없습니다.</BR>대상자를 다시 선택해주세요", null);
				return;
			}
			
			strParam = "["+checkedSystemKeys+"]";
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rdaFileName, strParam);
		}
		
		
//		if("".equals(checkedSystemKeys)){
//			MessageBox.info("", "인쇄 하실 내용을 체크하여 주세요.", null);
//			return;
//		}else{
//			
//			if(iCnt > 200) {
//				MessageBox.confirm("출력", "200건 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
//					@Override
//					public void handleEvent(MessageBoxEvent be) {
//						// TODO Auto-generated method stub
//						
//						if("No".equals(be.getButtonClicked().getText())){
//							MessageBox.info("", "대상자를 다시 선택해주세요..", null);
//							return;
//						}else {
//							
//							//GWT 타입으로 팝업 호출시  postCall true 설정
//							PrintUtils.setPostCall(true);
//							PrintUtils.rexPrint(strDirPath, rdaFileName, strParam);
//							
//						}
//					}
//				});
//			}else {
//				strParam = "["+checkedSystemKeys+"]";
//				
//				//GWT 타입으로 팝업 호출시  postCall true 설정
//				PrintUtils.setPostCall(true);
//				PrintUtils.rexPrint(strDirPath, rdaFileName, strParam);
//			}
//		}
		
		
//        if(checkedSystemKeys == null || checkedSystemKeys.length() <= 0 || checkedSystemKeys == ""){
//        	
//        	MessageBox.info("알림", "출력대상자정보를 선택해주세요.", null);
//        	
//      		return;
//      		
//        }else {
//        	if(keyCnt >= 200) {
//        		
//        		MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
//    				@Override
//    				public void handleEvent(MessageBoxEvent be) {
//    					// TODO Auto-generated method stub
//    					if("Yes".equals(be.getButtonClicked().getText())){
//    						
//    						strParam = strParam + searchParam;
////    						System.out.println("============================");
////    						System.out.println("==	경로 : " + strDirPath);
////    						System.out.println("==	파일명 : " + rdaFileName);
////    						System.out.println("==	파라미터 : " + strParam);
////    						System.out.println("============================");
//    					
//    						//GWT 타입으로 팝업 호출시  postCall true 설정
//    						PrintUtils.setPostCall(true);
//    						PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//    					}else {
//    						return;
//    					}
//    				}
//    			});
//        	}else {
//        		strParam += checkedSystemKeys;
//				
//				//GWT 타입으로 팝업 호출시  postCall true 설정
//				PrintUtils.setPostCall(true);
//				PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//        	}
//        }
		
//		if(keyCnt += 1;)
		
		
		
		
//		if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){ //기본
//			List<Psnl0600DTO> checkList  = psnl0600Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0274".equals(fileName)){ //병역
//			
//			List<Psnl0600DTO> checkList  = psnl0112Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0275".equals(fileName)){ //학력
//			
//			List<Psnl0600DTO> checkList  = psnl0116Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0281".equals(fileName)){ //경력
//			
//			List<Psnl0600DTO> checkList  = psnl0119Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0277".equals(fileName)){ //자격
//			
//			List<Psnl0600DTO> checkList  = psnl0118Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0278".equals(fileName)){ //교육
//			
//			List<Psnl0600DTO> checkList  = psnl0120Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0276".equals(fileName)){ //포상
//			
//			List<Psnl0600DTO> checkList  = psnl0121Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}else if("PSNLT0279".equals(fileName)){ //징계
//			
//			List<Psnl0600DTO> checkList  = psnl0122Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
//		}
//		
//		checkedSystemKeys = checkedSystemKeys.length() > 0 ? checkedSystemKeys.substring(1, checkedSystemKeys.length()) : "";
		
		
		
		
//		if("".equals(checkedSystemKeys)){
//			MessageBox.info("", "인쇄 하실 내용을 체크하여 주세요.", null);
//			return;
//		}
//		else{
//			strParam += "["+checkedSystemKeys+"]";
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//			
//		}
	}
	
	//rex 
	private void RexPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
		strDirPath = "PSNL";
		
		// reb 출력물
//		rexFileName = fileName+".reb";
		rexFileName = fileName+".crf";
		
		// 보낼 파라미터  
		
        // 검색조건
		strParam = new String();
//     	strParam = "";
//     	searchParam = "";
     	String checkedSystemKeys = "";
		
     	int iCnt = 0;
     	
     	
//		//권한 설정으로 인해 추가된 부분 
//        String payrMangDeptCdStr = "";
//        String deptCdAuth = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); 
//        String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "");     	
// 
//        
//     	//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
//		if(deptCdAuth == null || "".equals(deptCdAuth) ) {
//			payrMangDeptCdStr = "";
//			deptCdAuth = "";	
//		}else {
//			deptCdAuth = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); 
//			payrMangDeptCdStr = payrMangDeptCd.getValue();
//		}
//        
//        
//		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
//		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
//			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
//			String chkkey = "";
//			for (int i = 0; i < ray.length; i++) {
//				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
//				chkkey += bmData.get("commCd") + ",";
//			}
//			strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
//		}
//        
//        
//     	// 기본 검색조건
//        strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd() ) + "⊥";									// $1 사업장코드
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd") ) + "⊥";		// $2 고용구분
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ) + "⊥";			// $3 직종
//        strParam += "" + PersonalUtil.getPrintStrToMultiData(lsDtilOccuInttnCd, MSFSharedUtils.allowNulls(
//        											srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") + "⊥";		// $4 직종세
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")) + "⊥";				// $5 사업
//        strParam += "" + MSFSharedUtils.allowNulls( strHdofcCodtnCd ) + "⊥";														// $6 재직
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchNowDeptDateS, "yyyymmdd") ) + "⊥";	// $7 현부서일
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchNowDeptDateE, "yyyymmdd") ) + "⊥";	// $8 현부서일
//        
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchFrstWorkDateS, "yyyymmdd") ) + "⊥";	// $9 최초고용일
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchFrstWorkDateE, "yyyymmdd") ) + "⊥";	// $10 최초고용일
//        
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchWorkYearS,"mangeItem01") ) + "⊥";	// $11 근속년수
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchWorkYearE,"mangeItem01") ) + "⊥";	// $12 근속년수
//        
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchBirthDateS, "yyyymmdd") ) + "⊥";	// $13 생년월일
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchBirthDateE, "yyyymmdd") ) + "⊥";	// $14 생년월일
//        
//        strParam += "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchSexType,"commCd") )  + "⊥";			// $15 성별    
//        
//		//20151212-변경추가 시작 
//        strParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥"; 					 											// $16 유저아이디 
//        strParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn() + "⊥"; 														// $17
//		  
//		//권한처리를위해 넘기는 변수 2개추가 
//        strParam += "" + deptCdAuth + "⊥"; 																							// $18 부서 
//        strParam += "" + dtilOccuInttnCdAuth + "⊥"; 																				// $19 직종세 
//		//20151212-추가 끝 
//        
//        strParam += "" + deptCdAuth + "⊥"; 																							// $20 부서 
//        strParam += "" + payrMangDeptCdStr + "⊥"; 																					// $21 단위기관 
        
        
     	//if("PSNLT0270".equals(fileName)){ //기본
     	if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){ //기본
//			List<Psnl0600DTO> checkList  = psnl0600Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
    		List<BaseModel> list = psnl0600GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			iCnt = 0;
    			String chkkey = "";
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
			
//			if("PSNLT0281".equals(fileName)) {
//				
//				strParam = "" + "⊥";		// $23 
//				strParam = "" + "⊥";		// $24 
//				strParam = "" + "⊥";		// $25 
//				
//			}
			
		}else if("PSNLT0274".equals(fileName)){ //병역
			
//			List<Psnl0600DTO> checkList  = psnl0112Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
			
    		List<BaseModel> list = psnl0600ToPsnl0112GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchDsageDivCd,"commCd") ) +"⊥";		// $23 제대구분
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchDsageDtS, "yyyymmdd") ) + "⊥";	// $24 제대기간
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchDsageDtE, "yyyymmdd") ) + "⊥";	// $25 제대기간
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchBaggrpCd,"commCd") ) + "⊥";		// $26 군별
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchAbotsCd,"commCd") ) + "⊥";		// $27 병과
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchClsCd,"commCd") ) + "⊥";			// $28 계급
			
		}
     	
		else if("PSNLT0275".equals(fileName)){ //학력
			
//			List<Psnl0600DTO> checkList  = psnl0116Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
    		List<BaseModel> list = psnl0600ToPsnl0116GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchAcadAbtyDivCd,"commCd") ) +"⊥";	// $23 학력구분
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchDegrDivCd,"commCd") ) +"⊥";		// $24 학위
//    		searchParam = "" + MSFSharedUtils.allowNulls( searchDeprMajrCd.getValue() ) +"⊥";											// $25 학과
//    		searchParam = "" + MSFSharedUtils.allowNulls( searchSchlCd.getValue() ) +"⊥";												// $26 학교명
			
			
			
		}else if("PSNLT0281".equals(fileName)){ //경력
			
//			List<Psnl0600DTO> checkList  = psnl0119Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
			
    		List<BaseModel> list = psnl0600ToPsnl0119GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
//			strParam = "" + MSFSharedUtils.allowNulls( searchPaeWorkNm.getValue() ) +"⊥";												// $23 근무처명
//			strParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchCarrBgnnDtS, "yyyymmdd") ) +"⊥";		// $24 근무시작일
//			strParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchCarrBgnnDtE, "yyyymmdd") ) +"⊥";		// $25 근무시작일
			
		}else if("PSNLT0277".equals(fileName)){ //자격
			
//			List<Psnl0600DTO> checkList  = psnl0118Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
			
    		List<BaseModel> list = psnl0600ToPsnl0118GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
//    		searchParam = "" + MSFSharedUtils.allowNulls( searchQftntLicnsPovncCtnt.getValue() ) +"⊥";									// $23 자격면허
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchAqtnDtS, "yyyymmdd") ) +"⊥";		// $24 취득일자
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchAqtnDtE, "yyyymmdd") ) +"⊥";		// $25 취득일자
			
    		
		}else if("PSNLT0278".equals(fileName)){ //교육
			
//			List<Psnl0600DTO> checkList  = psnl0120Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
			
    		List<BaseModel> list = psnl0600ToPsnl0120GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
//    		searchParam = "" + MSFSharedUtils.allowNulls( searchEduKndNm.getValue() ) +"⊥";												// $23 교육종류
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchEduBgnnDtS, "yyyymmdd") ) +"⊥";		// $24 교육기간
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchEduBgnnDtE, "yyyymmdd") ) +"⊥";		// $25 교육기간
			
		}else if("PSNLT0276".equals(fileName)){ //포상
			
//			List<Psnl0600DTO> checkList  = psnl0121Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
			
    		List<BaseModel> list = psnl0600ToPsnl0121GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
		}else if("PSNLT0279".equals(fileName)){ //징계
			
//			List<Psnl0600DTO> checkList  = psnl0122Grid.getSelectionModel().getSelectedItems();
//			if(checkList != null && checkList.size() > 0){
//				for(Psnl0600DTO dto : checkList){
//					if(checkedSystemKeys.indexOf(dto.getSystemkey()) < 0){
//						checkedSystemKeys += ",'"+dto.getSystemkey()+"'";
//					}
//				}
//			}
			
    		List<BaseModel> list = psnl0600ToPsnl0122GridPanel.getGrid().getSelectionModel().getSelectedItems();
    		if(list != null && list.size() > 0){
    			String chkkey = "";
    			iCnt = 0;
    			for(BaseModel bm : list){
    				chkkey += "'"+bm.get("systemkey")+"',";
    				iCnt = iCnt + 1;
    			}
    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
    		}
			
//			strParam = ""+checkedSystemKeys+"⊥";	// $22 시스템키
			
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(searchDsnyActDivCd,"commCd") ) +"⊥";			// $23 징계구분
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchDsnyActDsplDtS, "yyyymmdd") ) +"⊥";		// $24 징계처분일
//    		searchParam = "" + MSFSharedUtils.allowNulls( MSFSharedUtils.getConvertDateToString(searchDsnyActDsplDtE, "yyyymmdd") ) +"⊥";		// $25 징계처분일
			
		}	
//		checkedSystemKeys = checkedSystemKeys.length() > 0 ? checkedSystemKeys.substring(0, checkedSystemKeys.length()) : "";
     	
		if("".equals(checkedSystemKeys)){
			MessageBox.info("", "인쇄 하실 내용을 체크하여 주세요.", null);
			return;
		}else{
			
			if(iCnt > 200) {
				MessageBox.info("", "200건 이상은 선택할 수 없습니다.</BR>대상자를 다시 선택해주세요", null);
				return;
			}
//			else {
//				strParam = ""+checkedSystemKeys+"⊥";
//				
//				//GWT 타입으로 팝업 호출시  postCall true 설정
//				PrintUtils.setPostCall(true);
//				PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
//			}
			
			// TODO
			strParam = ""+checkedSystemKeys+"⊥";
			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
		}
		
		
//		if(iCnt > 200) {
//			
//			MessageBox.confirm("알림", "200건 이상은 전체출력 합니다. [YES] 버튼을 클릭하면 출력됩니다.",new Listener<MessageBoxEvent>(){
//				@Override
//				public void handleEvent(MessageBoxEvent be) {
//					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//						
//						
//						
//						strParam += "" + "⊥";		// $22 시스템키 없이 보냄
//						strParam += searchParam;
//						strParam += "" + strParam;
//						
//						Window.alert("strDirPath : " + strDirPath + " rexFileName : " + rexFileName +  " strParam : " + strParam);
//						
//						//GWT 타입으로 팝업 호출시  postCall true 설정
//						PrintUtils.setPostCall(true);
//						PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
//						
//					}else {
//						return;
//					}
//				}
//			});
//		}else {
//			
//			
//			strParam += "" + checkedSystemKeys + "⊥";
//			strParam += searchParam;
//			strParam += "" + strParam;
//			
//			Window.alert("strDirPath : " + strDirPath + " rexFileName : " + rexFileName +  " strParam : " + strParam);
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
//			
//		}
	}	
	
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	
	
	
	// 학교
	private void fnPopupBass0300(final String itemValue) {
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	       
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
//					if ("A001".equals(itemValue)) {
//						//국적
//						//코드값 및 버튼 텍스트 변경.
//            			searchSchlCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
//            			searchSchlCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
//					} else 
					if("A027".equals(itemValue) ) {
						//코드값 및 버튼 텍스트 변경.
	            		searchDeprMajrCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
	            		searchDeprMajrCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
					}else if("A032".equals(itemValue) || "A033".equals(itemValue) 
								|| "A034".equals(itemValue) || "A035".equals(itemValue)){
						//코드값 및 버튼 텍스트 변경.
            			searchSchlCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
            			searchSchlCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
					}
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
                if (!"".equals(mapModel.get("deptCd"))) { 
//                    srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                    srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
                	srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                	srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                    srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                    srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                    payrMangDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("payrMangDeptCd"))); 
                    srhDeptCd.fireEvent(Events.Add);
                }  
            }
        });
    }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/ 
    
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 그리드 조회부 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	
    /** 기본 조회 **/
	public void reloadPsnl0600() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		psnl0600GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		psnl0600GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 성별
		
		psnl0600GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 직종세
		
		psnl0600GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 사업
		
		
		psnl0600GridPanel.getTableDef().addColumnFilter("dateType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhDateType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 고용기간구분
		
		
		
		
//		ㅇㅇ
//		
//		emymtBgnnDt
//		SttsUtils.getSelectedComboValue(srhYr01, "year") + SttsUtils.getSelectedComboValue(srhMnth, "month") 
//		private ComboBox<BaseModel> srhYr01;							// 월별 년
//		private ComboBox<BaseModel> srhMnth;							// 월별 월
//		
//		strParam += "" + SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd")+"⊥";					// $2 시작기간
//		strParam += "" + SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd")+"⊥";					// $3 종료기간
//		
//	    private DateField srhDayS;      								// 기간별 시작일
//	    private DateField srhDayE;      								// 기간별 종료일
//	    
//	    
//		String strYr02 = SttsUtils.getSelectedComboValue(srhYr02, "yearDisp");					// 분기별 년  
//		String strMnthS = SttsUtils.getSelectedComboValue(srhMnthS, "monthDisp");				// 분기별 시작월   
//		String strMnthE = SttsUtils.getSelectedComboValue(srhMnthE, "monthDisp");				// 분기별 종료월 
//	    
//	    private ComboBox<BaseModel> srhYr02;							// 분기별 년
//	    private ComboBox<BaseModel> srhMnthS;							// 분기별 시작월
//	    private ComboBox<BaseModel> srhMnthE;							// 분기별 종료월
		
		
		
		/******************* 기본 검색조건 종료 *******************/
		
		psnl0600GridPanel.reload();
	}
	
    /** 병역 조회 **/
	public void reloadPsnl0112() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0112GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("dsageDivCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchDsageDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 제대구분
		 
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("dsageDtS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchDsageDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);				// 제대기간 시작일
		 
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("dsageDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchDsageDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);			// 제대기간 종료일		 
		
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("baggrpCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchBaggrpCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 군별
		 
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("abotsCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAbotsCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 병과
		 
		 psnl0600ToPsnl0112GridPanel.getTableDef().addColumnFilter("clsCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchClsCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 계급
		 
		psnl0600ToPsnl0112GridPanel.reload();
	}
	
    /** 단체 조회 **/
	public void reloadPsnl0114() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0114GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("jnOpztnNm"
					, MSFSharedUtils.allowNulls(searchJnOpztnNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 															// 단체명
		 
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("jnDtS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchJnDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);					// 가입기간 시작일
		 
		 psnl0600ToPsnl0114GridPanel.getTableDef().addColumnFilter("jnDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchJnDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);				// 가입기간 종료일	 
		 
		 psnl0600ToPsnl0114GridPanel.reload();
	}
	
	
    /** 학력 조회 **/
	public void reloadPsnl0116() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0116GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);											// 단위기관
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);											// 관리부서
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 												// 소속부서

		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 직종
				
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 생일 시작일
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 생일 종료일
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);	// 근속년수 시작일
		
		psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);	// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 성별
		
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("acadAbtyDivCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 학력구분														
		 
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("degrDivCd"
					, MSFSharedUtils.allowNulls( PersonalUtil.getSelectedComboValue(searchDegrDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 학위
		 
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("deprMajrCd"
					, MSFSharedUtils.allowNulls(searchDeprMajrCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 													// 학과
		 
		 psnl0600ToPsnl0116GridPanel.getTableDef().addColumnFilter("schlCd"
					, MSFSharedUtils.allowNulls(searchSchlCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 														// 학교명
		 
		 psnl0600ToPsnl0116GridPanel.reload();
	}
	
	
    /** 경력 조회 **/
	public void reloadPsnl0119() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0119GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("paeWorkNm"
					, MSFSharedUtils.allowNulls(searchPaeWorkNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 														// 근무처명														
		 
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("carrBgnnDtS"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchCarrBgnnDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근무시작일 시작일
			
		 psnl0600ToPsnl0119GridPanel.getTableDef().addColumnFilter("crrBgnnDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchCarrBgnnDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근무시작일 종료일
		
		 psnl0600ToPsnl0119GridPanel.reload();
	}
	
    /** 자격 조회 **/
	public void reloadPsnl0118() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0118GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("qftntLicnsPovncCtnt"
					, MSFSharedUtils.allowNulls(searchQftntLicnsPovncCtnt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 														// 자격면허														
		 
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("aqtnDtS"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchAqtnDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);			// 취득일자 시작일
			
		 psnl0600ToPsnl0118GridPanel.getTableDef().addColumnFilter("aqtnDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchAqtnDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);			// 취득일자 종료일
		
		 psnl0600ToPsnl0118GridPanel.reload();
	}
	
	
    /** 교육 조회 **/
	public void reloadPsnl0120() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0120GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("eduKndNm"
					, MSFSharedUtils.allowNulls(searchEduKndNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 															// 교육종류														
		 
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("eduBgnnDtS"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchEduBgnnDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 교육종류 시작일
			
		 psnl0600ToPsnl0120GridPanel.getTableDef().addColumnFilter("eduBgnnDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchEduBgnnDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 교육종류 종료일
		
		 psnl0600ToPsnl0120GridPanel.reload();
	}
    
	
    /** 포상 조회 **/
	public void reloadPsnl0121() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0121GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0121GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 psnl0600ToPsnl0121GridPanel.reload();
	}
	
	
    /** 징계 조회 **/
	public void reloadPsnl0122() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0122GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 					// 성별
		
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 직종세
		
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("dsnyActDivCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchDsnyActDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 징계구분													
		 
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("dsnyActDsplDtS"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchDsnyActDsplDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 징계처분일 시작일
			
		 psnl0600ToPsnl0122GridPanel.getTableDef().addColumnFilter("dsnyActDsplDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchDsnyActDsplDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 징계처분일 종료일
		 
		 psnl0600ToPsnl0122GridPanel.reload();
	}
	
	
    /** 휴직 조회 **/
	public void reloadPsnl0123() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0600ToPsnl0123GridPanel.getTableDef().setTableColumnFilters(filters);
		
		/******************* 기본 검색조건 시작 *******************/
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("payrMangDeptCd"
				, MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 단위기관
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("deptCd"
				, MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);															// 관리부서
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("currAffnDeptCd"
				, MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 																	// 소속부서

		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("emymtDivCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 		// 고용구분
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("typOccuCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd")), SimpleColumnFilter.OPERATOR_EQUALS); 			// 직종
				
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("nowDeptDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 시작일				
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("nowDeptDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 현부서 종료일
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("frstWorkDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 시작일
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("frstWorkDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 최초 고용 종료일
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("birthDateS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 시작일
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("birthDateE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchBirthDateE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);		// 생일 종료일
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("workYearS"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 시작일
		
		psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("workYearE"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01")), SimpleColumnFilter.OPERATOR_EQUALS);		// 근속년수 종료일
		
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
		 
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(strHdofcCodtnCd), SimpleColumnFilter.OPERATOR_EQUALS);	// 재직구분
		
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("sexType"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchSexType,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 						// 성별
		
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(
				lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")), SimpleColumnFilter.OPERATOR_EQUALS); 								// 직종세
		
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("businCd"
				, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd")), SimpleColumnFilter.OPERATOR_EQUALS); 							// 사업
		/******************* 기본 검색조건 종료 *******************/
		 
		 
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("levfAbncDivCd"
					, MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchLevfAbncDivCd,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS);			// 휴직구분													
		 
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("levfAbncBgnnDtS"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchLevfAbncBgnnDtS, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 휴직일 시작일
			
		 psnl0600ToPsnl0123GridPanel.getTableDef().addColumnFilter("levfAbncBgnnDtE"
					, MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchLevfAbncBgnnDtE, "yyyyMMdd")), SimpleColumnFilter.OPERATOR_EQUALS);	// 휴직일 종료일
		 
		 psnl0600ToPsnl0123GridPanel.reload();
	}
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 그리드 조회부 종료
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	
	
	
	
	// 기간 셋팅
	private void setInitDate() {
		   
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		String strYr = DateTimeFormat.getFormat("yyyy").format(new Date());
		
		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set (Integer.parseInt(strYr), monthS -1, 1);
		srhDayS.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  
	       
	      
		Calendar  intieCal =   Calendar.getInstance();
	    intieCal.set (Integer.parseInt(strYr), monthE - 1, maxDays );
	    srhDayE.setValue(intieCal.getTime());
	    
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
	public Psnl0600 getThis(){
		return this;
	}
}
