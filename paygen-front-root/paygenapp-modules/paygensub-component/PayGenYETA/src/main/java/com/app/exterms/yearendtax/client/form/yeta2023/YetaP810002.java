/**
 * 원천징수부서등록 및 대상자 원천징수부서맵핑 
 */
package com.app.exterms.yearendtax.client.form.yeta2023;
  

import java.util.ArrayList;
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
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2023.Ye161020Def;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaP810002Service;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaP810002ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
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
public  class YetaP810002   extends MSFFormPanel {  

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
 
	private ContentPanel cpYeta8100;

	private Ye161020Def ye161020Def = new Ye161020Def("YetaP810002");
	private MSFGridPanel YetaP810002GridPanel;
	

	private Button btnAllUsed;
	private Button btnUnUsed;
	private Button btnOnUsed;
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
	
	
	private ComboBox<BaseModel> srhUtDpobCd; 				// 원천신고부서
	private CheckBox utDpobChk; // 부서명
	
	private HiddenField<String> systemkey; 					// 시스템키
	

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 연말정산대상자-생성 폼 시작 --------------
	private MSFTextField creUtDpobCd; 					// 부서명
	private MSFTextField creUtDpobNm; 					// 부서명
	private HiddenField<String> hhrkWhdgRegrstDeptCd;
	private Button btnDeptCd;
	// -------------- 연말정산대상자-생성 폼 종료 --------------
	
	// -------------- 전자신고 기본정보 폼 시작 --------------

	
	
	
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
	private MSFTextField hmtxId; 							// 홈텍스 
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
 
	private YetaP810002ServiceAsync yetaP810002Service = YetaP810002Service.Util.getInstance();
	
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
	public YetaP810002(ActionDatabase actionDatabase, final MSFPanel caller) {

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

		cpYeta8100 = new ContentPanel();

		createSearchForm(); 	// 검색필드를 적용
		createStandardForm(); 	// 기본정보필드

		cpYeta8100.setBodyBorder(false);
		cpYeta8100.setBorders(false);
		cpYeta8100.setHeaderVisible(false);
		//cpYeta8100.setSize("890px", "640px");
		cpYeta8100.setSize("1010px", "740px");

		this.add(cpYeta8100);
		formBinding = new FormBinding(this, true);

		//this.setSize("910px", "710px");
		this.setSize("1030px", "800px");
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
	private void createPayrP710001Form() {

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
		// --------------------정산년도 불러 오는 함수------------------------------------------------
		
		
		actionDatabase = ActionDatabase.UPDATE;
		 
		dpobCd = new HiddenField<String>();
		dpobCd.setName("dpobCd");
		cpYeta8100.add(dpobCd);
		 
		clutYr = new HiddenField<String>();
		clutYr.setName("clutYr");
		cpYeta8100.add(clutYr);
		
		payrMangDeptCd = new HiddenField<String>();
		payrMangDeptCd.setName("payrMangDeptCd");
		cpYeta8100.add(payrMangDeptCd);

		payrMangDeptNm = new HiddenField<String>();
		payrMangDeptNm.setName("payrMangDeptNm");
		cpYeta8100.add(payrMangDeptNm);
		 		 
		 
		emymtDivCd = new HiddenField<String>();
		emymtDivCd.setName("emymtDivCd");
		cpYeta8100.add(emymtDivCd);		 
		 
		 
		emymtDivNm = new HiddenField<String>();
		emymtDivNm.setName("emymtDivNm");
		cpYeta8100.add(emymtDivNm);		 
		
		
		repbtyBusinDivCd = new HiddenField<String>();
		repbtyBusinDivCd.setName("repbtyBusinDivCd");
		cpYeta8100.add(repbtyBusinDivCd);		 
		 		 
		
		repbtyBusinDivNm = new HiddenField<String>();
		repbtyBusinDivNm.setName("repbtyBusinDivNm");
		cpYeta8100.add(repbtyBusinDivNm);		 
		 		 
		clutSeptCd = new HiddenField<String>();
		clutSeptCd.setName("clutSeptCd");
		cpYeta8100.add(clutSeptCd);		
		
		clutSeptNm = new HiddenField<String>();
		clutSeptNm.setName("clutSeptNm");
		cpYeta8100.add(clutSeptNm);		
		
		
		deptCd = new HiddenField<String>();
		deptCd.setName("deptCd");
		cpYeta8100.add(deptCd);	
		
		
		deptNm = new HiddenField<String>();
		deptNm.setName("deptNm");
		cpYeta8100.add(deptNm);	
		
		
		deptGpCd = new HiddenField<String>();
		deptGpCd.setName("deptGpCd");
		cpYeta8100.add(deptGpCd);	
		
		deptGpNm = new HiddenField<String>();
		deptGpNm.setName("deptGpNm");
		cpYeta8100.add(deptGpNm);	
		
		typOccuCd = new HiddenField<String>();
		typOccuCd.setName("typOccuCd");
		cpYeta8100.add(typOccuCd);		
		
		
		typOccuNm = new HiddenField<String>();
		typOccuNm.setName("typOccuNm");
		cpYeta8100.add(typOccuNm);		
		
		
		dtilOccuInttnCd = new HiddenField<String>();
		dtilOccuInttnCd.setName("dtilOccuInttnCd");
		cpYeta8100.add(dtilOccuInttnCd);			
		
		
		dtilOccuInttnNm = new HiddenField<String>();
		dtilOccuInttnNm.setName("dtilOccuInttnNm");
		cpYeta8100.add(dtilOccuInttnNm);		
		
		
		businCd = new HiddenField<String>();
		businCd.setName("businCd");
		cpYeta8100.add(businCd);
		
		
		businNm = new HiddenField<String>();
		businNm.setName("businNm");
		cpYeta8100.add(businNm);	
		
		
		hanNm = new HiddenField<String>();
		hanNm.setName("hanNm");
		cpYeta8100.add(hanNm);	
		
		resnRegnNum = new HiddenField<String>();
		resnRegnNum.setName("resnRegnNum");
		cpYeta8100.add(resnRegnNum);		
		
		systemkey = new HiddenField<String>();
		systemkey.setName("systemkey");
		cpYeta8100.add(systemkey);	
		
		yetaDpcd = new HiddenField<String>();
		yetaDpcd.setName("yetaDpcd");
		cpYeta8100.add(systemkey);	
		
		busoprRgstnumStr = new HiddenField<String>();
		busoprRgstnumStr.setName("busoprRgstnumStr");
		cpYeta8100.add(systemkey);	
		
		
		
		
		
		
		 
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
		frmlytSch.setLabelWidth(80);
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


		LayoutContainer layoutContainer7 = new LayoutContainer();

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
		frmlytSch.setLabelWidth(80);
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

		layoutContainer1_3.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer1_3.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer1_3.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
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
//		lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 

		cpYeta8100.add(fieldSet);
		
		FieldSet fieldSet_2 = new FieldSet();
		fieldSet_2.setHeadingHtml("원천신고부서선택");
		
		LayoutContainer lcSchCol2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer10 = new LayoutContainer();
		layoutContainer10.setLayout(new ColumnLayout());
		
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(100);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
        creUtDpobNm = new MSFTextField(); 
        creUtDpobNm.setName("creUtDpobNm");
        creUtDpobNm.setFieldLabel("원천신고부서"); 
        //currAffnDeptNm.setLabelSeparator("");
        creUtDpobNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		
        		if (MSFSharedUtils.allowNulls(creUtDpobNm.getValue()).trim().equals("")) {
        			creUtDpobCd.setValue("");
        			creUtDpobNm.setValue("");
	    		}
	    		if (MSFSharedUtils.paramNull(creUtDpobNm.getValue())) {
	    			creUtDpobCd.setValue("");
	    			creUtDpobNm.setValue("");
	    		}  
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			if (MSFSharedUtils.allowNulls(creUtDpobNm.getValue()).trim().equals("")) {
        				creUtDpobCd.setValue("");
        				creUtDpobNm.setValue("");
        			}
        			fnPopupPrgmComPBass120001(creUtDpobNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
        lcDeptNm.add(creUtDpobNm, new FormData("100%"));  
        
        
        LayoutContainer lcBtnDeptCd = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        lcBtnDeptCd.setLayout(frmlytSch);
          
        btnDeptCd = new Button();
        btnDeptCd.setIcon(MSFMainApp.ICONS.search()); 
        btnDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	 public void handleEvent(ButtonEvent e) { 
        		 if (MSFSharedUtils.allowNulls(creUtDpobNm.getValue()).trim().equals("")) {
        			 creUtDpobNm.setValue("");
        		 }
        		 fnPopupPrgmComPBass120001(creUtDpobNm.getValue()); 
        	 }
        });
        lcBtnDeptCd.add(btnDeptCd);
        
        
        LayoutContainer lcDeptCd = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(0);
        lcDeptCd.setLayout(frmlytSch);
        
        creUtDpobCd = new MSFTextField(); 
        creUtDpobCd.setLabelSeparator("");
        creUtDpobCd.setName("creUtDpobCd");
        creUtDpobCd.setReadOnly(true);
        
        lcDeptCd.add(creUtDpobCd, new FormData("100%"));
            
        layoutContainer10.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        layoutContainer10.add(lcBtnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
        layoutContainer10.add(lcDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
        
        
		LayoutContainer layoutContainer_16_2 = new LayoutContainer(); 
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setLabelWidth(50);
		layoutContainer_16_2.setLayout(frmlytSch);

		utDpobChk = new CheckBox(); 
		utDpobChk.setLabelSeparator("미선택");
		utDpobChk.setName("utDpobChk");  
		layoutContainer_16_2.add(utDpobChk, new FormData("100%"));
        
        
        ButtonBar btnBar = new ButtonBar();
        btnBar.setAlignment(HorizontalAlignment.RIGHT);
        
        
		Button btnSrh = new Button("검색");
		btnSrh.setWidth("50");
		btnSrh.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(creUtDpobCd.getValue() != null && !"".equals(creUtDpobCd.getValue()) ) {
					Ye161005DTO ye161005Dto = new Ye161005DTO();
					ye161005Dto = new Ye161005DTO();
					ye161005Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    				/** column 사업장코드 : dpobCd */
					ye161005Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(srhClutYr.getValue()));    			/** column null : yrtxBlggYr */
					ye161005Dto.setClutSeptCd(MSFSharedUtils.allowNulls(clutSeptCd.getValue()));    		/** column null : clutSeptCd */
					ye161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(creUtDpobCd.getValue()));   /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
					 
					yetaP810002Service.getYe161005Data(ye161005Dto , new AsyncCallback<Ye161005DTO>() {
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYe161005Data : " + caught), null);
						}
						
						public void onSuccess(Ye161005DTO result) { 
							
							reprName.setValue(result.getReprName()); 							// 대표자(성명) 
							busoprRgstnum.setValue(result.getBusoprRgstnum())	; 					// 사업자등록번호 
							resuNumb.setValue(result.getResuNumb())			; 							// 주민등록번호 
							corpNum.setValue(result.getCorpNum())			; 							// 법인번호 
							corpFmnmNm.setValue(result.getCorpFmnmNm())		; 						// 법인명 
							incmPost.setValue(result.getIncmPost())		; 							// 소재지주소_우편번호
							incmAddr.setValue(result.getIncmAddr())		; 							// 소재지주소_기본주소
							incmAdtl.setValue(result.getIncmAdtl())		; 							// 소재지주소_상세주소
							txOffcCd.setValue(result.getTxOffcCd())		; 							// 관할세무서코드 
							pentrSeptCd.setValue(result.getPentrSeptCd())		; 						// 제출자구분 
							txDeptyMangeNum.setValue(result.getTxDeptyMangeNum())		; 					// 세무대리인번호 
							hmtxId.setValue(result.getHmtxId())		; 							// 홈텍스 
							txPgmCd.setValue(result.getTxPgmCd())				; 							// 세무프로그램코드 

							pernChrgDeptNm.setValue(result.getPernChrgDeptNm())		; 					// 담당부서명 
							pernChrgPhnNum.setValue(result.getPernChrgPhnNum())		; 					// 담당자전화번호 
							pernChrgNm.setValue(result.getPernChrgNm())		; 						// 담당자성명 
							
						}
					});
					
				}
				reload();
				
			}
		});
		btnBar.add(btnSrh);
        
		
		Button btnNew = new Button("초기화");
		btnNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				creUtDpobCd.setValue("");
				creUtDpobNm.setValue("");
				utDpobChk.setValue(false);
				
				// 원천신고부서폼 초기화
				formInit();
				actionDatabase = ActionDatabase.INSERT;
			}
		});
		btnBar.add(btnNew);
        
		
//		Button btnAllOn = new Button("전체선택");
//		btnAllOn.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				
//				int  lsCnt = YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getCount();
//          	  
//          	  	for(int iCnt=0;iCnt < lsCnt;iCnt++) {
//          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
//          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
//          	  	} 
//          	  	YetaP810002GridPanel.getMsfGrid().getGrid().getView().refresh(true);
//          	  	
//			}
//		});
//		btnBar.add(btnAllOn);
//		
//		
//		Button btnAllOff = new Button("전체해제");
//		btnAllOff.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				
//				int  lsCnt = YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getCount();
//          	  
//          	  	for(int iCnt=0;iCnt < lsCnt;iCnt++) {
//          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
//          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
//          	  	} 
//          	  	YetaP810002GridPanel.getMsfGrid().getGrid().getView().refresh(true);
//          	  	
//			}
//		});
//		btnBar.add(btnAllOff);		
		
		
		
		lcSchCol2.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 	// 부서
        lcSchCol2.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1)); // 미선택
		lcSchCol2.add(btnBar, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 				// 버튼
		
		fieldSet_2.add(lcSchCol2);
		cpYeta8100.add(fieldSet_2);
		
		
		FieldSet fieldSet_3 = new FieldSet();
		fieldSet_3.setHeadingHtml("원천신고부서내역");
		fieldSet_3.setCollapsible(false);

		
		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		fieldSet_3.add(lcSchCol3, new FormData("100%"));


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
		busoprRgstnum.setReadOnly(true);
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

		hmtxId = new MSFTextField();
		hmtxId.setName("hmtxId");
		hmtxId.setFieldLabel("홈텍스 ID");
		hmtxId.setSelectOnFocus(true);

		layoutContainer25.add(hmtxId, new FormData("100%"));
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
		
		Button btnSave = new Button("저장");
		btnSave.setWidth(70);
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				MessageBox.confirm("저장", "해당 원천신고부서 내역을 수정 하시겠습니까?",new Listener<MessageBoxEvent>(){
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
//		btnBar2.add(btnDel);
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
		
		cpYeta8100.add(fieldSet_3);

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
 
		fldstNewFieldset_1.add(payrModiListInfo(), new FormData("100%"));
		layoutContainer.add(layoutContainer_2);
	 
		cpYeta8100.add(layoutContainer);
		
		
	}
	 
	
	private LayoutContainer payrModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		//cp01.setSize(870, 300);
		cp01.setSize(990, 300);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		YetaP810002GridPanel = new MSFGridPanel(ye161020Def, false, false, false, false);
		YetaP810002GridPanel.setHeaderVisible(false);
		YetaP810002GridPanel.setBodyBorder(false);
		YetaP810002GridPanel.setBorders(true);
		YetaP810002GridPanel.getBottomComponent().setVisible(true);

		
        final Grid<BaseModel> grid = YetaP810002GridPanel.getMsfGrid().getGrid();
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
        Button btnAllOn = new Button("전체선택");
        btnAllOn.setIcon(MSFMainApp.ICONS.save16());
        btnAllOn.addSelectionListener(new SelectionListener<ButtonEvent>() {   
        	
        	public void componentSelected(ButtonEvent ce) {  
        		
        		int  lsCnt = YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getCount();
            	  
          	  	for(int iCnt=0;iCnt < lsCnt;iCnt++) {
          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
          	  	} 
          	  	YetaP810002GridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});
        bottomToolbar.add(btnAllOn);
        bottomToolbar.add(new SeparatorMenuItem());
        
        //====================================================
        Button btnAllOff = new Button("전체해제");
        btnAllOff.setIcon(MSFMainApp.ICONS.save16());
        btnAllOff.addSelectionListener(new SelectionListener<ButtonEvent>() {   
        	
        	public void componentSelected(ButtonEvent ce) {  
        		
        		int  lsCnt = YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getCount();
            	  
          	  	for(int iCnt=0;iCnt < lsCnt;iCnt++) {
          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
          	  		YetaP810002GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
          	  	} 
          	  	YetaP810002GridPanel.getMsfGrid().getGrid().getView().refresh(true);
			}
		});
        bottomToolbar.add(btnAllOff);
        bottomToolbar.add(new SeparatorMenuItem());
        
        
        //====================================================
        btnOnUsed = new Button("반영");
        btnOnUsed.setIcon(MSFMainApp.ICONS.save16());
        btnOnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {   
        	
        	public void componentSelected(ButtonEvent ce) {  
        		
        		if("".equals(creUtDpobCd.getValue()) || creUtDpobCd.getValue() == null) {
        			MessageBox.alert("경고", "원천신고부서를 선택해 주세요.", null);
        			
        		}else {
        			
        			
        			final Tracker tracker = new Tracker();
    				tracker.setStatus(false);

    				Ye161010DTO ye161010Dto = new Ye161010DTO(); 
            		final List<Ye161010DTO> lsYe161010Dto = new ArrayList<Ye161010DTO>();
            		
            		Iterator<BaseModel> itBm  = YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
        			
					List<Record>  lsRec  = new ArrayList<Record>();
				

					while (itBm.hasNext()) {

						Record rec = new Record(itBm.next());
						lsRec.add(rec);

					}

					setListRecord(lsRec.iterator());
            		
					if (MSFSharedUtils.paramNotNull(records)) {  
						
						while (records.hasNext()) {
	            			
	            			Record recData = (Record) records.next(); 
	        				BaseModel bmMapModel = (BaseModel)recData.getModel();
	        				
	        				// select에 null값이 들어가있으므로 널포인트에러뜸.
	        				// 그래서 null인것은 false로 강제변환시킴.
	        				if ((Boolean) bmMapModel.get("select") == null) {
	        					bmMapModel.set("select", false);
	        				}

	        				if ((Boolean) bmMapModel.get("select")) {
	        					
	        					ye161010Dto = new Ye161010DTO(); 
	            				
	            				ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
	            				ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    	/** column 귀속연도 : yrtxBlggYr */
	            				ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    	/** column 연말정산구분코드 : clutSeptCd */
	            				ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	            				ye161010Dto.setUtDpobCd(creUtDpobCd.getValue());    									/** column 단위사업장코드 : utDpobCd */
	            				
	                			
	            				lsYe161010Dto.add(ye161010Dto);
	        					
	        				}
	            	
	            		}
	            		
	            		
	            		MessageBox.confirm("저장", "원천신고부서대상자내역의 원천신고부서를 수정 하시겠습니까?",new Listener<MessageBoxEvent>(){
	            			@Override
	            			public void handleEvent(MessageBoxEvent be) {
	            				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	            					saveYeta161010(lsYe161010Dto);
	            	   	    	}
	            			}
	            		});
						
					}else {
						Window.alert("수정할 데이터가 없습니다.");
	        			return;
					}
        			
        		}
			}
		});
        bottomToolbar.add(btnOnUsed);
        bottomToolbar.add(new SeparatorMenuItem());
        
	    // ================전체해제버튼=========================
        btnUnUsed = new Button("미반영");
        btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {  
            	
            	final Tracker tracker = new Tracker();
				tracker.setStatus(false);

				Ye161010DTO ye161010Dto = new Ye161010DTO(); 
        		final List<Ye161010DTO> lsYe161010Dto = new ArrayList<Ye161010DTO>();
        		
        		Iterator<BaseModel> itBm  = YetaP810002GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
    			
				List<Record>  lsRec  = new ArrayList<Record>();
			

				while (itBm.hasNext()) {

					Record rec = new Record(itBm.next());
					lsRec.add(rec);

				}

				setListRecord(lsRec.iterator());
        		
				if (MSFSharedUtils.paramNotNull(records)) { 
					
					while (records.hasNext()) {
	        			
	        			Record recData = (Record) records.next(); 
	    				BaseModel bmMapModel = (BaseModel)recData.getModel();
	    				
	    				// select에 null값이 들어가있으므로 널포인트에러뜸.
	    				// 그래서 null인것은 false로 강제변환시킴.
	    				if ((Boolean) bmMapModel.get("select") == null) {
	    					bmMapModel.set("select", false);
	    				}

	    				if ((Boolean) bmMapModel.get("select")) {
	    					
	    					ye161010Dto = new Ye161010DTO(); 
	        				
	        				ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
	        				ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    	/** column 귀속연도 : yrtxBlggYr */
	        				ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    	/** column 연말정산구분코드 : clutSeptCd */
	        				ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	        				ye161010Dto.setUtDpobCd("");    														/** column 단위사업장코드 : utDpobCd */
	        				
	            			
	        				lsYe161010Dto.add(ye161010Dto);
	    					
	    				}
	        	
	        		}
					
					MessageBox.confirm("저장", "원천신고부서대상자내역의 원천신고부서를 수정 하시겠습니까?",new Listener<MessageBoxEvent>(){
	        			@Override
	        			public void handleEvent(MessageBoxEvent be) {
	        				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	        					saveYeta161010(lsYe161010Dto);
	        	   	    	}
	        			}
	        		});
					
				}else {
					Window.alert("수정할 데이터가 없습니다.");
        			return;
				}
        		
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
        YetaP810002GridPanel.setBottomComponent(bottomToolbar);
        
		

		cp01.add(YetaP810002GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
	  
	  
		   
	public void reload() {
		// TODO Auto-generated method stub
		
		// 그리드 초기화
		YetaP810002GridPanel.getMsfGrid().clearData();
		
		// 원천신고부서 초기화
		formInit();
		
		
		IColumnFilter filters = null;
		YetaP810002GridPanel.getTableDef().setTableColumnFilters(filters);
		
		YetaP810002GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", srhClutYr.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		YetaP810002GridPanel.getTableDef().addColumnFilter("clutSeptCd", clutSeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
				 
		YetaP810002GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", payrMangDeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		YetaP810002GridPanel.getTableDef().addColumnFilter("emymtDivCd", emymtDivCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 		
		
		
		YetaP810002GridPanel.getTableDef().addColumnFilter("deptCd", deptCd.getValue() , SimpleColumnFilter.OPERATOR_EQUALS);
		YetaP810002GridPanel.getTableDef().addColumnFilter("typOccuCd", typOccuCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		YetaP810002GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", dtilOccuInttnCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		YetaP810002GridPanel.getTableDef().addColumnFilter("businCd", businCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		YetaP810002GridPanel.getTableDef().addColumnFilter("hanNm", srhHanNm.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		YetaP810002GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		YetaP810002GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
		
		
		YetaP810002GridPanel.getTableDef().addColumnFilter("utDpobCd", creUtDpobCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
		YetaP810002GridPanel.getTableDef().addColumnFilter("utDpobChk", utDpobChk.getValue()? "1" : "0", SimpleColumnFilter.OPERATOR_EQUALS);
		
		YetaP810002GridPanel.reload();
	
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
		hmtxId.setValue(""); 							// 홈텍스ID
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
	
	
	private void saveYeta161010(List<Ye161010DTO> lsYe161010Dto) {
		
		yetaP810002Service.saveYetaP810002ToYe161010(lsYe161010Dto , new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
					MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta2000_YetaDpcd : " + caught), null);
			}
			public void onSuccess(Integer result) { 
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "원천신고부서 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					
//					// TODO 콤보 선택시 사업자번호 스토어 
//					lsBusoprRgstnum.removeAll();
//					utDpobCd.setValue("");
//					utDpobNm.setValue("");
//					
//					ye16Ta1005Dto = new Ye16Ta1005DTO();
//					ye16Ta1005Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
//					ye16Ta1005Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());    /** column 부서코드 : deptCd */
//					lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdList(ye16Ta1005Dto);
//					
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "원천신고부서 적용 처리가 완료되었습니다.", null);
					reload();
				}
			}
		});
	}
	
	
	private void saveYe161005() {
		
		Ye161005DTO ye161005Dto = new Ye161005DTO();
		
		ye161005Dto.setDpobCd(dpobCd.getValue());    														/** column 사업장코드 : dpobCd */
		ye161005Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(srhClutYr.getValue()));    						/** column null : yrtxBlggYr */
		ye161005Dto.setClutSeptCd(MSFSharedUtils.allowNulls(clutSeptCd.getValue()));    					/** column null : clutSeptCd */
		ye161005Dto.setWhdgTxRegrstDeptCd(creUtDpobCd.getValue());											/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
		ye161005Dto.setHhrkWhdgRegrstDeptCd("");    														/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
		ye161005Dto.setTxOffcCd(txOffcCd.getValue());    													/** column A3_세무서코드 : txOffcCd */
		ye161005Dto.setPentrSeptCd(pentrSeptCd.getValue());    												/** column A5_제출자구분 : pentrSeptCd */
		ye161005Dto.setTxDeptyMangeNum(txDeptyMangeNum.getValue());    										/** column A6_세무대리인관리번호 : txDeptyMangeNum */
		ye161005Dto.setHmtxId(hmtxId.getValue());    														/** column A7_홈텍스ID : hmtxId */
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
		
		
		yetaP810002Service.saveYetaP810002ToYeta161005(ye161005Dto , actionDatabase ,  new AsyncCallback<Integer>() {
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
           		   
           		   
                 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + " 처리가 완료되었습니다.", null);
                 
                 
           	   } 
				
				actionDatabase = ActionDatabase.UPDATE;
			}
		});
		
	}
	
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
	
	private YetaP810002 getThis() {
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
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();
	               
				if (mapModels != null) { 
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
					
					while (iterRecords.hasNext()) {
						
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						creUtDpobCd.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
						creUtDpobNm.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobNm"))); 
						
					}
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
