package com.app.exterms.insurance.client.form;
 

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1200DTO;
import com.app.exterms.insurance.client.form.defs.Insr1100Def;
import com.app.exterms.insurance.client.service.Insr2100Service;
import com.app.exterms.insurance.client.service.Insr2100ServiceAsync;
import com.app.exterms.insurance.client.service.InsrP210004Service;
import com.app.exterms.insurance.client.service.InsrP210004ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFComponentKeyPress;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFNumberPropertyEditor;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.ComboBoxWithButton;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldWithButton;
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
import com.extjs.gxt.ui.client.widget.form.DateField;
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
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.


=====================================================**/
public class Insr2100    extends MSFPanel {  
 
   // private RemtConstants lblRemtConst = RemtConstants.INSTANCE; 
    
    private VerticalPanel vp;
    private FormPanel plFrmInsr2100; 
    private String txtForm = "";
    private XTemplate detailTp; 
    
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
    //4대보험취득
	  private Insr1100Def insr1100Def  = new Insr1100Def("INSR2100");   //그리드 테이블 컬럼 define  
    // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel insr1100GridPanel;
    
    //직종콤보
	  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
	  private MSFGridPanel typOccuCdGridPanel;
	    
     
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
      private ButtonBar topInsr2100Bar;
      private Button btnInsr2100Init;
      private Button btnInsr2100New;
      private Button btnInsr2100Save;
      private Button btnInsr2100Del;
      private Button btnInsr2100Sreach;
      private Button btnInsr2100ExcelFile;
      private Button btnInsr1550ExcelFile;
      private Button btnInsr2100Print;
      private Button btnInsr2100Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      

      /** column  년도 : payYr */
      private DateField srhSoctyInsurCmptnDt01;
      private DateField srhSoctyInsurCmptnDt02;
     
    //  private ComboBox<BaseModel> srhTypOccuCd; //직종 
    //  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
    //  private HiddenField<String> srhPyspGrdeCd; //직종 
      
    //  private ComboBox<BaseModel> srhPayCd;     //급여구분
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
    //  private MSFTextField srhDeptCd; //부서코드
    //  private MSFTextField srhDeptNm; //부서명  
    //  private Button btnSrhDeptCd;
    //  private MSFTextField srhMangeDeptCd; //관리부서 수정
    //  private MSFTextField srhMangeDeptNm; //관리부서 수정  
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

      private Boolean emptyCheck = false ;

      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> srhPymtDducDivCd;
      
      
      private List<ModelData> mDtalistHdofcCodtnCd ;
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      
      private boolean mutilCombo = false;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
     
		private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
		
		private HiddenField<String> systemkey;   /** column SYSTEMKEY : systemkey */
		
		private HiddenField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
		
		private MSFDateField socnsrAqtnRegVal17Dt;   /** column 취득일자 : soctyInsurCmptnDt */
		
		
		private HiddenField<Long> socInsrAqtnEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		private HiddenField<String> cellPhneNum;   /** column 핸드폰번호 : cellPhneNum */
      
		
		 private MSFTextField emymtDivNm; //고용구분 
		 private MSFTextField socInsrAqtnEmymtNumV; //일련번호
		 private MSFTextField deptNm; //부서 
		 private MSFTextField typOccuNm; //직종 
		 private MSFTextField DtilOccuClsDivNm; //직종세
		
		private MSFCheckBox allCheck = new MSFCheckBox(); //전체
	 	private MSFCheckBox hlthInsrRegrstYn = new MSFCheckBox();    /** column 건강보험신고여부 : hlthInsrRegrstYn */
	 	private MSFCheckBox natPennRegrstYn = new MSFCheckBox();     /** column 국민연금신고여부 : natPennRegrstYn */
	 	private MSFCheckBox umytInsrRegrstYn = new MSFCheckBox();    /** column 고용보험신고여부 : umytInsrRegrstYn */
	 	private MSFCheckBox idtlAccdtRegrstYn = new MSFCheckBox();   /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	 	
	 
	 	private MSFTextField socnsrAqtnRegVal02;    /** column 성명 : socnsrAqtnRegVal02 */
	 	private MSFTextField socnsrAqtnRegVal03;    /** column 주민등록번호 : socnsrAqtnRegVal03 */
	 	private TextFieldWithButton<String> socnsrAqtnRegVal04D;    /** column 국적 : socnsrAqtnRegVal04 popup */
	 	private HiddenField<String> socnsrAqtnRegVal04;    /** column 국적 : socnsrAqtnRegVal04 popup */
	 	private MSFComboBox<BaseModel> socnsrAqtnRegVal05;    /*TextFieldWithButton* column 체류자격 : socnsrAqtnRegVal05 */
	 	private MSFCheckBox socnsrAqtnRegVal06;    /** column 대표자여부 : socnsrAqtnRegVal06 1 예 / 2아니오 */
	 	
	 	private MSFNumberField  socnsrAqtnRegVal07;    /** NumberFieldWithButton column 연금_소득월액 : socnsrAqtnRegVal07 */
	 	private MSFCheckBox socnsrAqtnRegVal08;    /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 1:희망 2 미희망 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal09;    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
	 	private DateFieldWithButton socnsrAqtnRegVal10;    /** column 연금_자격취득일 : socnsrAqtnRegVal10 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal11;    /** column 연금_특수직종 : socnsrAqtnRegVal11 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal12;    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
	 	private HiddenField<String> socnsrAqtnRegVal13;    /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
	 	private HiddenField<String> socnsrAqtnRegVal14;    /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */
	 	private MSFNumberField socnsrAqtnRegVal15;    /** column 건강_보수월액 : socnsrAqtnRegVal15 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal16;    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
	 	private DateFieldWithButton socnsrAqtnRegVal17;    /** column 건강_자격취득일 : socnsrAqtnRegVal17 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal18;    /** column 건강_감면 : socnsrAqtnRegVal18 */
	 	private MSFCheckBox socnsrAqtnRegVal19;    /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 1:예 2 : 아니오 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal20;    /** column 건강_회계 : socnsrAqtnRegVal20 */
	 	private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal21;    /** column 건강_직종 : socnsrAqtnRegVal21 */
	 	private DateFieldWithButton socnsrAqtnRegVal22;    /** column 고용_자격취득일 : socnsrAqtnRegVal22 */
	 	private TextFieldWithButton<String> socnsrAqtnRegVal23D;    /** column 고용_직종 : socnsrAqtnRegVal23 팝업 */
	 	private HiddenField<String> socnsrAqtnRegVal23;    /** column 고용_직종 : socnsrAqtnRegVal23 팝업 */
		private MSFNumberField    socnsrAqtnRegVal24;    /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */
		private MSFCheckBox    socnsrAqtnRegVal25;    /** column 고용_계약직여부 : socnsrAqtnRegVal25 1: 계약직 /2 아니오*/
		private TextFieldWithButton socnsrAqtnRegVal26;    /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */
		private MSFNumberField socnsrAqtnRegVal27;    /** column 고용_월평균보수 : socnsrAqtnRegVal27 */
		private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal28;    /** column 고용_비고 : socnsrAqtnRegVal28 */
		private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal29;    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
		private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal30;    /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
		private DateFieldWithButton socnsrAqtnRegVal31;    /** column 산재_자격취득일 : socnsrAqtnRegVal31 */
		private TextFieldWithButton<String> socnsrAqtnRegVal32D;    /** column 산재_직종 : socnsrAqtnRegVal32 */
		private HiddenField<String> socnsrAqtnRegVal32;    /** column 산재_직종 : socnsrAqtnRegVal32 */
		private MSFNumberField socnsrAqtnRegVal33;    /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */
		private MSFCheckBox socnsrAqtnRegVal34;    /** column 산재_계약직여부 : socnsrAqtnRegVal34 */
		private TextFieldWithButton socnsrAqtnRegVal35;    /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */
		private MSFNumberField  socnsrAqtnRegVal36;    /** column 산재_월평균보수 : socnsrAqtnRegVal36 */
		private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal37;    /** column 산재_비고 : socnsrAqtnRegVal37 */
		private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal38;    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
		private ComboBoxWithButton<BaseModel> socnsrAqtnRegVal39;    /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
		private MSFTextField socnsrAqtnRegVal40;    /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
		private MSFTextField socnsrAqtnRegVal41;    /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
		private MSFTextField socnsrAqtnRegVal42;    /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
		private MSFTextField socnsrAqtnRegVal43;    /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
		private MSFTextField socnsrAqtnRegVal44;    /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
		private MSFTextField socnsrAqtnRegVal45;    /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
		private MSFTextField socnsrAqtnRegVal46;    /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
		private MSFTextField socnsrAqtnRegVal47;    /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
		private MSFTextField socnsrAqtnRegVal48;    /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
		private MSFTextField socnsrAqtnRegVal49;    /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
		private MSFTextField socnsrAqtnRegVal50;    /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
		private MSFTextField socnsrAqtnRegVal51;    /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
		private MSFTextField socnsrAqtnRegVal52;    /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
		private MSFTextField socnsrAqtnRegVal53;    /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
		private MSFTextField socnsrAqtnRegVal54;    /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
		private MSFTextField socnsrAqtnRegVal55;    /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
		private MSFTextField socnsrAqtnRegVal56;    /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
		private MSFTextField socnsrAqtnRegVal57;    /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
		private MSFTextField socnsrAqtnRegVal58;    /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
		private MSFTextField socnsrAqtnRegVal59;    /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
		private MSFTextField socnsrAqtnRegVal60;    /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
		private MSFTextField socnsrAqtnRegVal61;    /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
		private MSFTextField socnsrAqtnRegVal62;    /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
		private MSFTextField socnsrAqtnRegVal63;    /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
		private MSFTextField socnsrAqtnRegVal64;    /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
		private MSFTextField socnsrAqtnRegVal65;    /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
		private MSFTextField socnsrAqtnRegVal66;    /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
		private MSFTextField socnsrAqtnRegVal67;    /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
		private MSFTextField socnsrAqtnRegVal68;    /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
		private MSFTextField socnsrAqtnRegVal69;    /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
		private MSFTextField socnsrAqtnRegVal70;    /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
		private MSFTextField socnsrAqtnRegVal71;    /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
		private MSFTextField socnsrAqtnRegVal72;    /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
		private MSFTextField socnsrAqtnRegVal73;    /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
		private MSFTextField socnsrAqtnRegVal74;    /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
		private MSFTextField socnsrAqtnRegVal75;    /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
		private MSFTextField socnsrAqtnRegVal76;    /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
		private MSFTextField socnsrAqtnRegVal77;    /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
		private MSFTextField socnsrAqtnRegVal78;    /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
		private MSFTextField socnsrAqtnRegVal79;    /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
		private MSFTextField socnsrAqtnRegVal80;    /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */ 
		
		
		
		private Button btnSocnsrAqtnRegVal07;
		private Button btnSocnsrAqtnRegVal10;
		private Button btnSocnsrAqtnRegVal09;
		private Button btnSocnsrAqtnRegVal11;
		private Button btnSocnsrAqtnRegVal12;
		private Button btnSocnsrAqtnRegVal15;
		private Button btnSocnsrAqtnRegVal17;
		private Button btnSocnsrAqtnRegVal16;
		private Button btnSocnsrAqtnRegVal18;
		private Button btnSocnsrAqtnRegVal20;
		private Button btnSocnsrAqtnRegVal21;
		private Button btnSocnsrAqtnRegVal27;
		private Button btnSocnsrAqtnRegVal22;
		private Button btnSocnsrAqtnRegVal24;
		private Button btnSocnsrAqtnRegVal26;
		private Button btnSocnsrAqtnRegVal29;
		private Button btnSocnsrAqtnRegVal30;
		private Button btnSocnsrAqtnRegVal28;
		private Button btnSocnsrAqtnRegVal36;
		private Button btnSocnsrAqtnRegVal31;
		private Button btnSocnsrAqtnRegVal33;
		private Button btnSocnsrAqtnRegVal35;
		private Button btnSocnsrAqtnRegVal38;
		private Button btnSocnsrAqtnRegVal39;
		private Button btnSocnsrAqtnRegVal37;
		
		private Button btn01;
		private Button btn02; 
		private Button btn03; 
		private Button btn04; 
		
		private Button gridAllCheckbox; 
		private Button btnSocnsrAqtnRegVal08;
		private Button btnSocnsrAqtnRegVal19;
		private Button btnSocnsrAqtnRegVal23;
		private Button btnSocnsrAqtnRegVal25;
		private Button btnSocnsrAqtnRegVal32;
		private Button btnSocnsrAqtnRegVal34;

		private MSFTextField hlthInsrSym;
	 	private MSFTextField hlthInsrOfceSym01;
	 	private MSFTextField hlthPayMangeDeptNm;
	 	private MSFTextField natPennSym;
	 	private MSFTextField natPayMangeDeptNm;
	 	private MSFTextField umytInsrSym;
	 	private MSFTextField umytPayMangeDeptNm;
	 	private MSFTextField idtlAccdtInsurSym;
	 	private MSFTextField idtlPayMangeDeptNm;
	 	private MSFTextField payMangeDeptPhnNum;
	 	private MSFTextField payMangeDeptFaxNum;
	 	private MSFTextField payMangeDeptZpcd;
	 	private MSFTextField payMangeDeptAddr;
	 	private MSFTextField hlthInsrOfceSym;
	 	private MSFTextField insurPrvaffAgcyIstutNum;
	 	private MSFTextField insurPrvaffAgcyIstutNm;
	 	private MSFTextField payMangeDeptNm;
	 	
	 	private String systemKeys;
	 	private String printFileName;
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
			  private void checkInsr2100Auth( String authAction, ListStore<BaseModel> bm) {   
		    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
				 
				  if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
				   
					  if (!maskTracker) { unmask(); }  
		                //MSFMainApp.unmaskMainPage();
					   //----------------------------------------------------
					  authExecEnabled();
					  gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
				  }
			  }
			  
			  private void authExecEnabled() { 
				   //------------------
				    Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
		            
			           gwtAuthorization.formAuthFieldConfig(fldArrField);
			           
			           
			           
			           setInitDate();
			           srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
			           srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
			           
					   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			            * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			            * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
			            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			             //String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
			            // GWTAuthorization.formAuthPopConfig(plFrmInsr2100, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
			            // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
					 //  gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");  
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
			        	   if (lsEmymtDivCd.getCount() > 0 && lsPayYrStore.getCount() > 0) {
			        		   
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
					 authMapDef.put("PayrMangDeptCd",Boolean.FALSE);
					 authMapDef.put("EmymtDivCd",Boolean.FALSE);
					 authMapDef.put("DeptCd",Boolean.FALSE);
					// authMapDef.put("TypOccuCd",Boolean.FALSE); 
					 
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
		  
   // 검색 폼 바인딩 처리 함수 
	   //화면 폼 바인딩 처리 
	    private void setInsr2100FormBinding() {
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	    }        
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	    //입력수정삭제처리 rpc 처리부     
	   private Insr2100ServiceAsync insr2100Service = Insr2100Service.Util.getInstance();	 
	   private InsrP210004ServiceAsync insrP210004Service = InsrP210004Service.Util.getInstance();

	   private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
  		
  		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  		private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		   
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
  	   //--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관
  		
  		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
  		
  		private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드
  		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
  		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
  		
  		
  		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
  		 
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal05 = new ListStore<BaseModel>(); /** column 체류자격 : socnsrAqtnRegVal05 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal09 = new ListStore<BaseModel>();    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal11 = new ListStore<BaseModel>();    /** column 연금_특수직종 : socnsrAqtnRegVal11 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal12 = new ListStore<BaseModel>();    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal16 = new ListStore<BaseModel>();    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal18 = new ListStore<BaseModel>();    /** column 건강_감면 : socnsrAqtnRegVal18 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal20 = new ListStore<BaseModel>();    /** column 건강_회계 : socnsrAqtnRegVal20 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal21 = new ListStore<BaseModel>();    /** column 건강_직종 : socnsrAqtnRegVal21 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal28 = new ListStore<BaseModel>();    /** column 고용_비고 : socnsrAqtnRegVal28 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal29 = new ListStore<BaseModel>();    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal30 = new ListStore<BaseModel>();    /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal37 = new ListStore<BaseModel>();    /** column 산재_비고 : socnsrAqtnRegVal37 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal38 = new ListStore<BaseModel>();    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
  		private ListStore<BaseModel>  lsSocnsrAqtnRegVal39 = new ListStore<BaseModel>();    /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
  		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
  		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
  		private SysCoCalendarDTO  msfCoCalendarDto;  
  		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
  		 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
  		 
	    private BaseModel record;
    
	    private  Iterator<Record> records;
	    
	    private BaseModel ppRecord; //팝업에 넘길 레코드 값 
    
     
/**
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 */  
private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT: 
            break;
        case UPDATE:
            updateInsr2100();
            break;
        case DELETE:
        	deleteInsr2100();          	
            break;
        }
    }
	    
//updateInsr2100
private void updateInsr2100() {
	        
	        if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	            return;
	        }
	          
	        Insr1200DTO insr1200Dto = new Insr1200DTO(); 
	 
	        
	 		insr1200Dto.setDpobCd(dpobCd.getValue());                           /** column 사업장코드 : dpobCd */
	 		insr1200Dto.setSystemkey(systemkey.getValue());                     /** column SYSTEMKEY : systemkey */
	 		insr1200Dto.setSoctyInsurCmptnDt(soctyInsurCmptnDt.getValue());     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
	 		insr1200Dto.setSocInsrAqtnEmymtNum(socInsrAqtnEmymtNum.getValue()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			insr1200Dto.setNatPennRegrstYn(natPennRegrstYn.getValue());    /** column 국민연금신고여부 : natPennRegrstYn */
			insr1200Dto.setHlthInsrRegrstYn(hlthInsrRegrstYn.getValue());    /** column 건강보험신고여부 : hlthInsrRegrstYn */
			insr1200Dto.setUmytInsrRegrstYn(umytInsrRegrstYn.getValue());   /** column 고용보험신고여부 : umytInsrRegrstYn */
			insr1200Dto.setIdtlAccdtRegrstYn(idtlAccdtRegrstYn.getValue());  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
		 	
			//insr1200Dto.setSocnsrAqtnRegVal01(MSFSharedUtils.allowNulls(socnsrAqtnRegVal01.getValue()));    /** column 사회보험취득신고_ITEM_VALUE01 : socnsrAqtnRegVal01 */
			insr1200Dto.setSocnsrAqtnRegVal02(MSFSharedUtils.allowNulls(socnsrAqtnRegVal02.getValue()));         /** column 성명 : socnsrAqtnRegVal02 */                                                                                       
			insr1200Dto.setSocnsrAqtnRegVal03(MSFSharedUtils.allowNulls(socnsrAqtnRegVal03.getValue()));   /** column 주민등록번호 : socnsrAqtnRegVal03 */                                                                                   
			insr1200Dto.setSocnsrAqtnRegVal04(MSFSharedUtils.allowNulls(socnsrAqtnRegVal04.getValue()));   /** column 국적 : socnsrAqtnRegVal04 */                                                                                       
			insr1200Dto.setSocnsrAqtnRegVal05(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal05,"commCd") );   /** column 체류자격 : socnsrAqtnRegVal05 */                                                                                     
			insr1200Dto.setSocnsrAqtnRegVal06(socnsrAqtnRegVal06.getValue());   /** column 대표자여부 : socnsrAqtnRegVal06 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal07(longToNullChk(socnsrAqtnRegVal07.getValue()));   /** column 연금_소득월액 : socnsrAqtnRegVal07 */                                                                                  
			insr1200Dto.setSocnsrAqtnRegVal08(socnsrAqtnRegVal08.getValue());   /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal09(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal09,"commCd"));   /** column 연금_취득부호 : socnsrAqtnRegVal09 */                                                                                  
			insr1200Dto.setSocnsrAqtnRegVal10(GWTUtils.getStringFromDate(socnsrAqtnRegVal10.getValue(),"yyyyMMdd") );   /** column 연금_자격취득일 : socnsrAqtnRegVal10 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal11(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal11,"commCd") );   /** column 연금_특수직종 : socnsrAqtnRegVal11 */                                                                                  
			insr1200Dto.setSocnsrAqtnRegVal12(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal12,"commCd") );   /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */                                                                                
			insr1200Dto.setSocnsrAqtnRegVal13(MSFSharedUtils.allowNulls(socnsrAqtnRegVal13.getValue()));   /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal14(MSFSharedUtils.allowNulls(socnsrAqtnRegVal14.getValue()));   /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal15(longToNullChk(socnsrAqtnRegVal15.getValue()));   /** column 건강_보수월액 : socnsrAqtnRegVal15 */                                                                                  
			insr1200Dto.setSocnsrAqtnRegVal16( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal16,"commCd") );   /** column 건강_취득부호 : socnsrAqtnRegVal16 */                                                                                  
			insr1200Dto.setSocnsrAqtnRegVal17(GWTUtils.getStringFromDate(socnsrAqtnRegVal17.getValue(),"yyyyMMdd")  );   /** column 건강_자격취득일 : socnsrAqtnRegVal17 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal18( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal18,"commCd") );   /** column 건강_감면 : socnsrAqtnRegVal18 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal19(socnsrAqtnRegVal19.getValue());   /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 */                                                                            
			insr1200Dto.setSocnsrAqtnRegVal20( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal20,"commCd") );   /** column 건강_회계 : socnsrAqtnRegVal20 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal21( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal21,"commCd") );   /** column 건강_직종 : socnsrAqtnRegVal21 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal22(GWTUtils.getStringFromDate(socnsrAqtnRegVal22.getValue(),"yyyyMMdd")  );   /** column 고용_자격취득일 : socnsrAqtnRegVal22 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal23(MSFSharedUtils.allowNulls(socnsrAqtnRegVal23.getValue())  );   /** column 고용_직종 : socnsrAqtnRegVal23 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal24(doubleToNullChk(socnsrAqtnRegVal24.getValue()));   /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal25(socnsrAqtnRegVal25.getValue());   /** column 고용_계약직여부 : socnsrAqtnRegVal25 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal26( MSFSharedUtils.allowNulls(socnsrAqtnRegVal26.getValue()));   /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal27(longToNullChk(socnsrAqtnRegVal27.getValue()));   /** column 고용_월평균보수 : socnsrAqtnRegVal27 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal28(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal28,"commCd") );   /** column 고용_비고 : socnsrAqtnRegVal28 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal29(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal29,"commCd") );   /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */                                                                             
			insr1200Dto.setSocnsrAqtnRegVal30(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal30,"commCd") );   /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal31(GWTUtils.getStringFromDate(socnsrAqtnRegVal31.getValue(),"yyyyMMdd") );   /** column 산재_자격취득일 : socnsrAqtnRegVal31 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal32(MSFSharedUtils.allowNulls(socnsrAqtnRegVal32.getValue()) );   /** column 산재_직종 : socnsrAqtnRegVal32 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal33(doubleToNullChk(socnsrAqtnRegVal33.getValue()));   /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal34(socnsrAqtnRegVal34.getValue());   /** column 산재_계약직여부 : socnsrAqtnRegVal34 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal35(MSFSharedUtils.allowNulls(socnsrAqtnRegVal35.getValue()));   /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */                                                                               
			insr1200Dto.setSocnsrAqtnRegVal36(longToNullChk(socnsrAqtnRegVal36.getValue()));   /** column 산재_월평균보수 : socnsrAqtnRegVal36 */                                                                                 
			insr1200Dto.setSocnsrAqtnRegVal37(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal37,"commCd") );   /** column 산재_비고 : socnsrAqtnRegVal37 */                                                                                    
			insr1200Dto.setSocnsrAqtnRegVal38(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal38,"commCd") );   /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */                                                                             
			insr1200Dto.setSocnsrAqtnRegVal39(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal39,"commCd") );   /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */                                                                             
//			insr1200Dto.setSocnsrAqtnRegVal40(MSFSharedUtils.allowNulls(socnsrAqtnRegVal40.getValue())); /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal41(MSFSharedUtils.allowNulls(socnsrAqtnRegVal41.getValue())); /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal42(MSFSharedUtils.allowNulls(socnsrAqtnRegVal42.getValue())); /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal43(MSFSharedUtils.allowNulls(socnsrAqtnRegVal43.getValue())); /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal44(MSFSharedUtils.allowNulls(socnsrAqtnRegVal44.getValue())); /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal45(MSFSharedUtils.allowNulls(socnsrAqtnRegVal45.getValue())); /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal46(MSFSharedUtils.allowNulls(socnsrAqtnRegVal46.getValue())); /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal47(MSFSharedUtils.allowNulls(socnsrAqtnRegVal47.getValue())); /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal48(MSFSharedUtils.allowNulls(socnsrAqtnRegVal48.getValue())); /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal49(MSFSharedUtils.allowNulls(socnsrAqtnRegVal49.getValue())); /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal50(MSFSharedUtils.allowNulls(socnsrAqtnRegVal50.getValue())); /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal51(MSFSharedUtils.allowNulls(socnsrAqtnRegVal51.getValue())); /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal52(MSFSharedUtils.allowNulls(socnsrAqtnRegVal52.getValue())); /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal53(MSFSharedUtils.allowNulls(socnsrAqtnRegVal53.getValue())); /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal54(MSFSharedUtils.allowNulls(socnsrAqtnRegVal54.getValue())); /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal55(MSFSharedUtils.allowNulls(socnsrAqtnRegVal55.getValue())); /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal56(MSFSharedUtils.allowNulls(socnsrAqtnRegVal56.getValue())); /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal57(MSFSharedUtils.allowNulls(socnsrAqtnRegVal57.getValue())); /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal58(MSFSharedUtils.allowNulls(socnsrAqtnRegVal58.getValue())); /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal59(MSFSharedUtils.allowNulls(socnsrAqtnRegVal59.getValue())); /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal60(MSFSharedUtils.allowNulls(socnsrAqtnRegVal60.getValue())); /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal61(MSFSharedUtils.allowNulls(socnsrAqtnRegVal61.getValue())); /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal62(MSFSharedUtils.allowNulls(socnsrAqtnRegVal62.getValue())); /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal63(MSFSharedUtils.allowNulls(socnsrAqtnRegVal63.getValue())); /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal64(MSFSharedUtils.allowNulls(socnsrAqtnRegVal64.getValue())); /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal65(MSFSharedUtils.allowNulls(socnsrAqtnRegVal65.getValue())); /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal66(MSFSharedUtils.allowNulls(socnsrAqtnRegVal66.getValue())); /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal67(MSFSharedUtils.allowNulls(socnsrAqtnRegVal67.getValue())); /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal68(MSFSharedUtils.allowNulls(socnsrAqtnRegVal68.getValue())); /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal69(MSFSharedUtils.allowNulls(socnsrAqtnRegVal69.getValue())); /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal70(MSFSharedUtils.allowNulls(socnsrAqtnRegVal70.getValue())); /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal71(MSFSharedUtils.allowNulls(socnsrAqtnRegVal71.getValue())); /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal72(MSFSharedUtils.allowNulls(socnsrAqtnRegVal72.getValue())); /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal73(MSFSharedUtils.allowNulls(socnsrAqtnRegVal73.getValue())); /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal74(MSFSharedUtils.allowNulls(socnsrAqtnRegVal74.getValue())); /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal75(MSFSharedUtils.allowNulls(socnsrAqtnRegVal75.getValue())); /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal76(MSFSharedUtils.allowNulls(socnsrAqtnRegVal76.getValue())); /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal77(MSFSharedUtils.allowNulls(socnsrAqtnRegVal77.getValue())); /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal78(MSFSharedUtils.allowNulls(socnsrAqtnRegVal78.getValue())); /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal79(MSFSharedUtils.allowNulls(socnsrAqtnRegVal79.getValue())); /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */                                                                    
//			insr1200Dto.setSocnsrAqtnRegVal80(MSFSharedUtils.allowNulls(socnsrAqtnRegVal80.getValue())); /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */                                                                     
			 
	  
	 		insr2100Service.activityOnUpdateInsr2100(insr1200Dto ,
	                new AsyncCallback<Long>() {
	        public void onFailure(Throwable caught) {
	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateInsr2100(Save) : " + caught), null);
	        }
	        public void onSuccess(Long result) {  
	        	 if (result == 0) {
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                             actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                    // actionDatabase = ActionDatabase.INSERT;
                 } else {
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                             actionDatabase + "처리가 완료되었습니다.", null);
                     reload();
                     actionDatabase = ActionDatabase.UPDATE;
                 } 
	        	
	        	
	        } 
	        });
	        
}

private Long longToNullChk(Object val){
	if(val == null){
		return 0L;
	}else{
		return (Long) val;
	}
}
	   
private Double doubleToNullChk(Object val){
	if(val == null){
		return (double) 0;
	}else{
		return (Double) val;
	}
}


	//deleteInsr2100
	private void deleteInsr2100() {
		
		if (insr1100GridPanel.getCurrentlySelectedItem() != null) {  
			
			MessageBox.confirm("사회보험자격 취득신고 삭제", "선택하신 대상자를 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
				
				@Override
				public void handleEvent(MessageBoxEvent be) {
					
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						
						boolean flag = true;
					
						List<Insr1200DTO> listinsr1200Dto = new ArrayList<Insr1200DTO>();  
						
						while (records.hasNext()) {
							Record record = (Record) records.next();
							BaseModel bmMapModel = (BaseModel)record.getModel();
	   
							Insr1200DTO insr1200Dto = new Insr1200DTO(); 
	   
							insr1200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							insr1200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							insr1200Dto.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("soctyInsurCmptnDt")));    /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
							insr1200Dto.setSocInsrAqtnEmymtNum(Long.parseLong(MSFSharedUtils.allowNulls(bmMapModel.get("socInsrAqtnEmymtNum"))));    /** column 피부양자취득상실_고용일련번호 : socInsrAqtnEmymtNum */
							
							
							String hanNm = MSFSharedUtils.allowNulls(bmMapModel.get("hanNm"));
							String resnRegnNum = MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum"));							
							
							if(MSFSharedUtils.allowNulls(bmMapModel.get("insr1500Yn")).equals("true")){
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), hanNm+"("+resnRegnNum+")님의 피부양자가 존재합니다. 피부양자 삭제후 재시도 하세요. ", null);
								flag = false;
								break;
							}
							
 
							listinsr1200Dto.add(insr1200Dto);
						}
						
						if(flag){
							insr2100Service.deleteInsr2100(listinsr1200Dto, new AsyncCallback<Long>() {
								@Override
								public void onSuccess(Long result) { 
									MessageBox.info("", "삭제 되었습니다.", null);
									insr1100GridPanel.reload();
									detailClear();

								}
								@Override
								public void onFailure(Throwable caught) {
									caught.printStackTrace();
									MessageBox.info("", "삭제 오류", null);
								}
							});
						}
					}
				}
			});
		}
		else {
			 MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
			 return;
		}
	}
    
/**
* 그리드 선택시 데이타 가져오기 
*/
private void readDtailData() {
        
        if (MSFSharedUtils.paramNull(systemkey.getValue())) {
            return;
        }
         
        Insr1200DTO insr1200Dto = new Insr1200DTO(); 
 
        
 		insr1200Dto.setDpobCd(dpobCd.getValue());                           /** column 사업장코드 : dpobCd */
 		insr1200Dto.setSystemkey(systemkey.getValue());                     /** column SYSTEMKEY : systemkey */
 		insr1200Dto.setSoctyInsurCmptnDt(soctyInsurCmptnDt.getValue());     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
 		insr1200Dto.setSocInsrAqtnEmymtNum(socInsrAqtnEmymtNum.getValue()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
  
 		insr2100Service.activityOnReadInsr1200(insr1200Dto ,
                new AsyncCallback<Insr1200DTO>() {
        public void onFailure(Throwable caught) {
        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadInsr1200(Read) : " + caught), null);
        }
        public void onSuccess(Insr1200DTO result) { 
           //결과값맵핑 
//        	dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
//			systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
//			soctyInsurCmptnDt.setValue(result.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
//			socInsrAqtnEmymtNum.setValue(result.getSocInsrAqtnEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
        	socInsrAqtnEmymtNumV.setValue(result.getSocInsrAqtnEmymtNum().toString());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			//공단구분 4대보험 구분자로 분리 .
			//socnsrAqtnRegVal01.setValue(result.getSocnsrAqtnRegVal01());    /** column 공단구분 : socnsrAqtnRegVal01 */
			
			hlthInsrRegrstYn.setValue( result.getHlthInsrRegrstYn());    /** column 건강보험신고여부 : hlthInsrRegrstYn */
			natPennRegrstYn.setValue( result.getNatPennRegrstYn());    /** column 국민연금신고여부 : natPennRegrstYn */
			umytInsrRegrstYn.setValue( result.getUmytInsrRegrstYn());    /** column 고용보험신고여부 : umytInsrRegrstYn */
			idtlAccdtRegrstYn.setValue( result.getIdtlAccdtRegrstYn());    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
			 
			//emymtDivCd.setValue(result.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
			emymtDivNm.setValue(result.getEmymtDivNm());    /** column 고용구분 : emymtDivNm */
			//deptCd.setValue(result.getDeptCd());    /** column 부서코드 : deptCd */
			deptNm.setValue(result.getDeptNm());    /** column 부서 : deptNm */
			if (!MSFSharedUtils.paramNull(result.getTypOccuNm())) {
				//typOccuCd.setValue(result.getTypOccuCd());    /** column 직종코드 : typOccuCd */
				typOccuNm.setValue(result.getTypOccuNm());    /** column 직종 : typOccuNm */
			} else {
				//businCd.setValue(result.getBusinCd());    /** column 사업코드 : businCd */
				//businNm.setValue(result.getBusinNm());    /** column 사업 : businNm */
				typOccuNm.setValue(result.getBusinNm());    /** column 직종 : typOccuNm */
			}
			//pyspGrdeCd.setValue(result.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
			//pyspGrdeNm.setValue(result.getPyspGrdeNm());    /** column 호봉등급 : pyspGrdeNm */
			//dtilOccuInttnCd.setValue(result.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
			DtilOccuClsDivNm.setValue(result.getDtilOccuClsDivNm());    /** column 직종세구분 : dtilOccuClsDivNm */
			
			socnsrAqtnRegVal02.setValue(result.getSocnsrAqtnRegVal02());    /** column 성명 : socnsrAqtnRegVal02 */
			socnsrAqtnRegVal03.setValue(result.getSocnsrAqtnRegVal03());    /** column 주민등록번호 : socnsrAqtnRegVal03 */
			socnsrAqtnRegVal04.setValue(result.getSocnsrAqtnRegVal04());    /** column 국적 : socnsrAqtnRegVal04 */
			socnsrAqtnRegVal04D.setValue(result.getSocnsrAqtnRegVal04Nm());    /** column 국적 : socnsrAqtnRegVal04 */
			socnsrAqtnRegVal05.setValue(lsSocnsrAqtnRegVal05.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal05())));    /** column 체류자격 : socnsrAqtnRegVal05 */
			socnsrAqtnRegVal06.setValue(result.getSocnsrAqtnRegVal06());    /** column 대표자여부 : socnsrAqtnRegVal06 */
			socnsrAqtnRegVal07.setValue(result.getSocnsrAqtnRegVal07());    /** column 연금_소득월액 : socnsrAqtnRegVal07 */
			socnsrAqtnRegVal08.setValue(result.getSocnsrAqtnRegVal08());    /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */
			socnsrAqtnRegVal09.setValue(lsSocnsrAqtnRegVal09.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal09())));    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
			socnsrAqtnRegVal10.setValue(GWTUtils.getDateFromString(result.getSocnsrAqtnRegVal10(), "yyyyMMdd"));    /** column 연금_자격취득일 : socnsrAqtnRegVal10 */
			socnsrAqtnRegVal11.setValue(lsSocnsrAqtnRegVal11.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal11())));    /** column 연금_특수직종 : socnsrAqtnRegVal11 */
			socnsrAqtnRegVal12.setValue(lsSocnsrAqtnRegVal12.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal12())));    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
			socnsrAqtnRegVal13.setValue(result.getSocnsrAqtnRegVal13());    /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
			socnsrAqtnRegVal14.setValue(result.getSocnsrAqtnRegVal14());    /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */
			socnsrAqtnRegVal15.setValue(result.getSocnsrAqtnRegVal15());    /** column 건강_보수월액 : socnsrAqtnRegVal15 */
			socnsrAqtnRegVal16.setValue(lsSocnsrAqtnRegVal16.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal16())));    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
			socnsrAqtnRegVal17.setValue(GWTUtils.getDateFromString(result.getSocnsrAqtnRegVal17(), "yyyyMMdd"));    /** column 건강_자격취득일 : socnsrAqtnRegVal17 */
			socnsrAqtnRegVal18.setValue(lsSocnsrAqtnRegVal18.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal18())));    /** column 건강_감면 : socnsrAqtnRegVal18 */
			socnsrAqtnRegVal19.setValue(result.getSocnsrAqtnRegVal19());    /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 */
			socnsrAqtnRegVal20.setValue(lsSocnsrAqtnRegVal20.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal20())));    /** column 건강_회계 : socnsrAqtnRegVal20 */
			socnsrAqtnRegVal21.setValue(lsSocnsrAqtnRegVal21.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal21())));    /** column 건강_직종 : socnsrAqtnRegVal21 */
			socnsrAqtnRegVal21.setValue(lsSocnsrAqtnRegVal21.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal21())));    /** column 건강_직종 : socnsrAqtnRegVal21 */
			socnsrAqtnRegVal22.setValue(GWTUtils.getDateFromString(result.getSocnsrAqtnRegVal22(), "yyyyMMdd"));    /** column 고용_자격취득일 : socnsrAqtnRegVal22 */
			socnsrAqtnRegVal23.setValue(result.getSocnsrAqtnRegVal23());    /** column 고용_직종 : socnsrAqtnRegVal23 */
			socnsrAqtnRegVal23D.setValue(result.getSocnsrAqtnRegVal23Nm());    /** column 고용_직종 : socnsrAqtnRegVal23 */
			socnsrAqtnRegVal24.setValue(result.getSocnsrAqtnRegVal24());    /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */
			socnsrAqtnRegVal25.setValue(result.getSocnsrAqtnRegVal25());    /** column 고용_계약직여부 : socnsrAqtnRegVal25 */
			socnsrAqtnRegVal26.setValue(result.getSocnsrAqtnRegVal26());    /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */
			socnsrAqtnRegVal27.setValue(result.getSocnsrAqtnRegVal27());    /** column 고용_월평균보수 : socnsrAqtnRegVal27 */
			socnsrAqtnRegVal28.setValue(lsSocnsrAqtnRegVal28.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal28())));    /** column 고용_비고 : socnsrAqtnRegVal28 */
			socnsrAqtnRegVal29.setValue(lsSocnsrAqtnRegVal29.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal29())));    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
			socnsrAqtnRegVal30.setValue(lsSocnsrAqtnRegVal30.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal30())));    /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
			socnsrAqtnRegVal31.setValue(GWTUtils.getDateFromString(result.getSocnsrAqtnRegVal31(), "yyyyMMdd"));    /** column 산재_자격취득일 : socnsrAqtnRegVal31 */
			socnsrAqtnRegVal32.setValue(result.getSocnsrAqtnRegVal32());    /** column 산재_직종 : socnsrAqtnRegVal32 */
			socnsrAqtnRegVal32D.setValue(result.getSocnsrAqtnRegVal32Nm());    /** column 산재_직종 : socnsrAqtnRegVal32 */
			socnsrAqtnRegVal33.setValue(result.getSocnsrAqtnRegVal33());    /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */
			socnsrAqtnRegVal34.setValue(result.getSocnsrAqtnRegVal34());    /** column 산재_계약직여부 : socnsrAqtnRegVal34 */
			socnsrAqtnRegVal35.setValue(result.getSocnsrAqtnRegVal35());    /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */
			socnsrAqtnRegVal36.setValue(result.getSocnsrAqtnRegVal36());    /** column 산재_월평균보수 : socnsrAqtnRegVal36 */
			socnsrAqtnRegVal37.setValue(lsSocnsrAqtnRegVal37.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal37())));    /** column 산재_비고 : socnsrAqtnRegVal37 */
			socnsrAqtnRegVal38.setValue(lsSocnsrAqtnRegVal38.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal38())));    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
			socnsrAqtnRegVal39.setValue(lsSocnsrAqtnRegVal39.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrAqtnRegVal39())));    /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
//			socnsrAqtnRegVal40.setValue(result.getSocnsrAqtnRegVal40());    /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
//			socnsrAqtnRegVal41.setValue(result.getSocnsrAqtnRegVal41());    /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
//			socnsrAqtnRegVal42.setValue(result.getSocnsrAqtnRegVal42());    /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
//			socnsrAqtnRegVal43.setValue(result.getSocnsrAqtnRegVal43());    /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
//			socnsrAqtnRegVal44.setValue(result.getSocnsrAqtnRegVal44());    /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
//			socnsrAqtnRegVal45.setValue(result.getSocnsrAqtnRegVal45());    /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
//			socnsrAqtnRegVal46.setValue(result.getSocnsrAqtnRegVal46());    /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
//			socnsrAqtnRegVal47.setValue(result.getSocnsrAqtnRegVal47());    /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
//			socnsrAqtnRegVal48.setValue(result.getSocnsrAqtnRegVal48());    /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
//			socnsrAqtnRegVal49.setValue(result.getSocnsrAqtnRegVal49());    /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
//			socnsrAqtnRegVal50.setValue(result.getSocnsrAqtnRegVal50());    /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
//			socnsrAqtnRegVal51.setValue(result.getSocnsrAqtnRegVal51());    /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
//			socnsrAqtnRegVal52.setValue(result.getSocnsrAqtnRegVal52());    /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
//			socnsrAqtnRegVal53.setValue(result.getSocnsrAqtnRegVal53());    /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
//			socnsrAqtnRegVal54.setValue(result.getSocnsrAqtnRegVal54());    /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
//			socnsrAqtnRegVal55.setValue(result.getSocnsrAqtnRegVal55());    /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
//			socnsrAqtnRegVal56.setValue(result.getSocnsrAqtnRegVal56());    /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
//			socnsrAqtnRegVal57.setValue(result.getSocnsrAqtnRegVal57());    /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
//			socnsrAqtnRegVal58.setValue(result.getSocnsrAqtnRegVal58());    /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
//			socnsrAqtnRegVal59.setValue(result.getSocnsrAqtnRegVal59());    /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
//			socnsrAqtnRegVal60.setValue(result.getSocnsrAqtnRegVal60());    /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
//			socnsrAqtnRegVal61.setValue(result.getSocnsrAqtnRegVal61());    /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
//			socnsrAqtnRegVal62.setValue(result.getSocnsrAqtnRegVal62());    /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
//			socnsrAqtnRegVal63.setValue(result.getSocnsrAqtnRegVal63());    /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
//			socnsrAqtnRegVal64.setValue(result.getSocnsrAqtnRegVal64());    /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
//			socnsrAqtnRegVal65.setValue(result.getSocnsrAqtnRegVal65());    /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
//			socnsrAqtnRegVal66.setValue(result.getSocnsrAqtnRegVal66());    /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
//			socnsrAqtnRegVal67.setValue(result.getSocnsrAqtnRegVal67());    /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
//			socnsrAqtnRegVal68.setValue(result.getSocnsrAqtnRegVal68());    /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
//			socnsrAqtnRegVal69.setValue(result.getSocnsrAqtnRegVal69());    /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
//			socnsrAqtnRegVal70.setValue(result.getSocnsrAqtnRegVal70());    /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
//			socnsrAqtnRegVal71.setValue(result.getSocnsrAqtnRegVal71());    /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
//			socnsrAqtnRegVal72.setValue(result.getSocnsrAqtnRegVal72());    /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
//			socnsrAqtnRegVal73.setValue(result.getSocnsrAqtnRegVal73());    /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
//			socnsrAqtnRegVal74.setValue(result.getSocnsrAqtnRegVal74());    /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
//			socnsrAqtnRegVal75.setValue(result.getSocnsrAqtnRegVal75());    /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
//			socnsrAqtnRegVal76.setValue(result.getSocnsrAqtnRegVal76());    /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
//			socnsrAqtnRegVal77.setValue(result.getSocnsrAqtnRegVal77());    /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
//			socnsrAqtnRegVal78.setValue(result.getSocnsrAqtnRegVal78());    /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
//			socnsrAqtnRegVal79.setValue(result.getSocnsrAqtnRegVal79());    /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
//			socnsrAqtnRegVal80.setValue(result.getSocnsrAqtnRegVal80());    /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */ 
        	
        } 
        });
        
}
	
 
/**************************일괄 배치 처리 작업을 위한 함수 **********************************/
private void updaeBatchInsr2100() {
	        
	        if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	            return;
	        }
	         
	        //대상자 전체를 가지고 온다. 해당하는 값을 등록 넣는다.
	        
	        Iterator<BaseModel> itBm  = insr1100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
	          
	          List<Record>  lsRec  = new ArrayList<Record>();
	          
	          while(itBm.hasNext()) {
	
	              Record rec  = new Record(itBm.next()); 
	              lsRec.add(rec);
	              
	          } 
	          setListRecord(lsRec.iterator()); 
	       
	          Iterator<Record> iterRecords = getListRecord();
	           
              List<Insr1200DTO> listInsr1200dto = new ArrayList<Insr1200DTO>();  
            
              while (iterRecords.hasNext()) {
          
                Record recData = (Record) iterRecords.next(); 
                BaseModel bmMapModel = (BaseModel)recData.getModel();
                  
                Insr1200DTO insr1200Dto = new Insr1200DTO();  
    	        
    	 		insr1200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")) );                           /** column 사업장코드 : dpobCd */
    	 		insr1200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));                     /** column SYSTEMKEY : systemkey */
    	 		insr1200Dto.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("soctyInsurCmptnDt")) );     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
    	 		insr1200Dto.setSocInsrAqtnEmymtNum((Long)bmMapModel.get("socInsrAqtnEmymtNum")); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
    	 		  
    	 		
    			insr1200Dto.setHlthInsrRegrstYn(hlthInsrRegrstYn.getValue());    /** column 건강보험신고여부 : hlthInsrRegrstYn */
    			insr1200Dto.setNatPennRegrstYn(natPennRegrstYn.getValue());    /** column 국민연금신고여부 : natPennRegrstYn */
    			insr1200Dto.setUmytInsrRegrstYn(umytInsrRegrstYn.getValue());   /** column 고용보험신고여부 : umytInsrRegrstYn */
    			insr1200Dto.setIdtlAccdtRegrstYn(idtlAccdtRegrstYn.getValue());  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
    		 	
    			//insr1200Dto.setSocnsrAqtnRegVal01(MSFSharedUtils.allowNulls(socnsrAqtnRegVal01.getValue()));    /** column 사회보험취득신고_ITEM_VALUE01 : socnsrAqtnRegVal01 */
    			insr1200Dto.setSocnsrAqtnRegVal02(MSFSharedUtils.allowNulls(socnsrAqtnRegVal02.getValue()));         /** column 성명 : socnsrAqtnRegVal02 */                                                                                       
    			insr1200Dto.setSocnsrAqtnRegVal03(MSFSharedUtils.allowNulls(socnsrAqtnRegVal03.getValue()));   /** column 주민등록번호 : socnsrAqtnRegVal03 */                                                                                   
    			insr1200Dto.setSocnsrAqtnRegVal04(MSFSharedUtils.allowNulls(socnsrAqtnRegVal04.getValue()));   /** column 국적 : socnsrAqtnRegVal04 */                                                                                       
    			insr1200Dto.setSocnsrAqtnRegVal05(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal05,"commCd") );   /** column 체류자격 : socnsrAqtnRegVal05 */                                                                                     
    			insr1200Dto.setSocnsrAqtnRegVal06(socnsrAqtnRegVal06.getValue());   /** column 대표자여부 : socnsrAqtnRegVal06 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal07((Long)socnsrAqtnRegVal07.getValue());   /** column 연금_소득월액 : socnsrAqtnRegVal07 */                                                                                  
    			insr1200Dto.setSocnsrAqtnRegVal08(socnsrAqtnRegVal08.getValue());   /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal09(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal09,"commCd"));   /** column 연금_취득부호 : socnsrAqtnRegVal09 */                                                                                  
    			insr1200Dto.setSocnsrAqtnRegVal10(GWTUtils.getStringFromDate(socnsrAqtnRegVal10.getValue(),"yyyyMMdd") );   /** column 연금_자격취득일 : socnsrAqtnRegVal10 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal11(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal11,"commCd") );   /** column 연금_특수직종 : socnsrAqtnRegVal11 */                                                                                  
    			insr1200Dto.setSocnsrAqtnRegVal12(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal12,"commCd") );   /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */                                                                                
    			insr1200Dto.setSocnsrAqtnRegVal13(MSFSharedUtils.allowNulls(socnsrAqtnRegVal13.getValue()));   /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal14(MSFSharedUtils.allowNulls(socnsrAqtnRegVal14.getValue()));   /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal15((Long)socnsrAqtnRegVal15.getValue());   /** column 건강_보수월액 : socnsrAqtnRegVal15 */                                                                                  
    			insr1200Dto.setSocnsrAqtnRegVal16( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal16,"commCd") );   /** column 건강_취득부호 : socnsrAqtnRegVal16 */                                                                                  
    			insr1200Dto.setSocnsrAqtnRegVal17(GWTUtils.getStringFromDate(socnsrAqtnRegVal17.getValue(),"yyyyMMdd")  );   /** column 건강_자격취득일 : socnsrAqtnRegVal17 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal18( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal18,"commCd") );   /** column 건강_감면 : socnsrAqtnRegVal18 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal19(socnsrAqtnRegVal19.getValue());   /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 */                                                                            
    			insr1200Dto.setSocnsrAqtnRegVal20( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal20,"commCd") );   /** column 건강_회계 : socnsrAqtnRegVal20 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal21( MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal21,"commCd") );   /** column 건강_직종 : socnsrAqtnRegVal21 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal22(GWTUtils.getStringFromDate(socnsrAqtnRegVal22.getValue(),"yyyyMMdd")  );   /** column 고용_자격취득일 : socnsrAqtnRegVal22 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal23(MSFSharedUtils.allowNulls(socnsrAqtnRegVal23.getValue())  );   /** column 고용_직종 : socnsrAqtnRegVal23 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal24((Double)socnsrAqtnRegVal24.getValue());   /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal25(socnsrAqtnRegVal25.getValue());   /** column 고용_계약직여부 : socnsrAqtnRegVal25 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal26( MSFSharedUtils.allowNulls(socnsrAqtnRegVal26.getValue()));   /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal27((Long)socnsrAqtnRegVal27.getValue());   /** column 고용_월평균보수 : socnsrAqtnRegVal27 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal28(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal28,"commCd") );   /** column 고용_비고 : socnsrAqtnRegVal28 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal29(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal29,"commCd") );   /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */                                                                             
    			insr1200Dto.setSocnsrAqtnRegVal30(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal30,"commCd") );   /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal31(GWTUtils.getStringFromDate(socnsrAqtnRegVal31.getValue(),"yyyyMMdd") );   /** column 산재_자격취득일 : socnsrAqtnRegVal31 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal32(MSFSharedUtils.allowNulls(socnsrAqtnRegVal32.getValue()) );   /** column 산재_직종 : socnsrAqtnRegVal32 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal33((Double)socnsrAqtnRegVal33.getValue());   /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal34(socnsrAqtnRegVal34.getValue());   /** column 산재_계약직여부 : socnsrAqtnRegVal34 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal35(MSFSharedUtils.allowNulls(socnsrAqtnRegVal35.getValue()));   /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */                                                                               
    			insr1200Dto.setSocnsrAqtnRegVal36((Long)socnsrAqtnRegVal36.getValue());   /** column 산재_월평균보수 : socnsrAqtnRegVal36 */                                                                                 
    			insr1200Dto.setSocnsrAqtnRegVal37(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal37,"commCd") );   /** column 산재_비고 : socnsrAqtnRegVal37 */                                                                                    
    			insr1200Dto.setSocnsrAqtnRegVal38(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal38,"commCd") );   /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */                                                                             
    			insr1200Dto.setSocnsrAqtnRegVal39(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal39,"commCd") );   /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */                                                                             
//    			insr1200Dto.setSocnsrAqtnRegVal40(MSFSharedUtils.allowNulls(socnsrAqtnRegVal40.getValue())); /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal41(MSFSharedUtils.allowNulls(socnsrAqtnRegVal41.getValue())); /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal42(MSFSharedUtils.allowNulls(socnsrAqtnRegVal42.getValue())); /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal43(MSFSharedUtils.allowNulls(socnsrAqtnRegVal43.getValue())); /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal44(MSFSharedUtils.allowNulls(socnsrAqtnRegVal44.getValue())); /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal45(MSFSharedUtils.allowNulls(socnsrAqtnRegVal45.getValue())); /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal46(MSFSharedUtils.allowNulls(socnsrAqtnRegVal46.getValue())); /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal47(MSFSharedUtils.allowNulls(socnsrAqtnRegVal47.getValue())); /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal48(MSFSharedUtils.allowNulls(socnsrAqtnRegVal48.getValue())); /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal49(MSFSharedUtils.allowNulls(socnsrAqtnRegVal49.getValue())); /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal50(MSFSharedUtils.allowNulls(socnsrAqtnRegVal50.getValue())); /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal51(MSFSharedUtils.allowNulls(socnsrAqtnRegVal51.getValue())); /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal52(MSFSharedUtils.allowNulls(socnsrAqtnRegVal52.getValue())); /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal53(MSFSharedUtils.allowNulls(socnsrAqtnRegVal53.getValue())); /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal54(MSFSharedUtils.allowNulls(socnsrAqtnRegVal54.getValue())); /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal55(MSFSharedUtils.allowNulls(socnsrAqtnRegVal55.getValue())); /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal56(MSFSharedUtils.allowNulls(socnsrAqtnRegVal56.getValue())); /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal57(MSFSharedUtils.allowNulls(socnsrAqtnRegVal57.getValue())); /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal58(MSFSharedUtils.allowNulls(socnsrAqtnRegVal58.getValue())); /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal59(MSFSharedUtils.allowNulls(socnsrAqtnRegVal59.getValue())); /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal60(MSFSharedUtils.allowNulls(socnsrAqtnRegVal60.getValue())); /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal61(MSFSharedUtils.allowNulls(socnsrAqtnRegVal61.getValue())); /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal62(MSFSharedUtils.allowNulls(socnsrAqtnRegVal62.getValue())); /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal63(MSFSharedUtils.allowNulls(socnsrAqtnRegVal63.getValue())); /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal64(MSFSharedUtils.allowNulls(socnsrAqtnRegVal64.getValue())); /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal65(MSFSharedUtils.allowNulls(socnsrAqtnRegVal65.getValue())); /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal66(MSFSharedUtils.allowNulls(socnsrAqtnRegVal66.getValue())); /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal67(MSFSharedUtils.allowNulls(socnsrAqtnRegVal67.getValue())); /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal68(MSFSharedUtils.allowNulls(socnsrAqtnRegVal68.getValue())); /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal69(MSFSharedUtils.allowNulls(socnsrAqtnRegVal69.getValue())); /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal70(MSFSharedUtils.allowNulls(socnsrAqtnRegVal70.getValue())); /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal71(MSFSharedUtils.allowNulls(socnsrAqtnRegVal71.getValue())); /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal72(MSFSharedUtils.allowNulls(socnsrAqtnRegVal72.getValue())); /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal73(MSFSharedUtils.allowNulls(socnsrAqtnRegVal73.getValue())); /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal74(MSFSharedUtils.allowNulls(socnsrAqtnRegVal74.getValue())); /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal75(MSFSharedUtils.allowNulls(socnsrAqtnRegVal75.getValue())); /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal76(MSFSharedUtils.allowNulls(socnsrAqtnRegVal76.getValue())); /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal77(MSFSharedUtils.allowNulls(socnsrAqtnRegVal77.getValue())); /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal78(MSFSharedUtils.allowNulls(socnsrAqtnRegVal78.getValue())); /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal79(MSFSharedUtils.allowNulls(socnsrAqtnRegVal79.getValue())); /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */                                                                    
//    			insr1200Dto.setSocnsrAqtnRegVal80(MSFSharedUtils.allowNulls(socnsrAqtnRegVal80.getValue())); /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */                                                                     
    			 
				  
    			listInsr1200dto.add(insr1200Dto); 
                 
             }   
	         
	  
//	 		insr2100Service.activityOnUpdatBatchInsr2100(listInsr1200dto ,
//	                new AsyncCallback<Long>() {
//	        public void onFailure(Throwable caught) {
//	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdatBatchInsr2100(Save) : " + caught), null);
//	        }
//	        public void onSuccess(Long result) {  
//	        	 if (result == 0) {
//                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//                          actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//                 // actionDatabase = ActionDatabase.INSERT;
//              } else {
//                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                          actionDatabase + "처리가 완료되었습니다.", null);
//                  reload();
//                  actionDatabase = ActionDatabase.UPDATE;
//              } 
//	        	
//	        	
//	        } 
//	        });
	        
}

//Insr2100Print	   
private void Insr2100Print(String fileName, String repType) {
	
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
	
	// 출력물 디렉토리 패스경로 인사 : PSNL
	String strDirPath = "INSR";
	// mrd 출력물
	String rdaFileName = fileName+".mrd";
	// 보낼 파라미터
		
		//검색조건
 	String serarchParam = "";
        
 	serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";      //$1
 	serarchParam += "["+InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd")+"]";    //$2
 	serarchParam += "["+InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd")+"]";    //$3
 	
   	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";    //$4
	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";            //$5
	serarchParam += "["+InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd") +"]";                 //$6
	serarchParam += "["+ InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")  +"]";          //$7   
    serarchParam += "[]"; //$8  
    serarchParam += "["+ InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd") +"]";         //$9 
    
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
    
	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";                  //$10
	serarchParam += "["+strHdofcCodtnCd+"]";                  //$11
	serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";                          //$12
    //serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
    //serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]";
    	
	//TODO 확인 
	if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
	
	    serarchParam += "[]";                                                            //$13
	    serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]";          //$14
	
	} else {
	    
    	//직종 권한에 대한 처리 추가 기본 처리  $9로해서 처리 할것...                                 //$13
//                if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                          && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//                    serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//                } else {
//                    serarchParam += "[]";
//                } 
        
        serarchParam += "[]";   //$14
	}
	String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
	Window.alert("strParam1>>"+strParam);
	//GWT 타입으로 팝업 호출시  postCall true 설정
	PrintUtils.setPostCall(true);
	PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
}
    	
private void RexPrint(String fileName) {

	printFileName = new String();
	printFileName = fileName;
	
	String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
	String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
	String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
	String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

	systemKeys = new String();
	systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
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

	if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
		if(emymtDivCd.equals("A0020010")){
		}else if(emymtDivCd.equals("A0020020")){
			if(deptCd == null || deptCd.equals("")){
				Window.alert("부서를 선택해 주세요");
				return;
			}	
			if(businCd == null || businCd.equals("")){	
				Window.alert("사업을 선택해 주세요");
				return;
			}
		}else{
			Window.alert("고용구분을 선택해 주세요");
			return;
		}
	}else{
		Window.alert("단위기관/고용구분을 선택해 주세요");
		return;
	}

	
	//그리드 선택 데이터 출력
	String checkedSystemKeys = "";
	int keyCnt = 0;
	List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();


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

	}else{
		systemKeys = "";
	}

	//인쇄시 마스터 업데이트
	
	BaseModel baseModel = new BaseModel();
	
	baseModel.set("soctyInsurCmptnDt01", GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd"));
	baseModel.set("soctyInsurCmptnDt02", GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd"));
	baseModel.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	baseModel.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	baseModel.set("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
	baseModel.set("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
	baseModel.set("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
	baseModel.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
	baseModel.set("systemkey", MSFSharedUtils.allowNulls(systemKeys));
	baseModel.set("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
	baseModel.set("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));		   
	baseModel.set("hdofcCodtnCd", strHdofcCodtnCd); 
	
	
	//Window.alert(strHdofcCodtnCd);
	
	actionDatabase = ActionDatabase.UPDATE;
	insr2100Service.activityOnUpdateInsr1200(baseModel,  new AsyncCallback<Long>() {

		public void onFailure(Throwable caught) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
					MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateInsr2100(Save) : " + caught), null);
		}
		public void onSuccess(Long result) {  
			if (result == 0) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
			} else {
				//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
				RexPrint2(printFileName);
				
			} 
		} 
	});
}

//rex 
private void RexPrint2(String fileName) {
	
	// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR // 보험 : INSR
	String strDirPath = "INSR";
	// mrd 출력물
	String rexFileName = fileName+".crf";
	// 보낼 파라미터  
    // 검색조건
 	String serarchParam = "";
  
 /*	serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";          //$1
 	
 	
 	
 	serarchParam += ""+InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd")+"⊥";    //$2
 	serarchParam += ""+InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd")+"⊥";    //$3
   	serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";    //$4
	serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";            //$5
	serarchParam += ""+InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd") +"⊥";                 //$6
	serarchParam += ""+ InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")  +"⊥";          //$7   
    serarchParam += ""+ InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd") +"⊥";         //$8 
*/    
    
    

	String soctyInsurCmptnDt01 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd");
	String soctyInsurCmptnDt02 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd");
	String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
	String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
	String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
	String typOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
	String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
	String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
	String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
	String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue());
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
    
	String deptCdAuth = MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
	String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "");
  
	   
	if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)){

		//도장 출력을 위해 추가 2014-11-06 //$9
		String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
		if(MSFSharedUtils.paramNull(myImgUrl)) {
			// myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력 
		}	
	
	
		serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";//$1
		serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt01)+"⊥";	//$2			
		serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt02)+"⊥";	//$3			
		serarchParam += ""+MSFSharedUtils.allowNulls(payrMangDeptCd)+"⊥";		//$4
		serarchParam += ""+MSFSharedUtils.allowNulls(emymtDivCd)+"⊥";		//$5
		serarchParam += ""+MSFSharedUtils.allowNulls(deptCd)+"⊥";			//$6	
		serarchParam += ""+MSFSharedUtils.allowNulls(typOccuCd)+"⊥";			//$7
		serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCd)+"⊥";			 //$8
		serarchParam += ""+MSFSharedUtils.allowNulls(businCd)+"⊥";   //$9
		
		serarchParam += ""+MSFSharedUtils.allowNulls(systemKeys)+"⊥";	//$10
		serarchParam += ""+MSFSharedUtils.allowNulls(hanNm)+"⊥";		//$11
		serarchParam += ""+MSFSharedUtils.allowNulls(resnRegnNum)+"⊥";		//$12	
		serarchParam += ""+MSFSharedUtils.allowNulls(strHdofcCodtnCd)+"⊥";		//$13				 			        

		//20151212-변경추가 시작 
		serarchParam += ""+MSFMainApp.get().getUser().getUsrId()+"⊥";  //$14 //유우져 아이디 넘김 
		serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$15

		//권한처리를위해 넘기는 변수 2개추가 
		serarchParam += ""+deptCdAuth+"⊥"; //$16 부서 
		serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; //$17 직종세 
		//20151212-추가 끝 
		serarchParam += ""+MSFSharedUtils.allowNulls(myImgUrl)+"⊥"; //$18
		
		
		
	   
	//serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";                  //$9
	//serarchParam += ""+strHdofcCodtnCd+"⊥";                  //$10
	//serarchParam += ""+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"⊥";                          //$11
    //serarchParam += ""+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"⊥"; //$12
    //serarchParam += ""+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"⊥"; //$13
    	
	//TODO 확인 
	//if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
	//    serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥";          //$14
	//} else {
    //    serarchParam += "⊥";   //$15
	//}
	
	//if ( !MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd").equals("") ) {
	//serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd").substring(0,4)+"⊥";                  //$16
	//}
	
	
	
	
	
	
	
	String strParam = "" + serarchParam; //+"["+checkedSystemKeys+"]"; 
	
	//GWT 타입으로 팝업 호출시  postCall true 설정
	PrintUtils.setPostCall(true);
	PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
	}else{
		MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
	}
}
  
//getViewPanel
public ContentPanel getViewPanel(){
      if(panel == null){
           
    	  initLoad();
			
          detailTp = XTemplate.create(getDetailTemplate()); 
          
          vp = new VerticalPanel();
          vp.setSpacing(10);
          createInsr2100Form();  //화면 기본정보를 설정
          createSearchForm();    //검색필드를 적용 
          createForm();          //기본정보필드  
          
          //엣지변환
          //vp.setSize("1010px", "750px");
          vp.setSize("1010px", "800px");
              
          funcButtonEnabled(false); 
          
          panel = new ContentPanel();
          panel.setBodyBorder(false);
          panel.setBorders(false);
          panel.setHeaderVisible(false);
          panel.setScrollMode(Scroll.AUTO);  
          panel.add(vp);
          
          
      }
      return panel;
  }

public Insr2100() {
	//엣지변환
	//setSize("1010px", "750px");  
	setSize("1010px", "800px");  
} 

public Insr2100(String txtForm) {
      this.txtForm = txtForm;
}

//createInsr2100Form
private void createInsr2100Form() {
    
    plFrmInsr2100 = new FormPanel();
   
   // plFrmInsr2100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Remt0100());
    plFrmInsr2100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 사회보험취득신고"));
    plFrmInsr2100.setIcon(MSFMainApp.ICONS.text());
    //plFrmInsr2100.setBodyStyleName("pad-text");
    plFrmInsr2100.setPadding(2);
    plFrmInsr2100.setFrame(true); 
    

	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	final Button btnlogView = new Button("로그");   
	
	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //로그 뷰화면 호출 메서드 
			  funcLogMessage("사회보험취득신고","INSR2100");
			}
		});
	plFrmInsr2100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	plFrmInsr2100.getHeader().addTool(btnlogView); 
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 
	 ************************************************************************/

  
	   //멀티콤보박스 닫기 
    plFrmInsr2100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
        @Override
        public void handleEvent(ComponentEvent ce) { 
        
         //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                
        //        if (f instanceof MSFMultiComboBox<?>) {
                    
//                    if ("srhDeptCd".equals(f.getName())) {
//                        
//                    } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                        
//                    }
                    
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
    
    
    
	 topInsr2100Bar = new ButtonBar();    
	 topInsr2100Bar.setAlignment(HorizontalAlignment.RIGHT);
 
	      
    //초기화 
      btnInsr2100Init = new Button("초기화");  
      btnInsr2100Init.setIcon(MSFMainApp.ICONS.new16());
      topInsr2100Bar.add(btnInsr2100Init);
      btnInsr2100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
          public void handleEvent(ButtonEvent e) {
              //초기화 버튼 클릭시 처리  
        	  formInit();
          }
      });
	      
   //신규 
    btnInsr2100New = new Button("대상자선택");  
    btnInsr2100New.setIcon(MSFMainApp.ICONS.new16());
    topInsr2100Bar.add(btnInsr2100New);
    btnInsr2100New.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	fnPopupInsr2100();   
        }
    });
    //저장 -수정 동시 처리 부분으로 나뉨 
    btnInsr2100Save = new Button("저장");  
    btnInsr2100Save.setIcon(MSFMainApp.ICONS.save16());
    topInsr2100Bar.add(btnInsr2100Save); 
    btnInsr2100Save.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	actionDatabase = ActionDatabase.UPDATE;   	
            doAction(actionDatabase); 
        }
    });
   
    //삭제       
    btnInsr2100Del = new Button("삭제");  
    btnInsr2100Del.setIcon(MSFMainApp.ICONS.delete16());
    topInsr2100Bar.add(btnInsr2100Del);
    btnInsr2100Del.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	Iterator<BaseModel> itBm  = insr1100GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
    		
    		List<Record>  lsRec  = new ArrayList<Record>();
    		
    		while(itBm.hasNext()) {
    			Record rec  = new Record(itBm.next()); 
    			lsRec.add(rec);
    		} 
    		setListRecord(lsRec.iterator()); 
              
            actionDatabase = ActionDatabase.DELETE;
            doAction(actionDatabase);
        }
    });
    
  
  	btnInsr2100Sreach = new Button("조회"); 
  	btnInsr2100Sreach.setIcon(MSFMainApp.ICONS.search16());
  	topInsr2100Bar.add(btnInsr2100Sreach);
  	btnInsr2100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			//조회버튼 클릭시 처리
			detailClear();
		    reload();  
		    dpobInfoSearch();
		}
	});
  	
  
  	
  	btnInsr2100Print = new Button("인쇄"); 
  	btnInsr2100Print.setIcon(MSFMainApp.ICONS.print16());
  	topInsr2100Bar.add(btnInsr2100Print);
  	btnInsr2100Print.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			Insr2100Print("INSRT2100",MSFMainApp.getMsg("PayGen.ReportDivisionType"));
		}
	});
  	
	btnInsr2100ExcelFile = new Button("자격취득통합파일"); 
  	btnInsr2100ExcelFile.setIcon(MSFMainApp.ICONS.excel16());
  	topInsr2100Bar.add(btnInsr2100ExcelFile);
  	btnInsr2100ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			excelFileExport("all");
		}
	});
  	
  	btnInsr1550ExcelFile = new Button("피부양자"); 
  	btnInsr1550ExcelFile.setIcon(MSFMainApp.ICONS.excel16());
  	topInsr2100Bar.add(btnInsr1550ExcelFile);
  	btnInsr1550ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			excelFile1550Export();
		}
	});
 
  	plFrmInsr2100.add(topInsr2100Bar);   
    
    //파일업로드 처리
    plFrmInsr2100.setAction("myurl");
    plFrmInsr2100.setEncoding(Encoding.MULTIPART);
    plFrmInsr2100.setMethod(Method.POST);
     
        
    vp.add(plFrmInsr2100);
    //엣지변환
    //plFrmInsr2100.setSize("990px", "730px");
    plFrmInsr2100.setSize("990px", "780px");
  }
   
//createSearchForm
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
	 
	 //단위기관 불러 오는 함수 
	 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	 
	 //재직상태  
	 sysComBass0300Dto.setRpsttvCd("A003");
	 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
         public void handleEvent(StoreEvent<BaseModel> be) {  
             mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
             srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
             
         }
     });   

	 //고용구분
	 sysComBass0300Dto.setRpsttvCd("A002");
	 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	 sysComBass0300Dto.setRpsttvCd("A048");
	 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	//--------------------급여년도 불러 오는 함수 ------------------------------------------------
    lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);

    //월
	 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);

	
	 //-------------------관리부서 추가  
	 sysComBass0400Dto.setDeptDspyYn("Y");
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
//    		  ContentPanel typOccuCdGrid = new ContentPanel();  
//    		  typOccuCdGrid.setVisible(false);
//    		    
//    		    //직종 콤보처리 
//    		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//    		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//    			       public void handleEvent(ComponentEvent be) {  
//    			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//    			          public void handleEvent(StoreEvent<BaseModel> be) {  
//    			        	  
//    			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//    			        	mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//                           srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//    			          }  
//    			        });  
//    			       
//    			      }  
//    			    });  
//    	  
//    		 typOccuCdGrid.add(typOccuCdGridPanel); 
//    		plFrmInsr2100.add(typOccuCdGrid); 
		 
	 /**
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  * 년도 콤보박스 처리  시작
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
  */
// 		   ContentPanel payYrGrid = new ContentPanel();  
// 		   payYrGrid.setVisible(false);
// 		    
// 		   //년도 콤보처리 
// 		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
// 		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
// 			       public void handleEvent(ComponentEvent be) {  
// 			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
// 			          public void handleEvent(StoreEvent<BaseModel> be) {  
// 			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
// 			        	 
// 			        	//  Date today = new Date(); 
// 			        	    // A custom date format
// 			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
// 			        	 
// 			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
// 			      	     // srhPayYr.setValue(bm);
// 			        	srhPayYr.setValue(lsPayYrStore.getAt(0));
// 			        	Date today = new Date(); 
//                       DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                       srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                  
// 			          }  
// 			        });  
// 			       
// 			      }  
// 			    });  
// 	  
// 		payYrGrid.add(payYrGridPanel); 
// 		plFrmInsr2100.add(payYrGrid); 

 
   plFrmInsr2100.setLayout(new FlowLayout());
   
   srhSystemkey = new HiddenField<String>(); 
     
   LayoutContainer lcSchCol = new LayoutContainer();
   //lcSchCol.setStyleAttribute("background-color","red");
   lcSchCol.setLayout(new ColumnLayout());  
   FieldSet fieldSet = new FieldSet();  
   fieldSet.setHeadingHtml("검색조건");  
   /****************************************************************
	 * 검색조건 배경 변경 스타일쉬트 추가 시작
	 ****************************************************************/
	fieldSet.addStyleName("x-fieldset-serarch-back-color");
	/****************************************************************
	 * 검색조건 배경 변경 스타일쉬트 추가 끝
	 ****************************************************************/
  // fieldSet.setCheckboxToggle(false); 
   
   LayoutContainer lcSchLeft = new LayoutContainer();
 //  lcSchLeft.setStyleAttribute("paddingRight", "10px");
   lcSchLeft.setLayout(new ColumnLayout());

   fieldSet.add(lcSchCol, new FormData("100%"));  
   
   LayoutContainer layoutContainer_8 = new LayoutContainer();
   FormLayout frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_8.setLayout(frmlytSch);
     
   
   
   srhSoctyInsurCmptnDt01 = new DateField();
   srhSoctyInsurCmptnDt01.setName("soctyInsurCmptnDt01");
   new DateFieldMask(srhSoctyInsurCmptnDt01, "9999.99.99"); 
   srhSoctyInsurCmptnDt01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
   srhSoctyInsurCmptnDt01.setFieldLabel("취득기간");
 //  srhSoctyInsurCmptnDt01.setValue(value); 
   
   layoutContainer_8.add(srhSoctyInsurCmptnDt01, new FormData("100%"));
   lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
   layoutContainer_8.setBorders(false);
   
   LayoutContainer layoutContainer_9 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(10); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_9.setLayout(frmlytSch);
   
   srhSoctyInsurCmptnDt02 = new DateField();
   srhSoctyInsurCmptnDt02.setName("srhSoctyInsurCmptnDt02");
   new DateFieldMask(srhSoctyInsurCmptnDt02, "9999.99.99"); 
   srhSoctyInsurCmptnDt02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
   srhSoctyInsurCmptnDt02.setLabelSeparator("~");
   
   layoutContainer_9.add(srhSoctyInsurCmptnDt02, new FormData("100%"));
   lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
   layoutContainer_9.setBorders(false);

   
   
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
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("PayrMangDeptCd", lsPayrMangDeptCd ); 
        	 } 
           
       }
   });    
   srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
       public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
           
    	   sysComBass0400Dto = new PrgmComBass0400DTO(); 
    	   srhDeptCd.reset();
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
   
   
   LayoutContainer layoutContainer_1 = new LayoutContainer();
   layoutContainer_1.setLayout(new ColumnLayout());
   
   LayoutContainer layoutContainer_101 = new LayoutContainer();

   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_101.setLayout(frmlytSch);
   
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
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("EmymtDivCd", lsEmymtDivCd ); 
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
             } else {
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
   layoutContainer_101.add(srhEmymtDivCd, new FormData("100%"));
   layoutContainer_101.setBorders(false); 
   
   
   LayoutContainer layoutContainer_102 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(1); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   frmlytSch.setDefaultWidth(0);
   layoutContainer_102.setLayout(frmlytSch);
   
   
   
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

//       	  EventType type = be.getType();
//	    	   if (type == Store.Add) { 
//           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//           	 }  
         
       }
   });  
   
   layoutContainer_102.add(srhRepbtyBusinDivCd, new FormData("100%"));
   layoutContainer_102.setBorders(false); 
   
   
   layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
   layoutContainer_1.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
   layoutContainer_1.setBorders(false); 
   
   lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
   lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
   //lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
   
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

          // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
    	   EventType type = be.getType();
    	   if (type == Store.Add) { 
        		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("DeptCd", lsDeptCd ); 
        	 }
       }
   });    

   srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
      @Override
     public void handleEvent(ComponentEvent ce) { 
              
                 if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                    
                     if (srhDeptCd.getListView().getChecked().size() > 0) {  
                        
                         sysComBass0500Dto.setBusinApptnYr(GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyy"));    
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
//        BaseModel bmPayCd =  se.getSelectedItem(); 
//        if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//            if (bmPayCd != null) {  
//               
//                sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//                sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//            }      
//         
//            //--------------------사업 불러 오는 함수 -------------------------------------------------
//              lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//             //--------------------사업 불러 오는 함수 -------------------------------------------------
//              srhBusinCd.setStore(lsBusinCd); 
//              srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                  public void handleEvent(StoreEvent<BaseModel> be) {  
//                   //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                  }
//              });    
//        
//        }  
       
       } 
   });
   //검색 소속부서 코드 처리  
//   LayoutContainer lccmlcDeptNm = new LayoutContainer();
//   lccmlcDeptNm.setLayout(new ColumnLayout());
//      //부서 
//   srhDeptCd = new MSFTextField();
//   srhDeptCd.setName("srhDeptCd");
//   srhDeptCd.setVisible(false);
//   srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//       @Override
//       public void handleEvent(BaseEvent be) { 
//         if(srhDeptCd.getValue() != null){ 
//            
//                 PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//                 sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
//                 sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//             
//               //--------------------사업 불러 오는 함수 -------------------------------------------------
//                 lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                 srhBusinCd.setStore(lsBusinCd); 
//                 srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                     public void handleEvent(StoreEvent<BaseModel> be) {  
//                      //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                     }
//                 });    
//            
//         } 
//       }
//    });
//   plFrmInsr2100.add(srhDeptCd);
//   srhMangeDeptCd = new MSFTextField();
//   srhMangeDeptCd.setName("srhMangeDeptCd");
//   srhMangeDeptCd.setVisible(false);
//   plFrmInsr2100.add(srhMangeDeptCd);
//   srhMangeDeptNm = new MSFTextField();
//   srhMangeDeptNm.setName("srhMangeDeptNm");
//   srhMangeDeptNm.setVisible(false);
//   plFrmInsr2100.add(srhMangeDeptNm);
//  
//    LayoutContainer lcDeptNm = new LayoutContainer(); 
//    frmlytSch = new FormLayout();
//    frmlytSch.setLabelWidth(70);
//    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//    lcDeptNm.setLayout(frmlytSch);
// 
//    srhDeptNm = new MSFTextField();
//    srhDeptNm.setName("srhDeptNm");
//    srhDeptNm.setFieldLabel("부서");  
//    srhDeptNm.addKeyListener(new KeyListener() {
//         public void componentKeyUp(ComponentEvent event) {
//             super.componentKeyUp(event); 
//             if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                 if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                     srhDeptCd.setValue("");
//                     srhMangeDeptCd.setValue("");
//                 }
//                 fnPopupCommP140(srhDeptNm.getValue());
//             }
//         }
//     });
//    
//    srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//               @Override
//               public void handleEvent(BaseEvent be) { 
//                    
//                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                       srhDeptCd.setValue("");
//                       srhMangeDeptCd.setValue("");
//                   }
//                
//               } 
//      });        
//     lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//     
//      btnSrhDeptCd = new Button();
//      btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//      btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//          public void handleEvent(ButtonEvent e) { 
//              if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                  srhDeptCd.setValue("");
//                  srhMangeDeptCd.setValue("");
//              }
//              fnPopupCommP140(srhDeptNm.getValue()); 
//          }
//      });
//       
//      lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//      lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
        
   layoutContainer_2.add(srhDeptCd, new FormData("100%"));
   layoutContainer_2.setBorders(false);
   
   LayoutContainer layoutContainer_10 = new LayoutContainer();

   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_10.setLayout(frmlytSch);
   
//   srhTypOccuCd =  new ComboBox<BaseModel>(); 
//   srhTypOccuCd.setName("srhTypOccuCd");
//   srhTypOccuCd.setForceSelection(true);
//   srhTypOccuCd.setMinChars(1);
//   srhTypOccuCd.setDisplayField("typOccuNm");
//   srhTypOccuCd.setValueField("typOccuCd");
//   srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//   srhTypOccuCd.setEmptyText("--직종선택--");
//   srhTypOccuCd.setSelectOnFocus(true); 
//   srhTypOccuCd.setReadOnly(false);
//   srhTypOccuCd.setEnabled(true); 
//   srhTypOccuCd.setStore(lsTypOccuCd);
//   srhTypOccuCd.setFieldLabel("직종");
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
   
   
   
   
   LayoutContainer layoutContainer_21 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(1); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   frmlytSch.setDefaultWidth(0);
   layoutContainer_21.setLayout(frmlytSch); 
   
   

   
   
   
   
   layoutContainer_20.add(srhDeptGpCd, new FormData("100%")); 
   
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
              // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
        		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	//checkInsr2100Auth("TypOccuCd", lsTypOccuCd ); 
    		   }
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
   
   
   lcTypOccuCd.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
   lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
   lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
   layoutContainer_21.setBorders(false);
   
   layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
   layoutContainer_10.setBorders(false);
   
   
   fieldSet.add(layoutContainer_13);
   layoutContainer_13.setBorders(false);
   
//   LayoutContainer layoutContainer_3 = new LayoutContainer();
//   layoutContainer_3.setLayout(new ColumnLayout());
//   
//  
//    
//   fieldSet.add(layoutContainer_3);
//   layoutContainer_3.setBorders(false);
   
   layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
   layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
   //layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
   
   
   
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
//   srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//       @Override
//       public void handleEvent(BaseEvent be) {  
//           if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//               srhSystemkey.setValue("");
//               srhResnRegnNum.setValue("");
//           }
//        
//       } 
//  }); 
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
   
   

   LayoutContainer layoutContainer_14 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   layoutContainer_14.setLayout(frmlytSch);
   
   srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
   srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
//   srhHdofcCodtnCd.setForceSelection(true);
//   srhHdofcCodtnCd.setMinChars(1);
//   srhHdofcCodtnCd.setDisplayField("commCdNm");
//   srhHdofcCodtnCd.setValueField("commCd");
  // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
   srhHdofcCodtnCd.setEmptyText("--재직선택--");
//   srhHdofcCodtnCd.setSelectOnFocus(true); 
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
    	   checkInsr2100Auth("srhHdofcCodtnCd",lsHdofcCodtnCd); 
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
  
   
   layoutContainer_14.add(srhHdofcCodtnCd, new FormData("100%"));
   layoutContainer_14.setBorders(false);
   
   fieldSet.add(lcSchCol3);
   lcSchCol3.setBorders(false);
   
   lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
   lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
   
   plFrmInsr2100.add(fieldSet); 
	 
    //vp.add(panel);   
  }  

//displayDtilOccuInttnCd
private void  displayDtilOccuInttnCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        
        //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
            
            sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
            List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
            String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
            
           // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
            
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                
                lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
              //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                
                lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                    public void handleEvent(StoreEvent<BaseModel> be) {  
                        mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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

//
private void createForm() {
	
	dpobCd = new HiddenField<String>();   /** column 사업장코드 : dpobCd */
	systemkey = new HiddenField<String>();   /** column SYSTEMKEY : systemkey */
	soctyInsurCmptnDt = new HiddenField<String>();   /** column 작성일자 : 작성일자 */
	
	
	socInsrAqtnEmymtNum = new HiddenField<Long>();   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	cellPhneNum = new HiddenField<String>();   /** column cellPhneNum : cellPhneNum */
	socnsrAqtnRegVal04 = new HiddenField<String>();    /** column 국적 : socnsrAqtnRegVal04 popup */
	socnsrAqtnRegVal23 = new HiddenField<String>();    /** column 고용_직종 : socnsrAqtnRegVal23 팝업 */
	socnsrAqtnRegVal32 = new HiddenField<String>();    /** column 산재_직종 : socnsrAqtnRegVal32 */
	
	socnsrAqtnRegVal13 = new HiddenField<String>();     /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
	socnsrAqtnRegVal14 = new HiddenField<String>();    /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */	
	
	
	 sysComBass0300Dto.setRpsttvCd("I004"); 
	 lsSocnsrAqtnRegVal05 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 체류자격 : socnsrAqtnRegVal05 */
	 sysComBass0300Dto.setRpsttvCd("I015"); 
	 lsSocnsrAqtnRegVal09 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
	 sysComBass0300Dto.setRpsttvCd("I016"); 
	 lsSocnsrAqtnRegVal11 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 연금_특수직종 : socnsrAqtnRegVal11 */
	 sysComBass0300Dto.setRpsttvCd("I025"); 
	 lsSocnsrAqtnRegVal12 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
	 sysComBass0300Dto.setRpsttvCd("I005"); 
	 lsSocnsrAqtnRegVal16 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
	 sysComBass0300Dto.setRpsttvCd("I007"); 
	 lsSocnsrAqtnRegVal18 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 건강_감면 : socnsrAqtnRegVal18 */
	 sysComBass0300Dto.setRpsttvCd("I008"); 
	 lsSocnsrAqtnRegVal20 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 건강_회계 : socnsrAqtnRegVal20 */
	 sysComBass0300Dto.setRpsttvCd("I009"); 
	 lsSocnsrAqtnRegVal21 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 건강_직종 : socnsrAqtnRegVal21 */
	 sysComBass0300Dto.setRpsttvCd("I026"); 
	 lsSocnsrAqtnRegVal28 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 고용_비고 : socnsrAqtnRegVal28 */
	 sysComBass0300Dto.setRpsttvCd("I017"); 
	 lsSocnsrAqtnRegVal29 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
	 sysComBass0300Dto.setRpsttvCd("I018"); 
	 lsSocnsrAqtnRegVal30 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
	 sysComBass0300Dto.setRpsttvCd("I026"); 
	 lsSocnsrAqtnRegVal37 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 산재_비고 : socnsrAqtnRegVal37 */
	 sysComBass0300Dto.setRpsttvCd("I017"); 
	 lsSocnsrAqtnRegVal38 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
	 sysComBass0300Dto.setRpsttvCd("I018"); 
	 lsSocnsrAqtnRegVal39 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
	 
    LayoutContainer layoutContainer = new LayoutContainer();   

    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false); 
    cp01.setSize(975, 445);
    cp01.setLayout(new FitLayout());
    
    LayoutContainer layoutContainer_16 = new LayoutContainer(); 
   
    layoutContainer_16.setLayout(new ColumnLayout());
    //layoutContainer_16.setBorders(true);  
    
    LayoutContainer layoutContainer_1 = new LayoutContainer(); 
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_1.setLayout(frmlytStd); 
    
    FieldSet fldstNewFieldset = new FieldSet();
 //   fldstNewFieldset.setSize("480px", "475px");
 
    layoutContainer_1.add(fldstNewFieldset,new FormData("100%"));
    
    fldstNewFieldset.setHeadingHtml("대상자정보");
    fldstNewFieldset.setCollapsible(false);
    layoutContainer_16.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49)); 
    
    fldstNewFieldset.add(leftGrid01(),new FormData("100%"));
    
    LayoutContainer layoutContainer_2 = new LayoutContainer(); 
   // layoutContainer_16.setStyleAttribute("padding", "5px");
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd);
    //layoutContainer_2.setBorders(true);
    
    FieldSet fldstNewFieldset_1 = new FieldSet();  
    fldstNewFieldset_1.setHeadingHtml("기본정보");
    fldstNewFieldset_1.setCollapsible(false);
  //  fldstNewFieldset_1.setSize("480px", "475px");
    fldstNewFieldset_1.add(rightForm01(),new FormData("100%")); 
     
    layoutContainer_2.add(fldstNewFieldset_1,new FormData("100%"));  
    
    layoutContainer_16.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.51)); 
    

	LabelField lb_1 = new LabelField("신고구분");
	lb_1.setStyleAttribute("padding-top", "5px");
	lb_1.setStyleAttribute("text-align", "center");
	lb_1.setStyleAttribute("vertical-align", "middle");  
	LabelField lb_2 = new LabelField("전체");
	lb_2.setStyleAttribute("padding-top", "5px");
	LabelField lb_3 = new LabelField("국민");
	lb_3.setStyleAttribute("padding-top", "5px");
	LabelField lb_4 = new LabelField("건강"); 
	lb_4.setStyleAttribute("padding-top", "5px");
	LabelField lb_5 = new LabelField("고용");
	lb_5.setStyleAttribute("padding-top", "5px");
	LabelField lb_6 = new LabelField("산재");
	lb_6.setStyleAttribute("padding-top", "5px");
	
	gridAllCheckbox = new Button();
	gridAllCheckbox.setIcon(MSFMainApp.ICONS.allExec()); 
	gridAllCheckbox.addListener(Events.Select, new Listener<ButtonEvent>() {
	    public void handleEvent(ButtonEvent e) {
	    	MessageBox.confirm("신고구분", "신고구분 선택을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
	    		@Override
	    		public void handleEvent(MessageBoxEvent be) {
	    			//if("Yes".equals(be.getButtonClicked().getText())){
	    			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	    				updateInsr2100AllGridBatch("VAL01");
	    			}
	    		}
	    	}); 
	    }
	  });
	
	allCheck = new MSFCheckBox();
	allCheck.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			if(allCheck.getValue()){
				natPennRegrstYn.setValue(true);
				hlthInsrRegrstYn.setValue(true);
				umytInsrRegrstYn.setValue(true);
				idtlAccdtRegrstYn.setValue(true);
			}else{
				natPennRegrstYn.setValue(false);
				hlthInsrRegrstYn.setValue(false);
				umytInsrRegrstYn.setValue(false);
				idtlAccdtRegrstYn.setValue(false);
			}
		}
	});
	natPennRegrstYn = new MSFCheckBox();
	natPennRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			//checkBoxCheck(chkbox_2, chkbox_3, chkbox_4, chkbox_5);
		}
	});
	hlthInsrRegrstYn = new MSFCheckBox();
	hlthInsrRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			//checkBoxCheck(chkbox_2, chkbox_3, chkbox_4, chkbox_5);
		}
	});
	umytInsrRegrstYn = new MSFCheckBox();
	umytInsrRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			//checkBoxCheck(chkbox_2, chkbox_3, chkbox_4, chkbox_5);
		}
	});
	idtlAccdtRegrstYn = new MSFCheckBox();
	idtlAccdtRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			//checkBoxCheck(chkbox_2, chkbox_3, chkbox_4, chkbox_5);
		}
	});
	
	   FieldSet fldstNewFieldset_21 = new FieldSet(); 
	     
	    layoutContainer_2.add(fldstNewFieldset_21); 
	    fldstNewFieldset_21.setHeadingHtml("");
	    fldstNewFieldset_21.setCollapsible(false);
	    
	    
	LayoutContainer layoutContainer_14= new LayoutContainer(new ColumnLayout());
	layoutContainer_14.setStyleAttribute("vertical-align", "middle");  
	layoutContainer_14.add(lb_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.20) ); 
	layoutContainer_14.add(allCheck, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );
	layoutContainer_14.add(lb_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.07) ); 
	layoutContainer_14.add(natPennRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );
	layoutContainer_14.add(lb_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) ); 
	layoutContainer_14.add(hlthInsrRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );
	layoutContainer_14.add(lb_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	layoutContainer_14.add(umytInsrRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );
	layoutContainer_14.add(lb_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	layoutContainer_14.add(idtlAccdtRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );
	layoutContainer_14.add(lb_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	
	layoutContainer_14.add(gridAllCheckbox, new FormData("40%")); 
	
	/*
	btnSocnsrAqtnRegVal07 = new Button();  
    btnSocnsrAqtnRegVal07.setWidth("25px");
    btnSocnsrAqtnRegVal07.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal07.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
            //data에 값넣기 
        	Window.alert("일괄적용버튼");
       	 //fnPopupBass0300("I001"); 
        }
    }); 
    layoutContainer1_1.add(btnSocnsrAqtnRegVal07,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));  
    layoutContainer1_2.add(layoutContainer1_1, new FormData("100%"));
	*/
	
	layoutContainer_14.setBorders(true);
    fldstNewFieldset_21.add(layoutContainer_14,new FormData("100%")); 
    
    
    ContentPanel cp02 = new ContentPanel();
    cp02.setHeaderVisible(false); 
    cp02.setSize(498, 285);
    cp02.setLayout(new FitLayout());
    cp02.setScrollMode(Scroll.AUTOY);  
    
      LayoutContainer layoutContainer_21 = new LayoutContainer();
      layoutContainer_21.setSize("493px", "285px");
    
//	    FieldSet fldstNewFieldset_2 = new FieldSet(); 
//	     
//	    layoutContainer_21.add(fldstNewFieldset_2);
//	    fldstNewFieldset_2.setWidth("450px"); //, "274px");
//	    fldstNewFieldset_2.setHeadingHtml("국민연금");
//	    fldstNewFieldset_2.setCollapsible(false);
//	    
//	    fldstNewFieldset_2.add(rightFormBottom01(),new FormData("100%")); 
//	    
//	    FieldSet fldstNewFieldset_22 = new FieldSet(); 
//	     
//	    layoutContainer_21.add(fldstNewFieldset_22);
//	    fldstNewFieldset_22.setWidth("450px");  //.setSize("398px", "274px");
//	    fldstNewFieldset_22.setHeadingHtml("건강보험");
//	    fldstNewFieldset_22.setCollapsible(false);
//	    
//	    fldstNewFieldset_22.add(rightFormBottom02(),new FormData("100%")); 
//	    
//	    FieldSet fldstNewFieldset_23 = new FieldSet(); 
//	    
//	    layoutContainer_21.add(fldstNewFieldset_23);
//	    fldstNewFieldset_23.setWidth("450px"); //.setSize("398px", "274px");
//	    fldstNewFieldset_23.setHeadingHtml("고용/산재보험");
//	    fldstNewFieldset_23.setCollapsible(false);
//	    
//	    fldstNewFieldset_23.add(rightFormBottom03(),new FormData("100%")); 
    
       TabPanel tabPanel = new TabPanel(); 
	    //tabsPsnl.setMinTabWidth(80);   
	    tabPanel.setAutoWidth(false);
	   
	   // tabsPsnl.setResizeTabs(true);   
	    tabPanel.setAnimScroll(true);   
	    tabPanel.setTabScroll(true); 
	    tabPanel.setPlain(true);   
	    tabPanel.setSize(495, 280);    
	    
	    //1.국민연금
	    TabItem tabitem01 = new TabItem("국민연금"); 
	    tabitem01.setStyleAttribute("padding", "4px");
	    tabitem01.add(rightFormBottom01());
	    tabPanel.add(tabitem01);
	    tabitem01.setSize("495", "280");
	    
	    //2.건강보험
	    TabItem tabitem02 = new TabItem("건강보험");
	    tabitem02.setStyleAttribute("padding", "4px");
	    tabitem02.add(rightFormBottom02()); 
	    tabPanel.add(tabitem02);
	    tabitem02.setSize("492", "279"); 
	    
	    //3.고용보험/산재보험
	    TabItem tabitem03 = new TabItem("고용보험");
	    tabitem03.setStyleAttribute("padding", "4px");
	    tabitem03.add(rightFormBottom03()); 
	    tabPanel.add(tabitem03);
	    tabitem03.setSize("492", "279");
	    tabPanel.setHeight("285");
	    
	    //3.고용보험/산재보험
	    TabItem tabitem04 = new TabItem("산재보험");
	    tabitem04.setStyleAttribute("padding", "4px");
	    tabitem04.add(rightFormBottom04()); 
	    tabPanel.add(tabitem04);
	    tabitem04.setSize("492", "279");
	    tabPanel.setHeight("285");
	    
	     
	    layoutContainer_21.add(tabPanel);  
	    
	    cp02.add(layoutContainer_21); 
	    
	    layoutContainer_2.add(cp02) ;   

	 //    layoutContainer_16.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45)); 
	 //    layoutContainer_16.setSize("934", "424");
 
     cp01.add(layoutContainer_16); 

	 
     layoutContainer.add(cp01) ;    
       
     
   	 FieldSet subFieldSet = new FieldSet();
   	   // subFieldSet.setSize("480px", "475px");
   	 subFieldSet.setHeadingHtml("사업장정보");
     subFieldSet.setCollapsible(false);
     subFieldSet.add(subBinsinInfo());
   	 layoutContainer.add(subFieldSet);   
   
    plFrmInsr2100.add(layoutContainer);
    
} 

/**
 * 사업장 정보 
 * @return
 */
private LayoutContainer subBinsinInfo() {
	
	LayoutContainer layoutBinsin = new LayoutContainer();
	
	ContentPanel cpGrid = new ContentPanel();
	cpGrid.setBodyBorder(false);
	cpGrid.setHeaderVisible(false);
	cpGrid.setLayout(new FlowLayout());
	cpGrid.setSize("962", "108");
	    
	LayoutContainer layoutContainer_1 = new LayoutContainer();
	layoutContainer_1.setLayout(new ColumnLayout());
	    
	LayoutContainer layoutContainer_2 = new LayoutContainer();
	layoutContainer_2.setLayout(new ColumnLayout());
	    
	LayoutContainer layoutContainer_4 = new LayoutContainer();
	FormLayout frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_4.setLayout(frmlytSch); 
	    
	hlthInsrSym = new MSFTextField();
	hlthInsrSym.setReadOnly(true);
	layoutContainer_4.add(hlthInsrSym, new FormData("100%"));
    hlthInsrSym.setFieldLabel("건강보험");
	   
	layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.58));
	layoutContainer_4.setBorders(false);
	    
	LayoutContainer layoutContainer_6 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_6.setLayout(frmlytSch); 
	    
	hlthInsrOfceSym01 = new MSFTextField();
	hlthInsrOfceSym01.setReadOnly(true);
	layoutContainer_6.add(hlthInsrOfceSym01, new FormData("100%"));
	hlthInsrOfceSym01.setHideLabel(true);
	    
	layoutContainer_2.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
	layoutContainer_6.setBorders(false);
	    
	LayoutContainer layoutContainer_7 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_7.setLayout(frmlytSch); 
	    
	hlthPayMangeDeptNm = new MSFTextField();
	hlthPayMangeDeptNm.setReadOnly(true);
	layoutContainer_7.add(hlthPayMangeDeptNm, new FormData("100%"));
	hlthPayMangeDeptNm.setHideLabel(true);
	layoutContainer_2.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	layoutContainer_7.setBorders(false);
	layoutContainer_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	layoutContainer_2.setBorders(false);
	    
	LayoutContainer layoutContainer_3 = new LayoutContainer();
	layoutContainer_3.setLayout(new ColumnLayout());
	    
	LayoutContainer layoutContainer_5 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_5.setLayout(frmlytSch); 
	    
    natPennSym = new MSFTextField();
    natPennSym.setReadOnly(true);
    layoutContainer_5.add(natPennSym, new FormData("100%"));
    natPennSym.setFieldLabel("국민연금");
    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
    layoutContainer_5.setBorders(false);
    
    LayoutContainer layoutContainer_8 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_8.setLayout(frmlytSch); 
	
	natPayMangeDeptNm = new MSFTextField();
	natPayMangeDeptNm.setReadOnly(true);
	layoutContainer_8.add(natPayMangeDeptNm, new FormData("100%"));
	natPayMangeDeptNm.setHideLabel(true);
	layoutContainer_3.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	layoutContainer_8.setBorders(false);
	layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	layoutContainer_3.setBorders(false); 
	layoutContainer_1.setBorders(false);
   
	LayoutContainer layoutContainer_11 = new LayoutContainer();
	layoutContainer_11.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_12 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_12.setLayout(frmlytSch); 
	
	umytInsrSym = new MSFTextField();
	umytInsrSym.setReadOnly(true);
	layoutContainer_12.add(umytInsrSym, new FormData("100%"));
	umytInsrSym.setFieldLabel("고용보험");
	    
	layoutContainer_11.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	layoutContainer_12.setBorders(false);
	
	LayoutContainer layoutContainer_13 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_13.setLayout(frmlytSch); 
	layoutContainer_13.setBorders(false);
	
	umytPayMangeDeptNm = new MSFTextField();
	umytPayMangeDeptNm.setReadOnly(true);
	layoutContainer_13.add(umytPayMangeDeptNm, new FormData("100%"));
	umytPayMangeDeptNm.setHideLabel(true);
	layoutContainer_11.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	   
	layoutContainer_1.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	layoutContainer_11.setBorders(false);
	    
	LayoutContainer layoutContainer_14 = new LayoutContainer();
	layoutContainer_14.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_15 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_15.setLayout(frmlytSch); 
	
	idtlAccdtInsurSym = new MSFTextField();
	idtlAccdtInsurSym.setReadOnly(true);
	layoutContainer_15.add(idtlAccdtInsurSym, new FormData("100%"));
	idtlAccdtInsurSym.setFieldLabel("산재보험");
	layoutContainer_14.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	layoutContainer_15.setBorders(false);
	
	LayoutContainer layoutContainer_16 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_16.setLayout(frmlytSch); 

	idtlPayMangeDeptNm = new MSFTextField();
	idtlPayMangeDeptNm.setReadOnly(true);
	layoutContainer_16.add(idtlPayMangeDeptNm, new FormData("100%"));
	idtlPayMangeDeptNm.setHideLabel(true);
	layoutContainer_14.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	layoutContainer_16.setBorders(false);
	layoutContainer_1.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
    layoutContainer_14.setBorders(false);
	    
    cpGrid.add(layoutContainer_1);
	    
	LayoutContainer layoutContainer_17 = new LayoutContainer();
	layoutContainer_17.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_18 = new LayoutContainer();
	
	LabelField lblfldNewLabelfield_1 = new LabelField("보험사무 대행기관");
	lblfldNewLabelfield_1.setStyleAttribute("padding-top", "6px");
	lblfldNewLabelfield_1.setStyleAttribute("vertical-align", "middle"); 
	lblfldNewLabelfield_1.setStyleAttribute("text-align", "right");
	layoutContainer_18.add(lblfldNewLabelfield_1);
	layoutContainer_17.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	layoutContainer_18.setBorders(false);
	
	LayoutContainer layoutContainer_19 = new LayoutContainer();
	layoutContainer_19.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_20 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(40); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_20.setLayout(frmlytSch); 
	
	insurPrvaffAgcyIstutNum = new MSFTextField();
	insurPrvaffAgcyIstutNum.setReadOnly(true);
	layoutContainer_20.add(insurPrvaffAgcyIstutNum, new FormData("100%"));
	insurPrvaffAgcyIstutNum.setFieldLabel("번 호");
	layoutContainer_19.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	layoutContainer_20.setBorders(false);
	
	LayoutContainer layoutContainer_21 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(40); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_21.setLayout(frmlytSch);
	
	insurPrvaffAgcyIstutNm = new MSFTextField();
	insurPrvaffAgcyIstutNm.setReadOnly(true);
	layoutContainer_21.add(insurPrvaffAgcyIstutNm, new FormData("100%"));
	insurPrvaffAgcyIstutNm.setFieldLabel("명 칭");
	layoutContainer_19.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	layoutContainer_21.setBorders(false);
	layoutContainer_17.add(layoutContainer_19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
	layoutContainer_19.setBorders(false);
	
	LayoutContainer layoutContainer_22 = new LayoutContainer();
	
	LabelField lblfldNewLabelfield_2 = new LabelField("단위기관(영업소)");
	lblfldNewLabelfield_2.setStyleAttribute("padding-top", "6px");
	lblfldNewLabelfield_2.setStyleAttribute("vertical-align", "middle"); 
	lblfldNewLabelfield_2.setStyleAttribute("text-align", "right");
	layoutContainer_22.add(lblfldNewLabelfield_2);
	layoutContainer_17.add(layoutContainer_22,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	layoutContainer_22.setBorders(false);
	
	LayoutContainer layoutContainer_23 = new LayoutContainer();
	layoutContainer_23.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_24 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(40); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_24.setLayout(frmlytSch);
	
	hlthInsrOfceSym = new MSFTextField();
	hlthInsrOfceSym.setReadOnly(true);
	layoutContainer_24.add(hlthInsrOfceSym, new FormData("100%"));
	hlthInsrOfceSym.setFieldLabel("기 호");
	layoutContainer_23.add(layoutContainer_24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	layoutContainer_24.setBorders(false);
	
	LayoutContainer layoutContainer_25 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(40); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_25.setLayout(frmlytSch);
	
	payMangeDeptNm = new MSFTextField();
	payMangeDeptNm.setReadOnly(true);
	layoutContainer_25.add(payMangeDeptNm, new FormData("100%"));
	payMangeDeptNm.setFieldLabel("명 칭");
	layoutContainer_23.add(layoutContainer_25,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	layoutContainer_25.setBorders(false);
	layoutContainer_17.add(layoutContainer_23,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
	layoutContainer_23.setBorders(false);
	cpGrid.add(layoutContainer_17);
	layoutContainer_17.setBorders(false);
	
	LayoutContainer layoutContainer_26 = new LayoutContainer();
	layoutContainer_26.setLayout(new ColumnLayout());
	layoutContainer_26.setBorders(false);
	
	LayoutContainer layoutContainer_28 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_28.setLayout(frmlytSch);
	
	payMangeDeptPhnNum = new MSFTextField();
	payMangeDeptPhnNum.setReadOnly(true);
	layoutContainer_28.add(payMangeDeptPhnNum, new FormData("100%"));
	payMangeDeptPhnNum.setFieldLabel("전화번호");
	layoutContainer_26.add(layoutContainer_28,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	layoutContainer_28.setBorders(false); 
	
	LayoutContainer layoutContainer_29 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_29.setLayout(frmlytSch);
	
	payMangeDeptFaxNum = new MSFTextField();
	payMangeDeptFaxNum.setReadOnly(true);
	layoutContainer_29.add(payMangeDeptFaxNum, new FormData("100%"));
	payMangeDeptFaxNum.setFieldLabel("팩스번호");
	layoutContainer_26.add(layoutContainer_29,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	layoutContainer_29.setBorders(false);
	
	
	LayoutContainer layoutContainer_30 = new LayoutContainer();
	layoutContainer_30.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_31 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_31.setLayout(frmlytSch);
	
	payMangeDeptZpcd = new MSFTextField();
	payMangeDeptZpcd.setReadOnly(true);
	layoutContainer_31.add(payMangeDeptZpcd, new FormData("100%"));
	payMangeDeptZpcd.setFieldLabel("주 소");
	layoutContainer_30.add(layoutContainer_31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	layoutContainer_31.setBorders(false);
	
	LayoutContainer layoutContainer_32 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_32.setLayout(frmlytSch);
	
	payMangeDeptAddr = new MSFTextField();
	payMangeDeptAddr.setReadOnly(true);
	layoutContainer_32.add(payMangeDeptAddr, new FormData("100%"));
	payMangeDeptAddr.setHideLabel(true);
	layoutContainer_30.add(layoutContainer_32,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
	layoutContainer_32.setBorders(false); 
	layoutContainer_30.setBorders(false);
	layoutContainer_26.add(layoutContainer_30,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.64));
	
	cpGrid.add(layoutContainer_26);
	
	LayoutContainer layoutContainer_33 = new LayoutContainer();
	layoutContainer_33.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_34 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(165); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_34.setLayout(frmlytSch); 
	
	MSFTextField txtfldNewTextfield_14 = new MSFTextField(); 
	txtfldNewTextfield_14.setReadOnly(true);
	layoutContainer_34.add(txtfldNewTextfield_14, new FormData("100%"));
	txtfldNewTextfield_14.setFieldLabel("고용보험 하수급인관리번호");
	layoutContainer_33.add(layoutContainer_34,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
	layoutContainer_34.setBorders(false);
	
	LayoutContainer layoutContainer_35 = new LayoutContainer();
	
	LabelField lblfldNewLabelfield_3 = new LabelField("(건설공사등의 미승인 하수급인에 한함)");
	lblfldNewLabelfield_3.setStyleAttribute("padding-top", "6px");
	lblfldNewLabelfield_3.setStyleAttribute("vertical-align", "middle"); 
	lblfldNewLabelfield_3.setStyleAttribute("text-align", "left");
	layoutContainer_35.add(lblfldNewLabelfield_3);
	layoutContainer_33.add(layoutContainer_35,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.56));
	layoutContainer_35.setBorders(false);
	cpGrid.add(layoutContainer_33);
	layoutContainer_33.setBorders(false);
	layoutBinsin.add(cpGrid);   
	
	return layoutBinsin;
}

//국민연금
private LayoutContainer rightFormBottom01() { 
    
    LayoutContainer layoutContainer = new LayoutContainer();   
    
    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false);
    cp01.setLayout(new FormLayout());
    //엣지변환
    //cp01.setSize("480", "279");
    cp01.setSize("480", "280");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    layoutContainer_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer1_2 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_2.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer1_1 = new LayoutContainer();
    layoutContainer1_1.setLayout(new ColumnLayout()); 
  
    LayoutContainer layoutContainer_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd); 
    
    MSFNumberPropertyEditor propertyEditor = new MSFNumberPropertyEditor(NumberFormat.getDecimalFormat());
    propertyEditor.setStripGroupSeparator(true);
    
    socnsrAqtnRegVal07 = new MSFNumberField();//new NumberFieldWithButton(btnSocnsrAqtnRegVal07); 
    socnsrAqtnRegVal07.setAllowDecimals(false); 
    socnsrAqtnRegVal07.setPropertyEditorType(Long.class); 
    //socnsrAqtnRegVal07.setPropertyEditor(propertyEditor);
    socnsrAqtnRegVal07.setFormat(NumberFormat.getFormat("#,##0;(#,##0)"));  //NumberFormat.getFormat("#,##0;(#,##0)")
    //socnsrAqtnRegVal07.setFormat(NumberFormat.getDecimalFormat());
    socnsrAqtnRegVal07.setInputStyleAttribute("text-align", "right"); 
    socnsrAqtnRegVal07.addKeyListener(new MSFComponentKeyPress()); 
    socnsrAqtnRegVal07.setFieldLabel("소득월액"); 
    layoutContainer_2.add(socnsrAqtnRegVal07, new FormData("100%"));
    layoutContainer1_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));  
    layoutContainer_2.setBorders(false); 
    
    
    btnSocnsrAqtnRegVal07 = new Button();  
    btnSocnsrAqtnRegVal07.setWidth("25px");
    btnSocnsrAqtnRegVal07.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal07.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal07.getValue() || "".equals(socnsrAqtnRegVal07.getValue())){
        		Window.alert("소득월액을 입력하세요");
        	}else{
	        	MessageBox.confirm("소득월액", "국민연금 소득월액을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL07");
						}
					}
				}); 
        	}
        }
    }); 
    layoutContainer1_1.add(btnSocnsrAqtnRegVal07,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));  
    layoutContainer1_2.add(layoutContainer1_1, new FormData("100%"));
    
    layoutContainer_1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer1_2.setBorders(false);
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal10 = new Button();  
    btnSocnsrAqtnRegVal10.setWidth("25px");
    btnSocnsrAqtnRegVal10.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal10.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal10.getValue() || "".equals(socnsrAqtnRegVal10.getValue())){
        		Window.alert("취득일을 입력하세요");
        	}else{
	        	MessageBox.confirm("취득일", "국민연금 취득일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL10");;
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal10 = new DateFieldWithButton(btnSocnsrAqtnRegVal10);   
    new DateFieldMask(socnsrAqtnRegVal10, "9999.99.99"); 
    socnsrAqtnRegVal10.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrAqtnRegVal10.setName("socnsrAqtnRegVal10");
    socnsrAqtnRegVal10.setFieldLabel("취득일");
    socnsrAqtnRegVal10.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent e) {
        	String strDate = GWTUtils.getStringFromDate(socnsrAqtnRegVal10.getValue(),"yyyyMMdd");

        	if (strDate.substring(6,8).equals("01")) {
        		socnsrAqtnRegVal08.setValue(true);
        	}
        }
    });
    
    layoutContainer_3.add(socnsrAqtnRegVal10, new FormData("100%"));
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_3.setBorders(false);
    
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false);
    
    LayoutContainer layoutContainerc_1 = new LayoutContainer();
    layoutContainerc_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal09 = new Button();  
    btnSocnsrAqtnRegVal09.setWidth("25px");
    btnSocnsrAqtnRegVal09.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal09.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal09.getValue() || "".equals(socnsrAqtnRegVal09.getValue())){
        		Window.alert("취득부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("취득부호", "국민연금 취득부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL09");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal09 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal09); 
    socnsrAqtnRegVal09.setName("socnsrAqtnRegVal09");
    socnsrAqtnRegVal09.setForceSelection(true);
    socnsrAqtnRegVal09.setMinChars(1);
    socnsrAqtnRegVal09.setDisplayField("commCdNm");
    socnsrAqtnRegVal09.setValueField("commCd");
    socnsrAqtnRegVal09.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal09.setEmptyText("--취득부호선택--");
    socnsrAqtnRegVal09.setSelectOnFocus(true); 
    socnsrAqtnRegVal09.setReadOnly(false);
    socnsrAqtnRegVal09.setEnabled(true); 
    socnsrAqtnRegVal09.setStore(lsSocnsrAqtnRegVal09);  
    socnsrAqtnRegVal09.setFieldLabel("취득부호");  
    layoutContainer_4.add(socnsrAqtnRegVal09, new FormData("100%")); 
    layoutContainerc_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_4.setBorders(false);
   
    
    LayoutContainer layoutContainer6_1 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer6_1.setLayout(frmlytStd);
    
    LayoutContainer layoutContainer6_2 = new LayoutContainer();
    layoutContainer6_2.setLayout(new ColumnLayout());
        
    LayoutContainer layoutContainer6_3 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer6_3.setLayout(frmlytStd);
    
    
    socnsrAqtnRegVal08 = new MSFCheckBox(); 
    socnsrAqtnRegVal08.setStyleAttribute("text-align", "left");
    socnsrAqtnRegVal08.setFieldLabel("취득월납부");
    layoutContainer6_3.add(socnsrAqtnRegVal08, new FormData("100%"));
    layoutContainer6_2.add(layoutContainer6_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));  
    
    btnSocnsrAqtnRegVal08 = new Button();  
    btnSocnsrAqtnRegVal08.setWidth("25px");
    btnSocnsrAqtnRegVal08.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal08.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	MessageBox.confirm("취득월납부", "국민연금 취득월납부를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
        		@Override
        		public void handleEvent(MessageBoxEvent be) {
        			//if("Yes".equals(be.getButtonClicked().getText())){
        			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        				updateInsr2100AllGridBatch("VAL08");
        			}
        		}
        	}); 
        }
    });
    layoutContainer6_2.add(btnSocnsrAqtnRegVal08,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));  
    layoutContainer6_1.add(layoutContainer6_2, new FormData("100%"));
    
    layoutContainerc_1.add(layoutContainer6_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer6_1.setBorders(false);

    cp01.add(layoutContainerc_1, new FormData("100%"));
    
    
    LayoutContainer layoutContainer_5 = new LayoutContainer(new FlowLayout());
    layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_71 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_71.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal11 = new Button();  
    btnSocnsrAqtnRegVal11.setWidth("25px");
    btnSocnsrAqtnRegVal11.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal11.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal11.getValue() || "".equals(socnsrAqtnRegVal11.getValue())){
        		Window.alert("특수직종을 입력하세요");
        	}else{
	        	MessageBox.confirm("특수직종", "국민연금 특수직종을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL11");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal11 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal11); 
    socnsrAqtnRegVal11.setName("socnsrAqtnRegVal11");
    socnsrAqtnRegVal11.setForceSelection(true);
    socnsrAqtnRegVal11.setMinChars(1);
    socnsrAqtnRegVal11.setDisplayField("commCdNm");
    socnsrAqtnRegVal11.setValueField("commCd");
    socnsrAqtnRegVal11.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal11.setEmptyText("--특수직종선택--");
    socnsrAqtnRegVal11.setSelectOnFocus(true); 
    socnsrAqtnRegVal11.setReadOnly(false);
    socnsrAqtnRegVal11.setEnabled(true); 
    socnsrAqtnRegVal11.setStore(lsSocnsrAqtnRegVal11);  
    layoutContainer_71.add(socnsrAqtnRegVal11, new FormData("100%"));
    socnsrAqtnRegVal11.setFieldLabel("특수직종");
    layoutContainer_5.add(layoutContainer_71,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
    layoutContainer_71.setBorders(false); 
    
    LayoutContainer layoutContainer_7 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal12 = new Button();  
    btnSocnsrAqtnRegVal12.setWidth("25px");
    btnSocnsrAqtnRegVal12.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal12.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal12.getValue() || "".equals(socnsrAqtnRegVal12.getValue())){
        		Window.alert("직역연금을 입력하세요");
        	}else{
	        	MessageBox.confirm("직역연금", "국민연금 직역연금을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL12");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal12 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal12); 
    socnsrAqtnRegVal12.setName("socnsrAqtnRegVal12");
    socnsrAqtnRegVal12.setForceSelection(true);
    socnsrAqtnRegVal12.setMinChars(1);
    socnsrAqtnRegVal12.setDisplayField("commCdNm");
    socnsrAqtnRegVal12.setValueField("commCd");
    socnsrAqtnRegVal12.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal12.setEmptyText("--직역연금선택--");
    socnsrAqtnRegVal12.setSelectOnFocus(true); 
    socnsrAqtnRegVal12.setReadOnly(false);
    socnsrAqtnRegVal12.setEnabled(true); 
    socnsrAqtnRegVal12.setStore(lsSocnsrAqtnRegVal12);  
    layoutContainer_7.add(socnsrAqtnRegVal12, new FormData("100%"));
    socnsrAqtnRegVal12.setFieldLabel("직역연금");
    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_7.setBorders(false); 
    
    cp01.add(layoutContainer_5, new FormData("100%"));
    layoutContainer_5.setBorders(false);
    
    LayoutContainer layoutContainer_8 = new LayoutContainer();
    layoutContainer_8.setHeight(148);
    layoutContainer_8.setBorders(false);
    cp01.add(layoutContainer_8, new FormData("100%"));
    
    LayoutContainer layoutContainer_8_1 = new LayoutContainer();
    ButtonBar barbtn01 = new ButtonBar();
    barbtn01.setAlignment(HorizontalAlignment.RIGHT);     
    layoutContainer_8_1.add(barbtn01, new FormData("100"));     
    btn01 = new Button("신고파일"); 
    barbtn01.add(btn01);
    btn01.addListener(Events.Select, new Listener<ButtonEvent>() {
    	public void handleEvent(ButtonEvent e) {
    		excelFileExport("1");
    	}
    });
    
    layoutContainer_8_1.setBorders(false); 
    cp01.add(layoutContainer_8_1, new FormData("100%"));
    
    layoutContainer.add(cp01); 
    
    return layoutContainer;
}

//건강보험
private LayoutContainer rightFormBottom02() { 
    
    LayoutContainer layoutContainer = new LayoutContainer();   
    
    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false);
    cp01.setLayout(new FormLayout());
    cp01.setSize("480", "279");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    layoutContainer_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer1_2 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_2.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer1_1 = new LayoutContainer();
    layoutContainer1_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_2 = new LayoutContainer();
      frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd); 
    
    socnsrAqtnRegVal15 = new MSFNumberField();
    socnsrAqtnRegVal15.setAllowDecimals(false); 
    socnsrAqtnRegVal15.setPropertyEditorType(Long.class); 
    socnsrAqtnRegVal15.setFormat(NumberFormat.getDecimalFormat());
    socnsrAqtnRegVal15.setInputStyleAttribute("text-align", "right"); 
    socnsrAqtnRegVal15.setFieldLabel("보수월액"); 
    layoutContainer_2.add(socnsrAqtnRegVal15, new FormData("100%"));
    layoutContainer1_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));   
    layoutContainer_2.setBorders(false);
    
    btnSocnsrAqtnRegVal15 = new Button();  
    btnSocnsrAqtnRegVal15.setWidth("25px");
    btnSocnsrAqtnRegVal15.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal15.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal15.getValue() || "".equals(socnsrAqtnRegVal15.getValue())){
        		Window.alert("보수월액을 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험", "건강보험 보수월액을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL15");
						}
					}
				}); 
        	}
        }
    });
    
    layoutContainer1_1.add(btnSocnsrAqtnRegVal15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
    
    layoutContainer1_2.add(layoutContainer1_1, new FormData("100%"));   
    layoutContainer_1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
     frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal17 = new Button();  
    btnSocnsrAqtnRegVal17.setWidth("25px");
    btnSocnsrAqtnRegVal17.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal17.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal17.getValue() || "".equals(socnsrAqtnRegVal17.getValue())){
        		Window.alert("취득일을 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험", "건강보험 취득일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL17");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal17 = new DateFieldWithButton(btnSocnsrAqtnRegVal17);   
    new DateFieldMask(socnsrAqtnRegVal17, "9999.99.99"); 
    socnsrAqtnRegVal17.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrAqtnRegVal17.setName("socnsrAqtnRegVal17");
    layoutContainer_3.add(socnsrAqtnRegVal17, new FormData("100%"));
    socnsrAqtnRegVal17.setFieldLabel("취득일");
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));    
    layoutContainer_3.setBorders(false);
    
   
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false);
    
    LayoutContainer layoutContainer_5 = new LayoutContainer(new FlowLayout());
   layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal16 = new Button();  
    btnSocnsrAqtnRegVal16.setWidth("25px");
    btnSocnsrAqtnRegVal16.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal16.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal16.getValue() || "".equals(socnsrAqtnRegVal16.getValue())){
        		Window.alert("취득부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험", "건강보험 취득부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL16");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal16 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal16); 
    socnsrAqtnRegVal16.setName("socnsrAqtnRegVal16");
    socnsrAqtnRegVal16.setForceSelection(true);
    socnsrAqtnRegVal16.setMinChars(1);
    socnsrAqtnRegVal16.setDisplayField("commCdNm");
    socnsrAqtnRegVal16.setValueField("commCd");
    socnsrAqtnRegVal16.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal16.setEmptyText("--취득부호선택--");
    socnsrAqtnRegVal16.setSelectOnFocus(true); 
    socnsrAqtnRegVal16.setReadOnly(false);
    socnsrAqtnRegVal16.setEnabled(true); 
    socnsrAqtnRegVal16.setStore(lsSocnsrAqtnRegVal16);  
    socnsrAqtnRegVal16.setFieldLabel("취득부호"); 
    
    layoutContainer_4.add(socnsrAqtnRegVal16, new FormData("100%"));
    layoutContainer_5.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_4.setBorders(false);
    
    LayoutContainer layoutContainer_6 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal18 = new Button();  
    btnSocnsrAqtnRegVal18.setWidth("25px");
    btnSocnsrAqtnRegVal18.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal18.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal18.getValue() || "".equals(socnsrAqtnRegVal18.getValue())){
        		Window.alert("감면부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험", "건강보험 감면부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL18");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal18 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal18); 
    socnsrAqtnRegVal18.setName("socnsrAqtnRegVal18");
    socnsrAqtnRegVal18.setForceSelection(true);
    socnsrAqtnRegVal18.setMinChars(1);
    socnsrAqtnRegVal18.setDisplayField("commCdNm");
    socnsrAqtnRegVal18.setValueField("commCd");
    socnsrAqtnRegVal18.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal18.setEmptyText("--감면부호선택--");
    socnsrAqtnRegVal18.setSelectOnFocus(true); 
    socnsrAqtnRegVal18.setReadOnly(false);
    socnsrAqtnRegVal18.setEnabled(true); 
    socnsrAqtnRegVal18.setStore(lsSocnsrAqtnRegVal18);  
    socnsrAqtnRegVal18.setFieldLabel("감면부호"); 
    layoutContainer_6.add(socnsrAqtnRegVal18, new FormData("100%")); 
    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_6.setBorders(false);
     
    cp01.add(layoutContainer_5, new FormData("100%"));
    layoutContainer_5.setBorders(false);
    
    LayoutContainer layoutContainerc_5 = new LayoutContainer(new FlowLayout());
    layoutContainerc_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_11 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(140); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_11.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer_11_1 = new LayoutContainer();
    layoutContainer_11_1.setLayout(new ColumnLayout());

    LayoutContainer layoutContainer_11_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(140); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_11_2.setLayout(frmlytStd); 
    
    socnsrAqtnRegVal19 = new MSFCheckBox(); 
    socnsrAqtnRegVal19.setFieldLabel("사업장으로 발송희망");
    layoutContainer_11_2.add(socnsrAqtnRegVal19, new FormData("100%"));
    layoutContainer_11_1.add(layoutContainer_11_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));  
    
    btnSocnsrAqtnRegVal19 = new Button();  
    btnSocnsrAqtnRegVal19.setWidth("25px");
    btnSocnsrAqtnRegVal19.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal19.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	MessageBox.confirm("건강보험", "건강보험 사업장으로 발송희망 선택을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
        		@Override
        		public void handleEvent(MessageBoxEvent be) {
        			//if("Yes".equals(be.getButtonClicked().getText())){
        			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        				updateInsr2100AllGridBatch("VAL19");
        			}
        		}
        	}); 
        }
    });
    layoutContainer_11_1.add(btnSocnsrAqtnRegVal19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));  
    layoutContainer_11.add(layoutContainer_11_1, new FormData("100%"));
    
    layoutContainerc_5.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_11.setBorders(false);
    
    LayoutContainer layoutContainer_71 = new LayoutContainer();
//    layoutContainer_71.setStyleAttribute("text-align", "center");
    ButtonBar barbtn01 = new ButtonBar();
    barbtn01.setAlignment(HorizontalAlignment.CENTER);     
    layoutContainer_71.add(barbtn01, new FormData("100"));     
    
    Button btn01 = new Button("피부양자"); 
    barbtn01.add(btn01);
//    layoutContainer_71.add(btn01, new FormData("40%")); 
    btn01.addListener(Events.Select, new Listener<ButtonEvent>() {
    public void handleEvent(ButtonEvent e) { 
       if (!MSFSharedUtils.allowNulls(systemkey.getValue()).trim().equals("")) {
    	//피부양자 
		  InsrP210001 insrP21001Form = new InsrP210001(ActionDatabase.CUSTOM, getThis());   
		    
		  MSFFormWindows msFwInsr21001 = new MSFFormWindows("피부양자취득/상실신고",insrP21001Form,"닫기","900px", "550px",true);
		  msFwInsr21001.show();
		  insrP21001Form.setMSFFormWindows(msFwInsr21001);
		  
		  funcSetPopUpRecord2();
		  
	      insrP21001Form.bind(ppRecord);  
       }
    }
  });
      
    layoutContainer_71.setBorders(false); 
    layoutContainerc_5.add(layoutContainer_71,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    
    
    cp01.add(layoutContainerc_5, new FormData("100%"));
    layoutContainerc_5.setBorders(false);
     

    LayoutContainer layoutContainer_31 = new LayoutContainer(new FlowLayout());
   // layoutContainer_31.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_8 = new LayoutContainer();
    frmlytStd = new FormLayout();   
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_8.setLayout(frmlytStd); 
    
    LabelField lblfldDd = new LabelField("공무원/교직원");
    layoutContainer_8.add(lblfldDd, new FormData("100%"));
    layoutContainer_31.add(layoutContainer_8);   //,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)
    layoutContainer_8.setBorders(false);
    

    LayoutContainer layoutContainers_5 = new LayoutContainer(new FlowLayout());
    layoutContainers_5.setLayout(new ColumnLayout());
    layoutContainer_5.setBorders(false);
    
    LayoutContainer layoutContainer_9 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_9.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal20 = new Button();  
    btnSocnsrAqtnRegVal20.setWidth("25px");
    btnSocnsrAqtnRegVal20.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal20.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal20.getValue() || "".equals(socnsrAqtnRegVal20.getValue())){
        		Window.alert("회계부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험", "건강보험 회계부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL20");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal20 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal20); 
    socnsrAqtnRegVal20.setName("socnsrAqtnRegVal20");
    socnsrAqtnRegVal20.setForceSelection(true);
    socnsrAqtnRegVal20.setMinChars(1);
    socnsrAqtnRegVal20.setDisplayField("commCdNm");
    socnsrAqtnRegVal20.setValueField("commCd");
    socnsrAqtnRegVal20.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal20.setEmptyText("--회계부호선택--");
    socnsrAqtnRegVal20.setSelectOnFocus(true); 
    socnsrAqtnRegVal20.setReadOnly(false);
    socnsrAqtnRegVal20.setEnabled(true); 
    socnsrAqtnRegVal20.setStore(lsSocnsrAqtnRegVal20);  
    socnsrAqtnRegVal20.setFieldLabel("회계부호"); 
    layoutContainer_9.add(socnsrAqtnRegVal20, new FormData("100%")); 
    layoutContainers_5.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_9.setBorders(false);
    
    LayoutContainer layoutContainer_10 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_10.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal21 = new Button();  
    btnSocnsrAqtnRegVal21.setWidth("25px");
    btnSocnsrAqtnRegVal21.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal21.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal21.getValue() || "".equals(socnsrAqtnRegVal21.getValue())){
        		Window.alert("직종부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험", "건강보험 직종부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL21");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal21 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal21); 
    socnsrAqtnRegVal21.setName("socnsrAqtnRegVal21");
    socnsrAqtnRegVal21.setForceSelection(true);
    socnsrAqtnRegVal21.setMinChars(1);
    socnsrAqtnRegVal21.setDisplayField("commCdNm");
    socnsrAqtnRegVal21.setValueField("commCd");
    socnsrAqtnRegVal21.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal21.setEmptyText("--직종부호선택--");
    socnsrAqtnRegVal21.setSelectOnFocus(true); 
    socnsrAqtnRegVal21.setReadOnly(false);
    socnsrAqtnRegVal21.setEnabled(true); 
    socnsrAqtnRegVal21.setStore(lsSocnsrAqtnRegVal21);  
    socnsrAqtnRegVal21.setFieldLabel("직종부호"); 
    layoutContainer_10.add(socnsrAqtnRegVal21, new FormData("100%"));
    layoutContainers_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_10.setBorders(false);
    
    layoutContainer_31.add(layoutContainers_5);
    layoutContainer_31.setBorders(false);
    cp01.add(layoutContainer_31, new FormData("100%"));
     
    LayoutContainer layoutContainer_12 = new LayoutContainer();
    layoutContainer_12.setHeight(102);
    layoutContainer_12.setBorders(false);
    cp01.add(layoutContainer_12, new FormData("100%"));
    
    LayoutContainer layoutContainer_12_1 = new LayoutContainer();
    ButtonBar barbtn02 = new ButtonBar();
    barbtn02.setAlignment(HorizontalAlignment.RIGHT);     
    layoutContainer_12_1.add(barbtn02, new FormData("100"));     
    btn02 = new Button("신고파일"); 
    barbtn02.add(btn02);
    btn02.addListener(Events.Select, new Listener<ButtonEvent>() {
    	public void handleEvent(ButtonEvent e) {
    		excelFileExport("2");
    	}
    });
    
    layoutContainer_12_1.setBorders(false); 
    cp01.add(layoutContainer_12_1, new FormData("100%"));
 
    layoutContainer.add(cp01); 
    
    return layoutContainer;
}

//고용보험
private LayoutContainer rightFormBottom03() { 
    
    LayoutContainer layoutContainer = new LayoutContainer();   
    
    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false);
    cp01.setLayout(new FormLayout());
    cp01.setSize("480", "279");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer1_2 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_2.setLayout(frmlytStd); 
    
    
    LayoutContainer layoutContainer1_1 = new LayoutContainer(new FlowLayout());
    layoutContainer1_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd); 
    
    
    socnsrAqtnRegVal27 = new MSFNumberField();
    socnsrAqtnRegVal27.setAllowDecimals(true); 
    socnsrAqtnRegVal27.setPropertyEditorType(Long.class); 
    socnsrAqtnRegVal27.setFormat(NumberFormat.getDecimalFormat());
    socnsrAqtnRegVal27.setInputStyleAttribute("text-align", "right"); 
    socnsrAqtnRegVal27.setFieldLabel("월평균보수"); 
    socnsrAqtnRegVal27.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal36.setValue(socnsrAqtnRegVal27.getValue());
		}
	});
    layoutContainer_2.add(socnsrAqtnRegVal27, new FormData("100%"));
    layoutContainer1_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));   
    layoutContainer_2.setBorders(false);
    
    btnSocnsrAqtnRegVal27 = new Button();  
    btnSocnsrAqtnRegVal27.setWidth("25px");
    btnSocnsrAqtnRegVal27.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal27.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal27.getValue() || "".equals(socnsrAqtnRegVal27.getValue())){
        		Window.alert("월평균보수를 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 월평균보수를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL27");
						}
					}
				}); 
        	}
        }
    }); 
    layoutContainer1_1.add(btnSocnsrAqtnRegVal27,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));   
    layoutContainer1_2.add(layoutContainer1_1, new FormData("100%"));   
    layoutContainer_1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal22 = new Button();  
    btnSocnsrAqtnRegVal22.setWidth("25px");
    btnSocnsrAqtnRegVal22.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal22.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal22.getValue() || "".equals(socnsrAqtnRegVal22.getValue())){
        		Window.alert("취득일을 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 취득일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL22");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal22 = new DateFieldWithButton(btnSocnsrAqtnRegVal22);   
    new DateFieldMask(socnsrAqtnRegVal22, "9999.99.99"); 
    socnsrAqtnRegVal22.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrAqtnRegVal22.setName("socnsrAqtnRegVal22");
    socnsrAqtnRegVal22.setFieldLabel("취득일");
    socnsrAqtnRegVal22.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal31.setValue(InsrUtils.getConvertStringToDate((String) GWTUtils.getStringFromDate(socnsrAqtnRegVal22.getValue(),"yyyyMMdd"), "yyyyMMdd"));// 연금 상실일
		}
	});
    layoutContainer_3.add(socnsrAqtnRegVal22, new FormData("100%"));
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_3.setBorders(false);
    
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false);
    
    
    LayoutContainer layoutContainer_5 = new LayoutContainer(new FlowLayout());
    layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer1_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_4.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer1_5 = new LayoutContainer(new FlowLayout());
    layoutContainer1_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    socnsrAqtnRegVal24 = new MSFNumberField();
    socnsrAqtnRegVal24.setAllowDecimals(true); 
    socnsrAqtnRegVal24.setPropertyEditorType(Double.class); 
    socnsrAqtnRegVal24.setFormat(NumberFormat.getDecimalFormat());
    socnsrAqtnRegVal24.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_4.add(socnsrAqtnRegVal24, new FormData("100%"));
    socnsrAqtnRegVal24.setFieldLabel("주소정근로");
    socnsrAqtnRegVal24.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal33.setValue(socnsrAqtnRegVal24.getValue());
		}
	});
    layoutContainer1_5.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));   //
    layoutContainer_4.setBorders(false);
    
    btnSocnsrAqtnRegVal24 = new Button();  
    btnSocnsrAqtnRegVal24.setWidth("25px");
    btnSocnsrAqtnRegVal24.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal24.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal24.getValue() || "".equals(socnsrAqtnRegVal24.getValue())){
        		Window.alert("주소정근로를 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 주소정근로를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL24");
						}
					}
				}); 
        	}
        }
    });
    layoutContainer1_5.add(btnSocnsrAqtnRegVal24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));   //
    layoutContainer1_4.add(layoutContainer1_5, new FormData("100%"));   //
   
    layoutContainer_5.add(layoutContainer1_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   //
    
    
    LayoutContainer layoutContainer_6 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer_6_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_6_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_6_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6_2.setLayout(frmlytStd); 
    
    //직종 찾기
    Button btnSocnsrAqtnRegVal23D = new Button();  
    btnSocnsrAqtnRegVal23D.setIcon(MSFMainApp.ICONS.search()); 
    btnSocnsrAqtnRegVal23D.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	fnPopupBass0300("I001"); 
        }
    });
    socnsrAqtnRegVal23D = new TextFieldWithButton<String>(btnSocnsrAqtnRegVal23D);
    socnsrAqtnRegVal23D.addKeyListener(new KeyListener() {
    	 @Override
        public void componentKeyDown(ComponentEvent event) {
           
            socnsrAqtnRegVal23D.validate();
            if (MSFSharedUtils.allowNulls(socnsrAqtnRegVal23D.getValue()).trim().equals("")) {
            	socnsrAqtnRegVal23.setValue("");
            	socnsrAqtnRegVal23D.setValue(""); 
            }  
            if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
            	socnsrAqtnRegVal23.setValue("");
            	socnsrAqtnRegVal23D.setValue("");
            	fnPopupBass0300("I001"); 
            }
            
            super.componentKeyDown(event);
        }
    });
//    socnsrAqtnRegVal23D.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//        @Override
//        public void handleEvent(BaseEvent be) {  
//            if (MSFSharedUtils.allowNulls(socnsrAqtnRegVal23D.getValue()).trim().equals("")) {
//            	socnsrAqtnRegVal23.setValue("");
//            	socnsrAqtnRegVal23D.setValue(""); 
//            }         
//        } 
//    }); 
    socnsrAqtnRegVal23D.setFieldLabel("직종");
    socnsrAqtnRegVal23D.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal32D.setValue(socnsrAqtnRegVal23D.getValue());
		}
	});
    layoutContainer_6_2.add(socnsrAqtnRegVal23D, new FormData("100%"));
    layoutContainer_6_1.add(layoutContainer_6_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));   //
    
    btnSocnsrAqtnRegVal23 = new Button();  
    btnSocnsrAqtnRegVal23.setWidth("25px");
    btnSocnsrAqtnRegVal23.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal23.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal23.getValue() || "".equals(socnsrAqtnRegVal23.getValue())){
        		Window.alert("직종을 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 직종을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL23");
						}
					}
				}); 
        	}
        }
    });
    layoutContainer_6_1.add(btnSocnsrAqtnRegVal23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));   //
    layoutContainer_6.add(layoutContainer_6_1, new FormData("100%"));
    
    layoutContainer_6.setBorders(false);
    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
    
    cp01.add(layoutContainer_5, new FormData("100%"));
    layoutContainer_5.setBorders(false);
  
    LayoutContainer layoutContainerd_5 = new LayoutContainer(new FlowLayout());
    layoutContainerd_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_7 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer_7_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_7_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_7_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7_2.setLayout(frmlytStd); 
    
    socnsrAqtnRegVal25 = new MSFCheckBox(); 
    socnsrAqtnRegVal25.setFieldLabel("계약직여부");
    socnsrAqtnRegVal25.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal34.setValue(socnsrAqtnRegVal25.getValue());
		}
	});
    layoutContainer_7_2.add(socnsrAqtnRegVal25, new FormData("100%"));
    layoutContainer_7_1.add(layoutContainer_7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
    
    btnSocnsrAqtnRegVal25 = new Button();  
    btnSocnsrAqtnRegVal25.setWidth("25px");
    btnSocnsrAqtnRegVal25.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal25.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	MessageBox.confirm("고용보험", "고용보험 계약직여부를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
        		@Override
        		public void handleEvent(MessageBoxEvent be) {
        			//if("Yes".equals(be.getButtonClicked().getText())){
        			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
        				updateInsr2100AllGridBatch("VAL25");
        			}
        		}
        	}); 
        }
    });
    layoutContainer_7_1.add(btnSocnsrAqtnRegVal25, new FormData("100%"));
    layoutContainer_7_1.add(btnSocnsrAqtnRegVal25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));

    layoutContainer_7.add(layoutContainer_7_1, new FormData("100%"));
    layoutContainer_7.setBorders(false); 
    layoutContainerd_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    
    LayoutContainer layoutContainer_8 = new LayoutContainer(); 
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_8.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal26 = new Button();  
    btnSocnsrAqtnRegVal26.setWidth("25px");
    btnSocnsrAqtnRegVal26.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal26.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal26.getValue() || "".equals(socnsrAqtnRegVal26.getValue())){
        		Window.alert("계약종료월을 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 계약종료월을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL26");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal26 = new TextFieldWithButton(btnSocnsrAqtnRegVal26);
    socnsrAqtnRegVal26.setName("socnsrAqtnRegVal26");
    socnsrAqtnRegVal26.setFieldLabel("계약종료월");
    socnsrAqtnRegVal26.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal35.setValue(socnsrAqtnRegVal26.getValue());
		}
	});
    new TextFieldMask<String>(socnsrAqtnRegVal26, "9999.99");
    layoutContainer_8.add(socnsrAqtnRegVal26, new FormData("100%"));
    layoutContainerd_5.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));    
    layoutContainer_8.setBorders(false);
   
    cp01.add(layoutContainerd_5, new FormData("100%"));
    layoutContainerd_5.setBorders(false);
      
    LayoutContainer layoutContainer_9 = new LayoutContainer(new FlowLayout());
    layoutContainer_9.setLayout(new ColumnLayout());
    layoutContainer_9.setBorders(false);
    
    LayoutContainer layoutContainer_12 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_12.setLayout(frmlytStd);
    
    btnSocnsrAqtnRegVal29 = new Button();  
    btnSocnsrAqtnRegVal29.setWidth("25px");
    btnSocnsrAqtnRegVal29.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal29.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal29.getValue() || "".equals(socnsrAqtnRegVal29.getValue())){
        		Window.alert("부과구분부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 부과구분부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL29");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal29 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal29); 
    socnsrAqtnRegVal29.setName("socnsrAqtnRegVal29");
    socnsrAqtnRegVal29.setForceSelection(true);
    socnsrAqtnRegVal29.setMinChars(1);
    socnsrAqtnRegVal29.setDisplayField("commCdNm");
    socnsrAqtnRegVal29.setValueField("commCd");
    socnsrAqtnRegVal29.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal29.setEmptyText("--구분부호선택--");
    socnsrAqtnRegVal29.setSelectOnFocus(true); 
    socnsrAqtnRegVal29.setReadOnly(false);
    socnsrAqtnRegVal29.setEnabled(true); 
    socnsrAqtnRegVal29.setStore(lsSocnsrAqtnRegVal29);  
    socnsrAqtnRegVal29.setFieldLabel("부과구분부호"); 
    socnsrAqtnRegVal29.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrAqtnRegVal38.setValue(lsSocnsrAqtnRegVal29.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal29,"commCd")));
		}
	});
    layoutContainer_12.add(socnsrAqtnRegVal29, new FormData("100%"));
    layoutContainer_9.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_12.setBorders(false);
    
    LayoutContainer layoutContainer_13 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_13.setLayout(frmlytStd);
    
    btnSocnsrAqtnRegVal30 = new Button();  
    btnSocnsrAqtnRegVal30.setWidth("25px");
    btnSocnsrAqtnRegVal30.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal30.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal30.getValue() || "".equals(socnsrAqtnRegVal30.getValue())){
        		Window.alert("부과구분사유를 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 부과구분사유를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL30");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal30 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal30); 
    socnsrAqtnRegVal30.setName("socnsrAqtnRegVal30");
    socnsrAqtnRegVal30.setForceSelection(true);
    socnsrAqtnRegVal30.setMinChars(1);
    socnsrAqtnRegVal30.setDisplayField("commCdNm");
    socnsrAqtnRegVal30.setValueField("commCd");
    socnsrAqtnRegVal30.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal30.setEmptyText("--구분사유선택--");
    socnsrAqtnRegVal30.setSelectOnFocus(true); 
    socnsrAqtnRegVal30.setReadOnly(false);
    socnsrAqtnRegVal30.setEnabled(true); 
    socnsrAqtnRegVal30.setStore(lsSocnsrAqtnRegVal30);  
    socnsrAqtnRegVal30.setFieldLabel("부과구분사유"); 
    socnsrAqtnRegVal30.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrAqtnRegVal39.setValue(lsSocnsrAqtnRegVal30.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal30,"commCd")));
		}
	});
    layoutContainer_13.add(socnsrAqtnRegVal30, new FormData("100%"));
    layoutContainer_9.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_13.setBorders(false);
    cp01.add(layoutContainer_9, new FormData("100%"));
    
    LayoutContainer layoutContainer_10 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_10.setLayout(frmlytStd);
    
    btnSocnsrAqtnRegVal28 = new Button();  
    btnSocnsrAqtnRegVal28.setWidth("25px");
    btnSocnsrAqtnRegVal28.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal28.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal28.getValue() || "".equals(socnsrAqtnRegVal28.getValue())){
        		Window.alert("비고를 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험", "고용보험 비고를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL28");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal28 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal28); 
    socnsrAqtnRegVal28.setName("socnsrAqtnRegVal28");
    socnsrAqtnRegVal28.setForceSelection(true);
    socnsrAqtnRegVal28.setMinChars(1);
    socnsrAqtnRegVal28.setDisplayField("commCdNm");
    socnsrAqtnRegVal28.setValueField("commCd");
    socnsrAqtnRegVal28.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal28.setEmptyText("--선택--");
    socnsrAqtnRegVal28.setSelectOnFocus(true); 
    socnsrAqtnRegVal28.setReadOnly(false);
    socnsrAqtnRegVal28.setEnabled(true); 
    socnsrAqtnRegVal28.setStore(lsSocnsrAqtnRegVal28);  
    socnsrAqtnRegVal28.setFieldLabel("비고"); 
    socnsrAqtnRegVal28.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrAqtnRegVal37.setValue(lsSocnsrAqtnRegVal28.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal28,"commCd")));
		}
	});    
    layoutContainer_10.add(socnsrAqtnRegVal28, new FormData("100%"));
    layoutContainer_10.setBorders(false);
    cp01.add(layoutContainer_10, new FormData("100%"));
    
    LayoutContainer layoutContainer_14 = new LayoutContainer();
    layoutContainer_14.setHeight(100);
    layoutContainer_14.setBorders(false);
    cp01.add(layoutContainer_14, new FormData("100%"));
    
    LayoutContainer layoutContainer_14_1 = new LayoutContainer();
    ButtonBar barbtn03 = new ButtonBar();
    barbtn03.setAlignment(HorizontalAlignment.RIGHT);     
    layoutContainer_14_1.add(barbtn03, new FormData("100"));     
    btn03 = new Button("신고파일"); 
    barbtn03.add(btn03);
    btn03.addListener(Events.Select, new Listener<ButtonEvent>() {
    	public void handleEvent(ButtonEvent e) {
    		excelFileExport("3");
    	}
    });
    
    layoutContainer_14_1.setBorders(false); 
    cp01.add(layoutContainer_14_1, new FormData("100%"));
    
    layoutContainer.add(cp01); 
    
    return layoutContainer;
}

//산재보험
private LayoutContainer rightFormBottom04() { 
    
    LayoutContainer layoutContainer = new LayoutContainer();   
    
    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false);
    cp01.setLayout(new FormLayout());
    cp01.setSize("480", "279");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer1_2 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_2.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer1_1 = new LayoutContainer(new FlowLayout());
    layoutContainer1_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd); 
    
    /** column 산재_월평균보수 : socnsrAqtnRegVal36 */   
    socnsrAqtnRegVal36 = new MSFNumberField();
    socnsrAqtnRegVal36.setAllowDecimals(true); 
    socnsrAqtnRegVal36.setPropertyEditorType(Long.class); 
    socnsrAqtnRegVal36.setFormat(NumberFormat.getDecimalFormat());
    socnsrAqtnRegVal36.setInputStyleAttribute("text-align", "right"); 
    socnsrAqtnRegVal36.setFieldLabel("월평균보수"); 
    socnsrAqtnRegVal36.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal27.setValue(socnsrAqtnRegVal36.getValue());
		}
	});    
    layoutContainer_2.add(socnsrAqtnRegVal36, new FormData("100%"));
    layoutContainer1_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));   
    layoutContainer_2.setBorders(false);
    
    btnSocnsrAqtnRegVal36 = new Button();  
    btnSocnsrAqtnRegVal36.setWidth("25px");
    btnSocnsrAqtnRegVal36.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal36.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal36.getValue() || "".equals(socnsrAqtnRegVal36.getValue())){
        		Window.alert("월평균보수를 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 월평균보수를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL36");
						}
					}
				}); 
        	}
        }
    });
    layoutContainer1_1.add(btnSocnsrAqtnRegVal36,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));      
    layoutContainer1_2.add(layoutContainer1_1, new FormData("100%"));   
    
    layoutContainer_1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal31 = new Button();  
    btnSocnsrAqtnRegVal31.setWidth("25px");
    btnSocnsrAqtnRegVal31.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal31.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal31.getValue() || "".equals(socnsrAqtnRegVal31.getValue())){
        		Window.alert("취득일을 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 취득일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL31");
						}
					}
				}); 
        	}
        }
    });
    /** column 산재_자격취득일 : socnsrAqtnRegVal31 */     
    socnsrAqtnRegVal31 = new DateFieldWithButton(btnSocnsrAqtnRegVal31);   
    new DateFieldMask(socnsrAqtnRegVal31, "9999.99.99"); 
    socnsrAqtnRegVal31.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrAqtnRegVal31.setName("socnsrAqtnRegVal31");
    layoutContainer_3.add(socnsrAqtnRegVal31, new FormData("100%"));
    socnsrAqtnRegVal31.setFieldLabel("취득일");
    socnsrAqtnRegVal31.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal22.setValue(InsrUtils.getConvertStringToDate((String) GWTUtils.getStringFromDate(socnsrAqtnRegVal31.getValue(),"yyyyMMdd"), "yyyyMMdd"));// 연금 상실일
		}
	});    
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_3.setBorders(false);
    
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false);
    
    
    
    LayoutContainer layoutContainer_5 = new LayoutContainer(new FlowLayout());
    layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer1_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_4.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer1_5 = new LayoutContainer(new FlowLayout());
    layoutContainer1_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */ 
    socnsrAqtnRegVal33 = new MSFNumberField();
    socnsrAqtnRegVal33.setAllowDecimals(true); 
    socnsrAqtnRegVal33.setPropertyEditorType(Double.class); 
    socnsrAqtnRegVal33.setFormat(NumberFormat.getDecimalFormat());
    layoutContainer_4.add(socnsrAqtnRegVal33, new FormData("100%"));
    socnsrAqtnRegVal33.setInputStyleAttribute("text-align", "right"); 
    socnsrAqtnRegVal33.setFieldLabel("주소정근로");
    socnsrAqtnRegVal33.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal24.setValue(socnsrAqtnRegVal33.getValue());
		}
	});    
    layoutContainer1_5.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));  
    layoutContainer_4.setBorders(false);
    
    btnSocnsrAqtnRegVal33 = new Button();  
    btnSocnsrAqtnRegVal33.setWidth("25px");
    btnSocnsrAqtnRegVal33.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal33.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal33.getValue() || "".equals(socnsrAqtnRegVal33.getValue())){
        		Window.alert("주소정근로를 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 주소정근로를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL33");
						}
					}
				}); 
        	}
        }
    });
    layoutContainer1_5.add(btnSocnsrAqtnRegVal33,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));  
    layoutContainer1_4.add(layoutContainer1_5, new FormData("100%")); 
   
    layoutContainer_5.add(layoutContainer1_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    
    LayoutContainer layoutContainer_6 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer_6_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_6_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_6_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6_2.setLayout(frmlytStd); 
    
    Button btnSocnsrAqtnRegVal32D = new Button();  
    btnSocnsrAqtnRegVal32D.setIcon(MSFMainApp.ICONS.search()); 
    btnSocnsrAqtnRegVal32D.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
            //data에 값넣기 
       	 fnPopupBass0300("I001"); 
        }
    });
    
    /** column 산재_직종 : socnsrAqtnRegVal32 */   
    socnsrAqtnRegVal32D = new TextFieldWithButton<String>(btnSocnsrAqtnRegVal32D);
    socnsrAqtnRegVal32D.addKeyListener(new KeyListener() {
    	 @Override
        public void componentKeyDown(ComponentEvent event) {
        	
            socnsrAqtnRegVal32D.validate();
            
            if (MSFSharedUtils.allowNulls(socnsrAqtnRegVal32D.getValue()).trim().equals("")) {
            	socnsrAqtnRegVal32.setValue("");
            	socnsrAqtnRegVal32D.setValue(""); 
            }
            
            if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
            	socnsrAqtnRegVal32.setValue("");
            	socnsrAqtnRegVal32D.setValue(""); 
                fnPopupBass0300("I001"); 
            }
            super.componentKeyDown(event);
        }
     });
//    socnsrAqtnRegVal32D.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//        @Override
//        public void handleEvent(BaseEvent be) {  
//            if (MSFSharedUtils.allowNulls(socnsrAqtnRegVal32D.getValue()).trim().equals("")) {
//            	socnsrAqtnRegVal32.setValue("");
//            	socnsrAqtnRegVal32D.setValue(""); 
//            }
//        } 
//    }); 
    socnsrAqtnRegVal32D.setFieldLabel("직종");
    socnsrAqtnRegVal32D.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal23D.setValue(socnsrAqtnRegVal32D.getValue());
		}
	});    
    layoutContainer_6_2.add(socnsrAqtnRegVal32D, new FormData("100%"));
    layoutContainer_6_1.add(layoutContainer_6_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));   //
    
    btnSocnsrAqtnRegVal32 = new Button();  
    btnSocnsrAqtnRegVal32.setWidth("25px");
    btnSocnsrAqtnRegVal32.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal32.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal32.getValue() || "".equals(socnsrAqtnRegVal32.getValue())){
        		Window.alert("직종을 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 직종을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL32");
						}
					}
				}); 
        	}
        }
    });
    layoutContainer_6_1.add(btnSocnsrAqtnRegVal32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));   //
    layoutContainer_6.add(layoutContainer_6_1, new FormData("100%"));

    layoutContainer_6.setBorders(false);
    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   //
    layoutContainer_5.setBorders(false);
    cp01.add(layoutContainer_5, new FormData("100%"));
  
    LayoutContainer layoutContainerd_5 = new LayoutContainer(new FlowLayout());
    layoutContainerd_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_7 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer_7_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_7_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_7_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7_2.setLayout(frmlytStd);
    
    /** column 산재_계약직여부 : socnsrAqtnRegVal34 */      
    socnsrAqtnRegVal34 = new MSFCheckBox(); 
    socnsrAqtnRegVal34.setFieldLabel("계약직여부");
    socnsrAqtnRegVal34.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal25.setValue(socnsrAqtnRegVal34.getValue());
		}
	});    
    layoutContainer_7_2.add(socnsrAqtnRegVal34, new FormData("100%"));
    layoutContainer_7_1.add(layoutContainer_7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
    
    btnSocnsrAqtnRegVal34 = new Button();  
    btnSocnsrAqtnRegVal34.setWidth("25px");
    btnSocnsrAqtnRegVal34.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal34.addListener(Events.Select, new Listener<ButtonEvent>() {
    	public void handleEvent(ButtonEvent e) {
    		MessageBox.confirm("산재보험", "산재보험 계약직여부를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
    			@Override
    			public void handleEvent(MessageBoxEvent be) {
    				//if("Yes".equals(be.getButtonClicked().getText())){
    				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
    					updateInsr2100AllGridBatch("VAL34");
    				}
    			}
    		}); 
    	}
    });
    layoutContainer_7_1.add(btnSocnsrAqtnRegVal34, new FormData("100%"));
    layoutContainer_7_1.add(btnSocnsrAqtnRegVal34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
    layoutContainer_7.add(layoutContainer_7_1, new FormData("100%"));
    
    layoutContainerd_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_7.setBorders(false); 
    
    LayoutContainer layoutContainer_8 = new LayoutContainer(); 
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_8.setLayout(frmlytStd); 
    
    btnSocnsrAqtnRegVal35 = new Button();  
    btnSocnsrAqtnRegVal35.setWidth("25px");
    btnSocnsrAqtnRegVal35.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal35.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal35.getValue() || "".equals(socnsrAqtnRegVal35.getValue())){
        		Window.alert("계약종료월을 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 계약종료월을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL35");
						}
					}
				}); 
        	}
        }
    });
    /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */   
    socnsrAqtnRegVal35 = new TextFieldWithButton(btnSocnsrAqtnRegVal35);
    socnsrAqtnRegVal35.setName("socnsrAqtnRegVal35");
    new TextFieldMask<String>(socnsrAqtnRegVal35, "9999.99");
    layoutContainer_8.add(socnsrAqtnRegVal35, new FormData("100%"));
    socnsrAqtnRegVal35.setFieldLabel("계약종료월");
    socnsrAqtnRegVal35.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrAqtnRegVal26.setValue(socnsrAqtnRegVal35.getValue());
		}
	});    
    layoutContainerd_5.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));    
    layoutContainer_8.setBorders(false);
   
    cp01.add(layoutContainerd_5, new FormData("100%"));
    layoutContainerd_5.setBorders(false);
    
      
    LayoutContainer layoutContainer_9 = new LayoutContainer(new FlowLayout());
    layoutContainer_9.setLayout(new ColumnLayout());
    layoutContainer_9.setBorders(false);
    
    LayoutContainer layoutContainer_12 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_12.setLayout(frmlytStd);
    
    btnSocnsrAqtnRegVal38 = new Button();  
    btnSocnsrAqtnRegVal38.setWidth("25px");
    btnSocnsrAqtnRegVal38.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal38.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal38.getValue() || "".equals(socnsrAqtnRegVal38.getValue())){
        		Window.alert("부과구분부호를 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 부과구분부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL38");
						}
					}
				}); 
        	}
        }
    });
    
    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */     
    socnsrAqtnRegVal38 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal38); 
    socnsrAqtnRegVal38.setName("socnsrAqtnRegVal38");
    socnsrAqtnRegVal38.setForceSelection(true);
    socnsrAqtnRegVal38.setMinChars(1);
    socnsrAqtnRegVal38.setDisplayField("commCdNm");
    socnsrAqtnRegVal38.setValueField("commCd");
    socnsrAqtnRegVal38.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal38.setEmptyText("--구분부호선택--");
    socnsrAqtnRegVal38.setSelectOnFocus(true); 
    socnsrAqtnRegVal38.setReadOnly(false);
    socnsrAqtnRegVal38.setEnabled(true); 
    socnsrAqtnRegVal38.setStore(lsSocnsrAqtnRegVal38);  
    socnsrAqtnRegVal38.setFieldLabel("부과구분부호"); 
    socnsrAqtnRegVal38.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrAqtnRegVal29.setValue(lsSocnsrAqtnRegVal38.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal38,"commCd")));
		}
	});    
    layoutContainer_12.add(socnsrAqtnRegVal38, new FormData("100%"));
    layoutContainer_9.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_12.setBorders(false);
    
    LayoutContainer layoutContainer_13 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_13.setLayout(frmlytStd);
    
    btnSocnsrAqtnRegVal39 = new Button();  
    btnSocnsrAqtnRegVal39.setWidth("25px");
    btnSocnsrAqtnRegVal39.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal39.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal39.getValue() || "".equals(socnsrAqtnRegVal39.getValue())){
        		Window.alert("부과구분사유를 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 부과구분사유를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL39");
						}
					}
				}); 
        	}
        }
    });
    
    socnsrAqtnRegVal39 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal39); 
    socnsrAqtnRegVal39.setName("socnsrAqtnRegVal39");
    socnsrAqtnRegVal39.setForceSelection(true);
    socnsrAqtnRegVal39.setMinChars(1);
    socnsrAqtnRegVal39.setDisplayField("commCdNm");
    socnsrAqtnRegVal39.setValueField("commCd");
    socnsrAqtnRegVal39.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal39.setEmptyText("--구분사유선택--");
    socnsrAqtnRegVal39.setSelectOnFocus(true); 
    socnsrAqtnRegVal39.setReadOnly(false);
    socnsrAqtnRegVal39.setEnabled(true); 
    socnsrAqtnRegVal39.setStore(lsSocnsrAqtnRegVal39);  
    socnsrAqtnRegVal39.setFieldLabel("부과구분사유"); 
    socnsrAqtnRegVal39.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrAqtnRegVal30.setValue(lsSocnsrAqtnRegVal39.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal39,"commCd")));
		}
	});
    
    layoutContainer_13.add(socnsrAqtnRegVal39, new FormData("100%"));
    layoutContainer_9.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    layoutContainer_13.setBorders(false);
    cp01.add(layoutContainer_9, new FormData("100%"));
    
    LayoutContainer layoutContainer_10 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(80); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_10.setLayout(frmlytStd);
    
    
    btnSocnsrAqtnRegVal37 = new Button();  
    btnSocnsrAqtnRegVal37.setWidth("25px");
    btnSocnsrAqtnRegVal37.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrAqtnRegVal37.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrAqtnRegVal37.getValue() || "".equals(socnsrAqtnRegVal37.getValue())){
        		Window.alert("비고를 입력하세요");
        	}else{
	        	MessageBox.confirm("산재보험", "산재보험 비고를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2100AllGridBatch("VAL37");
						}
					}
				}); 
        	}
        }
    });
    socnsrAqtnRegVal37 = new ComboBoxWithButton<BaseModel>(btnSocnsrAqtnRegVal37); 
    socnsrAqtnRegVal37.setName("socnsrAqtnRegVal37");
    socnsrAqtnRegVal37.setForceSelection(true);
    socnsrAqtnRegVal37.setMinChars(1);
    socnsrAqtnRegVal37.setDisplayField("commCdNm");
    socnsrAqtnRegVal37.setValueField("commCd");
    socnsrAqtnRegVal37.setTriggerAction(TriggerAction.ALL);
    socnsrAqtnRegVal37.setEmptyText("--선택--");
    socnsrAqtnRegVal37.setSelectOnFocus(true); 
    socnsrAqtnRegVal37.setReadOnly(false);
    socnsrAqtnRegVal37.setEnabled(true); 
    socnsrAqtnRegVal37.setStore(lsSocnsrAqtnRegVal37);  
    socnsrAqtnRegVal37.setFieldLabel("비고"); 
    socnsrAqtnRegVal37.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrAqtnRegVal28.setValue(lsSocnsrAqtnRegVal37.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal37,"commCd")));
		}
	});    
    layoutContainer_10.add(socnsrAqtnRegVal37, new FormData("100%"));
    layoutContainer_10.setBorders(false);
    cp01.add(layoutContainer_10, new FormData("100%"));
    
    LayoutContainer layoutContainer_14 = new LayoutContainer();
    layoutContainer_14.setHeight(100);
    layoutContainer_14.setBorders(false);
    cp01.add(layoutContainer_14, new FormData("100%"));
    
    LayoutContainer layoutContainer_14_1 = new LayoutContainer();
    ButtonBar barbtn04 = new ButtonBar();
    barbtn04.setAlignment(HorizontalAlignment.RIGHT);     
    layoutContainer_14_1.add(barbtn04, new FormData("100"));     
    btn04 = new Button("신고파일"); 
    barbtn04.add(btn04);
    btn04.addListener(Events.Select, new Listener<ButtonEvent>() {
    	public void handleEvent(ButtonEvent e) {
    		excelFileExport("4");
    	}
    });
    
    layoutContainer_14_1.setBorders(false); 
    cp01.add(layoutContainer_14_1, new FormData("100%"));
    
    layoutContainer.add(cp01); 
    
    return layoutContainer;
}

//기본정보
private LayoutContainer rightForm01() { 
     
     LayoutContainer layoutContainer = new LayoutContainer();   
    
     ContentPanel cp02 = new ContentPanel();
     cp02.setHeaderVisible(false); 
     cp02.setSize(483, 82); 
     cp02.setLayout(new FlowLayout());
     
     LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());
     
     LayoutContainer layoutContainer_2_1 = new LayoutContainer();
     FormLayout frmlytSch = new FormLayout();  
     frmlytSch.setLabelWidth(60); 
     frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
     layoutContainer_2_1.setLayout(frmlytSch);
     
     socnsrAqtnRegVal17Dt = new MSFDateField();   
     socnsrAqtnRegVal17Dt.setReadOnly(true);
     new DateFieldMask(socnsrAqtnRegVal17Dt, "9999.99.99"); 
     socnsrAqtnRegVal17Dt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     socnsrAqtnRegVal17Dt.setName("socnsrAqtnRegVal17Dt");
     layoutContainer_2_1.add(socnsrAqtnRegVal17Dt, new FormData("100%"));
     socnsrAqtnRegVal17Dt.setFieldLabel("취득일자");
     layoutContainer_6.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
     layoutContainer_2_1.setBorders(false);
     
     LayoutContainer layoutContainer_3 = new LayoutContainer();
     layoutContainer_3.setBorders(false);
  //   layoutContainer_3.setBorders(true);
     FormLayout frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_3.setLayout(frmlytStd);
     
     socnsrAqtnRegVal02 = new MSFTextField();
     socnsrAqtnRegVal02.setReadOnly(true);
     layoutContainer_3.add(socnsrAqtnRegVal02, new FormData("100%"));
     socnsrAqtnRegVal02.setFieldLabel("성명");
     layoutContainer_6.add(layoutContainer_3 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23)); 
     
     LayoutContainer layoutContainer_4 = new LayoutContainer();
     layoutContainer_4.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(0); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_4.setLayout(frmlytStd);
     
     socnsrAqtnRegVal03 = new MSFTextField();
     socnsrAqtnRegVal03.setReadOnly(true);
     layoutContainer_4.add(socnsrAqtnRegVal03, new FormData("100%"));
     socnsrAqtnRegVal03.setHideLabel(true);
     layoutContainer_6.add(layoutContainer_4 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16)); 
     
     /** 고용구분 */
     LayoutContainer layoutContaineri_4 = new LayoutContainer();
     layoutContaineri_4.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContaineri_4.setLayout(frmlytStd);
     
     emymtDivNm = new MSFTextField();
     emymtDivNm.setReadOnly(true);
     layoutContaineri_4.add(emymtDivNm, new FormData("100%"));
     emymtDivNm.setFieldLabel("고용구분"); 
     layoutContainer_6.add(layoutContaineri_4 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
    
     cp02.add(layoutContainer_6, new FormData("100%"));  
     
     LayoutContainer layoutContainera7 = new LayoutContainer();
     layoutContainera7.setLayout(new ColumnLayout());
     
     LayoutContainer layoutContainera_1 = new LayoutContainer();
     layoutContainera_1.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainera_1.setLayout(frmlytStd);
     
     socInsrAqtnEmymtNumV  = new MSFTextField();
     layoutContainera_1.add(socInsrAqtnEmymtNumV, new FormData("100%"));
     socInsrAqtnEmymtNumV.setReadOnly(true);
     socInsrAqtnEmymtNumV.setFieldLabel("일련번호");
     layoutContainera7.add(layoutContainera_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
     
     LayoutContainer layoutContainera_2 = new LayoutContainer();
     layoutContainera_2.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainera_2.setLayout(frmlytStd);
      
     
     deptNm = new MSFTextField();
     deptNm.setReadOnly(true);
     layoutContainera_2.add(deptNm, new FormData("100%"));
     deptNm.setFieldLabel("부서");
     
     layoutContainera7.add(layoutContainera_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
     
     

     
     LayoutContainer layoutContainerb_2 = new LayoutContainer();
     layoutContainerb_2.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainerb_2.setLayout(frmlytStd);
      
     
     typOccuNm = new MSFTextField();
     typOccuNm.setReadOnly(true);
     layoutContainerb_2.add(typOccuNm, new FormData("100%"));
     typOccuNm.setFieldLabel("직종");
     
     layoutContainera7.add(layoutContainerb_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
     
     DtilOccuClsDivNm = new MSFTextField();
     DtilOccuClsDivNm.setVisible(false);
     
     cp02.add(layoutContainera7, new FormData("100%"));
      
  
     LayoutContainer layoutContainer17 = new LayoutContainer();
     layoutContainer17.setLayout(new ColumnLayout());
     
     //국적
     LayoutContainer layoutContainer_2 = new LayoutContainer();
     layoutContainer_2.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_2.setLayout(frmlytStd);
     
     Button btnSocnsrAqtnRegVal04D = new Button();  
     btnSocnsrAqtnRegVal04D.setIcon(MSFMainApp.ICONS.search()); 
     btnSocnsrAqtnRegVal04D.addListener(Events.Select, new Listener<ButtonEvent>() {
         public void handleEvent(ButtonEvent e) {
             //data에 값넣기 
        	 fnPopupBass0300("A001"); 
         }
     });
     
     socnsrAqtnRegVal04D = new TextFieldWithButton<String>(btnSocnsrAqtnRegVal04D);
     socnsrAqtnRegVal04D.addKeyListener(new KeyListener() {
    	 @Override
         public void componentKeyDown(ComponentEvent event) {
            
             socnsrAqtnRegVal04D.validate();
             if (MSFSharedUtils.allowNulls(socnsrAqtnRegVal04D.getValue()).trim().equals("")) {
            	 socnsrAqtnRegVal04.setValue("");
                 socnsrAqtnRegVal04D.setValue(""); 
             }
             if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                
            	 socnsrAqtnRegVal04.setValue("");
                 socnsrAqtnRegVal04D.setValue(""); 
                 
                 fnPopupBass0300("A001"); 
             }
             
             super.componentKeyDown(event);
         }
      });
//     socnsrAqtnRegVal04D.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//         @Override
//         public void handleEvent(BaseEvent be) {  
//             if (MSFSharedUtils.allowNulls(socnsrAqtnRegVal04D.getValue()).trim().equals("")) {
//            	 socnsrAqtnRegVal04.setValue("");
//                 socnsrAqtnRegVal04D.setValue(""); 
//             }
//          
//         } 
//   }); 
     layoutContainer_2.add(socnsrAqtnRegVal04D, new FormData("100%"));
     socnsrAqtnRegVal04D.setFieldLabel("국적");
     
     layoutContainer17.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
     
     
     LayoutContainer layoutContainer_11 = new LayoutContainer();
     layoutContainer_11.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
     layoutContainer_11.setLayout(frmlytStd);
     
     socnsrAqtnRegVal05 = new MSFComboBox<BaseModel>(); 
     socnsrAqtnRegVal05.setName("socnsrAqtnRegVal05");
     socnsrAqtnRegVal05.setForceSelection(true);
     socnsrAqtnRegVal05.setMinChars(1);
     socnsrAqtnRegVal05.setDisplayField("commCdNm");
     socnsrAqtnRegVal05.setValueField("commCd");
     socnsrAqtnRegVal05.setTriggerAction(TriggerAction.ALL);
     socnsrAqtnRegVal05.setEmptyText("--체류자격선택--");
     socnsrAqtnRegVal05.setSelectOnFocus(true); 
     socnsrAqtnRegVal05.setReadOnly(false);
     socnsrAqtnRegVal05.setEnabled(true); 
     socnsrAqtnRegVal05.setStore(lsSocnsrAqtnRegVal05);  
     socnsrAqtnRegVal05.setFieldLabel("체류자격"); 
     layoutContainer_11.add(socnsrAqtnRegVal05, new FormData("100%"));
     layoutContainer17.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
     
     LayoutContainer layoutContainer_12 = new LayoutContainer();
     layoutContainer_12.setBorders(false);
     frmlytStd = new FormLayout();  
     frmlytStd.setLabelWidth(60); 
     frmlytStd.setLabelAlign(LabelAlign.LEFT);
     layoutContainer_12.setLayout(frmlytStd);
     
     socnsrAqtnRegVal06 = new MSFCheckBox();
     layoutContainer_12.add(socnsrAqtnRegVal06, new FormData("100%"));
     socnsrAqtnRegVal06.setFieldLabel("대표자");
     layoutContainer17.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
      
     cp02.add(layoutContainer17, new FormData("100%"));
     

//     LayoutContainer layoutContainer27 = new LayoutContainer();
//     layoutContainer27.setLayout(new ColumnLayout());
//     
//     LayoutContainer layoutContainer_21 = new LayoutContainer();
//     layoutContainer_21.setBorders(false);
//     frmlytStd = new FormLayout();  
//     frmlytStd.setLabelWidth(60); 
//     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//     layoutContainer_21.setLayout(frmlytStd);
//     
//     DateField dtfldNewDatefield21 = new DateField();
//     layoutContainer_21.add(dtfldNewDatefield21, new FormData("100%"));
//     dtfldNewDatefield21.setFieldLabel("부서");
//     layoutContainer27.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
//     
//     LayoutContainer layoutContainer_22 = new LayoutContainer();
//     layoutContainer_22.setBorders(false);
//     frmlytStd = new FormLayout();  
//     frmlytStd.setLabelWidth(60); 
//     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//     layoutContainer_22.setLayout(frmlytStd);
//     
//     DateField dtfldNewDatefield_21 = new DateField();
//     layoutContainer_22.add(dtfldNewDatefield_21, new FormData("100%"));
//     dtfldNewDatefield_21.setFieldLabel("직종(사업)");
//     layoutContainer27.add(layoutContainer_22,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
//     
//     LayoutContainer layoutContainer_29 = new LayoutContainer();
//     frmlytStd = new FormLayout();  
//     frmlytStd.setLabelWidth(70); 
//     frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//     layoutContainer_29.setLayout(frmlytStd);
//     
//     DateField dtfldNewDatefield_22 = new DateField();
//     layoutContainer_29.add(dtfldNewDatefield_22, new FormData("100%"));
//     dtfldNewDatefield_22.setFieldLabel("직종세");
//     layoutContainer27.add(layoutContainer_29,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
//     layoutContainer_29.setBorders(false);
//     cp02.add(layoutContainer27);
      
       
     layoutContainer.add(cp02) ;   
     
    return layoutContainer;
       
 }

// 대상자정보 Grid
private  LayoutContainer leftGrid01() {
//	   List<Stock> stocks = null;//TestData.getStocks();   
//	    
//	    RowNumberer r = new RowNumberer();   
//
//	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
//	    configs.add(r);   
//
//	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
//	    // selection model supports the SIMPLE selection mode   
//	    // sm.setSelectionMode(SelectionMode.SIMPLE);   
//	  
//	    configs.add(sm.getColumn());   
//	  
//	    ColumnConfig column = new ColumnConfig();   
//	    column.setId("name");   
//	    column.setHeaderText("작성일자");  
//	    column.setAlignment(HorizontalAlignment.CENTER); 
//	    column.setWidth(100);   
//	    configs.add(column);   
//	  
//	    column = new ColumnConfig();   
//	    column.setId("symbol");   
//	    column.setHeaderText("부서");  
//	    column.setAlignment(HorizontalAlignment.CENTER); 
//	    column.setWidth(100);   
//	    configs.add(column);   
//	    
//	    column = new ColumnConfig();   
//	    column.setId("last");   
//	    column.setHeaderText("성명");   
//	    column.setAlignment(HorizontalAlignment.CENTER);   
//	    column.setWidth(100);   
//	    column.setRenderer(gridNumber);   
//	    configs.add(column);   
//	  
//	    column = new ColumnConfig();   
//	    column.setId("last");   
//	    column.setHeaderText("주민번호");   
//	    column.setAlignment(HorizontalAlignment.CENTER);   
//	    column.setWidth(100);   
//	    column.setRenderer(gridNumber);   
//	    configs.add(column);   
//	    
//	    column = new ColumnConfig();   
//	    column.setId("last");   
//	    column.setHeaderText("피부양자");   
//	    column.setAlignment(HorizontalAlignment.CENTER);   
//	    column.setWidth(100);   
//	    column.setRenderer(gridNumber);   
//	    configs.add(column);   
//	    
//	    /**********************************************
//	     * 신청구분 멀티로우 추가 할것.......
//	     **********************************************/
//	    //체크필드 
//	    column = new ColumnConfig();   
//	    column.setId("last");   
//	    column.setHeaderText("국");   
//	    column.setAlignment(HorizontalAlignment.CENTER);   
//	    column.setWidth(30);   
//	    column.setRenderer(gridNumber);   
//	    configs.add(column);   
//	  
//	    //체크필드 
//	    column = new ColumnConfig("change", "건", 30);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);   
//	    
//	    //체크필드 
//	    column = new ColumnConfig("change", "고", 30);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);    
//	    
//	    //체크필드 
//	    column = new ColumnConfig("change", "산", 30);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);   
//	    
//	    //작성중 - 완료 
//	    column = new ColumnConfig("change", "신고", 30);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);   
//	    
//
//	    column = new ColumnConfig("change", "직종(사업)", 100);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);   
//	  
//
//	    column = new ColumnConfig("change", "직종세", 100);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);   
//	   
//	    
//	    ListStore<Stock> store = new ListStore<Stock>();   
//	    store.add(stocks);   
//	  
//	    ColumnModel cm = new ColumnModel(configs);    
//	    
//	    ContentPanel cp = new ContentPanel();   
//	    cp.setHeaderVisible(false);
//	    cp.setFrame(true);   
//	  //  cp.setIcon(Resources.ICONS.table());   
//	    cp.setLayout(new FitLayout());   
//	    cp.setSize(498, 200);   
//	  
//	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
//	    grid.setSelectionModel(sm);   
//	    grid.setBorders(true);   
//	    grid.setColumnReordering(true);   
//	    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
//	    grid.addPlugin(sm);   
	      
	  
	  
	    LayoutContainer lcStdGrid = new LayoutContainer();
	   // lcStdGrid.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytStd = new FormLayout();  
	  //  frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
		   ContentPanel cp01 = new ContentPanel();   
		   cp01.setBodyBorder(false); 
		   cp01.setHeaderVisible(false);   
		   cp01.setLayout(new FitLayout());      
		   cp01.setSize(461, 412);  
		   
		   //msfCustomForm.setHeaderVisible(false);
	       //Instantiate the GridPanel
		   insr1100GridPanel = new MSFGridPanel(insr1100Def, false, false, false, false,false);
		   insr1100GridPanel.setHeaderVisible(false);  
		   insr1100GridPanel.setBodyBorder(true);
		   insr1100GridPanel.setBorders(true);
		   //insr1100GridPanel.setSize(300, 140);  
		  // insr1100GridPanel.getBottomComponent().setVisible(false);  
		    final Grid<?> insr1100Grid = insr1100GridPanel.getMsfGrid().getGrid(); 
		    insr1100Grid.addListener(Events.RowDoubleClick,  new Listener<BaseEvent>() {
	             public void handleEvent(BaseEvent be) {  
	           	  if (insr1100GridPanel.getCurrentlySelectedItem() != null) {  
	           		  setRecord(insr1100GridPanel.getCurrentlySelectedItem());	
	           		 // setPPRecord(insr1100GridPanel.getCurrentlySelectedItem());
	           	
	           		  dpobCd.setValue(MSFSharedUtils.allowNulls(insr1100GridPanel.getCurrentlySelectedItem().get("dpobCd")));   /** column 사업장코드 : dpobCd */ 
	           	      systemkey.setValue(MSFSharedUtils.allowNulls(insr1100GridPanel.getCurrentlySelectedItem().get("systemkey")));   /** column SYSTEMKEY : systemkey */ 
	           		  soctyInsurCmptnDt.setValue(MSFSharedUtils.allowNulls(insr1100GridPanel.getCurrentlySelectedItem().get("soctyInsurCmptnDt")));   /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
	           		  
	           		 
	           		
	           		  socnsrAqtnRegVal17Dt.setValue(InsrUtils.getConvertStringToDate((String) insr1100GridPanel.getCurrentlySelectedItem().get("socnsrAqtnRegVal17"),"yyyyMMdd"));   /** column 사회보험작성일자 : soctyInsurCmptnDt */
	           		  
	           		  socInsrAqtnEmymtNum.setValue(Long.parseLong(MSFSharedUtils.defaultNulls(insr1100GridPanel.getCurrentlySelectedItem().get("socInsrAqtnEmymtNum"),"0")));   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	           		  cellPhneNum.setValue(MSFSharedUtils.allowNulls(insr1100GridPanel.getCurrentlySelectedItem().get("cellPhneNum"))); //전화번호
	           		  
	           		  int rowIndex = insr1100GridPanel.getMsfGrid().getGrid().getStore().indexOf(insr1100GridPanel.getCurrentlySelectedItem());
	           		  
	           		   if (rowIndex < 1) {
	           			  funcButtonEnabled(true);
	           		   } else {
	           			 funcButtonEnabled(false); 
	           		   }
	           		  /**
	           		   * 조회 - 전체 데이터를 가지고 온다.    
	           		   */
	           		  
	           		  readDtailData();
	           		btn01.setEnabled(true);
	           		btn02.setEnabled(true);
	           		btn03.setEnabled(true);
	           		btn04.setEnabled(true);
	           		  
	           		  actionDatabase = ActionDatabase.UPDATE;
	           		  
	           	  }
	             }
	         });  
 	
		    cp01.add(insr1100GridPanel); 
	    
//		    cp01.addButton(new Button("사업장정보", new SelectionListener<ButtonEvent>() {   
//	  	      @Override  
//	  	      public void componentSelected(ButtonEvent ce) {   
//	  	    	  
//	    			//사업장정보
//	 			  InsrP210004 insrP21004Form = new InsrP210004(ActionDatabase.CUSTOM, getThis());   
//	 			    
//	 			  MSFFormWindows msFwInsr21004 = new MSFFormWindows("사업장정보",insrP21004Form,"닫기","980px", "610px",true);
//	 			  msFwInsr21004.show();
//	 			  insrP21004Form.setMSFFormWindows(msFwInsr21004);
//	 			  insrP21004Form.bind(ppRecord);  
//				    
//	  	      } 
//	  	    }));
	    
		    cp01.addButton(new Button("보수월액산정", new SelectionListener<ButtonEvent>() {   
	  	      @Override  
	  	      public void componentSelected(ButtonEvent ce) {   
	  	    	  
	    			//4대보험보수계산
	 			   InsrP210002 insrP21002Form = new InsrP210002(ActionDatabase.CUSTOM, getThis());   
	 			    
	 			   MSFFormWindows msFwInsr21002 = new MSFFormWindows("4대보험보수계산",insrP21002Form,"닫기","1010px", "650px",true);
	 			   msFwInsr21002.show();
	 			   insrP21002Form.setMSFFormWindows(msFwInsr21002);
	 			  
	 			   funcSetPopUpRecord();

	 			   insrP21002Form.bind(ppRecord);  
	  	      }   
	  	    }));  
	    
		    cp01.addButton(new Button("취득신고내역보기", new SelectionListener<ButtonEvent>() {   
	  	      @Override  
	  	      public void componentSelected(ButtonEvent ce) {   
	  	    	  
	    			//4대보험취득신고내역
	 			  InsrP210005 insrP21005Form = new InsrP210005(ActionDatabase.CUSTOM, getThis());   
	 			    
	 			  MSFFormWindows msFwInsr21005 = new MSFFormWindows("4대보험취득신고내역",insrP21005Form,"닫기","1010px", "650px",true);
	 			  msFwInsr21005.show();
	 			  insrP21005Form.setMSFFormWindows(msFwInsr21005);
	 			  
	 			  funcSetPopUpRecord(); 
	 		      insrP21005Form.bind(ppRecord);  
				    
	  	      }   
	  	    }));  
	     
	    lcStdGrid.add(cp01);  
	   
		return lcStdGrid;  
	   
}

// reload
public void reload() {
			// TODO Auto-generated method stub 
		   
			String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
			String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
			String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
			String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
			
		    if(payrMangDeptCd == null || payrMangDeptCd.equals("") || emymtDivCd == null || emymtDivCd.equals("")){
		    	Window.alert("단위기관 과 고용분을 선택해 주세요");
		    	return;
		    }
		    
		    else if ( emymtDivCd.equals("A0020020") ) {
	    		/*if(deptCd == null || deptCd.equals("") || businCd == null || businCd.equals("")){
	    			Window.alert("기간제 근로자 선택 경우 부서와 사업을 선택해 주세요.");
			    	return;
		    	}*/
		    }
		    	 
		    
		    //Window.alert(""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		    
			IColumnFilter filters = null;
			
			insr1100GridPanel.getTableDef().setTableColumnFilters(filters);
			
			insr1100GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr1100GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			insr1100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			insr1100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 

			//20180305추가 
			insr1100GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
					
 
            String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            insr1100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
            String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            insr1100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//            String strPyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//            insr1100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            insr1100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
			//insr1100GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd") , SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
          
			insr1100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr1100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr1100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
			insr1100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
			 
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
	        insr1100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
              
			insr1100GridPanel.reload();
			funcButtonEnabled(false);
			actionDatabase = ActionDatabase.UPDATE;
		}

public void dpobInfoSearch(){
	
	boolean flag = false;
	BaseModel bm = new BaseModel();
	String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
	String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
	String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
	String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
	bm.set("payrMangDeptCd",payrMangDeptCd);
	bm.set("emymtDivCd", emymtDivCd);
	bm.set("deptCd", deptCd);
	bm.set("businCd", businCd);
	
	if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
		
		if(emymtDivCd.equals("A0020010")){ //공무직
			flag = true;
		}else if(emymtDivCd.equals("A0020020")){ //기간제
			if(deptCd != null && !deptCd.equals("") && businCd != null && !businCd.equals("")){
				flag = true;
			}
		}else{
			flag = false;
		}
		
		if ( flag ){
			insrP210004Service.activityOnReadInsr210004(bm ,
					new AsyncCallback<BaseModel>() {
				public void onFailure(Throwable caught) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
							MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadInsr210004(Read) : " + caught), null);
				}
				public void onSuccess(BaseModel result) { 
					hlthInsrSym.setValue((String) result.get("hlthInsrSym"));
					hlthInsrOfceSym01.setValue((String) result.get("hlthInsrOfceSym"));
					hlthPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));			
					natPennSym.setValue((String) result.get("natPennSym"));
					natPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));			
					umytInsrSym.setValue((String) result.get("umytInsrSym"));
					umytPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));				
					idtlAccdtInsurSym.setValue((String) result.get("idtlAccdtInsurSym"));
					idtlPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));		
					payMangeDeptPhnNum.setValue((String) result.get("payMangeDeptPhnNum"));
					payMangeDeptFaxNum.setValue((String) result.get("payMangeDeptFaxNum"));
					payMangeDeptZpcd.setValue((String) result.get("payMangeDeptZpcd"));
					payMangeDeptAddr.setValue((String) result.get("payMangeDeptFNdtnAddr")+(String) result.get("payMangeDeptDtlPatrAddr"));
					hlthInsrOfceSym.setValue((String) result.get("hlthInsrOfceSym"));
					insurPrvaffAgcyIstutNum.setValue((String) result.get("insurPrvaffAgcyIstutNum"));			
					insurPrvaffAgcyIstutNm.setValue((String) result.get("insurPrvaffAgcyIstutNm"));
					payMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));
				} 
			});
		}
	}
}
	
//폼초기화 검색조건포함 
private void formInit() {
	
	
	
	//검색조건 초기화
	setInitDate();
	srhHdofcCodtnCd.setValue("");					//재직상태
	srhPayrMangDeptCd.setValue(new BaseModel());	//단위기간
	srhEmymtDivCd.setValue(new BaseModel());		// 고용구분
	srhDeptCd.setValue("");							//부서
	srhTypOccuCd.setValue(""); 						//직종
	srhDtilOccuInttnCd.setValue("");				//직종세	
	srhHanNm.setValue("");							//성명
	srhResnRegnNum.setValue("");					//주민번호
	srhBusinCd.setValue(new BaseModel());			//사업
	
	//그리드 삭제
	insr1100GridPanel.getMsfGrid().clearData();
	
	//디테일 값 초기화
	detailClear();
	
	//일괄적용 버튼 비활성
	funcButtonEnabled(false);
	
	//사업장 정보 초기화
}

//디테일 값 초기화
private void detailClear() {
	//기본정보
	systemkey.clear(); soctyInsurCmptnDt.clear(); socnsrAqtnRegVal17Dt.clear(); socInsrAqtnEmymtNum.clear(); emymtDivNm.clear(); deptNm.clear(); typOccuNm.clear(); 
	natPennRegrstYn.clear(); hlthInsrRegrstYn.clear(); umytInsrRegrstYn.clear(); idtlAccdtRegrstYn.clear(); socnsrAqtnRegVal04D.clear();
	socInsrAqtnEmymtNumV.clear();
	socnsrAqtnRegVal02.clear(); socnsrAqtnRegVal03.clear(); socnsrAqtnRegVal04.clear(); socnsrAqtnRegVal05.clear(); socnsrAqtnRegVal06.clear(); socnsrAqtnRegVal07.clear();
	socnsrAqtnRegVal08.clear(); socnsrAqtnRegVal09.clear(); socnsrAqtnRegVal10.clear(); socnsrAqtnRegVal11.clear(); socnsrAqtnRegVal12.clear(); socnsrAqtnRegVal13.clear();
	socnsrAqtnRegVal14.clear(); socnsrAqtnRegVal15.clear(); socnsrAqtnRegVal16.clear(); socnsrAqtnRegVal17.clear(); socnsrAqtnRegVal18.clear(); socnsrAqtnRegVal19.clear();
	socnsrAqtnRegVal20.clear(); socnsrAqtnRegVal21.clear(); socnsrAqtnRegVal22.clear(); socnsrAqtnRegVal23.clear(); socnsrAqtnRegVal24.clear(); socnsrAqtnRegVal25.clear();
	socnsrAqtnRegVal26.clear(); socnsrAqtnRegVal27.clear(); socnsrAqtnRegVal28.clear(); socnsrAqtnRegVal29.clear(); socnsrAqtnRegVal30.clear(); socnsrAqtnRegVal31.clear();
	socnsrAqtnRegVal32.clear(); socnsrAqtnRegVal33.clear(); socnsrAqtnRegVal34.clear(); socnsrAqtnRegVal35.clear(); socnsrAqtnRegVal36.clear(); socnsrAqtnRegVal37.clear();
	socnsrAqtnRegVal38.clear(); socnsrAqtnRegVal39.clear();
	
	//사업장 정보
	hlthInsrSym.clear(); hlthInsrOfceSym01.clear(); hlthPayMangeDeptNm.clear(); natPennSym.clear(); natPayMangeDeptNm.clear();			
	umytInsrSym.clear(); umytPayMangeDeptNm.clear(); idtlAccdtInsurSym.clear(); idtlPayMangeDeptNm.clear();		
	payMangeDeptPhnNum.clear(); payMangeDeptFaxNum.clear(); payMangeDeptZpcd.clear(); payMangeDeptAddr.clear();
	hlthInsrOfceSym.clear(); insurPrvaffAgcyIstutNum.clear(); insurPrvaffAgcyIstutNm.clear(); payMangeDeptNm.clear();
}
	  
public void setRecord(BaseModel record) {
       this.record = record;
}
	 
public void setListRecord(Iterator<Record> records) {
	this.records = records;
}

public Iterator<Record>  getListRecord() {
	return this.records;
}

private Insr2100 getThis(){
	return this;
}

//이름 검색 팝업
private void fnPopupPsnl0100()  {
           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
           //검색.처리하면됨.
          MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
           
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

//대상자 선택 팝업
private void fnPopupInsr2100()  {

	MSFFormPanel popCom2000 = PrgmComPopupUtils.lovPopUpPrgmComInsr2000Form();  //인사  

	popCom2000.setSize("1300px", "650px");
    final FormBinding popBindingCom2000 = popCom2000.getFormBinding();

    popBindingCom2000.addListener(Events.Change, new Listener<BaseEvent>() {
    	
    	public void handleEvent(BaseEvent be) {
    		
    		List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
			
    		if (mapModels != null) { 
    			if (MSFSharedUtils.paramNull(mapModels)) {
    				return;
    			} else {
    				insr2100Service.activityOnInsertInsr2100(mapModels , new AsyncCallback<Long>() {
    					public void onFailure(Throwable caught) {
    						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
    								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertInsr2100(insert) : " + caught), null);
   	           	        }
   	           	        
    					public void onSuccess(Long result) {
    						if (result == 0) {
    							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),"등록 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
   	           	             } else {
   	           	            	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "등록 처리가 완료되었습니다.", null);
   	           	            	 reload(); 
   	           	             }  
   	           	        } 
           	        });
				}  
    		}  
    	}
	});
}

public void setPPRecord(BaseModel ppRecord) {
	this.ppRecord = ppRecord;
}    		   

//setInitDate
private void setInitDate() { 
    	  
    	   Date today = new Date();
    	   int maxDays = 0;
    	   Calendar  intiCal =  Calendar.getInstance(); 
           intiCal.set ( Integer.parseInt( GWTUtils.getStringFromDate(today,"yyyy")), Integer.parseInt(GWTUtils.getStringFromDate(today,"MM")) - 1, 1 );
           srhSoctyInsurCmptnDt01.setValue(intiCal.getTime());
            maxDays = intiCal.getActualMaximum(intiCal.DAY_OF_MONTH); 
           
           if ("02".equals(GWTUtils.getStringFromDate(today,"MM")) && maxDays != 28) {
        	   maxDays = 28;
           } else if ("04".equals(GWTUtils.getStringFromDate(today,"MM")) && maxDays != 30) {
        	   maxDays = 30;
           } else if ("06".equals(GWTUtils.getStringFromDate(today,"MM")) && maxDays != 30) {
        	   maxDays = 30;
           } else if ("09".equals(GWTUtils.getStringFromDate(today,"MM")) && maxDays != 30) {
        	   maxDays = 30;
           } else if ("11".equals(GWTUtils.getStringFromDate(today,"MM")) && maxDays != 30) {
        	   maxDays = 30; 
           }
           Calendar  intieCal =   Calendar.getInstance();
           intieCal.set ( Integer.parseInt( GWTUtils.getStringFromDate(today,"yyyy")), Integer.parseInt(GWTUtils.getStringFromDate(today,"MM")) - 1, maxDays );
          // intiCal.add(Calendar.DATE, maxDays - 1);
          // GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
           srhSoctyInsurCmptnDt02.setValue(intieCal.getTime());
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
   
//직종 선택 팝업
private void fnPopupBass0300(final String itemValue) {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	      
	       final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
	       popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("commCd"))) { 
	                   
	                   if ("A001".equals(itemValue)) {
	                	   //국적
	                	   socnsrAqtnRegVal04D.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
	                	   socnsrAqtnRegVal04.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
	                   } else if ("I001".equals(itemValue)) {
	                	   //고용-직종
	                	   socnsrAqtnRegVal23D.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
	                	   socnsrAqtnRegVal23.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
	                	   //분리 작업 
	                	   socnsrAqtnRegVal32D.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
	                	   socnsrAqtnRegVal32.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
	                   }
	                	   
	               }   
	               
	           }
	       });
	   }
	   
 /**
* 첫번째 로우 클릭시에만 활성화 한다. 전체적용.
* @param boolBtn
*/
private void funcButtonEnabled(boolean boolBtn) {
		   
		   btnSocnsrAqtnRegVal07.setEnabled(boolBtn); 
		   btnSocnsrAqtnRegVal10.setEnabled(boolBtn); 
		   btnSocnsrAqtnRegVal09.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal11.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal12.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal15.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal17.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal16.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal18.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal20.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal21.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal27.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal22.setEnabled(boolBtn); 
		   btnSocnsrAqtnRegVal24.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal26.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal29.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal30.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal28.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal36.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal31.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal33.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal35.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal38.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal39.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal37.setEnabled(boolBtn);  
		   
		   gridAllCheckbox.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal08.setEnabled(boolBtn);  
		   btnSocnsrAqtnRegVal19.setEnabled(boolBtn);
		   btnSocnsrAqtnRegVal23.setEnabled(boolBtn);
		   btnSocnsrAqtnRegVal25.setEnabled(boolBtn);
		   btnSocnsrAqtnRegVal32.setEnabled(boolBtn);
		   btnSocnsrAqtnRegVal34.setEnabled(boolBtn);
		   
		   btn01.setEnabled(boolBtn);
		   btn02.setEnabled(boolBtn);
		   btn03.setEnabled(boolBtn);
		   btn04.setEnabled(boolBtn);
	   }

//funcSetPopUpRecord
private void funcSetPopUpRecord() {

	BaseModel bmRec = new BaseModel();

	bmRec.set("dpobCd",  dpobCd.getValue()); 
	bmRec.set("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd")); 
	bmRec.set("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd") ); 
	bmRec.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	bmRec.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); 

	String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	bmRec.set("deptCd", strDeptCd );

	String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	bmRec.set("typOccuCd", strTypOccuCd); 
	//	           String strPyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
	//	           bmRec.set("pyspGrdeCd", strPyspGrdeCd);  

	String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	bmRec.set("dtilOccuInttnCd", strDtilOccuInttnCd); 
	bmRec.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
	bmRec.set("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue())); 
	bmRec.set("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()));    
	bmRec.set("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()));  

	String strHdofcCodtnCd = InsrUtils.getStrValToBMMultiCombo(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd");  
	bmRec.set("hdofcCodtnCd", strHdofcCodtnCd); 
	bmRec.set("payrMangDeptNm",  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptNm"));
	bmRec.set("emymtDivNm",  MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCdNm")); 
	bmRec.set("deptNm", MSFSharedUtils.allowNulls(srhDeptCd.getValue() ));
	bmRec.set("typOccuNm", MSFSharedUtils.allowNulls(srhTypOccuCd.getValue())); 
	// String strPyspGrdeNm = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeNm");  
	// bmRec.set("pyspGrdeNm", MSFSharedUtils.allowNulls(strPyspGrdeNm));  
	bmRec.set("dtilOccuClsDivNm", MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue())); 
	bmRec.set("businNm", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businNm")); 
	bmRec.set("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue())); 
	bmRec.set("hanNm",  MSFSharedUtils.allowNulls(srhHanNm.getRawValue()));    
	bmRec.set("resnRegnNum",  MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()));   
	bmRec.set("hdofcCodtnNm", MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue())); 
	//bmRec.set("soctyInsurCmptnDt", GWTUtils.getStringFromDate(soctyInsurCmptnDt.getValue(),"yyyyMMdd"));   /** column 사회보험작성일자 : soctyInsurCmptnDt */

	bmRec.set("deptCdAuth", MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""));
	bmRec.set("dtilOccuInttnCdAuth", MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""));			

	bmRec.set("srhRepbtyBusinDivNm",  MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCdNm")); 
	bmRec.set("srhRepbtyBusinDivCd",  MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd")); 
	
	bmRec.set("srhDeptGpNm",  MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCdNm")); 
	bmRec.set("srhDeptGpCd",  MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCd")); 

	setPPRecord(bmRec);
}

//funcSetPopUpRecord2
	private void funcSetPopUpRecord2() {
	
		BaseModel bmRec = new BaseModel();
		
		bmRec.set("systemkey", systemkey.getValue());
		bmRec.set("dpobCd", dpobCd.getValue());
		bmRec.set("hanNm", socnsrAqtnRegVal02.getValue());
		bmRec.set("resnRegnNum", socnsrAqtnRegVal03.getValue());  
		bmRec.set("emymtDivNm",  emymtDivNm.getValue());
	    bmRec.set("currAffnDeptNm", deptNm.getValue());
	    bmRec.set("typOccuNm",  typOccuNm.getValue());
	    bmRec.set("dtilOccuClsDivNm",  DtilOccuClsDivNm.getValue());
	    bmRec.set("insrDpobPhnNum",  payMangeDeptPhnNum.getValue()); //건강보험사업장전화번호
	    bmRec.set("socInsrAqtnEmymtNum",  socInsrAqtnEmymtNum.getValue());
	    bmRec.set("soctyInsurCmptnDt", soctyInsurCmptnDt.getValue());   /** column 사회보험작성일자 : soctyInsurCmptnDt */

	    bmRec.set("payMangeDeptNm",  payMangeDeptNm.getValue()); //건강보험사업장명
	    bmRec.set("hlthInsrSym",  hlthInsrSym.getValue()); //건강보험사업장관리번호
	    bmRec.set("insrUsePhnNum",  cellPhneNum.getValue()); //건강보험사업장관리번호
	    
	    bmRec.set("srhRepbtyBusinDivNm",  MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCdNm")); 
		bmRec.set("srhRepbtyBusinDivCd",  MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd")); 
		
		bmRec.set("srhDeptGpNm",  MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCdNm")); 
		bmRec.set("srhDeptGpCd",  MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCd")); 
	    
	    setPPRecord(bmRec);
}

	//	excelFileExport
	private void excelFileExport(String val) {
		
//		if (insr1100GridPanel.getCurrentlySelectedItem() != null) {
	
			HashMap<String, String> param = new HashMap<String, String>(); 
		  	   
			param.put("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd")); //시작일
			param.put("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd")); //종료일
	
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
		   
			param.put("hdofcCodtnCd", strHdofcCodtnCd); //재직상태
			param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); //단위기관
			param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue())); //성명
			param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); //주민번호
			param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); //고용구분
			param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); //부서
			param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); //직종
			param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); //직종세  
			param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); //사업
			param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue())); 
			param.put("valDiv", val); // 엑셀 출력 구분자 (all, 1, 2, 3, 4 >> 전체, 국민, 건강, 고용, 산재)
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();
	
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
			
			if (insr1100GridPanel.getCurrentlySelectedItem() == null) {  
				systemKeys = "";
			}
			
			param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
			
			if(!(!MSFSharedUtils.isNullAsString(param.get("soctyInsurCmptnDt01"))) && (!MSFSharedUtils.isNullAsString(param.get("soctyInsurCmptnDt02"))) ){
				MessageBox.info("", "기간은 필수 입니다.", null);
			} 
			else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//				} 
//				else { 
					insr1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2100Export.do","extgwtFrame" ,param);
//				}
			}
			else{ 
				insr1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2100Export.do","extgwtFrame" ,param);  
			}
//		}
//		else{ 
//			MessageBox.info("", "대상자를 선택해주세요.", null);  
//		}
	}

//excelFileExport
private void excelFile1550Export() {
	
//	if (insr1100GridPanel.getCurrentlySelectedItem() != null) {  
		
		HashMap<String, String> param = new HashMap<String, String>(); 
		
		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
		
		if (insr1100GridPanel.getCurrentlySelectedItem() == null) {  
			systemKeys = "";
		}
		
		param.put("soctyInsurCmptnDt01",  GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd")); 
		param.put("soctyInsurCmptnDt02",  GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd")); 			
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		//단위기관
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	    param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));    
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
	    param.put("hdofcCodtnCd", strHdofcCodtnCd); 
		param.put("famyQuftDivCd", "I0100001");
		
		//param.put("dpobCd", dpobCd.getValue());
		//param.put("socInsrAqtnEmymtNum", String.valueOf(socInsrAqtnEmymtNum.getValue()));
		//param.put("systemkey", systemkey.getValue()); 
		//param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
		
		insr1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2100_1550Export.do","extgwtFrame" ,param);
//	}
//	else{ 
//		MessageBox.info("", "대상자를 선택해주세요.", null);  
//	}
}
	   
//일괄적용 버튼
private void updateInsr2100AllGridBatch(String val) {
		   
		   Iterator<BaseModel> itBm  = insr1100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();  
		   List<Record>  lsRec  = new ArrayList<Record>();

		   while(itBm.hasNext()) {
			   Record rec  = new Record(itBm.next());
			   lsRec.add(rec);
		   } 
		   setListRecord(lsRec.iterator()); 
		   Iterator<Record> iterRecords = getListRecord();

		   List<Insr1200DTO> listInsr1200dto = new ArrayList<Insr1200DTO>();  
		   while (iterRecords.hasNext()) {
			   
			   Insr1200DTO insr1200Dto = new Insr1200DTO();  
			   Record recData = (Record) iterRecords.next(); 
			   BaseModel bmMapModel = (BaseModel)recData.getModel();
			   
			   insr1200Dto.setBatchDiv(val); // 일괄처리 구분자
			   
			   
			  
	
			   insr1200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")) );                           /** column 사업장코드 : dpobCd */
			   insr1200Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));                     /** column SYSTEMKEY : systemkey */
			   insr1200Dto.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("soctyInsurCmptnDt")) );     /** column 사회보험작성일자 : soctyInsurCmptnDt */
			   insr1200Dto.setSocInsrAqtnEmymtNum(Long.parseLong(MSFSharedUtils.defaultNulls(bmMapModel.get("socInsrAqtnEmymtNum"),"0")));   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			   
			   if (val.equals("VAL01")) { //4대보험 체크박스
				   insr1200Dto.setNatPennRegrstYn(natPennRegrstYn.getValue());    /** column 국민연금신고여부 : natPennRegrstYn */
				   insr1200Dto.setHlthInsrRegrstYn(hlthInsrRegrstYn.getValue());    /** column 건강보험신고여부 : hlthInsrRegrstYn */
				   insr1200Dto.setUmytInsrRegrstYn(umytInsrRegrstYn.getValue());   /** column 고용보험신고여부 : umytInsrRegrstYn */
				   insr1200Dto.setIdtlAccdtRegrstYn(idtlAccdtRegrstYn.getValue());  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
			   }
			   if (val.equals("VAL07")) { //소득월액
				   insr1200Dto.setSocnsrAqtnRegVal07(longToNullChk(socnsrAqtnRegVal07.getValue()));    /** column 국민_소득월액 : socnsrAqtnRegVal07 */
			   }
			   if (val.equals("VAL08")) { //국민_취득월납부여부
				   insr1200Dto.setSocnsrAqtnRegVal08(socnsrAqtnRegVal08.getValue());    /** column 국민_취득월납부여부 : socnsrAqtnRegVal08 */
			   }
			   if (val.equals("VAL09")) { //국민_취득부호
				   insr1200Dto.setSocnsrAqtnRegVal09(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal09,"commCd"));  /** column 국민_취득부호 : socnsrAqtnRegVal09 */
			   }
			   if (val.equals("VAL10")) { //국민_자격취득일
				   insr1200Dto.setSocnsrAqtnRegVal10(GWTUtils.getStringFromDate(socnsrAqtnRegVal10.getValue(),"yyyyMMdd"));    /** column 국민_자격취득일 : socnsrAqtnRegVal10 */
			   }
			   if (val.equals("VAL11")) { //국민_특수직종연금
				   insr1200Dto.setSocnsrAqtnRegVal11(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal11,"commCd"));    /** column 국민_특수직종연금 : socnsrAqtnRegVal11 */
			   }
			   if (val.equals("VAL12")) { //국민_직역연금부호
				   insr1200Dto.setSocnsrAqtnRegVal12(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal12,"commCd"));    /** column 국민_직역연금부호 : socnsrAqtnRegVal12 */
			   }
			   
			   if (val.equals("VAL15")) { //건강_보수월액
				   insr1200Dto.setSocnsrAqtnRegVal15(longToNullChk(socnsrAqtnRegVal15.getValue()));    /** column 건강_보수월액 : socnsrAqtnRegVal15 */
			   }
			   if (val.equals("VAL17")) { //건강_자격취득일
				   insr1200Dto.setSocnsrAqtnRegVal17(GWTUtils.getStringFromDate(socnsrAqtnRegVal17.getValue(),"yyyyMMdd"));    /** column 건강_자격취득일 : socnsrAqtnRegVal17 */
			   }
			   if (val.equals("VAL16")) { //건강_취득부호
				   insr1200Dto.setSocnsrAqtnRegVal16(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal16,"commCd"));  /** column 건강_취득부호 : socnsrAqtnRegVal16 */
			   }
			   if (val.equals("VAL18")) { //건강_감면부호
				   insr1200Dto.setSocnsrAqtnRegVal18(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal18,"commCd"));    /** column 건강_감면부호 : socnsrAqtnRegVal18 */
			   }
			   if (val.equals("VAL19")) { //건강_발송희망
				   insr1200Dto.setSocnsrAqtnRegVal19(socnsrAqtnRegVal19.getValue());    /** column 건강_발송희망 : socnsrAqtnRegVal19 */
			   }
			   if (val.equals("VAL20")) { //건강_회계부호
				   insr1200Dto.setSocnsrAqtnRegVal20(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal20,"commCd"));    /** column 건강_회계부호 : socnsrAqtnRegVal20 */
			   }
			   if (val.equals("VAL21")) { //건강_직종부호
				   insr1200Dto.setSocnsrAqtnRegVal21(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal21,"commCd"));    /** column 건강_직종부호 : socnsrAqtnRegVal21 */
			   }
			   
			   if (val.equals("VAL27")) { //고용_월평균보수
				   insr1200Dto.setSocnsrAqtnRegVal27(longToNullChk(socnsrAqtnRegVal27.getValue()));   
			   }
			   if (val.equals("VAL22")) { //고용_취득일
				   insr1200Dto.setSocnsrAqtnRegVal22(GWTUtils.getStringFromDate(socnsrAqtnRegVal22.getValue(),"yyyyMMdd"));   
			   }
			   if (val.equals("VAL24")) { //고용_주소정근로
				   insr1200Dto.setSocnsrAqtnRegVal24(doubleToNullChk(socnsrAqtnRegVal24.getValue())); 
			   }
			   if (val.equals("VAL23")) { //고용_직종
				   insr1200Dto.setSocnsrAqtnRegVal23(MSFSharedUtils.allowNulls(socnsrAqtnRegVal23.getValue()));
			   }
			   if (val.equals("VAL25")) { //고용_계약직여부
				   insr1200Dto.setSocnsrAqtnRegVal25(socnsrAqtnRegVal25.getValue()); 
			   }
			   if (val.equals("VAL26")) { //고용_계약종료월
				   insr1200Dto.setSocnsrAqtnRegVal26(MSFSharedUtils.allowNulls(socnsrAqtnRegVal26.getValue())); 
			   }
			   if (val.equals("VAL29")) { //고용_부과구분부호
				   insr1200Dto.setSocnsrAqtnRegVal29(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal29,"commCd"));
			   }
			   if (val.equals("VAL30")) { //고용_부과구분사유
				   insr1200Dto.setSocnsrAqtnRegVal30(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal30,"commCd")); 
			   }
			   if (val.equals("VAL28")) { //고용_비고
				   insr1200Dto.setSocnsrAqtnRegVal28(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal28,"commCd")); 
			   }
			   
			   if (val.equals("VAL36")) { //산재_월평균보수
				   insr1200Dto.setSocnsrAqtnRegVal36(longToNullChk(socnsrAqtnRegVal36.getValue()));   
			   }
			   if (val.equals("VAL31")) { //산재_취득일
				   insr1200Dto.setSocnsrAqtnRegVal31(GWTUtils.getStringFromDate(socnsrAqtnRegVal31.getValue(),"yyyyMMdd"));   
			   }
			   if (val.equals("VAL33")) { //산재_주소정근로
				   insr1200Dto.setSocnsrAqtnRegVal33(doubleToNullChk(socnsrAqtnRegVal33.getValue())); 
			   }
			   if (val.equals("VAL32")) { //산재_직종
				   insr1200Dto.setSocnsrAqtnRegVal32(MSFSharedUtils.allowNulls(socnsrAqtnRegVal32.getValue()));
			   }
			   if (val.equals("VAL34")) { //산재_계약직여부
				   insr1200Dto.setSocnsrAqtnRegVal34(socnsrAqtnRegVal34.getValue()); 
			   }
			   if (val.equals("VAL35")) { //산재_계약종료월
				   insr1200Dto.setSocnsrAqtnRegVal35(MSFSharedUtils.allowNulls(socnsrAqtnRegVal35.getValue())); 
			   }
			   if (val.equals("VAL38")) { //산재_부과구분부호
				   insr1200Dto.setSocnsrAqtnRegVal38(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal38,"commCd"));
			   }
			   if (val.equals("VAL39")) { //산재_부과구분사유
				   insr1200Dto.setSocnsrAqtnRegVal39(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal39,"commCd")); 
			   }
			   if (val.equals("VAL37")) { //산재_비고
				   insr1200Dto.setSocnsrAqtnRegVal37(MSFSharedUtils.getSelectedComboValue(socnsrAqtnRegVal37,"commCd")); 
			   }
			   
			   listInsr1200dto.add(insr1200Dto);
		   }
	   
		   insr2100Service.updateInsr2100AllGridBatch(listInsr1200dto, new AsyncCallback<Long>() {
			   public void onFailure(Throwable caught) {
				   MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("updateInsr2100AllGridBatch(Update) : " + caught), null);
			   }
			   public void onSuccess(Long result) {
				   if (result == 0) {
					   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				   } 
				   else {
					   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), result + "건 일괄 적용 처리가 완료되었습니다.", null);
					   reload();
					   actionDatabase = ActionDatabase.UPDATE;
				   }
			   } 
		   });
		   
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
