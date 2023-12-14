package com.app.exterms.yearendtax.client.form.yeta2016;

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
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta1000Def;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1400Service;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1400ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaComboUtils;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
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
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Yeta1400 extends MSFPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	private VerticalPanel vp;
	private FormPanel plFrmYeta1400;
	private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	private MSFGridPanel msfGridPanel;
	private Ye16Ta1000Def yeta1000def = new Ye16Ta1000Def("YETA1400");
	
	// -------------- grid 선언 종료  ---------------

	// final TabPanel tabsPsnl = new TabPanel(); //인사탭정보설정을 위한 tab

	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	// -------------- 권한 설정 객체 종료 --------------

	// 직종콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();
//	private MSFGridPanel typOccuCdGridPanel;

	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * Button 선언 시작
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
	// ---------- 상단 버튼 시작 ----------
	private ButtonBar topYeta1400Bar;
	private Button btnYeta1400Reset;	//초기화
	private Button btnYeta1400Save;		//저장
	private Button btnYeta1400Search;	//조회
	// ---------- 상단 버튼 종료 ----------
	
	// ---------- 엑셀 버튼 시작 ----------
	private ButtonBar exYeta1400Bar;	
	private Button btnYetaExImport;		//엑셀저장
	private Button btnYetaExSave;		//신고파일생성
	private Button btnYetaVerifiction;	//신고파일검증
	
	// ---------- 엑셀 버튼 종료 ----------
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * Button 선언 종료
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
	
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 전역변수 선언 시작
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/	
	// -------------- 검색조건 폼 시작 --------------
	private ComboBox<BaseModel> srhEdacRvyy; 				// 귀속년월
	private ComboBox<BaseModel> srhSettGbcd; 				// 정산구분
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
//	private TextField<String> srhHanNm; 					// 성명
//	private TextField<String> srhResnRegnNum; 				// 주민번호
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
	private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드	     
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
//	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private MSFMultiComboBox<ModelData> srhBusinCd; 		// 사업
//	private HiddenField<String> srhSystemkey; 				// 시스템키
	private ComboBox<BaseModel> srhYetaDpcd; 				// 원천신고부서
	private ComboBox<BaseModel> srhBusoprRgstnum; 			// 사업자등록번호
	private Boolean busoprRgstnumFlag = false; 
	// -------------- 검색조건 폼 종료 --------------
		
		
	// -------------- 연말정산 생성 폼 시작 --------------
	private ComboBox<BaseModel> creEdacRvyy; 				// 귀속년월
	private ComboBox<BaseModel> creSettGbcd; 				// 정산구분
	private ComboBox<BaseModel> crePayrMangDeptCd; 			// 단위기관
//	private TextField<String> creHanNm; 					// 성명
//	private TextField<String> creResnRegnNum; 				// 주민번호
	private ComboBox<BaseModel> creEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> creRepbtyBusinDivCd; 		// 호봉제구분코드
	private MSFMultiComboBox<ModelData> creDeptCd; 			// 부서
	private ComboBox<BaseModel> creDeptGpCd; 				// 부서직종그룹코드
	private MSFMultiComboBox<ModelData> creTypOccuCd; 		// 직종
	private MSFMultiComboBox<ModelData> creDtilOccuInttnCd; // 직종세
//	private ComboBox<BaseModel> creBusinCd; 				// 사업
	private MSFMultiComboBox<ModelData> creBusinCd; 		// 사업
	private ComboBox<BaseModel> creYetaDpcd; 				// 원천신고부서
	private ComboBox<BaseModel> creBusoprRgstnum; 			// 사업자등록번호
	//private HiddenField<String> creSystemkey; 				// 시스템키
	// -------------- 연말정산 생성 폼 종료 --------------
	
	
	// -------------- 전자신고 기본정보 폼 시작 --------------
	private HiddenField<String> yetaDpcd;		// 원천신고부서
	
	
	private MSFComboBox<BaseModel> edacRvyy;	// 정산년도
	private MSFComboBox<BaseModel> settGbcd; 	// 정산구분
	private MSFDateField edacPrdt; 				// 제출일자
	
	private MSFComboBox<BaseModel> creFile; 	// 신고파일
	private MSFTextField reprName; 				// 대표자(성명)
	private MSFTextField busiNumb; 				// 사업자등록번호
	private MSFTextField resuNumb; 				// 주민등록번호
	private MSFTextField juriNumb; 				// 법인번호
	private MSFTextField juriName;				// 법인명
	private MSFTextField incmPost; 				// 소재지주소_우편번호
	private MSFTextField incmAddr; 				// 소재지주소_기본주소
	private MSFTextField incmAdtl; 				// 소재지주소_상세주소
	private MSFTextField taxaCode; 				// 관할세무서코드
	private MSFTextField incmGbcd; 				// 제출자구분
	private MSFTextField taxaDnum; 				// 세무대리인번호
	private MSFTextField homeTxid; 				// 홈텍스ID
	private MSFTextField taxaPrcd; 				// 세무프로그램코드
	
	private MSFTextField charDept; 				// 담당부서명
	private MSFTextField charTele; 				// 담당자전화번호
	private MSFTextField charName; 				// 담당자성명
	private MSFTextField filePass; 				// 파일암호
	private MSFNumberField edacSeilNum;			// 연말정산마감일련번호
	
	private TextField<String> declareCount; 	// 신고인원수
	private TextField<String> workCount; 		// 재직
	private TextField<String> retireCount; 		// 퇴직
	// -------------- 전자신고 기본정보 폼 종료 --------------
	
	
	// ------------ ModelData 시작 ------------
	private List<ModelData> mDtalistcrDeptCd;
	private List<ModelData> mDtalistcrTypOccuCd;
	private List<ModelData> mDtalistcrDtilOccuInttnCd;
	
	private List<ModelData> mDtalistcrBusinCd;
	
//	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;
	
	private List<ModelData> mDtalistBusinCd;
	
	private boolean mutilCombo = false;
	// ------------ ModelData 시작 ------------
	
	
    // -------------- 연말정산 마감 관리 시작--------------
    private DateField closDate;    			//마감일자 
    private ToolBar underFinishToolBar;		//마감 toorbar	
    private ButtonBar underFinishBtnBar;	//마감 buttobar
    private Button btnFinish;				//마감
    private Button btnCancel;				//마감풀기
	// -------------- 연말정산 마감 관리 종료--------------
	
	
	private FileUploadField yeta1400flUp; // 파일업로드처리 부분
	private Boolean picBoolFile;

	//private HiddenField<String> systemkey;/** column SYSTEMKEY : systemkey */
	//private HiddenField<String> dpobCd;/** column 사업장코드 : dpobCd */
 //   private HiddenField<String> PayrMangDeptCd;/** column 급여관리부서코드 : PayrMangDeptCd */
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Rpc Service 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	// -------------- stroe 선언 시작 --------------
	private ListStore<BaseModel> lsClutYrStore	 	= new ListStore<BaseModel>(); 	//년도
	private ListStore<BaseModel> lsSettGbcd 		= new ListStore<BaseModel>();	//정산구분
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>(); 	//단위기관
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>(); 	//고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>(); 	//부서콤보
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드 
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>(); 	//직종
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>(); 	//직종세
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>(); 	//사업콤보
	private ListStore<BaseModel> lsYetaDpcd  		= new ListStore<BaseModel>();	// 원천징수부서코드  
	private ListStore<BaseModel> lsBusoprRgstnum  	= new ListStore<BaseModel>();	// 사업자등록번호  
	//---------------------------
	private ListStore<BaseModel> lscreClutYrStore 		= new ListStore<BaseModel>(); 	//년도
	private ListStore<BaseModel> lscreSettGbcd 			= new ListStore<BaseModel>(); 	//정산구분
	private ListStore<BaseModel> lscrePayrMangDeptCd	= new ListStore<BaseModel>(); 	//단위기관
	private ListStore<BaseModel> lscreEmymtDivCd 		= new ListStore<BaseModel>(); 	//고용구분
	private ListStore<BaseModel> lscreRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lscreDeptCd 			= new ListStore<BaseModel>(); 	//부서콤보
	private ListStore<BaseModel> lscreDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드 
	private ListStore<BaseModel> lscreTypOccuCd 		= new ListStore<BaseModel>(); 	//직종
	private ListStore<BaseModel> lscreDtilOccuInttnCd 	= new ListStore<BaseModel>(); 	//직종세
	private ListStore<BaseModel> lscreBusinCd 			= new ListStore<BaseModel>(); 	//사업콤보
	private ListStore<BaseModel> lscreYetaDpcd  		= new ListStore<BaseModel>();	// 원천징수부서코드  
	private ListStore<BaseModel> lscreBusoprRgstnum  	= new ListStore<BaseModel>();	// 사업자등록번호  
	
	private ListStore<BaseModel> lsFileType = new ListStore<BaseModel>(); 			//신고파일
	// -------------- stroe 선언 시작 --------------
	
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종 dto
	private Ye16Ta1000DTO yeta1000Dto;
	private Ye16Ta1005DTO ye16Ta1005Dto;
	// -------------- DTO 선언 종료 --------------
	private Ye16Ta1000BM yeta1000Bm;
	private Ye16Ta1005BM yeta161005Bm;
	
	
	// -------------- 서비스 호출 시작 --------------
//	private Yeta0100ServiceAsync yeta0100Service = Yeta0100Service.Util.getInstance();
	private Yeta1400ServiceAsync yeta1400Service = Yeta1400Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
	private BaseModel record;
	private Iterator<Record> records;
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkYeta1400Auth(String authAction, ListStore<BaseModel> bm) {
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())
				&& gwtExtAuth.checkExtAuth(authAction, bm)) {

			if (!maskTracker) {
				unmask();
			}
			authExecEnabled() ;
			
		}
	}
	 private void authExecEnabled() { 
		   //------------------
		 /**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세,사업 순으로 없으면 ""
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
			// ----------------------------------------------------
			//Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd,srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd, srhEdacRvyy};
			//gwtAuthorization.formAuthFieldConfig(fldArrField);

			srhEdacRvyy.setValue(lsClutYrStore.findModel("year", "2016"));
			creEdacRvyy.setValue(lsClutYrStore.findModel("year", "2016"));
			edacRvyy.setValue(lscreClutYrStore.findModel("year", "2016"));
		 
			srhSettGbcd.setValue(lsSettGbcd.getAt(0));
			creSettGbcd.setValue(lsSettGbcd.getAt(0));
			settGbcd.setValue(lscreSettGbcd.getAt(0));
			
			
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 종료
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
			srhDeptCd.getListView().fireEvent(Events.CheckChanged);
			creDeptCd.getListView().fireEvent(Events.CheckChanged);
		 }
	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			 if (lsEmymtDivCd.getCount() > 0 ) {
      		   
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

		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();

		// authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
		authMapDef.put("srhDeptCd", Boolean.FALSE);
		//authMapDef.put("srhTypOccuCd", Boolean.FALSE);

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
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Rpc Service 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();
			
			detailTp = XTemplate.create(getDetailTemplate());
//			formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			
			
			createYeta1400Form();	// 화면 기본정보를 설정
			createSearchForm();		// 검색조건 필드를 설정
			createXlsForm();		// 엑셀 생성 폼
			createBottomForm(); 	// 그리드 밑부분정보를 설정
			createStandardForm();	// 기본정보필드
			createMsfGridForm(); 	// 그리드 설정

			
			vp.setSize("1010px", "820px");

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
	public Yeta1400() {
		setSize("1010px", "820px");
	}

	public Yeta1400(String txtForm) {
		this.txtForm = txtForm;
	}
	
	/** 연말정산신고 - 생성부 **/
	private void createXlsForm() {
		
	//	dpobCd = new HiddenField<String>();			//사업장코드
	//	systemkey = new HiddenField<String>(); 		//시스템키
//		PayrMangDeptCd = new HiddenField<String>(); //급여관리부서코드 
		
		yetaDpcd = new HiddenField<String>();

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		//--------검색조건, 휴가일수 중복 store---------
		lscreClutYrStore = lsClutYrStore; 
		lscreSettGbcd = lsSettGbcd; 
		lscrePayrMangDeptCd = lsPayrMangDeptCd;
		lscreEmymtDivCd = lsEmymtDivCd;
		lscreRepbtyBusinDivCd = lsRepbtyBusinDivCd;
		lscreYetaDpcd  = lsYetaDpcd;
		//lscreDeptCd = lsDeptCd;
	//	lscreTypOccuCd = lsTypOccuCd;
//		lscreDtilOccuInttnCd = lsDtilOccuInttnCd;
	//	lscreBusinCd = lsBusinCd;
        //--------검색조건, 휴가일수 중복 store---------

//		// --------------------단위기관 불러 오는 함수------------------------------------------------
//		lscrePayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto); // 단위기관
//		// --------------------단위기관 불러 오는 함수------------------------------------------------
//
//		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
//		sysComBass0300Dto.setRpsttvCd("Y002");
//		lscreSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분
//	 
//		 
//		sysComBass0300Dto.setRpsttvCd("A002");
//		lscreEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); // 고용구분
//		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
//
//		// --------------------정산년도 불러 오는 함수------------------------------------------------
//		lscreClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
//		// --------------------정산년도 불러 오는 함수------------------------------------------------
////		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
//
        sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//
    	lscreDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

		lscreDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistcrDeptCd = YetaUtils.getDeptCdModelData(lscreDeptCd);
				creDeptCd.getInitStore().add(mDtalistcrDeptCd);
			}
		}); 
		
		
		lscreTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lscreTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				mDtalistcrTypOccuCd = YetaUtils.getTypOccuCdModelData(lscreTypOccuCd);
			    creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);

			}
		});
		
		
		plFrmYeta1400.setLayout(new FlowLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("연말정산신고 - 생성");
//		fieldSet.setHeight("80px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());
		fieldSet.add(lcSchCol1, new FormData("100%"));

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		layoutContainer1_1.setLayout(new ColumnLayout());

		/** column 지급년 : ClutYr */
		LayoutContainer layoutContainer1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1.setLayout(frmlytSch);

		creEdacRvyy = new ComboBox<BaseModel>();
		creEdacRvyy.setName("creEdacRvyy");
		creEdacRvyy.setForceSelection(true);
		creEdacRvyy.setMinChars(1);
		creEdacRvyy.setDisplayField("yearDisp");
		creEdacRvyy.setValueField("year");
		creEdacRvyy.setTriggerAction(TriggerAction.ALL);
		creEdacRvyy.setSelectOnFocus(true);
		creEdacRvyy.setReadOnly(true);
		creEdacRvyy.setEnabled(true);
		creEdacRvyy.setStore(lscreClutYrStore);
		creEdacRvyy.setFieldLabel("정산년도");
		creEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		creEdacRvyy.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((creDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

						if (creDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creEdacRvyy, "year"));
							List<ModelData> mdListSelect = creDeptCd.getListView().getChecked();
							String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"deptCd");
							sysComBass0500Dto.setDeptCd(strDeptCd);
							//sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lscreBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						lscreBusinCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistcrBusinCd = YetaUtils.getBusinCdModelData(lscreBusinCd);
								creBusinCd.getInitStore().add(mDtalistcrBusinCd);
							}
						});
						
						
//						creBusinCd.setStore(lscreBusinCd);
//						creBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//							public void handleEvent(StoreEvent<BaseModel> be) {
//									// searchBusinCd.setValue(lsBusinCd.getAt(0));
//							}
//						});
					} if ((creDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
							// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
							// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
							// return;
					}
				}
			}
		});
		layoutContainer1.add(creEdacRvyy, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);


		/** column 정산구분 : settGbcd */
		LayoutContainer layoutContainer3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch);
		
		crePayrMangDeptCd = new ComboBox<BaseModel>();
		crePayrMangDeptCd.setName("crePayrMangDeptCd");
		crePayrMangDeptCd.setForceSelection(true);
		crePayrMangDeptCd.setMinChars(1);
		crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
		crePayrMangDeptCd.setValueField("payrMangDeptCd");
		crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		crePayrMangDeptCd.setEmptyText("--단위기관선택--");
		crePayrMangDeptCd.setSelectOnFocus(true);
		crePayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		crePayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
		crePayrMangDeptCd.setStore(lscrePayrMangDeptCd);
		crePayrMangDeptCd.setFieldLabel("단위기관");
		lscrePayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));

				// --------------------부서 불러 오는 함수------------------------------------------------
				lscreDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// --------------------부서 불러 오는 함수------------------------------------------------
				lscreDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistcrDeptCd = YetaUtils.getDeptCdModelData(lscreDeptCd);
						creDeptCd.getInitStore().add(mDtalistcrDeptCd);
					}
				});
			}
		});
		layoutContainer3.add(crePayrMangDeptCd, new FormData("100%"));

//		creSettGbcd = new ComboBox<BaseModel>();
//		creSettGbcd.setName("creSettGbcd");
//		creSettGbcd.setForceSelection(true);
//		creSettGbcd.setMinChars(1);
//		creSettGbcd.setDisplayField("commCdNm");
//		creSettGbcd.setValueField("commCd");
//		creSettGbcd.setTriggerAction(TriggerAction.ALL);
//		creSettGbcd.setEmptyText("--정산구분선택--");
//		creSettGbcd.setSelectOnFocus(true);
//		creSettGbcd.setReadOnly(false);
//		creSettGbcd.setEnabled(true);
//		creSettGbcd.setStore(lscreSettGbcd);
//		creSettGbcd.setFieldLabel("정산구분");
//		creSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//			
//			}
//		});
//
//		layoutContainer3.add(creSettGbcd, new FormData("100%"));
		layoutContainer3.setBorders(false);
 
		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4.setLayout(frmlytSch);
		
		creSettGbcd = new ComboBox<BaseModel>();
		creSettGbcd.setName("creSettGbcd");
		creSettGbcd.setForceSelection(true);
		creSettGbcd.setMinChars(1);
		creSettGbcd.setDisplayField("commCdNm");
		creSettGbcd.setValueField("commCd");
		creSettGbcd.setTriggerAction(TriggerAction.ALL);
		creSettGbcd.setEmptyText("--정산구분선택--");
		creSettGbcd.setSelectOnFocus(true);
		creSettGbcd.setReadOnly(false);
		creSettGbcd.setEnabled(true);
		creSettGbcd.setStore(lscreSettGbcd);
		creSettGbcd.setFieldLabel("정산구분");
		creSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
			
			}
		});

		layoutContainer4.add(creSettGbcd, new FormData("100%"));

//		crePayrMangDeptCd = new ComboBox<BaseModel>();
//		crePayrMangDeptCd.setName("crePayrMangDeptCd");
//		crePayrMangDeptCd.setForceSelection(true);
//		crePayrMangDeptCd.setMinChars(1);
//		crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
//		crePayrMangDeptCd.setValueField("payrMangDeptCd");
//		crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
//		crePayrMangDeptCd.setEmptyText("--단위기관선택--");
//		crePayrMangDeptCd.setSelectOnFocus(true);
//		crePayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//		crePayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
//		crePayrMangDeptCd.setStore(lscrePayrMangDeptCd);
//		crePayrMangDeptCd.setFieldLabel("단위기관");
//		lscrePayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				
//			}
//		});
//		crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				sysComBass0400Dto.setDeptDspyYn("Y");
//				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
//
//				// --------------------부서 불러 오는 함수------------------------------------------------
//				lscreDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
//				// --------------------부서 불러 오는 함수------------------------------------------------
//				lscreDeptCd.addStoreListener(new StoreListener<BaseModel>() {
//					public void handleEvent(StoreEvent<BaseModel> be) {
//						mDtalistcrDeptCd = YetaUtils.getDeptCdModelData(lscreDeptCd);
//						creDeptCd.getInitStore().add(mDtalistcrDeptCd);
//					}
//				});
//			}
//		});
//		layoutContainer4.add(crePayrMangDeptCd, new FormData("100%"));
		layoutContainer4.setBorders(false);

		/** column 고용구분 : EmymtDivCd */
		LayoutContainer layoutContainer7 = new LayoutContainer(new ColumnLayout());
		layoutContainer7.setBorders(false);
		
		LayoutContainer layoutContainer77 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer77.setLayout(frmlytSch);

		creEmymtDivCd = new ComboBox<BaseModel>();
		creEmymtDivCd.setName("creEmymtDivCd");
		creEmymtDivCd.setForceSelection(true);
		creEmymtDivCd.setMinChars(1);
		creEmymtDivCd.setDisplayField("commCdNm");
		creEmymtDivCd.setValueField("commCd");
		creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		creEmymtDivCd.setEmptyText("--고용구분선택--");
		creEmymtDivCd.setSelectOnFocus(true);
		creEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		creEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		creEmymtDivCd.setStore(lscreEmymtDivCd);
		creEmymtDivCd.setFieldLabel("고용구분");
		lscreEmymtDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "crePayrMangDeptCd","creEmymtDivCd", "creDeptCd","creTypOccuCd","creBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta1400Auth("creEmymtDivCd", lscreEmymtDivCd);
				}
			}
		});
		creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null
								&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					if ((creDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
						if (creDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creEdacRvyy, "year"));
							List<ModelData> mdListSelect = creDeptCd.getListView().getChecked();
							String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"deptCd");
							sysComBass0500Dto.setDeptCd(strDeptCd);
							//sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lscreBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						
						
						lscreBusinCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistcrBusinCd = YetaUtils.getBusinCdModelData(lscreBusinCd);
								creBusinCd.getInitStore().add(mDtalistcrBusinCd);
							}
						});
						
//						creBusinCd.setStore(lscreBusinCd);
//						creBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//							public void handleEvent(StoreEvent<BaseModel> be) {
//								// searchBusinCd.setValue(lsBusinCd.getAt(0));
//							}
//						});
					} else {
						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
						// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
						// return;
					}
					creBusinCd.setEnabled(true);
					creTypOccuCd.reset();
					creTypOccuCd.setEnabled(false);
					creDtilOccuInttnCd.reset();
					creDtilOccuInttnCd.setEnabled(false);
				} else {
					creBusinCd.reset();
					creBusinCd.setEnabled(false);

					//if (gwtAuthorization.getCheckOccuDisabled()) {
						creTypOccuCd.setEnabled(true);
						creDtilOccuInttnCd.setEnabled(true);
					//} else {
					//	creTypOccuCd.setEnabled(false);
					//	creDtilOccuInttnCd.setEnabled(false);
					//}
				}
			}
		});
		layoutContainer77.add(creEmymtDivCd, new FormData("100%"));
		layoutContainer7.add(layoutContainer77, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    creRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
	    creRepbtyBusinDivCd.setHideLabel(true);
	    creRepbtyBusinDivCd.setForceSelection(true);
	    creRepbtyBusinDivCd.setAllowBlank(false);
	    creRepbtyBusinDivCd.setMinChars(1);
	    creRepbtyBusinDivCd.setDisplayField("commCdNm");
	    creRepbtyBusinDivCd.setValueField("commCd");
	    creRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    creRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    creRepbtyBusinDivCd.setSelectOnFocus(true); 
	    creRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    creRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    creRepbtyBusinDivCd.setStore(lscreRepbtyBusinDivCd);
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lscreRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    layoutContainer_101.add(creRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer7.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		
		
		LayoutContainer layoutContainer8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer8.setLayout(frmlytSch);

		creDeptCd = new MSFMultiComboBox<ModelData>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		creDeptCd.setWidth(100);
		creDeptCd.setFieldLabel("부서");
		creDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		creDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta1400Auth("creDeptCd", lscreDeptCd);
				}
			}
		});

		creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((creDeptCd.getListView().getChecked().size() > 0 )
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
					if (creDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creEdacRvyy, "year"));
						List<ModelData> mdListSelect = creDeptCd.getListView().getChecked();
						String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"deptCd");
						sysComBass0500Dto.setDeptCd(strDeptCd);
						//sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}

					// --------------------사업 불러 오는 함수-------------------------------------------------
					lscreBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수-------------------------------------------------
					
					//mDtalistcrBusinCd = YetaUtils.getBusinCdModelData(lscreBusinCd);
//					creBusinCd.getInitStore().add(mDtalistcrBusinCd);
					
					lscreBusinCd.addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
							mDtalistcrBusinCd = YetaUtils.getBusinCdModelData(lscreBusinCd);
							creBusinCd.getInitStore().add(mDtalistcrBusinCd);

						}
					});
					
//					creBusinCd.setStore(lscreBusinCd);
//					creBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//						public void handleEvent(StoreEvent<BaseModel> be) {
//							// searchBusinCd.setValue(lsBusinCd.getAt(0));
//						}
//					});
				} else {
					// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
					// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
					// return;
				}
			}
		});

		creDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
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

		layoutContainer8.add(creDeptCd, new FormData("100%"));
		layoutContainer8.setBorders(false);

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_3 = new LayoutContainer();
		layoutContainer1_3.setLayout(new ColumnLayout());
		
		
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_211.setLayout(frmlytSch); 
       
        creDeptGpCd  =  new ComboBox<BaseModel>(); 
        creDeptGpCd.setName("creDeptGpCd");
        creDeptGpCd.setForceSelection(true);
        creDeptGpCd.setAllowBlank(false);
        creDeptGpCd.setMinChars(1);
        creDeptGpCd.setDisplayField("commCdNm");
        creDeptGpCd.setValueField("commCd");
        creDeptGpCd.setTriggerAction(TriggerAction.ALL);
        creDeptGpCd.setEmptyText("--그룹--");
        creDeptGpCd.setSelectOnFocus(true); 
        creDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        creDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        creDeptGpCd.setStore(lscreDeptGpCd);
        creDeptGpCd.setFieldLabel("직종"); 
        
        
        layoutContainer_211.add(creDeptGpCd, new FormData("100%")); 
        

		/** column 직종 : TypOccuCd */
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuCd.setLayout(frmlytSch);

		creTypOccuCd = new MSFMultiComboBox<ModelData>();
		creTypOccuCd.setName("creTypOccuCd");
		creTypOccuCd.setEmptyText("--직종선택--");
		creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		//creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
		creTypOccuCd.setWidth(100);
		creTypOccuCd.setHideLabel(true);
//		creTypOccuCd.setFieldLabel("직종");
		creTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		creTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		creTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
					 *  lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					//checkYeta1400Auth("creTypOccuCd", lsTypOccuCd);
				}
			}
		});
		
	 

		creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((creTypOccuCd.getListView().getChecked().size() > 0)
						&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
					// 직종변경에 따른 직종세 값 가져오기
					List<ModelData> mdListDeptCdSelect = creDeptCd.getListView().getChecked();
					String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListDeptCdSelect,"deptCd");
					sysComBass0350Dto.setDeptCd(strDeptCd);
					
					List<ModelData> mdListSelect = creTypOccuCd.getListView().getChecked();

					String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd");
					sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));

					if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
 
                      lscreDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
						// crehDtilOccuInttnCd.setStore(LsDtilOccuInttnCd);
                      lscreDtilOccuInttnCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistcrDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lscreDtilOccuInttnCd);
								creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);

							}
						});
					}
				} else {

				}
			}
		});

		creTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
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
		lcTypOccuCd.add(creTypOccuCd, new FormData("100%"));

		LayoutContainer lcSchRight = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		lcSchRight.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */
		creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		creDtilOccuInttnCd.setName("crehDtilOccuInttnCd");
		creDtilOccuInttnCd.setEmptyText("--직종세선택--");
		creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
		creDtilOccuInttnCd.setWidth(100);
		creDtilOccuInttnCd.setHideLabel(true);
		creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
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

		lcSchRight.add(creDtilOccuInttnCd, new FormData("100%"));

		
		layoutContainer1_3.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer1_3.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer1_3.setBorders(false);

		/** column 사업 : BusinCd */
		LayoutContainer layoutContainer9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9.setLayout(frmlytSch);
		
		creBusinCd = new MSFMultiComboBox<ModelData>();
		creBusinCd.setName("creBusinCd");
		creBusinCd.setEmptyText("--사업선택--");
		creBusinCd.setFieldLabel("사업");
		creBusinCd.getListView().setDisplayProperty("businNm");
		creBusinCd.getStore().add(mDtalistcrBusinCd);
		creBusinCd.setWidth(100);
//		creBusinCd.setHideLabel(true);
		creBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		creBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		creBusinCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
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
		
		layoutContainer9.add(creBusinCd, new FormData("100%"));
		layoutContainer9.setBorders(false);
		
		LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());


		LayoutContainer layoutContainer_16_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_1.setLayout(frmlytSch);
			    
		creYetaDpcd = new ComboBox<BaseModel>();
		creYetaDpcd.setName("creYetaDpcd");
		creYetaDpcd.setForceSelection(true);
		creYetaDpcd.setMinChars(1);
		creYetaDpcd.setDisplayField("yetaDpnm");
		creYetaDpcd.setValueField("yetaDpcd");
		creYetaDpcd.setTriggerAction(TriggerAction.ALL);
		creYetaDpcd.setEmptyText("--원천신고부서--");
		creYetaDpcd.setSelectOnFocus(true);
		creYetaDpcd.setReadOnly(false);
		creYetaDpcd.setEnabled(true);
		creYetaDpcd.setStore(lscreYetaDpcd);
		creYetaDpcd.setFieldLabel("원천신고부서");
		layoutContainer_16_1.add(creYetaDpcd, new FormData("100%"));
		layoutContainer_16_1.setBorders(false);
		creYetaDpcd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 원천신고부서가 변경될 경우 해당하는 사업자등록번호를 가져옴
				BaseModel bmClutYr = se.getSelectedItem();
				
				if (bmClutYr != null) {
					
					
					// TODO 콤보 선택시 사업자번호 스토어 
					lscreBusoprRgstnum.removeAll();
					creBusoprRgstnum.setStore(new ListStore<BaseModel>());
					creBusoprRgstnum.setValue(new BaseModel());
					
					
					Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
//					yeta161005Dto.setDpobCd(dpobCd.getValue());
					yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd"));
					
					lscreBusoprRgstnum = YetaComboUtils.getYeta2000busoprRgstnumList(yeta161005Dto);
					creBusoprRgstnum.setStore(lscreBusoprRgstnum);
					
				}
			}
		}); 
		layoutContainer_16_1.add(creYetaDpcd, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_16_2 = new LayoutContainer();
		layoutContainer_16_2.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_2.setLayout(frmlytSch);

		creBusoprRgstnum = new ComboBox<BaseModel>();
		creBusoprRgstnum.setName("creBusoprRgstnum"); 
		creBusoprRgstnum.setHideLabel(true);
		creBusoprRgstnum.setForceSelection(true);
		creBusoprRgstnum.setMinChars(1);
		creBusoprRgstnum.setDisplayField("busoprRgstnum");
		creBusoprRgstnum.setValueField("busoprRgstnum");
		creBusoprRgstnum.setTriggerAction(TriggerAction.ALL);
		creBusoprRgstnum.setEmptyText("--원천신고부서--");
		creBusoprRgstnum.setSelectOnFocus(false);
		creBusoprRgstnum.setReadOnly(false);
		creBusoprRgstnum.setEnabled(true);
		creBusoprRgstnum.setStore(lscreBusoprRgstnum);
		creBusoprRgstnum.setLabelSeparator("");
//		creBusoprRgstnum.setFieldLabel("사업자등록번호");
		lscreRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		layoutContainer_16_2.add(creBusoprRgstnum, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));	
		
		
		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월
		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23)); 	// 단위기관
		lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 정산구분
//		lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 성명, 주민등록번호
		lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 고용구분
		
		
		lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 부서
		lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
		lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 사업
		
		lcSchCol1.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월

		plFrmYeta1400.add(fieldSet);
	}
	
	private void createStandardForm() {
		
		//dpobCd = new HiddenField<String>();			//사업장코드
		//systemkey = new HiddenField<String>(); 		//시스템키
//		PayrMangDeptCd = new HiddenField<String>(); //급여관리부서코드 
	
		// 파일업로드 처리
		plFrmYeta1400.setAction("myurl");
		plFrmYeta1400.setEncoding(Encoding.MULTIPART);
		plFrmYeta1400.setMethod(Method.POST);

		plFrmYeta1400.setSize("990px", "820px");
		plFrmYeta1400.setLayout(new FlowLayout());



//		srhSystemkey = new HiddenField<String>();

		LayoutContainer layoutContainer1_4 = new LayoutContainer();
		layoutContainer1_4.setLayout(new ColumnLayout());
		layoutContainer1_4.setStyleAttribute("marginTop", "10px");
//		layoutContainer1_4.setStyleAttribute("marginBottom", "10px");

		LayoutContainer layoutContainer10 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10.setLayout(frmlytSch);

		Label txt1 = new Label();
		Label txt2 = new Label();
		txt1.setText("* 정산 완료 하신 후 본 작업을 실행 하시기 바랍니다. * 신고파일은 C:\\eosdata에 생성됩니다.");

		layoutContainer10.add(txt1, new FormData("100%"));
		layoutContainer10.add(txt2, new FormData("100%"));
		layoutContainer10.setBorders(false);

		LayoutContainer layoutContainer11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11.setLayout(frmlytSch);

		exYeta1400Bar = new ButtonBar();
		exYeta1400Bar.setAlignment(HorizontalAlignment.RIGHT);

		/*
		btnYetaVerifiction= new Button("신고사전검증");
		exYeta1400Bar.add(btnYetaVerifiction);
		btnYetaVerifiction.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 
				yeta1400Verifiction(); 
			 
			}
		});*/
		
		
		btnYetaExImport = new Button("엑셀저장");
		btnYetaExImport.addListener(Events.Select, new Listener<ButtonEvent>() {
     		public void handleEvent(ButtonEvent e) {
     			xlsExportData();
     		}
    	});
		exYeta1400Bar.add(btnYetaExImport);

		btnYetaExSave= new Button("신고파일생성");
		exYeta1400Bar.add(btnYetaExSave);
		btnYetaExSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 
				fileSave(); 
			 
			}
		});
		 

		layoutContainer11.add(exYeta1400Bar);
		layoutContainer11.setBorders(false);

		layoutContainer1_4.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1_4.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1_4.setBorders(false);
		plFrmYeta1400.add(layoutContainer1_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));	// 텍스트와 버튼
				
		// 연말정산신고-생성
		FieldSet fieldSet_2 = new FieldSet();
		fieldSet_2.setHeadingHtml("전자신고기본정보");
		// fieldSet_2.setHeight("230px");
		fieldSet_2.setCollapsible(false);

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());
		fieldSet_2.add(lcSchCol2, new FormData("100%"));

		/** column 년도 : edacPvYy */

		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(90);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(fl1_1);

		edacRvyy = new MSFComboBox<BaseModel>();
		edacRvyy.setName("edacPvYy");
		edacRvyy.setFieldLabel("정산년도");
		edacRvyy.setForceSelection(true);
		edacRvyy.setMinChars(1);
		edacRvyy.setDisplayField("yearDisp");
		edacRvyy.setValueField("year");
		edacRvyy.setTriggerAction(TriggerAction.ALL);
		edacRvyy.setEmptyText("--년도--");
		edacRvyy.setSelectOnFocus(true);
		edacRvyy.setStore(lscreClutYrStore);
		edacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		
		//TODO 안해줘도 될 꺼 같음..
//		edacRvyy.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
//				BaseModel bmClutYr = se.getSelectedItem();
//				if (bmClutYr != null) {
//					if ((srhDeptCd.getListView().getChecked().size() == 1)
//							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")))) {
//
//						if (srhDeptCd.getListView().getChecked().size() > 0) {
//							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(edacRvyy, "year"));
//							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
//							sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
//						}
//
//						// --------------------사업 불러 오는 함수-------------------------------------------------
//						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
//						// --------------------사업 불러 오는 함수-------------------------------------------------
//						
//						
//						mDtalistcrBusinCd = YetaUtils.getBusinCdModelData(lsBusinCd);
//						srhBusinCd.getInitStore().add(mDtalistBusinCd);
//						
//						
////						srhBusinCd.setStore(lsBusinCd);
////						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
////							public void handleEvent(StoreEvent<BaseModel> be) {
////								// searchBusinCd.setValue(lsBusinCd.getAt(0));
////							}
////						});
//					} else {
//						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
//						// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
//						// return;
//					}
//				}
//			}
//		});

		lc1_1.add(edacRvyy, new FormData("100%"));
		// lc11.add(lc1_1, new FormData("100%"));

		/** column 정산구분 : */
		LayoutContainer layoutContainer13 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13.setLayout(frmlytSch);

		settGbcd = new MSFComboBox<BaseModel>();
		settGbcd.setName("settGbcd");
		settGbcd.setForceSelection(true);
		settGbcd.setMinChars(1);
		settGbcd.setDisplayField("commCdNm");
		settGbcd.setValueField("commCd");
		settGbcd.setTriggerAction(TriggerAction.ALL);
		settGbcd.setEmptyText("--정산구분선택--");
		settGbcd.setSelectOnFocus(true);
		settGbcd.setReadOnly(false);
		settGbcd.setEnabled(true);
		settGbcd.setStore(lscreSettGbcd);
		settGbcd.setFieldLabel("정산구분");
		settGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});

		layoutContainer13.add(settGbcd, new FormData("100%"));
		layoutContainer13.setBorders(false);

		/** column 제출일자 : */
		LayoutContainer layoutContainer14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14.setLayout(frmlytSch);

		edacPrdt = new MSFDateField();
		edacPrdt.setName("edacPrdt");
		new DateFieldMask(edacPrdt, "9999.99.99");
		edacPrdt.setValue(new Date());

		edacPrdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		edacPrdt.setFieldLabel("제출일자");

		layoutContainer14.add(edacPrdt, new FormData("100%"));
		layoutContainer14.setBorders(false);
		
		
		
		/** edacSeilNum 연말정산마감일련번호 : */
		LayoutContainer layoutContainer36 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer36.setLayout(frmlytSch);

		edacSeilNum = new MSFNumberField();
		edacSeilNum.setAllowDecimals(true); 
		edacSeilNum.setPropertyEditorType(Long.class); 
		edacSeilNum.setFormat(NumberFormat.getDecimalFormat());
		edacSeilNum.setName("edacSeilNum");
		edacSeilNum.setFieldLabel("일련번호");
		edacSeilNum.setReadOnly(true);
		edacSeilNum.setSelectOnFocus(true);

		layoutContainer36.add(edacSeilNum, new FormData("100%"));
		layoutContainer36.setBorders(false);

		/** column 신고파일 : */
		LayoutContainer layoutContainer15 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer15.setLayout(frmlytSch);
			
		
		//TODO 
		/*
		 * 1.근로소득지급명세서 2.의료비명세서 3.기부금명세서
		 */

		creFile = new MSFComboBox<BaseModel>();
		creFile.setName("creFile");
		creFile.setForceSelection(true);
		creFile.setMinChars(1);
		creFile.setDisplayField("commCdNm");
		creFile.setValueField("commCd");
		creFile.setTriggerAction(TriggerAction.ALL);
		creFile.setEmptyText("--신고파일--");
		creFile.setSelectOnFocus(true);
		creFile.setReadOnly(false);
		creFile.setEnabled(true);
		creFile.setStore(lsFileType);
		creFile.setFieldLabel("신고파일");

		layoutContainer15.add(creFile, new FormData("100%"));
		layoutContainer15.setBorders(false);

		/** column 대표자(성명) : */
		LayoutContainer layoutContainer16 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer16.setLayout(frmlytSch);

		reprName = new MSFTextField();
		reprName.setName("reprName");
		reprName.setFieldLabel("대표자(성명)");
		reprName.setSelectOnFocus(true);

		layoutContainer16.add(reprName, new FormData("100%"));
		layoutContainer16.setBorders(false);

		/** column 법인명(상호) : */
		LayoutContainer layoutContainer17 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer17.setLayout(frmlytSch);

		juriName = new MSFTextField();
		juriName.setName("juriName");
		juriName.setFieldLabel("법인명(상호)");
		juriName.setSelectOnFocus(true);

		layoutContainer17.add(juriName, new FormData("100%"));
		layoutContainer17.setBorders(false);

		/** column 사업자등록번호 : */
		LayoutContainer layoutContainer18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer18.setLayout(frmlytSch);

		busiNumb = new MSFTextField();
		busiNumb.setName("busiNumb");
		new TextFieldMask<String>(busiNumb, "999-99-99999");
		busiNumb.setFieldLabel("사업자번호");

		layoutContainer18.add(busiNumb, new FormData("100%"));
		layoutContainer18.setBorders(false);

		/** column 주민등록번호 : */
		LayoutContainer layoutContainer19 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer19.setLayout(frmlytSch);

		resuNumb = new MSFTextField();
		resuNumb.setName("resuNumb");
		new TextFieldMask<String>(resuNumb, "999999-9999999");
		resuNumb.setFieldLabel("주민등록번호");

		layoutContainer19.add(resuNumb, new FormData("100%"));
		layoutContainer19.setBorders(false);

		/** column 법인번호 : */
		LayoutContainer layoutContainer20 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer20.setLayout(frmlytSch);

		juriNumb = new MSFTextField();
		juriNumb.setName("juriNumb");
		juriNumb.setFieldLabel("법인번호");
		juriNumb.setSelectOnFocus(true);

		layoutContainer20.add(juriNumb, new FormData("100%"));
		layoutContainer20.setBorders(false);

		/** column 소재지주소 : */
		LayoutContainer layoutContainer21 = new LayoutContainer(new ColumnLayout());
				
		LayoutContainer lcIncmPost = new LayoutContainer();
				
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcIncmPost.setLayout(frmlytSch);
				
				
		incmPost = new MSFTextField();
		incmPost.setName("incmPost");
		incmPost.setEmptyText("(우편번호)");
		incmPost.setFieldLabel("소재지주소");
		incmPost.setSelectOnFocus(true);

		lcIncmPost.add(incmPost, new FormData("100%"));

		LayoutContainer lcIncmAddr = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcIncmAddr.setLayout(frmlytSch);

		incmAddr = new MSFTextField();
		incmAddr.setLabelSeparator("");
		incmAddr.setEmptyText("기본주소");
		incmAddr.setName("incmAddr");
		incmAddr.setSelectOnFocus(true);

		lcIncmAddr.add(incmAddr, new FormData("100%"));

		LayoutContainer lcIncmAdtl = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcIncmAdtl.setLayout(frmlytSch);

		incmAdtl = new MSFTextField();
		incmAdtl.setLabelSeparator("");
		incmAdtl.setEmptyText("상세주소");
		incmAdtl.setName("incmAdtl");
		incmAdtl.setSelectOnFocus(true);
				
		lcIncmAdtl.add(incmAdtl, new FormData("100%"));
				
		layoutContainer21.add(lcIncmPost, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer21.add(lcIncmAddr, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer21.add(lcIncmAdtl, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer21.setBorders(false);

		/** column 관할세무서코드 : */
		LayoutContainer layoutContainer22 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer22.setLayout(frmlytSch);

		taxaCode = new MSFTextField();
		taxaCode.setName("taxaCode");
		taxaCode.setFieldLabel("관할세무서");
		taxaCode.setSelectOnFocus(true);

		layoutContainer22.add(taxaCode, new FormData("100%"));
		layoutContainer22.setBorders(false);

		/** column 제출자구분 : */
		LayoutContainer layoutContainer23 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer23.setLayout(frmlytSch);

		incmGbcd = new MSFTextField();
		incmGbcd.setName("incmGbcd");
		incmGbcd.setFieldLabel("제출자구분");
		incmGbcd.setSelectOnFocus(true);

		layoutContainer23.add(incmGbcd, new FormData("100%"));
		layoutContainer23.setBorders(false);

		/** column 세무대리인번호 : */
		LayoutContainer layoutContainer24 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer24.setLayout(frmlytSch);

		taxaDnum = new MSFTextField();
		taxaDnum.setName("taxaDnum");
		taxaDnum.setFieldLabel("세무대리인번호");
		taxaDnum.setSelectOnFocus(true);

		layoutContainer24.add(taxaDnum, new FormData("100%"));
		layoutContainer24.setBorders(false);

		/** column 홈텍스 ID : */
		LayoutContainer layoutContainer25 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer25.setLayout(frmlytSch);

		homeTxid = new MSFTextField();
		homeTxid.setName("homeTxid");
		homeTxid.setFieldLabel("홈텍스 ID");
		homeTxid.setSelectOnFocus(true);

		layoutContainer25.add(homeTxid, new FormData("100%"));
		layoutContainer25.setBorders(false);

		/** column 세무프로그램코드 : */
		LayoutContainer layoutContainer26 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer26.setLayout(frmlytSch);

		taxaPrcd = new MSFTextField();
		taxaPrcd.setName("taxaPrcd");
		taxaPrcd.setFieldLabel("세무프로그램코드");
		taxaPrcd.setSelectOnFocus(true);

		layoutContainer26.add(taxaPrcd, new FormData("100%"));
		layoutContainer26.setBorders(false);

		/** column temp : */
		LayoutContainer layoutContainer27 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer27.setLayout(frmlytSch);

		TextField<String> tpTaxaPrcd = new TextField<String>(); 
		tpTaxaPrcd.setVisible(false);
		layoutContainer27.add(tpTaxaPrcd, new FormData("100%"));
		layoutContainer27.setBorders(false);

		/** column 담당부서명 : */
		LayoutContainer layoutContainer28 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer28.setLayout(frmlytSch);

		charDept = new MSFTextField();
		charDept.setName("taxaPrCd");
		charDept.setFieldLabel("담당부서명");
		charDept.setSelectOnFocus(true);

		layoutContainer28.add(charDept, new FormData("100%"));
		layoutContainer28.setBorders(false);

		/** column 담당자전화번호 : */
		LayoutContainer layoutContainer29 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer29.setLayout(frmlytSch);

		charTele = new MSFTextField();
		charTele.setName("charTele");
		charTele.setFieldLabel("담당자전화번호");
		charTele.setSelectOnFocus(true);
		charTele.setEmptyText("(02-323-3456 형태로 입력)");
		layoutContainer29.add(charTele, new FormData("100%"));
		layoutContainer29.setBorders(false);

		/** column 담당자전화번호 : */
		//LayoutContainer layoutContainer30 = new LayoutContainer();
		//frmlytSch = new FormLayout();
		//frmlytSch.setLabelWidth(150);
		//frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		//layoutContainer30.setLayout(frmlytSch);
		//layoutContainer30.setHeight(24);
		//Label txt3 = new Label();
		
		//layoutContainer30.add(txt3, new FormData("100%"));
		//layoutContainer30.setBorders(false);
		//layoutContainer30.setStyleAttribute("fontSize", "15px");
		//layoutContainer30.setStyleAttribute("textAlign", "left");

		/** column 담당자성명 : */
		LayoutContainer layoutContainer31 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer31.setLayout(frmlytSch);

		charName = new MSFTextField();
		charName.setName("charName");
		charName.setFieldLabel("담당자성명");
		charName.setSelectOnFocus(true);

		layoutContainer31.add(charName, new FormData("100%"));
		layoutContainer31.setBorders(false);

		/** column 파일암호 : */
		LayoutContainer layoutContainer32 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer32.setLayout(frmlytSch);

		filePass = new MSFTextField();
		filePass.setName("filePass");
		filePass.setFieldLabel("파일암호");
		filePass.setSelectOnFocus(true);

		layoutContainer32.add(filePass, new FormData("100%"));
		layoutContainer32.setBorders(false);

		/** column 파일암호 text : */
		LayoutContainer layoutContainer33 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer33.setLayout(frmlytSch);
		layoutContainer33.setHeight(24);
		Label txt4 = new Label();
		txt4.setText("암호는 홈텍스 ID로 파일이 생성됩니다.");
		layoutContainer33.add(txt4, new FormData("100%"));
		layoutContainer33.setBorders(false);
		layoutContainer33.setStyleAttribute("fontSize", "15px");
		layoutContainer33.setStyleAttribute("textAlign", "left");

		/** column text : */
		LayoutContainer layoutContainer34 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer34.setLayout(frmlytSch);
		layoutContainer34.setHeight(24);
				
		Label txt5 = new Label();
		txt5.setText("연말정산신고내역은 종/전근무지를 모두 합한 금액으로 계산된 내역입니다.");
		layoutContainer34.add(txt5, new FormData("100%"));
		layoutContainer34.setBorders(false);
		layoutContainer34.setStyleAttribute("fontSize", "15px");
		layoutContainer34.setStyleAttribute("textAlign", "right");
		layoutContainer34.setStyleAttribute("font-weight", "bold");

		plFrmYeta1400.add(fieldSet_2);


		lcSchCol2.add(lc1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); // 정산년도
		lcSchCol2.add(layoutContainer13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 정산구분
		lcSchCol2.add(layoutContainer14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 제출일자
		lcSchCol2.add(layoutContainer36,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15)); 	// 연말정산일련번호
		lcSchCol2.add(layoutContainer15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 신고파일
		lcSchCol2.add(layoutContainer16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 대표자(성명)
		lcSchCol2.add(layoutContainer17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75)); 	// 법인명(상호)
		lcSchCol2.add(layoutContainer18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 사업자등록번호
		lcSchCol2.add(layoutContainer19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 		// 주민등록번호
		lcSchCol2.add(layoutContainer20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 	// 법인번호
		lcSchCol2.add(layoutContainer21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); 		// 소재지주소
		lcSchCol2.add(layoutContainer22,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 관할세무서코드
		lcSchCol2.add(layoutContainer23,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 		// 제출자구분
		lcSchCol2.add(layoutContainer24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 	// 세무대리인번호
		lcSchCol2.add(layoutContainer25,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 홈텍스 ID
		lcSchCol2.add(layoutContainer26,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 		// 세무프로그램코드
		lcSchCol2.add(layoutContainer27,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 	// 공백
		lcSchCol2.add(layoutContainer28,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 		// 담당부서명
		lcSchCol2.add(layoutContainer29,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 담당자전화번호
	//	lcSchCol2.add(layoutContainer30,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 담당자전화번호 text
		lcSchCol2.add(layoutContainer31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 담당자성명
		lcSchCol2.add(layoutContainer32,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 파일암호
		lcSchCol2.add(layoutContainer33,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45)); 	// 파일암호 text
		lcSchCol2.add(layoutContainer34,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); 		// 파일암호 text
	}
	


	private void createYeta1400Form() {

		plFrmYeta1400 = new FormPanel();
		plFrmYeta1400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산신고파일생성"));
		plFrmYeta1400.setIcon(Resources.APP_ICONS.text());
		plFrmYeta1400.setPadding(2);
		plFrmYeta1400.setFrame(true);
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("연말정산신고파일생성","YETA0400");
				}
			});
		plFrmYeta1400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta1400.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		   //멀티콤보박스 닫기 
		plFrmYeta1400.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
		            @Override
		            public void handleEvent(ComponentEvent ce) { 
		            
		             //   for (Field<?>  f : ((FormPanel) plFrmRemt0100).getFields()) {
	                        
		            //        if (f instanceof MSFMultiComboBox<?>) {
		                        
//						                        if ("srhDeptCd".equals(f.getName())) {
//						                            
//						                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//						                            
//						                        }
	                            
	                  //      } else {
		                   if (mutilCombo) {
	                            if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
	                                srhDeptCd.showClose(ce);
	                                mutilCombo = false;
	                         //   } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
	                         //       srhHdofcCodtnCd.showClose(ce);
	                          //      mutilCombo = false;
	                            } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
	                                //직종
	                                srhTypOccuCd.showClose(ce);
	                                mutilCombo = false;
	                              //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
	                            } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
	                                //직종세
	                                srhDtilOccuInttnCd.showClose(ce);
	                                mutilCombo = false;
	                            } else if ( srhBusinCd.getCheckBoxListHolder().isVisible() ) {
	                                //사업코드 
	                            	srhBusinCd.showClose(ce);
	                                mutilCombo = false;
	                            } else if ( creDeptCd.getCheckBoxListHolder().isVisible() ) {
	                            	creDeptCd.showClose(ce);
	                                mutilCombo = false;
	                         //   } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
	                         //       srhHdofcCodtnCd.showClose(ce);
	                          //      mutilCombo = false;
	                            } else if (creTypOccuCd.getCheckBoxListHolder().isVisible() ) {
	                                //직종
	                            	creTypOccuCd.showClose(ce);
	                                mutilCombo = false;
	                              //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
	                            } else if ( creDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
	                                //직종세
	                            	creDtilOccuInttnCd.showClose(ce);
	                                mutilCombo = false;
	                            }   else if ( creBusinCd.getCheckBoxListHolder().isVisible() ) {
	                                //사업
	                            	creBusinCd.showClose(ce);
	                                mutilCombo = false;
	                            }  
	                            
		                   }
	                    //    }
		            //    } 
		            } 
		        });

		vp.add(plFrmYeta1400);
	}
	
	
	/** 검색조건 **/
	private void createSearchForm() {
		
		topYeta1400Bar = new ButtonBar();
		topYeta1400Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnYeta1400Reset = new Button("초기화");
		btnYeta1400Reset.setIcon(MSFMainApp.ICONS.new16());
		btnYeta1400Reset.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				resetStandardForm();	//전자신고기본정보 초기화
			}
		});
		topYeta1400Bar.add(btnYeta1400Reset);

//		topBtn = new Button("신 규");
//		topBtn.setIcon(MSFMainApp.ICONS.new16());
//		topYeta1400Bar.add(topBtn);

//		topBtn = new Button("수 정");
//		topBtn.setIcon(MSFMainApp.ICONS.edit());
//		buttonBar.add(topBtn);

//		topBtn = new Button("삭 제");
//		topBtn.setIcon(MSFMainApp.ICONS.delete16());
//		buttonBar.add(topBtn);

		btnYeta1400Save = new Button("저 장");
		btnYeta1400Save.setIcon(MSFMainApp.ICONS.save16());
		btnYeta1400Save.addListener(Events.Select, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				saveYeta1400();	//저장
			}
		});
		
		topYeta1400Bar.add(btnYeta1400Save);

		btnYeta1400Search = new Button("조 회");
		btnYeta1400Search.setIcon(MSFMainApp.ICONS.search());
		btnYeta1400Search.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				yeta1000Dto = new Ye16Ta1000DTO();
				yeta1000Bm = new Ye16Ta1000BM();
				
//				yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
				yeta1000Bm.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
				
//				yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
				yeta1000Bm.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
				
//				yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				yeta1000Bm.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				
//				yeta1000Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				yeta1000Bm.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				
				String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//				yeta1000Dto.setDeptCd(strDeptCd);
				yeta1000Bm.setDeptCd(strDeptCd);
				
				String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//				yeta1000Dto.setTypOccuCd(strTypOccuCd);
				yeta1000Bm.setTypOccuCd(strTypOccuCd);
				
				String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//				yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);
				yeta1000Bm.setDtilOccuInttnCd(strDtilOccuInttnCd);
				
//				yeta1000Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//				yeta1000Bm.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				yeta1000Bm.setBusinCd(strBusinCd);
				
				
				yeta1000Bm.setYetaDpcd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
				yeta1000Bm.setBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
				
				yeta1400Service.getYeta1400List(yeta1000Bm, new AsyncCallback<Ye16Ta1005BM>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "조회에 실패하였습니다.", null);
					}

					@Override
					public void onSuccess(Ye16Ta1005BM result) {
						// TODO Auto-generated method stub
						yeta0300Dtail(result);
						
						//연말정산신고내역 조회
						reload();
					} 
				});
			}
		});
		topYeta1400Bar.add(btnYeta1400Search);

//		topBtn = new Button("인 쇄");
//		topBtn.setIcon(MSFMainApp.ICONS.print16());
//		buttonBar.add(topBtn);
		
		plFrmYeta1400.add(topYeta1400Bar);
		
		
		////dpobCd = new HiddenField<String>();		//사업장코드
		//systemkey = new HiddenField<String>(); 	//시스템키

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();

		// --------------------단위기관 불러 오는 함수------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto); // 단위기관
		// --------------------단위기관 불러 오는 함수------------------------------------------------

		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분
		
		sysComBass0300Dto.setRpsttvCd("Y009");
		lsFileType = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분
		 
		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); // 고용구분
		
		
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);//호봉
		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
		
		// --------------------사업 불러 오는 함수-------------------------------------------------
//		lsBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
		// --------------------사업 불러 오는 함수-------------------------------------------------
		
		// --------------------정산년도 불러 오는 함수------------------------------------------------
		lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		// --------------------정산년도 불러 오는 함수------------------------------------------------
//		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		
		
		// --------------------연말정산 불러 오는 함수------------------------------------------------	
//		ye16Ta1005Dto = new Ye16Ta1005DTO();
//		ye16Ta1005Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
//		ye16Ta1005Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//		ye16Ta1005Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());    /** column 부서코드 : deptCd */
//		lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdList(ye16Ta1005Dto);
		lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdListNoAuth();
		// --------------------연말정산 불러 오는 함수------------------------------------------------		

		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

		lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});
	
		

		
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd);
			    srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

			}
		});
		
		plFrmYeta1400.setLayout(new FlowLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
//		fieldSet.setHeight("80px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());
		fieldSet.add(lcSchCol1, new FormData("100%"));

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		layoutContainer1_1.setLayout(new ColumnLayout());

		/** column 지급년 : ClutYr */
		LayoutContainer layoutContainer1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1.setLayout(frmlytSch);

		srhEdacRvyy = new ComboBox<BaseModel>();
		srhEdacRvyy.setName("srhEdacRvyy");
		srhEdacRvyy.setForceSelection(true);
		srhEdacRvyy.setMinChars(1);
		srhEdacRvyy.setDisplayField("yearDisp");
		srhEdacRvyy.setValueField("year");
		srhEdacRvyy.setTriggerAction(TriggerAction.ALL);
		srhEdacRvyy.setSelectOnFocus(true);
		srhEdacRvyy.setReadOnly(true);
		srhEdacRvyy.setEnabled(true);
		srhEdacRvyy.setStore(lsClutYrStore);
		srhEdacRvyy.setFieldLabel("정산년도");
		srhEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		srhEdacRvyy.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"deptCd");
							sysComBass0500Dto.setDeptCd(strDeptCd);
							//sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						 
						lsBusinCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistBusinCd = YetaUtils.getBusinCdModelData(lsBusinCd);
								srhBusinCd.getInitStore().add(mDtalistBusinCd);
							}
						});
						
//						srhBusinCd.setStore(lsBusinCd);
//						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//							public void handleEvent(StoreEvent<BaseModel> be) {
//									// searchBusinCd.setValue(lsBusinCd.getAt(0));
//							}
//						});
					} else {
							// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
							// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
							// return;
					}
				}
			}
		});
		layoutContainer1.add(srhEdacRvyy, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);

		// /** column 지급월 : Mnth */
		// LayoutContainer layoutContainer2 = new LayoutContainer();
		// frmlytSch = new FormLayout();
		// frmlytSch.setLabelWidth(0);
		// frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// layoutContainer2.setLayout(frmlytSch);
		//
		// srhClutMnth = new ComboBox<BaseModel>();
		// srhClutMnth.setName("srhClutMnth");
		// srhClutMnth.setForceSelection(true);
		// srhClutMnth.setMinChars(1);
		// srhClutMnth.setDisplayField("monthDisp");
		// srhClutMnth.setValueField("month");
		// srhClutMnth.setTriggerAction(TriggerAction.ALL);
		// srhClutMnth.setSelectOnFocus(true);
		// srhClutMnth.setStore(lsClutMnth);
		// srhClutMnth.setHideLabel(true);
		// layoutContainer2.add(srhClutMnth, new FormData("100%"));
		// layoutContainer1_1.add(layoutContainer2,new
		// com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		// layoutContainer2.setBorders(false);

		/** column 정산구분 : CalcSevePayPsnDivCd */
		LayoutContainer layoutContainer3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch);
		
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

			}
		});
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

				// --------------------부서 불러 오는 함수------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// --------------------부서 불러 오는 함수------------------------------------------------
				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});
			}
		});
		layoutContainer3.add(srhPayrMangDeptCd, new FormData("100%"));

//		srhSettGbcd = new ComboBox<BaseModel>();
//		srhSettGbcd.setName("srhSettGbcd");
//		srhSettGbcd.setForceSelection(true);
//		srhSettGbcd.setMinChars(1);
//		srhSettGbcd.setDisplayField("commCdNm");
//		srhSettGbcd.setValueField("commCd");
//		srhSettGbcd.setTriggerAction(TriggerAction.ALL);
//		srhSettGbcd.setSelectOnFocus(true);
//		srhSettGbcd.setReadOnly(false);
//		srhSettGbcd.setEnabled(true);
//		srhSettGbcd.setStore(lsSettGbcd);
//		srhSettGbcd.setFieldLabel("정산구분");
////		srhSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
////			public void handleEvent(StoreEvent<BaseModel> be) {
////			
////			}
////		});
//
//		layoutContainer3.add(srhSettGbcd, new FormData("100%"));
		layoutContainer3.setBorders(false);
 
		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4.setLayout(frmlytSch);
		
		srhSettGbcd = new ComboBox<BaseModel>();
		srhSettGbcd.setName("srhSettGbcd");
		srhSettGbcd.setForceSelection(true);
		srhSettGbcd.setMinChars(1);
		srhSettGbcd.setDisplayField("commCdNm");
		srhSettGbcd.setValueField("commCd");
		srhSettGbcd.setTriggerAction(TriggerAction.ALL);
		srhSettGbcd.setSelectOnFocus(true);
		srhSettGbcd.setReadOnly(false);
		srhSettGbcd.setEnabled(true);
		srhSettGbcd.setStore(lsSettGbcd);
		srhSettGbcd.setFieldLabel("정산구분");
//		srhSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//			
//			}
//		});

		layoutContainer4.add(srhSettGbcd, new FormData("100%"));

//		srhPayrMangDeptCd = new ComboBox<BaseModel>();
//		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
//		srhPayrMangDeptCd.setForceSelection(true);
//		srhPayrMangDeptCd.setMinChars(1);
//		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
//		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
//		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
//		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
//		srhPayrMangDeptCd.setSelectOnFocus(true);
//		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//		srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
//		srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);
//		srhPayrMangDeptCd.setFieldLabel("단위기관");
//		lsPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//
//			}
//		});
//		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				sysComBass0400Dto.setDeptDspyYn("Y");
//				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//
//				// --------------------부서 불러 오는 함수------------------------------------------------
//				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
//				// --------------------부서 불러 오는 함수------------------------------------------------
//				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
//					public void handleEvent(StoreEvent<BaseModel> be) {
//						mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
//						srhDeptCd.getInitStore().add(mDtalistDeptCd);
//					}
//				});
//			}
//		});
//		layoutContainer4.add(srhPayrMangDeptCd, new FormData("100%"));
		layoutContainer4.setBorders(false);


		/** column 고용구분 : EmymtDivCd */
		LayoutContainer layoutContainer7 = new LayoutContainer(new ColumnLayout());
		layoutContainer7.setBorders(false);
		
		LayoutContainer layoutContainer77 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer77.setLayout(frmlytSch);

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
		lsEmymtDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd", "srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta1400Auth("srhEmymtDivCd", lsEmymtDivCd);
				}
			}
		});
		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null
								&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					if ((srhDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							//sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
							String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"deptCd");
							sysComBass0500Dto.setDeptCd(strDeptCd);
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						
						lsBusinCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistBusinCd = YetaUtils.getBusinCdModelData(lsBusinCd);
								srhBusinCd.getInitStore().add(mDtalistBusinCd);
							}
						});
						
						
						
					//	mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lsDtilOccuInttnCd);
					//	srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
						
						
						
////						srhBusinCd.setStore(lsBusinCd);
////						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//							public void handleEvent(StoreEvent<BaseModel> be) {
//								// searchBusinCd.setValue(lsBusinCd.getAt(0));
//							}
//						});
					} else {
						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
						// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
						// return;
					}
					srhBusinCd.setEnabled(true);
					srhTypOccuCd.reset();
					srhTypOccuCd.setEnabled(false);
					srhDtilOccuInttnCd.reset();
					srhDtilOccuInttnCd.setEnabled(false);
				} else {
					srhBusinCd.reset();
					srhBusinCd.setEnabled(false);

					//if (gwtAuthorization.getCheckOccuDisabled()) {
					 	srhTypOccuCd.setEnabled(true);
					 	srhDtilOccuInttnCd.setEnabled(true);
					//} else {
					//	srhTypOccuCd.setEnabled(false);
					//	srhDtilOccuInttnCd.setEnabled(false);
					//}
				}
			}
		});
		layoutContainer77.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer7.add(layoutContainer77, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
	    
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
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
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer7.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	   
		
		
		LayoutContainer layoutContainer8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer8.setLayout(frmlytSch);

		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta1400Auth("srhDeptCd", lsDeptCd);
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhDeptCd.getListView().getChecked().size() > 0) 
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));
						List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
						String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"deptCd");
						sysComBass0500Dto.setDeptCd(strDeptCd);
						//sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}
 
					// --------------------사업 불러 오는 함수-------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500MultiCombo(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수-------------------------------------------------
					
					//mDtalistBusinCd = YetaUtils.getBusinCdModelData(lsBusinCd);
//					srhBusinCd.getInitStore().add(mDtalistBusinCd);
					lsBusinCd.addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
							mDtalistBusinCd = YetaUtils.getBusinCdModelData(lsBusinCd);
							srhBusinCd.getInitStore().add(mDtalistBusinCd);

						}
					});
					
//					srhBusinCd.setStore(lsBusinCd);  
//					srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//						public void handleEvent(StoreEvent<BaseModel> be) {
//							// searchBusinCd.setValue(lsBusinCd.getAt(0));
//						}
//					});
				} else if ((srhDeptCd.getListView().getChecked().size() > 0) 
						&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
					// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
					// return;
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
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		layoutContainer8.add(srhDeptCd, new FormData("100%"));
		layoutContainer8.setBorders(false);

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_3 = new LayoutContainer();
		layoutContainer1_3.setLayout(new ColumnLayout());
		
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
		

		/** column 직종 : TypOccuCd */
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuCd.setLayout(frmlytSch);

		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		srhTypOccuCd.setHideLabel(true);
//		srhTypOccuCd.setFieldLabel("직종");
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
					 *  lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					//checkYeta1400Auth("srhTypOccuCd", lsTypOccuCd);
				}
			}
		});

		srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhTypOccuCd.getListView().getChecked().size() > 0)
						&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					// 직종변경에 따른 직종세 값 가져오기
					List<ModelData> mdListDeptCdSelect = srhDeptCd.getListView().getChecked();
					String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdListDeptCdSelect,"deptCd");
					sysComBass0350Dto.setDeptCd(strDeptCd);
					
					List<ModelData> mdListSelect = srhTypOccuCd.getListView().getChecked();

					String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd");
					sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));

					if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {

						lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
						// srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd);
						lsDtilOccuInttnCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lsDtilOccuInttnCd);
								srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);

							}
						});
					}
				} else {

				}
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
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});
		lcTypOccuCd.add(srhTypOccuCd, new FormData("100%"));

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

		
		layoutContainer1_3.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer1_3.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer1_3.setBorders(false);

		/** column 사업 : BusinCd */
		LayoutContainer layoutContainer9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9.setLayout(frmlytSch);

//		srhBusinCd = new ComboBox<BaseModel>();
//		srhBusinCd.setName("srhBusinCd");
//		srhBusinCd.setForceSelection(true);
//		srhBusinCd.setMinChars(1);
//		srhBusinCd.setDisplayField("businNm");
//		srhBusinCd.setValueField("businCd");
//		srhBusinCd.setTriggerAction(TriggerAction.ALL);
//		srhBusinCd.setEmptyText("--사업선택--");
//		srhBusinCd.setSelectOnFocus(true);
//		srhBusinCd.getListView().setWidth("200px");
//		srhBusinCd.setStore(lsBusinCd);
//		srhBusinCd.setFieldLabel("사업");
//		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		
		srhBusinCd = new MSFMultiComboBox<ModelData>();
		srhBusinCd.setName("srhBusinCd");
		srhBusinCd.setEmptyText("--사업선택--");
		srhBusinCd.getListView().setDisplayProperty("businNm");
		srhBusinCd.getStore().add(mDtalistBusinCd);
		srhBusinCd.setWidth(100);
		srhBusinCd.setFieldLabel("사업");
//		srhBusinCd.setHideLabel(true);
		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		srhBusinCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
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
		
		layoutContainer9.add(srhBusinCd, new FormData("100%"));
		layoutContainer9.setBorders(false);
		
		
		LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());


		LayoutContainer layoutContainer_16_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_1.setLayout(frmlytSch);
			    
		srhYetaDpcd = new ComboBox<BaseModel>();
		srhYetaDpcd.setName("srhYetaDpcd");
		srhYetaDpcd.setForceSelection(true);
		srhYetaDpcd.setMinChars(1);
		srhYetaDpcd.setDisplayField("yetaDpnm");
		srhYetaDpcd.setValueField("yetaDpcd");
		srhYetaDpcd.setTriggerAction(TriggerAction.ALL);
		srhYetaDpcd.setEmptyText("--원천신고부서--");
		srhYetaDpcd.setSelectOnFocus(true);
		srhYetaDpcd.setReadOnly(false);
		srhYetaDpcd.setEnabled(true);
		srhYetaDpcd.setStore(lsYetaDpcd);
		srhYetaDpcd.setFieldLabel("원천신고부서");
		layoutContainer_16_1.add(srhYetaDpcd, new FormData("100%"));
		layoutContainer_16_1.setBorders(false);
		srhYetaDpcd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 원천신고부서가 변경될 경우 해당하는 사업자등록번호를 가져옴
				BaseModel bmClutYr = se.getSelectedItem();
				
				if (bmClutYr != null) {
					
					
					
					// TODO 콤보 선택시 사업자번호 스토어 
					lsBusoprRgstnum.removeAll();
					srhBusoprRgstnum.setStore(new ListStore<BaseModel>());
					srhBusoprRgstnum.setValue(new BaseModel());
					
					Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
//					yeta161005Dto.setDpobCd(dpobCd.getValue());
					yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
					
					
					yetaDpcd.setValue("");
					yetaDpcd.setValue(yeta161005Dto.getWhdgTxRegrstDeptCd());
					
					lsBusoprRgstnum = YetaComboUtils.getYeta2000busoprRgstnumList(yeta161005Dto);
					srhBusoprRgstnum.setStore(lsBusoprRgstnum);
					srhBusoprRgstnum.fireEvent(Events.Add);
					
				}else {
					
					
				}
			}
		}); 
		layoutContainer_16_1.add(srhYetaDpcd, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_16_2 = new LayoutContainer();
		layoutContainer_16_2.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_2.setLayout(frmlytSch);

		srhBusoprRgstnum = new ComboBox<BaseModel>();
		srhBusoprRgstnum.setName("srhBusoprRgstnum");
		srhBusoprRgstnum.setHideLabel(true);
		srhBusoprRgstnum.setForceSelection(true);
		srhBusoprRgstnum.setMinChars(1);
		srhBusoprRgstnum.setDisplayField("busoprRgstnum");
		srhBusoprRgstnum.setValueField("busoprRgstnum");
		srhBusoprRgstnum.setTriggerAction(TriggerAction.ALL);
		srhBusoprRgstnum.setEmptyText("--원천신고부서--");
		srhBusoprRgstnum.setSelectOnFocus(false);
		srhBusoprRgstnum.setReadOnly(false);
		srhBusoprRgstnum.setEnabled(true);
		srhBusoprRgstnum.setStore(lsBusoprRgstnum);
		srhBusoprRgstnum.setLabelSeparator("");
		srhBusoprRgstnum.addListener(Events.Add,new Listener<BaseEvent>() { 
			@Override
			public void handleEvent(BaseEvent ce) {
				
				final Timer tmMask = new Timer() {
					public void run() {
						
						if(lsBusoprRgstnum.getCount() <= 0 ) {
							
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"선택하신 원천신고부서에 등록된 정보가 없습니다. </br> 연말정산 대상자 관리 화면에서 [원천징수부서등록 - 원천신고부서]을 해주세요.", null);	
						
						}
					}
					
				};
                tmMask.schedule(4000);
			}
		});
//		creBusoprRgstnum.setFieldLabel("사업자등록번호");
		srhBusoprRgstnum.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 사업자등록번호를 선택할 경우 해당 원천신고부서의 정보를 가져와 뿌려준다.
				BaseModel bmClutYr = se.getSelectedItem();
				
				if (bmClutYr != null) { 
					
					srhBusoprRgstnum.setValue(lsBusoprRgstnum.getAt(0));
					
					yeta1000Dto = new Ye16Ta1000DTO();
					yeta1000Bm = new Ye16Ta1000BM();
					
//					yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
					yeta1000Bm.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
					
//					yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
					yeta1000Bm.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
					
//					yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
					yeta1000Bm.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
					
//					yeta1000Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
					yeta1000Bm.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
					
					String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//					yeta1000Dto.setDeptCd(strDeptCd);
					yeta1000Bm.setDeptCd(strDeptCd);
					
					String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//					yeta1000Dto.setTypOccuCd(strTypOccuCd);
					yeta1000Bm.setTypOccuCd(strTypOccuCd);
					
					String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//					yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);
					yeta1000Bm.setDtilOccuInttnCd(strDtilOccuInttnCd);
					
//					yeta1000Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
					String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//					yeta1000Bm.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
					yeta1000Bm.setBusinCd(strBusinCd);
					
					
					yeta1000Bm.setYetaDpcd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
					yeta1000Bm.setBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
					
					yeta1400Service.getYeta1400List(yeta1000Bm, new AsyncCallback<Ye16Ta1005BM>(){

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "조회에 실패하였습니다.", null);
						}

						@Override
						public void onSuccess(Ye16Ta1005BM result) {
							// TODO Auto-generated method stub
							yeta0300Dtail(result);
							
							//연말정산신고내역 조회
							reload();
						} 
					});
					
					
				}else {
					
				}
			}
		});		
		layoutContainer_16_2.add(srhBusoprRgstnum, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));	
		
		
		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월
		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23)); 	// 단위기관
		lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 정산구분
		lcSchCol1.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 고용구분
		
		
		
		lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 부서
		lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
		lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 사업
		
		lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 

		plFrmYeta1400.add(fieldSet);
//		vp.add(plFrmYeta1400);
	}

	/** 연말정산 신고내역 grid **/
	private void createMsfGridForm() {
		
		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("연말정산신고내역");
		
		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());    
		cpGrid.setSize(965, 240);
		
		msfGridPanel = new MSFGridPanel(yeta1000def, false, false, false, false);
		msfGridPanel.setHeaderVisible(false);  
		msfGridPanel.setSize(965, 190);
		msfGridPanel.setBorders(false);
		
		cpGrid.add(msfGridPanel);
		
	    //마감
	    underFinishToolBar = new ToolBar();
	    underFinishToolBar.getAriaSupport().setLabel("마감일자");

	    underFinishToolBar.add(new LabelToolItem("마감일자: "));
        

	    closDate = new DateField();
	    closDate.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	    closDate.setName("itemApptnBgnnDt"); 
//	    closDate.setFieldLabel("시작일자");
	    closDate.setWidth("100px");
	    closDate.setValue(new Date());
        
        underFinishToolBar.add(closDate);
        underFinishToolBar.setAlignment(HorizontalAlignment.RIGHT); 
        
        underFinishBtnBar = new ButtonBar();     
        underFinishBtnBar.setAlignment(HorizontalAlignment.RIGHT); 
         
        
        btnFinish = new Button("정산마감");
		underFinishBtnBar.add(btnFinish);
		btnFinish.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
    	          
				if (0 >=  msfGridPanel.getMsfGrid().getGrid().getStore().getModels().size()) {
					Window.alert("마감할 데이터를 조회해 주세요.");
					return;

				} else {

					finishYeta1400("Y");

				}
            	
            	
            	
//            	yeta1000Dto = new Ye16Ta1000DTO();
//            	yeta1000Dto.setDpobCd(dpobCd.getValue());
//				
//				yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(edacRvyy,"year"));
//				yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(settGbcd,"commCd"));
//				yeta1000Dto.setPayrMangDeptCd(PayrMangDeptCd.getValue());
//				yeta1000Dto.setEdacSeilNum((Long) edacSeilNum.getValue());
//				
//				yeta1000Dto.setEdacPrdt(YetaUtils.getConvertDateToString(edacPrdt, "yyyyMMdd"));//제출일자
            
            }
		});
		
		btnCancel = new Button("마감풀기");
	    underFinishBtnBar.add(btnCancel);
	    btnCancel.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
    	     	
					if (0 >=  msfGridPanel.getMsfGrid().getGrid().getStore().getModels().size()) {
						Window.alert("마감 풀 데이터를 조회해 주세요.");
						return;

					} else {

						finishYeta1400("N");

					}
            	
//            	yeta1000Dto = new Ye16Ta1000DTO();
//            	yeta1000Dto.setDpobCd(dpobCd.getValue());
//				
//				yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(edacRvyy,"year"));
//				yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(settGbcd,"commCd"));
//				yeta1000Dto.setPayrMangDeptCd(PayrMangDeptCd.getValue());
//				yeta1000Dto.setEdacSeilNum((Long) edacSeilNum.getValue());
//				
//				yeta1000Dto.setEdacPrdt(YetaUtils.getConvertDateToString(edacPrdt, "yyyyMMdd"));//제출일자
            
            }
		});
	    
	    
//	    btnCancel.addListener(Events.Select, new Listener<ButtonEvent>() {
//	    	public void handleEvent(ButtonEvent e) {
//	    		Iterator<BaseModel> itBm  = psnl0126GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//              
//	    		List<Record>  lsRec  = new ArrayList<Record>();
//              
//	    		while(itBm.hasNext()) {
//                  Record rec  = new Record(itBm.next()); 
//                  lsRec.add(rec);
//	    		} 
//	    		setListRecord(lsRec.iterator());  
//               
//              	actionDatabase = ActionDatabase.DELETE;
//              	doFinish(actionDatabase);
//	    	}
//	    });
//        
 
	    
		underFinishToolBar.add(underFinishBtnBar);
        cpGrid.setBottomComponent(underFinishToolBar);
        
        gridFieldSet.add(cpGrid);
        
        LayoutContainer layoutContainer1_5 = new LayoutContainer();
		layoutContainer1_5.setLayout(new ColumnLayout());
//		layoutContainer1_5.setStyleAttribute("marginTop", "10px");

		/** column text : 공백 */
		LayoutContainer space = new LayoutContainer();
		space.setHeight(10);
		space.setWidth(500);
		space.setId("space");
		space.setStyleAttribute("paddingLeft", "10px");

		/** column text : 신고인원수 creDeclare */
		LayoutContainer layoutContainer35 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer35.setLayout(frmlytSch);

		declareCount = new TextField<String>();
		declareCount.setName("declareCount");
		declareCount.setFieldLabel("신고인원수");
		declareCount.setSelectOnFocus(true);
		layoutContainer35.add(declareCount, new FormData("100%"));
		layoutContainer35.setBorders(false);

		/** column text : 재직 creWork */
		LayoutContainer layoutContainer36 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer36.setLayout(frmlytSch);

		workCount = new TextField<String>();
		workCount.setName("creWork");
		workCount.setFieldLabel("재직");
		workCount.setSelectOnFocus(true);
		layoutContainer36.add(workCount, new FormData("100%"));
		layoutContainer36.setBorders(false);

		/** column text : 퇴직 creRetire */
		LayoutContainer layoutContainer37 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer37.setLayout(frmlytSch);

		retireCount = new TextField<String>();
		retireCount.setName("creRetire");
		retireCount.setFieldLabel("퇴직");
		retireCount.setSelectOnFocus(true);
		layoutContainer37.add(retireCount, new FormData("100%"));
		layoutContainer37.setBorders(false);

		layoutContainer1_5.add(space, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer1_5.add(layoutContainer35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer1_5.add(layoutContainer36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer1_5.add(layoutContainer37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer1_5.setBorders(false);

		gridFieldSet.add(layoutContainer1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); // 텍스트와 버튼
		
//        cpGrid.add(msfGridPanel);
//        cpGrid.add(gridFieldSet);

		plFrmYeta1400.add(gridFieldSet);
//		plFrmYeta1400.add(msfGridPanel);
	}

	private void createBottomForm() {
//		LayoutContainer layoutContainer1_5 = new LayoutContainer();
//		layoutContainer1_5.setLayout(new ColumnLayout());
////		layoutContainer1_5.setStyleAttribute("marginTop", "10px");
//
//		/** column text : 공백 */
//		LayoutContainer space = new LayoutContainer();
//		space.setHeight(10);
//		space.setWidth(500);
//		space.setId("space");
//		space.setStyleAttribute("paddingLeft", "10px");
//
//		/** column text : 신고인원수 creDeclare */
//		LayoutContainer layoutContainer35 = new LayoutContainer();
//		FormLayout frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer35.setLayout(frmlytSch);
//
//		declareCount = new TextField<String>();
//		declareCount.setName("declareCount");
//		declareCount.setFieldLabel("신고인원수");
//		declareCount.setSelectOnFocus(true);
//		layoutContainer35.add(declareCount, new FormData("100%"));
//		layoutContainer35.setBorders(false);
//
//		/** column text : 재직 creWork */
//		LayoutContainer layoutContainer36 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer36.setLayout(frmlytSch);
//
//		workCount = new TextField<String>();
//		workCount.setName("creWork");
//		workCount.setFieldLabel("재직");
//		workCount.setSelectOnFocus(true);
//		layoutContainer36.add(workCount, new FormData("100%"));
//		layoutContainer36.setBorders(false);
//
//		/** column text : 퇴직 creRetire */
//		LayoutContainer layoutContainer37 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer37.setLayout(frmlytSch);
//
//		retireCount = new TextField<String>();
//		retireCount.setName("creRetire");
//		retireCount.setFieldLabel("퇴직");
//		retireCount.setSelectOnFocus(true);
//		layoutContainer37.add(retireCount, new FormData("100%"));
//		layoutContainer37.setBorders(false);
//
//		layoutContainer1_5.add(space, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		layoutContainer1_5.add(layoutContainer35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		layoutContainer1_5.add(layoutContainer36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		layoutContainer1_5.add(layoutContainer37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		layoutContainer1_5.setBorders(false);
//
//		plFrmYeta1400.add(layoutContainer1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); // 텍스트와 버튼
		
		
//		vp.add(plFrmYeta1400);

	}
	
	
	/** 기본정보 초기화 **/
	public void resetStandardForm() {

//		PayrMangDeptCd.setValue("");	//급여부서코드
		edacSeilNum.setValue(null);	// 일련번호
		
		creFile.setValue(new BaseModel()); // 신고파일
		reprName.setValue(""); 		// 대표자(성명)
		busiNumb.setValue(""); 		// 사업자등록번호
		resuNumb.setValue(""); 		// 주민등록번호
		juriNumb.setValue(""); 		// 법인번호
		incmPost.setValue(""); 		// 소재지주소_우편번호
		incmAddr.setValue(""); 		// 소재지주소_기본주소
		incmAdtl.setValue(""); 		// 소재지주소_상세주소
		taxaCode.setValue("142"); 	// 관할세무서코드
		incmGbcd.setValue("3"); 	// 제출자구분
		taxaDnum.setValue(""); 		// 세무대리인번호
		homeTxid.setValue(""); 		// 홈텍스ID
		taxaPrcd.setValue("9000"); 	// 세무프로그램코드
		
		charDept.setValue(""); 		// 담당부서명
		charTele.setValue(""); 		// 담당자전화번호
		charName.setValue(""); 		// 담당자성명
		filePass.setValue(""); 		// 파일암호

		declareCount.setValue(""); 	// 신고인원수
		workCount.setValue(""); 	// 재직
		retireCount.setValue(""); 	// 퇴직
		
		msfGridPanel.getMsfGrid().clearData();
	}
	
	
	
	public void reload() {
		// TODO Auto-generated method stub
//		if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
//			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//				return;
//			} 
//		} 
		
//		if("".equals(YetaUtils.getStrValToBMMultiCombo(lsBusinCd, srhBusinCd.getValue(),"businNm","businCd"))){
//			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//				return;
//			} 
//		} 
				    
		IColumnFilter filters = null;
		msfGridPanel.getTableDef().setTableColumnFilters(filters);
		
		//msfGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);//systemkey
		
		msfGridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"), SimpleColumnFilter.OPERATOR_EQUALS);//정산년도
		
		msfGridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		msfGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);//단위기관
		msfGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); //고용구분
		
		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		msfGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);//부서
		
		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		msfGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); //직종
		
		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		msfGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); //직종세
		
//		msfGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);//사업
		msfGridPanel.getTableDef().addColumnFilter("businCd", YetaUtils.getStrValToBMMultiCombo(lsBusinCd, srhBusinCd.getValue(),"businNm","businCd"), SimpleColumnFilter.OPERATOR_EQUALS);//사업
		
		msfGridPanel.getTableDef().addColumnFilter("yetaDpcd", MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"), SimpleColumnFilter.OPERATOR_EQUALS);
		msfGridPanel.getTableDef().addColumnFilter("busoprRgstnum", MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		msfGridPanel.reload();
		
	}
	
	private void yeta0300Dtail(Ye16Ta1005BM result) {
		
// 	PayrMangDeptCd.setValue(result.getPayrMangDeptCd());
		
//		String strEdacSeilNum = String.valueOf(result.getEdacSeilNum());
		
//		edacSeilNum.setValue(MSFSharedUtils.convertStringToLong(result.getEdacSeilNum()));
		reprName.setValue(MSFSharedUtils.allowNulls(result.getReprName()));
		juriName.setValue(MSFSharedUtils.allowNulls(result.getCorpFmnmNm()));
		busiNumb.setValue(MSFSharedUtils.allowNulls(result.getBusoprRgstnum()));
		resuNumb.setValue(MSFSharedUtils.allowNulls(result.getResuNumb()));
		juriNumb.setValue(MSFSharedUtils.allowNulls(result.getCorpNum()));
		incmPost.setValue(MSFSharedUtils.allowNulls(result.getIncmPost()));
		incmAddr.setValue(MSFSharedUtils.allowNulls(result.getIncmAddr()));
		incmAdtl.setValue(MSFSharedUtils.allowNulls(result.getIncmAdtl()));
		
		taxaCode.setValue(MSFSharedUtils.defaultNulls(result.getTxOffcCd(),"142"));
		incmGbcd.setValue(MSFSharedUtils.defaultNulls(result.getPentrSeptCd(),"3"));
		taxaDnum.setValue(MSFSharedUtils.allowNulls(result.getTxDeptyMangeNum()));

		charDept.setValue(MSFSharedUtils.allowNulls(result.getPernChrgDeptNm()));
		taxaPrcd.setValue(MSFSharedUtils.defaultNulls(result.getTxPgmCd(),"9000"));
		homeTxid.setValue(MSFSharedUtils.allowNulls(result.getHmtxId()));
		charTele.setValue(MSFSharedUtils.allowNulls(result.getPernChrgPhnNum()));
		charName.setValue(MSFSharedUtils.allowNulls(result.getPernChrgNm()));
		
 	//	filePass.setValue(MSFSharedUtils.allowNulls(result.getFilePass()));
		
		
	//	declareCount.setValue(value);
	//	workCount.setValue(value);
	//	retireCount.setValue(value);
		
	}
	
	
	
	/** 정산 마감 및 풀기 **/
	private void finishYeta1400(final String flag) { 
		
//	      if (MSFSharedUtils.paramNotNull(PayrMangDeptCd.getValue())) {
	          MessageBox.confirm("마감", "테이터를 마감(마감풀기)하시겠습니까?",new Listener<MessageBoxEvent>(){
	              @Override
	              public void handleEvent(MessageBoxEvent be) {
	                //  if("Yes".equals(be.getButtonClicked().getText())){
	            	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                      
	                	  if (MSFSharedUtils.paramNull(GWTUtils.getStringFromDate(edacPrdt.getValue(),"yyyyMMdd"))) {
	                          MessageBox.alert( "일자오류 ", "마감일자를 입력해 주십시요.", null);
	                          return ;
	                      }
	                	  
//	                    yeta1000Dto = new Ye16Ta1000DTO();
	                    yeta1000Bm = new Ye16Ta1000BM();
	                    
	                    
//	                  	yeta1000Dto.setDpobCd(dpobCd.getValue());
//	      				yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(edacRvyy,"year"));
//	      				yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(settGbcd,"commCd"));
//	      				yeta1000Dto.setPayrMangDeptCd(PayrMangDeptCd.getValue());
//	      				yeta1000Dto.setEdacSeilNum(MSFSharedUtils.allowNulls(edacSeilNum.getValue()));
	      				
	                    yeta1000Bm.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
	                    yeta1000Bm.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(edacRvyy,"year"));
	                    yeta1000Bm.setSettGbcd(MSFSharedUtils.getSelectedComboValue(settGbcd,"commCd"));
//	      				yeta1000Bm.setPayrMangDeptCd(PayrMangDeptCd.getValue());
//	      				yeta1000Bm.setEdacSeilNum((Long) edacSeilNum.getValue());
//	      				yeta1000Bm.setEdacSeilNum((String) edacSeilNum.getValue().toString());
	                    // -- 
	                    
	    				yeta1000Bm.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
	    				
//	    				yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
	    				yeta1000Bm.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
	    				
//	    				yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	    				yeta1000Bm.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	    				
//	    				yeta1000Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	    				yeta1000Bm.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	    				
	    				String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//	    				yeta1000Dto.setDeptCd(strDeptCd);
	    				yeta1000Bm.setDeptCd(strDeptCd);
	    				
	    				String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//	    				yeta1000Dto.setTypOccuCd(strTypOccuCd);
	    				yeta1000Bm.setTypOccuCd(strTypOccuCd);
	    				
	    				String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//	    				yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);
	    				yeta1000Bm.setDtilOccuInttnCd(strDtilOccuInttnCd);
	    				
//	    				yeta1000Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
	    				String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//	    				yeta1000Bm.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
	    				yeta1000Bm.setBusinCd(strBusinCd);
	    				
	    				
	    				yeta1000Bm.setYetaDpcd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
	    				yeta1000Bm.setBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
	      				
	      				
	      				if("Y".equals(flag)) {
//	      					yeta1000Dto.setClosFlag("Y");
//	      					yeta1000Dto.setClosDate(YetaUtils.getConvertDateToString(closDate, "yyyyMMdd"));//마감일자
	      					
	      					yeta1000Bm.setClosFlag("Y");
	      					yeta1000Bm.setClosDate(YetaUtils.getConvertDateToString(closDate, "yyyyMMdd"));//마감일자
	      					
	      				}else {
//	      					yeta1000Dto.setClosFlag("N");
//	      					yeta1000Dto.setClosDate("");//마감일자
	      					
	      					yeta1000Bm.setClosFlag("N");
	      					yeta1000Bm.setClosDate("");//마감일자
	      				}
	      				
	                     
	      				yeta1400Service.finishOnYeta1000(yeta1000Bm, new AsyncCallback<Long>(){
	                         public void onFailure(Throwable caught) {
	                             MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                     MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaFinish() : " + caught), null);
	                         }
	                         public void onSuccess(Long result) { 
	                             
	                            if (result == 0) {
	                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                       ( "Y".equals(flag) ? "마감" : "마감풀기") + "(처리)가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                            } else {
	                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                        ( "Y".equals(flag) ? "마감" : "마감풀기") + "(처리)가 완료되었습니다.", null);
	                                
	                            } 
	                         } 
	      				}); 
	                  }
	              }
	          }); 
//	      } else {
//	    	  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"마감 처리할 데이타가 존재하지 않습니다.", null);
//	    	  return;
//		}
	} 
	 
	
	//신고파일생성
	private void xlsExportData() {
		         
				
		HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("edacRvyy", MSFSharedUtils.getSelectedComboValue(creEdacRvyy,"year"));
		param.put("settGbcd", MSFSharedUtils.getSelectedComboValue(creSettGbcd,"commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
//		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		
		
		
		// 부서, 원천신고부서 둘 중 하나는 필수이며, 둘 중 하나만 입력가능
				if(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") == null  ||  "".equals(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
					
					if(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum")  == null || "".equals(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") )) {
						
						MessageBox.info("", "부서나 원천신고부서 중 한가지는 필수로 선택해주셔야 합니다.", null);
						return;
					}else {
						
						param.put("yetaDpcd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
						param.put("busoprRgstnum", YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") );
						
//						param.put("deptCd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
					 
					}
					
				}else{
					
					if(!"".equals(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum"))  &&  YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") != null ) {
						
						//Window.alert(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum"));
						
						MessageBox.info("", "부서나 원천신고부서 중 한가지만 입력 가능합니다.", null);
						return;
					}else {
						param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") );
					}
					
				}
		param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lscreTypOccuCd, creTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lscreDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//		param.put("businCd", MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"));
		param.put("businCd", YetaUtils.getStrValToBMMultiCombo(lscreBusinCd, creBusinCd.getValue(),"businNm","businCd"));
		param.put("creFile", MSFSharedUtils.getSelectedComboValue(creFile,"commCd"));
		                     
		if(MSFSharedUtils.paramNull(param.get("creFile"))){
			MessageBox.info("", "신고파일은 필수 입니다.", null);
		} else if("".equals(MSFSharedUtils.getSelectedComboValue(creEdacRvyy,"year"))){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
//			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
//			if("".equals(YetaUtils.getStrValToBMMultiCombo(lsBusinCd, creBusinCd.getValue(),"businNm","businCd"))){ 
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//			} else { 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta1400Export.do","extgwtFrame" ,param);   
			//}
		}else{ 
			msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta1400Export.do","extgwtFrame" ,param);  
		}
	}	
	
	/** 전자신고기본정보 수정**/
	private void saveYeta1400() {
		
//		yeta1000Dto = new Ye16Ta1000DTO();
		
//		yeta1000Bm = new Ye16Ta1000BM();
		
		
		yeta161005Bm = new Ye16Ta1005BM();
		
//		yeta161005Bm.setDpobCd(dpobCd.getValue());    														/** column 사업장코드 : dpobCd */
		yeta161005Bm.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));	/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
		yeta161005Bm.setHhrkWhdgRegrstDeptCd("");    														/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
		yeta161005Bm.setTxOffcCd(taxaCode.getValue());    													/** column A3_세무서코드 : txOffcCd */
		yeta161005Bm.setPentrSeptCd(incmGbcd.getValue());    												/** column A5_제출자구분 : pentrSeptCd */
		yeta161005Bm.setTxDeptyMangeNum(taxaDnum.getValue());    											/** column A6_세무대리인관리번호 : txDeptyMangeNum */
		yeta161005Bm.setHmtxId(homeTxid.getValue());    													/** column A7_홈텍스ID : hmtxId */
		yeta161005Bm.setTxPgmCd(taxaPrcd.getValue());    													/** column A8_세무프로그램코드 : txPgmCd */
		yeta161005Bm.setBusoprRgstnum(busiNumb.getValue());    												/** column A9_사업자등록번호 : busoprRgstnum */
		yeta161005Bm.setCorpFmnmNm(juriName.getValue());    												/** column A10_법인_상호명 : corpFmnmNm */
		yeta161005Bm.setPernChrgDeptNm(charDept.getValue());    											/** column A11_담당자부서 : pernChrgDeptNm */
		yeta161005Bm.setPernChrgNm(charName.getValue());    												/** column A12_담당자성명 : pernChrgNm */
		yeta161005Bm.setPernChrgPhnNum(charTele.getValue());    											/** column A13_담당자전화번호 : pernChrgPhnNum */
		yeta161005Bm.setUseHanCd("101");    																/** column A15_사용한글코드 : useHanCd */
		yeta161005Bm.setSumtTgtPridCd("1");    																/** column B16_제출대상기간코드 : sumtTgtPridCd */
		yeta161005Bm.setCorpNum(juriNumb.getValue());    													/** column 법인번호 : corpNum */
		yeta161005Bm.setIncmPost(incmPost.getValue());    													/** column 소득신고의무자우편번호 : incmPost */
		yeta161005Bm.setIncmAddr(incmAddr.getValue());    													/** column 소득신고의무자기본주소 : incmAddr */
		yeta161005Bm.setIncmAdtl(incmAdtl.getValue());    													/** column 소득신고의무자상세주소 : incmAdtl */
//		ye161005Dto.setKybdr(ye161005Dto.getKybdr());    /** column 입력자 : kybdr */
//		ye161005Dto.setInptDt(ye161005Dto.getInptDt());    /** column 입력일자 : inptDt */
//		ye161005Dto.setInptAddr(ye161005Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		ye161005Dto.setIsmt(ye161005Dto.getIsmt());    /** column 수정자 : ismt */
//		ye161005Dto.setRevnDt(ye161005Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		ye161005Dto.setRevnAddr(ye161005Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
		yeta161005Bm.setReprName(reprName.getValue());    													/** column 대표자성명 : reprName */
		yeta161005Bm.setResuNumb(resuNumb.getValue());    													/** column 주민등록번호 : resuNumb */
		
//		yeta1000Bm.setEdacRvyy(YetaUtils.getSelectedComboValue(edacRvyy, "year"));
//		yeta1000Bm.setSettGbcd(YetaUtils.getSelectedComboValue(settGbcd, "commCd"));
////		yeta1000Bm.setEdacSeilNum((Long) edacSeilNum.getValue());
//		yeta1000Bm.setEdacSeilNum((String) edacSeilNum.getValue().toString());
//		
//		
//		yeta1000Bm.setPayrMangDeptCd(PayrMangDeptCd.getValue());
//		
//		yeta1000Bm.setEdacPrdt(YetaUtils.getConvertDateToString(edacPrdt, "yyyyMMdd"));
//		yeta1000Bm.setReprName(reprName.getValue());
//		yeta1000Bm.setJuriName(juriName.getValue());
//		yeta1000Bm.setBusiNumb(busiNumb.getValue());
//		yeta1000Bm.setResuNumb(resuNumb.getValue());
//		yeta1000Bm.setJuriNumb(juriNumb.getValue());
//		yeta1000Bm.setIncmPost(incmPost.getValue());
//		yeta1000Bm.setIncmAddr(incmAddr.getValue());
//		yeta1000Bm.setIncmAdtl(incmAdtl.getValue());
//		yeta1000Bm.setTaxaCode(taxaCode.getValue());
//		yeta1000Bm.setIncmGbcd(incmGbcd.getValue());
//		yeta1000Bm.setTaxaDnum(taxaDnum.getValue());
//		yeta1000Bm.setCharDept(charDept.getValue());
//		yeta1000Bm.setHomeTxid(homeTxid.getValue());
//		yeta1000Bm.setTaxaPrcd(taxaPrcd.getValue()); 
//		yeta1000Bm.setCharTele(charTele.getValue());
//		yeta1000Bm.setCharName(charName.getValue());
//		yeta1000Bm.setFilePass(filePass.getValue());
		
		if("".equals(MSFSharedUtils.allowNulls(YetaUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"))) 
				|| MSFSharedUtils.allowNulls(YetaUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"))  == null) {
			Window.alert("검색조건에서 원천신고부서와 사업자등록번호를 선택해주세요.");
			return;
		}else if("".equals(yeta161005Bm.getBusoprRgstnum()) || yeta161005Bm.getBusoprRgstnum() == null) {
			Window.alert("사업자등록번호를 입력해주세요.");
			return;
		//}else if("".equals(yeta161005Bm.getCorpNum()) || yeta161005Bm.getCorpNum() == null) {
		//	Window.alert("법인등록번호를 입력해주세요.");
		//	return;
		}else if("".equals(yeta161005Bm.getCorpFmnmNm()) || yeta161005Bm.getCorpFmnmNm() == null) {
			Window.alert("상호(법인)명을 입력해주세요.");
			return;
		}else if(MSFSharedUtils.paramNull(yeta161005Bm.getPentrSeptCd()) ||  yeta161005Bm.getPentrSeptCd().length() > 1) {
			Window.alert("제출자구분은 1자리 입니다.");
			return;
		}else if(MSFSharedUtils.paramNull(yeta161005Bm.getTxPgmCd()) ||  yeta161005Bm.getTxPgmCd().length() > 4) {
			Window.alert("세무프로그램코드는 4자리 입니다.");
			return;
		}else if(MSFSharedUtils.paramNull(yeta161005Bm.getTxOffcCd()) ||  yeta161005Bm.getTxOffcCd().length() > 3) {
			Window.alert("관할세무서는 3자리 입니다.");
			return;
		}
		
		
		
//		yeta1000Dto.setEdacRvyy(YetaUtils.getSelectedComboValue(edacRvyy, "commCd"));
//		yeta1000Dto.setSettGbcd(YetaUtils.getSelectedComboValue(settGbcd, "commCd"));
//		yeta1000Dto.setEdacSeilNum(MSFSharedUtils.allowNulls(edacSeilNum.getValue()));
//		yeta1000Dto.setPayrMangDeptCd(PayrMangDeptCd.getValue());
//		
//		yeta1000Dto.setEdacPrdt(YetaUtils.getConvertDateToString(edacPrdt, "yyyyMMdd"));
//		yeta1000Dto.setReprName(reprName.getValue());
//		yeta1000Dto.setJuriName(juriName.getValue());
//		yeta1000Dto.setBusiNumb(busiNumb.getValue());
//		yeta1000Dto.setJuriNumb(juriNumb.getValue());
//		yeta1000Dto.setIncmPost(incmPost.getValue());
//		yeta1000Dto.setIncmAddr(incmAddr.getValue());
//		yeta1000Dto.setIncmAdtl(incmAdtl.getValue());
//		yeta1000Dto.setTaxaCode(taxaCode.getValue());
//		yeta1000Dto.setIncmGbcd(incmGbcd.getValue());
//		yeta1000Dto.setTaxaDnum(taxaDnum.getValue());
//		yeta1000Dto.setCharDept(charDept.getValue());
//		yeta1000Dto.setHomeTxid(homeTxid.getValue());
//		yeta1000Dto.setCharTele(charTele.getValue());
//		yeta1000Dto.setCharName(charName.getValue());
//		yeta1000Dto.setFilePass(filePass.getValue());
//		
		
		yeta1400Service.updateYeta1000(yeta161005Bm, new AsyncCallback<Long>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장에 실패하였습니다.", null);
			}

			@Override
			public void onSuccess(Long result) {
				
				yeta1000Dto = new Ye16Ta1000DTO();
				yeta1000Bm = new Ye16Ta1000BM();
				
//				yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
				yeta1000Bm.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));
				
//				yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
				yeta1000Bm.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"));
				
//				yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				yeta1000Bm.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				
//				yeta1000Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				yeta1000Bm.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				
				String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//				yeta1000Dto.setDeptCd(strDeptCd);
				yeta1000Bm.setDeptCd(strDeptCd);
				
				String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//				yeta1000Dto.setTypOccuCd(strTypOccuCd);
				yeta1000Bm.setTypOccuCd(strTypOccuCd);
				
				String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//				yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);
				yeta1000Bm.setDtilOccuInttnCd(strDtilOccuInttnCd);
				
//				yeta1000Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//				yeta1000Bm.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				yeta1000Bm.setBusinCd(strBusinCd);
				
				
				yeta1000Bm.setYetaDpcd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
				yeta1000Bm.setBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
				
				yeta1400Service.getYeta1400List(yeta1000Bm, new AsyncCallback<Ye16Ta1005BM>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "조회에 실패하였습니다.", null);
					}

					@Override
					public void onSuccess(Ye16Ta1005BM result) {
						// TODO Auto-generated method stub
						yeta0300Dtail(result);
						
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장되었습니다.", null);
						
					} 
				});
				
			}
		});
	}
	
	

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 전자파일저장  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : fileSave
	 * @date : Jan 29, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 29, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 *
	 */
	private void fileSave() {
		 
		
		//        		 if Trim(edREPR_NAME.Text) = '' then
//				   begin
//				      ShowMessage('신고파일 생성을 위한 기본정보가 없습니다. 신규버튼을 클릭하십시요.');
//				      Exit;
//				   end;
//				   if  Trim(edSELF_NAME.Text) = '' then
//				   begin
//				      ShowMessage('신고파일 생성을 위해서는 모든항목이 입력되어야 합니다.');
//				      Exit;
//				   end;
//
				
       HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("edacRvyy", MSFSharedUtils.getSelectedComboValue(creEdacRvyy,"year"));
		param.put("settGbcd", MSFSharedUtils.getSelectedComboValue(creSettGbcd,"commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		
		// 부서, 원천신고부서 둘 중 하나는 필수이며, 둘 중 하나만 입력가능
		if(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") == null  ||  "".equals(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
			
			if(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum")  == null || "".equals(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") )) {
				
				MessageBox.info("", "부서나 원천신고부서 중 한가지는 필수로 선택해주셔야 합니다.", null);
				return;
			}else {
				
				param.put("yetaDpcd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
				param.put("busoprRgstnum", YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") );
				
//				param.put("deptCd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
			 
			}
			
		}else{
			
			if(!"".equals(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum"))  &&  YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") != null ) {
				
				//Window.alert(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum"));
				
				MessageBox.info("", "부서나 원천신고부서 중 한가지만 입력 가능합니다.", null);
				return;
			}else {
				param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") );
			}
			
		}
		
		param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lscreTypOccuCd, creTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lscreDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//		param.put("businCd", MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"));
		param.put("businCd", YetaUtils.getStrValToBMMultiCombo(lscreBusinCd, creBusinCd.getValue(),"businNm","businCd"));
		param.put("creFile", MSFSharedUtils.getSelectedComboValue(creFile,"commCd"));
		
		param.put("edacPrdt", YetaUtils.getConvertDateToString(edacPrdt, "yyyyMMdd"));
		param.put("reprName",reprName.getValue());
		param.put("juriName",juriName.getValue());
		param.put("busiNumb",busiNumb.getValue());
		param.put("resuNumb",resuNumb.getValue());
		
		param.put("juriNumb",juriNumb.getValue());
		param.put("incmPost",incmPost.getValue());
		param.put("incmAddr",incmAddr.getValue());
		param.put("incmAdtl",incmAdtl.getValue());
		param.put("taxaCode",taxaCode.getValue());
		param.put("incmGbcd",incmGbcd.getValue());
		param.put("taxaDnum",taxaDnum.getValue());
		param.put("charDept",charDept.getValue());
		param.put("homeTxid",homeTxid.getValue());
		param.put("taxaPrcd",taxaPrcd.getValue()); 
	    param.put("charTele",charTele.getValue());
		param.put("charName",charName.getValue());
		//param.put("filePass",filePass.getValue());
		   
		
		if(MSFSharedUtils.paramNull(param.get("resuNumb"))){
			MessageBox.info("", "주민등록번호는 필수 입니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("homeTxid"))){
			MessageBox.info("", "홈텍스아이디는 필수 입니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("charDept"))){
			MessageBox.info("", "담당부서명은 필수 입니다.", null);
		}  else if(MSFSharedUtils.paramNull(param.get("charTele"))){
			MessageBox.info("", "담당자 전화번호는  필수 입니다.", null);
		}   else if(MSFSharedUtils.paramNull(param.get("charName"))){
			MessageBox.info("", "담당자 성명은 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("creFile"))){
			MessageBox.info("", "신고파일은 필수 입니다.", null);
		} else if("".equals(MSFSharedUtils.getSelectedComboValue(creEdacRvyy,"year"))){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("deptCd")) && MSFSharedUtils.paramNull(param.get("busoprRgstnum"))){
			MessageBox.info("", "중간 생성부 부서 또는 원천징수부서는 필수 입니다.(택1)", null);
			
		} else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
//			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
			//if("".equals(YetaUtils.getStrValToBMMultiCombo(lsBusinCd, creBusinCd.getValue(),"businNm","businCd"))){ 
			//	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			//} else { 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/FileYeta1400Export.do","extgwtFrame" ,param);   
			//}
		}else{ 
			
//			Window.alert("deptCd :  " + param.get("deptCd") 
//							+ "  yetaDpcd :  " + param.get("yetaDpcd") 
//							+ "  busoprRgstnum :  "  + param.get("busoprRgstnum"));
			msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/FileYeta1400Export.do","extgwtFrame" ,param);  
		}	
		
		
		
	}
	
	  public void setListRecord(Iterator<Record> records) {
		    this.records = records;
		 }
	  
	  public Iterator<Record>  getListRecord() {
			return this.records;
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
 

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 * 검증 추가 
	 *  @RequestMapping(value = "/exp/Yeta1400Verifiction.do") 
	 -------------------------------------------------------------------------------------------------------------------------------------*/
	
	 
	private void  yeta1400Verifiction() { 
		 
       HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("edacRvyy", MSFSharedUtils.getSelectedComboValue(creEdacRvyy,"year"));
		param.put("settGbcd", MSFSharedUtils.getSelectedComboValue(creSettGbcd,"commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		
		// 부서, 원천신고부서 둘 중 하나는 필수이며, 둘 중 하나만 입력가능
		if(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") == null  ||  "".equals(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
			
			if(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum")  == null || "".equals(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") )) {
				
				MessageBox.info("", "부서나 원천신고부서 중 한가지는 필수로 선택해주셔야 합니다.", null);
				return;
			}else {
				
				param.put("yetaDpcd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
				param.put("busoprRgstnum", YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") );
				
//				param.put("deptCd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
			 
			}
			
		}else{
			
			if(!"".equals(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum"))  &&  YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") != null ) {
				
				//Window.alert(YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum"));
				
				MessageBox.info("", "부서나 원천신고부서 중 한가지만 입력 가능합니다.", null);
				return;
			}else {
				param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") );
			}
			
		}
		
		param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lscreTypOccuCd, creTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lscreDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//		param.put("businCd", MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"));
		param.put("businCd", YetaUtils.getStrValToBMMultiCombo(lscreBusinCd, creBusinCd.getValue(),"businNm","businCd"));
		param.put("creFile", MSFSharedUtils.getSelectedComboValue(creFile,"commCd"));
		
		param.put("edacPrdt", YetaUtils.getConvertDateToString(edacPrdt, "yyyyMMdd"));
		param.put("reprName",reprName.getValue());
		param.put("juriName",juriName.getValue());
		param.put("busiNumb",busiNumb.getValue());
		param.put("resuNumb",resuNumb.getValue());
		
		param.put("juriNumb",juriNumb.getValue());
		param.put("incmPost",incmPost.getValue());
		param.put("incmAddr",incmAddr.getValue());
		param.put("incmAdtl",incmAdtl.getValue());
		param.put("taxaCode",taxaCode.getValue());
		param.put("incmGbcd",incmGbcd.getValue());
		param.put("taxaDnum",taxaDnum.getValue());
		param.put("charDept",charDept.getValue());
		param.put("homeTxid",homeTxid.getValue());
		param.put("taxaPrcd",taxaPrcd.getValue()); 
	    param.put("charTele",charTele.getValue());
		param.put("charName",charName.getValue());
		//param.put("filePass",filePass.getValue());
		   
		
		if(MSFSharedUtils.paramNull(param.get("resuNumb"))){
			MessageBox.info("", "주민등록번호는 필수 입니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("homeTxid"))){
			MessageBox.info("", "홈텍스아이디는 필수 입니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("charDept"))){
			MessageBox.info("", "담당부서명은 필수 입니다.", null);
		}  else if(MSFSharedUtils.paramNull(param.get("charTele"))){
			MessageBox.info("", "담당자 전화번호는  필수 입니다.", null);
		}   else if(MSFSharedUtils.paramNull(param.get("charName"))){
			MessageBox.info("", "담당자 성명은 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("creFile"))){
			MessageBox.info("", "신고파일은 필수 입니다.", null);
		} else if("".equals(MSFSharedUtils.getSelectedComboValue(creEdacRvyy,"year"))){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("deptCd")) && MSFSharedUtils.paramNull(param.get("busoprRgstnum"))){
			MessageBox.info("", "중간 생성부 부서 또는 원천징수부서는 필수 입니다.(택1)", null);
			
		} else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/Yeta1400Verifiction.do","extgwtFrame" ,param);   
		 
		}else{ 
 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/Yeta1400Verifiction.do","extgwtFrame" ,param);  
		}	
		 
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 * 검증 추가 종료  
	 *   	 
	 -------------------------------------------------------------------------------------------------------------------------------------*/
	
	 

}
