/**
 * 월세엑소득공제명세
 */
package com.app.exterms.yearendtax.client.form.yeta2017;
  

import java.util.Iterator;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP220003   extends MSFFormPanel {  

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
 
	private FormPanel cpYeta22003;
	  
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
	private Boolean reading = false;
	public FormBinding formBinding;

	private Iterator<Record> records;

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
//  	private  ButtonBar topYetaBtnBar = new ButtonBar();
//	private  Button btnYetaNew = new Button();		//신규
//	private  Button btnYetaDel = new Button();		//삭제
//	private  Button btnYetaSave = new Button();		//저장
//	private  Button btnYetaClose = new Button();	//닫기

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
	private HiddenField<String> resnRegnNum; 	
	
	
	private FileUploadField ddxCrefileUpload; 		// PDF파일자료_파일업로드
	private TextField<String> ddcCrePasswd; 		// PDF파일자료_패스워드
	private HiddenField<Boolean> ddcCreOriginYn; 	// PDF파일자료_원본자동검증여부 
	private CheckBox ddcCreOriginChkYn; 			// PDF파일자료_원본자동검증여부
	private CheckBox stlRflSttChkYn; 
	
	private Boolean picBoolFile;
	
	
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
	private  ListStore<BaseModel> lsclutSeptCd = new ListStore<BaseModel>(); 		// 정산구분
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
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	 
	  
	public YetaP220003(final ActionDatabase actionDatabase, final MSFPanel caller) {
		
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
		   
	 	cpYeta22003 = new FormPanel();  

		createSearchForm();			//기본정보 필드를 적용
		   
		cpYeta22003.setBodyBorder(false);
		cpYeta22003.setBorders(false);
		cpYeta22003.setHeaderVisible(false);
		cpYeta22003.setSize("690px", "250px");
		   
		this.add(cpYeta22003);
		formBinding = new FormBinding(this, true);
		    
		this.setSize("680px", "250px");  
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
		cpYeta22003.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYeta22003.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYeta22003.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYeta22003.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYeta22003.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYeta22003.add(hanNm);
	    
	    resnRegnNum = new HiddenField<String>();		
	    resnRegnNum.setName("resnRegnNum");
	    cpYeta22003.add(resnRegnNum);
	    
	    
		ddcCreOriginYn = new HiddenField<Boolean>();
		ddcCreOriginYn.setName("ddcCreOriginYn");
		ddcCreOriginYn.setId("ddcCreOriginYn");
		cpYeta22003.add(ddcCreOriginYn);
			
		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		     

		cpYeta22003.setLayout(new FlowLayout());
		
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setWidth(650);
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);
			
		srhYrtxBlggYr = new TextField<String>();
		srhYrtxBlggYr.setName("srhYrtxBlggYr");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
		srhYrtxBlggYr.setFieldLabel("년도");
			
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
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsclutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
				
				reload();
				
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
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta22003.add(fieldSet);
		
		
		FieldSet ddcFieldSet = new FieldSet();
		ddcFieldSet.setWidth(650);
		ddcFieldSet.setHeadingHtml("공제신고서 PDF파일자료");
		ddcFieldSet.setHeight("130px");
		ddcFieldSet.setStyleAttribute("marginTop", "10px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer ddcLcSchCol = new LayoutContainer();
		ddcLcSchCol.setLayout(new ColumnLayout());
		ddcFieldSet.add(ddcLcSchCol, new FormData("100%"));

		/** column text : PDF파일자료_파일업로드 crefileUpload */
		LayoutContainer ddcLayoutContainer1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer1.setLayout(frmlytSch);

		ddxCrefileUpload = new FileUploadField();
		ddxCrefileUpload.setName("ddxCrefileUpload");
		ddxCrefileUpload.setFieldLabel("파일업로드");
		ddxCrefileUpload.setSelectOnFocus(true);
		ddxCrefileUpload.setStyleAttribute("marginBottom", "5px");
		ddcLayoutContainer1.add(ddxCrefileUpload, new FormData("100%"));
		ddcLayoutContainer1.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));

		/** column text : PDF파일자료_패스워드 crePasswd */
		LayoutContainer ddcLayoutContainer2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer2.setLayout(frmlytSch);

		ddcCrePasswd = new TextField<String>();
		ddcCrePasswd.setName("ddcCrePasswd");
		ddcCrePasswd.setId("ddcCrePasswd");
		ddcCrePasswd.setFieldLabel("패스워드");
		ddcCrePasswd.setSelectOnFocus(true);
		ddcCrePasswd.setPassword(true);
		ddcLayoutContainer2.add(ddcCrePasswd, new FormData("100%"));
		ddcLayoutContainer2.setBorders(false);
		ddcLcSchCol.add(ddcLayoutContainer2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		/** column text : PDF파일자료_원본자동검증여부 creOriginYn */
		LayoutContainer ddcLayoutContainer3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer3.setLayout(frmlytSch);

		ddcCreOriginChkYn = new CheckBox();
		ddcCreOriginChkYn.setName("ddcCreOriginChkYn");
		ddcCreOriginChkYn.setBoxLabel("원본여부");
		ddcCreOriginChkYn.setValue(false);
		ddcLayoutContainer3.add(ddcCreOriginChkYn, new FormData("100%"));
		ddcLcSchCol.add(ddcLayoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer ddcLayoutContainer4 = new LayoutContainer();

		stlRflSttChkYn = new CheckBox();
		stlRflSttChkYn.setName("stlRflSttChkYn");
		stlRflSttChkYn.setBoxLabel("정산반영여부");
		stlRflSttChkYn.setReadOnly(true);
		stlRflSttChkYn.setLabelSeparator("");
		stlRflSttChkYn.setValueAttribute("Y");
		ddcLayoutContainer4.add(stlRflSttChkYn, new FormData("100%"));
		ddcLayoutContainer4.hide();
		ddcLcSchCol.add(ddcLayoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		/** column text : text */
		LayoutContainer ddcLayoutContainer5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		ddcLayoutContainer5.setLayout(frmlytSch);

		Label ddcTxt1 = new Label();
		Label ddcTxt2 = new Label();
		ddcTxt1.setText("* PDF 비밀번호는 인사 정보를 이용해 자동비교 됩니다.");
		ddcTxt2.setText("* PDF 검증여부에 체크된 경우 원본검증은 자동처리 됩니다.");
		ddcLayoutContainer5.setStyleAttribute("paddingLeft", "10px");
		ddcLayoutContainer5.setStyleAttribute("marginTop", "5px");
		ddcLayoutContainer5.setStyleAttribute("marginBottom", "5px");
		ddcLayoutContainer5.add(ddcTxt1, new FormData("100%"));
		ddcLayoutContainer5.add(ddcTxt2, new FormData("100%"));

		ddcLcSchCol.add(ddcLayoutContainer5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));

		Button topDdcBtn = new Button("PDF 소득공제자료추출");
		topDdcBtn.setIcon(MSFMainApp.ICONS.new16());
		topDdcBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				ddcCreOriginYn.setValue(ddcCreOriginChkYn.getValue());
				xmlImportDdcData();
				
			}
		});

		ddcLcSchCol.add(topDdcBtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		cpYeta22003.add(ddcFieldSet);
		
		
	}    
	 	 
   	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				srhDeptCd.setValue(deptNm.getValue());
				YetaUtils.setCheckedCheckBoxValue(stlRflSttChkYn ,"Y");	
				srhYrtxBlggYr.setValue(yrtxBlggYr.getValue());
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
		
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
		
	private void xmlImportDdcData() { 

		MessageBox.confirm("전자문서", "전자문서를 업로드 하시겠습니까?<br>(등록되어있는 전자문서가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					final Timer tmMask01 = new Timer() {
						public void run() {
							cancel();
							cpYeta22003.unmask();  
//							reloadYeta2200();
//							reloadYeta2200Result();
							// }
						}
					};		        		  

					if("".equals(systemkey.getValue())){
						MessageBox.alert("", "PDF 전자문서 업로드 대상자를 선택하십시요.", null);
					} else if("".equals(clutSeptCd.getValue())){
						MessageBox.alert("", "정산구분은 필수 선택조건입니다.", null);
					} else { 
						//get the filename to be uploaded

						String filename = MSFSharedUtils.allowNulls(ddxCrefileUpload.getValue());

						if (filename.length() == 0) {
							Window.alert("선택된 파일이 없습니다.");
						} else {
							//submit the form
							cpYeta22003.mask("PDF 전자문서 업데이트 중입니다. 업로드 중..."); 

							//파일업로드 처리
							cpYeta22003.setAction(GWT.getHostPageBaseURL() + "/imp/XmlYeta2200DdcImport.do");
							cpYeta22003.setEncoding(Encoding.MULTIPART);
							cpYeta22003.setMethod(Method.POST);   
							cpYeta22003.submit();  
							cpYeta22003.onFrameLoad();  
							picBoolFile = true;
							tmMask01.scheduleRepeating(5000);
						}               

						// reset and unmask the form 
						// after file upload 
						cpYeta22003.addListener(Events.Submit, new Listener<FormEvent>() {
							public void handleEvent(FormEvent evt) {   
								
							};
						});
					}
				}	
			}	
		}); 
	} 

		
}
