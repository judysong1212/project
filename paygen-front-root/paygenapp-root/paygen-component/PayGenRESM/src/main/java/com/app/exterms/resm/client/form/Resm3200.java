package com.app.exterms.resm.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.resm.client.dto.Bass0500DTO;
import com.app.exterms.resm.client.form.defs.Bass0500Def;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.client.service.Resm3200Service;
import com.app.exterms.resm.client.service.Resm3200ServiceAsync;
import com.app.exterms.resm.client.utils.ResmUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.app.smrmf.syscom.client.util.SysComPopupUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Bass0500.java
 * @Description : 부서별사업관리
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 **/

/**
 * =========================================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends
 * LayoutContainer implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리
 * 해야함. MSFPanel
 * =========================================================================
 **/
public class Resm3200 extends MSFPanel {
	/**
	 * ########################################################################## 
	 * { 시스템 기본설정파일 선언부 시작}
	 * ##########################################################################
	 **/

	/**
	 * ########################################################################## 
	 * { 시스템 기본설정파일 선언부 종료}
	 * ##########################################################################
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/	
	private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
	
	private VerticalPanel vp;
	private FormPanel plFrmResm3200;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	
	final TabPanel tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
	
	private BaseModel record;
	
	// -------------- grid 선언 시작  ---------------
	private Bass0500Def bass0500Def = new Bass0500Def();
//	private Bass0500Def bass050002Def = new Bass0500Def("BASS0500_CRE");
	
	private MSFGridPanel msfResm3200GridPanel;
	// -------------- grid 선언 종료  ---------------
	
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
	  
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */	
	// -- 상단 버튼 시작
	private ButtonBar topResm3200Bar;				
	private Button btnResm3200New;						//신규 버튼
	private Button btnResm3200Save;						//저장 버튼 
	private Button btnResm3200Del;						//삭제 버튼
	private Button btnResm3200Sreach;					//조회 버튼
	private Button btnResm3200Print;					//인쇄 버튼
	private Button btnResm3200Excel;					//엑셀 버튼	
	
	private Button btnResm3200Trnr;						//이관 버튼
	// -- 상단 버튼 종료
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 -------------- 
	private ComboBox<BaseModel> srhBusinApptnYr; 		//사업년도
	private ComboBox<BaseModel> srhDeptCd; 				//부서
	private TextField<String> srhBusinNm; 				//사업명
	// -------------- 검색 조건 끝 -------------- 
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 상세정보 시작 -------------- 
	private TabPanel tabsResm3200; // 하위 탭 정보
	
	private MSFTextField dpobCd;
	private MSFComboBox<BaseModel> businApptnYr; 			//사업년도
	private MSFComboBox<BaseModel> deptCd; 					//부서코드
	private MSFComboBox<BaseModel> businEmymtTypOccuCd; 	//사업고용직종코드(산재보험직종)
	private MSFTextField businCd; 							//사업코드
	private MSFTextField businNm; 							//사업명
	private TextFieldWithButton<String> businRepbtyEmpNum; 	//담당직원
	private HiddenField<String> pmdPernKey;					//담당직원 키
	private MSFTextField idtlAccdtInsurApmrt; 				//산재보험효율
	private MSFNumberField businDutyNumDys; 				//근무일수
	private MSFDateField businStdt; 						//시작일자
	private MSFDateField businEddt; 						//종료일자
	private MSFTextField spityCtnt; 						//특기사항
	// --------------  상세정보 끝 -------------- 
	
	// -------------- 사업장 관리번호 시작 ---------------
	private MSFTextField natPennSym; 						//국민연금
	private MSFTextField hlthInsrSym; 						//건강보험
	private MSFTextField hlthInsrOfceSym;					//건강보험영업소기호
	private MSFTextField umytInsrSym; 						//고용보험
	private MSFTextField idtlAccdtInsurSym; 				//산재보험
	// -------------- 사업장 관리번호 종료 ---------------
	
	// -------------- store 선언 시작 ---------------
	ListStore<BaseModel> listStoreSrhYr 	= new ListStore<BaseModel>();
	ListStore<BaseModel> listStoreSrhDeptCd = new ListStore<BaseModel>();
	ListStore<BaseModel> listStoreYr 		= new ListStore<BaseModel>();
	ListStore<BaseModel> listStoreDeptCd 	= new ListStore<BaseModel>();
	ListStore<BaseModel> listStoreI001 		= new ListStore<BaseModel>();
	// -------------- store 선언 종료 ---------------
	
	// -------------- 서비스 호출 시작 --------------
//	private InfcResm3200ServiceAsync infcResm3200Service = InfcResm3200Service.Util.getInstance();
	private Resm3200ServiceAsync bass0500Service = Resm3200Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	  private SysCoCalendarDTO  msfCoCalendarDto;  
	
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 상태처리 전역변수
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
	// -------------- 상태처리 전역변수 시작 ---------------
	private ActionDatabase actionDatabase;
	// -------------- 상태처리 전역변수 종료 ---------------
	
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/
	   // 검색 폼 바인딩 처리 함수 
	 // private AuthAction authAction;  
	//  private Boolean boolChkAuth;  
	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  private void checkResm3200Auth( String authAction, ListStore<BaseModel> bm) {   
    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
		    
			    //----------------------------------------------------
			  // if (!maskTracker) { unmask(); }  
                //MSFMainApp.unmaskMainPage();
			   authExecEnabled() ;
			   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
               
		   }
	  }
	  
	  private void authExecEnabled() { 
		   //------------------
		  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
           * 권한설정을 위한 콤보처리를 위한 메서드 시작 
           * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
           ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		     Field<?>[] fldArrField = {srhDeptCd};
		      
		     gwtAuthorization.formAuthFieldConfig(fldArrField);
		     
		      
		     srhBusinApptnYr.setValue(listStoreSrhYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()) ));
		     businApptnYr.setValue(listStoreYr.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()) ));
		    
		   //gwtAuthorization.formAuthConfig(plFrmResm3200, "","","srhDeptCd","","",""); 
          /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
           * 권한설정을 위한 콤보처리를 위한 메서드 종료
           ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
		 }
		 
		   final Timer tmMask = new Timer()
		     {
		           public void run()
		           {
		              // if (maskTracker)
		              // { 
		        	   if (listStoreSrhDeptCd.getCount() > 0) {
		        		   
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
		     
		     authMapDef.put("srhDeptCd",Boolean.FALSE);  
			 
			 gwtExtAuth.setCheckMapDef(authMapDef);
	        
	        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
	        	  //권한 검색조건처리를 위해 추가된 부분 
				   mask("[화면로딩] 초기화 진행 중!");
        	}
	        
	        tmMask.scheduleRepeating(5000);     
    	
	  }
	  
//		  private AuthAction authAction;
//		  private int checkCntDef = 1;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkResm3200Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			 
//			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//			   
//				   //----------------------------------------------------
//	                unmask(); 
//	                //MSFMainApp.unmaskMainPage();
//	                 
//			   }
//		  } 
	     
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/	
	  
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */	
	// -------------- 선택된버튼에 따른 인서트 업데이트 삭제 처리 부 시작 --------------
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			if (ce.getButton() == btnResm3200Save) {
					doAction(ActionDatabase.INSERT);
			}else if (ce.getButton() == btnResm3200Save) {
				doAction(ActionDatabase.UPDATE);
			}else if (ce.getButton() == btnResm3200Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	};
	// -------------- 선택된버튼에 따른 인서트 업데이트 삭제 처리 부 종료 --------------
	
	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public ContentPanel getViewPanel() {
		if (panel == null) {
			
			 //콤보 권한초기화
			   initLoad(); 
			
			msfCoCalendarDto = new SysCoCalendarDTO();   
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("I001");
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					// TODO 콤보 데이터 저장하는곳
					if(result != null && result.size() > 0){
						listStoreI001.add(result.get("I001"));
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "공통코드 에러!", null);
				}
			});
			
//			infcResm3200Service.getYearList(new AsyncCallback<List<BaseModel>>() {
//				@Override
//				public void onSuccess(List<BaseModel> result) {
//					listStoreSrhYr.add(result);
//					listStoreYr.add(result);
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					MessageBox.alert("", "년도코드 에러!", null);
//				}
//			});
			
			 //--------------------정산년도 불러 오는 함수 ------------------------------------------------
			listStoreSrhYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		     //--------------------정산년도 불러 오는 함수 ------------------------------------------------
		     
		     //--------------------년도 불러 오는 함수 ------------------------------------------------
			listStoreYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		
		     //--------------------년도 불러 오는 함수 ------------------------------------------------  
		     
			 
			
			bass0500Service.getBass0400List(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStoreSrhDeptCd.add(result);
					listStoreDeptCd.add(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "부서코드 에러!", null);
				}
			});
			
			
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createResm3200Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createListGrid(); 		// 부서정보 그리드 
			createTabForm();		// 탭 
//			createStandardForm(); 	// 사업장정보
			createStdSubFrom(); 	// 사업장 관리번호

			
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.setScrollMode(Scroll.AUTO);
			panel.add(vp);

		}
		return panel;
	}
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// TODO 사업장 관리기호
	private void createStdSubFrom() {

		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("사업장 관리번호");
		fldstNewFieldset.setCollapsible(false);
		
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_2 = new LayoutContainer();
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(60);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lc1_2.setLayout(fl1_2);
		hlthInsrSym = new MSFTextField();
		hlthInsrSym.setFieldLabel("건강보험");
		lc1_2.add(hlthInsrSym, new FormData("100%"));
		
		lc1.add(lc1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.19));
		
		LayoutContainer lc1_5 = new LayoutContainer();
		hlthInsrOfceSym = new MSFTextField();
		hlthInsrOfceSym.setMaxLength(20);
		hlthInsrOfceSym.setWidth("100%");
		lc1_5.add(hlthInsrOfceSym);
		
		lc1.add(lc1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.12));
		
		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(70);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(fl1_1);
		natPennSym = new MSFTextField();
		natPennSym.setFieldLabel("국민연금");
		lc1_1.add(natPennSym, new FormData("100%"));
		
		lc1.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.23));
		
		LayoutContainer lc1_3 = new LayoutContainer();
		FormLayout fl1_3 = new FormLayout();
		fl1_3.setLabelWidth(70);
		fl1_3.setLabelAlign(LabelAlign.RIGHT);
		lc1_3.setLayout(fl1_3);
		umytInsrSym = new MSFTextField();
		umytInsrSym.setFieldLabel("고용보험");
		lc1_3.add(umytInsrSym, new FormData("100%"));
		
		lc1.add(lc1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.23));
		
		LayoutContainer lc1_4 = new LayoutContainer();
		FormLayout fl1_4 = new FormLayout();
		fl1_4.setLabelWidth(70);
		fl1_4.setLabelAlign(LabelAlign.RIGHT);
		lc1_4.setLayout(fl1_4);
		idtlAccdtInsurSym = new MSFTextField();
		idtlAccdtInsurSym.setFieldLabel("산재보험");
		lc1_4.add(idtlAccdtInsurSym, new FormData("100%"));
		
		lc1.add(lc1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.23));
		
		fldstNewFieldset.add(lc1);
		
		plFrmResm3200.add(fldstNewFieldset, new FormData("100%"));
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * @wbp.parser.constructor
	 */
	public Resm3200() {

		setSize("1010px", "700px");
	}

	public Resm3200(String txtForm) {
		this.txtForm = txtForm;
	}

	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createResm3200Form() {

		plFrmResm3200 = new FormPanel();
		plFrmResm3200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 부서별사업관리"));
		plFrmResm3200.setIcon(Resources.APP_ICONS.text());
		plFrmResm3200.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("부서별사업관리","BASS0500");
				}
			});
		plFrmResm3200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmResm3200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		plFrmResm3200.setPadding(2);
		
		plFrmResm3200.setFrame(true);
		plFrmResm3200.setLayout(new FormLayout());
		
		
		LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.LEFT);
		
		
		
		
		btnResm3200Trnr = new Button("이전사업이관");
		btnResm3200Trnr.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
				ResmP320001 bassP05001Form = new ResmP320001(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwResm32001 = new MSFFormWindows("이전사업이관", bassP05001Form, "닫기", "820px", "710px", true);
				msFwResm32001.show();
				bassP05001Form.setMSFFormWindows(msFwResm32001);
				
    		}
    	});
		
		btnBar.add(btnResm3200Trnr);
		lc1.add(btnBar);
		
		
		
		LayoutContainer lc2 = new LayoutContainer();
		
		//ButtonBar buttonBar = new ButtonBar();
		topResm3200Bar = new ButtonBar();
		topResm3200Bar.setAlignment(HorizontalAlignment.RIGHT);
		

		//Button topBtn = new Button("신규");
		btnResm3200New = new Button("신규");
		btnResm3200New.setIcon(Resources.APP_ICONS.new16());
		btnResm3200New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//신규 버튼 클릭시 
    			mainFormInit();
    			subFormInit();
    			actionDatabase = ActionDatabase.INSERT;
//    			formResm3200Init();   
    		}
    	});
		/**
		btnResm3200New.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				dpobCd.setValue("");
				//2014.08.27 신규버튼 클릭시 상세정보 사업년도를 현재년도로 설정
				ResmUtils.setSelectedComboValue(businApptnYr, DateTimeFormat.getFormat("yyyy").format(new Date()), "commCd");
				//businApptnYr.setValue(new BaseModel());
				
				deptCd.setValue(new BaseModel());
				businEmymtTypOccuCd.setValue(new BaseModel());
				
				businCd.setValue("--자동생성--");
				businNm.setValue("");
				businRepbtyEmpNum.setValue("");
				idtlAccdtInsurApmrt.setValue("");
				spityCtnt.setValue("");
				
				natPennSym.setValue(""); 		//국민연금
				hlthInsrSym.setValue(""); 		//건강보험
				umytInsrSym.setValue(""); 		//고용보험
				idtlAccdtInsurSym.setValue(""); //산재보험
			}
		});
		*/
		topResm3200Bar.add(btnResm3200New);

		//topBtn = new Button("저장");
		btnResm3200Save = new Button("저장");
		btnResm3200Save.setIcon(Resources.APP_ICONS.save16());
		btnResm3200Save.addSelectionListener(selectionListener);
		/**
		btnResm3200Save.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				save(ActionDatabase.UPDATE);
			}
		});*/
		topResm3200Bar.add(btnResm3200Save);

		//topBtn = new Button("삭제");
		btnResm3200Del = new Button("삭제");
		btnResm3200Del.setIcon(Resources.APP_ICONS.delete16());
		btnResm3200Del.addSelectionListener(selectionListener);
		/**
		btnResm3200Del.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				save(ActionDatabase.DELETE);
			}
		});*/
		topResm3200Bar.add(btnResm3200Del);

		
		//topBtn = new Button("조회");
		btnResm3200Sreach = new Button("조회");
		btnResm3200Sreach.setIcon(Resources.APP_ICONS.search16());
		btnResm3200Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});
		topResm3200Bar.add(btnResm3200Sreach);

		
		//TODO 기능없으므로 닫아놓음
		//topBtn = new Button("인쇄");
//		btnResm3200Print = new Button("인쇄");
//		btnResm3200Print.setIcon(Resources.APP_ICONS.print16());
//		topResm3200Bar.add(btnResm3200Print);
		
		
		//TODO 기능없으므로 닫아놓음
		//topBtn = new Button("엑셀");
//		btnResm3200Excel = new Button("엑셀");
//		btnResm3200Excel.setIcon(Resources.APP_ICONS.excel16());
//		topResm3200Bar.add(btnResm3200Excel);
		
		
		
		//lc.add(buttonBarLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));
		lc2.add(topResm3200Bar);
		
		lc.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lc.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		plFrmResm3200.add(lc);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmResm3200.setAction("myurl"); // url 정보 추가 할것.
		plFrmResm3200.setEncoding(Encoding.MULTIPART);
		plFrmResm3200.setMethod(Method.POST);

		vp.add(plFrmResm3200);
		plFrmResm3200.setSize("990px", "680px");
	}
	
	public void save(final ActionDatabase actionDatabase){
		
		final Bass0500DTO dto = new Bass0500DTO();
		
		/*
		if( "".equals(businCd.getValue())){
			MessageBox.info("", "사업코드를 입력하여 주세요.", null);
		} 
		dpobCd.setValue(new BaseModel());
		if("".equals(dto.getBusinApptnYr()) || dto.getBusinApptnYr() == null){
			MessageBox.info("", "사업년도를 입력하여 주세요.", null);
			businApptnYr.focus();
		}**/
		if("".equals(businApptnYr.getValue()) || businApptnYr.getValue() == null){
			MessageBox.info("", "사업년도를 입력하여 주세요.", null);
			businApptnYr.focus();
		}else if("".equals(deptCd.getValue()) || deptCd.getValue() == null){
			MessageBox.info("", "부서명을 입력하여 주세요.", null);
			deptCd.focus();
		}else if("".equals(businNm.getValue()) || businNm.getValue() == null){
			MessageBox.info("", "사업명 입력하여 주세요.", null);
			businNm.focus();
		} else if("".equals(businRepbtyEmpNum.getValue()) || businRepbtyEmpNum.getValue() == null){
			MessageBox.info("", "담당직원을 입력하여 주세요.", null);
			businRepbtyEmpNum.focus();
		} else if("".equals(businStdt.getValue()) || businStdt.getValue() == null){
			MessageBox.info("", "시작일자를 입력하여 주세요.", null);
			businStdt.focus();
		} else if("".equals(businEddt.getValue()) || businEddt.getValue() == null){
			MessageBox.info("", "종료일자를 입력하여 주세요.", null);
			businEddt.focus();
		}else{
			
			dto.setDpobCd(dpobCd.getValue());
			dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(businApptnYr, "year") );	//사업년도
			dto.setDeptCd(ResmUtils.getSelectedComboValue(deptCd));								//부서코드
			dto.setBusinEmymtTypOccuCd(ResmUtils.getSelectedComboValue(businEmymtTypOccuCd));	//사업고용직종코드(산재보험직종)
			
			dto.setBusinCd(businCd.getValue());													//사업코드
			dto.setBusinNm(businNm.getValue());													//사업명
			dto.setBusinRepbtyEmpNum(businRepbtyEmpNum.getValue());								//담당직원
			dto.setIdtlAccdtInsurApmrt(idtlAccdtInsurApmrt.getValue());							//산재보험효율
			dto.setSpityCtnt(spityCtnt.getValue());												//특기사항
			dto.setBusinStdt(ResmUtils.getConvertDateToString(businStdt, "yyyyMMdd"));			//시작일자
			dto.setBusinEddt(ResmUtils.getConvertDateToString(businEddt, "yyyyMMdd"));			//종료일자
			
			dto.setNatPennSym(natPennSym.getValue()); 											//국민연금
			dto.setHlthInsrSym(hlthInsrSym.getValue()); 										//건강보험
			dto.setHlthInsrOfceSym(hlthInsrOfceSym.getValue()); 								//건강보험 영업소 기호
			dto.setUmytInsrSym(umytInsrSym.getValue()); 										//고용보험
			dto.setIdtlAccdtInsurSym(idtlAccdtInsurSym.getValue()); 							//산재보험
						
			
			MessageBox.confirm("","DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						bass0500Service.saveBass0500(dto, actionDatabase, new AsyncCallback<String>() {
							@Override
							public void onSuccess(String result) {
								if("DELETE".equals(actionDatabase.name())){
									MessageBox.info("", "삭제 되었습니다.", null);
								}else{
									MessageBox.info("", "저장 되었습니다.", null);
								}
								reload();
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnResm3200(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});
					}
				}
			});
		}
		
	}
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/	
	// TODO 검색필드 설정
	private void createSearchForm() {

		LayoutContainer lcSchCol = new LayoutContainer(new ColumnLayout());
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchLeft = new LayoutContainer();
		FormLayout frmlytSchLeft = new FormLayout();
		frmlytSchLeft.setLabelWidth(85);
		frmlytSchLeft.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft.setLayout(frmlytSchLeft);
		srhBusinApptnYr = new ComboBox<BaseModel>();
		srhBusinApptnYr.setName("srhBusinApptnYr");
		srhBusinApptnYr.setFieldLabel("사업년도");
		srhBusinApptnYr.setForceSelection(true);
		srhBusinApptnYr.setMinChars(1);
		srhBusinApptnYr.setDisplayField("yearDisp");
		srhBusinApptnYr.setValueField("year");
		srhBusinApptnYr.setTriggerAction(TriggerAction.ALL);
		srhBusinApptnYr.setEmptyText("--년도선택--");
		srhBusinApptnYr.setSelectOnFocus(true);
		srhBusinApptnYr.setStore(listStoreSrhYr);
		lcSchLeft.add(srhBusinApptnYr, new FormData("100%"));
		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));
		
		LayoutContainer lc1 = new LayoutContainer();
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(85);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);
		srhDeptCd = new ComboBox<BaseModel>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setFieldLabel("부서명");
		srhDeptCd.setForceSelection(true);
		srhDeptCd.setMinChars(1);
		srhDeptCd.setDisplayField("commCdNm");
		srhDeptCd.setValueField("commCd");
		srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.setSelectOnFocus(true);
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.setStore(listStoreSrhDeptCd);
		srhDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		srhDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		       public void handleEvent(StoreEvent<BaseModel> be) {  
	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
	               	      /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                    checkResm3200Auth("srhDeptCd", listStoreSrhDeptCd);  
		    	   }   
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
		         
		       }
		   });   
		lc1.add(srhDeptCd, new FormData("100%"));
		lcSchCol.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));
		
		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(85);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl2);
		srhBusinNm = new TextField<String>();
		srhBusinNm.setFieldLabel("사업명");
		lc2.add(srhBusinNm, new FormData("100%"));
		lcSchCol.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));
		
		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmResm3200.add(fieldSet);

	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createTabForm(){
		tabsResm3200 = new TabPanel(); // 인사탭정보설정을 위한 tab
		
		// tabsBass0350.setMinTabWidth(80);
		tabsResm3200.setAutoWidth(false);
		// tabsBass0350.setResizeTabs(true);
		tabsResm3200.setAnimScroll(true);
		tabsResm3200.setTabScroll(true);
		tabsResm3200.setPlain(true);
		tabsResm3200.setSize(970, 173);

		TabItem itemBass0350 = new TabItem();
		itemBass0350.setId("itemBass0350");
//		itemBass0350.setStyleAttribute("padding", "1"); 
		itemBass0350.setText("상세정보");
//		itemBass0350.addStyleName("pad-text");
		itemBass0350.setLayout(new FormLayout());
		itemBass0350.add(detailImfo01(), new FormData("100%"));
		tabsResm3200.add(itemBass0350);

		TabItem itemBass0351 = new TabItem();
		//itemBass0351.setStyleAttribute("padding", "10px");
		itemBass0351.setId("itemBass0351");
		itemBass0351.setText("설정정보");
		itemBass0351.setLayout(new FormLayout());
		itemBass0351.add(settingInfo01(), new FormData("100%"));
		tabsResm3200.add(itemBass0351);
		
		plFrmResm3200.add(tabsResm3200, new FormData("100%"));
	}
	
	// 상세정보 탭
	private LayoutContainer detailImfo01(){
			 
		LayoutContainer lcTabFormLayer = new LayoutContainer();
			
		ContentPanel di01 = new ContentPanel();
		di01.setHeaderVisible(false);
		di01.setFrame(true);
		di01.setSize(968, 198);
		di01.setLayout(new FitLayout());
			
		LayoutContainer lcStd01 = new LayoutContainer();
		//lcStd01.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd1 = new FormLayout();
		frmlytStd1.setLabelWidth(100);
		frmlytStd1.setLabelAlign(LabelAlign.RIGHT);
		lcStd01.setLayout(frmlytStd1);
			
		dpobCd = new MSFTextField();
			
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
			
		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(85);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(fl1_1);
		businApptnYr = new MSFComboBox<BaseModel>();
		businApptnYr.setFieldLabel("사업년도");
		businApptnYr.setName("businApptnYr");
		businApptnYr.setForceSelection(true);
		businApptnYr.setMinChars(1);
		businApptnYr.setDisplayField("yearDisp");
		businApptnYr.setValueField("year");
		businApptnYr.setTriggerAction(TriggerAction.ALL);
		businApptnYr.setEmptyText("--년도선택--");
		businApptnYr.setSelectOnFocus(true);
		businApptnYr.setStore(listStoreYr);
		lc1_1.add(businApptnYr, new FormData("100%"));
		lc1.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
			
		LayoutContainer lc1_2 = new LayoutContainer();
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(85);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lc1_2.setLayout(fl1_2);
		deptCd = new MSFComboBox<BaseModel>();
		deptCd.setFieldLabel("부서명");
		deptCd.setName("deptCd");
		deptCd.setForceSelection(true);
		deptCd.setMinChars(1);
		deptCd.setDisplayField("commCdNm");
		deptCd.setValueField("commCd");
		deptCd.setTriggerAction(TriggerAction.ALL);
		deptCd.setEmptyText("--부서선택--");
		deptCd.setSelectOnFocus(true);
		deptCd.setStore(listStoreDeptCd);
		lc1_2.add(deptCd, new FormData("100%"));
		lc1.add(lc1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
			
		LayoutContainer lc1_3 = new LayoutContainer();
		FormLayout fl1_3 = new FormLayout();
		fl1_3.setLabelWidth(85);
		fl1_3.setLabelAlign(LabelAlign.RIGHT);
		lc1_3.setLayout(fl1_3);
		businEmymtTypOccuCd = new MSFComboBox<BaseModel>();
		businEmymtTypOccuCd.setFieldLabel("산재보험직종");
		businEmymtTypOccuCd.setName("businEmymtTypOccuCd");
		businEmymtTypOccuCd.setForceSelection(true);
		businEmymtTypOccuCd.setMinChars(1);
		businEmymtTypOccuCd.setDisplayField("commCdNm");
		businEmymtTypOccuCd.setValueField("commCd");
		businEmymtTypOccuCd.setTriggerAction(TriggerAction.ALL);
		businEmymtTypOccuCd.setEmptyText("--선택--");
		businEmymtTypOccuCd.setSelectOnFocus(true);
		businEmymtTypOccuCd.setStore(listStoreI001);
		lc1_3.add(businEmymtTypOccuCd, new FormData("100%"));
		lc1.add(lc1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
			
		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
			
		LayoutContainer lc2_1 = new LayoutContainer();
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(85);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1.setLayout(fl2_1);
		businCd = new MSFTextField();
		businCd.setFieldLabel("사업코드");
		businCd.setReadOnly(true);
		businCd.disable();
		lc2_1.add(businCd, new FormData("100%"));
		
		lc2.add(lc2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc2_2 = new LayoutContainer();
		FormLayout fl2_2 = new FormLayout();
		fl2_2.setLabelWidth(85);
		fl2_2.setLabelAlign(LabelAlign.RIGHT);
		lc2_2.setLayout(fl2_2);
		businNm = new MSFTextField();
		businNm.setFieldLabel("사업명");
		lc2_2.add(businNm, new FormData("100%"));
		
		lc2.add(lc2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		pmdPernKey = new HiddenField<String>();
		pmdPernKey.setName("pmdPernKey");
		pmdPernKey.setFieldLabel("pmdPernKey");
		
		LayoutContainer lc2_3 = new LayoutContainer();
		FormLayout fl2_3 = new FormLayout();
		fl2_3.setLabelWidth(85);
		fl2_3.setLabelAlign(LabelAlign.RIGHT);
		lc2_3.setLayout(fl2_3);
		
		
		Button btnBusinRepbtyEmpNum = new Button();
		btnBusinRepbtyEmpNum.setIcon(MSFMainApp.ICONS.search());
		btnBusinRepbtyEmpNum.addListener(Events.Select, new Listener<ButtonEvent>() {
	           public void handleEvent(ButtonEvent e) {
	           	if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue()).trim().equals("")) {
	           		pmdPernKey.setValue("");
	               }
	           	fnPopupCommP980(businRepbtyEmpNum.getValue());
	           }
	       });
		
		
		businRepbtyEmpNum = new TextFieldWithButton<String>(btnBusinRepbtyEmpNum);
		businRepbtyEmpNum.setFieldLabel("담당직원");
		businRepbtyEmpNum.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				super.componentKeyUp(event);
				pmdPernKey.validate();
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
						if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue())
							.trim().equals("")) {
						pmdPernKey.setValue("");
					}
					fnPopupCommP980(businRepbtyEmpNum.getValue());
				}
			}
		});
			
//		businRepbtyEmpNum.addKeyListener(new KeyListener() {
//	           public void componentKeyUp(ComponentEvent event) {
////	               super.componentKeyUp(event);
//	               pmdPernKey.validate();
//	               if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	               	if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue()).trim().equals("")) {
//	               		pmdPernKey.setValue("");
//	                   }
//	               	fnPopupCommP980(businRepbtyEmpNum.getValue());
//	               }
//	           }
//	        });
		businRepbtyEmpNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
	          @Override
	          public void handleEvent(BaseEvent be) {  
	              if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue()).trim().equals("")) {
	              	pmdPernKey.setValue("");
	              }if (MSFSharedUtils.paramNull(businRepbtyEmpNum.getValue())) {
	              	pmdPernKey.setValue("");
	              }   
	          } 
	    }); 
		lc2_3.add(businRepbtyEmpNum, new FormData("100%"));
		
		lc2.add(lc2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		
		LayoutContainer lc3 = new LayoutContainer(new ColumnLayout());
		/**
		LayoutContainer lc3_1 = new LayoutContainer();
		FormLayout fl3_1 = new FormLayout();
		fl3_1.setLabelWidth(85);
		fl3_1.setLabelAlign(LabelAlign.RIGHT);
		lc3_1.setLayout(fl3_1);
		idtlAccdtInsurApmrt = new TextField<String>();
		idtlAccdtInsurApmrt.setFieldLabel("산재보험요율");
		lc3_1.add(idtlAccdtInsurApmrt, new FormData("100%"));
		*/
		
		LayoutContainer lc3_1 = new LayoutContainer();
		FormLayout fl3_1 = new FormLayout();
		fl3_1.setLabelWidth(85);
		fl3_1.setLabelAlign(LabelAlign.RIGHT);
		lc3_1.setLayout(fl3_1);
		businDutyNumDys = new MSFNumberField();
		businDutyNumDys.setFieldLabel("근무일수");
		lc3_1.add(businDutyNumDys, new FormData("100%"));
		
		lc3.add(lc3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		
		LayoutContainer lc3_2 = new LayoutContainer();
		FormLayout fl3_2 = new FormLayout();
		fl3_2.setLabelWidth(85);
		fl3_2.setLabelAlign(LabelAlign.RIGHT);
		lc3_2.setLayout(fl3_2);
		businStdt = new MSFDateField();
		new DateFieldMask(businStdt, "9999.99.99"); 
		businStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		businStdt.setFieldLabel("시작일자");
		lc3_2.add(businStdt, new FormData("100%"));
		
		lc3.add(lc3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc3_3 = new LayoutContainer();
		FormLayout fl3_3 = new FormLayout();
		fl3_3.setLabelWidth(85);
		fl3_3.setLabelAlign(LabelAlign.RIGHT);
		lc3_3.setLayout(fl3_3);
		businEddt = new MSFDateField();
		new DateFieldMask(businEddt, "9999.99.99"); 
		businEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		businEddt.setFieldLabel("종료일자");
		lc3_3.add(businEddt, new FormData("100%"));
		
		lc3.add(lc3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc4 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lc4_1 = new LayoutContainer();
		FormLayout fl4_1 = new FormLayout();
		fl4_1.setLabelWidth(85);
		fl4_1.setLabelAlign(LabelAlign.RIGHT);
		lc4_1.setLayout(fl4_1);
		idtlAccdtInsurApmrt = new MSFTextField();
		idtlAccdtInsurApmrt.setFieldLabel("산재보험요율");
		lc4_1.add(idtlAccdtInsurApmrt, new FormData("100%"));
		
		lc4.add(lc4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		
		LayoutContainer lc5 = new LayoutContainer();
		FormLayout fl5 = new FormLayout();
		fl5.setLabelWidth(85);
		fl5.setLabelAlign(LabelAlign.RIGHT);
		lc5.setLayout(fl5);
		spityCtnt = new MSFTextField();
		spityCtnt.setFieldLabel("특기사항");
		lc5.add(spityCtnt, new FormData("100%"));
					
		lcStd01.add(lc1, new FormData("100%"));		
		lcStd01.add(lc2, new FormData("100%"));
		lcStd01.add(lc3, new FormData("100%"));
		lcStd01.add(lc4, new FormData("100%"));
		lcStd01.add(lc5, new FormData("100%"));
		
		di01.add(lcStd01);
		lcTabFormLayer.add(di01);
		return lcTabFormLayer;
	}	
	
	private LayoutContainer settingInfo01(){
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel si01 = new ContentPanel();
		si01.setHeaderVisible(false);
		si01.setFrame(true);
		si01.setSize(968, 198);
		si01.setLayout(new FitLayout());
		
		lcTabFormLayer.add(si01);
		return lcTabFormLayer;
	}
		
	// TODO 상세정보 설정
	private void createStandardForm() {
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		
		dpobCd = new MSFTextField();
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(85);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(fl1_1);
		businApptnYr = new MSFComboBox<BaseModel>();
		businApptnYr.setFieldLabel("사업년도");
		businApptnYr.setName("businApptnYr");
		businApptnYr.setForceSelection(true);
		businApptnYr.setMinChars(1);
		businApptnYr.setDisplayField("yearDisp");
		businApptnYr.setValueField("year");
		businApptnYr.setTriggerAction(TriggerAction.ALL);
		businApptnYr.setEmptyText("--년도선택--");
		businApptnYr.setSelectOnFocus(true);
		businApptnYr.setStore(listStoreYr);
		lc1_1.add(businApptnYr, new FormData("100%"));
		lc1.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc1_2 = new LayoutContainer();
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(85);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lc1_2.setLayout(fl1_2);
		deptCd = new MSFComboBox<BaseModel>();
		deptCd.setFieldLabel("부서명");
		deptCd.setName("deptCd");
		deptCd.setForceSelection(true);
		deptCd.setMinChars(1);
		deptCd.setDisplayField("commCdNm");
		deptCd.setValueField("commCd");
		deptCd.setTriggerAction(TriggerAction.ALL);
		deptCd.setEmptyText("--부서선택--");
		deptCd.setSelectOnFocus(true);
		deptCd.setStore(listStoreDeptCd);
		lc1_2.add(deptCd, new FormData("100%"));
		lc1.add(lc1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc1_3 = new LayoutContainer();
		FormLayout fl1_3 = new FormLayout();
		fl1_3.setLabelWidth(85);
		fl1_3.setLabelAlign(LabelAlign.RIGHT);
		lc1_3.setLayout(fl1_3);
		businEmymtTypOccuCd = new MSFComboBox<BaseModel>();
		businEmymtTypOccuCd.setFieldLabel("산재보험직종");
		businEmymtTypOccuCd.setName("businEmymtTypOccuCd");
		businEmymtTypOccuCd.setForceSelection(true);
		businEmymtTypOccuCd.setMinChars(1);
		businEmymtTypOccuCd.setDisplayField("commCdNm");
		businEmymtTypOccuCd.setValueField("commCd");
		businEmymtTypOccuCd.setTriggerAction(TriggerAction.ALL);
		businEmymtTypOccuCd.setEmptyText("--선택--");
		businEmymtTypOccuCd.setSelectOnFocus(true);
		businEmymtTypOccuCd.setStore(listStoreI001);
		lc1_3.add(businEmymtTypOccuCd, new FormData("100%"));
		lc1.add(lc1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc2_1 = new LayoutContainer();
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(85);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1.setLayout(fl2_1);
		businCd = new MSFTextField();
		businCd.setFieldLabel("사업코드");
		businCd.setReadOnly(true);
		businCd.disable();
		lc2_1.add(businCd, new FormData("100%"));
		
		lc2.add(lc2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc2_2 = new LayoutContainer();
		FormLayout fl2_2 = new FormLayout();
		fl2_2.setLabelWidth(85);
		fl2_2.setLabelAlign(LabelAlign.RIGHT);
		lc2_2.setLayout(fl2_2);
		businNm = new MSFTextField();
		businNm.setFieldLabel("사업명");
		lc2_2.add(businNm, new FormData("100%"));
		
		lc2.add(lc2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		pmdPernKey = new HiddenField<String>();
		pmdPernKey.setName("pmdPernKey");
		pmdPernKey.setFieldLabel("pmdPernKey");
		
		LayoutContainer lc2_3 = new LayoutContainer();
		FormLayout fl2_3 = new FormLayout();
		fl2_3.setLabelWidth(85);
		fl2_3.setLabelAlign(LabelAlign.RIGHT);
		lc2_3.setLayout(fl2_3);
		
		
		Button btnBusinRepbtyEmpNum = new Button();
		btnBusinRepbtyEmpNum.setIcon(MSFMainApp.ICONS.search());
		btnBusinRepbtyEmpNum.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue()).trim().equals("")) {
            		pmdPernKey.setValue("");
                }
            	fnPopupCommP980(businRepbtyEmpNum.getValue());
            }
        });
		
		
		businRepbtyEmpNum = new TextFieldWithButton<String>(btnBusinRepbtyEmpNum);
		businRepbtyEmpNum.setFieldLabel("담당직원");
		businRepbtyEmpNum.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				super.componentKeyUp(event);
				pmdPernKey.validate();
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue())
							.trim().equals("")) {
						pmdPernKey.setValue("");
					}
					fnPopupCommP980(businRepbtyEmpNum.getValue());
				}
			}
		});
		
//		businRepbtyEmpNum.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
////                super.componentKeyUp(event);
//                pmdPernKey.validate();
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                	if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue()).trim().equals("")) {
//                		pmdPernKey.setValue("");
//                    }
//                	fnPopupCommP980(businRepbtyEmpNum.getValue());
//                }
//            }
//         });
		 businRepbtyEmpNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
                if (MSFSharedUtils.allowNulls(businRepbtyEmpNum.getValue()).trim().equals("")) {
                	pmdPernKey.setValue("");
                }if (MSFSharedUtils.paramNull(businRepbtyEmpNum.getValue())) {
                	pmdPernKey.setValue("");
                }   
            } 
        }); 
		lc2_3.add(businRepbtyEmpNum, new FormData("100%"));
		
		lc2.add(lc2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		
		LayoutContainer lc3 = new LayoutContainer(new ColumnLayout());
		/**
		LayoutContainer lc3_1 = new LayoutContainer();
		FormLayout fl3_1 = new FormLayout();
		fl3_1.setLabelWidth(85);
		fl3_1.setLabelAlign(LabelAlign.RIGHT);
		lc3_1.setLayout(fl3_1);
		idtlAccdtInsurApmrt = new TextField<String>();
		idtlAccdtInsurApmrt.setFieldLabel("산재보험요율");
		lc3_1.add(idtlAccdtInsurApmrt, new FormData("100%"));
		*/
		
		LayoutContainer lc3_1 = new LayoutContainer();
		FormLayout fl3_1 = new FormLayout();
		fl3_1.setLabelWidth(85);
		fl3_1.setLabelAlign(LabelAlign.RIGHT);
		lc3_1.setLayout(fl3_1);
		businDutyNumDys = new MSFNumberField();
		businDutyNumDys.setFieldLabel("근무일수");
		lc3_1.add(businDutyNumDys, new FormData("100%"));
		
		lc3.add(lc3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		
		LayoutContainer lc3_2 = new LayoutContainer();
		FormLayout fl3_2 = new FormLayout();
		fl3_2.setLabelWidth(85);
		fl3_2.setLabelAlign(LabelAlign.RIGHT);
		lc3_2.setLayout(fl3_2);
		businStdt = new MSFDateField();
		new DateFieldMask(businStdt, "9999.99.99"); 
		businStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		businStdt.setFieldLabel("시작일자");
		lc3_2.add(businStdt, new FormData("100%"));
		
		lc3.add(lc3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc3_3 = new LayoutContainer();
		FormLayout fl3_3 = new FormLayout();
		fl3_3.setLabelWidth(85);
		fl3_3.setLabelAlign(LabelAlign.RIGHT);
		lc3_3.setLayout(fl3_3);
		businEddt = new MSFDateField();
		new DateFieldMask(businEddt, "9999.99.99"); 
		businEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		businEddt.setFieldLabel("종료일자");
		lc3_3.add(businEddt, new FormData("100%"));
		
		lc3.add(lc3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		LayoutContainer lc4 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lc4_1 = new LayoutContainer();
		FormLayout fl4_1 = new FormLayout();
		fl4_1.setLabelWidth(85);
		fl4_1.setLabelAlign(LabelAlign.RIGHT);
		lc4_1.setLayout(fl4_1);
		idtlAccdtInsurApmrt = new MSFTextField();
		idtlAccdtInsurApmrt.setFieldLabel("산재보험요율");
		lc4_1.add(idtlAccdtInsurApmrt, new FormData("100%"));
		
		lc4.add(lc4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.33));
		
		
		LayoutContainer lc5 = new LayoutContainer();
		FormLayout fl5 = new FormLayout();
		fl5.setLabelWidth(85);
		fl5.setLabelAlign(LabelAlign.RIGHT);
		lc5.setLayout(fl5);
		spityCtnt = new MSFTextField();
		spityCtnt.setFieldLabel("특기사항");
		lc5.add(spityCtnt, new FormData("100%"));
			
		LayoutContainer middle_lc = new LayoutContainer();
		middle_lc.add(lc1, new FormData("100%"));
		middle_lc.add(lc2, new FormData("100%"));
		middle_lc.add(lc3, new FormData("100%"));
		middle_lc.add(lc4, new FormData("100%"));
		middle_lc.add(lc5, new FormData("100%"));
		
		
		fieldSet.add(middle_lc);
		plFrmResm3200.add(fieldSet);
		// vp.add(panel);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/
	//담당직원
    private void fnPopupCommP980(String usrNm) {
        MSFFormPanel popCom0980 = SysComPopupUtils.lovPopUpMsfSysComP0980Form(usrNm);  //부서
        
        final FormBinding popBindingCom0980 = popCom0980.getFormBinding();
        popBindingCom0980.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
            BaseModel mapModel = (BaseModel)be.getSource();
            if (!"".equals(mapModel.get("usrId"))) {
            	businRepbtyEmpNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrNm")));
            	}
           	}
        });
    }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// TODO 그리드
	private void createListGrid() {
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("부서정보");
		
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(940, 320);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		msfResm3200GridPanel = new MSFGridPanel(bass0500Def, false, false, false, false);
		msfResm3200GridPanel.setHeaderVisible(false);
		
		final Grid<BaseModel> grid = msfResm3200GridPanel.getMsfGrid().getGrid();
		grid.addListener(Events.RowClick, new Listener<GridEvent<BaseModel>>() {
			@Override
			public void handleEvent(GridEvent<BaseModel> be) {
				
				dpobCd.setValue(grid.getSelectionModel().getSelectedItem().get("dpobCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dpobCd")+"");
				//ResmUtils.setSelectedComboValue(businApptnYr, grid.getSelectionModel().getSelectedItem().get("businApptnYr")+"");//단위기관
				businApptnYr.setValue(listStoreYr.findModel("year", grid.getSelectionModel().getSelectedItem().get("businApptnYr")));
				ResmUtils.setSelectedComboValue(deptCd, grid.getSelectionModel().getSelectedItem().get("deptCd")+"");
				ResmUtils.setSelectedComboValue(businEmymtTypOccuCd, grid.getSelectionModel().getSelectedItem().get("businEmymtTypOccuCd")+"");
				
				businCd.setValue(grid.getSelectionModel().getSelectedItem().get("businCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("businCd")+"");
				businNm.setValue(grid.getSelectionModel().getSelectedItem().get("businNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("businNm")+"");
				businRepbtyEmpNum.setValue(grid.getSelectionModel().getSelectedItem().get("businRepbtyEmpNum") == null ? "" : grid.getSelectionModel().getSelectedItem().get("businRepbtyEmpNum")+"");
				idtlAccdtInsurApmrt.setValue(grid.getSelectionModel().getSelectedItem().get("idtlAccdtInsurApmrt") == null ? "" : grid.getSelectionModel().getSelectedItem().get("idtlAccdtInsurApmrt")+"");
				spityCtnt.setValue(grid.getSelectionModel().getSelectedItem().get("spityCtnt") == null ? "" : grid.getSelectionModel().getSelectedItem().get("spityCtnt")+"");
				businStdt.setValue(ResmUtils.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("businStdt"), "yyyyMMdd"));
				businEddt.setValue(ResmUtils.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("businEddt"), "yyyyMMdd"));
				
				natPennSym.setValue(grid.getSelectionModel().getSelectedItem().get("natPennSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("natPennSym")+""); //국민연금
				hlthInsrSym.setValue(grid.getSelectionModel().getSelectedItem().get("hlthInsrSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("hlthInsrSym")+""); //건강보험
				hlthInsrOfceSym.setValue(grid.getSelectionModel().getSelectedItem().get("hlthInsrOfceSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("hlthInsrOfceSym")+"");//건강보험영업소기호
				umytInsrSym.setValue(grid.getSelectionModel().getSelectedItem().get("umytInsrSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("umytInsrSym")+""); //고용보험
				idtlAccdtInsurSym.setValue(grid.getSelectionModel().getSelectedItem().get("idtlAccdtInsurSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("idtlAccdtInsurSym")+""); //산재보험
				
//				dpobCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd")+"");
//				ResmUtils.setSelectedComboValue(businApptnYr, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businApptnYr")+"");//단위기관
//				ResmUtils.setSelectedComboValue(deptCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptCd")+"");
//				ResmUtils.setSelectedComboValue(businEmymtTypOccuCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businEmymtTypOccuCd")+"");
//				
//				businCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businCd")+"");
//				businNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businNm")+"");
//				businRepbtyEmpNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businRepbtyEmpNum") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businRepbtyEmpNum")+"");
//				idtlAccdtInsurApmrt.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurApmrt") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurApmrt")+"");
//				spityCtnt.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("spityCtnt") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("spityCtnt")+"");
//				businStdt.setValue(ResmUtils.getConvertStringToDate((String)grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businStdt"), "yyyyMMdd"));
//				businEddt.setValue(ResmUtils.getConvertStringToDate((String)grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("businEddt"), "yyyyMMdd"));
//				
//				natPennSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym")+""); //국민연금
//				hlthInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym")+""); //건강보험
//				umytInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym")+""); //고용보험
//				idtlAccdtInsurSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym")+""); //산재보험
			}
		});

		cpGrid.add(msfResm3200GridPanel);
		// grid.setHeight("147px");

		lcStdGrid.add(cpGrid);
		fieldSet.add(lcStdGrid);

		plFrmResm3200.add(fieldSet);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	@Override
	public void reload() {
		
//		dpobCd.setValue("");							
//		businApptnYr.setValue(new BaseModel());			//사업년도
//		deptCd.setValue(new BaseModel());				//부서코드
//		businEmymtTypOccuCd.setValue(new BaseModel());	//사업고용직종코드
//		
//		businCd.setValue("");							//사업코드
//		businNm.setValue("");							//사업명
//		businRepbtyEmpNum.setValue("");					//사업담당직원번호
//		idtlAccdtInsurApmrt.setValue("");				//산재보험효율
//		spityCtnt.setValue("");							//근무일수
//		businStdt.setValue(null);						//시작일자
//		businEddt.setValue(null);						//종료일자
//		
//		natPennSym.setValue(""); 						//국민연금
//		hlthInsrSym.setValue(""); 						//건강보험
//		hlthInsrOfceSym.setValue("");					//건강보험 영업소 기호 
//		umytInsrSym.setValue(""); 						//고용보험
//		idtlAccdtInsurSym.setValue(""); 				//산재보험
		
		mainFormInit();	// 상세정보 초기화
		subFormInit();	// 사업장 관리번호 초기화
		
		
		IColumnFilter filters = null;
		msfResm3200GridPanel.getTableDef().setTableColumnFilters(filters);
		msfResm3200GridPanel.getTableDef().addColumnFilter("srhBusinApptnYr", MSFSharedUtils.getSelectedComboValue(srhBusinApptnYr, "year")  , SimpleColumnFilter.OPERATOR_LIKE);
		msfResm3200GridPanel.getTableDef().addColumnFilter("srhDeptCd", ResmUtils.getSelectedComboValue(srhDeptCd), SimpleColumnFilter.OPERATOR_LIKE);
		msfResm3200GridPanel.getTableDef().addColumnFilter("srhBusinNm", srhBusinNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfResm3200GridPanel.reload();
		
	}
	
	public void setRecord(BaseModel record){
		this.record = record;
	}
	
	public Resm3200 getThis(){
		return this;
	}
	
	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
	}-*/;
	
	
	private void formResm3200Init() {
		
		dpobCd.setValue("");
		//2014.08.27 신규버튼 클릭시 상세정보 사업년도를 현재년도로 설정
		 //ResmUtils.setSelectedComboValue(businApptnYr, DateTimeFormat.getFormat("yyyy").format(new Date()), "commCd");	//사업년도
		 businApptnYr.setValue(listStoreYr.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()) ));
		//businApptnYr.setValue(new BaseModel());
		deptCd.setValue(new BaseModel());				//부서코드
		businEmymtTypOccuCd.setValue(new BaseModel());	//사업고용직종코드
		
		businCd.setValue("");							//사업코드
		businNm.setValue("");							//사업명
		businRepbtyEmpNum.setValue("");					//사업담당직원번호
		idtlAccdtInsurApmrt.setValue("");				//산재보험효율
		
		spityCtnt.setValue("");							//특기사항
		businDutyNumDys.reset();						//근무일수
		businStdt.setValue(null); 						//시작일자
		businEddt.setValue(null);						//종료일자
		
		natPennSym.setValue(""); 						//국민연금
		hlthInsrSym.setValue(""); 						//건강보험
		hlthInsrOfceSym.setValue("");					//건강보험 영업소 기호 					
		umytInsrSym.setValue(""); 						//고용보험
		idtlAccdtInsurSym.setValue(""); 				//산재보험
		
		actionDatabase = ActionDatabase.INSERT;
	}
	
	
	// 상세정보 초기화
	private void mainFormInit() {
		dpobCd.setValue("");							//사업장코드
		//2014.08.27 신규버튼 클릭시 상세정보 사업년도를 현재년도로 설정
		 //ResmUtils.setSelectedComboValue(businApptnYr, DateTimeFormat.getFormat("yyyy").format(new Date()), "commCd");	//사업년도
		 businApptnYr.setValue(listStoreYr.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));	//사업년도
		//businApptnYr.setValue(new BaseModel());
		deptCd.setValue(new BaseModel());				//부서코드
		businEmymtTypOccuCd.setValue(new BaseModel());	//사업고용직종코드
		
		businCd.setValue("");							//사업코드
		businNm.setValue("");							//사업명
		businRepbtyEmpNum.setValue("");					//사업담당직원번호
		idtlAccdtInsurApmrt.setValue("");				//산재보험효율
		
		spityCtnt.setValue("");							//특기사항
		businDutyNumDys.reset();						//근무일수
		businStdt.setValue(null); 						//시작일자
		businEddt.setValue(null);						//종료일자
	}
	
	// 사업장 관리번호 초기화
	private void subFormInit() {
		natPennSym.setValue(""); 						//국민연금
		hlthInsrSym.setValue(""); 						//건강보험
		hlthInsrOfceSym.setValue("");					//건강보험 영업소 기호 					
		umytInsrSym.setValue(""); 						//고용보험
		idtlAccdtInsurSym.setValue(""); 				//산재보험
	}


	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : funcLogMessage
	 * @date : 2016. 9. 2.
	 * @author : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 2.		Administrator				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param wndName
	 * @param wndId
	 */
	public void funcLogMessage(String wndName, String wndId){
	
		 ShowMessageBM smForm = new ShowMessageBM();
		 smForm.setWindowId(wndId);
		 smForm.setWindowNm(wndName);
		//개별 화면 에러메시지 검색 팝업  
		GWTUtils.funcLogMessage(smForm);
	}  
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
 
}
