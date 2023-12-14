
package com.app.exterms.payroll.client.form;
  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0500DTO;
import com.app.exterms.payroll.client.form.defs.Payr0500Def;
import com.app.exterms.payroll.client.service.PayrP410004Service;
import com.app.exterms.payroll.client.service.PayrP410004ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PayrP410004    extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	     
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

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
	  
	  private  ContentPanel cpPayr4104;  

	  //추가소득세관리
	  private Payr0500Def pPayr0500Def  = new Payr0500Def("PAYRP410004");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel pPayr0500GridPanel;
      
	    //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
		    
 
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
  private Boolean reading = false;
  public  FormBinding formBinding;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ButtonBar topPayrP410004Bar;
  private Button btnPayrP410004Init;
  private Button btnPayrP410004Save;
  private Button btnPayrP410004Del;
  private Button btnPayrP410004Sreach;
  private Button btnPayrP410004Print;
  private Button btnPayrP410004Excel;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  
  private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
  private ComboBox<BaseModel> srhEmymtDivCd; //고용구분  
  
  
//  private ComboBox<BaseModel> srhTypOccuCd; //직종  
//  private HiddenField<String> srhPyspGrdeCd; //호봉등급 
//  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
  
  private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
  private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
  
  private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//  private ComboBox<BaseModel> srhDeptCd ;    //부서 
//  private TextField<String> srhDeptCd; //부서코드
//  private TextField<String> srhDeptNm; //부서명  
//  private Button btnSrhDeptCd;
//  private TextField<String> srhMangeDeptCd; //관리부서 수정
//  private TextField<String> srhMangeDeptNm; //관리부서 수정  
  
  private ComboBox<BaseModel> srhBusinCd;    //사업
  private TextField<String> srhHanNm;         //성명
  private TextField<String> srhResnRegnNum;   //주민번호 
  private HiddenField<String> srhSystemkey;   //시스템키
//  private ComboBox<BaseModel> srhHdofcCodtnCd; //재직상태  
  private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
   
  
  private List<ModelData> mDtalistHdofcCodtnCd ;
  private List<ModelData> mDtalistDeptCd ;
  private List<ModelData> mDtalistTypOccuCd ;
  private List<ModelData> mDtalistDtilOccuInttnCd ;
  
  private boolean mutilCombo = false;
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
   * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   **/
   // 검색 폼 바인딩 처리 함수 
//private AuthAction authAction;  
			//  private Boolean boolChkAuth;  
			//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
			  /**
			   * 권한설정 처리 체크 
			   * AuthAction 
			   */
			  private void checkPayr410004Auth( String authAction, ListStore<BaseModel> bm) {   
		    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
				 
				  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
				   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
				   
					   if (!maskTracker) { unmask(); }  
		                //MSFMainApp.unmaskMainPage();
					   authExecEnabled() ;
					     
		             
		                 
				   }
			  }
			  
				 private void authExecEnabled() { 
					   //------------------

	                 Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
	                 
	           	  	gwtAuthorization.formAuthFieldConfig(fldArrField);
	           	    gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
	                //----------------------------------------------------
	              
	           	   srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
	                srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
	                
				   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
	                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	               //  String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
	                // GWTAuthorization.formAuthFieldConfig(cpPayr4104, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	               //  GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
				  // gwtAuthorization.formAuthFieldConfig(getFields(), "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
	               /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	               //  srhDeptCd.fireEvent(Events.Add); 
	                 srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                 
					 }
			   final Timer tmMask = new Timer()
			     {
			           public void run()
			           {
			              // if (maskTracker)
			              // { 
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
				     
				     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
				     authMapDef.put("srhHdofcCodtnCd",Boolean.FALSE); 
				     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
				     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);  
				     authMapDef.put("srhDeptCd",Boolean.FALSE); 
				     // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
					 
				      gwtExtAuth.setCheckMapDef(authMapDef);
			        
			        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			        	  //권한 검색조건처리를 위해 추가된 부분 
						  mask("[화면로딩] 초기화 진행 중!");
		        	}
			        tmMask.scheduleRepeating(5000);
			  }
			  
		 
     
  /**
   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   **/	
  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayrP410004FormBinding() {
	 	 
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
 
	       private PayrP410004ServiceAsync payrP410004Service = PayrP410004Service.Util.getInstance();
		   
		 
	       private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
	  		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
	    		
	   		 //--------------------부서 불러 오는 함수 ------------------------------------------------
	   	 	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
	   		 //--------------------부서 불러 오는 함수 ------------------------------------------------
	   		   
	   		//--------------------사업 불러 오는 함수 -------------------------------------------------
	   		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
	   	   //--------------------사업 불러 오는 함수 -------------------------------------------------
	   		
	   		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
	   		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
	   		
	   	 
	   		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
	   		 
	   		 
	   		
	   		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	   	 	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	   		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	   		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	   		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	   	    private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	   	 
	   		private SysCoCalendarDTO msfCoCalendarDto;   
	   		
	    	    private BaseModel record;
	       
    
	          private  Iterator<Record> records;
  		   
	    
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
	     * 기본정보저장처리
	     */
	    private void saveStandData() {
	        
	    	 setListRecord(pPayr0500GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator());
	         
	         if (pPayr0500GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
	             
	             MessageBox.alert("추가소득세율관리", "저장할 추가소득세율이 존재하지 않습니다.", null);
	             return;
	         }
	         
	         List<Payr0500DTO> listPayr0500Dto = new ArrayList<Payr0500DTO>();  
	         
	         while (records.hasNext()) {
	       
	                Record record = (Record) records.next(); 
	                BaseModel bmMapModel = (BaseModel)record.getModel();
	               
	           
	               Payr0500DTO payr0500Dto = new Payr0500DTO(); 

		        payr0500Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	 	        payr0500Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	//	        payr0500Dto.setSoctyInsurYr(DateTimeFormat.getFormat("yyyy").format(new Date())); //TODO 회계년도 물고 있을것
	//	        payr0500Dto.setPayrMangDeptCd(payrMangDeptCd.getValue());    /** column 급여관리부서코드 : payrMangDeptCd */
	//	        payr0500Dto.setEmymtDivCd(emymtDivCd.getValue());    /** column 고용구분코드 : emymtDivCd */
	//	        payr0500Dto.setLogSvcStdDt(MSFSharedUtils.allowNulls(logSvcStdDt.getValue()).replace(".", ""));    /** column 근속기준일자 : logSvcStdDt */
	//	        payr0500Dto.setWmnYn(wmnYn.getValue());    /** column 부녀자여부 : wmnYn */
	//	        payr0500Dto.setRetryClutYn(retryClutYn.getValue());    /** column 퇴직정산여부 : retryClutYn */
	//	        payr0500Dto.setPayRcptYn(payRcptYn.getValue());    /** column 급여대상자여부 : payRcptYn */
	//	      // payr0500Dto.setSpueYn(spueYn.getValue());   /** column 배우자유무 : spueYn */
	//	        payr0500Dto.setHlthInsrApptnYn(hlthInsrApptnYn.getValue());    /** column 건강보험적용여부 : hlthInsrApptnYn */
	//	        payr0500Dto.setNatPennApptnYn(natPennApptnYn.getValue());    /** column 국민연금적용여부 : natPennApptnYn */
	//	        payr0500Dto.setUmytInsrApptnYn(umytInsrApptnYn.getValue());    /** column 고용보험적용여부 : umytInsrApptnYn */
	//	        payr0500Dto.setIdtlAccdtInsurApptnYn(idtlAccdtInsurApptnYn.getValue());    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
	//	       // payr0500Dto.setSuprtFamyNumTwenChDn(.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
	//	        //payr0500Dto.setSuprtFamyNumTreOvrChdnYn(.getSuprtFamyNumTreOvrChdnYn());    /** column 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
	//	       // payr0500Dto.setSuprtFamyNumEtc(.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
	//	       // payr0500Dto.setChdnSchlExpnAdmclYn(.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */ 
	//	        payr0500Dto.setLogSvcExtpyApptnYn(logSvcExtpyApptnYn.getValue());    /** column 근속수당적용여부 : logSvcExtpyApptnYn */
	//	        
	//	        payr0500Dto.setMnthPayDlywagSum((Long)mnthPayDlywagSum.getValue());    /** column 월급여일당금액 : mnthPayDlywagSum */
		         
	//	        payr0500Dto.setHlthInsrMnthRuntnAmnt((Long)hlthInsrMnthRuntnAmnt.getValue());                                 /**  column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	//	        payr0500Dto.setNatPennStdIncmMnthAmnt((Long)natPennStdIncmMnthAmnt.getValue());                               /**  column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
	//	        payr0500Dto.setUmytInsrPayMnthAmnt((Long)umytInsrPayMnthAmnt.getValue());                                     /**  column 고용보수월액 : umytInsrPayMnthAmnt */
	//	        payr0500Dto.setIdtlAccdtPayMnthAmnt((Long)umytInsrPayMnthAmnt.getValue());                                    /**  column 산재보수월액 : idtlAccdtPayMnthAmnt */ 
	//	        payr0500Dto.setLogSvcYrNumCd(MSFSharedUtils.getSelectedComboValue(logSvcYrNumCd,"commCd") )  ;                /**  column 근속년수코드 : logSvcYrNumCd */
	//	        payr0500Dto.setLogSvcMnthIcmCd(MSFSharedUtils.getSelectedComboValue(logSvcMnthIcmCd,"commCd"))  ;             /**  column 근속월수코드 : logSvcYrNumNm */ 
	//	        payr0500Dto.setDayWorkYn(dayWorkYn.getValue())  ;                                                             /**  column 일용직구분 : dayWorkYn */ 
//		        payr0500Dto.setPayrIncmExceYn(payrIncmExceYn.getValue())  ;                                                             /**  column 일용직구분 : payrIncmExceYn */ 	        
		        
		        payr0500Dto.setAddIncmTxApptnRtoCd(MSFSharedUtils.allowNulls(bmMapModel.get("addIncmTxApptnRtoCd$commCd")) );    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
		        payr0500Dto.setAddIncmTxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("addIncmTxApptnYrMnth")));    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
		        payr0500Dto.setAddIncmTxApptnYn("Y");    /** column 추가소득세적용여부 : addIncmTxApptnYn */
		        
		        listPayr0500Dto.add(payr0500Dto);
		           
	         }  
	         
		        payrP410004Service.activityOnUpdatePayrP410004Save(listPayr0500Dto ,
		                new AsyncCallback<Long>() {
		        public void onFailure(Throwable caught) {
		        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdatePayrP410004Save(저장(수정)) : " + caught), null);
		        }
		        public void onSuccess(Long result) { 
		        if (result == 0) {
		           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
		                   "수정처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
		        } else {
		           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		                    "수정처리가 완료되었습니다.", null);
		           reload();
		        } 
		        } 
		        });
	        
	    }
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
//		private void Payr4100Print(String fileName) {
	// 
//			// 출력물 디렉토리 패스경로 인사 : PSNL
//			String strDirPath = "PAYR";
//			// mrd 출력물
//			String rdaFileName = fileName+".mrd";
//			// 보낼 파라미터
//			
//			
//			//검색조건
//	 	String serarchParam = "";
////			
////			String name = searchName.getValue() == null ? "" : searchName.getValue();
////			String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////			String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////			//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////			String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////			String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////			String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////			
////			serarchParam += "["+name+"]";
////			serarchParam += "["+resn+"]";
////			serarchParam += "["+hdofcCodtnCd+"]";
////			serarchParam += "[]";
////			//serarchParam += "["+manageDeptCd+"]";
////			serarchParam += "["+deptCd+"]";
////			serarchParam += "["+emymtDivCd+"]";
////			serarchParam += "["+typOccuCd+"]";
//			
//			List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
//			String checkedSystemKeys = "";
//			if(list != null && list.size() > 0){
//				String chkkey = "";
//				for(BaseModel bm : list){
//					chkkey += "'"+bm.get("systemkey")+"',";
//				}
//				
//				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				
//			}
//			String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//			
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	//
//		}

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
 
//	    @Override
//	    protected void onRender(Element parent, int index) {
//	      super.onRender(parent, index);
//	        
//	    }
	  
	  public PayrP410004(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
		  //콤보 권한초기화
		   initLoad(); 
			
		   // this.setFrame(false);
	       // this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		  
	        cpPayr4104 = new ContentPanel();
		    createPayrP410004Form();  //화면 기본정보를 설정
		    createBtnTop();
		    createSearchForm();    //검색필드를 적용 
		    createStandardForm();    //기본정보필드    
		   
		   cpPayr4104.setBodyBorder(false);
		   cpPayr4104.setBorders(false);
		   cpPayr4104.setHeaderVisible(false);
		  //cpPayr4104.setSize("810px", "710px");  
		 
		    this.add(cpPayr4104);
		  //  formBinding = new FormBinding(this, true);
			this.setSize("996px", "640px");    
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
	  private  void createPayrP410004Form() { 
		   
		  

		   //멀티콤보박스 닫기 
		  cpPayr4104.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
           @Override
           public void handleEvent(ComponentEvent ce) { 
           
            //   for (Field<?>  f : ((FormPanel) cpPayr4104).getFields()) {
                   
           //        if (f instanceof MSFMultiComboBox<?>) {
                       
//                       if ("srhDeptCd".equals(f.getName())) {
//                           
//                       } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                           
//                       }
                       
             //      } else {
                  if (mutilCombo) {
                       if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                           srhDeptCd.showClose(ce);
                           mutilCombo = false;
                       } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
                           srhHdofcCodtnCd.showClose(ce);
                           mutilCombo = false;
                       } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                           //직종
                           srhTypOccuCd.showClose(ce);
                           mutilCombo = false;
                         //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
                       } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                           //직종세
                           srhDtilOccuInttnCd.showClose(ce);
                           mutilCombo = false;
                       }  
                  }
               //    }
           //    } 
           } 
       });
		 
	 
		  cpPayr4104.setSize("976px", "640px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		     
		   
		  //  srhPyspGrdeCd = new HiddenField<String>(); 
	         srhSystemkey = new HiddenField<String>();  //시스템키 
	        
	     
		     sysComBass0150Dto = new PrgmComBass0150DTO();
			 sysComBass0300Dto = new PrgmComBass0300DTO();
			 sysComBass0400Dto = new PrgmComBass0400DTO();
			 sysComBass0500Dto = new PrgmComBass0500DTO(); 
			 sysComBass0350Dto = new PrgmComBass0350DTO();
			 sysComBass0320Dto = new PrgmComBass0320DTO();
			 
			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
			 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
			
			 //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			// sysComBass0400Dto.setDeptDspyYn("Y");
			 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
			 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
			
			 lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
			
			 lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	             public void handleEvent(StoreEvent<BaseModel> be) {  
	                 mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
	                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
	                 
	             }
	         });     
			 //--------------------급여부서 불러 오는 함수 ------------------------------------------------
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //고용구분
			 sysComBass0300Dto.setRpsttvCd("A002");
			 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //재직상태  
			 sysComBass0300Dto.setRpsttvCd("A003");
			 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
	              public void handleEvent(StoreEvent<BaseModel> be) {  
	                  mDtalistHdofcCodtnCd = PayrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
	                  srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
	                  
	              }
	          });   
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			  
 
			 
		   /**
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		      * 직종 콤보박스 처리  시작
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		      */
//		     		  ContentPanel typOccuCdGrid = new ContentPanel();  
//		     		  typOccuCdGrid.setVisible(false);
//		     		    
//		     		    //직종 콤보처리 
//		     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		     			       public void handleEvent(ComponentEvent be) {  
//		     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		     			        	  
//		     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//		     			        	mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//		     			          }  
//		     			        });  
//		     			       
//		     			      }  
//		     			    });  
//		     	  
//		     	    typOccuCdGrid.add(typOccuCdGridPanel); 
//		     		cpPayr4104.add(typOccuCdGrid);
		     	    
			  lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
    		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
   	            public void handleEvent(StoreEvent<BaseModel> be) {  
   	             
                     mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                     srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                      
                   }
               });  
			 
		   cpPayr4104.setLayout(new FlowLayout());
		    
		    LayoutContainer lcSchCol = new LayoutContainer();
		    lcSchCol.setLayout(new ColumnLayout()); 
		    
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("검색조건");
	        /****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 시작
			 ****************************************************************/
			fieldSet.addStyleName("x-fieldset-serarch-back-color");
			/****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 끝
			 ****************************************************************/
		   
		    fieldSet.add(lcSchCol, new FormData("100%"));
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_14.setLayout(frmlytSch);
		    
		    /** column 단위기관 : payrMangDeptCd */
		    srhPayrMangDeptCd = new ComboBox<BaseModel>();
		    srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		    srhPayrMangDeptCd.setForceSelection(true);
		    srhPayrMangDeptCd.setMinChars(1);
		    srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		    srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		    srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		    srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		    srhPayrMangDeptCd.setSelectOnFocus(true); 
		    srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		    srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
		    srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
		    srhPayrMangDeptCd.setFieldLabel("단위기관"); 
		    lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	            	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkPayr410004Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	                	 }
	            }
	        });    
		    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	  	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	  	    	    // sysComBass0400Dto.setDeptDspyYn("Y");
	  	          sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	  	          //--------------------부서 불러 오는 함수 ------------------------------------------------
	  	          lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	  	          //--------------------부서 불러 오는 함수 ------------------------------------------------
	  	          lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	  	             public void handleEvent(StoreEvent<BaseModel> be) {  
	  	               mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
	                   srhDeptCd.getInitStore().add(mDtalistDeptCd);
	  	                 
	  	             }
	  	          });       
	  	    	} 
	  	    });
		    layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
		    layoutContainer_14.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer(); 
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_1.setLayout(frmlytSch);
	        
	        srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
	        srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
//	        srhHdofcCodtnCd.setForceSelection(true);
//	        srhHdofcCodtnCd.setMinChars(1);
//	        srhHdofcCodtnCd.setDisplayField("commCdNm");
//	        srhHdofcCodtnCd.setValueField("commCd");
	       // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
	        srhHdofcCodtnCd.setEmptyText("--재직선택--");
//	        srhHdofcCodtnCd.setSelectOnFocus(true); 
	        srhHdofcCodtnCd.setReadOnly(true);
	        srhHdofcCodtnCd.setEnabled(true); 
	       // srhHdofcCodtnCd.setStore(lsHdofcCodtnCd); 
	        srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
	        srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
	        srhHdofcCodtnCd.setWidth(100);
	     //   srhHdofcCodtnCd.setHeight(100);
	        srhHdofcCodtnCd.setFieldLabel("재직상태");
	        srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	            public void handleEvent(StoreEvent<ModelData> be) {  
	            	checkPayr410004Auth("srhHdofcCodtnCd",lsHdofcCodtnCd); 
	  	          
	            }
	        }); 
	        srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {   
	                
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
	                   // GWT.log(" a" + ce.getEvent().getType());
	                    mutilCombo = true;
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                    mutilCombo = true;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                    mutilCombo = false;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                }  
	             
	            } 
	        });
	        layoutContainer_1.add(srhHdofcCodtnCd, new FormData("100%"));
	        layoutContainer_1.setBorders(false); 
	        
	        
	        LayoutContainer layoutContainer11 = new LayoutContainer(); 
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer11.setLayout(frmlytSch);
	        
	        srhEmymtDivCd =  new ComboBox<BaseModel>(); 
	        srhEmymtDivCd.setName("srhEmymtDivCd");
	        srhEmymtDivCd.setForceSelection(true);
	        srhEmymtDivCd.setMinChars(1);
	        srhEmymtDivCd.setDisplayField("commCdNm");
	        srhEmymtDivCd.setValueField("commCd");
	        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
	        srhEmymtDivCd.setEmptyText("--고용구분선택--");
	        srhEmymtDivCd.setSelectOnFocus(true); 
	        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	        srhEmymtDivCd.setStore(lsEmymtDivCd);
	        srhEmymtDivCd.setFieldLabel("고용구분"); 
	        lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	            	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkPayr410004Auth("srhEmymtDivCd", lsEmymtDivCd); 
	                	 }
	                
	            }
	        });    
	        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	             BaseModel bmPayCd =  se.getSelectedItem(); 
	             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	            	 srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                 srhBusinCd.setEnabled(true);
	                 srhTypOccuCd.reset();
	                 srhTypOccuCd.setEnabled(false);
	                 srhDtilOccuInttnCd.reset();
	                 srhDtilOccuInttnCd.setEnabled(false);
	             } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
	            	 //20151130 추가 수정 
            	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	            	 srhBusinCd.reset();
                     srhBusinCd.setEnabled(false);   
	                 if (gwtExtAuth.getEnableTypOccuCd()) {
	                	 srhTypOccuCd.setEnabled(true);
	                     srhDtilOccuInttnCd.setEnabled(true); 
	                 } else {
	                	 srhTypOccuCd.setEnabled(false);
	                     srhDtilOccuInttnCd.setEnabled(false);
	                     
	                 }
            	     
	             }  
	             
	             
	            } 
	        });
	        layoutContainer11.add(srhEmymtDivCd, new FormData("100%"));
	        layoutContainer11.setBorders(false);
	        

	        LayoutContainer layoutContainer_5 = new LayoutContainer();
	        layoutContainer_5.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_6 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(40); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_6.setLayout(frmlytSch);
	        
	        srhHanNm = new TextField<String>();
	        srhHanNm.setName("srhHanNm");
	        layoutContainer_6.add(srhHanNm, new FormData("100%"));
	        srhHanNm.setFieldLabel("성명");
	        
	        
 	        srhHanNm.addKeyListener(new KeyListener() {
 	        	 @Override
	            public void componentKeyDown(ComponentEvent event) {
	               
	                srhHanNm.validate();
	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
	                    srhSystemkey.setValue("");
	                    srhResnRegnNum.setValue("");
	                }
	                
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                   
	                    srhSystemkey.setValue("");
	                    srhResnRegnNum.setValue(""); 
	                    
	                    fnPopupPsnl0100() ;
	                }
	                
	                if (event.getKeyCode() == KeyCodes.KEY_BACKSPACE) {
	                	srhSystemkey.setValue("");
	                	srhResnRegnNum.setValue("");
	                }
	                
	                super.componentKeyDown(event);
	            }
	         });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                    srhSystemkey.setValue("");
//	                    srhResnRegnNum.setValue("");
//	                }
//	             
//	            } 
//	      }); 
	        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	        layoutContainer_6.setBorders(false);
	        
	        Button btnHanNm = new Button("검색");
	        layoutContainer_5.add(btnHanNm);
	        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                
	                srhSystemkey.setValue("");
	                srhResnRegnNum.setValue("");
	                   
	                 fnPopupPsnl0100() ;
	                  
	                  
	            }
	        });
	        
	        LayoutContainer layoutContainer_7 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(1); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_7.setLayout(frmlytSch);
	        
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
	       // srhResnRegnNum.setFieldLabel("주민번호");
	        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));
	        layoutContainer_7.setBorders(false);
	        layoutContainer_5.setBorders(false);
	        
		     
		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		   lcSchCol.add(layoutContainer11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    layoutContainer_13.setLayout(new ColumnLayout()); 
		    
		    LayoutContainer layoutContainer = new LayoutContainer(); 
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer.setLayout(frmlytSch);
	  
	        //부서콤보 
	        srhDeptCd = new MSFMultiComboBox<ModelData>();
	        srhDeptCd.setName("srhDeptCd");
	       // srhDeptCd.setForceSelection(true);
	       // srhDeptCd.setMinChars(1);
	        //srhDeptCd.setDisplayField("deptNmRtchnt");
	        //srhDeptCd.setValueField("deptCd");
	       // srhDeptCd.setTriggerAction(TriggerAction.ALL);
	        srhDeptCd.setEmptyText("--부서선택--");
	       // srhDeptCd.setSelectOnFocus(true); 
	       // srhDeptCd.setReadOnly(false);
	      //  srhDeptCd.setEnabled(true); 
	        //srhDeptCd.setStore(lsDeptCd );
	        //srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
	        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
	        srhDeptCd.getStore().add(mDtalistDeptCd);
	        srhDeptCd.setWidth(100);
	        srhDeptCd.setFieldLabel("부서");
	        srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	        srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	        srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	            public void handleEvent(StoreEvent<ModelData> be) {  
	            	 EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkPayr410004Auth("srhDeptCd", lsDeptCd); 
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
	                                 //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
	                                }
	                            });    
	                      
	                      } else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
       	            		 
                        	  //2015.11.30 권한 직종가져오기  추가 
   	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
   	            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
   	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
   	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
   	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
   	           	             
   	                             mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
   	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
   	                              
   	                           }
   	                       });  
                	    
		                  } else {
		                	  
		                	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		                	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		             		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            	            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	             
		                              mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		                              srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		                               
		                            }
		                        });   
		                  }
	                      
	                  }  
	          
	                });  
	         
	        srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {   
	                
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
	                   // GWT.log(" a" + ce.getEvent().getType());
	                    mutilCombo = true;
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                    mutilCombo = true;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                    mutilCombo = false;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                } 
	               
	                //new SelectionChangedListener<ModelData>() {
	         //@Override
	         //public void selectionChanged(SelectionChangedEvent<ModelData> se) {
	         //.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
	         //  public void selectionChanged(SelectionChangedEvent<ModelData> se) {
	            
	                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	             BaseModel bmPayCd =  se.getSelectedItem(); 
//	             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//	                 if (bmPayCd != null) {  
//	                    
//	                     sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//	                     sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//	                 }      
//	              
//	                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                   lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                  //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                   srhBusinCd.setStore(lsBusinCd); 
//	                   srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                       public void handleEvent(StoreEvent<BaseModel> be) {  
//	                        //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                       }
//	                   });    
//	             
//	             }  
	            
	            } 
	        });
//	          srhDeptCd.getCheckBoxListHolder().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) { 
//	           //.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
//	           //    public void selectionChanged(SelectionChangedEvent<ModelData> se) {
//	                  
//	                  if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	                      Window.alert("Single click");
//	                  }
//	                   
//	                 GWT.log("v " + ce.getEvent().getType());
//	                 
//	              //  srhDeptCd.showClose(ce);
//	                   //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
////	                BaseModel bmPayCd =  se.getSelectedItem(); 
////	                if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
////	                    if (bmPayCd != null) {  
////	                       
////	                        sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
////	                        sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
////	                    }      
////	                 
////	                    //--------------------사업 불러 오는 함수 -------------------------------------------------
////	                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
////	                     //--------------------사업 불러 오는 함수 -------------------------------------------------
////	                      srhBusinCd.setStore(lsBusinCd); 
////	                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
////	                          public void handleEvent(StoreEvent<BaseModel> be) {  
////	                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
////	                          }
////	                      });    
////	                
////	                }  
//	               
//	               } 
//	           });
//	        srhDeptCd.addBlurHandler(new BlurHandler()
//	        {
//	          @Override
//	          public void onBlur(BlurEvent event)
//	          {
//	              Timer delayTimer = new Timer()
//	              {
//	                @Override
//	                public void run()
//	                {
//	                   //do stuff
//	                }
//	              };
//	              delayTimer.schedule(300);
//	           }
//	      });
	        layoutContainer.add(srhDeptCd, new FormData("100%"));  
//	        //검색 소속부서 코드 처리  
//	        LayoutContainer lccmlcDeptNm = new LayoutContainer();
//	        lccmlcDeptNm.setLayout(new ColumnLayout());
//	           //부서 
//	        srhDeptCd = new TextField<String>();
//	        srhDeptCd.setName("srhDeptCd");
//	        srhDeptCd.setVisible(false);
//	        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//	            @Override
//	            public void handleEvent(BaseEvent be) { 
//	              if(srhDeptCd.getValue() != null){ 
//	                 
//	                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//	                      sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date())); 
//	                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//	                  
//	                    //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                      srhBusinCd.setStore(lsBusinCd); 
//	                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                          public void handleEvent(StoreEvent<BaseModel> be) {  
//	                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                          }
//	                      });    
//	                 
//	              } 
//	            }
//	         });
//	        cpPayr4104.add(srhDeptCd);
//	        srhMangeDeptCd = new TextField<String>();
//	        srhMangeDeptCd.setName("srhMangeDeptCd");
//	        srhMangeDeptCd.setVisible(false);
//	        cpPayr4104.add(srhMangeDeptCd);
//	        srhMangeDeptNm = new TextField<String>();
//	        srhMangeDeptNm.setName("srhMangeDeptNm");
//	        srhMangeDeptNm.setVisible(false);
//	        cpPayr4104.add(srhMangeDeptNm);
	//  
//	         LayoutContainer lcDeptNm = new LayoutContainer(); 
//	         frmlytSch = new FormLayout();
//	         frmlytSch.setLabelWidth(70);
//	         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//	         lcDeptNm.setLayout(frmlytSch);
//	      
//	         srhDeptNm = new TextField<String>();
//	         srhDeptNm.setName("srhDeptNm");
//	         srhDeptNm.setFieldLabel("부서");  
//	         srhDeptNm.addKeyListener(new KeyListener() {
//	              public void componentKeyUp(ComponentEvent event) {
//	                  super.componentKeyUp(event); 
//	                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                      if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                          srhDeptCd.setValue("");
//	                          srhMangeDeptCd.setValue("");
//	                      }
//	                      fnPopupCommP140(srhDeptNm.getValue());
//	                  }
//	              }
//	          });
//	         
//	         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	                    @Override
//	                    public void handleEvent(BaseEvent be) { 
//	                         
//	                        if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                            srhDeptCd.setValue("");
//	                            srhMangeDeptCd.setValue("");
//	                        }
//	                     
//	                    } 
//	           });        
//	          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//	          
//	           btnSrhDeptCd = new Button();
//	           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//	           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//	               public void handleEvent(ButtonEvent e) { 
//	                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                       srhDeptCd.setValue("");
//	                       srhMangeDeptCd.setValue("");
//	                   }
//	                   fnPopupCommP140(srhDeptNm.getValue()); 
//	               }
//	           });
//	            
//	           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//	           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	        
//	        layoutContainer.add(lccmlcDeptNm, new FormData("100%"));
	        layoutContainer.setBorders(false);
	         
	        
		    LayoutContainer layoutContainer_2 = new LayoutContainer(); 
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_2.setLayout(frmlytSch);
		    
		  //직종 직종세처리  
	        LayoutContainer lcTypOccuCd = new LayoutContainer();
	        lcTypOccuCd.setLayout(new ColumnLayout());
	           
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_21.setLayout(frmlytSch); 
	        
//	        srhTypOccuCd = new ComboBox<BaseModel>(); 
//	        srhTypOccuCd.setName("srhTypOccuCd");
//	        srhTypOccuCd.setForceSelection(true);
//	        srhTypOccuCd.setMinChars(1);
//	        srhTypOccuCd.setDisplayField("typOccuNm");
//	        srhTypOccuCd.setValueField("typOccuCd");
//	        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	        srhTypOccuCd.setEmptyText("--직종선택--");
//	        srhTypOccuCd.setSelectOnFocus(true); 
//	        srhTypOccuCd.setReadOnly(false);
//	        srhTypOccuCd.setEnabled(true); 
//	        srhTypOccuCd.setStore(lsTypOccuCd); 
//	        srhTypOccuCd.setFieldLabel("직 종");  
//	        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                //직종변경에 따른 직종세 값 가져오기
//	                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//	                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//	                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//	                    sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//	                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//	                        LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//	                        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//	                    }
//	                }   
//	            } 
//	        }); 
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	        srhTypOccuCd.setFieldLabel("직종");
	        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	            public void handleEvent(StoreEvent<ModelData> be) {  
	            	
	            	 EventType type = be.getType();
			    	   if (type == Store.Add) { 
			    		   //2015.11.30 추가 
			    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
	             	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
			                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
			                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
			                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
			                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
			                      //         mdSelect = tpMdSelect;
			                         //  } 
			                     //  }  
			                   
			                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
			                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
			                   // }  
			                    
	                    }  }
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	//checkPayr410004Auth("srhTypOccuCd", lsTypOccuCd); 
	                	 }
	                
	            }
	        });     
	        
	        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	           @Override
	          public void handleEvent(ComponentEvent ce) { 
	        	   //2015.11.30 추가 
	            	 displayDtilOccuInttnCd(); 
	            	 
	                      
	                  }  
	          
	                });  
	         
	        srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {   
	                
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
	                   // GWT.log(" a" + ce.getEvent().getType());
	                    mutilCombo = true;
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                    mutilCombo = true;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                    mutilCombo = false;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                }  
	            
	            } 
	        });
	        
		      //2015.11.30 추가 
		        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
		            @Override
		            public void handleEvent(BaseEvent ce) {   
		            	
		            	displayDtilOccuInttnCd();
		            } 
		        }); 
	        layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
	        
	        LayoutContainer lcSchRight = new LayoutContainer();
	      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(1); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        frmlytSch.setDefaultWidth(0);
	       // fieldSet.setLayout(layout);  
	        lcSchRight.setLayout(frmlytSch);
	        
	        /** column 직종세코드 : dtilOccuInttnCd */
//	        srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//	        srhDtilOccuInttnCd.setForceSelection(true);
//	        srhDtilOccuInttnCd.setMinChars(1);
//	        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//	        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//	        srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//	        srhDtilOccuInttnCd.setSelectOnFocus(true); 
//	        srhDtilOccuInttnCd.setReadOnly(false);
//	        srhDtilOccuInttnCd.setEnabled(true);  
//	        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
	      //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//	        srhDtilOccuInttnCd.setLabelSeparator("");
	        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
	        srhDtilOccuInttnCd.setWidth(100);
	        srhDtilOccuInttnCd.setFieldLabel("");
	        srhDtilOccuInttnCd.setLabelSeparator("");
	        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
	        srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {    
	               
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
	                    mutilCombo = true;
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                    mutilCombo = true;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                    mutilCombo = false;
	                  //  GWT.log(" b" + ce.getEvent().getType());
	                } else {
	                   
	                }  
	            
	            } 
	        });
	        
	        lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%")); 
	        
	        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 
	        layoutContainer_21.setBorders(false);
	        
		    layoutContainer_2.add(lcTypOccuCd, new FormData("100%"));
		    layoutContainer_2.setBorders(false);
		    
		    
//		    LayoutContainer layoutContainer_10 = new LayoutContainer(); 
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(40); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_10.setLayout(frmlytSch);
//	        
//	        srhTypOccuCd =  new ComboBox<BaseModel>(); 
//	        srhTypOccuCd.setName("srhTypOccuCd");
//	        srhTypOccuCd.setForceSelection(true);
//	        srhTypOccuCd.setMinChars(1);
//	        srhTypOccuCd.setDisplayField("typOccuNm");
//	        srhTypOccuCd.setValueField("typOccuCd");
//	        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	        srhTypOccuCd.setEmptyText("--직종선택--");
//	        srhTypOccuCd.setSelectOnFocus(true); 
//	        srhTypOccuCd.setReadOnly(false);
//	        srhTypOccuCd.setEnabled(true); 
//	        srhTypOccuCd.setStore(lsTypOccuCd);
//	        srhTypOccuCd.setFieldLabel("직종");
//	        layoutContainer_10.add(srhTypOccuCd, new FormData("100%"));
//	        layoutContainer_10.setBorders(false);
	        
		    LayoutContainer layoutContainer_4 = new LayoutContainer(); 
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(40); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_4.setLayout(frmlytSch);
		    
		    srhBusinCd = new ComboBox<BaseModel>();
		    srhBusinCd.setName("srhBusinCd");
		    srhBusinCd.setForceSelection(true);
		    srhBusinCd.setMinChars(1);
		    srhBusinCd.setDisplayField("businNm");
		    srhBusinCd.setValueField("businCd");
		    srhBusinCd.setTriggerAction(TriggerAction.ALL);
		    srhBusinCd.setEmptyText("--사업선택--");
		    srhBusinCd.setSelectOnFocus(true); 
		    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
		    srhBusinCd.setStore(lsBusinCd);
		    srhBusinCd.setFieldLabel("사업");
		    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
		    fieldSet.add(layoutContainer_13);
		    layoutContainer_13.setBorders(false);
		    
		    
		    layoutContainer_13.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		   // layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    
//		    LayoutContainer layoutContainer_3 = new LayoutContainer();
//		    layoutContainer_3.setLayout(new ColumnLayout());
//		    
//		    layoutContainer_3.add(layoutContainer_1);
//		    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		    layoutContainer_3.setBorders(false);
//	        
//		    fieldSet.add(layoutContainer_3);  
			
		  cpPayr4104.add(fieldSet); 
		   
	  }  
	   
	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
             
             //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                 
                 sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                 List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                 String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                 sysComBass0350Dto.setDeptCd(strDeptCd);
                 List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                 String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                 sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                 
                // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                 
                 if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                     
                     lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                   //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                     
                     lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                         public void handleEvent(StoreEvent<BaseModel> be) {  
                             mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
                             srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                             
                             if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
                         	    ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
		  		                   
		  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
		  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
		  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
		  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
		  		                      //         mdSelect = tpMdSelect;
		  		                         //  } 
		  		                     //  }  	
		  		                   
                         	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
                         	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
		  		                   // }  
     	                 } 
                         }
                     });     
                     
                 } 
              
           } else {
            
           } 
         //직종변경에 따른 직종세 값 가져오기
//         String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//         if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//             sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//             sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//             if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                 lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                 srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//             }
//         }   
	  }
	  private  void createStandardForm() {
		  
		  LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset_2 = new FieldSet();
		//	fldstNewFieldset_2.setSize(528, 120);
			layoutContainer_2.add(fldstNewFieldset_2);
			fldstNewFieldset_2.setHeadingHtml("소득세율정보");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(createCheckBoxGrid(),new FormData("100%"));
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
			 
			    
			cpPayr4104.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   

	  private LayoutContainer createCheckBoxGrid() {    
	  	   
//		    List<Stock> stocks = null;//TestData.getStocks();   
//		    
//		    RowNumberer r = new RowNumberer();   
//
//		    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
//		    configs.add(r);   
//
//		    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
//		    // selection model supports the SIMPLE selection mode   
//		    // sm.setSelectionMode(SelectionMode.SIMPLE);   
//		  
//		    configs.add(sm.getColumn());   
//		  
//		    ColumnConfig column = new ColumnConfig();   
//		    column.setId("name");   
//		    column.setHeaderText("납부년월");  
//		    column.setAlignment(HorizontalAlignment.CENTER); 
//		    column.setWidth(100);   
//		    configs.add(column);   
//		  
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("고용구분");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);  
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("부서");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig();   
//		    column.setId("symbol");   
//		    column.setHeaderText("성명");  
//		    column.setAlignment(HorizontalAlignment.CENTER); 
//		    column.setWidth(100);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("주민등록번호");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("표준보수월액");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		    
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("등급");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    
//		    column = new ColumnConfig("change", "연금보험료", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		    
//
//		    column = new ColumnConfig("change", "정산보험료", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		  
//
//		    column = new ColumnConfig("change", "소급보험료", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		  
//
//		    column = new ColumnConfig("change", "합계", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		     
//		  
//
//		    column = new ColumnConfig("change", "직종(사업)", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		  
//
//		    column = new ColumnConfig("change", "직종세", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		   
//		    
//		    ListStore<Stock> store = new ListStore<Stock>();   
//		    store.add(stocks);   
//		  
//		    ColumnModel cm = new ColumnModel(configs);    
//		    
//		    ContentPanel cp = new ContentPanel();   
//		    cp.setHeaderVisible(false);
//		    cp.setFrame(true);   
//		   // cp.setIcon(Resources.ICONS.table());   
//		    cp.setLayout(new FitLayout());   
//		    cp.setSize(800, 300);   
//		  
//		    Grid<Stock> grid = new Grid<Stock>(store, cm);   
//		    grid.setSelectionModel(sm);   
//		    grid.setBorders(true);   
//		    grid.setColumnReordering(true);   
//		    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
//		    grid.addPlugin(sm);   
		      
		  
		  
		    LayoutContainer lcStdGrid = new LayoutContainer();
		    lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		    lcStdGrid.setStyleAttribute("paddingRight", "5px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(960, 510);   //478
		    
		    //msfCustomForm.setHeaderVisible(false);
		    //Instantiate the GridPanel
		    pPayr0500GridPanel = new MSFGridPanel(pPayr0500Def, false, false, false, false, false);
		    pPayr0500GridPanel.setHeaderVisible(false);  
		    pPayr0500GridPanel.setBodyBorder(true);
		    pPayr0500GridPanel.setBorders(true);
			// pPayr0500GridPanel.setSize(308, 466); 
		    // msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

		    final Grid payr0500Grid = pPayr0500GridPanel.getMsfGrid().getGrid(); 
		    payr0500Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
	              public void handleEvent(BaseEvent be) {  
	            	  if (pPayr0500GridPanel.getCurrentlySelectedItem() != null) {  
	            		  setRecord(pPayr0500GridPanel.getCurrentlySelectedItem());	
	            		  actionDatabase = ActionDatabase.UPDATE;
	            	  }
	              }
	          });  
		    
		    cpGrid.add(pPayr0500GridPanel); 
		    lcStdGrid.add(cpGrid);   
		 
		    return lcStdGrid;
		     
		  }    
		  

		   private void createBtnTop() {
				 
				 
			    topPayrP410004Bar = new ButtonBar();    
				topPayrP410004Bar.setAlignment(HorizontalAlignment.RIGHT);
	   
			  
				btnPayrP410004Init = new Button("초기화");  
			    btnPayrP410004Init.setIcon(Resources.APP_ICONS.new16());
			    topPayrP410004Bar.add(btnPayrP410004Init);
			    btnPayrP410004Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		        });  
			     
			  	 
			    btnPayrP410004Save = new Button("저장");  
			    btnPayrP410004Save.setIcon(Resources.APP_ICONS.save16());
		        topPayrP410004Bar.add(btnPayrP410004Save); 
		        btnPayrP410004Save.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 saveStandData(); 
		    		}
		    	});
		        
		        btnPayrP410004Del = new Button("취소");  
//		        btnPayrP410004Del.setIcon(Resources.APP_ICONS.delete16());
		        btnPayrP410004Del.setIcon(Resources.APP_ICONS.actionRefresh());
		  	    topPayrP410004Bar.add(btnPayrP410004Del);
		  	    btnPayrP410004Del.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
		  	  
		  	    btnPayrP410004Sreach = new Button("조회"); 
		  	    btnPayrP410004Sreach.setIcon(Resources.APP_ICONS.search16());
		  	    topPayrP410004Bar.add(btnPayrP410004Sreach);
		  	    btnPayrP410004Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
		  	    
//		  	  btnPayrP410004Print = new Button("인쇄"); 
//		  	 btnPayrP410004Print.setIcon(Resources.APP_ICONS.print16()); 
//		  	 topPayrP410004Bar.add(btnPayrP410004Print);  
//		  	  btnPayrP410004Print.addListener(Events.Select, new Listener<ButtonEvent>() {
//		    		public void handleEvent(ButtonEvent e) {
//		    			//인쇄 
//		    		}
//		    	});
		  	
		  	    //TODO 170403 다은
		  	    // 기능구현 안되어있어서 일단 주석처리 해둠.
		  	    btnPayrP410004Excel = new Button("엑셀"); 
		  	    btnPayrP410004Excel.setIcon(Resources.APP_ICONS.excel16()); 
//		  	    topPayrP410004Bar.add(btnPayrP410004Excel);  
		    	  btnPayrP410004Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//엑셀저장  
		    		//	xlsExportData() ;
		    		}
		    	});
			  	 
		      
			  	cpPayr4104.add(topPayrP410004Bar);    
			  	
			 }  
		   
			public void reload() {
				// TODO Auto-generated method stub
				formInit(); 
				IColumnFilter filters = null;
				 
				pPayr0500GridPanel.getTableDef().setTableColumnFilters(filters);
				
				pPayr0500GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				pPayr0500GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			
			     String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	             pPayr0500GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	          // pPayr0500GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd")), SimpleColumnFilter.OPERATOR_EQUALS); 
	            
	             String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	             pPayr0500GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	           //pPayr0500GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
	          //   String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
	          //   pPayr0500GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
	           //pPayr0500GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	             String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	             pPayr0500GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	           //pPayr0500GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
		         
				pPayr0500GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				  
			//	pPayr0500GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(srhHdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				 
			   String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
			   if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
	    	           String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
	    	           String chkkey = "";
	    	           for (int i=0; i<ray.length; i++){ 
	    	               BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
	    	               chkkey += bmData.get("commCd")+","; 
	    	           }
	    	           strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
			   } 
		        pPayr0500GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	             
				pPayr0500GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				pPayr0500GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
				pPayr0500GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
				 
				 
				pPayr0500GridPanel.reload();
				
				actionDatabase = ActionDatabase.UPDATE; 
			}
			
			
			//폼초기화 검색조건포함 
		   private void formInit() {
			     
			   pPayr0500GridPanel.getMsfGrid().clearData();
			  
			   actionDatabase = ActionDatabase.UPDATE;
			   
			   
		   }
		    
		   public void setListRecord(Iterator<Record> records) {
		         this.records = records;
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
		   
	 private void fnPopupPsnl0100()  {
	           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	           //검색.처리하면됨.
	          MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
	          //  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호 
	           
	           final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	           
	           popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	               public void handleEvent(BaseEvent be) {
	                   BaseModel mapModel = (BaseModel)be.getSource();
	                   if (!"".equals(mapModel.get("systemkey"))) { 
	                        
	                       srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
	                       srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
	                       srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
	                   }  
	                  
	               }
	           });
	   }
	 
	   
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 
	 
//	  private void xlsExportData() {
//	       
//	        //  MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
//	          //    @Override
//	          //    public void handleEvent(MessageBoxEvent be) {
//	          //        if("Yes".equals(be.getButtonClicked().getText())){
//	                      
//		  				  HashMap<String, String> param = new HashMap<String, String>(); 
//        
//		  				  String year = PayrUtils.getSelectedComboValue(srhPayYr,"year");
//		  	              String month = PayrUtils.getSelectedComboValue(srhPayMonth,"month");
//		  	               
//		  
//						  String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
//						   if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
//				   	           String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
//				   	           String chkkey = "";
//				   	           for (int i=0; i<ray.length; i++){ 
//				   	               BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
//				   	               chkkey += bmData.get("commCd")+","; 
//				   	           }
//				   	           strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
//						   } 
//					      
//						   param.put("pymtYrMnth", year.concat(month));
//							
//				           param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//				           param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
//				           param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
//				           param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
//				           param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
//				           param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//				           param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
//				           param.put("hdofcCodtnCd", strHdofcCodtnCd);
//				           param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
//				           param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
//				           param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
//	                      
//	                      
//	                      
//	                      if("".equals(year) || "".equals(month)){
//	                          MessageBox.info("", "납부년월은 필수 입니다.", null);
////	                      } else if("".equals(payCd)){
////	                          MessageBox.info("", "급여구분은 필수 입니다.", null);
////	                      }else if("".equals(workDayS) || "".equals(workDayE)){
////	                          MessageBox.info("", "근태기간은 필수 입니다.", null);
////	                          
////	                      } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
////	                    	  
////	                    	  if("".equals(businCd)){ 
////	                     			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
////	              	                         "사업명을 선택하십시요.", null);
////	                       		 
////	               		     } else { 
////	                         
////	                          insr4100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr3100TempExport.do","extgwtFrame" ,param);   
////	               		     }
// 	                      }else{  
//				           pPayr0500GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayrP410004Export.do","extgwtFrame" ,param);  
//	                      }
//	            //      }
//	        //      }
//	              
//	       //   });
//	           
//	          
//		  }	 
		   
	  
	 

}
