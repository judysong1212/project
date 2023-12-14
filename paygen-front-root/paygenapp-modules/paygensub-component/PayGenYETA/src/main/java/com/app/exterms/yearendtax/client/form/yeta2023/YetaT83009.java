/**
 * 신용카드등
 */
package com.app.exterms.yearendtax.client.form.yeta2023;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaT83009Service;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaT83009ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.app.exterms.yearendtax.client.form.defs.yeta2016.YetaT83009Def;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT83009   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYetaT83009; 
	  
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
	private MSFGridPanel YetaT83009GridPanel;
//	private YetaT83009Def YetaT83009Def = new YetaT83009Def("YetaT83009");   //TODO 일단 화면번호로 Def
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private YetaT83009ServiceAsync yetaT83009Service = YetaT83009Service.Util.getInstance();
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
 	private NumberField srhSum1; //신용카드등(본인2014년)
 	private NumberField srhSum2; //신용카드등(본인2015년)
 	private NumberField srhSum3; //신용카드등(당해년도 상반기)
 	private NumberField srhSum4; //신용카드등(당해년도 하반기)
 	private NumberField srhSum1_1; //추가공제율(본인2014년)
 	private NumberField srhSum2_2; //추가공제율(본인2015년)
 	private NumberField srhSum3_3; //추가공제율(당해년도 상반기)
 	private NumberField srhSum4_4; //추가공제율(당해년도 하반기)
 	
 	private NumberField srhSum5; //신용카드 국세청자료 상반기
 	private NumberField srhSum5_5; //신용카드 국세청자료 하반기
 	private NumberField srhSum6; //직불카드 국세청자료 상반기
 	private NumberField srhSum6_6; //직불카드 국세청자료 하반기
 	private NumberField srhSum7; //현금영수증 국세청자료 상반기
 	private NumberField srhSum7_7; //현금영수증 국세청자료 하반기
 	private NumberField srhSum8; //전통시장 국세청자료 상반기
 	private NumberField srhSum8_8; //전통시장 국세청자료 하반기
 	private NumberField srhSum9; //대중교통 국세청자료 상반기
 	private NumberField srhSum9_9; //대중교통 국세청자료 하반기
 	
 	private NumberField srhSum10; //신용카드 그밖의자료 상반기
 	private NumberField srhSum10_10; //신용카드 그밖의자료 하반기
 	private NumberField srhSum11; //직불카드 그밖의자료 상반기
 	private NumberField srhSum11_11; //직불카드 그밖의자료 하반기
 	private NumberField srhSum12; //현금영수증 그밖의자료 상반기
 	private NumberField srhSum12_12; //현금영수증 그밖의자료 하반기
 	private NumberField srhSum13; //전통시장 그밖의자료 상반기
 	private NumberField srhSum13_13; //전통시장 그밖의자료 하반기
 	private NumberField srhSum14; //대중교통 그밖의자료 상반기
 	private NumberField srhSum14_14; //대중교통 그밖의자료 하반기
 	
 	private MSFNumberField srhSum20; //신용카드계 상반기
 	private MSFNumberField srhSum21; //직불카드계 상반기
 	private MSFNumberField srhSum22; //현금영수증계 상반기
 	
 	private MSFNumberField srhSum20_20; //신용카드계 하반기
 	private MSFNumberField srhSum21_21; //직불카드계 하반기
 	private MSFNumberField srhSum22_22; //현금영수증계 하반기
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산귀속년도 : edacRvyy */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : settGbcd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
 	// -------------- 검색 조건 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

      
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
	 				yetaT83019FormSave();
	 				break;
	 			case UPDATE:
	 				this.actionDatabase = ActionDatabase.UPDATE;
	 				yetaT83019FormSave();
	 				break;
	 			case DELETE:
	 				this.actionDatabase = ActionDatabase.DELETE;
	 				yetaT83019FormSave();
	 				break;
	 		}
	 	}
			
			
		private void yetaT83019FormSave() {  
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
		                
				yetaT83009Service.activityOnYetaT83009(listYe162510Dto, actionDatabase, new AsyncCallback<Long>(){
					
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("yetaT83019FormSave(" + actionDatabase.name() + ") : " + caught), null);
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
	  
	public YetaT83009(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
	 	cpYetaT83009 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
	 	createMsfGridForm();		//그리드필드
		   
		cpYetaT83009.setBodyBorder(false);
		cpYetaT83009.setBorders(false);
		cpYetaT83009.setHeaderVisible(false);
		cpYetaT83009.setSize("790px", "640px");
		   
		this.add(cpYetaT83009);
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
		cpYetaT83009.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYetaT83009.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYetaT83009.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYetaT83009.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYetaT83009.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYetaT83009.add(hanNm);
			
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
		        

		cpYetaT83009.setLayout(new FlowLayout());

//		topYetaBtnBar = new ButtonBar();
//		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);
//
//		btnYetaNew = new Button("신규");
//		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
//		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//	 	    		 return;
//	      	     }
//				 
//				YetaT83009GridPanel.getMsfGrid().clearData();
//				 
//				BaseModel bmData = YetaT83009GridPanel.getTableDef().getDefaultValues();  
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
//		        YetaT83009GridPanel.getMsfGrid().getGrid().stopEditing();      
//		        YetaT83009GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		        YetaT83009GridPanel.getMsfGrid().getGrid().startEditing(YetaT83009GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
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
//				Iterator<BaseModel> itBm = YetaT83009GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				List<Record> lsRec = new ArrayList<Record>();
//
//				
//				if((ActionDatabase.INSERT).equals(actionDatabase)) {
//					YetaT83009GridPanel.getMsfGrid().clearData();
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
//				
//		btnYetaSave = new Button("저장");
//		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
//		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				setListRecord(YetaT83009GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
//				doAction(actionDatabase);
//
//				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
//					actionDatabase = ActionDatabase.INSERT;
//				} else {
//					actionDatabase = ActionDatabase.UPDATE;
//				}
//			}
//		});
//
//		topYetaBtnBar.add(btnYetaSave);
//				
////			btnYetaClose  = new Button("닫기");
////			topYetaBtnBar.add(btnYetaClose);
//				
//		cpYetaT83009.add(topYetaBtnBar);
		  	
		  	
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
			
		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol0.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol0.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol0.add(lcSchCol05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
			

		fieldSet.add(lcSchCol, new FormData("100%"));
		fieldSet.add(lcSchCol0, new FormData("100%"));

		cpYetaT83009.add(fieldSet);
		
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
//		cpYetaT83009.add(topYetaBtnBar);
		
//		YetaT83009GridPanel = new MSFGridPanel(YetaT83009Def, false, false, false, false, false);
//		YetaT83009GridPanel.setSize("790px", "420px");
//		YetaT83009GridPanel.setBorders(true);
//		YetaT83009GridPanel.setHeaderVisible(false);
		
		
//		/** --- 그리드 합계 부분  시작 --- **/
//		// TODO 현재 월세계, 비과세로 수정
//		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 비과세소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "비과세소득계");  
//		
//		YetaT83009GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
//		
//		AggregationRowConfig<BaseModel> payrSummaryRow1 = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow1.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 감면소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow1.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow1.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow1.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "감면소득계");  
//		
//		YetaT83009GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow1);
//		/** --- 그리드 합계 부분  종료 --- **/
		
//        cpYetaT83009.add(YetaT83009GridPanel);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fldstNewFieldset_1 = new FieldSet();
		//fldstNewFieldset_1.setSize("790px", "600px");
		fldstNewFieldset_1.setHeadingHtml("신용카드등사용액소득공제");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setWidth(575);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "3px");
		layoutContainer.add(fldstNewFieldset_1);
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		//fldstNewFieldset_1.setSize("790px", "600px");
		fldstNewFieldset_2.setHeadingHtml("근로자 본인 신용카드 등 연간 사용금액");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "3px");
		fldstNewFieldset_1.add(fldstNewFieldset_2);
		
		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		FormLayout frmlytSch01 = new FormLayout();
		frmlytSch01.setLabelWidth(170);
		frmlytSch01.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1.setLayout(frmlytSch01);
		
		srhSum1 = new NumberField();
		srhSum1.setAllowDecimals(true); 
		srhSum1.setPropertyEditorType(Long.class); 
		srhSum1.setFormat(NumberFormat.getDecimalFormat());
		srhSum1.setFieldLabel("신용카드등(본인2014년)");
		layoutContainer1_1.add(srhSum1, new FormData("100%"));
		
		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		FormLayout frmlytSch02 = new FormLayout();
		frmlytSch02.setLabelWidth(170);
		frmlytSch02.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_2.setLayout(frmlytSch02);
		
		srhSum1_1 = new NumberField();
		srhSum1_1.setAllowDecimals(true); 
		srhSum1_1.setPropertyEditorType(Long.class); 
		srhSum1_1.setFormat(NumberFormat.getDecimalFormat());
		srhSum1_1.setFieldLabel("추가공제율(본인2014년)");
		layoutContainer1_2.add(srhSum1_1, new FormData("100%"));
		
		layoutContainer1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_2.add(layoutContainer1);
		//////// 
		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		FormLayout frmlytSch03 = new FormLayout();
		frmlytSch03.setLabelWidth(170);
		frmlytSch03.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_1.setLayout(frmlytSch03);
		
		srhSum2 = new NumberField();
		srhSum2.setAllowDecimals(true); 
		srhSum2.setPropertyEditorType(Long.class); 
		srhSum2.setFormat(NumberFormat.getDecimalFormat());
		srhSum2.setFieldLabel("신용카드등(본인2015년)");
		layoutContainer2_1.add(srhSum2, new FormData("100%"));
		
		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		FormLayout frmlytSch04 = new FormLayout();
		frmlytSch04.setLabelWidth(170);
		frmlytSch04.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_2.setLayout(frmlytSch04);
		
		srhSum2_2 = new NumberField();
		srhSum2_2.setAllowDecimals(true); 
		srhSum2_2.setPropertyEditorType(Long.class); 
		srhSum2_2.setFormat(NumberFormat.getDecimalFormat());
		srhSum2_2.setFieldLabel("추가공제율(본인2015년)");
		layoutContainer2_2.add(srhSum2_2, new FormData("100%"));
		
		layoutContainer2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer2.add(layoutContainer2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_2.add(layoutContainer2);
		//////
		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer3_1 = new LayoutContainer();
		FormLayout frmlytSch05 = new FormLayout();
		frmlytSch05.setLabelWidth(170);
		frmlytSch05.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_1.setLayout(frmlytSch05);
		
		srhSum3 = new NumberField();
		srhSum3.setAllowDecimals(true); 
		srhSum3.setPropertyEditorType(Long.class); 
		srhSum3.setFormat(NumberFormat.getDecimalFormat());
		srhSum3.setFieldLabel("신용카드등(당해년도상반기)");
		layoutContainer3_1.add(srhSum3, new FormData("100%"));
		
		LayoutContainer layoutContainer3_2 = new LayoutContainer();
		FormLayout frmlytSch06 = new FormLayout();
		frmlytSch06.setLabelWidth(170);
		frmlytSch06.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_2.setLayout(frmlytSch06);
		
		srhSum3_3 = new NumberField();
		srhSum3_3.setAllowDecimals(true); 
		srhSum3_3.setPropertyEditorType(Long.class); 
		srhSum3_3.setFormat(NumberFormat.getDecimalFormat());
		srhSum3_3.setFieldLabel("추가공제율(당해년도상반기)");
		layoutContainer3_2.add(srhSum3_3, new FormData("100%"));
		
		layoutContainer3.add(layoutContainer3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer3.add(layoutContainer3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_2.add(layoutContainer3);
		////
		LayoutContainer layoutContainer4 = new LayoutContainer();
		layoutContainer4.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer4_1 = new LayoutContainer();
		FormLayout frmlytSch07 = new FormLayout();
		frmlytSch07.setLabelWidth(170);
		frmlytSch07.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_1.setLayout(frmlytSch07);
		
		srhSum4 = new NumberField();
		srhSum4.setAllowDecimals(true); 
		srhSum4.setPropertyEditorType(Long.class); 
		srhSum4.setFormat(NumberFormat.getDecimalFormat());
		srhSum4.setFieldLabel("신용카드등(당해년도하반기)");
		layoutContainer4_1.add(srhSum4, new FormData("100%"));
		
		LayoutContainer layoutContainer4_2 = new LayoutContainer();
		FormLayout frmlytSch08 = new FormLayout();
		frmlytSch08.setLabelWidth(170);
		frmlytSch08.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_2.setLayout(frmlytSch08);
		
		srhSum4_4 = new NumberField();
		srhSum4_4.setAllowDecimals(true); 
		srhSum4_4.setPropertyEditorType(Long.class); 
		srhSum4_4.setFormat(NumberFormat.getDecimalFormat());
		srhSum4_4.setFieldLabel("추가공제율(당해년도하반기)");
		layoutContainer4_2.add(srhSum4_4, new FormData("100%"));
		
		layoutContainer4.add(layoutContainer4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer4.add(layoutContainer4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_2.add(layoutContainer4);

		FieldSet fldstNewFieldset_3 = new FieldSet();
		//fldstNewFieldset_1.setSize("790px", "600px");
		fldstNewFieldset_3.setHeadingHtml("당해년도 신용카드 등 근무기간 사용금액");
		fldstNewFieldset_3.setCollapsible(false);
		fldstNewFieldset_3.setStyleAttribute("marginTop", "3px");
		fldstNewFieldset_1.add(fldstNewFieldset_3);
		
		
		FieldSet fldstNewFieldset_4 = new FieldSet();
		//fldstNewFieldset_1.setSize("790px", "600px");
		fldstNewFieldset_4.setHeadingHtml("국세청 자료");
		fldstNewFieldset_4.setCollapsible(false);
		fldstNewFieldset_4.setStyleAttribute("marginTop", "3px");
		fldstNewFieldset_3.add(fldstNewFieldset_4);
		
		LayoutContainer layoutContainer5 = new LayoutContainer();
		layoutContainer5.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer5_1 = new LayoutContainer();
		FormLayout frmlytSch09 = new FormLayout();
		frmlytSch09.setLabelWidth(170);
		frmlytSch09.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_1.setLayout(frmlytSch09);
		
		srhSum5 = new NumberField();
		srhSum5.setAllowDecimals(true); 
		srhSum5.setPropertyEditorType(Long.class); 
		srhSum5.setFormat(NumberFormat.getDecimalFormat());
		srhSum5.setFieldLabel("신용카드 상반기");
		layoutContainer5_1.add(srhSum5, new FormData("100%"));
		
		LayoutContainer layoutContainer5_2 = new LayoutContainer();
		FormLayout frmlytSch010 = new FormLayout();
		frmlytSch010.setLabelWidth(170);
		frmlytSch010.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_2.setLayout(frmlytSch010);
		
		srhSum5_5 = new NumberField();
		srhSum5_5.setAllowDecimals(true); 
		srhSum5_5.setPropertyEditorType(Long.class); 
		srhSum5_5.setFormat(NumberFormat.getDecimalFormat());
		srhSum5_5.setFieldLabel("신용카드 하반기");
		layoutContainer5_2.add(srhSum5_5, new FormData("100%"));
		
		layoutContainer5.add(layoutContainer5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer5.add(layoutContainer5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_4.add(layoutContainer5);
		/////
		
		LayoutContainer layoutContainer6 = new LayoutContainer();
		layoutContainer6.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer6_1 = new LayoutContainer();
		FormLayout frmlytSch11 = new FormLayout();
		frmlytSch11.setLabelWidth(170);
		frmlytSch11.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6_1.setLayout(frmlytSch11);
		
		srhSum6 = new NumberField();
		srhSum6.setAllowDecimals(true); 
		srhSum6.setPropertyEditorType(Long.class); 
		srhSum6.setFormat(NumberFormat.getDecimalFormat());
		srhSum6.setFieldLabel("직불카드 상반기");
		layoutContainer6_1.add(srhSum6, new FormData("100%"));
		
		LayoutContainer layoutContainer6_2 = new LayoutContainer();
		FormLayout frmlytSch012 = new FormLayout();
		frmlytSch012.setLabelWidth(170);
		frmlytSch012.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6_2.setLayout(frmlytSch012);
		
		srhSum6_6 = new NumberField();
		srhSum6_6.setAllowDecimals(true); 
		srhSum6_6.setPropertyEditorType(Long.class); 
		srhSum6_6.setFormat(NumberFormat.getDecimalFormat());
		srhSum6_6.setFieldLabel("직불카드 하반기");
		layoutContainer6_2.add(srhSum6_6, new FormData("100%"));
		
		layoutContainer6.add(layoutContainer6_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer6.add(layoutContainer6_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_4.add(layoutContainer6);
		////
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer7_1 = new LayoutContainer();
		FormLayout frmlytSch13 = new FormLayout();
		frmlytSch13.setLabelWidth(170);
		frmlytSch13.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7_1.setLayout(frmlytSch13);
		
		srhSum7 = new NumberField();
		srhSum7.setAllowDecimals(true); 
		srhSum7.setPropertyEditorType(Long.class); 
		srhSum7.setFormat(NumberFormat.getDecimalFormat());
		srhSum7.setFieldLabel("현금영수증 상반기");
		layoutContainer7_1.add(srhSum7, new FormData("100%"));
		
		LayoutContainer layoutContainer7_2 = new LayoutContainer();
		FormLayout frmlytSch014 = new FormLayout();
		frmlytSch014.setLabelWidth(170);
		frmlytSch014.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7_2.setLayout(frmlytSch014);
		
		srhSum7_7 = new NumberField();
		srhSum7_7.setAllowDecimals(true); 
		srhSum7_7.setPropertyEditorType(Long.class); 
		srhSum7_7.setFormat(NumberFormat.getDecimalFormat());
		srhSum7_7.setFieldLabel("현금영수증 하반기");
		layoutContainer7_2.add(srhSum7_7, new FormData("100%"));
		
		layoutContainer7.add(layoutContainer7_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer7.add(layoutContainer7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_4.add(layoutContainer7);
		////
		
		LayoutContainer layoutContainer8 = new LayoutContainer();
		layoutContainer8.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer8_1 = new LayoutContainer();
		FormLayout frmlytSch15 = new FormLayout();
		frmlytSch15.setLabelWidth(170);
		frmlytSch15.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer8_1.setLayout(frmlytSch15);
		
		srhSum8 = new NumberField();
		srhSum8.setAllowDecimals(true); 
		srhSum8.setPropertyEditorType(Long.class); 
		srhSum8.setFormat(NumberFormat.getDecimalFormat());
		srhSum8.setFieldLabel("전통시장분 상반기");
		layoutContainer8_1.add(srhSum8, new FormData("100%"));
		
		LayoutContainer layoutContainer8_2 = new LayoutContainer();
		FormLayout frmlytSch016 = new FormLayout();
		frmlytSch016.setLabelWidth(170);
		frmlytSch016.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer8_2.setLayout(frmlytSch016);
		
		srhSum8_8 = new NumberField();
		srhSum8_8.setAllowDecimals(true); 
		srhSum8_8.setPropertyEditorType(Long.class); 
		srhSum8_8.setFormat(NumberFormat.getDecimalFormat());
		srhSum8_8.setFieldLabel("전통시장분 하반기");
		layoutContainer8_2.add(srhSum8_8, new FormData("100%"));
		
		layoutContainer8.add(layoutContainer8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer8.add(layoutContainer8_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_4.add(layoutContainer8);
		////
		LayoutContainer layoutContainer9 = new LayoutContainer();
		layoutContainer9.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer9_1 = new LayoutContainer();
		FormLayout frmlytSch17 = new FormLayout();
		frmlytSch17.setLabelWidth(170);
		frmlytSch17.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_1.setLayout(frmlytSch17);
		
		srhSum9 = new NumberField();
		srhSum9.setAllowDecimals(true); 
		srhSum9.setPropertyEditorType(Long.class); 
		srhSum9.setFormat(NumberFormat.getDecimalFormat());
		srhSum9.setFieldLabel("대중교통분 상반기");
		layoutContainer9_1.add(srhSum9, new FormData("100%"));
		
		LayoutContainer layoutContainer9_2 = new LayoutContainer();
		FormLayout frmlytSch018 = new FormLayout();
		frmlytSch018.setLabelWidth(170);
		frmlytSch018.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_2.setLayout(frmlytSch018);
		
		srhSum9_9 = new NumberField();
		srhSum9_9.setAllowDecimals(true); 
		srhSum9_9.setPropertyEditorType(Long.class); 
		srhSum9_9.setFormat(NumberFormat.getDecimalFormat());
		srhSum9_9.setFieldLabel("대중교통분 하반기");
		layoutContainer9_2.add(srhSum9_9, new FormData("100%"));
		
		layoutContainer9.add(layoutContainer9_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer9.add(layoutContainer9_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_4.add(layoutContainer9);
		
		FieldSet fldstNewFieldset_5 = new FieldSet();
		//fldstNewFieldset_1.setSize("790px", "600px");
		fldstNewFieldset_5.setHeadingHtml("그밖의 자료");
		fldstNewFieldset_5.setCollapsible(false);
		fldstNewFieldset_5.setStyleAttribute("marginTop", "3px");
		fldstNewFieldset_3.add(fldstNewFieldset_5);
		
		LayoutContainer layoutContainer10 = new LayoutContainer();
		layoutContainer10.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer10_1 = new LayoutContainer();
		FormLayout frmlytSch19 = new FormLayout();
		frmlytSch19.setLabelWidth(170);
		frmlytSch19.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10_1.setLayout(frmlytSch19);
		
		srhSum10 = new NumberField();
		srhSum10.setAllowDecimals(true); 
		srhSum10.setPropertyEditorType(Long.class); 
		srhSum10.setFormat(NumberFormat.getDecimalFormat());
		srhSum10.setFieldLabel("신용카드 상반기");
		layoutContainer10_1.add(srhSum10, new FormData("100%"));
		
		LayoutContainer layoutContainer10_2 = new LayoutContainer();
		FormLayout frmlytSch020 = new FormLayout();
		frmlytSch020.setLabelWidth(170);
		frmlytSch020.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10_2.setLayout(frmlytSch020);
		
		srhSum10_10 = new NumberField();
		srhSum10_10.setAllowDecimals(true); 
		srhSum10_10.setPropertyEditorType(Long.class); 
		srhSum10_10.setFormat(NumberFormat.getDecimalFormat());
		srhSum10_10.setFieldLabel("신용카드 하반기");
		layoutContainer10_2.add(srhSum10_10, new FormData("100%"));
		
		layoutContainer10.add(layoutContainer10_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer10.add(layoutContainer10_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_5.add(layoutContainer10);
		///
		LayoutContainer layoutContainer11 = new LayoutContainer();
		layoutContainer11.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer11_1 = new LayoutContainer();
		FormLayout frmlytSch21 = new FormLayout();
		frmlytSch21.setLabelWidth(170);
		frmlytSch21.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11_1.setLayout(frmlytSch21);
		
		srhSum11 = new NumberField();
		srhSum11.setAllowDecimals(true); 
		srhSum11.setPropertyEditorType(Long.class); 
		srhSum11.setFormat(NumberFormat.getDecimalFormat());
		srhSum11.setFieldLabel("직불카드 상반기");
		layoutContainer11_1.add(srhSum11, new FormData("100%"));
		
		LayoutContainer layoutContainer11_2 = new LayoutContainer();
		FormLayout frmlytSch022 = new FormLayout();
		frmlytSch022.setLabelWidth(170);
		frmlytSch022.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11_2.setLayout(frmlytSch022);
		
		srhSum11_11 = new NumberField();
		srhSum11_11.setAllowDecimals(true); 
		srhSum11_11.setPropertyEditorType(Long.class); 
		srhSum11_11.setFormat(NumberFormat.getDecimalFormat());
		srhSum11_11.setFieldLabel("직불카드 하반기");
		layoutContainer11_2.add(srhSum11_11, new FormData("100%"));
		
		layoutContainer11.add(layoutContainer11_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer11.add(layoutContainer11_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_5.add(layoutContainer11);
		////
		
		LayoutContainer layoutContainer12 = new LayoutContainer();
		layoutContainer12.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer12_1 = new LayoutContainer();
		FormLayout frmlytSch23 = new FormLayout();
		frmlytSch23.setLabelWidth(170);
		frmlytSch23.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12_1.setLayout(frmlytSch23);
		
		srhSum12 = new NumberField();
		srhSum12.setAllowDecimals(true); 
		srhSum12.setPropertyEditorType(Long.class); 
		srhSum12.setFormat(NumberFormat.getDecimalFormat());
		srhSum12.setFieldLabel("현금영수증 상반기");
		layoutContainer12_1.add(srhSum12, new FormData("100%"));
		
		LayoutContainer layoutContainer12_2 = new LayoutContainer();
		FormLayout frmlytSch024 = new FormLayout();
		frmlytSch024.setLabelWidth(170);
		frmlytSch024.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12_2.setLayout(frmlytSch024);
		
		srhSum12_12 = new NumberField();
		srhSum12_12.setAllowDecimals(true); 
		srhSum12_12.setPropertyEditorType(Long.class); 
		srhSum12_12.setFormat(NumberFormat.getDecimalFormat());
		srhSum12_12.setFieldLabel("현금영수증 하반기");
		layoutContainer12_2.add(srhSum12_12, new FormData("100%"));
		
		layoutContainer12.add(layoutContainer12_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer12.add(layoutContainer12_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_5.add(layoutContainer12);
		////
		LayoutContainer layoutContainer13 = new LayoutContainer();
		layoutContainer13.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer13_1 = new LayoutContainer();
		FormLayout frmlytSch24 = new FormLayout();
		frmlytSch24.setLabelWidth(170);
		frmlytSch24.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13_1.setLayout(frmlytSch24);
		
		srhSum13 = new NumberField();
		srhSum13.setAllowDecimals(true); 
		srhSum13.setPropertyEditorType(Long.class); 
		srhSum13.setFormat(NumberFormat.getDecimalFormat());
		srhSum13.setFieldLabel("전통시장분 상반기");
		layoutContainer13_1.add(srhSum13, new FormData("100%"));
		
		LayoutContainer layoutContainer13_2 = new LayoutContainer();
		FormLayout frmlytSch026 = new FormLayout();
		frmlytSch026.setLabelWidth(170);
		frmlytSch026.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13_2.setLayout(frmlytSch026);
		
		srhSum13_13 = new NumberField();
		srhSum13_13.setAllowDecimals(true); 
		srhSum13_13.setPropertyEditorType(Long.class); 
		srhSum13_13.setFormat(NumberFormat.getDecimalFormat());
		srhSum13_13.setFieldLabel("전통시장분 하반기");
		layoutContainer13_2.add(srhSum13_13, new FormData("100%"));
		
		layoutContainer13.add(layoutContainer13_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer13.add(layoutContainer13_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_5.add(layoutContainer13);
		/////
		
		LayoutContainer layoutContainer14 = new LayoutContainer();
		layoutContainer14.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer14_1 = new LayoutContainer();
		FormLayout frmlytSch26 = new FormLayout();
		frmlytSch26.setLabelWidth(170);
		frmlytSch26.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14_1.setLayout(frmlytSch26);
		
		srhSum14 = new NumberField();
		srhSum14.setAllowDecimals(true); 
		srhSum14.setPropertyEditorType(Long.class); 
		srhSum14.setFormat(NumberFormat.getDecimalFormat());
		srhSum14.setFieldLabel("대중교통분 상반기");
		layoutContainer14_1.add(srhSum14, new FormData("100%"));
		
		LayoutContainer layoutContainer14_2 = new LayoutContainer();
		FormLayout frmlytSch27 = new FormLayout();
		frmlytSch27.setLabelWidth(170);
		frmlytSch27.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14_2.setLayout(frmlytSch27);
		
		srhSum14_14 = new NumberField();
		srhSum14_14.setAllowDecimals(true); 
		srhSum14_14.setPropertyEditorType(Long.class); 
		srhSum14_14.setFormat(NumberFormat.getDecimalFormat());
		srhSum14_14.setFieldLabel("대중교통분 하반기");
		layoutContainer14_2.add(srhSum14_14, new FormData("100%"));
		
		layoutContainer14.add(layoutContainer14_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer14.add(layoutContainer14_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset_5.add(layoutContainer14);
		
		LayoutContainer layoutContainer20 = new LayoutContainer();
		layoutContainer20.setLayout(new ColumnLayout());
		layoutContainer20.setWidth(575);
		
		LayoutContainer layoutContainer20_1 = new LayoutContainer();
		FormLayout frmlytSch40 = new FormLayout();
		frmlytSch40.setLabelWidth(170);
		frmlytSch40.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer20_1.setLayout(frmlytSch40);
		
		srhSum20 = new MSFNumberField();
		srhSum20.setAllowDecimals(true); 
		srhSum20.setPropertyEditorType(Long.class); 
		srhSum20.setFormat(NumberFormat.getDecimalFormat());
		srhSum20.setFieldLabel("신용카드합계(상반기)");
		layoutContainer20_1.add(srhSum20, new FormData("100%"));
		
		LayoutContainer layoutContainer20_2 = new LayoutContainer();
		FormLayout frmlytSch41 = new FormLayout();
		frmlytSch41.setLabelWidth(170);
		frmlytSch41.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer20_2.setLayout(frmlytSch41);
		
		srhSum20_20 = new MSFNumberField();
		srhSum20_20.setAllowDecimals(true); 
		srhSum20_20.setPropertyEditorType(Long.class); 
		srhSum20_20.setFormat(NumberFormat.getDecimalFormat());
		srhSum20_20.setFieldLabel("신용카드합계(하반기)");
		layoutContainer20_2.add(srhSum20_20, new FormData("100%"));
		
		layoutContainer20.add(layoutContainer20_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer20.add(layoutContainer20_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer21 = new LayoutContainer();
		layoutContainer21.setLayout(new ColumnLayout());
		layoutContainer21.setWidth(575);
		
		LayoutContainer layoutContainer21_1 = new LayoutContainer();
		FormLayout frmlytSch42 = new FormLayout();
		frmlytSch42.setLabelWidth(170);
		frmlytSch42.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer21_1.setLayout(frmlytSch42);
		
		srhSum21 = new MSFNumberField();
		srhSum21.setAllowDecimals(true); 
		srhSum21.setPropertyEditorType(Long.class); 
		srhSum21.setFormat(NumberFormat.getDecimalFormat());
		srhSum21.setFieldLabel("직불카드등합계(상반기)");
		layoutContainer21_1.add(srhSum21, new FormData("100%"));
		
		LayoutContainer layoutContainer21_2 = new LayoutContainer();
		FormLayout frmlytSch43 = new FormLayout();
		frmlytSch43.setLabelWidth(170);
		frmlytSch43.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer21_2.setLayout(frmlytSch43);
		
		srhSum21_21 = new MSFNumberField();
		srhSum21_21.setAllowDecimals(true); 
		srhSum21_21.setPropertyEditorType(Long.class); 
		srhSum21_21.setFormat(NumberFormat.getDecimalFormat());
		srhSum21_21.setFieldLabel("직불카드등합계(하반기)");
		layoutContainer21_2.add(srhSum21_21, new FormData("100%"));
		
		layoutContainer21.add(layoutContainer21_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer21.add(layoutContainer21_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer22 = new LayoutContainer();
		layoutContainer22.setLayout(new ColumnLayout());
		layoutContainer22.setWidth(575);
		
		LayoutContainer layoutContainer22_1 = new LayoutContainer();
		FormLayout frmlytSch44 = new FormLayout();
		frmlytSch44.setLabelWidth(170);
		frmlytSch44.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer22_1.setLayout(frmlytSch44);
		
		srhSum22 = new MSFNumberField();
		srhSum22.setAllowDecimals(true); 
		srhSum22.setPropertyEditorType(Long.class); 
		srhSum22.setFormat(NumberFormat.getDecimalFormat());
		srhSum22.setFieldLabel("현금영수증합계(상반기)");
		layoutContainer22_1.add(srhSum22, new FormData("100%"));
		
		LayoutContainer layoutContainer22_2 = new LayoutContainer();
		FormLayout frmlytSch45 = new FormLayout();
		frmlytSch45.setLabelWidth(170);
		frmlytSch45.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer22_2.setLayout(frmlytSch45);
		
		srhSum22_22 = new MSFNumberField();
		srhSum22_22.setAllowDecimals(true); 
		srhSum22_22.setPropertyEditorType(Long.class); 
		srhSum22_22.setFormat(NumberFormat.getDecimalFormat());
		srhSum22_22.setFieldLabel("현금영수증합계(하반기)");
		layoutContainer22_2.add(srhSum22_22, new FormData("100%"));
		
		layoutContainer22.add(layoutContainer22_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer22.add(layoutContainer22_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		cpYetaT83009.add(layoutContainer);
		cpYetaT83009.add(layoutContainer20);
		cpYetaT83009.add(layoutContainer21);
		cpYetaT83009.add(layoutContainer22);
		
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			YetaT83009GridPanel.getTableDef().setTableColumnFilters(filters);
			YetaT83009GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			YetaT83009GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			YetaT83009GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			YetaT83009GridPanel.reload();
		
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
