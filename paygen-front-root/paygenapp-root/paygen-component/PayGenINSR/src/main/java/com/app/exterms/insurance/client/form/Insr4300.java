package com.app.exterms.insurance.client.form;
 

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3400DTO;
import com.app.exterms.insurance.client.form.defs.Insr3400Def;
import com.app.exterms.insurance.client.service.Insr4300Service;
import com.app.exterms.insurance.client.service.Insr4300ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
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
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
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
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
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
public class Insr4300  extends MSFPanel { 
 

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
   // private RemtConstants lblRemtConst = RemtConstants.INSTANCE; 
    
	private VerticalPanel vp;
	private FormPanel plFrmInsr4300; 
	private String txtForm = "";
	private XTemplate detailTp; 
    //권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

	//직종콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	private MSFGridPanel typOccuCdGridPanel;
	
	private  TabPanel tabsInsr4300Frst;
	private  TabPanel tabsInsr4300Two; 
	
	private Insr3400Def insr3400Def = new Insr3400Def("INSR4300");   //그리드 테이블 컬럼 define
	private MSFGridPanel insr3400GridPanel;
	private GridCellRenderer<Stock> gridNumber;
	private GridCellRenderer<Stock> change;
     
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
      private ButtonBar topPayr4300Bar;
      private Button btnPayr4300Init;
     // private Button btnPayr4100Save;
     // private Button btnPayr4100Del;
      private Button btnPayr4300Sreach;
      private Button btnInsr4300Print;
      
      private Button btnInsr4300Del;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel> srhPayMonth;
     
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
//      private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//      private HiddenField<String> srhPyspGrdeCd; //직종 
      
//      private ComboBox<BaseModel> srhPayCd;     //급여구분
      private MSFMultiComboBox<ModelData> srhHdofcCodtnCd;		//재직구분
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
      
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> srhPymtDducDivCd;
      
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      
      private List<ModelData> mDtalistHdofcCodtnCd ;
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
       
       private ComboBox<BaseModel> crDilWrkrIncmBlggYr; //귀속년도
       /** set 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
       private ComboBox<BaseModel> crDilWrkrBlggQatrDivCd;     //귀속분기
       /** set 단위기관코드 : payrMangDeptCd */
       private ComboBox<BaseModel> crPayrMangDeptCd; //단위기관 
       private ComboBox<BaseModel> crDeptCd ;    //부서   
       private ComboBox<BaseModel> crBusinCd;    //사업
       
       
       private HiddenField<String> dpobCd;  //사업장코드 
       private HiddenField<String> systemkey;
     
      private HiddenField<String> dilWrkrIncmBlggYr;   /** column 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
 
      private HiddenField<String> dilWrkrBlggQatrDivCd;   /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
//
//     private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//
//     private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//     private TextField<String> dilWrkrIncmSumtDataNum   /** column 일용근로자소득제출자료건수 : dilWrkrIncmSumtDataNum */
//
//     private TextField<String> dilWrkrIncmSumtDt   /** column 일용근로자소득제출일자 : dilWrkrIncmSumtDt */
//
//     private TextField<String> degtrNm   /** column 대표자성명 : degtrNm */
//
     private TextField<String> corpNmFmnm;   /** column 법인명_상호 : corpNmFmnm */
//
       private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
//
//     private TextField<String> resnRegnNum   /** column 주민등록번호 : resnRegnNum */
//
//       private TextField<String> corpNum;   /** column 법인번호 : corpNum */
//
//     private TextField<String> incmRegrstDebrZpcd   /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
//
//     private TextField<String> incmRegrstDebrFndtnAddr   /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
//
//     private TextField<String> incmRegrstDebrDtlPatrAddr   /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
//
//     private TextField<String> juriTxOffcCd   /** column 관할세무서코드 : juriTxOffcCd */
//
      private ComboBox<BaseModel> pentrCd;   /** column 제출자구분코드 : pentrCd */
//
       private TextField<String> txDeptyNum;   /** column 세무대리인번호 : txDeptyNum */
//
    private TextField<String> hmtxId;   /** column 홈텍스ID : hmtxId */
//
//     private TextField<String> txPgmCd   /** column 세무프로그램코드 : txPgmCd */
//
     private TextField<String> pernChrgDeptNm;   /** column 담당자부서명 : pernChrgDeptNm */
 
     private TextField<String> pernChrgNm ;  /** column 담당자성명 : pernChrgNm */

     private TextField<String> pernChrgPhnNum;   /** column 담당자전화번호 : pernChrgPhnNum */

//     private TextField<String> dilWrkrIncmSumtDdlneDt   /** column 일용근로자소득제출마감일자 : dilWrkrIncmSumtDdlneDt */
//
//     private TextField<String> dilWrkrIncmSumtDdlneYn   /** column 일용근로자소득제출마감여부 : dilWrkrIncmSumtDdlneYn */
//
//     private TextField<String> dilWrkrIncmBlggYr   /** column 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
//
//     private TextField<String> dilWrkrBlggQatrDivCd   /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
//
//     private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//
//     private TextField<String> dilWrkrIncmPymtYrMnth   /** column 일용근로소득지급년월 : dilWrkrIncmPymtYrMnth */
//
//     private TextField<String> dilWrkrIncmDutyYrMnth   /** column 일용근로소득근무년월 : dilWrkrIncmDutyYrMnth */
//
//     private TextField<String> dilWrkrIncmDutyNumDys   /** column 일용근로소득근무일수 : dilWrkrIncmDutyNumDys */
//
//     private TextField<String> dilWrkrIncmTotPymtSum   /** column 일용근로소득총지급금액 : dilWrkrIncmTotPymtSum */
//
//     private TextField<String> dilWrkrFreeDtyIncmSum   /** column 일용근로소득비과세소득금액 : dilWrkrFreeDtyIncmSum */
//
//     private TextField<String> dilWrkrIncmIncmTxSum   /** column 일용근로소득소득세금액 : dilWrkrIncmIncmTxSum */
//
//     private TextField<String> dilWrkrRgonIncmTxSum   /** column 일용근로소득지방소득세금액 : dilWrkrRgonIncmTxSum */
//
//     private TextField<String> dilWrkrIncmDataArrgtDt   /** column 일용근로소득자료정리일자 : dilWrkrIncmDataArrgtDt */
//
//     private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//     private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//     private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//     private TextField<String> ismt   /** column 수정자 : ismt */
//
//     private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//     private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
       
     private Insr4300ServiceAsync insr4300Service = Insr4300Service.Util.getInstance();
     
     private String systemKeys;
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
  		  private void checkInsr4300Auth( String authAction, ListStore<BaseModel> bm) {   
  	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
  			 
  			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
 	                //----------------------------------------------------
				   authExecEnabled() ;
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
  			   }
  		  }
  		private void authExecEnabled() { 
  		   //------------------
  		  
             Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
            
             gwtAuthorization.formAuthFieldConfig(fldArrField);
             
             
             srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
             srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
             
//            srhPayCd.setValue(lsPayCd.getAt(0));
            srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(1), true);
            srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(2), true);
    		srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(1).get("commCdNm").toString()+","+mDtalistHdofcCodtnCd.get(2).get("commCdNm").toString());
    	//	srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(2).get("commCdNm").toString());
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
               //String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
               //GWTAuthorization.formAuthPopConfig(plFrmInsr4300, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
               //GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			    //gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 종료
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
              //  srhDeptCd.fireEvent(Events.Add); 
                srhDeptCd.getListView().fireEvent(Events.CheckChanged);         
            
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
  			     authMapDef.put("srhPayYr",Boolean.FALSE);
  			     authMapDef.put("srhPayMonth",Boolean.FALSE);
  			     authMapDef.put("srhPayCd",Boolean.FALSE);
  			     
  			     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
  			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
  				 authMapDef.put("srhDeptCd",Boolean.FALSE);
  				// authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
  				 
  				 gwtExtAuth.setCheckMapDef(authMapDef);
  		        
  		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
  		        	  //권한 검색조건처리를 위해 추가된 부분 
  					  mask("[화면로딩] 초기화 진행 중!");
  	        	}
  		      tmMask.scheduleRepeating(5000);
  		  }
  		  
//   	  private AuthAction authAction;
//   	  private int checkCntDef = 4;   //체크 값 갯수 
//   	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//   	  /**
//   	   * 권한설정 처리 체크 
//   	   * AuthAction 
//   	   */
//   	  private void checkInsr4300Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//       	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//   		 
//   		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//   			 
//            
//                   //----------------------------------------------------
//                   unmask(); 
//                   //MSFMainApp.unmaskMainPage();
//                    
//   		   }
//   	  }
         
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
	    private void setInsr4300FormBinding() {
	 	 
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
	    //입력수정삭제처리 rpc 처리부     
	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
  		
  		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  		
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
  	   //--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
  		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
//  		private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
  		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직구분
  		private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
  		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
  		

  	    private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
  	    private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
  		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
  		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
  		private SysCoCalendarDTO msfCoCalendarDto;  
  		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
  		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
  		
	    private BaseModel record;
    
	    private  Iterator<Record> records;
    
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
//	            if (ce.getButton() == btnInsr4300Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnInsr4300Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnInsr4300Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }

	        }  
	    };
    
    private void doAction(ActionDatabase actionDatabase) {
//        switch (actionDatabase) {
//        case INSERT:
//            NoticeBoardForm caricaVmn = new NoticeBoardForm(ActionDatabase.INSERT, getThis());
//            MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show(); 
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(new BaseModel());
//            caricaVmn.pulisci();
//            break;
//        case UPDATE:
//            caricaVmn = new NoticeBoardForm(ActionDatabase.UPDATE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtModification(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	   
//            break;
//        case DELETE:
//            caricaVmn = new NoticeBoardForm(ActionDatabase.DELETE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtCancel(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtCancel(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();  
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	            	
//            break;
//        }
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
	private void Insr4300Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "INSR";
		// mrd 출력물PAYR
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
 	   String serarchParam = "";
//		
//		String name = searchName.getValue() == null ? "" : searchName.getValue();
//		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
//		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
//		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
//		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
//		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
//		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
//		
//		serarchParam += "["+name+"]";
//		serarchParam += "["+resn+"]";
//		serarchParam += "["+hdofcCodtnCd+"]";
//		serarchParam += "[]";
//		//serarchParam += "["+manageDeptCd+"]";
//		serarchParam += "["+deptCd+"]";
//		serarchParam += "["+emymtDivCd+"]";
//		serarchParam += "["+typOccuCd+"]";
		
//		List<BaseModel> list = payr0650GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
		String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
		 
		//String strParam = "/rp " + "[" + "20080311" + "]";
		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

	}

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
				
              detailTp = XTemplate.create(getDetailTemplate()); 
              
              vp = new VerticalPanel();
              vp.setSpacing(10);
              createPsnl0100Form();  //화면 기본정보를 설정
              createSearchForm();    //검색필드를 적용 
              createForm();    //기본정보필드  
              createBottom();
              add(vp);
              //엣지변환
              //vp.setSize("1010px", "700px");
              vp.setSize("1010px", "750px");
                  
              panel = new ContentPanel();
              panel.setBodyBorder(false);
              panel.setBorders(false);
              panel.setHeaderVisible(false);
              panel.setScrollMode(Scroll.AUTO);  
              panel.add(vp);
              
              
          }
          return panel;
      }
	 
//  @Override
//  protected void onRender(Element parent, int index) {
//    super.onRender(parent, index);
//    
//    detailTp = XTemplate.create(getDetailTemplate()); 
//    
//    vp = new VerticalPanel();
//    vp.setSpacing(10);
//    createPsnl0100Form();  //화면 기본정보를 설정
//    createSearchForm();    //검색필드를 적용 
//    createForm();    //기본정보필드  
//    createBottom();
//    add(vp);
//    vp.setSize("1010px", "700px");
//  }
  
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
  public Insr4300() {
	  
//	  final NumberFormat currency = NumberFormat.getCurrencyFormat();   
//	    final NumberFormat number = NumberFormat.getFormat("0.00");   
//	    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);   
//	  
//	    change = new GridCellRenderer<Stock>() {   
//	      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//	          ListStore<Stock> store, Grid<Stock> grid) {   
//	        double val = (Double) model.get(property);   
//	        String style = val < 0 ? "red" : "green";   
//	        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";   
//	      }   
//	    };   
//	  
//	    gridNumber = new GridCellRenderer<Stock>() {   
//	      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,   
//	          ListStore<Stock> store, Grid<Stock> grid) {
//	        return numberRenderer.render(null, property, model.get(property));   
//	      }   
//	    };   
		      
      //엣지변환
	  //setSize("1010px", "700px");  
      setSize("1010px", "750px");  
} 

public Insr4300(String txtForm) {
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
    
    plFrmInsr4300 = new FormPanel();
   
   // plFrmInsr4300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Insr4300());
    plFrmInsr4300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 휴퇴직자정산관리"));
    plFrmInsr4300.setIcon(MSFMainApp.ICONS.text());
    //plFrmInsr4300.setBodyStyleName("pad-text");
    plFrmInsr4300.setFrame(true); 
    
    
    /************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	final Button btnlogView = new Button("로그");   
	
	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //로그 뷰화면 호출 메서드 
			  funcLogMessage("휴퇴직자정산관리","INSR4300");
			}
		});
	plFrmInsr4300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	plFrmInsr4300.getHeader().addTool(btnlogView); 
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 
	 ************************************************************************/

	 //멀티콤보박스 닫기 
	plFrmInsr4300.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
     @Override
     public void handleEvent(ComponentEvent ce) { 
     
      //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
             
     //        if (f instanceof MSFMultiComboBox<?>) {
                 
//                 if ("srhDeptCd".equals(f.getName())) {
//                     
//                 } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                     
//                 }
                 
       //      } else {
            if (mutilCombo) {
                 if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                     srhDeptCd.showClose(ce);
                     mutilCombo = false;
                 } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
                     srhHdofcCodtnCd.showClose(ce);
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
         //    }
     //    } 
     } 
 });
	
      ButtonBar buttonBar = new ButtonBar();    
      buttonBar.setAlignment(HorizontalAlignment.RIGHT);
 
  
    Button topBtn = new Button("초기화");  
    topBtn.setIcon(MSFMainApp.ICONS.new16());
    buttonBar.add(topBtn);
     
    topBtn = new Button("급여반영");  
    topBtn.setIcon(MSFMainApp.ICONS.new16());
    buttonBar.add(topBtn); 
    
    topBtn = new Button("(재)정산");  
    topBtn.setIcon(MSFMainApp.ICONS.new16());
    topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			reCalculate();
		}
	});
    buttonBar.add(topBtn); 
    
    btnInsr4300Del = new Button("삭제");  
    btnInsr4300Del.setIcon(MSFMainApp.ICONS.delete16());
    buttonBar.add(btnInsr4300Del);
    btnInsr4300Del.addListener(Events.Select, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent e) {
           
            
            MessageBox.confirm("사회보험자격 상실신고 삭제", "선택하신 대상자를 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
 				@Override
 				public void handleEvent(MessageBoxEvent be) {
 					//if("Yes".equals(be.getButtonClicked().getText())){
 					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

 						if(insr3400GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
 							 actionDatabase = ActionDatabase.DELETE;
 					           doAction(actionDatabase);
 					           
 					          
 					           
 					          insr4300Service.activityOnDeleteInsr4300(insr3400GridPanel.getGrid().getSelectionModel().getSelectedItems(), new AsyncCallback<Long>() {
 									@Override
 									public void onSuccess(Long result) {
 										MessageBox.info("", "삭제 되었습니다.", null);
 										reload();
 										//resetForm();
 									}
 									@Override
 									public void onFailure(Throwable caught) {
 										caught.printStackTrace();
 										MessageBox.info("", "삭제 오류", null);
 									}
 								});
 							}else{
 								MessageBox.info("", "삭제하실 대상자를 선택하여주세요.", null);
 							}
 					           
 						}else{
 							//MessageBox.info("", "삭제하실 대상자를 선택하여주세요.", null);
 						}
 					}
 				
            });
            
        }
    });
    
    
    
    
    
     
    topBtn = new Button("조회"); 
    topBtn.setIcon(MSFMainApp.ICONS.search16());
    topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			reload();
		}
	});
    buttonBar.add(topBtn);
    
    //출력물구분으로 전환하여 엑셀 로저장하거나 출력물로 전환 
    topBtn = new Button("퇴직보수총액신고"); 
    topBtn.setIcon(MSFMainApp.ICONS.text()); 
    buttonBar.add(topBtn);  
    
	btnInsr4300Print = new Button("정산산출내역");
	btnInsr4300Print.setIcon(MSFMainApp.ICONS.text());
	buttonBar.add(btnInsr4300Print);
	btnInsr4300Print.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
//			Insr4300Print("InsrP430001", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			RexPrint("INSRT430001");
		}
	});
	
	topBtn = new Button("엑셀");
	topBtn.setIcon(MSFMainApp.ICONS.text());
	buttonBar.add(topBtn);
	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			excelFileExport();
		}
	});
    
    plFrmInsr4300.add(buttonBar);       
    
    //파일업로드 처리
    plFrmInsr4300.setAction("myurl");
    plFrmInsr4300.setEncoding(Encoding.MULTIPART);
    plFrmInsr4300.setMethod(Method.POST);
     
        
    vp.add(plFrmInsr4300);
    //엣지변환
    //plFrmInsr4300.setSize("990px", "680px");
    plFrmInsr4300.setSize("990px", "730px");
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

private void createSearchForm() {   
     
	//  srhPyspGrdeCd = new HiddenField<String>(); 
	srhSystemkey = new HiddenField<String>();  //시스템키 


	sysComBass0150Dto = new PrgmComBass0150DTO();
	sysComBass0300Dto = new PrgmComBass0300DTO();
	sysComBass0400Dto = new PrgmComBass0400DTO();
	sysComBass0500Dto = new PrgmComBass0500DTO();
	msfCoCalendarDto = new SysCoCalendarDTO();
	sysComBass0350Dto = new PrgmComBass0350DTO();
	sysComBass0320Dto = new PrgmComBass0320DTO();

	//--------------------단위기관 불러 오는 함수 ------------------------------------------------
	lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	//--------------------단위기관 불러 오는 함수 ------------------------------------------------

	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	//급여구분 
	//		 sysComBass0300Dto.setRpsttvCd("B015");
	//		 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------

	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	//고용구분
	sysComBass0300Dto.setRpsttvCd("A002");
	lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------

	//--------------------공통 코드 불러 오는 함수 -----------------------------------------------
	 
	
	//재직구분
	sysComBass0300Dto.setRpsttvCd("A003");
	//sysComBass0300Dto.setMangeItem01("Y");
	lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
	lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {
		public void handleEvent(StoreEvent<BaseModel> be) {
			mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd);
			srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		}
	});

	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	sysComBass0300Dto.setRpsttvCd("A048");
	lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	//월 
	lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);

	lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 //-------------------관리부서 추가  
	sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
	//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
	sysComBass0400Dto.setDeptDspyYn("Y");
	sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

	lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);

	lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
			srhDeptCd.getInitStore().add(mDtalistDeptCd);

		}
	});     

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 직종 콤보박스 처리  시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	 */

	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  

			mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

		}
	});  

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 년도 콤보박스 처리  시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	 */

	plFrmInsr4300.setLayout(new FlowLayout());

	srhSystemkey = new HiddenField<String>(); 

	LayoutContainer lcSchCol = new LayoutContainer();
	//lcSchCol.setStyleAttribute("background-color","red");
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
	srhPayYr.setValueField("payYr");
	srhPayYr.setTriggerAction(TriggerAction.ALL);
	// srhPayYr.setEmptyText("--년도선택--");
	srhPayYr.setSelectOnFocus(true); 
	srhPayYr.setReadOnly(false);
	srhPayYr.setEnabled(true); 
	srhPayYr.setStore(lsPayYrStore);
	srhPayYr.setFieldLabel("정산년월"); 
	srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			checkInsr4300Auth("srhPayYr",lsPayYrStore);  

		}
	});
	srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
			BaseModel bmPayYr =  se.getSelectedItem(); 
			if (bmPayYr != null) {

				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

					if (srhDeptCd.getListView().getChecked().size() > 0) {  

						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
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
	lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
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
			checkInsr4300Auth("srhPayMonth",lsPayMonth);  

		}
	});
	layoutContainer_9.add(srhPayMonth, new FormData("100%"));
	lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
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
				checkInsr4300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
			}      


		}
	});    
	srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			sysComBass0400Dto = new PrgmComBass0400DTO();
	    	 
			srhDeptCd.reset();  //2015.12.07 추가 
			sysComBass0400Dto.setDeptDspyYn("Y");
			sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
			//--------------------부서 불러 오는 함수 ------------------------------------------------
			lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
			//--------------------부서 불러 오는 함수 ------------------------------------------------
			lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
					srhDeptCd.getInitStore().add(mDtalistDeptCd);

				}
			});  
		} 
	});
	layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	layoutContainer.setBorders(false);

	LayoutContainer layoutContainer_1 = new LayoutContainer();
	layoutContainer_1.setLayout(new ColumnLayout());

	LayoutContainer layoutContainer_101 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_101.setLayout(frmlytSch);

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
				checkInsr4300Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	layoutContainer_101.add(srhEmymtDivCd, new FormData("100%"));
	layoutContainer_101.setBorders(false); 

	LayoutContainer layoutContainer_102 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(1); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	frmlytSch.setDefaultWidth(0);
	layoutContainer_102.setLayout(frmlytSch);



	srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	srhRepbtyBusinDivCd.setForceSelection(true);
	srhRepbtyBusinDivCd.setAllowBlank(false);
	srhRepbtyBusinDivCd.setMinChars(1);
	srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	srhRepbtyBusinDivCd.setValueField("commCd");
	srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	srhRepbtyBusinDivCd.setHideLabel(true);
	//srhRepbtyBusinDivCd.setLabelSeparator("");
	// srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  

			//		       	  EventType type = be.getType();
			//			    	   if (type == Store.Add) { 
			//		           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			//			    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
			//		           	 }  

		}
	});  

	layoutContainer_102.add(srhRepbtyBusinDivCd, new FormData("100%"));
	layoutContainer_102.setBorders(false); 


	layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	layoutContainer_1.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	layoutContainer_1.setBorders(false); 



	lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
	lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	//lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));//

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
	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
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
      	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
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

	srhDeptCd = new MSFMultiComboBox<ModelData>();
	srhDeptCd.setName("srhDeptCd");
	srhDeptCd.setEmptyText("--부서선택--");
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
				checkInsr4300Auth("srhDeptCd", lsDeptCd); 
			}

		}
	});    

	srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
		@Override
		public void handleEvent(ComponentEvent ce) { 

			if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

				if (srhDeptCd.getListView().getChecked().size() > 0) {  

					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));    
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
				String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				sysComBass0320Dto.setDeptCd(strDeptCd);
				lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
				lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  

						mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
						srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

					}
				});  

			} else {

				sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				sysComBass0320Dto.setDeptCd(strDeptCd);
				lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
				lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  

						mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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

	LayoutContainer layoutContainer_10 = new LayoutContainer();

	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_10.setLayout(frmlytSch);

	//직종 직종세처리  
	LayoutContainer lcTypOccuCd = new LayoutContainer();
	lcTypOccuCd.setLayout(new ColumnLayout());

	LayoutContainer layoutContainer_20 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_20.setLayout(frmlytSch); 


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
	layoutContainer_20.add(srhDeptGpCd, new FormData("100%")); 

	LayoutContainer layoutContainer_21 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(70); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_21.setLayout(frmlytSch); 

	srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	srhTypOccuCd.setName("srhTypOccuCd"); 
	srhTypOccuCd.setEmptyText("--직종선택--"); 
	srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	srhTypOccuCd.setWidth(100);
	srhTypOccuCd.setHideLabel(true);
	//srhTypOccuCd.setFieldLabel("직종");
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

						srhTypOccuCd.getListView().setChecked(mdSelect, true); 
						srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
						// }  

				}  
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					//checkInsr4300Auth("srhTypOccuCd", lsTypOccuCd); 
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

	lcTypOccuCd.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
	lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
	lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
	layoutContainer_21.setBorders(false);

	layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
	layoutContainer_10.setBorders(false);


	fieldSet.add(layoutContainer_13);
	layoutContainer_13.setBorders(false);

	layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	//layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));

	LayoutContainer lcSchCol3 = new LayoutContainer();
	lcSchCol3.setLayout(new ColumnLayout());

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

	 LayoutContainer layoutContainer_5 = new LayoutContainer();
	    layoutContainer_5.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_6 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_6.setLayout(frmlytSch);
	    
	    srhNm = new TextField<String>();
	    srhNm.setName("srhNm");
	    srhNm.setFieldLabel("성명");
	    layoutContainer_6.add(srhNm, new FormData("100%"));
	    srhNm.addKeyListener(new KeyListener() {
	    	  @Override
	        public void componentKeyDown(ComponentEvent event) {
	           
	            srhNm.validate();
	            if (MSFSharedUtils.allowNulls(srhNm.getValue()).trim().equals("")) {
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
//	    srhNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	        @Override
//	        public void handleEvent(BaseEvent be) {  
//	            if (MSFSharedUtils.allowNulls(srhNm.getValue()).trim().equals("")) {
//	                srhSystemkey.setValue("");
//	                srhResnRegnNum.setValue("");
//	            }
//	         
//	        } 
//	   }); 
	    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	    layoutContainer_6.setBorders(false);
	    
	    Button btnHanNm = new Button("검색");
	    layoutContainer_5.add(btnHanNm);
	    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	        public void handleEvent(ButtonEvent e) {
	            srhSystemkey.setValue("");
	            srhResnRegnNum.setValue("");   
	          fnPopupPsnl0100() ;
	              
	        }
	    });
	    
	    LayoutContainer layoutContainer_7 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_7.setLayout(frmlytSch);
	    
	    /** column 주민등록번호 : resnRegnNum */
	    srhResnRegnNum = new TextField<String>();
	    srhResnRegnNum.setName("srhResnRegnNum");
	    new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
	    srhResnRegnNum.setHideLabel(true);
	    srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
	        @Override
	        public void handleEvent(BaseEvent be) {  
	            if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
	                srhSystemkey.setValue("");
	                srhNm.setValue("");
	            }
	         
	        } 
	  }); 
	    layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.41));
	    layoutContainer_7.setBorders(false); 
	    layoutContainer_5.setBorders(false);
	    
	    
	    LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		layoutContainer_14.setLayout(frmlytSch);

		srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
		srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
		srhHdofcCodtnCd.setEmptyText("--재직구분선택--");
		srhHdofcCodtnCd.setReadOnly(true);
		srhHdofcCodtnCd.setEnabled(true);
		srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
		srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		srhHdofcCodtnCd.setWidth(100);
		srhHdofcCodtnCd.setFieldLabel("재직구분");
		srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				checkInsr4300Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);
			}
		});
		srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
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
		layoutContainer_14.add(srhHdofcCodtnCd, new FormData("100%"));

		layoutContainer_14.setBorders(false);
		 
	    lcSchCol3.setBorders(false);

		lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		
		fieldSet.add(lcSchCol3);
		
	
	plFrmInsr4300.add(fieldSet);
  }  

private void  displayDtilOccuInttnCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        
        //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
            
            sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
            List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
            String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
            
           // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
            
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                
                lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
              //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                
                lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                    public void handleEvent(StoreEvent<BaseModel> be) {  
                        mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
	 
private void createForm() {
    
//    FieldSet fieldSet = new FieldSet(); 
//    fieldSet.setSize("958px", "492px");  //492
//    fieldSet.setHeadingHtml("");


    LayoutContainer layoutContainer = new LayoutContainer();   

    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false); 
    cp01.setSize(950, 500);
    cp01.setLayout(new FitLayout());
    
    LayoutContainer layoutContainer_16 = new LayoutContainer(); 
    layoutContainer_16.setLayout(new ColumnLayout());
  //  layoutContainer_16.setBorders(false);  
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_1.setLayout(frmlytStd);
    
    FieldSet fldstNewFieldset = new FieldSet();
    fldstNewFieldset.setSize("958px", "490px");
    
//    ContentPanel cntntpnlNewContentpanel = new ContentPanel();
//    cntntpnlNewContentpanel.setHeaderVisible(false); 
//    fldstNewFieldset.add(cntntpnlNewContentpanel);
    
    fldstNewFieldset.add(createCheckBoxGrid(),new FormData("100%"));
    fldstNewFieldset.setHeadingHtml("대상자정보");
    fldstNewFieldset.setCollapsible(false);
    fldstNewFieldset.setStyleAttribute("marginTop", "10px");
    layoutContainer_1.add(fldstNewFieldset);
    layoutContainer_16.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
    
    cp01.add(layoutContainer_16);
    layoutContainer_16.setSize("934", "490");
    layoutContainer.add(cp01) ;   
      
    fldstNewFieldset.add(layoutContainer,new FormData("100%"));    
    
    plFrmInsr4300.add(fldstNewFieldset);
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


private LayoutContainer createCheckBoxGrid() {
	LayoutContainer lcStdGrid = new LayoutContainer();
	FormLayout frmlytStd = new FormLayout();
	lcStdGrid.setLayout(frmlytStd);
	
	ContentPanel cpGrid = new ContentPanel();
	cpGrid.setBodyBorder(false);
	cpGrid.setHeaderVisible(false);
	cpGrid.setLayout(new FitLayout());
	cpGrid.setSize(945, 460);
	
	insr3400GridPanel = new MSFGridPanel(insr3400Def, false, false, false, false, false);
	insr3400GridPanel.setHeaderVisible(false);
	insr3400GridPanel.setBodyBorder(true);
	insr3400GridPanel.setBorders(true);
	//Set the CustomForm to be used by the GridPanel
	
	/* 2줄파싱 */
	insr3400GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 9, new HeaderGroupConfig("기납부", 1, 3));
	
	final Grid insr3400Grid = insr3400GridPanel.getMsfGrid().getGrid();
	insr3400Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent be) {
			if(insr3400GridPanel.getCurrentlySelectedItem() != null) {
				//insr3400GridPanel.getMSFFormPanel().bind(insr3400GridPanel.getCurrentlySelectedItem());
				setRecord(insr3400GridPanel.getCurrentlySelectedItem());
				if(actionDatabase == ActionDatabase.INSERT) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		}
	});
	
	cpGrid.add(insr3400GridPanel);
	lcStdGrid.add(cpGrid);
	
	return lcStdGrid;
}  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 


private void createBottom() {
	 
	 
	  ButtonBar buttonBar = new ButtonBar();    
	  buttonBar.setAlignment(HorizontalAlignment.RIGHT);
//    buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//      public void componentSelected(ButtonEvent ce) {   
//       
//      }   
//    }));   
//    buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//      public void componentSelected(ButtonEvent ce) {   
//         
//      }   
//    }));    
 	 
	 
	plFrmInsr4300.add(buttonBar);    
	
}

	/* 조회 */
	public void reload() {
		// TODO Auto-generated method stub
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
			if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				return;
			}
		}
		
		IColumnFilter filters = null;
		insr3400GridPanel.getTableDef().setTableColumnFilters(filters);
		insr3400GridPanel.getTableDef().addColumnFilter(  "nofctYrMnthNum"
														,   MSFSharedUtils.getSelectedComboValue(srhPayYr,	  "year")
														  + MSFSharedUtils.getSelectedComboValue(srhPayMonth, "month")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3400GridPanel.getTableDef().addColumnFilter(  "payrMangDeptCd"
														, MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3400GridPanel.getTableDef().addColumnFilter(  "emymtDivCd"
														, MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );   
		
		String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
		insr3400GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		//20180305추가 
		insr3400GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr3400GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
		insr3400GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);
		
		String strDtilOccuClsDivCd = InsrUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																	   , srhDtilOccuInttnCd.getValue()
																	   , "dtilOccuClsNm"
																	   , "dtilOccuClsDivCd"
																	  );
		insr3400GridPanel.getTableDef().addColumnFilter("dtilOccuClsDivCd", strDtilOccuClsDivCd, SimpleColumnFilter.OPERATOR_EQUALS);
		
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for (int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
		}
		insr3400GridPanel.getTableDef().addColumnFilter(  "hdofcCodtnCd"
														, strHdofcCodtnCd
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3400GridPanel.getTableDef().addColumnFilter(  "businCd"
														, MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3400GridPanel.getTableDef().addColumnFilter("systemkey"
														, MSFSharedUtils.allowNulls(srhSystemkey.getValue())
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3400GridPanel.getTableDef().addColumnFilter("nm", MSFSharedUtils.allowNulls(srhNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		insr3400GridPanel.getTableDef().addColumnFilter(  "resnRegnNum"
														, MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3400GridPanel.reload();
	}
	
//	private void resetForm(){
//		   soctyInsurCmptnDt.clear();		/** column 사회보험작성일자 : soctyInsurCmptnDt */	
//		   socnsrIssRegVal02.clear();    /** column 성명 : socnsrAqtnRegVal02 */
//		   socnsrIssRegVal03.clear();    /** column 주민등록번호 : socnsrAqtnRegVal03 */
//		   emymtDivNm.clear();			// 고용구분
//		   deptNm.clear();		 		// 부서
//		   typOccuNm.clear(); 			// 직종
//		   //DtilOccuClsDivNm.clear(); 		// 직종세
//		   socInsrLssEmymtNum.clear(); //일련번호
//		   tempDateFld1.clear(); 			// 이직(퇴직일)
//		   tempDateFld2.clear(); 			// 취득일
//		   tempNumFle.clear();		//통산피보험 단위기간
//		   systemkey.clear();
//		   dpobCd.clear();
//		   deptCd.clear();
//		   icncDt.clear();
//		   tempComboTop_0.clear();
//		   tempComboTop_1.clear(); 		//사유1
//		   tempComboTop_2.clear(); 		//사유2
//		   tempComboTop_3.clear(); 		//사유3
//		   tempTopDate_1_S.clear(); 					//날짜1 시작
//		   tempTopDate_1_E.clear(); 					//날짜1 종료
//		   tempTopDate_2_S.clear(); 					//날짜2 시작
//		   tempTopDate_2_E.clear(); 					//날짜2 종료
//		   tempTopDate_3_S.clear(); 					//날짜3 시작
//		   tempTopDate_3_E.clear(); 					//날짜3 종료
//		   tempMidDate_1_S.clear(); 					//날짜1 시작
//		   tempMidDate_1_E.clear(); 					//날짜1 종료
//		   tempMidDate_2_S.clear(); 					//날짜2 시작
//		   tempMidDate_2_E.clear(); 					//날짜2 종료
//		   tempMidDate_3_S.clear(); 					//날짜3 시작
//		   tempMidDate_3_E.clear(); 					//날짜3 종료
//		   tempMidDate_4_S.clear(); 					//날짜4 시작
//		   tempMidDate_4_E.clear(); 					//날짜4 종료
//		   tempNumDaysSumFle.clear();				//통산피보험 단위기간
//		   tempNumDaysFle_1.clear();				//총보수 1
//		   tempNumDaysFle_2.clear();				//총보수 2
//		   tempNumDaysFle_3.clear();				//총보수 3
//		   tempNumDaysFle_4.clear();				//총보수 4
//		   tempNumDaysFle_5.clear();				//총보수 5
//		   tempNumFle_1.clear();					//기본금 1
//		   tempNumFle_2.clear();					//기본금 2
//		   tempNumFle_3.clear();					//기본금 3
//		   tempNumFle_4.clear();					//기본금 4
//		   tempSumNumFle_1.clear();				//기본금 합계 1
//		   tempNumFle_5.clear();					//기타수당 1
//		   tempNumFle_6.clear();					//기타수당 2
//		   tempNumFle_7.clear();					//기타수당 3
//		   tempNumFle_8.clear();					//기타수당 4
//		   tempSumNumFle_2.clear();				//기타수당 합계 1
//		   tempNumFle_9.clear();					//상여금 1
//		   tempSumNumFle_3.clear();				//상여금 합계 1
//		   tempNumFle_10.clear();					//연차수당 1
//		   tempSumNumFle_4.clear();				//연차수당 합계 1
//		   tempNumFle_11.clear();					//기타 1
//		   tempSumNumFle_5.clear();				//기타 합계 1
//		   //tempUnderNumFle_1.clear();				//총임금액 
//		   //tempUnderNumFle_2.clear();				//총일수
//		   //tempUnderNumFle_3.clear();				//평균임금 (총임금액/총일수)
//		   tempUnderNumFle_4.clear();				//통상임금
//		   tempUnderNumFle_5.clear();				//기준임금
//		   tempUnderNumFle_6.clear();				//1일 소정근로 시간
//		   tempUnderNumFle_7.clear();				//퇴직금 수령액
//		   tempUnderTxtFle_1.clear();		//기타(퇴직금외 기타 금품)
//		   tempUnderTxtFle_2.clear();		//구체적 사유
//		   systemKeys = "";
//		   
//		   insr3400GridPanel.getMsfGrid().clearData();
//		   
//	   }
	
	/* (재)정산 */
	public void reCalculate() {
		if(MSFSharedUtils.paramNull(records)) {
			
			actionDatabase = ActionDatabase.INSERT;
			
			Insr3400DTO insr3400dto = new Insr3400DTO();
			
			insr3400dto.setNofctYrMnthNum(  MSFSharedUtils.getSelectedComboValue(srhPayYr,		"year")
										  + MSFSharedUtils.getSelectedComboValue(srhPayMonth,	"month")
										 );
			insr4300Service.activityOnInsr4300(insr3400dto, actionDatabase, new AsyncCallback<Long>() {
				public void onFailure(Throwable caught) {
					MessageBox.alert(  MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									 , MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsr4300(" + actionDatabase.name() + ") : " + caught), null
									);
				}
				public void onSuccess(Long result) {
					if(result == 0) {
						MessageBox.alert(  MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
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
	
	public void setRecord(BaseModel record) {
		this.record = record;
	}
	
	private Insr4300 getThis() {
		return this;
	}
	
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣는 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhNm.getValue()); // 인사
//		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form(); //우편번호
		
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
		
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if(!"".equals(mapModel.get("systemkey"))) {
					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); //시스템키
					srhNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); //주민번호
				}
			}
		});
	}
	
	/* 엑셀 다운로드 */
	private void excelFileExport() {
		HashMap<String, String> param = new HashMap<String, String>();
		
		String year	 = InsrUtils.getSelectedComboValue(srhPayYr,	"year");
		String month = InsrUtils.getSelectedComboValue(srhPayMonth, "month");
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for(int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
		}
		
		param.put("nofctYrMnthNum",	  year.concat(month));
		param.put("payrMangDeptCd",	  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("emymtDivCd",		  MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
		param.put("deptCd",			  InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",		  InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));
		param.put("dtilOccuClsDivCd", InsrUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																		, srhDtilOccuInttnCd.getValue()
																		, "dtilOccuClsNm"
																		, "dtilOccuClsDivCd"
																	   )
				 );
		param.put("hdofcCodtnCd",		  strHdofcCodtnCd);
		param.put("businCd",		  MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
		param.put("systemkey",		  MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
		param.put("nm",				  MSFSharedUtils.allowNulls(srhNm.getValue()));
		param.put("resnRegnNum",	  MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		
		if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			} else {
				insr3400GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr4300Export.do", "extgwtFrame", param);
			}
		} else {
			insr3400GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr4300Export.do", "extgwtFrame", param);
		}
	}
	
	private void Insr4300Print(String fileName, String repType) {
		if(PayGenConst.REPORT_DIV_TYPE02.equals(repType.trim())) {
			RdaPrint(fileName);
		} else if(PayGenConst.REPORT_DIV_TYPE01.equals(repType.trim())) {
			RexPrint(fileName);
		} else {
			Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		}
	}
	
	private void RdaPrint(String fileName) {
		
	}
	
	private void RexPrint(String fileName) {
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
		System.out.println("출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR");
		String strDirPath = "INSR";
		
		// reb 출력물
		String rexFileName = fileName + ".crf";
//		String rexFileName = fileName + ".reb";
		
		// 보낼 파라미터
		
		// 검색조건
		String serarchParam = "";
		
		String year	 = InsrUtils.getSelectedComboValue(srhPayYr,	"year");
		String month = InsrUtils.getSelectedComboValue(srhPayMonth,	"month");
		
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray  = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for(int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
		}
		
		String pymtYrMnth = year.concat(month);
//		String payCd = srhPayCd.getValue();
	 	
		String payrMangDeptCd  = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
		String emymtDivCd	   = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");
		String deptCd		   = InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
		String typOccuCd	   = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
		String mangeDeptCd	   = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd");
		String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
		String businCd		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd");
		String nm			   = MSFSharedUtils.allowNulls(srhNm.getValue());
		String resnRegnNum	   = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 

		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
		
		String deptCdAuth		   = MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(  lsDeptCd
																								 , MSFSharedUtils.allowNulls(srhDeptCd.getValue())
																								 , "deptNmRtchnt", "deptCd"
																								)
															  ).replace(",", "");
		String dtilOccuInttnCdAuth = MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																								 , MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue())
																								 , "dtilOccuClsNm"
																								 , "dtilOccuInttnCd")).replace(",", "");

		//그리드 선택 데이터 출력
		System.out.println("그리드 선택 데이터 출력");
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = insr3400GridPanel.getGrid().getSelectionModel().getSelectedItems();

		if(list != null && list.size() > 0) {
			String chkSysKey = "";
			int iCnt = 0;

			for(BaseModel bm : list){
				chkSysKey += bm.get("systemkey") + ",";
				iCnt = iCnt + 1;
			}
			keyCnt = iCnt;
			checkedSystemKeys = chkSysKey.substring(0, chkSysKey.length() - 1); //$10 시스템키
			System.out.println("시스템키는 넘기지 않고 검색조건만 넘김");
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
				System.out.println("선택한 시스템키 넘김");
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
			serarchParam += "" + MSFSharedUtils.allowNulls(nm)										+ "⊥";	/*$11 성명						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(resnRegnNum)								+ "⊥";	/*$12 주민번호					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(strHdofcCodtnCd)							+ "⊥";	/*$13 재직상태					*/
			
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
			serarchParam += "" + mangeDeptCd																+ "⊥";	/*$22 관리부서							*/
			
			String strParam = "" + serarchParam ;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

		//}else{
		//	MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
		//}
	}
	
	public native String getDetailTemplate() /*-{
		return ['<div class="details">',
		'<tpl for=".">',
		'<img src="{modPath}"><div class="details-info">',
		'<b>Image Name:</b>',
		'<span>{name}</span>',
		'<b>Size:</b>',
		'<span>{sizeString}</span>',
		'<b>Last Modified:</b>',
		'<span>{dateString}</span></div>',
		'</tpl>',
		'</div>'].join("");
	}-*/;
	


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