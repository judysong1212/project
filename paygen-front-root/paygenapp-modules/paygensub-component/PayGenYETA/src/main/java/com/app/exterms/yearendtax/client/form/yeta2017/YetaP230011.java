/**
 * 교육비내역등록
 */
package com.app.exterms.yearendtax.client.form.yeta2017;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115BM;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161090BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161090DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye164010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.Ye161090Def;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP230011Service;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP230011ServiceAsync;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23002Service;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23002ServiceAsync;
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
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP230011   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta230011; 
	  
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
	private MSFGridPanel yeta2300ToYe161090GridPanel01;		// 가족교육비 GridPanel (기타자료)
	private MSFGridPanel yeta2300ToYe161090GridPanel02;		// 가족교육비 GridPanel (국세청자료)
	private Ye161090Def ye161090Def_01  		= new Ye161090Def("YETA230001");
	private Ye161090Def ye161090Def_02  		= new Ye161090Def("YETA230002");
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
       
  	private ButtonBar topYetaBtnBar = new ButtonBar();
	private Button btnYetaNew = new Button();			//신규
	private Button btnYetaDel = new Button();			//삭제
	private Button btnYetaSave = new Button();			//저장

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhYrtxBlggYr;	// 년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산년도 : yrtxBlggYr */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : clutSeptCd */
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	hanNm;		/**  column 성명 : hanNm */
 	// -------------- 검색 조건 종료 --------------
	
	private YetaP230011ServiceAsync yetaP230011Service = YetaP230011Service.Util.getInstance();
      
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
	private  ListStore<BaseModel> lsclutSeptCd = new ListStore<BaseModel>(); 		// 정산구분
	// -------------- stroe 선언 종료 --------------
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP23002ServiceAsync yetaP23002Service = YetaP23002Service.Util.getInstance();
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
	// 버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			yetaP23002FormSave();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			yetaP23002FormSave();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			yetaP23002FormSave();
			break;
		}
	}
		
		
	private void yetaP23002FormSave() {

		if (MSFSharedUtils.paramNotNull(records)) {

			Boolean dataChk = true;

			List<Ye164010DTO> listYe164010Dto = new ArrayList<Ye164010DTO>();
			
			Ye164010DTO ye164010Dto = new Ye164010DTO();

			while (records.hasNext()) {

				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				ye164010Dto = new Ye164010DTO();
				
				ye164010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
				ye164010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    						/** column 귀속연도 : yrtxBlggYr */
				ye164010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
				ye164010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
				ye164010Dto.setMdxpsSeilNum((Long)bmMapModel.get("mdxpsSeilNum"));    										/** column 의료비지급일련번호 : mdxpsSeilNum */
				
				ye164010Dto.setResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("resnoEncCntn")).replaceAll("-", "")); /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
				ye164010Dto.setYn( MSFSharedUtils.defaultNulls(bmMapModel.get("yn"), "1") );    							/** column 본인등해당여부 : yn */
				ye164010Dto.setBsnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("bsnoEncCntn")).replaceAll("-", ""));   /** column 지급처사업자등록번호 : bsnoEncCntn */
				ye164010Dto.setPlymNm(MSFSharedUtils.allowNulls(bmMapModel.get("plymNm")));    								/** column 의료비_상호명 : plymNm */
				ye164010Dto.setMdxpsPrfClCd(MSFSharedUtils.allowNulls(bmMapModel.get("mdxpsPrfClCd$commCd")));    			/** column 의료비_의료증빙코드 : mdxpsPrfClCd */
				ye164010Dto.setScnt( MSFSharedUtils.defaultNulls((Long)bmMapModel.get("scnt"), "0") );   					/** column 의료비_건수 : scnt */
				ye164010Dto.setUseAmt( MSFSharedUtils.defaultNulls((Long)bmMapModel.get("useAmt"), "0") );    				/** column 의료비_금액 : useAmt */
				ye164010Dto.setYn2( MSFSharedUtils.defaultNulls(bmMapModel.get("yn2"), "0") );    							/** column 의료비_난임시술비해당여부 : yn2 */				
				
	                
	                
				/** 그리드에 있는 항목에 대해서 입력 체크 **/
				if (MSFSharedUtils.paramNull(ye164010Dto.getResnoEncCntn().replace("-", ""))) {
					MessageBox.alert("경고", "주민번호를 입력해 주세요.", null);
					dataChk = false;
					return;
//				} else if (MSFSharedUtils.paramNull(yeta3140Dto.getCtifTrea())) {
//					MessageBox.alert("경고", "난임여부를 입력해 주세요.", null);
//					dataChk = false;
//					return;
				} else if ( (!"1".equals(ye164010Dto.getYn()) || ye164010Dto.getYn() != "1" ) && (!"2".equals(ye164010Dto.getYn()) || ye164010Dto.getYn() != "2") ) {
					MessageBox.alert("경고", "본인 여부는 1 또는 2만 입력 가능합니다.", null);
					dataChk = false;
					return;
				} else if ( (!"1".equals(ye164010Dto.getYn2()) || ye164010Dto.getYn2() != "1" ) && (!"0".equals(ye164010Dto.getYn2()) || ye164010Dto.getYn2() != "0") ) {
					MessageBox.alert("경고", "난임 여부는 1 또는 0만 입력 가능합니다.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getBsnoEncCntn().replace("-", ""))) {
					MessageBox.alert("경고", "사업자번호를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getPlymNm())) {
					MessageBox.alert("경고", "상호명을 입력해주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getMdxpsPrfClCd())) {
					MessageBox.alert("경고", "의료증빙구분을 입력해주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getScnt())) {
					MessageBox.alert("경고", "지급건수를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getUseAmt())) {
					MessageBox.alert("경고", "지급금액을 입력해 주세요.", null);
					dataChk = false;
					return;
				}

				listYe164010Dto.add(ye164010Dto);
			}
				
				
			if (dataChk) {

				if (listYe164010Dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장",actionDatabase.name()+ "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
					
				yetaP23002Service.activityOnYetaP23002ToYe164010(listYe164010Dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
								, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP23002ToYe164010(" + actionDatabase.name() + ") : " + caught), null);
						}
					
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
								reload01();
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
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++ 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++
		 * ++++++++++++++++++++++++++++++++++++++++
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
	  
	public YetaP230011(final ActionDatabase actionDatabase, final MSFPanel caller) {

		// 콤보 권한초기화
		// initLoad();

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYeta230011 = new ContentPanel();

		createSearchForm(); 	// 기본정보 필드를 적용
//		createStandardForm(); 	// 기본정보필드
		createMsfGridForm(); 	// 그리드필드

		cpYeta230011.setBodyBorder(false);
		cpYeta230011.setBorders(false);
		cpYeta230011.setHeaderVisible(false);
		cpYeta230011.setSize("790px", "700px");

		this.add(cpYeta230011);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "730px");
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
			cpYeta230011.add(systemkey);
			
		    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		    dpobCd.setName("dpobCd");
		    cpYeta230011.add(dpobCd);
		    
		    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
		    yrtxBlggYr.setName("yrtxBlggYr");
		    cpYeta230011.add(yrtxBlggYr);
		    
		    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
		    clutSeptCd.setName("clutSeptCd");
		    cpYeta230011.add(clutSeptCd);
		    
		    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		    deptNm.setName("deptNm");
		    cpYeta230011.add(deptNm);
		    
		    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		    hanNm.setName("hanNm");
		    cpYeta230011.add(hanNm);
				
			sysComBass0300Dto = new PrgmComBass0300DTO();
			msfCoCalendarDto = new SysCoCalendarDTO();
			     
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			sysComBass0300Dto.setRpsttvCd("Y002");
			lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			     
			     
			//--------------------급여년도 불러 오는 함수 ------------------------------------------------
			lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
			//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			     
			        

		cpYeta230011.setLayout(new FlowLayout());

		

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		srhYrtxBlggYr = new TextField<String>();
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setName("yrtxBlggYr");
		// srhYrtxBlggYr.setForceSelection(true);
		// srhYrtxBlggYr.setMinChars(1);
		// srhYrtxBlggYr.setDisplayField("yearDisp");
		// srhYrtxBlggYr.setValueField("year");
		// srhYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		// srhYrtxBlggYr.setEmptyText("--년도선택--");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
		// srhYrtxBlggYr.setStore(lsdacRvyyStore);
		srhYrtxBlggYr.setFieldLabel("년도");
//			srhYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
//				public void handleEvent(StoreEvent<BaseModel> be) {
//					srhYrtxBlggYr.setValue(lsdacRvyyStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
//				}
//			});
				
		lcSchCol01.add(srhYrtxBlggYr, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhClutSeptCd = new ComboBox<BaseModel>();
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setName("srhClutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setEmptyText("--정산구분선택--");
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsclutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
			srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {
					YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
					reload01();
					reload02();
				}
			});
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
				
			lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
				
		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta230011.add(fieldSet);
	}
	 	 
	private void createStandardForm() {
		
		LayoutContainer lcFormLayer = new LayoutContainer();
		  
		ContentPanel cp01 = new ContentPanel();   
		cp01.setBodyBorder(false); 
		cp01.setHeaderVisible(false);   
		cp01.setLayout(new FitLayout()); 
		cp01.setSize("820px", "140px");
		  
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		
	      
		LayoutContainer layoutContainer_4 = new LayoutContainer();
	      
		LabelField lblfldNewLabelfield_2 = new LabelField(" *본인들 해당여부의 체크는 해당사항만 체크해주세요");
		layoutContainer_4.add(lblfldNewLabelfield_2);
		layoutContainer_3.add(layoutContainer_4);
		layoutContainer_4.setBorders(false);
	      
		LayoutContainer layoutContainer_5 = new LayoutContainer();
	      
		LabelField lblfldNewLabelfield_3 = new LabelField(" *해당사항 : 본인 *65세이상 *장애인인경우");
		layoutContainer_5.add(lblfldNewLabelfield_3);
		layoutContainer_3.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);
	      
	    LayoutContainer layoutContainer_6 = new LayoutContainer();
	      
	    LabelField lblfldNewLabelfield_4 = new LabelField(" *미해당사항 : 그 밖의 기본공제대상자");
	    layoutContainer_6.add(lblfldNewLabelfield_4);
	    layoutContainer_3.add(layoutContainer_6);
	    layoutContainer_6.setBorders(false);
	      
	    LayoutContainer layoutContainer_7 = new LayoutContainer();
	      
	    LabelField lblfldNewLabelfield_5 = new LabelField("");
	    layoutContainer_7.add(lblfldNewLabelfield_5);
	    layoutContainer_3.add(layoutContainer_7);
	    layoutContainer_7.setBorders(false);
	      
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	      
	    LabelField lblfldNewLabelfield_6 = new LabelField(" * 의료비 내역 등록 합계는 소득공제에 등록된 의료비와 반드시 같아야 합니다. 입력확인");
	    layoutContainer_8.add(lblfldNewLabelfield_6);
	    layoutContainer_3.add(layoutContainer_8);
	    layoutContainer_8.setBorders(false);
	      
	    LayoutContainer layoutContainer_9 = new LayoutContainer();
	    
	    LabelField lblfldNewLabelfield_7 = new LabelField(" * 의료증빙구분이 국세청장이 제공하는 의료비 자료인 경우, 사업자 번호와 지급건수를 입력하지 않아도 됩니다.");
	    layoutContainer_9.add(lblfldNewLabelfield_7);
	    layoutContainer_3.add(layoutContainer_9);
	    layoutContainer_9.setBorders(false);
	      
	    layoutContainer_3.setBorders(false);
	      
	    cp01.add(layoutContainer_3);
	    lcFormLayer.add(cp01);
	    cpYeta230011.add(lcFormLayer);
	  		
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

	public void reload01() {
			
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
			
		IColumnFilter filters = null;
			
		yeta2300ToYe161090GridPanel01.getTableDef().setTableColumnFilters(filters);
				
		yeta2300ToYe161090GridPanel01.getTableDef().addColumnFilter("dpobCd"		, MSFSharedUtils.allowNulls(dpobCd.getValue())		, SimpleColumnFilter.OPERATOR_EQUALS);
		yeta2300ToYe161090GridPanel01.getTableDef().addColumnFilter("systemkey"		, MSFSharedUtils.allowNulls(systemkey.getValue())	, SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta2300ToYe161090GridPanel01.getTableDef().addColumnFilter("clutSeptCd"	, MSFSharedUtils.allowNulls(clutSeptCd.getValue())	, SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta2300ToYe161090GridPanel01.getTableDef().addColumnFilter("yrtxBlggYr"	, MSFSharedUtils.allowNulls(yrtxBlggYr.getValue())	, SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta2300ToYe161090GridPanel01.getTableDef().addColumnFilter("cdVvalKrnCd"	, MSFSharedUtils.allowNulls("Y0140001")				, SimpleColumnFilter.OPERATOR_EQUALS); 
				
		yeta2300ToYe161090GridPanel01.reload();
	
	}
	
	public void reload02() {
		
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
			
		IColumnFilter filters = null;
			
		yeta2300ToYe161090GridPanel02.getTableDef().setTableColumnFilters(filters);
				
		yeta2300ToYe161090GridPanel02.getTableDef().addColumnFilter("dpobCd"		, MSFSharedUtils.allowNulls(dpobCd.getValue())		, SimpleColumnFilter.OPERATOR_EQUALS);
		yeta2300ToYe161090GridPanel02.getTableDef().addColumnFilter("systemkey"		, MSFSharedUtils.allowNulls(systemkey.getValue())	, SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta2300ToYe161090GridPanel02.getTableDef().addColumnFilter("clutSeptCd"	, MSFSharedUtils.allowNulls(clutSeptCd.getValue())	, SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta2300ToYe161090GridPanel02.getTableDef().addColumnFilter("yrtxBlggYr"	, MSFSharedUtils.allowNulls(yrtxBlggYr.getValue())	, SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta2300ToYe161090GridPanel02.getTableDef().addColumnFilter("cdVvalKrnCd"	, MSFSharedUtils.allowNulls("Y0140000")				, SimpleColumnFilter.OPERATOR_EQUALS); 
				
		yeta2300ToYe161090GridPanel02.reload();
	
	}
		
	private void createMsfGridForm() {
		
		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("교육비 내역");
		gridFieldSet.setBorders(true);
		
		FieldSet gridFieldSet01 = new FieldSet();
		gridFieldSet01.setHeadingHtml("기타 자료");
		gridFieldSet01.setBorders(true);
		
		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaNew = new Button("신규");
		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				actionDatabase = ActionDatabase.INSERT;

				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
					return;
				}

				// TODO Auto-generated method stub
				// 가족사항을 가지고 오는 팝업을 호출한다.
				// 선택한 내용을 저장 후리스트에 보여준다.
				// 저장은 업데이트로 처리한다.
				fnPopupCommP160(); 
			         
				actionDatabase = ActionDatabase.INSERT;
			}
		});
				
		topYetaBtnBar.add(btnYetaNew);
		
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				actionDatabase = ActionDatabase.UPDATE;
				
				Iterator<Record> iterRecords = yeta2300ToYe161090GridPanel01.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		        
				List<Ye161090DTO> listYe161090Dto = new ArrayList<Ye161090DTO>();  
				Ye161090DTO ye161090Dto = new Ye161090DTO(); 
				
					
				while (iterRecords.hasNext()) {

					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					ye161090Dto = new Ye161090DTO();
						
					ye161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    										/** column 사업장코드 : dpobCd */
					ye161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   								/** column SYSTEMKEY : systemkey */
					ye161090Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    								/** column 귀속연도 : yrtxBlggYr */
					ye161090Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    								/** column 연말정산구분코드 : clutSeptCd */
					ye161090Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd$commCd")));    					/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
					ye161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famResnoEncCntn")));						/** column 가족주민등록번호 : famResnoEncCntn */
						
					ye161090Dto.setScxpsStd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStd$commCd")));    							/** column 교육비공제대상구분코드 : scxpsStd */
					ye161090Dto.setScxpsStdTmp(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStdTmp")));    							/** column 교육비공제대상구분코드 : scxpsStd */
					ye161090Dto.setScxpsUseAmt((Long) bmMapModel.get("scxpsUseAmt"));    												/** column 교육비지출금액 : scxpsUseAmt */
					ye161090Dto.setScxpsStdDdcTrgtIndvAmt((Long) bmMapModel.get("scxpsStdDdcTrgtIndvAmt"));    							/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
					ye161090Dto.setScxpsStdClDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStdClDivCd$commCd")));				/** column 교육비구분코드 : scxpsStdClDivCd */
					ye161090Dto.setScxpsStdClDivCdTmp(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStdClDivCdTmp")));					/** column 교육비구분코드 : scxpsStdClDivCd */
					
					listYe161090Dto.add(ye161090Dto);
					
//					// 기존데이터
//					Iterator<BaseModel> itBm  = yeta2300ToYe161090GridPanel01.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
//	            	  
//					List<Record> lsRec = new ArrayList<Record>();
//					while (itBm.hasNext()) {
//						Record orgRec = new Record(itBm.next());
//						lsRec.add(rec);
//					}
//					
//					Iterator<Record> orgIterRecords = lsRec.iterator();
//	    			          
//					while (iterRecords.hasNext()) {
//						
//						Record recData = (Record) orgIterRecords.next();
//						BaseModel bmMapModel = (BaseModel) recData.getModel();
//					}
				
				} 	
				
				if(listYe161090Dto.size() < 1) {
					MessageBox.alert( "오류", "저장할 데이타가 존재하지 않습니다.", null);
					return;
					
				}else {
					
					itemYeta08_3Save(listYe161090Dto, "01");
					
//					Iterator<BaseModel> itBm = yeta2300ToYe161090GridPanel01.getMsfGrid().getGrid().getStore().getModels().iterator(); 
//					
//					List<Record>  lsRecOrg  = new ArrayList<Record>();
//			          
//					while(itBm.hasNext()) {
//						Record rec  = new Record(itBm.next()); 
//						lsRecOrg.add(rec);
//					} 
//			            
//			        Iterator<Record> iterRecordsOrg = lsRecOrg.iterator() ;  
//					
//					List<Ye161090DTO> lsOrgYe161090Dto = new ArrayList<Ye161090DTO>();  
//							
//					while (iterRecordsOrg.hasNext()) {
//								
//						Record recData = (Record) iterRecordsOrg.next(); 
//						BaseModel bmMapModel = (BaseModel)recData.getModel();
//						               
//						Ye161090DTO orgYe161090Dto = new Ye161090DTO(); 
//						
//						orgYe161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    						/** column 사업장코드 : dpobCd */
//						orgYe161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   					/** column SYSTEMKEY : systemkey */
//						orgYe161090Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    				/** column 귀속연도 : yrtxBlggYr */
//						orgYe161090Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    				/** column 연말정산구분코드 : clutSeptCd */
//						orgYe161090Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd$commCd")));    		/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
//						orgYe161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famResnoEncCntn")));		/** column 가족주민등록번호 : famResnoEncCntn */
//						
//						orgYe161090Dto.setScxpsStd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStd$commCd")));    			/** column 교육비공제대상구분코드 : scxpsStd */
//						orgYe161090Dto.setScxpsStdClDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStdClDivCd$commCd")));	/** column 교육비구분코드 : scxpsStdClDivCd */
//						
//						orgYe161090Dto.setScxpsUseAmt((Long) bmMapModel.get("scxpsUseAmt"));    								/** column 교육비지출금액 : scxpsUseAmt */
//						orgYe161090Dto.setScxpsStdDdcTrgtIndvAmt((Long) bmMapModel.get("scxpsStdDdcTrgtIndvAmt"));    			/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
//						
//						
//						
//						for(int iYetaCnt=0; iYetaCnt < lsOrgYe161090Dto.size(); iYetaCnt++) {
//			                
//							Ye161090DTO ye161090Dto_Check = new Ye161090DTO();  
//							ye161090Dto_Check = lsOrgYe161090Dto.get(iYetaCnt);   
//					            	
//					            	
//							//내가 선택한 데이터가 아닌 것 중에서
//							if((ye161090Dto_Check.getDpobCd() == orgYe161090Dto.getDpobCd())
//									&& (ye161090Dto_Check.getSystemkey() == orgYe161090Dto.getSystemkey())
//									&& (ye161090Dto_Check.getYrtxBlggYr() == orgYe161090Dto.getYrtxBlggYr())
//									&& (ye161090Dto_Check.getCdVvalKrnCd() == orgYe161090Dto.getCdVvalKrnCd())
//									&& (ye161090Dto_Check.getFamResnoEncCntn() == orgYe161090Dto.getFamResnoEncCntn())
//									&& (ye161090Dto_Check.getScxpsStd() == orgYe161090Dto.getFamResnoEncCntn())
//									) {
//									if(payr0410Dto.getPayrImcd() == Payr0410Dto_Check.getPayrImcd() && payr0410Dto.getPayCd() == Payr0410Dto_Check.getPayCd()) {
//										MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"지급공제항목에 중복된 데이터가 존재합니다.", null);
//										return;
//									}
//							
//						
//						
//						
//						
//						lsOrgYe161090Dto.add(orgYe161090Dto);
//					} 
//					
//
//							}
//						}
//					
//					itemYeta08_3Save(listYe161090Dto, "01");
//				}
				}
			}
		});
		topYetaBtnBar.add(btnYetaSave);		
		

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				MessageBox.confirm("삭제", "선택하신 교육비 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							actionDatabase = ActionDatabase.DELETE;
							
							
							Iterator<BaseModel> itBm = yeta2300ToYe161090GridPanel01.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

							List<Record> lsRec = new ArrayList<Record>();

							while (itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}

							Iterator<Record> iterRecords = lsRec.iterator();
							List<Ye161090DTO> listYe161090Dto = new ArrayList<Ye161090DTO>();  
							Ye161090DTO ye161090Dto = new Ye161090DTO(); 
								
							while (iterRecords.hasNext()) {

								Record recData = (Record) iterRecords.next();
								BaseModel bmMapModel = (BaseModel) recData.getModel();

								ye161090Dto = new Ye161090DTO();
								
								ye161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    										/** column 사업장코드 : dpobCd */
								ye161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   								/** column SYSTEMKEY : systemkey */
								ye161090Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    								/** column 귀속연도 : yrtxBlggYr */
								ye161090Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    								/** column 연말정산구분코드 : clutSeptCd */
								ye161090Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd$commCd")));    					/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
								ye161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famResnoEncCntn")));						/** column 가족주민등록번호 : famResnoEncCntn */
									
								ye161090Dto.setScxpsStd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStd$commCd")));    							/** column 교육비공제대상구분코드 : scxpsStd */
								ye161090Dto.setScxpsUseAmt((Long) bmMapModel.get("scxpsUseAmt"));    												/** column 교육비지출금액 : scxpsUseAmt */
								ye161090Dto.setScxpsStdDdcTrgtIndvAmt((Long) bmMapModel.get("scxpsStdDdcTrgtIndvAmt"));    							/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
								ye161090Dto.setScxpsStdClDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStdClDivCd$commCd")));				/** column 교육비구분코드 : scxpsStdClDivCd */
								
								listYe161090Dto.add(ye161090Dto);
						                   
							}
							
							itemYeta08_3Save(listYe161090Dto, "01");
							
						}
					}
				});
			}
		});
		topYetaBtnBar.add(btnYetaDel);

		gridFieldSet01.add(topYetaBtnBar);
		
		
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid01 = new ContentPanel();
		cpGrid01.setBodyBorder(false);
		cpGrid01.setHeaderVisible(false);
		cpGrid01.setLayout(new FitLayout());
		cpGrid01.setStyleAttribute("paddingLeft"	, "5px");
		cpGrid01.setStyleAttribute("paddingRight"	, "5px");
		cpGrid01.setSize(780, 220);
		    
		 
		yeta2300ToYe161090GridPanel01 = new MSFGridPanel(ye161090Def_01, false, false, false, false, false);
		yeta2300ToYe161090GridPanel01.setHeaderVisible(false);  
		yeta2300ToYe161090GridPanel01.setBodyBorder(false);
		yeta2300ToYe161090GridPanel01.setBorders(true);
		yeta2300ToYe161090GridPanel01.getBottomComponent().setVisible(true);
		
		
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
		payrSummaryRow.setHtml(PrgmComPsnl0115BM.ATTR_FAMYNM, "합 계"); 
		 
		payrSummaryRow.setCellStyle(Ye161090BM.ATTR_SCXPSUSEAMT,"summary_color");	
		payrSummaryRow.setCellStyle(Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT,"summary_color");	
			
								    
		payrSummaryRow.setSummaryType(Ye161090BM.ATTR_SCXPSUSEAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
		payrSummaryRow.setSummaryType(Ye161090BM.ATTR_SCXPSUSEAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								      
		yeta2300ToYe161090GridPanel01.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		/** --- 그리드 합계 부분  시작 --- **/		
		   
		cpGrid01.add(yeta2300ToYe161090GridPanel01); 
		lcStdGrid.add(cpGrid01);	
		gridFieldSet01.add(lcStdGrid);
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		LabelField lblfldNewLabelfield_22 = new LabelField("기타  자료는  성명(주민등록번호)/자료구분/공제대상구분/교육구분 별 1건씩만 입력 가능합니다.");
		layoutContainer_5.add(lblfldNewLabelfield_22);
		
		LabelField lblfldNewLabelfield_23 = new LabelField("무결성 오류 발생시 중복 데이터가 없는지 확인해주시길 바랍니다. (존재시 해당 데이터 삭제 후 다시 등록해주세요.)");
		layoutContainer_5.add(lblfldNewLabelfield_23);
		gridFieldSet01.add(layoutContainer_5);
		
		
		gridFieldSet.add(gridFieldSet01);
		
		
		
		//--
		FieldSet gridFieldSet02 = new FieldSet();
		gridFieldSet02.setHeadingHtml("국세청 자료");
		gridFieldSet02.setBorders(true);
		
		ButtonBar topYetaBtnBar2 = new ButtonBar();
		topYetaBtnBar2.setAlignment(HorizontalAlignment.RIGHT);

		Button btnYetaSave2 = new Button("저장");
		btnYetaSave2.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				actionDatabase = ActionDatabase.UPDATE;
				
				Iterator<Record> iterRecords = yeta2300ToYe161090GridPanel02.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		        
				List<Ye161090DTO> listYe161090Dto = new ArrayList<Ye161090DTO>();  
				Ye161090DTO ye161090Dto = new Ye161090DTO(); 
				
					
				while (iterRecords.hasNext()) {

					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					ye161090Dto = new Ye161090DTO();
						
					ye161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    										/** column 사업장코드 : dpobCd */
					ye161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   								/** column SYSTEMKEY : systemkey */
					ye161090Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    								/** column 귀속연도 : yrtxBlggYr */
					ye161090Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    								/** column 연말정산구분코드 : clutSeptCd */
					ye161090Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd$commCd")));    					/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
					ye161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famResnoEncCntn")));						/** column 가족주민등록번호 : famResnoEncCntn */
						
					ye161090Dto.setScxpsStd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStd$commCd")));    							/** column 교육비공제대상구분코드 : scxpsStd */
					ye161090Dto.setScxpsUseAmt((Long) bmMapModel.get("scxpsUseAmt"));    												/** column 교육비지출금액 : scxpsUseAmt */
					ye161090Dto.setScxpsStdDdcTrgtIndvAmt((Long) bmMapModel.get("scxpsStdDdcTrgtIndvAmt"));    							/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
					ye161090Dto.setScxpsStdClDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStdClDivCd$commCd")));				/** column 교육비구분코드 : scxpsStdClDivCd */
					
					listYe161090Dto.add(ye161090Dto);
				
				} 				
				
				itemYeta08_3Save(listYe161090Dto, "02");
			}
		});
		topYetaBtnBar2.add(btnYetaSave2);		

		gridFieldSet02.add(topYetaBtnBar2);
		
		
		LayoutContainer lcStdGrid02 = new LayoutContainer();
		frmlytStd = new FormLayout();
		lcStdGrid02.setLayout(frmlytStd);

		ContentPanel cpGrid02 = new ContentPanel();
		cpGrid02.setBodyBorder(false);
		cpGrid02.setHeaderVisible(false);
		cpGrid02.setLayout(new FitLayout());
		cpGrid02.setStyleAttribute("paddingLeft"	, "5px");
		cpGrid02.setStyleAttribute("paddingRight"	, "5px");
		cpGrid02.setSize(780, 220);
		    
		 
		yeta2300ToYe161090GridPanel02 = new MSFGridPanel(ye161090Def_02, false, false, false, false, false);
		yeta2300ToYe161090GridPanel02.setHeaderVisible(false);  
		yeta2300ToYe161090GridPanel02.setBodyBorder(false);
		yeta2300ToYe161090GridPanel02.setBorders(true);
		yeta2300ToYe161090GridPanel02.getBottomComponent().setVisible(true);
		
		
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow2 = new AggregationRowConfig<BaseModel>();  
			
		payrSummaryRow2.setHtml(PrgmComPsnl0115BM.ATTR_FAMYNM, "합 계"); 
		 
		payrSummaryRow2.setCellStyle(Ye161090BM.ATTR_SCXPSUSEAMT,"summary_color");	
		payrSummaryRow2.setCellStyle(Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT,"summary_color");	
			
								    
		payrSummaryRow2.setSummaryType(Ye161090BM.ATTR_SCXPSUSEAMT, SummaryType.SUM);   
		payrSummaryRow2.setSummaryFormat(Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
		payrSummaryRow2.setSummaryType(Ye161090BM.ATTR_SCXPSUSEAMT, SummaryType.SUM);   
		payrSummaryRow2.setSummaryFormat(Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								      
		yeta2300ToYe161090GridPanel02.getGrid().getColumnModel().addAggregationRow(payrSummaryRow2);  
		/** --- 그리드 합계 부분  시작 --- **/		
		   
		cpGrid02.add(yeta2300ToYe161090GridPanel02); 
		lcStdGrid02.add(cpGrid02);	
		gridFieldSet02.add(lcStdGrid02);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		LabelField lblfldNewLabelfield_2 = new LabelField("국세청  자료는 공제대상구분만 수정 가능합니다. (신규, 삭제 처리 불가)");
		layoutContainer_4.add(lblfldNewLabelfield_2);
		gridFieldSet02.add(layoutContainer_4);
		
		
		gridFieldSet.add(gridFieldSet02);
		
		cpYeta230011.add(gridFieldSet);


		
	}
		
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
		

		
	 
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	//가족사항
	private void fnPopupCommP160() {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
//		
		
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
			
		PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
		sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
		sysComPsnl0115Dto.setSystemkey(systemkey.getValue());// systemKey 넘김.
		      
		MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto); // 인사

		final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
		      
		popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();
		               
				if (mapModels != null) {
					actionDatabase = ActionDatabase.INSERT;

					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
					List<Ye161090DTO> listYe161090Dto = new ArrayList<Ye161090DTO>();
					Ye161090DTO ye161090Dto = new Ye161090DTO();
					
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						// 건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
						ye161090Dto = new Ye161090DTO();
	                        
						ye161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
						ye161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   			/** column SYSTEMKEY : systemkey */
						ye161090Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    											/** column 귀속연도 : yrtxBlggYr */
						ye161090Dto.setClutSeptCd(clutSeptCd.getValue());    											/** column 연말정산구분코드 : clutSeptCd */
						ye161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));	/** column 가족주민등록번호 : famResnoEncCntn */
							
						ye161090Dto.setScxpsStdTmp("Y0030010");    														/** column 교육비공제대상구분코드 : scxpsStd */
						ye161090Dto.setScxpsStdClDivCdTmp("Y0200010");    												/** column 교육비구분코드 : scxpsStdClDivCd */
						ye161090Dto.setScxpsStd("Y0030010");    														/** column 교육비공제대상구분코드 : scxpsStd */
						ye161090Dto.setScxpsStdClDivCd("Y0200010");    													/** column 교육비구분코드 : scxpsStdClDivCd */
						
						ye161090Dto.setCdVvalKrnCd("Y0140001");    														/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
						ye161090Dto.setScxpsUseAmt(bmMapModel.set("scxpsUseAmt", 0L));    								/** column 교육비지출금액 : scxpsUseAmt */
						ye161090Dto.setScxpsStdDdcTrgtIndvAmt(bmMapModel.set("scxpsStdDdcTrgtIndvAmt", 0L));    		/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
						ye161090Dto.setScxpsStdClDivCdTmp("Y0200010");    												/** column 교육비구분코드 : scxpsStdClDivCd */
						
						listYe161090Dto.add(ye161090Dto);
							
					}    
		                
					yetaP230011Service.saveYeta2300ToYe161090tabItem08_3(listYe161090Dto, actionDatabase, new AsyncCallback<Long>() {
			    			 
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
												MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta2300ToYe161090tabItem08_3(" + actionDatabase.name() + ") : " + caught), null);
						}
					
						public void onSuccess(Long result) {  
							
							reload01();
							actionDatabase = ActionDatabase.UPDATE;
							
						}
					});
				}
			}
		});
	}
	
	
	/**세액감면및세액공제1 - 교육비 수정 **/
	public void itemYeta08_3Save(List<Ye161090DTO> listYe161090Dto, final String typStr) {
		// TODO Auto-generated method stub
		
		if(listYe161090Dto.size() < 1) {
			MessageBox.alert(actionDatabase.name() + "오류", (actionDatabase.equals(ActionDatabase.DELETE) ? "삭제" : "저장") +  " 처리할 데이타가 존재하지 않습니다.", null);
			return;
		}else {
			
			yetaP230011Service.saveYeta2300ToYe161090tabItem08_3(listYe161090Dto, actionDatabase, new AsyncCallback<Long>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
					                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_3Save : " + caught), null);
				}
		
				@Override
				public void onSuccess(Long result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  (actionDatabase.equals(ActionDatabase.DELETE) ? "삭제" : "저장") + " 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} else {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), (actionDatabase.equals(ActionDatabase.DELETE) ? "삭제" : "저장" )+ " 처리가 완료되었습니다.", null);
						
						if("01".equals(typStr)) {
							reload01();
						}else {
							reload02();
						}
						
						
						
					} 
				}
			});
			
		}
	}
			
	
		
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/		
}
