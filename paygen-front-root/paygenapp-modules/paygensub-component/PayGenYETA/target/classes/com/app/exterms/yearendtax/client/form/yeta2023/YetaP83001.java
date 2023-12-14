/**
 * 이월기부금등록
 */
package com.app.exterms.yearendtax.client.form.yeta2023;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye165030BM;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye165030DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2023.Ye165030Def;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaP83001Service;
import com.app.exterms.yearendtax.client.service.yeta2023.YetaP83001ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP83001   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta83001; 
	  
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
	private MSFGridPanel YetaP83001GridPanel;
//	private Ye16Ta3170Def YetaP83001ToYe5030Def  = new Ye16Ta3170Def("YetaP83001");	//이월기부금 그리드 테이블 컬럼 define 
	private Ye165030Def YetaP83001ToYe5030Def  = new Ye165030Def("YetaP83001");	//이월기부금 그리드 테이블 컬럼 define 
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
  
	private BaseModel record;
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
 	private TextField<String> srhYrtxBlggYr;		// 귀속년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
// 	private TextField<String> srhClutSeptCd;

 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> yrtxBlggYr;	/** column 연말정산귀속년도 : yrtxBlggYr */
	private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : clutSeptCd */
	private HiddenField<String> systemkey;  /**  column SYSTEMKEY : systemkey */
	private HiddenField<String>	 dpobCd;	/**  column 사업장코드 : dpobCd */
	private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
 	// -------------- 검색 조건 종료 --------------
    
    
	// -------------- 서비스 호출 시작 --------------
	private YetaP83001ServiceAsync yetaP83001Service = YetaP83001Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
      
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
	private ListStore<BaseModel> lsclutSeptCd = new ListStore<BaseModel>(); // 정산구분
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

	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			cancel();
			unmask();
			maskTracker = true;
			// }
		}
	};
		     
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
	  
	public YetaP83001(final ActionDatabase actionDatabase, final MSFPanel caller) {

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
		// this.actionDatabase = actionDatabase;
		this.actionDatabase = ActionDatabase.UPDATE;
		this.caller = caller;

		cpYeta83001 = new ContentPanel();

		createSearchForm(); // 기본정보 필드를 적용
		// createMsfGridForm(); //그리드필드
		createStandardForm(); // 기본정보필드

		cpYeta83001.setBodyBorder(false);
		cpYeta83001.setBorders(false);
		cpYeta83001.setHeaderVisible(false);
		cpYeta83001.setSize("790px", "640px");

		this.add(cpYeta83001);
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
		cpYeta83001.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYeta83001.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYeta83001.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYeta83001.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYeta83001.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYeta83001.add(hanNm);

		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
//		lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		     

		cpYeta83001.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaNew = new Button("신규");
		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	 	    		 return;
	      	     }
				 
				 YetaP83001GridPanel.getMsfGrid().clearData();
				 
				 BaseModel bmData = YetaP83001GridPanel.getTableDef().getDefaultValues();  
		              
		         bmData.set("dpobCd"			, dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		         bmData.set("yrtxBlggYr"		, yrtxBlggYr.getValue());    	/** column 귀속연도 : yrtxBlggYr */
		         bmData.set("clutSeptCd"		, clutSeptCd.getValue());    	/** column 연말정산구분코드 : clutSeptCd */
		         bmData.set("systemkey"			, systemkey.getValue());   	 	/** column SYSTEMKEY : systemkey */
		         bmData.set("conbSeilNum"		, 0L);    						/** column 기부금조정일련번호 : conbSeilNum */
		         
		         bmData.set("conbCddl"			, "");    						/** column 기부금유형구분코드 : conbCddl */
		         bmData.set("ctrbTycd"			, "");    						/** column 기부금유형신고코드 : ctrbTycd */
		         bmData.set("attrYr"			, yrtxBlggYr.getValue());    	/** column 기부년도 : attrYr */
		         bmData.set("useAmt"			, 0L);    						/** column 기부금액 : useAmt */
		         bmData.set("pyrDdcAmt"			, 0L);   					 	/** column 전년도공제된금액 : pyrDdcAmt */
		         bmData.set("ddcTrgtAmt"		, 0L);    						/** column 기부금공제대상금액 : ddcTrgtAmt */
		         bmData.set("thcYrDdcAmtNdXps"	, 0L);    						/** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
		         bmData.set("thcYrDdcAmt"		, 0L);    						/** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
		         bmData.set("thcYrNducExtnAmt"	, 0L);    						/** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
		         bmData.set("thcYrNducCrfwAmt"	,0L);    						/** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */		         
		         
		         
		         YetaP83001GridPanel.getMsfGrid().getGrid().stopEditing();      
		         YetaP83001GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
		         YetaP83001GridPanel.getMsfGrid().getGrid().startEditing(YetaP83001GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
		         
		         actionDatabase = ActionDatabase.INSERT;
			}
		});
		topYetaBtnBar.add(btnYetaNew);

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				MessageBox.confirm("삭제", "선택하신 이월기부금 내용을 삭제하시겠습니까?" , new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){	
							
							Iterator<BaseModel> itBm = YetaP83001GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
							List<Record> lsRec = new ArrayList<Record>();
							
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
			}
		});
		topYetaBtnBar.add(btnYetaDel);
				
		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(YetaP83001GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
				
				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
				
				doAction(actionDatabase);
			}
		});

		topYetaBtnBar.add(btnYetaSave);
				
		cpYeta83001.add(topYetaBtnBar);
		  	
		  	
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
		srhYrtxBlggYr.setName("yrtxBlggYr");
//		srhYrtxBlggYr.setForceSelection(true);
//		srhYrtxBlggYr.setMinChars(1);
//		srhYrtxBlggYr.setDisplayField("yearDisp");
//		srhYrtxBlggYr.setValueField("year");
//		srhYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		// srhYrtxBlggYr.setEmptyText("--년도선택--");
//		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
//		srhYrtxBlggYr.setStore(lsdacRvyyStore);
		srhYrtxBlggYr.setFieldLabel("년도");
//		srhYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				srhYrtxBlggYr.setValue(lsdacRvyyStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
//			}
//		});
			
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
		srhClutSeptCd.setStore(lsclutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
				reload();
//				srhClutSeptCd.setValue(lsclutSeptCd.getAt(0));
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
		
		
		

		cpYeta83001.add(fieldSet);
		cpYeta83001.add(createMsfGridForm(), new FormData("100%"));
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

		LabelField lblfldNewLabelfield = new LabelField(
				"유형 항목을 선택하시면 콤보에서 선택 하는 화면이 나타 납니다.");
		layoutContainer_1.add(lblfldNewLabelfield, new FormData("100%"));
		layoutContainer_1.setBorders(false);
		layoutContainer.add(layoutContainer_1);

		LayoutContainer layoutContainer_2 = new LayoutContainer();

		LabelField lblfldNewLabelfield_1 = new LabelField(
				"정산 이전년도에 대한 기부금 이월이 존재하는 기부금 유형에 대해 등록합니다.");
		layoutContainer_2.add(lblfldNewLabelfield_1, new FormData("100%"));
		layoutContainer_2.setBorders(false);
		layoutContainer.add(layoutContainer_2);

		LayoutContainer layoutContainer_3 = new LayoutContainer();

		LabelField lblfldNewLabelfield_2 = new LabelField(
				"재직자의 경우 등록된 데이타를 기준으로 자동으로 보여지게 됩니다.");
		layoutContainer_3.add(lblfldNewLabelfield_2, new FormData("100%"));
		layoutContainer_1.setBorders(false);
		layoutContainer.add(layoutContainer_3);

		cp01.add(layoutContainer);
		lcFormLayer.add(cp01);
		cpYeta83001.add(lcFormLayer);

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
	
		
	
	private LayoutContainer createMsfGridForm() {
//	private void createMsfGridForm() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		lcTabFormLayer.setLayout(frmlytStd);  
		
		ContentPanel cp01 = new ContentPanel();   
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(790, 490);
		
		YetaP83001GridPanel = new MSFGridPanel(YetaP83001ToYe5030Def, false, false, false, false, false);
		YetaP83001GridPanel.setBorders(false);
		YetaP83001GridPanel.setBodyBorder(false);
		YetaP83001GridPanel.setHeaderVisible(false); 
		YetaP83001GridPanel.getBottomComponent().setVisible(false);
		
		GWTUtils.findColumnConfig(YetaP83001GridPanel, Ye165030BM.ATTR_THCYRDDCAMT).setStyle("background-color:#F5F6CE;");
		
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//		GWTUtils.findColumnConfig(YetaP83001GridPanel, Yeta3170BM.ATTR_CTRBAMNT).setStyle("Height:20px;");
		
		payrSummaryRow.setHtml(Ye165030BM.ATTR_ATTRYR, "합 계"); 
		
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_USEAMT,"summary_color");			/** column 기부금액 : useAmt */
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_PYRDDCAMT,"summary_color");			/** column 전년도공제된금액 : pyrDdcAmt */
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_DDCTRGTAMT,"summary_color");		/** column 기부금공제대상금액 : ddcTrgtAmt */
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_THCYRDDCAMTNDXPS,"summary_color");	/** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */	
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_THCYRDDCAMT,"summary_color");	 	/** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_THCYRNDUCEXTNAMT,"summary_color");	/** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
		payrSummaryRow.setCellStyle(Ye165030BM.ATTR_THCYRNDUCCRFWAMT,"summary_color");	/** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
		
		
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_USEAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_USEAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
							    
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_PYRDDCAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_PYRDDCAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
							      
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_DDCTRGTAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_DDCTRGTAMT, NumberFormat.getFormat("#,##0;(#,##0)"));
		
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_THCYRDDCAMTNDXPS, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_THCYRDDCAMTNDXPS, NumberFormat.getFormat("#,##0;(#,##0)"));
		
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_THCYRDDCAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_THCYRDDCAMT, NumberFormat.getFormat("#,##0;(#,##0)"));
		
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_THCYRNDUCEXTNAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_THCYRNDUCEXTNAMT, NumberFormat.getFormat("#,##0;(#,##0)"));
		
		payrSummaryRow.setSummaryType(Ye165030BM.ATTR_THCYRNDUCCRFWAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165030BM.ATTR_THCYRNDUCCRFWAMT, NumberFormat.getFormat("#,##0;(#,##0)"));
		
		
		YetaP83001GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		
		cpYeta83001.add(YetaP83001GridPanel);
		cp01.add(YetaP83001GridPanel);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
		
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
	
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
				YetaP83001FormSave();
				break;
			case UPDATE:
				
				this.actionDatabase = ActionDatabase.UPDATE;
				YetaP83001FormSave();
				break;
			case DELETE:
				this.actionDatabase = ActionDatabase.DELETE;
				YetaP83001FormSave();
				break;
		}
	}
	
	
	private void YetaP83001FormSave() {
		
		if (MSFSharedUtils.paramNotNull(records)) {

			List<Ye165030DTO> listYe165030Dto = new ArrayList<Ye165030DTO>();  
			Ye165030DTO ye165030Dto= new Ye165030DTO();  
			 
			Boolean dataChk = true;
                
			while (records.hasNext()) {
              
				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();
                      
                ye165030Dto= new Ye165030DTO(); 
                
                ye165030Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
                ye165030Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));		/** column 귀속연도 : yrtxBlggYr */
                ye165030Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    	/** column 연말정산구분코드 : clutSeptCd */
                ye165030Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */
                ye165030Dto.setConbSeilNum((Long) bmMapModel.get("conbSeilNum"));    					/** column 기부금조정일련번호 : conbSeilNum */
                
                ye165030Dto.setConbCddl(MSFSharedUtils.allowNulls(bmMapModel.get("conbCddl$commCd"))); 	/** column 기부금유형구분코드 : conbCddl */
                ye165030Dto.setAttrYr(MSFSharedUtils.allowNulls(bmMapModel.get("attrYr")));    			/** column 기부년도 : attrYr */
                ye165030Dto.setUseAmt((Long) bmMapModel.get("useAmt"));    								/** column 기부금액 : useAmt */
                ye165030Dto.setPyrDdcAmt((Long) bmMapModel.get("pyrDdcAmt"));    						/** column 전년도공제된금액 : pyrDdcAmt */
                ye165030Dto.setDdcTrgtAmt((Long) bmMapModel.get("ddcTrgtAmt"));    						/** column 기부금공제대상금액 : ddcTrgtAmt */
                ye165030Dto.setThcYrDdcAmtNdXps((Long) bmMapModel.get("thcYrDdcAmtNdXps"));    			/** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
                ye165030Dto.setThcYrDdcAmt((Long) bmMapModel.get("thcYrDdcAmt"));    					/** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
                ye165030Dto.setThcYrNducExtnAmt((Long) bmMapModel.get("thcYrNducExtnAmt"));    			/** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
                ye165030Dto.setThcYrNducCrfwAmt((Long) bmMapModel.get("thcYrNducCrfwAmt"));    			/** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */   
                ye165030Dto.setCtrbTycd(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbTycd")));    		/** column 기부금유형신고코드 : ctrbTycd */
                
                
                
                if(!"DELETE".equals(actionDatabase.name())) {
                	
                	 /** 그리드에 있는 항목에 대해서 입력 체크 **/
                    if(MSFSharedUtils.paramNull( ye165030Dto.getAttrYr())) {
                    	MessageBox.alert("경고", "년도를 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getConbCddl())) {
                    	MessageBox.alert("경고", "유형을 선택해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getUseAmt())) {
                    	MessageBox.alert("경고", "기부금액을 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getPyrDdcAmt())) {
                    	MessageBox.alert("경고", "전년도공제금액을 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getDdcTrgtAmt())) {
                    	MessageBox.alert("경고", "공제대상금액을 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getThcYrDdcAmtNdXps())) {
                    	MessageBox.alert("경고", "필요경비를 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getThcYrDdcAmtNdXps())) {
                    	MessageBox.alert("경고", "해당연도공제금액을 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getThcYrNducExtnAmt())) {
                    	MessageBox.alert("경고", "소멸금액을 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
                    }else if(MSFSharedUtils.paramNull( ye165030Dto.getThcYrNducCrfwAmt())) {
                    	MessageBox.alert("경고", "이월금액을 입력해 주세요.", null);
                    	dataChk = false;
    					return; 
    					
    				// 2013년 ~ 2016년도 까지만 입력 가능하도록.	
    				}else if(  Long.parseLong("2014") > Long.parseLong(ye165030Dto.getAttrYr())
    							||  Long.parseLong("2018") < Long.parseLong(ye165030Dto.getAttrYr())) {
                    	MessageBox.alert("경고", "2014~2018년도 데이터만 입력 가능합니다.", null);
                    	dataChk = false;
    					return; 
    				}
                    
                }else {
                	
                }
                
				listYe165030Dto.add(ye165030Dto);
			}  
			
			if(dataChk) {
				
				if (listYe165030Dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장",actionDatabase.name()+ "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
	                
				yetaP83001Service.activityOnYetaP83001ToYe165030(listYe165030Dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP83001ToYe165030(" + actionDatabase.name() + ") : " + caught), null);
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
	
	@Override
	public void reload() {

		IColumnFilter filters = null;
			
		YetaP83001GridPanel.getTableDef().setTableColumnFilters(filters);
		
		YetaP83001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
		
		YetaP83001GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		
		YetaP83001GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		
		YetaP83001GridPanel.reload();
			
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
