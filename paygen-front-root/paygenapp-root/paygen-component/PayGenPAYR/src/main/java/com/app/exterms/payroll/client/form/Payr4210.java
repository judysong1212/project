package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0350DTO;
import com.app.exterms.payroll.client.dto.Payr0360DTO;
import com.app.exterms.payroll.client.form.defs.Payr0350Def;
import com.app.exterms.payroll.client.form.defs.Payr0360Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr4210Service;
import com.app.exterms.payroll.client.service.Payr4210ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFCheckBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextArea;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
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
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr4210  extends MSFPanel { 
 

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

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
	  private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
	
	  private VerticalPanel vp;
	  private FormPanel plFrmPayr4210;
	  //private FormData formData; 
	  private String txtForm = ""; 
	 
	  //소급계산결과 설정정보 
	  private Payr0360Def payr0360Def  = new Payr0360Def("PAYR4210");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0360GridPanel; 
  
      //계산결과   
	  private Payr0350Def payr0350Def  = new Payr0350Def("PAYR4210");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0350GridPanel; 
	    
      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
  
      //지급년도 
//      private LookupPayr0300PayYr lkReattyApptnYr = new LookupPayr0300PayYr();  
//      private MSFGridPanel ReattyApptnYrGridPanel; 
      
      
//      private LookupReattyStpDsptyNum lkReattyStpDsptyNum = new LookupReattyStpDsptyNum();  
//      private MSFGridPanel reattyStpDsptyNumGridPanel;
 
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
       
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * Button 변수 선언
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ButtonBar topPayr4210Bar;
      private Button    btnPayr4210Init;
      private Button    btnPayr4210New;
      private Button    btnPayr4210Save;
      private Button    btnPayr4210Del;
      private Button    btnPayr4210Sreach;
      private Button    btnPayr4210Excel;
      private Button    btnPayr4210Print;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : ReattyApptnYr */
      private ComboBox<BaseModel> srhReattyApptnYr;
      private ComboBox<BaseModel> srhReattyApptnMnth;
      private ComboBox<BaseModel> srhReattyStpDsptyNum;  //차수번호
      
      
      private ComboBox<BaseModel> srhPayCd;     //급여구분
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
//      private TextField<String> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptNm ;    //부서 
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정 
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
       
      private Boolean picBoolFile;
       
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

      private Boolean emptyCheck = false ;
      private boolean mutilCombo = false;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      
      private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */

      private MSFComboBox<BaseModel> payCd;   /** column 급여구분코드 : payCd */

      private MSFComboBox<BaseModel> reattyYr;   /** column 소급년도 : reattyYr */

      private MSFTextField reattyStpDsptyNum;   /** column 소급설정회차번호 : reattyStpDsptyNum */

      private HiddenField<String> reattyApptnYrMnth;   /** column 소급적용년월 : reattyApptnYrMnth */
      
      private MSFComboBox<BaseModel> reattyApptnYr;        //작업년도
      private MSFComboBox<BaseModel> reattyApptnMnth;       //작업월
      

      private MSFDateField reattyPymtDt;   /** column 소급지급일자 : reattyPymtDt */

      private MSFComboBox<BaseModel> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */


      private MSFComboBox<BaseModel> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */

      private MSFMultiComboBox<ModelData> deptCd;   /** column 부서코드 : deptCd */

      private MSFComboBox<BaseModel> businCd;   /** column 사업코드 : businCd */

      private MSFMultiComboBox<ModelData> typOccuCd;   /** column 직종코드 : typOccuCd */
      

      private MSFMultiComboBox<ModelData> dtilOccuInttnCd;   /** column 직종세구분코드 : dtilOccuInttnCd */

      private MSFCheckBox pymtMnthStp01;   /** column 지급월설정_01 : pymtMnthStp01 */

      private MSFCheckBox pymtMnthStp02;   /** column 지급월설정_02 : pymtMnthStp02 */

      private MSFCheckBox pymtMnthStp03;   /** column 지급월설정_03 : pymtMnthStp03 */

      private MSFCheckBox pymtMnthStp04;   /** column 지급월설정_04 : pymtMnthStp04 */

      private MSFCheckBox pymtMnthStp05;   /** column 지급월설정_05 : pymtMnthStp05 */

      private MSFCheckBox pymtMnthStp06;   /** column 지급월설정_06 : pymtMnthStp06 */

      private MSFCheckBox pymtMnthStp07;   /** column 지급월설정_07 : pymtMnthStp07 */

      private MSFCheckBox pymtMnthStp08;   /** column 지급월설정_08 : pymtMnthStp08 */

      private MSFCheckBox pymtMnthStp09;   /** column 지급월설정_09 : pymtMnthStp09 */

      private MSFCheckBox pymtMnthStp10;   /** column 지급월설정_10 : pymtMnthStp10 */

      private MSFCheckBox pymtMnthStp11;   /** column 지급월설정_11 : pymtMnthStp11 */

      private MSFCheckBox pymtMnthStp12;   /** column 지급월설정_12 : pymtMnthStp12 */
      
      private MSFCheckBox chkAll;    /** column 전체체크 : chkAll */
      
      private MSFTextArea reattyStpNoteCtnt;   /** column 소급설정내용 : reattyStpNoteCtnt */

      private HiddenField<String> tgtSystemkey;   /** column TGT_SYSTEMKEY : tgtSystemkey */
      private MSFTextField hanNm;         //성명
      private MSFTextField resnRegnNum;   //주민번호 
      
      private HiddenField<String> secRegnNum;   //주민번호 
      
      private HiddenField<String> reattyPymtYrMnth;   /** column 지급년월 : reattyPymtYrMnth */
      private HiddenField<Boolean> reattyPymtPrcsYn;   /** column 소급지급처리여부 : reattyPymtPrcsYn */ 
      private HiddenField<String> reattyDdlneDt;   /** column 소급마감일자 : reattyDdlneDt */ 
      private HiddenField<Boolean> reattyDdlneYn;   /** column 소급마감여부 : reattyDdlneYn */
      
      
//
//      private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//      private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//      private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//      private TextField<String> ismt;   /** column 수정자 : ismt */
//
//      private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//      private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
      
      private List<ModelData> mDtalistcrDeptCd ;
      private List<ModelData> mDtalistcrTypOccuCd ;
      private List<ModelData> mDtalistcrDtilOccuInttnCd ;
      
      private boolean mutilcrCombo = false;
       
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

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
		  private void checkPayr4210Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ; 
	                //----------------------------------------------------
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
	                 
			   }
		  }
			 private void authExecEnabled() { 
				   //------------------
			     
		   	        Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd
		   	        						, payrMangDeptCd, emymtDivCd, deptCd, typOccuCd, dtilOccuInttnCd, businCd};
		   	     
		   	        gwtAuthorization.formAuthFieldConfig(fldArrField);
		   	        
		   	        
			   	 	 srhReattyApptnYr.setValue(lsReattyApptnYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		        	 Date today = new Date(); 
		             DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
		             srhReattyApptnMnth.setValue(lsReattyApptnMnth.getAt(Integer.parseInt(fmt.format(today)) - 1));
		            
		              reattyYr.setValue(lsReattyYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
			           reattyApptnYr.setValue(lscrReattyApptnYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
			           if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(reattyApptnYr,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(reattyApptnMnth,"month"))) {
			               //setInitDate();
			           }
			         
			           reattyApptnMnth.setValue(lscrReattyApptnMnth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
			           
			           srhPayCd.setValue(lsPayCd.getAt(0));
			           payCd.setValue(lscrPayCd.getAt(0));
					   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                    // String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
	                    // GWTAuthorization.formAuthPopConfig(plFrmPayr0350, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
	                    // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
					 //  gwtAuthorization.formAuthConfig(plFrmPayr4210, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 //    srhDeptCd.fireEvent(Events.Add);
	                   srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	   	            
		   	              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		   	            * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		   	            * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		   	            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		   	            // String[] strArrDeptCd = { "creCurrDeptCd","creCurrDeptNm"};
		   	            // GWTAuthorization.formAuthPopConfig(plFrmPayr0350, "payrMangDeptCd","emymtDivCd",strArrDeptCd,"typOccuCd","businCd");
		   	            // GWTAuthorization.formAuthBtnConfig(btnCreCurrDeptCd); 
	                 //  gwtAuthorization.formAuthConfig(plFrmPayr4210,  "payrMangDeptCd","emymtDivCd","deptCd","typOccuCd","dtilOccuInttnCd","businCd" );
		   	           
		   	           /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		   	            * 권한설정을 위한 콤보처리를 위한 메서드 종료
		   	            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		   	            deptCd.getListView().fireEvent(Events.CheckChanged);  
	   	           
			            
				 }
		   final Timer tmMask = new Timer()
		     {
		           public void run()
		           {
		              // if (maskTracker)
		              // { 
		        	   if (lsEmymtDivCd.getCount() > 0 ) {
		        		   
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
			     
			     authMapDef.put("srhReattyApptnYr",Boolean.FALSE); 
			     authMapDef.put("srhReattyApptnMnth",Boolean.FALSE);
			     authMapDef.put("srhPayCd",Boolean.FALSE);
			     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);  
			     authMapDef.put("srhDeptCd",Boolean.FALSE); 
			   //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
			    
			    
			     authMapDef.put("reattyApptnYr",Boolean.FALSE); 
			     authMapDef.put("reattyApptnMnth",Boolean.FALSE);
			     authMapDef.put("payCd",Boolean.FALSE);
			     authMapDef.put("payrMangDeptCd",Boolean.FALSE); 
			    authMapDef.put("emymtDivCd",Boolean.FALSE);  
			    authMapDef.put("deptCd",Boolean.FALSE); 
			   // authMapDef.put("typOccuCd",Boolean.FALSE);  
				 
			     gwtExtAuth.setCheckMapDef(authMapDef);
		        
		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		        	  //권한 검색조건처리를 위해 추가된 부분 
					  mask("[화면로딩] 초기화 진행 중!");
	        	}
		        tmMask.scheduleRepeating(5000);
		  }
	     
      /**
       *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
       * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
       *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
       **/	
      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr4210FormBinding() {
	 	 
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
 *  Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	  
      //입력수정삭제처리 rpc 처리부     
      private Payr4210ServiceAsync payr4210Service = Payr4210Service.Util.getInstance();
      
      private ListStore<BaseModel> lsReattyApptnYrStore = new ListStore<BaseModel>();  	//년도 
      private ListStore<BaseModel> lsReattyYr 			= new ListStore<BaseModel>(); 	//년도 
      private ListStore<BaseModel> lsReattyApptnMnth 	= new ListStore<BaseModel>();  	//급여월   
      private ListStore<BaseModel> lsReattyStpDsptyNum 	= new ListStore<BaseModel>();  	//차수번호  
      private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	//고용구분
      private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드
      
       //--------------------부서 불러 오는 함수 ------------------------------------------------
      private ListStore<BaseModel> lsDeptCd 			 = new ListStore<BaseModel>();	// 부서콤보
       //--------------------부서 불러 오는 함수 ------------------------------------------------
      private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
      //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lsBusinCd  			= new ListStore<BaseModel>();	// 사업콤보   
     //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
	  private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드 
      private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	//직종 
      private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
      private ListStore<BaseModel> lsPayCd 				= new ListStore<BaseModel>(); 	//급여구분
      
      private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
      private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
      private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
      private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
      private SysCoCalendarDTO  msfCoCalendarDto;  
      private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
      private PrgmComBass0320DTO sysComBass0320Dto;	//직종
     
      private BaseModel record;
  
      private  Iterator<Record> records;
    
      
      private ListStore<BaseModel>  lscrReattyApptnYr = new ListStore<BaseModel>(); 
      private ListStore<BaseModel>  lscrReattyApptnMnth = new ListStore<BaseModel>();  //급여월   
    
      private ListStore<BaseModel>  lscrEmymtDivCd = new ListStore<BaseModel>();//고용구분 
      
       //--------------------부서 불러 오는 함수 ------------------------------------------------
      private ListStore<BaseModel> lscrDeptCd  = new ListStore<BaseModel>();// 부서콤보
       //--------------------부서 불러 오는 함수 ------------------------------------------------
         
      //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lscrBusinCd  = new ListStore<BaseModel>();// 사업콤보   
     //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel>   lscrPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
      private ListStore<BaseModel>  lscrTypOccuCd = new ListStore<BaseModel>();//직종 
      private ListStore<BaseModel>  lscrDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
      private ListStore<BaseModel>  lscrPayCd = new ListStore<BaseModel>(); //급여구분
      private ListStore<BaseModel> lscreMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
	 
    
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
    private SelectionListener<ButtonEvent> selectionListener = 
	        new SelectionListener<ButtonEvent>() {
	        public void componentSelected(ButtonEvent ce) { 
	            if (ce.getButton() == btnPayr4210Save) {
	                doAction(ActionDatabase.INSERT);
	            } else if (ce.getButton() == btnPayr4210Save) {
	                doAction(ActionDatabase.UPDATE);
	            } else if (ce.getButton() == btnPayr4210Del) {
	                doAction(ActionDatabase.DELETE);
	            }

	        }  
	    };
	  
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
         
            break;
        case UPDATE:
            
            break;
        case DELETE:
              deletePayr4210Reatty();      	
            break;
        }
    }
    
    
	  /**
     * 데이타를 삭제한다.
     */
    private void deletePayr4210Reatty() {
        
        if (!(reattyPymtPrcsYn.equals(true) && reattyDdlneYn.equals(true))) {
        	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                     "마감되거나 이미소급처리된 내역에 대해서는 삭제하실 수 없습니다.", null); 
            return;
        }
        
        if (MSFSharedUtils.paramNull(reattyApptnYrMnth.getValue())) {
            return;
        }
        
        MessageBox.confirm("소급계산설정삭제", "선택된 데이타를 삭제 하시겠습니까?<br>(소급계산설정정보를 삭제합니다.)",new Listener<MessageBoxEvent>(){
            @Override
             public void handleEvent(MessageBoxEvent be) {
                // if("Yes".equals(be.getButtonClicked().getText())){
            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
             
                	 Payr0360DTO payr0360Dto = new Payr0360DTO(); 

                	 
                	 payr0360Dto.setDpobCd(dpobCd.getValue());    /** column 사업장코드 : dpobCd */
                	 payr0360Dto.setPayCd(MSFSharedUtils.getSelectedComboValue(payCd,"commCd"));    /** column 급여구분코드 : payCd */
                	 payr0360Dto.setReattyYr(MSFSharedUtils.getSelectedComboValue(reattyYr,"year") );    /** column 소급년도 : reattyYr */
                	 payr0360Dto.setReattyStpDsptyNum(reattyStpDsptyNum.getValue());    /** column 소급설정회차번호 : reattyStpDsptyNum */
//                	 remtInpt3000Vo.setReattyApptnYrMnth(eepnRemt3000Vo.getReattyApptnYrMnth());    /** column 소급계산년월 : reattyApptnYrMnth */
//                	 remtInpt3000Vo.setReattyPymtDt(eepnRemt3000Vo.getReattyPymtDt());    /** column 소급지급일자 : reattyPymtDt */
//                	 remtInpt3000Vo.setEmymtDivCd(eepnRemt3000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//                	 remtInpt3000Vo.setPayrMangDeptCd(eepnRemt3000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//                	 remtInpt3000Vo.setDeptCd(eepnRemt3000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//                	 remtInpt3000Vo.setBusinCd(eepnRemt3000Vo.getBusinCd());    /** column 사업코드 : businCd */
//                	 remtInpt3000Vo.setTypOccuCd(eepnRemt3000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//                	 remtInpt3000Vo.setDtilOccuInttnCd(eepnRemt3000Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//                	 remtInpt3000Vo.setPymtMnthStp01(eepnRemt3000Vo.getPymtMnthStp01());    /** column 지급월설정_01 : pymtMnthStp01 */
//                	 remtInpt3000Vo.setPymtMnthStp02(eepnRemt3000Vo.getPymtMnthStp02());    /** column 지급월설정_02 : pymtMnthStp02 */
//                	 remtInpt3000Vo.setPymtMnthStp03(eepnRemt3000Vo.getPymtMnthStp03());    /** column 지급월설정_03 : pymtMnthStp03 */
//                	 remtInpt3000Vo.setPymtMnthStp04(eepnRemt3000Vo.getPymtMnthStp04());    /** column 지급월설정_04 : pymtMnthStp04 */
//                	 remtInpt3000Vo.setPymtMnthStp05(eepnRemt3000Vo.getPymtMnthStp05());    /** column 지급월설정_05 : pymtMnthStp05 */
//                	 remtInpt3000Vo.setPymtMnthStp06(eepnRemt3000Vo.getPymtMnthStp06());    /** column 지급월설정_06 : pymtMnthStp06 */
//                	 remtInpt3000Vo.setPymtMnthStp07(eepnRemt3000Vo.getPymtMnthStp07());    /** column 지급월설정_07 : pymtMnthStp07 */
//                	 remtInpt3000Vo.setPymtMnthStp08(eepnRemt3000Vo.getPymtMnthStp08());    /** column 지급월설정_08 : pymtMnthStp08 */
//                	 remtInpt3000Vo.setPymtMnthStp09(eepnRemt3000Vo.getPymtMnthStp09());    /** column 지급월설정_09 : pymtMnthStp09 */
//                	 remtInpt3000Vo.setPymtMnthStp10(eepnRemt3000Vo.getPymtMnthStp10());    /** column 지급월설정_10 : pymtMnthStp10 */
//                	 remtInpt3000Vo.setPymtMnthStp11(eepnRemt3000Vo.getPymtMnthStp11());    /** column 지급월설정_11 : pymtMnthStp11 */
//                	 remtInpt3000Vo.setPymtMnthStp12(eepnRemt3000Vo.getPymtMnthStp12());    /** column 지급월설정_12 : pymtMnthStp12 */
//                	 remtInpt3000Vo.setTgtSystemkey(eepnRemt3000Vo.getTgtSystemkey());    /** column TGT_SYSTEMKEY : tgtSystemkey */
//                	 remtInpt3000Vo.setReattyStpNoteCtnt(eepnRemt3000Vo.getReattyStpNoteCtnt());    /** column null : reattyStpNoteCtnt */
//                	 remtInpt3000Vo.setKybdr(eepnRemt3000Vo.getKybdr());    /** column 입력자 : kybdr */
//                	 remtInpt3000Vo.setInptDt(eepnRemt3000Vo.getInptDt());    /** column 입력일자 : inptDt */
//                	 remtInpt3000Vo.setInptAddr(eepnRemt3000Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                	 remtInpt3000Vo.setIsmt(eepnRemt3000Vo.getIsmt());    /** column 수정자 : ismt */
//                	 remtInpt3000Vo.setRevnDt(eepnRemt3000Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                	 remtInpt3000Vo.setRevnAddr(eepnRemt3000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                	  
                       
               		payr4210Service.activityOnDeletePayr4210(payr0360Dto ,
                               new AsyncCallback<Long>() {
                       public void onFailure(Throwable caught) {
                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDeletePayr4210(삭제) : " + caught), null);
                       }
                       public void onSuccess(Long result) { 
                       if (result == 0) {
                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                  "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                       } else {
                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                                   "삭제처리가 완료되었습니다.", null); 
                          payr4210Init(); 
                          reload(); 
                       } 
                       } 
                       });
                 }  
            }
            
        });
        
        
    }      
    
	
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
//	private void Payr4210Print(String fileName) {
// 
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PAYR";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		// 보낼 파라미터
//		
//		
//		//검색조건
// 	String serarchParam = "";
////		
////		String name = searchName.getValue() == null ? "" : searchName.getValue();
////		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////		
////		serarchParam += "["+name+"]";
////		serarchParam += "["+resn+"]";
////		serarchParam += "["+hdofcCodtnCd+"]";
////		serarchParam += "[]";
////		//serarchParam += "["+manageDeptCd+"]";
////		serarchParam += "["+deptCd+"]";
////		serarchParam += "["+emymtDivCd+"]";
////		serarchParam += "["+typOccuCd+"]";
//		
//		List<BaseModel> list = payr0350GridPanel.getGrid().getSelectionModel().getSelectedItems();
//		String checkedSystemKeys = "";
//		if(list != null && list.size() > 0){
//			String chkkey = "";
//			for(BaseModel bm : list){
//				chkkey += "'"+bm.get("systemkey")+"',";
//			}
//			
//			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//			
//		}
//		String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//		
//		//System.out.println(strParam);
//		
//		//String strParam = "/rp " + "[" + "20080311" + "]";
//		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//
//	}

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/
 
	  
  public ContentPanel getViewPanel(){
		if(panel == null){
			  
			 //콤보 권한초기화
			   initLoad(); 
		   // formData = new FormData("-650");
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createPayr4210Form();  //화면 기본정보를 설정
		    createSearchForm();    //검색필드를 적용
		    createStandardForm();    //기본정보필드  
		    //엣지변환
		    //vp.setSize("1010px", "700px");
		    vp.setSize("1010px", "750px");
			
		    
		    /**
             *  
              * Create the relations 
              */
               final RelationDef  relPayr0360 = new RelationDef(payr0360Def,false); 
               relPayr0360.addJoinDef("dpobCd", "dpobCd"); 
               relPayr0360.addJoinDef("payCd", "payCd");
               relPayr0360.addJoinDef("reattyYr", "reattyYr");
               relPayr0360.addJoinDef("reattyStpDsptyNum", "reattyStpDsptyNum"); 
               relPayr0360.setLinkedObject(payr0360GridPanel);
               payr0350Def.addRelation(relPayr0360);  

               
               // DETAILS 
               final Grid payr0360Grid = payr0360GridPanel.getMsfGrid().getGrid();
               payr0360Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
                  public void handleEvent(BaseEvent be) {  
                      if (payr0360GridPanel.getCurrentlySelectedItem() != null) { 
                          
                          payr0350Def.synchronizeGridDetail(
                                  payr0360GridPanel.getCurrentlySelectedItem(),
                                  payr0350GridPanel );  
                            
                          
                          fnPayr0360Detail(payr0360GridPanel.getCurrentlySelectedItem());
                         //  payr0350DtlGridPanel.reload(); 
                         
                       }
                    
                       
                  }
              }); 
               
		    
		    this.actionDatabase = ActionDatabase.UPDATE;	    
			 
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
	   * @wbp.parser.constructor
	   */
	  public Payr4210() {
		 
		  //엣지변환
		  //setSize("1010px", "700px"); 
			setSize("1010px", "750px");  
	  } 
	
	  public Payr4210(String txtForm) {
			this.txtForm = txtForm;
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
	  private void createPayr4210Form() {
		  
		plFrmPayr4210 = new FormPanel();
		plFrmPayr4210.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr4210());
		//plFrmPayr4210.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 소급계산관리");
		plFrmPayr4210.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr4210.setBodyStyleName("pad-text");
		plFrmPayr4210.setPadding(2);
		plFrmPayr4210.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr4210(),"PAYR4210");
				}
			});
		plFrmPayr4210.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr4210.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmPayr4210.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) { 
            
             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                    
            //        if (f instanceof MSFMultiComboBox<?>) {
                        
//                      if ("srhDeptCd".equals(f.getName())) {
//                          
//                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                          
//                      }
                        
              //      } else {
                   if (mutilCombo) {
                        if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                            //부서
                            srhDeptCd.showClose(ce);
                            mutilCombo = false;
                        } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                            //직종
                            srhTypOccuCd.showClose(ce);
                            mutilCombo = false;
                          //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
                        } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                            //직종세
                            srhDtilOccuInttnCd.showClose(ce);
                            mutilCombo = false;
                        }  
                   }
                   
                   if (mutilcrCombo) {
                       if ( deptCd.getCheckBoxListHolder().isVisible() ) {
                           //부서
                           deptCd.showClose(ce);
                           mutilcrCombo = false;
                       } else if (typOccuCd.getCheckBoxListHolder().isVisible() ) {
                           //직종
                           typOccuCd.showClose(ce);
                           mutilcrCombo = false;
                         //  typOccuCd.getListView().fireEvent(Events.CheckChanged);
                       } else if ( dtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                           //직종세
                           dtilOccuInttnCd.showClose(ce);
                           mutilcrCombo = false;
                       }  
                  }
                //    }
            //    } 
            } 
         }); 

		  LayoutContainer layoutContainer = new LayoutContainer();
		  layoutContainer.setLayout(new ColumnLayout());
		  
		  LayoutContainer layoutContainer_1 = new LayoutContainer(); 
		  layoutContainer_1.setLayout(new FlowLayout());
		  
		  ButtonBar buttonBar_1 = new ButtonBar();
		  
		  Button btnNewButton_2 = new Button("");
		  btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
		  buttonBar_1.add(btnNewButton_2);
		  layoutContainer_1.add(buttonBar_1);
		  layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  layoutContainer_1.setBorders(false);
		  
		  LayoutContainer layoutContainer_2 = new LayoutContainer();
		  layoutContainer_2.setLayout(new FlowLayout());
		  
		   
		   topPayr4210Bar = new ButtonBar();    
		   layoutContainer_2.add(topPayr4210Bar);
		   topPayr4210Bar.setAlignment(HorizontalAlignment.RIGHT);
 
	  	
		   btnPayr4210Init = new Button("초기화");  
		   btnPayr4210Init.setIcon(MSFMainApp.ICONS.new16());
		  	topPayr4210Bar.add(btnPayr4210Init);
		  	btnPayr4210Init.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    //초기화 버튼 클릭시 처리     
                   payr4210Init();
                     
                }
            });
		  	
		  	btnPayr4210New = new Button("신규");  
		  	btnPayr4210New.setIcon(MSFMainApp.ICONS.new16());
		  	topPayr4210Bar.add(btnPayr4210New);
		  	btnPayr4210New.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                    // 버튼 클릭시 처리     
                   payr421FormNew();
                     
                }
            });
		  	
		  	
		    
		  	btnPayr4210Del = new Button("삭제");  
		  	btnPayr4210Del.setIcon(MSFMainApp.ICONS.delete16());
		  	topPayr4210Bar.add(btnPayr4210Del); 
		  	btnPayr4210Del.addSelectionListener(selectionListener);
		  	
		  	btnPayr4210Sreach = new Button("조회"); 
		  	btnPayr4210Sreach.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr4210Bar.add(btnPayr4210Sreach);
		  	btnPayr4210Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                //조회버튼 클릭시 처리 
	                reload();  
	            }
	        });
		  	
//		  	btnPayr4210Print = new Button("인쇄"); 
//		  	btnPayr4210Print.setIcon(MSFMainApp.ICONS.search16());
//		  	topPayr4210Bar.add(btnPayr4210Print);
//		  	btnPayr4210Print.addListener(Events.Select, new Listener<ButtonEvent>() {
//	            public void handleEvent(ButtonEvent e) {
//	                //조회버튼 클릭시 처리 
//	                reload();  
//	            }
//	        });
//		  	
		  	btnPayr4210Excel = new Button("엑셀"); 
		  	btnPayr4210Excel.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr4210Bar.add(btnPayr4210Excel);
		  	btnPayr4210Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	            	exportExcel();
	           }
	        }); 
		  	
	    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_2.setBorders(false); 
	    layoutContainer.setBorders(false);
	  	
	    plFrmPayr4210.add(layoutContainer);    
	  	  
	  	
		//파일업로드 처리
		plFrmPayr4210.setAction("bizform");
		plFrmPayr4210.setEncoding(Encoding.MULTIPART);
		plFrmPayr4210.setMethod(Method.POST);
		
	
		vp.add(plFrmPayr4210);
		//엣지변환
		//plFrmPayr4210.setSize("990px", "680px");
		plFrmPayr4210.setSize("990px", "730px");
	  }
		
 
 /**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 
 /**
  * 검색필드 설정
  */
 private void createSearchForm() {   
	  
     sysComBass0150Dto = new PrgmComBass0150DTO();
     sysComBass0300Dto = new PrgmComBass0300DTO();
     sysComBass0400Dto = new PrgmComBass0400DTO();
     sysComBass0500Dto = new PrgmComBass0500DTO();
     msfCoCalendarDto  = new SysCoCalendarDTO();
     sysComBass0350Dto = new PrgmComBass0350DTO();
     sysComBass0320Dto = new PrgmComBass0320DTO();
     
     //--------------------단위기관 불러 오는 함수 ------------------------------------------------
     lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
     //--------------------단위기관 불러 오는 함수 ------------------------------------------------
   
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     //급여구분 
     sysComBass0300Dto.setRpsttvCd("B015");
     lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     //고용구분
     sysComBass0300Dto.setRpsttvCd("A002");
     lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     //호봉
     sysComBass0300Dto.setRpsttvCd("A048");
     lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
   
     //--------------------급여년도 불러 오는 함수 ------------------------------------------------
     lsReattyApptnYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     //월 
     
     lsReattyApptnMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------


     //-------------------관리부서 추가  
     sysComBass0400Dto.setDeptDspyYn("Y");
    sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
    lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
    
     //--------------------부서 불러 오는 함수 ------------------------------------------------
    // lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
     //--------------------부서 불러 오는 함수 ------------------------------------------------
     sysComBass0400Dto.setDeptDspyYn("Y");
     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
    
     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
    
     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
         public void handleEvent(StoreEvent<BaseModel> be) {  
             mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
             srhDeptCd.getInitStore().add(mDtalistDeptCd);
             
             lscrDeptCd = lsDeptCd; 
             mDtalistcrDeptCd = PayrUtils.getDeptCdModelData(lscrDeptCd) ; 
            deptCd.getInitStore().add(mDtalistcrDeptCd);
             
         }
     });     
     //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
    lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
        
   /**
      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      * 직종 콤보박스 처리  시작
      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
      */
//              ContentPanel typOccuCdGrid = new ContentPanel();  
//              typOccuCdGrid.setVisible(false);
//                
//                //직종 콤보처리 
//               typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//               typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//                       public void handleEvent(ComponentEvent be) {  
//                         typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//                          public void handleEvent(StoreEvent<BaseModel> be) {  
//                              

//                          }  
//                        });  
//                       
//                      }  
//                    });  
//          
//             typOccuCdGrid.add(typOccuCdGridPanel); 
//             plFrmPayr4210.add(typOccuCdGrid); 
    
    lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
         public void handleEvent(StoreEvent<BaseModel> be) {  
          
           mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
           srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
           lscrTypOccuCd.add(lsTypOccuCd.getModels());
           mDtalistcrTypOccuCd = PayrUtils.getTypOccuCdModelData(lscrTypOccuCd) ;  
           typOccuCd.getStore().add(mDtalistcrTypOccuCd);
            
         }
     });  
    
         
             /**
              * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
              * 월차조회 
              * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
              */
//             ContentPanel reattyStpDsptyNumGrid = new ContentPanel();  
//             reattyStpDsptyNumGrid.setVisible(false);
//              
//             //년도 콤보처리 
//             reattyStpDsptyNumGridPanel = new MSFGridPanel(lkReattyStpDsptyNum, false, false, false, true); 
//             reattyStpDsptyNumGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//                     public void handleEvent(ComponentEvent be) {  
//                    	 reattyStpDsptyNumGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//                        public void handleEvent(StoreEvent<BaseModel> be) {  
//                           
//                         lsReattyStpDsptyNum.add(reattyStpDsptyNumGridPanel.getMsfGrid().getStore().getModels()); 
//                            
//                         srhReattyStpDsptyNum.setValue(lsReattyStpDsptyNum.getAt(0)); 
//                        
//                        }  
//                      });  
//                     
//                    }  
//                  });  
//        
//             reattyStpDsptyNumGrid.add(reattyStpDsptyNumGridPanel); 
//          plFrmPayr4210.add(reattyStpDsptyNumGrid);  
          
           
     /**
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   * 년도 콤보박스 처리  시작
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
   */
//           ContentPanel ReattyApptnYrGrid = new ContentPanel();  
//           ReattyApptnYrGrid.setVisible(false);
//            
//           //년도 콤보처리 
//           ReattyApptnYrGridPanel = new MSFGridPanel(lkReattyApptnYr, false, false, false, true); 
//           ReattyApptnYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//                   public void handleEvent(ComponentEvent be) {  
//                     ReattyApptnYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//                      public void handleEvent(StoreEvent<BaseModel> be) {  
//                         lsReattyApptnYrStore.add(ReattyApptnYrGridPanel.getMsfGrid().getStore().getModels());  
//                        //  Date today = new Date(); 
//                            // A custom date format
//                        //  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//                         
//                         // BaseModel  bm  =  srhReattyApptnYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//                         // srhReattyApptnYr.setValue(bm);
//                        srhReattyApptnYr.setValue(lsReattyApptnYrStore.getAt(0));
//                        Date today = new Date(); 
//                        DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                        srhReattyApptnMnth.setValue(lsReattyApptnMnth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                      
//                      }  
//                    });  
//                   
//                  }  
//                });  
//      
//        ReattyApptnYrGrid.add(ReattyApptnYrGridPanel); 
//        plFrmPayr4210.add(ReattyApptnYrGrid); 

        lscrPayrMangDeptCd = lsPayrMangDeptCd; 
        lscreMangeDeptCd = lsMangeDeptCd; 
        lscrPayCd = lsPayCd; 
        lscrEmymtDivCd = lsEmymtDivCd;   
        

        
        srhSystemkey = new HiddenField<String>(); 
        
	    plFrmPayr4210.setLayout(new FlowLayout()); 
          
        LayoutContainer lcSchCol = new LayoutContainer();
        lcSchCol.setLayout(new ColumnLayout()); 
        
        FieldSet fieldSet = new FieldSet();  
        fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
        fieldSet.setStyleAttribute("marginTop", "10px");
       // fieldSet.setCheckboxToggle(false); 
        
        LayoutContainer lcSchLeft = new LayoutContainer();
      //  lcSchLeft.setStyleAttribute("paddingRight", "10px"); 
     
        fieldSet.add(lcSchCol, new FormData("100%"));  
        lcSchLeft.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_8 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_8.setLayout(frmlytSch);
        
        srhReattyApptnYr = new ComboBox<BaseModel>();
        srhReattyApptnYr.setName("srhReattyApptnYr");
        srhReattyApptnYr.setForceSelection(true);
        srhReattyApptnYr.setMinChars(1);
        srhReattyApptnYr.setDisplayField("yearDisp");
        srhReattyApptnYr.setValueField("year");
        srhReattyApptnYr.setTriggerAction(TriggerAction.ALL);
       // srhReattyApptnYr.setEmptyText("--년도선택--");
        srhReattyApptnYr.setSelectOnFocus(true); 
        srhReattyApptnYr.setReadOnly(false);
        srhReattyApptnYr.setEnabled(true); 
        srhReattyApptnYr.setStore(lsReattyApptnYrStore);
        srhReattyApptnYr.setFieldLabel("지급년월"); 
        srhReattyApptnYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	checkPayr4210Auth("srhReattyApptnYr", lsReattyApptnYrStore); 
            	 
            }
        });
        srhReattyApptnYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
              public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                  //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
               BaseModel bmReattyApptnYr =  se.getSelectedItem(); 
               if (bmReattyApptnYr != null) {
                   
                   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                       
                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
                          
                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year"));
                           List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
                           sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
                       }      
                    
                       //--------------------사업 불러 오는 함수 -------------------------------------------------
                         lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                        //--------------------사업 불러 오는 함수 -------------------------------------------------
                         srhBusinCd.setStore(lsBusinCd); 
                         srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                             public void handleEvent(StoreEvent<BaseModel> be) {  
                              //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                             }
                         });    
                         
                        // IColumnFilter filters = null;
                        // reattyStpDsptyNumGridPanel.getTableDef().setTableColumnFilters(filters);
           				
                         //reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"ReattyApptnYr")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
             			// reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             			// reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyYr", MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"ReattyApptnYr"), SimpleColumnFilter.OPERATOR_LIKE); 
           			  
                        // reattyStpDsptyNumGridPanel.reload(); 
                         
                   } else {
                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
                      // return;
                   } 
   
                  
               }       
              } 
          });   
        layoutContainer_8.add(srhReattyApptnYr, new FormData("100%"));
        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.66));
        layoutContainer_8.setBorders(false);
        
        LayoutContainer layoutContainer1_9 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer1_9.setLayout(frmlytSch);
        
        /** column 지급년월 : Mnth */ 
        srhReattyApptnMnth = new ComboBox<BaseModel>();
        srhReattyApptnMnth.setName("srhReattyApptnMnth");
        srhReattyApptnMnth.setForceSelection(true);
        srhReattyApptnMnth.setMinChars(1);
        srhReattyApptnMnth.setDisplayField("monthDisp");
        srhReattyApptnMnth.setValueField("month");
        srhReattyApptnMnth.setTriggerAction(TriggerAction.ALL);
       // srhReattyApptnMnth.setEmptyText("--월선택--");
        srhReattyApptnMnth.setSelectOnFocus(true); 
        srhReattyApptnMnth.setReadOnly(false);
        srhReattyApptnMnth.setEnabled(true); 
        srhReattyApptnMnth.setStore(lsReattyApptnMnth);
        srhReattyApptnMnth.setHideLabel(true);
        srhReattyApptnMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            
            	checkPayr4210Auth("srhReattyApptnMnth", lsReattyApptnMnth);  
              
            }
        });
        
        srhReattyApptnMnth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
             BaseModel bmReattyApptnYr =  se.getSelectedItem(); 
             if (bmReattyApptnYr != null) {
           
                       
                     //  IColumnFilter filters = null;
                    //   reattyStpDsptyNumGridPanel.getTableDef().setTableColumnFilters(filters);
         				
                      // reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"ReattyApptnYr")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
           			 //reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
           			// reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyYr", MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"ReattyApptnYr"), SimpleColumnFilter.OPERATOR_LIKE); 
         			  
                     //  reattyStpDsptyNumGridPanel.reload(); 
                      
              } 
      
            } 
        }); 
        layoutContainer1_9.add(srhReattyApptnMnth, new FormData("100%"));
        lcSchLeft.add(layoutContainer1_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
        layoutContainer1_9.setBorders(false);
        
        LayoutContainer layoutContainer_9 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_9.setLayout(frmlytSch);
        
        /** column 차수번호  : srhReattyStpDsptyNum */ 
        srhReattyStpDsptyNum = new ComboBox<BaseModel>();
        srhReattyStpDsptyNum.setName("srhReattyStpDsptyNum");
        srhReattyStpDsptyNum.setForceSelection(true);
        srhReattyStpDsptyNum.setMinChars(1);
        srhReattyStpDsptyNum.setDisplayField("reattyStpDsptyNumDisp");
        srhReattyStpDsptyNum.setValueField("reattyStpDsptyNum");
        srhReattyStpDsptyNum.setTriggerAction(TriggerAction.ALL);
        srhReattyStpDsptyNum.setEmptyText("-차수-");
        srhReattyStpDsptyNum.setSelectOnFocus(true); 
        srhReattyStpDsptyNum.setReadOnly(true);
        srhReattyStpDsptyNum.setEnabled(true); 
        srhReattyStpDsptyNum.setStore(lsReattyStpDsptyNum);
        srhReattyStpDsptyNum.setHideLabel(true);
        layoutContainer_9.add(srhReattyStpDsptyNum, new FormData("100%"));
        lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
        layoutContainer_9.setBorders(false);
        
        
        LayoutContainer layoutContainer = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer.setLayout(frmlytSch);
        
        /** column 단위기관 : payrMangDeptCd */
        srhPayrMangDeptCd = new ComboBox<BaseModel>();
        srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
        srhPayrMangDeptCd.setForceSelection(true);
        srhPayrMangDeptCd.setMinChars(1);
        srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
        srhPayrMangDeptCd.setValueField("payrMangDeptCd");
        srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
        srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
        srhPayrMangDeptCd.setSelectOnFocus(true); 
        srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
        srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
        srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
        srhPayrMangDeptCd.setFieldLabel("단위기관"); 
        lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
          	  EventType type = be.getType();
	    	   if (type == Store.Add) { 
           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	checkPayr4210Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
           	 }
              
            }
        });    
        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
            	sysComBass0400Dto = new PrgmComBass0400DTO(); 

                 sysComBass0400Dto.setDeptDspyYn("Y");
                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
                //--------------------부서 불러 오는 함수 ------------------------------------------------
                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
                //--------------------부서 불러 오는 함수 ------------------------------------------------
                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
                   public void handleEvent(StoreEvent<BaseModel> be) {  
                     mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
                       
                   }
                });   
            } 
        });
        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
        layoutContainer.setBorders(false);
        
     
        LayoutContainer layoutContainer_5 = new LayoutContainer();
        layoutContainer_5.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_6 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_6.setLayout(frmlytSch);
        
        srhHanNm = new TextField<String>();
        srhHanNm.setName("srhHanNm");
        srhHanNm.setFieldLabel("성명");
        layoutContainer_6.add(srhHanNm, new FormData("100%"));
       
        
        srhHanNm.addKeyListener(new KeyListener() {
           @Override
            public void componentKeyDown(ComponentEvent event) {
                
                srhHanNm.validate();
                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
                    srhSystemkey.setValue("");
                    srhResnRegnNum.setValue("");
                }
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    srhSystemkey.setValue("");
                    srhResnRegnNum.setValue(""); 
                    fnPopupPsnl0100() ;
                }
                super.componentKeyDown(event);
            }
         });
//        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                }
//             
//            } 
//      }); 
        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
        layoutContainer_6.setBorders(false);
        
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        layoutContainer_btn.setLayout(frmlytSch);
        
        Button btnHanNm = new Button("검색");
//        layoutContainer_5.add(btnHanNm);
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                srhSystemkey.setValue("");
                srhResnRegnNum.setValue("");  
              fnPopupPsnl0100() ;
                  
            }
        });
        layoutContainer_btn.add(btnHanNm);
        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));
        
        
        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout(); 
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_7.setLayout(frmlytSch);
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");  
        srhResnRegnNum.setName("srhResnRegnNum");
        srhResnRegnNum.setHideLabel(true);
        srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
                    srhSystemkey.setValue("");
                    srhHanNm.setValue("");
                }
             
            } 
      });
        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
        layoutContainer_7.setBorders(false); 
        layoutContainer_5.setBorders(false);
        
        
        LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
        layoutContainer_1.setBorders(false); 
        
        LayoutContainer layoutContainer_1_1 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_1_1.setLayout(frmlytSch);
        
        srhEmymtDivCd =  new ComboBox<BaseModel>(); 
        srhEmymtDivCd.setName("srhEmymtDivCd");
        srhEmymtDivCd.setForceSelection(true);
        srhEmymtDivCd.setMinChars(1);
        srhEmymtDivCd.setDisplayField("commCdNm");
        srhEmymtDivCd.setValueField("commCd");
        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
        srhEmymtDivCd.setEmptyText("--고용구분선택--");
        srhEmymtDivCd.setSelectOnFocus(true); 
    	srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
    	srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhEmymtDivCd.setStore(lsEmymtDivCd);
        srhEmymtDivCd.setFieldLabel("고용구분");
        lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
          	  EventType type = be.getType();
	    	   if (type == Store.Add) { 
           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	checkPayr4210Auth("srhEmymtDivCd", lsEmymtDivCd); 
           	 }
           
                     
            }
        });    
        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
             BaseModel bmPayCd =  se.getSelectedItem(); 
             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
            	 srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
                 srhBusinCd.setEnabled(true);
                 srhTypOccuCd.reset();
                 srhTypOccuCd.setEnabled(false);
                 srhDtilOccuInttnCd.reset();
                 srhDtilOccuInttnCd.setEnabled(false);
             } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
            	 //20151130 추가 수정 
        	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
            	 srhBusinCd.reset();
                 srhBusinCd.setEnabled(false);   
                 if (gwtExtAuth.getEnableTypOccuCd()) {
                	 srhTypOccuCd.setEnabled(true);
                     srhDtilOccuInttnCd.setEnabled(true); 
                 } else {
                	 srhTypOccuCd.setEnabled(false);
                     srhDtilOccuInttnCd.setEnabled(false);
                     
                 }
        	     
             }  
             
            } 
        });
        layoutContainer_1_1.add(srhEmymtDivCd, new FormData("100%"));
        layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
        
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(true);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	    srhRepbtyBusinDivCd.setValueField("commCd");
	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer_101.setBorders(false);
	    layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
//        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 			// 지급년월
//        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));	// 지급구분
//        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 단위기관
//        lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명
        
        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급년월
        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
        lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
        
        
        
        LayoutContainer layoutContainer_13 = new LayoutContainer();
        layoutContainer_13.setLayout(new ColumnLayout());
        

        
      //관리부서 
      		LayoutContainer lcSch2_1 = new LayoutContainer();
      		FormLayout frmlytSch2_1 = new FormLayout();
      		frmlytSch2_1.setLabelWidth(60);
      		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
      		lcSch2_1.setLayout(frmlytSch2_1);
      		
      		srhMangeDeptCd = new ComboBox<BaseModel>();
      		srhMangeDeptCd.setName("srhMangeDeptCd"); 
      		srhMangeDeptCd.setEmptyText("--관리부서선택--");
      		srhMangeDeptCd.setDisplayField("deptNmRtchnt");
      		srhMangeDeptCd.setStore(lsMangeDeptCd); 
      		srhMangeDeptCd.setWidth(100);
      		srhMangeDeptCd.setFieldLabel("관리부서");
      		srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
              srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
              srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                  public void handleEvent(StoreEvent<BaseModel> be) {  
                  	EventType type = be.getType();
                  	if (type == Store.Add) { 
                  		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
                  		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                  		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
      		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                  		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
                  	}
                  }
              });  
              srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
      	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
      	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
      	    		sysComBass0400Dto = new PrgmComBass0400DTO();
        	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
        	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
        	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
        	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
        	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
        	    		
        	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
        	    			public void handleEvent(StoreEvent<BaseModel> be) {  
        	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
        	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
        	    			}
        	    		});  
        	    		emptyCheck = true;
      	    	} 
      	    });
              srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
                  @Override
                  public void handleEvent(ComponentEvent ce) {    
                  	
                      if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
                      	
                      	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
      	                	sysComBass0400Dto = new PrgmComBass0400DTO();
      	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
      	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
      	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
      	      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
      	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
      	      	    		
      	      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
      	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
      	      	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
      	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
      	      	    			} 
      	      	    			
      	      	    		}); 
      	      	    		emptyCheck = false;
                      	}
                       }  
                  } 
              });   
             
              lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
        
        
        LayoutContainer layoutContainer_2 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_2.setLayout(frmlytSch);
        
        //검색 소속부서 코드 처리  
 
        
           srhDeptCd = new MSFMultiComboBox<ModelData>();
           srhDeptCd.setName("srhDeptCd");
           // srhDeptCd.setForceSelection(true);
           // srhDeptCd.setMinChars(1);
            //srhDeptCd.setDisplayField("deptNmRtchnt");
            //srhDeptCd.setValueField("deptCd");
           // srhDeptCd.setTriggerAction(TriggerAction.ALL);
            srhDeptCd.setEmptyText("--부서선택--");
           // srhDeptCd.setSelectOnFocus(true); 
           // srhDeptCd.setReadOnly(false);
          //  srhDeptCd.setEnabled(true); 
            //srhDeptCd.setStore(lsDeptCd );
            //srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
            srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
            srhDeptCd.getStore().add(mDtalistDeptCd);
            srhDeptCd.setWidth(100);
            srhDeptCd.setFieldLabel("부서");
            srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
            srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
            srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
                public void handleEvent(StoreEvent<ModelData> be) {  
              	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4210Auth("srhDeptCd", lsDeptCd); 
               	 }
                  
                    
                }
            });    

            srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
               @Override
              public void handleEvent(ComponentEvent ce) { 
                       
                          if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                             
                              if (srhDeptCd.getListView().getChecked().size() > 0) {  
                                 
                                  sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year") );    
                                  List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
                                  sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
                              }      
                           
                              //--------------------사업 불러 오는 함수 -------------------------------------------------
                                lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                               //--------------------사업 불러 오는 함수 -------------------------------------------------
                                srhBusinCd.setStore(lsBusinCd); 
                                srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                                    public void handleEvent(StoreEvent<BaseModel> be) {  
                                     //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                                    }
                                });    
                                
                             
                          } else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
       	            		 
                        	  //2015.11.30 권한 직종가져오기  추가 
   	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
   	            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
   	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
   	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
   	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
   	           	             
   	                             mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
   	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
   	                              
   	                           }
   	                       });  
                	    
		                  } else {
		                	  
		                	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		                	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		             		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            	            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	             
		                              mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		                              srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		                               
		                            }
		                        });   
		                  }
                          
                      }  
              
                    });  
             
            srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
                @Override
                public void handleEvent(ComponentEvent ce) {   
                    
                    if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                       // GWT.log(" a" + ce.getEvent().getType());
                        mutilCombo = true;
                    } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                        mutilCombo = true;
                      //  GWT.log(" b" + ce.getEvent().getType());
                    } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                        mutilCombo = false;
                      //  GWT.log(" b" + ce.getEvent().getType());
                    }  
                
                } 
            });         
        layoutContainer_2.add(srhDeptCd, new FormData("100%"));
        layoutContainer_2.setBorders(false);
        
     
        
        //직종 직종세처리 
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
        
        
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_211.setLayout(frmlytSch); 
       
        srhDeptGpCd  =  new ComboBox<BaseModel>(); 
        srhDeptGpCd.setName("srhDeptGpCd");
        srhDeptGpCd.setForceSelection(true);
        srhDeptGpCd.setAllowBlank(false);
        srhDeptGpCd.setMinChars(1);
        srhDeptGpCd.setDisplayField("commCdNm");
        srhDeptGpCd.setValueField("commCd");
        srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
        srhDeptGpCd.setEmptyText("--그룹--");
        srhDeptGpCd.setSelectOnFocus(true); 
        srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhDeptGpCd.setStore(lsDeptGpCd);
        srhDeptGpCd.setFieldLabel("직종"); 
        
        
        layoutContainer_211.add(srhDeptGpCd, new FormData("100%")); 
        
           
        LayoutContainer layoutContainer_21 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_21.setLayout(frmlytSch);
       
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
        srhTypOccuCd.setHideLabel(true);
//        srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	
          	  EventType type = be.getType();
	    	   if (type == Store.Add) { 
	    		 //2015.11.30 추가 
	    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
	    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
	                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
	                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
	                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
	                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
	                      //         mdSelect = tpMdSelect;
	                         //  } 
	                     //  }  
	                   
	                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
	                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
	                   // }  
	                    
                }  
           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	//checkPayr4210Auth("srhTypOccuCd", lsTypOccuCd ); 
	    		   }
	    		   }
                
            }
        });     
        
        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
           @Override
          public void handleEvent(ComponentEvent ce) { 
                   
        	   //2015.11.30 추가 
          	 displayDtilOccuInttnCd(); 
                      
                  }  
          
                });  
         
        srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {   
                
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                   // GWT.log(" a" + ce.getEvent().getType());
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                  //  GWT.log(" b" + ce.getEvent().getType());
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                  //  GWT.log(" b" + ce.getEvent().getType());
                }  
            
            } 
        });
        
      //2015.11.30 추가 
        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent ce) {   
            	
            	displayDtilOccuInttnCd();
            } 
        }); 
        layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
        
        LayoutContainer lcSchRight = new LayoutContainer();
      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(1); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        frmlytSch.setDefaultWidth(0);
       // fieldSet.setLayout(layout);  
        lcSchRight.setLayout(frmlytSch);
        
        /** column 직종세코드 : dtilOccuInttnCd */ 
 
        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
        srhDtilOccuInttnCd.setWidth(100);
        srhDtilOccuInttnCd.setHideLabel(true);
        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
        srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
               
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                  //  GWT.log(" b" + ce.getEvent().getType());
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                  //  GWT.log(" b" + ce.getEvent().getType());
                } else {
                   
                }  
            
            } 
        });
        
        
        lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%")); 
        
        
        lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
        
        layoutContainer_21.setBorders(false);
          
   
        layoutContainer_13.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));// 지급구분
        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));// 부서
        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 직종
        
        fieldSet.add(layoutContainer_13);
        layoutContainer_13.setBorders(false); 
        
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_14 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer_14.setLayout(frmlytSch);
        
        srhPayCd =  new ComboBox<BaseModel>(); 
        srhPayCd.setName("srhPayCd");
        srhPayCd.setForceSelection(true);
        srhPayCd.setMinChars(1);
        srhPayCd.setDisplayField("commCdNm");
        srhPayCd.setValueField("commCd");
        srhPayCd.setTriggerAction(TriggerAction.ALL);
        srhPayCd.setEmptyText("--지급구분선택--");
        srhPayCd.setSelectOnFocus(true); 
        srhPayCd.setReadOnly(false);
        srhPayCd.setEnabled(true); 
        srhPayCd.setStore(lsPayCd);
        srhPayCd.setFieldLabel("지급구분");
        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	checkPayr4210Auth("srhPayCd",lsPayCd);   
              
            }
        });    
        srhPayCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
             BaseModel bmReattyApptnYr =  se.getSelectedItem(); 
             if (bmReattyApptnYr != null) {
           
                       
//                       IColumnFilter filters = null;
//                       reattyStpDsptyNumGridPanel.getTableDef().setTableColumnFilters(filters);
//         				
//                       reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"ReattyApptnYr")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
//           			 reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//           			 reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyYr", MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"ReattyApptnYr"), SimpleColumnFilter.OPERATOR_LIKE); 
//         			  
//                       reattyStpDsptyNumGridPanel.reload(); 
                      
              } 
      
            } 
        }); 
        
        layoutContainer_14.add(srhPayCd, new FormData("100%"));
       
        layoutContainer_14.setBorders(false);
        

        LayoutContainer layoutContainer_4 = new LayoutContainer();
        layoutContainer_4.setBorders(false);
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_4.setLayout(frmlytSch);
        
	    srhBusinCd = new ComboBox<BaseModel>();
	    srhBusinCd.setName("srhBusinCd");
	    srhBusinCd.setForceSelection(true);
	    srhBusinCd.setMinChars(1);
	    srhBusinCd.setDisplayField("businNm");
	    srhBusinCd.setValueField("businCd");
	    srhBusinCd.setTriggerAction(TriggerAction.ALL);
	    srhBusinCd.setEmptyText("--사업선택--");
	    srhBusinCd.setSelectOnFocus(true); 
	    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
	    srhBusinCd.setEnabled(true); 
	    srhBusinCd.setStore(lsBusinCd);
	    srhBusinCd.setFieldLabel("사업");
        layoutContainer_4.add(srhBusinCd, new FormData("100%"));
        
        
//        LayoutContainer layoutContainer_16 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);
        
        lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 성명
        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
	    
        
        fieldSet.add(lcSchCol3);
        
		
	    plFrmPayr4210.add(fieldSet); 
	//vp.add(panel);   
 }  


 
 private void  displayDtilOccuInttnCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
         
         //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
             
             sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
             List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
             String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
             sysComBass0350Dto.setDeptCd(strDeptCd);
             List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
             String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
             sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
             
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
             
             if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                 
                 lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
               //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                 
                 lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                         mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
                         srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                         
                         if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
                     	    ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
	  		                   
	  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
	  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
	  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
	  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
	  		                      //         mdSelect = tpMdSelect;
	  		                         //  } 
	  		                     //  }  	
	  		                   
                     	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
                     	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
	  		                   // }  
 	                 } 
                     }
                 });     
                 
             } 
          
       } else {
        
       } 
     //직종변경에 따른 직종세 값 가져오기
//     String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//     if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//         sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//         sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//         if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//             lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//             srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//         }
//     }   
 }
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/   
  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 기본등록화면 입력 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/  
 private void createStandardForm() {
      
		 
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		//fldstNewFieldset.setSize(330,335);
		
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("소급계산설정");
		fldstNewFieldset.setCollapsible(false);
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);
		
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		 frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		 
		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("소급계산");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_1.add(occupationalRight(),new FormData("100%"));
		 
 		plFrmPayr4210.add(layoutContainer);
		layoutContainer.setBorders(false);  
		
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.setBorders(false);
		 
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		 frmlytStd = new FormLayout();  
		 frmlytStd.setLabelWidth(0); 
		 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_6.setLayout(frmlytStd); 
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		//fldstNewFieldset_2.setSize(953, 200); 
		fldstNewFieldset_2.setHeadingHtml("소급계산결과내역");
		fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_2.setCollapsible(false);
		layoutContainer_6.add(fldstNewFieldset_2);
		
		
		fldstNewFieldset_2.add(occupationalBottom(),new FormData("100%")); 
		
		plFrmPayr4210.add(layoutContainer_6);
		layoutContainer_6.setBorders(false);
		
	  } 
 
   
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 기본등록화면 입력 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/   
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 
 private LayoutContainer occupationalLeft() {
	 
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
	 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(470, 250);   

	   //msfCustomForm.setHeaderVisible(false);
     //Instantiate the GridPanel
	   payr0360GridPanel = new MSFGridPanel(payr0360Def, false, false, false, false);
	   payr0360GridPanel.setHeaderVisible(false);  
	   payr0360GridPanel.setBodyBorder(true);
	   payr0360GridPanel.setBorders(true);
	//    payr0360GridPanel.setSize(936, 280);
  //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
 
	    cp01.add(payr0360GridPanel); 
	    
   
	    
	   lcTabFormLayer.add(cp01); 
	      
	   return lcTabFormLayer;
	 
}
 

class Tracker 
{
    public boolean status = false;
    public boolean getStatus(){return status;}
    public void setStatus(boolean stat){status = stat;}
}   
   
 
private LayoutContainer occupationalBottom() {
	
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
     
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(950, 190);   

	   //msfCustomForm.setHeaderVisible(false);
     //Instantiate the GridPanel
	   payr0350GridPanel = new MSFGridPanel(payr0350Def, false, false, false, false,false);
	   payr0350GridPanel.setHeaderVisible(false);  
	   payr0350GridPanel.setBodyBorder(true);
	   payr0350GridPanel.setBorders(true);
	//    payr0350GridPanel.setSize(936, 280);
  //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
 
	    cp01.add(payr0350GridPanel); 
	    
	    cp01.addButton(new Button("소급재계산", new SelectionListener<ButtonEvent>() {   
	  	      @Override  
	  	      public void componentSelected(ButtonEvent ce) {   
	  	         
	  	      //  if (MSFSharedUtils.paramNull(tgtSystemkey.getValue())) {
                  
             //     return;
            //  }
              payr0350GridPanel.getMsfGrid().clearData(); 
        
            //  if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
                 
                  final Tracker tracker = new Tracker();
                  tracker.setStatus(false);
                     
                  MessageBox.confirm("소급재계산", "선택하신 대상자의 기존 생성된 소급데이타를 삭제 후 다시 계산합니다.\n 소급재계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
                      @Override
                      public void handleEvent(MessageBoxEvent be) {
                      //    if("Yes".equals(be.getButtonClicked().getText())){
                    	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                            
                            //final SysComPsnl0100DTO dtoPsnl0100 = new SysComPsnl0100DTO();
	                           final ArrayList<PrgmComPsnl0100DTO> dtoListPsnl0100 = new ArrayList<PrgmComPsnl0100DTO>();  
	                           
	                           //값을레코드에 넣음.
	                            setListRecord(payr0350GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
	                           
	                            
	                            List<Payr0350DTO> listPayr0350dto = new ArrayList<Payr0350DTO>();  
	                            
	                            while (records.hasNext()) {
	                          
	                                Record record = (Record) records.next(); 
	                                BaseModel bmMapModel = (BaseModel)record.getModel();
	                                 
	                                PrgmComPsnl0100DTO dtoPsnl0100 = new PrgmComPsnl0100DTO();
	                                dtoPsnl0100.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));     /** column 사업장코드 : dpobCd */
                	            	dtoPsnl0100.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   //시스템키
                                    dtoPsnl0100.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));
                                    dtoPsnl0100.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));   //주민번호  
                                      
                                    dtoListPsnl0100.add(dtoPsnl0100); 
	                              
	                            }  
	                             
	                        	     
	                            Payr0360DTO dtoPayr0360 = new Payr0360DTO();  

								dtoPayr0360.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
								dtoPayr0360.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column 급여구분코드 : payCd */
								dtoPayr0360.setReattyYr(MSFSharedUtils.getSelectedComboValue(reattyYr,"year"));    /** column 소급년도 : reattyYr */
								dtoPayr0360.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(reattyStpDsptyNum.getValue()));    /** column 소급설정회차번호 : reattyStpDsptyNum */
								dtoPayr0360.setReattyApptnYrMnth((MSFSharedUtils.getSelectedComboValue(reattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(reattyApptnMnth,"month")));    /** column 소급계산년월 : reattyApptnYrMnth */
								dtoPayr0360.setReattyPymtDt(GWTUtils.getStringFromDate( reattyPymtDt.getValue() , "yyyyMMdd"));    /** column 소급지급일자 : reattyPymtDt */
								dtoPayr0360.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") );    /** column 고용구분코드 : emymtDivCd */
								dtoPayr0360.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));    /** column 급여관리부서코드 : payrMangDeptCd */
								
								dtoPayr0360.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));    /** column 관리부서코드 : mangeDeptCd */
								
								dtoPayr0360.setDeptCd(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));    /** column 부서코드 : deptCd */
								// PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")
								dtoPayr0360.setBusinCd( MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));    /** column 사업코드 : businCd */
								dtoPayr0360.setTypOccuCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));    /** column 직종코드 : typOccuCd */
								dtoPayr0360.setDtilOccuInttnCd(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd") );    /** column 직종세구분코드 : dtilOccuInttnCd */
								dtoPayr0360.setPymtMnthStp01( pymtMnthStp01.getValue());    /** column 지급월설정_01 : pymtMnthStp01 */
								dtoPayr0360.setPymtMnthStp02( pymtMnthStp02.getValue());    /** column 지급월설정_02 : pymtMnthStp02 */
								dtoPayr0360.setPymtMnthStp03( pymtMnthStp03.getValue());    /** column 지급월설정_03 : pymtMnthStp03 */
								dtoPayr0360.setPymtMnthStp04( pymtMnthStp04.getValue());    /** column 지급월설정_04 : pymtMnthStp04 */
								dtoPayr0360.setPymtMnthStp05( pymtMnthStp05.getValue());    /** column 지급월설정_05 : pymtMnthStp05 */
								dtoPayr0360.setPymtMnthStp06( pymtMnthStp06.getValue());    /** column 지급월설정_06 : pymtMnthStp06 */
								dtoPayr0360.setPymtMnthStp07( pymtMnthStp07.getValue());    /** column 지급월설정_07 : pymtMnthStp07 */
								dtoPayr0360.setPymtMnthStp08( pymtMnthStp08.getValue());    /** column 지급월설정_08 : pymtMnthStp08 */
								dtoPayr0360.setPymtMnthStp09( pymtMnthStp09.getValue());    /** column 지급월설정_09 : pymtMnthStp09 */
								dtoPayr0360.setPymtMnthStp10( pymtMnthStp10.getValue());    /** column 지급월설정_10 : pymtMnthStp10 */
								dtoPayr0360.setPymtMnthStp11( pymtMnthStp11.getValue());    /** column 지급월설정_11 : pymtMnthStp11 */
								dtoPayr0360.setPymtMnthStp12( pymtMnthStp12.getValue());    /** column 지급월설정_12 : pymtMnthStp12 */
								//dtoPayr0360.setTgtSystemkey(MSFSharedUtils.allowNulls(tgtSystemkey.getValue()));    /** column TGT_SYSTEMKEY : tgtSystemkey */
								dtoPayr0360.setReattyStpNoteCtnt(MSFSharedUtils.allowNulls(reattyStpNoteCtnt.getValue()));    /** column 소급설정내용 : reattyStpNoteCtnt */
							   
	                              if (!(reattyPymtPrcsYn.equals(true) && reattyDdlneYn.equals(true))) {
	                             	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                          "마감되거나 이미소급처리된 내역에 대해서는 소급을 계산할 수 없습니다.", null); 
	                                 return;
	                             }
	                           
                              
                              //급여 배치 호출 
                              //Progress bar for upload
                              final MessageBox box = MessageBox.wait("소급재계산", "소급대상자 소급반영처리 중 입니다...", "소급재계산 중...");
                              final Timer t = new Timer()
                              {
                                  public void run()
                                  {
                                      if (tracker.getStatus())
                                      {
                                          cancel();
                                          box.close();
                                      }
                                  }
                              };
                              t.scheduleRepeating(500); 
                              
                             payr4210Service.setPayr4210ToPayCalcSeft(dtoPayr0360, dtoListPsnl0100, actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
                                      public void onFailure(Throwable caught) {
                                          tracker.setStatus(true);
                                          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                                          ShowMessageBM smBm = new ShowMessageBM();
                                       	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
                                       	   smBm.setMenu("Payr");
                                       	   smBm.setPhase("[소급]에러");
                                       	   smBm.setMessage(caught.getLocalizedMessage());
                                       	   smBm.setContent(caught.getMessage());
                                       	   bmResult.add(smBm);  
                                       	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
                                       	   
                                              ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
                     		    			    
                   		    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
                   		    		       msFwMessage.show();
                   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                                         
                                        //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                         //         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4210ToPayCalcSeft(): "+caught), null);
                                      }

                                      public void onSuccess(PagingLoadResult<ShowMessageBM>  result) { 
                                          tracker.setStatus(true);
                                         // if (result == 0) { 
                                             // 오류를 리턴하는 경우 
                                          //    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"소급재계산이 정상적으로 이루어지지 않았습니다.", null);
                                             
                                         // } else {
                                              //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
                                          //    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"소급재계산이 정상적으로 처리되었습니다.", null);
                                          ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                 		    			    
                                        	MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
                                        	msFwMessage.show();
                                        	showMessageForm.setMSFFormWindows(msFwMessage);
                                              payr0350GridPanel.reload(); 
                                         // }
                                      }
                                  });
                                  
                          }
                      }
                  });   
              
                
            //  } else {
                  
                  //스케줄링을 선택하지 않은경우 메시지 처리 
             //     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
                  
            //  }    
	  	      }   
	  	    }));  
	    
	    cp01.addButton(new Button("대상자삭제", new SelectionListener<ButtonEvent>() {   
	  	      @Override  
	  	      public void componentSelected(ButtonEvent ce) {   
	  	         
	  	      //  if (MSFSharedUtils.paramNull(tgtSystemkey.getValue())) {
                
           //     return;
          //  }
      
      
          //  if (payr0350GridPanel.getCurrentlySelectedItem() != null) {   
               
                MessageBox.confirm("소급대상자삭제", "선택하신 근로자의 소급데이타를 삭제합니다.\n 선택하신 대상자를 하시겠습니까?",new Listener<MessageBoxEvent>(){
                    @Override
                    public void handleEvent(MessageBoxEvent be) {
                        //if("Yes".equals(be.getButtonClicked().getText())){
                    	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){ 
                        	
                            if (!(reattyPymtPrcsYn.equals(true) && reattyDdlneYn.equals(true))) {
                            	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                                         "마감되거나 이미소급처리된 내역에 대해서는 소급을 계산할 수 없습니다.", null); 
                                return;
                            }
                            
                            //값을레코드에 넣음.
                            setListRecord(payr0350GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
                           
                            
                            List<Payr0350DTO> listPayr0350dto = new ArrayList<Payr0350DTO>();  
                            
                            while (records.hasNext()) {
                          
                                Record record = (Record) records.next(); 
                                BaseModel bmMapModel = (BaseModel)record.getModel();
                                  
                                Payr0350DTO payr0350Dto = new Payr0350DTO();  
                                  
                                

								payr0350Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								payr0350Dto.setReattyYr(MSFSharedUtils.allowNulls(bmMapModel.get("reattyYr")));    /** column 소급년도 : reattyYr */
								payr0350Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));    /** column 급여구분코드 : payCd */
								payr0350Dto.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(bmMapModel.get("reattyStpDsptyNum")));    /** column 소급설정회차번호 : reattyStpDsptyNum */
								payr0350Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//								payr0350Dto.setReattyApptnSumJan(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumJan")));    /** column 소급적용금액_1월 : reattyApptnSumJan */
//								payr0350Dto.setReattyApptnSumFeb(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumFeb")));    /** column 소급적용금액_2월 : reattyApptnSumFeb */
//								payr0350Dto.setReattyApptnSumMar(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumMar")));    /** column 소급적용금액_3월 : reattyApptnSumMar */
//								payr0350Dto.setReattyApptnSumApr(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumApr")));    /** column 소급적용금액_4월 : reattyApptnSumApr */
//								payr0350Dto.setReattyApptnSumMay(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumMay")));    /** column 소급적용금액_5월 : reattyApptnSumMay */
//								payr0350Dto.setReattyApptnSumJun(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumJun")));    /** column 소급적용금액_6월 : reattyApptnSumJun */
//								payr0350Dto.setReattyApptnSumJul(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumJul")));    /** column 소급적용금액_7월 : reattyApptnSumJul */
//								payr0350Dto.setReattyApptnSumAug(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumAug")));    /** column 소급적용금액_8월 : reattyApptnSumAug */
//								payr0350Dto.setReattyApptnSumSep(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumSep")));    /** column 소급적용금액_9월 : reattyApptnSumSep */
//								payr0350Dto.setReattyApptnSumOct(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumOct")));    /** column 소급적용금액_10월 : reattyApptnSumOct */
//								payr0350Dto.setReattyApptnSumNov(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumNov")));    /** column 소급적용금액_11월 : reattyApptnSumNov */
//								payr0350Dto.setReattyApptnSumDec(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumDec")));    /** column 소급적용금액_12월 : reattyApptnSumDec */
//								payr0350Dto.setReattyApptnSumAggr(MSFSharedUtils.allowNulls(bmMapModel.get("reattyApptnSumAggr")));    /** column 소급적용금액합계 : reattyApptnSumAggr */
//								payr0350Dto.setReattyItemNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("reattyItemNoteCtnt")));    /** column 소급항목비고내용 : reattyItemNoteCtnt */
//								payr0350Dto.setReattyPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("reattyPymtYrMnth")));    /** column 소급적용년월 : reattyPymtYrMnth */
//								payr0350Dto.setReattyPymtPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("reattyPymtPrcsYn")));    /** column 소급지급처리여부 : reattyPymtPrcsYn */
//								payr0350Dto.setReattyDdlneDt(MSFSharedUtils.allowNulls(bmMapModel.get("reattyDdlneDt")));    /** column 소급마감일자 : reattyDdlneDt */
//								payr0350Dto.setReattyDdlneYn(MSFSharedUtils.allowNulls(bmMapModel.get("reattyDdlneYn")));    /** column 소급마감여부 : reattyDdlneYn */
//								payr0350Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//								payr0350Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//								payr0350Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//								payr0350Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//								payr0350Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//								payr0350Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
 

                                listPayr0350dto.add(payr0350Dto);
                              
                            }  
                            
                            if (listPayr0350dto.size() <= 0) {
                                
                                MessageBox.alert("저장",  "저장 할 데이타가 존재하지 않습니다.", null);
                                return;
                            }
                            
                            
                           payr4210Service.setPayr4210ToPayr0350Delete(listPayr0350dto, new AsyncCallback<Long>() {
                                    public void onFailure(Throwable caught) {
                                     
                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4210ToPayr0350Delete(): "+caught), null);
                                    }

                                    public void onSuccess(Long result) { 
                                       
                                        if (result == 0) { 
                                           // 오류를 리턴하는 경우 
                                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자 삭제가 정상적으로 이루어지지 않았습니다.", null);
                                           
                                        } else {
                                            //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
                                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자 삭제가 정상 처리되었습니다.", null);
                                            payr0350GridPanel.reload(); 
                                        }
                                    }
                                });
                                
                        }
                    }
                });   
            
              
          //  } else {
                
                //스케줄링을 선택하지 않은경우 메시지 처리 
           //     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
                
          //  }    
	  	      }   
	  	    })); 
	  	  
	    lcTabFormLayer.add(cp01); 
	     
		return lcTabFormLayer;     
   
} 

	 
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 
 private LayoutContainer occupationalRight() {
	   
	   dpobCd=  new HiddenField<String>();  /** column 사업장코드 : dpobCd */
	   reattyApptnYrMnth=  new HiddenField<String>();  /** column 소급적용년월 : reattyApptnYrMnth */
	   tgtSystemkey =  new HiddenField<String>();  
	   
	   reattyPymtYrMnth = new  HiddenField<String>();   /** column 지급년월 : reattyPymtYrMnth */
	   reattyPymtPrcsYn = new HiddenField<Boolean>();   /** column 소급지급처리여부 : reattyPymtPrcsYn */ 
	   reattyDdlneDt = new  HiddenField<String>();   /** column 소급마감일자 : reattyDdlneDt */ 
	   reattyDdlneYn = new HiddenField<Boolean>();   /** column 소급마감여부 : reattyDdlneYn */
	      
	      
	    msfCoCalendarDto = new SysCoCalendarDTO();
	    
	    
	    
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	    lscrReattyApptnYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	    lsReattyYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		    //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	    //월 
	    
	    lscrReattyApptnMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	       
	       
	   LayoutContainer lcTabFormLayer = new LayoutContainer();


	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FlowLayout());      
	   cp01.setSize(470, 250);
	    
	   cp01.addButton(new Button("설정저장", new SelectionListener<ButtonEvent>() {   
		      @Override  
		      public void componentSelected(ButtonEvent ce) {   
		         
	           //TODO 필수 입력 조건으로 체크하여 처리하는걸로 수정 
	           //   if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
	                 
	         
	                  MessageBox.confirm("소급계산설정변경", "소급계산설정변경내역을 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
	                      @Override
	                      public void handleEvent(MessageBoxEvent be) {
	                        //  if("Yes".equals(be.getButtonClicked().getText())){
	                    	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                             
//	                            setRecord(payr0250GridPanel.getCurrentlySelectedItem());  
//	                              
	                            Payr0360DTO dtoPayr0360 = new Payr0360DTO();  

								dtoPayr0360.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
								dtoPayr0360.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column 급여구분코드 : payCd */
								dtoPayr0360.setReattyYr(MSFSharedUtils.getSelectedComboValue(reattyYr,"year"));    /** column 소급년도 : reattyYr */
								dtoPayr0360.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(reattyStpDsptyNum.getValue()));    /** column 소급설정회차번호 : reattyStpDsptyNum */
								dtoPayr0360.setReattyApptnYrMnth((MSFSharedUtils.getSelectedComboValue(reattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(reattyApptnMnth,"month")));    /** column 소급계산년월 : reattyApptnYrMnth */
								dtoPayr0360.setReattyPymtDt(GWTUtils.getStringFromDate( reattyPymtDt.getValue() , "yyyyMMdd"));    /** column 소급지급일자 : reattyPymtDt */
								dtoPayr0360.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") );    /** column 고용구분코드 : emymtDivCd */
								dtoPayr0360.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));    /** column 급여관리부서코드 : payrMangDeptCd */

								dtoPayr0360.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));    /** column 관리부서코드 : mangeDeptCd */
								
								
								dtoPayr0360.setDeptCd(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));    /** column 부서코드 : deptCd */
								// PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")
								dtoPayr0360.setBusinCd( MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));    /** column 사업코드 : businCd */
								dtoPayr0360.setTypOccuCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));    /** column 직종코드 : typOccuCd */
								dtoPayr0360.setDtilOccuInttnCd(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd") );    /** column 직종세구분코드 : dtilOccuInttnCd */
								dtoPayr0360.setPymtMnthStp01( pymtMnthStp01.getValue());    /** column 지급월설정_01 : pymtMnthStp01 */
								dtoPayr0360.setPymtMnthStp02( pymtMnthStp02.getValue());    /** column 지급월설정_02 : pymtMnthStp02 */
								dtoPayr0360.setPymtMnthStp03( pymtMnthStp03.getValue());    /** column 지급월설정_03 : pymtMnthStp03 */
								dtoPayr0360.setPymtMnthStp04( pymtMnthStp04.getValue());    /** column 지급월설정_04 : pymtMnthStp04 */
								dtoPayr0360.setPymtMnthStp05( pymtMnthStp05.getValue());    /** column 지급월설정_05 : pymtMnthStp05 */
								dtoPayr0360.setPymtMnthStp06( pymtMnthStp06.getValue());    /** column 지급월설정_06 : pymtMnthStp06 */
								dtoPayr0360.setPymtMnthStp07( pymtMnthStp07.getValue());    /** column 지급월설정_07 : pymtMnthStp07 */
								dtoPayr0360.setPymtMnthStp08( pymtMnthStp08.getValue());    /** column 지급월설정_08 : pymtMnthStp08 */
								dtoPayr0360.setPymtMnthStp09( pymtMnthStp09.getValue());    /** column 지급월설정_09 : pymtMnthStp09 */
								dtoPayr0360.setPymtMnthStp10( pymtMnthStp10.getValue());    /** column 지급월설정_10 : pymtMnthStp10 */
								dtoPayr0360.setPymtMnthStp11( pymtMnthStp11.getValue());    /** column 지급월설정_11 : pymtMnthStp11 */
								dtoPayr0360.setPymtMnthStp12( pymtMnthStp12.getValue());    /** column 지급월설정_12 : pymtMnthStp12 */
								//dtoPayr0360.setTgtSystemkey(MSFSharedUtils.allowNulls(tgtSystemkey.getValue()));    /** column TGT_SYSTEMKEY : tgtSystemkey */
								dtoPayr0360.setReattyStpNoteCtnt(MSFSharedUtils.allowNulls(reattyStpNoteCtnt.getValue()));    /** column 소급설정내용 : reattyStpNoteCtnt */
							   
	                              if (!(reattyPymtPrcsYn.equals(true) && reattyDdlneYn.equals(true))) {
	                             	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                          "마감되거나 이미소급처리된 내역에 대해서는 소급을 계산할 수 없습니다.", null); 
	                                 return;
	                             }
	                            
	                             payr4210Service.setPayr4210TPayr0360Update(dtoPayr0360, actionDatabase, new AsyncCallback<Long>() {
	                                      public void onFailure(Throwable caught) {
	                                    
	                                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                                  MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4210TPayr0360Update(): "+caught), null);
	                                      }

	                                      public void onSuccess(Long result) { 
	                                       
	                                          if (result == 0) { 
	                                             // 오류를 리턴하는 경우 
	                                              MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"저장이 정상적으로 이루어지지 않았습니다.", null);
	                                             
	                                          } else {
	                                              //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
	                                              MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"저장이 정상 처리되었습니다.", null);
	                                              payr0360GridPanel.reload(); 
	                                          }
	                                      }
	                                  });
	                                  
	                          }
	                      }
	                  });   
	             
	               
	                    // 
	           
	                
	            //  } else {
	                  
	                  //스케줄링을 선택하지 않은경우 메시지 처리 
	            //      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
	                  
	            //  }
	     
		      }   
		    }));  
	   cp01.addButton(new Button("소급개별계산", new SelectionListener<ButtonEvent>() {   
		      @Override  
		      public void componentSelected(ButtonEvent ce) {   
		         
		          //하단결과그리드 초기화 
		          payr0350GridPanel.getMsfGrid().clearData(); 
	           //TODO 필수 입력 조건으로 체크하여 처리하는걸로 수정 
	           //   if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
	                 
	                  final Tracker tracker = new Tracker();
	                  tracker.setStatus(false);
	                     
	                  MessageBox.confirm("소급개별계산", "소급개별계산을 하시면 기존 생성된 소급내역에 대상자를 계산하여 추가합니다.\n 선택된 대상자를 소급계산 하시겠습니까?",new Listener<MessageBoxEvent>(){
	                      @Override
	                      public void handleEvent(MessageBoxEvent be) {
	                         // if("Yes".equals(be.getButtonClicked().getText())){
	                    	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                        	   
	                        	//final SysComPsnl0100DTO dtoPsnl0100 = new SysComPsnl0100DTO();
	                           final ArrayList<PrgmComPsnl0100DTO> dtoListPsnl0100 = new ArrayList<PrgmComPsnl0100DTO>(); 
	                        	  
	                    	    MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form();  //인사  
	                    	    
	                    	    final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	                    	   
	                    	    popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	                    	    public void handleEvent(BaseEvent be) { 
	                    	        	
	                    	                List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	                    	                  
	                    	                  if (mapModels != null) { 
	                    	                        
	                    	                      if (mapModels.size() > 1) {
	                    	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                    	                               "한건의 데이타만 선택가능합니다. 데이타를 확인하십시요.", null);
	                    	                          return;
	                    	                      }
	                    	                      
	                    	                       
	                    	                      Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
	                    	                      while (iterRecords.hasNext()) {
	                    	                            BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
	                    	                           
	                    	                            PrgmComPsnl0100DTO dtoPsnl0100 = new PrgmComPsnl0100DTO();
	                    	                              dtoPsnl0100.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));     /** column 사업장코드 : dpobCd */
		      	                    	            	  dtoPsnl0100.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   //시스템키
		      	                                          dtoPsnl0100.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));
		      	                                          dtoPsnl0100.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));   //주민번호  
		      	                                          
		      	                                        dtoListPsnl0100.add(dtoPsnl0100);
	                    	                              
	                    	                      }   
	                    	                  }
	                    	        }
	                    	    });
	                        	     
	                            Payr0360DTO dtoPayr0360 = new Payr0360DTO();  

								dtoPayr0360.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
								dtoPayr0360.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column 급여구분코드 : payCd */
								dtoPayr0360.setReattyYr(MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year"));    /** column 소급년도 : reattyYr */
								dtoPayr0360.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(reattyStpDsptyNum.getValue()));    /** column 소급설정회차번호 : reattyStpDsptyNum */
								dtoPayr0360.setReattyApptnYrMnth((MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")));    /** column 소급계산년월 : reattyApptnYrMnth */
								dtoPayr0360.setReattyPymtDt(GWTUtils.getStringFromDate( reattyPymtDt.getValue() , "yyyyMMdd"));    /** column 소급지급일자 : reattyPymtDt */
								dtoPayr0360.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") );    /** column 고용구분코드 : emymtDivCd */
								dtoPayr0360.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));    /** column 급여관리부서코드 : payrMangDeptCd */

								dtoPayr0360.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));    /** column 관리부서코드 : mangeDeptCd */
								
								
								dtoPayr0360.setDeptCd(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));    /** column 부서코드 : deptCd */
								// PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")
								dtoPayr0360.setBusinCd( MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));    /** column 사업코드 : businCd */
								dtoPayr0360.setTypOccuCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));    /** column 직종코드 : typOccuCd */
								dtoPayr0360.setDtilOccuInttnCd(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd") );    /** column 직종세구분코드 : dtilOccuInttnCd */
								dtoPayr0360.setPymtMnthStp01( pymtMnthStp01.getValue());    /** column 지급월설정_01 : pymtMnthStp01 */
								dtoPayr0360.setPymtMnthStp02( pymtMnthStp02.getValue());    /** column 지급월설정_02 : pymtMnthStp02 */
								dtoPayr0360.setPymtMnthStp03( pymtMnthStp03.getValue());    /** column 지급월설정_03 : pymtMnthStp03 */
								dtoPayr0360.setPymtMnthStp04( pymtMnthStp04.getValue());    /** column 지급월설정_04 : pymtMnthStp04 */
								dtoPayr0360.setPymtMnthStp05( pymtMnthStp05.getValue());    /** column 지급월설정_05 : pymtMnthStp05 */
								dtoPayr0360.setPymtMnthStp06( pymtMnthStp06.getValue());    /** column 지급월설정_06 : pymtMnthStp06 */
								dtoPayr0360.setPymtMnthStp07( pymtMnthStp07.getValue());    /** column 지급월설정_07 : pymtMnthStp07 */
								dtoPayr0360.setPymtMnthStp08( pymtMnthStp08.getValue());    /** column 지급월설정_08 : pymtMnthStp08 */
								dtoPayr0360.setPymtMnthStp09( pymtMnthStp09.getValue());    /** column 지급월설정_09 : pymtMnthStp09 */
								dtoPayr0360.setPymtMnthStp10( pymtMnthStp10.getValue());    /** column 지급월설정_10 : pymtMnthStp10 */
								dtoPayr0360.setPymtMnthStp11( pymtMnthStp11.getValue());    /** column 지급월설정_11 : pymtMnthStp11 */
								dtoPayr0360.setPymtMnthStp12( pymtMnthStp12.getValue());    /** column 지급월설정_12 : pymtMnthStp12 */
								//dtoPayr0360.setTgtSystemkey(MSFSharedUtils.allowNulls(tgtSystemkey.getValue()));    /** column TGT_SYSTEMKEY : tgtSystemkey */
								dtoPayr0360.setReattyStpNoteCtnt(MSFSharedUtils.allowNulls(reattyStpNoteCtnt.getValue()));    /** column 소급설정내용 : reattyStpNoteCtnt */
							   
	                              if (!(reattyPymtPrcsYn.equals(true) && reattyDdlneYn.equals(true))) {
	                             	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                          "마감되거나 이미소급처리된 내역에 대해서는 소급을 계산할 수 없습니다.", null); 
	                                 return;
	                             }
	                           
	                              //급여 배치 호출 
	                              //Progress bar for upload
	                              final MessageBox box = MessageBox.wait("소급개별계산", "소급대상자 소급반영처리 중 입니다...", "소급개별계산 중...");
	                              final Timer t = new Timer()
	                              {
	                                  public void run()
	                                  {
	                                      if (tracker.getStatus())
	                                      {
	                                          cancel();
	                                          box.close();
	                                      }
	                                  }
	                              };
	                              t.scheduleRepeating(500);
	                              
	                             payr4210Service.setPayr4210ToPayCalcSeft(dtoPayr0360, dtoListPsnl0100,   actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
	                                      public void onFailure(Throwable caught) {
	                                          tracker.setStatus(true);
	                                          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	                                          ShowMessageBM smBm = new ShowMessageBM();
	                                       	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
	                                       	   smBm.setMenu("Payr");
	                                       	   smBm.setPhase("[소급]에러");
	                                       	   smBm.setMessage(caught.getLocalizedMessage());
	                                       	   smBm.setContent(caught.getMessage());
	                                       	   bmResult.add(smBm);  
	                                       	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
	                                       	   
	                                              ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
	                     		    			    
	                   		    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	                   		    		       msFwMessage.show();
	                   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
	                                          //MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                            //      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4210ToPayCalculation(): "+caught), null);
	                                      }

	                                      public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
	                                          tracker.setStatus(true);
	                                         // if (result == 0) { 
	                                             // 오류를 리턴하는 경우 
	                                           //   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"소급개별계산이 정상적으로 이루어지지 않았습니다.", null);
	                                             
	                                          //} else {
	                                              //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
	                                            //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"소급개별계산이 정상적으로 처리되었습니다.", null);
	                                            ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	                 		    			    
	                                          	MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	                                          	msFwMessage.show();
	                                          	showMessageForm.setMSFFormWindows(msFwMessage);
	                                              payr0350GridPanel.reload(); 
	                                          //}
	                                      }
	                                  });
	                                  
	                          }
	                      }
	                  });   
	             
	               
	                    // 
	           
	                
	            //  } else {
	                  
	                  //스케줄링을 선택하지 않은경우 메시지 처리 
	            //      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
	                  
	            //  }
	     
		      }   
		    }));  
	   
	   cp01.addButton(new Button("소급일괄계산", new SelectionListener<ButtonEvent>() {   
		      @Override  
		      public void componentSelected(ButtonEvent ce) {   
		         
		          //하단결과그리드 초기화 
		          payr0350GridPanel.getMsfGrid().clearData(); 
	           //TODO 필수 입력 조건으로 체크하여 처리하는걸로 수정 
	           //   if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
	                 
	                  final Tracker tracker = new Tracker();
	                  tracker.setStatus(false);
	                     
	                  MessageBox.confirm("소급일괄계산", "소급일괄계산을 하시면 기존 생성된 소급데이타를 삭제 후 다시 계산합니다.\n 소급일괄계산(재직자)을 하시겠습니까?",new Listener<MessageBoxEvent>(){
	                      @Override
	                      public void handleEvent(MessageBoxEvent be) {
	                       //   if("Yes".equals(be.getButtonClicked().getText())){
	                    	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                             
//	                            setRecord(payr0250GridPanel.getCurrentlySelectedItem());  
//	                              
	                            Payr0360DTO dtoPayr0360 = new Payr0360DTO();  

								dtoPayr0360.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
								dtoPayr0360.setPayCd(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column 급여구분코드 : payCd */
								dtoPayr0360.setReattyYr(MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year"));    /** column 소급년도 : reattyYr */
								dtoPayr0360.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(reattyStpDsptyNum.getValue()));    /** column 소급설정회차번호 : reattyStpDsptyNum */
								dtoPayr0360.setReattyApptnYrMnth((MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")));    /** column 소급계산년월 : reattyApptnYrMnth */
								dtoPayr0360.setReattyPymtDt(GWTUtils.getStringFromDate( reattyPymtDt.getValue() , "yyyyMMdd"));    /** column 소급지급일자 : reattyPymtDt */
								dtoPayr0360.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") );    /** column 고용구분코드 : emymtDivCd */
								dtoPayr0360.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));    /** column 급여관리부서코드 : payrMangDeptCd */

								dtoPayr0360.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));    /** column 관리부서코드 : mangeDeptCd */
								
								
								dtoPayr0360.setDeptCd(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));    /** column 부서코드 : deptCd */
								// PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")
								dtoPayr0360.setBusinCd( MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));    /** column 사업코드 : businCd */
								dtoPayr0360.setTypOccuCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));    /** column 직종코드 : typOccuCd */
								dtoPayr0360.setDtilOccuInttnCd(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd") );    /** column 직종세구분코드 : dtilOccuInttnCd */
								dtoPayr0360.setPymtMnthStp01( pymtMnthStp01.getValue());    /** column 지급월설정_01 : pymtMnthStp01 */
								dtoPayr0360.setPymtMnthStp02( pymtMnthStp02.getValue());    /** column 지급월설정_02 : pymtMnthStp02 */
								dtoPayr0360.setPymtMnthStp03( pymtMnthStp03.getValue());    /** column 지급월설정_03 : pymtMnthStp03 */
								dtoPayr0360.setPymtMnthStp04( pymtMnthStp04.getValue());    /** column 지급월설정_04 : pymtMnthStp04 */
								dtoPayr0360.setPymtMnthStp05( pymtMnthStp05.getValue());    /** column 지급월설정_05 : pymtMnthStp05 */
								dtoPayr0360.setPymtMnthStp06( pymtMnthStp06.getValue());    /** column 지급월설정_06 : pymtMnthStp06 */
								dtoPayr0360.setPymtMnthStp07( pymtMnthStp07.getValue());    /** column 지급월설정_07 : pymtMnthStp07 */
								dtoPayr0360.setPymtMnthStp08( pymtMnthStp08.getValue());    /** column 지급월설정_08 : pymtMnthStp08 */
								dtoPayr0360.setPymtMnthStp09( pymtMnthStp09.getValue());    /** column 지급월설정_09 : pymtMnthStp09 */
								dtoPayr0360.setPymtMnthStp10( pymtMnthStp10.getValue());    /** column 지급월설정_10 : pymtMnthStp10 */
								dtoPayr0360.setPymtMnthStp11( pymtMnthStp11.getValue());    /** column 지급월설정_11 : pymtMnthStp11 */
								dtoPayr0360.setPymtMnthStp12( pymtMnthStp12.getValue());    /** column 지급월설정_12 : pymtMnthStp12 */
								//dtoPayr0360.setTgtSystemkey(MSFSharedUtils.allowNulls(tgtSystemkey.getValue()));    /** column TGT_SYSTEMKEY : tgtSystemkey */
								dtoPayr0360.setReattyStpNoteCtnt(MSFSharedUtils.allowNulls(reattyStpNoteCtnt.getValue()));    /** column 소급설정내용 : reattyStpNoteCtnt */
							   
	                              if (!(reattyPymtPrcsYn.equals(true) && reattyDdlneYn.equals(true))) {
	                             	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                          "마감되거나 이미소급처리된 내역에 대해서는 소급을 계산할 수 없습니다.", null); 
	                                 return;
	                             }
	                           
	                              //급여 배치 호출 
	                              //Progress bar for upload
	                              final MessageBox box = MessageBox.wait("소급일괄계산", "소급대상자 소급반영처리 중 입니다...", "소급일괄계산 중...");
	                              final Timer t = new Timer()
	                              {
	                                  public void run()
	                                  {
	                                      if (tracker.getStatus())
	                                      {
	                                          cancel();
	                                          box.close();
	                                      }
	                                  }
	                              };
	                              t.scheduleRepeating(500);
	                              
	                             payr4210Service.setPayr4210ToPayCalculation(dtoPayr0360, actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM> >() {
	                                      public void onFailure(Throwable caught) {
	                                          tracker.setStatus(true);
	                                          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                                              ShowMessageBM smBm = new ShowMessageBM();
	                                       	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
	                                       	   smBm.setMenu("Payr");
	                                       	   smBm.setPhase("[소급]에러");
	                                       	   smBm.setMessage(caught.getLocalizedMessage());
	                                       	   smBm.setContent(caught.getMessage());
	                                       	   bmResult.add(smBm);  
	                                       	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
	                                       	   
	                                              ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
	                     		    			    
	                   		    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	                   		    		       msFwMessage.show();
	                   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                                             
	                                         // MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                          //        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4210ToPayCalculation(): "+caught), null);
	                                      }

	                                      public void onSuccess(PagingLoadResult<ShowMessageBM>  result) { 
	                                          tracker.setStatus(true);
	                                         // if (result == 0) { 
	                                             // 오류를 리턴하는 경우 
	                                            //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"소급일괄계산이 정상적으로 이루어지지 않았습니다.", null);
	                                             
	                                         // } else {
	                                              //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
	                                          //    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"소급일괄계산이 정상적으로 처리되었습니다.", null);
	                                            ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                   		    			    
	                                          	MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	                                          	msFwMessage.show();
	                                          	showMessageForm.setMSFFormWindows(msFwMessage);
	                                              payr0350GridPanel.reload(); 
	                                         // }
	                                      }
	                                  });
	                                  
	                          }
	                      }
	                  });   
	             
	               
	                    // 
	           
	                
	            //  } else {
	                  
	                  //스케줄링을 선택하지 않은경우 메시지 처리 
	            //      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
	                  
	            //  }
	     
		      }   
		    }));  
	  
	   LayoutContainer layoutContainer21 = new LayoutContainer(new ColumnLayout());
	   layoutContainer21.setBorders(false);
	    
	   
	   LayoutContainer lc11 = new LayoutContainer();
	   FormLayout fl1 = new FormLayout();
	   fl1.setLabelWidth(70);
	   fl1.setLabelAlign(LabelAlign.RIGHT);
	   lc11.setLayout(fl1);
	   
	   
	   LayoutContainer lcSchLeft = new LayoutContainer(); 
       lcSchLeft.setLayout(new ColumnLayout());
       
       LayoutContainer layoutContainer_8 = new LayoutContainer();
       FormLayout frmlytSch = new FormLayout();  
       frmlytSch.setLabelWidth(70); 
       frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
       layoutContainer_8.setLayout(frmlytSch);
       
       reattyYr = new MSFComboBox<BaseModel>();
       reattyYr.setName("reattyYr");
       reattyYr.setForceSelection(true);
       reattyYr.setMinChars(1);
       reattyYr.setDisplayField("yearDisp");
       reattyYr.setValueField("year");
       reattyYr.setTriggerAction(TriggerAction.ALL);
      // reattyYr.setEmptyText("--년도선택--");
       reattyYr.setSelectOnFocus(true); 
       reattyYr.setReadOnly(false);
       reattyYr.setEnabled(true); 
       reattyYr.setStore(lsReattyYr);
       reattyYr.setFieldLabel("소급년도"); 
       reattyYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
           public void handleEvent(StoreEvent<BaseModel> be) {  
 
        	 
             
           }
       });
//       reattyYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//             public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                 //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//              BaseModel bmReattyApptnYr =  se.getSelectedItem(); 
//              if (bmReattyApptnYr != null) {
//                   
//                        
////                        IColumnFilter filters = null;
////                        reattyStpDsptyNumGridPanel.getTableDef().setTableColumnFilters(filters); 
////            			reattyStpDsptyNumGridPanel.getTableDef().addColumnFilter("reattyYr", MSFSharedUtils.getSelectedComboValue(reattyYr,"ReattyApptnYr"), SimpleColumnFilter.OPERATOR_LIKE); 
////          			  
////                        reattyStpDsptyNumGridPanel.reload(); 
//                        
//                
//              }       
//             } 
//         });   
       layoutContainer_8.add(reattyYr, new FormData("100%"));
       lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
       layoutContainer_8.setBorders(false);
       
       LayoutContainer layoutContainer1_9 = new LayoutContainer();
       frmlytSch = new FormLayout();  
       frmlytSch.setLabelWidth(0); 
       frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
       layoutContainer1_9.setLayout(frmlytSch);
       
	   LayoutContainer layoutContainer_69 = new LayoutContainer();
	   FormLayout  frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(70); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_69.setLayout(frmlytStd);
     
	   reattyStpDsptyNum = new MSFTextField();
	   reattyStpDsptyNum.setReadOnly(true); 
	   reattyStpDsptyNum.setHideLabel(true); 
	 
	   
       layoutContainer1_9.add(reattyStpDsptyNum, new FormData("100%"));
       lcSchLeft.add(layoutContainer1_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(3));
       layoutContainer1_9.setBorders(false);
       
	   
	   LayoutContainer lc1_1 = new LayoutContainer(new ColumnLayout());
	   
	   LayoutContainer lc1_1_1 = new LayoutContainer();
	   FormLayout fl1_1 = new FormLayout();
	   fl1_1.setLabelWidth(60);
	   fl1_1.setLabelAlign(LabelAlign.RIGHT);
	   lc1_1_1.setLayout(fl1_1);
	   
	   reattyApptnYr = new  MSFComboBox<BaseModel>();
	   reattyApptnYr.setName("reattyApptnYr");
	   reattyApptnYr.setFieldLabel("지급년월");
	   reattyApptnYr.setForceSelection(true);
	   reattyApptnYr.setMinChars(1);
	   reattyApptnYr.setDisplayField("yearDisp");
	   reattyApptnYr.setValueField("year");
	   reattyApptnYr.setTriggerAction(TriggerAction.ALL);
	   reattyApptnYr.setEmptyText("--지급년도--");
	   reattyApptnYr.setSelectOnFocus(true);
	   reattyApptnYr.setStore(lscrReattyApptnYr);
	   reattyApptnYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	       public void handleEvent(StoreEvent<BaseModel> be) {  

	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4210Auth("reattyApptnYr", lscrReattyApptnYr); 
               	 }
		       
	       }
	   });
	    
	   lc1_1_1.add(reattyApptnYr, new FormData("100%"));
	   
	   
	   LayoutContainer lc1_1_2 = new LayoutContainer();
	   FormLayout fl1_2 = new FormLayout();
	   fl1_2.setLabelWidth(0);
	   fl1_2.setLabelAlign(LabelAlign.RIGHT);
	   lc1_1_2.setLayout(fl1_2);
	  
	   reattyApptnMnth = new MSFComboBox<BaseModel>();
	   reattyApptnMnth.setName("reattyApptnMnth");
	   reattyApptnMnth.setHideLabel(true);
	   reattyApptnMnth.setForceSelection(true);
	   reattyApptnMnth.setMinChars(1);
	   reattyApptnMnth.setDisplayField("monthDisp");
	   reattyApptnMnth.setValueField("month");
	   reattyApptnMnth.setTriggerAction(TriggerAction.ALL);
	   reattyApptnMnth.setEmptyText("--월--");
	   reattyApptnMnth.setSelectOnFocus(true); 
	   reattyApptnMnth.setStore(lscrReattyApptnMnth);
	   reattyApptnMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	       public void handleEvent(StoreEvent<BaseModel> be) {  
	    	   checkPayr4210Auth("reattyApptnMnth", lscrReattyApptnMnth); 
	         //  GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
	       }
	   });
	   reattyApptnMnth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	       public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	           //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        BaseModel bmMonth =  se.getSelectedItem(); 
	        if (bmMonth != null) { 
	            
	            if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(reattyApptnYr,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(reattyApptnMnth,"month"))) {
	              //  setInitDate();
	            }
	            
	        }       
	       } 
	   });   
	   
	  
	   
	   lc1_1_2.add(reattyApptnMnth, new FormData("100%"));
	    
	   
	   lc1_1.add(lc1_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	   lc1_1.add(lc1_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
	   
	   lc11.add(lc1_1, new FormData("100%"));
	    
	   
	   LayoutContainer lc21 = new LayoutContainer();
	   FormLayout fl2 = new FormLayout();
	   fl2.setLabelWidth(80);
	   fl2.setLabelAlign(LabelAlign.RIGHT);
	   lc21.setLayout(fl2);
	   
	   LayoutContainer lc2_1 = new LayoutContainer(); 
	   FormLayout fl2_1 = new FormLayout();
	   fl2_1.setLabelWidth(70);
	   fl2_1.setLabelAlign(LabelAlign.RIGHT);
	   lc2_1.setLayout(fl2_1);

	    
	   reattyPymtDt = new MSFDateField();
	   reattyPymtDt.setName("reattyPymtDt");
	   new DateFieldMask(reattyPymtDt, "9999.99.99"); 
	   reattyPymtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	   reattyPymtDt.setFieldLabel("지급일자");
	 //  reattyPymtDt.setValue(value);
	 
	   lc2_1.add(reattyPymtDt, new FormData("100%")); 
	   lc21.add(lc2_1, new FormData("100%")); 
	   
	   
	   layoutContainer21.add(lc11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer21.add(lc21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   
	  
	   LayoutContainer layoutContainer41 = new LayoutContainer(new ColumnLayout());
	   layoutContainer41.setBorders(false);
	    
	   
	   LayoutContainer lc41 = new LayoutContainer();
	   FormLayout fl4 = new FormLayout();
	   fl4.setLabelWidth(60);
	   fl4.setLabelAlign(LabelAlign.RIGHT);
	   lc41.setLayout(fl4);

	   payCd = new MSFComboBox<BaseModel>();
	   payCd.setName("payCd");
	   payCd.setFieldLabel("지급구분");
	   payCd.setForceSelection(true);
	   payCd.setMinChars(1);
	   payCd.setDisplayField("commCdNm");
	   payCd.setValueField("commCd");
	   payCd.setTriggerAction(TriggerAction.ALL);
	   payCd.setEmptyText("--지급구분선택--");
	   payCd.setSelectOnFocus(true);
	   payCd.setStore(lscrPayCd);
	 //  payCd.setReadOnly(true);
	   payCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	       public void handleEvent(StoreEvent<BaseModel> be) {  
 
	           EventType type = be.getType();
	    	   if (type == Store.Add) { 
           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	checkPayr4210Auth("payCd", lscrPayCd); 
           	 }
	           
	       }
	   });
	   
	   lc41.add(payCd, new FormData("100%")); 
	    
	   
	   
//	   LayoutContainer layoutContainer_5_1 = new LayoutContainer();
//	   layoutContainer_5_1.setLayout(new ColumnLayout());  
	   //layoutContainer_5_1.setStyleAttribute("paddingTop", "10px"); 
	   
//	   LayoutContainer layoutContainer_6_1 = new LayoutContainer();
//	   FormLayout frmlytSch = new FormLayout();  
//	   frmlytSch.setLabelWidth(70); 
//	   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	   layoutContainer_6_1.setLayout(frmlytSch);
//	   layoutContainer_6_1.setBorders(false);
	     
	   LayoutContainer layoutContainer_6 = new LayoutContainer();
	   frmlytSch = new FormLayout();  
	   frmlytSch.setLabelWidth(70); 
	   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	   layoutContainer_6.setLayout(frmlytSch); 
	   layoutContainer_6.setBorders(false);

	   
	   /** column 단위기관 : payrMangDeptCd */
	   payrMangDeptCd = new MSFComboBox<BaseModel>();
	   payrMangDeptCd.setName("payrMangDeptCd"); 
	   payrMangDeptCd.setForceSelection(true);
	   payrMangDeptCd.setMinChars(1);
	   payrMangDeptCd.setDisplayField("payrMangDeptNm");
	   payrMangDeptCd.setValueField("payrMangDeptCd");
	   payrMangDeptCd.setTriggerAction(TriggerAction.ALL);
	   payrMangDeptCd.setEmptyText("--단위기관선택--");
	   payrMangDeptCd.setSelectOnFocus(true); 
	   payrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
	   payrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
	   payrMangDeptCd.setStore(lscrPayrMangDeptCd);  
	   payrMangDeptCd.setFieldLabel("단위기관"); 
	   lscrPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	       public void handleEvent(StoreEvent<BaseModel> be) {  

	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4210Auth("payrMangDeptCd", lscrPayrMangDeptCd); 
               	 }  
	           
	       }
	   });    
	   payrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	       public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	           //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	            sysComBass0400Dto.setDeptDspyYn("Y");
	           sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(payrMangDeptCd,"payrMangDeptCd"));
	           //--------------------부서 불러 오는 함수 ------------------------------------------------
	           lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	           //--------------------부서 불러 오는 함수 ------------------------------------------------
	           lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	              public void handleEvent(StoreEvent<BaseModel> be) {  
	                mDtalistcrDeptCd = PayrUtils.getDeptCdModelData(lscrDeptCd) ; 
	                deptCd.getInitStore().add(mDtalistcrDeptCd);
	                  
	              }
	           });   
	       } 
	   });
	   layoutContainer_6.add(payrMangDeptCd, new FormData("100%")); 
	   
	   
	   
//	   hanNm = new MSFTextField();
//	   layoutContainer_6.add(hanNm, new FormData("100%"));
//	   hanNm.addKeyListener(new KeyListener() {
//	       public void componentKeyUp(ComponentEvent event) {
//	           super.componentKeyUp(event);
//	           hanNm.validate();
//	           if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	               tgtSystemkey.setValue("");
//	               resnRegnNum.setValue(""); 
//	               fnCreatePsnl0100() ;
//	           }
//	       }
//	    });
//	   hanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	       @Override
//	       public void handleEvent(BaseEvent be) {  
//	           if (MSFSharedUtils.allowNulls(hanNm.getValue()).trim().equals("")) {
//	               tgtSystemkey.setValue("");
//	               resnRegnNum.setValue(""); 
//	           }
//	        
//	       } 
//	 }); 
//	   hanNm.setFieldLabel("성명"); 

//	   
//	   Button btnHanNm = new Button("검색"); 
//	   btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
//	       public void handleEvent(ButtonEvent e) {
//	           tgtSystemkey.setValue("");
//	           resnRegnNum.setValue(""); 
//	           fnCreatePsnl0100() ;
//	             
//	       }
//	   });
//	   
//	   LayoutContainer layoutContainer_7_1 = new LayoutContainer();
//	   frmlytSch = new FormLayout();  
//	   frmlytSch.setLabelWidth(0); 
//	   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	   layoutContainer_7_1.setLayout(frmlytSch);
//	   
//	   /** column 주민등록번호 : resnRegnNum */
//	   resnRegnNum = new MSFTextField();
//	   resnRegnNum.setHideLabel(true);
//	   new TextFieldMask<String>(resnRegnNum, "999999-9999999");
//	   resnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	       @Override
//	       public void handleEvent(BaseEvent be) {  
//	           if (MSFSharedUtils.allowNulls(resnRegnNum.getValue()).trim().equals("")) {
//	               tgtSystemkey.setValue("");
//	               resnRegnNum.setValue(""); 
//	           }
//	        
//	       } 
//	 }); 
//	  // resnRegnNum.setFieldLabel("주민번호");
//	   layoutContainer_7_1.add(resnRegnNum, new FormData("100%")); 
//	   layoutContainer_7_1.setBorders(false); 
//	   
//	 
//	   layoutContainer_5_1.setBorders(false);
//	   layoutContainer_5_1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//	   layoutContainer_5_1.add(btnHanNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//	   layoutContainer_5_1.add(layoutContainer_7_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
	    
	   layoutContainer41.add(lc41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
	   layoutContainer41.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));  
	 
	   
	   LayoutContainer layoutContainer01 = new LayoutContainer(new ColumnLayout());
	   layoutContainer01.setBorders(false);  
	   
	   
	   LayoutContainer lc31 = new LayoutContainer();
	   FormLayout fl3 = new FormLayout();
	   fl3.setLabelWidth(60);
	   fl3.setLabelAlign(LabelAlign.RIGHT);
	   lc31.setLayout(fl3);
	   
	    
	   emymtDivCd = new MSFComboBox<BaseModel>();
	   emymtDivCd.setFieldLabel("고용구분");
	   emymtDivCd.setForceSelection(true);
	   emymtDivCd.setMinChars(1);
	   emymtDivCd.setDisplayField("commCdNm");
	   emymtDivCd.setValueField("commCd");
	   emymtDivCd.setTriggerAction(TriggerAction.ALL);
	   emymtDivCd.setEmptyText("--고용구분선택--");
	   emymtDivCd.setSelectOnFocus(true);
	   emymtDivCd.setStore(lscrEmymtDivCd);
	   emymtDivCd.setName("emymtDivCd"); 
	   emymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	   emymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	   emymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	       public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	           //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        BaseModel bmPayCd =  se.getSelectedItem(); 
	        if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	            
	           deptCd.getListView().fireEvent(Events.CheckChanged); 
	           businCd.setEnabled(true);
	           typOccuCd.reset();
	           typOccuCd.setEnabled(false);
	           dtilOccuInttnCd.reset();
	           dtilOccuInttnCd.setEnabled(false);
	        } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
                
          	  businCd.reset();
              businCd.setEnabled(false);  
          	  //20151130 추가 수정
           	   deptCd.getListView().fireEvent(Events.CheckChanged);
                if (gwtExtAuth.getEnableTypOccuCd()) {
                	typOccuCd.setEnabled(true);
               		dtilOccuInttnCd.setEnabled(true); 
                } else {
                	typOccuCd.setEnabled(false);
                    dtilOccuInttnCd.setEnabled(false);
                    
                }
  	 
        
		    } else {
		  	  
		    } 
	        
	       } 
	   });
	   
	   lscrEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	       public void handleEvent(StoreEvent<BaseModel> be) {  
	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4210Auth("emymtDivCd", lscrEmymtDivCd); 
               	 }

	         
	         
	       }
	   });
	   lc31.add(emymtDivCd, new FormData("100%")); 
	   
	   LayoutContainer lc1 = new LayoutContainer();
	   FormLayout fl11 = new FormLayout();
	   fl11.setLabelWidth(70);
	   fl11.setLabelAlign(LabelAlign.RIGHT);
	   lc1.setLayout(fl11);
	    
	   deptCd = new MSFMultiComboBox<ModelData>();
	   deptCd.setName("deptCd");
	   // srhDeptCd.setForceSelection(true);
	   // srhDeptCd.setMinChars(1);
	    //srhDeptCd.setDisplayField("deptNmRtchnt");
	    //srhDeptCd.setValueField("deptCd");
	   // srhDeptCd.setTriggerAction(TriggerAction.ALL);
	   deptCd.setEmptyText("--부서선택--");
	   // srhDeptCd.setSelectOnFocus(true); 
	   // srhDeptCd.setReadOnly(false);
	  //  srhDeptCd.setEnabled(true); 
	    //srhDeptCd.setStore(lsDeptCd );
	    //srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
	   deptCd.getListView().setDisplayProperty("deptNmRtchnt");
	   deptCd.getStore().add(mDtalistcrDeptCd);
	   deptCd.setWidth(100);
	   deptCd.setFieldLabel("부서");
	   deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	   deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	   deptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	        public void handleEvent(StoreEvent<ModelData> be) {  

	      	  EventType type = be.getType();
	    	   if (type == Store.Add) { 
           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	checkPayr4210Auth("deptCd", lscrDeptCd); 
           	 }
	            
	        }
	    });    

	    deptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	       @Override
	      public void handleEvent(ComponentEvent ce) { 
	               
	                  if ((deptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(emymtDivCd,"commCd")))) {
	                     
	                      if (deptCd.getListView().getChecked().size() > 0) {  
	                         
	                          sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(reattyApptnYr,"year"));  
	                          List<ModelData> mdListSelect =  deptCd.getListView().getChecked(); 
	                          sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	                      }      
	                   
	                      //--------------------사업 불러 오는 함수 -------------------------------------------------
	                        lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	                       //--------------------사업 불러 오는 함수 -------------------------------------------------
	                        businCd.setStore(lscrBusinCd); 
	                        businCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	                            public void handleEvent(StoreEvent<BaseModel> be) {  
	                             //   businCd.setValue(lscrBusinCd.getAt(0));  
	                            }
	                        });    
	                        
	                     
	                  } else  if ((deptCd.getListView().getChecked().size() >  0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(emymtDivCd,"commCd")))) {
      	            		 
                    	  //2015.11.30 권한 직종가져오기  추가 
	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(payrMangDeptCd,"payrMangDeptCd"));
	            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lscrDeptCd,deptCd.getValue(),"deptNmRtchnt","deptCd");  
	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            		   lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	           
	                             mDtalistcrTypOccuCd = PayrUtils.getTypOccuCdModelData(lscrTypOccuCd) ;  
	                             typOccuCd.getInitStore().add(mDtalistcrTypOccuCd);
	                              
	                           }
	                       });  
            	    
                 } 
	                  
	              }  
	      
	            });  
	     
	    deptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	        @Override
	        public void handleEvent(ComponentEvent ce) {   
	            
	            if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
	               // GWT.log(" a" + ce.getEvent().getType());
	                mutilcrCombo = true;
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                mutilcrCombo = true;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                mutilcrCombo = false;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } 
	            
	        } 
	    });                       
	        
	    lc1.add(deptCd, new FormData("100%"));
	  
	   
	   layoutContainer01.add(lc31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer01.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   
	   
	   LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
	   layoutContainer.setBorders(false); 
	    
	   
	   LayoutContainer lc2 = new LayoutContainer();
	   FormLayout fl21 = new FormLayout();
	   fl21.setLabelWidth(70);
	   fl21.setLabelAlign(LabelAlign.RIGHT);
	   lc2.setLayout(fl21);
	   
	   //직종 직종세처리 
	   LayoutContainer lcTypOccuCd = new LayoutContainer();
	   lcTypOccuCd.setLayout(new ColumnLayout());
	   
	      
	   LayoutContainer layoutContainer_21 = new LayoutContainer();
	   FormLayout frmlytCre = new FormLayout();  
	   frmlytCre.setLabelWidth(70); 
//	   frmlytCre.setDefaultWidth(0);
	   frmlytCre.setLabelAlign(LabelAlign.RIGHT); 
	   layoutContainer_21.setLayout(frmlytCre);  
	   
	   typOccuCd = new MSFMultiComboBox<ModelData>();
	   typOccuCd.setName("typOccuCd"); 
	   typOccuCd.setEmptyText("--직종선택--"); 
	   typOccuCd.getListView().setDisplayProperty("typOccuNm");
	   typOccuCd.getStore().add(mDtalistcrTypOccuCd);
	   typOccuCd.setWidth(100);
//	   typOccuCd.setHideLabel(true);
	   typOccuCd.setFieldLabel("직종");
	   typOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	   typOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	   typOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	       public void handleEvent(StoreEvent<ModelData> be) { 
	    	  
	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   
		    		   //2015.11.30 추가 
			    	   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
		          	       ModelData  mdSelect  = typOccuCd.getStore().getAt(0) ; 
			                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
			                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
			                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
			                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
			                      //         mdSelect = tpMdSelect;
			                         //  } 
			                     //  }  
			                   
			                       typOccuCd.getListView().setChecked(mdSelect, true); 
			                       typOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
			                   // }  
			                    
		                 }  
			    	   }
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4210Auth("typOccuCd", lscrTypOccuCd); 
               	 }
	         
	           
	       }
	   });     
	   
	   typOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	      @Override
	     public void handleEvent(ComponentEvent ce) { 
	              
	    		//2015.11.30 추가 
          	   displayCreDtilOccuInttnCd();  
          	   
	                 
	             }  
	     
	           });  
	    
	   typOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	       @Override
	       public void handleEvent(ComponentEvent ce) {   
	           
	           if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
	              // GWT.log(" a" + ce.getEvent().getType());
	               mutilcrCombo = true;
	           } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	               mutilcrCombo = true;
	             //  GWT.log(" b" + ce.getEvent().getType());
	           } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	               mutilcrCombo = false;
	             //  GWT.log(" b" + ce.getEvent().getType());
	           }  
	       
	       } 
	   });
	   //2015.11.30 추가 
       typOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
           @Override
           public void handleEvent(BaseEvent ce) {   
           	
              displayCreDtilOccuInttnCd();  
           } 
       });  
	  
	   layoutContainer_21.add(typOccuCd, new FormData("100%")); 
	   
	   LayoutContainer lcSchRight = new LayoutContainer();
	 //  lcSchRight.setStyleAttribute("paddingRight", "10px");
	   frmlytSch = new FormLayout();  
	   frmlytSch.setLabelWidth(1); 
	   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	   frmlytSch.setDefaultWidth(0);
	  // fieldSet.setLayout(layout);  
	   lcSchRight.setLayout(frmlytSch);
	   
	   /** column 직종세코드 : dtilOccuInttnCd */  
	   dtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	   dtilOccuInttnCd.setName("dtilOccuInttnCd"); 
	   dtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	   dtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	   dtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
	   dtilOccuInttnCd.setWidth(100);
	   dtilOccuInttnCd.setFieldLabel("");
	   dtilOccuInttnCd.setHideLabel(true);
	   dtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	   dtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
	   dtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	       @Override
	       public void handleEvent(ComponentEvent ce) {    
	          
	           if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
	               mutilcrCombo = true;
	           } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	               mutilcrCombo = true;
	             //  GWT.log(" b" + ce.getEvent().getType());
	           } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	               mutilcrCombo = false;
	             //  GWT.log(" b" + ce.getEvent().getType());
	           } else {
	              
	           }  
	       
	       } 
	   });
	   
	   
	   lcSchRight.add(dtilOccuInttnCd, new FormData("100%")); 
	   
//	   lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
	   lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
	   lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
	   
	   layoutContainer_21.setBorders(false);
	 
	   lc2.add(lcTypOccuCd, new FormData("100%"));        
	 
	   
	   LayoutContainer lc3 = new LayoutContainer();
	   FormLayout fl31 = new FormLayout();
	   fl31.setLabelWidth(70);
	   fl31.setLabelAlign(LabelAlign.RIGHT);
	   lc3.setLayout(fl31); 
	 
	   businCd = new MSFComboBox<BaseModel>();
       businCd.setName("businCd");
       businCd.setForceSelection(true);
       businCd.setMinChars(1);
       businCd.setDisplayField("businNm");
       businCd.setValueField("businCd");
       businCd.setTriggerAction(TriggerAction.ALL);
       businCd.setEmptyText("--사업선택--");
       businCd.setSelectOnFocus(true); 
       businCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
       businCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
       businCd.setStore(lscrBusinCd);
       businCd.setFieldLabel("사업");
       lc3.add(businCd, new FormData("100%"));
        
	   layoutContainer.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	   layoutContainer.add(lc3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	  
	   
//	   LayoutContainer layoutContainer_4 = new LayoutContainer();
//	   layoutContainer.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//       frmlytSch = new FormLayout();  
//       frmlytSch.setLabelWidth(70); 
//       frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//       layoutContainer_4.setLayout(frmlytSch);
//       
//       businCd = new MSFComboBox<BaseModel>();
//       businCd.setName("businCd");
//       businCd.setForceSelection(true);
//       businCd.setMinChars(1);
//       businCd.setDisplayField("businNm");
//       businCd.setValueField("businCd");
//       businCd.setTriggerAction(TriggerAction.ALL);
//       businCd.setEmptyText("--사업선택--");
//       businCd.setSelectOnFocus(true); 
//       businCd.setReadOnly(false);
//       businCd.setEnabled(true); 
//       businCd.setStore(lscrBusinCd);
//       businCd.setFieldLabel("사업");
//       layoutContainer_4.add(srhBusinCd, new FormData("100%"));
//       layoutContainer_4.setBorders(false);  
       
	   
	 LayoutContainer layoutContainer_v1 = new LayoutContainer();
	 layoutContainer_v1.setLayout(new HBoxLayout()); 
	 LayoutContainer layoutContainer_v13 = new LayoutContainer();
	 frmlytStd = new FormLayout();  
	 frmlytStd.setLabelWidth(70); 
	 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	 layoutContainer_v13.setLayout(frmlytStd);
	
	 Listener<BaseEvent> chkListener = new CheckboxListener(); 
	 CheckBoxGroup chckbxgrpNewCheckboxgroup = new CheckBoxGroup(); 
	 
	 /** column 1월 : pymtMnthStp01 */ 
	 pymtMnthStp01 = new MSFCheckBox();  
	 chckbxgrpNewCheckboxgroup.add(pymtMnthStp01); 
	 pymtMnthStp01.setBoxLabel("1월");
	 pymtMnthStp01.setHideLabel(true);
	 
	 /** column 2월 : pymtMnthStp02 */
	 pymtMnthStp02 = new MSFCheckBox(); 
	 chckbxgrpNewCheckboxgroup.add(pymtMnthStp02);
	 pymtMnthStp02.setBoxLabel("2월");
	 pymtMnthStp02.setHideLabel(true);
	 
	 /** column 3월 : pymtMnthStp03 */
	 pymtMnthStp03 = new MSFCheckBox(); 
	 chckbxgrpNewCheckboxgroup.add(pymtMnthStp03);
	 pymtMnthStp03.setBoxLabel("3월");
	 pymtMnthStp03.setHideLabel(true);
	 
	 /** column 4월 : pymtMnthStp04 */
	 pymtMnthStp04 = new MSFCheckBox(); 
	 chckbxgrpNewCheckboxgroup.add(pymtMnthStp04);
	 pymtMnthStp04.setBoxLabel("4월");
	 pymtMnthStp04.setHideLabel(true);
	 
	 /** column 5월 : pymtMnthStp05 */
	 pymtMnthStp05 = new MSFCheckBox(); 
	 chckbxgrpNewCheckboxgroup.add(pymtMnthStp05);
	 pymtMnthStp05.setBoxLabel("5월");
	 pymtMnthStp05.setHideLabel(true);
	 
	 /** column 6월 : pymtMnthStp06 */
	 pymtMnthStp06 = new MSFCheckBox(); 
	 chckbxgrpNewCheckboxgroup.add(pymtMnthStp06);
	 pymtMnthStp06.setBoxLabel("6월");
	 pymtMnthStp06.setHideLabel(true);
	  
	   
	 layoutContainer_v13.add(chckbxgrpNewCheckboxgroup, new FormData("100%"));
	 chckbxgrpNewCheckboxgroup.setFieldLabel("지급월");
	 layoutContainer_v13.setBorders(false);
	 
	   
	  HBoxLayoutData hbld_layoutContainer_v2 = new HBoxLayoutData();
	  hbld_layoutContainer_v2.setFlex(1.0);
	  layoutContainer_v1.add(layoutContainer_v13, hbld_layoutContainer_v2);
	   
	  
	     LayoutContainer layoutContainer_1 = new LayoutContainer();
		 layoutContainer_1.setLayout(new HBoxLayout()); 
		 LayoutContainer layoutContainer_13 = new LayoutContainer();
		 frmlytStd = new FormLayout();  
		 frmlytStd.setLabelWidth(70); 
		 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_13.setLayout(frmlytStd);
		 
		 
		
		 CheckBoxGroup chckbxgrpNewCheckboxgroup01 = new CheckBoxGroup(); 
		  
		 /** column 7월 : pymtMnthStp07 */
		 pymtMnthStp07 = new MSFCheckBox(); 
		 chckbxgrpNewCheckboxgroup01.add(pymtMnthStp07);
		 pymtMnthStp07.setBoxLabel("7월");
		 pymtMnthStp07.setHideLabel(true);
		 
		 /** column 8월 : pymtMnthStp08 */
		 pymtMnthStp08 = new MSFCheckBox(); 
		 chckbxgrpNewCheckboxgroup01.add(pymtMnthStp08);
		 pymtMnthStp08.setBoxLabel("8월");
		 pymtMnthStp08.setHideLabel(true);
		 
		 /** column 9월 : pymtMnthStp09 */
		 pymtMnthStp09 = new MSFCheckBox(); 
		 chckbxgrpNewCheckboxgroup01.add(pymtMnthStp09);
		 pymtMnthStp09.setBoxLabel("9월");
		 pymtMnthStp09.setHideLabel(true);
		 
		 /** column 10월 : pymtMnthStp10 */
		 pymtMnthStp10 = new MSFCheckBox(); 
		 chckbxgrpNewCheckboxgroup01.add(pymtMnthStp10);
		 pymtMnthStp10.setBoxLabel("10월");
		 pymtMnthStp10.setHideLabel(true);

		 
		 /** column 11월 : pymtMnthStp11 */
		 pymtMnthStp11 = new MSFCheckBox(); 
		 chckbxgrpNewCheckboxgroup01.add(pymtMnthStp11);
		 pymtMnthStp11.setBoxLabel("11월");
		 pymtMnthStp11.setHideLabel(true);
		 pymtMnthStp11.setStyleAttribute("marginLeft", "-6px");
		 
		 /** column 12월 : pymtMnthStp12 */
		  pymtMnthStp12 = new MSFCheckBox(); 
		 
		  chckbxgrpNewCheckboxgroup01.add(pymtMnthStp12);
		  pymtMnthStp12.setBoxLabel("12월");
		  pymtMnthStp12.setHideLabel(true);
		  pymtMnthStp12.setStyleAttribute("marginLeft", "-6px");
		  
		  chkAll = new MSFCheckBox(); 
		  chckbxgrpNewCheckboxgroup01.add(chkAll);
		  chkAll.addListener(Events.OnClick, chkListener); 
		  chkAll.setBoxLabel("전체선택");
		  chkAll.setHideLabel(true);
			  
  
		 layoutContainer_13.add(chckbxgrpNewCheckboxgroup01, new FormData("100%"));
		 chckbxgrpNewCheckboxgroup01.setLabelSeparator("");
		 chckbxgrpNewCheckboxgroup01.setFieldLabel("");
		 layoutContainer_13.setBorders(false);
		 
		   
		  HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		  hbld_layoutContainer_2.setFlex(1.0);
		  layoutContainer_1.add(layoutContainer_13, hbld_layoutContainer_2);
		    
	  
	  LayoutContainer layoutContainer_v4 = new LayoutContainer();
	//  layoutContainer_v4.setStyleAttribute("paddingRight", "10px");
	  frmlytSch = new FormLayout();  
	  frmlytSch.setLabelWidth(70); 
	  frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	  layoutContainer_v4.setLayout(frmlytSch);
	  
	  reattyStpNoteCtnt = new MSFTextArea();  
	  reattyStpNoteCtnt.setPreventScrollbars(true);  
	  reattyStpNoteCtnt.setHeight("70px");
	  reattyStpNoteCtnt.setFieldLabel("내 용");   
	  
	  layoutContainer_v4.add(reattyStpNoteCtnt, new FormData("100%"));
	  layoutContainer_v4.setBorders(false);
	   
	   
	//  
	//  Button btnPayr0350Save = new Button("실적업로드");
	//  layoutContainer_4.add(btnPayr0350Save, new FormData("100%"));
	//  btnPayr0350Save.addListener(Events.Select, new Listener<ButtonEvent>() {
//	          public void handleEvent(ButtonEvent e) {
//	              
//	          //   xlsImportData(); 
//	                
//	          }
//	      });
	//  layoutContainer_1.add(layoutContainer_4, new FormData("100%"));
	//  layoutContainer_4.setBorders(false);
	//  
	//  LayoutContainer layoutContainer_3 = new LayoutContainer();
	//  layoutContainer_1.add(layoutContainer_3, new FormData("100%"));
	//  layoutContainer_3.setStyleAttribute("paddingRight", "10px");
	//  frmlytSch = new FormLayout();  
	//  frmlytSch.setLabelWidth(100); 
	//  frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	//  layoutContainer_3.setLayout(frmlytSch);
	//  
	//  Button btnPayr0350down = new Button("양식다운로드");
	//  btnPayr0350down.addListener(Events.Select, new Listener<ButtonEvent>() {
//	      public void handleEvent(ButtonEvent e) {
//	          
//	      //  xlsExportData();
//	            
//	      }
	//  }); 
	//    
	//  layoutContainer_3.add(btnPayr0350down, new FormData("100%"));
	//  layoutContainer_3.setBorders(false);
	//  
	//  
	//  LayoutContainer layoutContainer_5 = new LayoutContainer();
	//  layoutContainer_1.add(layoutContainer_5, new FormData("100%"));
	//  layoutContainer_5.setStyleAttribute("paddingRight", "10px");
	//  frmlytSch = new FormLayout();  
	//  frmlytSch.setLabelWidth(100); 
	//  frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	//  layoutContainer_5.setLayout(frmlytSch);
	//  
	//  Button btnPayr0350Create = new Button("근무실적생성");
	//  btnPayr0350Create.addListener(Events.Select, new Listener<ButtonEvent>() {
//	      public void handleEvent(ButtonEvent e) { 
//	         //  createPayr0350Data();
//	            
//	      }
	//  }); 
	//    
	//  layoutContainer_5.add(btnPayr0350Create, new FormData("100%"));
	//  layoutContainer_5.setBorders(false);
	  
	  
	  cp01.add(layoutContainer21, new FormData("100%")); 
	  cp01.add(layoutContainer41, new FormData("100%")); 
	  cp01.add(layoutContainer01, new FormData("100%")); 
	  cp01.add(layoutContainer,  new FormData("100%")); 
	  cp01.add(layoutContainer_v1, new FormData("100%")); 
	  cp01.add(layoutContainer_1, new FormData("100%"));
	  cp01.add(layoutContainer_v4, new FormData("100%"));
	   
	  lcTabFormLayer.add(cp01); 
	     
	  return lcTabFormLayer;
	  
	   
 }	  
 

 private void  displayCreDtilOccuInttnCd() {
	  
	  if ((typOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(emymtDivCd,"commCd")))) {
           
	        //직종변경에 따른 직종세 값 가져오기
	             
	            sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	           
	            List<ModelData> mdDeptCdSelect =  deptCd.getListView().getChecked();  
               String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
               sysComBass0350Dto.setDeptCd(strDeptCd);
                 
               List<ModelData> mdListSelect =  typOccuCd.getListView().getChecked();
	            String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
	            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
	          //  sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	            
	            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                
	                lscrDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	              //  creDtilOccuInttnCd.setStore(lscrDtilOccuInttnCd); 
	                
	                lscrDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
	                    public void handleEvent(StoreEvent<BaseModel> be) {  
	                        mDtalistcrDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lscrDtilOccuInttnCd) ; 
	                        dtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);
	                        
	                        if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
                         	    ModelData  mdSelect  = dtilOccuInttnCd.getStore().getAt(0) ;
		  		                   
		  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
		  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
		  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
		  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
		  		                      //         mdSelect = tpMdSelect;
		  		                         //  } 
		  		                     //  }  
		  		                   
                         	    dtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
                         	    dtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
		  		                   // }  
     	                 } 
	                    }
	                });     
	                
	            } 
	         
	      } else {
	       
	      }   
 }

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
			// TODO Auto-generated method stub 
		    payr4210Init();
			IColumnFilter filters = null;
			payr0360GridPanel.getTableDef().setTableColumnFilters(filters);
			
			payr0360GridPanel.getTableDef().addColumnFilter("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0360GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0360GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0360GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 

			//20180305추가 
			payr0360GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0360GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			
            String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            payr0360GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
            String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            payr0360GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
            //String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
            //payr0360GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            payr0360GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           
            payr0360GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0360GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0360GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
            payr0360GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
            payr0360GridPanel.reload();
			
			actionDatabase = ActionDatabase.UPDATE;
		   
		}
	
	
	
	 /**
	  * init 
	  */
	  private void payr4210Init() { 
		  
		  payr4210FormInit(); 
	
		  payr0360GridPanel.getMsfGrid().clearData();  
	      payr0350GridPanel.getMsfGrid().clearData();  
	      
	      actionDatabase = ActionDatabase.INSERT;
		  
	   }
	  
	  //신규처리시 
	  private void payr421FormNew() {  
	
		  payr4210FormInit(); 
	      payr0350GridPanel.getMsfGrid().clearData();  
	      
	      actionDatabase = ActionDatabase.INSERT;
		  
	   }  
	  
     private void payr4210FormInit() { 
		  
		  dpobCd.setValue("");   /** column 사업장코드 : dpobCd */                                
		  payCd.reset();   /** column 급여구분코드 : payCd */       
		  reattyYr.setValue(lsReattyYr.getAt(0));  /** column 소급년도 : reattyYr */    
		                 
		  reattyStpDsptyNum.setValue("");   /** column 소급설정회차번호 : reattyStpDsptyNum */       
		  reattyApptnYrMnth.setValue("");   /** column 소급적용년월 : reattyApptnYrMnth */         
		  reattyApptnYr.reset();        //작업년도                                        
		  reattyApptnMnth.reset();       //작업월                                          
		  reattyPymtDt.reset();   /** column 소급지급일자 : reattyPymtDt */                   
		  emymtDivCd.reset();   /** column 고용구분코드 : emymtDivCd */                       
		  payrMangDeptCd.reset();   /** column 급여관리부서코드 : payrMangDeptCd */             
		  deptCd.setValue("");   /** column 부서코드 : deptCd */                                 
		  businCd.reset();   /** column 사업코드 : businCd */                               
		  typOccuCd.setValue("");   /** column 직종코드 : typOccuCd */                           
		  dtilOccuInttnCd.setValue("");   /** column 직종세구분코드 : dtilOccuInttnCd */          
		  pymtMnthStp01.setValue(false);   /** column 지급월설정_01 : pymtMnthStp01 */               
		  pymtMnthStp02.setValue(false);   /** column 지급월설정_02 : pymtMnthStp02 */               
		  pymtMnthStp03.setValue(false);   /** column 지급월설정_03 : pymtMnthStp03 */               
		  pymtMnthStp04.setValue(false);   /** column 지급월설정_04 : pymtMnthStp04 */               
		  pymtMnthStp05.setValue(false);   /** column 지급월설정_05 : pymtMnthStp05 */               
		  pymtMnthStp06.setValue(false);   /** column 지급월설정_06 : pymtMnthStp06 */               
		  pymtMnthStp07.setValue(false);   /** column 지급월설정_07 : pymtMnthStp07 */               
		  pymtMnthStp08.setValue(false);   /** column 지급월설정_08 : pymtMnthStp08 */               
		  pymtMnthStp09.setValue(false);   /** column 지급월설정_09 : pymtMnthStp09 */               
		  pymtMnthStp10.setValue(false);   /** column 지급월설정_10 : pymtMnthStp10 */               
		  pymtMnthStp11.setValue(false);   /** column 지급월설정_11 : pymtMnthStp11 */               
		  pymtMnthStp12.setValue(false);   /** column 지급월설정_12 : pymtMnthStp12 */               
		  chkAll.setValue(false);    /** column 전체체크 : chkAll */                                
		  reattyStpNoteCtnt.setValue("");   /** column 소급설정내용 : reattyStpNoteCtnt */         
		  tgtSystemkey.setValue("");   /** column TGT_SYSTEMKEY : tgtSystemkey */            
		  hanNm.setValue("");         //성명                                                   
		  resnRegnNum.setValue("");   //주민번호  
		  secRegnNum.setValue("");   //주민번호  
		  
		  payCd.setReadOnly(false);
		  reattyYr.setReadOnly(false);
    	  emymtDivCd.setReadOnly(false);
    	  payrMangDeptCd.setReadOnly(false);
    	  deptCd.setReadOnly(false);
    	  typOccuCd.setReadOnly(false);
    	  dtilOccuInttnCd.setReadOnly(false);
    	  businCd.setReadOnly(false);
	 
		  
	   }
	  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 


	   public void setListRecord(Iterator<Record> records) {
	      this.records = records;
	   } 
	   
	   private Payr4210 getThis(){
	       return this;
	   }
	   
       private void fnPopupPsnl0100()  {
           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
           //검색.처리하면됨.
          MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
          //  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호 
           
           final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
           
           popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
               public void handleEvent(BaseEvent be) {
                   BaseModel mapModel = (BaseModel)be.getSource();
                   if (!"".equals(mapModel.get("systemkey"))) { 
                        
                       srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                       srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                       srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
                   }  
                  
               }
           });
   }
       
    


private void fnCreatePsnl0100() {
    //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
    //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
    //검색.처리하면됨.
    
    MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(hanNm.getRawValue());  //인사  
    
    final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
   
    popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
            BaseModel mapModel = (BaseModel)be.getSource();
            if (!"".equals(mapModel.get("systemkey"))) { 
                 
                tgtSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                hanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                resnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
                secRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("secRegnNum")));   //주민번호 
                 
            }  
         
            
        }
    });
     
}
       
//   private void setInitDate() {
//       Calendar  intiCal =   Calendar.getInstance();
//       
//       intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(reattyApptnYr,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(reattyApptnMnth,"month")) - 1, 1 );
//       reattyPymtDt.setValue(intiCal.getTime());
//       int maxDays = intiCal.getActualMaximum ( Calendar.DATE ); 
//       intiCal.add(Calendar.DATE, maxDays - 1);
//       GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
//       creWorkDayE.setValue(intiCal.getTime());
//   }
   

   //전체선택 체크박스 
   public class CheckboxListener implements Listener<BaseEvent>
   {
       public void handleEvent(BaseEvent be) {
           CheckBox checkBox = (CheckBox) be.getSource();
           if (checkBox.getValue()) {
              //전체선택
               pymtMnthStp01.setValue(true);   /** column 1월 : pymtMnthStp01 */
               pymtMnthStp02.setValue(true);   /** column 2월 : pymtMnthStp02 */
               pymtMnthStp03.setValue(true);   /** column 3월 : pymtMnthStp03 */
               pymtMnthStp04.setValue(true);   /** column 4월 : pymtMnthStp04 */
               pymtMnthStp05.setValue(true);   /** column 5월 : pymtMnthStp05 */
               pymtMnthStp06.setValue(true);   /** column 6월 : pymtMnthStp06 */
               pymtMnthStp07.setValue(true);   /** column 7월 : pymtMnthStp07 */
               pymtMnthStp08.setValue(true);   /** column 8월 : pymtMnthStp08 */
               pymtMnthStp09.setValue(true) ;  /** column 9월 : pymtMnthStp09 */
               pymtMnthStp10.setValue(true);   /** column 10월 : pymtMnthStp10 */
               pymtMnthStp11.setValue(true);   /** column 11월 : pymtMnthStp11 */
               pymtMnthStp12.setValue(true);   /** column 12월 : pymtMnthStp12 */
           } else {
              //전체해제  
               pymtMnthStp01.setValue(false);   /** column 1월 : pymtMnthStp01 */
               pymtMnthStp02.setValue(false);   /** column 2월 : pymtMnthStp02 */
               pymtMnthStp03.setValue(false);   /** column 3월 : pymtMnthStp03 */
               pymtMnthStp04.setValue(false);   /** column 4월 : pymtMnthStp04 */
               pymtMnthStp05.setValue(false);   /** column 5월 : pymtMnthStp05 */
               pymtMnthStp06.setValue(false);   /** column 6월 : pymtMnthStp06 */
               pymtMnthStp07.setValue(false);   /** column 7월 : pymtMnthStp07 */
               pymtMnthStp08.setValue(false);   /** column 8월 : pymtMnthStp08 */
               pymtMnthStp09.setValue(false) ;  /** column 9월 : pymtMnthStp09 */
               pymtMnthStp10.setValue(false);   /** column 10월 : pymtMnthStp10 */
               pymtMnthStp11.setValue(false);   /** column 11월 : pymtMnthStp11 */
               pymtMnthStp12.setValue(false);   /** column 12월 : pymtMnthStp12 */
           }
       }
   }  
   
   
   
   /**
    * 상세정보 조회 
    * @param selRecord
    */
   private void fnPayr0360Detail(BaseModel selRecord) {
	   
	    Payr0360DTO payr0360Dto = new Payr0360DTO();   
       

		payr0360Dto.setDpobCd(MSFSharedUtils.allowNulls(selRecord.get("dpobCd")));    /** column 사업장코드 : dpobCd */
		payr0360Dto.setPayCd(MSFSharedUtils.allowNulls(selRecord.get("payCd")));    /** column 급여구분코드 : payCd */
		payr0360Dto.setReattyYr(MSFSharedUtils.allowNulls(selRecord.get("reattyYr")));    /** column 소급년도 : reattyYr */
		payr0360Dto.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(selRecord.get("reattyStpDsptyNum")));    /** column 소급설정회차번호 : reattyStpDsptyNum */ 
        payr0360Dto.setReattyApptnYrMnth(MSFSharedUtils.allowNulls(selRecord.get("reattyApptnYrMnth")));    /** column 소급계산년월 : reattyApptnYrMnth */
 
		payr4210Service.activityOnReadDtlPayr4210ToPayr0360(payr0360Dto, 
                                  new AsyncCallback<Payr0360DTO>() {
  			 
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadRemt0100ToRemt3100" + caught), null);
              }
              public void onSuccess(Payr0360DTO result) { 
              	//리턴 결과  
            	  dpobCd.setValue(result.getDpobCd());    /** column 사업장코드 : dpobCd */
            	  payCd.setValue(lscrPayCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getPayCd())));    /** column 급여구분코드 : payCd */
            	 
            	  reattyYr.setValue(lsReattyYr.findModel("year",MSFSharedUtils.allowNulls(result.getReattyYr())));    /** column 소급년도 : reattyYr */ 
            	  reattyStpDsptyNum.setValue(result.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */
            	  reattyApptnYrMnth.setValue(result.getReattyApptnYrMnth());    /** column 소급계산년월 : reattyApptnYrMnth */
            	  reattyApptnYr.setValue(lscrReattyApptnYr.findModel("year",MSFSharedUtils.allowNulls(result.getReattyApptnYr())));    /** column 소급계산년월 : reattyApptnYr */
            	  reattyApptnMnth.setValue(lscrReattyApptnMnth.findModel("month",MSFSharedUtils.allowNulls(result.getReattyApptnMnth())) );    /** column 소급계산년월 : reattyApptnMnth */
            	  reattyPymtDt.setValue(GWTUtils.getDateFromString(result.getReattyPymtDt(), "yyyyMMdd") );    /** column 소급지급일자 : reattyPymtDt */
            	  emymtDivCd.setValue(lscrEmymtDivCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getEmymtDivCd())));    /** column 고용구분코드 : emymtDivCd */
            	  payrMangDeptCd.setValue(lscrPayrMangDeptCd.findModel("payrMangDeptCd",MSFSharedUtils.allowNulls(result.getPayrMangDeptCd())));    /** column 급여관리부서코드 : payrMangDeptCd */
            
            	  
            	  deptCd.setValue(PayrUtils.getCheckStrToMultiData(plFrmPayr4210,result.getDeptCd(),"deptCd","deptNmRtchnt","deptCd") );    /** column 부서코드 : deptCd */ 
            	  typOccuCd.setValue(PayrUtils.getCheckStrToMultiData(plFrmPayr4210,result.getTypOccuCd(),"typOccuCd","typOccuNm","typOccuCd") );    /** column 직종코드 : typOccuCd */
            	  dtilOccuInttnCd.setValue(PayrUtils.getCheckStrToMultiData(plFrmPayr4210,result.getDtilOccuInttnCd(),"dtilOccuInttnCd","dtilOccuClsDivNm","dtilOccuInttnCd") );    /** column 직종세구분코드 : dtilOccuInttnCd */
            	   
            	  businCd.setValue(lscrBusinCd.findModel("businCd",MSFSharedUtils.allowNulls(result.getBusinCd())));    /** column 사업코드 : businCd */
            	  pymtMnthStp01.setValue(result.getPymtMnthStp01());    /** column 지급월설정_01 : pymtMnthStp01 */
            	  pymtMnthStp02.setValue(result.getPymtMnthStp02());    /** column 지급월설정_02 : pymtMnthStp02 */
            	  pymtMnthStp03.setValue(result.getPymtMnthStp03());    /** column 지급월설정_03 : pymtMnthStp03 */
            	  pymtMnthStp04.setValue(result.getPymtMnthStp04());    /** column 지급월설정_04 : pymtMnthStp04 */
            	  pymtMnthStp05.setValue(result.getPymtMnthStp05());    /** column 지급월설정_05 : pymtMnthStp05 */
            	  pymtMnthStp06.setValue(result.getPymtMnthStp06());    /** column 지급월설정_06 : pymtMnthStp06 */
            	  pymtMnthStp07.setValue(result.getPymtMnthStp07());    /** column 지급월설정_07 : pymtMnthStp07 */
            	  pymtMnthStp08.setValue(result.getPymtMnthStp08());    /** column 지급월설정_08 : pymtMnthStp08 */
            	  pymtMnthStp09.setValue(result.getPymtMnthStp09());    /** column 지급월설정_09 : pymtMnthStp09 */
            	  pymtMnthStp10.setValue(result.getPymtMnthStp10());    /** column 지급월설정_10 : pymtMnthStp10 */
            	  pymtMnthStp11.setValue(result.getPymtMnthStp11());    /** column 지급월설정_11 : pymtMnthStp11 */
            	  pymtMnthStp12.setValue(result.getPymtMnthStp12());    /** column 지급월설정_12 : pymtMnthStp12 */
            	  tgtSystemkey.setValue(result.getTgtSystemkey());    /** column TGT_SYSTEMKEY : tgtSystemkey */
            	  reattyStpNoteCtnt.setValue(result.getReattyStpNoteCtnt());    /** column null : reattyStpNoteCtnt */ 
            	  
            	  payCd.setReadOnly(true);
            	  reattyYr.setReadOnly(true); 
            	  emymtDivCd.setReadOnly(true);
            	  payrMangDeptCd.setReadOnly(true);
            	  deptCd.setReadOnly(true);
            	  typOccuCd.setReadOnly(true);
            	  dtilOccuInttnCd.setReadOnly(true);
            	  businCd.setReadOnly(true);
            	  
            	  actionDatabase = ActionDatabase.UPDATE;
				  
              }	
          });	  
  	 
      
  }
   //엑셀저장함수 
   public void exportExcel() {
       // TODO Auto-generated method stub
       // payr0301GridPanel.callExportServlet("");
       HashMap<String, String> param = new HashMap<String, String>(); 
       
       DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
       
       param.put("dpobCd", MSFMainApp.get().getUser().getDpobCd()); 
       param.put("reattyApptnYrMnth", (MSFSharedUtils.getSelectedComboValue(srhReattyApptnYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhReattyApptnMnth,"month"))); 
       param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
       
       param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
       param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
       
       param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") ); 
       param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
       param.put("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd")); 
       param.put("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
      // param.put("pyspGrdeCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
       param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd")); 
       param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
       param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
       param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
       param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));  

       //넘어온메서드 값을 가지고 처리 한다.  
      // dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsDlgn0250Export.do","extgwtFrame" ,param);  
       GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPayr4210Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
         
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
