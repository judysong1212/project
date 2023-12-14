/**
 * 연금저축소득공제
 */
package com.app.exterms.yearendtax.client.form.yeta2016;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3100BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3100DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta3100Def;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13007Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13007ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.languages.SysComConstants;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP13007   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta13007; 
	  
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

	private SysComConstants SysComLabel = SysComConstants.INSTANCE; 
		  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel yetaP13007GridPanel;
//	private MSFGridPanel yeta0100GridPanel;
//	private Yeta0300Def yeta0300Def_012  = new Yeta0300Def("YETA030012");	//종전근무지내역 그리드 테이블 컬럼 define 
	private Ye16Ta3100Def yetaP13007ToYe16Ta3100Def  = new Ye16Ta3100Def("YETAP13007");	//종전근무지내역 그리드 테이블 컬럼 define 
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private SysCoCalendarDTO msfCoCalendarDto;
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
 	private TextField<String>  srhEdacRvyy;	// 년도
 	private ComboBox<BaseModel> srhSettGbcd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;	/**  column 사업장코드 : dpobCd */
    private HiddenField<String> edacRvyy;	/** column 정산년도 : edacRvyy */
    private HiddenField<String> settGbcd;	/** column 정산구분코드 : settGbcd */
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
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP13007ServiceAsync yetaP13007Service = YetaP13007Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------		
	 	
	    
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
		//버튼에 따른 Action
		private void doAction(ActionDatabase actionDatabase) {
			switch (actionDatabase) {
				case INSERT:
					this.actionDatabase = ActionDatabase.INSERT;
					yetaP13007FormSave();
					break;
				case UPDATE:
					this.actionDatabase = ActionDatabase.UPDATE;
					yetaP13007FormSave();
					break;
				case DELETE:
					this.actionDatabase = ActionDatabase.DELETE;
					yetaP13007FormSave();
					break;
			}
		}
		
		
		private void yetaP13007FormSave() {  
			if (MSFSharedUtils.paramNotNull(records)) { 
				
				Boolean dataChk = true;
	              
				List<Ye16Ta3100DTO> listYeta3100dto = new ArrayList<Ye16Ta3100DTO>();  
	                
				while (records.hasNext()) {
	              
					Record record = (Record) records.next(); 
	                BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
	                Ye16Ta3100DTO yeta3100Dto= new Ye16Ta3100DTO();  
	                      
	                yeta3100Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));					/** 사업장코드 : dpobCd */
	                yeta3100Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   		/** SYSTEMKEY : systemkey */
	                yeta3100Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    			/** column 정산구분코드 : settGbcd */
	                yeta3100Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    			/** column 연말정산귀속년도 : edacRvyy */
	                
	                yeta3100Dto.setFinaSeqn((Long) bmMapModel.get("finaSeqn"));    								/** column 연금_저축일련번호 : finaSeqn */
	                yeta3100Dto.setImdeGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("imdeGbcd$commCd")));		/** column 소득공제구분코드 : imdeGbcd */
	                
	                yeta3100Dto.setFinaCode(MSFSharedUtils.allowNulls(bmMapModel.get("finaCode$commCd"))); 		/** column 금융기관코드 : finaCode */
	                yeta3100Dto.setFinaName(MSFSharedUtils.allowNulls(bmMapModel.get("finaName")));    			/** column 금융기관상호 : finaName */
	                yeta3100Dto.setAcntNumb(MSFSharedUtils.allowNulls(bmMapModel.get("acntNumb")));    			/** column 계좌번호 : acntNumb */
	                yeta3100Dto.setIcnmYear(MSFSharedUtils.allowNulls(bmMapModel.get("icnmYear")));    			/** column 납입연차 : icnmYear */
	                yeta3100Dto.setPaytAmnt((Long) bmMapModel.get("paytAmnt"));    								/** column 불입금액 : paytAmnt */
	                yeta3100Dto.setDeduAmnt((Long) bmMapModel.get("deduAmnt"));    								/** column 세액공제금액 : deduAmnt */
	                yeta3100Dto.setImdeTxcd(MSFSharedUtils.allowNulls(bmMapModel.get("imdeTxcd")));   			/** column 소득공제구분국세청코드 : imdeTxcd */
	                yeta3100Dto.setFinaTxcd(MSFSharedUtils.allowNulls(bmMapModel.get("finaTxcd")));    			/** column 금융기관국세청코드 : finaTxcd */
	                
	                
	                /** 그리드에 있는 항목에 대해서 입력 체크 **/
	                if(MSFSharedUtils.paramNull( yeta3100Dto.getImdeGbcd())) {
	                	MessageBox.alert("경고", "연금/저축명을 선택해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( yeta3100Dto.getFinaCode())) {
	                	MessageBox.alert("경고", "금융회사를 선택해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( yeta3100Dto.getAcntNumb().replace("-", ""))) {
	                	MessageBox.alert("경고", "계좌번호를 입력해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( yeta3100Dto.getIcnmYear())) {
	                	MessageBox.alert("경고", "납입연차를 입력해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( yeta3100Dto.getPaytAmnt())) {
	                	MessageBox.alert("경고", "블입금액을 입력해 주세요.", null);
	                	dataChk = false;
						return; 
	                }
	                
	                listYeta3100dto.add(yeta3100Dto);
				}  
				
				
				
				if(dataChk) {
					if (listYeta3100dto.size() <= 0) {
						MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
		                
					yetaP13007Service.activityOnYetaP13007ToYeta3100(listYeta3100dto, actionDatabase, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP13007ToYeta3100(" + actionDatabase.name() + ") : " + caught), null);
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
//		 private void checkYetaP13001Auth( String authAction, ListStore<BaseModel>bm) {
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
	  public YetaP13007(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
			//콤보 권한초기화
//			initLoad(); 
			
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
		   
	        cpYeta13007 = new ContentPanel();  
	        
	        createSearchForm();			//검색필드를 적용
	        createMsfGridForm();		//그리드필드
		   
	           
		   cpYeta13007.setBodyBorder(false);
		   cpYeta13007.setBorders(false);
		   cpYeta13007.setHeaderVisible(false);
		   cpYeta13007.setSize("790px", "640px");
		   
		   this.add(cpYeta13007);
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
			cpYeta13007.add(systemkey);
			
		    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		    dpobCd.setName("dpobCd");
		    cpYeta13007.add(dpobCd);
		    
		    edacRvyy = new HiddenField<String>();	/** column 정산년도 : edacRvyy */
		    edacRvyy.setName("edacRvyy");
		    cpYeta13007.add(edacRvyy);
		    
		    settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
		    settGbcd.setName("settGbcd");
		    cpYeta13007.add(settGbcd);
		    
		    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		    deptNm.setName("deptNm");
		    cpYeta13007.add(deptNm);
		    
		    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		    hanNm.setName("hanNm");
		    cpYeta13007.add(hanNm);
		    
				
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
//			     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
//			     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
			     
//			     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//			     
//			     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//			    	 public void handleEvent(StoreEvent<BaseModel> be) {  
//			    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
//			    		 srhDeptCd.getStore().add(mDtalistDeptCd);
//			    	 }
//			     });     
			        

			cpYeta13007.setLayout(new FlowLayout());

			topYetaBtnBar = new ButtonBar();
			topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

			btnYetaNew = new Button("신규");
			btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
			btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					//테스트용
//					dpobCd.setValue(" ");
//					systemkey.setValue("20080013");
					
					
					 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		 	    		 return;
		      	     }
					 
					 yetaP13007GridPanel.getMsfGrid().clearData();
					 
					 BaseModel bmData = yetaP13007GridPanel.getTableDef().getDefaultValues();  
			              
			         bmData.set("dpobCd", dpobCd.getValue()); 		/** column 사업장코드 : dpobCd */
			         bmData.set("systemkey", systemkey.getValue()); /** column SYSTEMKEY : systemkey */
			         bmData.set("edacRvyy", edacRvyy.getValue());	/** column 연말정산귀속년도 : edacRvyy */
			         bmData.set("settGbcd", settGbcd.getValue());   /** column 정산구분코드 : settGbcd */
			         
			         bmData.set("finaSeqn", 0L);    /** column 연금_저축일련번호 : finaSeqn */
			         bmData.set("imdeGbcd", "");    /** column 소득공제구분코드 : imdeGbcd */
			         bmData.set("finaCode", "");    /** column 금융기관코드 : finaCode */
			         bmData.set("finaName", "");    /** column 금융기관상호 : finaName */
			         bmData.set("acntNumb", "");    /** column 계좌번호 : acntNumb */
			         bmData.set("icnmYear", "");    /** column 납입연차 : icnmYear */
			         bmData.set("paytAmnt", 0L);    /** column 불입금액 : paytAmnt */
			         bmData.set("deduAmnt", 0L);    /** column 세액공제금액 : deduAmnt */
			         bmData.set("imdeTxcd", "");    /** column 소득공제구분국세청코드 : imdeTxcd */
			         bmData.set("finaTxcd", "");    /** column 금융기관국세청코드 : finaTxcd */
			              
			         yetaP13007GridPanel.getMsfGrid().getGrid().stopEditing();      
			         yetaP13007GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			         yetaP13007GridPanel.getMsfGrid().getGrid().startEditing(yetaP13007GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
					
			         actionDatabase = ActionDatabase.INSERT;
					
					
//					doAction(actionDatabase);
				}
			});
				
			topYetaBtnBar.add(btnYetaNew);

			btnYetaDel = new Button("삭제");
			btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
			btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					Iterator<BaseModel> itBm = yetaP13007GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
					List<Record> lsRec = new ArrayList<Record>();
					
					if((ActionDatabase.INSERT).equals(actionDatabase)) {
						yetaP13007GridPanel.getMsfGrid().clearData();

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
					setListRecord(yetaP13007GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
					doAction(actionDatabase);

					if ((ActionDatabase.INSERT).equals(actionDatabase)) {
						actionDatabase = ActionDatabase.INSERT;
					} else {
						actionDatabase = ActionDatabase.UPDATE;
					}
				}
			});

			topYetaBtnBar.add(btnYetaSave);
					
//				btnYetaClose  = new Button("닫기");
//				topYetaBtnBar.add(btnYetaClose);
					
			cpYeta13007.add(topYetaBtnBar);
			  	
			  	
			LayoutContainer lcSchCol = new LayoutContainer();
			lcSchCol.setLayout(new ColumnLayout());

			FieldSet fieldSet = new FieldSet();
			fieldSet.setHeadingHtml("기본정보");

			LayoutContainer lcSchCol01 = new LayoutContainer();

			FormLayout frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			lcSchCol01.setLayout(frmlytSch);
				
			srhEdacRvyy = new TextField<String> ();
			srhEdacRvyy.setName("edacRvyy");
//			srhEdacRvyy.setForceSelection(true);
//			srhEdacRvyy.setMinChars(1);
//			srhEdacRvyy.setDisplayField("yearDisp");
//			srhEdacRvyy.setValueField("year");
//			srhEdacRvyy.setTriggerAction(TriggerAction.ALL);
			// srhEdacRvyy.setEmptyText("--년도선택--");
			srhEdacRvyy.setSelectOnFocus(true);
			srhEdacRvyy.setReadOnly(true);
			srhEdacRvyy.setEnabled(true);
//			srhEdacRvyy.setStore(lsdacRvyyStore);
			srhEdacRvyy.setFieldLabel("년도");
//			srhEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
//				public void handleEvent(StoreEvent<BaseModel> be) {
//					srhEdacRvyy.setValue(lsdacRvyyStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
//				}
//			});
				
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
//					srhSettGbcd.setValue(lsSettGbcd.getAt(0));
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
				
			lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
				

			fieldSet.add(lcSchCol, new FormData("100%"));

			cpYeta13007.add(fieldSet);
		}    
		
		public void setListRecord(Iterator<Record> records) {
		    this.records = records;
		}
	 	 
			
   	
	  @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            @Override
	            public void handleEvent(BaseEvent be) {
	            	
	            	 Timer timer = new Timer() {
							@Override
							public void run() {
								

				            	srhDeptCd.setValue(deptNm.getValue());
				    			srhHanNm.setValue(hanNm.getValue());
							}
						};
						
						timer.schedule(3000);
	            
	    			
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
			
//			topYetaBtnBar  = new ButtonBar();
//			topYetaBtnBar .setAlignment(HorizontalAlignment.RIGHT);
//
//			btnYetaNew   = new Button("신규");
//			topYetaBtnBar.add(btnYetaNew);
//
//			btnYetaDel  = new Button("삭제");
//			topYetaBtnBar.add(btnYetaDel);
//				
//			btnYetaSave = new Button("저장");
//			topYetaBtnBar.add(btnYetaSave);
//				
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
//				
//			cpYeta13007.add(topYetaBtnBar);
			
			ContentPanel cp01 = new ContentPanel();   
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());
			cp01.setSize(790, 500);
			
			yetaP13007GridPanel = new MSFGridPanel(yetaP13007ToYe16Ta3100Def, false, false, false, false, false);
			yetaP13007GridPanel.setSize("790px", "500px");
			yetaP13007GridPanel.setBorders(false);
			yetaP13007GridPanel.setHeaderVisible(false);
			
			/** --- 그리드 합계 부분  시작 --- **/
			AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
			payrSummaryRow.setHtml(Ye16Ta3100BM.ATTR_ICNMYEAR, "합 계"); 
			 
			payrSummaryRow.setCellStyle(Ye16Ta3100BM.ATTR_PAYTAMNT,"summary_color");	/** set 불입금액 : paytAmnt */
								    
			payrSummaryRow.setSummaryType(Ye16Ta3100BM.ATTR_PAYTAMNT, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye16Ta3100BM.ATTR_PAYTAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
			
			yetaP13007GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
			/** --- 그리드 합계 부분  시작 --- **/
			
			cpYeta13007.add(yetaP13007GridPanel);
			
			LayoutContainer layoutContainer = new LayoutContainer();
		      
			LabelField lblfldNewLabelfield = new LabelField("장기주식형저축의 경우에만 납입연차를 1,2,3년차로 구분하여 적는다. 숫자만 기입");
			layoutContainer.add(lblfldNewLabelfield);
			layoutContainer.setBorders(false);
			
			cp01.add(yetaP13007GridPanel);
			
			cpYeta13007.add(cp01);
			
			
//			cpYeta13007.add(layoutContainer);
	}
		
		
		public void reload() {
			
				// TODO Auto-generated method stub
				IColumnFilter filters = null;
				
				yetaP13007GridPanel.getTableDef().setTableColumnFilters(filters);
				yetaP13007GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//				yetaP13001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
//						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
				yetaP13007GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
						, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
				yetaP13007GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
						, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
			 
				yetaP13007GridPanel.reload();
			
//			actionDatabase = ActionDatabase.READ;
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
