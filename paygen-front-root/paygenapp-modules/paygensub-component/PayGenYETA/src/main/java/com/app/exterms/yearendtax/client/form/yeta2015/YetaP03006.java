/**
 * 종전근무지등록
 */
package com.app.exterms.yearendtax.client.form.yeta2015;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3110DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta3110Def;
import com.app.exterms.yearendtax.client.service.yeta2015.YetaP03006Service;
import com.app.exterms.yearendtax.client.service.yeta2015.YetaP03006ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP03006   extends MSFFormPanel {  

/**
 *##############################O############################################
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
 
	private  ContentPanel cpYeta03006; 
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
		 
	//권한 설정 객체 
	private static  GWTAuthorization gwtAuthorization;
	private static  GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

	  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel yetaP03006GridPanel;
	private Yeta3110Def yetaP03006ToYeta03110Def  = new Yeta3110Def("YETAP03006");	 //종전근무지내역 그리드 테이블 컬럼 define 
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	    
	
    
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
  private Boolean  reading = false;
  public  FormBinding formBinding;
  
  private BaseModel ppRecord; //팝업에 넘길 레코드 값 
  private BaseModel record;
  private Iterator<Record> records;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
  	private  ButtonBar topYetaBtnBar = new ButtonBar();
	private  Button btnYetaNew = new Button();		//신규
	private  Button btnYetaDel = new Button();		//삭제
	private  Button btnYetaSave = new Button();		//저장

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhEdacRvyy;		// 년도
 	private ComboBox<BaseModel> srhSettGbcd; 	// 정산구분
 	private TextField<String> srhDeptNm; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> systemkey;		/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;			/**  column 사업장코드 : dpobCd */
    private HiddenField<String> edacRvyy;		/** column 정산년도 : edacRvyy */
    private HiddenField<String> settGbcd;		/** column 정산구분코드 : settGbcd */
    private HiddenField<String> siteNumb;		/** column 사업자등록번호 : siteNumb */
    private HiddenField<String> deptNm;  		/**  column 부서명 : deptNm */
	private HiddenField<String>	hanNm;			/**  column 성명 : hanNm */
 	// -------------- 검색 조건 종료 --------------
    
	// -------------- 서비스 호출 시작 --------------
	private YetaP03006ServiceAsync yetaP03006Service = YetaP03006Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
    // ---------------- 종전근무지 상세 시작 ---------------- 
    private MSFDateField jeymStdt;		// 귀속년월 시작
    private MSFDateField jeymEddt;  	// 귀속년월 종료    
    private MSFDateField jutrStdt;		// 감면 시작 기간
    private MSFDateField jutrEddt;		// 감면 종료 기간
    private MSFTextField hanNm01;		// 성명   
    private MSFTextField siteNumb01;	//사업자등록번호
    private MSFTextField siteCtnt;		// 근무지명
    private MSFNumberField payrTotl;	// 급여합계
    private MSFNumberField annuMuam;	//국민연금보험료금액    
    private MSFNumberField auetMuam;	//국민연금외공무원연금
    private MSFNumberField auetDdam;	//국민연금외공무원연금_공제액    
    private MSFNumberField earnTaxn;	//소득세    
    private MSFNumberField annuDdam;	//국민연금보험료공제액
    private MSFNumberField auetSold;	//국민연금외군인연금
    private MSFNumberField auetDold;	//국민연금외군인연금_공제액
    private MSFNumberField bonsAmnt;	//상여합계
    private MSFNumberField hlthDbam;	//건강보험료지출액
    private MSFNumberField auetTech;	//국민연금외교직원연금
    private MSFNumberField auetDech;	//국민연금외교직원연금_공제액
    private MSFNumberField ihtxTaxn;	// 지방소득세
    private MSFNumberField hlthMuam;	//건강보험료공제액
    private MSFNumberField auetFect;	// 국민연금외별정우체국
    private MSFNumberField auetDect; 	// 국민연금외별정우체국_공제액
    private MSFNumberField dtmnBtam;	//인정상여
    private MSFNumberField upisJuam;	// 고용보험지출액
    
    private MSFNumberField unonAmnt; 	// 우리사주조합인출금액
    
    private MSFNumberField farmTaxn;	//농특세
    private MSFNumberField upisMuam;	//고용보험공제액
    private MSFNumberField rtreMuam;	//과학기술인공제
    private MSFNumberField rtreDdam;	//과학기술인공제_공제액
    private MSFNumberField stckPrft;	//주식행사이익
    private MSFNumberField rtrePsct;	//근로자퇴직보장법
    private MSFNumberField rtreDsct;	//근로자퇴직보장법_공제액
    private MSFNumberField taxeTotl;	//비과세합계    
    private MSFNumberField ofrrExli;	//임직원퇴직한도초과액
    private MSFNumberField rtreAnsv;	//연금저축계좌
    private MSFNumberField rtreDnsv;	//연금저축계좌_공제액    
    private RadioGroup wthdSbyn;		//원청징수영수증제출여부
    private RadioGroup mangGbyn;		//처리구분
    // ---------------- 종전근무지 상세 종료 ---------------- 

      
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
	// -------------- stroe 선언 시작 --------------
	private  ListStore<BaseModel> lsdacRvyyStore = new ListStore<BaseModel>(); 	// 년도
	private  ListStore<BaseModel> lsSettGbcd = new ListStore<BaseModel>(); 		// 정산구분
	// -------------- stroe 선언 종료 --------------
	    
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
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/
		/**
		 * 권한설정 처리 체크 AuthAction
		 */
//		 private void checkYetaP03006Auth( String authAction, ListStore<BaseModel>bm) {
//			 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				  if (!maskTracker) { 
//					  unmask(); 
//				  }  
//				  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				   * 권한설정을 위한 콤보처리를 위한 메서드 시작
//				   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  * 권한설정을 위한 콤보처리를 위한 메서드 종료
//					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			 }
//		 }
//
//		 final Timer tmMask = new Timer() {
//			 public void run() {
//				// if (maskTracker)
//				 // { 
//				 cancel();
//				 unmask(); 
//				 maskTracker  = true;
//				 // }
//			 }
//		 }; 
//		     
//		 private void initLoad() {
//		
//			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//			 gwtAuthorization = GWTAuthorization.getInstance();
//			 gwtExtAuth = GWTExtAuth.getInstance();
//			
//			
//			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//			 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//			 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
//			 authMapDef.put("srhDeptCd",Boolean.FALSE);
//				 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
//			
//			 gwtExtAuth.setCheckMapDef(authMapDef);
//			
//			 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//				 //권한 검색조건처리를 위해 추가된 부분
//				 mask("[화면로딩] 초기화 진행 중!");
//			 }	
//			 tmMask.scheduleRepeating(5000);
//		 }
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	 
	  
	public YetaP03006(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
		//콤보 권한초기화
//		initLoad(); 
		    
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
	        //FormLayout layout = new FormLayout();
	        //layout.setDefaultWidth(600);
	       // layout.setLabelWidth(0);  
	       // this.setLayout(layout);   
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
		   
		cpYeta03006 = new ContentPanel();  

		createSearchForm();		//기본정보 필드를 적용
		createMsfGridForm();	//그리드필드
		createStandardForm(); 	//기본정보필드   
		   
		cpYeta03006.setBodyBorder(false);
		cpYeta03006.setBorders(false);
		cpYeta03006.setHeaderVisible(false);
		cpYeta03006.setSize("790px", "640px");
		   
		this.add(cpYeta03006);
		formBinding = new FormBinding(this, true);
		    
		this.setSize("810px", "710px");  
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
	  
	/**
	 * 기본정보 설정
	 */
	private void createSearchForm() {
		
		actionDatabase = ActionDatabase.UPDATE;
			
		systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta03006.add(systemkey);
			
		dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYeta03006.add(dpobCd);
		    
		edacRvyy = new HiddenField<String>();	/** column 정산년도 : edacRvyy */
		edacRvyy.setName("edacRvyy");
		cpYeta03006.add(edacRvyy);
		    
		settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
		settGbcd.setName("settGbcd");
		cpYeta03006.add(settGbcd);
		
		deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		deptNm.setName("deptNm");
		cpYeta03006.add(deptNm);
		    
		hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		hanNm.setName("hanNm");
		cpYeta03006.add(hanNm);
		
		siteNumb = new HiddenField<String>();		/** column 성명 : hanNm */
		siteNumb.setName("siteNumb");
		cpYeta03006.add(siteNumb);
		
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		     
		     // sysComBass0400Dto.setDeptDspyYn("Y");
//		     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
//		     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		     
//		     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//		     
//		     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//		    	 public void handleEvent(StoreEvent<BaseModel> be) {  
//		    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
//		    		 srhDeptCd.getStore().add(mDtalistDeptCd);
//		    	 }
//		     });     
		        

		cpYeta03006.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaNew = new Button("신규");
		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				//종전근무지상세 초기화
				resetYetaP03006();
				
				actionDatabase = ActionDatabase.INSERT;
//				doAction(actionDatabase);
			}
		});
			
		topYetaBtnBar.add(btnYetaNew);

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Iterator<BaseModel> itBm = yetaP03006GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();

				if((ActionDatabase.INSERT).equals(actionDatabase)) {
					yetaP03006GridPanel.getMsfGrid().clearData();
					resetYetaP03006();	//종전근무지상세 초기화
					actionDatabase = ActionDatabase.DELETE;
					
				}else {
					
					while (itBm.hasNext()) {
						Record rec = new Record(itBm.next());
						lsRec.add(rec);
					}
					setListRecord(lsRec.iterator());

					actionDatabase = ActionDatabase.DELETE;
					doAction(actionDatabase);
				}
			}
		});
		topYetaBtnBar.add(btnYetaDel);
				
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(yetaP03006GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
				doAction(actionDatabase);

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});

		topYetaBtnBar.add(btnYetaSave);
				
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
				
		cpYeta03006.add(topYetaBtnBar);
		  	
		  	
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);
			
		srhEdacRvyy = new TextField<String>();
		srhEdacRvyy.setName("edacRvyy");
//		srhEdacRvyy.setForceSelection(true);
//		srhEdacRvyy.setMinChars(1);
//		srhEdacRvyy.setDisplayField("yearDisp");
//		srhEdacRvyy.setValueField("year");
//		srhEdacRvyy.setTriggerAction(TriggerAction.ALL);
		// srhEdacRvyy.setEmptyText("--년도선택--");
		srhEdacRvyy.setSelectOnFocus(true);
		srhEdacRvyy.setReadOnly(true);
		srhEdacRvyy.setEnabled(true);
//		srhEdacRvyy.setStore(lsdacRvyyStore);
		srhEdacRvyy.setFieldLabel("년도");
//		srhEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				srhEdacRvyy.setValue(lsdacRvyyStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
//			}
//		});
			
		lcSchCol01.add(srhEdacRvyy, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhSettGbcd = new ComboBox<BaseModel>();
		srhSettGbcd.setName("srhSettGbcd");
		srhSettGbcd.setForceSelection(true);
		srhSettGbcd.setMinChars(1);
		srhSettGbcd.setDisplayField("commCdNm");
		srhSettGbcd.setValueField("commCd");
		srhSettGbcd.setTriggerAction(TriggerAction.ALL);
		srhSettGbcd.setEmptyText("--정산구분선택--");
		srhSettGbcd.setSelectOnFocus(true);
		srhSettGbcd.setReadOnly(true);
		srhSettGbcd.setEnabled(true);
		srhSettGbcd.setStore(lsSettGbcd);
		srhSettGbcd.setFieldLabel("정산구분");
		srhSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				YetaUtils.setSelectedComboValue(srhSettGbcd, settGbcd.getValue(), "commCd");
//				srhSettGbcd.setValue(lsSettGbcd.getAt(0));
			}
		});
		lcSchCol02.add(srhSettGbcd, new FormData("100%"));
			
		LayoutContainer lcSchCol03 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03.setLayout(frmlytSch);

		srhDeptNm = new TextField<String>();
		srhDeptNm.setReadOnly(true);
		srhDeptNm.setName("srhDeptNm");
		srhDeptNm.setWidth(100);
		srhDeptNm.setFieldLabel("부서");

		lcSchCol03.add(srhDeptNm, new FormData("100%"));
			
			
		LayoutContainer lcSchCol04 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol04.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setReadOnly(true);
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");

		lcSchCol04.add(srhHanNm, new FormData("100%"));
			
		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta03006.add(fieldSet);
		
	}  
	 	 
	  private void createStandardForm() {
		  
		  LayoutContainer lcFormLayer = new LayoutContainer();
		  lcFormLayer.setSize("785px", "270px");  
		  
//		  ContentPanel cp01 = new ContentPanel();   
//		  cp01.setBodyBorder(false); 
//		  cp01.setHeaderVisible(false);   
//		  cp01.setLayout(new FitLayout());      
//		  cp01.setSize("780px", "350px");  
		  
		  LayoutContainer layoutContainer = new LayoutContainer();
	      
	      //종전근무지상세
	      LayoutContainer layoutContainer_1 = new LayoutContainer();
	      
		  FieldSet fieldSet_01 = new FieldSet();
		  fieldSet_01.setHeadingHtml("종전근무지상세");
		  fieldSet_01.setBorders(true);
//		  fieldSet_01.setWidth("780px");
//		  layoutContainer_1.add(fieldSet_01);
	      
//	      LabelField lblfldNewLabelfield = new LabelField("종전근무지상세");
//	      layoutContainer_1.add(lblfldNewLabelfield);
	      
	      layoutContainer.add(layoutContainer_1);
	      layoutContainer_1.setBorders(false);
	      
	      LayoutContainer layoutContainer_2 = new LayoutContainer();
	      layoutContainer_2.setLayout(new ColumnLayout());
	      
	      LayoutContainer layoutContainer_5 = new LayoutContainer();
	      layoutContainer_5.setBorders(true);
	      
	      LayoutContainer layoutContainer_7 = new LayoutContainer();
	      layoutContainer_7.setLayout(new ColumnLayout());
	      
	      
	      //근무기간
	      LayoutContainer layoutContainer_27 = new LayoutContainer();
	      
		  FormLayout frmlytSch5 = new FormLayout();  
		  frmlytSch5.setLabelWidth(80); 
		  frmlytSch5.setLabelAlign(LabelAlign.RIGHT); 
			  
		  layoutContainer_27.setLayout(frmlytSch5);
	      
		  jeymStdt = new MSFDateField();
	      layoutContainer_27.add(jeymStdt, new FormData("100%"));
	      new DateFieldMask(jeymStdt, "9999.99.99"); 
	      jeymStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	      jeymStdt.setFieldLabel("근무기간");
	      layoutContainer_7.add(layoutContainer_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_27.setBorders(false);
	      
	      LayoutContainer layoutContainer_28 = new LayoutContainer();
	      
	      FormLayout frmlytSch6 = new FormLayout();  
	      frmlytSch6.setLabelWidth(5); 
	      frmlytSch6.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_28.setLayout(frmlytSch6);
	      
	      jeymEddt = new MSFDateField();
	      layoutContainer_28.add(jeymEddt, new FormData("100%"));
	      new DateFieldMask(jeymEddt, "9999.99.99"); 
	      jeymEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	      jeymEddt.setLabelSeparator("~");
	      layoutContainer_7.add(layoutContainer_28, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_28.setBorders(false);
	      

	      layoutContainer_5.add(layoutContainer_7);
	      layoutContainer_7.setBorders(false);
	      
	      LayoutContainer layoutContainer_8 = new LayoutContainer();
	      layoutContainer_8.setLayout(new ColumnLayout());
	      
	      //성명
	      LayoutContainer layoutContainer_29 = new LayoutContainer();
	      
	      FormLayout frmlytSch7 = new FormLayout();  
	      frmlytSch7.setLabelWidth(80); 
	      frmlytSch7.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_29.setLayout(frmlytSch7);
	      
	      hanNm01 = new MSFTextField();
	      layoutContainer_29.add(hanNm01, new FormData("100%"));
	      hanNm01.setFieldLabel("성 명");
	      layoutContainer_8.add(layoutContainer_29, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_29.setBorders(false);
	      
	      //사업자등록번호
	      LayoutContainer layoutContainer_30 = new LayoutContainer();
	      
	      FormLayout frmlytSch8 = new FormLayout();  
	      frmlytSch8.setLabelWidth(130); 
	      frmlytSch8.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_30.setLayout(frmlytSch8);
	      
	      siteNumb01 = new MSFTextField();
	      layoutContainer_30.add(siteNumb01, new FormData("100%"));
	      new TextFieldMask<String>(siteNumb01, "999-99-99999");
	      siteNumb01.setFieldLabel("사업자등록번호");
	      layoutContainer_8.add(layoutContainer_30, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_30.setBorders(false);
	      
	      
	      layoutContainer_5.add(layoutContainer_8);
	      layoutContainer_8.setBorders(false);
	      
	      LayoutContainer layoutContainer_9 = new LayoutContainer();
	      layoutContainer_9.setLayout(new ColumnLayout());
	      
	      //급여합계
	      LayoutContainer layoutContainer_31 = new LayoutContainer();
	      
	      FormLayout frmlytSch9 = new FormLayout();  
	      frmlytSch9.setLabelWidth(80); 
	      frmlytSch9.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_31.setLayout(frmlytSch9);
	      
	      payrTotl = new MSFNumberField();
	      
	      payrTotl.setAllowDecimals(true); 
	      payrTotl.setPropertyEditorType(Long.class); 
	      payrTotl.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_31.add(payrTotl, new FormData("100%"));
	      payrTotl.setFieldLabel("급여합계");
	      layoutContainer_9.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_31.setBorders(false);
	      
	      //국민연금보험료지출액
	      LayoutContainer layoutContainer_32 = new LayoutContainer();
	      
	      FormLayout frmlytSch10 = new FormLayout();  
	      frmlytSch10.setLabelWidth(130); 
	      frmlytSch10.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_32.setLayout(frmlytSch10);
	      
	      annuMuam = new MSFNumberField();
	      
	      annuMuam.setAllowDecimals(true); 
	      annuMuam.setPropertyEditorType(Long.class); 
	      annuMuam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_32.add(annuMuam, new FormData("100%"));
	      annuMuam.setFieldLabel("국민연금보험료지출액");
	      layoutContainer_9.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_32.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_9);
	      layoutContainer_9.setBorders(false);
	      
	      
	      //
	      LayoutContainer layoutContainer_11 = new LayoutContainer();
	      layoutContainer_11.setLayout(new ColumnLayout());
	      
	      
	      //소득세
	      LayoutContainer layoutContainer_35 = new LayoutContainer();
	      
	      FormLayout frmlytSch11 = new FormLayout();  
	      frmlytSch11.setLabelWidth(80); 
	      frmlytSch11.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_35.setLayout(frmlytSch11);
	      
	      earnTaxn = new MSFNumberField();
	      
	      earnTaxn.setAllowDecimals(true); 
	      earnTaxn.setPropertyEditorType(Long.class); 
	      earnTaxn.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_35.add(earnTaxn, new FormData("100%"));
	      earnTaxn.setFieldLabel("소득세");
	      
	      layoutContainer_11.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_35.setBorders(false);
	      
	      //국민연금보험료공제액
	      LayoutContainer layoutContainer_36 = new LayoutContainer();
	      
	      FormLayout frmlytSch12 = new FormLayout();  
	      frmlytSch12.setLabelWidth(130); 
	      frmlytSch12.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_36.setLayout(frmlytSch12);
	      
	      annuDdam = new MSFNumberField();
	      
	      annuDdam.setAllowDecimals(true); 
	      annuDdam.setPropertyEditorType(Long.class); 
	      annuDdam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_36.add(annuDdam, new FormData("100%"));
	      annuDdam.setFieldLabel("국민연금보험료공제액");
	      layoutContainer_11.add(layoutContainer_36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_36.setBorders(false);
	      
	      
	      layoutContainer_5.add(layoutContainer_11);
	      
	      LayoutContainer layoutContainer_12 = new LayoutContainer();
	      layoutContainer_12.setLayout(new ColumnLayout());
	      
	      //상여합계
	      LayoutContainer layoutContainer_37 = new LayoutContainer();
	      
	      FormLayout frmlytSch13 = new FormLayout();  
	      frmlytSch13.setLabelWidth(80); 
	      frmlytSch13.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_37.setLayout(frmlytSch13);
	      
	      bonsAmnt = new MSFNumberField();
	      
	      bonsAmnt.setAllowDecimals(true); 
	      bonsAmnt.setPropertyEditorType(Long.class); 
	      bonsAmnt.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_37.add(bonsAmnt, new FormData("100%"));
	      bonsAmnt.setFieldLabel("상여합계");
	      layoutContainer_12.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_37.setBorders(false);
	      
	      //건강보험료지출액
	      LayoutContainer layoutContainer_38 = new LayoutContainer();
	      
	      FormLayout frmlytSch14 = new FormLayout();  
	      frmlytSch14.setLabelWidth(130); 
	      frmlytSch14.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_38.setLayout(frmlytSch14);
	      
	      hlthDbam = new MSFNumberField();
	      
	      hlthDbam.setAllowDecimals(true); 
	      hlthDbam.setPropertyEditorType(Long.class); 
	      hlthDbam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_38.add(hlthDbam, new FormData("100%"));
	      hlthDbam.setFieldLabel("건강보험료지출액");
	      layoutContainer_12.add(layoutContainer_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_38.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_12);
	      layoutContainer_12.setBorders(false);
	      
	      LayoutContainer layoutContainer_13 = new LayoutContainer();
	      layoutContainer_13.setLayout(new ColumnLayout());
	      
	      //주민세
	      LayoutContainer layoutContainer_39 = new LayoutContainer();
	      
	      FormLayout frmlytSch15 = new FormLayout();  
	      frmlytSch15.setLabelWidth(80); 
	      frmlytSch15.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_39.setLayout(frmlytSch15);
	      
	      ihtxTaxn = new MSFNumberField();
	      
	      ihtxTaxn.setAllowDecimals(true); 
	      ihtxTaxn.setPropertyEditorType(Long.class); 
	      ihtxTaxn.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_39.add(ihtxTaxn, new FormData("100%"));
	      ihtxTaxn.setFieldLabel("지방소득세");
	      layoutContainer_13.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_39.setBorders(false);
	      
	      //건강보험료공제액
	      LayoutContainer layoutContainer_40 = new LayoutContainer();
	      
	      FormLayout frmlytSch16 = new FormLayout();  
	      frmlytSch16.setLabelWidth(130); 
	      frmlytSch16.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_40.setLayout(frmlytSch16);
	      
	      hlthMuam = new MSFNumberField();
	      
	      hlthMuam.setAllowDecimals(true); 
	      hlthMuam.setPropertyEditorType(Long.class); 
	      hlthMuam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_40.add(hlthMuam, new FormData("100%"));
	      hlthMuam.setFieldLabel("건강보험료공제액");
	      layoutContainer_13.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_40.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_13);
	      layoutContainer_13.setBorders(false);
	      
	      LayoutContainer layoutContainer_14 = new LayoutContainer();
	      layoutContainer_14.setLayout(new ColumnLayout());
	      
	      //인정상여
	      LayoutContainer layoutContainer_41 = new LayoutContainer();
	      
	      FormLayout frmlytSch17 = new FormLayout();  
	      frmlytSch17.setLabelWidth(80); 
	      frmlytSch17.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_41.setLayout(frmlytSch17);
	      
	      dtmnBtam = new MSFNumberField();
	      
	      dtmnBtam.setAllowDecimals(true); 
	      dtmnBtam.setPropertyEditorType(Long.class); 
	      dtmnBtam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_41.add(dtmnBtam, new FormData("100%"));
	      dtmnBtam.setFieldLabel("인정상여");
	      layoutContainer_14.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_41.setBorders(false);
	      
	      
	      //고용보험지출액
	      LayoutContainer layoutContainer_42 = new LayoutContainer();
	      
	      FormLayout frmlytSch18 = new FormLayout();  
	      frmlytSch18.setLabelWidth(130); 
	      frmlytSch18.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_42.setLayout(frmlytSch18);
	      
	      upisJuam= new MSFNumberField();
	      
	      upisJuam.setAllowDecimals(true); 
	      upisJuam.setPropertyEditorType(Long.class); 
	      upisJuam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_42.add(upisJuam, new FormData("100%"));
	      upisJuam.setFieldLabel("고용보험지출액");
	      layoutContainer_14.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_42.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_14);
	      layoutContainer_14.setBorders(false);
	      
	      
	      
	      LayoutContainer layoutContainer_15 = new LayoutContainer();
	      layoutContainer_15.setLayout(new ColumnLayout());
	      
	      //농특세
	      LayoutContainer layoutContainer_43 = new LayoutContainer();
	      
	      FormLayout frmlytSch19 = new FormLayout();  
	      frmlytSch19.setLabelWidth(80); 
	      frmlytSch19.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_43.setLayout(frmlytSch19);
	      
	      farmTaxn = new MSFNumberField();
	      
	      farmTaxn.setAllowDecimals(true); 
	      farmTaxn.setPropertyEditorType(Long.class); 
	      farmTaxn.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_43.add(farmTaxn, new FormData("100%"));
	      farmTaxn.setFieldLabel("농특세");
	      layoutContainer_15.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_43.setBorders(false);
	      
	      //고용보험공제액
	      LayoutContainer layoutContainer_44 = new LayoutContainer();
	      
	      FormLayout frmlytSch20 = new FormLayout();  
	      frmlytSch20.setLabelWidth(130); 
	      frmlytSch20.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_44.setLayout(frmlytSch20);
	      
	      upisMuam = new MSFNumberField();
	      
	      upisMuam.setAllowDecimals(true); 
	      upisMuam.setPropertyEditorType(Long.class); 
	      upisMuam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_44.add(upisMuam, new FormData("100%"));
	      upisMuam.setFieldLabel("고용보험공제액");
	      layoutContainer_15.add(layoutContainer_44, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_44.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_15);
	      layoutContainer_15.setBorders(false);
	      
	      LayoutContainer layoutContainer_16 = new LayoutContainer();
	      layoutContainer_16.setLayout(new ColumnLayout());
	      
	      //주식행사이익
	      LayoutContainer layoutContainer_45 = new LayoutContainer();
	      
	      FormLayout frmlytSch21 = new FormLayout();  
	      frmlytSch21.setLabelWidth(80); 
	      frmlytSch21.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_45.setLayout(frmlytSch21);
	      
	      stckPrft = new MSFNumberField();
	      
	      stckPrft.setAllowDecimals(true); 
	      stckPrft.setPropertyEditorType(Long.class); 
	      stckPrft.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_45.add(stckPrft, new FormData("100%"));
	      stckPrft.setFieldLabel("주식행사이익");
	      layoutContainer_16.add(layoutContainer_45, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_45.setBorders(false);
	      
	      
	      // 우리사주조합인출금액
	      LayoutContainer layoutContainer_46 = new LayoutContainer();
	      
	      frmlytSch21 = new FormLayout();  
	      frmlytSch21.setLabelWidth(130); 
	      frmlytSch21.setLabelAlign(LabelAlign.RIGHT); 			  
	      layoutContainer_46.setLayout(frmlytSch21);
	      
	      unonAmnt = new MSFNumberField();
	      
	      unonAmnt.setAllowDecimals(true); 
	      unonAmnt.setPropertyEditorType(Long.class); 
	      unonAmnt.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_46.add(unonAmnt, new FormData("100%"));
	      unonAmnt.setFieldLabel("우리사주인출금액");
	      layoutContainer_16.add(layoutContainer_46, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_46.setBorders(false);	      
	      
	      
	      layoutContainer_16.add(layoutContainer_46, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_46.setBorders(false);
	      
	      
	      layoutContainer_5.add(layoutContainer_16);
	      layoutContainer_16.setBorders(false);
	      
	      LayoutContainer layoutContainer_47 = new LayoutContainer();
	      layoutContainer_47.setLayout(new ColumnLayout());
	      
	      //비과세합계
	      LayoutContainer layoutContainer_49 = new LayoutContainer();
	      
	      FormLayout frmlytSch22 = new FormLayout();  
	      frmlytSch22.setLabelWidth(80); 
	      frmlytSch22.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_49.setLayout(frmlytSch22);
	      
	      taxeTotl = new MSFNumberField();
	      
	      taxeTotl.setAllowDecimals(true); 
	      taxeTotl.setPropertyEditorType(Long.class); 
	      taxeTotl.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_49.add(taxeTotl, new FormData("100%"));
	      taxeTotl.setFieldLabel("비과세합계");
	      layoutContainer_47.add(layoutContainer_49, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      
	      //임원퇴직한도초과액
	      LayoutContainer layoutContainer_50 = new LayoutContainer();
	      
	      FormLayout frmlytSch23 = new FormLayout();  
	      frmlytSch23.setLabelWidth(130); 
	      frmlytSch23.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_50.setLayout(frmlytSch23);
	      
	      ofrrExli = new MSFNumberField();
	      
	      ofrrExli.setAllowDecimals(true); 
	      ofrrExli.setPropertyEditorType(Long.class); 
	      ofrrExli.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_50.add(ofrrExli, new FormData("100%"));
	      ofrrExli.setFieldLabel("임원퇴직한도초과액");
	      layoutContainer_47.add(layoutContainer_50, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_5.add(layoutContainer_47);
	      layoutContainer_47.setBorders(false);
	      
	      
	      layoutContainer_2.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_5.setBorders(false);
	      
	      //
	      LayoutContainer layoutContainer_6 = new LayoutContainer();
	      
	      LayoutContainer layoutContainer_17= new LayoutContainer();
	      layoutContainer_17.setLayout(new ColumnLayout());
	      
	      //감면기간
	      LayoutContainer layoutContainer_51 = new LayoutContainer();
	      
	      FormLayout frmlytSch24 = new FormLayout();  
	      frmlytSch24.setLabelWidth(80); 
	      frmlytSch24.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_51.setLayout(frmlytSch24);
	      
	      jutrStdt = new MSFDateField();
	      layoutContainer_51.add(jutrStdt, new FormData("100%"));
	      new DateFieldMask(jutrStdt, "9999.99.99"); 
	      jutrStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	      jutrStdt.setFieldLabel("감면기간");
	      layoutContainer_17.add(layoutContainer_51, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      
	      LayoutContainer layoutContainer_52 = new LayoutContainer();
	      
	      FormLayout frmlytSch25 = new FormLayout();  
	      frmlytSch25.setLabelWidth(5); 
	      frmlytSch25.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_52.setLayout(frmlytSch25);
	      
	      jutrEddt = new MSFDateField();
	      layoutContainer_52.add(jutrEddt, new FormData("100%"));
	      new DateFieldMask(jutrEddt, "9999.99.99"); 
	      jutrEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	      jutrEddt.setLabelSeparator("~");
	      layoutContainer_17.add(layoutContainer_52, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      
	      layoutContainer_6.add(layoutContainer_17);
	      layoutContainer_17.setBorders(false);
	      
	      //근무지명
	      LayoutContainer layoutContainer_18= new LayoutContainer();
	      
	      FormLayout frmlytSch26 = new FormLayout();  
	      frmlytSch26.setLabelWidth(80); 
	      frmlytSch26.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_18.setLayout(frmlytSch26);
	      
	      siteCtnt = new MSFTextField();
	      layoutContainer_18.add(siteCtnt, new FormData("100%"));
	      siteCtnt.setFieldLabel("근무지명");
	      
	      layoutContainer_6.add(layoutContainer_18);
	      layoutContainer_18.setBorders(false);
	      
	      LayoutContainer layoutContainer_19= new LayoutContainer();
	      layoutContainer_19.setLayout(new ColumnLayout());
	      
	      //국민연금외공무원연금
	      LayoutContainer layoutContainer_55 = new LayoutContainer();
	      
	      FormLayout frmlytSch27 = new FormLayout();  
	      frmlytSch27.setLabelWidth(130); 
	      frmlytSch27.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_55.setLayout(frmlytSch27);
	      
	      auetMuam = new MSFNumberField();
	      
	      auetMuam.setAllowDecimals(true); 
	      auetMuam.setPropertyEditorType(Long.class); 
	      auetMuam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_55.add(auetMuam, new FormData("100%"));
	      auetMuam.setFieldLabel("국민연금외공무원연금");
	      layoutContainer_19.add(layoutContainer_55, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_55.setBorders(false);
	      
	      //국민연금외공무원연금_공제액
	      LayoutContainer layoutContainer_56 = new LayoutContainer();
	      
	      FormLayout frmlytSch28 = new FormLayout();  
	      frmlytSch28.setLabelWidth(80); 
	      frmlytSch28.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_56.setLayout(frmlytSch28);
	      
	      auetDdam = new MSFNumberField();
	      
	      auetDdam.setAllowDecimals(true); 
	      auetDdam.setPropertyEditorType(Long.class); 
	      auetDdam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_56.add(auetDdam, new FormData("100%"));
	      auetDdam.setFieldLabel("공제액");
	      layoutContainer_19.add(layoutContainer_56, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_56.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_19);
	      layoutContainer_19.setBorders(false);
	      
	      LayoutContainer layoutContainer_20= new LayoutContainer();
	      layoutContainer_20.setLayout(new ColumnLayout());
	      
	      //국민연금외군인연금
	      LayoutContainer layoutContainer_57 = new LayoutContainer();
	      
	      FormLayout frmlytSch29 = new FormLayout();  
	      frmlytSch29.setLabelWidth(130); 
	      frmlytSch29.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_57.setLayout(frmlytSch29);
	      
	      auetSold = new MSFNumberField();
	      
	      auetSold.setAllowDecimals(true); 
	      auetSold.setPropertyEditorType(Long.class); 
	      auetSold.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_57.add(auetSold, new FormData("100%"));
	      auetSold.setFieldLabel("국민연금외군인연금");
	      layoutContainer_20.add(layoutContainer_57, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_57.setBorders(false);
	      
	      //국민연금외군인연금_공제액
	      LayoutContainer layoutContainer_58 = new LayoutContainer();
	      
	      FormLayout frmlytSch30 = new FormLayout();  
	      frmlytSch30.setLabelWidth(80); 
	      frmlytSch30.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_58.setLayout(frmlytSch30);
	      
	      auetDold = new MSFNumberField();
	      
	      auetDold.setAllowDecimals(true); 
	      auetDold.setPropertyEditorType(Long.class); 
	      auetDold.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_58.add(auetDold, new FormData("100%"));
	      auetDold.setFieldLabel("공제액");
	      layoutContainer_20.add(layoutContainer_58, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_58.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_20);
	      layoutContainer_20.setBorders(false);
	      
	      LayoutContainer layoutContainer_21= new LayoutContainer();
	      layoutContainer_21.setLayout(new ColumnLayout());
	      
	      //국민연금외교직원연금
	      LayoutContainer layoutContainer_59 = new LayoutContainer();
	      
	      FormLayout frmlytSch31 = new FormLayout();  
	      frmlytSch31.setLabelWidth(130); 
	      frmlytSch31.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_59.setLayout(frmlytSch31);
	      
	      auetTech = new MSFNumberField();
	      
	      auetTech.setAllowDecimals(true); 
	      auetTech.setPropertyEditorType(Long.class); 
	      auetTech.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_59.add(auetTech, new FormData("100%"));
	      auetTech.setFieldLabel("국민연금외교직원연금");
	      layoutContainer_21.add(layoutContainer_59, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_59.setBorders(false);
	      
	      //국민연금외교직원연금_공제액
	      LayoutContainer layoutContainer_60= new LayoutContainer();
	      
	      FormLayout frmlytSch32= new FormLayout();  
	      frmlytSch32.setLabelWidth(80); 
	      frmlytSch32.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_60.setLayout(frmlytSch32);
	      
	      auetDech = new MSFNumberField();
	      
	      auetDech.setAllowDecimals(true); 
	      auetDech.setPropertyEditorType(Long.class); 
	      auetDech.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_60.add(auetDech, new FormData("100%"));
	      auetDech.setFieldLabel("공제액");
	      layoutContainer_21.add(layoutContainer_60, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_60.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_21);
	      layoutContainer_21.setBorders(false);
	      
	      LayoutContainer layoutContainer_22= new LayoutContainer();
	      layoutContainer_22.setLayout(new ColumnLayout());
	      
	      
	      //국민연금외별정우체국
	      LayoutContainer layoutContainer_61 = new LayoutContainer();
	      
	      FormLayout frmlytSch33= new FormLayout();  
	      frmlytSch33.setLabelWidth(130); 
	      frmlytSch33.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_61.setLayout(frmlytSch33);
	      
	      auetFect = new MSFNumberField();
	      
	      auetFect.setAllowDecimals(true); 
	      auetFect.setPropertyEditorType(Long.class); 
	      auetFect.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_61.add(auetFect, new FormData("100%"));
	      auetFect.setFieldLabel("국민연금외별정우체국");
	      layoutContainer_22.add(layoutContainer_61, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_61.setBorders(false);
	      
	      
	      //국민연금외별정우체국_공제액
	      LayoutContainer layoutContainer_62 = new LayoutContainer();
	      
	      FormLayout frmlytSch34= new FormLayout();  
	      frmlytSch34.setLabelWidth(80); 
	      frmlytSch34.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_62.setLayout(frmlytSch34);
	      
	      auetDect = new MSFNumberField();
	      
	      auetDect.setAllowDecimals(true); 
	      auetDect.setPropertyEditorType(Long.class); 
	      auetDect.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_62.add(auetDect, new FormData("100%"));
	      auetDect.setFieldLabel("공제액");
	      layoutContainer_22.add(layoutContainer_62, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_62.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_22);
	      layoutContainer_22.setBorders(false);
	      
	      LayoutContainer layoutContainer_24= new LayoutContainer();
	      layoutContainer_24.setLayout(new ColumnLayout());
	      
	      LayoutContainer layoutContainer_65 = new LayoutContainer();
	      layoutContainer_24.add(layoutContainer_65);
	      layoutContainer_65.setBorders(false);
	      
	      LayoutContainer layoutContainer_66 = new LayoutContainer();
	      layoutContainer_24.add(layoutContainer_66);
	      layoutContainer_66.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_24);
	      layoutContainer_24.setHeight("26");
	      layoutContainer_24.setBorders(false);
	      
	      LayoutContainer layoutContainer_25= new LayoutContainer();
	      layoutContainer_25.setLayout(new ColumnLayout());
	      
	      
	      //과학기술인공제
	      LayoutContainer layoutContainer_67 = new LayoutContainer();
	      
	      FormLayout frmlytSch35= new FormLayout();  
	      frmlytSch35.setLabelWidth(130); 
	      frmlytSch35.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_67.setLayout(frmlytSch35);
	      
	      rtreMuam = new MSFNumberField();
	      
	      rtreMuam.setAllowDecimals(true); 
	      rtreMuam.setPropertyEditorType(Long.class); 
	      rtreMuam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_67.add(rtreMuam, new FormData("100%"));
	      rtreMuam.setFieldLabel("과학기술인공제");
	      layoutContainer_25.add(layoutContainer_67, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_67.setBorders(false);
	      
	      
	      //과학기술인공제_공제액
	      LayoutContainer layoutContainer_68 = new LayoutContainer();
	      
	      FormLayout frmlytSch36= new FormLayout();  
	      frmlytSch36.setLabelWidth(80); 
	      frmlytSch36.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_68.setLayout(frmlytSch36);
	      
	      rtreDdam = new MSFNumberField();
	      
	      rtreDdam.setAllowDecimals(true); 
	      rtreDdam.setPropertyEditorType(Long.class); 
	      rtreDdam.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_68.add(rtreDdam, new FormData("100%"));
	      rtreDdam.setFieldLabel("공제액");
	      layoutContainer_25.add(layoutContainer_68, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_68.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_25);
	      layoutContainer_25.setBorders(false);
	      
	      LayoutContainer layoutContainer_26= new LayoutContainer();
	      layoutContainer_26.setLayout(new ColumnLayout());
	      
	      //근로자퇴직보장법
	      LayoutContainer layoutContainer_69= new LayoutContainer();
	      
	      FormLayout frmlytSch37 = new FormLayout();  
	      frmlytSch37.setLabelWidth(130); 
	      frmlytSch37.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_69.setLayout(frmlytSch37);
	      
	      rtrePsct = new MSFNumberField();
	      
	      rtrePsct.setAllowDecimals(true); 
	      rtrePsct.setPropertyEditorType(Long.class); 
	      rtrePsct.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_69.add(rtrePsct, new FormData("100%"));
	      rtrePsct.setFieldLabel("근로자퇴직보장법");
	      layoutContainer_26.add(layoutContainer_69, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_69.setBorders(false);
	      
	      
	      //근로자퇴직보장법_공제액
	      LayoutContainer layoutContainer_70 = new LayoutContainer();
	      
	      FormLayout frmlytSch38 = new FormLayout();  
	      frmlytSch38.setLabelWidth(80); 
	      frmlytSch38.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_70.setLayout(frmlytSch38);
	      
	      rtreDsct = new MSFNumberField();
	      
	      rtreDsct.setAllowDecimals(true); 
	      rtreDsct.setPropertyEditorType(Long.class); 
	      rtreDsct.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_70.add(rtreDsct, new FormData("100%"));
	      rtreDsct.setFieldLabel("공제액");
	      layoutContainer_26.add(layoutContainer_70, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_70.setBorders(false);
	      
	      
	      layoutContainer_6.add(layoutContainer_26);
	      layoutContainer_26.setBorders(false);
	      
	      LayoutContainer layoutContainer_48 = new LayoutContainer();
	      layoutContainer_48.setLayout(new ColumnLayout());
	      
	      //연금저축계좌
	      LayoutContainer layoutContainer_71 = new LayoutContainer();
	      
	      FormLayout frmlytSch39 = new FormLayout();  
	      frmlytSch39.setLabelWidth(130); 
	      frmlytSch39.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_71.setLayout(frmlytSch39);
	      
	      rtreAnsv = new MSFNumberField();
	      
	      rtreAnsv.setAllowDecimals(true); 
	      rtreAnsv.setPropertyEditorType(Long.class); 
	      rtreAnsv.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_71.add(rtreAnsv, new FormData("100%"));
	      rtreAnsv.setFieldLabel("연금저축계좌");
	      layoutContainer_48.add(layoutContainer_71, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	      layoutContainer_71.setBorders(false);
	      
	      //연금저축계좌_공제액
	      LayoutContainer layoutContainer_72 = new LayoutContainer();
	      
	      FormLayout frmlytSch40 = new FormLayout();  
	      frmlytSch40.setLabelWidth(80); 
	      frmlytSch40.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_72.setLayout(frmlytSch40);
	      
	      rtreDnsv = new MSFNumberField();
	      
	      rtreDnsv.setAllowDecimals(true); 
	      rtreDnsv.setPropertyEditorType(Long.class); 
	      rtreDnsv.setFormat(NumberFormat.getDecimalFormat());
			
	      layoutContainer_72.add(rtreDnsv, new FormData("100%"));
	      rtreDnsv.setFieldLabel("공제액");
	      layoutContainer_48.add(layoutContainer_72, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	      layoutContainer_72.setBorders(false);
	      
	      
	      layoutContainer_6.add(layoutContainer_48);
	      layoutContainer_48.setBorders(false);
	      
	      layoutContainer_2.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_6.setBorders(false);
	      
	      
	      
	      layoutContainer.add(layoutContainer_2);
	      layoutContainer_2.setBorders(false);
	      
	      LayoutContainer layoutContainer_3 = new LayoutContainer();
	      layoutContainer_3.setLayout(new ColumnLayout());
	      
	      LabelField lblfldNewLabelfield_1 = new LabelField("원천징수영수증제출여부");
	      layoutContainer_3.add(lblfldNewLabelfield_1);
	      
	      wthdSbyn = new RadioGroup();
	      
	      Radio wthdSbY = new Radio();
	      wthdSbyn.add(wthdSbY);
	      wthdSbY.setBoxLabel("제출");
	      wthdSbY.setHideLabel(true);
	      wthdSbY.setValueAttribute("1");
	      
	      Radio wthdSbN = new Radio();
	      wthdSbyn.add(wthdSbN);
	      wthdSbN.setBoxLabel("미제출");
	      wthdSbN.setHideLabel(true);
	      wthdSbN.setValueAttribute("0");
	      
	      layoutContainer_3.add(wthdSbyn);
	      
	      LabelField lblfldNewLabelfield_2 = new LabelField("처리구분");
	      layoutContainer_3.add(lblfldNewLabelfield_2);
	      
	      mangGbyn = new RadioGroup();
//	      wthdSbyn.setLabelSeparator("처리구분");
//	      wthdSbyn.setHideLabel(true);
	      
	      Radio mangGbY = new Radio();
	      mangGbyn.add(mangGbY);
	      mangGbY.setBoxLabel("예");
	      mangGbY.setHideLabel(true);
	      mangGbY.setValueAttribute("1");
	      
	      Radio mangGbN = new Radio();
	      mangGbyn.add(mangGbN);
	      mangGbN.setBoxLabel("아니오");
	      mangGbN.setHideLabel(true);
	      mangGbN.setValueAttribute("0");
	      
	      layoutContainer_3.add(mangGbyn);
	      
	      layoutContainer.add(layoutContainer_3);
	      layoutContainer_3.setBorders(false);
	      
	      
	      
	      LayoutContainer layoutContainer_4 = new LayoutContainer();
	      layoutContainer_4.setLayout(new ColumnLayout());
	      
	      LabelField lblfldNewLabelfield_3 = new LabelField("* 원천징수 영수증 제출 '예', 처리구분 '예'인 자료만 연말정산 종전근무지에 등록됩니다.");
	      layoutContainer_4.add(lblfldNewLabelfield_3);	      

	      Button btnNewButton = new Button("비과세 및 감면소득 입력");
		  btnNewButton.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				//TODO 수정하기..
				BaseModel bmData = yetaP03006GridPanel.getCurrentlySelectedItem(); 
				
				funcSetPopUpRecord();
				setPPRecord(bmData); //팝업에 넘길값 
				
				if(MSFSharedUtils.paramNotNull(bmData)){
					dpobCd.setValue((String) bmData.get("dpobCd"));		/**  column 사업장코드 : dpobCd */
					edacRvyy.setValue((String) bmData.get("edacRvyy"));	/** column 연말정산귀속년도 : edacRvyy */
					settGbcd.setValue((String) bmData.get("settGbcd"));	/** column 정산구분코드 : settGbcd */
					systemkey.setValue((String) bmData.get("systemkey"));/**  column SYSTEMKEY : systemkey */
					siteNumb.setValue((String) bmData.get("siteNumb"));//사업자등록번호
				}
	        	   
				//전체내역  
				YetaP03008 yetaP03008Form = new YetaP03008(ActionDatabase.READ, getThis());   
						    
				MSFFormWindows msFwYeta03008 = new MSFFormWindows("비과세 및 감면소득", yetaP03008Form, "닫기", "820px", "710px", true);
				msFwYeta03008.show();
				yetaP03008Form.setMSFFormWindows(msFwYeta03008);
				
				//TODO 추후 주석해제 
				yetaP03008Form.bind(ppRecord);

				}
			});
		  layoutContainer_4.add(btnNewButton);
		  
	      layoutContainer.add(layoutContainer_4);
	      layoutContainer_4.setBorders(false);
	      
	      layoutContainer.setBorders(false);
	      
	      fieldSet_01.add(layoutContainer);
	      
//	      cp01.add(layoutContainer);
//	      cp01.add(fieldSet_01);
//	      lcFormLayer.add(cp01);
	      lcFormLayer.add(fieldSet_01);
	      cpYeta03006.add(lcFormLayer);
//	      return lcFormLayer;	  
	  } 
	  
	 
			
   	
	@Override	
	public void bind(final ModelData model) { 
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				
				srhDeptNm.setValue(deptNm.getValue());
				srhHanNm.setValue(hanNm.getValue());
				
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
		
	private void createMsfGridForm() {			
		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("종전근무지내역");
		gridFieldSet.setBorders(true);
			
		yetaP03006GridPanel = new MSFGridPanel(yetaP03006ToYeta03110Def, false, false, false, false, false);
		yetaP03006GridPanel.setHeaderVisible(false);  
		yetaP03006GridPanel.setSize("780px", "200px");
		yetaP03006GridPanel.setBorders(true);
		yetaP03006GridPanel.setHeadingText("");
		
		final Grid yetaP03006Grid = yetaP03006GridPanel.getMsfGrid().getGrid();
		yetaP03006Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				//그리드 선택시
				yetaP03006ToYeta3200Detail(yetaP03006GridPanel.getCurrentlySelectedItem());
			}
		});
		
		gridFieldSet.add(yetaP03006GridPanel);
			
		cpYeta03006.add(gridFieldSet);
	}		
		
	private YetaP03006 getThis(){
	       return this;
	}
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
	
	//버튼에 따른 Action
		private void doAction(ActionDatabase actionDatabase) {
			switch (actionDatabase) {
				case INSERT:
					this.actionDatabase = ActionDatabase.INSERT;
					yetaP03006FormSave();
					break;
				case UPDATE:
					this.actionDatabase = ActionDatabase.UPDATE;
					yetaP03006FormSave();
					break;
				case DELETE:
					this.actionDatabase = ActionDatabase.DELETE;
					yetaP03006FormSave();
					break;
			}
		}
	
		private void yetaP03006FormSave() {  
			if (MSFSharedUtils.paramNotNull(records)) { 
				
				Yeta3110DTO yeta3110Dto= new Yeta3110DTO();  
				List<Yeta3110DTO> listYeta3110dto = new ArrayList<Yeta3110DTO>();  
				
				if((ActionDatabase.INSERT).equals(actionDatabase) || (ActionDatabase.UPDATE).equals(actionDatabase)) {
					
					yeta3110Dto= new Yeta3110DTO();
					listYeta3110dto = new ArrayList<Yeta3110DTO>();  

					/** Hidden **/
					yeta3110Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));/** 사업장코드 : dpobCd */
					yeta3110Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));/** SYSTEMKEY : systemkey */
					yeta3110Dto.setEdacRvyy(MSFSharedUtils.allowNulls(edacRvyy.getValue()));/** column 연말정산귀속년도 : edacRvyy */
					yeta3110Dto.setSettGbcd(MSFSharedUtils.allowNulls(settGbcd.getValue()));/** column 정산구분코드 : settGbcd */
					
//					yeta3110Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));/** 사업장코드 : dpobCd */
//					yeta3110Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));/** SYSTEMKEY : systemkey */
//					yeta3110Dto.setEdacRvyy(MSFSharedUtils.allowNulls(edacRvyy.getValue()));/** column 연말정산귀속년도 : edacRvyy */
//					yeta3110Dto.setSettGbcd(MSFSharedUtils.allowNulls(settGbcd.getValue()));/** column 정산구분코드 : settGbcd */
					 
					 
					yeta3110Dto.setSiteNumb(MSFSharedUtils.allowNulls(siteNumb01.getValue())); 				/** column 사업자등록번호 : siteNumb */
					yeta3110Dto.setJeymStdt(GWTUtils.getStringFromDate(jeymStdt.getValue(), "yyyyMMdd"));	/** column 귀속년월_From : jeymStdt */
		            yeta3110Dto.setJeymEddt(GWTUtils.getStringFromDate(jeymEddt.getValue(), "yyyyMMdd"));	/** column 귀속년월_TO : jeymEddt */
		            yeta3110Dto.setJutrEddt(GWTUtils.getStringFromDate(jutrEddt.getValue(), "yyyyMMdd"));	/** column 감면기간_TO : jutrEddt */
		            yeta3110Dto.setJutrStdt(GWTUtils.getStringFromDate(jutrStdt.getValue(), "yyyyMMdd"));	/** column 감면기간_From : jutrStdt */
		            yeta3110Dto.setSiteCtnt(MSFSharedUtils.allowNulls(siteCtnt.getValue()));/** column 근무지명 : siteCtnt */
		            yeta3110Dto.setPayrTotl((Long) payrTotl.getValue());	/** column 급여합계금액 : payrTotl */
		            yeta3110Dto.setBonsAmnt((Long) bonsAmnt.getValue());	/** column 상여합계금액 : bonsAmnt */
		            yeta3110Dto.setDtmnBtam((Long) dtmnBtam.getValue());	/** column 인정상여합계금액 : dtmnBtam */
		            yeta3110Dto.setStckPrft((Long) stckPrft.getValue());	/** column 주식행사이익 : stckPrft */
		            yeta3110Dto.setUnonAmnt((Long) unonAmnt.getValue());	/** column 우리사주조합인출금액 : unonAmnt */
		            yeta3110Dto.setOfrrExli((Long) ofrrExli.getValue());	/** column 임원퇴직소득금액한도초과액 : ofrrExli */
		            yeta3110Dto.setTaxeTotl((Long) taxeTotl.getValue());	/** column 비과세합계금액 : taxeTotl */
//		            yeta3110Dto.setReseSmam((Long) reseSmam.getValue());			/** column 연구보조비합계금액 : reseSmam */
		            yeta3110Dto.setEarnTaxn((Long) earnTaxn.getValue());	/** column 소득세 : earnTaxn */
		            yeta3110Dto.setIhtxTaxn((Long) ihtxTaxn.getValue());	/** column 지방소득세 : ihtxTaxn */
		            yeta3110Dto.setFarmTaxn((Long) farmTaxn.getValue());	/** column 농특세 : farmTaxn */
		            yeta3110Dto.setAnnuMuam((Long) annuMuam.getValue());	/** column 국민연금보험료금액 : annuMuam */
		            yeta3110Dto.setAnnuDdam((Long) annuDdam.getValue());	/** column 국민연금보험료공제액 : annuDdam */
		            yeta3110Dto.setAuetMuam((Long) auetMuam.getValue());	/** column 국민연금외공무원연금 : auetMuam */
		            yeta3110Dto.setAuetSold((Long) auetSold.getValue());	/** column 국민연금외군인연금 : auetSold */
		            yeta3110Dto.setAuetTech((Long) auetTech.getValue());	/** column 국민연금외교직원연금 : auetTech */
		            yeta3110Dto.setAuetFect((Long) auetFect.getValue());	/** column 국민연금외별정우체국 : auetFect */
		            yeta3110Dto.setAuetDdam((Long) auetDdam.getValue());	/** column 국민연금외공무원연금공제액 : auetDdam */
		            yeta3110Dto.setAuetDold((Long) auetDold.getValue());	/** column 국민연금외군인연금공제액 : auetDold */
		            yeta3110Dto.setAuetDech((Long) auetDech.getValue());	/** column 국민연금외교직원연금공제액 : auetDech */
		            yeta3110Dto.setAuetDect((Long) auetDect.getValue());	/** column 국민연금외별정우체국공제액 : auetDect */
		            yeta3110Dto.setRtreMuam((Long) rtreMuam.getValue());	/** column 퇴직연금과학기술인금액 : rtreMuam */
		            yeta3110Dto.setRtrePsct((Long) rtrePsct.getValue());	/** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
		            yeta3110Dto.setRtreAnsv((Long) rtreAnsv.getValue());	/** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
		            yeta3110Dto.setRtreDdam((Long) rtreDdam.getValue());	/** column 퇴직연금과학기술인공제액 : rtreDdam */
		            yeta3110Dto.setRtreDsct((Long) rtreDsct.getValue());	/** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
		            yeta3110Dto.setRtreDnsv((Long) rtreDnsv.getValue());	/** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
		            yeta3110Dto.setHlthDbam((Long) hlthDbam.getValue());	/** column 국민건강보험료금액 : hlthDbam */
		            yeta3110Dto.setHlthMuam((Long) hlthMuam.getValue());	/** column 국민건강보험료공제액 : hlthMuam */
		            yeta3110Dto.setUpisJuam((Long) upisJuam.getValue());	/** column 고용보험금액 : upisJuam */
		            yeta3110Dto.setUpisMuam((Long) upisMuam.getValue());	/** column 고용보험공제액 : upisMuam */
		            
		            yeta3110Dto.setMangGbyn(YetaUtils.getCheckedRadioValue(mangGbyn));/** column 처리구분여부 : mangGbyn */
		            yeta3110Dto.setWthdSbyn(YetaUtils.getCheckedRadioValue(wthdSbyn));/** column 원천징수영수증제출여부 : wthdSbyn */		
		           
		            listYeta3110dto.add(yeta3110Dto);
		            
				}else {
					yeta3110Dto= new Yeta3110DTO();
					listYeta3110dto = new ArrayList<Yeta3110DTO>();  
	                
					while (records.hasNext()) {
		              
						Record record = (Record) records.next(); 
		                BaseModel bmMapModel = (BaseModel)record.getModel();
		                      
//		                Yeta3110DTO yeta3110Dto= new Yeta3110DTO();  
		                      
		                yeta3110Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
		                yeta3110Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** SYSTEMKEY : systemkey */
		                yeta3110Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
		                yeta3110Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd$commCd")));/** column 정산구분코드 : settGbcd */
		                
		                yeta3110Dto.setSiteNumb(MSFSharedUtils.allowNulls(bmMapModel.get("siteNumb"))); /** column 사업자등록번호 : siteNumb */
		                
		                yeta3110Dto.setJeymStdt(MSFSharedUtils.allowNulls(bmMapModel.get("jeymStdt")));	/** column 귀속년월_From : jeymStdt */
		                yeta3110Dto.setJeymEddt(MSFSharedUtils.allowNulls(bmMapModel.get("jeymEddt")));	/** column 귀속년월_TO : jeymEddt */
		                yeta3110Dto.setJutrEddt(MSFSharedUtils.allowNulls(bmMapModel.get("jutrEddt")));	/** column 감면기간_TO : jutrEddt */
		                yeta3110Dto.setJutrStdt(MSFSharedUtils.allowNulls(bmMapModel.get("jutrStdt")));	/** column 감면기간_From : jutrStdt */
		                yeta3110Dto.setSiteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("siteCtnt")));	/** column 근무지명 : siteCtnt */
		                yeta3110Dto.setPayrTotl((Long)bmMapModel.get("payrTotl"));	/** column 급여합계금액 : payrTotl */
		                yeta3110Dto.setBonsAmnt((Long)bmMapModel.get("bonsAmnt"));	/** column 상여합계금액 : bonsAmnt */
		                yeta3110Dto.setDtmnBtam((Long)bmMapModel.get("dtmnBtam"));	/** column 인정상여합계금액 : dtmnBtam */
		                yeta3110Dto.setStckPrft((Long)bmMapModel.get("stckPrft"));	/** column 주식행사이익 : stckPrft */
		                yeta3110Dto.setUnonAmnt((Long)bmMapModel.get("unonAmnt"));	/** column 우리사주조합인출금액 : unonAmnt */
		                yeta3110Dto.setOfrrExli((Long)bmMapModel.get("ofrrExli"));	/** column 임원퇴직소득금액한도초과액 : ofrrExli */
		                yeta3110Dto.setTaxeTotl((Long)bmMapModel.get("taxeTotl"));	/** column 비과세합계금액 : taxeTotl */
//		                yeta3110Dto.set.((Long)bmMapModel.get("reseSmam"));	/** column 연구보조비합계금액 : reseSmam */
		                yeta3110Dto.setEarnTaxn((Long)bmMapModel.get("earnTaxn"));	/** column 소득세 : earnTaxn */
		                yeta3110Dto.setIhtxTaxn((Long)bmMapModel.get("ihtxTaxn"));	/** column 지방소득세 : ihtxTaxn */
		                yeta3110Dto.setFarmTaxn((Long)bmMapModel.get("farmTaxn"));	/** column 농특세 : farmTaxn */
		                yeta3110Dto.setAnnuMuam((Long)bmMapModel.get("annuMuam"));	/** column 국민연금보험료금액 : annuMuam */
		                yeta3110Dto.setAnnuDdam((Long)bmMapModel.get("annuDdam"));	/** column 국민연금보험료공제액 : annuDdam */
		                yeta3110Dto.setAuetMuam((Long)bmMapModel.get("auetMuam"));	/** column 국민연금외공무원연금 : auetMuam */
		                yeta3110Dto.setAuetSold((Long)bmMapModel.get("auetSold"));	/** column 국민연금외군인연금 : auetSold */
		                yeta3110Dto.setAuetTech((Long)bmMapModel.get("auetTech"));	/** column 국민연금외교직원연금 : auetTech */
		                yeta3110Dto.setAuetFect((Long)bmMapModel.get("auetFect"));	/** column 국민연금외별정우체국 : auetFect */
		                yeta3110Dto.setAuetDdam((Long)bmMapModel.get("auetDdam"));	/** column 국민연금외공무원연금공제액 : auetDdam */
		                yeta3110Dto.setAuetDold((Long)bmMapModel.get("auetDold"));	/** column 국민연금외군인연금공제액 : auetDold */
		                yeta3110Dto.setAuetDech((Long)bmMapModel.get("auetDech"));	/** column 국민연금외교직원연금공제액 : auetDech */
		                yeta3110Dto.setAuetDect((Long)bmMapModel.get("auetDect"));	/** column 국민연금외별정우체국공제액 : auetDect */
		                yeta3110Dto.setRtreMuam((Long)bmMapModel.get("rtreMuam"));	/** column 퇴직연금과학기술인금액 : rtreMuam */
		                yeta3110Dto.setRtrePsct((Long)bmMapModel.get("rtrePsct"));	/** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
		                yeta3110Dto.setRtreAnsv((Long)bmMapModel.get("rtreAnsv"));	/** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
		                yeta3110Dto.setRtreDdam((Long)bmMapModel.get("rtreDdam"));	/** column 퇴직연금과학기술인공제액 : rtreDdam */
		                yeta3110Dto.setRtreDsct((Long)bmMapModel.get("rtreDsct"));	/** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
		                yeta3110Dto.setRtreDnsv((Long)bmMapModel.get("rtreDnsv"));	/** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
		                yeta3110Dto.setHlthDbam((Long)bmMapModel.get("hlthDbam"));	/** column 국민건강보험료금액 : hlthDbam */
		                yeta3110Dto.setHlthMuam((Long)bmMapModel.get("hlthMuam"));	/** column 국민건강보험료공제액 : hlthMuam */
		                yeta3110Dto.setUpisJuam((Long)bmMapModel.get("upisJuam"));	/** column 고용보험금액 : upisJuam */
		                yeta3110Dto.setUpisMuam((Long)bmMapModel.get("upisMuam"));	/** column 고용보험공제액 : upisMuam */
		                yeta3110Dto.setWthdSbyn(MSFSharedUtils.allowNulls(bmMapModel.get("wthdSbyn")));	/** column 처리구분여부 : wthdSbyn */
		                yeta3110Dto.setWthdSbyn(MSFSharedUtils.allowNulls(bmMapModel.get("wthdSbyn")));	/** column 원천징수영수증제출여부 : wthdSbyn */

		               
		                listYeta3110dto.add(yeta3110Dto);
					}  
		                
					if (listYeta3110dto.size() <= 0) {
						MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
				}
	              
				
	                
				yetaP03006Service.activityOnYetaP03006ToYeta3110(listYeta3110dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP03006ToYeta3110(" + actionDatabase.name() + ") : " + caught), null);
					}
					public void onSuccess(Long result) { 
						if (result == 0) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
						} else {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
							reload();
							actionDatabase = ActionDatabase.UPDATE;
						} 
					} 
	                   
				}); 
	              
			} else {
				MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}
	}	
		
		
	//종전근무지상세 초기화
	public void resetYetaP03006() {
		
		jeymStdt.reset(); // 귀속년월 시작
		jeymEddt.reset(); // 귀속년월 종료
		jutrStdt.reset(); // 감면 시작 기간
		jutrEddt.reset(); // 감면 종료 기간
		hanNm01.setValue(""); // 성명
		siteNumb01.setValue(""); // 사업자등록번호
		siteCtnt.setValue(""); // 근무지명
		payrTotl.setValue(null); // 급여합계
		annuMuam.setValue(null); // 국민연금보험료금액
		auetMuam.setValue(null); // 국민연금외공무원연금
		auetDdam.setValue(null); // 국민연금외공무원연금_공제액
		earnTaxn.setValue(null); // 소득세
		annuDdam.setValue(null); // 국민연금보험료공제액
		auetSold.setValue(null); // 국민연금외군인연금
		auetDold.setValue(null); // 국민연금외군인연금_공제액
		bonsAmnt.setValue(null); // 상여합계
		hlthDbam.setValue(null); // 건강보험료지출액
		auetTech.setValue(null); // 국민연금외교직원연금
		auetDech.setValue(null); // 국민연금외교직원연금_공제액
		ihtxTaxn.setValue(null); // 지방소득세
		hlthMuam.setValue(null); // 건강보험료공제액
		auetFect.setValue(null); // 국민연금외별정우체국
		auetDect.setValue(null); // 국민연금외별정우체국_공제액
		dtmnBtam.setValue(null); // 인정상여
		upisJuam.setValue(null); // 고용보험지출액

		unonAmnt.setValue(null); // 우리사주조합인출금액

		farmTaxn.setValue(null); // 농특세
		upisMuam.setValue(null); // 고용보험공제액
		rtreMuam.setValue(null); // 과학기술인공제
		rtreDdam.setValue(null); // 과학기술인공제_공제액
		stckPrft.setValue(null); // 주식행사이익
		rtrePsct.setValue(null); // 근로자퇴직보장법
		rtreDsct.setValue(null); // 근로자퇴직보장법_공제액
		taxeTotl.setValue(null); // 비과세합계
		ofrrExli.setValue(null); // 임직원퇴직한도초과액
		rtreAnsv.setValue(null); // 연금저축계좌
		rtreDnsv.setValue(null); // 연금저축계좌_공제액
		wthdSbyn.reset(); // 원청징수영수증제출여부
		mangGbyn.reset(); // 처리구분
	}

	
	/** 종전근무지 상세내역을 가져옴 **/
	private void yetaP03006ToYeta3200Detail(BaseModel selRecord) {
			
		dpobCd.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("dpobCd")));		/** 사업장코드 : dpobCd */
		systemkey.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("systemkey")));	/** SYSTEMKEY : systemkey */
		edacRvyy.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("edacRvyy")));	/** column 연말정산년도 : edacRvyy */
		settGbcd.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("settGbcd")));	/** column 정산구분코드 : settGbcd */
			
		siteNumb01.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("siteNumb"))); /** column 사업자등록번호 : siteNumb */
		jeymStdt.setValue(GWTUtils.getDateFromString((String) selRecord.get("jeymStdt"), "yyyyMMdd"));	/** column 귀속년월_From : jeymStdt */
    	jeymEddt.setValue(GWTUtils.getDateFromString((String) selRecord.get("jeymEddt"), "yyyyMMdd"));	/** column 귀속년월_TO : jeymEddt */
     	jutrEddt.setValue(GWTUtils.getDateFromString((String) selRecord.get("jutrEddt"), "yyyyMMdd"));	/** column 감면기간_TO : jutrEddt */
      	jutrStdt.setValue(GWTUtils.getDateFromString((String) selRecord.get("jutrStdt"), "yyyyMMdd"));	/** column 감면기간_From : jutrStdt */
        siteCtnt.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("edacRvyy")));	/** column 근무지명 : siteCtnt */
        hanNm01.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("hanNm")));		/** column 성명 : hanNm */
        payrTotl.setValue((Long) selRecord.get("payrTotl"));	/** column 급여합계금액 : payrTotl */
        bonsAmnt.setValue((Long) selRecord.get("bonsAmnt"));	/** column 상여합계금액 : bonsAmnt */
        dtmnBtam.setValue((Long) selRecord.get("dtmnBtam"));	/** column 인정상여합계금액 : dtmnBtam */
        stckPrft.setValue((Long) selRecord.get("stckPrft"));	/** column 주식행사이익 : stckPrft */
        unonAmnt.setValue((Long) selRecord.get("unonAmnt"));	/** column 우리사주조합인출금액 : unonAmnt */
        ofrrExli.setValue((Long) selRecord.get("ofrrExli"));	/** column 임원퇴직소득금액한도초과액 : ofrrExli */
        taxeTotl.setValue((Long) selRecord.get("taxeTotl"));	/** column 비과세합계금액 : taxeTotl */
        
//         reseSmam.setValue((Long) selRecord.get("reseSmam"));			/** column 연구보조비합계금액 : reseSmam */
        earnTaxn.setValue((Long) selRecord.get("earnTaxn"));	/** column 소득세 : earnTaxn */
        ihtxTaxn.setValue((Long) selRecord.get("ihtxTaxn"));	/** column 지방소득세 : ihtxTaxn */
        farmTaxn.setValue((Long) selRecord.get("farmTaxn"));	/** column 농특세 : farmTaxn */
        annuMuam.setValue((Long) selRecord.get("annuMuam"));	/** column 국민연금보험료금액 : annuMuam */
        annuDdam.setValue((Long) selRecord.get("annuDdam"));	/** column 국민연금보험료공제액 : annuDdam */
        auetMuam.setValue((Long) selRecord.get("auetMuam"));	/** column 국민연금외공무원연금 : auetMuam */
        auetSold.setValue((Long) selRecord.get("auetSold"));	/** column 국민연금외군인연금 : auetSold */
        auetTech.setValue((Long) selRecord.get("auetTech"));	/** column 국민연금외교직원연금 : auetTech */
        auetFect.setValue((Long) selRecord.get("auetFect"));	/** column 국민연금외별정우체국 : auetFect */
        auetDdam.setValue((Long) selRecord.get("auetDdam"));	/** column 국민연금외공무원연금공제액 : auetDdam */
        auetDold.setValue((Long) selRecord.get("auetDold"));	/** column 국민연금외군인연금공제액 : auetDold */
        auetDech.setValue((Long) selRecord.get("auetDech"));	/** column 국민연금외교직원연금공제액 : auetDech */
        auetDect.setValue((Long) selRecord.get("auetDect"));	/** column 국민연금외별정우체국공제액 : auetDect */
        rtreMuam.setValue((Long) selRecord.get("rtreMuam"));	/** column 퇴직연금과학기술인금액 : rtreMuam */
        rtrePsct.setValue((Long) selRecord.get("rtrePsct"));	/** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
        rtreAnsv.setValue((Long) selRecord.get("rtreAnsv"));	/** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
        rtreDdam.setValue((Long) selRecord.get("rtreDdam"));	/** column 퇴직연금과학기술인공제액 : rtreDdam */
        rtreDsct.setValue((Long) selRecord.get("rtreDsct"));	/** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
        rtreDnsv.setValue((Long) selRecord.get("rtreDnsv"));	/** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
        hlthDbam.setValue((Long) selRecord.get("hlthDbam"));	/** column 국민건강보험료금액 : hlthDbam */
        hlthMuam.setValue((Long) selRecord.get("hlthMuam"));	/** column 국민건강보험료공제액 : hlthMuam */
        upisJuam.setValue((Long) selRecord.get("upisJuam"));	/** column 고용보험금액 : upisJuam */
        upisMuam.setValue((Long) selRecord.get("upisMuam"));	/** column 고용보험공제액 : upisMuam */
        
        if((Boolean.TRUE).equals((Boolean) selRecord.get("mangGbyn"))) {
        	YetaUtils.setCheckedRadioValue(mangGbyn, "1");/** column 처리구분여부 : wthdSbyn */
        }else {
//        	YetaUtils.setCheckedRadioValue(mangGbyn, (String) selRecord.get("mangGbyn"));/** column 처리구분여부 : wthdSbyn */
        	YetaUtils.setCheckedRadioValue(mangGbyn, "0");/** column 처리구분여부 : wthdSbyn */
        }
        
        
//        if("true".equals((String) selRecord.get("wthdSbyn"))) {
//        	YetaUtils.setCheckedRadioValue(wthdSbyn, "1");/** column 처리구분여부 : wthdSbyn */
//        }else {
//        	YetaUtils.setCheckedRadioValue(mangGbyn, (String) selRecord.get("mangGbyn"));/** column 처리구분여부 : wthdSbyn */
//        	YetaUtils.setCheckedRadioValue(wthdSbyn, "0");/** column 처리구분여부 : wthdSbyn */
//        }
        
        YetaUtils.setCheckedRadioValue(wthdSbyn, (String) selRecord.get("wthdSbyn"));/** column 원천징수영수증제출여부 : wthdSbyn */
	}			

	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			yetaP03006GridPanel.getTableDef().setTableColumnFilters(filters);
			yetaP03006GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			yetaP03006GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			yetaP03006GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			yetaP03006GridPanel.reload();

		
//		actionDatabase = ActionDatabase.READ;
	}
	
	
	private void funcSetPopUpRecord() {
		   
		BaseModel ppRecord = new BaseModel();

		ppRecord.set("dpobCd", dpobCd.getValue());
		ppRecord.set("settGbcd", settGbcd.getValue());
		ppRecord.set("systemkey", systemkey.getValue());
		ppRecord.set("edacRvyy", edacRvyy.getValue());
		ppRecord.set("siteNumb", siteNumb01.getValue());
		
		setPPRecord(ppRecord);
   }
	
	
	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/		
}
