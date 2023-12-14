package com.app.exterms.statistics.client.form;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.client.service.PrgmComBass0400ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.statistics.client.utils.SttsUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Stts0200 extends MSFPanel {

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
    private VerticalPanel vp;
    private FormPanel plFrmStts0200; 
    private String txtForm = "";
    private XTemplate detailTp;
  
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
     

	  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;
	private boolean statCheck = false;
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
	private ButtonBar topStts0200Bar;
	private Button btnStts0200Init;
	private Button btnStts0200Sreach;
//	private Button btnStts0200Print;
//	private Button btnStts0200Excel;
	
   /**
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    * 검색변수 선언 
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    */
	
	private HiddenField<String> srhSystemkey;   			// 시스템키 
	
	private String systemkey;   							// 시스템키 
	
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private TextField<String> srhName;						// 이름
//	private TextField<String> srhResnRegnNum; 				// 주민번호
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 	// 재직 구분
	
	
	private List<ModelData> mDtalistDeptCd;					// 부서 멀티
	private List<ModelData> mDtalistHdofcCodtnCd;			// 재직 멀티

	private boolean mutilCombo = false;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
		
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	
	
    // -------------- store 선언 시작 ---------------
	private ListStore<BaseModel> lsDeptCd 		    = new ListStore<BaseModel>();	// 부서콤보
	private ListStore<BaseModel> lsHdofcCodtnCd		= new ListStore<BaseModel>();	// 재직콤보
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분 
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();	// 사업
	// -------------- store 선언 종료 ---------------
    
    
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;	// 공통코드
    private PrgmComBass0400DTO sysComBass0400Dto; 	// 부서코드
    private PrgmComBass0500DTO sysComBass0500Dto; 	// 사업코드 
    private SysCoCalendarDTO  msfCoCalendarDto;  	// 날짜
    private PrgmComBass0350DTO sysComBass0350Dto;  	// 직종세
    private PrgmComBass0320DTO sysComBass0320Dto;	// 직종
    // -------------- DTO 선언 종료 --------------
    
    
	// -------------- 코드 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	//공통코드 
	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();	//부서코드 
	// -------------- 코드 호출 종료 --------------
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */	
	private String strDirPath;
	private String strParam;
	private String serarchParam;
	private String rdaFileName;
	private String rexFileName;
	private String checkedSystemKeys;
	private ContentPanel cp01;
	
	private HashMap<String, String> param;
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */		
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	    

	  /**
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   **/
	   
	  	/**
	 	 * 권한설정 처리 체크 AuthAction
	 	 */
	  	private void checkStts0200Auth( String authAction, ListStore<BaseModel>bm) {
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			 
			   if (!maskTracker) { unmask(); } 
			   authExecEnabled() ;
		   }	
	 	 }

	  	 
		 private void authExecEnabled() { 
		   //------------------
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작
				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
				 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 //----------------------------------------------------
			 Field<?>[] fldArrField = {srhDeptCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
//			 srhClutYr.setValue(lsClutYrStore.findModel("year",String.valueOf(Integer.parseInt(DateTimeFormat.getFormat("yyyy").format(new Date())) - 1)));
//          srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
//			 SttsUtils.setSelectedComboValue(srhDateType, "season", "commCd");
          
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		
		 }
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) { 
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

	 		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 
		     
		
//			authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
//			authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			authMapDef.put("srhDeptCd",Boolean.FALSE); 
		   // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
		    
		   
//		    authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
//		    authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
//		    authMapDef.put("creDeptCd",Boolean.FALSE); 
		   // authMapDef.put("creTypOccuCd",Boolean.FALSE);	 		

	 		 gwtExtAuth.setCheckMapDef(authMapDef);
	 		
	 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//	 			 권한 검색조건처리를 위해 추가된 부분
	 			 mask("[화면로딩] 초기화 진행 중!");
	 		 }	
	 		 tmMask.scheduleRepeating(5000);
	 	 }
	 	/**
	 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 	 **/   
	    
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
		private void Stts0200Print(String fileName, String repType) {
			   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
//				   RdaPrint(fileName);
			   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
				   RexPrint(fileName);
			   } else {
				   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
			   }
		    }	
		
		
		//rex
		private void RexPrint(final String fileName) {
			
			// 출력물 디렉토리 패스경로 통계 : STTS
			strDirPath = new String();
			strDirPath = "STTS";
//			strDirPath = "PSNL";
			
			// rex 출력물
			rexFileName = new String();
			rexFileName = fileName+".crf";
			
			// 보낼 파라미터
			strParam = new String();
			strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) +"⊥";						// $1 사업장 코드
			strParam += "" + SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")+"⊥";									// $2 고용구분(기간제)
			strParam += ""+ SttsUtils.getPrintStrToMultiData(lsDeptCd, 
					MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; 							// $3 부서

			strParam += "" + MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")) +"⊥";	// $4 사업
			strParam += "" + MSFSharedUtils.allowNulls(systemkey) +"⊥";   													// $5 시스템키
			strParam += ""+MSFSharedUtils.allowNulls(SttsUtils.getPrintStrToMultiData(lsHdofcCodtnCd
							, MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue()), "commCdNm", "commCd"))+"⊥";			// $6 재직구분
			
			printPanel();
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
	  		
//	  		detailTp = XTemplate.create(getDetailTemplate());
	  		vp = new VerticalPanel();
	  		vp.setSpacing(10);
	  		createStts0200Form();  	// 화면 기본정보를 설정
	  		createSearchForm();		// 검색조건
	  		createMsfGridForm();  	// 출력화면
	  		vp.setSize("1010px", "700px");
	  		
	                  
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
		public Stts0200() {
			setSize("1010px", "700px");  
		} 

		public Stts0200(String txtForm) {
		      this.txtForm = txtForm;
		}
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		  
		
	private void createStts0200Form() {
			
		plFrmStts0200 = new FormPanel();
		plFrmStts0200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 기간제근무이력조회"));
		plFrmStts0200.setIcon(MSFMainApp.ICONS.text());
		plFrmStts0200.setPadding(2);
		plFrmStts0200.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("기간제근무이력조회","STTS0200");
				}
			});
		plFrmStts0200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmStts0200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmStts0200.setSize("990px", "680px");
		plFrmStts0200.setLayout(new FlowLayout());
 
		//멀티콤보박스 닫기 
		plFrmStts0200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
	            
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						//부서
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					
					} else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						//재직
						srhHdofcCodtnCd.showClose(ce);
						mutilCombo = false;
					} 
				}
			} 
		});
	        
		/** 상단 버튼 ButtonBar**/
		topStts0200Bar = new ButtonBar();    
		topStts0200Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
//			btnStts0200Init = new Button("초기화");  
//			btnStts0200Init.setIcon(MSFMainApp.ICONS.new16());
//			topStts0200Bar.add(btnStts0200Init);
			    
		btnStts0200Init = new Button("초기화");  
		btnStts0200Init.setIcon(MSFMainApp.ICONS.new16());
		topStts0200Bar.add(btnStts0200Init); 
		btnStts0200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) {
	    		//초기화 
	    		formInit();
	    		
	    		cp01.hide();
			}
		}); 
 
		      
		btnStts0200Sreach = new Button("조 회", Stts0200ButtonListener);
		btnStts0200Sreach.setIcon(MSFMainApp.ICONS.search());
		topStts0200Bar.add(btnStts0200Sreach);
		
 
		plFrmStts0200.add(topStts0200Bar);
		      
//		// 파일업로드 처리
//		plFrmStts0200.setAction("myurl");
//		plFrmStts0200.setEncoding(Encoding.MULTIPART);
//		plFrmStts0200.setMethod(Method.POST);
		vp.add(plFrmStts0200);


	}
  
		
	/** 검색조건 **/
    private void createSearchForm() {   
    	
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0400Dto = new PrgmComBass0400DTO();
        sysComBass0500Dto = new PrgmComBass0500DTO();
        msfCoCalendarDto  = new SysCoCalendarDTO();
        sysComBass0350Dto = new PrgmComBass0350DTO();
        sysComBass0320Dto = new PrgmComBass0320DTO();
        
        
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        sysComBass0300Dto.setRpsttvCd("A002");	//고용구분
        lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
		 //재직상태  
		 sysComBass0300Dto.setRpsttvCd("A003");
		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
                mDtalistHdofcCodtnCd = SttsUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
                srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
            }
		 });  
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		 sysComBass0400Dto.setDeptDspyYn("Y");
		 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		     
		 lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		     
		 lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			 public void handleEvent(StoreEvent<BaseModel> be) {  
				 mDtalistDeptCd = SttsUtils.getDeptCdModelData(lsDeptCd) ; 
				 srhDeptCd.getInitStore().add(mDtalistDeptCd);
			 }
		 }); 
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
      
        
       /**
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * 직종 콤보박스 처리  시작
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
        */
        
		srhSystemkey = new HiddenField<String>(); 		// 시스템키
		
		plFrmStts0200.setLayout(new FlowLayout());


		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		// fieldSet.setCheckboxToggle(false);
		
		LayoutContainer lcSchCol = new LayoutContainer();
		
		
		LayoutContainer lcSch1 = new LayoutContainer();
		lcSch1.setLayout(new ColumnLayout());
		
		
		LayoutContainer lcSch1_1 = new LayoutContainer();
		FormLayout frmlytSch1_1 = new FormLayout();
		frmlytSch1_1.setLabelWidth(40);
		frmlytSch1_1.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSch1_1.setLayout(frmlytSch1_1);
		
        srhDeptCd = new MSFMultiComboBox<ModelData>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setEmptyText("--부서선택--");
        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
        srhDeptCd.getStore().add(mDtalistDeptCd);
        srhDeptCd.setWidth(100);
        srhDeptCd.setFieldLabel("부서");
//        srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//        srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
        srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	EventType type = be.getType();
            	if (type == Store.Add) { 
            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
            			checkStts0200Auth("srhDeptCd", lsDeptCd); 
            	}
            }
        });    
        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
        	@Override
        	public void handleEvent(ComponentEvent ce) { 
        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        			if (srhDeptCd.getListView().getChecked().size() > 0) {  
        				
        				sysComBass0500Dto.setBusinApptnYr(PayGenConst.ACC_CURR_YEAR);    
        				List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
        				
        				sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
        			}      
        			
        			//--------------------사업 불러 오는 함수 -------------------------------------------------
        			lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
        			//--------------------사업 불러 오는 함수 -------------------------------------------------
        			
        			srhBusinCd.setStore(lsBusinCd); 
        			srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        				public void handleEvent(StoreEvent<BaseModel> be) {  
        				}
        			});    
        		}
        	}  
        });
        srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {   
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                }  
            } 
        }); 
		
	    lcSch1_1.add(srhDeptCd, new FormData("100%"));
	    
	    
		LayoutContainer lcSch1_2 = new LayoutContainer();
		FormLayout frmlytSch1_2 = new FormLayout();
		frmlytSch1_2.setLabelWidth(60);
		frmlytSch1_2.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSch1_2.setLayout(frmlytSch1_2);
		
		srhEmymtDivCd =  new ComboBox<BaseModel>(); 
        srhEmymtDivCd.setName("srhEmymtDivCd");
        srhEmymtDivCd.setForceSelection(true);
        srhEmymtDivCd.setMinChars(1);
        srhEmymtDivCd.setDisplayField("commCdNm");
        srhEmymtDivCd.setValueField("commCd");
        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
        srhEmymtDivCd.setEmptyText("--고용구분선택--");
        srhEmymtDivCd.setSelectOnFocus(true); 
        srhEmymtDivCd.setReadOnly(true);
//        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());//TODO
//        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhEmymtDivCd.setStore(lsEmymtDivCd);
        srhEmymtDivCd.setFieldLabel("고용구분"); 
        srhEmymtDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
//				SttsUtils.setSelectedComboValue(srhDateType, "S0010010", "commCd");
//				srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(1));
				srhEmymtDivCd.setValue(lsEmymtDivCd.findModel("commCd",MSFConfiguration.EMYMT_DIVCD02));
			}
		});
        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
        		BaseModel bmPayCd =  se.getSelectedItem(); 
        		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
        			srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
        			srhBusinCd.setEnabled(true);
        		} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
        			//20151130 추가 수정 
           	     	srhDeptCd.getListView().fireEvent(Events.CheckChanged);
           	     	srhBusinCd.reset();
                    srhBusinCd.setEnabled(false);   
        		}  
        	} 
        });
        lcSch1_2.add(srhEmymtDivCd, new FormData("100%"));
		

    	
        LayoutContainer lcSch1_3 = new LayoutContainer();
		FormLayout frmlytSch1_3 = new FormLayout();
		frmlytSch1_3.setLabelWidth(60);
		frmlytSch1_3.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_3.setLayout(frmlytSch1_3);
		
		srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
        srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
        srhHdofcCodtnCd.setEmptyText("--재직선택--");
        srhHdofcCodtnCd.setReadOnly(true);
//        srhHdofcCodtnCd.setEnabled(true); 
        srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
        srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
        srhHdofcCodtnCd.setFieldLabel("재직");
        srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
//            	srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//            	srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
            }
        }); 
        srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {   
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                }  
            } 
        });
        lcSch1_3.add(srhHdofcCodtnCd, new FormData("100%"));
		

		LayoutContainer lcSch1_4 = new LayoutContainer();
		
		FormLayout frmlytSch1_4 = new FormLayout();
		frmlytSch1_4.setLabelWidth(40);
		frmlytSch1_4.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_4.setLayout(frmlytSch1_4);
		
		srhBusinCd = new ComboBox<BaseModel>();
	    srhBusinCd.setName("srhBusinCd");
	    srhBusinCd.setForceSelection(true);
	    srhBusinCd.setMinChars(1);
	    srhBusinCd.setDisplayField("businNm");
	    srhBusinCd.setValueField("businCd");
	    srhBusinCd.setTriggerAction(TriggerAction.ALL);
	    srhBusinCd.setEmptyText("--사업선택--");
	    srhBusinCd.setSelectOnFocus(true); 
//	    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
	    srhBusinCd.setStore(lsBusinCd);
	    srhBusinCd.setFieldLabel("사업");
	    lcSch1_4.add(srhBusinCd, new FormData("100%"));
		
		
		LayoutContainer lcSch1_5 = new LayoutContainer();
		FormLayout frmlytSch1_5 = new FormLayout();
		frmlytSch1_5.setLabelWidth(40);
		frmlytSch1_5.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_5.setLayout(frmlytSch1_5);
		
		srhName = new TextField<String>();
		srhName.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				  
				srhName.validate();
				if (MSFSharedUtils.allowNulls(srhName.getValue()).trim().equals("")) {
					 srhSystemkey.setValue("");
					 srhName.setValue("");
				}
				
				super.componentKeyDown(event);
						
			}
		});		
		
//		srhName.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) {  
//				if (MSFSharedUtils.allowNulls(srhName.getValue()).trim().equals("")) {
//					srhSystemkey.setValue("");
//					srhName.setValue("");
//				}
//			} 
//		}); 
		srhName.setFieldLabel("성명");
		
		lcSch1_5.add(srhName, new FormData("95%"));
		
		
		LayoutContainer lcSch1_6 = new LayoutContainer();
		
		Button btnSrhPsnl = new Button("대상자 검색");
		btnSrhPsnl.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				fnPopupPsnl0100();

			}
		});	
		lcSch1_6.add(btnSrhPsnl);
		
		
//		lcSch1_5.setLayout(new ColumnLayout());
		
//		LayoutContainer lcSch1_5_1 = new LayoutContainer();
//		FormLayout frmlytSch1_5_1 = new FormLayout();
//		frmlytSch1_5_1.setLabelWidth(40);
//		frmlytSch1_5_1.setLabelAlign(LabelAlign.RIGHT);
//		lcSch1_5_1.setLayout(frmlytSch1_5_1);
//		
//		srhName = new TextField<String>();
//		srhName.setFieldLabel("성명");
//		srhName.addKeyListener(new KeyListener() {
//			public void componentKeyUp(ComponentEvent event) {
//				super.componentKeyUp(event);
//                srhName.validate();
//                
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                	srhSystemkey.setValue("");
//                	srhResnRegnNum.setValue(""); 
//                    fnPopupPsnl0100() ;
//                }
//			}
//		});
//		srhName.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) {  
//				if (MSFSharedUtils.allowNulls(srhName.getValue()).trim().equals("")) {
//					srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//				}
//			} 
//		}); 
//		lcSch1_5_1.add(srhName, new FormData("100%"));
//		lcSch1_5.add(lcSch1_5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
//		
//		
//		LayoutContainer lcSch1_5_2 = new LayoutContainer();
//		FormLayout frmlytSch1_5_2 = new FormLayout();
//		frmlytSch1_5_2.setLabelWidth(0);
//		lcSch1_5_2.setLayout(frmlytSch1_5_2);
//		
//		
//        Button btnHanNm = new Button("검색");
//        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
//        	public void handleEvent(ButtonEvent e) {
//                srhSystemkey.setValue("");
//                srhResnRegnNum.setValue("");
//                fnPopupPsnl0100() ;
//            }
//        });
//        lcSch1_5_2.add(btnHanNm, new FormData("100%"));
//        lcSch1_5.add(lcSch1_5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
//        
//        LayoutContainer lcSch1_5_3 = new LayoutContainer();
//		FormLayout frmlytSch1_5_3 = new FormLayout();
//		frmlytSch1_5_3.setHideLabels(true);
//		frmlytSch1_5_3.setLabelAlign(LabelAlign.LEFT);
//		lcSch1_5_3.setLayout(frmlytSch1_5_3);
//		srhResnRegnNum = new TextField<String>();
//		srhResnRegnNum.setName("srhResnRegnNum");
//		srhResnRegnNum.setLabelSeparator("");
//		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
//		lcSch1_5_3.add(srhResnRegnNum, new FormData("100%"));
//		lcSch1_5.add(lcSch1_5_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		
        
//        lcSch1.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));	// 부서
//        lcSch1.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	// 고용구분
//        lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));	// 재직구분
//        lcSch1.add(lcSch1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));	// 사업
//        lcSch1.add(lcSch1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));	// 성명, 주민등록번호
//        lcSch1.add(lcSch1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));		// 대상자검색
		
		
        lcSch1.add(lcSch1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));	// 성명
        lcSch1.add(lcSch1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));		// 대상자검색
        lcSch1.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));	// 부서
        lcSch1.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	// 고용구분
        lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));	// 재직구분
        lcSch1.add(lcSch1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));	// 사업
        
		lcSchCol.add(lcSch1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmStts0200.add(fieldSet);		
	} 
			  

	class Tracker {
		public boolean status = false;

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean stat) {
			status = stat;
		}
	}
		   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
		
		
	private void createMsfGridForm() {
		
		

		FieldSet fieldSetGrd = new FieldSet();
		fieldSetGrd.setHeadingHtml("");
		fieldSetGrd.setSize(975, 550);
		
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    FormLayout frmlytStd = new FormLayout();  
	    lcStdGrid.setLayout(frmlytStd); 

		/** +++++++++++++++++++ 노동력조사 시작 +++++++++++++++++++ **/
	    
		cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(960, 540);
		
		if("".equals(param) || param == null) {
		
		}
		

		lcStdGrid.add(cp01);   
		fieldSetGrd.add(lcStdGrid); 
		/** +++++++++++++++++++ 노동력조사 종료 +++++++++++++++++++ **/
		
		
		plFrmStts0200.add(fieldSetGrd);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	//성명
	private void fnPopupPsnl0100()  {
		MSFFormPanel popCom0100 = SttsUtils.lovPopUpPrgmCom0100Form(srhName.getValue());  //인사 
        
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
        
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
            	
            	List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
            	
				if (mapModels != null) { 
					
//					String outPut = "" ;
					systemkey = new String();
				            
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
					
					while (iterRecords.hasNext()) {
						
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
			            String chkNm = "";
			            String chkkey = "";
			            
			            int size = 0;
			            
			            
			            for(BaseModel bm : mapModels){
			            	
			            	size = size + 1 ;
			            	
			            	if(mapModels.size() == size) {
			            		chkNm += ""+bm.get("hanNm")+"";
				            	chkkey += "'"+bm.get("systemkey")+"'";
				            	
			            	}else {
			            		chkNm += ""+bm.get("hanNm")+", ";
				            	chkkey += "'"+bm.get("systemkey")+"',";
				            	
			            	}
			            	
			            }
//			            srhName.setValue(chkNm.substring(chkNm.length()-1, 1));
//			            systemkey = chkkey.substring(chkkey.length()-1, 1);
			            
			            srhName.setValue(chkNm);
			            systemkey = chkkey;
			            
			            
//			            srhName.setValue(chkNm.substring(0, chkNm.length()-1));
//			            systemkey = chkkey.substring(0,chkkey.length()-1);
			            
			            
//			            srhSystemkey.setValue(chkkey.substring(0,chkkey.length()-1));
			           
			            
//			            Window.alert(srhName.getValue() + " | " +  systemkey);
					}    
				}  
            }
        });
    }

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
		
	// 폼초기화 검색조건포함
	private void formInit() {
		       
        srhName.setValue("");
        systemkey = "";
//        srhSystemkey.reset();
		      
		   }
		

	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}


	private Stts0200 getThis() {
		return this;
	}
	
	
	private SelectionListener<ButtonEvent> Stts0200ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
	        /**  
			 	S0020010	S002	0010	노동력조사 			STTST0100
			 	S0020020	S002	0020	기간제근로자현황(통계) 	STTST0101
			 	S0020030	S002	0030	기간제근로자현황(상세)	STTST0102
			 	S0020040	S002	0040	근로자명부			STTST0103
			 	S0020050	S002	0050	근로자현황			STTST0104
	         **/
			
			String printType = "STTST0105";
			
			Stts0200Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
		}
	};

	private void printPanel() {
		
		String RDA_DIR_PATH_CHAR = MSFConfiguration.RDA_DIR_PATH_CHAR;          //파일경로 구분자
		
		param = new HashMap<String, String>();
		
		String rexServerPath =  MSFMainApp.getMsg("PayGen.RexServerPath");  
		String getRexBaseURL = MSFMainApp.getMsg("PayGen.RexReportService");
		   
		
		param = new HashMap<String, String>(); 
		param.put("svDirPath", rexServerPath + RDA_DIR_PATH_CHAR + strDirPath + RDA_DIR_PATH_CHAR );    //파일경로명
		param.put("svRexParam", strParam);  	//param
		param.put("rexFile", rexFileName); 		//파일명
		param.put("rexUrl", getRexBaseURL);  	//rex server
		param.put("pageUrl", GWT.getHostPageBaseURL());      //pageBase Url
		
		String url = MSFMainApp.getMsg("PayGen.RexServerUrl"); 
		String baseUrl = GWT.getHostPageBaseURL() + url;
		cp01.setUrl(baseUrl+"?"+getURLParamAsString(param));
		
		cp01.show();
		
	}
	
    public static String getURLParamAsString(HashMap<String, String> map) {
        String result = null;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> e = (Entry<String, String>) iter.next();
            String key = e.getKey();
            String val = e.getValue();
            if (MSFSharedUtils.paramNotNull(key) &&
                MSFSharedUtils.paramNotNull(val)) {
                if (result == null) {
                    result = e.getKey()+"="+e.getValue();
                } else {
                    result += "&"+e.getKey()+"="+e.getValue();
                }
            }
        }
        return result;
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