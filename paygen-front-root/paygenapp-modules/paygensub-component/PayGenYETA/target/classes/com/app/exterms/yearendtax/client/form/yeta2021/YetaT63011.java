/**
 * 외국인근로자감면세액
 */
package com.app.exterms.yearendtax.client.form.yeta2021;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2021.YetaT63011Service;
import com.app.exterms.yearendtax.client.service.yeta2021.YetaT63011ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
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
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.app.exterms.yearendtax.client.form.defs.yeta2016.YetaT63011Def;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT63011   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYetaT63011; 
	  
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
	private MSFGridPanel YetaT63011GridPanel;
//	private YetaT63011Def YetaT63011Def = new YetaT63011Def("YetaT63011");   //TODO 일단 화면번호로 Def
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private YetaT63011ServiceAsync yetaT63011Service = YetaT63011Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------	 
	    
	
	    
		
    
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
	private  Button btnYetaClose = new Button();	//닫기

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private ComboBox<BaseModel> srhYrtxBlggYr;		// 정산귀속년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	private TextField<String> srhResnRegnNum;   //주민번호
 	private TextField<String> srhSystemkey; 		//시스템키
 	private NumberField srhSum1; //1.입국목적 감면세액 변수명 다시 해줘야 함.
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산귀속년도 : edacRvyy */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : settGbcd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
	
	private TextArea textarea;
 	// -------------- 검색 조건 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	 private MSFDateField reymStdt;			//감면 기간 시작 일자
	 private MSFDateField reymEddt;			//감면 기간 종료 일자
	 private MSFDateField itemStdt01;			//1. 근로소득세 감면 접수일
	 private MSFDateField itemEddt01;			//1. 근로소득세 감면 제출일
	 private MSFDateField itemStdt02;			//1. 해저 확인일
	 private MSFDateField itemEddt02;			//1. 해저 확신청일
	 
	 
	 private MSFDateField itemStdt03;			//2. 접수일
	 private MSFDateField itemEddt03;			//2. 제출일
	 private TextField<String> srhSum3; //2. 감면세액
      
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
	    private CheckBoxGroup taxdIncd;		//소득세법 및 조세제한특례법에 따른 세액감면 입국목적
	    private CheckBox taxdIncd1;
	    private CheckBox taxdIncd2;
	    private CheckBox taxdIncd3;
	    
	    private CheckBoxGroup taxdIncd0;		//조세조약에 따른 세액감면 입국목적
	    private CheckBox taxdIncd5;
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
	private  ListStore<BaseModel> lsYrtxBlggYrStore = new ListStore<BaseModel>(); 	// 년도
	private  ListStore<BaseModel> lsClutSeptCd = new ListStore<BaseModel>(); 		// 정산구분
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
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
	 	//버튼에 따른 Action
	 	private void doAction(ActionDatabase actionDatabase) {
	 		switch (actionDatabase) {
	 			case INSERT:
	 				this.actionDatabase = ActionDatabase.INSERT;
	 				yetaT63019FormSave();
	 				break;
	 			case UPDATE:
	 				this.actionDatabase = ActionDatabase.UPDATE;
	 				yetaT63019FormSave();
	 				break;
	 			case DELETE:
	 				this.actionDatabase = ActionDatabase.DELETE;
	 				yetaT63019FormSave();
	 				break;
	 		}
	 	}
			
			
		private void yetaT63019FormSave() {  
			if (MSFSharedUtils.paramNotNull(records)) { 
		        
				List<Ye162510DTO> listYe162510Dto = new ArrayList<Ye162510DTO>();

				while (records.hasNext()) {
		              
					Record record = (Record) records.next(); 
					BaseModel bmMapModel = (BaseModel)record.getModel();
		                      
					Ye162510DTO ye162510Dto= new Ye162510DTO();  
		                      
					ye162510Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** 사업장코드 : dpobCd */
					ye162510Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** SYSTEMKEY : systemkey */
		                
					ye162510Dto.setYrtxBlggYr((MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr"))));    		/** column 연말정산귀속년도 : yrtxBlggYr */
					
					if((ActionDatabase.INSERT).equals(actionDatabase)) {
						ye162510Dto.setClutSeptCd((MSFSharedUtils.allowNulls(clutSeptCd.getValue())));	/** column 정산구분코드 : clutSeptCd */
					}else{
						ye162510Dto.setClutSeptCd((MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd"))));	/** column 정산구분코드 : clutSeptCd */
					}
					
					ye162510Dto.setMnthRntQntySeilNum((Long) bmMapModel.get("mnthRntQntySeilNum"));				/** column 월세일련번호 : mnthRntQntySeilNum */
					ye162510Dto.setMnthRnttyLehdrNm((MSFSharedUtils.allowNulls(bmMapModel.get("mnthRnttyLehdrNm"))));    		/** column 월세_임대인성명 : mnthRnttyLehdrNm */
					ye162510Dto.setMnthRnttyBurRgsum((MSFSharedUtils.allowNulls(bmMapModel.get("mnthRnttyBurRgsum"))));    		/** column 월세_주민번호 : mnthRnttyBurRgsum */
					ye162510Dto.setMnthRnttyHusFrmCd((MSFSharedUtils.allowNulls(bmMapModel.get("mnthRnttyHusFrmCd$commCd"))));    		/** column 월세_주택유형코드 : mnthRnttyHusFrmCd */
					System.out.println((String) bmMapModel.get("mnthRnttyHusFrmCd$commCd") + " :" +  bmMapModel.get("mnthRnttyHusFrmCd"));
//					ye162510Dto.setMnthRnttyHusCnttArea((MSFSharedUtils.allowNulls(bmMapModel.get("mnthRnttyHusCnttArea"))));    		/** column 월세주택계약면적 : mnthRnttyHusCnttArea */
					ye162510Dto.setMnthRnttyRntlAddr((MSFSharedUtils.allowNulls(bmMapModel.get("mnthRnttyRntlAddr"))));    		/** column 월세_계약서상주소 : mnthRnttyRntlAddr */
					ye162510Dto.setMnthRnttyRntlBgnnDt((GWTUtils.getStringFromDate((Date)bmMapModel.get("mnthRnttyRntlBgnnDt"),"yyyyMMdd")));    /** column 월세_임대차계약시작일자 : mnrnStdt */
					ye162510Dto.setMnthRnttyRntlEndDt((GWTUtils.getStringFromDate((Date)bmMapModel.get("mnthRnttyRntlEndDt"),"yyyyMMdd")));    /** column 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
					ye162510Dto.setMnthRnttyYrlyMnthSum(((Long) bmMapModel.get("mnthRnttyYrlyMnthSum")));    			/** column 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
					ye162510Dto.setMnthRnttyTxDducSum(((Long) bmMapModel.get("mnthRnttyTxDducSum")));    			/** column 월세_월세세액공제금액 : mnthRnttyTxDducSum */
					
		                
					listYe162510Dto.add(ye162510Dto);
				}  
		                
				if (listYe162510Dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
		                
				yetaT63011Service.activityOnYetaT63011(listYe162510Dto, actionDatabase, new AsyncCallback<Long>(){
					
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("yetaT63019FormSave(" + actionDatabase.name() + ") : " + caught), null);
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
//		 private void checkYetaP03001Auth( String authAction, ListStore<BaseModel>bm) {
//			 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				   
//				  if (!maskTracker) { unmask(); }  
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
//				 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			 }
//		 }
//
//		   final Timer tmMask = new Timer()
//		     {
//		           public void run()
//		           {
//		              // if (maskTracker)
//		              // { 
//		           	    cancel();
//		               	unmask(); 
//		               	maskTracker  = true;
//		              // }
//		           }
//		     }; 
//		     
//		 private void initLoad() {
//		
//			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//			 gwtAuthorization = GWTAuthorization.getInstance();
//			 gwtExtAuth = GWTExtAuth.getInstance();
//			
//			
//			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//				 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//				 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
//				 authMapDef.put("srhDeptCd",Boolean.FALSE);
//				 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
//			
//			 gwtExtAuth.setCheckMapDef(authMapDef);
//			
//			 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//				 //권한처리를 위해 추가된 부분
//				 mask("[화면로딩] 초기화 진행 중!");
//			 }	
//			 tmMask.scheduleRepeating(5000);
//		 }
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	 
	  
	public YetaT63011(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
		//콤보 권한초기화
//		initLoad(); 	
		
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		//layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);  
	    // this.setLayout(layout);   
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
	 	this.caller = caller;
		   
	 	cpYetaT63011 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
	 	createMsfGridForm();		//그리드필드
		   
		cpYetaT63011.setBodyBorder(false);
		cpYetaT63011.setBorders(false);
		cpYetaT63011.setHeaderVisible(false);
		cpYetaT63011.setSize("790px", "640px");
		   
		this.add(cpYetaT63011);
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
		cpYetaT63011.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYetaT63011.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYetaT63011.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYetaT63011.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYetaT63011.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYetaT63011.add(hanNm);
			
		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsClutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsYrtxBlggYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
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
		        

		cpYetaT63011.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

//		btnYetaNew = new Button("신규");
//		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
//		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//	 	    		 return;
//	      	     }
//				 
//				YetaT63011GridPanel.getMsfGrid().clearData();
//				 
//				BaseModel bmData = YetaT63011GridPanel.getTableDef().getDefaultValues();  
//		              
//				bmData.set("dpobCd",  dpobCd.getValue()); 		/** column 사업장코드 : dpobCd */
//		        bmData.set("systemkey", systemkey.getValue()); 	/** column SYSTEMKEY : systemkey */
//		        bmData.set("yrtxBlggYr", yrtxBlggYr.getValue());	/** column 연말정산귀속년도 : yrtxBlggYr */
//		        bmData.set("clutSeptCd", clutSeptCd.getValue());	/** column 정산구분코드 : clutSeptCd */
//		         
//		        bmData.set("mnthRntQntySeilNum", 0L);    /** column 월세일련번호 : mnthRntQntySeilNum */
//		        bmData.set("mnthRnttyBurRgsum", "");    /** column 월세_주민번호 : mnthRnttyBurRgsum */
//		        bmData.set("mnthRnttyHusFrmCd", "");    /** column 월세_주택유형코드 : mnthRnttyHusFrmCd */
//		        bmData.set("mnthRnttyHusCnttArea", "");    /** column 월세주택계약면적 : mnthRnttyHusCnttArea */
//		        bmData.set("mnthRnttyRntlAddr", "");    /** column 월세_계약서상주소 : mnthRnttyRntlAddr */
//		        bmData.set("mnthRnttyRntlBgnnDt", GWTUtils.getDateFromString("", "yyyyMMdd"));    /** column 월세_임대차계약시작일자 : mnthRnttyRntlBgnnDt */
//		        bmData.set("mnthRnttyRntlEndDt", GWTUtils.getDateFromString("", "yyyyMMdd"));    /** column 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
//		        bmData.set("mnthRnttyYrlyMnthSum", 0L);    /** column 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
//		        bmData.set("mnthRnttyTxDducSum", 0L);    /** column 월세_월세세액공제금액 : mnthRnttyTxDducSum */
//		         
//		        YetaT63011GridPanel.getMsfGrid().getGrid().stopEditing();      
//		        YetaT63011GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		        YetaT63011GridPanel.getMsfGrid().getGrid().startEditing(YetaT63011GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
//
//				actionDatabase = ActionDatabase.INSERT;
////				doAction(actionDatabase);
//			}
//		});
//			
//		topYetaBtnBar.add(btnYetaNew);
//
//		btnYetaDel = new Button("삭제");
//		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
//		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				Iterator<BaseModel> itBm = YetaT63011GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				List<Record> lsRec = new ArrayList<Record>();
//
//				
//				if((ActionDatabase.INSERT).equals(actionDatabase)) {
//					YetaT63011GridPanel.getMsfGrid().clearData();
//					actionDatabase = ActionDatabase.DELETE;
//				}else {
//					while (itBm.hasNext()) {
//						Record rec = new Record(itBm.next());
//						lsRec.add(rec);
//					}
//					setListRecord(lsRec.iterator());
//				}
//				
//				actionDatabase = ActionDatabase.DELETE;
//				doAction(actionDatabase);
//			}
//		});
//		topYetaBtnBar.add(btnYetaDel);
				
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(YetaT63011GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
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
				
		cpYetaT63011.add(topYetaBtnBar);
		  	
		  	
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchCol0 = new LayoutContainer();
		lcSchCol0.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");
		fieldSet.setWidth(575);

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);
			
		srhYrtxBlggYr = new ComboBox<BaseModel>();
		srhYrtxBlggYr.setName("srhYrtxBlggYr");
		srhYrtxBlggYr.setForceSelection(true);
		srhYrtxBlggYr.setMinChars(1);
		srhYrtxBlggYr.setDisplayField("yearDisp");
		srhYrtxBlggYr.setValueField("year");
		srhYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		// srhEdacRvyy.setEmptyText("--년도선택--");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(false);
		srhYrtxBlggYr.setEnabled(true);
		srhYrtxBlggYr.setStore(lsYrtxBlggYrStore);
		srhYrtxBlggYr.setFieldLabel("귀속년도");
		srhYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
			
		lcSchCol01.add(srhYrtxBlggYr, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhClutSeptCd = new ComboBox<BaseModel>();
		srhClutSeptCd.setName("srhClutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setEmptyText("--정산구분선택--");
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(false);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsClutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
		
		lcSchCol02.add(srhClutSeptCd, new FormData("100%"));
			
		LayoutContainer lcSchCol03 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03.setLayout(frmlytSch);

		srhDeptCd = new TextField<String>();
		srhDeptCd.setReadOnly(true);
		srhDeptCd.setName("srhDeptCd");
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
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");

		lcSchCol04.add(srhHanNm, new FormData("100%"));
		
		LayoutContainer lcSchCol05 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        lcSchCol05.setLayout(frmlytSch);
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        srhResnRegnNum.setName("srhResnRegnNum");
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
        srhResnRegnNum.setLabelSeparator("");
        srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
                    srhSystemkey.setValue("");
                    srhHanNm.setValue("");
                }
            }
        });
        
        lcSchCol05.add(srhResnRegnNum, new FormData("100%"));
			
		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol0.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol0.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol0.add(lcSchCol05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
			

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYetaT63011.add(fieldSet);
		
		//외국인근로자세액감면 감면기간
		FieldSet fieldSet1 = new FieldSet();
		fieldSet1.setHeadingHtml("감면기간");
		fieldSet1.setWidth(575);
		
		LayoutContainer lcSchCol1 = new LayoutContainer();
		LayoutContainer lcSchCol2 = new LayoutContainer();
		
		LayoutContainer lcSchCol10 = new LayoutContainer();
		lcSchCol10.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_23 = new LayoutContainer();
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(90);
		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_23.setLayout(frmlytSch2_1);
		layoutContainer_23.setBorders(false);
		
		LayoutContainer layoutContainer_32 = new LayoutContainer();
		FormLayout frmlytSch2_2 = new FormLayout();
		frmlytSch2_2 = new FormLayout();
		frmlytSch2_2.setLabelWidth(600);
		frmlytSch2_2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytSch2_2);
		
		reymStdt = new MSFDateField();
//		emymtBgnnDt.setWidth(100);
		reymStdt.setFieldLabel("감면기간 시작일(기술도입계약 또는 근로제공일)");
		reymStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer_32.add(reymStdt, new FormData("100%"));
//		reymStdt.setHeight("");

		layoutContainer_32.setBorders(false);


		//
		LayoutContainer layoutContainer_34 = new LayoutContainer();
//		layoutContainer_34.setWidth(100);
		FormLayout frmlytSch2_11 = new FormLayout();
		frmlytSch2_11.setLabelWidth(600);
//		frmlytSch2_1.setLabelWidth(100);
		frmlytSch2_11.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_34.setLayout(frmlytSch2_11);

		reymEddt = new MSFDateField();
//		emymtEndDt.setWidth(100);
		reymEddt.setFieldLabel("감면기간 만료일");
		reymEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer_34.add(reymEddt, new FormData("100%"));

		layoutContainer_34.setBorders(false);
		layoutContainer_23.add(lcSchCol1, new FormData("100%"));
		
		lcSchCol1.add(layoutContainer_32);
		lcSchCol2.add(layoutContainer_34);
		
		lcSchCol10.add(lcSchCol1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol10.add(lcSchCol2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		fieldSet1.add(lcSchCol0);
		fieldSet1.add(lcSchCol10);
		cpYetaT63011.add(fieldSet1);
	}    
	 	 
	  
	 
			
   	
	  @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            @Override
	            public void handleEvent(BaseEvent be) {
	            	
	            	srhDeptCd.setValue(deptNm.getValue());
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
		
//		topYetaBtnBar  = new ButtonBar();
//		topYetaBtnBar .setAlignment(HorizontalAlignment.RIGHT);
//
//		btnYetaNew   = new Button("신규");
//		topYetaBtnBar.add(btnYetaNew);
//
//		btnYetaDel  = new Button("삭제");
//		topYetaBtnBar.add(btnYetaDel);
//			
//		btnYetaSave = new Button("저장");
//		topYetaBtnBar.add(btnYetaSave);
//			
//		btnYetaClose  = new Button("닫기");
//		topYetaBtnBar.add(btnYetaClose);
//			
//		cpYetaT63011.add(topYetaBtnBar);
		
//		YetaT63011GridPanel = new MSFGridPanel(YetaT63011Def, false, false, false, false, false);
//		YetaT63011GridPanel.setSize("790px", "420px");
//		YetaT63011GridPanel.setBorders(true);
//		YetaT63011GridPanel.setHeaderVisible(false);
		
		
//		/** --- 그리드 합계 부분  시작 --- **/
//		// TODO 현재 월세계, 비과세로 수정
//		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 비과세소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "비과세소득계");  
//		
//		YetaT63011GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
//		
//		AggregationRowConfig<BaseModel> payrSummaryRow1 = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow1.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 감면소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow1.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow1.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow1.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "감면소득계");  
//		
//		YetaT63011GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow1);
//		/** --- 그리드 합계 부분  종료 --- **/
		
//        cpYetaT63011.add(YetaT63011GridPanel);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
        FieldSet fieldSet3 = new FieldSet();
        fieldSet3.setHeadingHtml("소득세법 및 조세제한특례범에 따른 세액감면");
        fieldSet3.setWidth(390);
        fieldSet3.setHeight(300);
        fieldSet3.setCollapsible(false);
        LayoutContainer layoutContainer_152 = new LayoutContainer();
		layoutContainer_152.setBorders(false);
		layoutContainer_152.setStyleAttribute("paddingLeft", "15px");
		layoutContainer_152.setStyleAttribute("marginTop", "20px");
		layoutContainer_152.setLayout(new ColumnLayout());
		
        FieldSet fieldSet3_1 = new FieldSet();
        fieldSet3_1.setHeadingHtml("입국목적");
        fieldSet3_1.setWidth(390);
        fieldSet3_1.setHeight(90);
        fieldSet3_1.setCollapsible(false);
        
        taxdIncd = new CheckBoxGroup();
		taxdIncd.setName("taxdIncd");
        
		taxdIncd1 = new CheckBox();
//			layoutContainer_152.add(chckbxNewCheckbox1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		taxdIncd.add(taxdIncd1);
		taxdIncd1.setBoxLabel("정부간협약");
		taxdIncd1.setHideLabel(true);
		taxdIncd1.setValueAttribute("Y");
	
		taxdIncd2 = new CheckBox();
//				layoutContainer_152.add(chckbxNewCheckbox2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		taxdIncd.add(taxdIncd2);
		taxdIncd2.setBoxLabel("기술도입계약");
		taxdIncd2.setHideLabel(true);
		taxdIncd2.setValueAttribute("Y");
		  
		 taxdIncd3 = new CheckBox();
//				layoutContainer_152.add(chckbxNewCheckbox3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		taxdIncd.add(taxdIncd3);
		taxdIncd3.setBoxLabel("조세특례제한법 상 감면");
		taxdIncd3.setHideLabel(true);
		taxdIncd3.setValueAttribute("Y");
		
		layoutContainer_152.add(taxdIncd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		fieldSet3_1.add(layoutContainer_152);
		
		LayoutContainer layoutContainer_151 = new LayoutContainer();
		layoutContainer_151.setStyleAttribute("marginTop", "5px");
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(90);
		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_151.setLayout(frmlytSch1);
		
		srhSum1 = new NumberField();
		srhSum1.setAllowDecimals(true); 
		srhSum1.setPropertyEditorType(Long.class); 
		srhSum1.setFormat(NumberFormat.getDecimalFormat());
		srhSum1.setFieldLabel("감면세액");
		layoutContainer_151.add(srhSum1, new FormData("70%"));
		fieldSet3_1.add(layoutContainer_151);
		
        FieldSet fieldSet3_2 = new FieldSet();
        fieldSet3_2.setHeadingHtml("외국인 근로소득에 대한 감면");
        fieldSet3_2.setWidth(390);
        fieldSet3_2.setHeight(90);
        fieldSet3_2.setCollapsible(false);
        
        LayoutContainer lcSchCol1 = new LayoutContainer();
        lcSchCol1.setLayout(new ColumnLayout());
        lcSchCol1.setStyleAttribute("marginTop", "20px");
        lcSchCol1.setStyleAttribute("paddingRight", "5px");
        lcSchCol1.setStyleAttribute("paddingLeft", "5px");
        
        LayoutContainer layoutContainer5 = new LayoutContainer();
        FormLayout frmlytSch2_2 = new FormLayout();
		frmlytSch2_2 = new FormLayout();
		frmlytSch2_2.setLabelWidth(70);
		frmlytSch2_2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5.setLayout(frmlytSch2_2);
		
		itemStdt01 = new MSFDateField();
		itemStdt01.setFieldLabel("접수일");
		itemStdt01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer5.add(itemStdt01, new FormData("100%"));
		layoutContainer5.setBorders(false);
        
        LayoutContainer layoutContainer6 = new LayoutContainer();
        FormLayout frmlytSch2_3 = new FormLayout();
        frmlytSch2_3 = new FormLayout();
        frmlytSch2_3.setLabelWidth(70);
        frmlytSch2_3.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6.setLayout(frmlytSch2_3);
		
		itemEddt01 = new MSFDateField();
		itemEddt01.setFieldLabel("제출일");
		itemEddt01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer6.add(itemEddt01, new FormData("100%"));
		layoutContainer6.setBorders(false);
		
		lcSchCol1.add(layoutContainer5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol1.add(layoutContainer6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fieldSet3_2.add(lcSchCol1);
		
        FieldSet fieldSet3_3 = new FieldSet();
        fieldSet3_3.setHeadingHtml("해저광물자원개발에 대한 감면");
        fieldSet3_3.setWidth(390);
        fieldSet3_3.setHeight(90);
        fieldSet3_3.setCollapsible(false);
        
        
        LayoutContainer lcSchCol2 = new LayoutContainer();
        lcSchCol2.setLayout(new ColumnLayout());
        lcSchCol2.setStyleAttribute("marginTop", "20px");
        lcSchCol2.setStyleAttribute("paddingRight", "5px");
        //lcSchCol2.setStyleAttribute("paddingLeft", "5px");
        
        LayoutContainer layoutContainer7 = new LayoutContainer();
        FormLayout frmlytSch2_4 = new FormLayout();
        frmlytSch2_4 = new FormLayout();
        frmlytSch2_4.setLabelWidth(130);
        frmlytSch2_4.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7.setLayout(frmlytSch2_4);
		
		itemStdt02 = new MSFDateField();
		itemStdt02.setFieldLabel("지식경제부장관 확인일");
		itemStdt02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer7.add(itemStdt02, new FormData("100%"));
		layoutContainer7.setBorders(false);
        
        LayoutContainer layoutContainer8 = new LayoutContainer();
        FormLayout frmlytSch2_5 = new FormLayout();
        frmlytSch2_5 = new FormLayout();
        frmlytSch2_5.setLabelWidth(50);
        frmlytSch2_5.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer8.setLayout(frmlytSch2_5);
		
        itemEddt02 = new MSFDateField();
        itemEddt02.setFieldLabel("신청일");
        itemEddt02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        layoutContainer8.add(itemEddt02, new FormData("100%"));
        layoutContainer8.setBorders(false);
		
        lcSchCol2.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
        lcSchCol2.add(layoutContainer8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		fieldSet3_3.add(lcSchCol2);
		
		
        FieldSet fieldSet4 = new FieldSet();
        fieldSet4.setHeadingHtml("조세조약에 따른 세액감면");
        fieldSet4.setWidth(390);
        fieldSet4.setHeight(300);
        fieldSet4.setCollapsible(false);
        
        FieldSet fieldSet4_1 = new FieldSet();
        fieldSet4_1.setHeadingHtml("입국목적");
        fieldSet4_1.setWidth(390);
        fieldSet4_1.setHeight(135);
        fieldSet4_1.setCollapsible(false);
        
        LayoutContainer lcSchCol3_1 = new LayoutContainer();
        
        lcSchCol3_1.setStyleAttribute("marginTop", "40px");
        lcSchCol3_1.setStyleAttribute("paddingRight", "30px");
        lcSchCol3_1.setStyleAttribute("paddingLeft", "5px");
        FormLayout frmlytSch2_6 = new FormLayout();
        frmlytSch2_6 = new FormLayout();
        frmlytSch2_6.setLabelWidth(60);
        frmlytSch2_6.setLabelAlign(LabelAlign.RIGHT);
        lcSchCol3_1.setLayout(frmlytSch2_6);
        
        
        LayoutContainer lcSchCol3_2 = new LayoutContainer();
        lcSchCol3_2.setLayout(new ColumnLayout());
        lcSchCol3_2.setStyleAttribute("marginTop", "40px");
        lcSchCol3_2.setStyleAttribute("paddingLeft", "30px");
        
        
        taxdIncd = new CheckBoxGroup();
		taxdIncd.setName("taxdIncd");
        
		taxdIncd5 = new CheckBox();
//			layoutContainer_152.add(chckbxNewCheckbox1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		taxdIncd.add(taxdIncd5);
		taxdIncd5.setBoxLabel("조세조약 상 감면");
		taxdIncd5.setHideLabel(true);
		taxdIncd5.setValueAttribute("Y");
		
		srhSum3 = new TextField<String>();
		srhSum3.setReadOnly(true);
		srhSum3.setName("srhSum3");
		srhSum3.setWidth(80);
		srhSum3.setFieldLabel("감면세액");
		
		lcSchCol3_1.add(srhSum1, new FormData("100%"));
		lcSchCol3_2.add(taxdIncd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		LayoutContainer lcSchCol4 = new LayoutContainer();
		lcSchCol4.setLayout(new ColumnLayout());
		lcSchCol4.add(lcSchCol3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol4.add(lcSchCol3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		fieldSet4_1.add(lcSchCol4);
        
        FieldSet fieldSet4_2 = new FieldSet();
        fieldSet4_2.setHeadingHtml("근로소득에 대한 조세조약상 면제");
        fieldSet4_2.setWidth(390);
        fieldSet4_2.setHeight(135);
        fieldSet4_2.setCollapsible(false);
        
        LayoutContainer lcSchCol5 = new LayoutContainer();
        lcSchCol5.setLayout(new ColumnLayout());
        lcSchCol5.setStyleAttribute("marginTop", "40px");
        lcSchCol5.setStyleAttribute("paddingRight", "30px");
        //lcSchCol5.setStyleAttribute("paddingLeft", "10px");
        
        LayoutContainer layoutContainer10 = new LayoutContainer();
        FormLayout frmlytSch2_9 = new FormLayout();
        frmlytSch2_9 = new FormLayout();
        frmlytSch2_9.setLabelWidth(70);
        frmlytSch2_9.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10.setLayout(frmlytSch2_9);
		
		itemStdt03 = new MSFDateField();
		itemStdt03.setFieldLabel("접수일");
		itemStdt03.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer10.add(itemStdt03, new FormData("100%"));
		layoutContainer10.setBorders(false);
        
        LayoutContainer layoutContainer11 = new LayoutContainer();
        FormLayout frmlytSch2_10 = new FormLayout();
        frmlytSch2_10 = new FormLayout();
        frmlytSch2_10.setLabelWidth(70);
        frmlytSch2_10.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer11.setLayout(frmlytSch2_10);
		
        itemEddt03 = new MSFDateField();
        itemEddt03.setFieldLabel("제출일");
        itemEddt03.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        layoutContainer11.add(itemEddt03, new FormData("100%"));
        layoutContainer11.setBorders(false);
		
        lcSchCol5.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol5.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fieldSet4_2.add(lcSchCol5);
		
		LayoutContainer layoutContainer15 = new LayoutContainer();
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("textarea");
		fldstNewFieldset_1.setCollapsible(false);
		
		textarea = new TextArea();
		textarea.setName("textarea");
		textarea.setFieldLabel("textarea");
		textarea.setHeight(180);
		textarea.setWidth(790);
		textarea.setReadOnly(true);
		layoutContainer15.add(textarea, new FormData("100%"));
		
		fldstNewFieldset_1.add(layoutContainer15);
        
//		LayoutContainer layoutContainer1 = new LayoutContainer();
//		FormLayout frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer1.setLayout(frmlytSch);
//
//		srhSum1 = new TextField<String>();
//		srhSum1.setReadOnly(true);
//		srhSum1.setName("srhMnthRnttyYrlyMnthSum");
//		srhSum1.setWidth(80);
//		srhSum1.setFieldLabel("비과세소득계");
//		layoutContainer1.add(srhSum1, new FormData("100%"));
//		
//		LayoutContainer layoutContainer2 = new LayoutContainer();
//		FormLayout frmlytSch1 = new FormLayout();
//		frmlytSch1.setLabelWidth(100);
//		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer2.setLayout(frmlytSch1);
//
//		srhSum2 = new TextField<String>();
//		srhSum2.setReadOnly(true);
//		srhSum2.setName("srhMnthRnttyYrlyMnthSum");
//		srhSum2.setWidth(80);
//		srhSum2.setFieldLabel("감면소득계");
//		layoutContainer2.add(srhSum2, new FormData("100%"));
//		
        fieldSet3.add(fieldSet3_1);
        fieldSet3.add(fieldSet3_2);
        fieldSet3.add(fieldSet3_3);
        fieldSet4.add(fieldSet4_1);
        fieldSet4.add(fieldSet4_2);
		layoutContainer.add(fieldSet3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer.add(fieldSet4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		cpYetaT63011.add(layoutContainer);
		cpYetaT63011.add(fldstNewFieldset_1);
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			YetaT63011GridPanel.getTableDef().setTableColumnFilters(filters);
			YetaT63011GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			YetaT63011GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			YetaT63011GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			YetaT63011GridPanel.reload();
		
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
