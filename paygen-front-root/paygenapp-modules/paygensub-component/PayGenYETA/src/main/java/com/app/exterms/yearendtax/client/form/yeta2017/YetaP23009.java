/**
 * 주현근무지등록
 */
package com.app.exterms.yearendtax.client.form.yeta2017;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3210DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta3210Def;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13009Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13009ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
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
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
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
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP23009 extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta13009; 
	  
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
	private MSFGridPanel yetaP13009GridPanel;
	private Ye16Ta3210Def yetaP13009ToYeta03210Def  = new Ye16Ta3210Def("YETAP13009");	//주현근무지내역 그리드 테이블 컬럼 define 
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
 	private  TextField<String> srhEdacRvyy;		// 년도
 	private  ComboBox<BaseModel> srhSettGbcd; 	// 정산구분
 	private  TextField<String> srhDeptCd; 		// 부서
 	private  TextField<String> srhHanNm; 		// 성명
 	
 	private  HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private  HiddenField<String> dpobCd ;	/**  column 사업장코드 : dpobCd */
    private  HiddenField<String> edacRvyy;	/** column 정산년도 : edacRvyy */
    private  HiddenField<String> settGbcd;	/** column 정산구분코드 : settGbcd */
 	// -------------- 검색 조건 종료 --------------
    
	// -------------- 서비스 호출 시작 --------------
	private YetaP13009ServiceAsync yetaP13009Service = YetaP13009Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
    // ---------------- 주현근무지 상세 시작 ---------------- 
    private MSFDateField elctDate; 			// 급여지급일자
    private MSFNumberField suprTxam; 	// 급여지급금액_과세
    private MSFNumberField buamTxam; 	// 상여금_과세
    private MSFTextField hanNm; 			// 성명
    private MSFTextField elctYymm;			// 지급년월
    private MSFNumberField inbsAmnt; 	// 인정상여금_과세
    private MSFNumberField stckInam; 	// 주식행사이익금액
    private MSFNumberField spbmTxam; 	// 급여_상여합계금액
    private MSFNumberField ecinTxam;		// 외국인소득금액_과세
    private MSFNumberField taxmEcin;		// 외국인소득금액_비과세
    private MSFNumberField taxmEarn;		// 자가운전보조금_비과세
    private MSFNumberField taxmEtam;	// 정액급식비_비과세
    private MSFNumberField txetTxam;	// 정액급식비_과세
    private MSFNumberField addrBhtx;		// 출산보육수당_비과세
    private MSFNumberField spciHlth;		// 건강보험료금액
    private MSFNumberField spciEmpf;		// 고용보험료금액
    private MSFNumberField natnPsnf;		// 국민연금금액
    private MSFNumberField earnTaxn;		// 소득세
    private MSFNumberField ihtxTaxn; 		// 지방소득세
    private MSFNumberField etccTxam;		// 기타금액_과세
    private MSFNumberField etccEtam;		// 기타금액_비과세
    // ---------------- 주현근무지 상세 종료 ---------------- 

      
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
//		 private void checkYetaP13009Auth( String authAction, ListStore<BaseModel>bm) {
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
	  
	public YetaP23009(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
		cpYeta13009 = new ContentPanel();  

		createSearchForm();		//검색필드를 적용
		createMsfGridForm();	//그리드필드
		createStandardForm(); 	//기본정보필드   
		   
		cpYeta13009.setBodyBorder(false);
		cpYeta13009.setBorders(false);
		cpYeta13009.setHeaderVisible(false);
		cpYeta13009.setSize("790px", "640px");
		   
		this.add(cpYeta13009);
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
		cpYeta13009.add(systemkey);
			
		dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYeta13009.add(dpobCd);
		    
		edacRvyy = new HiddenField<String>();	/** column 정산년도 : edacRvyy */
		edacRvyy.setName("edacRvyy");
		cpYeta13009.add(edacRvyy);
		    
		settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
		settGbcd.setName("settGbcd");
		cpYeta13009.add(settGbcd);
			
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
		        

		cpYeta13009.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaNew = new Button("신규");
		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				//주현근무지상세 초기화
				resetYetaP13009();
				
				actionDatabase = ActionDatabase.INSERT;
//				doAction(actionDatabase);
			}
		});
			
		topYetaBtnBar.add(btnYetaNew);

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				MessageBox.confirm("삭제", "선택하신 주현근무지 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							Iterator<BaseModel> itBm = yetaP13009GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
							List<Record> lsRec = new ArrayList<Record>();

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
				
			}
		});
		topYetaBtnBar.add(btnYetaDel);
				
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(yetaP13009GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
				doAction(actionDatabase);

				if ("INSERT".equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});

		topYetaBtnBar.add(btnYetaSave);
				
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
				
		cpYeta13009.add(topYetaBtnBar);
		  	
		  	
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
		srhSettGbcd.setName("settGbcd");
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
				srhSettGbcd.setValue(lsSettGbcd.getAt(2));
			}
		});
		lcSchCol02.add(srhSettGbcd, new FormData("100%"));
			
		LayoutContainer lcSchCol03 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03.setLayout(frmlytSch);

		srhDeptCd = new TextField<String>();
		srhDeptCd.setReadOnly(true);
		srhDeptCd.setName("deptNm");
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");

		lcSchCol03.add(srhDeptCd, new FormData("100%"));
			
			
		LayoutContainer lcSchCol04 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol04.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setReadOnly(true);
		srhHanNm.setName("hanNm");
		srhHanNm.setFieldLabel("성명");

		lcSchCol04.add(srhHanNm, new FormData("100%"));
			
		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta13009.add(fieldSet);
	}    
	 	 
	  private void createStandardForm() {
		  
		  LayoutContainer lcFormLayer = new LayoutContainer();
		  lcFormLayer.setSize("785px", "270px");  
		  
//		  ContentPanel cp01 = new ContentPanel();   
//		  cp01.setBodyBorder(false); 
//		  cp01.setHeaderVisible(false);   
//		  cp01.setLayout(new FitLayout());      
//		  cp01.setSize("780px", "350px");  
		  
		  // TODO
		  LayoutContainer layoutContainer = new LayoutContainer();
	      
	      // 주현근무지상세
	      LayoutContainer layoutContainer_1 = new LayoutContainer();
	      
		  FieldSet fieldSet_01 = new FieldSet();
		  fieldSet_01.setHeadingHtml("주현근무지상세");
		  fieldSet_01.setBorders(true);
		  
	      layoutContainer.add(layoutContainer_1);
	      layoutContainer_1.setBorders(false);
	      
	      LayoutContainer layoutContainer_2 = new LayoutContainer();
	      layoutContainer_2.setLayout(new ColumnLayout());
	      
	      LayoutContainer layoutContainer_5 = new LayoutContainer();
	      layoutContainer_5.setBorders(true);
	      
	      LayoutContainer layoutContainer_7 = new LayoutContainer();
	      layoutContainer_7.setLayout(new ColumnLayout());
	      
	      
	      // 급여 지급일자
	      LayoutContainer layoutContainer_27 = new LayoutContainer();
	      
		  FormLayout frmlytSch5 = new FormLayout();  
		  frmlytSch5.setLabelWidth(110); 
		  frmlytSch5.setLabelAlign(LabelAlign.RIGHT); 
			  
		  layoutContainer_27.setLayout(frmlytSch5);
	      
		  elctDate = new MSFDateField();
	      layoutContainer_27.add(elctDate, new FormData("100%"));
	      new DateFieldMask(elctDate, "9999.99.99"); 
	      elctDate.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	      elctDate.setFieldLabel("급여지급일자");
	      layoutContainer_7.add(layoutContainer_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_27.setBorders(false);
	      
	      
	      
	      LayoutContainer layoutContainer_28 = new LayoutContainer();
	      
	      FormLayout frmlytSch6 = new FormLayout();  
	      frmlytSch6.setLabelWidth(110); 
	      frmlytSch6.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_28.setLayout(frmlytSch6);
	      
	      suprTxam = new MSFNumberField();
	      suprTxam.setFieldLabel("급여금액_과세");
	      layoutContainer_28.add(suprTxam, new FormData("100%"));
	      layoutContainer_7.add(layoutContainer_28, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_28.setBorders(false);	      

	      layoutContainer_5.add(layoutContainer_7);
	      layoutContainer_7.setBorders(false);
	      
	      
	      
	      
	      LayoutContainer layoutContainer_8 = new LayoutContainer();
	      layoutContainer_8.setLayout(new ColumnLayout());
	      
	      //성명
	      LayoutContainer layoutContainer_29 = new LayoutContainer();
	      
	      FormLayout frmlytSch7 = new FormLayout();  
	      frmlytSch7.setLabelWidth(110); 
	      frmlytSch7.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_29.setLayout(frmlytSch7);
	      
	      hanNm = new MSFTextField();
	      hanNm.setFieldLabel("성 명");
	      layoutContainer_29.add(hanNm, new FormData("100%"));
	      layoutContainer_8.add(layoutContainer_29, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_29.setBorders(false);
	      
	      // 지급년월
	      LayoutContainer layoutContainer_30 = new LayoutContainer();
	      
	      FormLayout frmlytSch8 = new FormLayout();  
	      frmlytSch8.setLabelWidth(110); 
	      frmlytSch8.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_30.setLayout(frmlytSch8);
	      
	      elctYymm = new MSFTextField();
	      layoutContainer_30.add(elctYymm, new FormData("100%"));
	      new TextFieldMask<String>(elctYymm, "999-99-99999");
	      elctYymm.setFieldLabel("지급년월");
	      layoutContainer_8.add(layoutContainer_30, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_30.setBorders(false);
	      
	      
	      layoutContainer_5.add(layoutContainer_8);
	      layoutContainer_8.setBorders(false);
	      
	      
	      
	      
	      
	      LayoutContainer layoutContainer_9 = new LayoutContainer();
	      layoutContainer_9.setLayout(new ColumnLayout());
	      
	      // 상여금_과세
	      LayoutContainer layoutContainer_31 = new LayoutContainer();
	      
	      FormLayout frmlytSch9 = new FormLayout();  
	      frmlytSch9.setLabelWidth(110); 
	      frmlytSch9.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_31.setLayout(frmlytSch9);
	      
	      buamTxam = new MSFNumberField();
	      layoutContainer_31.add(buamTxam, new FormData("100%"));
	      buamTxam.setFieldLabel("상여금_과세");
	      layoutContainer_9.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_31.setBorders(false);
	      
	      // 인정상여금_과세
	      LayoutContainer layoutContainer_32 = new LayoutContainer();
	      
	      FormLayout frmlytSch10 = new FormLayout();  
	      frmlytSch10.setLabelWidth(110); 
	      frmlytSch10.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_32.setLayout(frmlytSch10);
	      
	      inbsAmnt = new MSFNumberField();
	      layoutContainer_32.add(inbsAmnt, new FormData("100%"));
	      inbsAmnt.setFieldLabel("인정상여금_과세");
	      layoutContainer_9.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_32.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_9);
	      layoutContainer_9.setBorders(false);
	      
	      
	      LayoutContainer layoutContainer_11 = new LayoutContainer();
	      layoutContainer_11.setLayout(new ColumnLayout());
	      
	      
	      // 주식행사이익금액
	      LayoutContainer layoutContainer_35 = new LayoutContainer();
	      
	      FormLayout frmlytSch11 = new FormLayout();  
	      frmlytSch11.setLabelWidth(110); 
	      frmlytSch11.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_35.setLayout(frmlytSch11);
	      
	      stckInam = new MSFNumberField();
	      layoutContainer_35.add(stckInam, new FormData("100%"));
	      stckInam.setFieldLabel("주식행사이익금액");
	      
	      layoutContainer_11.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_35.setBorders(false);
	      
	      //급여_상여합계금액
	      LayoutContainer layoutContainer_36 = new LayoutContainer();
	      
	      FormLayout frmlytSch12 = new FormLayout();  
	      frmlytSch12.setLabelWidth(110); 
	      frmlytSch12.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_36.setLayout(frmlytSch12);
	      
	      spbmTxam = new MSFNumberField();
	      layoutContainer_36.add(spbmTxam, new FormData("100%"));
	      spbmTxam.setFieldLabel("급여_상여합계금액");
	      layoutContainer_11.add(layoutContainer_36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_36.setBorders(false);	      
	      
	      layoutContainer_5.add(layoutContainer_11);
	      
	      
	      
	      
	      
	      LayoutContainer layoutContainer_12 = new LayoutContainer();
	      layoutContainer_12.setLayout(new ColumnLayout());
	      
	      // 외국인소득금액_과세
	      LayoutContainer layoutContainer_37 = new LayoutContainer();
	      
	      FormLayout frmlytSch13 = new FormLayout();  
	      frmlytSch13.setLabelWidth(110); 
	      frmlytSch13.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_37.setLayout(frmlytSch13);
	      
	      ecinTxam = new MSFNumberField();
	      layoutContainer_37.add(ecinTxam, new FormData("100%"));
	      ecinTxam.setFieldLabel("외국인소득_과세");
	      layoutContainer_12.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_37.setBorders(false);
	      
	      // 외국인소득금액_비과세
	      LayoutContainer layoutContainer_38 = new LayoutContainer();
	      
	      FormLayout frmlytSch14 = new FormLayout();  
	      frmlytSch14.setLabelWidth(110); 
	      frmlytSch14.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_38.setLayout(frmlytSch14);
	      
	      taxmEcin = new MSFNumberField();
	      layoutContainer_38.add(taxmEcin, new FormData("100%"));
	      taxmEcin.setFieldLabel("외국인소득_비과세");
	      layoutContainer_12.add(layoutContainer_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_38.setBorders(false);
	      
	      layoutContainer_5.add(layoutContainer_12);
	      layoutContainer_12.setBorders(false);
	      
	      
	      
	      
	      
	      LayoutContainer layoutContainer_13 = new LayoutContainer();
	      layoutContainer_13.setLayout(new ColumnLayout());
	      
	      // 자가운전보조금_비과세
	      LayoutContainer layoutContainer_39 = new LayoutContainer();
	      
	      FormLayout frmlytSch15 = new FormLayout();  
	      frmlytSch15.setLabelWidth(110); 
	      frmlytSch15.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_39.setLayout(frmlytSch15);
	      
	      taxmEarn = new MSFNumberField();
	      layoutContainer_39.add(taxmEarn, new FormData("100%"));
	      taxmEarn.setFieldLabel("자가운전_비과세");
	      layoutContainer_13.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_39.setBorders(false);
	      
	      //건강보험료공제액
	      LayoutContainer layoutContainer_40 = new LayoutContainer();
	      layoutContainer_13.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_40.setBorders(false);	     

	      layoutContainer_5.add(layoutContainer_13);
	      layoutContainer_13.setBorders(false);
 
	      layoutContainer_2.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_5.setBorders(false);
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      LayoutContainer layoutContainer_6 = new LayoutContainer();
	      
	      LayoutContainer layoutContainer_17= new LayoutContainer();
	      layoutContainer_17.setLayout(new ColumnLayout());
	      
	      // 정액급식비_비과세
	      LayoutContainer layoutContainer_51 = new LayoutContainer();
	      
	      FormLayout frmlytSch24 = new FormLayout();  
	      frmlytSch24.setLabelWidth(110); 
	      frmlytSch24.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_51.setLayout(frmlytSch24);
	      
	      taxmEtam = new MSFNumberField();
	      layoutContainer_51.add(taxmEtam, new FormData("100%"));
	      taxmEtam.setFieldLabel("정액급식 비과세");
	      layoutContainer_17.add(layoutContainer_51, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
	      LayoutContainer layoutContainer_52 = new LayoutContainer();
	      
	      FormLayout frmlytSch25 = new FormLayout();  
	      frmlytSch25.setLabelWidth(110); 
	      frmlytSch25.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_52.setLayout(frmlytSch25);
	      
	      txetTxam = new MSFNumberField();
	      layoutContainer_52.add(txetTxam, new FormData("100%"));
	      txetTxam.setFieldLabel("정액급식 과세");
	      layoutContainer_17.add(layoutContainer_52, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      
	      layoutContainer_6.add(layoutContainer_17);
	      layoutContainer_17.setBorders(false);
	      
	      
      
	      LayoutContainer layoutContainer_19= new LayoutContainer();
	      layoutContainer_19.setLayout(new ColumnLayout());
	      
	      // 출산보육수당_비과세
	      LayoutContainer layoutContainer_55 = new LayoutContainer();
	      
	      FormLayout frmlytSch27 = new FormLayout();  
	      frmlytSch27.setLabelWidth(110); 
	      frmlytSch27.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_55.setLayout(frmlytSch27);
	      
	      addrBhtx = new MSFNumberField();
	      layoutContainer_55.add(addrBhtx, new FormData("100%"));
	      addrBhtx.setFieldLabel("출산보육 비과세");
	      layoutContainer_19.add(layoutContainer_55, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_55.setBorders(false);
	      
	      
	      // 건강보험료금액
	      LayoutContainer layoutContainer_56 = new LayoutContainer();
	      
	      FormLayout frmlytSch28 = new FormLayout();  
	      frmlytSch28.setLabelWidth(110); 
	      frmlytSch28.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_56.setLayout(frmlytSch28);
	      
	      spciHlth = new MSFNumberField();
	      layoutContainer_56.add(spciHlth, new FormData("100%"));
	      spciHlth.setFieldLabel("건강보험료금액");
	      layoutContainer_19.add(layoutContainer_56, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_56.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_19);
	      layoutContainer_19.setBorders(false);      
	      
	      
	      
	      LayoutContainer layoutContainer_20= new LayoutContainer();
	      layoutContainer_20.setLayout(new ColumnLayout());
	      
	      // 고용보험료금액
	      LayoutContainer layoutContainer_57 = new LayoutContainer();
	      
	      FormLayout frmlytSch29 = new FormLayout();  
	      frmlytSch29.setLabelWidth(110); 
	      frmlytSch29.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_57.setLayout(frmlytSch29);
	      
	      spciEmpf = new MSFNumberField();
	      layoutContainer_57.add(spciEmpf, new FormData("100%"));
	      spciEmpf.setFieldLabel("고용보험료금액");
	      layoutContainer_20.add(layoutContainer_57, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_57.setBorders(false);
	      
	      // 국민연금금액
	      LayoutContainer layoutContainer_58 = new LayoutContainer();
	      
	      FormLayout frmlytSch30 = new FormLayout();  
	      frmlytSch30.setLabelWidth(110); 
	      frmlytSch30.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_58.setLayout(frmlytSch30);
	      
	      natnPsnf = new MSFNumberField();
	      layoutContainer_58.add(natnPsnf, new FormData("100%"));
	      natnPsnf.setFieldLabel("국민연금금액");
	      layoutContainer_20.add(layoutContainer_58, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_58.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_20);
	      layoutContainer_20.setBorders(false);
	      
	      	      
	      
	      
	      LayoutContainer layoutContainer_21= new LayoutContainer();
	      layoutContainer_21.setLayout(new ColumnLayout());
	      
	      // 소득세
	      LayoutContainer layoutContainer_59 = new LayoutContainer();
	      
	      FormLayout frmlytSch31 = new FormLayout();  
	      frmlytSch31.setLabelWidth(110); 
	      frmlytSch31.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_59.setLayout(frmlytSch31);
	      
	      earnTaxn = new MSFNumberField();
	      layoutContainer_59.add(earnTaxn, new FormData("100%"));
	      earnTaxn.setFieldLabel("소득세");
	      layoutContainer_21.add(layoutContainer_59, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_59.setBorders(false);
	      
	      //지방소득세
	      LayoutContainer layoutContainer_60= new LayoutContainer();
	      
	      FormLayout frmlytSch32= new FormLayout();  
	      frmlytSch32.setLabelWidth(110); 
	      frmlytSch32.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_60.setLayout(frmlytSch32);
	      
	      ihtxTaxn = new MSFNumberField();
	      layoutContainer_60.add(ihtxTaxn, new FormData("100%"));
	      ihtxTaxn.setFieldLabel("지방소득세");
	      layoutContainer_21.add(layoutContainer_60, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_60.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_21);
	      layoutContainer_21.setBorders(false);
	      
	      

   
	      LayoutContainer layoutContainer_25= new LayoutContainer();
	      layoutContainer_25.setLayout(new ColumnLayout());
	      
	      
	      // 기타금액_과세
	      LayoutContainer layoutContainer_67 = new LayoutContainer();
	      
	      FormLayout frmlytSch35= new FormLayout();  
	      frmlytSch35.setLabelWidth(110); 
	      frmlytSch35.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_67.setLayout(frmlytSch35);
	      
	      etccTxam = new MSFNumberField();
	      layoutContainer_67.add(etccTxam, new FormData("100%"));
	      etccTxam.setFieldLabel("기타금액_과세");
	      layoutContainer_25.add(layoutContainer_67, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_67.setBorders(false);
	      
	      
	      // 기타금액_비과세
	      LayoutContainer layoutContainer_68 = new LayoutContainer();
	      
	      FormLayout frmlytSch36= new FormLayout();  
	      frmlytSch36.setLabelWidth(110); 
	      frmlytSch36.setLabelAlign(LabelAlign.RIGHT); 
			  
	      layoutContainer_68.setLayout(frmlytSch36);
	      
	      etccEtam = new MSFNumberField();
	      layoutContainer_68.add(etccEtam, new FormData("100%"));
	      etccEtam.setFieldLabel(" 기타금액 비과세");
	      layoutContainer_25.add(layoutContainer_68, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_68.setBorders(false);
	      
	      layoutContainer_6.add(layoutContainer_25);
	      layoutContainer_25.setBorders(false);
	      
	      LayoutContainer layoutContainer_26= new LayoutContainer();
	      layoutContainer_26.setLayout(new ColumnLayout());
	      

	      layoutContainer_2.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	      layoutContainer_6.setBorders(false);

	      layoutContainer.add(layoutContainer_2);
	      layoutContainer_2.setBorders(false);
	      
	      layoutContainer.setBorders(false);
	      
	      fieldSet_01.add(layoutContainer);
	      
//	      cp01.add(layoutContainer);
//	      cp01.add(fieldSet_01);
//	      lcFormLayer.add(cp01);
	      lcFormLayer.add(fieldSet_01);
	      cpYeta13009.add(lcFormLayer);
//	      return lcFormLayer;	  
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
		
	private void createMsfGridForm() {			
		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("주현근무지내역");
		gridFieldSet.setBorders(true);
			
		yetaP13009GridPanel = new MSFGridPanel(yetaP13009ToYeta03210Def, false, false, false, false);
		yetaP13009GridPanel.setHeaderVisible(false);  
		yetaP13009GridPanel.setSize("780px", "330px");
		yetaP13009GridPanel.setBorders(true);
		yetaP13009GridPanel.setHeadingText("");
		
		yetaP13009GridPanel.addListener(Events.DoubleClick, new Listener<ComponentEvent>() {

			@Override
			public void handleEvent(ComponentEvent be) {
				// TODO Auto-generated method stub
				//그리드 선택시
				yetaP13009ToYeta3210Detail(yetaP13009GridPanel.getCurrentlySelectedItem());
			}
			
		});
			
		gridFieldSet.add(yetaP13009GridPanel);
			
		cpYeta13009.add(gridFieldSet);
	}		
		
	private YetaP23009 getThis(){
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
			yetaP13009FormSave();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			yetaP13009FormSave();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			yetaP13009FormSave();
			break;
		}
	}

	private void yetaP13009FormSave() {
		if (MSFSharedUtils.paramNotNull(records)) {

			List<Ye16Ta3210DTO> listYeta3210dto = new ArrayList<Ye16Ta3210DTO>();
			Ye16Ta3210DTO yeta3210Dto = new Ye16Ta3210DTO();
			
			if("INSERT".equals(actionDatabase)) {
				
				yeta3210Dto = new Ye16Ta3210DTO();
				listYeta3210dto = new ArrayList<Ye16Ta3210DTO>();
				
				yeta3210Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));		/** 사업장코드 : dpobCd */
				yeta3210Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));	/** SYSTEMKEY : systemkey */
				yeta3210Dto.setEdacRvyy(MSFSharedUtils.allowNulls(edacRvyy.getValue()));	/** column 연말정산귀속년도 : edacRvyy */
				yeta3210Dto.setSettGbcd(MSFSharedUtils.allowNulls(settGbcd.getValue()));	/** column 정산구분코드 : settGbcd */
				
				yeta3210Dto.setElctYymm(MSFSharedUtils.allowNulls(elctYymm.getValue()));		/** column 지급년월 : elctYymm */
				yeta3210Dto.setElctDate(GWTUtils.getStringFromDate(elctDate.getValue(), "yyyyMMdd"));		/** column 급여지급일자 : elctDate */
		    	yeta3210Dto.setSuprTxam((Long) suprTxam.getValue());	/** column 급여지급금액_과세 : suprTxam */
		    	yeta3210Dto.setBuamTxam((Long) buamTxam.getValue());	/** column 상여금_과세 : buamTxam */
		    	yeta3210Dto.setInbsAmnt((Long) inbsAmnt.getValue());	/** column 인정상여금액 : inbsAmnt */
		    	yeta3210Dto.setStckInam((Long) stckInam.getValue());	/** column 주식행사이익금액 : stckInam */
		        yeta3210Dto.setSpbmTxam((Long) spbmTxam.getValue());	/** column 급여_상여합계금액 : spbmTxam */
		        yeta3210Dto.setEcinTxam((Long) ecinTxam.getValue());	/** column 외국인소득금액_과세 : ecinTxam */
		        yeta3210Dto.setTaxmEcin((Long) taxmEcin.getValue());	/** column 외국인소득금액_비과세 : taxmEcin */
		        yeta3210Dto.setEarnTaxn((Long) taxmEarn.getValue());	/** column 자가운전보조금_비과세 : taxmEarn */
		        yeta3210Dto.setTaxmEtam((Long) taxmEtam.getValue());	/** column 정액급식비_비과세 : taxmEtam */
		        yeta3210Dto.setTxetTxam((Long) txetTxam.getValue());	/** column 정액급식비_과세 : txetTxam */
		        yeta3210Dto.setAddrBhtx((Long) addrBhtx.getValue());	/** column 출산보육수당_비과세 : addrBhtx */
		        yeta3210Dto.setSpciHlth((Long) spciHlth.getValue());	/** column 건강보험료금액 : spciHlth */
		        yeta3210Dto.setSpciEmpf((Long) spciEmpf.getValue());	/** column 고용보험료금액 : spciEmpf */
		        yeta3210Dto.setNatnPsnf((Long) natnPsnf.getValue());	/** column 국민연금금액 : natnPsnf */
		        yeta3210Dto.setEarnTaxn((Long) earnTaxn.getValue());	/** column 소득세 : earnTaxn */
		        yeta3210Dto.setIhtxTaxn((Long) ihtxTaxn.getValue());	/** column 지방소득세 : ihtxTaxn */
		        yeta3210Dto.setEtccTxam((Long) etccTxam.getValue());	/** column 기타금액_과세 : etccTxam */
		        yeta3210Dto.setEtccEtam((Long) etccEtam.getValue());	/** column 기타금액_비과세 : etccEtam */

		        listYeta3210dto.add(yeta3210Dto);
				
			}else {
				while (records.hasNext()) {
					Record record = (Record) records.next();
					BaseModel bmMapModel = (BaseModel) record.getModel();

					yeta3210Dto = new Ye16Ta3210DTO();
					listYeta3210dto = new ArrayList<Ye16Ta3210DTO>();

					yeta3210Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
					yeta3210Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** SYSTEMKEY : systemkey */
					yeta3210Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
					yeta3210Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
					
					
					yeta3210Dto.setElctYymm(MSFSharedUtils.allowNulls(bmMapModel.get("elctYymm")));		/** column 지급년월 : elctYymm */
					yeta3210Dto.setElctDate(MSFSharedUtils.allowNulls(bmMapModel.get("elctDate")));		/** column 급여지급일자 : elctDate */
			    	yeta3210Dto.setSuprTxam((Long)bmMapModel.get("suprTxam"));	/** column 급여지급금액_과세 : suprTxam */
			    	yeta3210Dto.setBuamTxam((Long)bmMapModel.get("buamTxam"));	/** column 상여금_과세 : buamTxam */
			    	yeta3210Dto.setInbsAmnt((Long)bmMapModel.get("inbsAmnt"));	/** column 인정상여금액 : inbsAmnt */
			    	yeta3210Dto.setStckInam((Long)bmMapModel.get("stckInam"));	/** column 주식행사이익금액 : stckInam */
			        yeta3210Dto.setSpbmTxam((Long)bmMapModel.get("spbmTxam"));	/** column 급여_상여합계금액 : spbmTxam */
			        yeta3210Dto.setEcinTxam((Long)bmMapModel.get("ecinTxam"));	/** column 외국인소득금액_과세 : ecinTxam */
			        yeta3210Dto.setTaxmEcin((Long)bmMapModel.get("taxmEcin"));	/** column 외국인소득금액_비과세 : taxmEcin */
			        yeta3210Dto.setEarnTaxn((Long)bmMapModel.get("taxmEarn"));	/** column 자가운전보조금_비과세 : taxmEarn */
			        yeta3210Dto.setTaxmEtam((Long)bmMapModel.get("taxmEtam"));	/** column 정액급식비_비과세 : taxmEtam */
			        yeta3210Dto.setTxetTxam((Long)bmMapModel.get("txetTxam"));	/** column 정액급식비_과세 : txetTxam */
			        yeta3210Dto.setAddrBhtx((Long)bmMapModel.get("addrBhtx"));	/** column 출산보육수당_비과세 : addrBhtx */
			        yeta3210Dto.setSpciHlth((Long)bmMapModel.get("spciHlth"));	/** column 건강보험료금액 : spciHlth */
			        yeta3210Dto.setSpciEmpf((Long)bmMapModel.get("spciEmpf"));	/** column 고용보험료금액 : spciEmpf */
			        yeta3210Dto.setNatnPsnf((Long)bmMapModel.get("natnPsnf"));	/** column 국민연금금액 : natnPsnf */
			        yeta3210Dto.setEarnTaxn((Long)bmMapModel.get("earnTaxn"));	/** column 소득세 : earnTaxn */
			        yeta3210Dto.setIhtxTaxn((Long)bmMapModel.get("ihtxTaxn"));	/** column 지방소득세 : ihtxTaxn */
			        yeta3210Dto.setEtccTxam((Long)bmMapModel.get("etccTxam"));	/** column 기타금액_과세 : etccTxam */
			        yeta3210Dto.setEtccEtam((Long)bmMapModel.get("etccEtam"));	/** column 기타금액_비과세 : etccEtam */

			        listYeta3210dto.add(yeta3210Dto);
					}  
			                
					if (listYeta3210dto.size() <= 0) {
						MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
						return;
						}	
				}

			
				yetaP13009Service.activityOnYetaP13009ToYeta3210(listYeta3210dto, actionDatabase, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									,MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP13009ToYeta3210("+ actionDatabase.name()+ ") : " + caught), null);
						}

						public void onSuccess(Long result) {
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),actionDatabase+ "처리가 완료되지 않았습니다. 데이타를 확인하십시요.",null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),actionDatabase + "처리가 완료되었습니다.", null);
								reload();
								actionDatabase = ActionDatabase.UPDATE;
							}
						}
					});
		} else {
			MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
			return;
		}
	}
			
	
	//주현근무지상세 초기화
	public void resetYetaP13009() {
			
		elctDate.reset(); // 급여지급일자
		suprTxam.setValue(null); // 급여지급금액_과세
		buamTxam.setValue(null); // 상여금_과세
		hanNm.setValue(""); // 성명
		elctYymm.setValue(""); // 지급년월
		inbsAmnt.setValue(null); // 인정상여금_과세
		stckInam.setValue(null); // 주식행사이익금액
		spbmTxam.setValue(null); // 급여_상여합계금액
		ecinTxam.setValue(null); // 외국인소득금액_과세
		taxmEcin.setValue(null); // 외국인소득금액_비과세
		taxmEarn.setValue(null); // 자가운전보조금_비과세
		taxmEtam.setValue(null); // 정액급식비_비과세
		txetTxam.setValue(null); // 정액급식비_과세
		addrBhtx.setValue(null); // 출산보육수당_비과세
		spciHlth.setValue(null); // 건강보험료금액
		spciEmpf.setValue(null); // 고용보험료금액
		natnPsnf.setValue(null); // 국민연금금액
		earnTaxn.setValue(null); // 소득세
		ihtxTaxn.setValue(null); // 지방소득세
		etccTxam.setValue(null); // 기타금액_과세
		etccEtam.setValue(null); // 기타금액_비과세
		    
	}
	
	
	/** 주현근무지 상세내역을 가져옴 **/
	private void yetaP13009ToYeta3210Detail(BaseModel selRecord) {
		
		dpobCd.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("dpobCd")));/** 사업장코드 : dpobCd */
		systemkey.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("systemkey")));/** SYSTEMKEY : systemkey */
		edacRvyy.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("edacRvyy")));/** column 연말정산년도 : edacRvyy */
		settGbcd.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("settGbcd")));/** column 정산구분코드 : settGbcd */
		
		elctYymm.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("elctYymm")));	/** column 지급년월 : elctYymm */
		elctDate.setValue(GWTUtils.getDateFromString((String) selRecord.get("elctDate")));	/** column 급여지급일자 : elctDate */
		suprTxam.setValue((Long) selRecord.get("elctYymm"));	/** column 급여지급금액_과세 : suprTxam */
		buamTxam.setValue((Long) selRecord.get("buamTxam"));	/** column 상여금_과세 : buamTxam */
		inbsAmnt.setValue((Long) selRecord.get("inbsAmnt"));	/** column 인정상여금액 : inbsAmnt */
		stckInam.setValue((Long) selRecord.get("stckInam"));	/** column 주식행사이익금액 : stckInam */
		spbmTxam.setValue((Long) selRecord.get("spbmTxam"));	/** column 급여_상여합계금액 : spbmTxam */
		ecinTxam.setValue((Long) selRecord.get("ecinTxam"));	/** column 외국인소득금액_과세 : ecinTxam */
		taxmEcin.setValue((Long) selRecord.get("taxmEcin"));	/** column 외국인소득금액_비과세 : taxmEcin */
		taxmEarn.setValue((Long) selRecord.get("taxmEarn"));	/** column 자가운전보조금_비과세 : taxmEarn */
		taxmEtam.setValue((Long) selRecord.get("taxmEtam"));	/** column 정액급식비_비과세 : taxmEtam */
		txetTxam.setValue((Long) selRecord.get("txetTxam"));	/** column 정액급식비_과세 : txetTxam */
		addrBhtx.setValue((Long) selRecord.get("addrBhtx"));	/** column 출산보육수당_비과세 : addrBhtx */
		spciHlth.setValue((Long) selRecord.get("spciHlth"));	/** column 건강보험료금액 : spciHlth */
		spciEmpf.setValue((Long) selRecord.get("spciEmpf"));	/** column 고용보험료금액 : spciEmpf */
		natnPsnf.setValue((Long) selRecord.get("natnPsnf"));	/** column 국민연금금액 : natnPsnf */
		earnTaxn.setValue((Long) selRecord.get("earnTaxn"));	/** column 소득세 : earnTaxn */
		ihtxTaxn.setValue((Long) selRecord.get("ihtxTaxn"));	/** column 지방소득세 : ihtxTaxn */
		etccTxam.setValue((Long) selRecord.get("etccTxam"));	/** column 기타금액_과세 : etccTxam */
		etccEtam.setValue((Long) selRecord.get("etccEtam"));	/** column 기타금액_비과세 : etccEtam */
	}
	
	
	public void reload() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		
		yetaP13009GridPanel.getTableDef().setTableColumnFilters(filters);
		yetaP13009GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//		yetaP13001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
//				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
		yetaP13009GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		yetaP13009GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
	 
		yetaP13009GridPanel.reload();
		
//		actionDatabase = ActionDatabase.READ;
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
