/**
 * 비과세 및 감면소득 입력
 */
package com.app.exterms.yearendtax.client.form.yeta2019;
  
 
import java.util.Iterator;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye160405DTO;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP430010Service;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP430010ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
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
public  class YetaP430010   extends MSFFormPanel { 

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
 
	private ContentPanel cpYeta230010;
	  
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
    
	private MSFFormPanel caller;
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
	private HiddenField<String> whdgDebrBusoprRgstnum;		/**  column 사업자등록번호 : whdgDebrBusoprRgstnum */
	private HiddenField<String>	dpobCd;				/**  column 사업장코드 : dpobCd */
	private HiddenField<String>	hanNm;	
 	// -------------- 검색 조건 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private YetaP430010ServiceAsync yetaP430010Service = YetaP430010Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
	// -------------- DTO 호출 시작 --------------
	private Ye160405DTO ye160405Dto;
	// -------------- DTO 호출 종료 --------------
	
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

	private TextField<String> srhHanNm;			// 성명
	private TextField<String> srhWhdgDebrBusoprRgstnum; 	// 사업자등록번호
	private TextField<String> srhSiteCtnt; 		// 근무지명
    
    /**비과세부분 */
    private  NumberField taxmSg01Jong;    // ⑱-5 G01-비과세 학자금
    private  NumberField taxmSh01Jong;    // ⑱-9 H01-무보수위원수당
    private  NumberField taxmSh05Jong;    // ⑱-18 H05-경호·승선수당
    private  NumberField taxmSh06Jong;    // ⑱-4 H06-유아·초중등
    private  NumberField taxmSh07Jong;    // ⑱-4 H07-고등교육법
    private  NumberField taxmSh08Jong;    // ⑱-4 H08-특별법
    private  NumberField taxmSh09Jong;    // ⑱-4 H09-연구기관
    private  NumberField taxmSh10Jong;    // ⑱-4 H10-기업부설연구소
    private  NumberField taxmSh14Jong;    // ⑱-22 H14-보육교사
    private  NumberField taxmSh15Jong;    // ⑱-23 H15-사립유치원수석교사
    private  NumberField taxmSh11Jong;    // ⑱-6 H11-취재수당
    private  NumberField taxmSh12Jong;    // ⑱-7 H12-벽지수당
    private  NumberField taxmSh13Jong;    // ⑱-8 H13-재해관련급여
    private  NumberField taxmSh16Jong;    // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
    private  NumberField taxmSi01Jong;    // ⑱-19 l01-외국정부 근무자
    private  NumberField taxmSk01Jong;    // ⑱-10 K01-외국주둔군인
    private  NumberField taxmSm01Jong;    // ⑱ M01-국외근로 100만원
    private  NumberField taxmSm02Jong;    // ⑱ M02-국외근로 300만원
    private  NumberField taxmSm03Jong;    // ⑱ M03-국외근로
    private  NumberField taxmSo01Jong;    // ⑱-1 O01-야간근로수당
    private  NumberField taxmSq01Jong;    // ⑱-2 Q01-출산보육수당
    private  NumberField taxmSr10Jong;    // ⑱-21 R10-근로장학금
    private  NumberField taxmSr11Jong;    // ⑱-21 R11-직무발명보상금
    private  NumberField taxmSs01Jong;    // ⑱-11 S01-주식매수선택권
    private  NumberField taxmSy02Jong;    // ⑱-14 Y02-우리사주조합인출금50%
    private  NumberField taxmSy03Jong;    // ⑱-15 Y03-우리사주조합인출금70%
    private  NumberField taxmSy04Jong;    // ⑱-15 Y04-우리사주조합인출금100%

//    private  NumberField taxmSy21Jong; // ⑱-20 Y21-장기미취업자 중소기업 취업     TODO 2017년도삭제필요
    private  NumberField taxmSy22Jong;    // ⑲ Y22-전공의 수련 보조수당
     
    /**감면소득 부분 */
    private  NumberField taxmSt01Jong;    // ⑱-12 T01-외국인기술자
    private  NumberField taxmSt10Jong;    // ⑱-24 T10-중소기업취업 청년 소득세 감면
    private  NumberField taxmSt11Jong;    // ⑱-24 T11-중소기업취업 청년 소득세 감면
    private  NumberField taxmSt12Jong;    // ⑱-24 T12-중소기업취업 청년 소득세 감면
    private  NumberField taxmSt20Jong;    // ⑱-25 T20-조세조약상 교직자 감면
    
    
    private NumberField taxmSa01Jong; 	// A01-복무병 급여
    private NumberField taxmSb01Jong; 	// B01-동원직장 급여
    private NumberField taxmSc01Jong;		// C01-요양 급여
    private NumberField taxmSd01Jong;		// D01-요양 보상금
    private NumberField taxmSe01Jong;		// E01-육아휴직급여
    private NumberField taxmSe02Jong;		// E02-육아휴직수당
    private NumberField taxmSe10Jong;		// E10-사망일시금
    private NumberField taxmSf01Jong;		// F01-요양비
    
    private NumberField taxmSh02Jong;		// H02-일직·숙직료 
    private NumberField taxmSh03Jong;		// H03-자가운전보조금
    private NumberField taxmSh04Jong;		// H04-착용제복금
    
    private NumberField taxmSj01Jong;		// J01-보훈·학습보조비
    private NumberField taxmSj10Jong;		// J10-전직대통령 연금

    private NumberField taxmSl01Jong;		// L01-중군군인전사 과세급여
    
    private NumberField taxmSn01Jong;		// N01-국민건강보험 보험료
    
    private NumberField taxmSp01Jong;		// P01-비과세 식대
    private NumberField taxmSp02Jong;		// P02-현물 급식
    
    private NumberField taxmSr01Jong;		//R01-국군포로 보수
    
    
    /** 총계 부분*/
    private  NumberField taxeTotl;    // ⑳ 비과세 계
    private  NumberField taxmTotl;    // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
    
    
    
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  


	  
	public YetaP430010(final ActionDatabase actionDatabase, final MSFFormPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYeta230010 = new ContentPanel();

		createStandardForm();
		setReadOnlyFalseYetaP13008();

		cpYeta230010.setBodyBorder(false);
		cpYeta230010.setBorders(false);
		cpYeta230010.setHeaderVisible(false);
		cpYeta230010.setSize("790px", "720px");

		this.add(cpYeta230010);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "750px");
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
				srhWhdgDebrBusoprRgstnum.setValue(whdgDebrBusoprRgstnum.getValue());
				srhSiteCtnt.setValue(deptNm.getValue());
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
		
	private void createStandardForm() {

		systemkey = new HiddenField<String>();		/** column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta230010.add(systemkey);

		dpobCd = new HiddenField<String>();			/** column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYeta230010.add(dpobCd);

		yrtxBlggYr = new HiddenField<String>();		/** column 정산년도 : yrtxBlggYr */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYeta230010.add(yrtxBlggYr);

		clutSeptCd = new HiddenField<String>();		/** column 정산구분코드 : clutSeptCd */
		clutSeptCd.setName("clutSeptCd");
		cpYeta230010.add(clutSeptCd);

		whdgDebrBusoprRgstnum = new HiddenField<String>();	/** column 사업자등록번호 : whdgDebrBusoprRgstnum */
		whdgDebrBusoprRgstnum.setName("whdgDebrBusoprRgstnum");
		cpYeta230010.add(whdgDebrBusoprRgstnum);
		
		
		deptNm = new HiddenField<String>();
		deptNm.setName("deptNm");
		cpYeta230010.add(deptNm);
		
		hanNm = new HiddenField<String>();
		hanNm.setName("hanNm");
		cpYeta230010.add(hanNm);
		
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
		cpYeta230010.add(topYetaBtnBar);
			
			
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");
		srhHanNm.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_1.add(srhHanNm, new FormData("100%"));
		lcSchLeft.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchCenter = new LayoutContainer();
		lcSchCenter.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(110);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		srhWhdgDebrBusoprRgstnum = new TextField<String>();
		srhWhdgDebrBusoprRgstnum.setName("srhWhdgDebrBusoprRgstnum");
		srhWhdgDebrBusoprRgstnum.setFieldLabel("사업자등록번호");
		new TextFieldMask<String>(srhWhdgDebrBusoprRgstnum, "999-99-99999");
		srhWhdgDebrBusoprRgstnum.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_2.add(srhWhdgDebrBusoprRgstnum, new FormData("100%"));
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
		cpYeta230010.add(lcSchCol);

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

		taxmSg01Jong = new NumberField();
		taxmSg01Jong.setAllowDecimals(true);
		taxmSg01Jong.setPropertyEditorType(Long.class);
		taxmSg01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSg01Jong.setName("taxmSg01Jong");
		taxmSg01Jong.setFieldLabel("G01-비과세 학자금");
		taxmSg01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_4.add(taxmSg01Jong, new FormData("100%"));
		lcSchLeft1_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchCenter1_2 = new LayoutContainer();

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytSch);

		taxmSh01Jong = new NumberField();
		taxmSh01Jong.setAllowDecimals(true);
		taxmSh01Jong.setPropertyEditorType(Long.class);
		taxmSh01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh01Jong.setName("taxmSh01Jong");
		taxmSh01Jong.setFieldLabel("H01-무보수위원수당");
		taxmSh01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_5.add(taxmSh01Jong, new FormData("100%"));
		lcSchCenter1_2.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
			
		LayoutContainer lcSchRight1_2 = new LayoutContainer();

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);

		taxmSh05Jong = new NumberField();
		taxmSh05Jong.setAllowDecimals(true);
		taxmSh05Jong.setPropertyEditorType(Long.class);
		taxmSh05Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh05Jong.setName("taxmSh05Jong");
		taxmSh05Jong.setFieldLabel("H05-경호·승선수당");
		taxmSh05Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_6.add(taxmSh05Jong, new FormData("100%"));
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

		taxmSh06Jong = new NumberField();
		taxmSh06Jong.setAllowDecimals(true);
		taxmSh06Jong.setPropertyEditorType(Long.class);
		taxmSh06Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh06Jong.setName("taxmSh06Jong");
		taxmSh06Jong.setFieldLabel("H06-유아·초중등");
		taxmSh06Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_7.add(taxmSh06Jong, new FormData("100%"));
		lcSchLeft1_3.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		LayoutContainer lcSchCenter1_3 = new LayoutContainer();

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);

		taxmSh07Jong = new NumberField();
		taxmSh07Jong.setAllowDecimals(true);
		taxmSh07Jong.setPropertyEditorType(Long.class);
		taxmSh07Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh07Jong.setName("taxmSh07Jong");
		taxmSh07Jong.setFieldLabel("H07-고등교육법");
		taxmSh07Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_8.add(taxmSh07Jong, new FormData("100%"));
		lcSchCenter1_3.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		LayoutContainer lcSchRight1_3 = new LayoutContainer();

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSch);

		taxmSh08Jong = new NumberField();
		taxmSh08Jong.setAllowDecimals(true);
		taxmSh08Jong.setPropertyEditorType(Long.class);
		taxmSh08Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh08Jong.setName("taxmSh08Jong");
		taxmSh08Jong.setFieldLabel("H08-특별법");
		taxmSh08Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_9.add(taxmSh08Jong, new FormData("100%"));
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

		taxmSh09Jong = new NumberField();
		taxmSh09Jong.setAllowDecimals(true);
		taxmSh09Jong.setPropertyEditorType(Long.class);
		taxmSh09Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh09Jong.setName("taxmSh09Jong");
		taxmSh09Jong.setFieldLabel("H09-연구기관");
		taxmSh09Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_10.add(taxmSh09Jong, new FormData("100%"));
		lcSchLeft1_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_4 = new LayoutContainer();

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytSch);

		taxmSh10Jong = new NumberField();
		taxmSh10Jong.setAllowDecimals(true);
		taxmSh10Jong.setPropertyEditorType(Long.class);
		taxmSh10Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh10Jong.setName("taxmSh10Jong");
		taxmSh10Jong.setFieldLabel("H10-기업부설연구소");
		taxmSh10Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_11.add(taxmSh10Jong, new FormData("100%"));
		lcSchCenter1_4.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight1_4 = new LayoutContainer();

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytSch);

		taxmSh14Jong = new NumberField();
		taxmSh14Jong.setAllowDecimals(true);
		taxmSh14Jong.setPropertyEditorType(Long.class);
		taxmSh14Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh14Jong.setName("taxmSh14Jong");
		taxmSh14Jong.setFieldLabel("H14-보육교사");
		taxmSh14Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_12.add(taxmSh14Jong, new FormData("100%"));
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

		taxmSh15Jong = new NumberField();
		taxmSh15Jong.setAllowDecimals(true);
		taxmSh15Jong.setPropertyEditorType(Long.class);
		taxmSh15Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh15Jong.setName("taxmSh15Jong");
		taxmSh15Jong.setFieldLabel("H15-사립유치원수석교사");
		taxmSh15Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_13.add(taxmSh15Jong, new FormData("100%"));
		lcSchLeft1_5.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchCenter1_5 = new LayoutContainer();

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);

		taxmSh11Jong = new NumberField();
		taxmSh11Jong.setAllowDecimals(true);
		taxmSh11Jong.setPropertyEditorType(Long.class);
		taxmSh11Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh11Jong.setName("taxmSh11Jong");
		taxmSh11Jong.setFieldLabel("H11-취재수당");
		taxmSh11Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_14.add(taxmSh11Jong, new FormData("100%"));

		lcSchCenter1_5.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight1_5 = new LayoutContainer();

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSch);

		taxmSh12Jong = new NumberField();
		taxmSh12Jong.setAllowDecimals(true);
		taxmSh12Jong.setPropertyEditorType(Long.class);
		taxmSh12Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh12Jong.setName("taxmSh12Jong");
		taxmSh12Jong.setFieldLabel("H12-벽지수당");
		taxmSh12Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_15.add(taxmSh12Jong, new FormData("100%"));
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

		taxmSh13Jong = new NumberField();
		taxmSh13Jong.setAllowDecimals(true);
		taxmSh13Jong.setPropertyEditorType(Long.class);
		taxmSh13Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh13Jong.setName("taxmSh13Jong");
		taxmSh13Jong.setFieldLabel("H13-재해관련급여");
		taxmSh13Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_16.add(taxmSh13Jong, new FormData("100%"));
		lcSchLeft1_6.add(layoutContainer_16);
			
			
			
			
		LayoutContainer lcSchCenter1_6 = new LayoutContainer();

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_17.setLayout(frmlytSch);

		taxmSh16Jong = new NumberField();
		taxmSh16Jong.setAllowDecimals(true);
		taxmSh16Jong.setPropertyEditorType(Long.class);
		taxmSh16Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh16Jong.setName("taxmSh16Jong");
		taxmSh16Jong.setFieldLabel("H16-정부공공 이주수당");
		taxmSh16Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_17.add(taxmSh16Jong, new FormData("100%"));
		lcSchCenter1_6.add(layoutContainer_17);
			
			
			
		LayoutContainer lcSchRight1_6 = new LayoutContainer();

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytSch);

		taxmSi01Jong = new NumberField();

		taxmSi01Jong.setAllowDecimals(true);
		taxmSi01Jong.setPropertyEditorType(Long.class);
		taxmSi01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSi01Jong.setName("taxmSi01Jong");
		taxmSi01Jong.setFieldLabel("l01-외국정부 근무자");
		taxmSi01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_18.add(taxmSi01Jong, new FormData("100%"));
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

		taxmSk01Jong = new NumberField();
		taxmSk01Jong.setAllowDecimals(true);
		taxmSk01Jong.setPropertyEditorType(Long.class);
		taxmSk01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSk01Jong.setName("taxmSk01Jong");
		taxmSk01Jong.setFieldLabel("K01-외국주둔군인");
		taxmSk01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_19.add(taxmSk01Jong, new FormData("100%"));
		lcSchLeft1_7.add(layoutContainer_19);
			
			
			
			
		LayoutContainer lcSchCenter1_7 = new LayoutContainer();

		LayoutContainer layoutContainer_20 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytSch);

		taxmSm01Jong = new NumberField();
		taxmSm01Jong.setAllowDecimals(true);
		taxmSm01Jong.setPropertyEditorType(Long.class);
		taxmSm01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSm01Jong.setName("taxmSm01Jong");
		taxmSm01Jong.setFieldLabel("M01-국외근로 100만원");
		taxmSm01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_20.add(taxmSm01Jong, new FormData("100%"));
		lcSchCenter1_7.add(layoutContainer_20);
			
			
			
		LayoutContainer lcSchRight1_7 = new LayoutContainer();

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);

		taxmSm02Jong = new NumberField();
		taxmSm02Jong.setAllowDecimals(true);
		taxmSm02Jong.setPropertyEditorType(Long.class);
		taxmSm02Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSm02Jong.setName("taxmSm02Jong");
		taxmSm02Jong.setFieldLabel("M02-국외근로 300만원");
		taxmSm02Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_21.add(taxmSm02Jong, new FormData("100%"));
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

		taxmSm03Jong = new NumberField();
		taxmSm03Jong.setAllowDecimals(true);
		taxmSm03Jong.setPropertyEditorType(Long.class);
		taxmSm03Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSm03Jong.setName("taxmSm03Jong");
		taxmSm03Jong.setFieldLabel("M03-국외근로");
		taxmSm03Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_22.add(taxmSm03Jong, new FormData("100%"));
		lcSchLeft1_8.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_8 = new LayoutContainer();

		LayoutContainer layoutContainer_23 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_23.setLayout(frmlytSch);

		taxmSo01Jong = new NumberField();

		taxmSo01Jong.setAllowDecimals(true);
		taxmSo01Jong.setPropertyEditorType(Long.class);
		taxmSo01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSo01Jong.setName("taxmSo01Jong");
		taxmSo01Jong.setFieldLabel("O01-야간근로수당");
		taxmSo01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_23.add(taxmSo01Jong, new FormData("100%"));
		lcSchCenter1_8.add(layoutContainer_23);
			
			
			
		LayoutContainer lcSchRight1_8 = new LayoutContainer();

		LayoutContainer layoutContainer_24 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24.setLayout(frmlytSch);

		taxmSq01Jong = new NumberField();
		taxmSq01Jong.setAllowDecimals(true);
		taxmSq01Jong.setPropertyEditorType(Long.class);
		taxmSq01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSq01Jong.setName("taxmSq01Jong");
		taxmSq01Jong.setFieldLabel("Q01-출산보육수당");
		taxmSq01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_24.add(taxmSq01Jong, new FormData("100%"));
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

		taxmSr10Jong = new NumberField();
		taxmSr10Jong.setAllowDecimals(true);
		taxmSr10Jong.setPropertyEditorType(Long.class);
		taxmSr10Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSr10Jong.setName("taxmSr10Jong");
		taxmSr10Jong.setFieldLabel("R10-근로장학금");
		taxmSr10Jong.setStyleAttribute("marginTop", "5px;");
		
		lcSchLeft1_9.add(taxmSr10Jong, new FormData("100%"));
			
			
		LayoutContainer lcSchCenter1_9 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter1_9.setLayout(frmlytSch);

		taxmSs01Jong = new NumberField();
		taxmSs01Jong.setAllowDecimals(true);
		taxmSs01Jong.setPropertyEditorType(Long.class);
		taxmSs01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSs01Jong.setName("taxmSs01Jong");
		taxmSs01Jong.setFieldLabel("S01-주식매수선택권");
		taxmSs01Jong.setStyleAttribute("marginTop", "5px;");
		
		lcSchCenter1_9.add(taxmSs01Jong, new FormData("100%"));
			
			
			
		LayoutContainer lcSchRight1_9 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight1_9.setLayout(frmlytSch);

		taxmSy02Jong = new NumberField();
		taxmSy02Jong.setAllowDecimals(true);
		taxmSy02Jong.setPropertyEditorType(Long.class);
		taxmSy02Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSy02Jong.setName("taxmSy02Jong");
		taxmSy02Jong.setFieldLabel("Y02-사주조합인출50%");
		taxmSy02Jong.setStyleAttribute("marginTop", "5px;");
		
		lcSchRight1_9.add(taxmSy02Jong, new FormData("100%"));
			
			
			
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

		taxmSy03Jong = new NumberField();
		taxmSy03Jong.setAllowDecimals(true);
		taxmSy03Jong.setPropertyEditorType(Long.class);
		taxmSy03Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSy03Jong.setName("taxmSy03Jong");
		taxmSy03Jong.setFieldLabel("Y03-사주조합인출70%");
		taxmSy03Jong.setStyleAttribute("marginTop", "5px;");
		lcSchLeft1_10.add(taxmSy03Jong, new FormData("100%"));
			
			
			
			
		LayoutContainer lcSchCenter1_10 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter1_10.setLayout(frmlytSch);

		taxmSy04Jong = new NumberField();
		taxmSy04Jong.setAllowDecimals(true);
		taxmSy04Jong.setPropertyEditorType(Long.class);
		taxmSy04Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSy04Jong.setName("taxmSy04Jong");
		taxmSy04Jong.setFieldLabel("Y04-사주조합인출100%");
		taxmSy04Jong.setStyleAttribute("marginTop", "5px;");
		
		lcSchCenter1_10.add(taxmSy04Jong, new FormData("100%"));
			
			
			
		LayoutContainer lcSchRight1_10 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight1_10.setLayout(frmlytSch);
		
		

		taxmSy22Jong = new NumberField();
		taxmSy22Jong.setAllowDecimals(true);
		taxmSy22Jong.setPropertyEditorType(Long.class);
		taxmSy22Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSy22Jong.setName("taxmSy22Jong");
		taxmSy22Jong.setFieldLabel("Y22-전공의 수련 보조수당");
		taxmSy22Jong.setStyleAttribute("fontSize", "10pt");
		taxmSy22Jong.setStyleAttribute("marginTop", "5px;");
		
		lcSchRight1_10.add(taxmSy22Jong, new FormData("100%"));
			
			
			
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

		taxmSa01Jong = new NumberField();

		taxmSa01Jong.setAllowDecimals(true);
		taxmSa01Jong.setPropertyEditorType(Long.class);
		taxmSa01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSa01Jong.setName("taxmSa01Jong");
		taxmSa01Jong.setFieldLabel("A01-복무병 급여");
		taxmSa01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_31.add(taxmSa01Jong, new FormData("100%"));
		lcSchLeft1_11.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_11 = new LayoutContainer();

		LayoutContainer layoutContainer_32 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytSch);

		taxmSb01Jong = new NumberField();

		taxmSb01Jong.setAllowDecimals(true);
		taxmSb01Jong.setPropertyEditorType(Long.class);
		taxmSb01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSb01Jong.setName("taxmSb01Jong");
		taxmSb01Jong.setFieldLabel("B01-동원직장 급여");
		taxmSb01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_32.add(taxmSb01Jong, new FormData("100%"));

		lcSchCenter1_11.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchRight1_11 = new LayoutContainer();

		LayoutContainer layoutContainer_33 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_33.setLayout(frmlytSch);

		taxmSc01Jong = new NumberField();

		taxmSc01Jong.setAllowDecimals(true);
		taxmSc01Jong.setPropertyEditorType(Long.class);
		taxmSc01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSc01Jong.setName("taxmSc01Jong");
		taxmSc01Jong.setFieldLabel("C01-요양 급여");
		taxmSc01Jong.setStyleAttribute("fontSize", "10pt");
		taxmSc01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_33.add(taxmSc01Jong, new FormData("100%"));

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

		taxmSd01Jong = new NumberField();

		taxmSd01Jong.setAllowDecimals(true);
		taxmSd01Jong.setPropertyEditorType(Long.class);
		taxmSd01Jong.setFormat(NumberFormat.getDecimalFormat());
			
		taxmSd01Jong.setName("taxmSd01Jong");
		taxmSd01Jong.setFieldLabel("D01-요양 보상금");
		taxmSd01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_34.add(taxmSd01Jong, new FormData("100%"));

		lcSchLeft1_12.add(layoutContainer_34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_12 = new LayoutContainer();

		LayoutContainer layoutContainer_35 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_35.setLayout(frmlytSch);

		taxmSe01Jong = new NumberField();

		taxmSe01Jong.setAllowDecimals(true);
		taxmSe01Jong.setPropertyEditorType(Long.class);
		taxmSd01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSe01Jong.setName("taxmSe01Jong");
		taxmSe01Jong.setFieldLabel("E01-육아휴직급여");
		taxmSe01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_35.add(taxmSe01Jong, new FormData("100%"));

		lcSchCenter1_12.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
			
		LayoutContainer lcSchRight1_12 = new LayoutContainer();

		LayoutContainer layoutContainer_36 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_36.setLayout(frmlytSch);

		taxmSe02Jong = new NumberField();

		taxmSe02Jong.setAllowDecimals(true);
		taxmSe02Jong.setPropertyEditorType(Long.class);
		taxmSe02Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSe02Jong.setName("taxmSe02Jong");
		taxmSe02Jong.setFieldLabel("E02-육아휴직수당");
		taxmSe02Jong.setStyleAttribute("fontSize", "10pt");
		taxmSe02Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_36.add(taxmSe02Jong, new FormData("100%"));
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

		taxmSe10Jong = new NumberField();
		taxmSe10Jong.setAllowDecimals(true);
		taxmSe10Jong.setPropertyEditorType(Long.class);
		taxmSe10Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSe10Jong.setName("taxmSe10Jong");
		taxmSe10Jong.setFieldLabel("E10-사망일시금");
		taxmSe10Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_37.add(taxmSe10Jong, new FormData("100%"));

		lcSchLeft1_13.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_13 = new LayoutContainer();

		LayoutContainer layoutContainer_38 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_38.setLayout(frmlytSch);

		taxmSf01Jong = new NumberField();
		taxmSf01Jong.setAllowDecimals(true);
		taxmSf01Jong.setPropertyEditorType(Long.class);
		taxmSf01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSf01Jong.setName("taxmSf01Jong");
		taxmSf01Jong.setFieldLabel("F01-요양비");
		taxmSf01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_38.add(taxmSf01Jong, new FormData("100%"));

		lcSchCenter1_13.add(layoutContainer_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
			
		LayoutContainer lcSchRight1_13 = new LayoutContainer();

		LayoutContainer layoutContainer_39 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_39.setLayout(frmlytSch);

		taxmSh02Jong = new NumberField();
		taxmSh02Jong.setAllowDecimals(true);
		taxmSh02Jong.setPropertyEditorType(Long.class);
		taxmSh02Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh02Jong.setName("taxmSh02Jong");
		taxmSh02Jong.setFieldLabel("H02-일직·숙직료");
		taxmSh02Jong.setStyleAttribute("fontSize", "10pt");
		taxmSh02Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_39.add(taxmSh02Jong, new FormData("100%"));

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

		taxmSh03Jong = new NumberField();
		taxmSh03Jong.setAllowDecimals(true);
		taxmSh03Jong.setPropertyEditorType(Long.class);
		taxmSh03Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh03Jong.setName("taxmSh03Jong");
		taxmSh03Jong.setFieldLabel("H03-자가운전보조금");
		taxmSh03Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_40.add(taxmSh03Jong, new FormData("100%"));
		lcSchLeft1_14.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_14 = new LayoutContainer();

		LayoutContainer layoutContainer_41 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_41.setLayout(frmlytSch);

		taxmSh04Jong = new NumberField();
		taxmSh04Jong.setAllowDecimals(true);
		taxmSh04Jong.setPropertyEditorType(Long.class);
		taxmSh04Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSh04Jong.setName("taxmSh04Jong");
		taxmSh04Jong.setFieldLabel("H04-착용제복금");
		taxmSh04Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_41.add(taxmSh04Jong, new FormData("100%"));
		lcSchCenter1_14.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
		LayoutContainer lcSchRight1_14 = new LayoutContainer();

		LayoutContainer layoutContainer_42 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytSch);

		taxmSj01Jong = new NumberField();
		taxmSj01Jong.setAllowDecimals(true);
		taxmSj01Jong.setPropertyEditorType(Long.class);
		taxmSj01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSj01Jong.setName("taxmSj01Jong");
		taxmSj01Jong.setFieldLabel("J01-보훈·학습보조비");
		taxmSj01Jong.setStyleAttribute("fontSize", "10pt");
		taxmSj01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_42.add(taxmSj01Jong, new FormData("100%"));
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

		taxmSj10Jong = new NumberField();

		taxmSj10Jong.setAllowDecimals(true);
		taxmSj10Jong.setPropertyEditorType(Long.class);
		taxmSj10Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSj10Jong.setName("taxmSj10Jong");
		taxmSj10Jong.setFieldLabel("J10-전직대통령 연금");
		taxmSj10Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_43.add(taxmSj10Jong, new FormData("100%"));
		lcSchLeft1_15.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_15 = new LayoutContainer();

		LayoutContainer layoutContainer_44 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_44.setLayout(frmlytSch);

		taxmSl01Jong = new NumberField();
		taxmSl01Jong.setAllowDecimals(true);
		taxmSl01Jong.setPropertyEditorType(Long.class);
		taxmSl01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSl01Jong.setName("taxmSl01Jong");
		taxmSl01Jong.setFieldLabel("L01-군인전사 과세급여");
		taxmSl01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_44.add(taxmSl01Jong, new FormData("100%"));

		lcSchCenter1_15.add(layoutContainer_44, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
		LayoutContainer lcSchRight1_15 = new LayoutContainer();

		LayoutContainer layoutContainer_45 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_45.setLayout(frmlytSch);

		taxmSn01Jong = new NumberField();

		taxmSn01Jong.setAllowDecimals(true);
		taxmSn01Jong.setPropertyEditorType(Long.class);
		taxmSn01Jong.setFormat(NumberFormat.getDecimalFormat());

		taxmSn01Jong.setName("taxmSn01Jong");
		taxmSn01Jong.setFieldLabel("N01-국민건강보험 보험료");
		taxmSn01Jong.setStyleAttribute("fontSize", "10pt");
		taxmSn01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_45.add(taxmSn01Jong, new FormData("100%"));
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

		taxmSp01Jong = new NumberField();
		taxmSp01Jong.setAllowDecimals(true);
		taxmSp01Jong.setPropertyEditorType(Long.class);
		taxmSp01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSp01Jong.setName("taxmSp01Jong");
		taxmSp01Jong.setFieldLabel("P01-비과세 식대");
		taxmSp01Jong.setStyleAttribute("marginTop", "5px;");
		
		layoutContainer_46.add(taxmSp01Jong, new FormData("100%"));
		lcSchLeft1_16.add(layoutContainer_46, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchCenter1_16 = new LayoutContainer();

		LayoutContainer layoutContainer_47 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_47.setLayout(frmlytSch);

		taxmSp02Jong = new NumberField();
		taxmSp02Jong.setAllowDecimals(true);
		taxmSp02Jong.setPropertyEditorType(Long.class);
		taxmSp02Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSp02Jong.setName("taxmSp02Jong");
		taxmSp02Jong.setFieldLabel("P02-현물 급식");
		taxmSp02Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_47.add(taxmSp02Jong, new FormData("100%"));

		lcSchCenter1_16.add(layoutContainer_47, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			
			
			
		LayoutContainer lcSchRight1_16 = new LayoutContainer();

		LayoutContainer layoutContainer_48 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_48.setLayout(frmlytSch);

		taxmSr01Jong = new NumberField();
		taxmSr01Jong.setAllowDecimals(true);
		taxmSr01Jong.setPropertyEditorType(Long.class);
		taxmSr01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSr01Jong.setName("taxmSr01Jong");
		taxmSr01Jong.setFieldLabel("R01-국군포로 보수");
		taxmSr01Jong.setStyleAttribute("fontSize", "10pt");
		taxmSr01Jong.setStyleAttribute("marginTop", "5px;");
		layoutContainer_48.add(taxmSr01Jong, new FormData("100%"));

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
		
		taxmSr11Jong = new NumberField();
		taxmSr11Jong.setAllowDecimals(true);
		taxmSr11Jong.setPropertyEditorType(Long.class);
		taxmSr11Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSr11Jong.setName("taxmSr11Jong");
		taxmSr11Jong.setFieldLabel("R11-직무발명보상금");
		taxmSr11Jong.setStyleAttribute("marginTop", "5px;");
		lcSchLeft11_16.add(taxmSr11Jong, new FormData("100%"));		
		

//		taxmSy04Jong = new NumberField();
//		taxmSy04Jong.setAllowDecimals(true);
//		taxmSy04Jong.setPropertyEditorType(Long.class);
//		taxmSy04Jong.setFormat(NumberFormat.getDecimalFormat());
//		taxmSy04Jong.setName("taxmSy04Jong");
//		taxmSy04Jong.setFieldLabel("Y04-사주조합인출100%");
//		taxmSy04Jong.setStyleAttribute("marginTop", "5px;");
//		
//		lcSchLeft11_16.add(taxmSy04Jong, new FormData("100%"));
			
			
			
		LayoutContainer lcSchCenter3_16 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter3_16.setLayout(frmlytSch);
		
//		taxmSr11Jong = new NumberField();
//		taxmSr11Jong.setAllowDecimals(true);
//		taxmSr11Jong.setPropertyEditorType(Long.class);
//		taxmSr11Jong.setFormat(NumberFormat.getDecimalFormat());
//		taxmSr11Jong.setName("taxmSr11Jong");
//		taxmSr11Jong.setFieldLabel("R11-직무발명보상금");
//		taxmSr11Jong.setStyleAttribute("marginTop", "5px;");
//		lcSchCenter3_16.add(taxmSr11Jong, new FormData("100%"));
			
			
			
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
		cpYeta230010.add(fieldSet);
			
			
		
			
			
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

		taxmSt01Jong = new NumberField();
		taxmSt01Jong.setAllowDecimals(true);
		taxmSt01Jong.setPropertyEditorType(Long.class);
		taxmSt01Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSt01Jong.setName("taxmSt01Jong");
		taxmSt01Jong.setFieldLabel("T01-외국인기술자");
		
		lcSchLeft2_1.add(taxmSt01Jong, new FormData("100%"));
			
			
		LayoutContainer lcSchCenter2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter2_1.setLayout(frmlytSch);

//		taxmSt10Jong = new NumberField();
//		taxmSt10Jong.setAllowDecimals(true);
//		taxmSt10Jong.setPropertyEditorType(Long.class);
//		taxmSt10Jong.setFormat(NumberFormat.getDecimalFormat());
//		taxmSt10Jong.setName("taxmSt10Jong");
//		taxmSt10Jong.setFieldLabel("T10-중소 청년 소득세 감면100%");
//		lcSchCenter2_1.add(taxmSt10Jong, new FormData("100%"));
			
			
		LayoutContainer lcSchRight2_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight2_1.setLayout(frmlytSch);

		taxmSt20Jong = new NumberField();
		taxmSt20Jong.setAllowDecimals(true);
		taxmSt20Jong.setPropertyEditorType(Long.class);
		taxmSt20Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSt20Jong.setName("taxmSt20Jong");
		taxmSt20Jong.setFieldLabel("T20-조세조약 교직자 감면");
		taxmSt20Jong.setStyleAttribute("fontSize", "10pt");
		lcSchRight2_1.add(taxmSt20Jong, new FormData("100%"));
			
		
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
		
		taxmSt10Jong = new NumberField();
		taxmSt10Jong.setAllowDecimals(true);
		taxmSt10Jong.setPropertyEditorType(Long.class);
		taxmSt10Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSt10Jong.setName("taxmSt10Jong");
		taxmSt10Jong.setFieldLabel("T10-중소 청년 소득세100%");
		lcSchLeft21_1.add(taxmSt10Jong, new FormData("100%"));


			
		LayoutContainer lcSchCenter22_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter22_1.setLayout(frmlytSch);

		taxmSt12Jong = new NumberField();
		taxmSt12Jong.setAllowDecimals(true);
		taxmSt12Jong.setPropertyEditorType(Long.class);
		taxmSt12Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSt12Jong.setName("taxmSt12Jong");
		taxmSt12Jong.setFieldLabel("T12-중소청년소득세70%");
		lcSchCenter22_1.add(taxmSt12Jong, new FormData("100%"));

			 
		LayoutContainer lcSchRight23_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight23_1.setLayout(frmlytSch);
		
		taxmSt11Jong = new NumberField();
		taxmSt11Jong.setAllowDecimals(true);
		taxmSt11Jong.setPropertyEditorType(Long.class);
		taxmSt11Jong.setFormat(NumberFormat.getDecimalFormat());
		taxmSt11Jong.setName("taxmSt11Jong");
		taxmSt11Jong.setFieldLabel("T11-중소청년소득세50%");
		lcSchRight23_1.add(taxmSt11Jong, new FormData("100%"));
			
			
			
		lcSchCol21_1.add(lcSchLeft21_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol21_1.add(lcSchCenter22_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcSchCol21_1.add(lcSchRight23_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
			
			
		fieldSet2.add(lcSchCol21_1);

		cpYeta230010.add(fieldSet2);

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
		cpYeta230010.add(lcSchCol2);
	}

	// 버튼 저장액션
	private void doAction(ActionDatabase actionDatabase) {

		YetaP430010FormSave();
		// actionDatabase = ActionDatabase.UPDATE;

	}
		
	
	private void YetaP430010FormSave() {  
	              
		ye160405Dto = new Ye160405DTO();
	                
		ye160405Dto.setDpobCd(dpobCd.getValue());    							/** column 사업장코드 : dpobCd */
		ye160405Dto.setYrtxBlggYr(yrtxBlggYr.getValue()); 						/** column 귀속연도 : yrtxBlggYr */
		ye160405Dto.setClutSeptCd(clutSeptCd.getValue());						/** column 연말정산구분코드 : clutSeptCd */
		ye160405Dto.setSystemkey(systemkey.getValue());    						/** column SYSTEMKEY : systemkey */
		ye160405Dto.setWhdgDebrBusoprRgstnum(whdgDebrBusoprRgstnum.getValue()); /** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */

		
		ye160405Dto.setTaxmSa01Jong((Long) taxmSa01Jong.getValue());   /** column 비과세소득_A01_비과세 : taxmSa01Jong */
		ye160405Dto.setTaxmSb01Jong((Long)taxmSb01Jong.getValue());    /** column 비과세소득_B01_비과세 : taxmSb01Jong */
		ye160405Dto.setTaxmSc01Jong((Long)taxmSc01Jong.getValue());    /** column 비과세소득_C01_비과세 : taxmSc01Jong */
		ye160405Dto.setTaxmSd01Jong((Long)taxmSd01Jong.getValue());    /** column 비과세소득_D01_비과세 : taxmSd01Jong */
		ye160405Dto.setTaxmSe01Jong((Long)taxmSe01Jong.getValue());    /** column 비과세소득_E01_비과세 : taxmSe01Jong */
		ye160405Dto.setTaxmSe02Jong((Long)taxmSe02Jong.getValue());    /** column 비과세소득_E02_비과세 : taxmSe02Jong */
		ye160405Dto.setTaxmSe10Jong((Long)taxmSe10Jong.getValue());    /** column 비과세소득_E10_비과세 : taxmSe10Jong */
		ye160405Dto.setTaxmSf01Jong((Long)taxmSf01Jong.getValue());    /** column 비과세소득_F01_비과세 : taxmSf01Jong */
		ye160405Dto.setTaxmSg01Jong((Long)taxmSg01Jong.getValue());    /** column 비과세소득_G01_비과세 : taxmSg01Jong */
		ye160405Dto.setTaxmSh01Jong((Long)taxmSh01Jong.getValue());    /** column 비과세소득_H01_비과세 : taxmSh01Jong */
		ye160405Dto.setTaxmSh02Jong((Long)taxmSh02Jong.getValue());    /** column 비과세소득_H02_비과세 : taxmSh02Jong */
		ye160405Dto.setTaxmSh03Jong((Long)taxmSh03Jong.getValue());    /** column 비과세소득_H03_비과세 : taxmSh03Jong */
		ye160405Dto.setTaxmSh04Jong((Long)taxmSh04Jong.getValue());    /** column 비과세소득_H04_비과세 : taxmSh04Jong */
		ye160405Dto.setTaxmSh05Jong((Long)taxmSh05Jong.getValue());    /** column 비과세소득_H05_비과세 : taxmSh05Jong */
		ye160405Dto.setTaxmSh06Jong((Long)taxmSh06Jong.getValue());    /** column 비과세소득_H06_비과세 : taxmSh06Jong */
		ye160405Dto.setTaxmSh07Jong((Long)taxmSh07Jong.getValue());    /** column 비과세소득_H07_비과세 : taxmSh07Jong */
		ye160405Dto.setTaxmSh08Jong((Long)taxmSh08Jong.getValue());    /** column 비과세소득_H08_비과세 : taxmSh08Jong */
		ye160405Dto.setTaxmSh09Jong((Long)taxmSh09Jong.getValue());    /** column 비과세소득_H09_비과세 : taxmSh09Jong */
		ye160405Dto.setTaxmSh10Jong((Long)taxmSh10Jong.getValue());    /** column 비과세소득_H10_비과세 : taxmSh10Jong */
		ye160405Dto.setTaxmSh14Jong((Long)taxmSh14Jong.getValue());    /** column 비과세소득_H14_비과세 : taxmSh14Jong */
		ye160405Dto.setTaxmSh15Jong((Long)taxmSh15Jong.getValue());    /** column 비과세소득_H15_비과세 : taxmSh15Jong */
		ye160405Dto.setTaxmSh11Jong((Long)taxmSh11Jong.getValue());    /** column 비과세소득_H11_비과세 : taxmSh11Jong */
		ye160405Dto.setTaxmSh12Jong((Long)taxmSh12Jong.getValue());    /** column 비과세소득_H12_비과세 : taxmSh12Jong */
		ye160405Dto.setTaxmSh13Jong((Long)taxmSh13Jong.getValue());    /** column 비과세소득_H13_비과세 : taxmSh13Jong */
		ye160405Dto.setTaxmSh16Jong((Long)taxmSh16Jong.getValue());    /** column 비과세소득_H16_비과세 : taxmSh16Jong */
		ye160405Dto.setTaxmSi01Jong((Long)taxmSi01Jong.getValue());    /** column 비과세소득_I01_비과세 : taxmSi01Jong */
		ye160405Dto.setTaxmSj01Jong((Long)taxmSj01Jong.getValue());    /** column 비과세소득_J01_비과세 : taxmSj01Jong */
		ye160405Dto.setTaxmSj10Jong((Long)taxmSj10Jong.getValue());    /** column 비과세소득_J10_비과세 : taxmSj10Jong */
		ye160405Dto.setTaxmSk01Jong((Long)taxmSk01Jong.getValue());    /** column 비과세소득_K01_비과세 : taxmSk01Jong */
		ye160405Dto.setTaxmSl01Jong((Long)taxmSl01Jong.getValue());    /** column 비과세소득_L01_비과세 : taxmSl01Jong */
		ye160405Dto.setTaxmSm01Jong((Long)taxmSm01Jong.getValue());    /** column 비과세소득_M01_비과세 : taxmSm01Jong */
		ye160405Dto.setTaxmSm02Jong((Long)taxmSm02Jong.getValue());    /** column 비과세소득_M02_비과세 : taxmSm02Jong */
		ye160405Dto.setTaxmSm03Jong((Long)taxmSm03Jong.getValue());    /** column 비과세소득_M03_비과세 : taxmSm03Jong */
		ye160405Dto.setTaxmSn01Jong((Long)taxmSn01Jong.getValue());    /** column 비과세소득_N01_비과세 : taxmSn01Jong */
		ye160405Dto.setTaxmSo01Jong((Long)taxmSo01Jong.getValue());    /** column 비과세소득_O01_비과세 : taxmSo01Jong */
		ye160405Dto.setTaxmSq01Jong((Long)taxmSq01Jong.getValue());    /** column 비과세소득_P01_비과세 : taxmSq01Jong */
		ye160405Dto.setTaxmSp02Jong((Long)taxmSp02Jong.getValue());    /** column 비과세소득_P02_비과세 : taxmSp02Jong */
		ye160405Dto.setTaxmSq01Jong((Long)taxmSq01Jong.getValue());    /** column 비과세소득_Q01_비과세 : taxmSq01Jong */
		ye160405Dto.setTaxmSr01Jong((Long)taxmSr01Jong.getValue());    /** column 비과세소득_R01_비과세 : taxmSr10Jong */
		ye160405Dto.setTaxmSr10Jong((Long)taxmSr10Jong.getValue());    /** column 비과세소득_R10_비과세 : taxmSr10Jong */
		ye160405Dto.setTaxmSs01Jong((Long)taxmSs01Jong.getValue());    /** column 비과세소득_S01_비과세 : taxmSs01Jong */
		ye160405Dto.setTaxmSy02Jong((Long)taxmSy02Jong.getValue());    /** column 비과세소득_Y02_비과세 : taxmSy02Jong */
		ye160405Dto.setTaxmSy03Jong((Long)taxmSy03Jong.getValue());    /** column 비과세소득_Y03_비과세 : taxmSy03Jong */
		ye160405Dto.setTaxmSy04Jong((Long)taxmSy04Jong.getValue());    /** column 비과세소득_Y04_비과세 : taxmSy04Jong */
//		ye160405Dto.setTaxmSy21Jong((Long)taxmSy21Jong.getValue());    /** column 비과세소득_Y21_비과세 : taxmSy21Jong */
		ye160405Dto.setTaxmSy22Jong((Long)taxmSy22Jong.getValue());    /** column 비과세소득_Y22_비과세 : taxmSy22Jong */
		ye160405Dto.setTaxmSt01Jong((Long)taxmSt01Jong.getValue());    /** column 감면소득_T01_비과세 : taxmSt01Jong */
		ye160405Dto.setTaxmSt10Jong((Long)taxmSt10Jong.getValue());    /** column 감면소득_T10_비과세 : taxmSt10Jong */
		ye160405Dto.setTaxmSt11Jong((Long)taxmSt11Jong.getValue());    /** column 감면소득_T11_비과세 : taxmSt11Jong */
		ye160405Dto.setTaxmSt12Jong((Long)taxmSt12Jong.getValue());    /** column 감면소득_T12_비과세 : taxmSt12Jong */
		ye160405Dto.setTaxmSt20Jong((Long)taxmSt20Jong.getValue());    /** column 감면소득_T20_비과세 : taxmSt20Jong */
		ye160405Dto.setTaxmSr11Jong((Long)taxmSr11Jong.getValue());    /** column 비과세소득_R11_비과세 : taxmSr11Jong */

		yetaP430010Service.activityOnYetaP430010ToYe160405(ye160405Dto, actionDatabase, new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP430010ToYe160405(" + actionDatabase.name() + ") : " + caught), null);
					}
					public void onSuccess(Integer result) { 
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
		
		ye160405Dto = new Ye160405DTO();
		
		ye160405Dto.setDpobCd(dpobCd.getValue());													/**  column 사업장코드 : dpobCd */
		ye160405Dto.setSystemkey(systemkey.getValue()); 											/**  column SYSTEMKEY : systemkey */
		ye160405Dto.setClutSeptCd(clutSeptCd.getValue());											/** column 정산구분코드 : clutSeptCd */
		ye160405Dto.setYrtxBlggYr(yrtxBlggYr.getValue());											/** column 연말정산귀속년도 : yrtxBlggYr */
		ye160405Dto.setWhdgDebrBusoprRgstnum(whdgDebrBusoprRgstnum.getValue().replaceAll("-", ""));	/** column 사업자등록번호 : whdgDebrBusoprRgstnum */
		
		yetaP430010Service.getYetaP430010ToYe160405List(ye160405Dto, new AsyncCallback<Ye160405DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYetaP23008ToYe160405List(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye160405DTO result) {
				// TODO Auto-generated method stub
				readYetaP430010Data(result);
			}
		});
	}	
	
	
	/** 비과세 및 감면소득 조회부 **/
	public void readYetaP430010Data(Ye160405DTO result) {
		
//		dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
//		yrtxBlggYr.setValue(result.getYrtxBlggYr());    /** column 귀속연도 : yrtxBlggYr */
//		clutSeptCd.setValue(result.getClutSeptCd());    /** column 연말정산구분코드 : clutSeptCd */
//		systemkey.setValue(result.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		elctYymm.setValue(result.getElctYymm());    /** column 지급년월 : elctYymm */
		
		taxmSa01Jong.setValue(result.getTaxmSa01Jong());    /** column 비과세소득_A01_비과세 : taxmSa01Jong */
		taxmSb01Jong.setValue(result.getTaxmSb01Jong());    /** column 비과세소득_B01_비과세 : taxmSb01Jong */
		taxmSc01Jong.setValue(result.getTaxmSc01Jong());    /** column 비과세소득_C01_비과세 : taxmSc01Jong */
		taxmSd01Jong.setValue(result.getTaxmSd01Jong());    /** column 비과세소득_D01_비과세 : taxmSd01Jong */
		taxmSe01Jong.setValue(result.getTaxmSe01Jong());    /** column 비과세소득_E01_비과세 : taxmSe01Jong */
		taxmSe02Jong.setValue(result.getTaxmSe02Jong());    /** column 비과세소득_E02_비과세 : taxmSe02Jong */
		taxmSe10Jong.setValue(result.getTaxmSe10Jong());    /** column 비과세소득_E10_비과세 : taxmSe10Jong */
		taxmSf01Jong.setValue(result.getTaxmSf01Jong());    /** column 비과세소득_F01_비과세 : taxmSf01Jong */
		taxmSg01Jong.setValue(result.getTaxmSg01Jong());    /** column 비과세소득_G01_비과세 : taxmSg01Jong */
		taxmSh01Jong.setValue(result.getTaxmSh01Jong());    /** column 비과세소득_H01_비과세 : taxmSh01Jong */
		taxmSh02Jong.setValue(result.getTaxmSh02Jong());    /** column 비과세소득_H02_비과세 : taxmSh02Jong */
		taxmSh03Jong.setValue(result.getTaxmSh03Jong());    /** column 비과세소득_H03_비과세 : taxmSh03Jong */
		taxmSh04Jong.setValue(result.getTaxmSh04Jong());    /** column 비과세소득_H04_비과세 : taxmSh04Jong */
		taxmSh05Jong.setValue(result.getTaxmSh05Jong());    /** column 비과세소득_H05_비과세 : taxmSh05Jong */
		taxmSh06Jong.setValue(result.getTaxmSh06Jong());    /** column 비과세소득_H06_비과세 : taxmSh06Jong */
		taxmSh07Jong.setValue(result.getTaxmSh07Jong());    /** column 비과세소득_H07_비과세 : taxmSh07Jong */
		taxmSh08Jong.setValue(result.getTaxmSh08Jong());    /** column 비과세소득_H08_비과세 : taxmSh08Jong */
		taxmSh09Jong.setValue(result.getTaxmSh09Jong());    /** column 비과세소득_H09_비과세 : taxmSh09Jong */
		taxmSh10Jong.setValue(result.getTaxmSh10Jong());    /** column 비과세소득_H10_비과세 : taxmSh10Jong */
		taxmSh14Jong.setValue(result.getTaxmSh14Jong());    /** column 비과세소득_H14_비과세 : taxmSh14Jong */
		taxmSh15Jong.setValue(result.getTaxmSh15Jong());    /** column 비과세소득_H15_비과세 : taxmSh15Jong */
		taxmSh11Jong.setValue(result.getTaxmSh11Jong());    /** column 비과세소득_H11_비과세 : taxmSh11Jong */
		taxmSh12Jong.setValue(result.getTaxmSh12Jong());    /** column 비과세소득_H12_비과세 : taxmSh12Jong */
		taxmSh13Jong.setValue(result.getTaxmSh13Jong());    /** column 비과세소득_H13_비과세 : taxmSh13Jong */
		taxmSh16Jong.setValue(result.getTaxmSh16Jong());    /** column 비과세소득_H16_비과세 : taxmSh16Jong */
		taxmSi01Jong.setValue(result.getTaxmSi01Jong());    /** column 비과세소득_I01_비과세 : taxmSi01Jong */
		taxmSj01Jong.setValue(result.getTaxmSj01Jong());    /** column 비과세소득_J01_비과세 : taxmSj01Jong */
		taxmSj10Jong.setValue(result.getTaxmSj10Jong());    /** column 비과세소득_J10_비과세 : taxmSj10Jong */
		taxmSk01Jong.setValue(result.getTaxmSk01Jong());    /** column 비과세소득_K01_비과세 : taxmSk01Jong */
		taxmSl01Jong.setValue(result.getTaxmSl01Jong());    /** column 비과세소득_L01_비과세 : taxmSl01Jong */
		taxmSm01Jong.setValue(result.getTaxmSm01Jong());    /** column 비과세소득_M01_비과세 : taxmSm01Jong */
		taxmSm02Jong.setValue(result.getTaxmSm02Jong());    /** column 비과세소득_M02_비과세 : taxmSm02Jong */
		taxmSm03Jong.setValue(result.getTaxmSm03Jong());    /** column 비과세소득_M03_비과세 : taxmSm03Jong */
		taxmSn01Jong.setValue(result.getTaxmSn01Jong());    /** column 비과세소득_N01_비과세 : taxmSn01Jong */
		taxmSo01Jong.setValue(result.getTaxmSo01Jong());    /** column 비과세소득_O01_비과세 : taxmSo01Jong */
		taxmSq01Jong.setValue(result.getTaxmSq01Jong());    /** column 비과세소득_P01_비과세 : taxmSq01Jong */
		taxmSp02Jong.setValue(result.getTaxmSp02Jong());    /** column 비과세소득_P02_비과세 : taxmSp02Jong */
		taxmSq01Jong.setValue(result.getTaxmSq01Jong());    /** column 비과세소득_Q01_비과세 : taxmSq01Jong */
		taxmSr01Jong.setValue(result.getTaxmSr01Jong());    /** column 비과세소득_R01_비과세 : taxmSr01Jong */
		taxmSr10Jong.setValue(result.getTaxmSr10Jong());    /** column 비과세소득_R10_비과세 : taxmSr10Jong */
		taxmSs01Jong.setValue(result.getTaxmSs01Jong());    /** column 비과세소득_S01_비과세 : taxmSs01Jong */
		taxmSy02Jong.setValue(result.getTaxmSy02Jong());    /** column 비과세소득_Y02_비과세 : taxmSy02Jong */
		taxmSy03Jong.setValue(result.getTaxmSy03Jong());    /** column 비과세소득_Y03_비과세 : taxmSy03Jong */
		taxmSy04Jong.setValue(result.getTaxmSy04Jong());    /** column 비과세소득_Y04_비과세 : taxmSy04Jong */
//		taxmSy21Jong.setValue(result.getTaxmSy21Jong());    /** column 비과세소득_Y21_비과세 : taxmSy21Jong */
		taxmSy22Jong.setValue(result.getTaxmSy22Jong());    /** column 비과세소득_Y22_비과세 : taxmSy22Jong */
		taxmSt01Jong.setValue(result.getTaxmSt01Jong());    /** column 감면소득_T01_비과세 : taxmSt01Jong */
		taxmSt10Jong.setValue(result.getTaxmSt10Jong());    /** column 감면소득_T10_비과세 : taxmSt10Jong */
		taxmSt11Jong.setValue(result.getTaxmSt11Jong());    /** column 감면소득_T11_비과세 : taxmSt11Jong */
		taxmSt12Jong.setValue(result.getTaxmSt12Jong());    /** column 감면소득_T12_비과세 : taxmSt12Jong */
		taxmSt20Jong.setValue(result.getTaxmSt20Jong());    /** column 감면소득_T20_비과세 : taxmSt20Jong */
		taxmSr11Jong.setValue(result.getTaxmSr11Jong());    /** column 비과세소득_R11_비과세 : taxmSr11Jong */
		
		/** 총계 부분 */
		taxeTotl.setValue(result.getTaxeTotl()); // ⑳ 비과세 계
		taxmTotl.setValue(result.getTaxmTotl()); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단
	}
	
	
		
	public void setReadOnlyTrueYetaP13008() {
		
		srhHanNm.setReadOnly(true); 				// 성명
		srhWhdgDebrBusoprRgstnum.setReadOnly(true); // 사업자등록번호
		srhSiteCtnt.setReadOnly(true);				// 근무지명
			
		taxmSg01Jong.setReadOnly(true); // ⑱-5 G01-비과세 학자금
		taxmSh01Jong.setReadOnly(true); // ⑱-9 H01-무보수위원수당
		taxmSh05Jong.setReadOnly(true); // ⑱-18 H05-경호·승선수당
		taxmSh06Jong.setReadOnly(true); // ⑱-4 H06-유아·초중등
		taxmSh07Jong.setReadOnly(true); // ⑱-4 H07-고등교육법
		taxmSh08Jong.setReadOnly(true); // ⑱-4 H08-특별법
		taxmSh09Jong.setReadOnly(true); // ⑱-4 H09-연구기관
		taxmSh10Jong.setReadOnly(true); // ⑱-4 H10-기업부설연구소
		taxmSh14Jong.setReadOnly(true); // ⑱-22 H14-보육교사
		taxmSh15Jong.setReadOnly(true); // ⑱-23 H15-사립유치원수석교사
		taxmSh11Jong.setReadOnly(true); // ⑱-6 H11-취재수당
		taxmSh12Jong.setReadOnly(true); // ⑱-7 H12-벽지수당
		taxmSh13Jong.setReadOnly(true); // ⑱-8 H13-재해관련급여
		taxmSh16Jong.setReadOnly(true); // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
		taxmSi01Jong.setReadOnly(true); // ⑱-19 l01-외국정부 근무자
		taxmSk01Jong.setReadOnly(true); // ⑱-10 K01-외국주둔군인
		taxmSm01Jong.setReadOnly(true); // ⑱ M01-국외근로 100만원
		taxmSm02Jong.setReadOnly(true); // ⑱ M02-국외근로 300만원
		taxmSm03Jong.setReadOnly(true); // ⑱ M03-국외근로
		taxmSo01Jong.setReadOnly(true); // ⑱-1 O01-야간근로수당
		taxmSq01Jong.setReadOnly(true); // ⑱-2 Q01-출산보육수당
		taxmSr10Jong.setReadOnly(true); // ⑱-21 R10-근로장학금
		taxmSs01Jong.setReadOnly(true); // ⑱-11 S01-주식매수선택권
		taxmSy02Jong.setReadOnly(true); // ⑱-14 Y02-우리사주조합인출금50%
		taxmSy03Jong.setReadOnly(true); // ⑱-15 Y03-우리사주조합인출금70%
//		taxmSy21Jong.setReadOnly(true); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmSy22Jong.setReadOnly(true); // ⑲ Y22-전공의 수련 보조수당

		taxmSa01Jong.setReadOnly(true); // A01-복무병 급여
		taxmSb01Jong.setReadOnly(true); // B01-동원직장 급여
		taxmSc01Jong.setReadOnly(true); // C01-요양 급여
		taxmSd01Jong.setReadOnly(true); // D01-요양 보상금
		taxmSe01Jong.setReadOnly(true); // E01-육아휴직급여
		taxmSe02Jong.setReadOnly(true); // E02-육아휴직수당
		taxmSe10Jong.setReadOnly(true); // E10-사망일시금
		taxmSf01Jong.setReadOnly(true); // F01-요양비

		taxmSh02Jong.setReadOnly(true); // H02-일직·숙직료
		taxmSh03Jong.setReadOnly(true); // H03-자가운전보조금
		taxmSh04Jong.setReadOnly(true); // H04-착용제복금
		taxmSj01Jong.setReadOnly(true); // J01-보훈·학습보조비
		taxmSj10Jong.setReadOnly(true); // J10-전직대통령 연금
		taxmSl01Jong.setReadOnly(true); // L01-중군군인전사 과세급여
		taxmSn01Jong.setReadOnly(true); // N01-국민건강보험 보험료
		taxmSp01Jong.setReadOnly(true); // P01-비과세 식대
		taxmSp02Jong.setReadOnly(true); // P02-현물 급식
		taxmSr01Jong.setReadOnly(true); // R01-국군포로 보수
		
		/** 감면소득 부분 */
		taxmSt01Jong.setReadOnly(true); // ⑱-12 T01-외국인기술자
		taxmSt10Jong.setReadOnly(true); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmSt20Jong.setReadOnly(true); // ⑱-25 T20-조세조약상 교직자 감면

		/** 총계 부분 */
		taxeTotl.setReadOnly(false); // ⑳ 비과세 계
		taxmTotl.setReadOnly(false); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
		
	}
	
	
	
	public void setReadOnlyFalseYetaP13008() {
		
		srhHanNm.setReadOnly(true); 					// 성명
		srhWhdgDebrBusoprRgstnum.setReadOnly(true); 	// 사업자등록번호
		srhSiteCtnt.setReadOnly(true);					// 근무지명
		
		taxmSg01Jong.setReadOnly(false); // ⑱-5 G01-비과세 학자금
		taxmSh01Jong.setReadOnly(false); // ⑱-9 H01-무보수위원수당
		taxmSh05Jong.setReadOnly(false); // ⑱-18 H05-경호·승선수당
		taxmSh06Jong.setReadOnly(false); // ⑱-4 H06-유아·초중등
		taxmSh07Jong.setReadOnly(false); // ⑱-4 H07-고등교육법
		taxmSh08Jong.setReadOnly(false); // ⑱-4 H08-특별법
		taxmSh09Jong.setReadOnly(false); // ⑱-4 H09-연구기관
		taxmSh10Jong.setReadOnly(false); // ⑱-4 H10-기업부설연구소
		taxmSh14Jong.setReadOnly(false); // ⑱-22 H14-보육교사
		taxmSh15Jong.setReadOnly(false); // ⑱-23 H15-사립유치원수석교사
		taxmSh11Jong.setReadOnly(false); // ⑱-6 H11-취재수당
		taxmSh12Jong.setReadOnly(false); // ⑱-7 H12-벽지수당
		taxmSh13Jong.setReadOnly(false); // ⑱-8 H13-재해관련급여
		taxmSh16Jong.setReadOnly(false); // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
		taxmSi01Jong.setReadOnly(false); // ⑱-19 l01-외국정부 근무자
		taxmSk01Jong.setReadOnly(false); // ⑱-10 K01-외국주둔군인
		taxmSm01Jong.setReadOnly(false); // ⑱ M01-국외근로 100만원
		taxmSm02Jong.setReadOnly(false); // ⑱ M02-국외근로 300만원
		taxmSm03Jong.setReadOnly(false); // ⑱ M03-국외근로
		taxmSo01Jong.setReadOnly(false); // ⑱-1 O01-야간근로수당
		taxmSq01Jong.setReadOnly(false); // ⑱-2 Q01-출산보육수당
		taxmSr10Jong.setReadOnly(false); // ⑱-21 R10-근로장학금
		taxmSs01Jong.setReadOnly(false); // ⑱-11 S01-주식매수선택권
		taxmSy02Jong.setReadOnly(false); // ⑱-14 Y02-우리사주조합인출금50%
		taxmSy03Jong.setReadOnly(false); // ⑱-15 Y03-우리사주조합인출금70%
//		taxmSy21Jong.setReadOnly(false); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmSy22Jong.setReadOnly(false); // ⑲ Y22-전공의 수련 보조수당

		taxmSa01Jong.setReadOnly(false); // A01-복무병 급여
		taxmSb01Jong.setReadOnly(false); // B01-동원직장 급여
		taxmSc01Jong.setReadOnly(false); // C01-요양 급여
		taxmSd01Jong.setReadOnly(false); // D01-요양 보상금
		taxmSe01Jong.setReadOnly(false); // E01-육아휴직급여
		taxmSe02Jong.setReadOnly(false); // E02-육아휴직수당
		taxmSe10Jong.setReadOnly(false); // E10-사망일시금
		taxmSf01Jong.setReadOnly(false); // F01-요양비

		taxmSh02Jong.setReadOnly(false); // H02-일직·숙직료
		taxmSh03Jong.setReadOnly(false); // H03-자가운전보조금
		taxmSh04Jong.setReadOnly(false); // H04-착용제복금
		taxmSj01Jong.setReadOnly(false); // J01-보훈·학습보조비
		taxmSj10Jong.setReadOnly(false); // J10-전직대통령 연금
		taxmSl01Jong.setReadOnly(false); // L01-중군군인전사 과세급여
		taxmSn01Jong.setReadOnly(false); // N01-국민건강보험 보험료
		taxmSp01Jong.setReadOnly(false); // P01-비과세 식대
		taxmSp02Jong.setReadOnly(false); // P02-현물 급식
		taxmSr01Jong.setReadOnly(false); // R01-국군포로 보수
		
		/** 감면소득 부분 */
		taxmSt01Jong.setReadOnly(false); // ⑱-12 T01-외국인기술자
		taxmSt10Jong.setReadOnly(false); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmSt20Jong.setReadOnly(false); // ⑱-25 T20-조세조약상 교직자 감면

		/** 총계 부분 */
		taxeTotl.setReadOnly(false); // ⑳ 비과세 계
		taxmTotl.setReadOnly(false); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
	}
		
		

}