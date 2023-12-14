package com.app.exterms.statistics.client.form;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.client.service.PrgmComBass0400ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.statistics.client.utils.SttsUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Stts0100   extends MSFPanel {

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
    private VerticalPanel vp;
    private FormPanel plFrmStts0100; 
    private String txtForm = "";
    private XTemplate detailTp;
  
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
     

	  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;
	private boolean statCheck = false;
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
	private ButtonBar topStts0100Bar;
	private Button btnStts0100Init;
	private Button btnStts0100Sreach;
//	private Button btnStts0100Print;
	private Button btnStts0100Excel;
   /**
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    * 검색변수 선언 
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    */
	
	private LayoutContainer lcSch1_2 = new LayoutContainer(new ColumnLayout());		// 기간별
	private LayoutContainer lcSch1_2_1 = new LayoutContainer(new ColumnLayout());	// 기간별
	private LayoutContainer lcSch1_2_2 = new LayoutContainer(new ColumnLayout());	// 분기별
	private LayoutContainer lcSch1_2_3 = new LayoutContainer(new ColumnLayout());	// 월별
	
	
	private HiddenField<String> srhSystemkey;   						// 시스템키 
	
	private ComboBox<BaseModel> srhDateType;						// 기간구분(기간별, 분기별, 월별)
	private ComboBox<BaseModel> srhYr01;							// 월별 년
	private ComboBox<BaseModel> srhMnth;							// 월
    private DateField srhDayS;      								// 기간별 시작일
    private DateField srhDayE;      								// 기간별 종료일
    private ComboBox<BaseModel> srhYr02;							// 분기별 년
    private ComboBox<BaseModel> srhMnthS;							// 분기별 시작월
    private ComboBox<BaseModel> srhMnthE;							// 분기별 종료월
	private ComboBox<BaseModel> srhEmymtDivCd; 						// 고용구분
	private ComboBox<BaseModel> srhDataType;						// 조회 내역 구분
	
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 			// 재직구분
	private MSFMultiComboBox<ModelData> srhDeptCd; 					// 부서
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 				// 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 		// 직종세
	private ComboBox<BaseModel> srhBusinCd; 						// 사업
	
	private List<ModelData> mDtalistHdofcCodtnCd;					// 재직 멀티
	private List<ModelData> mDtalistDeptCd;							// 부서 멀티	
	private List<ModelData> mDtalistTypOccuCd;						// 직종 멀티
	private List<ModelData> mDtalistDtilOccuInttnCd;				// 직종세 멀티

	private boolean mutilCombo = false;

	private HiddenField<String> systemkey;	/** column SYSTEMKEY : systemkey */
	private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
	private HiddenField<String> month;
   
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
		
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	
	
    // -------------- store 선언 시작 ---------------
	private ListStore<BaseModel> lsDateType 		= new ListStore<BaseModel>();  	// 기간 구분
	private ListStore<BaseModel> lsYrStore 			= new ListStore<BaseModel>();  	// 년도 
	private ListStore<BaseModel> lsMonthStore 		= new ListStore<BaseModel>();  	// 월 
	private ListStore<BaseModel> lsDeptCd 		    = new ListStore<BaseModel>();	// 부서콤보
	private ListStore<BaseModel> lsDataType 		= new ListStore<BaseModel>();  	// 조회 구분
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분 
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	// 직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd	= new ListStore<BaseModel>();	// 직종세
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();	// 사업
	private ListStore<BaseModel> lsHdofcCodtnCd 	= new ListStore<BaseModel>();	//재직상태 
	// -------------- store 선언 종료 ---------------
    
    
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;	// 공통코드
    private PrgmComBass0400DTO sysComBass0400Dto; 	// 부서코드
    private PrgmComBass0500DTO sysComBass0500Dto; 	// 사업코드 
    private SysCoCalendarDTO    msfCoCalendarDto;  	// 날짜
    private PrgmComBass0350DTO sysComBass0350Dto; 	// 직종세
    private PrgmComBass0320DTO sysComBass0320Dto;	// 직종
    // -------------- DTO 선언 종료 --------------
    
    
	// -------------- 코드 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	//공통코드 
	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();	//부서코드 
	// -------------- 코드 호출 종료 --------------
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */	
	private String strDirPath;
	private String strParam;
	private String serarchParam;
	private String rdaFileName;
	private String rexFileName;
	private String checkedSystemKeys;
	private ContentPanel cp01;
	
	private HashMap<String, String> param;
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */		
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	    

	  /**
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   **/
	   
	  	/**
	 	 * 권한설정 처리 체크 AuthAction
	 	 */
	  	private void checkStts0100Auth( String authAction, ListStore<BaseModel>bm) {
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			 
			   if (!maskTracker) { unmask(); } 
			   authExecEnabled() ;
		   }	
	 	 }

	  	 
		 private void authExecEnabled() { 
		   //------------------
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작
				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
				 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 //----------------------------------------------------
			 Field<?>[] fldArrField = {srhDeptCd, srhEmymtDivCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
			 // ------------- 기간 구분 셋팅 
			 srhDateType.setValue(lsDateType.getAt(0));
			 // -------------  기간 구분 셋팅 
			 
			 // ------------- 월별 날짜 셋팅 
			 srhYr01.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
			 srhMnth.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
			 // ------------- 월별 날짜 셋팅 
			 
			 
			 // ------------- 분기별 날짜 셋팅 
			 srhYr02.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//분기별 년도
			 srhMnthS.setValue(lsMonthStore.findModel("month", DateTimeFormat.getFormat("MM").format(new Date()))); 
//			 srhMnthE.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
			 // ------------- 분기별 날짜 셋팅 
			 
			 
//			 srhClutYr.setValue(lsClutYrStore.findModel("year",String.valueOf(Integer.parseInt(DateTimeFormat.getFormat("yyyy").format(new Date())) - 1)));
//          srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
//			 SttsUtils.setSelectedComboValue(srhDateType, "season", "commCd");
          
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		
		 }
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) { 
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

	 		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 
		     
		
//			authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
			authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			authMapDef.put("srhDeptCd",Boolean.FALSE); 
		   // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
		    
		   

	 		 gwtExtAuth.setCheckMapDef(authMapDef);
	 		
	 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//	 			 권한 검색조건처리를 위해 추가된 부분
	 			 mask("[화면로딩] 초기화 진행 중!");
	 		 }	
	 		 tmMask.scheduleRepeating(5000);
	 	 }
	 	/**
	 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     * 	print Service 선언부 시작
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     **/
		private void Stts0100Print(String fileName, String repType, String dataType) {
			   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
//				   RdaPrint(fileName);
			   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
				   RexPrint(fileName, dataType);
			   } else {
				   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
			   }
		    }	
		
		
		//rex
		private void RexPrint(final String fileName, final String dataType) {
			
			// 출력물 디렉토리 패스경로 통계 : STTS
			strDirPath = new String();
			strDirPath = "STTS";
//			strDirPath = "PSNL";
			
			// rex 출력물
			rexFileName = new String();
			rexFileName = fileName+".crf";
			
			// 보낼 파라미터
			strParam = new String();
			
			String strDateType = SttsUtils.getSelectedComboValue(srhDateType, "commCd");								// 기간 구분
				
			String strYr01 = SttsUtils.getSelectedComboValue(srhYr01, "yearDisp");										// 월별_년			
			String strMnth = SttsUtils.getSelectedComboValue(srhMnth, "monthDisp");										// 월별_월
			
			String strDayS = SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd");										// 기간별_시작일
			String strDayE = SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd");										// 기간별_종료일
			
			String strYr02 = SttsUtils.getSelectedComboValue(srhYr02, "yearDisp");										// 분기별_년
			String strMnthS = SttsUtils.getSelectedComboValue(srhMnthS, "monthDisp");									// 분기별_시작월
			String strMnthE = SttsUtils.getSelectedComboValue(srhMnthE, "monthDisp");									// 분기별_종료월
			
			String strDataType = SttsUtils.getSelectedComboValue(srhDataType, "commCd");								// 조회 구분
			
			String strEmymtDivCd = SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");							// 고용 구분
			
			String  strDeptCd = SttsUtils.getPrintStrToMultiData(lsDeptCd
						, MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd"); 					// 부서
		
			String  strTypOccuCd = SttsUtils.getPrintStrToMultiData(lsTypOccuCd
						, MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  			// 직종
			
						String strDtilOccuInttnCd = MSFSharedUtils.allowNulls(SttsUtils.getPrintStrToMultiData(lsDtilOccuInttnCd
						, MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")); // 직종세
			
			String strBusinCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");								// 사업
			
		
			// 노동력조사 
			if("S0020010".equals(dataType)) {
				
				strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) + "⊥";  									// $1 사업장코드
				
				if("S0010030".equals(strDateType)) {																							// $2 월 : 월별
					strParam+= "" + SttsUtils.getSelectedComboValue(srhYr01, "year") + SttsUtils.getSelectedComboValue(srhMnth, "month") + "⊥";
				}
//				else if("S0010020".equals(strDateType)){	// $2 월 : 분기별
//					strParam+= "" + SttsUtils.getSelectedComboValue(srhYr02, "year") + month.getValue() + "⊥";
//				}
				
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsDeptCd, 
									MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; 								// $3 부서
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsTypOccuCd, 
									MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  							// $4 직종
				strParam += ""+ MSFSharedUtils.allowNulls(SttsUtils.getPrintStrToMultiData(lsDtilOccuInttnCd, 
									MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd"))+"⊥"; 			// $5 직종세
				strParam += ""+ MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";   												// $6 사업
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd") +  "⊥";			// $7 재직
			
			// 사업체현황조사(통계)
			}else if("S0020020".equals(dataType)) {
				
				strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) + "⊥";  	// $1 사업장코드
				
				if("S0010030".equals(strDateType)) {		// $2 월 : 월별
					strParam += "" + SttsUtils.getSelectedComboValue(srhYr01, "year") + SttsUtils.getSelectedComboValue(srhMnth, "month") + "⊥";
				}else if("S0010020".equals(strDateType)){	// $2 월 : 분기별
					strParam += "" + SttsUtils.getSelectedComboValue(srhYr02, "year") + month.getValue() + "⊥";
				}
				
				strParam += "" + SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")+"⊥";					// $3 고용구분(기간제)
				strParam += "" + SttsUtils.getSelectedComboValue(srhDateType, "commCd")+"⊥";					// $4 기간구분
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsDeptCd, 
						MSFSharedUtils.allowNulls(srhDeptCd.getValue()), "deptNmRtchnt","deptCd")+"⊥"; 			// $5 부서
				strParam += ""+ MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";   				// $6 사업
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd") +  "⊥";	// $7 재직
			
			// 사업체현황조사(상세)
			}else if("S0020030".equals(dataType)) {
				
				strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) + "⊥";  //$1 사업장코드
				
				strParam += "" + SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd")+"⊥";					// $2 시작기간
				strParam += "" + SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd")+"⊥";					// $3 종료기간
				strParam += "" + SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd") + "⊥";			// $4 고용구분(기간제)
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsDeptCd, 
						MSFSharedUtils.allowNulls(srhDeptCd.getValue()), "deptNmRtchnt","deptCd")+"⊥"; 		// $5 부서
				strParam += ""+ MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";   			// $6 사업
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd") +  "⊥";	// $7 재직
			
			// 근로자명부(공무직)
			}else if("S0020040".equals(dataType)) {
				
				strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) + "⊥";  				// $1 사업장코드
				
				strParam += "" + SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd")+"⊥";									// $2 시작기간
				strParam += "" + SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd")+"⊥";									// $3 종료기간
				strParam += "" + SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd") + "⊥";							// $4 고용구분(공무직)
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsDeptCd, 
						MSFSharedUtils.allowNulls(srhDeptCd.getValue()), "deptNmRtchnt","deptCd")+"⊥"; 						// $5 부서
				strParam += ""+SttsUtils.getPrintStrToMultiData(lsTypOccuCd,
						MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  					// $6 직종
				strParam += ""+MSFSharedUtils.allowNulls(SttsUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,
						MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd"))+"⊥"; 	// $7 직종세
				strParam += ""+SttsUtils.getPrintStrToMultiData(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd") +  "⊥";	// $8 재직

			// 근로자현황
			}else if("S0020050".equals(dataType)) {
				
				strParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd()) + "⊥";  				// $1 사업장코드
				
				strParam += "" + SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd")+"⊥";									// $2 시작기간
				strParam += "" + SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd")+"⊥";									// $3 종료기간
				strParam += "" + SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")+"⊥";								// $4 고용구분(공무직)
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsDeptCd, 
						MSFSharedUtils.allowNulls(srhDeptCd.getValue()), "deptNmRtchnt","deptCd")+"⊥"; 						// $5 부서
				strParam += ""+SttsUtils.getPrintStrToMultiData(lsTypOccuCd,
						MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  					// $6 직종
				strParam += ""+MSFSharedUtils.allowNulls(SttsUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,
						MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd"))+"⊥"; 	// $7 직종세
				strParam += ""+ MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";   							// $8 사업
				strParam += ""+ SttsUtils.getPrintStrToMultiData(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd") +  "⊥";	// $9 재직
			}else {
				 Window.alert("조회구분을 선택해 주세요.");
			}
			
			// 출력물 호출
			printPanel();
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
	  		
//	  		detailTp = XTemplate.create(getDetailTemplate());
	  		vp = new VerticalPanel();
	  		vp.setSpacing(10);
	  		createStts0100Form();  	// 화면 기본정보를 설정
	  		createSearchForm();		// 검색조건
	  		createMsfGridForm();  	// 출력화면
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
		public Stts0100() {
			setSize("1010px", "700px");  
		} 

		public Stts0100(String txtForm) {
		      this.txtForm = txtForm;
		}
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		  
		
	private void createStts0100Form() {
			
		plFrmStts0100 = new FormPanel();
		plFrmStts0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 근로자현황조회"));
		plFrmStts0100.setIcon(MSFMainApp.ICONS.text());
		plFrmStts0100.setPadding(2);
		plFrmStts0100.setFrame(true);
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("근로자현황조회","STTS0100");
				}
			});
		plFrmStts0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmStts0100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmStts0100.setSize("990px", "680px");
		plFrmStts0100.setLayout(new FlowLayout());
		
 
		//멀티콤보박스 닫기 
		plFrmStts0100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
	            
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
					}  else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						//재직
						srhHdofcCodtnCd.showClose(ce);
						mutilCombo = false;
					}
				}
			} 
		});
	        
		/** 상단 버튼 ButtonBar**/
		topStts0100Bar = new ButtonBar();    
		topStts0100Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
//			btnStts0100Init = new Button("초기화");  
//			btnStts0100Init.setIcon(MSFMainApp.ICONS.new16());
//			topStts0100Bar.add(btnStts0100Init);
			    
		btnStts0100Init = new Button("초기화");  
		btnStts0100Init.setIcon(MSFMainApp.ICONS.new16());
		topStts0100Bar.add(btnStts0100Init); 
		btnStts0100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) {
	    		//초기화 
	    		formInit();
	    		
	    		cp01.hide();
			}
		}); 
 
		      
		btnStts0100Sreach = new Button("조 회", Stts0100ButtonListener);
		btnStts0100Sreach.setIcon(MSFMainApp.ICONS.search());
		topStts0100Bar.add(btnStts0100Sreach);
//		btnStts0100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				// 조회버튼 클릭시 처리
//				reloadStts0100();
//			}
//		});
		
		
		btnStts0100Excel = new Button("기간제근로자운영현황");
		btnStts0100Excel.setIcon(MSFMainApp.ICONS.excel16());
		topStts0100Bar.add(btnStts0100Excel);
		btnStts0100Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//엑셀저장  
				excelFileExport();
			}
		});
		
		
		
		
		
 
		plFrmStts0100.add(topStts0100Bar);
		      
//		// 파일업로드 처리
//		plFrmStts0100.setAction("myurl");
//		plFrmStts0100.setEncoding(Encoding.MULTIPART);
//		plFrmStts0100.setMethod(Method.POST);
		vp.add(plFrmStts0100);


	}
  
		
	/** 검색조건 **/
    private void createSearchForm() { 
    	
    	month = new HiddenField<String>();
    	
    	
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0400Dto = new PrgmComBass0400DTO();
        sysComBass0500Dto = new PrgmComBass0500DTO();
        msfCoCalendarDto  = new SysCoCalendarDTO();
        sysComBass0350Dto = new PrgmComBass0350DTO();
        sysComBass0320Dto = new PrgmComBass0320DTO();
        
        
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        sysComBass0300Dto.setRpsttvCd("A002");	//고용구분
        lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        /**  
         	 	STTS001		STTS	S001	기간구분코드
        	 	S0010010	S001	0010	기간별
        	 	S0010020	S001	0020	분기별
        	 	S0010030	S001	0030	월별
        **/
        sysComBass0300Dto.setRpsttvCd("S001");	//고용구분
        lsDateType = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        
        /**  
		 	S0020010	S002	0010	노동력조사
		 	S0020020	S002	0020	기간제근로자현황(통계)
		 	S0020030	S002	0030	기간제근로자현황(상세)
		 	S0020040	S002	0040	근로자명부
		 	S0020050	S002	0050	근로자현황
         **/
        sysComBass0300Dto.setRpsttvCd("S002");	//고용구분
        lsDataType = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        
    	//재직상태  
    	sysComBass0300Dto.setRpsttvCd("A003");
    	lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
    	lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
    		public void handleEvent(StoreEvent<BaseModel> be) {  
    			mDtalistHdofcCodtnCd = SttsUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
    	        srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
    	     }
    	});   
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        
        
        //--------------------부서 불러 오는 함수 ------------------------------------------------
	    sysComBass0400Dto.setDeptDspyYn("Y");
	    sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	    sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	     
	    lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	     
	    lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	    	public void handleEvent(StoreEvent<BaseModel> be) {  
	    		mDtalistDeptCd = SttsUtils.getDeptCdModelData(lsDeptCd) ; 
	    		srhDeptCd.getInitStore().add(mDtalistDeptCd);
	    	}
	    }); 
	    //--------------------부서 불러 오는 함수 ------------------------------------------------

	    
        //--------------------년도 불러 오는 함수 ------------------------------------------------
        lsYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);	
        //--------------------년도 불러 오는 함수 ------------------------------------------------ 
        
        
        //--------------------월 불러 오는 함수 ------------------------------------------------ 
        lsMonthStore = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
        //--------------------월 불러 오는 함수 ------------------------------------------------ 
        
       /**
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * 직종 콤보박스 처리  시작
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
        */
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				mDtalistTypOccuCd = SttsUtils.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

			}
		});
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 직종 콤보박스 처리  종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
		 */
		
		dpobCd = new HiddenField<String>(); 		// 사업장코드
		systemkey = new HiddenField<String>(); 		// 시스템키
		
		plFrmStts0100.setLayout(new FlowLayout());


		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		// fieldSet.setCheckboxToggle(false);
		
		LayoutContainer lcSchCol = new LayoutContainer();
		
		
		LayoutContainer lcSch1 = new LayoutContainer();
		lcSch1.setLayout(new ColumnLayout());
		
		
		LayoutContainer lcSch1_1 = new LayoutContainer();
		FormLayout frmlytSch1_1 = new FormLayout();
		frmlytSch1_1.setLabelWidth(60);
		frmlytSch1_1.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSch1_1.setLayout(frmlytSch1_1);
		
		srhDateType = new ComboBox<BaseModel>();
		srhDateType.setName("srhDateType");
		srhDateType.setForceSelection(true);
		srhDateType.setMinChars(1);
		srhDateType.setDisplayField("commCdNm");
		srhDateType.setValueField("commCd");
		srhDateType.setTriggerAction(TriggerAction.ALL);
		srhDateType.setEmptyText("-- 기간 선택 --");
		srhDateType.setSelectOnFocus(true); 
		srhDateType.setFieldLabel("기간구분"); 
		srhDateType.setStore(lsDateType); 
		srhDateType.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
//				SttsUtils.setSelectedComboValue(srhDateType, "S0010010", "commCd");
//				srhDateType.setValue(lsDateType.getAt(0));
			}
		});
		
		srhDateType.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// TODO Auto-generated method stub
				// 기간 선택에 따라 날짜를 보여준다.
				
				
				//lcSch1_2_1 기간별 lcSch1_2_2 분기별 lcSch1_2_3 월별
				if("S0010010".equals(SttsUtils.getSelectedComboValue(srhDateType))) {		// 기간별
					
					lcSch1_2_3.hide();
					lcSch1_2_2.hide();
					lcSch1_2_1.show();
					
					setInitDate();	// 기간 셋팅
					
//					srhYr01.reset();
//					srhMnth.reset();
//					
//					srhYr02.reset();
//					srhMnthS.reset();
//					srhMnthE.reset();
					
				}else if("S0010020".equals(SttsUtils.getSelectedComboValue(srhDateType))) {	// 분기별
					
					lcSch1_2_3.hide();
					lcSch1_2_2.show();
					lcSch1_2_1.hide();
					
//					srhYr01.reset();
//					srhMnth.reset();
//					
//					srhDayS.reset();
//					srhDayE.reset();
					
				}else if("S0010030".equals(SttsUtils.getSelectedComboValue(srhDateType))) {	// 월별
					
					lcSch1_2_1.hide();
					lcSch1_2_3.show();
					lcSch1_2_2.hide();
					
//					srhDayS.reset();
//					srhDayE.reset();
//					
//					srhYr02.reset();
//					srhMnthS.reset();
//					srhMnthE.reset();
					
				}else {
					
					lcSch1_2_3.hide();
					lcSch1_2_2.hide();
					lcSch1_2_1.show();
					
//					srhYr01.reset();
//					srhMnth.reset();
//					
//					srhYr02.reset();
//					srhMnthS.reset();
//					srhMnthE.reset();
					
				}
			}
	    });
	    lcSch1_1.add(srhDateType, new FormData("100%"));
		

/****** 기간 *******/	    
	    lcSch1_2 = new LayoutContainer();
		FormLayout frmlytSch1_2 = new FormLayout();
//		frmlytSch1_2.setLabelWidth(60);
//		frmlytSch1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_2.setLayout(frmlytSch1_2);
		
		// 기간별
		lcSch1_2_1 = new LayoutContainer(new ColumnLayout());
//		FormLayout fl1_2_1  = new FormLayout();
//		lcSch1_2_1.setLayout(fl1_2_1);
		
		LayoutContainer lcSch1_2_1_S = new LayoutContainer();
    	FormLayout fl2_1 = new FormLayout();
      	fl2_1.setLabelWidth(40);
      	fl2_1.setLabelAlign(LabelAlign.RIGHT);
      	lcSch1_2_1_S.setLayout(fl2_1);
             
     	srhDayS = new DateField();
     	srhDayS.setName("srhDayS");
        new DateFieldMask(srhDayS, "9999.99.99"); 
        srhDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayS.setFieldLabel("기간");
        lcSch1_2_1_S.add(srhDayS, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_1_E = new LayoutContainer();
        FormLayout fl2_2 = new FormLayout();
        fl2_2.setLabelWidth(5);
        fl2_2.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_1_E.setLayout(fl2_2);
        
            
        srhDayE = new DateField();
        srhDayE.setName("srhDayE");
        new DateFieldMask(srhDayE, "9999.99.99"); 
        srhDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayE.setLabelSeparator("~");
//        srhDayE.setReadOnly(true);
//        srhDayE.setEnabled(true);
        lcSch1_2_1_E.add(srhDayE, new FormData("100%"));
            
        lcSch1_2_1.add(lcSch1_2_1_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
        lcSch1_2_1.add(lcSch1_2_1_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
        
//        lcSch1_2_1.show();
        lcSch1_2.add(lcSch1_2_1);
        
        
        
		// 분기별
        lcSch1_2_2 = new LayoutContainer(new ColumnLayout());
//        FormLayout fl1_2_2  = new FormLayout();
//        lcSch1_2_2.setLayout(fl1_2_2);
		
		LayoutContainer lcSch1_2_2_Y = new LayoutContainer();
    	FormLayout fl1_2_2_Y  = new FormLayout();
    	fl1_2_2_Y.setLabelWidth(40);
    	fl1_2_2_Y.setLabelAlign(LabelAlign.RIGHT);
    	lcSch1_2_2_Y.setLayout(fl1_2_2_Y);
             
    	srhYr02 = new ComboBox<BaseModel>();
    	srhYr02.setName("srhYr02");
    	srhYr02.setForceSelection(true);
    	srhYr02.setMinChars(1);
    	srhYr02.setDisplayField("yearDisp");
    	srhYr02.setValueField("year");
    	srhYr02.setTriggerAction(TriggerAction.ALL);
    	srhYr02.setEmptyText("-- 년도선택 --");
    	srhYr02.setSelectOnFocus(true); 
    	srhYr02.setStore(lsYrStore);  
    	srhYr02.setFieldLabel("년도");
    	srhYr02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
//					srhYr02.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
				}
			}
    	});
		lcSch1_2_2_Y.add(srhYr02, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_2_M_S = new LayoutContainer();
        FormLayout fl1_2_2_M_S = new FormLayout();
        fl1_2_2_M_S.setLabelWidth(30);
        fl1_2_2_M_S.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_2_M_S.setLayout(fl1_2_2_M_S);
        
        srhMnthS = new ComboBox<BaseModel>();
        srhMnthS.setName("srhMnthS");
        srhMnthS.setForceSelection(true);
        srhMnthS.setMinChars(1);
        srhMnthS.setDisplayField("monthDisp");
        srhMnthS.setValueField("month");
        srhMnthS.setTriggerAction(TriggerAction.ALL);
        srhMnthS.setEmptyText("-- 년도선택 --");
        srhMnthS.setSelectOnFocus(true); 
        srhMnthS.setStore(lsMonthStore);  
        srhMnthS.setFieldLabel("월");
        srhMnthS.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
//					srhMnthS.setValue(lsMonthStore.findModel("month", DateTimeFormat.getFormat("MM").format(new Date()))); 	
				}
			}
    	});
        srhMnthS.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		// 시작월에 따라 마감월 변경
        		String strMon_S = SttsUtils.getSelectedComboValue(srhMnthS, "month");
        		
        		// 1분기 시작월, 마감월 고정
        		if ("01".equals(strMon_S) || "02".equals(strMon_S) || "03".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "01"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "03"));
        			
        			month.setValue("02");
        			
        		// 2분기 시작월, 마감월 고정	
        		} else  if ("04".equals(strMon_S) || "05".equals(strMon_S) || "06".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "04"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "06"));
        			
        			month.setValue("05");
        			
        		// 3분기 시작월, 마감월 고정		
        		}  else  if ("07".equals(strMon_S) || "08".equals(strMon_S) || "09".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "07"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "09"));
        			
        			month.setValue("08");
        			
        		// 4분기 시작월, 마감월 고정			
        		} else  if ("10".equals(strMon_S) || "11".equals(strMon_S) || "12".equals(strMon_S)) {
         			
         			srhMnthS.setValue(lsMonthStore.findModel("month", "10"));
         			srhMnthE.setValue(lsMonthStore.findModel("month", "12"));
         			
         			month.setValue("11");
         			
         		} 
        		
        	} 
        });
    	lcSch1_2_2_M_S.add(srhMnthS, new FormData("100%"));
    	
    	
      	LayoutContainer lcSch1_2_2_M_E = new LayoutContainer();
        FormLayout fl1_2_2_M_E = new FormLayout();
        fl1_2_2_M_E.setLabelWidth(5);
        fl1_2_2_M_E.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_2_M_E.setLayout(fl1_2_2_M_E);
        
        srhMnthE = new ComboBox<BaseModel>();
        srhMnthE.setName("srhMnthE");
        srhMnthE.setForceSelection(true);
        srhMnthE.setMinChars(1);
        srhMnthE.setDisplayField("monthDisp");
        srhMnthE.setValueField("month");
    	srhMnthE.setTriggerAction(TriggerAction.ALL);
//    	srhMnthE.setEmptyText("-- 년도선택 --");
    	srhMnthE.setSelectOnFocus(true); 
    	srhMnthE.setStore(lsMonthStore);  
    	srhMnthE.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		// 시작월에 따라 마감월 변경
        		String strMon_E = SttsUtils.getSelectedComboValue(srhMnthE, "month");
        		
        		// 1분기 시작월, 마감월 고정
        		if ("01".equals(strMon_E) || "02".equals(strMon_E) || "03".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "01"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "03"));
        			
        		// 2분기 시작월, 마감월 고정	
        		} else  if ("04".equals(strMon_E) || "05".equals(strMon_E) || "06".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "04"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "06"));
        			
        		// 3분기 시작월, 마감월 고정		
        		}  else  if ("07".equals(strMon_E) || "08".equals(strMon_E) || "09".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "07"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "09"));
        			
        		// 4분기 시작월, 마감월 고정			
        		} else  if ("10".equals(strMon_E) || "11".equals(strMon_E) || "12".equals(strMon_E)) {
         			
         			srhMnthS.setValue(lsMonthStore.findModel("month", "10"));
         			srhMnthE.setValue(lsMonthStore.findModel("month", "12"));
         			
         		} 
        		
        	} 
        });
    	srhMnthE.setLabelSeparator("~");
    	lcSch1_2_2_M_E.add(srhMnthE, new FormData("100%"));
            
        lcSch1_2_2.add(lcSch1_2_2_Y, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        lcSch1_2_2.add(lcSch1_2_2_M_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
        lcSch1_2_2.add(lcSch1_2_2_M_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
        
        lcSch1_2.add(lcSch1_2_2);
//        lcSch1_2_2.show();
//        lcSch1_2_2.hide();
        
        
        
		// 월별
        lcSch1_2_3 = new LayoutContainer(new ColumnLayout());
//        FormLayout fl1_2_3  = new FormLayout();
//        lcSch1_2_3.setLayout(fl1_2_3);
		
		LayoutContainer lcSch1_2_3_S = new LayoutContainer();
    	FormLayout fl1_2_3_S  = new FormLayout();
    	fl1_2_3_S.setLabelWidth(40);
    	fl1_2_3_S.setLabelAlign(LabelAlign.RIGHT);
      	lcSch1_2_3_S.setLayout(fl1_2_3_S);
             
    	srhYr01 = new ComboBox<BaseModel>();
    	srhYr01.setName("srhYr");
    	srhYr01.setForceSelection(true);
    	srhYr01.setMinChars(1);
    	srhYr01.setDisplayField("yearDisp");
    	srhYr01.setValueField("year");
    	srhYr01.setTriggerAction(TriggerAction.ALL);
    	srhYr01.setEmptyText("-- 년도선택 --");
    	srhYr01.setSelectOnFocus(true); 
    	srhYr01.setStore(lsYrStore);  
    	srhYr01.setFieldLabel("년도");
    	srhYr01.setAllowBlank(false);
    	srhYr01.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {    
        		EventType type = be.getType();
        		if (type == Store.Add) { 
//        			 srhYr01.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
        		}
        	}
        });
        lcSch1_2_3_S.add(srhYr01, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_3_E = new LayoutContainer();
        FormLayout fl1_2_3_E = new FormLayout();
        fl1_2_3_E.setLabelWidth(30);
        fl1_2_3_E.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_3_E.setLayout(fl1_2_3_E);
        
    	srhMnth = new ComboBox<BaseModel>();
    	srhMnth.setName("srhMnth");
    	srhMnth.setForceSelection(true);
    	srhMnth.setMinChars(1);
    	srhMnth.setDisplayField("monthDisp");
    	srhMnth.setValueField("month");
    	srhMnth.setTriggerAction(TriggerAction.ALL);
    	srhMnth.setEmptyText("-- 년도선택 --");
    	srhMnth.setSelectOnFocus(true); 
    	srhMnth.setAllowBlank(false);
    	srhMnth.setStore(lsMonthStore);  
    	srhMnth.setFieldLabel("월");
    	srhMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {    
        		EventType type = be.getType();
        		if (type == Store.Add) { 
//        			 srhMnth.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
        		}
        	}
        });
        lcSch1_2_3_E.add(srhMnth, new FormData("100%"));
            
        lcSch1_2_3.add(lcSch1_2_3_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        lcSch1_2_3.add(lcSch1_2_3_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
        lcSch1_2.add(lcSch1_2_3);
//        lcSch1_2_3.show();
//        lcSch1_2_3.hide();
         
/****** 기간 *******/	     	
    	
    	
        LayoutContainer lcSch1_3 = new LayoutContainer(new ColumnLayout());
        
        
        
//		FormLayout frmlytSch1_3 = new FormLayout();
//		frmlytSch1_3.setLabelWidth(60);
//		frmlytSch1_3.setLabelAlign(LabelAlign.RIGHT);
//		lcSch1_3.setLayout(frmlytSch1_3);
        
        LayoutContainer lcSch1_3_1 = new LayoutContainer();
        
		FormLayout formLayout = new FormLayout();
		formLayout.setLabelWidth(60);
		formLayout.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_3_1.setLayout(formLayout);
		
		
		srhEmymtDivCd =  new ComboBox<BaseModel>(); 
        srhEmymtDivCd.setName("srhEmymtDivCd");
        srhEmymtDivCd.setForceSelection(true);
        srhEmymtDivCd.setMinChars(1);
        srhEmymtDivCd.setDisplayField("commCdNm");
        srhEmymtDivCd.setValueField("commCd");
        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
        srhEmymtDivCd.setEmptyText("--고용구분선택--");
        srhEmymtDivCd.setSelectOnFocus(true); 
//        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());//TODO
//        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhEmymtDivCd.setStore(lsEmymtDivCd);
        srhEmymtDivCd.setFieldLabel("고용구분"); 
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
//                    if (gwtExtAuth.getEnableTypOccuCd()) {
//                    	srhTypOccuCd.setEnabled(true);
//                    	srhDtilOccuInttnCd.setEnabled(true); 
//                    } else {
//                    	srhTypOccuCd.setEnabled(false);
//                    	srhDtilOccuInttnCd.setEnabled(false);
//                    }
        		}  
        	} 
        });
        
        lcSch1_3_1.add(srhEmymtDivCd, new FormData("100%"));
//        lcSch1_3.add(srhEmymtDivCd, new FormData("100%"));
        
        
        LayoutContainer lcSch1_3_2 = new LayoutContainer();
        
		formLayout = new FormLayout();
		formLayout.setLabelWidth(40);
		formLayout.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_3_2.setLayout(formLayout);
		

		srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
	    srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
	    srhHdofcCodtnCd.setEmptyText("--재직선택--");
	    srhHdofcCodtnCd.setReadOnly(true);
	    srhHdofcCodtnCd.setEnabled(true); 
	    srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
	    srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
	    srhHdofcCodtnCd.setFieldLabel("재직");
	    srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
//	                 srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//	                 srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
			}
		}); 
	    srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
				}  
			} 
		});
        
		lcSch1_3_2.add(srhHdofcCodtnCd, new FormData("100%"));
		
		
        
		lcSch1_3.add(lcSch1_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		lcSch1_3.add(lcSch1_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		
		LayoutContainer lcSch1_4 = new LayoutContainer();
		FormLayout frmlytSch1_4_1 = new FormLayout();
		frmlytSch1_4_1.setLabelWidth(60);
		frmlytSch1_4_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_4.setLayout(frmlytSch1_4_1);
		
		srhDataType = new ComboBox<BaseModel>();
		srhDataType.setName("srhDateType");
		srhDataType.setForceSelection(true);
		srhDataType.setMinChars(1);
		srhDataType.setDisplayField("commCdNm");
		srhDataType.setValueField("commCd");
		srhDataType.setTriggerAction(TriggerAction.ALL);
		srhDataType.setEmptyText("--조회선택--");
		srhDataType.setSelectOnFocus(true); 
		srhDataType.setStore(lsDataType);  
		srhDataType.setFieldLabel("조회 구분"); 
		srhDataType.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// TODO Auto-generated method stub
				
				String strDateType = SttsUtils.getSelectedComboValue(srhDateType, "commCd");			// 기간구분
				String strDataType = SttsUtils.getSelectedComboValue(srhDataType, "commCd");			// 조회구분
				String strEmymtDivCd =  SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");		// 고용구분     
				
				String strYr01 = SttsUtils.getSelectedComboValue(srhYr01, "yearDisp");					// 월별 년  
				String strMnth = SttsUtils.getSelectedComboValue(srhMnth, "monthDisp");					// 월별 월    
				
				String strYr02 = SttsUtils.getSelectedComboValue(srhYr02, "yearDisp");					// 분기별 년  
				String strMnthS = SttsUtils.getSelectedComboValue(srhMnthS, "monthDisp");				// 분기별 시작월   
				String strMnthE = SttsUtils.getSelectedComboValue(srhMnthE, "monthDisp");				// 분기별 종료월 
				
				String strDayS = SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd");					// 기간별 시작일
				String strDayE = SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd");					// 기간별 종료일
				
				
				// --------------- 노동력 조사 S0020010 - 월별
				if("S0020010".equals(strDataType)) {
					
					
					if(!"S0010030".equals(strDateType)) {
						MessageBox.alert("경고", "기간 구분을 월별로 선택해주세요.", null);
	        			return;
					}
					
					
					if("S0010030".equals(strDateType)) {
						if("".equals(strYr01) || strYr01 == null) {
							MessageBox.alert("경고", "년도를 선택해 주세요.", null);
		        			return;
						}
						
						if("".equals(strMnth) || strMnth == null) {
							MessageBox.alert("경고", "월을 선택해 주세요.", null);
		        			return;
						}
						

					}
					
//					if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020020".equals(strEmymtDivCd)) {
//						MessageBox.alert("경고", "고용구분을 기간제 근로자로 선택해주세요.", null);
//	        			return;
//					}
				

				// ---------------  근로자현황(통계) S0020020 - 분기/월, 고용구분 기간제		
				}else if("S0020020".equals(strDataType)) {
					
					
					if(!"S0010020".equals(strDateType) && !"S0010030".equals(strDateType)) {
						MessageBox.alert("경고", "기간 구분을 월 or 분기별로 선택해주세요.", null);
	        			return;
					}
					
					if("S0010020".equals(strDateType)) {			// 분기별
						
						if("".equals(strYr02) || strYr02 == null) {
							MessageBox.alert("경고", "년도를 선택해 주세요.", null);
		        			return;
						}
						
						if("".equals(strMnthS) || strMnthS == null) {
							MessageBox.alert("경고", "시작월을 선택해 주세요.", null);
		        			return;	
						}
						
						if("".equals(strMnthE) || strMnthE == null) {
							MessageBox.alert("경고", "종료월을 선택해 주세요.", null);
		        			return;
						}
						
					}else if("S0010030".equals(strDateType)) {		// 월별
						
						if("".equals(strYr01) || strYr01 == null) {
							MessageBox.alert("경고", "년도를 선택해 주세요.", null);
		        			return;
						}
						
						if("".equals(strMnth) || strMnth == null) {
							MessageBox.alert("경고", "월을 선택해 주세요.", null);
		        			return;
						}
					}
					
					
					if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020020".equals(strEmymtDivCd)) {
						MessageBox.alert("경고", "고용구분을 기간제 근로자로 선택해주세요.", null);
	        			return;
					}
					
					
				// ---------------  근로자현황(상세) S0020030 - 기간별, 고용구분 기간제		
				}else if("S0020030".equals(strDataType)) {
					
					if(!"S0010010".equals(strDateType)) {
						MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
	        			return;
					}
					
					if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020020".equals(strEmymtDivCd)) {
						MessageBox.alert("경고", "고용구분을 기간제 근로자로 선택해주세요.", null);
	        			return;
					}
					
					if(GregorianCalendar.compareDate(srhDayS.getValue(), srhDayS.getValue()) < 0){
						MessageBox.alert("경고", "시작 기간이 이상합니다. 확인하십시요.", null);  
						return;
					} 
				
				// ---------------  근로자명부 S0020040 - 기간별, 고용구분 공무직	
				}else if("S0020040".equals(strDataType)) {
					
					// 근로자 명부는 무기계약 근로자만.. 고용구분을 무기계약근로자로 셋팅
//					SttsUtils.setSelectedComboValue(srhEmymtDivCd, "A0020010", "commCd");
					
					if(!"S0010010".equals(strDateType)) {
						MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
	        			return;
					}
					
					if(srhDayS.getValue() == null || "".equals(srhDayS.getValue())  ) {
						MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
	        			return;
					}
					
					if(GregorianCalendar.compareDate(srhDayS.getValue(), srhDayS.getValue()) < 0){
						MessageBox.alert("경고", "시작 기간이 이상합니다. 확인하십시요.", null);  
						return;
					} 	
					
					if("".equals(strEmymtDivCd) || strEmymtDivCd == null) {
						MessageBox.alert("경고", "고용구분을 선택해주세요.", null);
	        			return;
					}
					
					if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020010".equals(strEmymtDivCd)) {
						MessageBox.alert("경고", "고용구분을 공무직 근로자로 선택해주세요.", null);
	        			return;
					}
				
					
				// ---------------  근로자현황 S0020050 - 기간별, 고용구분 공무직		
				}else if("S0020050".equals(strDataType)) {
					
					if(!"S0010010".equals(strDateType)) {
						MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
	        			return;
					}
					
					if(GregorianCalendar.compareDate(srhDayS.getValue(), srhDayS.getValue()) < 0){
						MessageBox.alert("경고", "시작 기간이 이상합니다. 확인하십시요.", null);  
						return;
					} 
					
//					if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020010".equals(strEmymtDivCd)) {
//						MessageBox.alert("경고", "고용 구분을 공무직 근로자로 선택해주세요.", null);
//	        			return;
//					}
				}
			}
	    });
		lcSch1_4.add(srhDataType, new FormData("100%"));
		
        
        lcSch1.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));	// 기간구분
        lcSch1.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));	// 날짜
        lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 고용구분
//        lcSch1.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));	// 날짜
//        lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	// 고용구분
        lcSch1.add(lcSch1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));	// 조회구분
		
		
        
        LayoutContainer lcSch2 = new LayoutContainer();
		lcSch2.setLayout(new ColumnLayout());
		
		//부서 
		LayoutContainer lcSch2_1 = new LayoutContainer();
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(60);
		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_1.setLayout(frmlytSch2_1);
        srhDeptCd = new MSFMultiComboBox<ModelData>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setEmptyText("--부서선택--");
        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
        srhDeptCd.getStore().add(mDtalistDeptCd);
        srhDeptCd.setWidth(100);
        srhDeptCd.setFieldLabel("부서");
	    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	        public void handleEvent(StoreEvent<ModelData> be) {  
	        	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkStts0100Auth("srhDeptCd", lsDeptCd); 
	           	 	}
	        	}
	    	});    
	    srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	    	@Override
	    	public void handleEvent(ComponentEvent ce) { 
	    		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	    			if (srhDeptCd.getListView().getChecked().size() > 0) {  
	    				
	    				sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
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
          		   sysComBass0320Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
          		   String strDeptCd = SttsUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
          		   sysComBass0320Dto.setDeptCd(strDeptCd);
          		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
          		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
         	            public void handleEvent(StoreEvent<BaseModel> be) {  
         	             
                           mDtalistTypOccuCd = SttsUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                           srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                            
                         }
                     });  
      	    
	              } else {
	            	  
	            	   sysComBass0320Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	           		   String strDeptCd = SttsUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	           		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	         		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	        	            public void handleEvent(StoreEvent<BaseModel> be) {  
	        	             
	                          mDtalistTypOccuCd = SttsUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                }  
            } 
        }); 
        lcSch2_1.add(srhDeptCd, new FormData("100%"));

        
        
		LayoutContainer lcSch2_2 = new LayoutContainer();
		lcSch2_2.setLayout(new ColumnLayout());
		
		LayoutContainer lcSch2_2_1 = new LayoutContainer();
		FormLayout frmlytSch2_2_1 = new FormLayout();
		frmlytSch2_2_1.setLabelWidth(60);
		frmlytSch2_2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_2_1.setLayout(frmlytSch2_2_1);
		
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setFieldLabel("직종");
//        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
//        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			    		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						//checkYeta0300Auth("srhTypOccuCd", lsTypOccuCd); 
				}
			}
		});     
		    
		srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
		               
				if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
		                        
					//직종변경에 따른 직종세 값 가져오기
					List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked();  
		                        
					String strTypOccuCd = SttsUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
					sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
		                        
		        	if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
		                            
		        		lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
		        		//  srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
			        	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
			        		public void handleEvent(StoreEvent<BaseModel> be) {  
			        			mDtalistDtilOccuInttnCd = SttsUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
			        			srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
			        		}
			        	});     
		         	} 
				} else {
		                   
				} 
		                  
			}  
		});     

        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
        	@Override
        	public void handleEvent(ComponentEvent ce) { 
        		
        		//2015.11.30 추가 
//        		displayDtilOccuInttnCd();  
        	}  
        }); 
        
        srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {   
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                }  
            } 
        });
        //2015.11.30 추가 
        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent ce) {   
//            	displayDtilOccuInttnCd();
            } 
        }); 
        lcSch2_2_1.add(srhTypOccuCd, new FormData("100%"));
        lcSch2_2.add(lcSch2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		
		LayoutContainer lcSch2_2_2 = new LayoutContainer();
		FormLayout frmlytSch2_2_2 = new FormLayout();
		frmlytSch2_2_2.setHideLabels(true);
		frmlytSch2_2_2.setLabelAlign(LabelAlign.LEFT);
		lcSch2_2_2.setLayout(frmlytSch2_2_2);
		
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setHideLabel(true);
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
        srhDtilOccuInttnCd.setLabelSeparator("");
        srhDtilOccuInttnCd.setFieldLabel("");
//        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
//        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
        srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                } 
//                else {
//                }  
            } 
        });
        lcSch2_2_2.add(srhDtilOccuInttnCd, new FormData("100%"));
        lcSch2_2.add(lcSch2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		
		LayoutContainer lcSch2_3 = new LayoutContainer();
		FormLayout frmlytSch2_3 = new FormLayout();
		frmlytSch2_3.setLabelWidth(60);
		frmlytSch2_3.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_3.setLayout(frmlytSch2_3);
		
		srhBusinCd = new ComboBox<BaseModel>();
	    srhBusinCd.setName("srhBusinCd");
	    srhBusinCd.setForceSelection(true);
	    srhBusinCd.setMinChars(1);
	    srhBusinCd.setDisplayField("businNm");
	    srhBusinCd.setValueField("businCd");
	    srhBusinCd.setTriggerAction(TriggerAction.ALL);
	    srhBusinCd.setEmptyText("--사업선택--");
	    srhBusinCd.setSelectOnFocus(true); 
//	    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
	    srhBusinCd.setStore(lsBusinCd);
	    srhBusinCd.setFieldLabel("사업");
	    lcSch2_3.add(srhBusinCd, new FormData("100%"));
		
	    
	    lcSch2.add(lcSch2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//부서
        lcSch2.add(lcSch2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));	//직종, 직종세
        lcSch2.add(lcSch2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));	//사업
		

		lcSchCol.add(lcSch1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcSchCol.add(lcSch2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmStts0100.add(fieldSet);		
	} 
			  

	class Tracker {
		public boolean status = false;

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean stat) {
			status = stat;
		}
	}
		   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
		
		
	private void createMsfGridForm() {
		
		

		FieldSet fieldSetGrd = new FieldSet();
		fieldSetGrd.setHeadingHtml("");
		fieldSetGrd.setSize(975, 525);
//		fieldSetGrd.setSize(970, 490);
		
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    FormLayout frmlytStd = new FormLayout();  
	    lcStdGrid.setLayout(frmlytStd); 

		/** +++++++++++++++++++ 노동력조사 시작 +++++++++++++++++++ **/
//		cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(960, 480);
//		
//		if("".equals(param) || param == null) {
//			
//		}else {
//			cp01.setUrl(baseUrl+"?"+getURLParamAsString(param));
//		}
	    
		cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
//		cp01.setSize(960, 500);
		cp01.setSize(960, 515);
//		cp01.hide();
		
//		String url = MSFMainApp.getMsg("PayGen.RexServerUrl"); 
//		String baseUrl = GWT.getHostPageBaseURL() + url;
//		cp01.setUrl(baseUrl+"?"+getURLParamAsString(param));
		
		if("".equals(param) || param == null) {
		
		}
//		else {
//			cp01.setUrl(baseUrl+"?"+getURLParamAsString(param));
//			cp01.show();
//		}
		
		
//		printPanel();
		

		lcStdGrid.add(cp01);   
		fieldSetGrd.add(lcStdGrid); 
		/** +++++++++++++++++++ 노동력조사 종료 +++++++++++++++++++ **/
		
		
		
		plFrmStts0100.add(fieldSetGrd);
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
		
	// 폼초기화 검색조건포함
	private void formInit() {
		       
//		    edSETT_GBNM.Text := '';
//			lblSETT_GBCD01.Caption := '';
//			edEDAC_RVYY.Text := IntToStr(StrToInt(leftStr(DateToStr(Date),4)) - 1);
//			edKORN_NAME.Text := '';
//			lblPSNL_NUMB.Caption := '';
//
//			Payr06420_OnMenuInit;
//			_MethodAction := 'insert';
		       
	        //remtPayr0100GridPanel.getMsfGrid().clearData();  
		      
		   }
		

	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}


	private Stts0100 getThis() {
		return this;
	}
	
	
	private SelectionListener<ButtonEvent> Stts0100ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
	        /**  
			 	S0020010	S002	0010	노동력조사 				STTST0100
			 	S0020020	S002	0020	기간제근로자현황(통계) 	STTST0101
			 	S0020030	S002	0030	기간제근로자현황(상세)		STTST0102
			 	S0020040	S002	0040	근로자명부				STTST0103
			 	S0020050	S002	0050	근로자현황				STTST0104
	         **/
			
			String strDataType = SttsUtils.getSelectedComboValue(srhDataType, "commCd");
			String printType = "";
			
			
			// 검색조건 체크
//			searchCheck();
			
			if(searchCheck() < 1) {
				//Window.alert("검색조건이 이상!!!!");
				//return;
			}else {
				
				if("S0020010".equals(strDataType)){
					// 노동력조사
					printType = "STTST0100";
				}else if("S0020020".equals(strDataType)) {
					// 기간제근로자현황(통계) 
					printType = "STTST0101";
				}else if("S0020030".equals(strDataType)) {
					// 기간제근로자현황(상세)
					printType = "STTST0102";
				}else if("S0020040".equals(strDataType)) {
					// 근로자명부
					printType = "STTST0103";
				}else if("S0020050".equals(strDataType)) {
					// 근로자현황
					printType = "STTST0104";
				}else {
					MessageBox.alert("경고", "조회 구분을 선택해 주세요.", null);
	    			return;
				}
				
				Stts0100Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"), strDataType);
				
			}
			
			
		}
	};

	private void reloadStts0100() {
				 
//			   IColumnFilter filters = null;
//			   yeta2000GridPanel.getTableDef().setTableColumnFilters(filters);
//				 
//				//정산년
//			   yeta2000GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhClutYr,"year") , SimpleColumnFilter.OPERATOR_EQUALS); 
//			        
//				//정산구분
//			   yeta2000GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			          
//			   yeta2000GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
//			   yeta2000GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			
//			
//			   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//			   yeta2000GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
//	            
//	           String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//	           yeta2000GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//	             
//	         //    String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//	          //   remt2000DefGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
//	             
//	           String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//	           yeta2000GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//		       
//	           yeta2000GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
//				   
//	             
//	           yeta2000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//	           yeta2000GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
//	           yeta2000GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
//				
//	           yeta2000GridPanel.reload();  
			   
	}
	
	private void printPanel() {
//		cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(960, 480);
		
		String RDA_DIR_PATH_CHAR = MSFConfiguration.RDA_DIR_PATH_CHAR;          //파일경로 구분자
		
		param = new HashMap<String, String>();
		
		String rexServerPath =  MSFMainApp.getMsg("PayGen.RexServerPath");  
		String getRexBaseURL = MSFMainApp.getMsg("PayGen.RexReportService");
		   
//		PrintUtils.setPostCall(true);
		
		param = new HashMap<String, String>(); 
		param.put("svDirPath", rexServerPath + RDA_DIR_PATH_CHAR + strDirPath + RDA_DIR_PATH_CHAR );    //파일경로명
		param.put("svRexParam", strParam);  	//param
		param.put("rexFile", rexFileName); 		//파일명
		param.put("rexUrl", getRexBaseURL);  	//rex server
		param.put("pageUrl", GWT.getHostPageBaseURL());      //pageBase Url
		
		String url = MSFMainApp.getMsg("PayGen.RexServerUrl"); 
		String baseUrl = GWT.getHostPageBaseURL() + url;
		cp01.setUrl(baseUrl+"?"+getURLParamAsString(param));
		
		cp01.show();
		
//		return cp01;
	}

	
	
    public static String getURLParamAsString(HashMap<String, String> map) {
        String result = null;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> e = (Entry<String, String>) iter.next();
            String key = e.getKey();
            String val = e.getValue();
            if (MSFSharedUtils.paramNotNull(key) &&
                MSFSharedUtils.paramNotNull(val)) {
                if (result == null) {
                    result = e.getKey()+"="+e.getValue();
                } else {
                    result += "&"+e.getKey()+"="+e.getValue();
                }
            }
        }
        return result;
    }
    
    
	// 기간 셋팅
	private void setInitDate() {
		   
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		String strYr = DateTimeFormat.getFormat("yyyy").format(new Date());
		
		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set (Integer.parseInt(strYr), monthS -1, 1);
		srhDayS.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  
	       
	      
		Calendar  intieCal =   Calendar.getInstance();
	    intieCal.set (Integer.parseInt(strYr), monthE - 1, maxDays );
	    srhDayE.setValue(intieCal.getTime());
	    
	}
	
	// 조회구분 체크
//	private void searchCheck() {
	private int searchCheck() {
		
		int iResult = 1;
		
		String strDateType = SttsUtils.getSelectedComboValue(srhDateType, "commCd");		// 기간구분
		String strDataType = SttsUtils.getSelectedComboValue(srhDataType, "commCd");		// 조회구분
		String strEmymtDivCd =  SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");	// 고용구분     
		
		String strYr01 = SttsUtils.getSelectedComboValue(srhYr01, "yearDisp");				// 월별 년  
		String strMnth = SttsUtils.getSelectedComboValue(srhMnth, "monthDisp");				// 월별 월    
		
		String strYr02 = SttsUtils.getSelectedComboValue(srhYr02, "yearDisp");				// 분기별 년  
		String strMnthS = SttsUtils.getSelectedComboValue(srhMnthS, "monthDisp");			// 분기별 시작월   
		String strMnthE = SttsUtils.getSelectedComboValue(srhMnthE, "monthDisp");			// 분기별 종료월 
		
		String strDayS = SttsUtils.getConvertDateToString(srhDayS, "yyyyMMdd");				// 기간별 시작일
		String strDayE = SttsUtils.getConvertDateToString(srhDayE, "yyyyMMdd");				// 기간별 종료일
		
		
		// --------------- 노동력 조사 S0020010 - 월별
		if("S0020010".equals(strDataType)) {
			
			
			if(!"S0010030".equals(strDateType)) {
				MessageBox.alert("경고", "기간 구분을 월별로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			
			if("S0010030".equals(strDateType)) {
				if("".equals(strYr01) || strYr01 == null) {
					MessageBox.alert("경고", "년도를 선택해 주세요.", null);
//        			return;
					iResult = 0;
				}
				
				if("".equals(strMnth) || strMnth == null) {
					MessageBox.alert("경고", "월을 선택해 주세요.", null);
//        			return;
					iResult = 0;
				}
				

			}
			
//			if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020020".equals(strEmymtDivCd)) {
//				MessageBox.alert("경고", "고용구분을 기간제 근로자로 선택해주세요.", null);
//    			return;
//			}
		

		// ---------------  근로자현황(통계) S0020020 - 분기/월, 고용구분 기간제		
		}else if("S0020020".equals(strDataType)) {
			
			
			if(!"S0010020".equals(strDateType) && !"S0010030".equals(strDateType)) {
				MessageBox.alert("경고", "기간 구분을 월 or 분기별로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if("S0010020".equals(strDateType)) {			// 분기별
				
				if("".equals(strYr02) || strYr02 == null) {
					MessageBox.alert("경고", "년도를 선택해 주세요.", null);
//        			return;
					iResult = 0;
				}
				
				if("".equals(strMnthS) || strMnthS == null) {
					MessageBox.alert("경고", "시작월을 선택해 주세요.", null);
//        			return;	
					iResult = 0;
				}
				
				if("".equals(strMnthE) || strMnthE == null) {
					MessageBox.alert("경고", "종료월을 선택해 주세요.", null);
//        			return;
					iResult = 0;
				}
				
			}else if("S0010030".equals(strDateType)) {		// 월별
				
				if("".equals(strYr01) || strYr01 == null) {
					MessageBox.alert("경고", "년도를 선택해 주세요.", null);
//        			return;
					iResult = 0;
				}
				
				if("".equals(strMnth) || strMnth == null) {
					MessageBox.alert("경고", "월을 선택해 주세요.", null);
//        			return;
					iResult = 0;
				}
			}
			
			
			if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020020".equals(strEmymtDivCd)) {
				MessageBox.alert("경고", "고용구분을 기간제 근로자로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			
		// ---------------  근로자현황(상세) S0020030 - 기간별, 고용구분 기간제		
		}else if("S0020030".equals(strDataType)) {
			
			if(!"S0010010".equals(strDateType)) {
				MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020020".equals(strEmymtDivCd)) {
				MessageBox.alert("경고", "고용구분을 기간제 근로자로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if(GregorianCalendar.compareDate(srhDayS.getValue(), srhDayS.getValue()) < 0){
				MessageBox.alert("경고", "시작 기간이 이상합니다. 확인하십시요.", null);  
//				return;
				iResult = 0;
			} 
		
		// ---------------  근로자명부 S0020040 - 기간별, 고용구분 공무직	
		}else if("S0020040".equals(strDataType)) {
			
			// 근로자 명부는 무기계약 근로자만.. 고용구분을 무기계약근로자로 셋팅
//			SttsUtils.setSelectedComboValue(srhEmymtDivCd, "A0020010", "commCd");
			
			if(!"S0010010".equals(strDateType)) {
				MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if(srhDayS.getValue() == null || "".equals(srhDayS.getValue())  ) {
				MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if(GregorianCalendar.compareDate(srhDayS.getValue(), srhDayS.getValue()) < 0){
				MessageBox.alert("경고", "시작 기간이 이상합니다. 확인하십시요.", null);  
//				return;
				iResult = 0;
			} 	
			
			if("".equals(strEmymtDivCd) || strEmymtDivCd == null) {
				MessageBox.alert("경고", "고용구분을 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020010".equals(strEmymtDivCd)) {
				MessageBox.alert("경고", "고용구분을 공무직 근로자로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
		
			
		// ---------------  근로자현황 S0020050 - 기간별, 고용구분 공무직		
		}else if("S0020050".equals(strDataType)) {
			
			if(!"S0010010".equals(strDateType)) {
				MessageBox.alert("경고", "기간 구분을 기간별로 선택해주세요.", null);
//    			return;
				iResult = 0;
			}
			
			if(GregorianCalendar.compareDate(srhDayS.getValue(), srhDayS.getValue()) < 0){
				MessageBox.alert("경고", "시작 기간이 이상합니다. 확인하십시요.", null);  
//				return;
				iResult = 0;
			} 
			
//			if("".equals(strEmymtDivCd) || strEmymtDivCd == null || !"A0020010".equals(strEmymtDivCd)) {
//				MessageBox.alert("경고", "고용 구분을 공무직 근로자로 선택해주세요.", null);
//    			return;
//			}
		}
		
		return iResult;
	}
	

	
//	private void  displayDtilOccuInttnCd() {
//		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//            
//			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
////			sysComBass0350Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//			
//			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
//			String strDeptCd = SttsUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
//            sysComBass0350Dto.setDeptCd(strDeptCd);
//            
//            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
//            String strTypOccuCd = SttsUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
//            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
//                
//            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
//                
//            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
//            	
//            	//직종세 초기화
//            	srhDtilOccuInttnCd.getInitStore(); 
//            	srhDtilOccuInttnCd.setValue("");
//            	
//            	lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
//            	//  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//                    
//            	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
//            		public void handleEvent(StoreEvent<BaseModel> be) {  
//            			mDtalistDtilOccuInttnCd = SttsUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
//            			srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
//                            
////            			if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
//            				ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
//		  		                   
//		  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//		  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//		  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//		  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//		  		                      //         mdSelect = tpMdSelect;
//		  		                         //  } 
//		  		                     //  }  	 
//		  		                   
//            				srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
//            				srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
//		  		                   // }  
////            			} 
//            		}
//            	});     
//            } 
//		} else {
//           
//		} 
//        //직종변경에 따른 직종세 값 가져오기
////        String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
////        if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
////            sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
////            sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
////            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
////                lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
////                srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
////            }
////        }   
//	}
		   
 
	/** 엑셀 저장  **/
	private void excelFileExport() {
		
		String strDateType = SttsUtils.getSelectedComboValue(srhDateType, "commCd");								// 기간 구분
		
		String strYr01 = SttsUtils.getSelectedComboValue(srhYr01, "yearDisp");										// 월별_년			
		String strMnth = SttsUtils.getSelectedComboValue(srhMnth, "monthDisp");										// 월별_월
		
		String strEmymtDivCd = SttsUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");							// 고용 구분
		
		String  strDeptCd = SttsUtils.getStrValToBMMultiCombo(lsDeptCd
					, MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd"); 					// 부서
		
		String strBusinCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");								// 사업

		HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("pymtYrMnth", strYr01 + strMnth);
		param.put("emymtDivCd", strEmymtDivCd);
		param.put("deptCd", strDeptCd);
		param.put("businCd", strBusinCd);

		if(!"S0010030".equals(strDateType)){
			
			MessageBox.info("경고", "기간구분을 월별로 변경해주세요.", null);
			
		}else if(!MSFConfiguration.EMYMT_DIVCD02.equals(strEmymtDivCd)){ 
			
			MessageBox.info("경고", "고용구분을 기간제근로자로 변경해주세요.", null);
			
		}else {
			
			GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsStts0100Export.do","extgwtFrame" , JsUtil.toJavaScriptObject(param));  
			
		}
	
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
