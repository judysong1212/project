/**
 * 월별급여내역
 */
package com.app.exterms.payroll.client.form;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0307DTO_XLS;
import com.app.exterms.payroll.client.dto.Payr0470DTO;
import com.app.exterms.payroll.client.form.defs.Payr0307Def;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr4200Service;
import com.app.exterms.payroll.client.service.Payr4200ServiceAsync;
import com.app.exterms.payroll.client.service.PayrP420002Service;
import com.app.exterms.payroll.client.service.PayrP420002ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PayrP420002   extends MSFFormPanel {  

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
 
//	private  ContentPanel cpPayr4200; 
	private  FormPanel cpPayr4200; 
	    
	//급여조정 
	private Payr0307Def payr0307Def  = new Payr0307Def("PAYRP420002");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0307GridPanel;
	
	private static EditorGrid<Payr0307DTO_XLS> excelGrid;
	  
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
 		private MSFPanel caller;
 		private Boolean reading = false;
 		public FormBinding formBinding;
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
//		private ButtonBar topPayr4200Bar;
//		// private Button btnPayr4200Init;
//		// private Button btnPayr4200Save;
//		// private Button btnPayr4200Del;
//		private Button btnPayr4200Sreach;
//		// private Button btnPayr4200Print;
//		private Button btnPayr4200Excel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	* 검색변수 선언 
	* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	*/
      
		private HiddenField<String> systemkey;
		
		private HiddenField<String> dpobCd;  //사업장코드
		private HiddenField<String> srhSystemkey; // 시스템키
		
	    private HiddenField<String> payYr;   			/** column 지급년월 : pymtYrMnth */
	    private HiddenField<String> payMonth;   		/** column 지급년월 : pymtYrMnth */
	    private HiddenField<String> payCd;  			/** column 급여구분코드 : payCd */
	    private HiddenField<String> payrMangDeptCd; 	/** column 단위기관코드 : payrMangDeptCd */	      
	    private HiddenField<String> emymtDivCd;   		/** column 고용구분코드 : emymtDivCd */
		private HiddenField<String> repbtyBusinDivCd; 	// 호봉제구분코드
	    private HiddenField<String> deptCd;  			/** column 부서코드 : deptCd */
		private HiddenField<String> deptGpCd; 			// 부서직종그룹코드
	    private HiddenField<String> typOccuCd;   		/** column 직종코드 : typOccuCd */
	    private HiddenField<String> dtilOccuInttnCd;	/**  column 직종세구분코드 : dtilOccuInttnCd */
	    private HiddenField<String> businCd;   			/** column 사업코드 : businCd */

		private ComboBox<BaseModel> srhPayYr;			// 지급년
		private ComboBox<BaseModel> srhPayMonth;		// 지급월
		private ComboBox<BaseModel> srhPayCd; 			// 급여구분
		private TextField<String> srhPayrMangDeptCd; 	// 단위기관
		private TextField<String> srhHanNm; 			// 성명
		private TextField<String> srhResnRegnNum; 		// 주민번호
		private TextField<String> srhEmymtDivCd; 		// 고용구분
		private TextField<String> srhRepbtyBusinDivCd; 	// 호봉제구분코드
		private TextField<String> srhDeptCd; 			// 부서
		private TextField<String> srhDeptGpCd; 			// 부서직종그룹코드
		private TextField<String> srhTypOccuCd; 		// 직종
		private TextField<String> srhDtilOccuInttnCd; 	// 직종세
		private TextField<String> srhBusinCd; 			// 사업

		private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
		private ComboBox<BaseModel> srhPayDducExtpyCd;
		
		private FileUploadField payrP420002flUp; 		// 파일업로드처리 부분  
	    private HiddenField<String> fileKeyCode;			// 업로드를 위해 추가 
		private Boolean picBoolFile;
      
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */


//      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */ 
//      
//      private HiddenField<String>  pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
//      
//      private HiddenField<String>  payCd ;  /** column 급여구분코드 : payCd */
//
//      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */
//
//      private HiddenField<Long> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
//      
//      private HiddenField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//      private TextField<String> hanNm ;  /** column 한글성명 : hanNm */
//
//      private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//      
//      private HiddenField<String> secRegnNum;   /** column 주민등록번호 : secRegnNum */
//
//      private HiddenField<String> deptCd ;  /** column 부서코드 : deptCd */
//      private TextField<String> currAffnDeptNm ;  /** column 부서 : deptNm */
//
//      private HiddenField<String> businCd;   /** column 사업코드 : businCd */
//      private TextField<String> businNm;   /** column 사업코드 : businNm */
//
//      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//      private TextField<String> typOccuNm ;  /** column 직종코드 : typOccuNm */ 
//       
//      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
//      
//      
//    //  private HiddenField<String>  pyspGrdeCd;  /** column 호봉등급코 : pyspGrdeCd */
//       
// 
//      private TextField<String> dtilOccuClsDivNm  ;           /**  column 직종세구분코드 : dtilOccuClsDivNm */
//      private TextField<String> emymtDivNm ;                  /**  column 고용구분 : emymtDivNm */
//      
//      private TextField<String> 	frstEmymtDt  ;                         /**  column 최초고용일자 : frstEmymtDt */
//    
//      private HiddenField<String> logSvcYrNumCd ;  /** column 근속년수코드 : logSvcYrNumCd */
//      private HiddenField<String>  logSvcMnthIcmCd  ;                           /**  column 근속월수코드 : logSvcYrNumNm */
//      
//      private  TextField<String>  logSvcYrNumNm  ;                           /**  column 근속년수 : logSvcYrNumNm */
//      private  TextField<String> logSvcMnthIcmNm;                             /**  column 근속월수 : logSvcMnthIcmNm */
//      
//      private TextField<String> 	hdofcCodtnNm;                          /**  column 재직상태코드 : hdofcCodtnNm */

//      private NumberField  pymtTotAmnt;   /** column 지급총액 : pymtTotAmnt */ 
//      private NumberField extpyTotAmnt ;  /** column 수당총액 : extpyTotAmnt */ 
//      private NumberField  txtnTotAmnt;   /** column 과세총액 : txtnTotAmnt */ 
//      private NumberField freeDtyTotAmnt;   /** column 비과세총액 : freeDtyTotAmnt */ 
//      private NumberField  dducTotAmnt;   /** column 공제총액 : dducTotAmnt */ 
//      private NumberField  txTotAmnt;   /** column 세금총액 : txTotAmnt */  
//      private NumberField  pernPymtSum ;  /** column 차인지급액 : pernPymtSum */ 
      
//      private HiddenField<String> bnkCd;   /** column 은행코드 : bnkCd */
//      private HiddenField<String>  bnkNm ;  /** column 은행코드 : bnkNm */
//      private HiddenField<String> bnkAccuNum ;  /** column 은행계좌번호 : bnkAccuNum */
//      private HiddenField<String>  acntHodrNm;   /** column 예금주명 : acntHodrNm */
//
//      private HiddenField<String> payDdlneDt ;  /** column 급여마감일자 : payDdlneDt */
//      private HiddenField<String> payDdlneYn ;  /** column 급여마감여부 : payDdlneYn */
// 
//      private NumberField  pymtB10100Sum ;     /** column 기본급 : pymtB10100Sum */ 
      
//      private NumberField  pymtT10100Sum ;    /** column 소득세 : pymtT10100Sum */
//      private NumberField  pymtT20100Sum ;    /** column 주민세  : pymtT20100Sum */
      
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
 
	    private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
	    private PayrP420002ServiceAsync payr0420002Service = PayrP420002Service.Util.getInstance();
	    
	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
  		
  
  		private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분 
  		
  		
  		private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); 	//지급공제구분코드 
  		private ListStore<BaseModel>  lsPayDducExtpyCd = new ListStore<BaseModel>(); 	//지급공제항목
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드  
  		private SysCoCalendarDTO msfCoCalendarDto;   
  		
  		private Payr0307DTO_XLS payr0307Dto;
  		private ArrayList<Payr0307DTO_XLS> insertPayr0307List = new ArrayList<Payr0307DTO_XLS>();
  		
	    
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
	public PayrP420002(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
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

//		cpPayr4200 = new ContentPanel();
		cpPayr4200 = new FormPanel();
		
		
		fileKeyCode = new HiddenField<String>();
		fileKeyCode.setName("fileKeyCode");
		cpPayr4200.add(fileKeyCode);
		

		createSearchForm(); 	// 검색필드를 적용
		createInfoForm(); 		// 파일 업로드부 적용
		createStandardForm(); 	// 그리드 필드
		// createPayrP410001Form(); //화면 기본정보를 설정

		cpPayr4200.setBodyBorder(false);
		cpPayr4200.setBorders(false);
		cpPayr4200.setHeaderVisible(false);
		cpPayr4200.setSize("890px", "640px");

		this.add(cpPayr4200);
		formBinding = new FormBinding(this, true);

		this.setSize("910px", "710px");
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
	private void createPayrP410001Form() {

	}
	  
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();

		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//급여구분 
		sysComBass0300Dto.setRpsttvCd("B015");
		lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//지급공제 
		sysComBass0300Dto.setRpsttvCd("B008");
		lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월 
		lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		
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
	  					lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
	  			        	 
	  			        	//  Date today = new Date(); 
	  			        	    // A custom date format
	  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
	  			        	 
	  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
	  			      	     // srhPayYr.setValue(bm);
	  			        	//srhPayYr.setValue(lsPayYrStore.getAt(0));
	  			        	//Date today = new Date(); 
                            //DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
                            //srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
					}
	  			});
	  		}
		});
	  	  
		payYrGrid.add(payYrGridPanel);
		cpPayr4200.add(payYrGrid);		
		
		
		
		
	    systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpPayr4200.add(systemkey);
		
		dpobCd = new HiddenField<String>();	
		dpobCd.setName("dpobCd");
		cpPayr4200.add(dpobCd);
		
		
		srhSystemkey = new HiddenField<String>();	
		srhSystemkey.setName("srhSystemkey");
		cpPayr4200.add(srhSystemkey);
		
		
		payYr = new HiddenField<String>();	
		payYr.setName("payYr");
		cpPayr4200.add(payYr);
		
		payMonth = new HiddenField<String>();	
		payMonth.setName("payMonth");
		cpPayr4200.add(payMonth);
		
		payCd = new HiddenField<String>();	
		payCd.setName("payCd");
		cpPayr4200.add(payCd);
		
		payrMangDeptCd = new HiddenField<String>();	
		payrMangDeptCd.setName("payrMangDeptCd");
		cpPayr4200.add(payrMangDeptCd);
		
		emymtDivCd = new HiddenField<String>();	
		emymtDivCd.setName("emymtDivCd");
		cpPayr4200.add(emymtDivCd);
		
		deptCd = new HiddenField<String>();	
		deptCd.setName("deptCd");
		cpPayr4200.add(deptCd);
		
		typOccuCd = new HiddenField<String>();	
		typOccuCd.setName("typOccuCd");
		cpPayr4200.add(typOccuCd);
		
		dtilOccuInttnCd = new HiddenField<String>();	
		dtilOccuInttnCd.setName("dtilOccuInttnCd");
		cpPayr4200.add(dtilOccuInttnCd);
		
		businCd = new HiddenField<String>();	
		businCd.setName("businCd");
		cpPayr4200.add(businCd);
		

		cpPayr4200.setLayout(new FlowLayout());


		LayoutContainer lcSchCol = new LayoutContainer();
		// lcSchCol.setStyleAttribute("background-color","red");
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

		fieldSet.add(lcSchCol, new FormData("100%"));
		lcSchLeft.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
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
	    srhPayYr.setFieldLabel("지급년월"); 
		srhPayYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				PayrUtils.setSelectedComboValue(srhPayYr, payYr.getValue(), "payYr");
			}
		});
		layoutContainer_8.add(srhPayYr, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
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
		srhPayMonth.setEmptyText("--월선택--");
		srhPayMonth.setSelectOnFocus(true);
		srhPayMonth.setReadOnly(false);
		srhPayMonth.setEnabled(true);
		srhPayMonth.setStore(lsPayMonth);
		srhPayMonth.setHideLabel(true);
		srhPayMonth.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				PayrUtils.setSelectedComboValue(srhPayMonth, payMonth.getValue(), "month");
			} 
		});
		layoutContainer_9.add(srhPayMonth, new FormData("100%"));
		lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
		layoutContainer.setBorders(false);
		
		
		LayoutContainer layoutContainer111 = new LayoutContainer();
		layoutContainer111.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer111.setLayout(frmlytSch);
		
		srhEmymtDivCd = new TextField<String>();
		srhEmymtDivCd.setName("srhEmymtDivCd");
		srhEmymtDivCd.setFieldLabel("고용구분");
		layoutContainer111.add(srhEmymtDivCd, new FormData("100%"));
		
		layoutContainer.add(layoutContainer111,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
		
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	    layoutContainer_101.setBorders(false);
	    
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd = new TextField<String>();
		srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		srhRepbtyBusinDivCd.setLabelSeparator("");
//		srhRepbtyBusinDivCd.setFieldLabel("고용구분");
		layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	   
	    layoutContainer.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		
		

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		layoutContainer_14.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);
		
		/** column 단위기관 : payrMangDeptCd */
		srhPayrMangDeptCd = new TextField<String>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setFieldLabel("단위기관");
		layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));


		

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
		layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);

		srhResnRegnNum = new TextField<String>();
		srhResnRegnNum.setName("srhResnRegnNum");
		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
		srhResnRegnNum.setLabelSeparator("");
		// srhResnRegnNum.setFieldLabel("주민번호");
		layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	         
	         
	 	lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
	 	lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	    
	 	LayoutContainer layoutContainer_13 = new LayoutContainer();
	 	layoutContainer_13.setLayout(new ColumnLayout());
	 	    
	 	LayoutContainer layoutContainer_1 = new LayoutContainer();
	 	layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	
	 	
	 	frmlytSch = new FormLayout();  
	 	frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);
		
		srhDeptCd = new TextField<String>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setFieldLabel("부서");

		layoutContainer_1.add(srhDeptCd, new FormData("100%"));


		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setBorders(false);
	 	
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		
		layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	    
		LayoutContainer layoutContainer_10 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);

		// 직종 직종세처리
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());
		
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(80); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_211.setLayout(frmlytSch); 
       
        srhDeptGpCd = new TextField<String>();
		srhDeptGpCd.setName("srhDeptGpCd");
		srhDeptGpCd.setFieldLabel("직종");
        
        layoutContainer_211.add(srhDeptGpCd, new FormData("100%")); 
        

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);

		srhTypOccuCd = new TextField<String>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setLabelSeparator("");
//		srhTypOccuCd.setFieldLabel("직종");
		layoutContainer_21.add(srhTypOccuCd, new FormData("100%"));
	         
		LayoutContainer lcSchRight = new LayoutContainer();
		// lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lcSchRight.setLayout(frmlytSch);

		srhDtilOccuInttnCd = new TextField<String>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setLabelSeparator("");
	         
		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));
		
		
		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer_21.setBorders(false);

		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);
		
		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);

		srhBusinCd = new TextField<String>();
		srhBusinCd.setName("srhBusinCd");
		srhBusinCd.setFieldLabel("사업");
		layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		layoutContainer_4.setBorders(false);
		
		fieldSet.add(layoutContainer_13);
		
		
		
	 	LayoutContainer layoutContainer_15 = new LayoutContainer();
	 	layoutContainer_15.setLayout(new ColumnLayout());
	 	layoutContainer_15.setBorders(false);
	 	
	 	
	 	LayoutContainer layoutContainer_16 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytSch);
		
		srhPayCd = new ComboBox<BaseModel>();
		srhPayCd.setName("srhPayCd");
		srhPayCd.setForceSelection(true);
		srhPayCd.setMinChars(1);
		srhPayCd.setDisplayField("commCdNm");
		srhPayCd.setValueField("commCd");
		srhPayCd.setTriggerAction(TriggerAction.ALL);
		srhPayCd.setEmptyText("--급여구분선택--");
		srhPayCd.setSelectOnFocus(true);
		srhPayCd.setReadOnly(false);
		srhPayCd.setEnabled(true);
		srhPayCd.setStore(lsPayCd);
		srhPayCd.setFieldLabel("급여구분");
		srhPayCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				PayrUtils.setSelectedComboValue(srhPayCd, payCd.getValue(), "commCd");
			}
		});
		
	        
	         
		layoutContainer_16.add(srhPayCd, new FormData("100%"));
		
	 	layoutContainer_15.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	
	 	
	 	
	 	LayoutContainer layoutContainer_17 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_17.setLayout(frmlytSch);
	 	
	    srhPymtDducDivCd = new ComboBox<BaseModel>(); 
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
	    srhPymtDducDivCd.setFieldLabel("지급공제구분");  
	    srhPymtDducDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		
	    		Payr0470DTO payr0470Dto = new Payr0470DTO();
	    		
	    		payr0470Dto.setPymtDducDivCd(PayrUtils.getSelectedComboValue(srhPymtDducDivCd, "commCd"));
	    		
	    		//지급공제구분 선택에 따라 지급공제항목을 가져옴
	    	    payr4200Service.getPayDducExtpyCd(payr0470Dto, new AsyncCallback<List<BaseModel>>() {
	    	    	
	    			@Override
	    			public void onFailure(Throwable caught) {
	    				// TODO Auto-generated method stub
	    				Window.alert("오류 : " + caught);
	    			}

	    			@Override
	    			public void onSuccess(List<BaseModel> result) {
	    				// TODO Auto-generated method stub
	    				
	    				// -- 초기화 -- 
	    				srhPayDducExtpyCd.setStore(new ListStore<BaseModel>());
	    				srhPayDducExtpyCd.setValue(new BaseModel());
	    				lsPayDducExtpyCd.removeAll();
	    				// -- 초기화 -- 
	    				
	    				lsPayDducExtpyCd.add(result);
	    				srhPayDducExtpyCd.setStore(lsPayDducExtpyCd); 
	    			}
	    	    });
	    	} 
	    });  
		layoutContainer_17.add(srhPymtDducDivCd, new FormData("100%"));
		layoutContainer_15.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
	 	LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytSch);
	 	
		srhPayDducExtpyCd = new ComboBox<BaseModel>(); 
		srhPayDducExtpyCd.setForceSelection(true);
		srhPayDducExtpyCd.setMinChars(1);
		srhPayDducExtpyCd.setDisplayField("commCdNm");
		srhPayDducExtpyCd.setValueField("commCd");
		srhPayDducExtpyCd.setTriggerAction(TriggerAction.ALL);
		srhPayDducExtpyCd.setEmptyText("--지급공제구분선택--");
		srhPayDducExtpyCd.setSelectOnFocus(true); 
		srhPayDducExtpyCd.setReadOnly(false);
		srhPayDducExtpyCd.setEnabled(true); 
		srhPayDducExtpyCd.setStore(new ListStore<BaseModel>()); 
		srhPayDducExtpyCd.setFieldLabel("지급공제항목");  
		
		layoutContainer_18.add(srhPayDducExtpyCd, new FormData("100%"));
		layoutContainer_15.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	 	
	 	
	 	fieldSet.add(layoutContainer_15);
	 	
		
		cpPayr4200.add(fieldSet);
		
	  } 
	  
	private void createInfoForm() {
		  
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("");
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
		    
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_21.setLayout(frmlytSch);
	    layoutContainer_21.setBorders(false);
	    
		payrP420002flUp = new FileUploadField();
		payrP420002flUp.setFieldLabel("조정내역");
		payrP420002flUp.setName("payrP420002flUp");
		payrP420002flUp.setValidator(new Validator() {  
			@Override 
			public String validate(Field<?> field, String value) { 
				value = value.toLowerCase();        
				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
				if(value.endsWith(".xls") ){           
					result = null;        
             	}        
				return result;  
        	} 
		});
		payrP420002flUp.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				excelGrid.getStore().removeAll();
			}
	    });
		
		
		layoutContainer_21.add(payrP420002flUp, new FormData("100%"));

		  
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnButton01 = new Button("업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
               	xlsImportData(); 
			}
		});
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_42 = new LayoutContainer(); 
		//layoutContainer_42.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_42.setLayout(frmlytSch);
		
		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		}); 
		layoutContainer_42.add(btnButton02, new FormData("100%"));
		layoutContainer_42.setBorders(false);
		
		layoutContainer_2.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_42,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
//		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer.add(layoutContainer_1);
		fldstNewFieldset.add(layoutContainer);
		
		cpPayr4200.add(fldstNewFieldset);
	  
	}
	 
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
//		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_1 = new FieldSet();
		// fldstNewFieldset_1.setSize(628, 320);

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("급여조정내역");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.add(payrModiListInfo(), new FormData("100%"));

//		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button button = new Button("저 장");
		button.setWidth(150);
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(excelGrid.getStore().getCount() <= 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"저장할 데이터가 없습니다.</BR> 먼저 엑셀 파일을 업로드 해주세요.", null);
		        	return;
				}else {
					xlsSaveData();  
				}
			}
		}); 
		btnBar.add(button);
		layoutContainer_3_1.add(btnBar);
		
		layoutContainer_3.add(layoutContainer_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.99));
		
		
		layoutContainer.add(layoutContainer_3);
		 

		cpPayr4200.add(layoutContainer);
		layoutContainer.setBorders(false);

	}
	  
	private LayoutContainer payrModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 410);
		cp01.setScrollMode(Scroll.AUTO);  
		
	    //그리드 작업
	    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
	    
		CheckColumnConfig checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dateChk");
//		checkcolumn.setHeaderText("데이터");
//		checkColumn.setWidth(40);
//		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
//		checkColumn.setEditor(checkBoxEditor);
//	    checkColumn.setMenuDisabled(true);
//	   // checkColumn.setFixed(true);
//	    columns.add(checkColumn);
	    
	    
	    ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("순번");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("dataChk");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("데이터");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("pymtYrMnth");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("지급년월");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("payCdNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("급여구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("payCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("급여구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("pymtDducDivCdNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("지급공제구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("pymtDducDivCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("지급공제구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("payItemCdNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("급여항목");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("payItemCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("급여항목");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("hanNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("resnRegnNum");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("주민등록번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("deptCdNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("deptCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setHidden(true);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		NumberField numberField = new NumberField();
		numberField.setFormat(NumberFormat.getDecimalFormat());
		numberField.setAllowDecimals(true); 
		
		
		column = new ColumnConfig();
		column.setId("pymtDducFreeDtySum");
		column.setHeaderText("비과세금액");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setEditor(new CellEditor(numberField));
		column.setNumberFormat(NumberFormat.getDecimalFormat());
		column.setMenuDisabled(true);
		columns.add(column);
		
		numberField = new NumberField();
		numberField.setFormat(NumberFormat.getDecimalFormat());
		numberField.setAllowDecimals(true); 
		
		
		column = new ColumnConfig();
		column.setId("pymtDducSum");
		column.setHeaderText("금액");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setEditor(new CellEditor(numberField));
		column.setNumberFormat(NumberFormat.getDecimalFormat());
		column.setMenuDisabled(true);
		columns.add(column);
		
		numberField = new NumberField();
		numberField.setFormat(NumberFormat.getDecimalFormat());
		numberField.setAllowDecimals(true); 
		
		
		column = new ColumnConfig();
		column.setId("pymtDducTxtnAmnt");
		column.setHeaderText("과세금액");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setEditor(new CellEditor(numberField));
		column.setNumberFormat(NumberFormat.getDecimalFormat());
		column.setMenuDisabled(true);
		columns.add(column);
		
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("mnthPayAdmntYn");
//		checkcolumn.setHeaderText("소득세");
//		checkColumn.setWidth(60);
//		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
//		checkColumn.setEditor(checkBoxEditor);
//	    checkColumn.setMenuDisabled(true);
//	   // checkColumn.setFixed(true);
//	    columns.add(checkColumn);
		
		column = new ColumnConfig();
		column.setId("mnthPayAdmntYn");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("소득세");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setHidden(true);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
	    
		column = new ColumnConfig();
		column.setId("mnthPayAdmntAssoBssCtnt");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("조정사유");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("dtilOccuInttnCdNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("직종세");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("dtilOccuInttnCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("직종세");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setSortable(false);
		column.setHidden(true);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("businCdNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("사업");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("businCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("사업");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setHidden(true);
		column.setMenuDisabled(true);
		columns.add(column);
		
		ColumnModel cm = new ColumnModel(columns);
		excelGrid = new EditorGrid<Payr0307DTO_XLS>(new ListStore<Payr0307DTO_XLS>(), cm);
		excelGrid.setLoadMask(true);
		excelGrid.setBorders(true);
		excelGrid.setStateful(false);
//		excelGrid.setAutoExpandColumn("resnRegnNum");
		excelGrid.setHeight(485);
		//excelGrid.getView().setAutoFill(true);
		
		cp01.add(excelGrid);
		
		

//		// msfCustomForm.setHeaderVisible(false);
//		// Instantiate the GridPanel
//		payr0307GridPanel = new MSFGridPanel(payr0307Def, false, false, false,false);
//		payr0307GridPanel.setHeaderVisible(false);
//		payr0307GridPanel.setBodyBorder(true);
//		payr0307GridPanel.setBorders(true);
//		payr0307GridPanel.getBottomComponent().setVisible(false);
//		// payr0307GridPanel.setSize(600, 145);
//		cp01.add(payr0307GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	  
	  
		   
	public void reload() {
		// TODO Auto-generated method stub
		formInit();
		IColumnFilter filters = null;
		payr0307GridPanel.getTableDef().setTableColumnFilters(filters);
				 
		payr0307GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0307GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0307GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.allowNulls( payrMangDeptCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0307GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.allowNulls( emymtDivCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 		
		payr0307GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls( deptCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 				
		payr0307GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.allowNulls( typOccuCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 	
		payr0307GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls( dtilOccuInttnCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);		
		payr0307GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.allowNulls( businCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);	
		payr0307GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls( srhHanNm.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);	
		payr0307GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0307GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0307GridPanel.getTableDef().addColumnFilter("payItemCd", MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
			 
		payr0307GridPanel.reload();

		actionDatabase = ActionDatabase.READ;
	}
			
			
	// 폼초기화 검색조건포함
	private void formInit() {

		// grid init
		payr0307GridPanel.getMsfGrid().clearData();

		actionDatabase = ActionDatabase.READ;

	}
	
	
	//엑셀 양식 저장
	private void xlsExportData() {
			                    
		HashMap<String, String> param = new HashMap<String, String>(); 
			   
		
        if("".equals(MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd ,"commCd"))) {
        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"지급공제항목을 선택해주세요.", null);
        	return;
        }
		
		payr0307GridPanel = new MSFGridPanel(payr0307Def, false, false, false,false);
		
        
		param.put("pymtYrMnth", MSFSharedUtils.allowNulls(( MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")))); 
		param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd") ); 
		param.put("payrMangDeptCd", MSFSharedUtils.allowNulls( payrMangDeptCd.getValue() )); 
		param.put("emymtDivCd", MSFSharedUtils.allowNulls( emymtDivCd.getValue() )); 		
		param.put("deptCd", MSFSharedUtils.allowNulls( deptCd.getValue() )); 				
		param.put("typOccuCd", MSFSharedUtils.allowNulls( typOccuCd.getValue() )); 	
		param.put("dtilOccuInttnCd", MSFSharedUtils.allowNulls( dtilOccuInttnCd.getValue() ));		
		param.put("businCd", MSFSharedUtils.allowNulls( businCd.getValue() ));	
		param.put("hanNm", MSFSharedUtils.allowNulls( srhHanNm.getValue() ));	
		param.put("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
		
		param.put("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"));	
		param.put("payDducExtpyCd",MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd"));
		
			                     
        payr0307GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayrP420002Export.do","extgwtFrame", param);   
        
	}	
	
	
	//급여일괄조정 업로드
	private void xlsImportData() {
		
//  		String filename = MSFSharedUtils.allowNulls(payrP420002flUp.getValue());
		String flUpNm = MSFSharedUtils.allowNulls(payrP420002flUp.getValue());
		
  		if (flUpNm.length() == 0) {
  			Window.alert("선택된 파일이 없습니다.");
    	} else {
    		//submit the form
//    		cpPayr4200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
    		
//    		HttpServletRequest request;
    		
    		flUpNm = flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    		int pos = flUpNm.lastIndexOf(".");							// 기존파일명에서 확장자의 위치를 가져온다.
    		flUpNm = flUpNm.substring(pos + 1);							// 확장자만 잘라서 당아줌.
    		
//    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
//    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + DateTimeFormat.getFormat("yyyyMMddhhmiss").format(new Date()) + "_" + flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + DateTimeFormat.getFormat("yyyyMMddhhmiss").format(new Date()) + "." + flUpNm;
    		
    		
//    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    		fileKeyCode.setValue(filename);
 
    		
    		final Tracker tracker = new Tracker();
            tracker.setStatus(false);
    		
            final MessageBox box = MessageBox.wait("업로드 중", "엑셀 데이터 업로드 중입니다....", "업로드 중...");
            final Timer t = new Timer()
            {
                public void run()
                {
                    if (tracker.getStatus())
                    {
                        cancel();
                        box.close();
                    }
                }
            };
            t.scheduleRepeating(500);
            
            
            cpPayr4200.setAction(GWT.getHostPageBaseURL() + "upload/XlsFileUpload.do"); 
            cpPayr4200.setEncoding(Encoding.MULTIPART);
            cpPayr4200.setMethod(Method.POST);
            cpPayr4200.submit();
            cpPayr4200.onFrameLoad(); 
            picBoolFile = true;
            
            cpPayr4200.addListener(Events.Submit, new Listener<FormEvent>() {
	              public void handleEvent(FormEvent evt) {  
	                  if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                	  
	                	  box.close();
	                	  picBoolFile = false;
	                	  
	              		// 데이터 업로드
	          			payr0420002Service.getPayrP420002ExcelData(filename, new AsyncCallback<List<HashMap<String,String>>>() {

	          				@Override
	          				public void onFailure(Throwable caught) {
	          					cpPayr4200.unmask();
	          					
	          					// TODO Auto-generated method stub
	          					MessageBox.alert("", "Excel파일이 아니거나 양식이 잘못되었습니다.", null);
	          				}

	          				@Override
	          				public void onSuccess(List<HashMap<String, String>> result) {
	          					// TODO Auto-generated method stub
	          					if(result.size() > 0){
	          						excelGrid.getStore().removeAll();
	          						excelGrid.stopEditing(false);
	          						
	          						insertPayr0307List = new ArrayList<Payr0307DTO_XLS>();
	          						
	          						for(int i = 0; i < result.size(); i++){
	          							
	          							payr0307Dto = new Payr0307DTO_XLS();
	          							
	          							payr0307Dto.setRnum(result.get(i).get("rnum"));
	          							payr0307Dto.setSystemkey(result.get(i).get("systemkey"));
	          							payr0307Dto.setDataChk(result.get(i).get("dataChk"));
	          							payr0307Dto.setPymtYrMnth(result.get(i).get("pymtYrMnth"));
	          							payr0307Dto.setPayCdNm(result.get(i).get("payCdNm"));
	          							payr0307Dto.setPayCd(result.get(i).get("payCd"));
	          							payr0307Dto.setPymtDducDivCdNm(result.get(i).get("pymtDducDivCdNm"));
	          							payr0307Dto.setPymtDducDivCd(result.get(i).get("pymtDducDivCd"));
	          							payr0307Dto.setPayItemCdNm(result.get(i).get("payItemCdNm"));
	          							payr0307Dto.setPayItemCd(result.get(i).get("payItemCd"));
	          							payr0307Dto.setHanNm(result.get(i).get("hanNm"));
	          							payr0307Dto.setResnRegnNum(result.get(i).get("resnRegnNum"));
	          							payr0307Dto.setDeptCdNm(result.get(i).get("deptCdNm"));
	          							payr0307Dto.setDeptCd(result.get(i).get("deptd"));
	          							payr0307Dto.setPymtDducFreeDtySum(Double.parseDouble(MSFSharedUtils.defaultNulls(result.get(i).get("pymtDducFreeDtySum"), "0")) );
	          							payr0307Dto.setPymtDducSum(Double.parseDouble(MSFSharedUtils.defaultNulls(result.get(i).get("pymtDducSum"), "0")));
	          							payr0307Dto.setPymtDducTxtnAmnt(Double.parseDouble(MSFSharedUtils.defaultNulls(result.get(i).get("pymtDducTxtnAmnt"), "0")));
	          							payr0307Dto.setMnthPayAdmntYn(MSFSharedUtils.defaultNulls(result.get(i).get("mnthPayAdmntYn"), "N"));
	          							payr0307Dto.setMnthPayAdmntAssoBssCtnt(result.get(i).get("mnthPayAdmntAssoBssCtnt"));
	          							payr0307Dto.setDtilOccuInttnCdNm(result.get(i).get("dtilOccuInttnCdNm"));
	          							payr0307Dto.setDtilOccuInttnCd(result.get(i).get("dtilOccuInttnCd"));
	          							payr0307Dto.setBusinCdNm(result.get(i).get("businCdNm"));
	          							payr0307Dto.setBusinCd(result.get(i).get("businCd"));
	          							
	          							excelGrid.getStore().insert(payr0307Dto, i);
	          							insertPayr0307List.add(payr0307Dto);
	          							
	          						}
	          						excelGrid.getStore().commitChanges();
	          					}else{
	          						
	          						MessageBox.alert("", "Excel파일이 아니거나 양식이 잘못되었습니다.", null);
	          					}
	          				}
	          			});  
	                	  
                            
	                  } else {
	                      //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
	                      evt.setResultHtml("");
	                  }
	              };
            });
    		
    	}    	
	}
	
	
	//급여일괄조정 업로드
	private void xlsSaveData() {
		
  		String filename = MSFSharedUtils.allowNulls(payrP420002flUp.getValue());
  		if (filename.length() == 0) {
  			Window.alert("선택된 파일이 없습니다.");
    	} else {
    		MessageBox.confirm("일괄 등록", "저장 시 기존에 조정 등록된 수당(공제)항목은 삭제 후 저장됩니다. \n 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
    			@Override
    			public void handleEvent(MessageBoxEvent be) {
                	  
    				// TODO Auto-generated method stub
//    				Info.display("", excelGrid.getStore().getCount()+"");
    				
//        			ArrayList<Payr0307DTO_XLS> insertPayr0307List = new ArrayList<Payr0307DTO_XLS>();
//        			for ( int i = 0; i < excelGrid.getStore().getCount(); i++){
//        				if("X".equals(excelGrid.getStore().getAt(i).get("dataChk")) || "X" == excelGrid.getStore().getAt(i).get("dataChk")) {
//        					
//        				}else {
//        					
//        					// 그리드 데이터 'O'인 데이터를 'Y'로 변경 후 INSERT 해줌
////        					Payr0307DTO_XLS payr0307Dto = new Payr0307DTO_XLS();
//        					
////        					payr0307Dto.setDataChk("Y");
////        					excelGrid.getStore().getAt(i).update(payr0307Dto);
//        					
//        					excelGrid.getStore().getAt(i).set("dataChk", "V");
//        					
////        					excelGrid.getStore().update(payr0307Dto);
////        					excelGrid.getStore().insert(payr0307Dto, i);
////        					excelGrid.getStore().getAt(i).Update();
//        					insertPayr0307List.add(excelGrid.getStore().getAt(i));
//        					excelGrid.getStore().update(payr0307Dto);
//        					
////        					excelGrid.getView().
//        					
//        					excelGrid.getStore().commitChanges();
//   							System.out.println("무슨 값 -> " + excelGrid.getStore().getAt(i).get("dataChk"));
//        				}
//        			}
        				
        			payr0420002Service.updateXlsPayr0307ToP420002(insertPayr0307List, new AsyncCallback<List<Payr0307DTO_XLS>>() {
       					@Override
       					public void onSuccess(List<Payr0307DTO_XLS> result) {
       						// TODO Auto-generated method stub
       						if(0 >= result.size()){
       							MessageBox.info("저장실패", "조정 내역 저장이 실패 하였습니다. \n 데이터를 확인해주세요.", null);
//       							payrP420002flUp.setValue("");
       							payrP420002flUp.reset();
       						}else{
       							
       							//그리드 확인
//       							excelGrid.getStore().commitChanges();
       							
       							excelGrid.getStore().removeAll();
       							//Info.display("REMOVE = excelGrid.getStore().getCount()", excelGrid.getStore().getCount()+"");
       							excelGrid.stopEditing(false);
       							
       							for(int i = 0; i < result.size(); i++){
       								
       								payr0307Dto = new Payr0307DTO_XLS();
       								
       								payr0307Dto.setRnum(MSFSharedUtils.allowNulls(result.get(i).get("rnum")) );
       								payr0307Dto.setSystemkey(MSFSharedUtils.allowNulls(result.get(i).get("systemkey")));
       								payr0307Dto.setDataChk(MSFSharedUtils.allowNulls(result.get(i).get("dataChk")));
       								payr0307Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(result.get(i).get("pymtYrMnth")));
       								payr0307Dto.setPayCdNm(MSFSharedUtils.allowNulls(result.get(i).get("payCdNm")));
       								payr0307Dto.setPayCd(MSFSharedUtils.allowNulls(result.get(i).get("payCd")));
       								payr0307Dto.setPymtDducDivCdNm(MSFSharedUtils.allowNulls(result.get(i).get("pymtDducDivCdNm")));
       								payr0307Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(result.get(i).get("pymtDducDivCd")));
       								payr0307Dto.setPayItemCdNm(MSFSharedUtils.allowNulls(result.get(i).get("payItemCdNm")));
       								payr0307Dto.setPayItemCd(MSFSharedUtils.allowNulls(result.get(i).get("payItemCd")));
       								payr0307Dto.setHanNm(MSFSharedUtils.allowNulls(result.get(i).get("hanNm")));
       								payr0307Dto.setResnRegnNum(MSFSharedUtils.allowNulls(result.get(i).get("resnRegnNum")));
       								payr0307Dto.setDeptCdNm(MSFSharedUtils.allowNulls(result.get(i).get("deptCdNm")));
       								payr0307Dto.setDeptCd(MSFSharedUtils.allowNulls(result.get(i).get("deptd")));
       								payr0307Dto.setPymtDducFreeDtySum(Double.parseDouble(MSFSharedUtils.defaultNulls(result.get(i).get("pymtDducFreeDtySum"), "0")) );
       								payr0307Dto.setPymtDducSum(Double.parseDouble(MSFSharedUtils.defaultNulls(result.get(i).get("pymtDducSum"), "0")));
       								payr0307Dto.setPymtDducTxtnAmnt(Double.parseDouble(MSFSharedUtils.defaultNulls(result.get(i).get("pymtDducTxtnAmnt"), "0")));
       								payr0307Dto.setMnthPayAdmntYn(MSFSharedUtils.defaultNulls(result.get(i).get("mnthPayAdmntYn"), "N"));
       								payr0307Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(result.get(i).get("mnthPayAdmntAssoBssCtnt")));
       								payr0307Dto.setDtilOccuInttnCdNm(MSFSharedUtils.allowNulls(result.get(i).get("dtilOccuInttnCdNm")));
       								payr0307Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(result.get(i).get("dtilOccuInttnCd")));
       								payr0307Dto.setBusinCdNm(MSFSharedUtils.allowNulls(result.get(i).get("businCdNm")));
       								payr0307Dto.setBusinCd(MSFSharedUtils.allowNulls(result.get(i).get("businCd")));

       								excelGrid.getStore().insert(payr0307Dto, i);
       								
       							}
       							
       							excelGrid.getStore().commitChanges();
       							
       							MessageBox.info("저장완료", "조정 내역이 총("+result.size()+")건이 저장되었습니다.", null);
//       							payrP420002flUp.setValue("");
       							payrP420002flUp.reset();
       						}
       						
       					}
       					
       					@Override
       					public void onFailure(Throwable caught) {
       						// TODO Auto-generated method stub
       						MessageBox.info("저장실패", "급여조정내역 저장이 실패 하였습니다.", null);
       						payrP420002flUp.reset();
       					}
       				}); 
    			}
    		});
    	}    	
	}
	
			    
   	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {

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
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	}  
	 

}
