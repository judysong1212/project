/**
 * 원천징수부서등록 및 대상자 원천징수부서맵핑 
 */
package com.app.exterms.yearendtax.client.form.yeta2016;
  

import java.util.ArrayList;
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
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta2000Def;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110002Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110002ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP110002   extends MSFFormPanel {  

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
 
	private ContentPanel cpYeta1100;

	private Ye16Ta2000Def yetaP110002def = new Ye16Ta2000Def("YETAP110002");
	private MSFGridPanel yetaP110002GridPanel;

	private Button btnAllUsed;
	private Button btnUnUsed;
	private Button btnSelected;
	private MSFFormPanel popCom0100 = null;
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	// -------------- 권한 설정 객체 종료 --------------
    
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;
	private Boolean midChk = false;
 	
 	/**
 	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 	 * 화면 렌더링 변수 선언 
 	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 	 */
	private MSFPanel caller;
	private Boolean reading = false;
	private Boolean readFlag = false;
	public FormBinding formBinding;
	// public FormBinding formBinding2;
	
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ButtonBar topPayr4200Bar;
	private Button btnPayr4200Sreach;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	
//	private HiddenField<String> systemkey;
	private HiddenField<String> dpobCd;  					// 사업장코드
	
	private HiddenField<String> clutYr; 					// 정산년		
	private TextField<String> srhClutYr; 					// 정산년
	
	private HiddenField<String> payrMangDeptCd; 			// 단위기관	
	private HiddenField<String> payrMangDeptNm; 			// 단위기관
	private TextField<String> srhPayrMangDeptNm; 			// 단위기관
	
	private HiddenField<String> emymtDivCd; 				// 고용구분	
	private HiddenField<String> emymtDivNm; 				// 고용구분	
	private TextField<String> srhEmymtDivNm; 				// 고용구분
	
	private HiddenField<String> repbtyBusinDivCd; 			// 호봉제구분코드	
	private HiddenField<String> repbtyBusinDivNm; 			// 호봉제구분코드	
	private TextField<String> srhRepbtyBusinDivNm; 			// 호봉제구분코드
	
	private HiddenField<String> clutSeptCd; 				// 정산구분	
	private HiddenField<String> clutSeptNm; 				// 정산구분	
	private TextField<String> srhClutSeptNm; 				// 정산구분	
	
	private HiddenField<String> deptCd; 					// 부서
	private HiddenField<String> deptNm; 					// 부서	
	private TextField<String> srhDeptNm; 					// 부서
	
	private HiddenField<String> deptGpCd; 					// 부서직종그룹코드
	private HiddenField<String> deptGpNm; 					// 부서직종그룹코드
	private TextField<String> srhDeptGpNm; 					// 부서직종그룹코드
	
	private HiddenField<String> typOccuCd; 					// 직종	
	private HiddenField<String> typOccuNm; 					// 직종
	private TextField<String> srhTypOccuNm; 				// 직종
	
	private HiddenField<String> dtilOccuInttnCd; 			// 직종세	
	private HiddenField<String> dtilOccuInttnNm; 			// 직종세	
	private TextField<String> srhDtilOccuInttnNm; 			// 직종세
	
	private HiddenField<String> businCd; 					// 사업	
	private HiddenField<String> businNm; 					// 사업	
	private TextField<String> srhBusinNm; 					// 사업
	
	private HiddenField<String> hanNm; 						// 성명	
	private TextField<String> srhHanNm; 					// 성명
	
	private HiddenField<String> resnRegnNum; 				// 주민번호	
	private TextField<String> srhResnRegnNum; 				// 주민번호
	
	private HiddenField<String> systemkey; 					// 시스템키
	

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 연말정산대상자-생성 폼 시작 --------------
	private MSFTextField creDeptCd; 						// 부서명
	private MSFTextField creDeptNm; 						// 부서명
	private Button btnDeptCd;
	// -------------- 연말정산대상자-생성 폼 종료 --------------
	
	// -------------- 전자신고 기본정보 폼 시작 --------------
	private MSFComboBox<BaseModel> creEdacRvyy; 			// 정산년도
	private MSFComboBox<BaseModel> creSettGbcd; 			// 정산구분
	private MSFComboBox<BaseModel> creYetaDpcd; 			// 원천신고부서
	private MSFComboBox<BaseModel> creBusoprRgstnum; 		// 사업자등록번호
	
	private HiddenField<String> yetaDpcd;
	private HiddenField<String> busoprRgstnumStr; 			// 사업자등록번호

	private MSFTextField reprName; 							// 대표자(성명) 
	private MSFTextField busoprRgstnum; 					// 사업자등록번호 
	private MSFTextField resuNumb; 							// 주민등록번호 
	private MSFTextField corpNum; 							// 법인번호 
	private MSFTextField corpFmnmNm; 						// 법인명 
	private MSFTextField incmPost; 							// 소재지주소_우편번호
	private MSFTextField incmAddr; 							// 소재지주소_기본주소
	private MSFTextField incmAdtl; 							// 소재지주소_상세주소
	private MSFTextField txOffcCd; 							// 관할세무서코드 
	private MSFTextField pentrSeptCd; 						// 제출자구분 
	private MSFTextField txDeptyMangeNum; 					// 세무대리인번호 
	private MSFTextField idHMTXId; 							// 홈텍스 
	private MSFTextField txPgmCd; 							// 세무프로그램코드 

	private MSFTextField pernChrgDeptNm; 					// 담당부서명 
	private MSFTextField pernChrgPhnNum; 					// 담당자전화번호 
	private MSFTextField pernChrgNm; 						// 담당자성명 
	// -------------- 전자신고 기본정보 폼 종료 --------------
	
	private  Iterator<Record> records;
      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr410001FormBinding() {
	 	 
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
 
	private YetaP110002ServiceAsync yetaP110002Service = YetaP110002Service.Util.getInstance();
	
	private ListStore<BaseModel> lscreClutYrStore 	= new ListStore<BaseModel>(); 	// 년도
	private ListStore<BaseModel> lscreSettGbcd 		= new ListStore<BaseModel>(); 	// 정산구분
	private ListStore<BaseModel> lsYetaDpcd  		= new ListStore<BaseModel>();	// 원천징수부서코드  
	private ListStore<BaseModel> lsBusoprRgstnum  	= new ListStore<BaseModel>();	// 사업자등록번호  

	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO  msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
	private Ye16Ta1005DTO ye16Ta1005Dto;
  		
	    
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
	
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
        	saveYe161005();
            break;
        case UPDATE:
        	saveYe161005();
            break;
        case DELETE:
        	saveYe161005();	
            break;
		default:
			MessageBox.alert("no Action", "ActionDatabase Error", null);
			break;
        }
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
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/ 
 
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
	public YetaP110002(ActionDatabase actionDatabase, final MSFPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		//this.actionDatabase = actionDatabase;
		this.caller = caller;
		
		
		
		// 콤보 권한초기화
//		initLoad();

		cpYeta1100 = new ContentPanel();

		createSearchForm(); 	// 검색필드를 적용
		createStandardForm(); 	// 기본정보필드

		cpYeta1100.setBodyBorder(false);
		cpYeta1100.setBorders(false);
		cpYeta1100.setHeaderVisible(false);
		cpYeta1100.setSize("890px", "640px");

		this.add(cpYeta1100);
		formBinding = new FormBinding(this, true);

		this.setSize("910px", "710px");
	}
	    
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	 private void checkYetaP110002Auth( String authAction, ListStore<BaseModel>bm) {
		 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
	
			 if (!maskTracker) { unmask(); } 
			   authExecEnabled() ;
			 
		 }
	 }

	 private void authExecEnabled() { 
//	   //------------------
//		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			 * 권한설정을 위한 콤보처리를 위한 메서드 시작
//			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//			 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//		 //----------------------------------------------------
//		 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
//		 gwtAuthorization.formAuthFieldConfig(fldArrField);
//		 srhClutYr.setValue(lsClutYrStore.findModel("year","2016"));
//         srhClutSeptCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
//         
//		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
//		 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//		 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	 }
	 
	 
//	final Timer tmMask = new Timer() {
//		public void run() {
//			if (lsEmymtDivCd.getCount() > 0) {
//
//				cancel();
//				unmask();
//				authExecEnabled();
//				maskTracker = true;
//
//			} else {
//				tmMask.scheduleRepeating(2000);
//			}
//		}
//	};
//
//	 private void initLoad() {
//	
//		 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//		 gwtAuthorization = GWTAuthorization.getInstance();
//		 gwtExtAuth = GWTExtAuth.getInstance();
//		
//		
//		 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//			 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//			 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
//			 authMapDef.put("srhDeptCd",Boolean.FALSE);
//			 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
//		
//		 gwtExtAuth.setCheckMapDef(authMapDef);
//		
//		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//			 //권한 검색조건처리를 위해 추가된 부분
//			 mask("[화면로딩] 초기화 진행 중!");
//		 }	
//		 tmMask.scheduleRepeating(5000);
//	 }
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	
	    
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createPayrP410001Form() {

	}
	   
	  
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		 
		
		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lscreSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분
//		settGbcd.setValue(lscreSettGbcd.getAt(0));
		// --------------------공통 코드 불러 오는 함수--------------------------------------------------		
		
		// --------------------정산년도 불러 오는 함수------------------------------------------------
		lscreClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
//		edacRvyy.setValue(lscreClutYrStore.findModel("year","2015"));
		// --------------------정산년도 불러 오는 함수------------------------------------------------
		 
		 //--------------------- 원천신고부서 리스트를 가져옴. -------------------------------------------------	
		// --------------------연말정산 불러 오는 함수------------------------------------------------	
//		ye16Ta1005Dto = new Ye16Ta1005DTO();
//		ye16Ta1005Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
//		ye16Ta1005Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());    /** column 부서코드 : deptCd */
//		ye16Ta1005Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdListNoAuth();
		// --------------------연말정산 불러 오는 함수------------------------------------------------	
//		 yetaP110002Service.getYeta2000YetaDpcdList(ye16Ta1005Dto, new AsyncCallback<List<BaseModel>>() {
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				lsYetaDpcd.add(result);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				MessageBox.alert("", "원천신고부서 리스트를 가져오지 못했습니다. </br> 관리자에게 문의해주세요.", null);
//			}
//		});
		//--------------------- 원천신고부서 리스트를 가져옴. -------------------------------------------------	
		actionDatabase = ActionDatabase.UPDATE;
		 
		dpobCd = new HiddenField<String>();
		dpobCd.setName("dpobCd");
		cpYeta1100.add(dpobCd);
		 
		clutYr = new HiddenField<String>();
		clutYr.setName("clutYr");
		cpYeta1100.add(clutYr);
		
		payrMangDeptCd = new HiddenField<String>();
		payrMangDeptCd.setName("payrMangDeptCd");
		cpYeta1100.add(payrMangDeptCd);

		payrMangDeptNm = new HiddenField<String>();
		payrMangDeptNm.setName("payrMangDeptNm");
		cpYeta1100.add(payrMangDeptNm);
		 		 
		 
		emymtDivCd = new HiddenField<String>();
		emymtDivCd.setName("emymtDivCd");
		cpYeta1100.add(emymtDivCd);		 
		 
		 
		emymtDivNm = new HiddenField<String>();
		emymtDivNm.setName("emymtDivNm");
		cpYeta1100.add(emymtDivNm);		 
		
		
		repbtyBusinDivCd = new HiddenField<String>();
		repbtyBusinDivCd.setName("repbtyBusinDivCd");
		cpYeta1100.add(repbtyBusinDivCd);		 
		 		 
		
		repbtyBusinDivNm = new HiddenField<String>();
		repbtyBusinDivNm.setName("repbtyBusinDivNm");
		cpYeta1100.add(repbtyBusinDivNm);		 
		 		 
		clutSeptCd = new HiddenField<String>();
		clutSeptCd.setName("clutSeptCd");
		cpYeta1100.add(clutSeptCd);		
		
		clutSeptNm = new HiddenField<String>();
		clutSeptNm.setName("clutSeptNm");
		cpYeta1100.add(clutSeptNm);		
		
		
		deptCd = new HiddenField<String>();
		deptCd.setName("deptCd");
		cpYeta1100.add(deptCd);	
		
		
		deptNm = new HiddenField<String>();
		deptNm.setName("deptNm");
		cpYeta1100.add(deptNm);	
		
		
		deptGpCd = new HiddenField<String>();
		deptGpCd.setName("deptGpCd");
		cpYeta1100.add(deptGpCd);	
		
		deptGpNm = new HiddenField<String>();
		deptGpNm.setName("deptGpNm");
		cpYeta1100.add(deptGpNm);	
		
		typOccuCd = new HiddenField<String>();
		typOccuCd.setName("typOccuCd");
		cpYeta1100.add(typOccuCd);		
		
		
		typOccuNm = new HiddenField<String>();
		typOccuNm.setName("typOccuNm");
		cpYeta1100.add(typOccuNm);		
		
		
		dtilOccuInttnCd = new HiddenField<String>();
		dtilOccuInttnCd.setName("dtilOccuInttnCd");
		cpYeta1100.add(dtilOccuInttnCd);			
		
		
		dtilOccuInttnNm = new HiddenField<String>();
		dtilOccuInttnNm.setName("dtilOccuInttnNm");
		cpYeta1100.add(dtilOccuInttnNm);		
		
		
		businCd = new HiddenField<String>();
		businCd.setName("businCd");
		cpYeta1100.add(businCd);
		
		
		businNm = new HiddenField<String>();
		businNm.setName("businNm");
		cpYeta1100.add(businNm);	
		
		
		hanNm = new HiddenField<String>();
		hanNm.setName("hanNm");
		cpYeta1100.add(hanNm);	
		
		resnRegnNum = new HiddenField<String>();
		resnRegnNum.setName("resnRegnNum");
		cpYeta1100.add(resnRegnNum);		
		
		systemkey = new HiddenField<String>();
		systemkey.setName("systemkey");
		cpYeta1100.add(systemkey);	
		
		yetaDpcd = new HiddenField<String>();
		yetaDpcd.setName("yetaDpcd");
		cpYeta1100.add(systemkey);	
		
		busoprRgstnumStr = new HiddenField<String>();
		busoprRgstnumStr.setName("busoprRgstnumStr");
		cpYeta1100.add(systemkey);	
		
		
		
		
		
		
		 
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		// fieldSet.setHeight("80px");
		
		
	

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
		
		srhClutYr = new TextField<String>();
		srhClutYr.setName("srhClutYr");
		srhClutYr.setFieldLabel("정산년도");
		layoutContainer1.add(srhClutYr, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);
				    
		    
				    
		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch);
		
		srhPayrMangDeptNm = new TextField<String>();
		srhPayrMangDeptNm.setName("srhPayrMangDeptNm");
		srhPayrMangDeptNm.setFieldLabel("단위기관");
		layoutContainer3.add(srhPayrMangDeptNm, new FormData("100%"));


		
		
		/** column 고용구분 : EmymtDivCd */
		LayoutContainer layoutContainer4 = new LayoutContainer(new ColumnLayout());
		layoutContainer4.setBorders(false);

		LayoutContainer layoutContainer77 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer77.setLayout(frmlytSch);
		
		srhEmymtDivNm = new TextField<String>();
		srhEmymtDivNm.setName("srhEmymtDivNm");
		srhEmymtDivNm.setFieldLabel("고용구분");
		layoutContainer77.add(srhEmymtDivNm, new FormData("100%"));
		layoutContainer4.add(layoutContainer77,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		
		
		LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_101.setLayout(frmlytSch);
		
		srhRepbtyBusinDivNm = new TextField<String>();
		srhRepbtyBusinDivNm.setName("srhRepbtyBusinDivNm");
		srhRepbtyBusinDivNm.setHideLabel(true);
		srhRepbtyBusinDivNm.setLabelSeparator("");
		layoutContainer_101.add(srhRepbtyBusinDivNm, new FormData("100%"));
		layoutContainer4.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

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

		layoutContainer1_2.add(layoutContainer5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer5.setBorders(false);


		/** column 주민등록번호 : resnRegnNum */
		LayoutContainer layoutContainer6 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6.setLayout(frmlytSch);

		srhResnRegnNum = new TextField<String>();
		srhResnRegnNum.setName("srhResnRegnNum");
		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
		srhResnRegnNum.setHideLabel(true);
		layoutContainer6.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer1_2.add(layoutContainer6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer6.setBorders(false);
		layoutContainer1_2.setBorders(false);

		LayoutContainer layoutContainer_16 = new LayoutContainer();
		layoutContainer_16.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytSch);

		/** column 정산구분 : CalcSevePayPsnDivCd */
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7.setLayout(frmlytSch);
		
		
		srhClutSeptNm = new TextField<String>();
		srhClutSeptNm.setName("srhClutSeptNm");
		srhClutSeptNm.setFieldLabel("정산구분");
		layoutContainer7.add(srhClutSeptNm, new FormData("100%"));

		
		
		
		LayoutContainer layoutContainer8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer8.setLayout(frmlytSch);

		srhDeptNm = new TextField<String>();
		srhDeptNm.setName("srhDeptNm");
		srhDeptNm.setFieldLabel("부서");
		layoutContainer8.add(srhDeptNm, new FormData("100%"));
		layoutContainer8.setBorders(false);

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_3 = new LayoutContainer();
		layoutContainer1_3.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_211 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_211.setLayout(frmlytSch);
		
		
		srhDeptGpNm = new TextField<String>();
		srhDeptGpNm.setName("srhDeptGpNm");
		srhDeptGpNm.setFieldLabel("직종");
		layoutContainer_211.add(srhDeptGpNm, new FormData("100%"));

		/** column 직종 : srhTypOccuCd */
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuCd.setLayout(frmlytSch);

		srhTypOccuNm = new TextField<String>();
		srhTypOccuNm.setName("srhTypOccuNm");
		srhTypOccuNm.setHideLabel(true);
		srhTypOccuNm.setLabelSeparator("");
		lcTypOccuCd.add(srhTypOccuNm, new FormData("100%"));

		LayoutContainer lcSchRight = new LayoutContainer();

		frmlytSch = new FormLayout();
		// frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		lcSchRight.setLayout(frmlytSch);
		
		srhDtilOccuInttnNm = new TextField<String>();
		srhDtilOccuInttnNm.setName("srhDtilOccuInttnNm");
		srhDtilOccuInttnNm.setHideLabel(true);
		srhDtilOccuInttnNm.setLabelSeparator("");
		lcSchRight.add(srhDtilOccuInttnNm, new FormData("100%"));

		layoutContainer1_3.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer1_3.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer1_3.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer1_3.setBorders(false);

		/** column 사업 : BusinCd */
		LayoutContainer layoutContainer9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9.setLayout(frmlytSch);
		
		srhBusinNm = new TextField<String>();
		srhBusinNm.setName("srhBusinNm");
		srhBusinNm.setFieldLabel("사업");

		layoutContainer9.add(srhBusinNm, new FormData("100%"));
		layoutContainer9.setBorders(false);
		
		
		lcSchCol1.add(layoutContainer1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));   	// 정산년,월
		lcSchCol1.add(layoutContainer3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 단위기관
		lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 		// 고용구분
			    
		lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 정산구분
		lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 부서
		lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
			    
		lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 사업
		lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 성명, 주민등록번호
		lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 

		cpYeta1100.add(fieldSet);
		
		
		FieldSet fieldSet_2 = new FieldSet();
		fieldSet_2.setHeadingHtml("");
		// fieldSet_3.setHeight("230px");
		fieldSet_2.setCollapsible(false);
		
		LayoutContainer lcSchCol2 = new LayoutContainer(new ColumnLayout());
		
		/** column 년도 : edacPvYy */
		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout formLayout = new FormLayout();
		formLayout.setLabelWidth(100);
		formLayout.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(formLayout);

		creEdacRvyy = new MSFComboBox<BaseModel>();
		creEdacRvyy.setName("creEdacRvyy");
		creEdacRvyy.setFieldLabel("정산년도");
		creEdacRvyy.setForceSelection(true);
		creEdacRvyy.setMinChars(1);
		creEdacRvyy.setDisplayField("yearDisp");
		creEdacRvyy.setValueField("year");
		creEdacRvyy.setTriggerAction(TriggerAction.ALL);
		creEdacRvyy.setEmptyText("--년도--");
		creEdacRvyy.setSelectOnFocus(true);
		creEdacRvyy.setReadOnly(true);
		creEdacRvyy.setStore(lscreClutYrStore);
		creEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				creEdacRvyy.setValue(lscreClutYrStore.findModel("year","2016"));
			}
		});
//		creEdacRvyy.setValue(lscreClutYrStore.findModel("year","2016"));
		lc1_1.add(creEdacRvyy, new FormData("100%"));
		// lc11.add(lc1_1, new FormData("100%"));
		
		
		/** column 정산구분 : */
		LayoutContainer layoutContainer13_ = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13_.setLayout(frmlytSch);

		creSettGbcd = new MSFComboBox<BaseModel>();
		creSettGbcd.setName("settGbcd");
		creSettGbcd.setForceSelection(true);
		creSettGbcd.setMinChars(1);
		creSettGbcd.setDisplayField("commCdNm");
		creSettGbcd.setValueField("commCd");
		creSettGbcd.setTriggerAction(TriggerAction.ALL);
		creSettGbcd.setEmptyText("--정산구분선택--");
		creSettGbcd.setSelectOnFocus(true);
		creSettGbcd.setReadOnly(true);
		creSettGbcd.setEnabled(true);
		creSettGbcd.setStore(lscreSettGbcd);
		creSettGbcd.setFieldLabel("정산구분");
		creSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				creSettGbcd.setValue(lscreSettGbcd.getAt(0));
			}
		});
//		creSettGbcd.setValue(lscreSettGbcd.getAt(0));
		layoutContainer13_.add(creSettGbcd, new FormData("100%"));
		layoutContainer13_.setBorders(false);
		
		
		LayoutContainer layoutContainer14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14.setLayout(frmlytSch);
		
		creYetaDpcd = new MSFComboBox<BaseModel>();
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
		creYetaDpcd.setStore(lsYetaDpcd);
		creYetaDpcd.setFieldLabel("원천신고부서");
		layoutContainer14.add(creYetaDpcd, new FormData("100%"));
		layoutContainer14.setBorders(false);
		
		creYetaDpcd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 원천신고부서가 변경될 경우 해당하는 사업자등록번호를 가져옴
				BaseModel bmClutYr = se.getSelectedItem();
				
				if (bmClutYr != null) {
					
					yetaDpcd.setValue(MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd")); 
					
					readFlag = true;
					
					// TODO 콤보 선택시 사업자번호 스토어 
					lsBusoprRgstnum.removeAll();
					creBusoprRgstnum.setStore(new ListStore<BaseModel>());
					creBusoprRgstnum.setValue(new BaseModel());
					
					
					Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
					yeta161005Dto.setDpobCd(dpobCd.getValue());
					yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd"));
					
					yetaP110002Service.getYeta2000busoprRgstnumList(yeta161005Dto, new AsyncCallback<List<BaseModel>>() {
						@Override
						public void onSuccess(List<BaseModel> result) {
							
							if (!result.isEmpty()) {
								lsBusoprRgstnum.add(result);
								creBusoprRgstnum.setStore(lsBusoprRgstnum); 
								creBusoprRgstnum.setValue(lsBusoprRgstnum.getAt(0));
								creBusoprRgstnum.fireEvent(Events.SelectionChange);
							} else {
								//초기화 인서트 모드 
								formInit();
								actionDatabase = ActionDatabase.INSERT;
							}
						}
							
						@Override
						public void onFailure(Throwable caught) {
							MessageBox.alert("", "사업자번호 리스트를 가져오지 못했습니다. </br> 관리자에게 문의해주세요.", null);
						}
					});
					//reload();
					
					readFlag = false;
				}
			}
		}); 		
 
		
		LayoutContainer layoutContainer15 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer15.setLayout(frmlytSch);
		
		creBusoprRgstnum = new MSFComboBox<BaseModel>();
		creBusoprRgstnum.setName("creBusoprRgstnum");
		creBusoprRgstnum.setForceSelection(true);
		creBusoprRgstnum.setMinChars(1);
		creBusoprRgstnum.setDisplayField("busoprRgstnum");
		creBusoprRgstnum.setValueField("busoprRgstnum");
		creBusoprRgstnum.setTriggerAction(TriggerAction.ALL);
		creBusoprRgstnum.setEmptyText("--원천신고부서--");
		creBusoprRgstnum.setSelectOnFocus(true);
		creBusoprRgstnum.setReadOnly(false);
		creBusoprRgstnum.setEnabled(true);
		creBusoprRgstnum.setStore(lsBusoprRgstnum);
		creBusoprRgstnum.setFieldLabel("사업자등록번호");
		creBusoprRgstnum.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				 
				if(!readFlag) {
					// 사업자등록번호를 선택할 경우 해당 원천신고부서의 정보를 가져와 뿌려준다.
					BaseModel bmClutYr = se.getSelectedItem();
					
					if (bmClutYr != null) { 
						
						Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
						
						yeta161005Dto.setDpobCd(dpobCd.getValue());
						yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd"));
						yeta161005Dto.setBusoprRgstnum(MSFSharedUtils.getSelectedComboValue(creBusoprRgstnum, "busoprRgstnum"));
						
						if(MSFSharedUtils.paramNotNull(yeta161005Dto.getWhdgTxRegrstDeptCd())) {
							
							yetaP110002Service.getYe161005List(yeta161005Dto, new AsyncCallback<Ye16Ta1005DTO>() {
								@Override
								public void onSuccess(Ye16Ta1005DTO result) {
									
									// 필드 초기화
									formInit();
									
									dpobCd.setValue(result.getDpobCd());    					/** column 사업장코드 : dpobCd */
//									ye161005Dto.setWhdgTxRegrstDeptCd(result.getWhdgTxRegrstDeptCd());    /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
//									ye161005Dto.setHhrkWhdgRegrstDeptCd(result.getHhrkWhdgRegrstDeptCd());    /** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
									txOffcCd.setValue(result.getTxOffcCd());    				/** column A3_세무서코드 : txOffcCd */
									pentrSeptCd.setValue(result.getPentrSeptCd());    			/** column A5_제출자구분 : pentrSeptCd */
									txDeptyMangeNum.setValue(result.getTxDeptyMangeNum());    	/** column A6_세무대리인관리번호 : txDeptyMangeNum */
									idHMTXId.setValue(result.getHmtxId());    					/** column A7_홈텍스ID : hmtxId */
									txPgmCd.setValue(result.getTxPgmCd());    					/** column A8_세무프로그램코드 : txPgmCd */
									busoprRgstnum.setValue(result.getBusoprRgstnum());    		/** column A9_사업자등록번호 : busoprRgstnum */
									corpFmnmNm.setValue(result.getCorpFmnmNm());    			/** column A10_법인_상호명 : corpFmnmNm */
									pernChrgDeptNm.setValue(result.getPernChrgDeptNm());    	/** column A11_담당자부서 : pernChrgDeptNm */
									pernChrgNm.setValue(result.getPernChrgNm());    			/** column A12_담당자성명 : pernChrgNm */
									pernChrgPhnNum.setValue(result.getPernChrgPhnNum());    	/** column A13_담당자전화번호 : pernChrgPhnNum */
//									useHanCd.setValue(result.getUseHanCd());    /** column A15_사용한글코드 : useHanCd */
//									sumtTgtPridCd.setValue(result.getSumtTgtPridCd());    /** column B16_제출대상기간코드 : sumtTgtPridCd */
									corpNum.setValue(result.getCorpNum());    					/** column 법인번호 : corpNum */
									incmPost.setValue(result.getIncmPost());   				 	/** column 소득신고의무자우편번호 : incmPost */
									incmAddr.setValue(result.getIncmAddr());    				/** column 소득신고의무자기본주소 : incmAddr */
									incmAdtl.setValue(result.getIncmAdtl());    				/** column 소득신고의무자상세주소 : incmAdtl */
									reprName.setValue(result.getReprName());    				/** column 대표자성명 : reprName */
									resuNumb.setValue(result.getResuNumb());    				/** column 주민등록번호 : resuNumb */
									
									
									// 사업자 번호를 hidded으로 담아둔다.
									busoprRgstnumStr.setValue(busoprRgstnum.getValue());
									
									actionDatabase = ActionDatabase.UPDATE;
								}
									
								@Override
								public void onFailure(Throwable caught) {
									MessageBox.alert("", "기등록된 원천신고부서 정보를 가져오지 못했습니다. </br> 관리자에게 문의해주세요.", null);
								}
							});
						}
						
						readFlag = false;
					}
					
				}

			}
		});		

		layoutContainer15.add(creBusoprRgstnum, new FormData("100%"));
		layoutContainer15.setBorders(false);
		
		
		lcSchCol2.add(lc1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 				// 정산년도
		lcSchCol2.add(layoutContainer13_,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 정산구분
		lcSchCol2.add(layoutContainer14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));		// 원천신고부서
		lcSchCol2.add(layoutContainer15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));		// 사업자등록번호
		
		fieldSet_2.add(lcSchCol2);
	//	cpYeta1100.add(fieldSet_2);
		
		//----
		FieldSet fieldSet_3 = new FieldSet();
		fieldSet_3.setHeadingHtml("원천신고부서");
		// fieldSet_3.setHeight("230px");
		fieldSet_3.setCollapsible(false);

		fieldSet_3.add(fieldSet_2);
		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		fieldSet_3.add(lcSchCol3, new FormData("100%"));

//		/** column 년도 : edacPvYy */
//		LayoutContainer lc1_1 = new LayoutContainer();
//		FormLayout formLayout = new FormLayout();
//		formLayout.setLabelWidth(100);
//		formLayout.setLabelAlign(LabelAlign.RIGHT);
//		lc1_1.setLayout(formLayout);
//
//		edacRvyy = new MSFComboBox<BaseModel>();
//		edacRvyy.setName("edacPvYy");
//		edacRvyy.setFieldLabel("정산년도");
//		edacRvyy.setForceSelection(true);
//		edacRvyy.setMinChars(1);
//		edacRvyy.setDisplayField("yearDisp");
//		edacRvyy.setValueField("year");
//		edacRvyy.setTriggerAction(TriggerAction.ALL);
//		edacRvyy.setEmptyText("--년도--");
//		edacRvyy.setSelectOnFocus(true);
//		edacRvyy.setReadOnly(true);
//		edacRvyy.setStore(lscreClutYrStore);
//		edacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//
//			}
//		});
//		edacRvyy.setValue(lscreClutYrStore.findModel("year","2016"));
//		lc1_1.add(edacRvyy, new FormData("100%"));
//		// lc11.add(lc1_1, new FormData("100%"));

//		/** column 정산구분 : */
//		LayoutContainer layoutContainer13_ = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer13_.setLayout(frmlytSch);
//
//		settGbcd = new MSFComboBox<BaseModel>();
//		settGbcd.setName("settGbcd");
//		settGbcd.setForceSelection(true);
//		settGbcd.setMinChars(1);
//		settGbcd.setDisplayField("commCdNm");
//		settGbcd.setValueField("commCd");
//		settGbcd.setTriggerAction(TriggerAction.ALL);
//		settGbcd.setEmptyText("--정산구분선택--");
//		settGbcd.setSelectOnFocus(true);
//		settGbcd.setReadOnly(true);
//		settGbcd.setEnabled(true);
//		settGbcd.setStore(lscreSettGbcd);
//		settGbcd.setFieldLabel("정산구분");
//		settGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//
//			}
//		});
//		settGbcd.setValue(lscreSettGbcd.getAt(0));
//		layoutContainer13_.add(settGbcd, new FormData("100%"));
//		layoutContainer13_.setBorders(false);
		
		
//		LayoutContainer layoutContainer14 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer14.setLayout(frmlytSch);
//		
//		yetaDpcd = new MSFComboBox<BaseModel>();
//		yetaDpcd.setName("yetaDpcd");
//		yetaDpcd.setForceSelection(true);
//		yetaDpcd.setMinChars(1);
//		yetaDpcd.setDisplayField("yetaDpnm");
//		yetaDpcd.setValueField("yetaDpcd");
//		yetaDpcd.setTriggerAction(TriggerAction.ALL);
//		yetaDpcd.setEmptyText("--원천신고부서--");
//		yetaDpcd.setSelectOnFocus(true);
//		yetaDpcd.setReadOnly(false);
//		yetaDpcd.setEnabled(true);
//		yetaDpcd.setStore(lsYetaDpcd);
//		yetaDpcd.setFieldLabel("원천신고부서");
//		yetaDpcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				
//				// TODO 콤보 선택시 조회루틴을 태운다
//
//			}
//		});
//
//		layoutContainer14.add(yetaDpcd, new FormData("100%"));
//		layoutContainer14.setBorders(false);


		/** column 대표자(성명) : */
		LayoutContainer layoutContainer16 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer20.setLayout(frmlytSch);

		corpNum = new MSFTextField();
		corpNum.setName("corpNum");
		corpNum.setFieldLabel("법인번호");
		new TextFieldMask<String>(corpNum, "999999-9999999");
		corpNum.setSelectOnFocus(true);

		layoutContainer20.add(corpNum, new FormData("100%"));
		layoutContainer20.setBorders(false);

		/** column 소재지주소 : */
		LayoutContainer layoutContainer21 = new LayoutContainer(new ColumnLayout());
				
		LayoutContainer lcIncmPost = new LayoutContainer();
				
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer25.setLayout(frmlytSch);

		idHMTXId = new MSFTextField();
		idHMTXId.setName("idHMTXId");
		idHMTXId.setFieldLabel("홈텍스 ID");
		idHMTXId.setSelectOnFocus(true);

		layoutContainer25.add(idHMTXId, new FormData("100%"));
		layoutContainer25.setBorders(false);

		/** column 세무프로그램코드 : */
		LayoutContainer layoutContainer26 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
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
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer27.setLayout(frmlytSch);

		TextField<String> tpTaxaPrcd = new TextField<String>(); 
		tpTaxaPrcd.setVisible(false);
		layoutContainer27.add(tpTaxaPrcd, new FormData("100%"));
		layoutContainer27.setBorders(false);

		/** column 담당부서명 : */
		LayoutContainer layoutContainer28 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer28.setLayout(frmlytSch);

		pernChrgDeptNm = new MSFTextField();
		pernChrgDeptNm.setName("pernChrgDeptNm");
		pernChrgDeptNm.setFieldLabel("담당부서명");
		pernChrgDeptNm.setSelectOnFocus(true);

		layoutContainer28.add(pernChrgDeptNm, new FormData("100%"));
		layoutContainer28.setBorders(false);

		/** column 담당자전화번호 : */
		LayoutContainer layoutContainer29 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer29.setLayout(frmlytSch);

		pernChrgPhnNum = new MSFTextField();
		pernChrgPhnNum.setName("pernChrgPhnNum");
		pernChrgPhnNum.setFieldLabel("담당자전화번호");
		pernChrgPhnNum.setSelectOnFocus(true);
		pernChrgPhnNum.setEmptyText("(02-123-4567) 형태로 입력)");
		layoutContainer29.add(pernChrgPhnNum, new FormData("100%"));
		layoutContainer29.setBorders(false);


		/** column 담당자성명 : */
		LayoutContainer layoutContainer31 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer31.setLayout(frmlytSch);

		pernChrgNm = new MSFTextField();
		pernChrgNm.setName("pernChrgNm");
		pernChrgNm.setFieldLabel("담당자성명");
		pernChrgNm.setSelectOnFocus(true);

		layoutContainer31.add(pernChrgNm, new FormData("100%"));
		layoutContainer31.setBorders(false);
		
		
		
		LayoutContainer layoutContainer32 = new LayoutContainer();
		frmlytSch = new FormLayout();
		layoutContainer32.setLayout(frmlytSch);
		
		ButtonBar btnBar2 = new ButtonBar();
		btnBar2.setAlignment(HorizontalAlignment.RIGHT);
		
		Button btnNew = new Button("신규");
		btnNew.setWidth(70);
		btnNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				// 원천신고부서폼 초기화
				formInit();
				actionDatabase = ActionDatabase.INSERT;
			}
		});
		btnBar2.add(btnNew);
		
		Button btnSave = new Button("저장");
		btnSave.setWidth(70);
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				MessageBox.confirm("저장", "해당 원천신고부서를 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
        			@Override
        			public void handleEvent(MessageBoxEvent be) {
        				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        					doAction(actionDatabase);
        	   	    	}
        			}
        		});
				
			}
		});
		btnBar2.add(btnSave);
		
		Button btnDel = new Button("삭제");
		btnDel.setWidth(70);
		btnDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
               	 
        	 		MessageBox.alert("오류", "마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
        	 		return; 
                 
               }
				
				MessageBox.confirm("삭제", "해당 원천신고부서를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
        			@Override
        			public void handleEvent(MessageBoxEvent be) {
        				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        					
        					actionDatabase = ActionDatabase.DELETE; 
        					doAction(actionDatabase);
        	   	    	}
        			}
        		});
				
			}
		});
		btnBar2.add(btnDel);
		layoutContainer32.add(btnBar2);


		lcSchCol3.add(layoutContainer16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 대표자(성명)
		lcSchCol3.add(layoutContainer17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.67)); 	// 법인명(상호)
		
		lcSchCol3.add(layoutContainer18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 사업자등록번호
		lcSchCol3.add(layoutContainer19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 주민등록번호
		lcSchCol3.add(layoutContainer20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34)); 	// 법인번호
		
		lcSchCol3.add(layoutContainer21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); 		// 소재지주소
		
		lcSchCol3.add(layoutContainer22,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 관할세무서코드
		lcSchCol3.add(layoutContainer23,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 제출자구분
		lcSchCol3.add(layoutContainer24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34)); 	// 세무대리인번호
		
		lcSchCol3.add(layoutContainer25,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 홈텍스 ID
		lcSchCol3.add(layoutContainer26,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 세무프로그램코드
//		lcSchCol3.add(layoutContainer27,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34)); 	// 공백
		lcSchCol3.add(layoutContainer28,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34)); 	// 담당부서명
		
		lcSchCol3.add(layoutContainer29,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 담당자전화번호
		lcSchCol3.add(layoutContainer31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 	// 담당자성명
		lcSchCol3.add(layoutContainer32,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34)); 	// 신규/저장/삭제
		
		cpYeta1100.add(fieldSet_3);

	}
	  
	 
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
		
	
		
		
		
		
		// 원천신고부서대상자 그리드
		FieldSet fldstNewFieldset_1 = new FieldSet();

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("원천신고부서대상자내역");
		fldstNewFieldset_1.setCollapsible(false);
 
		
		FieldSet fieldSet_2 = new FieldSet();
		fieldSet_2.setHeadingHtml("원천신고부서선택");
		// fieldSet_3.setHeight("230px");
		fieldSet_2.setCollapsible(false);
		
		LayoutContainer lcSchCol2 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer layoutContainer10 = new LayoutContainer();
		layoutContainer10.setLayout(new ColumnLayout());
		
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(100);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
        creDeptNm = new MSFTextField(); 
        creDeptNm.setName("creDeptNm");
        creDeptNm.setFieldLabel("원천신고부서"); 
        //currAffnDeptNm.setLabelSeparator("");
        creDeptNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		
        		if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        			creDeptCd.setValue("");
        			creDeptNm.setValue("");
	    		}
	    		if (MSFSharedUtils.paramNull(creDeptNm.getValue())) {
	    			creDeptCd.setValue("");
	    			creDeptNm.setValue("");
	    		}  
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        				creDeptCd.setValue("");
        				creDeptNm.setValue("");
        			}
        			fnPopupCommP150(creDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
        lcDeptNm.add(creDeptNm, new FormData("100%"));  
        
        
        LayoutContainer lcBtnDeptCd = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        lcBtnDeptCd.setLayout(frmlytSch);
          
        btnDeptCd = new Button();
        btnDeptCd.setIcon(MSFMainApp.ICONS.search()); 
        btnDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	 public void handleEvent(ButtonEvent e) { 
        		 if (MSFSharedUtils.allowNulls(creDeptNm.getValue()).trim().equals("")) {
        			 creDeptNm.setValue("");
        		 }
        		 fnPopupCommP150(creDeptNm.getValue()); 
        	 }
        });
        lcBtnDeptCd.add(btnDeptCd);
        
        
        LayoutContainer lcDeptCd = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(0);
        lcDeptCd.setLayout(frmlytSch);
        
        creDeptCd = new MSFTextField(); 
        creDeptCd.setLabelSeparator("");
        creDeptCd.setName("creDeptCd");
        creDeptCd.setReadOnly(true);
        
        lcDeptCd.add(creDeptCd, new FormData("100%"));
            
        layoutContainer10.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        layoutContainer10.add(lcBtnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.03));
        layoutContainer10.add(lcDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
        
        
        ButtonBar btnBar = new ButtonBar();
        btnBar.setAlignment(HorizontalAlignment.RIGHT);
        
//		LayoutContainer layoutContainer11 = new LayoutContainer();
		
		Button btnSelApp = new Button("선택자료적용");
		btnSelApp.setWidth(100);
		btnSelApp.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO(); 
        		final List<Ye16Ta2000DTO> listYeta2000Dto = new ArrayList<Ye16Ta2000DTO>();
        		
				Iterator<BaseModel> itBm = yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
					
				} 
				
				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						
						yeta2000Dto = new Ye16Ta2000DTO(); 
	        			yeta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));	 			/** column 사업장코드 : dpobCd */
	        			yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));			/** column 연말정산귀속년도 : edacRvyy */
	        			yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));			/** column 정산구분코드 : settGbcd */
	        			yeta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));		/** column SYSTEMKEY : systemkey */
	        			yeta2000Dto.setYetaDpcd(creDeptCd.getValue());
	        			listYeta2000Dto.add(yeta2000Dto);	
					}
				}
				
				if(listYeta2000Dto.size() <= 0) {
					Window.alert("적용할 데이터를 선택해 주세요.");
					
				}
				
				MessageBox.confirm("저장", "선택한 대상의 원천신고부서를 수정 하시겠습니까?",new Listener<MessageBoxEvent>(){
        			@Override
        			public void handleEvent(MessageBoxEvent be) {
        				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        					saveYeta2000(listYeta2000Dto);
        	   	    	}
        			}
        		});
				
			}
		});
		btnBar.add(btnSelApp);
//		layoutContainer11.add(btnSelApp);
		
//		LayoutContainer layoutContainer12 = new LayoutContainer();
		
		Button btnAllApp = new Button("전체적용");
		btnAllApp.setWidth(100);
		btnAllApp.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				// 원천신고부서를 선택했는지 체크한다.
				if(creDeptCd.getValue() == null || "".equals(creDeptCd.getValue())) {
					Window.alert("하단 원천신고부서를 선택해주세요.");
					return;
				}
				
				int  lsCnt = yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getCount();
          	  
          	  	for(int iCnt=0;iCnt < lsCnt;iCnt++) {
          	  		yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
          	  		yetaP110002GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
          	  	} 
          	  	yetaP110002GridPanel.getMsfGrid().getGrid().getView().refresh(true);
          	  	
          	  	
          	  	
          	  	Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO(); 
          	  	final List<Ye16Ta2000DTO> listYeta2000Dto = new ArrayList<Ye16Ta2000DTO>();
      		
				Iterator<BaseModel> itBm = yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
					
				} 
				
				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						
						yeta2000Dto = new Ye16Ta2000DTO(); 
	        			yeta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));	 		/** column 사업장코드 : dpobCd */
	        			yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));		/** column 연말정산귀속년도 : edacRvyy */
	        			yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));		/** column 정산구분코드 : settGbcd */
	        			yeta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
	        			yeta2000Dto.setYetaDpcd(creDeptCd.getValue());
	        			listYeta2000Dto.add(yeta2000Dto);	
					}
				}
				
				if(listYeta2000Dto.size() <= 0) {
					Window.alert("적용할 데이터를 선택해 주세요.");
					
				}
				
				MessageBox.confirm("저장", "전체 원천신고부서를 수정 하시겠습니까?",new Listener<MessageBoxEvent>(){
	      			@Override
	      			public void handleEvent(MessageBoxEvent be) {
	      				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	      					saveYeta2000(listYeta2000Dto);
	      	   	    	}
	      			}
				});
			}
		});
		btnBar.add(btnAllApp);
//		layoutContainer12.add(btnAllApp);
		
		
		lcSchCol2.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.64)); 	// 부서
		lcSchCol2.add(btnBar, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.36)); 				// 버튼
//		lcSchCol2.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));  	// 선택자료적용			    
//		lcSchCol2.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));  	// 전체적용
		
		fieldSet_2.add(lcSchCol2);
		
		fldstNewFieldset_1.add(payrModiListInfo(), new FormData("100%"));
		fldstNewFieldset_1.add( fieldSet_2);
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);
	 
		cpYeta1100.add(layoutContainer);
		
		//cpYeta1100.add(fieldSet_2);
		
		
		
		
		
	}
	  
	private LayoutContainer payrModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 260);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		yetaP110002GridPanel = new MSFGridPanel(yetaP110002def, false, false, false, false);
		yetaP110002GridPanel.setHeaderVisible(false);
		yetaP110002GridPanel.setBodyBorder(false);
		yetaP110002GridPanel.setBorders(true);
		yetaP110002GridPanel.getBottomComponent().setVisible(false);
		// payr0307GridPanel.setSize(600, 145);
		
        final Grid<BaseModel> grid = yetaP110002GridPanel.getMsfGrid().getGrid();
        final ColumnModel columnModel =  grid.getColumnModel();
        final List<ColumnConfig> columnConfigs = columnModel.getColumns();
        final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
        check.setAlignment(Style.HorizontalAlignment.CENTER);		            
        check.setEditor(columnConfigs.get(0).getEditor());
        columnConfigs.set(0, check);

        check.setRenderer(columnConfigs.get(0).getRenderer());  
        grid.addPlugin(check);
        grid.getView().setForceFit(true);	
        
        
        
        //툴바메뉴
        ToolBar bottomToolbar = new ToolBar();  
        bottomToolbar.add(new FillToolItem());
        //====================================================
        btnSelected = new Button("저 장");
        btnSelected.setIcon(MSFMainApp.ICONS.save16());
        btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   
        	
        	public void componentSelected(ButtonEvent ce) {  
        		
        		final Tracker tracker = new Tracker();
				tracker.setStatus(false);
				
				Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO(); 
        		final List<Ye16Ta2000DTO> listYeta2000Dto = new ArrayList<Ye16Ta2000DTO>();
        		
        		Iterator<Record> iterRecords = yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
    			
        		
        		while (iterRecords.hasNext()) {
        			
        			Record recData = (Record) iterRecords.next(); 
    				BaseModel bmMapModel = (BaseModel)recData.getModel();
        			
        			yeta2000Dto = new Ye16Ta2000DTO(); 
        			
        			yeta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));	 		/** column 사업장코드 : dpobCd */
        			yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));		/** column 연말정산귀속년도 : edacRvyy */
        			yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));		/** column 정산구분코드 : settGbcd */
        			yeta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
        			yeta2000Dto.setYetaDpcd(MSFSharedUtils.allowNulls(bmMapModel.get("yetaDpcd$deptCd")));
        			
        			listYeta2000Dto.add(yeta2000Dto);
        	
        		}
        		
//        		Window.alert("수정한 데이터 사이즈 " + listYeta2000Dto.size());
        		
        		if(listYeta2000Dto.size() <= 0) {
        			Window.alert("수정할 데이터가 없습니다.");
        			return;
        		}
        		
        		
        		MessageBox.confirm("저장", "수정된 원천신고부서대상자의 부서정보를 수정 하시겠습니까?",new Listener<MessageBoxEvent>(){
        			@Override
        			public void handleEvent(MessageBoxEvent be) {
        				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        					saveYeta2000(listYeta2000Dto);
        	   	    	}
        			}
        		});
			}
		});
        bottomToolbar.add(btnSelected);
        bottomToolbar.add(new SeparatorMenuItem());
        
	    // ================전체해제버튼=========================
        btnUnUsed = new Button("해 제");
        btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {  
            	
            	  int  lsCnt = yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getCount();
            	  
            	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
            		  
            		  yetaP110002GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
            		  yetaP110002GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
            		   
            	  } 
            	  yetaP110002GridPanel.getMsfGrid().getGrid().getView().refresh(true);
            }  
        });

        bottomToolbar.add(btnUnUsed);
        bottomToolbar.add(new SeparatorMenuItem());
        //====================================================	

        Button refresh = new Button();
        refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
        refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {  
            	reload();              	
            }  
        });		            
        bottomToolbar.add(refresh);
        
        //툴바 넣어주는것
        yetaP110002GridPanel.setBottomComponent(bottomToolbar);
        
		

		cp01.add(yetaP110002GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
	  
	  
		   
	public void reload() {
		// TODO Auto-generated method stub
		
		// 그리드 초기화
		yetaP110002GridPanel.getMsfGrid().clearData();
		
		// 원천신고부서 초기화
		formInit();
		
		IColumnFilter filters = null;
		yetaP110002GridPanel.getTableDef().setTableColumnFilters(filters);
		
		yetaP110002GridPanel.getTableDef().addColumnFilter("edacRvyy", srhClutYr.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		yetaP110002GridPanel.getTableDef().addColumnFilter("settGbcd", clutSeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
				 
		yetaP110002GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", payrMangDeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaP110002GridPanel.getTableDef().addColumnFilter("emymtDivCd", emymtDivCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 		
		
		
		yetaP110002GridPanel.getTableDef().addColumnFilter("deptCd", deptCd.getValue() , SimpleColumnFilter.OPERATOR_EQUALS);
		yetaP110002GridPanel.getTableDef().addColumnFilter("typOccuCd", typOccuCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaP110002GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", dtilOccuInttnCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		yetaP110002GridPanel.getTableDef().addColumnFilter("businCd", businCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		yetaP110002GridPanel.getTableDef().addColumnFilter("hanNm", srhHanNm.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		yetaP110002GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaP110002GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
		
		
		yetaP110002GridPanel.getTableDef().addColumnFilter("yetaDpcd", MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd"), SimpleColumnFilter.OPERATOR_EQUALS);
		yetaP110002GridPanel.getTableDef().addColumnFilter("settGbcd", clutSeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
		
		yetaP110002GridPanel.reload();

	}
			
	// 폼초기화
	private void formInit() {

//		creYetaDpcd.setValue(new BaseModel()); 			// 원천신고부서
		reprName.setValue(""); 							// 대표자(성명)
		busoprRgstnum.setValue(""); 					// 사업자등록번호
		resuNumb.setValue(""); 							// 주민등록번호
		corpNum.setValue(""); 							// 법인번호
		corpFmnmNm.setValue(""); 						// 법인명
		incmPost.setValue(""); 							// 소재지주소_우편번호
		incmAddr.setValue(""); 							// 소재지주소_기본주소
		incmAdtl.setValue(""); 							// 소재지주소_상세주소
		txOffcCd.setValue("142"); 						// 관할세무서코드
		pentrSeptCd.setValue("3"); 						// 제출자구분
		txDeptyMangeNum.setValue(""); 					// 세무대리인번호
		idHMTXId.setValue(""); 							// 홈텍스ID
		txPgmCd.setValue("9000"); 						// 세무프로그램코드

		pernChrgDeptNm.setValue(""); 					// 담당부서명
		pernChrgPhnNum.setValue(""); 					// 담당자전화번호
		pernChrgNm.setValue(""); 						// 담당자성명

	}
	
			    
   	
	@Override
	public void bind(final ModelData model) {
		
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				
				srhClutYr.setValue(clutYr.getValue());						// 정산년
				srhPayrMangDeptNm.setValue(payrMangDeptNm.getValue());		// 단위기관
				srhEmymtDivNm.setValue(emymtDivNm.getValue());				// 고용구분
				srhRepbtyBusinDivNm.setValue(repbtyBusinDivNm.getValue());	// 호봉제구분코드
				srhClutSeptNm.setValue(clutSeptNm.getValue());				// 정산구분	
				srhDeptNm.setValue(deptNm.getValue());						// 부서	
				srhTypOccuNm.setValue(typOccuNm.getValue());				// 직종
				srhDtilOccuInttnNm.setValue(dtilOccuInttnNm.getValue());	// 직종세
				srhBusinNm.setValue(businNm.getValue());					// 사업
				srhHanNm.setValue(hanNm.getValue());						// 성명
				srhResnRegnNum.setValue(resnRegnNum.getValue());			// 주민번호
				
				reload();
//				creEdacRvyy.setValue(lscreClutYrStore.findModel("year","2016"));
			}
		});
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}
	
	
	private void saveYeta2000(List<Ye16Ta2000DTO> listYeta2000Dto) {
		
		yetaP110002Service.saveYeta2000_YetaDpcd(listYeta2000Dto , new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
					MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta2000_YetaDpcd : " + caught), null);
			}
			public void onSuccess(Integer result) { 
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "원천신고부서 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					
					// TODO 콤보 선택시 사업자번호 스토어 
					lsBusoprRgstnum.removeAll();
					creYetaDpcd.setStore(new ListStore<BaseModel>());
					creYetaDpcd.setValue(new BaseModel());
					
					ye16Ta1005Dto = new Ye16Ta1005DTO();
					ye16Ta1005Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
					ye16Ta1005Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());    /** column 부서코드 : deptCd */
					lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdList(ye16Ta1005Dto);
					
					creYetaDpcd.setStore(lsYetaDpcd);
					
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "원천신고부서 적용 처리가 완료되었습니다.", null);
					reload();
				}
			}
		});
	}
	
	
	private void saveYe161005() {
		
		
		Ye16Ta1005DTO ye161005Dto = new Ye16Ta1005DTO();
		
		ye161005Dto.setDpobCd(dpobCd.getValue());    														/** column 사업장코드 : dpobCd */
		ye161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd"));	/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
		ye161005Dto.setHhrkWhdgRegrstDeptCd("");    														/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
		ye161005Dto.setTxOffcCd(txOffcCd.getValue());    													/** column A3_세무서코드 : txOffcCd */
		ye161005Dto.setPentrSeptCd(pentrSeptCd.getValue());    												/** column A5_제출자구분 : pentrSeptCd */
		ye161005Dto.setTxDeptyMangeNum(txDeptyMangeNum.getValue());    										/** column A6_세무대리인관리번호 : txDeptyMangeNum */
		ye161005Dto.setHmtxId(idHMTXId.getValue());    														/** column A7_홈텍스ID : hmtxId */
		ye161005Dto.setTxPgmCd(txPgmCd.getValue());    														/** column A8_세무프로그램코드 : txPgmCd */
		ye161005Dto.setBusoprRgstnum(busoprRgstnum.getValue().replace("-", ""));    						/** column A9_사업자등록번호 : busoprRgstnum */
		ye161005Dto.setCorpFmnmNm(corpFmnmNm.getValue());    												/** column A10_법인_상호명 : corpFmnmNm */
		ye161005Dto.setPernChrgDeptNm(pernChrgDeptNm.getValue());    										/** column A11_담당자부서 : pernChrgDeptNm */
		ye161005Dto.setPernChrgNm(pernChrgNm.getValue());    												/** column A12_담당자성명 : pernChrgNm */
		ye161005Dto.setPernChrgPhnNum(pernChrgPhnNum.getValue());    										/** column A13_담당자전화번호 : pernChrgPhnNum */
		ye161005Dto.setUseHanCd("101");    																	/** column A15_사용한글코드 : useHanCd */
		ye161005Dto.setSumtTgtPridCd("1");    																/** column B16_제출대상기간코드 : sumtTgtPridCd */
		ye161005Dto.setCorpNum(corpNum.getValue());    														/** column 법인번호 : corpNum */
		ye161005Dto.setIncmPost(incmPost.getValue());    													/** column 소득신고의무자우편번호 : incmPost */
		ye161005Dto.setIncmAddr(incmAddr.getValue());    													/** column 소득신고의무자기본주소 : incmAddr */
		ye161005Dto.setIncmAdtl(incmAdtl.getValue());    													/** column 소득신고의무자상세주소 : incmAdtl */
//		ye161005Dto.setKybdr(ye161005Dto.getKybdr());    /** column 입력자 : kybdr */
//		ye161005Dto.setInptDt(ye161005Dto.getInptDt());    /** column 입력일자 : inptDt */
//		ye161005Dto.setInptAddr(ye161005Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		ye161005Dto.setIsmt(ye161005Dto.getIsmt());    /** column 수정자 : ismt */
//		ye161005Dto.setRevnDt(ye161005Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		ye161005Dto.setRevnAddr(ye161005Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
		ye161005Dto.setReprName(reprName.getValue());    													/** column 대표자성명 : reprName */
		ye161005Dto.setResuNumb(resuNumb.getValue());    													/** column 주민등록번호 : resuNumb */
               
		
		if("".equals(ye161005Dto.getWhdgTxRegrstDeptCd()) || ye161005Dto.getWhdgTxRegrstDeptCd() == null) {
			Window.alert("원천신고부서를 선택해주세요.");
			return;
		}else if("".equals(ye161005Dto.getBusoprRgstnum()) || ye161005Dto.getBusoprRgstnum() == null) {
			Window.alert("사업자등록번호를 입력해주세요.");
			return;
			
		//}
//		else if("".equals(ye161005Dto.getCorpNum()) || ye161005Dto.getCorpNum() == null) {
//			Window.alert("법인등록번호를 입력해주세요.");
//			return;
//			
//		}
	//	else if("".equals(ye161005Dto.getCorpFmnmNm()) || ye161005Dto.getCorpFmnmNm() == null) {
	//		Window.alert("법인명을 입력해주세요.");
	//		return;
			
		}else if(MSFSharedUtils.paramNull(ye161005Dto.getPentrSeptCd()) ||  ye161005Dto.getPentrSeptCd().length() > 1) {
			Window.alert("제출자구분은 1자리 입니다.");
			return;
		}else if(MSFSharedUtils.paramNull(ye161005Dto.getTxPgmCd()) ||  ye161005Dto.getTxPgmCd().length() > 4) {
			Window.alert("세무프로그램코드는 4자리 입니다.");
			return;
		}else if(MSFSharedUtils.paramNull(ye161005Dto.getTxOffcCd()) ||  ye161005Dto.getTxOffcCd().length() > 3) {
			Window.alert("관할세무서는 3자리 입니다.");
			return;
	//	}else if(MSFSharedUtils.paramNull(ye161005Dto.getTxDeptyMangeNum()) ||  ye161005Dto.getTxDeptyMangeNum().length() > 6) {
	//		Window.alert("세무대리인번호는 6자리 입니다.");
	//		return;
		}
		
		
		yetaP110002Service.saveYeta161005(ye161005Dto , actionDatabase ,  new AsyncCallback<Integer>() {
			@Override
               public void onFailure(Throwable caught) {
            	   MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                       MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta161005 : " + caught), null);
               }
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
           		   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + " 처리가 완료되지 않았습니다. 데이타를 확인해주세요.", null);
           	   } else if(result == 3) {
           		 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "해당 원천신고부서에 이미 등록된 사업자번호가 존재합니다. 데이터를 확인해주세요.", null);
           	   }else {
           		   
           		//creYetaDpcd.setValue(lsYetaDpcd.findModel("yetaDpcd", MSFSharedUtils.allowNulls(yetaDpcd.getValue())));
           		   
           		   readFlag = true;
           		   // TODO 콤보 선택시 사업자번호 스토어 
					lsBusoprRgstnum.removeAll();
					creBusoprRgstnum.setStore(new ListStore<BaseModel>());
					creBusoprRgstnum.setValue(new BaseModel());
					
					
					Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
					yeta161005Dto.setDpobCd(dpobCd.getValue());
					yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(creYetaDpcd, "yetaDpcd"));
					
					yetaP110002Service.getYeta2000busoprRgstnumList(yeta161005Dto, new AsyncCallback<List<BaseModel>>() {
						@Override
						public void onSuccess(List<BaseModel> result) {
							
							if (!result.isEmpty()) {
								readFlag = false;
								lsBusoprRgstnum.add(result);
								creBusoprRgstnum.setStore(lsBusoprRgstnum); 
								creBusoprRgstnum.setValue(lsBusoprRgstnum.getAt(0));
//								creBusoprRgstnum.setValue(creBusoprRgstnum.getStore().findModel("busoprRgstnum", MSFSharedUtils.allowNulls(busoprRgstnum.getValue())));
								//creBusoprRgstnum.fireEvent(Events.SelectionChange); busoprRgstnum
								//creBusoprRgstnum.setValue(lsBusoprRgstnum.findModel("busoprRgstnum", MSFSharedUtils.allowNulls(busoprRgstnum.getValue())));
								//Window.alert(MSFSharedUtils.allowNulls(busoprRgstnum.getValue()));
							} else {
								//초기화 인서트 모드 
								formInit();
								actionDatabase = ActionDatabase.INSERT;
							}
						}
							
						@Override
						public void onFailure(Throwable caught) {
							MessageBox.alert("", "사업자번호 리스트를 가져오지 못했습니다. </br> 관리자에게 문의해주세요.", null);
						}
					});
                 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + " 처리가 완료되었습니다.", null);
                 
                 
//                 Window.alert("초기화 ");
                 //lsYetaDpcd.removeAll();
                 //creYetaDpcd.setStore(new ListStore<BaseModel>());
                 //creYetaDpcd.setValue(new BaseModel());
                 
           	   } 
				
				actionDatabase = ActionDatabase.UPDATE;
			}
		});
		
	}
	
	
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
	
	private YetaP110002 getThis() {
		return this;
	}
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	}  
	
	
	
	
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// 부서
	private void fnPopupCommP150(String deptNmStr) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨. 
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpNonPrgmCom0145Form(deptNmStr);  //부서
           
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
          
		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				
				if (!"".equals(mapModel.get("deptCd"))) {  
					creDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
					creDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
				}
			}
		});
	}	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
			  	

}
