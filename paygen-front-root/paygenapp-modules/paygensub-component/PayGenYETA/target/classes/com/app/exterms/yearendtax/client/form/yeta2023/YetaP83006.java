/**
 * 종전근무지등록
 */
package com.app.exterms.yearendtax.client.form.yeta2023;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye160404BM;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye160404DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2023.Ye160404Def;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaP83006Service;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaP83006ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
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
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP83006   extends MSFFormPanel {  

/**
 *##############################O############################################
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
 
	private ContentPanel cpYeta83006;

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 시작} 
	 * #######################################################
	 */

	// 권한 설정 객체
	private static GWTAuthorization gwtAuthorization;
	private static GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */

	// -------------- grid 선언 시작 ---------------
	private MSFGridPanel YetaP83006GridPanel;
	private Ye160404Def YetaP83006ToYe160404Def = new Ye160404Def("YetaP83006"); // 종전근무지내역 그리드 테이블 컬럼 define
	// -------------- grid 선언 종료 ---------------

	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	    
	
    
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
    
	private MSFPanel caller;
	private Boolean reading = false;
	public FormBinding formBinding;

	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	private BaseModel record;
	private Iterator<Record> records;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
	private ButtonBar topYetaBtnBar = new ButtonBar();
	private Button btnYetaNew = new Button(); 		// 신규
	private Button btnYetaDel = new Button(); 		// 삭제
	private Button btnYetaSave = new Button(); 		// 저장

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
	private TextField<String> srhYrtxBlggYr; 		// 년도
	private ComboBox<BaseModel> srhClutSeptCd; 		// 정산구분
	private TextField<String> srhDeptNm; 			// 부서
	private TextField<String> srhHanNm;	 			// 성명
 	
 	private HiddenField<String> systemkey;					/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;						/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;					/** column 정산년도 : yrtxBlggYr */
    private HiddenField<String> clutSeptCd;					/** column 정산구분코드 : clutSeptCd */
    private HiddenField<String> whdgDebrBusoprRgstnum;		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum	 */
    private HiddenField<String> deptNm;  					/**  column 부서명 : deptNm */
	private HiddenField<String>	hanNm;						/**  column 성명 : hanNm */
	
	private HiddenField<String> resnRegnNum;	/** column D7_소득자주민등록번호 : resnRegnNum */
	private HiddenField<String> prcspSeilNum;	/** column D4_종전근무처일련번호 : prcspSeilNum */	
 	// -------------- 검색 조건 종료 --------------
    
	// -------------- 서비스 호출 시작 --------------
	private YetaP83006ServiceAsync yetaP83006Service = YetaP83006Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
    // ---------------- 종전근무지 상세 시작 ---------------- 
	private MSFDateField prcspDutyBgnnDt; 			// 종전근무처근무시간시작일자
	private MSFDateField prcspDutyEndDt; 			// 종전근무처근무시간종료일자
	private MSFDateField prcspReduBgnnDt; 			// 감면 시작 기간
	private MSFDateField prcspReduEndDt; 			// 감면 종료 기간
    private MSFTextField hanNm01;					// 성명   
    private MSFTextField prcspBusoprRgstnum;		// D10_종전근무처사업자등록번호
    private MSFTextField prcspFmnmNm;				// D9_종전근무처법인_상호명
    
    private MSFNumberField prcspPaySum;				// D15_종전근무처급여금액
    private MSFNumberField prcspAllwBnusSum;		// D16_종전근무처상여금액
    private MSFNumberField prcspRcgtnBnusSum;		// D17_종전근무처인정상여금액
    
    private MSFNumberField natPennPrmmSum;			// 국민연금보험료금액    
    private MSFNumberField natPennAraPrmmSum;		// 국민연금지역보험료금액    
    private MSFNumberField natPennDducSum;			// 국민연금보험료공제액
    
    private MSFNumberField puoferAnty;				// 공적연금_공무원연금금액
    private MSFNumberField puoferAntyDducSum;		// 공적연금_공무원연금공제금액    
    
    private MSFNumberField prcspIncmTxSum;			// D56_종전근무지기납부세액_소득세금액    
    private MSFNumberField prcspRgonIncmTxSum;		// D57_종전근무지기납부세액_지방소득세금액 
    private MSFNumberField prcspNnksSum;			// D58_종전근무지기납부세액_농특세금액
  
    private MSFNumberField mltymAnty;				// 공적연금_군인연금금액
    private MSFNumberField mltymAntyDducSum;		// 공적연금_군인연금공제금액

    private MSFNumberField prcspHlthPrmmSum;		// 종전근무지건강보험료금액
    private MSFNumberField prcspLgtmRcptnSum;		// 종전근무지장기요양보험료금액    
    private MSFNumberField prcspHlthPrmmDducSum;	// 종전근무지건강보험료공제금액
    private MSFNumberField prcspHlthLgcptnAggr;		// 종전근무지건강장기요양보험료합계금액
    
    private MSFNumberField prtafirSchlFalymmAnty;	// 공적연금_사립학교교직원연금금액
    private MSFNumberField prtafirSchlDducSum;		// 공적연금_사립학교직원연금공제금액
 
    private MSFNumberField spildtnPstoficAnty;		// 공적연금_별정우체국연금금액
    private MSFNumberField spildtnPstoficDducSum; 	// 공적연금_별정우체국연금공제금액_공제액
    

    private MSFNumberField prcspEmymtPrmmSum;		// 종전근무지고용보험료금액
    private MSFNumberField prcspEmytPrmmDducSum;	// 종전근무지고용보험료공제금액
    
    
    private MSFNumberField prcspStckEvntPrftSum;	// D18_종전근무처주식매수선택권행사이익금액
    private MSFNumberField prcspEmpStkscWdrwSum; 	// D19_종전근무처우리사주조합인출금액
    private MSFNumberField prcspEcteRsgtnExceSum;	// D20_종전근무처임원퇴직소득한도초과금액
    
    private MSFNumberField prcspAggrSum;    		// D22_종전근무처합계금액 : prcspAggrSum 
    private MSFNumberField freeDtyAggrSum;			// D53_비과세합계금액    
    private MSFNumberField reduIncmAggrSum;    		// D54_감면소득합계금액 : reduIncmAggrSum 
    
    private MSFNumberField prcspYetaC165;    		// C165_납부특례세액_소득세금액
    private MSFNumberField prcspYetaC166;			// C166_납부특례세액_지방소득세금액  
    private MSFNumberField prcspYetaC167;    		// C167_납부특례세액_농특세금액 
    
    private CheckBox prcspTxpyrAsocYn;				// D8_종전근무처납세조합여부
    private CheckBox prcspWhdgReipSumtYn;			// 종전근무지원천징수영수증제출여부
    private CheckBox prcspPrcsYn;					// 종전근무지처리여부


//    private MSFNumberField rtreMuam;	//과학기술인공제
//    private MSFNumberField rtreDdam;	//과학기술인공제_공제액
//    
//    private MSFNumberField rtrePsct;	//근로자퇴직보장법
//    private MSFNumberField rtreDsct;	//근로자퇴직보장법_공제액
//    
//    private MSFNumberField rtreAnsv;	//연금저축계좌
//    private MSFNumberField rtreDnsv;	//연금저축계좌_공제액    

    // ---------------- 종전근무지 상세 종료 ---------------- 
	Button btnNewButton;;
      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++구남+++++++++++++++ 
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
	// -------------- stroe 선언 시작 --------------
	private ListStore<BaseModel> lsdacRvyyStore = new ListStore<BaseModel>(); // 년도
	private ListStore<BaseModel> lsclutSeptCd 	= new ListStore<BaseModel>(); // 정산구분
	// -------------- stroe 선언 종료 --------------
	    
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
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	Rpc Service 선언부 종료
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**

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
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/
		/**
		 * 권한설정 처리 체크 AuthAction
		 */
//		 private void checkYetaP13006Auth( String authAction, ListStore<BaseModel>bm) {
//			 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				  if (!maskTracker) { 
//					  unmask(); 
//				  }  
//				  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				   * 권한설정을 위한 콤보처리를 위한 메서드 시작
//				   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  * 권한설정을 위한 콤보처리를 위한 메서드 종료
//					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			 }
//		 }
//
//		 final Timer tmMask = new Timer() {
//			 public void run() {
//				// if (maskTracker)
//				 // { 
//				 cancel();
//				 unmask(); 
//				 maskTracker  = true;
//				 // }
//			 }
//		 }; 
//		     
//		 private void initLoad() {
//		
//			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//			 gwtAuthorization = GWTAuthorization.getInstance();
//			 gwtExtAuth = GWTExtAuth.getInstance();
//			
//			
//			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//			 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//			 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
//			 authMapDef.put("srhDeptCd",Boolean.FALSE);
//				 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
//			
//			 gwtExtAuth.setCheckMapDef(authMapDef);
//			
//			 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//				 //권한 검색조건처리를 위해 추가된 부분
//				 mask("[화면로딩] 초기화 진행 중!");
//			 }	
//			 tmMask.scheduleRepeating(5000);
//		 }
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	 
	  
	public YetaP83006(final ActionDatabase actionDatabase, final MSFPanel caller) {

		// 콤보 권한초기화
		// initLoad();

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYeta83006 = new ContentPanel();

		createSearchForm(); 	// 기본정보 필드를 적용
		createMsfGridForm(); 	// 그리드필드
		createStandardForm(); 	// 기본정보필드

		cpYeta83006.setBodyBorder(false);
		cpYeta83006.setBorders(false);
		cpYeta83006.setHeaderVisible(false);
//		cpYeta83006.setSize("790px", "640px");
		cpYeta83006.setSize("950px", "720px");

		this.add(cpYeta83006);
		formBinding = new FormBinding(this, true);

//		this.setSize("810px", "710px");
		this.setSize("970px", "780px");
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
	  
	/**
	 * 기본정보 설정
	 */
	private void createSearchForm() {
		
		actionDatabase = ActionDatabase.UPDATE;
			
		systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta83006.add(systemkey);
			
		dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYeta83006.add(dpobCd);
		    
		yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYeta83006.add(yrtxBlggYr);
		    
		clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
		clutSeptCd.setName("clutSeptCd");
		cpYeta83006.add(clutSeptCd);
		
		deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		deptNm.setName("deptNm");
		cpYeta83006.add(deptNm);
		    
		hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		hanNm.setName("hanNm");
		cpYeta83006.add(hanNm);
		
		whdgDebrBusoprRgstnum = new HiddenField<String>();	/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum	 */
		whdgDebrBusoprRgstnum.setName("whdgDebrBusoprRgstnum");
		cpYeta83006.add(whdgDebrBusoprRgstnum);
		
		prcspSeilNum = new HiddenField<String>();/** column D4_종전근무처일련번호 : prcspSeilNum */
		prcspSeilNum.setName("prcspSeilNum");
		cpYeta83006.add(prcspSeilNum);
		
		resnRegnNum = new HiddenField<String>(); /** column D7_소득자주민등록번호 : resnRegnNum */
		resnRegnNum.setName("resnRegnNum");
		cpYeta83006.add(resnRegnNum);
		
		
		
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		     
		        

		cpYeta83006.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaNew = new Button("신규");
		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				// 종전근무지상세 초기화
				resetYetaP13006();

				actionDatabase = ActionDatabase.INSERT;
				// doAction(actionDatabase);
				
				btnNewButton.hide();
			}
		});
			
		topYetaBtnBar.add(btnYetaNew);

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				MessageBox.confirm("삭제", "선택하신 종전근무지 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							Iterator<BaseModel> itBm = YetaP83006GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
							List<Record> lsRec = new ArrayList<Record>();

							while (itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}
							setListRecord(lsRec.iterator());

							actionDatabase = ActionDatabase.DELETE;
							doAction(actionDatabase);
							
						}
					}
				});
			}
		});
		topYetaBtnBar.add(btnYetaDel);
				
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
//				setListRecord(YetaP83006GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
//				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
//					actionDatabase = ActionDatabase.INSERT;
//				} else {
//					actionDatabase = ActionDatabase.UPDATE;
//				}
				Boolean dataChk = valChk();
				if(dataChk) {
					doAction(actionDatabase);
				}
			}
		});

		topYetaBtnBar.add(btnYetaSave);
		cpYeta83006.add(topYetaBtnBar);
		  	
		  	
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);
			
		srhYrtxBlggYr = new TextField<String>();
		srhYrtxBlggYr.setName("srhYrtxBlggYr");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
		srhYrtxBlggYr.setFieldLabel("년도");
		lcSchCol01.add(srhYrtxBlggYr, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhClutSeptCd = new ComboBox<BaseModel>();
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
		srhClutSeptCd.setStore(lsclutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
//				srhClutSeptCd.setValue(lsclutSeptCd.getAt(0));
			}
		});
		lcSchCol02.add(srhClutSeptCd, new FormData("100%"));
			
		LayoutContainer lcSchCol03 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03.setLayout(frmlytSch);

		srhDeptNm = new TextField<String>();
		srhDeptNm.setReadOnly(true);
		srhDeptNm.setName("srhDeptNm");
		srhDeptNm.setWidth(100);
		srhDeptNm.setFieldLabel("부서");
		lcSchCol03.add(srhDeptNm, new FormData("100%"));
			
			
		LayoutContainer lcSchCol04 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol04.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setReadOnly(true);
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");

		lcSchCol04.add(srhHanNm, new FormData("100%"));
			
		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta83006.add(fieldSet);

	}
	 	 
	private void createStandardForm() {

		LayoutContainer lcFormLayer = new LayoutContainer();
		lcFormLayer.setSize("925px", "270px");

		LayoutContainer layoutContainer = new LayoutContainer();

		// 종전근무지상세
		LayoutContainer layoutContainer_1 = new LayoutContainer();

		FieldSet fieldSet_01 = new FieldSet();
		fieldSet_01.setHeadingHtml("종전근무지상세");
		fieldSet_01.setBorders(true);

		layoutContainer.add(layoutContainer_1);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		layoutContainer_7.setLayout(new ColumnLayout());
	      
	      
		// 근무기간
		LayoutContainer layoutContainer_27 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_27.setLayout(frmlytSch);
	      
		prcspDutyBgnnDt = new MSFDateField();
		new DateFieldMask(prcspDutyBgnnDt, "9999.99.99");
		prcspDutyBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		prcspDutyBgnnDt.setFieldLabel("근무기간");
		layoutContainer_27.add(prcspDutyBgnnDt, new FormData("100%"));
		
		layoutContainer_7.add(layoutContainer_27,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.62));

		LayoutContainer layoutContainer_28 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_28.setLayout(frmlytSch);
	      
		prcspDutyEndDt = new MSFDateField();
		new DateFieldMask(prcspDutyEndDt, "9999.99.99");
		prcspDutyEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		prcspDutyEndDt.setLabelSeparator("~");
		layoutContainer_28.add(prcspDutyEndDt, new FormData("100%"));
		layoutContainer_7.add(layoutContainer_28,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));
		layoutContainer_5.add(layoutContainer_7);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		layoutContainer_8.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_29 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_29.setLayout(frmlytSch);

		hanNm01 = new MSFTextField();
		hanNm01.setFieldLabel("성 명");
		hanNm01.setReadOnly(true);
		layoutContainer_29.add(hanNm01, new FormData("100%"));
		layoutContainer_8.add(layoutContainer_29,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		
		LayoutContainer layoutContainer_30 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_30.setLayout(frmlytSch);

		prcspBusoprRgstnum = new MSFTextField();
		prcspBusoprRgstnum.setFieldLabel("사업자등록번호");
		new TextFieldMask<String>(prcspBusoprRgstnum, "999-99-99999");
		layoutContainer_30.add(prcspBusoprRgstnum, new FormData("100%"));
		layoutContainer_8.add(layoutContainer_30,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		layoutContainer_5.add(layoutContainer_8);
	
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		
		
		LayoutContainer layoutContainer_31 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_31.setLayout(frmlytSch);
		
		prcspHlthPrmmSum = new MSFNumberField();
		prcspHlthPrmmSum.setAllowDecimals(true);
		prcspHlthPrmmSum.setPropertyEditorType(Long.class);
		prcspHlthPrmmSum.setFormat(NumberFormat.getDecimalFormat());
		prcspHlthPrmmSum.setFieldLabel("건강보험료");
		layoutContainer_31.add(prcspHlthPrmmSum, new FormData("100%"));		
		layoutContainer_9.add(layoutContainer_31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		

		LayoutContainer layoutContainer_32 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytSch);
		
		prcspHlthPrmmDducSum = new MSFNumberField();
		prcspHlthPrmmDducSum.setFieldLabel("공제액"); 
		prcspHlthPrmmDducSum.setAllowDecimals(true);
		prcspHlthPrmmDducSum.setPropertyEditorType(Long.class);
		prcspHlthPrmmDducSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_32.add(prcspHlthPrmmDducSum, new FormData("100%"));
		
		layoutContainer_9.add(layoutContainer_32,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_5.add(layoutContainer_9);

		
		
		LayoutContainer layoutContainer_11 = new LayoutContainer();
		layoutContainer_11.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_35 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_35.setLayout(frmlytSch);
		
		prcspLgtmRcptnSum = new MSFNumberField();
		prcspLgtmRcptnSum.setAllowDecimals(true);
		prcspLgtmRcptnSum.setPropertyEditorType(Long.class);
		prcspLgtmRcptnSum.setFormat(NumberFormat.getDecimalFormat());
		prcspLgtmRcptnSum.setFieldLabel("장기요양보험료");
		
		layoutContainer_35.add(prcspLgtmRcptnSum, new FormData("100%"));
		layoutContainer_11.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));


		LayoutContainer layoutContainer_36 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_36.setLayout(frmlytSch);
		
		prcspHlthLgcptnAggr = new MSFNumberField();
		prcspHlthLgcptnAggr.setAllowDecimals(true);
		prcspHlthLgcptnAggr.setPropertyEditorType(Long.class);
		prcspHlthLgcptnAggr.setFormat(NumberFormat.getDecimalFormat());
		prcspHlthLgcptnAggr.setFieldLabel("공제액");
		
		layoutContainer_36.add(prcspHlthLgcptnAggr, new FormData("100%"));
		layoutContainer_11.add(layoutContainer_36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer_5.add(layoutContainer_11);
		
		
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());
	      
		LayoutContainer layoutContainer_37 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_37.setLayout(frmlytSch);
		
		prcspEmymtPrmmSum = new MSFNumberField();
		prcspEmymtPrmmSum.setFieldLabel("고용보험료");
		prcspEmymtPrmmSum.setAllowDecimals(true);
		prcspEmymtPrmmSum.setPropertyEditorType(Long.class);
		prcspEmymtPrmmSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_37.add(prcspEmymtPrmmSum, new FormData("100%"));		
		layoutContainer_12.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		LayoutContainer layoutContainer_38 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_38.setLayout(frmlytSch);
		
		prcspEmytPrmmDducSum = new MSFNumberField();
		prcspEmytPrmmDducSum.setFieldLabel("공제액");
		prcspEmytPrmmDducSum.setAllowDecimals(true);
		prcspEmytPrmmDducSum.setPropertyEditorType(Long.class);
		prcspEmytPrmmDducSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_38.add(prcspEmytPrmmDducSum, new FormData("100%"));		
		layoutContainer_12.add(layoutContainer_38,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer_5.add(layoutContainer_12);
		
		
		LayoutContainer layoutContainer_16 = new LayoutContainer();
		layoutContainer_16.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_45 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_45.setLayout(frmlytSch);
	      
		prcspStckEvntPrftSum = new MSFNumberField();
		prcspStckEvntPrftSum.setFieldLabel("주식행사이익");
		prcspStckEvntPrftSum.setAllowDecimals(true);
		prcspStckEvntPrftSum.setPropertyEditorType(Long.class);
		prcspStckEvntPrftSum.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_45.add(prcspStckEvntPrftSum, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_45, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
	      
		LayoutContainer layoutContainer_46 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_46.setLayout(frmlytSch);

		prcspEmpStkscWdrwSum = new MSFNumberField();
		prcspEmpStkscWdrwSum.setFieldLabel("우리사주인출금액");
		prcspEmpStkscWdrwSum.setAllowDecimals(true);
		prcspEmpStkscWdrwSum.setPropertyEditorType(Long.class);
		prcspEmpStkscWdrwSum.setFormat(NumberFormat.getDecimalFormat());
			
		layoutContainer_46.add(prcspEmpStkscWdrwSum, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_46,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_5.add(layoutContainer_16);

	      
		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		layoutContainer_14.setLayout(new ColumnLayout());
	      
	
		LayoutContainer layoutContainer_41 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_41.setLayout(frmlytSch);

		prcspRcgtnBnusSum = new MSFNumberField();
		prcspRcgtnBnusSum.setFieldLabel("인정상여");
		prcspRcgtnBnusSum.setAllowDecimals(true);
		prcspRcgtnBnusSum.setPropertyEditorType(Long.class);
		prcspRcgtnBnusSum.setFormat(NumberFormat.getDecimalFormat());
			
		layoutContainer_41.add(prcspRcgtnBnusSum, new FormData("100%"));

		layoutContainer_14.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
	      
	     
		LayoutContainer layoutContainer_42 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytSch);

		prcspAllwBnusSum = new MSFNumberField();
		prcspAllwBnusSum.setFieldLabel("상여금액");
		prcspAllwBnusSum.setAllowDecimals(true);
		prcspAllwBnusSum.setPropertyEditorType(Long.class);
		prcspAllwBnusSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_42.add(prcspAllwBnusSum, new FormData("100%"));
		layoutContainer_14.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		layoutContainer_5.add(layoutContainer_14);
	      
	      
		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_43 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_43.setLayout(frmlytSch);

		prcspEcteRsgtnExceSum = new MSFNumberField();
		prcspEcteRsgtnExceSum.setFieldLabel("임원퇴직한도초과액");
		prcspEcteRsgtnExceSum.setAllowDecimals(true);
		prcspEcteRsgtnExceSum.setPropertyEditorType(Long.class);
		prcspEcteRsgtnExceSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_43.add(prcspEcteRsgtnExceSum, new FormData("100%"));
		layoutContainer_15.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      

		LayoutContainer layoutContainer_44 = new LayoutContainer();
	      
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_44.setLayout(frmlytSch);
		
		prcspPaySum = new MSFNumberField();
		prcspPaySum.setAllowDecimals(true);
		prcspPaySum.setPropertyEditorType(Long.class);
		prcspPaySum.setFormat(NumberFormat.getDecimalFormat());
		prcspPaySum.setFieldLabel("급여금액");
		layoutContainer_44.add(prcspPaySum, new FormData("100%"));
		layoutContainer_15.add(layoutContainer_44, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
		layoutContainer_5.add(layoutContainer_15);
		
		
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());
	      
		
		LayoutContainer layoutContainer_39 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_39.setLayout(frmlytSch);
		
		prcspIncmTxSum = new MSFNumberField();
		prcspIncmTxSum.setAllowDecimals(true);
		prcspIncmTxSum.setPropertyEditorType(Long.class);
		prcspIncmTxSum.setFormat(NumberFormat.getDecimalFormat());
		prcspIncmTxSum.setFieldLabel("기납부 소득세");
		layoutContainer_39.add(prcspIncmTxSum, new FormData("100%"));
		layoutContainer_13.add(layoutContainer_39,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      

		LayoutContainer layoutContainer_40 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(65);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_40.setLayout(frmlytSch);
		
		prcspRgonIncmTxSum = new MSFNumberField();
		prcspRgonIncmTxSum.setFieldLabel("지방소득세");
		prcspRgonIncmTxSum.setAllowDecimals(true);
		prcspRgonIncmTxSum.setPropertyEditorType(Long.class);
		prcspRgonIncmTxSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_40.add(prcspRgonIncmTxSum, new FormData("100%"));
		layoutContainer_13.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		
		LayoutContainer layoutContainer_411 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(65);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_411.setLayout(frmlytSch);
		
		prcspNnksSum = new MSFNumberField();
		prcspNnksSum.setFieldLabel("농특세");
		prcspNnksSum.setAllowDecimals(true);
		prcspNnksSum.setPropertyEditorType(Long.class);
		prcspNnksSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_411.add(prcspNnksSum, new FormData("100%"));
		layoutContainer_13.add(layoutContainer_411, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		layoutContainer_5.add(layoutContainer_13);
		

		LayoutContainer layoutContainer_47 = new LayoutContainer();
		layoutContainer_47.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_49 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_49.setLayout(frmlytSch);
		
		prcspAggrSum = new MSFNumberField();
		prcspAggrSum.setFieldLabel("종전근무처합계금액");
		prcspAggrSum.setAllowDecimals(true);
		prcspAggrSum.setPropertyEditorType(Long.class);
		prcspAggrSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_49.add(prcspAggrSum, new FormData("100%"));
		layoutContainer_47.add(layoutContainer_49, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
	
		LayoutContainer layoutContainer_50 = new LayoutContainer();
		layoutContainer_50.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_50.setLayout(frmlytSch);
		
		freeDtyAggrSum = new MSFNumberField();
		freeDtyAggrSum.setFieldLabel("비과세합계금액");
		freeDtyAggrSum.setAllowDecimals(true);
		freeDtyAggrSum.setPropertyEditorType(Long.class);
		freeDtyAggrSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_50.add(freeDtyAggrSum, new FormData("100%"));
		layoutContainer_47.add(layoutContainer_50, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer_5.add(layoutContainer_47);
	      
	      
		layoutContainer_2.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
	      
		LayoutContainer layoutContainer_6 = new LayoutContainer();

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		layoutContainer_17.setLayout(new ColumnLayout());

	
		LayoutContainer layoutContainer_51 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_51.setLayout(frmlytSch);
	      
		prcspReduBgnnDt = new MSFDateField();
		layoutContainer_51.add(prcspReduBgnnDt, new FormData("100%"));
		new DateFieldMask(prcspReduBgnnDt, "9999.99.99");
		prcspReduBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		prcspReduBgnnDt.setFieldLabel("감면기간");
		layoutContainer_17.add(layoutContainer_51,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.62));
	      
		LayoutContainer layoutContainer_52 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_52.setLayout(frmlytSch);

		prcspReduEndDt = new MSFDateField();
		layoutContainer_52.add(prcspReduEndDt, new FormData("100%"));
		new DateFieldMask(prcspReduEndDt, "9999.99.99");
		prcspReduEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		prcspReduEndDt.setLabelSeparator("~");
		layoutContainer_17.add(layoutContainer_52,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));

		layoutContainer_6.add(layoutContainer_17);
	      
		LayoutContainer layoutContainer_18 = new LayoutContainer();

		FormLayout frmlytSch26 = new FormLayout();
		frmlytSch26.setLabelWidth(120);
		frmlytSch26.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_18.setLayout(frmlytSch26);

		prcspFmnmNm = new MSFTextField();
		layoutContainer_18.add(prcspFmnmNm, new FormData("100%"));
		prcspFmnmNm.setFieldLabel("근무지명");

		layoutContainer_6.add(layoutContainer_18);
		
		

		LayoutContainer layoutContainer_199 = new LayoutContainer();
		layoutContainer_199.setLayout(new ColumnLayout());
		
		
		LayoutContainer layoutContainer_322 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_322.setLayout(frmlytSch);

		natPennPrmmSum = new MSFNumberField();
		natPennPrmmSum.setFieldLabel("국민연금보험료");
		natPennPrmmSum.setAllowDecimals(true);
		natPennPrmmSum.setPropertyEditorType(Long.class);
		natPennPrmmSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_322.add(natPennPrmmSum, new FormData("100%"));
		
		layoutContainer_199.add(layoutContainer_322,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_6.add(layoutContainer_199);
		
		
		LayoutContainer layoutContainer_366 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_366.setLayout(frmlytSch);

		natPennDducSum = new MSFNumberField();
		natPennDducSum.setFieldLabel("공제액");
		natPennDducSum.setAllowDecimals(true);
		natPennDducSum.setPropertyEditorType(Long.class);
		natPennDducSum.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_366.add(natPennDducSum, new FormData("100%"));
		
		layoutContainer_199.add(layoutContainer_366, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_6.add(layoutContainer_199);
		
		
		
		///--
		LayoutContainer layoutContainer_299 = new LayoutContainer();
		layoutContainer_299.setLayout(new ColumnLayout());
		
		
		LayoutContainer layoutContainer_222 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_222.setLayout(frmlytSch);

		natPennAraPrmmSum = new MSFNumberField();
		natPennAraPrmmSum.setFieldLabel("국민연금지역보험료");
		natPennAraPrmmSum.setAllowDecimals(true);
		natPennAraPrmmSum.setPropertyEditorType(Long.class);
		natPennAraPrmmSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_222.add(natPennAraPrmmSum, new FormData("100%"));
		
		layoutContainer_299.add(layoutContainer_222,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_6.add(layoutContainer_299);
		
		
		LayoutContainer layoutContainer_223 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_223.setLayout(frmlytSch);

		
		layoutContainer_299.add(layoutContainer_223, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_6.add(layoutContainer_299);		
		//--
		
		
		

		
		
		LayoutContainer layoutContainer_19 = new LayoutContainer();
		layoutContainer_19.setLayout(new ColumnLayout());
	      
		
		LayoutContainer layoutContainer_55 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_55.setLayout(frmlytSch);
	      
		puoferAnty = new MSFNumberField();
		puoferAnty.setFieldLabel("공무원연금");
		puoferAnty.setAllowDecimals(true);
		puoferAnty.setPropertyEditorType(Long.class);
		puoferAnty.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_55.add(puoferAnty, new FormData("100%"));
	   
		layoutContainer_19.add(layoutContainer_55, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	   
	      
		LayoutContainer layoutContainer_56 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_56.setLayout(frmlytSch);

		puoferAntyDducSum = new MSFNumberField();
		puoferAntyDducSum.setFieldLabel("공제액");
		puoferAntyDducSum.setAllowDecimals(true);
		puoferAntyDducSum.setPropertyEditorType(Long.class);
		puoferAntyDducSum.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_56.add(puoferAntyDducSum, new FormData("100%"));
		layoutContainer_19.add(layoutContainer_56, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		layoutContainer_6.add(layoutContainer_19);

		LayoutContainer layoutContainer_20 = new LayoutContainer();
		layoutContainer_20.setLayout(new ColumnLayout());

		
		LayoutContainer layoutContainer_57 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_57.setLayout(frmlytSch);
	      
		mltymAnty = new MSFNumberField();
		mltymAnty.setAllowDecimals(true);
		mltymAnty.setPropertyEditorType(Long.class);
		mltymAnty.setFormat(NumberFormat.getDecimalFormat());
		mltymAnty.setFieldLabel("군인연금");
		layoutContainer_57.add(mltymAnty, new FormData("100%"));
		
		layoutContainer_20.add(layoutContainer_57, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      
		
		LayoutContainer layoutContainer_58 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_58.setLayout(frmlytSch);

		mltymAntyDducSum = new MSFNumberField();
		mltymAntyDducSum.setFieldLabel("공제액");
		mltymAntyDducSum.setAllowDecimals(true);
		mltymAntyDducSum.setPropertyEditorType(Long.class); 
		mltymAntyDducSum.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_58.add(mltymAntyDducSum, new FormData("100%"));
		layoutContainer_20.add(layoutContainer_58,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		layoutContainer_6.add(layoutContainer_20);
	      
		
		
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_59 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_59.setLayout(frmlytSch);

		prtafirSchlFalymmAnty = new MSFNumberField();
		prtafirSchlFalymmAnty.setFieldLabel("교직원연금");
		prtafirSchlFalymmAnty.setAllowDecimals(true);
		prtafirSchlFalymmAnty.setPropertyEditorType(Long.class);
		prtafirSchlFalymmAnty.setFormat(NumberFormat.getDecimalFormat());
			
		layoutContainer_59.add(prtafirSchlFalymmAnty, new FormData("100%"));

		layoutContainer_21.add(layoutContainer_59, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		

		LayoutContainer layoutContainer_60 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_60.setLayout(frmlytSch);

		prtafirSchlDducSum = new MSFNumberField();

		prtafirSchlDducSum.setAllowDecimals(true);
		prtafirSchlDducSum.setPropertyEditorType(Long.class);
		prtafirSchlDducSum.setFormat(NumberFormat.getDecimalFormat());
		prtafirSchlDducSum.setFieldLabel("공제액");
		layoutContainer_60.add(prtafirSchlDducSum, new FormData("100%"));
	    
		layoutContainer_21.add(layoutContainer_60, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		layoutContainer_6.add(layoutContainer_21);

		
		
		LayoutContainer layoutContainer_22 = new LayoutContainer();
		layoutContainer_22.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_61 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_61.setLayout(frmlytSch);

		spildtnPstoficAnty = new MSFNumberField();
		spildtnPstoficAnty.setFieldLabel("별정우체국");
		spildtnPstoficAnty.setAllowDecimals(true);
		spildtnPstoficAnty.setPropertyEditorType(Long.class);
		spildtnPstoficAnty.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_61.add(spildtnPstoficAnty, new FormData("100%"));
		layoutContainer_22.add(layoutContainer_61,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		
		LayoutContainer layoutContainer_62 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_62.setLayout(frmlytSch);
	      
		spildtnPstoficDducSum = new MSFNumberField();
		spildtnPstoficDducSum.setFieldLabel("공제액");
		spildtnPstoficDducSum.setAllowDecimals(true);
		spildtnPstoficDducSum.setPropertyEditorType(Long.class);
		spildtnPstoficDducSum.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_62.add(spildtnPstoficDducSum, new FormData("100%"));

		layoutContainer_22.add(layoutContainer_62, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		layoutContainer_6.add(layoutContainer_22);
	      
		
		LayoutContainer layoutContainer_24 = new LayoutContainer();
		layoutContainer_24.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_391 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_391.setLayout(frmlytSch);
		
		prcspYetaC165 = new MSFNumberField();
		prcspYetaC165.setAllowDecimals(true);
		prcspYetaC165.setPropertyEditorType(Long.class);
		prcspYetaC165.setFormat(NumberFormat.getDecimalFormat());
		prcspYetaC165.setFieldLabel("납부특례 소득세");
		layoutContainer_391.add(prcspYetaC165, new FormData("100%"));
		layoutContainer_24.add(layoutContainer_391,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		
		LayoutContainer layoutContainer_401 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(65);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_401.setLayout(frmlytSch);
		
		prcspYetaC166 = new MSFNumberField();
		prcspYetaC166.setFieldLabel("지방소득세");
		prcspYetaC166.setAllowDecimals(true);
		prcspYetaC166.setPropertyEditorType(Long.class);
		prcspYetaC166.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_401.add(prcspYetaC166, new FormData("100%"));
		layoutContainer_24.add(layoutContainer_401, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		
		LayoutContainer layoutContainer_412 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(65);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_412.setLayout(frmlytSch);
		
		prcspYetaC167 = new MSFNumberField();
		prcspYetaC167.setFieldLabel("농특세");
		prcspYetaC167.setAllowDecimals(true);
		prcspYetaC167.setPropertyEditorType(Long.class);
		prcspYetaC167.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_412.add(prcspYetaC167, new FormData("100%"));
		layoutContainer_24.add(layoutContainer_412, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_6.add(layoutContainer_24);
		

		LayoutContainer layoutContainer_48 = new LayoutContainer();
		layoutContainer_48.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_71 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_71.setLayout(frmlytSch);
		
		reduIncmAggrSum = new MSFNumberField();
		reduIncmAggrSum.setFieldLabel("감면소득합계금액");
		reduIncmAggrSum.setAllowDecimals(true);
		reduIncmAggrSum.setPropertyEditorType(Long.class);
		reduIncmAggrSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_71.add(reduIncmAggrSum, new FormData("100%"));
		layoutContainer_48.add(layoutContainer_71, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      
	      
		LayoutContainer layoutContainer_72 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_72.setLayout(frmlytSch);

		layoutContainer_48.add(layoutContainer_72,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_6.add(layoutContainer_48);

		layoutContainer_2.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer.add(layoutContainer_2);
	      
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());

		prcspTxpyrAsocYn = new CheckBox();
		prcspTxpyrAsocYn.setValueAttribute("Y");
		prcspTxpyrAsocYn.setName("prcspTxpyrAsocYn");
		prcspTxpyrAsocYn.setBoxLabel("납세조합여부");
		prcspTxpyrAsocYn.setHideLabel(false);
		layoutContainer_3.add(prcspTxpyrAsocYn);
		
		prcspWhdgReipSumtYn = new CheckBox();
		prcspWhdgReipSumtYn.setValueAttribute("1");
		prcspWhdgReipSumtYn.setName("prcspWhdgReipSumtYn");
		prcspWhdgReipSumtYn.setBoxLabel("원천징수영수증제출여부");
		prcspWhdgReipSumtYn.setHideLabel(false);
		layoutContainer_3.add(prcspWhdgReipSumtYn);
		
		prcspPrcsYn = new CheckBox();
		prcspPrcsYn.setValueAttribute("1");
		prcspPrcsYn.setName("prcspPrcsYn");
		prcspPrcsYn.setBoxLabel("처리여부");
		prcspPrcsYn.setHideLabel(false);
		layoutContainer_3.add(prcspPrcsYn);
		layoutContainer.add(layoutContainer_3);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_3 = new LabelField("* 원천징수 영수증 제출 '예', 처리구분 '예'인 자료만 연말정산 종전근무지에 등록됩니다.    ");
		layoutContainer_4.add(lblfldNewLabelfield_3);

		btnNewButton = new Button("비과세 및 감면소득 입력");
		btnNewButton.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				BaseModel bmData = YetaP83006GridPanel.getCurrentlySelectedItem();

				funcSetPopUpRecord();
//				setPPRecord(bmData); //팝업에 넘길값 
				
				if(MSFSharedUtils.paramNull(bmData)){
					
					dpobCd.setValue((String) bmData.get("dpobCd"));									/** column 사업장코드 : dpobCd */
					yrtxBlggYr.setValue((String) bmData.get("yrtxBlggYr"));							/** column 연말정산귀속년도 : yrtxBlggYr */
					clutSeptCd.setValue((String) bmData.get("clutSeptCd"));							/** column 정산구분코드 : clutSeptCd */
					systemkey.setValue((String) bmData.get("systemkey"));							/** column SYSTEMKEY : systemkey */
					whdgDebrBusoprRgstnum.setValue((String) bmData.get("whdgDebrBusoprRgstnum"));	// 사업자등록번호
					hanNm.setValue((String) bmData.get("hanNm"));
					deptNm.setValue((String) bmData.get("deptNm"));
				}
	        	   
				// 전체내역
				YetaP830010 yetaP830010Form = new YetaP830010(ActionDatabase.UPDATE,getThis()); 
						    
				MSFFormWindows msFwYeta830010 = new MSFFormWindows("비과세 및 감면소득", yetaP830010Form, "닫기", "820px", "750px", true);
				msFwYeta830010.show();
				yetaP830010Form.setMSFFormWindows(msFwYeta830010);

				yetaP830010Form.bind(ppRecord);
			}
		});
		btnNewButton.hide();
		layoutContainer_4.add(btnNewButton);

		layoutContainer.add(layoutContainer_4);

		fieldSet_01.add(layoutContainer);

		// cp01.add(layoutContainer);
		// cp01.add(fieldSet_01);
		// lcFormLayer.add(cp01);
		lcFormLayer.add(fieldSet_01);
		cpYeta83006.add(lcFormLayer);
		// return lcFormLayer;
	}
	 
			
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				srhYrtxBlggYr.setValue(yrtxBlggYr.getValue());
				YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd" );
				srhDeptNm.setValue(deptNm.getValue());
				srhHanNm.setValue(hanNm.getValue());
				hanNm01.setValue(hanNm.getValue());
				
				reload();
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

	private void createMsfGridForm() {

		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("종전근무지내역");
		gridFieldSet.setBorders(true);
		gridFieldSet.setStyleAttribute("paddingLeft" , "5px");
		gridFieldSet.setStyleAttribute("paddingRight", "5px");

		YetaP83006GridPanel = new MSFGridPanel(YetaP83006ToYe160404Def, false,false, false, false, false);
		YetaP83006GridPanel.setHeaderVisible(false);
		YetaP83006GridPanel.setSize("915px", "200px");
		YetaP83006GridPanel.setBorders(false);
		YetaP83006GridPanel.setHeadingText("");
		
	
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
		
		payrSummaryRow.setHtml(Ye160404BM.ATTR_CLUTSEPTNM, "합 계"); 
		payrSummaryRow.setCellStyle(Ye160404BM.ATTR_CLUTSEPTNM,"summary_color");
		
		payrSummaryRow.setCellStyle(Ye160404BM.ATTR_PRCSPPAYSUM,"summary_color");			/** set 급여합계금액 : prcspAggrSum */
		payrSummaryRow.setCellStyle(Ye160404BM.ATTR_PRCSPALLWBNUSSUM,"summary_color");		/** column D16_종전근무처상여금액 : prcspAllwBnusSum */
		payrSummaryRow.setCellStyle(Ye160404BM.ATTR_PRCSPINCMTXSUM,"summary_color");	/** column D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
		payrSummaryRow.setCellStyle(Ye160404BM.ATTR_PRCSPRGONINCMTXSUM,"summary_color");	/** column D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
		
							    
		payrSummaryRow.setSummaryType(Ye160404BM.ATTR_PRCSPPAYSUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye160404BM.ATTR_PRCSPPAYSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
							    
		payrSummaryRow.setSummaryType(Ye160404BM.ATTR_PRCSPALLWBNUSSUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye160404BM.ATTR_PRCSPALLWBNUSSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		payrSummaryRow.setSummaryType(Ye160404BM.ATTR_PRCSPINCMTXSUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye160404BM.ATTR_PRCSPINCMTXSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		payrSummaryRow.setSummaryType(Ye160404BM.ATTR_PRCSPRGONINCMTXSUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye160404BM.ATTR_PRCSPRGONINCMTXSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
							      
		
		YetaP83006GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		/** --- 그리드 합계 부분  시작 --- **/
		
		final Grid YetaP83006Grid = YetaP83006GridPanel.getMsfGrid().getGrid();
		YetaP83006Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				//그리드 선택시
				actionDatabase = ActionDatabase.UPDATE;
				yetaP13006ToYeta3200Detail(YetaP83006GridPanel.getCurrentlySelectedItem());
				btnNewButton.show();
			}
		});
		
		gridFieldSet.add(YetaP83006GridPanel);

		cpYeta83006.add(gridFieldSet);
	}

	private YetaP83006 getThis() {
		return this;
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
	
	// 버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			YetaP83006FormSave();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			YetaP83006FormSave();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			YetaP83006FormSave();
			break;
		}
	}
	
	private void YetaP83006FormSave() {
		
		Ye160404DTO ye160404Dto = new Ye160404DTO();
		List<Ye160404DTO> listYe160404Dto = new ArrayList<Ye160404DTO>();
		
    	if("DELETE".equals(actionDatabase)) {
    		
    		if (MSFSharedUtils.paramNotNull(records)) {

				while (records.hasNext()) {

					Record record = (Record) records.next();
					BaseModel bmMapModel = (BaseModel) record.getModel();

					ye160404Dto = new Ye160404DTO();
    				
    				ye160404Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
    				ye160404Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    						/** column 귀속연도 : yrtxBlggYr */
    				ye160404Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
    				ye160404Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
    				ye160404Dto.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(bmMapModel.get("whdgDebrBusoprRgstnum")));	/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    				ye160404Dto.setPrcspSeilNum((Long) bmMapModel.get("prcspSeilNum"));    										/** column D4_종전근무처일련번호 : prcspSeilNum */
//    				ye160404Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    					/** column D7_소득자주민등록번호 : resnRegnNum */
//    				ye160404Dto.setPrcspTxpyrAsocYn(MSFSharedUtils.allowNulls(bmMapModel.get("prcspTxpyrAsocYn")));    			/** column D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
//    				ye160404Dto.setPrcspFmnmNm(MSFSharedUtils.allowNulls(bmMapModel.get("prcspFmnmNm")));    					/** column D9_종전근무처법인_상호명 : prcspFmnmNm */
//    				ye160404Dto.setPrcspBusoprRgstnum(MSFSharedUtils.allowNulls(bmMapModel.get("prcspBusoprRgstnum")));    		/** column D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
//    				ye160404Dto.setPrcspDutyBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("prcspDutyBgnnDt")));    			/** column D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
//    				ye160404Dto.setPrcspDutyEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("prcspDutyEndDt")));    				/** column D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
//    				ye160404Dto.setPrcspReduBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("prcspReduBgnnDt")));    			/** column D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
//    				ye160404Dto.setPrcspReduEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("prcspReduEndDt")));    				/** column D14_종전근무처감면기간종료일자 : prcspReduEndDt */
//    				ye160404Dto.setPrcspPaySum((Long) bmMapModel.get("prcspPaySum"));    										/** column D15_종전근무처급여금액 : prcspPaySum */
//    				ye160404Dto.setPrcspAllwBnusSum((Long) bmMapModel.get("prcspAllwBnusSum"));    								/** column D16_종전근무처상여금액 : prcspAllwBnusSum */
//    				ye160404Dto.setPrcspRcgtnBnusSum((Long) bmMapModel.get("prcspRcgtnBnusSum"));    							/** column D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
//    				ye160404Dto.setPrcspStckEvntPrftSum((Long) bmMapModel.get("prcspStckEvntPrftSum"));    						/** column D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
//    				ye160404Dto.setPrcspEmpStkscWdrwSum((Long) bmMapModel.get("prcspEmpStkscWdrwSum"));    						/** column D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
//    				ye160404Dto.setPrcspEcteRsgtnExceSum((Long) bmMapModel.get("prcspEcteRsgtnExceSum"));    					/** column D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
//    				ye160404Dto.setPrcspAggrSum((Long) bmMapModel.get("prcspAggrSum"));    										/** column D22_종전근무처합계금액 : prcspAggrSum */
//    				ye160404Dto.setFreeDtyAggrSum((Long) bmMapModel.get("freeDtyAggrSum"));    									/** column D53_비과세합계금액 : freeDtyAggrSum */
//    				ye160404Dto.setReduIncmAggrSum((Long) bmMapModel.get("reduIncmAggrSum"));    								/** column D54_감면소득합계금액 : reduIncmAggrSum */
//    				ye160404Dto.setPrcspIncmTxSum((Long) bmMapModel.get("prcspIncmTxSum"));    									/** column D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
//    				ye160404Dto.setPrcspRgonIncmTxSum((Long) bmMapModel.get("prcspRgonIncmTxSum"));    							/** column D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
//    				ye160404Dto.setPrcspNnksSum((Long) bmMapModel.get("prcspNnksSum"));    										/** column D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
//    				ye160404Dto.setPrcspHlthPrmmSum((Long) bmMapModel.get("prcspHlthPrmmSum"));    								/** column 종전근무지건강보험료금액 : prcspHlthPrmmSum */
//    				ye160404Dto.setPrcspLgtmRcptnSum((Long)bmMapModel.get("prcspLgtmRcptnSum"));    							/** column 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
//    				ye160404Dto.setPrcspHlthLgcptnAggr((Long) bmMapModel.get("prcspHlthLgcptnAggr"));    						/** column 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
//    				ye160404Dto.setPrcspHlthPrmmDducSum((Long)bmMapModel.get("prcspHlthPrmmDducSum"));    						/** column 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
//    				ye160404Dto.setPrcspEmymtPrmmSum((Long) bmMapModel.get("prcspEmymtPrmmSum"));    							/** column 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
//    				ye160404Dto.setPrcspEmytPrmmDducSum((Long) bmMapModel.get("prcspEmytPrmmDducSum"));    						/** column 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
//    				ye160404Dto.setPrcspPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("prcspPrcsYn")));    					/** column 종전근무지처리여부 : prcspPrcsYn */
//    				ye160404Dto.setPrcspWhdgReipSumtYn(MSFSharedUtils.allowNulls(bmMapModel.get("prcspWhdgReipSumtYn")));    	/** column 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */				
    				
    				listYe160404Dto.add(ye160404Dto);
    			
    			}
    			
    			yetaP83006Service.activityOnYetaP83006ToYe160404(listYe160404Dto, actionDatabase, new AsyncCallback<Long>(){
    				public void onFailure(Throwable caught) {
    					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
    							, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP83006ToYe160404(" + actionDatabase.name() + ") : " + caught)
    							, null);
    					}
    					public void onSuccess(Long result) { 
    						
    						if (result == 0) {
    							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
    						} else {
    							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
    							reload();
    							actionDatabase = ActionDatabase.UPDATE;
    						} 
    					} 
    				}
    			); 
    			
    		} else {
    			MessageBox.alert(actionDatabase.name() + "선택",actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
    			return;
    		}
    		
    	}else {
    		
    		ye160404Dto = new Ye160404DTO();
			
			ye160404Dto.setDpobCd				( MSFSharedUtils.allowNulls(dpobCd.getValue()));    					/** column 사업장코드 : dpobCd */
			ye160404Dto.setYrtxBlggYr			( MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()));    				/** column 귀속연도 : yrtxBlggYr */
			ye160404Dto.setClutSeptCd			( MSFSharedUtils.allowNulls(clutSeptCd.getValue()));    				/** column 연말정산구분코드 : clutSeptCd */
			ye160404Dto.setSystemkey			( MSFSharedUtils.allowNulls(systemkey.getValue()));    					/** column SYSTEMKEY : systemkey */
			ye160404Dto.setWhdgDebrBusoprRgstnum( MSFSharedUtils.allowNulls(prcspBusoprRgstnum.getValue()));			/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
			ye160404Dto.setPrcspSeilNum			( MSFSharedUtils.convertStringToLong(prcspSeilNum.getValue()) );    	/** column D4_종전근무처일련번호 : prcspSeilNum */
			ye160404Dto.setResnRegnNum			( MSFSharedUtils.allowNulls(resnRegnNum.getValue()));    				/** column D7_소득자주민등록번호 : resnRegnNum */
		
			ye160404Dto.setPrcspFmnmNm			( MSFSharedUtils.allowNulls(prcspFmnmNm.getValue()));    				/** column D9_종전근무처법인_상호명 : prcspFmnmNm */
			ye160404Dto.setPrcspBusoprRgstnum	( MSFSharedUtils.allowNulls(prcspBusoprRgstnum.getValue()));    		/** column D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
			ye160404Dto.setPrcspDutyBgnnDt		( MSFSharedUtils.getConvertDateToString(prcspDutyBgnnDt	, "yyyyMMdd")); /** column D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
			ye160404Dto.setPrcspDutyEndDt		( MSFSharedUtils.getConvertDateToString(prcspDutyEndDt	, "yyyyMMdd")); /** column D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
			ye160404Dto.setPrcspReduBgnnDt		( MSFSharedUtils.getConvertDateToString(prcspReduBgnnDt	, "yyyyMMdd")); /** column D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
			ye160404Dto.setPrcspReduEndDt		( MSFSharedUtils.getConvertDateToString(prcspReduEndDt	, "yyyyMMdd")); /** column D14_종전근무처감면기간종료일자 : prcspReduEndDt */
			
			ye160404Dto.setPrcspPaySum			((Long) prcspPaySum.getValue());    									/** column D15_종전근무처급여금액 : prcspPaySum */
			ye160404Dto.setPrcspAllwBnusSum		((Long) prcspAllwBnusSum.getValue());    								/** column D16_종전근무처상여금액 : prcspAllwBnusSum */
			ye160404Dto.setPrcspRcgtnBnusSum	((Long) prcspRcgtnBnusSum.getValue());    								/** column D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
			ye160404Dto.setPrcspStckEvntPrftSum	((Long) prcspStckEvntPrftSum.getValue());    							/** column D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
			ye160404Dto.setPrcspEmpStkscWdrwSum	((Long) prcspEmpStkscWdrwSum.getValue());    							/** column D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
			ye160404Dto.setPrcspEcteRsgtnExceSum((Long) prcspEcteRsgtnExceSum.getValue());    							/** column D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
			ye160404Dto.setPrcspAggrSum			((Long) prcspAggrSum.getValue());    									/** column D22_종전근무처합계금액 : prcspAggrSum */
			ye160404Dto.setFreeDtyAggrSum		((Long) freeDtyAggrSum.getValue());    									/** column D53_비과세합계금액 : freeDtyAggrSum */
			ye160404Dto.setReduIncmAggrSum		((Long) reduIncmAggrSum.getValue());    								/** column D54_감면소득합계금액 : reduIncmAggrSum */
			ye160404Dto.setPrcspIncmTxSum		((Long) prcspIncmTxSum.getValue());    									/** column D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
			ye160404Dto.setPrcspRgonIncmTxSum	((Long) prcspRgonIncmTxSum.getValue());    								/** column D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
			ye160404Dto.setPrcspNnksSum			((Long) prcspNnksSum.getValue());    									/** column D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
			ye160404Dto.setPrcspHlthPrmmSum		((Long) prcspHlthPrmmSum.getValue());    								/** column 종전근무지건강보험료금액 : prcspHlthPrmmSum */
			ye160404Dto.setPrcspLgtmRcptnSum	((Long) prcspLgtmRcptnSum.getValue());    								/** column 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
			ye160404Dto.setPrcspHlthLgcptnAggr	((Long) prcspHlthLgcptnAggr.getValue());    							/** column 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
			ye160404Dto.setPrcspHlthPrmmDducSum	((Long) prcspHlthPrmmDducSum.getValue());    							/** column 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
			ye160404Dto.setPrcspEmymtPrmmSum	((Long) prcspEmymtPrmmSum.getValue());    								/** column 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
			ye160404Dto.setPrcspEmytPrmmDducSum	((Long) prcspEmytPrmmDducSum.getValue());    							/** column 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
			
			ye160404Dto.setPrcspPrcsYn(MSFSharedUtils.defaultNulls(prcspPrcsYn.getValue() ? "1" : "0", "0"));    				/** column 종전근무지처리여부 : prcspPrcsYn */
			ye160404Dto.setPrcspWhdgReipSumtYn(MSFSharedUtils.defaultNulls(prcspWhdgReipSumtYn.getValue() ? "1" : "0", "0"));   /** column 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */		
			ye160404Dto.setPrcspTxpyrAsocYn(MSFSharedUtils.defaultNulls(prcspTxpyrAsocYn.getValue() ? "Y" : "N", "N"));    		/** column D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
			
			
			ye160404Dto.setNatPennPrmmSum		((Long) natPennPrmmSum.getValue());   									/** column 국민연금보험료금액 : natPennPrmmSum */
			ye160404Dto.setNatPennAraPrmmSum	((Long) natPennAraPrmmSum.getValue());   								/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
			ye160404Dto.setNatPennDducSum		((Long) natPennDducSum.getValue());    									/** column 국민연금공제금액 : natPennDducSum */
			ye160404Dto.setPuoferAnty			((Long) puoferAnty.getValue());   	 									/** column 공적연금_공무원연금금액 : puoferAnty */
			ye160404Dto.setPuoferAntyDducSum	((Long) puoferAntyDducSum.getValue());    								/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
			ye160404Dto.setMltymAnty			((Long) mltymAnty.getValue());    										/** column 공적연금_군인연금금액 : mltymAnty */
			ye160404Dto.setMltymAntyDducSum		((Long) mltymAntyDducSum.getValue());    								/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
			ye160404Dto.setPrtafirSchlFalymmAnty((Long) prtafirSchlFalymmAnty.getValue());    							/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
			ye160404Dto.setPrtafirSchlDducSum	((Long) prtafirSchlDducSum.getValue());    								/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
			ye160404Dto.setSpildtnPstoficAnty	((Long) spildtnPstoficAnty.getValue());   					 			/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
			ye160404Dto.setSpildtnPstoficDducSum((Long) spildtnPstoficDducSum.getValue());    							/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
			
			ye160404Dto.setPrcspYetaC165		((Long) prcspYetaC165.getValue());    									/** column C165_납부특례세액_소득세금액 : prcspYetaC165 */
			ye160404Dto.setPrcspYetaC166		((Long) prcspYetaC166.getValue());    									/** column C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
			ye160404Dto.setPrcspYetaC167		((Long) prcspYetaC167.getValue());    									/** column C167_납부특례세액_농특세금액 : prcspYetaC167 */
			

			
			listYe160404Dto.add(ye160404Dto);
    		
    	}
    	
		yetaP83006Service.activityOnYetaP83006ToYe160404(listYe160404Dto, actionDatabase, new AsyncCallback<Long>(){
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
						, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP83006ToYe160404(" + actionDatabase.name() + ") : " + caught)
						, null);
				}
				public void onSuccess(Long result) { 
					
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} else {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
						reload();
						actionDatabase = ActionDatabase.UPDATE;
					} 
				} 
			}
		); 

	}
	
	// 데이터 체크
	private Boolean valChk() {
		
		Boolean boolVal = true;
		
		return boolVal;
		
	}
	// 종전근무지상세 초기화
	public void resetYetaP13006() {

		prcspDutyBgnnDt.reset(); 			// 종전근무처근무시간시작일자
		prcspDutyEndDt.reset(); 			// 종전근무처근무시간종료일자
		prcspReduBgnnDt.reset(); 			// 감면 시작 기간
		prcspReduEndDt.reset();				// 감면 종료 기간
//		hanNm01.setValue("");				// 성명   
		prcspBusoprRgstnum.setReadOnly(false);
		prcspBusoprRgstnum.setValue("");	// D10_종전근무처사업자등록번호
		prcspFmnmNm.setValue("");			// D9_종전근무처법인_상호명
			    
		prcspPaySum.setValue(0L);			// D15_종전근무처급여금액
		prcspAllwBnusSum.setValue(0L);		// D16_종전근무처상여금액
		prcspRcgtnBnusSum.setValue(0L);		// D17_종전근무처인정상여금액

		natPennPrmmSum.setValue(0L);		// 국민연금보험료금액    
		natPennAraPrmmSum.setValue(0L);		// 국민연금지역보험료금액    
		natPennDducSum.setValue(0L);		// 국민연금보험료공제액

		puoferAnty.setValue(0L);			// 공적연금_공무원연금금액
		puoferAntyDducSum.setValue(0L);		// 공적연금_공무원연금공제금액    

		prcspIncmTxSum.setValue(0L);		// D56_종전근무지기납부세액_소득세금액    
		prcspRgonIncmTxSum.setValue(0L);	// D57_종전근무지기납부세액_지방소득세금액 
		prcspNnksSum.setValue(0L);			// D58_종전근무지기납부세액_농특세금액

		mltymAnty.setValue(0L);				// 공적연금_군인연금금액
		mltymAntyDducSum.setValue(0L);		// 공적연금_군인연금공제금액

		prcspHlthPrmmSum.setValue(0L);		// 종전근무지건강보험료금액
		prcspLgtmRcptnSum.setValue(0L);		// 종전근무지장기요양보험료금액    
		prcspHlthPrmmDducSum.setValue(0L);	// 종전근무지건강보험료공제금액
		prcspHlthLgcptnAggr.setValue(0L);	// 종전근무지건강장기요양보험료합계금액

		prtafirSchlFalymmAnty.setValue(0L);	// 공적연금_사립학교교직원연금금액
		prtafirSchlDducSum.setValue(0L);	// 공적연금_사립학교직원연금공제금액

		spildtnPstoficAnty.setValue(0L);	// 공적연금_별정우체국연금금액
		spildtnPstoficDducSum.setValue(0L); // 공적연금_별정우체국연금공제금액_공제액

		prcspEmymtPrmmSum.setValue(0L);		// 종전근무지고용보험료금액
		prcspEmytPrmmDducSum.setValue(0L);	// 종전근무지고용보험료공제금액


		prcspStckEvntPrftSum.setValue(0L);	// D18_종전근무처주식매수선택권행사이익금액
		prcspEmpStkscWdrwSum.setValue(0L); 	// D19_종전근무처우리사주조합인출금액
		prcspEcteRsgtnExceSum.setValue(0L);	// D20_종전근무처임원퇴직소득한도초과금액

		prcspAggrSum.setValue(0L);    		// D22_종전근무처합계금액
		freeDtyAggrSum.setValue(0L);		// D53_비과세합계금액    
		reduIncmAggrSum.setValue(0L);    	// D54_감면소득합계금액
	    
	    prcspTxpyrAsocYn.reset();			// D8_종전근무처납세조합여부
	    prcspWhdgReipSumtYn.reset();		// 종전근무지원천징수영수증제출여부
	    prcspPrcsYn.reset();				// 종전근무지처리여부
	    
	    prcspYetaC165.setValue(0L);    		// C165_납부특례세액_소득세금액    
	    prcspYetaC166.setValue(0L);			// C166_납부특례세액_지방소득세금액 
	    prcspYetaC167.setValue(0L);    		// C167_납부특례세액_농특세금액    

	}

	
	/** 종전근무지 상세내역을 가져옴 **/
	private void yetaP13006ToYeta3200Detail(BaseModel selRecord) {
		
		hanNm01.setValue(MSFSharedUtils.allowNulls(selRecord.get("fnm")));
		
		dpobCd.setValue(MSFSharedUtils.allowNulls(selRecord.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
		yrtxBlggYr.setValue(MSFSharedUtils.allowNulls(selRecord.get("yrtxBlggYr")));    						/** column 귀속연도 : yrtxBlggYr */
		clutSeptCd.setValue(MSFSharedUtils.allowNulls(selRecord.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
		systemkey.setValue(MSFSharedUtils.allowNulls(selRecord.get("systemkey")));    							/** column SYSTEMKEY : systemkey */
		whdgDebrBusoprRgstnum.setValue(MSFSharedUtils.allowNulls(selRecord.get("whdgDebrBusoprRgstnum")));		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
		prcspSeilNum.setValue( MSFSharedUtils.allowNulls(selRecord.get("prcspSeilNum")));    					/** column D4_종전근무처일련번호 : prcspSeilNum */
		resnRegnNum.setValue(MSFSharedUtils.allowNulls(selRecord.get("resnRegnNum")));    						/** column D7_소득자주민등록번호 : resnRegnNum */

		prcspFmnmNm.setValue(MSFSharedUtils.allowNulls(selRecord.get("prcspFmnmNm")));    						/** column D9_종전근무처법인_상호명 : prcspFmnmNm */
		prcspBusoprRgstnum.setReadOnly(true);
		prcspBusoprRgstnum.setValue(MSFSharedUtils.allowNulls(selRecord.get("prcspBusoprRgstnum")));    		/** column D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
		
		prcspDutyBgnnDt.setValue(YetaUtils.getConvertStringToDate(
									MSFSharedUtils.allowNulls(selRecord.get("prcspDutyBgnnDt")), "yyyyMMdd"));	/** column D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
		prcspDutyEndDt.setValue(YetaUtils.getConvertStringToDate(
									MSFSharedUtils.allowNulls(selRecord.get("prcspDutyEndDt")), "yyyyMMdd"));	/** column D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
		prcspReduBgnnDt.setValue(YetaUtils.getConvertStringToDate(
									MSFSharedUtils.allowNulls(selRecord.get("prcspReduBgnnDt")), "yyyyMMdd"));	/** column D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
		prcspReduEndDt.setValue(YetaUtils.getConvertStringToDate(
									MSFSharedUtils.allowNulls(selRecord.get("prcspReduEndDt")), "yyyyMMdd"));	/** column D14_종전근무처감면기간종료일자 : prcspReduEndDt */
		
		prcspPaySum.setValue((Long) selRecord.get("prcspPaySum"));    											/** column D15_종전근무처급여금액 : prcspPaySum */
		prcspAllwBnusSum.setValue((Long) selRecord.get("prcspAllwBnusSum"));    								/** column D16_종전근무처상여금액 : prcspAllwBnusSum */
		prcspRcgtnBnusSum.setValue((Long) selRecord.get("prcspRcgtnBnusSum"));    								/** column D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
		prcspStckEvntPrftSum.setValue((Long) selRecord.get("prcspStckEvntPrftSum"));    						/** column D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
		prcspEmpStkscWdrwSum.setValue((Long) selRecord.get("prcspEmpStkscWdrwSum"));    						/** column D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
		prcspEcteRsgtnExceSum.setValue((Long) selRecord.get("prcspEcteRsgtnExceSum"));    						/** column D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
		prcspAggrSum.setValue((Long) selRecord.get("prcspAggrSum"));    										/** column D22_종전근무처합계금액 : prcspAggrSum */
		freeDtyAggrSum.setValue((Long) selRecord.get("freeDtyAggrSum"));    									/** column D53_비과세합계금액 : freeDtyAggrSum */
		reduIncmAggrSum.setValue((Long) selRecord.get("reduIncmAggrSum"));    									/** column D54_감면소득합계금액 : reduIncmAggrSum */
		
		prcspIncmTxSum.setValue((Long) selRecord.get("prcspIncmTxSum"));    									/** column D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
		prcspRgonIncmTxSum.setValue((Long) selRecord.get("prcspRgonIncmTxSum"));    							/** column D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
		prcspNnksSum.setValue((Long) selRecord.get("prcspNnksSum"));    										/** column D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
		
		prcspHlthPrmmSum.setValue((Long) selRecord.get("prcspHlthPrmmSum"));    								/** column 종전근무지건강보험료금액 : prcspHlthPrmmSum */
		prcspLgtmRcptnSum.setValue((Long)selRecord.get("prcspLgtmRcptnSum"));    								/** column 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
		prcspHlthLgcptnAggr.setValue((Long) selRecord.get("prcspHlthLgcptnAggr"));    							/** column 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
		prcspHlthPrmmDducSum.setValue((Long)selRecord.get("prcspHlthPrmmDducSum"));    							/** column 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
		prcspEmymtPrmmSum.setValue((Long) selRecord.get("prcspEmymtPrmmSum"));    								/** column 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
		prcspEmytPrmmDducSum.setValue((Long) selRecord.get("prcspEmytPrmmDducSum"));    						/** column 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
		
		prcspPrcsYn.setValue((Boolean) selRecord.get("prcspPrcsYn"));																		/** column 종전근무지처리여부 : prcspPrcsYn */
		YetaUtils.setCheckedCheckBoxValue(prcspWhdgReipSumtYn, MSFSharedUtils.defaultNulls( selRecord.get("prcspWhdgReipSumtYn"), "N"));	/** column 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
		YetaUtils.setCheckedCheckBoxValue(prcspTxpyrAsocYn, MSFSharedUtils.defaultNulls( selRecord.get("prcspTxpyrAsocYn"), "N"));			/** column D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */	
		
		natPennPrmmSum.setValue((Long) selRecord.get("natPennPrmmSum"));   									 	/** column 국민연금보험료금액 : natPennPrmmSum */
		natPennAraPrmmSum.setValue	((Long) selRecord.get("natPennAraPrmmSum"));    							/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
		natPennDducSum.setValue((Long) selRecord.get("natPennDducSum"));    									/** column 국민연금공제금액 : natPennDducSum */
		puoferAnty.setValue((Long) selRecord.get("puoferAnty"));   	 											/** column 공적연금_공무원연금금액 : puoferAnty */
		puoferAntyDducSum.setValue((Long) selRecord.get("puoferAntyDducSum"));    								/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
		mltymAnty.setValue((Long) selRecord.get("mltymAnty"));    												/** column 공적연금_군인연금금액 : mltymAnty */
		mltymAntyDducSum.setValue((Long) selRecord.get("mltymAntyDducSum"));    								/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
		prtafirSchlFalymmAnty.setValue((Long) selRecord.get("prtafirSchlFalymmAnty"));    						/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
		prtafirSchlDducSum.setValue((Long) selRecord.get("prtafirSchlDducSum"));    							/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
		spildtnPstoficAnty.setValue((Long) selRecord.get("spildtnPstoficAnty"));   					 			/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
		spildtnPstoficDducSum.setValue((Long) selRecord.get("spildtnPstoficDducSum"));    						/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
		
		prcspYetaC165.setValue((Long) selRecord.get("prcspYetaC165"));    										/** column C165_납부특례세액_소득세금액 : prcspYetaC165 */
		prcspYetaC166.setValue((Long) selRecord.get("prcspYetaC166"));    										/** column C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
		prcspYetaC167.setValue((Long) selRecord.get("prcspYetaC167"));    										/** column C167_납부특례세액_농특세금액 : prcspYetaC167 */
			
	}			

	@Override
	public void reload() {
		
		// TODO Auto-generated method stub

		IColumnFilter filters = null;
			
		YetaP83006GridPanel.getTableDef().setTableColumnFilters(filters);
		YetaP83006GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 연말정산귀속년도 
		
		YetaP83006GridPanel.getTableDef().addColumnFilter("clutSeptCd",clutSeptCd.getValue()
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 정산구분
		
		YetaP83006GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 시스템키
		
//		YetaP83006GridPanel.getTableDef().addColumnFilter("whdgDebrBusoprRgstnum", MSFSharedUtils.allowNulls(whdgDebrBusoprRgstnum.getValue())
//				, SimpleColumnFilter.OPERATOR_EQUALS); // 원천징수의무자사업자등록번호
		
		YetaP83006GridPanel.reload();

	}
	
	
	private void funcSetPopUpRecord() {

		BaseModel ppRecord = new BaseModel();
		
		ppRecord.set("dpobCd", dpobCd.getValue());
		ppRecord.set("clutSeptCd", clutSeptCd.getValue());
		ppRecord.set("systemkey", systemkey.getValue());
		ppRecord.set("yrtxBlggYr", yrtxBlggYr.getValue());
		ppRecord.set("hanNm", hanNm.getValue());
		ppRecord.set("deptNm", deptNm.getValue());
		ppRecord.set("whdgDebrBusoprRgstnum", whdgDebrBusoprRgstnum.getValue());
		ppRecord.set("prcspSeilNum", prcspSeilNum.getValue());

		setPPRecord(ppRecord);
	}
	
	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
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
}
