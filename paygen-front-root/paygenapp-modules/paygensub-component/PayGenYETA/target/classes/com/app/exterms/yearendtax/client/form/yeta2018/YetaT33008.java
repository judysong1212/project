/**
 * 비과세감면소득
 */
package com.app.exterms.yearendtax.client.form.yeta2018;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaT33008Service;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaT33008ServiceAsync;
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
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT33008   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYetaT33008; 
	  
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
	private MSFGridPanel YetaT33008GridPanel;
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private YetaT33008ServiceAsync yetaT33008Service = YetaT33008Service.Util.getInstance();
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
 	private NumberField cpivAsctUseAmt2; //출자투자금액 2014년 조합등 변수명 다시 해줘야 함.
 	private NumberField cpivVntUseAmt2; //출자투자금액 2014년 벤처등 변수명 다시 해줘야 함.
 	private NumberField cpivAsctUseAmt1; //출자투자금액 2015년 조합등 변수명 다시 해줘야 함.
 	private NumberField cpivVntUseAmt1; //출자투자금액 2015년 벤처등 변수명 다시 해줘야 함.
 	private NumberField cpivAsctUseAmt0; //출자투자금액 2016년 조합등 변수명 다시 해줘야 함.
 	private NumberField cpivVntUseAmt0; //출자투자금액 2016년 벤처등 변수명 다시 해줘야 함.
 	private MSFNumberField ivcpInvmUseAmtSum; //출자투자금액합계 변수명 다시 해줘야 함.
 	private TextArea textarea;				//임시선언
 	
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
	 				yetaT23019FormSave();
	 				break;
	 			case UPDATE:
	 				this.actionDatabase = ActionDatabase.UPDATE;
	 				yetaT23019FormSave();
	 				break;
	 			case DELETE:
	 				this.actionDatabase = ActionDatabase.DELETE;
	 				yetaT23019FormSave();
	 				break;
	 		}
	 	}
			
			
		private void yetaT23019FormSave() {  
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
		                
				yetaT33008Service.activityOnYetaT33008(listYe162510Dto, actionDatabase, new AsyncCallback<Long>(){
					
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("yetaT23019FormSave(" + actionDatabase.name() + ") : " + caught), null);
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
	  
	public YetaT33008(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
	 	cpYetaT33008 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
	 	createMsfGridForm();		//그리드필드
		   
		cpYetaT33008.setBodyBorder(false);
		cpYetaT33008.setBorders(false);
		cpYetaT33008.setHeaderVisible(false);
		cpYetaT33008.setSize("790px", "640px");
		   
		this.add(cpYetaT33008);
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
		cpYetaT33008.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYetaT33008.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYetaT33008.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYetaT33008.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYetaT33008.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYetaT33008.add(hanNm);
			
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
		        

		cpYetaT33008.setLayout(new FlowLayout());

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
//				YetaT33008GridPanel.getMsfGrid().clearData();
//				 
//				BaseModel bmData = YetaT33008GridPanel.getTableDef().getDefaultValues();  
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
//		        YetaT33008GridPanel.getMsfGrid().getGrid().stopEditing();      
//		        YetaT33008GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		        YetaT33008GridPanel.getMsfGrid().getGrid().startEditing(YetaT33008GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
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
//				Iterator<BaseModel> itBm = YetaT33008GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				List<Record> lsRec = new ArrayList<Record>();
//
//				
//				if((ActionDatabase.INSERT).equals(actionDatabase)) {
//					YetaT33008GridPanel.getMsfGrid().clearData();
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
				setListRecord(YetaT33008GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
				doAction(actionDatabase);

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});

		topYetaBtnBar.add(btnYetaSave);
		topYetaBtnBar.setWidth(575);
				
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
				
		cpYetaT33008.add(topYetaBtnBar);
		  	
		  	
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

		cpYetaT33008.add(fieldSet);
		
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
//		cpYetaT33008.add(topYetaBtnBar);
//		
//		YetaT33008GridPanel = new MSFGridPanel(YetaT33008Def, false, false, false, false, false);
//		YetaT33008GridPanel.setSize("790px", "420px");
//		YetaT33008GridPanel.setBorders(true);
//		YetaT33008GridPanel.setHeaderVisible(false);
//		
		
//		/** --- 그리드 합계 부분  시작 --- **/
//		// TODO 현재 월세계, 비과세로 수정
//		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 비과세소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "비과세소득계");  
//		
//		YetaT33008GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
//		
//		AggregationRowConfig<BaseModel> payrSummaryRow1 = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow1.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 감면소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow1.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow1.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow1.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "감면소득계");  
//		
//		YetaT33008GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow1);
//		/** --- 그리드 합계 부분  종료 --- **/
		
//        cpYetaT33008.add(YetaT33008GridPanel);
        
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("중소기업 창업투자조합출자공제");
		fldstNewFieldset.setCollapsible(false);
		fldstNewFieldset.setWidth(575);

		LayoutContainer layoutContainer1 = new LayoutContainer(); //출자.투자금액 textfield
		LayoutContainer layoutContainer2 = new LayoutContainer(); //출자.투자금액 큰 레이아웃
		layoutContainer2.setLayout(new ColumnLayout());
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(120);
		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1.setLayout(frmlytSch1);

		cpivAsctUseAmt2 = new NumberField();
		cpivAsctUseAmt2.setAllowDecimals(true); 
		cpivAsctUseAmt2.setPropertyEditorType(Long.class); 
		cpivAsctUseAmt2.setFormat(NumberFormat.getDecimalFormat());
		cpivAsctUseAmt2.setFieldLabel("출자·투자금액");
		layoutContainer1.add(cpivAsctUseAmt2, new FormData("100%"));
		layoutContainer2.add(layoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer_11 = new LayoutContainer(); //부가field 라벨
		layoutContainer_11.setBorders(false);
		FormLayout frmlytSch2 = new FormLayout();
		frmlytSch2.setLabelWidth(20);
		frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytSch2);
		
		Label lblfldNewLabelfield_11 = new Label();
		lblfldNewLabelfield_11.setText("(2014년도 조합등, 공제율 10%, 공제한도 50%)");
		layoutContainer_11.setStyleAttribute("paddingLeft", "10px");
		layoutContainer_11.setStyleAttribute("marginTop", "5px");
		layoutContainer_11.setStyleAttribute("marginBottom", "5px");
		layoutContainer_11.add(lblfldNewLabelfield_11);
		layoutContainer2.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer layoutContainer3 = new LayoutContainer(); //출자.투자금액 textfield
		LayoutContainer layoutContainer4 = new LayoutContainer(); //출자.투자금액 큰 레이아웃
		layoutContainer4.setLayout(new ColumnLayout());
		FormLayout frmlytSch3 = new FormLayout();
		frmlytSch3.setLabelWidth(120);
		frmlytSch3.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch3);

		cpivVntUseAmt2 = new NumberField();
		cpivVntUseAmt2.setAllowDecimals(true); 
		cpivVntUseAmt2.setPropertyEditorType(Long.class); 
		cpivVntUseAmt2.setFormat(NumberFormat.getDecimalFormat());
		cpivVntUseAmt2.setFieldLabel("출자·투자금액");
		layoutContainer3.add(cpivVntUseAmt2, new FormData("100%"));
		layoutContainer4.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer_12 = new LayoutContainer(); //부가field 라벨
		layoutContainer_12.setBorders(false);
		FormLayout frmlytSch4 = new FormLayout();
		frmlytSch4.setLabelWidth(20);
		frmlytSch4.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytSch4);
		
		Label lblfldNewLabelfield_12 = new Label();
		lblfldNewLabelfield_12.setText("(2014년도 벤처등, 공제율 50%．30%,  공제한도 50%)");
		layoutContainer_12.setStyleAttribute("paddingLeft", "10px");
		layoutContainer_12.setStyleAttribute("marginTop", "5px");
		layoutContainer_12.setStyleAttribute("marginBottom", "5px");
		layoutContainer_12.add(lblfldNewLabelfield_12);
		layoutContainer4.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer layoutContainer5 = new LayoutContainer(); //출자.투자금액 textfield
		LayoutContainer layoutContainer6 = new LayoutContainer(); //출자.투자금액 큰 레이아웃
		layoutContainer6.setLayout(new ColumnLayout());
		FormLayout frmlytSch5 = new FormLayout();
		frmlytSch5.setLabelWidth(120);
		frmlytSch5.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5.setLayout(frmlytSch5);

		cpivAsctUseAmt1 = new NumberField();
		cpivAsctUseAmt1.setAllowDecimals(true); 
		cpivAsctUseAmt1.setPropertyEditorType(Long.class); 
		cpivAsctUseAmt1.setFormat(NumberFormat.getDecimalFormat());
		cpivAsctUseAmt1.setFieldLabel("출자·투자금액");
		layoutContainer5.add(cpivAsctUseAmt1, new FormData("100%"));
		layoutContainer6.add(layoutContainer5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer_13 = new LayoutContainer(); //부가field 라벨
		layoutContainer_13.setBorders(false);
		FormLayout frmlytSch6 = new FormLayout();
		frmlytSch6.setLabelWidth(20);
		frmlytSch6.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytSch6);
		
		
		Label lblfldNewLabelfield_13 = new Label();
		lblfldNewLabelfield_13.setText("(2015년 조합등, 공제율 10%,  공제한도 50%)");
		layoutContainer_13.setStyleAttribute("paddingLeft", "10px");
		layoutContainer_13.setStyleAttribute("marginTop", "5px");
		layoutContainer_13.setStyleAttribute("marginBottom", "5px");
		layoutContainer_13.add(lblfldNewLabelfield_13);
		layoutContainer6.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer layoutContainer7 = new LayoutContainer(); //출자.투자금액 textfield
		LayoutContainer layoutContainer8 = new LayoutContainer(); //출자.투자금액 큰 레이아웃
		layoutContainer8.setLayout(new ColumnLayout());
		FormLayout frmlytSch7 = new FormLayout();
		frmlytSch7.setLabelWidth(120);
		frmlytSch7.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7.setLayout(frmlytSch7);

		cpivVntUseAmt1 = new NumberField();
		cpivVntUseAmt1.setAllowDecimals(true); 
		cpivVntUseAmt1.setPropertyEditorType(Long.class); 
		cpivVntUseAmt1.setFormat(NumberFormat.getDecimalFormat());
		cpivVntUseAmt1.setFieldLabel("출자·투자금액");
		layoutContainer7.add(cpivVntUseAmt1, new FormData("100%"));
		layoutContainer8.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer_14 = new LayoutContainer(); //부가field 라벨
		layoutContainer_14.setBorders(false);
		FormLayout frmlytSch8 = new FormLayout();
		frmlytSch8.setLabelWidth(20);
		frmlytSch8.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch8);
		
		
		Label lblfldNewLabelfield_14 = new Label();
		lblfldNewLabelfield_14.setText("(2015 벤처등, 공제율 100%．50%．30%,  공제한도 50%)");
		layoutContainer_14.setStyleAttribute("paddingLeft", "10px");
		layoutContainer_14.setStyleAttribute("marginTop", "5px");
		layoutContainer_14.setStyleAttribute("marginBottom", "5px");
		layoutContainer_14.add(lblfldNewLabelfield_14);
		layoutContainer8.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		
		LayoutContainer layoutContainer11 = new LayoutContainer(); //출자.투자금액 textfield
		LayoutContainer layoutContainer12 = new LayoutContainer(); //출자.투자금액 큰 레이아웃
		layoutContainer12.setLayout(new ColumnLayout());
		FormLayout frmlytSch15 = new FormLayout();
		frmlytSch15.setLabelWidth(120);
		frmlytSch15.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11.setLayout(frmlytSch15);

		cpivAsctUseAmt0 = new NumberField();
		cpivAsctUseAmt0.setAllowDecimals(true); 
		cpivAsctUseAmt0.setPropertyEditorType(Long.class); 
		cpivAsctUseAmt0.setFormat(NumberFormat.getDecimalFormat());
		cpivAsctUseAmt0.setFieldLabel("출자·투자금액");
		layoutContainer11.add(cpivAsctUseAmt0, new FormData("100%"));
		layoutContainer12.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer_16 = new LayoutContainer(); //부가field 라벨
		layoutContainer_16.setBorders(false);
		FormLayout frmlytSch16 = new FormLayout();
		frmlytSch16.setLabelWidth(20);
		frmlytSch16.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytSch16);
		
		
		Label lblfldNewLabelfield_16 = new Label();
		lblfldNewLabelfield_16.setText("(2016 조합등, 공제율 10%, 공제한도 50%)");
		layoutContainer_16.setStyleAttribute("paddingLeft", "10px");
		layoutContainer_16.setStyleAttribute("marginTop", "5px");
		layoutContainer_16.setStyleAttribute("marginBottom", "5px");
		layoutContainer_16.add(lblfldNewLabelfield_16);
		layoutContainer12.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer layoutContainer20= new LayoutContainer(); //출자.투자금액 textfield
		LayoutContainer layoutContainer21 = new LayoutContainer(); //출자.투자금액 큰 레이아웃
		layoutContainer21.setLayout(new ColumnLayout());
		FormLayout frmlytSch17 = new FormLayout();
		frmlytSch17.setLabelWidth(120);
		frmlytSch17.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer20.setLayout(frmlytSch17);

		cpivVntUseAmt0 = new NumberField();
		cpivVntUseAmt0.setAllowDecimals(true); 
		cpivVntUseAmt0.setPropertyEditorType(Long.class); 
		cpivVntUseAmt0.setFormat(NumberFormat.getDecimalFormat());
		cpivVntUseAmt0.setFieldLabel("출자·투자금액");
		layoutContainer20.add(cpivVntUseAmt0, new FormData("100%"));
		layoutContainer21.add(layoutContainer20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer_22 = new LayoutContainer(); //부가field 라벨
		layoutContainer_22.setBorders(false);
		FormLayout frmlytSch18 = new FormLayout();
		frmlytSch18.setLabelWidth(20);
		frmlytSch18.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_22.setLayout(frmlytSch18);
		
		Label lblfldNewLabelfield_22 = new Label();
		lblfldNewLabelfield_22.setText("(2015 벤처등, 공제율 100%．50%．30%,  공제한도 50%)");
		layoutContainer_22.setStyleAttribute("paddingLeft", "10px");
		layoutContainer_22.setStyleAttribute("marginTop", "5px");
		layoutContainer_22.setStyleAttribute("marginBottom", "5px");
		layoutContainer_22.add(lblfldNewLabelfield_22);
		layoutContainer21.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer layoutContainer9 = new LayoutContainer(); 
		layoutContainer9.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer10 = new LayoutContainer(); 
		FormLayout frmlytSch9 = new FormLayout();
		frmlytSch9.setLabelWidth(120);
		frmlytSch9.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10.setLayout(frmlytSch9);
		
		ivcpInvmUseAmtSum = new MSFNumberField();
		ivcpInvmUseAmtSum.setAllowDecimals(true); 
		ivcpInvmUseAmtSum.setPropertyEditorType(Long.class); 
		ivcpInvmUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		ivcpInvmUseAmtSum.setFieldLabel("출자·투자금액 합계");
		layoutContainer10.add(ivcpInvmUseAmtSum, new FormData("100%"));
		layoutContainer9.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer layoutContainer = new LayoutContainer();
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("textarea");
		fldstNewFieldset_1.setCollapsible(false);
		
		textarea = new TextArea();
		textarea.setName("textarea");
		textarea.setFieldLabel("textarea");
		textarea.setHeight(320);
		textarea.setWidth(570);
		textarea.setReadOnly(true);
		layoutContainer.add(textarea, new FormData("100%"));
		
		fldstNewFieldset_1.add(layoutContainer);
		
		fldstNewFieldset.add(layoutContainer2);
		fldstNewFieldset.add(layoutContainer4);
		fldstNewFieldset.add(layoutContainer6);
		fldstNewFieldset.add(layoutContainer8);
		fldstNewFieldset.add(layoutContainer12);
		fldstNewFieldset.add(layoutContainer21);
		fldstNewFieldset.add(layoutContainer9);
		cpYetaT33008.add(fldstNewFieldset);
		cpYetaT33008.add(fldstNewFieldset_1);
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			YetaT33008GridPanel.getTableDef().setTableColumnFilters(filters);
			YetaT33008GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			YetaT33008GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			YetaT33008GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			YetaT33008GridPanel.reload();
		
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
