/**
 * 비과세 및 감면소득 입력
 */
package com.app.exterms.yearendtax.client.form.yeta2017;
  
 
import java.util.Iterator;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160403DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23008Service;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23008ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
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
public  class YetaP23008   extends MSFFormPanel { 

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
 
	private ContentPanel cpYeta23008;
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/

		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/


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
	private MSFFormPanel caller2;
	private Boolean reading = false;
	public FormBinding formBinding;

	private BaseModel record;
	private Iterator<Record> records;

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
  	private  ButtonBar topYetaBtnBar = new ButtonBar();
  	private  Button btnYetaSave = new Button();	//저장


  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private HiddenField<String> yrtxBlggYr;			/** column 연말정산귀속년도 : yrtxBlggYr */
	private HiddenField<String> clutSeptCd;			/** column 정산구분코드 : clutSeptCd */
	private HiddenField<String> systemkey;  		/**  column SYSTEMKEY : systemkey */
	private HiddenField<String> deptNm;			
	private HiddenField<String> bsnoEncCntn;		/**  column 사업자등록번호 : bsnoEncCntn */
	private HiddenField<String>	dpobCd;				/**  column 사업장코드 : dpobCd */
	private HiddenField<String>	elctYymm;	
	
 	// -------------- 검색 조건 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private YetaP23008ServiceAsync yetaP23008Service = YetaP23008Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
	// -------------- DTO 호출 시작 --------------
	private Ye160403DTO ye160403Dto;
	// -------------- DTO 호출 종료 --------------
	
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

	private TextField<String> hanNm;			// 성명
	private TextField<String> srhBsnoEncCntn; 	// 사업자등록번호
	private TextField<String> srhSiteCtnt; 		// 근무지명
    
    /**비과세부분 */
    private  NumberField taxmSg01Bi;    // ⑱-5 G01-비과세 학자금
    private  NumberField taxmSh01Bi;    // ⑱-9 H01-무보수위원수당
    private  NumberField taxmSh05Bi;    // ⑱-18 H05-경호·승선수당
    private  NumberField taxmSh06Bi;    // ⑱-4 H06-유아·초중등
    private  NumberField taxmSh07Bi;    // ⑱-4 H07-고등교육법
    private  NumberField taxmSh08Bi;    // ⑱-4 H08-특별법
    private  NumberField taxmSh09Bi;    // ⑱-4 H09-연구기관
    private  NumberField taxmSh10Bi;    // ⑱-4 H10-기업부설연구소
    private  NumberField taxmSh14Bi;    // ⑱-22 H14-보육교사
    private  NumberField taxmSh15Bi;    // ⑱-23 H15-사립유치원수석교사
    private  NumberField taxmSh11Bi;    // ⑱-6 H11-취재수당
    private  NumberField taxmSh12Bi;    // ⑱-7 H12-벽지수당
    private  NumberField taxmSh13Bi;    // ⑱-8 H13-재해관련급여
    private  NumberField taxmSh16Bi;    // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
    private  NumberField taxmSi01Bi;    // ⑱-19 l01-외국정부 근무자
    private  NumberField taxmSk01Bi;    // ⑱-10 K01-외국주둔군인
    private  NumberField taxmSm01Bi;    // ⑱ M01-국외근로 100만원
    private  NumberField taxmSm02Bi;    // ⑱ M02-국외근로 300만원
    private  NumberField taxmSm03Bi;    // ⑱ M03-국외근로
    private  NumberField taxmSo01Bi;    // ⑱-1 O01-야간근로수당
    private  NumberField taxmSq01Bi;    // ⑱-2 Q01-출산보육수당
    private  NumberField taxmSr10Bi;    // ⑱-21 R10-근로장학금
    private  NumberField taxmSr11Bi;    // ⑱-21 R11-직무발명보상금
    private  NumberField taxmSs01Bi;    // ⑱-11 S01-주식매수선택권
    private  NumberField taxmSy02Bi;    // ⑱-14 Y02-우리사주조합인출금50%
    private  NumberField taxmSy03Bi;    // ⑱-15 Y03-우리사주조합인출금70%
    private  NumberField taxmSy04Bi;    // ⑱-15 Y04-우리사주조합인출금100%

//    private  NumberField taxmSy21Bi; // ⑱-20 Y21-장기미취업자 중소기업 취업     TODO 2017년도삭제필요
    private  NumberField taxmSy22Bi;    // ⑲ Y22-전공의 수련 보조수당
     
    /**감면소득 부분 */
    private  NumberField taxmSt01Bi;    // ⑱-12 T01-외국인기술자
    private  NumberField taxmSt10Bi;    // ⑱-24 T10-중소기업취업 청년 소득세 감면
    private  NumberField taxmSt11Bi;    // ⑱-24 T11-중소기업취업 청년 소득세 감면
    private  NumberField taxmSt12Bi;    // ⑱-24 T12-중소기업취업 청년 소득세 감면
    private  NumberField taxmSt20Bi;    // ⑱-25 T20-조세조약상 교직자 감면
    
    
    private NumberField taxmSa01Bi; 	// A01-복무병 급여
    private NumberField taxmSb01Bi; 	// B01-동원직장 급여
    private NumberField taxmSc01Bi;		// C01-요양 급여
    private NumberField taxmSd01Bi;		// D01-요양 보상금
    private NumberField taxmSe01Bi;		// E01-육아휴직급여
    private NumberField taxmSe02Bi;		// E02-육아휴직수당
    private NumberField taxmSe10Bi;		// E10-사망일시금
    private NumberField taxmSf01Bi;		// F01-요양비
    
    private NumberField taxmSh02Bi;		// H02-일직·숙직료 
    private NumberField taxmSh03Bi;		// H03-자가운전보조금
    private NumberField taxmSh04Bi;		// H04-착용제복금
    
    private NumberField taxmSj01Bi;		// J01-보훈·학습보조비
    private NumberField taxmSj10Bi;		// J10-전직대통령 연금

    private NumberField taxmSl01Bi;		// L01-중군군인전사 과세급여
    
    private NumberField taxmSn01Bi;		// N01-국민건강보험 보험료
    
    private NumberField taxmSp01Bi;		// P01-비과세 식대
    private NumberField taxmSp02Bi;		// P02-현물 급식
    
    private NumberField taxmSr01Bi;		//R01-국군포로 보수
    
    
    /** 총계 부분*/
    private  NumberField taxeTotl;    // ⑳ 비과세 계
    private  NumberField taxmTotl;    // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
    
    
    
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  



	public YetaP23008(final ActionDatabase actionDatabase, final MSFPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYeta23008 = new ContentPanel();

		createStandardForm();
		setReadOnlyTrueYetaP13008();

		cpYeta23008.setBodyBorder(false);
		cpYeta23008.setBorders(false);
		cpYeta23008.setHeaderVisible(false);
		cpYeta23008.setSize("790px", "680px");

		this.add(cpYeta23008);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "750px");
	}
	  
	public YetaP23008(final ActionDatabase actionDatabase, final MSFFormPanel caller2) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller2 = caller2;

		cpYeta23008 = new ContentPanel();

		createStandardForm();
		setReadOnlyFalseYetaP13008();

		cpYeta23008.setBodyBorder(false);
		cpYeta23008.setBorders(false);
		cpYeta23008.setHeaderVisible(false);
		cpYeta23008.setSize("790px", "640px");

		this.add(cpYeta23008);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "710px");
	}
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 생성자 함수 선언부 종료
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/		 	 
			
   	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				
				srhSiteCtnt.setValue(deptNm.getValue());
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
		
	private void createStandardForm() {

		systemkey = new HiddenField<String>();		/** column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta23008.add(systemkey);

		dpobCd = new HiddenField<String>();			/** column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYeta23008.add(dpobCd);

		yrtxBlggYr = new HiddenField<String>();		/** column 정산년도 : yrtxBlggYr */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYeta23008.add(yrtxBlggYr);

		clutSeptCd = new HiddenField<String>();		/** column 정산구분코드 : clutSeptCd */
		clutSeptCd.setName("clutSeptCd");
		cpYeta23008.add(clutSeptCd);

		bsnoEncCntn = new HiddenField<String>();	/** column 사업자등록번호 : bsnoEncCntn */
		bsnoEncCntn.setName("bsnoEncCntn");
		cpYeta23008.add(bsnoEncCntn);
		
		elctYymm = new HiddenField<String>();
		elctYymm.setName("elctYymm");
		cpYeta23008.add(elctYymm);
		
		
		deptNm = new HiddenField<String>();
		deptNm.setName("deptNm");
		deptNm.addListener(Events.Show, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
			}
		});		
		
		cpYeta23008.add(deptNm);

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				doAction(actionDatabase);

//				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
//					actionDatabase = ActionDatabase.INSERT;
//				} else {
//					actionDatabase = ActionDatabase.UPDATE;
//				}

			}
		});
		topYetaBtnBar.add(btnYetaSave);
		cpYeta23008.add(topYetaBtnBar);
			
			
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

		hanNm = new TextField<String>();
		hanNm.setName("hanNm");
		hanNm.setFieldLabel("성명");
		hanNm.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_1.add(hanNm, new FormData("100%"));
		lcSchLeft.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchCenter = new LayoutContainer();
		lcSchCenter.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(110);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		srhBsnoEncCntn = new TextField<String>();
		srhBsnoEncCntn.setName("srhBsnoEncCntn");
		srhBsnoEncCntn.setFieldLabel("사업자등록번호");
		new TextFieldMask<String>(srhBsnoEncCntn, "999-99-99999");
		srhBsnoEncCntn.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_2.add(srhBsnoEncCntn, new FormData("100%"));
		lcSchCenter.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchCenter.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch);

		srhSiteCtnt = new TextField<String>();
		srhSiteCtnt.setName("srhSiteCtnt");
		srhSiteCtnt.setFieldLabel("근무지명");
		srhSiteCtnt.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_3.add(srhSiteCtnt, new FormData("100%"));
		lcSchRight.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(lcSchCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));

		lcSchCol.setBorders(true);
		lcSchCol.setHeight(35);
		lcSchCol.setStyleAttribute("marginTop", "5px;");
		cpYeta23008.add(lcSchCol);

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("비과세");
		// fieldSet.setHeight(470);
		fieldSet.setStyleAttribute("marginTop", "5px;");
			
			
		// 비과세 첫번째 줄
		LayoutContainer lcSchCol1_2 = new LayoutContainer();
		lcSchCol1_2.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_2 = new LayoutContainer();

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);

		taxmSg01Bi = new NumberField();
		taxmSg01Bi.setAllowDecimals(true);
		taxmSg01Bi.setPropertyEditorType(Long.class);
		taxmSg01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSg01Bi.setName("taxmSg01Bi");
		taxmSg01Bi.setFieldLabel("G01-비과세 학자금");
		taxmSg01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_4.add(taxmSg01Bi, new FormData("100%"));
		lcSchLeft1_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchCenter1_2 = new LayoutContainer();

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytSch);

		taxmSh01Bi = new NumberField();
		taxmSh01Bi.setAllowDecimals(true);
		taxmSh01Bi.setPropertyEditorType(Long.class);
		taxmSh01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh01Bi.setName("taxmSh01Bi");
		taxmSh01Bi.setFieldLabel("H01-무보수위원수당");
		taxmSh01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_5.add(taxmSh01Bi, new FormData("100%"));
		lcSchCenter1_2.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
			
		LayoutContainer lcSchRight1_2 = new LayoutContainer();

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);

		taxmSh05Bi = new NumberField();
		taxmSh05Bi.setAllowDecimals(true);
		taxmSh05Bi.setPropertyEditorType(Long.class);
		taxmSh05Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh05Bi.setName("taxmSh05Bi");
		taxmSh05Bi.setFieldLabel("H05-경호·승선수당");
		taxmSh05Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_6.add(taxmSh05Bi, new FormData("100%"));
		lcSchRight1_2.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol1_2.add(lcSchLeft1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_2.add(lcSchCenter1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_2.add(lcSchRight1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
		// 비과세 두번째 줄
		LayoutContainer lcSchCol1_3 = new LayoutContainer();
		lcSchCol1_3.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_3 = new LayoutContainer();

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);

		taxmSh06Bi = new NumberField();
		taxmSh06Bi.setAllowDecimals(true);
		taxmSh06Bi.setPropertyEditorType(Long.class);
		taxmSh06Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh06Bi.setName("taxmSh06Bi");
		taxmSh06Bi.setFieldLabel("H06-유아·초중등");
		taxmSh06Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_7.add(taxmSh06Bi, new FormData("100%"));
		lcSchLeft1_3.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		LayoutContainer lcSchCenter1_3 = new LayoutContainer();

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);

		taxmSh07Bi = new NumberField();
		taxmSh07Bi.setAllowDecimals(true);
		taxmSh07Bi.setPropertyEditorType(Long.class);
		taxmSh07Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh07Bi.setName("taxmSh07Bi");
		taxmSh07Bi.setFieldLabel("H07-고등교육법");
		taxmSh07Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_8.add(taxmSh07Bi, new FormData("100%"));
		lcSchCenter1_3.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		LayoutContainer lcSchRight1_3 = new LayoutContainer();

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSch);

		taxmSh08Bi = new NumberField();
		taxmSh08Bi.setAllowDecimals(true);
		taxmSh08Bi.setPropertyEditorType(Long.class);
		taxmSh08Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh08Bi.setName("taxmSh08Bi");
		taxmSh08Bi.setFieldLabel("H08-특별법");
		taxmSh08Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_9.add(taxmSh08Bi, new FormData("100%"));
		lcSchRight1_3.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		lcSchCol1_3.add(lcSchLeft1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_3.add(lcSchCenter1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_3.add(lcSchRight1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
			
		// 비과세 세번째 줄
		LayoutContainer lcSchCol1_4 = new LayoutContainer();
		lcSchCol1_4.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_4 = new LayoutContainer();

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);

		taxmSh09Bi = new NumberField();
		taxmSh09Bi.setAllowDecimals(true);
		taxmSh09Bi.setPropertyEditorType(Long.class);
		taxmSh09Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh09Bi.setName("taxmSh09Bi");
		taxmSh09Bi.setFieldLabel("H09-연구기관");
		taxmSh09Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_10.add(taxmSh09Bi, new FormData("100%"));
		lcSchLeft1_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_4 = new LayoutContainer();

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytSch);

		taxmSh10Bi = new NumberField();
		taxmSh10Bi.setAllowDecimals(true);
		taxmSh10Bi.setPropertyEditorType(Long.class);
		taxmSh10Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh10Bi.setName("taxmSh10Bi");
		taxmSh10Bi.setFieldLabel("H10-기업부설연구소");
		taxmSh10Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_11.add(taxmSh10Bi, new FormData("100%"));
		lcSchCenter1_4.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight1_4 = new LayoutContainer();

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytSch);

		taxmSh14Bi = new NumberField();
		taxmSh14Bi.setAllowDecimals(true);
		taxmSh14Bi.setPropertyEditorType(Long.class);
		taxmSh14Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh14Bi.setName("taxmSh14Bi");
		taxmSh14Bi.setFieldLabel("H14-보육교사");
		taxmSh14Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_12.add(taxmSh14Bi, new FormData("100%"));
		lcSchRight1_4.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		lcSchCol1_4.add(lcSchLeft1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_4.add(lcSchCenter1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_4.add(lcSchRight1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
			
		// 비과세 네번째 줄
		LayoutContainer lcSchCol1_5 = new LayoutContainer();
		lcSchCol1_5.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_5 = new LayoutContainer();

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytSch);

		taxmSh15Bi = new NumberField();
		taxmSh15Bi.setAllowDecimals(true);
		taxmSh15Bi.setPropertyEditorType(Long.class);
		taxmSh15Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh15Bi.setName("taxmSh15Bi");
		taxmSh15Bi.setFieldLabel("H15-사립유치원수석교사");
		taxmSh15Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_13.add(taxmSh15Bi, new FormData("100%"));
		lcSchLeft1_5.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchCenter1_5 = new LayoutContainer();

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);

		taxmSh11Bi = new NumberField();
		taxmSh11Bi.setAllowDecimals(true);
		taxmSh11Bi.setPropertyEditorType(Long.class);
		taxmSh11Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh11Bi.setName("taxmSh11Bi");
		taxmSh11Bi.setFieldLabel("H11-취재수당");
		taxmSh11Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_14.add(taxmSh11Bi, new FormData("100%"));

		lcSchCenter1_5.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight1_5 = new LayoutContainer();

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSch);

		taxmSh12Bi = new NumberField();
		taxmSh12Bi.setAllowDecimals(true);
		taxmSh12Bi.setPropertyEditorType(Long.class);
		taxmSh12Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh12Bi.setName("taxmSh12Bi");
		taxmSh12Bi.setFieldLabel("H12-벽지수당");
		taxmSh12Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_15.add(taxmSh12Bi, new FormData("100%"));
		lcSchRight1_5.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		lcSchCol1_5.add(lcSchLeft1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_5.add(lcSchCenter1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_5.add(lcSchRight1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			

			
		// 비과세 다섯번째 줄
		LayoutContainer lcSchCol1_6 = new LayoutContainer();
		lcSchCol1_6.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_6 = new LayoutContainer();

		LayoutContainer layoutContainer_16 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytSch);

		taxmSh13Bi = new NumberField();
		taxmSh13Bi.setAllowDecimals(true);
		taxmSh13Bi.setPropertyEditorType(Long.class);
		taxmSh13Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh13Bi.setName("taxmSh13Bi");
		taxmSh13Bi.setFieldLabel("H13-재해관련급여");
		taxmSh13Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_16.add(taxmSh13Bi, new FormData("100%"));
		lcSchLeft1_6.add(layoutContainer_16);
			
			
			
			
		LayoutContainer lcSchCenter1_6 = new LayoutContainer();

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_17.setLayout(frmlytSch);

		taxmSh16Bi = new NumberField();
		taxmSh16Bi.setAllowDecimals(true);
		taxmSh16Bi.setPropertyEditorType(Long.class);
		taxmSh16Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh16Bi.setName("taxmSh16Bi");
		taxmSh16Bi.setFieldLabel("H16-정부공공 이주수당");
		taxmSh16Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_17.add(taxmSh16Bi, new FormData("100%"));
		lcSchCenter1_6.add(layoutContainer_17);
			
			
			
		LayoutContainer lcSchRight1_6 = new LayoutContainer();

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytSch);

		taxmSi01Bi = new NumberField();

		taxmSi01Bi.setAllowDecimals(true);
		taxmSi01Bi.setPropertyEditorType(Long.class);
		taxmSi01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSi01Bi.setName("taxmSi01Bi");
		taxmSi01Bi.setFieldLabel("l01-외국정부 근무자");
		taxmSi01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_18.add(taxmSi01Bi, new FormData("100%"));
		lcSchRight1_6.add(layoutContainer_18);
			
			
		lcSchCol1_6.add(lcSchLeft1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_6.add(lcSchCenter1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_6.add(lcSchRight1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
		// 비과세 여섯번째 줄
		LayoutContainer lcSchCol1_7 = new LayoutContainer();
		lcSchCol1_7.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_7 = new LayoutContainer();

		LayoutContainer layoutContainer_19 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_19.setLayout(frmlytSch);

		taxmSk01Bi = new NumberField();
		taxmSk01Bi.setAllowDecimals(true);
		taxmSk01Bi.setPropertyEditorType(Long.class);
		taxmSk01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSk01Bi.setName("taxmSk01Bi");
		taxmSk01Bi.setFieldLabel("K01-외국주둔군인");
		taxmSk01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_19.add(taxmSk01Bi, new FormData("100%"));
		lcSchLeft1_7.add(layoutContainer_19);
			
			
			
			
		LayoutContainer lcSchCenter1_7 = new LayoutContainer();

		LayoutContainer layoutContainer_20 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytSch);

		taxmSm01Bi = new NumberField();
		taxmSm01Bi.setAllowDecimals(true);
		taxmSm01Bi.setPropertyEditorType(Long.class);
		taxmSm01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSm01Bi.setName("taxmSm01Bi");
		taxmSm01Bi.setFieldLabel("M01-국외근로 100만원");
		taxmSm01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_20.add(taxmSm01Bi, new FormData("100%"));
		lcSchCenter1_7.add(layoutContainer_20);
			
			
			
		LayoutContainer lcSchRight1_7 = new LayoutContainer();

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);

		taxmSm02Bi = new NumberField();
		taxmSm02Bi.setAllowDecimals(true);
		taxmSm02Bi.setPropertyEditorType(Long.class);
		taxmSm02Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSm02Bi.setName("taxmSm02Bi");
		taxmSm02Bi.setFieldLabel("M02-국외근로 300만원");
		taxmSm02Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_21.add(taxmSm02Bi, new FormData("100%"));
		lcSchRight1_7.add(layoutContainer_21);
			

		
		lcSchCol1_7.add(lcSchLeft1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_7.add(lcSchCenter1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_7.add(lcSchRight1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			

		// 비과세 일곱번째 줄
		LayoutContainer lcSchCol1_8 = new LayoutContainer();
		lcSchCol1_8.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_8 = new LayoutContainer();

		LayoutContainer layoutContainer_22 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_22.setLayout(frmlytSch);

		taxmSm03Bi = new NumberField();
		taxmSm03Bi.setAllowDecimals(true);
		taxmSm03Bi.setPropertyEditorType(Long.class);
		taxmSm03Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSm03Bi.setName("taxmSm03Bi");
		taxmSm03Bi.setFieldLabel("M03-국외근로");
		taxmSm03Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_22.add(taxmSm03Bi, new FormData("100%"));
		lcSchLeft1_8.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_8 = new LayoutContainer();

		LayoutContainer layoutContainer_23 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_23.setLayout(frmlytSch);

		taxmSo01Bi = new NumberField();

		taxmSo01Bi.setAllowDecimals(true);
		taxmSo01Bi.setPropertyEditorType(Long.class);
		taxmSo01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSo01Bi.setName("taxmSo01Bi");
		taxmSo01Bi.setFieldLabel("O01-야간근로수당");
		taxmSo01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_23.add(taxmSo01Bi, new FormData("100%"));
		lcSchCenter1_8.add(layoutContainer_23);
			
			
			
		LayoutContainer lcSchRight1_8 = new LayoutContainer();

		LayoutContainer layoutContainer_24 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24.setLayout(frmlytSch);

		taxmSq01Bi = new NumberField();
		taxmSq01Bi.setAllowDecimals(true);
		taxmSq01Bi.setPropertyEditorType(Long.class);
		taxmSq01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSq01Bi.setName("taxmSq01Bi");
		taxmSq01Bi.setFieldLabel("Q01-출산보육수당");
		taxmSq01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_24.add(taxmSq01Bi, new FormData("100%"));
		lcSchRight1_8.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol1_8.add(lcSchLeft1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_8.add(lcSchCenter1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_8.add(lcSchRight1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
		// 비과세 여덟번째 줄
		LayoutContainer lcSchCol1_9 = new LayoutContainer();
		lcSchCol1_9.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_9 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft1_9.setLayout(frmlytSch);

		taxmSr10Bi = new NumberField();
		taxmSr10Bi.setAllowDecimals(true);
		taxmSr10Bi.setPropertyEditorType(Long.class);
		taxmSr10Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSr10Bi.setName("taxmSr10Bi");
		taxmSr10Bi.setFieldLabel("R10-근로장학금");
		taxmSr10Bi.setStyleAttribute("marginTop", "5px;");
		
		lcSchLeft1_9.add(taxmSr10Bi, new FormData("100%"));
			
			
		LayoutContainer lcSchCenter1_9 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter1_9.setLayout(frmlytSch);

		taxmSs01Bi = new NumberField();
		taxmSs01Bi.setAllowDecimals(true);
		taxmSs01Bi.setPropertyEditorType(Long.class);
		taxmSs01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSs01Bi.setName("taxmSs01Bi");
		taxmSs01Bi.setFieldLabel("S01-주식매수선택권");
		taxmSs01Bi.setStyleAttribute("marginTop", "5px;");
		
		lcSchCenter1_9.add(taxmSs01Bi, new FormData("100%"));
			
			
			
		LayoutContainer lcSchRight1_9 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight1_9.setLayout(frmlytSch);

		taxmSy02Bi = new NumberField();
		taxmSy02Bi.setAllowDecimals(true);
		taxmSy02Bi.setPropertyEditorType(Long.class);
		taxmSy02Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSy02Bi.setName("taxmSy02Bi");
		taxmSy02Bi.setFieldLabel("Y02-사주조합인출50%");
		taxmSy02Bi.setStyleAttribute("marginTop", "5px;");
		
		lcSchRight1_9.add(taxmSy02Bi, new FormData("100%"));
			
			
			
		lcSchCol1_9.add(lcSchLeft1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_9.add(lcSchCenter1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_9.add(lcSchRight1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
			
			
		// 비과세 아홉번째 줄
		LayoutContainer lcSchCol1_10 = new LayoutContainer();
		lcSchCol1_10.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_10 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft1_10.setLayout(frmlytSch);

		taxmSy03Bi = new NumberField();
		taxmSy03Bi.setAllowDecimals(true);
		taxmSy03Bi.setPropertyEditorType(Long.class);
		taxmSy03Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSy03Bi.setName("taxmSy03Bi");
		taxmSy03Bi.setFieldLabel("Y03-사주조합인출70%");
		taxmSy03Bi.setStyleAttribute("marginTop", "5px;");
		lcSchLeft1_10.add(taxmSy03Bi, new FormData("100%"));
			
			
			
			
		LayoutContainer lcSchCenter1_10 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter1_10.setLayout(frmlytSch);

		taxmSy04Bi = new NumberField();
		taxmSy04Bi.setAllowDecimals(true);
		taxmSy04Bi.setPropertyEditorType(Long.class);
		taxmSy04Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSy04Bi.setName("taxmSy04Bi");
		taxmSy04Bi.setFieldLabel("Y04-사주조합인출100%");
		taxmSy04Bi.setStyleAttribute("marginTop", "5px;");
		
		lcSchCenter1_10.add(taxmSy04Bi, new FormData("100%"));
			
			
			
		LayoutContainer lcSchRight1_10 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight1_10.setLayout(frmlytSch);
		
		

		taxmSy22Bi = new NumberField();
		taxmSy22Bi.setAllowDecimals(true);
		taxmSy22Bi.setPropertyEditorType(Long.class);
		taxmSy22Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSy22Bi.setName("taxmSy22Bi");
		taxmSy22Bi.setFieldLabel("Y22-전공의 수련 보조수당");
		taxmSy22Bi.setStyleAttribute("fontSize", "10pt");
		taxmSy22Bi.setStyleAttribute("marginTop", "5px;");
		
		lcSchRight1_10.add(taxmSy22Bi, new FormData("100%"));
			
			
			
		lcSchCol1_10.add(lcSchLeft1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_10.add(lcSchCenter1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_10.add(lcSchRight1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
			
		// 비과세 열번째 줄
		LayoutContainer lcSchCol1_11 = new LayoutContainer();
		lcSchCol1_11.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_11 = new LayoutContainer();

		LayoutContainer layoutContainer_31 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_31.setLayout(frmlytSch);

		taxmSa01Bi = new NumberField();

		taxmSa01Bi.setAllowDecimals(true);
		taxmSa01Bi.setPropertyEditorType(Long.class);
		taxmSa01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSa01Bi.setName("taxmSa01Bi");
		taxmSa01Bi.setFieldLabel("A01-복무병 급여");
		taxmSa01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_31.add(taxmSa01Bi, new FormData("100%"));
		lcSchLeft1_11.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_11 = new LayoutContainer();

		LayoutContainer layoutContainer_32 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytSch);

		taxmSb01Bi = new NumberField();

		taxmSb01Bi.setAllowDecimals(true);
		taxmSb01Bi.setPropertyEditorType(Long.class);
		taxmSb01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSb01Bi.setName("taxmSb01Bi");
		taxmSb01Bi.setFieldLabel("B01-동원직장 급여");
		taxmSb01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_32.add(taxmSb01Bi, new FormData("100%"));

		lcSchCenter1_11.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchRight1_11 = new LayoutContainer();

		LayoutContainer layoutContainer_33 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_33.setLayout(frmlytSch);

		taxmSc01Bi = new NumberField();

		taxmSc01Bi.setAllowDecimals(true);
		taxmSc01Bi.setPropertyEditorType(Long.class);
		taxmSc01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSc01Bi.setName("taxmSc01Bi");
		taxmSc01Bi.setFieldLabel("C01-요양 급여");
		taxmSc01Bi.setStyleAttribute("fontSize", "10pt");
		taxmSc01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_33.add(taxmSc01Bi, new FormData("100%"));

		lcSchRight1_11.add(layoutContainer_33, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol1_11.add(lcSchLeft1_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_11.add(lcSchCenter1_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_11.add(lcSchRight1_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
	

		// 비과세 열한번째 줄
		LayoutContainer lcSchCol1_12 = new LayoutContainer();
		lcSchCol1_12.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_12 = new LayoutContainer();

		LayoutContainer layoutContainer_34 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_34.setLayout(frmlytSch);

		taxmSd01Bi = new NumberField();

		taxmSd01Bi.setAllowDecimals(true);
		taxmSd01Bi.setPropertyEditorType(Long.class);
		taxmSd01Bi.setFormat(NumberFormat.getDecimalFormat());
			
		taxmSd01Bi.setName("taxmSd01Bi");
		taxmSd01Bi.setFieldLabel("D01-요양 보상금");
		taxmSd01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_34.add(taxmSd01Bi, new FormData("100%"));

		lcSchLeft1_12.add(layoutContainer_34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_12 = new LayoutContainer();

		LayoutContainer layoutContainer_35 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_35.setLayout(frmlytSch);

		taxmSe01Bi = new NumberField();

		taxmSe01Bi.setAllowDecimals(true);
		taxmSe01Bi.setPropertyEditorType(Long.class);
		taxmSd01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSe01Bi.setName("taxmSe01Bi");
		taxmSe01Bi.setFieldLabel("E01-육아휴직급여");
		taxmSe01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_35.add(taxmSe01Bi, new FormData("100%"));

		lcSchCenter1_12.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
			
		LayoutContainer lcSchRight1_12 = new LayoutContainer();

		LayoutContainer layoutContainer_36 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_36.setLayout(frmlytSch);

		taxmSe02Bi = new NumberField();

		taxmSe02Bi.setAllowDecimals(true);
		taxmSe02Bi.setPropertyEditorType(Long.class);
		taxmSe02Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSe02Bi.setName("taxmSe02Bi");
		taxmSe02Bi.setFieldLabel("E02-육아휴직수당");
		taxmSe02Bi.setStyleAttribute("fontSize", "10pt");
		taxmSe02Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_36.add(taxmSe02Bi, new FormData("100%"));
		lcSchRight1_12.add(layoutContainer_36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		lcSchCol1_12.add(lcSchLeft1_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_12.add(lcSchCenter1_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_12.add(lcSchRight1_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));

			

			
		// 비과세 열두번째 줄
		LayoutContainer lcSchCol1_13 = new LayoutContainer();
		lcSchCol1_13.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_13 = new LayoutContainer();

		LayoutContainer layoutContainer_37 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_37.setLayout(frmlytSch);

		taxmSe10Bi = new NumberField();
		taxmSe10Bi.setAllowDecimals(true);
		taxmSe10Bi.setPropertyEditorType(Long.class);
		taxmSe10Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSe10Bi.setName("taxmSe10Bi");
		taxmSe10Bi.setFieldLabel("E10-사망일시금");
		taxmSe10Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_37.add(taxmSe10Bi, new FormData("100%"));

		lcSchLeft1_13.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_13 = new LayoutContainer();

		LayoutContainer layoutContainer_38 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_38.setLayout(frmlytSch);

		taxmSf01Bi = new NumberField();
		taxmSf01Bi.setAllowDecimals(true);
		taxmSf01Bi.setPropertyEditorType(Long.class);
		taxmSf01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSf01Bi.setName("taxmSf01Bi");
		taxmSf01Bi.setFieldLabel("F01-요양비");
		taxmSf01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_38.add(taxmSf01Bi, new FormData("100%"));

		lcSchCenter1_13.add(layoutContainer_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
			
		LayoutContainer lcSchRight1_13 = new LayoutContainer();

		LayoutContainer layoutContainer_39 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_39.setLayout(frmlytSch);

		taxmSh02Bi = new NumberField();
		taxmSh02Bi.setAllowDecimals(true);
		taxmSh02Bi.setPropertyEditorType(Long.class);
		taxmSh02Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh02Bi.setName("taxmSh02Bi");
		taxmSh02Bi.setFieldLabel("H02-일직·숙직료");
		taxmSh02Bi.setStyleAttribute("fontSize", "10pt");
		taxmSh02Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_39.add(taxmSh02Bi, new FormData("100%"));

		lcSchRight1_13.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		lcSchCol1_13.add(lcSchLeft1_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_13.add(lcSchCenter1_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_13.add(lcSchRight1_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
	
			
		// 비과세 열세번째 줄
		LayoutContainer lcSchCol1_14 = new LayoutContainer();
		lcSchCol1_14.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_14 = new LayoutContainer();

		LayoutContainer layoutContainer_40 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_40.setLayout(frmlytSch);

		taxmSh03Bi = new NumberField();
		taxmSh03Bi.setAllowDecimals(true);
		taxmSh03Bi.setPropertyEditorType(Long.class);
		taxmSh03Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh03Bi.setName("taxmSh03Bi");
		taxmSh03Bi.setFieldLabel("H03-자가운전보조금");
		taxmSh03Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_40.add(taxmSh03Bi, new FormData("100%"));
		lcSchLeft1_14.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_14 = new LayoutContainer();

		LayoutContainer layoutContainer_41 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_41.setLayout(frmlytSch);

		taxmSh04Bi = new NumberField();
		taxmSh04Bi.setAllowDecimals(true);
		taxmSh04Bi.setPropertyEditorType(Long.class);
		taxmSh04Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSh04Bi.setName("taxmSh04Bi");
		taxmSh04Bi.setFieldLabel("H04-착용제복금");
		taxmSh04Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_41.add(taxmSh04Bi, new FormData("100%"));
		lcSchCenter1_14.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight1_14 = new LayoutContainer();

		LayoutContainer layoutContainer_42 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytSch);

		taxmSj01Bi = new NumberField();
		taxmSj01Bi.setAllowDecimals(true);
		taxmSj01Bi.setPropertyEditorType(Long.class);
		taxmSj01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSj01Bi.setName("taxmSj01Bi");
		taxmSj01Bi.setFieldLabel("J01-보훈·학습보조비");
		taxmSj01Bi.setStyleAttribute("fontSize", "10pt");
		taxmSj01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_42.add(taxmSj01Bi, new FormData("100%"));
		lcSchRight1_14.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol1_14.add(lcSchLeft1_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_14.add(lcSchCenter1_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_14.add(lcSchRight1_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			

		// 비과세 열네번째 줄
		LayoutContainer lcSchCol1_15 = new LayoutContainer();
		lcSchCol1_15.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_15 = new LayoutContainer();

		LayoutContainer layoutContainer_43 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_43.setLayout(frmlytSch);

		taxmSj10Bi = new NumberField();

		taxmSj10Bi.setAllowDecimals(true);
		taxmSj10Bi.setPropertyEditorType(Long.class);
		taxmSj10Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSj10Bi.setName("taxmSj10Bi");
		taxmSj10Bi.setFieldLabel("J10-전직대통령 연금");
		taxmSj10Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_43.add(taxmSj10Bi, new FormData("100%"));
		lcSchLeft1_15.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_15 = new LayoutContainer();

		LayoutContainer layoutContainer_44 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_44.setLayout(frmlytSch);

		taxmSl01Bi = new NumberField();
		taxmSl01Bi.setAllowDecimals(true);
		taxmSl01Bi.setPropertyEditorType(Long.class);
		taxmSl01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSl01Bi.setName("taxmSl01Bi");
		taxmSl01Bi.setFieldLabel("L01-군인전사 과세급여");
		taxmSl01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_44.add(taxmSl01Bi, new FormData("100%"));

		lcSchCenter1_15.add(layoutContainer_44, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		LayoutContainer lcSchRight1_15 = new LayoutContainer();

		LayoutContainer layoutContainer_45 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_45.setLayout(frmlytSch);

		taxmSn01Bi = new NumberField();

		taxmSn01Bi.setAllowDecimals(true);
		taxmSn01Bi.setPropertyEditorType(Long.class);
		taxmSn01Bi.setFormat(NumberFormat.getDecimalFormat());

		taxmSn01Bi.setName("taxmSn01Bi");
		taxmSn01Bi.setFieldLabel("N01-국민건강보험 보험료");
		taxmSn01Bi.setStyleAttribute("fontSize", "10pt");
		taxmSn01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_45.add(taxmSn01Bi, new FormData("100%"));
		lcSchRight1_15.add(layoutContainer_45, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol1_15.add(lcSchLeft1_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_15.add(lcSchCenter1_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_15.add(lcSchRight1_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
		// 비과세 열다번째 줄
		LayoutContainer lcSchCol1_16 = new LayoutContainer();
		lcSchCol1_16.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft1_16 = new LayoutContainer();

		LayoutContainer layoutContainer_46 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_46.setLayout(frmlytSch);

		taxmSp01Bi = new NumberField();
		taxmSp01Bi.setAllowDecimals(true);
		taxmSp01Bi.setPropertyEditorType(Long.class);
		taxmSp01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSp01Bi.setName("taxmSp01Bi");
		taxmSp01Bi.setFieldLabel("P01-비과세 식대");
		taxmSp01Bi.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_46.add(taxmSp01Bi, new FormData("100%"));
		lcSchLeft1_16.add(layoutContainer_46, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_16 = new LayoutContainer();

		LayoutContainer layoutContainer_47 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_47.setLayout(frmlytSch);

		taxmSp02Bi = new NumberField();
		taxmSp02Bi.setAllowDecimals(true);
		taxmSp02Bi.setPropertyEditorType(Long.class);
		taxmSp02Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSp02Bi.setName("taxmSp02Bi");
		taxmSp02Bi.setFieldLabel("P02-현물 급식");
		taxmSp02Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_47.add(taxmSp02Bi, new FormData("100%"));

		lcSchCenter1_16.add(layoutContainer_47, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchRight1_16 = new LayoutContainer();

		LayoutContainer layoutContainer_48 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_48.setLayout(frmlytSch);

		taxmSr01Bi = new NumberField();
		taxmSr01Bi.setAllowDecimals(true);
		taxmSr01Bi.setPropertyEditorType(Long.class);
		taxmSr01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSr01Bi.setName("taxmSr01Bi");
		taxmSr01Bi.setFieldLabel("R01-국군포로 보수");
		taxmSr01Bi.setStyleAttribute("fontSize", "10pt");
		taxmSr01Bi.setStyleAttribute("marginTop", "5px;");
		layoutContainer_48.add(taxmSr01Bi, new FormData("100%"));

		lcSchRight1_16.add(layoutContainer_48, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol1_16.add(lcSchLeft1_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_16.add(lcSchCenter1_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol1_16.add(lcSchRight1_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			

		// 비과세 열여번째 줄
		LayoutContainer lcSchCol5_16 = new LayoutContainer();
		lcSchCol5_16.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft11_16 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft11_16.setLayout(frmlytSch);
		
		taxmSr11Bi = new NumberField();
		taxmSr11Bi.setAllowDecimals(true);
		taxmSr11Bi.setPropertyEditorType(Long.class);
		taxmSr11Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSr11Bi.setName("taxmSr11Bi");
		taxmSr11Bi.setFieldLabel("R11-직무발명보상금");
		taxmSr11Bi.setStyleAttribute("marginTop", "5px;");
		lcSchLeft11_16.add(taxmSr11Bi, new FormData("100%"));		
		

//		taxmSy04Bi = new NumberField();
//		taxmSy04Bi.setAllowDecimals(true);
//		taxmSy04Bi.setPropertyEditorType(Long.class);
//		taxmSy04Bi.setFormat(NumberFormat.getDecimalFormat());
//		taxmSy04Bi.setName("taxmSy04Bi");
//		taxmSy04Bi.setFieldLabel("Y04-사주조합인출100%");
//		taxmSy04Bi.setStyleAttribute("marginTop", "5px;");
//		
//		lcSchLeft11_16.add(taxmSy04Bi, new FormData("100%"));
			
			
			
		LayoutContainer lcSchCenter3_16 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter3_16.setLayout(frmlytSch);
		
//		taxmSr11Bi = new NumberField();
//		taxmSr11Bi.setAllowDecimals(true);
//		taxmSr11Bi.setPropertyEditorType(Long.class);
//		taxmSr11Bi.setFormat(NumberFormat.getDecimalFormat());
//		taxmSr11Bi.setName("taxmSr11Bi");
//		taxmSr11Bi.setFieldLabel("R11-직무발명보상금");
//		taxmSr11Bi.setStyleAttribute("marginTop", "5px;");
//		lcSchCenter3_16.add(taxmSr11Bi, new FormData("100%"));
			
			
			
		LayoutContainer lcSchRight4_16 = new LayoutContainer();
			
		LayoutContainer layoutContainer1_48 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_48.setLayout(frmlytSch);

		lcSchRight4_16.add(layoutContainer1_48, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		lcSchCol5_16.add(lcSchLeft11_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol5_16.add(lcSchCenter3_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol5_16.add(lcSchRight4_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
		fieldSet.add(lcSchCol1_2);
		fieldSet.add(lcSchCol1_3);
		fieldSet.add(lcSchCol1_4);
		fieldSet.add(lcSchCol1_5);
		fieldSet.add(lcSchCol1_6);
		fieldSet.add(lcSchCol1_7);
		fieldSet.add(lcSchCol1_8);
		fieldSet.add(lcSchCol1_9);
		fieldSet.add(lcSchCol1_10);
		 fieldSet.add(lcSchCol1_11);
		 fieldSet.add(lcSchCol1_12);
		 fieldSet.add(lcSchCol1_13);
		 fieldSet.add(lcSchCol1_14);
		 fieldSet.add(lcSchCol1_15);
		 fieldSet.add(lcSchCol1_16);
		fieldSet.add(lcSchCol5_16);
		cpYeta23008.add(fieldSet);
			
			
		
			
			
		FieldSet fieldSet2 = new FieldSet();
		fieldSet2.setHeadingHtml("감면");
		// fieldSet2.setHeight(50);
		fieldSet2.setStyleAttribute("marginTop", "5px;");

		// 감면 첫번째 줄
		LayoutContainer lcSchCol2_1 = new LayoutContainer();
		lcSchCol2_1.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft2_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft2_1.setLayout(frmlytSch);

		taxmSt01Bi = new NumberField();
		taxmSt01Bi.setAllowDecimals(true);
		taxmSt01Bi.setPropertyEditorType(Long.class);
		taxmSt01Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSt01Bi.setName("taxmSt01Bi");
		taxmSt01Bi.setFieldLabel("T01-외국인기술자");
		
		lcSchLeft2_1.add(taxmSt01Bi, new FormData("100%"));
			
			
		LayoutContainer lcSchCenter2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter2_1.setLayout(frmlytSch);

//		taxmSt10Bi = new NumberField();
//		taxmSt10Bi.setAllowDecimals(true);
//		taxmSt10Bi.setPropertyEditorType(Long.class);
//		taxmSt10Bi.setFormat(NumberFormat.getDecimalFormat());
//		taxmSt10Bi.setName("taxmSt10Bi");
//		taxmSt10Bi.setFieldLabel("T10-중소 청년 소득세 감면100%");
//		lcSchCenter2_1.add(taxmSt10Bi, new FormData("100%"));
			
			
		LayoutContainer lcSchRight2_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight2_1.setLayout(frmlytSch);

		taxmSt20Bi = new NumberField();
		taxmSt20Bi.setAllowDecimals(true);
		taxmSt20Bi.setPropertyEditorType(Long.class);
		taxmSt20Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSt20Bi.setName("taxmSt20Bi");
		taxmSt20Bi.setFieldLabel("T20-조세조약 교직자 감면");
		taxmSt20Bi.setStyleAttribute("fontSize", "10pt");
		lcSchRight2_1.add(taxmSt20Bi, new FormData("100%"));
			
		
		lcSchCol2_1.add(lcSchLeft2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol2_1.add(lcSchCenter2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol2_1.add(lcSchRight2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
		fieldSet2.add(lcSchCol2_1);

		// 감면 두번째 줄
		LayoutContainer lcSchCol21_1 = new LayoutContainer();
		lcSchCol21_1.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft21_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft21_1.setLayout(frmlytSch);
		
		taxmSt10Bi = new NumberField();
		taxmSt10Bi.setAllowDecimals(true);
		taxmSt10Bi.setPropertyEditorType(Long.class);
		taxmSt10Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSt10Bi.setName("taxmSt10Bi");
		taxmSt10Bi.setFieldLabel("T10-중소 청년 소득세100%");
		lcSchLeft21_1.add(taxmSt10Bi, new FormData("100%"));


			
		LayoutContainer lcSchCenter22_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter22_1.setLayout(frmlytSch);

		taxmSt12Bi = new NumberField();
		taxmSt12Bi.setAllowDecimals(true);
		taxmSt12Bi.setPropertyEditorType(Long.class);
		taxmSt12Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSt12Bi.setName("taxmSt12Bi");
		taxmSt12Bi.setFieldLabel("T12-중소청년소득세70%");
		lcSchCenter22_1.add(taxmSt12Bi, new FormData("100%"));

			 
		LayoutContainer lcSchRight23_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight23_1.setLayout(frmlytSch);
		
		taxmSt11Bi = new NumberField();
		taxmSt11Bi.setAllowDecimals(true);
		taxmSt11Bi.setPropertyEditorType(Long.class);
		taxmSt11Bi.setFormat(NumberFormat.getDecimalFormat());
		taxmSt11Bi.setName("taxmSt11Bi");
		taxmSt11Bi.setFieldLabel("T11-중소청년소득세50%");
		lcSchRight23_1.add(taxmSt11Bi, new FormData("100%"));
			
			
			
		lcSchCol21_1.add(lcSchLeft21_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol21_1.add(lcSchCenter22_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol21_1.add(lcSchRight23_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
		fieldSet2.add(lcSchCol21_1);

		cpYeta23008.add(fieldSet2);

		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft2.setLayout(frmlytSch);

		taxeTotl = new NumberField();
		taxeTotl.setAllowDecimals(true);
		taxeTotl.setPropertyEditorType(Long.class);
		taxeTotl.setFormat(NumberFormat.getDecimalFormat());
		taxeTotl.setName("taxeTotl");
		taxeTotl.setFieldLabel("비과세 합계");
		taxeTotl.setStyleAttribute("marginTop", "10px;");
		lcSchLeft2.add(taxeTotl, new FormData("100%"));
			
			
		LayoutContainer lcSchCenter2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(200);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter2.setLayout(frmlytSch);

		taxmTotl = new NumberField();
		taxmTotl.setAllowDecimals(true);
		taxmTotl.setPropertyEditorType(Long.class);
		taxmTotl.setFormat(NumberFormat.getDecimalFormat());
		taxmTotl.setName("taxmTotl");
		taxmTotl.setFieldLabel("감면 합계");
		taxmTotl.setStyleAttribute("marginTop", "10px;");
		
		lcSchCenter2.add(taxmTotl, new FormData("100%"));
			
		lcSchCol2.add(lcSchLeft2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcSchCol2.add(lcSchCenter2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
			
		lcSchCol2.setStyleAttribute("marginTop", "5px;");
		cpYeta23008.add(lcSchCol2);
	}

	// 버튼 저장액션
	private void doAction(ActionDatabase actionDatabase) {

		yetaP23008FormSave();
		// actionDatabase = ActionDatabase.UPDATE;

	}
		
	
	private void yetaP23008FormSave() {  
	              
		ye160403Dto = new Ye160403DTO();
	                
		ye160403Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye160403Dto.setYrtxBlggYr(yrtxBlggYr.getValue()); 	/** column 귀속연도 : yrtxBlggYr */
		ye160403Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye160403Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		ye160403Dto.setElctYymm(elctYymm.getValue());   	/** column 지급년월 : elctYymm */


		ye160403Dto.setTaxmSa01Bi((Long) taxmSa01Bi.getValue());    /** column 비과세소득_A01_비과세 : taxmSa01Bi */
		ye160403Dto.setTaxmSb01Bi((Long)taxmSb01Bi.getValue());    /** column 비과세소득_B01_비과세 : taxmSb01Bi */
		ye160403Dto.setTaxmSc01Bi((Long)taxmSc01Bi.getValue());    /** column 비과세소득_C01_비과세 : taxmSc01Bi */
		ye160403Dto.setTaxmSd01Bi((Long)taxmSd01Bi.getValue());    /** column 비과세소득_D01_비과세 : taxmSd01Bi */
		ye160403Dto.setTaxmSe01Bi((Long)taxmSe01Bi.getValue());    /** column 비과세소득_E01_비과세 : taxmSe01Bi */
		ye160403Dto.setTaxmSe02Bi((Long)taxmSe02Bi.getValue());    /** column 비과세소득_E02_비과세 : taxmSe02Bi */
		ye160403Dto.setTaxmSe10Bi((Long)taxmSe10Bi.getValue());    /** column 비과세소득_E10_비과세 : taxmSe10Bi */
		ye160403Dto.setTaxmSf01Bi((Long)taxmSf01Bi.getValue());    /** column 비과세소득_F01_비과세 : taxmSf01Bi */
		ye160403Dto.setTaxmSg01Bi((Long)taxmSg01Bi.getValue());    /** column 비과세소득_G01_비과세 : taxmSg01Bi */
		ye160403Dto.setTaxmSh01Bi((Long)taxmSh01Bi.getValue());    /** column 비과세소득_H01_비과세 : taxmSh01Bi */
		ye160403Dto.setTaxmSh02Bi((Long)taxmSh02Bi.getValue());    /** column 비과세소득_H02_비과세 : taxmSh02Bi */
		ye160403Dto.setTaxmSh03Bi((Long)taxmSh03Bi.getValue());    /** column 비과세소득_H03_비과세 : taxmSh03Bi */
		ye160403Dto.setTaxmSh04Bi((Long)taxmSh04Bi.getValue());    /** column 비과세소득_H04_비과세 : taxmSh04Bi */
		ye160403Dto.setTaxmSh05Bi((Long)taxmSh05Bi.getValue());    /** column 비과세소득_H05_비과세 : taxmSh05Bi */
		ye160403Dto.setTaxmSh06Bi((Long)taxmSh06Bi.getValue());    /** column 비과세소득_H06_비과세 : taxmSh06Bi */
		ye160403Dto.setTaxmSh07Bi((Long)taxmSh07Bi.getValue());    /** column 비과세소득_H07_비과세 : taxmSh07Bi */
		ye160403Dto.setTaxmSh08Bi((Long)taxmSh08Bi.getValue());    /** column 비과세소득_H08_비과세 : taxmSh08Bi */
		ye160403Dto.setTaxmSh09Bi((Long)taxmSh09Bi.getValue());    /** column 비과세소득_H09_비과세 : taxmSh09Bi */
		ye160403Dto.setTaxmSh10Bi((Long)taxmSh10Bi.getValue());    /** column 비과세소득_H10_비과세 : taxmSh10Bi */
		ye160403Dto.setTaxmSh14Bi((Long)taxmSh14Bi.getValue());    /** column 비과세소득_H14_비과세 : taxmSh14Bi */
		ye160403Dto.setTaxmSh15Bi((Long)taxmSh15Bi.getValue());    /** column 비과세소득_H15_비과세 : taxmSh15Bi */
		ye160403Dto.setTaxmSh11Bi((Long)taxmSh11Bi.getValue());    /** column 비과세소득_H11_비과세 : taxmSh11Bi */
		ye160403Dto.setTaxmSh12Bi((Long)taxmSh12Bi.getValue());    /** column 비과세소득_H12_비과세 : taxmSh12Bi */
		ye160403Dto.setTaxmSh13Bi((Long)taxmSh13Bi.getValue());    /** column 비과세소득_H13_비과세 : taxmSh13Bi */
		ye160403Dto.setTaxmSh16Bi((Long)taxmSh16Bi.getValue());    /** column 비과세소득_H16_비과세 : taxmSh16Bi */
		ye160403Dto.setTaxmSi01Bi((Long)taxmSi01Bi.getValue());    /** column 비과세소득_I01_비과세 : taxmSi01Bi */
		ye160403Dto.setTaxmSj01Bi((Long)taxmSj01Bi.getValue());    /** column 비과세소득_J01_비과세 : taxmSj01Bi */
		ye160403Dto.setTaxmSj10Bi((Long)taxmSj10Bi.getValue());    /** column 비과세소득_J10_비과세 : taxmSj10Bi */
		ye160403Dto.setTaxmSk01Bi((Long)taxmSk01Bi.getValue());    /** column 비과세소득_K01_비과세 : taxmSk01Bi */
		ye160403Dto.setTaxmSl01Bi((Long)taxmSl01Bi.getValue());    /** column 비과세소득_L01_비과세 : taxmSl01Bi */
		ye160403Dto.setTaxmSm01Bi((Long)taxmSm01Bi.getValue());    /** column 비과세소득_M01_비과세 : taxmSm01Bi */
		ye160403Dto.setTaxmSm02Bi((Long)taxmSm02Bi.getValue());    /** column 비과세소득_M02_비과세 : taxmSm02Bi */
		ye160403Dto.setTaxmSm03Bi((Long)taxmSm03Bi.getValue());    /** column 비과세소득_M03_비과세 : taxmSm03Bi */
		ye160403Dto.setTaxmSn01Bi((Long)taxmSn01Bi.getValue());    /** column 비과세소득_N01_비과세 : taxmSn01Bi */
		ye160403Dto.setTaxmSo01Bi((Long)taxmSo01Bi.getValue());    /** column 비과세소득_O01_비과세 : taxmSo01Bi */
		ye160403Dto.setTaxmSq01Bi((Long)taxmSp01Bi.getValue());    /** column 비과세소득_P01_비과세 : taxmSq01Bi */
		ye160403Dto.setTaxmSp02Bi((Long)taxmSp02Bi.getValue());    /** column 비과세소득_P02_비과세 : taxmSp02Bi */
		ye160403Dto.setTaxmSq01Bi((Long)taxmSq01Bi.getValue());    /** column 비과세소득_Q01_비과세 : taxmSq01Bi */
		ye160403Dto.setTaxmSr01Bi((Long)taxmSr01Bi.getValue());    /** column 비과세소득_R01_비과세 : taxmSr10Bi */
		ye160403Dto.setTaxmSr10Bi((Long)taxmSr10Bi.getValue());    /** column 비과세소득_R10_비과세 : taxmSr10Bi */
		ye160403Dto.setTaxmSs01Bi((Long)taxmSs01Bi.getValue());    /** column 비과세소득_S01_비과세 : taxmSs01Bi */
		ye160403Dto.setTaxmSy02Bi((Long)taxmSy02Bi.getValue());    /** column 비과세소득_Y02_비과세 : taxmSy02Bi */
		ye160403Dto.setTaxmSy03Bi((Long)taxmSy03Bi.getValue());    /** column 비과세소득_Y03_비과세 : taxmSy03Bi */
		ye160403Dto.setTaxmSy04Bi((Long)taxmSy04Bi.getValue());    /** column 비과세소득_Y04_비과세 : taxmSy04Bi */
//		ye160403Dto.setTaxmSy21Bi((Long)taxmSy21Bi.getValue());    /** column 비과세소득_Y21_비과세 : taxmSy21Bi */
		ye160403Dto.setTaxmSy22Bi((Long)taxmSy22Bi.getValue());    /** column 비과세소득_Y22_비과세 : taxmSy22Bi */
		ye160403Dto.setTaxmSt01Bi((Long)taxmSt01Bi.getValue());    /** column 감면소득_T01_비과세 : taxmSt01Bi */
		ye160403Dto.setTaxmSt10Bi((Long)taxmSt10Bi.getValue());    /** column 감면소득_T10_비과세 : taxmSt10Bi */
		ye160403Dto.setTaxmSt11Bi((Long)taxmSt11Bi.getValue());    /** column 감면소득_T11_비과세 : taxmSt11Bi */
		ye160403Dto.setTaxmSt12Bi((Long)taxmSt12Bi.getValue());    /** column 감면소득_T12_비과세 : taxmSt12Bi */
		ye160403Dto.setTaxmSt20Bi((Long)taxmSt20Bi.getValue());    /** column 감면소득_T20_비과세 : taxmSt20Bi */
		ye160403Dto.setTaxmSr11Bi((Long)taxmSr11Bi.getValue());    /** column 비과세소득_R11_비과세 : taxmSr11Bi */

	                
		yetaP23008Service.activityOnYetaP23008ToYe160403(ye160403Dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP23008ToYe160403(" + actionDatabase.name() + ") : " + caught), null);
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
	}
		
		
	@Override
	public void reload() {
		
		ye160403Dto = new Ye160403DTO();
		
		ye160403Dto.setDpobCd(dpobCd.getValue());			/**  column 사업장코드 : dpobCd */
		ye160403Dto.setSystemkey(systemkey.getValue()); 	/**  column SYSTEMKEY : systemkey */
		ye160403Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 정산구분코드 : clutSeptCd */
		ye160403Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 연말정산귀속년도 : yrtxBlggYr */
		ye160403Dto.setBsnoEncCntn(bsnoEncCntn.getValue());	/** column 사업자등록번호 : bsnoEncCntn */
		ye160403Dto.setElctYymm("201711");
		
		yetaP23008Service.getYetaP23008ToYe160403List(ye160403Dto, new AsyncCallback<Ye160403DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYetaP23008ToYe160403List(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye160403DTO result) {
				// TODO Auto-generated method stub
				readYetaP23008Data(result);
			}
		});
	}	
	
	
	/** 비과세 및 감면소득 조회부 **/
	public void readYetaP23008Data(Ye160403DTO result) {
		
//		hanNm.setValue(MSFSharedUtils.allowNulls(result.getHanNm())); // 성명
//		srhBsnoEncCntn.setValue(MSFSharedUtils.defaultNulls(result.getBsnoEncCntn(), "0000000000")); // 사업자등록번호
//
//		if("0000000000".equals(srhBsnoEncCntn.getValue())) {
//			actionDatabase = ActionDatabase.INSERT;
//		}else {
//			actionDatabase = ActionDatabase.UPDATE;
//		}
//		
//		srhSiteCtnt.setValue(MSFSharedUtils.allowNulls(result.getSiteCtnt())); // 근무지명
//
//		dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
//		yrtxBlggYr.setValue(result.getYrtxBlggYr());    /** column 귀속연도 : yrtxBlggYr */
//		clutSeptCd.setValue(result.getClutSeptCd());    /** column 연말정산구분코드 : clutSeptCd */
//		systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		elctYymm.setValue(result.getElctYymm());    /** column 지급년월 : elctYymm */
		
		taxmSa01Bi.setValue(result.getTaxmSa01Bi());    /** column 비과세소득_A01_비과세 : taxmSa01Bi */
		taxmSb01Bi.setValue(result.getTaxmSb01Bi());    /** column 비과세소득_B01_비과세 : taxmSb01Bi */
		taxmSc01Bi.setValue(result.getTaxmSc01Bi());    /** column 비과세소득_C01_비과세 : taxmSc01Bi */
		taxmSd01Bi.setValue(result.getTaxmSd01Bi());    /** column 비과세소득_D01_비과세 : taxmSd01Bi */
		taxmSe01Bi.setValue(result.getTaxmSe01Bi());    /** column 비과세소득_E01_비과세 : taxmSe01Bi */
		taxmSe02Bi.setValue(result.getTaxmSe02Bi());    /** column 비과세소득_E02_비과세 : taxmSe02Bi */
		taxmSe10Bi.setValue(result.getTaxmSe10Bi());    /** column 비과세소득_E10_비과세 : taxmSe10Bi */
		taxmSf01Bi.setValue(result.getTaxmSf01Bi());    /** column 비과세소득_F01_비과세 : taxmSf01Bi */
		taxmSg01Bi.setValue(result.getTaxmSg01Bi());    /** column 비과세소득_G01_비과세 : taxmSg01Bi */
		taxmSh01Bi.setValue(result.getTaxmSh01Bi());    /** column 비과세소득_H01_비과세 : taxmSh01Bi */
		taxmSh02Bi.setValue(result.getTaxmSh02Bi());    /** column 비과세소득_H02_비과세 : taxmSh02Bi */
		taxmSh03Bi.setValue(result.getTaxmSh03Bi());    /** column 비과세소득_H03_비과세 : taxmSh03Bi */
		taxmSh04Bi.setValue(result.getTaxmSh04Bi());    /** column 비과세소득_H04_비과세 : taxmSh04Bi */
		taxmSh05Bi.setValue(result.getTaxmSh05Bi());    /** column 비과세소득_H05_비과세 : taxmSh05Bi */
		taxmSh06Bi.setValue(result.getTaxmSh06Bi());    /** column 비과세소득_H06_비과세 : taxmSh06Bi */
		taxmSh07Bi.setValue(result.getTaxmSh07Bi());    /** column 비과세소득_H07_비과세 : taxmSh07Bi */
		taxmSh08Bi.setValue(result.getTaxmSh08Bi());    /** column 비과세소득_H08_비과세 : taxmSh08Bi */
		taxmSh09Bi.setValue(result.getTaxmSh09Bi());    /** column 비과세소득_H09_비과세 : taxmSh09Bi */
		taxmSh10Bi.setValue(result.getTaxmSh10Bi());    /** column 비과세소득_H10_비과세 : taxmSh10Bi */
		taxmSh14Bi.setValue(result.getTaxmSh14Bi());    /** column 비과세소득_H14_비과세 : taxmSh14Bi */
		taxmSh15Bi.setValue(result.getTaxmSh15Bi());    /** column 비과세소득_H15_비과세 : taxmSh15Bi */
		taxmSh11Bi.setValue(result.getTaxmSh11Bi());    /** column 비과세소득_H11_비과세 : taxmSh11Bi */
		taxmSh12Bi.setValue(result.getTaxmSh12Bi());    /** column 비과세소득_H12_비과세 : taxmSh12Bi */
		taxmSh13Bi.setValue(result.getTaxmSh13Bi());    /** column 비과세소득_H13_비과세 : taxmSh13Bi */
		taxmSh16Bi.setValue(result.getTaxmSh16Bi());    /** column 비과세소득_H16_비과세 : taxmSh16Bi */
		taxmSi01Bi.setValue(result.getTaxmSi01Bi());    /** column 비과세소득_I01_비과세 : taxmSi01Bi */
		taxmSj01Bi.setValue(result.getTaxmSj01Bi());    /** column 비과세소득_J01_비과세 : taxmSj01Bi */
		taxmSj10Bi.setValue(result.getTaxmSj10Bi());    /** column 비과세소득_J10_비과세 : taxmSj10Bi */
		taxmSk01Bi.setValue(result.getTaxmSk01Bi());    /** column 비과세소득_K01_비과세 : taxmSk01Bi */
		taxmSl01Bi.setValue(result.getTaxmSl01Bi());    /** column 비과세소득_L01_비과세 : taxmSl01Bi */
		taxmSm01Bi.setValue(result.getTaxmSm01Bi());    /** column 비과세소득_M01_비과세 : taxmSm01Bi */
		taxmSm02Bi.setValue(result.getTaxmSm02Bi());    /** column 비과세소득_M02_비과세 : taxmSm02Bi */
		taxmSm03Bi.setValue(result.getTaxmSm03Bi());    /** column 비과세소득_M03_비과세 : taxmSm03Bi */
		taxmSn01Bi.setValue(result.getTaxmSn01Bi());    /** column 비과세소득_N01_비과세 : taxmSn01Bi */
		taxmSo01Bi.setValue(result.getTaxmSo01Bi());    /** column 비과세소득_O01_비과세 : taxmSo01Bi */
		taxmSp01Bi.setValue(result.getTaxmSp01Bi());    /** column 비과세소득_P01_비과세 : taxmSq01Bi */
		taxmSp02Bi.setValue(result.getTaxmSp02Bi());    /** column 비과세소득_P02_비과세 : taxmSp02Bi */
		taxmSq01Bi.setValue(result.getTaxmSq01Bi());    /** column 비과세소득_Q01_비과세 : taxmSq01Bi */
		taxmSr01Bi.setValue(result.getTaxmSr01Bi());    /** column 비과세소득_R01_비과세 : taxmSr01Bi */
		taxmSr10Bi.setValue(result.getTaxmSr10Bi());    /** column 비과세소득_R10_비과세 : taxmSr10Bi */
		taxmSs01Bi.setValue(result.getTaxmSs01Bi());    /** column 비과세소득_S01_비과세 : taxmSs01Bi */
		taxmSy02Bi.setValue(result.getTaxmSy02Bi());    /** column 비과세소득_Y02_비과세 : taxmSy02Bi */
		taxmSy03Bi.setValue(result.getTaxmSy03Bi());    /** column 비과세소득_Y03_비과세 : taxmSy03Bi */
		taxmSy04Bi.setValue(result.getTaxmSy04Bi());    /** column 비과세소득_Y04_비과세 : taxmSy04Bi */
//		taxmSy21Bi.setValue(result.getTaxmSy21Bi());    /** column 비과세소득_Y21_비과세 : taxmSy21Bi */
		taxmSy22Bi.setValue(result.getTaxmSy22Bi());    /** column 비과세소득_Y22_비과세 : taxmSy22Bi */
		taxmSt01Bi.setValue(result.getTaxmSt01Bi());    /** column 감면소득_T01_비과세 : taxmSt01Bi */
		taxmSt10Bi.setValue(result.getTaxmSt10Bi());    /** column 감면소득_T10_비과세 : taxmSt10Bi */
		taxmSt11Bi.setValue(result.getTaxmSt11Bi());    /** column 감면소득_T11_비과세 : taxmSt11Bi */
		taxmSt12Bi.setValue(result.getTaxmSt12Bi());    /** column 감면소득_T12_비과세 : taxmSt12Bi */
		taxmSt20Bi.setValue(result.getTaxmSt20Bi());    /** column 감면소득_T20_비과세 : taxmSt20Bi */
		taxmSr11Bi.setValue(result.getTaxmSr11Bi());    /** column 비과세소득_R11_비과세 : taxmSr11Bi */
		
		/** 총계 부분 */
		taxeTotl.setValue(result.getTaxeTotl()); // ⑳ 비과세 계
		taxmTotl.setValue(result.getTaxmTotl()); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단
	}
	
	
		
	public void setReadOnlyTrueYetaP13008() {
		
		hanNm.setReadOnly(true); 	// 성명
		srhBsnoEncCntn.setReadOnly(true); 	// 사업자등록번호
		srhSiteCtnt.setReadOnly(true);	// 근무지명
			
		taxmSg01Bi.setReadOnly(true); // ⑱-5 G01-비과세 학자금
		taxmSh01Bi.setReadOnly(true); // ⑱-9 H01-무보수위원수당
		taxmSh05Bi.setReadOnly(true); // ⑱-18 H05-경호·승선수당
		taxmSh06Bi.setReadOnly(true); // ⑱-4 H06-유아·초중등
		taxmSh07Bi.setReadOnly(true); // ⑱-4 H07-고등교육법
		taxmSh08Bi.setReadOnly(true); // ⑱-4 H08-특별법
		taxmSh09Bi.setReadOnly(true); // ⑱-4 H09-연구기관
		taxmSh10Bi.setReadOnly(true); // ⑱-4 H10-기업부설연구소
		taxmSh14Bi.setReadOnly(true); // ⑱-22 H14-보육교사
		taxmSh15Bi.setReadOnly(true); // ⑱-23 H15-사립유치원수석교사
		taxmSh11Bi.setReadOnly(true); // ⑱-6 H11-취재수당
		taxmSh12Bi.setReadOnly(true); // ⑱-7 H12-벽지수당
		taxmSh13Bi.setReadOnly(true); // ⑱-8 H13-재해관련급여
		taxmSh16Bi.setReadOnly(true); // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
		taxmSi01Bi.setReadOnly(true); // ⑱-19 l01-외국정부 근무자
		taxmSk01Bi.setReadOnly(true); // ⑱-10 K01-외국주둔군인
		taxmSm01Bi.setReadOnly(true); // ⑱ M01-국외근로 100만원
		taxmSm02Bi.setReadOnly(true); // ⑱ M02-국외근로 300만원
		taxmSm03Bi.setReadOnly(true); // ⑱ M03-국외근로
		taxmSo01Bi.setReadOnly(true); // ⑱-1 O01-야간근로수당
		taxmSq01Bi.setReadOnly(true); // ⑱-2 Q01-출산보육수당
		taxmSr10Bi.setReadOnly(true); // ⑱-21 R10-근로장학금
		taxmSs01Bi.setReadOnly(true); // ⑱-11 S01-주식매수선택권
		taxmSy02Bi.setReadOnly(true); // ⑱-14 Y02-우리사주조합인출금50%
		taxmSy03Bi.setReadOnly(true); // ⑱-15 Y03-우리사주조합인출금70%
//		taxmSy21Bi.setReadOnly(true); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmSy22Bi.setReadOnly(true); // ⑲ Y22-전공의 수련 보조수당

		taxmSa01Bi.setReadOnly(true); // A01-복무병 급여
		taxmSb01Bi.setReadOnly(true); // B01-동원직장 급여
		taxmSc01Bi.setReadOnly(true); // C01-요양 급여
		taxmSd01Bi.setReadOnly(true); // D01-요양 보상금
		taxmSe01Bi.setReadOnly(true); // E01-육아휴직급여
		taxmSe02Bi.setReadOnly(true); // E02-육아휴직수당
		taxmSe10Bi.setReadOnly(true); // E10-사망일시금
		taxmSf01Bi.setReadOnly(true); // F01-요양비

		taxmSh02Bi.setReadOnly(true); // H02-일직·숙직료
		taxmSh03Bi.setReadOnly(true); // H03-자가운전보조금
		taxmSh04Bi.setReadOnly(true); // H04-착용제복금
		taxmSj01Bi.setReadOnly(true); // J01-보훈·학습보조비
		taxmSj10Bi.setReadOnly(true); // J10-전직대통령 연금
		taxmSl01Bi.setReadOnly(true); // L01-중군군인전사 과세급여
		taxmSn01Bi.setReadOnly(true); // N01-국민건강보험 보험료
		taxmSp01Bi.setReadOnly(true); // P01-비과세 식대
		taxmSp02Bi.setReadOnly(true); // P02-현물 급식
		taxmSr01Bi.setReadOnly(true); // R01-국군포로 보수
		
		/** 감면소득 부분 */
		taxmSt01Bi.setReadOnly(true); // ⑱-12 T01-외국인기술자
		taxmSt10Bi.setReadOnly(true); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmSt20Bi.setReadOnly(true); // ⑱-25 T20-조세조약상 교직자 감면

		/** 총계 부분 */
		taxeTotl.setReadOnly(false); // ⑳ 비과세 계
		taxmTotl.setReadOnly(false); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
		
	}
	
	
	
	public void setReadOnlyFalseYetaP13008() {
		
		hanNm.setReadOnly(false); 			// 성명
		srhBsnoEncCntn.setReadOnly(false); 	// 사업자등록번호
		srhSiteCtnt.setReadOnly(false);		// 근무지명
		
		taxmSg01Bi.setReadOnly(false); // ⑱-5 G01-비과세 학자금
		taxmSh01Bi.setReadOnly(false); // ⑱-9 H01-무보수위원수당
		taxmSh05Bi.setReadOnly(false); // ⑱-18 H05-경호·승선수당
		taxmSh06Bi.setReadOnly(false); // ⑱-4 H06-유아·초중등
		taxmSh07Bi.setReadOnly(false); // ⑱-4 H07-고등교육법
		taxmSh08Bi.setReadOnly(false); // ⑱-4 H08-특별법
		taxmSh09Bi.setReadOnly(false); // ⑱-4 H09-연구기관
		taxmSh10Bi.setReadOnly(false); // ⑱-4 H10-기업부설연구소
		taxmSh14Bi.setReadOnly(false); // ⑱-22 H14-보육교사
		taxmSh15Bi.setReadOnly(false); // ⑱-23 H15-사립유치원수석교사
		taxmSh11Bi.setReadOnly(false); // ⑱-6 H11-취재수당
		taxmSh12Bi.setReadOnly(false); // ⑱-7 H12-벽지수당
		taxmSh13Bi.setReadOnly(false); // ⑱-8 H13-재해관련급여
		taxmSh16Bi.setReadOnly(false); // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
		taxmSi01Bi.setReadOnly(false); // ⑱-19 l01-외국정부 근무자
		taxmSk01Bi.setReadOnly(false); // ⑱-10 K01-외국주둔군인
		taxmSm01Bi.setReadOnly(false); // ⑱ M01-국외근로 100만원
		taxmSm02Bi.setReadOnly(false); // ⑱ M02-국외근로 300만원
		taxmSm03Bi.setReadOnly(false); // ⑱ M03-국외근로
		taxmSo01Bi.setReadOnly(false); // ⑱-1 O01-야간근로수당
		taxmSq01Bi.setReadOnly(false); // ⑱-2 Q01-출산보육수당
		taxmSr10Bi.setReadOnly(false); // ⑱-21 R10-근로장학금
		taxmSs01Bi.setReadOnly(false); // ⑱-11 S01-주식매수선택권
		taxmSy02Bi.setReadOnly(false); // ⑱-14 Y02-우리사주조합인출금50%
		taxmSy03Bi.setReadOnly(false); // ⑱-15 Y03-우리사주조합인출금70%
//		taxmSy21Bi.setReadOnly(false); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmSy22Bi.setReadOnly(false); // ⑲ Y22-전공의 수련 보조수당

		taxmSa01Bi.setReadOnly(false); // A01-복무병 급여
		taxmSb01Bi.setReadOnly(false); // B01-동원직장 급여
		taxmSc01Bi.setReadOnly(false); // C01-요양 급여
		taxmSd01Bi.setReadOnly(false); // D01-요양 보상금
		taxmSe01Bi.setReadOnly(false); // E01-육아휴직급여
		taxmSe02Bi.setReadOnly(false); // E02-육아휴직수당
		taxmSe10Bi.setReadOnly(false); // E10-사망일시금
		taxmSf01Bi.setReadOnly(false); // F01-요양비

		taxmSh02Bi.setReadOnly(false); // H02-일직·숙직료
		taxmSh03Bi.setReadOnly(false); // H03-자가운전보조금
		taxmSh04Bi.setReadOnly(false); // H04-착용제복금
		taxmSj01Bi.setReadOnly(false); // J01-보훈·학습보조비
		taxmSj10Bi.setReadOnly(false); // J10-전직대통령 연금
		taxmSl01Bi.setReadOnly(false); // L01-중군군인전사 과세급여
		taxmSn01Bi.setReadOnly(false); // N01-국민건강보험 보험료
		taxmSp01Bi.setReadOnly(false); // P01-비과세 식대
		taxmSp02Bi.setReadOnly(false); // P02-현물 급식
		taxmSr01Bi.setReadOnly(false); // R01-국군포로 보수
		
		/** 감면소득 부분 */
		taxmSt01Bi.setReadOnly(false); // ⑱-12 T01-외국인기술자
		taxmSt10Bi.setReadOnly(false); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmSt20Bi.setReadOnly(false); // ⑱-25 T20-조세조약상 교직자 감면

		/** 총계 부분 */
		taxeTotl.setReadOnly(false); // ⑳ 비과세 계
		taxmTotl.setReadOnly(false); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
	}
		
		

}