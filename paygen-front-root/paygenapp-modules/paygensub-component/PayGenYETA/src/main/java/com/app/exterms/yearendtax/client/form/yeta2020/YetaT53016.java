/**
 * 기부금
 */
package com.app.exterms.yearendtax.client.form.yeta2020;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2020.YetaT53016Service;
import com.app.exterms.yearendtax.client.service.yeta2020.YetaT53016ServiceAsync;
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
//import com.app.exterms.yearendtax.client.form.defs.yeta2016.YetaT53016Def;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT53016   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYetaT53016; 
	  
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
	private MSFGridPanel YetaT53016GridPanel;
//	private YetaT53016Def YetaT53016Def = new YetaT53016Def("YetaT53016");   //TODO 일단 화면번호로 Def
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private YetaT53016ServiceAsync yetaT53016Service = YetaT53016Service.Util.getInstance();
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
 	private TextArea textarea; //textarea 임시 선언
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산귀속년도 : edacRvyy */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : settGbcd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
	
	Label txt1 = new Label();
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

	//--기부금
    private NumberField taxdPltc;	//우리사주조합기부금
    		
    		
    private NumberField spciFbam;	//정치기부금 이월금액	
    private NumberField spciFbtg;	//정치기부금 대상금액	
    		
    private NumberField spciExam;	//법정기부금 이월금액
    private NumberField spciExtg;	//법정기부금 대상금액	
    		
    private NumberField spciHfam;	//특례기부금 이월금액
    private NumberField spciHftg;	//특례기부금 대상금액	
    		
    private NumberField spciNamt;	//지정기부금 이월금액	
    private NumberField spciNatg;	//지정기부금 대상금액	
    		
    private NumberField spciYamt;	//종교기부금 이월금액
    private NumberField spciYatg;	//종교기부금 대상금액	
    		
    private MSFNumberField spciDgam;	//기부금합계금액
    private MSFNumberField spciDgamA;	//기부금이월합계금액
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
		                
				yetaT53016Service.activityOnYetaT53016(listYe162510Dto, actionDatabase, new AsyncCallback<Long>(){
					
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
	  
	public YetaT53016(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
	 	cpYetaT53016 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
	 	createMsfGridForm();		//그리드필드
		   
		cpYetaT53016.setBodyBorder(false);
		cpYetaT53016.setBorders(false);
		cpYetaT53016.setHeaderVisible(false);
		cpYetaT53016.setSize("790px", "640px");
		   
		this.add(cpYetaT53016);
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
		cpYetaT53016.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYetaT53016.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYetaT53016.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYetaT53016.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYetaT53016.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYetaT53016.add(hanNm);
			
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
		        

		cpYetaT53016.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);
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
//				YetaT53016GridPanel.getMsfGrid().clearData();
//				 
//				BaseModel bmData = YetaT53016GridPanel.getTableDef().getDefaultValues();  
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
//		        YetaT53016GridPanel.getMsfGrid().getGrid().stopEditing();      
//		        YetaT53016GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		        YetaT53016GridPanel.getMsfGrid().getGrid().startEditing(YetaT53016GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
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
//				Iterator<BaseModel> itBm = YetaT53016GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				List<Record> lsRec = new ArrayList<Record>();
//
//				
//				if((ActionDatabase.INSERT).equals(actionDatabase)) {
//					YetaT53016GridPanel.getMsfGrid().clearData();
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
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(YetaT53016GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
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
//				
////			btnYetaClose  = new Button("닫기");
////			topYetaBtnBar.add(btnYetaClose);
//				
		cpYetaT53016.add(topYetaBtnBar);
		  	
		  	
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

		cpYetaT53016.add(fieldSet);
		
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
//		cpYetaT53016.add(topYetaBtnBar);
		
//		YetaT53016GridPanel = new MSFGridPanel(YetaT53016Def, false, false, false, false, false);
//		YetaT53016GridPanel.setSize("790px", "420px");
//		YetaT53016GridPanel.setBorders(true);
//		YetaT53016GridPanel.setHeaderVisible(false);
		
		
//		/** --- 그리드 합계 부분  시작 --- **/
//		// TODO 현재 월세계, 비과세로 수정
//		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 비과세소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "비과세소득계");  
//		
//		YetaT53016GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
//		
//		AggregationRowConfig<BaseModel> payrSummaryRow1 = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow1.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 감면소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow1.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow1.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow1.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "감면소득계");  
//		
//		YetaT53016GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow1);
//		/** --- 그리드 합계 부분  종료 --- **/
		
//        cpYetaT53016.add(YetaT53016GridPanel);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("정치자금 기부금 10만원 세액공제");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "5px");
		fldstNewFieldset_1.setWidth(575);
		
		
		LayoutContainer layoutContainer_gibu01 = new LayoutContainer();
		
		// 정치자금(10만원이하)
		LayoutContainer layoutContainer_giLeftbu01 = new LayoutContainer();
		
		FormLayout frmlytSchLeft01 = new FormLayout();
		frmlytSchLeft01.setLabelWidth(180);
		frmlytSchLeft01.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu01.setLayout(frmlytSchLeft01);
		layoutContainer_giLeftbu01.setBorders(false);

		//세액공제_기부정치자금금액
		taxdPltc = new NumberField();
		
		taxdPltc.setAllowDecimals(true); 
		taxdPltc.setPropertyEditorType(Long.class); 
		taxdPltc.setFormat(NumberFormat.getDecimalFormat());
		
		taxdPltc.setFieldLabel("정치자금(한도 10만원)");
		layoutContainer_giLeftbu01.add(taxdPltc, new FormData("80%"));
		layoutContainer_gibu01.add(layoutContainer_giLeftbu01, new FormData("100%"));
		
		fldstNewFieldset_1.add(layoutContainer_gibu01);
		layoutContainer.add(fldstNewFieldset_1);
		cpYetaT53016.add(layoutContainer);
		
		
		
		LayoutContainer layoutContainer1 = new LayoutContainer();
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setHeadingHtml("기부금 특별세액공제");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "5px");
		fldstNewFieldset_2.setWidth(575);
		
		LayoutContainer layoutContainer_gibu03 = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_giLeftbu03 = new LayoutContainer();
		FormLayout frmlytSchLeft03 = new FormLayout();
		frmlytSchLeft03.setLabelWidth(180);
		frmlytSchLeft03.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu03.setLayout(frmlytSchLeft03);
		layoutContainer_giLeftbu03.setBorders(false);

		spciFbam = new NumberField();
		spciFbam.setAllowDecimals(true); 
		spciFbam.setPropertyEditorType(Long.class); 
		spciFbam.setFormat(NumberFormat.getDecimalFormat());
		spciFbam.setFieldLabel("정치기부금 (한도 전액)");
		layoutContainer_giLeftbu03.add(spciFbam, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_giLeftbu03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		LayoutContainer layoutContainer_gibuCenter03 = new LayoutContainer();
		layoutContainer_gibuCenter03.setBorders(false);
		FormLayout frmlytSchCenter03 = new FormLayout();
		frmlytSchCenter03.setLabelWidth(0);
		layoutContainer_gibuCenter03.setLayout(frmlytSchCenter03);

		//특별공제-정치기부금 당해금액
		spciFbtg = new NumberField();
		spciFbtg.setAllowDecimals(true); 
		spciFbtg.setPropertyEditorType(Long.class); 
		spciFbtg.setFormat(NumberFormat.getDecimalFormat());
		spciFbtg.setLabelSeparator("");
		layoutContainer_gibuCenter03.add(spciFbtg, new FormData("56%"));
		layoutContainer_gibu03.add(layoutContainer_gibuCenter03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		LayoutContainer layoutContainer_gibu04 = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_giLeftbu04 = new LayoutContainer();
		FormLayout frmlytSchLeft04 = new FormLayout();
		frmlytSchLeft04.setLabelWidth(180);
		frmlytSchLeft04.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu04.setLayout(frmlytSchLeft04);
		layoutContainer_giLeftbu04.setBorders(false);
		//법정기부금 이월금액
		spciExam = new NumberField();
		spciExam.setAllowDecimals(true); 
		spciExam.setPropertyEditorType(Long.class); 
		spciExam.setFormat(NumberFormat.getDecimalFormat());
		spciExam.setFieldLabel("법정기부금 (한도 전액)");
		layoutContainer_giLeftbu04.add(spciExam, new FormData("100%"));
		layoutContainer_gibu04.add(layoutContainer_giLeftbu04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		LayoutContainer layoutContainer_gibuCenter04 = new LayoutContainer();
		layoutContainer_gibuCenter04.setBorders(false);
		FormLayout frmlytSchCenter04 = new FormLayout();
		frmlytSchCenter04.setLabelWidth(0);
		layoutContainer_gibuCenter04.setLayout(frmlytSchCenter04);

		//법정기부금 당해금액
		spciExtg = new NumberField();
		spciExtg.setAllowDecimals(true); 
		spciExtg.setPropertyEditorType(Long.class); 
		spciExtg.setFormat(NumberFormat.getDecimalFormat());
		spciExtg.setLabelSeparator("");
		layoutContainer_gibuCenter04.add(spciExtg, new FormData("56%"));
		layoutContainer_gibu04.add(layoutContainer_gibuCenter04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		LayoutContainer layoutContainer_gibu05 = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_giLeftbu05 = new LayoutContainer();
		FormLayout frmlytSchLeft05 = new FormLayout();
		frmlytSchLeft05.setLabelWidth(180);
		frmlytSchLeft05.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu05.setLayout(frmlytSchLeft05);
		layoutContainer_giLeftbu05.setBorders(false);
		//법정기부금 이월금액
		spciHfam = new NumberField();
		spciHfam.setAllowDecimals(true); 
		spciHfam.setPropertyEditorType(Long.class); 
		spciHfam.setFormat(NumberFormat.getDecimalFormat());
		spciHfam.setFieldLabel("특례기부금 (한도 50%)");
		layoutContainer_giLeftbu05.add(spciHfam, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_giLeftbu05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		LayoutContainer layoutContainer_gibuCenter05 = new LayoutContainer();
		layoutContainer_gibuCenter05.setBorders(false);
		FormLayout frmlytSchCenter05 = new FormLayout();
		frmlytSchCenter05.setLabelWidth(0);
		layoutContainer_gibuCenter05.setLayout(frmlytSchCenter05);

		//법정기부금 당해금액
		spciHftg = new NumberField();
		spciHftg.setAllowDecimals(true); 
		spciHftg.setPropertyEditorType(Long.class); 
		spciHftg.setFormat(NumberFormat.getDecimalFormat());
		spciHftg.setLabelSeparator("");
		layoutContainer_gibuCenter05.add(spciHftg, new FormData("56%"));
		layoutContainer_gibu05.add(layoutContainer_gibuCenter05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		LayoutContainer layoutContainer_gibu06 = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_giLeftbu06 = new LayoutContainer();
		FormLayout frmlytSchLeft06 = new FormLayout();
		frmlytSchLeft06.setLabelWidth(180);
		frmlytSchLeft06.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu06.setLayout(frmlytSchLeft06);
		layoutContainer_giLeftbu06.setBorders(false);
		//지정기부금 이월금액
		spciNamt = new NumberField();
		spciNamt.setAllowDecimals(true); 
		spciNamt.setPropertyEditorType(Long.class); 
		spciNamt.setFormat(NumberFormat.getDecimalFormat());
		spciNamt.setFieldLabel("지정기부금 (한도 30%)");
		layoutContainer_giLeftbu06.add(spciNamt, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_giLeftbu06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		LayoutContainer layoutContainer_gibuCenter06 = new LayoutContainer();
		layoutContainer_gibuCenter06.setBorders(false);
		FormLayout frmlytSchCenter06 = new FormLayout();
		frmlytSchCenter06.setLabelWidth(0);
		layoutContainer_gibuCenter06.setLayout(frmlytSchCenter06);

		//지정기부금 당해금액
		spciNatg = new NumberField();
		spciNatg.setAllowDecimals(true); 
		spciNatg.setPropertyEditorType(Long.class); 
		spciNatg.setFormat(NumberFormat.getDecimalFormat());
		spciNatg.setLabelSeparator("");
		layoutContainer_gibuCenter06.add(spciNatg, new FormData("56%"));
		layoutContainer_gibu06.add(layoutContainer_gibuCenter06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		
		
		LayoutContainer layoutContainer_gibu07 = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_giLeftbu07 = new LayoutContainer();
		FormLayout frmlytSchLeft07 = new FormLayout();
		frmlytSchLeft07.setLabelWidth(180);
		frmlytSchLeft07.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu07.setLayout(frmlytSchLeft07);
		layoutContainer_giLeftbu07.setBorders(false);
		//종교기부금 이월금액
		spciYamt = new NumberField();
		spciYamt.setAllowDecimals(true); 
		spciYamt.setPropertyEditorType(Long.class); 
		spciYamt.setFormat(NumberFormat.getDecimalFormat());
		spciYamt.setFieldLabel("종교기부금 (한도 10%)");
		layoutContainer_giLeftbu07.add(spciYamt, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_giLeftbu07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		LayoutContainer layoutContainer_gibuCenter07 = new LayoutContainer();
		layoutContainer_gibuCenter07.setBorders(false);
		FormLayout frmlytSchCenter07 = new FormLayout();
		frmlytSchCenter07.setLabelWidth(0);
		layoutContainer_gibuCenter07.setLayout(frmlytSchCenter07);

		//종교기부금 당해금액
		spciYatg = new NumberField();
		spciYatg.setAllowDecimals(true); 
		spciYatg.setPropertyEditorType(Long.class); 
		spciYatg.setFormat(NumberFormat.getDecimalFormat());
		spciYatg.setLabelSeparator("");
		layoutContainer_gibuCenter07.add(spciYatg, new FormData("56%"));
		layoutContainer_gibu07.add(layoutContainer_gibuCenter07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		LayoutContainer layoutContainer16 = new LayoutContainer();
		txt1.setText("*특별 기부금은 이월금액 -> 당해금액 순으로 표시됩니다.");
		layoutContainer16.setStyleAttribute("paddingLeft", "10px");
		layoutContainer16.setStyleAttribute("marginTop", "5px");
		layoutContainer16.setStyleAttribute("marginBottom", "5px");
		layoutContainer16.add(txt1, new FormData("100%"));
		
		fldstNewFieldset_2.add(layoutContainer_gibu03);
		fldstNewFieldset_2.add(layoutContainer_gibu04);
		fldstNewFieldset_2.add(layoutContainer_gibu05);
		fldstNewFieldset_2.add(layoutContainer_gibu06);
		fldstNewFieldset_2.add(layoutContainer_gibu07);
		fldstNewFieldset_2.add(layoutContainer16);
		layoutContainer1.add(fldstNewFieldset_2);
		cpYetaT53016.add(layoutContainer1);
		
		
		LayoutContainer layoutContainer2 = new LayoutContainer();
		FieldSet fldstNewFieldset_3 = new FieldSet();
		fldstNewFieldset_3.setHeadingHtml("우리사주조합 기부금");
		fldstNewFieldset_3.setCollapsible(false);
		fldstNewFieldset_3.setStyleAttribute("marginTop", "5px");
		fldstNewFieldset_3.setWidth(575);
		
		LayoutContainer layoutContainer_gibu02 = new LayoutContainer();
		
		// 정치자금(10만원이하)
		LayoutContainer layoutContainer_giLeftbu02 = new LayoutContainer();
		
		FormLayout frmlytSchLeft02 = new FormLayout();
		frmlytSchLeft02.setLabelWidth(180);
		frmlytSchLeft02.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu02.setLayout(frmlytSchLeft02);
		layoutContainer_giLeftbu02.setBorders(false);

		//세액공제_기부정치자금금액
		taxdPltc = new NumberField();
		
		taxdPltc.setAllowDecimals(true); 
		taxdPltc.setPropertyEditorType(Long.class); 
		taxdPltc.setFormat(NumberFormat.getDecimalFormat());
		
		taxdPltc.setFieldLabel("우리사주조합기부금 (한도 30%)");
		layoutContainer_giLeftbu02.add(taxdPltc, new FormData("80%"));
		layoutContainer_gibu02.add(layoutContainer_giLeftbu02, new FormData("100%"));
		
		fldstNewFieldset_3.add(layoutContainer_giLeftbu02);
		layoutContainer2.add(fldstNewFieldset_3);
		cpYetaT53016.add(layoutContainer2);
		
		
		LayoutContainer layoutContainer_gibu08 = new LayoutContainer(new ColumnLayout());
		layoutContainer_gibu08.setStyleAttribute("marginTop", "5px");
		layoutContainer_gibu08.setWidth(575);
		LayoutContainer layoutContainer_giLeftbu08 = new LayoutContainer();
		FormLayout frmlytSchLeft08 = new FormLayout();
		frmlytSchLeft08.setLabelWidth(100);
		frmlytSchLeft08.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu08.setLayout(frmlytSchLeft08);
		layoutContainer_giLeftbu08.setBorders(false);

		spciDgam = new MSFNumberField();
		spciDgam.setAllowDecimals(true); 
		spciDgam.setPropertyEditorType(Long.class); 
		spciDgam.setFormat(NumberFormat.getDecimalFormat());
		spciDgam.setFieldLabel("기부금액계");
		layoutContainer_giLeftbu08.add(spciDgam, new FormData("80%"));
		layoutContainer_giLeftbu08.setStyleAttribute("marginTop", "7px");
		layoutContainer_gibu08.add(layoutContainer_giLeftbu08, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter08 = new LayoutContainer();
		layoutContainer_gibuCenter08.setBorders(false);
		FormLayout frmlytSchCenter08 = new FormLayout();
		frmlytSchCenter08.setLabelWidth(100);
		layoutContainer_gibuCenter08.setLayout(frmlytSchCenter08);

		spciDgamA = new MSFNumberField();
		spciDgamA.setAllowDecimals(true); 
		spciDgamA.setPropertyEditorType(Long.class); 
		spciDgamA.setFormat(NumberFormat.getDecimalFormat());
		spciDgamA.setFieldLabel("기부금(이월분)계");
		layoutContainer_gibuCenter08.add(spciDgamA, new FormData("80%"));
		layoutContainer_gibuCenter08.setStyleAttribute("marginTop", "7px");
		layoutContainer_gibu08.add(layoutContainer_gibuCenter08, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		cpYetaT53016.add(layoutContainer_gibu08);
		
		LayoutContainer layoutContainer3 = new LayoutContainer();
		
		FieldSet fldstNewFieldset_4 = new FieldSet();
		fldstNewFieldset_4.setHeadingHtml("textarea");
		fldstNewFieldset_4.setCollapsible(false);
		
		textarea = new TextArea();
		textarea.setName("textarea");
		textarea.setFieldLabel("textarea");
		textarea.setHeight(210);
		textarea.setWidth(570);
		textarea.setReadOnly(true);
		layoutContainer3.add(textarea, new FormData("100%"));
		fldstNewFieldset_4.add(layoutContainer3);
		
		cpYetaT53016.add(fldstNewFieldset_4);
		
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			YetaT53016GridPanel.getTableDef().setTableColumnFilters(filters);
			YetaT53016GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			YetaT53016GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			YetaT53016GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			YetaT53016GridPanel.reload();
		
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
