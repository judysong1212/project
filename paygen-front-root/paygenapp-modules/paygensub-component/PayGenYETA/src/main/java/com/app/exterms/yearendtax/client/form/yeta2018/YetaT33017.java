/**
 * 표준세액공제
 */
package com.app.exterms.yearendtax.client.form.yeta2018;


import java.util.Iterator;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye169010DTO;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaT33017Service;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaT33017ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaT33017   extends MSFFormPanel {  

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

	private  ContentPanel cpYetaT33017; 

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
	private MSFGridPanel YetaT33017GridPanel;
	//	private YetaT33017Def YetaT33017Def = new YetaT33017Def("YetaT33017");   //TODO 일단 화면번호로 Def
	// -------------- grid 선언 종료  ---------------


	// -------------- DTO 선언 시작 --------------
	private Ye169010DTO ye1690103Dto;
	// -------------- DTO 선언 종료 --------------


	// -------------- 서비스 호출 시작 --------------
	private YetaT33017ServiceAsync yetaT33017Service = YetaT33017Service.Util.getInstance();
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
	private TextField<String> srhDeptCd; 		// 부서
	private TextField<String> srhHanNm; 		// 성명

	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
	private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
	private HiddenField<String> yrtxBlggYr;	/** column 정산귀속년도 : edacRvyy */
	private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : settGbcd */
	private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
	
	private HiddenField<String>	 c152StdTxDdcYn;	
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

	private NumberField yetaSum1;	//기본공제 계
	private NumberField yetaSum2;	//추가공제 계	
	private NumberField yetaSum3;	//연금보험료공제 계
	private NumberField yetaSum4;	//특별소득공제 계
	private NumberField yetaSum5;	//차감소득금액 계

	private NumberField yetaSum6;	//그밖의소득공제 계
	private NumberField yetaSum7;	//소득공제종합한도초과액
	private NumberField yetaSum8;	//종합소득 과세표준
	private NumberField yetaSum9;	//산출세액
	private NumberField yetaSum10;	//세액감면 계

	private NumberField yetaSum11;	//근로소득공제
	private NumberField yetaSum12;	//자녁공제 계
	private NumberField yetaSum13;	//연금계좌 계
	private NumberField yetaSum14;	//보험료 계
	private NumberField yetaSum15;	//의료비 계

	private NumberField yetaSum16;	//교육비 계
	private NumberField yetaSum17;	//기부금 계
	private NumberField yetaSum18;	//특별세액공제 계
	private NumberField yetaSum19;	//표준세액공제 계
	private NumberField yetaSum20;	//납세조합공제 계

	private NumberField yetaSum21;	//주택차입금 계
	private NumberField yetaSum22;	//외국납부 계
	private NumberField yetaSum23;	//월세액 계
	private NumberField yetaSum24;	//세액공제 계
	private NumberField yetaSum25;	//결정세액 소득세

	private NumberField yetaSum26;	//기본공제 지방소득세
	private NumberField yetaSum27;	//기본공제 농특세

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

	public YetaT33017(final ActionDatabase actionDatabase, final MSFPanel caller) {

		//콤보 권한초기화
		//		initLoad(); 	

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		//layout.setDefaultWidth(590);
		// layout.setLabelWidth(0);  
		// this.setLayout(layout);   
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYetaT33017 = new ContentPanel();  

		createSearchForm();			//기본정보 필드를 적용
		createMsfGridForm();		//그리드필드
		setReadOnlyTrueYetaP23017();

		cpYetaT33017.setBodyBorder(false);
		cpYetaT33017.setBorders(false);
		cpYetaT33017.setHeaderVisible(false);
		cpYetaT33017.setSize("630px", "640px");

		this.add(cpYetaT33017);
		formBinding = new FormBinding(this, true);

		this.setSize("640px", "710px");  
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
		cpYetaT33017.add(systemkey);

		dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYetaT33017.add(dpobCd);

		yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYetaT33017.add(yrtxBlggYr);

		clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
		clutSeptCd.setName("clutSeptCd");
		cpYetaT33017.add(clutSeptCd);

		deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		deptNm.setName("deptNm");
		cpYetaT33017.add(deptNm);

		hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		hanNm.setName("hanNm");
		cpYetaT33017.add(hanNm);
		
		
		c152StdTxDdcYn = new HiddenField<String>();		
		c152StdTxDdcYn.setName("c152StdTxDdcYn");
		cpYetaT33017.add(c152StdTxDdcYn);

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");
		fieldSet.setWidth(590);

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		srhDeptCd = new TextField<String>();
		srhDeptCd.setReadOnly(true);
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setFieldLabel("부서");

		lcSchCol01.add(srhDeptCd, new FormData("80%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setReadOnly(true);
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");

		lcSchCol02.add(srhHanNm, new FormData("80%"));

		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYetaT33017.add(fieldSet);

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

		LayoutContainer layoutContainer1 = new LayoutContainer();

		FieldSet fldstNewFieldset1 = new FieldSet();
		fldstNewFieldset1.setHeadingHtml("종합소득공제");
		fldstNewFieldset1.setCollapsible(false);
		fldstNewFieldset1.setWidth(590);

		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		layoutContainer1_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer1_1_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1_1.setLayout(frmlytSch);

		yetaSum1 = new NumberField();
		yetaSum1.setAllowDecimals(true); 
		yetaSum1.setPropertyEditorType(Long.class); 
		yetaSum1.setFormat(NumberFormat.getDecimalFormat());
		yetaSum1.setFieldLabel("기본공제계");
		layoutContainer1_1_1.add(yetaSum1, new FormData("80%"));

		LayoutContainer layoutContainer1_1_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1_2.setLayout(frmlytSch);

		yetaSum2 = new NumberField();
		yetaSum2.setAllowDecimals(true); 
		yetaSum2.setPropertyEditorType(Long.class); 
		yetaSum2.setFormat(NumberFormat.getDecimalFormat());
		yetaSum2.setFieldLabel("추가공제계");
		layoutContainer1_1_2.add(yetaSum2, new FormData("80%"));

		layoutContainer1_1.add(layoutContainer1_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1_1.add(layoutContainer1_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset1.add(layoutContainer1_1);

		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		layoutContainer1_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer1_2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_2_1.setLayout(frmlytSch);

		yetaSum3 = new NumberField();
		yetaSum3.setAllowDecimals(true); 
		yetaSum3.setPropertyEditorType(Long.class); 
		yetaSum3.setFormat(NumberFormat.getDecimalFormat());
		yetaSum3.setFieldLabel("연금보험료공제계");
		layoutContainer1_2_1.add(yetaSum3, new FormData("80%"));

		LayoutContainer layoutContainer1_2_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_2_2.setLayout(frmlytSch);

		yetaSum4 = new NumberField();
		yetaSum4.setAllowDecimals(true); 
		yetaSum4.setPropertyEditorType(Long.class); 
		yetaSum4.setFormat(NumberFormat.getDecimalFormat());
		yetaSum4.setFieldLabel("특별소득공제계");
		layoutContainer1_2_2.add(yetaSum4, new FormData("80%"));

		layoutContainer1_2.add(layoutContainer1_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer1_2.add(layoutContainer1_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset1.add(layoutContainer1_2);

		layoutContainer1.add(fldstNewFieldset1);

		LayoutContainer layoutContainer2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2.setLayout(frmlytSch);
		layoutContainer2.setWidth(590);

		yetaSum5 = new NumberField();
		yetaSum5.setAllowDecimals(true); 
		yetaSum5.setPropertyEditorType(Long.class); 
		yetaSum5.setFormat(NumberFormat.getDecimalFormat());
		yetaSum5.setFieldLabel("차감소득금액");
		layoutContainer2.add(yetaSum5, new FormData("90%"));

		LayoutContainer layoutContainer3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch);
		layoutContainer3.setWidth(590);

		yetaSum6 = new NumberField();
		yetaSum6.setAllowDecimals(true); 
		yetaSum6.setPropertyEditorType(Long.class); 
		yetaSum6.setFormat(NumberFormat.getDecimalFormat());
		yetaSum6.setFieldLabel("그밖의소득공제계");
		layoutContainer3.add(yetaSum6, new FormData("90%"));

		LayoutContainer layoutContainer4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4.setLayout(frmlytSch);
		layoutContainer4.setWidth(590);

		yetaSum7 = new NumberField();
		yetaSum7.setAllowDecimals(true); 
		yetaSum7.setPropertyEditorType(Long.class); 
		yetaSum7.setFormat(NumberFormat.getDecimalFormat());
		yetaSum7.setFieldLabel("소득공제종합한도초과액");
		layoutContainer4.add(yetaSum7, new FormData("90%"));

		LayoutContainer layoutContainer5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5.setLayout(frmlytSch);
		layoutContainer5.setWidth(590);

		yetaSum8 = new NumberField();
		yetaSum8.setAllowDecimals(true); 
		yetaSum8.setPropertyEditorType(Long.class); 
		yetaSum8.setFormat(NumberFormat.getDecimalFormat());
		yetaSum8.setFieldLabel("종합소득과세표준");
		layoutContainer5.add(yetaSum8, new FormData("90%"));

		LayoutContainer layoutContainer6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6.setLayout(frmlytSch);
		layoutContainer6.setWidth(590);
		
		yetaSum9 = new NumberField();
		yetaSum9.setAllowDecimals(true); 
		yetaSum9.setPropertyEditorType(Long.class); 
		yetaSum9.setFormat(NumberFormat.getDecimalFormat());
		yetaSum9.setFieldLabel("산출세액");
		layoutContainer6.add(yetaSum9, new FormData("90%"));

		LayoutContainer layoutContainer7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7.setLayout(frmlytSch);
		layoutContainer7.setWidth(590);

		yetaSum10 = new NumberField();
		yetaSum10.setAllowDecimals(true); 
		yetaSum10.setPropertyEditorType(Long.class); 
		yetaSum10.setFormat(NumberFormat.getDecimalFormat());
		yetaSum10.setFieldLabel("세액감면");
		layoutContainer7.add(yetaSum10, new FormData("90%"));

		LayoutContainer layoutContainer8 = new LayoutContainer();

		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.setHeadingHtml("세액공제");
		fldstNewFieldset2.setCollapsible(false);
		fldstNewFieldset2.setWidth(590);

		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		layoutContainer2_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer2_1_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_1_1.setLayout(frmlytSch);

		yetaSum11 = new NumberField();
		yetaSum11.setAllowDecimals(true); 
		yetaSum11.setPropertyEditorType(Long.class); 
		yetaSum11.setFormat(NumberFormat.getDecimalFormat());
		yetaSum11.setFieldLabel("근로소득");
		layoutContainer2_1_1.add(yetaSum11, new FormData("80%"));

		LayoutContainer layoutContainer2_1_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_1_2.setLayout(frmlytSch);

		yetaSum12 = new NumberField();
		yetaSum12.setAllowDecimals(true); 
		yetaSum12.setPropertyEditorType(Long.class); 
		yetaSum12.setFormat(NumberFormat.getDecimalFormat());
		yetaSum12.setFieldLabel("자녀계");
		layoutContainer2_1_2.add(yetaSum12, new FormData("80%"));

		layoutContainer2_1.add(layoutContainer2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer2_1.add(layoutContainer2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset2.add(layoutContainer2_1);

		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		layoutContainer2_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer2_2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_2_1.setLayout(frmlytSch);

		yetaSum13 = new NumberField();
		yetaSum13.setAllowDecimals(true); 
		yetaSum13.setPropertyEditorType(Long.class); 
		yetaSum13.setFormat(NumberFormat.getDecimalFormat());
		yetaSum13.setFieldLabel("연금계좌계");
		layoutContainer2_2_1.add(yetaSum13, new FormData("80%"));

		LayoutContainer layoutContainer2_2_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_2_2.setLayout(frmlytSch);

		yetaSum14 = new NumberField();
		yetaSum14.setAllowDecimals(true); 
		yetaSum14.setPropertyEditorType(Long.class); 
		yetaSum14.setFormat(NumberFormat.getDecimalFormat());
		yetaSum14.setFieldLabel("보험료계");
		layoutContainer2_2_2.add(yetaSum14, new FormData("80%"));

		layoutContainer2_2.add(layoutContainer2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer2_2.add(layoutContainer2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset2.add(layoutContainer2_2);

		LayoutContainer layoutContainer2_3 = new LayoutContainer();
		layoutContainer2_3.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer2_3_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_3_1.setLayout(frmlytSch);

		yetaSum15 = new NumberField();
		yetaSum15.setAllowDecimals(true); 
		yetaSum15.setPropertyEditorType(Long.class); 
		yetaSum15.setFormat(NumberFormat.getDecimalFormat());
		yetaSum15.setFieldLabel("의료비계");
		layoutContainer2_3_1.add(yetaSum15, new FormData("80%"));

		LayoutContainer layoutContainer2_3_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_3_2.setLayout(frmlytSch);

		yetaSum16 = new NumberField();
		yetaSum16.setAllowDecimals(true); 
		yetaSum16.setPropertyEditorType(Long.class); 
		yetaSum16.setFormat(NumberFormat.getDecimalFormat());
		yetaSum16.setFieldLabel("교육비계");
		layoutContainer2_3_2.add(yetaSum16, new FormData("80%"));

		layoutContainer2_3.add(layoutContainer2_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer2_3.add(layoutContainer2_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset2.add(layoutContainer2_3);

		LayoutContainer layoutContainer2_4 = new LayoutContainer();
		layoutContainer2_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer2_4_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_4_1.setLayout(frmlytSch);

		yetaSum17 = new NumberField();
		yetaSum17.setAllowDecimals(true); 
		yetaSum17.setPropertyEditorType(Long.class); 
		yetaSum17.setFormat(NumberFormat.getDecimalFormat());
		yetaSum17.setFieldLabel("기부금계");
		layoutContainer2_4_1.add(yetaSum17, new FormData("80%"));

		LayoutContainer layoutContainer2_4_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_4_2.setLayout(frmlytSch);

		layoutContainer2_4.add(layoutContainer2_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer2_4.add(layoutContainer2_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset2.add(layoutContainer2_4);

		LayoutContainer layoutContainer2_5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_5.setLayout(frmlytSch);

		yetaSum18 = new NumberField();
		yetaSum18.setAllowDecimals(true); 
		yetaSum18.setPropertyEditorType(Long.class); 
		yetaSum18.setFormat(NumberFormat.getDecimalFormat());
		yetaSum18.setFieldLabel("특별세액공제계");
		layoutContainer2_5.add(yetaSum18, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_5);

		LayoutContainer layoutContainer2_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_6.setLayout(frmlytSch);

		yetaSum19 = new NumberField();
		yetaSum19.setAllowDecimals(true); 
		yetaSum19.setPropertyEditorType(Long.class); 
		yetaSum19.setFormat(NumberFormat.getDecimalFormat());
		yetaSum19.setFieldLabel("표준세액공제계");
		layoutContainer2_6.add(yetaSum19, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_6);

		LayoutContainer layoutContainer2_7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_7.setLayout(frmlytSch);

		yetaSum20 = new NumberField();
		yetaSum20.setAllowDecimals(true); 
		yetaSum20.setPropertyEditorType(Long.class); 
		yetaSum20.setFormat(NumberFormat.getDecimalFormat());
		yetaSum20.setFieldLabel("납세조합공제");
		layoutContainer2_7.add(yetaSum20, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_7);

		LayoutContainer layoutContainer2_8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_8.setLayout(frmlytSch);

		yetaSum21 = new NumberField();
		yetaSum21.setAllowDecimals(true); 
		yetaSum21.setPropertyEditorType(Long.class); 
		yetaSum21.setFormat(NumberFormat.getDecimalFormat());
		yetaSum21.setFieldLabel("주택차입금");
		layoutContainer2_8.add(yetaSum21, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_8);

		LayoutContainer layoutContainer2_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_9.setLayout(frmlytSch);

		yetaSum22 = new NumberField();
		yetaSum22.setAllowDecimals(true); 
		yetaSum22.setPropertyEditorType(Long.class); 
		yetaSum22.setFormat(NumberFormat.getDecimalFormat());
		yetaSum22.setFieldLabel("외국납부");
		layoutContainer2_9.add(yetaSum22, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_9);

		LayoutContainer layoutContainer2_10 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_10.setLayout(frmlytSch);

		yetaSum23 = new NumberField();
		yetaSum23.setAllowDecimals(true); 
		yetaSum23.setPropertyEditorType(Long.class); 
		yetaSum23.setFormat(NumberFormat.getDecimalFormat());
		yetaSum23.setFieldLabel("월세액계");
		layoutContainer2_10.add(yetaSum23, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_10);

		LayoutContainer layoutContainer2_11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(140);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_11.setLayout(frmlytSch);

		yetaSum24 = new NumberField();
		yetaSum24.setAllowDecimals(true); 
		yetaSum24.setPropertyEditorType(Long.class); 
		yetaSum24.setFormat(NumberFormat.getDecimalFormat());
		yetaSum24.setFieldLabel("세액공제계");
		layoutContainer2_11.add(yetaSum24, new FormData("90%"));
		fldstNewFieldset2.add(layoutContainer2_11);

		layoutContainer8.add(fldstNewFieldset2);

		LayoutContainer layoutContainer9 = new LayoutContainer();
		layoutContainer9.setLayout(new ColumnLayout());
		layoutContainer9.setWidth(575);

		LayoutContainer layoutContainer9_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_1.setLayout(frmlytSch);

		yetaSum25 = new MSFNumberField();
		yetaSum25.setAllowDecimals(true); 
		yetaSum25.setPropertyEditorType(Long.class); 
		yetaSum25.setFormat(NumberFormat.getDecimalFormat());
		yetaSum25.setFieldLabel("결정세액_소득세");
		layoutContainer9_1.add(yetaSum25, new FormData("100%"));
		layoutContainer9_1.setStyleAttribute("marginTop", "7px");

		LayoutContainer layoutContainer9_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_2.setLayout(frmlytSch);

		yetaSum26 = new MSFNumberField();
		yetaSum26.setAllowDecimals(true); 
		yetaSum26.setPropertyEditorType(Long.class); 
		yetaSum26.setFormat(NumberFormat.getDecimalFormat());
		yetaSum26.setFieldLabel("결정세액_지방소득세");
		layoutContainer9_2.add(yetaSum26, new FormData("100%"));
		layoutContainer9_2.setStyleAttribute("marginTop", "7px");

		LayoutContainer layoutContainer9_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(120);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_3.setLayout(frmlytSch);

		yetaSum27 = new MSFNumberField();
		yetaSum27.setAllowDecimals(true); 
		yetaSum27.setPropertyEditorType(Long.class); 
		yetaSum27.setFormat(NumberFormat.getDecimalFormat());
		yetaSum27.setFieldLabel("결정세액_농특세");
		layoutContainer9_3.add(yetaSum27, new FormData("100%"));
		layoutContainer9_3.setStyleAttribute("marginTop", "7px");

		layoutContainer9.add(layoutContainer9_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		layoutContainer9.add(layoutContainer9_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));
		layoutContainer9.add(layoutContainer9_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.333));

		cpYetaT33017.add(layoutContainer1);
		cpYetaT33017.add(layoutContainer2);
		cpYetaT33017.add(layoutContainer3);
		cpYetaT33017.add(layoutContainer4);
		cpYetaT33017.add(layoutContainer5);
		cpYetaT33017.add(layoutContainer6);
		cpYetaT33017.add(layoutContainer7);
		cpYetaT33017.add(layoutContainer8);
		cpYetaT33017.add(layoutContainer9);
	}	

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	} 

	@Override
	public void reload() {
		ye1690103Dto = new Ye169010DTO();

		ye1690103Dto.setDpobCd(dpobCd.getValue());			/**  column 사업장코드 : dpobCd */
		ye1690103Dto.setSystemkey(systemkey.getValue()); 	/**  column SYSTEMKEY : systemkey */
		ye1690103Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 정산구분코드 : clutSeptCd */
		ye1690103Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 연말정산귀속년도 : yrtxBlggYr */
		ye1690103Dto.setC152StdTxDdcYn(c152StdTxDdcYn.getValue());

		yetaT33017Service.getYetaP33017ToYe169010List(ye1690103Dto, new AsyncCallback<Ye169010DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYetaP23008ToYe160403List(" + actionDatabase.name() + ") : " + caught), null);

			}

			@Override
			public void onSuccess(Ye169010DTO result) {
				// TODO Auto-generated method stub
				readYetaP33017Data(result);
			}
		});
	}	 
	public void readYetaP33017Data(Ye169010DTO result) {
		
		yetaSum1.setValue(result.getYetaSum1());
		yetaSum2.setValue(result.getYetaSum2());
		yetaSum3.setValue(result.getYetaSum3());
		yetaSum4.setValue(result.getYetaSum4());
		yetaSum5.setValue(result.getYetaSum5());
		
		yetaSum6.setValue(result.getYetaSum6());
		yetaSum7.setValue(result.getYetaSum7());
		yetaSum8.setValue(result.getYetaSum8());
		yetaSum9.setValue(result.getYetaSum9());
		yetaSum10.setValue(result.getYetaSum10());
		
		yetaSum11.setValue(result.getYetaSum11());
		yetaSum12.setValue(result.getYetaSum12());
		yetaSum13.setValue(result.getYetaSum13());
		yetaSum14.setValue(result.getYetaSum14());
		yetaSum15.setValue(result.getYetaSum15());
		
		yetaSum16.setValue(result.getYetaSum16());
		yetaSum17.setValue(result.getYetaSum17());
		yetaSum18.setValue(result.getYetaSum18());
		yetaSum19.setValue(result.getYetaSum19());
		yetaSum20.setValue(result.getYetaSum20());
		
		yetaSum21.setValue(result.getYetaSum21());
		yetaSum22.setValue(result.getYetaSum22());
		yetaSum23.setValue(result.getYetaSum23());
		yetaSum24.setValue(result.getYetaSum24());
		yetaSum25.setValue(result.getYetaSum25());
		
		yetaSum26.setValue(result.getYetaSum26());
		yetaSum27.setValue(result.getYetaSum27());

	}
	
	public void setReadOnlyTrueYetaP23017() {
		srhDeptCd.setReadOnly(true);		// 부서
		srhHanNm.setReadOnly(true);
		
		yetaSum1.setReadOnly(true);
		yetaSum2.setReadOnly(true);
		yetaSum3.setReadOnly(true);
		yetaSum4.setReadOnly(true);
		yetaSum5.setReadOnly(true);
		
		yetaSum6.setReadOnly(true);
		yetaSum7.setReadOnly(true);
		yetaSum8.setReadOnly(true);
		yetaSum9.setReadOnly(true);
		yetaSum10.setReadOnly(true);
		
		yetaSum11.setReadOnly(true);
		yetaSum12.setReadOnly(true);
		yetaSum13.setReadOnly(true);
		yetaSum14.setReadOnly(true);
		yetaSum15.setReadOnly(true);
		
		yetaSum16.setReadOnly(true);
		yetaSum17.setReadOnly(true);
		yetaSum18.setReadOnly(true);
		yetaSum19.setReadOnly(true);
		yetaSum20.setReadOnly(true);
		
		yetaSum21.setReadOnly(true);
		yetaSum22.setReadOnly(true);
		yetaSum23.setReadOnly(true);
		yetaSum24.setReadOnly(true);
		yetaSum25.setReadOnly(true);
		
		yetaSum26.setReadOnly(true);
		yetaSum27.setReadOnly(true);
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
