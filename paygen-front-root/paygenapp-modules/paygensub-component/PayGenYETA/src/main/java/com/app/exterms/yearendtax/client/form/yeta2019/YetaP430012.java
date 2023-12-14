
package com.app.exterms.yearendtax.client.form.yeta2019;
  

import com.app.exterms.personal.client.dto.InfcPkgPsnl0115DTO;
import com.app.exterms.personal.client.service.InfcPkgPsnl0115Service;
import com.app.exterms.personal.client.service.InfcPkgPsnl0115ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP430012   extends MSFFormPanel {  

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
 
	  private  ContentPanel cpPayr4101; 
 
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
       
//      private  ButtonBar topPayr4200Bar;
//      private  Button btnPayr4200Init;
//     // private Button btnPayr4200Save;
//      private  Button btnPayr4200Del;
//      private  Button btnPayr4200Sreach;
//      private  Button btnPayr4200Print;
//      private  Button btnPayr4200Excel;

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
        
      
//      private TextField<String> srhHanNm;         //성명
//      private TextField<String> srhResnRegnNum;   //주민번호 
//      private HiddenField<String> srhSystemkey;   //시스템키  
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */


      // ------------ 기본정보
      private HiddenField<String> dpobCd;  			/** column 사업장코드 : dpobCd */  
      private HiddenField<String> systemkey;    	/** column SYSTEMKEY : systemkey */ 
      private HiddenField<String>  pymtYrMnth;   	/** column 지급년월 : pymtYrMnth */
      private HiddenField<String>  payCd ;  		/** column 급여구분코드 : payCd */
      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */
      private HiddenField<Long> payrSeilNum;  	 	/** column 급여일련번호 : payrSeilNum */
      
      private TextField<String> deptNm;     		/** column 고용구분 : emymtDivNm */
      private HiddenField<String> emymtDivCd;   	/** column 고용구분코드 : emymtDivCd */
      
      private TextField<String> hanNm ;  			/** column 한글성명 : hanNm */
      
      
      private HiddenField<String> secRegnNum ;  	/** column 주민등록번호 : secRegnNum */
      private TextField<String> resnRegnNum;   		/** column 주민등록번호 : resnRegnNum */
      
      // ------------ 가족정보 
     
      private ComboBox<BaseModel> famyRelaDivCd; 	/** set 가족관계구분코드 : famyRelaDivCd */	
      private TextField<String>  famyNm;  			/** set 가족성명 : famyNm */
      private TextField<String> famyResnRegnNum;	/** set 가족주민등록번호 : famyResnRegnNum */
     
      private ComboBox<BaseModel> dabtyDivCd; 		/** set 장애구분코드 : dabtyDivCd */
      private ComboBox<BaseModel> dabtyGrdeCd;		/** set 장애등급코드 : dabtyGrdeCd */
      private ComboBox<BaseModel> frgnrYn;			/** set 외국인여부 : frgnrYn */
      
      
      private PrgmComBass0300DTO sysComBass0300Dto; 	//공통코드 dto

      
//      private HiddenField<String> currAffnDeptCd ;	/** column 부서코드 : deptCd */
//      private TextField<String> currAffnDeptNm ; 	/** column 부서 : deptNm */
//
//      private HiddenField<String> businCd;   		/** column 사업코드 : businCd */
//      private TextField<String> businNm;   			/** column 사업코드 : businNm */
//
//      private HiddenField<String> typOccuCd;   		/** column 직종코드 : typOccuCd */
//      private TextField<String> typOccuNm ;  		/** column 직종코드 : typOccuNm */ 
//       
//      private HiddenField<String> dtilOccuInttnCd;	/**  column 직종세구분코드 : dtilOccuInttnCd */
//      private TextField<String> dtilOccuClsDivNm;   /**  column 직종세구분코드 : dtilOccuClsDivNm */
//      private HiddenField<String>  pyspGrdeCd;  /** column 호봉등급코 : pyspGrdeCd */
      
      
//      private TextField<String> 	frstEmymtDt  ; 				/**  column 최초고용일자 : frstEmymtDt */
//      private HiddenField<String> logSvcYrNumCd ;  				/** column 근속년수코드 : logSvcYrNumCd */
//      private HiddenField<String>  logSvcMnthIcmCd  ;      	 	/**  column 근속월수코드 : logSvcYrNumNm */
//      private  TextField<String>  logSvcYrNumNm  ;    			/**  column 근속년수 : logSvcYrNumNm */
//      private  TextField<String> logSvcMnthIcmNm;     			/**  column 근속월수 : logSvcMnthIcmNm */
//      private TextField<String> 	hdofcCodtnNm;      			/**  column 재직상태코드 : hdofcCodtnNm */
//
//      private NumberField  pymtTotAmnt;   						/** column 지급총액 : pymtTotAmnt */ 
//      private NumberField extpyTotAmnt ;  						/** column 수당총액 : extpyTotAmnt */ 
//      private NumberField  txtnTotAmnt;   						/** column 과세총액 : txtnTotAmnt */ 
//      private NumberField freeDtyTotAmnt;   					/** column 비과세총액 : freeDtyTotAmnt */ 
//      private NumberField  dducTotAmnt;  						/** column 공제총액 : dducTotAmnt */ 
//      private NumberField  txTotAmnt;  							/** column 세금총액 : txTotAmnt */  
//      private NumberField  pernPymtSum ;  						/** column 차인지급액 : pernPymtSum */ 
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
 
	    private InfcPkgPsnl0115ServiceAsync infcPsnl0115Service = InfcPkgPsnl0115Service.Util.getInstance();
	    
	    private ListStore<BaseModel> lsFamyRelaDivCd 	= new ListStore<BaseModel>();	// 가족관계
	    private ListStore<BaseModel> lsDabtyDivCd 		= new ListStore<BaseModel>();	// 장애구분
	    private ListStore<BaseModel> lsDabtyGrdeCd 		= new ListStore<BaseModel>(); 	// 장애등급
	    private ListStore<BaseModel> lsFrgnrYnCd 		= new ListStore<BaseModel>(); 	// 외국인구분
  		   
	    
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
 
	  
	  public YetaP430012(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		    this.setFrame(false);
	        this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		  
	        cpPayr4101 = new ContentPanel();
		    createPayrP410002Form();  //화면 기본정보를 설정
		    createSearchForm();    //검색필드를 적용
		    createInfoForm();    //검색필드를 적용
		    createStandardForm();    //기본정보필드   
		 
		    
		    
		   
		   cpPayr4101.setBodyBorder(false);
		   cpPayr4101.setBorders(false);
		   cpPayr4101.setHeaderVisible(false);
		  //cpPayr4101.setSize("810px", "710px");  
		    
		    this.add(cpPayr4101);
		    formBinding = new FormBinding(this, true);
			this.setSize("510px", "300px");  //setSize("790px", "610px");  
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
	  private  void createPayrP410002Form() { 
		    
	 
		  cpPayr4101.setSize("490px", "280px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		     
		    
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
//			
//		    cpPayr4101.add(fieldSet); 
		   
	  }  
	  
	/** 기본사항 시작 **/  
	private void createInfoForm() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		// --------------------공통 코드 불러 오는 함수 --------------------------------------------------
		// 가족관례
		sysComBass0300Dto.setRpsttvCd("A019");
		lsFamyRelaDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		// 장애구분
		sysComBass0300Dto.setRpsttvCd("A037");
		lsDabtyDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		// 장애등급
		sysComBass0300Dto.setRpsttvCd("A036");
		lsDabtyGrdeCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		// 외국인구분
		sysComBass0300Dto.setRpsttvCd("B006");
		lsFrgnrYnCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// --------------------공통 코드 불러 오는 함수  --------------------------------------------------
		
		dpobCd = new HiddenField<String>(); // 사업장코드
		dpobCd.setName("dpobCd");
		cpPayr4101.add(dpobCd);
		
		
		systemkey = new HiddenField<String>(); // 시스템키
		systemkey.setName("systemkey");
		cpPayr4101.add(systemkey);
		
		
		payrMangDeptCd = new HiddenField<String>();
		payrMangDeptCd.setName("payrMangDeptCd");
		cpPayr4101.add(payrMangDeptCd);
		
		
		emymtDivCd = new HiddenField<String>();
		emymtDivCd.setName("emymtDivCd");
		cpPayr4101.add(emymtDivCd);
	         
	      
		
		
		FieldSet fieldSet1 = new FieldSet();
		fieldSet1.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());
		   

		LayoutContainer layoutContainer_8 = new LayoutContainer();

		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
		    
		 
		deptNm = new TextField<String>();
		deptNm.setName("deptNm");
		deptNm.setReadOnly(true);
		deptNm.setFieldLabel("부 서");
		layoutContainer_8.setBorders(false);
		layoutContainer_8.add(deptNm, new FormData("100%"));

		
		LayoutContainer layoutContainer_6 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		hanNm = new TextField<String>();
		hanNm.setName("hanNm");
		hanNm.setReadOnly(true);
		hanNm.setFieldLabel("성 명");
		
		layoutContainer_6.add(hanNm, new FormData("100%"));

		
		LayoutContainer layoutContainer_7 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		secRegnNum = new HiddenField<String>();
		secRegnNum.setName("secRegnNum");

		resnRegnNum = new TextField<String>();
		resnRegnNum.setName("resnRegnNum");
		resnRegnNum.setReadOnly(true);
		resnRegnNum.setFieldLabel("주민번호");
		layoutContainer_7.setBorders(false);
		layoutContainer_7.add(resnRegnNum, new FormData("100%"));
		    
		    
		lcSchCol1.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 고용
		lcSchCol1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));		// 성명
		lcSchCol1.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));		// 주민등록번호
		   
		    
		fieldSet1.add(lcSchCol1, new FormData("100%"));
		    
		cpPayr4101.add(fieldSet1);
	}
	 
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_2 = new FieldSet();
		// fldstNewFieldset_2.setSize(528, 120);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("가족정보");
		fldstNewFieldset_2.setCollapsible(false);

		fldstNewFieldset_2.add(occupationalFmyInfo(), new FormData("100%"));

		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);

		cpPayr4101.add(layoutContainer);
		layoutContainer.setBorders(false);

	}
	   
		 
	private LayoutContainer occupationalFmyInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FlowLayout());
		cp01.setSize(464, 160);
	  	
		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_8 = new LayoutContainer();

		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
		
		famyRelaDivCd  =  new ComboBox<BaseModel>(); 
		famyRelaDivCd.setName("famyRelaDivCd");
		famyRelaDivCd.setForceSelection(true);
		famyRelaDivCd.setAllowBlank(false);
		famyRelaDivCd.setMinChars(1);
		famyRelaDivCd.setDisplayField("commCdNm");
		famyRelaDivCd.setValueField("commCd");
		famyRelaDivCd.setTriggerAction(TriggerAction.ALL);
		famyRelaDivCd.setEmptyText("--가족관계--");
		famyRelaDivCd.setSelectOnFocus(true); 
		famyRelaDivCd.setStore(lsFamyRelaDivCd);
		famyRelaDivCd.setFieldLabel("관 계");
		lsFamyRelaDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	famyRelaDivCd.setValue(lsFamyRelaDivCd.getAt(0));
              
            }
        });  
		layoutContainer_8.add(famyRelaDivCd, new FormData("100%"));
		    
		    
		
		LayoutContainer layoutContainer_6 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		famyNm = new TextField<String>();
		famyNm.setName("famyNm");
		famyNm.setFieldLabel("성 명");
		layoutContainer_6.setBorders(false);
		layoutContainer_6.add(famyNm, new FormData("100%"));
		
		
		LayoutContainer layoutContainer_7 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		famyResnRegnNum = new TextField<String>();
		new TextFieldMask<String>(famyResnRegnNum, "999999-9999999");
		famyResnRegnNum.setName("famyResnRegnNum");
		famyResnRegnNum.setFieldLabel("주민번호");
		layoutContainer_7.setBorders(false);
		layoutContainer_7.add(famyResnRegnNum, new FormData("100%"));

		lcSchCol1.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 가족 관게
		lcSchCol1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 가족 성명
		lcSchCol1.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));	// 가족 주민등록번호

		cp01.add(lcSchCol1, new FormData("100%"));
		
		

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		dabtyDivCd  =  new ComboBox<BaseModel>(); 
		dabtyDivCd.setName("dabtyDivCd");
		dabtyDivCd.setForceSelection(true);
		dabtyDivCd.setAllowBlank(false);
		dabtyDivCd.setMinChars(1);
		dabtyDivCd.setDisplayField("commCdNm");
		dabtyDivCd.setValueField("commCd");
		dabtyDivCd.setTriggerAction(TriggerAction.ALL);
		dabtyDivCd.setEmptyText("--장애구분--");
		dabtyDivCd.setSelectOnFocus(true); 
		dabtyDivCd.setStore(lsDabtyDivCd);
		dabtyDivCd.setFieldLabel("장애구분");
		lsDabtyDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	dabtyDivCd.setValue(lsDabtyDivCd.getAt(0));
            }
        });  
		layoutContainer_10.add(dabtyDivCd, new FormData("100%"));
		
		

		LayoutContainer layoutContainer_11 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		dabtyGrdeCd  =  new ComboBox<BaseModel>(); 
		dabtyGrdeCd.setName("dabtyGrdeCd");
		dabtyGrdeCd.setForceSelection(true);
		dabtyGrdeCd.setAllowBlank(false);
		dabtyGrdeCd.setMinChars(1);
		dabtyGrdeCd.setDisplayField("commCdNm");
		dabtyGrdeCd.setValueField("commCd");
		dabtyGrdeCd.setTriggerAction(TriggerAction.ALL);
		dabtyGrdeCd.setEmptyText("--장애등급--");
		dabtyGrdeCd.setSelectOnFocus(true); 
		dabtyGrdeCd.setStore(lsDabtyGrdeCd);
		dabtyGrdeCd.setFieldLabel("장애등급");
		lsDabtyGrdeCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	dabtyGrdeCd.setValue(lsDabtyGrdeCd.getAt(0));
              
            }
        });  
		layoutContainer_11.add(dabtyGrdeCd, new FormData("100%"));

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_17.setLayout(frmlytStd);
		
		frgnrYn  =  new ComboBox<BaseModel>(); 
		frgnrYn.setName("frgnrYn");
		frgnrYn.setForceSelection(true);
		frgnrYn.setAllowBlank(false);
		frgnrYn.setMinChars(1);
		frgnrYn.setDisplayField("commCdNm");
		frgnrYn.setValueField("commCd");
		frgnrYn.setTriggerAction(TriggerAction.ALL);
		frgnrYn.setEmptyText("--외국인구분--");
		frgnrYn.setSelectOnFocus(true); 
		frgnrYn.setStore(lsFrgnrYnCd);
		frgnrYn.setFieldLabel("외국인");
		lsFrgnrYnCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	frgnrYn.setValue(lsFrgnrYnCd.getAt(0));
            }
        });  
		layoutContainer_17.add(frgnrYn, new FormData("100%"));

		layoutContainer_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 가족 장애구분
		layoutContainer_5.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 가족 장애등급
		layoutContainer_5.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));	// 가족 외국인 구분

		cp01.add(layoutContainer_5, new FormData("100%"));

		LayoutContainer layoutContainer_61 = new LayoutContainer();
		layoutContainer_61.setLayout(new ColumnLayout());
		layoutContainer_61.setBorders(false);

		LayoutContainer layoutContainer_30 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_30.setLayout(frmlytStd);

//		currAffnDeptNm = new TextField<String>();
//		currAffnDeptNm.setName("currAffnDeptNm");
//		currAffnDeptNm.setReadOnly(true);
//		layoutContainer_30.add(currAffnDeptNm, new FormData("100%"));
//		currAffnDeptNm.setFieldLabel("직장명");
//		layoutContainer_30.setBorders(false);

		LayoutContainer layoutContainer_31 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_31.setLayout(frmlytStd);

//		typOccuNm = new TextField<String>();
//		typOccuNm.setName("typOccuNm");
//		typOccuNm.setReadOnly(true);
//		layoutContainer_31.add(typOccuNm, new FormData("100%"));
//		typOccuNm.setFieldLabel("직위명");
//		layoutContainer_31.setBorders(false);

		layoutContainer_61.add(layoutContainer_30,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_61.add(layoutContainer_31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		cp01.add(layoutContainer_61, new FormData("100%"));
		    
		LayoutContainer layoutContainer_71 = new LayoutContainer();
		layoutContainer_71.setLayout(new ColumnLayout());
		layoutContainer_71.setBorders(false);

		LayoutContainer layoutContainer_33 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_33.setLayout(frmlytStd);

//		currAffnDeptNm = new TextField<String>();
//		currAffnDeptNm.setName("currAffnDeptNm");
//		currAffnDeptNm.setReadOnly(true);
//		layoutContainer_33.add(currAffnDeptNm, new FormData("100%"));
//		currAffnDeptNm.setFieldLabel("장애구분");
//		layoutContainer_33.setBorders(false);

		LayoutContainer layoutContainer_34 = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_34.setLayout(frmlytStd);

//		typOccuNm = new TextField<String>();
//		typOccuNm.setName("typOccuNm");
//		typOccuNm.setReadOnly(true);
//		layoutContainer_34.add(typOccuNm, new FormData("100%"));
//		typOccuNm.setFieldLabel("장애등급");
//		layoutContainer_34.setBorders(false);
			    
		layoutContainer_71.add(layoutContainer_33,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_71.add(layoutContainer_34,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		cp01.add(layoutContainer_71, new FormData("100%"));
		
		cp01.addButton(new Button("초기화", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
		 	    	
				// 가족정보 초기화
				subformInit();
			}
		}));
			    
			    
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				
				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(famyRelaDivCd,"commCd"))) {
					MessageBox.info("", "가족관계를 선택해 주세요", null);
					return;
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(famyRelaDivCd,"commCd"))) {
					MessageBox.info("", "가족 성명을 입력해 주세요.", null);
					return;
				}else if("".equals(MSFSharedUtils.allowNulls(famyResnRegnNum.getValue()).replaceAll("-", ""))) {
					MessageBox.info("", "가족 주민등록번호를 입력해 주세요.", null);
					return;
				}else {
					
					InfcPkgPsnl0115DTO infcPsnl0115Dto = new InfcPkgPsnl0115DTO();
					
					infcPsnl0115Dto.setDpobCd(dpobCd.getValue());    													/** column 사업장코드 : dpobCd */
					infcPsnl0115Dto.setSystemkey(systemkey.getValue());    												/** column SYSTEMKEY : systemkey */
					infcPsnl0115Dto.setFamyRelaDivCd(MSFSharedUtils.getSelectedComboValue(famyRelaDivCd,"commCd"));    	/** column 가족관계구분코드 : famyRelaDivCd */
					infcPsnl0115Dto.setFamyNm(famyNm.getValue());    													/** column 가족성명 : famyNm */
					infcPsnl0115Dto.setFamyResnRegnNum(famyResnRegnNum.getValue().replaceAll("-", ""));    				/** column 가족주민등록번호 : famyResnRegnNum */
					
					
					if("B0060002".equals(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(frgnrYn,"commCd")) ) 
						 || "B0060002" == MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(frgnrYn,"commCd")) ) {

						// 외국인
						infcPsnl0115Dto.setFrgnrYn("Y");    				/** column 외국인여부 : frgnrYn */
						
					}else {
						// 내국인 
						infcPsnl0115Dto.setFrgnrYn("N");					/** column 외국인여부 : frgnrYn */
					}
					
					infcPsnl0115Dto.setDabtyDivCd(MSFSharedUtils.getSelectedComboValue(dabtyDivCd,"commCd"));    		/** column 장애구분코드 : dabtyDivCd */
					infcPsnl0115Dto.setDabtyGrdeCd(MSFSharedUtils.getSelectedComboValue(dabtyGrdeCd,"commCd"));    		/** column 장애등급코드 : dabtyGrdeCd */
					
					actionDatabase = ActionDatabase.INSERT;
					
					
					infcPsnl0115Service.insertOnPsnl0115(infcPsnl0115Dto, actionDatabase, new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
											, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("insertOnPsnl0115("
													+ actionDatabase.name()+ ") : " + caught)
											, null);
								}

						public void onSuccess(Long result) {
							
							if(result != 0 ) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다. [가족선택(인사)] 버튼을  클릭하여 등록한 가족을 추가해 주세요.", null);
							
							}else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					                    "저장 처리가 실패하였습니다. 이미 등록되어 있는 가족인지 확인하시길 바랍니다.", null);
							}

						}
					});
				}
			}
		}));
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	   
			
	// 폼초기화 검색조건포함
	private void formInit() {

		subformInit();

		// payr0304GridPanel.getMsfGrid().clearData();

		actionDatabase = ActionDatabase.READ;
	}

	private void subformInit() {

	      famyRelaDivCd.setValue(new BaseModel()); 	/** set 가족관계구분코드 : famyRelaDivCd */	
	      famyNm.setValue("");  					/** set 가족성명 : famyNm */
	      famyResnRegnNum.setValue("");				/** set 가족주민등록번호 : famyResnRegnNum */
	     
	      dabtyDivCd.setValue(new BaseModel()); 	/** set 장애구분코드 : dabtyDivCd */
	      dabtyGrdeCd.setValue(new BaseModel());	/** set 장애등급코드 : dabtyGrdeCd */
	      frgnrYn.setValue(new BaseModel());		/** set 외국인여부 : frgnrYn */
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
