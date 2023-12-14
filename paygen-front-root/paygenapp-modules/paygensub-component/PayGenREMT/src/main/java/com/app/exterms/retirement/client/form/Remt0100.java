package com.app.exterms.retirement.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.retirement.client.dto.Remt2000BM;
import com.app.exterms.retirement.client.dto.Remt2000DTO;
import com.app.exterms.retirement.client.dto.Remt2100DTO;
import com.app.exterms.retirement.client.dto.Remt2200DTO;
import com.app.exterms.retirement.client.dto.Remt2300DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.RemtDays0100DTO;
import com.app.exterms.retirement.client.dto.RemtPayr0100BM;
import com.app.exterms.retirement.client.form.def.Remt2000Def;
import com.app.exterms.retirement.client.form.def.Remt2300Def;
import com.app.exterms.retirement.client.form.def.Remt3100Def;
import com.app.exterms.retirement.client.form.def.RemtPayr0100Def;
import com.app.exterms.retirement.client.form.def.RemtWfep0100Def;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.client.service.Remt0100Service;
import com.app.exterms.retirement.client.service.Remt0100ServiceAsync;
import com.app.exterms.retirement.client.utils.RemtUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
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
public class Remt0100  extends MSFPanel { 
 
/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    
	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	  
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
	private RemtConstants lblRemtConst = RemtConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmRemt0100;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	private FieldSet fldstNewFieldset_1;
	private TabPanel tabsRemtSub;
	private TabPanel tabsRemtTop;
		   
	// 퇴직금대상자정보리스트
	private Remt2000Def remt2000Def = new Remt2000Def("REMT0100"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remt2000DefGridPanel;
		 
	// 퇴직금산정 급여내역조회
	private RemtPayr0100Def remtPayr0100Def = new RemtPayr0100Def("REMT0100"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remtPayr0100GridPanel;
	      
	// 퇴직금산정 복리후생비
	private RemtWfep0100Def remtWfep0100Def = new RemtWfep0100Def("REMT0100"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remtWfep0100GridPanel;

	// 퇴직금 지급항목
	private Remt2000Def remtPymt2000Def = new Remt2000Def("REMTPYMT0100"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remtPymt2000GridPanel;

	// 공제금액
	private Remt2300Def remt2300Def = new Remt2300Def("REMT0100"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remt2300GridPanel;

	// 퇴직정산/중도정산처리시
	private Remt3100Def remt3100Def = new Remt3100Def("REMT0100"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel remt3100GridPanel;
       
 
	       
		  //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
		   
//	      //지급년도 
//	      private LookupPayr0300ClutYr lkClutYr = new LookupPayr0300ClutYr();  
//	      private MSFGridPanel yearGridPanel;

		  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;
	private boolean boolPymtDduc = false;
	private boolean statCheck = false;
	
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
	private ButtonBar topRemt0100Bar;
	private Button btnRemt0100Init;
	private Button btnRemt0100TgtSrh; // 대상자선택
	private Button btnRemt0100Recalc; // 재계산
	private Button btnRemt0100Save;
	private Button btnRemt0100Del;
	private Button btnRemt0100Sreach;
	private Button btnRemt0100Print;
	private Button btnRemt0100Excel;
	
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */ 

	/** column 년도 : year */
	private ComboBox<BaseModel> srhClutYr;
	private ComboBox<BaseModel> srhClutMnth;
     
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
//      private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//      private HiddenField<String> srhPyspGrdeCd; //직종 
      
	private ComboBox<BaseModel> srhCalcSevePayPsnDivCd; 	// 정산구분
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드  	
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
      
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
	private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	   
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세

	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private TextField<String> srhHanNm; 					// 성명
	private TextField<String> srhResnRegnNum; 				// 주민번호
	private HiddenField<String> srhSystemkey; 				// 시스템키
      
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
 
	private HiddenField<String> systemkey;		/**  column SYSTEMKEY : systemkey */
	private HiddenField<String>	dpobCd;			/**  column 사업장코드 : dpobCd */
	private HiddenField<String> logSvcYrNumCd;	/** column 근속년수코드 : logSvcYrNumCd */
	private HiddenField<String> logSvcMnthIcmCd;/** column 근속월수코드 : logSvcMnthIcmCd */
	private HiddenField<String> clutYrMnth;   	/** column 정산년월 : clutYrMnth */
	private HiddenField<String> pyspGrdeCd;   	/** column 호봉등급코드 : pyspGrdeCd */
 
	// -- 퇴직금 산정 시작 -- 
    private MSFComboBox<BaseModel> clutYr;   	/** column 정산년 : clutYr */
    private MSFComboBox<BaseModel> clutMnth;	/** column 정산월 : clutMnth */
    private MSFComboBox<BaseModel> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private MSFTextField nm;   			/** column 성명 : nm */
    private MSFTextField resnRegnNum;	//주민번호 

    private MSFTextField emymtDivNm;	/** column 고용구분 : emymtDivNm */
    private MSFTextField deptNm;		/** column 부서 : deptNm    */
    private MSFTextField typOccuNm;		/** column 직종 : typOccuNm */
    
    private MSFDateField icncDt;   				/** column 입사일자 : icncDt */
    private MSFDateField rkfcdDt;   			/** column 기산일자 : rkfcdDt */
    private MSFDateField retryDt;   			/** column 퇴직일자 : retryDt */
    private MSFCheckBox amcrrClutInsnYn;		/** column 군경력정산포함여부 : amcrrClutInsnYn */
    
    private  MSFDateField  sevePayPymtDt;   	/** column 퇴직금지급일자 : sevePayPymtDt */
    
    private MSFNumberField eepnMnthIcm2012Bfr;	/** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    private MSFNumberField eepnMnthIcm2013Aft;	/** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
    private MSFNumberField addMnthIcm2012Bfr;   /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
    private MSFNumberField addMnthIcm2013Aft;   /** column 가산월수_2013이후 : addMnthIcm2013Aft */
    private MSFNumberField eepnDayIcmDys;   	/** column 제외일수 : eepnDayIcmDys */
    private MSFNumberField sevePayAddRate;   	/** column 퇴직금가산율 : sevePayAddRate */
    
    private MSFNumberField logSvcYrNum;			/** column 근속년수 : logSvcYrNum */
    private MSFNumberField logSvcMnthIcm;   	/** column 근속월수 : logSvcMnthIcm */
    private MSFNumberField logSvcNumDys;   		/** column 근속일수 : logSvcNumDys */
    private MSFNumberField turtyDutyYrNum;   	/** column 실근무년수 : turtyDutyYrNum */
    private MSFNumberField turtyDutyMnthNum;   	/** column 실근무개월수 : turtyDutyMnthNum */
    private MSFNumberField turtyDutyNumDys;   	/** column 실근무일수 : turtyDutyNumDys */
    // -- 퇴직금 산정 종료 -- 
    
    
    // -- 퇴직금계산 > 산정결과 시작 -- 
    private MSFDateField payCmpttnBgnnDt;		/** column 급여산정시작일자 : payCmpttnBgnnDt */
    private MSFDateField payCmpttnEndDt;   		/** column 급여산정종료일자 : payCmpttnEndDt */
    private MSFNumberField marPubcWelfAmnt;		/** column 3월간후생복지비 : marPubcWelfAmnt */
    private MSFNumberField marTotAmntWag;   	/** column 3월간총임금액 : marTotAmntWag */
    private MSFNumberField dayAvgAmntWag;   	/** column 1일평균임금액 : dayAvgAmntWag */
    private MSFNumberField totLogSvcNumDys;   	/** column 총근무일수 : totLogSvcNumDys */
    private MSFNumberField sevePayCmpttnSum;   	/** column 퇴직금산정금액 : sevePayCmpttnSum */
    private MSFNumberField seveViewPayAddRate;	/** column 퇴직금가산율 : sevePayAddRate */
    private MSFNumberField sevePayAddApptnSum;	/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
    private MSFNumberField amcrrLogSvcNumDys;   /** column 군경력근무일수 : amcrrLogSvcNumDys */
    private MSFNumberField amcrrAddApptnSum;   	/** column 군경력가산적용금액 : amcrrAddApptnSum */
    private MSFNumberField sevePayPymtSum;   	/** column 퇴직금지급액 : sevePayPymtSum */
    // -- 퇴직금계산 > 산정결과 종료 -- 
    
    // -- 소득세계산 >  시작 -- 
    private MSFNumberField sevePayTurtyPymtSum;   /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
    
    private MSFNumberField clutLogSvcMnthIcm;		/** column 정산_근속월수 : clutLogSvcMnthIcm */
    private MSFNumberField clutLogSvcYrNum;   		/** column 정산_근속연수 : clutLogSvcYrNum */
    
    private MSFNumberField logPpnl12befLogMnthIcm;	/** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
    private MSFNumberField logPpnl12befLogYrNum;   	/** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
    
    private MSFNumberField logPpnl13afrLogMnthIcm;   /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
    private MSFNumberField logPpnl13afrLogSvc;   	/** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
    // -- 소득세계산 >  종료 -- 
    
    // -- 세액계산 >  시작 -- 
    //--퇴직소득과세표준계산
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
    private MSFNumberField retryTxtnStdClutSum;		/** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
    
    //--퇴직소득세액계산
    private MSFNumberField tat12befTxtnStdPpnlSum;	/** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
    private MSFNumberField tat13afrTxstdPpnlSum;	/** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
    private MSFNumberField tatAggrTxtnStdPpnlSum;   /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
    
    private MSFNumberField tat12befYravgTxstdSum;   /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
    private MSFNumberField tat13afrYrAvgStdSum;   	/** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
    private MSFNumberField tatAggrYrAvgTxtnStdSum;	/** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
    
    private MSFNumberField tat12befCvsnTxtnStdSum;	/** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
    private MSFNumberField tat13afrCvsnTxtnStdSum;	/** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
    private MSFNumberField tatAggrCvsnTxtnStdSum;	/** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
    
    private MSFNumberField tat12befCvsnCalcAmnt;	/** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
    private MSFNumberField tat13afrCvsnCalcTxAmnt;	/** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
    private MSFNumberField tatAggrCvsnCalcTxAmnt;   /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
    
    private MSFNumberField tat12befYrAvgCalcAmnt;   /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
    private MSFNumberField tat13afrYrAvgCalcAmnt;   /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
    private MSFNumberField tatAggrYrAvgCalcTxAmnt;	/** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
    
    private MSFNumberField tat12befCalcTxAmnt;   	/** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
    private MSFNumberField tat13afrCalcTxAmnt;   	/** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
    private MSFNumberField tatAggrCalcTxAmnt;   	/** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
    
    private MSFNumberField tat12befAlpayTxAmnt;   	/** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
    private MSFNumberField tat13afrAlpayTxAmnt;   	/** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
    private MSFNumberField tatAggrAlpayTxAmnt;   	/** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
    
    private MSFNumberField tat12befRegTgtTxAmnt;   	/** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
    private MSFNumberField tat13afrRegrstTgtSum;   	/** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
    private MSFNumberField tatAggrRegrstTgtTxAmnt;	/** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
    // -- 세액계산 >  종료 -- 
    
    
//    private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//    private TextField deptCd;   /** column 부서코드 : deptCd */
//    private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//    private TextField<String> dtilOccuInttnCd;   /** column 직종세구분코드 : dtilOccuInttnCd */
//    private TextField<String> businCd;   /** column 사업코드 : businCd */
//    private TextField<String> inbyCd;   /** column 직위코드 : inbyCd */
//    private TextField<String> pyspCd;   /** column 호봉코드 : pyspCd */
//    private MSFNumberField amcrrLogSvcYrNum;   /** column 군경력근속년수 : amcrrLogSvcYrNum */
//    private MSFNumberField amcrrLogSvcMnthIcm;   /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
//    private MSFNumberField fndtnPayAggrSumSum;   /** column 기본급여합계금액 : fndtnPayAggrSumSum */
//    private MSFNumberField snryAllwAggrSum;   /** column 제수당합계금액 : snryAllwAggrSum */
//    private MSFNumberField welfWelfSpdgAggrSum;   /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
//    private MSFCheckBox sevePayAddYn;   /** column 퇴직금가산포함여부 : sevePayAddYn */
//    private MSFNumberField sevePayAddSum;   /** column 퇴직금가산금액 : sevePayAddSum */
// 	private MSFNumberField sevePayCmpttnFreeDtySum;   /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
// 	private MSFNumberField sevePayCmpttnTxtnSum;   /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
// 	private MSFNumberField sevePayPymtDducSum;   /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
// 	private MSFTextField sevePayNoteCtnt;   /** column 퇴직금비고내용 : sevePayNoteCtnt */
// 	private MSFCheckBox sevePayPymtYn;   /** column 퇴직금지급여부 : sevePayPymtYn */
//  	private MSFCheckBox ddlneYn;   /** column 마감여부 : ddlneYn */
//  	private  MSFDateField  ddlneDt;   /** column 마감일 : ddlneDt */
//  	private TextField<String> kybdr;   /** column 입력자 : kybdr */
//  	private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//  	private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//  	private TextField<String> ismt;   /** column 수정자 : ismt */
//  	private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//  	private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */ 
//	private TextField<String>	hanNm  ;                      /**  column 한글성명 : hanNm */
//	private TextField<String> resnRegnNum  ;                /**  column 주민등록번호 : resnRegnNum */
//	private TextField<String> typOccuNm  ;                  /**  column 직종코드 : typOccuNm */
//	private TextField<String> dtilOccuClsDivNm  ;           /**  column 직종세구분코드 : dtilOccuClsDivNm */
//	private TextField<String> emymtDivNm ;                  /**  column 고용구분 : emymtDivNm */
//	private HiddenField<String> emymtDivCd ;                  /**  column 고용구분코드 : emymtDivCd */
//	private HiddenField<String>      payrMangDeptCd  ;                /**  column 관리부서코드 : payrMangDeptCd */ 
//	private HiddenField<String>      payrMangDeptNm  ;                /**  column 관리부서코드 : payrMangDeptNm */ 
//	private TextField<String>      currAffnDeptNm  ;       /**  column 현소속부서코드 : currAffnDeptNm */
//	private TextField<String> businNm  ;                     /**  column 사업코드 : businNm */
//	private TextField<String> 	frstEmymtDt  ;                         /**  column 최초고용일자 : frstEmymtDt */
//    //  private TextField<String>  logSvcYrNumNm  ;                           /**  column 근속년수 : logSvcYrNumNm */
//	private ComboBox<BaseModel>  logSvcYrNumCd  ;                           /**  column 근속년수코드 : logSvcYrNumCd */
//	private ComboBox<BaseModel>  logSvcMnthIcmCd  ;                           /**  column 근속월수코드 : logSvcYrNumNm */
//	private HiddenField<String> typOccuCd  ;                  /**  column 직종코드 : typOccuCd */
//	private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
//	private HiddenField<String>      currAffnDeptCd  ;       /**  column 현소속부서코드 : currAffnDeptCd */
//	private HiddenField<String> businCd  ;                     /**  column 사업코드 : businCd */
//	private HiddenField<String>  pyspGrdeCd;  /** column 호봉등급코 : pyspGrdeCd */
//	private TextField<String> logSvcMnthIcmNm;                             /**  column 근속월수 : logSvcMnthIcmNm */
//	private TextField<String> 	hdofcCodtnNm;                          /**  column 재직상태코드 : hdofcCodtnNm */
//	private TextField<String> retryDt;                     /**  column 퇴직일자 : retryDt */
     
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
	/**
	 * 권한설정 처리 체크 
	 * AuthAction 
	 */
	private void checkRemt0100Auth( String authAction, ListStore<BaseModel> bm) {   
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			if (!maskTracker) { unmask(); }  
			authExecEnabled() ;
			//MSFMainApp.unmaskMainPage();
		}
	}
	
	private void authExecEnabled() { 
		//----------------------------------------------------------------------
		Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
            
		gwtAuthorization.formAuthFieldConfig(fldArrField);
		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
               
		srhClutYr.setValue(lsClutYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		srhClutMnth.setValue(lsClutMnth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
             
		srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(2));
               
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			// String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
			// GWTAuthorization.formAuthPopConfig(plFrmPayr4220, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
    		// GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			// gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
 		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  srhDeptCd.fireEvent(Events.Add); 
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);   
	}

	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			if (lsEmymtDivCd.getCount() > 0) {
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
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	// 검색 폼 바인딩 처리 함수 
      
	//화면 폼 바인딩 처리 
	private void setRemt0100FormBinding() {
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
	private Remt0100ServiceAsync remt0100Service = Remt0100Service.Util.getInstance();

	private ListStore<BaseModel> lsClutYrStore 				= new ListStore<BaseModel>();	// 년도
	private ListStore<BaseModel> lsClutMnth 				= new ListStore<BaseModel>(); 	// 급여월
	private ListStore<BaseModel> lsEmymtDivCd 				= new ListStore<BaseModel>();	// 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd 		= new ListStore<BaseModel>();	// 호봉제구분코드

	// -------------------- 부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd 					= new ListStore<BaseModel>();	// 부서콤보
	// -------------------- 부서 불러 오는 함수 ------------------------------------------------

	// -------------------- 사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd 					= new ListStore<BaseModel>();	// 사업콤보
	// --------------------사업 불러 오는 함수 -------------------------------------------------
	
	private ListStore<BaseModel> lsPayrMangDeptCd 			= new ListStore<BaseModel>();	// 단위기관
	private ListStore<BaseModel> lsDeptGpCd 				= new ListStore<BaseModel>();	//부서직종그룹코드  
	private ListStore<BaseModel> lsTypOccuCd 				= new ListStore<BaseModel>();	// 직종
	private ListStore<BaseModel> lsCalcSevePayPsnDivCd 		= new ListStore<BaseModel>();	// 정산구분

	private ListStore<BaseModel> lsPymtDducDivCd 			= new ListStore<BaseModel>(); 	// 지급공제구분코드
	private ListStore<BaseModel> lsDtilOccuInttnCd 			= new ListStore<BaseModel>();	// 직종세

	private ListStore<BaseModel> lsCrClutYrStore 			= new ListStore<BaseModel>(); 	// 년도
	private ListStore<BaseModel> lsCrClutMnth 				= new ListStore<BaseModel>(); 	// 급여월
	private ListStore<BaseModel> lsCrCalcSevePayPsnDivCd 	= new ListStore<BaseModel>(); 	// 정산구분
	    
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종

	private BaseModel record;
	private Iterator<Record> records;
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
  	  
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
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnRemt0100Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnRemt0100Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnRemt0100Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
//	  
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			saveStandData();
			break;
		case UPDATE:
			saveStandData();
			break;
		case DELETE:
			deleteStandData();
			break;
		}
	}
	
	/**
     * 기본정보저장처리
     */
	private void saveStandData() {
        
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
         
        MessageBox.confirm("기본정보저장", "기본정보를 하시겠습니까?<br>(퇴직금산정 기본정보를 수정합니다.[지급일자,제외월수등])",new Listener<MessageBoxEvent>(){
        	@Override
        	public void handleEvent(MessageBoxEvent be) {
        		//if("Yes".equals(be.getButtonClicked().getText())){
        		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

        			Remt2000DTO remt2000Dto = new Remt2000DTO(); 
		
        			remt2000Dto.setDpobCd(dpobCd.getValue());			/** column 사업장코드 : dpobCd */
        			remt2000Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
        			remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        			remt2000Dto.setClutYrMnth(clutYrMnth.getValue());    /** column 정산년월 : clutYrMnth */
		             	 
        			remt2000Dto.setRkfcdDt(RemtUtils.getConvertDateToString(rkfcdDt, "yyyyMMdd") );    /** column 기산일자 : rkfcdDt */
        			remt2000Dto.setRetryDt(RemtUtils.getConvertDateToString(retryDt, "yyyyMMdd") );    /** column 퇴직일자 : retryDt */
			             	 
        			remt2000Dto.setEepnMnthIcm2012Bfr((Long)eepnMnthIcm2012Bfr.getValue());		/** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
        			remt2000Dto.setEepnMnthIcm2013Aft((Long)eepnMnthIcm2013Aft.getValue());    	/** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
        			remt2000Dto.setAddMnthIcm2012Bfr((Long)addMnthIcm2012Bfr.getValue());    	/** column 가산월수_2012이전 : addMnthIcm2012Bfr */
        			remt2000Dto.setAddMnthIcm2013Aft((Long)addMnthIcm2013Aft.getValue());    	/** column 가산월수_2013이후 : addMnthIcm2013Aft */
        			remt2000Dto.setEepnDayIcmDys((Long)eepnDayIcmDys.getValue());   			/** column 제외일수 : eepnDayIcmDys */
		             		 
		             		//remt2000Dto.setPayCmpttnBgnnDt(payCmpttnBgnnDt.getValue());    /** column 급여산정시작일자 : payCmpttnBgnnDt */
		             		//remt2000Dto.setPayCmpttnEndDt(payCmpttnEndDt.getValue());    /** column 급여산정종료일자 : payCmpttnEndDt */
		             		 
        			remt2000Dto.setSevePayAddRate((Double)sevePayAddRate.getValue()); 	/** column 퇴직금가산율 : sevePayAddRate */ 
        			remt2000Dto.setAmcrrClutInsnYn(amcrrClutInsnYn.getValue());    		/** column 군경력정산포함여부 : amcrrClutInsnYn */
		             		  
        			remt2000Dto.setSevePayNoteCtnt("");	/** column 퇴직금비고내용 : sevePayNoteCtnt */
        			remt2000Dto.setSevePayPymtDt(RemtUtils.getConvertDateToString(sevePayPymtDt, "yyyyMMdd"));	/** column 퇴직금지급일자 : sevePayPymtDt */
		             		 
        			remt0100Service.activityOnUpdateRemt0100Save(remt2000Dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
        				public void onFailure(Throwable caught) {
        					List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        					ShowMessageBM smBm = new ShowMessageBM();
        					
        					smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
		                  	smBm.setMenu("Remt");
		                  	smBm.setPhase("[퇴직정산수정]퇴직대상자수정에러");
		                  	smBm.setMessage(caught.getLocalizedMessage());
		                  	smBm.setContent(caught.getMessage());
		                  	bmResult.add(smBm);  
		                  	
		                  	PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
		                  	ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
		             			    
		                  	MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
		                  	msFwMessage.show();
		                  	showMessageForm.setMSFFormWindows(msFwMessage);
		             		          
		//                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		//                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100Save(저장(수정)) : " + caught), null);
        				}
        				
        				public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
        					if (MSFSharedUtils.paramNotNull(result)) {
        						
        						ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
        						BaseModel tmRec = new BaseModel();
        						MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
        						msFwMessage.show();
        						showMessageForm.setMSFFormWindows(msFwMessage);
        						
		                	}
		                     	 
        					tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
        					tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
		                     	  
        					reloadRemt2000();
        				} 
        			});        		}  
        	}
        });
	}
    
	/**
	 * 데이타를 삭제한다.
	 */
    private void deleteStandData() {
        
    	if (MSFSharedUtils.paramNull(systemkey.getValue())) {
    		return;
    	}
    	
        MessageBox.confirm("퇴직금계산 대상자 삭제", "선택된 데이타를 삭제 하시겠습니까?<br>(퇴직금산정 대상자를 삭제합니다.)",new Listener<MessageBoxEvent>(){
        	@Override
        	public void handleEvent(MessageBoxEvent be) {
        		
        		//if("Yes".equals(be.getButtonClicked().getText())){
        		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
             
        			Remt2000DTO remt2000Dto = new Remt2000DTO(); 
        			
               		remt2000Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
               		remt2000Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
               		remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
               		remt2000Dto.setClutYrMnth(clutYrMnth.getValue());	/** column 정산년월 : clutYrMnth */
               	  
                       
               		remt0100Service.activityOnDeleteRemt0100Save(remt2000Dto, new AsyncCallback<Long>() {
               			
               			public void onFailure(Throwable caught) {
               				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
               						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDeleteRemt0100Save(삭제) : " + caught), null);
               			}
               			
               			public void onSuccess(Long result) { 
               				if (result == 0) {
               					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                  "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
               				} else {
               					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "삭제처리가 완료되었습니다.", null);
               					formInit();
               					reload(); 
               				} 
               			} 
               		});
        		}  
        	}
        });
	}    
    
    private void saveRemt2300DDucData( final ActionDatabase actionDatabase) { 
        
    	if (MSFSharedUtils.paramNotNull(records)) {
             
    		statCheck = false;
        	
//        	 MessageBox.confirm("퇴직금공제내역", "퇴직금공제내역을 저장 하시겠습니까?<br>(퇴직금공제)",new Listener<MessageBoxEvent>(){
//        	      @Override
//        	       public void handleEvent(MessageBoxEvent be) {
//        	           if("Yes".equals(be.getButtonClicked().getText())){
        	       
    		List<Remt2300DTO> listRemt2300Dto = new ArrayList<Remt2300DTO>();  

    		while (records.hasNext()) {
        	             
				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				Remt2300DTO remt2300Dto = new Remt2300DTO();
        	                
				remt2300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
        	  	remt2300Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        	  	remt2300Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));	/** column 정산년월 : clutYrMnth */
        	  	remt2300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
        	  	remt2300Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));	/** column 급여항목코드 : payItemCd */
        	  	remt2300Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));	/** column 지급공제구분코드 : pymtDducDivCd */
        	  	remt2300Dto.setPymtSum((Long)bmMapModel.get("pymtSum"));	/** column 지급금액 : pymtSum */
        	  			  
        	                  
//        	                  if (actionDatabase.equals(ActionDatabase.INSERT)) {
//        	                  	
//        	                  	 
//        	                  		if (MSFSharedUtils.isNullAsString(remt2300Dto.getSystemkey())) {
//        	                  			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//        	         	                             "[급여] 조정할 대상자를 선택하십시요.", null);
//        	                  			statCheck = true;
//        	                  			break;
//        	                  		} else if (MSFSharedUtils.isNullAsString(remt2300Dto.getPymtDducDivCd())) {
//        	                  			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//        	            	                         "[급여] 지급공제구분을 입력하십시요.", null);
//        	                     			statCheck = true;
//        	                     			break;
//        	                     		} else if (MSFSharedUtils.paramNotNull(remt2300Dto.getPymtDducSum())) {
//        	                     			if (remt2300Dto.getPymtDducSum().compareTo(0L) <= 0) {
//        	  	                			//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//        	  	         	               //          "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
//        	  	                  			//statCheck = true;
//        	  	                  			//break;
//        	                     			}
//        	                    		}  else if (MSFSharedUtils.paramNull(remt2300Dto.getPymtDducSum())) {
//        	                     			 
//        	  	                			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//        	  	         	                         "[급여] 조정할 지급공제금액은 0 이상이어야합니다. 입력하십시요.", null);
//        	  	                  			statCheck = true;
//        	  	                  			break;
//        	                     			 
//        	                    		}  
//        	                  	
//        	                  }   
        	                  
        	  	listRemt2300Dto.add(remt2300Dto);
    		}   
    		
    		
        	              // if (!statCheck) {    
    		remt0100Service.activityOnSaveRemt2300DDucData(listRemt2300Dto, actionDatabase, new AsyncCallback<Long>() { 
    			
    			public void onFailure(Throwable caught) {
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
    						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr4200(" + actionDatabase.name() + ") : " + caught), null);
        	  	}
    			
    			@Autowired
    			public void onSuccess(Long result) { 
    				if (result == 0) {
    					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
    							actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
        	  		                      // actionDatabase = ActionDatabase.INSERT;
        	  		} else {
        	  			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
        	  					actionDatabase + "처리가 완료되었습니다.", null);
        	  		                     
        	  			tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
        	  			tabsRemtSub.setSelection(tabsRemtSub.getItem(0));

								// reloadRemt2000();
        	  			reloadDataRemtPymt();
        	  		} 
    			} 
    		}); 
//        	           }  
//        	      }
//        	      
//        	  });
        	
    		this.actionDatabase = ActionDatabase.UPDATE;
            // }
    	} else {
    		MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
            return;
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
	private void Remt0100Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 퇴직 : REMT
		String strDirPath = "REMT";
		
		// mrd 출력물
		String rdaFileName = fileName + ".mrd";
		
		// 보낼 파라미터
		
		//검색조건
		String serarchParam = "";

		String year = RemtUtils.getSelectedComboValue(srhClutYr, "year");
		String month = RemtUtils.getSelectedComboValue(srhClutMnth, "month");

		String strCalcSevePayPsnDivCd = RemtUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd, "commCd");

		String pymtYrMnth = year.concat(month);

		String strDpobCd = dpobCd.getValue();
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = RemtUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt", "deptCd");
		String typOccuCd = RemtUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm", "typOccuCd");
		// String pyspGrdeCd =
		// RemtUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd");
		String dtilOccuInttnCd = RemtUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm", "dtilOccuInttnCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
		// String hdofcCodtnCd = strHdofcCodtnCd;
		String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
		String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue());
	         
				
		serarchParam += "[" + strDpobCd + "]";				// $1
		serarchParam += "[" + pymtYrMnth + "]"; 			// $2
		serarchParam += "[" + strCalcSevePayPsnDivCd + "]"; // $3
		serarchParam += "[" + payrMangDeptCd + "]";			// $4
		serarchParam += "[" + emymtDivCd + "]"; 			// $5
		serarchParam += "[" + deptCd + "]"; 				// $6
		serarchParam += "[" + typOccuCd + "]"; 				// $7
		serarchParam += "[]"; 								// $8
		serarchParam += "[" + dtilOccuInttnCd + "]"; 		// $9
		serarchParam += "[" + businCd + "]"; 				// $10
			 
		
		List<BaseModel> list = remt2000DefGridPanel.getGrid().getSelectionModel().getSelectedItems();
		String checkedSystemKeys = "";
		if (list != null && list.size() > 0) {
			String chkkey = "";
			for (BaseModel bm : list) {
				chkkey += "'" + bm.get("systemkey") + "',";
			}

			checkedSystemKeys = chkkey.substring(0, chkkey.length() - 1);

		} // $11
		
		
		serarchParam += "[" + checkedSystemKeys + "]"; // $11

		// TODO 확인 출력 확인 해야함
		if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {

			serarchParam += "[]"; // $12
			serarchParam += "["+ MSFMainApp.get().getUser().getPayrMangDeptYn() + "]"; // $13

		} else {
	           
	          		  
	          //직종 권한에 대한 처리 추가 기본 처리  $14로해서 처리 할것...$12
//	          if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//	                    && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//	              serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//	          } else {
//	              serarchParam += "[]";
//	          } 
	          
			serarchParam += "[]"; // $13
		}

		String strParam = "/rp " + serarchParam;

		// GWT 타입으로 팝업 호출시 postCall true 설정
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
  
	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());
			    
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createRemt0100Form();	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createStandardForm(); 	// 기본정보필드
			occupationalRTop();
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");
				    
			// /**
			// * Create the relations
			// */
			// final RelationDef relPsnl0100 = new
			// RelationDef(payr0500Def,false);
			// relPsnl0100.addJoinDef("dpobCd", "dpobCd");
			// relPsnl0100.addJoinDef("systemkey", "systemkey");
			// relPsnl0100.setLinkedObject(payr0500GridPanel);
			// remt2000Def.addRelation(relPsnl0100);
			//
			//
			// // DETAILS
			// final Grid remt2000DefGrid =
			// remt2000DefGridPanel.getMsfGrid().getGrid();
			// remt2000DefGrid.addListener(Events.CellDoubleClick, new
			// Listener<BaseEvent>() {
			// public void handleEvent(BaseEvent be) {
			// if (remt2000DefGridPanel.getCurrentlySelectedItem() != null) {
			//
			// payr0500Def.synchronizeGridDetail(
			// remt2000DefGridPanel.getCurrentlySelectedItem(),
			// payr0500GridPanel );
			// }
			// tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
			// payr0500GridPanel.reload();
			//
			// }
			// });

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
	public Remt0100() {

		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Remt0100(String txtForm) {
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
	private void createRemt0100Form() {

		plFrmRemt0100 = new FormPanel();
		plFrmRemt0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ lblRemtConst.title_Remt0100());
		// plFrmRemt0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여대상자관리");
		plFrmRemt0100.setIcon(MSFMainApp.ICONS.text());
		plFrmRemt0100.setBodyStyleName("pad-text");
		plFrmRemt0100.setPadding(2);
		plFrmRemt0100.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblRemtConst.title_Remt0100(),"REMT0100");
				}
			});
		plFrmRemt0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmRemt0100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
	 
		//멀티콤보박스 닫기 
		plFrmRemt0100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						srhDeptCd.showClose(ce);
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
			} 
		});
	        
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FlowLayout());

		ButtonBar buttonBar_1 = new ButtonBar();

		Button btnNewButton_2 = new Button("");
		// btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
		buttonBar_1.add(btnNewButton_2);
			  
			 
		// layoutContainer_1.add(buttonBar_1);
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		topRemt0100Bar = new ButtonBar();
		layoutContainer_2.add(topRemt0100Bar);
		topRemt0100Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnRemt0100Init = new Button("초기화");
		btnRemt0100Init.setIcon(MSFMainApp.ICONS.new16());
		topRemt0100Bar.add(btnRemt0100Init);
		btnRemt0100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 초기화
				formInit();
			}
		});
			  	
			     
		btnRemt0100TgtSrh = new Button("대상자선택");
		btnRemt0100TgtSrh.setIcon(MSFMainApp.ICONS.text());
		topRemt0100Bar.add(btnRemt0100TgtSrh);
		btnRemt0100TgtSrh.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				fnPopupRemt1000();
			}
		});
				  	
		btnRemt0100Save = new Button("저장");
		btnRemt0100Save.setIcon(MSFMainApp.ICONS.save16());
		topRemt0100Bar.add(btnRemt0100Save);
		btnRemt0100Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				doAction(actionDatabase.UPDATE);
			}
		});

		btnRemt0100Del = new Button("삭제");
		btnRemt0100Del.setIcon(MSFMainApp.ICONS.delete16());
		topRemt0100Bar.add(btnRemt0100Del);
		btnRemt0100Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				doAction(actionDatabase.DELETE);
			}
		}); 	
				  	
//			  	btnRemt0100Recalc = new Button("급여산정"); 
//			  	btnRemt0100Recalc.setIcon(MSFMainApp.ICONS.text());
//				  	topRemt0100Bar.add(btnRemt0100Recalc);
//				  	btnRemt0100Recalc.addListener(Events.Select, new Listener<ButtonEvent>() {
//			    		public void handleEvent(ButtonEvent e) {
//			    			
//			    		}
//			    	});
				  	
		btnRemt0100Recalc = new Button("퇴직금산정");
		btnRemt0100Recalc.setIcon(MSFMainApp.ICONS.text());
		topRemt0100Bar.add(btnRemt0100Recalc);
		btnRemt0100Recalc.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				fnPayrCalc();
			}
		});

		btnRemt0100Sreach = new Button("조회");
		btnRemt0100Sreach.setIcon(MSFMainApp.ICONS.search16());
		topRemt0100Bar.add(btnRemt0100Sreach);
		btnRemt0100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});

		btnRemt0100Print = new Button("퇴직금산정내역서");
		btnRemt0100Print.setIcon(MSFMainApp.ICONS.search16());
		topRemt0100Bar.add(btnRemt0100Print);
		btnRemt0100Print.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Remt0100Print("REMTT0100");
			}
		});
			  	
//			  	btnRemt0100Excel = new Button("엑셀"); 
//			  	btnRemt0100Excel.setIcon(MSFMainApp.ICONS.search16());
//			  	topRemt0100Bar.add(btnRemt0100Excel);
//			  	btnRemt0100Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
//		    		public void handleEvent(ButtonEvent e) {
//		    			 
//		    		}
//		    	});
			  	
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		layoutContainer_2.setBorders(false);
		layoutContainer.setBorders(false);

		plFrmRemt0100.add(layoutContainer);   
		  	  
		  	
		// 파일업로드 처리
		plFrmRemt0100.setAction("bizform");
		plFrmRemt0100.setEncoding(Encoding.MULTIPART);
		plFrmRemt0100.setMethod(Method.POST);

		vp.add(plFrmRemt0100);
		//엣지변환
		//plFrmRemt0100.setSize("990px", "690px");
		plFrmRemt0100.setSize("990px", "740px");
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
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
        
        
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월 
		lsClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
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
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});   
  
		plFrmRemt0100.setLayout(new FlowLayout());
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
		srhClutYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				checkRemt0100Auth("srhClutYr", lsClutYrStore);
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
	                  // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
	                  // return;
					} 
				}       
			} 
		});   
		layoutContainer_8.add(srhClutYr, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
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
		srhClutMnth.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				checkRemt0100Auth("srhClutMnth", lsClutMnth);
			}
		});
		layoutContainer_9.add(srhClutMnth, new FormData("100%"));
		lcSchLeft.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
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
					checkRemt0100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
		
		LayoutContainer layoutContainer_15 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_15.setLayout(frmlytSch);
    
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
		lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	     				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						checkRemt0100Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
		layoutContainer.setBorders(false);
		layoutContainer.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setLabelSeparator("");
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
//	    srhRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		

//		LayoutContainer layoutContainer_14 = new LayoutContainer();
//		layoutContainer_14.setBorders(false);
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_14.setLayout(frmlytSch);
//    
//		srhCalcSevePayPsnDivCd = new ComboBox<BaseModel>();
//		srhCalcSevePayPsnDivCd.setName("srhCalcSevePayPsnDivCd");
//		srhCalcSevePayPsnDivCd.setForceSelection(true);
//		srhCalcSevePayPsnDivCd.setMinChars(1);
//		srhCalcSevePayPsnDivCd.setDisplayField("commCdNm");
//		srhCalcSevePayPsnDivCd.setValueField("commCd");
//		srhCalcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
//		srhCalcSevePayPsnDivCd.setEmptyText("--정산구분선택--");
//		srhCalcSevePayPsnDivCd.setSelectOnFocus(true);
//		srhCalcSevePayPsnDivCd.setReadOnly(false);
//		srhCalcSevePayPsnDivCd.setEnabled(true);
//		srhCalcSevePayPsnDivCd.setStore(lsCalcSevePayPsnDivCd);
//		srhCalcSevePayPsnDivCd.setFieldLabel("정산구분");
//		srhCalcSevePayPsnDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				checkRemt0100Auth("srhCalcSevePayPsnDivCd", lsCalcSevePayPsnDivCd);
//			}
//		}); 
//		layoutContainer_14.add(srhCalcSevePayPsnDivCd, new FormData("100%"));

		

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
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});
//		srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) {
//				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//					srhSystemkey.setValue("");
//					srhResnRegnNum.setValue("");
//				}
//			}
//		});
		layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		layoutContainer_6.setBorders(false);
		
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        layoutContainer_btn.setLayout(frmlytSch);

		Button btnHanNm = new Button("검색");
//		layoutContainer_5.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();
			}
		});
		
        layoutContainer_btn.add(btnHanNm);
        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
    
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
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer_7.setBorders(false);
		layoutContainer_5.setBorders(false);
    
//		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));			// 정산년월 
//		lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 단위기관
//		lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 고용구분
//		lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명
		
		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 정산년월 
		lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
		lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
    
    
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());
		
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);
    
		srhCalcSevePayPsnDivCd = new ComboBox<BaseModel>();
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
		srhCalcSevePayPsnDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				checkRemt0100Auth("srhCalcSevePayPsnDivCd", lsCalcSevePayPsnDivCd);
			}
		}); 
		layoutContainer_1.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
    
//		LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
//		
//		LayoutContainer layoutContainer_15 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(60); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		layoutContainer_15.setLayout(frmlytSch);
//    
//		srhEmymtDivCd = new ComboBox<BaseModel>();
//		srhEmymtDivCd.setName("srhEmymtDivCd");
//		srhEmymtDivCd.setForceSelection(true);
//		srhEmymtDivCd.setMinChars(1);
//		srhEmymtDivCd.setDisplayField("commCdNm");
//		srhEmymtDivCd.setValueField("commCd");
//		srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//		srhEmymtDivCd.setEmptyText("--고용구분선택--");
//		srhEmymtDivCd.setSelectOnFocus(true);
//		srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//		srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
//		srhEmymtDivCd.setStore(lsEmymtDivCd);
//		srhEmymtDivCd.setFieldLabel("고용구분");
//		lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//			public void handleEvent(StoreEvent<BaseModel> be) {  
//				
//				EventType type = be.getType();
//				if (type == Store.Add) { 
//					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//	     				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//						checkRemt0100Auth("srhEmymtDivCd", lsEmymtDivCd); 
//				}
//			}
//		});    
//		
//		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				
//				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//				BaseModel bmPayCd =  se.getSelectedItem(); 
//				
//				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//					srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//					srhBusinCd.setEnabled(true);
//					srhTypOccuCd.reset();
//					srhTypOccuCd.setEnabled(false);
//					srhDtilOccuInttnCd.reset();
//					srhDtilOccuInttnCd.setEnabled(false);
//				} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
//					//20151130 추가 수정 
//					srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//					srhBusinCd.reset();
//					srhBusinCd.setEnabled(false);   
//					if (gwtExtAuth.getEnableTypOccuCd()) {
//						srhTypOccuCd.setEnabled(true);
//						srhDtilOccuInttnCd.setEnabled(true); 
//					} else {
//						srhTypOccuCd.setEnabled(false);
//						srhDtilOccuInttnCd.setEnabled(false);
//					}
//    	     
//				}  
//			} 
//		});
//		layoutContainer_15.add(srhEmymtDivCd, new FormData("100%"));
//		layoutContainer_1.setBorders(false);
//		layoutContainer_1.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//		
//	    LayoutContainer layoutContainer_101 = new LayoutContainer();
//		layoutContainer_101.setBorders(false);
//
//	    frmlytSch = new FormLayout();  
//	    frmlytSch.setDefaultWidth(0);
////	    frmlytSch.setLabelWidth(0); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	    layoutContainer_101.setLayout(frmlytSch);
//	    
//	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
//	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
//	    srhRepbtyBusinDivCd.setForceSelection(true);
//	    srhRepbtyBusinDivCd.setAllowBlank(false);
//	    srhRepbtyBusinDivCd.setMinChars(1);
//	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
//	    srhRepbtyBusinDivCd.setValueField("commCd");
//	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
//	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
//	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
//	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
//	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
//	    srhRepbtyBusinDivCd.setHideLabel(true);
////	    srhRepbtyBusinDivCd.setLabelSeparator("");
//       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
//	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//              
//            }
//        });  
//	    
//	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
//	    layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		
    
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
    
		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		// srhDeptCd.setForceSelection(true);
		// srhDeptCd.setMinChars(1);
		// srhDeptCd.setDisplayField("deptNmRtchnt");
		// srhDeptCd.setValueField("deptCd");
		// srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		// srhDeptCd.setSelectOnFocus(true);
		// srhDeptCd.setReadOnly(false);
		// srhDeptCd.setEnabled(true);
		// srhDeptCd.setStore(lsDeptCd );
		// srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
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
						checkRemt0100Auth("srhDeptCd", lsDeptCd); 
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
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			} 
		});
    //검색 소속부서 코드 처리  
 //   LayoutContainer lccmlcDeptNm = new LayoutContainer();
 //   lccmlcDeptNm.setLayout(new ColumnLayout());
//       //부서 
 //   srhDeptCd = new TextField<String>();
 //   srhDeptCd.setName("srhDeptCd");
 //   srhDeptCd.setVisible(false);
 //   srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//        @Override
//        public void handleEvent(BaseEvent be) { 
//          if(srhDeptCd.getValue() != null){ 
//             
//                  PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//                  sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year")); 
//                  sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//              
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                  lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//                  srhBusinCd.setStore(lsBusinCd); 
//                  srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                      public void handleEvent(StoreEvent<BaseModel> be) {  
//                       //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                      }
//                  });    
//             
//          } 
//        }
//     });
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
//     LayoutContainer lcDeptNm = new LayoutContainer(); 
//     frmlytSch = new FormLayout();
//     frmlytSch.setLabelWidth(70);
//     frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//     lcDeptNm.setLayout(frmlytSch);
 // 
//     srhDeptNm = new TextField<String>();
//     srhDeptNm.setName("srhDeptNm");
//     srhDeptNm.setFieldLabel("부서");  
//     srhDeptNm.addKeyListener(new KeyListener() {
//          public void componentKeyUp(ComponentEvent event) {
//              super.componentKeyUp(event); 
//              if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                  if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                      srhDeptCd.setValue("");
//                      srhMangeDeptCd.setValue("");
//                  }
//                  fnPopupCommP140(srhDeptNm.getValue());
//              }
//          }
//      });
 //    
//     srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                @Override
//                public void handleEvent(BaseEvent be) { 
//                     
//                    if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                        srhDeptCd.setValue("");
//                        srhMangeDeptCd.setValue("");
//                    }
//                 
//                } 
//       });        
//      lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//      
//       btnSrhDeptCd = new Button();
//       btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//       btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//           public void handleEvent(ButtonEvent e) { 
//               if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                   srhDeptCd.setValue("");
//                   srhMangeDeptCd.setValue("");
//               }
//               fnPopupCommP140(srhDeptNm.getValue()); 
//           }
//       });
//        
//       lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//       lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
         
		layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);
		
	

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
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
    
		// 직종 직종세처리
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);
    
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
	                	//checkRemt0100Auth("srhTypOccuCd", lsTypOccuCd); 
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
		// lcSchRight.setStyleAttribute("paddingRight", "10px");
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
		
		
//		layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	// 정산구분
//		layoutContainer_13.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 부서
//		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 직종
//		layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 사업
		
		layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 정산구분
		layoutContainer_13.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
		
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
		
    

		plFrmRemt0100.add(fieldSet);
		// vp.add(panel);
	}
 

	private void  displayDtilOccuInttnCd() {
	  
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
         
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
             
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect = srhDeptCd.getListView().getChecked();
			String strDeptCd = RemtUtils.getStrValToMDMultiCombo(mdDeptCdSelect, "deptCd");
			sysComBass0350Dto.setDeptCd(strDeptCd);
			List<ModelData> mdListSelect = srhTypOccuCd.getListView().getChecked();
			String strTypOccuCd = RemtUtils.getStrValToMDMultiCombo(mdListSelect, "typOccuCd");
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
	  
		dpobCd = new HiddenField<String>(); 		// 사업장코드
		systemkey = new HiddenField<String>(); 		// 시스템키
		pyspGrdeCd = new HiddenField<String>();
		logSvcYrNumCd = new HiddenField<String>();	/** column 근속년수코드 : logSvcYrNumCd */
		logSvcMnthIcmCd = new HiddenField<String>();/** column 근속월수코드 : logSvcMnthIcmCd */
		clutYrMnth = new HiddenField<String>();
//      payrMangDeptCd = new  HiddenField<String>(); 
//      payrMangDeptNm = new  HiddenField<String>(); 
//     
//      idtlAccdtInsurApptnYn = new HiddenField<Boolean>() ; 
//      logSvcExtpyApptnYn =  new HiddenField<Boolean>() ;
//      
//      typOccuCd =  new HiddenField<String>() ;
//      dtilOccuInttnCd =  new HiddenField<String>() ;
//      currAffnDeptCd =  new HiddenField<String>() ;
//      businCd =  new HiddenField<String>() ;
     
    	
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//정산구분 
		sysComBass0300Dto.setRpsttvCd("B027");
		lsCrCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    
     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsCrClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월 
		lsCrClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    
        
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		//fldstNewFieldset.setSize("330px", "505px");
		
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("대상자정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.36));
		layoutContainer_1.setBorders(false);
		
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		//frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("퇴직금산정");
		fldstNewFieldset_1.setCollapsible(false);
		//fldstNewFieldset_1.setSize(622, 540);
		 
		layoutContainer_2.add(fldstNewFieldset_1,new FormData("100%"));
		 
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.64));
		layoutContainer_2.setBorders(false);
		  
		plFrmRemt0100.add(layoutContainer);
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
	  
      
		LayoutContainer layoutContainer_37 = new LayoutContainer();
		layoutContainer_37.setLayout(new FlowLayout());

		layoutContainer_37.add(rightForm01());
		layoutContainer_37.setBorders(false);

		fldstNewFieldset_1.add(layoutContainer_37);
      
     
		tabsRemtTop = new TabPanel(); // 퇴직금 정보설정을 위한 tab
		// tabsRemtSub.setMinTabWidth(80);
		tabsRemtTop.setAutoWidth(false);
		// tabsRemtSub.setResizeTabs(true);
		tabsRemtTop.setAnimScroll(true);
		tabsRemtTop.setTabScroll(true);
		tabsRemtTop.setPlain(true);
		tabsRemtTop.setSize(597, 350);    
     
		TabItem itemTop01 = new TabItem();
		itemTop01.setStyleAttribute("padding", "3px");
		itemTop01.setText("퇴직금계산");
		// itemTop01.addStyleName("pad-text");
		itemTop01.setLayout(new FormLayout());
		itemTop01.add(DataTop01(), new FormData("100%"));
		itemTop01.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 퇴직금계산결과
				reloadRemt2000();
			}
		});
		tabsRemtTop.add(itemTop01);

		TabItem itemTop02 = new TabItem();
		itemTop02.setStyleAttribute("padding", "3px");
		itemTop02.setText("소득세계산");
		itemTop02.setLayout(new FormLayout());
		itemTop02.add(DataTop02(), new FormData("100%"));
		itemTop02.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 소득세 계산결과
				reloadDataRemtPymt();
				reloadDataRemtCalcTax();
			}
		});
		tabsRemtTop.add(itemTop02);
     
		TabItem itemTop03 = new TabItem();
		itemTop03.setStyleAttribute("padding", "3px");
		itemTop03.setText("세액계산");
		itemTop03.setLayout(new FormLayout());
		itemTop03.add(DataTop03(), new FormData("100%"));
		itemTop03.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 세액계산
			}
		});
		tabsRemtTop.add(itemTop03);
     
     
		TabItem itemTop04 = new TabItem();
		itemTop04.setStyleAttribute("padding", "3px");
		itemTop04.setText("중간정산내역");
		itemTop04.setLayout(new FormLayout());
		itemTop04.add(DataTop04(), new FormData("100%"));
		itemTop04.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 중간정산내역검색
				reloadRemtDetail();

			}
		});
		tabsRemtTop.add(itemTop04);

		fldstNewFieldset_1.add(tabsRemtTop, new FormData("100%"));
	}
 
 

	private LayoutContainer rightForm01() { 
	
		dpobCd = new HiddenField<String>();    /** column 사업장코드 : dpobCd */
		systemkey = new HiddenField<String>(); /** column SYSTEMKEY : systemkey */
	 
		LayoutContainer layoutContainer = new LayoutContainer();

		ContentPanel cp02 = new ContentPanel();
		cp02.setHeaderVisible(false);
		cp02.setSize(600, 158);
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
     
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytSch);

		clutYr = new MSFComboBox<BaseModel>();
		clutYr.setName("clutYr");
		clutYr.setForceSelection(true);
		clutYr.setMinChars(1);
		clutYr.setDisplayField("yearDisp");
		clutYr.setValueField("year");
		clutYr.setTriggerAction(TriggerAction.ALL);
		clutYr.setEmptyText("----");
		clutYr.setSelectOnFocus(true);
		clutYr.setReadOnly(true);
		clutYr.setStore(lsCrClutYrStore);
		layoutContainer_13.add(clutYr, new FormData("100%"));
		clutYr.setFieldLabel("정산년월");
		layoutContainer_13.setBorders(false);
     
		layoutContainer_1_1.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
     
		LayoutContainer layoutContainer_2_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_3.setLayout(frmlytSch);

		clutMnth = new MSFComboBox<BaseModel>();
		clutMnth.setName("clutMnth");
		clutMnth.setForceSelection(true);
		clutMnth.setMinChars(1);
		clutMnth.setDisplayField("monthDisp");
		clutMnth.setValueField("month");
		clutMnth.setTriggerAction(TriggerAction.ALL);
		clutMnth.setEmptyText("----");
		clutMnth.setSelectOnFocus(true);
		clutMnth.setReadOnly(true);
		clutMnth.setStore(lsCrClutMnth);
		layoutContainer_2_3.add(clutMnth, new FormData("100%"));
		clutMnth.setHideLabel(true);
		clutMnth.setBorders(false);
      
     
		layoutContainer_1_1.add(layoutContainer_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_1_1.setBorders(false);
     
		layoutContainer_5.add(layoutContainer_1_1, new FormData("100%"));
     
		layoutContainer_6.add(layoutContainer_5 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3) );
     
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytSch);

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
		layoutContainer_2_1.add(calcSevePayPsnDivCd, new FormData("100%"));
		calcSevePayPsnDivCd.setFieldLabel("정산구분");
		layoutContainer_6.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_2_1.setBorders(false);
     
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		nm = new MSFTextField();
		nm.setReadOnly(true);
		layoutContainer_3.add(nm, new FormData("100%"));
		nm.setFieldLabel("성명");
		layoutContainer_6.add(layoutContainer_3 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 
     
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		resnRegnNum = new MSFTextField();
		resnRegnNum.setReadOnly(true);
		layoutContainer_4.add(resnRegnNum, new FormData("100%"));
		resnRegnNum.setHideLabel(true);
		layoutContainer_6.add(layoutContainer_4 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16)); 
      
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
		layoutContainer71.add(layoutContainer_62,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
     
		LayoutContainer layoutContainer_69 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_69.setLayout(frmlytStd);

		typOccuNm = new MSFTextField();
		typOccuNm.setReadOnly(true);
		layoutContainer_69.add(typOccuNm, new FormData("100%"));
		typOccuNm.setFieldLabel("직종(사업)");
		layoutContainer71.add(layoutContainer_69,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));
		layoutContainer_69.setBorders(false);
		cp02.add(layoutContainer71);
     
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		icncDt = new MSFDateField();
		icncDt.setReadOnly(true);
		new DateFieldMask(icncDt, "9999.99.99");
		icncDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		icncDt.setName("icncDt");
		icncDt.setAllowBlank(false);
		layoutContainer_1.add(icncDt, new FormData("100%"));
		icncDt.setFieldLabel("입사일자");
    	layoutContainer7.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
     
		rkfcdDt = new MSFDateField();
		new DateFieldMask(rkfcdDt, "9999.99.99"); 
		rkfcdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		rkfcdDt.setName("rkfcdDt");
		rkfcdDt.setAllowBlank(false);
		layoutContainer_2.add(rkfcdDt, new FormData("100%"));
		rkfcdDt.setFieldLabel("기산일자");
		layoutContainer7.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);

		retryDt = new MSFDateField();
		new DateFieldMask(retryDt, "9999.99.99");
		retryDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		retryDt.setName("retryDt");
		retryDt.setAllowBlank(false);
		layoutContainer_9.add(retryDt, new FormData("100%"));
		retryDt.setFieldLabel("퇴사일자");
		layoutContainer7.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainer_9.setBorders(false);
		cp02.add(layoutContainer7);
     
     
		LayoutContainer layoutContainer_51 = new LayoutContainer();
		layoutContainer_51.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_51.setLayout(frmlytStd);
     
		amcrrClutInsnYn = new MSFCheckBox();
		layoutContainer_51.add(amcrrClutInsnYn, new FormData("100%"));
		amcrrClutInsnYn.setFieldLabel("군경력");
		// amcrrClutInsnYn.setBoxLabel("군경력");
		layoutContainer7.add(layoutContainer_51, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
      
		/**-----------------------------------------------
		 * 지급일자 시작 
      	----------------------------------------------*/ 

		LayoutContainer layoutContainerd7 = new LayoutContainer();
		layoutContainerd7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainerd_1 = new LayoutContainer();
		layoutContainerd_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_1.setLayout(frmlytStd);
      
		sevePayPymtDt = new MSFDateField();
		new DateFieldMask(sevePayPymtDt, "9999.99.99");
		sevePayPymtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		sevePayPymtDt.setName("rkfcdDt");
		sevePayPymtDt.setAllowBlank(false);
		layoutContainerd_1.add(sevePayPymtDt, new FormData("100%"));
		sevePayPymtDt.setFieldLabel("지급일자");
		layoutContainerd7.add(layoutContainerd_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));

		LayoutContainer layoutContainerd_2 = new LayoutContainer();
		layoutContainerd_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_2.setLayout(frmlytStd);
    
		layoutContainerd7.add(layoutContainerd_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
     
		LayoutContainer layoutContainerd_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_9.setLayout(frmlytStd);
      
		layoutContainerd7.add(layoutContainerd_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainerd_9.setBorders(false);
		cp02.add(layoutContainerd7);
     
		LayoutContainer layoutContainerd_51 = new LayoutContainer();
		layoutContainer_51.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerd_51.setLayout(frmlytStd);
      
		layoutContainerd7.add(layoutContainerd_51,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
      
		/**-----------------------------------------------
		 * 지급일자 종료
      	----------------------------------------------*/ 
     
		LayoutContainer layoutContainer_16 = new LayoutContainer();
		layoutContainer_16.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		layoutContainer_17.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_30 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_30.setLayout(frmlytStd);
     
		eepnMnthIcm2012Bfr = new MSFNumberField();
		eepnMnthIcm2012Bfr.setAllowDecimals(true);
		eepnMnthIcm2012Bfr.setPropertyEditorType(Long.class);
		eepnMnthIcm2012Bfr.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_30.add(eepnMnthIcm2012Bfr, new FormData("100%"));
		eepnMnthIcm2012Bfr.setFieldLabel("제외월수");
		layoutContainer_17.add(layoutContainer_30,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_30.setBorders(false);
     
		LayoutContainer layoutContainer_31 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_31.setLayout(frmlytStd);

		eepnMnthIcm2013Aft = new MSFNumberField();
		eepnMnthIcm2013Aft.setAllowDecimals(true);
		eepnMnthIcm2013Aft.setPropertyEditorType(Long.class);
		eepnMnthIcm2013Aft.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_31.add(eepnMnthIcm2013Aft, new FormData("100%"));
		eepnMnthIcm2013Aft.setFieldLabel("");
		eepnMnthIcm2013Aft.setLabelSeparator("/");
		layoutContainer_17.add(layoutContainer_31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_31.setBorders(false);  
     
     
		layoutContainer_16.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainer_17.setBorders(false);
     
		LayoutContainer layoutContainer_18 = new LayoutContainer();
		layoutContainer_18.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_32 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytStd);
     
		addMnthIcm2012Bfr = new MSFNumberField();
		addMnthIcm2012Bfr.setAllowDecimals(true);
		addMnthIcm2012Bfr.setPropertyEditorType(Long.class);
		addMnthIcm2012Bfr.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_32.add(addMnthIcm2012Bfr, new FormData("100%"));
		addMnthIcm2012Bfr.setFieldLabel("가산월수");
    // addMnthIcm2012Bfr.setStyleAttribute("foreground-color", "red");
		layoutContainer_18.add(layoutContainer_32,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_32.setBorders(false);

		LayoutContainer layoutContainer_33 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_33.setLayout(frmlytStd);
     
		addMnthIcm2013Aft = new MSFNumberField();
		addMnthIcm2013Aft.setAllowDecimals(true);
		addMnthIcm2013Aft.setPropertyEditorType(Long.class);
		addMnthIcm2013Aft.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_33.add(addMnthIcm2013Aft, new FormData("100%"));
		addMnthIcm2013Aft.setFieldLabel("");
		addMnthIcm2013Aft.setLabelSeparator("/");
    	layoutContainer_18.add(layoutContainer_33,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
    	layoutContainer_33.setBorders(false);  
     
     
    	layoutContainer_16.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
    	layoutContainer_18.setBorders(false);
     
		LayoutContainer layoutContainer_19 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_19.setLayout(frmlytStd);
     
 
		eepnDayIcmDys = new MSFNumberField();
		eepnDayIcmDys.setAllowDecimals(true);
		eepnDayIcmDys.setPropertyEditorType(Long.class);
		eepnDayIcmDys.setFormat(NumberFormat.getDecimalFormat());
		eepnDayIcmDys.setInputStyleAttribute("text-Align", "right");
		layoutContainer_19.add(eepnDayIcmDys, new FormData("100%"));
		eepnDayIcmDys.setFieldLabel("제외일수");
     
		layoutContainer_16.add(layoutContainer_19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainer_19.setBorders(false);
     
     
		LayoutContainer layoutContainer_119 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_119.setLayout(frmlytStd);
     
 
		sevePayAddRate = new MSFNumberField();
		sevePayAddRate.setAllowDecimals(true);
		sevePayAddRate.setPropertyEditorType(Double.class);
		sevePayAddRate.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_119.add(sevePayAddRate, new FormData("100%"));
		sevePayAddRate.setFieldLabel("가산율");
     
		layoutContainer_16.add(layoutContainer_119,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
		layoutContainer_119.setBorders(false);

		cp02.add(layoutContainer_16);
		layoutContainer_16.setBorders(false);

		LayoutContainer layoutContainer8 = new LayoutContainer();
		layoutContainer8.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		layoutContainer_7.setBorders(false);
		layoutContainer_7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(125);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		logSvcYrNum = new MSFNumberField();
		logSvcYrNum.setReadOnly(true);
		logSvcYrNum.setAllowDecimals(true);
		logSvcYrNum.setPropertyEditorType(Long.class);
		logSvcYrNum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_10.add(logSvcYrNum, new FormData("100%"));
		logSvcYrNum.setFieldLabel("근속기간(년/월/일)");
		layoutContainer_7.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.56));
		layoutContainer_10.setBorders(false);
     
		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		logSvcMnthIcm = new MSFNumberField();
		logSvcMnthIcm.setReadOnly(true);
		logSvcMnthIcm.setAllowDecimals(true);
		logSvcMnthIcm.setPropertyEditorType(Long.class);
		logSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_11.add(logSvcMnthIcm, new FormData("100%"));
		logSvcMnthIcm.setFieldLabel("");
		logSvcMnthIcm.setLabelSeparator("/");
		layoutContainer_7.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
		layoutContainer_11.setBorders(false);
     
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytStd);

		logSvcNumDys = new MSFNumberField();
		logSvcNumDys.setReadOnly(true);
		logSvcNumDys.setAllowDecimals(true);
		logSvcNumDys.setPropertyEditorType(Long.class);
		logSvcNumDys.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_12.add(logSvcNumDys, new FormData("100%"));
		logSvcNumDys.setFieldLabel("");
		logSvcNumDys.setLabelSeparator("/");
		layoutContainer_7.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_12.setBorders(false);
		layoutContainer8.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
      
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		layoutContainer_8.setLayout(new ColumnLayout());
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_20 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(125);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytStd);
     
		/** column 실근무년수 : turtyDutyYrNum */
		turtyDutyYrNum = new MSFNumberField();
		turtyDutyYrNum.setReadOnly(true);
		turtyDutyYrNum.setAllowDecimals(true);
		turtyDutyYrNum.setPropertyEditorType(Long.class);
		turtyDutyYrNum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_20.add(turtyDutyYrNum, new FormData("100%"));
		turtyDutyYrNum.setFieldLabel("실제근무(년/개월/일)");
		layoutContainer_8.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.56));
		layoutContainer_13.setBorders(false);

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytStd);

		/** column 실근무개월수 : turtyDutyMnthNum */
		turtyDutyMnthNum = new MSFNumberField();
		turtyDutyMnthNum.setReadOnly(true);
		turtyDutyMnthNum.setAllowDecimals(true);
		turtyDutyMnthNum.setPropertyEditorType(Long.class);
		turtyDutyMnthNum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_15.add(turtyDutyMnthNum, new FormData("100%"));
		turtyDutyMnthNum.setFieldLabel("");
		turtyDutyMnthNum.setLabelSeparator("/");
		layoutContainer_8.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
		layoutContainer_15.setBorders(false);
     
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);
     
		/** column 실근무일수 : turtyDutyNumDys */
		turtyDutyNumDys = new MSFNumberField();
		turtyDutyNumDys.setReadOnly(true);
		turtyDutyNumDys.setAllowDecimals(true);
		turtyDutyNumDys.setPropertyEditorType(Long.class);
		turtyDutyNumDys.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_14.add(turtyDutyNumDys, new FormData("100%"));
		turtyDutyNumDys.setFieldLabel("");
		turtyDutyNumDys.setLabelSeparator("/");
		layoutContainer_8.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_14.setBorders(false);
		layoutContainer8.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
     
		cp02.add(layoutContainer8);

		layoutContainer.add(cp02);

		return layoutContainer;

	}
 
	private  LayoutContainer DataTop01() {
    
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		tabsRemtSub = new TabPanel(); // 인사탭정보설정을 위한 tab
		// tabsRemtSub.setMinTabWidth(80);
		tabsRemtSub.setAutoWidth(false);
		// tabsRemtSub.setResizeTabs(true);
		tabsRemtSub.setAnimScroll(true);
		tabsRemtSub.setTabScroll(true);
		tabsRemtSub.setPlain(true);
		tabsRemtSub.setSize(583, 312);

		TabItem item01 = new TabItem();
		// item01.setStyleAttribute("padding", "10px");
		item01.setText("산정결과");
		item01.addStyleName("pad-text");
		item01.setLayout(new FormLayout());
		item01.add(Data01(), new FormData("100%"));
		tabsRemtSub.add(item01);
		item01.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 산정결과 탭을 누른경우에 데이터를 리로딩한다.

			}
		});

		TabItem item02 = new TabItem();
		// item02.setStyleAttribute("padding", "10px");
		item02.setText("급여내역");
		item02.setLayout(new FormLayout());
		item02.add(Data02(), new FormData("100%"));
		tabsRemtSub.add(item02);
		item02.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 급여내역에 대한 지급기간 데이터를 가지고와 헤더셋팅하는 부분 추가
				reloadPayrRemt0100Header();

			}
		});

		TabItem item03 = new TabItem();
		// item03.setStyleAttribute("padding", "10px");
		item03.setText("후생복지비");
		item03.setLayout(new FormLayout());
		item03.add(Data03(), new FormData("100%"));
		tabsRemtSub.add(item03);
		item03.addListener(Events.Select, new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent ce) {
				// 후생복지비
				reloadRemt210002();

			}
		});

		lcTabFormLayer.add(tabsRemtSub, new FormData("100%"));

		return lcTabFormLayer;
	}


	private  LayoutContainer DataTop02() {
    
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(590, 324);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_19 = new LayoutContainer();
		layoutContainer_19.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_20 = new LayoutContainer();
		layoutContainer_20.setLayout(new FlowLayout(2));

		layoutContainer_20.add(DataRetm300001());
		layoutContainer_19.add(layoutContainer_20,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));
		layoutContainer_20.setBorders(false);

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setLayout(new FlowLayout(2));
		layoutContainer_21.add(DataRetm300002());
		layoutContainer_19.add(layoutContainer_21,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));
		layoutContainer_21.setBorders(false);

		layoutContainer_19.setBorders(false);
		lytCtr01.add(layoutContainer_19);

		LayoutContainer layoutContainer_23 = new LayoutContainer();
		layoutContainer_23.setLayout(new FlowLayout(2));
		layoutContainer_23.add(DataRetm300003());
		layoutContainer_23.setBorders(false);
		lytCtr01.add(layoutContainer_23);

		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}



	//세액계산요약으로 보여주기
	private  LayoutContainer DataTop03() {
    
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(590, 320);
		cp01.setScrollMode(Scroll.AUTOY);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		lytCtr01.add(DataRetm300004());

		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}


	private  LayoutContainer DataTop04() {
    
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(590, 320);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		lytCtr01.add(DataRemt9000());

		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}


	// 퇴직금
	private LayoutContainer DataRetm300001() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(285, 193);

		// 퇴직금 지급내역
		remtPymt2000GridPanel = new MSFGridPanel(remtPymt2000Def, false, false, false, false);
		remtPymt2000GridPanel.setHeaderVisible(true);
		remtPymt2000GridPanel.setHeadingText("퇴직금지급내역");
		remtPymt2000GridPanel.setBodyBorder(true);
		remtPymt2000GridPanel.setBorders(true);
		remtPymt2000GridPanel.getBottomComponent().setVisible(false);
		// remtPymt2000GridPanel.setGridType(MSFGridType.GROUPBY);
		// remtPymt2000GridPanel.setSize(598, 184);   
//				    final Grid remtPymt2000Grid = remtPymt2000GridPanel.getMsfGrid().getGrid(); 
//				    remtPymt2000Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//			             public void handleEvent(BaseEvent be) {  
//			           	  if (remtPymt2000GridPanel.getCurrentlySelectedItem() != null) {  
//			           		  setRecord(remtPymt2000GridPanel.getCurrentlySelectedItem());	
//			           		  actionDatabase = ActionDatabase.UPDATE;
//			           	  }
//			             }
//			         });  
//		 	  

		cp01.add(remtPymt2000GridPanel);

		LayoutContainer lcSevePayTurtyPymtSum = new LayoutContainer();
		lcSevePayTurtyPymtSum.setBorders(false);

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSevePayTurtyPymtSum.setLayout(frmlytSch);

			    
		sevePayTurtyPymtSum = new MSFNumberField();
		sevePayTurtyPymtSum.setAllowDecimals(true);
		sevePayTurtyPymtSum.setPropertyEditorType(Long.class);
		sevePayTurtyPymtSum.setFormat(NumberFormat.getDecimalFormat());
		// sevePayTurtyPymtSum.setWidth("160px");
		// sevePayTurtyPymtSum.setHeight("30px");
//		sevePayTurtyPymtSum.setStyleAttribute("padding-top", "5px");
//		sevePayTurtyPymtSum.setStyleAttribute("vertical-align", "middle");
//		sevePayTurtyPymtSum.setStyleAttribute("text-align", "right");
//		sevePayTurtyPymtSum.setStyleAttribute("font-size", "12px");
		sevePayTurtyPymtSum.setFieldLabel("실지급금액");
		sevePayTurtyPymtSum.setReadOnly(true);
			   // sevePayTurtyPymtSum.setStyleAttribute("align", value);
			    
			    
		lcSevePayTurtyPymtSum.add(sevePayTurtyPymtSum);
		cp01.setBottomComponent(lcSevePayTurtyPymtSum);
		// cp01.setBottomComponent(sevePayTurtyPymtSum);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
		 
	//공제금액
	private LayoutContainer DataRetm300002() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(287, 198);

		remt2300GridPanel = new MSFGridPanel(remt2300Def, false, false, false,false, false);
		remt2300GridPanel.setHeaderVisible(true);
		remt2300GridPanel.setHeadingText("퇴직금공제내역");
		remt2300GridPanel.setBodyBorder(true);
		remt2300GridPanel.setBorders(true);
		remt2300GridPanel.getBottomComponent().setVisible(false);
	  //	remt2300GridPanel.setGridType(MSFGridType.GROUPBY);
	 // 	remt2300GridPanel.setSize(200, 184);  
		final Grid remt2300Grid = remt2300GridPanel.getMsfGrid().getGrid();
		remt2300Grid.addListener(Events.Select, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (remt2300GridPanel.getCurrentlySelectedItem() != null) {
					setRecord(remt2300GridPanel.getCurrentlySelectedItem());
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		}); 
//			 	  

		cp01.add(remt2300GridPanel);

		cp01.addButton(new Button("공제선택", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
			        	
//		        	   if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//		                   MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//		                   return;
//		               } 
				fnPopupCommP500();
			}
		}));
			     
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) { 
			           
//			        	  if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//			                  MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//			                  return;
//			              }  

				MessageBox.confirm("공제저장", "퇴직금 공제항목을 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
					//	if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							setListRecord(remt2300GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());  
							if (MSFSharedUtils.paramNull(getListRecord()) || !getListRecord().hasNext()) {
								List<Record>  lsRec  = new ArrayList<Record>();
								
								for ( int i = 0; i < remt2300GridPanel.getMsfGrid().getStore().getCount(); i++){
									if(remt2300GridPanel.getMsfGrid().getStore().getRecord(remt2300GridPanel.getMsfGrid().getStore().getAt(i)).isDirty()){ //변경된 로우가 있을경우
										BaseModel bm = remt2300GridPanel.getMsfGrid().getStore().getAt(i); 
										lsRec.add(remt2300GridPanel.getMsfGrid().getStore().getRecord(bm));
									}
								}
								setListRecord(lsRec.iterator()); 
							}
							saveRemt2300DDucData(actionDatabase); 
						}
					}
				});   
			}   
		}));  
			      
		cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
			   	      
//			   	        if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//			                MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//			                return;
//			            }
			           
				MessageBox.confirm("공제삭제", "퇴직금 공제항목을 삭제 하시겠습니까?", new Listener<MessageBoxEvent>() {
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if ("Yes".equals(be.getButtonClicked().getText())) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

							Iterator<BaseModel> itBm  = remt2300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
							List<Record>  lsRec  = new ArrayList<Record>();
			                        
							while(itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}
							setListRecord(lsRec.iterator()); 
			                         
							actionDatabase = ActionDatabase.DELETE;
							saveRemt2300DDucData(actionDatabase);
						}
					}
				});   
			}   
		}));
	 	    
		lcTabFormLayer.add(cp01); 
	 	     
		return lcTabFormLayer;
	} 
		 
		 
	// 근속연수
	private LayoutContainer DataRetm300003() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(578, 110);

		FieldSet subFdSet01 = new FieldSet();
		subFdSet01.setHeadingHtml("근속연수");
		LayoutContainer layoutContainer51 = new LayoutContainer();
		layoutContainer51.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_100 = new LayoutContainer(new FlowLayout());
		layoutContainer_100.setBorders(false);
	           
	           
		LabelField lblfldNewLabelfield_39 = new LabelField("근속연수 : ");
		lblfldNewLabelfield_39.setHeight(25);
		lblfldNewLabelfield_39.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_39.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_39.setStyleAttribute("text-align", "right");
		lblfldNewLabelfield_39.setBorders(false);
		layoutContainer_100.add(lblfldNewLabelfield_39, new FormData("100%"));

		LabelField lblfldNewLabelfield_391 = new LabelField("안분 2012.12.31이전 : ");
		lblfldNewLabelfield_391.setHeight(25);
		lblfldNewLabelfield_391.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_391.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_391.setStyleAttribute("text-align", "right");
		lblfldNewLabelfield_391.setBorders(false);
		layoutContainer_100.add(lblfldNewLabelfield_391, new FormData("100%"));

		LabelField lblfldNewLabelfield_392 = new LabelField("안분 2013.01.01이후 : ");
		lblfldNewLabelfield_392.setHeight(25);
		lblfldNewLabelfield_392.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_392.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_392.setStyleAttribute("text-align", "right");
		lblfldNewLabelfield_392.setBorders(false);
		layoutContainer_100.add(lblfldNewLabelfield_392, new FormData("100%"));
	           
	          
		layoutContainer51.add(layoutContainer_100, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	           
		LayoutContainer layoutContainer3_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(140);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_1.setLayout(frmlytStd);
		      
 
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setLayout(new ColumnLayout());
		layoutContainer_2_1.setBorders(false);

		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_3_1.setLayout(frmlytStd);
		      
		/** column 정산_근속월수 : clutLogSvcMnthIcm */
		clutLogSvcMnthIcm = new MSFNumberField();
		clutLogSvcMnthIcm.setAllowDecimals(true);
		clutLogSvcMnthIcm.setPropertyEditorType(Long.class);
		clutLogSvcMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		clutLogSvcMnthIcm.setReadOnly(true);
		clutLogSvcMnthIcm.setHideLabel(true);
		layoutContainer_3_1.add(clutLogSvcMnthIcm, new FormData("100%"));
	 	        
		   
		layoutContainer_2_1.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_3_1.setBorders(false);

		LabelField lblfldNewLabelfield_40 = new LabelField(" 개월 = ");
		// lblfldNewLabelfield_40.setHeight(20);
		lblfldNewLabelfield_40.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_40.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_40.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_40.setBorders(false);
		layoutContainer_2_1.add(lblfldNewLabelfield_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		     
		     
		LayoutContainer layoutContainer_4_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_4_1.setLayout(frmlytStd);

		MSFNumberField textField_17 = new MSFNumberField();
		textField_17.setAllowDecimals(true);
		textField_17.setPropertyEditorType(Long.class);
		textField_17.setFormat(NumberFormat.getDecimalFormat());
		textField_17.setReadOnly(true);
		textField_17.setHideLabel(true);
		layoutContainer_4_1.add(textField_17, new FormData("100%"));

		layoutContainer_2_1.add(layoutContainer_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_4_1.setBorders(false);

		LabelField lblfldNewLabelfield_41 = new LabelField(" 년  ");
		// lblfldNewLabelfield_41.setHeight(20);
		lblfldNewLabelfield_41.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_41.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_41.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_41.setBorders(false);
		layoutContainer_2_1.add(lblfldNewLabelfield_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		     
	           
		LayoutContainer layoutContainer_5_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_5_1.setLayout(frmlytStd);

		MSFNumberField textField_18 = new MSFNumberField();
		textField_18.setAllowDecimals(true);
		textField_18.setPropertyEditorType(Long.class);
		textField_18.setFormat(NumberFormat.getDecimalFormat());
		textField_18.setReadOnly(true);
		textField_18.setHideLabel(true);
		layoutContainer_5_1.add(textField_18, new FormData("100%"));
		     
		layoutContainer_2_1.add(layoutContainer_5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_5_1.setBorders(false);
		     
		LabelField lblfldNewLabelfield_42 = new LabelField(" 개월 => ");
		// lblfldNewLabelfield_42.setHeight(20);
		lblfldNewLabelfield_42.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_42.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_42.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_42.setBorders(false);
		layoutContainer_2_1.add(lblfldNewLabelfield_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		     
		     
		LayoutContainer layoutContainer_4_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_4_2.setLayout(frmlytStd);
		     
		/** column 정산_근속연수 : clutLogSvcYrNum */
		clutLogSvcYrNum = new MSFNumberField();
		clutLogSvcYrNum.setAllowDecimals(true);
		clutLogSvcYrNum.setPropertyEditorType(Long.class);
		clutLogSvcYrNum.setFormat(NumberFormat.getDecimalFormat());
		clutLogSvcYrNum.setReadOnly(true);
		clutLogSvcYrNum.setHideLabel(true);
		layoutContainer_4_2.add(clutLogSvcYrNum, new FormData("100%"));
		     
		layoutContainer_2_1.add(layoutContainer_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_4_2.setBorders(false);
		     
		LabelField lblfldNewLabelfield_43 = new LabelField(" 년");
		// lblfldNewLabelfield_43.setHeight(20);
		lblfldNewLabelfield_43.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_43.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_43.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_43.setBorders(false);
		layoutContainer_2_1.add(lblfldNewLabelfield_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));

		layoutContainer3_1.add(layoutContainer_2_1);
		     
		     
		// ---안분2012.12.31이전
		LayoutContainer layoutContainer_2_2 = new LayoutContainer();
		layoutContainer_2_2.setLayout(new ColumnLayout());
		layoutContainer_2_2.setBorders(false);
		LayoutContainer layoutContainer_13_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_13_1.setLayout(frmlytStd);
		      
		/** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
		logPpnl12befLogMnthIcm = new MSFNumberField();
		logPpnl12befLogMnthIcm.setAllowDecimals(true);
		logPpnl12befLogMnthIcm.setPropertyEditorType(Long.class);
		logPpnl12befLogMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		logPpnl12befLogMnthIcm.setReadOnly(true);
		logPpnl12befLogMnthIcm.setHideLabel(true);
		layoutContainer_13_1.add(logPpnl12befLogMnthIcm, new FormData("100%"));
	 	        
		   
		layoutContainer_2_2.add(layoutContainer_13_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_13_1.setBorders(false);
		     
		LabelField lblfldNewLabelfield_401 = new LabelField(" 개월 = ");
		// lblfldNewLabelfield_401.setHeight(20);
		lblfldNewLabelfield_401.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_401.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_401.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_401.setBorders(false);
		layoutContainer_2_2.add(lblfldNewLabelfield_401, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		     
		     
		LayoutContainer layoutContainer_41_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_41_1.setLayout(frmlytStd);

		MSFNumberField textField_171 = new MSFNumberField();
		textField_171.setAllowDecimals(true);
		textField_171.setPropertyEditorType(Long.class);
		textField_171.setFormat(NumberFormat.getDecimalFormat());
		textField_171.setReadOnly(true);
		textField_171.setHideLabel(true);
		layoutContainer_41_1.add(textField_171, new FormData("100%"));
		     
		layoutContainer_2_2.add(layoutContainer_41_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_41_1.setBorders(false);
		     
		LabelField lblfldNewLabelfield_412 = new LabelField(" 년  ");
		// lblfldNewLabelfield_412.setHeight(20);
		lblfldNewLabelfield_412.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_412.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_412.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_412.setBorders(false);
		layoutContainer_2_2.add(lblfldNewLabelfield_412, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		     
	           
		LayoutContainer layoutContainer_51_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_51_1.setLayout(frmlytStd);

		MSFNumberField textField_181 = new MSFNumberField();
		textField_181.setAllowDecimals(true);
		textField_181.setPropertyEditorType(Long.class);
		textField_181.setFormat(NumberFormat.getDecimalFormat());
		textField_181.setReadOnly(true);
		textField_181.setHideLabel(true);
		layoutContainer_51_1.add(textField_181, new FormData("100%"));
		     
		layoutContainer_2_2.add(layoutContainer_51_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_51_1.setBorders(false);
		     
		LabelField lblfldNewLabelfield_422 = new LabelField(" 개월 => ");
		// lblfldNewLabelfield_422.setHeight(20);
		lblfldNewLabelfield_422.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_422.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_422.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_422.setBorders(false);
		layoutContainer_2_2.add(lblfldNewLabelfield_422, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
		     
		     
		LayoutContainer layoutContainer_42_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_42_2.setLayout(frmlytStd);

		/** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
		logPpnl12befLogYrNum = new MSFNumberField();
		logPpnl12befLogYrNum.setAllowDecimals(true);
		logPpnl12befLogYrNum.setPropertyEditorType(Long.class);
		logPpnl12befLogYrNum.setFormat(NumberFormat.getDecimalFormat());
		logPpnl12befLogYrNum.setReadOnly(true);
		logPpnl12befLogYrNum.setHideLabel(true);
		layoutContainer_42_2.add(logPpnl12befLogYrNum, new FormData("100%"));
		     
		layoutContainer_2_2.add(layoutContainer_42_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_42_2.setBorders(false);

		LabelField lblfldNewLabelfield_431 = new LabelField(" 년");
		// lblfldNewLabelfield_431.setHeight(20);
		lblfldNewLabelfield_431.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_431.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_431.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_431.setBorders(false);
		layoutContainer_2_2.add(lblfldNewLabelfield_431, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
	           
		layoutContainer3_1.add(layoutContainer_2_2);

		// ---안분2013.01.01이후
		LayoutContainer layoutContainer_2_3 = new LayoutContainer();
		layoutContainer_2_3.setLayout(new ColumnLayout());
		layoutContainer_2_3.setBorders(false);

		LayoutContainer layoutContainer_23_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_23_1.setLayout(frmlytStd);
		     
		/** XX column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm 년수로대체해서 계산 */
		logPpnl13afrLogMnthIcm = new MSFNumberField();
		logPpnl13afrLogMnthIcm.setAllowDecimals(true);
		logPpnl13afrLogMnthIcm.setPropertyEditorType(Long.class);
		logPpnl13afrLogMnthIcm.setFormat(NumberFormat.getDecimalFormat());
		logPpnl13afrLogMnthIcm.setReadOnly(true);
		logPpnl13afrLogMnthIcm.setHideLabel(true);
		layoutContainer_23_1.add(logPpnl13afrLogMnthIcm, new FormData("100%"));
	 	        
		   
		layoutContainer_2_3.add(layoutContainer_23_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_23_1.setBorders(false);

		LabelField lblfldNewLabelfield_402 = new LabelField(" 년 -  ");
		// lblfldNewLabelfield_402.setHeight(20);
		lblfldNewLabelfield_402.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_402.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_402.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_402.setBorders(false);
		layoutContainer_2_3.add(lblfldNewLabelfield_402, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		     
		     
		LayoutContainer layoutContainer_42_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_42_1.setLayout(frmlytStd);

		MSFNumberField textField_172 = new MSFNumberField();
		textField_172.setAllowDecimals(true);
		textField_172.setPropertyEditorType(Long.class);
		textField_172.setFormat(NumberFormat.getDecimalFormat());
		textField_172.setReadOnly(true);
		textField_172.setHideLabel(true);
		layoutContainer_42_1.add(textField_172, new FormData("100%"));
		     
		layoutContainer_2_3.add(layoutContainer_42_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_42_1.setBorders(false);

		LabelField lblfldNewLabelfield_413 = new LabelField(" 년  = ");
		// lblfldNewLabelfield_413.setHeight(20);
		lblfldNewLabelfield_413.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_413.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_413.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_413.setBorders(false);
		layoutContainer_2_3.add(lblfldNewLabelfield_413, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		     
		LayoutContainer layoutContainer_52_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		layoutContainer_52_1.setLayout(frmlytStd);
		     
		/** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
		logPpnl13afrLogSvc = new MSFNumberField();
		logPpnl13afrLogSvc.setAllowDecimals(true);
		logPpnl13afrLogSvc.setPropertyEditorType(Long.class);
		logPpnl13afrLogSvc.setFormat(NumberFormat.getDecimalFormat());
		logPpnl13afrLogSvc.setReadOnly(true);
		logPpnl13afrLogSvc.setHideLabel(true);
		layoutContainer_52_1.add(logPpnl13afrLogSvc, new FormData("100%"));
		     
		layoutContainer_2_3.add(layoutContainer_52_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		layoutContainer_52_1.setBorders(false);

		LabelField lblfldNewLabelfield_423 = new LabelField(" 년 ");
		// lblfldNewLabelfield_423.setHeight(20);
		lblfldNewLabelfield_423.setStyleAttribute("padding-top", "5px");
		lblfldNewLabelfield_423.setStyleAttribute("vertical-align", "middle");
		lblfldNewLabelfield_423.setStyleAttribute("text-align", "center");
		lblfldNewLabelfield_423.setBorders(false);
		layoutContainer_2_3.add(lblfldNewLabelfield_423, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));

		layoutContainer3_1.add(layoutContainer_2_3);
		     
		     
		layoutContainer51.add(layoutContainer3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer3_1.setBorders(false);

		subFdSet01.add(layoutContainer51);

		cp01.add(subFdSet01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
		 
		 
	//산출결과
	private  LayoutContainer DataRetm300004() {
    
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
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
				lyoutMid_01_1.setHeight("22px");
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
	    		lyoutMid_01_2.setHeight("22px");
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
	    		lyoutMid_01_3.setHeight("22px");
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
	    		lyoutMid_01_4.setHeight("22px");
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
				lyoutMid_02_2_1_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldMid_02_2_1_1 = new LabelField("퇴직소득");
	    labelfldMid_02_2_1_1.setStyleAttribute("background-color", "#dfe8f6");
	//    labelfld_02_2_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    retryIncmCtrPymtSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    retryIncmEndPymtSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    retryIncmClutSum.setWidth("165px");
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
				lyoutMid_02_2_2_1.setHeight("22px");
	
			}
	    });
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/          
		 LabelField labelfldMid_02_2_2_1 = new LabelField("퇴직소득정률공제");
	//     lblfldNewLabelfield_38.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/ 	
	     FormLayout formLayoutMid_02_2_2_2 = new FormLayout();
	     formLayoutMid_02_2_2_2.setLabelWidth(0);
	     lyoutMid_02_2_2_2.setLayout(formLayoutMid_02_2_2_2);
		    
	     tempNumFld_02_2_2_2 = new MSFNumberField();
	//   nmbrfldNewNumberfield_49.setAllowDecimals(true); 
	//   nmbrfldNewNumberfield_49.setPropertyEditorType(Long.class); 
	//   nmbrfldNewNumberfield_49.setFormat(NumberFormat.getDecimalFormat());
	   
	     tempNumFld_02_2_2_2.setReadOnly(true);
	     tempNumFld_02_2_2_2.setEnabled(false);
	//   tempNumFld_02_2_2_2.setWidth("160px");
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
	//	    		layoutContainer_02_2_2.setHeight("25px");
		    		}
		    });
		    /**********************************************************************************************************
		     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		     ***********************************************************************************************************/
		FormLayout formLayoutMid_02_2_2_3 = new FormLayout();
		formLayoutMid_02_2_2_3.setLabelWidth(0);
		lyoutMid_02_2_2_3.setLayout(formLayoutMid_02_2_2_3);
		    
		tempNumFld_02_2_2_3 = new MSFNumberField();
	//   nmbrfldNewNumberfield_49.setAllowDecimals(true); 
	//   nmbrfldNewNumberfield_49.setPropertyEditorType(Long.class); 
	//   nmbrfldNewNumberfield_49.setFormat(NumberFormat.getDecimalFormat());
		tempNumFld_02_2_2_3.setReadOnly(true);
		tempNumFld_02_2_2_3.setEnabled(false);
	//   nmbrfldNewNumberfield_49.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    retryFxrtDducClutSum.setWidth("165px");
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
				lyoutMid_02_2_3_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/  
	    LabelField labelfldMid_02_2_3 = new LabelField("근속연수공제");
	//    lblfldNewLabelfield_39.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    FormLayout formLayoutMid_02_2_3_2 = new FormLayout();
	    formLayoutMid_02_2_3_2.setLabelWidth(0);
	    lyoutMid_02_2_3_2.setLayout(formLayoutMid_02_2_3_2);
	    
	    tempNumFld_02_2_3_2 = new MSFNumberField();
	//  nmbrfldNewNumberfield_52.setAllowDecimals(true); 
	//  nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
	//  nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
	  
	    tempNumFld_02_2_3_2.setReadOnly(true);
	    tempNumFld_02_2_3_2.setEnabled(false);
	//  nmbrfldNewNumberfield_52.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    FormLayout formLayoutMid_02_2_3_3 = new FormLayout();
	    formLayoutMid_02_2_3_3.setLabelWidth(0);
	    lyoutMid_02_2_3_3.setLayout(formLayoutMid_02_2_3_3);
	    
	    tempNumFld_02_2_3_3 = new MSFNumberField();
	//  nmbrfldNewNumberfield_52.setAllowDecimals(true); 
	//  nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
	//  nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
	  
	    tempNumFld_02_2_3_3.setReadOnly(true);
	    tempNumFld_02_2_3_3.setEnabled(false);
	//  nmbrfldNewNumberfield_52.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    logYrDducSum.setWidth("165px");
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
				lyoutMid_02_2_4_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldMid_02_2_4_1 = new LabelField("퇴직소득과세표준");
	//    lblfldNewLabelfield_40.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    FormLayout formLayoutMid_02_2_4_2 = new FormLayout();
	    formLayoutMid_02_2_4_2.setLabelWidth(0);
	    lyoutMid_02_2_4_2.setLayout(formLayoutMid_02_2_4_2);
	    
	    tempNumFld_02_2_4_2 = new MSFNumberField();
	//  nmbrfldNewNumberfield_52.setAllowDecimals(true); 
	//  nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
	//  nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
	  
	    tempNumFld_02_2_4_2.setReadOnly(true);
	    tempNumFld_02_2_4_2.setEnabled(false);
	//  nmbrfldNewNumberfield_52.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
	    		}
	    });
	    /**********************************************************************************************************
	     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
	     ***********************************************************************************************************/
	    FormLayout formLayoutMid_02_2_4_3 = new FormLayout();
	    formLayoutMid_02_2_4_3.setLabelWidth(0);
	    lyoutMid_02_2_4_3.setLayout(formLayoutMid_02_2_4_3);
	    
	    tempNumFld_02_2_4_3 = new MSFNumberField();
	//  nmbrfldNewNumberfield_52.setAllowDecimals(true); 
	//  nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
	//  nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat());
	  
	    tempNumFld_02_2_4_3.setReadOnly(true);
	    tempNumFld_02_2_4_3.setEnabled(false);
	//  nmbrfldNewNumberfield_52.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    retryTxtnStdClutSum.setWidth("165px");
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
	    
	    lcTabFormLayer.add(lyoutMid, new FormData("100%"));
	    
	    
	    
	   
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
				lyoutUnder_01_1.setHeight("22px");
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
				lyoutUnder_01_2.setHeight("22px");
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
				lyoutUnder_01_3.setHeight("22px");
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
				lyoutUnder_01_4.setHeight("22px");
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
				lyoutUnder_02_2_1_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_1_1 = new LabelField("과세표준안분");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat12befTxtnStdPpnlSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat13afrTxstdPpnlSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tatAggrTxtnStdPpnlSum.setWidth("165px");
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
				lyoutUnder_02_2_2_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_2_1 = new LabelField("연평균과세표준");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat12befYravgTxstdSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat13afrYrAvgStdSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    tatAggrYrAvgTxtnStdSum.setWidth("165px");
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
				lyoutUnder_02_2_3_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_3_1 = new LabelField("환산과세표준");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    tat12befCvsnTxtnStdSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat13afrCvsnTxtnStdSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tatAggrCvsnTxtnStdSum.setWidth("165px");
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
				lyoutUnder_02_2_4_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_4_1 = new LabelField("환산산출세액");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    tat12befCvsnCalcAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat13afrCvsnCalcTxAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tatAggrCvsnCalcTxAmnt.setWidth("165px");
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
				lyoutUnder_02_2_5_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_5_1 = new LabelField("연평균산출세액");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	     
	//     tat12befYrAvgCalcAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	     
	//     tat13afrYrAvgCalcAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	     
	//     tatAggrYrAvgCalcTxAmnt.setWidth("165px");
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
				lyoutUnder_02_2_6_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_6_1 = new LabelField("산출세액");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat12befCalcTxAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat13afrCalcTxAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tatAggrCalcTxAmnt.setWidth("165px");
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
				lyoutUnder_02_2_7_1.setHeight("22px");
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_7_1 = new LabelField("기납부(또는 기과세이연)세액");
	    labelfldUnder_02_2_7_1.setStyleAttribute("font-size", "10px");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    tat12befAlpayTxAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    tat13afrAlpayTxAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tatAggrAlpayTxAmnt.setWidth("165px");
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
				lyoutUnder_02_2_8_1.setHeight("22px");
	
			}
		});
		/**********************************************************************************************************
		 * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
		 ***********************************************************************************************************/ 
	    LabelField labelfldUnder_02_2_8_1 = new LabelField("신고대상세액");
	//    labelfldUnder_02_2_1_1.setHeight(24);
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	//    tat12befRegTgtTxAmnt.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tat13afrRegrstTgtSum.setWidth("160px");
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
	//    		layoutContainer_02_2_2.setHeight("25px");
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
	    
	//    tatAggrRegrstTgtTxAmnt.setWidth("165px");
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
	    
	    lcTabFormLayer.add(lyoutUnder, new FormData("100%"));
	
	  
//    //퇴직소득과세표준계산 
//    
//    LayoutContainer layoutContainer100_2 = new LayoutContainer();
//    layoutContainer100_2.setLayout(new FitLayout()); 
//    layoutContainer100_2.setHeight(121);
//    layoutContainer100_2.setBorders(false);
//
//	     //4개의 걸럼
//	    
//	 LayoutContainer hBoxTopFrm01 = new LayoutContainer();  
//     HBoxLayout hbLayout01 = new HBoxLayout();  
//     hbLayout01.setPadding(new Padding(0));  
//     hbLayout01.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
//     hBoxTopFrm01.setLayout(hbLayout01);  
//
//     //1
//     LayoutContainer layoutContainer1_1502 = new LayoutContainer();
//     FormLayout frmlytSch = new FormLayout();  
//    frmlytSch.setLabelWidth(0); 
//    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//    layoutContainer1_1502.setLayout(frmlytSch);
//    layoutContainer1_1502.setBorders(true); 
//    layoutContainer1_1502.setWidth(175);
//	    
//
//	    //2
//     LayoutContainer layoutContainer1_2502 = new LayoutContainer();
//  frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer1_2502.setLayout(frmlytSch);
//  layoutContainer1_2502.setBorders(true); 
//  layoutContainer1_2502.setWidth(130);
//	    
//	    //3
//     LayoutContainer layoutContainer1_3502 = new LayoutContainer();
//  frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer1_3502.setLayout(frmlytSch);
//  layoutContainer1_3502.setBorders(true); 
//  layoutContainer1_3502.setWidth(130);
//	    
//	    //4
//     LayoutContainer layoutContainer1_4502 = new LayoutContainer();
//  frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer1_4502.setLayout(frmlytSch);
//  layoutContainer1_4502.setBorders(true); 
//  layoutContainer1_4502.setWidth(130);
//	    
//	  
//
//  hBoxTopFrm01.add(layoutContainer1_1502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//  hBoxTopFrm01.add(layoutContainer1_2502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//  hBoxTopFrm01.add(layoutContainer1_3502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//  hBoxTopFrm01.add(layoutContainer1_4502, new HBoxLayoutData(new Margins(0)));  
//  
//	    
//    //계산내용 
//    
//    final LayoutContainer layoutContainer_84 = new LayoutContainer(new FlowLayout());
//    layoutContainer_84.setStyleAttribute("background-color", "#dfe8f6");
//    layoutContainer_84.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_84.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_84.removeStyleName("x-border");
//                      	// layoutContainer_84.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_84.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_84.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/  
//    LabelField lblfldNewLabelfield_32 = new LabelField("계 산 내 용");
//    lblfldNewLabelfield_32.setStyleAttribute( "text-align", "center"); 
//    lblfldNewLabelfield_32.setBorders(false);
//    layoutContainer_84.add(lblfldNewLabelfield_32, new FormData("100%"));
//    layoutContainer1_1502.add(layoutContainer_84);
//    
//    
//    final LayoutContainer layoutContainer_85 = new LayoutContainer(new FlowLayout());
//    layoutContainer_85.setStyleAttribute("background-color", "#dfe8f6");
//    layoutContainer_85.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_85.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_85.removeStyleName("x-border");
//                      	// layoutContainer_85.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_85.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_85.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/  
//    LabelField lblfldNewLabelfield_33 = new LabelField("중간지급");
//    lblfldNewLabelfield_33.setStyleAttribute( "text-align", "center"); 
//    lblfldNewLabelfield_33.setBorders(false);
//    layoutContainer_85.add(lblfldNewLabelfield_33, new FormData("100%"));
//    layoutContainer1_2502.add(layoutContainer_85); 
//    
//    
//    final LayoutContainer layoutContainer_86 = new LayoutContainer(new FlowLayout());
//    layoutContainer_86.setStyleAttribute("background-color", "#dfe8f6");
//    layoutContainer_86.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_86.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_86.removeStyleName("x-border");
//                      	// layoutContainer_86.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_86.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_86.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/  
//    LabelField lblfldNewLabelfield_34 = new LabelField("최종분");
//    lblfldNewLabelfield_34.setStyleAttribute( "text-align", "center"); 
//    lblfldNewLabelfield_34.setBorders(false);
//    layoutContainer_86.add(lblfldNewLabelfield_34, new FormData("100%"));
//    layoutContainer1_3502.add(layoutContainer_86);
//  
//    
//    final LayoutContainer layoutContainer_87 = new LayoutContainer(new FlowLayout());
//    layoutContainer_87.setStyleAttribute("background-color", "#dfe8f6");
//    layoutContainer_87.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_87.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_87.removeStyleName("x-border");
//                      	// layoutContainer_87.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_87.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_87.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    LabelField lblfldNewLabelfield_35 = new LabelField("정산(합산)");
//    lblfldNewLabelfield_35.setStyleAttribute( "text-align", "center"); 
//    lblfldNewLabelfield_35.setBorders(false);
//    layoutContainer_87.add(lblfldNewLabelfield_35, new FormData("100%"));
//    layoutContainer1_4502.add(layoutContainer_87);
//    
//    final LayoutContainer layoutContainer1_94 = new LayoutContainer();
//    layoutContainer1_94.setStyleAttribute("background-color", "#dfe8f6");
//    layoutContainer1_94.setLayout(new ColumnLayout());
//    layoutContainer1_94.setBorders(false);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
////    layoutContainer1_94.addListener(Events.Render, new Listener<BaseEvent>() {
////	                   public void handleEvent(BaseEvent be) {
////	                
////	                	   layoutContainer1_94.removeStyleName("x-border");
////                      	// layoutContainer1_94.setStyleName("x-border-u-right",true);
////	                	   layoutContainer1_94.setStyleName("x-border-u-bottom",true);
////	                	   layoutContainer1_94.setHeight("120px");  
////	                          
////	                 
////	                   }
////	       });
//	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    
//    final LayoutContainer layoutContainer_88 = new LayoutContainer(new FlowLayout());
//    layoutContainer_88.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_88.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_88.removeStyleName("x-border");
//                      	   layoutContainer_88.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_88.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_88.setHeight("118px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    
//   LabelField lblfldNewLabelfield_36 = new LabelField("퇴직소득과세표준계산");
//   lblfldNewLabelfield_36.setStyleAttribute( "text-align", "center"); 
//   lblfldNewLabelfield_36.setStyleAttribute( "padding-top", "10px"); 
//   layoutContainer_88.add(lblfldNewLabelfield_36, new FormData("100%")); 
//   layoutContainer1_94.add(layoutContainer_88, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
// 
//   final LayoutContainer layoutContainer_89 = new LayoutContainer(new FlowLayout());
//  // frmlytSch = new FormLayout();  
//  // frmlytSch.setLabelWidth(0); 
//  // frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  // layoutContainer_89.setLayout(frmlytSch);
//   layoutContainer_89.setBorders(false); 
// 
//   final LayoutContainer layoutContainer_90 = new LayoutContainer(new FlowLayout()); 
//   layoutContainer_90.setBorders(true);
//   
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_90.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_90.removeStyleName("x-border");
//                     	// layoutContainer_90.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_90.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_90.setHeight("25px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   
//   LabelField lblfldNewLabelfield_37 = new LabelField("퇴직소득");
//   lblfldNewLabelfield_37.setBorders(false);
//   //lblfldNewLabelfield_37.setHeight(24);
//   lblfldNewLabelfield_37.setStyleAttribute("paddingTop", "5px");
//   lblfldNewLabelfield_37.setStyleAttribute("vertical-align", "middle"); 
//   layoutContainer_90.add(lblfldNewLabelfield_37, new FormData("100%")); 
//   layoutContainer_89.add(layoutContainer_90);
//   
//   layoutContainer1_94.add(layoutContainer_89, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//   
//   layoutContainer1_1502.add(layoutContainer1_94);
//   
//   final LayoutContainer layoutContainer_91 = new LayoutContainer(new FlowLayout());
//   layoutContainer_91.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_91.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_91.removeStyleName("x-border");
//                     	// layoutContainer_91.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_91.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_91.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
//   retryIncmCtrPymtSum = new MSFNumberField();
//   retryIncmCtrPymtSum.setReadOnly(true);
//   retryIncmCtrPymtSum.setAllowDecimals(true); 
//   retryIncmCtrPymtSum.setPropertyEditorType(Long.class); 
//   retryIncmCtrPymtSum.setFormat(NumberFormat.getDecimalFormat());
//   
//   retryIncmCtrPymtSum.setWidth("130px");
//   retryIncmCtrPymtSum.setHideLabel(true);
//   layoutContainer_91.add(retryIncmCtrPymtSum, new FlowData(0));
//   layoutContainer1_2502.add(layoutContainer_91);
//    
//   
//   final LayoutContainer layoutContainer_92 = new LayoutContainer(new FlowLayout());
//   layoutContainer_92.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_92.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_92.removeStyleName("x-border");
//                     	// layoutContainer_92.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_92.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_92.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
//   retryIncmEndPymtSum = new MSFNumberField();
//   retryIncmEndPymtSum.setReadOnly(true);
//   retryIncmEndPymtSum.setAllowDecimals(true); 
//   retryIncmEndPymtSum.setPropertyEditorType(Long.class); 
//   retryIncmEndPymtSum.setFormat(NumberFormat.getDecimalFormat());
//   
//   retryIncmEndPymtSum.setWidth("130px");
//   retryIncmEndPymtSum.setHideLabel(true);
//   layoutContainer_92.add(retryIncmEndPymtSum, new FlowData(0));
//   layoutContainer1_3502.add(layoutContainer_92);
//  
//   
//   final LayoutContainer layoutContainer_93 = new LayoutContainer(new FlowLayout());
//   layoutContainer_93.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_93.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_93.removeStyleName("x-border");
//                     	// layoutContainer_93.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_93.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_93.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   /** column 퇴직소득_정산금액 : retryIncmClutSum */
//   retryIncmClutSum = new MSFNumberField();
//   retryIncmClutSum.setReadOnly(true);
//   retryIncmClutSum.setAllowDecimals(true); 
//   retryIncmClutSum.setPropertyEditorType(Long.class); 
//   retryIncmClutSum.setFormat(NumberFormat.getDecimalFormat());
//   
//   retryIncmClutSum.setWidth("130px");
//   retryIncmClutSum.setHideLabel(true);
//   layoutContainer_93.add(retryIncmClutSum, new FlowData(0));
//   layoutContainer1_4502.add(layoutContainer_93);
//    
//  
//     final LayoutContainer layoutContainer_95 = new LayoutContainer(new FlowLayout());
//     layoutContainer_95.setBorders(true);
//     /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//      ------------------------------------------------------------------------------------------------------------*/
//     layoutContainer_95.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_95.removeStyleName("x-border");
//                       	// layoutContainer_95.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_95.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_95.setHeight("25px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//       * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//       ------------------------------------------------------------------------------------------------------------*/ 
//     LabelField lblfldNewLabelfield_38 = new LabelField("퇴직소득정률공제");
//   //  lblfldNewLabelfield_38.setHeight(24);
//     lblfldNewLabelfield_38.setStyleAttribute("paddingTop", "5px");
//     lblfldNewLabelfield_38.setStyleAttribute("vertical-align", "middle"); 
//     lblfldNewLabelfield_38.setBorders(false);
//     layoutContainer_95.add(lblfldNewLabelfield_38, new FormData("100%"));
//     
//     layoutContainer_89.add(layoutContainer_95); 
//     
//     final LayoutContainer layoutContainer_96 = new LayoutContainer(new FlowLayout());
//     layoutContainer_96.setBorders(true); 
//     /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//      ------------------------------------------------------------------------------------------------------------*/
//     layoutContainer_96.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_96.removeStyleName("x-border");
//                       	// layoutContainer_96.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_96.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_96.setHeight("24px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//       * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//       ------------------------------------------------------------------------------------------------------------*/ 
//     MSFNumberField nmbrfldNewNumberfield_49 = new MSFNumberField();
////     nmbrfldNewNumberfield_49.setAllowDecimals(true); 
////     nmbrfldNewNumberfield_49.setPropertyEditorType(Long.class); 
////     nmbrfldNewNumberfield_49.setFormat(NumberFormat.getDecimalFormat());
//     
//     nmbrfldNewNumberfield_49.setReadOnly(true);
//     nmbrfldNewNumberfield_49.setEnabled(false);
//     nmbrfldNewNumberfield_49.setWidth("130px");
//     nmbrfldNewNumberfield_49.setHideLabel(true);
//     layoutContainer_96.add(nmbrfldNewNumberfield_49, new FlowData(0));
//     layoutContainer1_2502.add(layoutContainer_96); 
//     
//     final LayoutContainer layoutContainer_97 = new LayoutContainer(new FlowLayout());
//     layoutContainer_97.setBorders(true);
//     /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//      ------------------------------------------------------------------------------------------------------------*/
//     layoutContainer_97.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_97.removeStyleName("x-border");
//                       	// layoutContainer_97.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_97.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_97.setHeight("24px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//       * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//       ------------------------------------------------------------------------------------------------------------*/ 
//     MSFNumberField nmbrfldNewNumberfield_50 = new MSFNumberField();
////     nmbrfldNewNumberfield_50.setAllowDecimals(true); 
////     nmbrfldNewNumberfield_50.setPropertyEditorType(Long.class); 
////     nmbrfldNewNumberfield_50.setFormat(NumberFormat.getDecimalFormat());
//     
//     nmbrfldNewNumberfield_50.setReadOnly(true);
//     nmbrfldNewNumberfield_50.setEnabled(false);
//     nmbrfldNewNumberfield_50.setWidth("130px");
//     nmbrfldNewNumberfield_50.setHideLabel(true);
//     layoutContainer_97.add(nmbrfldNewNumberfield_50, new FlowData(0));
//     layoutContainer1_3502.add(layoutContainer_97); 
//     
//     final LayoutContainer layoutContainer_98 = new LayoutContainer(new FlowLayout());
//     layoutContainer_98.setBorders(true);
//     /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//      ------------------------------------------------------------------------------------------------------------*/
//     layoutContainer_98.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_98.removeStyleName("x-border");
//                       	// layoutContainer_98.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_98.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_98.setHeight("24px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//       * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//       ------------------------------------------------------------------------------------------------------------*/ 
//     /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//     retryFxrtDducClutSum = new MSFNumberField();
//     retryFxrtDducClutSum.setReadOnly(true);
//     retryFxrtDducClutSum.setAllowDecimals(true); 
//     retryFxrtDducClutSum.setPropertyEditorType(Long.class); 
//     retryFxrtDducClutSum.setFormat(NumberFormat.getDecimalFormat());
//     
//     retryFxrtDducClutSum.setWidth("130px");
//     retryFxrtDducClutSum.setHideLabel(true);
//     layoutContainer_98.add(retryFxrtDducClutSum, new FlowData(0));
//     layoutContainer1_4502.add(layoutContainer_98);  
//     
//     //근속연수공제 
//    final  LayoutContainer layoutContainer_100 = new LayoutContainer(new FlowLayout());
//    layoutContainer_100.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_100.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_100.removeStyleName("x-border");
//                      	// layoutContainer_100.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_100.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_100.setHeight("25px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//    LabelField lblfldNewLabelfield_39 = new LabelField("근속연수공제");
//  //  lblfldNewLabelfield_39.setHeight(24);
//    lblfldNewLabelfield_39.setStyleAttribute("paddingTop", "5px");
//    lblfldNewLabelfield_39.setStyleAttribute("vertical-align", "middle"); 
//    lblfldNewLabelfield_39.setBorders(false);
//    layoutContainer_100.add(lblfldNewLabelfield_39, new FormData("100%"));
//    layoutContainer_89.add(layoutContainer_100);
//    
//    
//    final LayoutContainer layoutContainer_101 = new LayoutContainer(new FlowLayout());
//    layoutContainer_101.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_101.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_101.removeStyleName("x-border");
//                      	// layoutContainer_101.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_101.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_101.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    MSFNumberField nmbrfldNewNumberfield_52 = new MSFNumberField();
////    nmbrfldNewNumberfield_52.setAllowDecimals(true); 
////    nmbrfldNewNumberfield_52.setPropertyEditorType(Long.class); 
////    nmbrfldNewNumberfield_52.setFormat(NumberFormat.getDecimalFormat()); 
//    nmbrfldNewNumberfield_52.setReadOnly(true);
//    nmbrfldNewNumberfield_52.setEnabled(false);
//    nmbrfldNewNumberfield_52.setWidth("130px");
//    nmbrfldNewNumberfield_52.setHideLabel(true);
//    layoutContainer_101.add(nmbrfldNewNumberfield_52, new FlowData(0));
//    layoutContainer1_2502.add(layoutContainer_101);
//    
//    
//    final LayoutContainer layoutContainer_102 = new LayoutContainer(new FlowLayout());
//    layoutContainer_102.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_102.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_102.removeStyleName("x-border");
//                      	// layoutContainer_102.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_102.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_102.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    MSFNumberField nmbrfldNewNumberfield_53 = new MSFNumberField();
////    nmbrfldNewNumberfield_53.setAllowDecimals(true); 
////    nmbrfldNewNumberfield_53.setPropertyEditorType(Long.class); 
////    nmbrfldNewNumberfield_53.setFormat(NumberFormat.getDecimalFormat());
//    
//    nmbrfldNewNumberfield_53.setReadOnly(true);
//    nmbrfldNewNumberfield_53.setEnabled(false);
//    nmbrfldNewNumberfield_53.setWidth("130px");
//    nmbrfldNewNumberfield_53.setHideLabel(true);
//    layoutContainer_102.add(nmbrfldNewNumberfield_53, new FlowData(0));
//    layoutContainer1_3502.add(layoutContainer_102);
//    
//    
//    final LayoutContainer layoutContainer_103 = new LayoutContainer(new FlowLayout());
//    layoutContainer_103.setBorders(true);
//    /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//     ------------------------------------------------------------------------------------------------------------*/
//    layoutContainer_103.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_103.removeStyleName("x-border");
//                      	// layoutContainer_103.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_103.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_103.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//      * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//      ------------------------------------------------------------------------------------------------------------*/ 
//    /** column 근속년수공제_정산금액 : logYrDducSum */
//    logYrDducSum = new MSFNumberField();
//    logYrDducSum.setReadOnly(true);
//    logYrDducSum.setAllowDecimals(true); 
//    logYrDducSum.setPropertyEditorType(Long.class); 
//    logYrDducSum.setFormat(NumberFormat.getDecimalFormat());
//    
//    logYrDducSum.setWidth("130px");
//    logYrDducSum.setHideLabel(true);
//    layoutContainer_103.add(logYrDducSum, new FlowData(0));
//    layoutContainer1_4502.add(layoutContainer_103);
//    
//    
//   final  LayoutContainer layoutContainer_105 = new LayoutContainer(new FlowLayout());
//   layoutContainer_105.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_105.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_105.removeStyleName("x-border");
//                     	// layoutContainer_105.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_105.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_105.setHeight("25px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   LabelField lblfldNewLabelfield_40 = new LabelField("퇴직소득과세표준");
// //  lblfldNewLabelfield_40.setHeight(24);
//   lblfldNewLabelfield_40.setStyleAttribute("padding-top", "5px");
//   lblfldNewLabelfield_40.setStyleAttribute("vertical-align", "middle"); 
//   lblfldNewLabelfield_40.setBorders(false);
//   layoutContainer_105.add(lblfldNewLabelfield_40, new FormData("100%"));  
//   layoutContainer_89.add(layoutContainer_105);
//   
//   
//   final LayoutContainer layoutContainer_106 = new LayoutContainer(new FlowLayout());
//   layoutContainer_106.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_106.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_106.removeStyleName("x-border");
//                     	// layoutContainer_106.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_106.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_106.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   MSFNumberField nmbrfldNewNumberfield_55 = new MSFNumberField();
////   nmbrfldNewNumberfield_55.setAllowDecimals(true); 
////   nmbrfldNewNumberfield_55.setPropertyEditorType(Long.class); 
////   nmbrfldNewNumberfield_55.setFormat(NumberFormat.getDecimalFormat());
//   
//   nmbrfldNewNumberfield_55.setReadOnly(true);
//   nmbrfldNewNumberfield_55.setEnabled(false);
//   nmbrfldNewNumberfield_55.setWidth("130px");
//   nmbrfldNewNumberfield_55.setHideLabel(true);
//   layoutContainer_106.add(nmbrfldNewNumberfield_55, new FlowData(0));
//   layoutContainer1_2502.add(layoutContainer_106);
//  
//   
//   final LayoutContainer layoutContainer_107 = new LayoutContainer(new FlowLayout());
//   layoutContainer_107.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_107.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_107.removeStyleName("x-border");
//                     	// layoutContainer_107.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_107.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_107.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   MSFNumberField nmbrfldNewNumberfield_56 = new MSFNumberField();
////   nmbrfldNewNumberfield_56.setAllowDecimals(true); 
////   nmbrfldNewNumberfield_56.setPropertyEditorType(Long.class); 
////   nmbrfldNewNumberfield_56.setFormat(NumberFormat.getDecimalFormat());
//   
//   nmbrfldNewNumberfield_56.setReadOnly(true);
//   nmbrfldNewNumberfield_56.setEnabled(false);
//   nmbrfldNewNumberfield_56.setWidth("130px");
//   nmbrfldNewNumberfield_56.setHideLabel(true);
//   layoutContainer_107.add(nmbrfldNewNumberfield_56, new FlowData(0));
//   layoutContainer1_3502.add(layoutContainer_107);
//   
//   
//   final LayoutContainer layoutContainer_108 = new LayoutContainer(new FlowLayout());
//   layoutContainer_108.setBorders(true);
//   /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//    ------------------------------------------------------------------------------------------------------------*/
//   layoutContainer_108.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_108.removeStyleName("x-border");
//                     	// layoutContainer_108.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_108.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_108.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//     * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//     ------------------------------------------------------------------------------------------------------------*/ 
//   /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//   retryTxtnStdClutSum = new MSFNumberField();
//   retryTxtnStdClutSum.setReadOnly(true);
//   retryTxtnStdClutSum.setAllowDecimals(true); 
//   retryTxtnStdClutSum.setPropertyEditorType(Long.class); 
//   retryTxtnStdClutSum.setFormat(NumberFormat.getDecimalFormat());
//   retryTxtnStdClutSum.setWidth("130px");
//   retryTxtnStdClutSum.setHideLabel(true);
//   layoutContainer_108.add(retryTxtnStdClutSum, new FlowData(0));
//   layoutContainer1_4502.add(layoutContainer_108);
//   
//   layoutContainer100_2.add(hBoxTopFrm01);
//	    
//   lcTabFormLayer.add(layoutContainer100_2);
//   
//   //퇴직소득과세표준계산 
//   
//   LayoutContainer layoutContainer200_2 = new LayoutContainer();
//   layoutContainer200_2.setLayout(new FitLayout()); 
//   layoutContainer200_2.setHeight(223);
//   layoutContainer200_2.setBorders(false);
//
//	     //4개의 걸럼
//	    
//	    LayoutContainer hBoxTopFrm02 = new LayoutContainer();  
//     HBoxLayout hbLayout02 = new HBoxLayout();  
//     hbLayout02.setPadding(new Padding(0));  
//     hbLayout02.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
//     hBoxTopFrm02.setLayout(hbLayout02);  
//
//     //1
//     LayoutContainer layoutContainer2_1502 = new LayoutContainer();
//   frmlytSch = new FormLayout();  
//   frmlytSch.setLabelWidth(0); 
//   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//   layoutContainer2_1502.setLayout(frmlytSch);
//   layoutContainer2_1502.setBorders(true); 
//   layoutContainer2_1502.setWidth(175);
//	   
//   //2
//     LayoutContainer layoutContainer2_2502 = new LayoutContainer();
//  frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer2_2502.setLayout(frmlytSch);
//  layoutContainer2_2502.setBorders(true); 
//  layoutContainer2_2502.setWidth(130);
//	    
//	    //3
//     LayoutContainer layoutContainer2_3502 = new LayoutContainer();
//  frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer2_3502.setLayout(frmlytSch);
//  layoutContainer2_3502.setBorders(true); 
//  layoutContainer2_3502.setWidth(130);
//	    
//	    //4
//     LayoutContainer layoutContainer2_4502 = new LayoutContainer();
//  frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer2_4502.setLayout(frmlytSch);
//  layoutContainer2_4502.setBorders(true); 
//  layoutContainer2_4502.setWidth(130);
//	    
//	    
//
//  hBoxTopFrm02.add(layoutContainer2_1502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//  hBoxTopFrm02.add(layoutContainer2_2502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//  hBoxTopFrm02.add(layoutContainer2_3502, new HBoxLayoutData(new Margins(0, 0, 0, 0)));  
//  hBoxTopFrm02.add(layoutContainer2_4502, new HBoxLayoutData(new Margins(0)));  
//  
//  
//  final LayoutContainer layoutContainer_110 = new LayoutContainer(new FlowLayout());
//  layoutContainer_110.setStyleAttribute("background-color", "#dfe8f6");
//  layoutContainer_110.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_110.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_110.removeStyleName("x-border");
//                    	// layoutContainer_110.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_110.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_110.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_41 = new LabelField("계 산 내 용");
//  lblfldNewLabelfield_41.setStyleAttribute( "text-align", "center"); 
//  lblfldNewLabelfield_41.setBorders(false);
//  layoutContainer_110.add(lblfldNewLabelfield_41, new FormData("100%"));
//  layoutContainer2_1502.add(layoutContainer_110);
// 
//  
//  final LayoutContainer layoutContainer_111 = new LayoutContainer(new FlowLayout());
//  layoutContainer_111.setStyleAttribute("background-color", "#dfe8f6");
//  layoutContainer_111.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_111.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_111.removeStyleName("x-border");
//                    	// layoutContainer_111.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_111.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_111.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_42 = new LabelField("2012.12.31.이전");
//  lblfldNewLabelfield_42.setStyleAttribute( "text-align", "center"); 
//  lblfldNewLabelfield_42.setBorders(false);
//  layoutContainer_111.add(lblfldNewLabelfield_42, new FormData("100%"));
//  layoutContainer2_2502.add(layoutContainer_111);
//  
//  
//  final LayoutContainer layoutContainer_112 = new LayoutContainer(new FlowLayout());
//  layoutContainer_112.setStyleAttribute("background-color", "#dfe8f6");
//  layoutContainer_112.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_112.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_112.removeStyleName("x-border");
//                    	// layoutContainer_112.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_112.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_112.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_43 = new LabelField("2013.1.1이후");
//  lblfldNewLabelfield_43.setStyleAttribute( "text-align", "center"); 
//  lblfldNewLabelfield_43.setBorders(false);
//  layoutContainer_112.add(lblfldNewLabelfield_43, new FormData("100%"));
//  layoutContainer2_3502.add(layoutContainer_112);
//  
//  
//  final LayoutContainer layoutContainer_113 = new LayoutContainer(new FlowLayout());
//  layoutContainer_113.setStyleAttribute("background-color", "#dfe8f6");
//  layoutContainer_113.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_113.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_113.removeStyleName("x-border");
//                    	// layoutContainer_113.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_113.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_113.setHeight("22px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_44 = new LabelField("합 계");
//  lblfldNewLabelfield_44.setStyleAttribute( "text-align", "center"); 
//  lblfldNewLabelfield_44.setBorders(false);
//  layoutContainer_113.add(lblfldNewLabelfield_44, new FormData("100%"));
//  layoutContainer2_4502.add(layoutContainer_113);
//	      
////  퇴직소득세액계산
//  LayoutContainer layoutContainer_114 = new LayoutContainer();
//  layoutContainer_114.setStyleAttribute("background-color", "#dfe8f6");
//  layoutContainer_114.setLayout(new ColumnLayout());
//  layoutContainer_114.setBorders(false);
//  
//  final LayoutContainer layoutContainer_115 = new LayoutContainer(new FlowLayout());
//   frmlytSch = new FormLayout();  
//  frmlytSch.setLabelWidth(0); 
//  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//  layoutContainer_115.setLayout(frmlytSch);
//  layoutContainer_115.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_115.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_115.removeStyleName("x-border");
//                    	   layoutContainer_115.setStyleName("x-border-u-right",true);
//	                	    layoutContainer_115.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_115.setHeight("125px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_45 = new LabelField("퇴직소득세액계산");
//  layoutContainer_115.add(lblfldNewLabelfield_45, new FormData("100%"));
//  layoutContainer_114.add(layoutContainer_115, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//  
//   LayoutContainer layoutContainera_124 = new LayoutContainer();
//  layoutContainera_124.setBorders(false);
//   
//  final LayoutContainer layoutContainer_124 = new LayoutContainer(new FlowLayout());
//  layoutContainer_124.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_124.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_124.removeStyleName("x-border");
//	                	  // layoutContainer_124.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_124.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_124.setHeight("25px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_46 = new LabelField("과세표준안분");
////  lblfldNewLabelfield_46.setHeight(24);
//  lblfldNewLabelfield_46.setStyleAttribute("paddingTop", "5px");
//  lblfldNewLabelfield_46.setStyleAttribute("vertical-align", "middle"); 
//  lblfldNewLabelfield_46.setBorders(false);
//  layoutContainer_124.add(lblfldNewLabelfield_46, new FormData("100%"));
//  layoutContainera_124.add(layoutContainer_124);
//  layoutContainer_114.add(layoutContainera_124, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//
//  layoutContainer2_1502.add(layoutContainer_114); 
//  
//  
//  final LayoutContainer layoutContainer_125 = new LayoutContainer(new FlowLayout());
//  layoutContainer_125.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_125.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_125.removeStyleName("x-border");
//	                	  // layoutContainer_125.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_125.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_125.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//  tat12befTxtnStdPpnlSum = new MSFNumberField();
//  tat12befTxtnStdPpnlSum.setReadOnly(true);
//  tat12befTxtnStdPpnlSum.setAllowDecimals(true); 
//  tat12befTxtnStdPpnlSum.setPropertyEditorType(Long.class); 
//  tat12befTxtnStdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
//  
//  tat12befTxtnStdPpnlSum.setWidth("130px");
//  tat12befTxtnStdPpnlSum.setHideLabel(true);
//  layoutContainer_125.add(tat12befTxtnStdPpnlSum, new FlowData(0));
//  layoutContainer2_2502.add(layoutContainer_125);
//  
//  
//  final LayoutContainer layoutContainer_126 = new LayoutContainer(new FlowLayout());
//  layoutContainer_126.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_126.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_126.removeStyleName("x-border");
//	                	  // layoutContainer_126.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_126.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_126.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//  tat13afrTxstdPpnlSum = new MSFNumberField();
//  tat13afrTxstdPpnlSum.setReadOnly(true);
//  tat13afrTxstdPpnlSum.setAllowDecimals(true); 
//  tat13afrTxstdPpnlSum.setPropertyEditorType(Long.class); 
//  tat13afrTxstdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
//  
//  tat13afrTxstdPpnlSum.setWidth("130px");
//  tat13afrTxstdPpnlSum.setHideLabel(true);
//  layoutContainer_126.add(tat13afrTxstdPpnlSum, new FlowData(0));
//  layoutContainer2_3502.add(layoutContainer_126);
//  
//  
//  final LayoutContainer layoutContainer_127 = new LayoutContainer(new FlowLayout());
//  layoutContainer_127.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_127.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_127.removeStyleName("x-border");
//	                	  // layoutContainer_127.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_127.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_127.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//  tatAggrTxtnStdPpnlSum = new MSFNumberField();
//  tatAggrTxtnStdPpnlSum.setReadOnly(true);
//  tatAggrTxtnStdPpnlSum.setAllowDecimals(true); 
//  tatAggrTxtnStdPpnlSum.setPropertyEditorType(Long.class); 
//  tatAggrTxtnStdPpnlSum.setFormat(NumberFormat.getDecimalFormat());
//  
//  tatAggrTxtnStdPpnlSum.setWidth("130px");
//  tatAggrTxtnStdPpnlSum.setHideLabel(true);
//  layoutContainer_127.add(tatAggrTxtnStdPpnlSum, new FlowData(0));
//  layoutContainer2_4502.add(layoutContainer_127);
//
//    
//  //연평균과세표준
//  
//  final LayoutContainer layoutContainer_128 = new LayoutContainer(new FlowLayout());
// layoutContainer_128.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_128.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_128.removeStyleName("x-border");
//	                	  // layoutContainer_128.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_128.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_128.setHeight("25px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// LabelField lblfldNewLabelfield_50 = new LabelField("연평균과세표준");
//// lblfldNewLabelfield_50.setHeight(24);
// lblfldNewLabelfield_50.setStyleAttribute("paddingTop", "5px");
// lblfldNewLabelfield_50.setStyleAttribute("vertical-align", "middle"); 
// lblfldNewLabelfield_50.setBorders(false);
// layoutContainer_128.add(lblfldNewLabelfield_50, new FormData("100%"));
// layoutContainera_124.add(layoutContainer_128);
// 
// 
// final LayoutContainer layoutContainer_129 = new LayoutContainer(new FlowLayout());
// layoutContainer_129.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_129.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_129.removeStyleName("x-border");
//	                	  // layoutContainer_129.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_129.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_129.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
// tat12befYravgTxstdSum = new MSFNumberField();
// tat12befYravgTxstdSum.setReadOnly(true);
// tat12befYravgTxstdSum.setAllowDecimals(true); 
// tat12befYravgTxstdSum.setPropertyEditorType(Long.class); 
// tat12befYravgTxstdSum.setFormat(NumberFormat.getDecimalFormat());
// 
// tat12befYravgTxstdSum.setWidth("130px");
// tat12befYravgTxstdSum.setHideLabel(true);
// layoutContainer_129.add(tat12befYravgTxstdSum, new FlowData(0));
// layoutContainer2_2502.add(layoutContainer_129);
//
// 
// final LayoutContainer layoutContainer_130 = new LayoutContainer(new FlowLayout());
// layoutContainer_130.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_130.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_130.removeStyleName("x-border");
//	                	  // layoutContainer_130.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_130.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_130.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
// tat13afrYrAvgStdSum = new MSFNumberField();
// tat13afrYrAvgStdSum.setReadOnly(true);
// tat13afrYrAvgStdSum.setAllowDecimals(true); 
// tat13afrYrAvgStdSum.setPropertyEditorType(Long.class); 
// tat13afrYrAvgStdSum.setFormat(NumberFormat.getDecimalFormat());
// 
// tat13afrYrAvgStdSum.setWidth("130px");
// tat13afrYrAvgStdSum.setHideLabel(true);
// layoutContainer_130.add(tat13afrYrAvgStdSum, new FlowData(0));
// layoutContainer2_3502.add(layoutContainer_130);
// 
// 
//final  LayoutContainer layoutContainer_131 = new LayoutContainer(new FlowLayout());
// layoutContainer_131.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_131.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_131.removeStyleName("x-border");
//	                	  // layoutContainer_131.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_131.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_131.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum REadonly 데이타없음.*/
// tatAggrYrAvgTxtnStdSum = new MSFNumberField();
// tatAggrYrAvgTxtnStdSum.setAllowDecimals(true); 
// tatAggrYrAvgTxtnStdSum.setPropertyEditorType(Long.class); 
// tatAggrYrAvgTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
// tatAggrYrAvgTxtnStdSum.setReadOnly(true); 
// tatAggrYrAvgTxtnStdSum.setWidth("130px");
// tatAggrYrAvgTxtnStdSum.setHideLabel(true);
// layoutContainer_131.add(tatAggrYrAvgTxtnStdSum, new FlowData(0));
// layoutContainer2_4502.add(layoutContainer_131);
// 
//  
// final LayoutContainer layoutContainer_132 = new LayoutContainer(new FlowLayout());
//layoutContainer_132.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_132.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_132.removeStyleName("x-border");
//	                	  // layoutContainer_132.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_132.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_132.setHeight("25px");  
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
//LabelField lblfldNewLabelfield_51 = new LabelField("환산과세표준");
////lblfldNewLabelfield_51.setHeight(24);
//lblfldNewLabelfield_51.setStyleAttribute("paddingTop", "5px");
//lblfldNewLabelfield_51.setStyleAttribute("vertical-align", "middle"); 
//lblfldNewLabelfield_51.setBorders(false);
//layoutContainer_132.add(lblfldNewLabelfield_51, new FormData("100%"));
//layoutContainera_124.add(layoutContainer_132);
//
//
//final LayoutContainer layoutContainer_133 = new LayoutContainer(new FlowLayout());
//layoutContainer_133.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_133.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_133.removeStyleName("x-border");
//	                	  // layoutContainer_133.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_133.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_133.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
///** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum readonly*/
//tat12befCvsnTxtnStdSum = new MSFNumberField();
//tat12befCvsnTxtnStdSum.setAllowDecimals(true); 
//tat12befCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
//tat12befCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//tat12befCvsnTxtnStdSum.setReadOnly(true); 
//tat12befCvsnTxtnStdSum.setWidth("130px");
//tat12befCvsnTxtnStdSum.setHideLabel(true);
//layoutContainer_133.add(tat12befCvsnTxtnStdSum, new FlowData(0));
//layoutContainer2_2502.add(layoutContainer_133);
//
//
//final LayoutContainer layoutContainer_134 = new LayoutContainer(new FlowLayout());
//layoutContainer_134.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_134.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_134.removeStyleName("x-border");
//	                	  // layoutContainer_134.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_134.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_134.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
///** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//tat13afrCvsnTxtnStdSum = new MSFNumberField();
//tat13afrCvsnTxtnStdSum.setReadOnly(true);
//tat13afrCvsnTxtnStdSum.setAllowDecimals(true); 
//tat13afrCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
//tat13afrCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//
//tat13afrCvsnTxtnStdSum.setWidth("130px");
//tat13afrCvsnTxtnStdSum.setHideLabel(true);
//layoutContainer_134.add(tat13afrCvsnTxtnStdSum, new FlowData(0));
//layoutContainer2_3502.add(layoutContainer_134);
//
//
//final LayoutContainer layoutContainer_135 = new LayoutContainer(new FlowLayout());
//layoutContainer_135.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_135.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_135.removeStyleName("x-border");
//	                	  // layoutContainer_135.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_135.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_135.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
///** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//tatAggrCvsnTxtnStdSum = new MSFNumberField();
//tatAggrCvsnTxtnStdSum.setReadOnly(true);
//tatAggrCvsnTxtnStdSum.setAllowDecimals(true); 
//tatAggrCvsnTxtnStdSum.setPropertyEditorType(Long.class); 
//tatAggrCvsnTxtnStdSum.setFormat(NumberFormat.getDecimalFormat());
//
//tatAggrCvsnTxtnStdSum.setWidth("130px");
//tatAggrCvsnTxtnStdSum.setHideLabel(true);
//layoutContainer_135.add(tatAggrCvsnTxtnStdSum, new FlowData(0));
//layoutContainer2_4502.add(layoutContainer_135);
//
//
//final LayoutContainer layoutContainer_136 = new LayoutContainer(new FlowLayout());
//layoutContainer_136.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_136.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_136.removeStyleName("x-border");
//	                	  // layoutContainer_136.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_136.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_136.setHeight("25px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
//LabelField lblfldNewLabelfield_52 = new LabelField("환산산출세액");
////lblfldNewLabelfield_52.setHeight(24);
//lblfldNewLabelfield_52.setStyleAttribute("paddingTop", "5px");
//lblfldNewLabelfield_52.setStyleAttribute("vertical-align", "middle"); 
//lblfldNewLabelfield_52.setBorders(false);
//layoutContainer_136.add(lblfldNewLabelfield_52, new FormData("100%"));
//layoutContainera_124.add(layoutContainer_136);
//
//
//final LayoutContainer layoutContainer_137 = new LayoutContainer(new FlowLayout());
//layoutContainer_137.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_137.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_137.removeStyleName("x-border");
//	                	  // layoutContainer_137.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_137.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_137.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
///** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt readonly*/
//tat12befCvsnCalcAmnt = new MSFNumberField();
//tat12befCvsnCalcAmnt.setAllowDecimals(true); 
//tat12befCvsnCalcAmnt.setPropertyEditorType(Long.class); 
//tat12befCvsnCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
//tat12befCvsnCalcAmnt.setReadOnly(true); 
//tat12befCvsnCalcAmnt.setWidth("130px");
//tat12befCvsnCalcAmnt.setHideLabel(true);
//layoutContainer_137.add(tat12befCvsnCalcAmnt, new FlowData(0));
//layoutContainer2_2502.add(layoutContainer_137);
//
//
//
//final LayoutContainer layoutContainer_138 = new LayoutContainer(new FlowLayout());
//layoutContainer_138.setBorders(true);
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_138.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_138.removeStyleName("x-border");
//	                	  // layoutContainer_138.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_138.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_138.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
///** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//tat13afrCvsnCalcTxAmnt = new MSFNumberField();
//tat13afrCvsnCalcTxAmnt.setReadOnly(true);
//tat13afrCvsnCalcTxAmnt.setAllowDecimals(true); 
//tat13afrCvsnCalcTxAmnt.setPropertyEditorType(Long.class); 
//tat13afrCvsnCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//
//tat13afrCvsnCalcTxAmnt.setWidth("130px");
//tat13afrCvsnCalcTxAmnt.setHideLabel(true);
//layoutContainer_138.add(tat13afrCvsnCalcTxAmnt, new FlowData(0));
//layoutContainer2_3502.add(layoutContainer_138);
//
//
//final LayoutContainer layoutContainer_139 = new LayoutContainer(new FlowLayout());
//layoutContainer_139.setBorders(true); 
///**------------------------------------------------------------------------------------------------------------
// * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
// ------------------------------------------------------------------------------------------------------------*/
//layoutContainer_139.addListener(Events.Render, new Listener<BaseEvent>() {
//	                   public void handleEvent(BaseEvent be) {
//	                
//	                	   layoutContainer_139.removeStyleName("x-border");
//	                	  // layoutContainer_139.setStyleName("x-border-u-right",true);
//	                	   layoutContainer_139.setStyleName("x-border-u-bottom",true);
//	                	   layoutContainer_139.setHeight("24px");  
//	                          
//	                 
//	                   }
//	       });
//	 /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//  ------------------------------------------------------------------------------------------------------------*/ 
///** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//tatAggrCvsnCalcTxAmnt = new MSFNumberField();
//tatAggrCvsnCalcTxAmnt.setReadOnly(true);
//tatAggrCvsnCalcTxAmnt.setInputStyleAttribute("text-Align", "right");
//tatAggrCvsnCalcTxAmnt.setAllowDecimals(true); 
//tatAggrCvsnCalcTxAmnt.setPropertyEditorType(Long.class); 
//tatAggrCvsnCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//
//tatAggrCvsnCalcTxAmnt.setWidth("130px");
//tatAggrCvsnCalcTxAmnt.setHideLabel(true);
//layoutContainer_139.add(tatAggrCvsnCalcTxAmnt, new FlowData(0));
//layoutContainer2_4502.add(layoutContainer_139);
//
////연평균산출세액
//   final LayoutContainer layoutContainer_140 = new LayoutContainer(new FlowLayout());
//  layoutContainer_140.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_140.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_140.removeStyleName("x-border");
//  	                	  // layoutContainer_140.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_140.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_140.setHeight("25px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  LabelField lblfldNewLabelfield_53 = new LabelField("연평균산출세액");
//  //lblfldNewLabelfield_53.setHeight(24);
//  lblfldNewLabelfield_53.setStyleAttribute("paddingTop", "5px");
//  lblfldNewLabelfield_53.setStyleAttribute("vertical-align", "middle"); 
//  lblfldNewLabelfield_53.setBorders(false);
//  layoutContainer_140.add(lblfldNewLabelfield_53, new FormData("100%"));
//  layoutContainera_124.add(layoutContainer_140);
//  
//  
//  final LayoutContainer layoutContainer_141 = new LayoutContainer(new FlowLayout());
//  layoutContainer_141.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_141.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_141.removeStyleName("x-border");
//  	                	  // layoutContainer_141.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_141.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_141.setHeight("24px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//  tat12befYrAvgCalcAmnt = new MSFNumberField();
//  tat12befYrAvgCalcAmnt.setReadOnly(true);
//  tat12befYrAvgCalcAmnt.setAllowDecimals(true); 
//  tat12befYrAvgCalcAmnt.setPropertyEditorType(Long.class); 
//  tat12befYrAvgCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
//  
//  tat12befYrAvgCalcAmnt.setWidth("130px");
//  tat12befYrAvgCalcAmnt.setHideLabel(true);
//  layoutContainer_141.add(tat12befYrAvgCalcAmnt, new FlowData(0));
//  layoutContainer2_2502.add(layoutContainer_141);
//  
//  
//  final LayoutContainer layoutContainer_142 = new LayoutContainer(new FlowLayout());
//  layoutContainer_142.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_142.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_142.removeStyleName("x-border");
//  	                	  // layoutContainer_142.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_142.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_142.setHeight("24px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//  tat13afrYrAvgCalcAmnt = new MSFNumberField();
//  tat13afrYrAvgCalcAmnt.setReadOnly(true);
//  tat13afrYrAvgCalcAmnt.setAllowDecimals(true); 
//  tat13afrYrAvgCalcAmnt.setPropertyEditorType(Long.class); 
//  tat13afrYrAvgCalcAmnt.setFormat(NumberFormat.getDecimalFormat());
//  
//  tat13afrYrAvgCalcAmnt.setWidth("130px");
//  tat13afrYrAvgCalcAmnt.setHideLabel(true);
//  layoutContainer_142.add(tat13afrYrAvgCalcAmnt, new FlowData(0));
//  layoutContainer2_3502.add(layoutContainer_142);
//  
//  
//  final LayoutContainer layoutContainer_143 = new LayoutContainer(new FlowLayout());
//  layoutContainer_143.setBorders(true);
//  /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//   ------------------------------------------------------------------------------------------------------------*/
//  layoutContainer_143.addListener(Events.Render, new Listener<BaseEvent>() {
//  	                   public void handleEvent(BaseEvent be) {
//  	                
//  	                	 layoutContainer_143.removeStyleName("x-border");
//  	                	  // layoutContainer_143.setStyleName("x-border-u-right",true);
//  	                	layoutContainer_143.setStyleName("x-border-u-bottom",true);
//  	                	layoutContainer_143.setHeight("24px");  
//  	                          
//  	                 
//  	                   }
//  	       });
//  	 /**------------------------------------------------------------------------------------------------------------
//    * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//    ------------------------------------------------------------------------------------------------------------*/ 
//  /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//  tatAggrYrAvgCalcTxAmnt = new MSFNumberField();
//  tatAggrYrAvgCalcTxAmnt.setReadOnly(true);
//  tatAggrYrAvgCalcTxAmnt.setAllowDecimals(true); 
//  tatAggrYrAvgCalcTxAmnt.setPropertyEditorType(Long.class); 
//  tatAggrYrAvgCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
//  
//  tatAggrYrAvgCalcTxAmnt.setWidth("130px");
//  tatAggrYrAvgCalcTxAmnt.setHideLabel(true);
//  layoutContainer_143.add(tatAggrYrAvgCalcTxAmnt, new FlowData(0));
//  layoutContainer2_4502.add(layoutContainer_143);
//  
//  //산출세액
//  
// final  LayoutContainer layoutContainer_144 = new LayoutContainer(new FlowLayout());
// layoutContainer_144.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_144.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_144.removeStyleName("x-border");
// 	                	  // layoutContainer_143.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_144.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_144.setHeight("25px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// LabelField lblfldNewLabelfield_54 = new LabelField("산출세액");
// //lblfldNewLabelfield_54.setHeight(24);
// lblfldNewLabelfield_54.setStyleAttribute("paddingTop", "5px");
// lblfldNewLabelfield_54.setStyleAttribute("vertical-align", "middle"); 
// lblfldNewLabelfield_54.setBorders(false);
// layoutContainer_144.add(lblfldNewLabelfield_54, new FormData("100%"));
// layoutContainer_114.add(layoutContainer_144 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//  
// 
// final LayoutContainer layoutContainer_145 = new LayoutContainer(new FlowLayout());
// layoutContainer_145.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_145.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_145.removeStyleName("x-border");
// 	                	  // layoutContainer_145.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_145.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_145.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
// tat12befCalcTxAmnt = new MSFNumberField();
// tat12befCalcTxAmnt.setReadOnly(true);
// tat12befCalcTxAmnt.setAllowDecimals(true); 
// tat12befCalcTxAmnt.setPropertyEditorType(Long.class); 
// tat12befCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// 
// tat12befCalcTxAmnt.setWidth("130px");
// tat12befCalcTxAmnt.setHideLabel(true);
// layoutContainer_145.add(tat12befCalcTxAmnt, new FlowData(0));
// layoutContainer2_2502.add(layoutContainer_145);
//
// 
// final LayoutContainer layoutContainer_146 = new LayoutContainer(new FlowLayout());
// layoutContainer_146.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_146.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_146.removeStyleName("x-border");
// 	                	  // layoutContainer_146.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_146.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_146.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
// tat13afrCalcTxAmnt = new MSFNumberField();
// tat13afrCalcTxAmnt.setReadOnly(true);
// tat13afrCalcTxAmnt.setAllowDecimals(true); 
// tat13afrCalcTxAmnt.setPropertyEditorType(Long.class); 
// tat13afrCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// 
// tat13afrCalcTxAmnt.setWidth("130px");
// tat13afrCalcTxAmnt.setHideLabel(true);
// layoutContainer_146.add(tat13afrCalcTxAmnt, new FlowData(0));
// layoutContainer2_3502.add(layoutContainer_146);
// 
// 
// final LayoutContainer layoutContainer_147 = new LayoutContainer(new FlowLayout());
// layoutContainer_147.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_147.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_147.removeStyleName("x-border");
// 	                	  // layoutContainer_147.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_147.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_147.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
// tatAggrCalcTxAmnt = new MSFNumberField();
// tatAggrCalcTxAmnt.setReadOnly(true);
// tatAggrCalcTxAmnt.setAllowDecimals(true); 
// tatAggrCalcTxAmnt.setPropertyEditorType(Long.class); 
// tatAggrCalcTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// 
// tatAggrCalcTxAmnt.setWidth("130px");
// tatAggrCalcTxAmnt.setHideLabel(true);
// layoutContainer_147.add(tatAggrCalcTxAmnt, new FlowData(0));
// layoutContainer2_4502.add(layoutContainer_147);
// 
// 
// final LayoutContainer layoutContainer_148 = new LayoutContainer(new FlowLayout());
// layoutContainer_148.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_148.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_148.removeStyleName("x-border");
// 	                	  // layoutContainer_148.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_148.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_148.setHeight("25px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// LabelField lblfldNewLabelfield_47 = new LabelField("기납부(또는 기과세이연)세액");
// //lblfldNewLabelfield_47.setHeight(24);
// lblfldNewLabelfield_47.setStyleAttribute("paddingTop", "5px");
// lblfldNewLabelfield_47.setStyleAttribute("vertical-align", "middle"); 
// lblfldNewLabelfield_47.setBorders(false);
// layoutContainer_148.add(lblfldNewLabelfield_47, new FormData("100%"));
// layoutContainer_114.add(layoutContainer_148,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//
// 
// final LayoutContainer layoutContainer_149 = new LayoutContainer(new FlowLayout());
// layoutContainer_149.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_149.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_149.removeStyleName("x-border");
// 	                	  // layoutContainer_149.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_149.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_149.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt readonly*/
// tat12befAlpayTxAmnt = new MSFNumberField();
// tat12befAlpayTxAmnt.setAllowDecimals(true); 
// tat12befAlpayTxAmnt.setPropertyEditorType(Long.class); 
// tat12befAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// tat12befAlpayTxAmnt.setReadOnly(true);
// tat12befAlpayTxAmnt.setWidth("130px");
// tat12befAlpayTxAmnt.setHideLabel(true);
// layoutContainer_149.add(tat12befAlpayTxAmnt, new FlowData(0));
// layoutContainer2_2502.add(layoutContainer_149);
// 
// 
// final LayoutContainer layoutContainer_150 = new LayoutContainer(new FlowLayout());
// layoutContainer_150.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_150.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_150.removeStyleName("x-border");
// 	                	  // layoutContainer_150.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_150.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_150.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt readonly*/
// tat13afrAlpayTxAmnt = new MSFNumberField();
// tat13afrAlpayTxAmnt.setAllowDecimals(true); 
// tat13afrAlpayTxAmnt.setPropertyEditorType(Long.class); 
// tat13afrAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// tat13afrAlpayTxAmnt.setReadOnly(true);
// tat13afrAlpayTxAmnt.setWidth("130px");
// tat13afrAlpayTxAmnt.setHideLabel(true);
// layoutContainer_150.add(tat13afrAlpayTxAmnt, new FlowData(0));
// layoutContainer2_3502.add(layoutContainer_150);
// 
// 
// final LayoutContainer layoutContainer_151 = new LayoutContainer(new FlowLayout());
// layoutContainer_151.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_151.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_151.removeStyleName("x-border");
// 	                	  // layoutContainer_151.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_151.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_151.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
// tatAggrAlpayTxAmnt = new MSFNumberField();
// tatAggrAlpayTxAmnt.setReadOnly(true);
// tatAggrAlpayTxAmnt.setAllowDecimals(true); 
// tatAggrAlpayTxAmnt.setPropertyEditorType(Long.class); 
// tatAggrAlpayTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// 
// tatAggrAlpayTxAmnt.setWidth("130px");
// tatAggrAlpayTxAmnt.setHideLabel(true);
// layoutContainer_151.add(tatAggrAlpayTxAmnt, new FlowData(0));
// layoutContainer2_4502.add(layoutContainer_151);
//
// final LayoutContainer layoutContainer_152 = new LayoutContainer(new FlowLayout());
// layoutContainer_152.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_152.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_152.removeStyleName("x-border");
// 	                	  // layoutContainer_152.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_152.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_152.setHeight("25px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// LabelField lblfldNewLabelfield_48 = new LabelField("신고대상세액");
// //lblfldNewLabelfield_48.setHeight(24);
// lblfldNewLabelfield_48.setStyleAttribute("paddingTop", "5px");
// lblfldNewLabelfield_48.setStyleAttribute("vertical-align", "middle"); 
// lblfldNewLabelfield_48.setBorders(false);
// layoutContainer_152.add(lblfldNewLabelfield_48, new FormData("100%"));
// layoutContainer_114.add(layoutContainer_152,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
// 
// 
// final LayoutContainer layoutContainer_153 = new LayoutContainer(new FlowLayout());
// layoutContainer_153.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_153.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_153.removeStyleName("x-border");
// 	                	  // layoutContainer_153.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_153.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_153.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt readonly*/
// tat12befRegTgtTxAmnt = new MSFNumberField();
// tat12befRegTgtTxAmnt.setAllowDecimals(true); 
// tat12befRegTgtTxAmnt.setPropertyEditorType(Long.class); 
// tat12befRegTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// tat12befRegTgtTxAmnt.setReadOnly(true);
// tat12befRegTgtTxAmnt.setWidth("130px");
// tat12befRegTgtTxAmnt.setHideLabel(true);
// layoutContainer_153.add(tat12befRegTgtTxAmnt, new FlowData(0));
// layoutContainer2_2502.add(layoutContainer_153);
// 
// 
// final LayoutContainer layoutContainer_154 = new LayoutContainer(new FlowLayout());
// layoutContainer_154.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_154.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_154.removeStyleName("x-border");
// 	                	  // layoutContainer_154.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_154.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_154.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
// tat13afrRegrstTgtSum = new MSFNumberField();
// tat13afrRegrstTgtSum.setReadOnly(true);
// tat13afrRegrstTgtSum.setAllowDecimals(true); 
// tat13afrRegrstTgtSum.setPropertyEditorType(Long.class); 
// tat13afrRegrstTgtSum.setFormat(NumberFormat.getDecimalFormat());
// 
// tat13afrRegrstTgtSum.setWidth("130px");
// tat13afrRegrstTgtSum.setHideLabel(true);
// layoutContainer_154.add(tat13afrRegrstTgtSum, new FlowData(0));
// layoutContainer2_3502.add(layoutContainer_154);
// 
// 
// final LayoutContainer layoutContainer_155 = new LayoutContainer(new FlowLayout());
// layoutContainer_155.setBorders(true);
// /**------------------------------------------------------------------------------------------------------------
//  * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(start) css 적용 
//  ------------------------------------------------------------------------------------------------------------*/
// layoutContainer_155.addListener(Events.Render, new Listener<BaseEvent>() {
// 	                   public void handleEvent(BaseEvent be) {
// 	                
// 	                	  layoutContainer_155.removeStyleName("x-border");
// 	                	  // layoutContainer_155.setStyleName("x-border-u-right",true);
// 	                	 layoutContainer_155.setStyleName("x-border-u-bottom",true);
// 	                	layoutContainer_155.setHeight("24px");  
// 	                          
// 	                 
// 	                   }
// 	       });
// 	 /**------------------------------------------------------------------------------------------------------------
//   * 렌더링에 따른 소득명세 화면그리기 설정을 모아둔다.(end)
//   ------------------------------------------------------------------------------------------------------------*/ 
// /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
// tatAggrRegrstTgtTxAmnt = new MSFNumberField();
// tatAggrRegrstTgtTxAmnt.setReadOnly(true);
// tatAggrRegrstTgtTxAmnt.setAllowDecimals(true); 
// tatAggrRegrstTgtTxAmnt.setPropertyEditorType(Long.class); 
// tatAggrRegrstTgtTxAmnt.setFormat(NumberFormat.getDecimalFormat());
// 
// tatAggrRegrstTgtTxAmnt.setWidth("130px");
// tatAggrRegrstTgtTxAmnt.setHideLabel(true);
// layoutContainer_155.add(tatAggrRegrstTgtTxAmnt, new FlowData(0));
// layoutContainer2_4502.add(layoutContainer_155);
// 
//  layoutContainer200_2.add(hBoxTopFrm02);
//	    
//  lcTabFormLayer.add(layoutContainer200_2);
       
	    return lcTabFormLayer;
	}
		 
	// 퇴직정산
	private LayoutContainer DataRemt9000() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(586, 318);

		remt3100GridPanel = new MSFGridPanel(remt3100Def, false, false, false, false);
		remt3100GridPanel.setHeaderVisible(false);
		remt3100GridPanel.setBodyBorder(true);
		remt3100GridPanel.setBorders(true);
		// remt3100GridPanel.setVisible(false);
		// remt3100GridPanel .setGridType(MSFGridType.GROUPBY);
		// emt3100GridPanel.setSize(936, 440);

		cp01.add(remt3100GridPanel);

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
		cp01.setSize(315, 508);
		//

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		remt2000DefGridPanel = new MSFGridPanel(remt2000Def, false, false, false, false);
		remt2000DefGridPanel.setHeaderVisible(false);
		remt2000DefGridPanel.setBodyBorder(true);
		remt2000DefGridPanel.setBorders(true);
		// remt2000DefGridPanel.setSize(308, 466);
		// msfGridPanel.setMSFFormPanel(msfCustomForm); //폼을 그리드에 넣은다.

		final Grid remt2000DefGrid = remt2000DefGridPanel.getMsfGrid().getGrid();
		remt2000DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (remt2000DefGridPanel.getCurrentlySelectedItem() != null) { 
					
					BaseModel bmData = new BaseModel();
        		  
					bmData = remt2000DefGridPanel.getCurrentlySelectedItem();
        		   
					dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
					systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
					clutYrMnth.setValue(MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")));   /** column 정산년월 : clutYrMnth */
					calcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(bmData.get("calcSevePayPsnDivCd"))));   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        	    
					clutYr.setValue(lsCrClutYrStore.findModel("year",MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")).substring(0, 4)) );   /** column 정산년 : clutYr */
					clutMnth.setValue(lsCrClutMnth.findModel("month",MSFSharedUtils.allowNulls(bmData.get("clutYrMnth")).substring(4, 6)) );   /** column 정산월 : clutMnth */
					
					reloadRemt2000();
				} 
        	    tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
        	    tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
	       }
	  });  

		cp01.add(remt2000DefGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
 
	   
	// 산정결과
	private LayoutContainer Data01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FlowLayout(5));
		cp01.setSize(558, 287);

		cp01.add(DataRemt2000());

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	 
	 
	private LayoutContainer DataRemt2000() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(555, 283);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		payCmpttnBgnnDt = new MSFDateField();
		payCmpttnBgnnDt.setReadOnly(true);
		new DateFieldMask(payCmpttnBgnnDt, "9999.99.99");
		payCmpttnBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		payCmpttnBgnnDt.setName("payCmpttnBgnnDt");
		payCmpttnBgnnDt.setAllowBlank(false);
		layoutContainer_6.add(payCmpttnBgnnDt, new FormData("100%"));
		payCmpttnBgnnDt.setFieldLabel("급여산정기간");
		layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(20);
		frmlytStd.setLabelSeparator("");
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
	     
		payCmpttnEndDt = new MSFDateField();
		payCmpttnEndDt.setReadOnly(true);
		new DateFieldMask(icncDt, "9999.99.99");
		payCmpttnEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		payCmpttnEndDt.setName("payCmpttnEndDt");
		payCmpttnEndDt.setAllowBlank(false);
		layoutContainer_7.add(payCmpttnEndDt, new FormData("100%"));
		payCmpttnEndDt.setFieldLabel("~");
		layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);

		layoutContainer_5.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.30));
		layoutContainer_8.setBorders(false);

		lytCtr01.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytStd);
	     
		/** column 3월간후생복지비 : marPubcWelfAmnt */
		marPubcWelfAmnt = new MSFNumberField();
		marPubcWelfAmnt.setReadOnly(true);
		marPubcWelfAmnt.setAllowDecimals(true);
		marPubcWelfAmnt.setPropertyEditorType(Long.class);
		marPubcWelfAmnt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_18.add(marPubcWelfAmnt, new FormData("100%"));
		marPubcWelfAmnt.setFieldLabel("3개월간후생복지비");
		layoutContainer_9.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_18.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		marTotAmntWag = new MSFNumberField();
		marTotAmntWag.setReadOnly(true);
		marTotAmntWag.setAllowDecimals(true);
		marTotAmntWag.setPropertyEditorType(Long.class);
		marTotAmntWag.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_10.add(marTotAmntWag, new FormData("100%"));
		marTotAmntWag.setFieldLabel("3개월간총임금액");
		layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_10.setBorders(false);

		lytCtr01.add(layoutContainer_9);
		layoutContainer_9.setBorders(false);
	      
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);
	     
		dayAvgAmntWag = new MSFNumberField();
		dayAvgAmntWag.setReadOnly(true);
		dayAvgAmntWag.setAllowDecimals(true);
		dayAvgAmntWag.setPropertyEditorType(Long.class);
		dayAvgAmntWag.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_13.add(dayAvgAmntWag, new FormData("100%"));
		dayAvgAmntWag.setFieldLabel("일평균임금액");
		layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_13.setBorders(false);
	     
 
		lytCtr01.add(layoutContainer_12);
		layoutContainer_12.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		totLogSvcNumDys = new MSFNumberField();
		totLogSvcNumDys.setReadOnly(true);
		totLogSvcNumDys.setAllowDecimals(true);
		totLogSvcNumDys.setPropertyEditorType(Long.class);
		totLogSvcNumDys.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_3.add(totLogSvcNumDys, new FormData("100%"));
		totLogSvcNumDys.setFieldLabel("근속일수"); 
	     
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
	     
		/** column 퇴직금산정금액 : sevePayCmpttnSum */
		sevePayCmpttnSum = new MSFNumberField();
		sevePayCmpttnSum.setReadOnly(true);
		sevePayCmpttnSum.setAllowDecimals(true);
		sevePayCmpttnSum.setPropertyEditorType(Long.class);
		sevePayCmpttnSum.setFormat(NumberFormat.getDecimalFormat());
		sevePayCmpttnSum.setFieldLabel("퇴직금액");
		layoutContainer_4.add(sevePayCmpttnSum, new FormData("100%"));

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_4.setBorders(false);

		lytCtr01.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);

		FieldSet subFdSet01 = new FieldSet();
		subFdSet01.setTitle("퇴직금가산");
		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		layoutContainer2_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer3_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(145);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_1.setLayout(frmlytStd);

		seveViewPayAddRate = new MSFNumberField();
		seveViewPayAddRate.setReadOnly(true);
		seveViewPayAddRate.setAllowDecimals(true);
		seveViewPayAddRate.setPropertyEditorType(Double.class);
		seveViewPayAddRate.setFormat(NumberFormat.getDecimalFormat());
		seveViewPayAddRate.setFieldLabel("퇴직금가산율");
		layoutContainer3_1.add(seveViewPayAddRate, new FormData("100%"));
 	        
	   
		layoutContainer2_1.add(layoutContainer3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer3_1.setBorders(false);

		LayoutContainer layoutContainer4_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_1.setLayout(frmlytStd);

		/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
		sevePayAddApptnSum = new MSFNumberField();
		sevePayAddApptnSum.setReadOnly(true);
		sevePayAddApptnSum.setAllowDecimals(true);
		sevePayAddApptnSum.setPropertyEditorType(Long.class);
		sevePayAddApptnSum.setFormat(NumberFormat.getDecimalFormat());
		sevePayAddApptnSum.setFieldLabel("근무연수가산금");
		layoutContainer4_1.add(sevePayAddApptnSum, new FormData("100%"));
	     
		layoutContainer2_1.add(layoutContainer4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer4_1.setBorders(false);

		subFdSet01.add(layoutContainer2_1);

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(145);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3_1.setLayout(frmlytStd);

		/** column 군경력근무일수 : amcrrLogSvcNumDys */
		amcrrLogSvcNumDys = new MSFNumberField();
		amcrrLogSvcNumDys.setReadOnly(true);
		amcrrLogSvcNumDys.setAllowDecimals(true);
		amcrrLogSvcNumDys.setPropertyEditorType(Long.class);
		amcrrLogSvcNumDys.setFormat(NumberFormat.getDecimalFormat());
		amcrrLogSvcNumDys.setFieldLabel("군경력일수");
		layoutContainer_3_1.add(amcrrLogSvcNumDys, new FormData("100%"));
 	        
	   
		layoutContainer_2_1.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_3_1.setBorders(false);

		LayoutContainer layoutContainer_4_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4_1.setLayout(frmlytStd);

		/** column 군경력가산적용금액 : amcrrAddApptnSum */
		amcrrAddApptnSum = new MSFNumberField();
		amcrrAddApptnSum.setReadOnly(true);
		amcrrAddApptnSum.setAllowDecimals(true);
		amcrrAddApptnSum.setPropertyEditorType(Long.class);
		amcrrAddApptnSum.setFormat(NumberFormat.getDecimalFormat());
		amcrrAddApptnSum.setFieldLabel("군경력가산금");
		layoutContainer_4_1.add(amcrrAddApptnSum, new FormData("100%"));
	     
		layoutContainer_2_1.add(layoutContainer_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_4_1.setBorders(false);

		subFdSet01.add(layoutContainer_2_1);
		lytCtr01.add(subFdSet01);
		layoutContainer_2_1.setBorders(false);

		LayoutContainer layoutContainer_121 = new LayoutContainer();
		layoutContainer_121.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_131 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(150);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_131.setLayout(frmlytStd);

		/** column 퇴직금지급액 : sevePayPymtSum */
		sevePayPymtSum = new MSFNumberField();
		sevePayPymtSum.setReadOnly(true);
		sevePayPymtSum.setAllowDecimals(true);
		sevePayPymtSum.setPropertyEditorType(Long.class);
		sevePayPymtSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_131.add(sevePayPymtSum, new FormData("100%"));
		sevePayPymtSum.setFieldLabel("퇴직금지급액");
		layoutContainer_121.add(layoutContainer_131, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_131.setBorders(false);

		lytCtr01.add(layoutContainer_121);
		layoutContainer_121.setBorders(false);

		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	 
	// 급여내역
	private LayoutContainer Data02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		//
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(583, 287);

		remtPayr0100GridPanel = new MSFGridPanel(remtPayr0100Def, false, false, false, false, false);
		remtPayr0100GridPanel.setHeaderVisible(false);
		remtPayr0100GridPanel.setBodyBorder(true);
		remtPayr0100GridPanel.setBorders(true);
	  
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM01).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM02).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM03).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM04).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT01).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT02).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT03).setStyle("background-color:#F5F6CE;");
	    GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT04).setStyle("background-color:#F5F6CE;");
	     
		AggregationRowConfig<BaseModel> remtPayr0100SummaryRow = new AggregationRowConfig<BaseModel>();  
		 
		remtPayr0100SummaryRow.setCellStyle(RemtPayr0100BM.ATTR_PAYITEMNM,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(RemtPayr0100BM.ATTR_ITEMAMNT01,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(RemtPayr0100BM.ATTR_ITEMAMNT02,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(RemtPayr0100BM.ATTR_ITEMAMNT03,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(RemtPayr0100BM.ATTR_ITEMAMNT04,"summary_color");
		remtPayr0100SummaryRow.setCellStyle(RemtPayr0100BM.ATTR_ITEMTOTAMNT,"summary_color");
		//  String htmlAttr = "<span style='background-color:yellow; background-repeat: no-repeat;'>합 계</span>" ;
		    
		remtPayr0100SummaryRow.setHtml(RemtPayr0100BM.ATTR_PAYITEMNM, "계");   
		    
		// with summary type and format  
		remtPayr0100SummaryRow.setSummaryType(RemtPayr0100BM.ATTR_ITEMAMNT01, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(RemtPayr0100BM.ATTR_ITEMAMNT01, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(RemtPayr0100BM.ATTR_ITEMAMNT02, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(RemtPayr0100BM.ATTR_ITEMAMNT02, NumberFormat.getFormat("#,##0;(#,##0)"));  
		  
		remtPayr0100SummaryRow.setSummaryType(RemtPayr0100BM.ATTR_ITEMAMNT03, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(RemtPayr0100BM.ATTR_ITEMAMNT03, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(RemtPayr0100BM.ATTR_ITEMAMNT04, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(RemtPayr0100BM.ATTR_ITEMAMNT04, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		remtPayr0100SummaryRow.setSummaryType(RemtPayr0100BM.ATTR_ITEMTOTAMNT, SummaryType.SUM);   
		remtPayr0100SummaryRow.setSummaryFormat(RemtPayr0100BM.ATTR_ITEMTOTAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
		      
		    // with renderer  
//		    averages.setSummaryType("change", SummaryType.AVG);  
//		    averages.setRenderer("change", new AggregationRenderer<Stock>() {  
//		      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {  
//		        // you can return html here  
//		        return number.format(value.doubleValue());  
//		      }  
//		    });  
		 remtPayr0100GridPanel.getGrid().getColumnModel().addAggregationRow(remtPayr0100SummaryRow);    
	       
	       
	     cp01.add(remtPayr0100GridPanel);  
		 
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
		// //급여내역
		cp01.addButton(new Button("퇴직금재산정", new SelectionListener<ButtonEvent>() { 
			@Override  
			public void componentSelected(ButtonEvent ce) {   
				MessageBox.confirm("급여내역 퇴직금재산정", "급여내역 퇴직금 재산정을 하시겠습니까?<br>(급여내역 변경에 따른 재계산)", new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
					//	if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	    	       
	    	        	   //if (isValid()) {
	    		      	   
	    	  	    	 // Iterator<Record> iterRecords = remtPayr0100GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
	    	                
							Iterator<BaseModel> itBm  = remtPayr0100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  
	    	  	          	List<Record>  lsRec  = new ArrayList<Record>();
	    	  	          
	    	  	          	while(itBm.hasNext()) {
	    	  	          		Record rec  = new Record(itBm.next()); 
	    	  	          		lsRec.add(rec);
	    	  	          	} 
	    	  	          	setListRecord(lsRec.iterator()); 
	    	  	          	Iterator<Record> iterRecords = getListRecord();
	    	  	          
	    	                List<Remt2200DTO> listRemt2200dto = new ArrayList<Remt2200DTO>();  
	    	              
	    	                while (iterRecords.hasNext()) {
	    	            
	    	                	Record recData = (Record) iterRecords.next(); 
	    	                	BaseModel bmMapModel = (BaseModel)recData.getModel();
	    	                    
	    	                	Remt2200DTO remt2200Dto = new Remt2200DTO(); 
	    	                 
	    	                	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
	    	                	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** column SYSTEMKEY : systemkey */
	    	                	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth"))); /** column 정산년월 : clutYrMnth */
	    	                	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));	/** column 급여항목코드 : payItemCd */
	    	                	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));	/** column 수당그룹코드 : extpyGrpCd */
	    	                	remt2200Dto.setSevePayDtlPatrNum(1L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm01")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt01"));	/** column 지급금액 : pymtSum */
	    	  				  
	    	                	listRemt2200dto.add(remt2200Dto);
	    	                  
	    	                 	remt2200Dto = new Remt2200DTO();
	    	                  
	    	                 	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
	    	                 	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	    	                 	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    	/** column 정산년월 : clutYrMnth */
	    	                 	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                 	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    	/** column 급여항목코드 : payItemCd */
	    	                 	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    	/** column 수당그룹코드 : extpyGrpCd */
	    	                 	remt2200Dto.setSevePayDtlPatrNum(2L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                 	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm02")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                 	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt02"));	/** column 지급금액 : pymtSum */
	    	  				  
	    	                 	listRemt2200dto.add(remt2200Dto);
	    	                  
	    	                 	remt2200Dto = new Remt2200DTO();
	    	                  
	    	                 	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** column 사업장코드 : dpobCd */
	    	                 	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
	    	                 	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));		/** column 정산년월 : clutYrMnth */
	    	                 	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                 	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    	/** column 급여항목코드 : payItemCd */
	    	                 	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    	/** column 수당그룹코드 : extpyGrpCd */
	    	                 	remt2200Dto.setSevePayDtlPatrNum(3L);	/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                 	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm03")));	/** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                 	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt03"));	/** column 지급금액 : pymtSum */
	    	  				  
	    	                 	listRemt2200dto.add(remt2200Dto);
	    	                  
	    	                 	remt2200Dto = new Remt2200DTO();
	    	                 	remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	    	                 	remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	    	                 	remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 정산년월 : clutYrMnth */
	    	                 	remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	    	                 	remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
	    	                 	remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    /** column 수당그룹코드 : extpyGrpCd */
	    	                 	remt2200Dto.setSevePayDtlPatrNum(4L);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	    	                 	remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("itemTm04")));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
	    	                 	remt2200Dto.setPymtSum((Long)bmMapModel.get("itemAmnt04"));    /** column 지급금액 : pymtSum */
	    	  				  
	    	                 	listRemt2200dto.add(remt2200Dto);
	    	                }   
	    	                
	    	           
	    	                remt0100Service.activityOnUpdateRemt0100ToPayrCalc(listRemt2200dto,  new AsyncCallback<Long>() {
	    	                   
	    	                	public void onFailure(Throwable caught) {
	    	                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    	                				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100ToPayrCalc(저장) : " + caught), null);
	    	                	}
	    	                	
	    	  	                public void onSuccess(Long result) { 
	    	  	                	
	    	  	                	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "퇴직금재정산이 완료되었습니다.", null);
	    	                            //remtPayr0100GridPanel.reload();
	    	  	                	tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
	    	  	                	tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
	    	                     	  
	    	  	                	reloadRemt2000();
	    	  	                }   
	    	                });  
						}  
					}
				});
			}   
		}));  
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
	
	

	// 후생복지비
	private LayoutContainer Data03() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(583, 287);

		remtWfep0100GridPanel = new MSFGridPanel(remtWfep0100Def, false, false, false, false);
		remtWfep0100GridPanel.setHeaderVisible(false);
		remtWfep0100GridPanel.setBodyBorder(true);
		remtWfep0100GridPanel.setBorders(true);
	   
	    
		GWTUtils.findColumnConfig(remtWfep0100GridPanel, Remt2000BM.ATTR_SEVEPAYPYMTSUM).setStyle("background-color:#F5F6CE;"); 
		       
		AggregationRowConfig<BaseModel> remtWfep0100SummaryRow = new AggregationRowConfig<BaseModel>();  
				 
		remtWfep0100SummaryRow.setCellStyle(Remt2000BM.ATTR_SEVEPAYPYMTSUM,"summary_color");
			   
			   //  String htmlAttr = "<span style='background-color:yellow; background-repeat: no-repeat;'>합 계</span>" ;
			    
		remtWfep0100SummaryRow.setHtml(RemtPayr0100BM.ATTR_PAYITEMNM, "계");   
		   
		// with summary type and format  
		remtWfep0100SummaryRow.setSummaryType(Remt2000BM.ATTR_SEVEPAYPYMTSUM, SummaryType.SUM);   
		remtWfep0100SummaryRow.setSummaryFormat(Remt2000BM.ATTR_SEVEPAYPYMTSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
			    
			  
			    // with renderer  
//			    averages.setSummaryType("change", SummaryType.AVG);  
//			    averages.setRenderer("change", new AggregationRenderer<Stock>() {  
//			      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {  
//			        // you can return html here  
//			        return number.format(value.doubleValue());  
//			      }  
//			    });  
		remtWfep0100GridPanel.getGrid().getColumnModel().addAggregationRow(remtWfep0100SummaryRow);    
		       
			     
		cp01.add(remtWfep0100GridPanel);  
 
		// 후생복지비
		cp01.addButton(new Button("퇴직금재산정", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {   
		    	
				MessageBox.confirm("후생복지비 퇴직금재산정", "후생복지비 퇴직금 재산정을 하시겠습니까?<br>(후생복지비 변경에 따른 재계산)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
					//	if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							//if (isValid()) { 
							// Iterator<Record> iterRecords = remtWfep0100GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
							Iterator<BaseModel> itBm  = remtWfep0100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
							List<Record>  lsRec  = new ArrayList<Record>();
		    			          
							while(itBm.hasNext()) {
								Record rec  = new Record(itBm.next()); 
								lsRec.add(rec);
							} 
							setListRecord(lsRec.iterator()); 
							Iterator<Record> iterRecords = getListRecord();
		    			           
							List<Remt2200DTO> listRemt2200dto = new ArrayList<Remt2200DTO>();  
		    		            
							while (iterRecords.hasNext()) {
		    		          
								Record recData = (Record) iterRecords.next(); 
								BaseModel bmMapModel = (BaseModel)recData.getModel();
		    		                  
								Remt2200DTO remt2200Dto = new Remt2200DTO(); 
		    		               
								remt2200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
		    		            remt2200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
		    		            remt2200Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 정산년월 : clutYrMnth */
		    		            remt2200Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
		    		            remt2200Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
		    		            remt2200Dto.setExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("extpyGrpCd")));    /** column 수당그룹코드 : extpyGrpCd */
		    		            remt2200Dto.setSevePayDtlPatrNum(0L);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
		    		            remt2200Dto.setSevePayCmpttnTm(MSFSharedUtils.allowNulls(bmMapModel.get("totLogSvcNumDys")));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
		    					remt2200Dto.setPymtSum((Long)bmMapModel.get("sevePayPymtSum"));    /** column 지급금액 : pymtSum */
		    						  
		    		            listRemt2200dto.add(remt2200Dto); 
							}   
		    		              
							remt0100Service.activityOnUpdateRemt0100ToPayrWfepCalc(listRemt2200dto, new AsyncCallback<Long>() {
								public void onFailure(Throwable caught) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100ToPayrCalc01(저장) : " + caught), null);
								}
								
								public void onSuccess(Long result) { 
		    		                	 // if (result == 0) {
		    		                     //     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
		    		                     //  } else {
									
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "퇴직금재정산이 완료되었습니다.", null);
		    		                          //remtWfep0100GridPanel.reload();
		    		                tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
		    		                tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
		    		                   	  
		    		                reloadRemt2000();
		    		                   	   
		    		                     //  } 
		    			                   // reloadPayrR0540();
		    			                   // actionDatabase = ActionDatabase.UPDATE;
								}
							});
						}
					}
				});
			}
		}));
		
		lcTabFormLayer.add(cp01);

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
		remt2000DefGridPanel.getTableDef().setTableColumnFilters(filters);
		 
		//정산년월
		remt2000DefGridPanel.getTableDef().addColumnFilter("clutYrMnth", (MSFSharedUtils.getSelectedComboValue(srhClutYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhClutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		        
		//정산구분
		remt2000DefGridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		         
		remt2000DefGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		remt2000DefGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
        remt2000DefGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
            
        String strTypOccuCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
        remt2000DefGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             
         //    String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
          //   remt2000DefGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
             
        String strDtilOccuInttnCd = RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
        remt2000DefGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	         
        remt2000DefGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			  
        remt2000DefGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
        remt2000DefGridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
        remt2000DefGridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			 
        remt2000DefGridPanel.reload();
	}
	  
	
	// 폼초기화 검색조건포함
	private void formInit() {
	       
		tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
		tabsRemtSub.setSelection(tabsRemtSub.getItem(0));
	      
	       systemkey.setValue("");        /**  column SYSTEMKEY : systemkey */
	       dpobCd.setValue("");           /**  column 사업장코드 : dpobCd      */  
	       calcSevePayPsnDivCd.reset();   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */ 
	       clutYrMnth.setValue("");   /** column 정산년월 : clutYrMnth */ 
	       clutYr.reset();   /** column 정산년 : clutYr */ 
	       clutMnth.reset();   /** column 정산월 : clutMnth */ 
	       nm.setValue("");   /** column 성명 : nm */
	       resnRegnNum.setValue("");    
	       deptNm.setValue("");     /** column 부서 : deptNm    */ 
	       emymtDivNm.setValue("");   /** column 고용구분 : emymtDivNm */ 
	       typOccuNm.setValue("");   /** column 직종 : typOccuNm */ 
	      // pyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */ 
	       logSvcYrNumCd.setValue("");   /** column 근속년수코드 : logSvcYrNumCd */ 
	       logSvcMnthIcmCd.setValue("");   /** column 근속월수코드 : logSvcMnthIcmCd */ 
	       icncDt.reset();   /** column 입사일자 : icncDt */ 
	       rkfcdDt.reset();   /** column 기산일자 : rkfcdDt */ 
	       retryDt.reset();   /** column 퇴직일자 : retryDt */
	       logSvcYrNum.setValue(0);   /** column 근속년수 : logSvcYrNum */
	       logSvcMnthIcm.setValue(0);   /** column 근속월수 : logSvcMnthIcm */
	     //  amcrrLogSvcYrNum.setValue(0);   /** column 군경력근속년수 : amcrrLogSvcYrNum */
	     //  amcrrLogSvcMnthIcm.setValue(0);   /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
	       eepnMnthIcm2012Bfr.setValue(0);   /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
	       eepnMnthIcm2013Aft.setValue(0);   /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
	       addMnthIcm2012Bfr.setValue(0);   /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
	       addMnthIcm2013Aft.setValue(0);   /** column 가산월수_2013이후 : addMnthIcm2013Aft */
	       eepnDayIcmDys.setValue(0);   /** column 제외일수 : eepnDayIcmDys */
	       logSvcNumDys.setValue(0);   /** column 근속일수 : logSvcNumDys */
	       turtyDutyYrNum.setValue(0);   /** column 실근무년수 : turtyDutyYrNum */
     	   turtyDutyMnthNum.setValue(0);   /** column 실근무개월수 : turtyDutyMnthNum */
    	   turtyDutyNumDys.setValue(0);   /** column 실근무일수 : turtyDutyNumDys */
	       amcrrLogSvcNumDys.setValue(0);   /** column 군경력근무일수 : amcrrLogSvcNumDys */
	       payCmpttnBgnnDt.reset();   /** column 급여산정시작일자 : payCmpttnBgnnDt */
	       payCmpttnEndDt.reset();   /** column 급여산정종료일자 : payCmpttnEndDt */
	      // fndtnPayAggrSumSum.setValue(0);   /** column 기본급여합계금액 : fndtnPayAggrSumSum */
	     //  snryAllwAggrSum.setValue(0);   /** column 제수당합계금액 : snryAllwAggrSum */
	      // welfWelfSpdgAggrSum.setValue(0);   /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
	       marPubcWelfAmnt.setValue(0);   /** column 3월간후생복지비 : marPubcWelfAmnt */
	       marTotAmntWag.setValue(0);   /** column 3월간총임금액 : marTotAmntWag */
	       dayAvgAmntWag.setValue(0);   /** column 1일평균임금액 : dayAvgAmntWag */
	       sevePayCmpttnSum.setValue(0);   /** column 퇴직금산정금액 : sevePayCmpttnSum */
	     //  sevePayAddYn.setValue(false);;   /** column 퇴직금가산포함여부 : sevePayAddYn */
	      // sevePayAddSum.setValue(0);   /** column 퇴직금가산금액 : sevePayAddSum */
	       sevePayAddRate.setValue(0);   /** column 퇴직금가산율 : sevePayAddRate */
	       seveViewPayAddRate.setValue(0);
	       sevePayAddApptnSum.setValue(0);   /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
	       amcrrClutInsnYn.setValue(false);   /** column 군경력정산포함여부 : amcrrClutInsnYn */
	       amcrrAddApptnSum.setValue(0);   /** column 군경력가산적용금액 : amcrrAddApptnSum */
	       totLogSvcNumDys.setValue(0);   /** column 총근무일수 : totLogSvcNumDys */
	       sevePayPymtSum.setValue(0);   /** column 퇴직금지급액 : sevePayPymtSum */
	      // sevePayCmpttnFreeDtySum.setValue(0);   /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
	       //sevePayCmpttnTxtnSum.setValue(0);   /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
	      // sevePayPymtDducSum.setValue(0);   /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
		   sevePayTurtyPymtSum.setValue(0);   /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
		  // sevePayNoteCtnt.setValue("");   /** column 퇴직금비고내용 : sevePayNoteCtnt */
		   sevePayPymtDt.reset();   /** column 퇴직금지급일자 : sevePayPymtDt */
		  // sevePayPymtYn.setValue(false);   /** column 퇴직금지급여부 : sevePayPymtYn */
		 //  ddlneYn.setValue(false );   /** column 마감여부 : ddlneYn */
		 //  ddlneDt.reset();   /** column 마감일 : ddlneDt */
		   clutLogSvcMnthIcm.setValue(0);   /** column 정산_근속월수 : clutLogSvcMnthIcm */
		   clutLogSvcYrNum.setValue(0);   /** column 정산_근속연수 : clutLogSvcYrNum */
		   logPpnl12befLogMnthIcm.setValue(0);   /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
		   logPpnl12befLogYrNum.setValue(0);   /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
		   logPpnl13afrLogMnthIcm.setValue(0);   /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
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
	       
	       
		remtPayr0100GridPanel.getMsfGrid().clearData();
		remtWfep0100GridPanel.getMsfGrid().clearData();
		remtPymt2000GridPanel.getMsfGrid().clearData();
		remt2300GridPanel.getMsfGrid().clearData();
		remt3100GridPanel.getMsfGrid().clearData();

	}
	   
	// 산정결과
	private void reloadRemt2000() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
         
		Remt2000DTO remt2000Dto = new Remt2000DTO(); 
	      	 
	    remt2000Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));		/**  column 사업장코드 : dpobCd */
	    remt2000Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));	/**  column SYSTEMKEY : systemkey */ 
 		  
	    remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	    remt2000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */	  
	      	    
	    remt0100Service.activityOnReadRemt0100(remt2000Dto, new AsyncCallback<Remt2000DTO>() {
	    	@Override
	    	public void onFailure(Throwable caught) {
	    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0100" + caught), null);
	     	}
	    	
	    	@Override
	    	public void onSuccess(Remt2000DTO result) {
	    		
	    		//리턴 결과 
	            //dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
				//systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
				calcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getCalcSevePayPsnDivCd())));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				clutYrMnth.setValue(result.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				clutYr.setValue(lsCrClutYrStore.findModel("year",MSFSharedUtils.allowNulls(result.getClutYr() )));    /** column 정산년월 : clutYrMnth */
				clutMnth.setValue(lsCrClutMnth.findModel("month",MSFSharedUtils.allowNulls(result.getClutMnth() )));    /** column 정산년월 : clutYrMnth */
				//emymtDivCd.setValue(result.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
				emymtDivNm.setValue(result.getEmymtDivNm());    /** column 고용구분 : emymtDivNm */
				//deptCd.setValue(result.getDeptCd());    /** column 부서코드 : deptCd */
				deptNm.setValue(result.getDeptNm());    /** column 부서 : deptNm */
				//typOccuCd.setValue(result.getTypOccuCd());    /** column 직종코드 : typOccuCd */
				typOccuNm.setValue(result.getTypOccuNm());    /** column 직종 : typOccuNm */
				//pyspGrdeCd.setValue(result.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
				//pyspGrdeNm.setValue(result.getPyspGrdeNm());    /** column 호봉등급 : pyspGrdeNm */
				//dtilOccuInttnCd.setValue(result.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
				//dtilOccuClsDivNm.setValue(result.getDtilOccuClsDivNm());    /** column 직종세구분 : dtilOccuClsDivNm */
				//businNm.setValue(result.getBusinNm());    /** column 사업코드 : businCd */
					 
				//inbyCd.setValue(result.getInbyCd());    /** column 직위코드 : inbyCd */
				//pyspCd.setValue(result.getPyspCd());    /** column 호봉코드 : pyspCd */
				logSvcYrNumCd.setValue(result.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
				logSvcMnthIcmCd.setValue(result.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
				nm.setValue(result.getNm());    /** column 성명 : nm */
				resnRegnNum.setValue(result.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
				icncDt.setValue(GWTUtils.getDateFromString(result.getIcncDt(), "yyyyMMdd"));    /** column 입사일자 : icncDt */
				rkfcdDt.setValue(GWTUtils.getDateFromString(result.getRkfcdDt(), "yyyyMMdd"));    /** column 기산일자 : rkfcdDt */
				retryDt.setValue(GWTUtils.getDateFromString(result.getRetryDt(), "yyyyMMdd"));    /** column 퇴직일자 : retryDt */
				logSvcYrNum.setValue(result.getLogSvcYrNum());    /** column 근속년수 : logSvcYrNum */
				logSvcMnthIcm.setValue(result.getLogSvcMnthIcm());    /** column 근속월수 : logSvcMnthIcm */
				//	amcrrLogSvcYrNum.setValue(result.getAmcrrLogSvcYrNum());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
				//	amcrrLogSvcMnthIcm.setValue(result.getAmcrrLogSvcMnthIcm());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
				eepnMnthIcm2012Bfr.setValue(result.getEepnMnthIcm2012Bfr());    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
				eepnMnthIcm2013Aft.setValue(result.getEepnMnthIcm2013Aft());    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
				addMnthIcm2012Bfr.setValue(result.getAddMnthIcm2012Bfr());    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
				addMnthIcm2013Aft.setValue(result.getAddMnthIcm2013Aft());    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
				eepnDayIcmDys.setValue(result.getEepnDayIcmDys());    /** column 제외일수 : eepnDayIcmDys */
				logSvcNumDys.setValue(result.getLogSvcNumDys());    /** column 근속일수 : logSvcNumDys */
				turtyDutyYrNum.setValue(result.getTurtyDutyYrNum());    /** column 실근무년수 : turtyDutyYrNum */
				turtyDutyMnthNum.setValue(result.getTurtyDutyMnthNum());    /** column 실근무개월수 : turtyDutyMnthNum */
				turtyDutyNumDys.setValue(result.getTurtyDutyNumDys());    /** column 실근무일수 : turtyDutyNumDys */
				amcrrLogSvcNumDys.setValue(result.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */ 
				payCmpttnBgnnDt.setValue(GWTUtils.getDateFromString(result.getPayCmpttnBgnnDt(), "yyyyMMdd"));    /** column 급여산정시작일자 : payCmpttnBgnnDt */
				payCmpttnEndDt.setValue(GWTUtils.getDateFromString(result.getPayCmpttnEndDt(), "yyyyMMdd"));    /** column 급여산정종료일자 : payCmpttnEndDt */
					//	fndtnPayAggrSumSum.setValue(result.getFndtnPayAggrSumSum());    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
					//	snryAllwAggrSum.setValue(result.getSnryAllwAggrSum());    /** column 제수당합계금액 : snryAllwAggrSum */
					//	welfWelfSpdgAggrSum.setValue(result.getWelfWelfSpdgAggrSum());    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
				marPubcWelfAmnt.setValue(result.getMarPubcWelfAmnt());    /** column 3월간후생복지비 : marPubcWelfAmnt */
				marTotAmntWag.setValue(result.getMarTotAmntWag());    /** column 3월간총임금액 : marTotAmntWag */
				dayAvgAmntWag.setValue(result.getDayAvgAmntWag());    /** column 1일평균임금액 : dayAvgAmntWag */
				sevePayCmpttnSum.setValue(result.getSevePayCmpttnSum());    /** column 퇴직금산정금액 : sevePayCmpttnSum */
					//sevePayAddSum.setValue(result.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
				sevePayAddRate.setValue(result.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
				seveViewPayAddRate.setValue(result.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
				sevePayAddApptnSum.setValue(result.getSevePayAddApptnSum());    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
				amcrrClutInsnYn.setValue( result.getAmcrrClutInsnYn());    /** column 군경력정산포함여부 : amcrrClutInsnYn */
				amcrrAddApptnSum.setValue(result.getAmcrrAddApptnSum());    /** column 군경력가산적용금액 : amcrrAddApptnSum */
				totLogSvcNumDys.setValue(result.getTotLogSvcNumDys());    /** column 총근무일수 : totLogSvcNumDys */
				sevePayPymtSum.setValue(result.getSevePayPymtSum());    /** column 퇴직금지급액 : sevePayPymtSum */
				//sevePayCmpttnFreeDtySum.setValue(result.getSevePayCmpttnFreeDtySum());    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
				//sevePayCmpttnTxtnSum.setValue(result.getSevePayCmpttnTxtnSum());    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
				//sevePayPymtDducSum.setValue(result.getSevePayPymtDducSum());    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
				sevePayTurtyPymtSum.setValue(result.getSevePayTurtyPymtSum());    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
				//sevePayNoteCtnt.setValue(result.getSevePayNoteCtnt());    /** column 퇴직금비고내용 : sevePayNoteCtnt */
				sevePayPymtDt.setValue(GWTUtils.getDateFromString(result.getSevePayPymtDt(), "yyyyMMdd"));    /** column 퇴직금지급일자 : sevePayPymtDt */
				//sevePayPymtYn.setValue( result.getSevePayPymtYn());    /** column 퇴직금지급여부 : sevePayPymtYn */
				//ddlneYn.setValue( result.getDdlneYn());    /** column 마감여부 : ddlneYn */
				//ddlneDt.setValue(GWTUtils.getDateFromString(result.getDdlneDt(), "yyyyMMdd"));    /** column 마감일시 : ddlneDt */
	    	}
	    });
	}
	   
	   
	// 급여지급기간 셋팅하는 부분
	private void reloadPayrRemt0100Header() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		Remt2100DTO remt2100Dto = new Remt2100DTO();
	      	 
	    remt2100Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));		/**  column 사업장코드 : dpobCd */
	    remt2100Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));	/**  column SYSTEMKEY : systemkey */ 
 		  
	    remt2100Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	    remt2100Dto.setClutYrMnth(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */	  
	      	    
	    remt0100Service.activityOnPayrRemt0100Header(remt2100Dto, new AsyncCallback<List<RemtDays0100DTO>>() {
	    	@Override 
	    	public void onSuccess(List<RemtDays0100DTO> result) { 
	    		//리턴 결과 
	    		if (MSFSharedUtils.paramNotNull(result)) {
	    			
	    			for (int iCnt =0;iCnt < result.size();iCnt++) {

	    				RemtDays0100DTO remtDays0100Dto = new RemtDays0100DTO();
	    				remtDays0100Dto = (RemtDays0100DTO) result.get(iCnt);
		                		  
		                 // remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("", 2, 1));
	                	remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig( MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt01()).concat("<br>" 
	                			+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt01()))  , 1, 2));
	                	remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 3, new HeaderGroupConfig(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt02()).concat("<br>" 
	                			+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt02())), 1, 2));
	                	remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 5, new HeaderGroupConfig(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt03()).concat("<br>" 
	                			+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt03())), 1, 2));
	                	remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 7, new HeaderGroupConfig(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemStDt04()).concat("<br>" 
	                			+ MSFSharedUtils.allowNulls(remtDays0100Dto.getItemEdDt04())), 1, 2));
	                	remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("계", 2, 1));
	                				
		                		   
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_PAYITEMNM).setHeaderText("급여지급기간"); 
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM01).setHeaderText("");     /** set item_tm01 : itemTm01 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT01).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays01()));   /** set item_amnt01 : itemAmnt01 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM02).setHeaderText("");     /** set item_tm02 : itemTm02 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT02).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays02()));   /** set item_amnt02 : itemAmnt02 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM03).setHeaderText("");     /** set item_tm03 : itemTm03 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT03).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays03()));   /** set item_amnt03 : itemAmnt03 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM04).setHeaderText("");     /** set item_tm04 : itemTm04 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT04).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemDays04()));   /** set item_amnt04 : itemAmnt04 */
	                	GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTOTAMNT).setHeaderText(MSFSharedUtils.allowNulls(remtDays0100Dto.getItemTotDays()));  /** set 퇴직금 급여합계 :  itemTotAmnt */
	                	       
	                			
//	                		   BaseModel bmData = new BaseModel();
//	                		   bmData = (BaseModel)result.get(iCnt);
//	                		  
//	                		   // remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("", 2, 1));
//                		       remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig( MSFSharedUtils.allowNulls(bmData.get("itemTm01Stdt")).concat("<br>" 
//                		                                                                  + MSFSharedUtils.allowNulls(bmData.get("itemTm01Eddt")))  , 1, 2));
//                		       remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 3, new HeaderGroupConfig(MSFSharedUtils.allowNulls(bmData.get("itemTm02Stdt")).concat("<br>" 
//                                       + MSFSharedUtils.allowNulls(bmData.get("itemTm02Eddt"))), 1, 2));
//                		       remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 5, new HeaderGroupConfig(MSFSharedUtils.allowNulls(bmData.get("itemTm03Stdt")).concat("<br>" 
//                                       + MSFSharedUtils.allowNulls(bmData.get("itemTm03Eddt"))), 1, 2));
//                		       remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 7, new HeaderGroupConfig(MSFSharedUtils.allowNulls(bmData.get("itemTm04Stdt")).concat("<br>" 
//                                       + MSFSharedUtils.allowNulls(bmData.get("itemTm04Eddt"))), 1, 2));
//                		       remtPayr0100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("계", 2, 1));
//                				
//	                		   
//                		 	   GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_PAYITEMNM).setHeader("급여지급기간"); 
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM01).setHeader("");     /** set item_tm01 : itemTm01 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT01).setHeader(MSFSharedUtils.allowNulls(bmData.get("itemAmnt01")));   /** set item_amnt01 : itemAmnt01 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM02).setHeader("");     /** set item_tm02 : itemTm02 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT02).setHeader(MSFSharedUtils.allowNulls(bmData.get("itemAmnt02")));   /** set item_amnt02 : itemAmnt02 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM03).setHeader("");     /** set item_tm03 : itemTm03 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT03).setHeader(MSFSharedUtils.allowNulls(bmData.get("itemAmnt03")));   /** set item_amnt03 : itemAmnt03 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTM04).setHeader("");     /** set item_tm04 : itemTm04 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMAMNT04).setHeader(MSFSharedUtils.allowNulls(bmData.get("itemAmnt04")));   /** set item_amnt04 : itemAmnt04 */
//                		       GWTUtils.findColumnConfig(remtPayr0100GridPanel, RemtPayr0100BM.ATTR_ITEMTOTAMNT).setHeader(MSFSharedUtils.allowNulls(bmData.get("totPymtNumDys")));  /** set 퇴직금 급여합계 :  itemTotAmnt */
	                			
	    				} 
	    			
	    			//급여내역
	    			reloadRemt210001();
	    		} else {
	                		
	    		}
	    	}
	    	
	    	@Override
	    	public void onFailure(Throwable caught) {
	    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0100 : " + caught), null);
	    	}
	    });	   
	}

	// 급여내역
	private void reloadRemt210001() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		remtPayr0100GridPanel.getTableDef().setTableColumnFilters(filters);
			
		remtPayr0100GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remtPayr0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtPayr0100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtPayr0100GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		    
		remtPayr0100GridPanel.reload();  
		boolPymtDduc = true;
	   }
	
	
	// 후생복지비
	private void reloadRemt210002() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		remtWfep0100GridPanel.getTableDef().setTableColumnFilters(filters);
			
		remtWfep0100GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remtWfep0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtWfep0100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtWfep0100GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		    
		remtWfep0100GridPanel.reload();

		// boolPymtDduc = true;
	}
		
	    
	      
	/**
	 * 퇴직정산 누른경우에 데이터를 리로딩한다. 소득세계산 탭을 누르면 /세액계산 탭의 정보 까지 같이 가지고 온다.
	 */
	private void reloadDataRemtPymt() {
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		remtPymt2000GridPanel.getTableDef().setTableColumnFilters(filters);
			
		remtPymt2000GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remtPymt2000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtPymt2000GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		remtPymt2000GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		    
		remtPymt2000GridPanel.reload();

		reloadDataRemtTax();

	}
	   
	/**
	 * 퇴직금공제내역
	 */
	private void reloadDataRemtTax() {
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		IColumnFilter filters = null;
		remt2300GridPanel.getTableDef().setTableColumnFilters(filters);
			
		remt2300GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remt2300GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remt2300GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		remt2300GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		    
		remt2300GridPanel.reload();
	}
	   
	/**
	 * 세액계산
	 */
	private void reloadDataRemtCalcTax() {
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		   
		Remt3100DTO remt3100Dto = new Remt3100DTO(); 
	      	 
	    remt3100Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));         /**  column 사업장코드 : dpobCd */
	    remt3100Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));        /**  column SYSTEMKEY : systemkey */ 
 		  
	    remt3100Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	    remt3100Dto.setClutYrMnth(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */	  
	      	    
	    remt0100Service.activityOnReadRemt0100ToRemt3100(remt3100Dto, new AsyncCallback<Remt3100DTO>() {
	    			 
	    	public void onFailure(Throwable caught) {
	    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
	    			, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0100ToRemt3100"+ caught), null);
	    	}
	    	
	    	public void onSuccess(Remt3100DTO result) { 
	    		//리턴 결과 

//						dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
//						calcSevePsnBlggYrMnth.setValue(result.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//						calcSevePayPsnDivCd.setValue(result.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//						systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
//						deptCd.setValue(result.getDeptCd());    /** column 부서코드 : deptCd */
//						hanNm.setValue(result.getHanNm());    /** column 한글성명 : hanNm */
//						resnRegnNum.setValue(result.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//						aimenrEcteYn.setValue(result.getAimenrEcteYn());    /** column 소득자임원여부 : aimenrEcteYn */
//						fixPayJnDt.setValue(result.getFixPayJnDt());    /** column 확정급여형가입일자 : fixPayJnDt */
//						sevePay20111231Sum.setValue(result.getSevePay20111231Sum());    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
//						frgnrDivCd.setValue(result.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
//						ridnSeptYn.setValue(result.getRidnSeptYn());    /** column 거주구분여부 : ridnSeptYn */
//						ridnCd.setValue(result.getRidnCd());    /** column 거주지국코드 : ridnCd */
//						ridnNm.setValue(result.getRidnNm());    /** column 거주지국명 : ridnNm */
//						blggYrBgnnDt.setValue(result.getBlggYrBgnnDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
//						blggYrEndDt.setValue(result.getBlggYrEndDt());    /** column 귀속년도종료일자 : blggYrEndDt */
//						retryReasCd.setValue(result.getRetryReasCd());    /** column 퇴직사유코드 : retryReasCd */
//						ctrBusoprRgstnNum.setValue(result.getCtrBusoprRgstnNum());    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
//						ctrPaeWorkNm.setValue(result.getCtrPaeWorkNm());    /** column 중_근무처명 : ctrPaeWorkNm */
//						ctrRetryPayQnty.setValue(result.getCtrRetryPayQnty());    /** column 중_퇴직급여액 : ctrRetryPayQnty */
//						ctrFreeDtyRetryPayQnty.setValue(result.getCtrFreeDtyRetryPayQnty());    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
//						ctrTxtnTgtRetryPayQnty.setValue(result.getCtrTxtnTgtRetryPayQnty());    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
//						endBusoprRgstnNum.setValue(result.getEndBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
//						endPaeWorkNm.setValue(result.getEndPaeWorkNm());    /** column 종_근무처명 : endPaeWorkNm */
//						endRetryPayQnty.setValue(result.getEndRetryPayQnty());    /** column 종_퇴직급여액 : endRetryPayQnty */
//						endFreeDtyRetryPayQnty.setValue(result.getEndFreeDtyRetryPayQnty());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
//						endTxtnTgtRetryPayQnty.setValue(result.getEndTxtnTgtRetryPayQnty());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
//						clutRetryPayQnty.setValue(result.getClutRetryPayQnty());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
//						clutFreeDtyRetryPayQnty.setValue(result.getClutFreeDtyRetryPayQnty());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
//						clutTxtnTgtRetryPayQnty.setValue(result.getClutTxtnTgtRetryPayQnty());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
//						ctrIcncDt.setValue(result.getCtrIcncDt());    /** column 중_입사일자 : ctrIcncDt */
//						ctrRkfcdDt.setValue(result.getCtrRkfcdDt());    /** column 중_기산일자 : ctrRkfcdDt */
//						ctrRsgtnDt.setValue(result.getCtrRsgtnDt());    /** column 중_퇴사일자 : ctrRsgtnDt */
//						ctrPymtDt.setValue(result.getCtrPymtDt());    /** column 중_지급일자 : ctrPymtDt */
//						ctrLogSvcMnthIcm.setValue(result.getCtrLogSvcMnthIcm());    /** column 중_근속월수 : ctrLogSvcMnthIcm */
//						ctrEepnMnth12Bfr.setValue(result.getCtrEepnMnth12Bfr());    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
//						ctrEepnMnth13Aft.setValue(result.getCtrEepnMnth13Aft());    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
//						ctrAddMnth12Bfr.setValue(result.getCtrAddMnth12Bfr());    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
//						ctrAddMnth13Aft.setValue(result.getCtrAddMnth13Aft());    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
//						ctrEepnMnthIcm.setValue(result.getCtrEepnMnthIcm());    /** column 중_제외월수 : ctrEepnMnthIcm */
//						ctrAddMnthIcm.setValue(result.getCtrAddMnthIcm());    /** column 중_가산월수 : ctrAddMnthIcm */
//						ctrDupMnthIcm.setValue(result.getCtrDupMnthIcm());    /** column 중_중복월수 : ctrDupMnthIcm */
//						ctrLogSvc.setValue(result.getCtrLogSvc());    /** column 중_근속연수 : ctrLogSvc */
//						endIcncDt.setValue(result.getEndIcncDt());    /** column 종_입사일자 : endIcncDt */
//						endRkfcdDt.setValue(result.getEndRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
//						endRsgtnDt.setValue(result.getEndRsgtnDt());    /** column 종_퇴사일자 : endRsgtnDt */
//						endPymtDt.setValue(result.getEndPymtDt());    /** column 종_지급일자 : endPymtDt */
//						endLogSvcMnthIcm.setValue(result.getEndLogSvcMnthIcm());    /** column 종_근속월수 : endLogSvcMnthIcm */
//						endEepnMnth12Bfr.setValue(result.getEndEepnMnth12Bfr());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
//						endEepnMnth13Aft.setValue(result.getEndEepnMnth13Aft());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
//						endAddMnth12Bfr.setValue(result.getEndAddMnth12Bfr());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
//						endAddMnth13Aft.setValue(result.getEndAddMnth13Aft());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
//						endEepnMnthIcm.setValue(result.getEndEepnMnthIcm());    /** column 종_제외월수 : endEepnMnthIcm */
//						endAddMnthIcm.setValue(result.getEndAddMnthIcm());    /** column 종_가산월수 : endAddMnthIcm */
//						endDupMnthIcm.setValue(result.getEndDupMnthIcm());    /** column 종_중복월수 : endDupMnthIcm */
//						endLogSvcYrNum.setValue(result.getEndLogSvcYrNum());    /** column 종_근속연수 : endLogSvcYrNum */
//						clutIcncDt.setValue(result.getClutIcncDt());    /** column 정산_입사일자 : clutIcncDt */
//						clutRkfcdDt.setValue(result.getClutRkfcdDt());    /** column 정산-기산일자 : clutRkfcdDt */
//						clutRsgtnDt.setValue(result.getClutRsgtnDt());    /** column 정산_퇴사일자 : clutRsgtnDt */
//						clutPymtDt.setValue(result.getClutPymtDt());    /** column 정산_지급일자 : clutPymtDt */
						clutLogSvcMnthIcm.setValue(result.getClutLogSvcMnthIcm());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
//						clutEepnMnthIcm.setValue(result.getClutEepnMnthIcm());    /** column 정산_제외월수 : clutEepnMnthIcm */
//						clutAddMnthIcm.setValue(result.getClutAddMnthIcm());    /** column 정산_가산월수 : clutAddMnthIcm */
//						clutDupMnthIcm.setValue(result.getClutDupMnthIcm());    /** column 정산_중복월수 : clutDupMnthIcm */
						clutLogSvcYrNum.setValue(result.getClutLogSvcYrNum());    /** column 정산_근속연수 : clutLogSvcYrNum */
//						logPpnl12befIcncDt.setValue(result.getLogPpnl12befIcncDt());    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
//						logPpnl12befRkfcdDt.setValue(result.getLogPpnl12befRkfcdDt());    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
//						logPpnl12befRsgtnDt.setValue(result.getLogPpnl12befRsgtnDt());    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
//						logPpnl12befPymtDt.setValue(result.getLogPpnl12befPymtDt());    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
						logPpnl12befLogMnthIcm.setValue(result.getLogPpnl12befLogMnthIcm());    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
//						logPpnl12befEepnMnthIcm.setValue(result.getLogPpnl12befEepnMnthIcm());    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
//						logPpnl12befAddMnthIcm.setValue(result.getLogPpnl12befAddMnthIcm());    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
//						logPpnl12befDupMnthIcm.setValue(result.getLogPpnl12befDupMnthIcm());    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
						logPpnl12befLogYrNum.setValue(result.getLogPpnl12befLogYrNum());    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
//						logPpnl13afrIcncDt.setValue(result.getLogPpnl13afrIcncDt());    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
//						logPpnl13afrRkfcdDt.setValue(result.getLogPpnl13afrRkfcdDt());    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
//						logPpnl13afrRsgtnDt.setValue(result.getLogPpnl13afrRsgtnDt());    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
//						logPpnl13afrPymtDt.setValue(result.getLogPpnl13afrPymtDt());    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
						logPpnl13afrLogMnthIcm.setValue(result.getLogPpnl13afrLogMnthIcm());    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
//						logPpnl13afrEepnMnthIcm.setValue(result.getLogPpnl13afrEepnMnthIcm());    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
//						logPpnl13afrAddMnthIcm.setValue(result.getLogPpnl13afrAddMnthIcm());    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
//						logPpnl13afrDupMnthIcm.setValue(result.getLogPpnl13afrDupMnthIcm());    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
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
//						talRegrstTgtTxAmnt.setValue(result.getTalRegrstTgtTxAmnt());    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//						talAccuDepitAggrSum.setValue(result.getTalAccuDepitAggrSum());    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//						talRetryPayQnty.setValue(result.getTalRetryPayQnty());    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
//						talRetryIncmTxAmnt.setValue(result.getTalRetryIncmTxAmnt());    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
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
	   
	   
	// 중간정산내역검색
	private void reloadRemtDetail() {
		
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		remt3100GridPanel.getTableDef().setTableColumnFilters(filters);
			
		remt3100GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		remt3100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		remt3100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		remt3100GridPanel.getTableDef().addColumnFilter("clutYrMnth", MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		    
		remt3100GridPanel.reload();
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

	public Iterator<Record> getListRecord() {
		return this.records;
	}

	private Remt0100 getThis() {
		return this;
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
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();
		// //우편번호

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
	
	
	private void fnPopupRemt1000() {

		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom1000 = PrgmComPopupUtils.lovPopUpPrgmComRemt1000Form(); // 인사
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();
		// //우편번호

		final FormBinding popBindingCom1000 = popCom1000.getFormBinding();

		popBindingCom1000.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {

				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();

				if (mapModels != null) {

					if (MSFSharedUtils.paramNull(mapModels)) {
         	            return;
         	        } else {
         	        	
						String pymtYrMnth = MSFSharedUtils.getSelectedComboValue(srhClutYr, "year") 
								+ MSFSharedUtils.getSelectedComboValue(srhClutMnth, "month");
						if (MSFSharedUtils.paramNull(pymtYrMnth)) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산년월을 선택하셔야 합니다.", null);
							return;
						}
						if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"))) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
							return;
						}
         	        	 
             	     	//정산구분
         	        	//추가정보보내기 
         	            Remt2000DTO remt2000Dto = new Remt2000DTO(); 
         	            
         	            remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
         	            remt2000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(pymtYrMnth));    /** column 정산년월 : clutYrMnth */
         	            
	           	 		remt0100Service.activityOnInsertRemt0100(mapModels ,remt2000Dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
	           	 			public void onFailure(Throwable caught) {
	           	        	
	           	 				List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	           	 				ShowMessageBM smBm = new ShowMessageBM();
	           	 				smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
	           	 				smBm.setMenu("Remt");
	           	 				smBm.setPhase("[퇴직정산]퇴직대상자에러");
	           	 				smBm.setMessage(caught.getLocalizedMessage());
	           	 				smBm.setContent(caught.getMessage());
	           	 				bmResult.add(smBm);  
	           	 				
	           	 				PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
                	   
	           	 				ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
		    			    
	           	 				MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	           	 				msFwMessage.show();
	           	 				showMessageForm.setMSFFormWindows(msFwMessage);
	    		       
//	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertRemt0100(insert) : " + caught), null);
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
         	        }  
				}   
            }
        });
	}
	
	
	
	private void fnPopupCommP500() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		PrgmComP0500DTO sysComP0500Dto = new PrgmComP0500DTO();
		sysComP0500Dto.setPymtDducDivCd(PayGenConst.PYMT_DDUC_DIV_CD_03);
		
		// 지급공제구분코드 넘김.
		MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpPrgmCom0500Form(sysComP0500Dto); // 공제

		final FormBinding popBindingCom0500 = popCom0500.getFormBinding();

		popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {

				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();

				if (mapModels != null) {

					if (mapModels.size() > 1) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"한건의 데이타만 선택가능합니다. 데이타를 확인하십시요.", null);
						return;
					}
                      
					remt2300GridPanel.getMsfGrid().clearData();
                      
					BaseModel bmData = remt2300GridPanel.getTableDef().getDefaultValues(); 
                 
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
					
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
                            
						bmData.set("dpobCd",MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
						bmData.set("calcSevePayPsnDivCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						bmData.set("clutYrMnth",MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(clutYr,"year").concat(MSFSharedUtils.getSelectedComboValue(clutMnth,"month"))));    /** column 정산년월 : clutYrMnth */
						bmData.set("systemkey",MSFSharedUtils.allowNulls(systemkey.getValue()));			/** column SYSTEMKEY : systemkey */
						bmData.set("payItemCd",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd"))); 	/** column 급여항목코드 : payItemCd */ 
	                    bmData.set("payItemNm",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));	/** column 급여항목 : payItemNm */ 
						bmData.set("pymtDducDivCd",MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));	/** column 지급공제구분코드 : pymtDducDivCd */
						bmData.set("pymtSum",0L);    /** column 지급금액 : pymtSum */
					}   
                     
					remt2300GridPanel.getMsfGrid().getGrid().stopEditing();      
                    remt2300GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
                    remt2300GridPanel.getMsfGrid().getGrid().startEditing(remt2300GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 2);   
                     // remt2300GridPanel.getMsfGrid().getGrid().getStore().getAt(0).set("mnthPayAdmntAssoBssCtnt"," ");
                     // remt2300GridPanel.getMsfGrid().getGrid().getStore().update(Remt2300GridPanel.getMsfGrid().getGrid().getStore().getAt(0));
                    remt2300GridPanel.getMsfGrid().getGrid().getStore().getRecord(remt2300GridPanel.getMsfGrid().getGrid().getStore().getAt(0)).setDirty(true);
                      
                    actionDatabase = ActionDatabase.INSERT; 
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
	 * 급여산정 로직 멀티건에 대해 가능하도록 처리
	 */
	private void fnPayrCalc() {
   	  
   	  
		MessageBox.confirm("퇴직금 산정", "현재 대상자 퇴직금산정 내역을 초기화 하고 <br> 급여내역에 따른 퇴직금산정을 다시 하시겠습니까?<br>([주의] 기 작성된 퇴직금 산정 결과가 초기화 되니 주의!!!)",new Listener<MessageBoxEvent>(){
			@Override
   	      	public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
   	       
					Iterator<BaseModel> itBm  = remt2000DefGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
					List<Record>  lsRec  = new ArrayList<Record>();
				          
					while(itBm.hasNext()) {
						Record rec  = new Record(itBm.next()); 
						lsRec.add(rec);
					} 
					setListRecord(lsRec.iterator()); 
      
	                   // setListRecord(remt2000DefGridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());      	        	
	  
					String pymtYrMnth =  MSFSharedUtils.getSelectedComboValue(clutYr,"year") + MSFSharedUtils.getSelectedComboValue(clutMnth,"month");
					if (MSFSharedUtils.paramNull(pymtYrMnth)) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "대상자를 선택하시려면 정산년월을 선택하셔야 합니다.", null);
						return;
					}
					
					if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"))) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
						return;
					}
              	     	
					if (MSFSharedUtils.paramNotNull(records)) { 
  	  	              
						List<Remt2000DTO> listRemt2000Dto = new ArrayList<Remt2000DTO>();   
		              	    	
						while (records.hasNext()) {
  	  	  	              
							Record record = (Record) records.next(); 
							BaseModel bmMapModel = (BaseModel)record.getModel();
	  	  	                      
	  	  	                Remt2000DTO remt2000Dto = new Remt2000DTO();  
	  	  	                    
	  	  	                remt2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));         /**  column 사업장코드 : dpobCd */
			  	  	 	    remt2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
			  	  	  		  
			  	  	 	    remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			  	  	 	    remt2000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 정산년월 : clutYrMnth */	  
	  	  	 	      	     
			  	  	 	    listRemt2000Dto.add(remt2000Dto);
						}  
              	    	    
						if (listRemt2000Dto.size() <= 0) {
							MessageBox.alert("퇴직금산정", "퇴직금산정 처리 할 데이타가 존재하지 않습니다.", null);
							return;
	  	  	    		}
	               	             
						remt0100Service.activityOnPayrCalc(listRemt2000Dto,  new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
   	           	        	public void onFailure(Throwable caught) {
   	           	        	
   	           	        		List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   	           	        		ShowMessageBM smBm = new ShowMessageBM();
   	           	        		smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
   	           	        		smBm.setMenu("Remt");
   	           	        		smBm.setPhase("[퇴직금산정]퇴직금산정에러");
   	           	        		smBm.setMessage(caught.getLocalizedMessage());
   	           	        		smBm.setContent(caught.getMessage());
   	           	        		bmResult.add(smBm);  
   	           	        		
   	           	        		PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
   	           	        		ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
   	           	        		MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
 		    		          
   	           	        		msFwMessage.show();
   	           	        		showMessageForm.setMSFFormWindows(msFwMessage);
 		    		       
//   	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//   	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertRemt0100(insert) : " + caught), null);
   	           	        	}
   	           	        	
	   	           	        public void onSuccess(PagingLoadResult<ShowMessageBM> result) {  
   	           	        	
	   	           	        	if (MSFSharedUtils.paramNotNull(result)) {
	   	           	        		ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	   	           	        		BaseModel tmRec = new BaseModel();
	   	           	        		MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	   	           	        		msFwMessage.show();
	   	           	        		showMessageForm.setMSFFormWindows(msFwMessage);
	   	           	        	}
                              //reload(); 
	   	           	        	tabsRemtTop.setSelection(tabsRemtTop.getItem(0));
	   	           	        	tabsRemtSub.setSelection(tabsRemtSub.getItem(0));

	   	           	        	reloadRemt2000();
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
