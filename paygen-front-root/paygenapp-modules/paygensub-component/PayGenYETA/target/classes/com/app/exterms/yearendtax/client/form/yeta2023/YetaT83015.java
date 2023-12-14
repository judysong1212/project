/**
 * 비과세감면소득
 */
package com.app.exterms.yearendtax.client.form.yeta2023;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaT83015Service;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaT83015ServiceAsync;
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
//import com.app.exterms.yearendtax.client.form.defs.yeta2016.YetaT83015Def;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT83015   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYetaT83015; 
	  
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
	private MSFGridPanel YetaT83015GridPanel;
//	private YetaT83015Def YetaT83015Def = new YetaT83015Def("YetaT83015");   //TODO 일단 화면번호로 Def
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private YetaT83015ServiceAsync yetaT83015Service = YetaT83015Service.Util.getInstance();
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
 	
 	private NumberField scxpsPrsUseAmt; //소득공제 본인 공납금(대학원포함)
 	private NumberField scxpsPrsDdcTrgtAmt; //소득공제 본인 공제대상
 	private NumberField scxpsPrsDdcAmt; //소득공제 본인 세액공제
 	
 	private NumberField scxpsKidUseAmt; //부양가족(취학전) 납입금액
 	private NumberField scxpsKidDdcTrgtAmt; //부양가족(취학전) 공제대상
 	private NumberField scxpsKidDdcAmt; //부양가족(취학전) 세액공제
 	
 	private NumberField scxpsStdUseAmt; //부양가족(초중고) 납입금액
 	private NumberField scxpsStdDdcTrgtAmt; //부양가족(초중고) 공제대상
 	private NumberField scxpsStdDdcAmt; //부양가족(초중고) 세액공제
 	
 	private NumberField scxpsUndUseAmt; //부양가족(대학생) 납입금액
 	private NumberField scxpsUndDdcTrgtAmt; //부양가족(대학생) 공제대상
 	private NumberField scxpsUndDdcAmt; //부양가족(대학생) 세액공제
 	
 	private NumberField scxpsDsbrUseAmt; //장애인특수본인 납입금액
 	private NumberField scxpsDsbrDdcTrgtAmt; //장애인특수본인 공제대상
 	private NumberField scxpsDsbrDdcAmt; //장애인특수본인 세액공제
 	
 	private MSFNumberField scxpsUseAmtSum; //교육비 납입금액 합계
 	private MSFNumberField scxpsDdcTrgtAmtSum; //교육비 공제대상 합계
 	private MSFNumberField scxpsDdcAmtSum; //교육비 세액공제 합계
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산귀속년도 : edacRvyy */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : settGbcd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
	
	private TextArea textarea;
	
	Label txt0 = new Label();
	Label txt1 = new Label();
	Label txt2 = new Label();
	Label txt3 = new Label();
	Label txt4 = new Label();
	Label txt5 = new Label();
	Label txt6 = new Label();
	Label txt7 = new Label();
	Label txt8 = new Label();
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
		                
				yetaT83015Service.activityOnYetaT83015(listYe162510Dto, actionDatabase, new AsyncCallback<Long>(){
					
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
	  
	public YetaT83015(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
	 	cpYetaT83015 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
	 	createMsfGridForm();		//그리드필드
		   
		cpYetaT83015.setBodyBorder(false);
		cpYetaT83015.setBorders(false);
		cpYetaT83015.setHeaderVisible(false);
		cpYetaT83015.setSize("790px", "640px");
		   
		this.add(cpYetaT83015);
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
		cpYetaT83015.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYetaT83015.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYetaT83015.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYetaT83015.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYetaT83015.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYetaT83015.add(hanNm);
			
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
		        

		cpYetaT83015.setLayout(new FlowLayout());

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
//				YetaT83015GridPanel.getMsfGrid().clearData();
//				 
//				BaseModel bmData = YetaT83015GridPanel.getTableDef().getDefaultValues();  
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
//		        YetaT83015GridPanel.getMsfGrid().getGrid().stopEditing();      
//		        YetaT83015GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		        YetaT83015GridPanel.getMsfGrid().getGrid().startEditing(YetaT83015GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
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
//				Iterator<BaseModel> itBm = YetaT83015GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				List<Record> lsRec = new ArrayList<Record>();
//
//				
//				if((ActionDatabase.INSERT).equals(actionDatabase)) {
//					YetaT83015GridPanel.getMsfGrid().clearData();
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
//				setListRecord(YetaT83015GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
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
				
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
				
		cpYetaT83015.add(topYetaBtnBar);
		  	
		  	
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");
		fieldSet.setWidth(525);
		
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
		frmlytSch.setLabelWidth(40);
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
//		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol1.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol1.add(lcSchCol05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			

		fieldSet.add(lcSchCol, new FormData("100%"));
		fieldSet.add(lcSchCol1, new FormData("100%"));

		cpYetaT83015.add(fieldSet);
		
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
//		cpYetaT83015.add(topYetaBtnBar);
//		
//		YetaT83015GridPanel = new MSFGridPanel(YetaT83015Def, false, false, false, false, false);
//		YetaT83015GridPanel.setSize("790px", "420px");
//		YetaT83015GridPanel.setBorders(true);
//		YetaT83015GridPanel.setHeaderVisible(false);
		
		
//		/** --- 그리드 합계 부분  시작 --- **/
//		// TODO 현재 월세계, 비과세로 수정
//		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 비과세소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "비과세소득계");  
//		
//		YetaT83015GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
//		
//		AggregationRowConfig<BaseModel> payrSummaryRow1 = new AggregationRowConfig<BaseModel>();  
//		payrSummaryRow1.setCellStyle(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM,"summary_color");	 /** column 감면소득계 : mnthRnttyYrlyMnthSum */
//		payrSummaryRow1.setSummaryType(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, SummaryType.SUM);   
//		payrSummaryRow1.setSummaryFormat(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
//		payrSummaryRow1.setHtml(Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, "감면소득계");  
//		
//		YetaT83015GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow1);
//		/** --- 그리드 합계 부분  종료 --- **/
		
 //       cpYetaT83015.add(YetaT83015GridPanel);
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("교육비공제");
		fieldSet.setCollapsible(false);
		fieldSet.setWidth(525);
		
		FieldSet fieldSet1 = new FieldSet();
		fieldSet1.setHeadingHtml("소득자본인");
		fieldSet1.setCollapsible(false);
		fieldSet1.setWidth(525);
		
		FieldSet fieldSet2 = new FieldSet();
		fieldSet2.setHeadingHtml("가족교육비등록");
		fieldSet2.setCollapsible(false);
		fieldSet2.setWidth(525);
		
		FieldSet fieldSet3 = new FieldSet();
		fieldSet3.setHeadingHtml("장애인특수");
		fieldSet3.setCollapsible(false);
		fieldSet3.setWidth(525);
		
		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1.setLayout(frmlytSch);
		
		scxpsPrsUseAmt = new NumberField();
		scxpsPrsUseAmt.setAllowDecimals(true); 
		scxpsPrsUseAmt.setPropertyEditorType(Long.class); 
		scxpsPrsUseAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsPrsUseAmt.setFieldLabel("공납금(대학원포함)");
		layoutContainer1_1.add(scxpsPrsUseAmt, new FormData("100%"));
		layoutContainer1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(90);
		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_2.setLayout(frmlytSch1);
		
		scxpsPrsDdcTrgtAmt = new NumberField();
		scxpsPrsDdcTrgtAmt.setAllowDecimals(true); 
		scxpsPrsDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsPrsDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsPrsDdcTrgtAmt.setFieldLabel("공제대상");
		layoutContainer1_2.add(scxpsPrsDdcTrgtAmt, new FormData("100%"));
		layoutContainer1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer1_3 = new LayoutContainer();
		FormLayout frmlytSch2 = new FormLayout();
		frmlytSch2.setLabelWidth(90);
		frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_3.setLayout(frmlytSch2);
		
		scxpsPrsDdcAmt = new NumberField();
		scxpsPrsDdcAmt.setAllowDecimals(true); 
		scxpsPrsDdcAmt.setPropertyEditorType(Long.class); 
		scxpsPrsDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsPrsDdcAmt.setFieldLabel("세액공제");
		layoutContainer1_3.add(scxpsPrsDdcAmt, new FormData("100%"));
		layoutContainer1.add(layoutContainer1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		fieldSet1.add(layoutContainer1);
		
		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		FormLayout frmlytSch3 = new FormLayout();
		frmlytSch3.setLabelWidth(90);
		frmlytSch3.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_2.setLayout(frmlytSch3);
		
		scxpsKidUseAmt = new NumberField();
		scxpsKidUseAmt.setAllowDecimals(true); 
		scxpsKidUseAmt.setPropertyEditorType(Long.class); 
		scxpsKidUseAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsKidUseAmt.setFieldLabel("취학전납입금액");
		layoutContainer2_2.add(scxpsKidUseAmt, new FormData("100%"));
		layoutContainer2.add(layoutContainer2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer2_3 = new LayoutContainer();
		FormLayout frmlytSch4 = new FormLayout();
		frmlytSch4.setLabelWidth(90);
		frmlytSch4.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_3.setLayout(frmlytSch4);
		
		scxpsKidDdcTrgtAmt = new NumberField();
		scxpsKidDdcTrgtAmt.setAllowDecimals(true); 
		scxpsKidDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsKidDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsKidDdcTrgtAmt.setFieldLabel("취학전공제대상");
		layoutContainer2_3.add(scxpsKidDdcTrgtAmt, new FormData("100%"));
		layoutContainer2.add(layoutContainer2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer2_4 = new LayoutContainer();
		FormLayout frmlytSch5 = new FormLayout();
		frmlytSch5.setLabelWidth(90);
		frmlytSch5.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_4.setLayout(frmlytSch5);
		
		scxpsKidDdcAmt = new NumberField();
		scxpsKidDdcAmt.setAllowDecimals(true); 
		scxpsKidDdcAmt.setPropertyEditorType(Long.class); 
		scxpsKidDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsKidDdcAmt.setFieldLabel("취학전세액공제");
		layoutContainer2_4.add(scxpsKidDdcAmt, new FormData("100%"));
		layoutContainer2.add(layoutContainer2_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		fieldSet2.add(layoutContainer2);
		
		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer3_2 = new LayoutContainer();
		FormLayout frmlytSch6 = new FormLayout();
		frmlytSch6.setLabelWidth(90);
		frmlytSch6.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_2.setLayout(frmlytSch6);
		
		scxpsStdUseAmt = new NumberField();
		scxpsStdUseAmt.setAllowDecimals(true); 
		scxpsStdUseAmt.setPropertyEditorType(Long.class); 
		scxpsStdUseAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsStdUseAmt.setFieldLabel("초중고납입금액");
		layoutContainer3_2.add(scxpsStdUseAmt, new FormData("100%"));
		layoutContainer3.add(layoutContainer3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer3_3 = new LayoutContainer();
		FormLayout frmlytSch7 = new FormLayout();
		frmlytSch7.setLabelWidth(90);
		frmlytSch7.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_3.setLayout(frmlytSch7);
		
		scxpsStdDdcTrgtAmt = new NumberField();
		scxpsStdDdcTrgtAmt.setAllowDecimals(true); 
		scxpsStdDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsStdDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsStdDdcTrgtAmt.setFieldLabel("초중고공제대상");
		layoutContainer3_3.add(scxpsStdDdcTrgtAmt, new FormData("100%"));
		layoutContainer3.add(layoutContainer3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer3_4 = new LayoutContainer();
		FormLayout frmlytSch8 = new FormLayout();
		frmlytSch8.setLabelWidth(90);
		frmlytSch8.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3_4.setLayout(frmlytSch8);
		
		scxpsStdDdcAmt = new NumberField();
		scxpsStdDdcAmt.setAllowDecimals(true); 
		scxpsStdDdcAmt.setPropertyEditorType(Long.class); 
		scxpsStdDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsStdDdcAmt.setFieldLabel("초중고세액공제");
		layoutContainer3_4.add(scxpsStdDdcAmt, new FormData("100%"));
		layoutContainer3.add(layoutContainer3_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		fieldSet2.add(layoutContainer3);
		
		LayoutContainer layoutContainer4 = new LayoutContainer();
		layoutContainer4.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer4_2 = new LayoutContainer();
		FormLayout frmlytSch9 = new FormLayout();
		frmlytSch9.setLabelWidth(90);
		frmlytSch9.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_2.setLayout(frmlytSch9);
		
		scxpsUndUseAmt = new NumberField();
		scxpsUndUseAmt.setAllowDecimals(true); 
		scxpsUndUseAmt.setPropertyEditorType(Long.class); 
		scxpsUndUseAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsUndUseAmt.setFieldLabel("대학생납입금액");
		layoutContainer4_2.add(scxpsUndUseAmt, new FormData("100%"));
		layoutContainer4.add(layoutContainer4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer4_3 = new LayoutContainer();
		FormLayout frmlytSch10 = new FormLayout();
		frmlytSch10.setLabelWidth(90);
		frmlytSch10.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_3.setLayout(frmlytSch10);
		
		scxpsUndDdcTrgtAmt = new NumberField();
		scxpsUndDdcTrgtAmt.setAllowDecimals(true); 
		scxpsUndDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsUndDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsUndDdcTrgtAmt.setFieldLabel("대학생공제대상");
		layoutContainer4_3.add(scxpsUndDdcTrgtAmt, new FormData("100%"));
		layoutContainer4.add(layoutContainer4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer4_4 = new LayoutContainer();
		FormLayout frmlytSch11 = new FormLayout();
		frmlytSch11.setLabelWidth(90);
		frmlytSch11.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_4.setLayout(frmlytSch11);
		
		scxpsUndDdcAmt = new NumberField();
		scxpsUndDdcAmt.setAllowDecimals(true); 
		scxpsUndDdcAmt.setPropertyEditorType(Long.class); 
		scxpsUndDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsUndDdcAmt.setFieldLabel("대학생세액공제");
		layoutContainer4_4.add(scxpsUndDdcAmt, new FormData("100%"));
		layoutContainer4.add(layoutContainer4_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		fieldSet2.add(layoutContainer4);
		
		LayoutContainer layoutContainer5 = new LayoutContainer();
		layoutContainer5.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer5_2 = new LayoutContainer();
		FormLayout frmlytSch12 = new FormLayout();
		frmlytSch12.setLabelWidth(90);
		frmlytSch12.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_2.setLayout(frmlytSch12);
		
		scxpsDsbrUseAmt = new NumberField();
		scxpsDsbrUseAmt.setAllowDecimals(true); 
		scxpsDsbrUseAmt.setPropertyEditorType(Long.class); 
		scxpsDsbrUseAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsDsbrUseAmt.setFieldLabel("납입금액");
		layoutContainer5_2.add(scxpsDsbrUseAmt, new FormData("100%"));
		layoutContainer5.add(layoutContainer5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer5_3 = new LayoutContainer();
		FormLayout frmlytSch13 = new FormLayout();
		frmlytSch13.setLabelWidth(90);
		frmlytSch13.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_3.setLayout(frmlytSch13);
		
		scxpsDsbrDdcTrgtAmt = new NumberField();
		scxpsDsbrDdcTrgtAmt.setAllowDecimals(true); 
		scxpsDsbrDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsDsbrDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsDsbrDdcTrgtAmt.setFieldLabel("공제대상");
		layoutContainer5_3.add(scxpsDsbrDdcTrgtAmt, new FormData("100%"));
		layoutContainer5.add(layoutContainer5_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer5_4 = new LayoutContainer();
		FormLayout frmlytSch14 = new FormLayout();
		frmlytSch14.setLabelWidth(90);
		frmlytSch14.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_4.setLayout(frmlytSch14);
		
		scxpsDsbrDdcAmt = new NumberField();
		scxpsDsbrDdcAmt.setAllowDecimals(true); 
		scxpsDsbrDdcAmt.setPropertyEditorType(Long.class); 
		scxpsDsbrDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		scxpsDsbrDdcAmt.setFieldLabel("세액공제");
		layoutContainer5_4.add(scxpsDsbrDdcAmt, new FormData("100%"));
		layoutContainer5.add(layoutContainer5_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		fieldSet3.add(layoutContainer5);
		
		
		LayoutContainer layoutContainer6 = new LayoutContainer();
		layoutContainer6.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer6_2 = new LayoutContainer();
		FormLayout frmlytSch18 = new FormLayout();
		frmlytSch18.setLabelWidth(100);
		frmlytSch18.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6_2.setLayout(frmlytSch18);
		
		scxpsUseAmtSum = new MSFNumberField();
		scxpsUseAmtSum.setAllowDecimals(true); 
		scxpsUseAmtSum.setPropertyEditorType(Long.class); 
		scxpsUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		scxpsUseAmtSum.setFieldLabel("납입금액합계");
		layoutContainer6_2.add(scxpsUseAmtSum, new FormData("100%"));
		layoutContainer6_2.setStyleAttribute("marginTop", "7px");
		layoutContainer6.add(layoutContainer6_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer6_3 = new LayoutContainer();
		FormLayout frmlytSch19 = new FormLayout();
		frmlytSch19.setLabelWidth(100);
		frmlytSch19.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6_3.setLayout(frmlytSch19);
		
		scxpsDdcTrgtAmtSum = new MSFNumberField();
		scxpsDdcTrgtAmtSum.setAllowDecimals(true); 
		scxpsDdcTrgtAmtSum.setPropertyEditorType(Long.class); 
		scxpsDdcTrgtAmtSum.setFormat(NumberFormat.getDecimalFormat());
		scxpsDdcTrgtAmtSum.setFieldLabel("공제대상금액합계");
		layoutContainer6_3.add(scxpsDdcTrgtAmtSum, new FormData("100%"));
		layoutContainer6_3.setStyleAttribute("marginTop", "7px");
		layoutContainer6.add(layoutContainer6_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		LayoutContainer layoutContainer6_4 = new LayoutContainer();
		FormLayout frmlytSch20 = new FormLayout();
		frmlytSch20.setLabelWidth(100);
		frmlytSch20.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6_4.setLayout(frmlytSch20);
		
		scxpsDdcAmtSum = new MSFNumberField();
		scxpsDdcAmtSum.setAllowDecimals(true); 
		scxpsDdcAmtSum.setPropertyEditorType(Long.class); 
		scxpsDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		scxpsDdcAmtSum.setFieldLabel("세액공제금액합계");
		layoutContainer6_4.add(scxpsDdcAmtSum, new FormData("100%"));
		layoutContainer6_4.setStyleAttribute("marginTop", "7px");
		layoutContainer6.add(layoutContainer6_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		layoutContainer6.setWidth(525);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("textarea");
		fldstNewFieldset_1.setCollapsible(false);
		
		textarea = new TextArea();
		textarea.setName("textarea");
		textarea.setFieldLabel("textarea");
		textarea.setHeight(280);
		textarea.setWidth(520);
		textarea.setReadOnly(true);
		layoutContainer.add(textarea, new FormData("100%"));
		
		fldstNewFieldset_1.add(layoutContainer);
		
		fieldSet.add(fieldSet1);
		fieldSet.add(fieldSet2);
		fieldSet.add(fieldSet3);
		cpYetaT83015.add(fieldSet);
		cpYetaT83015.add(layoutContainer6);
		cpYetaT83015.add(fldstNewFieldset_1);
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			YetaT83015GridPanel.getTableDef().setTableColumnFilters(filters);
			YetaT83015GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			YetaT83015GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			YetaT83015GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			YetaT83015GridPanel.reload();
		
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

