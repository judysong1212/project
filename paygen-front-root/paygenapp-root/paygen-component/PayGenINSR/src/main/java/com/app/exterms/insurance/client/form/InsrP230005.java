
package com.app.exterms.insurance.client.form;
  

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.form.defs.Insr2200Def;
import com.app.exterms.insurance.client.service.Insr2300Service;
import com.app.exterms.insurance.client.service.Insr2300ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class InsrP230005   extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    

/**0
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
	  private  ContentPanel cpInsr4201; 

	  private Insr2200Def pInsr2200Def  = new Insr2200Def("INSRP230005");   //그리드 테이블 컬럼 define  
	  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel pInsr2200GridPanel;
	  
	    //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
		   
		  private GridCellRenderer<Stock> gridNumber;   
		  private GridCellRenderer<Stock> change;
		 
		  //권한 설정 객체 
		  private GWTAuthorization gwtAuthorization;
		  private GWTExtAuth gwtExtAuth;
		  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
		  
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
  public  FormBinding formBinding;
  
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
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  
  /** column  년도 : payYr */
  private ComboBox<BaseModel> srhPayYr;
  private ComboBox<BaseModel> srhPayMonth;
  
  
  /** column  년도 : payYr */
  private DateField srhSoctyInsurCmptnDt01;					//작성기간 시작
  private DateField srhSoctyInsurCmptnDt02; 				//작성기간 종료 
  private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 		//재직상태  
 
//  private ComboBox<BaseModel> srhTypOccuCd; //직종 
//  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//  private HiddenField<String> srhPyspGrdeCd; //직종 
  
  private ComboBox<BaseModel> srhPayCd;     //급여구분
  private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
  private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
  
  private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//  private TextField<String> srhDeptCd; //부서코드
//  private TextField<String> srhDeptNm; //부서명  
//  private Button btnSrhDeptCd;
//  private TextField<String> srhMangeDeptCd; //관리부서 수정
//  private TextField<String> srhMangeDeptNm; //관리부서 수정  
  
  private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
  private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
  
  private ComboBox<BaseModel> srhBusinCd;    //사업
  private TextField<String> srhHanNm;         //성명
  private TextField<String> srhResnRegnNum;   //주민번호 
  private HiddenField<String> srhSystemkey;   //시스템키
  
  private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
 private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
  
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


      private HiddenField<String> dpobCd;  //사업장코드
      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */ 
      private HiddenField<String> socInsrLssEmymtNum;
      
      
      
      private HiddenField<String> soctyInsurCmptnDt01;
      private HiddenField<String> soctyInsurCmptnDt02;
      private HiddenField<String> hdofcCodtnCd; //재직상태
      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */
      private HiddenField<String> hanNm; //성명
      private HiddenField<String> resnRegnNum; //주민번호
      private HiddenField<String> secRegnNum; //주민번호
      private HiddenField<String> emymtDivCd;   /** column 고용구분  */
      private HiddenField<String> deptCd; //부서      
      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuNm */ 
      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
      private HiddenField<String> businCd;   /** column 사업코드 : businNm */
      
      
      
      private HiddenField<String> hdofcCodtnNm; //재직상태명
      private HiddenField<String> payrMangDeptNm;//단위기관명
      private HiddenField<String> typOccuNm;//직종명
      private HiddenField<String> dtilOccuInttnNm;//직종세명
      private HiddenField<String> deptNm;
      private HiddenField<String> emymtDivNm;
      private HiddenField<String> businNm;   /** column 사업코드 : businNm */
      
      private HiddenField<String>  pymtYrMnth;   /** column 지급년월 : pymtYrMnth */   
      private HiddenField<String>  payCd ;  /** column 급여구분코드 : payCd */
      private HiddenField<Long> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
      private HiddenField<String> currAffnDeptCd ;  /** column 부서 : deptNm */

     
      private HiddenField<String> deptCdAuth;
      private HiddenField<String> dtilOccuInttnCdAuth;
      private String systemKeys;
       
      private HiddenField<String> repbtyBusinDivCd; //호봉제구분코드 
      private HiddenField<String> deptGpCd; //부서직종그룹코드
      private HiddenField<String> repbtyBusinDivNm; //호봉제구분코드 
      private HiddenField<String> deptGpNm; //부서직종그룹코드
      
     
      
      
 //     private HiddenField<String>  pyspGrdeCd;  /**  column 고용구분 : emymtDivNm */
      
      private TextField<String> 	frstEmymtDt  ;                         /**  column 최초고용일자 : frstEmymtDt */
    
      private HiddenField<String> logSvcYrNumCd ;  /** column 근속년수코드 : logSvcYrNumCd */
      private HiddenField<String>  logSvcMnthIcmCd  ;                           /**  column 근속년수 : logSvcYrNumNm */
      private  TextField<String> logSvcMnthIcmNm;                             /**  column 재직상태코드 : hdofcCodtnNm */

      private NumberField  pymtTotAmnt;   /** column 지급총액 : pymtTotAmnt */ 
      private NumberField extpyTotAmnt ;  /** column 수당총액 : extpyTotAmnt */ 
      private NumberField  txtnTotAmnt;   /** column 과세총액 : txtnTotAmnt */ 
      private NumberField freeDtyTotAmnt;   /** column 비과세총액 : freeDtyTotAmnt */ 
      private NumberField  dducTotAmnt;   /** column 공제총액 : dducTotAmnt */ 
      private NumberField  txTotAmnt;   /** column 세금총액 : txTotAmnt */  
      private NumberField  pernPymtSum ;  /** column 차인지급액 : pernPymtSum */ 
      
//      private HiddenField<String> bnkCd;   /** column 은행코드 : bnkCd */
//      private HiddenField<String>  bnkNm ;  /** column 은행코드 : bnkNm */
//      private HiddenField<String> bnkAccuNum ;  /** column 은행계좌번호 : bnkAccuNum */
//      private HiddenField<String>  acntHodrNm;   /** column 예금주명 : acntHodrNm */
//
//      private HiddenField<String> payDdlneDt ;  /** column 급여마감일자 : payDdlneDt */
//      private HiddenField<String> payDdlneYn ;  /** column 급여마감여부 : payDdlneYn */
// 
//      private NumberField  pymtB10100Sum ;     /** column 기본급 : pymtB10100Sum */ 
      
      private NumberField  pymtT10100Sum ;    /** column 소득세 : pymtT10100Sum */
      private NumberField  pymtT20100Sum ;    /** column 주민세  : pymtT20100Sum */
      
      private String printFileName;
      
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
		  private void checkInsrP230005Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
	                //----------------------------------------------------
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
	                 
			   }
		  }
		  private void authExecEnabled() { 
			   //------------------
			   Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
               
               gwtAuthorization.formAuthFieldConfig(fldArrField);
               
               
              // srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	          //    srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	               
	         //     srhPayCd.setValue(lsPayCd.getAt(0));
	              
             /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              * 권한설정을 위한 콤보처리를 위한 메서드 시작 
              * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
              ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
              // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
              // GWTAuthorization.formAuthPopConfig(cpInsr4201, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
              // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			  // gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
             /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              * 권한설정을 위한 콤보처리를 위한 메서드 종료
              ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
             //  srhDeptCd.fireEvent(Events.Add); 
             //  srhDeptCd.getListView().fireEvent(Events.CheckChanged);      
           
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
			     authMapDef.put("srhPayYr",Boolean.FALSE);
  			     authMapDef.put("srhPayMonth",Boolean.FALSE);
  			     authMapDef.put("srhPayCd",Boolean.FALSE);
  			     
			     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
				 authMapDef.put("srhDeptCd",Boolean.FALSE);
				 //authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
				 
				 gwtExtAuth.setCheckMapDef(authMapDef);
		        
		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		        	  //권한 검색조건처리를 위해 추가된 부분 
					  mask("[화면로딩] 초기화 진행 중!");
	        	}
		        tmMask.scheduleRepeating(5000);
		        
		       // setPayr410002FormBinding();
		  }
		  
		  
//    	  private AuthAction authAction;
//    	  private int checkCntDef = 4;   //체크 값 갯수 
//    	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//    	  /**
//    	   * 권한설정 처리 체크 
//    	   * AuthAction 
//    	   */
//    	  private void checkInsrP230005Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//        	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//    		 
//    		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//    		   
//    		   
//	                  
//                    //----------------------------------------------------
//                    unmask(); 
//                    //MSFMainApp.unmaskMainPage();
//                     
//    		   }
//    	  }
             
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
	    private void setPayr410002FormBinding() {
	 	 
	    	//Window.alert("srhPayrMangDeptCd : "+srhPayrMangDeptCd);
	    	
	     //formBinding.addFieldBinding(new FieldBinding(payrMangDeptCd, "payrMangDeptCd"));
	     
	     //Window.alert("srhPayrMangDeptCd : "+srhPayrMangDeptCd);
	     
	     
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
 
	  //  private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
		   
	    private Insr2300ServiceAsync insr2300Service = Insr2300Service.Util.getInstance(); 
	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
  		
  		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  		
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		   
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
  	   //--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
  		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
  		private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
  		
  		private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
  		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
  		
  		private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
  		private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드 
  		
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
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
//		private void Payr4100Print(String fileName) {
	// 
//			// 출력물 디렉토리 패스경로 인사 : PSNL
//			String strDirPath = "PAYR";
//			// mrd 출력물
//			String rdaFileName = fileName+".mrd";
//			// 보낼 파라미터
//			
//			
//			//검색조건
//	 	String serarchParam = "";
////			
////			String name = searchName.getValue() == null ? "" : searchName.getValue();
////			String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////			String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////			//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////			String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////			String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////			String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////			
////			serarchParam += "["+name+"]";
////			serarchParam += "["+resn+"]";
////			serarchParam += "["+hdofcCodtnCd+"]";
////			serarchParam += "[]";
////			//serarchParam += "["+manageDeptCd+"]";
////			serarchParam += "["+deptCd+"]";
////			serarchParam += "["+emymtDivCd+"]";
////			serarchParam += "["+typOccuCd+"]";
//			
//			List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
//			String checkedSystemKeys = "";
//			if(list != null && list.size() > 0){
//				String chkkey = "";
//				for(BaseModel bm : list){
//					chkkey += "'"+bm.get("systemkey")+"',";
//				}
//				
//				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				
//			}
//			String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//			
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	//
//		}

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
 
	    @Override
	    protected void onRender(Element parent, int index) {
	      super.onRender(parent, index);
	      
	    }
	  
	  public InsrP230005(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
		  //콤보 권한초기화
		   initLoad(); 
		   // this.setFrame(false);
	       // this.setBodyBorder(false);
	        this.setBorders(false);
	       // this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		  
	        cpInsr4201 = new ContentPanel();
		    createInsrP410002Form();  //화면 기본정보를 설정
		    createBtnTop();
		    createSearchForm();    //검색필드를 적용 
		    createStandardForm();    //기본정보필드   
		   
		    
		    
		   
		   cpInsr4201.setBodyBorder(false);
		   cpInsr4201.setBorders(false);
		   cpInsr4201.setHeaderVisible(false);
		  //cpInsr4201.setSize("810px", "710px");  
		    
		    this.add(cpInsr4201);
		    formBinding = new FormBinding(this, true);
			this.setSize("996px", "640px");  //setSize("790px", "610px");  
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
	  private  void createInsrP410002Form() { 
		   
		  
//		  final NumberFormat currency = NumberFormat.getCurrencyFormat();   
//		    final NumberFormat number = NumberFormat.getFormat("0.00");   
//		    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);   
//		  
//		    change = new GridCellRenderer<Stock>() {   
//		      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//		          ListStore<Stock> store, Grid<Stock> grid) {   
//		        double val = (Double) model.get(property);   
//		        String style = val < 0 ? "red" : "green";   
//		        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";   
//		      }   
//		    };   
//		  
//		    gridNumber = new GridCellRenderer<Stock>() {   
//		      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//		          ListStore<Stock> store, Grid<Stock> grid) {   
//		        return numberRenderer.render(null, property, model.get(property));   
//		      }   
//		    };   
		 
		  cpInsr4201.setSize("976px", "640px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		     
		  	 soctyInsurCmptnDt01 = new HiddenField<String>();
		  	 soctyInsurCmptnDt01.setName("soctyInsurCmptnDt01");
	         cpInsr4201.add(soctyInsurCmptnDt01); 
	         
	         soctyInsurCmptnDt02 = new HiddenField<String>();
		  	 soctyInsurCmptnDt02.setName("soctyInsurCmptnDt02");
	         cpInsr4201.add(soctyInsurCmptnDt02); 
		  
	         hdofcCodtnCd = new HiddenField<String>();
	         hdofcCodtnCd.setName("hdofcCodtnCd");
	         cpInsr4201.add(hdofcCodtnCd);
	         
		     payrMangDeptCd = new HiddenField<String>();
	         payrMangDeptCd.setName("payrMangDeptCd");
	         cpInsr4201.add(payrMangDeptCd);
	         
	         hanNm = new HiddenField<String>();
	         hanNm.setName("hanNm");
	         cpInsr4201.add(hanNm);
	         
	         resnRegnNum = new HiddenField<String>();
	         resnRegnNum.setName("resnRegnNum");
	         cpInsr4201.add(resnRegnNum);
	         
	         secRegnNum = new HiddenField<String>();
	         secRegnNum.setName("secRegnNum");
	         cpInsr4201.add(secRegnNum);
		  
	         emymtDivCd = new HiddenField<String>();
	         emymtDivCd.setName("emymtDivCd");
	         cpInsr4201.add(emymtDivCd);
	         
	         deptCd = new HiddenField<String>();
	         deptCd.setName("deptCd");
	         cpInsr4201.add(deptCd);
	         
	         typOccuCd = new HiddenField<String>();
	         typOccuCd.setName("typOccuCd");
	         cpInsr4201.add(typOccuCd);
	         
	         dtilOccuInttnCd = new HiddenField<String>();
	         dtilOccuInttnCd.setName("dtilOccuInttnCd");
	         cpInsr4201.add(dtilOccuInttnCd);

	         businCd = new HiddenField<String>();
	         businCd.setName("businCd");
	         cpInsr4201.add(businCd);
	         
	         systemkey = new HiddenField<String>();
	         systemkey.setName("systemkey");
	         cpInsr4201.add(systemkey);
	         
	         socInsrLssEmymtNum = new HiddenField<String>();
	         socInsrLssEmymtNum.setName("socInsrLssEmymtNum");
	         cpInsr4201.add(socInsrLssEmymtNum);
	         
	         hdofcCodtnNm = new HiddenField<String>();
	         hdofcCodtnNm.setName("hdofcCodtnNm");
	         cpInsr4201.add(hdofcCodtnNm);
	         
	         payrMangDeptNm = new HiddenField<String>();
	         payrMangDeptNm.setName("payrMangDeptNm");
	         cpInsr4201.add(payrMangDeptNm);
	         
	         typOccuNm = new HiddenField<String>();
	         typOccuNm.setName("typOccuNm");
	         cpInsr4201.add(typOccuNm);

	         dtilOccuInttnNm = new HiddenField<String>();
	         dtilOccuInttnNm.setName("dtilOccuInttnNm");
	         
	         dpobCd = new HiddenField<String>();
	         dpobCd.setName("dpobCd");
	         cpInsr4201.add(dpobCd);
	         
	         deptNm = new HiddenField<String>();
	         deptNm.setName("deptNm");
	         cpInsr4201.add(deptNm);
	         
	         emymtDivNm = new HiddenField<String>();
	         emymtDivNm.setName("emymtDivNm");
	         cpInsr4201.add(emymtDivNm);
	         
	         deptCdAuth = new HiddenField<String>();
	         deptCdAuth.setName("deptCdAuth");
	         cpInsr4201.add(deptCdAuth);
	         
	         dtilOccuInttnCdAuth = new HiddenField<String>();
	         dtilOccuInttnCdAuth.setName("dtilOccuInttnCdAuth");
	         cpInsr4201.add(dtilOccuInttnCdAuth);
	         
	          repbtyBusinDivCd = new HiddenField<String>();  //시스템키 
	          repbtyBusinDivCd.setName("repbtyBusinDivCd");
	          cpInsr4201.add(repbtyBusinDivCd); 
	    	  
	    	  deptGpCd = new HiddenField<String>();  //시스템키 
	    	  deptGpCd.setName("deptGpCd");
	    	  cpInsr4201.add(deptGpCd); 
	    	  
	    	  
	    	  repbtyBusinDivNm = new HiddenField<String>();  //시스템키 
	    	  repbtyBusinDivNm.setName("repbtyBusinDivNm");
	          cpInsr4201.add(repbtyBusinDivNm); 
	    	  
	    	  deptGpNm = new HiddenField<String>();  //시스템키 
	    	  deptGpNm.setName("deptGpNm");
	    	  cpInsr4201.add(deptGpNm); 
	    	  
	    	  businNm = new HiddenField<String>();  //시스템키 
	    	  businNm.setName("businNm");
	    	  cpInsr4201.add(businNm); 
	    	  
	    	  
	        
	         cpInsr4201.add(dtilOccuInttnNm);
		    /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		     * 추가사항 
		     * 콤보박스 구분 전체/종료자/진행
		     * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		     */
		  //  srhPyspGrdeCd = new HiddenField<String>(); 
	         srhSystemkey = new HiddenField<String>();  //시스템키 

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
			 //월 
			 
			 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------

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
	          
	          sysComBass0300Dto.setRpsttvCd("A048");
	          lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
//		     		  ContentPanel typOccuCdGrid = new ContentPanel();  
//		     		  typOccuCdGrid.setVisible(false);
//		     		    
//		     		    //직종 콤보처리 
//		     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		     			       public void handleEvent(ComponentEvent be) {  
//		     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		     			        	  
//		     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//		     			        	mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//		     			          }  
//		     			        });  
//		     			       
//		     			      }  
//		     			    });  
//		     	  
//		     		 typOccuCdGrid.add(typOccuCdGridPanel); 
//		     		cpInsr4201.add(typOccuCdGrid);
		     	    
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
//		  		   ContentPanel payYrGrid = new ContentPanel();  
//		  		   payYrGrid.setVisible(false);
//		  		    
//		  		   //년도 콤보처리 
//		  		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//		  		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		  			       public void handleEvent(ComponentEvent be) {  
//		  			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		  			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		  			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//		  			        	 
//		  			        	//  Date today = new Date(); 
//		  			        	    // A custom date format
//		  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//		  			        	 
//		  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//		  			      	     // srhPayYr.setValue(bm);
//		  			        	srhPayYr.setValue(lsPayYrStore.getAt(0));
//		  			        	Date today = new Date(); 
//	                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//	                            srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//	                       
//		  			          }  
//		  			        });  
//		  			       
//		  			      }  
//		  			    });  
//		  	  
//		  		payYrGrid.add(payYrGridPanel); 
//		  		cpInsr4201.add(payYrGrid); 

		  
		    cpInsr4201.setLayout(new FlowLayout());
		    
		    srhSystemkey = new HiddenField<String>(); 
		      
		    LayoutContainer lcSchCol = new LayoutContainer();
		    lcSchCol.setLayout(new ColumnLayout());  
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("검색조건");  
		   
		   // fieldSet.setCheckboxToggle(false); 
		    
		    LayoutContainer lcSchLeft = new LayoutContainer();
		    lcSchLeft.setStyleAttribute("paddingRight", "10px");
		   
		 
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    
		    
		    lcSchLeft.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch);
		    

		    srhSoctyInsurCmptnDt01 = new DateField();
		    srhSoctyInsurCmptnDt01.setName("soctyInsurCmptnDt011");
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
		    srhSoctyInsurCmptnDt02.setName("srhSoctyInsurCmptnDt022");
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

	  /*          	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 *//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//* 
			                	checkInsrP230005Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	                	 }*/
			    	   
			    	   
	                
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
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkInsrP230005Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
		   // srhRepbtyBusinDivCd.setAllowBlank(false);
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

//		        	  EventType type = be.getType();
//		 	    	   if (type == Store.Add) { 
//		            		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		 	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//		 	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		 	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		 	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		 	    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//		            	 }  
		          
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
		        	//checkInsr2300Auth("srhHdofcCodtnCd",lsHdofcCodtnCd);  
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
			                	checkInsrP230005Auth("srhDeptCd", lsDeptCd); 
	                	 }
	             
	            }
	        });    
	 
	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	           @Override
	          public void handleEvent(ComponentEvent ce) { 
	                   
	                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                    	 
	                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                             
	                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));    
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
//	             BaseModel bmPayCd =  se.getSelectedItem(); 
//	             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//	                 if (bmPayCd != null) {  
//	                    
//	                     sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//	                     sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//	                 }      
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
//	             }  
	            
	            } 
	        });
		    //검색 소속부서 코드 처리  
//	        LayoutContainer lccmlcDeptNm = new LayoutContainer();
//	        lccmlcDeptNm.setLayout(new ColumnLayout());
//	           //부서 
//	        srhDeptCd = new TextField<String>();
//	        srhDeptCd.setName("srhDeptCd");
//	        srhDeptCd.setVisible(false);
//	        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//	            @Override
//	            public void handleEvent(BaseEvent be) { 
//	              if(srhDeptCd.getValue() != null){ 
//	                 
//	                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//	                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
//	                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//	                  
//	                    //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                      srhBusinCd.setStore(lsBusinCd); 
//	                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                          public void handleEvent(StoreEvent<BaseModel> be) {  
//	                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                          }
//	                      });    
//	                 
//	              } 
//	            }
//	         });
//	        cpInsr4201.add(srhDeptCd);
//	        srhMangeDeptCd = new TextField<String>();
//	        srhMangeDeptCd.setName("srhMangeDeptCd");
//	        srhMangeDeptCd.setVisible(false);
//	        cpInsr4201.add(srhMangeDeptCd);
//	        srhMangeDeptNm = new TextField<String>();
//	        srhMangeDeptNm.setName("srhMangeDeptNm");
//	        srhMangeDeptNm.setVisible(false);
//	        cpInsr4201.add(srhMangeDeptNm);
	//  
//	         LayoutContainer lcDeptNm = new LayoutContainer(); 
//	         frmlytSch = new FormLayout();
//	         frmlytSch.setLabelWidth(70);
//	         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//	         lcDeptNm.setLayout(frmlytSch);
//	      
//	         srhDeptNm = new TextField<String>();
//	         srhDeptNm.setName("srhDeptNm");
//	         srhDeptNm.setFieldLabel("부서");  
//	         srhDeptNm.addKeyListener(new KeyListener() {
//	              public void componentKeyUp(ComponentEvent event) {
//	                  super.componentKeyUp(event); 
//	                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                      if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                          srhDeptCd.setValue("");
//	                          srhMangeDeptCd.setValue("");
//	                      }
//	                      fnPopupCommP140(srhDeptNm.getValue());
//	                  }
//	              }
//	          });
//	         
//	         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	                    @Override
//	                    public void handleEvent(BaseEvent be) { 
//	                         
//	                        if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                            srhDeptCd.setValue("");
//	                            srhMangeDeptCd.setValue("");
//	                        }
//	                     
//	                    } 
//	           });        
//	          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//	          
//	           btnSrhDeptCd = new Button();
//	           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//	           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//	               public void handleEvent(ButtonEvent e) { 
//	                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                       srhDeptCd.setValue("");
//	                       srhMangeDeptCd.setValue("");
//	                   }
//	                   fnPopupCommP140(srhDeptNm.getValue()); 
//	               }
//	           });
//	            
//	           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//	           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	             
		    layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		    layoutContainer_2.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		   
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_10.setLayout(frmlytSch);
	        
//	        srhTypOccuCd =  new ComboBox<BaseModel>(); 
//	        srhTypOccuCd.setName("srhTypOccuCd");
//	        srhTypOccuCd.setForceSelection(true);
//	        srhTypOccuCd.setMinChars(1);
//	        srhTypOccuCd.setDisplayField("typOccuNm");
//	        srhTypOccuCd.setValueField("typOccuCd");
//	        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	        srhTypOccuCd.setEmptyText("--직종선택--");
//	        srhTypOccuCd.setSelectOnFocus(true); 
//	        srhTypOccuCd.setReadOnly(false);
//	        srhTypOccuCd.setEnabled(true); 
//	        srhTypOccuCd.setStore(lsTypOccuCd);
//	        srhTypOccuCd.setFieldLabel("직종");
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
	        //srhDeptGpCd.setAllowBlank(false);
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
	        layoutContainer_20.add(srhDeptGpCd, new FormData("100%")); 
	        
	        
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(1); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        frmlytSch.setDefaultWidth(0);
	        layoutContainer_21.setLayout(frmlytSch); 
	        
	        
//	        srhTypOccuCd = new ComboBox<BaseModel>(); 
//	        srhTypOccuCd.setName("srhTypOccuCd");
//	        srhTypOccuCd.setForceSelection(true);
//	        srhTypOccuCd.setMinChars(1);
//	        srhTypOccuCd.setDisplayField("typOccuNm");
//	        srhTypOccuCd.setValueField("typOccuCd");
//	        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	        srhTypOccuCd.setEmptyText("--직종선택--");
//	        srhTypOccuCd.setSelectOnFocus(true); 
//	        srhTypOccuCd.setReadOnly(false);
//	        srhTypOccuCd.setEnabled(true); 
//	        srhTypOccuCd.setStore(lsTypOccuCd); 
//	        srhTypOccuCd.setFieldLabel("직 종");  
//	        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                //직종변경에 따른 직종세 값 가져오기
//	                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//	                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//	                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//	                    sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//	                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//	                        LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//	                        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//	                    }
//	                }
//	            } 
//	        }); 
//	        lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
  
//	                
//	            }
//	        });    
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
			                	//checkInsrP230005Auth("srhTypOccuCd", lsTypOccuCd); 
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
//	        srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//	        srhDtilOccuInttnCd.setForceSelection(true);
//	        srhDtilOccuInttnCd.setMinChars(1);
//	        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//	        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//	        srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//	        srhDtilOccuInttnCd.setSelectOnFocus(true); 
//	        srhDtilOccuInttnCd.setReadOnly(false);
//	        srhDtilOccuInttnCd.setEnabled(true);  
//	        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//	      //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//	        srhDtilOccuInttnCd.setLabelSeparator("");
	       
	        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
	        srhDtilOccuInttnCd.setWidth(100);
	        srhDtilOccuInttnCd.setFieldLabel("");
	        srhDtilOccuInttnCd.setLabelSeparator("");
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
		    
//		    LayoutContainer layoutContainer_3 = new LayoutContainer();
//		    layoutContainer_3.setLayout(new ColumnLayout());
//		    
//		   
//		     
//		    fieldSet.add(layoutContainer_3);
//		    layoutContainer_3.setBorders(false);
		    
		    layoutContainer_13.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
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
/*	        srhHanNm.addKeyListener(new KeyListener() {
	            public void componentKeyUp(ComponentEvent event) {
	                super.componentKeyUp(event);
	                srhHanNm.validate();
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                    srhSystemkey.setValue("");
	                    srhResnRegnNum.setValue(""); 
	                    fnPopupPsnl0100() ;
	                }
	            }
	         });*/
/*	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
	            @Override
	            public void handleEvent(BaseEvent be) {  
	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
	                    srhSystemkey.setValue("");
	                    srhResnRegnNum.setValue("");
	                }
	             
	            } 
	       });*/ 
	        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	        layoutContainer_6.setBorders(false);
	        
	        Button btnHanNm = new Button("검색");
	        layoutContainer_5.add(btnHanNm);
	        btnHanNm.setEnabled(false);
/*	        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                srhSystemkey.setValue("");
	                srhResnRegnNum.setValue("");   
	              fnPopupPsnl0100() ;
	                  
	            }
	        });*/
	        
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
	     //   srhResnRegnNum.setFieldLabel("주민번호");
/*	        srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
	            @Override
	            public void handleEvent(BaseEvent be) {  
	                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
	                    srhSystemkey.setValue("");
	                    srhHanNm.setValue("");
	                }
	             
	            } 
	      }); */
	        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.41));
	        layoutContainer_7.setBorders(false); 
	        layoutContainer_5.setBorders(false);
		    
	        fieldSet.add(lcSchCol3);
		    lcSchCol3.setBorders(false);
		    
		    lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        
		    cpInsr4201.add(fieldSet); 
		 
	    //vp.add(panel);   
		    
//		    LayoutContainer lcSchCol = new LayoutContainer();
//		    lcSchCol.setLayout(new ColumnLayout()); 
//		    
//		    FieldSet fieldSet = new FieldSet();  
//		    fieldSet.setHeadingHtml("검색조건");  
//		    //fieldSet.setCheckboxToggle(false); 
//		    
//		    LayoutContainer lcSchLeft = new LayoutContainer();
//		    lcSchLeft.setStyleAttribute("paddingRight", "10px");
//		  
//		    LayoutContainer layoutContainer = new LayoutContainer();
//		    FormLayout frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//		    layoutContainer.setLayout(frmlytSch);
//		    layoutContainer.setBorders(false);
// 
//		    LayoutContainer layoutContainer_2 = new LayoutContainer();
//			layoutContainer_2.setLayout(new FlowLayout());
//			  
//			   
////			topPayr4200Bar = new ButtonBar();    
////			layoutContainer_2.add(topPayr4200Bar);
////			topPayr4200Bar.setAlignment(HorizontalAlignment.RIGHT);
////			 
////			  	
////		  	btnPayr4200Print = new Button("인쇄"); 
////		  	btnPayr4200Print.setIcon(MSFMainApp.ICONS.print16()); 
////		  	topPayr4200Bar.add(btnPayr4200Print); 
////		  	btnPayr4200Print.addListener(Events.Select, new Listener<ButtonEvent>() {
////	    		public void handleEvent(ButtonEvent e) {
////	    			//버튼 클릭시 처리 
////	    		//	Payr410002Print("PAYRT4203") ;
////	    		}
////	    	}); 
//			 
//			  	
//		    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		    layoutContainer_2.setBorders(false);  
//		    
//		    LayoutContainer layoutContainer_14 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//		    layoutContainer_14.setLayout(frmlytSch);
//		     
//		   
//		    layoutContainer_14.setBorders(false);
//		 
//		    fieldSet.add(lcSchCol, new FormData("100%"));  
//		    lcSchLeft.setLayout(new ColumnLayout());
//		    
//		    LayoutContainer layoutContainer_8 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_8.setLayout(frmlytSch);
//		    
//		    srhPayYr = new ComboBox<BaseModel>();
//		    srhPayYr.setName("srhPayYr");
//		    srhPayYr.setForceSelection(true);
//		    srhPayYr.setMinChars(1);
//		    srhPayYr.setDisplayField("payYrDisp");
//		    srhPayYr.setValueField("payYr");
//		    srhPayYr.setTriggerAction(TriggerAction.ALL);
//		   // srhPayYr.setEmptyText("--년도선택--");
//		    srhPayYr.setSelectOnFocus(true); 
//		    srhPayYr.setReadOnly(false);
//		    srhPayYr.setEnabled(true); 
//		    srhPayYr.setStore(lsPayYrStore);
//		    srhPayYr.setFieldLabel("지급년월"); 
//		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//		           BaseModel bmPayYr =  se.getSelectedItem(); 
//		           if (bmPayYr != null) {
//		                //조회 처리 호출 
//		        	  String payYr =  MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"); 
//		        	  if (MSFSharedUtils.paramNotNull(payYr)) {  
//		        			  reload(); 
//		        	  }
//		        	   
//		           }       
//		          } 
//		      });   
//		    layoutContainer_8.add(srhPayYr, new FormData("100%"));  
//		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//		    layoutContainer_8.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_9 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(0); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_9.setLayout(frmlytSch);
//		    
//  
//		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    layoutContainer_9.setBorders(false);
//		    
//		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
//		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 
			
		   // cpInsr4201.add(fieldSet); 
		   
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
	  
	  private  void createStandardForm() {
		  
		  LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset_2 = new FieldSet();
		//	fldstNewFieldset_2.setSize(528, 120);
			layoutContainer_2.add(fldstNewFieldset_2);
			fldstNewFieldset_2.setHeadingHtml("상실신고내역");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(createCheckBoxGrid(),new FormData("100%"));
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
			 
			    
			cpInsr4201.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   

	  private LayoutContainer createCheckBoxGrid() {    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		    FormLayout frmlytStd = new FormLayout();    
		    lcStdGrid.setLayout(frmlytStd);  
		    
			   ContentPanel cpGrid = new ContentPanel();   
			   cpGrid.setBodyBorder(false); 
			   cpGrid.setHeaderVisible(false);   
			   cpGrid.setLayout(new FitLayout());      
			   cpGrid.setSize(954, 490);  
			   
			   pInsr2200GridPanel = new MSFGridPanel(pInsr2200Def, false, false, false, false,false);
			   pInsr2200GridPanel.setHeaderVisible(false);  
			   pInsr2200GridPanel.setBodyBorder(true);
			   pInsr2200GridPanel.setBorders(true);
			   pInsr2200GridPanel.getBottomComponent().setVisible(false);
			   pInsr2200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("공통", 1, 7));
			   pInsr2200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("연금", 1, 3));
			   pInsr2200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 11, new HeaderGroupConfig("건강", 1, 8));
			   pInsr2200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 19, new HeaderGroupConfig("고용", 1, 4));
			   pInsr2200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 23, new HeaderGroupConfig("산재", 1, 4));
			   cpGrid.add(pInsr2200GridPanel); 			    
			   lcStdGrid.add(cpGrid);
			   return lcStdGrid;  
		  }   
	  
		  

			 private void createBtnTop() {
				 
				 
				  ButtonBar buttonBar = new ButtonBar();    
				  buttonBar.setAlignment(HorizontalAlignment.RIGHT);
			  	
				  Button topBtn = new Button("인쇄"); 
			  	topBtn.setIcon(MSFMainApp.ICONS.print16());
			  	buttonBar.add(topBtn); 
			  	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {			
						InsrP230005Print("INSRT230005", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
					}
				});
			  	
			  	
			  	
			  	
			  	topBtn = new Button("엑셀"); 
			  	topBtn.setIcon(MSFMainApp.ICONS.excel16());
			  	buttonBar.add(topBtn);  
			  	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {			
						excelFileExport();
					}
				});

			  	cpInsr4201.add(buttonBar);    
			  	
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
				private void InsrP230005Print(String fileName, String repType) {
					   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType.trim())) {
						   RdaPrint(fileName);
					   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType.trim())) {
						   RexPrint(fileName);
					   } else {
						   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
					   }
				    }	
				//rda
				private void RdaPrint(String fileName) {
					
				}
				
				//rex 
				private void RexPrint(String fileName) {
					
					
					printFileName = new String();
					printFileName = fileName;
					
					systemKeys = new String();
					systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
					
					
					if(payrMangDeptCd.getValue() != null && !payrMangDeptCd.getValue().equals("") && emymtDivCd.getValue() != null && !emymtDivCd.getValue().equals("")){
						if(emymtDivCd.getValue().equals("A0020010")){
						}else if(emymtDivCd.getValue().equals("A0020020")){
							if(deptCd.getValue() == null || deptCd.getValue().equals("")){
								Window.alert("부서를 선택해 주세요");
								return;
							}	
							if(businCd.getValue() == null || businCd.getValue().equals("")){	
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
					List<BaseModel> list = pInsr2200GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
									// TODO Auto-generated method stub
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
					baseModel.set("soctyInsurCmptnDt01", MSFSharedUtils.allowNulls(soctyInsurCmptnDt01.getValue()));
					baseModel.set("soctyInsurCmptnDt02", MSFSharedUtils.allowNulls(soctyInsurCmptnDt02.getValue()));
					baseModel.set("payrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));
					baseModel.set("emymtDivCd", MSFSharedUtils.allowNulls(emymtDivCd.getValue()));
					baseModel.set("deptCd", MSFSharedUtils.allowNulls(deptCd.getValue()));
					baseModel.set("typOccuCd", MSFSharedUtils.allowNulls(typOccuCd.getValue()));
					baseModel.set("dtilOccuInttnCd", MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue()));
					baseModel.set("businCd", MSFSharedUtils.allowNulls(businCd.getValue()));
					baseModel.set("systemkey", MSFSharedUtils.allowNulls(systemKeys));
					baseModel.set("hanNm", MSFSharedUtils.allowNulls(hanNm.getValue()));
					baseModel.set("resnRegnNum", MSFSharedUtils.allowNulls(resnRegnNum.getValue()));		   
					baseModel.set("hdofcCodtnCd", MSFSharedUtils.allowNulls(hdofcCodtnCd.getValue())); 
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

			    	if(soctyInsurCmptnDt01.getValue() != null && !"".equals(soctyInsurCmptnDt01.getValue())){

			    		String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
						if(MSFSharedUtils.paramNull(myImgUrl)) {
						// myImgUrl = "http://105.19.10.32:8080";
						//경로오류 출력 
						}							
				        
				        
				      
				        serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";
						serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt01.getValue())+"⊥";				//$1
						serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt02.getValue())+"⊥";				//$2
						serarchParam += ""+MSFSharedUtils.allowNulls(payrMangDeptCd.getValue())+"⊥";		//$3
						serarchParam += ""+MSFSharedUtils.allowNulls(emymtDivCd.getValue())+"⊥";		//$4
						serarchParam += ""+MSFSharedUtils.allowNulls(deptCd.getValue())+"⊥";				//$5
						serarchParam += ""+MSFSharedUtils.allowNulls(typOccuCd.getValue())+"⊥";			//$6
						serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue())+"⊥";			//$7
						serarchParam += ""+MSFSharedUtils.allowNulls(businCd.getValue())+"⊥";    //$8
						serarchParam += ""+MSFSharedUtils.allowNulls(systemKeys)+"⊥";	//$10
						serarchParam += ""+MSFSharedUtils.allowNulls(hanNm.getValue())+"⊥";		//$10
						serarchParam += ""+MSFSharedUtils.allowNulls(resnRegnNum.getValue())+"⊥";		//$10
						serarchParam += ""+MSFSharedUtils.allowNulls(hdofcCodtnCd.getValue())+"⊥";		//$10				 			        
						
						//20151212-변경추가 시작 
						serarchParam += ""+MSFMainApp.get().getUser().getUsrId()+"⊥";  //$14 //유우져 아이디 넘김 
						serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$15
									  
						//권한처리를위해 넘기는 변수 2개추가 
						serarchParam += ""+MSFSharedUtils.allowNulls(deptCdAuth.getValue())+"⊥"; //$16 부서 
						serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCdAuth.getValue())+"⊥"; //$17 직종세 
						serarchParam += ""+MSFSharedUtils.allowNulls(myImgUrl)+"⊥"; //$18
						//20151212-추가 끝 
						
						
						String strParam = "" + serarchParam ;
						
						//GWT 타입으로 팝업 호출시  postCall true 설정
						PrintUtils.setPostCall(true);
						PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
							
						}else{
							MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
						}
					
					
				}
				
			 
			public void reload() {
				// TODO Auto-generated method stub
				formInit(); 
				IColumnFilter filters = null;
//				payr0304GridPanel.getTableDef().setTableColumnFilters(filters); 
//				 
//				payr0304GridPanel.getTableDef().addColumnFilter("pymtYrMnth", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			 	payr0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			 
//				payr0304GridPanel.reload();
				
				
				 
				pInsr2200GridPanel.getTableDef().setTableColumnFilters(filters);			
				pInsr2200GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt01", soctyInsurCmptnDt01.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
				pInsr2200GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt02",  soctyInsurCmptnDt02.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 			
				pInsr2200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", payrMangDeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
				pInsr2200GridPanel.getTableDef().addColumnFilter("emymtDivCd", emymtDivCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	            //String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            pInsr2200GridPanel.getTableDef().addColumnFilter("deptCd", deptCd.getValue() , SimpleColumnFilter.OPERATOR_EQUALS);          
	            //String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	            pInsr2200GridPanel.getTableDef().addColumnFilter("typOccuCd", typOccuCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);              
	           // String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	            pInsr2200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", dtilOccuInttnCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	            pInsr2200GridPanel.getTableDef().addColumnFilter("businCd", businCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	            pInsr2200GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	            pInsr2200GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(hanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
	            pInsr2200GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(resnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
	            pInsr2200GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", hdofcCodtnCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	            pInsr2200GridPanel.getTableDef().addColumnFilter("dpobCd", dpobCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);   

	            pInsr2200GridPanel.reload();
				
				 
				actionDatabase = ActionDatabase.READ; 
			}
			
			
			//폼초기화 검색조건포함 
		   private void formInit() {
			     
			   subformInit(); 
			   
			 //  payr0304GridPanel.getMsfGrid().clearData();
			  
			   actionDatabase = ActionDatabase.READ;
			   
			   
		   }
		   
		   private void subformInit() { 
			      
			   //grid init 
//			   payr0302ExtpyGridPanel.getMsfGrid().clearData();
//			   payr0302DducGridPanel.getMsfGrid().clearData(); 
			     
		   }
	
	   @Override	
	   public void bind(final ModelData model) { 
		   formBinding.bind(model);
		   formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			   //@Override
			   public void handleEvent(BaseEvent be) {

				   //작성기간
				   srhSoctyInsurCmptnDt01.setValue(InsrUtils.getConvertStringToDate(soctyInsurCmptnDt01.getValue(), "yyyyMMdd"));   
				   srhSoctyInsurCmptnDt01.setEnabled(false);
				   srhSoctyInsurCmptnDt02.setValue(InsrUtils.getConvertStringToDate(soctyInsurCmptnDt02.getValue(), "yyyyMMdd"));
				   srhSoctyInsurCmptnDt02.setEnabled(false);
				   
				   //재직구분
				   srhHdofcCodtnCd.setValue(hdofcCodtnNm.getValue()); 
				   srhHdofcCodtnCd.setEnabled(false);

				
				   //단위기간			   
				   srhPayrMangDeptCd.setEmptyText(payrMangDeptNm.getValue());			   
				   //InsrUtils.setSelectedComboValue(srhPayrMangDeptCd, payrMangDeptCd.getValue(), "payrMangDeptCd");
				   srhPayrMangDeptCd.setEnabled(false);
				   
				   //성명
				   srhHanNm.setValue(hanNm.getValue());
				   srhHanNm.setReadOnly(true);
				   //주민번호
				   srhResnRegnNum.setValue(resnRegnNum.getValue()); //주민번호
				   srhResnRegnNum.setReadOnly(true);
				   
				   //고용구분
				   //InsrUtils.setSelectedComboValue(srhEmymtDivCd, emymtDivCd.getValue(), "commCd");
				   srhEmymtDivCd.setEmptyText(emymtDivNm.getValue());
				   srhEmymtDivCd.setEnabled(false);

				   srhRepbtyBusinDivCd.setEmptyText(repbtyBusinDivNm.getValue());
				   srhRepbtyBusinDivCd.setEnabled(false);
				   //부서
				   srhDeptCd.setValue(deptNm.getValue());				   
/*				   String deptCdStr = deptCd.getValue();
				   String deptNmStr = "";
				   if (MSFSharedUtils.paramNotNull(deptCd.getValue())) {
					   String[] ray = deptCdStr.substring(0, deptCdStr.length()).split(",");
					   for (int i=0; i<ray.length; i++){ 	    	        	  	    	        	   
						   for(int j = 0; j < srhDeptCd.getStore().getCount(); j++){
							   if( ray[i].equals(srhDeptCd.getStore().getAt(j).get("deptCd"))){		    						 
								   //srhDeptCd.getListView().setChecked(mDtalistDeptCd.get(j), true);			    						 
								   if(i == 0)	deptNmStr += mDtalistDeptCd.get(j).get("deptNmRtchnt").toString();
								   else 	deptNmStr += ","+mDtalistDeptCd.get(j).get("deptNmRtchnt").toString();		    		 		        
							   }
						   }	
					   } 
				   }
				   if(!"".equals(deptNmStr) && deptNmStr.length() > 0)	srhDeptCd.setValue(deptNmStr);*/
				   srhDeptCd.setEnabled(false);
	            	
				  
				   srhDeptGpCd.setEmptyText(deptGpNm.getValue());
				   srhDeptGpCd.setEnabled(false);
				   //직종
				   srhTypOccuCd.setValue(typOccuNm.getValue());
				   srhTypOccuCd.setEnabled(false);
				   
				   //직종세
				   srhDtilOccuInttnCd.setValue(dtilOccuInttnNm.getValue());
				   srhDtilOccuInttnCd.setEnabled(false);
	            	
	               //사업
				   //InsrUtils.setSelectedComboValue(srhBusinCd, businCd.getValue(), "businCd");
				  

				   
				   srhBusinCd.setEmptyText(businNm.getValue());
				   srhBusinCd.setEnabled(false);
				   
				   
				   
				  // Window.alert("dpobCd : "+MSFMainApp.get().getUser().getDpobCd());
	            
	               reload();	
	            	
/*	            	String deptCdStr = deptCd.getValue();
	            	String deptNmStr = "";
	 			   if (MSFSharedUtils.paramNotNull(deptCd.getValue())) {
	    	           String[] ray = deptCdStr.substring(0, deptCdStr.length()).split(",");
	    	           for (int i=0; i<ray.length; i++){ 	    	        	  	    	        	   
//	    	        		ModelData mdSelect = (ModelData) srhDeptCd.getStore().findModel("deptCd", ray[i]);
//	    	 	             if (MSFSharedUtils.paramNotNull(mdSelect)) {
//	    	 	            	srhDeptCd.getListView().setChecked(mdSelect, true); 
//	    	 	            	//srhDeptCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("deptNmRtchnt")));
//	    	 	            	
//	    	 	             }
		    	   			for(int j = 0; j < srhDeptCd.getStore().getCount(); j++){
		    					if( ray[i].equals(srhDeptCd.getStore().getAt(j).get("deptCd"))){		    						 
		    						 srhDeptCd.getListView().setChecked(mDtalistDeptCd.get(j), true);			    						 
		    						 if(i == 0)	deptNmStr += mDtalistDeptCd.get(j).get("deptNmRtchnt").toString();
		    						 else 	deptNmStr += ","+mDtalistDeptCd.get(j).get("deptNmRtchnt").toString();		    		 		        
		    					}
		    				}	
	    	           	} 
	 			   }
	 			  if(!"".equals(deptNmStr) && deptNmStr.length() > 0)	srhDeptCd.setValue(deptNmStr);*/
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
		   
		//엑셀 저장
		private void excelFileExport() {		                     
			HashMap<String, String> param = new HashMap<String, String>(); 
			
			
			systemKeys = new String();
			systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = pInsr2200GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
							// TODO Auto-generated method stub
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
			
			
			param.put("soctyInsurCmptnDt01",  soctyInsurCmptnDt01.getValue()); 
			param.put("soctyInsurCmptnDt02",  soctyInsurCmptnDt02.getValue()); 			
			param.put("payrMangDeptCd", payrMangDeptCd.getValue());		//단위기관
			param.put("emymtDivCd", emymtDivCd.getValue());
		    param.put("deptCd", deptCd.getValue());
		    
		    
		    if(null == typOccuCd.getValue())
		    	param.put("typOccuCd", "");
		    else
		    	param.put("typOccuCd", typOccuCd.getValue());
			
		    if(null == dtilOccuInttnCd.getValue())
		    	param.put("dtilOccuInttnCd", "");
		    else
		    	param.put("dtilOccuInttnCd", dtilOccuInttnCd.getValue());
		    
			
			param.put("businCd", businCd.getValue());
			param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
			param.put("hanNm", hanNm.getValue());
			param.put("resnRegnNum", resnRegnNum.getValue());    
			param.put("hdofcCodtnCd", hdofcCodtnCd.getValue()); 
		
			
			
		   pInsr2200GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2300Export.do","extgwtFrame" ,param);
		}
	  
	 

}
