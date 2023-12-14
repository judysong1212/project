/**
 * PayGenConst.PAYGEN_VERSION.concat("  - 인사기본출력
 */
package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.app.exterms.personal.client.dto.Psnl0122DTO;
import com.app.exterms.personal.client.dto.Psnl0320DTO;
import com.app.exterms.personal.client.form.defs.Psnl0320DefButtom;
import com.app.exterms.personal.client.form.defs.Psnl0320DefLeft;
import com.app.exterms.personal.client.form.defs.Psnl0320DefRight10;
import com.app.exterms.personal.client.form.defs.Psnl0320DefRight20;
import com.app.exterms.personal.client.form.defs.Psnl0320DefRight30;
import com.app.exterms.personal.client.form.defs.Psnl0320DefRight40;
import com.app.exterms.personal.client.service.Psnl0111Service;
import com.app.exterms.personal.client.service.Psnl0111ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0320Service;
import com.app.exterms.personal.client.service.Psnl0320ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
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
import com.extjs.gxt.ui.client.event.TabPanelEvent;
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
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * 
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0320 extends MSFPanel {

	private Psnl0320DefLeft psnl0320DefLeft = new Psnl0320DefLeft();  //대상자정보 
	private Psnl0320DefRight10 psnl0320DefRight10 = new Psnl0320DefRight10();  //고용
	private Psnl0320DefRight20 psnl0320DefRight20 = new Psnl0320DefRight20();  //기간제고용
	private Psnl0320DefRight30 psnl0320DefRight30 = new Psnl0320DefRight30();  //경력
	private Psnl0320DefRight40 psnl0320DefRight40 = new Psnl0320DefRight40(); //징계
	private Psnl0320DefButtom psnl0320DefButtom = new Psnl0320DefButtom(); //호복재획정결과상세 
	
    private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
	private HiddenField<String> systemkey;   /** column SYSTEMKEY : systemkey */ 
	
	private TabPanel tabPanel;
	private TabItem tabitem10;
	private TabItem tabitem20;
 	private TabItem tabitem30;
 	private TabItem tabitem40;
 //	private TabItem tabitem04;
    private MSFGridPanel psnl0320GridPanelLeft;   //대상자정보
    private MSFGridPanel psnl0320GridPanelRight10;
    private MSFGridPanel psnl0320GridPanelRight20;
    private MSFGridPanel psnl0320GridPanelRight30;
    private MSFGridPanel psnl0320GridPanelRight40;
    private MSFGridPanel psnl0320GridPanelBottom;
 	private MSFTextField emymtBgnnDt;   /** column 고용시작일자(입사일자) : emymtBgnnDt */
    private MSFTextField emymtDivNm; //고용구분
    private MSFTextField  socnsrIssRegVal02;    /** column 공통_성명 : socnsrIssRegVal02 */
    private MSFTextField  socnsrIssRegVal03;   /** column 공통_주민등록번호 : socnsrIssRegVal03 */
    private MSFTextField deptNm; //부서
    private MSFTextField typOccuNm; //직종
    private String systemKeys;
  
 	private MSFTextField deptNmHan;    //부서명(한글)
	private MSFTextField detailTypOccuNm;			//직종명
	private MSFTextField detailDtilOccuInttnNm;		//직종세명
	private MSFTextField businNm;	 				//사업명
	private MSFTextField reMrkDt;   /** column 호봉재획정일자 : reMrkDt */
	private MSFDateField reMrkCalcDt;   /** column 호봉재획정일자 : reMrkDt */
	private MSFTextField pysd;	 				//호봉
	private MSFTextField logSvcYrNumCd;	 	//근속년
	private MSFTextField logSvcMnthNumCd;	 	//근속월
	private MSFTextField logStdDt;   /** column 근속기준일 : logStdDt */
	private MSFTextField enrlntDt;	 	//입대일자
	private MSFTextField dsageDt;	 	//제대일자
	//private MSFComboBox<BaseModel> servcRcgtnPrid;	 	//복무인정기간
	private MSFComboBox<BaseModel> psnl0112ServcRcgtnPridCd;	 	//복무인정기간
	private MSFTextField stdDt;    //기준일자
	private HashMap<String, String> param = new HashMap<String, String>();
	private ComboBox<BaseModel> searchEmymtDivCd; 			//고용구분
	private ComboBox<BaseModel> creMonth;//작업월
	private ComboBox<BaseModel> creYear;//작업년도
	

	private ListStore<BaseModel> listStoreA029 = new ListStore<BaseModel>();
 	
 	 
 	private String dblClickDpobCd = new String();
 	private String dblClickSystemkey = new String();

	
 	private MSFTextField blank_a1;  //호봉
 	private MSFTextField blank_a2;  //근속년수
 	private MSFTextField blank_a3;  //근속월수
 	private MSFTextField blank_a4;  //근속일수
 	
 	private String pyspReMrkSeilNum; // 시스템키
 	private String mityCarrTotLogSvcDys;
 	
 	private Button btnSave1;
 	
 	
/**
 * ####################################################### 
 * { 시스템 기본설정파일 선언부 시작} 
 * #######################################################
 */
	  //권한 설정 객체 
 	private GWTAuthorization gwtAuthorization;
 	private GWTExtAuth gwtExtAuth;
 	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	 
/**
 * ####################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################
 */
	
	private XTemplate detailTp;
	private VerticalPanel vp;
	private FormPanel plFrmPsnl0320; // formpanel
	private String txtForm = "";
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	
	private FieldSet  fldstNewFieldset_3;
	
	public FormBinding formBinding;	//폼바인딩변수

	private BaseModel record;
	private Iterator<Record> records;

	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0320Bar;						//상위 버튼 Bar	
	private Button btnPsnl0320Reset;						//초기화 버튼
	private Button btnPsnl0320Sreach;						//조회 버튼
	private Button btnPsnl0320Print;						//인쇄 버튼
	private Button btnPsnl0320Excel;						//엑셀버튼
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 시작 --------------
	//private ComboBox<BaseModel> searchManageDeptCd; // 관리부서
	//private ComboBox<BaseModel> searchDeptCd; // 부서
	private FieldSet fieldSet; 								//검색조건
	private TextField<String> searchName;					//이름
	private TextField<String> searchResnRegnNum; 			//주민번호
	private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	
//	private ComboBox<BaseModel> searchTypOccuCd; 			//직종
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종
	private DateField srhLogStdDt;						//기준일자
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;//직종세
//	private ComboBox<BaseModel> searchHdofcCodtnCd; 		//재직구분
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 	//재직 
//	private TextField<String> srhDeptCd; 					//부서코드
	private MSFMultiComboBox<ModelData> srhDeptCd; 			//부서코드
    private TextField<String> srhDeptNm; 					//부서명  
    private Button btnSrhDeptCd;							//부서검색 버튼
//    private TextField<String> srhMangeDeptCd; 				//관리부서 수정
 //   private TextField<String> srhMangeDeptNm; 				//관리부서 수정 
//	private ComboBox<BaseModel> searchEmymtDivCd; 			//고용구분
	private ComboBox<BaseModel> srhPayrMangDeptCd;			//단위기관
	private ComboBox<BaseModel> searchYearBusinCd; 			//사업명 코드
	private ComboBox<BaseModel> srhBusinCd;    				//사업
	private HiddenField<String> srhSystemkey;   			//시스템키
	private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분 
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정


	private Boolean emptyCheck = false ;

	// -------------- 검색조건 종료 --------------

	
	// -------------- 서비스 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	//공통코드 호출
	//private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();	//부서코드 호출
	// -------------- 서비스 호출 종료 --------------
	
	// -------------- 출력조건 시작 --------------
	private RadioGroup outputTypeRadiogroup;
	// -------------- 출력조건 종료 --------------
	
	// -------------- listStore 선언 시작 --------------
	private ListStore<BaseModel> listStoreA003 		= new ListStore<BaseModel>();	//재직구분
	private ListStore<BaseModel> listStoreA041 		= new ListStore<BaseModel>();	//직종
	private ListStore<BaseModel> listStoreA002 		= new ListStore<BaseModel>();	//고용구분
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lsDeptCd  			= new ListStore<BaseModel>();	//부서콤보
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd  = new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();	//부서
	private ListStore<BaseModel> lsHdofcCodtnCd 	= new ListStore<BaseModel>(); 	//재직상태 
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	// -------------- listStore 선언 끝 --------------
	
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0150DTO sysComBass0150Dto;	//단위기관
	private PrgmComBass0300DTO sysComBass0300Dto; 	//공통코드 
	private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- DTO 선언 끝 ---------------
	
	// -------------- List<ModelData> 선언 시작 ---------------
	private boolean mutilCombo = false;
	
	private List<ModelData> mDtalistHdofcCodtnCd;
    private List<ModelData> mDtalistDeptCd;
    private List<ModelData> mDtalistTypOccuCd;
    private List<ModelData> mDtalistDtilOccuInttnCd;
    // -------------- List<ModelData> 선언 끝  ---------------
    
 	// -------------- grid 선언 종료  ---------------
    
    // -------------- HiddenField 선언 시작 ------------------
    private HiddenField<String> payrMangDeptCd;		//단위기관 
    private HiddenField<String> typOccuCd;          //직종코드 
    private HiddenField<String> dtilOccuInttnCd;   //직종세구분코드
    private HiddenField<String> currAffnDeptCd;     //현소속부서코드 
    private HiddenField<String> businCd;            //사업코드 
    // -------------- HiddenField 선언 끝 ------------------
    
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */	
	
//	private String strParam;
//	private String serarchParam;
//	private String rdaFileName;
//	private String rexFileName;
//	private String checkedSystemKeys;
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */		

	//######## PSNL0320 시작
	private Psnl0320ServiceAsync psnl0320Service = Psnl0320Service.Util.getInstance();
	
	private RpcProxy<List<HashMap<String, String>>> psnl0320Proxy = new RpcProxy<List<HashMap<String,String>>>() {
		
		@Override
		protected void load(Object loadConfig, AsyncCallback<List<HashMap<String, String>>> callBack) {
			
			param = new HashMap<String, String>();
			param.put("dpobCd", dblClickDpobCd);
			param.put("systemkey", dblClickSystemkey);
			
			psnl0320Service.selectPsnl0320(param, new AsyncCallback<List<HashMap<String,String>>>() {
				
				@Override
				public void onSuccess(List<HashMap<String, String>> result) {
 
					if(result.size() > 0){
						//pysd.setValue(result.get(0).get("PYSP_GRDE_CD"));
					}else{

					}
				}

				@Override
				public void onFailure(Throwable caught) {
 
				}
			});
			param = new HashMap<String, String>();
		}
	};

	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0320Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0320Proxy);
	//######## PSNL0320 끝

	//######## PSNL0111 시작
	
	private Psnl0111ServiceAsync psnl0111Service = Psnl0111Service.Util.getInstance();
	private RpcProxy<List<HashMap<String, String>>> psnl0111Proxy = new RpcProxy<List<HashMap<String,String>>>() {
		
		@Override
		protected void load(Object loadConfig, AsyncCallback<List<HashMap<String, String>>> callBack) {
			
			param = new HashMap<String, String>();
			param.put("dpobCd", dblClickDpobCd);
			param.put("systemkey", dblClickSystemkey);
			
			psnl0111Service.selectPsnl0111(param, new AsyncCallback<List<HashMap<String,String>>>() {
				
				@Override
				public void onSuccess(List<HashMap<String, String>> result) {
 
					if(result.size() > 0){
						
					}else{

					}
				}
				
				@Override
				public void onFailure(Throwable caught) { 
				}
			});
			param = new HashMap<String, String>();
		}
	};
	
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0111Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0111Proxy);
	//######## PSNL0111 끝  
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
	private void checkPsnl0250Auth( String authAction, ListStore<BaseModel> bm) {
		//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 

		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			//----------------------------------------------------
			if (!maskTracker) {
				unmask();
			}  
			//MSFMainApp.unmaskMainPage();
			authExecEnabled() ;
		}
	 }

	private void authExecEnabled() { 
			//------------------
		Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);
		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 

			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			* 권한설정을 위한 콤보처리를 위한 메서드 시작 
			* 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			// String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
			// GWTAuthorization.formAuthPopConfig(plFrmPayr4100, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
			// GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			// GWTAuthorization.formAuthConfig(plFrmPayr4100, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
			//gwtAuthorization.formAuthConfig(plFrmPsnl0250, "srhPsnlMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			* 권한설정을 위한 콤보처리를 위한 메서드 종료
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	}
		  
	final Timer tmMask = new Timer()
	{
		public void run()
		{ 
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
		
		HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
		
		authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
		authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
		authMapDef.put("srhDeptCd",Boolean.FALSE);
		//authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
		
		gwtExtAuth.setCheckMapDef(authMapDef);
		
		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())){
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
	  
		  
	public ContentPanel getViewPanel() {

		if (panel == null) {


			initLoad();


			detailTp = XTemplate.create(getDetailTemplate());
			vp = new VerticalPanel();
			//엣지변환
			//vp.setSize("1010px", "840px");
			vp.setSize("1010px", "900px");


			createPsnl0320Form();// 화면 기본정보를 설정
			createSearchForm();// 검색필드를 적용
			createForm();//기본정보필드


			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmPsnl0320, true);

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.setScrollMode(Scroll.AUTO);
			panel.add(vp);

			sysComBass0300Service.getPrgmComMultiComboBass0300List(PersonalUtil.getComboList(), new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					if(result != null && result.size() > 0){
						
						listStoreA002.add(result.get("A002"));
						listStoreA003.add(result.get("A003"));
						listStoreA029.add(result.get("A029"));
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					unmask(); 
					MessageBox.alert("", "공통코드 에러!", null);
					
				}
			});
		}
		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Psnl0320() {
		//엣지변환
		//setSize("1010px", "840px");
		setSize("1010px", "900px");
	}

	public Psnl0320(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0320Form() {

		plFrmPsnl0320 = new FormPanel(); 
		plFrmPsnl0320.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 호봉재획정"));
		plFrmPsnl0320.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0320.setBodyStyleName("pad-text");
		plFrmPsnl0320.setFrame(true);
		plFrmPsnl0320.setPadding(2);

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("호봉재획정","PSNL0320");
				}
			});
		plFrmPsnl0320.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0320.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		topPsnl0320Bar = new ButtonBar();
		topPsnl0320Bar.setAlignment(HorizontalAlignment.RIGHT);


		btnPsnl0320Reset = new Button("초기화");
		btnPsnl0320Reset.setIcon(MSFMainApp.ICONS.new16());
		btnPsnl0320Reset.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				searchInit();	//검색조건 초기화
			}
		});
		topPsnl0320Bar.add(btnPsnl0320Reset);


		btnPsnl0320Sreach = new Button("조회");
		btnPsnl0320Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0320Sreach.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				//psnl0110Loader.load();
				resetForm();
				reload();
			}
		});
		topPsnl0320Bar.add(btnPsnl0320Sreach);


		btnPsnl0320Print = new Button("인쇄");
		btnPsnl0320Print.setIcon(MSFMainApp.ICONS.print16());
		btnPsnl0320Print.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
			psnl0320Print("PSNLT0320", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
		});

		topPsnl0320Bar.add(btnPsnl0320Print);
		plFrmPsnl0320.add(topPsnl0320Bar);
 
		btnPsnl0320Excel = new Button("엑셀");
		btnPsnl0320Excel.setIcon(MSFMainApp.ICONS.excel16());
		btnPsnl0320Excel.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				excelFileExport();
			}
		});
		topPsnl0320Bar.add(btnPsnl0320Excel);
		plFrmPsnl0320.add(topPsnl0320Bar);
 
		vp.add(plFrmPsnl0320);
		//엣지변환
		//plFrmPsnl0320.setSize("990px", "840px");
		plFrmPsnl0320.setSize("990px", "900px");//화면의 전체사이즈를 조절한다.
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
	private void psnl0320Print(String fileName, String repType) {
		if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			RdaPrint(fileName);
		} else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			RexPrint(fileName);
		} else {
			Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		}
	}	
	

	//rda
	private void RdaPrint(final String fileName) {
		
		
	}
	
	//rex
	private void RexPrint(final String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		String rexFileName = fileName+".crf";
		String serarchParam = "";
		
		
		String srhLogStdDtStr = GWTUtils.getStringFromDate(srhLogStdDt.getValue(),"yyyyMMdd");
		
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd");
		String typOccuCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
		String dtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
		String hanNm = MSFSharedUtils.allowNulls(searchName.getValue());
		String resnRegnNum = MSFSharedUtils.allowNulls(searchResnRegnNum.getValue());
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

		
		String deptCdAuth = MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "");
		
		
		
		if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
			if(emymtDivCd.equals("A0020010")){
			}else if(emymtDivCd.equals("A0020020")){
				if(deptCd == null || deptCd.equals("")){
					Window.alert("부서를 선택해 주세요");
					resetForm();
					psnl0320GridPanelLeft.getMsfGrid().clearData();
					return;
				}	
				if(businCd == null || businCd.equals("")){	
					Window.alert("사업을 선택해 주세요");
					resetForm();
					psnl0320GridPanelLeft.getMsfGrid().clearData();
					return;
				}
			}else{
				Window.alert("고용구분을 선택해 주세요");
				resetForm();
				psnl0320GridPanelLeft.getMsfGrid().clearData();
				return;
			}
		}else{
			Window.alert("단위기관/고용구분을 선택해 주세요");
			resetForm();
			psnl0320GridPanelLeft.getMsfGrid().clearData();
			return;
		}

		
		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = psnl0320GridPanelLeft.getGrid().getSelectionModel().getSelectedItems();

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


		if(srhLogStdDtStr != null && !"".equals(srhLogStdDtStr)){

			//도장 출력을 위해 추가 2014-11-06 //$9
			String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
			if(MSFSharedUtils.paramNull(myImgUrl)) {
			// myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력 
			}							

			
			serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";//$1
			serarchParam += ""+MSFSharedUtils.allowNulls(srhLogStdDtStr)+"⊥";	//$2  기간검색시작		
			serarchParam += "⊥";	//$3  기간검색종료			
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
			serarchParam += ""+MSFSharedUtils.allowNulls(mangeDeptCd)+"⊥";	   //$20 관리부서	                             
			
			String strParam = "" + serarchParam ;

			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

		}else{
			MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
		}
		
		
		
	
	}	
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {
		
		srhSystemkey = new HiddenField<String>();		//시스템키 
		
		sysComBass0150Dto = new PrgmComBass0150DTO();	//단위기관
		sysComBass0300Dto = new PrgmComBass0300DTO();	//공통코드
		sysComBass0320Dto = new PrgmComBass0320DTO();	//직종코드
		sysComBass0350Dto = new PrgmComBass0350DTO();	//직종세
		sysComBass0400Dto = new PrgmComBass0400DTO();	//부서코드
		sysComBass0500Dto = new PrgmComBass0500DTO();	//사업코드  
		
		 
		//List<String> arrRpsttvCd = new ArrayList<String>();
		//arrRpsttvCd.add("A002"); //고용구분
		//arrRpsttvCd.add("A003"); //재직구분
		//arrRpsttvCd.add("A041"); //직종
		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
		//sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
		
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		 //재직상태  
		 sysComBass0300Dto.setRpsttvCd("A003");
		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>(){
             public void handleEvent(StoreEvent<BaseModel> be) {  
                 mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
                 srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
             }
		 });  
		 
		// 호봉코드
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);


		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------


		 //-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);


		
		//--------------------부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);

		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});     
		 //--------------------부서 불러 오는 함수 ------------------------------------------------


		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});  
		//---------------------직종 콤보 처리----------------------------------------------------

		//---------------------멀티콤보박스 닫기 -------------------------------------------------
		//plFrmPsnl0250.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
		plFrmPsnl0320.addListener(Events.OnClick,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce)
			{ 
				if (mutilCombo)
				{
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() )
					{
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					} else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() )
					{
						srhHdofcCodtnCd.showClose(ce);
						mutilCombo = false;
					} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() )
					{
						//직종
						srhTypOccuCd.showClose(ce);
						mutilCombo = false;
					} else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() )
					{
						//직종세
						srhDtilOccuInttnCd.showClose(ce);
						mutilCombo = false;
					}  
				}
			}
		});

		plFrmPsnl0320.setLayout(new FlowLayout());

		//lcSchCol.setLayout(new ColumnLayout());

		fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
		//fieldSet.setCheckboxToggle(false);

		LayoutContainer lcSchCol = new LayoutContainer();

		LayoutContainer lcSch1 = new LayoutContainer();
		lcSch1.setLayout(new ColumnLayout());
		lcSch1.setBorders(false);
		
		


		LayoutContainer lcSch1_4 = new LayoutContainer();
		lcSch1_4.setLayout(new ColumnLayout());

		LayoutContainer lcSch1_4_1 = new LayoutContainer();
		FormLayout frmlytSch1_4_1 = new FormLayout();
		frmlytSch1_4_1.setLabelWidth(60);
		frmlytSch1_4_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_4_1.setLayout(frmlytSch1_4_1);

		searchName = new TextField<String>();
		searchName.setFieldLabel("성명");
		searchName.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				
				searchName.validate();
				if (MSFSharedUtils.allowNulls(searchName.getValue()).trim().equals("")) {
					srhSystemkey.setValue("");
					searchResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					searchResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});
		
 

		lcSch1_4_1.add(searchName, new FormData("100%"));
		lcSch1_4.add(lcSch1_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));


		LayoutContainer lcSch1_4_2 = new LayoutContainer();
		Button btnHanNm = new Button("검색");
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				searchResnRegnNum.setValue("");
				fnPopupPsnl0100() ;
			}
		});

		lcSch1_4_2.add(btnHanNm);
		lcSch1_4.add(lcSch1_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));

		LayoutContainer lcSch1_4_3 = new LayoutContainer();
		FormLayout frmlytSch1_4_3 = new FormLayout();
		frmlytSch1_4_3.setHideLabels(true);
		frmlytSch1_4_3.setLabelAlign(LabelAlign.LEFT);
		lcSch1_4_3.setLayout(frmlytSch1_4_3);
		searchResnRegnNum = new TextField<String>();
		searchResnRegnNum.setName("searchResnRegnNum");
		searchResnRegnNum.setLabelSeparator("");
		new TextFieldMask<String>(searchResnRegnNum, "999999-9999999");
		lcSch1_4_3.add(searchResnRegnNum, new FormData("100%"));
		lcSch1_4.add(lcSch1_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		 

		LayoutContainer lcSch1_1 = new LayoutContainer();
		FormLayout frmlytSch1_1 = new FormLayout();
		frmlytSch1_1.setLabelWidth(60);
		frmlytSch1_1.setLabelAlign(LabelAlign.RIGHT);
		//fieldSet.setLayout(layout);
		lcSch1_1.setLayout(frmlytSch1_1);


		srhPayrMangDeptCd = new ComboBox<BaseModel>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setForceSelection(true);
		srhPayrMangDeptCd.setMinChars(1);
		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		srhPayrMangDeptCd.setSelectOnFocus(true); 
		srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
		srhPayrMangDeptCd.setFieldLabel("단위기관"); 
		lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>(){
			public void handleEvent(StoreEvent<BaseModel> be){

				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		  				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPsnl0250Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
				}
			}
		});

		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
				sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
				 

				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------

				lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});
			}
		});
		lcSch1_1.add(srhPayrMangDeptCd, new FormData("100%"));
		 
        LayoutContainer lcSch1_3 = new LayoutContainer(new ColumnLayout());
        
    LayoutContainer lcSch1_3_1 = new LayoutContainer();
    
	FormLayout frmlytSch1_3 = new FormLayout();
	frmlytSch1_3.setLabelWidth(60);
	frmlytSch1_3.setLabelAlign(LabelAlign.RIGHT);
	lcSch1_3_1.setLayout(frmlytSch1_3);
	
	srhEmymtDivCd =  new ComboBox<BaseModel>(); 
    srhEmymtDivCd.setName("srhEmymtDivCd");
    srhEmymtDivCd.setForceSelection(true);
    srhEmymtDivCd.setMinChars(1);
    srhEmymtDivCd.setDisplayField("commCdNm");
    srhEmymtDivCd.setValueField("commCd");
    srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
    srhEmymtDivCd.setEmptyText("--고용구분선택--");
    srhEmymtDivCd.setSelectOnFocus(true); 
    srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());//TODO
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
	                	checkPsnl0250Auth("srhEmymtDivCd", lsEmymtDivCd); 
          	 }
    	}
    }); 
    
    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
    		
    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
    		BaseModel bmPayCd =  se.getSelectedItem(); 
    		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//    			if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//    				if (srhDeptCd.getListView().getChecked().size() > 0) {  
//    					sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//    					List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//    					sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//    				}      
//              
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//    				lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//                   
//    				srhBusinCd.setStore(lsBusinCd); 
//    				srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//    					public void handleEvent(StoreEvent<BaseModel> be) {  
//    					}
//    				});    
//    			} else {
//    			}  
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
    lcSch1_3_1.add(srhEmymtDivCd, new FormData("100%"));
	lcSch1_3.add(lcSch1_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	
    LayoutContainer lcSch1_3_2 = new LayoutContainer(); 
    FormLayout  frmlytSch = new FormLayout();   
    frmlytSch.setDefaultWidth(0);
    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    lcSch1_3_2.setLayout(frmlytSch);
    
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
//    srhRepbtyBusinDivCd.setLabelSeparator("");
   // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
        public void handleEvent(StoreEvent<BaseModel> be) {  

          
        }
    });  
    
    lcSch1_3_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
    lcSch1_3.add(lcSch1_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		

	LayoutContainer lcSch3_1 = new LayoutContainer();
	 frmlytSch = new FormLayout();
	frmlytSch.setLabelWidth(60);
	frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	lcSch3_1.setLayout(frmlytSch);
	srhLogStdDt = new DateField();
	new DateFieldMask(srhLogStdDt, "9999.99.99");
	srhLogStdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	srhLogStdDt.setFieldLabel("기준일자");
    lcSch3_1.add(srhLogStdDt, new FormData("100%"));

		
//		lcSch1.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//단위기관
//		lcSch1.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	//재직
//		lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	//고용구분
//		lcSch1.add(lcSch1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));	//성명, 주민번호
		
		
		lcSch1.add(lcSch1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		//기준일자
		lcSch1.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	//단위기관
		lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	//고용구분


		LayoutContainer lcSch2 = new LayoutContainer();
		lcSch2.setLayout(new ColumnLayout());
 
		//관리부서 
		LayoutContainer lcSch2_0 = new LayoutContainer();
		FormLayout frmlytSch2_0 = new FormLayout();
		frmlytSch2_0.setLabelWidth(60);
		frmlytSch2_0.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_0.setLayout(frmlytSch2_0);
		
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
  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
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
	      	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	      	    			} 
	      	    			
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_0.add(srhMangeDeptCd, new FormData("100%"));
		//부서 
		LayoutContainer lcSch2_1 = new LayoutContainer();
		
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(60);
		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_1.setLayout(frmlytSch2_1);
		
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
					checkPsnl0250Auth("srhDeptCd", lsDeptCd);
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {  

						sysComBass0500Dto.setBusinApptnYr(PayGenConst.ACC_CURR_YEAR);    
						List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 

        				sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
					}

        			//--------------------사업 불러 오는 함수 -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
        			//--------------------사업 불러 오는 함수 -------------------------------------------------

					srhBusinCd.setStore(lsBusinCd); 
					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
						}
					});
				} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	            		 
        			//2015.11.30 권한 직종가져오기  추가 
        			sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

        			String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
        			sysComBass0320Dto.setDeptCd(strDeptCd);

        			lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
        			lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
         		   		public void handleEvent(StoreEvent<BaseModel> be) {  
         		   			mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
         		   			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
         		   		}
        			});  
				} else {

					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

					String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		      	   	sysComBass0320Dto.setDeptCd(strDeptCd);
		      	   	
		      	   	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		      	   	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		      	   		public void handleEvent(StoreEvent<BaseModel> be) {  
		      	   			mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
		      	   			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		      	   		}
		      	   	});
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>(){
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

        lcSch2_1.add(srhDeptCd, new FormData("100%"));
        
        //직종 직종세처리 
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
        
        
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
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
//        frmlytSch.setLabelWidth(30); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_21.setLayout(frmlytSch);
       
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.setHideLabel(true);
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
        srhTypOccuCd.setHideLabel(true);
//        srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	
	    		  EventType type = be.getType();
	    		  if (type == Store.Add) { 
	    			  //2015.11.30 추가 
		    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
		    			   ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
		    			   srhTypOccuCd.getListView().setChecked(mdSelect, true); 
		    			   srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
		                    
		    		   }  
		    		   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
	    			  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    			   * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	    			   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	    			   * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	         			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	//checkDlgn0100Auth("srhTypOccuCd", lsTypOccuCd); 
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
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(1); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        frmlytSch.setDefaultWidth(0);
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
        
        lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
	    

		LayoutContainer lcSch2_3 = new LayoutContainer();
		FormLayout frmlytSch2_3 = new FormLayout();
		frmlytSch2_3.setLabelWidth(60);
		frmlytSch2_3.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_3.setLayout(frmlytSch2_3);
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
	    lcSch2_3.add(srhBusinCd, new FormData("100%"));
	    
	    lcSch2.add(lcSch2_0, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		//재직
	    lcSch2.add(lcSch2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	//부서
	    lcSch2.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	//직종, 직종세
	    

		LayoutContainer lcSch3 = new LayoutContainer();
		lcSch3.setLayout(new ColumnLayout());


//		LayoutContainer lcSch3_1 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSch3_1.setLayout(frmlytSch);
//		srhLogStdDt = new MSFDateField();
//		new DateFieldMask(srhLogStdDt, "9999.99.99");
//		srhLogStdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		srhLogStdDt.setFieldLabel("기준일자");
//	    lcSch3_1.add(srhLogStdDt, new FormData("100%"));
	    
		LayoutContainer lcSch1_2 = new LayoutContainer();
		FormLayout frmlytSch1_2 = new FormLayout();
		frmlytSch1_2.setLabelWidth(60);
		frmlytSch1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_2.setLayout(frmlytSch1_2);

		srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
		srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
		srhHdofcCodtnCd.setEmptyText("--재직선택--");
		srhHdofcCodtnCd.setReadOnly(true);
		srhHdofcCodtnCd.setEnabled(true); 
		srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
		srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		srhHdofcCodtnCd.setFieldLabel("재직");
		srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>(){
			public void handleEvent(StoreEvent<ModelData> be){
				srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
				srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
			}
		});

		srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce)
			{   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR)
				{
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT)
				{
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER)
				{
					mutilCombo = false;
				}
			}
		});

		lcSch1_2.add(srhHdofcCodtnCd, new FormData("100%"));
		
//      
		lcSch3.add(lcSch2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		//사업
        lcSch3.add(lcSch3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	//성명, 주민번호
        lcSch3.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	//기준일자


		lcSchCol.add(lcSch1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcSchCol.add(lcSch2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcSchCol.add(lcSch3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));


		fieldSet.add(lcSchCol, new FormData("100%"));


		plFrmPsnl0320.add(fieldSet);
	}
	

	private void  displayDtilOccuInttnCd() {
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
            
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
			
			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
            	lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
            	//  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                    
            	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
            		public void handleEvent(StoreEvent<BaseModel> be) {  
            			mDtalistDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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

	
	public void setRecord(BaseModel record) {
		this.record = record;
	}		
	
	//검색조건 초기화
	private void searchInit() {
		srhPayrMangDeptCd.setValue(new BaseModel());	//단위기관
		srhHdofcCodtnCd.setValue("");					//재직상태
		srhEmymtDivCd.setValue(new BaseModel());		//고용구분
	    searchName.setValue("");						//성명
		searchResnRegnNum.setValue("");					//주민등록번호
		srhDeptCd.setValue("");							//부서
		srhTypOccuCd.setValue("");						//직종
		srhDtilOccuInttnCd.setValue("");				//직종세
		srhBusinCd.setValue(new BaseModel());			//사업
		
		blank_a1.clear();
	 	blank_a2.clear();
	 	blank_a3.clear();
	 	blank_a4.clear();
	 	
	 	pyspReMrkSeilNum = "";
	 	mityCarrTotLogSvcDys = "";
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/		
	//성명
	private void fnPopupPsnl0100()  {
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchName.getValue());  //인사 
        
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
        
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource();
                if (!"".equals(mapModel.get("systemkey"))) { 
                	srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));		//시스템키
                	searchName.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));				//성명
                	searchResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));	//주민번호 
                }  
            }
        });
    }
	

	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
	}-*/;

	
	
	
	
	
	private void createForm() {
		dpobCd = new HiddenField<String>();   /** column 사업장코드 : dpobCd */
		systemkey = new HiddenField<String>();   /** column SYSTEMKEY : systemkey */ 
	 

		LayoutContainer layoutContainer = new LayoutContainer();   

	    
		LayoutContainer layoutContainer_16 = new LayoutContainer();
		layoutContainer_16.setLayout(new ColumnLayout());
		layoutContainer_16.setBorders(false);  


		LayoutContainer layoutContainer_1 = new LayoutContainer();
		//layoutContainer_1.setSize(width, height)
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);


		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setScrollMode(Scroll.AUTO);


		fldstNewFieldset.setHeadingHtml("근로자정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer_1.add(fldstNewFieldset,new FormData("100%"));
		fldstNewFieldset.add(leftGrid01(),new FormData("100%"));


		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("기본정보");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.add(rightForm01(),new FormData("100%"));
		layoutContainer_2.add(fldstNewFieldset_1,new FormData("100%"));


		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);


		FieldSet fldstNewFieldset_2 = new FieldSet(); 
		
		
		
		fldstNewFieldset_2.setHeadingHtml("군복무");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.add(rightForm02(),new FormData("100%"));
		layoutContainer_2.add(fldstNewFieldset_2);


		//컨텐츠패널 > 탭패널 > 탭 > 그리드
/*		ContentPanel cp02 = new ContentPanel();
		cp02.setSize(625, 235);
		cp02.setHeaderVisible(false);
		cp02.setBorders(false);
		cp02.setScrollMode(Scroll.AUTO);*/


		
	   fldstNewFieldset_3 = new FieldSet();
	   fldstNewFieldset_3.setSize(625, 255);
	   fldstNewFieldset_3.add(createTabForm(),new FormData("100%"));
	   fldstNewFieldset_3.setCollapsible(false);
		

		layoutContainer_2.add(fldstNewFieldset_3);


		FieldSet fldstNewFieldset_4 = new FieldSet(); 
		fldstNewFieldset_4.setHeadingHtml("호봉재획정결과");
		fldstNewFieldset_4.setCollapsible(false);
		fldstNewFieldset_4.add(rightForm03(),new FormData("100%"));
		layoutContainer_2.add(fldstNewFieldset_4);


		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		//대상자정보, 기본정보, 군복무 등을 감싸고 있는 패널
		cp01.setBorders(false);
		//이상하다. width 를 900대로 하면 오늘쪽 윤곽선이 보이지 않고 있음에도 내부에 들어있는 컴포넌트 들의 크기가 줄어든다.
		
		//엣지변환
		//cp01.setSize(964, 460);
		cp01.setSize(964, 510);


		layoutContainer_16.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_16.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));

		cp01.add(layoutContainer_16);

		layoutContainer.add(cp01, new FormData("100%")) ;   


		FieldSet subFieldSet = new FieldSet();
		subFieldSet.setScrollMode(Scroll.AUTO);
		subFieldSet.setHeadingHtml("호봉재획정결과상세");
		subFieldSet.setCollapsible(false);
		subFieldSet.add(bottomGrid01());
		layoutContainer.add(subFieldSet);

		plFrmPsnl0320.add(layoutContainer);
	}

	
	
	private LayoutContainer createTabForm() {
		
		//탭패널 > 탭 > 그리드
//				TabPanel tabPanel = new TabPanel();
				tabPanel = new TabPanel();
				//tabPanel.setSize(622, 175);
				

				//tabPanel.setAutoWidth(false);		   
				tabPanel.setAnimScroll(true);   
				tabPanel.setTabScroll(true); 
				tabPanel.setPlain(true);   
				//엣지변환
				//tabPanel.setSize(622, 220);
				tabPanel.setSize(622, 230);
				tabPanel.addListener(Events.Select, new Listener<TabPanelEvent>() {
					public void handleEvent(TabPanelEvent e) {
						
						if("tabitem10".equals(tabPanel.getSelectedItem().getId())) {
							reloadRightGrid10();
						} else	if("tabitem20".equals(tabPanel.getSelectedItem().getId())) {
							reloadRightGrid20(); 
						}else if("tabitem30".equals(tabPanel.getSelectedItem().getId())) {
							reloadRightGrid30();
						}else if("tabitem40".equals(tabPanel.getSelectedItem().getId())) {
							reloadRightGrid40();
						}
					}
				});
				//탭 > 그리드
				LayoutContainer lcRightTab = new LayoutContainer();
				//lcRightTab.setSize(620, 180);
				lcRightTab.setSize(620, 195);


				//그리드
			    //1.고용
				tabitem10 = new TabItem("고용");
				tabitem10.setId("tabitem10");
				tabitem10.setStyleAttribute("padding", "2px");
				tabitem10.add(StdData10(), new FormData("100%"));
				//tabitem10.setScrollMode(Scroll.AUTO);
				tabitem10.setBorders(false);
				tabPanel.add(tabitem10);
				/*tabitem10.addListener(Events.Select, new Listener<ComponentEvent>() {
					public void handleEvent(ComponentEvent e) {
						reloadRightGrid1();
					}
				});*/
				
				 //2.기간제고용-공무직일경우에 활성화 
				tabitem20 = new TabItem("기간제고용");
				tabitem20.setId("tabitem20");
				tabitem20.setStyleAttribute("padding", "2px");
				tabitem20.add(StdData20(), new FormData("100%"));
				//tabitem20.setScrollMode(Scroll.AUTO);
				tabitem20.setBorders(false);
				tabPanel.add(tabitem20);
				/*tabitem20.addListener(Events.Select, new Listener<ComponentEvent>() {
					public void handleEvent(ComponentEvent e) {
						reloadRightGrid1();
					}
				});*/

			    //2.경력
				tabitem30 = new TabItem("경력");
				tabitem30.setId("tabitem30");
				tabitem30.setStyleAttribute("padding", "2px");
				tabitem30.add(StdData30(), new FormData("100%"));
				//tabitem30.setScrollMode(Scroll.AUTO);
				tabitem30.setBorders(false);
				tabPanel.add(tabitem30);
				/*tabitem30.addListener(Events.Select, new Listener<ComponentEvent>() {
					public void handleEvent(ComponentEvent e) {
						reloadRightGrid2();

					}
				});*/


			    //3.징계
				tabitem40 = new TabItem("징계");
				tabitem40.setId("tabitem40");
				tabitem40.setStyleAttribute("padding", "2px");
				tabitem40.add(StdData40(), new FormData("100%"));
				tabitem40.setBorders(false);
				tabPanel.add(tabitem40);
				/*tabitem40.addListener(Events.Select, new Listener<ComponentEvent>() {
					public void handleEvent(ComponentEvent e) {
						reloadRightGrid3();

					}
				});
*/
				lcRightTab.add(tabPanel);
		return lcRightTab;
	}
	private  LayoutContainer leftGrid01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);  


		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false); 
		cp01.setHeaderVisible(false);   
		cp01.setLayout(new FitLayout());    
		//엣지변환
		//cp01.setSize(323, 425);
		cp01.setSize(323, 445);


		psnl0320GridPanelLeft = new MSFGridPanel(psnl0320DefLeft, false, false, false, false,false);
		psnl0320GridPanelLeft.setHeaderVisible(false);
		psnl0320GridPanelLeft.setBodyBorder(true);
		psnl0320GridPanelLeft.setBorders(true);


		final Grid psnl0320Grid = psnl0320GridPanelLeft.getMsfGrid().getGrid();
		//psnl0320Grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		

		psnl0320Grid.addListener(Events.CellDoubleClick,  new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {

				//Window.alert(""+psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString());
				
				//호봉재획정 버튼 클릭시 고용/경력/징계 정보를 읽어오기 위한 정보를 전역변수로 저장한다.
				dblClickDpobCd = psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dpobCd").toString();
				dblClickSystemkey = psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString();


				//Window.alert("더블클릭1.");
				if (psnl0320GridPanelLeft.getCurrentlySelectedItem() != null) {

					//성명
					if ( psnl0320GridPanelLeft.getCurrentlySelectedItem().get("hanNm") == null)
					{
						socnsrIssRegVal02.setValue("");
					}else
					{
						socnsrIssRegVal02.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("hanNm").toString());
					}


					//주민번호
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("resnRegnNum") == null)
					{
						socnsrIssRegVal03.setValue("");
					}else
					{
						socnsrIssRegVal03.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("resnRegnNum").toString());
					}


					//부서명
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("deptNm") == null)
					{
						deptNmHan.setValue("");
					}else
					{
						deptNmHan.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("deptNm").toString());
					}


					//직종
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("typOccuNm") == null)
					{
						detailTypOccuNm.setValue("");
					
					}else
					{
						detailTypOccuNm.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("typOccuNm").toString());
					}


					//직종세
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dtilOccuClsDivNm") == null)
					{
						detailDtilOccuInttnNm.setValue("");
					}else
					{
						detailDtilOccuInttnNm.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dtilOccuClsDivNm").toString());
					}


					//사업명
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("businNm") == null)
					{
						businNm.setValue("");
					}else
					{
						businNm.setValue(MSFSharedUtils.allowNulls(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("businNm").toString()));
					}


					//고용시작일자(입사일자)
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("emymtBgnnDt") == null)
					{
						emymtBgnnDt.setValue("");
					}else
					{
						emymtBgnnDt.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("emymtBgnnDt").toString());
					}


					//호봉재획정일자
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("reMrkDt") == null)
					{
						reMrkDt.setValue("");
					}else
					{
						reMrkDt.setValue(MSFSharedUtils.allowNulls(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("reMrkDt").toString()));
						//logStdDt.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("reMrkDt").toString());
					}

					//근속기준일(근속일)
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("logStdDt") == null)
					{
						logStdDt.setValue("");
					}else
					{
						logStdDt.setValue(MSFSharedUtils.allowNulls(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("logStdDt").toString()));
					}
					
					//호봉
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("pyspNm") == null)
					{
						pysd.setValue("");
					}else
					{
						pysd.setValue(MSFSharedUtils.allowNulls(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("pyspNm").toString()));
					}
					
					//근속년
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("logSvcYrNumNm") == null)
					{
						logSvcYrNumCd.setValue("");
					}else
					{
						logSvcYrNumCd.setValue(MSFSharedUtils.allowNulls(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("logSvcYrNumNm").toString()));
					}
					
					//근속월
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("logSvcMnthIcmNm") == null)
					{
						logSvcMnthNumCd.setValue("");
					}else
					{
						logSvcMnthNumCd.setValue(MSFSharedUtils.allowNulls(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("logSvcMnthIcmNm").toString()));
					}

					//입대일자
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("enrlntDt") == null)
					{
						enrlntDt.setValue("");
					}else
					{
						enrlntDt.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("enrlntDt").toString());
					}


					//제대일자
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dsageDt") == null)
					{
						dsageDt.setValue("");
					}else
					{
						dsageDt.setValue(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dsageDt").toString());
					}


					//복무인정기간
					if (psnl0320GridPanelLeft.getCurrentlySelectedItem().get("servcRcgtnPridCd") == null)
					{
						psnl0112ServcRcgtnPridCd.setValue(new BaseModel());	//복무인정기간
					}else
					{
						psnl0112ServcRcgtnPridCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112ServcRcgtnPridCd, psnl0320GridPanelLeft.getCurrentlySelectedItem().get("servcRcgtnPridCd").toString()));//복무인정기간
					}

					Date today = new Date();
					Calendar  intiCal = Calendar.getInstance();
					intiCal.set(Integer.parseInt(GWTUtils.getStringFromDate(today,"yyyy")), Integer.parseInt(GWTUtils.getStringFromDate(today,"MM"))-1, 01);
					reMrkCalcDt.setValue(intiCal.getTime());

					reloadRightGrid10();
					reloadRightGrid20();
					reloadRightGrid30();
					reloadRightGrid40();
					reloadButtomGrid();
					
					blank_a1.clear();
					blank_a2.clear();
					blank_a3.clear();
					blank_a4.clear();
				}
			}
		});  

		psnl0320Grid.addListener(Events.CellClick,  new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {

			}
		});

		
		Button btnSave = new Button("호봉확정");
		ButtonBar buttonBar =  new ButtonBar();  
		buttonBar.add(btnSave);
		
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {       
				savePsnl0100();
			}
		});
		
		
		ToolBar bottomToolbar = new ToolBar();
		bottomToolbar.add(buttonBar);  
		
		 bottomToolbar.add(new SeparatorMenuItem());


         Button refresh2 = new Button();
         refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
         refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
             public void componentSelected(ButtonEvent ce) {  
            	 psnl0320GridPanelLeft.reload();
             }  
         });		            
         bottomToolbar.add(refresh2);
		 
         btnSave.setStyleAttribute("paddingLeft", "200px");
         
      
		 
		psnl0320GridPanelLeft.setBottomComponent(bottomToolbar);
		
		cp01.add(psnl0320GridPanelLeft); 

		lcStdGrid.add(cp01);  
		return lcStdGrid;  
	}
	
	
	private LayoutContainer rightForm01() {

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ContentPanel cp_a = new ContentPanel();
		cp_a.setHeaderVisible(false);
		//엣지변환
		//cp_a.setSize(620, 100);
		cp_a.setSize(620, 120);


		LayoutContainer layoutContainer_a = new LayoutContainer(new ColumnLayout());
		layoutContainer_a.setBorders(false);
		layoutContainer_a.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_a1 = new LayoutContainer();
		layoutContainer_a1.setBorders(false);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a1.setLayout(frmlytStd);
		socnsrIssRegVal02 = new MSFTextField();
		socnsrIssRegVal02.setFieldLabel("성명");
		socnsrIssRegVal02.setReadOnly(true);
		layoutContainer_a1.add(socnsrIssRegVal02, new FormData("100%"));
		layoutContainer_a.add(layoutContainer_a1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));


		LayoutContainer layoutContainer_a2 = new LayoutContainer();
		layoutContainer_a2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a2.setLayout(frmlytStd);
		socnsrIssRegVal03 = new MSFTextField();
		socnsrIssRegVal03.setFieldLabel("주민번호");
		socnsrIssRegVal03.setReadOnly(true);
		layoutContainer_a2.add(socnsrIssRegVal03, new FormData("100%"));
		layoutContainer_a.add(layoutContainer_a2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_a, new FormData("100%"));


		LayoutContainer layoutContainer_a3 = new LayoutContainer();
		layoutContainer_a3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a3.setLayout(frmlytStd);
		deptNmHan = new MSFTextField();
		deptNmHan.setFieldLabel("부서명");
		deptNmHan.setReadOnly(true);
		layoutContainer_a3.add(deptNmHan, new FormData("100%"));
		layoutContainer_a.add(layoutContainer_a3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.40));
		cp_a.add(layoutContainer_a, new FormData("100%"));


		LayoutContainer layoutContainer_b = new LayoutContainer();
		layoutContainer_b.setBorders(false);
		layoutContainer_b.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_b1 = new LayoutContainer();
		layoutContainer_b1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_b1.setLayout(frmlytStd);
		detailTypOccuNm = new MSFTextField();
		detailTypOccuNm.setFieldLabel("직종");
		detailTypOccuNm.setReadOnly(true);
		layoutContainer_b1.add(detailTypOccuNm, new FormData("100%"));
		layoutContainer_b.add(layoutContainer_b1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_b, new FormData("100%"));


		LayoutContainer layoutContainer_b2 = new LayoutContainer();
		layoutContainer_b2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_b2.setLayout(frmlytStd);
		detailDtilOccuInttnNm = new MSFTextField();
		detailDtilOccuInttnNm.setReadOnly(true);
		detailDtilOccuInttnNm.setHideLabel(true);
		detailDtilOccuInttnNm.setFieldLabel("직종세");
		layoutContainer_b2.add(detailDtilOccuInttnNm, new FormData("100%"));
		layoutContainer_b.add(layoutContainer_b2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_b, new FormData("100%"));


		LayoutContainer layoutContainer_b3 = new LayoutContainer();
		layoutContainer_b3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_b3.setLayout(frmlytStd);
		businNm = new MSFTextField();
		businNm.setFieldLabel("사업명");
		businNm.setReadOnly(true);
		businNm.setHideLabel(false);
		layoutContainer_b3.add(businNm, new FormData("100%"));
		layoutContainer_b.add(layoutContainer_b3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_b, new FormData("100%"));


		LayoutContainer layoutContainer_b4 = new LayoutContainer();
		layoutContainer_b4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_b4.setLayout(frmlytStd);
		emymtBgnnDt = new MSFTextField();
		emymtBgnnDt.setFieldLabel("입사일자");
		emymtBgnnDt.setReadOnly(true);
		emymtBgnnDt.setHideLabel(false);
		emymtBgnnDt.setName("emymtBgnnDt");
		layoutContainer_b4.add(emymtBgnnDt, new FormData("100%"));
		layoutContainer_b.add(layoutContainer_b4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_b, new FormData("100%"));


		LayoutContainer layoutContainer_c = new LayoutContainer();
		layoutContainer_c.setBorders(false);
		layoutContainer_c.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_c1 = new LayoutContainer();
		layoutContainer_c1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_c1.setLayout(frmlytStd);
		reMrkDt = new MSFTextField();
		reMrkDt.setFieldLabel("재획정일자");
		reMrkDt.setReadOnly(true);
		reMrkDt.setHideLabel(false);
		layoutContainer_c1.add(reMrkDt, new FormData("100%"));
		layoutContainer_c.add(layoutContainer_c1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_c, new FormData("100%"));


		LayoutContainer layoutContainer_c2 = new LayoutContainer();
		layoutContainer_c2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_c2.setLayout(frmlytStd);
		logStdDt = new MSFTextField();
		logStdDt.setFieldLabel("근속기준일");
		logStdDt.setReadOnly(true);
		logStdDt.setHideLabel(false);
		layoutContainer_c2.add(logStdDt, new FormData("100%"));
		layoutContainer_c.add(layoutContainer_c2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_c, new FormData("100%"));


		LayoutContainer layoutContainer_c3 = new LayoutContainer();
		layoutContainer_c3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_c3.setLayout(frmlytStd);
		pysd = new MSFTextField();
		pysd.setFieldLabel("호봉");
		pysd.setReadOnly(true);
		pysd.setHideLabel(false);
		layoutContainer_c3.add(pysd, new FormData("100%"));
		layoutContainer_c.add(layoutContainer_c3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_c, new FormData("100%"));


		LayoutContainer layoutContainer_d = new LayoutContainer();
		layoutContainer_d.setBorders(false);
		layoutContainer_d.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_d1 = new LayoutContainer();
		layoutContainer_d1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_d1.setLayout(frmlytStd);
		logSvcYrNumCd = new MSFTextField();
		logSvcYrNumCd.setFieldLabel("근속년");
		logSvcYrNumCd.setReadOnly(true);
		logSvcYrNumCd.setHideLabel(false);
		layoutContainer_d1.add(logSvcYrNumCd, new FormData("100%"));
		layoutContainer_d.add(layoutContainer_d1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_d, new FormData("100%"));

		
		LayoutContainer layoutContainer_d2 = new LayoutContainer();
		layoutContainer_d2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_d2.setLayout(frmlytStd);
		logSvcMnthNumCd = new MSFTextField();
		logSvcMnthNumCd.setFieldLabel("근속월");
		logSvcMnthNumCd.setReadOnly(true);
		logSvcMnthNumCd.setHideLabel(false);
		layoutContainer_d2.add(logSvcMnthNumCd, new FormData("100%"));
		layoutContainer_d.add(layoutContainer_d2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		cp_a.add(layoutContainer_d, new FormData("100%"));


		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.add(cp_a);


		return layoutContainer;
	}

	private LayoutContainer rightForm02() {

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ContentPanel cp02 = new ContentPanel();
		cp02.setHeaderVisible(false);
		//엣지변환
		//cp02.setSize(600, 23);
		cp02.setSize(600, 33);


		LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());


		LayoutContainer layoutContainer_a1 = new LayoutContainer();
		layoutContainer_a1.setBorders(false);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a1.setLayout(frmlytStd);
		enrlntDt = new MSFTextField();
		enrlntDt.setFieldLabel("입대일자");
		enrlntDt.setReadOnly(true);
		enrlntDt.setHideLabel(false);
		layoutContainer_a1.add(enrlntDt, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));
		cp02.add(layoutContainer_6);


		LayoutContainer layoutContainer_a2 = new LayoutContainer();
		layoutContainer_a2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a2.setLayout(frmlytStd);
		dsageDt = new MSFTextField();
		dsageDt.setFieldLabel("제대일자");
		dsageDt.setReadOnly(true);
		dsageDt.setHideLabel(false);
		layoutContainer_a2.add(dsageDt, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));
		cp02.add(layoutContainer_6);


		LayoutContainer layoutContainer_a3 = new LayoutContainer();
		layoutContainer_a3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a3.setLayout(frmlytStd);
		//servcRcgtnPrid = new MSFMultiComboBox<ModelData>();
		psnl0112ServcRcgtnPridCd = new MSFComboBox<BaseModel>();
		psnl0112ServcRcgtnPridCd.setFieldLabel("복무인정기간");
		psnl0112ServcRcgtnPridCd.setForceSelection(true);
		psnl0112ServcRcgtnPridCd.setMinChars(1);
		psnl0112ServcRcgtnPridCd.setDisplayField("commCdNm");
		psnl0112ServcRcgtnPridCd.setValueField("commCd");
		psnl0112ServcRcgtnPridCd.setTriggerAction(TriggerAction.ALL);
		psnl0112ServcRcgtnPridCd.setEmptyText("--복무인정기간선택--");
		psnl0112ServcRcgtnPridCd.setSelectOnFocus(true);
		psnl0112ServcRcgtnPridCd.setStore(listStoreA029);
		layoutContainer_a3.add(psnl0112ServcRcgtnPridCd, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.30));
		cp02.add(layoutContainer_6);


		LayoutContainer layoutContainer_a4 = new LayoutContainer();
		layoutContainer_a4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a4.setLayout(frmlytStd);
		reMrkCalcDt = new MSFDateField();
		reMrkCalcDt.setFieldLabel("계산기준일");
		new DateFieldMask(reMrkCalcDt, "9999.99.99");
		reMrkCalcDt.setReadOnly(false);
		reMrkCalcDt.setHideLabel(false);
		reMrkCalcDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer_a4.add(reMrkCalcDt, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		cp02.add(layoutContainer_6);


		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.add(cp02);


		return layoutContainer;
	}

	private LayoutContainer rightForm03() {

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ContentPanel cp020 = new ContentPanel();
		cp020.setHeaderVisible(false);
		//엣지변환
		//cp020.setSize(600, 23);
		cp020.setSize(600, 33);


		LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());


		LayoutContainer layoutContainer_a1 = new LayoutContainer();
		layoutContainer_a1.setBorders(false);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a1.setLayout(frmlytStd);
		blank_a1 = new MSFTextField();
		blank_a1.setFieldLabel("호봉");
		blank_a1.setReadOnly(true);
		blank_a1.setHideLabel(false);
		blank_a1.setWidth(40);
		layoutContainer_a1.add(blank_a1, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		cp020.add(layoutContainer_6);


		LayoutContainer layoutContainer_a2 = new LayoutContainer();
		layoutContainer_a2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a2.setLayout(frmlytStd);
		blank_a2 = new MSFTextField();
		blank_a2.setFieldLabel("근속년수");
		blank_a2.setReadOnly(true);
		blank_a2.setHideLabel(false);
		blank_a2.setWidth(40);
		layoutContainer_a2.add(blank_a2, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		cp020.add(layoutContainer_6);


		LayoutContainer layoutContainer_a3 = new LayoutContainer();
		layoutContainer_a3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a3.setLayout(frmlytStd);
		blank_a3 = new MSFTextField();
		blank_a3.setFieldLabel("근속월수");
		blank_a3.setReadOnly(true);
		blank_a3.setHideLabel(false);
		blank_a3.setWidth(40);
		layoutContainer_a3.add(blank_a3, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		cp020.add(layoutContainer_6);


		LayoutContainer layoutContainer_a4 = new LayoutContainer();
		layoutContainer_a4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a4.setLayout(frmlytStd);
		blank_a4 = new MSFTextField();
		blank_a4.setFieldLabel("근속일수");
		blank_a4.setReadOnly(true);
		blank_a4.setHideLabel(false);
		blank_a4.setWidth(40);
		layoutContainer_a4.add(blank_a4, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_a4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		cp020.add(layoutContainer_6);


		LayoutContainer layoutContainer_a5 = new LayoutContainer();
		layoutContainer_a5.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a5.setLayout(frmlytStd);
		
	    btnSave1 = new Button("호봉재획정");
		btnSave1.setWidth(60);
		layoutContainer_a5.add(btnSave1, new FormData("100%"));
		btnSave1.setIcon(MSFMainApp.ICONS.save16());
		btnSave1.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {			
				savePsnl0320();
			}
		});
		
		

		layoutContainer_6.add(layoutContainer_a5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		cp020.add(layoutContainer_6);
		

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.add(cp020);


		return layoutContainer;
	}

	//   고용 탭 시작
	private LayoutContainer StdData10() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);
		LayoutContainer lcTabFormLayer = new LayoutContainer();


		ContentPanel cp01 = new ContentPanel();
		cp01.setSize(614, 190);
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());

       // MSFCustomForm msfCustomForm = new MSFCustomForm(psnl0320DefRight10, 0, 0, false, false,false);
       // msfCustomForm.setHeaderVisible(false);
		psnl0320GridPanelRight10 = new MSFGridPanel(psnl0320DefRight10, false, false, false, false,false);
		psnl0320GridPanelRight10.getBottomComponent().setVisible(false);
		psnl0320GridPanelRight10.setHeaderVisible(false);
		psnl0320GridPanelRight10.setBodyBorder(true);
		psnl0320GridPanelRight10.setBorders(true);

		//psnl0320GridPanelRight10.setMSFFormPanel(msfCustomForm);
		
/*        final Grid psnl0320GridRight10 = psnl0320GridPanelRight10.getMsfGrid().getGrid();
        psnl0320GridRight10.addListener(Events.RowClick,  new Listener<BaseEvent>() {
			  public void handleEvent(BaseEvent be) {
				  if (psnl0320GridPanelRight10.getCurrentlySelectedItem() != null) {
					  psnl0320GridPanelRight10.setGridRowFormBind(psnl0320GridPanelRight10.getCurrentlySelectedItem());
					 // setRecord(psnl0320GridPanelRight10.getCurrentlySelectedItem());
				  }
			  }
		  });*/
		
		cp01.add(psnl0320GridPanelRight10);
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0320GridPanelRight10.getGrid().getSelectionModel().getSelectedItem() != null ) {		
						MessageBox.confirm("고용 저장", "고용정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									saveRightGrid10();
								}
							}
						});					
				}else{
					
					Window.alert("변경된 사항이 없습니다.");
				}
			}
		}));
		

		lcTabFormLayer.add(cp01);
		

		return lcTabFormLayer;
	}
	
	
	//   기간제 고용 탭 시작
		private LayoutContainer StdData20() {

			LayoutContainer lcStdGrid = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();    
			lcStdGrid.setLayout(frmlytStd);
			LayoutContainer lcTabFormLayer = new LayoutContainer();


			ContentPanel cp01 = new ContentPanel();
			cp01.setSize(614, 190);
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());

	       // MSFCustomForm msfCustomForm = new MSFCustomForm(psnl0320DefRight10, 0, 0, false, false,false);
	       // msfCustomForm.setHeaderVisible(false);
			psnl0320GridPanelRight20 = new MSFGridPanel(psnl0320DefRight20, false, false, false, false,false);
			psnl0320GridPanelRight20.getBottomComponent().setVisible(false);
			psnl0320GridPanelRight20.setHeaderVisible(false);
			psnl0320GridPanelRight20.setBodyBorder(true);
			psnl0320GridPanelRight20.setBorders(true);

			//psnl0320GridPanelRight20.setMSFFormPanel(msfCustomForm);
			
	/*        final Grid psnl0320GridRight20 = psnl0320GridPanelRight10.getMsfGrid().getGrid();
	        psnl0320GridRight20.addListener(Events.RowClick,  new Listener<BaseEvent>() {
				  public void handleEvent(BaseEvent be) {
					  if (psnl0320GridPanelRight20.getCurrentlySelectedItem() != null) {
						  psnl0320GridPanelRight20.setGridRowFormBind(psnl0320GridPanelRight10.getCurrentlySelectedItem());
						 // setRecord(psnl0320GridPanelRight20.getCurrentlySelectedItem());
					  }
				  }
			  });*/
			
			cp01.add(psnl0320GridPanelRight20);
			cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					if(psnl0320GridPanelRight20.getGrid().getSelectionModel().getSelectedItem() != null ) {		
							MessageBox.confirm("고용 저장", "고용정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
								@Override
								public void handleEvent(MessageBoxEvent be) {
									if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
										saveRightGrid20();
									}
								}
							});					
					}else{
						
						Window.alert("변경된 사항이 없습니다.");
					}
				}
			}));
			

			lcTabFormLayer.add(cp01);
			

			return lcTabFormLayer;
		}

	//   경력 탭 시작
	private LayoutContainer StdData30() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);
		LayoutContainer lcTabFormLayer = new LayoutContainer();


		ContentPanel cp01 = new ContentPanel();
		cp01.setSize(614, 190);
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());


		psnl0320GridPanelRight30 = new MSFGridPanel(psnl0320DefRight30, false, false, false, false,false);
		psnl0320GridPanelRight30.setHeaderVisible(false);
		psnl0320GridPanelRight30.setBodyBorder(true);
		psnl0320GridPanelRight30.setBorders(true);
		psnl0320GridPanelRight30.getBottomComponent().setVisible(false);


		cp01.add(psnl0320GridPanelRight30);
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			
			
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				
				
				if(psnl0320GridPanelRight30.getGrid().getSelectionModel().getSelectedItem() != null ) {
						MessageBox.confirm("경력 저장", "경력정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									saveRightGrid30();
								}
							}
						});					
				}else{
					
					Window.alert("변경된 사항이 없습니다.");
				}
			}
		}));
		lcTabFormLayer.add(cp01);


		return lcTabFormLayer;
	}


	//  징계 탭 시작
	private LayoutContainer StdData40() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);
		LayoutContainer lcTabFormLayer = new LayoutContainer();


		ContentPanel cp01 = new ContentPanel();
		cp01.setSize(614, 190);
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());


		psnl0320GridPanelRight40 = new MSFGridPanel(psnl0320DefRight40, false, false, false, false,false);
		psnl0320GridPanelRight40.setHeaderVisible(false);
		psnl0320GridPanelRight40.setBodyBorder(true);
		psnl0320GridPanelRight40.setBorders(true);
		psnl0320GridPanelRight40.getBottomComponent().setVisible(false);


		cp01.add(psnl0320GridPanelRight40);
		
		
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0320GridPanelRight40.getGrid().getSelectionModel().getSelectedItem() != null ) {
						MessageBox.confirm("징계 저장", "징계정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									saveRightGrid40();
								}
							}
						});
				}else{
					
					Window.alert("변경된 사항이 없습니다.");
				}
			}
		})); 
		
		lcTabFormLayer.add(cp01); 

		return lcTabFormLayer;
	}

	private  LayoutContainer bottomGrid01() {
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);


		ContentPanel cp01 = new ContentPanel();
		cp01.setSize(960, 200);
		cp01.setScrollMode(Scroll.AUTO);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());


		psnl0320GridPanelBottom = new MSFGridPanel(psnl0320DefButtom, false, false, false, false,false);
		psnl0320GridPanelBottom.setScrollMode(Scroll.AUTO);
		psnl0320GridPanelBottom.setHeaderVisible(false);  
		psnl0320GridPanelBottom.setBodyBorder(true);
		psnl0320GridPanelBottom.setBorders(true);
		

		final Grid psnl0320GridBottom = psnl0320GridPanelBottom.getMsfGrid().getGrid();
		psnl0320GridBottom.setSize(920, 80);

	
		
		
		psnl0320GridPanelBottom.getGrid().getColumnModel().addHeaderGroup(0, 14, new HeaderGroupConfig("고용인정", 1, 3));
		psnl0320GridPanelBottom.getGrid().getColumnModel().addHeaderGroup(0, 17, new HeaderGroupConfig("군경력인정", 1, 3));
		psnl0320GridPanelBottom.getGrid().getColumnModel().addHeaderGroup(0, 20, new HeaderGroupConfig("경력인정", 1, 3));
		

		
		cp01.add(psnl0320GridPanelBottom); 
//		cp01.addButton(new Button("상실신고내역보기", new SelectionListener<ButtonEvent>() {   
//			@Override  
//			public void componentSelected(ButtonEvent ce) {
//
//			}   
//		}));  
		
		
		
		
		lcStdGrid.add(cp01);  
		
		
		
		
		return lcStdGrid;  
	}


	public void resetForm(){
		IColumnFilter filters = null;
		psnl0320GridPanelRight10.getMsfGrid().clearData();
		psnl0320GridPanelRight10.getTableDef().setTableColumnFilters(filters);

		psnl0320GridPanelRight20.getMsfGrid().clearData();
		psnl0320GridPanelRight20.getTableDef().setTableColumnFilters(filters);

		
		psnl0320GridPanelRight30.getMsfGrid().clearData();
		psnl0320GridPanelRight30.getTableDef().setTableColumnFilters(filters);


		psnl0320GridPanelRight40.getMsfGrid().clearData();
		psnl0320GridPanelRight40.getTableDef().setTableColumnFilters(filters);


		psnl0320GridPanelBottom.getMsfGrid().clearData();
		psnl0320GridPanelBottom.getTableDef().setTableColumnFilters(filters);


		socnsrIssRegVal02.clear(); //성명
		socnsrIssRegVal03.clear(); //주민번호
		deptNmHan.clear(); //부서명
		detailTypOccuNm.clear(); //직종
		detailDtilOccuInttnNm.clear(); //직종세
		businNm.clear(); //사업명
		emymtBgnnDt.clear(); //고용시작일자(입사일자)
		reMrkDt.clear(); //호봉재획정일자
		logStdDt.clear(); //근속기준일
		pysd.clear(); //호봉
		logSvcYrNumCd.clear(); //근속년
		logSvcMnthNumCd.clear(); //근속월
		enrlntDt.clear(); //입대일자
		dsageDt.clear(); //제대일자


		systemKeys = "";
	}

	//엑셀 저장
	private void excelFileExport(String flag) {

		HashMap<String, String> param = new HashMap<String, String>(); 

		if(null != flag && !flag.equals("")) param.put("gubun",  flag);


		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());


		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = psnl0320GridPanelBottom.getGrid().getSelectionModel().getSelectedItems();


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


		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		//단위기관
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));


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
		psnl0320GridPanelBottom.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2300Export.do","extgwtFrame" ,param);
	}

	//고용탭 저장
	private void saveRightGrid10() {


	//	Window.alert("x");
		
		final List<Psnl0320DTO> listPsnl0320dto = new ArrayList<Psnl0320DTO>();
		Iterator<Record> iterRecords = psnl0320GridPanelRight10.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();


		while (iterRecords.hasNext())
		{
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			Psnl0320DTO psnl0320dto = new Psnl0320DTO();


			psnl0320dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));//사업장코드 : dpobCd
			psnl0320dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));//SYSTEMKEY : systemkey
			psnl0320dto.setEmymtSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("emymtSeilNum")));//고용일련번호 : emymtSeilNum
			psnl0320dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));//고용구분코드 : emymtDivCd
			psnl0320dto.setEmymtTypCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtTypCd")));//고용유형코드 : emymtTypCd
			psnl0320dto.setEmymtBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("emymtBgnnDt"),"yyyyMMdd"));//고용시작일자(입사일자) : emymtBgnnDt


			Date today = new Date();
			String sToday = GWTUtils.getStringFromDate(today,"yyyyMMdd");


			String sEmymtEndDt = new String();


			//고용종료일자가 현재날짜보다 작으면 종료일자를 사용
			if (bmMapModel.get("emymtEndDt") != null)
			{
				if(Integer.parseInt(GWTUtils.getStringFromDate((Date)bmMapModel.get("emymtEndDt"),"yyyyMMdd")) < Integer.parseInt(sToday))
				{
					sEmymtEndDt = GWTUtils.getStringFromDate((Date)bmMapModel.get("emymtEndDt"),"yyyyMMdd");
				}else{
					sEmymtEndDt = sToday;
				}

				//고용종료일자가 현재날짜보다 큰경우에 대한 로직이 없음.
			}
			//고용종료일자가 없으면 계산기준일이 있는 달의 1일을 사용
			else if(bmMapModel.get("emymtEndDt") == null)
			{
				//sEmymtEndDt = GWTUtils.getStringFromDate(intiCal.getTime(),"yyyyMMdd");//계산기준일이 있는 달의 1일을 사용
				sEmymtEndDt = GWTUtils.getStringFromDate(reMrkCalcDt.getValue(),"yyyyMMdd");
			}
			psnl0320dto.setEmymtEndDt(sEmymtEndDt);
			psnl0320dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));//부서 : deptCd
			psnl0320dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));//직종 : typOccuCd
			psnl0320dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));//직종세 : dtilOccuInttnCd
			psnl0320dto.setCvsnRtoDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("cvsnRtoDivCd$commCd")));//경력인정(환산비율) : cvsnRtoDivCd
			
			listPsnl0320dto.add(psnl0320dto);
		}

		psnl0320Service.updatePsnl0110(listPsnl0320dto, new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				//MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught), null);
				Window.alert(MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught));
			}
			@Override
			public void onSuccess(Long result) {
				if (result == 1)
				{
					reloadRightGrid10();					
				} else
				{
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} 
			}
		}); 
	}

	//기간제 고용탭 저장
		private void saveRightGrid20() {


		//	Window.alert("x");
			
			final List<Psnl0320DTO> listPsnl0320dto = new ArrayList<Psnl0320DTO>();
			Iterator<Record> iterRecords = psnl0320GridPanelRight20.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();


			while (iterRecords.hasNext())
			{
				Record recData = (Record) iterRecords.next(); 
				BaseModel bmMapModel = (BaseModel)recData.getModel();
				Psnl0320DTO psnl0320dto = new Psnl0320DTO();


				psnl0320dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));//사업장코드 : dpobCd
				psnl0320dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));//SYSTEMKEY : systemkey
				psnl0320dto.setEmymtSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("emymtSeilNum")));//고용일련번호 : emymtSeilNum
				psnl0320dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));//고용구분코드 : emymtDivCd
				psnl0320dto.setEmymtTypCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtTypCd")));//고용유형코드 : emymtTypCd
				psnl0320dto.setEmymtBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("emymtBgnnDt"),"yyyyMMdd"));//고용시작일자(입사일자) : emymtBgnnDt


				Date today = new Date();
				String sToday = GWTUtils.getStringFromDate(today,"yyyyMMdd");


				String sEmymtEndDt = new String();


				//고용종료일자가 현재날짜보다 작으면 종료일자를 사용
				if (bmMapModel.get("emymtEndDt") != null)
				{
					if(Integer.parseInt(GWTUtils.getStringFromDate((Date)bmMapModel.get("emymtEndDt"),"yyyyMMdd")) < Integer.parseInt(sToday))
					{
						sEmymtEndDt = GWTUtils.getStringFromDate((Date)bmMapModel.get("emymtEndDt"),"yyyyMMdd");
					}else{
						sEmymtEndDt = sToday;
					}

					//고용종료일자가 현재날짜보다 큰경우에 대한 로직이 없음.
				}
				//고용종료일자가 없으면 계산기준일이 있는 달의 1일을 사용
				else if(bmMapModel.get("emymtEndDt") == null)
				{
					//sEmymtEndDt = GWTUtils.getStringFromDate(intiCal.getTime(),"yyyyMMdd");//계산기준일이 있는 달의 1일을 사용
					sEmymtEndDt = GWTUtils.getStringFromDate(reMrkCalcDt.getValue(),"yyyyMMdd");
				}
				psnl0320dto.setEmymtEndDt(sEmymtEndDt);
				psnl0320dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));//부서 : deptCd
				psnl0320dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));//직종 : typOccuCd
				psnl0320dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));//직종세 : dtilOccuInttnCd
				psnl0320dto.setCvsnRtoDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("cvsnRtoDivCd$commCd")));//경력인정(환산비율) : cvsnRtoDivCd
				
				listPsnl0320dto.add(psnl0320dto);
			}

			psnl0320Service.updatePsnl0110(listPsnl0320dto, new AsyncCallback<Long>() {

				@Override
				public void onFailure(Throwable caught) {
					//MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught), null);
					Window.alert(MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught));
				}
				@Override
				public void onSuccess(Long result) {
					if (result == 1)
					{
						reloadRightGrid20();					
					} else
					{
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} 
				}
			}); 
		}
	//경력탭 저장
	private void saveRightGrid30() {
		
		final List<Psnl0119DTO> listPsnl0119dto = new ArrayList<Psnl0119DTO>();
		Iterator<Record> iterRecords2 = psnl0320GridPanelRight30.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
		
		

		while (iterRecords2.hasNext())
		{
			
			Record recData = (Record) iterRecords2.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			Psnl0119DTO psnl0119dto = new Psnl0119DTO();

			psnl0119dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));//사업장코드 : dpobCd
			psnl0119dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));//SYSTEMKEY : systemkey
			psnl0119dto.setCarrRsptSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("carrRsptSeilNum")));//경력사항일련번호 : carrRsptSeilNum
			psnl0119dto.setCarrBgnnDt((Date)bmMapModel.get("carrBgnnDt"));//경력시작일자(근무시작일자) : carrBgnnDt
			psnl0119dto.setCarrEndDt((Date)bmMapModel.get("carrEndDt"));//경력종료일자(근무종료일자) : carrEndDt			 			                                 
			psnl0119dto.setAjmtMnthNum(MSFSharedUtils.allowNulls( bmMapModel.get("ajmtMnthNum")));//가감월수         
			Date today = new Date();			
			String sToday = GWTUtils.getStringFromDate(today,"yyyyMMdd");	

			String sCarrEndDt = new String();
			
			if (bmMapModel.get("carrEndDt") != null)
			{
				if(Integer.parseInt(GWTUtils.getStringFromDate((Date)bmMapModel.get("carrEndDt"),"yyyyMMdd")) < Integer.parseInt(sToday))
				{
					sCarrEndDt = GWTUtils.getStringFromDate((Date)bmMapModel.get("carrEndDt"),"yyyyMMdd");
				}else{
					sCarrEndDt = sToday;
				}
				//경력종료일자(근무종료일자) 현재날짜보다 큰경우에 대한 로직이 없음.
			}
			//경력종료일자(근무종료일자) 없으면 계산기준일이 있는 달의 1일을 사용
			else if(bmMapModel.get("carrEndDt") == null)
			{
				//Calendar  intiCal = Calendar.getInstance();
				//intiCal.set(Integer.parseInt(GWTUtils.getStringFromDate(today,"yyyy")), Integer.parseInt(GWTUtils.getStringFromDate(today,"MM"))-1, 01);
				//sEmymtEndDt = GWTUtils.getStringFromDate(intiCal.getTime(),"yyyyMMdd");//계산기준일이 있는 달의 1일을 사용
				sCarrEndDt = reMrkCalcDt.getValue().toString();
			}


			psnl0119dto.setDutyDeptNm(MSFSharedUtils.allowNulls(bmMapModel.get("dutyDeptNm")));//근무부서명(부서명) : dutyDeptNm
			psnl0119dto.setCarrDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("carrDivCd")));//경력구분코드 : carrDivCd
			psnl0119dto.setRepbtyBusinNm(MSFSharedUtils.allowNulls(bmMapModel.get("repbtyBusinNm")));//담당업무명 : repbtyBusinNm
			psnl0119dto.setCvsnRtoDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("cvsnRtoDivCd$commCd")));//경력인정(환산비율) : cvsnRtoDivCd
			psnl0119dto.setDutyYrNum(MSFSharedUtils.allowNulls(bmMapModel.get("dutyYrNum")));//근무년수 : dutyYrNum
			psnl0119dto.setDutyMnthIcm(MSFSharedUtils.allowNulls(bmMapModel.get("dutyMnthIcm")));//근무월수 : dutyMnthIcm
			/*근무일수????*/
			psnl0119dto.setRcgtnMnthNum(MSFSharedUtils.allowNulls(bmMapModel.get("rcgtnMnthNum")));//인정월수 : rcgtnMnthNum

			listPsnl0119dto.add(psnl0119dto);
		}

		
		psnl0320Service.updatePsnl0119(listPsnl0119dto, new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				//MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught), null);
				Window.alert(MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught));
			}


			@Override
			public void onSuccess(Long result) {
				// TODO Auto-generated method stub
				if (result == 1)
				{
					reloadRightGrid30();		
					//Window.alert("저장되었습니다.");
				} else
				{
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} 
			}
		});
	}

	//징계탭 저장
	private void saveRightGrid40() {
		final List<Psnl0122DTO> listPsnl0122dto = new ArrayList<Psnl0122DTO>();
		Iterator<Record> iterRecords = psnl0320GridPanelRight40.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();


		while (iterRecords.hasNext())
		{
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			Psnl0122DTO psnl0122dto = new Psnl0122DTO();


			psnl0122dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));//사업장코드 : dpobCd
			psnl0122dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));//SYSTEMKEY : systemkey
			psnl0122dto.setDsnyActSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActSeilNum")));//징계일련번호 : dsnyActSeilNum
			psnl0122dto.setDsnyActDsplDt((Date)bmMapModel.get("dsnyActDsplDt"));//징계처분일자 : dsnyActDsplDt
			psnl0122dto.setDsnyActDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActDivCd")));//징계구분코드 : dsnyActDivCd
			psnl0122dto.setDsnyActNm(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActNm")));//징계명 : dsnyActNm
			psnl0122dto.setDsnyActReasCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActReasCtnt")));//징계사유내용 : dsnyActReasCtnt
			psnl0122dto.setDsnyActEctgOrgn(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActEctgOrgn")));//징계수행기관(시행기관) : dsnyActEctgOrgn
			psnl0122dto.setDsnyActBgnnDt((Date)bmMapModel.get("dsnyActBgnnDt"));//징계시작일자 : dsnyActBgnnDt
			psnl0122dto.setDsnyActEndDt((Date)bmMapModel.get("dsnyActEndDt"));//징계종료일자 : dsnyActEndDt
			psnl0122dto.setDsnyActAnstyDt((Date)bmMapModel.get("dsnyActAnstyDt"));//징계사면일자 : dsnyActAnstyDt
			psnl0122dto.setDsnyActCtwpMnthIcm(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActCtwpMnthIcm")));

			listPsnl0122dto.add(psnl0122dto);
		}


		psnl0320Service.updatePsnl0122(listPsnl0122dto, new AsyncCallback<Long>() {


			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				//MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught), null);
				Window.alert(MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught));
			}


			@Override
			public void onSuccess(Long result) {
				// TODO Auto-generated method stub
				if (result == 0)
				{
					//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					Window.alert("저장되었습니다.");
				} else
				{
					//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
					//yeta300ToYeta2000Detail(yeta300ToYeta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					//reFresh("itemYeta01");
					//reFresh();
				} 
			}
		});
	}

	private void savePsnl0320() {
		 
		final Psnl0320DTO Psnl0320dto = new Psnl0320DTO();
		Psnl0320dto.setDpobCd(dblClickDpobCd);
		Psnl0320dto.setSystemkey(dblClickSystemkey);
		Psnl0320dto.setPyspReMrkCalcDt(GWTUtils.getStringFromDate(reMrkCalcDt.getValue(),"yyyyMMdd"));//탭상단계산기준일
		Psnl0320dto.setServcRcgtnPridCd(MSFSharedUtils.getSelectedComboValue(psnl0112ServcRcgtnPridCd,"commCd"));
		psnl0320Service.savePsnl0320(Psnl0320dto, new AsyncCallback<Psnl0320DTO>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught));
			}

			@Override
			public void onSuccess(Psnl0320DTO result) {
				// TODO Auto-generated method stub
				if (result == null)
				{
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else
				{
							
					blank_a1.setValue(result.getPyspCd());
					blank_a2.setValue(result.getLogSvcYrNumCd());
					blank_a3.setValue(result.getLogSvcMnthIcmCd());
					blank_a4.setValue(result.getLogSvcDys());
					
					pyspReMrkSeilNum = new String();
					pyspReMrkSeilNum = result.getPyspReMrkSeilNum();
					mityCarrTotLogSvcDys = new String();
					mityCarrTotLogSvcDys = result.getMityCarrTotLogSvcDys();
					 
					
					reloadButtomGrid();
					psnl0320Loader.load();
				} 
			}
		});
	}
	
	private void savePsnl0100() {
		final Psnl0320DTO Psnl0320dto = new Psnl0320DTO();
		Psnl0320dto.setDpobCd(dblClickDpobCd);
		Psnl0320dto.setSystemkey(dblClickSystemkey);
		
		if(pyspReMrkSeilNum == null || pyspReMrkSeilNum.equals("")){
			Window.alert("호봉재획정후 저장하세요");
			return;
		}else{
		Psnl0320dto.setPyspReMrkSeilNum(pyspReMrkSeilNum);
		//Psnl0320dto.setPyspReMrkCalcDt(GWTUtils.getStringFromDate(reMrkCalcDt.getValue(),"yyyyMMdd"));//탭상단계산기준일
		
		//Window.alert(""+mityCarrTotLogSvcDys);
		
		Psnl0320dto.setMityCarrTotLogSvcDys(mityCarrTotLogSvcDys);
		
		psnl0320Service.updatePsnl0100(Psnl0320dto, new AsyncCallback<Psnl0320DTO>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught));
			}

			@Override
			public void onSuccess(Psnl0320DTO result) {
				// TODO Auto-generated method stub
				if (result == null)
				{
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else
				{			
					reMrkDt.setValue(result.getReMrkDt());
					logStdDt.setValue(result.getLogStdBgnDt());
					pysd.setValue(result.getPyspCd());
					logSvcYrNumCd.setValue(result.getLogSvcYrNumCd());
					logSvcMnthNumCd.setValue(result.getLogSvcMnthIcmCd());
					
					Window.alert("호봉확정 완료");
					
					reload();
				} 
			}
		});
		
		}
	}


	public void reload() {
		// TODO Auto-generated method stub

		IColumnFilter filters = null;
		psnl0320GridPanelLeft.getMsfGrid().clearData();
		psnl0320GridPanelLeft.getTableDef().setTableColumnFilters(filters);

		psnl0320GridPanelLeft.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
	
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue()))
		{
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for (int i=0; i<ray.length; i++)
			{ 
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd")+","; 
			}
			strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		}
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);       
		String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);

		//20180305추가 
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		
				
		String strTypOccuCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(searchName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		psnl0320GridPanelLeft.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(searchResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
		psnl0320GridPanelLeft.reload();
		
		blank_a1.clear();
		blank_a2.clear();
		blank_a3.clear();
		blank_a4.clear();
	}


	public void reloadRightGrid10() {

		IColumnFilter filters = null;

		psnl0320GridPanelRight10.getMsfGrid().clearData();
		psnl0320GridPanelRight10.getTableDef().setTableColumnFilters(filters);		
		psnl0320GridPanelRight10.getTableDef().addColumnFilter("systemkey", dblClickSystemkey, SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight10.getTableDef().addColumnFilter("dpobCd", dblClickDpobCd, SimpleColumnFilter.OPERATOR_EQUALS);
		//psnl0320GridPanelRight10.getTableDef().addColumnFilter("systemkey", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString(), SimpleColumnFilter.OPERATOR_EQUALS);		
		//psnl0320GridPanelRight10.getTableDef().addColumnFilter("dpobCd", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dpobCd").toString(), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight10.reload();
	}
	
	public void reloadRightGrid20() {

		IColumnFilter filters = null;

		psnl0320GridPanelRight20.getMsfGrid().clearData();
		psnl0320GridPanelRight20.getTableDef().setTableColumnFilters(filters);		
		psnl0320GridPanelRight20.getTableDef().addColumnFilter("systemkey", dblClickSystemkey, SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight20.getTableDef().addColumnFilter("dpobCd", dblClickDpobCd, SimpleColumnFilter.OPERATOR_EQUALS);
		//psnl0320GridPanelRight20.getTableDef().addColumnFilter("systemkey", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString(), SimpleColumnFilter.OPERATOR_EQUALS);		
		//psnl0320GridPanelRight20.getTableDef().addColumnFilter("dpobCd", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dpobCd").toString(), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight20.reload();
	}

	public void reloadRightGrid30() {

		//Window.alert(psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString());
		IColumnFilter filters = null;
		psnl0320GridPanelRight30.getMsfGrid().clearData();
		psnl0320GridPanelRight30.getTableDef().setTableColumnFilters(filters);
		psnl0320GridPanelRight30.getTableDef().addColumnFilter("systemkey", dblClickSystemkey, SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight30.getTableDef().addColumnFilter("dpobCd", dblClickDpobCd, SimpleColumnFilter.OPERATOR_EQUALS);
		//psnl0320GridPanelRight30.getTableDef().addColumnFilter("systemkey", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString(), SimpleColumnFilter.OPERATOR_EQUALS);
		//psnl0320GridPanelRight30.getTableDef().addColumnFilter("dpobCd", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dpobCd").toString(), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight30.reload();
	}

	public void reloadRightGrid40() {

		IColumnFilter filters = null;
		psnl0320GridPanelRight40.getMsfGrid().clearData();
		psnl0320GridPanelRight40.getTableDef().setTableColumnFilters(filters);
		psnl0320GridPanelRight40.getTableDef().addColumnFilter("systemkey", dblClickSystemkey, SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelRight40.getTableDef().addColumnFilter("dpobCd", dblClickDpobCd, SimpleColumnFilter.OPERATOR_EQUALS);
		//psnl0320GridPanelRight40.getTableDef().addColumnFilter("systemkey", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("systemkey").toString(), SimpleColumnFilter.OPERATOR_EQUALS);
		//psnl0320GridPanelRight40.getTableDef().addColumnFilter("dpobCd", psnl0320GridPanelLeft.getCurrentlySelectedItem().get("dpobCd").toString(), SimpleColumnFilter.OPERATOR_EQUALS);


		psnl0320GridPanelRight40.reload();
	}

	public void reloadButtomGrid() {

		IColumnFilter filters = null;
		psnl0320GridPanelBottom.getMsfGrid().clearData();
		psnl0320GridPanelBottom.getTableDef().setTableColumnFilters(filters);
		psnl0320GridPanelBottom.getTableDef().addColumnFilter("systemkey", dblClickSystemkey, SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0320GridPanelBottom.getTableDef().addColumnFilter("dpobCd", dblClickDpobCd, SimpleColumnFilter.OPERATOR_EQUALS);

		
		psnl0320GridPanelBottom.reload();
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
	
	
	//엑셀 저장
			private void excelFileExport() {		                     
				HashMap<String, String> param = new HashMap<String, String>(); 
				
				systemKeys = new String();
				systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
				
				//그리드 선택 데이터 출력
				String checkedSystemKeys = "";
				int keyCnt = 0;
				List<BaseModel> list = psnl0320GridPanelLeft.getGrid().getSelectionModel().getSelectedItems();

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
				
				
				param.put("srhLogStdDt",  GWTUtils.getStringFromDate(srhLogStdDt.getValue(),"yyyyMMdd")); 			
				param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		//단위기관
				param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));		//관리부서
				param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
				param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
			    param.put("deptCd", PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
				param.put("typOccuCd", PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
				param.put("dtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
				param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
				param.put("hanNm", MSFSharedUtils.allowNulls(searchName.getValue()));
				param.put("resnRegnNum", MSFSharedUtils.allowNulls(searchResnRegnNum.getValue()));    
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
			   
			   psnl0320GridPanelLeft.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFilePsnl0320Export.do","extgwtFrame" ,param);
			}
 
}