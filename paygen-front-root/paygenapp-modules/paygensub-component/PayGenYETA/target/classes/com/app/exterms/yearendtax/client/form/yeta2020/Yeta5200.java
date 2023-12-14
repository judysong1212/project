package com.app.exterms.yearendtax.client.form.yeta2020;

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
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2020.Ye161010Def;
import com.app.exterms.yearendtax.client.service.yeta2020.Yeta5200Service;
import com.app.exterms.yearendtax.client.service.yeta2020.Yeta5200ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
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
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
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
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
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

/**
 * 
 * <pre>
 * 1. 패키지명 : com.app.exterms.yearendtax.client.form.yeta2018
 * 2. 타입명 : Yeta5200.java
 * 3. 작성일 : 2018. 1. 5. 오후 11:07:51
 * 4. 작성자 : atres
 * 5. 설명 :
 * </pre>
 */
public class Yeta5200 extends MSFPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	// private RemtConstants lblRemtConst = RemtConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmYeta5200;
	private String txtForm = "";


	private MSFGridPanel Yeta5200GridPanel;
	private MSFGridPanel Yeta5200XmlGridPanel;
	private Ye161010Def Yeta5200def = new Ye161010Def("Yeta5200");
	private Ye161010Def Yeta5200defXml = new Ye161010Def("Yeta5200_RESULT");

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
	 * 상태처리 전역 변수 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;


	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topYeta5200Bar;
	private Button btnYeta5200Sec; 	// 초기화
	private Button btnYeta5200Reset; 	// 초기화
	private Button btnYeta5200New; 		// 신규
	private Button btnYeta5200Save; 	// 저장
	private Button btnYeta5200Del; 		// 삭제
	private Button btnYeta5200Sreach; 	// 조회
	private Button btnYeta5200Print; 	// 인쇄
	private Button btnYetaP520001; 	// 상세정보 팝업
	private Button btnYetaP520002; 	// 상세정보 팝업

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
	// -------------- 검색조건 생성 폼 시작 --------------
	private MSFComboBox<BaseModel> srhYrtxBlggYr; 				// 정산년 
	private MSFComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	private TextField<String> srhHanNm; 					// 성명
	private TextField<String> srhResnRegnNum; 				// 주민번호
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드  
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
	private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드	 
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private HiddenField<String> srhSystemkey; 				// 시스템키

	// -------------- 기본정보 폼 시작 --------------
	private MSFTextField typOccuNm; 			// 기본정보_직종
	private MSFTextField hanNm; 				// 기본정보_성명
	private MSFTextField deptNm; 				// 기본정보_부서
	private FileUploadField crefileUpload; 		// PDF파일자료_파일업로드
	private FileUploadField ddxCrefileUpload; 		// PDF파일자료_파일업로드
	private TextField<String> crePasswd; 		// PDF파일자료_패스워드
	private TextField<String> ddcCrePasswd; 	// PDF파일자료_패스워드
	private HiddenField<String> resnRegnNum; 	// PDF파일자료_패스워드 
	private HiddenField<Boolean> creOriginYn; 	// PDF파일자료_원본자동검증여부 
	private HiddenField<Boolean> ddcCreOriginYn; 	// PDF파일자료_원본자동검증여부 
	private CheckBoxGroup chkYnGroup;
	private CheckBox creOriginChkYn; 				// PDF파일자료_원본자동검증여부
	private CheckBox ddcCreOriginChkYn; 				// PDF파일자료_원본자동검증여부
	private CheckBox stlRflSttChkYn; 				// PDF파일자료_원본자동검증여부
	private CheckBox ddcStlRflSttChkYn; 				// PDF파일자료_원본자동검증여부
	

	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;

	private HiddenField<String> systemkey;
	/** column SYSTEMKEY : systemkey */
	private HiddenField<String> dpobCd;
	/** column 사업장코드 : dpobCd */

	private HiddenField<String> yrtxBlggYr;  /** set 연말정산귀속년도 : edacRvyy */
	private HiddenField<String> clutSeptCd;/** set 정산구분코드 : settGbcd */

	private BaseModel ppRecord; // 팝업에 넘길 레코드 값

	private Boolean picBoolFile;

	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종

	private BaseModel record;
	private Iterator<Record> records;

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ Rpc Service 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++++++++++
	 **/
	private Yeta5200ServiceAsync yeta5200Service = Yeta5200Service.Util.getInstance(); 

	private ListStore<BaseModel> lsClutYrStore = new ListStore<BaseModel>(); // 년도 
	private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>(); // 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd = new ListStore<BaseModel>(); // 부서콤보
	private ListStore<BaseModel> lsBusinCd = new ListStore<BaseModel>(); // 사업콤보
	private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>(); // 단위기관
	private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  
	private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>(); // 직종
	private ListStore<BaseModel> lsCalcSevePayPsnDivCd = new ListStore<BaseModel>(); // 정산구분
	private ListStore<BaseModel> lsPymtDducDivCd = new ListStore<BaseModel>(); // 지급공제구분코드
	private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>(); // 직종세 

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++
	 * ++++++++++++++++++++++++++++++++++++++++
	 */
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkYeta0200Auth(String authAction, ListStore<BaseModel> bm) {
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
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++++++++ 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세
		 * ,사업 순으로 없으면 ""
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++++++++++++++++++++++
		 */
		// ----------------------------------------------------
		Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd,srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd };
		gwtAuthorization.formAuthFieldConfig(fldArrField);

		srhYrtxBlggYr.setValue(lsClutYrStore.findModel("year",String.valueOf("2020")));
		srhClutSeptCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));

		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++++++++ 권한설정을 위한 콤보처리를 위한 메서드 종료
		 * ++++++++++++++++++++++++++++++++
		 * ++++++++++++++++++++++++++++++++++++++++++
		 */
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
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

		authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
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
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++
	 * ++++++++++++++++++++++++++++++++++++++++
	 **/

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	file upload  선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	file upload  선언부 닫기
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/ 
	/**
	 * #########################################################################
	 * #### 프로그램 시작
	 * #############################################################
	 * ################
	 **/

	public ContentPanel getViewPanel() {
		if (panel == null) {

			initLoad(); 

			vp = new VerticalPanel();
			vp.setSpacing(10);
			createYeta0200Form(); // 화면 기본정보를 설정
			createMsfGridForm(); // 그리드설정
			vp.setSize("1010px", "900px");

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
	 * #########################################################################
	 * #### 프로그램 종료
	 * #############################################################
	 * ################
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 생성자 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	 * @wbp.parser.constructor
	 */
	public Yeta5200() {
		setSize("1600px", "900px");
	}

	public Yeta5200(String txtForm) {
		this.txtForm = txtForm;
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createYeta0200Form() {

		plFrmYeta5200 = new FormPanel();
		plFrmYeta5200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산파일업로드"));
		plFrmYeta5200.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta5200.setPadding(2);
		plFrmYeta5200.setFrame(true);

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   

		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//로그 뷰화면 호출 메서드 
				funcLogMessage("연말정산파일업로드","YETA0200");
			}
		});
		plFrmYeta5200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta5200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmYeta5200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 

				//   for (Field<?>  f : ((FormPanel) plFrmRemt0100).getFields()) {

				//        if (f instanceof MSFMultiComboBox<?>) {

				//			                        if ("srhDeptCd".equals(f.getName())) {
				//			                            
				//			                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
				//			                            
				//			                        }

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
					} 
				}
				//    }
				//    } 
			} 
		});

		/** 상단 버튼 ButtonBar **/
		topYeta5200Bar = new ButtonBar();
		topYeta5200Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		if ("admin".equals(MSFMainApp.get().getUser().getUsrId())) {	
			btnYeta5200Sec = new Button("암호화패치");
			btnYeta5200Sec.setIcon(MSFMainApp.ICONS.new16());
			topYeta5200Bar.add(btnYeta5200Sec);
			btnYeta5200Sec.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
				 
					Ye161010DTO ye161010Dto = new Ye161010DTO(); 
						   
					yeta5200Service.yetaChangeConvert(ye161010Dto,  new AsyncCallback<String>(){
				                 public void onFailure(Throwable caught) {
				                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("Yeta5200Service : " + caught), null);
				                 }
				                 public void onSuccess(String result) { 
				                   
				                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "처리가 완료되었습니다.", null);
				                      
				                   
				                 } 
				                  
				             }); 
					  
				}
			}); 
		
		}		
		
		
		

		btnYeta5200Reset = new Button("초기화");
		btnYeta5200Reset.setIcon(MSFMainApp.ICONS.new16());
		topYeta5200Bar.add(btnYeta5200Reset);
		btnYeta5200Reset.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//초기화 
				formInit();
				Yeta5200GridPanel.getMsfGrid().clearData(); 
			}
		});  

		//		topBtn = new Button("신 규");
		//		topBtn.setIcon(MSFMainApp.ICONS.new16());
		//		buttonBar.add(topBtn);

		//		topBtn = new Button("수 정");
		//		topBtn.setIcon(MSFMainApp.ICONS.edit());
		//		buttonBar.add(topBtn);
		//
		//		topBtn = new Button("삭 제");
		//		topBtn.setIcon(MSFMainApp.ICONS.delete16());
		//		buttonBar.add(topBtn);
		//
		//		topBtn = new Button("저 장");
		//		topBtn.setIcon(MSFMainApp.ICONS.save16());
		//		buttonBar.add(topBtn);

		btnYeta5200Sreach = new Button("조 회");
		btnYeta5200Sreach.setIcon(MSFMainApp.ICONS.search());
		topYeta5200Bar.add(btnYeta5200Sreach);
		btnYeta5200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//조회버튼 클릭시 처리 
				reloadYeta5200();  
			}
		});
		//		topBtn = new Button("인 쇄");
		//		topBtn.setIcon(MSFMainApp.ICONS.print16());
		//		buttonBar.add(topBtn);

		plFrmYeta5200.add(topYeta5200Bar);

		// 파일업로드 처리
		plFrmYeta5200.setAction("myurl");
		plFrmYeta5200.setEncoding(Encoding.MULTIPART);
		plFrmYeta5200.setMethod(Method.POST);

		vp.add(plFrmYeta5200);
		plFrmYeta5200.setSize("990px", "830px");
		plFrmYeta5200.setLayout(new FlowLayout());


		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();

		// --------------------단위기관 불러 오는 함수------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);	//단위기관
		// --------------------단위기관 불러 오는 함수------------------------------------------------

		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분

		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);		//고용구분

		//호봉
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// --------------------공통 코드 불러 오는 함수--------------------------------------------------

		// --------------------정산년도 불러 오는 함수------------------------------------------------
		lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		// --------------------정산년도 불러 오는 함수------------------------------------------------

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
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  

				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

			}
		});  

		srhSystemkey = new HiddenField<String>();
		plFrmYeta5200.setLayout(new FlowLayout());

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
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1.setLayout(frmlytSch);

		srhYrtxBlggYr = new MSFComboBox<BaseModel>();
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
					if ((srhDeptCd.getListView().getChecked().size() == 1)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						srhBusinCd.setStore(lsBusinCd);
						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								// searchBusinCd.setValue(lsBusinCd.getAt(0));
							}
						});
					} else {
						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
						// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
						// return;
					}
				}
			}
		});

		layoutContainer1.add(srhYrtxBlggYr, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);

		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setBorders(false);

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

				checkYeta0200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd);
			}
		});
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// --------------------부서 불러 오는 함수------------------------------------------------
				sysComBass0400Dto.setDeptDspyYn("Y"); 
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
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


		/** column 고용구분 : EmymtDivCd */
		LayoutContainer layoutContainer4 = new LayoutContainer(new ColumnLayout());
		layoutContainer4.setBorders(false);

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
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서: 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd", "srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta0200Auth("srhEmymtDivCd", lsEmymtDivCd);
				}
			}
		});
		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null
						&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수 -------------------------------------------------
						srhBusinCd.setStore(lsBusinCd);
						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								// searchBusinCd.setValue(lsBusinCd.getAt(0));
							}
						});
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
					srhTypOccuCd.setEnabled(true);
					srhDtilOccuInttnCd.setEnabled(true);
					
				}
			}
		});
		layoutContainer77.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer4.add(layoutContainer77, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));


		LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

		frmlytSch = new FormLayout();  
		frmlytSch.setDefaultWidth(0);
		//	    frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_101.setLayout(frmlytSch);

		srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		srhRepbtyBusinDivCd.setHideLabel(true);
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
		lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  


			}
		});  

		layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		layoutContainer4.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		layoutContainer1_2.setLayout(new ColumnLayout());

		/** column 성명 : HanNm */
		LayoutContainer layoutContainer5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");
		layoutContainer5.add(srhHanNm, new FormData("100%"));
		srhHanNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {

				srhHanNm.validate();
				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
					systemkey.setValue("");
					srhResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					systemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		}); 		
		
		layoutContainer1_2.add(layoutContainer5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		layoutContainer5.setBorders(false);

		LayoutContainer layoutContainer_btn = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		layoutContainer_btn.setLayout(frmlytSch);

		Button btnHanNm = new Button("검색");
		layoutContainer1_2.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();

			}
		});

		layoutContainer_btn.add(btnHanNm);
		layoutContainer1_2.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		/** column 주민등록번호 : resnRegnNum */
		LayoutContainer layoutContainer6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6.setLayout(frmlytSch);


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
		layoutContainer6.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer1_2.add(layoutContainer6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer6.setBorders(false);
		layoutContainer1_2.setBorders(false);

		/** column 정산구분 : CalcSevePayPsnDivCd */
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7.setLayout(frmlytSch);

		srhClutSeptCd = new MSFComboBox<BaseModel>();
		srhClutSeptCd.setName("srhClutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setEmptyText("--정산구분선택--");
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setEnabled(true); 
		srhClutSeptCd.setStore(lsCalcSevePayPsnDivCd);
		srhClutSeptCd.setFieldLabel("정산구분");
		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});

		layoutContainer7.add(srhClutSeptCd, new FormData("100%"));


		LayoutContainer layoutContainer8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
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
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서: 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta0200Auth("srhDeptCd", lsDeptCd);
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhDeptCd.getListView().getChecked().size() == 1)
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
						List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
						sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}

					// --------------------사업 불러 오는 함수-------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수 -------------------------------------------------
					srhBusinCd.setStore(lsBusinCd);
					srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
							// searchBusinCd.setValue(lsBusinCd.getAt(0));
						}
					});
				} else {
					// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
					// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
					// return;
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
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

		/** column 직종 : srhTypOccuCd */
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		//		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuCd.setLayout(frmlytSch);

		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setHideLabel(true);
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		//		srhTypOccuCd.setFieldLabel("직종");
		//srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		//srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
					 * lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면
					 * ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd"
					 * ,"srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					//checkYeta0200Auth("srhTypOccuCd", lsTypOccuCd);
				}
			}
		});

		srhTypOccuCd.getListView().addListener(Events.CheckChanged, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhTypOccuCd.getListView().getChecked().size() > 0)
						&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					// 직종변경에 따른 직종세 값 가져오기
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

		srhTypOccuCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
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
		//	srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		//	srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
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


		layoutContainer1_3.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer1_3.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer1_3.setBorders(false);

		/** column 사업 : BusinCd */
		LayoutContainer layoutContainer9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9.setLayout(frmlytSch);

		srhBusinCd = new ComboBox<BaseModel>();
		srhBusinCd.setName("srhBusinCd");
		srhBusinCd.setForceSelection(true);
		srhBusinCd.setMinChars(1);
		srhBusinCd.setDisplayField("businNm");
		srhBusinCd.setValueField("businCd");
		srhBusinCd.setTriggerAction(TriggerAction.ALL);
		srhBusinCd.setEmptyText("--사업선택--");
		srhBusinCd.setSelectOnFocus(true);
		srhBusinCd.getListView().setWidth("200px");
		srhBusinCd.setStore(lsBusinCd);
		srhBusinCd.setFieldLabel("사업");
		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		layoutContainer9.add(srhBusinCd, new FormData("100%"));
		layoutContainer9.setBorders(false);


		LayoutContainer layoutContainer_16 = new LayoutContainer();

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_16.setLayout(frmlytSch);

		plFrmYeta5200.add(fieldSet);

		//		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 	// 정산년,월
		//		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 	// 단위기관
		//		lcSchCol1.add(layoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38)); 	// 고용구분
		//		lcSchCol1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 	// 성명, 주민등록번호
		//		
		//		lcSchCol1.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 	// 정산구분
		//		lcSchCol1.add(layoutContainer8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	 	// 부서
		//		lcSchCol1.add(layoutContainer1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38)); 	// 직종
		//		lcSchCol1.add(layoutContainer9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));		// 사업

		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월
		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 단위기관
		lcSchCol1.add(layoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 고용구분


		lcSchCol1.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 정산구분
		lcSchCol1.add(layoutContainer8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	 	// 부서
		lcSchCol1.add(layoutContainer1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종


		lcSchCol1.add(layoutContainer9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
		lcSchCol1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 성명, 주민등록번호
		lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 


	}

	private void createMsfGridForm() {

		dpobCd = new HiddenField<String>();		// 사업장코드
		dpobCd.setName("dpobCd");
		dpobCd.setId("dpobCd");
		plFrmYeta5200.add(dpobCd);
		systemkey = new HiddenField<String>(); 	// 시스템키
		systemkey.setName("systemkey");
		systemkey.setId("systemkey");
		plFrmYeta5200.add(systemkey);
		yrtxBlggYr  = new HiddenField<String>();	  /** set 연말정산귀속년도 : edacRvyy */
		yrtxBlggYr.setName("yrtxBlggYr");
		yrtxBlggYr.setId("yrtxBlggYr");
		plFrmYeta5200.add(yrtxBlggYr);
		clutSeptCd = new HiddenField<String>();	/** set 정산구분코드 : settGbcd */
		clutSeptCd.setName("clutSeptCd");
		clutSeptCd.setId("clutSeptCd");
		plFrmYeta5200.add(clutSeptCd);
		resnRegnNum = new HiddenField<String>();	/** set 연말정산마감일련번호 : edacSeilNum */
		resnRegnNum.setName("resnRegnNum");
		resnRegnNum.setId("resnRegnNum");
		plFrmYeta5200.add(resnRegnNum);
		creOriginYn = new HiddenField<Boolean>();
		creOriginYn.setName("creOriginYn");
		creOriginYn.setId("creOriginYn");
		plFrmYeta5200.add(creOriginYn);
		ddcCreOriginYn = new HiddenField<Boolean>();
		ddcCreOriginYn.setName("ddcCreOriginYn");
		ddcCreOriginYn.setId("ddcCreOriginYn");
		plFrmYeta5200.add(ddcCreOriginYn);


		FieldSet fsGird = new FieldSet();
		fsGird.setHeadingHtml("정산대상자");
		fsGird.setStyleAttribute("paddingLeft", "5px");
		fsGird.setBorders(true);

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_4 = new LayoutContainer();
		layoutContainer1_4.setLayout(new ColumnLayout());

		Yeta5200GridPanel = new MSFGridPanel(Yeta5200def, false, false, false, false,false);
		Yeta5200GridPanel.setHeaderVisible(false);
		Yeta5200GridPanel.setSize(470, 640);
		Yeta5200GridPanel.setBorders(true);
		final Grid yeta4000DefGrid = Yeta5200GridPanel.getMsfGrid().getGrid();
		yeta4000DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (Yeta5200GridPanel.getCurrentlySelectedItem() != null) { 
					BaseModel bmData = new BaseModel();
					formInit() ;
					bmData = Yeta5200GridPanel.getCurrentlySelectedItem();

					dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
					systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
					yrtxBlggYr.setValue(MSFSharedUtils.allowNulls(bmData.get("yrtxBlggYr")));  /** set 연말정산귀속년도 : yrtxBlggYr */
					clutSeptCd.setValue(MSFSharedUtils.allowNulls(bmData.get("clutSeptCd")));/** set 정산구분코드 : clutSeptCd */
					typOccuNm.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuNm"))); 
					hanNm.setValue(MSFSharedUtils.allowNulls(bmData.get("fnm")));
					deptNm.setValue(MSFSharedUtils.allowNulls(bmData.get("deptNm")));
					crePasswd.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum")).substring(6,13)); 
					ddcCrePasswd.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum")).substring(6,13)); 
					resnRegnNum.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum"))); 
					creOriginChkYn.setValue(Boolean.FALSE);
					ddcCreOriginChkYn.setValue(Boolean.FALSE);
				
					setPPRecord(bmData);

					reloadYeta5200Result();
				} 


			}
		});  

		Yeta5200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 4, new HeaderGroupConfig("소득공제자료", 1, 2));

		fsGird.add(Yeta5200GridPanel);
		layoutContainer1_4.add(fsGird, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));
		//		layoutContainer1_4.add(msfGridPanel, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		/** column text : 공백1 */
		LayoutContainer space1 = new LayoutContainer();
		space1.setHeight(500);
		space1.setWidth(10);
		space1.setId("space");
		space1.setBorders(false);
		layoutContainer1_4.add(space1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.01));

		FieldSet fieldSet3 = new FieldSet();
		fieldSet3.setHeadingHtml("기본정보");
		fieldSet3.setHeight("80px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());
		fieldSet3.add(lcSchCol2, new FormData("100%"));

		/** column text : 기본정보_직종 cretypOccuNm */
		LayoutContainer layoutContainer10 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10.setLayout(frmlytSch);

		typOccuNm = new MSFTextField();
		typOccuNm.setName("typOccuNm");
		typOccuNm.setFieldLabel("직종");
		typOccuNm.setEmptyText("--직종--");
		typOccuNm.setReadOnly(true);
		layoutContainer10.add(typOccuNm, new FormData("100%"));
		layoutContainer10.setBorders(false);
		lcSchCol2.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));

		/** column text : 기본정보_성명 cretypOccuNm */
		LayoutContainer layoutContainer11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11.setLayout(frmlytSch);

		hanNm = new MSFTextField();
		hanNm.setName("hanNm");
		hanNm.setFieldLabel("성명");
		hanNm.setEmptyText("--성명--");
		hanNm.setReadOnly(true);
		layoutContainer11.add(hanNm, new FormData("100%"));
		layoutContainer11.setBorders(false);
		lcSchCol2.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));

		/** column text : 기본정보_부서 creDeptCd */
		LayoutContainer layoutContainer12 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12.setLayout(frmlytSch);

		deptNm = new MSFTextField();
		deptNm.setName("deptNm");
		deptNm.setFieldLabel("부서");
		deptNm.setEmptyText("--부서--");
		deptNm.setReadOnly(true);
		layoutContainer12.add(deptNm, new FormData("100%"));
		layoutContainer12.setBorders(false);
		lcSchCol2.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));

		layoutContainer1_4.add(fieldSet3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		FieldSet fieldSet4 = new FieldSet();
		fieldSet4.setHeadingHtml("간소화 PDF파일자료");
		fieldSet4.setHeight("130px");
		fieldSet4.setStyleAttribute("marginTop", "10px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		fieldSet4.add(lcSchCol3, new FormData("100%"));

		/** column text : PDF파일자료_파일업로드 crefileUpload */
		LayoutContainer layoutContainer13 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13.setLayout(frmlytSch);


		/************************************************************************/


		//	  	  SingleUploader single1 = new SingleUploaderModal();
		//	      single1.addOnFinishUploadHandler(onFinishUploaderHandler);

		// This enables php apc progress mechanism
		//	      single1.add(new Hidden("APC_UPLOAD_PROGRESS", single1.getInputName()), 0);
		//	      single1.avoidEmptyFiles(false);
		//   SingleUploader single2 = new SingleUploaderModal(FileInputType.ANCHOR, new ChismesUploadProgress(true));
		//   single2.addOnFinishUploadHandler(onFinishUploaderHandler);
		//   RootPanel.get("single2").add(single2);

		//   RootPanel.get("thumbnails").add(panelImages);
		/************************************************************************/   


		crefileUpload = new FileUploadField();
		crefileUpload.setName("crefileUpload");
		crefileUpload.setFieldLabel("파일업로드");
		crefileUpload.setSelectOnFocus(true);
		layoutContainer13.add(crefileUpload, new FormData("100%"));
		layoutContainer13.setBorders(false);
		lcSchCol3.add(layoutContainer13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));

		/** column text : PDF파일자료_패스워드 crePasswd */
		LayoutContainer layoutContainer14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14.setLayout(frmlytSch);

		crePasswd = new TextField<String>();
		crePasswd.setName("crePasswd");
		crePasswd.setId("crePasswd");
		crePasswd.setFieldLabel("패스워드");
		crePasswd.setSelectOnFocus(true);
		crePasswd.setPassword(true);
		layoutContainer14.add(crePasswd, new FormData("100%"));
		layoutContainer14.setBorders(false);
		lcSchCol3.add(layoutContainer14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		/** column text : PDF파일자료_원본자동검증여부 creOriginYn */
		LayoutContainer layoutContainer15 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer15.setLayout(frmlytSch);

		creOriginChkYn = new CheckBox();
		creOriginChkYn.setName("creOriginChkYn");
		creOriginChkYn.setBoxLabel("원본여부");
		creOriginChkYn.setValue(false);
		layoutContainer15.add(creOriginChkYn, new FormData("100%"));
		layoutContainer15.setBorders(false);
		lcSchCol3.add(layoutContainer15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer15_1 = new LayoutContainer();

		stlRflSttChkYn = new CheckBox();
		stlRflSttChkYn.setName("stlRflSttChkYn");
		stlRflSttChkYn.setBoxLabel("정산반영여부");
		stlRflSttChkYn.setLabelSeparator("");
		stlRflSttChkYn.setValue(false);
		layoutContainer15_1.add(stlRflSttChkYn, new FormData("100%"));
		layoutContainer15_1.setBorders(false);
		lcSchCol3.add(layoutContainer15_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		/** column text : text */
		LayoutContainer layoutContainer16 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer16.setLayout(frmlytSch);

		Label txt1 = new Label();
		Label txt2 = new Label();
		txt1.setText("* PDF 비밀번호는 인사 정보를 이용해 자동비교 됩니다.");
		txt2.setText("* PDF 검증여부에 체크된 경우 원본검증은 자동처리 됩니다.");
		layoutContainer16.setStyleAttribute("paddingLeft", "10px");
		layoutContainer16.setStyleAttribute("marginTop", "5px");
		layoutContainer16.setStyleAttribute("marginBottom", "5px");
		layoutContainer16.add(txt1, new FormData("100%"));
		layoutContainer16.add(txt2, new FormData("100%"));



		layoutContainer16.setBorders(false);
		lcSchCol3.add(layoutContainer16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));

		//현재사용중인 버튼
		Button topBtn = new Button("PDF 소득공제자료추출");
		topBtn.setIcon(MSFMainApp.ICONS.new16());
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				creOriginYn.setValue(creOriginChkYn.getValue());
				xmlImportData();
			}
		});

		//		Button topBtn01   = new Button("PDF 신용카드사용수정반영");
		//		topBtn01.setIcon(MSFMainApp.ICONS.new16());
		//		topBtn01.addListener(Events.Select, new Listener<ButtonEvent>() {
		//			public void handleEvent(ButtonEvent e) {
		//				creOriginYn.setValue(creOriginChkYn.getValue());
		//				xmlImportUpData();
		//			}
		//		});
		lcSchCol3.add(topBtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		//		lcSchCol3.add(topBtn01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		//fieldSet4.add(topBtn);

		layoutContainer1_4.add(fieldSet4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		/** --------------------------------------------------------------------------------------------------------- */
		FieldSet ddcFieldSet = new FieldSet();
		ddcFieldSet.setEnabled(false);
		ddcFieldSet.setVisible(false);
		ddcFieldSet.setHeadingHtml("공제신고서 PDF파일자료");
		ddcFieldSet.setHeight("130px");
		ddcFieldSet.setStyleAttribute("marginTop", "10px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer ddcLcSchCol = new LayoutContainer();
		ddcLcSchCol.setLayout(new ColumnLayout());
		ddcFieldSet.add(ddcLcSchCol, new FormData("100%"));

		/** column text : PDF파일자료_파일업로드 crefileUpload */
		LayoutContainer ddcLayoutContainer1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer1.setLayout(frmlytSch);

		ddxCrefileUpload = new FileUploadField();
		ddxCrefileUpload.setName("ddxCrefileUpload");
		ddxCrefileUpload.setFieldLabel("파일업로드");
		ddxCrefileUpload.setSelectOnFocus(true);
		ddxCrefileUpload.setStyleAttribute("marginBottom", "5px");
		ddcLayoutContainer1.add(ddxCrefileUpload, new FormData("100%"));
		ddcLayoutContainer1.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));

		/** column text : PDF파일자료_패스워드 crePasswd */
		LayoutContainer ddcLayoutContainer2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer2.setLayout(frmlytSch);

		ddcCrePasswd = new TextField<String>();
		ddcCrePasswd.setName("ddcCrePasswd");
		ddcCrePasswd.setId("ddcCrePasswd");
		ddcCrePasswd.setFieldLabel("패스워드");
		ddcCrePasswd.setSelectOnFocus(true);
		ddcCrePasswd.setPassword(true);
		ddcLayoutContainer2.add(ddcCrePasswd, new FormData("100%"));
		ddcLayoutContainer2.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		/** column text : PDF파일자료_원본자동검증여부 creOriginYn */
		LayoutContainer ddcLayoutContainer3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer3.setLayout(frmlytSch);

		ddcCreOriginChkYn = new CheckBox();
		ddcCreOriginChkYn.setName("ddcCreOriginChkYn");
		ddcCreOriginChkYn.setBoxLabel("원본여부");
		ddcCreOriginChkYn.setValue(false);
		ddcLayoutContainer3.add(ddcCreOriginChkYn, new FormData("100%"));
		ddcLayoutContainer3.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer ddcLayoutContainer4 = new LayoutContainer();

		ddcStlRflSttChkYn = new CheckBox();
		ddcStlRflSttChkYn.setName("ddcStlRflSttChkYn");
		ddcStlRflSttChkYn.setBoxLabel("정산반영여부");
		ddcStlRflSttChkYn.setLabelSeparator("");
		ddcStlRflSttChkYn.setValue(false);
		ddcLayoutContainer4.add(ddcStlRflSttChkYn, new FormData("100%"));
		ddcLayoutContainer4.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		/** column text : text */
		LayoutContainer ddcLayoutContainer5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer5.setLayout(frmlytSch);

		Label ddcTxt1 = new Label();
		Label ddcTxt2 = new Label();
		ddcTxt1.setText("* PDF 비밀번호는 인사 정보를 이용해 자동비교 됩니다.");
		ddcTxt2.setText("* PDF 검증여부에 체크된 경우 원본검증은 자동처리 됩니다.");
		ddcLayoutContainer5.setStyleAttribute("paddingLeft", "10px");
		ddcLayoutContainer5.setStyleAttribute("marginTop", "5px");
		ddcLayoutContainer5.setStyleAttribute("marginBottom", "5px");
		ddcLayoutContainer5.add(ddcTxt1, new FormData("100%"));
		ddcLayoutContainer5.add(ddcTxt2, new FormData("100%"));

		ddcLayoutContainer5.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));
		
		
		Button topDdcBtn = new Button("PDF 소득공제자료추출");
		topDdcBtn.setIcon(MSFMainApp.ICONS.new16());
		topDdcBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				ddcCreOriginYn.setValue(ddcCreOriginChkYn.getValue());
				xmlImportDdcData();
			}
		});

		ddcLcSchCol.add(topDdcBtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		layoutContainer1_4.add(ddcFieldSet, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		/** --------------------------------------------------------------------------------------------------------- */

		LayoutContainer layoutContainer17 = new LayoutContainer();
		layoutContainer17.setLayout(new ColumnLayout());

		Yeta5200XmlGridPanel = new MSFGridPanel(Yeta5200defXml, false, false,false, false);
		Yeta5200XmlGridPanel.setSize(250, 305);
		Yeta5200XmlGridPanel.setBorders(true);
		Yeta5200XmlGridPanel.setStyleAttribute("marginTop", "5px");
		layoutContainer17.add(Yeta5200XmlGridPanel,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));

		btnYetaP520001 = new Button("개별간소화파일");
		btnYetaP520001.setStyleAttribute("marginTop", "5px");
		btnYetaP520001.setStyleAttribute("marginLeft", "5px");
		btnYetaP520001.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (systemkey.getValue() == null) {
					Window.alert("정산대상자를 선택해주세요.");
				}
				else {
					YetaP520001 yetaP520001Form = new YetaP520001(ActionDatabase.READ, getThis());

					final MSFFormWindows msFwYeta520001 = new MSFFormWindows("자료추출상세내역",yetaP520001Form, "닫기", "920px", "710px", false);
					msFwYeta520001.show();
					yetaP520001Form.setMSFFormWindows(msFwYeta520001);

					//					funcSetPopUpRecord();

					yetaP520001Form.bind(ppRecord);
				}
			}
		});
		
		layoutContainer17.add(btnYetaP520001,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		//일괄간소화파일은 데이터스킵문제로 화면에 안보이게 주석처리함 연말정산2020_20210121,안양 잠깐 열어둠
		/*btnYetaP520002 = new Button("일괄간소화파일");
		btnYetaP520002.setStyleAttribute("marginTop", "5px");
		btnYetaP520002.setStyleAttribute("marginLeft", "5px");
		btnYetaP520002.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (systemkey.getValue() == null) {
					Window.alert("정산대상자를 선택해주세요.");
				}
				else {
					YetaP520002 yetaP520002Form = new YetaP520002(ActionDatabase.READ, getThis());

					final MSFFormWindows msFwYeta520002 = new MSFFormWindows("자료추출상세내역",yetaP520002Form, "닫기", "945px", "710px", false);
					msFwYeta520002.show();
					yetaP520002Form.setMSFFormWindows(msFwYeta520002);

					//					funcSetPopUpRecord();

					yetaP520002Form.bind(ppRecord);
				}
			}
		});

		layoutContainer17.add(btnYetaP520002,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));*/

		layoutContainer1_4.add(layoutContainer17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		plFrmYeta5200.add(layoutContainer1_4);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사

		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) {
					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); // 주민번호
				}
			}
		});
	} 

	private void funcSetPopUpRecord() {

		BaseModel ppRecord = new BaseModel();

		ppRecord.set("dpobCd", dpobCd.getValue());
		ppRecord.set("systemkey", systemkey.getValue());
		ppRecord.set("yrtxBlggYr", yrtxBlggYr.getValue());
		ppRecord.set("clutSeptCd", clutSeptCd.getValue());
		setPPRecord(ppRecord);
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}


	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}


	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	public Iterator<Record>  getListRecord() {
		return this.records;
	}


	private Yeta5200 getThis(){
		return this;
	}

	private void reloadYeta5200(){

		IColumnFilter filters = null;
		Yeta5200GridPanel.getTableDef().setTableColumnFilters(filters);

		//정산년
		Yeta5200GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") , SimpleColumnFilter.OPERATOR_EQUALS); 

		//정산구분
		Yeta5200GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 

		Yeta5200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta5200GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 


		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		Yeta5200GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);

		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		Yeta5200GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 

		//    String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
		//   remt2000DefGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  

		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		Yeta5200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 

		Yeta5200GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);


		Yeta5200GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta5200GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		Yeta5200GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   

		Yeta5200GridPanel.reload();  

	}

	private void reloadYeta5200Result(){

		IColumnFilter filters = null;
		Yeta5200XmlGridPanel.getTableDef().setTableColumnFilters(filters);

		//정산년
		Yeta5200XmlGridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") , SimpleColumnFilter.OPERATOR_EQUALS); 
		//정산구분
		Yeta5200XmlGridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta5200XmlGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 

		Yeta5200XmlGridPanel.reload();  

	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 전자파일 추출 컨데이너 호출  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : xmlImportData
	 * @date : Jan 26, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 26, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 *
	 */
	private void xmlImportData() { 

		MessageBox.confirm("전자문서", "전자문서를 업로드 하시겠습니까?<br>(등록되어있는 전자문서가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					
					final Timer tmMask01 = new Timer() {
						public void run() {
							// if (maskTracker)
							// { 
							cancel();
							plFrmYeta5200.unmask();  
							reloadYeta5200();
							reloadYeta5200Result();
							// }
						}
					};		        		  

					if("".equals(systemkey.getValue())){
						MessageBox.alert("", "PDF 전자문서 업로드 대상자를 선택하십시요.", null);
					}else if("".equals(clutSeptCd.getValue())){
						MessageBox.alert("", "정산구분은 필수 선택조건입니다.", null);
					} else { 
						//get the filename to be uploaded
						String filename = MSFSharedUtils.allowNulls(crefileUpload.getValue());
						String filename2 = MSFSharedUtils.allowNulls(ddxCrefileUpload.getValue());

						if (filename.length() == 0) {
							Window.alert("선택된 파일이 없습니다.");
						} else if (filename2.length() != 0) {
							MessageBox.alert("", "간소화 PDF 파일만 업로드해주세요.<br>(공제신고서 PDF 파일은 제외 시켜주세요.)", null);
						} else {
							//submit the form
							plFrmYeta5200.mask("PDF 전자문서 업데이트 중입니다. 업로드 중..."); 

							//파일업로드 처리
							plFrmYeta5200.setAction(GWT.getHostPageBaseURL() + "/imp/XmlYeta5200Import.do");
							plFrmYeta5200.setEncoding(Encoding.MULTIPART);
							plFrmYeta5200.setMethod(Method.POST);   
							//	                               FormElement frmEl=FormElement.as(plFrmYeta5200.getElement()); 
							//	                               frmEl.setAcceptCharset("UTF-8"); 
							plFrmYeta5200.submit();  
							plFrmYeta5200.onFrameLoad();  
							picBoolFile = true;
							tmMask01.scheduleRepeating(3000);
						}               

						// reset and unmask the form 
						// after file upload 
						plFrmYeta5200.addListener(Events.Submit, new Listener<FormEvent>() {
							public void handleEvent(FormEvent evt) {   
//								Window.alert("얍 : "+evt.getResultHtml());
//								if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//									//업로드가  성공했으면 인서트 모듈을 태운다. 
//									plFrmYeta5200.unmask();
//									MessageBox.alert("", "PDF 전자문서 업로드가 정상적으로 완료되었습니다.", null); 
//									picBoolFile = false;
//									evt.setResultHtml("");
//								} else {
//									if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//										//업로드가  성공했으면 인서트 모듈을 태운다.
//										plFrmYeta5200.unmask();  
//										MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
//										picBoolFile = false;
//										evt.setResultHtml("");
//									} else {
//										//실패 메시지나 에러 메시지 처리 . 
//										if (evt.getResultHtml().matches(".*error.*") && picBoolFile) {
//											//업로드가  성공했으면 인서트 모듈을 태운다.
//											plFrmYeta5200.unmask();  
//											MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
//											picBoolFile = false;
//											evt.setResultHtml("");
//										}
//									} 
//								}
							};
						});
					}
				}	
			}	
		}); 
	} 


	private void xmlImportDdcData() { 

		MessageBox.confirm("전자문서", "전자문서를 업로드 하시겠습니까?<br>(등록되어있는 전자문서가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					//HashMap<String, String> param = new HashMap<String, String>();
					// only accept certain files  

					//						dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
					//		        		systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
					//		        		edacRvyy.setValue(MSFSharedUtils.allowNulls(bmData.get("edacRvyy")));  /** set 연말정산귀속년도 : edacRvyy */
					//		        		settGbcd.setValue(MSFSharedUtils.allowNulls(bmData.get("settGbcd")));/** set 정산구분코드 : settGbcd */
					//		        		edacSeilNum.setValue((Long)bmData.get("edacSeilNum"));/** set 연말정산마감일련번호 : edacSeilNum */

					final Timer tmMask01 = new Timer() {
						public void run() {
							// if (maskTracker)
							// { 
							cancel();
							plFrmYeta5200.unmask();  
							reloadYeta5200();
							reloadYeta5200Result();
							// }
						}
					};		        		  

					if("".equals(systemkey.getValue())){
						MessageBox.alert("", "PDF 전자문서 업로드 대상자를 선택하십시요.", null);
					} else if("".equals(clutSeptCd.getValue())){
						MessageBox.alert("", "정산구분은 필수 선택조건입니다.", null);
					} else { 
						//get the filename to be uploaded

						String filename = MSFSharedUtils.allowNulls(ddxCrefileUpload.getValue());
						String filename2 = MSFSharedUtils.allowNulls(crefileUpload.getValue());

						if (filename.length() == 0) {
							Window.alert("선택된 파일이 없습니다.");
						} else if(filename2.length() != 0){
							MessageBox.alert("", "공제신고서 PDF 파일만 업로드해주세요.<br>(공제신고서 PDF 파일은 제외 시켜주세요.)", null);
						} else {
							//submit the form
							plFrmYeta5200.mask("PDF 전자문서 업데이트 중입니다. 업로드 중..."); 

							//파일업로드 처리
							plFrmYeta5200.setAction(GWT.getHostPageBaseURL() + "/imp/XmlYeta5200DdcImport.do");
							plFrmYeta5200.setEncoding(Encoding.MULTIPART);
							plFrmYeta5200.setMethod(Method.POST);   
							//	                               FormElement frmEl=FormElement.as(plFrmYeta5200.getElement()); 
							//	                               frmEl.setAcceptCharset("UTF-8"); 
							plFrmYeta5200.submit();  
							plFrmYeta5200.onFrameLoad();  
							picBoolFile = true;
							tmMask01.scheduleRepeating(5000);
						}               

						// reset and unmask the form 
						// after file upload 
						plFrmYeta5200.addListener(Events.Submit, new Listener<FormEvent>() {
							public void handleEvent(FormEvent evt) {   
//								Window.alert("얍 : "+evt.getResultHtml());
//								if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//									//업로드가  성공했으면 인서트 모듈을 태운다. 
//									plFrmYeta5200.unmask();
//									MessageBox.alert("", "PDF 전자문서 업로드가 정상적으로 완료되었습니다.", null); 
//									picBoolFile = false;
//									evt.setResultHtml("");
//								} else {
//									if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//										//업로드가  성공했으면 인서트 모듈을 태운다.
//										plFrmYeta5200.unmask();  
//										MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
//										picBoolFile = false;
//										evt.setResultHtml("");
//									} else {
//										//실패 메시지나 에러 메시지 처리 . 
//										if (evt.getResultHtml().matches(".*error.*") && picBoolFile) {
//											//업로드가  성공했으면 인서트 모듈을 태운다.
//											plFrmYeta5200.unmask();  
//											MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
//											picBoolFile = false;
//											evt.setResultHtml("");
//										}
//									} 
//								}
							};
						});
					}
				}	
			}	
		}); 
	} 

	//폼초기화 검색조건포함 
	private void formInit() {

		dpobCd.setValue("") ;         /**  column 사업장코드 : dpobCd */
		systemkey.setValue("");        /**  column SYSTEMKEY : systemkey */ 
		yrtxBlggYr.setValue("");  /** set 연말정산귀속년도 : edacRvyy */
		clutSeptCd.setValue("");/** set 정산구분코드 : settGbcd */

		typOccuNm.setValue(""); 
		hanNm.setValue("");
		deptNm.setValue("");
		crePasswd.setValue(""); 
		ddcCrePasswd.setValue(""); 
		creOriginChkYn.setValue(false);
		crefileUpload.clear();
		ddxCrefileUpload.clear();
		picBoolFile = false;


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


}