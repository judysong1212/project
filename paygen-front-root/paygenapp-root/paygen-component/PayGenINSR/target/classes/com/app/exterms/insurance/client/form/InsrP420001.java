
package com.app.exterms.insurance.client.form;
  

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.form.defs.Insr3200Def;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.core.resources.client.model.Stock;
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
import com.extjs.gxt.ui.client.event.KeyListener;
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
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class InsrP420001   extends MSFFormPanel {  

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
 
	  private  ContentPanel cpInsr4201; 

	    //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
		   
		  private GridCellRenderer<Stock> gridNumber;   
		  private GridCellRenderer<Stock> change;
		 
		  
		  //건강보험
		  private Insr3200Def pInsr320001Def  = new Insr3200Def("INSRP420001");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	      private MSFGridPanel pInsr320001GridPanel;
		  
 
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
  private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
  
  private ComboBox<BaseModel> srhBusinCd;    //사업
  private TextField<String> srhHanNm;         //성명
  private TextField<String> srhResnRegnNum;   //주민번호 
  private HiddenField<String> srhSystemkey;   //시스템키
  
  /** column 지급공제구분코드 : pymtDducDivCd */
  private ComboBox<BaseModel> srhPymtDducDivCd;
  private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
  private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
  
  private List<ModelData> mDtalistHdofcCodtnCd ;
  private List<ModelData> mDtalistDeptCd ;
  private List<ModelData> mDtalistTypOccuCd ;
  private List<ModelData> mDtalistDtilOccuInttnCd ;
  
  private String systemKeys;
  private boolean mutilCombo = false;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */


      private HiddenField<String> dpobCd;  //사업장코드
      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */ 
      
      private HiddenField<String>  pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
      
      private HiddenField<String>  payCd ;  /** column 급여구분코드 : payCd */

      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */

      private HiddenField<Long> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
      
      private HiddenField<String> emymtDivCd;   /** column 주민등록번호 : resnRegnNum */

      private HiddenField<String> currAffnDeptCd ;  /** column 부서 : deptNm */

      private HiddenField<String> businCd;   /** column 사업코드 : businNm */

      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuNm */ 
       
      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
      
      
    //  private HiddenField<String>  pyspGrdeCd;  /**  column 고용구분 : emymtDivNm */
      
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
		  private void checkInsrP420001Auth( String authAction, ListStore<BaseModel> bm) {   
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
                 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
                  
                 gwtAuthorization.formAuthFieldConfig(fldArrField);
                 
                 
                 srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	              srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	               
	              srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
	              srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
	              
	             // srhPayCd.setValue(lsPayCd.getAt(0));
	              
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
			     authMapDef.put("srhPayYr",Boolean.FALSE);
  			     authMapDef.put("srhPayMonth",Boolean.FALSE);
  			    // authMapDef.put("srhPayCd",Boolean.FALSE);
  			     
  			   authMapDef.put("srhHdofcCodtnCd",Boolean.FALSE);
  			     
			     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
				 authMapDef.put("srhDeptCd",Boolean.FALSE);
				// authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
				 
				 gwtExtAuth.setCheckMapDef(authMapDef);
		        
		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		        	  //권한 검색조건처리를 위해 추가된 부분 
					  mask("[화면로딩] 초기화 진행 중!");
	        	}
		        tmMask.scheduleRepeating(5000);
		  }
		  
//    	  private AuthAction authAction;
//    	  private int checkCntDef = 4;   //체크 값 갯수 
//    	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//    	  /**
//    	   * 권한설정 처리 체크 
//    	   * AuthAction 
//    	   */
//    	  private void checkInsrP420001Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//        	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//    		 
//    		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//    		    
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
 
	  //  private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
		   
		 
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
  		
  		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
  		
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
	  
	  public InsrP420001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
		  
		  //콤보 권한초기화
		   initLoad(); 
		   // this.setFrame(false);
	       // this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	         
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
		  //  formBinding = new FormBinding(this, true);
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
//		  final NumberFormat number = NumberFormat.getFormat("0.00");   
//		  final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);   
//
//		  change = new GridCellRenderer<Stock>() {   
//			  public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//					  ListStore<Stock> store, Grid<Stock> grid) {   
//				  double val = (Double) model.get(property);   
//				  String style = val < 0 ? "red" : "green";   
//				  return "<span style='color:" + style + "'>" + number.format(val) + "</span>";   
//			  }   
//		  };   
//
//		  gridNumber = new GridCellRenderer<Stock>() {   
//			  public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//					  ListStore<Stock> store, Grid<Stock> grid) {   
//				  return numberRenderer.render(null, property, model.get(property));   
//			  }   
//		  };   

		  //멀티콤보박스 닫기 
		  cpInsr4201.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			  @Override
			  public void handleEvent(ComponentEvent ce) { 
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
			  } 
		  });


		  cpInsr4201.setSize("976px", "640px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		     
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
			 //sysComBass0300Dto.setRpsttvCd("B015");
			 //lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
			 //재직상태  
			 sysComBass0300Dto.setRpsttvCd("A003");
			 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
	              public void handleEvent(StoreEvent<BaseModel> be) {  
	                  mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
	                  srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
	                  
	              }
	          });   
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //고용구분
			 sysComBass0300Dto.setRpsttvCd("A002");
			 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			//--------------------급여년도 불러 오는 함수 ------------------------------------------------
	         lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
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
		    //lcSchCol.setStyleAttribute("background-color","red");
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
		    lcSchLeft.setStyleAttribute("paddingRight", "10px");
		   
		 
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    lcSchLeft.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch);
		    
		    srhPayYr = new ComboBox<BaseModel>();
		    srhPayYr.setName("srhPayYr");
		    srhPayYr.setForceSelection(true);
		    srhPayYr.setMinChars(1);
		    srhPayYr.setDisplayField("yearDisp");
		    srhPayYr.setValueField("year");
		    srhPayYr.setTriggerAction(TriggerAction.ALL);
		   // srhPayYr.setEmptyText("--년도선택--");
		    srhPayYr.setSelectOnFocus(true); 
		    srhPayYr.setReadOnly(false);
		    srhPayYr.setEnabled(true); 
		    srhPayYr.setStore(lsPayYrStore);
		    srhPayYr.setFieldLabel("작성년월"); 
		    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        public void handleEvent(StoreEvent<BaseModel> be) {  
		        	checkInsrP420001Auth("srhPayYr",lsPayYrStore);  
		          
		        }
		    });
		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		           BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		               
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
	                         
	                   } else {
	                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
	                      // return;
	                   } 
	   
		              
		           }       
		          } 
		      });   
		    layoutContainer_8.add(srhPayYr, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		    layoutContainer_8.setBorders(false);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_9.setLayout(frmlytSch);
		    
		    /** column 지급년월 : Mnth */ 
		    srhPayMonth = new ComboBox<BaseModel>();
		    srhPayMonth.setName("srhPayMonth");
		    srhPayMonth.setForceSelection(true);
		    srhPayMonth.setMinChars(1);
		    srhPayMonth.setDisplayField("monthDisp");
		    srhPayMonth.setValueField("month");
		    srhPayMonth.setTriggerAction(TriggerAction.ALL);
		   // srhPayMonth.setEmptyText("--월선택--");
		    srhPayMonth.setSelectOnFocus(true); 
		    srhPayMonth.setReadOnly(false);
		    srhPayMonth.setEnabled(true); 
		    srhPayMonth.setStore(lsPayMonth);
		    srhPayMonth.setHideLabel(true); 
		    srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        public void handleEvent(StoreEvent<BaseModel> be) {  
		        	checkInsrP420001Auth("srhPayMonth",lsPayMonth);  
		          
		        }
		    });
		    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
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
			                	checkInsrP420001Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
			                	checkInsrP420001Auth("srhEmymtDivCd", lsEmymtDivCd); 
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

//			       	  EventType type = be.getType();
//				    	   if (type == Store.Add) { 
//			           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//				    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//			           	 }  

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
	        
//	        srhPayCd =  new ComboBox<BaseModel>(); 
//	        srhPayCd.setName("srhPayCd");
//	        srhPayCd.setForceSelection(true);
//	        srhPayCd.setMinChars(1);
//	        srhPayCd.setDisplayField("commCdNm");
//	        srhPayCd.setValueField("commCd");
//	        srhPayCd.setTriggerAction(TriggerAction.ALL);
//	        srhPayCd.setEmptyText("--급여구분선택--");
//	        srhPayCd.setSelectOnFocus(true); 
//	        srhPayCd.setReadOnly(false);
//	        srhPayCd.setEnabled(true); 
//	        srhPayCd.setStore(lsPayCd);
//	        srhPayCd.setFieldLabel("급여구분");
//	        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//	 
//	            	checkInsrP420001Auth("srhPayCd",lsPayCd);   
//	            }
//	        });    
	        srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
	        srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
//	        srhHdofcCodtnCd.setForceSelection(true);
//	        srhHdofcCodtnCd.setMinChars(1);
//	        srhHdofcCodtnCd.setDisplayField("commCdNm");
//	        srhHdofcCodtnCd.setValueField("commCd");
	       // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
	        srhHdofcCodtnCd.setEmptyText("--재직선택--");
//	        srhHdofcCodtnCd.setSelectOnFocus(true); 
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
	            	checkInsrP420001Auth("srhHdofcCodtnCd", lsHdofcCodtnCd); 
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
			                	checkInsrP420001Auth("srhDeptCd", lsDeptCd); 
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
	        frmlytSch.setLabelWidth(70); 
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
			                	//checkInsrP420001Auth("srhTypOccuCd", lsTypOccuCd); 
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
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                    srhSystemkey.setValue("");
//	                    srhResnRegnNum.setValue("");
//	                }
//	             
//	            } 
//	       }); 
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
			fldstNewFieldset_2.setHeadingHtml("월별변동내역");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(createCheckBoxGrid(),new FormData("100%"));
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
			 
			    
			cpInsr4201.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   

	  private LayoutContainer createCheckBoxGrid() {    
	  	   
//		    List<Stock> stocks = null;//TestData.getStocks();   
//		    
//		    RowNumberer r = new RowNumberer();   
//
//		    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
//		    configs.add(r);   
//
//		    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
//		    // selection model supports the SIMPLE selection mode   
//		    // sm.setSelectionMode(SelectionMode.SIMPLE);   
//		  
//		    configs.add(sm.getColumn());   
//		  
//		    ColumnConfig column = new ColumnConfig();   
//		    column.setId("name");   
//		    column.setHeaderText("납부년월");  
//		    column.setAlignment(HorizontalAlignment.CENTER); 
//		    column.setWidth(100);   
//		    configs.add(column);   
//		  
//
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("부서");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig();   
//		    column.setId("symbol");   
//		    column.setHeaderText("성명");  
//		    column.setAlignment(HorizontalAlignment.CENTER); 
//		    column.setWidth(100);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("주민등록번호");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("보수월액");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		    
//		    /*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//		     * 그리드헤더에 건강보험/장기요양보험  추가 할것. 
//		     * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//		     */
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("납부년월금액");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    
//		    column = new ColumnConfig("change", "납부전월금액", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		    
//
//		    column = new ColumnConfig("change", "변동금액", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		  
//		  
//            //장기요양보험
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("납부년월금액");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    
//		    column = new ColumnConfig("change", "납부전월금액", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		    
//
//		    column = new ColumnConfig("change", "변동금액", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		  
//		    
//		    ListStore<Stock> store = new ListStore<Stock>();   
//		    store.add(stocks);   
//		  
//		    ColumnModel cm = new ColumnModel(configs);    
//		    
//		    ContentPanel cp = new ContentPanel();   
//		    cp.setHeaderVisible(false);
//		    cp.setFrame(true);   
//		   // cp.setIcon(Resources.ICONS.table());   
//		    cp.setLayout(new FitLayout());   
//		    cp.setSize(800, 300);   
//		  
//		    Grid<Stock> grid = new Grid<Stock>(store, cm);   
//		    grid.setSelectionModel(sm);   
//		    grid.setBorders(true);   
//		    grid.setColumnReordering(true);   
//		    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
//		    grid.addPlugin(sm);   
//		      
//		  
//		  
//		    LayoutContainer lcStdGrid = new LayoutContainer();
//		    lcStdGrid.setStyleAttribute("paddingRight", "10px");
//		    FormLayout frmlytStd = new FormLayout();  
//		  //  frmlytStd.setLabelWidth(85); 
//		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
//		    lcStdGrid.setLayout(frmlytStd);  
//		    
//		    ContentPanel cpGrid = new ContentPanel();   
//		    cpGrid.setBodyBorder(false); 
//		    cpGrid.setHeaderVisible(false);   
//		    cpGrid.setLayout(new FitLayout());      
//		    cpGrid.setSize(864, 140);   
		    
	 
		    
		    

		    LayoutContainer lcStdGrid = new LayoutContainer();
		    lcStdGrid.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  

		    lcStdGrid.setLayout(frmlytStd);  

		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(954, 478);   

		    pInsr320001GridPanel = new MSFGridPanel(pInsr320001Def, false, false, false, false,false);
		    pInsr320001GridPanel.setHeaderVisible(false);  
		    pInsr320001GridPanel.setBodyBorder(true);
		    pInsr320001GridPanel.setBorders(true);
		    
		    //pInsr320001GridPanel.getGrid().getColumnModel().addAggregationRow(insr4100SummaryRow);  
		    pInsr320001GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 5,  new HeaderGroupConfig("건강보험",		1, 3));
		    pInsr320001GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("장기요양보험",	1, 3));
		     
		    cpGrid.add(pInsr320001GridPanel); 
		    lcStdGrid.add(cpGrid);   
		    
		    
		 
		    return lcStdGrid;
		     
		  }   
	  
		  

			 private void createBtnTop() {
				 
				 
				  ButtonBar buttonBar = new ButtonBar();    
				  buttonBar.setAlignment(HorizontalAlignment.RIGHT);
//			      buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//			        public void componentSelected(ButtonEvent ce) {   
//			         
//			        }   
//			      }));   
//			      buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//			        public void componentSelected(ButtonEvent ce) {   
//			           
//			        }   
//			      }));    
			 
				  	
//					Button topBtn1 = new Button("신규"); 
//				  	topBtn1.setIcon(Resources.APP_ICONS.new16());
//				  	buttonBar.add(topBtn1);
//				  
//				  	Button topBtn = new Button("저장"); 
//				  	topBtn.setIcon(Resources.APP_ICONS.save16());
//				  	buttonBar.add(topBtn);
//				  	
//				  	Button topBtn2 = new Button("삭제"); 
//				  	topBtn2.setIcon(Resources.APP_ICONS.delete16());
//				  	buttonBar.add(topBtn2);
				  

				
			 	Button topBtn4 = new Button("조회"); 
			  	topBtn4.setIcon(Resources.APP_ICONS.search16());
			  	buttonBar.add(topBtn4);
			  	
			  	topBtn4.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    			//조회버튼 클릭시 처리 
			    		    reload();  
			    		}
			    	});
			  	
			  	
			  	
			  	Button topBtn = new Button("인쇄"); 
			  	topBtn.setIcon(Resources.APP_ICONS.print16()); 
			  	buttonBar.add(topBtn); 
			  	
			  	topBtn = new Button("엑셀"); 
			  	topBtn.setIcon(Resources.APP_ICONS.excel16()); 
			  	buttonBar.add(topBtn);    
			  	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
						public void handleEvent(ButtonEvent e) {
							//엑셀저장  
							xlsExportData();
						}
					});
			  	
			  	cpInsr4201.add(buttonBar);    
			  	
			 } 
		    
			 private void xlsExportData() {

				 systemKeys = new String();
				 systemKeys = MSFSharedUtils.allowNulls(srhSystemkey.getValue());

				 //그리드 선택 데이터 출력
				 String checkedSystemKeys = "";
				 int keyCnt = 0;
				 List<BaseModel> list = pInsr320001GridPanel.getGrid().getSelectionModel().getSelectedItems();

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

				 HashMap<String, String> param = new HashMap<String, String>(); 

				 String year = InsrUtils.getSelectedComboValue(srhPayYr,"year");
				 String month = InsrUtils.getSelectedComboValue(srhPayMonth,"month");


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

				 param.put("pymtYrMnth", year.concat(month));
		         //param.put("pymtYr", year);
				 param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				 param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
				 param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
				 param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
				 // param.put("pyspGrdeCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
				 param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
				 param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				 param.put("hdofcCodtnCd", strHdofcCodtnCd);
				 param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
				 param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
				 param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 



				 if("".equals(year) || "".equals(month)){
					 MessageBox.info("", "납부년월은 필수 입니다.", null);
					 //	                      } else if("".equals(payCd)){
					 //	                          MessageBox.info("", "급여구분은 필수 입니다.", null);
					 //	                      }else if("".equals(workDayS) || "".equals(workDayE)){
					 //	                          MessageBox.info("", "근태기간은 필수 입니다.", null);
					 //	                          
					 //	                      } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
					 //	                    	  
					 //	                    	  if("".equals(businCd)){ 
					 //	                     			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					 //	              	                         "사업명을 선택하십시요.", null);
					 //	                       		 
					 //	               		     } else { 
					 //	                         
					 //	                          pInsr5100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr3100TempExport.do","extgwtFrame" ,param);   
					 //	               		     }
				 }else{  
					 pInsr320001GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsrP420001Export.do","extgwtFrame" ,param);  
					 
				 }  
			 }	
			 
			 
		   
			public void reload() {
		
				formInit(); 
				IColumnFilter filters = null;
				
				

				String strDeptCd		  = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,			 srhDeptCd.getValue(),			"deptNmRtchnt",	 "deptCd");
				String strTypOccuCd		  = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,		 srhTypOccuCd.getValue(),		"typOccuNm",	 "typOccuCd");
				String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm", "dtilOccuInttnCd");
				String strHdofcCodtnCd	  = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
				
				pInsr320001GridPanel.getTableDef().setTableColumnFilters(filters);
				
				pInsr320001GridPanel.getTableDef().addColumnFilter(   "pymtYrMnth"
																,  (MSFSharedUtils.getSelectedComboValue(srhPayYr,   "year")
																  + MSFSharedUtils.getSelectedComboValue(srhPayMonth, "month")
																   )
																,  SimpleColumnFilter.OPERATOR_EQUALS
															   );
				pInsr320001GridPanel.getTableDef().addColumnFilter(  "payrMangDeptCd"
																, MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd")
																, SimpleColumnFilter.OPERATOR_EQUALS
															   );
				pInsr320001GridPanel.getTableDef().addColumnFilter(  "emymtDivCd"
																, MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")
																, SimpleColumnFilter.OPERATOR_EQUALS
															   ); 
				pInsr320001GridPanel.getTableDef().addColumnFilter("deptCd",		   strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
				pInsr320001GridPanel.getTableDef().addColumnFilter("typOccuCd",	   strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
				pInsr320001GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
				pInsr320001GridPanel.getTableDef().addColumnFilter(  "businCd"
																, MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd")
																, SimpleColumnFilter.OPERATOR_EQUALS
															   ); 
				pInsr320001GridPanel.getTableDef().addColumnFilter(  "systemkey"
																, MSFSharedUtils.allowNulls(srhSystemkey.getRawValue())
																, SimpleColumnFilter.OPERATOR_EQUALS
															   ); 
				pInsr320001GridPanel.getTableDef().addColumnFilter(  "hanNm"
																, MSFSharedUtils.allowNulls(srhHanNm.getRawValue())
																, SimpleColumnFilter.OPERATOR_EQUALS
															   );    
				pInsr320001GridPanel.getTableDef().addColumnFilter(  "resnRegnNum"
																, MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue())
																, SimpleColumnFilter.OPERATOR_EQUALS
															   );  
				
				if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
					String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
					String chkkey = "";
					for(int i = 0; i < ray.length; i++) {
						BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
						chkkey += bmData.get("commCd") + ",";
					}
					strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
				}
				pInsr320001GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS);

			   pInsr320001GridPanel.reload();
				
				
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
		   
	  
	 

}
