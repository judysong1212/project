package com.app.exterms.insurance.client.form;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr5400DTO;
import com.app.exterms.insurance.client.form.defs.Insr5400Def;
import com.app.exterms.insurance.client.service.Insr5400Service;
import com.app.exterms.insurance.client.service.Insr5400ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
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
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Insr5400  extends MSFPanel { 
 
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topInsr5400Bar; 
	private Button btnInsr5400Reset; 	// 초기화
	private Button btnInsr5400New; 		// 신규
	private Button btnInsr5400Save; 	// 저장
	private Button btnInsr5400Del; 		// 삭제
	private Button btnInsr5400Sreach; 	// 조회
	private Button btnInsr5400Print; 	// 인쇄
	private Button btnExcel;//엑셀
	private Button btnSingo;//보수총액신고파일
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
   // private RemtConstants lblRemtConst = RemtConstants.INSTANCE; 
    
	private VerticalPanel vp;
    private FormPanel plFrmInsr5400; 
    private String txtForm = "";
    private XTemplate detailTp; 
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

//	직종콤보
	private Insr5400Def insr5400Def  = new Insr5400Def("INSR5400");   //그리드 테이블 컬럼 define
	private MSFGridPanel insrGridPanel = new MSFGridPanel(insr5400Def, false, false, false, false,false);


	private  TabPanel tabsInsr4400Frst;
    private  TabPanel tabsInsr4400Two; 


    private GridCellRenderer<Stock> gridNumber;   
	private GridCellRenderer<Stock> change;

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

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	/** column  년도 : payYr */
	private ComboBox<BaseModel> srhPayYr;
	private ComboBox<BaseModel> srhPayMonth;
	/** column  년도 : year */
	private ComboBox<BaseModel> srhHlthInsrYr;//귀속년도

	private ComboBox<BaseModel> srhPayCd;     //급여구분
	private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
	private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
	private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
      
	private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
	private ComboBox<BaseModel> srhBusinCd;    //사업
	private TextField<String> srhHanNm;         //성명
	private TextField<String> srhResnRegnNum;   //주민번호 
	private HiddenField<String> srhSystemkey;   //시스템키
      
      /** column 지급공제구분코드 : pymtDducDivCd */
	private ComboBox<BaseModel> srhPymtDducDivCd;
	  private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
	  private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      
	private List<ModelData> mDtalistHdofcCodtnCd ;
	private List<ModelData> mDtalistDeptCd ;
	private List<ModelData> mDtalistTypOccuCd ;
	private List<ModelData> mDtalistDtilOccuInttnCd ;
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

	private Boolean emptyCheck = false ;
	private boolean mutilCombo = false;
	/**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
       
	/** set 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
	private ComboBox<BaseModel> crDilWrkrBlggQatrDivCd;     //귀속분기
	/** set 단위기관코드 : payrMangDeptCd */
	private ComboBox<BaseModel> crPayrMangDeptCd; //단위기관 
	private ComboBox<BaseModel> crDeptCd ;    //부서   
	private ComboBox<BaseModel> crBusinCd;    //사업
	private HiddenField<String> dpobCd;  //사업장코드 
	private HiddenField<String> dilWrkrBlggQatrDivCd;   /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
	private TextField<String> corpNmFmnm;   /** column 법인명_상호 : corpNmFmnm */

	private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
	private ComboBox<BaseModel> pentrCd;   /** column 제출자구분코드 : pentrCd */

	private TextField<String> txDeptyNum;   /** column 세무대리인번호 : txDeptyNum */

	private TextField<String> hmtxId;   /** column 홈텍스ID : hmtxId */
	private TextField<String> pernChrgDeptNm;   /** column 담당자부서명 : pernChrgDeptNm */
 
	private TextField<String> pernChrgNm ;  /** column 담당자성명 : pernChrgNm */

	private TextField<String> pernChrgPhnNum;   /** column 담당자전화번호 : pernChrgPhnNum */

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	전역함수 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 	**/	
	  
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
	private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   

	private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 

	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------

	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
	private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분

	private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세

	  private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
	  private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드
	
 	private HiddenField<String> systemkey;
 	private HiddenField<String> deptCd;
 	private HiddenField<String> icncDt;
	private String systemKeys;
	private DateField srhSoctyInsurCmptnDt01;
	private DateField srhSoctyInsurCmptnDt02;
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; // 재직상태
	private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); 		//재직상태
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
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
      // 검색 폼 바인딩 처리 함수 
	// private AuthAction authAction;  
	//  private Boolean boolChkAuth;  
	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	/**
	* 권한설정 처리 체크 
	* AuthAction 
	*/
	private void checkInsr5400Auth( String authAction, ListStore<BaseModel> bm) {   
		//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 

		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			if (!maskTracker) { unmask(); }  
				//MSFMainApp.unmaskMainPage();
				authExecEnabled() ;
				gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
		}
	}

	private void authExecEnabled() { 

		Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);
		srhHlthInsrYr.setValue(lsPayYrStore.findModel("year",String.valueOf(Integer.parseInt(DateTimeFormat.getFormat("yyyy").format(new Date())) - 1)));

		//srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		//srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));

		srhPayCd.setValue(lsPayCd.getAt(0));
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		* 권한설정을 위한 콤보처리를 위한 메서드 시작 
		* 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		// String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
		// GWTAuthorization.formAuthPopConfig(plFrmInsr5400, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
		// GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
		// gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		* 권한설정을 위한 콤보처리를 위한 메서드 종료
        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  srhDeptCd.fireEvent(Events.Add); 
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
			} else
			{
				tmMask.scheduleRepeating(2000);
			}
		}
	}; 

	private void initLoad() { 

		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
		authMapDef.put("srhPayYr",Boolean.FALSE);
		authMapDef.put("srhPayMonth",Boolean.FALSE);
		authMapDef.put("srhPayCd",Boolean.FALSE);

		authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
		authMapDef.put("srhDeptCd",Boolean.FALSE);
		// authMapDef.put("srhTypOccuCd",Boolean.FALSE);  

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			//권한 검색조건처리를 위해 추가된 부분 
			mask("[화면로딩] 초기화 진행 중!");
		}
		tmMask.scheduleRepeating(5000);
	}
  		  
	// 검색 폼 바인딩 처리 함수 
	//화면 폼 바인딩 처리 
	private void setInsr4400FormBinding() {
	 	 
		// formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
		// formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	   
	}        
   
		/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	Rpc Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 	**/
	//입력수정삭제처리 rpc 처리부
	private Insr5400ServiceAsync insr5400Service = Insr5400Service.Util.getInstance();

	private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	private SysCoCalendarDTO msfCoCalendarDto;  
	private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	private Insr5400DTO insr5400DTO;

	private BaseModel record;
	private  Iterator<Record> records;
    
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
	private SelectionListener<ButtonEvent> selectionListener =

		new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnInsr4400Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnInsr4400Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnInsr4400Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }

		}  
	};
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	private void Insr4400Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
 	   String serarchParam = "";
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
		
//		List<BaseModel> list = payr0650GridPanel.getGrid().getSelectionModel().getSelectedItems();
//		String checkedSystemKeys = "";
//		if(list != null && list.size() > 0){
//			String chkkey = "";
//			for(BaseModel bm : list){
//				chkkey += "'"+bm.get("systemkey")+"',";
//			}
//			
//			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//			
//		}
		String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
		 
		//String strParam = "/rp " + "[" + "20080311" + "]";
		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

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
  
public ContentPanel getViewPanel(){

	if(panel == null){
           
		//콤보 권한초기화
		initLoad(); 

		detailTp = XTemplate.create(getDetailTemplate()); 

		vp = new VerticalPanel();
		vp.setSpacing(10);
		createPsnl0100Form();  //화면 기본정보를 설정
		createSearchForm();    //검색필드를 적용 
		createForm();    //기본정보필드

		//createBottom();
		add(vp);
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
  public Insr5400() {
	  
//	final NumberFormat currency = NumberFormat.getCurrencyFormat();   
//	final NumberFormat number = NumberFormat.getFormat("0.00");   
//	final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);   
//	  
//	change = new GridCellRenderer<Stock>() {   
//		public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Stock> store, Grid<Stock> grid) {   
//			double val = (Double) model.get(property);
//			String style = val < 0 ? "red" : "green";   
//			return "<span style='color:" + style + "'>" + number.format(val) + "</span>";   
//		}
//	};
//
//	gridNumber = new GridCellRenderer<Stock>() {   
//		public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Stock> store, Grid<Stock> grid) {   
//			return numberRenderer.render(null, property, model.get(property));   
//		}
//	};
	  //엣지변환
	  //setSize("1010px", "700px");  
	setSize("1010px", "750px");  
}

public Insr5400(String txtForm) {
      this.txtForm = txtForm;
}
	  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 시작
 * 1. 폼 생성 선언
 * 2. 공통 버튼 처리 선언
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/	  
	 
private void createPsnl0100Form() {
    
    plFrmInsr5400 = new FormPanel();
   
    //화면명 설정
    plFrmInsr5400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 고용보험보수총액신고"));
    plFrmInsr5400.setIcon(MSFMainApp.ICONS.text());
    plFrmInsr5400.setFrame(true); 

    /************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	final Button btnlogView = new Button("로그");   
	
	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //로그 뷰화면 호출 메서드 
			  funcLogMessage("고용보험보수총액신고","INSR5400");
			}
		});
	plFrmInsr5400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	plFrmInsr5400.getHeader().addTool(btnlogView); 
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 
	 ************************************************************************/

	
    topInsr5400Bar = new ButtonBar();    
    topInsr5400Bar.setAlignment(HorizontalAlignment.RIGHT);

    btnInsr5400Reset = new Button("초기화");  
    btnInsr5400Reset.setIcon(MSFMainApp.ICONS.new16());
    //topInsr5400Bar.add(btnInsr5400Reset);

	btnInsr5400Save = new Button("저장");
	btnInsr5400Save.setIcon(MSFMainApp.ICONS.save16());
	topInsr5400Bar.add(btnInsr5400Save);

	//저장버튼 클릭 이벤트
	btnInsr5400Save.addListener(Events.Select, new Listener<ButtonEvent>() {

		@Override
		public void handleEvent(ButtonEvent be) {

			// TODO Auto-generated method stub
			MessageBox.confirm("고용보험보수총액신고", "저장하시겠습니까?", new Listener<MessageBoxEvent>(){

				@Override
				public void handleEvent(MessageBoxEvent be) {

//MessageBox.alert("고용보험보수총액신고", be.getButtonClicked().getText(), null);
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						saveGrid();
					}
				}
			});
		}
	});

	topInsr5400Bar.addListener(Events.Select, new Listener<ButtonEvent>() {
		@Override
		public void handleEvent(ButtonEvent be) {
			// TODO Auto-generated method stub
			
//			    if (edacRvyy.getValue().compareTo("2015") != 0) {
//			    	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	                            "2015년연말정산 이전자료는 조회만 가능합니다.", null); 
//			        return;
//			    
//			    }
//			    
//			     if (settGbcd.getValue().compareTo("Y0020010") != 0 ) { 
//			    	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
// 	                            "2015년 귀속분 연말정산만 가능합니다.", null); 
//			        //  showMessage('2015년 연말정산은 마감되었습니다. 수정은 재정산만 가능합니다.');
//			         return;
//			     }
			
//			     actionDatabase = ActionDatabase.UPDATE;
			     
		}
	});

	btnInsr5400Sreach = new Button("조회"); 
	btnInsr5400Sreach.setIcon(MSFMainApp.ICONS.search16());
	btnInsr5400Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			//조회버튼 클릭시 처리 
		    reload();  
		}
	});
	topInsr5400Bar.add(btnInsr5400Sreach);


    btnSingo = new Button("보수총액신고파일");
    btnSingo.setIcon(MSFMainApp.ICONS.text()); 
    //topInsr5400Bar.add(btnSingo);  
     
    
    btnExcel = new Button("엑셀"); 
    btnExcel.setIcon(MSFMainApp.ICONS.text()); 
    topInsr5400Bar.add(btnExcel);
    btnExcel.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			excelFileExport();
		}
	});
    
    plFrmInsr5400.add(topInsr5400Bar);       
    
    //파일업로드 처리
    plFrmInsr5400.setAction("myurl");
    plFrmInsr5400.setEncoding(Encoding.MULTIPART);
    plFrmInsr5400.setMethod(Method.POST);
     
        
    vp.add(plFrmInsr5400);
    //엣지변환
    //plFrmInsr5400.setSize("990px", "680px");
    plFrmInsr5400.setSize("990px", "730px");
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

private void createSearchForm() {   
     
      //  srhPyspGrdeCd = new HiddenField<String>(); 
         srhSystemkey = new HiddenField<String>();  //시스템키 

         sysComBass0150Dto = new PrgmComBass0150DTO();
		 sysComBass0300Dto = new PrgmComBass0300DTO();
		 sysComBass0400Dto = new PrgmComBass0400DTO();
		 sysComBass0500Dto = new PrgmComBass0500DTO();
		 msfCoCalendarDto = new SysCoCalendarDTO();
		 sysComBass0350Dto = new PrgmComBass0350DTO();
		 sysComBass0320Dto = new PrgmComBass0320DTO();

			//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		 lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
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
		 //월 
		 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //-------------------관리부서 추가  
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		 lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		   //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
          sysComBass0400Dto.setDeptDspyYn("Y");
          sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
          sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
         
          lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
         
          lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
              public void handleEvent(StoreEvent<BaseModel> be) {  
                  mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
                  srhDeptCd.getInitStore().add(mDtalistDeptCd);
                  
              }
          });     
          sysComBass0300Dto.setRpsttvCd("A048");
          lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
          //--------------------급여부서 불러 오는 함수 ------------------------------------------------
          
		// sysComBass0400Dto.setDeptDspyYn("Y");
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		// lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		// sysComBass0400Dto.setDeptDspyYn("");
			
	   /**
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      * 직종 콤보박스 처리  시작
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	      */
//	     		  ContentPanel typOccuCdGrid = new ContentPanel();  
//	     		  typOccuCdGrid.setVisible(false);
//	     		    
//	     		    //직종 콤보처리 
//	     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	     			       public void handleEvent(ComponentEvent be) {  
//	     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//	     			        	  
//	     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//	     			        	mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	     			          }  
//	     			        });  
//	     			       
//	     			      }  
//	     			    });  
//	     	  
//	     		 typOccuCdGrid.add(typOccuCdGridPanel); 
//	     		plFrmInsr5400.add(typOccuCdGrid);srhTypOccuCd
          
//	     	    
          lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);//srhTypOccuCd
          lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                 mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                  
               }
           });  
			 
		 /**
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   * 년도 콤보박스 처리  시작
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	   */
//	  		   ContentPanel payYrGrid = new ContentPanel();  
//	  		   payYrGrid.setVisible(false);
//	  		    
//	  		   //년도 콤보처리 
//	  		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//	  		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	  			       public void handleEvent(ComponentEvent be) {  
//	  			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	  			          public void handleEvent(StoreEvent<BaseModel> be) {  
//	  			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//	  			        	 
//	  			        	//  Date today = new Date(); 
//	  			        	    // A custom date format
//	  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	  			        	 
//	  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//	  			      	     // srhPayYr.setValue(bm);
//	  			        	srhPayYr.setValue(lsPayYrStore.getAt(0));
//	  			        	Date today = new Date(); 
//                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                            srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                       
//	  			          }  
//	  			        });  
//	  			       
//	  			      }  
//	  			    });  
//	  	  
//	  		payYrGrid.add(payYrGridPanel); 
//	  		plFrmInsr5400.add(payYrGrid); 

	  
	    plFrmInsr5400.setLayout(new FlowLayout());
	    
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
	   // fieldSet.setCheckboxToggle(false); 
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();
//	    lcSchLeft.setStyleAttribute("paddingRight", "10px");
	   
	 
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_8.setLayout(frmlytSch);

	    srhHlthInsrYr = new ComboBox<BaseModel>();
	    srhHlthInsrYr.setName("srhHlthInsrYr");
	    srhHlthInsrYr.setForceSelection(true);
	    srhHlthInsrYr.setMinChars(1);
	    srhHlthInsrYr.setDisplayField("yearDisp");
	    srhHlthInsrYr.setValueField("year");
	    srhHlthInsrYr.setTriggerAction(TriggerAction.ALL);
	   // srhHlthInsrYr.setEmptyText("--년도선택--");
	    srhHlthInsrYr.setSelectOnFocus(true); 
	    srhHlthInsrYr.setReadOnly(false);
	    srhHlthInsrYr.setEnabled(true); 
	    srhHlthInsrYr.setStore(lsPayYrStore);
	    srhHlthInsrYr.setFieldLabel("귀속년도");

	    srhHlthInsrYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	        public void handleEvent(StoreEvent<BaseModel> be) {  
	     	   checkInsr5400Auth("srhHlthInsrYr",lsPayYrStore);  
	          
	        }
	    });
	    srhHlthInsrYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	           BaseModel bmPayYr =  se.getSelectedItem(); 
	           if (bmPayYr != null) {
	               
	               if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                       
                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
                          
                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhHlthInsrYr,"year"));
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
	    layoutContainer_8.add(srhHlthInsrYr, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	    layoutContainer_8.setBorders(false);
//	    srhPayYr = new ComboBox<BaseModel>();
//	    srhPayYr.setName("srhPayYr");
//	    srhPayYr.setForceSelection(true);
//	    srhPayYr.setMinChars(1);
//	    srhPayYr.setDisplayField("payYrDisp");
//	    srhPayYr.setValueField("payYr");
//	    srhPayYr.setTriggerAction(TriggerAction.ALL);
//	    srhPayYr.setSelectOnFocus(true); 
//	    srhPayYr.setReadOnly(false);
//	    srhPayYr.setEnabled(true); 
//	    srhPayYr.setStore(lsPayYrStore);
//	    srhPayYr.setFieldLabel("작성년월"); 
//	    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	        public void handleEvent(StoreEvent<BaseModel> be) {  
//	     	   checkInsr5400Auth("srhPayYr",lsPayYrStore);  
//	          
//	        }
//	    });
//	    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	           BaseModel bmPayYr =  se.getSelectedItem(); 
//	           if (bmPayYr != null) {
//	               
//	               if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//                       
//                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
//                          
//                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
//                           List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//                           sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//                       }      
//                    
//                       //--------------------사업 불러 오는 함수 -------------------------------------------------
//                         lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                        //--------------------사업 불러 오는 함수 -------------------------------------------------
//                         srhBusinCd.setStore(lsBusinCd); 
//                         srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                             public void handleEvent(StoreEvent<BaseModel> be) {  
//                              //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                             }
//                         });    
//                         
//                   } else {
//                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
//                      // return;
//                   } 
//   
//	              
//	           }       
//	          } 
//	      });   
//	    layoutContainer_8.add(srhPayYr, new FormData("100%"));
//	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
//	    layoutContainer_8.setBorders(false);
//	    
//	    LayoutContainer layoutContainer_9 = new LayoutContainer();
//	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(0); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	    layoutContainer_9.setLayout(frmlytSch);
//	    
//	    /** column 지급년월 : Mnth */ 
//	    srhPayMonth = new ComboBox<BaseModel>();
//	    srhPayMonth.setName("srhPayMonth");
//	    srhPayMonth.setForceSelection(true);
//	    srhPayMonth.setMinChars(1);
//	    srhPayMonth.setDisplayField("monthDisp");
//	    srhPayMonth.setValueField("month");
//	    srhPayMonth.setTriggerAction(TriggerAction.ALL);
//	   // srhPayMonth.setEmptyText("--월선택--");
//	    srhPayMonth.setSelectOnFocus(true); 
//	    srhPayMonth.setReadOnly(false);
//	    srhPayMonth.setEnabled(true); 
//	    srhPayMonth.setStore(lsPayMonth);
//	    srhPayMonth.setHideLabel(true);
//	    srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	        public void handleEvent(StoreEvent<BaseModel> be) {  
//	     	   checkInsr5400Auth("srhPayMonth",lsPayMonth);  
//	          
//	        }
//	    });
//	    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
//	    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//	    layoutContainer_9.setBorders(false);
	    
	    
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
        lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkInsr5400Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
                     mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
                       
                   }
                });  
            } 
        });
        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
        layoutContainer.setBorders(false);
        
        LayoutContainer layoutContainer_14 = new LayoutContainer();
        layoutContainer_14.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_140 = new LayoutContainer();
    	frmlytSch = new FormLayout();  
    	frmlytSch.setLabelWidth(60); 
    	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    	layoutContainer_140.setLayout(frmlytSch);
        
        
        
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
		                	checkInsr5400Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
       
        
	    layoutContainer_140.add(srhEmymtDivCd, new FormData("100%"));
	       
	    layoutContainer_140.setBorders(false);
	    
	    LayoutContainer layoutContainer_141 = new LayoutContainer();
		   frmlytSch = new FormLayout();  
		   frmlytSch.setLabelWidth(1); 
		   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		   frmlytSch.setDefaultWidth(0);
		   layoutContainer_141.setLayout(frmlytSch);
		   
		   
		   
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

//		       	  EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//		           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//		           	 }  
		         
		       }
		   });  
		   
		   layoutContainer_141.add(srhRepbtyBusinDivCd, new FormData("100%"));
		   layoutContainer_141.setBorders(false); 
		   
		   
		   layoutContainer_14.add(layoutContainer_140, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		   layoutContainer_14.add(layoutContainer_141, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		   layoutContainer_14.setBorders(false); 
	    
        
	  
        
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	    //lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
	    
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
        //srhDeptCd.setDisplayField("deptNmRtchnt");
        //srhDeptCd.setValueField("deptCd");
       // srhDeptCd.setTriggerAction(TriggerAction.ALL);
        srhDeptCd.setEmptyText("--부서선택--");
       // srhDeptCd.setSelectOnFocus(true); 
       // srhDeptCd.setReadOnly(false);
      //  srhDeptCd.setEnabled(true); 
        //srhDeptCd.setStore(lsDeptCd );
        //srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
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
		                	checkInsr5400Auth("srhDeptCd", lsDeptCd); 
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
	            		   String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	             
	                             mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	                           }
	                       });  
            	    
              } else {
            	  
            	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
           		   String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
           		   sysComBass0320Dto.setDeptCd(strDeptCd);
            	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
         		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
        	            public void handleEvent(StoreEvent<BaseModel> be) {  
        	             
                          mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
//             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
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
//                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
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
//        plFrmInsr5400.add(srhDeptCd);
//        srhMangeDeptCd = new TextField<String>();
//        srhMangeDeptCd.setName("srhMangeDeptCd");
//        srhMangeDeptCd.setVisible(false);
//        plFrmInsr5400.add(srhMangeDeptCd);
//        srhMangeDeptNm = new TextField<String>();
//        srhMangeDeptNm.setName("srhMangeDeptNm");
//        srhMangeDeptNm.setVisible(false);
//        plFrmInsr5400.add(srhMangeDeptNm);
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
        
//        srhTypOccuCd =  new ComboBox<BaseModel>(); 
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
//        srhTypOccuCd.setFieldLabel("직종");
        //직종 직종세처리  
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
//            }
//        });    
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
        srhTypOccuCd.setHideLabel(true);
        //srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());

        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {

            public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();

				if (type == Store.Add)
				{
					//2015.11.30 추가 
					if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))
					{
						if (!gwtExtAuth.getEnableTypOccuCd())
						{
							ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
							//if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
							//for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
								//ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
            				 	//if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
            				 		//mdSelect = tpMdSelect;
		                        //} 
            				 //}  
            				 srhTypOccuCd.getListView().setChecked(mdSelect, true); 
            				 srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
            			//}  
		                    
            			 }
            			 //srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
            			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                //	checkInsr5400Auth("srhTypOccuCd", lsTypOccuCd); 
            		 }
            	 }
            }
        });

        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
        	@Override
        	public void handleEvent(ComponentEvent ce){
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
	    //layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));

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
//             
//            } 
//       }); 
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
 
            	checkInsr5400Auth("srhPayCd",lsPayCd); 
            }
        });    
	    
	    layoutContainer_1.add(srhPayCd, new FormData("100%"));
	    layoutContainer_1.setBorders(false); 
	    
	    lcSchCol3.setBorders(false); 
	    lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	    lcSchCol3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
        fieldSet.add(lcSchCol3);
        
	    plFrmInsr5400.add(fieldSet); 
	 
    //vp.add(panel);   
  }  

private void  displayDtilOccuInttnCd() {

	if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))))
	{
		//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져기
		sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
		String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
		sysComBass0350Dto.setDeptCd(strDeptCd);
		List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
		String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
		sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 

		//sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 

		if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd()))
		{
			lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
			//srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 

			lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>(){   
				public void handleEvent(StoreEvent<BaseModel> be) {
					mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
					srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);

					if (!gwtExtAuth.getEnableDtilOccuInttnCd())
					{
						ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;

						//if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
						//for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
						//ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
						//if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
						//mdSelect = tpMdSelect;
						//} 
						//}  
						srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
						srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
	  		            // }  
	                 }
				}
                });     
		} 
	} else
	{
		//직종변경에 따른 직종세 값 가져오기
		//String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
		
//		if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//        sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//        sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//        if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//            lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//            srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//		}
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
	 
private void createForm() {
    
//    FieldSet fieldSet = new FieldSet(); 
//    fieldSet.setSize("958px", "435px");  //492
//    fieldSet.setHeadingHtml("");
      

    LayoutContainer layoutContainer = new LayoutContainer();   

    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false); 
    cp01.setSize(950, 450);
    cp01.setLayout(new FitLayout());
    
    LayoutContainer layoutContainer_16 = new LayoutContainer(); 
    layoutContainer_16.setLayout(new ColumnLayout());
  //  layoutContainer_16.setBorders(false);  
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_1.setLayout(frmlytStd);
    
    FieldSet fldstNewFieldset = new FieldSet();
    //fldstNewFieldset.setSize("958px", "470px");
    fldstNewFieldset.setSize("958px", "520px");
    fldstNewFieldset.add(createCheckBoxGrid(),new FormData("100%"));
    layoutContainer_1.add(fldstNewFieldset);
    fldstNewFieldset.setHeadingHtml("대상자정보");
    fldstNewFieldset.setStyleAttribute("marginTop", "10px");
    fldstNewFieldset.setCollapsible(false);
    
    layoutContainer_16.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
    
     cp01.add(layoutContainer_16);
     layoutContainer_16.setSize("934", "470");
     layoutContainer.add(cp01) ;   
    
      
     fldstNewFieldset.add(layoutContainer,new FormData("100%"));    
    
    plFrmInsr5400.add(fldstNewFieldset);
    
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


private LayoutContainer createCheckBoxGrid() {    
	   
    String gridBgColor =  "background-color:#F5F6CE;"; 

    
    
    LayoutContainer lcStdGrid = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    lcStdGrid.setLayout(frmlytStd);  
    
    ContentPanel cpGrid = new ContentPanel();   
    cpGrid.setBodyBorder(false); 
    cpGrid.setHeaderVisible(false);   
    cpGrid.setLayout(new FitLayout());      
    //cpGrid.setSize(945, 440);  
    cpGrid.setSize(945, 490);
    
    //insrGridPanel = new MSFGridPanel(insr5400Def, false, false, false, false,false);
    insrGridPanel.getMsfGrid().setCellModel(true);
    insrGridPanel.setHeaderVisible(false);  
    insrGridPanel.setBodyBorder(true);
    insrGridPanel.setBorders(true);
    insrGridPanel.getBottomComponent().setVisible(false);

    //2줄파싱 
    insrGridPanel.getGrid().getColumnModel().addHeaderGroup(0, 5, new HeaderGroupConfig("산재", 1, 3));
    insrGridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("고용", 1, 3));

    cpGrid.add(insrGridPanel); 
    lcStdGrid.add(cpGrid);    
 
    return lcStdGrid;
}   

  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 


	private void createBottom() {
	 
		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setHeadingHtml("");
	
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout(1));
	
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout()); 
	
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2.setLayout(frmlytSch);
	
		FileUploadField flpldfldNewFileuploadfield = new FileUploadField();
		layoutContainer_2.add(flpldfldNewFileuploadfield, new FormData("100%"));
		flpldfldNewFileuploadfield.setFieldLabel("");
	 
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		layoutContainer_2.setBorders(false);

	
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_3);
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
	
		Button btnNewButton = new Button("파일업로드");
		layoutContainer_3.add(btnNewButton, new FormData("100%"));
		layoutContainer_3.setBorders(false);
	
		layoutContainer.add(layoutContainer_1);
		layoutContainer_1.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);

		plFrmInsr5400.add(fldstNewFieldset);    
	} 
	  
	public void reload() {
		IColumnFilter filters = null;
		
		insrGridPanel.getTableDef().setTableColumnFilters(filters);
		
		insrGridPanel.getTableDef().addColumnFilter("srhHlthInsrYr",  MSFSharedUtils.getSelectedComboValue(srhHlthInsrYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS);  
		
		insrGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		insrGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		//insrGridPanel.getTableDef().addColumnFilter("srhPayCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insrGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		 

	    String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	    insrGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	  //20180305추가 
	    insrGridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	    insrGridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 	
	    String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	    insrGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	    insrGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	  
	  
	    insrGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	    insrGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	    insrGridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
	    insrGridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
		 
	    insrGridPanel.reload();
	}
	  
	public void setRecord(BaseModel record) {
	       this.record = record;
	}
	 
	private Insr5400 getThis(){
	       return this;
	}
	   
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
	   
	//private int saveGrid(List<Insr5400DTO> listInsr5400Dto)
	private int saveGrid()
	{
		final List<Insr5400DTO> listInsr5400Dto = new ArrayList<Insr5400DTO>();
		Iterator<Record> iterRecords = insrGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();

		while (iterRecords.hasNext()) {
			
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			Insr5400DTO insr5400DTO = new Insr5400DTO();

			insr5400DTO.setUmytDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("umytDpobCd")));//고용보험사업장코드 : umytDpobCd
			insr5400DTO.setUmytInsrClutYr(MSFSharedUtils.allowNulls(bmMapModel.get("umytInsrClutYr")));//고용보험정산년도 : umytInsrClutYr
			insr5400DTO.setUmytSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("umytSystemkey")));//고용보험시스템키 : umytSystemkey
			insr5400DTO.setEmymtSeilNum2(MSFSharedUtils.allowNulls(bmMapModel.get("emymtSeilNum2")));//고용보험고용일련번호 : emymtSeilNum2
			insr5400DTO.setUmytInsrAqtnDt(MSFSharedUtils.allowNulls(bmMapModel.get("umytInsrAqtnDt")));//고용보험취득일자 : umytInsrAqtnDt
			insr5400DTO.setUmytInsrLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("umytInsrLssDt")));//고용보험상실일자 : umytInsrLssDt
			insr5400DTO.setUmytInsrPayTotAmnt(MSFSharedUtils.allowNulls(bmMapModel.get("umytInsrPayTotAmnt")));//고용보험보수총액 : umytInsrPayTotAmnt

			insr5400DTO.setIdtlDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("idtlDpobCd")));/** column 산재보험사업장코드 : idtlDpobCd */
			insr5400DTO.setIdtlAccdtInsurClutYr(MSFSharedUtils.allowNulls(bmMapModel.get("idtlAccdtInsurClutYr")));/** column 산재보험정산년도 : idtlAccdtInsurClutYr */
			insr5400DTO.setIdtlSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("idtlSystemkey")));/** column 산재보험시스템키 : idtlSystemkey */
			insr5400DTO.setEmymtSeilNum1(MSFSharedUtils.allowNulls(bmMapModel.get("emymtSeilNum1")));/** column 산재보험고용일련번호 : emymtSeilNum1 */
			insr5400DTO.setIdtlAccdtInsurAqtnDt(MSFSharedUtils.allowNulls(bmMapModel.get("idtlAccdtInsurAqtnDt")));/** column 산재취득일자 : idtlAccdtInsurAqtnDt */
			insr5400DTO.setIdtlAccdtInsurLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("idtlAccdtInsurLssDt")));/** column 산재상실일자 : idtlAccdtInsurLssDt */
			insr5400DTO.setIdtlAccdtPayTotAmnt(MSFSharedUtils.allowNulls(bmMapModel.get("idtlAccdtPayTotAmnt")));/** column 산재보수총액 : idtlAccdtPayTotAmnt */

			//MessageBox.alert("고용보험보수총액신고", bmMapModel.get("idtlAccdtInsurAqtnDt").toString(), null);
			listInsr5400Dto.add(insr5400DTO);
		}

		//MessageBox.alert("고용보험보수총액신고", list.toString(), null);
		//saveInsr6200_5300(listInsr5400DTO);
		//saveGrid(listInsr5400DTO);

		
		int retVal = -1;

		insr5400Service.saveInsr5400To5300Grid(listInsr5400Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("저장실패 : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else
				{
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
//					
//					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
////					yeta300ToYeta2000Detail(yeta300ToYeta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
//					
//					//reFresh("itemYeta01");
//					reFresh();
//					
				} 
			}
		});

		return retVal;
	}























	/* 엑셀 다운로드 */
	private void excelFileExport() {

		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
		
//		if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals(""))
//		{
//			if(emymtDivCd.equals("A0020010")){
//			}else if(emymtDivCd.equals("A0020020")){
//				if(deptCd == null || deptCd.equals("")){
//					Window.alert("부서를 선택해 주세요");
//					resetForm();
//					insr2200GridPanel.getMsfGrid().clearData();
//					return;
//				}	
//				if(businCd == null || businCd.equals("")){	
//					Window.alert("사업을 선택해 주세요");
//					resetForm();
//					insr2200GridPanel.getMsfGrid().clearData();
//					return;
//				}
//			}else{
//				Window.alert("고용구분을 선택해 주세요");
//				resetForm();
//				insr2200GridPanel.getMsfGrid().clearData();
//				return;
//			}
//		}else{
//			Window.alert("단위기관/고용구분을 선택해 주세요");
//			resetForm();
//			insr2200GridPanel.getMsfGrid().clearData();
//			return;
//		}
		
		
		
		HashMap<String, String> param = new HashMap<String, String>(); 
		
		
		
		systemKeys = new String();
		//systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
		
		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = insrGridPanel.getGrid().getSelectionModel().getSelectedItems();

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

		param.put("srhHlthInsrYr", MSFSharedUtils.getSelectedComboValue(srhHlthInsrYr,"year"));//귀속년도

		param.put("payrMangDeptCd",MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		param.put("srhPayCd",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));
		param.put("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		param.put("deptCd",deptCd);//부서

		param.put("typOccuCd",InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd",InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));

		param.put("businCd",MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey",MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
		param.put("hanNm",MSFSharedUtils.allowNulls(srhHanNm.getRawValue()));
		param.put("resnRegnNum",MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()));
		
		//GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsInsr5100Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
		//insr5100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr5100Export.do","extgwtFrame" ,param);

		//insrGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr5400Export.do","extgwtFrame" ,param);
		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsFileInsr5400Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param));
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