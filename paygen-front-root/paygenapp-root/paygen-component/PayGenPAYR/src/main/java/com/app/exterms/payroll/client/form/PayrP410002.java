
package com.app.exterms.payroll.client.form;
  

import com.app.exterms.payroll.client.dto.Payr0302BM;
import com.app.exterms.payroll.client.form.defs.Payr0302Def;
import com.app.exterms.payroll.client.form.defs.Payr0304Def;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel.MSFGridType;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PayrP410002   extends MSFFormPanel {  

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
	  
	  //급여정보 
	  private Payr0304Def payr0304Def  = new Payr0304Def("PAYRP410002");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0304GridPanel;
	  
	    //수당 
	  private Payr0302Def payr0302ExtpyDef  = new Payr0302Def("PAYR4200EXTPY");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0302ExtpyGridPanel; 
	  
	    //공제 
	  private Payr0302Def payr0302DducDef  = new Payr0302Def("PAYR4200DDUC");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0302DducGridPanel;
   
	    
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


      private HiddenField<String> dpobCd;  //사업장코드
      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */ 
      
      private HiddenField<String>  pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
      
      private HiddenField<String>  payCd ;  /** column 급여구분코드 : payCd */

      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */

      private HiddenField<Long> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
      
      private HiddenField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
      
      private HiddenField<String>  repbtyBusinDivCd;   /** column 호봉제구분코드 : repbtyBusinDivCd */
      private TextField<String> repbtyBusinDivNm ;         /**  column 호봉제구분코드 : repbtyBusinDivNm */
      
      
      private HiddenField<String>  deptGpCd;   /** column 부서직종그룹코드 : deptGpCd */
      private TextField<String> deptGpNm ;         /**  column 부서직종그룹코드 : deptGpNm */

      private TextField<String> hanNm ;  /** column 한글성명 : hanNm */

      private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
      
      private HiddenField<String> secRegnNum;   /** column 주민등록번호 : secRegnNum */
      

      private HiddenField<String> currAffnDeptCd ;  /** column 부서코드 : deptCd */
      private TextField<String> currAffnDeptNm ;  /** column 부서 : deptNm */

      private HiddenField<String> businCd;   /** column 사업코드 : businCd */
      private TextField<String> businNm;   /** column 사업코드 : businNm */

      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
      private TextField<String> typOccuNm ;  /** column 직종코드 : typOccuNm */ 
       
      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
      
      
  //    private HiddenField<String>  pyspGrdeCd;  /** column 호봉등급코 : pyspGrdeCd */
       
 
      private TextField<String> dtilOccuClsDivNm  ;           /**  column 직종세구분코드 : dtilOccuClsDivNm */
      private TextField<String> emymtDivNm ;                  /**  column 고용구분 : emymtDivNm */
      
      private TextField<String> 	frstEmymtDt  ;                         /**  column 최초고용일자 : frstEmymtDt */
    
      private HiddenField<String> logSvcYrNumCd ;  /** column 근속년수코드 : logSvcYrNumCd */
      private HiddenField<String>  logSvcMnthIcmCd  ;                           /**  column 근속월수코드 : logSvcYrNumNm */
      
      private  TextField<String>  logSvcYrNumNm  ;                           /**  column 근속년수 : logSvcYrNumNm */
      private  TextField<String> logSvcMnthIcmNm;                             /**  column 근속월수 : logSvcMnthIcmNm */
      
      private TextField<String> 	hdofcCodtnNm;                          /**  column 재직상태코드 : hdofcCodtnNm */

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
 
	  
	  public PayrP410002(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
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
		 
		    
		    /**
		     * TODO 급여대상자에 따른 수당,공제,급여조정부분을 자동으로 불러오는 부분을 추가 한다...단계별진행........
	          * Create the relations 
	          */
			   final RelationDef  relPayr030401 = new RelationDef(payr0304Def,false);
			   relPayr030401.addJoinDef("pymtYrMnth", "pymtYrMnth");
			   relPayr030401.addJoinDef("dpobCd", "dpobCd");
			   relPayr030401.addJoinDef("systemkey", "systemkey");
			   relPayr030401.addJoinDef("payCd", "payCd");
			   relPayr030401.addJoinDef("payrSeilNum", "payrSeilNum"); 
			   relPayr030401.setLinkedObject(payr0304GridPanel);
			   payr0302ExtpyDef.addRelation(relPayr030401);  
 
	           // DETAILS 
	           final Grid payr0304Grid01 = payr0304GridPanel.getMsfGrid().getGrid();
	           payr0304Grid01.addListener(Events.CellClick, new Listener<BaseEvent>() {
	              public void handleEvent(BaseEvent be) {  
	            	  if (payr0304GridPanel.getCurrentlySelectedItem() != null) {  
                       
	            		  payr0302ExtpyDef.synchronizeGridDetail(
	            				  payr0304GridPanel.getCurrentlySelectedItem(),
	            				  payr0302ExtpyGridPanel );  
		              	
	            		 // payr0302ExtpyGridPanel.reload(); 
	            	   }
	            	  
	            	 
	            	 
	            	   
	              }
	          }); 
	           
	           
			   final RelationDef  relPayr030402 = new RelationDef(payr0304Def,false);
			   relPayr030402.addJoinDef("pymtYrMnth", "pymtYrMnth");
			   relPayr030402.addJoinDef("dpobCd", "dpobCd");
			   relPayr030402.addJoinDef("systemkey", "systemkey");
			   relPayr030402.addJoinDef("payCd", "payCd");
			   relPayr030402.addJoinDef("payrSeilNum", "payrSeilNum"); 
			   relPayr030402.setLinkedObject(payr0304GridPanel);
			   payr0302DducDef.addRelation(relPayr030402);   
	           
	 
	           // DETAILS 
	           final Grid payr0304Grid02 = payr0304GridPanel.getMsfGrid().getGrid();
	           payr0304Grid02.addListener(Events.CellClick, new Listener<BaseEvent>() {
	              public void handleEvent(BaseEvent be) {  
	            	  if (payr0304GridPanel.getCurrentlySelectedItem() != null) { 
	            		 
	            		  payr0302DducDef.synchronizeGridDetail(
	            				  payr0304GridPanel.getCurrentlySelectedItem(),
	            				  payr0302DducGridPanel ); 
	            		   
	            		 // payr0302DducGridPanel.reload(); 
	            	   }
	            	  
	             
	                
	              }
	          }); 
		   
		   cpPayr4101.setBodyBorder(false);
		   cpPayr4101.setBorders(false);
		   cpPayr4101.setHeaderVisible(false);
		  //cpPayr4101.setSize("810px", "710px");  
		    
		    this.add(cpPayr4101);
		    formBinding = new FormBinding(this, true);
			this.setSize("810px", "710px");  //setSize("790px", "610px");  
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
		   
		  
		         
	 
		  cpPayr4101.setSize("790px", "640px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		    
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
		  			         
		  			        	srhPayYr.setValue(lsPayYrStore.getAt(0)); 
	                       
		  			          }  
		  			        });  
		  			       
		  			      }  
		  			    });  
		  	  
		  		payYrGrid.add(payYrGridPanel); 
		  		cpPayr4101.add(payYrGrid); 
  
		    
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
			
		    //fieldSet.setCheckboxToggle(false); 
		    
		    LayoutContainer lcSchLeft = new LayoutContainer();
		    lcSchLeft.setStyleAttribute("paddingRight", "10px");
		  
		    LayoutContainer layoutContainer = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer.setLayout(frmlytSch);
		    layoutContainer.setBorders(false);
 
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
			layoutContainer_2.setLayout(new FlowLayout());
			  
			   
//			topPayr4200Bar = new ButtonBar();    
//			layoutContainer_2.add(topPayr4200Bar);
//			topPayr4200Bar.setAlignment(HorizontalAlignment.RIGHT);
//			 
//			  	
//		  	btnPayr4200Print = new Button("인쇄"); 
//		  	btnPayr4200Print.setIcon(MSFMainApp.ICONS.print16()); 
//		  	topPayr4200Bar.add(btnPayr4200Print); 
//		  	btnPayr4200Print.addListener(Events.Select, new Listener<ButtonEvent>() {
//	    		public void handleEvent(ButtonEvent e) {
//	    			//버튼 클릭시 처리 
//	    		//	Payr410002Print("PAYRT4203") ;
//	    		}
//	    	}); 
			 
			  	
		    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_2.setBorders(false);  
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_14.setLayout(frmlytSch);
		     
		   
		    layoutContainer_14.setBorders(false);
		 
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    lcSchLeft.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
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
		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		           BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		                //조회 처리 호출 
		        	  String payYr =  MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"); 
		        	  if (MSFSharedUtils.paramNotNull(payYr)) {  
		        			  reload(); 
		        	  }
		        	   
		           }       
		          } 
		      });   
		    layoutContainer_8.add(srhPayYr, new FormData("100%"));  
		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		    layoutContainer_8.setBorders(false);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_9.setLayout(frmlytSch);
		    
  
		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_9.setBorders(false);
		    
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 
			
		    cpPayr4101.add(fieldSet); 
		   
	  }  
	  
  private  void createInfoForm() {   
	  
	   systemkey = new HiddenField<String>();  //시스템키 
       systemkey.setName("systemkey");
       cpPayr4101.add(systemkey);
       payrMangDeptCd = new  HiddenField<String>(); 
       payrMangDeptCd.setName("payrMangDeptCd");
       cpPayr4101.add(payrMangDeptCd); 
       businCd = new  HiddenField<String>(); 
       businCd.setName("businCd");
       cpPayr4101.add(businCd);
       dpobCd = new HiddenField<String>();  //사업장코드 
       dpobCd.setName("dpobCd");
       cpPayr4101.add(dpobCd);
    //   idtlAccdtInsurApptnYn = new HiddenField<Boolean>() ; 
     //  logSvcExtpyApptnYn =  new HiddenField<Boolean>() ;
       
       
       typOccuCd = new HiddenField<String>();  /**  column 직종코드 : typOccuCd */
       typOccuCd.setName("typOccuCd");
       cpPayr4101.add(typOccuCd);
       dtilOccuInttnCd = new HiddenField<String>();  //사업장코드 
       dtilOccuInttnCd.setName("dtilOccuInttnCd");
       cpPayr4101.add(dtilOccuInttnCd);
       currAffnDeptCd = new HiddenField<String>();  //사업장코드 
       currAffnDeptCd.setName("currAffnDeptCd");
       cpPayr4101.add(currAffnDeptCd);
       businCd = new HiddenField<String>();  //사업장코드 
       businCd.setName("businCd");
       cpPayr4101.add(businCd);
      // pyspGrdeCd = new HiddenField<String>();  //사업장코드 
      // pyspGrdeCd.setName("pyspGrdeCd");
      // cpPayr4101.add(pyspGrdeCd);
       emymtDivCd = new HiddenField<String>();
	   emymtDivCd.setName("emymtDivCd");
	   cpPayr4101.add(emymtDivCd);
	         
	      
		    FieldSet fieldSet1 = new FieldSet();  
		    fieldSet1.setHeadingHtml("기본정보");
		    
		    LayoutContainer lcSchCol1 = new LayoutContainer();
		    lcSchCol1.setLayout(new ColumnLayout()); 
		   
		    LayoutContainer layoutContainer_6 = new LayoutContainer();
		    
		    FormLayout  frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(50); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_6.setLayout(frmlytStd);
		    
		    hanNm = new TextField<String>(); 
		    hanNm.setName("hanNm");
		    hanNm.setReadOnly(true);
		    layoutContainer_6.add(hanNm, new FormData("100%"));
		    hanNm.setFieldLabel("성 명"); 
		    layoutContainer_6.setBorders(false);
		    
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
		    layoutContainer_7.add(resnRegnNum, new FormData("100%"));
		    resnRegnNum.setFieldLabel("주민번호"); 
		    layoutContainer_7.setBorders(false);
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(60); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_8.setLayout(frmlytStd);
		    
		 
		    emymtDivNm = new TextField<String>();
		    emymtDivNm.setName("emymtDivNm");
		    emymtDivNm.setReadOnly(true);
		    layoutContainer_8.add(emymtDivNm, new FormData("100%"));
		    emymtDivNm.setFieldLabel("고 용"); 
		    layoutContainer_8.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(60); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_3_1.setLayout(frmlytStd);
		    
		    repbtyBusinDivNm = new TextField<String>();
		    repbtyBusinDivNm.setName("repbtyBusinDivNm"); 
		    repbtyBusinDivNm.setFieldLabel("호봉");   
		    layoutContainer_3_1.add(repbtyBusinDivNm, new FormData("100%"));  
		     
//		    logSvcYrNumNm = new TextField<String>();
//		    logSvcYrNumNm.setName("logSvcYrNumNm"); 
//		    logSvcYrNumNm.setFieldLabel("근무년수");   
//		    layoutContainer_3_1.add(logSvcYrNumNm, new FormData("100%"));  
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(60); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_1.setLayout(frmlytStd);
		    
		    logSvcYrNumNm = new TextField<String>();
		    logSvcYrNumNm.setName("logSvcYrNumNm"); 
		    logSvcYrNumNm.setFieldLabel("근무년수");   
		    layoutContainer_1.add(logSvcYrNumNm, new FormData("100%"));  
		    

//		    TextField<String> textField_9 = new TextField<String>();
//		    textField_9.setReadOnly(true);
//		    layoutContainer_1.add(textField_9, new FormData("100%"));
//		    textField_9.setFieldLabel("회계단위"); 
//		    layoutContainer_1.setBorders(false);
		    
		    lcSchCol1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    lcSchCol1.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    lcSchCol1.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    lcSchCol1.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    lcSchCol1.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    
		    fieldSet1.add(lcSchCol1, new FormData("100%"));
		    
		    LayoutContainer layoutContainer_5 = new LayoutContainer();
		    layoutContainer_5.setLayout(new ColumnLayout());
		    layoutContainer_5.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		   
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(50); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_10.setLayout(frmlytStd);
		    
		    currAffnDeptNm = new TextField<String>(); 
		    currAffnDeptNm.setName("currAffnDeptNm");
		    currAffnDeptNm.setReadOnly(true);
		    layoutContainer_10.add(currAffnDeptNm, new FormData("100%"));
		    currAffnDeptNm.setFieldLabel("부 서"); 
		    layoutContainer_10.setBorders(false);
		    
		    LayoutContainer layoutContainer_11 = new LayoutContainer(new ColumnLayout());
		    
	        LayoutContainer layoutContainer_211 = new LayoutContainer();
	        FormLayout frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_211.setLayout(frmlytSch); 
	       
	        deptGpNm = new TextField<String>();
	        deptGpNm.setName("deptGpNm");
	        deptGpNm.setReadOnly(true);
	        deptGpNm.setFieldLabel("직 종"); 
	        
	        layoutContainer_211.add(deptGpNm, new FormData("100%")); 
	        layoutContainer_11.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		    
	        
	        LayoutContainer layoutContainer_11_1 = new LayoutContainer();
	        
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(0); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_11_1.setLayout(frmlytStd);
		    
		    typOccuNm = new TextField<String>();
		    typOccuNm.setName("typOccuNm");
		    typOccuNm.setReadOnly(true);
//		    typOccuNm.setFieldLabel("직 종"); 
		    typOccuNm.setLabelSeparator("");
		    layoutContainer_11_1.add(typOccuNm, new FormData("100%"));
		    layoutContainer_11.add(layoutContainer_11_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    
		    LayoutContainer layoutContainer_17 = new LayoutContainer();
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(0); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_17.setLayout(frmlytStd);
		    
		    dtilOccuClsDivNm = new TextField<String>();
		    dtilOccuClsDivNm.setName("dtilOccuClsDivNm");
		    dtilOccuClsDivNm.setLabelSeparator("");
		    dtilOccuClsDivNm.setReadOnly(true);
		    layoutContainer_17.add(dtilOccuClsDivNm, new FormData("100%"));
//		    dtilOccuClsDivNm.setFieldLabel("직종세"); 
		    layoutContainer_17.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_12 = new LayoutContainer();
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(60); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_12.setLayout(frmlytStd);
		    
		    businNm = new TextField<String>();
		    businNm.setName("businNm");
		    businNm.setReadOnly(true);
		    layoutContainer_12.add(businNm, new FormData("100%"));
		    businNm.setFieldLabel("사 업"); 
		    layoutContainer_12.setBorders(false);
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(60); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_14.setLayout(frmlytStd);
		    
		    hdofcCodtnNm = new TextField<String>();
		    hdofcCodtnNm.setName("hdofcCodtnNm");
		    hdofcCodtnNm.setReadOnly(true);
		    layoutContainer_14.add(hdofcCodtnNm, new FormData("100%"));
		    hdofcCodtnNm.setFieldLabel("근무상태");
		    layoutContainer_14.setBorders(false);
		    
		    
		    layoutContainer_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    layoutContainer_5.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_5.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		    layoutContainer_5.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    layoutContainer_5.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    
		    fieldSet1.add(layoutContainer_5); 
			
		    cpPayr4101.add(fieldSet1);  
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
			fldstNewFieldset_2.setHeadingHtml("급여내역");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(occupationalRTop(),new FormData("100%"));
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
				
				
			FieldSet fldstNewFieldset_1 = new FieldSet();
		   // fldstNewFieldset_1.setSize(628, 320);
			

			layoutContainer_2.add(fldstNewFieldset_1);
			fldstNewFieldset_1.setHeadingHtml("급여상세정보");
			fldstNewFieldset_1.setCollapsible(false);
			
		//	fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
			
			LayoutContainer layoutContainer_3 = new LayoutContainer();
			layoutContainer_3.setLayout(new ColumnLayout());
			
			FieldSet fldstNewFieldset_4 = new FieldSet();
			fldstNewFieldset_4.setCollapsible(false);
			
			LayoutContainer layoutContainer_4 = new LayoutContainer();
			layoutContainer_4.setStyleAttribute("paddingLeft", "10px");
			frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_4.setLayout(frmlytStd);
			layoutContainer_4.add(payrLeft01(),new FormData("100%"));
			fldstNewFieldset_4.add(layoutContainer_4,new FormData("100%"));
			layoutContainer_4.setBorders(false);
			layoutContainer_3.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.54));
			fldstNewFieldset_4.setHeadingHtml("수 당");
			 
			
			FieldSet fldstNewFieldset_5 = new FieldSet();
			
			LayoutContainer layoutContainer_5 = new LayoutContainer();
			layoutContainer_5.setStyleAttribute("paddingLeft", "10px");
			frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_5.setLayout(frmlytStd);
			layoutContainer_5.add(payrLeft02(),new FormData("100%"));
			fldstNewFieldset_5.add(layoutContainer_5,new FormData("100%"));
			layoutContainer_5.setBorders(false);
			layoutContainer_3.add(fldstNewFieldset_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
			fldstNewFieldset_5.setHeadingHtml("공 제");
			fldstNewFieldset_5.setCollapsible(false);
			fldstNewFieldset_1.add(layoutContainer_3);
			layoutContainer_3.setBorders(false);
			 
			    
			cpPayr4101.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   
		 
		 private  LayoutContainer occupationalRTop() {
			   

	         LayoutContainer lcTabFormLayer = new LayoutContainer();

 
	  	   ContentPanel cp01 = new ContentPanel();   
	  	   cp01.setBodyBorder(false); 
	  	   cp01.setHeaderVisible(false);   
	  	   cp01.setLayout(new FitLayout());      
	  	   cp01.setSize(764, 190);  
	  	  
	  	   payr0304GridPanel = new MSFGridPanel(payr0304Def, false, false, false, false);
  	       payr0304GridPanel.setAutoSelectFirstRecord(true);
  	       payr0304GridPanel.setHeaderVisible(false);  
  	       payr0304GridPanel.setBodyBorder(true);
  	       payr0304GridPanel.setBorders(true); 
  	     //  payr0304GridPanel.setSize(700, 100);
  	       final Grid payr0304Grid = payr0304GridPanel.getMsfGrid().getGrid(); 
  	       payr0304Grid.addListener(Events.CellClick,  new Listener<BaseEvent>() {
  	            public void handleEvent(BaseEvent be) {  
  	              if (payr0304GridPanel.getCurrentlySelectedItem() != null) {   
  	            	  //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
  	            	 
                   
  	              }
  	            }
  	        });  
  	 
//	    	 payr0304GridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	         public void handleEvent(StoreEvent<BaseModel> be) { 
//	        	 ListStore<BaseModel>  bmLsStore = (ListStore<BaseModel>) be.getSource();//payr0304GridPanel.getMsfGrid().getStore().getModels();
//	        	 if (MSFSharedUtils.paramNotNull(bmLsStore.getModels()) && (bmLsStore.getCount() > 0)) { 
//	        		 payr0304GridPanel.getMsfGrid().setCurrentlySelectedItem(bmLsStore.getAt(0));  
//	        		 payr0304GridPanel.getMsfGrid().getGrid().fireEvent(Events.CellClick);
//	        	 } 
//	           }  
//	         });   
		  
	       cp01.add(payr0304GridPanel);   
	 	  
	 	    lcTabFormLayer.add(cp01); 
	 	      
			    return lcTabFormLayer;
		 } 
	  
		 
		   private  LayoutContainer payrLeft01() {
			   
			   LayoutContainer lcTabFormLayer = new LayoutContainer();
  
		 	    
		 	   ContentPanel cp01 = new ContentPanel();   
		 	   cp01.setBodyBorder(false); 
		 	   cp01.setHeaderVisible(false);   
		 	   cp01.setLayout(new FitLayout());      
		 	   cp01.setSize(391, 240);  
		 	   
		 	  //msfCustomForm.setHeaderVisible(false);
		       //Instantiate the GridPanel
			   payr0302ExtpyGridPanel = new MSFGridPanel(payr0302ExtpyDef, false, false, false, false);
			   payr0302ExtpyGridPanel.setHeaderVisible(false);  
			   payr0302ExtpyGridPanel.setBodyBorder(true);
			   payr0302ExtpyGridPanel.setBorders(true);
			 //  payr0302ExtpyGridPanel.setSize(300, 140);  
			   payr0302ExtpyGridPanel.getBottomComponent().setVisible(false);
			 
				 
				//   insr4100GridPanel.setSize(308, 466); 
			  	 //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.  
			   GWTUtils.findColumnConfig(payr0302ExtpyGridPanel, Payr0302BM.ATTR_PYMTDDUCSUM).setStyle("background-color:#F5F6CE;");
//				    GWTUtils.findColumnConfig(insr4100GridPanel, Insr4100BM.ATTR_NATPENNSTDINCMMNTHAMNT).setStyle("background-color:#F5F6CE;");
//				    GWTUtils.findColumnConfig(insr4100GridPanel, Insr4100BM.ATTR_NATPENNAQTNDT).setStyle("background-color:#F5F6CE;");
//				    setGridCellRenderer(new GridCellRenderer<BaseModel>() {    
//				    @Override
//				    public Object render(BaseModel model, String property, ColumnData config,
//				                         int rowIndex, int colIndex, ListStore<BaseModel> store,
//				                         Grid<BaseModel> grid) {
//				          config.style = "background-color:yellow;";
//				          grid.getColumnModel().getColumn(colIndex).setNumberFormat(formatNumeric);
//				          grid.getColumnModel().getColumn(colIndex).setAlignment(HorizontalAlignment.RIGHT);
//				          Object value =  Long.parseLong(String.valueOf(model.get(property)));
//				          return value;          
//				     } 
//				});
				    
				    //2줄파싱 
					   // dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("Stock Performance", 1, 2));
					   // dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 0, new HeaderGroupConfig("Stock Information", 1, 2));
					  //  final ListStore<BaseModel> store = new ListStore<BaseModel>();  
					   // store.add(dlgn0300GridPanel.getGrid().getStore().getModels());  
					     
					    AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
					 
					    payrSummaryRow.setCellStyle(Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM,"summary_color");
					    payrSummaryRow.setCellStyle(Payr0302BM.ATTR_PYMTDDUCSUM,"summary_color");
					    payrSummaryRow.setCellStyle(Payr0302BM.ATTR_PYMTDDUCTXTNAMNT,"summary_color");
					   //  String htmlAttr = "<span style='background-color:yellow; background-repeat: no-repeat;'>합 계</span>" ;
					    
					    payrSummaryRow.setHtml(Payr0302BM.ATTR_PAYITEMNM, "합 계");   
					    
					    // with summary type and format  
					    payrSummaryRow.setSummaryType(Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, SummaryType.SUM);   
					    payrSummaryRow.setSummaryFormat(Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
					    
					    payrSummaryRow.setSummaryType(Payr0302BM.ATTR_PYMTDDUCSUM, SummaryType.SUM);   
					    payrSummaryRow.setSummaryFormat(Payr0302BM.ATTR_PYMTDDUCSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
					      
					    payrSummaryRow.setSummaryType(Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, SummaryType.SUM);   
					    payrSummaryRow.setSummaryFormat(Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
					      
					    // with renderer  
//					    averages.setSummaryType("change", SummaryType.AVG);  
//					    averages.setRenderer("change", new AggregationRenderer<Stock>() {  
//					      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {  
//					        // you can return html here  
//					        return number.format(value.doubleValue());  
//					      }  
//					    });  
				payr0302ExtpyGridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
				
			    cp01.add(payr0302ExtpyGridPanel); 
			    
			    lcTabFormLayer.add(cp01); 
			     
				return lcTabFormLayer;  
			   
		   }
		   
		   
		   private  LayoutContainer payrLeft02() {
			   
			   LayoutContainer lcTabFormLayer = new LayoutContainer();
 
		 	    
		 	   ContentPanel cp01 = new ContentPanel();   
		 	   cp01.setBodyBorder(false); 
		 	   cp01.setHeaderVisible(false);   
		 	   cp01.setLayout(new FitLayout());      
		 	   cp01.setSize(331, 240);  
		 	   
		 	    payr0302DducGridPanel = new MSFGridPanel(payr0302DducDef, false, false, false, false,MSFGridType.GROUPBY,"pymtDducDivNm");
		 	   // payr0302DducGridPanel = new MSFGridPanel(payr0302DducDef, false, false, false, false);
			    payr0302DducGridPanel.setHeaderVisible(false);  
			    payr0302DducGridPanel.setBodyBorder(true);
			    payr0302DducGridPanel.setBorders(true); 
			    payr0302DducGridPanel.getBottomComponent().setVisible(false);
			 //   payr0302DducGridPanel.setSize(300, 140); 
				//   insr4100GridPanel.setSize(308, 466); 
			  	 //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.  
			 //  GWTUtils.findColumnConfig(payr0302ExtpyGridPanel, Payr0302BM.ATTR_PYMTDDUCSUM).setStyle("background-color:#F5F6CE;");
//					    GWTUtils.findColumnConfig(insr4100GridPanel, Insr4100BM.ATTR_NATPENNSTDINCMMNTHAMNT).setStyle("background-color:#F5F6CE;");
//					    GWTUtils.findColumnConfig(insr4100GridPanel, Insr4100BM.ATTR_NATPENNAQTNDT).setStyle("background-color:#F5F6CE;");
//					    setGridCellRenderer(new GridCellRenderer<BaseModel>() {    
//					    @Override
//					    public Object render(BaseModel model, String property, ColumnData config,
//					                         int rowIndex, int colIndex, ListStore<BaseModel> store,
//					                         Grid<BaseModel> grid) {
//					          config.style = "background-color:yellow;";
//					          grid.getColumnModel().getColumn(colIndex).setNumberFormat(formatNumeric);
//					          grid.getColumnModel().getColumn(colIndex).setAlignment(HorizontalAlignment.RIGHT);
//					          Object value =  Long.parseLong(String.valueOf(model.get(property)));
//					          return value;          
//					     } 
//					});
				    
				    //2줄파싱 
					   // dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("Stock Performance", 1, 2));
					   // dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 0, new HeaderGroupConfig("Stock Information", 1, 2));
					  //  final ListStore<BaseModel> store = new ListStore<BaseModel>();  
					   // store.add(dlgn0300GridPanel.getGrid().getStore().getModels());  
					     
					    AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
					 
					    payrSummaryRow.setCellStyle(Payr0302BM.ATTR_PYMTDDUCSUM,"summary_color"); 
					   //  String htmlAttr = "<span style='background-color:yellow; background-repeat: no-repeat;'>합 계</span>" ;
					    
					    payrSummaryRow.setHtml(Payr0302BM.ATTR_PAYITEMNM, "합 계");   
					    
					    // with summary type and format  
					   
					    payrSummaryRow.setSummaryType(Payr0302BM.ATTR_PYMTDDUCSUM, SummaryType.SUM);   
					    payrSummaryRow.setSummaryFormat(Payr0302BM.ATTR_PYMTDDUCSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
					       
					    // with renderer  
//						    averages.setSummaryType("change", SummaryType.AVG);  
//						    averages.setRenderer("change", new AggregationRenderer<Stock>() {  
//						      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {  
//						        // you can return html here  
//						        return number.format(value.doubleValue());  
//						      }  
//						    });  
					    payr0302DducGridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow); 
			    
			    cp01.add(payr0302DducGridPanel);
		 	   
			    lcTabFormLayer.add(cp01); 
			     
				return lcTabFormLayer;  
			   
		   }
		    
		   
			public void reload() {
				// TODO Auto-generated method stub
				formInit(); 
				IColumnFilter filters = null;
				payr0304GridPanel.getTableDef().setTableColumnFilters(filters); 
				 
				payr0304GridPanel.getTableDef().addColumnFilter("pymtYrMnth", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
			 	payr0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			 
				payr0304GridPanel.reload();
				
				actionDatabase = ActionDatabase.READ; 
			}
			
			
			//폼초기화 검색조건포함 
		   private void formInit() {
			     
			   subformInit(); 
			   
			   payr0304GridPanel.getMsfGrid().clearData();
			  
			   actionDatabase = ActionDatabase.READ;
			   
			   
		   }
		   
		   private void subformInit() { 
			      
			   //grid init 
			   payr0302ExtpyGridPanel.getMsfGrid().clearData();
			   payr0302DducGridPanel.getMsfGrid().clearData(); 
			     
		   }
	
	   @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            //@Override
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
