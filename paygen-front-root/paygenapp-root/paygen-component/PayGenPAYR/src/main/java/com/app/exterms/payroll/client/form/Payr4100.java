package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0500DTO;
import com.app.exterms.payroll.client.dto.Payr0530DTO;
import com.app.exterms.payroll.client.dto.Payr0540DTO;
import com.app.exterms.payroll.client.form.defs.Payr0220Def;
import com.app.exterms.payroll.client.form.defs.Payr0500Def;
import com.app.exterms.payroll.client.form.defs.Payr0520Def;
import com.app.exterms.payroll.client.form.defs.Payr0530Def;
import com.app.exterms.payroll.client.form.defs.Payr0540Def;
import com.app.exterms.payroll.client.form.defs.Psnl0123Def;
import com.app.exterms.payroll.client.form.defs.Psnl0130Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr4100Service;
import com.app.exterms.payroll.client.service.Payr4100ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0100Def;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.retirement.client.form.def.InfcPkgRemt3500Def;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
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
import com.extjs.gxt.ui.client.event.FieldEvent;
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
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr4100  extends MSFPanel { 



/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;	  
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

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
	      private PayrConstants lblPayrConst = PayrConstants.INSTANCE; 

		  private VerticalPanel vp;
		  private FormPanel plFrmPayr4100;
		  //private FormData formData; 
		  private String txtForm = "";
		 
		  
		  private  FieldSet fldstNewFieldset_2;
		  private FieldSet fldstNewFieldset_1;
		  private  TabPanel tabsPsnl;
		  private  TabPanel  tabsPsnlTop;
		   
		  private PrgmComPsnl0100Def psnl0100Def  = new PrgmComPsnl0100Def("PAYR4100");   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel psnl0100GridPanel;
		   
		  //기본정보 
		  private Payr0500Def payr0500Def  = new Payr0500Def("");   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0500GridPanel;
	 
		 //가족사항및학비보조 
		  private Payr0530Def payr0530Def  = new Payr0530Def("");   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0530GridPanel;
		  
		 //수당-공제 
		  private Payr0520Def payr0520Def  = new Payr0520Def("");   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0520GridPanel;
	 
//        //걔별공제 
//		  private Payr0200Def payr0200Def  = new Payr0200Def("PAYR0200");   //그리드 테이블 컬럼 define  
//		      // private MSFCustomForm msfCustomForm; 
//		  private MSFGridPanel payr0200GridPanel;
          private Payr0520Def payr0520DducDef  = new Payr0520Def("");   //그리드 테이블 컬럼 define  
          // private MSFCustomForm msfCustomForm; 
          private MSFGridPanel payr0520DducGridPanel;
		  
         //지급계좌정보 
		  private Psnl0130Def psnl0130Def  = new Psnl0130Def("PAYR4100");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	      private MSFGridPanel psnl0130GridPanel;
	     
	      //채권압류 
	      private Payr0220Def payr0220Def  = new Payr0220Def("PAYR4100");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	      private MSFGridPanel payr0220GridPanel;
	      
	      //TODO  퇴직정산 완료시 추가 할것.  
	      private InfcPkgRemt3500Def remt3500Def  = new InfcPkgRemt3500Def("PAYR4100");   //그리드 테이블 컬럼 define  
          // private MSFCustomForm msfCustomForm; 
          private MSFGridPanel remt3500GridPanel; 
	      
	      //휴직처리 
	      private Psnl0123Def psnl0123Def  = new Psnl0123Def();   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	      private MSFGridPanel psnl0123GridPanel;
	      
	      //예외처리-건강보험...
		  private Payr0540Def payr0540Def  = new Payr0540Def();   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0540GridPanel;
	       
		  //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
		   
	      //지급년도 
	      private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
	      private MSFGridPanel payYrGridPanel;

		  
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
      private ButtonBar topPayr4100Bar;
      private Button btnPayr4100Init;
     // private Button btnPayr4100Save;
     // private Button btnPayr4100Del;
      private Button btnPayr4100Sreach;
      private Button btnPayr4100AddIncmTxApptn;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
	private ComboBox<BaseModel> srhPayrMangDeptCd; // 단위기관
	private ComboBox<BaseModel> srhEmymtDivCd; // 고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; // 호봉제구분코드

	// private ComboBox<BaseModel> srhTypOccuCd; //직종
	// private HiddenField<String> srhPyspGrdeCd; //호봉등급
	// private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세

	private ComboBox<BaseModel> srhDeptGpCd; // 부서직종그룹코드
	private MSFMultiComboBox<ModelData> srhTypOccuCd; // 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세

	private MSFMultiComboBox<ModelData> srhDeptCd; // 부서
	// private ComboBox<BaseModel> srhDeptCd ; //부서
	// private TextField<String> srhDeptCd; //부서코드
	// private TextField<String> srhDeptNm; //부서명
	// private Button btnSrhDeptCd;
	// private TextField<String> srhMangeDeptCd; //관리부서 수정
	// private TextField<String> srhMangeDeptNm; //관리부서 수정

	private ComboBox<BaseModel> srhBusinCd; // 사업
	private TextField<String> srhHanNm; // 성명
	private TextField<String> srhResnRegnNum; // 주민번호
	private HiddenField<String> srhSystemkey; // 시스템키
	// private ComboBox<BaseModel> srhHdofcCodtnCd; //재직상태
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; // 재직상태

	private ComboBox<BaseModel> srhPayrYr01;
	private ComboBox<BaseModel> srhPayrYr02;

	private ComboBox<BaseModel> creYetaDpcd; // 원천신고부서
	private ComboBox<BaseModel> creBusoprRgstnum; // 사업자등록번호

	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

	private Boolean emptyCheck = false ;
	private boolean mutilCombo = false;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
 
      private HiddenField<String>  systemkey;        /**  column SYSTEMKEY : systemkey */
      private HiddenField<String>	dpobCd ;         /**  column 사업장코드 : dpobCd */
                                          
		                        
      private TextField<String>	hanNm  ;                      /**  column 한글성명 : hanNm */
      private TextField<String> resnRegnNum  ;                /**  column 주민등록번호 : resnRegnNum */
      private HiddenField<String> secRegnNum  ;                /**  column 주민등록번호 : secRegnNum */
      
      private TextField<String> typOccuNm  ;                  /**  column 직종코드 : typOccuNm */
      private TextField<String> dtilOccuClsDivNm  ;           /**  column 직종세구분코드 : dtilOccuClsDivNm */
      private TextField<String> emymtDivNm ;                  /**  column 고용구분 : emymtDivNm */
      private HiddenField<String> emymtDivCd ;                  /**  column 고용구분코드 : emymtDivCd */
      
      private HiddenField<String>      payrMangDeptCd  ;                /**  column 관리부서코드 : payrMangDeptCd */ 
      private HiddenField<String>      payrMangDeptNm  ;                /**  column 관리부서코드 : payrMangDeptNm */ 
      private TextField<String>        currAffnDeptNm  ;       /**  column 현소속부서코드 : currAffnDeptNm */
      private TextField<String>        businNm  ;                     /**  column 사업코드 : businNm */
      private TextField<String> 	   frstEmymtDt  ;                         /**  column 최초고용일자 : frstEmymtDt */
    //  private TextField<String>      logSvcYrNumNm  ;                           /**  column 근속년수 : logSvcYrNumNm */
      private ComboBox<BaseModel>      logSvcYrNumCd  ;                           /**  column 근속년수코드 : logSvcYrNumCd */
      private ComboBox<BaseModel>      logSvcMnthIcmCd  ;                           /**  column 근속월수코드 : logSvcYrNumNm */
       
      
      private ComboBox<BaseModel>      pyspCd  ;                           /**  column 호봉 : pyspCd */
      private CheckBox      unnMbspSttYn  ;                           /**  column 노조가입여부 : unnMbspSttYn */
      
      
      private HiddenField<String> typOccuCd  ;                  /**  column 직종코드 : typOccuCd */
      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
      private HiddenField<String>      currAffnDeptCd  ;       /**  column 현소속부서코드 : currAffnDeptCd */
      private HiddenField<String> businCd  ;                     /**  column 사업코드 : businCd */
      
    //  private HiddenField<String>  pyspGrdeCd;  /** column 호봉등급코 : pyspGrdeCd */
       
		                        
      private  TextField<String> logSvcMnthIcmNm;                             /**  column 근속월수 : logSvcMnthIcmNm */
      private TextField<String> 	hdofcCodtnNm;                          /**  column 재직상태코드 : hdofcCodtnNm */
      private TextField<String> retryDt;                     /**  column 퇴직일자 : retryDt */
		                        
      private CheckBox wmnYn;                               /**  column 부녀자여부 : wmnYn */
      private CheckBox 	retryClutYn;                           /**  column 퇴직정산여부 : retryClutYn */
      private CheckBox 	payRcptYn;                       /**  column 급여대상자여부 : payRcptYn */
		               
      private CheckBox dayWorkYn;                               /**  column 일용직여부 : dayWorkYn */
      private CheckBox payrIncmExceYn ;                               /**  column 급여소득세제외여부 : payrIncmExceYn */
      
      private CheckBox   hlthInsrApptnYn ;                            /**  column 건강보험적용여부 : hlthInsrApptnYn */
      private CheckBox 	natPennApptnYn;                             /**  column 국민연금적용여부 : natPennApptnYn */
      private  CheckBox 	umytInsrApptnYn;                              /**  column 고용보험적용여부 : umytInsrApptnYn */
      private   HiddenField<Boolean> 	idtlAccdtInsurApptnYn ;                                   /**  column 산재보험적용여부 : idtlAccdtInsurApptnYn */
		                        
      private NumberField hlthInsrMnthRuntnAmnt;                                   /**  column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
      private NumberField natPennStdIncmMnthAmnt;                                    /**  column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
      private NumberField umytInsrPayMnthAmnt;                                    /**  column 고용보수월액 : umytInsrPayMnthAmnt */
      private NumberField idtlAccdtPayMnthAmnt;                                    /**  column 산재보수월액 : idtlAccdtPayMnthAmnt */
      
      private TextField<String> currDeptAppmtDt;                             /**  column 현_부서발령일자 : currDeptAppmtDt */
      private TextField<String> yoobhMnthDay;                          /**  column 생년월일 : yoobhMnthDay */
      private TextField<String> natnNm;                                /**  column 국가코드 : natnCd */
		                        
      private TextField<String> logSvcStdDt;                           /**  column 근속기준일자 : logSvcStdDt */
      private HiddenField<Boolean>  logSvcExtpyApptnYn ;                                /**  column 근속수당적용여부 : logSvcExtpyApptnYn */
		                        
      private TextField<String> husPhnNum;                           /**  column 집전화번호 : husPhnNum */
      private TextField<String> cellPhneNum ;                        /**  column 핸드폰번호 : cellPhneNum */
		                        
      private TextField<String> emailAddr;                           /**  column 이메일주소 : emailAddr */
                                                      
      private TextField<String> husRoadNmZpcd ;                      /**  column 집도로명우편번호 : husRoadNmZpcd */
		                        
      private   TextField<String> husRoadNmFndtnAddr;                /**  column 집도로명기본주소 : husRoadNmFndtnAddr */
		                        
      private  TextField<String> husRoadNmDtlPatrAddr;               /**  column 집도로명상세주소 : husRoadNmDtlPatrAddr */
      
      private NumberField mnthPayDlywagSum;                          /**  column 월급여일당금액 :  */
      
      private ComboBox<BaseModel> addIncmTxApptnRtoCd;              /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
     

      private ComboBox<BaseModel> addIncmTxApptnYr;  /** set 추가소득세적용년 : addIncmTxApptnYrMnth */
      private ComboBox<BaseModel> addIncmTxApptnMnth;  /** set 추가소득세적용월 : addIncmTxApptnYrMnth */ 
      private HiddenField<String> addIncmTxApptnYn;   /** set 추가소득세적용여부 : addIncmTxApptnYn */
      
       
      private HiddenField<String> befIncmTxApptnRtoCd;              /** set  이전 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
      private HiddenField<String> befIncmTxApptnYr;  /** set 이전 추가소득세적용년 : befIncmTxApptnYrMnth */
      private HiddenField<String> befIncmTxApptnMnth;  /** set 이전 추가소득세적용월 : befIncmTxApptnYrMnth */ 
      private HiddenField<String> befIncmTxApptnYn;   /** set 이전 추가소득세적용여부 : befIncmTxApptnYn */
      
      private HiddenField<Long> addIncmTxApptnCnt;   /** set   추가소득세적용개수 : addIncmTxApptnCnt */
      
 
 
     private boolean boolPymtDduc = false;
     
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
	  private void checkPayr4100Auth( String authAction, ListStore<BaseModel> bm) {   
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
			   //------------------
			//----------------------------------------------------
             Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
           
     	    gwtAuthorization.formAuthFieldConfig(fldArrField);
     	    
     	    
     	    srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
             srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
             
             addIncmTxApptnYr.setValue(lsAddIncmTxApptnYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
         	addIncmTxApptnMnth.setValue(lsAddIncmTxApptnMnth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
            /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
           * 권한설정을 위한 콤보처리를 위한 메서드 시작 
           * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
           ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
          //  String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
           // GWTAuthorization.formAuthPopConfig(plFrmPayr4100, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
          //  GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			 //  gwtAuthorization.formAuthConfig(plFrmPayr4100, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
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
		     
		     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
		     authMapDef.put("srhHdofcCodtnCd",Boolean.FALSE);
			 authMapDef.put("addIncmTxApptnYr",Boolean.FALSE);
			 authMapDef.put("addIncmTxApptnMnth",Boolean.FALSE);
			     
		     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
		     authMapDef.put("srhDeptCd",Boolean.FALSE); 
		     authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
		     //authMapDef.put("srhTypOccuCd",Boolean.FALSE); 
			 
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
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr4100FormBinding() {
	 	 
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
	    //입력수정삭제처리 rpc 처리부     
	    private Payr4100ServiceAsync payr4100Service = Payr4100Service.Util.getInstance();	    
	 
	    private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>();	// 단위기관 
		private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	// 고용구분 
		private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	// 호봉제구분코드 
  		
		//--------------------부서 불러 오는 함수 ------------------------------------------------
 	 	private ListStore<BaseModel> lsDeptCd  				= new ListStore<BaseModel>();	// 부서콤보
 		//--------------------부서 불러 오는 함수 ------------------------------------------------
 	 	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
 	 	
 		//--------------------사업 불러 오는 함수 -------------------------------------------------
 		private ListStore<BaseModel> lsBusinCd  			= new ListStore<BaseModel>();	// 사업콤보   
 		//--------------------사업 불러 오는 함수 -------------------------------------------------
 		private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	// 부서직종그룹코드  
 		private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	// 직종 
 		private ListStore<BaseModel> lsHdofcCodtnCd 		= new ListStore<BaseModel>(); 	// 재직상태 
 		
 		private ListStore<BaseModel> lsLogSvcYrNumCd   		= new ListStore<BaseModel>(); 	//근속년수코드  
 		private ListStore<BaseModel> lsLogSvcMnthIcmCd   	= new ListStore<BaseModel>(); 	//근속월수코드   
 		private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	//직종세
 		 
 		private ListStore<BaseModel> lsPayYrStore01 		= new ListStore<BaseModel>();  	// 년도
 		private ListStore<BaseModel> lsPayYrStore02 		= new ListStore<BaseModel>();  	// 년도
 		private ListStore<BaseModel> listStoreA005 			= new ListStore<BaseModel>();  	// 호동
 		
 		private ListStore<BaseModel> lsAddIncmTxApptnYr 	= new ListStore<BaseModel>();	/** set 추가소득세적용년 : addIncmTxApptnYrMnth */
 		private ListStore<BaseModel> lsAddIncmTxApptnMnth 	= new ListStore<BaseModel>();   /** set 추가소득세적용월 : addIncmTxApptnYrMnth */
 		private ListStore<BaseModel> lsAddIncmTxApptnRtoCd	= new ListStore<BaseModel>();   /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
 		
 		private ListStore<BaseModel> lsYetaDpcd  			= new ListStore<BaseModel>();	// 원천징수부서코드  
 		private ListStore<BaseModel> lsBusoprRgstnum  		= new ListStore<BaseModel>();	// 사업자등록번호  
 		
 		private PrgmComBass0300DTO sysComBass0300Dto; 	//공통코드 dto
 	 	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
 		private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
 		private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
 		private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
 		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
 		
 		private SysCoCalendarDTO msfCoCalendarDto;   
 		
  	    private BaseModel record;
    
  	    private BaseModel ppRecord; //팝업에 넘길 레코드 값 
  	  
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr4100(){
//    	payr0301GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr4100List(bass0200Dto, new AsyncCallback<List<Payr4100BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr4100(): "+caught), null);
//                msfPayr4100GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr4100BM> result) {
//            	composedPayr4100List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr4100List(List<Payr4100BM> listaMenu) {
//        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//        BaseTreeModel folder = new BaseTreeModel();
//        BaseTreeModel category = null;
//        while ( iter.hasNext() ) {
//        	Sysm0200BM mnu = iter.next();
//            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
//            BaseTreeModel bm = new BaseTreeModel();
//            bm.set("sysDivCd", mnu.getSysDivCd());
//            bm.set("mnuCd", mnu.getMnuCd());
//            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
//            bm.set("mnuNm", mnu.getMnuNm());
//            bm.set("mnuIcn", mnu.getMnuIcn()); 
//            bm.set("mnuTmbl", mnu.getMnuTmbl());
//            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
//            bm.set("mnuTipNm", mnu.getMnuTipNm());
//            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
//            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
//            bm.set("mnuPrntOrd", ord);
//            bm.set("useYn", mnu.getUseYn());
//            bm.set("mnuEpln", mnu.getMnuEpln());
//             
//            if (mnu.getHhrkMnuCd() == null) {
//                category = new BaseTreeModel();
//                category.setProperties(bm.getProperties());
//                folder.add(category);
//            } else {
//                if (category != null) {
//                    category.add(bm);
//                }
//            }
//        } 
//        msfPayr4100GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr4100Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr4100Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnPayr4100Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
//	  
//    private void doAction(ActionDatabase actionDatabase) {
//        switch (actionDatabase) {
//        case INSERT:
//            GestioneVociMenu caricaVmn = new GestioneVociMenu(ActionDatabase.INSERT, getThis());
//            MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show(); 
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(new BaseModel());
//            caricaVmn.pulisci();
//            break;
//        case UPDATE:
//            caricaVmn = new GestioneVociMenu(ActionDatabase.UPDATE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtModification(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	   
//            break;
//        case DELETE:
//            caricaVmn = new GestioneVociMenu(ActionDatabase.DELETE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtCancel(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtCancel(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();  
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	            	
//            break;
//        }
//    }
	
	  /**
     * 기본정보저장처리
     */
    private void saveStandData() {
        
        if (MSFSharedUtils.paramNull(systemkey.getValue())) {
            return;
        }
         
        Payr0500DTO payr0500Dto = new Payr0500DTO(); 

        payr0500Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
        payr0500Dto.setSystemkey(systemkey.getValue());		/** column SYSTEMKEY : systemkey */
        payr0500Dto.setSoctyInsurYr(PayGenConst.ACC_CURR_YEAR); //TODO 회계년도 물고 있을것
        payr0500Dto.setPayrMangDeptCd(payrMangDeptCd.getValue());	/** column 급여관리부서코드 : payrMangDeptCd */
        payr0500Dto.setEmymtDivCd(emymtDivCd.getValue());	/** column 고용구분코드 : emymtDivCd */
        payr0500Dto.setLogSvcStdDt(MSFSharedUtils.allowNulls(logSvcStdDt.getValue()).replace(".", ""));	/** column 근속기준일자 : logSvcStdDt */
        payr0500Dto.setWmnYn(wmnYn.getValue());    			/** column 부녀자여부 : wmnYn */
        payr0500Dto.setRetryClutYn(retryClutYn.getValue());	/** column 퇴직정산여부 : retryClutYn */
        payr0500Dto.setPayRcptYn(payRcptYn.getValue());    	/** column 급여대상자여부 : payRcptYn */
      // payr0500Dto.setSpueYn(spueYn.getValue());   /** column 배우자유무 : spueYn */
        payr0500Dto.setHlthInsrApptnYn(hlthInsrApptnYn.getValue());		/** column 건강보험적용여부 : hlthInsrApptnYn */
        payr0500Dto.setNatPennApptnYn(natPennApptnYn.getValue());    	/** column 국민연금적용여부 : natPennApptnYn */
        payr0500Dto.setUmytInsrApptnYn(umytInsrApptnYn.getValue());    	/** column 고용보험적용여부 : umytInsrApptnYn */
        payr0500Dto.setIdtlAccdtInsurApptnYn(idtlAccdtInsurApptnYn.getValue());    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
       // payr0500Dto.setSuprtFamyNumTwenChDn(.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
        //payr0500Dto.setSuprtFamyNumTreOvrChdnYn(.getSuprtFamyNumTreOvrChdnYn());    /** column 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
       // payr0500Dto.setSuprtFamyNumEtc(.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
       // payr0500Dto.setChdnSchlExpnAdmclYn(.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */ 
        payr0500Dto.setLogSvcExtpyApptnYn(logSvcExtpyApptnYn.getValue());	/** column 근속수당적용여부 : logSvcExtpyApptnYn */
        payr0500Dto.setMnthPayDlywagSum((Long)mnthPayDlywagSum.getValue());	/** column 월급여일당금액 : mnthPayDlywagSum */
         
        payr0500Dto.setHlthInsrMnthRuntnAmnt((Long)hlthInsrMnthRuntnAmnt.getValue());     				/**  column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
        payr0500Dto.setNatPennStdIncmMnthAmnt((Long)natPennStdIncmMnthAmnt.getValue());           		/**  column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
        payr0500Dto.setUmytInsrPayMnthAmnt((Long)umytInsrPayMnthAmnt.getValue());                		/**  column 고용보수월액 : umytInsrPayMnthAmnt */
        payr0500Dto.setIdtlAccdtPayMnthAmnt((Long)umytInsrPayMnthAmnt.getValue());               		/**  column 산재보수월액 : idtlAccdtPayMnthAmnt */ 
        payr0500Dto.setLogSvcYrNumCd(MSFSharedUtils.getSelectedComboValue(logSvcYrNumCd,"commCd"));		/**  column 근속년수코드 : logSvcYrNumCd */
        payr0500Dto.setLogSvcMnthIcmCd(MSFSharedUtils.getSelectedComboValue(logSvcMnthIcmCd,"commCd")); /**  column 근속월수코드 : logSvcYrNumNm */ 
        payr0500Dto.setDayWorkYn(dayWorkYn.getValue());  												/**  column 일용직구분 : dayWorkYn */ 
        payr0500Dto.setPayrIncmExceYn(payrIncmExceYn.getValue());  												/**  column 일용직구분 : dayWorkYn */ 
        
        
        payr0500Dto.setAddIncmTxApptnRtoCd(MSFSharedUtils.getSelectedComboValue(addIncmTxApptnRtoCd,"commCd"));		/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
        payr0500Dto.setAddIncmTxApptnYrMnth(MSFSharedUtils.getSelectedComboValue(addIncmTxApptnYr,"year").concat(MSFSharedUtils.getSelectedComboValue(addIncmTxApptnMnth,"month")));    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
        payr0500Dto.setAddIncmTxApptnYn(addIncmTxApptnYn.getValue());    /** column 추가소득세적용여부 : addIncmTxApptnYn */
        
        payr0500Dto.setLogSvcMnthIcmCd(MSFSharedUtils.getSelectedComboValue(logSvcMnthIcmCd,"commCd"));	/**  column 근속월수코드 : logSvcYrNumNm */ 
      //  payr0500Dto.setDayWorkYn(dayWorkYn.getValue())  ;                                  				/**  column 일용직구분 : dayWorkYn */ 
        
        payr0500Dto.setPyspCd(MSFSharedUtils.getSelectedComboValue(pyspCd,"commCd"));					/**  column 호봉 : pyspCd */ 
        payr0500Dto.setUnnMbspSttYn(PayrUtils.getCheckedCheckBoxYnValue(unnMbspSttYn));	/**  column 노조가입여부 : unnMbspSttYn */ 
        
        
        
//        payr0500Dto.setKybdr(changePsnl0123List.get(i).getKybdr());    /** column 입력자 : kybdr */
//        payr0500Dto.setInptDt(changePsnl0123List.get(i).getInptDt());    /** column 입력일자 : inptDt */
//        payr0500Dto.setInptAddr(changePsnl0123List.get(i).getInptAddr());    /** column 입력주소 : inptAddr */
//        payr0500Dto.setIsmt(changePsnl0123List.get(i).getIsmt());    /** column 수정자 : ismt */
//        payr0500Dto.setRevnDt(changePsnl0123List.get(i).getRevnDt());    /** column 수정일자 : revnDt */
//        payr0500Dto.setRevnAddr(changePsnl0123List.get(i).getRevnAddr());    /** column 수정주소 : revnAddr */
        
        payr4100Service.activityOnUpdatePayr4100Save(payr0500Dto ,
                new AsyncCallback<Long>() {
        public void onFailure(Throwable caught) {
        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdatePayr4100Save(저장(수정)) : " + caught), null);
        }
        public void onSuccess(Long result) { 
        if (result == 0) {
           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                   "수정처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
        } else {
           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                    "수정처리가 완료되었습니다.", null);
           reload();
        } 
        } 
        });
        
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
//	private void Payr4100Print(String fileName) {
// 
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PAYR";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		// 보낼 파라미터
//		
//		
//		//검색조건
// 	String serarchParam = "";
////		
////		String name = searchName.getValue() == null ? "" : searchName.getValue();
////		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////		
////		serarchParam += "["+name+"]";
////		serarchParam += "["+resn+"]";
////		serarchParam += "["+hdofcCodtnCd+"]";
////		serarchParam += "[]";
////		//serarchParam += "["+manageDeptCd+"]";
////		serarchParam += "["+deptCd+"]";
////		serarchParam += "["+emymtDivCd+"]";
////		serarchParam += "["+typOccuCd+"]";
//		
//		List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
//		String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//		
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//
//	}

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
				 
			    
				   // formData = new FormData("-650");
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				    createPayr4100Form();  //화면 기본정보를 설정
				    createSearchForm();    //검색필드를 적용
				    createStandardForm();    //기본정보필드  
				    occupationalRTop();
				    createTabForm();
				    
				    //엣지변환
				    //vp.setSize("1010px", "700px"); 
				    vp.setSize("1010px", "750px"); 
				    
				    fnAddIncmTxApptnReadOnly(true);
				    
				    /**
			          * Create the relations 
			          */
					   final RelationDef  relPsnl0100 = new RelationDef(psnl0100Def,false);
					   relPsnl0100.addJoinDef("dpobCd", "dpobCd"); 
					   relPsnl0100.addJoinDef("systemkey", "systemkey"); 
					   relPsnl0100.setLinkedObject(psnl0100GridPanel);
					   payr0500Def.addRelation(relPsnl0100); 
			           
			 
			           // DETAILS 
			           final Grid psnl0100Grid = psnl0100GridPanel.getMsfGrid().getGrid();
			           psnl0100Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (psnl0100GridPanel.getCurrentlySelectedItem() != null) { 
			            		 
			            		  payr0500Def.synchronizeGridDetail(psnl0100GridPanel.getCurrentlySelectedItem(),payr0500GridPanel ); 
			            	   }
			            	  tabsPsnlTop.setSelection(tabsPsnlTop.getItem(0));
			                 // payr0500GridPanel.reload(); 
			            	  
			           }
			      });  
				    
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
	  public Payr4100() {
		   
		  //엣지변환
		  //setSize("1010px", "700px");  
			setSize("1010px", "750px");  
	  } 
	
	  public Payr4100(String txtForm) {
			this.txtForm = txtForm;
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
	  private void createPayr4100Form() {
		  
			plFrmPayr4100 = new FormPanel();
			plFrmPayr4100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr4100());
		//	plFrmPayr4100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여대상자관리");
			plFrmPayr4100.setIcon(MSFMainApp.ICONS.text());
			plFrmPayr4100.setBodyStyleName("pad-text");
			plFrmPayr4100.setPadding(2);
			plFrmPayr4100.setFrame(true); 
	 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblPayrConst.title_Payr4100(),"PAYR4100");
					}
				});
			plFrmPayr4100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr4100.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

            //멀티콤보박스 닫기 
	        plFrmPayr4100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) { 
	            
	             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                        
	            //        if (f instanceof MSFMultiComboBox<?>) {
	                        
//	                        if ("srhDeptCd".equals(f.getName())) {
//	                            
//	                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                            
//	                        }
                            
                  //      } else {
	                   if (mutilCombo) {
                            if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                                srhDeptCd.showClose(ce);
                                mutilCombo = false;
                            } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
                                srhHdofcCodtnCd.showClose(ce);
                                mutilCombo = false;
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
	        
			 LayoutContainer layoutContainer = new LayoutContainer();
			  layoutContainer.setLayout(new ColumnLayout());
			  
			  LayoutContainer layoutContainer_1 = new LayoutContainer(); 
			  layoutContainer_1.setLayout(new FlowLayout());
			  
			  ButtonBar  btnSideBar = new ButtonBar();
			  
			  Button btnFmyTgt = new Button("가족수당대상자");
			  btnFmyTgt.setIcon(MSFMainApp.ICONS.search16());
			  btnSideBar.add(btnFmyTgt);
			  btnFmyTgt.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //가족수당대상자
		    			formFmyTgtPop();
		    		}
		        });  	 
			 
			  layoutContainer_1.add(btnSideBar);
			  layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			  layoutContainer_1.setBorders(false);
			  
			  LayoutContainer layoutContainer_2 = new LayoutContainer();
			  layoutContainer_2.setLayout(new FlowLayout());
			  
			   
			   topPayr4100Bar = new ButtonBar();    
			   layoutContainer_2.add(topPayr4100Bar);
			   topPayr4100Bar.setAlignment(HorizontalAlignment.RIGHT);
			 
		  	
			   btnPayr4100Init = new Button("초기화");  
			   btnPayr4100Init.setIcon(MSFMainApp.ICONS.new16());
			  	topPayr4100Bar.add(btnPayr4100Init);
			  	btnPayr4100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		        });  	 
			  	 
			  	btnPayr4100Sreach = new Button("조회"); 
			  	btnPayr4100Sreach.setIcon(MSFMainApp.ICONS.search16());
			  	topPayr4100Bar.add(btnPayr4100Sreach);
			  	btnPayr4100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
			  	
			  	btnPayr4100AddIncmTxApptn = new Button("추가소득세율관리"); 
			  	btnPayr4100AddIncmTxApptn.setIcon(MSFMainApp.ICONS.text());
			  	topPayr4100Bar.add(btnPayr4100AddIncmTxApptn);
			  	btnPayr4100AddIncmTxApptn.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    			payrP410004AddIncmTxApptn();
		    		}
		    	});
			  	
			  	
			  	
		    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_2.setBorders(false); 
		    layoutContainer.setBorders(false);
		  	
		    plFrmPayr4100.add(layoutContainer);    
		  	  
		  	
			//파일업로드 처리
			plFrmPayr4100.setAction("bizform");
			plFrmPayr4100.setEncoding(Encoding.MULTIPART);
			plFrmPayr4100.setMethod(Method.POST);
			
		
			vp.add(plFrmPayr4100);
			//엣지변환
			//plFrmPayr4100.setSize("990px", "680px");
			plFrmPayr4100.setSize("990px", "730px");
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
 /**
  * 검색필드 설정
  */
 private void createSearchForm() {   
      
       //  srhPyspGrdeCd = new HiddenField<String>(); 
         srhSystemkey = new HiddenField<String>();  //시스템키 
        
     
	     sysComBass0150Dto = new PrgmComBass0150DTO();
		 sysComBass0300Dto = new PrgmComBass0300DTO();
		 sysComBass0400Dto = new PrgmComBass0400DTO();
		 sysComBass0500Dto = new PrgmComBass0500DTO(); 
		 sysComBass0350Dto = new PrgmComBass0350DTO();
		 sysComBass0320Dto = new PrgmComBass0320DTO();
		 
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
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
                 mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
                 
             }
         });     
		 //--------------------급여부서 불러 오는 함수 ------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//TODO 안성시는 0호봉 사용 여부 확인 필요
		 //호봉
		 sysComBass0300Dto.setRpsttvCd("A005");
		 listStoreA005 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //호봉
		 sysComBass0300Dto.setRpsttvCd("A048");
		 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //재직상태  
		 sysComBass0300Dto.setRpsttvCd("A003");
		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
              public void handleEvent(StoreEvent<BaseModel> be) {  
                  mDtalistHdofcCodtnCd = PayrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
                  srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
                  
              }
          });   
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         //근무년수
         sysComBass0300Dto.setRpsttvCd("A007");
         lsLogSvcYrNumCd   = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         sysComBass0300Dto.setMangeItem02("");

         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
       //TODO 안성시는 0월 사용 여부 확인 필요
         //근무월수  
         sysComBass0300Dto.setRpsttvCd("A006");
         sysComBass0300Dto.setMangeItem02("Y");
         lsLogSvcMnthIcmCd  = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         sysComBass0300Dto.setMangeItem02("");
		 
		 
	   /**
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      * 직종 콤보박스 처리  시작
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	      */
 
	     	    
           lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                 
              }
          });  
		 
	    plFrmPayr4100.setLayout(new FlowLayout());
	    
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
		
	    fieldSet.setStyleAttribute("marginTop", "10px");
	    fieldSet.add(lcSchCol, new FormData("100%"));
	    
	    LayoutContainer layoutContainer_14 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer_14.setLayout(frmlytSch);
	    
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
		                	checkPayr4100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
               	 } 
                
            }
        });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	    	  //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
  	    	  sysComBass0400Dto = new PrgmComBass0400DTO(); 
  	    		
  	    	  sysComBass0400Dto.setDeptDspyYn("Y");
  	          sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  	          sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
  	          
  	          //--------------------부서 불러 오는 함수 ------------------------------------------------
  	          lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	          //--------------------부서 불러 오는 함수 ------------------------------------------------
  	          lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	             public void handleEvent(StoreEvent<BaseModel> be) {  
  	               mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
                   srhDeptCd.getInitStore().add(mDtalistDeptCd);
  	                 
  	             }
  	          });       
  	    	} 
  	    });
	    layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
	    layoutContainer_14.setBorders(false);
	    
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer(); 
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_1.setLayout(frmlytSch);
        
        srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
        srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
//        srhHdofcCodtnCd.setForceSelection(true);
//        srhHdofcCodtnCd.setMinChars(1);
//        srhHdofcCodtnCd.setDisplayField("commCdNm");
//        srhHdofcCodtnCd.setValueField("commCd");
       // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
        srhHdofcCodtnCd.setEmptyText("--재직선택--");
//        srhHdofcCodtnCd.setSelectOnFocus(true); 
        srhHdofcCodtnCd.setReadOnly(true);
        srhHdofcCodtnCd.setEnabled(true); 
       // srhHdofcCodtnCd.setStore(lsHdofcCodtnCd); 
        srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
        srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
        srhHdofcCodtnCd.setWidth(100);
     //   srhHdofcCodtnCd.setHeight(100);
        srhHdofcCodtnCd.setFieldLabel("재직상태");
        srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	checkPayr4100Auth("srhHdofcCodtnCd",lsHdofcCodtnCd); 
            }
        }); 
        srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
        layoutContainer_1.add(srhHdofcCodtnCd, new FormData("100%"));
        layoutContainer_1.setBorders(false); 
        
        
        LayoutContainer layoutContainer11 = new LayoutContainer(new ColumnLayout()); 
        
        LayoutContainer layoutContainer11_1 = new LayoutContainer(); 
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer11_1.setLayout(frmlytSch);
        
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
		                	checkPayr4100Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
                 pyspCd.setEnabled(false);  
                 unnMbspSttYn.setEnabled(false); 
             } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
            	 //20151130 추가 수정 
        	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
            	 srhBusinCd.reset();
                 srhBusinCd.setEnabled(false);   
                 pyspCd.setEnabled(true);  
                 unnMbspSttYn.setEnabled(true); 
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
        layoutContainer11_1.add(srhEmymtDivCd, new FormData("100%"));
        layoutContainer11.setBorders(false);
        layoutContainer11.add(layoutContainer11_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
        
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(true);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	    srhRepbtyBusinDivCd.setValueField("commCd");
	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
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
	    layoutContainer_101.setBorders(false);
        layoutContainer11.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        

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
//        }); 
        layoutContainer_6.add(srhHanNm, new FormData("100%"));
        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
        layoutContainer_6.setBorders(false);
        
        LayoutContainer lcBtn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        lcBtn.setLayout(frmlytSch);
        
        Button btnHanNm = new Button("검색");
//        layoutContainer_5.add(btnHanNm);
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                srhSystemkey.setValue("");
                srhResnRegnNum.setValue("");
                   
                 fnPopupPsnl0100() ;
                  
                  
            }
        });
        lcBtn.add(btnHanNm);
        
        layoutContainer_5.add(lcBtn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
        
        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_7.setLayout(frmlytSch);
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        srhResnRegnNum.setName("srhResnRegnNum");
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
        srhResnRegnNum.setLabelSeparator("");
        srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
                    srhSystemkey.setValue("");
                    srhHanNm.setValue("");
                }
             
            } 
      }); 
       // srhResnRegnNum.setFieldLabel("주민번호");
        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        
	     
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    lcSchCol.add(layoutContainer11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	    
	    
	    
	    
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
  	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
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
	      	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	      	    			} 
	      	    			
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
        
	    LayoutContainer layoutContainer = new LayoutContainer(); 
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer.setLayout(frmlytSch);
  
        //부서콤보 
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
        //srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
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
		                	checkPayr4100Auth("srhDeptCd", lsDeptCd); 
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
                                 //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                                }
                            });    
                      
                      } else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
   	            		 
                    	  //2015.11.30 권한 직종가져오기  추가 
	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	             
	                             mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	                           }
	                       });  
            	    
		              } else {
		            	  
		            	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		           		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		           		   sysComBass0320Dto.setDeptCd(strDeptCd);
		            	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		         		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		        	            public void handleEvent(StoreEvent<BaseModel> be) {  
		        	             
		                          mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
                
            } 
        });
 
        layoutContainer.add(srhDeptCd, new FormData("100%"));  
 
        layoutContainer.setBorders(false);
         
        
	    LayoutContainer layoutContainer_2 = new LayoutContainer(); 
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_2.setLayout(frmlytSch);
	    
	  //직종 직종세처리  
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
        
        
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
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
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_21.setLayout(frmlytSch); 
        
 
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setHideLabel(true);
        srhTypOccuCd.setWidth(100); 
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            
            	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
		    			//2015.11.30 추가 
		    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
	         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
		                      //         mdSelect = tpMdSelect;
		                         //  } 
		                     //  }  
		                   
		                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
		                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
		                   // }  
		    		   }    
	                 }  
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkPayr4100Auth("srhTypOccuCd", lsTypOccuCd); 
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
      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(1); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        frmlytSch.setDefaultWidth(0);
       // fieldSet.setLayout(layout);  
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
        layoutContainer_21.setBorders(false);
        
	    layoutContainer_2.add(lcTypOccuCd, new FormData("100%"));
	    layoutContainer_2.setBorders(false);
	    
	     
	   
	    layoutContainer_13.setBorders(false);  
	    layoutContainer_13.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	    layoutContainer_13.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
	    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
	  
	   
	    
	    fieldSet.add(layoutContainer_13);
	    
	    LayoutContainer layoutContainer_3 = new LayoutContainer();
	    layoutContainer_3.setLayout(new ColumnLayout());
	    
	    
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
   
	    
	    layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 //   layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	    layoutContainer_3.setBorders(false);
        
	    fieldSet.add(layoutContainer_3);  
		
	    plFrmPayr4100.add(fieldSet); 
	//vp.add(panel);   
 }  

 private void  displayDtilOccuInttnCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
         
         //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
             
             sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
             List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
             String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
             sysComBass0350Dto.setDeptCd(strDeptCd);
             List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
             String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
             sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
             
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
             
             if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                 
                 lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
               //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                 
                 lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                         mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
          
       } else {
        
       } 
     //직종변경에 따른 직종세 값 가져오기
//     String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//     if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//         sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//         sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//         if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//             lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//             srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//         }
//     }   
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
 private void createStandardForm() {
	  
        systemkey = new HiddenField<String>();  //시스템키 
        payrMangDeptCd = new  HiddenField<String>(); 
        payrMangDeptNm = new  HiddenField<String>(); 
        dpobCd = new HiddenField<String>();  //사업장코드 
        idtlAccdtInsurApptnYn = new HiddenField<Boolean>() ; 
        logSvcExtpyApptnYn =  new HiddenField<Boolean>() ;
        
        typOccuCd =  new HiddenField<String>() ;
        dtilOccuInttnCd =  new HiddenField<String>() ;
        currAffnDeptCd =  new HiddenField<String>() ;
        businCd =  new HiddenField<String>() ;
    //    pyspGrdeCd =  new HiddenField<String>() ;
        addIncmTxApptnYn = new HiddenField<String>();
        
        befIncmTxApptnRtoCd= new HiddenField<String>();              /** set  이전 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
        befIncmTxApptnYr= new HiddenField<String>();  /** set 이전 추가소득세적용년 : befIncmTxApptnYrMnth */
        befIncmTxApptnMnth= new HiddenField<String>();  /** set 이전 추가소득세적용월 : befIncmTxApptnYrMnth */ 
        befIncmTxApptnYn= new HiddenField<String>();   /** set 이전 추가소득세적용여부 : befIncmTxApptnYn */
        
        addIncmTxApptnCnt= new HiddenField<Long>();  /** set   추가소득세적용개수 : addIncmTxApptnCnt */
        
        msfCoCalendarDto = new SysCoCalendarDTO();
        
        
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     	 //추가소득세울
     	 sysComBass0300Dto.setRpsttvCd("B029");
     	 lsAddIncmTxApptnRtoCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
     	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     	 
     	//--------------------급여년도 불러 오는 함수 ------------------------------------------------
     	 lsAddIncmTxApptnYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
     	 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
          
     	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     	 //월 
     	 
     	 lsAddIncmTxApptnMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
     	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     	 
          
        
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		//엣지변환
		//fldstNewFieldset.setSize("330px", "500px");
		fldstNewFieldset.setSize("330px", "550px");
		
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("대상자정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_1.setBorders(false);
		layoutContainer_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		fldstNewFieldset_1 = new FieldSet();
		//엣지변환
		//fldstNewFieldset_1.setSize(625, 240);
		fldstNewFieldset_1.setSize(625, 290);
		

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("기본상세정보");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
		//fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
		 
		
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_2.setBorders(false);
		
	    fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(625, 250);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("급여내역정보");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_2.setBorders(false);
		 
		    
		plFrmPayr4100.add(layoutContainer);
		layoutContainer.setBorders(false); 
		    
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
 //기본사항 
 private void occupationalRTop() {
	  
         payr0500GridPanel = new MSFGridPanel(payr0500Def, false, false, false, false);
         payr0500GridPanel.setHeaderVisible(false);  
         payr0500GridPanel.setBodyBorder(true);
         payr0500GridPanel.setBorders(true); 
         payr0500GridPanel.setVisible(false);
         payr0500GridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
         public void handleEvent(StoreEvent<BaseModel> be) {  
                
             if (payr0500GridPanel.getMsfGrid().getStore().getCount() > 0) {  
                 
               BaseModel bmData = payr0500GridPanel.getMsfGrid().getStore().getModels().get(0);  
           
               setPPRecord(bmData); //팝업에 넘길값 
               
               systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey"))); /** column SYSTEMKEY : systemkey */
               dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));   /** column 사업장코드 : dpobCd */ 
               
               hanNm.setValue(MSFSharedUtils.allowNulls(bmData.get("hanNm"))); /** column 한글성명 : hanNm */
               resnRegnNum.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum")));  /** column 주민등록번호 : resnRegnNum */
               secRegnNum.setValue(MSFSharedUtils.allowNulls(bmData.get("secRegnNum")));  /** column 주민등록번호 : resnRegnNum */
               typOccuNm.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuNm")));  /** column 직종코드 : typOccuNm */
               dtilOccuClsDivNm.setValue(MSFSharedUtils.allowNulls(bmData.get("dtilOccuClsDivNm")));  /** column 직종세구분코드 : dtilOccuClsDivNm */
               
               emymtDivCd.setValue(MSFSharedUtils.allowNulls(bmData.get("emymtDivCd")));  /** column 고용구분코드 : emymtDivCd */
               emymtDivNm.setValue(MSFSharedUtils.allowNulls(bmData.get("emymtDivNm")));  /** column 고용구분 : emymtDivNm */
               
               payrMangDeptCd.setValue(MSFSharedUtils.allowNulls(bmData.get("payrMangDeptCd")));  /** column 관부서코드 : payrMangDeptCd */ 
               payrMangDeptNm.setValue(MSFSharedUtils.allowNulls(bmData.get("payrMangDeptNm")));  /** column 관부서코드 : payrMangDeptNm */ 
          
               typOccuCd.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuCd")));  /** column 직종코드 : typOccuNm */
               dtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dtilOccuInttnCd")));  /** column 직종세구분코드 : dtilOccuClsDivNm */
               currAffnDeptCd.setValue(MSFSharedUtils.allowNulls(bmData.get("currAffnDeptCd")));  /** column 현소속부서코드 : currAffnDeptNm */
               businCd.setValue(MSFSharedUtils.allowNulls(bmData.get("businCd")));   /** column 사업코드 : businNm */
             //  pyspGrdeCd.setValue(MSFSharedUtils.allowNulls(bmData.get("pyspGrdeCd")));   /** column 호봉등급코 : pyspGrdeCd */
               currAffnDeptNm.setValue(MSFSharedUtils.allowNulls(bmData.get("currAffnDeptNm")));  /** column 현소속부서코드 : currAffnDeptNm */
               businNm.setValue(MSFSharedUtils.allowNulls(bmData.get("businNm")));   /** column 사업코드 : businNm */
               frstEmymtDt.setValue(GWTUtils.getStringFromDate((Date)bmData.get("frstEmymtDt"), "yyyy.MM.dd"));  /** column 최초고용일자 : frstEmymtDt */
               logSvcYrNumCd.setValue(lsLogSvcYrNumCd.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("logSvcYrNumCd")))); /** column 근속년수 : logSvcYrNum */
               logSvcMnthIcmCd.setValue(lsLogSvcMnthIcmCd.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("logSvcMnthIcmCd")))); /** column 근속년수 : logSvcYrNum */
               
               dayWorkYn.setValue((Boolean)bmData.get("dayWorkYn"));   /** column 일용직구분 : dayWorkYn */
               payrIncmExceYn.setValue((Boolean)bmData.get("payrIncmExceYn"));   /** column 급여소득세제외여부  : payrIncmExceYn */
               
               addIncmTxApptnRtoCd.setValue(lsAddIncmTxApptnRtoCd.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("addIncmTxApptnRtoCd")))); /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
              
               
               addIncmTxApptnYr.setValue(lsAddIncmTxApptnYr.findModel("year",MSFSharedUtils.paramNull(bmData.get("addIncmTxApptnYrMnth")) ? "" : MSFSharedUtils.allowNulls(bmData.get("addIncmTxApptnYrMnth")).substring(0, 4)));  /** set 추가소득세적용년 : addIncmTxApptnYrMnth */
               addIncmTxApptnMnth.setValue(lsAddIncmTxApptnMnth.findModel("month",MSFSharedUtils.paramNull(bmData.get("addIncmTxApptnYrMnth")) ? "" :MSFSharedUtils.allowNulls(bmData.get("addIncmTxApptnYrMnth")).substring(4, 6))); /** set 추가소득세적용월 : addIncmTxApptnYrMnth */
               
               addIncmTxApptnYn.setValue(MSFSharedUtils.allowNulls(bmData.get("addIncmTxApptnYn"))); 
               
               befIncmTxApptnRtoCd.setValue(MSFSharedUtils.allowNulls(bmData.get("befIncmTxApptnRtoCd")));
               befIncmTxApptnYr.setValue(MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(bmData.get("befIncmTxApptnYrMnth"))) ? "" : MSFSharedUtils.allowNulls(bmData.get("befIncmTxApptnYrMnth")).substring(0, 4));		
               befIncmTxApptnMnth.setValue(MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(bmData.get("befIncmTxApptnYrMnth"))) ? "" : MSFSharedUtils.allowNulls(bmData.get("befIncmTxApptnYrMnth")).substring(4, 6));	
               befIncmTxApptnYn.setValue(MSFSharedUtils.allowNulls(bmData.get("befIncmTxApptnYn")));	 
               
               addIncmTxApptnCnt.setValue((Long)bmData.get("addIncmTxApptnCnt"));		

               pyspCd.setValue(listStoreA005.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("pyspCd")))); /** column 호봉 : pyspCd */
               PayrUtils.setCheckedCheckBoxYnValue(unnMbspSttYn, MSFSharedUtils.allowNulls(bmData.get("unnMbspSttYn"))); 	//노조가입
               
            //   if (Constants.PAYR_TAX_B0290020.equals(MSFSharedUtils.allowNulls(bmData.get("addIncmTxApptnRtoCd"))) { 
	              
	               if (addIncmTxApptnCnt.getValue().compareTo(2L) < 0) {
	            	   fnAddIncmTxApptnReadOnly(false);
	               } else {
	            	   fnAddIncmTxApptnReadOnly(true);
	               }
             //  } else {
            	   
            //   }
               
              // logSvcMnthIcmNm.setValue(MSFSharedUtils.allowNulls(bmData.get("logSvcMnthIcmNm")));  /** column 근속월수 : logSvcMnthIcmNm */
               hdofcCodtnNm.setValue(MSFSharedUtils.allowNulls(bmData.get("hdofcCodtnNm")));  /** column 재직상태코드 : hdofcCodtnNm */
               retryDt.setValue(GWTUtils.getStringFromDate((Date)bmData.get("retryDt"), "yyyy.MM.dd"));  /** column 퇴직일자 : retryDt */
               
               wmnYn.setValue((Boolean)bmData.get("wmnYn"));   /** column 부녀자여부 : wmnYn */
               retryClutYn.setValue((Boolean)bmData.get("retryClutYn"));   /** column 퇴직정산여부 : retryClutYn */
               payRcptYn.setValue((Boolean)bmData.get("payRcptYn"));  /** column 급여대상자여부 : payRcptYn */
               
               hlthInsrApptnYn.setValue((Boolean)bmData.get("hlthInsrApptnYn"));  /** column 건강보험적용여부 : hlthInsrApptnYn */
               natPennApptnYn.setValue((Boolean)bmData.get("natPennApptnYn"));   /** column 국민연금적용여부 : natPennApptnYn */
               umytInsrApptnYn.setValue((Boolean)bmData.get("umytInsrApptnYn"));   /** column 고용보험적용여부 : umytInsrApptnYn */
               idtlAccdtInsurApptnYn.setValue((Boolean)bmData.get("idtlAccdtInsurApptnYn"));  /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
               
               hlthInsrMnthRuntnAmnt.setValue((Long)bmData.get("hlthInsrMnthRuntnAmnt"));  /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
               natPennStdIncmMnthAmnt.setValue((Long)bmData.get("natPennStdIncmMnthAmnt"));  /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */ 
               umytInsrPayMnthAmnt.setValue((Long)bmData.get("umytInsrPayMnthAmnt"));  /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
                
               currDeptAppmtDt.setValue(GWTUtils.getStringFromDate((Date)bmData.get("currDeptAppmtDt"), "yyyy.MM.dd"));  /** column 현_부서발령일자 : currDeptAppmtDt */
               yoobhMnthDay.setValue(GWTUtils.getStringFromDate((Date)bmData.get("yoobhMnthDay"), "yyyy.MM.dd"));  /** column 생년월일 : yoobhMnthDay */
               natnNm.setValue(MSFSharedUtils.allowNulls(bmData.get("natnNm")));  /** column 국가코드 : natnCd */
               
               logSvcStdDt.setValue(GWTUtils.getStringFromDate((Date)bmData.get("logSvcStdDt"), "yyyy.MM.dd"));   /** column 근속기준일자 : logSvcStdDt */
               logSvcExtpyApptnYn.setValue((Boolean)bmData.get("logSvcExtpyApptnYn"));  /** column 근속수당적용여부 : logSvcExtpyApptnYn */
               
               husPhnNum.setValue(MSFSharedUtils.allowNulls(bmData.get("husPhnNum"))); /** column 집전화번호 : husPhnNum */
               cellPhneNum.setValue(MSFSharedUtils.allowNulls(bmData.get("cellPhneNum"))); /** column 핸드폰번호 : cellPhneNum */
               
               emailAddr.setValue(MSFSharedUtils.allowNulls(bmData.get("emailAddr")));  /** column 이메일주소 : emailAddr */
    
               husRoadNmZpcd.setValue(MSFSharedUtils.allowNulls(bmData.get("husRoadNmZpcd"))); /** column 집도로명우편번호 : husRoadNmZpcd */
               
               husRoadNmFndtnAddr.setValue(MSFSharedUtils.allowNulls(bmData.get("husRoadNmFndtnAddr")));  /** column 집도로명기본주소 : husRoadNmFndtnAddr */
               
               mnthPayDlywagSum.setValue((Long)bmData.get("mnthPayDlywagSum"));
              // husRoadNmDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(bmData.get("husRoadNmDtlPatrAddr")));  /** column 집도로명상세주소 : husRoadNmDtlPatrAddr */
               
               //가족사항리플래쉬 평션 호출 
                   tabsPsnl.setSelection(tabsPsnl.getItem(0));
               
                   IColumnFilter filters = null;
                   payr0530GridPanel.getTableDef().setTableColumnFilters(filters);
                   
                   payr0530GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
                   payr0530GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
                     
                   payr0530GridPanel.reload(); 
           } else {
               
           }
         }  
       });  
     
//     final Grid<BaseModel> payr0500Grid = payr0500GridPanel.getMsfGrid().getGrid();
//     payr0500Grid.addListener(Events.Complete ,new Listener<BaseEvent>() {
//      public void handleEvent(BaseEvent be) {
//             
//             payr0500GridPanel.setAutoSelectFirstRecord(true);
//             BaseModel bmData = payr0500GridPanel.getGrid().getStore().getAt(0);
//             
//            
//         }
//     });    
     
     fldstNewFieldset_1.add(payr0500GridPanel);
     
//     payr0500Grid.addListener(Events.Complete, new Listener<BaseEvent>() {
//         public void handleEvent(BaseEvent be) {
//             payr0500GridPanel.setAutoSelectFirstRecord(true);
//             if (payr0500GridPanel.getCurrentlySelectedItem() != null) {  
//                   
//                   BaseModel bmData = payr0500GridPanel.getGrid().getStore().getAt(0);
//                   
//                   systemkey.setValue((String)bmData.get("systemkey")); /** column SYSTEMKEY : systemkey */
//                   dpobCd.setValue((String)bmData.get("dpobCd"));   /** column 사업장코드 : dpobCd */ 
//                   
//                   hanNm.setValue((String)bmData.get("hanNm")); /** column 한글성명 : hanNm */
//                   resnRegnNum.setValue((String)bmData.get("resnRegnNum"));  /** column 주민등록번호 : resnRegnNum */
//                   typOccuNm.setValue((String)bmData.get("typOccuNm"));  /** column 직종코드 : typOccuNm */
//                   dtilOccuClsDivNm.setValue((String)bmData.get("dtilOccuClsDivNm"));  /** column 직종세구분코드 : dtilOccuClsDivNm */
//                   emymtDivNm.setValue((String)bmData.get("emymtDivNm"));  /** column 고용구분 : emymtDivNm */
//                   
//                   deptNm.setValue((String)bmData.get("deptNm"));  /** column 관부서코드 : deptCd */ 
//                   currAffnDeptNm.setValue((String)bmData.get("currAffnDeptNm"));  /** column 현소속부서코드 : currAffnDeptNm */
//                   businNm.setValue((String)bmData.get("businNm"));   /** column 사업코드 : businNm */
//                   frstEmymtDt.setValue((String)bmData.get("frstEmymtDt"));  /** column 최초고용일자 : frstEmymtDt */
//                   logSvcYrNumNm.setValue((String)bmData.get("logSvcYrNumNm")); /** column 근속년수 : logSvcYrNumNm */
//                    
//                   logSvcMnthIcmNm.setValue((String)bmData.get("logSvcMnthIcmNm"));  /** column 근속월수 : logSvcMnthIcmNm */
//                   hdofcCodtnNm.setValue((String)bmData.get("hdofcCodtnNm"));  /** column 재직상태코드 : hdofcCodtnNm */
//                   retryDt.setValue((String)bmData.get("retryDt"));  /** column 퇴직일자 : retryDt */
//                   
//                   wmnYn.setValue((Boolean)bmData.get("wmnYn"));   /** column 부녀자여부 : wmnYn */
//                   retryClutYn.setValue((Boolean)bmData.get("retryClutYn"));   /** column 퇴직정산여부 : retryClutYn */
//                   payRcptYn.setValue((Boolean)bmData.get("payRcptYn"));  /** column 급여대상자여부 : payRcptYn */
//                   
//                   hlthInsrApptnYn.setValue((Boolean)bmData.get("hlthInsrApptnYn"));  /** column 건강보험적용여부 : hlthInsrApptnYn */
//                   natPennApptnYn.setValue((Boolean)bmData.get("natPennApptnYn"));   /** column 국민연금적용여부 : natPennApptnYn */
//                   umytInsrApptnYn.setValue((Boolean)bmData.get("umytInsrApptnYn"));   /** column 고용보험적용여부 : umytInsrApptnYn */
//                   idtlAccdtInsurApptnYn.setValue((Boolean)bmData.get("idtlAccdtInsurApptnYn"));  /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
//                   
//                   hlthInsrMnthRuntnAmnt.setValue((String)bmData.get("hlthInsrMnthRuntnAmnt"));  /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
//                   natPennStdIncmMnthAmnt.setValue((String)bmData.get("natPennStdIncmMnthAmnt"));  /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
//                   
//                   currDeptAppmtDt.setValue((String)bmData.get("currDeptAppmtDt"));  /** column 현_부서발령일자 : currDeptAppmtDt */
//                   yoobhMnthDay.setValue((String)bmData.get("yoobhMnthDay"));  /** column 생년월일 : yoobhMnthDay */
//                   natnNm.setValue((String)bmData.get("natnNm"));  /** column 국가코드 : natnCd */
//                   
//                   logSvcStdDt.setValue((String)bmData.get("logSvcStdDt"));   /** column 근속기준일자 : logSvcStdDt */
//                   logSvcExtpyApptnYn.setValue((Boolean)bmData.get("logSvcExtpyApptnYn"));  /** column 근속수당적용여부 : logSvcExtpyApptnYn */
//                   
//                   husPhnNum.setValue((String)bmData.get("husPhnNum")); /** column 집전화번호 : husPhnNum */
//                   cellPhneNum.setValue((String)bmData.get("cellPhneNum")); /** column 핸드폰번호 : cellPhneNum */
//                   
//                   emailAddr.setValue((String)bmData.get("emailAddr"));  /** column 이메일주소 : emailAddr */
//
//                   husRoadNmZpcd.setValue((String)bmData.get("husRoadNmZpcd")); /** column 집도로명우편번호 : husRoadNmZpcd */
//                   
//                   husRoadNmFndtnAddr.setValue((String)bmData.get("husRoadNmFndtnAddr"));  /** column 집도로명기본주소 : husRoadNmFndtnAddr */
//                   
//                   husRoadNmDtlPatrAddr.setValue((String)bmData.get("husRoadNmDtlPatrAddr"));  /** column 집도로명상세주소 : husRoadNmDtlPatrAddr */
//                   
//                   //가족사항리플래쉬 평션 호출 
//                   tabsPsnl.setSelection(tabsPsnl.getItem(0));
//                   
//                   IColumnFilter filters = null;
//                   payr0530GridPanel.getTableDef().setTableColumnFilters(filters);
//                   
//                   payr0530GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//                   payr0530GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//                     
//                   payr0530GridPanel.reload();
//                
//              }
//         }
//     });     
     
    
     tabsPsnlTop = new TabPanel(); //인사탭정보설정을 위한 tab 
     //tabsPsnl.setMinTabWidth(80);   
     tabsPsnlTop.setAutoWidth(false);
    // tabsPsnl.setResizeTabs(true);   
     tabsPsnlTop.setAnimScroll(true);   
     tabsPsnlTop.setTabScroll(true); 
     tabsPsnlTop.setPlain(true);   
     //엣지변환
     //tabsPsnlTop.setSize(615, 178); 
     tabsPsnlTop.setSize(615, 228);    
     
     TabItem itemTop01 = new TabItem();  
     itemTop01.setStyleAttribute("padding", "5px");  
     itemTop01.setText("기본정보");  
    // itemTop01.addStyleName("pad-text");     
     itemTop01.setLayout(new FormLayout());   
     itemTop01.add(DataTop01(), new FormData("100%"));   
     tabsPsnlTop.add(itemTop01);  
      
     TabItem itemTop02 = new TabItem();  
     itemTop02.setStyleAttribute("padding", "5px");  
     itemTop02.setText("상세정보");  
     itemTop02.setLayout(new FormLayout());   
     itemTop02.add(DataTop02(), new FormData("100%"));   
     tabsPsnlTop.add(itemTop02);  
       
       
       fldstNewFieldset_1.add(tabsPsnlTop,new FormData("100%"));  
        
        
	   LayoutContainer layoutContainer_36 = new LayoutContainer();
	   layoutContainer_36.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_37 = new LayoutContainer();
	   layoutContainer_37.setLayout(new FlowLayout(1));
	   
	   ButtonBar buttonBar = new ButtonBar();
	   
	   Button btnNewPayr = new Button("월별급여내역");
	   btnNewPayr.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) {
	    		 
	        	if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		            return;
		        }
	    		
	    		//급여내역  
			   PayrP410001 payrP41001Form = new PayrP410001(ActionDatabase.READ, getThis());   
			    
		       MSFFormWindows msFwPayr41001 = new MSFFormWindows("월별급여내역",payrP41001Form,"닫기","820px", "710px",true);
		       msFwPayr41001.show();
		       payrP41001Form.setMSFFormWindows(msFwPayr41001);
		       payrP41001Form.bind(ppRecord); 
	    		 
	    	}
	    });
	   buttonBar.add(btnNewPayr);
	   
	   Button btnYearPayr = new Button("년도별급여내역");
	   btnYearPayr.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) {
	    		 
	    		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		            return;
		        }
	    		
	    		//전체내역  
				   PayrP410002 payrP41002Form = new PayrP410002(ActionDatabase.READ, getThis());   
				    
			       MSFFormWindows msFwPayr41002 = new MSFFormWindows("년도별급여내역",payrP41002Form,"닫기","820px", "710px",true);
			       msFwPayr41002.show();
			       payrP41002Form.setMSFFormWindows(msFwPayr41002);
			       payrP41002Form.bind(ppRecord); 
		    		   
	    	}
	    });
	   buttonBar.add(btnYearPayr);
	   
	   
	   layoutContainer_37.add(buttonBar);
	   layoutContainer_36.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.48));
	   layoutContainer_37.setBorders(false);
	   
	   LayoutContainer layoutContainer_38 = new LayoutContainer();
	   layoutContainer_38.setLayout(new FlowLayout(1));
	   
	   ButtonBar buttonBar_1 = new ButtonBar();
	   buttonBar_1.setAlignment(HorizontalAlignment.RIGHT);
	   
	   Button btnStandSave = new Button("저장");

	   btnStandSave.setIcon(MSFMainApp.ICONS.saveSmall());
	   buttonBar_1.add(btnStandSave);
	   btnStandSave.addListener(Events.Select, new Listener<ButtonEvent>() {
 	    	public void handleEvent(ButtonEvent e) {
 	    		//기본정보저장 .
 	    	    saveStandData(); 
 	    		  
 	    	}
 	    });
	   layoutContainer_38.add(buttonBar_1);
	   layoutContainer_36.add(layoutContainer_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer_38.setBorders(false); 
	   layoutContainer_36.setBorders(true);
	   layoutContainer_36.setStyleAttribute("marginTop", "5px");
	   
	   fldstNewFieldset_1.add(layoutContainer_36,new FormData("100%"));  
	 
}
 
private  LayoutContainer DataTop01() {
    

    LayoutContainer lcTabFormLayer = new LayoutContainer();
  
    ContentPanel cp01 = new ContentPanel();   
    cp01.setBodyBorder(false); 
    cp01.setHeaderVisible(false);   
    cp01.setLayout(new FitLayout()); 
    //엣지변환
    //cp01.setSize(590, 178);  
    cp01.setSize(590, 228);  
    
    LayoutContainer lytCtr01 = new LayoutContainer();
    lytCtr01.setLayout(new FlowLayout());
    
    LayoutContainer layoutContainer_5 = new LayoutContainer();
    layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_6 = new LayoutContainer();
    FormLayout  frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6.setLayout(frmlytStd);
    
    hanNm = new TextField<String>(); 
    hanNm.setReadOnly(true);
    hanNm.addStyleName("x-form-field-readonly"); 
    layoutContainer_6.add(hanNm, new FormData("100%"));
    hanNm.setFieldLabel("성 명");
   
    layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));
    layoutContainer_6.setBorders(false);
    
    LayoutContainer layoutContainer_7 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7.setLayout(frmlytStd);
    
   secRegnNum = new HiddenField<String>();
    
    resnRegnNum = new TextField<String>();
    resnRegnNum.setReadOnly(true);
    layoutContainer_7.add(resnRegnNum, new FormData("100%"));
    resnRegnNum.setFieldLabel("주민번호");
    layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));
    layoutContainer_7.setBorders(false);
    
    LayoutContainer layoutContainer_8 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(50); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_8.setLayout(frmlytStd);
    
    typOccuNm = new TextField<String>();
    typOccuNm.setReadOnly(true);
    layoutContainer_8.add(typOccuNm, new FormData("100%"));
    typOccuNm.setFieldLabel("직 종");
    layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_8.setBorders(false);
    
    LayoutContainer layoutContainer_17 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_17.setLayout(frmlytStd);
    
    dtilOccuClsDivNm = new TextField<String>();
    dtilOccuClsDivNm.setReadOnly(true);
    layoutContainer_17.add(dtilOccuClsDivNm, new FormData("100%"));
    dtilOccuClsDivNm.setFieldLabel("직종세");
    layoutContainer_5.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_17.setBorders(false);
    lytCtr01.add(layoutContainer_5);
    layoutContainer_5.setBorders(false);
    
    LayoutContainer layoutContainer_9 = new LayoutContainer();
    layoutContainer_9.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_18 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_18.setLayout(frmlytStd);
    
    emymtDivCd = new HiddenField<String>();
    emymtDivNm = new TextField<String>();
    emymtDivNm.setReadOnly(true);
    layoutContainer_18.add(emymtDivNm, new FormData("100%"));
    emymtDivNm.setFieldLabel("고용");
    layoutContainer_9.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_18.setBorders(false);
    
    LayoutContainer layoutContainer_10 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_10.setLayout(frmlytStd);
    
    currAffnDeptNm = new TextField<String>();
    currAffnDeptNm.setReadOnly(true);
    layoutContainer_10.add(currAffnDeptNm, new FormData("100%"));
    currAffnDeptNm.setFieldLabel("부서");
    layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
    layoutContainer_10.setBorders(false);
    
    LayoutContainer layoutContainer_11 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_11.setLayout(frmlytStd);
    
    businNm = new TextField<String>();
    businNm.setReadOnly(true);
    layoutContainer_11.add(businNm, new FormData("100%"));
    businNm.setFieldLabel("사업");
    layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
    layoutContainer_11.setBorders(false);
    lytCtr01.add(layoutContainer_9);
    layoutContainer_9.setBorders(false);
    
    LayoutContainer layoutContainer_12 = new LayoutContainer();
    layoutContainer_12.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_13 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_13.setLayout(frmlytStd);
    
    frstEmymtDt = new TextField<String>();
    frstEmymtDt.setReadOnly(true);
    layoutContainer_13.add(frstEmymtDt, new FormData("100%"));
    frstEmymtDt.setFieldLabel("최초고용");
    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_13.setBorders(false);
    
    LayoutContainer layoutContainer_14 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_14.setLayout(frmlytStd);
    
    hdofcCodtnNm = new TextField<String>();
    hdofcCodtnNm.setReadOnly(true);
    layoutContainer_14.add(hdofcCodtnNm, new FormData("100%"));
    hdofcCodtnNm.setFieldLabel("근무상태");
    
    layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    
    LayoutContainer layoutContainer = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer.setLayout(frmlytStd);
    
    retryDt = new TextField<String>();
    retryDt.setReadOnly(true);
    layoutContainer.add(retryDt, new FormData("100%"));
    retryDt.setFieldLabel("퇴직일자");
    
    layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer.setBorders(false);
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_1.setLayout(frmlytStd);
    

    TextField<String> textField_9 = new TextField<String>();
    textField_9.setReadOnly(true);
    layoutContainer_1.add(textField_9, new FormData("100%"));
    textField_9.setFieldLabel("회계단위");
    
    layoutContainer_12.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_1.setBorders(false);
    lytCtr01.add(layoutContainer_12);
    layoutContainer_12.setBorders(false);
    
    LayoutContainer layoutContainer_2 = new LayoutContainer();
    layoutContainer_2.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd);
    
    TextField<String> textField_10 = new TextField<String>();
    textField_10.setReadOnly(true);
    layoutContainer_3.add(textField_10, new FormData("100%"));
    textField_10.setFieldLabel("장애자"); 
    
    layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
    layoutContainer_3.setBorders(false);
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd);
    
    wmnYn = new CheckBox();
    layoutContainer_4.add(wmnYn, new FormData("100%"));
    wmnYn.setBoxLabel("부녀자");
    wmnYn.setHideLabel(true);
    
    layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
    layoutContainer_4.setBorders(false);
    layoutContainer_4.setStyleAttribute("marginLeft", "20px");
    
    LayoutContainer layoutContainer_15 = new LayoutContainer();
    frmlytStd = new FormLayout();  
 //   frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_15.setLayout(frmlytStd);
    
    retryClutYn = new CheckBox();
    layoutContainer_15.add(retryClutYn, new FormData("100%"));
    retryClutYn.setBoxLabel("퇴직정산");
    retryClutYn.setHideLabel(true);
   
    layoutContainer_2.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
    layoutContainer_15.setBorders(false);
    layoutContainer_15.setStyleAttribute("marginLeft", "20px");
    
    LayoutContainer layoutContainer_16 = new LayoutContainer();
    frmlytStd = new FormLayout();  
  //  frmlytStd.setLabelWidth(50); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_16.setLayout(frmlytStd);
    
    payRcptYn = new CheckBox();
    layoutContainer_16.add(payRcptYn, new FormData("100%"));
    payRcptYn.setBoxLabel("급여대상");
    payRcptYn.setHideLabel(true);
  
    layoutContainer_2.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
    layoutContainer_16.setBorders(false);
    layoutContainer_16.setStyleAttribute("marginLeft", "20px");
    
    LayoutContainer layoutContainer_22 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    //frmlytStd.setLabelWidth(50); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_22.setLayout(frmlytStd);
    
    
    dayWorkYn = new CheckBox(); 
    dayWorkYn.setBoxLabel("일용직");
    dayWorkYn.setHideLabel(true); 
    layoutContainer_22.add(dayWorkYn, new FormData("100%"));
    layoutContainer_2.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
    layoutContainer_22.setBorders(false);
    layoutContainer_22.setStyleAttribute("marginLeft", "20px");
    
    
    LayoutContainer lcPayrIncmExceYn = new LayoutContainer();
    frmlytStd = new FormLayout();  
    //frmlytStd.setLabelWidth(50); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    lcPayrIncmExceYn.setLayout(frmlytStd);
    
    
    payrIncmExceYn = new CheckBox(); 
    payrIncmExceYn.setBoxLabel("소득세제외");
    payrIncmExceYn.setHideLabel(true); 
    lcPayrIncmExceYn.add(payrIncmExceYn, new FormData("100%"));
    layoutContainer_2.add(lcPayrIncmExceYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));
    lcPayrIncmExceYn.setBorders(false);
    lcPayrIncmExceYn.setStyleAttribute("marginLeft", "20px");
    
    
    lytCtr01.add(layoutContainer_2);
    layoutContainer_2.setBorders(false); 

    
    
    
    
    LayoutContainer layoutContainer_2_1 = new LayoutContainer();
    layoutContainer_2_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_3_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3_1.setLayout(frmlytStd);
     
    logSvcYrNumCd = new ComboBox<BaseModel>();
    logSvcYrNumCd.setName("logSvcYrNumCd");
    logSvcYrNumCd.setForceSelection(true);
    logSvcYrNumCd.setMinChars(1);
    logSvcYrNumCd.setDisplayField("commCdNm");
    logSvcYrNumCd.setValueField("commCd");
    logSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
    logSvcYrNumCd.setAllowBlank(true);
    logSvcYrNumCd.setEmptyText("--근속년수선택--");
    logSvcYrNumCd.setSelectOnFocus(true); 
    logSvcYrNumCd.setReadOnly(false);
    logSvcYrNumCd.setEnabled(true); 
    logSvcYrNumCd.setStore(lsLogSvcYrNumCd);  
    logSvcYrNumCd.setFieldLabel("근무년수"); 
    logSvcYrNumCd.setLazyRender(false);
    lsLogSvcYrNumCd.addStoreListener(new StoreListener<BaseModel>() { 
         @Override
         public void storeAdd(StoreEvent<BaseModel> se) {
             
         }
     });
      
    layoutContainer_3_1.add(logSvcYrNumCd, new FormData("100%")); 
  
    layoutContainer_2_1.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
    layoutContainer_3_1.setBorders(false);
    
    LayoutContainer layoutContainer_4_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4_1.setLayout(frmlytStd); 
    
    logSvcMnthIcmCd = new ComboBox<BaseModel>();
    logSvcMnthIcmCd.setName("logSvcMnthIcmCd");
    logSvcMnthIcmCd.setForceSelection(true);
    logSvcMnthIcmCd.setMinChars(1);
    logSvcMnthIcmCd.setDisplayField("commCdNm");
    logSvcMnthIcmCd.setValueField("commCd");
    logSvcMnthIcmCd.setTriggerAction(TriggerAction.ALL);
    logSvcMnthIcmCd.setAllowBlank(true);
    logSvcMnthIcmCd.setEmptyText("--근속월수선택--");
    logSvcMnthIcmCd.setSelectOnFocus(true); 
    logSvcMnthIcmCd.setReadOnly(false);
    logSvcMnthIcmCd.setEnabled(true); 
    logSvcMnthIcmCd.setStore(lsLogSvcMnthIcmCd);  
    logSvcMnthIcmCd.setFieldLabel("근무월수"); 
    logSvcMnthIcmCd.setLazyRender(false);
    lsLogSvcMnthIcmCd.addStoreListener(new StoreListener<BaseModel>() { 
         @Override
         public void storeAdd(StoreEvent<BaseModel> se) {
             
         }
     });
    layoutContainer_4_1.add(logSvcMnthIcmCd, new FormData("100%")); 
    
    layoutContainer_2_1.add(layoutContainer_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
    layoutContainer_4_1.setBorders(false);
    
    LayoutContainer layoutContainer_15_1 = new LayoutContainer(); 
    //layoutContainer_15_1.setStyleAttribute("paddingLeft", "2px");
    frmlytStd = new FormLayout();  
    
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_15_1.setLayout(frmlytStd);
    
    addIncmTxApptnRtoCd = new ComboBox<BaseModel>();
    addIncmTxApptnRtoCd.setName("addIncmTxApptnRtoCd");
    addIncmTxApptnRtoCd.setForceSelection(true);
    addIncmTxApptnRtoCd.setMinChars(1);
    addIncmTxApptnRtoCd.setDisplayField("commCdNm");
    addIncmTxApptnRtoCd.setValueField("commCd");
    addIncmTxApptnRtoCd.setTriggerAction(TriggerAction.ALL);
    addIncmTxApptnRtoCd.setAllowBlank(true);
    addIncmTxApptnRtoCd.setEmptyText("--소득세율--");
    addIncmTxApptnRtoCd.setSelectOnFocus(true); 
    addIncmTxApptnRtoCd.setReadOnly(false);
    addIncmTxApptnRtoCd.setEnabled(true); 
    addIncmTxApptnRtoCd.setStore(lsAddIncmTxApptnRtoCd);  
    addIncmTxApptnRtoCd.setFieldLabel("소득세율"); 
    addIncmTxApptnRtoCd.setLazyRender(false);
    lsAddIncmTxApptnRtoCd.addStoreListener(new StoreListener<BaseModel>() { 
         @Override
         public void storeAdd(StoreEvent<BaseModel> se) {
             
         }
     });
    addIncmTxApptnRtoCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
           
         BaseModel bmAddIncmTxApptnRtoCd =  se.getSelectedItem(); 
         if (bmAddIncmTxApptnRtoCd != null) { 
             
        	 //현재 급여에 반영된 값을 토대로 정의 해야 함. 
        	 if (MSFSharedUtils.allowNulls(addIncmTxApptnCnt.getValue()).compareTo("2") >= 0) {
        		 
        		     MessageBox.confirm("추가소득세율변경", "현재 변경된 소득세율은 급여에 <br>반영되었습니다.<br>과세기간에 변경이 가능한지 확인한 후 <br>변경하십시요.<br> 변경하시려면[Yes] 버튼클릭 <br>"
        		     		+ " <font-color=red>변경하지않으려면 [No] 버튼클릭.</font-color>",new Listener<MessageBoxEvent>(){
                     @Override
                      public void handleEvent(MessageBoxEvent be) {
                      // if("Yes".equals(be.getButtonClicked().getText())){
                    	 if(Dialog.YES.equals(be.getButtonClicked().getItemId())){    
                             fnAddIncmTxApptnReadOnly(false);
                             addIncmTxApptnYn.setValue("Y");
                             
                       } else  if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
                    	   //if("No".equals(be.getButtonClicked().getText())){
                         
                    	   fnAddIncmTxApptnReadOnly(true); 
                    	   
                    	   addIncmTxApptnRtoCd.setValue(lsAddIncmTxApptnRtoCd.findModel("commCd",MSFSharedUtils.allowNulls(befIncmTxApptnRtoCd.getValue()))); /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
                           addIncmTxApptnYr.setValue(lsAddIncmTxApptnYr.findModel("year",MSFSharedUtils.allowNulls(befIncmTxApptnYr.getValue())));  /** set 추가소득세적용년 : addIncmTxApptnYrMnth */
                           addIncmTxApptnMnth.setValue(lsAddIncmTxApptnMnth.findModel("month",MSFSharedUtils.allowNulls(befIncmTxApptnMnth.getValue()))); /** set 추가소득세적용월 : addIncmTxApptnYrMnth */
                           
                           addIncmTxApptnYn.setValue(MSFSharedUtils.allowNulls(befIncmTxApptnYn.getValue())); 
                             
                       }
                       
                     }
                     
                });
        	 }
              // sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
            
         }       
        } 
    });   
    layoutContainer_15_1.add(addIncmTxApptnRtoCd, new FormData("100%")); 
   
    layoutContainer_2_1.add(layoutContainer_15_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
    layoutContainer_15_1.setBorders(false);
    
    LayoutContainer layoutContainer_16_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
  //  frmlytStd.setLabelWidth(50); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_16_1.setLayout(frmlytStd);
     
    
    LayoutContainer lcSchLeft = new LayoutContainer();
   // lcSchLeft.setStyleAttribute("paddingRight", "10px");
    
    lcSchLeft.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_81 = new LayoutContainer();
    FormLayout frmlytSch = new FormLayout();  
    frmlytSch.setLabelWidth(60); 
    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    layoutContainer_81.setLayout(frmlytSch);
    
    addIncmTxApptnYr = new ComboBox<BaseModel>();
    addIncmTxApptnYr.setName("addIncmTxApptnYr");
    addIncmTxApptnYr.setStyleAttribute("background-color", "#E0ECF8");
    addIncmTxApptnYr.setForceSelection(true);
    addIncmTxApptnYr.setMinChars(1);
    addIncmTxApptnYr.setDisplayField("yearDisp");
    addIncmTxApptnYr.setValueField("year");
    addIncmTxApptnYr.setTriggerAction(TriggerAction.ALL);
   //addIncmTxApptnYr.setEmptyText("--년도선택--");
    addIncmTxApptnYr.setSelectOnFocus(true); 
    addIncmTxApptnYr.setReadOnly(false);
    addIncmTxApptnYr.setEnabled(true); 
    addIncmTxApptnYr.setStore(lsAddIncmTxApptnYr);
    addIncmTxApptnYr.setFieldLabel("적용년월"); 
    addIncmTxApptnYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        public void handleEvent(StoreEvent<BaseModel> be) {  
        	checkPayr4100Auth("addIncmTxApptnYr",lsAddIncmTxApptnYr); 
        	   
        }
    });
    
    layoutContainer_81.add(addIncmTxApptnYr, new FormData("100%"));
    lcSchLeft.add(layoutContainer_81,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
    layoutContainer_81.setBorders(false);
    
    LayoutContainer layoutContainer_91 = new LayoutContainer();
    frmlytSch = new FormLayout();  
    frmlytSch.setLabelWidth(0); 
    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    layoutContainer_91.setLayout(frmlytSch);
    
    /** column 지급년월 : Mnth */ 
    addIncmTxApptnMnth = new ComboBox<BaseModel>();
    addIncmTxApptnMnth.setName("addIncmTxApptnMnth");
    addIncmTxApptnMnth.setForceSelection(true);
    addIncmTxApptnMnth.setMinChars(1);
    addIncmTxApptnMnth.setDisplayField("monthDisp");
    addIncmTxApptnMnth.setValueField("month");
    addIncmTxApptnMnth.setTriggerAction(TriggerAction.ALL);
   // addIncmTxApptnMnth.setEmptyText("--월선택--");
    addIncmTxApptnMnth.setSelectOnFocus(true); 
    addIncmTxApptnMnth.setReadOnly(false);
    addIncmTxApptnMnth.setEnabled(true); 
    addIncmTxApptnMnth.setStore(lsAddIncmTxApptnMnth);
    addIncmTxApptnMnth.setLabelSeparator("");  
    addIncmTxApptnMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        public void handleEvent(StoreEvent<BaseModel> be) {  
        	checkPayr4100Auth("addIncmTxApptnMnth",lsAddIncmTxApptnMnth); 
        }
    });
    layoutContainer_91.add(addIncmTxApptnMnth, new FormData("100%"));
    lcSchLeft.add(layoutContainer_91,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    layoutContainer_91.setBorders(false);
  
    layoutContainer_2_1.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
    layoutContainer_2_1.setBorders(false);
    layoutContainer_16_1.setBorders(false);
     
    lytCtr01.add(layoutContainer_2_1);
    
    
    LayoutContainer	layoutContainer_100 = new LayoutContainer(new ColumnLayout());
    layoutContainer_100.setBorders(false);
    
    LayoutContainer	layoutContainer_101 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_101.setLayout(frmlytStd);
    
    pyspCd = new ComboBox<BaseModel>();
    pyspCd.setName("pyspCd");
    pyspCd.setForceSelection(true);
    pyspCd.setMinChars(1);
    pyspCd.setDisplayField("commCdNm");
    pyspCd.setValueField("commCd");
    pyspCd.setTriggerAction(TriggerAction.ALL);
    pyspCd.setAllowBlank(true);
    pyspCd.setEmptyText("--호봉선택--");
    pyspCd.setSelectOnFocus(true); 
    pyspCd.setReadOnly(false); 
    pyspCd.setEnabled(true);  
    pyspCd.setStore(listStoreA005);  
    pyspCd.setFieldLabel("호봉"); 
    pyspCd.setLazyRender(false);
    
    layoutContainer_101.add(pyspCd, new FormData("100%"));
    layoutContainer_100.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
    
    
    LayoutContainer	layoutContainer_102 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(10); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_102.setLayout(frmlytStd);
    
    unnMbspSttYn = new CheckBox();
    unnMbspSttYn.setHideLabel(true);
    unnMbspSttYn.setBoxLabel("노조");
    unnMbspSttYn.setValue(false);
    unnMbspSttYn.setHideLabel(true);
    unnMbspSttYn.setReadOnly(false); 
    unnMbspSttYn.setEnabled(true); 
    unnMbspSttYn.setValueAttribute("Y");
	layoutContainer_102.add(unnMbspSttYn, new FormData("100%"));
	layoutContainer_100.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));

    
    
    lytCtr01.add(layoutContainer_100);  
    
    cp01.add(lytCtr01);
    
     
    lcTabFormLayer.add(cp01); 
       
    return lcTabFormLayer;
}


private  LayoutContainer DataTop02() {
    

    LayoutContainer lcTabFormLayer = new LayoutContainer();
  
    ContentPanel cp01 = new ContentPanel();   
    cp01.setBodyBorder(false); 
    cp01.setHeaderVisible(false);   
    cp01.setLayout(new FitLayout());
    //엣지변환
    //cp01.setSize(590, 178);  
    cp01.setSize(590, 228);  
    
    LayoutContainer lytCtr01 = new LayoutContainer();
    lytCtr01.setLayout(new FlowLayout());
        
  
    LayoutContainer layoutContainer_19 = new LayoutContainer();
    layoutContainer_19.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_20 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_20.setLayout(frmlytStd);
    
    CheckBoxGroup chckbxgrpNewCheckboxgroup = new CheckBoxGroup();
    
    hlthInsrApptnYn = new CheckBox();
    chckbxgrpNewCheckboxgroup.add(hlthInsrApptnYn);
    hlthInsrApptnYn.setBoxLabel("건강");
    hlthInsrApptnYn.setHideLabel(true);
    
    natPennApptnYn = new CheckBox();
    chckbxgrpNewCheckboxgroup.add(natPennApptnYn);
    natPennApptnYn.setBoxLabel("국민");
    natPennApptnYn.setHideLabel(true);
    
    umytInsrApptnYn = new CheckBox();
    chckbxgrpNewCheckboxgroup.add(umytInsrApptnYn);
    umytInsrApptnYn.setBoxLabel("고용");
    umytInsrApptnYn.setHideLabel(true);
    layoutContainer_20.add(chckbxgrpNewCheckboxgroup, new FormData("100%"));
    chckbxgrpNewCheckboxgroup.setFieldLabel("사회보험");
    layoutContainer_19.add(layoutContainer_20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
    layoutContainer_20.setBorders(false);
    
    LayoutContainer layoutContainer_21 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_21.setLayout(frmlytStd);
     
   // layoutContainer_21.add( , new FormData("100%")); 
    layoutContainer_19.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
    layoutContainer_21.setBorders(false);
    
    LayoutContainer layoutContainer_23 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_23.setLayout(frmlytStd);
     
    mnthPayDlywagSum = new NumberField();  
    mnthPayDlywagSum.setReadOnly(true);
    mnthPayDlywagSum.setAllowDecimals(true);
    mnthPayDlywagSum.setPropertyEditorType(Long.class); 
    mnthPayDlywagSum.setFormat(NumberFormat.getDecimalFormat());
    layoutContainer_23.add( mnthPayDlywagSum, new FormData("100%")); 
    mnthPayDlywagSum.setFieldLabel("일당금액");  
   
    layoutContainer_19.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    layoutContainer_23.setBorders(false);
    lytCtr01.add(layoutContainer_19);
    layoutContainer_19.setBorders(false);
    
    //-----------------------------
    

    LayoutContainer layoutContainer_19_1 = new LayoutContainer();
    layoutContainer_19_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_20_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_20_1.setLayout(frmlytStd); 

    hlthInsrMnthRuntnAmnt = new NumberField();
    hlthInsrMnthRuntnAmnt.setAllowDecimals(true);
    hlthInsrMnthRuntnAmnt.setPropertyEditorType(Long.class); 
    hlthInsrMnthRuntnAmnt.setFormat(NumberFormat.getDecimalFormat());
    layoutContainer_20_1.add(hlthInsrMnthRuntnAmnt, new FormData("100%"));
    hlthInsrMnthRuntnAmnt.setFieldLabel("건강보수월액"); 
    layoutContainer_19_1.add(layoutContainer_20_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
    layoutContainer_20_1.setBorders(false);
    
    LayoutContainer layoutContainer_21_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_21_1.setLayout(frmlytStd);
    
    natPennStdIncmMnthAmnt = new NumberField();
    natPennStdIncmMnthAmnt.setAllowDecimals(true);
    natPennStdIncmMnthAmnt.setPropertyEditorType(Long.class); 
    natPennStdIncmMnthAmnt.setFormat(NumberFormat.getDecimalFormat());
    layoutContainer_21_1.add(natPennStdIncmMnthAmnt, new FormData("100%"));
    natPennStdIncmMnthAmnt.setFieldLabel("기준소득월액");
    
    layoutContainer_19_1.add(layoutContainer_21_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
    layoutContainer_21_1.setBorders(false);
    
    LayoutContainer layoutContainer_23_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_23_1.setLayout(frmlytStd);
    
    umytInsrPayMnthAmnt = new NumberField();
    umytInsrPayMnthAmnt.setAllowDecimals(true); 
    umytInsrPayMnthAmnt.setPropertyEditorType(Long.class); 
    umytInsrPayMnthAmnt.setFormat(NumberFormat.getDecimalFormat());
    layoutContainer_23_1.add(umytInsrPayMnthAmnt, new FormData("100%"));
    umytInsrPayMnthAmnt.setFieldLabel("고용보수월액");
    
    layoutContainer_19_1.add(layoutContainer_23_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
    layoutContainer_23_1.setBorders(false);
    lytCtr01.add(layoutContainer_19_1);
    layoutContainer_19_1.setBorders(false);
    
    
    //-----------------------------
    
    LayoutContainer layoutContainer_24 = new LayoutContainer();
    layoutContainer_24.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_25 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_25.setLayout(frmlytStd);
    
    currDeptAppmtDt = new TextField<String>();
    currDeptAppmtDt.setReadOnly(true);
    layoutContainer_25.add(currDeptAppmtDt, new FormData("100%"));
    currDeptAppmtDt.setFieldLabel("현부서고용일");
    layoutContainer_24.add(layoutContainer_25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_25.setBorders(false);
    
    LayoutContainer layoutContainer_26 = new LayoutContainer();
  frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_26.setLayout(frmlytStd);
    
    yoobhMnthDay = new TextField<String>();
    yoobhMnthDay.setReadOnly(true);
    layoutContainer_26.add(yoobhMnthDay, new FormData("100%"));
    yoobhMnthDay.setFieldLabel("생년월일");
    layoutContainer_24.add(layoutContainer_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_26.setBorders(false);
    
    LayoutContainer layoutContainer_27 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_27.setLayout(frmlytStd);
    
    natnNm = new TextField<String>();
    natnNm.setReadOnly(true);
    layoutContainer_27.add(natnNm, new FormData("100%"));
    natnNm.setFieldLabel("국 적");
    layoutContainer_24.add(layoutContainer_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_27.setBorders(false);
    
    LayoutContainer layoutContainer_28 = new LayoutContainer();
   frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_28.setLayout(frmlytStd);
    
    logSvcStdDt = new TextField<String>();
    logSvcStdDt.setReadOnly(true);
    layoutContainer_28.add(logSvcStdDt, new FormData("100%"));
    logSvcStdDt.setFieldLabel("근속기준일");
    layoutContainer_24.add(layoutContainer_28, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_28.setBorders(false);
    lytCtr01.add(layoutContainer_24);
    layoutContainer_24.setBorders(false);
    
    LayoutContainer layoutContainer_32 = new LayoutContainer();
    layoutContainer_32.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_33 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_33.setLayout(frmlytStd);
    
    husPhnNum = new TextField<String>();
    husPhnNum.setReadOnly(true);
    layoutContainer_33.add(husPhnNum, new FormData("100%"));
    husPhnNum.setFieldLabel("전화번호");
    layoutContainer_32.add(layoutContainer_33, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_33.setBorders(false);
    
    LayoutContainer layoutContainer_34 = new LayoutContainer();
  frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_34.setLayout(frmlytStd);
    
    cellPhneNum = new TextField<String>();
    cellPhneNum.setReadOnly(true);
    layoutContainer_34.add(cellPhneNum, new FormData("100%"));
    cellPhneNum.setFieldLabel("핸드폰");
    layoutContainer_32.add(layoutContainer_34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_34.setBorders(false);
    
    LayoutContainer layoutContainer_35 = new LayoutContainer();
  frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_35.setLayout(frmlytStd);
    
    emailAddr = new TextField<String>();
    emailAddr.setReadOnly(true);
    layoutContainer_35.add(emailAddr, new FormData("100%"));
    emailAddr.setFieldLabel("이메일");
    layoutContainer_32.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
    layoutContainer_35.setBorders(false);
    lytCtr01.add(layoutContainer_32);
    layoutContainer_32.setBorders(false);
    
    LayoutContainer layoutContainer_29 = new LayoutContainer();
    layoutContainer_29.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_30 = new LayoutContainer();
  frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_30.setLayout(frmlytStd);
    
    husRoadNmZpcd = new TextField<String>();
    husRoadNmZpcd.setReadOnly(true);
    layoutContainer_30.add(husRoadNmZpcd, new FormData("100%"));
    husRoadNmZpcd.setFieldLabel("우편번호");
    layoutContainer_29.add(layoutContainer_30, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_30.setBorders(false);
    
    LayoutContainer layoutContainer_31 = new LayoutContainer();
   frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(60); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_31.setLayout(frmlytStd);
    
    husRoadNmFndtnAddr = new TextField<String>();
    husRoadNmFndtnAddr.setReadOnly(true);
    layoutContainer_31.add(husRoadNmFndtnAddr, new FormData("100%"));
    husRoadNmFndtnAddr.setFieldLabel("주 소");
    layoutContainer_29.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
    layoutContainer_31.setBorders(false);
    lytCtr01.add(layoutContainer_29);
    layoutContainer_29.setBorders(false);
     
    cp01.add(lytCtr01);
     
    lcTabFormLayer.add(cp01); 
       
    return lcTabFormLayer;
}

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
 private LayoutContainer occupationalLeft() {
	   
	   LayoutContainer lcTabFormLayer = new LayoutContainer(new FitLayout());
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());     
	   //엣지변환
	   //cp01.setSize(315, 470);  
	   cp01.setSize(315, 520);  
//	   
	   
	    //msfCustomForm.setHeaderVisible(false);
    //Instantiate the GridPanel
	   psnl0100GridPanel = new MSFGridPanel(psnl0100Def, false, false, false, false);
	   psnl0100GridPanel.setHeaderVisible(false);  
	   psnl0100GridPanel.setBodyBorder(true);
	   psnl0100GridPanel.setBorders(true);
	//   psnl0100GridPanel.setSize(308, 466); 
 //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

	   cp01.add(psnl0100GridPanel); 
	    
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;  
	   
}

private void createTabForm() {   
	
	
	/**
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   * 년도 콤보박스 처리  시작
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	   */
		   ContentPanel payYrGrid = new ContentPanel();  
		   payYrGrid.setVisible(false);
		    
		   //년도 콤보처리 
		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
			       public void handleEvent(ComponentEvent be) {  
			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
			          public void handleEvent(StoreEvent<BaseModel> be) {  
			        	 lsPayYrStore01.add(payYrGridPanel.getMsfGrid().getStore().getModels());  
			        	 lsPayYrStore02.add(payYrGridPanel.getMsfGrid().getStore().getModels());  
			        	 srhPayrYr01.setStore(lsPayYrStore01); 
			        	 srhPayrYr01.setValue(lsPayYrStore01.getAt(0));
			        	 srhPayrYr02.setStore(lsPayYrStore02); 
			        	 srhPayrYr02.setValue(lsPayYrStore02.getAt(0));
			          }  
			        });  
			       
			      }  
			    });  
	  
		payYrGrid.add(payYrGridPanel);  

	/**
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   * 년도 콤보박스 처리  시작
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	   */
		fldstNewFieldset_2.add(payYrGrid);
	    
	    tabsPsnl = new TabPanel(); //인사탭정보설정을 위한 tab 
	    //tabsPsnl.setMinTabWidth(80);   
	    tabsPsnl.setAutoWidth(false);
	   // tabsPsnl.setResizeTabs(true);   
	    tabsPsnl.setAnimScroll(true);   
	    tabsPsnl.setTabScroll(true); 
	    tabsPsnl.setPlain(true);   
	    tabsPsnl.setSize(615, 220);    
	    
	    TabItem item01 = new TabItem();  
	  //  item01.setStyleAttribute("padding", "10px");  
	    item01.setText("가족사항");  
	    item01.addStyleName("pad-text");     
	    item01.setLayout(new FormLayout());   
	    item01.add(Data01(), new FormData("100%"));   
	    tabsPsnl.add(item01);  
	    item01.addListener(Events.Select, new Listener<ComponentEvent>() {
    		public void handleEvent(ComponentEvent ce) {
    			//가족사항탭을 누른경우에 데이터를 리로딩한다.
    			reloadPayr0530();
    		   
    		}
    	});

	    TabItem item02 = new TabItem();  
	 //   item02.setStyleAttribute("padding", "10px");  
	    item02.setText("수 당");  
	    item02.setLayout(new FormLayout());   
	    item02.add(Data02(), new FormData("100%"));   
        tabsPsnl.add(item02);  
        item02.addListener(Events.Select, new Listener<ComponentEvent>() {
    		public void handleEvent(ComponentEvent ce) {
    			//수당  
    			reloadPayr0520();
    		   
    		}
    	});
     
    
    TabItem item03 = new TabItem();  
   // item03.setStyleAttribute("padding", "10px");  
    item03.setText("공 제");  
    item03.setLayout(new FormLayout());   
    item03.add(Data03(), new FormData("100%"));   
    tabsPsnl.add(item03);  
    item03.addListener(Events.Select, new Listener<ComponentEvent>() {
		public void handleEvent(ComponentEvent ce) {
			//공제 
			reloadPayr0200();
		   
		}
	});
    
    
    TabItem item04 = new TabItem();  
   // item04.setStyleAttribute("padding", "10px");  
    item04.setText("지급계좌");  
    item04.setLayout(new FormLayout());   
    item04.add(Data04(), new FormData("100%"));          
    tabsPsnl.add(item04);  
    item04.addListener(Events.Select, new Listener<ComponentEvent>() {
		public void handleEvent(ComponentEvent ce) {
			//지급계좌 누른경우에 데이터를 리로딩한다.
			reloadPsnl0130();
		   
		}
	});
    
    TabItem item05 = new TabItem();  
  //  item05.setStyleAttribute("padding", "10px");  
    item05.setText("채권압류");  
    item05.setLayout(new FormLayout()); 
    item05.add(Data05(), new FormData("100%"));          
    tabsPsnl.add(item05);  
    item05.addListener(Events.Select, new Listener<ComponentEvent>() {
		public void handleEvent(ComponentEvent ce) {
			//채권압류 누른경우에 데이터를 리로딩한다.
			reloadPayr0220();
		   
		}
	});
    TabItem item06 = new TabItem();  
  //  item06.setStyleAttribute("padding", "10px");  
    item06.setText("퇴직정산");  
    item06.setLayout(new FormLayout());  
    item06.add(Data06(),  new FormData("100%"));          
     
    tabsPsnl.add(item06);  
    item06.addListener(Events.Select, new Listener<ComponentEvent>() {
		public void handleEvent(ComponentEvent ce) {
			//퇴직정산 누른경우에 데이터를 리로딩한다.
			reloadRemt3500();
		   
		}
	});
    
    TabItem item07 = new TabItem();  
  //  item07.setStyleAttribute("padding", "10px");  
    item07.setText("휴 직");  
    item07.setLayout(new FormLayout());   
    item07.add(Data07(), new FormData("100%"));          
    tabsPsnl.add(item07);  
    item07.addListener(Events.Select, new Listener<ComponentEvent>() {
		public void handleEvent(ComponentEvent ce) {
			//휴 직 누른경우에 데이터를 리로딩한다.
			reloadPsnl0123();
		   
		}
	});
    
    TabItem item08 = new TabItem();  
   // item08.setStyleAttribute("padding", "10px");  
    item08.setText("예외사항");  
    item08.setLayout(new FormLayout()); 
    item08.add(Data08(), new FormData("100%")); 
    tabsPsnl.add(item08);   
    item08.addListener(Events.Select, new Listener<ComponentEvent>() {
		public void handleEvent(ComponentEvent ce) {
			//예외 누른경우에 데이터를 리로딩한다.
			reloadPayr0540();
		   
		}
	});
    
    fldstNewFieldset_2.add(tabsPsnl, new FormData("100%"));  
}  
	   
	//가족사항
	 private LayoutContainer Data01() { 

		  
		 LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(610, 180);  
	  	     
		 	  //msfCustomForm.setHeaderVisible(false);
		        //Instantiate the GridPanel
	  	payr0530GridPanel = new MSFGridPanel(payr0530Def, false, false, false, false,false);
	  	payr0530GridPanel.setHeaderVisible(false);  
	  	payr0530GridPanel.setBodyBorder(true);
	  	payr0530GridPanel.setBorders(true);
	  	 
	  	
	 // 	payr0530GridPanel.getBottomComponent().setVisible(false); 
//		    final Grid payr0530Grid = payr0530GridPanel.getMsfGrid().getGrid(); 
//		    payr0530Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//	              public void handleEvent(BaseEvent be) {  
//	            	  if (payr0530GridPanel.getCurrentlySelectedItem() != null) {  
//	            		  setRecord(payr0530GridPanel.getCurrentlySelectedItem());	
//	            		  actionDatabase = ActionDatabase.UPDATE;
//	            	  }
//	              }
//	          });   

		   cp01.add(payr0530GridPanel);  
		   
	  	   cp01.addButton(new Button("가족선택", new SelectionListener<ButtonEvent>() {   
		  	      @Override  
		  	      public void componentSelected(ButtonEvent ce) {   
		  	    	  
//		  	    	   BaseModel bm = new BaseModel();
//					   
//					   bm = payr0530GridPanel.getTableDef().getDefaultValues();
//					   RowEditor rowEdit = new RowEditor();
//					   
//					   /**================================================================================= 
//					   //인서트시 초기셋팅부분 .
//					   ====================================================================================*/ 
//					   bm.set("dpobCd", MSFMainApp.get().getUser().getDpobCd() );
//					   bm.set("systemkey", MSFMainApp.get().getUser().getUserInfo().getPayrMangDeptCd());
//					   bm.set("payFamyRsptSeilNum", 0);
//					   /**================================================================================= 
//					   //인서트시 초기셋팅부분 .
//					   ====================================================================================*/ 
//					    
//					    for (int i=0;i < payr0530GridPanel.getGrid().getPlugins().size();i++) {
//					    	if (payr0530GridPanel.getGrid().getPlugins().get(i) instanceof RowEditor) {
//					    		rowEdit = (RowEditor)payr0530GridPanel.getGrid().getPlugins().get(i);
//					    		rowEdit.stopEditing(false);  
//					    		payr0530GridPanel.getGrid().getStore().insert(bm, 1);  
//					    		rowEdit.startEditing(payr0530GridPanel.getGrid().getStore().indexOf(bm), true);  
//					    	    break;
//					    	}
//					    }
		  	    	  //TODO 가족사항을 가지고 오는 팝업을 호출한다.
		  	    	  //선택한 내용을 저장 후리스트에 보여준다.
		  	    	  //저장은 업데이트로 처리한다. 
		  	            fnPopupCommP160();  
		  	    	  
					    
		  	      }   
		  	    }));  
	 		 
	  	   cp01.addButton(new Button("가족등록", new SelectionListener<ButtonEvent>() {   
	  	      @Override  
	  	      public void componentSelected(ButtonEvent ce) {  
	  	    	//가족사항을 등록하는 팝업을 호출한다.   
	          	if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		            return;
		        }
		    		
	    		//가족사항등록 
			   PayrP410003 payrP41003Form = new PayrP410003(ActionDatabase.INSERT, getThis());   
			    
		       MSFFormWindows msFwPayr41003 = new MSFFormWindows("가족사항등록",payrP41003Form,"닫기","520px", "410px",true);
		       msFwPayr41003.show();
		       payrP41003Form.setMSFFormWindows(msFwPayr41003);
		       payrP41003Form.bind(ppRecord);   
	  	    	  
	  	      }   
	  	    }));  
	  	   
	 	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
	 	      @Override  
	 	      public void componentSelected(ButtonEvent ce) {   
	 	    	
	 	    	  //if (isValid()) {
	 	      	  
	 	            actionDatabase = ActionDatabase.UPDATE;
	 	         
	 	           Iterator<Record> iterRecords = payr0530GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
	 	           
	 	           List<Payr0530DTO> listPayr0530dto = new ArrayList<Payr0530DTO>();  
	 	         
	 	         while (iterRecords.hasNext()) {
	 	       
	 	             Record recData = (Record) iterRecords.next(); 
	 	             BaseModel bmMapModel = (BaseModel)recData.getModel();
	 	               
	 	            
	                    Payr0530DTO payr0530Dto = new Payr0530DTO();  
	                    
	                    payr0530Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                    payr0530Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                    payr0530Dto.setPayFamyRsptSeilNum((Long)bmMapModel.get("payFamyRsptSeilNum"));    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
	                    payr0530Dto.setPayFamyResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("payFamyResnRegnNum")));    /** column 급여가족주민번호 : payFamyResnRegnNum */
	                    payr0530Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
	                    payr0530Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd$commCd")));    /** column 가족관계구분코드 : famyRelaDivCd */
	                    payr0530Dto.setFamyAllwPymtYn((Boolean)bmMapModel.get("famyAllwPymtYn"));    /** column 가족수당지급여부 : famyAllwPymtYn */
	                    payr0530Dto.setChdnChdRrgEpnsPymtYn((Boolean)bmMapModel.get("chdnChdRrgEpnsPymtYn"));    /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
	                    payr0530Dto.setFndtnDducYn((Boolean)bmMapModel.get("fndtnDducYn"));    /** column 기본공제여부 : fndtnDducYn */
	                    payr0530Dto.setSpueDducYn((Boolean)bmMapModel.get("spueDducYn"));    /** column 배우자공제여부 : spueDducYn */
	                    payr0530Dto.setWmnDducYn((Boolean)bmMapModel.get("wmnDducYn"));    /** column 부녀자공제여부 : wmnDducYn */
	                    payr0530Dto.setRftaGvstDducYn((Boolean)bmMapModel.get("rftaGvstDducYn"));    /** column 경로우대공제여부 : rftaGvstDducYn */
	                    payr0530Dto.setDabpnDducYn((Boolean)bmMapModel.get("dabpnDducYn"));    /** column 장애자공제여부 : dabpnDducYn */
	                    payr0530Dto.setSgpnFmlyDducYn((Boolean)bmMapModel.get("sgpnFmlyDducYn"));    /** column 한가족공제여부 : sgpnFmlyDducYn */
	                    payr0530Dto.setChdnChdRrgEpnsDducYn((Boolean)bmMapModel.get("chdnChdRrgEpnsDducYn"));    /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
	                    if (MSFSharedUtils.paramNotNull(bmMapModel.get("famyExtpyDivCd$commCdNm"))) {
	                    	payr0530Dto.setFamyExtpyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyExtpyDivCd$commCd")));    /** column 가족수당구분코드 : famyExtpyDivCd */
	                    } else {
	                    	payr0530Dto.setFamyExtpyDivCd("");    /** column 가족수당구분코드 : famyExtpyDivCd */
	                    }
	                    if (MSFSharedUtils.paramNotNull(bmMapModel.get("schlExpnAdmclExtpyDivCd$commCdNm"))) {
	                    	payr0530Dto.setSchlExpnAdmclExtpyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("schlExpnAdmclExtpyDivCd$commCd")));    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
	                    } else {
	                    	payr0530Dto.setSchlExpnAdmclExtpyDivCd("");    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
	                    }
	                    payr0530Dto.setSchlExpnAdmclExtpySum((Long)bmMapModel.get("schlExpnAdmclExtpySum"));    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
	                    payr0530Dto.setFamyExtpySum((Long)bmMapModel.get("famyExtpySum"));    /** column 가족수당금액 : famyExtpySum */
	                    payr0530Dto.setSchlExpnExtpyPymtBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("schlExpnExtpyPymtBgnnDt"),"yyyyMMdd"));    /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
	                    payr0530Dto.setSchlExpnExtpyPymtEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("schlExpnExtpyPymtEndDt"),"yyyyMMdd"));    /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
//	                    payr0530Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//	                    payr0530Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//	                    payr0530Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//	                    payr0530Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//	                    payr0530Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//	                    payr0530Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */ 
	 	  

	                    listPayr0530dto.add(payr0530Dto);
	 	           
	 	         }   
	 	          
	 	         
	 	    		 payr4100Service.activityOnPayr0530(listPayr0530dto, 
	 	                                    actionDatabase,
	 	                                    new AsyncCallback<Long>() {
	 	    			 
	 	                public void onFailure(Throwable caught) {
	 	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	 	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0530(" + actionDatabase.name() + ") : " + caught), null);
	 	                }
	 	                public void onSuccess(Long result) {  
	 	                    reloadPayr0530();
	 	                }	
	 	            });
	 	        //}
	 	      }   
	 	    }));  
	 	    
	 	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
		 	      @Override  
		 	      public void componentSelected(ButtonEvent ce) {   
		 	    	  //if (isValid()) {
		 	      	  
		 	         Iterator<BaseModel> itBm  = payr0530GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		              
		              List<Record>  lsRec  = new ArrayList<Record>();
		              
		              while(itBm.hasNext()) {

		                  Record rec  = new Record(itBm.next()); 
		                  lsRec.add(rec);
		                  
		              } 
		                
		                
		                 Iterator<Record> iterRecords = lsRec.iterator() ;   
		                   
		                 final List<Payr0530DTO> listPayr0530dto = new ArrayList<Payr0530DTO>();  
		                 
		                 while (iterRecords.hasNext()) {
		               
		                     Record recData = (Record) iterRecords.next(); 
		                     BaseModel bmMapModel = (BaseModel)recData.getModel();
		                       
		                    
		                        Payr0530DTO payr0530Dto = new Payr0530DTO(); 
		                      
		                        
		                        payr0530Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
		                        payr0530Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
		                        payr0530Dto.setPayFamyRsptSeilNum((Long)bmMapModel.get("payFamyRsptSeilNum"));    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
		                        payr0530Dto.setPayFamyResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("payFamyResnRegnNum")));    /** column 급여가족주민번호 : payFamyResnRegnNum */
		                        payr0530Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
		                        payr0530Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd$commCd")));    /** column 가족관계구분코드 : famyRelaDivCd */
		                        payr0530Dto.setFamyAllwPymtYn((Boolean)bmMapModel.get("famyAllwPymtYn"));    /** column 가족수당지급여부 : famyAllwPymtYn */
		                        payr0530Dto.setChdnChdRrgEpnsPymtYn((Boolean)bmMapModel.get("chdnChdRrgEpnsPymtYn"));    /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
		                        payr0530Dto.setFndtnDducYn((Boolean)bmMapModel.get("fndtnDducYn"));    /** column 기본공제여부 : fndtnDducYn */
		                        payr0530Dto.setSpueDducYn((Boolean)bmMapModel.get("spueDducYn"));    /** column 배우자공제여부 : spueDducYn */
		                        payr0530Dto.setWmnDducYn((Boolean)bmMapModel.get("wmnDducYn"));    /** column 부녀자공제여부 : wmnDducYn */
		                        payr0530Dto.setRftaGvstDducYn((Boolean)bmMapModel.get("rftaGvstDducYn"));    /** column 경로우대공제여부 : rftaGvstDducYn */
		                        payr0530Dto.setDabpnDducYn((Boolean)bmMapModel.get("dabpnDducYn"));    /** column 장애자공제여부 : dabpnDducYn */
		                        payr0530Dto.setSgpnFmlyDducYn((Boolean)bmMapModel.get("sgpnFmlyDducYn"));    /** column 한가족공제여부 : sgpnFmlyDducYn */
		                        payr0530Dto.setChdnChdRrgEpnsDducYn((Boolean)bmMapModel.get("chdnChdRrgEpnsDducYn"));    /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
		                        payr0530Dto.setFamyExtpyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyExtpyDivCd$commCd")));    /** column 가족수당구분코드 : famyExtpyDivCd */
		                        payr0530Dto.setSchlExpnAdmclExtpyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("schlExpnAdmclExtpyDivCd$commCd")));    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
		                        payr0530Dto.setSchlExpnAdmclExtpySum((Long)bmMapModel.get("schlExpnAdmclExtpySum"));    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
		                        payr0530Dto.setFamyExtpySum((Long)bmMapModel.get("famyExtpySum"));    /** column 가족수당금액 : famyExtpySum */
		                        payr0530Dto.setSchlExpnExtpyPymtBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("schlExpnExtpyPymtBgnnDt"),"yyyyMMdd"));    /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
		                        payr0530Dto.setSchlExpnExtpyPymtEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("schlExpnExtpyPymtEndDt"),"yyyyMMdd"));    /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
//		                      payr0530Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//		                      payr0530Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//		                      payr0530Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//		                      payr0530Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//		                      payr0530Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//		                      payr0530Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */ 
		          

		                        listPayr0530dto.add(payr0530Dto);
		                   
		                 }    
		 	      	  
		 	         	 actionDatabase = ActionDatabase.DELETE;
		 	         	 
		 				MessageBox.confirm("경고", "해당 정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					 	    		 payr4100Service.activityOnPayr0530(listPayr0530dto, actionDatabase,new AsyncCallback<Long>() {
					 	    			 
						 	                public void onFailure(Throwable caught) {
						 	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						 	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0200(" + actionDatabase.name() + ") : " + caught), null);
						 	                }
						 	                public void onSuccess(Long result) {  
						 	                    reloadPayr0530();
						 	                }	
						 	            });
								}
							}
						});
		 	         	 
		 	         	 

		 	        //}
		 	      }   
		 	    }));
	 	    
	 	    lcTabFormLayer.add(cp01); 
		     
		    return lcTabFormLayer;
	 } 
	 
	 private void fnPopupCommP160() {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	            return;
	        }
	       PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
	       sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
	       sysComPsnl0115Dto.setSystemkey(systemkey.getValue());
	       //systemKey 넘김.
	       MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto);  //인사  
	      
	       final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
	      
	       popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	               
	               if (mapModels != null) { 
	                   actionDatabase = ActionDatabase.INSERT;
	                   Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
	                   List<Payr0530DTO> listPayr0530dto = new ArrayList<Payr0530DTO>();  
	                   while (iterRecords.hasNext()) {
	                       BaseModel bmMapModel = (BaseModel) iterRecords.next();
	                       //건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
	                       Payr0530DTO payr0530Dto = new Payr0530DTO();  
	                        
                            payr0530Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                            payr0530Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                            payr0530Dto.setPayFamyRsptSeilNum((Long)bmMapModel.get("famySeilNum"));    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
                            payr0530Dto.setPayFamyResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));    /** column 급여가족주민번호 : payFamyResnRegnNum */
                            payr0530Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("famyNm")));    /** column 한글성명 : hanNm */
                            payr0530Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));    /** column 가족관계구분코드 : famyRelaDivCd */
                            payr0530Dto.setFamyAllwPymtYn(false);    /** column 가족수당지급여부 : famyAllwPymtYn */
                            payr0530Dto.setChdnChdRrgEpnsPymtYn(false);    /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
                            payr0530Dto.setFndtnDducYn(false);    /** column 기본공제여부 : fndtnDducYn */
                            payr0530Dto.setSpueDducYn(false);    /** column 배우자공제여부 : spueDducYn */
                            payr0530Dto.setWmnDducYn(false);    /** column 부녀자공제여부 : wmnDducYn */
                            payr0530Dto.setRftaGvstDducYn(false);    /** column 경로우대공제여부 : rftaGvstDducYn */
                            payr0530Dto.setDabpnDducYn(false);    /** column 장애자공제여부 : dabpnDducYn */
                            payr0530Dto.setSgpnFmlyDducYn(false);    /** column 한가족공제여부 : sgpnFmlyDducYn */
                            payr0530Dto.setChdnChdRrgEpnsDducYn(false);    /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
                            payr0530Dto.setFamyExtpyDivCd("");    /** column 가족수당구분코드 : famyExtpyDivCd */
                            payr0530Dto.setSchlExpnAdmclExtpyDivCd("");    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
                            payr0530Dto.setSchlExpnAdmclExtpySum(0L);    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
                            payr0530Dto.setFamyExtpySum(0L);    /** column 가족수당금액 : famyExtpySum */
                            payr0530Dto.setSchlExpnExtpyPymtBgnnDt("");    /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
                            payr0530Dto.setSchlExpnExtpyPymtEndDt("");    /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
    //	                      payr0530Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
    //	                      payr0530Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
    //	                      payr0530Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
    //	                      payr0530Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
    //	                      payr0530Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
    //	                      payr0530Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */ 
	           
	                        listPayr0530dto.add(payr0530Dto);
	                   
	                 }    
	                 
	                     payr4100Service.activityOnPayr0530(listPayr0530dto, 
	                                            actionDatabase,
	                                            new AsyncCallback<Long>() {
	                         
	                        public void onFailure(Throwable caught) {
	                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                    MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0530(" + actionDatabase.name() + ") : " + caught), null);
	                        }
	                        public void onSuccess(Long result) {  
	                            reloadPayr0530();
	                        }   
	                    });
	               }  
	            
	               
	           }
	       });
	   }
	 
	 //수당
	 private LayoutContainer Data02() { 

		 
		   LayoutContainer lcTabFormLayer = new LayoutContainer(); 
//	  	    
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(615, 195);  
  
	  	   
	  	  ToolBar toolBar = new ToolBar();
          toolBar.getAriaSupport().setLabel("년도");

          toolBar.add(new LabelToolItem("년도: "));
          srhPayrYr01 = new ComboBox<BaseModel>();
          srhPayrYr01.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
          srhPayrYr01.setTriggerAction(TriggerAction.ALL);
          srhPayrYr01.setEditable(false);
          srhPayrYr01.setEmptyText("--년도선택--");
          srhPayrYr01.setFireChangeEventOnSetValue(true);
          srhPayrYr01.setWidth(150);
          srhPayrYr01.setDisplayField("payYrDisp");
          srhPayrYr01.setValueField("payYr");
          srhPayrYr01.setReadOnly(false);
          srhPayrYr01.setStore(lsPayYrStore01); 
          srhPayrYr01.addListener(Events.Change, new Listener<FieldEvent>() {
            public void handleEvent(FieldEvent be) {
            	if (MSFSharedUtils.paramNull(systemkey.getValue())) {
    	    		 return;
         	     }
            	 if (boolPymtDduc) {     
	                IColumnFilter filters = null;
	                payr0520GridPanel.getTableDef().setTableColumnFilters(filters);
	              
	                payr0520GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
	     		    payr0520GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	     		    payr0520GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", "B0080010,B0080020", SimpleColumnFilter.OPERATOR_EQUALS);  
	                payr0520GridPanel.getTableDef().addColumnFilter("pymtDducItemBgnnDt", MSFSharedUtils.getSelectedComboValue(srhPayrYr01,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                payr0520GridPanel.reload(); 
            	 }
            }
          });
          toolBar.add(srhPayrYr01); 
          
          cp01.setTopComponent(toolBar);
	 		 
		 	  //msfCustomForm.setHeaderVisible(false);
	        //Instantiate the GridPanel
	  	payr0520GridPanel = new MSFGridPanel(payr0520Def, false, false, false, false, false);
	  	payr0520GridPanel.setHeaderVisible(false);  
	  	payr0520GridPanel.setBodyBorder(true);
	  	payr0520GridPanel.setBorders(true);
	//  	payr0520GridPanel.setGridType(MSFGridType.GROUPBY);
	  	payr0520GridPanel.setSize(615, 215);  
//		    final Grid payr0520Grid = payr0520GridPanel.getMsfGrid().getGrid(); 
//		    payr0520Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//	             public void handleEvent(BaseEvent be) {  
//	           	  if (payr0520GridPanel.getCurrentlySelectedItem() != null) {  
//	           		  setRecord(payr0520GridPanel.getCurrentlySelectedItem());	
//	           		  actionDatabase = ActionDatabase.UPDATE;
//	           	  }
//	             }
//	         });  
// 	  

	    cp01.add(payr0520GridPanel);  
		 
// 	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
// 	      @Override  
// 	      public void componentSelected(ButtonEvent ce) {   
// 	    	   
// 	    	   BaseModel bm = new BaseModel();
//			   
//			   bm = payr0520GridPanel.getTableDef().getDefaultValues();
//			   RowEditor rowEdit = new RowEditor();
//			   
//			   /**================================================================================= 
//			   //인서트시 초기셋팅부분 .
//			   ====================================================================================*/ 
//			   bm.set("dpobCd", "");
//			   bm.set("systemkey", "");
//			   bm.set("payItemCd", new ListStore<BaseModel>());
//			   bm.set("pymtDducItemSilNum", 0);
//			   /**================================================================================= 
//			   //인서트시 초기셋팅부분 .
//			   ====================================================================================*/ 
//			    
//			    for (int i=0;i < payr0520GridPanel.getGrid().getPlugins().size();i++) {
//			    	if (payr0520GridPanel.getGrid().getPlugins().get(i) instanceof RowEditor) {
//			    		rowEdit = (RowEditor)payr0520GridPanel.getGrid().getPlugins().get(i);
//			    		rowEdit.stopEditing(false);  
//			    		payr0520GridPanel.getGrid().getStore().insert(bm, 1);  
//			    		rowEdit.startEditing(payr0520GridPanel.getGrid().getStore().indexOf(bm), true);  
//			    	    break;
//			    	}
//			    }
// 	    	 
//			    actionDatabase = ActionDatabase.INSERT;
// 	      }   
// 	    }));  
// 	   
//	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	      @Override  
//	      public void componentSelected(ButtonEvent ce) {   
//	    	
//	    	  //if (isValid()) {
//	      	  
//	      	  Payr0520DTO payr0520Dto = new Payr0520DTO(); 
//	      	 
//	      	  /**
//	      	  bass0200Dto.setDpobCd(dpobCd.getValue()==null?null:dpobCd.getValue());     //사업장코드 
//	      	  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	      	  bass0200Dto.setYear(fmt.format(yearMnthDay.getValue()));//휴일일자
//	      	  fmt = DateTimeFormat.getFormat("MM"); 
//	    		  bass0200Dto.setMnth(fmt.format(yearMnthDay.getValue()));  
//	    		  fmt = DateTimeFormat.getFormat("dd"); 
//	    		  bass0200Dto.setDay(fmt.format(yearMnthDay.getValue()));         
//	    		  bass0200Dto.setDotwCd((String)dotwCd.getValue().get("commCd"));  //요일코드  
//	    		  bass0200Dto.setPubcHodyCtnt(pubcHodyCtnt.getValue());  //휴일명 
//	    		 // bass0200Dto.setPubcHodyYn(pubcHodyYn.getValue()==null?"N":"Y") ;   //휴일유무
//	    		 // bass0200Dto.setPaidPubcHodyYn(paidPubcHodyYn.getValue()==null?"N":"Y");  //유급휴일여부   
//	      	    */
//	      	   
//	    		 payr4100Service.activityOnPayr0520(payr0520Dto, 
//	                                    actionDatabase,
//	                                    new AsyncCallback<Long>() {
//	    			 
//	                public void onFailure(Throwable caught) {
//	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0520(" + actionDatabase.name() + ") : " + caught), null);
//	                }
//	                public void onSuccess(Long result) { 
//	                	
//	                    reloadPayr0520();
//	                }	
//	            });
//	        //}
//	      }   
//	    }));  
//	    
//	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	    	  //if (isValid()) {
//	 	      	  
//	 	      	  Payr0520DTO payr0520Dto = new Payr0520DTO(); 
//	 	      	 
//	 	      	  /**
//	 	      	  bass0200Dto.setDpobCd(dpobCd.getValue()==null?null:dpobCd.getValue());     //사업장코드 
//	 	      	  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	 	      	  bass0200Dto.setYear(fmt.format(yearMnthDay.getValue()));//휴일일자
//	 	      	  fmt = DateTimeFormat.getFormat("MM"); 
//	 	    		  bass0200Dto.setMnth(fmt.format(yearMnthDay.getValue()));  
//	 	    		  fmt = DateTimeFormat.getFormat("dd"); 
//	 	    		  bass0200Dto.setDay(fmt.format(yearMnthDay.getValue()));         
//	 	    		  bass0200Dto.setDotwCd((String)dotwCd.getValue().get("commCd"));  //요일코드  
//	 	    		  bass0200Dto.setPubcHodyCtnt(pubcHodyCtnt.getValue());  //휴일명 
//	 	    		 // bass0200Dto.setPubcHodyYn(pubcHodyYn.getValue()==null?"N":"Y") ;   //휴일유무
//	 	    		 // bass0200Dto.setPaidPubcHodyYn(paidPubcHodyYn.getValue()==null?"N":"Y");  //유급휴일여부   
//	 	      	    */
//	 	      	  
//	 	         	actionDatabase = ActionDatabase.DELETE;
//	 	    		 payr4100Service.activityOnPayr0520(payr0520Dto, 
//	 	                                    actionDatabase,
//	 	                                    new AsyncCallback<Long>() {
//	 	    			 
//	 	                public void onFailure(Throwable caught) {
//	 	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	 	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0520(" + actionDatabase.name() + ") : " + caught), null);
//	 	                }
//	 	                public void onSuccess(Long result) { 
//	 	                	
//	 	                    reloadPayr0520();
//	 	                }	
//	 	            });
//	 	        //}
//	 	      }   
//	 	    }));
	 	    
	 	    lcTabFormLayer.add(cp01); 
		   
		    return lcTabFormLayer;
	 } 
	 //공제
	 private LayoutContainer Data03() {
		   
		 LayoutContainer lcTabFormLayer = new LayoutContainer();
		  
 
	  	    
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(615, 195);  
	  	  
	  	   
	  	   ToolBar toolBar = new ToolBar();
	       toolBar.getAriaSupport().setLabel("년도");
	
	       toolBar.add(new LabelToolItem("년도: "));
	       srhPayrYr02 = new ComboBox<BaseModel>();
	       srhPayrYr02.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
	       srhPayrYr02.setTriggerAction(TriggerAction.ALL);
	       srhPayrYr02.setEditable(false);
	       srhPayrYr02.setEmptyText("--년도선택--");
	       srhPayrYr02.setFireChangeEventOnSetValue(true);
	       srhPayrYr02.setWidth(150);
	       srhPayrYr02.setDisplayField("payYrDisp");
	       srhPayrYr02.setValueField("payYr");
	       srhPayrYr02.setReadOnly(false);
	       srhPayrYr02.setStore(lsPayYrStore02); 
	       srhPayrYr02.addListener(Events.Change, new Listener<FieldEvent>() {
	         public void handleEvent(FieldEvent be) {
	        	 
	        	 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	 	    		 return;
	      	     }
	        	 
	        	 if (boolPymtDduc) {  
	        	
		             IColumnFilter filters = null;
		             payr0520DducGridPanel.getTableDef().setTableColumnFilters(filters); 
		             
		             payr0520DducGridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		             payr0520DducGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		             payr0520DducGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", "B0080030,B0080040", SimpleColumnFilter.OPERATOR_EQUALS); 
		  		   
		             payr0520DducGridPanel.getTableDef().addColumnFilter("pymtDducItemBgnnDt", MSFSharedUtils.getSelectedComboValue(srhPayrYr02,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
		             payr0520DducGridPanel.reload(); 
	        	 }
	         }
	       });
	       toolBar.add(srhPayrYr02);
	  	    
	       
	       cp01.setTopComponent(toolBar);
	  	   
	          payr0520DducGridPanel = new MSFGridPanel(payr0520DducDef, false, false, false, false);
	          payr0520DducGridPanel.setHeaderVisible(false);  
	          payr0520DducGridPanel.setBodyBorder(true);
	          payr0520DducGridPanel.setBorders(true);
	      //    payr0520DducGridPanel.setGridType(MSFGridType.GROUPBY);
	          payr0520DducGridPanel.setSize(615, 215);  
//			    final Grid payr0520DducGrid = payr0520DducGridPanel.getMsfGrid().getGrid(); 
//			    payr0520DducGrid.addListener(Events.Select,  new Listener<BaseEvent>() {
//		             public void handleEvent(BaseEvent be) {  
//		           	  if (payr0520DducGridPanel.getCurrentlySelectedItem() != null) {  
//		           		  setRecord(payr0520DducGridPanel.getCurrentlySelectedItem());	
//		           		  actionDatabase = ActionDatabase.READ;
//		           	  }
//		             }
//		         });  
//	 	  

		    cp01.add(payr0520DducGridPanel);  
	  	  
//	  	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
//	  	    grid.setSelectionModel(sm);   
//	  	    grid.setBorders(true);   
//	  	    grid.setColumnReordering(true);   
//	  	   // grid.getAriaSupport().setLabelledBy(cp01.getHeader().getId() + "-label");   
//	  	    grid.addPlugin(sm);    
//	 		
//	  	    cp01.add(grid);
	 		 
//	  	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	  	      @Override  
//	  	      public void componentSelected(ButtonEvent ce) {   
//	  	         
//	  	      }   
//	  	    }));  
//	  	   
//	 	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	         
//	 	      }   
//	 	    }));  
//	 	    
//	 	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
//		 	      @Override  
//		 	      public void componentSelected(ButtonEvent ce) {   
//		 	         
//		 	      }   
//		 	    }));
	 	    
	 	    lcTabFormLayer.add(cp01); 
	 	    
		    return lcTabFormLayer;
	 } 
	  
	//지급계좌
	 private LayoutContainer Data04() {
		   

    LayoutContainer lcTabFormLayer = new LayoutContainer();
    
	    
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(615, 195);  
	   
	     psnl0130GridPanel = new MSFGridPanel(psnl0130Def, false, false, false, false);
		 psnl0130GridPanel.setHeaderVisible(false);  
		 psnl0130GridPanel.setBodyBorder(true);
		 psnl0130GridPanel.setBorders(true);
		// psnl0130GridPanel.setGridType(MSFGridType.GROUPBY);
		// psnl0130GridPanel.setSize(598, 184);   
				    final Grid psnl0130Grid = psnl0130GridPanel.getMsfGrid().getGrid(); 
				    psnl0130Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
			             public void handleEvent(BaseEvent be) {  
			           	  if (psnl0130GridPanel.getCurrentlySelectedItem() != null) {  
			           		  setRecord(psnl0130GridPanel.getCurrentlySelectedItem());	
			           		  actionDatabase = ActionDatabase.UPDATE;
			           	  }
			             }
			         });  
//		 	  

			    cp01.add(psnl0130GridPanel);  
	   
//		 
//	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	      @Override  
//	      public void componentSelected(ButtonEvent ce) {   
//	         
//	      }   
//	    }));  
//	   
//	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	      @Override  
//	      public void componentSelected(ButtonEvent ce) {   
//	         
//	      }   
//	    }));  
//	    
//	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	         
//	 	      }   
//	 	}));
	    
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;
	 } 
		 
		//채권압류
		 private LayoutContainer Data05() {
			   

	         LayoutContainer lcTabFormLayer = new LayoutContainer();
   
	  	    
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(615, 195); 
	  	   
	  	payr0220GridPanel = new MSFGridPanel(payr0220Def, false, false, false, false);
	  	payr0220GridPanel.setHeaderVisible(false);  
	  	payr0220GridPanel.setBodyBorder(true);
	  	payr0220GridPanel.setBorders(true);
	  //	payr0220GridPanel.setGridType(MSFGridType.GROUPBY);
	  	payr0220GridPanel.setSize(615, 215);  
					    final Grid payr0220Grid = payr0220GridPanel.getMsfGrid().getGrid(); 
					    payr0220Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
				             public void handleEvent(BaseEvent be) {  
				           	  if (payr0220GridPanel.getCurrentlySelectedItem() != null) {  
				           		  setRecord(payr0220GridPanel.getCurrentlySelectedItem());	
				           		  actionDatabase = ActionDatabase.UPDATE;
				           	  }
				             }
				         });  
//			 	  

				    cp01.add(payr0220GridPanel);  
		  
	  	   
	 		 
//	  	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	  	      @Override  
//	  	      public void componentSelected(ButtonEvent ce) {   
//	  	         
//	  	      }   
//	  	    }));  
//	  	   
//	 	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	         
//	 	      }   
//	 	    }));  
//	 	    
//	 	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
//		 	      @Override  
//		 	      public void componentSelected(ButtonEvent ce) {   
//		 	         
//		 	      }   
//		 	    }));
	 	    
	 	    lcTabFormLayer.add(cp01); 
	 	     
			return lcTabFormLayer;
		 } 
		 
		 //퇴직정산
		 private LayoutContainer Data06() {
			   

	        LayoutContainer lcTabFormLayer = new LayoutContainer();

 
	        ContentPanel cp01 = new ContentPanel();   
	  	    cp01.setBodyBorder(false); 
	  	    cp01.setHeaderVisible(false);   
	  	    cp01.setLayout(new FitLayout());      
	  	    cp01.setSize(615, 195);   
		  	   
	  
		    remt3500GridPanel = new MSFGridPanel(remt3500Def, false, false, false, false);
		  	remt3500GridPanel.setHeaderVisible(false);  
		  	remt3500GridPanel.setBodyBorder(true);
		  	remt3500GridPanel.setBorders(true);
		  //	remt3500GridPanel.setVisible(false);
//		   	remt3500GridPanel.setGridType(MSFGridType.GROUPBY);
		  //	remt3500GridPanel.setSize(936, 440); 
//						    final Grid payr0220Grid = payr0220GridPanel.getMsfGrid().getGrid(); 
//						    payr0220Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//					             public void handleEvent(BaseEvent be) {  
//					           	  if (payr0220GridPanel.getCurrentlySelectedItem() != null) {  
//					           		  setRecord(payr0220GridPanel.getCurrentlySelectedItem());	
//					           		  actionDatabase = ActionDatabase.UPDATE;
//					           	  }
//					             }
//					         });  
////				 	  
//
 			 cp01.add(remt3500GridPanel);  
	  	    
	 		
//	  	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	  	      @Override  
//	  	      public void componentSelected(ButtonEvent ce) {   
//	  	         
//	  	      }   
//	  	    }));  
//	  	   
//	 	      cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	         
//	 	      }   
//	 	    }));  
	 	    
	 	    lcTabFormLayer.add(cp01); 
	 	     
			    return lcTabFormLayer;
		 } 
		 
		 //휴직관리
		 private LayoutContainer Data07() { 

	        LayoutContainer lcTabFormLayer = new LayoutContainer(); 
	  	    
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(615, 195);   
	  	   
	  	   
	  	 psnl0123GridPanel = new MSFGridPanel(psnl0123Def, false, false, false, false);
	   	 psnl0123GridPanel.setHeaderVisible(false);  
	  	 psnl0123GridPanel.setBodyBorder(true);
	  	 psnl0123GridPanel.setBorders(true);
	  //	 psnl0123GridPanel.setGridType(MSFGridType.GROUPBY);
	  //	 psnl0123GridPanel.setSize(598, 184);   
//		    final Grid psnl0123Grid = psnl0123GridPanel.getMsfGrid().getGrid(); 
//		    psnl0123Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//	             public void handleEvent(BaseEvent be) {  
//	           	  if (psnl0123GridPanel.getCurrentlySelectedItem() != null) {  
//	           		  setRecord(psnl0123GridPanel.getCurrentlySelectedItem());	
//	           		  actionDatabase = ActionDatabase.UPDATE;
//	           	  }
//	             }
//	         });  
//				 	  

		  cp01.add(psnl0123GridPanel);  
	  	    
	 		
	  	  
	 		
//	  	    cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	  	      @Override  
//	  	      public void componentSelected(ButtonEvent ce) {   
//	  	         
//	  	      }   
//	  	    }));  
//	  	   
//	 	    cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	         
//	 	      }   
//	 	    }));  
	 	    
	 	    lcTabFormLayer.add(cp01); 
	 	     
			    return lcTabFormLayer;
		 } 
		 
			//예외처리
		 private LayoutContainer Data08() {
			   

	         LayoutContainer lcTabFormLayer = new LayoutContainer();
 
		  	    
		    final ContentPanel cpGridPayr0540 = new ContentPanel();   
		  	cpGridPayr0540.setBodyBorder(false); 
		  	cpGridPayr0540.setHeaderVisible(false);   
		  	cpGridPayr0540.setLayout(new FitLayout());      
		  	cpGridPayr0540.setSize(615, 185);  
		  	  
		  	 payr0540GridPanel = new MSFGridPanel(payr0540Def, false, false, false, false,false);
		  	 payr0540GridPanel.setHeaderVisible(false);  
		  	 payr0540GridPanel.setBodyBorder(true);
		  	 payr0540GridPanel.setBorders(true);
		// 	 payr0540GridPanel.setGridType(MSFGridType.GROUPBY);
		 	 payr0540GridPanel.setSize(615, 210);   
		 						    final Grid payr0540Grid = payr0540GridPanel.getMsfGrid().getGrid(); 
		 						   payr0540Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
		 					             public void handleEvent(BaseEvent be) {  
		 					           	  if (payr0540GridPanel.getCurrentlySelectedItem() != null) {  
		 					           		  setRecord(payr0540GridPanel.getCurrentlySelectedItem());	
		 					           		  actionDatabase = ActionDatabase.UPDATE;
		 					           	  }
		 					             }
		 					         });  
//		 				 	  

		 cpGridPayr0540.add(payr0540GridPanel);   
 
		 		 
		 cpGridPayr0540.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
 	      @Override  
 	      public void componentSelected(ButtonEvent ce) {   
 	    	   
 	    	 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
 	    		 return;
      	     }
// 	    	   BaseModel bm = new BaseModel();
//			   
//			   bm = payr0540GridPanel.getTableDef().getDefaultValues();
//			   RowEditor rowEdit = new RowEditor();
//			   
//			   /**================================================================================= 
//			   //인서트시 초기셋팅부분 .
//			   ====================================================================================*/ 
//			   bm.set("dpobCd", dpobCd.getValue());
//			   bm.set("systemkey", systemkey.getValue());
//			   bm.set("payItemCd", new ListStore<BaseModel>());
//			   bm.set("pymtDducItemSilNum", 0);
//			   /**================================================================================= 
//			   //인서트시 초기셋팅부분 .
//			   ====================================================================================*/ 
//			    
//			    for (int i=0;i < payr0540GridPanel.getGrid().getPlugins().size();i++) {
//			    	if (payr0540GridPanel.getGrid().getPlugins().get(i) instanceof RowEditor) {
//			    		rowEdit = (RowEditor)payr0540GridPanel.getGrid().getPlugins().get(i);
//			    		rowEdit.stopEditing(false);  
//			    		payr0540GridPanel.getGrid().getStore().insert(bm, 1);  
//			    		rowEdit.startEditing(payr0540GridPanel.getGrid().getStore().indexOf(bm), true);  
//			    	    break;
//			    	}
//			    }
 	          
 	          payr0540GridPanel.getMsfGrid().clearData();
             //TODO 부서에 따른 사업 및 직종처리 로직 추가해야 함
              BaseModel bmData = payr0540GridPanel.getTableDef().getDefaultValues();  
              
              bmData.set("dpobCd", dpobCd.getValue());/** column 사업장코드 : dpobCd */
              bmData.set("systemkey", systemkey.getValue());;    /** column 작업년월 : jobYrMnth */
              bmData.set("exptnPrcsSeilNum",0L);     /** column 예외처리일련번호 : exptnPrcsSeilNum */
              bmData.set("exptnDivCd",new BaseModel());    /** column 예외구분코드 : exptnDivCd */
            
              bmData.set("exmtnYn",true);     /** column 면제여부 : exmtnYn */
              bmData.set("exptnPrcsPymtSum",0L);     /** column 예외처리공제금액 : exptnPrcsPymtSum */
              bmData.set("exptnPrcsPymtRto",0.0);     /** column 예외처리공제비율 : exptnPrcsPymtRto */
              //bmData.set("exptnPrcsBgnnDt","");     /** column 예외처리시작일자 : exptnPrcsBgnnDt */
             // bmData.set("exptnPrcsEndDt","");     /** column 예외처리종료일자 : exptnPrcsEndDt */
              bmData.set("payItemCd",new BaseModel());      /** column 급여항목코드 : payItemCd */
              bmData.set("exptnPrcsNoteCtnt","");     /** column 예외처리내용 : exptnPrcsNoteCtnt */
              
              payr0540GridPanel.getMsfGrid().getGrid().stopEditing();      
              payr0540GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
              payr0540GridPanel.getMsfGrid().getGrid().startEditing(payr0540GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
              payr0540GridPanel.setSize(598, (184 - (cpGridPayr0540.getButtonBar().getHeight() + 10)) );  
               
			  actionDatabase = ActionDatabase.INSERT;
 	      }   
 	    }));  
 	   
		 cpGridPayr0540.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {   
	    	
	    	  //if (isValid()) {
	          boolean checkField = true;
	          
	      //    actionDatabase = ActionDatabase.UPDATE;
	    	   
              Iterator<Record> iterRecords = payr0540GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
              
              List<Payr0540DTO> listPayr0540dto = new ArrayList<Payr0540DTO>();  
            
              while (iterRecords.hasNext()) {
          
                Record recData = (Record) iterRecords.next(); 
                BaseModel bmMapModel = (BaseModel)recData.getModel();
                  
                Payr0540DTO payr0540Dto = new Payr0540DTO();  
               
                payr0540Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                payr0540Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                payr0540Dto.setExptnPrcsSeilNum((Long)bmMapModel.get("exptnPrcsSeilNum"));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
                payr0540Dto.setExptnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("exptnDivCd$commCd")));    /** column 예외구분코드 : exptnDivCd */
                payr0540Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
                payr0540Dto.setExmtnYn((Boolean)bmMapModel.get("exmtnYn"));    /** column 면제여부 : exmtnYn */
                payr0540Dto.setExptnPrcsPymtSum((Long)bmMapModel.get("exptnPrcsPymtSum"));    /** column 예외처리공제금액 : exptnPrcsPymtSum */
                payr0540Dto.setExptnPrcsPymtRto((Double)bmMapModel.get("exptnPrcsPymtRto"));    /** column 예외처리공제비율 : exptnPrcsPymtRto */
                payr0540Dto.setExptnPrcsBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsBgnnDt"),"yyyyMMdd")  );    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
                payr0540Dto.setExptnPrcsEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsEndDt"),"yyyyMMdd"));    /** column 예외처리종료일자 : exptnPrcsEndDt */
                //payr0540Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
                //payr0540Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
                //payr0540Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
                //payr0540Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
                //payr0540Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
                //payr0540Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */
                payr0540Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
                payr0540Dto.setExptnPrcsNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("exptnPrcsNoteCtnt")));    /** column 예외처리내용 : exptnPrcsNoteCtnt */
  
                if (MSFSharedUtils.paramNull(systemkey.getValue())) {
                	checkField = false;
       	            break;
       	          }
                listPayr0540dto.add(payr0540Dto);
              
            }   
              
            if (checkField) {
	             payr4100Service.activityOnPayr0540(listPayr0540dto, 
	                                    actionDatabase,
	                                    new AsyncCallback<Long>() {
	                 
	                public void onFailure(Throwable caught) {
	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0540(" + actionDatabase.name() + ") : " + caught), null);
	                }
	                public void onSuccess(Long result) { 
	                    
	                    reloadPayr0540();
	                    actionDatabase = ActionDatabase.UPDATE;
	                }   
	            }); 
            }
	        //}
	      }   
	    }));  
	    
		 cpGridPayr0540.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
	 	      @Override  
	 	      public void componentSelected(ButtonEvent ce) {   
	 	    	  //if (isValid()) {
	 	    	 boolean checkField = true;
	 	    	 
	 	         Iterator<BaseModel> itBm  = payr0540GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
                 
                 List<Record>  lsRec  = new ArrayList<Record>();
                 
                 while(itBm.hasNext()) {

                     Record rec  = new Record(itBm.next()); 
                     lsRec.add(rec);
                     
                 } 
                   
                   
                    Iterator<Record> iterRecords = lsRec.iterator() ;   
                      
                    final List<Payr0540DTO> listPayr0540dto = new ArrayList<Payr0540DTO>();  
                    
                    while (iterRecords.hasNext()) {
                  
                        Record recData = (Record) iterRecords.next(); 
                        BaseModel bmMapModel = (BaseModel)recData.getModel();
                          

                          Payr0540DTO payr0540Dto = new Payr0540DTO();   

                          payr0540Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                          payr0540Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                          payr0540Dto.setExptnPrcsSeilNum((Long)bmMapModel.get("exptnPrcsSeilNum"));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
                          payr0540Dto.setExptnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("exptnDivCd$commCd")));    /** column 예외구분코드 : exptnDivCd */
                          payr0540Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
                          payr0540Dto.setExmtnYn((Boolean)bmMapModel.get("exmtnYn"));    /** column 면제여부 : exmtnYn */
                          payr0540Dto.setExptnPrcsPymtSum((Long)bmMapModel.get("exptnPrcsPymtSum"));    /** column 예외처리공제금액 : exptnPrcsPymtSum */
                          payr0540Dto.setExptnPrcsPymtRto((Double)bmMapModel.get("exptnPrcsPymtRto"));    /** column 예외처리공제비율 : exptnPrcsPymtRto */
                          payr0540Dto.setExptnPrcsBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsBgnnDt"),"yyyyMMdd")  );    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
                          payr0540Dto.setExptnPrcsEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsEndDt"),"yyyyMMdd"));    /** column 예외처리종료일자 : exptnPrcsEndDt */
                          //payr0540Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
                          //payr0540Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
                          //payr0540Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
                          //payr0540Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
                          //payr0540Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
                          //payr0540Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */
                          payr0540Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
                          payr0540Dto.setExptnPrcsNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("exptnPrcsNoteCtnt")));    /** column 예외처리내용 : exptnPrcsNoteCtnt */
            
                          if (MSFSharedUtils.paramNull(systemkey.getValue())) {
                          	checkField = false;
                 	            break;
                 	      }
                          listPayr0540dto.add(payr0540Dto);
                      
                    }    
                  
                    if (checkField) {
		 	          	 actionDatabase = ActionDatabase.DELETE;
		 	          	 
		 				MessageBox.confirm("경고", "해당 정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					 	    		 payr4100Service.activityOnPayr0540(listPayr0540dto, actionDatabase,new AsyncCallback<Long>() {
					 	    			 
						 	                public void onFailure(Throwable caught) {
						 	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						 	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0540(" + actionDatabase.name() + ") : " + caught), null);
						 	                }
						 	                public void onSuccess(Long result) { 
						 	                    reloadPayr0540();
						 	                }	
						 	            });
								}
							}
						});
                    } 
	 	        //}
	 	      }   
	 	    }));
		 	    
		 	    lcTabFormLayer.add(cpGridPayr0540);  
	 	      
			    return lcTabFormLayer;
		 }   
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
			// TODO Auto-generated method stub
		     
			IColumnFilter filters = null;
			psnl0100GridPanel.getTableDef().setTableColumnFilters(filters);
			
			psnl0100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			psnl0100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
			 //20180305추가 
			 psnl0100GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			 psnl0100GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 

		     String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
             psnl0100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
          // psnl0100GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd")), SimpleColumnFilter.OPERATOR_EQUALS); 
            
             String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             psnl0100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           //psnl0100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
          //   String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
          //   psnl0100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
           //psnl0100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
             psnl0100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           //psnl0100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
	         
			psnl0100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			  
		//	psnl0100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(srhHdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			 
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
	        psnl0100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             
			psnl0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			psnl0100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
			psnl0100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			 
			 
			psnl0100GridPanel.reload();
		}
	  
	
		// 폼초기화 
		private void formInit() {
	
			tabsPsnlTop.setSelection(tabsPsnlTop.getItem(0));
			tabsPsnl.setSelection(tabsPsnl.getItem(0));
			
			resetStandardForm();	// 기본사항 초기화
			resetDetailForm();		// 상세정보 초기화
			resetGridPanel();		// 그리드 초기화
	
		}
		
		/**
		 * 
		 * <pre>
		 * 1. 개요 : 가족수당 대상자 정보를 팝업으로 띄워 검색
		 * 2. 처리내용 : 검색조건에 의해 가족수당대상자리스트를 출력하기 위한 팝업 호출 
		 * </pre>
		 * @Method Name : formFmyTgtPop
		 * @date : 2016. 12. 15.
		 * @author : atres-pc
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	2016. 12. 15.		atres-pc				최초 작성 
		 *	-----------------------------------------------------------------------
		 *
		 */
		private void formFmyTgtPop() {
	 
			  PayrP410005 payrP410005Form = new PayrP410005(ActionDatabase.CUSTOM, getThis());   
			    
		      //가족수당대상자 
			  MSFFormWindows msFwPayr410005 = new MSFFormWindows("가족수당대상자",payrP410005Form,"닫기","1010px", "660px",true);
			  msFwPayr410005.show();
			  payrP410005Form.setMSFFormWindows(msFwPayr410005);
		     // payrP410005Form.bind(ppRecord);   
			  
		} 
		
		// 기본사항 초기화
		private void resetStandardForm() {
			
			systemkey.setValue("");       					/**  column SYSTEMKEY : systemkey */
			dpobCd.setValue("");        					/**  column 사업장코드 : dpobCd */
		                                          
				                        
		    hanNm.setValue("");        						/**  column 한글성명 : hanNm */
		    resnRegnNum.setValue("");		 				/**  column 주민등록번호 : resnRegnNum */
		    secRegnNum.setValue("");     					/**  column 주민등록번호 : secRegnNum */
		      
		    typOccuNm.setValue("");        					/**  column 직종코드 : typOccuNm */
		    dtilOccuClsDivNm.setValue(""); 					/**  column 직종세구분코드 : dtilOccuClsDivNm */
		    emymtDivNm.setValue("");     					/**  column 고용구분 : emymtDivNm */
		    emymtDivCd.setValue("");      					/**  column 고용구분코드 : emymtDivCd */
		      
		    payrMangDeptCd.setValue("") ;  					/**  column 관리부서코드 : payrMangDeptCd */ 
		    payrMangDeptNm.setValue("");  					/**  column 관리부서코드 : payrMangDeptNm */ 
		    currAffnDeptNm.setValue(""); 					/**  column 현소속부서코드 : currAffnDeptNm */
		    businNm.setValue("");     						/**  column 사업코드 : businNm */
		    frstEmymtDt.setValue("");               		/**  column 최초고용일자 : frstEmymtDt */
		    logSvcYrNumCd.setValue(new BaseModel());  		/**  column 근속년수코드 : logSvcYrNumCd */
		    logSvcMnthIcmCd.setValue(new BaseModel());    	/**  column 근속월수코드 : logSvcYrNumNm */
		       
		      
		    pyspCd.setValue(new BaseModel());          		/**  column 호봉 : pyspCd */
		    unnMbspSttYn.setValue(false);                	/**  column 노조가입여부 : unnMbspSttYn */
		    
		    wmnYn.setValue(false);                      	/**  column 부녀자여부 : wmnYn */
		    retryClutYn.setValue(false);              		/**  column 퇴직정산여부 : retryClutYn */
		    payRcptYn.setValue(false);                		/**  column 급여대상자여부 : payRcptYn */
				               
		      
		      
		    typOccuCd.setValue("");                  		/**  column 직종코드 : typOccuCd */
		    dtilOccuInttnCd.setValue("");           		/**  column 직종세구분코드 : dtilOccuInttnCd */
		    currAffnDeptCd.setValue("");       				/**  column 현소속부서코드 : currAffnDeptCd */
		    businCd.setValue("") ;                     		/**  column 사업코드 : businCd */  ;               
		    secRegnNum.setValue("") ;                		/**  column 주민등록번호 : secRegnNum */
		     
		    typOccuNm.setValue("") ;                  		/**  column 직종코드 : typOccuNm */
		    dtilOccuClsDivNm.setValue("") ;           		/**  column 직종세구분코드 : dtilOccuClsDivNm */
		    emymtDivNm.setValue("");                  		/**  column 고용구분 : emymtDivNm */
		    emymtDivCd.setValue("");                  		/**  column 고용구분코드 : emymtDivCd */
		    hdofcCodtnNm.setValue("");                      /**  column 재직상태코드 : hdofcCodtnNm */
		
		    payrMangDeptCd.setValue("");                	/**  column 관리부서코드 : payrMangDeptCd */ 
		    payrMangDeptNm.setValue("");                	/**  column 관리부서코드 : payrMangDeptNm */ 
		    currAffnDeptNm.setValue("");       				/**  column 현소속부서코드 : currAffnDeptNm */
		    businNm.setValue("");                     		/**  column 사업코드 : businNm */
		    frstEmymtDt.setValue("");                 		/**  column 최초고용일자 : frstEmymtDt */
		    logSvcYrNumCd.setValue(new BaseModel());  		/**  column 근속년수코드 : logSvcYrNumCd */
		    logSvcMnthIcmCd.setValue(new BaseModel());   	/**  column 근속월수코드 : logSvcYrNumNm */
		       
		    pyspCd.setValue(new BaseModel());              	/**  column 호봉 : pyspCd */
		    unnMbspSttYn.setValue(false);                 	/**  column 노조가입여부 : unnMbspSttYn */
		    
		    addIncmTxApptnRtoCd.setValue(new BaseModel());  /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
		      
		    typOccuCd.setValue("");                  		/**  column 직종코드 : typOccuCd */
		    dtilOccuInttnCd.setValue("");           		/**  column 직종세구분코드 : dtilOccuInttnCd */
		    currAffnDeptCd.setValue("");       				/**  column 현소속부서코드 : currAffnDeptCd */
		    businCd.setValue("");              				/**  column 사업코드 : businCd */

		}
		
		// 상세정보 초기화
		private void resetDetailForm() {
			
			hlthInsrApptnYn.setValue(false);              	/**  column 건강보험적용여부 : hlthInsrApptnYn */
		    natPennApptnYn.setValue(false);            		/**  column 국민연금적용여부 : natPennApptnYn */
		    umytInsrApptnYn.setValue(false);            	/**  column 고용보험적용여부 : umytInsrApptnYn */
		    idtlAccdtInsurApptnYn.setValue(false);        	/**  column 산재보험적용여부 : idtlAccdtInsurApptnYn */
				                        
		    hlthInsrMnthRuntnAmnt.clear();            		/**  column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
		    natPennStdIncmMnthAmnt.clear();           		/**  column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
		    umytInsrPayMnthAmnt.clear();            		/**  column 고용보수월액 : umytInsrPayMnthAmnt */
//		    idtlAccdtPayMnthAmnt.clear();              		/**  column 산재보수월액 : idtlAccdtPayMnthAmnt */
		      
		    currDeptAppmtDt.setValue("");           		/**  column 현_부서발령일자 : currDeptAppmtDt */
		    yoobhMnthDay.setValue("");               		/**  column 생년월일 : yoobhMnthDay */
		    natnNm.setValue("");                     		/**  column 국가코드 : natnCd */
				                        
		    logSvcStdDt.setValue("");                		/**  column 근속기준일자 : logSvcStdDt */
		    logSvcExtpyApptnYn.setValue(false) ;    		/**  column 근속수당적용여부 : logSvcExtpyApptnYn */
				                        
		    husPhnNum.setValue("");                			/**  column 집전화번호 : husPhnNum */
		    cellPhneNum.setValue("");                    	/**  column 핸드폰번호 : cellPhneNum */
		    emailAddr.setValue("");                    		/**  column 이메일주소 : emailAddr */
		    husRoadNmZpcd.setValue("");               		/**  column 집도로명우편번호 : husRoadNmZpcd */
		    husRoadNmFndtnAddr.setValue("");                /**  column 집도로명기본주소 : husRoadNmFndtnAddr */
//		    husRoadNmDtlPatrAddr.setValue("");          	/**  column 집도로명상세주소 : husRoadNmDtlPatrAddr */
		  	mnthPayDlywagSum.clear();                 		/**  column 월급여일당금액 :  */
			addIncmTxApptnRtoCd.setValue(new BaseModel()); 	/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
			addIncmTxApptnYr.setValue(new BaseModel());  	/** set 추가소득세적용년 : addIncmTxApptnYrMnth */
			addIncmTxApptnMnth.setValue(new BaseModel());  	/** set 추가소득세적용월 : addIncmTxApptnYrMnth */ 
		 	addIncmTxApptnYn.setValue("");   				/** set 추가소득세적용여부 : addIncmTxApptnYn */
		 	befIncmTxApptnRtoCd.setValue("");              	/** set  이전 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
		    befIncmTxApptnYr.setValue("");  				/** set 이전 추가소득세적용년 : befIncmTxApptnYrMnth */
		    befIncmTxApptnMnth.setValue("");  				/** set 이전 추가소득세적용월 : befIncmTxApptnYrMnth */ 
		    befIncmTxApptnYn.setValue("");   				/** set 이전 추가소득세적용여부 : befIncmTxApptnYn */
		    addIncmTxApptnCnt.clear();   					/** set   추가소득세적용개수 : addIncmTxApptnCnt */

		}
		
		// 그리드 초기화
		private void resetGridPanel() {
			
			psnl0100GridPanel.getMsfGrid().clearData();			//대상자정보
			payr0500GridPanel.getMsfGrid().clearData();			//기본정보 
			payr0530GridPanel.getMsfGrid().clearData();			//가족사항및학비보조 
			payr0520GridPanel.getMsfGrid().clearData();			//수당-공제 
			payr0520DducGridPanel.getMsfGrid().clearData(); 	//걔별공제 
			psnl0130GridPanel.getMsfGrid().clearData(); 		//지급계좌정보 
			payr0220GridPanel.getMsfGrid().clearData();			//채권압류
			remt3500GridPanel.getMsfGrid().clearData();			//TODO  퇴직정산 완료시 추가 할것.  
			psnl0123GridPanel.getMsfGrid().clearData();			//휴직처리 
			payr0540GridPanel.getMsfGrid().clearData();			//예외처리-건강보험...
			
		}
		
		
	   
	 
	   
	   private void reloadPayr0530(){
	       
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	           return;
	       }
		   IColumnFilter filters = null;
		   payr0530GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   payr0530GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   payr0530GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   payr0530GridPanel.reload();
	   }
	   //수당  
	   private void reloadPayr0520(){
		   
		  /* B0080010	B008	0010	본봉			B	Y
		   B0080020	B008	0020	수당			C	Y
		   B0080030	B008	0030	공제			D	N
		   B0080040	B008	0040	세금			T	N */
		   
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   payr0520GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   payr0520GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   payr0520GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		  // payr0520GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", "B0080020", SimpleColumnFilter.OPERATOR_EQUALS); 
		   payr0520GridPanel.getTableDef().addColumnFilter("pymtDducItemBgnnDt", MSFSharedUtils.getSelectedComboValue(srhPayrYr01,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
		   payr0520GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", "B0080010,B0080020", SimpleColumnFilter.OPERATOR_EQUALS);  
 		   
			
		   payr0520GridPanel.reload();  
		   boolPymtDduc = true;
	   }
		//공제 
	   private void reloadPayr0200(){
	        
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   payr0520DducGridPanel.getTableDef().setTableColumnFilters(filters);
			
		   payr0520DducGridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   payr0520DducGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		  // payr0520DducGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", "B0080030", SimpleColumnFilter.OPERATOR_EQUALS); 
		   payr0520DducGridPanel.getTableDef().addColumnFilter("pymtDducItemBgnnDt", MSFSharedUtils.getSelectedComboValue(srhPayrYr02,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
		   payr0520DducGridPanel.getTableDef().addColumnFilter("pymtDducDivCd", "B0080030,B0080040", SimpleColumnFilter.OPERATOR_EQUALS);  
		   payr0520DducGridPanel.reload();
		   
		   boolPymtDduc = true;
	   }
		
		//지급계좌 누른경우에 데이터를 리로딩한다.
	   private void reloadPsnl0130(){
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   psnl0130GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   psnl0130GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   psnl0130GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   psnl0130GridPanel.reload();
	   }
		//채권압류 누른경우에 데이터를 리로딩한다.
	   private void reloadPayr0220(){
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   payr0220GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   payr0220GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   payr0220GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   payr0220GridPanel.reload();
	   }
	   
		//채권압류 누른경우에 데이터를 리로딩한다.
	   private void reloadRemt3500(){
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   remt3500GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   remt3500GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   remt3500GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   remt3500GridPanel.reload();
	   }
	   
	   
	   
		
		//휴 직 누른경우에 데이터를 리로딩한다.
	   private void reloadPsnl0123(){
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   psnl0123GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   psnl0123GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   psnl0123GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   psnl0123GridPanel.reload();
	   }
	
		//예외 누른경우에 데이터를 리로딩한다.
	   private void reloadPayr0540(){
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
               return;
           }
		   IColumnFilter filters = null;
		   payr0540GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   payr0540GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   payr0540GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   payr0540GridPanel.reload();
	   }
		
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 
	
	   public void setPPRecord(BaseModel ppRecord) {
	       this.ppRecord = ppRecord;
	   }
	   
	   

	   private Payr4100 getThis(){
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
       
     //부서 
//       private void fnPopupCommP140(String deptCd) {
//           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//           //검색.처리하면됨.
//           
//           MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//           
//           final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//          
//           popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//               public void handleEvent(BaseEvent be) {
//                   BaseModel mapModel = (BaseModel)be.getSource();
//                   if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                        
//                       srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                       srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                       srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                       srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                       srhDeptCd.fireEvent(Events.Add);
//                   }  
//                        
//               }
//           });
//       }  
		   
	  /**
	   * 추가소득세적용비율 ReadOnly 
	   * @param chkbool
	   */
	  private void fnAddIncmTxApptnReadOnly(boolean chkbool) { 
		 // addIncmTxApptnRtoCd.setReadOnly(chkbool);
		  addIncmTxApptnYr.setReadOnly(chkbool);
		  addIncmTxApptnMnth.setReadOnly(chkbool);
	  }
	  
	  private void payrP410004AddIncmTxApptn() { 
		      PayrP410004 payrP410004Form = new PayrP410004(ActionDatabase.CUSTOM, getThis());   
		    
		      //추가소득세율관리
			  MSFFormWindows msFwPayr410004 = new MSFFormWindows("추가소득세율관리",payrP410004Form,"닫기","1010px", "650px",true);
			  msFwPayr410004.show();
			  payrP410004Form.setMSFFormWindows(msFwPayr410004);
		     // payrP410004Form.bind(ppRecord);   
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
