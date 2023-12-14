package com.app.exterms.retirement.client.form;

import java.util.ArrayList;
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
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.retirement.client.dto.Remt3000DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.Remt3200DTO;
import com.app.exterms.retirement.client.form.def.Remt3000Def;
import com.app.exterms.retirement.client.form.def.Remt3100Def;
import com.app.exterms.retirement.client.form.def.Remt3200Def;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.client.service.Remt0200Service;
import com.app.exterms.retirement.client.service.Remt0200ServiceAsync;
import com.app.exterms.retirement.client.utils.RemtUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFCheckBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
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
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Remt0200  extends MSFPanel { 

	private RemtConstants lblRemtConst = RemtConstants.INSTANCE; 
	   
	private VerticalPanel vp;
	private FormPanel plFrmRemt0200;
	private String txtForm = "";
	private XTemplate detailTp;
	   
	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	 
	  
	private TabPanel tabPanel;

	private LayoutContainer layoutContainer_13;
	private TabItem tbtmNewTabitem_1;

	private LayoutContainer layoutContainer_157;
	private LayoutContainer lcTabFormLayer;
	private LayoutContainer lcTabFormLayer_1;
	  
	// 퇴직정산 대상자정보
	private Remt3000Def remt3000Def = new Remt3000Def("REMT0200"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remt3000DefGridPanel;
	  
	   
//	  private Remt3100Def remt3100Def  = new Remt3100Def("REMT0200");   //그리드 테이블 컬럼 define  
//	      // private MSFCustomForm msfCustomForm; 
//	  private MSFGridPanel remt3100DefGridPanel;
      
	//납부명세 
	private Remt3100Def remtSubtn3100Def  = new Remt3100Def("REMTPYMTSUBTN0200");   //그리드 테이블 컬럼 define  
    // private MSFCustomForm msfCustomForm; 
    private MSFGridPanel remtSubtn3100GridPanel;
      
      
	//퇴직연금
	private Remt3200Def remt3200Def  = new Remt3200Def("REMT0200");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
	private MSFGridPanel remt3200DefGridPanel;

      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;     	//과세이연관련
	private ActionDatabase actionDDlneDatabase; //마감
     
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
	private ButtonBar topRemt0200Bar;
    private Button btnRemt0200Init;
    private Button btnRemt0200Save;
    private Button btnRemt0200Calc;
    private Button btnRemt0200Del;
    private Button btnRemt0200Sreach;
    private Button btnRemt0200Print;
    private Button btnRemt0200Excel;
    
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	*/
	/** column  년도 : year */
	private ComboBox<BaseModel> srhClutYr;					// 정산년
	private ComboBox<BaseModel> srhClutMnth;				// 정산월
	private ComboBox<BaseModel> srhCalcSevePayPsnDivCd; 	// 정산구분
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	private TextField<String> srhHanNm;        	 			// 성명
    private TextField<String> srhResnRegnNum;   			// 주민번호 
    private HiddenField<String> srhSystemkey;   			// 시스템키
    private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
    private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드  
    private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
    private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드	 
    private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종  
    private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
    private ComboBox<BaseModel> srhBusinCd;   			 	// 사업
    
	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;
     
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 입력 변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	private MSFDateField ddlneDt;   /** column 마감일자 : ddlneDt */
	
	// ------ HiddenField 시작 ------
	private HiddenField<String>  dpobCd;   		/** column 사업장코드 : dpobCd */
	private HiddenField<String>  deptCd;   		/** column 부서코드 : deptCd */
	private HiddenField<String>  systemkey;		/** column SYSTEMKEY : systemkey */
    private HiddenField<String>  clutYrMnth;   	/** column 정산년월 : clutYrMnth */
    private HiddenField<String>  calcSevePsnBlggYrMnth;	/** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
    private HiddenField<String>  frgnrDivCd;  	/** column 외국인구분코드 : frgnrDivCd */
    private HiddenField<Boolean> ridnSeptYn;	/** column 거주구분여부 : ridnSeptYn */
    private HiddenField<String>  ridnCd;   		/** column 거주지국코드 : ridnCd */
    private HiddenField<String>  ridnNm;   		/** column 거주지국명 : ridnNm */
    // ------ HiddenField 종료 ------
    
    
	// ------ 기본정보 시작 ------
	private MSFComboBox<BaseModel> calcSevePsnBlggYr;	/** column 퇴직정산귀속년 : calcSevePsnBlggYr */
	private MSFComboBox<BaseModel> calcSevePsnBlggMnth;	/** column 퇴직정산귀속월 : calcSevePsnBlggMnth */
	private MSFComboBox<BaseModel> calcSevePayPsnDivCd; /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	private MSFTextField hanNm;   				/** column 한글성명 : hanNm */
	private MSFTextField resnRegnNum;   		/** column 주민등록번호 : resnRegnNum */
    private MSFTextField emymtDivNm;   			/** column 고용구분 : emymtDivNm */
    private MSFTextField deptNm;   				/** column 부서 : deptNm */
    private MSFTextField typOccuNm;   			/** column 직종 : typOccuNm */
    private MSFDateField blggYrBgnnDt;			/** column 귀속년도시작일자 : blggYrBgnnDt */
    private MSFDateField blggYrEndDt;  	 		/** column 귀속년도종료일자 : blggYrEndDt */
	private MSFDateField reipDt;   				/** column 영수일자 : reipDt */
	// ------ 기본정보 종료 ------
	
	// ------ 소득명세 시작 ------
	//-- 중간
	private TextFieldWithButton<String> ctrPaeWorkNm;	/** column 중_근무처명 : ctrPaeWorkNm */
	private MSFTextField ctrBusoprRgstnNum;   			/** column 중_사업자등록번호 : ctrBusoprRgstnNum */
	private MSFTextField ctrRetryReasNm;				/** column 중간퇴직사유 : ctrRetryReasNm */
	private MSFTextField ctrRkfcdDt;   					/** column 중_기산일자 : ctrRkfcdDt */
	private MSFTextField ctrIcncDt;						/** column 중_입사일자 : ctrIcncDt */
	
	private MSFTextField ctrRsgtnDt;   					/** column 중_퇴사일자 : ctrRsgtnDt */
	private MSFTextField ctrPymtDt;   					/** column 중_지급일자 : ctrPymtDt */
	private MSFNumberField ctrLogSvcMnthIcm;   			/** column 중_근속월수 : ctrLogSvcMnthIcm */
	private MSFNumberField ctrEepnMnth12Bfr;   			/** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
	private MSFNumberField ctrEepnMnth13Aft;   			/** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
	private MSFNumberField ctrAddMnth12Bfr;   			/** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
	private MSFNumberField ctrAddMnth13Aft;   			/** column 중_가산월수_2013이후 : ctrAddMnth13Aft */

	private MSFNumberField ctrTxtnTgtRetryPayQnty;		/** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
	private MSFNumberField ctrFreeDtyRetryPayQnty;		/** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
	
	//-- 최종
	private TextFieldWithButton<String> endPaeWorkNm;   /** column 종_근무처명 : endPaeWorkNm */
	private MSFTextField endBusoprRgstnNum;   			/** column 종_사업자등록번호 : endBusoprRgstnNum */
	private MSFComboBox<BaseModel> retryReasCd;   		/** column 퇴직사유코드 : retryReasCd */
	private MSFTextField endRkfcdDt;   					/** column 종_기산일자 : endRkfcdDt */
	private MSFTextField endViewIcncDt;					/** column 종_입사일자 : endIcncDt */
	private MSFTextField endRsgtnDt;   					/** column 종_퇴사일자 : endRsgtnDt */
	private MSFTextField endPymtDt;						/** column 종_지급일자 : endPymtDt */
	private MSFNumberField endLogSvcMnthIcm;   			/** column 종_근속월수 : endLogSvcMnthIcm */
	
	
	private MSFNumberField endEepnMnth12Bfr;   			/** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
	private MSFNumberField endEepnMnth13Aft;   			/** column 종_제외월수_2013이후 : endEepnMnth13Aft */
	   
	private MSFNumberField ctrAddMnthIcm;				/** column 중_가산월수 : ctrAddMnthIcm */
	private MSFNumberField endAddMnth12Bfr;   			/** column 종_가산월수_2012이전 : endAddMnth12Bfr */
	private MSFNumberField endAddMnth13Aft;   			/** column 종_가산월수_2013이후 : endAddMnth13Aft */
	   
	private MSFNumberField endTxtnTgtRetryPayQnty;   	/** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
	private MSFNumberField endFreeDtyRetryPayQnty;   	/** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
	
    //-- 정산
	private TextField<String> tmepTxtFld_2_4;
	private TextField<String> tmepTxtFld_3_4;
	private TextField<String> tmepTxtFld_4_4;
	private TextField<String> tmepTxtFld_5_4;
	private MSFNumberField tempNumFld_6_4;
	private MSFNumberField tempNumFld_7_4_1;
	private MSFNumberField tempNumFld_7_4_2;
	private MSFNumberField tempNumFld_8_4_1;
	private MSFNumberField tempNumFld_8_4_2;
	
    private MSFNumberField clutTxtnTgtRetryPayQnty;   	/** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
	private MSFNumberField clutFreeDtyRetryPayQnty;   	/** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
	// ------ 소득명세 종료 ------  
	
	
	private MSFDateField fixPayJnDt;   					/** column 확정급여형가입일자 : fixPayJnDt */
    private MSFNumberField sevePay20111231Sum;			/** column 퇴직금_20111231금액 : sevePay20111231Sum */
    private MSFCheckBox aimenrEcteYn;   				/** column 소득자임원여부 : aimenrEcteYn */
    private MSFNumberField talRegrstTgtTxAmnt;			/** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
    private MSFNumberField talRetryPayQnty;   			/** column 이연세액_퇴직급여액 : talRetryPayQnty */
    private MSFNumberField talRetryIncmTxAmnt;			/** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
    
    
    
    // ------ 세액계산 시작 ------   
    //-- 근속연수
	private MSFTextField ctrViewIcncDt;   			/** column 중_입사일자 : ctrIcncDt */
	private MSFTextField ctrViewRkfcdDt;   			/** column 중_기산일자 : ctrRkfcdDt */
	private MSFTextField  ctrViewRsgtnDt;   		/** column 중_퇴사일자 : ctrRsgtnDt */
	private MSFTextField  ctrViewPymtDt;   			/** column 중_지급일자 : ctrPymtDt */
	private MSFNumberField ctrViewLogSvcMnthIcm;	/** column 중_근속월수 : ctrLogSvcMnthIcm */
	private MSFNumberField ctrEepnMnthIcm;			/** column 중_제외월수 : ctrEepnMnthIcm */
	private MSFNumberField ctrDupMnthIcm;   		/** column 중_중복월수 : ctrDupMnthIcm */
	private MSFNumberField ctrLogSvc;   			/** column 중_근속연수 : ctrLogSvc */
	   
	private MSFTextField  endIcncDt;   				/** column 종_입사일자 : endIcncDt */
	private MSFTextField  endViewRkfcdDt;   		/** column 종_기산일자 : endRkfcdDt */
	private MSFTextField  endViewRsgtnDt;   		/** column 종_퇴사일자 : endRsgtnDt */
	private MSFTextField  endViewPymtDt;   			/** column 종_지급일자 : endPymtDt */
	private MSFNumberField endViewLogSvcMnthIcm;	/** column 종_근속월수 : endLogSvcMnthIcm */
	private MSFNumberField endEepnMnthIcm;   		/** column 종_제외월수 : endEepnMnthIcm */
	private MSFNumberField endAddMnthIcm;   		/** column 종_가산월수 : endAddMnthIcm */
	private MSFNumberField endDupMnthIcm;   		/** column 종_중복월수 : endDupMnthIcm */
	private MSFNumberField endLogSvcYrNum;   		/** column 종_근속연수 : endLogSvcYrNum */
	
	private MSFTextField  clutIcncDt;   			/** column 정산_입사일자 : clutIcncDt */
	private MSFTextField  clutRkfcdDt;   			/** column 정산-기산일자 : clutRkfcdDt */
	private MSFTextField  clutRsgtnDt;   			/** column 정산_퇴사일자 : clutRsgtnDt */
	private MSFTextField  clutPymtDt;   			/** column 정산_지급일자 : clutPymtDt */
	private MSFNumberField clutLogSvcMnthIcm;   	/** column 정산_근속월수 : clutLogSvcMnthIcm */
	private MSFNumberField clutEepnMnthIcm;   		/** column 정산_제외월수 : clutEepnMnthIcm */
	private MSFNumberField clutAddMnthIcm;   		/** column 정산_가산월수 : clutAddMnthIcm */
	private MSFNumberField clutDupMnthIcm;   		/** column 정산_중복월수 : clutDupMnthIcm */
	private MSFNumberField clutLogSvcYrNum;   		/** column 정산_근속연수 : clutLogSvcYrNum */
	
	private MSFTextField  logPpnl12befIcncDt;   	/** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
	private MSFTextField  logPpnl12befRkfcdDt;   	/** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
	private MSFTextField  logPpnl12befRsgtnDt;   	/** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
	private MSFTextField  logPpnl12befPymtDt;   	/** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
	private MSFNumberField logPpnl12befLogMnthIcm;	/** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
	private MSFNumberField logPpnl12befEepnMnthIcm;	/** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
	private MSFNumberField logPpnl12befAddMnthIcm;	/** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
	private MSFNumberField logPpnl12befDupMnthIcm;	/** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
	private MSFNumberField logPpnl12befLogYrNum;   	/** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
	   
	private MSFTextField  logPpnl13afrIcncDt;   	/** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
	private MSFTextField  logPpnl13afrRkfcdDt;   	/** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
	private MSFTextField  logPpnl13afrRsgtnDt;   	/** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
	private MSFTextField  logPpnl13afrPymtDt;   	/** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
	private MSFNumberField logPpnl13afrLogMnthIcm;	/** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
	private MSFNumberField logPpnl13afrEepnMnthIcm;	/** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
	private MSFNumberField logPpnl13afrAddMnthIcm;	/** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
	private MSFNumberField logPpnl13afrDupMnthIcm;	/** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
	private MSFNumberField logPpnl13afrLogSvc;   	/** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
	
	//-- 퇴직소득과새표준계산
	private MSFNumberField retryIncmCtrPymtSum;   	/** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
	private MSFNumberField retryIncmEndPymtSum;   	/** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
	private MSFNumberField retryIncmClutSum;   		/** column 퇴직소득_정산금액 : retryIncmClutSum */
	   
	private MSFNumberField tempNumFld_02_2_2_2;
	private MSFNumberField tempNumFld_02_2_2_3;
	private MSFNumberField retryFxrtDducClutSum;   	/** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
	
	private MSFNumberField tempNumFld_02_2_3_2;
	private MSFNumberField tempNumFld_02_2_3_3;   
	private MSFNumberField logYrDducSum;   			/** column 근속년수공제_정산금액 : logYrDducSum */
	
	private MSFNumberField tempNumFld_02_2_4_2;
	private MSFNumberField tempNumFld_02_2_4_3;    
	private MSFNumberField retryTxtnStdClutSum;   	/** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
	
	
	
	//-- 퇴직소득세액계산
	private MSFNumberField tat12befTxtnStdPpnlSum;	/** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
	private MSFNumberField tat12befYravgTxstdSum;	/** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
	private MSFNumberField tat12befCvsnTxtnStdSum;	/** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
	private MSFNumberField tat12befCvsnCalcAmnt;   	/** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
	private MSFNumberField tat12befYrAvgCalcAmnt;   /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
	private MSFNumberField tat12befCalcTxAmnt;   	/** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
	private MSFNumberField tat12befAlpayTxAmnt;   	/** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
	private MSFNumberField tat12befRegTgtTxAmnt;   	/** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
	   
	private MSFNumberField tat13afrTxstdPpnlSum;   	/** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
	private MSFNumberField tat13afrYrAvgStdSum;   	/** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
	private MSFNumberField tat13afrCvsnTxtnStdSum;	/** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
	private MSFNumberField tat13afrCvsnCalcTxAmnt;	/** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
	private MSFNumberField tat13afrYrAvgCalcAmnt;	/** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
	private MSFNumberField tat13afrCalcTxAmnt;   	/** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
	private MSFNumberField tat13afrAlpayTxAmnt;   	/** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
	private MSFNumberField tat13afrRegrstTgtSum;   	/** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
	   
	private MSFNumberField tatAggrTxtnStdPpnlSum;   /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
	private MSFNumberField tatAggrYrAvgTxtnStdSum;	/** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
	private MSFNumberField tatAggrCvsnTxtnStdSum;   /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
	private MSFNumberField tatAggrCvsnCalcTxAmnt;   /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
	private MSFNumberField tatAggrYrAvgCalcTxAmnt;	/** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
	private MSFNumberField tatAggrCalcTxAmnt;   	/** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
	private MSFNumberField tatAggrAlpayTxAmnt;   	/** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
	private MSFNumberField tatAggrRegrstTgtTxAmnt;	/** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
	// ------ 세액계산 종료 ------    
	   
	private boolean statCheck = false; 
	
    
//   private TextField<String> ddlneYn;   /** column 마감여부 : ddlneYn */
//   private TextField<String> calcSevePayPsnSumtDt;   /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
//   private TextField<String> degtrNm;   /** column 대표자성명 : degtrNm */
//   private TextField<String> corpNmFmnm;   /** column 법인명_상호 : corpNmFmnm */
//   private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
//   private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//   private TextField<String> corpNum;   /** column 법인번호 : corpNum */
//   private TextField<String> incmRegrstDebrZpcd;   /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
//   private TextField<String> incmRegrstDebrFndtnAddr;   /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
//   private TextField<String> incmRegrstDebrDtlPatrAddr;   /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
//   private TextField<String> juriTxOffcCd;   /** column 관할세무서코드 : juriTxOffcCd */
//   private TextField<String> pentrCd;   /** column 제출자구분코드 : pentrCd */
//   private TextField<String> txDeptyNum;   /** column 세무대리인번호 : txDeptyNum */
//   private TextField<String> hmtxId;   /** column 홈텍스ID : hmtxId */
//   private TextField<String> txPgmCd;   /** column 세무프로그램코드 : txPgmCd */
//   private TextField<String> pernChrgDeptNm;   /** column 담당자부서명 : pernChrgDeptNm */
//   private TextField<String> pernChrgNm;   /** column 담당자성명 : pernChrgNm */
//   private TextField<String> pernChrgPhnNum;   /** column 담당자전화번호 : pernChrgPhnNum */
//   private TextField<String> cllnDebrDivCd;   /** column 징수의무자구분코드 : cllnDebrDivCd */
// 	 private MSFNumberField ctrRetryPayQnty;   /** column 중_퇴직급여액 : ctrRetryPayQnty */
//   private MSFNumberField talAccuDepitAggrSum;   /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//   private TextField<String> pymtRegTgtIncmTxQnty;   /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//   private TextField<String> pymtRegTgtRgonIncmQnty;   /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//   private TextField<String> pymtRegTgtFarvilSpclQnty;   /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//   private TextField<String> pymtRegrstTgtAggrSum;   /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//   private TextField<String> pymtTalcIncmTxQnty;   /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//   private TextField<String> pymtTalcRgonIncmTxQnty;   /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//   private TextField<String> pymtTalcFarvilSpclQnty;   /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//   private TextField<String> pymtTxAllcAggrSum;   /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//   private TextField<String> pymtSubtnIncmTxQnty;   /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//   private TextField<String> pymtSubtnRgonIncmTxQnty;   /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//   private TextField<String> pymtSubtnFarvilSpclQnty;   /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//   private TextField<String> pymtSubtnAggrSum;   /** column 납부차감_합계금액 : pymtSubtnAggrSum */
   
   
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
	private void setRemt0200FormBinding() {
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	}        
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/		
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
		/**
		 * 권한설정 처리 체크 
		 * AuthAction 
		 */
		private void checkPayr3100Auth( String authAction, ListStore<BaseModel> bm) {   
			//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
	 			 
			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
				if (!maskTracker) { unmask(); }  
				authExecEnabled() ;
				//MSFMainApp.unmaskMainPage();
				}
			}
		private void authExecEnabled() { 
			//- ---------------------------------------------
			Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
	               
			gwtAuthorization.formAuthFieldConfig(fldArrField);
			gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
	               
			srhClutYr.setValue(lsClutYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
			srhClutMnth.setValue(lsClutMnth.findModel("month", DateTimeFormat.getFormat("MM").format(new Date())));
			srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(2));
			
			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	              // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
	              // GWTAuthorization.formAuthPopConfig(plFrmPayr4220, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	              // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			  	//gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * 권한설정을 위한 콤보처리를 위한 메서드 종료
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	             //  srhDeptCd.fireEvent(Events.Add); 
				srhDeptCd.getListView().fireEvent(Events.CheckChanged);         
		}

		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) { 
				if (lsEmymtDivCd.getCount() > 0 ) {
					cancel();
					unmask();
					authExecEnabled();
					maskTracker = true;

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
	
			authMapDef.put("srhClutYr", Boolean.FALSE);
			authMapDef.put("srhClutMnth", Boolean.FALSE);
			authMapDef.put("srhCalcSevePayPsnDivCd", Boolean.FALSE);
	
			authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
			authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
			authMapDef.put("srhDeptCd", Boolean.FALSE);
			// authMapDef.put("srhTypOccuCd",Boolean.FALSE);
	
			gwtExtAuth.setCheckMapDef(authMapDef);
	
			if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
				// 권한 검색조건처리를 위해 추가된 부분
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
	 * 	Rpc Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	//입력수정삭제처리 rpc 처리부     
	private Remt0200ServiceAsync remt0200Service = Remt0200Service.Util.getInstance();
	    
	private ListStore<BaseModel> lsClutYrStore 				= new ListStore<BaseModel>();  	//년도 
	private ListStore<BaseModel> lsClutMnth 				= new ListStore<BaseModel>();  	//급여월   
	private ListStore<BaseModel> lsEmymtDivCd				= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lsRepbtyBusinDivCd			= new ListStore<BaseModel>();	//호봉제구분코드 
	    
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  					= new ListStore<BaseModel>();	// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	         
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  				= new ListStore<BaseModel>();	// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	
	private ListStore<BaseModel> lsPayrMangDeptCd 			= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lsDeptGpCd 				= new ListStore<BaseModel>();	//부서직종그룹코드 
	private ListStore<BaseModel> lsTypOccuCd 				= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lsCalcSevePayPsnDivCd 		= new ListStore<BaseModel>();	//정산구분
	    
	private ListStore<BaseModel> lsPymtDducDivCd 			= new ListStore<BaseModel>(); 	//지급공제구분코드 
	private ListStore<BaseModel> lsDtilOccuInttnCd 			= new ListStore<BaseModel>();	//직종세
	
	private ListStore<BaseModel> lsCalcSevePsnBlggYr 		= new ListStore<BaseModel>();	/** column 퇴직정산귀속년 : calcSevePsnBlggYr */
	private ListStore<BaseModel> lsCalcSevePsnBlggMnth 		= new ListStore<BaseModel>();	/** column 퇴직정산귀속월 : calcSevePsnBlggMnth */
	private ListStore<BaseModel> lsCrCalcSevePayPsnDivCd 	= new ListStore<BaseModel>();	/** column 퇴직정산구분코 : CalcSevePayPsnDivCd */
	private ListStore<BaseModel> lsRetryReasCd 				= new ListStore<BaseModel>();	/** column 퇴직사유코드 : retryReasCd */
	private ListStore<BaseModel> lsPrntCalc 				= new ListStore<BaseModel>();	/** column 출력구분 */
	    
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
	    
	private BaseModel record;

	private Iterator<Record> records;
  
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
	//이연게좌
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			saveRemt0200ToRemt3200();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			saveRemt0200ToRemt3200();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			saveRemt0200ToRemt3200();
			break;
		}
	}
	     

	private void saveRemt0200ToRemt3200() { 
        
		if (MSFSharedUtils.paramNotNull(records)) {
        	
			statCheck = false;
            List<Remt3200DTO> listRemt3200dto = new ArrayList<Remt3200DTO>();  
             
            while (records.hasNext()) {
           
            	Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				Remt3200DTO remt3200Dto = new Remt3200DTO();
                 

				remt3200Dto.setAntyAccuSeilNum((Long)bmMapModel.get("antyAccuSeilNum") );    /** column 연금계좌일련번호 : antyAccuSeilNum */
				remt3200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				remt3200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 퇴직정산정산년월 : clutYrMnth */
                 
                // remt3200Dto.setCalcSevePsnBlggYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePsnBlggYrMnth")));    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
                 remt3200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
                 remt3200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                 remt3200Dto.setAntyAccuBusoprNum(MSFSharedUtils.allowNulls(bmMapModel.get("antyAccuBusoprNum")));    /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
                 remt3200Dto.setAntyAccuBusoprNm(MSFSharedUtils.allowNulls(bmMapModel.get("antyAccuBusoprNm")));    /** column 연금계좌_사업자명 : antyAccuBusoprNm */
                 remt3200Dto.setAntyAccuAccuNum(MSFSharedUtils.allowNulls(bmMapModel.get("antyAccuAccuNum")));    /** column 연금계좌_계좌번호 : antyAccuAccuNum */
                 remt3200Dto.setAntyAccuDepitSum((Long)bmMapModel.get("antyAccuDepitSum"));    /** column 연금계좌_입금금액 : antyAccuDepitSum */
                 remt3200Dto.setAntyAccuDepitDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("antyAccuDepitDt"),"yyyyMMdd"));    /** column 연금계좌_입금일자 : antyAccuDepitDt */
//				remt3200Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//				remt3200Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//				remt3200Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//				remt3200Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//				remt3200Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//				remt3200Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
				
 
//                if ("C9080100".equals(remt3200Dto.getPayItemCd())) {
//                	 MessageBox.confirm("정액급식비", "정액급식비 조정시 비과세금액도 조정이 필요한지 확인하십시요. 계속진행하시겠습니까?",new Listener<MessageBoxEvent>(){
//          	              @Override
//          	               public void handleEvent(MessageBoxEvent be) {
//          	                  if("No".equals(be.getButtonClicked().getText())){ 
//          	                      return ;
//          	                 }
//          	            }
//          	              
//          	          });
//                } 
                
                if (actionDatabase.equals(ActionDatabase.INSERT)) { 
                	 
                		if (MSFSharedUtils.isNullAsString(remt3200Dto.getSystemkey())) {
                			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
       	                             "[과세이연계좌] 등록할 대상자를 선택하십시요.", null);
                			statCheck = true;
                			break;
                		} else if (MSFSharedUtils.paramNotNull(remt3200Dto.getAntyAccuDepitSum())) {
                   			if (remt3200Dto.getAntyAccuDepitSum().compareTo(0L) <= 0) {
	                			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	         	                        "[과세이연계좌] 등록할 입금액은 0 이상이어야합니다. 입력하십시요.", null);
	                  			 statCheck = true;
	                  			 break;
                   			}
                  		}  else if (MSFSharedUtils.paramNull(remt3200Dto.getAntyAccuDepitSum())) {
                   			 
	                			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	         	                         "[과세이연계좌] 등록할 입금액은 0 이상이어야합니다. 입력하십시요.", null);
	                  			statCheck = true;
	                  			break;
                   			 
                  		}  else if (MSFSharedUtils.paramNull(remt3200Dto.getAntyAccuBusoprNum())) {
                  			 
	                			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	         	                         "[과세이연계좌] 사업자등록번호를 입력하십시요.", null);
	                  			statCheck = true;
	                  			break;
                  			 
                 		}  else if (MSFSharedUtils.paramNull(remt3200Dto.getAntyAccuBusoprNm())) {
                 			 
	                			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	         	                         "[과세이연계좌] 사업자명을 입력하십시요.", null);
	                  			statCheck = true;
	                  			break;
                 			 
                		}    
                		 
                	
                } 
                
                if (MSFSharedUtils.paramNull(remt3200Dto.getAntyAccuDepitDt())) {
        			 
        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
 	                         "[과세이연계좌] 입금일자를 입력하십시요.", null);
          			statCheck = true;
          			break;
          			
     			 
    		     }    
                
                listRemt3200dto.add(remt3200Dto);
               
             }   
             
             if (!statCheck) {    
		            remt0200Service.saveRemt0200ToRemt3200(listRemt3200dto, 
		                    actionDatabase,
		                    new AsyncCallback<Long>() { 
		                public void onFailure(Throwable caught) {
		                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveRemt0200ToRemt3200(" + actionDatabase.name() + ") : " + caught), null);
		                }
		                public void onSuccess(Long result) { 
		                   if (result == 0) {
		                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
		                               actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
		                      // actionDatabase = ActionDatabase.INSERT;
		                   } else {
		                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		                               actionDatabase + "처리가 완료되었습니다.", null);
		                       //reload();
		                       actionDatabase = ActionDatabase.UPDATE;
		                   } 
		                } 
		                 
		            }); 
             }
        } else {
            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
            return;
        }

}     
	    
     //마감
	    private void doDDlneAction(ActionDatabase actionDDlneDatabase) {
	        switch (actionDDlneDatabase) {
	        case INSERT: 
	            //마감하기로직 
	            this.actionDDlneDatabase = ActionDatabase.INSERT;
	            saveRemt0200ToDDlne();
	            break;
	        case UPDATE:
	           // actionDatabase = ActionDatabase.UPDATE; 
	           // saveRemt0200ToDDlne();
	            break;
	        case DELETE:
	            //마감풀기로직
	            this.actionDDlneDatabase = ActionDatabase.DELETE;
	            saveRemt0200ToDDlne();             
	            break;
	        }
	    } 
	   
	    private void saveRemt0200ToDDlne() { 
	        
	      if (MSFSharedUtils.paramNotNull(records)) {
	            
	          
	          MessageBox.confirm("마감", "선택하신 테이타를 마감(마감풀기)하시겠습니까?",new Listener<MessageBoxEvent>(){
	              @Override
	              public void handleEvent(MessageBoxEvent be) {
	                //  if("Yes".equals(be.getButtonClicked().getText())){
	            	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                      
	                      List<Remt3000DTO> listRemt3000dto = new ArrayList<Remt3000DTO>();  
	                      
	                      if (MSFSharedUtils.paramNull(GWTUtils.getStringFromDate(ddlneDt.getValue(),"yyyyMMdd"))) {
	                          MessageBox.alert( "일자오류 ", "마감일자를 입력해 주십시요.", null);
	                          return ;
	                      } 
	                      while (records.hasNext()) {
	                    
	                          Record record = (Record) records.next(); 
	                         // BaseModel bmMapModel = (BaseModel)record.getModel();
	                            
	                          Remt3000DTO remt3000Dto = new Remt3000DTO();   
	                          

							remt3000Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							remt3000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(record.get("clutYrMnth"))); /** column 퇴직정산정산년월 : clutYrMnth */ 
							//remt3000Dto.setCalcSevePsnBlggYrMnth(MSFSharedUtils.allowNulls(record.get("calcSevePsnBlggYrMnth")));    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
							remt3000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(record.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							remt3000Dto.setSystemkey(MSFSharedUtils.allowNulls(record.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						//	remt3000Dto.setSevePayClutMangeNum(record.get("sevePayClutMangeNum"));    /** column 퇴직정산관리번호 : sevePayClutMangeNum */
						//	remt3000Dto.setReipDt(record.get("reipDt"));    /** column 영수일자 : reipDt */
						//	remt3000Dto.setDdlneYn(true);    /** column 마감여부 : ddlneYn */
							remt3000Dto.setDdlneDt(GWTUtils.getStringFromDate((Date)record.get("ddlneDt"),"yyyyMMdd") );    /** column 마감일자 : ddlneDt */
//							remt3000Dto.setCalcSevePayPsnSumtDt(record.get("calcSevePayPsnSumtDt"));    /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
//							remt3000Dto.setDegtrNm(record.get("degtrNm"));    /** column 대표자성명 : degtrNm */
//							remt3000Dto.setCorpNmFmnm(record.get("corpNmFmnm"));    /** column 법인명_상호 : corpNmFmnm */
//							remt3000Dto.setBusoprRgstnNum(record.get("busoprRgstnNum"));    /** column 사업자등록번호 : busoprRgstnNum */
//							remt3000Dto.setResnRegnNum(record.get("resnRegnNum"));    /** column 주민등록번호 : resnRegnNum */
//							remt3000Dto.setCorpNum(record.get("corpNum"));    /** column 법인번호 : corpNum */
//							remt3000Dto.setIncmRegrstDebrZpcd(record.get("incmRegrstDebrZpcd"));    /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
//							remt3000Dto.setIncmRegrstDebrFndtnAddr(record.get("incmRegrstDebrFndtnAddr"));    /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
//							remt3000Dto.setIncmRegrstDebrDtlPatrAddr(record.get("incmRegrstDebrDtlPatrAddr"));    /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
//							remt3000Dto.setJuriTxOffcCd(record.get("juriTxOffcCd"));    /** column 관할세무서코드 : juriTxOffcCd */
//							remt3000Dto.setPentrCd(record.get("pentrCd"));    /** column 제출자구분코드 : pentrCd */
//							remt3000Dto.setTxDeptyNum(record.get("txDeptyNum"));    /** column 세무대리인번호 : txDeptyNum */
//							remt3000Dto.setHmtxId(record.get("hmtxId"));    /** column 홈텍스ID : hmtxId */
//							remt3000Dto.setTxPgmCd(record.get("txPgmCd"));    /** column 세무프로그램코드 : txPgmCd */
//							remt3000Dto.setPernChrgDeptNm(record.get("pernChrgDeptNm"));    /** column 담당자부서명 : pernChrgDeptNm */
//							remt3000Dto.setPernChrgNm(record.get("pernChrgNm"));    /** column 담당자성명 : pernChrgNm */
//							remt3000Dto.setPernChrgPhnNum(record.get("pernChrgPhnNum"));    /** column 담당자전화번호 : pernChrgPhnNum */
//							remt3000Dto.setCllnDebrDivCd(record.get("cllnDebrDivCd"));    /** column 징수의무자구분코드 : cllnDebrDivCd */ 
  
	                        listRemt3000dto.add(remt3000Dto);
	                        
	                      }  
	                     
	                     
	                     remt0200Service.saveRemt0200ToDDlne(listRemt3000dto, actionDDlneDatabase, new AsyncCallback<Long>(){
	                         public void onFailure(Throwable caught) {
	                             MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                     MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveRemt0200ToDDlne() : " + caught), null);
	                         }
	                         public void onSuccess(Long result) { 
	                             
	                            if (result == 0) {
	                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                       ( actionDDlneDatabase.equals(ActionDatabase.DELETE) ? "마감풀기" : "마감") + "(처리)가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                            } else {
	                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                        ( actionDDlneDatabase.equals(ActionDatabase.DELETE) ? "마감풀기" : "마감") + "(처리)가 완료되었습니다.", null);
	                                
//	                                if (actionDDlneDatabase.equals(actionDDlneDatabase.INSERT)) {
//	                                    reload();
//	                                }
	                                remt3000DefGridPanel.reload();
	                                actionDDlneDatabase = ActionDatabase.UPDATE;
	                            } 
	                         } 
	                          
	                     }); 
	                     //
	                  }
	              }
	          }); 
	            
	          
	        } else {
	            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
	            return;
	        }

	} 
	
	    private void saveStdRemt0200() { 
	        
	    	   if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	    		   MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
		            return;
	           }
	            
	                Remt3100DTO remt3100Dto = new Remt3100DTO();  

	                remt3100Dto.setDpobCd(dpobCd.getValue());    /** column 사업장코드 : dpobCd */
	                remt3100Dto.setClutYrMnth(clutYrMnth.getValue());    /** column 퇴직정산정산년월 : clutYrMnth */
					remt3100Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
					remt3100Dto.setSystemkey(systemkey.getValue());    /** column SYSTEMKEY : systemkey */
	         	    
					//수정 귀속년월이 수정될수 있으므로 처리 함. 
					remt3100Dto.setCalcSevePsnBlggYrMnth(RemtUtils.getSelectedComboValue(calcSevePsnBlggYr,"year").concat(RemtUtils.getSelectedComboValue(calcSevePsnBlggMnth,"month")));    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
					remt3100Dto.setReipDt(RemtUtils.getConvertDateToString(reipDt, "yyyyMMdd"));  /** set 영수일자 : reipDt */
					remt3100Dto.setFixPayJnDt(RemtUtils.getConvertDateToString(fixPayJnDt, "yyyyMMdd"));/** set 확정급여형가입일자 : fixPayJnDt */ 
					remt3100Dto.setSevePay20111231Sum((Long)sevePay20111231Sum.getValue());/** set 퇴직금_20111231금액 : sevePay20111231Sum */
					remt3100Dto.setAimenrEcteYn(aimenrEcteYn.getValue()); /** set 소득자임원여부 : aimenrEcteYn */
					remt3100Dto.setRetryReasCd(MSFSharedUtils.getSelectedComboValue(retryReasCd,"commCd") );/** set 퇴직사유코드 : retryReasCd */
					
					 //귀속년월 수정에 따른 귀속시작일자 종료일자 변경적용 함 IMPL 
					remt3100Dto.setBlggYrBgnnDt(RemtUtils.getConvertDateToString(blggYrBgnnDt, "yyyyMMdd") );    /** column 귀속년도시작일자 : blggYrBgnnDt */
					remt3100Dto.setBlggYrEndDt(RemtUtils.getConvertDateToString(blggYrEndDt, "yyyyMMdd") );    /** column 귀속년도종료일자 : blggYrEndDt */ 
					remt3100Dto.setEndRkfcdDt(endRkfcdDt.getValue());    /** column 종_기산일자 : endRkfcdDt */
					remt3100Dto.setEndRsgtnDt(endRsgtnDt.getValue() );    /** column 종_퇴사일자 : endRsgtnDt */ 					
					
	                 remt0200Service.activityOnupdateRemt0200Save(remt3100Dto ,
	                         new AsyncCallback<Long>() {
	                 public void onFailure(Throwable caught) {
	                 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnupdateRemt0200Save(수정) : " + caught), null);
	                 }
	                 public void onSuccess(Long result) { 
	                 if (result == 0) {
	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                            "수정처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                 } else {
	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                             "수정처리가 완료되었습니다.", null);
	                    //reload();
	                    reloadRemt0200ToRemt3100();
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
	    
	private void Remt0200Print(String fileName, String repType) {
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
			
		// 출력물 디렉토리 패스경로 인사
		String strDirPath = "REMT";
		
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		
		// 보낼 파라미터
		//검색조건
		String serarchParam = "";
		
		if (remt3000DefGridPanel.getGrid().getSelectionModel().getSelectedItems() != null){
		
			//권한 설정으로 인해 추가된 부분 
			String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
			String deptCdAuth = MSFSharedUtils.allowNulls(RemtUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
			String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
	         	 
			String year = RemtUtils.getSelectedComboValue(srhClutYr,"year");
	    	String month = RemtUtils.getSelectedComboValue(srhClutMnth,"month");
	    	
			String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
			String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
			String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
			         
			serarchParam += "["+dpobCd.getValue()+"]";				//$1
			serarchParam += "["+year.concat(month)+"]";    			//$2
			serarchParam += "["+RemtUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd")+"]";			//$3 
			serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";	//$4
			serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";      			//$5
			
			//20151212-추가 시작 $6
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "[]"; 
	        } else {
	        	serarchParam += "["+ RemtUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; 
	        }  
		    //20151212-추가 끝
			serarchParam += "["+RemtUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";  //$7
			serarchParam += "["+RemtUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")+"]"; //$8
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]"; 	//$9
	    			 
	    		
	    	List<BaseModel> list = remt3000DefGridPanel.getGrid().getSelectionModel().getSelectedItems();
	    	String checkedSystemKeys = "";
	    	if(list != null && list.size() > 0){
	    		String chkkey = "";
	    		for(BaseModel bm : list){
	    			chkkey += "'"+bm.get("systemkey")+"',";
	    		}
	    		checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
	    		serarchParam += "["+checkedSystemKeys+"]"; //$13 부서 
	    	}   //$10
	    	
	    	//20151212-변경추가 시작 
		    serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  	    //$11 //유우져 아이디 넘김 
			serarchParam += "[" + MSFMainApp.get().getUser().getPayrMangDeptYn() + "]"; //$12
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "[" + deptCdAuth + "]"; //$13 부서 
			serarchParam += "[" + dtilOccuInttnCdAuth + "]"; //$14 직종세 
			//20151212-추가 끝 	
			
		    //도장 출력을 위해 추가 2014-11-06 //$10
	      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
	      		if(MSFSharedUtils.paramNull(myImgUrl)) {
	      			// myImgUrl = "http://105.19.10.32:8080";
	              	//경로오류 출력 
	      	}
	        serarchParam += "[" + myImgUrl + "]"; //$15 이미지경로
			
			String strParam = "/rp " + serarchParam;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
	    	PrintUtils.setPostCall(true);
	    	PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
		} else {
			MessageBox.alert("", "대상자 정보를 선택하여 주세요.", null);
		}
    	
	}
		
	//rex 
	private void RexPrint(String fileName) {
			
		// 출력물 디렉토리 패스경로
		String strDirPath = "REMT";
			
		// reb 출력물
		String rexFileName = fileName+".reb";
			
		// 보낼 파라미터  
		//검색조건
		String serarchParam = "";
     	 
		if (remt3000DefGridPanel.getGrid().getSelectionModel().getSelectedItems() != null){
			
			//권한 설정으로 인해 추가된 부분 
			String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
			String deptCdAuth = MSFSharedUtils.allowNulls(RemtUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
			String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
	         	 
			String year = RemtUtils.getSelectedComboValue(srhClutYr,"year");
	    	String month = RemtUtils.getSelectedComboValue(srhClutMnth,"month");
	    	
			String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
			String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
			String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
			         
			serarchParam += ""+dpobCd.getValue()+"⊥";				//$1
			serarchParam += ""+year.concat(month)+"⊥";    			//$2
			serarchParam += ""+RemtUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd")+"⊥";			//$3 
			serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";	//$4
			serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";      			//$5
			
			//20151212-추가 시작 $6
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "⊥"; 
	        } else {
	        	serarchParam += ""+ RemtUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; 
	        }  
		    //20151212-추가 끝
			serarchParam += ""+RemtUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  //$7
			serarchParam += ""+RemtUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")+"⊥"; //$8
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥"; 	//$9
	    			 
	    		
	    	List<BaseModel> list = remt3000DefGridPanel.getGrid().getSelectionModel().getSelectedItems();
	    	String checkedSystemKeys = "";
	    	if(list != null && list.size() > 0){
	    		String chkkey = "";
	    		for(BaseModel bm : list){
	    			chkkey += "'"+bm.get("systemkey")+"',";
	    		}
	    		checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
	    		serarchParam += ""+checkedSystemKeys+"⊥"; //$13 부서 
	    	}   //$10
	    	
	    	//20151212-변경추가 시작 
		    serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  	    //$11 //유우져 아이디 넘김 
			serarchParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn() + "⊥"; //$12
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "" + deptCdAuth + "⊥"; //$13 부서 
			serarchParam += "" + dtilOccuInttnCdAuth + "⊥"; //$14 직종세 
			//20151212-추가 끝 	
			
		    //도장 출력을 위해 추가 2014-11-06 //$10
	      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
	      		if(MSFSharedUtils.paramNull(myImgUrl)) {
	      			// myImgUrl = "http://105.19.10.32:8080";
	              	//경로오류 출력 
	      	}
	        serarchParam += "" + myImgUrl + "⊥"; //$15 이미지경로
			
			String strParam = "" + serarchParam;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
		} else {
			MessageBox.alert("", "대상자 정보를 선택하여 주세요.", null);
		}
	}			    


    /**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	print Service 선언부 종료
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/	    
	/**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/
//		  @Override
//		  protected void onRender(Element parent, int index) {
//		    super.onRender(parent, index);
//		    
//		    detailTp = XTemplate.create(getDetailTemplate());
//		    
//		   // formData = new FormData("-650");
//		    vp = new VerticalPanel();
//		    vp.setSpacing(10);
//		    createRemt0200Form();  //화면 기본정보를 설정
//		    createSearchForm();    //검색필드를 적용
//		    createStandardForm();    //기본정보필드  
//		    add(vp);
//		    vp.setSize("1010px", "900px");
//		  }
		  
		  public ContentPanel getViewPanel(){
				if(panel == null){
					 
					 //콤보 권한초기화
					   initLoad(); 
					
				  detailTp = XTemplate.create(getDetailTemplate()); 
				    
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				    createRemt0200Form();  //화면 기본정보를 설정
				    createSearchForm();    //검색필드를 적용
				    createLeftRForm(); 
				     
				    //엣지변환
				    //vp.setSize("1010px", "870px");
				    vp.setSize("1010px", "920px");
					 
				    /**
			          * Create the relations 
			          */
					   final RelationDef  relRemtSubtn3100 = new RelationDef(remt3000Def,false);
					   relRemtSubtn3100.addJoinDef("dpobCd", "dpobCd"); 
					   relRemtSubtn3100.addJoinDef("clutYrMnth", "clutYrMnth"); 
					   relRemtSubtn3100.addJoinDef("calcSevePayPsnDivCd", "calcSevePayPsnDivCd"); 
					   relRemtSubtn3100.addJoinDef("systemkey", "systemkey"); 
					   relRemtSubtn3100.setLinkedObject(remt3000DefGridPanel);
					   remtSubtn3100Def.addRelation(relRemtSubtn3100); 
			           
					   
			           // DETAILS 
			           final Grid remtSubtn3100Grid = remt3000DefGridPanel.getMsfGrid().getGrid();
			           remtSubtn3100Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (remt3000DefGridPanel.getCurrentlySelectedItem() != null) { 
			            		 
			            		  setRecord(remt3000DefGridPanel.getCurrentlySelectedItem());	
			            		  remtSubtn3100Def.synchronizeGridDetail(
			            				  remt3000DefGridPanel.getCurrentlySelectedItem(),
			            				  remtSubtn3100GridPanel ); 
			            		  
			            		//  remtSubtn3100GridPanel.reload(); 
			            	   }
			            	   
			            	  
			            	 
			            	  
			           }
			         });  
			           
			           
			           /**
				          * Create the relations 
				          */
						   final RelationDef  relRemt3200 = new RelationDef(remt3000Def,false);
						   relRemt3200.addJoinDef("dpobCd", "dpobCd"); 
						   relRemt3200.addJoinDef("clutYrMnth", "clutYrMnth"); 
						   relRemt3200.addJoinDef("calcSevePayPsnDivCd", "calcSevePayPsnDivCd"); 
						   relRemt3200.addJoinDef("systemkey", "systemkey"); 
						   relRemt3200.setLinkedObject(remt3000DefGridPanel);
						   remt3200Def.addRelation(relRemt3200); 
				           
						   
				           // DETAILS 
				           final Grid remt3200Grid = remt3000DefGridPanel.getMsfGrid().getGrid();
				           remt3200Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
				              public void handleEvent(BaseEvent be) {  
				            	  if (remt3000DefGridPanel.getCurrentlySelectedItem() != null) { 
				            		 
				            		  setRecord(remt3000DefGridPanel.getCurrentlySelectedItem());	
				            		  remt3200Def.synchronizeGridDetail(
				            				  remt3000DefGridPanel.getCurrentlySelectedItem(),
				            				  remt3200DefGridPanel ); 
				            		  
				            		 // remt3200DefGridPanel.reload(); 
				            	   }
				            	  
				           
				            	  
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
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate()); 
//	    
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPsnl0100Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createLeftRForm(); 
//	    
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  /**
	   * @wbp.parser.constructor
	   */
	  public Remt0200() {
		  //엣지변환
		  //setSize("1010px", "870px");
			setSize("1010px", "920px");  
	  } 
	
	  public Remt0200(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createLeftRForm() {
		  
		    LayoutContainer layoutContainer_5 = new LayoutContainer();
		    layoutContainer_5.setLayout(new ColumnLayout()); 
		    layoutContainer_5.add(createListGrid(),new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32)); 
		    layoutContainer_5.add(createStandardForm(),new com.extjs.gxt.ui.client.widget.layout.ColumnData(.68)); 
		     
		     
		    plFrmRemt0200.add(layoutContainer_5);
		    layoutContainer_5.setBorders(false);
		    
	  }
	  
	  private void createRemt0200Form() {
		  
		plFrmRemt0200 = new FormPanel();
		plFrmRemt0200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 퇴직정산관리"));
		plFrmRemt0200.setIcon(MSFMainApp.ICONS.text());
		plFrmRemt0200.setBodyStyleName("pad-text");
		plFrmRemt0200.setPadding(2);
		plFrmRemt0200.setFrame(true); 
		
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("퇴직정산관리","REMT0200");
				}
			});
		plFrmRemt0200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmRemt0200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		 sysComBass0300Dto = new PrgmComBass0300DTO();

		   //멀티콤보박스 닫기 
		plFrmRemt0200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	        @Override
	        public void handleEvent(ComponentEvent ce) { 
	        
	         //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
	                
	        //        if (f instanceof MSFMultiComboBox<?>) {
	                    
//	                    if ("srhDeptCd".equals(f.getName())) {
//	                        
//	                    } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                        
//	                    }
	                    
	          //      } else {
	               if (mutilCombo) {
	                    if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
	                        srhDeptCd.showClose(ce);
	                        mutilCombo = false;
	                  //  } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
	                  //      srhHdofcCodtnCd.showClose(ce);
	                   //     mutilCombo = false;
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
	    
		
	   	topRemt0200Bar = new ButtonBar();    
	   	topRemt0200Bar.setAlignment(HorizontalAlignment.RIGHT);
//	      buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	        public void componentSelected(ButtonEvent ce) {   
//	         
//	        }   
//	      }));   
//	      buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	        public void componentSelected(ButtonEvent ce) {   
//	           
//	        }   
//	      }));    
	  
	   	btnRemt0200Init = new Button("초기화");  
	   	btnRemt0200Init.setIcon(MSFMainApp.ICONS.new16());
	  	topRemt0200Bar.add(btnRemt0200Init);
	  	btnRemt0200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			 //초기화 
    			 formInit();
    		}
        });
	  
	  	btnRemt0200Save = new Button("저장");  
	  	btnRemt0200Save.setIcon(MSFMainApp.ICONS.save16());
	  	topRemt0200Bar.add(btnRemt0200Save); 
	  	btnRemt0200Save.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			 saveStdRemt0200();
    		}
        });
		
	  	btnRemt0200Calc = new Button("세액계산");  
	  	btnRemt0200Calc.setIcon(MSFMainApp.ICONS.save16());
	  	topRemt0200Bar.add(btnRemt0200Calc); 
	  	btnRemt0200Calc.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
    			 fnPayrRemtCalc();
    		}
        });
	  	
	   
//	  	topBtn = new Button("삭제");  
//	  	topBtn.setIcon(MSFMainApp.ICONS.delete16());
//	  	buttonBar.add(topBtn);
	  	 
	  	btnRemt0200Sreach = new Button("조회"); 
	  	btnRemt0200Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topRemt0200Bar.add(btnRemt0200Sreach);
	  	btnRemt0200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});
	  	 
	     
	      //출력구분 
	      sysComBass0300Dto.setRpsttvCd("R004");
	      lsPrntCalc = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      	 
	 // LayoutContainer layoutContainer_2 = new LayoutContainer();
//	    FormLayout frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(60); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
//	    layoutContainer_2.setLayout(frmlytSch); 
	    
	    ComboBox<BaseModel> prntCalc = new ComboBox<BaseModel>();
	    prntCalc.setForceSelection(true);
	    prntCalc.setMinChars(1);
	    prntCalc.setDisplayField("commCdNm");
	    prntCalc.setValueField("commCd");
	    prntCalc.setTriggerAction(TriggerAction.ALL);
	    prntCalc.setEmptyText("--출력구분선택--");
	    prntCalc.setSelectOnFocus(true); 
	    prntCalc.setReadOnly(false);
	    prntCalc.setEnabled(true); 
	    prntCalc.setStore(lsPrntCalc);  
	    prntCalc.setFieldLabel("출력구분"); 
	  //  layoutContainer_2.add(cmbxNewCombobox_5, new FormData("100%")); 
	  //  layoutContainer_2.setBorders(false);
	    topRemt0200Bar.add(prntCalc);
	    
	    btnRemt0200Print = new Button("원천징수인쇄"); 
	    btnRemt0200Print.setIcon(MSFMainApp.ICONS.print16()); 
	  	topRemt0200Bar.add(btnRemt0200Print);  
	  	btnRemt0200Print.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
//    			Remt0200Print("REMTT0200");
    			Remt0200Print("REMTT0200", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
    			
    		}
    	});
	  	
	  	plFrmRemt0200.add(topRemt0200Bar);    	
	  	
		//파일업로드 처리
		plFrmRemt0200.setAction("myurl");
		plFrmRemt0200.setEncoding(Encoding.MULTIPART);
		plFrmRemt0200.setMethod(Method.POST);
		    
		vp.add(plFrmRemt0200);
		//엣지변환
		//plFrmRemt0200.setSize("990px", "850px");
		plFrmRemt0200.setSize("990px", "900px");
	  }
	   
	  private LayoutContainer createListGrid() {
		  
		    LayoutContainer layoutContainer_6 = new LayoutContainer();
		    layoutContainer_6.setLayout(new FormLayout());
		     
		    FieldSet fldstNewFieldset = new FieldSet(); 
	    	fldstNewFieldset.setHeadingHtml("대상자정보");
	    	fldstNewFieldset.setCollapsible(false);
		    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		   // lcStdGrid.setStyleAttribute("paddingRight", "10px");
	 
		   
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(true); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());
		    //엣지변환
		    //cpGrid.setSize(295, 670);   
		    cpGrid.setSize(295, 700);   
		    //msfCustomForm.setHeaderVisible(false);
			 //Instantiate the GridPanel
		    remt3000DefGridPanel = new MSFGridPanel(remt3000Def, false, false, false, false,false);
			remt3000DefGridPanel.setHeaderVisible(false);  
			remt3000DefGridPanel.setBodyBorder(true);
			remt3000DefGridPanel.setBorders(true);
			//   remt2000DefGridPanel.setSize(308, 466); 
		 //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
			//   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
			  final Grid remt3000Grid = remt3000DefGridPanel.getMsfGrid().getGrid(); 
			  remt3000Grid.addListener(Events.CellDoubleClick,  new Listener<BaseEvent>() {
		            public void handleEvent(BaseEvent be) {  
		          	  if (remt3000DefGridPanel.getCurrentlySelectedItem() != null) {  
		          		 //데이타 조회하는 로직추가 
                          BaseModel bmData = new BaseModel();
		        		  
		        		  bmData = remt3000DefGridPanel.getCurrentlySelectedItem();
		        		   
		        		  dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
		        		  systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
		        		  clutYrMnth.setValue(MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")));   /** column 정산년월 : clutYrMnth */
		        	      calcSevePayPsnDivCd.setValue(lsCrCalcSevePayPsnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("calcSevePayPsnDivCd"))));   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		        	    
		        	      calcSevePsnBlggYr.setValue(lsCalcSevePsnBlggYr.findModel("year",MSFSharedUtils.allowNulls(bmData.get("calcSevePsnBlggYrMnth")).substring(0, 4)) );   /** column 정산년 : clutYr */
		        	      calcSevePsnBlggMnth.setValue(lsCalcSevePsnBlggMnth.findModel("month",MSFSharedUtils.allowNulls(bmData.get("calcSevePsnBlggYrMnth")).substring(4, 6)) );   /** column 정산월 : clutMnth */
		        	
		        	       deptNm.setValue(MSFSharedUtils.allowNulls(bmData.get("deptNm")));;   /** column 부서 : deptNm */
		        	       hanNm.setValue(MSFSharedUtils.allowNulls(bmData.get("hanNm")));;   /** column 한글성명 : hanNm */
		        	       resnRegnNum.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum")));;   /** column 주민등록번호 : resnRegnNum */
		        	       emymtDivNm.setValue(MSFSharedUtils.allowNulls(bmData.get("emymtDivNm")));;   /** column 고용구분 : emymtDivNm */
		        	       typOccuNm.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuNm")));;   /** column 직종 : typOccuNm */
		        	       
		        	      reloadRemt0200ToRemt3100();
		        	  //    reloadRemtTx();
		        	   } 
		          	     tabPanel.setSelection(tabPanel.getItem(0)); 
		          	  } 
		        });  
			   
			
			cpGrid.add(remt3000DefGridPanel); 
		    
			  ToolBar toolBar = new ToolBar();
		        toolBar.getAriaSupport().setLabel("마감일자");

		        toolBar.add(new LabelToolItem("마감일자: "));
		        
		        /** column 항목적용시작일자 : itemApptnBgnnDt */
		        ddlneDt = new MSFDateField();
		        ddlneDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		        ddlneDt.setName("ddlneDt"); 
		        ddlneDt.setHideLabel(true);
		        ddlneDt.setWidth("100px");
		        ddlneDt.setValue(new Date());
		        
		        toolBar.add(ddlneDt);
		        toolBar.setAlignment(HorizontalAlignment.RIGHT); 
		        
		        final ButtonBar btnBar01 = new ButtonBar();     
		        btnBar01.setAlignment(HorizontalAlignment.RIGHT); 
		         
		        
		        btnBar01.add(new Button("마 감", new SelectionListener<ButtonEvent>() {   
			      @Override  
			      public void componentSelected(ButtonEvent ce) {  
			    	  
			          
		              Iterator<BaseModel> itBm  = remt3000DefGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		              
		              List<Record>  lsRec  = new ArrayList<Record>();
		              
		              while(itBm.hasNext()) {

		                  Record rec  = new Record(itBm.next()); 
		                  lsRec.add(rec);
		                  
		              } 
		               setListRecord(lsRec.iterator()); 
		        
		               actionDDlneDatabase = ActionDatabase.INSERT;
		               doDDlneAction(actionDatabase);
		               
 
			      }   
			    }));  
			   
		         btnBar01.add(new Button("마감풀기", new SelectionListener<ButtonEvent>() {   
			      @Override  
			      public void componentSelected(ButtonEvent ce) {   
			    	 
			          Iterator<BaseModel> itBm  = remt3000DefGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		              
		              List<Record>  lsRec  = new ArrayList<Record>();
		              
		              while(itBm.hasNext()) {

		                  Record rec  = new Record(itBm.next()); 
		                  lsRec.add(rec);
		                  
		              } 
		               setListRecord(lsRec.iterator());  
		               
 
		               actionDDlneDatabase = ActionDatabase.DELETE;
                       doDDlneAction(actionDatabase);
		               
 
			      }   
			    }));  
			    
		         toolBar.add(btnBar01);  
		         cpGrid.setBottomComponent(toolBar);
		     
			
		    	lcStdGrid.add(cpGrid);   
		        fldstNewFieldset.add(lcStdGrid); 
		  //  fldstNewFieldset.setSize(300, 500);
		      
		     layoutContainer_6.add(fldstNewFieldset);  
		     
		     return  layoutContainer_6;
	  }

	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {   
		  
	      
	      sysComBass0150Dto = new PrgmComBass0150DTO();
	      sysComBass0300Dto = new PrgmComBass0300DTO();
	      sysComBass0400Dto = new PrgmComBass0400DTO();
	      sysComBass0500Dto = new PrgmComBass0500DTO();
	      msfCoCalendarDto = new SysCoCalendarDTO();
	      sysComBass0350Dto = new PrgmComBass0350DTO();
	      sysComBass0320Dto = new PrgmComBass0320DTO();
	      
	      //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	      lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	      //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	      
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      //정산구분 
	      sysComBass0300Dto.setRpsttvCd("B027");
	      lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 
	   
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      //고용구분
	      sysComBass0300Dto.setRpsttvCd("A002");
	      lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      
	  	  //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      //호봉
	  	  sysComBass0300Dto.setRpsttvCd("A048");
	  	  lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	  	  //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      
	      
	  	//--------------------급여년도 불러 오는 함수 ------------------------------------------------
	         lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	         lsCalcSevePsnBlggYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	         
	        
	         
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      //월 
	      
	      lsClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	      lsCalcSevePsnBlggMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------

	        //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
	       sysComBass0400Dto.setDeptDspyYn("Y");
	       sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	       sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	      
	       lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	      
	       lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	           public void handleEvent(StoreEvent<BaseModel> be) {  
	               mDtalistDeptCd = RemtUtils.getDeptCdModelData(lsDeptCd) ; 
	               srhDeptCd.getInitStore().add(mDtalistDeptCd);
	               
	           }
	       });     
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
//	               ContentPanel typOccuCdGrid = new ContentPanel();  
//	               typOccuCdGrid.setVisible(false);
//	                 
//	                 //직종 콤보처리 
//	                typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	                typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	                        public void handleEvent(ComponentEvent be) {  
//	                          typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	                           public void handleEvent(StoreEvent<BaseModel> be) {  
//	                               
//	                             lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//	                             mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                             srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	                           }  
//	                         });  
//	                        
//	                       }  
//	                     });  
//	           
//	              typOccuCdGrid.add(typOccuCdGridPanel); 
//	              plFrmRemt0200.add(typOccuCdGrid);
	              
	       lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
 		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                  mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                  srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                   
                }
            });  
 		   
	      plFrmRemt0200.setLayout(new FlowLayout());
	     
	     srhSystemkey = new HiddenField<String>(); 
	       
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
			
	    // fieldSet.setCheckboxToggle(false); 
	     
	     LayoutContainer lcSchLeft = new LayoutContainer();
	    // lcSchLeft.setStyleAttribute("paddingRight", "10px");
	    

	     fieldSet.add(lcSchCol, new FormData("100%"));  
	     lcSchLeft.setLayout(new ColumnLayout());
	     
	     LayoutContainer layoutContainer_8 = new LayoutContainer();
	     FormLayout frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_8.setLayout(frmlytSch);
	     
	     srhClutYr = new ComboBox<BaseModel>();
	     srhClutYr.setName("srhClutYr");
	     srhClutYr.setForceSelection(true);
	     srhClutYr.setMinChars(1);
	     srhClutYr.setDisplayField("yearDisp");
	     srhClutYr.setValueField("year");
	     srhClutYr.setTriggerAction(TriggerAction.ALL);
	    // srhClutYr.setEmptyText("--년도선택--");
	     srhClutYr.setSelectOnFocus(true); 
	     srhClutYr.setReadOnly(false);
	     srhClutYr.setEnabled(true); 
	     srhClutYr.setStore(lsClutYrStore);
	     srhClutYr.setFieldLabel("정산년월"); 
	     srhClutYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
             public void handleEvent(StoreEvent<BaseModel> be) {  
            	 checkPayr3100Auth("srhClutYr", lsClutYrStore); 
             }
         });
	     srhClutYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	           public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	               //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	            BaseModel bmClutYr =  se.getSelectedItem(); 
	            if (bmClutYr != null) {
	                
	                if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                    
	                    if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                       
	                        sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year"));
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
	     layoutContainer_8.add(srhClutYr, new FormData("100%"));
	     lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
	     layoutContainer_8.setBorders(false);
	     
	     LayoutContainer layoutContainer_9 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(0); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_9.setLayout(frmlytSch);
	     
	     /** column 지급년월 : Mnth */ 
	     srhClutMnth = new ComboBox<BaseModel>();
	     srhClutMnth.setName("srhClutMnth");
	     srhClutMnth.setForceSelection(true);
	     srhClutMnth.setMinChars(1);
	     srhClutMnth.setDisplayField("monthDisp");
	     srhClutMnth.setValueField("month");
	     srhClutMnth.setTriggerAction(TriggerAction.ALL);
	    // srhClutMnth.setEmptyText("--월선택--");
	     srhClutMnth.setSelectOnFocus(true);   
	     srhClutMnth.setStore(lsClutMnth); 
	     srhClutMnth.setHideLabel(true);
	     srhClutMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
             public void handleEvent(StoreEvent<BaseModel> be) {  
            
            	 checkPayr3100Auth("srhClutMnth", lsClutMnth); 
             }
         });
	     layoutContainer_9.add(srhClutMnth, new FormData("100%"));
	     lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	     layoutContainer_9.setBorders(false);
	     
	     
	     LayoutContainer layoutContainer_14 = new LayoutContainer();
	     layoutContainer_14.setBorders(false);
	     
	     frmlytSch = new FormLayout();  
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
	     
	     srhPayrMangDeptCd.setEnabled(true); 
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
		                	checkPayr3100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
               	 }
	           
	             
	         }
	     });    
	     srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	         public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	             sysComBass0400Dto.setDeptDspyYn("Y");
	             sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	             //--------------------부서 불러 오는 함수 ------------------------------------------------
	             lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	             //--------------------부서 불러 오는 함수 ------------------------------------------------
	             lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	                public void handleEvent(StoreEvent<BaseModel> be) {  
	                  mDtalistDeptCd = RemtUtils.getDeptCdModelData(lsDeptCd) ; 
	                  srhDeptCd.getInitStore().add(mDtalistDeptCd);
	                    
	                }
	             });  
	         } 
	     });
	     layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
	     
	     LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
	     layoutContainer.setBorders(false); 
	     
	     LayoutContainer layoutContainer_15 = new LayoutContainer();
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_15.setLayout(frmlytSch);
	     
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
		                	checkPayr3100Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	     layoutContainer_15.add(srhEmymtDivCd, new FormData("100%"));
	     layoutContainer.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	     
	     
	     LayoutContainer layoutContainer_101 = new LayoutContainer();
	     layoutContainer_101.setBorders(false);

	     frmlytSch = new FormLayout();
	     frmlytSch.setLabelWidth(0);
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	     layoutContainer_101.setLayout(frmlytSch);
		    
	     srhRepbtyBusinDivCd = new ComboBox<BaseModel>();
	     srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	     srhRepbtyBusinDivCd.setHideLabel(true);
	     srhRepbtyBusinDivCd.setForceSelection(true);
	     srhRepbtyBusinDivCd.setAllowBlank(false);
	     srhRepbtyBusinDivCd.setMinChars(1);
	     srhRepbtyBusinDivCd.setLabelSeparator("");
	     srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	     srhRepbtyBusinDivCd.setValueField("commCd");
	     srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	     srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	     srhRepbtyBusinDivCd.setSelectOnFocus(true);
	     srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	     srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
	     srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	     lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  

	              
			}
	     });  
		layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		layoutContainer.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	     
	     
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
//	     srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	         @Override
//	         public void handleEvent(BaseEvent be) {  
//	             if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                 srhSystemkey.setValue("");
//	                 srhResnRegnNum.setValue("");
//	             }
//	          
//	         } 
//	    }); 
	     layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
	     layoutContainer_6.setBorders(false);
	     
         LayoutContainer layoutContainer_btn = new LayoutContainer();
         frmlytSch = new FormLayout();  
         frmlytSch.setLabelWidth(0); 
         layoutContainer_btn.setLayout(frmlytSch);
	     
	     Button btnHanNm = new Button("검색");
//	     layoutContainer_5.add(btnHanNm);
	     btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	         public void handleEvent(ButtonEvent e) {
	             srhSystemkey.setValue("");
	             srhResnRegnNum.setValue("");   
	           fnPopupPsnl0100() ;
	               
	         }
	     });
         layoutContainer_btn.add(btnHanNm);
         layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	     
	     LayoutContainer layoutContainer_7 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setDefaultWidth(0);
//	     frmlytSch.setLabelWidth(0); 
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
	     layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	     layoutContainer_7.setBorders(false); 
	     layoutContainer_5.setBorders(false);
	     
//	     lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 			// 정산년월
//	     lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 단위기관
//	     lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));		// 고용구분
//	     lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));		// 성명
	     
	     lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 				// 정산년월
	     lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
	     lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 고용구분
	     
	     
	     
	     LayoutContainer layoutContainer_13 = new LayoutContainer();
	     layoutContainer_13.setLayout(new ColumnLayout());
	     
	     
	     
	     LayoutContainer layoutContainer_1 = new LayoutContainer();
	     layoutContainer_1.setBorders(false);
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	     layoutContainer_1.setLayout(frmlytSch);
	     
	     srhCalcSevePayPsnDivCd =  new ComboBox<BaseModel>(); 
	     srhCalcSevePayPsnDivCd.setName("srhCalcSevePayPsnDivCd");
	     srhCalcSevePayPsnDivCd.setForceSelection(true);
	     srhCalcSevePayPsnDivCd.setMinChars(1);
	     srhCalcSevePayPsnDivCd.setDisplayField("commCdNm");
	     srhCalcSevePayPsnDivCd.setValueField("commCd");
	     srhCalcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
	     srhCalcSevePayPsnDivCd.setEmptyText("--정산구분선택--");
	     srhCalcSevePayPsnDivCd.setSelectOnFocus(true); 
	     srhCalcSevePayPsnDivCd.setReadOnly(false);
	     srhCalcSevePayPsnDivCd.setEnabled(true); 
	     srhCalcSevePayPsnDivCd.setStore(lsCalcSevePayPsnDivCd);
	     srhCalcSevePayPsnDivCd.setFieldLabel("정산구분");
	     srhCalcSevePayPsnDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	         public void handleEvent(StoreEvent<BaseModel> be) {  
	        	 checkPayr3100Auth("srhCalcSevePayPsnDivCd", lsCalcSevePayPsnDivCd); 
	         }
	     });    
	     layoutContainer_1.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
	     
	     
	     
	     LayoutContainer layoutContainer_2 = new LayoutContainer();
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_2.setLayout(frmlytSch);
	     
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
		                	checkPayr3100Auth("srhDeptCd", lsDeptCd); 
               	 }
	           
	         }
	     });    

	     srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	        @Override
	       public void handleEvent(ComponentEvent ce) { 
	                
	                   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                      
	                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                          
	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year"));    
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
	            		   String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	             
	                             mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	                           }
	                       });  
             	    
		               } else {
		             	  
		             	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		            		   String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		             	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		          		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		         	            public void handleEvent(StoreEvent<BaseModel> be) {  
		         	             
		                           mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
//	          BaseModel bmPayCd =  se.getSelectedItem(); 
//	          if (bmPayCd != null && Constants.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//	              if (bmPayCd != null) {  
//	                 
//	                  sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//	                  sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//	              }      
//	           
//	              //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	               //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                srhBusinCd.setStore(lsBusinCd); 
//	                srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                    public void handleEvent(StoreEvent<BaseModel> be) {  
//	                     //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                    }
//	                });    
//	          
//	          }  
	         
	         } 
	     });
	     //검색 소속부서 코드 처리  
	  //   LayoutContainer lccmlcDeptNm = new LayoutContainer();
	  //   lccmlcDeptNm.setLayout(new ColumnLayout());
//	        //부서 
	  //   srhDeptCd = new TextField<String>();
	  //   srhDeptCd.setName("srhDeptCd");
	  //   srhDeptCd.setVisible(false);
	  //   srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//	         @Override
//	         public void handleEvent(BaseEvent be) { 
//	           if(srhDeptCd.getValue() != null){ 
//	              
//	                   PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//	                   sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year")); 
//	                   sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//	               
//	                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                   lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                  //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                   srhBusinCd.setStore(lsBusinCd); 
//	                   srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                       public void handleEvent(StoreEvent<BaseModel> be) {  
//	                        //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                       }
//	                   });    
//	              
//	           } 
//	         }
//	      });
	  //   plFrmPayr4220.add(srhDeptCd);
	  //   srhMangeDeptCd = new TextField<String>();
	  //   srhMangeDeptCd.setName("srhMangeDeptCd");
	  //   srhMangeDeptCd.setVisible(false);
	  //   plFrmPayr4220.add(srhMangeDeptCd);
	  //   srhMangeDeptNm = new TextField<String>();
	  //   srhMangeDeptNm.setName("srhMangeDeptNm");
	  //   srhMangeDeptNm.setVisible(false);
	  //   plFrmPayr4220.add(srhMangeDeptNm);
	  //
//	      LayoutContainer lcDeptNm = new LayoutContainer(); 
//	      frmlytSch = new FormLayout();
//	      frmlytSch.setLabelWidth(70);
//	      frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//	      lcDeptNm.setLayout(frmlytSch);
	  // 
//	      srhDeptNm = new TextField<String>();
//	      srhDeptNm.setName("srhDeptNm");
//	      srhDeptNm.setFieldLabel("부서");  
//	      srhDeptNm.addKeyListener(new KeyListener() {
//	           public void componentKeyUp(ComponentEvent event) {
//	               super.componentKeyUp(event); 
//	               if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                       srhDeptCd.setValue("");
//	                       srhMangeDeptCd.setValue("");
//	                   }
//	                   fnPopupCommP140(srhDeptNm.getValue());
//	               }
//	           }
//	       });
	  //    
//	      srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	                 @Override
//	                 public void handleEvent(BaseEvent be) { 
//	                      
//	                     if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                         srhDeptCd.setValue("");
//	                         srhMangeDeptCd.setValue("");
//	                     }
//	                  
//	                 } 
//	        });        
//	       lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//	       
//	        btnSrhDeptCd = new Button();
//	        btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//	        btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//	            public void handleEvent(ButtonEvent e) { 
//	                if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                    srhDeptCd.setValue("");
//	                    srhMangeDeptCd.setValue("");
//	                }
//	                fnPopupCommP140(srhDeptNm.getValue()); 
//	            }
//	        });
//	         
//	        lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//	        lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	          
	     layoutContainer_2.add(srhDeptCd, new FormData("100%"));
	     layoutContainer_2.setBorders(false);
	     
	     LayoutContainer layoutContainer_10 = new LayoutContainer();
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(70); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_10.setLayout(frmlytSch);
	     
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
	     
	     
	     //직종 직종세처리  
	     LayoutContainer lcTypOccuCd = new LayoutContainer();
	     lcTypOccuCd.setLayout(new ColumnLayout());
	        
	     LayoutContainer layoutContainer_21 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setDefaultWidth(0);
//	     frmlytSch.setLabelWidth(70); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_21.setLayout(frmlytSch); 
	     
	     srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	     srhTypOccuCd.setName("srhTypOccuCd"); 
	     srhTypOccuCd.setEmptyText("--직종선택--"); 
	     srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	     srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	     srhTypOccuCd.setWidth(100);
	     srhTypOccuCd.setHideLabel(true);
//	     srhTypOccuCd.setFieldLabel("직종");
	     srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	     srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	     srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	         public void handleEvent(StoreEvent<ModelData> be) {  
	        	
	          	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   //2015.11.30 추가 
		    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
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
		                	//checkPayr3100Auth("srhTypOccuCd", lsTypOccuCd); 
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
	  //   srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
	  //   srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
	  //   srhDtilOccuInttnCd.setForceSelection(true);
	  //   srhDtilOccuInttnCd.setMinChars(1);
	  //   srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
	  //   srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
	  //   srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
	  //   srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
	  //   srhDtilOccuInttnCd.setSelectOnFocus(true); 
	  //   srhDtilOccuInttnCd.setReadOnly(false);
	  //   srhDtilOccuInttnCd.setEnabled(true);  
	  //   srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
	  // //  srhDtilOccuInttnCd.setFieldLabel("직종세");
	  //   srhDtilOccuInttnCd.setLabelSeparator("");
	    
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
	     
	     layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
	     layoutContainer_10.setBorders(false);
	     
	    
	     
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
	     srhBusinCd.getListView().setWidth("200px");
	     srhBusinCd.setStore(lsBusinCd);
	     srhBusinCd.setFieldLabel("사업");
	     srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	     srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
	     layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	     layoutContainer_4.setBorders(false);
	     
	     
//	     layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	// 정산구분
//	     layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 부서
//	     layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 직종
//	     layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 사업
	     
	     layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 정산구분
	     layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
	     layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
	     
	     fieldSet.add(layoutContainer_13);
	     
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		
        LayoutContainer layoutContainer_16 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_16.setLayout(frmlytSch);
        
        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 성명
        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
       
	     
		fieldSet.add(lcSchCol3);
	     
	      
		
	    plFrmRemt0200.add(fieldSet); 
		//vp.add(panel);   
	  }  
	  

	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
              
              //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                  
                  sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                  String strDeptCd = RemtUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                  sysComBass0350Dto.setDeptCd(strDeptCd);
                  List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                  String strTypOccuCd = RemtUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                  
                 // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                  
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                      
                      lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                      
                      lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                          public void handleEvent(StoreEvent<BaseModel> be) {  
                              mDtalistDtilOccuInttnCd = RemtUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
//          String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//          if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//              sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//              sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//              if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                  lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//              }
//          }   
	  } 
	  /**
	   * 기본사항 
	   */
	  private LayoutContainer createStandardForm() {
		  
		  
		  
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      //퇴직사유구분코드 
	      sysComBass0300Dto.setRpsttvCd("R003");
	      lsRetryReasCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		  
		    dpobCd = new HiddenField<String>();   /** column 사업장코드 : dpobCd */  
		    systemkey= new HiddenField<String>();   /** column SYSTEMKEY : systemkey */  
		    deptCd = new HiddenField<String> ();   /** column 부서코드 : deptCd */
		    frgnrDivCd= new HiddenField<String>();   /** column 외국인구분코드 : frgnrDivCd */
		    ridnSeptYn= new HiddenField<Boolean>();   /** column 거주구분여부 : ridnSeptYn */
		    ridnCd = new HiddenField<String>();   /** column 거주지국코드 : ridnCd */
		    ridnNm= new HiddenField<String>();   /** column 거주지국명 : ridnNm */
		    
		    clutYrMnth= new HiddenField<String>(); /** column 퇴직정산정산년월 : clutYrMnth */
		    calcSevePsnBlggYrMnth= new HiddenField<String>(); 
		     
	  	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	  	  //  layoutContainer_1.setLayout(new FlowLayout(2));
	  	    layoutContainer_1.setBorders(false);
	  	    
	  	    //우측 기본정보
	  	   layoutContainer_1.add(rightForm01());
	  	  
		   
	  	    tabPanel = new TabPanel(); 
		    //tabsPsnl.setMinTabWidth(80);   
		    tabPanel.setAutoWidth(false);
		   // tabsPsnl.setResizeTabs(true);   
		    tabPanel.setAnimScroll(true);   
		    tabPanel.setTabScroll(true); 
		    tabPanel.setPlain(true);   
		    tabPanel.setSize(655, 600);    
		    
		    //1.소득명세 
		    TabItem tabitem01 = new TabItem("소득명세"); 
		    tabitem01.add(createTabItem01());
		    tabPanel.add(tabitem01);
		    tabitem01.setSize("652", "595");
		    
		    //세액계산 탭
		    TabItem tabitem02 = new TabItem("세액계산");
		    tabitem02.add(createTabItem02()); 
		    tabPanel.add(tabitem02);
		    tabitem02.setSize("652", "595");
		    tabPanel.setHeight("595");
		     
		     layoutContainer_1.add(tabPanel);  
		     
		     return layoutContainer_1; 
		  }  
	  

private FieldSet rightForm01() { 
    
    // LayoutContainer layoutContainer = new LayoutContainer();   
    
    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    //정산구분 
    sysComBass0300Dto.setRpsttvCd("B027");
    lsCrCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    
//    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//    //퇴직사유 
//    sysComBass0300Dto.setRpsttvCd("R003");
//    lsRetryReasCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    
    
	 FieldSet subFdSet01 = new FieldSet(); 
     subFdSet01.setHeadingHtml("기본정보");
     
     ContentPanel cp02 = new ContentPanel();
     cp02.setHeaderVisible(false); 
     //엣지변환
     //cp02.setSize(640, 72); 
     cp02.setSize(640, 102); 
     cp02.setLayout(new FlowLayout());
     
     LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());
     
     LayoutContainer layoutContainer_5 = new LayoutContainer();
     layoutContainer_5.setBorders(false);
     FormLayout frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(40); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_5.setLayout(frmlytStd);

     LayoutContainer layoutContainer_1_1 = new LayoutContainer();
     layoutContainer_1_1.setLayout(new ColumnLayout());
     
     LayoutContainer   layoutContainer_13 = new LayoutContainer();
     FormLayout frmlytSch = new FormLayout();  
     frmlytSch.setLabelWidth(60); 
     frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
     layoutContainer_13.setLayout(frmlytSch); 
     
     calcSevePsnBlggYr = new MSFComboBox<BaseModel>(); 
     calcSevePsnBlggYr.setName("calcSevePsnBlggYr");
     calcSevePsnBlggYr.setForceSelection(true);
     calcSevePsnBlggYr.setMinChars(1);
     calcSevePsnBlggYr.setDisplayField("yearDisp");
     calcSevePsnBlggYr.setValueField("year");
     calcSevePsnBlggYr.setTriggerAction(TriggerAction.ALL);
     calcSevePsnBlggYr.setEmptyText("----");
     calcSevePsnBlggYr.setSelectOnFocus(true); 
   //  calcSevePsnBlggYr.setReadOnly(false);
     calcSevePsnBlggYr.setEnabled(true); 
     calcSevePsnBlggYr.setStore(lsCalcSevePsnBlggYr);
     calcSevePsnBlggYr.setFieldLabel("정산년월");   
     layoutContainer_13.add(calcSevePsnBlggYr, new FormData("100%"));
     layoutContainer_13.setBorders(false);
     
     layoutContainer_1_1.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.72));
     
     LayoutContainer layoutContainer_2_3 = new LayoutContainer();
      frmlytSch = new FormLayout();  
     frmlytSch.setLabelWidth(0); 
     frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
     layoutContainer_2_3.setLayout(frmlytSch); 
     
     calcSevePsnBlggMnth = new MSFComboBox<BaseModel>(); 
     calcSevePsnBlggMnth.setName("calcSevePsnBlggMnth");
     calcSevePsnBlggMnth.setForceSelection(true);
     calcSevePsnBlggMnth.setMinChars(1);
     calcSevePsnBlggMnth.setDisplayField("monthDisp");
     calcSevePsnBlggMnth.setValueField("month");
     calcSevePsnBlggMnth.setTriggerAction(TriggerAction.ALL);
     calcSevePsnBlggMnth.setEmptyText("----");
     calcSevePsnBlggMnth.setSelectOnFocus(true); 
   //  calcSevePsnBlggMnth.setReadOnly(false);
     calcSevePsnBlggMnth.setEnabled(true); 
     calcSevePsnBlggMnth.setStore(lsCalcSevePsnBlggMnth);
   //  calcSevePsnBlggMnth.setFieldLabel("정산년월");   

     layoutContainer_2_3.add(calcSevePsnBlggMnth, new FormData("100%")); 
     calcSevePsnBlggMnth.setHideLabel(true); 
      
     layoutContainer_1_1.add(layoutContainer_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
     layoutContainer_1_1.setBorders(false);
     
     layoutContainer_5.add(layoutContainer_1_1, new FormData("100%"));
     
     layoutContainer_6.add(layoutContainer_5 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3) );
     
     LayoutContainer layoutContainer_3_1 = new LayoutContainer();
       frmlytSch = new FormLayout();  
     frmlytSch.setLabelWidth(60); 
     frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
     layoutContainer_3_1.setLayout(frmlytSch);
     
     /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
     calcSevePayPsnDivCd = new MSFComboBox<BaseModel>(); 
     calcSevePayPsnDivCd.setName("calcSevePayPsnDivCd");
     calcSevePayPsnDivCd.setForceSelection(true);
     calcSevePayPsnDivCd.setMinChars(1);
     calcSevePayPsnDivCd.setDisplayField("commCdNm");
     calcSevePayPsnDivCd.setValueField("commCd");
     calcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
     calcSevePayPsnDivCd.setEmptyText("----");
     calcSevePayPsnDivCd.setSelectOnFocus(true); 
     calcSevePayPsnDivCd.setReadOnly(true); 
     calcSevePayPsnDivCd.setStore(lsCrCalcSevePayPsnDivCd);   
     calcSevePayPsnDivCd.setFieldLabel("정산구분");
     layoutContainer_3_1.add(calcSevePayPsnDivCd, new FormData("100%")); 
     layoutContainer_6.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     layoutContainer_3_1.setBorders(false);
      
     LayoutContainer layoutContainer_3 = new LayoutContainer();
     layoutContainer_3.setBorders(false); 
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(70); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_3.setLayout(frmlytStd);
     
     hanNm = new MSFTextField();
     hanNm.setReadOnly(true);
     layoutContainer_3.add(hanNm, new FormData("100%"));
     hanNm.setFieldLabel("성명");
     layoutContainer_6.add(layoutContainer_3 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 
     
     LayoutContainer layoutContainer_4 = new LayoutContainer();
     layoutContainer_4.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(0); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_4.setLayout(frmlytStd);
     
     resnRegnNum = new MSFTextField();
     resnRegnNum.setReadOnly(true);
     layoutContainer_4.add(resnRegnNum, new FormData("100%"));
     resnRegnNum.setHideLabel(true);
     layoutContainer_6.add(layoutContainer_4 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 
      
     cp02.add(layoutContainer_6);  
     

     LayoutContainer layoutContainer71 = new LayoutContainer();
     layoutContainer71.setLayout(new ColumnLayout());
     
     LayoutContainer layoutContainer_61 = new LayoutContainer();
     layoutContainer_61.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_61.setLayout(frmlytStd);
     
     emymtDivNm = new MSFTextField();
     emymtDivNm.setReadOnly(true);
     layoutContainer_61.add(emymtDivNm, new FormData("100%"));
     emymtDivNm.setFieldLabel("고용구분"); 
     layoutContainer71.add(layoutContainer_61,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     
     LayoutContainer layoutContainer_62 = new LayoutContainer();
     layoutContainer_62.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_62.setLayout(frmlytStd);
     
     deptNm = new MSFTextField();
     deptNm.setReadOnly(true);
     layoutContainer_62.add(deptNm, new FormData("100%"));
     deptNm.setFieldLabel("부서");
     layoutContainer71.add(layoutContainer_62,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     
     LayoutContainer layoutContainer_69 = new LayoutContainer();
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(70); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_69.setLayout(frmlytStd);
     
     typOccuNm = new MSFTextField();
     typOccuNm.setReadOnly(true);
     layoutContainer_69.add(typOccuNm, new FormData("100%"));
     typOccuNm.setFieldLabel("직종(사업)");
     layoutContainer71.add(layoutContainer_69,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
     layoutContainer_69.setBorders(false);
     cp02.add(layoutContainer71);
       
     
     LayoutContainer layoutContainer171 = new LayoutContainer();
     layoutContainer171.setLayout(new ColumnLayout());
     
     LayoutContainer layoutContainer_161 = new LayoutContainer();
     layoutContainer_161.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_161.setLayout(frmlytStd);
     
     blggYrBgnnDt = new MSFDateField();
     blggYrBgnnDt.setReadOnly(true);
     new DateFieldMask(blggYrBgnnDt, "9999.99.99"); 
     blggYrBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     blggYrBgnnDt.setName("blggYrBgnnDt");
     blggYrBgnnDt.setAllowBlank(false);
     layoutContainer_161.add(blggYrBgnnDt, new FormData("100%"));
     blggYrBgnnDt.setFieldLabel("귀속년도"); 
     layoutContainer171.add(layoutContainer_161,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     
     LayoutContainer layoutContainer_162 = new LayoutContainer();
     layoutContainer_162.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_162.setLayout(frmlytStd);
     
     blggYrEndDt = new MSFDateField();
     new DateFieldMask(blggYrEndDt, "9999.99.99"); 
     blggYrEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     blggYrEndDt.setName("blggYrEndDt");
     blggYrEndDt.setAllowBlank(false);
     blggYrEndDt.setReadOnly(true); 
     blggYrEndDt.setFieldLabel(" ~ ");
     blggYrEndDt.setLabelSeparator("");
     layoutContainer_162.add(blggYrEndDt, new FormData("100%"));
     layoutContainer171.add(layoutContainer_162,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     
     LayoutContainer layoutContainer_2_1 = new LayoutContainer();
     frmlytSch = new FormLayout();  
     frmlytSch.setLabelWidth(70); 
     frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
     layoutContainer_2_1.setLayout(frmlytSch);
   
     reipDt = new MSFDateField(); 
     new DateFieldMask(reipDt, "9999.99.99"); 
     reipDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     reipDt.setName("rkfcdDt");
     reipDt.setAllowBlank(false);
     layoutContainer_2_1.add(reipDt, new FormData("100%"));
     reipDt.setFieldLabel("영수일자");
     layoutContainer171.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
     layoutContainer_2_1.setBorders(false); 
   
     cp02.add(layoutContainer171);
 
     subFdSet01.add(cp02) ;   
     
    return subFdSet01;
       
 }
	  

	  /**
	   * 탭항목 소득명세
	   * @return
	   */
	  private LayoutContainer createTabItem01() {
		   
		    LayoutContainer layoutContainerItem01 = new LayoutContainer();
		    layoutContainerItem01.setStyleAttribute("padding", "3px");
		    layoutContainerItem01.setLayout(new FormLayout()); 
		    layoutContainerItem01.setBorders(false);
		    
//		    LayoutContainer layoutContainer_3 = new LayoutContainer();
//		    layoutContainer_3.setStyleAttribute("paddingTop", "4px");
//		    layoutContainer_3.setLayout(new ColumnLayout()); 
//		    layoutContainer_3.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_810 = new LayoutContainer();
//		  
//		    FormLayout frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(60); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
//		    layoutContainer_810.setLayout(frmlytSch);
//		    layoutContainer_810.setBorders(false); 
//		    
//		    LabelField lblfldNewLabelfield = new LabelField("귀속년월 : "); 
//		    lblfldNewLabelfield.setStyleAttribute("paddingTop", "4px");
//		    layoutContainer_810.add(lblfldNewLabelfield,  new FormData("100%") );
//		    layoutContainer_3.add(layoutContainer_810, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    
//		    LayoutContainer layoutContainer_310 = new LayoutContainer();
//		    layoutContainer_310.setLayout(new ColumnLayout());
//		    layoutContainer_310.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_410 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(0); 
//		    frmlytSch.setLabelAlign(LabelAlign.LEFT);   
//		    layoutContainer_410.setLayout(frmlytSch);
//		    layoutContainer_410.setBorders(false); 
//		    
//		    //년도 콤보박스
//		    
//		     calcSevePsnBlggYr = new ComboBox<BaseModel>(); 
//		     calcSevePsnBlggYr.setName("calcSevePsnBlggYr");
//		     calcSevePsnBlggYr.setForceSelection(true);
//		     calcSevePsnBlggYr.setMinChars(1);
//		     calcSevePsnBlggYr.setDisplayField("commCdNm");
//		     calcSevePsnBlggYr.setValueField("commCd");
//		     calcSevePsnBlggYr.setTriggerAction(TriggerAction.ALL);
//		     calcSevePsnBlggYr.setEmptyText("--정산년도선택--");
//		     calcSevePsnBlggYr.setSelectOnFocus(true); 
//		     calcSevePsnBlggYr.setReadOnly(false);
//		     calcSevePsnBlggYr.setEnabled(true); 
//		     calcSevePsnBlggYr.setStore(lsCalcSevePsnBlggYr);   
//		    
//		    layoutContainer_410.add(calcSevePsnBlggYr,  new FormData("100%") ); 
//		    calcSevePsnBlggYr.setHideLabel(true);
//		    
//		  
//		    LayoutContainer layoutContainer_420 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(0); 
//		    frmlytSch.setLabelAlign(LabelAlign.LEFT);   
//		    layoutContainer_420.setLayout(frmlytSch);
//		    layoutContainer_420.setBorders(false); 
//		    
//		    //월 콤보박스
//		    calcSevePsnBlggMnth = new ComboBox<BaseModel>(); 
//		    calcSevePsnBlggMnth.setName("calcSevePsnBlggYr");
//		    calcSevePsnBlggMnth.setForceSelection(true);
//		    calcSevePsnBlggMnth.setMinChars(1);
//		    calcSevePsnBlggMnth.setDisplayField("commCdNm");
//		    calcSevePsnBlggMnth.setValueField("commCd");
//		    calcSevePsnBlggMnth.setTriggerAction(TriggerAction.ALL);
//		    calcSevePsnBlggMnth.setEmptyText("--정산월선택--");
//		    calcSevePsnBlggMnth.setSelectOnFocus(true); 
//		    calcSevePsnBlggMnth.setReadOnly(false);
//		    calcSevePsnBlggMnth.setEnabled(true); 
//		    calcSevePsnBlggMnth.setStore(lsCalcSevePsnBlggMnth);  
//		    calcSevePsnBlggMnth.setHideLabel(true);
//		    layoutContainer_420.add(calcSevePsnBlggMnth,new FormData("100%") ); 
//		    
//		    layoutContainer_310.add(layoutContainer_410, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
//		    layoutContainer_310.add(layoutContainer_420, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		    
//		    layoutContainer_3.add(layoutContainer_310, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    
//		    LayoutContainer layoutContainer_500 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(60); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_500.setLayout(frmlytSch);
//            layoutContainer_500.setBorders(false);
//		    LabelField lblfldNewLabelfield_1 = new LabelField("영수일자 : ");
//		    lblfldNewLabelfield_1.setStyleAttribute("paddingTop", "4px");
//		    layoutContainer_500.add(lblfldNewLabelfield_1,new FormData("100%"));    //2
//		    layoutContainer_3.add(layoutContainer_500,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));    //2
//		    
//		    LayoutContainer layoutContainer_501 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.LEFT); 
//            layoutContainer_501.setLayout(frmlytSch);
//            layoutContainer_501.setBorders(false);
//		
//            //2.영수일자 
//            reipDt = new DateField(); 
//            reipDt.setHideLabel(true);
//            new DateFieldMask(reipDt, "9999.99.99"); 
//            reipDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//            reipDt.setName("reipDt"); 
//		    layoutContainer_501.add(reipDt,new FormData("100%"));     //15 
//		    layoutContainer_3.add(layoutContainer_501,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));     //15 
//		    
//		    layoutContainerItem01.add(layoutContainer_3);
		    /************/
		    LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		    layoutContainer_1_1.setBorders(true);
		    LabelField labelfld_1_1 = new LabelField("");
		    labelfld_1_1.setStyleAttribute( "text-align", "center");
		    labelfld_1_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_1_1.add(labelfld_1_1, new FormData("100%")); 
		    labelfld_1_1.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		    layoutContainer_1_2.setBorders(true);
		    LabelField labelfld_1_2 = new LabelField("중 간 지 급 등");
		    labelfld_1_2.setStyleAttribute( "text-align", "center");
		    labelfld_1_2.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_1_2.add(labelfld_1_2, new FormData("100%")); 
		    labelfld_1_2.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_1_3 = new LayoutContainer();
		    layoutContainer_1_3.setBorders(true);
		    LabelField labelfld_1_3 = new LabelField("최 종");
		    labelfld_1_3.setStyleAttribute( "text-align", "center");
		    labelfld_1_3.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_1_3.add(labelfld_1_3, new FormData("100%")); 
		    labelfld_1_3.setBorders(false);
		    
		    LayoutContainer layoutContainer_1_4 = new LayoutContainer();
		    layoutContainer_1_4.setBorders(true);
		    LabelField labelfld_1_4 = new LabelField("정 산");
		    labelfld_1_4.setStyleAttribute( "text-align", "center");
		    labelfld_1_4.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_1_4.add(labelfld_1_4, new FormData("100%")); 
		    labelfld_1_4.setBorders(false);
		    
		    layoutContainer_1.add(layoutContainer_1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header
		    layoutContainer_1.add(layoutContainer_1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중간지급등
		    layoutContainer_1.add(layoutContainer_1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//최종
		    layoutContainer_1.add(layoutContainer_1_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정산
		    
		    
		    
		    LayoutContainer layoutContainer_2 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		    layoutContainer_2_1.setBorders(true);
		    
		    LabelField labelfld_2_1= new LabelField("근 무 처 명");
			   
		    labelfld_2_1.setStyleAttribute("padding-top", "5px");
		    labelfld_2_1.setStyleAttribute( "text-align", "center");
		    labelfld_2_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_2_1.add(labelfld_2_1, new FlowData(0));
		    labelfld_2_1.setBorders(false);
		    
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
 		                                
		    		layoutContainer_2_1.removeStyleName("x-border");
 		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
		    		layoutContainer_2_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_2_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    
		    
		    final LayoutContainer layoutContainer_2_2 = new LayoutContainer();
		    FormLayout formLayout_2_2 = new FormLayout();
		    formLayout_2_2.setLabelWidth(0);
		    layoutContainer_2_2.setLayout(formLayout_2_2);
		    layoutContainer_2_2.setBorders(true);
		    
		    Button btnEndPaeWorkNm = new Button();  
		    btnEndPaeWorkNm.setIcon(MSFMainApp.ICONS.search()); 
		    btnEndPaeWorkNm.addListener(Events.Select, new Listener<ButtonEvent>() {
		        public void handleEvent(ButtonEvent e) {
		            //data에 값넣기 
		       	 //fnPopupBass0300("I001"); 
		        }
		    });
		    
            /** column 중_근무처명 : ctrPaeWorkNm */
            ctrPaeWorkNm = new TextFieldWithButton<String>(btnEndPaeWorkNm); 
//            ctrPaeWorkNm.setWidth("160px");
            layoutContainer_2_2.add(ctrPaeWorkNm, new FormData("100%"));
		    ctrPaeWorkNm.setHideLabel(true); 
		    //setStyleAttribute("backgroung-image", "none");
		   // ctrPaeWorkNm.setStyleAttribute("backgroundColor", "green");  

            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_2_2.removeStyleName("x-border");
 		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
		    		layoutContainer_2_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_2_2.setHeight("25px");
		    		}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/  
		    
		    
		    final LayoutContainer layoutContainer_2_3 = new LayoutContainer();
		    FormLayout formLayout_2_3 = new FormLayout();
		    formLayout_2_3.setLabelWidth(0);
		    layoutContainer_2_3.setLayout(formLayout_2_3);
		    layoutContainer_2_3.setBorders(true);
		    
		    btnEndPaeWorkNm = new Button();  
		    btnEndPaeWorkNm.setIcon(MSFMainApp.ICONS.search()); 
		    btnEndPaeWorkNm.addListener(Events.Select, new Listener<ButtonEvent>() {
		        public void handleEvent(ButtonEvent e) {
		            //data에 값넣기 
		       	 //fnPopupBass0300("I001"); 
		        }
		    });
		    
            /** column 종_근무처명 : endPaeWorkNm */
            endPaeWorkNm = new TextFieldWithButton<String>(btnEndPaeWorkNm);
//            endPaeWorkNm.setWidth("160px");
            layoutContainer_2_3.add(endPaeWorkNm, new FormData("100%"));
		    endPaeWorkNm.setHideLabel(true);
		    //txtfldNewTextfield_5.setLabelSeparator(""); 
		   // txtfldNewTextfield_5.setFieldLabel("");
		    
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {

		    		layoutContainer_2_3.removeStyleName("x-border");
						// layoutContainer_509.setStyleName("x-border-u-top",true);
		    		layoutContainer_2_3.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_2_3.setHeight("25px");
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		   
		    
		    final LayoutContainer layoutContainer_2_4 = new LayoutContainer();
		    FormLayout formLayout_2_4 = new FormLayout();
		    formLayout_2_4.setLabelWidth(0);
		    layoutContainer_2_4.setLayout(formLayout_2_4);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_2_4.addListener(Events.Render, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {
            		layoutContainer_2_4.removeStyleName("x-border");
 		                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
            		layoutContainer_2_4.setStyleName("x-border-u-bottom",true);
            		layoutContainer_2_4.setHeight("25px");  
            	}
            });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    layoutContainer_2_4.setBorders(true);
		    
		    tmepTxtFld_2_4 = new TextField<String>();
		    tmepTxtFld_2_4.setReadOnly(true);
		    tmepTxtFld_2_4.setEnabled(false);
//		    tempTextField.setWidth("165px");
		    layoutContainer_2_4.add(tmepTxtFld_2_4, new FormData("100%"));
		    tmepTxtFld_2_4.setHideLabel(false);
		    tmepTxtFld_2_4.setLabelSeparator("");
		    

		    
		    
		    layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_근무처명	
		    layoutContainer_2.add(layoutContainer_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_근무처명
		    layoutContainer_2.add(layoutContainer_2_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_근무처명
		    layoutContainer_2.add(layoutContainer_2_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_근무처명
		    
		    
		    LayoutContainer layoutContainer_3 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_3_1 = new LayoutContainer();
//		    layoutContainer_3_1.setBorders(true);
		    
		    LabelField labelfld_3_1 = new LabelField("등록번호/퇴직사유"); 
		    labelfld_3_1.setStyleAttribute("padding-top", "5px");
		    labelfld_3_1.setStyleAttribute( "text-align", "center");
		    labelfld_3_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_3_1.add(labelfld_3_1, new FormData("100%"));
//		    labelfld_3_1.setBorders(true);
		    
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_3_1.removeStyleName("x-border");
		    		layoutContainer_3_1.setStyleName("x-border-u-right", true);
 		                	// layoutContainer_523.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_3_1.setHeight("25px");  
		    	}
		    });
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
             ***********************************************************************************************************/
		    
		    LayoutContainer layoutContainer_3_2 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_3_2_1 = new LayoutContainer();
		    
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_3_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_3_2_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_3_2_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_3_2_1.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
            ctrBusoprRgstnNum = new MSFTextField();
//            ctrBusoprRgstnNum.setWidth("80px");
            ctrBusoprRgstnNum.setReadOnly(true);
            layoutContainer_3_2_1.add(ctrBusoprRgstnNum, new FormData("100%"));
		    ctrBusoprRgstnNum.setHideLabel(true);
		    layoutContainer_3_2.add(layoutContainer_3_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    final LayoutContainer layoutContainer_3_2_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_3_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_3_2_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_3_2_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_3_2_2.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    /** column 중간퇴직사유 : ctrRetryReasNm */
            ctrRetryReasNm = new MSFTextField();
//            ctrRetryReasNm.setWidth("80px");
            ctrRetryReasNm.setReadOnly(true);
            layoutContainer_3_2_2.add(ctrRetryReasNm, new FormData("100%")); 
		    ctrRetryReasNm.setHideLabel(true);
		   // txtfldNewTextfield_7.setBorders(false);
		   // txtfldNewTextfield_7.setLabelSeparator(""); 
		  //  txtfldNewTextfield_7.setFieldLabel(""); 
		    layoutContainer_3_2.add(layoutContainer_3_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    
		    LayoutContainer layoutContainer_3_3 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_3_3_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_3_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {
            		layoutContainer_3_3_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
            		layoutContainer_3_3_1.setStyleName("x-border-u-bottom",true);
            		layoutContainer_3_3_1.setHeight("25px"); 
 		                        
            	}
            });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    /** column 종_사업자등록번호 : endBusoprRgstnNum */
            endBusoprRgstnNum = new MSFTextField();
//            endBusoprRgstnNum.setWidth("80px");
            endBusoprRgstnNum.setReadOnly(true);
            layoutContainer_3_3_1.add(endBusoprRgstnNum, new FormData("100%"));
		    endBusoprRgstnNum.setHideLabel(true); 
		    layoutContainer_3_3.add(layoutContainer_3_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    final LayoutContainer layoutContainer_3_3_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_3_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {
            		layoutContainer_3_3_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
            		layoutContainer_3_3_2.setStyleName("x-border-u-bottom",true);
            		layoutContainer_3_3_2.setHeight("25px"); 
            		}
            });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    /** column 퇴직사유코드 : retryReasCd */
            retryReasCd = new MSFComboBox<BaseModel>(); 
            retryReasCd.setName("retryReasCd");
            retryReasCd.setForceSelection(true);
            retryReasCd.setMinChars(1);
            retryReasCd.setDisplayField("commCdNm");
            retryReasCd.setValueField("commCd");
            retryReasCd.setTriggerAction(TriggerAction.ALL);
            retryReasCd.setEmptyText("--퇴직사유--");
            retryReasCd.setSelectOnFocus(true); 
            retryReasCd.setReadOnly(false);
            retryReasCd.setEnabled(true); 
            retryReasCd.setStore(lsRetryReasCd);   
            retryReasCd.setWidth("80px");
            layoutContainer_3_3_2.add(retryReasCd, new FormData("100%"));
		    retryReasCd.setHideLabel(true); 
		    layoutContainer_3_3.add(layoutContainer_3_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    final LayoutContainer layoutContainer_3_4 = new LayoutContainer();
		    FormLayout formLayout_4_3 = new FormLayout();
		    formLayout_4_3.setLabelWidth(0);
		    layoutContainer_3_4.setLayout(formLayout_4_3);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_3_4.addListener(Events.Render, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {
            		layoutContainer_3_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
            		layoutContainer_3_4.setStyleName("x-border-u-bottom",true);
            		layoutContainer_3_4.setHeight("25px");  
            	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tmepTxtFld_3_4 = new MSFTextField();
		    tmepTxtFld_3_4.setReadOnly(true);
		    tmepTxtFld_3_4.setEnabled(false);
//		    txtfldNewTextfield_10.setWidth("165px");
		    tmepTxtFld_3_4.setHideLabel(true);  
		    layoutContainer_3_4.add(tmepTxtFld_3_4, new FormData("100%"));
		    
		    
		    layoutContainer_3.add(layoutContainer_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_등록번호,퇴직사유	
		    layoutContainer_3.add(layoutContainer_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_등록번호,퇴직사유
		    layoutContainer_3.add(layoutContainer_3_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_등록번호,퇴직사유
		    layoutContainer_3.add(layoutContainer_3_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_등록번호,퇴직사유
		    
		    
		    
		    LayoutContainer layoutContainer_4 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_4_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_4_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_4_1.removeStyleName("x-border");
 		                   // layoutContainer_516.setStyleName("x-border-u-right",true);
 		                	 layoutContainer_4_1.setStyleName("x-border-u-bottom", true);
 		                	layoutContainer_4_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_4_1 = new LabelField("기 산 일/입 사 일");
		   // lblfldNewLabelfield_8.setHeight(22);
		    labelfld_4_1.setStyleAttribute("padding-top", "5px");
		    labelfld_4_1.setStyleAttribute( "text-align", "center");
		    labelfld_4_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_4_1.add(labelfld_4_1, new FormData("100%"));
//		    labelfld_4_1.setBorders(true);		    
		    
		    
		    LayoutContainer layoutContainer_4_2 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_4_2_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_4_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_4_2_1.removeStyleName("x-border");
		    		layoutContainer_4_2_1.setStyleName("x-border-u-right", true);
 		                	// layoutContainer_523.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_4_2_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_기산일자 : ctrRkfcdDt */
            ctrRkfcdDt = new MSFTextField();
            new TextFieldMask<String>(ctrRkfcdDt, "9999.99.99");  
            ctrRkfcdDt.setName("ctrRkfcdDt");
            ctrRkfcdDt.setReadOnly(true); 
//            ctrRkfcdDt.setWidth("80px");
            layoutContainer_4_2_1.add(ctrRkfcdDt, new FormData("100%"));
		    ctrRkfcdDt.setHideLabel(true);
		    layoutContainer_4_2.add(layoutContainer_4_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    
		    final LayoutContainer layoutContainer_4_2_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_4_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_4_2_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
            		layoutContainer_4_2_2.setStyleName("x-border-u-bottom",true);
            		layoutContainer_4_2_2.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_입사일자 : ctrIcncDt */
            ctrIcncDt = new MSFTextField();
//            ctrIcncDt.setWidth("80px");
            new TextFieldMask<String>(ctrIcncDt, "9999.99.99"); 
            ctrIcncDt.setName("ctrIcncDt");
            ctrIcncDt.setReadOnly(true); 
            ctrIcncDt.setHideLabel(true);
            layoutContainer_4_2_2.add(ctrIcncDt, new FormData("100%"));
		    layoutContainer_4_2.add(layoutContainer_4_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    LayoutContainer layoutContainer_4_3 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_4_3_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_4_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_4_3_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_4_3_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_4_3_1.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_기산일자 : endRkfcdDt */
            endRkfcdDt = new MSFTextField();
            new TextFieldMask<String>(endRkfcdDt, "9999.99.99"); 
            endRkfcdDt.setName("endRkfcdDt");
            endRkfcdDt.setReadOnly(true);
//            endRkfcdDt.setWidth("80px");
            endRkfcdDt.setHideLabel(true); 
            layoutContainer_4_3_1.add(endRkfcdDt, new FormData("100%"));
		    layoutContainer_4_3.add(layoutContainer_4_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    final LayoutContainer layoutContainer_4_3_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_4_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_4_3_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_4_3_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_4_3_2.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_입사일자 : endIcncDt */
            endIcncDt = new MSFTextField(); 
            new TextFieldMask<String>(endIcncDt, "9999.99.99"); 
            endIcncDt.setName("endIcncDt");
            endIcncDt.setReadOnly(true);
//            endIcncDt.setWidth("80px");
            endIcncDt.setHideLabel(true); 
            layoutContainer_4_3_2.add(endIcncDt,  new FormData("100%"));
		    layoutContainer_4_3.add(layoutContainer_4_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    final LayoutContainer layoutContainer_4_4 = new LayoutContainer();
		    FormLayout formLayout_4_4 = new FormLayout();
		    formLayout_4_4.setLabelWidth(0);
		    layoutContainer_4_4.setLayout(formLayout_4_4);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_4_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_4_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_4_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_4_4.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tmepTxtFld_4_4 = new MSFTextField();
		    tmepTxtFld_4_4.setReadOnly(true);
		    tmepTxtFld_4_4.setEnabled(false);
//		    txtfldNewTextfield_15.setWidth("165px");
		    tmepTxtFld_4_4.setHideLabel(true);  
		    layoutContainer_4_4.add(tmepTxtFld_4_4, new FormData("100%"));
		    
		    layoutContainer_4.add(layoutContainer_4_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_기산일, 입사일
		    layoutContainer_4.add(layoutContainer_4_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_기산일, 입사일
		    layoutContainer_4.add(layoutContainer_4_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_기산일, 입사일
		    layoutContainer_4.add(layoutContainer_4_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_기산일, 입사일
		    
		    
		    LayoutContainer layoutContainer_5 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_5_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_5_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_5_1.removeStyleName("x-border");
 		                   // layoutContainer_522.setStyleName("x-border-u-right",true);
		    		layoutContainer_5_1.setStyleName("x-border-u-bottom", true);
		    		layoutContainer_5_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_5_1 = new LabelField("퇴 사 일/지 급 일");
		  //  lblfldNewLabelfield_9.setHeight(22);
		    labelfld_5_1.setStyleAttribute("padding-top", "5px");
		    labelfld_5_1.setStyleAttribute( "text-align", "center");
		    labelfld_5_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_5_1.add(labelfld_5_1, new FormData("100%"));
		   // lblfldNewLabelfield_9.setHeight("20");
		    
		    
		    LayoutContainer layoutContainer_5_2 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_5_2_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_5_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_5_2_1.removeStyleName("x-border");
		    		layoutContainer_5_2_1.setStyleName("x-border-u-right", true);
 		                	// layoutContainer_523.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_5_2_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_퇴사일자 : ctrRsgtnDt */
            ctrRsgtnDt = new MSFTextField();
            new TextFieldMask<String>(ctrRsgtnDt, "9999.99.99"); 
            ctrRsgtnDt.setName("ctrRsgtnDt");
            ctrRsgtnDt.setReadOnly(true);
//            ctrRsgtnDt.setWidth("80px");
            ctrRsgtnDt.setHideLabel(true);
            layoutContainer_5_2_1.add(ctrRsgtnDt, new FormData("100%"));
		    layoutContainer_5_2.add(layoutContainer_5_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	//header_퇴사일, 지급일
		    
		    final LayoutContainer layoutContainer_5_2_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_5_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_5_2_2.removeStyleName("x-border");
		    		layoutContainer_5_2_2.setStyleName("x-border-u-right", true);
 		                	// layoutContainer_523.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_5_2_2.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	         ***********************************************************************************************************/
		    /** column 중_지급일자 : ctrPymtDt */
		    ctrPymtDt = new MSFTextField();
		    new TextFieldMask<String>(ctrPymtDt, "9999.99.99"); 
		    ctrPymtDt.setName("ctrPymtDt");
		    ctrPymtDt.setReadOnly(true);
//		    ctrPymtDt.setWidth("80px");
		    ctrPymtDt.setHideLabel(true);
		    layoutContainer_5_2_2.add(ctrPymtDt, new FormData("100%")); 
		    layoutContainer_5_2.add(layoutContainer_5_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	//header_퇴사일, 지급일
		    
		    
		    LayoutContainer layoutContainer_5_3 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_5_3_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_5_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_5_3_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_5_3_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_5_3_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_퇴사일자 : endRsgtnDt */
            endRsgtnDt = new MSFTextField();
		    new TextFieldMask<String>(endRsgtnDt, "9999.99.99"); 
		    endRsgtnDt.setName("endRsgtnDt");
		    endRsgtnDt.setReadOnly(true);
//		    endRsgtnDt.setWidth("80px");
		    endRsgtnDt.setHideLabel(true); 
		    layoutContainer_5_3_1.add(endRsgtnDt, new FormData("100%")); 
		    layoutContainer_5_3.add(layoutContainer_5_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	//header_퇴사일, 지급일
		    
		    final LayoutContainer layoutContainer_5_3_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_5_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_5_3_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_5_3_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_5_3_2.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_지급일자 : endPymtDt */
            endPymtDt = new MSFTextField();
		    new TextFieldMask<String>(endPymtDt, "9999.99.99"); 
		    endPymtDt.setName("endPymtDt");
		    endPymtDt.setReadOnly(true);
//		    endPymtDt.setWidth("80px");
		    endPymtDt.setHideLabel(true); 
		    layoutContainer_5_3_2.add(endPymtDt, new FormData("100%"));
		    layoutContainer_5_3.add(layoutContainer_5_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	//header_퇴사일, 지급일
		   
		    final LayoutContainer layoutContainer_5_4 = new LayoutContainer();
		    FormLayout formLayout_5_4 = new FormLayout();
		    formLayout_5_4.setLabelWidth(0);
		    layoutContainer_5_4.setLayout(formLayout_5_4);
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_5_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_5_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_5_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_5_4.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tmepTxtFld_5_4 = new MSFTextField();
		    tmepTxtFld_5_4.setReadOnly(true);
		    tmepTxtFld_5_4.setEnabled(false);
//		    temlLabelfld_5_4.setWidth("165px");
		    tmepTxtFld_5_4.setHideLabel(true);  
		    layoutContainer_5_4.add(tmepTxtFld_5_4, new FormData("100%"));
		    
		    layoutContainer_5.add(layoutContainer_5_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_퇴사일, 지급일
		    layoutContainer_5.add(layoutContainer_5_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_퇴사일, 지급일
		    layoutContainer_5.add(layoutContainer_5_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_퇴사일, 지급일
		    layoutContainer_5.add(layoutContainer_5_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_퇴사일, 지급일
		    
		    
		    
		    LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_6_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_6_1.addListener(Events.Render, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {
            		layoutContainer_6_1.removeStyleName("x-border");
 		                    // layoutContainer_528.setStyleName("x-border-u-right",true);
            		layoutContainer_6_1.setStyleName("x-border-u-bottom",true);
            		layoutContainer_6_1.setHeight("25px");  
            	}
            });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_6_1 = new LabelField("근 속 월 수");
		   // lblfldNewLabelfield_10.setStyleAttribute("paddingTop", "4px");
		    //lblfldNewLabelfield_10.setHeight(24);
		    labelfld_6_1.setStyleAttribute("padding-top", "5px");
		    labelfld_6_1.setStyleAttribute( "text-align", "center");
		    labelfld_6_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_6_1.add(labelfld_6_1, new FormData("100%"));
		   // lblfldNewLabelfield_10.setHeight("20");
		    labelfld_6_1.setBorders(false);    
		    
		    
		    
		    
		    final LayoutContainer layoutContainer_6_2 = new LayoutContainer();
		    FormLayout formLayout_6_2 = new FormLayout();
		    formLayout_6_2.setLabelWidth(0);
		    layoutContainer_6_2.setLayout(formLayout_6_2);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_6_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_6_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_6_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_6_2.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_근속월수 : ctrLogSvcMnthIcm */
		    ctrLogSvcMnthIcm = new MSFNumberField();
		    ctrLogSvcMnthIcm.setAllowDecimals(true); 
		    ctrLogSvcMnthIcm.setPropertyEditorType(Long.class); 
		    ctrLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		    ctrLogSvcMnthIcm.setWidth("160px");
		    ctrLogSvcMnthIcm.setHideLabel(true);
		    ctrLogSvcMnthIcm.setReadOnly(true);
		    layoutContainer_6_2.add(ctrLogSvcMnthIcm, new FormData("100%"));
		    
		    final LayoutContainer layoutContainer_6_3 = new LayoutContainer();
		    FormLayout formLayout_6_3 = new FormLayout();
		    formLayout_6_3.setLabelWidth(0);
		    layoutContainer_6_3.setLayout(formLayout_6_3);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_6_3.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_6_3.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_6_3.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_6_3.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_근속월수 : endLogSvcMnthIcm */
            endLogSvcMnthIcm = new MSFNumberField();
            endLogSvcMnthIcm.setAllowDecimals(true); 
            endLogSvcMnthIcm.setPropertyEditorType(Long.class); 
            endLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//            endLogSvcMnthIcm.setWidth("160px");
            endLogSvcMnthIcm.setHideLabel(true);
            endLogSvcMnthIcm.setReadOnly(true);
            layoutContainer_6_3.add(endLogSvcMnthIcm, new FormData("100%")); 
		    
		    final LayoutContainer layoutContainer_6_4 = new LayoutContainer();
		    FormLayout formLayout_6_4 = new FormLayout();
		    formLayout_6_4.setLabelWidth(0);
		    layoutContainer_6_4.setLayout(formLayout_6_4);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_6_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_6_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_6_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_6_4.setHeight("25px"); ;  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tempNumFld_6_4 = new MSFNumberField();
		    tempNumFld_6_4.setReadOnly(true);
		    tempNumFld_6_4.setEnabled(false);
//		    nmbrfldNewNumberfield_2.setWidth("165px");
		    tempNumFld_6_4.setHideLabel(true); 
		    layoutContainer_6_4.add(tempNumFld_6_4, new FormData("100%"));
		    
		    layoutContainer_6.add(layoutContainer_6_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_근속월수
		    layoutContainer_6.add(layoutContainer_6_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_근속월수
		    layoutContainer_6.add(layoutContainer_6_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_근속월수
		    layoutContainer_6.add(layoutContainer_6_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_근속월수
		    
		    
		    LayoutContainer layoutContainer_7 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_7_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_1.removeStyleName("x-border");
 		                    // layoutContainer_5311.setStyleName("x-border-u-right",true);
		    		layoutContainer_7_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_7_1 = new LabelField("제 외 월 수");
		   // lblfldNewLabelfield_11.setHeight(24);
		    labelfld_7_1.setStyleAttribute("padding-top", "5px");
		    labelfld_7_1.setStyleAttribute( "text-align", "center");
		    labelfld_7_1.setStyleAttribute("background-color", "#dfe8f6"); 
		   // lblfldNewLabelfield_11.setStyleAttribute("paddingTop", "4px");
		    layoutContainer_7_1.add(labelfld_7_1, new FormData("100%"));
		   // lblfldNewLabelfield_11.setHeight("20");
		    labelfld_7_1.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_7_2 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_7_2_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_2_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_7_2_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_2_1.setHeight("25px");    
 		                        
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
            ctrEepnMnth12Bfr = new MSFNumberField();
            ctrEepnMnth12Bfr.setAllowDecimals(true); 
            ctrEepnMnth12Bfr.setPropertyEditorType(Long.class); 
            ctrEepnMnth12Bfr.setFormat(NumberFormat.getDecimalFormat());
//            ctrEepnMnth12Bfr.setWidth("80px");
            ctrEepnMnth12Bfr.setHideLabel(true);
            ctrEepnMnth12Bfr.setReadOnly(true);
            layoutContainer_7_2_1.add(ctrEepnMnth12Bfr, new FormData("100%"));
            layoutContainer_7_2.add(layoutContainer_7_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    final LayoutContainer layoutContainer_7_2_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_2_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_7_2_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_2_2.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
            ctrEepnMnth13Aft = new MSFNumberField();
            ctrEepnMnth13Aft.setAllowDecimals(true); 
            ctrEepnMnth13Aft.setPropertyEditorType(Long.class); 
            ctrEepnMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            ctrEepnMnth13Aft.setWidth("80px");
            ctrEepnMnth13Aft.setHideLabel(true);
            ctrEepnMnth13Aft.setReadOnly(true);
            layoutContainer_7_2_2.add(ctrEepnMnth13Aft, new FlowData(0));
		    layoutContainer_7_2.add(layoutContainer_7_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    LayoutContainer layoutContainer_7_3 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_7_3_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_3_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_7_3_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_3_1.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
            endEepnMnth12Bfr = new MSFNumberField();
            endEepnMnth12Bfr.setAllowDecimals(true); 
            endEepnMnth12Bfr.setPropertyEditorType(Long.class); 
            endEepnMnth12Bfr.setFormat(NumberFormat.getDecimalFormat()); 
//            endEepnMnth12Bfr.setWidth("80px");
            endEepnMnth12Bfr.setHideLabel(true);
            layoutContainer_7_3_1.add(endEepnMnth12Bfr, new FlowData(0)); 
		    layoutContainer_7_3.add(layoutContainer_7_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    final LayoutContainer layoutContainer_7_3_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_3_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_7_3_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_3_2.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
            endEepnMnth13Aft = new MSFNumberField();
            endEepnMnth13Aft.setAllowDecimals(true); 
            endEepnMnth13Aft.setPropertyEditorType(Long.class); 
            endEepnMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            endEepnMnth13Aft.setWidth("80px");
            endEepnMnth13Aft.setHideLabel(true);
            layoutContainer_7_3_2.add(endEepnMnth13Aft, new FormData("100%")); 
		    layoutContainer_7_3.add(layoutContainer_7_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    
		    final LayoutContainer layoutContainer_7_4 = new LayoutContainer(new ColumnLayout());
	        /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_7_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_4.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    
		    
		    final LayoutContainer layoutContainer_7_4_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_4_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_7_4_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_7_4_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_7_4_1.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tempNumFld_7_4_1 = new MSFNumberField();
		    tempNumFld_7_4_1.setReadOnly(true);
		    tempNumFld_7_4_1.setEnabled(false);
//		    nmbrfldNewNumberfield_7.setWidth("82px");
		    tempNumFld_7_4_1.setHideLabel(true);
		    layoutContainer_7_4_1.add(tempNumFld_7_4_1, new FormData("100%")); 
		    layoutContainer_7_4.add(layoutContainer_7_4_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    
		    final LayoutContainer layoutContainer_7_4_2 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_7_4_2.addListener(Events.Render, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {
            		layoutContainer_7_4_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
            		layoutContainer_7_4_2.setStyleName("x-border-u-bottom",true);
            		layoutContainer_7_4_2.setHeight("25px"); 
            	}
            });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tempNumFld_7_4_2 = new MSFNumberField();
		    tempNumFld_7_4_2.setReadOnly(true);
		    tempNumFld_7_4_2.setEnabled(false);
//		    temlLabelfld_7_4_2.setWidth("82px");
		    tempNumFld_7_4_2.setHideLabel(true);
		    layoutContainer_7_4_2.add(tempNumFld_7_4_2, new FormData("100%")); 
		    layoutContainer_7_4.add(layoutContainer_7_4_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    
		    layoutContainer_7.add(layoutContainer_7_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_제외월수
		    layoutContainer_7.add(layoutContainer_7_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_제외월수 2012이전, 제외월수 3013 이후
		    layoutContainer_7.add(layoutContainer_7_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_제외월수 2012이전, 제외월수 3013 이후
		    layoutContainer_7.add(layoutContainer_7_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_제외월수 2012이전, 제외월수 3013 이후
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_8_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_1.removeStyleName("x-border");
 		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
		    		layoutContainer_8_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_8_1= new LabelField("가 산 월 수");
		   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
		  //  lblfldNewLabelfield_12.setHeight(24);
		    labelfld_8_1.setStyleAttribute("padding-top", "5px");
		    labelfld_8_1.setStyleAttribute( "text-align", "center");
		    labelfld_8_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_8_1.add(labelfld_8_1, new FormData("100%"));
		   // lblfldNewLabelfield_12.setHeight("20");
		    labelfld_8_1.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_8_2 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_8_2_1 = new LayoutContainer();
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_2_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_2_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_2_1.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
            ctrAddMnth12Bfr = new MSFNumberField();
            ctrAddMnth12Bfr.setAllowDecimals(true); 
            ctrAddMnth12Bfr.setPropertyEditorType(Long.class); 
            ctrAddMnth12Bfr.setFormat(NumberFormat.getDecimalFormat());
//            ctrAddMnth12Bfr.setWidth("80px");
            ctrAddMnth12Bfr.setHideLabel(true);
            ctrAddMnth12Bfr.setReadOnly(true);
            layoutContainer_8_2_1.add(ctrAddMnth12Bfr, new FormData("100%"));
		    layoutContainer_8_2.add(layoutContainer_8_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    final LayoutContainer layoutContainer_8_2_2 = new LayoutContainer();
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_2_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_2_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_2_2.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
            ctrAddMnth13Aft = new MSFNumberField();
            ctrAddMnth13Aft.setAllowDecimals(true); 
            ctrAddMnth13Aft.setPropertyEditorType(Long.class); 
            ctrAddMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            ctrAddMnth13Aft.setWidth("80px");
            ctrAddMnth13Aft.setHideLabel(true);
            ctrAddMnth13Aft.setReadOnly(true);
            layoutContainer_8_2_2.add(ctrAddMnth13Aft, new FormData("100%"));
		    layoutContainer_8_2.add(layoutContainer_8_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    
		    LayoutContainer layoutContainer_8_3 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_8_3_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_3_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_3_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_3_1.setHeight("25px");    
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
            endAddMnth12Bfr = new MSFNumberField();
            endAddMnth12Bfr.setAllowDecimals(true); 
            endAddMnth12Bfr.setPropertyEditorType(Long.class); 
            endAddMnth12Bfr.setFormat(NumberFormat.getDecimalFormat());
//            endAddMnth12Bfr.setWidth("80px");
            endAddMnth12Bfr.setHideLabel(true);
            layoutContainer_8_3_1.add(endAddMnth12Bfr, new FormData("100%"));
		    layoutContainer_8_3.add(layoutContainer_8_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    final LayoutContainer layoutContainer_8_3_2 = new LayoutContainer();
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_3_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_3_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_3_2.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_가산월수_2013이후 : endAddMnth13Aft */
            endAddMnth13Aft = new MSFNumberField();
            endAddMnth13Aft.setAllowDecimals(true); 
            endAddMnth13Aft.setPropertyEditorType(Long.class); 
            endAddMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            endAddMnth13Aft.setWidth("80px");
            endAddMnth13Aft.setHideLabel(true);
            layoutContainer_8_3_2.add(endAddMnth13Aft, new FormData("100%"));
		    layoutContainer_8_3.add(layoutContainer_8_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    final LayoutContainer layoutContainer_8_4 = new LayoutContainer(new ColumnLayout());
	        /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_4.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    
		    final LayoutContainer layoutContainer_8_4_1 = new LayoutContainer();
		     /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_4_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_4_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_4_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_4_1.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tempNumFld_8_4_1 = new MSFNumberField();
		    tempNumFld_8_4_1.setReadOnly(true);
		    tempNumFld_8_4_1.setEnabled(false);
//		    nmbrfldNewNumberfield_13.setWidth("82px");
		    tempNumFld_8_4_1.setHideLabel(true);
		    layoutContainer_8_4_1.add(tempNumFld_8_4_1, new FlowData(0));
		    layoutContainer_8_4.add(layoutContainer_8_4_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		    
		    final LayoutContainer layoutContainer_8_4_2 = new LayoutContainer();
		    /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_8_4_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_8_4_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_8_4_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_8_4_2.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    tempNumFld_8_4_2 = new MSFNumberField();
		    tempNumFld_8_4_2.setReadOnly(true);
		    tempNumFld_8_4_2.setEnabled(false);
//		    temlLabelfld_8_4_2.setWidth("82px");
		    tempNumFld_8_4_2.setHideLabel(true);
		    layoutContainer_8_4_2.add(tempNumFld_8_4_2, new FormData("100%"));
		    layoutContainer_8_4.add(layoutContainer_8_4_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    
		    layoutContainer_8.add(layoutContainer_8_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_가산월수
		    layoutContainer_8.add(layoutContainer_8_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_가산월수 2012이전, 가산월수 3013 이후
		    layoutContainer_8.add(layoutContainer_8_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_가산월수 2012이전, 가산월수 3013 이후
		    layoutContainer_8.add(layoutContainer_8_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_가산월수 2012이전, 가산월수 3013 이후
		    
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_9_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_9_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_9_1.removeStyleName("x-border");
 		                    // layoutContainer_545.setStyleName("x-border-u-right",true);
		    		layoutContainer_9_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_9_1.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_9_1 = new LabelField("과 세 퇴 직 급 여");
		   // lblfldNewLabelfield_13.setStyleAttribute("paddingTop", "4px"); 
		  //  lblfldNewLabelfield_13.setHeight(24);
		    labelfld_9_1.setStyleAttribute("padding-top", "5px");
		    labelfld_9_1.setStyleAttribute("padding-top", "5px");
		    labelfld_9_1.setStyleAttribute( "text-align", "center");
		    labelfld_9_1.setStyleAttribute("background-color", "#dfe8f6"); 
		    layoutContainer_9_1.add(labelfld_9_1, new FormData("100%"));
		  //  lblfldNewLabelfield_13.setHeight("22");
		    labelfld_9_1.setBorders(false);
		    
		    
		    final LayoutContainer layoutContainer_9_2 = new LayoutContainer();
		    FormLayout formLayout_9_2 = new FormLayout();
		    formLayout_9_2.setLabelWidth(0);
		    layoutContainer_9_2.setLayout(formLayout_9_2);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_9_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_9_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_9_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_9_2.setHeight("25px"); 
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
            ctrTxtnTgtRetryPayQnty = new MSFNumberField();
            ctrTxtnTgtRetryPayQnty.setAllowDecimals(true); 
            ctrTxtnTgtRetryPayQnty.setPropertyEditorType(Long.class); 
            ctrTxtnTgtRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            ctrTxtnTgtRetryPayQnty.setWidth("160px");
            ctrTxtnTgtRetryPayQnty.setHideLabel(true);
            ctrTxtnTgtRetryPayQnty.setReadOnly(true);
            layoutContainer_9_2.add(ctrTxtnTgtRetryPayQnty, new FormData("100%"));
		    
		    final LayoutContainer layoutContainer_9_3 = new LayoutContainer();
		    FormLayout formLayout_9_3 = new FormLayout();
		    formLayout_9_3.setLabelWidth(0);
		    layoutContainer_9_3.setLayout(formLayout_9_3);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_9_3.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_9_3.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_9_3.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_9_3.setHeight("25px");  
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
            endTxtnTgtRetryPayQnty = new MSFNumberField();
            endTxtnTgtRetryPayQnty.setAllowDecimals(true); 
            endTxtnTgtRetryPayQnty.setPropertyEditorType(Long.class); 
            endTxtnTgtRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            endTxtnTgtRetryPayQnty.setWidth("160px");
            endTxtnTgtRetryPayQnty.setHideLabel(true);
            endTxtnTgtRetryPayQnty.setReadOnly(true);
            layoutContainer_9_3.add(endTxtnTgtRetryPayQnty, new FormData("100%"));
		    
		    final LayoutContainer layoutContainer_9_4 = new LayoutContainer();
		    FormLayout formLayout_9_4 = new FormLayout();
		    formLayout_9_4.setLabelWidth(0);
		    layoutContainer_9_4.setLayout(formLayout_9_4);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_9_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_9_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_9_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_9_4.setHeight("25px");    
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
            clutTxtnTgtRetryPayQnty = new MSFNumberField();
            clutTxtnTgtRetryPayQnty.setAllowDecimals(true); 
            clutTxtnTgtRetryPayQnty.setPropertyEditorType(Long.class); 
            clutTxtnTgtRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            clutTxtnTgtRetryPayQnty.setWidth("165px");
            clutTxtnTgtRetryPayQnty.setHideLabel(true);
            clutTxtnTgtRetryPayQnty.setReadOnly(true);
            layoutContainer_9_4.add(clutTxtnTgtRetryPayQnty, new FlowData(0));
		    
		    layoutContainer_9.add(layoutContainer_9_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_과세퇴직급여
		    layoutContainer_9.add(layoutContainer_9_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_과세퇴직급여
		    layoutContainer_9.add(layoutContainer_9_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_과세퇴직급여
		    layoutContainer_9.add(layoutContainer_9_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_과세퇴직급여
		    
		    
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer(new ColumnLayout());
		    
		    final LayoutContainer layoutContainer_10_1 = new LayoutContainer();
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_10_1.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_10_1.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_10_1.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_10_1.setHeight("25px");   
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
		    LabelField labelfld_10_1 = new LabelField("비 과 세 퇴직급여");
		   // lblfldNewLabelfield_14.setStyleAttribute("paddingTop", "4px"); 
		    //lblfldNewLabelfield_14.setHeight(24);
		    labelfld_10_1.setStyleAttribute("padding-top", "5px");
		    labelfld_10_1.setStyleAttribute( "text-align", "center");
		    labelfld_10_1.setStyleAttribute("background-color", "#dfe8f6");
		    layoutContainer_10_1.add(labelfld_10_1, new FormData("100%"));
		   // lblfldNewLabelfield_14.setHeight("22");
		    labelfld_10_1.setBorders(false);
		    
		    final LayoutContainer layoutContainer_10_2 = new LayoutContainer();
		    FormLayout formLayout_10_2 = new FormLayout();
		    formLayout_10_2.setLabelWidth(0);
		    layoutContainer_10_2.setLayout(formLayout_10_2);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_10_2.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_10_2.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_10_2.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_10_2.setHeight("25px");    
		    	}
		    });
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
            ctrFreeDtyRetryPayQnty = new MSFNumberField();
            ctrFreeDtyRetryPayQnty.setAllowDecimals(true); 
            ctrFreeDtyRetryPayQnty.setPropertyEditorType(Long.class); 
            ctrFreeDtyRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            ctrFreeDtyRetryPayQnty.setWidth("160px");
            ctrFreeDtyRetryPayQnty.setHideLabel(true);
            ctrFreeDtyRetryPayQnty.setReadOnly(true);
            layoutContainer_10_2.add(ctrFreeDtyRetryPayQnty, new FormData("100%"));
		    
		    final LayoutContainer layoutContainer_10_3 = new LayoutContainer();
		    FormLayout formLayout_10_3 = new FormLayout();
		    formLayout_10_3.setLabelWidth(0);
		    layoutContainer_10_3.setLayout(formLayout_10_3);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_10_3.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_10_3.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_10_3.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_10_3.setHeight("25px");

					}
				});
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
            endFreeDtyRetryPayQnty = new MSFNumberField();
            endFreeDtyRetryPayQnty.setAllowDecimals(true); 
            endFreeDtyRetryPayQnty.setPropertyEditorType(Long.class); 
            endFreeDtyRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            endFreeDtyRetryPayQnty.setWidth("160px");
            endFreeDtyRetryPayQnty.setHideLabel(true);
            endFreeDtyRetryPayQnty.setReadOnly(true);
            layoutContainer_10_3.add(endFreeDtyRetryPayQnty, new FormData("100%"));
		    
		    final LayoutContainer layoutContainer_10_4 = new LayoutContainer();
		    FormLayout formLayout_10_4 = new FormLayout();
		    formLayout_10_4.setLabelWidth(0);
		    layoutContainer_10_4.setLayout(formLayout_10_4);
            /**********************************************************************************************************
             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
             ***********************************************************************************************************/
		    layoutContainer_10_4.addListener(Events.Render, new Listener<BaseEvent>() {
		    	public void handleEvent(BaseEvent be) {
		    		layoutContainer_10_4.removeStyleName("x-border");
	                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
		    		layoutContainer_10_4.setStyleName("x-border-u-bottom",true);
		    		layoutContainer_10_4.setHeight("25px");  
					}
				});
 		    /**********************************************************************************************************
              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	         ***********************************************************************************************************/
            /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
            clutFreeDtyRetryPayQnty = new MSFNumberField();
            clutFreeDtyRetryPayQnty.setAllowDecimals(true); 
            clutFreeDtyRetryPayQnty.setPropertyEditorType(Long.class); 
            clutFreeDtyRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            clutFreeDtyRetryPayQnty.setWidth("165px");
            clutFreeDtyRetryPayQnty.setHideLabel(true);
            clutFreeDtyRetryPayQnty.setReadOnly(true);
            layoutContainer_10_4.add(clutFreeDtyRetryPayQnty, new FormData("100%"));
		    
		    
		    layoutContainer_10.add(layoutContainer_10_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//header_비과세퇴직급여
		    layoutContainer_10.add(layoutContainer_10_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//중_비과세퇴직급여
		    layoutContainer_10.add(layoutContainer_10_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//종_비과세퇴직급여
		    layoutContainer_10.add(layoutContainer_10_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//정_비과세퇴직급여
		    
		    
		    
		    layoutContainerItem01.add(layoutContainer_1);
		    layoutContainerItem01.add(layoutContainer_2);
		    layoutContainerItem01.add(layoutContainer_3);
		    layoutContainerItem01.add(layoutContainer_4);
		    layoutContainerItem01.add(layoutContainer_5);
		    layoutContainerItem01.add(layoutContainer_6);
		    layoutContainerItem01.add(layoutContainer_7);
		    layoutContainerItem01.add(layoutContainer_8);
		    layoutContainerItem01.add(layoutContainer_9);
		    layoutContainerItem01.add(layoutContainer_10);
		    
//		    LayoutContainer layoutContainer_2 = new LayoutContainer();
//		    layoutContainer_2.setLayout(new FitLayout()); 
//		    layoutContainer_2.setHeight(250);
//		    layoutContainer_2.setBorders(false);
//	 
//		    //4개의 걸럼
//		    
//		    LayoutContainer hBoxTopFrm = new LayoutContainer();  
//	        HBoxLayout hbLayout = new HBoxLayout();  
//	        hbLayout.setPadding(new Padding(0));  
//	        hbLayout.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
//	        hBoxTopFrm.setLayout(hbLayout);  
//	  
//	        //1
//	        LayoutContainer layoutContainer_1502 = new LayoutContainer();
//	        FormLayout frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_1502.setLayout(frmlytSch);
//            layoutContainer_1502.setBorders(true); 
//		    layoutContainer_1502.setWidth(145);
//		    
//		    //2
//	        LayoutContainer layoutContainer_2502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_2502.setLayout(frmlytSch);
//            layoutContainer_2502.setBorders(true); 
//            layoutContainer_2502.setWidth(165);
//		    
//		    //3
//	        LayoutContainer layoutContainer_3502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_3502.setLayout(frmlytSch);
//            layoutContainer_3502.setBorders(true); 
//            layoutContainer_3502.setWidth(165);
//		    
//		    //4
//	        LayoutContainer layoutContainer_4502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_4502.setLayout(frmlytSch);
//            layoutContainer_4502.setBorders(true); 
//            layoutContainer_4502.setWidth(170);
//		    
//		    
//
//		    hBoxTopFrm.add(layoutContainer_1502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_2502, new HBoxLayoutData(new Margins(0, 1, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_3502, new HBoxLayoutData(new Margins(0, 1, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_4502, new HBoxLayoutData(new Margins(0)));  
//		    
// 
//		   final  LayoutContainer layoutContainer1_506 = new LayoutContainer(new FitLayout());  
//           // frmlytSch = new FormLayout();   
//          //  frmlytSch.setLabelWidth(0); 
//          //  frmlytSch.setLabelAlign(LabelAlign.LEFT); 
//          //  layoutContainer1_506.setLayout(frmlytSch);
//            layoutContainer1_506.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
// 		     layoutContainer1_506.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		                   
// 		                   //상단 타이틀부 
// 		                        layoutContainer1_506.removeStyleName("x-border");
// 		                   //	   layoutContainer1_506.setStyleName("x-border-u-top",true);
// 		                        layoutContainer1_506.setStyleName("x-border-u-bottom",true);
// 		                        layoutContainer1_506.setHeight("24px");
// 		                    
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/  
//		    LabelField lblfldNewLabelfield_2 = new LabelField(""); 
//		  //  lblfldNewLabelfield_2.setStyleAttribute("paddingTop", "4px");
//		    lblfldNewLabelfield_2.setStyleAttribute("background-color", "#dfe8f6"); 
//		    layoutContainer1_506.add(lblfldNewLabelfield_2, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer1_506);//,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)  
//		    lblfldNewLabelfield_2.setBorders(false); 
//		    
//          
//		    
//		    final   LayoutContainer layoutContainer_503 = new LayoutContainer(new FitLayout());
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_503.setLayout(frmlytSch);
//            layoutContainer_503.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_503.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		                     
// 		                        layoutContainer_503.removeStyleName("x-border");
// 		                   //	  layoutContainer_503.setStyleName("x-border-u-top",true);
// 		                        layoutContainer_503.setStyleName("x-border-u-bottom",true);
// 		                        layoutContainer_503.setHeight("24px");
// 		                          
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/  
//		    LabelField lblfldNewLabelfield_3 = new LabelField("중 간 지 급 등");
//		    lblfldNewLabelfield_3.setStyleAttribute( "text-align", "center");
//		    lblfldNewLabelfield_3.setStyleAttribute("background-color", "#dfe8f6"); 
//		    layoutContainer_503.add(lblfldNewLabelfield_3, new FormData("100%")); 
//		    layoutContainer_2502.add(layoutContainer_503 ); 
//		    lblfldNewLabelfield_3.setBorders(false);
//		    
//		    
//		    final   LayoutContainer layoutContainer_504 = new LayoutContainer(new FitLayout());
//          //  frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          //  layoutContainer_504.setLayout(frmlytSch);
//            layoutContainer_504.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_504.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		                    
// 		                        layoutContainer_504.removeStyleName("x-border");
// 		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
// 		                        layoutContainer_504.setStyleName("x-border-u-bottom",true);
// 		                        layoutContainer_504.setHeight("24px");
// 		                        
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/  
//		    LabelField lblfldNewLabelfield_4 = new LabelField("최  종");
//		    lblfldNewLabelfield_4.setStyleAttribute( "text-align", "center");
//		    lblfldNewLabelfield_4.setStyleAttribute("background-color", "#dfe8f6"); 
//		    layoutContainer_504.add(lblfldNewLabelfield_4, new FormData("100%")); 
//		    layoutContainer_3502.add(layoutContainer_504 ); 
//		    lblfldNewLabelfield_4.setBorders(false);
//		    
//		    
//		    final   LayoutContainer layoutContainer_505 = new LayoutContainer(new FitLayout());
//          //  frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//         //   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         //   layoutContainer_505.setLayout(frmlytSch);
//            layoutContainer_505.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_505.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		              
// 		                            layoutContainer_505.removeStyleName("x-border");
// 		                   //	  layoutContainer_505.setStyleName("x-border-u-top",true);
// 		                        layoutContainer_505.setStyleName("x-border-u-bottom",true);
// 		                        layoutContainer_505.setHeight("24px");  
// 		                  
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/  
//		    LabelField lblfldNewLabelfield_5 = new LabelField("정   산");
//		    lblfldNewLabelfield_5.setStyleAttribute("text-align", "center");
//		    lblfldNewLabelfield_5.setStyleAttribute("background-color", "#dfe8f6"); 
//		    layoutContainer_505.add(lblfldNewLabelfield_5, new FormData("100%"));
//		    layoutContainer_4502.add(layoutContainer_505); 
//		    lblfldNewLabelfield_5.setBorders(false); 
//		    
//		    //--------------------------------------------------------------------------
//		    
//		    
//		    final   LayoutContainer layoutContainer_506 = new LayoutContainer(new FlowLayout()); 
//		    layoutContainer_506.setStyleAttribute("background-color", "#dfe8f6"); 
//		   
//		   // FormLayout frmlytSch506 = new FormLayout();  
//		   // frmlytSch506.setLabelWidth(0); 
//		   // frmlytSch506.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_506.setLayout(frmlytSch506);
//            layoutContainer_506.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_506.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                            layoutContainer_506.removeStyleName("x-border");
// 		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
// 		                        layoutContainer_506.setStyleName("x-border-u-bottom",true);
// 		                        layoutContainer_506.setHeight("25px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_6 = new LabelField("근 무 처 명");
//		   
//		    lblfldNewLabelfield_6.setStyleAttribute("padding-top", "7px");
//		    lblfldNewLabelfield_6.setStyleAttribute("vertical-align", "middle"); 
//		   // lblfldNewLabelfield_6.setStyleAttribute("background-color", "#dfe8f6"); 
//		    layoutContainer_506.add(lblfldNewLabelfield_6, new FlowData(0));
//		    layoutContainer_1502.add(layoutContainer_506);//,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)  
//		    lblfldNewLabelfield_6.setBorders(false);
//		    
//		    
//		    Button btnCtrPaeWorkNm = new Button();  
//		    btnCtrPaeWorkNm.setIcon(MSFMainApp.ICONS.search()); 
//		    btnCtrPaeWorkNm.addListener(Events.Select, new Listener<ButtonEvent>() {
//		        public void handleEvent(ButtonEvent e) {
//		            //data에 값넣기 
//		       	 //fnPopupBass0300("I001"); 
//		        }
//		    });
//		    
//		    final   LayoutContainer layoutContainer_507 = new LayoutContainer(new FlowLayout()); 
//            //frmlytSch = new FormLayout();  
//             //frmlytSch.setLabelWidth(0); 
//            //frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            // layoutContainer_507.setLayout(frmlytSch);
//            layoutContainer_507.setBorders(true); 
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_507.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_507.removeStyleName("x-border");
// 		                   //	  layoutContainer_507.setStyleName("x-border-u-top",true);
// 		                	 layoutContainer_507.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_507.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_근무처명 : ctrPaeWorkNm */
//            ctrPaeWorkNm = new TextFieldWithButton<String>(btnCtrPaeWorkNm); 
//            ctrPaeWorkNm.setWidth("160px");
//		    layoutContainer_507.add(ctrPaeWorkNm, new FlowData(0));
//		    layoutContainer_2502.add(layoutContainer_507);
//		    ctrPaeWorkNm.setHideLabel(true); 
//		    //setStyleAttribute("backgroung-image", "none");
//		   // ctrPaeWorkNm.setStyleAttribute("backgroundColor", "green");  
//		   
//		    
//		    Button btnEndPaeWorkNm = new Button();  
//		    btnEndPaeWorkNm.setIcon(MSFMainApp.ICONS.search()); 
//		    btnEndPaeWorkNm.addListener(Events.Select, new Listener<ButtonEvent>() {
//		        public void handleEvent(ButtonEvent e) {
//		            //data에 값넣기 
//		       	 //fnPopupBass0300("I001"); 
//		        }
//		    });
//		    
//		    final LayoutContainer layoutContainer_508 = new LayoutContainer(new FlowLayout());  
//            layoutContainer_508.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_508.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_508.removeStyleName("x-border");
// 		                   //	  layoutContainer_508.setStyleName("x-border-u-top",true);
// 		                	 layoutContainer_508.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_508.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_근무처명 : endPaeWorkNm */
//            endPaeWorkNm = new TextFieldWithButton<String>(btnEndPaeWorkNm);
//            endPaeWorkNm.setWidth("160px");
//		    layoutContainer_508.add(endPaeWorkNm, new FlowData(0));
//		    layoutContainer_3502.add(layoutContainer_508 );
//		    endPaeWorkNm.setHideLabel(true);
//		    //txtfldNewTextfield_5.setLabelSeparator(""); 
//		   // txtfldNewTextfield_5.setFieldLabel("");
//		    
//		    
//		    final   LayoutContainer layoutContainer_509 = new LayoutContainer(new FlowLayout()); 
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_509.setLayout(frmlytSch);
//            layoutContainer_509.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_509.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_509.removeStyleName("x-border");
// 		                   //	  layoutContainer_509.setStyleName("x-border-u-top",true);
// 		                	 layoutContainer_509.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_509.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    TextField<String> txtfldNewTextfield_3 = new TextField<String>();
//		    txtfldNewTextfield_3.setReadOnly(true);
//		    txtfldNewTextfield_3.setEnabled(false);
//		    txtfldNewTextfield_3.setWidth("165px");
//		    layoutContainer_509.add(txtfldNewTextfield_3, new FlowData(0));
//		    layoutContainer_4502.add(layoutContainer_509); 
//		    txtfldNewTextfield_3.setHideLabel(true);
//	        
//		     
//		  //--------------------------------------------------------------------------
//		    
//		    final LayoutContainer layoutContainer_510 = new LayoutContainer(new FitLayout());
//		    layoutContainer_510.setStyleAttribute("background-color", "#dfe8f6"); 
//            //frmlytSch = new FormLayout();  
//            //frmlytSch.setLabelWidth(0); 
//            //frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            //layoutContainer_510.setLayout(frmlytSch);
//            layoutContainer_510.setBorders(true); 
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_510.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_510.removeStyleName("x-border");
// 		                   //	  layoutContainer_510.setStyleName("x-border-u-top",true);
// 		                	  layoutContainer_510.setStyleName("x-border-u-bottom",true);
// 		                	  layoutContainer_510.setHeight("25px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//           // layoutContainer_510.setStyleAttribute("border-top", "1px  solid #88BBE8"); 
// 
//		    LabelField lblfldNewLabelfield_7 = new LabelField("등록번호/퇴직사유"); 
//		    lblfldNewLabelfield_7.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_7.setStyleAttribute("vertical-align", "middle"); 
//		    //lblfldNewLabelfield_7.setStyleAttribute("paddingTop", "4px");
//		  //  lblfldNewLabelfield_7.setStyleAttribute("background-color", "#dfe8f6"); 
//		    layoutContainer_510.add(lblfldNewLabelfield_7, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_510 );
//		//    lblfldNewLabelfield_7.setHeight("22");
//		    lblfldNewLabelfield_7.setBorders(false);
//		    
//		    
//		    final LayoutContainer layoutContainer1_5 = new LayoutContainer();
//		    layoutContainer1_5.setLayout(new ColumnLayout());
//		    layoutContainer1_5.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer1_5.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer1_5.removeStyleName("x-border");
// 		                    // layoutContainer1_5.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer1_5.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer1_5.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		
//		    final LayoutContainer layoutContainer_511 = new LayoutContainer(new FlowLayout()); 
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//          //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          //  layoutContainer_511.setLayout(frmlytSch);
//            layoutContainer_511.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_511.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_511.removeStyleName("x-border");
// 		                	 layoutContainer_511.setStyleName("x-border-u-right",true);
// 		                	//layoutContainer_511.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_511.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
//            ctrBusoprRgstnNum = new MSFTextField();
//            ctrBusoprRgstnNum.setWidth("80px");
//            ctrBusoprRgstnNum.setReadOnly(true);
//		    layoutContainer_511.add(ctrBusoprRgstnNum, new FlowData(0));
//		    layoutContainer1_5.add(layoutContainer_511,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    ctrBusoprRgstnNum.setHideLabel(true);
//		   // txtfldNewTextfield_6.setBorders(false); 
//		  // txtfldNewTextfield_6.setLabelSeparator(""); 
//		   // txtfldNewTextfield_6.setFieldLabel("");
//		    
//		    final LayoutContainer layoutContainer_512 = new LayoutContainer(new FlowLayout()); 
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//          //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          //  layoutContainer_512.setLayout(frmlytSch);
//            layoutContainer_512.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_512.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	layoutContainer_512.removeStyleName("x-border");
// 		                   // layoutContainer_512.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_512.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_512.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중간퇴직사유 : ctrRetryReasNm */
//            ctrRetryReasNm = new MSFTextField();
//            ctrRetryReasNm.setWidth("80px");
//            ctrRetryReasNm.setReadOnly(true);
//		    layoutContainer_512.add(ctrRetryReasNm, new FlowData(0)); 
//		    layoutContainer1_5.add(layoutContainer_512,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    ctrRetryReasNm.setHideLabel(true);
//		   // txtfldNewTextfield_7.setBorders(false);
//		   // txtfldNewTextfield_7.setLabelSeparator(""); 
//		  //  txtfldNewTextfield_7.setFieldLabel(""); 
//		    layoutContainer_2502.add(layoutContainer1_5);
//		    
//		    final LayoutContainer layoutContainer2_5 = new LayoutContainer();
//		    layoutContainer2_5.setLayout(new ColumnLayout());
//		    layoutContainer2_5.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer2_5.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer2_5.removeStyleName("x-border");
// 		                    // layoutContainer2_5.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer2_5.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer2_5.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_513 = new LayoutContainer(new FlowLayout()); 
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_513.setLayout(frmlytSch);
//            layoutContainer_513.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_513.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_513.removeStyleName("x-border");
// 		                    layoutContainer_513.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_513.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_513.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_사업자등록번호 : endBusoprRgstnNum */
//            endBusoprRgstnNum = new MSFTextField();
//            endBusoprRgstnNum.setWidth("80px");
//            endBusoprRgstnNum.setReadOnly(true);
//		    layoutContainer_513.add(endBusoprRgstnNum, new FlowData(0));
//		    layoutContainer2_5.add(layoutContainer_513,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    endBusoprRgstnNum.setHideLabel(true); 
//		    
//		    
//		    final LayoutContainer layoutContainer_514 = new LayoutContainer(new FlowLayout()); 
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_514.setLayout(frmlytSch);
//            layoutContainer_514.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_514.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_514.removeStyleName("x-border");
// 		                   // layoutContainer_514.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_514.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_514.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 퇴직사유코드 : retryReasCd */
//            retryReasCd = new MSFComboBox<BaseModel>(); 
//            retryReasCd.setName("retryReasCd");
//            retryReasCd.setForceSelection(true);
//            retryReasCd.setMinChars(1);
//            retryReasCd.setDisplayField("commCdNm");
//            retryReasCd.setValueField("commCd");
//            retryReasCd.setTriggerAction(TriggerAction.ALL);
//            retryReasCd.setEmptyText("--퇴직사유--");
//            retryReasCd.setSelectOnFocus(true); 
//            retryReasCd.setReadOnly(false);
//            retryReasCd.setEnabled(true); 
//            retryReasCd.setStore(lsRetryReasCd);   
//            retryReasCd.setWidth("80px");
//		    layoutContainer_514.add(retryReasCd, new FlowData(0));
//		    layoutContainer2_5.add(layoutContainer_514,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    retryReasCd.setHideLabel(true);  
//		    
//		    layoutContainer_3502.add(layoutContainer2_5);
//		    
//		    
//		    final LayoutContainer layoutContainer_515 = new LayoutContainer(new FlowLayout()); 
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_515.setLayout(frmlytSch);
//            layoutContainer_515.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_515.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_515.removeStyleName("x-border");
// 		                   // layoutContainer_515.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_515.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_515.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    MSFTextField txtfldNewTextfield_10 = new MSFTextField();
//		    txtfldNewTextfield_10.setReadOnly(true);
//		    txtfldNewTextfield_10.setEnabled(false);
//		    txtfldNewTextfield_10.setWidth("165px");
//		    txtfldNewTextfield_10.setHideLabel(true);  
//		    layoutContainer_515.add(txtfldNewTextfield_10, new FlowData(0));
//		    layoutContainer_4502.add(layoutContainer_515); 
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final  LayoutContainer layoutContainer_516 = new LayoutContainer(new FitLayout());
//		    layoutContainer_516.setStyleAttribute("background-color", "#dfe8f6"); 
//          //  frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//          //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          //  layoutContainer_516.setLayout(frmlytSch);
//            layoutContainer_516.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_516.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_516.removeStyleName("x-border");
// 		                   // layoutContainer_516.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_516.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_516.setHeight("25px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_8 = new LabelField("기 산 일/입 사 일");
//		   // lblfldNewLabelfield_8.setHeight(22);
//		    lblfldNewLabelfield_8.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_8.setStyleAttribute("vertical-align", "middle");  
//		    layoutContainer_516.add(lblfldNewLabelfield_8, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_516); 
//		    lblfldNewLabelfield_8.setBorders(false);
//		    
//		    final LayoutContainer layoutContainer1_7 = new LayoutContainer();
//		    layoutContainer1_7.setLayout(new ColumnLayout());   
//		    layoutContainer1_7.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer1_7.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer1_7.removeStyleName("x-border");
// 		                    // layoutContainer1_7.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer1_7.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer1_7.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_517 = new LayoutContainer(new FlowLayout());
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_517.setLayout(frmlytSch);
//            layoutContainer_517.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_517.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_517.removeStyleName("x-border");
// 		                	 layoutContainer_517.setStyleName("x-border-u-right",true);
// 		                	//layoutContainer_517.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_517.setHeight("24px");  
// 		                         
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_기산일자 : ctrRkfcdDt */
//            ctrRkfcdDt = new MSFTextField();
//            new TextFieldMask<String>(ctrRkfcdDt, "9999.99.99");  
//            ctrRkfcdDt.setName("ctrRkfcdDt");
//            ctrRkfcdDt.setReadOnly(true); 
//            ctrRkfcdDt.setWidth("80px");
//		    layoutContainer_517.add(ctrRkfcdDt, new FlowData(0));
//		    layoutContainer1_7.add(layoutContainer_517,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    ctrRkfcdDt.setHideLabel(true);
//		    
//		    
//		   final LayoutContainer layoutContainer_518 = new LayoutContainer(new FlowLayout());
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_518.setLayout(frmlytSch);
//            layoutContainer_518.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_518.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_518.removeStyleName("x-border");
// 		                   // layoutContainer_518.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_518.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_518.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_입사일자 : ctrIcncDt */
//            ctrIcncDt = new MSFTextField();
//            ctrIcncDt.setWidth("80px");
//            new TextFieldMask<String>(ctrIcncDt, "9999.99.99"); 
//            ctrIcncDt.setName("ctrIcncDt");
//            ctrIcncDt.setReadOnly(true); 
//            ctrIcncDt.setHideLabel(true);
//		    layoutContainer_518.add(ctrIcncDt, new FlowData(0));
//		    layoutContainer1_7.add(layoutContainer_518,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_2502.add(layoutContainer1_7);
//		    
//		    final LayoutContainer layoutContainer2_7 = new LayoutContainer();
//		    layoutContainer2_7.setLayout(new ColumnLayout());   
//		    layoutContainer2_7.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer2_7.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer2_7.removeStyleName("x-border");
// 		                    // layoutContainer2_7.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer2_7.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer2_7.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_519 = new LayoutContainer(new FlowLayout());
//            //frmlytSch = new FormLayout();  
//            //frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            //layoutContainer_519.setLayout(frmlytSch);
//            layoutContainer_519.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_519.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	layoutContainer_519.removeStyleName("x-border");
// 		                	layoutContainer_519.setStyleName("x-border-u-right",true);
// 		                //	layoutContainer_519.setStyleName("x-border-u-bottom",true);
// 		                //	layoutContainer_519.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_기산일자 : endRkfcdDt */
//            endRkfcdDt = new MSFTextField();
//            new TextFieldMask<String>(endRkfcdDt, "9999.99.99"); 
//            endRkfcdDt.setName("endRkfcdDt");
//            endRkfcdDt.setReadOnly(true);
//            endRkfcdDt.setWidth("80px");
//            endRkfcdDt.setHideLabel(true); 
//		    layoutContainer_519.add(endRkfcdDt, new FlowData(0));
//		    layoutContainer2_7.add(layoutContainer_519,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    
//		    final LayoutContainer layoutContainer_520 = new LayoutContainer(new FlowLayout());
//            //frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//            //frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_520.setLayout(frmlytSch);
//            layoutContainer_520.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_520.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_520.removeStyleName("x-border");
// 		                   // layoutContainer_520.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_520.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_520.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_입사일자 : endIcncDt */
//            endIcncDt = new MSFTextField(); 
//            new TextFieldMask<String>(endIcncDt, "9999.99.99"); 
//            endIcncDt.setName("endIcncDt");
//            endIcncDt.setReadOnly(true);
//            endIcncDt.setWidth("80px");
//            endIcncDt.setHideLabel(true); 
//		    layoutContainer_520.add(endIcncDt, new FlowData(0));
//		    layoutContainer2_7.add(layoutContainer_520,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//
//		    
//		    layoutContainer_3502.add(layoutContainer2_7);
//		    
//		    final LayoutContainer layoutContainer_521 = new LayoutContainer(new FlowLayout());
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//            //frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_521.setLayout(frmlytSch);
//            layoutContainer_521.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_521.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_521.removeStyleName("x-border");
// 		                   // layoutContainer_521.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_521.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_521.setHeight("24px");  
// 		                        
// 		                       
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    MSFTextField txtfldNewTextfield_15 = new MSFTextField();
//		    txtfldNewTextfield_15.setReadOnly(true);
//		    txtfldNewTextfield_15.setEnabled(false);
//		    txtfldNewTextfield_15.setWidth("165px");
//		    txtfldNewTextfield_15.setHideLabel(true);  
//		    layoutContainer_521.add(txtfldNewTextfield_15, new FlowData(0));
//		  
//		    layoutContainer_4502.add(layoutContainer_521);
//		     
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final   LayoutContainer layoutContainer_522 = new LayoutContainer(new FitLayout());
//		    layoutContainer_522.setStyleAttribute("background-color", "#dfe8f6"); 
//            //  frmlytSch = new FormLayout();  
//            //  frmlytSch.setLabelWidth(0); 
//            //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            //  layoutContainer_522.setLayout(frmlytSch);
//            layoutContainer_522.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_522.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_522.removeStyleName("x-border");
// 		                   // layoutContainer_522.setStyleName("x-border-u-right",true);
// 		                	  layoutContainer_522.setStyleName("x-border-u-bottom",true);
// 		                	  layoutContainer_522.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_9 = new LabelField("퇴 사 일/지 급 일");
//		  //  lblfldNewLabelfield_9.setHeight(22);
//		    lblfldNewLabelfield_9.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_9.setStyleAttribute("vertical-align", "middle"); 
//		    // lblfldNewLabelfield_9.setStyleAttribute("paddingTop", "4px"); 
//		    layoutContainer_522.add(lblfldNewLabelfield_9, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_522);
//		   // lblfldNewLabelfield_9.setHeight("20");
//		    lblfldNewLabelfield_9.setBorders(false); 
//		    
//		    
//		    
//		    final LayoutContainer layoutContainer3_7 = new LayoutContainer();
//		    layoutContainer3_7.setLayout(new ColumnLayout());   
//		    layoutContainer3_7.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer3_7.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer3_7.removeStyleName("x-border");
// 		                    // layoutContainer3_7.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer3_7.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer3_7.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_523 = new LayoutContainer(new FlowLayout()); 
//            layoutContainer_523.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_523.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_523.removeStyleName("x-border");
// 		                     layoutContainer_523.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_523.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_523.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_퇴사일자 : ctrRsgtnDt */
//            ctrRsgtnDt = new MSFTextField();
//            new TextFieldMask<String>(ctrRsgtnDt, "9999.99.99"); 
//            ctrRsgtnDt.setName("ctrRsgtnDt");
//            ctrRsgtnDt.setReadOnly(true);
//            ctrRsgtnDt.setWidth("80px");
//            ctrRsgtnDt.setHideLabel(true);
//		    layoutContainer_523.add(ctrRsgtnDt, new FlowData(0));
//		    layoutContainer3_7.add(layoutContainer_523,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//	  
//		    
//		    final LayoutContainer layoutContainer_524 = new LayoutContainer(new FlowLayout());
//            layoutContainer_524.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_524.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_524.removeStyleName("x-border");
// 		                   // layoutContainer_524.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_524.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_524.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_지급일자 : ctrPymtDt */
//            ctrPymtDt = new MSFTextField();
//		    new TextFieldMask<String>(ctrPymtDt, "9999.99.99"); 
//		    ctrPymtDt.setName("ctrPymtDt");
//		    ctrPymtDt.setReadOnly(true);
//		    ctrPymtDt.setWidth("80px");
//		    ctrPymtDt.setHideLabel(true);
//		    layoutContainer_524.add(ctrPymtDt, new FlowData(0)); 
//		    layoutContainer3_7.add(layoutContainer_524,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_2502.add(layoutContainer3_7);
//		    
//		    final LayoutContainer layoutContainer4_7 = new LayoutContainer();
//		    layoutContainer4_7.setLayout(new ColumnLayout());   
//		    layoutContainer4_7.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer4_7.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer4_7.removeStyleName("x-border");
// 		                    // layoutContainer4_7.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer4_7.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer4_7.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_525 = new LayoutContainer(new FlowLayout());
//            layoutContainer_525.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_525.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_525.removeStyleName("x-border");
// 		                     layoutContainer_525.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_525.setStyleName("x-border-u-bottom",true);
// 		                //	layoutContainer_525.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_퇴사일자 : endRsgtnDt */
//            endRsgtnDt = new MSFTextField();
//		    new TextFieldMask<String>(endRsgtnDt, "9999.99.99"); 
//		    endRsgtnDt.setName("endRsgtnDt");
//		    endRsgtnDt.setReadOnly(true);
//		    endRsgtnDt.setWidth("80px");
//		    endRsgtnDt.setHideLabel(true); 
//		    layoutContainer_525.add(endRsgtnDt, new FlowData(0)); 
//		    layoutContainer4_7.add(layoutContainer_525,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		   
//		    
//		    
//		    final LayoutContainer layoutContainer_526 = new LayoutContainer(new FlowLayout()); 
//            layoutContainer_526.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_526.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_526.removeStyleName("x-border");
// 		                   //layoutContainer_526.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_526.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_526.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_지급일자 : endPymtDt */
//            endPymtDt = new MSFTextField();
//		    new TextFieldMask<String>(endPymtDt, "9999.99.99"); 
//		    endPymtDt.setName("endPymtDt");
//		    endPymtDt.setReadOnly(true);
//		    endPymtDt.setWidth("80px");
//		    endPymtDt.setHideLabel(true); 
//		    layoutContainer_526.add(endPymtDt, new FlowData(0));
//		    layoutContainer4_7.add(layoutContainer_526,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		   
//		    layoutContainer_3502.add(layoutContainer4_7);
//		    
//		   final LayoutContainer layoutContainer_527 = new LayoutContainer(new FlowLayout());
//            layoutContainer_527.setBorders(true);
//           /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_527.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_527.removeStyleName("x-border");
// 		                    // layoutContainer_527.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_527.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_527.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    MSFTextField txtfldNewTextfield_20 = new MSFTextField();
//		    txtfldNewTextfield_20.setReadOnly(true);
//		    txtfldNewTextfield_20.setEnabled(false);
//		    txtfldNewTextfield_20.setWidth("165px");
//		    txtfldNewTextfield_20.setHideLabel(true);  
//		    layoutContainer_527.add(txtfldNewTextfield_20, new FlowData(0));
//		    layoutContainer_4502.add(layoutContainer_527);
//		     
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final LayoutContainer layoutContainer_528 = new LayoutContainer(new FitLayout());
//		    layoutContainer_528.setStyleAttribute("background-color", "#dfe8f6"); 
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_528.setLayout(frmlytSch);
//            layoutContainer_528.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_528.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_528.removeStyleName("x-border");
// 		                    // layoutContainer_528.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_528.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_528.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_10 = new LabelField("근 속 월 수");
//		   // lblfldNewLabelfield_10.setStyleAttribute("paddingTop", "4px");
//		    //lblfldNewLabelfield_10.setHeight(24);
//		    lblfldNewLabelfield_10.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_10.setStyleAttribute("vertical-align", "middle"); 
//		    layoutContainer_528.add(lblfldNewLabelfield_10, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_528);
//		   // lblfldNewLabelfield_10.setHeight("20");
//		    lblfldNewLabelfield_10.setBorders(false);
//		    
//		    
//		    final LayoutContainer layoutContainer_529 = new LayoutContainer(new FlowLayout());
//            layoutContainer_529.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_529.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_529.removeStyleName("x-border");
// 		                    // layoutContainer_529.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_529.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_529.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_근속월수 : ctrLogSvcMnthIcm */
//		    ctrLogSvcMnthIcm = new MSFNumberField();
//		    ctrLogSvcMnthIcm.setAllowDecimals(true); 
//		    ctrLogSvcMnthIcm.setPropertyEditorType(Long.class); 
//		    ctrLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		    ctrLogSvcMnthIcm.setWidth("160px");
//		    ctrLogSvcMnthIcm.setHideLabel(true);
//		    ctrLogSvcMnthIcm.setReadOnly(true);
//		    layoutContainer_529.add(ctrLogSvcMnthIcm, new FlowData(0));
//		    layoutContainer_2502.add(layoutContainer_529);
//		    
//		    final  LayoutContainer layoutContainer_530 = new LayoutContainer(new FlowLayout());
//            layoutContainer_530.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_530.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_530.removeStyleName("x-border");
// 		                    // layoutContainer_530.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_530.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_530.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_근속월수 : endLogSvcMnthIcm */
//            endLogSvcMnthIcm = new MSFNumberField();
//            endLogSvcMnthIcm.setAllowDecimals(true); 
//            endLogSvcMnthIcm.setPropertyEditorType(Long.class); 
//            endLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//            endLogSvcMnthIcm.setWidth("160px");
//            endLogSvcMnthIcm.setHideLabel(true);
//            endLogSvcMnthIcm.setReadOnly(true);
//		    layoutContainer_530.add(endLogSvcMnthIcm, new FlowData(0)); 
//		    layoutContainer_3502.add(layoutContainer_530);
//		    
//		    final LayoutContainer layoutContainer_531 = new LayoutContainer(new FlowLayout());
//            layoutContainer_531.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_531.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_531.removeStyleName("x-border");
// 		                    // layoutContainer_531.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_531.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_531.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            MSFNumberField nmbrfldNewNumberfield_2 = new MSFNumberField();
//		    nmbrfldNewNumberfield_2.setReadOnly(true);
//		    nmbrfldNewNumberfield_2.setEnabled(false);
//		    nmbrfldNewNumberfield_2.setWidth("165px");
//		    nmbrfldNewNumberfield_2.setHideLabel(true); 
//		    layoutContainer_531.add(nmbrfldNewNumberfield_2, new FlowData(0));
//		    layoutContainer_4502.add(layoutContainer_531);
//		    
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final LayoutContainer layoutContainer_5311 = new LayoutContainer(new FitLayout());
//		    layoutContainer_5311.setStyleAttribute("background-color", "#dfe8f6"); 
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_5311.setLayout(frmlytSch);
//            layoutContainer_5311.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_5311.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		                
// 		                	  layoutContainer_5311.removeStyleName("x-border");
// 		                    // layoutContainer_5311.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_5311.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_5311.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_11 = new LabelField("제 외 월 수");
//		   // lblfldNewLabelfield_11.setHeight(24);
//		    lblfldNewLabelfield_11.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_11.setStyleAttribute("vertical-align", "middle"); 
//		   // lblfldNewLabelfield_11.setStyleAttribute("paddingTop", "4px");
//		    layoutContainer_5311.add(lblfldNewLabelfield_11, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_5311);
//		   // lblfldNewLabelfield_11.setHeight("20");
//		    lblfldNewLabelfield_11.setBorders(false);
//		    
//		    final LayoutContainer layoutContainer1_9 = new LayoutContainer();
//		    layoutContainer1_9.setLayout(new ColumnLayout());
//		    layoutContainer1_9.setBorders(true);
//		    
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer1_9.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer1_9.removeStyleName("x-border");
// 		                    // layoutContainer1_9.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer1_9.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer1_9.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_532 = new LayoutContainer(new FlowLayout());
//            layoutContainer_532.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_532.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_532.removeStyleName("x-border");
// 		                	 layoutContainer_532.setStyleName("x-border-u-right",true);
// 		                	//layoutContainer_532.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_532.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
//            ctrEepnMnth12Bfr = new MSFNumberField();
//            ctrEepnMnth12Bfr.setAllowDecimals(true); 
//            ctrEepnMnth12Bfr.setPropertyEditorType(Long.class); 
//            ctrEepnMnth12Bfr.setFormat(NumberFormat.getDecimalFormat());
//            ctrEepnMnth12Bfr.setWidth("80px");
//            ctrEepnMnth12Bfr.setHideLabel(true);
//            ctrEepnMnth12Bfr.setReadOnly(true);
//		    layoutContainer_532.add(ctrEepnMnth12Bfr, new FlowData(0));
//		    layoutContainer1_9.add(layoutContainer_532,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    
//		    final LayoutContainer layoutContainer_533 = new LayoutContainer(new FlowLayout());
//            layoutContainer_533.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_533.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_533.removeStyleName("x-border");
// 		                    // layoutContainer_533.setStyleName("x-border-u-right",true);
// 		                	 //layoutContainer_533.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_533.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
//            ctrEepnMnth13Aft = new MSFNumberField();
//            ctrEepnMnth13Aft.setAllowDecimals(true); 
//            ctrEepnMnth13Aft.setPropertyEditorType(Long.class); 
//            ctrEepnMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            ctrEepnMnth13Aft.setWidth("80px");
//            ctrEepnMnth13Aft.setHideLabel(true);
//            ctrEepnMnth13Aft.setReadOnly(true);
//		    layoutContainer_533.add(ctrEepnMnth13Aft, new FlowData(0));
//		    layoutContainer1_9.add(layoutContainer_533 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_2502.add(layoutContainer1_9);
//		    
//		    final LayoutContainer layoutContainer2_9 = new LayoutContainer();
//		    layoutContainer2_9.setLayout(new ColumnLayout());
//		    layoutContainer2_9.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer2_9.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer2_9.removeStyleName("x-border");
// 		                    // layoutContainer2_9.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer2_9.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer2_9.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		  
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    final LayoutContainer layoutContainer_534 = new LayoutContainer(new FlowLayout());
//            layoutContainer_534.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_534.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_534.removeStyleName("x-border");
// 		                	 layoutContainer_534.setStyleName("x-border-u-right",true);
// 		                	//layoutContainer_534.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_534.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
//            endEepnMnth12Bfr = new MSFNumberField();
//            endEepnMnth12Bfr.setAllowDecimals(true); 
//            endEepnMnth12Bfr.setPropertyEditorType(Long.class); 
//            endEepnMnth12Bfr.setFormat(NumberFormat.getDecimalFormat()); 
//            endEepnMnth12Bfr.setWidth("80px");
//            endEepnMnth12Bfr.setHideLabel(true);
//		    layoutContainer_534.add(endEepnMnth12Bfr, new FlowData(0)); 
//		    layoutContainer2_9.add(layoutContainer_534,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5) );
//		    
//		    final LayoutContainer layoutContainer_535 = new LayoutContainer(new FlowLayout());
//            layoutContainer_535.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_535.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_535.removeStyleName("x-border");
// 		                    // layoutContainer_535.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_535.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_535.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
//            endEepnMnth13Aft = new MSFNumberField();
//            endEepnMnth13Aft.setAllowDecimals(true); 
//            endEepnMnth13Aft.setPropertyEditorType(Long.class); 
//            endEepnMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            endEepnMnth13Aft.setWidth("80px");
//            endEepnMnth13Aft.setHideLabel(true);
//		    layoutContainer_535.add(endEepnMnth13Aft, new FlowData(0)); 
//		    layoutContainer2_9.add(layoutContainer_535 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_3502.add(layoutContainer2_9);
//		    
//		   final LayoutContainer layoutContainer3_9 = new LayoutContainer();
//		    layoutContainer3_9.setLayout(new ColumnLayout());
//		    layoutContainer3_9.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer3_9.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer3_9.removeStyleName("x-border");
// 		                    // layoutContainer3_9.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer3_9.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer3_9.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_536 = new LayoutContainer(new FlowLayout());
//            layoutContainer_536.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_536.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_536.removeStyleName("x-border");
// 		                	 layoutContainer_536.setStyleName("x-border-u-right",true);
// 		                	//layoutContainer_536.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_536.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            MSFNumberField nmbrfldNewNumberfield_7 = new MSFNumberField();
//            nmbrfldNewNumberfield_7.setReadOnly(true);
//            nmbrfldNewNumberfield_7.setEnabled(false);
//		    nmbrfldNewNumberfield_7.setWidth("82px");
//		    nmbrfldNewNumberfield_7.setHideLabel(true);
//		    layoutContainer_536.add(nmbrfldNewNumberfield_7, new FlowData(0)); 
//		    layoutContainer3_9.add(layoutContainer_536 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    
//		    final LayoutContainer layoutContainer_537 = new LayoutContainer(new FlowLayout());
//            layoutContainer_537.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_537.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_537.removeStyleName("x-border");
// 		                    // layoutContainer_537.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_537.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_537.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            MSFNumberField nmbrfldNewNumberfield_8 = new MSFNumberField();
//            nmbrfldNewNumberfield_8.setReadOnly(true);
//            nmbrfldNewNumberfield_8.setEnabled(false);
//		    nmbrfldNewNumberfield_8.setWidth("82px");
//		    nmbrfldNewNumberfield_8.setHideLabel(true);
//		    layoutContainer_537.add(nmbrfldNewNumberfield_8, new FlowData(0)); 
//		    layoutContainer3_9.add(layoutContainer_537,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)) ;
//
//		    layoutContainer_4502.add(layoutContainer3_9);
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final LayoutContainer layoutContainer_538 = new LayoutContainer(new FitLayout());
//		    layoutContainer_538.setStyleAttribute("background-color", "#dfe8f6"); 
//           // frmlytSch = new FormLayout();  
//           // frmlytSch.setLabelWidth(0); 
//           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          //  layoutContainer_538.setLayout(frmlytSch);
//		    layoutContainer_538.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer_538.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_538.removeStyleName("x-border");
// 		                    // layoutContainer_538.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_538.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_538.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_12 = new LabelField("가 산 월 수");
//		   // lblfldNewLabelfield_12.setStyleAttribute("paddingTop", "4px"); 
//		  //  lblfldNewLabelfield_12.setHeight(24);
//		    lblfldNewLabelfield_12.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_12.setStyleAttribute("vertical-align", "middle");
//		    layoutContainer_538.add(lblfldNewLabelfield_12, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_538);
//		   // lblfldNewLabelfield_12.setHeight("20");
//		    lblfldNewLabelfield_12.setBorders(false);
//		    
//		    
//		    
//		    final LayoutContainer layoutContainer1_10 = new LayoutContainer();
//		    layoutContainer1_10.setLayout(new ColumnLayout());
//		    layoutContainer1_10.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer1_10.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer1_10.removeStyleName("x-border");
// 		                    // layoutContainer1_10.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer1_10.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer1_10.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_539 = new LayoutContainer(new FlowLayout());
//            layoutContainer_539.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_539.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_539.removeStyleName("x-border");
// 		                	 layoutContainer_539.setStyleName("x-border-u-right",true);
// 		                	//layoutContainer_539.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_539.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
//            ctrAddMnth12Bfr = new MSFNumberField();
//            ctrAddMnth12Bfr.setAllowDecimals(true); 
//            ctrAddMnth12Bfr.setPropertyEditorType(Long.class); 
//            ctrAddMnth12Bfr.setFormat(NumberFormat.getDecimalFormat());
//            ctrAddMnth12Bfr.setWidth("80px");
//            ctrAddMnth12Bfr.setHideLabel(true);
//            ctrAddMnth12Bfr.setReadOnly(true);
//		    layoutContainer_539.add(ctrAddMnth12Bfr, new FlowData(0));
//		    layoutContainer1_10.add(layoutContainer_539 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    
//		    final LayoutContainer layoutContainer_540 = new LayoutContainer(new FlowLayout());
//            layoutContainer_540.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_540.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_540.removeStyleName("x-border");
// 		                    // layoutContainer_540.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_540.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_540.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
//            ctrAddMnth13Aft = new MSFNumberField();
//            ctrAddMnth13Aft.setAllowDecimals(true); 
//            ctrAddMnth13Aft.setPropertyEditorType(Long.class); 
//            ctrAddMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            ctrAddMnth13Aft.setWidth("80px");
//            ctrAddMnth13Aft.setHideLabel(true);
//            ctrAddMnth13Aft.setReadOnly(true);
//		    layoutContainer_540.add(ctrAddMnth13Aft, new FlowData(0));
//		    layoutContainer1_10.add(layoutContainer_540,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_2502.add(layoutContainer1_10);
//		    
//		    final LayoutContainer layoutContainer2_10 = new LayoutContainer();
//		    layoutContainer2_10.setLayout(new ColumnLayout());
//		    layoutContainer2_10.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer2_10.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer2_10.removeStyleName("x-border");
// 		                    // layoutContainer2_10.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer2_10.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer2_10.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    
//		    final LayoutContainer layoutContainer_541 = new LayoutContainer(new FlowLayout());
//            layoutContainer_541.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_541.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_541.removeStyleName("x-border");
// 		                	 layoutContainer_541.setStyleName("x-border-u-right",true);
// 		                   // layoutContainer_541.setStyleName("x-border-u-bottom",true);
// 		                   //layoutContainer_541.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
//            endAddMnth12Bfr = new MSFNumberField();
//            endAddMnth12Bfr.setAllowDecimals(true); 
//            endAddMnth12Bfr.setPropertyEditorType(Long.class); 
//            endAddMnth12Bfr.setFormat(NumberFormat.getDecimalFormat());
//            endAddMnth12Bfr.setWidth("80px");
//            endAddMnth12Bfr.setHideLabel(true);
//		    layoutContainer_541.add(endAddMnth12Bfr, new FlowData(0));
//		    layoutContainer2_10.add(layoutContainer_541,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    final LayoutContainer layoutContainer_542 = new LayoutContainer(new FlowLayout());
//            layoutContainer_542.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_542.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_542.removeStyleName("x-border");
// 		                    // layoutContainer_542.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_542.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_542.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_가산월수_2013이후 : endAddMnth13Aft */
//            endAddMnth13Aft = new MSFNumberField();
//            endAddMnth13Aft.setAllowDecimals(true); 
//            endAddMnth13Aft.setPropertyEditorType(Long.class); 
//            endAddMnth13Aft.setFormat(NumberFormat.getDecimalFormat());
//            endAddMnth13Aft.setWidth("80px");
//            endAddMnth13Aft.setHideLabel(true);
//		    layoutContainer_542.add(endAddMnth13Aft, new FlowData(0));
//		    layoutContainer2_10.add(layoutContainer_542,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_3502.add(layoutContainer2_10);
//		    
//		   final LayoutContainer layoutContainer3_10 = new LayoutContainer();
//		    layoutContainer3_10.setLayout(new ColumnLayout());
//		    layoutContainer3_10.setBorders(true);
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//		    layoutContainer3_10.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer3_10.removeStyleName("x-border");
// 		                    // layoutContainer3_10.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer3_10.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer3_10.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end) css 적용 
//             ***********************************************************************************************************/
//		    
//		    final LayoutContainer layoutContainer_543 = new LayoutContainer(new FlowLayout());
//            layoutContainer_543.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_543.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_543.removeStyleName("x-border");
// 		                     layoutContainer_543.setStyleName("x-border-u-right",true);
// 		                	/// layoutContainer_543.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_543.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            MSFNumberField nmbrfldNewNumberfield_13 = new MSFNumberField();
//            nmbrfldNewNumberfield_13.setReadOnly(true);
//            nmbrfldNewNumberfield_13.setEnabled(false);
//		    nmbrfldNewNumberfield_13.setWidth("82px");
//		    nmbrfldNewNumberfield_13.setHideLabel(true);
//		    layoutContainer_543.add(nmbrfldNewNumberfield_13, new FlowData(0));
//		    layoutContainer3_10.add(layoutContainer_543,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    final LayoutContainer layoutContainer_544 = new LayoutContainer(new FlowLayout()); 
//            layoutContainer_544.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_544.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_544.removeStyleName("x-border");
// 		                    // layoutContainer_544.setStyleName("x-border-u-right",true);
// 		                	// layoutContainer_544.setStyleName("x-border-u-bottom",true);
// 		                	//layoutContainer_544.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            MSFNumberField nmbrfldNewNumberfield_14 = new MSFNumberField();
//            nmbrfldNewNumberfield_14.setReadOnly(true);
//            nmbrfldNewNumberfield_14.setEnabled(false);
//		    nmbrfldNewNumberfield_14.setWidth("82px");
//		    nmbrfldNewNumberfield_14.setHideLabel(true);
//		    layoutContainer_544.add(nmbrfldNewNumberfield_14, new FlowData(0));
//		    layoutContainer3_10.add(layoutContainer_544,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    
//		    layoutContainer_4502.add(layoutContainer3_10);
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final LayoutContainer layoutContainer_545 = new LayoutContainer(new FitLayout());
//		    layoutContainer_545.setStyleAttribute("background-color", "#dfe8f6"); 
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//          //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          //  layoutContainer_545.setLayout(frmlytSch);
//            layoutContainer_545.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_545.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_545.removeStyleName("x-border");
// 		                    // layoutContainer_545.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_545.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_545.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_13 = new LabelField("과 세 퇴 직 급 여");
//		   // lblfldNewLabelfield_13.setStyleAttribute("paddingTop", "4px"); 
//		  //  lblfldNewLabelfield_13.setHeight(24);
//		    lblfldNewLabelfield_13.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_13.setStyleAttribute("vertical-align", "middle"); 
//		    layoutContainer_545.add(lblfldNewLabelfield_13, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_545);
//		  //  lblfldNewLabelfield_13.setHeight("22");
//		    lblfldNewLabelfield_13.setBorders(false);
//		    
//		    
//		    final LayoutContainer layoutContainer_546 = new LayoutContainer(new FlowLayout());
//            layoutContainer_546.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_546.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_546.removeStyleName("x-border");
// 		                    // layoutContainer_546.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_546.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_546.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
//            ctrTxtnTgtRetryPayQnty = new MSFNumberField();
//            ctrTxtnTgtRetryPayQnty.setAllowDecimals(true); 
//            ctrTxtnTgtRetryPayQnty.setPropertyEditorType(Long.class); 
//            ctrTxtnTgtRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            ctrTxtnTgtRetryPayQnty.setWidth("160px");
//            ctrTxtnTgtRetryPayQnty.setHideLabel(true);
//            ctrTxtnTgtRetryPayQnty.setReadOnly(true);
//		    layoutContainer_546.add(ctrTxtnTgtRetryPayQnty, new FlowData(0));
//		    layoutContainer_2502.add(layoutContainer_546 );
//		    
//		    final LayoutContainer layoutContainer_547 = new LayoutContainer(new FlowLayout());
//            layoutContainer_547.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_547.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_547.removeStyleName("x-border");
// 		                    // layoutContainer_547.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_547.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_547.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
//            endTxtnTgtRetryPayQnty = new MSFNumberField();
//            endTxtnTgtRetryPayQnty.setAllowDecimals(true); 
//            endTxtnTgtRetryPayQnty.setPropertyEditorType(Long.class); 
//            endTxtnTgtRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            endTxtnTgtRetryPayQnty.setWidth("160px");
//            endTxtnTgtRetryPayQnty.setHideLabel(true);
//            endTxtnTgtRetryPayQnty.setReadOnly(true);
//		    layoutContainer_547.add(endTxtnTgtRetryPayQnty, new FlowData(0));
//		    layoutContainer_3502.add(layoutContainer_547 );
//		    
//		    final LayoutContainer layoutContainer_548 = new LayoutContainer(new FlowLayout());
//            layoutContainer_548.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_548.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_548.removeStyleName("x-border");
// 		                    // layoutContainer_548.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_548.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_548.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
//            clutTxtnTgtRetryPayQnty = new MSFNumberField();
//            clutTxtnTgtRetryPayQnty.setAllowDecimals(true); 
//            clutTxtnTgtRetryPayQnty.setPropertyEditorType(Long.class); 
//            clutTxtnTgtRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            clutTxtnTgtRetryPayQnty.setWidth("165px");
//            clutTxtnTgtRetryPayQnty.setHideLabel(true);
//            clutTxtnTgtRetryPayQnty.setReadOnly(true);
//		    layoutContainer_548.add(clutTxtnTgtRetryPayQnty, new FlowData(0));
//		    layoutContainer_4502.add(layoutContainer_548 );
//		    
//		    
//		  //--------------------------------------------------------------------------
//		    
//		    final LayoutContainer layoutContainer_549 = new LayoutContainer(new FitLayout());
//		    layoutContainer_549.setStyleAttribute("background-color", "#dfe8f6"); 
//           // frmlytSch = new FormLayout();  
//          //  frmlytSch.setLabelWidth(0); 
//          //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           // layoutContainer_549.setLayout(frmlytSch);
//            layoutContainer_549.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_549.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_549.removeStyleName("x-border");
// 		                    // layoutContainer_549.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_549.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_549.setHeight("25px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//		    LabelField lblfldNewLabelfield_14 = new LabelField("비 과 세 퇴직급여");
//		   // lblfldNewLabelfield_14.setStyleAttribute("paddingTop", "4px"); 
//		    //lblfldNewLabelfield_14.setHeight(24);
//		    lblfldNewLabelfield_14.setStyleAttribute("padding-top", "5px");
//		    lblfldNewLabelfield_14.setStyleAttribute("vertical-align", "middle"); 
//		    layoutContainer_549.add(lblfldNewLabelfield_14, new FormData("100%"));
//		    layoutContainer_1502.add(layoutContainer_549);
//		   // lblfldNewLabelfield_14.setHeight("22");
//		    lblfldNewLabelfield_14.setBorders(false);
//		 
//		    
//		   final  LayoutContainer layoutContainer_550 = new LayoutContainer(new FlowLayout());
//            layoutContainer_550.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_550.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_550.removeStyleName("x-border");
// 		                    // layoutContainer_550.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_550.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_550.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
//            ctrFreeDtyRetryPayQnty = new MSFNumberField();
//            ctrFreeDtyRetryPayQnty.setAllowDecimals(true); 
//            ctrFreeDtyRetryPayQnty.setPropertyEditorType(Long.class); 
//            ctrFreeDtyRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            ctrFreeDtyRetryPayQnty.setWidth("160px");
//            ctrFreeDtyRetryPayQnty.setHideLabel(true);
//            ctrFreeDtyRetryPayQnty.setReadOnly(true);
//		    layoutContainer_550.add(ctrFreeDtyRetryPayQnty, new FlowData(0));
//		    layoutContainer_2502.add(layoutContainer_550);
//		    
//		    final LayoutContainer layoutContainer_551 = new LayoutContainer(new FlowLayout());
//            layoutContainer_551.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_551.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_551.removeStyleName("x-border");
// 		                    // layoutContainer_551.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_551.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_551.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
//            endFreeDtyRetryPayQnty = new MSFNumberField();
//            endFreeDtyRetryPayQnty.setAllowDecimals(true); 
//            endFreeDtyRetryPayQnty.setPropertyEditorType(Long.class); 
//            endFreeDtyRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            endFreeDtyRetryPayQnty.setWidth("160px");
//            endFreeDtyRetryPayQnty.setHideLabel(true);
//            endFreeDtyRetryPayQnty.setReadOnly(true);
//		    layoutContainer_551.add(endFreeDtyRetryPayQnty, new FlowData(0));
//		    layoutContainer_3502.add(layoutContainer_551 );
//		    
//		    
//		    final LayoutContainer layoutContainer_552 = new LayoutContainer(new FlowLayout());
//            layoutContainer_552.setBorders(true);
//            /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//             ***********************************************************************************************************/
//            layoutContainer_552.addListener(Events.Render, new Listener<BaseEvent>() {
// 		                   public void handleEvent(BaseEvent be) {
// 		               
// 		                                
// 		                	  layoutContainer_552.removeStyleName("x-border");
// 		                    // layoutContainer_552.setStyleName("x-border-u-right",true);
// 		                	 layoutContainer_552.setStyleName("x-border-u-bottom",true);
// 		                	layoutContainer_552.setHeight("24px");  
// 		                         
// 		                        
// 		                   }
// 		       });
// 		    /**********************************************************************************************************
//              * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
// 	         ***********************************************************************************************************/
//            /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
//            clutFreeDtyRetryPayQnty = new MSFNumberField();
//            clutFreeDtyRetryPayQnty.setAllowDecimals(true); 
//            clutFreeDtyRetryPayQnty.setPropertyEditorType(Long.class); 
//            clutFreeDtyRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
//            clutFreeDtyRetryPayQnty.setWidth("165px");
//            clutFreeDtyRetryPayQnty.setHideLabel(true);
//            clutFreeDtyRetryPayQnty.setReadOnly(true);
//		    layoutContainer_552.add(clutFreeDtyRetryPayQnty, new FlowData(0));
//		    layoutContainer_4502.add(layoutContainer_552);
//		     
//		    
//	       layoutContainer_2.add(hBoxTopFrm);
//	      // layoutContainer_2.setStyleAttribute("padding-bottom", "5px");
//		   layoutContainerItem01.add(layoutContainer_2);
//		   
            /****************** 납부명세 *********************/
		    FieldSet fieldSet02 = new FieldSet();  
		    fieldSet02.setHeadingHtml("납부명세"); 
		 
		    LayoutContainer layoutContainer_176 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(0); 
          // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
           layoutContainer_176.setLayout(frmlytSch); 
           layoutContainer_176.add(createTabGridItem02());  
		     
		    fieldSet02.add(layoutContainer_176);
		     
		    layoutContainerItem01.add(fieldSet02);
		    
		    /****************** 납부명세 *********************/
		    
		    FieldSet fieldSet01 = new FieldSet();  
		    fieldSet01.setStyleAttribute("padding-top", "7px");
		    fieldSet01.setHeadingHtml("과세이연계좌명세");
		   
		   
		    LayoutContainer layoutContainer_159 = new LayoutContainer();
		    
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(0); 
           // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_159.setLayout(frmlytSch); 
		    layoutContainer_159.add(createTabGridItem01()); 
		 
		    fieldSet01.add(layoutContainer_159);
		     
		    layoutContainerItem01.add(fieldSet01);
		    
		    
		    LayoutContainer layoutContainer_169 = new LayoutContainer();
		    layoutContainer_169.setStyleAttribute("padding-top", "7px");
		    layoutContainer_169.setLayout(new ColumnLayout());
		    layoutContainer_169.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_172 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(200); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_172.setLayout(frmlytSch);
            /** column 확정급여형가입일자 : fixPayJnDt */
            fixPayJnDt = new MSFDateField();
		    new DateFieldMask(fixPayJnDt, "9999.99.99"); 
		    fixPayJnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		    layoutContainer_172.add(fixPayJnDt, new FormData("100%")); 
		    fixPayJnDt.setFieldLabel("확정급여일 퇴직연급제도 가입일");
		    layoutContainer_169.add(layoutContainer_172, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_172.setBorders(false);
		    
		    LayoutContainer layoutContainer_275 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(120); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_275.setLayout(frmlytSch); 
            /** column 퇴직금_20111231금액 : sevePay20111231Sum */
            sevePay20111231Sum = new MSFNumberField();
            sevePay20111231Sum.setAllowDecimals(true); 
            sevePay20111231Sum.setPropertyEditorType(Long.class); 
            sevePay20111231Sum.setFormat(NumberFormat.getDecimalFormat());
            layoutContainer_275.add(sevePay20111231Sum, new FormData("100%"));
		    sevePay20111231Sum.setFieldLabel("2011.12.31 퇴직금");
		    layoutContainer_169.add(layoutContainer_275, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_275.setBorders(false);
		     
		    
		    LayoutContainer layoutContainer_175 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_175.setLayout(frmlytSch); 
            /** column 퇴직금_20111231금액 : sevePay20111231Sum */
            aimenrEcteYn = new MSFCheckBox(); 
		    layoutContainer_175.add(aimenrEcteYn, new FormData("100%"));
		    aimenrEcteYn.setFieldLabel("임직원");
		    layoutContainer_169.add(layoutContainer_175, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
		    layoutContainer_175.setBorders(false);
		     
		    
		    fieldSet01.add(layoutContainer_169); 
		    
		    //과세이연계좌명세 /신고대상액 
		    LayoutContainer layoutContainer = new LayoutContainer();
		    layoutContainer.setLayout(new ColumnLayout());
		    layoutContainer.setBorders(true);
		    
		    LayoutContainer layoutContainer_164 = new LayoutContainer(); 
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(100); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_164.setLayout(frmlytSch); 
		    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
		    talRegrstTgtTxAmnt = new MSFNumberField();
		    talRegrstTgtTxAmnt.setAllowDecimals(true); 
		    talRegrstTgtTxAmnt.setPropertyEditorType(Long.class); 
		    talRegrstTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
		    talRegrstTgtTxAmnt.setFieldLabel("신고대상세액");
		    talRegrstTgtTxAmnt.setReadOnly(true);
		    layoutContainer_164.add(talRegrstTgtTxAmnt,new FormData("100%")); 
		    layoutContainer_164.setBorders(false);
		   
		    
		    LayoutContainer layoutContainer_166 = new LayoutContainer(new FlowLayout());
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(100); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_166.setLayout(frmlytSch); 
		    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
		    talRetryPayQnty = new MSFNumberField();
		    talRetryPayQnty.setAllowDecimals(true); 
		    talRetryPayQnty.setPropertyEditorType(Long.class); 
		    talRetryPayQnty.setFormat(NumberFormat.getDecimalFormat());
		    talRetryPayQnty.setFieldLabel("퇴직급여(최종)");
		    talRetryPayQnty.setReadOnly(true);
		    layoutContainer_166.add(talRetryPayQnty,new FormData("100%"));  
		    layoutContainer_166.setBorders(false);
		    
		     
		    LayoutContainer layoutContainer_162 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(100); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_162.setLayout(frmlytSch); 
		    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
		    talRetryIncmTxAmnt = new MSFNumberField();
		    talRetryIncmTxAmnt.setAllowDecimals(true); 
		    talRetryIncmTxAmnt.setPropertyEditorType(Long.class); 
		    talRetryIncmTxAmnt.setFormat(NumberFormat.getDecimalFormat());
		    talRetryIncmTxAmnt.setFieldLabel("이연퇴직소득세");
		    talRetryIncmTxAmnt.setReadOnly(true);
		    layoutContainer_162.add(talRetryIncmTxAmnt,new FormData("100%"));  
		    layoutContainer_162.setBorders(false);
		    
		    layoutContainer.add(layoutContainer_164, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer.add(layoutContainer_166, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer.add(layoutContainer_162, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		    
		    fieldSet01.add(layoutContainer); 
		     
		    
			return layoutContainerItem01; 
		  }  
	  
	/**
	 * 탭세액계산
	 * @return
	 */
	private LayoutContainer createTabItem02() {
		   
		LayoutContainer layoutContainerItem02 = new LayoutContainer();
//		layoutContainerItem02.setStyleAttribute("padding-top", "5px");
		layoutContainerItem02.setStyleAttribute("padding", "3px");
		layoutContainerItem02.setLayout(new FormLayout());
		layoutContainerItem02.setBorders(false);
		
		LayoutContainer lyoutTop = new LayoutContainer(new ColumnLayout());
		lyoutTop.setBorders(false);
		
		    
        final LayoutContainer layoutContainer_01 = new LayoutContainer();
        layoutContainer_01.setBorders(true); 
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_01.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_01.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_01.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_01.setHeight("135px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/  
	    LabelField labelfld_1_1  = new LabelField("근속연수");
	    labelfld_1_1.setStyleAttribute( "text-align", "center"); 
	    layoutContainer_01.setStyleAttribute("background-color", "#dfe8f6");
	    layoutContainer_01.add(labelfld_1_1, new FormData("100%"));
	    lyoutTop.add(layoutContainer_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.03));
        

	    
	    /**/
	    
	    LayoutContainer layoutContainer_02 = new LayoutContainer();
        layoutContainer_02.setBorders(false);
	    
        LayoutContainer layoutContainer_02_1 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_1.setBorders(false);
        
        final LayoutContainer layoutContainer_02_1_1 = new LayoutContainer();
        layoutContainer_02_1_1.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_1.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_1.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        LabelField labelfld_02_1_1 = new LabelField("구  분");
        labelfld_02_1_1.setStyleAttribute("font-size", "11px");
        labelfld_02_1_1.setStyleAttribute("text-align", "center");
        layoutContainer_02_1_1.setStyleAttribute("background-color", "#dfe8f6");
        layoutContainer_02_1_1.add(labelfld_02_1_1, new FormData("100%"));
	    
        
        final LayoutContainer layoutContainer_02_1_2 = new LayoutContainer();
        layoutContainer_02_1_2.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_2.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_2.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_2 = new LabelField("입사일");
		labelfld_02_1_2.setStyleAttribute("font-size", "11px");
		labelfld_02_1_2.setStyleAttribute("text-align", "center");
		labelfld_02_1_2.setBorders(false);
		layoutContainer_02_1_2.add(labelfld_02_1_2, new FormData("100%"));
		
		
        
        final LayoutContainer layoutContainer_02_1_3 = new LayoutContainer();
        layoutContainer_02_1_3.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_3.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_3.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_3 = new LabelField("기산일");
		labelfld_02_1_3.setStyleAttribute("font-size", "11px");
		labelfld_02_1_3.setStyleAttribute("text-align", "center");
		labelfld_02_1_3.setBorders(false);
		layoutContainer_02_1_3.add(labelfld_02_1_3, new FormData("100%"));
		
        
        final LayoutContainer layoutContainer_02_1_4 = new LayoutContainer();
        layoutContainer_02_1_4.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_4.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/       
        layoutContainer_02_1_4.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_4 = new LabelField("퇴사일");
		labelfld_02_1_4.setStyleAttribute("font-size", "11px");
		labelfld_02_1_4.setStyleAttribute("text-align", "center");
		labelfld_02_1_4.setBorders(false);
		layoutContainer_02_1_4.add(labelfld_02_1_4, new FormData("100%"));
		
        
        final LayoutContainer layoutContainer_02_1_5 = new LayoutContainer();
        layoutContainer_02_1_5.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_5.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_5.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_5.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_5 = new LabelField("지급일");
		labelfld_02_1_5.setStyleAttribute("font-size", "11px");
		labelfld_02_1_5.setStyleAttribute("text-align", "center");
		labelfld_02_1_5.setBorders(false);
		layoutContainer_02_1_5.add(labelfld_02_1_5, new FormData("100%"));
		
        
		final LayoutContainer layoutContainer_02_1_6 = new LayoutContainer();
		layoutContainer_02_1_6.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
		layoutContainer_02_1_6.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_6.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_6.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
		layoutContainer_02_1_6.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_6 = new LabelField("근속월");
		labelfld_02_1_6.setStyleAttribute("font-size", "11px");
		labelfld_02_1_6.setStyleAttribute("text-align", "center");
		labelfld_02_1_6.setBorders(false);
		layoutContainer_02_1_6.add(labelfld_02_1_6, new FormData("100%"));
		
		
        final LayoutContainer layoutContainer_02_1_7 = new LayoutContainer();
        layoutContainer_02_1_7.setBorders(true); 
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_7.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_7.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_7.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_7.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_7 = new LabelField("제외월");
		labelfld_02_1_7.setStyleAttribute("font-size", "11px");
		labelfld_02_1_7.setStyleAttribute("text-align", "center");
		labelfld_02_1_7.setBorders(false);
		layoutContainer_02_1_7.add(labelfld_02_1_7, new FormData("100%"));
		
        
        final LayoutContainer layoutContainer_02_1_8 = new LayoutContainer();
        layoutContainer_02_1_8.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_8.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_8.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_8.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_8.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_8 = new LabelField("가산월");
		labelfld_02_1_8.setStyleAttribute("font-size", "11px");
		labelfld_02_1_8.setStyleAttribute("text-align", "center");
		labelfld_02_1_8.setBorders(false);
		layoutContainer_02_1_8.add(labelfld_02_1_8, new FormData("100%"));
		
        
        final LayoutContainer layoutContainer_02_1_9 = new LayoutContainer();
        layoutContainer_02_1_9.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_9.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_9.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_9.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_9.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_9 = new LabelField("중복월");
		labelfld_02_1_9.setStyleAttribute("font-size", "11px");
		labelfld_02_1_9.setStyleAttribute("text-align", "center");
		labelfld_02_1_9.setBorders(false);
		layoutContainer_02_1_9.add(labelfld_02_1_9, new FormData("100%"));
		
        
        final LayoutContainer layoutContainer_02_1_10 = new LayoutContainer();
        layoutContainer_02_1_10.setBorders(true);
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
	     ***********************************************************************************************************/
        layoutContainer_02_1_10.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_1_10.removeStyleName("x-border");
                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
	    		layoutContainer_02_1_10.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_1.setHeight("22px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
        layoutContainer_02_1_10.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_1_10 = new LabelField("근속연");
		labelfld_02_1_10.setStyleAttribute("font-size", "11px");
		labelfld_02_1_10.setStyleAttribute("text-align", "center");
		labelfld_02_1_10.setBorders(false);
		layoutContainer_02_1_10.add(labelfld_02_1_10, new FormData("100%"));
        
        layoutContainer_02_1.add(layoutContainer_02_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));	//header_구분
        layoutContainer_02_1.add(layoutContainer_02_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_입사일
        layoutContainer_02_1.add(layoutContainer_02_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_기산일
        layoutContainer_02_1.add(layoutContainer_02_1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_퇴사일
        layoutContainer_02_1.add(layoutContainer_02_1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_지급일
        layoutContainer_02_1.add(layoutContainer_02_1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_근속월
        layoutContainer_02_1.add(layoutContainer_02_1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_제외월
        layoutContainer_02_1.add(layoutContainer_02_1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_가산월
        layoutContainer_02_1.add(layoutContainer_02_1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_중복월
        layoutContainer_02_1.add(layoutContainer_02_1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//header_근속연
        
        
        /**	중간지급 근속연수 **/
        LayoutContainer layoutContainer_02_2 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_2.setBorders(false);
        
        
        final LayoutContainer layoutContainer_02_2_1 = new LayoutContainer();
        layoutContainer_02_2_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        layoutContainer_02_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_1.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_2_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        layoutContainer_02_2_1.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_2_1 = new LabelField("중간지급 근속연수");
		labelfld_02_2_1.setStyleAttribute("font-size", "10px");
//		labelfld_02_3_1.setHeight(24);
		labelfld_02_2_1.setStyleAttribute("paddingTop", "5px");
		labelfld_02_2_1.setStyleAttribute("vertical-align", "middle");
		labelfld_02_2_1.setBorders(false);
		layoutContainer_02_2_1.add(labelfld_02_2_1, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_2_2 = new LayoutContainer();
		layoutContainer_02_2_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
          ***********************************************************************************************************/  		
		FormLayout formLayout_02_2_2 = new FormLayout();
		formLayout_02_2_2.setLabelWidth(0);
		layoutContainer_02_2_2.setLayout(formLayout_02_2_2);

		/** column 중_입사일자 : ctrViewIcncDt */
		ctrViewIcncDt = new MSFTextField();
		new TextFieldMask<String>(ctrViewIcncDt, "9999.99.99");
		ctrViewIcncDt.setName("ctrIcncDt");
//		ctrViewIcncDt.setWidth("60px");
		ctrViewIcncDt.setHideLabel(true);
		ctrViewIcncDt.setReadOnly(true);
		layoutContainer_02_2_2.add(ctrViewIcncDt, new FormData("100%"));
        
        
		final LayoutContainer layoutContainer_02_2_3 = new LayoutContainer();
		layoutContainer_02_2_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
          ***********************************************************************************************************/ 		
	    FormLayout formLayout_02_2_3 = new FormLayout();
	    formLayout_02_2_3.setLabelWidth(0);
	    layoutContainer_02_2_3.setLayout(formLayout_02_2_3);
	    
		/** column 중_기산일자 : ctrViewRkfcdDt */
		ctrViewRkfcdDt = new MSFTextField();
		new TextFieldMask<String>(ctrViewRkfcdDt, "9999.99.99");
		ctrViewRkfcdDt.setName("ctrViewRkfcdDt");
//		ctrViewRkfcdDt.setWidth("60px");
		ctrViewRkfcdDt.setHideLabel(true);
		ctrViewRkfcdDt.setReadOnly(true);
		layoutContainer_02_2_3.add(ctrViewRkfcdDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_2_4 = new LayoutContainer();
		layoutContainer_02_2_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 			
		FormLayout formLayout_02_2_4 = new FormLayout();
		formLayout_02_2_4.setLabelWidth(0);
		layoutContainer_02_2_4.setLayout(formLayout_02_2_4);
	    
		/** column 중_퇴사일자 : ctrViewRsgtnDt */
		ctrViewRsgtnDt = new MSFTextField();
		new TextFieldMask<String>(ctrViewRsgtnDt, "9999.99.99");
		ctrViewRsgtnDt.setName("ctrRsgtnDt");
		ctrViewRsgtnDt.setWidth("60px");
		ctrViewRsgtnDt.setHideLabel(true);
		ctrViewRsgtnDt.setReadOnly(true);
		layoutContainer_02_2_4.add(ctrViewRsgtnDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_2_5 = new LayoutContainer();
		layoutContainer_02_2_5.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_5.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_5.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 
	    FormLayout formLayout_02_2_5 = new FormLayout();
	    formLayout_02_2_5.setLabelWidth(0);
	    layoutContainer_02_2_5.setLayout(formLayout_02_2_5);
		
		/** column 중_지급일자 : ctrViewPymtDt */
		ctrViewPymtDt = new MSFTextField();
		new TextFieldMask<String>(ctrViewPymtDt, "9999.99.99");
		ctrViewPymtDt.setName("ctrPymtDt");
		ctrViewPymtDt.setWidth("60px");
		ctrViewPymtDt.setHideLabel(true);
		ctrViewPymtDt.setReadOnly(true);
		layoutContainer_02_2_5.add(ctrViewPymtDt, new FormData("100%"));
		
		
		
		final LayoutContainer layoutContainer_02_2_6 = new LayoutContainer();
		layoutContainer_02_2_6.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_6.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_6.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_6.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 		
	    FormLayout formLayout_02_2_6 = new FormLayout();
	    formLayout_02_2_6.setLabelWidth(0);
	    layoutContainer_02_2_6.setLayout(formLayout_02_2_6);

	    /** column 중_근속월수 : ctrViewLogSvcMnthIcm */
		ctrViewLogSvcMnthIcm = new MSFNumberField();
//		ctrViewLogSvcMnthIcm.setWidth("50px");
		ctrViewLogSvcMnthIcm.setHideLabel(true);
		ctrViewLogSvcMnthIcm.setAllowDecimals(true);
		ctrViewLogSvcMnthIcm.setPropertyEditorType(Long.class);
		ctrViewLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_02_2_6.add(ctrViewLogSvcMnthIcm, new FormData("100%"));
		
		
        
		final LayoutContainer layoutContainer_02_2_7 = new LayoutContainer();
		layoutContainer_02_2_7.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_7.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_7.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_7.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 		
	    FormLayout formLayout_02_2_7 = new FormLayout();
	    formLayout_02_2_7.setLabelWidth(0);
	    layoutContainer_02_2_7.setLayout(formLayout_02_2_7);
	    
		/** column 중_제외월수 : ctrEepnMnthIcm */
		ctrEepnMnthIcm = new MSFNumberField();
		ctrEepnMnthIcm.setAllowDecimals(true);
		ctrEepnMnthIcm.setPropertyEditorType(Long.class);
		ctrEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		ctrEepnMnthIcm.setWidth("50px");
		ctrEepnMnthIcm.setHideLabel(true);
		ctrEepnMnthIcm.setReadOnly(true);
		layoutContainer_02_2_7.add(ctrEepnMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_2_8 = new LayoutContainer();
		layoutContainer_02_2_8.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_8.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_8.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_8.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 		
	    FormLayout formLayout_02_2_8 = new FormLayout();
	    formLayout_02_2_8.setLabelWidth(0);
	    layoutContainer_02_2_8.setLayout(formLayout_02_2_8);
	    
		/** column 중_가산월수 : ctrAddMnthIcm */
		ctrAddMnthIcm = new MSFNumberField();
		ctrAddMnthIcm.setAllowDecimals(true);
		ctrAddMnthIcm.setPropertyEditorType(Long.class);
		ctrAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		ctrAddMnthIcm.setWidth("50px");
		ctrAddMnthIcm.setHideLabel(true);
		ctrAddMnthIcm.setReadOnly(true);
		layoutContainer_02_2_8.add(ctrAddMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_2_9 = new LayoutContainer();
		layoutContainer_02_2_9.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_9.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_9.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_9.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
	    FormLayout formLayout_02_2_9 = new FormLayout();
	    formLayout_02_2_9.setLabelWidth(0);
	    layoutContainer_02_2_9.setLayout(formLayout_02_2_9);
	    
		/** column 중_중복월수 : ctrDupMnthIcm */
		ctrDupMnthIcm = new MSFNumberField();
		ctrDupMnthIcm.setAllowDecimals(true);
		ctrDupMnthIcm.setPropertyEditorType(Long.class);
		ctrDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		ctrDupMnthIcm.setWidth("50px");
		ctrDupMnthIcm.setHideLabel(true);
		ctrDupMnthIcm.setReadOnly(true);
		layoutContainer_02_2_9.add(ctrDupMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_2_10 = new LayoutContainer();
		layoutContainer_02_2_10.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_2_10.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_10.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_2_10.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    FormLayout formLayout_02_2_10 = new FormLayout();
	    formLayout_02_2_10.setLabelWidth(0);
	    layoutContainer_02_2_10.setLayout(formLayout_02_2_10);
	    
		/** column 중_근속연수 : ctrLogSvc */
		ctrLogSvc = new MSFNumberField();
		ctrLogSvc.setAllowDecimals(true);
		ctrLogSvc.setPropertyEditorType(Long.class);
		ctrLogSvc.setFormat(NumberFormat.getDecimalFormat());
		ctrLogSvc.setWidth("50px");
		ctrLogSvc.setHideLabel(true);
		ctrLogSvc.setReadOnly(true);
		layoutContainer_02_2_10.add(ctrLogSvc, new FormData("100%"));
		
		
		
        layoutContainer_02_2.add(layoutContainer_02_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));	//header_중간지급근속연수
        layoutContainer_02_2.add(layoutContainer_02_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_입사일
        layoutContainer_02_2.add(layoutContainer_02_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_기산일
        layoutContainer_02_2.add(layoutContainer_02_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_퇴사일
        layoutContainer_02_2.add(layoutContainer_02_2_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_지급일
        layoutContainer_02_2.add(layoutContainer_02_2_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_근속월
        layoutContainer_02_2.add(layoutContainer_02_2_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_제외월
        layoutContainer_02_2.add(layoutContainer_02_2_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_가산월
        layoutContainer_02_2.add(layoutContainer_02_2_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_중복월
        layoutContainer_02_2.add(layoutContainer_02_2_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//중_근속연
        
        
        LayoutContainer layoutContainer_02_3 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_3.setBorders(false);
        
        
        final LayoutContainer layoutContainer_02_3_1 = new LayoutContainer();
        layoutContainer_02_3_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        layoutContainer_02_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_1.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_3_1.setHeight("23px");
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        layoutContainer_02_3_1.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_3_1 = new LabelField("최종분 근속연수");
		labelfld_02_3_1.setStyleAttribute("font-size", "10px");
//		labelfld_02_3_1.setHeight(24);
		labelfld_02_3_1.setStyleAttribute("paddingTop", "5px");
		labelfld_02_3_1.setStyleAttribute("vertical-align", "middle");
		labelfld_02_3_1.setBorders(false);
		layoutContainer_02_3_1.add(labelfld_02_3_1, new FormData("100%"));
		
        
        
		final LayoutContainer layoutContainer_02_3_2 = new LayoutContainer();
		layoutContainer_02_3_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("24px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
	    FormLayout formLayout_02_3_2 = new FormLayout();
	    formLayout_02_3_2.setLabelWidth(0);
	    layoutContainer_02_3_2.setLayout(formLayout_02_3_2);
	    
		/** column 종_입사일자 : endViewIcncDt */
		endViewIcncDt = new MSFTextField();
		new TextFieldMask<String>(endViewIcncDt, "9999.99.99");
		endViewIcncDt.setName("endIcncDt");
//		endViewIcncDt.setWidth("60px");
		endViewIcncDt.setHideLabel(true);
		endViewIcncDt.setReadOnly(true);
		layoutContainer_02_3_2.add(endViewIcncDt, new FormData("100%"));	
		
		
		final LayoutContainer layoutContainer_02_3_3 = new LayoutContainer();
		layoutContainer_02_3_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/			
	    FormLayout formLayout_02_3_3 = new FormLayout();
	    formLayout_02_3_3.setLabelWidth(0);
	    layoutContainer_02_3_3.setLayout(formLayout_02_3_3);
	    
		/** column 종_기산일자 : endViewRkfcdDt */
		endViewRkfcdDt = new MSFTextField();
		new TextFieldMask<String>(endViewRkfcdDt, "9999.99.99");
		endViewRkfcdDt.setName("endRkfcdDt");
		endViewRkfcdDt.setWidth("60px");
		endViewRkfcdDt.setHideLabel(true);
		endViewRkfcdDt.setReadOnly(true);
		layoutContainer_02_3_3.add(endViewRkfcdDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_3_4 = new LayoutContainer();
		layoutContainer_02_3_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
		FormLayout formLayout_02_3_4 = new FormLayout();
		formLayout_02_3_4.setLabelWidth(0);
	    layoutContainer_02_3_4.setLayout(formLayout_02_3_4);
	    
		/** column 종_퇴사일자 : endViewRsgtnDt */
		endViewRsgtnDt = new MSFTextField();
		new TextFieldMask<String>(endViewRsgtnDt, "9999.99.99");
		endViewRsgtnDt.setName("endRsgtnDt");
//		endViewRsgtnDt.setWidth("60px");
		endViewRsgtnDt.setHideLabel(true);
		endViewRsgtnDt.setReadOnly(true);
		layoutContainer_02_3_4.add(endViewRsgtnDt, new FormData("100%"));
        
		
		
		final LayoutContainer layoutContainer_02_3_5 = new LayoutContainer();
		layoutContainer_02_3_5.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_5.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_5.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/			
		FormLayout formLayout_02_3_5 = new FormLayout();
		formLayout_02_3_5.setLabelWidth(0);
	    layoutContainer_02_3_5.setLayout(formLayout_02_3_5);
	    
		/** column 종_지급일자 : endViewPymtDt */
		endViewPymtDt = new MSFTextField();
		new TextFieldMask<String>(endViewPymtDt, "9999.99.99");
		endViewPymtDt.setName("endViewPymtDt");
		endViewPymtDt.setWidth("60px");
		endViewPymtDt.setHideLabel(true);
		endViewPymtDt.setReadOnly(true);
		layoutContainer_02_3_5.add(endViewPymtDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_3_6 = new LayoutContainer();
		layoutContainer_02_3_6.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_6.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_6.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_6.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/	
	    FormLayout formLayout_1_2_3_6 = new FormLayout();
	    formLayout_1_2_3_6.setLabelWidth(0);
	    layoutContainer_02_3_6.setLayout(formLayout_1_2_3_6);
	    
		/** column 종_근속월수 : endViewLogSvcMnthIcm */
		endViewLogSvcMnthIcm = new MSFNumberField();
		endViewLogSvcMnthIcm.setAllowDecimals(true);
		endViewLogSvcMnthIcm.setPropertyEditorType(Long.class);
		endViewLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		endViewLogSvcMnthIcm.setWidth("50px");
		endViewLogSvcMnthIcm.setHideLabel(true);
		endViewLogSvcMnthIcm.setReadOnly(true);
		layoutContainer_02_3_6.add(endViewLogSvcMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_3_7 = new LayoutContainer();
		layoutContainer_02_3_7.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_7.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_7.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_7.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
		FormLayout formLayout_02_3_7 = new FormLayout();
		formLayout_02_3_7.setLabelWidth(0);
		layoutContainer_02_3_7.setLayout(formLayout_02_3_7);

		/** column 종_제외월수 : endEepnMnthIcm */
		endEepnMnthIcm = new MSFNumberField();
		endEepnMnthIcm.setAllowDecimals(true);
		endEepnMnthIcm.setPropertyEditorType(Long.class);
		endEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		// endEepnMnthIcm.setWidth("50px");
		endEepnMnthIcm.setHideLabel(true);
		endEepnMnthIcm.setReadOnly(true);
		layoutContainer_02_3_7.add(endEepnMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_3_8 = new LayoutContainer();
		layoutContainer_02_3_8.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_7.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_7.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_7.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/			
	    FormLayout formLayout_02_3_8 = new FormLayout();
	    formLayout_02_3_8.setLabelWidth(0);
	    layoutContainer_02_3_8.setLayout(formLayout_02_3_8);
	    
		/** column 종_가산월수 : endAddMnthIcm */
		endAddMnthIcm = new MSFNumberField();
		endAddMnthIcm.setAllowDecimals(true);
		endAddMnthIcm.setPropertyEditorType(Long.class);
		endAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		endAddMnthIcm.setWidth("50px");
		endAddMnthIcm.setHideLabel(true);
		endAddMnthIcm.setReadOnly(true);
		layoutContainer_02_3_8.add(endAddMnthIcm,new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_3_9 = new LayoutContainer();
		layoutContainer_02_3_9.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_9.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_9.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_9.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/			
	    FormLayout formLayout_02_3_9 = new FormLayout();
	    formLayout_02_3_9.setLabelWidth(0);
	    layoutContainer_02_3_9.setLayout(formLayout_02_3_9);
	    
		/** column 종_중복월수 : endDupMnthIcm */
		endDupMnthIcm = new MSFNumberField();
		endDupMnthIcm.setAllowDecimals(true);
		endDupMnthIcm.setPropertyEditorType(Long.class);
		endDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		endDupMnthIcm.setWidth("50px");
		endDupMnthIcm.setHideLabel(true);
		endDupMnthIcm.setReadOnly(true);
		layoutContainer_02_3_9.add(endDupMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_3_10 = new LayoutContainer();
		layoutContainer_02_3_10.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_3_9.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_3_9.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_3_9.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
	    FormLayout formLayout_02_3_10 = new FormLayout();
	    formLayout_02_3_10.setLabelWidth(0);
	    layoutContainer_02_3_10.setLayout(formLayout_02_3_10);
	    
		/** column 종_근속연수 : endLogSvcYrNum */
		endLogSvcYrNum = new MSFNumberField();
		endLogSvcYrNum.setAllowDecimals(true);
		endLogSvcYrNum.setPropertyEditorType(Long.class);
		endLogSvcYrNum.setFormat(NumberFormat.getDecimalFormat());
//		endLogSvcYrNum.setWidth("50px");
		endLogSvcYrNum.setHideLabel(true);
		endLogSvcYrNum.setReadOnly(true);
		layoutContainer_02_3_10.add(endLogSvcYrNum, new FormData("100%"));
		
		
        
        layoutContainer_02_3.add(layoutContainer_02_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));	//header_최종분근속연수
        layoutContainer_02_3.add(layoutContainer_02_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_입사일
        layoutContainer_02_3.add(layoutContainer_02_3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_기산일
        layoutContainer_02_3.add(layoutContainer_02_3_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_퇴사일
        layoutContainer_02_3.add(layoutContainer_02_3_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_지급일
        layoutContainer_02_3.add(layoutContainer_02_3_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_근속월
        layoutContainer_02_3.add(layoutContainer_02_3_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_제외월
        layoutContainer_02_3.add(layoutContainer_02_3_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_가산월
        layoutContainer_02_3.add(layoutContainer_02_3_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_중복월
        layoutContainer_02_3.add(layoutContainer_02_3_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//종_근속연
        
        
        LayoutContainer layoutContainer_02_4 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_4.setBorders(false);
        
        final LayoutContainer layoutContainer_02_4_1 = new LayoutContainer();
        layoutContainer_02_4_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        layoutContainer_02_4_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_2_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_1.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_4_1.setHeight("23px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        layoutContainer_02_4_1.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_1_2_4_1 = new LabelField("정산 근속연수");
		labelfld_1_2_4_1.setStyleAttribute("font-size", "10px");
//		labelfld_1_2_4_1.setHeight(24);
		labelfld_1_2_4_1.setStyleAttribute("paddingTop", "5px");
		labelfld_1_2_4_1.setStyleAttribute("vertical-align", "middle");
		labelfld_1_2_4_1.setBorders(false);
		layoutContainer_02_4_1.add(labelfld_1_2_4_1, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_4_2 = new LayoutContainer();
		layoutContainer_02_4_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_4_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_2.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_4_2.setHeight("23px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/			
		FormLayout formLayout_02_4_2 = new FormLayout();
		formLayout_02_4_2.setLabelWidth(0);
	    layoutContainer_02_4_2.setLayout(formLayout_02_4_2);
	    
		/** column 정산_입사일자 : clutIcncDt REad */
		clutIcncDt = new MSFTextField();
		new TextFieldMask<String>(clutIcncDt, "9999.99.99");
		clutIcncDt.setName("clutIcncDt");
//		clutIcncDt.setWidth("60px");
		clutIcncDt.setHideLabel(true);
		clutIcncDt.setReadOnly(true);
		layoutContainer_02_4_2.add(clutIcncDt, new FormData("100%"));
		
		final LayoutContainer layoutContainer_02_4_3 = new LayoutContainer();
		layoutContainer_02_4_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_4_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/	
		FormLayout formLayout_02_4_3 = new FormLayout();
		formLayout_02_4_3.setLabelWidth(0);
	    layoutContainer_02_4_3.setLayout(formLayout_02_4_3);
	    
		/** column 정산-기산일자 : clutRkfcdDt */
		clutRkfcdDt = new MSFTextField();
		new TextFieldMask<String>(clutRkfcdDt, "9999.99.99");
		clutRkfcdDt.setName("clutRkfcdDt");
//		clutRkfcdDt.setWidth("60px");
		clutRkfcdDt.setHideLabel(true);
		clutRkfcdDt.setReadOnly(true);
		layoutContainer_02_4_3.add(clutRkfcdDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_4_4 = new LayoutContainer();
		layoutContainer_02_4_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_4_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/			
	    FormLayout formLayout_02_4_4 = new FormLayout();
	    formLayout_02_4_4.setLabelWidth(0);
	    layoutContainer_02_4_4.setLayout(formLayout_02_4_4);
	    
		/** column 정산_퇴사일자 : clutRsgtnDt */
		clutRsgtnDt = new MSFTextField();
		new TextFieldMask<String>(clutRsgtnDt, "9999.99.99");
		clutRsgtnDt.setName("clutRsgtnDt");
		clutRsgtnDt.setWidth("60px");
		clutRsgtnDt.setHideLabel(true);
		clutRsgtnDt.setReadOnly(true);
		layoutContainer_02_4_4.add(clutRsgtnDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_4_5 = new LayoutContainer();
		layoutContainer_02_4_5.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_4_5.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_5.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_5.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/	
		FormLayout formLayout_02_4_5 = new FormLayout();
		formLayout_02_4_5.setLabelWidth(0);
	    layoutContainer_02_4_5.setLayout(formLayout_02_4_5);
		
		/** column 정산_지급일자 : clutPymtDt */
		clutPymtDt = new MSFTextField();
		new TextFieldMask<String>(clutPymtDt, "9999.99.99");
		clutPymtDt.setName("clutPymtDt");
//		clutPymtDt.setWidth("60px");
		clutPymtDt.setHideLabel(true);
		clutPymtDt.setReadOnly(true);
		layoutContainer_02_4_5.add(clutPymtDt, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_4_6 = new LayoutContainer();
		layoutContainer_02_4_6.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_4_6.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_6.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_6.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
		FormLayout formLayout_02_4_6 = new FormLayout();
		formLayout_02_4_6.setLabelWidth(0);
	    layoutContainer_02_4_6.setLayout(formLayout_02_4_6);
		
		/** column 정산_근속월수 : clutLogSvcMnthIcm */
		clutLogSvcMnthIcm = new MSFNumberField();
		clutLogSvcMnthIcm.setAllowDecimals(true);
		clutLogSvcMnthIcm.setPropertyEditorType(Long.class);
		clutLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		clutLogSvcMnthIcm.setWidth("50px");
		clutLogSvcMnthIcm.setHideLabel(true);
		clutLogSvcMnthIcm.setReadOnly(true);
		layoutContainer_02_4_6.add(clutLogSvcMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_4_7 = new LayoutContainer();
		layoutContainer_02_4_7.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		layoutContainer_02_4_7.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_7.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_7.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/		
		FormLayout formLayout_02_4_7 = new FormLayout();
		formLayout_02_4_7.setLabelWidth(0);
	    layoutContainer_02_4_7.setLayout(formLayout_02_4_7);
	    
		/** column 정산_제외월수 : clutEepnMnthIcm */
		clutEepnMnthIcm = new MSFNumberField();
		clutEepnMnthIcm.setAllowDecimals(true);
		clutEepnMnthIcm.setPropertyEditorType(Long.class);
		clutEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		clutEepnMnthIcm.setWidth("50px");
		clutEepnMnthIcm.setHideLabel(true);
		clutEepnMnthIcm.setReadOnly(true);
		layoutContainer_02_4_7.add(clutEepnMnthIcm, new FormData("100%"));
		
	    
	    final LayoutContainer layoutContainer_02_4_8 = new LayoutContainer();
	    layoutContainer_02_4_8.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
	    layoutContainer_02_4_8.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_4_8.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_4_8.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/	
	    FormLayout formLayout_02_4_8 = new FormLayout();
	    formLayout_02_4_8.setLabelWidth(0);
	    layoutContainer_02_4_8.setLayout(formLayout_02_4_8);
		
	    /** column 정산_가산월수 : clutAddMnthIcm */
		clutAddMnthIcm = new MSFNumberField();
		clutAddMnthIcm.setAllowDecimals(true);
		clutAddMnthIcm.setPropertyEditorType(Long.class);
		clutAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		clutAddMnthIcm.setWidth("50px");
		clutAddMnthIcm.setHideLabel(true);
		clutAddMnthIcm.setReadOnly(true);
		layoutContainer_02_4_8.add(clutAddMnthIcm, new FormData("100%"));
		
		
		final LayoutContainer layoutContainer_02_4_9 = new LayoutContainer();
		layoutContainer_02_4_9.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
		layoutContainer_02_4_9.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_4_9.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_4_9.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	
		FormLayout formLayout_02_4_9 = new FormLayout();
		formLayout_02_4_9.setLabelWidth(0);
		layoutContainer_02_4_9.setLayout(formLayout_02_4_9);

		/** column 정산_중복월수 : clutDupMnthIcm */
		clutDupMnthIcm = new MSFNumberField();
		clutDupMnthIcm.setAllowDecimals(true);
		clutDupMnthIcm.setPropertyEditorType(Long.class);
		clutDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//		clutDupMnthIcm.setWidth("50px");
		clutDupMnthIcm.setHideLabel(true);
		clutDupMnthIcm.setReadOnly(true);
		layoutContainer_02_4_9.add(clutDupMnthIcm, new FormData("100%"));
		 
		 
		final LayoutContainer layoutContainer_02_4_10 = new LayoutContainer();
		layoutContainer_02_4_10.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
		layoutContainer_02_4_10.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_4_10.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_4_10.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
		FormLayout formLayout_02_4_10 = new FormLayout();
		formLayout_02_4_10.setLabelWidth(0);
		layoutContainer_02_4_10.setLayout(formLayout_02_4_10);

		/** column 정산_근속연수 : clutLogSvcYrNum */
		clutLogSvcYrNum = new MSFNumberField();
		clutLogSvcYrNum.setAllowDecimals(true);
		clutLogSvcYrNum.setPropertyEditorType(Long.class);
		clutLogSvcYrNum.setFormat(NumberFormat.getDecimalFormat());
		// clutLogSvcYrNum.setWidth("50px");
		clutLogSvcYrNum.setHideLabel(true);
		clutLogSvcYrNum.setReadOnly(true);
		layoutContainer_02_4_10.add(clutLogSvcYrNum, new FormData("100%"));
        
        layoutContainer_02_4.add(layoutContainer_02_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));	//header_정산근속연수
        layoutContainer_02_4.add(layoutContainer_02_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_입사일
        layoutContainer_02_4.add(layoutContainer_02_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_기산일
        layoutContainer_02_4.add(layoutContainer_02_4_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_퇴사일
        layoutContainer_02_4.add(layoutContainer_02_4_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_지급일
        layoutContainer_02_4.add(layoutContainer_02_4_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_근속월
        layoutContainer_02_4.add(layoutContainer_02_4_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_제외월
        layoutContainer_02_4.add(layoutContainer_02_4_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_가산월
        layoutContainer_02_4.add(layoutContainer_02_4_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_중복월
        layoutContainer_02_4.add(layoutContainer_02_4_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));	//정_근속연
        
        
        
        LayoutContainer layoutContainer_02_5 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_5.setBorders(false);
        
//        layoutContainer_02_5.setStyleAttribute("background-color", "#dfe8f6");

        final LayoutContainer layoutContainer_02_5_1 = new LayoutContainer();
        layoutContainer_02_5_1.setStyleAttribute("background-color", "#dfe8f6");
        layoutContainer_02_5_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        layoutContainer_02_5_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_5_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_5_1.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_5_1.setHeight("46px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		LabelField labelfld_02_5_1 = new LabelField("안분");
//		labelfld_02_5_1.setHeight("48px");
		labelfld_02_5_1.setStyleAttribute("padding-top", "10px");
		labelfld_02_5_1.setStyleAttribute("vertical-align", "middle");
		layoutContainer_02_5_1.add(labelfld_02_5_1, new FormData("100%"));
		labelfld_02_5_1.setBorders(false);
        layoutContainer_02_5.add(layoutContainer_02_5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.03));
        
        
        
        
        LayoutContainer layoutContainer_02_5_2 = new LayoutContainer();
        layoutContainer_02_5_2.setBorders(false);
        
        
        LayoutContainer layoutContainer_02_5_2_1 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_5_2_1.setBorders(false);
        
        final LayoutContainer layoutContainer_02_5_2_1_1 = new LayoutContainer();
        layoutContainer_02_5_2_1_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        layoutContainer_02_5_2_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_5_2_1_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_5_2_1_1.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_5_2_1_1.setHeight("23px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/       
        layoutContainer_02_5_2_1_1.setStyleAttribute("background-color", "#dfe8f6");
		LabelField labelfld_02_5_2_1_1 = new LabelField("2012.12.31이전");
		labelfld_02_5_2_1_1.setStyleAttribute("font-size", "10px");
//		labelfld_02_5_2_1_1.setHeight(24);
		labelfld_02_5_2_1_1.setStyleAttribute("padding-top", "5px");
		labelfld_02_5_2_1_1.setStyleAttribute("vertical-align", "middle");
		labelfld_02_5_2_1_1.setBorders(false);
		layoutContainer_02_5_2_1_1.add(labelfld_02_5_2_1_1, new FormData("100%"));
        
        
		final LayoutContainer layoutContainer_02_5_2_1_2 = new LayoutContainer();
		layoutContainer_02_5_2_1_2.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
		layoutContainer_02_5_2_1_2.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_2.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_2.setStyleName("x-border-u-bottom", true);
				 layoutContainer_02_5_2_1_2.setHeight("22px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/			
		FormLayout formLayout_02_5_2_1_2 = new FormLayout();
		formLayout_02_5_2_1_2.setLabelWidth(0);
		layoutContainer_02_5_2_1_2.setLayout(formLayout_02_5_2_1_2);
		
		/** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
        logPpnl12befIcncDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl12befIcncDt, "9999.99.99"); 
        logPpnl12befIcncDt.setName("logPpnl12befIcncDt");
//        logPpnl12befIcncDt.setWidth("60px");
        logPpnl12befIcncDt.setHideLabel(true);  
        logPpnl12befIcncDt.setReadOnly(true);
        layoutContainer_02_5_2_1_2.add(logPpnl12befIcncDt, new FormData("100%"));
        
        
        
        final LayoutContainer layoutContainer_02_5_2_1_3 = new LayoutContainer();
        layoutContainer_02_5_2_1_3.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_3.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_3.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_3.setStyleName("x-border-u-bottom", true);
				 layoutContainer_02_5_2_1_3.setHeight("22px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_3 = new FormLayout();
        formLayout_02_5_2_1_3.setLabelWidth(0);
        layoutContainer_02_5_2_1_3.setLayout(formLayout_02_5_2_1_3);
		
		/** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
        logPpnl12befRkfcdDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl12befRkfcdDt, "9999.99.99"); 
        logPpnl12befRkfcdDt.setName("logPpnl12befRkfcdDt");
//        logPpnl12befRkfcdDt.setWidth("60px");
        logPpnl12befRkfcdDt.setHideLabel(true);  
        logPpnl12befRkfcdDt.setReadOnly(true);
        layoutContainer_02_5_2_1_3.add(logPpnl12befRkfcdDt, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_1_4 = new LayoutContainer();
        layoutContainer_02_5_2_1_4.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_4.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_4.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_4.setStyleName("x-border-u-bottom", true);
				 layoutContainer_02_5_2_1_4.setHeight("22px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_4 = new FormLayout();
        formLayout_02_5_2_1_4.setLabelWidth(0);
        layoutContainer_02_5_2_1_4.setLayout(formLayout_02_5_2_1_4);
        
        /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
        logPpnl12befRsgtnDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl12befRsgtnDt, "9999.99.99"); 
        logPpnl12befRsgtnDt.setName("logPpnl12befRsgtnDt");
//        logPpnl12befRsgtnDt.setWidth("60px");
        logPpnl12befRsgtnDt.setHideLabel(true);  
        logPpnl12befRsgtnDt.setReadOnly(true);
        layoutContainer_02_5_2_1_4.add(logPpnl12befRsgtnDt, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_1_5 = new LayoutContainer();
        layoutContainer_02_5_2_1_5.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_5.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_5.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_5.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_5 = new FormLayout();
        formLayout_02_5_2_1_5.setLabelWidth(0);
        layoutContainer_02_5_2_1_5.setLayout(formLayout_02_5_2_1_5);
        
        /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
        logPpnl12befPymtDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl12befPymtDt, "9999.99.99"); 
        logPpnl12befPymtDt.setName("logPpnl12befPymtDt");
//        logPpnl12befPymtDt.setWidth("60px");
        logPpnl12befPymtDt.setHideLabel(true);  
        logPpnl12befPymtDt.setReadOnly(true);
        layoutContainer_02_5_2_1_5.add(logPpnl12befPymtDt, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_1_6 = new LayoutContainer();
        layoutContainer_02_5_2_1_6.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_6.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_6.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_6.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_6 = new FormLayout();
        formLayout_02_5_2_1_6.setLabelWidth(0);
        layoutContainer_02_5_2_1_6.setLayout(formLayout_02_5_2_1_6);
        
        /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
        logPpnl12befLogMnthIcm = new MSFNumberField();
        logPpnl12befLogMnthIcm.setAllowDecimals(true); 
        logPpnl12befLogMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl12befLogMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//        logPpnl12befLogMnthIcm.setWidth("50px");
        logPpnl12befLogMnthIcm.setHideLabel(true);  
        logPpnl12befLogMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_1_6.add(logPpnl12befLogMnthIcm, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_1_7 = new LayoutContainer();
        layoutContainer_02_5_2_1_7.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_7.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_7.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_7.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_7 = new FormLayout();
        formLayout_02_5_2_1_7.setLabelWidth(0);
        layoutContainer_02_5_2_1_7.setLayout(formLayout_02_5_2_1_7);
        
        /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
        logPpnl12befEepnMnthIcm = new MSFNumberField();
        logPpnl12befEepnMnthIcm.setAllowDecimals(true); 
        logPpnl12befEepnMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl12befEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//        logPpnl12befEepnMnthIcm.setWidth("50px");
        logPpnl12befEepnMnthIcm.setHideLabel(true);  
        logPpnl12befEepnMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_1_7.add(logPpnl12befEepnMnthIcm, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_1_8 = new LayoutContainer();
        layoutContainer_02_5_2_1_8.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_8.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_8.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_8.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_8 = new FormLayout();
        formLayout_02_5_2_1_8.setLabelWidth(0);
        layoutContainer_02_5_2_1_8.setLayout(formLayout_02_5_2_1_8);
        
        /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
        logPpnl12befAddMnthIcm = new MSFNumberField();
        logPpnl12befAddMnthIcm.setAllowDecimals(true); 
        logPpnl12befAddMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl12befAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//        logPpnl12befAddMnthIcm.setWidth("50px");
        logPpnl12befAddMnthIcm.setHideLabel(true);  
        logPpnl12befAddMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_1_8.add(logPpnl12befAddMnthIcm, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_1_9 = new LayoutContainer();
        layoutContainer_02_5_2_1_9.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_9.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_9.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_9.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_9 = new FormLayout();
        formLayout_02_5_2_1_9.setLabelWidth(0);
        layoutContainer_02_5_2_1_9.setLayout(formLayout_02_5_2_1_9);
        
        /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
        logPpnl12befDupMnthIcm = new MSFNumberField();
        logPpnl12befDupMnthIcm.setAllowDecimals(true); 
        logPpnl12befDupMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl12befDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//        logPpnl12befDupMnthIcm.setWidth("50px");
        logPpnl12befDupMnthIcm.setHideLabel(true);  
        logPpnl12befDupMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_1_9.add(logPpnl12befDupMnthIcm, new FormData("100%"));
        
        
        
        final LayoutContainer layoutContainer_02_5_2_1_10 = new LayoutContainer();
        layoutContainer_02_5_2_1_10.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_1_10.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_1_10.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_1_10.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/	        
        FormLayout formLayout_02_5_2_1_10 = new FormLayout();
        formLayout_02_5_2_1_10.setLabelWidth(0);
        layoutContainer_02_5_2_1_10.setLayout(formLayout_02_5_2_1_10);
        
        /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
        logPpnl12befLogYrNum = new MSFNumberField();
        logPpnl12befLogYrNum.setAllowDecimals(true); 
        logPpnl12befLogYrNum.setPropertyEditorType(Long.class); 
        logPpnl12befLogYrNum.setFormat(NumberFormat.getDecimalFormat());
//        logPpnl12befLogYrNum.setWidth("50px");
        logPpnl12befLogYrNum.setHideLabel(true);  
        logPpnl12befLogYrNum.setReadOnly(true);
        layoutContainer_02_5_2_1_10.add(logPpnl12befLogYrNum, new FormData("100%"));
        
        
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1675));	//header_2012.12.31이후
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_입사일
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_기산일
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_퇴사일
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_지급일
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_근속월
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_제외월
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_가산월
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_중복월
        layoutContainer_02_5_2_1.add(layoutContainer_02_5_2_1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2012_근속연       
        layoutContainer_02_5_2.add(layoutContainer_02_5_2_1, new FormData("100%")); 
        
        
        
        LayoutContainer layoutContainer_02_5_2_2 = new LayoutContainer(new ColumnLayout());
        layoutContainer_02_5_2_2.setBorders(false);
        
        final LayoutContainer layoutContainer_02_5_2_2_1 = new LayoutContainer();
        layoutContainer_02_5_2_2_1.setBorders(true);
	    /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        layoutContainer_02_5_2_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		layoutContainer_02_5_2_2_1.removeStyleName("x-border");
		                   //	  layoutContainer_506.setStyleName("x-border-u-top",true);
	    		layoutContainer_02_5_2_2_1.setStyleName("x-border-u-bottom",true);
	    		layoutContainer_02_5_2_2_1.setHeight("23px");  
	    	}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/     
        layoutContainer_02_5_2_2_1.setStyleAttribute("background-color", "#dfe8f6"); 
        LabelField labelfld_02_5_2_2_1 = new LabelField("2013.01.01이후");
        labelfld_02_5_2_2_1.setStyleAttribute("font-size", "10px");
//        labelfld_02_5_2_2_1.setHeight(24);
        labelfld_02_5_2_2_1.setBorders(false);
        labelfld_02_5_2_2_1.setStyleAttribute("paddingTop", "5px");
        labelfld_02_5_2_2_1.setStyleAttribute("vertical-align", "middle"); 
        layoutContainer_02_5_2_2_1.add(labelfld_02_5_2_2_1, new FormData("100%"));
        
        
        
        final LayoutContainer layoutContainer_02_5_2_2_2 = new LayoutContainer();
        layoutContainer_02_5_2_2_2.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_2.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_2.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_2 = new FormLayout();
        formLayout_02_5_2_2_2.setLabelWidth(0);
        layoutContainer_02_5_2_2_2.setLayout(formLayout_02_5_2_2_2);
        
        /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
        logPpnl12befLogYrNum = new MSFNumberField();
        logPpnl12befLogYrNum.setAllowDecimals(true); 
        logPpnl12befLogYrNum.setPropertyEditorType(Long.class); 
        logPpnl12befLogYrNum.setFormat(NumberFormat.getDecimalFormat());
//        logPpnl12befLogYrNum.setWidth("50px");
        logPpnl12befLogYrNum.setHideLabel(true);  
        logPpnl12befLogYrNum.setReadOnly(true);
        layoutContainer_02_5_2_2_2.add(logPpnl12befLogYrNum, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_2_3 = new LayoutContainer();
        layoutContainer_02_5_2_2_3.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_3.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_3.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_3 = new FormLayout();
        formLayout_02_5_2_2_3.setLabelWidth(0);
        layoutContainer_02_5_2_2_3.setLayout(formLayout_02_5_2_2_3);
        
        /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
        logPpnl13afrRkfcdDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl13afrRkfcdDt, "9999.99.99"); 
        logPpnl13afrRkfcdDt.setName("logPpnl13afrRkfcdDt");
//        logPpnl13afrRkfcdDt.setWidth("60px");
        logPpnl13afrRkfcdDt.setHideLabel(true);  
        logPpnl13afrRkfcdDt.setReadOnly(true);
        layoutContainer_02_5_2_2_3.add(logPpnl13afrRkfcdDt, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_2_4 = new LayoutContainer();
        layoutContainer_02_5_2_2_4.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_4.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_4.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_4.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_4 = new FormLayout();
        formLayout_02_5_2_2_4.setLabelWidth(0);
        layoutContainer_02_5_2_2_4.setLayout(formLayout_02_5_2_2_4);
        
        /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
        logPpnl13afrRsgtnDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl13afrRsgtnDt, "9999.99.99"); 
        logPpnl13afrRsgtnDt.setName("logPpnl13afrRsgtnDt");
        logPpnl13afrRsgtnDt.setWidth("60px");
        logPpnl13afrRsgtnDt.setHideLabel(true);  
        logPpnl13afrRsgtnDt.setReadOnly(true);
        layoutContainer_02_5_2_2_4.add(logPpnl13afrRsgtnDt, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_2_5 = new LayoutContainer();
        layoutContainer_02_5_2_2_5.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_5.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_5.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_5.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_5 = new FormLayout();
        formLayout_02_5_2_2_5.setLabelWidth(0);
        layoutContainer_02_5_2_2_5.setLayout(formLayout_02_5_2_2_5);
        
        
        /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
        logPpnl13afrPymtDt = new MSFTextField();
        new TextFieldMask<String>(logPpnl13afrPymtDt, "9999.99.99"); 
        logPpnl13afrPymtDt.setName("logPpnl13afrPymtDt");
        logPpnl13afrPymtDt.setWidth("60px");
        logPpnl13afrPymtDt.setHideLabel(true);  
        logPpnl13afrPymtDt.setReadOnly(true);
        layoutContainer_02_5_2_2_5.add(logPpnl13afrPymtDt, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_2_6 = new LayoutContainer();
        layoutContainer_02_5_2_2_6.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_6.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_6.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_6.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_6 = new FormLayout();
        formLayout_02_5_2_2_6.setLabelWidth(0);
        layoutContainer_02_5_2_2_6.setLayout(formLayout_02_5_2_2_6);
        
        /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
        logPpnl13afrLogMnthIcm = new MSFNumberField();
        logPpnl13afrLogMnthIcm.setAllowDecimals(true); 
        logPpnl13afrLogMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl13afrLogMnthIcm.setFormat(NumberFormat.getDecimalFormat());
        
//        logPpnl13afrLogMnthIcm.setWidth("50px");
        logPpnl13afrLogMnthIcm.setHideLabel(true);  
        logPpnl13afrLogMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_2_6.add(logPpnl13afrLogMnthIcm, new FormData("100%"));
        
        
        
        
        final LayoutContainer layoutContainer_02_5_2_2_7 = new LayoutContainer();
        layoutContainer_02_5_2_2_7.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_7.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_7.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_7.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_7 = new FormLayout();
        formLayout_02_5_2_2_7.setLabelWidth(0);
        layoutContainer_02_5_2_2_7.setLayout(formLayout_02_5_2_2_7);
        
        /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
        logPpnl13afrEepnMnthIcm = new MSFNumberField();
        logPpnl13afrEepnMnthIcm.setAllowDecimals(true); 
        logPpnl13afrEepnMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl13afrEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
        
//        logPpnl13afrEepnMnthIcm.setWidth("50px");
        logPpnl13afrEepnMnthIcm.setHideLabel(true);  
        logPpnl13afrEepnMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_2_7.add(logPpnl13afrEepnMnthIcm, new FormData("100%")); 
        
        
        final LayoutContainer layoutContainer_02_5_2_2_8 = new LayoutContainer();
        layoutContainer_02_5_2_2_8.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_8.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_8.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_8.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_8 = new FormLayout();
        formLayout_02_5_2_2_8.setLabelWidth(0);
        layoutContainer_02_5_2_2_8.setLayout(formLayout_02_5_2_2_8);
        
        /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
        logPpnl13afrAddMnthIcm = new MSFNumberField();
        logPpnl13afrAddMnthIcm.setAllowDecimals(true); 
        logPpnl13afrAddMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl13afrAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
        
//        logPpnl13afrAddMnthIcm.setWidth("50px");
        logPpnl13afrAddMnthIcm.setHideLabel(true);  
        logPpnl13afrAddMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_2_8.add(logPpnl13afrAddMnthIcm, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_2_9 = new LayoutContainer();
        layoutContainer_02_5_2_2_9.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_9.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_9.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_9.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_9 = new FormLayout();
        formLayout_02_5_2_2_9.setLabelWidth(0);
        layoutContainer_02_5_2_2_9.setLayout(formLayout_02_5_2_2_9);
        
        /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
        logPpnl13afrDupMnthIcm = new MSFNumberField();
        logPpnl13afrDupMnthIcm.setAllowDecimals(true); 
        logPpnl13afrDupMnthIcm.setPropertyEditorType(Long.class); 
        logPpnl13afrDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
        
//        logPpnl13afrDupMnthIcm.setWidth("50px");
        logPpnl13afrDupMnthIcm.setHideLabel(true);  
        logPpnl13afrDupMnthIcm.setReadOnly(true);
        layoutContainer_02_5_2_2_9.add(logPpnl13afrDupMnthIcm, new FormData("100%"));
        
        
        final LayoutContainer layoutContainer_02_5_2_2_10 = new LayoutContainer();
        layoutContainer_02_5_2_2_10.setBorders(false);
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
		 ***********************************************************************************************************/
        layoutContainer_02_5_2_2_10.addListener(Events.Render, new Listener<BaseEvent>() {
			 public void handleEvent(BaseEvent be) {
				 layoutContainer_02_5_2_2_10.removeStyleName("x-border");
						// layoutContainer_504.setStyleName("x-border-u-top",true);
				 layoutContainer_02_5_2_2_10.setStyleName("x-border-u-bottom", true);
						// layoutContainer_02_2_2.setHeight("25px");
			 }
		 });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/
        FormLayout formLayout_02_5_2_2_10 = new FormLayout();
        formLayout_02_5_2_2_10.setLabelWidth(0);
        layoutContainer_02_5_2_2_10.setLayout(formLayout_02_5_2_2_10);
        
        /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
        logPpnl13afrLogSvc = new MSFNumberField();
        logPpnl13afrLogSvc.setAllowDecimals(true); 
        logPpnl13afrLogSvc.setPropertyEditorType(Long.class); 
        logPpnl13afrLogSvc.setFormat(NumberFormat.getDecimalFormat());
        
//        logPpnl13afrLogSvc.setWidth("50px");
        logPpnl13afrLogSvc.setHideLabel(true);  
        logPpnl13afrLogSvc.setReadOnly(true);
        layoutContainer_02_5_2_2_10.add(logPpnl13afrLogSvc, new FormData("100%"));
        
        
        
        
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1675));	//header_2013.12.31이후
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_입사일
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_기산일
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_퇴사일
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_지급일
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_근속월
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_제외월
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_가산월
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_중복월
        layoutContainer_02_5_2_2.add(layoutContainer_02_5_2_2_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.0925));	//2013_근속연   
        
        layoutContainer_02_5_2.add(layoutContainer_02_5_2_2); 
        layoutContainer_02_5.add(layoutContainer_02_5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.97));
        
        
        layoutContainer_02.add(layoutContainer_02_1);	//header
        layoutContainer_02.add(layoutContainer_02_2);	//중간지급 근속연수
        layoutContainer_02.add(layoutContainer_02_3);	//최종분 근속연수
        layoutContainer_02.add(layoutContainer_02_4);	//정산 근속연수
        layoutContainer_02.add(layoutContainer_02_5);	//안분
        
        
        
	    lyoutTop.add(layoutContainer_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.97));
        
        
        layoutContainerItem02.add(lyoutTop, new FormData("100%"));
        
        
        /** 퇴직소득과세표준계산 **/
        LayoutContainer lyoutMid = new LayoutContainer();
        lyoutMid.setBorders(false);
        
        
        LayoutContainer lyoutMid_01 = new LayoutContainer(new ColumnLayout());
        lyoutMid_01.setBorders(false);
        
        
        final LayoutContainer lyoutMid_01_1 = new LayoutContainer();
        lyoutMid_01_1.setBorders(true);
        lyoutMid_01_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_01_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutMid_01_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutMid_01_1.setStyleName("x-border-u-bottom", true);
				lyoutMid_01_1.setHeight("23px");
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
		LabelField labelfldMid_01_1 = new LabelField("계 산 내 용");
		labelfldMid_01_1.setStyleAttribute( "text-align", "center"); 
		labelfldMid_01_1.setBorders(false);
		lyoutMid_01_1.add(labelfldMid_01_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutMid_01_2 = new LayoutContainer();
        lyoutMid_01_2.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_01_2.addListener(Events.Render, new Listener<BaseEvent>() {
        	public void handleEvent(BaseEvent be) {
        		lyoutMid_01_2.removeStyleName("x-border");
		                   //	  layoutContainer_503.setStyleName("x-border-u-top",true);
        		lyoutMid_01_2.setStyleName("x-border-u-bottom",true);
        		lyoutMid_01_2.setHeight("23px");
        	}
        });
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
         ***********************************************************************************************************/ 
        lyoutMid_01_2.setStyleAttribute("background-color", "#dfe8f6");
        LabelField labelfld_01_2 = new LabelField("중간지급");
        labelfld_01_2.setStyleAttribute( "text-align", "center"); 
        labelfld_01_2.setBorders(false);
        lyoutMid_01_2.add(labelfld_01_2, new FormData("100%"));
        
        
        
        
        final LayoutContainer lyoutMid_01_3 = new LayoutContainer();
        lyoutMid_01_3.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_01_3.addListener(Events.Render, new Listener<BaseEvent>() {
        	public void handleEvent(BaseEvent be) {
        		lyoutMid_01_3.removeStyleName("x-border");
		                   //	  layoutContainer_503.setStyleName("x-border-u-top",true);
        		lyoutMid_01_3.setStyleName("x-border-u-bottom",true);
        		lyoutMid_01_3.setHeight("23px");
        	}
        });
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
         ***********************************************************************************************************/ 
        lyoutMid_01_3.setStyleAttribute("background-color", "#dfe8f6");
        LabelField labelfld_01_3 = new LabelField("최종분");
        labelfld_01_3.setStyleAttribute( "text-align", "center"); 
        labelfld_01_3.setBorders(false);
        lyoutMid_01_3.add(labelfld_01_3, new FormData("100%"));
        
        final LayoutContainer lyoutMid_01_4 = new LayoutContainer();
        lyoutMid_01_4.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_01_4.addListener(Events.Render, new Listener<BaseEvent>() {
        	public void handleEvent(BaseEvent be) {
        		lyoutMid_01_4.removeStyleName("x-border");
		                   //	  layoutContainer_503.setStyleName("x-border-u-top",true);
        		lyoutMid_01_4.setStyleName("x-border-u-bottom",true);
        		lyoutMid_01_4.setHeight("23px");
        	}
        });
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
         ***********************************************************************************************************/ 
        lyoutMid_01_4.setStyleAttribute("background-color", "#dfe8f6");
        LabelField labelfld_01_4 = new LabelField("정산(합산)");
        labelfld_01_4.setStyleAttribute( "text-align", "center"); 
        labelfld_01_4.setBorders(false);
        lyoutMid_01_4.add(labelfld_01_4, new FormData("100%"));
        
        
        lyoutMid_01.add(lyoutMid_01_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        lyoutMid_01.add(lyoutMid_01_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
        lyoutMid_01.add(lyoutMid_01_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
        lyoutMid_01.add(lyoutMid_01_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
        
        
        lyoutMid.add(lyoutMid_01);
        
        LayoutContainer lyoutMid_02 = new LayoutContainer(new ColumnLayout());
        lyoutMid_02.setBorders(false);
        
        final LayoutContainer lyoutMid_02_1 = new LayoutContainer();
        lyoutMid_02_1.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutMid_02_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutMid_02_1.setStyleName("x-border-u-bottom", true);
				 lyoutMid_02_1.setHeight("92px");

			}
		       });
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
         ***********************************************************************************************************/  
        LabelField labelfld_02_1 = new LabelField("퇴직소득과세표준계산");
        labelfld_02_1.setStyleAttribute("paddingTop", "15px");
        lyoutMid_02_1.add(labelfld_02_1, new FormData("100%")); 
        lyoutMid_02_1.setStyleAttribute("background-color", "#dfe8f6");
        lyoutMid_02.add(lyoutMid_02_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
        
        
        LayoutContainer lyoutMid_02_2 = new LayoutContainer();
        lyoutMid_02_2.setBorders(false);
        
        
        LayoutContainer lyoutMid_02_2_1 = new LayoutContainer(new ColumnLayout());
        lyoutMid_02_2_1.setBorders(false);
        
        final LayoutContainer lyoutMid_02_2_1_1 = new LayoutContainer();
        lyoutMid_02_2_1_1.setBorders(true);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutMid_02_2_1_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutMid_02_2_1_1.setStyleName("x-border-u-bottom", true);
				lyoutMid_02_2_1_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldMid_02_2_1_1 = new LabelField("퇴직소득");
        labelfldMid_02_2_1_1.setStyleAttribute("background-color", "#dfe8f6");
//        labelfld_02_2_1.setHeight(24);
        labelfldMid_02_2_1_1.setStyleAttribute("paddingTop", "5px");
        labelfldMid_02_2_1_1.setStyleAttribute("vertical-align", "middle"); 
        lyoutMid_02_2_1_1.add(labelfldMid_02_2_1_1, new FormData("100%")); 
		

        
        final LayoutContainer lyoutMid_02_2_1_2 = new LayoutContainer();
        lyoutMid_02_2_1_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_1_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_1_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_1_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 	
        FormLayout formLayoutMid_02_2_1_2 = new FormLayout();
        formLayoutMid_02_2_1_2.setLabelWidth(0);
        lyoutMid_02_2_1_2.setLayout(formLayoutMid_02_2_1_2);

        /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
        retryIncmCtrPymtSum = new MSFNumberField();
        retryIncmCtrPymtSum.setAllowDecimals(true); 
        retryIncmCtrPymtSum.setPropertyEditorType(Long.class); 
        retryIncmCtrPymtSum.setFormat(NumberFormat.getDecimalFormat());
        
//        retryIncmCtrPymtSum.setWidth("160px");
        retryIncmCtrPymtSum.setHideLabel(true);
        retryIncmCtrPymtSum.setReadOnly(true);
        lyoutMid_02_2_1_2.add(retryIncmCtrPymtSum, new FormData("100%"));
        
        
        final LayoutContainer lyoutMid_02_2_1_3 = new LayoutContainer();
        lyoutMid_02_2_1_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_1_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_1_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_1_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 	
        FormLayout formLayoutMid_02_2_1_3 = new FormLayout();
        formLayoutMid_02_2_1_3.setLabelWidth(0);
        lyoutMid_02_2_1_3.setLayout(formLayoutMid_02_2_1_3);
		
		/** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
        retryIncmEndPymtSum = new MSFNumberField();
        retryIncmEndPymtSum.setAllowDecimals(true); 
        retryIncmEndPymtSum.setPropertyEditorType(Long.class); 
        retryIncmEndPymtSum.setFormat(NumberFormat.getDecimalFormat());
        
//        retryIncmEndPymtSum.setWidth("160px");
        retryIncmEndPymtSum.setHideLabel(true);
        retryIncmEndPymtSum.setReadOnly(true);
        lyoutMid_02_2_1_3.add(retryIncmEndPymtSum, new FormData("100%"));
        
        
        final LayoutContainer lyoutMid_02_2_1_4 = new LayoutContainer();
        lyoutMid_02_2_1_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_1_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_1_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_1_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 	
        FormLayout formLayoutMid_02_2_1_4 = new FormLayout();
        formLayoutMid_02_2_1_4.setLabelWidth(0);
        lyoutMid_02_2_1_4.setLayout(formLayoutMid_02_2_1_4);
	    
	    retryIncmClutSum = new MSFNumberField();
        retryIncmClutSum.setAllowDecimals(true); 
        retryIncmClutSum.setPropertyEditorType(Long.class); 
        retryIncmClutSum.setFormat(NumberFormat.getDecimalFormat());
        
//        retryIncmClutSum.setWidth("165px");
        retryIncmClutSum.setHideLabel(true);
        retryIncmClutSum.setReadOnly(true);
        lyoutMid_02_2_1_4.add(retryIncmClutSum, new FormData("100%"));
		
        
        lyoutMid_02_2_1.add(lyoutMid_02_2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_퇴직소득
        lyoutMid_02_2_1.add(lyoutMid_02_2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//중_퇴직소득
        lyoutMid_02_2_1.add(lyoutMid_02_2_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//종_퇴직소득
        lyoutMid_02_2_1.add(lyoutMid_02_2_1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_퇴직소득
        
        

        LayoutContainer lyoutMid_02_2_2 = new LayoutContainer(new ColumnLayout());
        lyoutMid_02_2_2.setBorders(false);
        
        
        final LayoutContainer lyoutMid_02_2_2_1 = new LayoutContainer();
        lyoutMid_02_2_2_1.setBorders(true);
        lyoutMid_02_2_2_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutMid_02_2_2_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutMid_02_2_2_1.setStyleName("x-border-u-bottom", true);
				lyoutMid_02_2_2_1.setHeight("23px");

			}
        });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/          
		 LabelField labelfldMid_02_2_2_1 = new LabelField("퇴직소득정률공제");
//         lblfldNewLabelfield_38.setHeight(24);
		 labelfldMid_02_2_2_1.setStyleAttribute("paddingTop", "5px");
		 labelfldMid_02_2_2_1.setStyleAttribute("vertical-align", "middle"); 
		 labelfldMid_02_2_2_1.setBorders(false);
         lyoutMid_02_2_2_1.add(labelfldMid_02_2_2_1, new FormData("100%"));        
        
        
        
         final LayoutContainer lyoutMid_02_2_2_2 = new LayoutContainer();
         lyoutMid_02_2_2_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
         lyoutMid_02_2_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_2_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_2_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 	
         FormLayout formLayoutMid_02_2_2_2 = new FormLayout();
         formLayoutMid_02_2_2_2.setLabelWidth(0);
         lyoutMid_02_2_2_2.setLayout(formLayoutMid_02_2_2_2);
 	    
         tempNumFld_02_2_2_2 = new MSFNumberField();
//       nmbrfldNewNumberfield_49.setAllowDecimals(true); 
//       nmbrfldNewNumberfield_49.setPropertyEditorType(Long.class); 
//       nmbrfldNewNumberfield_49.setFormat(NumberFormat.getDecimalFormat());
       
         tempNumFld_02_2_2_2.setReadOnly(true);
         tempNumFld_02_2_2_2.setEnabled(false);
//       tempNumFld_02_2_2_2.setWidth("160px");
         tempNumFld_02_2_2_2.setHideLabel(true);
         lyoutMid_02_2_2_2.add(tempNumFld_02_2_2_2, new FormData("100%"));
       
		
		
         final LayoutContainer lyoutMid_02_2_2_3 = new LayoutContainer();
         lyoutMid_02_2_2_3.setBorders(false);
         /**********************************************************************************************************
          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
          ***********************************************************************************************************/
         lyoutMid_02_2_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
 	    	public void handleEvent(BaseEvent be) {
 	    		lyoutMid_02_2_2_3.removeStyleName("x-border");
 		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
 	    		lyoutMid_02_2_2_3.setStyleName("x-border-u-bottom",true);
// 	    		layoutContainer_02_2_2.setHeight("25px");
 	    		}
 	    });
 	    /**********************************************************************************************************
 	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
 	     ***********************************************************************************************************/
		FormLayout formLayoutMid_02_2_2_3 = new FormLayout();
		formLayoutMid_02_2_2_3.setLabelWidth(0);
		lyoutMid_02_2_2_3.setLayout(formLayoutMid_02_2_2_3);
 	    
		tempNumFld_02_2_2_3 = new MSFNumberField();
//       nmbrfldNewNumberfield_49.setAllowDecimals(true); 
//       nmbrfldNewNumberfield_49.setPropertyEditorType(Long.class); 
//       nmbrfldNewNumberfield_49.setFormat(NumberFormat.getDecimalFormat());
		tempNumFld_02_2_2_3.setReadOnly(true);
		tempNumFld_02_2_2_3.setEnabled(false);
//       nmbrfldNewNumberfield_49.setWidth("160px");
		tempNumFld_02_2_2_3.setHideLabel(true);
		lyoutMid_02_2_2_3.add(tempNumFld_02_2_2_3, new FormData("100%"));
         
         

		final LayoutContainer lyoutMid_02_2_2_4 = new LayoutContainer();
		lyoutMid_02_2_2_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_2_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_2_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_2_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
		FormLayout formLayout_02_2_2_4 = new FormLayout();
		formLayout_02_2_2_4.setLabelWidth(0);
		lyoutMid_02_2_2_4.setLayout(formLayout_02_2_2_4);
	    
	    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
        retryFxrtDducClutSum = new MSFNumberField();
        retryFxrtDducClutSum.setAllowDecimals(true); 
        retryFxrtDducClutSum.setPropertyEditorType(Long.class); 
        retryFxrtDducClutSum.setFormat(NumberFormat.getDecimalFormat());
        
//        retryFxrtDducClutSum.setWidth("165px");
        retryFxrtDducClutSum.setHideLabel(true);
        retryFxrtDducClutSum.setReadOnly(true);
        lyoutMid_02_2_2_4.add(retryFxrtDducClutSum, new FormData("100%"));
		
        
        
        lyoutMid_02_2_2.add(lyoutMid_02_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_퇴직소득정률공제
        lyoutMid_02_2_2.add(lyoutMid_02_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//중_퇴직공제
        lyoutMid_02_2_2.add(lyoutMid_02_2_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//종_퇴직공제
        lyoutMid_02_2_2.add(lyoutMid_02_2_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_퇴직공제
        
        
        
        
        LayoutContainer lyoutMid_02_2_3 = new LayoutContainer(new ColumnLayout());
        lyoutMid_02_2_3.setBorders(false);
        
        
        final LayoutContainer lyoutMid_02_2_3_1 = new LayoutContainer();
        lyoutMid_02_2_3_1.setBorders(true);
        lyoutMid_02_2_3_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutMid_02_2_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutMid_02_2_3_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutMid_02_2_3_1.setStyleName("x-border-u-bottom", true);
				lyoutMid_02_2_3_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/  
        LabelField labelfldMid_02_2_3 = new LabelField("근속연수공제");
//        lblfldNewLabelfield_39.setHeight(24);
        labelfldMid_02_2_3.setStyleAttribute("paddingTop", "5px");
        labelfldMid_02_2_3.setStyleAttribute("vertical-align", "middle"); 
        labelfldMid_02_2_3.setBorders(false);
        lyoutMid_02_2_3_1.add(labelfldMid_02_2_3, new FormData("100%"));
        
		
		
        final LayoutContainer lyoutMid_02_2_3_2 = new LayoutContainer();
        lyoutMid_02_2_3_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_3_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_3_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutMid_02_2_3_2 = new FormLayout();
        formLayoutMid_02_2_3_2.setLabelWidth(0);
        lyoutMid_02_2_3_2.setLayout(formLayoutMid_02_2_3_2);
        
        tempNumFld_02_2_3_2 = new MSFNumberField();
//      nmbrfldNewNumberfield_52.setAllowDecimals(true); 
//      nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
//      nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
      
        tempNumFld_02_2_3_2.setReadOnly(true);
        tempNumFld_02_2_3_2.setEnabled(false);
//      nmbrfldNewNumberfield_52.setWidth("160px");
        tempNumFld_02_2_3_2.setHideLabel(true);
        lyoutMid_02_2_3_2.add(tempNumFld_02_2_3_2, new FormData("100%"));
		
		
        final LayoutContainer lyoutMid_02_2_3_3 = new LayoutContainer();
        lyoutMid_02_2_3_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_3_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_3_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_3_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutMid_02_2_3_3 = new FormLayout();
        formLayoutMid_02_2_3_3.setLabelWidth(0);
        lyoutMid_02_2_3_3.setLayout(formLayoutMid_02_2_3_3);
        
        tempNumFld_02_2_3_3 = new MSFNumberField();
//      nmbrfldNewNumberfield_52.setAllowDecimals(true); 
//      nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
//      nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
      
        tempNumFld_02_2_3_3.setReadOnly(true);
        tempNumFld_02_2_3_3.setEnabled(false);
//      nmbrfldNewNumberfield_52.setWidth("160px");
        tempNumFld_02_2_3_3.setHideLabel(true);
        lyoutMid_02_2_3_3.add(tempNumFld_02_2_3_3, new FormData("100%"));
        
        
        
		
        final LayoutContainer lyoutMid_02_2_3_4 = new LayoutContainer();
        lyoutMid_02_2_3_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_3_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_3_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_3_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutMid_02_2_3_4 = new FormLayout();
        formLayoutMid_02_2_3_4.setLabelWidth(0);
        lyoutMid_02_2_3_4.setLayout(formLayoutMid_02_2_3_4);
        
        /** column 근속년수공제_정산금액 : logYrDducSum */
        logYrDducSum = new MSFNumberField();
        logYrDducSum.setAllowDecimals(true); 
        logYrDducSum.setPropertyEditorType(Long.class); 
        logYrDducSum.setFormat(NumberFormat.getDecimalFormat());
        
//        logYrDducSum.setWidth("165px");
        logYrDducSum.setHideLabel(true);
        logYrDducSum.setReadOnly(true);
        lyoutMid_02_2_3_4.add(logYrDducSum, new FormData("100%"));
      
        
        
        lyoutMid_02_2_3.add(lyoutMid_02_2_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_근속연수공제
        lyoutMid_02_2_3.add(lyoutMid_02_2_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//중_근속공제
        lyoutMid_02_2_3.add(lyoutMid_02_2_3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//종_근속공제
        lyoutMid_02_2_3.add(lyoutMid_02_2_3_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_근속공제
        
        
        
        LayoutContainer lyoutMid_02_2_4 = new LayoutContainer(new ColumnLayout());
        
        
        final LayoutContainer lyoutMid_02_2_4_1 = new LayoutContainer();
        lyoutMid_02_2_4_1.setBorders(true);
        lyoutMid_02_2_4_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_4_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutMid_02_2_4_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutMid_02_2_4_1.setStyleName("x-border-u-bottom", true);
				lyoutMid_02_2_4_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldMid_02_2_4_1 = new LabelField("퇴직소득과세표준");
//        lblfldNewLabelfield_40.setHeight(24);
        labelfldMid_02_2_4_1.setStyleAttribute("paddingTop", "5px");
        labelfldMid_02_2_4_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldMid_02_2_4_1.setBorders(false);
        lyoutMid_02_2_4_1.add(labelfldMid_02_2_4_1, new FormData("100%"));  
        
        
        
        final LayoutContainer lyoutMid_02_2_4_2 = new LayoutContainer();
        lyoutMid_02_2_4_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_4_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_4_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_4_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutMid_02_2_4_2 = new FormLayout();
        formLayoutMid_02_2_4_2.setLabelWidth(0);
        lyoutMid_02_2_4_2.setLayout(formLayoutMid_02_2_4_2);
        
        tempNumFld_02_2_4_2 = new MSFNumberField();
//      nmbrfldNewNumberfield_52.setAllowDecimals(true); 
//      nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
//      nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
      
        tempNumFld_02_2_4_2.setReadOnly(true);
        tempNumFld_02_2_4_2.setEnabled(false);
//      nmbrfldNewNumberfield_52.setWidth("160px");
        tempNumFld_02_2_4_2.setHideLabel(true);
        lyoutMid_02_2_4_2.add(tempNumFld_02_2_4_2, new FormData("100%"));
        
        
        final LayoutContainer lyoutMid_02_2_4_3 = new LayoutContainer();
        lyoutMid_02_2_4_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_4_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_4_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_4_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutMid_02_2_4_3 = new FormLayout();
        formLayoutMid_02_2_4_3.setLabelWidth(0);
        lyoutMid_02_2_4_3.setLayout(formLayoutMid_02_2_4_3);
        
        tempNumFld_02_2_4_3 = new MSFNumberField();
//      nmbrfldNewNumberfield_52.setAllowDecimals(true); 
//      nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
//      nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
      
        tempNumFld_02_2_4_3.setReadOnly(true);
        tempNumFld_02_2_4_3.setEnabled(false);
//      nmbrfldNewNumberfield_52.setWidth("160px");
        tempNumFld_02_2_4_3.setHideLabel(true);
        lyoutMid_02_2_4_3.add(tempNumFld_02_2_4_3, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutMid_02_2_4_4 = new LayoutContainer();
        lyoutMid_02_2_4_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutMid_02_2_4_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutMid_02_2_4_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutMid_02_2_4_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutMid_02_2_4_4 = new FormLayout();
        formLayoutMid_02_2_4_4.setLabelWidth(0);
        lyoutMid_02_2_4_4.setLayout(formLayoutMid_02_2_4_4);
        
        /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
        retryTxtnStdClutSum = new MSFNumberField();
        retryTxtnStdClutSum.setAllowDecimals(true); 
        retryTxtnStdClutSum.setPropertyEditorType(Long.class); 
        retryTxtnStdClutSum.setFormat(NumberFormat.getDecimalFormat());
//        retryTxtnStdClutSum.setWidth("165px");
        retryTxtnStdClutSum.setHideLabel(true);
        lyoutMid_02_2_4_4.add(retryTxtnStdClutSum, new FormData("100%"));
        
        
        
        lyoutMid_02_2_4.add(lyoutMid_02_2_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_퇴직소득과세표준
        lyoutMid_02_2_4.add(lyoutMid_02_2_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//중_퇴직과세
        lyoutMid_02_2_4.add(lyoutMid_02_2_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//종_퇴직과세
        lyoutMid_02_2_4.add(lyoutMid_02_2_4_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_퇴직과세
        
        
        lyoutMid_02_2.add(lyoutMid_02_2_1);
        lyoutMid_02_2.add(lyoutMid_02_2_2);
        lyoutMid_02_2.add(lyoutMid_02_2_3);
        lyoutMid_02_2.add(lyoutMid_02_2_4);
        
        lyoutMid_02.add(lyoutMid_02_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));
        
        lyoutMid.add(lyoutMid_02, new FormData("100%"));
        
        layoutContainerItem02.add(lyoutMid, new FormData("100%"));
        
        
        
       
        /** 퇴직소득세액계산 **/
        LayoutContainer lyoutUnder = new LayoutContainer();
        
        LayoutContainer lyoutUnder_01 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_01.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_01_1 = new LayoutContainer();
        lyoutUnder_01_1.setBorders(true);
        lyoutUnder_01_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_01_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_01_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutUnder_01_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_01_1.setHeight("23px");
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
		LabelField labelfldUnder_01_1 = new LabelField("계 산 내 용");
		labelfldUnder_01_1.setStyleAttribute( "text-align", "center"); 
		labelfldUnder_01_1.setBorders(false);
		lyoutUnder_01_1.add(labelfldUnder_01_1, new FormData("100%"));
		
		
		
        final LayoutContainer lyoutUnder_01_2 = new LayoutContainer();
        lyoutUnder_01_2.setBorders(true);
        lyoutUnder_01_2.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_01_2.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_01_2.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutUnder_01_2.setStyleName("x-border-u-bottom", true);
				lyoutUnder_01_2.setHeight("23px");
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
		LabelField labelfldUnder_01_2 = new LabelField("2012.12.31.이전");
		labelfldUnder_01_2.setStyleAttribute( "text-align", "center"); 
		labelfldUnder_01_2.setBorders(false);
		lyoutUnder_01_2.add(labelfldUnder_01_2, new FormData("100%"));
		
		
		
        final LayoutContainer lyoutUnder_01_3 = new LayoutContainer();
        lyoutUnder_01_3.setBorders(true);
        lyoutUnder_01_3.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_01_3.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_01_3.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutUnder_01_3.setStyleName("x-border-u-bottom", true);
				lyoutUnder_01_3.setHeight("23px");
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
		LabelField labelfldUnder_01_3 = new LabelField("2013.1.1.이후");
		labelfldUnder_01_3.setStyleAttribute( "text-align", "center"); 
		labelfldUnder_01_3.setBorders(false);
		lyoutUnder_01_3.add(labelfldUnder_01_3, new FormData("100%"));
		
		
		
        final LayoutContainer lyoutUnder_01_4 = new LayoutContainer();
        lyoutUnder_01_4.setBorders(true);
        lyoutUnder_01_4.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_01_4.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_01_4.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutUnder_01_4.setStyleName("x-border-u-bottom", true);
				lyoutUnder_01_4.setHeight("23px");
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
		LabelField labelfldUnder_01_4 = new LabelField("합 계");
		labelfldUnder_01_4.setStyleAttribute( "text-align", "center"); 
		labelfldUnder_01_4.setBorders(false);
		lyoutUnder_01_4.add(labelfldUnder_01_4, new FormData("100%"));
		
        
        lyoutUnder_01.add(lyoutUnder_01_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        lyoutUnder_01.add(lyoutUnder_01_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
        lyoutUnder_01.add(lyoutUnder_01_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
        lyoutUnder_01.add(lyoutUnder_01_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
        lyoutUnder.add(lyoutUnder_01);
        
        LayoutContainer lyoutUnder_02 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_1 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_1.setBorders(true);
        lyoutUnder_02_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
		lyoutUnder_02_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutUnder_02_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_1.setHeight("184px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/  
        LabelField labelfldUnder_02_1 = new LabelField("퇴직소득세액계산");
        labelfldUnder_02_1.setStyleAttribute("paddingTop", "15px");
        lyoutUnder_02_1.add(labelfldUnder_02_1, new FormData("100%"));
        lyoutUnder_02.add(lyoutUnder_02_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
        
        LayoutContainer lyoutUnder_02_2 = new LayoutContainer();
        lyoutUnder_02_2.setBorders(false);
        
        LayoutContainer lyoutUnder_02_2_1 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_1.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_1_1 = new LayoutContainer();
        lyoutUnder_02_2_1_1.setBorders(true);
        lyoutUnder_02_2_1_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_1_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_1_1.removeStyleName("x-border");
				// layoutContainer_503.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_1_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_1_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_1_1 = new LabelField("과세표준안분");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_1_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_1_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_1_1.setBorders(false);
        lyoutUnder_02_2_1_1.add(labelfldUnder_02_2_1_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_1_2 = new LayoutContainer();
        lyoutUnder_02_2_1_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_1_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_1_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_1_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_1_2 = new FormLayout();
        formLayoutUnder_02_2_1_2.setLabelWidth(0);
        lyoutUnder_02_2_1_2.setLayout(formLayoutUnder_02_2_1_2);
        
        /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
        tat12befTxtnStdPpnlSum = new MSFNumberField();
        tat12befTxtnStdPpnlSum.setAllowDecimals(true); 
        tat12befTxtnStdPpnlSum.setPropertyEditorType(Long.class); 
        tat12befTxtnStdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tat12befTxtnStdPpnlSum.setWidth("160px");
        tat12befTxtnStdPpnlSum.setHideLabel(true);
        tat12befTxtnStdPpnlSum.setReadOnly(true);
        lyoutUnder_02_2_1_2.add(tat12befTxtnStdPpnlSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_1_3 = new LayoutContainer();
        lyoutUnder_02_2_1_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_1_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_1_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_1_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_1_3 = new FormLayout();
        formLayoutUnder_02_2_1_3.setLabelWidth(0);
        lyoutUnder_02_2_1_3.setLayout(formLayoutUnder_02_2_1_3);
        
        /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
        tat13afrTxstdPpnlSum = new MSFNumberField();
        tat13afrTxstdPpnlSum.setAllowDecimals(true); 
        tat13afrTxstdPpnlSum.setPropertyEditorType(Long.class); 
        tat13afrTxstdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tat13afrTxstdPpnlSum.setWidth("160px");
        tat13afrTxstdPpnlSum.setHideLabel(true);
        tat13afrTxstdPpnlSum.setReadOnly(true);
        lyoutUnder_02_2_1_3.add(tat13afrTxstdPpnlSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_1_4 = new LayoutContainer();
        lyoutUnder_02_2_1_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_1_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_1_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_1_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_1_4 = new FormLayout();
        formLayoutUnder_02_2_1_4.setLabelWidth(0);
        lyoutUnder_02_2_1_4.setLayout(formLayoutUnder_02_2_1_4);
        
        /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
        tatAggrTxtnStdPpnlSum = new MSFNumberField();
        tatAggrTxtnStdPpnlSum.setAllowDecimals(true); 
        tatAggrTxtnStdPpnlSum.setPropertyEditorType(Long.class); 
        tatAggrTxtnStdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tatAggrTxtnStdPpnlSum.setWidth("165px");
        tatAggrTxtnStdPpnlSum.setHideLabel(true);
        tatAggrTxtnStdPpnlSum.setReadOnly(true);
        lyoutUnder_02_2_1_4.add(tatAggrTxtnStdPpnlSum, new FormData("100%"));
        
        lyoutUnder_02_2_1.add(lyoutUnder_02_2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_과세표준안분
        lyoutUnder_02_2_1.add(lyoutUnder_02_2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_과세표준
        lyoutUnder_02_2_1.add(lyoutUnder_02_2_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_퇴직과세
        lyoutUnder_02_2_1.add(lyoutUnder_02_2_1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_퇴직과세
        lyoutUnder_02_2.add(lyoutUnder_02_2_1);
        
        
        
        LayoutContainer lyoutUnder_02_2_2 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_2.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_2_1 = new LayoutContainer();
        lyoutUnder_02_2_2_1.setBorders(true);
        lyoutUnder_02_2_2_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_2_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_2_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_2_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_2_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_2_1 = new LabelField("연평균과세표준");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_2_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_2_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_2_1.setBorders(false);
        lyoutUnder_02_2_2_1.add(labelfldUnder_02_2_2_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_2_2 = new LayoutContainer();
        lyoutUnder_02_2_2_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_2_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_2_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_2_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_2_2 = new FormLayout();
        formLayoutUnder_02_2_2_2.setLabelWidth(0);
        lyoutUnder_02_2_2_2.setLayout(formLayoutUnder_02_2_2_2);
        
        /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
        tat12befYravgTxstdSum = new MSFNumberField();
        tat12befYravgTxstdSum.setAllowDecimals(true); 
        tat12befYravgTxstdSum.setPropertyEditorType(Long.class); 
        tat12befYravgTxstdSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tat12befYravgTxstdSum.setWidth("160px");
        tat12befYravgTxstdSum.setHideLabel(true);
        tat12befYravgTxstdSum.setReadOnly(true);
        lyoutUnder_02_2_2_2.add(tat12befYravgTxstdSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_2_3 = new LayoutContainer();
        lyoutUnder_02_2_2_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_2_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_2_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_2_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_2_3 = new FormLayout();
        formLayoutUnder_02_2_2_3.setLabelWidth(0);
        lyoutUnder_02_2_2_3.setLayout(formLayoutUnder_02_2_2_3);
        
        /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
        tat13afrYrAvgStdSum = new MSFNumberField();
        tat13afrYrAvgStdSum.setAllowDecimals(true); 
        tat13afrYrAvgStdSum.setPropertyEditorType(Long.class); 
        tat13afrYrAvgStdSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tat13afrYrAvgStdSum.setWidth("160px");
        tat13afrYrAvgStdSum.setHideLabel(true);
        tat13afrYrAvgStdSum.setReadOnly(true);
        lyoutUnder_02_2_2_3.add(tat13afrYrAvgStdSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_2_4 = new LayoutContainer();
        lyoutUnder_02_2_2_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_2_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_2_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_2_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_2_4 = new FormLayout();
        formLayoutUnder_02_2_2_4.setLabelWidth(0);
        lyoutUnder_02_2_2_4.setLayout(formLayoutUnder_02_2_2_4);
        
        /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum REadonly 데이타없음.*/
        tatAggrYrAvgTxtnStdSum = new MSFNumberField();
        tatAggrYrAvgTxtnStdSum.setAllowDecimals(true); 
        tatAggrYrAvgTxtnStdSum.setPropertyEditorType(Long.class); 
        tatAggrYrAvgTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
        tatAggrYrAvgTxtnStdSum.setReadOnly(true);
      //  tatAggrYrAvgTxtnStdSum.setEnabled(false);
//        tatAggrYrAvgTxtnStdSum.setWidth("165px");
        tatAggrYrAvgTxtnStdSum.setHideLabel(true);
        lyoutUnder_02_2_2_4.add(tatAggrYrAvgTxtnStdSum, new FormData("100%"));
        
        
        
        lyoutUnder_02_2_2.add(lyoutUnder_02_2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_연평균과세표준
        lyoutUnder_02_2_2.add(lyoutUnder_02_2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_연평균과세
        lyoutUnder_02_2_2.add(lyoutUnder_02_2_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_연평균과세
        lyoutUnder_02_2_2.add(lyoutUnder_02_2_2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_연평균과세
        lyoutUnder_02_2.add(lyoutUnder_02_2_2);
        
        
        
        LayoutContainer lyoutUnder_02_2_3 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_3.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_3_1 = new LayoutContainer();
        lyoutUnder_02_2_3_1.setBorders(true);
        lyoutUnder_02_2_3_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_3_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_3_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_3_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_3_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_3_1 = new LabelField("환산과세표준");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_3_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_3_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_3_1.setBorders(false);
        lyoutUnder_02_2_3_1.add(labelfldUnder_02_2_3_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_3_2 = new LayoutContainer();
        lyoutUnder_02_2_3_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_3_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_3_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_3_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_3_2 = new FormLayout();
        formLayoutUnder_02_2_3_2.setLabelWidth(0);
        lyoutUnder_02_2_3_2.setLayout(formLayoutUnder_02_2_3_2);
        
        /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum readonly*/
        tat12befCvsnTxtnStdSum = new MSFNumberField();
        tat12befCvsnTxtnStdSum.setAllowDecimals(true); 
        tat12befCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
        tat12befCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
        tat12befCvsnTxtnStdSum.setReadOnly(true);
       // tat12befCvsnTxtnStdSum.setEnabled(false);
//        tat12befCvsnTxtnStdSum.setWidth("160px");
        tat12befCvsnTxtnStdSum.setHideLabel(true);
        lyoutUnder_02_2_3_2.add(tat12befCvsnTxtnStdSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_3_3 = new LayoutContainer();
        lyoutUnder_02_2_3_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_3_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_3_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_3_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_3_3 = new FormLayout();
        formLayoutUnder_02_2_3_3.setLabelWidth(0);
        lyoutUnder_02_2_3_3.setLayout(formLayoutUnder_02_2_3_3);
        
        /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
        tat13afrCvsnTxtnStdSum = new MSFNumberField();
        tat13afrCvsnTxtnStdSum.setAllowDecimals(true); 
        tat13afrCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
        tat13afrCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tat13afrCvsnTxtnStdSum.setWidth("160px");
        tat13afrCvsnTxtnStdSum.setHideLabel(true);
        tat13afrCvsnTxtnStdSum.setReadOnly(true);
        lyoutUnder_02_2_3_3.add(tat13afrCvsnTxtnStdSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_3_4 = new LayoutContainer();
        lyoutUnder_02_2_3_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_3_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_3_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_3_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_3_4 = new FormLayout();
        formLayoutUnder_02_2_3_4.setLabelWidth(0);
        lyoutUnder_02_2_3_4.setLayout(formLayoutUnder_02_2_3_4);
        
        /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
        tatAggrCvsnTxtnStdSum = new MSFNumberField();
        tatAggrCvsnTxtnStdSum.setAllowDecimals(true); 
        tatAggrCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
        tatAggrCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tatAggrCvsnTxtnStdSum.setWidth("165px");
        tatAggrCvsnTxtnStdSum.setHideLabel(true);
        tatAggrCvsnTxtnStdSum.setReadOnly(true);
        lyoutUnder_02_2_3_4.add(tatAggrCvsnTxtnStdSum, new FormData("100%"));
        
        
        lyoutUnder_02_2_3.add(lyoutUnder_02_2_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_환산과세표준
        lyoutUnder_02_2_3.add(lyoutUnder_02_2_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_환산과세
        lyoutUnder_02_2_3.add(lyoutUnder_02_2_3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_환산과세
        lyoutUnder_02_2_3.add(lyoutUnder_02_2_3_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_환산과세
        lyoutUnder_02_2.add(lyoutUnder_02_2_3);
        
        
        
        LayoutContainer lyoutUnder_02_2_4 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_4.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_4_1 = new LayoutContainer();
        lyoutUnder_02_2_4_1.setBorders(true);
        lyoutUnder_02_2_4_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_4_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_4_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_4_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_4_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_4_1 = new LabelField("환산산출세액");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_4_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_4_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_4_1.setBorders(false);
        lyoutUnder_02_2_4_1.add(labelfldUnder_02_2_4_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_4_2 = new LayoutContainer();
        lyoutUnder_02_2_4_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_4_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_4_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_4_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_4_2 = new FormLayout();
        formLayoutUnder_02_2_4_2.setLabelWidth(0);
        lyoutUnder_02_2_4_2.setLayout(formLayoutUnder_02_2_4_2);
        
        /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt readonly*/
        tat12befCvsnCalcAmnt = new MSFNumberField();
        tat12befCvsnCalcAmnt.setAllowDecimals(true); 
        tat12befCvsnCalcAmnt.setPropertyEditorType(Long.class); 
        tat12befCvsnCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
        tat12befCvsnCalcAmnt.setReadOnly(true);
       // tat12befCvsnCalcAmnt.setEnabled(false);
//        tat12befCvsnCalcAmnt.setWidth("160px");
        tat12befCvsnCalcAmnt.setHideLabel(true);
        lyoutUnder_02_2_4_2.add(tat12befCvsnCalcAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_4_3 = new LayoutContainer();
        lyoutUnder_02_2_4_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_4_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_4_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_4_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_4_3 = new FormLayout();
        formLayoutUnder_02_2_4_3.setLabelWidth(0);
        lyoutUnder_02_2_4_3.setLayout(formLayoutUnder_02_2_4_3);
        
        /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
        tat13afrCvsnCalcTxAmnt = new MSFNumberField();
        tat13afrCvsnCalcTxAmnt.setAllowDecimals(true); 
        tat13afrCvsnCalcTxAmnt.setPropertyEditorType(Long.class); 
        tat13afrCvsnCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tat13afrCvsnCalcTxAmnt.setWidth("160px");
        tat13afrCvsnCalcTxAmnt.setHideLabel(true);
        tat13afrCvsnCalcTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_4_3.add(tat13afrCvsnCalcTxAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_4_4 = new LayoutContainer();
        lyoutUnder_02_2_4_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_4_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_4_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_4_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_4_4 = new FormLayout();
        formLayoutUnder_02_2_4_4.setLabelWidth(0);
        lyoutUnder_02_2_4_4.setLayout(formLayoutUnder_02_2_4_4);
        
        /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
        tatAggrCvsnCalcTxAmnt = new MSFNumberField();
        tatAggrCvsnCalcTxAmnt.setAllowDecimals(true); 
        tatAggrCvsnCalcTxAmnt.setPropertyEditorType(Long.class); 
        tatAggrCvsnCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tatAggrCvsnCalcTxAmnt.setWidth("165px");
        tatAggrCvsnCalcTxAmnt.setHideLabel(true);
        tatAggrCvsnCalcTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_4_4.add(tatAggrCvsnCalcTxAmnt, new FormData("100%"));
        
        
        lyoutUnder_02_2_4.add(lyoutUnder_02_2_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_환산산출세액
        lyoutUnder_02_2_4.add(lyoutUnder_02_2_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_환산산출
        lyoutUnder_02_2_4.add(lyoutUnder_02_2_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_환산산출
        lyoutUnder_02_2_4.add(lyoutUnder_02_2_4_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_환산산출
        lyoutUnder_02_2.add(lyoutUnder_02_2_4);
        
        
        
        LayoutContainer lyoutUnder_02_2_5 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_5.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_5_1 = new LayoutContainer();
        lyoutUnder_02_2_5_1.setBorders(true);
        lyoutUnder_02_2_5_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_5_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_5_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_5_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_5_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_5_1 = new LabelField("연평균산출세액");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_5_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_5_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_5_1.setBorders(false);
        lyoutUnder_02_2_5_1.add(labelfldUnder_02_2_5_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_5_2 = new LayoutContainer();
        lyoutUnder_02_2_5_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_5_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_5_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_5_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_5_2 = new FormLayout();
        formLayoutUnder_02_2_5_2.setLabelWidth(0);
        lyoutUnder_02_2_5_2.setLayout(formLayoutUnder_02_2_5_2);
        
	     /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
	     tat12befYrAvgCalcAmnt = new MSFNumberField();
	     tat12befYrAvgCalcAmnt.setAllowDecimals(true); 
	     tat12befYrAvgCalcAmnt.setPropertyEditorType(Long.class); 
	     tat12befYrAvgCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
	     
//	     tat12befYrAvgCalcAmnt.setWidth("160px");
	     tat12befYrAvgCalcAmnt.setHideLabel(true);
	     tat12befYrAvgCalcAmnt.setReadOnly(true);
	     lyoutUnder_02_2_5_2.add(tat12befYrAvgCalcAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_5_3 = new LayoutContainer();
        lyoutUnder_02_2_5_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_5_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_5_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_5_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_5_3 = new FormLayout();
        formLayoutUnder_02_2_5_3.setLabelWidth(0);
        lyoutUnder_02_2_5_3.setLayout(formLayoutUnder_02_2_5_3);
        
	     /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
	     tat13afrYrAvgCalcAmnt = new MSFNumberField();
	     tat13afrYrAvgCalcAmnt.setAllowDecimals(true); 
	     tat13afrYrAvgCalcAmnt.setPropertyEditorType(Long.class); 
	     tat13afrYrAvgCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
	     
//	     tat13afrYrAvgCalcAmnt.setWidth("160px");
	     tat13afrYrAvgCalcAmnt.setHideLabel(true);
	     tat13afrYrAvgCalcAmnt.setReadOnly(true);
	     lyoutUnder_02_2_5_3.add(tat13afrYrAvgCalcAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_5_4 = new LayoutContainer();
        lyoutUnder_02_2_5_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_5_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_5_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_5_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_5_4 = new FormLayout();
        formLayoutUnder_02_2_5_4.setLabelWidth(0);
        lyoutUnder_02_2_5_4.setLayout(formLayoutUnder_02_2_5_4);
        
	     /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
	     tatAggrYrAvgCalcTxAmnt = new MSFNumberField();
	     tatAggrYrAvgCalcTxAmnt.setAllowDecimals(true); 
	     tatAggrYrAvgCalcTxAmnt.setPropertyEditorType(Long.class); 
	     tatAggrYrAvgCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
	     
//	     tatAggrYrAvgCalcTxAmnt.setWidth("165px");
	     tatAggrYrAvgCalcTxAmnt.setHideLabel(true);
	     tatAggrYrAvgCalcTxAmnt.setReadOnly(true);
	     lyoutUnder_02_2_5_4.add(tatAggrYrAvgCalcTxAmnt, new FormData("100%"));
        
        
        lyoutUnder_02_2_5.add(lyoutUnder_02_2_5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_연평균산출세액
        lyoutUnder_02_2_5.add(lyoutUnder_02_2_5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_연평균산출
        lyoutUnder_02_2_5.add(lyoutUnder_02_2_5_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_연평균산출
        lyoutUnder_02_2_5.add(lyoutUnder_02_2_5_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_연평균산출
        lyoutUnder_02_2.add(lyoutUnder_02_2_5);
        
        
        LayoutContainer lyoutUnder_02_2_6 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_6.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_6_1 = new LayoutContainer();
        lyoutUnder_02_2_6_1.setBorders(true);
        lyoutUnder_02_2_6_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_6_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_6_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_6_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_6_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_6_1 = new LabelField("산출세액");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_6_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_6_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_6_1.setBorders(false);
        lyoutUnder_02_2_6_1.add(labelfldUnder_02_2_6_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_6_2 = new LayoutContainer();
        lyoutUnder_02_2_6_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_6_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_6_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_6_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_6_2 = new FormLayout();
        formLayoutUnder_02_2_6_2.setLabelWidth(0);
        lyoutUnder_02_2_6_2.setLayout(formLayoutUnder_02_2_6_2);
        
        /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
        tat12befCalcTxAmnt = new MSFNumberField();
        tat12befCalcTxAmnt.setAllowDecimals(true); 
        tat12befCalcTxAmnt.setPropertyEditorType(Long.class); 
        tat12befCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tat12befCalcTxAmnt.setWidth("160px");
        tat12befCalcTxAmnt.setHideLabel(true);
        tat12befCalcTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_6_2.add(tat12befCalcTxAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_6_3 = new LayoutContainer();
        lyoutUnder_02_2_6_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_6_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_6_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_6_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_6_3 = new FormLayout();
        formLayoutUnder_02_2_6_3.setLabelWidth(0);
        lyoutUnder_02_2_6_3.setLayout(formLayoutUnder_02_2_6_3);
        
        /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
        tat13afrCalcTxAmnt = new MSFNumberField();
        tat13afrCalcTxAmnt.setAllowDecimals(true); 
        tat13afrCalcTxAmnt.setPropertyEditorType(Long.class); 
        tat13afrCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tat13afrCalcTxAmnt.setWidth("160px");
        tat13afrCalcTxAmnt.setHideLabel(true);
        tat13afrCalcTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_6_3.add(tat13afrCalcTxAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_6_4 = new LayoutContainer();
        lyoutUnder_02_2_6_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_6_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_6_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_6_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_6_4 = new FormLayout();
        formLayoutUnder_02_2_6_4.setLabelWidth(0);
        lyoutUnder_02_2_6_4.setLayout(formLayoutUnder_02_2_6_4);
        
        /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
        tatAggrCalcTxAmnt = new MSFNumberField();
        tatAggrCalcTxAmnt.setAllowDecimals(true); 
        tatAggrCalcTxAmnt.setPropertyEditorType(Long.class); 
        tatAggrCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tatAggrCalcTxAmnt.setWidth("165px");
        tatAggrCalcTxAmnt.setHideLabel(true);
        tatAggrCalcTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_6_4.add(tatAggrCalcTxAmnt, new FormData("100%"));
        
        
        lyoutUnder_02_2_6.add(lyoutUnder_02_2_6_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_산출세액
        lyoutUnder_02_2_6.add(lyoutUnder_02_2_6_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_산출세액
        lyoutUnder_02_2_6.add(lyoutUnder_02_2_6_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_산출세액
        lyoutUnder_02_2_6.add(lyoutUnder_02_2_6_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_산출세액
        lyoutUnder_02_2.add(lyoutUnder_02_2_6);
        
        
        LayoutContainer lyoutUnder_02_2_7 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_7.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_7_1 = new LayoutContainer();
        lyoutUnder_02_2_7_1.setBorders(true);
        lyoutUnder_02_2_7_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_7_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_7_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_7_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_7_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_7_1 = new LabelField("기납부(또는 기과세이연)세액");
        labelfldUnder_02_2_7_1.setStyleAttribute("font-size", "10px");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_7_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_7_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_7_1.setBorders(false);
        lyoutUnder_02_2_7_1.add(labelfldUnder_02_2_7_1, new FormData("100%"));
        
        final LayoutContainer lyoutUnder_02_2_7_2 = new LayoutContainer();
        lyoutUnder_02_2_7_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_7_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_7_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_7_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_7_2 = new FormLayout();
        formLayoutUnder_02_2_7_2.setLabelWidth(0);
        lyoutUnder_02_2_7_2.setLayout(formLayoutUnder_02_2_7_2);
        
        /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt readonly*/
        tat12befAlpayTxAmnt = new MSFNumberField();
        tat12befAlpayTxAmnt.setAllowDecimals(true); 
        tat12befAlpayTxAmnt.setPropertyEditorType(Long.class); 
        tat12befAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        tat12befAlpayTxAmnt.setReadOnly(true);
        //tat12befAlpayTxAmnt.setEnabled(false);
//        tat12befAlpayTxAmnt.setWidth("160px");
        tat12befAlpayTxAmnt.setHideLabel(true);
        lyoutUnder_02_2_7_2.add(tat12befAlpayTxAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_7_3 = new LayoutContainer();
        lyoutUnder_02_2_7_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_7_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_7_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_7_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_7_3 = new FormLayout();
        formLayoutUnder_02_2_7_3.setLabelWidth(0);
        lyoutUnder_02_2_7_3.setLayout(formLayoutUnder_02_2_7_3);
        
        /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt readonly*/
        tat13afrAlpayTxAmnt = new MSFNumberField();
        tat13afrAlpayTxAmnt.setAllowDecimals(true); 
        tat13afrAlpayTxAmnt.setPropertyEditorType(Long.class); 
        tat13afrAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        tat13afrAlpayTxAmnt.setReadOnly(true);
      //  tat13afrAlpayTxAmnt.setEnabled(false);
//        tat13afrAlpayTxAmnt.setWidth("160px");
        tat13afrAlpayTxAmnt.setHideLabel(true);
        lyoutUnder_02_2_7_3.add(tat13afrAlpayTxAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_7_4 = new LayoutContainer();
        lyoutUnder_02_2_7_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_7_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_7_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_7_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_7_4 = new FormLayout();
        formLayoutUnder_02_2_7_4.setLabelWidth(0);
        lyoutUnder_02_2_7_4.setLayout(formLayoutUnder_02_2_7_4);
        
        /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
        tatAggrAlpayTxAmnt = new MSFNumberField();
        tatAggrAlpayTxAmnt.setAllowDecimals(true); 
        tatAggrAlpayTxAmnt.setPropertyEditorType(Long.class); 
        tatAggrAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tatAggrAlpayTxAmnt.setWidth("165px");
        tatAggrAlpayTxAmnt.setHideLabel(true);
        tatAggrAlpayTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_7_4.add(tatAggrAlpayTxAmnt, new FormData("100%"));
        
        lyoutUnder_02_2_7.add(lyoutUnder_02_2_7_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_기납부(또는 기과세이연)세액
        lyoutUnder_02_2_7.add(lyoutUnder_02_2_7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_기납부
        lyoutUnder_02_2_7.add(lyoutUnder_02_2_7_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_기납부
        lyoutUnder_02_2_7.add(lyoutUnder_02_2_7_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_기납부
        lyoutUnder_02_2.add(lyoutUnder_02_2_7);
        
        
        LayoutContainer lyoutUnder_02_2_8 = new LayoutContainer(new ColumnLayout());
        lyoutUnder_02_2_8.setBorders(false);
        
        
        final LayoutContainer lyoutUnder_02_2_8_1 = new LayoutContainer();
        lyoutUnder_02_2_8_1.setBorders(true);
        lyoutUnder_02_2_8_1.setStyleAttribute("background-color", "#dfe8f6");
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_8_1.addListener(Events.Render, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				lyoutUnder_02_2_8_1.removeStyleName("x-border");
				// lyoutUnder_02_2_2_1.setStyleName("x-border-u-top",true);
				lyoutUnder_02_2_8_1.setStyleName("x-border-u-bottom", true);
				lyoutUnder_02_2_8_1.setHeight("23px");

			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
        LabelField labelfldUnder_02_2_8_1 = new LabelField("신고대상세액");
//        labelfldUnder_02_2_1_1.setHeight(24);
        labelfldUnder_02_2_8_1.setStyleAttribute("paddingTop", "5px");
        labelfldUnder_02_2_8_1.setStyleAttribute("vertical-align", "middle"); 
        labelfldUnder_02_2_8_1.setBorders(false);
        lyoutUnder_02_2_8_1.add(labelfldUnder_02_2_8_1, new FormData("100%"));
        
        
        final LayoutContainer lyoutUnder_02_2_8_2 = new LayoutContainer();
        lyoutUnder_02_2_8_2.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_8_2.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_8_2.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_8_2.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_8_2 = new FormLayout();
        formLayoutUnder_02_2_8_2.setLabelWidth(0);
        lyoutUnder_02_2_8_2.setLayout(formLayoutUnder_02_2_8_2);
        
        /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt readonly*/
        tat12befRegTgtTxAmnt = new MSFNumberField();
        tat12befRegTgtTxAmnt.setAllowDecimals(true); 
        tat12befRegTgtTxAmnt.setPropertyEditorType(Long.class); 
        tat12befRegTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        tat12befRegTgtTxAmnt.setReadOnly(true);
     //   tat12befRegTgtTxAmnt.setEnabled(false);
//        tat12befRegTgtTxAmnt.setWidth("160px");
        tat12befRegTgtTxAmnt.setHideLabel(true);
        lyoutUnder_02_2_8_2.add(tat12befRegTgtTxAmnt, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_8_3 = new LayoutContainer();
        lyoutUnder_02_2_8_3.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_8_3.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_8_3.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_8_3.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_8_3 = new FormLayout();
        formLayoutUnder_02_2_8_3.setLabelWidth(0);
        lyoutUnder_02_2_8_3.setLayout(formLayoutUnder_02_2_8_3);
        
        /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
        tat13afrRegrstTgtSum = new MSFNumberField();
        tat13afrRegrstTgtSum.setAllowDecimals(true); 
        tat13afrRegrstTgtSum.setPropertyEditorType(Long.class); 
        tat13afrRegrstTgtSum.setFormat(NumberFormat.getDecimalFormat());
        
//        tat13afrRegrstTgtSum.setWidth("160px");
        tat13afrRegrstTgtSum.setHideLabel(true);
        tat13afrRegrstTgtSum.setReadOnly(true);
        lyoutUnder_02_2_8_3.add(tat13afrRegrstTgtSum, new FormData("100%"));
        
        
        
        final LayoutContainer lyoutUnder_02_2_8_4 = new LayoutContainer();
        lyoutUnder_02_2_8_4.setBorders(false);
        /**********************************************************************************************************
         * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
         ***********************************************************************************************************/
        lyoutUnder_02_2_8_4.addListener(Events.Render, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		lyoutUnder_02_2_8_4.removeStyleName("x-border");
		                   //	  layoutContainer_504.setStyleName("x-border-u-top",true);
	    		lyoutUnder_02_2_8_4.setStyleName("x-border-u-bottom",true);
//	    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
        FormLayout formLayoutUnder_02_2_8_4 = new FormLayout();
        formLayoutUnder_02_2_8_4.setLabelWidth(0);
        lyoutUnder_02_2_8_4.setLayout(formLayoutUnder_02_2_8_4);
        
        /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
        tatAggrRegrstTgtTxAmnt = new MSFNumberField();
        tatAggrRegrstTgtTxAmnt.setAllowDecimals(true); 
        tatAggrRegrstTgtTxAmnt.setPropertyEditorType(Long.class); 
        tatAggrRegrstTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
        
//        tatAggrRegrstTgtTxAmnt.setWidth("165px");
        tatAggrRegrstTgtTxAmnt.setHideLabel(true);
        tatAggrRegrstTgtTxAmnt.setReadOnly(true);
        lyoutUnder_02_2_8_4.add(tatAggrRegrstTgtTxAmnt, new FormData("100%"));
        
        lyoutUnder_02_2_8.add(lyoutUnder_02_2_8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.265));	//header_신고대상세액
        lyoutUnder_02_2_8.add(lyoutUnder_02_2_8_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2012_신고대상
        lyoutUnder_02_2_8.add(lyoutUnder_02_2_8_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.242));	//2013_신고대상
        lyoutUnder_02_2_8.add(lyoutUnder_02_2_8_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.251));	//합_신고대상
        lyoutUnder_02_2.add(lyoutUnder_02_2_8);
        
        
        
        lyoutUnder_02.add(lyoutUnder_02_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));
        
        
        
        
        lyoutUnder.add(lyoutUnder_02);
        
        
        
        layoutContainerItem02.add(lyoutUnder, new FormData("100%"));
       
        
        
        
		    
		    
		    
	        
	        /****** 임시 주석 *******/
//		LayoutContainer hBoxTopFrm = new LayoutContainer();
//		HBoxLayout hbLayout = new HBoxLayout();
//		hbLayout.setPadding(new Padding(0));
//		hbLayout.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);
//		hBoxTopFrm.setLayout(hbLayout);        
//        
//		    //11개의 걸럼
//		    LayoutContainer hBoxTopFrm = new LayoutContainer();  
//	        HBoxLayout hbLayout = new HBoxLayout();  
//	        hbLayout.setPadding(new Padding(0));  
//	        hbLayout.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
//	        hBoxTopFrm.setLayout(hbLayout);
//	        
//	        
//	        //1
//	        LayoutContainer layoutContainer_1502 = new LayoutContainer(new FitLayout());
//	        //FormLayout frmlytSch = new FormLayout();  
//            //frmlytSch.setLabelWidth(0); 
//            //frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            //layoutContainer_1502.setLayout(frmlytSch);
//            layoutContainer_1502.setBorders(true); 
//		    layoutContainer_1502.setWidth(25);
//		    
//		    //2
//	        LayoutContainer layoutContainer_2502 = new LayoutContainer();
//	        FormLayout frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_2502.setLayout(frmlytSch);
//            layoutContainer_2502.setBorders(true); 
//            layoutContainer_2502.setWidth(88);
//		    
//		    //3
//	        LayoutContainer layoutContainer_3502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_3502.setLayout(frmlytSch);
//            layoutContainer_3502.setBorders(true); 
//            layoutContainer_3502.setWidth(65);
//		    
//		    //4
//	        LayoutContainer layoutContainer_4502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_4502.setLayout(frmlytSch);
//            layoutContainer_4502.setBorders(true); 
//            layoutContainer_4502.setWidth(65);
//          //5
//	        LayoutContainer layoutContainer_5502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_5502.setLayout(frmlytSch);
//            layoutContainer_5502.setBorders(true); 
//            layoutContainer_5502.setWidth(65);
//            
//          //6
//	        LayoutContainer layoutContainer_6502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_6502.setLayout(frmlytSch);
//            layoutContainer_6502.setBorders(true); 
//            layoutContainer_6502.setWidth(65);
//            
//         
//          //7
//	        LayoutContainer layoutContainer_7502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_7502.setLayout(frmlytSch);
//            layoutContainer_7502.setBorders(true); 
//            layoutContainer_7502.setWidth(55);
//          //8
//	        LayoutContainer layoutContainer_8502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_8502.setLayout(frmlytSch);
//            layoutContainer_8502.setBorders(true); 
//            layoutContainer_8502.setWidth(55);
//          //9
//	        LayoutContainer layoutContainer_9502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_9502.setLayout(frmlytSch);
//            layoutContainer_9502.setBorders(true); 
//            layoutContainer_9502.setWidth(55);
//          //10
//	        LayoutContainer layoutContainer_10502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_10502.setLayout(frmlytSch);
//            layoutContainer_10502.setBorders(true); 
//            layoutContainer_10502.setWidth(55);
//            //11
//	        LayoutContainer layoutContainer_11502 = new LayoutContainer();
//            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(0); 
//            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//            layoutContainer_11502.setLayout(frmlytSch);
//            layoutContainer_11502.setBorders(true); 
//            layoutContainer_11502.setWidth(55);
//         
//
//		    hBoxTopFrm.add(layoutContainer_1502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_2502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_3502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_4502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_5502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_6502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_7502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_8502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_9502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_10502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//		    hBoxTopFrm.add(layoutContainer_11502, new HBoxLayoutData(new Margins(0)));  
//		    
//  
//	       layoutContainer_2.add(hBoxTopFrm);
//	      // layoutContainer_2.setStyleAttribute("padding-bottom", "5px");
//	       layoutContainerItem02.add(layoutContainer_2);
//		     
//	      // layoutContainer_1502
//	      final LayoutContainer layoutContainer_16 = new LayoutContainer(new FitLayout());
//	       layoutContainer_16.setStyleAttribute("background-color", "#dfe8f6"); 
//	       layoutContainer_16.setBorders(false);
//	       /**********************************************************************************************************
//            * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//            ***********************************************************************************************************/
//	       layoutContainer_16.addListener(Events.Render, new Listener<BaseEvent>() {
//		                   public void handleEvent(BaseEvent be) {
//		                
//		                	   layoutContainer_16.removeStyleName("x-border");
//                         	// layoutContainer_16.setStyleName("x-border-u-right",true);
//		                	   layoutContainer_16.setStyleName("x-border-u-bottom",true);
//		                	   layoutContainer_16.setHeight("22px");  
//		                   }
//		       });
//		    /**********************************************************************************************************
//             * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//	         ***********************************************************************************************************/  
//           LabelField lblfldNewLabelfield_15 = new LabelField("근속연수");
//           lblfldNewLabelfield_15.setStyleAttribute( "text-align", "center"); 
//           layoutContainer_16.add(lblfldNewLabelfield_15, new FormData("100%"));
//           layoutContainer_1502.add(layoutContainer_16); 
//           
//		    
//            
//		  //  hBoxTopFrm.add(layoutContainer_2502, new HBoxLayoutData(new Margins(0, 0, 0, 0))); 
//           
//           LayoutContainer layoutContainer_18 = new LayoutContainer(new FitLayout());
//           layoutContainer_18.setStyleAttribute("background-color", "#dfe8f6");
//           
//           LabelField lblfldNewLabelfield_16 = new LabelField("구  분");
//           lblfldNewLabelfield_16.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_16.setStyleAttribute( "text-align", "center"); 
//           layoutContainer_18.add(lblfldNewLabelfield_16, new FormData("100%"));
//           layoutContainer_2502.add(layoutContainer_18);
//           layoutContainer_18.setBorders(true); 
//           
//           LayoutContainer layoutContainer_19 = new LayoutContainer(new FitLayout());
//           layoutContainer_19.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_17 = new LabelField("입사일");
//           lblfldNewLabelfield_17.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_17.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_17.setBorders(false);
//           layoutContainer_19.add(lblfldNewLabelfield_17, new FormData("100%"));
//           layoutContainer_3502.add(layoutContainer_19);
//           layoutContainer_19.setBorders(true);
//           
//           LayoutContainer layoutContainer_20 = new LayoutContainer(new FitLayout());
//           layoutContainer_20.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_18 = new LabelField("기산일");
//           lblfldNewLabelfield_18.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_18.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_18.setBorders(false);
//           layoutContainer_20.add(lblfldNewLabelfield_18, new FormData("100%"));
//           layoutContainer_4502.add(layoutContainer_20);
//           layoutContainer_20.setBorders(true);
//           
//           LayoutContainer layoutContainer_21 = new LayoutContainer(new FitLayout());
//           layoutContainer_21.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_19 = new LabelField("퇴사일");
//           lblfldNewLabelfield_19.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_19.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_19.setBorders(false);
//           layoutContainer_21.add(lblfldNewLabelfield_19, new FormData("100%"));
//           layoutContainer_5502.add(layoutContainer_21);
//           layoutContainer_21.setBorders(true);
//           
//           LayoutContainer layoutContainer_22 = new LayoutContainer(new FitLayout());
//           layoutContainer_22.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_20 = new LabelField("지급일");
//           lblfldNewLabelfield_20.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_20.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_20.setBorders(false);
//           layoutContainer_22.add(lblfldNewLabelfield_20, new FormData("100%"));
//           layoutContainer_6502.add(layoutContainer_22);
//           layoutContainer_22.setBorders(true);
//           
//           LayoutContainer layoutContainer_23 = new LayoutContainer(new FitLayout());
//           layoutContainer_23.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_21 = new LabelField("근속월");
//           lblfldNewLabelfield_21.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_21.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_21.setBorders(false);
//           layoutContainer_23.add(lblfldNewLabelfield_21, new FormData("100%"));
//           layoutContainer_7502.add(layoutContainer_23);
//           layoutContainer_23.setBorders(true);
//           
//           LayoutContainer layoutContainer_24 = new LayoutContainer();
//           layoutContainer_24.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_22 = new LabelField("제외월");
//           lblfldNewLabelfield_22.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_22.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_22.setBorders(false);
//           layoutContainer_24.add(lblfldNewLabelfield_22, new FormData("100%"));
//           layoutContainer_8502.add(layoutContainer_24);
//           layoutContainer_24.setBorders(true);
//           
//           LayoutContainer layoutContainer_25 = new LayoutContainer(new FitLayout());
//           layoutContainer_25.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_23 = new LabelField("가산월");
//           lblfldNewLabelfield_23.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_23.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_23.setBorders(false);
//           layoutContainer_25.add(lblfldNewLabelfield_23, new FormData("100%"));
//           layoutContainer_9502.add(layoutContainer_25);
//           layoutContainer_25.setBorders(true);
//           
//           LayoutContainer layoutContainer_26 = new LayoutContainer(new FitLayout());
//           layoutContainer_26.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_24 = new LabelField("중복월"); 
//           lblfldNewLabelfield_24.setStyleAttribute("font-size", "11px");
//           lblfldNewLabelfield_24.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_24.setBorders(false);
//           layoutContainer_26.add(lblfldNewLabelfield_24, new FormData("100%"));
//           layoutContainer_26.setBorders(true);
//           layoutContainer_10502.add(layoutContainer_26);
//           
//           LayoutContainer layoutContainer_27 = new LayoutContainer(new FitLayout());
//           layoutContainer_27.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_25 = new LabelField("근속연");
//           lblfldNewLabelfield_25.setStyleAttribute("font-size", "11px"); 
//           lblfldNewLabelfield_25.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_25.setBorders(false);
//           layoutContainer_27.add(lblfldNewLabelfield_25, new FormData("100%"));  
//           layoutContainer_27.setBorders(true);
//           layoutContainer_11502.add(layoutContainer_27);
//           
//		  // 중간지급 근속연수
//           LayoutContainer layoutContainer_50 = new LayoutContainer(new FlowLayout()); 
//           layoutContainer_50.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_26 = new LabelField("중간지급 근속연수");
//           lblfldNewLabelfield_26.setStyleAttribute("font-size", "9px");
//           lblfldNewLabelfield_26.setHeight(26);
//           lblfldNewLabelfield_26.setStyleAttribute("paddingTop", "5px");
//           lblfldNewLabelfield_26.setStyleAttribute("vertical-align", "middle"); 
//           lblfldNewLabelfield_26.setBorders(false);
//           layoutContainer_50.add(lblfldNewLabelfield_26, new FormData("100%"));
//           layoutContainer_2502.add(layoutContainer_50);
//           layoutContainer_50.setBorders(true);
//           
//           LayoutContainer layoutContainer_51 = new LayoutContainer(new FlowLayout());
//           layoutContainer_51.setBorders(true);
//           /** column 중_입사일자 : ctrViewIcncDt */
//           ctrViewIcncDt = new MSFTextField();
//           new TextFieldMask<String>(ctrViewIcncDt, "9999.99.99"); 
//           layoutContainer_51.setHeight(24);
//           ctrViewIcncDt.setName("ctrIcncDt");
//           ctrViewIcncDt.setWidth("60px");
//           ctrViewIcncDt.setHideLabel(true);
//           ctrViewIcncDt.setReadOnly(true);
//           layoutContainer_51.add(ctrViewIcncDt, new FlowData(0));
//           layoutContainer_3502.add(layoutContainer_51);
//           
//           
//           LayoutContainer layoutContainer_52 = new LayoutContainer();
//           layoutContainer_52.setBorders(true);
//           /** column 중_기산일자 : ctrViewRkfcdDt */
//           ctrViewRkfcdDt = new MSFTextField();
//           new TextFieldMask<String>(ctrViewRkfcdDt, "9999.99.99"); 
//           ctrViewRkfcdDt.setName("ctrViewRkfcdDt");
//           ctrViewRkfcdDt.setWidth("60px");
//           ctrViewRkfcdDt.setHideLabel(true);  
//           ctrViewRkfcdDt.setReadOnly(true);
//           layoutContainer_52.add(ctrViewRkfcdDt, new FlowData(0));
//           layoutContainer_4502.add(layoutContainer_52 );
//          
//           
//           LayoutContainer layoutContainer_53 = new LayoutContainer(new FlowLayout());
//           layoutContainer_53.setBorders(true);
//           /** column 중_퇴사일자 : ctrViewRsgtnDt */
//           ctrViewRsgtnDt = new MSFTextField();
//           new TextFieldMask<String>(ctrViewRsgtnDt, "9999.99.99"); 
//           ctrViewRsgtnDt.setName("ctrRsgtnDt");
//           ctrViewRsgtnDt.setWidth("60px");
//           ctrViewRsgtnDt.setHideLabel(true);  
//           ctrViewRsgtnDt.setReadOnly(true);
//           layoutContainer_53.add(ctrViewRsgtnDt, new FlowData(0));
//           layoutContainer_5502.add(layoutContainer_53);
//          
//           
//           LayoutContainer layoutContainer_54 = new LayoutContainer(new FlowLayout());
//           layoutContainer_54.setBorders(true);
//           /** column 중_지급일자 : ctrViewPymtDt */
//           ctrViewPymtDt = new MSFTextField();
//           new TextFieldMask<String>(ctrViewPymtDt, "9999.99.99"); 
//           ctrViewPymtDt.setName("ctrPymtDt");
//           ctrViewPymtDt.setWidth("60px");
//           ctrViewPymtDt.setHideLabel(true);  
//           ctrViewPymtDt.setReadOnly(true);
//           layoutContainer_54.add(ctrViewPymtDt, new FlowData(0));
//           layoutContainer_6502.add(layoutContainer_54);
//           
//           
//           LayoutContainer layoutContainer_55 = new LayoutContainer(new FlowLayout());
//           layoutContainer_55.setBorders(true);
//           /** column 중_근속월수 : ctrViewLogSvcMnthIcm */
//           ctrViewLogSvcMnthIcm = new MSFNumberField();
//           ctrViewLogSvcMnthIcm.setWidth("50px");
//           ctrViewLogSvcMnthIcm.setHideLabel(true);  
//           ctrViewLogSvcMnthIcm.setAllowDecimals(true); 
//           ctrViewLogSvcMnthIcm.setPropertyEditorType(Long.class); 
//           ctrViewLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           ctrViewLogSvcMnthIcm.setWidth("50px");
//           layoutContainer_55.add(ctrViewLogSvcMnthIcm, new FlowData(0));
//           layoutContainer_7502.add(layoutContainer_55);
//           
//           LayoutContainer layoutContainer_56 = new LayoutContainer(new FlowLayout());
//           layoutContainer_56.setBorders(true);
//           /** column 중_제외월수 : ctrEepnMnthIcm */
//           ctrEepnMnthIcm = new MSFNumberField();
//           ctrEepnMnthIcm.setAllowDecimals(true); 
//           ctrEepnMnthIcm.setPropertyEditorType(Long.class); 
//           ctrEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           ctrEepnMnthIcm.setWidth("50px");
//           ctrEepnMnthIcm.setHideLabel(true);  
//           ctrEepnMnthIcm.setReadOnly(true);
//           layoutContainer_56.add(ctrEepnMnthIcm, new FlowData(0));
//           layoutContainer_8502.add(layoutContainer_56);
//           
//           
//           LayoutContainer layoutContainer_57 = new LayoutContainer(new FlowLayout());
//           layoutContainer_57.setBorders(true);
//           /** column 중_가산월수 : ctrAddMnthIcm */
//           ctrAddMnthIcm = new MSFNumberField();
//           ctrAddMnthIcm.setAllowDecimals(true); 
//           ctrAddMnthIcm.setPropertyEditorType(Long.class); 
//           ctrAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           ctrAddMnthIcm.setWidth("50px");
//           ctrAddMnthIcm.setHideLabel(true);  
//           ctrAddMnthIcm.setReadOnly(true);
//           layoutContainer_57.add(ctrAddMnthIcm, new FlowData(0));
//           layoutContainer_9502.add(layoutContainer_57);
//           
//           
//           LayoutContainer layoutContainer_58 = new LayoutContainer();
//           layoutContainer_58.setBorders(true);
//           /** column 중_중복월수 : ctrDupMnthIcm */
//           ctrDupMnthIcm = new MSFNumberField();
//           ctrDupMnthIcm.setAllowDecimals(true); 
//           ctrDupMnthIcm.setPropertyEditorType(Long.class); 
//           ctrDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           ctrDupMnthIcm.setWidth("50px");
//           ctrDupMnthIcm.setHideLabel(true);  
//           ctrDupMnthIcm.setReadOnly(true);
//           layoutContainer_58.add(ctrDupMnthIcm, new FlowData(0));
//           layoutContainer_10502.add(layoutContainer_58);
//           
//           
//           LayoutContainer layoutContainer_59 = new LayoutContainer(new FlowLayout());
//           layoutContainer_59.setBorders(true);
//           /** column 중_근속연수 : ctrLogSvc */
//           ctrLogSvc = new MSFNumberField();
//           ctrLogSvc.setAllowDecimals(true); 
//           ctrLogSvc.setPropertyEditorType(Long.class); 
//           ctrLogSvc.setFormat(NumberFormat.getDecimalFormat());
//           ctrLogSvc.setWidth("50px");
//           ctrLogSvc.setHideLabel(true);  
//           ctrLogSvc.setReadOnly(true);
//           layoutContainer_59.add(ctrLogSvc, new FlowData(0));
//           layoutContainer_11502.add(layoutContainer_59); 
//           
//		  //  최종분 근속연수
//           
//           LayoutContainer layoutContainer_28 = new LayoutContainer(new FlowLayout());
//           layoutContainer_28.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_27 = new LabelField("최종분 근속연수");
//           lblfldNewLabelfield_27.setStyleAttribute("font-size", "9px");
//           lblfldNewLabelfield_27.setHeight(24);
//           lblfldNewLabelfield_27.setStyleAttribute("paddingTop", "5px");
//           lblfldNewLabelfield_27.setStyleAttribute("vertical-align", "middle"); 
//           lblfldNewLabelfield_27.setBorders(false);
//           layoutContainer_28.add(lblfldNewLabelfield_27, new FormData("100%"));
//           layoutContainer_2502.add(layoutContainer_28);
//           layoutContainer_28.setBorders(true);
//           
//           LayoutContainer layoutContainer_29 = new LayoutContainer(new FlowLayout());
//           layoutContainer_29.setBorders(true);
//           /** column 종_입사일자 : endViewIcncDt */
//           endViewIcncDt = new MSFTextField();
//           new TextFieldMask<String>(endViewIcncDt, "9999.99.99"); 
//           endViewIcncDt.setName("endIcncDt");
//           endViewIcncDt.setWidth("60px");
//           endViewIcncDt.setHideLabel(true);  
//           endViewIcncDt.setReadOnly(true);
//           layoutContainer_29.add(endViewIcncDt, new FlowData(0));
//           layoutContainer_3502.add(layoutContainer_29);
//           
//           
//           LayoutContainer layoutContainer_30 = new LayoutContainer(new FlowLayout());
//           layoutContainer_30.setBorders(true);
//           /** column 종_기산일자 : endViewRkfcdDt */
//           endViewRkfcdDt = new MSFTextField();
//           new TextFieldMask<String>(endViewRkfcdDt, "9999.99.99"); 
//           endViewRkfcdDt.setName("endRkfcdDt");
//           endViewRkfcdDt.setWidth("60px");
//           endViewRkfcdDt.setHideLabel(true);  
//           endViewRkfcdDt.setReadOnly(true);
//           layoutContainer_30.add(endViewRkfcdDt, new FlowData(0));
//           layoutContainer_4502.add(layoutContainer_30);
//           
//           
//           LayoutContainer layoutContainer_31 = new LayoutContainer(new FlowLayout());
//           layoutContainer_31.setBorders(true);
//           /** column 종_퇴사일자 : endViewRsgtnDt */
//           endViewRsgtnDt = new MSFTextField();
//           new TextFieldMask<String>(endViewRsgtnDt, "9999.99.99"); 
//           endViewRsgtnDt.setName("endRsgtnDt");
//           endViewRsgtnDt.setWidth("60px");
//           endViewRsgtnDt.setHideLabel(true); 
//           endViewRsgtnDt.setReadOnly(true);
//           layoutContainer_31.add(endViewRsgtnDt, new FlowData(0));
//           layoutContainer_5502.add(layoutContainer_31);
//           
//           
//           LayoutContainer layoutContainer_32 = new LayoutContainer(new FlowLayout());
//           layoutContainer_32.setBorders(true);
//           /** column 종_지급일자 : endViewPymtDt */
//           endViewPymtDt = new MSFTextField();
//           new TextFieldMask<String>(endViewPymtDt, "9999.99.99"); 
//           endViewPymtDt.setName("endViewPymtDt");
//           endViewPymtDt.setWidth("60px");
//           endViewPymtDt.setHideLabel(true);  
//           endViewPymtDt.setReadOnly(true);
//           layoutContainer_32.add(endViewPymtDt, new FlowData(0));
//           layoutContainer_6502.add(layoutContainer_32);
//           
//           
//           LayoutContainer layoutContainer_33 = new LayoutContainer(new FlowLayout());
//           layoutContainer_33.setBorders(true);
//           /** column 종_근속월수 : endViewLogSvcMnthIcm */
//           endViewLogSvcMnthIcm = new MSFNumberField();
//           endViewLogSvcMnthIcm.setAllowDecimals(true); 
//           endViewLogSvcMnthIcm.setPropertyEditorType(Long.class); 
//           endViewLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           endViewLogSvcMnthIcm.setWidth("50px");
//           endViewLogSvcMnthIcm.setHideLabel(true);  
//           endViewLogSvcMnthIcm.setReadOnly(true);
//           layoutContainer_33.add(endViewLogSvcMnthIcm, new FlowData(0));
//           layoutContainer_7502.add(layoutContainer_33);
//           
//           
//           LayoutContainer layoutContainer_34 = new LayoutContainer(new FlowLayout());
//           layoutContainer_34.setBorders(true);
//           /** column 종_제외월수 : endEepnMnthIcm */
//           endEepnMnthIcm = new MSFNumberField();
//           endEepnMnthIcm.setAllowDecimals(true); 
//           endEepnMnthIcm.setPropertyEditorType(Long.class); 
//           endEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           endEepnMnthIcm.setWidth("50px");
//           endEepnMnthIcm.setHideLabel(true);  
//           endEepnMnthIcm.setReadOnly(true);
//           layoutContainer_34.add(endEepnMnthIcm, new FlowData(0));
//           layoutContainer_8502.add(layoutContainer_34);
//           
//           
//           LayoutContainer layoutContainer_35 = new LayoutContainer(new FlowLayout());
//           layoutContainer_35.setBorders(true);
//           /** column 종_가산월수 : endAddMnthIcm */
//           endAddMnthIcm = new MSFNumberField();
//           endAddMnthIcm.setAllowDecimals(true); 
//           endAddMnthIcm.setPropertyEditorType(Long.class); 
//           endAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           endAddMnthIcm.setWidth("50px");
//           endAddMnthIcm.setHideLabel(true);
//           endAddMnthIcm.setReadOnly(true);
//           layoutContainer_35.add(endAddMnthIcm, new FlowData(0));
//           layoutContainer_9502.add(layoutContainer_35);
//           
//           
//           LayoutContainer layoutContainer_36 = new LayoutContainer(new FlowLayout());
//           layoutContainer_36.setBorders(true);
//           /** column 종_중복월수 : endDupMnthIcm */
//           endDupMnthIcm = new MSFNumberField();
//           endDupMnthIcm.setAllowDecimals(true); 
//           endDupMnthIcm.setPropertyEditorType(Long.class); 
//           endDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           endDupMnthIcm.setWidth("50px");
//           endDupMnthIcm.setHideLabel(true);  
//           endDupMnthIcm.setReadOnly(true);
//           layoutContainer_36.add(endDupMnthIcm, new FlowData(0));
//           layoutContainer_10502.add(layoutContainer_36);
//           
//           
//           LayoutContainer layoutContainer_48 = new LayoutContainer(new FlowLayout());
//           layoutContainer_48.setBorders(true);
//           /** column 종_근속연수 : endLogSvcYrNum */
//           endLogSvcYrNum = new MSFNumberField();
//           endLogSvcYrNum.setAllowDecimals(true); 
//           endLogSvcYrNum.setPropertyEditorType(Long.class); 
//           endLogSvcYrNum.setFormat(NumberFormat.getDecimalFormat());
//           endLogSvcYrNum.setWidth("50px");
//           endLogSvcYrNum.setHideLabel(true);  
//           endLogSvcYrNum.setReadOnly(true);
//           layoutContainer_48.add(endLogSvcYrNum, new FlowData(0));
//           layoutContainer_11502.add(layoutContainer_48);
//          
//           
//		  //  정산(합산) 근속연수
//            
//           
//           LayoutContainer layoutContainer_49 = new LayoutContainer(new FlowLayout());
//           layoutContainer_49.setStyleAttribute("background-color", "#dfe8f6");
//           layoutContainer_49.setBorders(true);
//           LabelField lblfldNewLabelfield_28 = new LabelField("정산 근속연수");
//           lblfldNewLabelfield_28.setStyleAttribute("font-size", "9px");
//           lblfldNewLabelfield_28.setHeight(24);
//           lblfldNewLabelfield_28.setStyleAttribute("paddingTop", "5px");
//           lblfldNewLabelfield_28.setStyleAttribute("vertical-align", "middle"); 
//           lblfldNewLabelfield_28.setBorders(false);
//           layoutContainer_49.add(lblfldNewLabelfield_28, new FormData("100%"));
//           layoutContainer_2502.add(layoutContainer_49);
//          
//           
//           LayoutContainer layoutContainer_60 = new LayoutContainer(new FlowLayout());
//           layoutContainer_60.setBorders(true);
//           /** column 정산_입사일자 : clutIcncDt REad*/
//           clutIcncDt = new MSFTextField();
//           new TextFieldMask<String>(clutIcncDt, "9999.99.99"); 
//           clutIcncDt.setName("clutIcncDt");
//           clutIcncDt.setWidth("60px");
//           clutIcncDt.setHideLabel(true);  
//           clutIcncDt.setReadOnly(true);
//           layoutContainer_60.add(clutIcncDt, new FlowData(0));
//           layoutContainer_3502.add(layoutContainer_60);
//           
//           
//           LayoutContainer layoutContainer_61 = new LayoutContainer(new FlowLayout());
//           layoutContainer_61.setBorders(true);
//           /** column 정산-기산일자 : clutRkfcdDt */
//           clutRkfcdDt = new MSFTextField();
//           new TextFieldMask<String>(clutRkfcdDt, "9999.99.99"); 
//           clutRkfcdDt.setName("clutRkfcdDt");
//           clutRkfcdDt.setWidth("60px");
//           clutRkfcdDt.setHideLabel(true);  
//           clutRkfcdDt.setReadOnly(true);
//           layoutContainer_61.add(clutRkfcdDt, new FlowData(0));
//           layoutContainer_4502.add(layoutContainer_61);
//           
//           
//           LayoutContainer layoutContainer_62 = new LayoutContainer(new FlowLayout());
//           layoutContainer_62.setBorders(true);
//           /** column 정산_퇴사일자 : clutRsgtnDt */
//           clutRsgtnDt = new MSFTextField();
//           new TextFieldMask<String>(clutRsgtnDt, "9999.99.99"); 
//           clutRsgtnDt.setName("clutRsgtnDt");
//           clutRsgtnDt.setWidth("60px");
//           clutRsgtnDt.setHideLabel(true);  
//           clutRsgtnDt.setReadOnly(true);
//           layoutContainer_62.add(clutRsgtnDt, new FlowData(0));
//           layoutContainer_5502.add(layoutContainer_62);
//         
//           
//           LayoutContainer layoutContainer_63 = new LayoutContainer(new FlowLayout());
//           layoutContainer_63.setBorders(true);
//           /** column 정산_지급일자 : clutPymtDt */
//           clutPymtDt = new MSFTextField();
//           new TextFieldMask<String>(clutPymtDt, "9999.99.99"); 
//           clutPymtDt.setName("clutPymtDt");
//           clutPymtDt.setWidth("60px");
//           clutPymtDt.setHideLabel(true);  
//           clutPymtDt.setReadOnly(true);
//           layoutContainer_63.add(clutPymtDt, new FlowData(0));
//           layoutContainer_6502.add(layoutContainer_63);
//           
//           
//           LayoutContainer layoutContainer_64 = new LayoutContainer(new FlowLayout());
//           layoutContainer_64.setBorders(true);
//           /** column 정산_근속월수 : clutLogSvcMnthIcm */
//           clutLogSvcMnthIcm = new MSFNumberField();
//           clutLogSvcMnthIcm.setAllowDecimals(true); 
//           clutLogSvcMnthIcm.setPropertyEditorType(Long.class); 
//           clutLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           clutLogSvcMnthIcm.setWidth("50px");
//           clutLogSvcMnthIcm.setHideLabel(true);  
//           clutLogSvcMnthIcm.setReadOnly(true);
//           layoutContainer_64.add(clutLogSvcMnthIcm, new FlowData(0));
//           layoutContainer_7502.add(layoutContainer_64);
//           
//           
//           LayoutContainer layoutContainer_65 = new LayoutContainer(new FlowLayout());
//           layoutContainer_65.setBorders(true);
//           /** column 정산_제외월수 : clutEepnMnthIcm */
//           clutEepnMnthIcm = new MSFNumberField();
//           clutEepnMnthIcm.setAllowDecimals(true); 
//           clutEepnMnthIcm.setPropertyEditorType(Long.class); 
//           clutEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           clutEepnMnthIcm.setWidth("50px");
//           clutEepnMnthIcm.setHideLabel(true);  
//           clutEepnMnthIcm.setReadOnly(true);
//           layoutContainer_65.add(clutEepnMnthIcm, new FlowData(0));
//           layoutContainer_8502.add(layoutContainer_65);
//           
//           
//           LayoutContainer layoutContainer_66 = new LayoutContainer(new FlowLayout());
//           layoutContainer_66.setBorders(true);
//           /** column 정산_가산월수 : clutAddMnthIcm */
//           clutAddMnthIcm = new MSFNumberField();
//           clutAddMnthIcm.setAllowDecimals(true); 
//           clutAddMnthIcm.setPropertyEditorType(Long.class); 
//           clutAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           clutAddMnthIcm.setWidth("50px");
//           clutAddMnthIcm.setHideLabel(true);  
//           clutAddMnthIcm.setReadOnly(true);
//           layoutContainer_66.add(clutAddMnthIcm, new FlowData(0));
//           layoutContainer_9502.add(layoutContainer_66);
//           
//           
//           LayoutContainer layoutContainer_67 = new LayoutContainer(new FlowLayout());
//           layoutContainer_67.setBorders(true);
//           /** column 정산_중복월수 : clutDupMnthIcm */
//           clutDupMnthIcm = new MSFNumberField();
//           clutDupMnthIcm.setAllowDecimals(true); 
//           clutDupMnthIcm.setPropertyEditorType(Long.class); 
//           clutDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           clutDupMnthIcm.setWidth("50px");
//           clutDupMnthIcm.setHideLabel(true); 
//           clutDupMnthIcm.setReadOnly(true);
//           layoutContainer_67.add(clutDupMnthIcm, new FlowData(0));
//           layoutContainer_10502.add(layoutContainer_67);
//           
//           
//           LayoutContainer layoutContainer_68 = new LayoutContainer(new FlowLayout());
//           layoutContainer_68.setBorders(true);
//           /** column 정산_근속연수 : clutLogSvcYrNum */
//           clutLogSvcYrNum = new MSFNumberField();
//           clutLogSvcYrNum.setAllowDecimals(true); 
//           clutLogSvcYrNum.setPropertyEditorType(Long.class); 
//           clutLogSvcYrNum.setFormat(NumberFormat.getDecimalFormat());
//           clutLogSvcYrNum.setWidth("50px");
//           clutLogSvcYrNum.setHideLabel(true); 
//           clutLogSvcYrNum.setReadOnly(true);
//           layoutContainer_68.add(clutLogSvcYrNum, new FlowData(0));
//           layoutContainer_11502.add(layoutContainer_68);
//          
//           
//		  //  안분 
//
//           LayoutContainer layoutContainer_38 = new LayoutContainer();
//           layoutContainer_38.setLayout(new ColumnLayout());
//           layoutContainer_38.setBorders(false); 
//           
//           LayoutContainer layoutContainer1_38 = new LayoutContainer(new FlowLayout()); 
//           layoutContainer1_38.setBorders(false);
//           
//           LayoutContainer layoutContainer_39 = new LayoutContainer(new FlowLayout());
//           layoutContainer_39.setHeight("52px");
//           layoutContainer_39.setStyleAttribute("background-color", "#dfe8f6"); 
//           layoutContainer_39.setBorders(true);
//           
//           LabelField lblfldNewLabelfield_29 = new LabelField("안분");
//           lblfldNewLabelfield_29.setHeight("52px");
//           
//           lblfldNewLabelfield_29.setStyleAttribute("padding-top", "10px");
//           lblfldNewLabelfield_29.setStyleAttribute("vertical-align", "middle"); 
//           layoutContainer_39.add(lblfldNewLabelfield_29, new FormData("100%"));
//           lblfldNewLabelfield_29.setBorders(false);
//           layoutContainer_38.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//       
//          
//           
//           LayoutContainer layoutContainer_40 = new LayoutContainer(new FlowLayout());
//           layoutContainer_40.setStyleAttribute("background-color", "#dfe8f6"); 
//           layoutContainer_40.setBorders(true);
//          
//           LabelField lblfldNewLabelfield_30 = new LabelField("2012.12.31이전");
//           lblfldNewLabelfield_30.setStyleAttribute("font-size", "8px");
//           lblfldNewLabelfield_30.setHeight(24);
//           lblfldNewLabelfield_30.setStyleAttribute("padding-top", "5px");
//           lblfldNewLabelfield_30.setStyleAttribute("vertical-align", "middle"); 
//           lblfldNewLabelfield_30.setBorders(false);
//           layoutContainer_40.add(lblfldNewLabelfield_30, new FormData("100%"));
//           layoutContainer1_38.add(layoutContainer_40, new FlowData(0) );
//          
//           
//           
//           LayoutContainer layoutContainer_80 = new LayoutContainer(new FlowLayout());
//           layoutContainer_80.setStyleAttribute("background-color", "#dfe8f6"); 
//           layoutContainer_80.setBorders(true);
//           LabelField lblfldNewLabelfield_31 = new LabelField("2013.01.01이후");
//           lblfldNewLabelfield_31.setStyleAttribute("font-size", "8px");
//           lblfldNewLabelfield_31.setHeight(24);
//           lblfldNewLabelfield_31.setBorders(false);
//           lblfldNewLabelfield_31.setStyleAttribute("paddingTop", "5px");
//           lblfldNewLabelfield_31.setStyleAttribute("vertical-align", "middle"); 
//           layoutContainer_80.add(lblfldNewLabelfield_31, new FormData("100%"));
//           layoutContainer1_38.add(layoutContainer_80, new FlowData(0));
//           
//           layoutContainer_38.add(layoutContainer1_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//           
//           layoutContainer_2502.add(layoutContainer_38);
//           
//		   //2012.12.31이전
//           
//           LayoutContainer layoutContainer_41 = new LayoutContainer(new FlowLayout());
//           layoutContainer_41.setBorders(true);
//           /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
//           logPpnl12befIcncDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl12befIcncDt, "9999.99.99"); 
//           logPpnl12befIcncDt.setName("logPpnl12befIcncDt");
//           logPpnl12befIcncDt.setWidth("60px");
//           logPpnl12befIcncDt.setHideLabel(true);  
//           logPpnl12befIcncDt.setReadOnly(true);
//           layoutContainer_41.add(logPpnl12befIcncDt, new FlowData(0));
//           layoutContainer_3502.add(layoutContainer_41);
//           
//           
//           LayoutContainer layoutContainer_42 = new LayoutContainer(new FlowLayout());
//           layoutContainer_42.setBorders(true);
//        /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
//           logPpnl12befRkfcdDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl12befRkfcdDt, "9999.99.99"); 
//           logPpnl12befRkfcdDt.setName("logPpnl12befRkfcdDt");
//           logPpnl12befRkfcdDt.setWidth("60px");
//           logPpnl12befRkfcdDt.setHideLabel(true);  
//           logPpnl12befRkfcdDt.setReadOnly(true);
//           layoutContainer_42.add(logPpnl12befRkfcdDt, new FlowData(0));
//           layoutContainer_4502.add(layoutContainer_42);
//          
//           
//           LayoutContainer layoutContainer_43 = new LayoutContainer(new FlowLayout());
//           layoutContainer_43.setBorders(true);
//           /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
//           logPpnl12befRsgtnDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl12befRsgtnDt, "9999.99.99"); 
//           logPpnl12befRsgtnDt.setName("logPpnl12befRsgtnDt");
//           logPpnl12befRsgtnDt.setWidth("60px");
//           logPpnl12befRsgtnDt.setHideLabel(true);  
//           logPpnl12befRsgtnDt.setReadOnly(true);
//           layoutContainer_43.add(logPpnl12befRsgtnDt, new FlowData(0));
//           layoutContainer_5502.add(layoutContainer_43);
//          
//           
//           LayoutContainer layoutContainer_44 = new LayoutContainer(new FlowLayout());
//           layoutContainer_44.setBorders(true);
//           /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
//           logPpnl12befPymtDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl12befPymtDt, "9999.99.99"); 
//           logPpnl12befPymtDt.setName("logPpnl12befPymtDt");
//           logPpnl12befPymtDt.setWidth("60px");
//           logPpnl12befPymtDt.setHideLabel(true);  
//           logPpnl12befPymtDt.setReadOnly(true);
//           layoutContainer_44.add(logPpnl12befPymtDt, new FlowData(0));
//            layoutContainer_6502.add(layoutContainer_44);
//           
//           
//           LayoutContainer layoutContainer_45 = new LayoutContainer(new FlowLayout());
//           layoutContainer_45.setBorders(true);
//           /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
//           logPpnl12befLogMnthIcm = new MSFNumberField();
//           logPpnl12befLogMnthIcm.setAllowDecimals(true); 
//           logPpnl12befLogMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl12befLogMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           logPpnl12befLogMnthIcm.setWidth("50px");
//           logPpnl12befLogMnthIcm.setHideLabel(true);  
//           logPpnl12befLogMnthIcm.setReadOnly(true);
//           layoutContainer_45.add(logPpnl12befLogMnthIcm, new FlowData(0));
//           layoutContainer_7502.add(layoutContainer_45);
//           
//           
//           LayoutContainer layoutContainer_46 = new LayoutContainer(new FlowLayout());
//           layoutContainer_46.setBorders(true);
//           /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
//           logPpnl12befEepnMnthIcm = new MSFNumberField();
//           logPpnl12befEepnMnthIcm.setAllowDecimals(true); 
//           logPpnl12befEepnMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl12befEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           logPpnl12befEepnMnthIcm.setWidth("50px");
//           logPpnl12befEepnMnthIcm.setHideLabel(true);  
//           logPpnl12befEepnMnthIcm.setReadOnly(true);
//           layoutContainer_46.add(logPpnl12befEepnMnthIcm, new FlowData(0));
//           layoutContainer_8502.add(layoutContainer_46);
//           
//           
//           LayoutContainer layoutContainer_47 = new LayoutContainer(new FlowLayout());
//           layoutContainer_47.setBorders(true);
//           /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
//           logPpnl12befAddMnthIcm = new MSFNumberField();
//           logPpnl12befAddMnthIcm.setAllowDecimals(true); 
//           logPpnl12befAddMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl12befAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           logPpnl12befAddMnthIcm.setWidth("50px");
//           logPpnl12befAddMnthIcm.setHideLabel(true);  
//           logPpnl12befAddMnthIcm.setReadOnly(true);
//           layoutContainer_47.add(logPpnl12befAddMnthIcm, new FlowData(0));
//           layoutContainer_9502.add(layoutContainer_47);           
//           
//           LayoutContainer layoutContainer_69 = new LayoutContainer(new FlowLayout());
//           layoutContainer_69.setBorders(true);
//           /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
//           logPpnl12befDupMnthIcm = new MSFNumberField();
//           logPpnl12befDupMnthIcm.setAllowDecimals(true); 
//           logPpnl12befDupMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl12befDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           logPpnl12befDupMnthIcm.setWidth("50px");
//           logPpnl12befDupMnthIcm.setHideLabel(true);  
//           logPpnl12befDupMnthIcm.setReadOnly(true);
//           layoutContainer_69.add(logPpnl12befDupMnthIcm, new FlowData(0));
//           layoutContainer_10502.add(layoutContainer_69);          
//           
//           LayoutContainer layoutContainer_71 = new LayoutContainer(new FlowLayout());
//           layoutContainer_71.setBorders(true);
//           /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
//           logPpnl12befLogYrNum = new MSFNumberField();
//           logPpnl12befLogYrNum.setAllowDecimals(true); 
//           logPpnl12befLogYrNum.setPropertyEditorType(Long.class); 
//           logPpnl12befLogYrNum.setFormat(NumberFormat.getDecimalFormat());
//           logPpnl12befLogYrNum.setWidth("50px");
//           logPpnl12befLogYrNum.setHideLabel(true);  
//           logPpnl12befLogYrNum.setReadOnly(true);
//           layoutContainer_71.add(logPpnl12befLogYrNum, new FlowData(0));
//           layoutContainer_11502.add(layoutContainer_71);
//              
//           //2013.01.01이후
//           
//           LayoutContainer layoutContainer_79 = new LayoutContainer(new FlowLayout());
//           layoutContainer_79.setBorders(true);
//           /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
//           logPpnl13afrIcncDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl13afrIcncDt, "9999.99.99"); 
//           logPpnl13afrIcncDt.setName("logPpnl13afrIcncDt");
//           logPpnl13afrIcncDt.setWidth("60px");
//           logPpnl13afrIcncDt.setHideLabel(true);  
//           logPpnl13afrIcncDt.setReadOnly(true);
//           layoutContainer_79.add(logPpnl13afrIcncDt, new FlowData(0));
//           layoutContainer_3502.add(layoutContainer_79);
//           
//           
//           LayoutContainer layoutContainer_78 = new LayoutContainer(new FlowLayout());
//           layoutContainer_78.setBorders(true);
//           /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
//           logPpnl13afrRkfcdDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl13afrRkfcdDt, "9999.99.99"); 
//           logPpnl13afrRkfcdDt.setName("logPpnl13afrRkfcdDt");
//           logPpnl13afrRkfcdDt.setWidth("60px");
//           logPpnl13afrRkfcdDt.setHideLabel(true);  
//           logPpnl13afrRkfcdDt.setReadOnly(true);
//           layoutContainer_78.add(logPpnl13afrRkfcdDt, new FlowData(0));
//           layoutContainer_4502.add(layoutContainer_78);
//           
//           LayoutContainer layoutContainer_77 = new LayoutContainer(new FlowLayout());
//           layoutContainer_77.setBorders(true);
//           /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
//           logPpnl13afrRsgtnDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl13afrRsgtnDt, "9999.99.99"); 
//           logPpnl13afrRsgtnDt.setName("logPpnl13afrRsgtnDt");
//           logPpnl13afrRsgtnDt.setWidth("60px");
//           logPpnl13afrRsgtnDt.setHideLabel(true);  
//           logPpnl13afrRsgtnDt.setReadOnly(true);
//           layoutContainer_77.add(logPpnl13afrRsgtnDt, new FlowData(0));
//           layoutContainer_5502.add(layoutContainer_77);
//           
//           
//           LayoutContainer layoutContainer_76 = new LayoutContainer(new FlowLayout());
//           layoutContainer_76.setBorders(true);
//           /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
//           logPpnl13afrPymtDt = new MSFTextField();
//           new TextFieldMask<String>(logPpnl13afrPymtDt, "9999.99.99"); 
//           logPpnl13afrPymtDt.setName("logPpnl13afrPymtDt");
//           logPpnl13afrPymtDt.setWidth("60px");
//           logPpnl13afrPymtDt.setHideLabel(true);  
//           logPpnl13afrPymtDt.setReadOnly(true);
//           layoutContainer_76.add(logPpnl13afrPymtDt, new FlowData(0));
//           layoutContainer_6502.add(layoutContainer_76);
//           
//           
//           LayoutContainer layoutContainer_75 = new LayoutContainer(new FlowLayout());
//           layoutContainer_75.setBorders(true);
//           /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
//           logPpnl13afrLogMnthIcm = new MSFNumberField();
//           logPpnl13afrLogMnthIcm.setAllowDecimals(true); 
//           logPpnl13afrLogMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl13afrLogMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           
//           logPpnl13afrLogMnthIcm.setWidth("50px");
//           logPpnl13afrLogMnthIcm.setHideLabel(true);  
//           logPpnl13afrLogMnthIcm.setReadOnly(true);
//           layoutContainer_75.add(logPpnl13afrLogMnthIcm, new FlowData(0));
//           layoutContainer_7502.add(layoutContainer_75);
//           
//           
//           LayoutContainer layoutContainer_74 = new LayoutContainer(new FlowLayout());
//           layoutContainer_74.setBorders(true);
//           /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
//           logPpnl13afrEepnMnthIcm = new MSFNumberField();
//           logPpnl13afrEepnMnthIcm.setAllowDecimals(true); 
//           logPpnl13afrEepnMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl13afrEepnMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           
//           logPpnl13afrEepnMnthIcm.setWidth("50px");
//           logPpnl13afrEepnMnthIcm.setHideLabel(true);  
//           logPpnl13afrEepnMnthIcm.setReadOnly(true);
//           layoutContainer_74.add(logPpnl13afrEepnMnthIcm, new FlowData(0)); 
//           layoutContainer_8502.add(layoutContainer_74);
//           
//           
//           LayoutContainer layoutContainer_73 = new LayoutContainer(new FlowLayout());
//           layoutContainer_73.setBorders(true);
//           /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
//           logPpnl13afrAddMnthIcm = new MSFNumberField();
//           logPpnl13afrAddMnthIcm.setAllowDecimals(true); 
//           logPpnl13afrAddMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl13afrAddMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           
//           logPpnl13afrAddMnthIcm.setWidth("50px");
//           logPpnl13afrAddMnthIcm.setHideLabel(true);  
//           logPpnl13afrAddMnthIcm.setReadOnly(true);
//           layoutContainer_73.add(logPpnl13afrAddMnthIcm, new FlowData(0));
//           layoutContainer_9502.add(layoutContainer_73);
//          
//           
//           LayoutContainer layoutContainer_72 = new LayoutContainer(new FlowLayout());
//           layoutContainer_72.setBorders(true);
//           /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
//           logPpnl13afrDupMnthIcm = new MSFNumberField();
//           logPpnl13afrDupMnthIcm.setAllowDecimals(true); 
//           logPpnl13afrDupMnthIcm.setPropertyEditorType(Long.class); 
//           logPpnl13afrDupMnthIcm.setFormat(NumberFormat.getDecimalFormat());
//           
//           logPpnl13afrDupMnthIcm.setWidth("50px");
//           logPpnl13afrDupMnthIcm.setHideLabel(true);  
//           logPpnl13afrDupMnthIcm.setReadOnly(true);
//           layoutContainer_72.add(logPpnl13afrDupMnthIcm, new FlowData(0));
//           layoutContainer_10502.add(layoutContainer_72);
//           
//           
//           LayoutContainer layoutContainer_70 = new LayoutContainer(new FlowLayout());
//           layoutContainer_70.setBorders(true);
//           /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
//           logPpnl13afrLogSvc = new MSFNumberField();
//           logPpnl13afrLogSvc.setAllowDecimals(true); 
//           logPpnl13afrLogSvc.setPropertyEditorType(Long.class); 
//           logPpnl13afrLogSvc.setFormat(NumberFormat.getDecimalFormat());
//           
//           logPpnl13afrLogSvc.setWidth("50px");
//           logPpnl13afrLogSvc.setHideLabel(true);  
//           logPpnl13afrLogSvc.setReadOnly(true);
//           layoutContainer_70.add(logPpnl13afrLogSvc, new FlowData(0));
//           layoutContainer_11502.add(layoutContainer_70);
//		    
//           
//           //퇴직소득과세표준계산  
//           LayoutContainer layoutContainer100_2 = new LayoutContainer();
//           layoutContainer100_2.setLayout(new FitLayout()); 
//           layoutContainer100_2.setHeight(127);
//           layoutContainer100_2.setBorders(false);
//	 
//		     //4개의 걸럼
//		    
//		    LayoutContainer hBoxTopFrm01 = new LayoutContainer();  
//	        HBoxLayout hbLayout01 = new HBoxLayout();  
//	        hbLayout01.setPadding(new Padding(0));  
//	        hbLayout01.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
//	        hBoxTopFrm01.setLayout(hbLayout01);  
//	  
//	        //1
//	        LayoutContainer layoutContainer1_1502 = new LayoutContainer();
//           frmlytSch = new FormLayout();  
//           frmlytSch.setLabelWidth(0); 
//           frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//           layoutContainer1_1502.setLayout(frmlytSch);
//           layoutContainer1_1502.setBorders(true); 
//           layoutContainer1_1502.setWidth(178);
//		    
//
//		    //2
//	        LayoutContainer layoutContainer1_2502 = new LayoutContainer();
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer1_2502.setLayout(frmlytSch);
//         layoutContainer1_2502.setBorders(true); 
//         layoutContainer1_2502.setWidth(165);
//		    
//		    //3
//	        LayoutContainer layoutContainer1_3502 = new LayoutContainer();
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer1_3502.setLayout(frmlytSch);
//         layoutContainer1_3502.setBorders(true); 
//         layoutContainer1_3502.setWidth(165);
//		    
//		    //4
//	        LayoutContainer layoutContainer1_4502 = new LayoutContainer();
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer1_4502.setLayout(frmlytSch);
//         layoutContainer1_4502.setBorders(true); 
//         layoutContainer1_4502.setWidth(170);
//		    
//		    
//
//         hBoxTopFrm01.add(layoutContainer1_1502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//         hBoxTopFrm01.add(layoutContainer1_2502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//         hBoxTopFrm01.add(layoutContainer1_3502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//         hBoxTopFrm01.add(layoutContainer1_4502, new HBoxLayoutData(new Margins(0)));  
//         
//		    
//           //계산내용 
//           
//           LayoutContainer layoutContainer_84 = new LayoutContainer(new FlowLayout());
//           layoutContainer_84.setStyleAttribute("background-color", "#dfe8f6");
//           layoutContainer_84.setBorders(true);
//           LabelField lblfldNewLabelfield_32 = new LabelField("계 산 내 용");
//           lblfldNewLabelfield_32.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_32.setBorders(false);
//           layoutContainer_84.add(lblfldNewLabelfield_32, new FormData("100%"));
//           layoutContainer1_1502.add(layoutContainer_84);
//           
//           
//           LayoutContainer layoutContainer_85 = new LayoutContainer(new FlowLayout());
//           layoutContainer_85.setStyleAttribute("background-color", "#dfe8f6");
//           layoutContainer_85.setBorders(true);
//           LabelField lblfldNewLabelfield_33 = new LabelField("중간지급");
//           lblfldNewLabelfield_33.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_33.setBorders(false);
//           layoutContainer_85.add(lblfldNewLabelfield_33, new FormData("100%"));
//           layoutContainer1_2502.add(layoutContainer_85); 
//           
//           
//           LayoutContainer layoutContainer_86 = new LayoutContainer(new FlowLayout());
//           layoutContainer_86.setStyleAttribute("background-color", "#dfe8f6");
//           LabelField lblfldNewLabelfield_34 = new LabelField("최종분");
//           lblfldNewLabelfield_34.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_34.setBorders(false);
//           layoutContainer_86.add(lblfldNewLabelfield_34, new FormData("100%"));
//           layoutContainer1_3502.add(layoutContainer_86);
//           layoutContainer_86.setBorders(true);
//           
//           LayoutContainer layoutContainer_87 = new LayoutContainer(new FlowLayout());
//           layoutContainer_87.setStyleAttribute("background-color", "#dfe8f6");
//           layoutContainer_87.setBorders(true);
//           
//           LabelField lblfldNewLabelfield_35 = new LabelField("정산(합산)");
//           lblfldNewLabelfield_35.setStyleAttribute( "text-align", "center"); 
//           lblfldNewLabelfield_35.setBorders(false);
//           layoutContainer_87.add(lblfldNewLabelfield_35, new FormData("100%"));
//           layoutContainer1_4502.add(layoutContainer_87);
//           
//           LayoutContainer layoutContainer1_94 = new LayoutContainer();
//           layoutContainer1_94.setStyleAttribute("background-color", "#dfe8f6");
//           layoutContainer1_94.setLayout(new ColumnLayout());
//           layoutContainer1_94.setBorders(false);
//           
//           LayoutContainer layoutContainer_88 = new LayoutContainer(new FlowLayout());
//          LabelField lblfldNewLabelfield_36 = new LabelField("퇴직소득과세표준계산");
//          lblfldNewLabelfield_36.setStyleAttribute("paddingTop", "15px");
//          layoutContainer_88.add(lblfldNewLabelfield_36, new FormData("100%")); 
//          layoutContainer1_94.add(layoutContainer_88, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//          layoutContainer_88.setBorders(true);
//          
//          LayoutContainer layoutContainer_89 = new LayoutContainer(new FlowLayout());
//         // frmlytSch = new FormLayout();  
//         // frmlytSch.setLabelWidth(0); 
//         // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         // layoutContainer_89.setLayout(frmlytSch);
//          layoutContainer_89.setBorders(false);
//          
//          LayoutContainer layoutContainer_90 = new LayoutContainer(new FlowLayout()); 
//          layoutContainer_90.setBorders(true);
//          
//          LabelField lblfldNewLabelfield_37 = new LabelField("퇴직소득");
//          lblfldNewLabelfield_37.setBorders(false);
//          lblfldNewLabelfield_37.setHeight(24);
//          lblfldNewLabelfield_37.setStyleAttribute("paddingTop", "5px");
//          lblfldNewLabelfield_37.setStyleAttribute("vertical-align", "middle"); 
//          layoutContainer_90.add(lblfldNewLabelfield_37, new FormData("100%")); 
//          layoutContainer_89.add(layoutContainer_90);
//          
//          layoutContainer1_94.add(layoutContainer_89, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//          
//          layoutContainer1_1502.add(layoutContainer1_94);
//          
//          LayoutContainer layoutContainer_91 = new LayoutContainer(new FlowLayout());
//          layoutContainer_91.setBorders(true);
//          /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
//          retryIncmCtrPymtSum = new MSFNumberField();
//          retryIncmCtrPymtSum.setAllowDecimals(true); 
//          retryIncmCtrPymtSum.setPropertyEditorType(Long.class); 
//          retryIncmCtrPymtSum.setFormat(NumberFormat.getDecimalFormat());
//          
//          retryIncmCtrPymtSum.setWidth("160px");
//          retryIncmCtrPymtSum.setHideLabel(true);
//          retryIncmCtrPymtSum.setReadOnly(true);
//          layoutContainer_91.add(retryIncmCtrPymtSum, new FlowData(0));
//          layoutContainer1_2502.add(layoutContainer_91);
//           
//          
//          LayoutContainer layoutContainer_92 = new LayoutContainer(new FlowLayout());
//          layoutContainer_92.setBorders(true);
//          /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
//          retryIncmEndPymtSum = new MSFNumberField();
//          retryIncmEndPymtSum.setAllowDecimals(true); 
//          retryIncmEndPymtSum.setPropertyEditorType(Long.class); 
//          retryIncmEndPymtSum.setFormat(NumberFormat.getDecimalFormat());
//          
//          retryIncmEndPymtSum.setWidth("160px");
//          retryIncmEndPymtSum.setHideLabel(true);
//          retryIncmEndPymtSum.setReadOnly(true);
//          layoutContainer_92.add(retryIncmEndPymtSum, new FlowData(0));
//          layoutContainer1_3502.add(layoutContainer_92);
//         
//          
//          LayoutContainer layoutContainer_93 = new LayoutContainer(new FlowLayout());
//          layoutContainer_93.setBorders(true);
//          /** column 퇴직소득_정산금액 : retryIncmClutSum */
//          retryIncmClutSum = new MSFNumberField();
//          retryIncmClutSum.setAllowDecimals(true); 
//          retryIncmClutSum.setPropertyEditorType(Long.class); 
//          retryIncmClutSum.setFormat(NumberFormat.getDecimalFormat());
//          
//          retryIncmClutSum.setWidth("165px");
//          retryIncmClutSum.setHideLabel(true);
//          retryIncmClutSum.setReadOnly(true);
//          layoutContainer_93.add(retryIncmClutSum, new FlowData(0));
//          layoutContainer1_4502.add(layoutContainer_93);
//           
//         
//            LayoutContainer layoutContainer_95 = new LayoutContainer(new FlowLayout());
//            layoutContainer_95.setBorders(true);
//            
//            LabelField lblfldNewLabelfield_38 = new LabelField("퇴직소득정률공제");
//            lblfldNewLabelfield_38.setHeight(24);
//            lblfldNewLabelfield_38.setStyleAttribute("paddingTop", "5px");
//            lblfldNewLabelfield_38.setStyleAttribute("vertical-align", "middle"); 
//            lblfldNewLabelfield_38.setBorders(false);
//            layoutContainer_95.add(lblfldNewLabelfield_38, new FormData("100%"));
//            
//            layoutContainer_89.add(layoutContainer_95); 
//            
//            LayoutContainer layoutContainer_96 = new LayoutContainer(new FlowLayout());
//            layoutContainer_96.setBorders(true); 
//            MSFNumberField nmbrfldNewNumberfield_49 = new MSFNumberField();
////            nmbrfldNewNumberfield_49.setAllowDecimals(true); 
////            nmbrfldNewNumberfield_49.setPropertyEditorType(Long.class); 
////            nmbrfldNewNumberfield_49.setFormat(NumberFormat.getDecimalFormat());
//            
//            nmbrfldNewNumberfield_49.setReadOnly(true);
//            nmbrfldNewNumberfield_49.setEnabled(false);
//            nmbrfldNewNumberfield_49.setWidth("160px");
//            nmbrfldNewNumberfield_49.setHideLabel(true);
//            layoutContainer_96.add(nmbrfldNewNumberfield_49, new FlowData(0));
//            layoutContainer1_2502.add(layoutContainer_96); 
//            
//            LayoutContainer layoutContainer_97 = new LayoutContainer(new FlowLayout());
//            layoutContainer_97.setBorders(true);
//            MSFNumberField nmbrfldNewNumberfield_50 = new MSFNumberField();
////            nmbrfldNewNumberfield_50.setAllowDecimals(true); 
////            nmbrfldNewNumberfield_50.setPropertyEditorType(Long.class); 
////            nmbrfldNewNumberfield_50.setFormat(NumberFormat.getDecimalFormat());
//            
//            nmbrfldNewNumberfield_50.setReadOnly(true);
//            nmbrfldNewNumberfield_50.setEnabled(false);
//            nmbrfldNewNumberfield_50.setWidth("160px");
//            nmbrfldNewNumberfield_50.setHideLabel(true);
//            layoutContainer_97.add(nmbrfldNewNumberfield_50, new FlowData(0));
//            layoutContainer1_3502.add(layoutContainer_97); 
//            
//            LayoutContainer layoutContainer_98 = new LayoutContainer(new FlowLayout());
//            layoutContainer_98.setBorders(true);
//            /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//            retryFxrtDducClutSum = new MSFNumberField();
//            retryFxrtDducClutSum.setAllowDecimals(true); 
//            retryFxrtDducClutSum.setPropertyEditorType(Long.class); 
//            retryFxrtDducClutSum.setFormat(NumberFormat.getDecimalFormat());
//            
//            retryFxrtDducClutSum.setWidth("165px");
//            retryFxrtDducClutSum.setHideLabel(true);
//            retryFxrtDducClutSum.setReadOnly(true);
//            layoutContainer_98.add(retryFxrtDducClutSum, new FlowData(0));
//            layoutContainer1_4502.add(layoutContainer_98);  
//            
//            //근속연수공제 
//            LayoutContainer layoutContainer_100 = new LayoutContainer(new FlowLayout());
//           layoutContainer_100.setBorders(true);
//           LabelField lblfldNewLabelfield_39 = new LabelField("근속연수공제");
//           lblfldNewLabelfield_39.setHeight(24);
//           lblfldNewLabelfield_39.setStyleAttribute("paddingTop", "5px");
//           lblfldNewLabelfield_39.setStyleAttribute("vertical-align", "middle"); 
//           lblfldNewLabelfield_39.setBorders(false);
//           layoutContainer_100.add(lblfldNewLabelfield_39, new FormData("100%"));
//           layoutContainer_89.add(layoutContainer_100);
//           
//           
//           LayoutContainer layoutContainer_101 = new LayoutContainer(new FlowLayout());
//           layoutContainer_101.setBorders(true);
//           MSFNumberField nmbrfldNewNumberfield_52 = new MSFNumberField();
////           nmbrfldNewNumberfield_52.setAllowDecimals(true); 
////           nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
////           nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
//           
//           nmbrfldNewNumberfield_52.setReadOnly(true);
//           nmbrfldNewNumberfield_52.setEnabled(false);
//           nmbrfldNewNumberfield_52.setWidth("160px");
//           nmbrfldNewNumberfield_52.setHideLabel(true);
//           layoutContainer_101.add(nmbrfldNewNumberfield_52, new FlowData(0));
//           layoutContainer1_2502.add(layoutContainer_101);
//           
//           
//           LayoutContainer layoutContainer_102 = new LayoutContainer(new FlowLayout());
//           layoutContainer_102.setBorders(true);
//           MSFNumberField nmbrfldNewNumberfield_53 = new MSFNumberField();
////           nmbrfldNewNumberfield_53.setAllowDecimals(true); 
////           nmbrfldNewNumberfield_53.setPropertyEditorType(Long.class); 
////           nmbrfldNewNumberfield_53.setFormat(NumberFormat.getDecimalFormat());
//           
//           nmbrfldNewNumberfield_53.setReadOnly(true);
//           nmbrfldNewNumberfield_53.setEnabled(false);
//           nmbrfldNewNumberfield_53.setWidth("160px");
//           nmbrfldNewNumberfield_53.setHideLabel(true);
//           layoutContainer_98.add(nmbrfldNewNumberfield_53, new FlowData(0));
//           layoutContainer1_3502.add(layoutContainer_98);
//           
//           
//           LayoutContainer layoutContainer_103 = new LayoutContainer(new FlowLayout());
//           layoutContainer_103.setBorders(true);
//           /** column 근속년수공제_정산금액 : logYrDducSum */
//           logYrDducSum = new MSFNumberField();
//           logYrDducSum.setAllowDecimals(true); 
//           logYrDducSum.setPropertyEditorType(Long.class); 
//           logYrDducSum.setFormat(NumberFormat.getDecimalFormat());
//           
//           logYrDducSum.setWidth("165px");
//           logYrDducSum.setHideLabel(true);
//           logYrDducSum.setReadOnly(true);
//           layoutContainer_103.add(logYrDducSum, new FlowData(0));
//           layoutContainer1_4502.add(layoutContainer_103);
//           
//           
//           LayoutContainer layoutContainer_105 = new LayoutContainer(new FlowLayout());
//          layoutContainer_105.setBorders(true);
//          LabelField lblfldNewLabelfield_40 = new LabelField("퇴직소득과세표준");
//          lblfldNewLabelfield_40.setHeight(24);
//          lblfldNewLabelfield_40.setStyleAttribute("paddingTop", "5px");
//          lblfldNewLabelfield_40.setStyleAttribute("vertical-align", "middle"); 
//          lblfldNewLabelfield_40.setBorders(false);
//          layoutContainer_105.add(lblfldNewLabelfield_40, new FormData("100%"));  
//          layoutContainer_89.add(layoutContainer_105);
//          
//          
//          LayoutContainer layoutContainer_106 = new LayoutContainer(new FlowLayout());
//          layoutContainer_106.setBorders(true);
//          MSFNumberField nmbrfldNewNumberfield_55 = new MSFNumberField();
////          nmbrfldNewNumberfield_55.setAllowDecimals(true); 
////          nmbrfldNewNumberfield_55.setPropertyEditorType(Long.class); 
////          nmbrfldNewNumberfield_55.setFormat(NumberFormat.getDecimalFormat());
//          
//          nmbrfldNewNumberfield_55.setReadOnly(true);
//          nmbrfldNewNumberfield_55.setEnabled(false);
////          nmbrfldNewNumberfield_55.setWidth("160px");
//          nmbrfldNewNumberfield_55.setHideLabel(true);
//          layoutContainer_106.add(nmbrfldNewNumberfield_55, new FlowData(0));
//          layoutContainer1_2502.add(layoutContainer_106);
//         
//          
//          LayoutContainer layoutContainer_107 = new LayoutContainer(new FlowLayout());
//          layoutContainer_107.setBorders(true);
//          MSFNumberField nmbrfldNewNumberfield_56 = new MSFNumberField();
////          nmbrfldNewNumberfield_56.setAllowDecimals(true); 
////          nmbrfldNewNumberfield_56.setPropertyEditorType(Long.class); 
////          nmbrfldNewNumberfield_56.setFormat(NumberFormat.getDecimalFormat());
//          
//          nmbrfldNewNumberfield_56.setReadOnly(true);
//          nmbrfldNewNumberfield_56.setEnabled(false);
////          nmbrfldNewNumberfield_56.setWidth("160px");
//          nmbrfldNewNumberfield_56.setHideLabel(true);
//          layoutContainer_107.add(nmbrfldNewNumberfield_56, new FlowData(0));
//          layoutContainer1_3502.add(layoutContainer_107);
//          
//          
//          LayoutContainer layoutContainer_108 = new LayoutContainer(new FlowLayout());
//          layoutContainer_108.setBorders(true);
//          /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//          retryTxtnStdClutSum = new MSFNumberField();
//          retryTxtnStdClutSum.setAllowDecimals(true); 
//          retryTxtnStdClutSum.setPropertyEditorType(Long.class); 
//          retryTxtnStdClutSum.setFormat(NumberFormat.getDecimalFormat());
////          retryTxtnStdClutSum.setWidth("165px");
//          retryTxtnStdClutSum.setHideLabel(true);
//          layoutContainer_108.add(retryTxtnStdClutSum, new FlowData(0));
//          layoutContainer1_4502.add(layoutContainer_108);
//          
//          layoutContainer100_2.add(hBoxTopFrm01);
//		    
//		  layoutContainerItem02.add(layoutContainer100_2);
//          
//		  //TODO 퇴직소득과세표준계산 
//          LayoutContainer layoutContainer200_2 = new LayoutContainer();
//          layoutContainer200_2.setLayout(new FitLayout()); 
//          layoutContainer200_2.setHeight(235);
//          layoutContainer200_2.setBorders(false);
//	 
//		     //4개의 걸럼
//		    
//		    LayoutContainer hBoxTopFrm02 = new LayoutContainer();  
//	        HBoxLayout hbLayout02 = new HBoxLayout();  
//	        hbLayout02.setPadding(new Padding(0));  
//	        hbLayout02.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
//	        hBoxTopFrm02.setLayout(hbLayout02);  
//	  
//	        //1
//	        LayoutContainer layoutContainer2_1502 = new LayoutContainer();
//          frmlytSch = new FormLayout();  
//          frmlytSch.setLabelWidth(0); 
//          frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//          layoutContainer2_1502.setLayout(frmlytSch);
//          layoutContainer2_1502.setBorders(true); 
//          layoutContainer2_1502.setWidth(178);
//		   
//          //2
//	        LayoutContainer layoutContainer2_2502 = new LayoutContainer();
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer2_2502.setLayout(frmlytSch);
//         layoutContainer2_2502.setBorders(true); 
//         layoutContainer2_2502.setWidth(165);
//		    
//		    //3
//	        LayoutContainer layoutContainer2_3502 = new LayoutContainer();
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer2_3502.setLayout(frmlytSch);
//         layoutContainer2_3502.setBorders(true); 
//         layoutContainer2_3502.setWidth(165);
//		    
//		    //4
//	        LayoutContainer layoutContainer2_4502 = new LayoutContainer();
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer2_4502.setLayout(frmlytSch);
//         layoutContainer2_4502.setBorders(true); 
//         layoutContainer2_4502.setWidth(170);
//		    
//		    
//
//         hBoxTopFrm02.add(layoutContainer2_1502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//         hBoxTopFrm02.add(layoutContainer2_2502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//         hBoxTopFrm02.add(layoutContainer2_3502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//         hBoxTopFrm02.add(layoutContainer2_4502, new HBoxLayoutData(new Margins(0)));  
//         
//         
//         LayoutContainer layoutContainer_110 = new LayoutContainer(new FlowLayout());
//         layoutContainer_110.setStyleAttribute("background-color", "#dfe8f6");
//         layoutContainer_110.setBorders(true);
//         LabelField lblfldNewLabelfield_41 = new LabelField("계 산 내 용");
//         lblfldNewLabelfield_41.setStyleAttribute( "text-align", "center"); 
//         lblfldNewLabelfield_41.setBorders(false);
//         layoutContainer_110.add(lblfldNewLabelfield_41, new FormData("100%"));
//         layoutContainer2_1502.add(layoutContainer_110);
//        
//         
//         LayoutContainer layoutContainer_111 = new LayoutContainer(new FlowLayout());
//         layoutContainer_111.setStyleAttribute("background-color", "#dfe8f6");
//         layoutContainer_111.setBorders(true);
//         LabelField lblfldNewLabelfield_42 = new LabelField("2012.12.31.이전");
//         lblfldNewLabelfield_42.setStyleAttribute( "text-align", "center"); 
//         lblfldNewLabelfield_42.setBorders(false);
//         layoutContainer_111.add(lblfldNewLabelfield_42, new FormData("100%"));
//         layoutContainer2_2502.add(layoutContainer_111);
//         
//         
//         LayoutContainer layoutContainer_112 = new LayoutContainer(new FlowLayout());
//         layoutContainer_112.setStyleAttribute("background-color", "#dfe8f6");
//         layoutContainer_112.setBorders(true);
//         LabelField lblfldNewLabelfield_43 = new LabelField("2013.1.1이후");
//         lblfldNewLabelfield_43.setStyleAttribute( "text-align", "center"); 
//         lblfldNewLabelfield_43.setBorders(false);
//         layoutContainer_112.add(lblfldNewLabelfield_43, new FormData("100%"));
//         layoutContainer2_3502.add(layoutContainer_112);
//         
//         
//         LayoutContainer layoutContainer_113 = new LayoutContainer(new FlowLayout());
//         layoutContainer_113.setStyleAttribute("background-color", "#dfe8f6");
//         layoutContainer_113.setBorders(true);
//         LabelField lblfldNewLabelfield_44 = new LabelField("합 계");
//         lblfldNewLabelfield_44.setStyleAttribute( "text-align", "center"); 
//         lblfldNewLabelfield_44.setBorders(false);
//         layoutContainer_113.add(lblfldNewLabelfield_44, new FormData("100%"));
//         layoutContainer2_4502.add(layoutContainer_113);
//		      
//         //  퇴직소득세액계산
//         LayoutContainer layoutContainer_114 = new LayoutContainer();
//         layoutContainer_114.setStyleAttribute("background-color", "#dfe8f6");
//         layoutContainer_114.setLayout(new ColumnLayout());
//         layoutContainer_114.setBorders(false);
//         
//         final LayoutContainer layoutContainer_115 = new LayoutContainer(new FlowLayout());
//         /**********************************************************************************************************
//          * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//          ***********************************************************************************************************/
//         layoutContainer_115.addListener(Events.Render,  new Listener<BaseEvent>() {
//        	 public void handleEvent(BaseEvent be) {
//        		 layoutContainer_115.removeStyleName("x-border");
//        		 // layoutContainer_16.setStyleName("x-border-u-right",true);
//        		 layoutContainer_115.setStyleName("x-border-u-bottom", true);
//        		 layoutContainer_115.setHeight("80px");
//        	 }
//         });
//         /**********************************************************************************************************
//           * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//           ***********************************************************************************************************/ 
//         frmlytSch = new FormLayout();  
//         frmlytSch.setLabelWidth(0); 
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//         layoutContainer_115.setLayout(frmlytSch);
//         layoutContainer_115.setBorders(true);
//         LabelField lblfldNewLabelfield_45 = new LabelField("퇴직소득세액계산");
//         lblfldNewLabelfield_45.setStyleAttribute("paddingTop", "15px");
//         layoutContainer_115.add(lblfldNewLabelfield_45, new FormData("100%"));
//         layoutContainer_114.add(layoutContainer_115, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//         
//          
//         LayoutContainer layoutContainer_124 = new LayoutContainer(new FlowLayout());
//         layoutContainer_124.setBorders(true);
//         LabelField lblfldNewLabelfield_46 = new LabelField("과세표준안분");
//         lblfldNewLabelfield_46.setHeight(24);
//         lblfldNewLabelfield_46.setStyleAttribute("paddingTop", "5px");
//         lblfldNewLabelfield_46.setStyleAttribute("vertical-align", "middle"); 
//         lblfldNewLabelfield_46.setBorders(false);
//         layoutContainer_124.add(lblfldNewLabelfield_46, new FormData("100%"));
//         layoutContainer_114.add(layoutContainer_124, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//       
//         layoutContainer2_1502.add(layoutContainer_114); 
//         
//         
//         LayoutContainer layoutContainer_125 = new LayoutContainer(new FlowLayout());
//         layoutContainer_125.setBorders(true);
//         /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//         tat12befTxtnStdPpnlSum = new MSFNumberField();
//         tat12befTxtnStdPpnlSum.setAllowDecimals(true); 
//         tat12befTxtnStdPpnlSum.setPropertyEditorType(Long.class); 
//         tat12befTxtnStdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
//         
//         tat12befTxtnStdPpnlSum.setWidth("160px");
//         tat12befTxtnStdPpnlSum.setHideLabel(true);
//         tat12befTxtnStdPpnlSum.setReadOnly(true);
//         layoutContainer_125.add(tat12befTxtnStdPpnlSum, new FlowData(0));
//         layoutContainer2_2502.add(layoutContainer_125);
//         
//         
//         LayoutContainer layoutContainer_126 = new LayoutContainer(new FlowLayout());
//         layoutContainer_126.setBorders(true);
//         /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//         tat13afrTxstdPpnlSum = new MSFNumberField();
//         tat13afrTxstdPpnlSum.setAllowDecimals(true); 
//         tat13afrTxstdPpnlSum.setPropertyEditorType(Long.class); 
//         tat13afrTxstdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
//         
//         tat13afrTxstdPpnlSum.setWidth("160px");
//         tat13afrTxstdPpnlSum.setHideLabel(true);
//         tat13afrTxstdPpnlSum.setReadOnly(true);
//         layoutContainer_126.add(tat13afrTxstdPpnlSum, new FlowData(0));
//         layoutContainer2_3502.add(layoutContainer_126);
//         
//         
//         LayoutContainer layoutContainer_127 = new LayoutContainer(new FlowLayout());
//         layoutContainer_127.setBorders(true);
//         /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//         tatAggrTxtnStdPpnlSum = new MSFNumberField();
//         tatAggrTxtnStdPpnlSum.setAllowDecimals(true); 
//         tatAggrTxtnStdPpnlSum.setPropertyEditorType(Long.class); 
//         tatAggrTxtnStdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
//         
//         tatAggrTxtnStdPpnlSum.setWidth("165px");
//         tatAggrTxtnStdPpnlSum.setHideLabel(true);
//         tatAggrTxtnStdPpnlSum.setReadOnly(true);
//         layoutContainer_127.add(tatAggrTxtnStdPpnlSum, new FlowData(0));
//         layoutContainer2_4502.add(layoutContainer_127);
//       
//           
//         //연평균과세표준
//         
//         LayoutContainer layoutContainer_128 = new LayoutContainer(new FlowLayout());
//        layoutContainer_128.setBorders(true);
//        LabelField lblfldNewLabelfield_50 = new LabelField("연평균과세표준");
//        lblfldNewLabelfield_50.setHeight(24);
//        lblfldNewLabelfield_50.setStyleAttribute("paddingTop", "5px");
//        lblfldNewLabelfield_50.setStyleAttribute("vertical-align", "middle"); 
//        lblfldNewLabelfield_50.setBorders(false);
//        layoutContainer_128.add(lblfldNewLabelfield_50, new FormData("100%"));
//        layoutContainer_114.add(layoutContainer_128, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//        
//        
//        LayoutContainer layoutContainer_129 = new LayoutContainer(new FlowLayout());
//        layoutContainer_129.setBorders(true);
//        /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//        tat12befYravgTxstdSum = new MSFNumberField();
//        tat12befYravgTxstdSum.setAllowDecimals(true); 
//        tat12befYravgTxstdSum.setPropertyEditorType(Long.class); 
//        tat12befYravgTxstdSum.setFormat(NumberFormat.getDecimalFormat());
//        
//        tat12befYravgTxstdSum.setWidth("160px");
//        tat12befYravgTxstdSum.setHideLabel(true);
//        tat12befYravgTxstdSum.setReadOnly(true);
//        layoutContainer_129.add(tat12befYravgTxstdSum, new FlowData(0));
//        layoutContainer2_2502.add(layoutContainer_129);
//       
//        
//        LayoutContainer layoutContainer_130 = new LayoutContainer(new FlowLayout());
//        layoutContainer_130.setBorders(true);
//        /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//        tat13afrYrAvgStdSum = new MSFNumberField();
//        tat13afrYrAvgStdSum.setAllowDecimals(true); 
//        tat13afrYrAvgStdSum.setPropertyEditorType(Long.class); 
//        tat13afrYrAvgStdSum.setFormat(NumberFormat.getDecimalFormat());
//        
//        tat13afrYrAvgStdSum.setWidth("160px");
//        tat13afrYrAvgStdSum.setHideLabel(true);
//        tat13afrYrAvgStdSum.setReadOnly(true);
//        layoutContainer_130.add(tat13afrYrAvgStdSum, new FlowData(0));
//        layoutContainer2_3502.add(layoutContainer_130);
//        
//        
//        LayoutContainer layoutContainer_131 = new LayoutContainer(new FlowLayout());
//        layoutContainer_131.setBorders(true);
//        /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum REadonly 데이타없음.*/
//        tatAggrYrAvgTxtnStdSum = new MSFNumberField();
//        tatAggrYrAvgTxtnStdSum.setAllowDecimals(true); 
//        tatAggrYrAvgTxtnStdSum.setPropertyEditorType(Long.class); 
//        tatAggrYrAvgTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//        tatAggrYrAvgTxtnStdSum.setReadOnly(true);
//      //  tatAggrYrAvgTxtnStdSum.setEnabled(false);
//        tatAggrYrAvgTxtnStdSum.setWidth("165px");
//        tatAggrYrAvgTxtnStdSum.setHideLabel(true);
//        layoutContainer_131.add(tatAggrYrAvgTxtnStdSum, new FlowData(0));
//        layoutContainer2_4502.add(layoutContainer_131);
//        
//         
//        LayoutContainer layoutContainer_132 = new LayoutContainer(new FlowLayout());
//       layoutContainer_132.setBorders(true);
//       LabelField lblfldNewLabelfield_51 = new LabelField("환산과세표준");
//       lblfldNewLabelfield_51.setHeight(24);
//       lblfldNewLabelfield_51.setStyleAttribute("paddingTop", "5px");
//       lblfldNewLabelfield_51.setStyleAttribute("vertical-align", "middle"); 
//       lblfldNewLabelfield_51.setBorders(false);
//       layoutContainer_132.add(lblfldNewLabelfield_51, new FormData("100%"));
//       layoutContainer_114.add(layoutContainer_132, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//       
//       
//       LayoutContainer layoutContainer_133 = new LayoutContainer(new FlowLayout());
//       layoutContainer_133.setBorders(true);
//       /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum readonly*/
//       tat12befCvsnTxtnStdSum = new MSFNumberField();
//       tat12befCvsnTxtnStdSum.setAllowDecimals(true); 
//       tat12befCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
//       tat12befCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//       tat12befCvsnTxtnStdSum.setReadOnly(true);
//      // tat12befCvsnTxtnStdSum.setEnabled(false);
//       tat12befCvsnTxtnStdSum.setWidth("160px");
//       tat12befCvsnTxtnStdSum.setHideLabel(true);
//       layoutContainer_133.add(tat12befCvsnTxtnStdSum, new FlowData(0));
//       layoutContainer2_2502.add(layoutContainer_133);
//       
//       
//       LayoutContainer layoutContainer_134 = new LayoutContainer(new FlowLayout());
//       layoutContainer_134.setBorders(true);
//       /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//       tat13afrCvsnTxtnStdSum = new MSFNumberField();
//       tat13afrCvsnTxtnStdSum.setAllowDecimals(true); 
//       tat13afrCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
//       tat13afrCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//       
//       tat13afrCvsnTxtnStdSum.setWidth("160px");
//       tat13afrCvsnTxtnStdSum.setHideLabel(true);
//       tat13afrCvsnTxtnStdSum.setReadOnly(true);
//       layoutContainer_134.add(tat13afrCvsnTxtnStdSum, new FlowData(0));
//       layoutContainer2_3502.add(layoutContainer_134);
//      
//       
//       LayoutContainer layoutContainer_135 = new LayoutContainer(new FlowLayout());
//       layoutContainer_135.setBorders(true);
//       /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//       tatAggrCvsnTxtnStdSum = new MSFNumberField();
//       tatAggrCvsnTxtnStdSum.setAllowDecimals(true); 
//       tatAggrCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
//       tatAggrCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//       
//       tatAggrCvsnTxtnStdSum.setWidth("165px");
//       tatAggrCvsnTxtnStdSum.setHideLabel(true);
//       tatAggrCvsnTxtnStdSum.setReadOnly(true);
//       layoutContainer_135.add(tatAggrCvsnTxtnStdSum, new FlowData(0));
//       layoutContainer2_4502.add(layoutContainer_135);
//       
//
//       LayoutContainer layoutContainer_136 = new LayoutContainer(new FlowLayout());
//      layoutContainer_136.setBorders(true);
//      LabelField lblfldNewLabelfield_52 = new LabelField("환산산출세액");
//      lblfldNewLabelfield_52.setHeight(24);
//      lblfldNewLabelfield_52.setStyleAttribute("paddingTop", "5px");
//      lblfldNewLabelfield_52.setStyleAttribute("vertical-align", "middle"); 
//      lblfldNewLabelfield_52.setBorders(false);
//      layoutContainer_136.add(lblfldNewLabelfield_52, new FormData("100%"));
//      layoutContainer_114.add(layoutContainer_136, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//     
//      
//      LayoutContainer layoutContainer_137 = new LayoutContainer(new FlowLayout());
//      layoutContainer_137.setBorders(true);
//      /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt readonly*/
//      tat12befCvsnCalcAmnt = new MSFNumberField();
//      tat12befCvsnCalcAmnt.setAllowDecimals(true); 
//      tat12befCvsnCalcAmnt.setPropertyEditorType(Long.class); 
//      tat12befCvsnCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
//      tat12befCvsnCalcAmnt.setReadOnly(true);
//     // tat12befCvsnCalcAmnt.setEnabled(false);
//      tat12befCvsnCalcAmnt.setWidth("160px");
//      tat12befCvsnCalcAmnt.setHideLabel(true);
//      layoutContainer_137.add(tat12befCvsnCalcAmnt, new FlowData(0));
//      layoutContainer2_2502.add(layoutContainer_137);
//       
//      
//      
//      LayoutContainer layoutContainer_138 = new LayoutContainer(new FlowLayout());
//      layoutContainer_138.setBorders(true);
//      /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//      tat13afrCvsnCalcTxAmnt = new MSFNumberField();
//      tat13afrCvsnCalcTxAmnt.setAllowDecimals(true); 
//      tat13afrCvsnCalcTxAmnt.setPropertyEditorType(Long.class); 
//      tat13afrCvsnCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//      
//      tat13afrCvsnCalcTxAmnt.setWidth("160px");
//      tat13afrCvsnCalcTxAmnt.setHideLabel(true);
//      tat13afrCvsnCalcTxAmnt.setReadOnly(true);
//      layoutContainer_138.add(tat13afrCvsnCalcTxAmnt, new FlowData(0));
//      layoutContainer2_3502.add(layoutContainer_138);
//     
//      
//      LayoutContainer layoutContainer_139 = new LayoutContainer(new FlowLayout());
//      layoutContainer_139.setBorders(true); 
//      /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//      tatAggrCvsnCalcTxAmnt = new MSFNumberField();
//      tatAggrCvsnCalcTxAmnt.setAllowDecimals(true); 
//      tatAggrCvsnCalcTxAmnt.setPropertyEditorType(Long.class); 
//      tatAggrCvsnCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//      
//      tatAggrCvsnCalcTxAmnt.setWidth("165px");
//      tatAggrCvsnCalcTxAmnt.setHideLabel(true);
//      tatAggrCvsnCalcTxAmnt.setReadOnly(true);
//      layoutContainer_139.add(tatAggrCvsnCalcTxAmnt, new FlowData(0));
//      layoutContainer2_4502.add(layoutContainer_139);
//      
//       //연평균산출세액
//	      LayoutContainer layoutContainer_140 = new LayoutContainer(new FlowLayout());
//	     layoutContainer_140.setBorders(true);
//	     LabelField lblfldNewLabelfield_53 = new LabelField("연평균산출세액");
//	     lblfldNewLabelfield_53.setHeight(24);
//	     lblfldNewLabelfield_53.setStyleAttribute("paddingTop", "5px");
//	     lblfldNewLabelfield_53.setStyleAttribute("vertical-align", "middle"); 
//	     lblfldNewLabelfield_53.setBorders(false);
//	     layoutContainer_140.add(lblfldNewLabelfield_53, new FormData("100%"));
//	     layoutContainer_114.add(layoutContainer_140, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//	     
//	     
//	     LayoutContainer layoutContainer_141 = new LayoutContainer(new FlowLayout());
//	     layoutContainer_141.setBorders(true);
//	     /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//	     tat12befYrAvgCalcAmnt = new MSFNumberField();
//	     tat12befYrAvgCalcAmnt.setAllowDecimals(true); 
//	     tat12befYrAvgCalcAmnt.setPropertyEditorType(Long.class); 
//	     tat12befYrAvgCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
//	     
//	     tat12befYrAvgCalcAmnt.setWidth("160px");
//	     tat12befYrAvgCalcAmnt.setHideLabel(true);
//	     tat12befYrAvgCalcAmnt.setReadOnly(true);
//	     layoutContainer_141.add(tat12befYrAvgCalcAmnt, new FlowData(0));
//	     layoutContainer2_2502.add(layoutContainer_141);
//	     
//	     
//	     LayoutContainer layoutContainer_142 = new LayoutContainer(new FlowLayout());
//	     layoutContainer_142.setBorders(true);
//	     /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//	     tat13afrYrAvgCalcAmnt = new MSFNumberField();
//	     tat13afrYrAvgCalcAmnt.setAllowDecimals(true); 
//	     tat13afrYrAvgCalcAmnt.setPropertyEditorType(Long.class); 
//	     tat13afrYrAvgCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
//	     
//	     tat13afrYrAvgCalcAmnt.setWidth("160px");
//	     tat13afrYrAvgCalcAmnt.setHideLabel(true);
//	     tat13afrYrAvgCalcAmnt.setReadOnly(true);
//	     layoutContainer_142.add(tat13afrYrAvgCalcAmnt, new FlowData(0));
//	     layoutContainer2_3502.add(layoutContainer_142);
//	     
//	     
//	     LayoutContainer layoutContainer_143 = new LayoutContainer(new FlowLayout());
//	     layoutContainer_143.setBorders(true);
//	     /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//	     tatAggrYrAvgCalcTxAmnt = new MSFNumberField();
//	     tatAggrYrAvgCalcTxAmnt.setAllowDecimals(true); 
//	     tatAggrYrAvgCalcTxAmnt.setPropertyEditorType(Long.class); 
//	     tatAggrYrAvgCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//	     
//	     tatAggrYrAvgCalcTxAmnt.setWidth("165px");
//	     tatAggrYrAvgCalcTxAmnt.setHideLabel(true);
//	     tatAggrYrAvgCalcTxAmnt.setReadOnly(true);
//	     layoutContainer_143.add(tatAggrYrAvgCalcTxAmnt, new FlowData(0));
//	     layoutContainer2_4502.add(layoutContainer_143);
//	     
//	     
//	     
//	     //산출세액
//	     
//	     LayoutContainer layoutContainer_144 = new LayoutContainer(new FlowLayout());
//        layoutContainer_144.setBorders(true);
//        LabelField lblfldNewLabelfield_54 = new LabelField("산출세액");
//        lblfldNewLabelfield_54.setHeight(24);
//        lblfldNewLabelfield_54.setStyleAttribute("paddingTop", "5px");
//        lblfldNewLabelfield_54.setStyleAttribute("vertical-align", "middle"); 
//        lblfldNewLabelfield_54.setBorders(false);
//        layoutContainer_144.add(lblfldNewLabelfield_54, new FormData("100%"));
//        layoutContainer_114.add(layoutContainer_144, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//       
//        
//        LayoutContainer layoutContainer_145 = new LayoutContainer(new FlowLayout());
//        layoutContainer_145.setBorders(true);
//        /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//        tat12befCalcTxAmnt = new MSFNumberField();
//        tat12befCalcTxAmnt.setAllowDecimals(true); 
//        tat12befCalcTxAmnt.setPropertyEditorType(Long.class); 
//        tat12befCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        
//        tat12befCalcTxAmnt.setWidth("160px");
//        tat12befCalcTxAmnt.setHideLabel(true);
//        tat12befCalcTxAmnt.setReadOnly(true);
//        layoutContainer_145.add(tat12befCalcTxAmnt, new FlowData(0));
//        layoutContainer2_2502.add(layoutContainer_145);
//       
//        
//        LayoutContainer layoutContainer_146 = new LayoutContainer(new FlowLayout());
//        layoutContainer_146.setBorders(true);
//        /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
//        tat13afrCalcTxAmnt = new MSFNumberField();
//        tat13afrCalcTxAmnt.setAllowDecimals(true); 
//        tat13afrCalcTxAmnt.setPropertyEditorType(Long.class); 
//        tat13afrCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        
//        tat13afrCalcTxAmnt.setWidth("160px");
//        tat13afrCalcTxAmnt.setHideLabel(true);
//        tat13afrCalcTxAmnt.setReadOnly(true);
//        layoutContainer_146.add(tat13afrCalcTxAmnt, new FlowData(0));
//        layoutContainer2_3502.add(layoutContainer_146);
//        
//        
//        LayoutContainer layoutContainer_147 = new LayoutContainer(new FlowLayout());
//        layoutContainer_147.setBorders(true);
//        /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//        tatAggrCalcTxAmnt = new MSFNumberField();
//        tatAggrCalcTxAmnt.setAllowDecimals(true); 
//        tatAggrCalcTxAmnt.setPropertyEditorType(Long.class); 
//        tatAggrCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        
//        tatAggrCalcTxAmnt.setWidth("165px");
//        tatAggrCalcTxAmnt.setHideLabel(true);
//        tatAggrCalcTxAmnt.setReadOnly(true);
//        layoutContainer_147.add(tatAggrCalcTxAmnt, new FlowData(0));
//        layoutContainer2_4502.add(layoutContainer_147);
//        
//        
//        LayoutContainer layoutContainer_148 = new LayoutContainer(new FlowLayout());
//        layoutContainer_148.setBorders(true);
//        LabelField lblfldNewLabelfield_47 = new LabelField("기납부(또는 기과세이연)세액");
//        lblfldNewLabelfield_47.setHeight(24);
//        lblfldNewLabelfield_47.setStyleAttribute("paddingTop", "5px");
//        lblfldNewLabelfield_47.setStyleAttribute("vertical-align", "middle"); 
//        lblfldNewLabelfield_47.setBorders(false);
//        layoutContainer_148.add(lblfldNewLabelfield_47, new FormData("100%"));
//        layoutContainer_114.add(layoutContainer_148, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//       
//        
//        LayoutContainer layoutContainer_149 = new LayoutContainer(new FlowLayout());
//        layoutContainer_149.setBorders(true);
//        /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt readonly*/
//        tat12befAlpayTxAmnt = new MSFNumberField();
//        tat12befAlpayTxAmnt.setAllowDecimals(true); 
//        tat12befAlpayTxAmnt.setPropertyEditorType(Long.class); 
//        tat12befAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        tat12befAlpayTxAmnt.setReadOnly(true);
//        //tat12befAlpayTxAmnt.setEnabled(false);
//        tat12befAlpayTxAmnt.setWidth("160px");
//        tat12befAlpayTxAmnt.setHideLabel(true);
//        layoutContainer_149.add(tat12befAlpayTxAmnt, new FlowData(0));
//        layoutContainer2_2502.add(layoutContainer_149);
//        
//        
//        LayoutContainer layoutContainer_150 = new LayoutContainer(new FlowLayout());
//        layoutContainer_150.setBorders(true);
//        /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt readonly*/
//        tat13afrAlpayTxAmnt = new MSFNumberField();
//        tat13afrAlpayTxAmnt.setAllowDecimals(true); 
//        tat13afrAlpayTxAmnt.setPropertyEditorType(Long.class); 
//        tat13afrAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        tat13afrAlpayTxAmnt.setReadOnly(true);
//      //  tat13afrAlpayTxAmnt.setEnabled(false);
//        tat13afrAlpayTxAmnt.setWidth("160px");
//        tat13afrAlpayTxAmnt.setHideLabel(true);
//        layoutContainer_150.add(tat13afrAlpayTxAmnt, new FlowData(0));
//        layoutContainer2_3502.add(layoutContainer_150);
//        
//        
//        LayoutContainer layoutContainer_151 = new LayoutContainer(new FlowLayout());
//        layoutContainer_151.setBorders(true);
//        /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//        tatAggrAlpayTxAmnt = new MSFNumberField();
//        tatAggrAlpayTxAmnt.setAllowDecimals(true); 
//        tatAggrAlpayTxAmnt.setPropertyEditorType(Long.class); 
//        tatAggrAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        
//        tatAggrAlpayTxAmnt.setWidth("165px");
//        tatAggrAlpayTxAmnt.setHideLabel(true);
//        tatAggrAlpayTxAmnt.setReadOnly(true);
//        layoutContainer_151.add(tatAggrAlpayTxAmnt, new FlowData(0));
//        layoutContainer2_4502.add(layoutContainer_151);
//       
//        LayoutContainer layoutContainer_152 = new LayoutContainer(new FlowLayout());
//        layoutContainer_152.setBorders(true);
//        LabelField lblfldNewLabelfield_48 = new LabelField("신고대상세액");
//        lblfldNewLabelfield_48.setHeight(24);
//        lblfldNewLabelfield_48.setStyleAttribute("paddingTop", "5px");
//        lblfldNewLabelfield_48.setStyleAttribute("vertical-align", "middle"); 
//        lblfldNewLabelfield_48.setBorders(false);
//        layoutContainer_152.add(lblfldNewLabelfield_48, new FormData("100%"));
//        layoutContainer_114.add(layoutContainer_152, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//        
//        
//        LayoutContainer layoutContainer_153 = new LayoutContainer(new FlowLayout());
//        layoutContainer_153.setBorders(true);
//        /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt readonly*/
//        tat12befRegTgtTxAmnt = new MSFNumberField();
//        tat12befRegTgtTxAmnt.setAllowDecimals(true); 
//        tat12befRegTgtTxAmnt.setPropertyEditorType(Long.class); 
//        tat12befRegTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        tat12befRegTgtTxAmnt.setReadOnly(true);
//     //   tat12befRegTgtTxAmnt.setEnabled(false);
//        tat12befRegTgtTxAmnt.setWidth("160px");
//        tat12befRegTgtTxAmnt.setHideLabel(true);
//        layoutContainer_153.add(tat12befRegTgtTxAmnt, new FlowData(0));
//        layoutContainer2_2502.add(layoutContainer_153);
//        
//        
//        LayoutContainer layoutContainer_154 = new LayoutContainer(new FlowLayout());
//        layoutContainer_154.setBorders(true);
//        /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//        tat13afrRegrstTgtSum = new MSFNumberField();
//        tat13afrRegrstTgtSum.setAllowDecimals(true); 
//        tat13afrRegrstTgtSum.setPropertyEditorType(Long.class); 
//        tat13afrRegrstTgtSum.setFormat(NumberFormat.getDecimalFormat());
//        
//        tat13afrRegrstTgtSum.setWidth("160px");
//        tat13afrRegrstTgtSum.setHideLabel(true);
//        tat13afrRegrstTgtSum.setReadOnly(true);
//        layoutContainer_154.add(tat13afrRegrstTgtSum, new FlowData(0));
//        layoutContainer2_3502.add(layoutContainer_154);
//        
//        
//        LayoutContainer layoutContainer_155 = new LayoutContainer(new FlowLayout());
//        layoutContainer_155.setBorders(true);
//        /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//        tatAggrRegrstTgtTxAmnt = new MSFNumberField();
//        tatAggrRegrstTgtTxAmnt.setAllowDecimals(true); 
//        tatAggrRegrstTgtTxAmnt.setPropertyEditorType(Long.class); 
//        tatAggrRegrstTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//        
//        tatAggrRegrstTgtTxAmnt.setWidth("165px");
//        tatAggrRegrstTgtTxAmnt.setHideLabel(true);
//        tatAggrRegrstTgtTxAmnt.setReadOnly(true);
//        layoutContainer_155.add(tatAggrRegrstTgtTxAmnt, new FlowData(0));
//        layoutContainer2_4502.add(layoutContainer_155);
//        
//         layoutContainer200_2.add(hBoxTopFrm02);
//		    
//		 layoutContainerItem02.add(layoutContainer200_2);
		    
		 return layoutContainerItem02; 
		  }  
	  
	  
	   
	  
	  private LayoutContainer createTabGridItem02() {
		   
		    LayoutContainer layoutContainerGridItem02 = new LayoutContainer();
		    layoutContainerGridItem02.setLayout(new FormLayout()); 
		    layoutContainerGridItem02.setBorders(false);
		     
			  //String name, double open, double change, double pctChange, double pctChange1
			
//			  List<DtRemt0200> dtRemt0200 = new ArrayList<DtRemt0200>();
//
//			  dtRemt0200.add(new DtRemt0200("신고대상세액", 308605L, 30860L, 0L,339465L));
//			  dtRemt0200.add(new DtRemt0200("이연퇴직소득세", 0L, 0L, 0L,0L));
//			  dtRemt0200.add(new DtRemt0200("차감원천징수세액", 308600L, 30860L, 0L,339465L));
//			  
//			   
//			    
//			   // RowNumberer r = new RowNumberer();   
//
//			    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
//			  //  configs.add(r);   
//
//			    //final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();    
//			  
//			   // configs.add(sm.getColumn());   
//			  
//			    ColumnConfig column = new ColumnConfig();   
//			    column.setId("name");   
//			    column.setHeaderText("구 분");  
//			    column.setAlignment(HorizontalAlignment.LEFT); 
//			    column.setWidth(120);   
//			    configs.add(column);   
//			  
//			    column = new ColumnConfig();   
//			    column.setId("open");   
//			    column.setHeaderText("소득세");   
//			    column.setAlignment(HorizontalAlignment.RIGHT);   
//			    column.setNumberFormat(NumberFormat.getDecimalFormat());
//			    column.setWidth(90);   
//			    configs.add(column);   
//			    
//			    column = new ColumnConfig();   
//			    column.setId("change");   
//			    column.setHeaderText("지방소득세");   
//			    column.setAlignment(HorizontalAlignment.RIGHT); 
//			    column.setNumberFormat(NumberFormat.getDecimalFormat());
//			    column.setWidth(90);    
//			    configs.add(column);   
//			    
//			    column = new ColumnConfig();   
//			    column.setId("pctChange");   
//			    column.setHeaderText("농어촌특별세");   
//			    column.setAlignment(HorizontalAlignment.RIGHT);  
//			    column.setNumberFormat(NumberFormat.getDecimalFormat());
//			    column.setWidth(90);      
//			    configs.add(column);   
//			    
//			    column = new ColumnConfig();   
//			    column.setId("pctChange1");   
//			    column.setHeaderText("계");   
//			    column.setAlignment(HorizontalAlignment.RIGHT);   
//			    column.setNumberFormat(NumberFormat.getDecimalFormat());
//			    column.setWidth(100);     
//			    configs.add(column);   
//			     
//			    ListStore<DtRemt0200> store = new ListStore<DtRemt0200>();   
//			    store.add(dtRemt0200);   
//			  
//			    ColumnModel cm = new ColumnModel(configs);    
//			    
//			    ContentPanel cp = new ContentPanel();   
//			    cp.setHeaderVisible(false);
//			    cp.setFrame(true);   
//			    cp.setIcon(MSFMainApp.ICONS.table());   
//			    cp.setLayout(new FitLayout());   
//			    //cp.setSize(300, 514);   
//			  
//			    Grid<DtRemt0200> grid = new Grid<DtRemt0200>(store, cm);   
//			   // grid.setSelectionModel(sm);   
//			    grid.setBorders(true);   
//			  //  grid.setColumnReordering(true);   
//			   // grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
//			  //  grid.addPlugin(sm);    

			   
			    ContentPanel cpGrid = new ContentPanel();   
			    cpGrid.setBodyBorder(true); 
			    cpGrid.setHeaderVisible(false);   
			    cpGrid.setLayout(new FitLayout());      
			    cpGrid.setSize(630, 90);   
			    
			    remtSubtn3100GridPanel = new MSFGridPanel(remtSubtn3100Def, false, false, false, false);
			    remtSubtn3100GridPanel.setHeaderVisible(false);  
			    remtSubtn3100GridPanel.setBodyBorder(true);
			    remtSubtn3100GridPanel.setBorders(true);
			    remtSubtn3100GridPanel.getBottomComponent().setVisible(false);
				//remtSubtn3100GridPanel.setVisible(false);
			    //remtSubtn3100GridPanel   .setGridType(MSFGridType.GROUPBY);
			    //remtSubtn3100GridPanel.setSize(936, 440); 
			  
			    cpGrid.add(remtSubtn3100GridPanel); 
			  
			    layoutContainerGridItem02.add(cpGrid);
			   
			return layoutContainerGridItem02; 
		  }  
	  
	  
	  private LayoutContainer createTabGridItem01() {
		    
 
		    
		   lcTabFormLayer = new LayoutContainer();
		    
	 	   ContentPanel cp01 = new ContentPanel();   
	 	   cp01.setBodyBorder(false); 
	 	   cp01.setHeaderVisible(false);
	 	   cp01.setLayout(new FitLayout());      
	 	   cp01.setSize(630, 100);  
	 	   
			
	 	  remt3200DefGridPanel = new MSFGridPanel(remt3200Def, false, false, false, false,false);
	  	  remt3200DefGridPanel.setHeaderVisible(false);  
	 	  remt3200DefGridPanel.setBodyBorder(true);
	 	  remt3200DefGridPanel.setBorders(true);
	 	  remt3200DefGridPanel.getBottomComponent().setVisible(false);
		  //remt3200DefGridPanel.setVisible(false);
	      //remt3200DefGridPanel   .setGridType(MSFGridType.GROUPBY);
	      remt3200DefGridPanel.setSize(630, 100); 
	 	   
	 	  
	 	   cp01.add(remt3200DefGridPanel);
	 	   // grid.setSize("630px", "80px");
		   
	 	  cp01.addButton(  new Button("취소", new SelectionListener<ButtonEvent>() {   
	 	        @Override  
	 	        public void componentSelected(ButtonEvent ce) {   
	 	            
//	 	            if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//	 	                MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//	 	                return;
//	 	            }
	 	        	remt3200DefGridPanel.reload();
	 	        }   
	 	      }));    
	 	  
	 	   cp01.addButton( new Button("신규", new SelectionListener<ButtonEvent>() {   
	 	      @Override  
	 	      public void componentSelected(ButtonEvent ce) {   
	 	    	  
	 	    	   setListRecord(null);
//	 	           BaseModel bm = new BaseModel(); 
	 	         
	 	    	  if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	 	             return;
	 	          }
	 	    	  
//	 	           if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//	 	               MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//	 	               return;
//	 	           }
	 	      
	 	    	    BaseModel bmData = remt3200DefGridPanel.getTableDef().getDefaultValues(); 
	 	    	  
					bmData.set("antyAccuSeilNum",0L);    /** column 연금계좌일련번호 : antyAccuSeilNum */
					bmData.set("dpobCd",MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
					bmData.set("clutYrMnth", clutYrMnth.getValue());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
					bmData.set("calcSevePayPsnDivCd",RemtUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
					bmData.set("systemkey",systemkey.getValue());    /** column SYSTEMKEY : systemkey */
					bmData.set("antyAccuBusoprNum","");    /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
					bmData.set("antyAccuBusoprNm","");    /** column 연금계좌_사업자명 : antyAccuBusoprNm */
					bmData.set("antyAccuAccuNum","");    /** column 연금계좌_계좌번호 : antyAccuAccuNum */
					bmData.set("antyAccuDepitSum",0L);    /** column 연금계좌_입금금액 : antyAccuDepitSum */
					//bmData.set("antyAccuDepitDt","");    /** column 연금계좌_입금일자 : antyAccuDepitDt */
  
                           
                     remt3200DefGridPanel.getMsfGrid().getGrid().stopEditing();      
                     remt3200DefGridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
                     remt3200DefGridPanel.getMsfGrid().getGrid().startEditing(remt3200DefGridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 4);   
                  // remt3200DefGridPanel.getMsfGrid().getGrid().getStore().getAt(0).set("mnthPayAdmntAssoBssCtnt"," ");
                  // remt3200DefGridPanel.getMsfGrid().getGrid().getStore().update(remt3200GridPanel.getMsfGrid().getGrid().getStore().getAt(0));
                     remt3200DefGridPanel.getMsfGrid().getGrid().getStore().getRecord(remt3200DefGridPanel.getMsfGrid().getGrid().getStore().getAt(0)).setDirty(true);
                   
                    actionDatabase = ActionDatabase.INSERT; 
	 	        
	 	       
	 	      }   
	 	    }));
	 	  
	 	  cp01.addButton(  new Button("저장", new SelectionListener<ButtonEvent>() {   
	 	     @Override  
	 	    public void componentSelected(ButtonEvent ce) {   
	 	       
	 			 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	 	            return;
	 	        }
	 			 
//	 	        if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//	 	            MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//	 	            return;
//	 	        } 
	 	         
	 	        MessageBox.confirm("이연계좌저장", "과세이연계좌명세 내역을 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
	 	            @Override
	 	            public void handleEvent(MessageBoxEvent be) {
	 	               // if("Yes".equals(be.getButtonClicked().getText())){
	 	            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	 	                    
	 	                	 setListRecord(remt3200DefGridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());  
	 	                     
	 	                     if (MSFSharedUtils.paramNull(getListRecord()) || !getListRecord().hasNext()) {
	 	                     	List<Record>  lsRec  = new ArrayList<Record>();
	 	                     	for ( int i = 0; i < remt3200DefGridPanel.getMsfGrid().getStore().getCount(); i++){
	 	             			  if(remt3200DefGridPanel.getMsfGrid().getStore().getRecord(remt3200DefGridPanel.getMsfGrid().getStore().getAt(i)).isDirty()){ //변경된 로우가 있을경우
	 	             				    BaseModel bm = remt3200DefGridPanel.getMsfGrid().getStore().getAt(i); 
	 	             				    lsRec.add(remt3200DefGridPanel.getMsfGrid().getStore().getRecord(bm));
	 	             			  }
	 	             			}
	 	                     	
	 	                     	setListRecord(lsRec.iterator()); 
	 	                     	
	 	                     }
	 	                  
	 	                     doAction(actionDatabase); 
	 	                        
	 	                }
	 	            }
	 	        });   
	 	      
	 	       
	 	         
	 	    }   
	 	  })); 
	 	  
	 	 cp01.addButton(  new Button("삭제", new SelectionListener<ButtonEvent>() {   
	 	        @Override  
	 	        public void componentSelected(ButtonEvent ce) {   
	 	        	
	 	        	 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	 	                return;
	 	            }
	 	            
//	 	            if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//	 	                MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//	 	                return;
//	 	            }
	 	           
	 	            
	 	            MessageBox.confirm("이연계좌삭제", "과세이연계좌 내역을 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
	 	                @Override
	 	                public void handleEvent(MessageBoxEvent be) {
	 	                   // if("Yes".equals(be.getButtonClicked().getText())){
	 	                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

	 	                        
	 	                        Iterator<BaseModel> itBm  = remt3200DefGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	 	                        
	 	                        List<Record>  lsRec  = new ArrayList<Record>();
	 	                        
	 	                        while(itBm.hasNext()) {

	 	                            Record rec  = new Record(itBm.next()); 
	 	                            lsRec.add(rec);
	 	                            
	 	                        } 
	 	                         setListRecord(lsRec.iterator()); 
	 	                     
	 	                         actionDatabase = ActionDatabase.DELETE;
	 	                         doAction(actionDatabase);
	 	                          
	 	                            
	 	                    }
	 	                }
	 	            });   
	 	            
	 	        }   
	 	      }));     
		    lcTabFormLayer.add(cp01);
		    
		   return lcTabFormLayer;  
		  }  
	   
	  
		public void reload() {
			// TODO Auto-generated method stub
		   
			IColumnFilter filters = null; 
			remt3000DefGridPanel.getTableDef().setTableColumnFilters(filters);
		 
			//정산년월
			remt3000DefGridPanel.getTableDef().addColumnFilter("clutYrMnth", (MSFSharedUtils.getSelectedComboValue(srhClutYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhClutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		        
			//정산구분
			remt3000DefGridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		          
			remt3000DefGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			remt3000DefGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		     String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		     remt3000DefGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
            
             String strTypOccuCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             remt3000DefGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             
           //  String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
            // remt3000DefGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
             
             String strDtilOccuInttnCd = RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
             remt3000DefGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	         
             remt3000DefGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			  
	 
             
             remt3000DefGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
             remt3000DefGridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
             remt3000DefGridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			 
			 
             remt3000DefGridPanel.reload();
		}

	//폼초기화 검색조건포함 
	   private void formInit() {
		   
		    dpobCd.setValue("");   /** column 사업장코드 : dpobCd */
		    calcSevePsnBlggYr.reset();   /** column 퇴직정산귀속년 : calcSevePsnBlggYr */
		    calcSevePsnBlggMnth.reset();   /** column 퇴직정산귀속월 : calcSevePsnBlggMnth */
		    calcSevePayPsnDivCd.reset();   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		    systemkey.setValue("");    /** column SYSTEMKEY : systemkey */
		    reipDt.reset();   /** column 영수일자 : reipDt */
		    ddlneDt.reset();   /** column 마감일자 : ddlneDt */
		    deptCd.setValue("");    /** column 부서코드 : deptCd */
		    deptNm.setValue("");    /** column 부서 : deptNm */
		    emymtDivNm.setValue("");    /** column 고용구분 : emymtDivNm */
		    typOccuNm.setValue("");    /** column 직종 : typOccuNm */
		    hanNm.setValue("");    /** column 한글성명 : hanNm */
		    resnRegnNum.setValue("");    /** column 주민등록번호 : resnRegnNum */
		    aimenrEcteYn.setValue(false);  /** column 소득자임원여부 : aimenrEcteYn */
		    fixPayJnDt.reset();   /** column 확정급여형가입일자 : fixPayJnDt */
		    sevePay20111231Sum.setValue(0);   /** column 퇴직금_20111231금액 : sevePay20111231Sum */
		    frgnrDivCd.setValue("");    /** column 외국인구분코드 : frgnrDivCd */
		    ridnSeptYn.setValue(true);   /** column 거주구분여부 : ridnSeptYn */
		    ridnCd.setValue("");    /** column 거주지국코드 : ridnCd */
		    ridnNm.setValue("");    /** column 거주지국명 : ridnNm */
		    blggYrBgnnDt.reset();   /** column 귀속년도시작일자 : blggYrBgnnDt */
		    blggYrEndDt.reset();   /** column 귀속년도종료일자 : blggYrEndDt */
		    retryReasCd.reset();   /** column 퇴직사유코드 : retryReasCd */
		    ctrRetryReasNm.setValue("");   /** column 중간퇴직사유 : ctrRetryReasNm */
		    ctrBusoprRgstnNum.setValue("");   /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
		    ctrPaeWorkNm.setValue("");   /** column 중_근무처명 : ctrPaeWorkNm */
		 //   ctrRetryPayQnty.setValue(0);   /** column 중_퇴직급여액 : ctrRetryPayQnty */
		    ctrFreeDtyRetryPayQnty.setValue(0);   /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
		    ctrTxtnTgtRetryPayQnty.setValue(0);   /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
		    endBusoprRgstnNum.setValue("");   /** column 종_사업자등록번호 : endBusoprRgstnNum */
		    endPaeWorkNm.setValue("");;   /** column 종_근무처명 : endPaeWorkNm */
		   // endRetryPayQnty.setValue(0);   /** column 종_퇴직급여액 : endRetryPayQnty */
		    endFreeDtyRetryPayQnty.setValue(0);   /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
		    endTxtnTgtRetryPayQnty.setValue(0);   /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
		//    clutRetryPayQnty.setValue(0);   /** column 정산_퇴직급여액 : clutRetryPayQnty */
		    clutFreeDtyRetryPayQnty.setValue(0);   /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
		    clutTxtnTgtRetryPayQnty.setValue(0);   /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
		    ctrIcncDt.setValue("");   /** column 중_입사일자 : ctrIcncDt */
		    ctrRkfcdDt.setValue("");   /** column 중_기산일자 : ctrRkfcdDt */
		    ctrRsgtnDt.setValue("");   /** column 중_퇴사일자 : ctrRsgtnDt */
		    ctrPymtDt.setValue("");   /** column 중_지급일자 : ctrPymtDt */
		    ctrViewIcncDt.setValue("");   /** column 중_입사일자 : ctrIcncDt */
		    ctrViewRkfcdDt.setValue("");   /** column 중_기산일자 : ctrRkfcdDt */
		    ctrViewRsgtnDt.setValue("");   /** column 중_퇴사일자 : ctrRsgtnDt */
		    ctrViewPymtDt.setValue("");   /** column 중_지급일자 : ctrPymtDt */
		    ctrLogSvcMnthIcm.setValue(0);   /** column 중_근속월수 : ctrLogSvcMnthIcm */
		    ctrViewLogSvcMnthIcm.setValue(0);   /** column 중_근속월수 : ctrLogSvcMnthIcm */
		    ctrEepnMnth12Bfr.setValue(0);   /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
		    ctrEepnMnth13Aft.setValue(0);   /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
		    ctrAddMnth12Bfr.setValue(0);   /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
		    ctrAddMnth13Aft.setValue(0);   /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
		    ctrEepnMnthIcm.setValue(0);   /** column 중_제외월수 : ctrEepnMnthIcm */
		    ctrAddMnthIcm.setValue(0);   /** column 중_가산월수 : ctrAddMnthIcm */
		    ctrDupMnthIcm.setValue(0);   /** column 중_중복월수 : ctrDupMnthIcm */
		    ctrLogSvc.setValue(0);   /** column 중_근속연수 : ctrLogSvc */
		    endIcncDt.setValue("");   /** column 종_입사일자 : endIcncDt */
		    endRkfcdDt.setValue("");   /** column 종_기산일자 : endRkfcdDt */
		    endRsgtnDt.setValue("");   /** column 종_퇴사일자 : endRsgtnDt */
		    endPymtDt.setValue("");   /** column 종_지급일자 : endPymtDt */
		    endViewIcncDt.setValue("");   /** column 종_입사일자 : endIcncDt */
		    endViewIcncDt.setValue("");   /** column 종_기산일자 : endRkfcdDt */
		    endViewIcncDt.setValue("");   /** column 종_퇴사일자 : endRsgtnDt */
		    endViewIcncDt.setValue("");   /** column 종_지급일자 : endPymtDt */
		    
		    endLogSvcMnthIcm.setValue(0);   /** column 종_근속월수 : endLogSvcMnthIcm */
		    endViewLogSvcMnthIcm.setValue(0);   /** column 종_근속월수 : endLogSvcMnthIcm */
		    endEepnMnth12Bfr.setValue(0);   /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
		    endEepnMnth13Aft.setValue(0);   /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
		    endAddMnth12Bfr.setValue(0);   /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
		    endAddMnth13Aft.setValue(0);   /** column 종_가산월수_2013이후 : endAddMnth13Aft */
		    endEepnMnthIcm.setValue(0);   /** column 종_제외월수 : endEepnMnthIcm */
		    endAddMnthIcm.setValue(0);   /** column 종_가산월수 : endAddMnthIcm */
		    endDupMnthIcm.setValue(0);   /** column 종_중복월수 : endDupMnthIcm */
		    endLogSvcYrNum.setValue(0);   /** column 종_근속연수 : endLogSvcYrNum */
		    clutIcncDt.setValue("");   /** column 정산_입사일자 : clutIcncDt */
		    clutRkfcdDt.setValue("");   /** column 정산-기산일자 : clutRkfcdDt */
		    clutRsgtnDt.setValue("");   /** column 정산_퇴사일자 : clutRsgtnDt */
		    clutPymtDt.setValue("");   /** column 정산_지급일자 : clutPymtDt */
		    clutLogSvcMnthIcm.setValue(0);   /** column 정산_근속월수 : clutLogSvcMnthIcm */
		    clutEepnMnthIcm.setValue(0);   /** column 정산_제외월수 : clutEepnMnthIcm */
		    clutAddMnthIcm.setValue(0);   /** column 정산_가산월수 : clutAddMnthIcm */
		    clutDupMnthIcm.setValue(0);   /** column 정산_중복월수 : clutDupMnthIcm */
		    clutLogSvcYrNum.setValue(0);   /** column 정산_근속연수 : clutLogSvcYrNum */
		    logPpnl12befIcncDt.setValue("");   /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
		    logPpnl12befRkfcdDt.setValue("");   /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
		    logPpnl12befRsgtnDt.setValue("");   /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
		    logPpnl12befPymtDt.setValue("");   /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
		    logPpnl12befLogMnthIcm.setValue(0);   /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
		    logPpnl12befEepnMnthIcm.setValue(0);   /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
		    logPpnl12befAddMnthIcm.setValue(0);   /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
		    logPpnl12befDupMnthIcm.setValue(0);   /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
		    logPpnl12befLogYrNum.setValue(0);   /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */        
		    logPpnl13afrIcncDt.setValue("");   /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */           
		    logPpnl13afrRkfcdDt.setValue("");   /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */         
		    logPpnl13afrRsgtnDt.setValue("");   /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */         
		    logPpnl13afrPymtDt.setValue("");   /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */           
		    logPpnl13afrLogMnthIcm.setValue(0);   /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */    
		    logPpnl13afrEepnMnthIcm.setValue(0);   /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */  
		    logPpnl13afrAddMnthIcm.setValue(0);   /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */    
		    logPpnl13afrDupMnthIcm.setValue(0);   /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */    
		    logPpnl13afrLogSvc.setValue(0);   /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */            
		    retryIncmCtrPymtSum.setValue(0);   /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */              
		    retryIncmEndPymtSum.setValue(0);   /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */              
		    retryIncmClutSum.setValue(0);   /** column 퇴직소득_정산금액 : retryIncmClutSum */                      
		    retryFxrtDducClutSum.setValue(0);   /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */          
		    logYrDducSum.setValue(0);   /** column 근속년수공제_정산금액 : logYrDducSum */                            
		    retryTxtnStdClutSum.setValue(0);   /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */            
		    tat12befTxtnStdPpnlSum.setValue(0);   /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */  
		    tat12befYravgTxstdSum.setValue(0);   /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */   
		    tat12befCvsnTxtnStdSum.setValue(0);   /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */  
		    tat12befCvsnCalcAmnt.setValue(0);   /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */      
		    tat12befYrAvgCalcAmnt.setValue(0);   /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */     
		    tat12befCalcTxAmnt.setValue(0);   /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */              
		    tat12befAlpayTxAmnt.setValue(0);   /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */           
		    tat12befRegTgtTxAmnt.setValue(0);   /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */        
		    tat13afrTxstdPpnlSum.setValue(0);   /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */      
		    tat13afrYrAvgStdSum.setValue(0);   /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */       
		    tat13afrCvsnTxtnStdSum.setValue(0);   /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */  
		    tat13afrCvsnCalcTxAmnt.setValue(0);   /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */    
		    tat13afrYrAvgCalcAmnt.setValue(0);   /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */     
		    tat13afrCalcTxAmnt.setValue(0);   /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */              
		    tat13afrAlpayTxAmnt.setValue(0);   /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */           
		    tat13afrRegrstTgtSum.setValue(0);   /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */        
		    tatAggrTxtnStdPpnlSum.setValue(0);   /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */       
		    tatAggrYrAvgTxtnStdSum.setValue(0);   /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */    
		    tatAggrCvsnTxtnStdSum.setValue(0);   /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */       
		    tatAggrCvsnCalcTxAmnt.setValue(0);   /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */         
		    tatAggrYrAvgCalcTxAmnt.setValue(0);   /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */      
		    tatAggrCalcTxAmnt.setValue(0);   /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */                   
		    tatAggrAlpayTxAmnt.setValue(0);   /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */                
		    tatAggrRegrstTgtTxAmnt.setValue(0);   /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */       
		    talRegrstTgtTxAmnt.setValue(0);   /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */                
		   // talAccuDepitAggrSum.setValue(0);   /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */            
		    talRetryPayQnty.setValue(0);   /** column 이연세액_퇴직급여액 : talRetryPayQnty */                       
		    talRetryIncmTxAmnt.setValue(0);   /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */              
 
		   
		   remt3000DefGridPanel.getMsfGrid().clearData();
		   
		   actionDatabase = ActionDatabase.UPDATE;
		   
		   //급여상세정보초기화 
	   }
	   
	   
	   
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 

	   private Remt0200 getThis(){
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

	  private void reloadRemt0200ToRemt3100(){
	       
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	           return;
	       }
        
	       Remt3100DTO remt3100Dto = new Remt3100DTO(); 
	      	 
	       remt3100Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));         /**  column 사업장코드 : dpobCd */
	       remt3100Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));        /**  column SYSTEMKEY : systemkey */ 
	       remt3100Dto.setClutYrMnth(clutYrMnth.getValue());     /** column 퇴직정산정산년월 : clutYrMnth */  
		      
	       remt3100Dto.setCalcSevePsnBlggYrMnth(MSFSharedUtils.allowNulls(RemtUtils.getSelectedComboValue(calcSevePsnBlggYr,"year").concat(RemtUtils.getSelectedComboValue(calcSevePsnBlggMnth,"month"))));    /** column 정산년월 : clutYrMnth */	  
	       remt3100Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(RemtUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	          
	      	remt0200Service.activityOnReadRemt0200(remt3100Dto, 
	                                    new AsyncCallback<Remt3100DTO>() {
	    			 
	                public void onFailure(Throwable caught) {
	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0200" + caught), null);
	                }
	                public void onSuccess(Remt3100DTO result) { 
	                	//리턴 결과 
//						dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
//						clutYrMnth.setValue(result.getClutYrMnth());    /** column 퇴직정산정산년월 : clutYrMnth */
//						calcSevePayPsnDivCd.setValue(result.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//						systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                	calcSevePsnBlggYrMnth.setValue(result.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
						deptCd.setValue(result.getDeptCd());    /** column 부서코드 : deptCd */
						hanNm.setValue(result.getHanNm());    /** column 한글성명 : hanNm */
						resnRegnNum.setValue(result.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
						aimenrEcteYn.setValue(result.getAimenrEcteYn());    /** column 소득자임원여부 : aimenrEcteYn */
						fixPayJnDt.setValue(GWTUtils.getDateFromString(result.getFixPayJnDt(), "yyyyMMdd"));    /** column 확정급여형가입일자 : fixPayJnDt */
						sevePay20111231Sum.setValue(result.getSevePay20111231Sum());    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
						frgnrDivCd.setValue(result.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
						ridnSeptYn.setValue(result.getRidnSeptYn());    /** column 거주구분여부 : ridnSeptYn */
						ridnCd.setValue(MSFSharedUtils.allowNulls(result.getRidnCd()));    /** column 거주지국코드 : ridnCd */
						ridnNm.setValue(MSFSharedUtils.allowNulls(result.getRidnNm()));    /** column 거주지국명 : ridnNm */
						blggYrBgnnDt.setValue(GWTUtils.getDateFromString(result.getBlggYrBgnnDt(), "yyyyMMdd"));    /** column 귀속년도시작일자 : blggYrBgnnDt */
						blggYrEndDt.setValue(GWTUtils.getDateFromString(result.getBlggYrEndDt(), "yyyyMMdd"));    /** column 귀속년도종료일자 : blggYrEndDt */
						//ctrRetryReasNm.setValue(lsRetryReasCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getRetryReasCd())));    /** column 종 퇴직사유 : ctrRetryReasCd */
						ctrBusoprRgstnNum.setValue(MSFSharedUtils.allowNulls(result.getCtrBusoprRgstnNum()));     /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
						ctrPaeWorkNm.setValue(result.getCtrPaeWorkNm());    /** column 중_근무처명 : ctrPaeWorkNm */
					//	ctrRetryPayQnty.setValue(result.getCtrRetryPayQnty());    /** column 중_퇴직급여액 : ctrRetryPayQnty */
						ctrFreeDtyRetryPayQnty.setValue(result.getCtrFreeDtyRetryPayQnty());    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
						ctrTxtnTgtRetryPayQnty.setValue(result.getCtrTxtnTgtRetryPayQnty());    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
						endBusoprRgstnNum.setValue(result.getEndBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
						endPaeWorkNm.setValue(result.getEndPaeWorkNm());    /** column 종_근무처명 : endPaeWorkNm */
						retryReasCd.setValue(lsRetryReasCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getRetryReasCd())));    /** column 퇴직사유코드 : retryReasCd */
					//	endRetryPayQnty.setValue(result.getEndRetryPayQnty());    /** column 종_퇴직급여액 : endRetryPayQnty */
						endFreeDtyRetryPayQnty.setValue(result.getEndFreeDtyRetryPayQnty());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
						endTxtnTgtRetryPayQnty.setValue(result.getEndTxtnTgtRetryPayQnty());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
					//	clutRetryPayQnty.setValue(result.getClutRetryPayQnty());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
						clutFreeDtyRetryPayQnty.setValue(result.getClutFreeDtyRetryPayQnty());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
						clutTxtnTgtRetryPayQnty.setValue(result.getClutTxtnTgtRetryPayQnty());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
						ctrIcncDt.setValue(result.getCtrIcncDt());    /** column 중_입사일자 : ctrIcncDt */
						ctrRkfcdDt.setValue(result.getCtrRkfcdDt());    /** column 중_기산일자 : ctrRkfcdDt */
						ctrRsgtnDt.setValue(result.getCtrRsgtnDt());    /** column 중_퇴사일자 : ctrRsgtnDt */
						ctrPymtDt.setValue(result.getCtrPymtDt());    /** column 중_지급일자 : ctrPymtDt */
						
						ctrViewIcncDt.setValue(result.getCtrIcncDt());    /** column 중_입사일자 : ctrIcncDt */
						ctrViewRkfcdDt.setValue(result.getCtrRkfcdDt());    /** column 중_기산일자 : ctrRkfcdDt */
						ctrViewRsgtnDt.setValue(result.getCtrRsgtnDt());    /** column 중_퇴사일자 : ctrRsgtnDt */
						ctrViewPymtDt.setValue(result.getCtrPymtDt());    /** column 중_지급일자 : ctrPymtDt */
						
						ctrLogSvcMnthIcm.setValue(result.getCtrLogSvcMnthIcm());    /** column 중_근속월수 : ctrLogSvcMnthIcm */
						ctrViewLogSvcMnthIcm.setValue(result.getCtrLogSvcMnthIcm());    /** column 중_근속월수 : ctrLogSvcMnthIcm */
						
						ctrEepnMnth12Bfr.setValue(result.getCtrEepnMnth12Bfr());    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
						ctrEepnMnth13Aft.setValue(result.getCtrEepnMnth13Aft());    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
						ctrAddMnth12Bfr.setValue(result.getCtrAddMnth12Bfr());    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
						ctrAddMnth13Aft.setValue(result.getCtrAddMnth13Aft());    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
						ctrEepnMnthIcm.setValue(result.getCtrEepnMnthIcm());    /** column 중_제외월수 : ctrEepnMnthIcm */
						ctrAddMnthIcm.setValue(result.getCtrAddMnthIcm());    /** column 중_가산월수 : ctrAddMnthIcm */
						ctrDupMnthIcm.setValue(result.getCtrDupMnthIcm());    /** column 중_중복월수 : ctrDupMnthIcm */
						ctrLogSvc.setValue(result.getCtrLogSvc());    /** column 중_근속연수 : ctrLogSvc */
						endIcncDt.setValue(result.getEndIcncDt());    /** column 종_입사일자 : endIcncDt */
						endRkfcdDt.setValue(result.getEndRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
						endRsgtnDt.setValue(result.getEndRsgtnDt());    /** column 종_퇴사일자 : endRsgtnDt */
						endPymtDt.setValue(result.getEndPymtDt());    /** column 종_지급일자 : endPymtDt */
						
						endViewIcncDt.setValue(result.getEndIcncDt());    /** column 종_입사일자 : endIcncDt */
						endViewRkfcdDt.setValue(result.getEndRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
						endViewRsgtnDt.setValue(result.getEndRsgtnDt());    /** column 종_퇴사일자 : endRsgtnDt */
						endViewPymtDt.setValue(result.getEndPymtDt());    /** column 종_지급일자 : endPymtDt */
						
						endLogSvcMnthIcm.setValue(result.getEndLogSvcMnthIcm());    /** column 종_근속월수 : endLogSvcMnthIcm */
						endViewLogSvcMnthIcm.setValue(result.getEndLogSvcMnthIcm());    /** column 종_근속월수 : endLogSvcMnthIcm */
						
						endEepnMnth12Bfr.setValue(result.getEndEepnMnth12Bfr());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
						endEepnMnth13Aft.setValue(result.getEndEepnMnth13Aft());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
						endAddMnth12Bfr.setValue(result.getEndAddMnth12Bfr());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
						endAddMnth13Aft.setValue(result.getEndAddMnth13Aft());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
						endEepnMnthIcm.setValue(result.getEndEepnMnthIcm());    /** column 종_제외월수 : endEepnMnthIcm */
						endAddMnthIcm.setValue(result.getEndAddMnthIcm());    /** column 종_가산월수 : endAddMnthIcm */
						endDupMnthIcm.setValue(result.getEndDupMnthIcm());    /** column 종_중복월수 : endDupMnthIcm */
						endLogSvcYrNum.setValue(result.getEndLogSvcYrNum());    /** column 종_근속연수 : endLogSvcYrNum */
						clutIcncDt.setValue(result.getClutIcncDt());    /** column 정산_입사일자 : clutIcncDt */
						clutRkfcdDt.setValue(result.getClutRkfcdDt());    /** column 정산-기산일자 : clutRkfcdDt */
						clutRsgtnDt.setValue(result.getClutRsgtnDt());    /** column 정산_퇴사일자 : clutRsgtnDt */
						clutPymtDt.setValue(result.getClutPymtDt());    /** column 정산_지급일자 : clutPymtDt */
						clutLogSvcMnthIcm.setValue(result.getClutLogSvcMnthIcm());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
						clutEepnMnthIcm.setValue(result.getClutEepnMnthIcm());    /** column 정산_제외월수 : clutEepnMnthIcm */
						clutAddMnthIcm.setValue(result.getClutAddMnthIcm());    /** column 정산_가산월수 : clutAddMnthIcm */
						clutDupMnthIcm.setValue(result.getClutDupMnthIcm());    /** column 정산_중복월수 : clutDupMnthIcm */
						clutLogSvcYrNum.setValue(result.getClutLogSvcYrNum());    /** column 정산_근속연수 : clutLogSvcYrNum */
						logPpnl12befIcncDt.setValue(result.getLogPpnl12befIcncDt());    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
						logPpnl12befRkfcdDt.setValue(result.getLogPpnl12befRkfcdDt());    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
						logPpnl12befRsgtnDt.setValue(result.getLogPpnl12befRsgtnDt());    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
						logPpnl12befPymtDt.setValue(result.getLogPpnl12befPymtDt());    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
						logPpnl12befLogMnthIcm.setValue(result.getLogPpnl12befLogMnthIcm());    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
						logPpnl12befEepnMnthIcm.setValue(result.getLogPpnl12befEepnMnthIcm());    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
						logPpnl12befAddMnthIcm.setValue(result.getLogPpnl12befAddMnthIcm());    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
						logPpnl12befDupMnthIcm.setValue(result.getLogPpnl12befDupMnthIcm());    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
						logPpnl12befLogYrNum.setValue(result.getLogPpnl12befLogYrNum());    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
						logPpnl13afrIcncDt.setValue(result.getLogPpnl13afrIcncDt());    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
						logPpnl13afrRkfcdDt.setValue(result.getLogPpnl13afrRkfcdDt());    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
						logPpnl13afrRsgtnDt.setValue(result.getLogPpnl13afrRsgtnDt());    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
						logPpnl13afrPymtDt.setValue(result.getLogPpnl13afrPymtDt());    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
						logPpnl13afrLogMnthIcm.setValue(result.getLogPpnl13afrLogMnthIcm());    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
						logPpnl13afrEepnMnthIcm.setValue(result.getLogPpnl13afrEepnMnthIcm());    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
						logPpnl13afrAddMnthIcm.setValue(result.getLogPpnl13afrAddMnthIcm());    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
						logPpnl13afrDupMnthIcm.setValue(result.getLogPpnl13afrDupMnthIcm());    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
						logPpnl13afrLogSvc.setValue(result.getLogPpnl13afrLogSvc());    /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
						retryIncmCtrPymtSum.setValue(result.getRetryIncmCtrPymtSum());    /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
						retryIncmEndPymtSum.setValue(result.getRetryIncmEndPymtSum());    /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
						retryIncmClutSum.setValue(result.getRetryIncmClutSum());    /** column 퇴직소득_정산금액 : retryIncmClutSum */
						retryFxrtDducClutSum.setValue(result.getRetryFxrtDducClutSum());    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
						logYrDducSum.setValue(result.getLogYrDducSum());    /** column 근속년수공제_정산금액 : logYrDducSum */
						retryTxtnStdClutSum.setValue(result.getRetryTxtnStdClutSum());    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
						tat12befTxtnStdPpnlSum.setValue(result.getTat12befTxtnStdPpnlSum());    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
						tat12befYravgTxstdSum.setValue(result.getTat12befYravgTxstdSum());    /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
						tat12befCvsnTxtnStdSum.setValue(result.getTat12befCvsnTxtnStdSum());    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
						tat12befCvsnCalcAmnt.setValue(result.getTat12befCvsnCalcAmnt());    /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
						tat12befYrAvgCalcAmnt.setValue(result.getTat12befYrAvgCalcAmnt());    /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
						tat12befCalcTxAmnt.setValue(result.getTat12befCalcTxAmnt());    /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
						tat12befAlpayTxAmnt.setValue(result.getTat12befAlpayTxAmnt());    /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
						tat12befRegTgtTxAmnt.setValue(result.getTat12befRegTgtTxAmnt());    /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
						tat13afrTxstdPpnlSum.setValue(result.getTat13afrTxstdPpnlSum());    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
						tat13afrYrAvgStdSum.setValue(result.getTat13afrYrAvgStdSum());    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
						tat13afrCvsnTxtnStdSum.setValue(result.getTat13afrCvsnTxtnStdSum());    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
						tat13afrCvsnCalcTxAmnt.setValue(result.getTat13afrCvsnCalcTxAmnt());    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
						tat13afrYrAvgCalcAmnt.setValue(result.getTat13afrYrAvgCalcAmnt());    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
						tat13afrCalcTxAmnt.setValue(result.getTat13afrCalcTxAmnt());    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
						tat13afrAlpayTxAmnt.setValue(result.getTat13afrAlpayTxAmnt());    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
						tat13afrRegrstTgtSum.setValue(result.getTat13afrRegrstTgtSum());    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
						tatAggrTxtnStdPpnlSum.setValue(result.getTatAggrTxtnStdPpnlSum());    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
						tatAggrYrAvgTxtnStdSum.setValue(result.getTatAggrYrAvgTxtnStdSum());    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
						tatAggrCvsnTxtnStdSum.setValue(result.getTatAggrCvsnTxtnStdSum());    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
						tatAggrCvsnCalcTxAmnt.setValue(result.getTatAggrCvsnCalcTxAmnt());    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
						tatAggrYrAvgCalcTxAmnt.setValue(result.getTatAggrYrAvgCalcTxAmnt());    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
						tatAggrCalcTxAmnt.setValue(result.getTatAggrCalcTxAmnt());    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
						tatAggrAlpayTxAmnt.setValue(result.getTatAggrAlpayTxAmnt());    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
						tatAggrRegrstTgtTxAmnt.setValue(result.getTatAggrRegrstTgtTxAmnt());    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
						talRegrstTgtTxAmnt.setValue(result.getTalRegrstTgtTxAmnt());    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//						talAccuDepitAggrSum.setValue(result.getTalAccuDepitAggrSum());    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
						talRetryPayQnty.setValue(result.getTalRetryPayQnty());    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
						talRetryIncmTxAmnt.setValue(result.getTalRetryIncmTxAmnt());    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
//						pymtRegTgtIncmTxQnty.setValue(result.getPymtRegTgtIncmTxQnty());    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//						pymtRegTgtRgonIncmQnty.setValue(result.getPymtRegTgtRgonIncmQnty());    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//						pymtRegTgtFarvilSpclQnty.setValue(result.getPymtRegTgtFarvilSpclQnty());    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//						pymtRegrstTgtAggrSum.setValue(result.getPymtRegrstTgtAggrSum());    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//						pymtTalcIncmTxQnty.setValue(result.getPymtTalcIncmTxQnty());    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//						pymtTalcRgonIncmTxQnty.setValue(result.getPymtTalcRgonIncmTxQnty());    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//						pymtTalcFarvilSpclQnty.setValue(result.getPymtTalcFarvilSpclQnty());    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//						pymtTxAllcAggrSum.setValue(result.getPymtTxAllcAggrSum());    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//						pymtSubtnIncmTxQnty.setValue(result.getPymtSubtnIncmTxQnty());    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//						pymtSubtnRgonIncmTxQnty.setValue(result.getPymtSubtnRgonIncmTxQnty());    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//						pymtSubtnFarvilSpclQnty.setValue(result.getPymtSubtnFarvilSpclQnty());    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//						pymtSubtnAggrSum.setValue(result.getPymtSubtnAggrSum());    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
						
					  
	                }	
	            });	       
	   
	   
	   }
	  
	  /**
	      * 급여산정 로직 멀티건에 대해 가능하도록 처리 
	      */
	      private void fnPayrRemtCalc()  {
	              
	    	  
	    	  MessageBox.confirm("퇴직정산-세액계산", "퇴직정산 세액계산을 다시 하시겠습니까?",new Listener<MessageBoxEvent>(){
	    	      @Override
	    	       public void handleEvent(MessageBoxEvent be) {
	    	          // if("Yes".equals(be.getButtonClicked().getText())){
	    	    	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	    	       
	    	        	 	  Iterator<BaseModel> itBm  = remt3000DefGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
					          
					          List<Record>  lsRec  = new ArrayList<Record>();
					          
					          while(itBm.hasNext()) {
					
					              Record rec  = new Record(itBm.next()); 
					              lsRec.add(rec);
					              
					          } 
					           setListRecord(lsRec.iterator()); 
							// setListRecord(remt3000DefGridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
		 
               	        	
               	        	String pymtYrMnth =  MSFSharedUtils.getSelectedComboValue(calcSevePsnBlggYr,"year") + MSFSharedUtils.getSelectedComboValue(calcSevePsnBlggMnth,"month");
               	        	if (MSFSharedUtils.paramNull(pymtYrMnth)) {
               	        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
               		                        "대상자를 선택하시려면 정산년월을 선택하셔야 합니다.", null);
               	        		return;
               	        	}
	               	     	if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"))) {
	               	     	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	         	                            "대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
	           	        		return;
	           	        	}
	               	     	
	               	     	
	               	      if (MSFSharedUtils.paramNotNull(records)) { 
	   	  	              
	               	    	    List<Remt3000DTO> listRemt3000Dto = new ArrayList<Remt3000DTO>();   
	               	    	
	               	    	 while (records.hasNext()) {
	   	  	  	              
		  	  	                    Record record = (Record) records.next(); 
		  	  	                    BaseModel bmMapModel = (BaseModel)record.getModel();
		  	  	                      
		  	  	                   Remt3000DTO remt3000Dto = new Remt3000DTO();  
		  	  	                    
		  	  	               remt3000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));         /**  column 사업장코드 : dpobCd */
		  	  	               remt3000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
				  	  	  		  
		  	  	               remt3000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  	  	               remt3000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 정산년월 : clutYrMnth */	  
		  	  	             //  remt3000Dto.setCalcSevePsnBlggYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePsnBlggYrMnth")));    /** column 정산년월 : clutYrMnth */	  
	  	  	 	      	     

		  	  	                   listRemt3000Dto.add(remt3000Dto);
		  	  	                  
		  	  	                }  
	               	    	    
		               	      if (listRemt3000Dto.size() <= 0) {
		  	  	                    
		  	  	                    MessageBox.alert("저장", "저장 처리 할 데이타가 존재하지 않습니다.", null);
		  	  	                    return;
		  	  	                }
		               	             
	    	           	 		remt0200Service.activityOnPayrRemtCalc(listRemt3000Dto,  
	    	           	                new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
	    	           	        public void onFailure(Throwable caught) {
	    	           	        	
	    	           	          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	                              ShowMessageBM smBm = new ShowMessageBM();
	                      	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
	                      	      smBm.setMenu("Remt");
	                      	      smBm.setPhase("[퇴직정산]퇴직정산에러");
	                      	      smBm.setMessage(caught.getLocalizedMessage());
	                      	      smBm.setContent(caught.getMessage());
	                      	      bmResult.add(smBm);  
	                      	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
	                      	   
	                              ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
	    		    			    
	  		    		          MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	  		    		          msFwMessage.show();
	  		    		          showMessageForm.setMSFFormWindows(msFwMessage);
	  		    		       
//	    	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	    	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertRemt0100(insert) : " + caught), null);
	   	           	           }
	    	           	        public void onSuccess(PagingLoadResult<ShowMessageBM> result) {  
	    	           	        	
	    	           	        if (MSFSharedUtils.paramNotNull(result)) {
	    	           	           ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	                         	   BaseModel tmRec = new BaseModel();
	     		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	     		    		       msFwMessage.show();
	     		    		       showMessageForm.setMSFFormWindows(msFwMessage);
	    	           	        }
	                               reload(); 
	                                
	    	           	        } 
	    	           	        }); 	  
	               	    	   
	  	  	              
	  	  	          } else {
	  	  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
	  	  	              return;
	  	  	          }
	    	           }  
	    	      }
	    	      
	    	  });
						   
	               	         
	      }
	      
//		   private void reloadRemtTx(){
//		       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//	               return;
//	           }
//			   IColumnFilter filters = null;
//			   remtSubtn3100GridPanel.getTableDef().setTableColumnFilters(filters);
//				
//			   remtSubtn3100GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//			   remtSubtn3100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			   remtSubtn3100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			   remtSubtn3100GridPanel.getTableDef().addColumnFilter("clutYrMnth", clutYrMnth.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			    
//			   remtSubtn3100GridPanel.reload();
//		   } 
		    


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
