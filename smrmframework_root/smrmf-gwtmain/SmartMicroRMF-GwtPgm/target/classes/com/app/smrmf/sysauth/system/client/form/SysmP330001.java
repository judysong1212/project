/**
 * 사용자에러상세정보
 */
package com.app.smrmf.sysauth.system.client.form;
  

import java.util.Iterator;

import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Timer;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class SysmP330001   extends MSFFormPanel {  

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
 
	private  ContentPanel cpSysmP330001; 
	  
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
	private SysIfBass0300DTO sysIfBass0300Dto; 		//공통코드 dto
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
       

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	
 	private TextField<String> strDeptNm; 			// 부서
 	private TextField<String> strHanNm;				// 성명
 	private TextField<String> strUsrId;				// 아이디
 	private TextField<String> strErrOccrrncDtntm;	// 에러발생일시
// 	private DateField strErrOccrrncDtntm;
 	private TextArea strErrEthdNm;					// 에러 메소드명
 	private TextArea strErrNm;						// 에러명
 	private TextArea strErrCtnt;					// 에러내용
 	
 	private HiddenField<String> deptNm; 			// 부서
 	private HiddenField<String> usrNm;				// 성명
 	private HiddenField<String> usrId;				// 아이디
 	private HiddenField<String> errOccrrncDtntm;	// 에러발생일시
 	private HiddenField<String> errEthdNm;			// 에러 메소드명
 	private HiddenField<String> errNm;				// 에러명
 	private HiddenField<String> errCtnt;			// 에러내용
 	private HiddenField<String> systemkey;			// 시스템키
 	private HiddenField<String> dpobCd;				// 사업장코드
      
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

		   final Timer tmMask = new Timer()
		     {
		           public void run()
		           {
		              // if (maskTracker)
		              // { 
		           	    cancel();
		               	unmask(); 
		               	maskTracker  = true;
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
	  
	  public SysmP330001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
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
		   
	        cpSysmP330001 = new ContentPanel();  

		    createSearchForm();			//기본정보 필드를 적용
		   
		    /**
	          * Create the relations 
	          */
	           
		   cpSysmP330001.setBodyBorder(false);
		   cpSysmP330001.setBorders(false);
		   cpSysmP330001.setHeaderVisible(false);
//		   cpSysmP330001.setSize("790px", "310px");
		   cpSysmP330001.setSize("860px", "470px");
		   
		   this.add(cpSysmP330001);
		   formBinding = new FormBinding(this, true);
		    
//		   this.setSize("810px", "400px"); 
		   this.setSize("880px", "485px");  
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
			
		dpobCd = new HiddenField<String>();		
	    dpobCd.setName("dpobCd");
	    cpSysmP330001.add(dpobCd);
	    
		systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpSysmP330001.add(systemkey);
		
	    
		deptNm = new HiddenField<String>();	
		deptNm.setName("deptNm");
	    cpSysmP330001.add(deptNm);
	    
	    usrNm = new HiddenField<String>();	
	    usrNm.setName("usrNm");
	    cpSysmP330001.add(usrNm);
	    
	    usrId = new HiddenField<String>();		
	    usrId.setName("usrId");
	    cpSysmP330001.add(usrId);
	    
	    errOccrrncDtntm = new HiddenField<String>();		
	    errOccrrncDtntm.setName("errOccrrncDtntm");
	    cpSysmP330001.add(errOccrrncDtntm);
	    
	    errEthdNm = new HiddenField<String>();		
	    errEthdNm.setName("errEthdNm");
	    cpSysmP330001.add(errEthdNm);
	    
	    errNm = new HiddenField<String>();		
	    errNm.setName("errNm");
	    cpSysmP330001.add(errNm);
	    
	    errCtnt = new HiddenField<String>();		
	    errCtnt.setName("errCtnt");
	    cpSysmP330001.add(errCtnt);
			
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		
		LayoutContainer  lcSchCol = new LayoutContainer();
		
		
		LayoutContainer  lcSchCol1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer  lcSchCol1_1 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol1_1.setLayout(frmlytSch);
        
		strDeptNm = new TextField<String>();
		strDeptNm.setName("strDeptNm");
		strDeptNm.setFieldLabel("부서명");
		strDeptNm.setReadOnly(true);
		lcSchCol1_1.add(strDeptNm, new FormData("100%"));
		
		lcSchCol1.add(lcSchCol1_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer  lcSchCol1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol1_2.setLayout(frmlytSch);
        
		strHanNm = new TextField<String>();
		strHanNm.setName("strHanNm");
		strHanNm.setFieldLabel("성 명");
		strHanNm.setReadOnly(true);
		lcSchCol1_2.add(strHanNm, new FormData("100%"));
		
		lcSchCol1.add(lcSchCol1_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		lcSchCol.add(lcSchCol1);
		
		LayoutContainer  lcSchCol2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer  lcSchCol2_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol2_1.setLayout(frmlytSch);
        
		strUsrId = new TextField<String>();
		strUsrId.setName("strHanNm");
		strUsrId.setFieldLabel("아이디");
		strUsrId.setReadOnly(true);
		lcSchCol2_1.add(strUsrId, new FormData("100%"));
		
		lcSchCol2.add(lcSchCol2_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer  lcSchCol2_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol2_2.setLayout(frmlytSch);
		
		strErrOccrrncDtntm = new TextField<String>();
		strErrOccrrncDtntm.setName("strErrOccrrncDtntm");
		strErrOccrrncDtntm.setFieldLabel("발생일시");
		strErrOccrrncDtntm.setReadOnly(true);
		lcSchCol2_2.add(strErrOccrrncDtntm, new FormData("100%"));
        
//		strErrOccrrncDtntm = new DateField();
//		new DateFieldMask(strErrOccrrncDtntm, "9999.99.99"); 
//		strErrOccrrncDtntm.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		strErrOccrrncDtntm.setFieldLabel("발생일시");
//		lcSchCol2_2.add(strErrOccrrncDtntm, new FormData("100%"));
		
		lcSchCol2.add(lcSchCol2_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		lcSchCol.add(lcSchCol2);
		
		LayoutContainer  lcSchCol3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol3.setLayout(frmlytSch);
		
		strErrEthdNm = new TextArea();
		strErrEthdNm.setName("strErrEthdNm");
		strErrEthdNm.setReadOnly(true);
		strErrEthdNm.setFieldLabel("에러메소드명");
//		strErrEthdNm.setSize(940, 40);
		lcSchCol3.add(strErrEthdNm, new FormData("100%"));
		
		lcSchCol.add(lcSchCol3);
		
		LayoutContainer  lcSchCol4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol4.setLayout(frmlytSch);
		
		strErrNm = new TextArea();
		strErrNm.setName("strErrNm");
		strErrNm.setFieldLabel("에러명");
		strErrNm.setReadOnly(true);
//		strErrEthdNm.setSize(940, 40);
		lcSchCol4.add(strErrNm, new FormData("100%"));
		
		lcSchCol.add(lcSchCol4);
		
		LayoutContainer  lcSchCol5 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol5.setLayout(frmlytSch);
		
		strErrCtnt = new TextArea();
		strErrCtnt.setName("strErrCtnt");
		strErrCtnt.setFieldLabel("에러내용");
		strErrCtnt.setHeight(250);
		strErrCtnt.setReadOnly(true);
//		strErrEthdNm.setSize(940, 40);
		lcSchCol5.add(strErrCtnt, new FormData("100%"));
		
		lcSchCol.add(lcSchCol5);

		fieldSet.add(lcSchCol, new FormData("100%"));
		

		cpSysmP330001.add(fieldSet);
	}  
	 
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			 @Override
			public void handleEvent(BaseEvent be) {
				 
				 strDeptNm.setValue(deptNm.getValue()); 						// 부서
				 strHanNm.setValue(usrNm.getValue());							// 성명
				 strUsrId.setValue(usrId.getValue());							// 아이디
				 strErrOccrrncDtntm.setValue(errOccrrncDtntm.getValue());		// 에러발생일시
				 strErrEthdNm.setValue(errEthdNm.getValue());					// 에러 메소드명
				 strErrNm.setValue(errNm.getValue());							// 에러명
				 strErrCtnt.setValue(errCtnt.getValue());						// 에러내용
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
	
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
	
		
	 
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
