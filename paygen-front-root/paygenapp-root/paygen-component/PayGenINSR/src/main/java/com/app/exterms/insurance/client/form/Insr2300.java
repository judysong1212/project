package com.app.exterms.insurance.client.form;
 

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr2200DTO;
import com.app.exterms.insurance.client.form.defs.Insr2200Def;
import com.app.exterms.insurance.client.service.Insr2300Service;
import com.app.exterms.insurance.client.service.Insr2300ServiceAsync;
import com.app.exterms.insurance.client.service.InsrP230004Service;
import com.app.exterms.insurance.client.service.InsrP230004ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
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
public class Insr2300    extends MSFPanel {  //extends LayoutContainer { 
 

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
   // private RemtConstants lblRemtConst = RemtConstants.INSTANCE; 
    
    private VerticalPanel vp;
    private FormPanel plFrmInsr2300; 
    private String txtForm = "";
    private XTemplate detailTp; 
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

    //4대보험취득
	  private Insr2200Def insr2200Def  = new Insr2200Def("INSR2300");   //그리드 테이블 컬럼 define  	  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel insr2200GridPanel;
    
    //직종콤보
//	  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	  private MSFGridPanel typOccuCdGridPanel;
	    
     
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
      private ButtonBar topInsr2300Bar;
      private Button btnInsr2300Init;
      private Button btnInsr2300New;
      private Button btnInsr2300Save;
      private Button btnInsr2300Del;
      private Button btnInsr2300Sreach;
      private Button btnInsr2300ExcelFile;
      private Button btnInsr2300Print;
      private Button btnInsr2300Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      

      /** column  년도 : payYr */
      private DateField srhSoctyInsurCmptnDt01;					//작성기간 시작
      private DateField srhSoctyInsurCmptnDt02; 				//작성기간 종료 
      private ComboBox<BaseModel> srhPayCd;     				//급여구분
      private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분 
      private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
      private MSFMultiComboBox<ModelData> srhDeptCd ;    		//부서 
      private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 	//직종세
      private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 		//재직상태  
      
      private ComboBox<BaseModel> srhBusinCd;    				//사업
      private TextField<String> srhHanNm;         				//성명
      private TextField<String> srhResnRegnNum;   				//주민번호 
      private HiddenField<String> srhSystemkey;   				//시스템키
      
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
      
      /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> srhPymtDducDivCd;
       
      private List<ModelData> mDtalistHdofcCodtnCd ;
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      
      private boolean mutilCombo = false;
   
 
      private Boolean emptyCheck = false ;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
       
        private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
		private HiddenField<String> systemkey;   /** column SYSTEMKEY : systemkey */
		private HiddenField<String> soctyInsurCmptnDt;   /** column 사회보험작성일자 : soctyInsurCmptnDt */
		
		private MSFDateField socnsrIssRegVal08Dt; /** column 상실일자 : socnsrIssRegVal08 */
		
		private MSFNumberField socInsrLssEmymtNum;   /** column 사회보험취득_고용_일련번호 : socInsrLssEmymtNum */
    

		 private MSFTextField emymtDivNm; //고용구분 
		 private MSFTextField deptNm; //부서 
		 private MSFTextField typOccuNm; //직종 
		 private MSFTextField DtilOccuClsDivNm; //직종세
		
		private MSFCheckBox allCheck = new MSFCheckBox(); //전체
	 	private MSFCheckBox hlthInsrRegrstYn = new MSFCheckBox();    /** column 건강보험신고여부 : hlthInsrRegrstYn */
	 	private MSFCheckBox natPennRegrstYn = new MSFCheckBox();     /** column 국민연금신고여부 : natPennRegrstYn */
	 	private MSFCheckBox umytInsrRegrstYn = new MSFCheckBox();    /** column 고용보험신고여부 : umytInsrRegrstYn */
	 	private MSFCheckBox idtlAccdtRegrstYn = new MSFCheckBox();   /** column 산재보험신고여부 : idtlAccdtRegrstYn */  
     
   

	 	private MSFTextField  socnsrIssRegVal01;    /** column 공단구분코드 4자리  : socnsrIssRegVal0 */ 
	 	private MSFTextField  socnsrIssRegVal02;    /** column 공통_성명 : socnsrIssRegVal02 */ 
	 	private MSFTextField  socnsrIssRegVal03;   /** column 공통_주민등록번호 : socnsrIssRegVal03 */ 
	 	private MSFTextField  socnsrIssRegVal04;   /** column 공통_전화번호  : socnsrIssRegVal04 */ 
	 	
	 	private DateFieldWithButton socnsrIssRegVal05;   /** column 연금_상실일 : socnsrIssRegVal05 */ 
	 	private ComboBoxWithButton<BaseModel> socnsrIssRegVal06;   /** column 연금_상실부호  : socnsrIssRegVal06 */ 
	 	private MSFCheckBox socnsrIssRegVal07;   /** column 연금_초일.취득당월 상실짜납부여부  : socnsrIssRegVal07 */ 
	 	
	 	private DateFieldWithButton socnsrIssRegVal08;   /** column 건강_상실일자  : socnsrIssRegVal08 */ 
	 	private ComboBoxWithButton<BaseModel> socnsrIssRegVal09;   /** column 건강_상실부호  : socnsrIssRegVal09 */ 
	 	private MSFNumberField socnsrIssRegVal10;   /** column 건강_퇴직전3개월간평균보수  : socnsrIssRegVal10 */ 
	 	private MSFNumberField socnsrIssRegVal11;   /** column 건강_당해년도보수총액  : socnsrIssRegVal11 */ 
	 	private MSFNumberField socnsrIssRegVal12;   /** column 건강_당해년도산정월수 : socnsrIssRegVal12 */ 
	 	private MSFCheckBox socnsrIssRegVal13;   /** column  건강_전년도 정산구분  : socnsrIssRegVal13 */ 
	 	private MSFNumberField socnsrIssRegVal14;   /** column 건강_전년도보수총액  : socnsrIssRegVal14 */ 
	 	private MSFNumberField socnsrIssRegVal15;   /** column 건강_전년도산정월수 : socnsrIssRegVal15 */ 
	 	
	 	private ComboBoxWithButton<BaseModel> socnsrIssRegVal16;   /** column 고용_상실사유 : socnsrIssRegVal16 */ 
	 	private TextFieldWithButton  socnsrIssRegVal17;   /** column 고용_구체적상실사유  : socnsrIssRegVal17 */ 
	 	private DateFieldWithButton socnsrIssRegVal18;   /** column 고용_상실일자  : socnsrIssRegVal18 */ 
	 	private MSFNumberField socnsrIssRegVal19;   /** column 고용_당해년도보수총액  : socnsrIssRegVal19 */ 
	 	
	 	private ComboBoxWithButton<BaseModel> socnsrIssRegVal20;   /** column 산재_상실사유  : socnsrIssRegVal20 */ 
	 	private TextFieldWithButton  socnsrIssRegVal21;   /** column 산재_구체적인상실사유  : socnsrIssRegVal21 */ 
	 	private DateFieldWithButton socnsrIssRegVal22;   /** column 산재_상실일자  : socnsrIssRegVal22 */ 
	 	private MSFNumberField socnsrIssRegVal23;   /** column 산재_당해년도보수총액  : socnsrIssRegVal23 */ 
	 	

 
       
	 	private Button	btnSocnsrIssRegVal05;
	 	private Button	btnSocnsrIssRegVal06;
	 	private Button	btnSocnsrIssRegVal08;
	 	private Button	btnSocnsrIssRegVal09;
	 	private Button	btnSocnsrIssRegVal10;
	 	private Button	btnSocnsrIssRegVal18;
	 	private Button	btnSocnsrIssRegVal16;
	 	private Button  btnSocnsrIssRegVal17;	
	 	private Button  btnSocnsrIssRegVal22;
	 	private Button  btnSocnsrIssRegVal20;
	 	private Button  btnSocnsrIssRegVal21;
	 	
	 	
	 	private TabItem tabitem01; 
	 	private TabItem tabitem02; 
	 	private TabItem tabitem03; 
	 	private TabItem tabitem04; 
	 	
	 	private MSFTextField hlthInsrSym;
	 	private MSFTextField hlthInsrOfceSym01;
	 	private MSFTextField hlthPayMangeDeptNm;
	 	private MSFTextField natPennSym;
	 	private MSFTextField natPayMangeDeptNm;
	 	private MSFComboBox umytInsrSym;
	 	private MSFTextField umytPayMangeDeptNm;
	 	private MSFComboBox idtlAccdtInsurSym;
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
	 	private HiddenField<String> retryDt;   				
	 	
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
	 			  private void checkInsr2300Auth( String authAction, ListStore<BaseModel> bm) {   
	 		    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
	 				 
	 				 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

	 					if (!maskTracker) { unmask(); }  
	 		                //MSFMainApp.unmaskMainPage();
	 					authExecEnabled();
	 					gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화   
	 				   }
	 			  }
	 			  
	 			  
//	 		  private AuthAction authAction;
//	 		  private int checkCntDef = 4;   //체크 값 갯수 
//	 		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//	 		  /**
//	 		   * 권한설정 처리 체크 
//	 		   * AuthAction 
//	 		   */
//	 		  private void checkInsr2300Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	 	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//	 			 
//	 			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//	 			    
//	 	             
//	 	                
//	 	                //----------------------------------------------------
//	 	                unmask(); 
//	 	                //MSFMainApp.unmaskMainPage();
//	 	                 
//	 			   }
//	 		  }
	 			  
	 			 private void authExecEnabled() { 
	 				  //----------------------------------------------------
	 	               Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd}; 	
	 	               
	 	               gwtAuthorization.formAuthFieldConfig(fldArrField);
	 	               
	 	               
	 	               setInitDate();
	 	                srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(1), true); 
	 		            srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(1).get("commCdNm").toString());
					   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 	                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	 	                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	 	                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					//  gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
	 	                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 	                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
	 	                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
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
				     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
			         authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
				     authMapDef.put("srhDeptCd",Boolean.FALSE);
				   //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
					 
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
	    private void setInsr2300FormBinding() {
	 	 
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
	    private Insr2300ServiceAsync insr2300Service = Insr2300Service.Util.getInstance();
	    private InsrP230004ServiceAsync insrP230004Service = InsrP230004Service.Util.getInstance();
	            
	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
  		
  		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  		
  		//--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
  		//--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
  		
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
  	    //--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
  		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
  		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
  		
  		 
  		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
  		

  	    private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
    	private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  
  		
  		private ListStore<BaseModel>  lsSocnsrIssRegVal06 = new ListStore<BaseModel>();/** column 연금_상실부호  : lsSocnsrIssRegVal06 */       
  		private ListStore<BaseModel>  lsSocnsrIssRegVal09 = new ListStore<BaseModel>();/** column 건강_상실부호  : lsSocnsrIssRegVal09 */       
  		private ListStore<BaseModel>  lsSocnsrIssRegVal13 = new ListStore<BaseModel>();/** column  건강_전년도 정산구분  : lsSocnsrIssRegVal13 */  
  		private ListStore<BaseModel>  lsSocnsrIssRegVal16 = new ListStore<BaseModel>();/** column 고용_상실사유 : lsSocnsrIssRegVal16 */        
  		private ListStore<BaseModel>  lsSocnsrIssRegVal20 = new ListStore<BaseModel>();/** column 산재_상실사유  : lsSocnsrIssRegVal20 */       

  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
  		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
  		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
  		private SysCoCalendarDTO msfCoCalendarDto;  
  		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
  		 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
  		 
	    private BaseModel record;
    
	    private  Iterator<Record> records;
	    
	    private BaseModel ppRecord; //팝업에 넘길 레코드 값   
    
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
    private SelectionListener<ButtonEvent> selectionListener = 
	        new SelectionListener<ButtonEvent>() {
	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnRemt0100Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnRemt0100Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnRemt0100Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }

	        }  
	    };
    
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
           break;
        case UPDATE:
        	 updateInsr2300();
            break;
        case DELETE:
        	deleteInsr2200();       	
            break;
        }
    }
    
    
    private void updateInsr2300() {
     
    	 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	            return;
	        }
	         
	        Insr2200DTO insr2200Dto = new Insr2200DTO(); 
	 
	        
	        insr2200Dto.setDpobCd(dpobCd.getValue());                           /** column 사업장코드 : dpobCd */
	 		insr2200Dto.setSystemkey(systemkey.getValue());                     /** column SYSTEMKEY : systemkey */
	 		insr2200Dto.setSoctyInsurCmptnDt(soctyInsurCmptnDt.getValue());     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
	 		insr2200Dto.setSocInsrLssEmymtNum(socInsrLssEmymtNum.getValue().longValue()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	 		 

			insr2200Dto.setHlthInsrRegrstYn(hlthInsrRegrstYn.getValue());    /** column 건강보험신고여부 : hlthInsrRegrstYn */
			insr2200Dto.setNatPennRegrstYn(natPennRegrstYn.getValue());    /** column 국민연금신고여부 : natPennRegrstYn */
			insr2200Dto.setUmytInsrRegrstYn(umytInsrRegrstYn.getValue());   /** column 고용보험신고여부 : umytInsrRegrstYn */
			insr2200Dto.setIdtlAccdtRegrstYn(idtlAccdtRegrstYn.getValue());  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
			//insr2200Dto.setSoctyInsurLssDt(soctyInsurLssDt);
			
			String socnsrIssRegVal01 = "";
			if(natPennRegrstYn.getValue()) socnsrIssRegVal01 += "Y";	else socnsrIssRegVal01 += "N";
			if(hlthInsrRegrstYn.getValue()) socnsrIssRegVal01 += "Y";	else socnsrIssRegVal01 += "N";
			if(umytInsrRegrstYn.getValue()) socnsrIssRegVal01 += "Y";	else socnsrIssRegVal01 += "N";
			if(idtlAccdtRegrstYn.getValue()) socnsrIssRegVal01 += "Y";	else socnsrIssRegVal01 += "N";
			
			insr2200Dto.setSocnsrIssRegVal01(socnsrIssRegVal01);    /** column 사회보험취득신고_ITEM_VALUE01 : socnsrIssRegVal01 */
			insr2200Dto.setSocnsrIssRegVal02(MSFSharedUtils.allowNulls(socnsrIssRegVal02.getValue()));         /** column 성명 : socnsrIssRegVal02 */                                                                                       
			insr2200Dto.setSocnsrIssRegVal03(MSFSharedUtils.allowNulls(socnsrIssRegVal03.getValue()));   	/** column 주민등록번호 : socnsrIssRegVal03 */                                                                                   
			insr2200Dto.setSocnsrIssRegVal04(MSFSharedUtils.allowNulls(socnsrIssRegVal04.getValue()));   /** column 전화번호 : socnsrIssRegVal04 */                                                                                       
			insr2200Dto.setSocnsrIssRegVal05(GWTUtils.getStringFromDate(socnsrIssRegVal05.getValue(),"yyyyMMdd"));   /** column 연금_상실일 : socnsrIssRegVal05 */                                                                                     
			insr2200Dto.setSocnsrIssRegVal06(MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal06,"commCd"));   /** column 연금_상실부호 : socnsrIssRegVal06 */                                                                                    
			insr2200Dto.setSocnsrIssRegVal07(socnsrIssRegVal07.getValue());   /** column 연금_초일취득,당월상실자 납부여부 : socnsrIssRegVal07 */                                                                                  
			insr2200Dto.setSocnsrIssRegVal08(GWTUtils.getStringFromDate(socnsrIssRegVal08.getValue(),"yyyyMMdd"));   /** column 건강_상실일 : socnsrIssRegVal08 */                                                                               
			insr2200Dto.setSocnsrIssRegVal09(MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal09,"commCd"));   /** column 건강_상실부호 : socnsrIssRegVal09 */                                                                                  
			insr2200Dto.setSocnsrIssRegVal10(longToNullChk(socnsrIssRegVal10.getValue()));   /** column 건강_퇴직전3개월평균보수 : socnsrIssRegVal10 */                                                                                 
			insr2200Dto.setSocnsrIssRegVal11(longToNullChk(socnsrIssRegVal11.getValue()));   /** column 건강_당해년도 보수총액 : socnsrIssRegVal11 */                                                                                  
			insr2200Dto.setSocnsrIssRegVal12(longToNullChk(socnsrIssRegVal12.getValue()));   /** column 건강_당해년도 산정월수 : socnsrIssRegVal12 */   
			
			if(socnsrIssRegVal13.getValue()){
         		insr2200Dto.setSocnsrIssRegVal13("2");   /** column 건강_전년도 정산구분 : socnsrIssRegVal13 */           
			}else{
				if(0 < longToNullChk(socnsrIssRegVal14.getValue()) || 0 < longToNullChk(socnsrIssRegVal14.getValue())){
					insr2200Dto.setSocnsrIssRegVal13("2");
					socnsrIssRegVal13.setValue(true);
				}else{
					insr2200Dto.setSocnsrIssRegVal13("0"); 
				}
			}
			//insr2200Dto.setSocnsrIssRegVal13(socnsrIssRegVal13.getValue());   /** column 건강_전년도 정산구분 : socnsrIssRegVal13 */                                                                               
			insr2200Dto.setSocnsrIssRegVal14(longToNullChk(socnsrIssRegVal14.getValue()));   /** column 건강_전년도 보수총액 : socnsrIssRegVal14 */                                                                               
			insr2200Dto.setSocnsrIssRegVal15(longToNullChk(socnsrIssRegVal15.getValue()));   /** column 건강_전년도 산정월수 : socnsrIssRegVal15 */        
			
			
			
			insr2200Dto.setSocnsrIssRegVal16( MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal16,"commCd"));   /** column 고용_상실사유 : socnsrIssRegVal16 */                                                                                  
			insr2200Dto.setSocnsrIssRegVal17(MSFSharedUtils.allowNulls(socnsrIssRegVal17.getValue()));   /** column 공용_구체적 상실사유 : socnsrIssRegVal17 */                                                                                 
			insr2200Dto.setSocnsrIssRegVal18(GWTUtils.getStringFromDate(socnsrIssRegVal18.getValue(),"yyyyMMdd"));   /** column 고용_상실일 : socnsrIssRegVal18 */                                                                                    
			insr2200Dto.setSocnsrIssRegVal19(longToNullChk(socnsrIssRegVal19.getValue()));   /** column 고용_당해년도 보수총액 : socnsrIssRegVal19 */     
			
			insr2200Dto.setSocnsrIssRegVal20(MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal20,"commCd") );   /** column 산재_상실사유 : socnsrIssRegVal20 */                                                                                    
			insr2200Dto.setSocnsrIssRegVal21(MSFSharedUtils.allowNulls(socnsrIssRegVal21.getValue()));   /** column 산재_구체적상실사유 : socnsrIssRegVal21 */                                                                                    
			insr2200Dto.setSocnsrIssRegVal22(GWTUtils.getStringFromDate(socnsrIssRegVal22.getValue(),"yyyyMMdd")  );   /** column 산재_상실일 : socnsrIssRegVal22 */                                                                                 
			insr2200Dto.setSocnsrIssRegVal23(longToNullChk((socnsrIssRegVal23.getValue())));   /** column 산재_당해년도 보수총액 : socnsrIssRegVal23 */                                                                                    
                                                                               
                                                                  
			 
	  
	 		insr2300Service.activityOnUpdateInsr2300(insr2200Dto ,
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
    
    
    private void deleteInsr2200() {
        
    	
    	
    }
    
    
    private void updateInsr2200Bnde(String no){

    	int rowCnt = insr2200GridPanel.getMsfGrid().getGrid().getStore().getModels().size();
    	List<Insr2200DTO> insrArr = new ArrayList<Insr2200DTO>();

    	if(rowCnt > 0){
    		for(int i=0; i<rowCnt; i++){
    			Insr2200DTO insr2200Dto = new Insr2200DTO(); 
    			insr2200Dto.setDpobCd((String) insr2200GridPanel.getMsfGrid().getGrid().getStore().getAt(i).get("dpobCd"));
    			insr2200Dto.setSystemkey((String) insr2200GridPanel.getMsfGrid().getGrid().getStore().getAt(i).get("systemkey"));                                                                                          /** column SYSTEMKEY : systemkey */
    			insr2200Dto.setSoctyInsurCmptnDt((String) insr2200GridPanel.getMsfGrid().getGrid().getStore().getAt(i).get("soctyInsurCmptnDt"));      /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
    			insr2200Dto.setSocInsrLssEmymtNum( (Long) insr2200GridPanel.getMsfGrid().getGrid().getStore().getAt(i).get("socInsrLssEmymtNum")); 	 /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */

    			if(no.equals("05")){
    				insr2200Dto.setSocnsrIssRegVal05(GWTUtils.getStringFromDate(socnsrIssRegVal05.getValue(),"yyyyMMdd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("06")){
    				insr2200Dto.setSocnsrIssRegVal06(MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal06,"commCd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("08")){
    				insr2200Dto.setSocnsrIssRegVal08(GWTUtils.getStringFromDate(socnsrIssRegVal08.getValue(),"yyyyMMdd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("09")){
    				insr2200Dto.setSocnsrIssRegVal09(MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal09,"commCd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("10")){
    				insr2200Dto.setSocnsrIssRegVal10(longToNullChk(socnsrIssRegVal10.getValue()));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("16")){
    				insr2200Dto.setSocnsrIssRegVal16( MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal16,"commCd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("17")){
    				insr2200Dto.setSocnsrIssRegVal17(MSFSharedUtils.allowNulls(socnsrIssRegVal17.getValue()));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("18")){
    				insr2200Dto.setSocnsrIssRegVal18(GWTUtils.getStringFromDate(socnsrIssRegVal18.getValue(),"yyyyMMdd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("20")){
    				insr2200Dto.setSocnsrIssRegVal20(MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal20,"commCd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else if(no.equals("21")){
    				insr2200Dto.setSocnsrIssRegVal21(MSFSharedUtils.allowNulls(socnsrIssRegVal21.getValue()));     
    			}else if(no.equals("22")){
    				insr2200Dto.setSocnsrIssRegVal22(GWTUtils.getStringFromDate(socnsrIssRegVal22.getValue(),"yyyyMMdd"));      /** column 연금_상실일 : socnsrIssRegVal05 */
    			}else{

    			}
    			insrArr.add(insr2200Dto);
    		}
    		insr2300Service.activityOnUpdateInsr2300(insrArr ,
    				new AsyncCallback<Long>() {
    			public void onFailure(Throwable caught) {
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
    						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateInsr2100(Save) : " + caught), null);
    			}
    			public void onSuccess(Long result) {  
    				if (result == 0) {
    					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
    							actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
    				} else {
    					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    							actionDatabase + "처리가 완료되었습니다.", null);
    					reload();
    					actionDatabase = ActionDatabase.UPDATE;
    				} 
    			} 
    		});
    	}else{
    		Window.alert("저장할 대상이 없습니다.");
    	}
    }
    
    
	  /**
     * 그리드 선택시 데이타 가져오기 
     */
    private void readDtailData() {
        
        if (MSFSharedUtils.paramNull(systemkey.getValue())) {
            return;
        }
         
        Insr2200DTO insr2200Dto = new Insr2200DTO(); 
 
        
 		insr2200Dto.setDpobCd(dpobCd.getValue());                           /** column 사업장코드 : dpobCd */
 		insr2200Dto.setSystemkey(systemkey.getValue());                     /** column SYSTEMKEY : systemkey */
 		insr2200Dto.setSoctyInsurCmptnDt(soctyInsurCmptnDt.getValue());     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
 		insr2200Dto.setSocInsrLssEmymtNum((socInsrLssEmymtNum.getValue().longValue())); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
  
 		insr2300Service.activityOnReadInsr2200(insr2200Dto ,
                new AsyncCallback<Insr2200DTO>() {
        public void onFailure(Throwable caught) {
        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadInsr2200(Read) : " + caught), null);
        }
        public void onSuccess(Insr2200DTO result) { 
           //결과값맵핑 
        	//dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
			//systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//soctyInsurCmptnDt.setValue(result.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
			//socInsrLssEmymtNum.setValue(result.getSocInsrLssEmymtNum().longValue());    /** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
			

			hlthInsrRegrstYn.setValue( result.getHlthInsrRegrstYn());    /** column 건강보험신고여부 : hlthInsrRegrstYn */
			natPennRegrstYn.setValue( result.getNatPennRegrstYn());    /** column 국민연금신고여부 : natPennRegrstYn */
			umytInsrRegrstYn.setValue( result.getUmytInsrRegrstYn());    /** column 고용보험신고여부 : umytInsrRegrstYn */
			idtlAccdtRegrstYn.setValue( result.getIdtlAccdtRegrstYn());    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
			 
			//socnsrIssRegVal01.setValue(result.getSocnsrIssRegVal01());    /** column 공단구분코드 4자리  : socnsrIssRegVal0 */
			socnsrIssRegVal02.setValue(result.getSocnsrIssRegVal02());     /** column 공통_성명 : socnsrIssRegVal02 */                              
			socnsrIssRegVal03.setValue(result.getSocnsrIssRegVal03());    /** column 공통_주민등록번호 : socnsrIssRegVal03 */                   
			socnsrIssRegVal04.setValue(result.getSocnsrIssRegVal04());    /** column 공통_전화번호  : socnsrIssRegVal04 */
			socnsrIssRegVal05.setValue(GWTUtils.getDateFromString(result.getSocnsrIssRegVal05(), "yyyyMMdd"));    /** column 연금_상실일 : socnsrIssRegVal05 */   
			socnsrIssRegVal06.setValue(lsSocnsrIssRegVal06.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrIssRegVal06())));    /** column 연금_상실부호  : socnsrIssRegVal06 */                    
			socnsrIssRegVal07.setValue(result.getSocnsrIssRegVal07());    /** column 연금_초일.취득당월 상실짜납부여부  : socnsrIssRegVal07 */         
			socnsrIssRegVal08.setValue(GWTUtils.getDateFromString(result.getSocnsrIssRegVal08(), "yyyy.MM.dd"));    /** column 건강_상실일자  : socnsrIssRegVal08 */                    
			socnsrIssRegVal09.setValue(lsSocnsrIssRegVal09.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrIssRegVal09())));    /** column 건강_상실부호  : socnsrIssRegVal09 */                    
			socnsrIssRegVal10.setValue((Long)result.getSocnsrIssRegVal10());    /** column 건강_퇴직전3개월간평균보수  : socnsrIssRegVal10 */             
			socnsrIssRegVal11.setValue(result.getSocnsrIssRegVal11());    /** column 건강_당해년도보수총액  : socnsrIssRegVal11 */                
			socnsrIssRegVal12.setValue(result.getSocnsrIssRegVal12());    /** column 건강_당해년도산정월수 : socnsrIssRegVal12 */                 
			//socnsrIssRegVal13.setValue(lsSocnsrIssRegVal13.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrIssRegVal13())));    /** column  건강_전년도 정산구분  : socnsrIssRegVal13 */               
			socnsrIssRegVal14.setValue(result.getSocnsrIssRegVal14());    /** column 건강_전년도보수총액  : socnsrIssRegVal14 */                 
			socnsrIssRegVal15.setValue(result.getSocnsrIssRegVal15());    /** column 건강_전년도산정월수 : socnsrIssRegVal15 */                  
			socnsrIssRegVal16.setValue(lsSocnsrIssRegVal16.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrIssRegVal16())));    /** column 고용_상실사유 : socnsrIssRegVal16 */                     
			socnsrIssRegVal17.setValue(result.getSocnsrIssRegVal17());    /** column 고용_구체적상실사유  : socnsrIssRegVal17 */                 
			socnsrIssRegVal18.setValue(GWTUtils.getDateFromString(result.getSocnsrIssRegVal18(), "yyyy.MM.dd"));    /** column 고용_상실일자  : socnsrIssRegVal18 */                    
			socnsrIssRegVal19.setValue(result.getSocnsrIssRegVal19());    /** column 고용_당해년도보수총액  : socnsrIssRegVal19 */                
			socnsrIssRegVal20.setValue(lsSocnsrIssRegVal20.findModel("commCd",MSFSharedUtils.allowNulls(result.getSocnsrIssRegVal20())));    /** column 산재_상실사유  : socnsrIssRegVal20 */                    
			socnsrIssRegVal21.setValue(result.getSocnsrIssRegVal21());    /** column 산재_구체적인상실사유  : socnsrIssRegVal21 */                
			socnsrIssRegVal22.setValue(GWTUtils.getDateFromString(result.getSocnsrIssRegVal22(), "yyyy.MM.dd"));    /** column 산재_상실일자  : socnsrIssRegVal22 */                    
			socnsrIssRegVal23.setValue(result.getSocnsrIssRegVal23());    /** column 산재_당해년도보수총액  : socnsrIssRegVal23 */                
 
			emymtDivNm.setValue(result.getEmymtDivNm());	/** column 고용구분  : emymtDivNm */
			deptNm.setValue(result.getDeptNm());	/** column 부서  : deptNm */
			typOccuNm.setValue(result.getTypOccuNm());	/** column 직종  : typOccuNm */
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
	private void Remt0100Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "INSR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
 	String serarchParam = "";
//		
//		String name = searchName.getValue() == null ? "" : searchName.getValue();
//		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
//		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
//		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
//		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
//		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
//		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
//		
//		serarchParam += "["+name+"]";
//		serarchParam += "["+resn+"]";
//		serarchParam += "["+hdofcCodtnCd+"]";
//		serarchParam += "[]";
//		//serarchParam += "["+manageDeptCd+"]";
//		serarchParam += "["+deptCd+"]";
//		serarchParam += "["+emymtDivCd+"]";
//		serarchParam += "["+typOccuCd+"]";
		
//		List<BaseModel> list = payr0650GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
		String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
		 
		//String strParam = "/rp " + "[" + "20080311" + "]";
		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
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
  
	  public ContentPanel getViewPanel(){
          if(panel == null){
               
        	  //콤보 권한초기화
			   initLoad(); 
				
              detailTp = XTemplate.create(getDetailTemplate()); 
              
              vp = new VerticalPanel();
              vp.setSpacing(10);
              createInsr2300Form();  //화면 기본정보를 설정
              createSearchForm();    //검색필드를 적용 
              createForm();    //기본정보필드   
              //엣지변환
              //vp.setSize("1010px", "750px");
              vp.setSize("1010px", "800px");
                  
              panel = new ContentPanel();
              panel.setBodyBorder(false);
              panel.setBorders(false);
              panel.setHeaderVisible(false);
              panel.setScrollMode(Scroll.AUTO);  
              panel.add(vp);
              funcButtonEnabled(false); 
              
          }
          return panel;
      }
	 
//  @Override
//  protected void onRender(Element parent, int index) {
//    super.onRender(parent, index);
//    
//    detailTp = XTemplate.create(getDetailTemplate()); 
//    
//    vp = new VerticalPanel();
//    vp.setSpacing(10);
//    createInsr2300Form();  //화면 기본정보를 설정
//    createSearchForm();    //검색필드를 적용 
//    createForm();    //기본정보필드  
//    add(vp);
//    vp.setSize("1010px", "750px");
//  }
  
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
  public Insr2300() {
	  //엣지변환
	  //setSize("1010px", "750px");  
      setSize("1010px", "800px");  
  } 

  public Insr2300(String txtForm) {
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
	 
private void createInsr2300Form() {
    
    plFrmInsr2300 = new FormPanel();
   
   // plFrmInsr2300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Remt0100());
    plFrmInsr2300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 사회보험상실신고"));
    plFrmInsr2300.setIcon(MSFMainApp.ICONS.text());
    //plFrmInsr2300.setBodyStyleName("pad-text");
    plFrmInsr2300.setPadding(2);
    plFrmInsr2300.setFrame(true); 
    
    /************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	final Button btnlogView = new Button("로그");   
	
	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //로그 뷰화면 호출 메서드 
			  funcLogMessage("사회보험상실신고","INSR2300");
			}
		});
	plFrmInsr2300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	plFrmInsr2300.getHeader().addTool(btnlogView); 
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 
	 ************************************************************************/


	   //멀티콤보박스 닫기 
    plFrmInsr2300.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
     @Override
     public void handleEvent(ComponentEvent ce) { 
     
      //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
             
     //        if (f instanceof MSFMultiComboBox<?>) {
                 
//                 if ("srhDeptCd".equals(f.getName())) {
//                     
//                 } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                     
//                 }
                 
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
 
 
    topInsr2300Bar = new ButtonBar();    
	 topInsr2300Bar.setAlignment(HorizontalAlignment.RIGHT);

	      
   //초기화 
     btnInsr2300Init = new Button("초기화");  
     btnInsr2300Init.setIcon(MSFMainApp.ICONS.new16());
     topInsr2300Bar.add(btnInsr2300Init);
     btnInsr2300Init.addListener(Events.Select, new Listener<ButtonEvent>() {
         public void handleEvent(ButtonEvent e) {
             //초기화 버튼 클릭시 처리     
           
        	//검색조건 초기화
				//resetSearchForm();
				//insr2200GridPanel.clearState();
				//insr2200GridPanel.getGrid().clearState();
				//insr2200GridPanel.getMsfGrid().getGrid().
				//insr2200GridPanel.removeAll();
				insr2200GridPanel.getMsfGrid().clearData();
				
				resetForm();
		        
				
         }
     });
	      
  //신규 
   btnInsr2300New = new Button("대상자선택");  
   btnInsr2300New.setIcon(MSFMainApp.ICONS.new16());
   topInsr2300Bar.add(btnInsr2300New);
   btnInsr2300New.addListener(Events.Select, new Listener<ButtonEvent>() {
       public void handleEvent(ButtonEvent e) {
           
       	fnPopupInsr2300();   
            
       }
   });
   //저장 -수정 동시 처리 부분으로 나뉨 
   btnInsr2300Save = new Button("저장");  
   btnInsr2300Save.setIcon(MSFMainApp.ICONS.save16());
   topInsr2300Bar.add(btnInsr2300Save); 
   btnInsr2300Save.addListener(Events.Select, new Listener<ButtonEvent>() {
       public void handleEvent(ButtonEvent e) {
    	     	   
    	   actionDatabase = ActionDatabase.UPDATE;   	
           doAction(actionDatabase); 
            
       }
   });
  
   //삭제       
   btnInsr2300Del = new Button("삭제");  
   btnInsr2300Del.setIcon(MSFMainApp.ICONS.delete16());
   topInsr2300Bar.add(btnInsr2300Del);
   btnInsr2300Del.addListener(Events.Select, new Listener<ButtonEvent>() {
       public void handleEvent(ButtonEvent e) {
          
           
           MessageBox.confirm("사회보험자격 상실신고 삭제", "선택하신 대상자를 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

						if(insr2200GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
							 actionDatabase = ActionDatabase.DELETE;
					           doAction(actionDatabase);
					           
					           insr2300Service.activityOnDeleteInsr2300(insr2200GridPanel.getGrid().getSelectionModel().getSelectedItems(), new AsyncCallback<Long>() {
									@Override
									public void onSuccess(Long result) {
										MessageBox.info("", "삭제 되었습니다.", null);
										reload();
										resetForm();
									}
									@Override
									public void onFailure(Throwable caught) {
										caught.printStackTrace();
										MessageBox.info("", "삭제 오류", null);
									}
								});
							}else{
								MessageBox.info("", "삭제하실 대상자를 선택하여주세요.", null);
							}
					           
						}else{
							//MessageBox.info("", "삭제하실 대상자를 선택하여주세요.", null);
						}
					}
				
           });
           
       }
   });
   
 
 	btnInsr2300Sreach = new Button("조회"); 
 	btnInsr2300Sreach.setIcon(MSFMainApp.ICONS.search16());
 	topInsr2300Bar.add(btnInsr2300Sreach);
 	btnInsr2300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			//조회버튼 클릭시 처리 
		    reload();  
		    resetForm();
		}
	});
 	
 	btnInsr2300ExcelFile = new Button("자격상실신고파일"); 
 	btnInsr2300ExcelFile.setIcon(MSFMainApp.ICONS.excel16());
 	topInsr2300Bar.add(btnInsr2300ExcelFile);
 	btnInsr2300ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {			
			excelFileExport("");
		}
	});
 	
 	
 	btnInsr2300Print = new Button("인쇄"); 
 	btnInsr2300Print.setIcon(MSFMainApp.ICONS.print16());
 	topInsr2300Bar.add(btnInsr2300Print);
 	btnInsr2300Print.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			insr23000Print("INSRT230005", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
		}
	});
 	
 	
 	
 	
 	
// 	btnInsr2300Excel = new Button("엑셀"); 
// 	btnInsr2300Excel.setIcon(MSFMainApp.ICONS.excel16());
// 	topInsr2300Bar.add(btnInsr2300Excel);
// 	btnInsr2300Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
//		public void handleEvent(ButtonEvent e) {
//			//엑셀저장  
//			//excelFileExport();
//		}
//	});
 	
 	
// 	topBtn = new Button("인쇄"); 
// 	topBtn.setIcon(MSFMainApp.ICONS.text()); 
// 	buttonBar.add(topBtn);  
 	 
    plFrmInsr2300.add(topInsr2300Bar);       
    
    //파일업로드 처리
    plFrmInsr2300.setAction("myurl");
    plFrmInsr2300.setEncoding(Encoding.MULTIPART);
    plFrmInsr2300.setMethod(Method.POST);
     
        
    vp.add(plFrmInsr2300);
    //엣지변환
    //plFrmInsr2300.setSize("990px", "730px");
    plFrmInsr2300.setSize("990px", "780px");
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

private void createSearchForm() {   
     

	
	retryDt = new HiddenField<String>();
	retryDt.setName("retryDt");
	plFrmInsr2300.add(retryDt);
	
      //  srhPyspGrdeCd = new HiddenField<String>(); 
         srhSystemkey = new HiddenField<String>();  //시스템키 
        

         sysComBass0150Dto = new PrgmComBass0150DTO();
		 sysComBass0300Dto = new PrgmComBass0300DTO();
		 sysComBass0400Dto = new PrgmComBass0400DTO();
		 sysComBass0500Dto = new PrgmComBass0500DTO();
		 msfCoCalendarDto = new SysCoCalendarDTO();
		 sysComBass0350Dto = new PrgmComBass0350DTO();
		 sysComBass0320Dto = new PrgmComBass0320DTO();
		 

		  sysComBass0300Dto.setRpsttvCd("A048");
		  lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //재직상태  
		 sysComBass0300Dto.setRpsttvCd("A003");
		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
	         public void handleEvent(StoreEvent<BaseModel> be) {  
	             mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
	             srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
	             
	         }
	     });   
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //월 
		 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------

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
//	     		  ContentPanel typOccuCdGrid = new ContentPanel();  
//	     		  typOccuCdGrid.setVisible(false);
//	     		    
//	     		    //직종 콤보처리 
//	     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	     			       public void handleEvent(ComponentEvent be) {  
//	     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//	     			        	  
//	     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//	     			        	mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	     			          }  
//	     			        });  
//	     			       
//	     			      }  
//	     			    });  
//	     	  
//	     		 typOccuCdGrid.add(typOccuCdGridPanel); 
//	     		plFrmInsr2300.add(typOccuCdGrid);
	     	    
           lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                 mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                  
               }
           });  
			 
		 /**
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   * 년도 콤보박스 처리  시작
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	   */
//	  		   ContentPanel payYrGrid = new ContentPanel();  
//	  		   payYrGrid.setVisible(false);
//	  		    
//	  		   //년도 콤보처리 
//	  		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//	  		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	  			       public void handleEvent(ComponentEvent be) {  
//	  			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	  			          public void handleEvent(StoreEvent<BaseModel> be) {  
//	  			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//	  			        	 
//	  			        	//  Date today = new Date(); 
//	  			        	    // A custom date format
//	  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	  			        	 
//	  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//	  			      	     // srhPayYr.setValue(bm);
//	  			        	srhPayYr.setValue(lsPayYrStore.getAt(0));
//	  			        	Date today = new Date(); 
//                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                            srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                       
//	  			          }  
//	  			        });  
//	  			       
//	  			      }  
//	  			    });  
//	  	  
//	  		payYrGrid.add(payYrGridPanel); 
//	  		plFrmInsr2300.add(payYrGrid); 

	  
	    plFrmInsr2300.setLayout(new FlowLayout());
	    
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
	    srhSoctyInsurCmptnDt01.setFieldLabel("상실기간");
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
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	checkInsr2300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
           	   }
             
              
                
            }
        });    
        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                
            	sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		  
            	srhDeptCd.reset();  //2015.12.07 추가 
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
                     	checkInsr2300Auth("EmymtDivCd", lsEmymtDivCd ); 
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

//            	  EventType type = be.getType();
//     	    	   if (type == Store.Add) { 
//                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//     	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//     	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//     	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//     	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//     	    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//                	 }  
              
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
	    //lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));//
	    
	    LayoutContainer layoutContainer_13 = new LayoutContainer();
	    layoutContainer_13.setLayout(new ColumnLayout());
	    

	    LayoutContainer lcSch2 = new LayoutContainer();
	 		lcSch2.setLayout(new ColumnLayout());
	 		
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
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkInsr2300Auth("srhDeptCd", lsDeptCd); 
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
//             BaseModel bmPayCd =  se.getSelectedItem(); 
//             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//                 if (bmPayCd != null) {  
//                    
//                     sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//                     sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//                 }      
//              
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//                   lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                  //--------------------사업 불러 오는 함수 -------------------------------------------------
//                   srhBusinCd.setStore(lsBusinCd); 
//                   srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                       public void handleEvent(StoreEvent<BaseModel> be) {  
//                        //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                       }
//                   });    
//             
//             }  
            
            } 
        });
	    //검색 소속부서 코드 처리  
//        LayoutContainer lccmlcDeptNm = new LayoutContainer();
//        lccmlcDeptNm.setLayout(new ColumnLayout());
//           //부서 
//        srhDeptCd = new TextField<String>();
//        srhDeptCd.setName("srhDeptCd");
//        srhDeptCd.setVisible(false);
//        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//            @Override
//            public void handleEvent(BaseEvent be) { 
//              if(srhDeptCd.getValue() != null){ 
//                 
//                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
//                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//                  
//                    //--------------------사업 불러 오는 함수 -------------------------------------------------
//                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//                      srhBusinCd.setStore(lsBusinCd); 
//                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                          public void handleEvent(StoreEvent<BaseModel> be) {  
//                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                          }
//                      });    
//                 
//              } 
//            }
//         });
//        plFrmInsr2300.add(srhDeptCd);
//        srhMangeDeptCd = new TextField<String>();
//        srhMangeDeptCd.setName("srhMangeDeptCd");
//        srhMangeDeptCd.setVisible(false);
//        plFrmInsr2300.add(srhMangeDeptCd);
//        srhMangeDeptNm = new TextField<String>();
//        srhMangeDeptNm.setName("srhMangeDeptNm");
//        srhMangeDeptNm.setVisible(false);
//        plFrmInsr2300.add(srhMangeDeptNm);
//  
//         LayoutContainer lcDeptNm = new LayoutContainer(); 
//         frmlytSch = new FormLayout();
//         frmlytSch.setLabelWidth(70);
//         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//         lcDeptNm.setLayout(frmlytSch);
//      
//         srhDeptNm = new TextField<String>();
//         srhDeptNm.setName("srhDeptNm");
//         srhDeptNm.setFieldLabel("부서");  
//         srhDeptNm.addKeyListener(new KeyListener() {
//              public void componentKeyUp(ComponentEvent event) {
//                  super.componentKeyUp(event); 
//                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                      if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                          srhDeptCd.setValue("");
//                          srhMangeDeptCd.setValue("");
//                      }
//                      fnPopupCommP140(srhDeptNm.getValue());
//                  }
//              }
//          });
//         
//         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                    @Override
//                    public void handleEvent(BaseEvent be) { 
//                         
//                        if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                            srhDeptCd.setValue("");
//                            srhMangeDeptCd.setValue("");
//                        }
//                     
//                    } 
//           });        
//          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//          
//           btnSrhDeptCd = new Button();
//           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//               public void handleEvent(ButtonEvent e) { 
//                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                       srhDeptCd.setValue("");
//                       srhMangeDeptCd.setValue("");
//                   }
//                   fnPopupCommP140(srhDeptNm.getValue()); 
//               }
//           });
//            
//           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
             
	    layoutContainer_2.add(srhDeptCd, new FormData("100%"));
	    layoutContainer_2.setBorders(false);
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_10.setLayout(frmlytSch);
        
//        srhTypOccuCd =  new ComboBox<BaseModel>(); 
//        srhTypOccuCd.setName("srhTypOccuCd");
//        srhTypOccuCd.setForceSelection(true);
//        srhTypOccuCd.setMinChars(1);
//        srhTypOccuCd.setDisplayField("typOccuNm");
//        srhTypOccuCd.setValueField("typOccuCd");
//        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//        srhTypOccuCd.setEmptyText("--직종선택--");
//        srhTypOccuCd.setSelectOnFocus(true); 
//        srhTypOccuCd.setReadOnly(false);
//        srhTypOccuCd.setEnabled(true); 
//        srhTypOccuCd.setStore(lsTypOccuCd);
//        srhTypOccuCd.setFieldLabel("직종");
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
        
        
//        srhTypOccuCd = new ComboBox<BaseModel>(); 
//        srhTypOccuCd.setName("srhTypOccuCd");
//        srhTypOccuCd.setForceSelection(true);
//        srhTypOccuCd.setMinChars(1);
//        srhTypOccuCd.setDisplayField("typOccuNm");
//        srhTypOccuCd.setValueField("typOccuCd");
//        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//        srhTypOccuCd.setEmptyText("--직종선택--");
//        srhTypOccuCd.setSelectOnFocus(true); 
//        srhTypOccuCd.setReadOnly(false);
//        srhTypOccuCd.setEnabled(true); 
//        srhTypOccuCd.setStore(lsTypOccuCd); 
//        srhTypOccuCd.setFieldLabel("직 종");  
//        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                //직종변경에 따른 직종세 값 가져오기
//                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//                    sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                        LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//                    }
//                }
//            } 
//        }); 
//        lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
 
//                
//            }
//        });    
        
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
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                //	checkInsr2300Auth("srhTypOccuCd", lsTypOccuCd); 
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
//        srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//        srhDtilOccuInttnCd.setForceSelection(true);
//        srhDtilOccuInttnCd.setMinChars(1);
//        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//        srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//        srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//        srhDtilOccuInttnCd.setSelectOnFocus(true); 
//        srhDtilOccuInttnCd.setReadOnly(false);
//        srhDtilOccuInttnCd.setEnabled(true);  
//        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//      //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//        srhDtilOccuInttnCd.setLabelSeparator("");
       
        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
        srhDtilOccuInttnCd.setWidth(100);
        srhDtilOccuInttnCd.setFieldLabel("");
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
	    
//	    LayoutContainer layoutContainer_3 = new LayoutContainer();
//	    layoutContainer_3.setLayout(new ColumnLayout());
//	    
//	   
//	     
//	    fieldSet.add(layoutContainer_3);
//	    layoutContainer_3.setBorders(false);
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
//	    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	        @Override
//	        public void handleEvent(BaseEvent be) {  
//	            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                srhSystemkey.setValue("");
//	                srhResnRegnNum.setValue("");
//	            }
//	         
//	        } 
//	   }); 
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
	     	   checkInsr2300Auth("srhHdofcCodtnCd",lsHdofcCodtnCd); 
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
	    
	    plFrmInsr2300.add(fieldSet); 
	 
    //vp.add(panel);   
  }  

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
    //직종변경에 따른 직종세 값 가져오기
//    String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//    if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//        sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//        sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//        if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//            lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//            srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//        }
//    }   
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
	 
private void createForm() {
    
	 dpobCd = new HiddenField<String>();   /** column 사업장코드 : dpobCd */
	 systemkey = new HiddenField<String>();   /** column SYSTEMKEY : systemkey */ 
	 socInsrLssEmymtNum = new MSFNumberField();   /** column 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
	 
	 
		soctyInsurCmptnDt = new HiddenField<String>();   /** column 작성일자 : 작성일자 */
	 
	 sysComBass0300Dto.setRpsttvCd("I021"); 
	 lsSocnsrIssRegVal06 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);/** column 연금_상실부호  : lsSocnsrIssRegVal06 */ 
	 sysComBass0300Dto.setRpsttvCd("I020"); 
	 lsSocnsrIssRegVal09 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); /** column 건강_상실부호  : lsSocnsrIssRegVal09 */       
	 sysComBass0300Dto.setRpsttvCd("I024"); 
	 lsSocnsrIssRegVal13 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); /** column  건강_전년도 정산구분  : lsSocnsrIssRegVal13 */  
	 sysComBass0300Dto.setRpsttvCd("I022"); 
	 lsSocnsrIssRegVal16 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); /** column 고용_상실사유 : lsSocnsrIssRegVal16 */     
	 sysComBass0300Dto.setRpsttvCd("I022"); 
	 lsSocnsrIssRegVal20 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); /** column 산재_상실사유  : lsSocnsrIssRegVal20 */       

		  
    LayoutContainer layoutContainer = new LayoutContainer();   

    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false); 
    cp01.setSize(975, 445);
    cp01.setLayout(new FitLayout());
    
    LayoutContainer layoutContainer_16 = new LayoutContainer(); 
    layoutContainer_16.setLayout(new ColumnLayout());
  //  layoutContainer_16.setBorders(false);  
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_1.setLayout(frmlytStd);
    
    FieldSet fldstNewFieldset = new FieldSet();
  //  fldstNewFieldset.setSize("480px", "475px");
    
//    ContentPanel cntntpnlNewContentpanel = new ContentPanel();
//    cntntpnlNewContentpanel.setHeaderVisible(false);
//    cntntpnlNewContentpanel.setHeading("New ContentPanel");
//    fldstNewFieldset.add(cntntpnlNewContentpanel);
    
    
    layoutContainer_1.add(fldstNewFieldset,new FormData("100%"));
    fldstNewFieldset.setHeadingHtml("대상자정보");
    fldstNewFieldset.setCollapsible(false);
    layoutContainer_16.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49)); 
    
    fldstNewFieldset.add(leftGrid01(),new FormData("100%"));
    
    LayoutContainer layoutContainer_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd);
    
    FieldSet fldstNewFieldset_1 = new FieldSet(); 
   // fldstNewFieldset_1.setSize("398px", "140px");
    fldstNewFieldset_1.setHeadingHtml("기본정보");
    fldstNewFieldset_1.setCollapsible(false);
    
    fldstNewFieldset_1.add(rightForm01(),new FormData("100%")); 
     
    layoutContainer_2.add(fldstNewFieldset_1);  
    
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
	
	allCheck = new MSFCheckBox();
	allCheck.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			if(allCheck.getValue()){
				natPennRegrstYn.setValue(true);
				hlthInsrRegrstYn.setValue(true);
				umytInsrRegrstYn.setValue(true);
				idtlAccdtRegrstYn.setValue(true);
				tabitem01.setEnabled(true);
				tabitem02.setEnabled(true);
				tabitem03.setEnabled(true);
				tabitem04.setEnabled(true);
			}else{
				natPennRegrstYn.setValue(false);
				hlthInsrRegrstYn.setValue(false);
				umytInsrRegrstYn.setValue(false);
				idtlAccdtRegrstYn.setValue(false);
				tabitem01.setEnabled(false);
				tabitem02.setEnabled(false);
				tabitem03.setEnabled(false);
				tabitem04.setEnabled(false);
			}
		}
	});
	natPennRegrstYn = new MSFCheckBox();
	natPennRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			if(natPennRegrstYn.getValue())	tabitem01.setEnabled(true);
			else tabitem01.setEnabled(false);
		}
	});
	hlthInsrRegrstYn = new MSFCheckBox();
	hlthInsrRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			if(hlthInsrRegrstYn.getValue())	 tabitem02.setEnabled(true);
			else tabitem02.setEnabled(false);
		}
	});
	umytInsrRegrstYn = new MSFCheckBox();
	umytInsrRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			if(umytInsrRegrstYn.getValue()){	 
				idtlAccdtRegrstYn.setValue(true);
				tabitem03.setEnabled(true);
				tabitem04.setEnabled(true); 
			}else{ 
				idtlAccdtRegrstYn.setValue(false);
				tabitem03.setEnabled(false);
				tabitem04.setEnabled(false);
			}
		}
	});
	idtlAccdtRegrstYn = new MSFCheckBox();
	idtlAccdtRegrstYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			if(idtlAccdtRegrstYn.getValue()){ 
				umytInsrRegrstYn.setValue(true);
				tabitem03.setEnabled(true);
				tabitem04.setEnabled(true);
			}else{ 
				umytInsrRegrstYn.setValue(false);
				tabitem03.setEnabled(false);
				tabitem04.setEnabled(false);
			}
		}
	});
	
	   FieldSet fldstNewFieldset_21 = new FieldSet(); 
	     
	    layoutContainer_2.add(fldstNewFieldset_21); 
	    fldstNewFieldset_21.setHeadingHtml("");
	    fldstNewFieldset_21.setCollapsible(false);
	     
	    
	LayoutContainer layoutContainer_14= new LayoutContainer(new ColumnLayout());
	layoutContainer_14.setStyleAttribute("vertical-align", "middle");  
	layoutContainer_14.add(lb_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.20) ); 
	layoutContainer_14.add(allCheck, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) ); //전체
	layoutContainer_14.add(lb_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.07) ); 
	layoutContainer_14.add(natPennRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );  /** column 국민연금신고여부 : natPennRegrstYn */
	layoutContainer_14.add(lb_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) ); 
	layoutContainer_14.add(hlthInsrRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) );  /** column 건강보험신고여부 : hlthInsrRegrstYn */
	layoutContainer_14.add(lb_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	layoutContainer_14.add(umytInsrRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) ); /** column 고용보험신고여부 : umytInsrRegrstYn */
	layoutContainer_14.add(lb_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	layoutContainer_14.add(idtlAccdtRegrstYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06) ); /** column 산재보험신고여부 : idtlAccdtRegrstYn */  
	layoutContainer_14.add(lb_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	
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
//	   fldstNewFieldset_2.setWidth("400px"); //, "274px");
//	    fldstNewFieldset_2.setHeadingHtml("국민연금");
//	    fldstNewFieldset_2.setCollapsible(false);
//	    
//	    fldstNewFieldset_2.add(rightFormBottom01(),new FormData("100%")); 
//	    
//	    FieldSet fldstNewFieldset_22 = new FieldSet(); 
//	     
//	    layoutContainer_21.add(fldstNewFieldset_22);
//	     fldstNewFieldset_22.setWidth("400px");  //.setSize("398px", "274px");
//	    fldstNewFieldset_22.setHeadingHtml("건강보험");
//	    fldstNewFieldset_22.setCollapsible(false);
//	    
//	    fldstNewFieldset_22.add(rightFormBottom02(),new FormData("100%")); 
//	    
//	    FieldSet fldstNewFieldset_23 = new FieldSet(); 
//	    
//	    layoutContainer_21.add(fldstNewFieldset_23);
//	    fldstNewFieldset_23.setWidth("400px"); //.setSize("398px", "274px");
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
	    tabitem01 = new TabItem("국민연금"); 
	    tabitem01.setStyleAttribute("padding", "2px");
	    tabitem01.add(rightFormBottom01());
	    tabPanel.add(tabitem01);
	    tabitem01.setSize("492", "279");
	    
	    
	    //2.건강보험
	    tabitem02 = new TabItem("건강보험");
	    tabitem02.setStyleAttribute("padding", "2px");
	    tabitem02.add(rightFormBottom02()); 
	    tabPanel.add(tabitem02);
	    tabitem02.setSize("492", "279"); 
	    
	    //3.고용보험/산재보험
	    tabitem03 = new TabItem("고용보험");
	    tabitem03.setStyleAttribute("padding", "2px");
	    tabitem03.add(rightFormBottom03()); 
	    tabPanel.add(tabitem03);
	    tabitem03.setSize("492", "279");
	    tabPanel.setHeight("285");
	    
	    
	    //3.고용보험/산재보험
	    tabitem04 = new TabItem("산재보험");
	    tabitem04.setStyleAttribute("padding", "2px");
	    tabitem04.add(rightFormBottom04()); 
	    tabPanel.add(tabitem04);
	    tabitem04.setSize("492", "279");
	    tabPanel.setHeight("285");
	    
	    layoutContainer_21.add(tabPanel);  
	     
	    cp02.add(layoutContainer_21); 
	    
	    layoutContainer_2.add(cp02) ;   

	   //  layoutContainer_16.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45)); 
	   //  layoutContainer_16.setSize("934", "424");

    
     cp01.add(layoutContainer_16); 
   
     
     layoutContainer.add(cp01) ;   
   //  cp01.setSize("934", "484"); 
     
   	 FieldSet subFieldSet = new FieldSet();
   	   // subFieldSet.setSize("480px", "475px");
   	 subFieldSet.setHeadingHtml("사업장정보");
     subFieldSet.setCollapsible(false);
     subFieldSet.add(subBinsinInfo());
   	 layoutContainer.add(subFieldSet);   
    
    plFrmInsr2300.add(layoutContainer);
    
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
 		    
// 		    HorizontalPanel horizontalPanel = new HorizontalPanel();
// 		    
// 		    LayoutContainer layoutContainer = new LayoutContainer();
// 		    layoutContainer.setSize("120px","56px");
// 		    LabelField lblfldNewLabelfield = new LabelField("사업장관리번호");
// 		    layoutContainer.add(lblfldNewLabelfield);
// 		    horizontalPanel.add(layoutContainer);
// 		    layoutContainer.setBorders(true);
 		   
 		  //  LayoutContainer layoutContainer_9 = new LayoutContainer();
 		   // layoutContainer_9.setWidth("646px");
 		 //   FormLayout frmlytSch = new FormLayout();  
 		 //   frmlytSch.setLabelWidth(0); 
 		  //  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
 		  //  layoutContainer_9.setLayout(frmlytSch);
 		  //  layoutContainer_9.setBorders(false);
 		    
 		   // horizontalPanel.add(layoutContainer_9); 
 		   
 		    
 		    LayoutContainer layoutContainer_1 = new LayoutContainer();
 		    layoutContainer_1.setLayout(new ColumnLayout());
 		  //  layoutContainer_9.add(layoutContainer_1, new FormData("100%"));
 		   
 		    
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
 		   
 		    
 		   // LayoutContainer layoutContainer_10 = new LayoutContainer();
 		   // layoutContainer_10.setLayout(new ColumnLayout());
 		    
 		    LayoutContainer layoutContainer_11 = new LayoutContainer();
 		    layoutContainer_11.setLayout(new ColumnLayout());
 		    
 		    LayoutContainer layoutContainer_12 = new LayoutContainer();
 		    frmlytSch = new FormLayout();  
 		    frmlytSch.setLabelWidth(60); 
 		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
 		    layoutContainer_12.setLayout(frmlytSch); 
 		    
 		    umytInsrSym = new MSFComboBox();
 		    umytInsrSym.setStore(new ListStore());
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
 		    
 		    idtlAccdtInsurSym = new MSFComboBox();
 		    idtlAccdtInsurSym.setStore(new ListStore());
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
 		   // layoutContainer_9.add(layoutContainer_10, new FormData("100%"));
 		  //  layoutContainer_10.setBorders(false);
 		    
 		    cpGrid.add(layoutContainer_1);
 		   // cpGrid.add(layoutContainer_10);
 		    
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
    cp01.setSize("480", "279");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    layoutContainer_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
    btnSocnsrIssRegVal05 = new Button();  
    btnSocnsrIssRegVal05.setWidth("25px");
    btnSocnsrIssRegVal05.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal05.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal05.getValue() || "".equals(socnsrIssRegVal05.getValue())){
        		Window.alert("상실일을 입력하세요");
        	}else{
				MessageBox.confirm("국민연금 상실일", "국민연금 상실일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("05");
						}
					}
				});
        	}
        }
    });
    /** column 연금_상실일 : socnsrIssRegVal05 */ 
    socnsrIssRegVal05 = new DateFieldWithButton(btnSocnsrIssRegVal05);
    new DateFieldMask(socnsrIssRegVal05, "9999.99.99"); 
    socnsrIssRegVal05.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrIssRegVal05.setName("socnsrIssRegVal05");
    layoutContainer_3.add(socnsrIssRegVal05, new FormData("100%"));
    socnsrIssRegVal05.setFieldLabel("상실일");   
    
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
    layoutContainer_3.setBorders(false);
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    btnSocnsrIssRegVal06 = new Button();  
    btnSocnsrIssRegVal06.setWidth("25px");
    btnSocnsrIssRegVal06.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal06.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal06.getValue() || "".equals(socnsrIssRegVal06.getValue())){
        		Window.alert("상실부호를 선택하세요");
        	}else{
				MessageBox.confirm("국민연금 상실부호", "국민연금 상실부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("06");
						}
					}
				});
        	}
        }
    });
    /** column 연금_상실부호  : socnsrIssRegVal06 */ 
    socnsrIssRegVal06 = new ComboBoxWithButton<BaseModel>(btnSocnsrIssRegVal06); 
    socnsrIssRegVal06.setName("socnsrIssRegVal06");
    socnsrIssRegVal06.setForceSelection(true);
    socnsrIssRegVal06.setMinChars(1);
    socnsrIssRegVal06.setDisplayField("commCdNm");
    socnsrIssRegVal06.setValueField("commCd");
    socnsrIssRegVal06.setTriggerAction(TriggerAction.ALL);
    socnsrIssRegVal06.setEmptyText("--상실부호선택--");
    socnsrIssRegVal06.setSelectOnFocus(true);  
    socnsrIssRegVal06.setStore(lsSocnsrIssRegVal06);  
    socnsrIssRegVal06.setFieldLabel("상실부호"); 
    layoutContainer_4.add(socnsrIssRegVal06, new FormData("100%"));
    layoutContainer_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   //
    layoutContainer_4.setBorders(false); 
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false);
    
    LayoutContainer layoutContainer_41 = new LayoutContainer();
    layoutContainer_41.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_11 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(280); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_11.setLayout(frmlytStd); 
    
    socnsrIssRegVal07 = new MSFCheckBox();  
    layoutContainer_11.add(socnsrIssRegVal07, new FormData("100%"));
    socnsrIssRegVal07.setFieldLabel("초일취득.당월 상실자납부여부");
    layoutContainer_41.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
    layoutContainer_11.setBorders(false);
    cp01.add(layoutContainer_41, new FormData("100%"));
    layoutContainer_41.setBorders(false);
    
    
    
   
    
   
    LayoutContainer layoutContainer_31 = new LayoutContainer(); 
    layoutContainer_31.setStyleAttribute("padding-top", "170px");  
    ButtonBar barbtn = new ButtonBar();
    barbtn.setAlignment(HorizontalAlignment.RIGHT);  
    
    Button natPennRegrstButton = new Button("신고파일");  
   
    natPennRegrstButton.setWidth("80px");
    natPennRegrstButton.setIcon(MSFMainApp.ICONS.excel16());
    natPennRegrstButton.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	excelFileExport("natPennRegrst");
        }
    });
    barbtn.add(natPennRegrstButton);
    
    layoutContainer_31.add(barbtn, new FormData("100")); 
    cp01.add(layoutContainer_31, new FormData("100%"));
    

    layoutContainer.add(cp01); 
    
    return layoutContainer;
}


private LayoutContainer rightFormBottom02() { 
    
    LayoutContainer layoutContainer = new LayoutContainer();   
    
    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false);
    cp01.setLayout(new FormLayout());
    cp01.setSize("480", "264");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_1.setLayout(new ColumnLayout());
     
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    FormLayout  frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
    btnSocnsrIssRegVal08 = new Button();  
    btnSocnsrIssRegVal08.setWidth("25px");
    btnSocnsrIssRegVal08.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal08.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal08.getValue() || "".equals(socnsrIssRegVal08.getValue())){
        		Window.alert("상실일을 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험 상실일", "건강보험 상실일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("08");
						}
					}
			});
        	}
        }
    });
    /** column 건강_상실일자  : socnsrIssRegVal08 */ 
    socnsrIssRegVal08 = new DateFieldWithButton(btnSocnsrIssRegVal08);
    new DateFieldMask(socnsrIssRegVal08, "9999.99.99"); 
    socnsrIssRegVal08.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrIssRegVal08.setName("socnsrIssRegVal08");
    layoutContainer_3.add(socnsrIssRegVal08, new FormData("100%"));
    socnsrIssRegVal08.setFieldLabel("상실일");
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   //
    layoutContainer_3.setBorders(false);
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    btnSocnsrIssRegVal09 = new Button();  
    btnSocnsrIssRegVal09.setWidth("25px");
    btnSocnsrIssRegVal09.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal09.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal09.getValue() || "".equals(socnsrIssRegVal09.getValue())){
        		Window.alert("상실부호를 선택하세요");
        	}else{
	        	MessageBox.confirm("건강보험 상실부호", "건강보험 상실부호를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("09");
						}
					}
				});
        	}
        }
    });
    
    /** column 건강_상실부호  : socnsrIssRegVal09 */ 
    socnsrIssRegVal09 = new ComboBoxWithButton<BaseModel>(btnSocnsrIssRegVal09); 
    socnsrIssRegVal09.setName("socnsrIssRegVal09");
    socnsrIssRegVal09.setForceSelection(true);
    socnsrIssRegVal09.setMinChars(1);
    socnsrIssRegVal09.setDisplayField("commCdNm");
    socnsrIssRegVal09.setValueField("commCd");
    socnsrIssRegVal09.setTriggerAction(TriggerAction.ALL);
    socnsrIssRegVal09.setEmptyText("--상실부호선택--");
    socnsrIssRegVal09.setSelectOnFocus(true);  
    socnsrIssRegVal09.setStore(lsSocnsrIssRegVal09);  
    socnsrIssRegVal09.setFieldLabel("상실부호"); 
    layoutContainer_4.add(socnsrIssRegVal09, new FormData("100%"));
    layoutContainer_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));    
    layoutContainer_4.setBorders(false);
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false); 
    
    
    LayoutContainer layoutContainer2_1 = new LayoutContainer(new FlowLayout());
    layoutContainer2_1.setLayout(new ColumnLayout());
     
    
    LayoutContainer layoutContainer1_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer1_2.setLayout(frmlytStd); 
    
    LayoutContainer layoutContainer2_2 = new LayoutContainer(new FlowLayout());
    layoutContainer2_2.setLayout(new ColumnLayout());
     
    
    LayoutContainer layoutContainer_2 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(110); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_2.setLayout(frmlytStd); 
  
    /** column 건강_퇴직전3개월간평균보수  : socnsrIssRegVal10 */ 
    socnsrIssRegVal10 = new MSFNumberField();
    socnsrIssRegVal10.setAllowDecimals(true); 
    socnsrIssRegVal10.setPropertyEditorType(Long.class); 
    socnsrIssRegVal10.setFormat(NumberFormat.getDecimalFormat()); 
    socnsrIssRegVal10.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_2.add(socnsrIssRegVal10, new FormData("100%"));
    socnsrIssRegVal10.setFieldLabel("평균보수(3개월)"); 
    layoutContainer2_2.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.88));   
    layoutContainer_2.setBorders(false);
    
    
    btnSocnsrIssRegVal10 = new Button();  
    btnSocnsrIssRegVal10.setWidth("25px");
    btnSocnsrIssRegVal10.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal10.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal10.getValue() || "".equals(socnsrIssRegVal10.getValue())){
        		Window.alert("평균보수(3개월)을 입력하세요");
        	}else{
	        	MessageBox.confirm("건강보험 평균보수(3개월)", "건강보험 평균보수(3개월)를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("10");
						}
					}
				});
        	}
        }
    }); 
    layoutContainer2_2.add(btnSocnsrIssRegVal10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));  
    layoutContainer1_2.add(layoutContainer2_2, new FormData("100%"));  
    layoutContainer2_1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));   
    cp01.add(layoutContainer2_1, new FormData("100%"));
    
    
    LayoutContainer layoutContainer_5 = new LayoutContainer();
    layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_13 = new LayoutContainer();
    
    LabelField lblfldDd1 = new LabelField("연간보수총액_당해");
    lblfldDd1.setStyleAttribute("padding-top", "5px");
    lblfldDd1.setStyleAttribute("vertical-align", "middle"); 
    lblfldDd1.setStyleAttribute("text-align", "right"); 
    layoutContainer_13.add(lblfldDd1);
    layoutContainer_5.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    layoutContainer_13.setBorders(false);
    
    LayoutContainer layoutContainer_6 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6.setLayout(frmlytStd); 
    
    /** column 건강_당해년도보수총액  : socnsrIssRegVal11 */ 
    socnsrIssRegVal11 = new MSFNumberField();
    socnsrIssRegVal11.setAllowDecimals(true); 
    socnsrIssRegVal11.setPropertyEditorType(Long.class); 
    socnsrIssRegVal11.setFormat(NumberFormat.getDecimalFormat()); 
    socnsrIssRegVal11.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_6.add(socnsrIssRegVal11, new FormData("100%"));
    socnsrIssRegVal11.setFieldLabel("보수총액");
    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
    layoutContainer_6.setBorders(false);
    
//    LayoutContainer layoutContainer_7 = new LayoutContainer();
//    frmlytStd = new FormLayout();  
//    frmlytStd.setLabelWidth(60); 
//    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//    layoutContainer_7.setLayout(frmlytStd); 
    /** column 건강_당해년도산정월수 : socnsrIssRegVal12 */ 
    socnsrIssRegVal12 = new MSFNumberField();
    socnsrIssRegVal12.setAllowDecimals(true); 
    socnsrIssRegVal12.setPropertyEditorType(Long.class); 
    socnsrIssRegVal12.setFormat(NumberFormat.getDecimalFormat()); 
    socnsrIssRegVal12.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_6.add(socnsrIssRegVal12, new FormData("100%"));
    socnsrIssRegVal12.setFieldLabel("근무월수");
//    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
//    layoutContainer_7.setBorders(false);  
    
    cp01.add(layoutContainer_5, new FormData("100%"));
    layoutContainer_5.setBorders(false);
    
    
    LayoutContainer layoutContainer_31 = new LayoutContainer();
    layoutContainer_31.setLayout(new ColumnLayout());
    
    
    
    
    
    
    
    LayoutContainer layoutContainer_8 = new LayoutContainer();
    LabelField lblfldDd = new LabelField("연간보수총액_전년");
    lblfldDd.setStyleAttribute("padding-top", "5px");
    lblfldDd.setStyleAttribute("vertical-align", "middle"); 
    lblfldDd.setStyleAttribute("text-align", "right"); 
    layoutContainer_8.add(lblfldDd);
    layoutContainer_31.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    layoutContainer_8.setBorders(false);
    
    LayoutContainer layoutContainer_9 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_9.setLayout(frmlytStd); 
    
    /** column 건강_전년도보수총액  : socnsrIssRegVal14 */ 
    socnsrIssRegVal14 = new MSFNumberField();
    socnsrIssRegVal14.setAllowDecimals(true); 
    socnsrIssRegVal14.setPropertyEditorType(Long.class); 
    socnsrIssRegVal14.setFormat(NumberFormat.getDecimalFormat()); 
    socnsrIssRegVal14.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_9.add(socnsrIssRegVal14, new FormData("100%"));
    socnsrIssRegVal14.setFieldLabel("보수총액");
    layoutContainer_31.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
    layoutContainer_9.setBorders(false);
    
    
/*    LayoutContainer layoutContainer_10 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_10.setLayout(frmlytStd); */
    
    LayoutContainer layoutContainer_11 = new LayoutContainer();
    layoutContainer_11.setLayout(new ColumnLayout());
    
    socnsrIssRegVal13 = new MSFCheckBox();  
    layoutContainer_8.add(socnsrIssRegVal13, new FormData("100%"));
    socnsrIssRegVal13.setFieldLabel("전년도");
    socnsrIssRegVal13.addListener(Events.OnClick, new Listener<BaseEvent>() {
		@Override
		public void handleEvent(BaseEvent be) {
			
			Window.alert(""+socnsrIssRegVal13.getValue());
			
			if(socnsrIssRegVal13.getValue()){

			}else{
				socnsrIssRegVal14.setValue(0L);;
				socnsrIssRegVal15.setValue(0L);
			}
		}
	});
	
   // layoutContainer_8.setBorders(false);
    cp01.add(layoutContainer_11, new FormData("100%"));
    layoutContainer_11.setBorders(false);
    
    
 /*   socnsrIssRegVal07 = new MSFCheckBox();  
    layoutContainer_11.add(socnsrIssRegVal07, new FormData("100%"));
    socnsrIssRegVal07.setFieldLabel("초일취득.당월 상실자납부여부");
    layoutContainer_41.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
    layoutContainer_11.setBorders(false);
    cp01.add(layoutContainer_41, new FormData("100%"));
    layoutContainer_41.setBorders(false);*/
    
    
    /** column 건강_전년도산정월수 : socnsrIssRegVal15 */ 
    socnsrIssRegVal15 = new MSFNumberField();
    socnsrIssRegVal15.setAllowDecimals(true); 
    socnsrIssRegVal15.setPropertyEditorType(Long.class); 
    socnsrIssRegVal15.setFormat(NumberFormat.getDecimalFormat()); 
    socnsrIssRegVal15.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_9.add(socnsrIssRegVal15, new FormData("100%"));
    socnsrIssRegVal15.setFieldLabel("근무월수");
//    layoutContainer_31.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//    layoutContainer_10.setBorders(false);
    cp01.add(layoutContainer_31, new FormData("100%"));
    layoutContainer_31.setBorders(false);
    
    
    
    LayoutContainer layoutContainer_71 = new LayoutContainer(); 
    //엣지변환
    //layoutContainer_71.setStyleAttribute("padding-top", "80px"); 
    layoutContainer_71.setStyleAttribute("padding-top", "140px"); 
    ButtonBar barbtn = new ButtonBar();
    barbtn.setAlignment(HorizontalAlignment.RIGHT);  

    Button hlthInsrRegrst = new Button("신고파일");  
    hlthInsrRegrst.setWidth("80px");
    hlthInsrRegrst.setIcon(MSFMainApp.ICONS.excel16());
    hlthInsrRegrst.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	excelFileExport("hlthInsrRegrst");
        }
    });
    
    barbtn.add(hlthInsrRegrst);
    
    layoutContainer_71.add(barbtn, new FormData("100"));
    cp01.add(layoutContainer_71, new FormData("100%"));
    
    layoutContainer.add(cp01); 
    
    return layoutContainer;
}

//고용보험
private LayoutContainer rightFormBottom03() { 
    
    LayoutContainer layoutContainer = new LayoutContainer();   
    
    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false);
    cp01.setLayout(new FormLayout());
    cp01.setSize("480", "264");
    
    LayoutContainer layoutContainer_1 = new LayoutContainer(new FlowLayout());
    layoutContainer_1.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_3 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_3.setLayout(frmlytStd); 
    
   
    
    btnSocnsrIssRegVal18 = new Button();  
    btnSocnsrIssRegVal18.setWidth("25px");
    btnSocnsrIssRegVal18.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal18.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal18.getValue() || "".equals(socnsrIssRegVal18.getValue())){
        		Window.alert("상실일을 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험 상실일", "고용보험 상실일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("18");
						}
					}
				}); 
        	}
        }
    }); 
    /** column 고용_상실일자  : socnsrIssRegVal18 */ 
    socnsrIssRegVal18 = new DateFieldWithButton(btnSocnsrIssRegVal18);
    new DateFieldMask(socnsrIssRegVal18, "9999.99.99"); 
    socnsrIssRegVal18.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    socnsrIssRegVal18.setName("socnsrIssRegVal18");
    layoutContainer_3.add(socnsrIssRegVal18, new FormData("100%"));
    socnsrIssRegVal18.setFieldLabel("상실일");
    socnsrIssRegVal18.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrIssRegVal22.setValue(InsrUtils.getConvertStringToDate((String) GWTUtils.getStringFromDate(socnsrIssRegVal18.getValue(),"yyyyMMdd"), "yyyyMMdd"));// 연금 상실일
		}
	});
    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));    
    layoutContainer_3.setBorders(false);
    
    LayoutContainer layoutContainer_4 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_4.setLayout(frmlytStd); 
    
    btnSocnsrIssRegVal16 = new Button();  
    btnSocnsrIssRegVal16.setWidth("25px");
    btnSocnsrIssRegVal16.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal16.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal16.getValue() || "".equals(socnsrIssRegVal16.getValue())){
        		Window.alert("상실사유를 선택하세요");
        	}else{
	        	MessageBox.confirm("고용보험 상실사유", "고용보험 상실사유를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("16");
						}
					}
				}); 
        	}
        }
    });
    /** column 고용_상실사유 : socnsrIssRegVal16 */ 
    socnsrIssRegVal16 = new ComboBoxWithButton<BaseModel>(btnSocnsrIssRegVal16); 
    socnsrIssRegVal16.setName("socnsrIssRegVal16");
    socnsrIssRegVal16.setForceSelection(true);
    socnsrIssRegVal16.setMinChars(1);
    socnsrIssRegVal16.setDisplayField("commCdNm");
    socnsrIssRegVal16.setValueField("commCd");
    socnsrIssRegVal16.setTriggerAction(TriggerAction.ALL);
    socnsrIssRegVal16.setEmptyText("--상실부호선택--");
    socnsrIssRegVal16.setSelectOnFocus(true);  
    socnsrIssRegVal16.setStore(lsSocnsrIssRegVal16);  
    layoutContainer_4.add(socnsrIssRegVal16, new FormData("100%"));
    socnsrIssRegVal16.setFieldLabel("상실사유");
    socnsrIssRegVal16.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrIssRegVal20.setValue(lsSocnsrIssRegVal16.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal16,"commCd")));
		}
	});
    layoutContainer_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
    layoutContainer_4.setBorders(false);  
    cp01.add(layoutContainer_1, new FormData("100%"));
    layoutContainer_1.setBorders(false);
    
    LayoutContainer layoutContainer_5 = new LayoutContainer(new FlowLayout());
    layoutContainer_5.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_6 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(165); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_6.setLayout(frmlytStd); 
    
    btnSocnsrIssRegVal17 = new Button();  
    btnSocnsrIssRegVal17.setWidth("25px");
    btnSocnsrIssRegVal17.setIcon(MSFMainApp.ICONS.allExec()); 
    btnSocnsrIssRegVal17.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	if(null == socnsrIssRegVal17.getValue() || "".equals(socnsrIssRegVal17.getValue())){
        		Window.alert("구체적사유를 입력하세요");
        	}else{
	        	MessageBox.confirm("고용보험 구체적사유", "고용보험 구체적사유를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("17");
						}
					}
				}); 
        	}
        }
    });
    /** column 고용_구체적상실사유  : socnsrIssRegVal17 */ 
    socnsrIssRegVal17 = new TextFieldWithButton(btnSocnsrIssRegVal17); 
    layoutContainer_6.add(socnsrIssRegVal17, new FormData("100%"));
    socnsrIssRegVal17.setFieldLabel("상실사유구체적사유");
    socnsrIssRegVal17.addListener(Events.KeyUp, new Listener<BaseEvent>() {
 		public void handleEvent(BaseEvent e) {
 			
 			socnsrIssRegVal21.setValue(socnsrIssRegVal17.getValue());
 		}
 	});
    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));   //
    layoutContainer_6.setBorders(false);
    
    LayoutContainer layoutContainer_7 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_7.setLayout(frmlytStd);
    
    Button btnNewButton = new Button("이직확인서");
    
    
    
    
    
    btnNewButton.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	
        	
        	if(systemkey.getValue() == null || systemkey.getValue().equals("")){
        		Window.alert("대상자를 선택하세요");
        	}else{
        		
        		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
        		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
        		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
        		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
        		
        		if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
        			if(emymtDivCd.equals("A0020010")){
        			}else if(emymtDivCd.equals("A0020020")){
        				if(deptCd == null || deptCd.equals("")){
        					Window.alert("부서를 선택해 주세요");
        					insr2200GridPanel.getMsfGrid().clearData();
        					resetForm();
        					return;
        				}	
        				if(businCd == null || businCd.equals("")){	
        					Window.alert("사업을 선택해 주세요");
        					insr2200GridPanel.getMsfGrid().clearData();
        					resetForm();
        					return;
        				}
        			}else{
        				Window.alert("고용구분을 선택해 주세요");
        				insr2200GridPanel.getMsfGrid().clearData();
        				resetForm();
        				return;
        			}
        		}else{
        			Window.alert("단위기관/고용구분을 선택해 주세요");
        			insr2200GridPanel.getMsfGrid().clearData();
        			resetForm();
        			return;
        		}
        		
        		
        		InsrP230006 insrP23006Form = new InsrP230006(ActionDatabase.CUSTOM, getThis());   
    			MSFFormWindows msFwInsr23006 = new MSFFormWindows("이직확인서",insrP23006Form,"닫기","1010px", "650px",true);
    			msFwInsr23006.show();
    			insrP23006Form.setMSFFormWindows(msFwInsr23006);
    			funcSetPopUpInsrP230006Record();
    			insrP23006Form.bind(ppRecord); 
        	}
        }
    });
    layoutContainer_7.add(btnNewButton, new FormData("100%"));
    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));   //
    layoutContainer_7.setBorders(false);
    cp01.add(layoutContainer_5, new FormData("100%"));
    layoutContainer_5.setBorders(false);
    

    
    
    
    LayoutContainer layoutContainer_41 = new LayoutContainer();
    layoutContainer_41.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_11 = new LayoutContainer(); 
    LabelField labelField = new LabelField("당해년도");
    labelField.setStyleAttribute("padding-top", "6px");
    labelField.setStyleAttribute("vertical-align", "middle"); 
    labelField.setStyleAttribute("text-align", "right"); 
    layoutContainer_11.add(labelField, new FormData("100%"));
    layoutContainer_41.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
    layoutContainer_11.setBorders(false);
  
    
    LayoutContainer layoutContainer_10 = new LayoutContainer();
    frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(70); 
    frmlytStd.setLabelAlign(LabelAlign.LEFT);
    layoutContainer_10.setLayout(frmlytStd);
    
    /** column 고용_당해년도보수총액  : socnsrIssRegVal19 */ 
    socnsrIssRegVal19 = new MSFNumberField();
    socnsrIssRegVal19.setAllowDecimals(true); 
    socnsrIssRegVal19.setPropertyEditorType(Long.class); 
    socnsrIssRegVal19.setFormat(NumberFormat.getDecimalFormat()); 
    socnsrIssRegVal19.setInputStyleAttribute("text-align", "right"); 
    layoutContainer_10.add(socnsrIssRegVal19, new FormData("100%"));
    socnsrIssRegVal19.setFieldLabel("보수총액");
    socnsrIssRegVal19.addListener(Events.KeyUp, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			
			socnsrIssRegVal23.setValue(socnsrIssRegVal19.getValue());
		}
	});
    layoutContainer_41.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
    layoutContainer_10.setBorders(false);
    cp01.add(layoutContainer_41, new FormData("100%"));
    layoutContainer_41.setBorders(false);
    
    
    LayoutContainer layoutContainer_71 = new LayoutContainer(); 
    layoutContainer_71.setStyleAttribute("padding-top", "140px");
      
    ButtonBar barbtn = new ButtonBar();
    barbtn.setAlignment(HorizontalAlignment.RIGHT);  

    Button umytInsrRegrst = new Button("신고파일");  
    umytInsrRegrst.setWidth("80px");
    umytInsrRegrst.setIcon(MSFMainApp.ICONS.excel16());
    umytInsrRegrst.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	excelFileExport("umytInsrRegrst");
        }
    });
    barbtn.add(umytInsrRegrst);
    layoutContainer_71.add(barbtn, new FormData("100")); 
    cp01.add(layoutContainer_71, new FormData("100%"));
    
    layoutContainer.add(cp01); 
    
    return layoutContainer;
}


//산재보험
private LayoutContainer rightFormBottom04() { 

	LayoutContainer layoutContainer = new LayoutContainer();   

	ContentPanel cp01 = new ContentPanel();
	cp01.setHeaderVisible(false);
	cp01.setLayout(new FormLayout());
	cp01.setSize("480", "264");

	LayoutContainer layoutContainer_1 = new LayoutContainer(new FlowLayout());
	layoutContainer_1.setLayout(new ColumnLayout());

	LayoutContainer layoutContainer_3 = new LayoutContainer();
	FormLayout frmlytStd = new FormLayout();  
	frmlytStd.setLabelWidth(70); 
	frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_3.setLayout(frmlytStd); 

	btnSocnsrIssRegVal22 = new Button();  
	btnSocnsrIssRegVal22.setWidth("25px");
	btnSocnsrIssRegVal22.setIcon(MSFMainApp.ICONS.allExec()); 
	btnSocnsrIssRegVal22.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			if(null == socnsrIssRegVal22.getValue() || "".equals(socnsrIssRegVal22.getValue())){
				Window.alert("상실일을 입력하세요");
			}else{
				MessageBox.confirm("산재보험 상실일", "산재보험 상실일을 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("22");
						}
					}
				}); 
			}
		}
	}); 
	/** column 산재_상실일자  : socnsrIssRegVal22 */ 
	socnsrIssRegVal22 = new DateFieldWithButton(btnSocnsrIssRegVal22);
	new DateFieldMask(socnsrIssRegVal22, "9999.99.99"); 
	socnsrIssRegVal22.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	socnsrIssRegVal22.setName("socnsrIssRegVal22");
	layoutContainer_3.add(socnsrIssRegVal22, new FormData("100%"));
	socnsrIssRegVal22.setFieldLabel("상실일");
	socnsrIssRegVal22.addListener(Events.Change, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			socnsrIssRegVal18.setValue(InsrUtils.getConvertStringToDate((String) GWTUtils.getStringFromDate(socnsrIssRegVal22.getValue(),"yyyyMMdd"), "yyyyMMdd"));// 연금 상실일
		}
	});

	layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));    
	layoutContainer_3.setBorders(false);

	LayoutContainer layoutContainer_4 = new LayoutContainer();
	frmlytStd = new FormLayout();  
	frmlytStd.setLabelWidth(70); 
	frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_4.setLayout(frmlytStd); 

	btnSocnsrIssRegVal20 = new Button();  
	btnSocnsrIssRegVal20.setWidth("25px");
	btnSocnsrIssRegVal20.setIcon(MSFMainApp.ICONS.allExec()); 
	btnSocnsrIssRegVal20.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			if(null == socnsrIssRegVal20.getValue() || "".equals(socnsrIssRegVal20.getValue())){
				Window.alert("상실사유를 선택하세요");
			}else{
				MessageBox.confirm("산재보험 상실사유", "산재보험 상실사유를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("20");
						}
					}
				}); 
			}
		}
	});
	/** column 산재_상실사유  : socnsrIssRegVal20 */ 
	socnsrIssRegVal20 = new ComboBoxWithButton<BaseModel>(btnSocnsrIssRegVal20); 
	socnsrIssRegVal20.setName("socnsrIssRegVal16");
	socnsrIssRegVal20.setForceSelection(true);
	socnsrIssRegVal20.setMinChars(1);
	socnsrIssRegVal20.setDisplayField("commCdNm");
	socnsrIssRegVal20.setValueField("commCd");
	socnsrIssRegVal20.setTriggerAction(TriggerAction.ALL);
	socnsrIssRegVal20.setEmptyText("--상실부호선택--");
	socnsrIssRegVal20.setSelectOnFocus(true);  
	socnsrIssRegVal20.setStore(lsSocnsrIssRegVal20);  
	layoutContainer_4.add(socnsrIssRegVal20, new FormData("100%"));
	socnsrIssRegVal20.setFieldLabel("상실사유");
	socnsrIssRegVal20.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {		
			socnsrIssRegVal16.setValue(lsSocnsrIssRegVal20.findModel("commCd",MSFSharedUtils.getSelectedComboValue(socnsrIssRegVal20,"commCd")));
		}
	});
	
	
	
	layoutContainer_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	layoutContainer_4.setBorders(false);  
	cp01.add(layoutContainer_1, new FormData("100%"));
	layoutContainer_1.setBorders(false);

	LayoutContainer layoutContainer_5 = new LayoutContainer(new FlowLayout());
	layoutContainer_5.setLayout(new ColumnLayout());

	LayoutContainer layoutContainer_6 = new LayoutContainer();
	frmlytStd = new FormLayout();  
	frmlytStd.setLabelWidth(165); 
	frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_6.setLayout(frmlytStd); 

	btnSocnsrIssRegVal21 = new Button();  
	btnSocnsrIssRegVal21.setWidth("25px");
	btnSocnsrIssRegVal21.setIcon(MSFMainApp.ICONS.allExec()); 
	btnSocnsrIssRegVal21.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			if(null == socnsrIssRegVal21.getValue() || "".equals(socnsrIssRegVal21.getValue())){
				Window.alert("구체적사유를 입력하세요");
			}else{
				MessageBox.confirm("산재보험 구체적사유", "산재보험 구체적사유를 일괄저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							updateInsr2200Bnde("21");
						}
					}
				});
			}
		}
	});
	/** column 산재_구체적인상실사유  : socnsrIssRegVal21 */ 
	socnsrIssRegVal21 = new TextFieldWithButton(btnSocnsrIssRegVal21); 
	layoutContainer_6.add(socnsrIssRegVal21, new FormData("100%"));
	socnsrIssRegVal21.setFieldLabel("상실사유구체적사유");
	socnsrIssRegVal21.addListener(Events.KeyUp, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			
			socnsrIssRegVal17.setValue(socnsrIssRegVal21.getValue());
		}
	});
	layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));   //
	layoutContainer_6.setBorders(false);

	LayoutContainer layoutContainer_7 = new LayoutContainer();
	frmlytStd = new FormLayout();  
	frmlytStd.setLabelWidth(60); 
	frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_7.setLayout(frmlytStd);

	//    Button btnNewButton = new Button("이직확인서");
	//    layoutContainer_7.add(btnNewButton, new FormData("100%"));
	//    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));   //
	layoutContainer_7.setBorders(false);
	cp01.add(layoutContainer_5, new FormData("100%"));
	layoutContainer_5.setBorders(false);

	LayoutContainer layoutContainer_41 = new LayoutContainer();
	layoutContainer_41.setLayout(new ColumnLayout());

	LayoutContainer layoutContainer_11 = new LayoutContainer();

	LabelField labelField = new LabelField("당해년도");
	labelField.setStyleAttribute("padding-top", "6px");
	labelField.setStyleAttribute("vertical-align", "middle"); 
	labelField.setStyleAttribute("text-align", "right"); 
	layoutContainer_11.add(labelField, new FormData("100%"));
	layoutContainer_41.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	layoutContainer_11.setBorders(false);


	LayoutContainer layoutContainer_10 = new LayoutContainer();
	frmlytStd = new FormLayout();  
	frmlytStd.setLabelWidth(70); 
	frmlytStd.setLabelAlign(LabelAlign.LEFT);
	layoutContainer_10.setLayout(frmlytStd);

	/** column 산재_당해년도보수총액  : socnsrIssRegVal23 */ 
	socnsrIssRegVal23 = new MSFNumberField();
	socnsrIssRegVal23.setAllowDecimals(true); 
	socnsrIssRegVal23.setPropertyEditorType(Long.class); 
	socnsrIssRegVal23.setFormat(NumberFormat.getDecimalFormat()); 
	socnsrIssRegVal23.setInputStyleAttribute("text-align", "right"); 
	layoutContainer_10.add(socnsrIssRegVal23, new FormData("100%"));
	socnsrIssRegVal23.setFieldLabel("보수총액");
	socnsrIssRegVal23.addListener(Events.KeyUp, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent e) {
			
			socnsrIssRegVal19.setValue(socnsrIssRegVal23.getValue());
		}
	});
	layoutContainer_41.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
	layoutContainer_10.setBorders(false);
	cp01.add(layoutContainer_41, new FormData("100%"));
	layoutContainer_41.setBorders(false);

    LayoutContainer layoutContainer_71 = new LayoutContainer(); 
    layoutContainer_71.setStyleAttribute("padding-top", "150px");  
    ButtonBar barbtn = new ButtonBar();
    barbtn.setAlignment(HorizontalAlignment.RIGHT);  
    
    
    Button idtlAccdtRegrst = new Button("신고파일");  
    idtlAccdtRegrst.setWidth("80px");
    idtlAccdtRegrst.setIcon(MSFMainApp.ICONS.excel16());
    idtlAccdtRegrst.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
        	excelFileExport("idtlAccdtRegrst");
        }
    });
    
    barbtn.add(idtlAccdtRegrst);
    
    layoutContainer_71.add(barbtn, new FormData("100")); 
    cp01.add(layoutContainer_71, new FormData("100%"));
	
    
    
	layoutContainer.add(cp01); 

	return layoutContainer;
}

	private LayoutContainer rightForm01() {

		LayoutContainer layoutContainer = new LayoutContainer();

		ContentPanel cp02 = new ContentPanel();
		cp02.setHeaderVisible(false);
		cp02.setSize(483, 82);
		cp02.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer(
				new ColumnLayout());

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytSch);

		socnsrIssRegVal08Dt = new MSFDateField();
		socnsrIssRegVal08Dt.setReadOnly(true);
		new DateFieldMask(socnsrIssRegVal08Dt, "9999.99.99");
		socnsrIssRegVal08Dt.getPropertyEditor().setFormat(
				DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		socnsrIssRegVal08Dt.setName("soctyInsurCmptnDt");
		layoutContainer_2_1.add(socnsrIssRegVal08Dt, new FormData("100%"));
		socnsrIssRegVal08Dt.setFieldLabel("상실일자");
		layoutContainer_6.add(layoutContainer_2_1,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_2_1.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setBorders(false);
		// layoutContainer_3.setBorders(true);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(40);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		socnsrIssRegVal02 = new MSFTextField();
		socnsrIssRegVal02.setReadOnly(true);
		layoutContainer_3.add(socnsrIssRegVal02, new FormData("100%"));
		socnsrIssRegVal02.setFieldLabel("성명");
		layoutContainer_6.add(layoutContainer_3,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		socnsrIssRegVal03 = new MSFTextField();
		socnsrIssRegVal03.setReadOnly(true);
		layoutContainer_4.add(socnsrIssRegVal03, new FormData("100%"));
		socnsrIssRegVal03.setHideLabel(true);
		// socnsrIssRegVal03.setFieldLabel("");
		// socnsrIssRegVal03.setLabelSeparator("");
		layoutContainer_6.add(layoutContainer_4,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

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
		layoutContainer_6.add(layoutContaineri_4,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		cp02.add(layoutContainer_6);

		LayoutContainer layoutContainera7 = new LayoutContainer();
		layoutContainera7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		socInsrLssEmymtNum = new MSFNumberField();
		socInsrLssEmymtNum.setReadOnly(true);
		layoutContainer_1.add(socInsrLssEmymtNum, new FormData("100%"));
		socInsrLssEmymtNum.setFieldLabel("일련번호");
		layoutContainera7.add(layoutContainer_1,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		LayoutContainer layoutContainera_2 = new LayoutContainer();
		layoutContainera_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(40);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainera_2.setLayout(frmlytStd);

		deptNm = new MSFTextField();
		deptNm.setReadOnly(true);
		layoutContainera_2.add(deptNm, new FormData("100%"));
		deptNm.setFieldLabel("부서");

		layoutContainera7.add(layoutContainera_2,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.36));
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

		layoutContainera7.add(layoutContainerb_2,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		cp02.add(layoutContainera7, new FormData("100%"));

		LayoutContainer layoutContainer17 = new LayoutContainer();
		layoutContainer17.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		socnsrIssRegVal04 = new MSFTextField();
		layoutContainer_2.add(socnsrIssRegVal04, new FormData("100%"));
		socnsrIssRegVal04.setFieldLabel("전화번호(휴)");
		layoutContainer17.add(layoutContainer_2,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		cp02.add(layoutContainer17);

		layoutContainer.add(cp02);

		return layoutContainer;

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

private  LayoutContainer leftGrid01() {
	LayoutContainer lcStdGrid = new LayoutContainer();
	FormLayout frmlytStd = new FormLayout();    
	lcStdGrid.setLayout(frmlytStd);  

	ContentPanel cp01 = new ContentPanel();   
	cp01.setBodyBorder(false); 
	cp01.setHeaderVisible(false);   
	cp01.setLayout(new FitLayout());      
	cp01.setSize(461, 412);  

	insr2200GridPanel = new MSFGridPanel(insr2200Def, false, false, false, false,false);
	insr2200GridPanel.setHeaderVisible(false);  
	insr2200GridPanel.setBodyBorder(true);
	insr2200GridPanel.setBorders(true);

	final Grid insr2100Grid = insr2200GridPanel.getMsfGrid().getGrid(); 
	insr2100Grid.addListener(Events.CellDoubleClick,  new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent be) {  

			if (insr2200GridPanel.getCurrentlySelectedItem() != null) {  
								
				
				//Window.alert(""+insr2200GridPanel.getCurrentlySelectedItem().get("retryDt"));
				
				setRecord(insr2200GridPanel.getCurrentlySelectedItem());	 
				

				retryDt.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("retryDt")));
				
				dpobCd.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("dpobCd")));   /** column 사업장코드 : dpobCd */ 
				systemkey.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("systemkey")));   /** column SYSTEMKEY : systemkey */          	 
				soctyInsurCmptnDt.setValue( (String) insr2200GridPanel.getCurrentlySelectedItem().get("soctyInsurCmptnDt"));   /** column 사회보험작성일자 : soctyInsurCmptnDt */
				
				
				socnsrIssRegVal08Dt.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal08"), "yyyyMMdd"));   /** column 상실일자 : soctyInsurCmptnDt */
				
				
				socInsrLssEmymtNum.setValue((Long)insr2200GridPanel.getCurrentlySelectedItem().get("socInsrLssEmymtNum"));   /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
				// soctyInsurCmptnDt.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("soctyInsurCmptnDt"), "yyyyMMdd"));
				socnsrIssRegVal02.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal02")));
				socnsrIssRegVal03.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal03")));
				socnsrIssRegVal04.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal04")));

				natPennRegrstYn.setValue(MSFSharedUtils.convertStringToBoolean(((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal01")).substring(0, 1)));  
				if(natPennRegrstYn.getValue()){
					socnsrIssRegVal05.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal05"), "yyyyMMdd"));   /** column 사회보험작성일자 : soctyInsurCmptnDt */
					socnsrIssRegVal06.setValue(lsSocnsrIssRegVal06.findModel("commCd",MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal06"))));           		 
					socnsrIssRegVal07.setValue(MSFSharedUtils.convertStringToBoolean( (String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal07")));    /** column 연금_초일.취득당월 상실짜납부여부  : socnsrIssRegVal07 */          
				}else{
					socnsrIssRegVal05.clear();
					socnsrIssRegVal06.clear();
					socnsrIssRegVal07.setValue(false);
				}
				hlthInsrRegrstYn.setValue(MSFSharedUtils.convertStringToBoolean(((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal01")).substring(1, 2)));            		
				if(hlthInsrRegrstYn.getValue()){
					socnsrIssRegVal08.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal08"), "yyyyMMdd"));
					socnsrIssRegVal09.setValue(lsSocnsrIssRegVal09.findModel("commCd",MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal09"))));
					socnsrIssRegVal10.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal10")));
					socnsrIssRegVal11.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal11")));
					socnsrIssRegVal12.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal12")));
					if("2".equals(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal13"))){
						socnsrIssRegVal13.setValue(true);
						socnsrIssRegVal14.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal14")));
						socnsrIssRegVal15.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal15")));
					}else{               	
						socnsrIssRegVal13.setValue(false);
						socnsrIssRegVal14.setValue(0L);
						socnsrIssRegVal15.setValue(0L); 
					}
				}else{
					socnsrIssRegVal08.clear();
					socnsrIssRegVal09.clear();
					socnsrIssRegVal10.setValue(0L);
					socnsrIssRegVal11.setValue(0L);
					socnsrIssRegVal12.setValue(0L);
					socnsrIssRegVal13.setValue(false);
					socnsrIssRegVal14.setValue(0L);
					socnsrIssRegVal15.setValue(0L);
				}
				umytInsrRegrstYn.setValue(MSFSharedUtils.convertStringToBoolean(((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal01")).substring(2, 3)));

				if(umytInsrRegrstYn.getValue()){
					socnsrIssRegVal16.setValue(lsSocnsrIssRegVal16.findModel("commCd",MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal16"))));
					socnsrIssRegVal17.setValue(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal17"));
					socnsrIssRegVal18.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal18"), "yyyyMMdd"));// 연금 상실일
					socnsrIssRegVal19.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal19")));
				}else{
					socnsrIssRegVal16.clear();
					socnsrIssRegVal17.clear();
					socnsrIssRegVal18.clear();
					socnsrIssRegVal19.setValue(0L);
				}
				idtlAccdtRegrstYn.setValue(MSFSharedUtils.convertStringToBoolean(((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal01")).substring(3, 4)));
				if(idtlAccdtRegrstYn.getValue()){
					socnsrIssRegVal20.setValue(lsSocnsrIssRegVal20.findModel("commCd",MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal20"))));
					socnsrIssRegVal21.setValue(insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal21"));  
					socnsrIssRegVal22.setValue(InsrUtils.getConvertStringToDate((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal22"), "yyyyMMdd"));
					socnsrIssRegVal23.setValue(MSFSharedUtils.convertStringToLong((String) insr2200GridPanel.getCurrentlySelectedItem().get("socnsrIssRegVal23")));

				}else{
					socnsrIssRegVal20.clear();
					socnsrIssRegVal21.clear();
					socnsrIssRegVal22.clear();
					socnsrIssRegVal23.setValue(0L);
				}
				emymtDivNm.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("emymtDivNm"))); //고용구분 
				deptNm.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("deptNm"))); //부서 
				typOccuNm.setValue(MSFSharedUtils.allowNulls(insr2200GridPanel.getCurrentlySelectedItem().get("typOccuNm"))); //직종 
				allCheck.setValue(false);  
				if(natPennRegrstYn.getValue()) tabitem01.setEnabled(true);
				else	tabitem01.setEnabled(false);
				if(hlthInsrRegrstYn.getValue())	tabitem02.setEnabled(true); 
				else 	tabitem02.setEnabled(false);          
				if(umytInsrRegrstYn.getValue())	 tabitem03.setEnabled(true);
				else 	tabitem03.setEnabled(false);
				if(idtlAccdtRegrstYn.getValue()) tabitem04.setEnabled(true); 	
				else 	tabitem04.setEnabled(false);   
				int rowIndex = insr2200GridPanel.getMsfGrid().getGrid().getStore().indexOf(insr2200GridPanel.getCurrentlySelectedItem());
				if (rowIndex < 1) {
					funcButtonEnabled(true);
				} else {
					funcButtonEnabled(false); 
				}
				//readDtailData();
				actionDatabase = ActionDatabase.UPDATE;
			}
		}
	});  
	
	insr2100Grid.addListener(Events.CellClick,  new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent be) {  
			if (insr2200GridPanel.getCurrentlySelectedItem() == null) { 
				resetForm();				
			}
		}
	});
	
	
	cp01.add(insr2200GridPanel); 
	cp01.addButton(new Button("상실신고내역보기", new SelectionListener<ButtonEvent>() {   
		@Override  
		public void componentSelected(ButtonEvent ce) {   
			
			
			String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
			String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
			String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
			String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

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
			
			
			
			InsrP230005 insrP23005Form = new InsrP230005(ActionDatabase.CUSTOM, getThis());   
			MSFFormWindows msFwInsr23005 = new MSFFormWindows("4대보험상실신고내역",insrP23005Form,"닫기","1010px", "650px",true);
			msFwInsr23005.show();
			insrP23005Form.setMSFFormWindows(msFwInsr23005);
			funcSetPopUpRecord();
			insrP23005Form.bind(ppRecord);  
		}   
	}));  
	lcStdGrid.add(cp01);  
	return lcStdGrid;  
}
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
			

			IColumnFilter filters = null;
			 
			insr2200GridPanel.getTableDef().setTableColumnFilters(filters);			
			insr2200GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr2200GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 			
			insr2200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			insr2200GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            insr2200GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);          
            
            //20180305추가 
            insr2200GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    		
    		
            String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            insr2200GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);              
            String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            insr2200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
			insr2200GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr2200GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr2200GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
			insr2200GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
			 
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
	        insr2200GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
              
			insr2200GridPanel.reload();
			actionDatabase = ActionDatabase.UPDATE;
			 
			dpobInfoSearch();
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
			if(emymtDivCd.equals("A0020010")){
				flag = true;
			}else if(emymtDivCd.equals("A0020020")){
				if(deptCd != null && !deptCd.equals("") && businCd != null && !businCd.equals("")){
					flag = true;
				}
			}else{
				flag = false;
			}
			if(flag){
				insrP230004Service.activityOnReadInsr230004(bm ,
						new AsyncCallback<BaseModel>() {
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadInsr230004(Read) : " + caught), null);
					}
					public void onSuccess(BaseModel result) { 
						hlthInsrSym.setValue((String) result.get("hlthInsrSym"));
						hlthInsrOfceSym01.setValue((String) result.get("hlthInsrOfceSym"));
						hlthPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));			
						natPennSym.setValue((String) result.get("natPennSym"));
						natPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));			
						umytInsrSym.setEmptyText((String) result.get("umytInsrSym"));
						umytPayMangeDeptNm.setValue((String) result.get("payMangeDeptNm"));				
						idtlAccdtInsurSym.setEmptyText((String) result.get("idtlAccdtInsurSym"));
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
	
	
	  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 
	   public void setPPRecord(BaseModel ppRecord) {
	       this.ppRecord = ppRecord;
	   }   
	   
	   private Insr2300 getThis(){
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
	  
	  

   
	   /**
	    * 첫번째 로우 클릭시에만 활성화 한다. 전체적용.
	    * @param boolBtn
	    */
	   private void funcButtonEnabled(boolean boolBtn) {
		   
		   btnSocnsrIssRegVal05.setEnabled(boolBtn); 
		   btnSocnsrIssRegVal06.setEnabled(boolBtn); 
		   btnSocnsrIssRegVal08.setEnabled(boolBtn);
		   btnSocnsrIssRegVal09.setEnabled(boolBtn);
		   btnSocnsrIssRegVal10.setEnabled(boolBtn); 
		   btnSocnsrIssRegVal09.setEnabled(boolBtn);  
		   btnSocnsrIssRegVal17.setEnabled(boolBtn);  
		   btnSocnsrIssRegVal16.setEnabled(boolBtn);  
		   btnSocnsrIssRegVal18.setEnabled(boolBtn);  
		   btnSocnsrIssRegVal20.setEnabled(boolBtn);  
		   btnSocnsrIssRegVal21.setEnabled(boolBtn);  
		   btnSocnsrIssRegVal22.setEnabled(boolBtn); 

	   }
	  
	  private void funcSetPopUpRecord() {		   
		  BaseModel bmRec = new BaseModel();
		  bmRec.set("dpobCd",  dpobCd.getValue());   
		  bmRec.set("systemkey",  systemkey.getValue());
		  bmRec.set("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd")); 
		  bmRec.set("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd") ); 
		  bmRec.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		  bmRec.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); 
		  String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		  bmRec.set("deptCd", strDeptCd );         
		  String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 

		  bmRec.set("typOccuCd", strTypOccuCd);        
		  String strTypOccuNm = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuNm"); 
		  bmRec.set("typOccuNm", strTypOccuNm); 
		  String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		  bmRec.set("dtilOccuInttnCd", strDtilOccuInttnCd);       
		  String strDtilOccuInttnNm = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuClsNm");  
		  bmRec.set("dtilOccuInttnNm", strDtilOccuInttnNm);
		  bmRec.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
		  bmRec.set("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue())); 
		  bmRec.set("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()));    
		  bmRec.set("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  			 
		  String strHdofcCodtnCd = InsrUtils.getStrValToBMMultiCombo(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd");  
		  bmRec.set("hdofcCodtnCd", strHdofcCodtnCd); 		   
		  bmRec.set("payrMangDeptNm",  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptNm")); 
		  String strHdofcCodtnNm = InsrUtils.getStrValToBMMultiCombo(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCdNm");  
		  bmRec.set("hdofcCodtnNm", strHdofcCodtnNm); 
		  String strDeptNm = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptNmRtchnt");  
		  bmRec.set("deptNm", strDeptNm );       
          bmRec.set("payrMangDeptNm",  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptNm"));
		  bmRec.set("emymtDivNm",  MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCdNm")); 	  
		  bmRec.set("deptCdAuth", MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""));
		  bmRec.set("dtilOccuInttnCdAuth", MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""));			
		  bmRec.set("socInsrLssEmymtNum", socInsrLssEmymtNum.getValue());
		  bmRec.set("soctyInsurCmptnDt", soctyInsurCmptnDt.getValue());		
		  bmRec.set("businNm", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businNm")); 
		  
		  bmRec.set("repbtyBusinDivNm",  MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCdNm")); 
		  bmRec.set("repbtyBusinDivCd",  MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd")); 
			
		  bmRec.set("deptGpNm",  MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCdNm")); 
		  bmRec.set("deptGpCd",  MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCd")); 
		  
		  setPPRecord(bmRec);
  }
	  
	  private void funcSetPopUpInsrP230006Record() {
		  BaseModel bmRec = new BaseModel();
		  
		  
		  bmRec.set("soctyInsurCmptnDt",  soctyInsurCmptnDt.getValue());   
		  
		 // Window.alert(soctyInsurCmptnDt.getValue());
		  
		  
		  bmRec.set("socnsrIssRegVal08Dt",  socnsrIssRegVal08Dt.getValue()); 
		
		  
		  bmRec.set("socnsrIssRegVal02",  socnsrIssRegVal02.getValue());   
		  bmRec.set("socnsrIssRegVal03",  socnsrIssRegVal03.getValue());   
		  bmRec.set("emymtDivNm",  emymtDivNm.getValue());   
		  bmRec.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));  //고용구분
		  bmRec.set("socInsrLssEmymtNum",  socInsrLssEmymtNum.getValue().longValue());   
		  bmRec.set("deptNm",  deptNm.getValue());   
		  bmRec.set("typOccuNm",  typOccuNm.getValue());   
		  bmRec.set("systemkey",  systemkey.getValue());   
		  bmRec.set("dpobCd",  dpobCd.getValue());   
		  bmRec.set("retryDt",  retryDt.getValue());  
		  
		  
  		  bmRec.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  		  bmRec.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
  		  String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		  bmRec.set("deptCd", strDeptCd );  
		  
/*		  String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		  bmRec.set("typOccuCd", strTypOccuCd);  
		  String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		  bmRec.set("dtilOccuInttnCd", strDtilOccuInttnCd);
		  bmRec.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
		  String strHdofcCodtnCd = InsrUtils.getStrValToBMMultiCombo(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd");  
		  bmRec.set("hdofcCodtnCd", strHdofcCodtnCd);*/
	
		  
		  setPPRecord(bmRec);
  }
	  
	  
	  private void fnPopupInsr2300()  {
          //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
          //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
          //검색.처리하면됨.
         MSFFormPanel popCom2000 = PrgmComPopupUtils.lovPopUpPrgmComInsr2000Form();  //인사  
          
          final FormBinding popBindingCom2000 = popCom2000.getFormBinding();
          
          popBindingCom2000.addListener(Events.Change, new Listener<BaseEvent>() {
              public void handleEvent(BaseEvent be) { 
            	  
            	     List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	               
	                 if (mapModels != null) { 
	                       
                      
	                	 for(BaseModel bm : mapModels){
    						// Window.alert(""+bm.get("retryDt"));
    						// Window.alert(""+bm.get("systemkey"));
    					 }
	                	 
	                	 
                      if (MSFSharedUtils.paramNull(mapModels)) {
             	            return;
             	        } else {
             	        
  	           	 		insr2300Service.activityOnInsertInsr2300(mapModels ,
  	           	                new AsyncCallback<Long>() {
  	           	        public void onFailure(Throwable caught) {
  	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
  	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertInsr2300(insert) : " + caught), null);
  	           	        }
  	           	        public void onSuccess(Long result) {  
  	           	        	
  	           	        	 if (result == 0) {
  	           	        		 
  	           	                 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
  	           	                                                                          "등록 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
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
	  
	  
		//엑셀 저장
		private void excelFileExport(String flag) {		                     
			HashMap<String, String> param = new HashMap<String, String>(); 
			
			if(null != flag && !flag.equals("")) param.put("gubun",  flag);
			
			systemKeys = new String();
			systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = insr2200GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
		   insr2200GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2300Export.do","extgwtFrame" ,param);
		}
	  
	  
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 화면 초기화 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
		//검색조건 초기화
		public void resetSearchForm() {
			
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
			
		}
		public void resetForm(){
			 	dpobCd.clear();
		        systemkey.clear();
		        soctyInsurCmptnDt.clear();
		        socnsrIssRegVal08Dt.clear();
		        socInsrLssEmymtNum.clear();
		        emymtDivNm.clear();
		        deptNm.clear();
		        typOccuNm.clear();
		       // DtilOccuClsDivNm.clear();
		        hlthInsrRegrstYn.clear();
		        natPennRegrstYn.clear();
		        umytInsrRegrstYn.clear();
		        idtlAccdtRegrstYn.clear();
		        //socnsrIssRegVal01.clear();
		        socnsrIssRegVal02.clear();
		        socnsrIssRegVal03.clear();
		        socnsrIssRegVal04.clear();
		        socnsrIssRegVal05.clear();
		        socnsrIssRegVal06.clear();
		        socnsrIssRegVal07.clear();
		        socnsrIssRegVal08.clear();
		        socnsrIssRegVal09.clear();
		        socnsrIssRegVal10.clear();
		        socnsrIssRegVal11.clear();
		        socnsrIssRegVal12.clear();
		        socnsrIssRegVal13.clear();
		        socnsrIssRegVal14.clear();
		        socnsrIssRegVal15.clear();
		        socnsrIssRegVal16.clear();
		        socnsrIssRegVal17.clear();
		        socnsrIssRegVal18.clear();
		        socnsrIssRegVal19.clear();
		        socnsrIssRegVal20.clear();
		        socnsrIssRegVal21.clear();
		        socnsrIssRegVal22.clear();
		        socnsrIssRegVal23.clear();
		        systemKeys = "";
		} 
		
		
		
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 인쇄 처리를 위해 추가된 부분 시작
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */
		/**
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     * 	print Service 선언부 시작
	     *  rex 추가로 리포트 타입변경
	     *  fileName : 출력파일명 
	     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     **/
		private void insr23000Print(String fileName, String repType) {
			
			
			   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType.trim())) {
				   RdaPrint(fileName);
			   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType.trim())) {
				   RexPrint(fileName);
			   } else {
				   Window.alert("출력 타입 오류(프로퍼티설정확인)!"+repType);
			   }
		    }	
		//rda
		private void RdaPrint(String fileName) {
			
			/*// 출력물 디렉토리 패스경로 인사 : PSNL
			String strDirPath = "INSR";
			
			// mrd 출력물
			String rdaFileName = fileName+".mrd";
					
			// 보낼 파라미터
			
			//검색조건
			String serarchParam = "";
			String soctyInsurCmptnDt01 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd");
			String soctyInsurCmptnDt02 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd");
			String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
			String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
			String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
			String typOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
			String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
			String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
			String systemkeyStr = MSFSharedUtils.allowNulls(systemkey.getValue());
			String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
			String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue());
			
			if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)){

				//도장 출력을 위해 추가 2014-11-06 //$9
		        String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
		        if(MSFSharedUtils.paramNull(myImgUrl)) {
		           // myImgUrl = "http://105.19.10.32:8080";
		        }
				
				serarchParam += "["+MSFSharedUtils.allowNulls(soctyInsurCmptnDt01.getValue())+"]";				//$1 
				serarchParam += "["+MSFSharedUtils.allowNulls(soctyInsurCmptnDt02.getValue())+"]";				//$2
				serarchParam += "["+MSFSharedUtils.allowNulls(payrMangDeptCd.getValue())+"]";		//$3
				serarchParam += "["+MSFSharedUtils.allowNulls(emymtDivCd.getValue())+"]";		//$4
				serarchParam += "["+MSFSharedUtils.allowNulls(deptCd.getValue())+"]";				//$5
				serarchParam += "["+MSFSharedUtils.allowNulls(typOccuCd.getValue())+"]";			//$6
				serarchParam += "["+MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue())+"]";			//$7
				serarchParam += "["+MSFSharedUtils.allowNulls(businCd.getValue())+"]";    //$8
				serarchParam += "["+MSFSharedUtils.allowNulls(systemkey.getValue())+"]";	//$9
				serarchParam += "["+MSFSharedUtils.allowNulls(hanNm.getValue())+"]";		//$10
				serarchParam += "["+MSFSharedUtils.allowNulls(resnRegnNum.getValue())+"]";		//$10
				serarchParam += "["+MSFSharedUtils.allowNulls(hdofcCodtnCd.getValue())+"]";		//$10
		        					
				String strParam = "/rp " + serarchParam;						
				
				PrintUtils.setPostCall(true);
				PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
			}else{
				MessageBox.alert("", "근로자 정보를 선택하여 주세요.", null);
			}*/
		}
		
		//rex 
		
		
		
		
		
		
		
		
		
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
			List<BaseModel> list = insr2200GridPanel.getGrid().getSelectionModel().getSelectedItems();


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
			actionDatabase = ActionDatabase.UPDATE;
			insr2300Service.activityOnUpdateInsr2100(baseModel,  new AsyncCallback<Long>() {

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
		
		private void RexPrint2(String fileName) {

			
			// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
			String strDirPath = "INSR";

			// reb 출력물
			String rexFileName = fileName+".crf";
			//String rexFileName = fileName+".reb";

			// 보낼 파라미터  

			// 검색조건
			String serarchParam = "";

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
				

				String strParam = "" + serarchParam ;

				//GWT 타입으로 팝업 호출시  postCall true 설정

				PrintUtils.setPostCall(true);
				PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

			}else{
				MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
			}
			


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
