package com.app.exterms.diligence.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.app.exterms.diligence.client.dto.Dlgn0250DTO;
import com.app.exterms.diligence.client.form.defs.Dlgn0250Def;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.client.service.Dlgn0250Service;
import com.app.exterms.diligence.client.service.Dlgn0250ServiceAsync;
import com.app.exterms.dlgn.client.utils.DlgnUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
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
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0250  extends MSFPanel { 
 
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
	  private DiligenceConstants lblDlgnConst = DiligenceConstants.INSTANCE;
	
	  private VerticalPanel vp;
	  private FormPanel plFrmDlgn0250;
	//  private FormData formData; 
	  private String txtForm = "";  
	  private  static boolean statTrue = true;
	 
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
	  private Dlgn0250Def dlgn0250Def  = new Dlgn0250Def();   //그리드 테이블 컬럼 define  
      private MSFCustomForm msfCustomForm; 
      private MSFGridPanel dlgn0250GridPanel;
      
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
      private ButtonBar topDlgn0250Bar;
      private Button btnDlgn0250New;
      private Button btnDlgn0250Save;
      private Button btnDlgn0250Del;
      private Button btnDlgn0250Sreach;
      private Button btnDlgn0250Excel;
      private Button btnDlgn0250Print;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ComboBox<BaseModel> srhPayYr;						//지급년
      private ComboBox<BaseModel> srhPayMonth;					//지급월
      private ComboBox<BaseModel> srhPayCd;     				//급여구분
      private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
      private TextField<String> srhHanNm;         				//성명
      private TextField<String> srhResnRegnNum;   				//주민번호 
      private HiddenField<String> srhSystemkey;   				//시스템키
      private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분 
      private MSFMultiComboBox<ModelData> srhDeptCd;			//부서 
      private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;	//직종세
      private ComboBox<BaseModel> srhBusinCd;    				//사업

      
//      private TextField<String> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptNm ;    //부서 
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정 
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 

       
      private Boolean picBoolFile;
       
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
       
      private boolean mutilCombo = false;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      // --------- 중간 근태생성 부분 시작 --------- 
      private ComboBox<BaseModel> creYear;        				//작업년도
      private ComboBox<BaseModel> creMonth;       				//작업월
      private DateField creWorkDayS;      						//근태기간 시작일
      private DateField creWorkDayE;      						//근태기간 종료일
      private ComboBox<BaseModel> crePayrMangDeptCd;			//단위기관
      private ComboBox<BaseModel> crePayCd;						//급여구분
      private ComboBox<BaseModel> creEmymtDivCd;				//고용구분
      private ComboBox<BaseModel> creRepbtyBusinDivCd; 			//호봉제구분코드  	
      private MSFMultiComboBox<ModelData> creDeptCd ;    		//부서 
      private ComboBox<BaseModel> creDeptGpCd; 					//부서직종그룹코드	
      private MSFMultiComboBox<ModelData> creTypOccuCd; 		//직종  
      private MSFMultiComboBox<ModelData> creDtilOccuInttnCd; 	//직종세
      private ComboBox<BaseModel> creBusinCd;					//사업
      // --------- 중간 근태생성 부분 끝 --------- 
      
      
      //파일업로드처리 부분  
      private FileUploadField dlgn0250flUp;
       
      private List<ModelData> mDtalistcrDeptCd ;
      private List<ModelData> mDtalistcrTypOccuCd ;
      private List<ModelData> mDtalistcrDtilOccuInttnCd ;
      
      private boolean mutilcrCombo = false;
      private String systemKeys;
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
      
     
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
      /**
       * 권한설정 처리 체크 
       * AuthAction 
       */
      private void checkDlgn0250Auth( String authAction, ListStore<BaseModel> bm) {   
    	  //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
    	  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
    	  if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
    		  //----------------------------------------------------
    		  if (!maskTracker) { unmask(); }  
		           
    		  Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd
                    		 			, crePayrMangDeptCd, creEmymtDivCd, creDeptCd, creTypOccuCd, creDtilOccuInttnCd, creBusinCd};
                    
    		  gwtAuthorization.formAuthFieldConfig(fldArrField);      			   
    		  gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
     			  
    		  srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
		      srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
		      creYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
              creMonth.setValue(lscrPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
                 
             // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
              // creEmymtDivCd.setValue(lscrEmymtDivCd.getAt(0)); 
                   
              srhPayCd.setValue(lsPayCd.getAt(0));  
              crePayCd.setValue(lscrPayCd.getAt(0));
              
              if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
            	  setInitDate();
              }
          
              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                // String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
		                // GWTAuthorization.formAuthPopConfig(plFrmDlgn0250, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
		                // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
				    //  gwtAuthorization.formAuthConfig(plFrmDlgn0250, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
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
		                     // GWTAuthorization.formAuthPopConfig(plFrmDlgn0250, "crePayrMangDeptCd","creEmymtDivCd",strArrDeptCd,"creTypOccuCd","creBusinCd");
		                     // GWTAuthorization.formAuthBtnConfig(btnCreCurrDeptCd); 
		             //  gwtAuthorization.formAuthConfig(plFrmDlgn0250,  "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creDtilOccuInttnCd","creBusinCd" );
		                    
              	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              	 * 권한설정을 위한 콤보처리를 위한 메서드 종료
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
              	creDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                //MSFMainApp.unmaskMainPage();
    	  }
      }
		  
      final Timer tmMask = new Timer(){
    	  public void run() {
    		  // if (maskTracker) { 
    		  cancel();
    		  unmask(); 
    		  maskTracker  = true;
		              // }
    	  }
      }; 
		     
      private void initLoad() { 

    	  // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
    	  gwtAuthorization = GWTAuthorization.getInstance();
    	  gwtExtAuth = GWTExtAuth.getInstance();
			     
    	  HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
			     
    	  authMapDef.put("srhPayYr",Boolean.FALSE);  
    	  authMapDef.put("srhPayMonth",Boolean.FALSE);  
			
    	  authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
    	  authMapDef.put("srhPayCd",Boolean.FALSE);  
    	  authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
    	  authMapDef.put("srhDeptCd",Boolean.FALSE); 
    	  //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
			      
    	  authMapDef.put("creYear",Boolean.FALSE);  
    	  authMapDef.put("creMonth",Boolean.FALSE);  
    	  authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
    	  authMapDef.put("crePayCd",Boolean.FALSE);  
    	  authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
    	  authMapDef.put("creDeptCd",Boolean.FALSE); 
    	  //  authMapDef.put("creTypOccuCd",Boolean.FALSE);  
				 
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
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
      //입력수정삭제처리 rpc 처리부     
      private Dlgn0250ServiceAsync payr0250Service = Dlgn0250Service.Util.getInstance();
      
      // ------  stroe 선언 시작 ------
      private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();		//년도 
      private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  		//급여월   
      private ListStore<BaseModel> lsPayCd = new ListStore<BaseModel>(); 			//급여구분
      private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>();	//단위기관 
      private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
      private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>();		//고용구분 
      private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();			//부서콤보
      private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();			//부서직종그룹코드  
      private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();		//직종 
      private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세
      private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();			//사업콤보   
      // ----------------------------------------------------------------------------------
      private ListStore<BaseModel> lscrPayYr = new ListStore<BaseModel>();			//년도 
      private ListStore<BaseModel> lscrPayMonth = new ListStore<BaseModel>();  		//급여월   
      private ListStore<BaseModel> lscrPayCd = new ListStore<BaseModel>(); 			//급여구분
      private ListStore<BaseModel> lscrPayrMangDeptCd = new ListStore<BaseModel>();	//단위기관 
      private ListStore<BaseModel> lscrEmymtDivCd = new ListStore<BaseModel>();		//고용구분 
      private ListStore<BaseModel> lscrRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
      private ListStore<BaseModel> lscrDeptCd  = new ListStore<BaseModel>();		//부서콤보
      private ListStore<BaseModel> lscrDeptGpCd = new ListStore<BaseModel>();		//부서직종그룹코드  
      private ListStore<BaseModel> lscrTypOccuCd = new ListStore<BaseModel>();		//직종 
      private ListStore<BaseModel> lscrDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
      private ListStore<BaseModel> lscrBusinCd  = new ListStore<BaseModel>();		// 사업콤보   
      // ------  stroe 선언 종료 ------
      
      
      // ------  DTO 선언 시작 ------
      private PrgmComBass0300DTO sysComBass0300Dto;	//공통코드 dto
      private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
      private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
      private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
      private SysCoCalendarDTO  msfCoCalendarDto;  
      private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
      private PrgmComBass0320DTO sysComBass0320Dto;	//직종
      // ------  DTO 선언 종료 ------
      
      
      private BaseModel record;
      private  Iterator<Record> records;
      
      
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
 
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnDlgn0250Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnDlgn0250Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnDlgn0250Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
	  
      private void doAction(ActionDatabase actionDatabase) {
          switch (actionDatabase) {
          case INSERT:
              this.actionDatabase = ActionDatabase.INSERT;
              dlgn0250FormSave();
              break;
          case UPDATE:
              this.actionDatabase = ActionDatabase.UPDATE;
              dlgn0250FormSave();
              break;
          case DELETE:
              this.actionDatabase = ActionDatabase.DELETE;
              dlgn0250FormSave();
              break;
          }
      }

      private void dlgn0250FormSave() {  
          
          if (MSFSharedUtils.paramNotNull(records)) { 
              
        	   statTrue = true;
        	   final Tracker tracker = new Tracker();
               tracker.setStatus(false);
               
               final List<Dlgn0250DTO> listDlgn0250dto = new ArrayList<Dlgn0250DTO>();  
              
//               if (this.actionDatabase.equals(ActionDatabase.DELETE)) {
//	               MessageBox.confirm("근무실적", "선택하신 근로자의 데이타를 삭제 처리합니다. \n 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
//	                   @Override
//	                   public void handleEvent(MessageBoxEvent be) {
//	                     //  if("Yes".equals(be.getButtonClicked().getText())){
//	                       if(Dialog.YES.equals(be.getButtonClicked().getItemId())){   
//	                    	   statTrue = true;
//	                       } else{
//	                    	   statTrue = false;
//	                       }
//	                   }
//	               });   
//               }
              
               if (!statTrue) {
            	   return ;
               } else {
	            
	                while (records.hasNext()) {
	              
	                    Record record = (Record) records.next(); 
	                    BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
	                    Dlgn0250DTO dlgn0250Dto = new Dlgn0250DTO();  
	                      
	                    dlgn0250Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    											/** column 사업장코드 : dpobCd */
	                    dlgn0250Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    									/** column SYSTEMKEY : systemkey */
	                    
	                    dlgn0250Dto.setDilnlazYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazYrMnth")));    							/** column 근태년월 : dilnlazYrMnth */
	                    dlgn0250Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));    											/** column 급여구분코드 : payCd */
	                    dlgn0250Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    									/** column 고용구분코드 : emymtDivCd */
	                    dlgn0250Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    											/** column 부서코드 : deptCd */
	                    dlgn0250Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    										/** column 사업코드 : businCd */
	                    dlgn0250Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    									/** column 직종코드 : typOccuCd */
	                    dlgn0250Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    						/** column 직종세구분코드 : dtilOccuInttnCd */
	                    dlgn0250Dto.setDilnlazDutyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dilnlazDutyBgnnDt"),"yyyyMMdd") );    /** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
	                    dlgn0250Dto.setDilnlazDutyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dilnlazDutyEndDt"),"yyyyMMdd") );    	/** column 근태_근무종료일자 : dilnlazDutyEndDt */
	                    
	                    dlgn0250Dto.setDilnlazExceDutyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dilnlazDutyBgnnDt"),"yyyyMMdd"));	/** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
	                    dlgn0250Dto.setDilnlazExceDutyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dilnlazDutyEndDt"),"yyyyMMdd"));	/** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
	                    
	                    dlgn0250Dto.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyNumDys")));    					/** column 근태_근무일수 : dilnlazDutyNumDys */
	                    dlgn0250Dto.setDilnlazLvsgNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazLvsgNumDys")));    					/** column 근태_연가일수 : dilnlazLvsgNumDys */
	                    dlgn0250Dto.setDilnlazAbnceNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazAbnceNumDys")));    					/** column 근태_결근일수 : dilnlazAbnceNumDys */
	                    dlgn0250Dto.setDilnlazSckleaNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSckleaNumDys")));    				/** column 근태_병가일수 : dilnlazSckleaNumDys */
	                    dlgn0250Dto.setDilnlazOffvaNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazOffvaNumDys")));    					/** column 근태_공가일수 : dilnlazOffvaNumDys */
	                    dlgn0250Dto.setDilnlazFmlyEvntNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazFmlyEvntNumDys")));    			/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
	                    dlgn0250Dto.setDilnlazHlthCreNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHlthCreNumDys")));    				/** column 근태_보건일수 : dilnlazHlthCreNumDys */
	                    dlgn0250Dto.setDilnlazTotDutyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTotDutyNumDys")));    				/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
	                    dlgn0250Dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazWklyHldyNumDys")));    			/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
	                    dlgn0250Dto.setDilnlazPaidPubcHodyNum(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazPaidPubcHodyNum")));   	 		/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
	                    dlgn0250Dto.setDilnlazDdlnePrcsYn((Boolean)bmMapModel.get("dilnlazDdlnePrcsYn"));    									/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
	                    dlgn0250Dto.setDilnlazNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazNoteCtnt")));    						/** column 근태_비고내용 : dilnlazNoteCtnt */
	                    dlgn0250Dto.setDilnlazSpclHodyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSpclHodyNumDys")));    			/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
	                    dlgn0250Dto.setDilnlazSatDutyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSatDutyNumDys")));    				/** column 총토요근무일수 : dilnlazSatDutyNumDys */
	                    dlgn0250Dto.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazPubcHodyDutyNumDys")));    	/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
	                    dlgn0250Dto.setDilnlazPubcHodyDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazPubcHodyDutyTm")));    			/** column 휴일총근무시간 : dilnlazPubcHodyDutyTm */
	                    dlgn0250Dto.setDilnlazHodyDutyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHodyDutyNumDys")));    			/** column 휴일일수 : dilnlazHodyDutyNumDys */
	                    
	                    dlgn0250Dto.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazAbnceDutyRcgtnDys")));    		/** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
	                  //  dlgn0250Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
	                    dlgn0250Dto.setDilnlazTotDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTotDutyTm")));   	 					/** column 근태_총근무시간 : dilnlazTotDutyTm */
	                    dlgn0250Dto.setDilnlazPaidHodyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazPaidHodyNumDys")));    			/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
	                    dlgn0250Dto.setDilnlazTfcAssCstNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTfcAssCstNumDys")));    			/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
	                   
	                    dlgn0250Dto.setDilnlazLnchDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazLnchDys")));    							/** column 근태_급식비일수 : dilnlazLnchDys */
	                    
	                    dlgn0250Dto.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazYrMnth")));    					/** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
	                    dlgn0250Dto.setDilnlazTotNtotNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTotNtotNumDys")));    				/** column 근태_총야근일수 : dilnlazTotNtotNumDys */
	                    dlgn0250Dto.setDilnlazTotNtotTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTotNtotTm")));    						/** column 근태_총야근시간 : dilnlazTotNtotTm */
	                    dlgn0250Dto.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazFndtnTmRstDutyTm")));    		/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
	                    dlgn0250Dto.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTmRstDutyTm")));    					/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
	                    dlgn0250Dto.setDilnlazTotTmRstDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTotTmRstDutyTm")));   	 		/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
	                    dlgn0250Dto.setDilnlazWkdDutyNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazWkdDutyNumDys")));    				/** column 평일근무일수 : dilnlazWkdDutyNumDys */

	//                    dlgn0250Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
	//                    dlgn0250Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
	//                    dlgn0250Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
	//                    dlgn0250Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
	//                    dlgn0250Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
	//                    dlgn0250Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
	 
	                     
	
	                    listDlgn0250dto.add(dlgn0250Dto);
	                  
	                }  
	                
	                if (listDlgn0250dto.size() <= 0) {
	                    
	                    MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
	                    return;
	                }
	                
//	                if(actionDatabase.equals(ActionDatabase.DELETE)){
//	                	if(1 < listDlgn0250dto.size()){
//	                		 MessageBox.alert(actionDatabase.name() + "삭제", actionDatabase.name() +  "1건 이상의 데이터는 삭제 할 수 없습니다.", null);
//	 	                    return;
//		                }
//	                }
	                
	            	MessageBox.confirm("근무내역등록 저장", "근무내역정보를 저장하시겠습니까?</br>[휴일근무 및 시간외근무 수정 시 시간외근무내역과 상이할 수 있습니다.]",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                
				                //급여 배치 호출 
				                //Progress bar for upload
				                final MessageBox box = MessageBox.wait("근무실적", "근무실적 데이타 처리 중 입니다...", "근무실적 저장(삭제) 중...");
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
				                
				                payr0250Service.activityOnDlgn0250(listDlgn0250dto, actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM>>(){
				                  public void onFailure(Throwable caught) {
				                	 
				                	  tracker.setStatus(true);
			                          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
			                          ShowMessageBM smBm = new ShowMessageBM();
			                   	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
			                   	      smBm.setMenu("Payr");
			                   	      smBm.setPhase("[복무관리]에러");
			                   	      smBm.setMessage(caught.getLocalizedMessage());
			                   	      smBm.setContent(caught.getMessage());
			                   	      bmResult.add(smBm);  
			                   	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
			                   	   
			                          ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
			 		    			    
					    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
					    		       msFwMessage.show();
					    		       showMessageForm.setMSFFormWindows(msFwMessage);
					    		       
				                      //MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                        //      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDlgn0250(" + actionDatabase.name() + ") : " + caught), null);
				                  }
				                  public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
			                          tracker.setStatus(true);
			                          
			                             // 오류를 리턴하는 경우
			                       	   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
			    		    			    
			   		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
			   		    		       msFwMessage.show();
			   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
			                       
			                           //   if (result == 0) {
			     	                   //     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
			     	                    //             actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
			     	                    // } else {
			     	                    //     MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
			     	                    //             actionDatabase + "처리가 완료되었습니다.", null);
			     	                    reload();
			     	                    actionDatabase = ActionDatabase.UPDATE;
			     	                   //  } 
			                      }
				              }); 
	                
							}
						}
					});
               } 
          } else {
              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
              return;
          }

      }      	 
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/
 
 
	  
	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();
			// formData = new FormData("-650");

			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0100Form();	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createXlsForm(); 		// 근무실적 생성
			createCheckBoxGrid(); 	// 근무실적 그리드
			vp.setSize("1010px", "700px");

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
	public Dlgn0250() {
		setSize("1010px", "700px");  
	} 
	
	public Dlgn0250(String txtForm) {
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
	  
	private void createPsnl0100Form() {
		  
		plFrmDlgn0250 = new FormPanel();
		plFrmDlgn0250.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - ") + lblDlgnConst.title_Dlgn0250());
		//plFrmDlgn0250.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 간이소득세액표관리");
		plFrmDlgn0250.setIcon(MSFMainApp.ICONS.text());
		plFrmDlgn0250.setBodyStyleName("pad-text");
		plFrmDlgn0250.setPadding(2);
		plFrmDlgn0250.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblDlgnConst.title_Dlgn0250(),"DLGN0250");
				}
			});
		plFrmDlgn0250.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmDlgn0250.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		   //멀티콤보박스 닫기 
		plFrmDlgn0250.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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
                       if ( creDeptCd.getCheckBoxListHolder().isVisible() ) {
                           //부서
                           creDeptCd.showClose(ce);
                           mutilcrCombo = false;
                       } else if (creTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                           //직종
                           creTypOccuCd.showClose(ce);
                           mutilcrCombo = false;
                         //  creTypOccuCd.getListView().fireEvent(Events.CheckChanged);
                       } else if ( creDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                           //직종세
                           creDtilOccuInttnCd.showClose(ce);
                           mutilcrCombo = false;
                       }  
                  }
                //    }
            //    } 
            } 
        }); 
        
		 topDlgn0250Bar = new ButtonBar();    
		 topDlgn0250Bar.setAlignment(HorizontalAlignment.RIGHT);
 
		 
	   //신규 
        btnDlgn0250New = new Button("신규");  
        btnDlgn0250New.setIcon(MSFMainApp.ICONS.new16());
        topDlgn0250Bar.add(btnDlgn0250New);
        btnDlgn0250New.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //초기화 버튼 클릭시 처리     
                dlgn0250GridPanel.getMsfGrid().clearData();
                fnPopupPsnl0110();   
                 
            }
        });
        //저장 -신규/수정 동시 처리 부분으로 나뉨 
        btnDlgn0250Save = new Button("저장");  
        btnDlgn0250Save.setIcon(MSFMainApp.ICONS.save16());
        topDlgn0250Bar.add(btnDlgn0250Save); 
        btnDlgn0250Save.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                setListRecord(dlgn0250GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
                doAction(actionDatabase); 
                 
            }
        });
       
        //삭제       
        btnDlgn0250Del = new Button("삭제");  
        btnDlgn0250Del.setIcon(MSFMainApp.ICONS.delete16());
        topDlgn0250Bar.add(btnDlgn0250Del);
        btnDlgn0250Del.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                Iterator<BaseModel> itBm  = dlgn0250GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
                
                List<Record>  lsRec  = new ArrayList<Record>();
                
                while(itBm.hasNext()) {
   
                    Record rec  = new Record(itBm.next()); 
                    lsRec.add(rec);
                    
                } 
                 setListRecord(lsRec.iterator()); 
                  
                actionDatabase = ActionDatabase.DELETE;
                doAction(actionDatabase);
                 
            }
        });
        
	  
	  	btnDlgn0250Sreach = new Button("조회"); 
	  	btnDlgn0250Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topDlgn0250Bar.add(btnDlgn0250Sreach);
	  	btnDlgn0250Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});

	  	btnDlgn0250Print = new Button("인쇄");
	  	btnDlgn0250Print.setIcon(MSFMainApp.ICONS.print16());
	  	topDlgn0250Bar.add(btnDlgn0250Print);
	  	btnDlgn0250Print.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"))){
					
					MessageBox.info("알림", "지급년을 선택해 주세요.", null);
					return;
					
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))){
					
					MessageBox.info("알림", "지급월을 선택해 주세요.", null);
					return;
					
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"))){
					
					MessageBox.info("알림", "단위기관을 선택해 주세요.", null);
					return;
					
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"))) {
					
					MessageBox.info("알림", "급여구분을 선택해 주세요.", null);
					return;
					
				}else {
					
					RexPrint("DLGNT0250");
					
				}
				
			}
		});
	  	
	  	
	  	btnDlgn0250Excel = new Button("엑셀"); 
	  	btnDlgn0250Excel.setIcon(MSFMainApp.ICONS.excel16());
	  	topDlgn0250Bar.add(btnDlgn0250Excel);
	  	btnDlgn0250Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});
	  	
//	  	btnDlgn0250Excel = new Button("엑셀업로드샘플"); 
//	  	btnDlgn0250Excel.setIcon(MSFMainApp.ICONS.excel16());
//	  	topDlgn0250Bar.add(btnDlgn0250Excel);
//	  	btnDlgn0250Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
//    		public void handleEvent(ButtonEvent e) {
//    			//엑셀저장  
//    			xlsReaderImportData();
//    		}
//    	});
	  	
	  	
//	  	topBtn = new Button("인쇄"); 
//	  	topBtn.setIcon(MSFMainApp.ICONS.text()); 
//	  	buttonBar.add(topBtn);  
	  	
	  	

	  	
	  	plFrmDlgn0250.add(topDlgn0250Bar);    	
	  	
		vp.add(plFrmDlgn0250);
		plFrmDlgn0250.setSize("990px", "690px");
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
	       
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      //월  
		  //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	      lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	      //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	         
	      lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
 
	         
	      //--------------------부서 불러 오는 함수 ------------------------------------------------
	      // lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
	      //--------------------부서 불러 오는 함수 ------------------------------------------------
	      sysComBass0400Dto.setDeptDspyYn("Y");
	      sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
          sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
            
          lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
            
          lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
        	  public void handleEvent(StoreEvent<BaseModel> be) {  
        		  mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
        		  srhDeptCd.getInitStore().add(mDtalistDeptCd);
                     
        		  lscrDeptCd.add(lsDeptCd.getModels()); 
        		  mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lscrDeptCd) ; 
        		  creDeptCd.getInitStore().add(mDtalistcrDeptCd);
        	  }
          });  
             
             //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
            //lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
	            
          /**
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           * 직종 콤보박스 처리  시작
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
           */
          lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
          lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
        	  public void handleEvent(StoreEvent<BaseModel> be) {  
        		  mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
        		  srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
        	  }
          });  
	             
          /**
	       * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	       * 년도 콤보박스 처리  시작
	       * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
	       */
//	               ContentPanel payYrGrid = new ContentPanel();  
//	               payYrGrid.setVisible(false);
//	                
//	               //년도 콤보처리 
//	               payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//	               payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	                       public void handleEvent(ComponentEvent be) {  
//	                         payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	                          public void handleEvent(StoreEvent<BaseModel> be) {  
//	                             lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//	                             
//	                            //  Date today = new Date(); 
//	                                // A custom date format
//	                            //  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	                             
//	                             // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//	                             // srhPayYr.setValue(bm);
//	                            srhPayYr.setValue(lsPayYrStore.getAt(0));
//	                            Date today = new Date(); 
//	                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//	                            srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//	                          
//	                          }  
//	                        });  
//	                       
//	                      }  
//	                    });  
//	          
//	            payYrGrid.add(payYrGridPanel); 
//	            plFrmDlgn0250.add(payYrGrid); 

          	lscrPayrMangDeptCd = lsPayrMangDeptCd; 
          	lscrPayCd = lsPayCd; 
          	lscrEmymtDivCd = lsEmymtDivCd; 
          	lscrRepbtyBusinDivCd = lsRepbtyBusinDivCd;
	      
	        plFrmDlgn0250.setLayout(new FlowLayout());
	        
	        srhSystemkey = new HiddenField<String>(); 
	          
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
	       // fieldSet.setCheckboxToggle(false); 
	        
	        LayoutContainer lcSchLeft = new LayoutContainer();
	       // lcSchLeft.setStyleAttribute("paddingRight", "10px"); 
	     
	        fieldSet.add(lcSchCol, new FormData("100%"));  
	        lcSchLeft.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_8 = new LayoutContainer();
	        FormLayout frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_8.setLayout(frmlytSch);
	        
	        srhPayYr = new ComboBox<BaseModel>();
	        srhPayYr.setName("srhPayYr");
	        srhPayYr.setForceSelection(true);
	        srhPayYr.setMinChars(1);
	        srhPayYr.setDisplayField("yearDisp");
	        srhPayYr.setValueField("year");
	        srhPayYr.setTriggerAction(TriggerAction.ALL);
	       // srhPayYr.setEmptyText("--년도선택--");
	        srhPayYr.setSelectOnFocus(true); 
	        srhPayYr.setReadOnly(false);
	        srhPayYr.setEnabled(true); 
	        srhPayYr.setStore(lsPayYrStore);
	        srhPayYr.setFieldLabel("지급년월"); 
	        srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                public void handleEvent(StoreEvent<BaseModel> be) {   
                	EventType type = be.getType();
                	if (type == Store.Add) { 
                		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			    			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                			checkDlgn0250Auth("srhPayYr", lsPayYrStore); 
                	}
                }
	        });
	        srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	              public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                  //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	               BaseModel bmPayYr =  se.getSelectedItem(); 
	               if (bmPayYr != null) {
	                   
	                   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                       
	                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                          
	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));
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
	                         
	                   } else {
	                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
	                      // return;
	                   } 
	   
	               	}       
	              } 
	        });   
	        layoutContainer_8.add(srhPayYr, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.74));
	        layoutContainer_8.setBorders(false);
	        
	        LayoutContainer layoutContainer_9 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_9.setLayout(frmlytSch);
	        
	        /** column 지급년월 : Mnth */ 
	        srhPayMonth = new ComboBox<BaseModel>();
	        srhPayMonth.setName("srhPayMonth");
	        srhPayMonth.setForceSelection(true);
	        srhPayMonth.setMinChars(1);
	        srhPayMonth.setDisplayField("monthDisp");
	        srhPayMonth.setValueField("month");
	        srhPayMonth.setTriggerAction(TriggerAction.ALL);
	       // srhPayMonth.setEmptyText("--월선택--");
	        srhPayMonth.setSelectOnFocus(true); 
	        srhPayMonth.setReadOnly(false);
	        srhPayMonth.setEnabled(true); 
	        srhPayMonth.setStore(lsPayMonth);
	        srhPayMonth.setHideLabel(true);
	        srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                public void handleEvent(StoreEvent<BaseModel> be) {  
                	checkDlgn0250Auth("srhPayMonth", lsPayMonth); 
                }
            });
	        layoutContainer_9.add(srhPayMonth, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
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
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkDlgn0250Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	                	 }
	            }
	        });    
	        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	                
	            	srhDeptCd.reset();  //2015.12.07 추가 
	            	sysComBass0400Dto.setDeptDspyYn("Y");
	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	                //--------------------부서 불러 오는 함수 ------------------------------------------------
	                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	                //--------------------부서 불러 오는 함수 ------------------------------------------------
	                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	                   public void handleEvent(StoreEvent<BaseModel> be) {  
	                     mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
	                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
	                       
	                   }
	                });   
	            } 
	        });
	        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	        layoutContainer.setBorders(false);
	        
	        
	        LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
	        layoutContainer_14.setBorders(false); 
	        
	        LayoutContainer layoutContainer_111 = new LayoutContainer();
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_111.setLayout(frmlytSch);
	        
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
	  			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	  			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	  			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	  			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	  			                	checkDlgn0250Auth("srhEmymtDivCd", lsEmymtDivCd ); 
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
	        layoutContainer_111.add(srhEmymtDivCd, new FormData("100%"));
	        layoutContainer_14.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	        
	        
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

		    frmlytSch = new FormLayout();  
		    frmlytSch.setDefaultWidth(0);
//		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_101.setLayout(frmlytSch);
		    
		    creRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		    creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
		    creRepbtyBusinDivCd.setForceSelection(true);
		    creRepbtyBusinDivCd.setHideLabel(true);
		    creRepbtyBusinDivCd.setAllowBlank(false);
		    creRepbtyBusinDivCd.setMinChars(1);
		    creRepbtyBusinDivCd.setDisplayField("commCdNm");
		    creRepbtyBusinDivCd.setValueField("commCd");
		    creRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		    creRepbtyBusinDivCd.setEmptyText("--호봉제--");
		    creRepbtyBusinDivCd.setSelectOnFocus(true); 
		    creRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		    creRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		    creRepbtyBusinDivCd.setStore(lscrRepbtyBusinDivCd);
//		    creRepbtyBusinDivCd.setLabelSeparator("");
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
		    lscrRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	              
	            }
	        });  
		    layoutContainer_101.add(creRepbtyBusinDivCd, new FormData("100%"));
		    layoutContainer_14.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	        
	       
	        
	        
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
//	              
	                srhHanNm.validate();
	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
	                	 
                        srhSystemkey.setValue("");
                        srhResnRegnNum.setValue("");
                    }
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) { 
	                	 srhSystemkey.setValue("");
	                     srhResnRegnNum.setValue(""); 
	                    fnPopupPsnl0100();
	                     
	                }
	                
	                super.componentKeyDown(event);
	            }
	         });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                @Override
//                public void handleEvent(BaseEvent be) {  
// 
//                    if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
// 
//                        srhSystemkey.setValue("");
//                        srhResnRegnNum.setValue("");
//                    }
//                 
//                } 
//          }); 
	        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	        layoutContainer_6.setBorders(false);
	        
	        LayoutContainer layoutContainer_btn = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        layoutContainer_btn.setLayout(frmlytSch);
	        
	        Button btnHanNm = new Button("검색");
//	        layoutContainer_5.add(btnHanNm);
	        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                srhSystemkey.setValue("");
                    srhResnRegnNum.setValue("");
//                    System.out.println("555555555");
	              fnPopupPsnl0100() ;
	                  
	            }
	        });
	        
	        layoutContainer_btn.add(btnHanNm);
	        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	        
	        LayoutContainer layoutContainer_7 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setDefaultWidth(0);
//	        frmlytSch.setLabelWidth(0); 
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
	        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
	        layoutContainer_7.setBorders(false); 
	        layoutContainer_5.setBorders(false);
	        
//	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));			// 지급년월 
//	        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));	// 급여구분
//	        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));	// 단위기관
//	        lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명, 주민번호
	        
	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 지급년월 
	        lcSchCol.add(layoutContainer ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
	        lcSchCol.add(layoutContainer_14 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));// 고용구분
	        
	        
	        
	        
	        
	        LayoutContainer layoutContainer_13 = new LayoutContainer();
	        layoutContainer_13.setLayout(new ColumnLayout());
	        
	        
	        LayoutContainer layoutContainer_1 = new LayoutContainer();
	        layoutContainer_1.setBorders(false);
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer_1.setLayout(frmlytSch);
	        
	        srhPayCd =  new ComboBox<BaseModel>(); 
	        srhPayCd.setName("srhPayCd");
	        srhPayCd.setForceSelection(true);
	        srhPayCd.setMinChars(1);
	        srhPayCd.setDisplayField("commCdNm");
	        srhPayCd.setValueField("commCd");
	        srhPayCd.setTriggerAction(TriggerAction.ALL);
	        srhPayCd.setEmptyText("--급여구분선택--");
	        srhPayCd.setSelectOnFocus(true); 
	        srhPayCd.setReadOnly(false);
	        srhPayCd.setEnabled(true); 
	        srhPayCd.setStore(lsPayCd);
	        srhPayCd.setFieldLabel("급여구분");
	        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	  
	           	   EventType type = be.getType();
		    	   if (type == Store.Add) { 
                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkDlgn0250Auth("srhPayCd", lsPayCd); 
                	 }
                  
	            }
	        });    
	        layoutContainer_1.add(srhPayCd, new FormData("100%"));
	        
	        
	        
	        
	        LayoutContainer layoutContainer_2 = new LayoutContainer();
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_2.setLayout(frmlytSch);
	        
	        
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
	            //srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
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
  			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
  			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
  			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
  			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
  			                	checkDlgn0250Auth("srhDeptCd", lsDeptCd); 
  	                	 }
	                    
	                }
	            });    

	              srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	              @Override
	              public void handleEvent(ComponentEvent ce) { 
	                       
	                          if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                             
	                        	  PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
     		                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
     		                      List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
                                  sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
     		                  
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
		       	            		   String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		       	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		       	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		       	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		       	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
		       	           	             
		       	                             mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		       	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		       	                              
		       	                           }
		       	                       });  
	                        	    
	                          } else {
	                        	  
	                        	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	       	            		   String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	       	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	                        	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	                     		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	                    	            public void handleEvent(StoreEvent<BaseModel> be) {  
	                    	             
	                                      mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
	       
	        creDeptGpCd  =  new ComboBox<BaseModel>(); 
	        creDeptGpCd.setName("creDeptGpCd");
	        creDeptGpCd.setForceSelection(true);
	        creDeptGpCd.setAllowBlank(false);
	        creDeptGpCd.setMinChars(1);
	        creDeptGpCd.setDisplayField("commCdNm");
	        creDeptGpCd.setValueField("commCd");
	        creDeptGpCd.setTriggerAction(TriggerAction.ALL);
	        creDeptGpCd.setEmptyText("--그룹--");
	        creDeptGpCd.setSelectOnFocus(true); 
	        creDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	        creDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	        creDeptGpCd.setStore(lsDeptGpCd);
	        creDeptGpCd.setFieldLabel("직종"); 
	        
	        layoutContainer_211.add(creDeptGpCd, new FormData("100%")); 
	        
	        
	        
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setDefaultWidth(0);
//	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_21.setLayout(frmlytSch);
	       
	         
	        
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	        srhTypOccuCd.setHideLabel(true);
//	        srhTypOccuCd.setFieldLabel("직종");
	        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	            public void handleEvent(StoreEvent<ModelData> be) {  
	            	EventType type = be.getType();
			    	   if (type == Store.Add) { 

	            	//2015.11.30 추가 
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
	               // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
        	       
                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkDlgn0250Auth("srhTypOccuCd", lsTypOccuCd); 
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
//	        frmlytSch.setLabelWidth(1); 
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
	        
	        
	        
	        
	        
	        LayoutContainer layoutContainer_4 = new LayoutContainer();
	        
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
	        srhBusinCd.setStore(lsBusinCd);
	        srhBusinCd.setFieldLabel("사업");
	        layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	        layoutContainer_4.setBorders(false);
	        
//	        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//	        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
//	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
//	        layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
	        
	        
	        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	        
	        fieldSet.add(layoutContainer_13);
	        
	        
	        
	        
	        LayoutContainer lcSchCol3 = new LayoutContainer();
	        lcSchCol3.setLayout(new ColumnLayout());
	        
	        
	        LayoutContainer layoutContainer_16 = new LayoutContainer();
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_16.setLayout(frmlytSch);
	        
	        
	        
	        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
	        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 성명
	        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
	       
	        
	        fieldSet.add(lcSchCol3, new FormData("100%"));
	        
	         
	        plFrmDlgn0250.add(fieldSet); 
	    //vp.add(panel);   
	  }  
	
      
	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
              
              //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                  
                  sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                  String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                  sysComBass0350Dto.setDeptCd(strDeptCd);
                  List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                  String strTypOccuCd = DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                  
                 // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                  
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                      
                      lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                      
                      lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                          public void handleEvent(StoreEvent<BaseModel> be) {  
                              mDtalistDtilOccuInttnCd = DlgnUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
//          String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//          if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//              sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//              sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//              if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                  lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//              }
//          }   
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
   
	  
	private void createXlsForm() {
		  
		  
		     msfCoCalendarDto = new SysCoCalendarDTO();
		     
		     //--------------------급여년도 불러 오는 함수 ------------------------------------------------
		     lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
		     
		     //월 
	         
	         lscrPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	            
	         lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
     		lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
    	            public void handleEvent(StoreEvent<BaseModel> be) {  
    	           
                      mDtalistcrTypOccuCd = DlgnUtils.getTypOccuCdModelData(lscrTypOccuCd) ;  
                      creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);
                       
                    }
                });  
     		   
		 
		        FieldSet fldstNewFieldset = new FieldSet(); 
	            
		     
		         LayoutContainer layoutContainer21 = new LayoutContainer(new ColumnLayout());
		         layoutContainer21.setBorders(false);
		          
		         
		         LayoutContainer lc11 = new LayoutContainer();
		         FormLayout fl1 = new FormLayout();
		         fl1.setLabelWidth(60);
		         fl1.setLabelAlign(LabelAlign.RIGHT);
		         lc11.setLayout(fl1);
		         
		         
                 LayoutContainer lc1_1 = new LayoutContainer(new ColumnLayout());
                 
                 LayoutContainer lc1_1_1 = new LayoutContainer();
                 FormLayout fl1_1 = new FormLayout();
                 fl1_1.setLabelWidth(60);
                 fl1_1.setLabelAlign(LabelAlign.RIGHT);
                 lc1_1_1.setLayout(fl1_1);
                 
                 creYear = new ComboBox<BaseModel>();
                 creYear.setName("creYear");
                 creYear.setFieldLabel("작업년월");
                 creYear.setForceSelection(true);
                 creYear.setMinChars(1);
                 creYear.setDisplayField("yearDisp");
                 creYear.setValueField("year");
                 creYear.setTriggerAction(TriggerAction.ALL);
                 creYear.setEmptyText("--년도--");
                 creYear.setSelectOnFocus(true);
                 creYear.setStore(lscrPayYr);
                 creYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  

                         /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                          * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                          * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                          ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                          // String[] strArrDeptCd = { "creCurrDeptCd","creCurrDeptNm"};
                          // GWTAuthorization.formAuthPopConfig(plFrmDlgn0250, "crePayrMangDeptCd","creEmymtDivCd",strArrDeptCd,"creTypOccuCd","creBusinCd");
                          // GWTAuthorization.formAuthBtnConfig(btnCreCurrDeptCd); 
//                         GWTAuthorization.formAuthConfig(plFrmDlgn0250,  "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creDtilOccuClsDivCd","creBusinCd" );
                    	 checkDlgn0250Auth("creYear", lscrPayYr); 
                         /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                          * 권한설정을 위한 콤보처리를 위한 메서드 종료
                          ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                         creYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
                         if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
                        	 setInitDate();
                         }
                       
                     }
                 });
                 creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                      BaseModel bmPayYr =  se.getSelectedItem(); 
                      if (bmPayYr != null) {
                          
                          if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
                              
                              if (creDeptCd.getListView().getChecked().size() > 0) {  
                                 
                                  sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));
                                  List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
                                  sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
                              }      
                           
                              //--------------------사업 불러 오는 함수 -------------------------------------------------
                                lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                               //--------------------사업 불러 오는 함수 -------------------------------------------------
                                creBusinCd.setStore(lscrBusinCd); 
                                creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                                    public void handleEvent(StoreEvent<BaseModel> be) {  
                                     //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                                    }
                                });    
                                
                          } else {
                             // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                             //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
                             // return;
                          }  
                      
                      }       
                     } 
                 });  
//                 creYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                     public void handleEvent(StoreEvent<BaseModel> be) {  
//                   
//                        EventType type = be.getType();
//   			    	   if (type == Store.Add) { 
//   	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//   			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//   			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//   			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//   			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//   			                	checkDlgn0250Auth("creYear", lscrPayYr); 
//   	                	 }
//                    
//                       
//                     }
//                 });
//                 creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//                      BaseModel bmPayYr =  se.getSelectedItem(); 
//                      if (bmPayYr != null) {
//                          
//                          if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
//                              
//                              if (creDeptCd.getListView().getChecked().size() > 0) {  
//                                 
//                                  sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));
//                                  List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
//                                  sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//                              }      
//                           
//                              //--------------------사업 불러 오는 함수 -------------------------------------------------
//                                lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                               //--------------------사업 불러 오는 함수 -------------------------------------------------
//                                creBusinCd.setStore(lscrBusinCd); 
//                                creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                                    public void handleEvent(StoreEvent<BaseModel> be) {  
//                                     //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                                    }
//                                });    
//                                
//                          } else {
//                             // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//                             //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
//                             // return;
//                          }  
//                      
//                      }       
//                     } 
//                 });  
//                 creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//                     	BaseModel bmMonth =  se.getSelectedItem(); 
//                     	if (bmMonth != null) { 
//                     		if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) ) {
//                         	//년도에 따라 기간 변화
//                  			setInitDate();
//                     		}
//                     	}       
//                     } 
//                 });  
                 lc1_1_1.add(creYear, new FormData("100%"));
                 
                 
                 LayoutContainer lc1_1_2 = new LayoutContainer();
                 FormLayout fl1_2 = new FormLayout();
                 fl1_2.setLabelWidth(0);
                 fl1_2.setLabelAlign(LabelAlign.RIGHT);
                 lc1_1_2.setLayout(fl1_2);
                
                 creMonth = new ComboBox<BaseModel>();
                 creMonth.setName("creMonth");
                 creMonth.setHideLabel(true);
                 creMonth.setForceSelection(true);
                 creMonth.setMinChars(1);
                 creMonth.setDisplayField("monthDisp");
                 creMonth.setValueField("month");
                 creMonth.setTriggerAction(TriggerAction.ALL);
                 creMonth.setEmptyText("--월--");
                 creMonth.setSelectOnFocus(true); 
                 creMonth.setStore(lscrPayMonth);
                 creMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {   
                    	 checkDlgn0250Auth("creMonth", lscrPayMonth); 
                       //  GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
                     }
                 });
                 creMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  

                         creMonth.setValue(lscrPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
                        
                         if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
                             setInitDate();
                         }
                       
                      
                       //  GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
                     }
                 });
                 creMonth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                      BaseModel bmMonth =  se.getSelectedItem(); 
                      if (bmMonth != null) { 
                    	  if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
                    		  setInitDate();
                          }
                     	}       
                     } 
                 });   
                 
//                 creMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                     public void handleEvent(StoreEvent<BaseModel> be) {  
//
//                         creMonth.setValue(lscrPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
//                        
//                         if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
//                             setInitDate();
//                         }
//                       
//                      
//                       //  GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
//                     }
//                 });
//                 creMonth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//                      BaseModel bmMonth =  se.getSelectedItem(); 
//                      if (bmMonth != null) { 
//                    	  creMonth.setValue(lscrPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
//                          
//                          if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
//                              setInitDate();
//							}
//						}
//					}
//				});
                 
                 
                 lc1_1_2.add(creMonth, new FormData("100%"));
                 
                 
                 lc1_1.add(lc1_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.74));
                 lc1_1.add(lc1_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
                 
                 lc11.add(lc1_1, new FormData("100%"));
		          
		         
		         LayoutContainer lc21 = new LayoutContainer();
		         FormLayout fl2 = new FormLayout();
		         fl2.setLabelWidth(60);
		         fl2.setLabelAlign(LabelAlign.RIGHT);
		         lc21.setLayout(fl2);
		         
		         LayoutContainer lc2_1 = new LayoutContainer(new ColumnLayout());
                 
                 LayoutContainer lc2_1_1 = new LayoutContainer();
                 FormLayout fl2_1 = new FormLayout();
                 fl2_1.setLabelWidth(60);
                 fl2_1.setLabelAlign(LabelAlign.RIGHT);
                 lc2_1_1.setLayout(fl2_1);
            
                  
                 creWorkDayS = new DateField();
                 creWorkDayS.setName("creWorkDayS");
                 new DateFieldMask(creWorkDayS, "9999.99.99"); 
                 creWorkDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
                 creWorkDayS.setFieldLabel("근태기간");
               //  creWorkDayS.setValue(value);
            
                 lc2_1_1.add(creWorkDayS, new FormData("100%"));
                 
                 LayoutContainer lc2_1_2 = new LayoutContainer();
                 FormLayout fl2_2 = new FormLayout();
                 fl2_2.setLabelWidth(7);
                 fl2_2.setLabelAlign(LabelAlign.RIGHT);
                 lc2_1_2.setLayout(fl2_2);
                 
                 creWorkDayE = new DateField();
                 creWorkDayE.setName("creWorkDayE");
                 new DateFieldMask(creWorkDayE, "9999.99.99"); 
                 creWorkDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
                 creWorkDayE.setLabelSeparator("~");
                 lc2_1_2.add(creWorkDayE, new FormData("100%"));
                 
                 lc2_1.add(lc2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.61));
                 lc2_1.add(lc2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
                 
                 lc21.add(lc2_1, new FormData("100%"));
                 
 
		         
		         LayoutContainer lc31 = new LayoutContainer();
		         FormLayout fl3 = new FormLayout();
		         fl3.setLabelWidth(60);
		         fl3.setLabelAlign(LabelAlign.RIGHT);
		         lc31.setLayout(fl3);
		         
                 
                 /** column 단위기관 : payrMangDeptCd */
                 crePayrMangDeptCd = new ComboBox<BaseModel>();
                 crePayrMangDeptCd.setName("crePayrMangDeptCd"); 
                 crePayrMangDeptCd.setForceSelection(true);
                 crePayrMangDeptCd.setMinChars(1);
                 crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
                 crePayrMangDeptCd.setValueField("payrMangDeptCd");
                 crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
                 crePayrMangDeptCd.setEmptyText("--단위기관선택--");
                 crePayrMangDeptCd.setSelectOnFocus(true); 
                 crePayrMangDeptCd.setReadOnly(false);
                 crePayrMangDeptCd.setEnabled(true); 
                 crePayrMangDeptCd.setStore(lscrPayrMangDeptCd);  
                 crePayrMangDeptCd.setFieldLabel("단위기관"); 
                 lscrPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                       EventType type = be.getType();
  			    	   if (type == Store.Add) { 
  	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
  			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
  			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
  			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
  			                	checkDlgn0250Auth("crePayrMangDeptCd", lscrPayrMangDeptCd); 
  	                	 }
                      
                         
                     }
                 });    
                 crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                         //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
                         
                     	 creDeptCd.reset();
                     	 sysComBass0400Dto.setDeptDspyYn("Y");
                         sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
                         //--------------------부서 불러 오는 함수 ------------------------------------------------
                         lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
                         //--------------------부서 불러 오는 함수 ------------------------------------------------
                         lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
                            public void handleEvent(StoreEvent<BaseModel> be) {  
                              mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lscrDeptCd) ; 
                              creDeptCd.getInitStore().add(mDtalistcrDeptCd);
                                
                            }
                         });   
                     } 
                 });
                 lc31.add(crePayrMangDeptCd, new FormData("100%"));  
		         
		         
		         LayoutContainer lc41 = new LayoutContainer();
		         FormLayout fl4 = new FormLayout();
		         fl4.setLabelWidth(60);
		         fl4.setLabelAlign(LabelAlign.RIGHT);
		         lc41.setLayout(fl4);

                 crePayCd = new ComboBox<BaseModel>();
                 crePayCd.setName("crePayCd");
                 crePayCd.setFieldLabel("급여구분");
                 crePayCd.setForceSelection(true);
                 crePayCd.setMinChars(1);
                 crePayCd.setDisplayField("commCdNm");
                 crePayCd.setValueField("commCd");
                 crePayCd.setTriggerAction(TriggerAction.ALL);
                 crePayCd.setEmptyText("--급여구분선택--");
                 crePayCd.setSelectOnFocus(true);
                 crePayCd.setStore(lscrPayCd);
               //  crePayCd.setReadOnly(true);
                 crePayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                    	
                         EventType type = be.getType();
  			    	    if (type == Store.Add) { 
  	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
  			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
  			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
  			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
  			                	checkDlgn0250Auth("crePayCd", lscrPayCd); 
  	                	 }
                         
                     }
                 });
                 
                 lc41.add(crePayCd, new FormData("100%")); 
                  
		         
                 layoutContainer21.add(lc11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
                 layoutContainer21.add(lc21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
                 layoutContainer21.add(lc31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
                 layoutContainer21.add(lc41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		         
		        
		         LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
                 layoutContainer.setBorders(false); 
                 
                 LayoutContainer lc1 = new LayoutContainer();
                 FormLayout fl11 = new FormLayout();
                 fl11.setLabelWidth(60);
                 fl11.setLabelAlign(LabelAlign.RIGHT);
                 lc1.setLayout(fl11);
                  
                 
                 creEmymtDivCd = new ComboBox<BaseModel>();
                 creEmymtDivCd.setFieldLabel("고용구분");
                 creEmymtDivCd.setForceSelection(true);
                 creEmymtDivCd.setMinChars(1);
                 creEmymtDivCd.setDisplayField("commCdNm");
                 creEmymtDivCd.setValueField("commCd");
                 creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
                 creEmymtDivCd.setEmptyText("--고용구분선택--");
                 creEmymtDivCd.setSelectOnFocus(true);
                 creEmymtDivCd.setStore(lscrEmymtDivCd);
                 creEmymtDivCd.setName("creEmymtDivCd"); 
                 creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                      BaseModel bmPayCd =  se.getSelectedItem(); 
                      if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
                          
                    	 creDeptCd.getListView().fireEvent(Events.CheckChanged); 
                         creBusinCd.setEnabled(true);
                         creTypOccuCd.reset();
                         creTypOccuCd.setEnabled(false);
                         creDtilOccuInttnCd.reset();
                         creDtilOccuInttnCd.setEnabled(false);
                      } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
                               
		                    	  creBusinCd.reset();
		                          creBusinCd.setEnabled(false);  
		                    	  //20151130 추가 수정
		     	            	 creDeptCd.getListView().fireEvent(Events.CheckChanged);
		     	                 if (gwtExtAuth.getEnableTypOccuCd()) {
		     	                	creTypOccuCd.setEnabled(true);
		                            creDtilOccuInttnCd.setEnabled(true); 
		     	                 } else {
		     	                	 creTypOccuCd.setEnabled(false);
		                             creDtilOccuInttnCd.setEnabled(false);
		     	                     
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
   			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
   			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
   			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
   			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
   			                	checkDlgn0250Auth("creEmymtDivCd", lscrEmymtDivCd); 
   	                	 }

                    
                       
                     }
                 });
                 lc1.add(creEmymtDivCd, new FormData("100%"));
                  
                 
                 LayoutContainer lc2 = new LayoutContainer();
                 FormLayout fl21 = new FormLayout();
                 fl21.setLabelWidth(60);
                 fl21.setLabelAlign(LabelAlign.RIGHT);
                 lc2.setLayout(fl21);
                 
                 
                 creDeptCd = new MSFMultiComboBox<ModelData>();
                 creDeptCd.setName("creDeptCd");
                 // srhDeptCd.setForceSelection(true);
                 // srhDeptCd.setMinChars(1);
                  //srhDeptCd.setDisplayField("deptNmRtchnt");
                  //srhDeptCd.setValueField("deptCd");
                 // srhDeptCd.setTriggerAction(TriggerAction.ALL);
                 creDeptCd.setEmptyText("--부서선택--");
                 // srhDeptCd.setSelectOnFocus(true); 
                 // srhDeptCd.setReadOnly(false);
                //  srhDeptCd.setEnabled(true); 
                  //srhDeptCd.setStore(lsDeptCd );
                  //srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
                 creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
                 creDeptCd.getStore().add(mDtalistcrDeptCd);
                 creDeptCd.setWidth(100);
                 creDeptCd.setFieldLabel("부서");
                 creDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
                      public void handleEvent(StoreEvent<ModelData> be) {  

                         // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
                       EventType type = be.getType();
   			    	   if (type == Store.Add) { 
   	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
   			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
   			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
   			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
   			                	checkDlgn0250Auth("creDeptCd", lscrDeptCd); 
   	                	 }
                          
                      }
                  });    
                  
                  creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
                     @Override
                    public void handleEvent(ComponentEvent ce) { 
                             
                                if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
                                   
                                    if (creDeptCd.getListView().getChecked().size() > 0) {  
                                       
                                        sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));  
                                        List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
                                        sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
                                    }      
                                 
                                    //--------------------사업 불러 오는 함수 -------------------------------------------------
                                      lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                                     //--------------------사업 불러 오는 함수 -------------------------------------------------
                                      creBusinCd.setStore(lscrBusinCd); 
                                      creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                                          public void handleEvent(StoreEvent<BaseModel> be) {  
                                           //   creBusinCd.setValue(lscrBusinCd.getAt(0));  
                                          }
                                      });    
                                      
                                   
                                } else  if ((creDeptCd.getListView().getChecked().size() >  0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
   	          	            		 
			                        	  //2015.11.30 권한 직종가져오기  추가 
		       	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		       	            		   String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		       	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		       	            		   lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		       	            		   lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		       	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
		       	           	           
		       	                             mDtalistcrTypOccuCd = DlgnUtils.getTypOccuCdModelData(lscrTypOccuCd) ;  
		       	                             creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);
		       	                              
		       	                           }
		       	                       });  
	                        	    
                                 } 
                                
                            }  
                    
                          });  
                   
                  creDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
                      
                 lc2.add(creDeptCd, new FormData("100%"));
                  
                 
                 LayoutContainer lc3 = new LayoutContainer();
                 FormLayout fl31 = new FormLayout();
                 fl31.setLabelWidth(60);
                 fl31.setLabelAlign(LabelAlign.RIGHT);
                 lc3.setLayout(fl31);
                 
                
                 
                 //직종 직종세처리 
                 LayoutContainer lcTypOccuCd = new LayoutContainer();
                 lcTypOccuCd.setLayout(new ColumnLayout());
                    
                 LayoutContainer layoutContainer_21 = new LayoutContainer();
                 FormLayout frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(60); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_21.setLayout(frmlytSch); 
                 
                 creTypOccuCd = new MSFMultiComboBox<ModelData>();
                 creTypOccuCd.setName("creTypOccuCd"); 
                 creTypOccuCd.setEmptyText("--직종선택--"); 
                 creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
                 creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
                 creTypOccuCd.setWidth(100);
                 creTypOccuCd.setFieldLabel("직종");
                 creTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
                     public void handleEvent(StoreEvent<ModelData> be) {  
                    	 EventType type = be.getType();
     			    	   if (type == Store.Add) { 
                    	 
                    	 //2015.11.30 추가 
  		    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
                  	       ModelData  mdSelect  = creTypOccuCd.getStore().getAt(0) ; 
  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
  		                      //         mdSelect = tpMdSelect;
  		                         //  } 
  		                     //  }  
  		                   
  		                       creTypOccuCd.getListView().setChecked(mdSelect, true); 
  		                       creTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
  		                   // }  
  		                    
                         }  
                        // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
                    	  
   	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
   			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
   			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
   			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
   			                	//checkDlgn0250Auth("creTypOccuCd", lscrTypOccuCd); 
   	                	 }
                      
                         
                     }
                 });     
                 
                 creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
                    @Override
                   public void handleEvent(ComponentEvent ce) { 
                            
                    	//2015.11.30 추가 
   	            	   displayCreDtilOccuInttnCd();  
                           }  
                   
                         });  
                  
                 creTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
                 creTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
     	            @Override
     	            public void handleEvent(BaseEvent ce) {   
     	            	
     	               displayCreDtilOccuInttnCd();  
     	            } 
     	        }); 
                 layoutContainer_21.add(creTypOccuCd, new FormData("100%")); 
                 
                 LayoutContainer lcSchRight = new LayoutContainer();
               //  lcSchRight.setStyleAttribute("paddingRight", "10px");
                 frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(0); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
                 frmlytSch.setDefaultWidth(0);
                // fieldSet.setLayout(layout);  
                 lcSchRight.setLayout(frmlytSch);
                 
                 /** column 직종세코드 : dtilOccuInttnCd */  
                 creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
                 creDtilOccuInttnCd.setName("creDtilOccuInttnCd"); 
                 creDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
                 creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
                 creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
                 creDtilOccuInttnCd.setWidth(100);
                 creDtilOccuInttnCd.setHideLabel(true);
                 creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
                 
                 
                 lcSchRight.add(creDtilOccuInttnCd, new FormData("100%")); 
                 
                 lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
                 lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
                 
                 layoutContainer_21.setBorders(false);

                 lc3.add(lcTypOccuCd, new FormData("100%")); 
                 
                 
                 LayoutContainer lc4 = new LayoutContainer();
                 FormLayout fl41 = new FormLayout();
                 fl41.setLabelWidth(60);
                 fl41.setLabelAlign(LabelAlign.RIGHT);
                 lc4.setLayout(fl41);
 
                 
                 creBusinCd = new ComboBox<BaseModel>();
                 creBusinCd.setName("creBusinCd");
                 creBusinCd.setFieldLabel("사업");
                 creBusinCd.setForceSelection(true);
                 creBusinCd.setMinChars(1);
                 creBusinCd.setDisplayField("businNm");
                 creBusinCd.setValueField("businCd");
                 creBusinCd.setTriggerAction(TriggerAction.ALL);
                 creBusinCd.setEmptyText("--사업선택--");
                 creBusinCd.setSelectOnFocus(true);
                 creBusinCd.setStore(lscrBusinCd); 
                 creBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                     public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                         //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                      BaseModel bmPayCd =  se.getSelectedItem(); 
                      if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
                           
                    	  srhBusinCd.setValue(lsBusinCd.findModel("businCd",bmPayCd.get("businCd")) );
                    	  
                      }  
                      
                     } 
                 });
                 lc4.add(creBusinCd, new FormData("100%"));
                 
                 
                 
                 layoutContainer.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
                 layoutContainer.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
                 layoutContainer.add(lc3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));
                 layoutContainer.add(lc4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
                 
		         
	           LayoutContainer layoutContainer_1 = new LayoutContainer();
	           layoutContainer_1.setLayout(new HBoxLayout()); 
	            
	            LayoutContainer layoutContainer_2 = new LayoutContainer();
	            layoutContainer_2.setStyleAttribute("paddingRight", "10px");
	            frmlytSch = new FormLayout();  
	            frmlytSch.setLabelWidth(60); 
	            frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	            layoutContainer_2.setLayout(frmlytSch);
	            
	            dlgn0250flUp = new FileUploadField();
	            dlgn0250flUp.setName("dlgn0250flUp");
	            dlgn0250flUp.setValidator(new Validator() {  
	            	@Override  
	            	public String validate(Field<?> field, String value) { 
	            		value = value.toLowerCase();        
	            		String result = "xls 파일이 아닙니다., 다시선택하십시요."; 
	            		
	            		if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
	            			result = null;        
	            		}        
	            		return result;  
	            	} 
	            });
	            
	            layoutContainer_2.add(dlgn0250flUp, new FormData("100%"));
	            dlgn0250flUp.setFieldLabel("근무실적");
	             
	            HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
	            hbld_layoutContainer_2.setFlex(1.0);
	            layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
	            layoutContainer_2.setBorders(false);
	            
	            LayoutContainer layoutContainer_4 = new LayoutContainer();
	            layoutContainer_4.setStyleAttribute("paddingRight", "10px");
	            frmlytSch = new FormLayout();  
	            frmlytSch.setLabelWidth(100); 
	            frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	            layoutContainer_4.setLayout(frmlytSch);
	            
	            Button btnDlgn0250Save = new Button("실적업로드");
	            layoutContainer_4.add(btnDlgn0250Save, new FormData("100%"));
	            btnDlgn0250Save.addListener(Events.Select, new Listener<ButtonEvent>() {
	            	public void handleEvent(ButtonEvent e) {
	            		xlsImportData(); 
	            	}
	            });
	            layoutContainer_1.add(layoutContainer_4, new FormData("100%"));
	            layoutContainer_4.setBorders(false);
	            
	            LayoutContainer layoutContainer_3 = new LayoutContainer();
	            layoutContainer_1.add(layoutContainer_3, new FormData("100%"));
	            layoutContainer_3.setStyleAttribute("paddingRight", "10px");
	            frmlytSch = new FormLayout();  
	            frmlytSch.setLabelWidth(100); 
	            frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	            layoutContainer_3.setLayout(frmlytSch);
	            
	            Button btnDlgn0250down = new Button("양식다운로드");
	            btnDlgn0250down.addListener(Events.Select, new Listener<ButtonEvent>() {
	                public void handleEvent(ButtonEvent e) {
	                	//엑셀저장  
	                	xlsExportData();
	                }
	            }); 
	              
	            layoutContainer_3.add(btnDlgn0250down, new FormData("100%"));
	            layoutContainer_3.setBorders(false);
	            
	            
	            LayoutContainer layoutContainer_5 = new LayoutContainer();
                layoutContainer_1.add(layoutContainer_5, new FormData("100%"));
                layoutContainer_5.setStyleAttribute("paddingRight", "10px");
                frmlytSch = new FormLayout();  
                frmlytSch.setLabelWidth(100); 
                frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
                layoutContainer_5.setLayout(frmlytSch);
                
                Button btnDlgn0250Create = new Button("근무실적생성");
                btnDlgn0250Create.addListener(Events.Select, new Listener<ButtonEvent>() {
                    public void handleEvent(ButtonEvent e) { 
                         createDlgn0250Data();
                          
                    }
                }); 
                  
                layoutContainer_5.add(btnDlgn0250Create, new FormData("100%"));
                layoutContainer_5.setBorders(false);
                
                
                fldstNewFieldset.add(layoutContainer21, new FormData("100%")); 
	            fldstNewFieldset.add(layoutContainer, new FormData("100%")); 
                fldstNewFieldset.add(layoutContainer_1, new FormData("100%"));
	        
	            fldstNewFieldset.setHeadingHtml("근무실적-생성");
	       if ("20144050000001".equals(MSFMainApp.get().getUser().getDpobCd())) {
	            plFrmDlgn0250.add(fldstNewFieldset);
	       } 
	  }
	  

	  private void  displayCreDtilOccuInttnCd() {
		  
		  if ((creTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
	            
		        //직종변경에 따른 직종세 값 가져오기
		             
		            sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		           
		            List<ModelData> mdDeptCdSelect =  creDeptCd.getListView().getChecked();  
	                String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
	                sysComBass0350Dto.setDeptCd(strDeptCd);
	                  
	                List<ModelData> mdListSelect =  creTypOccuCd.getListView().getChecked();
		            String strTypOccuCd = DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
		            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
		          //  sysComBass0350Dto.setPyspGrdeCd(DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
		            
		            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
		                
		                lscrDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
		              //  creDtilOccuInttnCd.setStore(lscrDtilOccuInttnCd); 
		                
		                lscrDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
		                    public void handleEvent(StoreEvent<BaseModel> be) {  
		                        mDtalistcrDtilOccuInttnCd = DlgnUtils.getDtilOccuInttnCdModelData(lscrDtilOccuInttnCd) ; 
		                        creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);
		                        
		                        if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
	                          	    ModelData  mdSelect  = creDtilOccuInttnCd.getStore().getAt(0) ;
			  		                   
			  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
			  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
			  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
			  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
			  		                      //         mdSelect = tpMdSelect;
			  		                         //  } 
			  		                     //  }  
			  		                   
	                          	    creDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
	                          	    creDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
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
   * 기본등록화면 입력 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/   
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 
	 
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


	  private void createCheckBoxGrid() {   
 
	       
	    FieldSet fieldSet1 = new FieldSet();  
	    fieldSet1.setHeadingHtml("근무실적");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	  //  lcStdGrid.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytStd = new FormLayout();  
	  //  frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(947, 450);  
	    
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
//	    MSFCustomForm msfCustomForm = new MSFCustomForm(dlgn0250Def, 0, 0, false, false, false);
//	    msfCustomForm.setHeaderVisible(false);
		msfCustomForm = new MSFCustomForm(dlgn0250Def, 0, 0, false, false, false);
	    msfCustomForm.setHeaderVisible(false);
	    dlgn0250GridPanel = new MSFGridPanel(dlgn0250Def, false, false, false, false,false);
//	    dlgn0250GridPanel.getMsfGrid().setCellModel(true);
	    dlgn0250GridPanel.setMSFFormPanel(msfCustomForm);
	    
	    dlgn0250GridPanel.setHeaderVisible(false);  
	    dlgn0250GridPanel.setBodyBorder(true);
	    dlgn0250GridPanel.setBorders(true);
	    
	    final Grid dlgn0250Grid = dlgn0250GridPanel.getMsfGrid().getGrid();
	    dlgn0250Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {  
             if (dlgn0250GridPanel.getCurrentlySelectedItem() != null) {      
            	 dlgn0250GridPanel.setGridRowFormBind(dlgn0250GridPanel.getCurrentlySelectedItem());
              } 
            }
        }); 

	    
	    dlgn0250GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 7, new HeaderGroupConfig("실근무일수", 1, 4));
	    dlgn0250GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 22, new HeaderGroupConfig("휴일근무", 1, 3));
	    dlgn0250GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 29, new HeaderGroupConfig("시간외 근무", 1, 3));
	 //   dlgn0250GridPanel.setFrame(true); 
	 //   dlgn0250GridPanel.showExportButton(true); 
//	    dlgn0250GridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//	    dlgn0250GridPanel.getGrid().addListener(Events.Render, new Listener<BaseEvent>() {
//	        public void handleEvent(BaseEvent be)
//	        {
//	        	 dlgn0250GridPanel.getGrid().disableTextSelection(false);
//	        }
//	    });    
//	    dlgn0250GridPanel.getGrid().removeStyleName("x-unselectable"); 
	    
	    cpGrid.add(dlgn0250GridPanel); 
	    
	 
	    lcStdGrid.add(cpGrid);   
	    fieldSet1.add(lcStdGrid);   
	      
	    plFrmDlgn0250.add(fieldSet1);
	     
	  }     
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
		public void reload() {
			// TODO Auto-generated method stub
			//선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임 
			if ( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")) ) { 
		          return;
			} else if ( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")) ) { 
		          return;
			}
//			
//			if ( MSFSharedUtils.paramNull(srhApptnStdBgnnDt.getRawValue()) ) {
//				  MessageBox.alert("데이터 오류", "기준일자는 필수 선택사항입니다.", null);
//				  srhApptnStdBgnnDt.focus();
//		          return;
//			}
//			
		  if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
      	     if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
    			 
          			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
   	                         "사업명을 선택하십시요.", null);
            		 return;
    		     } 
           } 
		    
            IColumnFilter filters = null;
            dlgn0250GridPanel.getTableDef().setTableColumnFilters(filters);
             
            dlgn0250GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
            dlgn0250GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            dlgn0250GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            dlgn0250GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
          
            //dlgn0250GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            //dlgn0250GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            dlgn0250GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
            String strTypOccuCd = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            dlgn0250GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//            String strPyspGrdeCd = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//            dlgn0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            String strDtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            dlgn0250GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
       
            
            dlgn0250GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            dlgn0250GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            dlgn0250GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
            dlgn0250GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
            
			dlgn0250GridPanel.reload();
	}
   

	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils
				.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();
		// //우편번호

		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) {
					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); // 주민번호
				}
			}
		});
	}
	       
	       
	       
	private void fnPopupPsnl0110() {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
	           
		MSFFormPanel popCom0110 = PrgmComPopupUtils.lovPopUpPrgmCom0110Form();  //인사  
	           
		final FormBinding popBindingCom0110 = popCom0110.getFormBinding();
	          
	    popBindingCom0110.addListener(Events.Change, new Listener<BaseEvent>() {
	    	public void handleEvent(BaseEvent be) {
	    		List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	    		
	    		if (mapModels != null) { 
	    			BaseModel bmData = dlgn0250GridPanel.getTableDef().getDefaultValues(); 
	    			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
	    			
	    			while (iterRecords.hasNext()) {
	    				
	    				BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
	                           
	    				bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());									/** column 사업장코드 : dpobCd */  
	                    bmData.set("systemkey",MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    				/** column SYSTEMKEY : systemkey */    
	                    bmData.set("deptCd",MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));   					/** column 부서코드 : deptCd */ 
	                    bmData.set("deptNm",MSFSharedUtils.allowNulls(bmMapModel.get("deptNm")));   					/** column 부서 : deptNm */ 
	                    bmData.set("hanNm",MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));  						/** column 한글성명 : hanNm */ 
	                    bmData.set("resnRegnNum",MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));  			/** column 주민등록번호 : resnRegnNum */ 
	                      
	                    bmData.set("payCd",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd") );   				/** column 급여구분코드 : payCd PayGenConst.PAY_CD_01*/ 
	                    bmData.set("payNm",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCdNm"));  				/** column 급여구분코드 : payCd   "월급여" */ 
	                           
	                          // bmData.set("payCd",PayGenConst.PAY_CD_01 );   /** column 급여구분코드 : payCd */ 
	                          // bmData.set("payNm","월급여");   /** column 급여구분코드 : payCd */  
	                        
	                    bmData.set("emymtDivCd",MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd"))); 				/** column 고용구분코드 : emymtDivCd */   
	                    bmData.set("typOccuCd",MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))); 				/** column 직종코드 : typOccuCd */ 
	                          // bmData.set("pyspGrdeCd",MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd"))); /** column 호봉등급코드 : pyspGrdeCd */ 
	                    bmData.set("dtilOccuInttnCd",MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))); 	/** column 직종세통합코드 : dtilOccuInttnCd */  
	                    bmData.set("businCd",MSFSharedUtils.allowNulls(bmMapModel.get("businCd"))); 					/** column 사업코드 : businCd */ 
	                         
	                    bmData.set("emymtDivNm",MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivNm")));  				/** column 고용구분코드 : emymtDivNm */  
	                    bmData.set("typOccuNm",MSFSharedUtils.allowNulls(bmMapModel.get("typOccuNm")));  				/** column 직종코드 : typOccuNm*/ 
	                          // bmData.set("pyspGrdeNm",MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeNm"))); /** column 호봉등급코드 : pyspGrdeNm */ 
	                    bmData.set("dtilOccuClsDivNm",MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivNm")));  	/** column 직종세구분코드 : dtilOccuClsDivNm */  
	                    bmData.set("businNm",MSFSharedUtils.allowNulls(bmMapModel.get("businNm")));					 	/** column 사업코드 : businNm */ 
	                           
	                    bmData.set("dilnlazYrMnth", DateTimeFormat.getFormat("yyyy.MM").format(new Date())); 			/** column 근태년월 : dilnlazYrMnth */
	                          
	                    bmData.set("dilnlazDutyNumDys","0"); 			/** column 근태_근무일수 : dilnlazDutyNumDys */
	                    bmData.set("dilnlazWkdDutyNumDys ","0"); 		/** column 평일근무일수  : dilnlazWkdDutyNumDys  */
	                    bmData.set("dilnlazTotDutyTm","0");    			/** column 근태_총근무시간 : dilnlazTotDutyTm */ 
	                    bmData.set("dilnlazHodyDutyNumDys ","0"); 		/** column 휴일일수  : dilnlazHodyDutyNumDys  */
	                 	bmData.set("dilnlazTotDutyNumDys","0");   		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
	                 	
	                 	
	                    bmData.set("dilnlazPaidHodyNumDys","0");    	/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
	                 	bmData.set("dilnlazSpclHodyNumDys","0");     	/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
	                	bmData.set("dilnlazAbnceNumDys","0");   		/** column 근태_결근일수 : dilnlazAbnceNumDys */
	                	bmData.set("dilnlazAbnceDutyRcgtnDys","0");     /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
	                	bmData.set("dilnlazSckleaNumDys","0");   		/** column 근태_병가일수 : dilnlazSckleaNumDys */
	                	bmData.set("dilnlazOffvaNumDys","0");   		/** column 근태_공가일수 : dilnlazOffvaNumDys */
	                	bmData.set("dilnlazFmlyEvntNumDys","0");     	/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
	                	bmData.set("dilnlazHlthCreNumDys","0");     	/** column 근태_보건일수 : dilnlazHlthCreNumDys */
	                         
	                	/** 잔여월차 */
	                	bmData.set("dilnlazPubcHodyDutyNumDys","0"); 	/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
	                	bmData.set("dilnlazSatDutyNumDys","0");    		/** column 총토요근무일수 : dilnlazSatDutyNumDys */
	                	bmData.set("dilnlazWklyHldyNumDys","0");     	/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
	                	bmData.set("dilnlazPaidPubcHodyNum","0");     	/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
	                         
	                	/** 잔여연가 */
	                	bmData.set("dilnlazTfcAssCstNumDys","0");    	/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
	                	bmData.set("dilnlazFndtnTmRstDutyTm","0");    	/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
	                	bmData.set("dilnlazTmRstDutyTm","0");    		/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
	                	bmData.set("dilnlazTotTmRstDutyTm","0");    	/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
	                	bmData.set("dilnlazTotNtotTm","0");    			/** column 근태_총야근시간 : dilnlazTotNtotTm */
	                            
	                          // bmData.set("dilnlazExceDutyBgnnDt","");    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
	                          // bmData.set("dilnlazExceDutyEndDt","");     /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */ 
	                          
	                	bmData.set("dilnlazDdlnePrcsYn",false);     	/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
	                	bmData.set("dilnlazNoteCtnt","");    			/** column 근태_비고내용 : dilnlazNoteCtnt */   
	                	bmData.set("dilnlazLvsgNumDys","0");     		/** column 근태_연가일수 : dilnlazLvsgNumDys */
	                	bmData.set("dilnlazTotNtotNumDys","0");    		/** column 근태_총야근일수 : dilnlazTotNtotNumDys */
	                            
//	                           kybdr.setValue(record.get("kybdr"));    /** column 입력자 : kybdr */
//	                           inptDt.setValue(record.get("inptDt"));    /** column 입력일자 : inptDt */
//	                           inptAddr.setValue(record.get("inptAddr"));    /** column 입력주소 : inptAddr */
//	                           ismt.setValue(record.get("ismt"));    /** column 수정자 : ismt */
//	                           revnDt.setValue(record.get("revnDt"));    /** column 수정일자 : revnDt */
//	                           revnAddr.setValue(record.get("revnAddr"));    /** column 수정주소 : revnAddr */
	                             
	    				} 
	                       
	    			dlgn0250GridPanel.getMsfGrid().getGrid().stopEditing();      
	    			dlgn0250GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
	    			dlgn0250GridPanel.getMsfGrid().getGrid().startEditing(dlgn0250GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
	    			dlgn0250GridPanel.setSize(935, 360);      
	    			actionDatabase = ActionDatabase.INSERT; 
	    		}  
	    	}
	    });
	}
	       
	/**
	 * 엑셀 양식다운로드
	 */
	private void xlsExportData() {
                      
		String year = DlgnUtils.getSelectedComboValue(creYear, "year");
		String month = DlgnUtils.getSelectedComboValue(creMonth, "month");
		String payCd = DlgnUtils.getSelectedComboValue(crePayCd, "commCd");
		String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS,"yyyyMMdd");
		String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE,"yyyyMMdd");
		String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");

		// String deptCd = MSFSharedUtils.allowNulls(creCurrDeptCd.getValue());
		// String typOccuCd =
		// DlgnUtils.getSelectedComboValue(creTypOccuCd,"typOccuCd");

		String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(), "deptNmRtchnt", "deptCd");
		String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
		String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");

		String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd");

		String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd, "payrMangDeptCd");

		HashMap<String, String> param = new HashMap<String, String>();

		param.put("jobYrMnth", year.concat(month));
		param.put("payCd", payCd);
		param.put("rflctnBgnnDt", workDayS);
		param.put("rflctnEndDt", workDayE);
		param.put("payrMangDeptCd", payrMangDeptCd);
		param.put("emymtDivCd", emymtDivCd);
		param.put("deptCd", deptCd);
		param.put("typOccuCd", typOccuCd);
		// param.put("pyspGrdeCd", pyspGrdeCd);
		param.put("dtilOccuInttnCd", dtilOccuInttnCd);
		param.put("businCd", businCd);

		if ("".equals(year) || "".equals(month)) {
			MessageBox.info("", "작업년월은 필수 입니다.", null);
		} else if ("".equals(payCd)) {
			MessageBox.info("", "급여구분은 필수 입니다.", null);
		} else if ("".equals(workDayS) || "".equals(workDayE)) {
			MessageBox.info("", "근태기간은 필수 입니다.", null);

		} else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {

			if ("".equals(businCd)) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
			} else {
				dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsDlgn0250Export.do", "extgwtFrame", param);
			}
		} else {
			dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsDlgn0250Export.do", "extgwtFrame", param);
		}
	}
	 

	private void xlsImportData() { 
         
		MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
              
					HashMap<String, String> param = new HashMap<String, String>();
					// only accept certain files 
		                       
					String year = DlgnUtils.getSelectedComboValue(creYear,"year");
                    String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
                    String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
                    String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
                    String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); 
                    String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
                    String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
                    String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
                    String strTypOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
                    String strDtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
                    String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd");  
                       
                      
                       
                       
                    if("".equals(year) || "".equals(month)){
                    	MessageBox.info("", "작업년월은 필수 입니다.", null);
                    }else if("".equals(payCd)){
                    	MessageBox.info("", "급여구분은 필수 입니다.", null);
                    }else if("".equals(workDayS) || "".equals(workDayE)){
                    	MessageBox.info("", "근태기간은 필수 입니다.", null);
                    } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
                    	if("".equals(businCd)){
                    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
                    	} else {
                    		//get the filename to be uploaded
                    		String filename = MSFSharedUtils.allowNulls(dlgn0250flUp.getValue());
                    		if (filename.length() == 0) {
                    			Window.alert("선택된 파일이 없습니다.");
                    		} else {
                    			//submit the form
                    			plFrmDlgn0250.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
                    			
                    			//파일업로드 처리
                    			plFrmDlgn0250.setAction(GWT.getHostPageBaseURL() + "imp/XlsDlgn0250Import.do");
                                plFrmDlgn0250.setEncoding(Encoding.MULTIPART);
                                plFrmDlgn0250.setMethod(Method.POST);   
//                                     FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
//                                     frmEl.setAcceptCharset("UTF-8"); 
                                plFrmDlgn0250.submit();  
                                plFrmDlgn0250.onFrameLoad();  
                                picBoolFile = true;
                    		}               
                                  
                    		// reset and unmask the form 
                    		// after file upload 
                    		plFrmDlgn0250.addListener(Events.Submit, new Listener<FormEvent>() {
                    			public void handleEvent(FormEvent evt) {   
                    				if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
                    					//업로드가  성공했으면 인서트 모듈을 태운다. 
                    					plFrmDlgn0250.unmask();  
                    					MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
                    					picBoolFile = false;
                    					evt.setResultHtml("");
                    				} else {
                    					if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
                    						//업로드가  성공했으면 인서트 모듈을 태운다.
                    						MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
                    						picBoolFile = false;
                    						evt.setResultHtml("");
                    					} else {
                    						//실패 메시지나 에러 메시지 처리 . 
                    						evt.setResultHtml("");
                    					} 
                    				}
                    			};
                    		}); 
                    	}
                    }else{ 
                    	
                    	//get the filename to be uploaded
                    	String filename = MSFSharedUtils.allowNulls(dlgn0250flUp.getValue());
                    	
                    	if (filename.length() == 0) {
                              Window.alert("선택된 파일이 없습니다.");
                    	} else {
                    		//submit the form
                    		plFrmDlgn0250.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
                    		
                    		//파일업로드 처리
                    		plFrmDlgn0250.setAction(GWT.getHostPageBaseURL() + "imp/XlsDlgn0250Import.do");
                    		plFrmDlgn0250.setEncoding(Encoding.MULTIPART);
                    		plFrmDlgn0250.setMethod(Method.POST);   
//                               FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
//                               frmEl.setAcceptCharset("UTF-8"); 
                    		plFrmDlgn0250.submit();  
                    		plFrmDlgn0250.onFrameLoad();  
                    		picBoolFile = true;
                    	}               
                            
                    	// reset and unmask the form 
                    	// after file upload 
                    	plFrmDlgn0250.addListener(Events.Submit, new Listener<FormEvent>() {
                    		public void handleEvent(FormEvent evt) {   
                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
                    				plFrmDlgn0250.unmask();  
                    				MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
                    				picBoolFile = false;
                    				evt.setResultHtml("");
                    			} else {
                    				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
                    					//업로드가  성공했으면 인서트 모듈을 태운다.
                    					MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
                    					picBoolFile = false;
                    					evt.setResultHtml("");
                    				} else {
                    					//실패 메시지나 에러 메시지 처리 . 
                    				} 
                    			}
                    		};
                    	});
                    }
				}  
			}
		}); 
	} 
	       
 

 /**
  * 근무실적생성   
  */
 private void createDlgn0250Data() {
     
     MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
      @Override
       public void handleEvent(MessageBoxEvent be) {
           //if("Yes".equals(be.getButtonClicked().getText())){
    	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
       
               String year = DlgnUtils.getSelectedComboValue(creYear,"year");
               String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
               String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
               String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
               String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
               String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
               
            //   String deptCd = MSFSharedUtils.allowNulls(creCurrDeptCd.getValue());
            //   String typOccuCd = DlgnUtils.getSelectedComboValue(creTypOccuCd,"typOccuCd"); 
               
               String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
               String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             //  String pyspGrdeCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
               String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
                
               String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd"); 
               
               String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); 
                
               if("".equals(year) || "".equals(month)){
                   MessageBox.info("", "작업년월은 필수 입니다.", null);
               }else if("".equals(payCd)){
                   MessageBox.info("", "급여구분은 필수 입니다.", null);
               }else if("".equals(workDayS) || "".equals(workDayE)){
                   MessageBox.info("", "근태기간은 필수 입니다.", null);
               }else if(GregorianCalendar.compareDate(creWorkDayS.getValue(), creWorkDayE.getValue()) < 0){
                   MessageBox.info("", "근태기간 설정이 이상합니다. 확인하십시요.", null);  
               } else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {    
           	    	if("".equals(businCd)){
               			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
         		     } else {
         		    	 
         		    	 final Tracker tracker = new Tracker();
                         tracker.setStatus(false);
                         
                         //급여 배치 호출 
                         //Progress bar for upload
                         final MessageBox box = MessageBox.wait("근무실적생성", "급여대상자 근무실적생성처리 중 입니다...", "근무실적  생성 중...");
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
                         

                         HashMap<String, String> param = new HashMap<String, String>(); 
                         
                         param.put("jobYrMnth", year.concat(month));
                         param.put("payCd", payCd);
                         param.put("rflctnBgnnDt", workDayS);
                         param.put("rflctnEndDt", workDayE);
                         param.put("emymtDivCd", emymtDivCd);
                         param.put("deptCd", deptCd);
                         param.put("typOccuCd", typOccuCd); 
                     //    param.put("pyspGrdeCd", pyspGrdeCd); 
                         param.put("dtilOccuInttnCd", dtilOccuInttnCd); 
                         param.put("businCd", businCd);
                         param.put("payrMangDeptCd", payrMangDeptCd);
                         param.put("workDayS", workDayS);
                         param.put("workDayE", workDayE);
                          
                         actionDatabase = ActionDatabase.INSERT;
                         
                         payr0250Service.createDlgn0250WorkPerfm(param, actionDatabase, new AsyncCallback<Long>(){
                             public void onFailure(Throwable caught) {
                                 tracker.setStatus(true);
                                 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createDlgn0250WorkPerfm(" + actionDatabase.name() + ") : " + caught), null);
                             }
                             public void onSuccess(Long result) { 
                                 tracker.setStatus(true);
                                if (result == 0) {
                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "근무실적 생성 중 오류가 발생 하였습니다. 데이타를 확인하십시요.", null);
                                } else {
                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                                            "근무실적 생성이 완료되었습니다.", null);
                                    reload();
                                    actionDatabase = ActionDatabase.UPDATE;
                                } 
                             } 
                         }); 
         		     }
               
               }else{ 
                    
                   
                   final Tracker tracker = new Tracker();
                   tracker.setStatus(false);
                      
                   
                   //급여 배치 호출 
                   //Progress bar for upload
                   final MessageBox box = MessageBox.wait("근무실적생성", "급여대상자 근무실적생성처리 중 입니다...", "근무실적  생성 중...");
                   final Timer t = new Timer(){
                       public void run(){
                           if (tracker.getStatus()){
                               cancel();
                               box.close();
                           }
                       }
                   };
                   t.scheduleRepeating(500);
                   

                   HashMap<String, String> param = new HashMap<String, String>(); 
                   
                   param.put("jobYrMnth", year.concat(month));
                   param.put("payCd", payCd);
                   param.put("rflctnBgnnDt", workDayS);
                   param.put("rflctnEndDt", workDayE);
                   param.put("emymtDivCd", emymtDivCd);
                   
                   param.put("deptCd", deptCd);
                   param.put("typOccuCd", typOccuCd); 
               //    param.put("pyspGrdeCd", pyspGrdeCd); 
                   param.put("dtilOccuInttnCd", dtilOccuInttnCd); 
                   
                   param.put("businCd", businCd);
                  
                   param.put("payrMangDeptCd", payrMangDeptCd);
                   
                   param.put("workDayS", workDayS);
                   param.put("workDayE", workDayE);
                    
                   actionDatabase = ActionDatabase.INSERT;
                   payr0250Service.createDlgn0250WorkPerfm(param, actionDatabase, new AsyncCallback<Long>(){
                       public void onFailure(Throwable caught) {
                           tracker.setStatus(true);
                           MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                   MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createDlgn0250WorkPerfm(" + actionDatabase.name() + ") : " + caught), null);
                       }
                       public void onSuccess(Long result) { 
                           tracker.setStatus(true);
                          if (result == 0) {
                              MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                      "근무실적 생성 중 오류가 발생 하였습니다. 데이타를 확인하십시요.", null);
                          } else {
                              MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                                      "근무실적 생성이 완료되었습니다.", null);
                              reload();
                              actionDatabase = ActionDatabase.UPDATE;
                          } 
                       } 
                   }); 
               }
           }  
      }
      
  }); 
 }  
 

class Tracker 
{
    public boolean status = false;
    public boolean getStatus(){return status;}
    public void setStatus(boolean stat){status = stat;}
}   
  
 
//부서 
// private void fnPopupCommP140(String deptCd) {
//     //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//     //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//     //검색.처리하면됨.
//     
//     MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//     
//     final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//    
//     popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//         public void handleEvent(BaseEvent be) {
//             BaseModel mapModel = (BaseModel)be.getSource();
//             if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                  
//                 srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                 srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                 srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                 srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                 srhDeptCd.fireEvent(Events.Add);
//             }  
//                  
//         }
//     });
// }
 
// private void fnPopupCommP150(String deptCd) {
//     //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//     //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//     //검색.처리하면됨. 
//     MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//     
//     final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//    
//     popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//         public void handleEvent(BaseEvent be) {
//             BaseModel mapModel = (BaseModel)be.getSource();
//             if (!"".equals(mapModel.get("deptCd"))) {  
//                 creMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                 creMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt"))); 
//                 creCurrDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                 creCurrDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//             }  
//         }
//     });
//       
// }

 public void setListRecord(Iterator<Record> records) {
    this.records = records;
 } 
 
  public void setRecord(BaseModel record) {
       this.record = record;
   }
 

   private Dlgn0250 getThis(){
       return this;
   }	   
  
	//날짜계산
	private void setInitDate() {
		
		int maxDays = 0;
		   
//		int monthS = 1;
//		int monthE = 12;
		   
		Calendar  intiCal =  Calendar.getInstance(Locale.KOREAN); 
		 
		intiCal.set (Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear, "year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creMonth, "month")) - 1 , 1);
		creWorkDayS.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  
		
//		 if ("02".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 28) {
//	    	   maxDays = 28;
//	       } else if ("04".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	   maxDays = 30;
//	       } else if ("06".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	   maxDays = 30;
//	       } else if ("09".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	   maxDays = 30;
//	       } else if ("11".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	   maxDays = 30; 
//	       }
	      
		Calendar  intieCal =   Calendar.getInstance(Locale.KOREAN);
	    intieCal.set (Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creMonth, "month")) - 1 , maxDays );
	    creWorkDayE.setValue(intieCal.getTime());
	    
	}
   
	
	private void RexPrint(String fileName) {
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
//		System.out.println("출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR");
		String strDirPath = "DLGN";
		
		// reb 출력물
		String rexFileName = fileName + ".crf";
//		String rexFileName = fileName + ".reb";
		
		// 보낼 파라미터
		
		// 검색조건
		String serarchParam = "";
		
		String year	 = DlgnUtils.getSelectedComboValue(srhPayYr,	"year");
		String month = DlgnUtils.getSelectedComboValue(srhPayMonth,	"month");
		
		String pymtYrMnth	   = year.concat(month);
		String payCd		   = DlgnUtils.getSelectedComboValue(srhPayCd, "commCd");
 		String payrMangDeptCd  = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
		String emymtDivCd	   = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");
		String deptCd		   = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
		String typOccuCd	   = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
//		String pyspGrdeCd	   = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "pyspGrdeCd");
		String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
		String businCd		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd");
		String hanNm		   = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum	   = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 

		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
		
		String deptCdAuth	   = MSFSharedUtils.allowNulls(DlgnUtils.getStrValToBMMultiCombo(  lsDeptCd
																							 , MSFSharedUtils.allowNulls(srhDeptCd.getValue())
																							 , "deptNmRtchnt", "deptCd"
																							)
														  ).replace(",", "");
		String dtilOccuInttnCdAuth = MSFSharedUtils.allowNulls(DlgnUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																								 , MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue())
																								 , "dtilOccuClsNm"
																								 , "dtilOccuInttnCd")).replace(",", "");

		//그리드 선택 데이터 출력
//		System.out.println("그리드 선택 데이터 출력");
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = dlgn0250GridPanel.getGrid().getSelectionModel().getSelectedItems();

		if(list != null && list.size() > 0) {
			String chkSysKey = "";
			int iCnt = 0;

			for(BaseModel bm : list){
				chkSysKey += bm.get("systemkey") + ",";
				iCnt = iCnt + 1;
			}
			keyCnt = iCnt;
			checkedSystemKeys = chkSysKey.substring(0, chkSysKey.length() - 1); //$10 시스템키
//			System.out.println("시스템키는 넘기지 않고 검색조건만 넘김");
			//시스템키는 넘기지 않고 검색조건만 넘김
			if(keyCnt > 200) {
				MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.", new Listener<MessageBoxEvent>() {
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// TODO Auto-generated method stub
						//if("Yes".equals(be.getButtonClicked().getText())) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							systemKeys = "";
						} else {
							return;
						}
					}
				});
//				System.out.println("선택한 시스템키 넘김");
				//선택한 시스템키 넘김
			} else {
				systemKeys = checkedSystemKeys;
			}
		}
//		if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)) {
		
			//도장 출력을 위해 추가 2014-11-06 //$9
			String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
			if(MSFSharedUtils.paramNull(myImgUrl)) {
			// myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력
			}
			
			serarchParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())	+ "⊥";	/*$1							*/
			serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$2  기간검색시작				*/
			serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$3  기간검색종료				*/
			serarchParam += "" + MSFSharedUtils.allowNulls(payrMangDeptCd)							+ "⊥";	/*$4  단위기간					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(emymtDivCd)								+ "⊥";	/*$5  고용구분					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(deptCd)									+ "⊥";	/*$6  부서코드					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(typOccuCd)								+ "⊥";	/*$7  직종						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(dtilOccuInttnCd)							+ "⊥";	/*$8  직종세						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(businCd)									+ "⊥";	/*$9  사업코드					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(systemKeys)								+ "⊥";	/*$10 시스템키					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(hanNm)									+ "⊥";	/*$11 성명						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(resnRegnNum)								+ "⊥";	/*$12 주민번호					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(payCd)									+ "⊥";	/*$13 급여구분					*/
			
			/* 20151212-변경추가 시작				*/
			serarchParam += "" + MSFMainApp.get().getUser().getUsrId()								+ "⊥"; /*$14 유저 아이디					*/
			serarchParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn()						+ "⊥";	/*$15 관리자 유무					*/
			
			/* 권한처리를위해 넘기는 변수 2개추가	*/
			serarchParam += "" + deptCdAuth															+ "⊥";	/*$16 부서						*/
			serarchParam += "" + dtilOccuInttnCdAuth												+ "⊥";	/*$17 직종세						*/
			
			/* 20151212-추가 끝					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(myImgUrl)								+ "⊥";	/*$18 직인경로					*/
			serarchParam += "0⊥";																			/*$19 단건 1 복수건 0 프린트 추가	*/
			serarchParam += "" + year																+ "⊥";	/*$20 년							*/
			serarchParam += "" + pymtYrMnth															+ "⊥";	/*$21 년월						*/
			serarchParam += "" + month																+ "⊥";	/*$21 월							*/
			
			String strParam = "" + serarchParam ;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

		//}else{
		//	MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
		//}
	}
	
   //엑셀 저장(상단)
	private void excelFileExport() {
       
		HashMap<String, String> param = new HashMap<String, String>(); 
   
	  	String year = DlgnUtils.getSelectedComboValue(srhPayYr,"year");
	  	String month = DlgnUtils.getSelectedComboValue(srhPayMonth,"month");
	   
	  	/** 검색조건 **/  
		param.put("pymtYrMnth", year.concat(month));
		param.put("payCd", DlgnUtils.getSelectedComboValue(srhPayCd, "commCd"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		param.put("systemkey",MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
		param.put("deptCd",DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));
		// param.put("pyspGrdeCd",
		// DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
		param.put("dtilOccuInttnCd", DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd"));
		param.put("businCd",MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));

		
		if ("".equals(year) || "".equals(month)) {
			
			MessageBox.info("", "작업년월은 필수 입니다.", null);
			
		} else if ("".equals(DlgnUtils.getSelectedComboValue(srhPayCd, "commCd"))) {
			
			MessageBox.info("", "급여구분은 필수 입니다.", null);
			
		} else if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {

			if ("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))) {
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
				
			} else {
				
				dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsFileDlgn0250Export.do", "extgwtFrame", param);
			}
			
		} else {
			dlgn0250GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsFileDlgn0250Export.do", "extgwtFrame", param);
		}
	}	 
 
//TODO 샘플..
//	private void xlsReaderImportData() { 
//               
//		MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
//			@Override
//			public void handleEvent(MessageBoxEvent be) {
//				//if("Yes".equals(be.getButtonClicked().getText())){
//                if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//					HashMap<String, String> param = new HashMap<String, String>();
//					
//					// only accept certain files 
//					String year = DlgnUtils.getSelectedComboValue(creYear,"year");
//					String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
//                    String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
//                    String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
//                    String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");
//                    String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
//                    String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
//                    String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//                    String strTypOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//                    String strDtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//                    String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd");  
//                    
//                         
//                         
//                    if("".equals(year) || "".equals(month)){
//                    	MessageBox.info("", "작업년월은 필수 입니다.", null);
//                    }else if("".equals(payCd)){
//                    	MessageBox.info("", "급여구분은 필수 입니다.", null);
//                    }else if("".equals(workDayS) || "".equals(workDayE)){
//                    	MessageBox.info("", "근태기간은 필수 입니다.", null);
//                    } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
//                    	if("".equals(businCd)){
//                    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//                    	} else {
//                    		//get the filename to be uploaded
//                    		String filename = MSFSharedUtils.allowNulls(dlgn0250flUp.getValue());
//                    		
//                    		if (filename.length() == 0) {
//                    			Window.alert("선택된 파일이 없습니다.");
//                    		} else {
//                    			
//                    			//submit the form
//                    			plFrmDlgn0250.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
//                    			
//                    			//파일업로드 처리
//                    			plFrmDlgn0250.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadDlgn0250Import.do");
//                    			plFrmDlgn0250.setEncoding(Encoding.MULTIPART);
//                    			plFrmDlgn0250.setMethod(Method.POST);   
////                                       FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
////                                       frmEl.setAcceptCharset("UTF-8"); 
//                    			plFrmDlgn0250.submit();  
//                    			plFrmDlgn0250.onFrameLoad();  
//                    			picBoolFile = true;
//                    		}               
//                                    
//                    		// reset and unmask the form 
//                    		// after file upload 
//                    		plFrmDlgn0250.addListener(Events.Submit, new Listener<FormEvent>() {
//                    			public void handleEvent(FormEvent evt) {   
//                    				if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//                    					//업로드가  성공했으면 인서트 모듈을 태운다. 
//                                    	plFrmDlgn0250.unmask();  
//                                    	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
//                                    	picBoolFile = false;
//                                    	evt.setResultHtml("");
//                    				} else {
//                    					if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//                    						//업로드가  성공했으면 인서트 모듈을 태운다.
//                    						MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
//                    						picBoolFile = false;
//                    						evt.setResultHtml("");
//                    					} else {
//                    						//실패 메시지나 에러 메시지 처리 . 
//                    						evt.setResultHtml("");
//                    					} 
//                    				}
//                    			};
//                    		}); 
//                    	}
//                    }else{ 
//                             
//                    	//get the filename to be uploaded
//                    	String filename = MSFSharedUtils.allowNulls(dlgn0250flUp.getValue());
//                    	
//                    	if (filename.length() == 0) {
//                    		Window.alert("선택된 파일이 없습니다.");
//                    	} else {
//                    		
//                    		//submit the form
//                    		plFrmDlgn0250.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
//                    		
//                    		//파일업로드 처리
//                    		plFrmDlgn0250.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadDlgn0250Import.do");
//                    		plFrmDlgn0250.setEncoding(Encoding.MULTIPART);
//                    		plFrmDlgn0250.setMethod(Method.POST);   
////                                 FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
////                                 frmEl.setAcceptCharset("UTF-8"); 
//                    		plFrmDlgn0250.submit();  
//                    		plFrmDlgn0250.onFrameLoad();  
//                    		picBoolFile = true;
//                    	}               
//                              
//                    	// reset and unmask the form 
//                    	// after file upload 
//                    	plFrmDlgn0250.addListener(Events.Submit, new Listener<FormEvent>() {
//                    		public void handleEvent(FormEvent evt) {   
//                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
//                    				plFrmDlgn0250.unmask();  
//                    				MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
//                    				picBoolFile = false;
//                    				evt.setResultHtml("");
//                    			} else {
//                    				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//                    					//업로드가  성공했으면 인서트 모듈을 태운다.
//                    					MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
//                    					picBoolFile = false;
//                    					evt.setResultHtml("");
//                    				} else {
//                    					//실패 메시지나 에러 메시지 처리 . 
//                    					evt.setResultHtml("");
//                    				} 
//                    			}
//                    		};
//                    	});
//                    }
//				}  
//			}
//		}); 
// 	} 
 


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

    