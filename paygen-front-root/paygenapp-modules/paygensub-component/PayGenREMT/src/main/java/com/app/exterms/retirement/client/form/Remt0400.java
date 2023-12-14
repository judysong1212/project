package com.app.exterms.retirement.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.retirement.client.form.def.Remt9000Def;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.client.service.Remt0050Service;
import com.app.exterms.retirement.client.service.Remt0050ServiceAsync;
import com.app.exterms.retirement.client.utils.RemtUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
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
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

public class Remt0400  extends MSFPanel { 
	

    private RemtConstants lblRemtConst = RemtConstants.INSTANCE;
  
    
	  private VerticalPanel vp;
	  private FormPanel plFrmRemt0400; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

      private Remt9000Def remt9000Def  = new Remt9000Def();   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel remt9000GridPanel;
      
    //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;

      private ButtonBar topRemt0400Bar;
      private Button btnRemt0400Init;
     // private Button btnRemt0400Save;
     // private Button btnRemt0400Del;
      private Button btnRemt0400Sreach;
      
      private ComboBox<BaseModel> srhCalcSevePayPsnBlggYr;   	//귀속년도 
      private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
      private ComboBox<BaseModel> srhDeptGpCd; 					//부서직종그룹코드	   
      private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 	//직종세  
      private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분  
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; 			//호봉제구분코드 
      private ComboBox<BaseModel> srhCalcSevePayPsnDivCd; 		//정산구분  
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    		//부서 
      private ComboBox<BaseModel> srhBusinCd;    				//사업
      private TextField<String>   srhHanNm;         			//성명
      private TextField<String>   srhResnRegnNum;   			//주민번호 
      private HiddenField<String> srhSystemkey;   				//시스템키
      

      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
       
      private boolean mutilCombo = false;
      
      private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */

//    private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//    private TextField<String> sevePayClutMangeNum;   /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
//
//    private TextField<String> calcSevePayPsnBlggYr;   /** column 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
//
//    private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//    private TextField<String> icncDt;   /** column 입사일자 : icncDt */
//
//    private TextField<String> rkfcdDt;   /** column 기산일자 : rkfcdDt */
//
//    private TextField<String> rsgtnDt;   /** column 퇴사일자 : rsgtnDt */
//
//    private TextField<String> pymtDt;   /** column 지급일자 : pymtDt */
//
//    private TextField<String> eepnMnthIcm2012Bfr;   /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//
//    private TextField<String> eepnMnthIcm2013Aft;   /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//
//    private TextField<String> addMnthIcm2012Bfr;   /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//
//    private TextField<String> addMnthIcm2013Aft;   /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//
//    private TextField<String> retryPayQnty;   /** column 퇴직급여액 : retryPayQnty */
//
//    private TextField<String> freeDtyRetryPayQnty;   /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
//
//    private TextField<String> alpayTxAmnt;   /** column 기납부세액 : alpayTxAmnt */
//
//    private TextField<String> sevePayCtrClutNoteCtnt;   /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
//
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
      

      private Remt0050ServiceAsync remt0050Service = Remt0050Service.Util.getInstance();  
	   
      private ListStore<BaseModel> lsPayYrStore 			= new ListStore<BaseModel>();	//년도 
      private ListStore<BaseModel> lsCalcSevePayPsnDivCd 	= new ListStore<BaseModel>();  	//정산구분   
      
      private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	//고용구분
      private ListStore<BaseModel> lsRepbtyBusinDivCd 		= new ListStore<BaseModel>();	//호봉제구분코드 
      
       //--------------------부서 불러 오는 함수 ------------------------------------------------
      private ListStore<BaseModel> lsDeptCd  				= new ListStore<BaseModel>();	//부서콤보
       //--------------------부서 불러 오는 함수 ------------------------------------------------
         
      //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lsBusinCd  				= new ListStore<BaseModel>();	//사업콤보   
     //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>();	//단위기관
      private ListStore<BaseModel> lsDeptGpCd 				= new ListStore<BaseModel>();	//부서직종그룹코드 
      private ListStore<BaseModel> lsTypOccuCd 				= new ListStore<BaseModel>();	//직종 
      private ListStore<BaseModel> lsDtilOccuInttnCd		= new ListStore<BaseModel>();	//직종세
      
      private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
      private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
      private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
      private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
      private SysCoCalendarDTO  msfCoCalendarDto;  
      private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
      private PrgmComBass0320DTO sysComBass0320Dto;	//직종
      
      private BaseModel record;
      
      //파일업로드처리 부분  
      private FileUploadField remt0400flUp;
      private Boolean picBoolFile;

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
   		  private void checkRemt0400Auth( String authAction, ListStore<BaseModel> bm) {   
   	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
   			 
   			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
   			       
				   if (!maskTracker) { unmask(); }  
 	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
	           
   	                 
   			   }
   		  }
   		 private void authExecEnabled() { 
   		   //------------------
   	      
               //----------------------------------------------------
			Field<?>[] fldArrField = {srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhBusinCd};
		 
			gwtAuthorization.formAuthFieldConfig(fldArrField);
			gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			
			 Date today = new Date(); 
          // A custom date format
        DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
        
        srhCalcSevePayPsnBlggYr.setValue(lsPayYrStore.findModel("year",fmt.format(today)));
        srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
        
	        /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            * 권한설정을 위한 콤보처리를 위한 메서드 시작 
            * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			//gwtAuthorization.formAuthConfig("","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
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

   			     authMapDef.put("srhCalcSevePayPsnBlggYr",Boolean.FALSE);
   			     authMapDef.put("srhCalcSevePayPsnDivCd",Boolean.FALSE); 
   			     
   			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
   			     authMapDef.put("srhDeptCd",Boolean.FALSE); 
   				 
   				 gwtExtAuth.setCheckMapDef(authMapDef);
   		        
   		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
   		        	  //권한 검색조건처리를 위해 추가된 부분 
   					  mask("[화면로딩] 초기화 진행 중!");
   	        	}
   		     tmMask.scheduleRepeating(5000);
   		  }
   	 
   		  
//    	  private AuthAction authAction;
//    	  private int checkCntDef = 2;   //체크 값 갯수 
//    	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//    	  /**
//    	   * 권한설정 처리 체크 
//    	   * AuthAction 
//    	   */
//    	  private void checkRemt0400Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//        	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//    		 
//    		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
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
      
    	  
	   public ContentPanel getViewPanel(){
           if(panel == null){
                
        	   //콤보 권한초기화
			   initLoad(); 
				
               detailTp = XTemplate.create(getDetailTemplate()); 
               
               vp = new VerticalPanel();
               vp.setSpacing(10);
               createRetm0400Form();  //화면 기본정보를 설정
               createSearchForm();    //검색필드를 적용
               createListGrid();
               createStandardForm();    //기본정보필드   
               createSubForm();
               
               //엣지변환
               //vp.setSize("1010px", "700px");
               vp.setSize("1010px", "750px");
                   
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
	   * @wbp.parser.constructor
	   */
	  public Remt0400() {
		    
		  //엣지변환
		  //setSize("1010px", "700px"); 
			setSize("1010px", "750px");  
	  } 
	
	  public Remt0400(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createRetm0400Form() {
		  
		plFrmRemt0400 = new FormPanel();
		//  plFrmRemt0400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Bugt0050());
		plFrmRemt0400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 퇴직금중간정산-2015년7이전자료등록"));
		plFrmRemt0400.setIcon(MSFMainApp.ICONS.text());
		plFrmRemt0400.setBodyStyleName("pad-text");
		plFrmRemt0400.setPadding(2);
		plFrmRemt0400.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("퇴직금중간정산-2015년7이전자료등록","REMT0400");
				}
			});
		plFrmRemt0400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmRemt0400.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		   //멀티콤보박스 닫기 
		plFrmRemt0400.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			        @Override
			        public void handleEvent(ComponentEvent ce) { 
			        
			         //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
			                
			        //        if (f instanceof MSFMultiComboBox<?>) {
			                    
//			                    if ("srhDeptCd".equals(f.getName())) {
//			                        
//			                    } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//			                        
//			                    }
			                    
			          //      } else {
			               if (mutilCombo) {
			                    if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
			                        srhDeptCd.showClose(ce);
			                        mutilCombo = false;
			                  //  } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
			                  //      srhHdofcCodtnCd.showClose(ce);
			                   //     mutilCombo = false;
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
			    

        topRemt0400Bar = new ButtonBar();    
        topRemt0400Bar.setAlignment(HorizontalAlignment.RIGHT);
//        buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//          public void componentSelected(ButtonEvent ce) {   
//           
//          }   
//        }));   
//        buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//          public void componentSelected(ButtonEvent ce) {   
//             
//          }   
//        }));    
      
//      Button topBtn = new Button("신규");  
//      topBtn.setIcon(MSFMainApp.ICONS.new16());
//      buttonBar.add(topBtn);
//       
//      topBtn = new Button("저장");  
//      topBtn.setIcon(MSFMainApp.ICONS.save16());
//      buttonBar.add(topBtn); 
//     
//      topBtn = new Button("삭제");  
//      topBtn.setIcon(MSFMainApp.ICONS.delete16());
//      buttonBar.add(topBtn);
         
        btnRemt0400Sreach = new Button("조회"); 
        btnRemt0400Sreach.setIcon(MSFMainApp.ICONS.search16());
        topRemt0400Bar.add(btnRemt0400Sreach);
        btnRemt0400Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //조회버튼 클릭시 처리 
                reload();  
            }
        });
//      topBtn = new Button("엑셀"); 
//      topBtn.setIcon(MSFMainApp.ICONS.text()); 
//      buttonBar.add(topBtn);  
            
	  	plFrmRemt0400.add(topRemt0400Bar);    	
	  	
		//파일업로드 처리
		plFrmRemt0400.setAction("myurl");
		plFrmRemt0400.setEncoding(Encoding.MULTIPART);
		plFrmRemt0400.setMethod(Method.POST);
		 
		    
		vp.add(plFrmRemt0400);
		//엣지변환
		//plFrmRemt0400.setSize("990px", "680px");
		plFrmRemt0400.setSize("990px", "730px");
	  }
	   
	  private void createListGrid() {
		   

		    FieldSet fldstNewFieldset = new FieldSet(); 
	    	fldstNewFieldset.setHeadingHtml("대상자정보");
	    	fldstNewFieldset.setCollapsible(false);
		    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		   // lcStdGrid.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(true); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(945, 455);   
		     
		    //msfCustomForm.setHeaderVisible(false);
            //Instantiate the GridPanel
            remt9000GridPanel = new MSFGridPanel(remt9000Def, true, true, true, false);
            remt9000GridPanel.setHeaderVisible(false);  
            remt9000GridPanel.setBodyBorder(true);
            remt9000GridPanel.setBorders(true);
         //   remt1000GridPanel.showExportButton(true); 
         //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
               
            cpGrid.add(remt9000GridPanel); 
//		    cpGrid.addButton(new Button("대상자삭제", new SelectionListener<ButtonEvent>() {   
//		  	      @Override  
//		  	      public void componentSelected(ButtonEvent ce) {   
//		  	         
//		  	      }   
//		  	}));  
//		  	   
//		    cpGrid.addButton(new Button("퇴직금계산", new SelectionListener<ButtonEvent>() {   
//	 	      @Override  
//	 	      public void componentSelected(ButtonEvent ce) {   
//	 	         
//	 	      }   
//	 	    }));   
	 	     
		    lcStdGrid.add(cpGrid);   
		    fldstNewFieldset.add(lcStdGrid);   
		      
		    plFrmRemt0400.add(fldstNewFieldset, new FormData("100%"));
		    
	  }
 
	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {   

		  srhSystemkey = new HiddenField<String>();   //시스템키 
	      dpobCd = new HiddenField<String>();  //사업장코드 
	      
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
          //정산구분 
          sysComBass0300Dto.setRpsttvCd("B027");
          lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
	      
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
          // 년도 
          
          lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
          //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
             
	        //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
	       sysComBass0400Dto.setDeptDspyYn("Y");
	       sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	       sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	      
	       lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	      
	       lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	           public void handleEvent(StoreEvent<BaseModel> be) {  
	               mDtalistDeptCd = RemtUtils.getDeptCdModelData(lsDeptCd) ; 
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
//	               ContentPanel typOccuCdGrid = new ContentPanel();  
//	               typOccuCdGrid.setVisible(false);
//	                 
//	                 //직종 콤보처리 
//	                typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	                typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	                        public void handleEvent(ComponentEvent be) {  
//	                          typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	                           public void handleEvent(StoreEvent<BaseModel> be) {  
//	                               
//	                             lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//	                             mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                             srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	                           }  
//	                         });  
//	                        
//	                       }  
//	                     });  
//	           
//	              typOccuCdGrid.add(typOccuCdGridPanel); 
//	              plFrmRemt0400.add(typOccuCdGrid);
	              
	       lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
 		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                  mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                  srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                   
                }
            });  
 		   
	      plFrmRemt0400.setLayout(new FlowLayout());
	     
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
	     
	     fieldSet.add(lcSchCol, new FormData("100%"));  
	     lcSchLeft.setLayout(new ColumnLayout());
	     
	     LayoutContainer layoutContainer_8 = new LayoutContainer();
	     FormLayout frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_8.setLayout(frmlytSch);
	     
	     srhCalcSevePayPsnBlggYr = new ComboBox<BaseModel>();
			srhCalcSevePayPsnBlggYr.setName("srhCalcSevePayPsnBlggYr");
			srhCalcSevePayPsnBlggYr.setForceSelection(true);
			srhCalcSevePayPsnBlggYr.setMinChars(1);
			srhCalcSevePayPsnBlggYr.setDisplayField("yearDisp");
			srhCalcSevePayPsnBlggYr.setValueField("year");
			srhCalcSevePayPsnBlggYr.setTriggerAction(TriggerAction.ALL);
	       // srhCalcSevePayPsnBlggYr.setEmptyText("--년도선택--");
			srhCalcSevePayPsnBlggYr.setSelectOnFocus(true); 
			srhCalcSevePayPsnBlggYr.setReadOnly(false);
			srhCalcSevePayPsnBlggYr.setEnabled(true); 
			srhCalcSevePayPsnBlggYr.setStore(lsPayYrStore);
			srhCalcSevePayPsnBlggYr.setFieldLabel("귀속년도"); 
			srhCalcSevePayPsnBlggYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		         public void handleEvent(StoreEvent<BaseModel> be) {  
		        	 checkRemt0400Auth("srhCalcSevePayPsnBlggYr", lsPayYrStore); 
		         } 
		     });   
			srhCalcSevePayPsnBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	           public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	               //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	            BaseModel bmClutYr =  se.getSelectedItem(); 
	            if (bmClutYr != null) {
	                
	                if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                    
	                    if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                       
	                        sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnBlggYr,"year"));
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
	     layoutContainer_8.add(srhCalcSevePayPsnBlggYr, new FormData("100%"));
	     lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	     layoutContainer_8.setBorders(false);
	     
	     LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
	     layoutContainer_14.setBorders(false);
	     
	     LayoutContainer layoutContainer_15 = new LayoutContainer();
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_15.setLayout(frmlytSch);
	     
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
		                	checkRemt0400Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	     layoutContainer_15.add(srhEmymtDivCd, new FormData("100%"));
	     layoutContainer_14.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	     
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

		    frmlytSch = new FormLayout();  
		    frmlytSch.setDefaultWidth(0);
//		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_101.setLayout(frmlytSch);
		    
		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		    srhRepbtyBusinDivCd.setForceSelection(true);
		    srhRepbtyBusinDivCd.setAllowBlank(false);
		    srhRepbtyBusinDivCd.setHideLabel(true);
		    srhRepbtyBusinDivCd.setMinChars(1);
		    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
		    srhRepbtyBusinDivCd.setValueField("commCd");
		    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
		    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
		    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
//		    srhRepbtyBusinDivCd.setLabelSeparator("");
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
		    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	              
	            }
	        });  
		    
		    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		    layoutContainer_14.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	      
	     
	     
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
	     
	     srhPayrMangDeptCd.setEnabled(true); 
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
		                	checkRemt0400Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
	                  mDtalistDeptCd = RemtUtils.getDeptCdModelData(lsDeptCd) ; 
	                  srhDeptCd.getInitStore().add(mDtalistDeptCd);
	                    
	                }
	             });  
	         } 
	     });
	     layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	     layoutContainer.setBorders(false);
	     
	   
	     
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
//	     srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	         @Override
//	         public void handleEvent(BaseEvent be) {  
//	             if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                 srhSystemkey.setValue("");
//	                 srhResnRegnNum.setValue("");
//	             }
//	          
//	         } 
//	    }); 
	     layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	     layoutContainer_6.setBorders(false);
	     
	     
	  	LayoutContainer layoutContainer_btn = new LayoutContainer();
	  	frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
		layoutContainer_btn.setLayout(frmlytSch);
	     
	     Button btnHanNm = new Button("검색");
//	     layoutContainer_5.add(btnHanNm);
	     btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	         public void handleEvent(ButtonEvent e) {
	             srhSystemkey.setValue("");
	             srhResnRegnNum.setValue("");   
	           fnPopupPsnl0100() ;
	               
	         }
	     });
	     
	     layoutContainer_btn.add(btnHanNm);
	     layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	     
	     LayoutContainer layoutContainer_7 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setDefaultWidth(0);
//	     frmlytSch.setLabelWidth(0); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_7.setLayout(frmlytSch);
	     
	     /** column 주민등록번호 : resnRegnNum */
	     srhResnRegnNum = new TextField<String>();
	     srhResnRegnNum.setHideLabel(true);
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
	     layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
	     layoutContainer_7.setBorders(false); 
	     layoutContainer_5.setBorders(false);
	     
//	     lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21)); 		// 귀속년도
//	     lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));// 고용구분
//	     lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 단위기관
//	     lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명
	     
	     lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 귀속년도
	     lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));// 고용구분
	     lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 단위기관
	     
	     
	     
	     
	     LayoutContainer layoutContainer_13 = new LayoutContainer();
	     layoutContainer_13.setLayout(new ColumnLayout());
	     
	     
	     LayoutContainer layoutContainer_1 = new LayoutContainer();
	     layoutContainer_1.setBorders(false);
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	     layoutContainer_1.setLayout(frmlytSch);
	     
	     srhCalcSevePayPsnDivCd =  new ComboBox<BaseModel>(); 
	     srhCalcSevePayPsnDivCd.setName("srhCalcSevePayPsnDivCd");
	     srhCalcSevePayPsnDivCd.setForceSelection(true);
	     srhCalcSevePayPsnDivCd.setMinChars(1);
	     srhCalcSevePayPsnDivCd.setDisplayField("commCdNm");
	     srhCalcSevePayPsnDivCd.setValueField("commCd");
	     srhCalcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
	     srhCalcSevePayPsnDivCd.setEmptyText("--정산구분선택--");
	     srhCalcSevePayPsnDivCd.setSelectOnFocus(true); 
	     srhCalcSevePayPsnDivCd.setReadOnly(false);
	     srhCalcSevePayPsnDivCd.setEnabled(true); 
	     srhCalcSevePayPsnDivCd.setStore(lsCalcSevePayPsnDivCd);
	     srhCalcSevePayPsnDivCd.setFieldLabel("정산구분");
	     srhCalcSevePayPsnDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	         public void handleEvent(StoreEvent<BaseModel> be) {  
	        	 checkRemt0400Auth("srhCalcSevePayPsnDivCd", lsCalcSevePayPsnDivCd); 
	         } 
	     });    
	     layoutContainer_1.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
	     
	     
	     
	     
	     
	     
	     
	      
	     
	     LayoutContainer layoutContainer_2 = new LayoutContainer();
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(60); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_2.setLayout(frmlytSch);
	     
	     srhDeptCd = new MSFMultiComboBox<ModelData>();
	     srhDeptCd.setName("srhDeptCd");
	     srhDeptCd.setEmptyText("--부서선택--");
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
		                	checkRemt0400Auth("srhDeptCd", lsDeptCd); 
               	 }
	           
	         }
	     });    

	     srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	        @Override
	       public void handleEvent(ComponentEvent ce) { 
	                
	                   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                      
	                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                          
	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnBlggYr,"year"));    
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
	            		   String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	             
	                             mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	                           }
	                       });  
             	    
		               } else {
		             	  
		             	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		            		   String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		             	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		          		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		         	            public void handleEvent(StoreEvent<BaseModel> be) {  
		         	             
		                           mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
	     
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(70); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_10.setLayout(frmlytSch);
	     
	     //직종 직종세처리  
	     LayoutContainer lcTypOccuCd = new LayoutContainer();
	     lcTypOccuCd.setLayout(new ColumnLayout());
	     
		 LayoutContainer layoutContainer_211 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(60);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_211.setLayout(frmlytSch);
	       
		 srhDeptGpCd = new ComboBox<BaseModel>();
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
	        
	     LayoutContainer layoutContainer_21 = new LayoutContainer();
	     frmlytSch = new FormLayout();
	     frmlytSch.setDefaultWidth(0);
//	     frmlytSch.setLabelWidth(70); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_21.setLayout(frmlytSch); 
	     
	     srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	     srhTypOccuCd.setName("srhTypOccuCd"); 
	     srhTypOccuCd.setEmptyText("--직종선택--"); 
	     srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	     srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	     srhTypOccuCd.setWidth(100);
	     srhTypOccuCd.setHideLabel(true);
//	     srhTypOccuCd.setFieldLabel("직종");
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
		    		   }
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkRemt0400Auth("srhTypOccuCd", lsTypOccuCd); 
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
	     
	     
	     lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
	     lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
	     lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
	     layoutContainer_21.setBorders(false);
	     
	     layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
	     layoutContainer_10.setBorders(false);
	     
	    
	     
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
	     srhBusinCd.getListView().setWidth("200px");
	     srhBusinCd.setStore(lsBusinCd);
	     srhBusinCd.setFieldLabel("사업");
	     srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	     srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
	     layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	     layoutContainer_4.setBorders(false);
	     
	     
//	     layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));	// 정산구분
//	     layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));	// 부서
//	     layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 직종
//	     layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 사업
	     
	     layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 정산구분
	     layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
	     layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
	     
	     fieldSet.add(layoutContainer_13);
	     
	     LayoutContainer lcSchCol3 = new LayoutContainer();
	     lcSchCol3.setLayout(new ColumnLayout());
		
	     LayoutContainer layoutContainer_16 = new LayoutContainer();
        
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(0); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_16.setLayout(frmlytSch);
	     
	     lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
	     lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명
	     lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 

	     
	     fieldSet.add(lcSchCol3);
	     
	      
		

	     plFrmRemt0400.add(fieldSet); 
		//vp.add(panel);   
	  }  
	  

	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
              
              //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                  
                  sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                  String strDeptCd = RemtUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                  sysComBass0350Dto.setDeptCd(strDeptCd);
                  List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                  String strTypOccuCd = RemtUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                  
                 // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                  
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                      
                      lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                      
                      lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                          public void handleEvent(StoreEvent<BaseModel> be) {  
                              mDtalistDtilOccuInttnCd = RemtUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
	  
	  /**
	   * Excel 
	   */
	  private void createSubForm() {
		  
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
			    
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2_1.setLayout(frmlytSch);
		layoutContainer_2_1.setBorders(false);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		layoutContainer_3.setBorders(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer(); 
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_4.setLayout(frmlytSch);
	    layoutContainer_4.setBorders(false);
	    
		remt0400flUp = new FileUploadField();
		remt0400flUp.setName("remt0400flUp");
		remt0400flUp.setValidator(new Validator() {  
                  @Override  public String validate(Field<?> field, String value) { 
                      value = value.toLowerCase();        
                      String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
                      if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
                          result = null;        
                          }        
                      return result;  
                      } 
                  });
		layoutContainer_2_1.add(remt0400flUp, new FormData("100%"));
		remt0400flUp.setFieldLabel("퇴직정산");
		
		Button btnButton01 = new Button("양식업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    
                	xlsImportData(); 
                      
                }
            });
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		

		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    
                  xlsExportData();
                      
                }
            }); 
		layoutContainer_4.add(btnButton02, new FormData("100%"));
		
		layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		
		plFrmRemt0400.add(fldstNewFieldset);
			
	  } 
	  
	  /* 엑셀 업로드 */
	  private void xlsImportData() {
		  MessageBox.confirm("퇴직 정산 생성", "퇴직 정산을 생성하시겠습니까?<br>(등록되어있는 퇴직정산이 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
		      	@Override
		    	public void handleEvent(MessageBoxEvent be) {
		      		//if("Yes".equals(be.getButtonClicked().getText())){
		      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      			
		      			String filename = MSFSharedUtils.allowNulls(remt0400flUp.getValue());
	              		if (filename.length() == 0) {
	              			Window.alert("선택된 파일이 없습니다.");
	              			return;
	                	} else {
	                		//submit the form
	                		plFrmRemt0400.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                		//파일업로드 처리
	                		
	                		plFrmRemt0400.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadRemt0400Import.do");
	                		plFrmRemt0400.setEncoding(Encoding.MULTIPART);
	                		plFrmRemt0400.setMethod(Method.POST);   
	                		plFrmRemt0400.submit();  
	                		plFrmRemt0400.onFrameLoad();  
	                    	picBoolFile = true;
	                	}
	                    // reset and unmask the form 
	                    // after file upload 
	              		plFrmRemt0400.addListener(Events.Submit, new Listener<FormEvent>() {
	                		public void handleEvent(FormEvent evt) {  
	                				plFrmRemt0400.unmask();  
	                            	if(picBoolFile) {
	                            		MessageBox.alert("", "업로드 중입니다. 팝업이 뜨면 오류 내역을 확인해주세요.", null); 
		                                picBoolFile = false;
		                                evt.setResultHtml("");
	                            	}
	                     	};
	                  	});
	              		
//		      			HashMap<String, String> param = new HashMap<String, String>();
//		      			
//		      			String calcSevePayPsnBlggYr = MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnBlggYr,"year");	//귀속년도
//		      			String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");	//고용구분
//		      			String repbtyBusinDivCd = MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd");	//호봉제구분코드 srhRepbtyBusinDivCd
//		      			String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");	//단위기관 srhPayrMangDeptCd
//		      			String calcSevePayPsnDivCd = MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd");	//정산구분  srhCalcSevePayPsnDivCd
//		      			String deptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");	//부서 srhDeptCd
//		      			String deptGpCd = MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCd");	//부서직종그룹코드 srhDeptGpCd
//		      			String typOccuCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");	//직종  srhTypOccuCd
//		      			String dtilOccuInttnCd = RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");	//직종세  srhDtilOccuInttnCd
//		      			String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");	//사업srhBusinCd
//		      			String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());	//성명srhHanNm
//		      			String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue());	//주민번호 srhResnRegnNum	
//		      			String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());	//시스템키srhSystemkey
		                  
//		            	if("".equals(calcSevePayPsnBlggYr)){
//		            		MessageBox.info("", "귀속년도는 필수 입니다.", null);
//		             	}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
//		              		if("".equals(businCd)){
//		              			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
//		            		} else {
//		            			//get the filename to be uploaded
//		                      	String filename = MSFSharedUtils.allowNulls(remt0400flUp.getValue());
//		                      	if (filename.length() == 0) {
//		                      		Window.alert("선택된 파일이 없습니다.");
//		                      	} else {
//		                      		//submit the form
//		                      		plFrmRemt0400.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
//		                            
//		                            //파일업로드 처리
//		                      		plFrmRemt0400.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadRemt0400Import.do");
//		                      		plFrmRemt0400.setEncoding(Encoding.MULTIPART);
//		                      		plFrmRemt0400.setMethod(Method.POST);   
//		                      		plFrmRemt0400.submit();  
//		                      		plFrmRemt0400.onFrameLoad();  
//		                        	picBoolFile = true;
//		                      	}               
//		                      	// reset and unmask the form 
//		                      	// after file upload 
//		                      	plFrmRemt0400.addListener(Events.Submit, new Listener<FormEvent>() {
//		                      		public void handleEvent(FormEvent evt) {   
//		                      			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//		                      				
//		                      				//업로드가  성공했으면 인서트 모듈을 태운다. 
//		                      				plFrmRemt0400.unmask();  
//		                                   	MessageBox.alert("", "업로드 중입니다... 팝업이 뜨면 오류 내역을 확인해주세요.", null); 
//		                                  	picBoolFile = false;
//		                                  	evt.setResultHtml("");
//		                              	} else {
//		                              		if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//		                              			
//		                              			//업로드가  성공했으면 인서트 모듈을 태운다.
//		                              			MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
//		                                      	picBoolFile = false;
//		                                    	evt.setResultHtml("");
//		                              		} else {
//		                              			//실패 메시지나 에러 메시지 처리 . 
//		                              			evt.setResultHtml("");
//		                              		} 
//		                              	}
//		                      		};
//		                      	}); 
//		            		}
//		              	}else{ 
//		              		//get the filename to be uploaded
//		              		String filename = MSFSharedUtils.allowNulls(remt0400flUp.getValue());
//		              		if (filename.length() == 0) {
//		              			Window.alert("선택된 파일이 없습니다.");
//		                	} else {
//		                		//submit the form
//		                		plFrmRemt0400.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
//		                		//파일업로드 처리
//		                		
//		                		plFrmRemt0400.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadRemt0400Import.do");
//		                		plFrmRemt0400.setEncoding(Encoding.MULTIPART);
//		                		plFrmRemt0400.setMethod(Method.POST);   
//		                		plFrmRemt0400.submit();  
//		                		plFrmRemt0400.onFrameLoad();  
//		                    	picBoolFile = true;
//		                	}               
//		                       
//		                    // reset and unmask the form 
//		                    // after file upload 
//		              		plFrmRemt0400.addListener(Events.Submit, new Listener<FormEvent>() {
//		                		public void handleEvent(FormEvent evt) {   
//		                			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//		                				//업로드가  성공했으면 인서트 모듈을 태운다. 
//		                				plFrmRemt0400.unmask();  
//		                             	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
//		                                picBoolFile = false;
//		                                evt.setResultHtml("");
//		                			} else {
//		                				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//		                					//업로드가  성공했으면 인서트 모듈을 태운다.
//		                                    MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
//		                                    picBoolFile = false;
//		                                    evt.setResultHtml("");
//		                				} else {
//		                					//실패 메시지나 에러 메시지 처리 . 
//		                                    evt.setResultHtml("");
//		                				} 
//		                          	}
//		                     	};
//		                  	});
//		             	}
		      			
	                	
		           	}  
		        }
			}); 
	     	 
	  } 
	    
	  /* 엑셀 다운로드 */
	  private void xlsExportData() {
		  
		  HashMap<String, String> param = new HashMap<String, String>();  
		  
		  param.put("calcSevePayPsnBlggYr", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnBlggYr,"year"));	//귀속년도
		  param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));	//고용구분
		  param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));	//호봉제구분코드 srhRepbtyBusinDivCd
		  param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));	//단위기관 srhPayrMangDeptCd
		  param.put("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"));	//정산구분  srhCalcSevePayPsnDivCd
		  param.put("deptCd", RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));	//부서 srhDeptCd
		  param.put("deptGpCd", MSFSharedUtils.getSelectedComboValue(srhDeptGpCd,"commCd"));	//부서직종그룹코드 srhDeptGpCd
		  param.put("typOccuCd", RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));	//직종  srhTypOccuCd
		  param.put("dtilOccuInttnCd", RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));	//직종세  srhDtilOccuInttnCd
		  param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));	//사업srhBusinCd
		  param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));	//성명srhHanNm
		  param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));	//주민번호 srhResnRegnNum	
		  param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));	//시스템키srhSystemkey
	      
		  if("".equals(srhCalcSevePayPsnBlggYr)){
				MessageBox.info("", "년도는 필수 입니다.", null);
			}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
				if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				} else { 
					remt9000GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileRemt0400Export.do","extgwtFrame" ,param);   
				}
			}else{ 
//				Window.alert(GWT.getHostPageBaseURL() + "exp/XlsFileRemt0400Export.do");
					remt9000GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileRemt0400Export.do","extgwtFrame" ,param);  
			}
		  
		  
	  }
 
	  /**
	   * 기본사항 
	   */
	  private void createStandardForm() {
			
			//vp.add(panel);   
	  }  
	        
      public void reload() {
             // TODO Auto-generated method stub
             //선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임 
//           if ( MSFSharedUtils.paramNull(srhApptnYr.getRawValue()) ) {
//                 MessageBox.alert("데이터 오류", "년도는 필수 선택사항입니다.", null);
//                 srhApptnYr.focus();
//                 return;
//           }
//           
//           if ( MSFSharedUtils.paramNull(srhApptnStdBgnnDt.getRawValue()) ) {
//                 MessageBox.alert("데이터 오류", "기준일자는 필수 선택사항입니다.", null);
//                 srhApptnStdBgnnDt.focus();
//                 return;
//           }
             
             
             IColumnFilter filters = null;
             remt9000GridPanel.getTableDef().setTableColumnFilters(filters);
             
              
             remt9000GridPanel.getTableDef().addColumnFilter("calcSevePayPsnBlggYr", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnBlggYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS); 
             remt9000GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             remt9000GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
             remt9000GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
             
            // remt9000GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             remt9000GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
             
            // remt9000GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             String strTypOccuCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             remt9000GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//             String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//             dlgn0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
             String strDtilOccuInttnCd = RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
             remt9000GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             remt9000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
             remt9000GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
             remt9000GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
              
             remt9000GridPanel.reload();
         }     
   
      
    public void setRecord(BaseModel record) {
        this.record = record;
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
    private Remt0400 getThis(){
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
