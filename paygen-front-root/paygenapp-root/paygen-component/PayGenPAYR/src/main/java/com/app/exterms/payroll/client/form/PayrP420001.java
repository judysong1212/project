/**
 * 월별급여내역
 */
package com.app.exterms.payroll.client.form;
  

import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0470DTO;
import com.app.exterms.payroll.client.form.defs.Payr0307Def;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr4200Service;
import com.app.exterms.payroll.client.service.Payr4200ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PayrP420001   extends MSFFormPanel {  

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
 
	private  ContentPanel cpPayr4200; 
	    
	//급여조정 
	private Payr0307Def payr0307Def  = new Payr0307Def("PAYRP420001");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0307GridPanel;
	    
	  
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
		private ButtonBar topPayr4200Bar;
		// private Button btnPayr4200Init;
		// private Button btnPayr4200Save;
		// private Button btnPayr4200Del;
		private Button btnPayr4200Sreach;
		// private Button btnPayr4200Print;
		private Button btnPayr4200Excel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	* 검색변수 선언 
	* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	*/
//      /** column  년도 : payYr */
//      private ComboBox<BaseModel> srhPayYr;
//      private ComboBox<BaseModel> srhPayMonth;
//      
//      private ComboBox<BaseModel> srhPayCd;     //급여구분
//      
////      private TextField<String> srhHanNm;         //성명
////      private TextField<String> srhResnRegnNum;   //주민번호 
////      private HiddenField<String> srhSystemkey;   //시스템키  
//      
//      private String oldSrhData = "";
      
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
      
		//출력물체크 
		private String rdaFileName = "";
		private String checkedSystemKeys = "";
      
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
	    
	    private ListStore<BaseModel> lsPayYrStore 		= new ListStore<BaseModel>();	// 년도 
  		private ListStore<BaseModel> lsPayMonth 		= new ListStore<BaseModel>();  	// 급여월   
  		private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>(); 	// 급여구분 
  		private ListStore<BaseModel> lsPymtDducDivCd	= new ListStore<BaseModel>(); 	// 지급공제구분코드 
  		private ListStore<BaseModel> lsPayDducExtpyCd 	= new ListStore<BaseModel>(); 	// 지급공제항목
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드  
  		private SysCoCalendarDTO msfCoCalendarDto;   
  		
	    
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
 		private void PayrP410001Print(String fileName) {
 			  // mrd 출력물
 	        rdaFileName = fileName+".mrd";
 	        // 보낼 파라미터
 	         
 			//MessageBox.confirm("급여대장", "[YES]버튼을 누르시면 전체내역인 출력됩니다.\n[NO]를 선택하시면 선택하신 데이타에 대해서만 출력됩니다.\n출력하시겠습니까?",new Listener<MessageBoxEvent>(){
 	       //     @Override
 	       //     public void handleEvent(MessageBoxEvent be) {
 	                
 	                // 출력물 디렉토리 패스경로 인사 : PSNL
 	                String strDirPath = "PAYR";
 	               
 	                //검색조건
 	            String serarchParam = "";
 	         
 	            serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";    //사업코드 $1
// 	            serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]"; //$2
// 	            serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]"; //$3
 	            serarchParam += "["+MSFSharedUtils.allowNulls(payrMangDeptCd.getValue())+"]";   //$4
 	            serarchParam += "["+MSFSharedUtils.allowNulls(emymtDivCd.getValue())+"]";    //$5
 	            serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";    //$6
 	            
 	            if (MSFSharedUtils.paramNotNull(deptCd.getValue())) {
 	              serarchParam += "['"+MSFSharedUtils.allowNulls(deptCd.getValue())+"']";//$7
 	            } else {
 	              serarchParam += "[]"; 
 	            }
 	           if (MSFSharedUtils.paramNotNull(typOccuCd.getValue())) {
 	        	  serarchParam += "['"+MSFSharedUtils.allowNulls(typOccuCd.getValue())+"']";//$8
	            } else {
	            	serarchParam += "[]"; 
	            }
// 	           if (MSFSharedUtils.paramNotNull(pyspGrdeCd.getValue())) {
// 	        	  serarchParam += "['"+MSFSharedUtils.allowNulls(pyspGrdeCd.getValue()) +"']";  //$9
//	            } else {
//	            	serarchParam += "[]"; 
//	            }
 	           if (MSFSharedUtils.paramNotNull(dtilOccuInttnCd.getValue())) {
 	        	  serarchParam += "['"+MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue()) +"']";  //$10 
	            } else {
	            	serarchParam += "[]"; 
	            }
 	             
 	            serarchParam += "["+MSFSharedUtils.allowNulls(businCd.getValue())+"]";   //$11
 	           
 	                
 	                checkedSystemKeys = "";
 	                
// 	                if("Yes".equals(be.getButtonClicked().getText())){
// 	                   
// 	                    
// 	                } else {
// 	                    
// 	                    List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
// 	                    if(list != null && list.size() > 0){
// 	                        String chkkey = "";
// 	                        for(BaseModel bm : list){
// 	                            chkkey += "'"+bm.get("systemkey")+"',";
// 	                        }
// 	                        
                          checkedSystemKeys = MSFSharedUtils.allowNulls(systemkey.getValue()); //$12
// 	                        
// 	                    }
// 	                }
 	                
 	                serarchParam = serarchParam+"['"+checkedSystemKeys+"']";
 	                
 	                //TODO 확인 
 	                if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
 	                    
 	                    serarchParam += "[]";  //$13
 	                    serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$14
 	                
 	                } else {
 	                    
 	                    //직종 권한에 대한 처리 추가 기본 처리  $9로해서 처리 할것...$13
// 	                    if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
// 	                              && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
// 	                        serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
// 	                    } else {
// 	                        serarchParam += "[]";
// 	                    } 
 	                    
 	                    serarchParam += "[]";  //$14
 	                }
 	                
 	               
 	                String strParam = "/rp " + serarchParam; 
 	              
 	                //GWT 타입으로 팝업 호출시  postCall true 설정
 	                PrintUtils.setPostCall(true);
 	                PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
 	                
 	        //    }
 	      //  });   
 			
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
 
	  
	public PayrP420001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
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

		cpPayr4200 = new ContentPanel();

		createSearchForm(); // 검색필드를 적용
		// createInfoForm(); //검색필드를 적용
		createStandardForm(); // 기본정보필드
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
	  private  void createPayrP410001Form() { 
		  
//		   ContentPanel cp01 = new ContentPanel();   
//	  	   cp01.setBodyBorder(false); 
//	  	   cp01.setHeaderVisible(false);   
//	  	   cp01.setLayout(new FitLayout());   
//	       //cp01.setVisible(false);
//	  	   cp01.setSize(0, 1);
//		   payr0304GridPanel = new MSFGridPanel(payr0304Def, false, false, false, false);
//           payr0304GridPanel.setAutoSelectFirstRecord(true);
//  	       payr0304GridPanel.setHeaderVisible(false);  
//  	       payr0304GridPanel.setBodyBorder(true);
//  	       payr0304GridPanel.setBorders(true); 
//  	       payr0304GridPanel.getBottomComponent().setVisible(false);
//  	       payr0304GridPanel.setSize(700, 1);
//  	       final Grid payr0304Grid = payr0304GridPanel.getMsfGrid().getGrid(); 
//  	       payr0304Grid.addListener(Events.CellClick,  new Listener<BaseEvent>() {
//  	            public void handleEvent(BaseEvent be) {  
//  	              if (payr0304GridPanel.getCurrentlySelectedItem() != null) {   
//  	            	  //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//                    leftPayr0304Detail(payr0304GridPanel.getCurrentlySelectedItem()); 
//                   
//  	              }
//  	            }
//  	        });  
//  	 
////	    	 payr0304GridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
////	         public void handleEvent(StoreEvent<BaseModel> be) { 
////	        	 ListStore<BaseModel>  bmLsStore = (ListStore<BaseModel>) be.getSource();//payr0304GridPanel.getMsfGrid().getStore().getModels();
////	        	 if (MSFSharedUtils.paramNotNull(bmLsStore.getModels()) && (bmLsStore.getCount() > 0)) { 
////	        		// payr0304GridPanel.getMsfGrid().setCurrentlySelectedItem(bmLsStore.getAt(0));  
////	        		// payr0304GridPanel.getMsfGrid().getGrid().fireEvent(Events.CellClick);
////	        	 } 
////	           }  
////	         });   
//		 
//	       cp01.add(payr0304GridPanel);  
//	  	   cpPayr4200.add(cp01);   
		  
	  }
	   

	  /**
	   * 검색필드 설정
	   */
//	  private  void createSearchForm() {   
//		   
//		 
//			 sysComBass0300Dto = new PrgmComBass0300DTO(); 
//			 msfCoCalendarDto = new SysCoCalendarDTO();
//			 
//			  
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 //급여구분 
//			 sysComBass0300Dto.setRpsttvCd("B015");
//			 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			  
//			 
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 //월  
//			 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
// 
//				 
//		  /**
//		   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		   * 년도 콤보박스 처리  시작
//		   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
//		   */
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
//		  		cpPayr4200.add(payYrGrid); 
//  
//		    
//		    LayoutContainer lcSchCol = new LayoutContainer();
//		    lcSchCol.setLayout(new ColumnLayout()); 
//		    
//		    FieldSet fieldSet = new FieldSet();  
//		    fieldSet.setHeadingHtml("검색조건");  
//		    //fieldSet.setCheckboxToggle(false); 
//		    
//		    LayoutContainer lcSchLeft = new LayoutContainer();
//		   // lcSchLeft.setStyleAttribute("paddingRight", "10px");
//		  
//		   
//		    
//		    LayoutContainer layoutContainer_14 = new LayoutContainer();
//		    FormLayout frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(60); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//		    layoutContainer_14.setLayout(frmlytSch);
//		    
//		    srhPayCd =  new ComboBox<BaseModel>(); 
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
//	                srhPayCd.setValue(lsPayCd.getAt(0));
//	            }
//	        });    
//	        srhPayCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//		           BaseModel bmPayCd =  se.getSelectedItem();  
//		           if (bmPayCd != null) {
//		                //조회 처리 호출 
//		        	  String payYr =  MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr");
//		        	  String payMonth =  MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month");
//		        	  String payCd =  MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd");
//		        	  if (MSFSharedUtils.paramNotNull(payMonth) && MSFSharedUtils.paramNotNull(payYr) && MSFSharedUtils.paramNotNull(payCd)) {
//		        		  if (!oldSrhData.equals((payYr + ":" + payMonth + ":" + payCd))) {
//		        			  oldSrhData = payYr + ":" + payMonth + ":" + payCd; 
//		        			  reload(); 
//		        		  }
//		        	  }
//		           }       
//		          } 
//		      });   
//	        
//	        layoutContainer_14.add(srhPayCd, new FormData("100%"));  
//		   
//		    layoutContainer_14.setBorders(false);
//		 
//		    fieldSet.add(lcSchCol, new FormData("100%"));  
//		    lcSchLeft.setLayout(new ColumnLayout());
//		    
//		    LayoutContainer layoutContainer_8 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(60); 
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
//		        	  srhPayCd.setValue(lsPayCd.getAt(0));
//		           BaseModel bmPayYr =  se.getSelectedItem(); 
//		           if (bmPayYr != null) {
//		                //조회 처리 호출 
//		        	  String payYr =  MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr");
//		        	  String payMonth =  MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month");
//		        	  String payCd =  MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd");
//		        	  if (MSFSharedUtils.paramNotNull(payMonth) && MSFSharedUtils.paramNotNull(payYr) && MSFSharedUtils.paramNotNull(payCd)) { 
//		        		  if (!oldSrhData.equals((payYr + ":" + payMonth + ":" + payCd))) {
//		        			  oldSrhData = payYr + ":" + payMonth + ":" + payCd; 
//		        			  reload(); 
//		        		  }
//		        		 
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
//		    /** column 지급년월 : Mnth */ 
//		    srhPayMonth = new ComboBox<BaseModel>();
//		    srhPayMonth.setName("srhPayMonth");
//		    srhPayMonth.setForceSelection(true);
//		    srhPayMonth.setMinChars(1);
//		    srhPayMonth.setDisplayField("monthDisp");
//		    srhPayMonth.setValueField("month");
//		    srhPayMonth.setTriggerAction(TriggerAction.ALL);
//		   // srhPayMonth.setEmptyText("--월선택--");
//		    srhPayMonth.setSelectOnFocus(true); 
//		    srhPayMonth.setReadOnly(false);
//		    srhPayMonth.setEnabled(true); 
//		    srhPayMonth.setStore(lsPayMonth);
//		    srhPayMonth.setLabelSeparator("");  
//		    srhPayMonth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//		        	  srhPayCd.setValue(lsPayCd.getAt(0));
//		           BaseModel bmPayMonth =  se.getSelectedItem(); 
//		           if (bmPayMonth != null) {
//		                //조회 처리 호출 
//	        	      String payYr =  MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr");
//		        	  String payMonth =  MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month");
//		        	  String payCd =  MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd");
//		        	  if (MSFSharedUtils.paramNotNull(payMonth) && MSFSharedUtils.paramNotNull(payYr) && MSFSharedUtils.paramNotNull(payCd)) {
//		        		  if (!oldSrhData.equals((payYr + ":" + payMonth + ":" + payCd))) {
//		        			  oldSrhData = payYr + ":" + payMonth + ":" + payCd; 
//		        			  reload(); 
//		        		  }
//		        	  }
//		        	  
//		           }       
//		          } 
//		      });   
//		    layoutContainer_9.add(srhPayMonth, new FormData("100%")); 
//		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    layoutContainer_9.setBorders(false);
//		    
//		    
//		    LayoutContainer layoutContainer_15 = new LayoutContainer();
//		    FormLayout frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_15.setLayout(frmlytStd);
//		    
//		    hdofcCodtnNm = new TextField<String>();
//		    hdofcCodtnNm.setName("hdofcCodtnNm");
//		    hdofcCodtnNm.setReadOnly(true);
//		    layoutContainer_15.add(hdofcCodtnNm, new FormData("100%"));
//		    hdofcCodtnNm.setFieldLabel("수당/공제");
//		    layoutContainer_15.setBorders(false);
//		    
//		    
//		    LayoutContainer layoutContainer_10 = new LayoutContainer();
//		   
//		    frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_10.setLayout(frmlytStd);
//		    
//		    currAffnDeptNm = new TextField<String>(); 
//		    currAffnDeptNm.setName("currAffnDeptNm");
//		    currAffnDeptNm.setReadOnly(true);
//		    layoutContainer_10.add(currAffnDeptNm, new FormData("100%"));
//		    currAffnDeptNm.setFieldLabel("조정항목"); 
//		    layoutContainer_10.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_11 = new LayoutContainer();
//		    
//		    frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_11.setLayout(frmlytStd);
//		    
//		    typOccuNm = new TextField<String>();
//		    typOccuNm.setName("typOccuNm");
//		    typOccuNm.setReadOnly(true);
//		    layoutContainer_11.add(typOccuNm, new FormData("100%"));
//		    typOccuNm.setFieldLabel("성 명"); 
//		    layoutContainer_11.setBorders(false);
//		    
//		    LayoutContainer layoutContainer = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(60); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//		    layoutContainer.setLayout(frmlytSch);
//		    layoutContainer.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_2 = new LayoutContainer();
//			layoutContainer_2.setLayout(new FlowLayout());
//			  
//			   
//			topPayr4200Bar = new ButtonBar();    
//			layoutContainer_2.add(topPayr4200Bar);
//			topPayr4200Bar.setAlignment(HorizontalAlignment.RIGHT);
//			 
//			  	
//		  	btnPayr4200Print = new Button("엑셀"); 
//		  	btnPayr4200Print.setIcon(MSFMainApp.ICONS.print16()); 
//		  	topPayr4200Bar.add(btnPayr4200Print); 
//		  	btnPayr4200Print.addListener(Events.Select, new Listener<ButtonEvent>() {
//	    		public void handleEvent(ButtonEvent e) {
//	    			//버튼 클릭시 처리 
//	    			//PayrP410001Print("PAYRT4303"); 
//	    		}
//	    	}); 
//			 
//			  	
//		    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
//		    layoutContainer_2.setBorders(false);  
//		    
//		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.20)); 
//		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15)); 
//		    lcSchCol.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		    lcSchCol.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
//		    lcSchCol.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
//		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.10));
//		    
//			
//		    cpPayr4200.add(fieldSet); 
//		   
//	  }  
	  
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

		topPayr4200Bar = new ButtonBar();
		topPayr4200Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnPayr4200Sreach = new Button("조 회");
		btnPayr4200Sreach.setIcon(MSFMainApp.ICONS.search16());
		topPayr4200Bar.add(btnPayr4200Sreach);
		btnPayr4200Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});

		btnPayr4200Excel = new Button("엑 셀");
		btnPayr4200Excel.setIcon(MSFMainApp.ICONS.excel16());
		topPayr4200Bar.add(btnPayr4200Excel);
		btnPayr4200Excel.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 버튼 클릭시 처리
				// payr0304GridPanel.callExportServlet("");
				exportExcel();
			}
		});
	 	 
		cpPayr4200.add(topPayr4200Bar);

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
	  
//	  private  void createInfoForm() {   
//		   
//	        systemkey = new HiddenField<String>();  //시스템키 
//	        systemkey.setName("systemkey");
//	        cpPayr4200.add(systemkey);
//	        payrMangDeptCd = new  HiddenField<String>(); 
//	        payrMangDeptCd.setName("payrMangDeptCd");
//	        cpPayr4200.add(payrMangDeptCd); 
//	        businCd = new  HiddenField<String>(); 
//	        businCd.setName("businCd");
//	        cpPayr4200.add(businCd);
//	        dpobCd = new HiddenField<String>();  //사업장코드 
//	        dpobCd.setName("dpobCd");
//	        cpPayr4200.add(dpobCd);
//	     //   idtlAccdtInsurApptnYn = new HiddenField<Boolean>() ; 
//	      //  logSvcExtpyApptnYn =  new HiddenField<Boolean>() ;
//	        
//	        
//	        typOccuCd = new HiddenField<String>();  /**  column 직종코드 : typOccuCd */
//	        typOccuCd.setName("typOccuCd");
//	        cpPayr4200.add(typOccuCd);
//	        dtilOccuInttnCd = new HiddenField<String>();  //사업장코드 
//	        dtilOccuInttnCd.setName("dtilOccuInttnCd");
//	        cpPayr4200.add(dtilOccuInttnCd);
//	        deptCd = new HiddenField<String>();  //사업장코드 
//	        deptCd.setName("deptCd");
//	        cpPayr4200.add(deptCd);
//	        businCd = new HiddenField<String>();  //사업장코드 
//	        businCd.setName("businCd");
//	        cpPayr4200.add(businCd);
//	      //  pyspGrdeCd = new HiddenField<String>();  //사업장코드 
//	      //  pyspGrdeCd.setName("pyspGrdeCd");
//	      //  cpPayr4200.add(pyspGrdeCd);
//	        emymtDivCd = new HiddenField<String>();
//		    emymtDivCd.setName("emymtDivCd");
//		    cpPayr4200.add(emymtDivCd);
//	        
//		    FieldSet fieldSet1 = new FieldSet();  
//		    fieldSet1.setHeadingHtml("기본정보");
//		    
//		    LayoutContainer lcSchCol1 = new LayoutContainer();
//		    lcSchCol1.setLayout(new ColumnLayout()); 
//		   
//		    
//		    LayoutContainer layoutContainer_5 = new LayoutContainer();
//		    layoutContainer_5.setLayout(new ColumnLayout());
//		    layoutContainer_5.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_14 = new LayoutContainer();
//		    FormLayout frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_14.setLayout(frmlytStd);
//		    
//		    hdofcCodtnNm = new TextField<String>();
//		    hdofcCodtnNm.setName("hdofcCodtnNm");
//		    hdofcCodtnNm.setReadOnly(true);
//		    layoutContainer_14.add(hdofcCodtnNm, new FormData("100%"));
//		    hdofcCodtnNm.setFieldLabel("고 용");
//		    layoutContainer_14.setBorders(false);
//		    
//		    
//		    LayoutContainer layoutContainer_10 = new LayoutContainer();
//		   
//		    frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_10.setLayout(frmlytStd);
//		    
//		    currAffnDeptNm = new TextField<String>(); 
//		    currAffnDeptNm.setName("currAffnDeptNm");
//		    currAffnDeptNm.setReadOnly(true);
//		    layoutContainer_10.add(currAffnDeptNm, new FormData("100%"));
//		    currAffnDeptNm.setFieldLabel("부 서"); 
//		    layoutContainer_10.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_11 = new LayoutContainer();
//		    
//		    frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_11.setLayout(frmlytStd);
//		    
//		    typOccuNm = new TextField<String>();
//		    typOccuNm.setName("typOccuNm");
//		    typOccuNm.setReadOnly(true);
//		    layoutContainer_11.add(typOccuNm, new FormData("100%"));
//		    typOccuNm.setFieldLabel("직 종"); 
//		    layoutContainer_11.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_17 = new LayoutContainer();
//		    frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_17.setLayout(frmlytStd);
//		    
//		    dtilOccuClsDivNm = new TextField<String>();
//		    dtilOccuClsDivNm.setName("dtilOccuClsDivNm");
//		    dtilOccuClsDivNm.setReadOnly(true);
//		    layoutContainer_17.add(dtilOccuClsDivNm, new FormData("100%"));
//		    dtilOccuClsDivNm.setFieldLabel("직종세"); 
//		    layoutContainer_17.setBorders(false);
//		    
//		    
//		    LayoutContainer layoutContainer_12 = new LayoutContainer();
//		    frmlytStd = new FormLayout();  
//		    frmlytStd.setLabelWidth(60); 
//		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		    layoutContainer_12.setLayout(frmlytStd);
//		    
//		    businNm = new TextField<String>();
//		    businNm.setName("businNm");
//		    businNm.setReadOnly(true);
//		    layoutContainer_12.add(businNm, new FormData("100%"));
//		    businNm.setFieldLabel("사 업"); 
//		    layoutContainer_12.setBorders(false);
//		    
//		  
//		    layoutContainer_5.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    layoutContainer_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    layoutContainer_5.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    layoutContainer_5.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    layoutContainer_5.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		   
//		    
//		    fieldSet1.add(layoutContainer_5); 
//			
//		    cpPayr4200.add(fieldSet1);  
//	  }  
	 
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

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

		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);

		cpPayr4200.add(layoutContainer);
		layoutContainer.setBorders(false);

	}
	  
	private LayoutContainer payrModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 458);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0307GridPanel = new MSFGridPanel(payr0307Def, false, false, false, false);
		payr0307GridPanel.setHeaderVisible(false);
		payr0307GridPanel.setBodyBorder(false);
		payr0307GridPanel.setBorders(true);
		payr0307GridPanel.getBottomComponent().setVisible(false);
		// payr0307GridPanel.setSize(600, 145);

		cp01.add(payr0307GridPanel);

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

//		actionDatabase = ActionDatabase.READ;
	}
			
			
	// 폼초기화 검색조건포함
	private void formInit() {

		// grid init
		payr0307GridPanel.getMsfGrid().clearData();

		actionDatabase = ActionDatabase.READ;

	}
	
	//엑셀저장함수 
	public void exportExcel() {
		// TODO Auto-generated method stub
		// payr0301GridPanel.callExportServlet("");
		HashMap<String, String> param = new HashMap<String, String>(); 
		
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
		
		param.put("pymtDducDivCd", MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd")) );	
		param.put("payItemCd",MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd")) );
		
		
		//넘어온메서드 값을 가지고 처리 한다.  
		payr0307GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayrP420001Export.do","extgwtFrame", param); 
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
	 

}
