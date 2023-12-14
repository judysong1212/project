package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.exterms.payroll.client.dto.Payr0415DTO;
import com.app.exterms.payroll.client.form.defs.Payr0410Def;
import com.app.exterms.payroll.client.form.defs.Payr0415Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0415PayYr;
import com.app.exterms.payroll.client.service.Payr1500Service;
import com.app.exterms.payroll.client.service.Payr1500ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
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
import com.extjs.gxt.ui.client.event.FieldEvent;
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
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
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
import com.google.gwt.core.client.GWT;
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
public class Payr1500  extends MSFPanel { 
 
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
	  private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
	 
	  private VerticalPanel vp;
	  private FormPanel plFrmPayr1500;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	 
	 
	  private Payr0415Def payr0415Def  = new Payr0415Def("");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0415GridPanel;
	  
	  
	  private Payr0410Def payr0410Def  = new Payr0410Def("");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0410GridPanel;

      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
      
      private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();  
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
      private ButtonBar topPayr1500Bar;
      private Button btnPayr1500Init;
      private Button btnPayr1500Print;
      private Button btnPayr1500Del;
      private Button btnPayr1500Sreach;
      private Button btnPayr1500ExcelFile;
      
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
        private ComboBox<BaseModel> srhPayYr;		/** column 급여년도 : payYr */
        private ComboBox<BaseModel> srhTypOccuCd; 	/** column 직종코드 : typOccuCd */
        private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; /** column 직종세코드 : dtilOccuInttnCd */  
        private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
        private ComboBox<BaseModel> srhPayrMangDeptCd; 	//단위기관
        
        private List<ModelData> mDtalistDtilOccuInttnCd ;
        private boolean mutilCombo = false;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ComboBox<BaseModel> createPayYr;	/** column 급여년도 : payYr */  
     // private ComboBox<BaseModel> createTypOccuCd ;  /** column 직종코드 : typOccuCd */
     // private ComboBox<BaseModel> createDtilOccuInttnCd;   /** column 직종세코드 : dtilOccuInttnCd */
        
      private HiddenField<String> dpobCd;  //사업장코드 
      //
      private HiddenField<String> typOccuCd;   	/** column 직종코드 : typOccuCd */
      private TextField<String> typOccuNm;   	/** column 직종코드 : typOccuCd */
  
      private HiddenField<String> dtilOccuInttnCd;	/** column 직종세코드 : dtilOccuInttnCd */
      private TextField<String> dtilOccuClsDivNm;   /** column 직종세코드 : dtilOccuInttnCd */
 
    //  private HiddenField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
   //   private TextField<String> pyspGrdeNm;   /** column 호봉등급코드 : pyspGrdeCd */
   
      private TextField<String> payYr;   /** column 급여년도 : payYr */ 
      
      private HiddenField<Long> typOccuGrdeMppgSeilNum;   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
      private HiddenField<Long> payrItemSeilNum;   /** column 급여항목일련번호 : payrItemSeilNum */
      
      private TextField<String> payrImcd ;  /** column 급여항목코드 : payrImcd */
      private TextField<String> itemNm;   /** column 항목명 : itemNm */ 
      private ComboBox<BaseModel> payCd;   /** column 급여구분코드 : payCd */ 
      private ComboBox<BaseModel> dayMnthAmntDivCd;   /** column 일월액구분코드 : dayMnthAmntDivCd */
      private CheckBox usalyAmntYn;   /** column 통상임금여부 : usalyAmntYn */
      private CheckBox payItemUseYn;   /** column 급여항목사용여부 : payItemUseYn */
      private ComboBox<BaseModel> pymtDducDivCd ;  /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> pymtDducFrmCd;   /** column 지급공제유형코드 : pymtDducFrmCd */
      private NumberField pymtDducSum;   /** column 지급공제액 : pymtDducSum */
      private NumberField pymtDducRate;   /** column 지급공제율 : pymtDducRate */
      private ComboBox<BaseModel> calcStdDivCd;   /** column 계산기준구분코드 : calcStdDivCd */
      private ComboBox<BaseModel> txtnDivCd;   /** column 과세구분코드 : txtnDivCd */
      private NumberField freeDtySum;   /** column 비과세금액 : freeDtySum */
      private NumberField freeDtyRate ;  /** column 비과세율 : freeDtyRate */

      private HiddenField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
      private CheckBox jan;   /** column 1월 : jan */
      private CheckBox feb;   /** column 2월 : feb */
      private CheckBox mar;   /** column 3월 : mar */
      private CheckBox apr;   /** column 4월 : apr */
      private CheckBox may;   /** column 5월 : may */
	  private CheckBox jun;   /** column 6월 : jun */
	  private CheckBox jul;   /** column 7월 : jul */
	  private CheckBox aug;   /** column 8월 : aug */
	  private CheckBox sep ;  /** column 9월 : sep */
	  private CheckBox oct;   /** column 10월 : oct */
	  private CheckBox nov;   /** column 11월 : nov */
	  private CheckBox dec;   /** column 12월 : dec */
	  private CheckBox chkAll;   		/** column 전체체크 : chkAll */
	  private NumberField rngeOrd ;  	/** column 정렬순서 : rngeOrd */
	  private DateField itemApptnBgnnDt ;  /** column 항목적용시작일자 : itemApptnBgnnDt */
	  private DateField itemApptnEndDt;   /** column 항목적용종료일자 : itemApptnEndDt */
      private TextField<String> payItemNoteCtnt;   /** column 급여항목비고내용 : payItemNoteCtnt */
         
      private ComboBox<BaseModel> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
 
      private TextField<String> calcStdFunc;   /** column 계산수식내용 : calcStdFunc */
      private BaseModel ppRecord; //팝업에 넘길 레코드 값   
      
      private ComboBox<BaseModel> srhPayCd;          //급여구분
      private ComboBox<BaseModel> srhType;          //급여구분
      
      
      private boolean searchYn;
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
			  private void checkPayr1500Auth( String authAction, ListStore<BaseModel> bm) {   
		    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
				 
				//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
				   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
				   
					   if (!maskTracker) { unmask(); }  
					   authExecEnabled() ;
		                 
					   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
				   }
			  }
				 private void authExecEnabled() { 
					   //------------------
					   //----------------------------------------------------
					   Field<?>[] fldArrField = {srhPayrMangDeptCd, srhTypOccuCd, payrMangDeptCd};
					   
					   gwtAuthorization.formAuthFieldConfig(fldArrField);
					  
		                //MSFMainApp.unmaskMainPage();
					 //  srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
					  
					   Date today = new Date(); 
                     // A custom date format
                     DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
                     createPayYr.setValue(lscrPayYr.findModel("year", fmt.format(today))); 
                   
					  // payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd() ));  
					   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					  // gwtAuthorization.formAuthConfig(plFrmPayr1500, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
	                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                    
	                      /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					  // gwtAuthorization.formAuthConfig(plFrmPayr1500, "payrMangDeptCd","","","","");
	                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		             
		                  
					 }
			   final Timer tmMask = new Timer()
			     {
			           public void run()
			           {
			              // if (maskTracker)
			              // { 
			        	   if (lsPayYrStore.getCount() > 0 ) {
			        		   
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
				     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
				     authMapDef.put("createPayYr",Boolean.FALSE); 
				 
					 //authMapDef.put("MangeDeptCd",Boolean.FALSE); 
					 
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
       //검색 폼 바인딩 처리 함수  
	   //화면 폼 바인딩 처리 
	    private void setPayr1500FormBinding() {
	 	 
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
	private Payr1500ServiceAsync payr1500Service = Payr1500Service.Util.getInstance();	    
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();
	//공통 코드 
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();
	private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>();
	
	private ListStore<BaseModel>  lscrTypOccuCd = new ListStore<BaseModel>();
	private ListStore<BaseModel>  lscrDtilOccuInttnCd = new ListStore<BaseModel>();
	private ListStore<BaseModel>  lscrPayYr = new ListStore<BaseModel>();
	 
	
    private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
	private ListStore<BaseModel>  lsGdPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
	    
	private ListStore<BaseModel>  lsPymtDducFrmCd = new ListStore<BaseModel>();  /** column 지급공제유형코드 : pymtDducFrmCd */
	private ListStore<BaseModel>  lsTxtnDivCd = new ListStore<BaseModel>(); /** column 과세구분코드 : txtnDivCd */
	private ListStore<BaseModel>  lsDayMnthAmntDivCd = new ListStore<BaseModel>(); /** column 일월액구분코드 : dayMnthAmntDivCd */
	private ListStore<BaseModel>  lsCalcStdDivCd = new ListStore<BaseModel>(); /** column 계산기준구분코드 : calcStdDivCd */
	     
	private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관     
	    
	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0350DTO sysComBass0350Dto;  
	private SysCoCalendarDTO  msfCoCalendarDto;  
	private PrgmComBass0150DTO sysComBass0150Dto;  
	 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
   
	private BaseModel record;
	
	private BaseModel detailRecord;
	
	private List<BaseModel> records;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr1500(){
//    	payr0400GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr1500List(bass0200Dto, new AsyncCallback<List<Payr1500BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr1500(): "+caught), null);
//                msfPayr1500GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr1500BM> result) {
//            	composedPayr1500List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr1500List(List<Payr1500BM> listaMenu) {
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
//        msfPayr1500GridPanel.unmask();  
//    }
     

	   /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
     private SelectionListener<ButtonEvent> selectionListener = 
                new SelectionListener<ButtonEvent>() {
                 public void componentSelected(ButtonEvent ce) { 
//                     if (ce.getButton() == btnPayr1500Save) {
//                         if (ActionDatabase.INSERT.equals(actionDatabase)) { 
//                                 doAction(ActionDatabase.INSERT);
//                         } else if (ActionDatabase.UPDATE.equals(actionDatabase) ){ 
//                                 doAction(ActionDatabase.UPDATE);
//                         }
//                     } else
                     if (ce.getButton() == btnPayr1500Del) {
                    	 
                    	 	if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
    	                	 
                    	 		MessageBox.alert("오류", "마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
                    	 		return; 
    	                     
    	                   }
                    	 
                    	 
                    	 	MessageBox.confirm("경고", "지급공제항목을 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
                    	 		@Override
                    			public void handleEvent(MessageBoxEvent be) {
                    	 		//	if("Yes".equals(be.getButtonClicked().getText())){
                    	 			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                    				}
                    			}
                    		});
                     	}
                 }  
            };
      
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
            doInsert();
            break;
        case UPDATE:
            this.actionDatabase = ActionDatabase.UPDATE;
            save();
            break;
        case DELETE:
            this.actionDatabase = ActionDatabase.DELETE;
            save();     
            break;
        }
    }
    
    
    /**
     * 지급공제항목저장
     */
    public void payr0410Save() {
//      if (isValid()) {
              
      
        Payr0410DTO payr0410Dto = new Payr0410DTO();
        
        payr0410Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));
        payr0410Dto.setTypOccuGrdeMppgSeilNum(Long.parseLong(MSFSharedUtils.allowNulls(record.get("typOccuGrdeMppgSeilNum"))));  
        payr0410Dto.setPayYr(payYr.getValue());
        payr0410Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd"))) ;
        payr0410Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd"))) ;
        payr0410Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd")));  
         
        /** EMYMT_DIV_CD 고용구분코드*/
        payr0410Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01); 
        /** PAY_CD */
        payr0410Dto.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd")); 
       
        /** PYMT_DDUC_FRM_CD */
        payr0410Dto.setPymtDducFrmCd(""); 
        /** TXTN_DIV_CD */
        payr0410Dto.setTxtnDivCd(""); 
        
        /** ITEM_APPTN_BGNN_DT */
        payr0410Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(new Date(),"yyyyMMdd"));
        
        /** ITEM_APPTN_END_DT */
        payr0410Dto.setItemApptnEndDt("99991231");
        
        /** DAY_MNTH_AMNT_DIV_CD */
        payr0410Dto.setDayMnthAmntDivCd("");
        
        /** CALC_STD_DIV_CD */
        payr0410Dto.setCalcStdDivCd("");
    
        /** PAY_ITEM_NOTE_CTNT */
        payr0410Dto.setPayItemNoteCtnt(payItemNoteCtnt.getValue());
        
        payr0410Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getMangeDeptCd()); 
        payr0410Dto.setCalcStdFunc(""); 

        
        payr1500Service.activityOnPayr0410Insert(payr0410Dto,records, 
                                  actionDatabase,
                                  new AsyncCallback<Long>() {
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Insert(" + actionDatabase.name() + ") : " + caught), null);
              }
              public void onSuccess(Long result) { 
                  if (result == 0) {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                              actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                  } else {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                              actionDatabase + "처리가 완료되었습니다.", null);
//                      reload();
                      payr0410_reload();
                  } 
              } 
          });
     // }
    }   
    
    /**
     * 급여항목마스터 생성저장
     */
    public void doInsert() {
//      if (isValid()) {
        
        Payr0415DTO payr0415Dto = new Payr0415DTO();  
        
        if (MSFSharedUtils.paramNull(createPayYr.getValue())) {
            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "생성할 년도를 선택하십시요.", null);
            return;
        }
       
        payr0415Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
        payr0415Dto.setPayYr(MSFSharedUtils.allowNulls(createPayYr.getValue().get("year")));
        
        payr1500Service.activityOnPayr0415Insert(payr0415Dto,records, 
                                  actionDatabase,
                                  new AsyncCallback<Long>() {
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Insert(" + actionDatabase.name() + ") : " + caught), null);
              }
              public void onSuccess(Long result) { 
                  if (result == 0) {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                              actionDatabase.name() + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                  } else {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                              actionDatabase.name() + "처리가 완료되었습니다.", null);
                      reload();
                  } 
              } 
          });
     // }
    }   
    
    
    public void save() {
//    if (isValid()) {
          
        Payr0415DTO payr0415Dto = new Payr0415DTO(); 
       
        if (MSFSharedUtils.paramNull(record)) {
            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "선택된 데이터가 없습니다.", null);
            return;
        }
         
        payr0415Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));
        payr0415Dto.setPayYr(MSFSharedUtils.allowNulls(record.get("payYr")));
        payr0415Dto.setTypOccuGrdeMppgSeilNum(Long.parseLong(MSFSharedUtils.allowNulls(record.get("typOccuGrdeMppgSeilNum")))); 
        payr0415Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd"))) ;
        payr0415Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd"))) ;
       // payr0415Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd"))); 
           
        payr1500Service.activityOnPayr0415Save(payr0415Dto, 
                                actionDatabase,
                                new AsyncCallback<Long>() {
            public void onFailure(Throwable caught) {
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Save(" + actionDatabase.name()   + ") : " + caught), null);
            }
            public void onSuccess(Long result) { 
               if (result == 0) {
                   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                           actionDatabase.name() + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
               } else {
                   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                           actionDatabase.name() + "처리가 완료되었습니다.", null);
                   formSubInit(); 
                   formSubDetilInit();
                   reload();
               } 
            } 
        });
   // }
  } 
   
    /**
     * form detail info data update 
     */
    public void detailFormSave() {
//      if (isValid()) {
            
    	if (MSFSharedUtils.paramNull(detailRecord)) {
    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "선택된 데이터가 없습니다.", null);
            return;
        }
        
        if (this.actionDatabase.equals(ActionDatabase.UPDATE) ) {
        	/** column 급여항목코드 : payItemCd */    
            if (MSFSharedUtils.paramNull(payrImcd.getValue())) {
            	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "급여항목이 존재하지 않습니다.", null);
            	return;
            } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(payCd,"commCd"))) {
                /** column 급여구분코드 : payCd */ 
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "급여구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd,"commCd"))) {
                /** column 지급공제구분코드 : pymtDducDivCd */  
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "지급공제구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd,"commCd"))) {
                /** column 지급공제유형코드 : pymtDducFrmCd */
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "지급공제유형은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(txtnDivCd,"commCd"))) {
                /** column 과세구분코드 : txtnDivCd */ 
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "과세구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(calcStdDivCd,"commCd"))) {
                /** column 계산기준구분코드 : calcStdDivCd */ 
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "계산기준구분은 필수 선택 항목입니다.", null);
                return;
            } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd,"commCd"))) {
            	/** column 일월액구분코드 : dayMnthAmntDivCd */
            	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                    "일월액구분은 필수 선택 항목입니다.", null);
               return;
            }
        }
        
        Payr0410DTO payr0410Dto = new Payr0410DTO(); 
         
        payr0410Dto.setDpobCd(MSFSharedUtils.allowNulls(detailRecord.get("dpobCd")));
        payr0410Dto.setPayYr(payYr.getValue());
        payr0410Dto.setTypOccuGrdeMppgSeilNum((Long)detailRecord.get("typOccuGrdeMppgSeilNum"));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        payr0410Dto.setPayrItemSeilNum((Long)detailRecord.get("payrItemSeilNum"));    /** column 급여항목일련번호 : payrItemSeilNum */
          
        payr0410Dto.setTypOccuCd(MSFSharedUtils.allowNulls(detailRecord.get("typOccuCd"))) ;
        payr0410Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(detailRecord.get("dtilOccuInttnCd"))) ;
       // payr0410Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(detailRecord.get("pyspGrdeCd"))); 
          
        /** EMYMT_DIV_CD 고용구분코드*/
        payr0410Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01); 
        /** PAY_CD */
        payr0410Dto.setPayCd(MSFSharedUtils.allowNulls(payCd.getValue().get("commCd")));
           
        /** PAYR_IMCD */
        payr0410Dto.setPayrImcd(payrImcd.getValue());
          
		/** ITEM_NM */
		payr0410Dto.setItemNm(itemNm.getValue());
          
		/** PYMT_DDUC_DIV_CD */
		payr0410Dto.setPymtDducDivCd(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd, "commCd"));
          
		/** PYMT_DDUC_FRM_CD */
		payr0410Dto.setPymtDducFrmCd(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd, "commCd"));

		/** PYMT_DDUC_RATE */
		payr0410Dto.setPymtDducRate((Double) pymtDducRate.getValue());

		/** PYMT_DDUC_SUM */
		payr0410Dto.setPymtDducSum((Long) pymtDducSum.getValue());

		/** TXTN_DIV_CD */
		payr0410Dto.setTxtnDivCd(MSFSharedUtils.getSelectedComboValue(txtnDivCd, "commCd"));

		/** FREE_DTY_RATE */
		payr0410Dto.setFreeDtyRate((Double) freeDtyRate.getValue());

		/** FREE_DTY_SUM */
		payr0410Dto.setFreeDtySum((Long) freeDtySum.getValue());

		/** JAN */
		payr0410Dto.setJan(jan.getValue());

		/** FEB */
		payr0410Dto.setFeb(feb.getValue());

		/** MAR */
		payr0410Dto.setMar(mar.getValue());

		/** APR */
		payr0410Dto.setApr(apr.getValue());

		/** MAY */
		payr0410Dto.setMay(may.getValue());

		/** JUN */
		payr0410Dto.setJun(jun.getValue());

		/** JUL */
		payr0410Dto.setJul(jul.getValue());

		/** AUG */
		payr0410Dto.setAug(aug.getValue());

		/** SEP */
		payr0410Dto.setSep(sep.getValue());

		/** OCT */
		payr0410Dto.setOct(oct.getValue());

		/** NOV */
		payr0410Dto.setNov(nov.getValue());

		/** DEC */
		payr0410Dto.setDec(dec.getValue());

		/** RNGE_ORD */
		payr0410Dto.setRngeOrd((Long) rngeOrd.getValue());

		/** PAY_ITEM_USE_YN */
		payr0410Dto.setPayItemUseYn(payItemUseYn.getValue());

		/** ITEM_APPTN_BGNN_DT */
		payr0410Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(itemApptnBgnnDt.getValue(), "yyyyMMdd"));

		/** ITEM_APPTN_END_DT */
		payr0410Dto.setItemApptnEndDt(GWTUtils.getStringFromDate(itemApptnEndDt.getValue(), "yyyyMMdd"));

		/** DAY_MNTH_AMNT_DIV_CD */
		payr0410Dto.setDayMnthAmntDivCd(MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd, "commCd"));

		/** CALC_STD_DIV_CD */
		payr0410Dto.setCalcStdDivCd(MSFSharedUtils.getSelectedComboValue(calcStdDivCd, "commCd"));

		/** USALY_AMNT_YN */
		payr0410Dto.setUsalyAmntYn(usalyAmntYn.getValue());

		/** PAY_ITEM_NOTE_CTNT */
		payr0410Dto.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(payItemNoteCtnt.getValue()));

		payr0410Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(payrMangDeptCd, "payrMangDeptCd"));
		payr0410Dto.setCalcStdFunc(MSFSharedUtils.allowNulls(calcStdFunc.getValue()));
		
		//------
		
		
		Iterator<BaseModel> itBm = payr0410GridPanel.getMsfGrid().getGrid().getStore().getModels().iterator(); 
				
		//==
		List<Record>  lsRec  = new ArrayList<Record>();
          
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 
            
        Iterator<Record> iterRecords = lsRec.iterator() ;  
		//==
		List<Payr0410DTO> listpayr0410Dto = new ArrayList<Payr0410DTO>();  
				
		while (iterRecords.hasNext()) {
					
					
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			               
			Payr0410DTO payr0410Dto_1 = new Payr0410DTO(); 
			
			payr0410Dto_1.setPayrItemSeilNum((Long) bmMapModel.get("payrItemSeilNum"));			/** set 급여항목일련번호 : payrItemSeilNum */        
			payr0410Dto_1.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));			/** set 급여구분코드 : payCd */
			payr0410Dto_1.setPayrImcd(MSFSharedUtils.allowNulls(bmMapModel.get("payrImcd")));	/** set 급여항목코드 : payrImcd */
			
			listpayr0410Dto.add(payr0410Dto_1);
		} 
		
		if(ActionDatabase.UPDATE == actionDatabase || (ActionDatabase.UPDATE).equals(actionDatabase)) {
			for(int iPayrCnt=0; iPayrCnt < listpayr0410Dto.size(); iPayrCnt++) {
	                
				Payr0410DTO Payr0410Dto_Check = new Payr0410DTO();  
				Payr0410Dto_Check = listpayr0410Dto.get(iPayrCnt);   
	            	
	            	
				//내가 선택한 데이터가 아닌 것 중에서
				if(Payr0410Dto_Check.getPayrItemSeilNum() != payr0410Dto.getPayrItemSeilNum() ) {
					if(payr0410Dto.getPayrImcd() == Payr0410Dto_Check.getPayrImcd() && payr0410Dto.getPayCd() == Payr0410Dto_Check.getPayCd()) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"지급공제항목에 중복된 데이터가 존재합니다.", null);
						return;
					}
				}
			}
		}
		//------
          
              
          payr1500Service.activityOnPayr0410DetailFormSave(payr0410Dto,  actionDatabase, new AsyncCallback<Long>() {
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0410DetailFormSave(" + actionDatabase.name() + ") : " + caught), null);
              }
              public void onSuccess(Long result) { 
                 if (result == 0) {
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                             actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                 } else {
                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                             actionDatabase + "처리가 완료되었습니다.", null);
                     formSubDetilInit();
                     payr0410GridPanel.reload();
                 } 
              } 
          });
//     // }
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
//	private void Payr1500Print(String fileName) {
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
//		List<BaseModel> list = payr0415GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
//		//System.out.println(strParam);
//		
//		//String strParam = "/rp " + "[" + "20080311" + "]";
//		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
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
				
			    getAriaSupport().setPresentation(true);
			    detailTp = XTemplate.create(getDetailTemplate());
			    
			   // formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			     createPayr1500Form();  //화면 기본정보를 설정
			     createSearchForm();    //검색필드를 적용
			     createStandardForm();    //기본정보필드  
			    vp.setSize("1010px", "700px");
			    
			    /**
			     * Create the relations 
			     */
				  final RelationDef  relPayr0415 = new RelationDef(payr0415Def,false);
				  relPayr0415.addJoinDef("dpobCd", "dpobCd");
				  relPayr0415.addJoinDef("payYr", "payYr");
				  relPayr0415.addJoinDef("typOccuGrdeMppgSeilNum", "typOccuGrdeMppgSeilNum");
				  relPayr0415.addJoinDef("typOccuCd", "typOccuCd");
				  relPayr0415.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
				 // relPayr0415.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
				  relPayr0415.setLinkedObject(payr0415GridPanel);
				  payr0410Def.addRelation(relPayr0415); 
			       //TODO
			      // DETAILS 
			      final Grid payr0415Grid = payr0415GridPanel.getMsfGrid().getGrid();
			      payr0415Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			         public void handleEvent(BaseEvent be) {  
			       	  if (payr0415GridPanel.getCurrentlySelectedItem() != null) { 
			       		 
			       	     //선택된 값을 가지고 있는 레코드 
                        setRecord(payr0415GridPanel.getCurrentlySelectedItem());
                          
			       		payr0410Def.synchronizeGridDetail(payr0415GridPanel.getCurrentlySelectedItem(),payr0410GridPanel ); 
			       			//화면우측에 뿌리기. 
			       			BaseModel bmPayr0415 = payr0415GridPanel.getCurrentlySelectedItem();
			       			payYr.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("payYr")));
			       			/** column 직종 : typOccuNm */ 
			       			typOccuNm.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("typOccuNm")));
			       			/** column 직종세 : dtilOccuClsDivNm */
			       			dtilOccuClsDivNm.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("dtilOccuClsDivNm")));
			       		
			       			//hidden 변수
			       			dpobCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("dpobCd")));
			       			typOccuGrdeMppgSeilNum.setValue(Long.parseLong(bmPayr0415.get("typOccuGrdeMppgSeilNum").toString()));  /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
			       			typOccuCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("typOccuCd")));
			       			dtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("dtilOccuInttnCd")));
			       			//pyspGrdeCd.setValue(MSFSharedUtils.allowNulls(bmPayr0415.get("pyspGrdeCd"))); 
			       		 
			       			srhType.setEnabled(true);  
					       	srhPayCd.setEnabled(true);
					        //srhType.clear();
							//srhPayCd.clear();  		       	  
					        //IColumnFilter filters = null;
					       	//payr0410GridPanel.getTableDef().setTableColumnFilters(filters);
							//payr0410GridPanel.reload();
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
	  public Payr1500() {
		   
			setSize("1010px", "700px");  
	  } 
	
	  public Payr1500(String txtForm) {
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
	        private void createPayr1500Form() {
	            
	          plFrmPayr1500 = new FormPanel();
	          plFrmPayr1500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr1500());
	          //plFrmPayr1500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 지급공제항목관리");
	          plFrmPayr1500.setIcon(MSFMainApp.ICONS.text());
	          plFrmPayr1500.setBodyStyleName("pad-text");
	          plFrmPayr1500.setPadding(2);
	          plFrmPayr1500.setFrame(true); 
	          
	          /************************************************************************
	  		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	  		 ************************************************************************/
	  		final Button btnlogView = new Button("로그");   
	  		
	  		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	  		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
	  			public void handleEvent(ButtonEvent e) {
	  				 //로그 뷰화면 호출 메서드 
	  				  funcLogMessage(lblPayrConst.title_Payr1500(),"PAYR1500");
	  				}
	  			});
	  		plFrmPayr1500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	  		plFrmPayr1500.getHeader().addTool(btnlogView); 
	  		/************************************************************************
	  		 * 화면 에러 처리시 필요한 부분으로 추가 
	  		 ************************************************************************/

			   //멀티콤보박스 닫기 
	          plFrmPayr1500.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) { 
	            
	             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
	                    
	            //        if (f instanceof MSFMultiComboBox<?>) {
	                        
//	                      if ("srhDeptCd".equals(f.getName())) {
//	                          
//	                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                          
//	                      }
	                        
	              //      } else {
	                   if (mutilCombo) {
	                        if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
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
	          //  btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
	            buttonBar_1.add(btnNewButton_2);
	            
	            layoutContainer_1.add(buttonBar_1); 
	            layoutContainer_1.setBorders(false);
	            
	            LayoutContainer layoutContainer_2 = new LayoutContainer();
	            layoutContainer_2.setLayout(new FlowLayout());
	             
	            topPayr1500Bar = new ButtonBar();    
	            
	            topPayr1500Bar.setAlignment(HorizontalAlignment.RIGHT);
	            
	          
	           btnPayr1500Init = new Button("초기화");  
	           btnPayr1500Init.setIcon(MSFMainApp.ICONS.new16());
	           topPayr1500Bar.add(btnPayr1500Init);
	           btnPayr1500Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	              public void handleEvent(ButtonEvent e) {
	                  formInit(); 
	              }
	          });
	          
	          btnPayr1500Del = new Button("삭제");  
	          btnPayr1500Del.setIcon(MSFMainApp.ICONS.delete16());
	            topPayr1500Bar.add(btnPayr1500Del); 
	          btnPayr1500Del.addSelectionListener(selectionListener);
	           
	          btnPayr1500Sreach = new Button("조회"); 
	          btnPayr1500Sreach.setIcon(MSFMainApp.ICONS.search16());
	            topPayr1500Bar.add(btnPayr1500Sreach);
	          btnPayr1500Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	              public void handleEvent(ButtonEvent e) {
	                  //조회버튼 클릭시 처리 
	            	  
	            	  searchYn = true;
	            	  
	                  reload();  
	              }
	          });
	          
	         
	          
	          btnPayr1500ExcelFile = new Button("엑셀"); 
	          btnPayr1500ExcelFile .setIcon(Resources.APP_ICONS.excel16()); 
	     	topPayr1500Bar.add(btnPayr1500ExcelFile); 
	     	btnPayr1500ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {			
	    			excelFileExport("");
	    		}
	    	});
	          
	              
//	            btnPayr1500Print = new Button("인쇄"); 
//	            btnPayr1500Print.setIcon(MSFMainApp.ICONS.print16()); 
//	            topPayr1500Bar.add(btnPayr1500Print);  
	            
	           layoutContainer_2.add(topPayr1500Bar);
	           layoutContainer_2.setBorders(false); 
	           
	           layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
	           layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	           layoutContainer.setBorders(false);
	          
	          plFrmPayr1500.add(layoutContainer);    
	            
	          
	          //파일업로드 처리
	          plFrmPayr1500.setAction("bizform");
	          plFrmPayr1500.setEncoding(Encoding.MULTIPART);
	          plFrmPayr1500.setMethod(Method.POST);
	           
	          vp.add(plFrmPayr1500);
	          plFrmPayr1500.setSize("990px", "680px");
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
	        
	       sysComBass0300Dto = new PrgmComBass0300DTO();
	       sysComBass0350Dto = new PrgmComBass0350DTO(); 
           sysComBass0150Dto = new PrgmComBass0150DTO(); 
           sysComBass0320Dto = new PrgmComBass0320DTO();
           
           //--------------------단위기관 불러 오는 함수 ------------------------------------------------
           lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
           //--------------------단위기관 불러 오는 함수 ------------------------------------------------
           
	       //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	       sysComBass0300Dto.setRpsttvCd("B008");  //지급공제구분코드 
	       lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	         
	       //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	         

	       /**
	        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	        * 년도 콤보박스 처리  시작
	        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
	        */
	                  ContentPanel payYrGrid = new ContentPanel();  
	                   payYrGrid.setVisible(false);
	                  
	                  //년도 콤보처리 
	                 payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
	                 payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
	                         public void handleEvent(ComponentEvent be) {  
	                           payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
	                            public void handleEvent(StoreEvent<BaseModel> be) {  
	                               lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
	                               
	                                Date today = new Date(); 
	                                  // A custom date format
	                                DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
	                               
	                                BaseModel  bm  =  srhPayYr.getStore().findModel("payYr", fmt.format(today) ); 
	                                srhPayYr.setValue(bm);
	                            }  
	                          });  
	                         
	                        }  
	                      });  
	            
	              payYrGrid.add(payYrGridPanel); 
	              plFrmPayr1500.add(payYrGrid);
	              
	               
	         /**
	            * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	            * 직종 콤보박스 처리  시작
	            * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
	            */
//	                      ContentPanel typOccuCdGrid = new ContentPanel();  
//	                      typOccuCdGrid.setVisible(false);
//	                      
//	                      //직종 콤보처리 
//	                     typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	                     typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	                             public void handleEvent(ComponentEvent be) {  
//	                               typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	                                public void handleEvent(StoreEvent<BaseModel> be) {  
//	                                    
//	                                  lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels()); 
//	                                  lscrTypOccuCd = lsTypOccuCd; 
//	                                }  
//	                              });  
//	                             
//	                            }  
//	                          });  
//	                
//	                   typOccuCdGrid.add(typOccuCdGridPanel); 
//	                  plFrmPayr1500.add(typOccuCdGrid);
	                  
	                      
	          lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	     		  
	     		   
	          plFrmPayr1500.setLayout(new FlowLayout());
	          
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
	          
	          LayoutContainer lcSchLeft = new LayoutContainer();
	          lcSchLeft.setStyleAttribute("paddingRight", "10px");  
	          lcSchLeft.setStyleAttribute("marginBottom", "5px");  

	          
	            LayoutContainer layoutContainer01 = new LayoutContainer();
	            FormLayout frmlytSch = new FormLayout();  
	            frmlytSch.setLabelWidth(60); 
	            frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	            layoutContainer01.setLayout(frmlytSch);
	            
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
	            srhPayrMangDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	                public void handleEvent(StoreEvent<BaseModel> be) {
	                	   
	                	   EventType type = be.getType();
				    	   if (type == Store.Add) { 
		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				                	checkPayr1500Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
		                	 } 
	                    
	                }
	            });    
	            srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	                public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                	payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")));  
	                } 
	            });
	            layoutContainer01.add(srhPayrMangDeptCd, new FormData("100%"));
	            layoutContainer01.setBorders(false);
	            
	          LayoutContainer layoutContainer = new LayoutContainer();
	          frmlytSch = new FormLayout();  
	          frmlytSch.setLabelWidth(60); 
	          frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	          layoutContainer.setLayout(frmlytSch);
	          
	          srhTypOccuCd = new ComboBox<BaseModel>(); 
	          srhTypOccuCd.setName("srhTypOccuCd");
	          srhTypOccuCd.setForceSelection(true);
	          srhTypOccuCd.setMinChars(1);
	          srhTypOccuCd.setDisplayField("typOccuNm");
	          srhTypOccuCd.setValueField("typOccuCd");
	          srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
	          srhTypOccuCd.setEmptyText("--직종선택--");
	          srhTypOccuCd.setSelectOnFocus(true); 
	          srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	          srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	          srhTypOccuCd.setStore(lsTypOccuCd); 
	          srhTypOccuCd.setFieldLabel("직 종");  
	          lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	 //2015.11.30 추가 
		            	
		            	  EventType type = be.getType();
				    	   if (type == Store.Add) { 
				    		 //  if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
					    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
					    			   BaseModel  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
					                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
					                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
					                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
					                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
					                      //         mdSelect = tpMdSelect;
					                         //  } 
					                     //  }  
					                   
					                       srhTypOccuCd.setValue(mdSelect );
					                   // }  
					                    
			                       }  
				            //	 }
		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				    		  // checkPayr1500Auth("srhTypOccuCd", lsTypOccuCd ); 
		                	 }

		                
		            }
		        });    
	          srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	              public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	         
	                  
	                //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기  
	                  sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	                  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
//	                  String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
//	                  sysComBass0350Dto.setDeptCd(strDeptCd);
	                //  List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
	                //  String strTypOccuCd =  DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
	                  sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")); 
	                  
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
	              } 
	          });
	           
	          layoutContainer.add(srhTypOccuCd, new FormData("100%")); 
	          layoutContainer.setBorders(false);
	          
	          LayoutContainer layoutContainer_14 = new LayoutContainer();
	          frmlytSch = new FormLayout();  
	          frmlytSch.setLabelWidth(60); 
	          frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	          layoutContainer_14.setLayout(frmlytSch);
	          
//	          srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//	          srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//	          srhDtilOccuInttnCd.setForceSelection(true);
//	          srhDtilOccuInttnCd.setMinChars(1);
//	          srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//	          srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//	          srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//	          srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//	          srhDtilOccuInttnCd.setSelectOnFocus(true); 
//	          srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
//	          srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
//	          srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//	          srhDtilOccuInttnCd.setFieldLabel("직종세");  
	            
	            srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
		        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
		        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
		        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		        srhDtilOccuInttnCd.setWidth(100);
		        //srhDtilOccuInttnCd.setHideLabel(true);
		        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		        srhDtilOccuInttnCd.setFieldLabel("직종세");
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
		        
	          layoutContainer_14.add(srhDtilOccuInttnCd, new FormData("100%"));  
	          layoutContainer_14.setBorders(false);
	          
	          LayoutContainer layoutContainer_1 = new LayoutContainer();
	          frmlytSch = new FormLayout();  
	          frmlytSch.setLabelWidth(60); 
	          frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	          layoutContainer_1.setLayout(frmlytSch);
	          
	          srhPymtDducDivCd = new ComboBox<BaseModel>(); 
	          srhPymtDducDivCd.setName("srhPymtDducDivCd");
	          srhPymtDducDivCd.setForceSelection(true);
	          srhPymtDducDivCd.setMinChars(1);
	          srhPymtDducDivCd.setDisplayField("commCdNm");
	          srhPymtDducDivCd.setValueField("commCd");
	          srhPymtDducDivCd.setTriggerAction(TriggerAction.ALL);
	          srhPymtDducDivCd.setEmptyText("--지급공제구분선택--");
	          srhPymtDducDivCd.setSelectOnFocus(true); 
	          srhPymtDducDivCd.setReadOnly(false);
	          srhPymtDducDivCd.setEnabled(true); 
	          srhPymtDducDivCd.setStore(lsPymtDducDivCd); 
	          srhPymtDducDivCd.setFieldLabel("지급공제");   
	        
	          layoutContainer_1.add(srhPymtDducDivCd, new FormData("100%"));
	          layoutContainer_1.setBorders(false);
	          lcSchCol.add(layoutContainer_1);
	        
	       
	          fieldSet.add(lcSchCol, new FormData("100%"));  
	          lcSchLeft.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_8 = new LayoutContainer();
	          frmlytSch = new FormLayout();  
	          frmlytSch.setLabelWidth(60); 
	          frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	          layoutContainer_8.setLayout(frmlytSch);
	          
	          srhPayYr = new ComboBox<BaseModel>(); 
	          srhPayYr.setName("srhPayYr");
	          srhPayYr.setForceSelection(true);
	          srhPayYr.setMinChars(1);
	          srhPayYr.setDisplayField("payYrDisp");
	          srhPayYr.setValueField("payYr");
	          srhPayYr.setTriggerAction(TriggerAction.ALL);
	         // srhPayYr.setEmptyText("--년도선택--");
	          srhPayYr.setSelectOnFocus(true); 
	          srhPayYr.setReadOnly(false);
	          srhPayYr.setEnabled(true); 
	          srhPayYr.setStore(lsPayYrStore); 
	          srhPayYr.setFieldLabel("급여년도");   
	          srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	                public void handleEvent(StoreEvent<BaseModel> be) {   
	                	
	                	 EventType type = be.getType();
				    	   if (type == Store.Add) { 
		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				                	checkPayr1500Auth("srhPayYr", lsPayYrStore); 
		                	 }
	                    
	                }
	            });  
	          
	          
//	  		targetYr = new ComboBox<BaseModel>();
//			targetYr.setForceSelection(true);
//			targetYr.setMinChars(1);
//			targetYr.setDisplayField("payYrDisp");
//			targetYr.setValueField("payYr");
//			targetYr.setTriggerAction(TriggerAction.ALL);
//			targetYr.setEmptyText("--직종선택--");
//			targetYr.setSelectOnFocus(true); 
//			targetYr.setReadOnly(false);
//			targetYr.setEnabled(true); 
//			targetYr.setStore(lsPayYrStore );
//			targetYr.setFieldLabel("이전년도");
//			targetYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//				@Autowired
//				public void handleEvent(StoreEvent<BaseModel> be) {
//
//					EventType type = be.getType();
//					if (type == Store.Add) { 
//						/*String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());		    		
//						int yyyy = Integer.parseInt(fmt.toString()) - 1;	                  
//						targetYr.setValue(lsPayYrStore.findModel("payYr",String.valueOf(yyyy)));*/
//					} 
//				}
//			});
	          
	          
	          layoutContainer_8.add(srhPayYr, new FormData("100%")); 
	          lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	          layoutContainer_8.setBorders(false);
	           
	          lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
	          lcSchCol.add(layoutContainer01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
	          lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	             
	          lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	             
	          plFrmPayr1500.add(fieldSet); 
	      //vp.add(panel);   
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
	       
	            dpobCd = new HiddenField<String>() ;  //사업장코드 
	            typOccuGrdeMppgSeilNum = new HiddenField<Long>();   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
	            payrItemSeilNum = new HiddenField<Long>();   /** column 급여항목일련번호 : payrItemSeilNum */
	            typOccuCd = new HiddenField<String>() ;    /** column 직종코드 : typOccuCd */
	            dtilOccuInttnCd = new HiddenField<String>() ;    /** column 직종세코드 : dtilOccuInttnCd */
	          //  pyspGrdeCd = new HiddenField<String>() ;    /** column 호봉등급코드 : pyspGrdeCd */
	            emymtDivCd = new HiddenField<String>() ;    /** column 고용구분코드 : emymtDivCd */ 
	            msfCoCalendarDto = new SysCoCalendarDTO();
	            
	              
	           //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	           lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	           //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	       
	              LayoutContainer layoutContainer_5 = new LayoutContainer();
	              LayoutContainer layoutContainer_1 = new LayoutContainer(); 
	              layoutContainer_1.setStyleAttribute("text-align", "right");
	              layoutContainer_1.setLayout(new ColumnLayout());
	              
	              LayoutContainer layoutContainer_4 = new LayoutContainer();
//	              layoutContainer_4.setLayout(new FormLayout());
//	              layoutContainer_1.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//	              layoutContainer_4.setBorders(false);
	              
	              LayoutContainer layoutContainer_2 = new LayoutContainer();
	              FormLayout frmlytSch = new FormLayout();  
	              frmlytSch.setLabelWidth(60); 
	              frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	              layoutContainer_2.setLayout(frmlytSch);
	              
	              
	              createPayYr = new ComboBox<BaseModel>(); 
	              createPayYr.setForceSelection(true);
	              createPayYr.setMinChars(1);
	              createPayYr.setDisplayField("yearDisp");
	              createPayYr.setValueField("year");
	              createPayYr.setTriggerAction(TriggerAction.ALL);
	              createPayYr.setEmptyText("--생성년도선택--");
	              createPayYr.setSelectOnFocus(true); 
	              createPayYr.setReadOnly(false);
	              createPayYr.setEnabled(true); 
	              createPayYr.setStore(lscrPayYr); 
	              createPayYr.setFieldLabel("생성년도");
	              createPayYr.setStyleAttribute("marginTop", "5px");
	              createPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	                  public void handleEvent(StoreEvent<BaseModel> be) {  

	                	  checkPayr1500Auth("createPayYr",lscrPayYr);   
	                      
	                  }
	              });    
	              layoutContainer_2.add(createPayYr, new FormData("100%"));          
	              layoutContainer_2.setBorders(false);
	              
	              layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
	              layoutContainer_1.setStyleAttribute("marginLeft", "3px");

	               
	              ////
	              LayoutContainer layoutContainer_btn = new LayoutContainer();
	              
	              
//	              ButtonBar buttonBar = new ButtonBar();
//	              buttonBar.setAlignment(HorizontalAlignment.RIGHT);
	              ButtonBar buttonBar1 = new ButtonBar();
	              buttonBar1.setAlignment(HorizontalAlignment.LEFT);
	              
	              Button btnNewButton_1 = new Button("지급공제직종세생성");
	              btnNewButton_1.setStyleAttribute("marginTop", "5px");
//	              btnNewButton_1.setStyleAttribute("marginLeft", "10px");
	              buttonBar1.add(btnNewButton_1);
	              btnNewButton_1.addListener(Events.Select, new Listener<ButtonEvent>() {
	                  public void handleEvent(ButtonEvent e) {
	                   //직종세 지급항목 생성하기 
	                	  
	                	  
	                	  if(searchYn){
	                		  formNew();
	                	  }else{
	                		  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	        							 " 직종정보 조회 후 생성 가능합니다.", null);	 
	                	  }
	                      
	                  }
	              });  
	              Button btnNewButton_2 = new Button("이전년도직종세이관");
	              btnNewButton_2.setStyleAttribute("marginTop", "5px");
//	              btnNewButton_2.setStyleAttribute("marginLeft", "5px");
	              buttonBar1.add(btnNewButton_2);
	              btnNewButton_2.addListener(Events.Select, new Listener<ButtonEvent>() {
	                  public void handleEvent(ButtonEvent e) {
	                      //TODO  
	                     // formBeforeToNew();
	                      
	                  	
	          			PayrP150001 payrP150001Form = new PayrP150001(ActionDatabase.CUSTOM, getThis());   
	          			MSFFormWindows msFwInsr15001 = new MSFFormWindows("이전년도직종세이관",payrP150001Form,"닫기","600px", "400px",true);
	          			msFwInsr15001.show();
	          			payrP150001Form.setMSFFormWindows(msFwInsr15001);
	          			//funcSetPopUpRecord();
	          			//insrP23005Form.bind(ppRecord);  
	          			
	                  }
	              });
	              
	              Button btnNewButton_4 = new Button("단가항목복사");
	              btnNewButton_4.setStyleAttribute("marginTop", "5px");
//	              btnNewButton_2.setStyleAttribute("marginLeft", "5px");
	              buttonBar1.add(btnNewButton_4);
	              btnNewButton_4.addListener(Events.Select, new Listener<ButtonEvent>() {
	                  public void handleEvent(ButtonEvent e) {
	                      //TODO  
	                  	
	          			PayrP150003 payrP150003Form = new PayrP150003(ActionDatabase.CUSTOM, getThis());   
	          			MSFFormWindows msFwInsr15003 = new MSFFormWindows("단가항목복사",payrP150003Form,"닫기","900px", "600px",true);
	          			msFwInsr15003.show();
	          			payrP150003Form.setMSFFormWindows(msFwInsr15003);
	          			
	                  }
	              });
	              layoutContainer_btn.add(buttonBar1); 
	              layoutContainer_1.add(layoutContainer_btn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.61)); 
	              //----
	              
	              
	              LayoutContainer layoutContainer_btn2 = new LayoutContainer();
	              
	              ButtonBar buttonBar2 = new ButtonBar();
	              buttonBar2.setAlignment(HorizontalAlignment.RIGHT);
	              
	              Button btnNewButton_3 = new Button("직종세지급항목일괄생성");
	              btnNewButton_3.setStyleAttribute("marginTop", "5px");
//	              btnNewButton_3.setStyleAttribute("marginLeft", "380px");
	              buttonBar2.add(btnNewButton_3);
	              btnNewButton_3.addListener(Events.Select, new Listener<ButtonEvent>() {
	                  public void handleEvent(ButtonEvent e) {
	                    //TODO  
	          			PayrP150002 payrP150002Form = new PayrP150002(ActionDatabase.CUSTOM, getThis());   
	          			MSFFormWindows msFwInsr15002 = new MSFFormWindows("직종세지급항목일괄생성",payrP150002Form,"닫기","1010px", "650px",true);
	          			msFwInsr15002.show();
	          			payrP150002Form.setMSFFormWindows(msFwInsr15002);     
	          			
	          			funcSetPopUpRecord();
	          			payrP150002Form.bind(ppRecord); 
	          			
	                  }
	              });
//	              layoutContainer_1.add(buttonBar); 
	              layoutContainer_btn2.add(buttonBar2); 
	              layoutContainer_1.add(layoutContainer_btn2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
	              
	              
//	              layoutContainer_btn.add(buttonBar2);
	             
	              layoutContainer_1.setBorders(false); 
	              layoutContainer_5.add(layoutContainer_1); 
	              layoutContainer_5.setBorders(true);
	              
	              plFrmPayr1500.add(layoutContainer_5);
	        
	          LayoutContainer layoutContainer = new LayoutContainer();
	          layoutContainer.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_11 = new LayoutContainer();
	          FormLayout frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(0); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_11.setLayout(frmlytStd);
	          
	          FieldSet fldstNewFieldset = new FieldSet();
	          fldstNewFieldset.setSize(330,300);
	          
	          
	          layoutContainer_11.add(fldstNewFieldset);
	          fldstNewFieldset.setHeadingHtml("직종정보");
	          fldstNewFieldset.setCollapsible(false);
	          layoutContainer.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
	          layoutContainer_11.setBorders(false);
	          layoutContainer_11.setStyleAttribute("marginTop", "10px");
	          
	          fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
	          
	          LayoutContainer layoutContainer_21 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(0); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_21.setLayout(frmlytStd);
	          
	          FieldSet fldstNewFieldset_1 = new FieldSet();
	          fldstNewFieldset_1.setSize(626, 300);
	          
	          

	          layoutContainer_21.add(fldstNewFieldset_1);
	          fldstNewFieldset_1.setHeadingHtml("지급공제항목설정");
	          fldstNewFieldset_1.setCollapsible(false);
	          fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
	          
	          
	          fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
	          
	          LayoutContainer layoutContainer_31 = new LayoutContainer();
	          layoutContainer_31.setLayout(new ColumnLayout());
	          
	          FieldSet fldstNewFieldset_4 = new FieldSet();
	          fldstNewFieldset_4.setCollapsible(false);
	          
	          LayoutContainer layoutContainer_41 = new LayoutContainer();
	          layoutContainer_41.add(payrLeft01());
	          fldstNewFieldset_4.add(layoutContainer_41);
	          layoutContainer_41.setBorders(false);
	          layoutContainer_31.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	          fldstNewFieldset_4.setHeadingHtml("지급공제항목");
	          fldstNewFieldset_1.add(layoutContainer_31);
	          layoutContainer_31.setBorders(false);
	           
	          
	          layoutContainer.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.63));
	          layoutContainer_21.setBorders(false);
	          layoutContainer_21.setStyleAttribute("marginLeft", "-30px");
	            
	          
	              
	          plFrmPayr1500.add(layoutContainer);
	          layoutContainer.setBorders(false); 
	          
	          LayoutContainer layoutContainer_3 = new LayoutContainer();
	          layoutContainer_3.setLayout(new FlowLayout());
	          
	          FieldSet fldstNewFieldset_2 = new FieldSet();
	          fldstNewFieldset_2.setSize(962, 190);
	          layoutContainer_3.add(fldstNewFieldset_2);
	          fldstNewFieldset_2.setHeadingHtml("지급공제상세정보");
	          fldstNewFieldset_2.setCollapsible(false);
	          fldstNewFieldset_2.setStyleAttribute("marginTop", "5px");
	          
	          fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
	          
	          plFrmPayr1500.add(layoutContainer_3);
	          layoutContainer_3.setBorders(false);
	              
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
	   //지급공제항목설정
	   private LayoutContainer occupationalRTop() {
	       
	         LayoutContainer lcTabFormLayer = new LayoutContainer();
	       
	         ContentPanel cp01 = new ContentPanel();   
	         cp01.setBodyBorder(false); 
	         cp01.setHeaderVisible(false);   
	         cp01.setLayout(new FitLayout());      
	         cp01.setSize(600, 30);  
	         
	         LayoutContainer lytCtr01 = new LayoutContainer();
	         lytCtr01.setLayout(new FlowLayout());
	         
	         LayoutContainer layoutContainer_12 = new LayoutContainer();
	         layoutContainer_12.setLayout(new ColumnLayout());
	         
	         LayoutContainer layoutContainer_13 = new LayoutContainer();
	         FormLayout frmlytStd = new FormLayout();  
	         frmlytStd.setLabelWidth(60); 
	         frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	         layoutContainer_13.setLayout(frmlytStd);
	         
	         payYr = new TextField<String>();
	         payYr.setFieldLabel("급여년도");
	         layoutContainer_13.add(payYr, new FormData("100%")); 
	         layoutContainer_13.setBorders(false);
	         
	         layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	         
	         
	         LayoutContainer layoutContainer = new LayoutContainer();
	         frmlytStd = new FormLayout();  
	         frmlytStd.setLabelWidth(60); 
	         frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	         layoutContainer.setLayout(frmlytStd);
	         
	         typOccuNm = new TextField<String>();
	         typOccuNm.setFieldLabel("직 종");
	         layoutContainer.add(typOccuNm, new FormData("100%"));
	         
	        
	         layoutContainer.setBorders(false);
	         layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	          
	         
	         
	         LayoutContainer layoutContainer14 = new LayoutContainer();
	         frmlytStd = new FormLayout();  
	         frmlytStd.setLabelWidth(60); 
	         frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	         layoutContainer14.setLayout(frmlytStd);
	         
	         dtilOccuClsDivNm = new TextField<String>();
	         dtilOccuClsDivNm.setFieldLabel("직종세");
	         layoutContainer14.add(dtilOccuClsDivNm, new FormData("100%"));
	         
	         layoutContainer14.setBorders(false);
	         layoutContainer_12.add(layoutContainer14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	         layoutContainer_12.setBorders(false); 
	         
	         lytCtr01.add(layoutContainer_12);
	         cp01.add(lytCtr01);
	   
	         lcTabFormLayer.add(cp01); 
	            
	         return lcTabFormLayer;
	       
	  }
	   //지급공제항목상세정보
	   private LayoutContainer occupationalRBottom() {
	         
           
	       LayoutContainer lcTabFormLayer = new LayoutContainer();

	          
	         ContentPanel cp01 = new ContentPanel();   
	         cp01.setBodyBorder(false); 
	         cp01.setHeaderVisible(false);   
	         cp01.setLayout(new FlowLayout());      
	         cp01.setSize(955, 165);
	         
	       
	          LayoutContainer layoutContainer = new LayoutContainer();
	          layoutContainer.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_1 = new LayoutContainer();
	          FormLayout frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_1.setLayout(frmlytStd);
	         
	          /** column 급여항목코드 : payrImcd */
	          payrImcd = new TextField<String>();
	          layoutContainer_1.add(payrImcd, new FormData("100%"));
	          payrImcd.setFieldLabel("항 목");
	          layoutContainer_1.setBorders(false);
	          layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	            
	          LayoutContainer layoutContainer_2 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(5); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_2.setLayout(frmlytStd);
	          
	          /** column 항목명 : itemNm */ 
	          itemNm = new TextField<String>();
	          layoutContainer_2.add(itemNm, new FormData("100%"));
	          itemNm.setLabelSeparator("");
	          itemNm.setFieldLabel("");
	          layoutContainer_2.setBorders(false);
	          layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	             
	          
	          LayoutContainer layoutContainer_3 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_3.setLayout(frmlytStd);
	          
	          
	          
	          //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	          sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
	          lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	          
	          /** column 급여구분코드 : payCd */
	          payCd = new ComboBox<BaseModel>(); 
	          payCd.setForceSelection(true);
	          payCd.setMinChars(1);
	          payCd.setDisplayField("commCdNm");
	          payCd.setValueField("commCd");
	          payCd.setTriggerAction(TriggerAction.ALL);
	          payCd.setEmptyText("--급여구분선택--");
	          payCd.setSelectOnFocus(true); 
	          payCd.setReadOnly(false);
	          payCd.setEnabled(true); 
	          payCd.setStore(lsPayCd); 
	          payCd.setFieldLabel("급여구분");  
	           
	          layoutContainer_3.add(payCd, new FormData("100%"));
	          layoutContainer_3.setBorders(false);
	          layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
	          LayoutContainer layoutContainer_4 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_4.setLayout(frmlytStd);
	        
	          
	          //--------------------공통 코드 불러 오는 함수 -------------------------------------------
              sysComBass0300Dto.setRpsttvCd("B016");  //과세구분  
              lsDayMnthAmntDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
                 
              
	          /** column 일월액구분코드 : dayMnthAmntDivCd */
	          dayMnthAmntDivCd = new ComboBox<BaseModel>(); 
	          dayMnthAmntDivCd.setForceSelection(true);
	          dayMnthAmntDivCd.setMinChars(1);
	          dayMnthAmntDivCd.setDisplayField("commCdNm");
	          dayMnthAmntDivCd.setValueField("commCd");
	          dayMnthAmntDivCd.setTriggerAction(TriggerAction.ALL);
	          dayMnthAmntDivCd.setEmptyText("--일월액구분선택--");
	          dayMnthAmntDivCd.setSelectOnFocus(true); 
	          dayMnthAmntDivCd.setReadOnly(false);
	          dayMnthAmntDivCd.setEnabled(true); 
	          dayMnthAmntDivCd.setStore(lsDayMnthAmntDivCd); 
	          dayMnthAmntDivCd.setFieldLabel("일월액구분");  
	          
	          layoutContainer_4.add(dayMnthAmntDivCd, new FormData("100%")); 
	          layoutContainer_4.setBorders(false);
	          
	          layoutContainer.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	          
	          
	          LayoutContainer layoutContainer_5 = new LayoutContainer();
	          layoutContainer_5.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_9 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_9.setLayout(frmlytStd);
	          
	          /** column 통상임금여부 : usalyAmntYn */
	          usalyAmntYn = new CheckBox(); 
	          usalyAmntYn.setBoxLabel("통상임금");
	          usalyAmntYn.setHideLabel(true);
	          layoutContainer_9.add(usalyAmntYn, new FormData("100%"));
	          layoutContainer_9.setBorders(false);
//	          layoutContainer_9.setStyleAttribute("padding-left", "27px");
	          
	          layoutContainer_5.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	           
	          LayoutContainer layoutContainer_10 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_10.setLayout(frmlytStd);
	          
	          /** column 급여항목사용여부 : payItemUseYn */
	          payItemUseYn = new CheckBox(); 
	          payItemUseYn.setBoxLabel("사용여부");
	          payItemUseYn.setHideLabel(true);
	          layoutContainer_10.add(payItemUseYn, new FormData("100%"));
	          layoutContainer_10.setBorders(false);
//	          layoutContainer_10.setStyleAttribute("padding-left", "25px");
	          
	          layoutContainer_5.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	          layoutContainer_5.setBorders(false);	          
	          layoutContainer.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	          layoutContainer.setBorders(false);

	          
	          cp01.add(layoutContainer);
	          
	          
	          LayoutContainer layoutContainer02 = new LayoutContainer();
	          layoutContainer02.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_11 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_11.setLayout(frmlytStd);
	          

	          //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	          sysComBass0300Dto.setRpsttvCd("B008");  //지급공제구분코드  
	          lsGdPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	            
	          
	          /** column 지급공제구분코드 : pymtDducDivCd */
	          pymtDducDivCd = new ComboBox<BaseModel>(); 
	          pymtDducDivCd.setForceSelection(true);
	          pymtDducDivCd.setMinChars(1);
	          pymtDducDivCd.setDisplayField("commCdNm");
	          pymtDducDivCd.setValueField("commCd");
	          pymtDducDivCd.setTriggerAction(TriggerAction.ALL);
	          pymtDducDivCd.setEmptyText("--지급공제구분선택--");
	          pymtDducDivCd.setSelectOnFocus(true); 
	          pymtDducDivCd.setReadOnly(false);
	          pymtDducDivCd.setEnabled(true); 
	          pymtDducDivCd.setStore(lsGdPymtDducDivCd); 
	          pymtDducDivCd.setFieldLabel("지급(공제)구분");  
	   
	          layoutContainer_11.add(pymtDducDivCd, new FormData("100%"));
	          layoutContainer_11.setBorders(false);
	          
	          layoutContainer02.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
	          LayoutContainer layoutContainer_21 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_21.setLayout(frmlytStd);
	          

	          //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	          sysComBass0300Dto.setRpsttvCd("B017");  //지급공제유형코드  
	          lsPymtDducFrmCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	             
	          
	          /** column 지급공제유형코드 : pymtDducFrmCd */
	          pymtDducFrmCd = new ComboBox<BaseModel>(); 
	          pymtDducFrmCd.setForceSelection(true);
	          pymtDducFrmCd.setMinChars(1);
	          pymtDducFrmCd.setDisplayField("commCdNm");
	          pymtDducFrmCd.setValueField("commCd");
	          pymtDducFrmCd.setTriggerAction(TriggerAction.ALL);
	          pymtDducFrmCd.setEmptyText("--지급공제유형선택--");
	          pymtDducFrmCd.setSelectOnFocus(true); 
	          pymtDducFrmCd.setReadOnly(false);
	          pymtDducFrmCd.setEnabled(true); 
	          pymtDducFrmCd.setStore(lsPymtDducFrmCd); 
	          pymtDducFrmCd.setFieldLabel("지급(공제)유형"); 
	          layoutContainer_21.add(pymtDducFrmCd, new FormData("100%"));
	          layoutContainer_21.setBorders(false);
	          
	          layoutContainer02.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
	          LayoutContainer layoutContainer_31 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_31.setLayout(frmlytStd);
	          
	          /** column 지급공제액 : pymtDducSum */ 
	          pymtDducSum = new NumberField();
	          pymtDducSum.setFieldLabel("지급(공제)금액");
	          pymtDducSum.setAllowDecimals(true);
	          pymtDducSum.setPropertyEditorType(Long.class); 
	          pymtDducSum.setFormat(NumberFormat.getDecimalFormat());
	          layoutContainer_31.add(pymtDducSum, new FormData("100%"));
	          layoutContainer_31.setBorders(false);
	          layoutContainer02.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
	          LayoutContainer layoutContainer_41 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_41.setLayout(frmlytStd);
	          
	          /** column 지급공제율 : pymtDducRate */
	          pymtDducRate = new NumberField(); 
	          pymtDducRate.setFieldLabel("지급(공제)율");
	          pymtDducRate.setAllowDecimals(true); 
	          pymtDducRate.setFormat(NumberFormat.getDecimalFormat());
	          layoutContainer_41.add(pymtDducRate, new FormData("100%"));
	          layoutContainer_41.setBorders(false);
	          
	          layoutContainer02.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	         
	          
	          LayoutContainer layoutContainer_6 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_6.setLayout(frmlytStd);
	          
	          //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	          sysComBass0300Dto.setRpsttvCd("B019");  //급여게산기준코드 
	          lsCalcStdDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	            
	          
	          /** column 계산기준구분코드 : calcStdDivCd */
	          calcStdDivCd = new ComboBox<BaseModel>(); 
	          calcStdDivCd.setForceSelection(true);
	          calcStdDivCd.setMinChars(1);
	          calcStdDivCd.setDisplayField("commCdNm");
	          calcStdDivCd.setValueField("commCd");
	          calcStdDivCd.setTriggerAction(TriggerAction.ALL);
	          calcStdDivCd.setEmptyText("--계산기준선택--");
	          calcStdDivCd.setSelectOnFocus(true); 
	          calcStdDivCd.setReadOnly(false);
	          calcStdDivCd.setEnabled(true); 
	          calcStdDivCd.setStore(lsCalcStdDivCd); 
	          calcStdDivCd.setFieldLabel("계산기준");  
	          
	          layoutContainer_6.add(calcStdDivCd, new FormData("100%"));
	          layoutContainer_6.setBorders(false);
	          
	          layoutContainer02.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	          layoutContainer02.setBorders(false);
	          cp01.add(layoutContainer02);
	           
	         
	          LayoutContainer layoutContainer03 = new LayoutContainer();
	          layoutContainer03.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_12 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_12.setLayout(frmlytStd);
	          
	          //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	          sysComBass0300Dto.setRpsttvCd("B005");  //과세구분  
	          lsTxtnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	             
	          
	          /** column 과세구분코드 : txtnDivCd */
	          txtnDivCd = new ComboBox<BaseModel>(); 
	          txtnDivCd.setForceSelection(true);
	          txtnDivCd.setMinChars(1);
	          txtnDivCd.setDisplayField("commCdNm");
	          txtnDivCd.setValueField("commCd");
	          txtnDivCd.setTriggerAction(TriggerAction.ALL);
	          txtnDivCd.setEmptyText("--과세구분선택--");
	          txtnDivCd.setSelectOnFocus(true); 
	          txtnDivCd.setReadOnly(false);
	          txtnDivCd.setEnabled(true); 
	          txtnDivCd.setStore(lsTxtnDivCd); 
	          txtnDivCd.setFieldLabel("과세구분");  
	          layoutContainer_12.add(txtnDivCd, new FormData("100%"));
	          layoutContainer_12.setBorders(false);
	          
	          layoutContainer03.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
	          LayoutContainer layoutContainer_22 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_22.setLayout(frmlytStd);
	          
	          /** column 비과세금액 : freeDtySum */
	          freeDtySum = new NumberField();
	          freeDtySum.setFieldLabel("비과세금액");
	          freeDtySum.setAllowDecimals(true); 
	          freeDtySum.setPropertyEditorType(Long.class); 
	          freeDtySum.setFormat(NumberFormat.getDecimalFormat());
	          layoutContainer_22.add(freeDtySum, new FormData("100%"));
	          layoutContainer_22.setBorders(false);
	          layoutContainer03.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
	          LayoutContainer layoutContainer_32 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_32.setLayout(frmlytStd);
	          
	          /** column 비과세율 : freeDtyRate */
	          freeDtyRate = new NumberField();
	          freeDtyRate.setFieldLabel("비과세율");
	          freeDtyRate.setAllowDecimals(true); 
	          freeDtyRate.setFormat(NumberFormat.getDecimalFormat());
	          layoutContainer_32.add(freeDtyRate, new FormData("100%")); 
	          layoutContainer03.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          layoutContainer_32.setBorders(false);
	          
	          LayoutContainer layoutContainer_42 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_42.setLayout(frmlytStd);
	          
	          /** column 항목적용시작일자 : itemApptnBgnnDt */
	          itemApptnBgnnDt = new DateField();
	      	  new DateFieldMask(itemApptnBgnnDt, "9999.99.99");
	      	  itemApptnBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//	          itemApptnBgnnDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	          itemApptnBgnnDt.setName("itemApptnBgnnDt"); 
	          itemApptnBgnnDt.setFieldLabel("시작일자");
	          
	          layoutContainer_42.add(itemApptnBgnnDt, new FormData("100%"));
	          
	          layoutContainer03.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	          layoutContainer_42.setBorders(false);
	          
	          LayoutContainer layoutContainer_7 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(90); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_7.setLayout(frmlytStd);
	          
	          /** column 항목적용종료일자 : itemApptnEndDt */
	          itemApptnEndDt = new DateField();
	          itemApptnEndDt.setName("itemApptnEndDt");
	      	  new DateFieldMask(itemApptnEndDt, "9999.99.99");
	      	  itemApptnEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//	          itemApptnEndDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
	          itemApptnEndDt.setFieldLabel("종료일자");
	           
	          layoutContainer_7.add(itemApptnEndDt, new FormData("100%"));
	          layoutContainer_7.setBorders(false);
	          layoutContainer03.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
	          layoutContainer03.setBorders(false);
	          cp01.add(layoutContainer03);
	          
	           
	          LayoutContainer layoutContainer04 = new LayoutContainer();
	          layoutContainer04.setLayout(new ColumnLayout());
	          
	          LayoutContainer layoutContainer_13 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	          frmlytStd.setLabelWidth(50); 
	          frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_13.setLayout(frmlytStd);
	          
	          Listener<BaseEvent> chkListener = new CheckboxListener(); 
	          CheckBoxGroup chckbxgrpNewCheckboxgroup = new CheckBoxGroup(); 
	          
	          /** column 1월 : jan */ 
	          jan = new CheckBox();  
	          chckbxgrpNewCheckboxgroup.add(jan); 
	          jan.setBoxLabel("1월");
	          jan.setHideLabel(true);
	          
	          /** column 2월 : feb */
	          feb = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(feb);
	          feb.setBoxLabel("2월");
	          feb.setHideLabel(true);
	          
	          /** column 3월 : mar */
	          mar = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(mar);
	          mar.setBoxLabel("3월");
	          mar.setHideLabel(true);
	          
	          /** column 4월 : apr */
	          apr = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(apr);
	          apr.setBoxLabel("4월");
	          apr.setHideLabel(true);
	          
	          /** column 5월 : may */
	          may = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(may);
	          may.setBoxLabel("5월");
	          may.setHideLabel(true);
	          
	          /** column 6월 : jun */
	          jun = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(jun);
	          jun.setBoxLabel("6월");
	          jun.setHideLabel(true);
	          
	          /** column 7월 : jul */
	          jul = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(jul);
	          jul.setBoxLabel("7월");
	          jul.setHideLabel(true);
	          
	          /** column 8월 : aug */
	          aug = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(aug);
	          aug.setBoxLabel("8월");
	          aug.setHideLabel(true);
	          
	          /** column 9월 : sep */
	          sep = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(sep);
	          sep.setBoxLabel("9월");
	          sep.setHideLabel(true);
	          
	          /** column 10월 : oct */
	          oct = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(oct);
	          oct.setBoxLabel("10월");
	          oct.setHideLabel(true);

	          /** column 11월 : nov */
	          nov = new CheckBox(); 
	          chckbxgrpNewCheckboxgroup.add(nov);
	          nov.setBoxLabel("11월");
	          nov.setHideLabel(true);
	          
	          /** column 12월 : dec */
	           dec = new CheckBox(); 
	          
	           chckbxgrpNewCheckboxgroup.add(dec);
	           dec.setBoxLabel("12월");
	           dec.setHideLabel(true);
	        
	           chkAll = new CheckBox(); 
	           chckbxgrpNewCheckboxgroup.add(chkAll);
	           chkAll.addListener(Events.OnClick, chkListener); 
	           chkAll.setBoxLabel("전체");
	           chkAll.setHideLabel(true);
	          
	          layoutContainer_13.add(chckbxgrpNewCheckboxgroup, new FormData("100%"));
	          chckbxgrpNewCheckboxgroup.setFieldLabel("지급월");
	          layoutContainer04.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
	          layoutContainer_13.setBorders(false);
	          
	          LayoutContainer layoutContainer_43 = new LayoutContainer();
	          frmlytStd = new FormLayout();  
	           frmlytStd.setLabelWidth(40); 
	           frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	          layoutContainer_43.setLayout(frmlytStd);
	         
	          /** column 정렬순서 : rngeOrd */
	          rngeOrd = new NumberField();
	          rngeOrd.setFieldLabel("순서");
	          rngeOrd.setPropertyEditorType(Long.class); 
	          rngeOrd.setAllowDecimals(true); 
	          rngeOrd.setFormat(NumberFormat.getDecimalFormat());
	          layoutContainer_43.add(rngeOrd, new FormData("100%"));
	          layoutContainer_43.setBorders(false);
	          layoutContainer04.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	          layoutContainer04.setBorders(false);
	          cp01.add(layoutContainer04); 
	         
	          LayoutContainer layoutContainer04_1 = new LayoutContainer();
	          layoutContainer04_1.setLayout(new ColumnLayout());
	          
	          
	         LayoutContainer layoutContainer_8 = new LayoutContainer();
	         frmlytStd = new FormLayout();  
	         frmlytStd.setLabelWidth(90); 
	         frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	         layoutContainer_8.setLayout(frmlytStd);
	         
	         /** column 급여항목비고내용 : payItemNoteCtnt */
	         payItemNoteCtnt = new TextField<String>(); 
	         payItemNoteCtnt.setFieldLabel("비 고");
	         layoutContainer_8.add(payItemNoteCtnt, new FormData("100%"));
	         layoutContainer_8.setBorders(false); 
	         
	         
	         LayoutContainer layoutContainer_8_1 = new LayoutContainer();
             frmlytStd = new FormLayout();  
             frmlytStd.setLabelWidth(90); 
             frmlytStd.setLabelAlign(LabelAlign.RIGHT);
             layoutContainer_8_1.setLayout(frmlytStd);
             
	            /** column 단위기관 : payrMangDeptCd */
	            payrMangDeptCd = new ComboBox<BaseModel>();
	            payrMangDeptCd.setName("payrMangDeptCd");
	            payrMangDeptCd.setForceSelection(true);
	            payrMangDeptCd.setMinChars(1);
	            payrMangDeptCd.setDisplayField("payrMangDeptNm");
	            payrMangDeptCd.setValueField("payrMangDeptCd");
	            payrMangDeptCd.setTriggerAction(TriggerAction.ALL);
	            payrMangDeptCd.setEmptyText("--단위기관선택--");
	            payrMangDeptCd.setSelectOnFocus(true); 
	            payrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
	            payrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
	            payrMangDeptCd.setStore(lsPayrMangDeptCd);  
	            payrMangDeptCd.setFieldLabel("단위기관"); 
	            payrMangDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	                public void handleEvent(StoreEvent<BaseModel> be) {  

	                	payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd() ));  
	                	 EventType type = be.getType();
				    	   if (type == Store.Add) { 
		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				                	checkPayr1500Auth("PayrMangDeptCd", lsPayrMangDeptCd); 
		                	 }
	                    
	                }
	            });    
	            payrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	                public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                 
	                } 
	            });
	            
	            layoutContainer_8_1.add(payrMangDeptCd, new FormData("100%"));
	            layoutContainer_8_1.setBorders(false);
	            
	            layoutContainer04_1.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	            layoutContainer04_1.add(layoutContainer_8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	            layoutContainer04_1.setBorders(false);
	            cp01.add(layoutContainer04_1);
	          
	            calcStdFunc = new TextField<String>(); 
	            calcStdFunc.setFieldLabel("게산식");
	            calcStdFunc.setVisible(false);
	         
	         //저장버튼클릭시 처리 루틴.
	         cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
	                @Override  
	                public void componentSelected(ButtonEvent ce) {   
	                    
	                   actionDatabase = ActionDatabase.UPDATE; 
	                   detailFormSave();
	                }   
	              }));  
	              
	          cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
	             @Override  
	             public void componentSelected(ButtonEvent ce) {   
	            	 
	                   if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
	                	 
	                	   MessageBox.alert("오류", "마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
	                	   return; 
	                     
	                   }
	            	 
	            		MessageBox.confirm("경고", "지급공제상세정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
	            			@Override
	            			public void handleEvent(MessageBoxEvent be) {
	            				//if("Yes".equals(be.getButtonClicked().getText())){
	            				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	            					 actionDatabase = ActionDatabase.DELETE; 
	            	                 detailFormSave();
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
	     * 서브 입력 폼 종료
	     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~       
	     **/    
	    /**
	     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	     * 그리드 처리 함수 시작 
	     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~       
	     **/   
	   //지급공제항목 
	   private LayoutContainer payrLeft01() {
	         
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(600, 220);
	   
	    sysComBass0300Dto = new PrgmComBass0300DTO(); 

		// --------------------공통 코드 불러 오는 함수-------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B008"); // 지급공제구분코드
		lsGdPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// --------------------공통 코드 불러 오는 함수-------------------------------------------

		  LayoutContainer layoutContainer_5 = new LayoutContainer();
          LayoutContainer layoutContainer_1 = new LayoutContainer(); 
          layoutContainer_1.setStyleAttribute("text-align", "right");
          layoutContainer_1.setLayout(new ColumnLayout());
          
     /*     LayoutContainer layoutContainer_4 = new LayoutContainer();
          layoutContainer_4.setLayout(new FormLayout());
          layoutContainer_1.add(layoutContainer_4, new FormData("100%"));
          layoutContainer_4.setBorders(true);*/
          
          LayoutContainer layoutContainer_2 = new LayoutContainer();
          FormLayout frmlytSch = new FormLayout();  
          frmlytSch.setLabelWidth(60); 
          frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
          layoutContainer_2.setLayout(frmlytSch);
		
		ToolBar toolBar = new ToolBar();
		//toolBar.getAriaSupport().setLabel("지급공제구분");
		//toolBar.add(new FillToolItem());
		toolBar.add(new LabelToolItem("급여구분: "));
		 
		
		sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
    	lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);

    	/** column 급여구분코드 : payCd */
    	srhPayCd = new ComboBox<BaseModel>(); 
    	srhPayCd.setForceSelection(true);
    	srhPayCd.setMinChars(1);
    	srhPayCd.setDisplayField("commCdNm");
    	srhPayCd.setValueField("commCd");
    	srhPayCd.setTriggerAction(TriggerAction.ALL);
    	srhPayCd.setEmptyText("--급여구분선택--");
    	srhPayCd.setSelectOnFocus(true); 
    	srhPayCd.setReadOnly(false);
    	srhPayCd.setEnabled(false); 
    	srhPayCd.setStore(lsPayCd); 
    	srhPayCd.setFieldLabel("급여구분");  
    	
    	
    	srhPayCd.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent be) {
				IColumnFilter filters = null;
				payr0410GridPanel.getTableDef().setTableColumnFilters(filters);
				payr0410GridPanel.getTableDef().addColumnFilter("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
				payr0410GridPanel.reload();
			}
		});
    	
    	
    	
    	toolBar.add(srhPayCd);
    	
		
		toolBar.add(new LabelToolItem("지급공제구분: "));
		srhType = new ComboBox<BaseModel>();
		srhType.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
		srhType.setTriggerAction(TriggerAction.ALL);
		//srhType.setEditable(false);
		srhType.setEmptyText("--지급공제구분선택--");
		srhType.setFireChangeEventOnSetValue(true);
		srhType.setWidth(150);
		srhType.setDisplayField("commCdNm");
		srhType.setValueField("commCd");
		srhType.setReadOnly(false);		
		srhType.setEnabled(false);		
		srhType.setStore(lsGdPymtDducDivCd);
		srhType.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent be) {
				IColumnFilter filters = null;
				payr0410GridPanel.getTableDef().setTableColumnFilters(filters);
				payr0410GridPanel.getTableDef().addColumnFilter("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
				payr0410GridPanel.getTableDef().addColumnFilter("pymtDducDivCd",MSFSharedUtils.getSelectedComboValue(srhType, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
				payr0410GridPanel.reload();
				
				
				
			}
		});
		
		
		toolBar.add(srhType);
		
		
		 layoutContainer_2.add(toolBar, new FormData("100%"));          
         layoutContainer_2.setBorders(false);
        
         
         
         layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
         layoutContainer_1.setStyleAttribute("marginLeft", "3px");

		
        // LayoutContainer layoutContainer_6 = new LayoutContainer();
         
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button btnNew = new Button("신규"); 
		btnNew.setIcon(MSFMainApp.ICONS.new16());
		btnNew.setStyleAttribute("marginTop", "3px");
		btnNew.setStyleAttribute("marginLeft", "50px");
		buttonBar.add(btnNew);
		
		btnNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//조회버튼 클릭시 처리 				
				if (MSFSharedUtils.paramNull(srhPayCd.getValue())) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
							"급여구분을 선택하세요", null);
					return;
				}else{
					fnPopupCommP500();
				}
			}
		});

		//layoutContainer_6.add(buttonBar, new FormData("100%"));
		
		 layoutContainer_1.add(buttonBar); 
         layoutContainer_1.setBorders(false); 
         
         layoutContainer_5.add(layoutContainer_1); 
         layoutContainer_5.setBorders(true);
         
       

		//toolBar.add(layoutContainer_01);
		
		cp01.setTopComponent(layoutContainer_5);

/*		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				fnPopupCommP500();
			}
		}));*/
	             
		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0410GridPanel = new MSFGridPanel(payr0410Def, false, false, false,false, false);
		payr0410GridPanel.setHeaderVisible(false);
		payr0410GridPanel.setBodyBorder(true);
		payr0410GridPanel.setBorders(true);
		payr0410GridPanel.setSize(600, 220);
		// DETAILS
		final Grid payr0410Grid = payr0410GridPanel.getMsfGrid().getGrid();
		payr0410Grid.addListener(Events.CellDoubleClick,new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (payr0410GridPanel.getCurrentlySelectedItem() != null) { 
					payYr.setValue(MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("payYr")));  //급여년도 
					typOccuGrdeMppgSeilNum.setValue((Long)payr0410GridPanel.getCurrentlySelectedItem().get("typOccuGrdeMppgSeilNum"));  /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
					payrItemSeilNum.setValue((Long)payr0410GridPanel.getCurrentlySelectedItem().get("payrItemSeilNum"));   /** column 급여항목일련번호 : payrItemSeilNum */
	                payrImcd.setValue(MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("payrImcd")));   /** column 급여항목코드 : payrImcd */                          
	                itemNm.setValue(MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("itemNm")));   /** column 항목명 : itemNm */                                         
	                payCd.setValue(lsPayCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("payCd"))));   /** column 급여구분코드 : payCd */                                  
	                pymtDducDivCd.setValue(lsGdPymtDducDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("pymtDducDivCd"))));   /** column 지급공제구분코드 : pymtDducDivCd */              
	                pymtDducFrmCd.setValue(lsPymtDducFrmCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("pymtDducFrmCd"))));   /** column 지급공제유형코드 : pymtDducFrmCd */              
	                pymtDducRate.setValue((Double)payr0410GridPanel.getCurrentlySelectedItem().get("pymtDducRate"));   /** column 지급공제율 : pymtDducRate */                      
	                pymtDducSum.setValue((Long)payr0410GridPanel.getCurrentlySelectedItem().get("pymtDducSum"));   /** column 지급공제액 : pymtDducSum */                        
	                txtnDivCd.setValue(lsTxtnDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("txtnDivCd"))));   /** column 과세구분코드 : txtnDivCd */                          
	                freeDtyRate.setValue((Double)payr0410GridPanel.getCurrentlySelectedItem().get("freeDtyRate"));   /** column 비과세율 : freeDtyRate */                          
	                freeDtySum.setValue((Long)payr0410GridPanel.getCurrentlySelectedItem().get("freeDtySum"));   /** column 비과세금액 : freeDtySum */  
	                  
	                jan.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("jan"));   /** column 1월 : jan */
	                feb.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("feb"));   /** column 2월 : feb */
	                mar.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("mar"));   /** column 3월 : mar */
	                apr.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("apr"));   /** column 4월 : apr */
	                may.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("may"));   /** column 5월 : may */
	                jun.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("jun"));   /** column 6월 : jun */
	            	jul.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("jul"));   /** column 7월 : jul */
	               	aug.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("aug"));   /** column 8월 : aug */
	               	sep.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("sep")) ;  /** column 9월 : sep */
	               	oct.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("oct"));   /** column 10월 : oct */
	             	nov.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("nov"));   /** column 11월 : nov */
	              	dec.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("dec"));   /** column 12월 : dec */ 
	                     
	              	rngeOrd.setValue((Long)payr0410GridPanel.getCurrentlySelectedItem().get("rngeOrd"));   /** column 정렬순서 : rngeOrd */                        
	              	payItemUseYn.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("payItemUseYn"));   /** column 급여항목사용여부 : payItemUseYn */      
	               	itemApptnBgnnDt.setValue((Date)payr0410GridPanel.getCurrentlySelectedItem().get("itemApptnBgnnDt"));   /** column 항목적용시작일자 : itemApptnBgnnDt */
	            	itemApptnEndDt.setValue((Date)payr0410GridPanel.getCurrentlySelectedItem().get("itemApptnEndDt")) ; /** column 항목적용종료일자 : itemApptnEndDt */   
	               	dayMnthAmntDivCd.setValue(lsDayMnthAmntDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("dayMnthAmntDivCd")))) ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
	             	calcStdDivCd.setValue(lsCalcStdDivCd.findModel("commCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("calcStdDivCd"))));   /** column 계산기준구분코드 : calcStdDivCd */      
	              	usalyAmntYn.setValue((Boolean)payr0410GridPanel.getCurrentlySelectedItem().get("usalyAmntYn"));   /** column 통상임금여부 : usalyAmntYn */            
	             	payItemNoteCtnt.setValue(MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("payItemNoteCtnt")));   /** column 급여항목비고내용 : payItemNoteCtnt */ 
	                  
	             	payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("payrMangDeptCd"))));  
	             	calcStdFunc.setValue(MSFSharedUtils.allowNulls(payr0410GridPanel.getCurrentlySelectedItem().get("calcStdFunc"))); 
	                      
	             	//삭제와 업데이트를 위한 값을 넣은다.
	             	setDetailRecord(payr0410GridPanel.getCurrentlySelectedItem());
	                     
	        		} 
	     		}
			}); 
	           
	          //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
			cp01.add(payr0410GridPanel);
	          
			lcTabFormLayer.add(cp01); 
	           
			return lcTabFormLayer;  
	   }
	   
	  private LayoutContainer occupationalLeft() {
	   
	     LayoutContainer lcTabFormLayer = new LayoutContainer();
	   
	    ContentPanel cp01 = new ContentPanel();   
	    cp01.setBodyBorder(false); 
	    cp01.setHeaderVisible(false);   
	    cp01.setLayout(new FitLayout());      
	    cp01.setSize(320, 270);  
	    
	     //msfCustomForm.setHeaderVisible(false);
	     //Instantiate the GridPanel
	     payr0415GridPanel = new MSFGridPanel(payr0415Def, false, false, false, false, false);
	     payr0415GridPanel.setHeaderVisible(false);  
	     payr0415GridPanel.setBodyBorder(true);
	     payr0415GridPanel.setBorders(true); 
	     payr0415GridPanel.setSize(320, 270); 
	  //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	  
	     
	     cp01.add(payr0415GridPanel); 
	     
	     lcTabFormLayer.add(cp01); 
	     
	      return lcTabFormLayer;  
	   
	  }
	  
	        
	    /**
	     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	     * 그리드 처리 함수 종료
	     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~       
	     **/    
	  
      public void payr0410_reload() {
		// TODO Auto-generated method stub

		// 선택된 값을 가지고 있는 레코드
		setRecord(payr0415GridPanel.getCurrentlySelectedItem());

		payr0410Def.synchronizeGridDetail(payr0415GridPanel.getCurrentlySelectedItem(),payr0410GridPanel);
		// 화면우측에 뿌리기.
		BaseModel bmPayr0415 = payr0415GridPanel.getCurrentlySelectedItem();

		String strPayYr = bmPayr0415.get("payYr");
		String strTypOccuCd = bmPayr0415.get("typOccuCd");
		String strDtilOccuInttnCd = bmPayr0415.get("dtilOccuInttnCd");
		String strPymtDducDivCd = bmPayr0415.get("pymtDducDivCd");
		String strPayrMangDeptCd = bmPayr0415.get("payrMangDeptCd");
       	   
	        
	    IColumnFilter filters = null;
	    payr0410GridPanel.getTableDef().setTableColumnFilters(filters);
           
	    payr0410GridPanel.getTableDef().addColumnFilter("payYr", strPayYr, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0410GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0410GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    //payr0410GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", strPymtDducDivCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0410GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", strPayrMangDeptCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	    payr0410GridPanel.getTableDef().addColumnFilter("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
		payr0410GridPanel.getTableDef().addColumnFilter("pymtDducDivCd",MSFSharedUtils.getSelectedComboValue(srhType, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
	    
	    payr0410GridPanel.reload();
      }
	        
	      public void reload() {
	              // TODO Auto-generated method stub
	          if ( MSFSharedUtils.paramNull(srhPayYr.getRawValue()) ) {
	                MessageBox.alert("데이터 오류", "년도는 필수 선택사항입니다.", null);
	                srhPayYr.focus();
	                return;
	          }
	            
	              IColumnFilter filters = null;
	              payr0415GridPanel.getTableDef().setTableColumnFilters(filters);
	               
	               
	              payr0415GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
	          //    payr0415GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS);
	              payr0415GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	              String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	              payr0415GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	              //payr0415GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	              payr0415GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"pymtDducDivCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	              payr0415GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	              
	              payr0415GridPanel.reload();
	          }
	        
	         public void setRecord(BaseModel record) {
	             this.record = record;
	         }
	         
	          /**
	           * 지급공제선택 
	           */
	         private void fnPopupCommP500() {
	             //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	             //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	             //검색.처리하면됨.
	        	 PrgmComP0500DTO sysComP0500Dto = new PrgmComP0500DTO();
	        	 //지급공제구분코드 넘김.
	        	 MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpPrgmCom0500Form(sysComP0500Dto);  //인사  

	        	 final FormBinding popBindingCom0500 = popCom0500.getFormBinding();

	        	 popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
	        		 public void handleEvent(BaseEvent be) {
	        			 List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	        			 if (mapModels != null) { 

	        				 boolean payCdEq = false;
	        				 boolean payImcdEq = false;
	        				 String itemNm = "";
	        				 String payCd =  MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCd");
	        				 List<BaseModel> list = payr0410GridPanel.getMsfGrid().getGrid().getStore().getModels();
	        				 for(BaseModel bm : list){
	        					 if(payCd.equals(bm.get("payCd"))){
	        						 payCdEq = true;
	        					 }
	        					 for(BaseModel bm2 : mapModels){
	        						 if(bm.get("payrImcd").equals(bm2.get("payExtpyCd"))){
	        							 payImcdEq = true;
	        							 itemNm = bm.get("itemNm");
	        						 }
	        					 }
	        				 }

	        				 if(payCdEq == true && payImcdEq == true){	            			
	        					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	        							 itemNm + " 의 "+MSFSharedUtils.getSelectedComboValue(srhPayCd, "commCdNm")+" 가 이미 존재 합니다.", null);	        					 
	        				 }else{
	        					 setListRecord(mapModels);
	        					 actionDatabase = ActionDatabase.INSERT;
	        					 payr0410Save();
	        				 }
	        			 }  
	        		 }
	        	 });
	         }
	         
	         /**
	           * 직종에 대한 직종세를 신규로 처리한다.
	           */
	           private void formNew() {
	                //팝업호출을 통해 처리 한다. 
	               fnPopupCommP510(); 
	           }
	           
	             private void fnPopupCommP510() {
	                 
	                  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(createPayYr,"year"))) {
	                      MessageBox.alert("생성년도선택", "생설할 생성년도를 선택하십시요.", null);
	                      return;
	                  }
	                 
	                 MSFFormPanel popCom0510 = PrgmComPopupUtils.lovPopUpPrgmCom0510Form();  //직종
	                 
	                 final FormBinding popBindingCom0510 = popCom0510.getFormBinding();
	                
	                 popBindingCom0510.addListener(Events.Change, new Listener<BaseEvent>() {
	                     public void handleEvent(BaseEvent be) {
	                         List<BaseModel> mapModels = (List<BaseModel>)be.getSource();

	                         if (mapModels != null) { 
	                        	 boolean year = false;
	                        	 boolean dtilOccuInttnCdYn = false;
	                        	 String dtilOccuClsDivNm = "";
	                        	 String createPayYrStr =  MSFSharedUtils.getSelectedComboValue(createPayYr, "year");
	                        	 List<BaseModel> list = payr0415GridPanel.getMsfGrid().getGrid().getStore().getModels();
	                        	 for(BaseModel bm : list){
	                        		 if(createPayYrStr.equals(bm.get("payYr"))){
	                        			 year = true;
	                        		 }
	                        		 for(BaseModel bm2 : mapModels){
	                        			 if(bm.get("dtilOccuInttnCd").equals(bm2.get("dtilOccuInttnCd"))){
	                        				 dtilOccuInttnCdYn = true;
	                        				 dtilOccuClsDivNm = bm.get("dtilOccuClsDivNm");
	                        			 }
	                        		 }
	                        	 }

	                        	 if(year == true && dtilOccuInttnCdYn == true){	            			
	                        		 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                        				 createPayYrStr+"년도에 직종세 ("+ dtilOccuClsDivNm + ") 이(가) 이미 존재 합니다.", null);	        					 
	                        	 }else{
	                        		 setListRecord(mapModels);
	                        		 actionDatabase = ActionDatabase.INSERT;
	                        		 doAction(ActionDatabase.INSERT);  
	                        	 }
	                         }    
	                     }
	                 });
	             }
	             
	             
	             private void formBeforeToNew() {
	                 //선택된 이전 데이터를 이관한다. 해당년도로 이관한다. 만약 데이터
	                 if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(createPayYr,"year"))) {
	                     MessageBox.alert("생성년도선택", "생설할 생성년도를 선택하십시요.", null);
	                     return;
	                 }
	                
	                MSFFormPanel popCom0510 = PrgmComPopupUtils.lovPopUpPrgmCom0510Form();  //직종
	                
	                final FormBinding popBindingCom0510 = popCom0510.getFormBinding();
	               
	                popBindingCom0510.addListener(Events.Change, new Listener<BaseEvent>() {
	                    public void handleEvent(BaseEvent be) {
	                        List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	                        
	                        if (mapModels != null) { 
	                            
	                            setListRecord(mapModels);
	                            actionDatabase = ActionDatabase.INSERT;
	                             
	                            MessageBox.confirm("이전데이터이관", "선택하신 직종세에 대한 이전년도 데이터를 이관합니다. 이관하시겠습니까?",new Listener<MessageBoxEvent>(){
	                                @Override
	                                public void handleEvent(MessageBoxEvent be) {
	                                    //if("Yes".equals(be.getButtonClicked().getText())){
	                                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                                        
	                                        
	                                        Payr0415DTO payr0415Dto = new Payr0415DTO();  
	                                         
	                                       
	                                        payr0415Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
	                                        payr0415Dto.setPayYr(MSFSharedUtils.allowNulls(createPayYr.getValue().get("year"))); 
	                                        
	                                            payr1500Service.activityOnPayr1500BfToNew(payr0415Dto,records, 
	                                                    actionDatabase,
	                                                    new AsyncCallback<Long>() {
	                                                    public void onFailure(Throwable caught) {
	                                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0415Insert(" + actionDatabase.name() + ") : " + caught), null);
	                                                    }
	                                                    public void onSuccess(Long result) { 
	                                                        if (result == 0) {
	                                                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                                                    actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                                                        } else {
	                                                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                                                    actionDatabase + "처리가 완료되었습니다.", null);
	                                                            reload();
	                                                        } 
	                                                    } 
	                                                }); 
	                                            
	                                    }
	                                }
	                            });
	                            
	                        } else {
	                            MessageBox.alert("직종선택", "생설할 직종/직종세를 선택하십시요.", null);
	                            return;
	                        } 
	                     
	                        
	                    }
	                });
	             }
	             
	             
	             
	             public void setListRecord(List<BaseModel> records) {
	                 this.records = records;
	             } 

	     private void formInit() {
	             
	    	 		searchYn = false;
	    	 
	                BaseModel bmBlank = new BaseModel();  
	                
	                srhPayYr.setValue(lsPayYrStore.getAt(0)); /** column 급여년도 : payYr */                                     
	                 
	                /** column 직종코드 : typOccuCd */
	                srhTypOccuCd.setValue(bmBlank);  
	                /** column 직종세코드 : dtilOccuInttnCd */  
	                srhDtilOccuInttnCd.getInitStore() ;    
	                /** column 지급공제구분코드 : pymtDducDivCd */
	                srhPymtDducDivCd.setValue(bmBlank);                                          
	               
	                
	                createPayYr.setValue(bmBlank);     /** column 급여년도 : payYr */  
	               // createTypOccuCd.setValue(bmBlank);    /** column 직종코드 : typOccuCd */
	               // createDtilOccuInttnCd.setValue(bmBlank);     /** column 직종세코드 : dtilOccuInttnCd */
	                  
	                
	                payr0415GridPanel.getMsfGrid().clearData();
	                
	                formSubInit(); 
	                formSubDetilInit();
	         }
	      
	         private void formSubInit() {
	             
	             BaseModel bmBlank = new BaseModel();  
	             
	             dpobCd.setValue("");  //사업장코드           
	             typOccuGrdeMppgSeilNum.setValue(0L);   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
	             payrItemSeilNum.setValue(0L);   /** column 급여항목일련번호 : payrItemSeilNum */
	             emymtDivCd.setValue("");   /** column 고용구분코드 : emymtDivCd */                        
	                                         
	             
	             typOccuCd.setValue("");   /** column 직종코드 : typOccuCd */
	             typOccuNm.setValue("");   /** column 직종코드 : typOccuCd */
	         
	             dtilOccuInttnCd.setValue("");   /** column 직종세코드 : dtilOccuInttnCd */
	             dtilOccuClsDivNm.setValue("");   /** column 직종세코드 : dtilOccuInttnCd */
	        
	          //   pyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */
	           //  pyspGrdeNm.setValue("");   /** column 호봉등급 : pyspGrdeNm */
	             
	   
	             payr0410GridPanel.getMsfGrid().clearData();
	              
	             
	         }
	         
	    private void formSubDetilInit() {
	             
	             BaseModel bmBlank = new BaseModel();  
	             
	             setDetailRecord(bmBlank); 
	                                                                           
	             payYr.setValue("");  //지급년도                                                                 
	             payrImcd.setValue("");   /** column 급여항목코드 : payrImcd */                 
	             itemNm.setValue("");   /** column 항목명 : itemNm */                                         
	             payCd.setValue(bmBlank);   /** column 급여구분코드 : payCd */                                  
	             pymtDducDivCd.setValue(bmBlank);   /** column 지급공제구분코드 : pymtDducDivCd */              
	             pymtDducFrmCd.setValue(bmBlank);   /** column 지급공제유형코드 : pymtDducFrmCd */              
	             pymtDducRate.setValue(0.0);   /** column 지급공제율 : pymtDducRate */                      
	             pymtDducSum.setValue(0);   /** column 지급공제액 : pymtDducSum */                        
	             txtnDivCd.setValue(bmBlank);   /** column 과세구분코드 : txtnDivCd */                          
	             freeDtyRate.setValue(0.0);   /** column 비과세율 : freeDtyRate */                          
	             freeDtySum.setValue(0);   /** column 비과세금액 : freeDtySum */   
	             
	             jan.setValue(false);   /** column 1월 : jan */
	             feb.setValue(false);   /** column 2월 : feb */
	             mar.setValue(false);   /** column 3월 : mar */
	             apr.setValue(false);   /** column 4월 : apr */
	             may.setValue(false);   /** column 5월 : may */
	             jun.setValue(false);   /** column 6월 : jun */
	             jul.setValue(false);   /** column 7월 : jul */
	             aug.setValue(false);   /** column 8월 : aug */
	             sep.setValue(false) ;  /** column 9월 : sep */
	             oct.setValue(false);   /** column 10월 : oct */
	             nov.setValue(false);   /** column 11월 : nov */
	             dec.setValue(false);   /** column 12월 : dec */
	             chkAll.setValue(false);   /** column 전체체크 : chkAll */
	             
	             rngeOrd.setValue(0);   /** column 정렬순서 : rngeOrd */                        
	             payItemUseYn.setValue(true);   /** column 급여항목사용여부 : payItemUseYn */      
	             itemApptnBgnnDt.reset();   /** column 항목적용시작일자 : itemApptnBgnnDt */
	             itemApptnEndDt.reset() ; /** column 항목적용종료일자 : itemApptnEndDt */   
	             dayMnthAmntDivCd.setValue(bmBlank) ;  /** column 일월액구분코드 : dayMnthAmntDivCd */
	             calcStdDivCd.setValue(bmBlank);   /** column 계산기준구분코드 : calcStdDivCd */      
	             usalyAmntYn.setValue(false);   /** column 통상임금여부 : usalyAmntYn */            
	             payItemNoteCtnt.setValue("");   /** column 급여항목비고내용 : payItemNoteCtnt */
	              
               //  payrMangDeptCd.setValue(bmBlank);  
                 calcStdFunc.setValue(""); 
                  
	                
	         }
	    
	        //전체선택 체크박스 
	        public class CheckboxListener implements Listener<BaseEvent>
	        {
	            public void handleEvent(BaseEvent be) {
	                CheckBox checkBox = (CheckBox) be.getSource();
	                if (checkBox.getValue()) {
	                   //전체선택
	                    jan.setValue(true);   /** column 1월 : jan */
	                    feb.setValue(true);   /** column 2월 : feb */
	                    mar.setValue(true);   /** column 3월 : mar */
	                    apr.setValue(true);   /** column 4월 : apr */
	                    may.setValue(true);   /** column 5월 : may */
	                    jun.setValue(true);   /** column 6월 : jun */
	                    jul.setValue(true);   /** column 7월 : jul */
	                    aug.setValue(true);   /** column 8월 : aug */
	                    sep.setValue(true) ;  /** column 9월 : sep */
	                    oct.setValue(true);   /** column 10월 : oct */
	                    nov.setValue(true);   /** column 11월 : nov */
	                    dec.setValue(true);   /** column 12월 : dec */
	                } else {
	                   //전체해제  
	                    jan.setValue(false);   /** column 1월 : jan */
	                    feb.setValue(false);   /** column 2월 : feb */
	                    mar.setValue(false);   /** column 3월 : mar */
	                    apr.setValue(false);   /** column 4월 : apr */
	                    may.setValue(false);   /** column 5월 : may */
	                    jun.setValue(false);   /** column 6월 : jun */
	                    jul.setValue(false);   /** column 7월 : jul */
	                    aug.setValue(false);   /** column 8월 : aug */
	                    sep.setValue(false) ;  /** column 9월 : sep */
	                    oct.setValue(false);   /** column 10월 : oct */
	                    nov.setValue(false);   /** column 11월 : nov */
	                    dec.setValue(false);   /** column 12월 : dec */
	                }
	            }
	        }   
	    
 
      public void setDetailRecord(BaseModel detailRecord) {
          this.detailRecord = detailRecord;
      }
      
  
	   private Payr1500 getThis(){
	       return this;
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

	//엑셀 저장
			private void excelFileExport(String flag) {		                     
				HashMap<String, String> param = new HashMap<String, String>(); 
				
				
/*				
				typOccuGrdeMppgSeilNumList = new String();
				typOccuGrdeMppgSeilNumList = MSFSharedUtils.allowNulls(typOccuGrdeMppgSeilNum.getValue());
				
				//그리드 선택 데이터 출력
				String checkedSystemKeys = "";
				int keyCnt = 0;
				List<BaseModel> list = payr0415GridPanel.getGrid().getSelectionModel().getSelectedItems();

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
								
								if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									typOccuGrdeMppgSeilNumList = "";
								}else {
									return;
								}
							}
						});
						//선택한 시스템키 넘김
					}else {
						typOccuGrdeMppgSeilNumList = checkedSystemKeys;
					}

				}*/

				param.put("payYr",  MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
				param.put("typOccuCd",  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")); 		
				String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
				param.put("dtilOccuInttnCd", strDtilOccuInttnCd);
				param.put("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"pymtDducDivCd"));
				param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		//단위기관


				payr0415GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFilePayr1500Export.do","extgwtFrame" ,param);
			}

			private void funcSetPopUpRecord() {		   
				BaseModel bmRec = new BaseModel();

				bmRec.set("payYr", MSFSharedUtils.getSelectedComboValue(createPayYr,"year")); 

				setPPRecord(bmRec);
			}

			

			public void setPPRecord(BaseModel ppRecord) {
				this.ppRecord = ppRecord;
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
