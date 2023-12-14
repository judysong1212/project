/**
 * 비과세 및 감면소득 입력
 */
package com.app.exterms.yearendtax.client.form.yeta2016;
  
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3200DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13008Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13008ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP13008   extends MSFFormPanel { 

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
 
	private  ContentPanel cpYeta13008; 
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/

		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

		// -------------- DTO 선언 시작 --------------
		private  Ye16Ta3200DTO yeta3200Dto; 
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
  private MSFFormPanel caller2;
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
  	private  Button btnYetaSave = new Button();	//저장


  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------

 	
 	private HiddenField<String> edacRvyy;	/** column 연말정산귀속년도 : edacRvyy */
	private HiddenField<String> settGbcd;	/** column 정산구분코드 : settGbcd */
	private HiddenField<String> systemkey;  /**  column SYSTEMKEY : systemkey */
//	private HiddenField<String> hid_siteNumb;	/**  column 사업자등록번호 : siteNumb */
	private HiddenField<String> siteNumb;	/**  column 사업자등록번호 : siteNumb */
	private HiddenField<String>	 dpobCd;	/**  column 사업장코드 : dpobCd */
 	// -------------- 검색 조건 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private YetaP13008ServiceAsync yetaP13008Service = YetaP13008Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

    private  TextField<String> srhHanNm; 	// 성명
    private  TextField<String> srhSiteNumb; // 사업자등록번호
    private  TextField<String> srhSiteCtnt;	// 근무지명
    
    /**비과세부분 */
    private  NumberField taxmEg01;    // ⑱-5 G01-비과세 학자금
    private  NumberField taxmEh01;    // ⑱-9 H01-무보수위원수당
    private  NumberField taxmEh05;    // ⑱-18 H05-경호·승선수당
    private  NumberField taxmEh06;    // ⑱-4 H06-유아·초중등
    private  NumberField taxmEh07;    // ⑱-4 H07-고등교육법
    private  NumberField taxmEh08;    // ⑱-4 H08-특별법
    private  NumberField taxmEh09;    // ⑱-4 H09-연구기관
    private  NumberField taxmEh10;    // ⑱-4 H10-기업부설연구소
    private  NumberField taxmEh14;    // ⑱-22 H14-보육교사
    private  NumberField taxmEh15;    // ⑱-23 H15-사립유치원수석교사
    private  NumberField taxmEh11;    // ⑱-6 H11-취재수당
    private  NumberField taxmEh12;    // ⑱-7 H12-벽지수당
    private  NumberField taxmEh13;    // ⑱-8 H13-재해관련급여
    private  NumberField taxmEh16;    // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
    private  NumberField taxmEi01;    // ⑱-19 l01-외국정부 근무자
    private  NumberField taxmEk01;    // ⑱-10 K01-외국주둔군인
    private  NumberField taxmEm01;    // ⑱ M01-국외근로 100만원
    private  NumberField taxmEm02;    // ⑱ M02-국외근로 300만원
    private  NumberField taxmEm03;    // ⑱ M03-국외근로
    private  NumberField taxmEo01;    // ⑱-1 O01-야간근로수당
    private  NumberField taxmEq01;    // ⑱-2 Q01-출산보육수당
    private  NumberField taxmEr10;    // ⑱-21 R10-근로장학금
    private  NumberField taxmEs01;    // ⑱-11 S01-주식매수선택권
    private  NumberField taxmEy02;    // ⑱-14 Y02-우리사주조합인출금50%
    private  NumberField taxmEy03;    // ⑱-15 Y03-우리사주조합인출금70%
    private  NumberField taxmEy04;    // ⑱-15 Y03-우리사주조합인출금70%
    private  NumberField taxmEy21;    // ⑱-20 Y21-장기미취업자 중소기업 취업    
    private  NumberField taxmEy22;    // ⑲ Y22-전공의 수련 보조수당
     
    /**감면소득 부분 */
    private  NumberField taxmEt01;    // ⑱-12 T01-외국인기술자
    private  NumberField taxmEt10;    // ⑱-24 T10-중소기업취업 청년 소득세 감면
    private  NumberField taxmEt11;    // ⑱-24 T11-중소기업취업 청년 소득세 감면
    private  NumberField taxmEt12;    // ⑱-24 T12-중소기업취업 청년 소득세 감면
    private  NumberField taxmEt20;    // ⑱-25 T20-조세조약상 교직자 감면
    
    
    /** 코드만 있고 기재란 없는 부분 */
    private NumberField taxmEa01; 	// A01-복무병 급여
    private NumberField taxmEb01; 	// B01-동원직장 급여
    private NumberField taxmEc01;		// C01-요양 급여
    private NumberField taxmEd01;		// D01-요양 보상금
    private NumberField taxmEe01;		// E01-육아휴직급여
    private NumberField taxmEe02;		// E02-육아휴직수당
    private NumberField taxmEe10;		// E10-사망일시금
    private NumberField taxmEf01;		// F01-요양비
    
    private NumberField taxmEh02;		// H02-일직·숙직료 
    private NumberField taxmEh03;		// H03-자가운전보조금
    private NumberField taxmEh04;		// H04-착용제복금
    
    private NumberField taxmEj01;		// J01-보훈·학습보조비
    private NumberField taxmEj10;		// J10-전직대통령 연금

    private NumberField taxmEl01;		// L01-중군군인전사 과세급여
    
    private NumberField taxmEn01;		// N01-국민건강보험 보험료
    
    private NumberField taxmEp01;		// P01-비과세 식대
    private NumberField taxmEp02;		// P02-현물 급식
    
    private NumberField taxmEr01;		//R01-국군포로 보수
    
    
    /** 총계 부분*/
    private  NumberField taxeTotl;    // ⑳ 비과세 계
    private  NumberField taxmTotl;    // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  



	public YetaP13008(final ActionDatabase actionDatabase, final MSFPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYeta13008 = new ContentPanel();

		createStandardForm();
		setReadOnlyTrueYetaP13008();

		cpYeta13008.setBodyBorder(false);
		cpYeta13008.setBorders(false);
		cpYeta13008.setHeaderVisible(false);
		cpYeta13008.setSize("790px", "680px");

		this.add(cpYeta13008);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "750px");
	} 
	  
	public YetaP13008(final ActionDatabase actionDatabase, final MSFFormPanel caller2) {
		  
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller2 = caller2;

		cpYeta13008 = new ContentPanel();

		createStandardForm();
		setReadOnlyFalseYetaP13008();

		cpYeta13008.setBodyBorder(false);
		cpYeta13008.setBorders(false);
		cpYeta13008.setHeaderVisible(false);
		cpYeta13008.setSize("790px", "640px");

		this.add(cpYeta13008);
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
	            //@Override
	            public void handleEvent(BaseEvent be) {
	            	 Timer timer = new Timer() {
							@Override
							public void run() {
								
 
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
		
		private void createStandardForm() {
			
			systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
			systemkey.setName("systemkey");
			cpYeta13008.add(systemkey);
			
		    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		    dpobCd.setName("dpobCd");
		    cpYeta13008.add(dpobCd);
		    
		    edacRvyy = new HiddenField<String>();	/** column 정산년도 : edacRvyy */
		    edacRvyy.setName("edacRvyy");
		    cpYeta13008.add(edacRvyy);
		    
		    settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
		    settGbcd.setName("settGbcd");
		    cpYeta13008.add(settGbcd);
		    
		    siteNumb = new HiddenField<String>();	/** column 사업자등록번호 : siteNumb */
		    siteNumb.setName("siteNumb");
		    cpYeta13008.add(siteNumb);
		    
//		    hid_siteNumb = new HiddenField<String>();	/** column 사업자등록번호 : siteNumb */
//		    hid_siteNumb.setName("hid_siteNumb");
//		    cpYeta13008.add(hid_siteNumb);
			
			topYetaBtnBar  = new ButtonBar();
			topYetaBtnBar .setAlignment(HorizontalAlignment.RIGHT);
				
			btnYetaSave = new Button("저장");
			btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
			btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			  public void handleEvent(ButtonEvent e) {	                
	                doAction(actionDatabase);
	                
	                if((ActionDatabase.INSERT).equals(actionDatabase)) {
	                	actionDatabase = ActionDatabase.INSERT;
	                }else {
	                	actionDatabase = ActionDatabase.UPDATE;
	                }
	                 
	            }
	        });
			topYetaBtnBar.add(btnYetaSave);
			
			cpYeta13008.add(topYetaBtnBar);
			
//			dpobCd = new HiddenField<String>();            //사업장코드 
//	        systemkey = new HiddenField<String>();         //시스템키 
			
			
			
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
			layoutContainer_1.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter = new LayoutContainer();		
			lcSchCenter.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(110);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytSch);
			
			srhSiteNumb = new TextField<String>();
			srhSiteNumb.setName("srhSiteNumb");
			srhSiteNumb.setFieldLabel("사업자등록번호");
			new TextFieldMask<String>(srhSiteNumb, "999-99-99999");
			srhSiteNumb.setStyleAttribute("marginTop", "5px;");
			layoutContainer_2.add(srhSiteNumb, new FormData("100%"));

			lcSchCenter.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
			
			
			
			
			
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
			layoutContainer_3.setBorders(false);
			
			
			
			lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			lcSchLeft.setBorders(false);
			lcSchCol.add(lcSchCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
			lcSchCenter.setBorders(false);
			lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
			lcSchCenter.setBorders(false);			

			lcSchCol.setBorders(true);
			lcSchCol.setHeight(35);
			lcSchCol.setStyleAttribute("marginTop", "5px;");			
			cpYeta13008.add(lcSchCol);
			
			
			
			FieldSet fieldSet = new FieldSet();
			fieldSet.setHeadingHtml("비과세");
//			fieldSet.setHeight(470);
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
			
			taxmEg01 = new NumberField();
			
			taxmEg01.setAllowDecimals(true); 
			taxmEg01.setPropertyEditorType(Long.class); 
			taxmEg01.setFormat(NumberFormat.getDecimalFormat());
		      
			taxmEg01.setName("taxmEg01");
			taxmEg01.setFieldLabel("G01-비과세 학자금");
			taxmEg01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_4.add(taxmEg01, new FormData("100%"));

			lcSchLeft1_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_4.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_2 = new LayoutContainer();
			
			LayoutContainer layoutContainer_5 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_5.setLayout(frmlytSch);
			
			taxmEh01 = new NumberField();
			
			taxmEh01.setAllowDecimals(true); 
			taxmEh01.setPropertyEditorType(Long.class); 
			taxmEh01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh01.setName("taxmEh01");
			taxmEh01.setFieldLabel("H01-무보수위원수당");
			taxmEh01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_5.add(taxmEh01, new FormData("100%"));

			lcSchCenter1_2.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_5.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_2 = new LayoutContainer();
			
			LayoutContainer layoutContainer_6 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_6.setLayout(frmlytSch);
			
			taxmEh05 = new NumberField();
			
			taxmEh05.setAllowDecimals(true); 
			taxmEh05.setPropertyEditorType(Long.class); 
			taxmEh05.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh05.setName("taxmEh05");
			taxmEh05.setFieldLabel("H05-경호·승선수당");
			taxmEh05.setStyleAttribute("marginTop", "5px;");
			layoutContainer_6.add(taxmEh05, new FormData("100%"));

			lcSchRight1_2.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_6.setBorders(false);
			
			
			
			lcSchCol1_2.add(lcSchLeft1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_2.setBorders(false);
			lcSchCol1_2.add(lcSchCenter1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_2.setBorders(false);
			lcSchCol1_2.add(lcSchRight1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_2.setBorders(false);			
			
			
			
			
			
			
			// 비과세 두번째 줄
			LayoutContainer lcSchCol1_3 = new LayoutContainer();
			lcSchCol1_3.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_3 = new LayoutContainer();
			
			LayoutContainer layoutContainer_7 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_7.setLayout(frmlytSch);
			
			taxmEh06 = new NumberField();
			
			taxmEh06.setAllowDecimals(true); 
			taxmEh06.setPropertyEditorType(Long.class); 
			taxmEh06.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh06.setName("taxmEh06");
			taxmEh06.setFieldLabel("H06-유아·초중등");
			taxmEh06.setStyleAttribute("marginTop", "5px;");
			layoutContainer_7.add(taxmEh06, new FormData("100%"));

			lcSchLeft1_3.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_7.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_3 = new LayoutContainer();
			
			LayoutContainer layoutContainer_8 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_8.setLayout(frmlytSch);
			
			taxmEh07 = new NumberField();
			
			taxmEh07.setAllowDecimals(true); 
			taxmEh07.setPropertyEditorType(Long.class); 
			taxmEh07.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh07.setName("taxmEh07");
			taxmEh07.setFieldLabel("H07-고등교육법");
			taxmEh07.setStyleAttribute("marginTop", "5px;");
			layoutContainer_8.add(taxmEh07, new FormData("100%"));

			lcSchCenter1_3.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_8.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_3 = new LayoutContainer();
			
			LayoutContainer layoutContainer_9 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_9.setLayout(frmlytSch);
			
			taxmEh08 = new NumberField();
			
			taxmEh08.setAllowDecimals(true); 
			taxmEh08.setPropertyEditorType(Long.class); 
			taxmEh08.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh08.setName("taxmEh08");
			taxmEh08.setFieldLabel("H08-특별법");
			taxmEh08.setStyleAttribute("marginTop", "5px;");
			layoutContainer_9.add(taxmEh08, new FormData("100%"));

			lcSchRight1_3.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_9.setBorders(false);
			
			
			
			lcSchCol1_3.add(lcSchLeft1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_3.setBorders(false);
			lcSchCol1_3.add(lcSchCenter1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_3.setBorders(false);
			lcSchCol1_3.add(lcSchRight1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_3.setBorders(false);	
			
			
			
			
			
			
			// 비과세 세번째 줄
			LayoutContainer lcSchCol1_4 = new LayoutContainer();
			lcSchCol1_4.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_4 = new LayoutContainer();
			
			LayoutContainer layoutContainer_10 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_10.setLayout(frmlytSch);
			
			taxmEh09 = new NumberField();
			
			taxmEh09.setAllowDecimals(true); 
			taxmEh09.setPropertyEditorType(Long.class); 
			taxmEh09.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh09.setName("taxmEh09");
			taxmEh09.setFieldLabel("H09-연구기관");
			taxmEh09.setStyleAttribute("marginTop", "5px;");
			layoutContainer_10.add(taxmEh09, new FormData("100%"));

			lcSchLeft1_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_10.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_4 = new LayoutContainer();
			
			LayoutContainer layoutContainer_11 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_11.setLayout(frmlytSch);
			
			taxmEh10 = new NumberField();
			
			taxmEh10.setAllowDecimals(true); 
			taxmEh10.setPropertyEditorType(Long.class); 
			taxmEh10.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh10.setName("taxmEh10");
			taxmEh10.setFieldLabel("H10-기업부설연구소");
			taxmEh10.setStyleAttribute("marginTop", "5px;");
			layoutContainer_11.add(taxmEh10, new FormData("100%"));

			lcSchCenter1_4.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_11.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_4 = new LayoutContainer();
			
			LayoutContainer layoutContainer_12 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_12.setLayout(frmlytSch);
			
			taxmEh14 = new NumberField();
			
			taxmEh14.setAllowDecimals(true); 
			taxmEh14.setPropertyEditorType(Long.class); 
			taxmEh14.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh14.setName("taxmEh14");
			taxmEh14.setFieldLabel("H14-보육교사");
			taxmEh14.setStyleAttribute("marginTop", "5px;");
			layoutContainer_12.add(taxmEh14, new FormData("100%"));

			lcSchRight1_4.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_12.setBorders(false);
			
			
			
			lcSchCol1_4.add(lcSchLeft1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_4.setBorders(false);
			lcSchCol1_4.add(lcSchCenter1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_4.setBorders(false);
			lcSchCol1_4.add(lcSchRight1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_4.setBorders(false);				
			
			
			
			

			
			// 비과세 네번째 줄
			LayoutContainer lcSchCol1_5 = new LayoutContainer();
			lcSchCol1_5.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_5 = new LayoutContainer();
			
			LayoutContainer layoutContainer_13 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_13.setLayout(frmlytSch);
			
			taxmEh15 = new NumberField();
			
			taxmEh15.setAllowDecimals(true); 
			taxmEh15.setPropertyEditorType(Long.class); 
			taxmEh15.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh15.setName("taxmEh15");
			taxmEh15.setFieldLabel("H15-사립유치원수석교사");
			taxmEh15.setStyleAttribute("marginTop", "5px;");
			layoutContainer_13.add(taxmEh15, new FormData("100%"));

			lcSchLeft1_5.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_13.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_5 = new LayoutContainer();
			
			LayoutContainer layoutContainer_14 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_14.setLayout(frmlytSch);
			
			taxmEh11 = new NumberField();
			
			taxmEh11.setAllowDecimals(true); 
			taxmEh11.setPropertyEditorType(Long.class); 
			taxmEh11.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh11.setName("taxmEh11");
			taxmEh11.setFieldLabel("H11-취재수당");
			taxmEh11.setStyleAttribute("marginTop", "5px;");
			layoutContainer_14.add(taxmEh11, new FormData("100%"));

			lcSchCenter1_5.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_14.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_5 = new LayoutContainer();
			
			LayoutContainer layoutContainer_15 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_15.setLayout(frmlytSch);
			
			taxmEh12 = new NumberField();
			
			taxmEh12.setAllowDecimals(true); 
			taxmEh12.setPropertyEditorType(Long.class); 
			taxmEh12.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh12.setName("taxmEh12");
			taxmEh12.setFieldLabel("H12-벽지수당");
			taxmEh12.setStyleAttribute("marginTop", "5px;");
			layoutContainer_15.add(taxmEh12, new FormData("100%"));

			lcSchRight1_5.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_15.setBorders(false);
			
			
			
			lcSchCol1_5.add(lcSchLeft1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_5.setBorders(false);
			lcSchCol1_5.add(lcSchCenter1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_5.setBorders(false);
			lcSchCol1_5.add(lcSchRight1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_5.setBorders(false);
			

			
			
			
			// 비과세 다섯번째 줄
			LayoutContainer lcSchCol1_6 = new LayoutContainer();
			lcSchCol1_6.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_6 = new LayoutContainer();
			
			LayoutContainer layoutContainer_16 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_16.setLayout(frmlytSch);
			
			taxmEh13 = new NumberField();
			
			taxmEh13.setAllowDecimals(true); 
			taxmEh13.setPropertyEditorType(Long.class); 
			taxmEh13.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh13.setName("taxmEh13");
			taxmEh13.setFieldLabel("H13-재해관련급여");
			taxmEh13.setStyleAttribute("marginTop", "5px;");
			layoutContainer_16.add(taxmEh13, new FormData("100%"));

			lcSchLeft1_6.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_16.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_6 = new LayoutContainer();
			
			LayoutContainer layoutContainer_17 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_17.setLayout(frmlytSch);
			
			taxmEh16 = new NumberField();
			
			taxmEh16.setAllowDecimals(true); 
			taxmEh16.setPropertyEditorType(Long.class); 
			taxmEh16.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh16.setName("taxmEh16");
			taxmEh16.setFieldLabel("H16-정부공공 이주수당");
			taxmEh16.setStyleAttribute("marginTop", "5px;");
			layoutContainer_17.add(taxmEh16, new FormData("100%"));

			lcSchCenter1_6.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_17.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_6 = new LayoutContainer();
			
			LayoutContainer layoutContainer_18 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_18.setLayout(frmlytSch);
			
			taxmEi01 = new NumberField();
			
			taxmEi01.setAllowDecimals(true); 
			taxmEi01.setPropertyEditorType(Long.class); 
			taxmEi01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEi01.setName("taxmEi01");
			taxmEi01.setFieldLabel("l01-외국정부 근무자");
			taxmEi01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_18.add(taxmEi01, new FormData("100%"));

			lcSchRight1_6.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_18.setBorders(false);
			
			
			
			lcSchCol1_6.add(lcSchLeft1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_6.setBorders(false);
			lcSchCol1_6.add(lcSchCenter1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_6.setBorders(false);
			lcSchCol1_6.add(lcSchRight1_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_6.setBorders(false);	
			
			
			
			
			
			// 비과세 여섯번째 줄
			LayoutContainer lcSchCol1_7 = new LayoutContainer();
			lcSchCol1_7.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_7 = new LayoutContainer();
			
			LayoutContainer layoutContainer_19 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_19.setLayout(frmlytSch);
			
			taxmEk01 = new NumberField();
			
			taxmEk01.setAllowDecimals(true); 
			taxmEk01.setPropertyEditorType(Long.class); 
			taxmEk01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEk01.setName("taxmEk01");
			taxmEk01.setFieldLabel("K01-외국주둔군인");
			taxmEk01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_19.add(taxmEk01, new FormData("100%"));

			lcSchLeft1_7.add(layoutContainer_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_19.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_7 = new LayoutContainer();
			
			LayoutContainer layoutContainer_20 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_20.setLayout(frmlytSch);
			
			taxmEm01 = new NumberField();
			
			taxmEm01.setAllowDecimals(true); 
			taxmEm01.setPropertyEditorType(Long.class); 
			taxmEm01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEm01.setName("taxmEm01");
			taxmEm01.setFieldLabel("M01-국외근로 100만원");
			taxmEm01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_20.add(taxmEm01, new FormData("100%"));

			lcSchCenter1_7.add(layoutContainer_20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_20.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_7 = new LayoutContainer();
			
			LayoutContainer layoutContainer_21 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_21.setLayout(frmlytSch);
			
			taxmEm02 = new NumberField();
			
			taxmEm02.setAllowDecimals(true); 
			taxmEm02.setPropertyEditorType(Long.class); 
			taxmEm02.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEm02.setName("taxmEm02");
			taxmEm02.setFieldLabel("M02-국외근로 300만원");
			taxmEm02.setStyleAttribute("marginTop", "5px;");
			layoutContainer_21.add(taxmEm02, new FormData("100%"));

			lcSchRight1_7.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_21.setBorders(false);
			
			
			
			lcSchCol1_7.add(lcSchLeft1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_7.setBorders(false);
			lcSchCol1_7.add(lcSchCenter1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_7.setBorders(false);
			lcSchCol1_7.add(lcSchRight1_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_7.setBorders(false);				
			
			
			
			
			

			// 비과세 일곱번째 줄
			LayoutContainer lcSchCol1_8 = new LayoutContainer();
			lcSchCol1_8.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_8 = new LayoutContainer();
			
			LayoutContainer layoutContainer_22 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_22.setLayout(frmlytSch);
			
			taxmEm03 = new NumberField();
			
			taxmEm03.setAllowDecimals(true); 
			taxmEm03.setPropertyEditorType(Long.class); 
			taxmEm03.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEm03.setName("taxmEm03");
			taxmEm03.setFieldLabel("M03-국외근로");
			taxmEm03.setStyleAttribute("marginTop", "5px;");
			layoutContainer_22.add(taxmEm03, new FormData("100%"));

			lcSchLeft1_8.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_22.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_8 = new LayoutContainer();
			
			LayoutContainer layoutContainer_23 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_23.setLayout(frmlytSch);
			
			taxmEo01 = new NumberField();
			
			taxmEo01.setAllowDecimals(true); 
			taxmEo01.setPropertyEditorType(Long.class); 
			taxmEo01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEo01.setName("taxmEo01");
			taxmEo01.setFieldLabel("O01-야간근로수당");
			taxmEo01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_23.add(taxmEo01, new FormData("100%"));

			lcSchCenter1_8.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_23.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_8 = new LayoutContainer();
			
			LayoutContainer layoutContainer_24 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_24.setLayout(frmlytSch);
			
			taxmEq01 = new NumberField();
			
			taxmEq01.setAllowDecimals(true); 
			taxmEq01.setPropertyEditorType(Long.class); 
			taxmEq01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEq01.setName("taxmEq01");
			taxmEq01.setFieldLabel("Q01-출산보육수당");
			taxmEq01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_24.add(taxmEq01, new FormData("100%"));

			lcSchRight1_8.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_24.setBorders(false);
			
			
			
			lcSchCol1_8.add(lcSchLeft1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_8.setBorders(false);
			lcSchCol1_8.add(lcSchCenter1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_8.setBorders(false);
			lcSchCol1_8.add(lcSchRight1_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_8.setBorders(false);	
			
			
			
			
			// 비과세 여덟번째 줄
			LayoutContainer lcSchCol1_9 = new LayoutContainer();
			lcSchCol1_9.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_9 = new LayoutContainer();
			
			LayoutContainer layoutContainer_25 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_25.setLayout(frmlytSch);
			
			taxmEr10 = new NumberField();
			
			taxmEr10.setAllowDecimals(true); 
			taxmEr10.setPropertyEditorType(Long.class); 
			taxmEr10.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEr10.setName("taxmEr10");
			taxmEr10.setFieldLabel("R10-근로장학금");
			taxmEr10.setStyleAttribute("marginTop", "5px;");
			layoutContainer_25.add(taxmEr10, new FormData("100%"));

			lcSchLeft1_9.add(layoutContainer_25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_25.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_9 = new LayoutContainer();
			
			LayoutContainer layoutContainer_26 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_26.setLayout(frmlytSch);
			
			taxmEs01 = new NumberField();
			
			taxmEs01.setAllowDecimals(true); 
			taxmEs01.setPropertyEditorType(Long.class); 
			taxmEs01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEs01.setName("taxmEs01");
			taxmEs01.setFieldLabel("S01-주식매수선택권");
			taxmEs01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_26.add(taxmEs01, new FormData("100%"));

			lcSchCenter1_9.add(layoutContainer_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_26.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_9 = new LayoutContainer();
			
			LayoutContainer layoutContainer_27 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_27.setLayout(frmlytSch);
			
			taxmEy02 = new NumberField();
			
			taxmEy02.setAllowDecimals(true); 
			taxmEy02.setPropertyEditorType(Long.class); 
			taxmEy02.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEy02.setName("taxmEy02");
			taxmEy02.setFieldLabel("Y02-사주조합인출50%");
			taxmEy02.setStyleAttribute("marginTop", "5px;");
			layoutContainer_27.add(taxmEy02, new FormData("100%"));

			lcSchRight1_9.add(layoutContainer_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_27.setBorders(false);
			
			
			
			lcSchCol1_9.add(lcSchLeft1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_9.setBorders(false);
			lcSchCol1_9.add(lcSchCenter1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_9.setBorders(false);
			lcSchCol1_9.add(lcSchRight1_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_9.setBorders(false);
			
			
			
			
			
			// 비과세 아홉번째 줄
			LayoutContainer lcSchCol1_10 = new LayoutContainer();
			lcSchCol1_10.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_10 = new LayoutContainer();
			
			LayoutContainer layoutContainer_28 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_28.setLayout(frmlytSch);
			
			taxmEy03 = new NumberField();
			
			taxmEy03.setAllowDecimals(true); 
			taxmEy03.setPropertyEditorType(Long.class); 
			taxmEy03.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEy03.setName("taxmEy03");
			taxmEy03.setFieldLabel("Y03-사주조합인출70%");
			taxmEy03.setStyleAttribute("marginTop", "5px;");
			layoutContainer_28.add(taxmEy03, new FormData("100%"));

			lcSchLeft1_10.add(layoutContainer_28, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_28.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_10 = new LayoutContainer();
			
			LayoutContainer layoutContainer_29 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_29.setLayout(frmlytSch);
			
			taxmEy21 = new NumberField();
			
			taxmEy21.setAllowDecimals(true); 
			taxmEy21.setPropertyEditorType(Long.class); 
			taxmEy21.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEy21.setName("taxmEy21");
			taxmEy21.setFieldLabel("Y21-장기미취업 중소 취업");
			taxmEy21.setStyleAttribute("marginTop", "5px;");
			layoutContainer_29.add(taxmEy21, new FormData("100%"));

			lcSchCenter1_10.add(layoutContainer_29, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_29.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_10 = new LayoutContainer();
			
			LayoutContainer layoutContainer_30 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_30.setLayout(frmlytSch);
			
			taxmEy22 = new NumberField();
			
			taxmEy22.setAllowDecimals(true); 
			taxmEy22.setPropertyEditorType(Long.class); 
			taxmEy22.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEy22.setName("taxmEy22");
			taxmEy22.setFieldLabel("Y22-전공의 수련 보조수당");
			taxmEy22.setStyleAttribute("fontSize", "10pt");
			taxmEy22.setStyleAttribute("marginTop", "5px;");
			layoutContainer_30.add(taxmEy22, new FormData("100%"));

			lcSchRight1_10.add(layoutContainer_30, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_30.setBorders(false);
			
			
			
			lcSchCol1_10.add(lcSchLeft1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_10.setBorders(false);
			lcSchCol1_10.add(lcSchCenter1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_10.setBorders(false);
			lcSchCol1_10.add(lcSchRight1_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_10.setBorders(false);			
			
			
			
			
			
			// 비과세 열번째 줄
			LayoutContainer lcSchCol1_11 = new LayoutContainer();
			lcSchCol1_11.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_11 = new LayoutContainer();
			
			LayoutContainer layoutContainer_31 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_31.setLayout(frmlytSch);
			
			taxmEa01 = new NumberField();
			
			taxmEa01.setAllowDecimals(true); 
			taxmEa01.setPropertyEditorType(Long.class); 
			taxmEa01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEa01.setName("taxmEa01");
			taxmEa01.setFieldLabel("A01-복무병 급여");
			taxmEa01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_31.add(taxmEa01, new FormData("100%"));

			lcSchLeft1_11.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_31.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_11 = new LayoutContainer();
			
			LayoutContainer layoutContainer_32 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_32.setLayout(frmlytSch);
			
			taxmEb01 = new NumberField();
			
			taxmEb01.setAllowDecimals(true); 
			taxmEb01.setPropertyEditorType(Long.class); 
			taxmEb01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEb01.setName("taxmEb01");
			taxmEb01.setFieldLabel("B01-동원직장 급여");
			taxmEb01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_32.add(taxmEb01, new FormData("100%"));

			lcSchCenter1_11.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_32.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_11 = new LayoutContainer();
			
			LayoutContainer layoutContainer_33 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_33.setLayout(frmlytSch);
			
			taxmEc01 = new NumberField();
			
			taxmEc01.setAllowDecimals(true); 
			taxmEc01.setPropertyEditorType(Long.class); 
			taxmEc01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEc01.setName("taxmEc01");
			taxmEc01.setFieldLabel("C01-요양 급여");
			taxmEc01.setStyleAttribute("fontSize", "10pt");
			taxmEc01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_33.add(taxmEc01, new FormData("100%"));

			lcSchRight1_11.add(layoutContainer_33, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_33.setBorders(false);
			
			
			
			lcSchCol1_11.add(lcSchLeft1_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_11.setBorders(false);
			lcSchCol1_11.add(lcSchCenter1_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_11.setBorders(false);
			lcSchCol1_11.add(lcSchRight1_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_11.setBorders(false);				
			
			
			
	

			// 비과세 열한번째 줄
			LayoutContainer lcSchCol1_12 = new LayoutContainer();
			lcSchCol1_12.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_12 = new LayoutContainer();
			
			LayoutContainer layoutContainer_34 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_34.setLayout(frmlytSch);
			
			taxmEd01 = new NumberField();
			
			taxmEd01.setAllowDecimals(true); 
			taxmEd01.setPropertyEditorType(Long.class); 
			taxmEd01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEd01.setName("taxmEd01");
			taxmEd01.setFieldLabel("D01-요양 보상금");
			taxmEd01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_34.add(taxmEd01, new FormData("100%"));

			lcSchLeft1_12.add(layoutContainer_34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_34.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_12 = new LayoutContainer();
			
			LayoutContainer layoutContainer_35 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_35.setLayout(frmlytSch);
			
			taxmEe01 = new NumberField();
			
			taxmEe01.setAllowDecimals(true); 
			taxmEe01.setPropertyEditorType(Long.class); 
			taxmEd01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEe01.setName("taxmEe01");
			taxmEe01.setFieldLabel("E01-육아휴직급여");
			taxmEe01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_35.add(taxmEe01, new FormData("100%"));

			lcSchCenter1_12.add(layoutContainer_35, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_35.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_12 = new LayoutContainer();
			
			LayoutContainer layoutContainer_36 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_36.setLayout(frmlytSch);
			
			taxmEe02 = new NumberField();
			
			taxmEe02.setAllowDecimals(true); 
			taxmEe02.setPropertyEditorType(Long.class); 
			taxmEe02.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEe02.setName("taxmEe02");
			taxmEe02.setFieldLabel("E02-육아휴직수당");
			taxmEe02.setStyleAttribute("fontSize", "10pt");
			taxmEe02.setStyleAttribute("marginTop", "5px;");
			layoutContainer_36.add(taxmEe02, new FormData("100%"));

			lcSchRight1_12.add(layoutContainer_36, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_36.setBorders(false);
			
			
			
			lcSchCol1_12.add(lcSchLeft1_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_12.setBorders(false);
			lcSchCol1_12.add(lcSchCenter1_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_12.setBorders(false);
			lcSchCol1_12.add(lcSchRight1_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_12.setBorders(false);				

			

			
			// 비과세 열두번째 줄
			LayoutContainer lcSchCol1_13 = new LayoutContainer();
			lcSchCol1_13.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_13 = new LayoutContainer();
			
			LayoutContainer layoutContainer_37 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_37.setLayout(frmlytSch);
			
			taxmEe10 = new NumberField();
			
			taxmEe10.setAllowDecimals(true); 
			taxmEe10.setPropertyEditorType(Long.class); 
			taxmEe10.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEe10.setName("taxmEe10");
			taxmEe10.setFieldLabel("E10-사망일시금");
			taxmEe10.setStyleAttribute("marginTop", "5px;");
			layoutContainer_37.add(taxmEe10, new FormData("100%"));

			lcSchLeft1_13.add(layoutContainer_37, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_37.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_13 = new LayoutContainer();
			
			LayoutContainer layoutContainer_38 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_38.setLayout(frmlytSch);
			
			taxmEf01 = new NumberField();
			
			taxmEf01.setAllowDecimals(true); 
			taxmEf01.setPropertyEditorType(Long.class); 
			taxmEf01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEf01.setName("taxmEf01");
			taxmEf01.setFieldLabel("F01-요양비");
			taxmEf01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_38.add(taxmEf01, new FormData("100%"));

			lcSchCenter1_13.add(layoutContainer_38, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_38.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_13 = new LayoutContainer();
			
			LayoutContainer layoutContainer_39 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_39.setLayout(frmlytSch);
			
			taxmEh02 = new NumberField();
			
			taxmEh02.setAllowDecimals(true); 
			taxmEh02.setPropertyEditorType(Long.class); 
			taxmEh02.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh02.setName("taxmEh02");
			taxmEh02.setFieldLabel("H02-일직·숙직료");
			taxmEh02.setStyleAttribute("fontSize", "10pt");
			taxmEh02.setStyleAttribute("marginTop", "5px;");
			layoutContainer_39.add(taxmEh02, new FormData("100%"));

			lcSchRight1_13.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_39.setBorders(false);
			
			
			
			lcSchCol1_13.add(lcSchLeft1_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_13.setBorders(false);
			lcSchCol1_13.add(lcSchCenter1_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_13.setBorders(false);
			lcSchCol1_13.add(lcSchRight1_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_13.setBorders(false);				
			
			
	
			
			// 비과세 열세번째 줄
			LayoutContainer lcSchCol1_14 = new LayoutContainer();
			lcSchCol1_14.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_14 = new LayoutContainer();
			
			LayoutContainer layoutContainer_40 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_40.setLayout(frmlytSch);
			
			taxmEh03 = new NumberField();
			
			taxmEh03.setAllowDecimals(true); 
			taxmEh03.setPropertyEditorType(Long.class); 
			taxmEh03.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh03.setName("taxmEh03");
			taxmEh03.setFieldLabel("H03-자가운전보조금");
			taxmEh03.setStyleAttribute("marginTop", "5px;");
			layoutContainer_40.add(taxmEh03, new FormData("100%"));

			lcSchLeft1_14.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_40.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_14 = new LayoutContainer();
			
			LayoutContainer layoutContainer_41 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_41.setLayout(frmlytSch);
			
			taxmEh04 = new NumberField();
			
			taxmEh04.setAllowDecimals(true); 
			taxmEh04.setPropertyEditorType(Long.class); 
			taxmEh04.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEh04.setName("taxmEh04");
			taxmEh04.setFieldLabel("H04-착용제복금");
			taxmEh04.setStyleAttribute("marginTop", "5px;");
			layoutContainer_41.add(taxmEh04, new FormData("100%"));

			lcSchCenter1_14.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_41.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_14 = new LayoutContainer();
			
			LayoutContainer layoutContainer_42 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_42.setLayout(frmlytSch);
			
			taxmEj01 = new NumberField();
			
			taxmEj01.setAllowDecimals(true); 
			taxmEj01.setPropertyEditorType(Long.class); 
			taxmEj01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEj01.setName("taxmEj01");
			taxmEj01.setFieldLabel("J01-보훈·학습보조비");
			taxmEj01.setStyleAttribute("fontSize", "10pt");
			taxmEj01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_42.add(taxmEj01, new FormData("100%"));

			lcSchRight1_14.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_42.setBorders(false);
			
			
			
			lcSchCol1_14.add(lcSchLeft1_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_14.setBorders(false);
			lcSchCol1_14.add(lcSchCenter1_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_14.setBorders(false);
			lcSchCol1_14.add(lcSchRight1_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_14.setBorders(false);					
			
			
			
			

			// 비과세 열네번째 줄
			LayoutContainer lcSchCol1_15 = new LayoutContainer();
			lcSchCol1_15.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_15 = new LayoutContainer();
			
			LayoutContainer layoutContainer_43 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_43.setLayout(frmlytSch);
			
			taxmEj10 = new NumberField();
			
			taxmEj10.setAllowDecimals(true); 
			taxmEj10.setPropertyEditorType(Long.class); 
			taxmEj10.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEj10.setName("taxmEj10");
			taxmEj10.setFieldLabel("J10-전직대통령 연금");
			taxmEj10.setStyleAttribute("marginTop", "5px;");
			layoutContainer_43.add(taxmEj10, new FormData("100%"));

			lcSchLeft1_15.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_43.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_15 = new LayoutContainer();
			
			LayoutContainer layoutContainer_44 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_44.setLayout(frmlytSch);
			
			taxmEl01 = new NumberField();
			
			taxmEl01.setAllowDecimals(true); 
			taxmEl01.setPropertyEditorType(Long.class); 
			taxmEl01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEl01.setName("taxmEl01");
			taxmEl01.setFieldLabel("L01-군인전사 과세급여");
			taxmEl01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_44.add(taxmEl01, new FormData("100%"));

			lcSchCenter1_15.add(layoutContainer_44, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_44.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_15 = new LayoutContainer();
			
			LayoutContainer layoutContainer_45 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_45.setLayout(frmlytSch);
			
			taxmEn01 = new NumberField();
			
			taxmEn01.setAllowDecimals(true); 
			taxmEn01.setPropertyEditorType(Long.class); 
			taxmEn01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEn01.setName("taxmEn01");
			taxmEn01.setFieldLabel("N01-국민건강보험 보험료");
			taxmEn01.setStyleAttribute("fontSize", "10pt");
			taxmEn01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_45.add(taxmEn01, new FormData("100%"));

			lcSchRight1_15.add(layoutContainer_45, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_45.setBorders(false);
			
			
			
			lcSchCol1_15.add(lcSchLeft1_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_15.setBorders(false);
			lcSchCol1_15.add(lcSchCenter1_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_15.setBorders(false);
			lcSchCol1_15.add(lcSchRight1_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_15.setBorders(false);	
			
			
			
			// 비과세 열다번째 줄
			LayoutContainer lcSchCol1_16 = new LayoutContainer();
			lcSchCol1_16.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft1_16 = new LayoutContainer();
			
			LayoutContainer layoutContainer_46 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_46.setLayout(frmlytSch);
			
			taxmEp01 = new NumberField();
			
			taxmEp01.setAllowDecimals(true); 
			taxmEp01.setPropertyEditorType(Long.class); 
			taxmEp01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEp01.setName("taxmEp01");
			taxmEp01.setFieldLabel("P01-비과세 식대");
			taxmEp01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_46.add(taxmEp01, new FormData("100%"));

			lcSchLeft1_16.add(layoutContainer_46, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_46.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter1_16 = new LayoutContainer();
			
			LayoutContainer layoutContainer_47 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_47.setLayout(frmlytSch);
			
			taxmEp02 = new NumberField();
			
			taxmEp02.setAllowDecimals(true); 
			taxmEp02.setPropertyEditorType(Long.class); 
			taxmEp02.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEp02.setName("taxmEp02");
			taxmEp02.setFieldLabel("P02-현물 급식");
			taxmEp02.setStyleAttribute("marginTop", "5px;");
			layoutContainer_47.add(taxmEp02, new FormData("100%"));

			lcSchCenter1_16.add(layoutContainer_47, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_47.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight1_16 = new LayoutContainer();
			
			LayoutContainer layoutContainer_48 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_48.setLayout(frmlytSch);
			
			taxmEr01 = new NumberField();
			
			taxmEr01.setAllowDecimals(true); 
			taxmEr01.setPropertyEditorType(Long.class); 
			taxmEr01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEr01.setName("taxmEr01");
			taxmEr01.setFieldLabel("R01-국군포로 보수");
			taxmEr01.setStyleAttribute("fontSize", "10pt");
			taxmEr01.setStyleAttribute("marginTop", "5px;");
			layoutContainer_48.add(taxmEr01, new FormData("100%"));

			lcSchRight1_16.add(layoutContainer_48, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_48.setBorders(false);
			
			
			
			lcSchCol1_16.add(lcSchLeft1_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft1_16.setBorders(false);
			lcSchCol1_16.add(lcSchCenter1_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter1_16.setBorders(false);
			lcSchCol1_16.add(lcSchRight1_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight1_16.setBorders(false);			
			

			// 비과세 열여번째 줄
			LayoutContainer lcSchCol5_16 = new LayoutContainer();
			lcSchCol5_16.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft11_16 = new LayoutContainer();
			
			LayoutContainer layoutContainer1_46 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer1_46.setLayout(frmlytSch);
			
			taxmEy04 = new NumberField();
			
			taxmEy04.setAllowDecimals(true); 
			taxmEy04.setPropertyEditorType(Long.class); 
			taxmEy04.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEy04.setName("taxmEy04");
			taxmEy04.setFieldLabel("Y04-사주조합인출100%");
			taxmEy04.setStyleAttribute("marginTop", "5px;");
			layoutContainer1_46.add(taxmEy04, new FormData("100%"));

			lcSchLeft11_16.add(layoutContainer1_46, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer1_46.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter3_16 = new LayoutContainer();
			
			LayoutContainer layoutContainer1_47 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer1_47.setLayout(frmlytSch);
			
		 

			lcSchCenter3_16.add(layoutContainer1_47, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer1_47.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight4_16 = new LayoutContainer();
			
			LayoutContainer layoutContainer1_48 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer1_48.setLayout(frmlytSch);
		 
			lcSchRight4_16.add(layoutContainer1_48, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer1_48.setBorders(false);
			
			
			
			lcSchCol5_16.add(lcSchLeft11_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft11_16.setBorders(false);
			lcSchCol5_16.add(lcSchCenter3_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter3_16.setBorders(false);
			lcSchCol5_16.add(lcSchRight4_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight4_16.setBorders(false);			
			
			
			
			
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
			cpYeta13008.add(fieldSet);
			
			
			
		
			
			
			FieldSet fieldSet2 = new FieldSet();
			fieldSet2.setHeadingHtml("감면");
//			fieldSet2.setHeight(50);
			fieldSet2.setStyleAttribute("marginTop", "5px;");
			
			// 감면 첫번째 줄
			LayoutContainer lcSchCol2_1 = new LayoutContainer();
			lcSchCol2_1.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft2_1 = new LayoutContainer();
			
			LayoutContainer layoutContainer_80 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_80.setLayout(frmlytSch);
			
			taxmEt01 = new NumberField();
			
			taxmEt01.setAllowDecimals(true); 
			taxmEt01.setPropertyEditorType(Long.class); 
			taxmEt01.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEt01.setName("taxmEt01");
			taxmEt01.setFieldLabel("T01-외국인기술자");
			layoutContainer_80.add(taxmEt01, new FormData("100%"));

			lcSchLeft2_1.add(layoutContainer_80, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_80.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter2_1 = new LayoutContainer();
			
			LayoutContainer layoutContainer_81 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_81.setLayout(frmlytSch);
			
			taxmEt10 = new NumberField();
			
			taxmEt10.setAllowDecimals(true); 
			taxmEt10.setPropertyEditorType(Long.class); 
			taxmEt10.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEt10.setName("taxmEt10");
			taxmEt10.setFieldLabel("T10-중소 청년 소득세 감면");
			layoutContainer_81.add(taxmEt10, new FormData("100%"));

			lcSchCenter2_1.add(layoutContainer_81, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_81.setBorders(false);
			
			
			
			
			
			LayoutContainer lcSchRight2_1 = new LayoutContainer();
			
			LayoutContainer layoutContainer_82 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_82.setLayout(frmlytSch);
			
			taxmEt20 = new NumberField();
			
			taxmEt20.setAllowDecimals(true); 
			taxmEt20.setPropertyEditorType(Long.class); 
			taxmEt20.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEt20.setName("taxmEt20");
			taxmEt20.setFieldLabel("T20-조세조약 교직자 감면");
			taxmEt20.setStyleAttribute("fontSize", "10pt");
			layoutContainer_82.add(taxmEt20, new FormData("100%"));

			lcSchRight2_1.add(layoutContainer_82, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_82.setBorders(false);
			
			
			
			lcSchCol2_1.add(lcSchLeft2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft2_1.setBorders(false);
			lcSchCol2_1.add(lcSchCenter2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter2_1.setBorders(false);
			lcSchCol2_1.add(lcSchRight2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight2_1.setBorders(false);		
			
				fieldSet2.add(lcSchCol2_1);
			
			// 감면 두번째 줄
			LayoutContainer lcSchCol21_1 = new LayoutContainer();
			lcSchCol21_1.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft21_1 = new LayoutContainer();
			
			LayoutContainer layoutContainer11_80 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer11_80.setLayout(frmlytSch);
			
			taxmEt11 = new NumberField();
			
			taxmEt11.setAllowDecimals(true); 
			taxmEt11.setPropertyEditorType(Long.class); 
			taxmEt11.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEt11.setName("taxmEt11");
			taxmEt11.setFieldLabel("T11-중소청년소득세50%");
			layoutContainer11_80.add(taxmEt11, new FormData("100%"));

			lcSchLeft21_1.add(layoutContainer11_80, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer11_80.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter22_1 = new LayoutContainer();
			
			LayoutContainer layoutContainer11_81 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer11_81.setLayout(frmlytSch);
			
			taxmEt12 = new NumberField();
			
			taxmEt12.setAllowDecimals(true); 
			taxmEt12.setPropertyEditorType(Long.class); 
			taxmEt12.setFormat(NumberFormat.getDecimalFormat());
			
			taxmEt12.setName("taxmEt12");
			taxmEt12.setFieldLabel("T12-중소청년소득세70%");
			layoutContainer11_81.add(taxmEt10, new FormData("100%"));

			lcSchCenter22_1.add(layoutContainer11_81, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer11_81.setBorders(false);
			
			 
			
			LayoutContainer lcSchRight23_1 = new LayoutContainer();
			
			LayoutContainer layoutContainer11_82 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer11_82.setLayout(frmlytSch);
			 
			lcSchRight23_1.add(layoutContainer11_82, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer11_82.setBorders(false);
			
			
			
			lcSchCol21_1.add(lcSchLeft21_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchLeft21_1.setBorders(false);
			lcSchCol21_1.add(lcSchCenter22_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchCenter22_1.setBorders(false);
			lcSchCol21_1.add(lcSchRight23_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			lcSchRight23_1.setBorders(false);		
			
			
			
			
			fieldSet2.add(lcSchCol21_1);
			
			cpYeta13008.add(fieldSet2);
			
			
			
			
			
			
			
			LayoutContainer lcSchCol2 = new LayoutContainer();
			lcSchCol2.setLayout(new ColumnLayout());
			
			LayoutContainer lcSchLeft2 = new LayoutContainer();		
			lcSchLeft2.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_83 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(150);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_83.setLayout(frmlytSch);
			
			taxeTotl = new NumberField();
			
			taxeTotl.setAllowDecimals(true); 
			taxeTotl.setPropertyEditorType(Long.class); 
			taxeTotl.setFormat(NumberFormat.getDecimalFormat());
			
			taxeTotl.setName("taxeTotl");
			taxeTotl.setFieldLabel("비과세 합계");
			taxeTotl.setStyleAttribute("marginTop", "10px;");
			layoutContainer_83.add(taxeTotl, new FormData("100%"));

			lcSchLeft2.add(layoutContainer_83, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_83.setBorders(false);
			
			
			
			
			LayoutContainer lcSchCenter2 = new LayoutContainer();		
			lcSchCenter2.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_84 = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(200);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_84.setLayout(frmlytSch);
			
			taxmTotl = new NumberField();
			
			taxmTotl.setAllowDecimals(true); 
			taxmTotl.setPropertyEditorType(Long.class); 
			taxmTotl.setFormat(NumberFormat.getDecimalFormat());
			
			taxmTotl.setName("taxmTotl");
			taxmTotl.setFieldLabel("감면 합계");
			taxmTotl.setStyleAttribute("marginTop", "10px;");
			layoutContainer_84.add(taxmTotl, new FormData("100%"));

			lcSchCenter2.add(layoutContainer_84, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_84.setBorders(false);
			
			lcSchCol2.add(lcSchLeft2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
			lcSchLeft2.setBorders(false);
			lcSchCol2.add(lcSchCenter2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
			lcSchCenter2.setBorders(false);
			
			lcSchCol2.setBorders(false);
			lcSchCol2.setStyleAttribute("marginTop", "5px;");			
			cpYeta13008.add(lcSchCol2);
		}

		// 버튼 저장액션
		private void doAction(ActionDatabase actionDatabase) {
			
			yetaP13008FormSave();
//			actionDatabase = ActionDatabase.UPDATE;
			
		}
		
		private void yetaP13008FormSave() {  
//			if (MSFSharedUtils.paramNotNull(records)) { 
	              
				List<Ye16Ta3200DTO> listYeta3200dto = new ArrayList<Ye16Ta3200DTO>();  
	                
//				while (records.hasNext()) {
	              
//					Record record = (Record) records.next(); 
//	                BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
	                Ye16Ta3200DTO yeta3200Dto= new Ye16Ta3200DTO();
	                
	                yeta3200Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));			/** 사업장코드 : dpobCd */
	                yeta3200Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));   	/** SYSTEMKEY : systemkey */
	                yeta3200Dto.setEdacRvyy(MSFSharedUtils.allowNulls(edacRvyy.getValue()));    	/** column 연말정산귀속년도 : edacRvyy */
	                yeta3200Dto.setSettGbcd(MSFSharedUtils.allowNulls(settGbcd.getValue()));    	/** column 정산구분코드 : settGbcd */
//	                yeta3200Dto.setElctYymm(MSFSharedUtils.allowNulls(elctYymm.));    	/** column 지급년월 : elctYymm */
	                yeta3200Dto.setSiteNumb(MSFSharedUtils.allowNulls(srhSiteNumb.getValue())); 	/** column 사업자등록번호 : siteNumb */
	                      
	                
	                yeta3200Dto.setTaxmEa01((Long) taxmEa01.getValue());		/** column 비과세소득_A01 : taxmEa01 */
	                yeta3200Dto.setTaxmEb01((Long) taxmEb01.getValue());		/** column 비과세소득_B01 : taxmEb01 */
	                yeta3200Dto.setTaxmEc01((Long) taxmEc01.getValue());		/** column 비과세소득_C01 : taxmEc01 */
	                yeta3200Dto.setTaxmEd01((Long) taxmEd01.getValue());		/** column 비과세소득_D01 : taxmEd01 */
	                yeta3200Dto.setTaxmEe01((Long) taxmEe01.getValue());		/** column 비과세소득_E01 : taxmEe01 */
	                yeta3200Dto.setTaxmEe02((Long) taxmEe02.getValue());		/** column 비과세소득_E02 : taxmEe02 */
	                yeta3200Dto.setTaxmEe10((Long) taxmEe10.getValue());		/** column 비과세소득_E10 : taxmEe10 */
	                yeta3200Dto.setTaxmEf01((Long) taxmEf01.getValue());		/** column 비과세소득_F01 : taxmEf01 */
	                yeta3200Dto.setTaxmEg01((Long) taxmEg01.getValue());		/** column 비과세소득_G01 : taxmEg01 */
	                yeta3200Dto.setTaxmEh01((Long) taxmEh01.getValue());		/** column 비과세소득_H01 : taxmEh01 */	                
	                yeta3200Dto.setTaxmEh02((Long) taxmEh02.getValue());		/** column 비과세소득_H02 : taxmEh02 */	                
	                yeta3200Dto.setTaxmEh03((Long) taxmEh03.getValue());		/** column 비과세소득_H03 : taxmEh03 */	                
	                yeta3200Dto.setTaxmEh04((Long) taxmEh04.getValue());		/** column 비과세소득_H04 : taxmEh04 */	                
	                yeta3200Dto.setTaxmEh05((Long) taxmEh05.getValue());		/** column 비과세소득_H05 : taxmEh05 */	                
	                yeta3200Dto.setTaxmEh06((Long) taxmEh06.getValue());		/** column 비과세소득_H06 : taxmEh06 */	                
	                yeta3200Dto.setTaxmEh07((Long) taxmEh07.getValue());		/** column 비과세소득_H07 : taxmEh07 */	                
	                yeta3200Dto.setTaxmEh08((Long) taxmEh08.getValue());		/** column 비과세소득_H08 : taxmEh08 */	                
	                yeta3200Dto.setTaxmEh09((Long) taxmEh09.getValue());		/** column 비과세소득_H09 : taxmEh09 */
	                yeta3200Dto.setTaxmEh10((Long) taxmEh10.getValue());		/** column 비과세소득_H10 : taxmEh10 */	                
	                yeta3200Dto.setTaxmEh14((Long) taxmEh14.getValue());		/** column 비과세소득_H14 : taxmEh14 */	                
	                yeta3200Dto.setTaxmEh15((Long) taxmEh15.getValue());		/** column 비과세소득_H15 : taxmEh15 */	                
	                yeta3200Dto.setTaxmEh11((Long) taxmEh11.getValue());		/** column 비과세소득_H11 : taxmEh11 */	                
	                yeta3200Dto.setTaxmEh12((Long) taxmEh12.getValue());		/** column 비과세소득_H12 : taxmEh12 */	                
	                yeta3200Dto.setTaxmEh13((Long) taxmEh13.getValue());		/** column 비과세소득_H10 : taxmEh13 */	                
	                yeta3200Dto.setTaxmEh16((Long) taxmEh16.getValue());		/** column 비과세소득_H16 : taxmEh16 */
	                yeta3200Dto.setTaxmEi01((Long) taxmEi01.getValue());		/** column 비과세소득_I01 : taxmEi01 */
	                yeta3200Dto.setTaxmEj01((Long) taxmEj01.getValue());		/** column 비과세소득_J01 : taxmEj01 */
	                yeta3200Dto.setTaxmEj10((Long) taxmEj10.getValue());		/** column 비과세소득_J10 : taxmEj10 */
	                yeta3200Dto.setTaxmEk01((Long) taxmEk01.getValue());		/** column 비과세소득_K01 : taxmEk01 */
	                yeta3200Dto.setTaxmEl01((Long) taxmEl01.getValue());		/** column 비과세소득_L01 : taxmEl01 */
	                yeta3200Dto.setTaxmEm01((Long) taxmEm01.getValue());		/** column 비과세소득_M01 : taxmEm01 */
	                yeta3200Dto.setTaxmEm02((Long) taxmEm02.getValue());		/** column 비과세소득_M02 : taxmEm02 */
	                yeta3200Dto.setTaxmEm03((Long) taxmEm03.getValue());		/** column 비과세소득_M03 : taxmEm03 */
	                yeta3200Dto.setTaxmEn01((Long) taxmEn01.getValue());		/** column 비과세소득_N01 : taxmEn01 */
	                yeta3200Dto.setTaxmEo01((Long) taxmEo01.getValue());		/** column 비과세소득_O01 : taxmEo01 */
	                yeta3200Dto.setTaxmEp01((Long) taxmEp01.getValue());		/** column 비과세소득_P01 : taxmEp01 */
	                yeta3200Dto.setTaxmEp02((Long) taxmEp02.getValue());		/** column 비과세소득_P02 : taxmEp02 */
	                yeta3200Dto.setTaxmEq01((Long) taxmEq01.getValue());		/** column 비과세소득_Q01 : taxmEq01 */
	                yeta3200Dto.setTaxmEr01((Long) taxmEr01.getValue());		/** column 비과세소득_R01 : taxmEr01 */
	                yeta3200Dto.setTaxmEr10((Long) taxmEr10.getValue());		/** column 비과세소득_R10 : taxmEr10 */
	                yeta3200Dto.setTaxmEs01((Long) taxmEs01.getValue());		/** column 비과세소득_S01 : taxmEs01 */
	                yeta3200Dto.setTaxmEy02((Long) taxmEy02.getValue());		/** column 비과세소득_Y02 : taxmEy02 */
	                yeta3200Dto.setTaxmEy03((Long) taxmEy03.getValue());		/** column 비과세소득_Y03 : taxmEy03 */
	                yeta3200Dto.setTaxmEy04((Long) taxmEy04.getValue());		/** column 비과세소득_Y04 : taxmEy04 */
	                yeta3200Dto.setTaxmEy21((Long) taxmEy21.getValue());		/** column 비과세소득_Y21 : taxmEy21 */
	                yeta3200Dto.setTaxmEy22((Long) taxmEy22.getValue());		/** column 비과세소득_Y22 : taxmEy22 */
	                
	                yeta3200Dto.setTaxmEt01((Long) taxmEt01.getValue());		/** column 감면소득_T01 : taxmEt01 */
	                yeta3200Dto.setTaxmEt10((Long) taxmEt10.getValue());		/** column 감면소득_T10 : taxmEt10 */
	                yeta3200Dto.setTaxmEt11((Long) taxmEt11.getValue());		/** column 감면소득_T11 : taxmEt11 */
	                yeta3200Dto.setTaxmEt12((Long) taxmEt12.getValue());		/** column 감면소득_T12 : taxmEt12 */
	                yeta3200Dto.setTaxmEt20((Long) taxmEt20.getValue());		/** column 감면소득_T20 : taxmEt20 */

	                listYeta3200dto.add(yeta3200Dto);
//				}  
	                
				if (listYeta3200dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
	                
				yetaP13008Service.activityOnYetaP13008ToYeta3200(listYeta3200dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP13008ToYeta3200(" + actionDatabase.name() + ") : " + caught), null);
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
	              
//			} else {
//				MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//				return;
//			}
	}
		
		
	@Override
	public void reload() {
		
		yeta3200Dto = new Ye16Ta3200DTO();
		
		yeta3200Dto.setDpobCd(dpobCd.getValue());		/**  column 사업장코드 : dpobCd */
		yeta3200Dto.setSystemkey(systemkey.getValue()); /**  column SYSTEMKEY : systemkey */
		yeta3200Dto.setSettGbcd(settGbcd.getValue());	/** column 정산구분코드 : settGbcd */
		yeta3200Dto.setEdacRvyy(edacRvyy.getValue());	/** column 연말정산귀속년도 : edacRvyy */
		yeta3200Dto.setSiteNumb(siteNumb.getValue());	/** column 사업자등록번호 : siteNumb */
		
		yetaP13008Service.getYetaP13008To3200List(yeta3200Dto, new AsyncCallback<Ye16Ta3200DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYetaP13008To3200List(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye16Ta3200DTO result) {
				// TODO Auto-generated method stub
				readYetaP13008Data(result);
			}
		});
	}	
	
	//비과세 및 감면소득 조회부
	public void readYetaP13008Data(Ye16Ta3200DTO result) {
		
		srhHanNm.setValue(MSFSharedUtils.allowNulls(result.getHanNm())); // 성명
		srhSiteNumb.setValue(MSFSharedUtils.defaultNulls(result.getSiteNumb(), "0000000000")); // 사업자등록번호

		if("0000000000".equals(srhSiteNumb.getValue())) {
			actionDatabase = ActionDatabase.INSERT;
		}else {
			actionDatabase = ActionDatabase.UPDATE;
		}
		
		srhSiteCtnt.setValue(MSFSharedUtils.allowNulls(result.getSiteCtnt())); // 근무지명

		/** 비과세부분 */
		taxmEg01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEg01(), "0")))); // ⑱-5 G01-비과세 학자금
		taxmEh01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh01(), "0")))); // ⑱-9 H01-무보수위원수당
		taxmEh05.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh05(), "0")))); // ⑱-18 H05-경호·승선수당
		taxmEh06.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh06(), "0")))); // ⑱-4 H06-유아·초중등
		taxmEh07.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh07(), "0")))); // ⑱-4 H07-고등교육법
		taxmEh08.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh08(), "0")))); // ⑱-4 H08-특별법
		taxmEh09.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh09(), "0")))); // ⑱-4 H09-연구기관
		taxmEh10.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh10(), "0")))); // ⑱-4 H10-기업부설연구소
		taxmEh14.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh14(), "0")))); // ⑱-22 H14-보육교사
		taxmEh15.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh15(), "0")))); // ⑱-23 H15-사립유치원수석교사
		taxmEh11.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh11(), "0")))); // ⑱-6 H11-취재수당
		taxmEh12.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh12(), "0")))); // ⑱-7 H12-벽지수당
		taxmEh13.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh13(), "0")))); // ⑱-8 H13-재해관련급여
		taxmEh16.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh16(), "0")))); // ⑱-26 H16-정부공공기관 지방이전기관 종사자이주수당
		taxmEi01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEi01(), "0")))); // ⑱-19 l01-외국정부 근무자
		taxmEk01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEk01(), "0")))); // ⑱-10 K01-외국주둔군인
		taxmEm01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEm01(), "0")))); // ⑱ M01-국외근로 100만원
		taxmEm02.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEm02(), "0")))); // ⑱ M02-국외근로 300만원
		taxmEm03.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEm03(), "0")))); // ⑱ M03-국외근로
		taxmEo01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEo01(), "0")))); // ⑱-1 O01-야간근로수당
		taxmEq01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEq01(), "0")))); // ⑱-2 Q01-출산보육수당
		taxmEr10.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEr10(), "0")))); // ⑱-21 R10-근로장학금
		taxmEs01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEs01(), "0")))); // ⑱-11 S01-주식매수선택권
		taxmEy02.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEy02(), "0")))); // ⑱-14 Y02-우리사주조합인출금50%
		taxmEy03.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEy03(), "0")))); // ⑱-15 Y03-우리사주조합인출금70%
		taxmEy04.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEy04(), "0")))); // ⑱-15 Y04-우리사주조합인출금100%
		taxmEy21.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEy21(), "0")))); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmEy22.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEy22(), "0")))); // ⑲ Y22-전공의 수련 보조수당

		/** 감면소득 부분 */
		taxmEt01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEt01(), "0")))); // ⑱-12 T01-외국인기술자
		taxmEt10.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEt10(), "0")))); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmEt11.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEt11(), "0"))));	/** set 감면소득_T11 : taxmSt11 */  
		taxmEt12.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEt12(), "0"))));/** set 감면소득_T12 : taxmSt12 */
	 
		taxmEt20.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEt20(), "0")))); // ⑱-25 T20-조세조약상 교직자 감면

		/** 코드만 있고 기재란 없는 부분 */
		taxmEa01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEa01(), "0")))); // A01-복무병 급여
		taxmEb01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEb01(), "0")))); // B01-동원직장 급여
		taxmEc01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEc01(), "0")))); // C01-요양 급여
		taxmEd01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEd01(), "0")))); // D01-요양 보상금
		taxmEe01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEe01(), "0")))); // E01-육아휴직급여
		taxmEe02.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEe02(), "0")))); // E02-육아휴직수당
		taxmEe10.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEe10(), "0")))); // E10-사망일시금
		taxmEf01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEf01(), "0")))); // F01-요양비

		taxmEh02.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh02(), "0")))); // H02-일직·숙직료
		taxmEh03.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh03(), "0")))); // H03-자가운전보조금
		taxmEh04.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEh04(), "0")))); // H04-착용제복금

		taxmEj01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEj01(), "0")))); // J01-보훈·학습보조비
		taxmEj10.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEj10(), "0")))); // J10-전직대통령 연금
		taxmEl01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEl01(), "0")))); // L01-중군군인전사 과세급여
		taxmEn01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEn01(), "0")))); // N01-국민건강보험 보험료
		taxmEp01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEp01(), "0")))); // P01-비과세 식대
		taxmEp02.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEp02(), "0")))); // P02-현물 급식
		taxmEr01.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmEr01(), "0")))); // R01-국군포로 보수

		/** 총계 부분 */
		taxeTotl.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxeTotl(), "0")))); // ⑳ 비과세 계
		taxmTotl.setValue((MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxmTotl(), "0")))); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단
	}
	
	
		
	public void setReadOnlyTrueYetaP13008() {
		
		srhHanNm.setReadOnly(true); 	// 성명
		srhSiteNumb.setReadOnly(true); 	// 사업자등록번호
		srhSiteCtnt.setReadOnly(true);	// 근무지명
			
		taxmEg01.setReadOnly(true); // ⑱-5 G01-비과세 학자금
		taxmEh01.setReadOnly(true); // ⑱-9 H01-무보수위원수당
		taxmEh05.setReadOnly(true); // ⑱-18 H05-경호·승선수당
		taxmEh06.setReadOnly(true); // ⑱-4 H06-유아·초중등
		taxmEh07.setReadOnly(true); // ⑱-4 H07-고등교육법
		taxmEh08.setReadOnly(true); // ⑱-4 H08-특별법
		taxmEh09.setReadOnly(true); // ⑱-4 H09-연구기관
		taxmEh10.setReadOnly(true); // ⑱-4 H10-기업부설연구소
		taxmEh14.setReadOnly(true); // ⑱-22 H14-보육교사
		taxmEh15.setReadOnly(true); // ⑱-23 H15-사립유치원수석교사
		taxmEh11.setReadOnly(true); // ⑱-6 H11-취재수당
		taxmEh12.setReadOnly(true); // ⑱-7 H12-벽지수당
		taxmEh13.setReadOnly(true); // ⑱-8 H13-재해관련급여
		taxmEh16.setReadOnly(true); // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
		taxmEi01.setReadOnly(true); // ⑱-19 l01-외국정부 근무자
		taxmEk01.setReadOnly(true); // ⑱-10 K01-외국주둔군인
		taxmEm01.setReadOnly(true); // ⑱ M01-국외근로 100만원
		taxmEm02.setReadOnly(true); // ⑱ M02-국외근로 300만원
		taxmEm03.setReadOnly(true); // ⑱ M03-국외근로
		taxmEo01.setReadOnly(true); // ⑱-1 O01-야간근로수당
		taxmEq01.setReadOnly(true); // ⑱-2 Q01-출산보육수당
		taxmEr10.setReadOnly(true); // ⑱-21 R10-근로장학금
		taxmEs01.setReadOnly(true); // ⑱-11 S01-주식매수선택권
		taxmEy02.setReadOnly(true); // ⑱-14 Y02-우리사주조합인출금50%
		taxmEy03.setReadOnly(true); // ⑱-15 Y03-우리사주조합인출금70%
		taxmEy21.setReadOnly(true); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmEy22.setReadOnly(true); // ⑲ Y22-전공의 수련 보조수당

		taxmEa01.setReadOnly(true); // A01-복무병 급여
		taxmEb01.setReadOnly(true); // B01-동원직장 급여
		taxmEc01.setReadOnly(true); // C01-요양 급여
		taxmEd01.setReadOnly(true); // D01-요양 보상금
		taxmEe01.setReadOnly(true); // E01-육아휴직급여
		taxmEe02.setReadOnly(true); // E02-육아휴직수당
		taxmEe10.setReadOnly(true); // E10-사망일시금
		taxmEf01.setReadOnly(true); // F01-요양비

		taxmEh02.setReadOnly(true); // H02-일직·숙직료
		taxmEh03.setReadOnly(true); // H03-자가운전보조금
		taxmEh04.setReadOnly(true); // H04-착용제복금
		taxmEj01.setReadOnly(true); // J01-보훈·학습보조비
		taxmEj10.setReadOnly(true); // J10-전직대통령 연금
		taxmEl01.setReadOnly(true); // L01-중군군인전사 과세급여
		taxmEn01.setReadOnly(true); // N01-국민건강보험 보험료
		taxmEp01.setReadOnly(true); // P01-비과세 식대
		taxmEp02.setReadOnly(true); // P02-현물 급식
		taxmEr01.setReadOnly(true); // R01-국군포로 보수
		
		/** 감면소득 부분 */
		taxmEt01.setReadOnly(true); // ⑱-12 T01-외국인기술자
		taxmEt10.setReadOnly(true); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmEt20.setReadOnly(true); // ⑱-25 T20-조세조약상 교직자 감면

		/** 총계 부분 */
		taxeTotl.setReadOnly(false); // ⑳ 비과세 계
		taxmTotl.setReadOnly(false); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
		
	}
	
	
	
	public void setReadOnlyFalseYetaP13008() {
		
		srhHanNm.setReadOnly(false); 	// 성명
		srhSiteNumb.setReadOnly(false); // 사업자등록번호
		srhSiteCtnt.setReadOnly(false);	// 근무지명
		
		taxmEg01.setReadOnly(false); // ⑱-5 G01-비과세 학자금
		taxmEh01.setReadOnly(false); // ⑱-9 H01-무보수위원수당
		taxmEh05.setReadOnly(false); // ⑱-18 H05-경호·승선수당
		taxmEh06.setReadOnly(false); // ⑱-4 H06-유아·초중등
		taxmEh07.setReadOnly(false); // ⑱-4 H07-고등교육법
		taxmEh08.setReadOnly(false); // ⑱-4 H08-특별법
		taxmEh09.setReadOnly(false); // ⑱-4 H09-연구기관
		taxmEh10.setReadOnly(false); // ⑱-4 H10-기업부설연구소
		taxmEh14.setReadOnly(false); // ⑱-22 H14-보육교사
		taxmEh15.setReadOnly(false); // ⑱-23 H15-사립유치원수석교사
		taxmEh11.setReadOnly(false); // ⑱-6 H11-취재수당
		taxmEh12.setReadOnly(false); // ⑱-7 H12-벽지수당
		taxmEh13.setReadOnly(false); // ⑱-8 H13-재해관련급여
		taxmEh16.setReadOnly(false); // ⑱-26 H16-정부공공기관 지방이전기관 종사자 이주수당
		taxmEi01.setReadOnly(false); // ⑱-19 l01-외국정부 근무자
		taxmEk01.setReadOnly(false); // ⑱-10 K01-외국주둔군인
		taxmEm01.setReadOnly(false); // ⑱ M01-국외근로 100만원
		taxmEm02.setReadOnly(false); // ⑱ M02-국외근로 300만원
		taxmEm03.setReadOnly(false); // ⑱ M03-국외근로
		taxmEo01.setReadOnly(false); // ⑱-1 O01-야간근로수당
		taxmEq01.setReadOnly(false); // ⑱-2 Q01-출산보육수당
		taxmEr10.setReadOnly(false); // ⑱-21 R10-근로장학금
		taxmEs01.setReadOnly(false); // ⑱-11 S01-주식매수선택권
		taxmEy02.setReadOnly(false); // ⑱-14 Y02-우리사주조합인출금50%
		taxmEy03.setReadOnly(false); // ⑱-15 Y03-우리사주조합인출금70%
		taxmEy21.setReadOnly(false); // ⑱-20 Y21-장기미취업자 중소기업 취업
		taxmEy22.setReadOnly(false); // ⑲ Y22-전공의 수련 보조수당

		taxmEa01.setReadOnly(false); // A01-복무병 급여
		taxmEb01.setReadOnly(false); // B01-동원직장 급여
		taxmEc01.setReadOnly(false); // C01-요양 급여
		taxmEd01.setReadOnly(false); // D01-요양 보상금
		taxmEe01.setReadOnly(false); // E01-육아휴직급여
		taxmEe02.setReadOnly(false); // E02-육아휴직수당
		taxmEe10.setReadOnly(false); // E10-사망일시금
		taxmEf01.setReadOnly(false); // F01-요양비

		taxmEh02.setReadOnly(false); // H02-일직·숙직료
		taxmEh03.setReadOnly(false); // H03-자가운전보조금
		taxmEh04.setReadOnly(false); // H04-착용제복금
		taxmEj01.setReadOnly(false); // J01-보훈·학습보조비
		taxmEj10.setReadOnly(false); // J10-전직대통령 연금
		taxmEl01.setReadOnly(false); // L01-중군군인전사 과세급여
		taxmEn01.setReadOnly(false); // N01-국민건강보험 보험료
		taxmEp01.setReadOnly(false); // P01-비과세 식대
		taxmEp02.setReadOnly(false); // P02-현물 급식
		taxmEr01.setReadOnly(false); // R01-국군포로 보수
		
		/** 감면소득 부분 */
		taxmEt01.setReadOnly(false); // ⑱-12 T01-외국인기술자
		taxmEt10.setReadOnly(false); // ⑱-24 T10-중소기업취업 청년 소득세 감면
		taxmEt20.setReadOnly(false); // ⑱-25 T20-조세조약상 교직자 감면

		/** 총계 부분 */
		taxeTotl.setReadOnly(false); // ⑳ 비과세 계
		taxmTotl.setReadOnly(false); // ⑳-1 감면소득 계 -> 감면소득은 못찾아서 일단 temp
	}
		
		

}