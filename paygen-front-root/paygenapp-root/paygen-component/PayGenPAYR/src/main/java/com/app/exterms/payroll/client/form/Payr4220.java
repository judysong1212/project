package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0350DTO;
import com.app.exterms.payroll.client.form.defs.Payr0303Def;
import com.app.exterms.payroll.client.form.defs.Payr0350Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr4220Service;
import com.app.exterms.payroll.client.service.Payr4220ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
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
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr4220  extends MSFPanel { 
 

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
 *  전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
       private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
        
       private VerticalPanel vp;
       private FormPanel plFrmPayr4220;
          //private FormData formData; 
       private String txtForm = ""; 
        
      //급여대상자정보 
      private Payr0350Def payr0350Def  = new Payr0350Def("PAYR4220");   //그리드 테이블 컬럼 define  
          // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0350GridPanel;
      
        //월별소급내역
      private Payr0350Def payr0350DtlDef  = new Payr0350Def("PAYR4220DTL");   //그리드 테이블 컬럼 define  
          // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0350DtlGridPanel; 
   
        //소급상세내역
      private Payr0303Def payr0303Def  = new Payr0303Def();   //그리드 테이블 컬럼 define  
          // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0303GridPanel;
        
 
    
	    
       /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 상태처리 전역변수
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ActionDatabase actionDatabase;
      
      private ActionDatabase actionDDlneDatabase;   //마감
      
      private  ContentPanel cpGridPayr0303 ;
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
      private ButtonBar topPayr4220Bar;
      private Button btnPayr4220Init;
     // private Button btnPayr4220Save;
      private Button btnPayr4220Del;
      private Button btnPayr4220Sreach;
      private Button btnPayr4220Print;
      private Button btnPayr4220Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhReattyApptnYr;
      private ComboBox<BaseModel> srhReattyApptnMnth;
     
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
//      private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//      private HiddenField<String> srhPyspGrdeCd; //직종 
      
      private ComboBox<BaseModel> srhPayCd;     //급여구분
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드	     
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> srhPymtDducDivCd; 
      
      
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

  	  private Boolean emptyCheck = false ;
      private boolean mutilCombo = false;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
       
      private HiddenField<String> dpobCd;  //사업장코드
      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */
      private HiddenField<String>  payCd ;  /** column 급여구분코드 : payCd */
      private MSFTextField   payNm ;  /** column 급여구분 : payNm */
      private HiddenField<String> reattyYr;   /** column 소급년도 : reattyYr */  
      private MSFTextField reattyStpDsptyNum;   /** column 소급설정회차번호 : reattyStpDsptyNum */
      private MSFTextField reattyApptnYrMnth;   /** column 소급적용년월 : reattyApptnYr */
      
      private MSFTextField reattyPymtYrMnth;   /** column 지급년월 : reattyPymtYrMnth */
          
      private HiddenField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
      private MSFTextField emymtDivNm;   /** column 고용구분 : emymtDivNm */

      private MSFTextField hanNm ;  /** column 한글성명 : hanNm */ 
      private MSFTextField resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
      private HiddenField<String> secRegnNum;   /** column 주민등록번호 : secRegnNum */
      
      private HiddenField<String> deptCd ;  /** column 부서코드 : deptCd */
      private MSFTextField deptNm ;  /** column 부서 : deptNm */

      private HiddenField<String> businCd;   /** column 사업코드 : businCd */
      private HiddenField<String>   businNm;   /** column 사업 : businNm */

      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
      private MSFTextField typOccuNm ;  /** column 직종 : typOccuNm */ 
      
      private HiddenField<String> logSvcYrNumCd ;  /** column 근속년수코드 : logSvcYrNumCd */
      private HiddenField<String> logSvcYrNumNm ;  /** column 근속년수 : logSvcYrNumNm */
     
      private HiddenField<Boolean> reattyPymtPrcsYn;   /** column 소급지급처리여부 : reattyPymtPrcsYn */

      private MSFDateField reattyDdlneDt;   /** column 소급마감일자 : reattyDdlneDt */

      private HiddenField<Boolean> reattyDdlneYn;   /** column 소급마감여부 : reattyDdlneYn */
      

//    private TextField<String> reattyApptnSumJan;   /** column 소급적용금액_1월 : reattyApptnSumJan */
//
//    private TextField<String> reattyApptnSumFeb;   /** column 소급적용금액_2월 : reattyApptnSumFeb */
//
//    private TextField<String> reattyApptnSumMar;   /** column 소급적용금액_3월 : reattyApptnSumMar */
//
//    private TextField<String> reattyApptnSumApr;   /** column 소급적용금액_4월 : reattyApptnSumApr */
//
//    private TextField<String> reattyApptnSumMay;   /** column 소급적용금액_5월 : reattyApptnSumMay */
//
//    private TextField<String> reattyApptnSumJun;   /** column 소급적용금액_6월 : reattyApptnSumJun */
//
//    private TextField<String> reattyApptnSumJul;   /** column 소급적용금액_7월 : reattyApptnSumJul */
//
//    private TextField<String> reattyApptnSumAug;   /** column 소급적용금액_8월 : reattyApptnSumAug */
//
//    private TextField<String> reattyApptnSumSep;   /** column 소급적용금액_9월 : reattyApptnSumSep */
//
//    private TextField<String> reattyApptnSumOct;   /** column 소급적용금액_10월 : reattyApptnSumOct */
//
//    private TextField<String> reattyApptnSumNov;   /** column 소급적용금액_11월 : reattyApptnSumNov */
//
//    private TextField<String> reattyApptnSumDec;   /** column 소급적용금액_12월 : reattyApptnSumDec */
//
//    private TextField<String> reattyApptnSumAggr;   /** column 소급적용금액합계 : reattyApptnSumAggr */
//
//    private TextField<String> reattyItemNoteCtnt;   /** column 소급항목비고내용 : reattyItemNoteCtnt */
 
 
//    private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//    private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//    private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//    private TextField<String> ismt;   /** column 수정자 : ismt */
//
//    private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//    private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  전역변수 선언부  종료
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
   			  private void checkPayr4220Auth( String authAction, ListStore<BaseModel> bm) {   
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
	                  
	              
	                  srhReattyApptnYr.setValue(lsReattyApptnYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	            	  srhReattyApptnMnth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date()))); 
	            	  srhPayCd.setValue(lsPayCd.getAt(0));
	                  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                    // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
	                    // GWTAuthorization.formAuthPopConfig(plFrmPayr4220, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	                    // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
					//gwtAuthorization.formAuthConfig(plFrmPayr4220, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
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
   				     
   				  authMapDef.put("srhReattyApptnYr",Boolean.FALSE); 
   				  authMapDef.put("srhReattyApptnMnth",Boolean.FALSE);
   				  authMapDef.put("srhPayCd",Boolean.FALSE);
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
 *  전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
       //화면 폼 바인딩 처리 
        private void setPayr4220FormBinding() {
         
        // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
        // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
       
        }        
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/    
      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
        //입력수정삭제처리 rpc 처리부     
        private Payr4220ServiceAsync payr4220Service = Payr4220Service.Util.getInstance();
        
        private ListStore<BaseModel> lsReattyApptnYrStore = new ListStore<BaseModel>();  //년도 
        private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
        
        private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
        private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
        
         //--------------------부서 불러 오는 함수 ------------------------------------------------
        private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
         //--------------------부서 불러 오는 함수 ------------------------------------------------
           
        //--------------------사업 불러 오는 함수 -------------------------------------------------
        private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
       //--------------------사업 불러 오는 함수 -------------------------------------------------
        private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
        private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드 
        private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
        private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
        private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
        private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
        private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
        
        private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
        private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
        private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
        private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
        private SysCoCalendarDTO msfCoCalendarDto;  
        private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
        private PrgmComBass0320DTO sysComBass0320Dto;	//직종
        
        private BaseModel record;
    
        private  Iterator<Record> records;
    
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr4220(){
//      payr0350GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//      
//      //검색조건 넘김 
//      bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//      bass0200Service.selectPayr4220List(bass0200Dto, new AsyncCallback<List<Payr4220BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr4220(): "+caught), null);
//                msfPayr4220GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr4220BM> result) {
//              composedPayr4220List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr4220List(List<Payr4220BM> listaMenu) {
//        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//        BaseTreeModel folder = new BaseTreeModel();
//        BaseTreeModel category = null;
//        while ( iter.hasNext() ) {
//          Sysm0200BM mnu = iter.next();
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
//        msfPayr4220GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
    private SelectionListener<ButtonEvent> selectionListener = 
            new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) { 
//              if (ce.getButton() == btnPayr4220Save) {
//                  doAction(ActionDatabase.INSERT);
//              } else if (ce.getButton() == btnPayr4220Save) {
//                  doAction(ActionDatabase.UPDATE);
//              } else
                if (ce.getButton() == btnPayr4220Del) { 
                	deletePayr4220(); 
                }

            }  
        };
      
        
        private void doAction(ActionDatabase actionDatabase) {
            switch (actionDatabase) {
            case INSERT: 
                this.actionDatabase = ActionDatabase.INSERT;
                savePayr4220();
                break;
            case UPDATE:
                this.actionDatabase = ActionDatabase.UPDATE; 
                savePayr4220();
                break;
            case DELETE: 
                break;
            }
        }
         

    private void savePayr4220() { 
        
//        if (MSFSharedUtils.paramNotNull(records)) {
//            
//            
//            List<Payr0303DTO> listPayr0303dto = new ArrayList<Payr0303DTO>();  
//             
//             while (records.hasNext()) {
//           
//                 Record record = (Record) records.next(); 
//                 BaseModel bmMapModel = (BaseModel)record.getModel();
//                   
//                 Payr0303DTO payr0303Dto = new Payr0303DTO();  
//             
//                payr0303Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//                payr0303Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("pymtYrMnth")));    /** column 지급년월 : pymtYrMnth */
//                payr0303Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    /** column 급여구분코드 : payCd */
//                payr0303Dto.setPayrSeilNum((Long)bmMapModel.get("payrSeilNum"));    /** column 급여일련번호 : payrSeilNum */
//                payr0303Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//                payr0303Dto.setMnthPayAdmntSeilNum((Long)bmMapModel.get("mnthPayAdmntSeilNum"));    /** column 월급여조정일련번호 : mnthPayAdmntSeilNum */
//                payr0303Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
//                payr0303Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
//                payr0303Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
//                payr0303Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    /** column null : pymtDducTxtnAmnt */
//                payr0303Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                payr0303Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("mnthPayAdmntAssoBssCtnt")));    /** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
//                payr0303Dto.setMnthPayAdmntYn((Boolean)bmMapModel.get("mnthPayAdmntYn"));    /** column 월급여소급조정여부 : mnthPayAdmntYn */
////                payr0303Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
////                payr0303Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
////                payr0303Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
////                payr0303Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
////                payr0303Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
////                payr0303Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
//                
//                 listPayr0303dto.add(payr0303Dto);
//               
//             }  
//            
//            
//            payr4220Service.activityOnPayr4220(listPayr0303dto, 
//                    actionDatabase,
//                    new AsyncCallback<Long>() { 
//                public void onFailure(Throwable caught) {
//                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr4220(" + actionDatabase.name() + ") : " + caught), null);
//                }
//                public void onSuccess(Long result) { 
//                   if (result == 0) {
//                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//                               actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//                       actionDatabase = ActionDatabase.UPDATE;
//                   } else {
//                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                               actionDatabase + "처리가 완료되었습니다.", null);
//                       reload();
//                       actionDatabase = ActionDatabase.UPDATE;
//                   } 
//                } 
//                 
//            }); 
//        } else {
//            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//            return;
//        }

}   
    
    private void deletePayr4220() {    
    	
        MessageBox.confirm("삭제", "선택된 데이타를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
            @Override
            public void handleEvent(MessageBoxEvent be) {
               // if("Yes".equals(be.getButtonClicked().getText())){
            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                    
                    
                    //값을레코드에 넣음.
                    setListRecord(payr0350GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
                   
                    
                    List<Payr0350DTO> listPayr0350dto = new ArrayList<Payr0350DTO>();  
                    
                    while (records.hasNext()) {
                  
                        Record record = (Record) records.next(); 
                        BaseModel bmMapModel = (BaseModel)record.getModel();
                          
                        Payr0350DTO payr0350Dto = new Payr0350DTO();  
                          
                        

						payr0350Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						payr0350Dto.setReattyYr(MSFSharedUtils.allowNulls(bmMapModel.get("reattyYr")));    /** column 소급년도 : reattyYr */
						payr0350Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));    /** column 급여구분코드 : payCd */
						payr0350Dto.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(bmMapModel.get("reattyStpDsptyNum")));    /** column 소급설정회차번호 : reattyStpDsptyNum */
						payr0350Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//						payr0350Dto.setReattyApptnSumJan(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumJan")));    /** column 소급적용금액_1월 : reattyApptnSumJan */
//						payr0350Dto.setReattyApptnSumFeb(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumFeb")));    /** column 소급적용금액_2월 : reattyApptnSumFeb */
//						payr0350Dto.setReattyApptnSumMar(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumMar")));    /** column 소급적용금액_3월 : reattyApptnSumMar */
//						payr0350Dto.setReattyApptnSumApr(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumApr")));    /** column 소급적용금액_4월 : reattyApptnSumApr */
//						payr0350Dto.setReattyApptnSumMay(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumMay")));    /** column 소급적용금액_5월 : reattyApptnSumMay */
//						payr0350Dto.setReattyApptnSumJun(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumJun")));    /** column 소급적용금액_6월 : reattyApptnSumJun */
//						payr0350Dto.setReattyApptnSumJul(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumJul")));    /** column 소급적용금액_7월 : reattyApptnSumJul */
//						payr0350Dto.setReattyApptnSumAug(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumAug")));    /** column 소급적용금액_8월 : reattyApptnSumAug */
//						payr0350Dto.setReattyApptnSumSep(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumSep")));    /** column 소급적용금액_9월 : reattyApptnSumSep */
//						payr0350Dto.setReattyApptnSumOct(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumOct")));    /** column 소급적용금액_10월 : reattyApptnSumOct */
//						payr0350Dto.setReattyApptnSumNov(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumNov")));    /** column 소급적용금액_11월 : reattyApptnSumNov */
//						payr0350Dto.setReattyApptnSumDec(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumDec")));    /** column 소급적용금액_12월 : reattyApptnSumDec */
//						payr0350Dto.setReattyApptnSumAggr(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumAggr")));    /** column 소급적용금액합계 : reattyApptnSumAggr */
//						payr0350Dto.setReattyItemNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("reattyItemNoteCtnt")));    /** column 소급항목비고내용 : reattyItemNoteCtnt */
//						payr0350Dto.setReattyPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("reattyPymtYrMnth")));    /** column 소급적용년월 : reattyPymtYrMnth */
//						payr0350Dto.setReattyPymtPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("reattyPymtPrcsYn")));    /** column 소급지급처리여부 : reattyPymtPrcsYn */
//						payr0350Dto.setReattyDdlneDt(MSFSharedUtils.allowNulls(bmMapModel.get("reattyDdlneDt")));    /** column 소급마감일자 : reattyDdlneDt */
//						payr0350Dto.setReattyDdlneYn(MSFSharedUtils.allowNulls(bmMapModel.get("reattyDdlneYn")));    /** column 소급마감여부 : reattyDdlneYn */
//						payr0350Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//						payr0350Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//						payr0350Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//						payr0350Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//						payr0350Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//						payr0350Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */


                        listPayr0350dto.add(payr0350Dto);
                      
                    }  
                    
                    if (listPayr0350dto.size() <= 0) {
                        
                        MessageBox.alert("저장",  "저장 할 데이타가 존재하지 않습니다.", null);
                        return;
                    }
                   
                      payr4220Service.deletePayr4220(listPayr0350dto,ActionDatabase.DELETE, new AsyncCallback<Long>() {
                           public void onFailure(Throwable caught) {
                               MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                       MSFMainApp.ADMINMESSAGES.ExceptionMessageService("deletePayr4220(delete) : " + caught), null);
                           }
                          
                        @Override
                        public void onSuccess(Long result) { 
                            if (result == 0) {
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                            } else {
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "삭제 처리가 완료되었습니다.", null);
                                reload(); 
                            } 
                         } 
                         
                       });   
                }
            }
        });   
    	
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
                      
//                      List<Remt3000DTO> listRemt3000dto = new ArrayList<Remt3000DTO>();  
//                      
//                      if (MSFSharedUtils.paramNull(GWTUtils.getStringFromDate(ddlneDt.getValue(),"yyyyMMdd"))) {
//                          MessageBox.alert( "일자오류 ", "마감일자를 입력해 주십시요.", null);
//                          return ;
//                      } 
//                      while (records.hasNext()) {
//                    
//                          Record record = (Record) records.next(); 
//                         // BaseModel bmMapModel = (BaseModel)record.getModel();
//                            
//                          Remt3000DTO remt3000Dto = new Remt3000DTO();   
//                          
//
//						remt3000Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//						remt3000Dto.setClutYrMnth(MSFSharedUtils.allowNulls(record.get("clutYrMnth"))); /** column 퇴직정산정산년월 : clutYrMnth */ 
//						//remt3000Dto.setCalcSevePsnBlggYrMnth(MSFSharedUtils.allowNulls(record.get("calcSevePsnBlggYrMnth")));    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//						remt3000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(record.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//						remt3000Dto.setSystemkey(MSFSharedUtils.allowNulls(record.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//					//	remt3000Dto.setSevePayClutMangeNum(record.get("sevePayClutMangeNum"));    /** column 퇴직정산관리번호 : sevePayClutMangeNum */
//					//	remt3000Dto.setReipDt(record.get("reipDt"));    /** column 영수일자 : reipDt */
//					//	remt3000Dto.setDdlneYn(true);    /** column 마감여부 : ddlneYn */
//						remt3000Dto.setDdlneDt(GWTUtils.getStringFromDate((Date)record.get("ddlneDt"),"yyyyMMdd") );    /** column 마감일자 : ddlneDt */
////						remt3000Dto.setCalcSevePayPsnSumtDt(record.get("calcSevePayPsnSumtDt"));    /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
////						remt3000Dto.setDegtrNm(record.get("degtrNm"));    /** column 대표자성명 : degtrNm */
////						remt3000Dto.setCorpNmFmnm(record.get("corpNmFmnm"));    /** column 법인명_상호 : corpNmFmnm */
////						remt3000Dto.setBusoprRgstnNum(record.get("busoprRgstnNum"));    /** column 사업자등록번호 : busoprRgstnNum */
////						remt3000Dto.setResnRegnNum(record.get("resnRegnNum"));    /** column 주민등록번호 : resnRegnNum */
////						remt3000Dto.setCorpNum(record.get("corpNum"));    /** column 법인번호 : corpNum */
////						remt3000Dto.setIncmRegrstDebrZpcd(record.get("incmRegrstDebrZpcd"));    /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
////						remt3000Dto.setIncmRegrstDebrFndtnAddr(record.get("incmRegrstDebrFndtnAddr"));    /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
////						remt3000Dto.setIncmRegrstDebrDtlPatrAddr(record.get("incmRegrstDebrDtlPatrAddr"));    /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
////						remt3000Dto.setJuriTxOffcCd(record.get("juriTxOffcCd"));    /** column 관할세무서코드 : juriTxOffcCd */
////						remt3000Dto.setPentrCd(record.get("pentrCd"));    /** column 제출자구분코드 : pentrCd */
////						remt3000Dto.setTxDeptyNum(record.get("txDeptyNum"));    /** column 세무대리인번호 : txDeptyNum */
////						remt3000Dto.setHmtxId(record.get("hmtxId"));    /** column 홈텍스ID : hmtxId */
////						remt3000Dto.setTxPgmCd(record.get("txPgmCd"));    /** column 세무프로그램코드 : txPgmCd */
////						remt3000Dto.setPernChrgDeptNm(record.get("pernChrgDeptNm"));    /** column 담당자부서명 : pernChrgDeptNm */
////						remt3000Dto.setPernChrgNm(record.get("pernChrgNm"));    /** column 담당자성명 : pernChrgNm */
////						remt3000Dto.setPernChrgPhnNum(record.get("pernChrgPhnNum"));    /** column 담당자전화번호 : pernChrgPhnNum */
////						remt3000Dto.setCllnDebrDivCd(record.get("cllnDebrDivCd"));    /** column 징수의무자구분코드 : cllnDebrDivCd */ 
//
//                        listRemt3000dto.add(remt3000Dto);
//                        
//                      }  
//                     
//                     
//                     remt0200Service.saveRemt0200ToDDlne(listRemt3000dto, actionDDlneDatabase, new AsyncCallback<Long>(){
//                         public void onFailure(Throwable caught) {
//                             MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                                     MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveRemt0200ToDDlne() : " + caught), null);
//                         }
//                         public void onSuccess(Long result) { 
//                             
//                            if (result == 0) {
//                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//                                       ( actionDDlneDatabase.equals(ActionDatabase.DELETE) ? "마감풀기" : "마감") + "(처리)가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//                            } else {
//                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                                        ( actionDDlneDatabase.equals(ActionDatabase.DELETE) ? "마감풀기" : "마감") + "(처리)가 완료되었습니다.", null);
//                                
////                                if (actionDDlneDatabase.equals(actionDDlneDatabase.INSERT)) {
////                                    reload();
////                                }
//                                remt3000DefGridPanel.reload();
//                                actionDDlneDatabase = ActionDatabase.UPDATE;
//                            } 
//                         } 
//                          
//                     }); 
                     //
                  }
              }
          }); 
            
          
        } else {
            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
            return;
        }

}     
    
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    private void Payr4220Print(String fileName) {
 
        // 출력물 디렉토리 패스경로 인사 : PSNL
    String strDirPath = "PAYR";
        // mrd 출력물
    String rdaFileName = fileName+".mrd";
        // 보낼 파라미터
     
        //검색조건
    String serarchParam = "";
    
    serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";  //$1
    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year") + MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month") +"]"; //$2
    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$3
    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";   //$4
    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";     //$5
    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]";  //$6
    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$7
   // serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd") +"]";  //$8
    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$9
    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";//$11
    
//  serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";
//  serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
//  serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]";
     
      List<BaseModel> list = payr0350GridPanel.getGrid().getSelectionModel().getSelectedItems();
      String checkedSystemKeys = "";
      if(list != null && list.size() > 0){
          String chkkey = "";
          for(BaseModel bm : list){
              chkkey += "'"+bm.get("systemkey")+"',";
          } 
          
          checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
      } 
     
       serarchParam = serarchParam+"["+checkedSystemKeys+"]"; //$10
       
       //TODO 확인 
       if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
           
           serarchParam += "[]";  //$11
           serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$12
       
       } else {
           
           //직종 권한에 대한 처리 추가 기본 처리  $9로해서 처리 할것...$11
//           if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                     && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//               serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//           } else {
//               serarchParam += "[]";
//           }  
           serarchParam += "[]";  //$12
       }
    
        String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
        
        
        //GWT 타입으로 팝업 호출시  postCall true 설정
      PrintUtils.setPostCall(true);
      PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

    }

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  print Service 선언부 시작
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
                    createPayr4220Form();  //화면 기본정보를 설정
                    createSearchForm();    //검색필드를 적용
                    createStandardForm();    //기본정보필드  
                    //엣지변환
                    //vp.setSize("1010px", "700px");
                    vp.setSize("1010px", "750px");
                     
                    /**
                     *  
                      * Create the relations 
                      */
                       final RelationDef  relPayr0350 = new RelationDef(payr0350Def,false); 
                       relPayr0350.addJoinDef("dpobCd", "dpobCd");
                       relPayr0350.addJoinDef("systemkey", "systemkey");
                       relPayr0350.addJoinDef("payCd", "payCd");
                       relPayr0350.addJoinDef("reattyYr", "reattyYr");
                       relPayr0350.addJoinDef("reattyStpDsptyNum", "reattyStpDsptyNum"); 
                       relPayr0350.setLinkedObject(payr0350GridPanel);
                       payr0350DtlDef.addRelation(relPayr0350);  
 
                       
                       // DETAILS 
                       final Grid payr0350Grid = payr0350GridPanel.getMsfGrid().getGrid();
                       payr0350Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
                          public void handleEvent(BaseEvent be) {  
                              if (payr0350GridPanel.getCurrentlySelectedItem() != null) { 
                                 
                                   //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
                                 leftPayr0350Detail(payr0350GridPanel.getCurrentlySelectedItem());
                                 
                                  payr0350DtlDef.synchronizeGridDetail(
                                          payr0350GridPanel.getCurrentlySelectedItem(),
                                          payr0350DtlGridPanel );
                                  
                                //  payr0350DtlGridPanel.reload(); 
                                    
                               }
                              
                               
                             
                               
                          }
                      }); 
                        
                       
                       final RelationDef  relPayr035002 = new RelationDef(payr0350Def,false); 
                       relPayr035002.addJoinDef("dpobCd", "dpobCd");
                       relPayr035002.addJoinDef("systemkey", "systemkey");
                       relPayr035002.addJoinDef("payCd", "payCd");
                       relPayr035002.addJoinDef("reattyYr", "reattyYr");
                       relPayr035002.addJoinDef("reattyStpDsptyNum", "reattyStpDsptyNum"); 
                       relPayr035002.setLinkedObject(payr0350GridPanel);
                       payr0303Def.addRelation(relPayr035002); 
                       
             
                       // DETAILS 
                       final Grid payr0350Grid02 = payr0350GridPanel.getMsfGrid().getGrid();
                       payr0350Grid02.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
                          public void handleEvent(BaseEvent be) {  
                              if (payr0350GridPanel.getCurrentlySelectedItem() != null) { 
                                 
                                  setRecord(payr0350GridPanel.getCurrentlySelectedItem());  
                                  actionDatabase = ActionDatabase.DELETE;
                                  
                                  payr0303Def.synchronizeGridDetail(
                                          payr0350GridPanel.getCurrentlySelectedItem(),
                                          payr0303GridPanel ); 
                                  
                                //  payr0303GridPanel.reload();
                                  actionDatabase = ActionDatabase.UPDATE;
                                 
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
      public Payr4220() {
          
             //엣지변환
    	  //setSize("1010px", "700px");  
            setSize("1010px", "750px");  
      } 
    
      public Payr4220(String txtForm) {
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
      private void createPayr4220Form() {
          
            plFrmPayr4220 = new FormPanel();
            plFrmPayr4220.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr4220());
            //plFrmPayr4220.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여(조정)내역관리");
            plFrmPayr4220.setIcon(MSFMainApp.ICONS.text());
            plFrmPayr4220.setBodyStyleName("pad-text");
            plFrmPayr4220.setPadding(2);
            plFrmPayr4220.setFrame(true); 
            
            
            /************************************************************************
    		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
    		 ************************************************************************/
    		final Button btnlogView = new Button("로그");   
    		
    		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
    		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
    			public void handleEvent(ButtonEvent e) {
    				 //로그 뷰화면 호출 메서드 
    				  funcLogMessage(lblPayrConst.title_Payr4220(),"PAYR4220");
    				}
    			});
    		plFrmPayr4220.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
    		plFrmPayr4220.getHeader().addTool(btnlogView); 
    		/************************************************************************
    		 * 화면 에러 처리시 필요한 부분으로 추가 
    		 ************************************************************************/

              //멀티콤보박스 닫기 
            plFrmPayr4220.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
                @Override
                public void handleEvent(ComponentEvent ce) { 
                 //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                //        if (f instanceof MSFMultiComboBox<?>) {                           
//                        if ("srhDeptCd".equals(f.getName())) {
                //                            
//                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                            
//                        }
                            
                  //      } else {
                    if (mutilCombo) {
                        if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                            //부서
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
                    //    }
                //    } 
                } 
            });

             LayoutContainer layoutContainer = new LayoutContainer();
              layoutContainer.setLayout(new ColumnLayout());
              
              LayoutContainer layoutContainer_1 = new LayoutContainer(); 
              layoutContainer_1.setLayout(new FlowLayout());
              
              ButtonBar buttonBar_1 = new ButtonBar();
              
              Button btnNewButton_2 = new Button("");
              //btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
              buttonBar_1.add(btnNewButton_2);
              layoutContainer_1.add(buttonBar_1);
              layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
              layoutContainer_1.setBorders(false);
              
              LayoutContainer layoutContainer_2 = new LayoutContainer();
              layoutContainer_2.setLayout(new FlowLayout());
              
               
               topPayr4220Bar = new ButtonBar();    
               layoutContainer_2.add(topPayr4220Bar);
               topPayr4220Bar.setAlignment(HorizontalAlignment.RIGHT);
                
//             Button topBtn = new Button("신규");  
//             topBtn.setIcon(MSFMainApp.ICONS.accordion());
//             buttonBar.add(topBtn);
                    

            
//          topBtn = new Button("삭제");  
//          topBtn.setIcon(MSFMainApp.ICONS.accordion());
//          buttonBar.add(topBtn);
            
               btnPayr4220Init = new Button("초기화");  
               btnPayr4220Init.setIcon(MSFMainApp.ICONS.new16());
               topPayr4220Bar.add(btnPayr4220Init);
               btnPayr4220Init.addListener(Events.Select, new Listener<ButtonEvent>() {
                    public void handleEvent(ButtonEvent e) {
                         //초기화 
                        formInit();
                    }
                });
                
                btnPayr4220Del = new Button("삭제");  
                btnPayr4220Del.setIcon(MSFMainApp.ICONS.delete16());
                topPayr4220Bar.add(btnPayr4220Del); 
                btnPayr4220Del.addSelectionListener(selectionListener);
                
                btnPayr4220Sreach = new Button("조회"); 
                btnPayr4220Sreach.setIcon(MSFMainApp.ICONS.search16());
                topPayr4220Bar.add(btnPayr4220Sreach);
                btnPayr4220Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
                    public void handleEvent(ButtonEvent e) {
                        //조회버튼 클릭시 처리 
                        reload();  
                    }
                });
                
                btnPayr4220Print = new Button("인쇄"); 
                btnPayr4220Print.setIcon(MSFMainApp.ICONS.print16()); 
                topPayr4220Bar.add(btnPayr4220Print); 
                btnPayr4220Print.addListener(Events.Select, new Listener<ButtonEvent>() {
                    public void handleEvent(ButtonEvent e) {
                        //버튼 클릭시 처리 
                        Payr4220Print("PAYRT4220") ;
                    }
                });
                
                btnPayr4220Print = new Button("엑셀"); 
                btnPayr4220Print.setIcon(MSFMainApp.ICONS.excel16()); 
                topPayr4220Bar.add(btnPayr4220Print); 
                btnPayr4220Print.addListener(Events.Select, new Listener<ButtonEvent>() {
                    public void handleEvent(ButtonEvent e) {
                        //버튼 클릭시 처리 
                        //exportExcel(); 
                        //payr0350GridPanel.callExportServlet("");
                        exportExcel(); 
                    }
                });
                
            layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
            layoutContainer_2.setBorders(false); 
            layoutContainer.setBorders(false);
            
            plFrmPayr4220.add(layoutContainer);    
              
            
            //파일업로드 처리
            plFrmPayr4220.setAction("bizform");
            plFrmPayr4220.setEncoding(Encoding.MULTIPART);
            plFrmPayr4220.setMethod(Method.POST);
            
        
            vp.add(plFrmPayr4220);
            //엣지변환
            //plFrmPayr4220.setSize("990px", "680px");
            plFrmPayr4220.setSize("990px", "730px");
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
         //급여구분 
         sysComBass0300Dto.setRpsttvCd("B015");
         lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
         lsReattyApptnYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
    	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         //월 
         
         lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
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
                  mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
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
//                  ContentPanel typOccuCdGrid = new ContentPanel();  
//                  typOccuCdGrid.setVisible(false);
//                    
//                    //직종 콤보처리 
//                   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//                   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//                           public void handleEvent(ComponentEvent be) {  
//                             typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//                              public void handleEvent(StoreEvent<BaseModel> be) {  
//                                  
//                                lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//                                mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//                              }  
//                            });  
//                           
//                          }  
//                        });  
//              
//                 typOccuCdGrid.add(typOccuCdGridPanel); 
//                plFrmPayr4220.add(typOccuCdGrid);
                
           lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                 mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                  
               }
           });  
             
         /**
       * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       * 년도 콤보박스 처리  시작
       * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
       */
//               ContentPanel payYrGrid = new ContentPanel();  
//               payYrGrid.setVisible(false);
//                
//               //년도 콤보처리 
//               payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//               payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//                       public void handleEvent(ComponentEvent be) {  
//                         payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//                          public void handleEvent(StoreEvent<BaseModel> be) {  
//                             lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//                             
//                            //  Date today = new Date(); 
//                                // A custom date format
//                            //  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//                             
//                             // BaseModel  bm  =  srhReattyApptnYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//                             // srhReattyApptnYr.setValue(bm);
//                            srhReattyApptnYr.setValue(lsPayYrStore.getAt(0));
//                            Date today = new Date(); 
//                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                            srhReattyApptnMnth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                       
//                          }  
//                        });  
//                       
//                      }  
//                    });  
//          
//            payYrGrid.add(payYrGridPanel); 
//            plFrmPayr4220.add(payYrGrid); 

      
        plFrmPayr4220.setLayout(new FlowLayout());
        
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
		
        fieldSet.setStyleAttribute("marginTop", "10px");
       // fieldSet.setCheckboxToggle(false); 
        
        LayoutContainer lcSchLeft = new LayoutContainer();
        //lcSchLeft.setStyleAttribute("paddingRight", "10px");
       
     
        fieldSet.add(lcSchCol, new FormData("100%"));  
        lcSchLeft.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_8 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_8.setLayout(frmlytSch);
        
        srhReattyApptnYr = new ComboBox<BaseModel>();
        srhReattyApptnYr.setName("srhReattyApptnYr");
        srhReattyApptnYr.setForceSelection(true);
        srhReattyApptnYr.setMinChars(1);
        srhReattyApptnYr.setDisplayField("yearDisp");
        srhReattyApptnYr.setValueField("year");
        srhReattyApptnYr.setTriggerAction(TriggerAction.ALL);
       // srhReattyApptnYr.setEmptyText("--년도선택--");
        srhReattyApptnYr.setSelectOnFocus(true); 
        srhReattyApptnYr.setReadOnly(false);
        srhReattyApptnYr.setEnabled(true); 
        srhReattyApptnYr.setStore(lsReattyApptnYrStore);
        srhReattyApptnYr.setFieldLabel("지급년월"); 
        srhReattyApptnYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {
            	checkPayr4220Auth("srhReattyApptnYr", lsReattyApptnYrStore);
            }
        });
        srhReattyApptnYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
              public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                  //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
               BaseModel bmReattyApptnYr =  se.getSelectedItem(); 
               if (bmReattyApptnYr != null) {
                   
                   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                       
                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
                          
                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year"));
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
        layoutContainer_8.add(srhReattyApptnYr, new FormData("100%"));
        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
        layoutContainer_8.setBorders(false);
        
        LayoutContainer layoutContainer_9 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_9.setLayout(frmlytSch);
        
        /** column 지급년월 : Mnth */ 
        srhReattyApptnMnth = new ComboBox<BaseModel>();
        srhReattyApptnMnth.setName("srhReattyApptnMnth");
        srhReattyApptnMnth.setForceSelection(true);
        srhReattyApptnMnth.setMinChars(1);
        srhReattyApptnMnth.setDisplayField("monthDisp");
        srhReattyApptnMnth.setValueField("month");
        srhReattyApptnMnth.setTriggerAction(TriggerAction.ALL);
       // srhReattyApptnMnth.setEmptyText("--월선택--");
        srhReattyApptnMnth.setSelectOnFocus(true); 
        srhReattyApptnMnth.setReadOnly(false);
        srhReattyApptnMnth.setEnabled(true); 
        srhReattyApptnMnth.setStore(lsPayMonth);
        srhReattyApptnMnth.setHideLabel(true); 
        srhReattyApptnMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	checkPayr4220Auth("srhReattyApptnMnth", lsPayMonth);  
             
              
            }
        });
        
        layoutContainer_9.add(srhReattyApptnMnth, new FormData("100%"));
        lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        layoutContainer_9.setBorders(false);
        
        
        
        LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
      
      
        LayoutContainer layoutContainer_1_1 = new LayoutContainer();
      
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1_1.setLayout(frmlytSch);
      
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
		                	checkPayr4220Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
		layoutContainer_1_1.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
      
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setHideLabel(true);
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
	    layoutContainer.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));       
        
        
        
        LayoutContainer layoutContainer_14 = new LayoutContainer();
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
		                	checkPayr4220Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
               	 }  
              
                
            }
        });    
        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
            	

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
//        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                }
//             
//            } 
//       }); 
        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
        layoutContainer_6.setBorders(false);
        
        
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        layoutContainer_btn.setLayout(frmlytSch);
        
        Button btnHanNm = new Button("검색");
//        layoutContainer_5.add(btnHanNm);
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                srhSystemkey.setValue("");
                srhResnRegnNum.setValue("");   
              fnPopupPsnl0100() ;
                  
            }
        });
        layoutContainer_btn.add(btnHanNm);
        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));
        
        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_7.setLayout(frmlytSch);
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        srhResnRegnNum.setName("srhResnRegnNum");
        srhResnRegnNum.setHideLabel(true);
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
        srhResnRegnNum.setHideLabel(true);
     //   srhResnRegnNum.setFieldLabel("주민번호");
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
 
        
        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급년월
        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
        
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
		                	checkPayr4220Auth("srhDeptCd", lsDeptCd); 
             	 }
            }
        });    
 
        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
           @Override
          public void handleEvent(ComponentEvent ce) { 
                   
                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                         
                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
                             
                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year"));    
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
             
        layoutContainer_2.add(srhDeptCd, new FormData("100%"));
        layoutContainer_2.setBorders(false);
        
        LayoutContainer layoutContainer_10 = new LayoutContainer();
        
        
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
        
        
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_10.setLayout(frmlytSch);
        
        //직종 직종세처리  
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
           
        LayoutContainer layoutContainer_21 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_21.setLayout(frmlytSch); 
        
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
        srhTypOccuCd.setHideLabel(true);
//        srhTypOccuCd.setFieldLabel("직종");
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
		                    
	                }  }
		    		   
             		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkPayr4220Auth("srhTypOccuCd", lsTypOccuCd); 
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
        
        layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
        layoutContainer_10.setBorders(false);
 
        layoutContainer_13.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 지급구분
        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
        layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
        
        fieldSet.add(layoutContainer_13);
        
        
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_1 = new LayoutContainer();
        
     		frmlytSch = new FormLayout();
     		frmlytSch.setLabelWidth(60);
     		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
     		layoutContainer_1.setLayout(frmlytSch);
             
             srhPayCd =  new ComboBox<BaseModel>(); 
             srhPayCd.setName("srhPayCd");
             srhPayCd.setForceSelection(true);
             srhPayCd.setMinChars(1);
             srhPayCd.setDisplayField("commCdNm");
             srhPayCd.setValueField("commCd");
             srhPayCd.setTriggerAction(TriggerAction.ALL);
             srhPayCd.setEmptyText("--지급구분선택--");
             srhPayCd.setSelectOnFocus(true); 
             srhPayCd.setReadOnly(false);
             srhPayCd.setEnabled(true); 
             srhPayCd.setStore(lsPayCd);
             srhPayCd.setFieldLabel("지급구분");
             srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                 public void handleEvent(StoreEvent<BaseModel> be) {  
                 	checkPayr4220Auth("srhPayCd", lsPayCd);
                     
                 }
             });    
             layoutContainer_1.add(srhPayCd, new FormData("100%"));
             
             
             LayoutContainer layoutContainer_4 = new LayoutContainer();
             layoutContainer_4.setBorders(false);
             
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
             
             
             
//        LayoutContainer layoutContainer_16 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);
        
        lcSchCol3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 사업
        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));				// 성명
        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 
        
        fieldSet.add(lcSchCol3);
        
        
        plFrmPayr4220.add(fieldSet); 
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
      
        sysComBass0300Dto = new PrgmComBass0300DTO(); 
        
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         //급여구분 
         sysComBass0300Dto.setRpsttvCd("B008");
         lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         
         
         dpobCd = new HiddenField<String>();  //사업장코드
         systemkey = new HiddenField<String>();    /** column SYSTEMKEY : systemkey */
         payCd  = new HiddenField<String>();   /** column 지급구분코드 : payCd */ 
         reattyYr = new HiddenField<String>();    /** column 소급년도 : reattyYr */   
         emymtDivCd = new HiddenField<String>();   /** column 고용구분코드 : emymtDivCd */
         deptCd = new HiddenField<String>();  /** column 부서코드 : deptCd */ 
         businCd = new HiddenField<String>();    /** column 사업코드 : businCd */ 
         typOccuCd = new HiddenField<String>();    /** column 직종코드 : typOccuCd */  
         logSvcYrNumCd = new HiddenField<String>();  /** column 근속년수코드 : logSvcYrNumCd */ 
         
         businNm = new HiddenField<String>();  /** column 사업 : businNm */
         logSvcYrNumNm = new HiddenField<String>();  /** column 근속년수 : logSvcYrNumNm */ 
         
         reattyPymtPrcsYn = new HiddenField<Boolean>(); /** column 소급지급처리여부 : reattyPymtPrcsYn */
         reattyDdlneYn = new HiddenField<Boolean>();    /** column 소급마감여부 : reattyDdlneYn */
         
        LayoutContainer layoutContainer = new LayoutContainer();
        layoutContainer.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_1 = new LayoutContainer();
        FormLayout frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(0); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_1.setLayout(frmlytStd);
        
        FieldSet fldstNewFieldset = new FieldSet();
      //  fldstNewFieldset.setSize("330px", "500px"); 
        layoutContainer_1.add(fldstNewFieldset);
        fldstNewFieldset.setHeadingHtml("소급대상자정보");
        fldstNewFieldset.setCollapsible(false);
        fldstNewFieldset.setStyleAttribute("marginTop", "10px");
        layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
        layoutContainer_1.setBorders(false);
        
        fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
        
        LayoutContainer layoutContainer_2 = new LayoutContainer();
        frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(0); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_2.setLayout(frmlytStd);
        
        FieldSet fldstNewFieldset_1 = new FieldSet();
      //  fldstNewFieldset_1.setSize(622, 320); 
        layoutContainer_2.add(fldstNewFieldset_1);
        fldstNewFieldset_1.setHeadingHtml("소급상세정보");
        fldstNewFieldset_1.setCollapsible(false);
        fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
        fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
        
        LayoutContainer layoutContainer_3 = new LayoutContainer();
        layoutContainer_3.setLayout(new FlowLayout(1));
        
        FieldSet fldstNewFieldset_4 = new FieldSet();
        fldstNewFieldset_4.setCollapsible(false);
        
        LayoutContainer layoutContainer_4 = new LayoutContainer();
        layoutContainer_4.add(payrLeft01());
        fldstNewFieldset_4.add(layoutContainer_4);
        layoutContainer_4.setBorders(false);
        layoutContainer_3.add(fldstNewFieldset_4);
        fldstNewFieldset_4.setHeadingHtml("월별소급내역");
        layoutContainer_3.setBorders(false); 
        fldstNewFieldset_1.add(layoutContainer_3);
         
        
        FieldSet fldstNewFieldset_2 = new FieldSet();
       // fldstNewFieldset_2.setSize(622, 170);
        layoutContainer_2.add(fldstNewFieldset_2);
        fldstNewFieldset_2.setHeadingHtml("소급상세내역");
        fldstNewFieldset_2.setCollapsible(false);
        
        fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
        
        layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
        layoutContainer_2.setBorders(false);
         
            
        plFrmPayr4220.add(layoutContainer);
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
 private LayoutContainer occupationalRTop() {
     
       LayoutContainer lcTabFormLayer = new LayoutContainer();
     
       ContentPanel cp01 = new ContentPanel();   
       cp01.setBodyBorder(false); 
       cp01.setHeaderVisible(false);   
       cp01.setLayout(new FitLayout());      
       //엣지변환
       //cp01.setSize(610, 80);  
       cp01.setSize(610, 100);  
       
       LayoutContainer lytCtr01 = new LayoutContainer();
       lytCtr01.setLayout(new FlowLayout());
       
       LayoutContainer layoutContainer_5 = new LayoutContainer();
       layoutContainer_5.setLayout(new ColumnLayout());
       
       LayoutContainer layoutContainer_6 = new LayoutContainer();
       FormLayout  frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(70); 
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_6.setLayout(frmlytStd);
       
       hanNm  = new MSFTextField();
       layoutContainer_6.add(hanNm, new FormData("100%"));
       hanNm.setFieldLabel("성 명");
       hanNm.setReadOnly(true);
       layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       layoutContainer_6.setBorders(false);
       
       LayoutContainer layoutContainer_7 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(5); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_7.setLayout(frmlytStd);
       
       secRegnNum = new HiddenField<String>();
       
       resnRegnNum = new MSFTextField();
       resnRegnNum.setReadOnly(true);
       resnRegnNum.setHideLabel(true);
       layoutContainer_7.add(resnRegnNum, new FormData("100%"));
      // resnRegnNum.setFieldLabel("주민번호");
       layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       layoutContainer_7.setBorders(false);
       
       LayoutContainer layoutContainer_8 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_8.setLayout(frmlytStd);
       
       emymtDivNm = new MSFTextField();
       emymtDivNm.setReadOnly(true);
       layoutContainer_8.add(emymtDivNm, new FormData("100%"));
       emymtDivNm.setFieldLabel("고용구분");
       layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
       layoutContainer_8.setBorders(false);
       lytCtr01.add(layoutContainer_5);
       layoutContainer_5.setBorders(false);
        
       LayoutContainer layoutContainer_9 = new LayoutContainer();
       layoutContainer_9.setLayout(new ColumnLayout());
       
       LayoutContainer layoutContainer_10 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_10.setLayout(frmlytStd);
       
       deptNm = new MSFTextField();
       deptNm.setReadOnly(true);
       layoutContainer_10.add(deptNm, new FormData("100%"));
       deptNm.setFieldLabel("부서");
       layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
       layoutContainer_10.setBorders(false);
       
       LayoutContainer layoutContainer_11 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_11.setLayout(frmlytStd);
       
       typOccuNm = new MSFTextField();
       typOccuNm.setReadOnly(true);
       layoutContainer_11.add(typOccuNm, new FormData("100%"));
       typOccuNm.setFieldLabel("직종(사업)");
       layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
       layoutContainer_11.setBorders(false);
       lytCtr01.add(layoutContainer_9);
       layoutContainer_9.setBorders(false);
       
       LayoutContainer layoutContainer_12 = new LayoutContainer();
       layoutContainer_12.setLayout(new ColumnLayout());
       
       LayoutContainer layoutContainer_13 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_13.setLayout(frmlytStd);
       
       reattyApptnYrMnth = new MSFTextField();
       reattyApptnYrMnth.setReadOnly(true);
       layoutContainer_13.add(reattyApptnYrMnth, new FormData("100%"));
       reattyApptnYrMnth.setFieldLabel("소급년도"); 
      
       layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       layoutContainer_13.setBorders(false);
       
       LayoutContainer layoutContainer_14 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_14.setLayout(frmlytStd);
       
       reattyStpDsptyNum = new MSFTextField();
       reattyStpDsptyNum.setReadOnly(true);
       layoutContainer_14.add(reattyStpDsptyNum, new FormData("100%"));
       reattyStpDsptyNum.setFieldLabel("회차");
    
       layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       
       LayoutContainer layoutContainer = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer.setLayout(frmlytStd);
       
       reattyPymtYrMnth = new MSFTextField();
       reattyPymtYrMnth.setReadOnly(true);
       layoutContainer.add(reattyPymtYrMnth, new FormData("100%"));
       reattyPymtYrMnth.setFieldLabel("지급년월");
    
       layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       layoutContainer.setBorders(false);
       
       LayoutContainer layoutContainer_1 = new LayoutContainer();
       frmlytStd = new FormLayout();  
       frmlytStd.setLabelWidth(70); 
       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
       layoutContainer_1.setLayout(frmlytStd);
       
       payNm = new MSFTextField();
       payNm.setReadOnly(true);
       layoutContainer_1.add(payNm, new FormData("100%"));
       payNm.setFieldLabel("지급구분"); 
       layoutContainer_12.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       layoutContainer_1.setBorders(false);
       lytCtr01.add(layoutContainer_12);
       layoutContainer_12.setBorders(false);
      
//       LayoutContainer layoutContainer_2 = new LayoutContainer();
//       layoutContainer_2.setLayout(new ColumnLayout());
//       
//       LayoutContainer layoutContainer_3 = new LayoutContainer();
//       frmlytStd = new FormLayout();  
//       frmlytStd.setLabelWidth(60); 
//       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//       layoutContainer_3.setLayout(frmlytStd);
//      
//       pymtB10100Sum = new NumberField();
//       pymtB10100Sum.setReadOnly(true);
//       layoutContainer_3.add(pymtB10100Sum, new FormData("100%"));
//       pymtB10100Sum.setFieldLabel("기본급");
//       pymtB10100Sum.setAllowDecimals(true); 
//       pymtB10100Sum.setFormat(NumberFormat.getDecimalFormat());
//       layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//       layoutContainer_3.setBorders(false);
//       
//       LayoutContainer layoutContainer_4 = new LayoutContainer();
//       frmlytStd = new FormLayout();  
//       frmlytStd.setLabelWidth(60); 
//       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//       layoutContainer_4.setLayout(frmlytStd);
//
//       
//       pymtT10100Sum = new NumberField();
//       pymtT10100Sum.setReadOnly(true);
//       layoutContainer_4.add(pymtT10100Sum, new FormData("100%"));
//       pymtT10100Sum.setFieldLabel("소득세");
//       pymtT10100Sum.setAllowDecimals(true); 
//       pymtT10100Sum.setFormat(NumberFormat.getDecimalFormat());
//       layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//       layoutContainer_4.setBorders(false);
//       
//       LayoutContainer layoutContainer_15 = new LayoutContainer();
//       frmlytStd = new FormLayout();  
//       frmlytStd.setLabelWidth(60); 
//       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//       layoutContainer_15.setLayout(frmlytStd);
//       
//       pymtT20100Sum = new NumberField();
//       pymtT20100Sum.setReadOnly(true);
//       layoutContainer_15.add(pymtT20100Sum, new FormData("100%"));
//       pymtT20100Sum.setFieldLabel("지방세");
//       pymtT20100Sum.setAllowDecimals(true); 
//       pymtT20100Sum.setFormat(NumberFormat.getDecimalFormat());
//       layoutContainer_2.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//       layoutContainer_15.setBorders(false);
//       
//       LayoutContainer layoutContainer_16 = new LayoutContainer();
//       frmlytStd = new FormLayout();  
//       frmlytStd.setLabelWidth(60); 
//       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//       layoutContainer_16.setLayout(frmlytStd);
//       
//       freeDtyTotAmnt = new NumberField();
//       freeDtyTotAmnt.setReadOnly(true); 
//      
//       layoutContainer_16.add(freeDtyTotAmnt, new FormData("100%"));
//       freeDtyTotAmnt.setFieldLabel("비과세");
//       freeDtyTotAmnt.setAllowDecimals(true); 
//       freeDtyTotAmnt.setFormat(NumberFormat.getDecimalFormat());
//       layoutContainer_2.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//       layoutContainer_16.setBorders(false);
//       lytCtr01.add(layoutContainer_2);
//       layoutContainer_2.setBorders(false);
       
       
       cp01.add(lytCtr01); 
       lcTabFormLayer.add(cp01); 
          
       return lcTabFormLayer;
     
}

 private LayoutContainer occupationalLeft() {
     
     LayoutContainer lcTabFormLayer = new LayoutContainer();
     
    //   
      ContentPanel cp01 = new ContentPanel();   
      cp01.setBodyBorder(false); 
      cp01.setHeaderVisible(false);   
      cp01.setLayout(new FitLayout());      
      cp01.setSize(320, 460);  
     
     //msfCustomForm.setHeaderVisible(false);
     //Instantiate the GridPanel
     payr0350GridPanel = new MSFGridPanel(payr0350Def, false, false, false, false);
     payr0350GridPanel.setHeaderVisible(false);  
     payr0350GridPanel.setBodyBorder(true);
     payr0350GridPanel.setBorders(true);
   //  payr0350GridPanel.setSize(308, 340);  
    //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
      final Grid payr0350Grid = payr0350GridPanel.getMsfGrid().getGrid(); 
      payr0350Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {  
              if (payr0350GridPanel.getCurrentlySelectedItem() != null) {  
                 
                  
              }
            }
        });  
    
     cp01.add(payr0350GridPanel); 
      
     
	  ToolBar toolBar = new ToolBar();
      toolBar.getAriaSupport().setLabel("마감일자");

      toolBar.add(new LabelToolItem("마감일자: "));
      
      /** column 항목적용시작일자 : itemApptnBgnnDt */
      reattyDdlneDt = new MSFDateField();
      reattyDdlneDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
      reattyDdlneDt.setName("ddlneDt"); 
      reattyDdlneDt.setHideLabel(true);
      reattyDdlneDt.setWidth("100px");
      reattyDdlneDt.setValue(new Date());
      
      toolBar.add(reattyDdlneDt);
      toolBar.setAlignment(HorizontalAlignment.RIGHT); 
      
      final ButtonBar btnBar01 = new ButtonBar();     
      btnBar01.setAlignment(HorizontalAlignment.RIGHT); 
       
      
      btnBar01.add(new Button("마 감", new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {  
	    	  
	          
            Iterator<BaseModel> itBm  = payr0350GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
            
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
	    	 
	          Iterator<BaseModel> itBm  = payr0350GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
            
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
       cp01.setBottomComponent(toolBar);
       
      lcTabFormLayer.add(cp01); 
       
        return lcTabFormLayer;  
     
    }   


 private LayoutContainer payrLeft01() {
       
       LayoutContainer lcTabFormLayer = new LayoutContainer();
 
       ContentPanel cp01 = new ContentPanel();   
       cp01.setBodyBorder(false); 
       cp01.setHeaderVisible(false);   
       cp01.setLayout(new FitLayout());  
       //엣지변환
       //cp01.setSize(600, 60);  
       cp01.setSize(600, 80);  
        
       //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
       payr0350DtlGridPanel = new MSFGridPanel(payr0350DtlDef, false, false, false, false);
       payr0350DtlGridPanel.setHeaderVisible(false);  
       payr0350DtlGridPanel.setBodyBorder(true);
       payr0350DtlGridPanel.setBorders(true);
     //  payr0350DtlGridPanel.setSize(300, 140);  
       payr0350DtlGridPanel.getBottomComponent().setVisible(false);
     
        cp01.add(payr0350DtlGridPanel); 
        
        lcTabFormLayer.add(cp01); 
         
        return lcTabFormLayer;  
       
 }
 
 
// private LayoutContainer payrLeft02() {
//       
//       LayoutContainer lcTabFormLayer = new LayoutContainer();
// 
//       ContentPanel cp01 = new ContentPanel();   
//       cp01.setBodyBorder(false); 
//       cp01.setHeaderVisible(false);   
//       cp01.setLayout(new FitLayout());      
//       cp01.setSize(300, 140);   
//       
//       //msfCustomForm.setHeaderVisible(false);
//       //Instantiate the GridPanel
//        payr0302DducGridPanel = new MSFGridPanel(payr0302DducDef, false, false, false, false);
//        payr0302DducGridPanel.setHeaderVisible(false);  
//        payr0302DducGridPanel.setBodyBorder(true);
//        payr0302DducGridPanel.setBorders(true); 
//        payr0302DducGridPanel.getBottomComponent().setVisible(false);
//     //   payr0302DducGridPanel.setSize(300, 140); 
//        cp01.add(payr0302DducGridPanel);
//        
//        lcTabFormLayer.add(cp01); 
//         
//        return lcTabFormLayer;  
//       
// }
 
//급여조정 
private LayoutContainer occupationalRBottom() {
      

  LayoutContainer lcTabFormLayer = new LayoutContainer();


  ContentPanel cpGridPayr0303 = new ContentPanel();   
  cpGridPayr0303.setBodyBorder(false); 
  cpGridPayr0303.setHeaderVisible(false);   
  cpGridPayr0303.setLayout(new FitLayout()); 
  //엣지변환
  //cpGridPayr0303.setSize(610, 260);  
  cpGridPayr0303.setSize(610, 280);  
  
  //msfCustomForm.setHeaderVisible(false);
  //Instantiate the GridPanel
  payr0303GridPanel = new MSFGridPanel(payr0303Def, false, false, false, false,false);
  payr0303GridPanel.setHeaderVisible(false);  
  payr0303GridPanel.setBodyBorder(true);
  payr0303GridPanel.setBorders(true); 
  payr0303GridPanel.getBottomComponent().setVisible(false);
 // payr0303GridPanel.setSize(600, 145); 
  
  cpGridPayr0303.add(payr0303GridPanel);  

//  cpGridPayr0303.addButton(  new Button("소득세재계산", new SelectionListener<ButtonEvent>() {   
//    @Override  
//    public void componentSelected(ButtonEvent ce) {   
//        
//        
//     
//     if (MSFSharedUtils.paramNotNull(systemkey.getValue())) {
//         
//       
//         if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//             MessageBox.alert("마감", " 마감처리된 데이타는 소득세를 재계산 하실 수 없습니다.", null);
//             return;
//         }
//        
//            
//         MessageBox.confirm("소득세재계산", "급여조정내역을 입력하면 자동으로 소득세가 계산됩니다. \n 이전 소득세 계산 오류가 있을 경우  소득세를  다시 계산합니다.\n 소득세를 재 계산 하시겠습니까?",new Listener<MessageBoxEvent>(){
//             @Override
//             public void handleEvent(MessageBoxEvent be) {
//                 //if("Yes".equals(be.getButtonClicked().getText())){
//  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//                    
//                     Payr0303DTO  payr0303Dto = new Payr0303DTO();  
//                     
//                     payr0303Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
//                     payr0303Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(pymtYrMnth.getValue()));    /** column 지급년월 : pymtYrMnth */
//                     payr0303Dto.setPayCd(MSFSharedUtils.allowNulls(payCd.getValue()));    /** column 급여구분코드 : payCd */
//                     payr0303Dto.setPayrSeilNum(payrSeilNum.getValue());    /** column 급여일련번호 : payrSeilNum */
//                     payr0303Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));    /** column SYSTEMKEY : systemkey */
////                     payr0303Dto.setMnthPayAdmntSeilNum((Long)bmMapModel.get("mnthPayAdmntSeilNum"));    /** column 월급여조정일련번호 : mnthPayAdmntSeilNum */
////                     payr0303Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
////                     payr0303Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
////                     payr0303Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
////                     payr0303Dto.setPymtDducTxtnAmnt((Long)bmMapModel.get("pymtDducTxtnAmnt"));    /** column null : pymtDducTxtnAmnt */
////                     payr0303Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////                     payr0303Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("mnthPayAdmntAssoBssCtnt")));    /** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
////                     payr0303Dto.setMnthPayAdmntYn((Boolean)bmMapModel.get("mnthPayAdmntYn"));    /** column 월급여소급조정여부 : mnthPayAdmntYn */
//           
//                     
//                     payr4220Service.activityOnCalcPayr4220(payr0303Dto ,
//                             new AsyncCallback<Long>() { 
//                         public void onFailure(Throwable caught) {
//                             MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                                     MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnCalcPayr4220() : " + caught), null);
//                         }
//                         public void onSuccess(Long result) { 
//                            if (result == 0) {
//                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),   "소득세 재계산 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//                                actionDatabase = ActionDatabase.UPDATE;
//                            } else {
//                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                                       "소득세 재계산 처리가 완료되었습니다.", null);
//                                reload();
//                                actionDatabase = ActionDatabase.UPDATE;
//                            } 
//                         } 
//                          
//                     }); 
//                         
//                 }
//             }
//         });   
//         
//         
//        } else {
//            MessageBox.alert("소득세수동계산", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//            return;
//        }
//         
//    }   
//  })); 
//  cpGridPayr0303.addButton( new Button("신규", new SelectionListener<ButtonEvent>() {   
//      @Override  
//      public void componentSelected(ButtonEvent ce) {   
////         BaseModel bm = new BaseModel();
////         
////         bm = payr0303GridPanel.getTableDef().getDefaultValues();
////         RowEditor rowEdit = new RowEditor();
////         
////         /**================================================================================= 
////         //인서트시 초기셋팅부분 .
////         ====================================================================================*/ 
////         bm.set("dpobCd", MSFMainApp.get().getUser().getDpobCd() );
////         bm.set("pymtYrMnth", pymtYrMnth.getValue());
////         bm.set("systemkey",systemkey.getValue() );
////         bm.set("payCd", payCd.getValue());
////         bm.set("payrMangDeptCd",payrMangDeptCd.getValue() );
////         bm.set("payrSeilNum", payrSeilNum.getValue());
////         bm.set("mnthPayAdmntSeilNum", 0);
////         bm.set("payItemCd", new BaseModel());
////         /**================================================================================= 
////         //인서트시 초기셋팅부분 .
////         ====================================================================================*/ 
////          
////          for (int i=0;i < payr0303GridPanel.getGrid().getPlugins().size();i++) {
////              if (payr0303GridPanel.getGrid().getPlugins().get(i) instanceof RowEditor) {
////                  rowEdit = (RowEditor)payr0303GridPanel.getGrid().getPlugins().get(i);
////                  rowEdit.stopEditing(false);  
////                  payr0303GridPanel.getGrid().getStore().insert(bm, 0);  
////                  rowEdit.startEditing(payr0303GridPanel.getGrid().getStore().indexOf(bm), true);  
////                  break;
////              }
////          }
//         
////          if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
////              MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
////              return;
////          }
//         
//          fnPopupCommP500();  
//       
//      }   
//    }));
  
  cpGridPayr0303.addButton(  new Button("저장", new SelectionListener<ButtonEvent>() {   
    @Override  
    public void componentSelected(ButtonEvent ce) {   
       
//        if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//            MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//            return;
//        }
        
        setListRecord(payr0303GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());  
        
        doAction(actionDatabase); 
         
    }   
  })); 
  
  cpGridPayr0303.addButton(  new Button("삭제", new SelectionListener<ButtonEvent>() {   
        @Override  
        public void componentSelected(ButtonEvent ce) {   
            
//            if (MSFSharedUtils.paramNotNull(payDdlneDt.getValue()) && ("Y".equals(payDdlneYn.getValue()))) {
//                MessageBox.alert("마감", " 마감처리된 데이타는 급여조정을 하실 수 없습니다.", null);
//                return;
//            }
           
            
//            MessageBox.confirm("소득세재계산", "급여조정내역을 입력하면 자동으로 소득세가 계산됩니다. \n 이전 소득세 계산 오류가 있을 경우  소득세를  다시 계산합니다.\n 소득세를 재 계산 하시겠습니까?",new Listener<MessageBoxEvent>(){
//                @Override
//                public void handleEvent(MessageBoxEvent be) {
//                    if("Yes".equals(be.getButtonClicked().getText())){
//
//                        
//                        Iterator<BaseModel> itBm  = payr0303GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//                        
//                        List<Record>  lsRec  = new ArrayList<Record>();
//                        
//                        while(itBm.hasNext()) {
//
//                            Record rec  = new Record(itBm.next()); 
//                            lsRec.add(rec);
//                            
//                        } 
//                         setListRecord(lsRec.iterator()); 
//                          
//                         actionDatabase = ActionDatabase.DELETE;
//                         doAction(actionDatabase);
//                          
//                            
//                    }
//                }
//            });   
            
        }   
      }));  
   
  lcTabFormLayer.add(cpGridPayr0303); 
    
       return lcTabFormLayer;
} 

  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~       
   **/   

    private void leftPayr0350Detail(BaseModel selRecord) {
         
        
         dpobCd.setValue((String)selRecord.get("dpobCd"));  //사업장코드
         systemkey.setValue((String)selRecord.get("systemkey"));    /** column SYSTEMKEY : systemkey */
        // pymtYrMnth.setValue((String)selRecord.get("pymtYrMnth"));   /** column 지급년월 : pymtYrMnth */
         payCd.setValue((String)selRecord.get("payCd")) ;  /** column 급여구분코드 : payCd */
        // payrMangDeptCd.setValue((String)selRecord.get("payrMangDeptCd"));   /** column 단위기관코드 : payrMangDeptCd */
        // payrSeilNum.setValue((Long)selRecord.get("payrSeilNum"));   /** column 급여일련번호 : payrSeilNum */
         emymtDivCd.setValue((String)selRecord.get("emymtDivCd"));   /** column 고용구분코드 : emymtDivCd */
         hanNm.setValue((String)selRecord.get("hanNm")) ;  /** column 한글성명 : hanNm */
         resnRegnNum.setValue((String)selRecord.get("resnRegnNum"));   /** column 주민등록번호 : resnRegnNum */
         secRegnNum.setValue((String)selRecord.get("secRegnNum"));   /** column 주민등록번호 : secRegnNum */
         
         deptCd.setValue((String)selRecord.get("deptCd")) ;  /** column 부서코드 : deptCd */
         deptNm.setValue((String)selRecord.get("deptNm")) ;  /** column 부서 : deptNm */
         businCd.setValue((String)selRecord.get("businCd"));   /** column 사업코드 : businCd */
         
        // if (MSFSharedUtils.paramNull(typOccuNm.getRawValue())) {
        //   businNm.setFieldLabel("사업");
        //   businNm.setValue((String)selRecord.get("businNm"));   /** column 사업코드 : businNm */ 
        // } else {
             businNm.setFieldLabel("직종");
             businNm.setValue((String)selRecord.get("typOccuNm")) ;  /** column 직종코드 : typOccuNm */
        // }
         typOccuCd.setValue((String)selRecord.get("typOccuCd"));   /** column 직종코드 : typOccuCd */ 
         logSvcYrNumCd.setValue((String)selRecord.get("logSvcYrNumCd")) ;  /** column 근속년수코드 : logSvcYrNumCd */
         logSvcYrNumNm.setValue((String)selRecord.get("logSvcYrNumNm")) ;  /** column 근속년수 : logSvcYrNumNm */
//         pymtTotAmnt.setValue((Long)selRecord.get("pymtTotAmnt"));   /** column 지급총액 : pymtTotAmnt */
//         extpyTotAmnt.setValue((Long)selRecord.get("extpyTotAmnt")) ;  /** column 수당총액 : extpyTotAmnt */
//         txtnTotAmnt.setValue((Long)selRecord.get("txtnTotAmnt"));   /** column 과세총액 : txtnTotAmnt */
//         freeDtyTotAmnt.setValue((Long)selRecord.get("freeDtyTotAmnt"));   /** column 비과세총액 : freeDtyTotAmnt */
//         dducTotAmnt.setValue((Long)selRecord.get("dducTotAmnt"));   /** column 공제총액 : dducTotAmnt */
//         txTotAmnt.setValue((Long)selRecord.get("txTotAmnt"));   /** column 세금총액 : txTotAmnt */
//         pernPymtSum.setValue((Long)selRecord.get("pernPymtSum")) ;  /** column 차인지급액 : pernPymtSum */
//         bnkCd.setValue((String)selRecord.get("bnkCd"));   /** column 은행코드 : bnkCd */
//         bnkNm.setValue((String)selRecord.get("bnkNm")) ;  /** column 은행코드 : bnkNm */
//         bnkAccuNum.setValue((String)selRecord.get("bnkAccuNum")) ;  /** column 은행계좌번호 : bnkAccuNum */
//         acntHodrNm.setValue((String)selRecord.get("acntHodrNm"));   /** column 예금주명 : acntHodrNm */
//         payDdlneDt.setValue((String)selRecord.get("payDdlneDt")) ;  /** column 급여마감일자 : payDdlneDt */
//         payDdlneYn.setValue((String)selRecord.get("payDdlneYn")) ;  /** column 급여마감여부 : payDdlneYn */
//         pymtB10100Sum.setValue((Long)selRecord.get("pymtB10100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 기본급 : pymtB10100Sum */
//         pymtT10100Sum.setValue((Long)selRecord.get("pymtT10100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 소득세 : pymtT10100Sum */
//         pymtT20100Sum.setValue((Long)selRecord.get("pymtT20100Sum"));   /** column 공제총액 : dducTotAmnt *//** column 주민세  : pymtT20100Sum */
        
    }
      
    public void reload() {
            // TODO Auto-generated method stub
            subformInit();
            IColumnFilter filters = null;
            payr0350GridPanel.getTableDef().setTableColumnFilters(filters);
             
            payr0350GridPanel.getTableDef().addColumnFilter("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0350GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            payr0350GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0350GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             

          //20180305추가 
            payr0350GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0350GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            
            String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            payr0350GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
            String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            payr0350GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           // String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
           // payr0350GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            payr0350GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
         
            payr0350GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0350GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0350GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
            payr0350GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
            
            payr0350GridPanel.reload();
            
            actionDatabase = ActionDatabase.UPDATE;
        }

    //폼초기화 검색조건포함 
       private void formInit() {
           BaseModel bmInit = new BaseModel();
             
           subformInit();
           //grid init
           payr0350GridPanel.getMsfGrid().clearData(); 
           
           actionDatabase = ActionDatabase.UPDATE;
           
           //급여상세정보초기화 
       }
       
       private void subformInit() {
           BaseModel bmInit = new BaseModel();
          
            dpobCd.setValue("");  //사업장코드
            systemkey.setValue("");    /** column SYSTEMKEY : systemkey */ 
            payCd.setValue("") ;  /** column 급여구분코드 : payCd */ 
            payNm.setValue("") ;  /** column 급여구분 : payNm */
            reattyYr.setValue("");   /** column 소급년도 : reattyYr */  
            reattyStpDsptyNum.setValue("");   /** column 소급설정회차번호 : reattyStpDsptyNum */
            reattyApptnYrMnth.setValue("");   /** column 소급적용년월 : reattyApptnYr */
            
            reattyPymtYrMnth.setValue("");   /** column 지급년월 : reattyPymtYrMnth */
            
           emymtDivCd.setValue("");   /** column 고용구분코드 : emymtDivCd */
           hanNm.setValue("") ;  /** column 한글성명 : hanNm */
           resnRegnNum.setValue("");   /** column 주민등록번호 : resnRegnNum */
           secRegnNum.setValue("");   /** column 주민등록번호 : secRegnNum */
           deptCd.setValue("") ;  /** column 부서코드 : deptCd */
           deptNm.setValue("") ;  /** column 부서 : deptNm */
           businCd.setValue("");   /** column 사업코드 : businCd */
           businNm.setValue("");   /** column 사업코드 : businNm */
           typOccuCd.setValue("");   /** column 직종코드 : typOccuCd */
           typOccuNm.setValue("") ;  /** column 직종코드 : typOccuNm */
           logSvcYrNumCd.setValue("") ;  /** column 근속년수코드 : logSvcYrNumCd */
           logSvcYrNumNm.setValue("") ;  /** column 근속년수 : logSvcYrNumNm */
 
           //grid init 
           payr0350DtlGridPanel.getMsfGrid().clearData(); 
           payr0303GridPanel.getMsfGrid().clearData();
             
       }
       
//          /**
//        * 지급공제선택 
//        */
//      private void fnPopupCommP500() {
//          //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//          //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//          //검색.처리하면됨.
//          SysComP0500DTO sysComP0500Dto = new SysComP0500DTO();
//          //지급공제구분코드 넘김.
//          MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpMsfCom0500Form(sysComP0500Dto);  //인사  
//          
//          final FormBinding popBindingCom0500 = popCom0500.getFormBinding();
//         
//          popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
//              public void handleEvent(BaseEvent be) {
//                 
//                  List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
//                  
//                  if (mapModels != null) { 
//                        
//                      if (mapModels.size() > 1) {
//                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                                  actionDatabase + "시 한건의 데이타만 선택가능합니다. 데이타를 확인하십시요.", null);
//                          return;
//                      }
//                      
//                      
//                      BaseModel bmData = payr0303GridPanel.getTableDef().getDefaultValues(); 
//                 
//                      Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
//                      while (iterRecords.hasNext()) {
//                            BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
//                           
//                            bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */ 
//                           // bmData.set("payrMangDeptCd",payrMangDeptCd.getValue());    /** column null : payrMangDeptCd */
//                           // bmData.set("payrSeilNum",payrSeilNum.getValue());    /** column null : payrSeilNum */
//                            bmData.set("mnthPayAdmntSeilNum",0L);    /** column null : mnthPayAdmntSeilNum */
//                          //  bmData.set("pymtYrMnth",pymtYrMnth.getValue());    /** column null : pymtYrMnth */
//                            bmData.set("payCd$commCd",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column null : payCd */
//                            bmData.set("payCd$commCdNm",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCdNm"));    /** column null : payCd */
//                          //  bmData.set("payCd",lsPayCd.getAt(0));    /** column null : payCd */
//                            bmData.set("systemkey",systemkey.getValue());    /** column systemKey : systemkey */
//                            bmData.set("payItemCd",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));       /** column 급여항목코드 : payItemCd */ 
//                            bmData.set("payItemNm",MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));      /** column 급여항목코드 : payItemNm */
//                            bmData.set("pymtDducDivCd$commCd",MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column null : pymtDducDivCd */
//                            bmData.set("pymtDducDivCd$commCdNm",MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivNm")));    /** column null : pymtDducDivCd */
//                            bmData.set("pymtDducFreeDtySum",0L);    /** column null : pymtDducFreeDtySum */
//                            bmData.set("pymtDducTxtnAmnt",0L);      /** pymtDducTxtnAmnt */
//                            
//                             bmData.set("pymtDducSum",(Long)bmMapModel.get("payExtpySum"));    /** column null : pymtDducSum */
//                            bmData.set("mnthPayAdmntAssoBssCtnt","");    /** column null : mnthPayAdmntAssoBssCtnt */
//                            bmData.set("mnthPayAdmntYn",false);    /** column null : mnthPayAdmntYn */
////                            bmData.set("kybdr",);    /** column null : kybdr */
////                            bmData.set("inptDt",);    /** column null : inptDt */
////                            bmData.set("inptAddr",);    /** column null : inptAddr */
////                            bmData.set("ismt",);    /** column null : ismt */
////                            bmData.set("revnDt",);    /** column null : revnDt */
////                            bmData.set("revnAddr",);    /** column null : revnAddr */ 
//                              
//                      }  
//                        
//                     
//                      payr0303GridPanel.getMsfGrid().getGrid().stopEditing();      
//                      payr0303GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//                      payr0303GridPanel.getMsfGrid().getGrid().startEditing(payr0303GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 4);   
//                      
//                      actionDatabase = ActionDatabase.INSERT; 
//                  }  
//                   
//                  
//              }
//          });
//      }
       
       public void setRecord(BaseModel record) {
           this.record = record;
       }
     

       public void setListRecord(Iterator<Record> records) {
             this.records = records;
         }
 

       private Payr4220 getThis(){
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
        
     //엑셀저장함수 
        public void exportExcel() {
            // TODO Auto-generated method stub
            // payr0301GridPanel.callExportServlet("");
            HashMap<String, String> param = new HashMap<String, String>(); 
            
            DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
            
            param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
            param.put("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month"))); 
            param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
            
            param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
            param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
            
            param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
            param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
            param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
            param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
           // param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
            param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
            param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
            param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
            param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
            param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

            //넘어온메서드 값을 가지고 처리 한다.  
           // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
            GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPayr4220Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
              
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

 
