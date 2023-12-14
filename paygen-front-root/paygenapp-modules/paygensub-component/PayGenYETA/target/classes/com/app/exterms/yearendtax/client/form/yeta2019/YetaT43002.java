/**
 * 연금보험료
 */
package com.app.exterms.yearendtax.client.form.yeta2019;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaT43002Service;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaT43002ServiceAsync;
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
//import com.app.exterms.yearendtax.client.form.defs.yeta2016.ㄹ;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT43002   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYetaT43002; 
	  
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
	private MSFGridPanel YetaT43002GridPanel;
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private YetaT43002ServiceAsync yetaT43002Service = YetaT43002Service.Util.getInstance();
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
 	private NumberField natPennPrmmSum; //국민연금 근무지금액 변수명 다시 해줘야 함.
 	private NumberField natPennDducSum; //국민연금 근무지공제액 변수명 다시 해줘야 함.
 	private NumberField natPennAraPrmmSum; //국민연금 근무지(지역)금액 변수명 다시 해줘야 함.
// 	private NumberField srhSum22; //국민연금 주(현)근무지공제액 변수명 다시 해줘야 함.
 	
// 	private NumberField srhSum3; //국민연금(지역) 종(전)근무지금액 변수명 다시 해줘야 함.
// 	private NumberField srhSum33; //국민연금(지역) 종(전)근무지공제액 변수명 다시 해줘야 함.
// 	private NumberField srhSum4; //국민연금(지역) 주(현)근무지금액 변수명 다시 해줘야 함.
// 	private NumberField srhSum44; //국민연금(지역) 주(현)근무지공제액 변수명 다시 해줘야 함.
 	
 	private NumberField puoferAnty; //공무원연금 종(전)근무지액 변수명 다시 해줘야 함.
 	private NumberField puoferAntyDducSum; //공무원연금 종(전)근무지공제액 변수명 다시 해줘야 함.
// 	private NumberField srhSum6; //공무원연금 주(현)근무지액 변수명 다시 해줘야 함.
// 	private NumberField srhSum66; //공무원연금 주(현)근무지공제액 변수명 다시 해줘야 함.
 	
 	private NumberField mltymAnty; //군인연금 종(전)근무지액 변수명 다시 해줘야 함.
 	private NumberField mltymAntyDducSum; //군인연금 종(전)근무지공제액 변수명 다시 해줘야 함.
// 	private NumberField srhSum8; //군인연금 주(현)근무지액 변수명 다시 해줘야 함.
// 	private NumberField srhSum88; //군인연금 주(현)근무지공제액 변수명 다시 해줘야 함.
 	
	private NumberField prtafirSchlFalymmAnty; //사립학교교직원연금 종(전)근무지액 변수명 다시 해줘야 함.
 	private NumberField prtafirSchlDducSum; //사립학교교직원연금 종(전)근무지공제액 변수명 다시 해줘야 함.
// 	private NumberField srhSum10; //사립학교교직원연금 주(현)근무지액 변수명 다시 해줘야 함.
// 	private NumberField srhSum1010; //사립학교교직원연금 주(현)근무지공제액 변수명 다시 해줘야 함.
 	
	private NumberField spildtnPstoficAnty; //별정우체국연금 종(전)근무지액 변수명 다시 해줘야 함.
 	private NumberField spildtnPstoficDducSum; //별정우체국연금 종(전)근무지공제액 변수명 다시 해줘야 함.
// 	private NumberField srhSum13; //별정우체국연금 주(현)근무지액 변수명 다시 해줘야 함.
// 	private NumberField srhSum1313; //별정우체국연금 주(현)근무지공제액 변수명 다시 해줘야 함.
 	
 	private MSFNumberField npHthrWaInfeeAmt; //국민연금액합계_종전근무지 변수명 다시 해줘야 함.
 	private MSFNumberField npHthrWaInfeeDdcAmt; //국민연금공제액합계_종전근무지 변수명 다시 해줘야 함.
 	private MSFNumberField npHthrMcurWkarInfeeAmt; //국민연금액합계_주현근무지 변수명 다시 해줘야 함.
 	private MSFNumberField npHthrMcurWkarDdcAmt; //국민연금공제액합계_주현근무지변수명 다시 해줘야 함
 	
 	private MSFNumberField hthrPblcPnsnInfeeAmt; //국민연금외공적연금액합계_종전근무지 변수명 다시 해줘야 함.
 	private MSFNumberField hthrPblcPnsnInfeeDdcAmt; //국민연금외공적연금공제액합계_종(전)근무지액 변수명 다시 해줘야 함.
 	private MSFNumberField mcurPblcPnsnInfeeAmt; //국민연금외공적연금액합계_주현근무지 변수명 다시 해줘야 함.
 	private MSFNumberField mcurPblcPnsnInfeeDdcAmt; //국민연금외공적연금공제액합계_주현근무지 변수명 다시 해줘야 함.
 	
 	private TextArea textarea; //textarea 임시 선언
 	
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
		                
				yetaT43002Service.activityOnYetaT43002(listYe162510Dto, actionDatabase, new AsyncCallback<Long>(){
					
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
	  
	public YetaT43002(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
	 	cpYetaT43002 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
	 	createMsfGridForm();		//그리드필드
		   
		cpYetaT43002.setBodyBorder(false);
		cpYetaT43002.setBorders(false);
		cpYetaT43002.setHeaderVisible(false);
		cpYetaT43002.setSize("790px", "640px");
		   
		this.add(cpYetaT43002);
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
		cpYetaT43002.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYetaT43002.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYetaT43002.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYetaT43002.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYetaT43002.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYetaT43002.add(hanNm);
			
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
		        

		cpYetaT43002.setLayout(new FlowLayout());

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
//				YetaT43002GridPanel.getMsfGrid().clearData();
//				 
//				BaseModel bmData = YetaT43002GridPanel.getTableDef().getDefaultValues();  
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
//		        YetaT43002GridPanel.getMsfGrid().getGrid().stopEditing();      
//		        YetaT43002GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		        YetaT43002GridPanel.getMsfGrid().getGrid().startEditing(YetaT43002GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
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
//				Iterator<BaseModel> itBm = YetaT43002GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				List<Record> lsRec = new ArrayList<Record>();
//
//				
//				if((ActionDatabase.INSERT).equals(actionDatabase)) {
//					YetaT43002GridPanel.getMsfGrid().clearData();
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
				setListRecord(YetaT43002GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
				doAction(actionDatabase);

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});

		topYetaBtnBar.add(btnYetaSave);
		topYetaBtnBar.setWidth(675);		
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
				
		cpYetaT43002.add(topYetaBtnBar);
		  	
		  	
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");
		fieldSet.setWidth(675);

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
		frmlytSch.setLabelWidth(40);
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
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
		lcSchCol.add(lcSchCol05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));
			

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYetaT43002.add(fieldSet);
		
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
		
//		YetaT43002GridPanel = new MSFGridPanel(YetaT43002Def, false, false, false, false, false);
//		YetaT43002GridPanel.setSize("790px", "420px");
//		YetaT43002GridPanel.setBorders(true);
//		YetaT43002GridPanel.setHeaderVisible(false);
//		
//      cpYetaT43002.add(YetaT43002GridPanel);

		FieldSet fldstNewFieldset10 = new FieldSet();
		fldstNewFieldset10.setHeadingHtml("연금보험료");
		fldstNewFieldset10.setWidth(675);
		fldstNewFieldset10.setCollapsible(false);
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("국민연금보험료");
		fldstNewFieldset.setWidth(675);
		fldstNewFieldset.setCollapsible(false);
		
		FieldSet fldstNewFieldset1 = new FieldSet();
		fldstNewFieldset1.setHeadingHtml("국민연금보험료외의 공적연금보험료");
		fldstNewFieldset1.setCollapsible(false);
		fldstNewFieldset1.setStyleAttribute("marginTop", "10px");

		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(110);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1.setLayout(frmlytSch);

		natPennPrmmSum = new NumberField();
		natPennPrmmSum.setAllowDecimals(true); 
		natPennPrmmSum.setPropertyEditorType(Long.class); 
		natPennPrmmSum.setFormat(NumberFormat.getDecimalFormat());
		natPennPrmmSum.setFieldLabel("국민연금금액");
		layoutContainer1_1.add(natPennPrmmSum, new FormData("99%"));
		
		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(110);
		frmlytSch1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_2.setLayout(frmlytSch1);

		natPennAraPrmmSum = new NumberField();
		natPennAraPrmmSum.setAllowDecimals(true); 
		natPennAraPrmmSum.setPropertyEditorType(Long.class); 
		natPennAraPrmmSum.setFormat(NumberFormat.getDecimalFormat());
		natPennAraPrmmSum.setFieldLabel("국민연금지역금액");
		layoutContainer1_2.add(natPennAraPrmmSum, new FormData("99%"));
		
//		LayoutContainer layoutContainer2 = new LayoutContainer();
//		layoutContainer2.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer1_3 = new LayoutContainer();
		FormLayout frmlytSch2 = new FormLayout();
		frmlytSch2.setLabelWidth(110);
		frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_3.setLayout(frmlytSch2);

		natPennDducSum = new NumberField();
		natPennDducSum.setAllowDecimals(true); 
		natPennDducSum.setPropertyEditorType(Long.class); 
		natPennDducSum.setFormat(NumberFormat.getDecimalFormat());
		natPennDducSum.setFieldLabel("국민연금공제금액");
		layoutContainer1_3.add(natPennDducSum, new FormData("99%"));
		

		layoutContainer1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		layoutContainer1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		layoutContainer1.add(layoutContainer1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		
		
//		LayoutContainer layoutContainer2_2 = new LayoutContainer();
//		FormLayout frmlytSch3 = new FormLayout();
//		frmlytSch3.setLabelWidth(220);
//		frmlytSch3.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer2_2.setLayout(frmlytSch3);
//
//		srhSum22 = new NumberField();
//		srhSum22.setAllowDecimals(true); 
//		srhSum22.setPropertyEditorType(Long.class); 
//		srhSum22.setFormat(NumberFormat.getDecimalFormat());
//		srhSum22.setFieldLabel("국민연금주(현)근무지공제액");
//		layoutContainer2_2.add(srhSum22, new FormData("100%"));
//		
//		layoutContainer2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer2.add(layoutContainer2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//
//		LayoutContainer layoutContainer3 = new LayoutContainer();
//		layoutContainer3.setLayout(new ColumnLayout());
//		
//		LayoutContainer layoutContainer3_1 = new LayoutContainer();
//		FormLayout frmlytSch4 = new FormLayout();
//		frmlytSch4.setLabelWidth(220);
//		frmlytSch4.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer3_1.setLayout(frmlytSch4);
//
//		srhSum3 = new NumberField();
//		srhSum3.setAllowDecimals(true); 
//		srhSum3.setPropertyEditorType(Long.class); 
//		srhSum3.setFormat(NumberFormat.getDecimalFormat());
//		srhSum3.setFieldLabel("국민연금(지역)종(전)근무지금액");
//		layoutContainer3_1.add(srhSum3, new FormData("100%"));
//		
//		LayoutContainer layoutContainer3_2 = new LayoutContainer();
//		FormLayout frmlytSch5 = new FormLayout();
//		frmlytSch5.setLabelWidth(220);
//		frmlytSch5.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer3_2.setLayout(frmlytSch5);
//
//		srhSum33 = new NumberField();
//		srhSum33.setAllowDecimals(true); 
//		srhSum33.setPropertyEditorType(Long.class); 
//		srhSum33.setFormat(NumberFormat.getDecimalFormat());
//		srhSum33.setFieldLabel("국민연금(지역)종(전)근무지공제액");
//		layoutContainer3_2.add(srhSum33, new FormData("100%"));
//		
//		layoutContainer3.add(layoutContainer3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer3.add(layoutContainer3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		
//		LayoutContainer layoutContainer4 = new LayoutContainer();
//		layoutContainer4.setLayout(new ColumnLayout());
//		
//		LayoutContainer layoutContainer4_1 = new LayoutContainer();
//		FormLayout frmlytSch6 = new FormLayout();
//		frmlytSch6.setLabelWidth(220);
//		frmlytSch6.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer4_1.setLayout(frmlytSch6);
//
//		srhSum4 = new NumberField();
//		srhSum4.setAllowDecimals(true); 
//		srhSum4.setPropertyEditorType(Long.class); 
//		srhSum4.setFormat(NumberFormat.getDecimalFormat());
//		srhSum4.setFieldLabel("국민연금(지역)주(현)근무지금액");
//		layoutContainer4_1.add(srhSum4, new FormData("100%"));
//		
//		LayoutContainer layoutContainer4_2 = new LayoutContainer();
//		FormLayout frmlytSch7 = new FormLayout();
//		frmlytSch7.setLabelWidth(220);
//		frmlytSch7.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer4_2.setLayout(frmlytSch7);
//
//		srhSum44 = new NumberField();
//		srhSum44.setAllowDecimals(true); 
//		srhSum44.setPropertyEditorType(Long.class); 
//		srhSum44.setFormat(NumberFormat.getDecimalFormat());
//		srhSum44.setFieldLabel("국민연금(지역)주(현)근무지공제액");
//		layoutContainer4_2.add(srhSum44, new FormData("100%"));
//		
//		layoutContainer4.add(layoutContainer4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer4.add(layoutContainer4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		//공적연금
		LayoutContainer layoutContainer5 = new LayoutContainer();
		layoutContainer5.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer5_1 = new LayoutContainer();
		FormLayout frmlytSch8 = new FormLayout();
		frmlytSch8.setLabelWidth(220);
		frmlytSch8.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_1.setLayout(frmlytSch8);

		puoferAnty = new NumberField();
		puoferAnty.setAllowDecimals(true); 
		puoferAnty.setPropertyEditorType(Long.class); 
		puoferAnty.setFormat(NumberFormat.getDecimalFormat());
		puoferAnty.setFieldLabel("공무원연금금액");
		layoutContainer5_1.add(puoferAnty, new FormData("100%"));
		
		LayoutContainer layoutContainer5_2 = new LayoutContainer();
		FormLayout frmlytSch9 = new FormLayout();
		frmlytSch9.setLabelWidth(220);
		frmlytSch9.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5_2.setLayout(frmlytSch9);

		puoferAntyDducSum = new NumberField();
		puoferAntyDducSum.setAllowDecimals(true); 
		puoferAntyDducSum.setPropertyEditorType(Long.class); 
		puoferAntyDducSum.setFormat(NumberFormat.getDecimalFormat());
		puoferAntyDducSum.setFieldLabel("공무원연금공제액");
		layoutContainer5_2.add(puoferAntyDducSum, new FormData("100%"));
		
		layoutContainer5.add(layoutContainer5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer5.add(layoutContainer5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
//		LayoutContainer layoutContainer6 = new LayoutContainer();
//		layoutContainer6.setLayout(new ColumnLayout());
//		
//		LayoutContainer layoutContainer6_1 = new LayoutContainer();
//		FormLayout frmlytSch10 = new FormLayout();
//		frmlytSch10.setLabelWidth(220);
//		frmlytSch10.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer6_1.setLayout(frmlytSch10);
//
//		srhSum6 = new NumberField();
//		srhSum6.setAllowDecimals(true); 
//		srhSum6.setPropertyEditorType(Long.class); 
//		srhSum6.setFormat(NumberFormat.getDecimalFormat());
//		srhSum6.setFieldLabel("공무원연금주(현)근무지금액");
//		layoutContainer6_1.add(srhSum6, new FormData("100%"));
//		
//		LayoutContainer layoutContainer6_2 = new LayoutContainer();
//		FormLayout frmlytSch11 = new FormLayout();
//		frmlytSch11.setLabelWidth(220);
//		frmlytSch11.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer6_2.setLayout(frmlytSch11);
//
//		srhSum66 = new NumberField();
//		srhSum66.setAllowDecimals(true); 
//		srhSum66.setPropertyEditorType(Long.class); 
//		srhSum66.setFormat(NumberFormat.getDecimalFormat());
//		srhSum66.setFieldLabel("공무원연금주(현)근무지공제액");
//		layoutContainer6_2.add(srhSum66, new FormData("100%"));
//		
//		layoutContainer6.add(layoutContainer6_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer6.add(layoutContainer6_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer7_1 = new LayoutContainer();
		FormLayout frmlytSch12 = new FormLayout();
		frmlytSch12.setLabelWidth(220);
		frmlytSch12.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7_1.setLayout(frmlytSch12);

		mltymAnty = new NumberField();
		mltymAnty.setAllowDecimals(true); 
		mltymAnty.setPropertyEditorType(Long.class); 
		mltymAnty.setFormat(NumberFormat.getDecimalFormat());
		mltymAnty.setFieldLabel("군인연금근무지금액");
		layoutContainer7_1.add(mltymAnty, new FormData("100%"));
		
		LayoutContainer layoutContainer7_2 = new LayoutContainer();
		FormLayout frmlytSch13 = new FormLayout();
		frmlytSch13.setLabelWidth(220);
		frmlytSch13.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7_2.setLayout(frmlytSch13);

		mltymAntyDducSum = new NumberField();
		mltymAntyDducSum.setAllowDecimals(true); 
		mltymAntyDducSum.setPropertyEditorType(Long.class); 
		mltymAntyDducSum.setFormat(NumberFormat.getDecimalFormat());
		mltymAntyDducSum.setFieldLabel("군인연금공제액");
		layoutContainer7_2.add(mltymAntyDducSum, new FormData("100%"));
		
		layoutContainer7.add(layoutContainer7_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer7.add(layoutContainer7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
//		LayoutContainer layoutContainer8 = new LayoutContainer();
//		layoutContainer8.setLayout(new ColumnLayout());
//		
//		LayoutContainer layoutContainer8_1 = new LayoutContainer();
//		FormLayout frmlytSch14 = new FormLayout();
//		frmlytSch14.setLabelWidth(220);
//		frmlytSch14.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer8_1.setLayout(frmlytSch14);
//
//		srhSum8 = new NumberField();
//		srhSum8.setAllowDecimals(true); 
//		srhSum8.setPropertyEditorType(Long.class); 
//		srhSum8.setFormat(NumberFormat.getDecimalFormat());
//		srhSum8.setFieldLabel("군인연금주(현)근무지금액");
//		layoutContainer8_1.add(srhSum8, new FormData("100%"));
//		
//		LayoutContainer layoutContainer8_2 = new LayoutContainer();
//		FormLayout frmlytSch15 = new FormLayout();
//		frmlytSch15.setLabelWidth(220);
//		frmlytSch15.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer8_2.setLayout(frmlytSch15);
//
//		srhSum88 = new NumberField();
//		srhSum88.setAllowDecimals(true); 
//		srhSum88.setPropertyEditorType(Long.class); 
//		srhSum88.setFormat(NumberFormat.getDecimalFormat());
//		srhSum88.setFieldLabel("군인연금주(현)근무지공제액");
//		layoutContainer8_2.add(srhSum88, new FormData("100%"));
//		
//		layoutContainer8.add(layoutContainer8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer8.add(layoutContainer8_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer9 = new LayoutContainer();
		layoutContainer9.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer9_1 = new LayoutContainer();
		FormLayout frmlytSch16 = new FormLayout();
		frmlytSch16.setLabelWidth(220);
		frmlytSch16.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_1.setLayout(frmlytSch16);

		prtafirSchlFalymmAnty = new NumberField();
		prtafirSchlFalymmAnty.setAllowDecimals(true); 
		prtafirSchlFalymmAnty.setPropertyEditorType(Long.class); 
		prtafirSchlFalymmAnty.setFormat(NumberFormat.getDecimalFormat());
		prtafirSchlFalymmAnty.setFieldLabel("사립학교교직원연금금액");
		layoutContainer9_1.add(prtafirSchlFalymmAnty, new FormData("100%"));
		
		LayoutContainer layoutContainer9_2 = new LayoutContainer();
		FormLayout frmlytSch17 = new FormLayout();
		frmlytSch17.setLabelWidth(220);
		frmlytSch17.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_2.setLayout(frmlytSch17);

		prtafirSchlDducSum = new NumberField();
		prtafirSchlDducSum.setAllowDecimals(true); 
		prtafirSchlDducSum.setPropertyEditorType(Long.class); 
		prtafirSchlDducSum.setFormat(NumberFormat.getDecimalFormat());
		prtafirSchlDducSum.setFieldLabel("사립학교교직원연금공제액");
		layoutContainer9_2.add(prtafirSchlDducSum, new FormData("100%"));
		
		layoutContainer9.add(layoutContainer9_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer9.add(layoutContainer9_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
//		LayoutContainer layoutContainer10 = new LayoutContainer();
//		layoutContainer10.setLayout(new ColumnLayout());
//		
//		LayoutContainer layoutContainer10_1 = new LayoutContainer();
//		FormLayout frmlytSch18 = new FormLayout();
//		frmlytSch18.setLabelWidth(220);
//		frmlytSch18.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer10_1.setLayout(frmlytSch18);
//
//		srhSum10 = new NumberField();
//		srhSum10.setAllowDecimals(true); 
//		srhSum10.setPropertyEditorType(Long.class); 
//		srhSum10.setFormat(NumberFormat.getDecimalFormat());
//		srhSum10.setFieldLabel("사립학교교직원연금주(현)근무지금액");
//		layoutContainer10_1.add(srhSum10, new FormData("100%"));
//		
//		LayoutContainer layoutContainer10_2 = new LayoutContainer();
//		FormLayout frmlytSch19 = new FormLayout();
//		frmlytSch19.setLabelWidth(220);
//		frmlytSch19.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer10_2.setLayout(frmlytSch19);
//
//		srhSum1010 = new NumberField();
//		srhSum1010.setAllowDecimals(true); 
//		srhSum1010.setPropertyEditorType(Long.class); 
//		srhSum1010.setFormat(NumberFormat.getDecimalFormat());
//		srhSum1010.setFieldLabel("사립학교교직원연금주(현)근무지공제액");
//		layoutContainer10_2.add(srhSum1010, new FormData("100%"));
//		
//		layoutContainer10.add(layoutContainer10_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer10.add(layoutContainer10_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer12 = new LayoutContainer();
		layoutContainer12.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer12_1 = new LayoutContainer();
		FormLayout frmlytSch20 = new FormLayout();
		frmlytSch20.setLabelWidth(220);
		frmlytSch20.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12_1.setLayout(frmlytSch20);

		spildtnPstoficAnty = new NumberField();
		spildtnPstoficAnty.setAllowDecimals(true); 
		spildtnPstoficAnty.setPropertyEditorType(Long.class); 
		spildtnPstoficAnty.setFormat(NumberFormat.getDecimalFormat());
		spildtnPstoficAnty.setFieldLabel("별정우체국연금금액");
		layoutContainer12_1.add(spildtnPstoficAnty, new FormData("100%"));
		
		LayoutContainer layoutContainer12_2 = new LayoutContainer();
		FormLayout frmlytSch21 = new FormLayout();
		frmlytSch21.setLabelWidth(220);
		frmlytSch21.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12_2.setLayout(frmlytSch21);

		spildtnPstoficDducSum = new NumberField();
		spildtnPstoficDducSum.setAllowDecimals(true); 
		spildtnPstoficDducSum.setPropertyEditorType(Long.class); 
		spildtnPstoficDducSum.setFormat(NumberFormat.getDecimalFormat());
		spildtnPstoficDducSum.setFieldLabel("별정우체국연금공제액");
		layoutContainer12_2.add(spildtnPstoficDducSum, new FormData("100%"));
		
		layoutContainer12.add(layoutContainer12_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer12.add(layoutContainer12_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
//		LayoutContainer layoutContainer13 = new LayoutContainer();
//		layoutContainer13.setLayout(new ColumnLayout());
//		
//		LayoutContainer layoutContainer13_1 = new LayoutContainer();
//		FormLayout frmlytSch22 = new FormLayout();
//		frmlytSch22.setLabelWidth(220);
//		frmlytSch22.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer13_1.setLayout(frmlytSch22);
//
//		srhSum13 = new NumberField();
//		srhSum13.setAllowDecimals(true); 
//		srhSum13.setPropertyEditorType(Long.class); 
//		srhSum13.setFormat(NumberFormat.getDecimalFormat());
//		srhSum13.setFieldLabel("별정우체국연금주(현)근무지금액");
//		layoutContainer13_1.add(srhSum13, new FormData("100%"));
//		
//		LayoutContainer layoutContainer13_2 = new LayoutContainer();
//		FormLayout frmlytSch23 = new FormLayout();
//		frmlytSch23.setLabelWidth(220);
//		frmlytSch23.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer13_2.setLayout(frmlytSch23);
//
//		srhSum1313 = new NumberField();
//		srhSum1313.setAllowDecimals(true); 
//		srhSum1313.setPropertyEditorType(Long.class); 
//		srhSum1313.setFormat(NumberFormat.getDecimalFormat());
//		srhSum1313.setFieldLabel("별정우체국연금주(현)근무지공제액");
//		layoutContainer13_2.add(srhSum1313, new FormData("100%"));
//		
//		layoutContainer13.add(layoutContainer13_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer13.add(layoutContainer13_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer14 = new LayoutContainer();
		layoutContainer14.setLayout(new ColumnLayout());
		layoutContainer14.setWidth(675);
		
		LayoutContainer layoutContainer14_1 = new LayoutContainer();
		FormLayout frmlytSch24 = new FormLayout();
		frmlytSch24.setLabelWidth(225);
		frmlytSch24.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14_1.setLayout(frmlytSch24);
		layoutContainer14_1.setStyleAttribute("marginTop", "7px");

		npHthrWaInfeeAmt = new MSFNumberField();
		npHthrWaInfeeAmt.setAllowDecimals(true); 
		npHthrWaInfeeAmt.setPropertyEditorType(Long.class); 
		npHthrWaInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		npHthrWaInfeeAmt.setFieldLabel("국민연금종(전)합계");
		layoutContainer14_1.add(npHthrWaInfeeAmt, new FormData("100%"));
		
		LayoutContainer layoutContainer14_2 = new LayoutContainer();
		FormLayout frmlytSch25 = new FormLayout();
		frmlytSch25.setLabelWidth(220);
		frmlytSch25.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14_2.setLayout(frmlytSch25);
		layoutContainer14_2.setStyleAttribute("marginTop", "7px");

		npHthrWaInfeeDdcAmt = new MSFNumberField();
		npHthrWaInfeeDdcAmt.setAllowDecimals(true); 
		npHthrWaInfeeDdcAmt.setPropertyEditorType(Long.class); 
		npHthrWaInfeeDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		npHthrWaInfeeDdcAmt.setFieldLabel("국민연금공제종(전)합계");
		layoutContainer14_2.add(npHthrWaInfeeDdcAmt, new FormData("98%"));
		
		layoutContainer14.add(layoutContainer14_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer14.add(layoutContainer14_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer15 = new LayoutContainer();
		layoutContainer15.setLayout(new ColumnLayout());
		layoutContainer15.setWidth(675);
		
		LayoutContainer layoutContainer15_1 = new LayoutContainer();
		FormLayout frmlytSch26 = new FormLayout();
		frmlytSch26.setLabelWidth(225);
		frmlytSch26.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer15_1.setLayout(frmlytSch26);

		npHthrMcurWkarInfeeAmt = new MSFNumberField();
		npHthrMcurWkarInfeeAmt.setAllowDecimals(true); 
		npHthrMcurWkarInfeeAmt.setPropertyEditorType(Long.class); 
		npHthrMcurWkarInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		npHthrMcurWkarInfeeAmt.setFieldLabel("국민연금주(현)합계");
		layoutContainer15_1.add(npHthrMcurWkarInfeeAmt, new FormData("100%"));
		
		LayoutContainer layoutContainer15_2 = new LayoutContainer();
		FormLayout frmlytSch27 = new FormLayout();
		frmlytSch27.setLabelWidth(220);
		frmlytSch27.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer15_2.setLayout(frmlytSch27);

		npHthrMcurWkarDdcAmt = new MSFNumberField();
		npHthrMcurWkarDdcAmt.setAllowDecimals(true); 
		npHthrMcurWkarDdcAmt.setPropertyEditorType(Long.class); 
		npHthrMcurWkarDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		npHthrMcurWkarDdcAmt.setFieldLabel("국민연금공제주(현)합계");
		layoutContainer15_2.add(npHthrMcurWkarDdcAmt, new FormData("98%"));
		
		layoutContainer15.add(layoutContainer15_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer15.add(layoutContainer15_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer16 = new LayoutContainer();
		layoutContainer16.setLayout(new ColumnLayout());
		layoutContainer16.setWidth(675);
		
		LayoutContainer layoutContainer16_1 = new LayoutContainer();
		FormLayout frmlytSch30 = new FormLayout();
		frmlytSch30.setLabelWidth(225);
		frmlytSch30.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer16_1.setLayout(frmlytSch30);

		hthrPblcPnsnInfeeAmt = new MSFNumberField();
		hthrPblcPnsnInfeeAmt.setAllowDecimals(true); 
		hthrPblcPnsnInfeeAmt.setPropertyEditorType(Long.class); 
		hthrPblcPnsnInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		hthrPblcPnsnInfeeAmt.setFieldLabel("국민연금외공적연금종(전)합계");
		layoutContainer16_1.add(hthrPblcPnsnInfeeAmt, new FormData("100%"));
		
		LayoutContainer layoutContainer16_2 = new LayoutContainer();
		FormLayout frmlytSch31 = new FormLayout();
		frmlytSch31.setLabelWidth(220);
		frmlytSch31.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer16_2.setLayout(frmlytSch31);

		hthrPblcPnsnInfeeDdcAmt = new MSFNumberField();
		hthrPblcPnsnInfeeDdcAmt.setAllowDecimals(true); 
		hthrPblcPnsnInfeeDdcAmt.setPropertyEditorType(Long.class); 
		hthrPblcPnsnInfeeDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		hthrPblcPnsnInfeeDdcAmt.setFieldLabel("국민연금외공적연금공제종(전)합계");
		layoutContainer16_2.add(hthrPblcPnsnInfeeDdcAmt, new FormData("98%"));
		
		layoutContainer16.add(layoutContainer16_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer16.add(layoutContainer16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer17 = new LayoutContainer();
		layoutContainer17.setLayout(new ColumnLayout());
		layoutContainer17.setWidth(675);
		
		LayoutContainer layoutContainer17_1 = new LayoutContainer();
		FormLayout frmlytSch32 = new FormLayout();
		frmlytSch32.setLabelWidth(225);
		frmlytSch32.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer17_1.setLayout(frmlytSch32);

		mcurPblcPnsnInfeeAmt = new MSFNumberField();
		mcurPblcPnsnInfeeAmt.setAllowDecimals(true); 
		mcurPblcPnsnInfeeAmt.setPropertyEditorType(Long.class); 
		mcurPblcPnsnInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		mcurPblcPnsnInfeeAmt.setFieldLabel("국민연금외공적연금종(전)합계");
		layoutContainer17_1.add(mcurPblcPnsnInfeeAmt, new FormData("100%"));
		
		LayoutContainer layoutContainer17_2 = new LayoutContainer();
		FormLayout frmlytSch33 = new FormLayout();
		frmlytSch33.setLabelWidth(220);
		frmlytSch33.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer17_2.setLayout(frmlytSch33);

		mcurPblcPnsnInfeeDdcAmt = new MSFNumberField();
		mcurPblcPnsnInfeeDdcAmt.setAllowDecimals(true); 
		mcurPblcPnsnInfeeDdcAmt.setPropertyEditorType(Long.class); 
		mcurPblcPnsnInfeeDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		mcurPblcPnsnInfeeDdcAmt.setFieldLabel("국민연금외공적연금공제종(전)합계");
		layoutContainer17_2.add(mcurPblcPnsnInfeeDdcAmt, new FormData("98%"));
		
		layoutContainer17.add(layoutContainer17_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer17.add(layoutContainer17_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer = new LayoutContainer();
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setHeadingHtml("textarea");
		
		textarea = new TextArea();
		textarea.setName("textarea");
		textarea.setFieldLabel("textarea");
		textarea.setHeight(290);
		textarea.setWidth(675);
		textarea.setReadOnly(true);
		layoutContainer.add(textarea, new FormData("100%"));
		fldstNewFieldset_1.add(layoutContainer);
		
		fldstNewFieldset.add(layoutContainer1);
//		fldstNewFieldset.add(layoutContainer2);
//		fldstNewFieldset.add(layoutContainer3);
//		fldstNewFieldset.add(layoutContainer4);

		fldstNewFieldset1.add(layoutContainer5);
//		fldstNewFieldset1.add(layoutContainer6);
		fldstNewFieldset1.add(layoutContainer7);
//		fldstNewFieldset1.add(layoutContainer8);
		fldstNewFieldset1.add(layoutContainer9);
//		fldstNewFieldset1.add(layoutContainer10);
		fldstNewFieldset1.add(layoutContainer12);
//		fldstNewFieldset1.add(layoutContainer13);
		
		fldstNewFieldset10.add(fldstNewFieldset);
		fldstNewFieldset10.add(fldstNewFieldset1);
		cpYetaT43002.add(fldstNewFieldset10);
		cpYetaT43002.add(layoutContainer14);
		cpYetaT43002.add(layoutContainer15);
		cpYetaT43002.add(fldstNewFieldset_1);
		
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	@Override
	public void reload() {
		
			// TODO Auto-generated method stub
			IColumnFilter filters = null;
			
			YetaT43002GridPanel.getTableDef().setTableColumnFilters(filters);
			YetaT43002GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP03001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
			YetaT43002GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
					, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
			YetaT43002GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
					, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
			YetaT43002GridPanel.reload();
		
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
