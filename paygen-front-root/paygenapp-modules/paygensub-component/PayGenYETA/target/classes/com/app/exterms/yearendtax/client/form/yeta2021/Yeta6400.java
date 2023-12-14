package com.app.exterms.yearendtax.client.form.yeta2021;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0120DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161005BM;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2021.Ye18Ta1000Def;
import com.app.exterms.yearendtax.client.service.yeta2021.Yeta6400Service;
import com.app.exterms.yearendtax.client.service.yeta2021.Yeta6400ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
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
import com.google.gwt.event.dom.client.KeyCodes;
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
public class Yeta6400 extends MSFPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	private VerticalPanel vp;
	private FormPanel plFrmYeta6400;
	private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	private MSFGridPanel msfGridPanel;
	private Ye18Ta1000Def ye17Ta1000def = new Ye18Ta1000Def("YETA2400");
	
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
	private ButtonBar topYeta6400Bar;
	private Button btnYeta6400Reset;	//초기화
	private Button btnYeta6400Save;		//저장
	private Button btnYeta6400Search;	//조회
	// ---------- 상단 버튼 종료 ----------
	
	// ---------- 엑셀 버튼 시작 ----------
	private ButtonBar exYeta6400Bar;	
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
	private ComboBox<BaseModel> srhYrtxBlggYr; 				// 귀속년월
	private ComboBox<BaseModel> srhClutSeptCd; 				// 정산구분
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
//	private ComboBox<BaseModel> srhYetaDpcd; 				// 원천신고부서
//	private ComboBox<BaseModel> srhBusoprRgstnum; 			// 사업자등록번호
	private Boolean busoprRgstnumFlag = false; 
	// -------------- 검색조건 폼 종료 --------------
	private HiddenField<String>  whdgTxRegrstDeptCd;
		
	// -------------- 연말정산 생성 폼 시작 --------------
	private ComboBox<BaseModel> creYrtxBlggYr; 				// 귀속년월
	private ComboBox<BaseModel> creClutSeptCd; 				// 정산구분
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
	//private ComboBox<BaseModel> creYetaDpcd; 				// 원천신고부서
	//private ComboBox<BaseModel> creBusoprRgstnum; 			// 사업자등록번호
	//private HiddenField<String> creSystemkey; 				// 시스템키
	// -------------- 연말정산 생성 폼 종료 --------------
	
	private MSFTextField srhUtDpobCd; // 부서명
	private MSFTextField srhUtDpobNm; // 부서명
	private Button btnSrhUtDpobCd;  
//	private CheckBox srhUtDpobChk; // 부서명
	
	private MSFTextField creUtDpobCd; // 부서명
	private MSFTextField creUtDpobNm; // 부서명
	private Button btnCreUtDpobCd;  
	//private CheckBox creUtDpobChk; // 부서명
	
	// -------------- 전자신고 기본정보 폼 시작 --------------
//	private HiddenField<String> yetaDpcd;		// 원천신고부서
	
	
	private MSFComboBox<BaseModel> yrtxBlggYr;	// 정산년도
	private MSFComboBox<BaseModel> clutSeptCd; 	// 정산구분
	private MSFDateField edacPrdt; 				// 제출일자
	
	private MSFComboBox<BaseModel> creFile; 	// 신고파일
	private MSFTextField reprName; 				// 대표자(성명)
	private MSFTextField busoprRgstnum; 				// 사업자등록번호
	private MSFTextField resuNumb; 				// 주민등록번호
	private MSFTextField corpNum; 				// 법인번호
	private MSFTextField corpFmnmNm;				// 법인명
	private MSFTextField incmPost; 				// 소재지주소_우편번호
	private MSFTextField incmAddr; 				// 소재지주소_기본주소
	private MSFTextField incmAdtl; 				// 소재지주소_상세주소
	private MSFTextField txOffcCd; 				// 관할세무서코드
	private MSFTextField pentrSeptCd; 				// 제출자구분
	private MSFTextField txDeptyMangeNum; 				// 세무대리인번호
	private MSFTextField hmtxId; 				// 홈텍스ID
	private MSFTextField txPgmCd; 				// 세무프로그램코드
	 
	private CheckBox yetaC171; 				// C171_사업자단위과세자여부
	private MSFTextField yetaC172; 				// C172_종사업장일련번호
	
	private MSFTextField pernChrgDeptNm; 				// 담당부서명
	private MSFTextField pernChrgPhnNum; 				// 담당자전화번호
	private MSFTextField pernChrgNm; 				// 담당자성명
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
	private ListStore<BaseModel> lsClutSeptCd 		= new ListStore<BaseModel>();	//정산구분
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>(); 	//단위기관
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>(); 	//고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>(); 	//부서콤보
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드 
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>(); 	//직종
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>(); 	//직종세
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>(); 	//사업콤보
//	private ListStore<BaseModel> lsYetaDpcd  		= new ListStore<BaseModel>();	// 원천징수부서코드  
//	private ListStore<BaseModel> lsBusoprRgstnum  	= new ListStore<BaseModel>();	// 사업자등록번호  
	//---------------------------
	private ListStore<BaseModel> lscreClutYrStore 		= new ListStore<BaseModel>(); 	//년도
	private ListStore<BaseModel> lscreClutSeptCd 			= new ListStore<BaseModel>(); 	//정산구분
	private ListStore<BaseModel> lscrePayrMangDeptCd	= new ListStore<BaseModel>(); 	//단위기관
	private ListStore<BaseModel> lscreEmymtDivCd 		= new ListStore<BaseModel>(); 	//고용구분
	private ListStore<BaseModel> lscreRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lscreDeptCd 			= new ListStore<BaseModel>(); 	//부서콤보
	private ListStore<BaseModel> lscreDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드 
	private ListStore<BaseModel> lscreTypOccuCd 		= new ListStore<BaseModel>(); 	//직종
	private ListStore<BaseModel> lscreDtilOccuInttnCd 	= new ListStore<BaseModel>(); 	//직종세
	private ListStore<BaseModel> lscreBusinCd 			= new ListStore<BaseModel>(); 	//사업콤보
//	private ListStore<BaseModel> lscreYetaDpcd  		= new ListStore<BaseModel>();	// 원천징수부서코드  
//	private ListStore<BaseModel> lscreBusoprRgstnum  	= new ListStore<BaseModel>();	// 사업자등록번호  
	
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
	private Ye161005DTO ye161005Dto;
	private Ye161010DTO ye17Ta1010Dto;
	// -------------- DTO 선언 종료 --------------
	//private Ye161005BM ye161005Bm;
	private Ye161005DTO ye161005ExDto;
	
	
	// -------------- 서비스 호출 시작 --------------
//	private Yeta0100ServiceAsync yeta0100Service = Yeta0100Service.Util.getInstance();
	private Yeta6400ServiceAsync yeta6400Service = Yeta6400Service.Util.getInstance();
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
	private void checkYeta6400Auth(String authAction, ListStore<BaseModel> bm) {
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
			//Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd,srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd, srhYrtxBlggYr};
			//gwtAuthorization.formAuthFieldConfig(fldArrField);

			srhYrtxBlggYr.setValue(lsClutYrStore.findModel("year", "2021"));
			creYrtxBlggYr.setValue(lsClutYrStore.findModel("year", "2021"));
			yrtxBlggYr.setValue(lscreClutYrStore.findModel("year", "2021"));
		 
			srhClutSeptCd.setValue(lsClutSeptCd.getAt(0));
			creClutSeptCd.setValue(lsClutSeptCd.getAt(0));
			clutSeptCd.setValue(lscreClutSeptCd.getAt(0));
			
			
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
			
			
			createYeta6400Form();	// 화면 기본정보를 설정
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
	public Yeta6400() {
		setSize("1010px", "820px");
	}

	public Yeta6400(String txtForm) {
		this.txtForm = txtForm;
	}
	
	/** 연말정산신고 - 생성부 **/
	private void createXlsForm() {
		
	//	dpobCd = new HiddenField<String>();			//사업장코드
	//	systemkey = new HiddenField<String>(); 		//시스템키
//		PayrMangDeptCd = new HiddenField<String>(); //급여관리부서코드 
		
		whdgTxRegrstDeptCd = new HiddenField<String>();

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		//--------검색조건, 휴가일수 중복 store---------
		lscreClutYrStore = lsClutYrStore; 
		lscreClutSeptCd = lsClutSeptCd; 
		lscrePayrMangDeptCd = lsPayrMangDeptCd;
		lscreEmymtDivCd = lsEmymtDivCd;
		lscreRepbtyBusinDivCd = lsRepbtyBusinDivCd;
//		lscreYetaDpcd  = lsYetaDpcd;
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
//		lscreClutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분
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
		
		
		plFrmYeta6400.setLayout(new FlowLayout());

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

		creYrtxBlggYr = new ComboBox<BaseModel>();
		creYrtxBlggYr.setName("creYrtxBlggYr");
		creYrtxBlggYr.setForceSelection(true);
		creYrtxBlggYr.setMinChars(1);
		creYrtxBlggYr.setDisplayField("yearDisp");
		creYrtxBlggYr.setValueField("year");
		creYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		creYrtxBlggYr.setSelectOnFocus(true);
		creYrtxBlggYr.setReadOnly(true);
		creYrtxBlggYr.setEnabled(true);
		creYrtxBlggYr.setStore(lscreClutYrStore);
		creYrtxBlggYr.setFieldLabel("정산년도");
		creYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		creYrtxBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((creDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

						if (creDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr, "year"));
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
		layoutContainer1.add(creYrtxBlggYr, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);


		/** column 정산구분 : clutSeptCd */
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

//		creClutSeptCd = new ComboBox<BaseModel>();
//		creClutSeptCd.setName("creClutSeptCd");
//		creClutSeptCd.setForceSelection(true);
//		creClutSeptCd.setMinChars(1);
//		creClutSeptCd.setDisplayField("commCdNm");
//		creClutSeptCd.setValueField("commCd");
//		creClutSeptCd.setTriggerAction(TriggerAction.ALL);
//		creClutSeptCd.setEmptyText("--정산구분선택--");
//		creClutSeptCd.setSelectOnFocus(true);
//		creClutSeptCd.setReadOnly(false);
//		creClutSeptCd.setEnabled(true);
//		creClutSeptCd.setStore(lscreClutSeptCd);
//		creClutSeptCd.setFieldLabel("정산구분");
//		creClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//			
//			}
//		});
//
//		layoutContainer3.add(creClutSeptCd, new FormData("100%"));
		layoutContainer3.setBorders(false);
 
		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4.setLayout(frmlytSch);
		
		creClutSeptCd = new ComboBox<BaseModel>();
		creClutSeptCd.setName("creClutSeptCd");
		creClutSeptCd.setForceSelection(true);
		creClutSeptCd.setMinChars(1);
		creClutSeptCd.setDisplayField("commCdNm");
		creClutSeptCd.setValueField("commCd");
		creClutSeptCd.setTriggerAction(TriggerAction.ALL);
		creClutSeptCd.setEmptyText("--정산구분선택--");
		creClutSeptCd.setSelectOnFocus(true);
		creClutSeptCd.setReadOnly(false);
		creClutSeptCd.setEnabled(true);
		creClutSeptCd.setStore(lscreClutSeptCd);
		creClutSeptCd.setFieldLabel("정산구분");
		creClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
			
			}
		});

		layoutContainer4.add(creClutSeptCd, new FormData("100%"));
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
					checkYeta6400Auth("creEmymtDivCd", lscreEmymtDivCd);
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
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr, "year"));
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
					checkYeta6400Auth("creDeptCd", lscreDeptCd);
				}
			}
		});

		creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((creDeptCd.getListView().getChecked().size() > 0 )
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
					if (creDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr, "year"));
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
					//checkYeta6400Auth("creTypOccuCd", lsTypOccuCd);
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
		LayoutContainer layoutContainer9a = new LayoutContainer();
		layoutContainer9a.setLayout(new ColumnLayout());
		layoutContainer9a.setBorders(false);

		LayoutContainer layoutContainer9_1 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_1.setLayout(frmlytSch);

		creUtDpobNm = new MSFTextField(); 
		creUtDpobNm.setName("creUtDpobNm");
		creUtDpobNm.setFieldLabel("원천징수부서"); 
		//currAffnDeptNm.setLabelSeparator("");
		creUtDpobNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {

				if (MSFSharedUtils.allowNulls(creUtDpobNm.getValue()).trim().equals("")) {
					creUtDpobNm.setValue("");
				}
				if (MSFSharedUtils.paramNull(creUtDpobNm.getValue())) {
					creUtDpobNm.setValue("");
				}  
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
					//if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
					creUtDpobNm.setValue("");
					//}
					fnPopupPrgmComPBass120002(creUtDpobNm.getValue());
				 
				}
				
				
				if (event.getKeyCode() == KeyCodes.KEY_BACKSPACE) {
					creUtDpobCd.setValue("");
				}
				
				super.componentKeyDown(event); 
			}
		});
		layoutContainer9_1.add(creUtDpobNm, new FormData("100%"));  


		LayoutContainer layoutContainer9_2 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		layoutContainer9_2.setLayout(frmlytSch);

		btnCreUtDpobCd = new Button();
		btnCreUtDpobCd.setIcon(MSFMainApp.ICONS.search()); 
		btnCreUtDpobCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(creUtDpobNm.getValue()).trim().equals("")) {
					creUtDpobNm.setValue("");
				}
				fnPopupPrgmComPBass120002(creUtDpobNm.getValue());
			}
		});
		layoutContainer9_2.add(btnCreUtDpobCd, new FormData("100%"));

		LayoutContainer layoutContainer9_3 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer9_3.setLayout(frmlytSch);

		creUtDpobCd = new MSFTextField(); 
		creUtDpobCd.setLabelSeparator("");
		creUtDpobCd.setName("creUtDpobCd");
		creUtDpobCd.setReadOnly(true);
		layoutContainer9_3.add(creUtDpobCd, new FormData("100%"));
	
		layoutContainer9a.add(layoutContainer9_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer9a.add(layoutContainer9_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		layoutContainer9a.add(layoutContainer9_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	//	layoutContainer9a.add(layoutContainer9_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		
		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월
		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23)); 	// 단위기관
		lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 정산구분
//		lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 성명, 주민등록번호
		lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 고용구분
		
		
		lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 부서
		lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
		lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 사업 
		lcSchCol1.add(layoutContainer9a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월

		plFrmYeta6400.add(fieldSet);
	}
	
	private void createStandardForm() {
		
		//dpobCd = new HiddenField<String>();			//사업장코드
		//systemkey = new HiddenField<String>(); 		//시스템키
//		PayrMangDeptCd = new HiddenField<String>(); //급여관리부서코드 
	
		// 파일업로드 처리
		plFrmYeta6400.setAction("myurl");
		plFrmYeta6400.setEncoding(Encoding.MULTIPART);
		plFrmYeta6400.setMethod(Method.POST);

		plFrmYeta6400.setSize("990px", "820px");
		plFrmYeta6400.setLayout(new FlowLayout());



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

		exYeta6400Bar = new ButtonBar();
		exYeta6400Bar.setAlignment(HorizontalAlignment.RIGHT);

		/*
		btnYetaVerifiction= new Button("신고사전검증");
		exYeta6400Bar.add(btnYetaVerifiction);
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
		exYeta6400Bar.add(btnYetaExImport);

		btnYetaExSave= new Button("신고파일생성");
		exYeta6400Bar.add(btnYetaExSave);
		btnYetaExSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 
				fileSave(); 
			 
			}
		});
		 

		layoutContainer11.add(exYeta6400Bar);
		layoutContainer11.setBorders(false);

		layoutContainer1_4.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1_4.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1_4.setBorders(false);
		plFrmYeta6400.add(layoutContainer1_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));	// 텍스트와 버튼
				
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

		yrtxBlggYr = new MSFComboBox<BaseModel>();
		yrtxBlggYr.setName("edacPvYy");
		yrtxBlggYr.setFieldLabel("정산년도");
		yrtxBlggYr.setForceSelection(true);
		yrtxBlggYr.setMinChars(1);
		yrtxBlggYr.setDisplayField("yearDisp");
		yrtxBlggYr.setValueField("year");
		yrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		yrtxBlggYr.setEmptyText("--년도--");
		yrtxBlggYr.setSelectOnFocus(true);
		yrtxBlggYr.setStore(lscreClutYrStore);
		yrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		
		//TODO 안해줘도 될 꺼 같음..
//		yrtxBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
//				BaseModel bmClutYr = se.getSelectedItem();
//				if (bmClutYr != null) {
//					if ((srhDeptCd.getListView().getChecked().size() == 1)
//							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")))) {
//
//						if (srhDeptCd.getListView().getChecked().size() > 0) {
//							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(yrtxBlggYr, "year"));
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

		lc1_1.add(yrtxBlggYr, new FormData("100%"));
		// lc11.add(lc1_1, new FormData("100%"));

		/** column 정산구분 : */
		LayoutContainer layoutContainer13 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13.setLayout(frmlytSch);

		clutSeptCd = new MSFComboBox<BaseModel>();
		clutSeptCd.setName("clutSeptCd");
		clutSeptCd.setForceSelection(true);
		clutSeptCd.setMinChars(1);
		clutSeptCd.setDisplayField("commCdNm");
		clutSeptCd.setValueField("commCd");
		clutSeptCd.setTriggerAction(TriggerAction.ALL);
		clutSeptCd.setEmptyText("--정산구분선택--");
		clutSeptCd.setSelectOnFocus(true);
		clutSeptCd.setReadOnly(false);
		clutSeptCd.setEnabled(true);
		clutSeptCd.setStore(lscreClutSeptCd);
		clutSeptCd.setFieldLabel("정산구분");
		clutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});

		layoutContainer13.add(clutSeptCd, new FormData("100%"));
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
			
		
		// 1.근로소득지급명세서 2.의료비명세서 3.기부금명세서
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

		corpFmnmNm = new MSFTextField();
		corpFmnmNm.setName("corpFmnmNm");
		corpFmnmNm.setFieldLabel("법인명(상호)");
		corpFmnmNm.setSelectOnFocus(true);

		layoutContainer17.add(corpFmnmNm, new FormData("100%"));
		layoutContainer17.setBorders(false);

		/** column 사업자등록번호 : */
		LayoutContainer layoutContainer18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer18.setLayout(frmlytSch);

		busoprRgstnum = new MSFTextField();
		busoprRgstnum.setName("busoprRgstnum");
		new TextFieldMask<String>(busoprRgstnum, "999-99-99999");
		busoprRgstnum.setFieldLabel("사업자번호");

		layoutContainer18.add(busoprRgstnum, new FormData("100%"));
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

		corpNum = new MSFTextField();
		corpNum.setName("corpNum");
		corpNum.setFieldLabel("법인번호");
		corpNum.setSelectOnFocus(true);

		layoutContainer20.add(corpNum, new FormData("100%"));
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

		txOffcCd = new MSFTextField();
		txOffcCd.setName("txOffcCd");
		txOffcCd.setFieldLabel("관할세무서");
		txOffcCd.setSelectOnFocus(true);

		layoutContainer22.add(txOffcCd, new FormData("100%"));
		layoutContainer22.setBorders(false);

		/** column 제출자구분 : */
		LayoutContainer layoutContainer23 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer23.setLayout(frmlytSch);

		pentrSeptCd = new MSFTextField();
		pentrSeptCd.setName("pentrSeptCd");
		pentrSeptCd.setFieldLabel("제출자구분");
		pentrSeptCd.setSelectOnFocus(true);

		layoutContainer23.add(pentrSeptCd, new FormData("100%"));
		layoutContainer23.setBorders(false);

		/** column 세무대리인번호 : */
		LayoutContainer layoutContainer24 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer24.setLayout(frmlytSch);

		txDeptyMangeNum = new MSFTextField();
		txDeptyMangeNum.setName("txDeptyMangeNum");
		txDeptyMangeNum.setFieldLabel("세무대리인번호");
		txDeptyMangeNum.setSelectOnFocus(true);

		layoutContainer24.add(txDeptyMangeNum, new FormData("100%"));
		layoutContainer24.setBorders(false);

		/** column 홈텍스 ID : */
		LayoutContainer layoutContainer25 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer25.setLayout(frmlytSch);

		hmtxId = new MSFTextField();
		hmtxId.setName("hmtxId");
		hmtxId.setFieldLabel("홈텍스 ID");
		hmtxId.setSelectOnFocus(true);

		layoutContainer25.add(hmtxId, new FormData("100%"));
		layoutContainer25.setBorders(false);

		/** column 세무프로그램코드 : */
		LayoutContainer layoutContainer26 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer26.setLayout(frmlytSch);

		txPgmCd = new MSFTextField();
		txPgmCd.setName("txPgmCd");
		txPgmCd.setFieldLabel("세무프로그램코드");
		txPgmCd.setSelectOnFocus(true);

		layoutContainer26.add(txPgmCd, new FormData("100%"));
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

		pernChrgDeptNm = new MSFTextField();
		pernChrgDeptNm.setName("taxaPrCd");
		pernChrgDeptNm.setFieldLabel("담당부서명");
		pernChrgDeptNm.setSelectOnFocus(true);

		layoutContainer28.add(pernChrgDeptNm, new FormData("100%"));
		layoutContainer28.setBorders(false);

		/** column 담당자전화번호 : */
		LayoutContainer layoutContainer29 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer29.setLayout(frmlytSch);

		pernChrgPhnNum = new MSFTextField();
		pernChrgPhnNum.setName("pernChrgPhnNum");
		pernChrgPhnNum.setFieldLabel("담당자전화번호");
		pernChrgPhnNum.setSelectOnFocus(true);
		pernChrgPhnNum.setEmptyText("(02-323-3456 형태로 입력)");
		layoutContainer29.add(pernChrgPhnNum, new FormData("100%"));
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

		pernChrgNm = new MSFTextField();
		pernChrgNm.setName("pernChrgNm");
		pernChrgNm.setFieldLabel("담당자성명");
		pernChrgNm.setSelectOnFocus(true);

		layoutContainer31.add(pernChrgNm, new FormData("100%"));
		layoutContainer31.setBorders(false);

		/** column 파일암호 : */
		LayoutContainer layoutContainer32 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer32.setLayout(frmlytSch);

		filePass = new MSFTextField();
		filePass.setEmptyText("암호는 홈텍스 ID로 파일이 생성됩니다.");
		filePass.setName("filePass");
		filePass.setFieldLabel("파일암호");
		filePass.setSelectOnFocus(true);

		layoutContainer32.add(filePass, new FormData("100%"));
		layoutContainer32.setBorders(false);

		
		LayoutContainer sub01_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150); 
		sub01_1.setLayout(frmlytSch);
		
		yetaC171 = new CheckBox(); 
		yetaC171.setName("yetaC171");
		yetaC171.setBoxLabel("단위과세여부");
		yetaC171.setHideLabel(true);
		yetaC171.setToolTip("사업자단위과제자여부");
		yetaC171.setValueAttribute("2");
		
		sub01_1.add(yetaC171, new FormData("100%"));
			
		
		/** column 파일암호 text : */
		LayoutContainer layoutContainer33 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer33.setLayout(frmlytSch);
		layoutContainer33.setHeight(24);
		yetaC172 = new MSFTextField();
		yetaC172.setName("yetaC172");
		yetaC172.setFieldLabel("단위과세일련번호");
		yetaC172.setSelectOnFocus(true);
		yetaC172.setToolTip("사업자단위과제자일련번호");
		layoutContainer33.add(yetaC172, new FormData("50%"));
		layoutContainer33.setBorders(false);
	//	layoutContainer33.setStyleAttribute("fontSize", "15px");
	//	layoutContainer33.setStyleAttribute("textAlign", "left");

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

		plFrmYeta6400.add(fieldSet_2);


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
		lcSchCol2.add(sub01_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 파일암호 text
		
		lcSchCol2.add(layoutContainer33,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45)); 	// 파일암호 text
		lcSchCol2.add(layoutContainer34,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); 		// 파일암호 text
	}
	


	private void createYeta6400Form() {

		plFrmYeta6400 = new FormPanel();
		plFrmYeta6400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산신고파일생성"));
		plFrmYeta6400.setIcon(Resources.APP_ICONS.text());
		plFrmYeta6400.setPadding(2);
		plFrmYeta6400.setFrame(true);
		
		
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
		plFrmYeta6400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta6400.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		   //멀티콤보박스 닫기 
		plFrmYeta6400.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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

		vp.add(plFrmYeta6400);
	}
	
	
	/** 검색조건 **/
	private void createSearchForm() {
		
		topYeta6400Bar = new ButtonBar();
		topYeta6400Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnYeta6400Reset = new Button("초기화");
		btnYeta6400Reset.setIcon(MSFMainApp.ICONS.new16());
		btnYeta6400Reset.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				resetStandardForm();	//전자신고기본정보 초기화
			}
		});
		topYeta6400Bar.add(btnYeta6400Reset);

//		topBtn = new Button("신 규");
//		topBtn.setIcon(MSFMainApp.ICONS.new16());
//		topYeta6400Bar.add(topBtn);

//		topBtn = new Button("수 정");
//		topBtn.setIcon(MSFMainApp.ICONS.edit());
//		buttonBar.add(topBtn);

//		topBtn = new Button("삭 제");
//		topBtn.setIcon(MSFMainApp.ICONS.delete16());
//		buttonBar.add(topBtn);

		btnYeta6400Save = new Button("저 장");
		btnYeta6400Save.setIcon(MSFMainApp.ICONS.save16());
		btnYeta6400Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				saveYeta6400();	//저장
			}
		});
		
		topYeta6400Bar.add(btnYeta6400Save);

		btnYeta6400Search = new Button("조 회");
		btnYeta6400Search.setIcon(MSFMainApp.ICONS.search());
		btnYeta6400Search.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				ye161005Dto = new Ye161005DTO(); 
	 
				ye161005Dto.setSrhYrtxBlggYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));
//				ye161005Bm.setSrhYrtxBlggYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));
				
				ye161005Dto.setSrhClutSeptCd(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"));
//				ye161005Bm.setSrhClutSeptCd(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"));
				
				ye161005Dto.setSrhPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//				ye161005Bm.setSrhPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				
				ye161005Dto.setSrhEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
//				ye161005Bm.setSrhEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				
				String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				ye161005Dto.setSrhDeptCd(strDeptCd);
//				ye161005Bm.setSrhDeptCd(strDeptCd);
				
				String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
				ye161005Dto.setSrhTypOccuCd(strTypOccuCd);
//				ye161005Bm.setSrhTypOccuCd(strTypOccuCd);
				
				String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
				ye161005Dto.setSrhDtilOccuInttnCd(strDtilOccuInttnCd);
//				ye161005Bm.setSrhDtilOccuInttnCd(strDtilOccuInttnCd);
				
//				ye161005Dto.setSrhBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//				ye161005Bm.setSrhBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				ye161005Dto.setSrhBusinCd(strBusinCd);
				 
				ye161005Dto.setSrhUtDpobCd(MSFSharedUtils.allowNulls(srhUtDpobCd.getValue()));
				//ye161005Dto.setSrhBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
			 
				
				
				yeta6400Service.getYeta6400List(ye161005Dto, new AsyncCallback<Ye161005BM>(){
					
					@Override
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "조회에 실패하였습니다.", null);
					}

					@Override
					public void onSuccess(Ye161005BM result) {
						yeta0300Dtail(result);
						//연말정산신고내역 조회
						 reloadThis();
					} 
				});
			}
		});
		topYeta6400Bar.add(btnYeta6400Search);

//		topBtn = new Button("인 쇄");
//		topBtn.setIcon(MSFMainApp.ICONS.print16());
//		buttonBar.add(topBtn);
		
		plFrmYeta6400.add(topYeta6400Bar);
		
		
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
		lsClutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분
		
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
//		lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdListNoAuth();
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
		
		plFrmYeta6400.setLayout(new FlowLayout());

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

		srhYrtxBlggYr = new ComboBox<BaseModel>();
		srhYrtxBlggYr.setName("srhYrtxBlggYr");
		srhYrtxBlggYr.setForceSelection(true);
		srhYrtxBlggYr.setMinChars(1);
		srhYrtxBlggYr.setDisplayField("yearDisp");
		srhYrtxBlggYr.setValueField("year");
		srhYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
		srhYrtxBlggYr.setStore(lsClutYrStore);
		srhYrtxBlggYr.setFieldLabel("정산년도");
		srhYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		srhYrtxBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() > 0)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
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
		layoutContainer1.add(srhYrtxBlggYr, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);
		
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

		layoutContainer3.setBorders(false);
 
		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4.setLayout(frmlytSch);
		
		srhClutSeptCd = new ComboBox<BaseModel>();
		srhClutSeptCd.setName("srhClutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(false);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsClutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
//		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//			
//			}
//		});

		layoutContainer4.add(srhClutSeptCd, new FormData("100%"));
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
					checkYeta6400Auth("srhEmymtDivCd", lsEmymtDivCd);
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
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
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
		
					} else {
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
					checkYeta6400Auth("srhDeptCd", lsDeptCd);
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhDeptCd.getListView().getChecked().size() > 0) 
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
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
					//checkYeta6400Auth("srhTypOccuCd", lsTypOccuCd);
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
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
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
		
		
		LayoutContainer layoutContainer9a = new LayoutContainer();
		layoutContainer9a.setLayout(new ColumnLayout());
		layoutContainer9a.setBorders(false);

		LayoutContainer layoutContainer9_1 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_1.setLayout(frmlytSch);

		srhUtDpobNm = new MSFTextField(); 
		srhUtDpobNm.setName("srhUtDpobNm");
		srhUtDpobNm.setFieldLabel("원천징수부서"); 
		//currAffnDeptNm.setLabelSeparator("");
		srhUtDpobNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {

				if (MSFSharedUtils.allowNulls(srhUtDpobNm.getValue()).trim().equals("")) {
					srhUtDpobNm.setValue("");
				}
				if (MSFSharedUtils.paramNull(srhUtDpobNm.getValue())) {
					srhUtDpobNm.setValue("");
				}  
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
					//if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
					srhUtDpobNm.setValue("");
					//}
					fnPopupPrgmComPBass120001(srhUtDpobNm.getValue());
				 
				}
				
				if (event.getKeyCode() == KeyCodes.KEY_BACKSPACE) {
					srhUtDpobCd.setValue("");
				}
				
				super.componentKeyDown(event); 
			}
		});
		layoutContainer9_1.add(srhUtDpobNm, new FormData("100%"));  


		LayoutContainer layoutContainer9_2 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		layoutContainer9_2.setLayout(frmlytSch);

		btnSrhUtDpobCd = new Button();
		btnSrhUtDpobCd.setIcon(MSFMainApp.ICONS.search()); 
		btnSrhUtDpobCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(srhUtDpobNm.getValue()).trim().equals("")) {
					srhUtDpobNm.setValue("");
				}
				fnPopupPrgmComPBass120001(srhUtDpobNm.getValue());
			}
		});
		layoutContainer9_2.add(btnSrhUtDpobCd, new FormData("100%"));

		LayoutContainer layoutContainer9_3 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer9_3.setLayout(frmlytSch);

		srhUtDpobCd = new MSFTextField(); 
		srhUtDpobCd.setLabelSeparator("");
		srhUtDpobCd.setName("utDpobCd");
		srhUtDpobCd.setReadOnly(true);
		layoutContainer9_3.add(srhUtDpobCd, new FormData("100%"));

		layoutContainer9a.add(layoutContainer9_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer9a.add(layoutContainer9_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		layoutContainer9a.add(layoutContainer9_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	//	layoutContainer9a.add(layoutContainer9_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월
		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23)); 	// 단위기관
		lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 정산구분
		lcSchCol1.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 고용구분
		
		
		
		lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 부서
		lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
		lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 사업
		
		lcSchCol1.add(layoutContainer9a,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 

		plFrmYeta6400.add(fieldSet);
//		vp.add(plFrmYeta6400);
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
		
		msfGridPanel = new MSFGridPanel(ye17Ta1000def, false, false, false, false);
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

					finishYeta6400("Y");

				}
            
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

						finishYeta6400("N");

					}
            	
            }
		});

	    
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

		plFrmYeta6400.add(gridFieldSet);
//		plFrmYeta6400.add(msfGridPanel);
	}

	private void createBottomForm() {
	}
	
	
	/** 기본정보 초기화 **/
	public void resetStandardForm() {

//		PayrMangDeptCd.setValue("");	//급여부서코드
		edacSeilNum.setValue(null);	// 일련번호
		
		creFile.setValue(new BaseModel()); // 신고파일
		reprName.setValue(""); 		// 대표자(성명)
		busoprRgstnum.setValue(""); 		// 사업자등록번호
		resuNumb.setValue(""); 		// 주민등록번호
		corpNum.setValue(""); 		// 법인번호
		incmPost.setValue(""); 		// 소재지주소_우편번호
		incmAddr.setValue(""); 		// 소재지주소_기본주소
		incmAdtl.setValue(""); 		// 소재지주소_상세주소
		txOffcCd.setValue("142"); 	// 관할세무서코드
		pentrSeptCd.setValue("3"); 	// 제출자구분
		txDeptyMangeNum.setValue(""); 		// 세무대리인번호
		hmtxId.setValue(""); 		// 홈텍스ID
		txPgmCd.setValue("9000"); 	// 세무프로그램코드
		
		pernChrgDeptNm.setValue(""); 		// 담당부서명
		pernChrgPhnNum.setValue(""); 		// 담당자전화번호
		pernChrgNm.setValue(""); 		// 담당자성명
		filePass.setValue(""); 		// 파일암호

		declareCount.setValue(""); 	// 신고인원수
		workCount.setValue(""); 	// 재직
		retireCount.setValue(""); 	// 퇴직
		
		yetaC171.setValue(false);
		yetaC172.setValue("");
		
		msfGridPanel.getMsfGrid().clearData();
	}
	
	
	
	public void reloadThis() {
		
		//연말정산 신고 생성 파일 조회조건과 동일하게셋팅
		 creYrtxBlggYr.setValue(srhYrtxBlggYr.getValue() );; 				// 귀속년월
		 creClutSeptCd.setValue(srhClutSeptCd.getValue());; 				// 정산구분
		 crePayrMangDeptCd.setValue(srhPayrMangDeptCd.getValue()); 			// 단위기관
 
		 creEmymtDivCd.setValue(srhEmymtDivCd.getValue()); 				// 고용구분
		 //creRepbtyBusinDivCd; 		// 호봉제구분코드
		 
		 //creDeptCd; 			// 부서
		 //creDeptGpCd; 				// 부서직종그룹코드
		 //creTypOccuCd; 		// 직종
		 //creDtilOccuInttnCd; // 직종세
 
		 //creBusinCd; 		// 사업
		 
		 creUtDpobCd.setValue(srhUtDpobCd.getValue());; // 부서명
		 creUtDpobNm.setValue(srhUtDpobNm.getValue());; // 부서명 
	 
	 
		IColumnFilter filters = null;
		msfGridPanel.getTableDef().setTableColumnFilters(filters);
		
		//msfGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);//systemkey
		
		msfGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"), SimpleColumnFilter.OPERATOR_EQUALS);//정산년도
		
		msfGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
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
		
		msfGridPanel.getTableDef().addColumnFilter("utDpobCd", MSFSharedUtils.allowNulls(srhUtDpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		//msfGridPanel.getTableDef().addColumnFilter("yetaDpcd", MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"), SimpleColumnFilter.OPERATOR_EQUALS);
		//msfGridPanel.getTableDef().addColumnFilter("busoprRgstnum", MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		msfGridPanel.reload();
		
	}
	
	private void yeta0300Dtail(Ye161005BM result) {
		
		reprName.setValue(MSFSharedUtils.allowNulls(result.getReprName()));
		corpFmnmNm.setValue(MSFSharedUtils.allowNulls(result.getCorpFmnmNm()));
		busoprRgstnum.setValue(MSFSharedUtils.allowNulls(result.getBusoprRgstnum()));
		resuNumb.setValue(MSFSharedUtils.allowNulls(result.getResuNumb()));
		corpNum.setValue(MSFSharedUtils.allowNulls(result.getCorpNum()));
		incmPost.setValue(MSFSharedUtils.allowNulls(result.getIncmPost()));
		incmAddr.setValue(MSFSharedUtils.allowNulls(result.getIncmAddr()));
		incmAdtl.setValue(MSFSharedUtils.allowNulls(result.getIncmAdtl()));
		
		//2021연말정산_변경
		//txOffcCd.setValue(MSFSharedUtils.defaultNulls(result.getTxOffcCd(),"142"));
		txOffcCd.setValue(MSFSharedUtils.allowNulls(result.getTxOffcCd()));
		pentrSeptCd.setValue(MSFSharedUtils.defaultNulls(result.getPentrSeptCd(),"3"));
		txDeptyMangeNum.setValue(MSFSharedUtils.allowNulls(result.getTxDeptyMangeNum()));

		pernChrgDeptNm.setValue(MSFSharedUtils.allowNulls(result.getPernChrgDeptNm()));
		txPgmCd.setValue(MSFSharedUtils.defaultNulls(result.getTxPgmCd(),"9000"));
		hmtxId.setValue(MSFSharedUtils.allowNulls(result.getHmtxId()));
		pernChrgPhnNum.setValue(MSFSharedUtils.allowNulls(result.getPernChrgPhnNum()));
		pernChrgNm.setValue(MSFSharedUtils.allowNulls(result.getPernChrgNm()));
		
		yetaC171.setValue(MSFSharedUtils.convertStringToBoolean(result.getYetaC171())); 
		yetaC172.setValue(MSFSharedUtils.allowNulls(result.getYetaC172()));
		
	
		
		
	}
	
	
	
	/** 정산 마감 및 풀기 **/
	private void finishYeta6400(final String flag) { 
		
//	      if (MSFSharedUtils.paramNotNull(PayrMangDeptCd.getValue())) {
	          MessageBox.confirm("마감", "테이터를 마감(마감풀기)하시겠습니까?",new Listener<MessageBoxEvent>(){
	              @Override
	              public void handleEvent(MessageBoxEvent be) {
	                //  if("Yes".equals(be.getButtonClicked().getText())){
	            	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                      
	                	  if (MSFSharedUtils.paramNull(GWTUtils.getStringFromDate(edacPrdt.getValue(),"yyyyMMdd"))) {
	                          MessageBox.alert( "일자오류 ", "마감일자를 입력해 주십시요.", null);
	                          return ;
	                      } ;
	                      ye17Ta1010Dto = new Ye161010DTO();  
	                	 
	                	   ye17Ta1010Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
	                	   ye17Ta1010Dto.setYrtxBlggYr(MSFSharedUtils.getSelectedComboValue(yrtxBlggYr,"year"));
	                	   ye17Ta1010Dto.setClutSeptCd(MSFSharedUtils.getSelectedComboValue(clutSeptCd,"commCd"));
	                    
	                	   ye17Ta1010Dto.setYrtxBlggYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));
	    				
	                	   ye17Ta1010Dto.setClutSeptCd(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"));
	    			   				
	                	   ye17Ta1010Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	    				
	                	   ye17Ta1010Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	    				
	    				String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	    				ye17Ta1010Dto.setDeptCd(strDeptCd);
	    				
	    				String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	    				ye17Ta1010Dto.setTypOccuCd(strTypOccuCd);
	    				
	    				String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	    				ye17Ta1010Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);
	    				
//	    				ye161005Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
	    				String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//	    				ye161005Bm.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
	    				ye17Ta1010Dto.setBusinCd(strBusinCd);
	    				
	    	 
	    				ye17Ta1010Dto.setUtDpobCd(MSFSharedUtils.allowNulls(srhUtDpobCd.getValue()));
	    			//	ye17Ta1010Dto.setBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
	      				
	      				if("Y".equals(flag)) {
	      					ye17Ta1010Dto.setClosFlag("Y");
	      					ye17Ta1010Dto.setClosDate(YetaUtils.getConvertDateToString(closDate, "yyyyMMdd"));//마감일자
	      				}else {
	      					ye17Ta1010Dto.setClosFlag("N");
	      					ye17Ta1010Dto.setClosDate("");//마감일자
	      				}
	                     
	      				yeta6400Service.finishOnYe161005(ye17Ta1010Dto, new AsyncCallback<Long>(){
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
		
		param.put("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr,"year"));
		param.put("clutSeptCd", MSFSharedUtils.getSelectedComboValue(creClutSeptCd,"commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
//		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		
		// 부서, 원천신고부서 둘 중 하나는 필수이며, 둘 중 하나만 입력가능
				if(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") == null  ||  "".equals(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
					
					if("".equals(MSFSharedUtils.allowNulls(creUtDpobCd.getValue())) 
							|| MSFSharedUtils.allowNulls(creUtDpobCd.getValue())  == null) {
						MessageBox.info("", "부서나 원천신고부서 중 한가지는 필수로 선택해주셔야 합니다.", null);
						return;
					}else {
						param.put("utDpobCd", MSFSharedUtils.allowNulls(creUtDpobCd.getValue()));
						//param.put("busoprRgstnum", YetaUtils.getSelectedComboValue(creBusoprRgstnum,"busoprRgstnum") );
					}
					
				}else{
					if(!"".equals(creUtDpobCd.getValue()) || creUtDpobCd.getValue() != null) {
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
		                  
		if("Y0090003".equals(param.get("creFile"))){
			MessageBox.info("", "기부금명세서는 근로소득지급명세서에통합되었습니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("creFile"))){
			MessageBox.info("", "신고파일은 필수 입니다.", null);
		} else if("".equals(MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr,"year"))){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
//			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
//			if("".equals(YetaUtils.getStrValToBMMultiCombo(lsBusinCd, creBusinCd.getValue(),"businNm","businCd"))){ 
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//			} else { 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta6400Export.do","extgwtFrame" ,param);   
			//}
		}else{ 
			msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta6400Export.do","extgwtFrame" ,param);  
		}
	}	
	
	/** 전자신고기본정보 수정**/
	private void saveYeta6400() {
		
		ye161005ExDto = new Ye161005DTO();
 
		whdgTxRegrstDeptCd.setValue(MSFSharedUtils.allowNulls(creUtDpobCd.getValue()));
		ye161005ExDto.setYrtxBlggYr( MSFSharedUtils.getSelectedComboValue(yrtxBlggYr,"year"));
		ye161005ExDto.setClutSeptCd(MSFSharedUtils.getSelectedComboValue(clutSeptCd,"commCd") );
//		ye161005ExDto.setDpobCd(dpobCd.getValue());    														/** column 사업장코드 : dpobCd */
		ye161005ExDto.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(whdgTxRegrstDeptCd.getValue()));	/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
		ye161005ExDto.setHhrkWhdgRegrstDeptCd("");    														/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
		ye161005ExDto.setTxOffcCd(txOffcCd.getValue());    													/** column A3_세무서코드 : txOffcCd */
		ye161005ExDto.setPentrSeptCd(pentrSeptCd.getValue());    												/** column A5_제출자구분 : pentrSeptCd */
		ye161005ExDto.setTxDeptyMangeNum(txDeptyMangeNum.getValue());    											/** column A6_세무대리인관리번호 : txDeptyMangeNum */
		ye161005ExDto.setHmtxId(hmtxId.getValue());    													/** column A7_홈텍스ID : hmtxId */
		ye161005ExDto.setTxPgmCd(txPgmCd.getValue());    													/** column A8_세무프로그램코드 : txPgmCd */
		ye161005ExDto.setBusoprRgstnum(busoprRgstnum.getValue());    												/** column A9_사업자등록번호 : busoprRgstnum */
		ye161005ExDto.setCorpFmnmNm(corpFmnmNm.getValue());    												/** column A10_법인_상호명 : corpFmnmNm */
		ye161005ExDto.setPernChrgDeptNm(pernChrgDeptNm.getValue());    											/** column A11_담당자부서 : pernChrgDeptNm */
		ye161005ExDto.setPernChrgNm(pernChrgNm.getValue());    												/** column A12_담당자성명 : pernChrgNm */
		ye161005ExDto.setPernChrgPhnNum(pernChrgPhnNum.getValue());    											/** column A13_담당자전화번호 : pernChrgPhnNum */
		ye161005ExDto.setUseHanCd("101");    																/** column A15_사용한글코드 : useHanCd */
		ye161005ExDto.setSumtTgtPridCd("1");    																/** column B16_제출대상기간코드 : sumtTgtPridCd */
		ye161005ExDto.setCorpNum(corpNum.getValue());    													/** column 법인번호 : corpNum */
		ye161005ExDto.setIncmPost(incmPost.getValue());    													/** column 소득신고의무자우편번호 : incmPost */
		ye161005ExDto.setIncmAddr(incmAddr.getValue());    													/** column 소득신고의무자기본주소 : incmAddr */
		ye161005ExDto.setIncmAdtl(incmAdtl.getValue());    													/** column 소득신고의무자상세주소 : incmAdtl */
 
		ye161005ExDto.setReprName(reprName.getValue());    													/** column 대표자성명 : reprName */
		ye161005ExDto.setResuNumb(resuNumb.getValue());    													/** column 주민등록번호 : resuNumb */
		
		ye161005ExDto.setYetaC171(yetaC171.getValue()); 
		ye161005ExDto.setYetaC172(yetaC172.getValue());
	 
		
		if("".equals(MSFSharedUtils.allowNulls(whdgTxRegrstDeptCd.getValue())) 
				|| MSFSharedUtils.allowNulls(whdgTxRegrstDeptCd.getValue())  == null) {
			Window.alert("검색조건에서 원천신고부서와 사업자등록번호를 선택해주세요.");
			return;
		}else if("".equals(ye161005ExDto.getBusoprRgstnum()) || ye161005ExDto.getBusoprRgstnum() == null) {
			Window.alert("사업자등록번호를 입력해주세요.");
			return;
		//}else if("".equals(ye161005ExDto.getCorpNum()) || ye161005ExDto.getCorpNum() == null) {
		//	Window.alert("법인등록번호를 입력해주세요.");
		//	return;
		}else if("".equals(ye161005ExDto.getCorpFmnmNm()) || ye161005ExDto.getCorpFmnmNm() == null) {
			Window.alert("상호(법인)명을 입력해주세요.");
			return;
		}else if(MSFSharedUtils.paramNull(ye161005ExDto.getPentrSeptCd()) ||  ye161005ExDto.getPentrSeptCd().length() > 1) {
			Window.alert("제출자구분은 1자리 입니다.");
			return;
		}else if(MSFSharedUtils.paramNull(ye161005ExDto.getTxPgmCd()) ||  ye161005ExDto.getTxPgmCd().length() > 4) {
			Window.alert("세무프로그램코드는 4자리 입니다.");
			return;
		}else if(MSFSharedUtils.paramNull(ye161005ExDto.getTxOffcCd()) ||  ye161005ExDto.getTxOffcCd().length() > 3) {
			Window.alert("관할세무서는 3자리 입니다.");
			return;
		}
		
		yeta6400Service.updateYe161005(ye161005ExDto, new AsyncCallback<Long>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장에 실패하였습니다.", null);
			}
			@Override
			public void onSuccess(Long result) {
				 
				ye161005Dto = new Ye161005DTO(); 
				 
				ye161005Dto.setSrhYrtxBlggYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));
//				ye161005Bm.setSrhYrtxBlggYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));
				
				ye161005Dto.setSrhClutSeptCd(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"));
//				ye161005Bm.setSrhClutSeptCd(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"));
				
				ye161005Dto.setSrhPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//				ye161005Bm.setSrhPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				
				ye161005Dto.setSrhEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
//				ye161005Bm.setSrhEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				
				String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				ye161005Dto.setSrhDeptCd(strDeptCd);
//				ye161005Bm.setSrhDeptCd(strDeptCd);
				
				String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
				ye161005Dto.setSrhTypOccuCd(strTypOccuCd);
//				ye161005Bm.setSrhTypOccuCd(strTypOccuCd);
				
				String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
				ye161005Dto.setSrhDtilOccuInttnCd(strDtilOccuInttnCd);
//				ye161005Bm.setSrhDtilOccuInttnCd(strDtilOccuInttnCd);
				
//				ye161005Dto.setSrhBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				String strBusinCd = YetaUtils.getStrValToBMMultiCombo(lsBusinCd,srhBusinCd.getValue(),"businNm","businCd"); 
//				ye161005Bm.setSrhBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				ye161005Dto.setSrhBusinCd(strBusinCd);
				 
				ye161005Dto.setSrhUtDpobCd(MSFSharedUtils.allowNulls(srhUtDpobCd.getValue()));
				//ye161005Dto.setSrhBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
			 
				 
				yeta6400Service.getYeta6400List(ye161005Dto, new AsyncCallback<Ye161005BM>(){
					@Override
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "조회에 실패하였습니다.", null);
					}
					@Override
					public void onSuccess(Ye161005BM result) {
						yeta0300Dtail(result);
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
	 * @date : Jan 29, 2017
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 29, 2017		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 *
	 */
	private void fileSave() {
		 
				
       HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr,"year"));
		param.put("clutSeptCd", MSFSharedUtils.getSelectedComboValue(creClutSeptCd,"commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		
		// 부서, 원천신고부서 둘 중 하나는 필수이며, 둘 중 하나만 입력가능
		if(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") == null  ||  "".equals(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
			
			if("".equals(MSFSharedUtils.allowNulls( creUtDpobCd.getValue())) 
					|| MSFSharedUtils.allowNulls( creUtDpobCd.getValue())  == null) {
				MessageBox.info("", "부서나 원천신고부서 중 한가지는 필수로 선택해주셔야 합니다.", null);
				return;
			}else { 
				param.put("utDpobCd", creUtDpobCd.getValue()); 
				//param.put("busoprRgstnum", busoprRgstnum.getValue() );
				//param.put("deptCd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
			}
		}else{
			 if(!"".equals(creUtDpobCd.getValue()) || creUtDpobCd.getValue() != null) {
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
		param.put("corpFmnmNm",corpFmnmNm.getValue());
		param.put("busoprRgstnum",busoprRgstnum.getValue());
		param.put("resuNumb",resuNumb.getValue());
		
		param.put("corpNum",corpNum.getValue());
		param.put("incmPost",incmPost.getValue());
		param.put("incmAddr",incmAddr.getValue());
		param.put("incmAdtl",incmAdtl.getValue());
		param.put("txOffcCd",txOffcCd.getValue());
		param.put("pentrSeptCd",pentrSeptCd.getValue());
		param.put("txDeptyMangeNum",txDeptyMangeNum.getValue());
		param.put("pernChrgDeptNm",pernChrgDeptNm.getValue());
		param.put("hmtxId",hmtxId.getValue());
		param.put("txPgmCd",txPgmCd.getValue()); 
	    param.put("pernChrgPhnNum",pernChrgPhnNum.getValue());
		param.put("pernChrgNm",pernChrgNm.getValue());
		//param.put("filePass",filePass.getValue());
		
		if ("Y0090003".equals(MSFSharedUtils.allowNulls(param.get("creFile")))) {
			MessageBox.info("", "기부금명세서은 근로지급명세서에통합되었습니다.", null);
	    } else if(MSFSharedUtils.paramNull(param.get("resuNumb"))){
			MessageBox.info("", "주민등록번호는 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("hmtxId"))){
			MessageBox.info("", "홈텍스아이디는 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("pernChrgDeptNm"))){
			MessageBox.info("", "담당부서명은 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("pernChrgPhnNum"))){
			MessageBox.info("", "담당자 전화번호는  필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("pernChrgNm"))){
			MessageBox.info("", "담당자 성명은 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("creFile"))){
			MessageBox.info("", "신고파일은 필수 입니다.", null);
		}else if("".equals(MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr,"year"))){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("deptCd")) && MSFSharedUtils.paramNull(param.get("busoprRgstnum"))){
			MessageBox.info("", "중간 생성부 부서 또는 원천징수부서는 필수 입니다.(택1)", null);
		}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
			msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/FileYeta6400Export.do","extgwtFrame" ,param);   
			//}
		}else{ 
			msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/FileYeta6400Export.do","extgwtFrame" ,param);  
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
	 * @date : 2017. 9. 2.
	 * @author : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 9. 2.		Administrator				최초 작성 
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
	 *  @RequestMapping(value = "/exp/Yeta6400Verifiction.do") 
	 -------------------------------------------------------------------------------------------------------------------------------------*/
	
	 
	private void  yeta1400Verifiction() { 
		 
       HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr,"year"));
		param.put("clutSeptCd", MSFSharedUtils.getSelectedComboValue(creClutSeptCd,"commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		
		// 부서, 원천신고부서 둘 중 하나는 필수이며, 둘 중 하나만 입력가능
		if(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd") == null  ||  "".equals(YetaUtils.getStrValToBMMultiCombo(lscreDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
			
			if("".equals(MSFSharedUtils.allowNulls( creUtDpobCd.getValue())) 
					|| MSFSharedUtils.allowNulls( creUtDpobCd.getValue())  == null) {
				
				MessageBox.info("", "부서나 원천신고부서 중 한가지는 필수로 선택해주셔야 합니다.", null);
				return;
			}else {
				
				param.put("utDpobCd", creUtDpobCd.getValue());
				param.put("busoprRgstnum", busoprRgstnum.getValue() );
				
//				param.put("deptCd", YetaUtils.getSelectedComboValue(creYetaDpcd,"yetaDpcd") );
			 
			}
			
		}else{
			
			if(!"".equals(busoprRgstnum.getValue()) || busoprRgstnum.getValue() != null) {
				MessageBox.info("", "부서나 원천신고부서 중 한가지만 입력 가능합니다.", null);
				
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
		param.put("corpFmnmNm",corpFmnmNm.getValue());
		param.put("busoprRgstnum",busoprRgstnum.getValue());
		param.put("resuNumb",resuNumb.getValue());
		
		param.put("corpNum",corpNum.getValue());
		param.put("incmPost",incmPost.getValue());
		param.put("incmAddr",incmAddr.getValue());
		param.put("incmAdtl",incmAdtl.getValue());
		param.put("txOffcCd",txOffcCd.getValue());
		param.put("pentrSeptCd",pentrSeptCd.getValue());
		param.put("txDeptyMangeNum",txDeptyMangeNum.getValue());
		param.put("pernChrgDeptNm",pernChrgDeptNm.getValue());
		param.put("hmtxId",hmtxId.getValue());
		param.put("txPgmCd",txPgmCd.getValue()); 
	    param.put("pernChrgPhnNum",pernChrgPhnNum.getValue());
		param.put("pernChrgNm",pernChrgNm.getValue());
		//param.put("filePass",filePass.getValue());
		   
		
		if(MSFSharedUtils.paramNull(param.get("resuNumb"))){
			MessageBox.info("", "주민등록번호는 필수 입니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("hmtxId"))){
			MessageBox.info("", "홈텍스아이디는 필수 입니다.", null);
		} else if(MSFSharedUtils.paramNull(param.get("pernChrgDeptNm"))){
			MessageBox.info("", "담당부서명은 필수 입니다.", null);
		}  else if(MSFSharedUtils.paramNull(param.get("pernChrgPhnNum"))){
			MessageBox.info("", "담당자 전화번호는  필수 입니다.", null);
		}   else if(MSFSharedUtils.paramNull(param.get("pernChrgNm"))){
			MessageBox.info("", "담당자 성명은 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("creFile"))){
			MessageBox.info("", "신고파일은 필수 입니다.", null);
		} else if("".equals(MSFSharedUtils.getSelectedComboValue(creYrtxBlggYr,"year"))){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else if(MSFSharedUtils.paramNull(param.get("deptCd")) && MSFSharedUtils.paramNull(param.get("busoprRgstnum"))){
			MessageBox.info("", "중간 생성부 부서 또는 원천징수부서는 필수 입니다.(택1)", null);
			
		} else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/Yeta6400Verifiction.do","extgwtFrame" ,param);   
		 
		}else{ 
 
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/Yeta6400Verifiction.do","extgwtFrame" ,param);  
		}	
		 
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 * 검증 추가 종료  
	 *   	 
	 -------------------------------------------------------------------------------------------------------------------------------------*/
	

	// 단위사업장 
	private void fnPopupPrgmComPBass120001(String deptNmStr) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨. 
		PrgmComBass0120DTO prgmComBass0120Dto = new PrgmComBass0120DTO();
		prgmComBass0120Dto.setUtDpobNm(deptNmStr);
		
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmComPBass120001Form(prgmComBass0120Dto) ;  //부서

		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();

		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	               
				if (mapModels != null) {  
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator(); 
					
					while (iterRecords.hasNext()) {
						
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						if (!"".equals(bmMapModel.get("utDpobCd"))) {  
							
							srhUtDpobCd.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
							srhUtDpobNm.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobNm"))); 
						}
						
					}
				}
			}
		});
	}	
	
	// 단위사업장 
	private void fnPopupPrgmComPBass120002(String deptNmStr) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨. 
		PrgmComBass0120DTO prgmComBass0120Dto = new PrgmComBass0120DTO();
		prgmComBass0120Dto.setUtDpobNm(deptNmStr);
		
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmComPBass120001Form(prgmComBass0120Dto) ;  //부서

		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();

		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	               
				if (mapModels != null) {  
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator(); 
					
					while (iterRecords.hasNext()) {
						
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						if (!"".equals(bmMapModel.get("utDpobCd"))) {  
							
							creUtDpobCd.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
							creUtDpobNm.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobNm"))); 
						}
						
					}
				}
			}
		});
	}	
}
