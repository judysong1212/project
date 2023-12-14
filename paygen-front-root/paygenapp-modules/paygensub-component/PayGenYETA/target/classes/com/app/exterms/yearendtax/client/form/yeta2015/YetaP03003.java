/**
 * 기부금내역등록
 */
package com.app.exterms.yearendtax.client.form.yeta2015;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3180DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta3180Def;
import com.app.exterms.yearendtax.client.service.yeta2015.YetaP03003Service;
import com.app.exterms.yearendtax.client.service.yeta2015.YetaP03003ServiceAsync;
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
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP03003   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta03003; 
	  
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
	private MSFGridPanel yetaP03003GridPanel;
//	private Yeta0300Def yeta0300Def_08  = new Yeta0300Def("YETA03008");	//가족교육비 그리드 테이블 컬럼 define 
	private Yeta3180Def yetaP03003ToYeta3180  = new Yeta3180Def("YETAP03003");	//가족교육비 그리드 테이블 컬럼 define 
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
	
	private Iterator<Record> records;
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
  	private  ButtonBar topYetaBtnBar = new ButtonBar();
	private  Button btnYetaNew = new Button();	//신규
	private  Button btnYetaDel = new Button();	//삭제
	private  Button btnYetaSave = new Button();	//저장
	private  Button btnYetaClose = new Button();//닫기

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhEdacRvyy;		// 년도
 	private ComboBox<BaseModel> srhSettGbcd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
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
	private YetaP03003ServiceAsync yetaP03003Service = YetaP03003Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 	
	 	
	    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
 
	     
		/**
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
		
		//버튼에 따른 Action
		private void doAction(ActionDatabase actionDatabase) {
			switch (actionDatabase) {
				case INSERT:
					this.actionDatabase = ActionDatabase.INSERT;
					yetaP03003FormSave();
					break;
				case UPDATE:
					this.actionDatabase = ActionDatabase.UPDATE;
					yetaP03003FormSave();
					break;
				case DELETE:
					this.actionDatabase = ActionDatabase.DELETE;
					yetaP03003FormSave();
					break;
			}
		}
		
		
		private void yetaP03003FormSave() {  
			if (MSFSharedUtils.paramNotNull(records)) { 
	              
				List<Yeta3180DTO> listYeta3180dto = new ArrayList<Yeta3180DTO>();  
	                
				while (records.hasNext()) {
	              
					Record record = (Record) records.next(); 
	                BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
	                Yeta3180DTO yeta3180Dto= new Yeta3180DTO();  
	                      
	                yeta3180Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
	                yeta3180Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** SYSTEMKEY : systemkey */
	                yeta3180Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
	                yeta3180Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
	                
	                yeta3180Dto.setCtrbSeqn((Long) bmMapModel.get("ctrbSeqn"));			/** column 기부내역일련번호 : ctrbSeqn */
	                
	                yeta3180Dto.setCtrbDdcd(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbDdcd$commCd")));/** column 기부유형구분코드 : ctrbDdcd */
	                yeta3180Dto.setCtrbTycd(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbTycd")));    	/** column 기부유형코드 : ctrbTycd */
	                yeta3180Dto.setCtrbCont(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbCont")));    	/** column 기부내용 : ctrbCont */
	                yeta3180Dto.setCtrbYrmn(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbYrmn")));    	/** column 기부연도 : ctrbYrmn */
	                yeta3180Dto.setCtrbName(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbName")));    	/** column 기부처명 : ctrbName */
	                yeta3180Dto.setCtrbBsnu(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbBsnu")));    	/** column 기부처사업자번호 : ctrbBsnu */
	                yeta3180Dto.setCrtbCncd(MSFSharedUtils.allowNulls(bmMapModel.get("crtbCncd$commCd")));    	/** column 기부자관계구분코드 : crtbCncd */
	                yeta3180Dto.setCbtgName(MSFSharedUtils.allowNulls(bmMapModel.get("cbtgName")));    	/** column 기부자성명 : cbtgName */
	                yeta3180Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 주민등록번호 : rsnoNumb */
	                yeta3180Dto.setCtrbSeqn((Long) bmMapModel.get("ctrbSeqn"));    		/** column 기부내역일련번호 : ctrbSeqn */
	                yeta3180Dto.setCtrbCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbCtnt")));    	/** column 건수 : ctrbCtnt */
	                yeta3180Dto.setCtrbAmnt((Long) bmMapModel.get("ctrbAmnt")); 		/** column 기부금액 : ctrbAmnt */
	                
	                listYeta3180dto.add(yeta3180Dto);
				}  
	                
				if (listYeta3180dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
	                
				yetaP03003Service.activityOnYetaP03003ToYeta3180(listYeta3180dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP03001ToYeta3180(" + actionDatabase.name() + ") : " + caught), null);
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
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++ 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++
		 * ++++++++++++++++++++++++++++++++++++++++
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
	  
	  public YetaP03003(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
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
		   
	        cpYeta03003 = new ContentPanel();  

		    createSearchForm();		//기본정보 필드를 적용
	        createMsfGridForm();	//그리드필드
		    createStandardForm();   //기본정보필드   
		   
		    /**
		     * TODO 급여대상자에 따른 수당,공제,급여조정부분을 자동으로 불러오는 부분을 추가 한다...단계별진행........
	          * Create the relations 
	          */
	           
		   cpYeta03003.setBodyBorder(false);
		   cpYeta03003.setBorders(false);
		   cpYeta03003.setHeaderVisible(false);
		   cpYeta03003.setSize("790px", "640px");
		   
		   this.add(cpYeta03003);
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
			cpYeta03003.add(systemkey);
			
		    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		    dpobCd.setName("dpobCd");
		    cpYeta03003.add(dpobCd);
		    
		    edacRvyy = new HiddenField<String>();	/** column 정산년도 : edacRvyy */
		    edacRvyy.setName("edacRvyy");
		    cpYeta03003.add(edacRvyy);
		    
		    settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
		    settGbcd.setName("settGbcd");
		    cpYeta03003.add(settGbcd);
		    
		    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		    deptNm.setName("deptNm");
		    cpYeta03003.add(deptNm);
		    
		    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		    hanNm.setName("hanNm");
		    cpYeta03003.add(hanNm);
				
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
			        

			cpYeta03003.setLayout(new FlowLayout());

			topYetaBtnBar = new ButtonBar();
			topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

			btnYetaNew = new Button("신규");
			btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
			btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					actionDatabase = ActionDatabase.INSERT;
					
					//테스트용
//					dpobCd.setValue(" ");
//					systemkey.setValue("20080013");
					
					actionDatabase = ActionDatabase.INSERT;
					
					if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		 	    		 return;
		      	     }
					 
					yetaP03003GridPanel.getMsfGrid().clearData();
					 
					 BaseModel bmData = yetaP03003GridPanel.getTableDef().getDefaultValues();  
			              
			         bmData.set("dpobCd", dpobCd.getValue()); 		/** column 사업장코드 : dpobCd */
			         bmData.set("systemkey", systemkey.getValue()); /** column SYSTEMKEY : systemkey */
			         bmData.set("edacRvyy", edacRvyy.getValue());   /** column 연말정산귀속년도 : edacRvyy */
			         bmData.set("settGbcd", settGbcd.getValue());   /** column 정산구분코드 : settGbcd */
			         
			         
			         bmData.set("ctrbCont", "");    /** column 기부내용 : ctrbCont */
			         bmData.set("ctrbName", "");    /** column 기부처명 : ctrbName */
			         bmData.set("ctrbBsnu", "");    /** column 기부처사업자번호 : ctrbBsnu */
			         bmData.set("crtbCncd", "");    /** column 기부자관계구분코드 : crtbCncd */
			         bmData.set("cbtgName", "");    /** column 기부자성명 : cbtgName */
			         bmData.set("rsnoNumb", "");    /** column 주민등록번호 : rsnoNumb */
			         bmData.set("ctrbAmnt", 0L);    /** column 기부금액 : ctrbAmnt */
			         bmData.set("ctrbSeqn", 0L);    /** column 기부내역일련번호 : ctrbSeqn */
			         bmData.set("ctrbYrmn", "");    /** column 기부연도 : ctrbYrmn */
			         
			         
			         bmData.set("ctrbDdcd", "");    /** column 기부유형구분코드 : ctrbDdcd */
			         bmData.set("ctrbTycd", "");    /** column 기부유형코드 : ctrbTycd */
			        
			        
//			         bmData.set("crnrFlag", "");    /** column 기부자내국인구분코드 : crnrFlag */
//			         bmData.set("ctrbCtnt", "");    /** column 기부금유형콤보TEMP : ctrbCtnt */
			         
			         
			         yetaP03003GridPanel.getMsfGrid().getGrid().stopEditing();      
			         yetaP03003GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			         yetaP03003GridPanel.getMsfGrid().getGrid().startEditing(yetaP03003GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
					
//					doAction(actionDatabase);
				}
			});
				
			topYetaBtnBar.add(btnYetaNew);

			btnYetaDel = new Button("삭제");
			btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
			btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					Iterator<BaseModel> itBm = yetaP03003GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
					List<Record> lsRec = new ArrayList<Record>();
					
					if((ActionDatabase.INSERT).equals(actionDatabase)) {
						yetaP03003GridPanel.getMsfGrid().clearData();
						
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
					setListRecord(yetaP03003GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
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
					
			cpYeta03003.add(topYetaBtnBar);
			  	
			  	
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
			srhEdacRvyy.setReadOnly(true);
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
			srhSettGbcd.setReadOnly(true);
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

			cpYeta03003.add(fieldSet);
			
	}    
	 	 
	private void createStandardForm() {
		
		LayoutContainer lcFormLayer = new LayoutContainer();
		  
		  ContentPanel cp01 = new ContentPanel();   
		  cp01.setBodyBorder(false); 
		  cp01.setHeaderVisible(false);   
		  cp01.setLayout(new FitLayout());      
		  cp01.setSize(800, 300);  
		  
		  LayoutContainer layoutContainer = new LayoutContainer();
	      
	      LayoutContainer layoutContainer_1 = new LayoutContainer();
	      
	      LabelField lblfldNewLabelfield = new LabelField("유형 항목을 선택하시면 콤보에서 선택 하는 화면이 나타 납니다.");
	      layoutContainer_1.add(lblfldNewLabelfield);
	      layoutContainer.add(layoutContainer_1);
	      layoutContainer_1.setBorders(false);
	      
	      LayoutContainer layoutContainer_2 = new LayoutContainer();
	      
	      LabelField lblfldNewLabelfield_1 = new LabelField("기부자는 팝업에서 선택하도록 했습니다. 기부자성명 항목을 선택하면 팝업 버튼이 나타납니다.");
	      layoutContainer_2.add(lblfldNewLabelfield_1);
	      layoutContainer.add(layoutContainer_2);
	      layoutContainer_2.setBorders(false);
	      
	      
	      cp01.add(layoutContainer);
	      lcFormLayer.add(cp01);
	      cpYeta03003.add(lcFormLayer);
	      
//	      return lcFormLayer;	  
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
		
		
//		private LayoutContainer createMsfGridForm() {
		private void createMsfGridForm() {
			
			ContentPanel cp01 = new ContentPanel();   
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());
			cp01.setSize(790, 420);

			
			yetaP03003GridPanel = new MSFGridPanel(yetaP03003ToYeta3180, false, false, false, false, false);
			yetaP03003GridPanel.setHeaderVisible(false);  
			yetaP03003GridPanel.setSize("790px", "420px");
			yetaP03003GridPanel.setBorders(true);
			yetaP03003GridPanel.setHeaderVisible(false);
			yetaP03003GridPanel.getBottomComponent().setVisible(false);
			
			
			/** --- 그리드 합계 부분  시작 --- **/
//			AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//			 
//			payrSummaryRow.setCellStyle(Yeta3180BM.ATTR_CTRBCTNT,"summary_color");	/** set 기부금유형콤보TEMP : ctrbCtnt */
//			payrSummaryRow.setCellStyle(Yeta3180BM.ATTR_CTRBAMNT,"summary_color");	/** set 기부금액 : ctrbAmnt */
//								    
//			payrSummaryRow.setSummaryType(Yeta3180BM.ATTR_CTRBCTNT, SummaryType.SUM);   
//			payrSummaryRow.setSummaryFormat(Yeta3180BM.ATTR_CTRBCTNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
//								    
//			payrSummaryRow.setSummaryType(Yeta3180BM.ATTR_CTRBAMNT, SummaryType.SUM);   
//			payrSummaryRow.setSummaryFormat(Yeta3180BM.ATTR_CTRBAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
//			
//			yetaP03003GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
			/** --- 그리드 합계 부분  종료 --- **/
			

			cp01.add(yetaP03003GridPanel);
			
			cpYeta03003.add(cp01);
			
		}	
		
		
		public void setListRecord(Iterator<Record> records) {
		    this.records = records;
		} 
		
		@Override
		public void reload() {
			
				// TODO Auto-generated method stub
				IColumnFilter filters = null;
				
				yetaP03003GridPanel.getTableDef().setTableColumnFilters(filters);
				yetaP03003GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
	//			yetaP03001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
	//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
				yetaP03003GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
						, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
				yetaP03003GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
						, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
			 
				yetaP03003GridPanel.reload();
			
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
